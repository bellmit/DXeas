/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.feedbiz.client;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

import uk.co.mmscomputing.device.twain.TwainResultException.Cancel;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.service.job.wrapper.SqlExecutor;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.ctrl.kdf.table.IColumn;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.swing.KDDatePicker;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.base.permission.client.longtime.ILongTimeTask;
import com.kingdee.eas.base.permission.client.longtime.LongTimeDialog;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.UIUtil;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillInfo;
import com.kingdee.eas.farm.stocking.basedata.BreedDataFactory;
import com.kingdee.eas.farm.stocking.basedata.BreedDataInfo;
import com.kingdee.eas.farm.stocking.basedata.IBreedData;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class FodderProductionPlanUI extends AbstractFodderProductionPlanUI
{
	private static final Logger logger = CoreUIObject.getLogger(FodderProductionPlanUI.class);
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat sdfMi = new SimpleDateFormat("hh24mmsss");
	private ArrayList<PlanBean> planBeans=null;
	private String tableName="CT_FM_FodderProductionPlan";
	private IMaterial iMaterial;
	private IBreedData iBreedData;
	private String sessionID;
	private BigDecimal rate308=BigDecimal.ZERO;
	private BigDecimal rate817=BigDecimal.ZERO;
	/**
	 * output class constructor
	 */
	public FodderProductionPlanUI() throws Exception
	{
		super();
	}

	public void onLoad() throws Exception {
		super.onLoad();
		txtDayRange.setValue(45);
	}



	/*
	 * 将计算数据存入临时表,并从表中取数.临时表表名:CT_FM_FodderProductionPlan.
	 * 临时表包含计算数据、创建日期及特殊标记字段.
	 * ----每次查询产生唯一标记值sessionID,同计算数据一起存入临时表,并在完成取数后清空包含之前操作所生成标记值的数据清空.
	 * ----每次查询前清除今天之前所有数据,防止之前有关故障等原因产生大量冗余数据无法清除.
	 */
	public void storeFields(){
		super.storeFields();
	}


	private void verifyInput() {
		if(pkBeginDate.getValue()==null){
			MsgBox.showWarning("开始日期不能为空!");
			SysUtil.abort();
		}
		if(pkEndDate.getValue()==null){
			MsgBox.showWarning("结束日期不能为空!");
			SysUtil.abort();
		}
		if(txtDayRange.getIntegerValue()==null||txtDayRange.getIntegerValue()<1||txtDayRange.getIntegerValue()>100){
			MsgBox.showWarning("饲养周期必须大于1且小于100天!");
			SysUtil.abort();
		}

		Date beginDate;
		try {
			beginDate = sdf.parse(sdf.format((Date) pkBeginDate.getValue()));
			Date endDate = sdf.parse(sdf.format((Date) pkEndDate.getValue()));
			if(beginDate.after(endDate)){
				MsgBox.showWarning("开始日期不能晚于结束日期!");
				SysUtil.abort();
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void btnQuery_actionPerformed(ActionEvent e) throws Exception {
		verifyInput();
		LongTimeDialog dialog = new LongTimeDialog((Frame)SwingUtilities.getWindowAncestor(this)); //进度栏
		dialog.setLongTimeTask(new ILongTimeTask(){		
			public void afterExec(Object obj) throws Exception {}
			public Object exec() throws Exception {
				Object obj = "success";  
				Date beginDate = sdf.parse(sdf.format((Date) pkBeginDate.getValue()));
				Date endDate = sdf.parse(sdf.format((Date) pkEndDate.getValue()));
				int dayRange = txtDayRange.getIntegerValue();
				//查询临时表是否创建,没有则创建一下.
				createTempTable();
				//产生本次操作唯一ID
				sessionID=UUID.randomUUID().toString().replaceAll("-","");
				//清除冗余数据
				deleteRedundantData();
				//初始化表格		
				initEntry();

				rate308 = UIRuleUtil.getBigDecimal(txt308Rate.getBigDecimalValue()).multiply(new BigDecimal(0.01));
				rate817 = UIRuleUtil.getBigDecimal(txt817Rate.getBigDecimalValue()).multiply(new BigDecimal(0.01));

				Calendar cal=Calendar.getInstance();
				cal.setTime(beginDate);
				int diffDay=(int) ((endDate.getTime()-beginDate.getTime())/(1000*3600*24));
				for(int i=0;i<=diffDay;i++){
					cal.add(Calendar.DATE, i);
					Date bizDate=cal.getTime();
					Calendar cal2=Calendar.getInstance();
					cal2.setTime(bizDate);
					for(int j=0;j<dayRange;j++){
						cal2.add(Calendar.DATE, -j);
						Date calDate=cal2.getTime();
						setStockQty(bizDate, j+1, calDate);
						cal2.add(Calendar.DATE, j);
					}
					cal.add(Calendar.DATE, -i);
				}	
				//填充数据
				constructEntry();
				//清除本次操作产生数据
				deleteCurData();
				MsgBox.showInfo("计算成功");		
				return obj;
			}
		});
		Component[] cps=dialog.getContentPane().getComponents();  
		for(Component cp:cps){  
			if(cp instanceof JLabel){  
				((JLabel) cp).setText("正在计算中,可能耗时较长,请耐心等候......");  
			}  
		}  
		dialog.show();  
	}		


	private void setStockQty(Date bizDate,int weekDay,Date calDate) {
		try {
			iMaterial=MaterialFactory.getRemoteInstance();
			iBreedData=BreedDataFactory.getRemoteInstance();
			Map<String, BigDecimal> breedDataStock=new HashMap<String, BigDecimal>();
			Date today=sdf.parse(sdf.format(new Date()));
			if(calDate.before(today)){
				//某日龄实际留存数
				StringBuffer sqlBuf = new StringBuffer();
				sqlBuf.append(" /*dialect*/select ")
				.append(" t1.FBreedDataID breedDataID, ")
				.append(" sum(t2.FAllReceiveQty) qty ")
				.append(" from T_FM_BreedSeedReceiveBill t1 ")
				.append(" inner join T_FM_BreedSeedReceiveBillEntry t2 on t1.fid=t2.fparentid ")
				.append(" where t1.FBillStatus in (4,7) ")
				.append(" and to_char(t1.FBizDate,'yyyy-mm-dd')='"+sdf.format(calDate)+"' ")
				.append(" and t1.FBatchContractID not in (select distinct CFBatchContractID from CT_FM_PreHouseWgtBill where CFBillStatus =4 )")
				.append(" group by  t1.FBreedDataID ");
				IRowSet rs = SQLExecutorFactory.getRemoteInstance(sqlBuf.toString()).executeSQL();
				while(rs.next()){	
					//817成活率
					if(rs.getString("breedDataID").equals("lwwAAAAu66GnpxMN")){
						breedDataStock.put(rs.getString("breedDataID"), rs.getBigDecimal("qty").multiply(rate817));
					}else if(rs.getString("breedDataID").equals("lwwAAAAu65ynpxMN")){//308成活率
						breedDataStock.put(rs.getString("breedDataID"), rs.getBigDecimal("qty").multiply(rate308));
					}
				}
			}else{
				breedDataStock=StockingComm.getPlanStock(null, calDate,rate308,rate817);
			}

			Iterator iterator = breedDataStock.entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry<String, BigDecimal> entry = (Entry<String, BigDecimal>) iterator.next();
				String breedDataID = entry.getKey();
				BigDecimal qty = entry.getValue();
				Map fodderStd = StockingComm.getFodderStd(null, weekDay, breedDataID);
				Iterator fooderIterator = fodderStd.entrySet().iterator();
				while(fooderIterator.hasNext()){
					Map.Entry<String, BigDecimal> fooderEntry=(Entry<String, BigDecimal>) fooderIterator.next();
					String fodderID = fooderEntry.getKey();
					BigDecimal singleUsed = fooderEntry.getValue();
					BigDecimal dateUsed=qty.multiply(singleUsed);
					StringBuffer sqlBuf = new StringBuffer();
					sqlBuf.append(" /*dialect*/insert into "+tableName)
					.append(" VALUES ('"+sessionID+"',")
					.append("to_date('"+sdf.format(bizDate)+"','yyyy-mm-dd'),")
					.append("to_date('"+sdf.format(calDate)+"','yyyy-mm-dd'),")
					.append("'"+breedDataID+"',")
					.append("'"+fodderID+"',")
					.append(weekDay+",")
					.append(qty+",")
					.append(dateUsed+",")
					.append("to_date('"+sdf.format(new Date())+"','yyyy-mm-dd')) ");
					CommFacadeFactory.getRemoteInstance().excuteUpdateSql(sqlBuf.toString());
				}
			}	
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//获取饲料计划并构筑表格
	private void constructEntry() {
		try {
			StringBuffer sqlBuf = new StringBuffer();
			sqlBuf.append(" /*dialect*/select  ")
			.append(" bizDate bizDate, ")
			.append(" materialID materialID, ")
			.append(" sum(nvl(fodderWgt,0)) qty from "+tableName+"  ")
			.append(" where sessionID='"+sessionID+"'")
			.append(" group by bizDate,materialID ")
			.append(" order by bizDate,materialID asc");
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sqlBuf.toString()).executeSQL();
			while(rs.next()){		
				IRow row = kdtEntrys.addRow();
				row.getCell("bizDate").setValue(rs.getDate("bizDate"));
				String materialId=rs.getString("materialID");
				MaterialInfo material=iMaterial.getMaterialInfo(new ObjectUuidPK(materialId));
				row.getCell("material").setValue(material);
				row.getCell("qty").setValue(rs.getBigDecimal("qty"));			
			}

			sqlBuf = new StringBuffer();
			sqlBuf.append(" /*dialect*/select  ")
			.append(" bizDate bizDate, ")
			.append(" inDate inDate, ")
			.append(" breedDataID breedDataID, ")
			.append(" weekDay weekDay, ")
			.append(" sum(nvl(stockQty,0)) qty from "+tableName+"  ")
			.append(" where sessionID='"+sessionID+"'")
			.append(" group by bizDate,inDate,breedDataID,weekDay ")
			.append(" order by bizDate,inDate,breedDataID,weekDay asc");
			rs = SQLExecutorFactory.getRemoteInstance(sqlBuf.toString()).executeSQL();
			while(rs.next()){		
				IRow row = kdtDetailEntrys.addRow();
				row.getCell("bizDate").setValue(rs.getDate("bizDate"));
				row.getCell("inDate").setValue(rs.getDate("inDate"));
				String breedDataID=rs.getString("breedDataID");
				BreedDataInfo breedData=iBreedData.getBreedDataInfo(new ObjectUuidPK(breedDataID));
				row.getCell("breedData").setValue(breedData);
				row.getCell("weekDay").setValue(rs.getBigDecimal("weekDay"));			
				row.getCell("qty").setValue(rs.getBigDecimal("qty"));			
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UIUtil.apendFootRow(kdtEntrys, new String[]{"qty"});
		UIUtil.apendFootRow(kdtDetailEntrys, new String[]{"qty"});
	}

	//创建临时表
	private void createTempTable() {
		try {
			StringBuffer sqlBuf = new StringBuffer();
			sqlBuf.append("select * from USER_TABLES where table_name ='"+tableName.toUpperCase()+"'");
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sqlBuf.toString()).executeSQL();
			if(rs.size()>0){
				return;
			}		
			sqlBuf = new StringBuffer();
			sqlBuf.append("  /*dialect*/ Create  Table "+tableName+"   ")
			.append("   ( ")
			.append("    sessionID VARCHAR2(44), ")
			.append("    bizDate DATE, ")
			.append("    inDate DATE, ")
			.append("    breedDataID VARCHAR2(44), ")
			.append("    materialID VARCHAR2(44), ")
			.append("    weekDay NUMBER(22), ")
			.append("    stockQty NUMBER(22), ")
			.append("    fodderWgt NUMBER(22), ")
			.append("    createDate DATE ")
			.append("   )  ");
			CommFacadeFactory.getRemoteInstance().excuteUpdateSql(sqlBuf.toString());
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//清除冗余数据 (昨日(不含昨日)之前数据)
	private void deleteRedundantData() {
		try {
			Calendar cal=Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(Calendar.DATE, -2);
			StringBuffer sqlBuf = new StringBuffer();
			sqlBuf.append("  delete  from  "+tableName+"  where to_char(createDate,'yyyy-mm-dd')<'"+sdf.format(cal.getTime())+"'");
			CommFacadeFactory.getRemoteInstance().excuteUpdateSql(sqlBuf.toString());
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void deleteCurData() {
		try {
			StringBuffer sqlBuf = new StringBuffer();
			sqlBuf.append("  delete  from  "+tableName+"  where sessionID='"+sessionID+"' ");
			CommFacadeFactory.getRemoteInstance().excuteUpdateSql(sqlBuf.toString());
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//删除临时表(已废弃)
	private void dropTempTable() {
		// TODO Auto-generated method stub
		try {
			StringBuffer sqlBuf = new StringBuffer();
			sqlBuf.append("  TRUNCATE TABLE  "+tableName+"   ");
			CommFacadeFactory.getRemoteInstance().excuteUpdateSql(sqlBuf.toString());

			sqlBuf = new StringBuffer();
			sqlBuf.append("  Drop  Table "+tableName+"   ");
			CommFacadeFactory.getRemoteInstance().excuteUpdateSql(sqlBuf.toString());
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void initEntry() {
		/*饲料生产量表*/
		kdtEntrys.removeRows(true);
		kdtEntrys.removeHeadRows();
		kdtEntrys.removeColumns();
		kdtEntrys.setEnabled(false);
		kdtEntrys.getStyleAttributes().setLocked(true);
		IRow headRow = kdtEntrys.addHeadRow();
		//日期
		IColumn col = kdtEntrys.addColumn();
		col.setKey("bizDate");
		headRow.getCell("bizDate").setValue("日期");
		//饲料
		col = kdtEntrys.addColumn();
		col.setKey("material");
		headRow.getCell("material").setValue("饲料名称");
		//耗用量
		col = kdtEntrys.addColumn();
		col.setKey("qty");
		headRow.getCell("qty").setValue("耗用量");

		/*存栏量表*/
		kdtDetailEntrys.removeRows(true);
		kdtDetailEntrys.removeHeadRows();
		kdtDetailEntrys.removeColumns();
		kdtDetailEntrys.setEnabled(false);
		kdtDetailEntrys.getStyleAttributes().setLocked(true);
		headRow = kdtDetailEntrys.addHeadRow();
		//计划生产日期
		col = kdtDetailEntrys.addColumn();
		col.setKey("bizDate");
		headRow.getCell("bizDate").setValue("日期");
		//上苗日期
		col = kdtDetailEntrys.addColumn();
		col.setKey("inDate");
		headRow.getCell("inDate").setValue("上苗日期");
		//品种
		col = kdtDetailEntrys.addColumn();
		col.setKey("breedData");
		headRow.getCell("breedData").setValue("养殖品种");
		//饲养天数
		col = kdtDetailEntrys.addColumn();
		col.setKey("weekDay");
		headRow.getCell("weekDay").setValue("饲养天数");
		//存栏量
		col = kdtDetailEntrys.addColumn();
		col.setKey("qty");
		headRow.getCell("qty").setValue("存栏量");
	}
}



class PlanBean{
	private Date bizDate;
	private BreedDataInfo breedData;
	private String material;
	private BigDecimal qty;
	public Date getBizDate() {
		return bizDate;
	}
	public void setBizDate(Date bizDate) {
		this.bizDate = bizDate;
	}
	public BreedDataInfo getBreedData() {
		return breedData;
	}
	public void setBreedData(BreedDataInfo breedData) {
		this.breedData = breedData;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public BigDecimal getQty() {
		return qty;
	}
	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}

}