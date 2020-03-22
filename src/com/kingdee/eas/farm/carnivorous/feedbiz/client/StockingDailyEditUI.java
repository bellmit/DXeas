/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.feedbiz.client;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.assistant.IMeasureUnit;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.farm.carnivorous.basedata.BatchCollection;
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BatchInfo;
import com.kingdee.eas.farm.carnivorous.basedata.IBatch;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.framework.AbstractCoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.ObjectValueUtil;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class StockingDailyEditUI extends AbstractStockingDailyEditUI
{

	private static final Logger logger = CoreUIObject.getLogger(StockingDailyEditUI.class);
	private boolean isLoadField = false;
	private String curStorageOrgUnitID;
	private String curCompanyID;
	private OrgUnitInfo orgInfo=null;
	private F7ContextManager f7Manager;
	public StockingDailyEditUI() throws Exception {
		super();
		// TODO Auto-generated constructor stub
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());//调用当前对象的构造方法
	}
	protected com.kingdee.bos.dao.IObjectValue createNewData()//创建新的数据对象，并设置初始值，相当于把数据加载到新创建的Info中
	{
		StockingDailyInfo objectValue = new StockingDailyInfo();
		//设置创建者初值
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		//获取当前财务组织
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date bizDate=sdf.parse(sdf.format(new Date()));
			//业务时间设置
			objectValue.setBizDate(bizDate);
			//			objectValue.setStorageOrgUnit(StorageOrgUnitFactory.getRemoteInstance().getStorageOrgUnitInfo(new ObjectUuidPK(curStorageOrgUnitID)));
			//获取没有填写今天养殖日报的养殖户
			ArrayList<String> batchIDList = getNoExistBatchIDDailyToday();
			IBatch ibs = BatchFactory.getRemoteInstance();
			BatchInfo bInfo;
			//下面这句是用来使养殖户可以显示更多的信息
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add(new SelectorItemInfo("*"));
			slor.add(new SelectorItemInfo("farmer.*"));
			slor.add(new SelectorItemInfo("farm.*"));
			for(String batchID:batchIDList) {
				bInfo=ibs.getBatchInfo(new ObjectUuidPK(batchID),slor);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return objectValue;
	}
	//得到今天没有填写养殖日报的养殖户
	private ArrayList<String> getNoExistBatchIDDailyToday() {
		// TODO Auto-generated method stub
		ArrayList<String> list=new ArrayList<String>();
		try {
			//如果职员为空，则返回
			if(SysContext.getSysContext().getCurrentUserInfo().getPerson()==null) {
				return list;
			}

			//剔除掉已经有填写的用户
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date bizdate=(Date) pkBizDate.getValue();
			StringBuffer sql=new StringBuffer();
			sql.append(" /*dialect*/select tbatch.fid from t_fm_stockingBatch tbatch")
			.append(" where tbatch.fbaseStatus=").append(FarmBaseStatusEnum.ENABLE_VALUE)//已核准
			.append(" and tbatch.FCompanyID='").append(curCompanyID).append("'")
			.append(" and (tbatch.ffarmerid,tbatch.ffarmid) in (")
			.append(" select t2.FFarmerID,tfarm.ffarmid  from T_FM_PersonFarmerRelation t1  ")
			.append(" inner join  T_FM_PersonFarmerRelationEntry t2 on t2.fparentid=t1.fid ")
			.append(" inner join T_FM_FarmersFarmEntry tfarm on tfarm.fparentid=t2.ffarmerid ")
			.append(" where t1.FPersonID='").append(SysContext.getSysContext().getCurrentUserInfo().getPerson().getId()).append("'")
			.append(" and t1.FCompanyID='").append(curCompanyID).append("'")
			.append(" and (tbatch.fisAllOut=0 or tbatch.fisAllOut is null)")//未出栏

			.append(" ) and (tbatch.ffarmerid,tbatch.ffarmid) not in (")
			.append("  select ffarmerid,cffarmid  ")
			.append("  from T_FM_StockingBreedDaily")
			.append("  where FCompanyID='").append(curCompanyID).append("'")
			.append("  and FBizDate>=to_date('").append(sdf.format(bizdate)).append(" 00:00:00','yyyy-MM-dd HH24:mi:ss')")
			.append("  and FBizDate<=to_date('").append(sdf.format(bizdate)).append(" 23:59:59','yyyy-MM-dd HH24:mi:ss')");
			//			if(editData!=null&&editData.getId()!=null) {
			//				//					 sql.append("  and fid!='").append(editData.getId()).append("'");
			//			}
			sql.append(" )")
			.append(" order by tbatch.fnumber");
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			while(rs.next()) {
				list.add(rs.getString("fid"));
			}

		}catch(Exception err) {
			err.printStackTrace();
		}
		return list;
	}
	@Override
	//获取当前财务组织，用户，库存组织
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		//当前库存组织ID
		curStorageOrgUnitID=ClientUtils.getCurrentStorageUnit().getString("id");
		//当前财务组织ID
		curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
		super.onLoad();
		//把当前库存组织的ID存放到库存组织中
		orgInfo = StorageOrgUnitFactory.getRemoteInstance().getOrgUnitInfo(new ObjectUuidPK(curStorageOrgUnitID));
		//f7管理
		f7Manager = new F7ContextManager(this, OrgType.Storage);
		initControl();

		kdtAssEntrys.addKDTEditListener(new KDTEditAdapter(){

			@Override
			public void editStopped(KDTEditEvent e) {
				// TODO Auto-generated method stub
				if(isLoadField)
				{
					return;
				}
				Integer oldValue = UIRuleUtil.getInt(e.getOldValue());
				Integer newValue = UIRuleUtil.getInt(e.getValue());
				if(kdtAssEntrys.getColumnKey(e.getColIndex()).equals("deathQty")||kdtAssEntrys.getColumnKey(e.getColIndex()).equals("cullQty")||kdtAssEntrys.getColumnKey(e.getColIndex()).equals("markedQty")){
					kdtAssEntrys.getCell(e.getRowIndex(), "breekingStock").setValue(UIRuleUtil.getInt(kdtAssEntrys.getCell(e.getRowIndex(), "breekingStock").getValue())-(newValue-oldValue));
				}else if(kdtAssEntrys.getColumnKey(e.getColIndex()).equals("adjustQty")){
					kdtAssEntrys.getCell(e.getRowIndex(), "breekingStock").setValue(UIRuleUtil.getInt(kdtAssEntrys.getCell(e.getRowIndex(), "breekingStock").getValue())+(newValue-oldValue));
				}
				super.editStopped(e);



			}


		});

	}
	//设置审核，反审核图标，设置过滤条件，检查是否具有初始化权限
	private void initControl() {
		// TODO Auto-generated method stub
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));//菜单栏审核图标
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));//菜单栏反审核图标
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));//工具栏审核图标
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));//工具栏反审核图标
		prmtfarm.setEnabled(true);
		chkisInit.setVisible(false);
		//业务日期
		this.pkBizDate.setDatePattern("yyyy-MM-dd");
		CompanyF7 cf7=new CompanyF7();
		cf7.setIsCUFilter(true);
		this.prmtcompany.setSelector(cf7);
		//饲喂信息分录重新解析
		kdtEntrys.checkParsed();
		//免疫信息分录重新解析
		kdtImmuneEntrys.checkParsed();
		//带出饲喂分录中的饲料F7，利用库存组织
		f7Manager.registerBizMaterialF7( (KDBizPromptBox) this.kdtEntrys.getColumn("material").getEditor().getComponent(), null, null, orgInfo,false);
		f7Manager.registerMeasureUnitF7(kdtEntrys, "material", "unit");

		//带出免疫信息中的疫苗分录F7，利用库存组织
		f7Manager.registerBizMaterialF7( (KDBizPromptBox) this.kdtImmuneEntrys.getColumn("vaccineMaterial").getEditor().getComponent(), null, null, orgInfo,false);
		//		f7Manager.registerMeasureUnitF7(kdtImmuneEntrys, "material", "vaccineUnit");
		//设置单包重，包数格式
		this.kdtEntrys.getColumn("unitQty").getStyleAttributes().setNumberFormat("#.00");
		this.kdtEntrys.getColumn("bagQty").getStyleAttributes().setNumberFormat("#.00");
		//设置过滤条件，财务组织
		this.prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setFilter();
			}});

		this.prmtfarmer.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				if(!isLoadField) {
					//根据养殖户获得养殖场
					StockingComm.setFarmInfoByFarmer(prmtfarmer, prmtfarm);
					//设置批次的过滤条件
					StockingComm.setBatchFilter(prmtbatch, curCompanyID, ((IPropertyContainer)prmtfarmer.getValue()).getString("id"), ((IPropertyContainer)prmtfarm.getValue()).getString("id"));
				}
				setFilter();
			}});
		//养殖场
		this.prmtfarm.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				farm_changed(e);
				setBatchFilter();

			}});

		//批次
		this.prmtbatch.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				batch_changed();
			}});
		//业务日期
		this.pkBizDate.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
			}});

		farm_changed(null);
		setFilter();

	}

	protected void batch_changed() {
		// TODO Auto-generated method stub
		if(isLoadField) {
			return;
		}
		isLoadField=true;

		if(prmtbatch.getValue()!=null) {
			try {
				SelectorItemCollection slor=new SelectorItemCollection();
				slor.add("*");
				slor.add("farmer.*");
				slor.add("farm.*");
				//通过批次来改变养殖户和养殖场,相当于知道批次中的养殖场，养殖户，把这个值赋给界面上的养殖场养殖户
				BatchInfo batchInfo=BatchFactory.getRemoteInstance().getBatchInfo(new ObjectUuidPK(((AbstractCoreBaseInfo) prmtbatch.getValue()).getId()),slor);
				isLoadField=true;
				this.prmtfarmer.setValue(batchInfo.getFarmer());
				this.prmtfarm.setValue(batchInfo.getFarm());
				isLoadField=false;

				Date batchDate = batchInfo.getInDate();
				if(this.pkBizDate.getValue()==null) {
					return;
				}
				Date bizDate=((Date) this.pkBizDate.getValue());
				//调用StockingComm类的getBreedWeekAndDay()方法得到周龄，日龄
				int[] result = StockingComm.getBreedWeekAndDay(bizDate, batchDate);
				int week=result[0];
				int weekDay=result[1];

				this.txtweek.setValue(week);
				this.txtweekDay.setValue(weekDay);
				//设置纯日龄
				setPurDayAge();

				//饲料标准
				getBreedFodderStandard(curCompanyID, batchInfo.getBreedData().getString("id"), week, weekDay);
				//免疫标准
				getBreedDrugStandard(curCompanyID, batchInfo.getBreedData().getString("id"), week, weekDay);
				//养殖分录
				getBreedEntry(curCompanyID, batchInfo.getBreedData().getString("id"), week, weekDay);
			}catch(Exception err) {
				err.printStackTrace();
			}
		}
		else {

		}

		isLoadField=false;
	}

	private void getBreedEntry(String curCompanyID2, String string, int week,
			int weekDay) {
		// TODO Auto-generated method stub
		try {
			if(prmtbatch.getValue()==null){
				return;
			}

			if(this.kdtAssEntrys.getRowCount()>0) {
				this.kdtAssEntrys.removeRows();
			}
			//得到业务日期
			Date bizDate = UIRuleUtil.getDateValue(pkBizDate.getValue());
			//将业务日期转换格式
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//写SQL语句获取存栏量
			StringBuffer sb = new StringBuffer();
			sb.append("/*dialect*/select").append("\n")
			.append("t3.FTotalQty-nvl(sum(CFDeathQty),0)-nvl(sum(CFCullQty),0)-nvl(sum(FMarkedQty),0)+nvl(sum(FAdjustQty),0) breekingStock").append("\n")
			.append("from") .append("\n")
			.append("T_FM_Batch                              t3").append("\n")
			.append("left join T_FM_StockingDaily            t4 on t3.FID=t4.FBatchID").append("\n") 

			.append("and t4.FBizDate<{d '").append(sdf.format(bizDate)).append("'} and t4.CFBaseStatus=4").append("\n")
			.append("left join T_FM_StockingDailyAssEntry   t2 on t4.FID=t2.FParentID").append("\n")
			.append("where t3.FID='").append(((IPropertyContainer)prmtbatch.getValue()).getString("id")).append("'").append("\n")
			.append("group by t3.FTotalQty");
			//执行SQL语句，并将结果存放在IRowset结果集中。
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			//新增加一行
			IRow row;
			//循环
			while(rs.next()){
				row=kdtAssEntrys.addRow();
				row.getCell("deathQty").setValue(0);
				row.getCell("cullQty").setValue(0);
				row.getCell("adjustQty").setValue(0);
				row.getCell("markedQty").setValue(0);

				row.getCell("breekingStock").setValue(rs.getString("breekingStock"));
			}




		}catch(Exception err) {
			err.printStackTrace();
		}

	}
    //免疫信息
	private void getBreedDrugStandard(String curCompanyID, String string,
			int week, int weekDay) {
		// TODO Auto-generated method stub
		if(this.kdtImmuneEntrys.getRowCount()>0) {
			this.kdtImmuneEntrys.removeRows();
		}
		int dayAge=(week-1)*7+weekDay-1;
		StringBuffer sql=new StringBuffer();
		sql.append(" select tentry.FMaterialID,tentry.FUnitID,tentry.FQty")
		.append(" from T_FM_BreedStandard tmain ")
		.append(" inner join T_FM_BreedStandardDrugEntry tentry on tentry.fparentid=tmain.fid")
		.append(" where tmain.FCompanyID='").append(curCompanyID).append("'")
		.append(" and FBreedDataID='").append(curCompanyID).append("'")
		.append(" and FBaseStatus=3")//启用状态
		.append(" and (")
		//起始周日均大于当前
		.append(" (FWeek<=").append(week).append(" and FDays<=").append(weekDay).append(" ")
		//结束同周，日大于当前日
		.append(" and ((FEndWeek=").append(week).append(" and FEndDays>=").append(weekDay).append(" )")
		//周大于当前周
		.append(" or FEndWeek>").append(week).append(" ))")
		//0周 进行日龄判断
		.append(" or (FWeek=0 and FDays<=").append(dayAge).append(" and FEndWeek=0 and FEndDays>=").append(dayAge).append(")")
		.append(" )")
		.append(" order by tentry.FSeq")
		.append(" ");
		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			IMaterial ims;
			IMeasureUnit ius;
			IRow row;
			MaterialInfo mInfo;
			while(rs.next()){
				row = kdtImmuneEntrys.addRow();	
				row.getCell("materialName").setValue(rs.getString("FMaterialID"));
				row.getCell("materialModel").setValue(rs.getString("FModel"));
				row.getCell("unitQty").setValue(rs.getString("CFUNITQTY"));
//				materialID = rs.getString("FID");	
			}
			
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

     //饲喂信息
	private void getBreedFodderStandard(String curCompanyID, String string,int week, int weekDay) {

		// TODO Auto-generated method stub
		
		StringBuffer sb = new StringBuffer();
		kdtEntrys.removeRows();

		Date bizDate = UIRuleUtil.getDateValue(pkBizDate.getValue());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sb.append("select").append("\n")
		.append(" distinct t2.FID,t2.FName_l2 materialName,t2.FModel,t2.CFUNITQTY").append("\n") 
		.append(" from ").append("\n") 
		.append("T_FM_FeedStd                  t1").append("\n") 
		.append("inner join T_FM_FeedStdEntry  t4 on t1.FID=t4.FParentID").append("\n") 
		.append("inner join T_BD_Material      t2 on t2.FID=t4.FMaterialID").append("\n") 
		.append("inner join T_ORG_Company      t3 on t3.FID=t1.CFCompanyID").append("\n") 
		.append("where t1.CFBeginDate<={d '").append(sdf.format(bizDate)).append("'} and (t1.CFEndDate is null or t1.CFEndDate>={d '").append(sdf.format(bizDate)).append("'})").append("\n") 
		.append(" and t3.FID='").append(SysContext.getSysContext().getCurrentFIUnit().getString("id")).append("'").append("\n");
		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			IRow row;
			String materialID;
			MaterialInfo materialInfo;
			//设置显示其他项
			SelectorItemCollection slor;
			IMaterial iMaterial = MaterialFactory.getRemoteInstance();
			while(rs.next()){//查询结果有多条记录用while(rs.next())，查询结果只有一条记录用if(rs.next())
				row = kdtEntrys.addRow();
				row.getCell("materialName").setValue(rs.getString("materialName"));
				row.getCell("materialModel").setValue(rs.getString("FModel"));
				row.getCell("unitQty").setValue(rs.getString("CFUNITQTY"));
				materialID = rs.getString("FID");
				slor = new SelectorItemCollection();
				slor.add("*");
				slor.add("baseUnit.*");
				materialInfo = iMaterial.getMaterialInfo(new ObjectUuidPK(materialID), slor );
				row.getCell("material").setValue(materialInfo);
				row.getCell("unit").setValue(materialInfo.getBaseUnit());
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

	}
	//计算纯日龄
	private void setPurDayAge() {
		Integer week = txtweek.getIntegerValue();
		Integer weekDay = this.txtweekDay.getIntegerValue();
		if(week==null){
			week=0;
		}
		if(weekDay==null) {
			weekDay=0;
		}
		int age=((week-1)*7+weekDay)-1;
		if(age<0) {
			age=0;
		}
		this.lblDayAge.setText(age+" 日龄");
	}
	//设置批次过滤
	protected void setBatchFilter() {
		// TODO Auto-generated method stub
		//通过养殖户和养殖场来 过滤批次
		String farmerID=null,farmID=null,houseID=null;
		if(prmtfarmer.getValue()!=null) {//养殖户
			farmerID=((IPropertyContainer) prmtfarmer.getValue()).getString("id");
		}
		if(prmtfarm.getValue()!=null) {//养殖场
			farmID=((IPropertyContainer) prmtfarm.getValue()).getString("id");
		}//添加放养批次过滤条件
		StockingComm.setStockingBatchFilter(prmtbatch,curCompanyID,farmerID,farmID,true,true);
	}

	@Override
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		//		super.actionCopy_actionPerformed(e);
		if(!UtilRequest.isPrepare("ActionCopy", this))
			checkModified();
		if(editData != null && !OprtState.VIEW.equals(getOprtState()))
		{
			IObjectValue objectValue = (IObjectValue)getUIContext().get("CURRENT.VO");
			if(objectValue != null)
				try
			{
					String id = idList.getID(idList.getCurrentIndex());
					setOprtState("RELEASEALL");
					pubFireVOChangeListener(id);
			}
			catch(Throwable E) { }
		}
		ObjectValueUtil.copy(editData);
		unLockUI();
		setFieldsNull(editData);
		editData.setBaseStatus(BillBaseStatusEnum.ADD);
		//        editData.setNumber(null);
		//        editData.setFarmer(null);
		editData.setBizDate(new java.util.Date());
		setOprtState("ADDNEW");
		setDataObject(editData);
		//重新再加载一遍
		loadFields();
		showCopyAddNew();
		actionCopy.setEnabled(false);
		chkMenuItemSubmitAndAddNew.setVisible(true);
		setDefaultFocused();
		setPurDayAge();
		setMakeRelations(null);
	}

	@Override
	//必录校验
	protected void verifyInput(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.verifyInput(e);

	}

	private void farm_changed(Object object) {
		// TODO Auto-generated method stub
		if(isLoadField) {
			return;
		}
		isLoadField=true;
		boolean isExist=false;
		Component d = kdTabPanelMain.getComponentAt(kdTabPanelMain.getTabCount()-2);
		if(d.getName().equalsIgnoreCase("kDPanelTrans")||d.getName().equalsIgnoreCase("kDPanelEnvi")) {
			isExist=true;
		}
		if(prmtfarm.getValue()!=null) {
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("*");
			slor.add("farmer.*");//金蝶有种规则两级视图只显示编号，因此此方法用于显示其他的信息
			try {
				//由于每个养殖场只有一个批次，所以建立一个批次的集合，内含一个批次
				BatchCollection coll = BatchFactory.getRemoteInstance().getBatchCollection("where Farm='"+((IPropertyContainer)prmtfarm.getValue()).getString("id")+"' and AllOutDate is null and IsAllOut=0");
				//如果集合不为空就执行下面的语句
				if(coll.size()>0){
					BOSUuid pc = coll.get(0).getId();

					BatchInfo batchInfo=BatchFactory.getRemoteInstance().getBatchInfo(new ObjectUuidPK(pc.toString()),slor);
					isLoadField=true;
					this.prmtbatch.setValue(batchInfo);
					this.prmtfarmer.setValue(batchInfo.getFarmer());
					isLoadField=false;
				}
			} catch (EASBizException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (BOSException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}


			try {
				if((Boolean) UIRuleUtil.getProperty((IObjectValue) prmtfarm.getValue(), "isHouseManager")) {
					if(!isExist){
						kdTabPanelMain.add(kDPanelEnvi,"环控信息", kdTabPanelMain.getTabCount()-1);

					}
				}else{
					if(isExist) {
						this.kdTabPanelMain.removeTabAt(kdTabPanelMain.getTabCount()-2);
						this.kdTabPanelMain.removeTabAt(kdTabPanelMain.getTabCount()-2);
					}
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			} 
		}else{
			if(isExist) {
				this.kdTabPanelMain.removeTabAt(kdTabPanelMain.getTabCount()-2);
				this.kdTabPanelMain.removeTabAt(kdTabPanelMain.getTabCount()-2);
			}
		}
		isLoadField = false;

	}

	protected void setFilter() {
		// TODO Auto-generated method stub
		if(this.prmtcompany.getValue()!=null) {
			curCompanyID=((IPropertyContainer) this.prmtcompany.getValue()).getString("id");
		}else{
			curCompanyID=null;
		}

		//养殖户过滤
		setFarmerFilter(prmtfarmer, curCompanyID);
		String farmerID=null;
		if(prmtfarmer.getValue()!=null) {
			farmerID=((IPropertyContainer) prmtfarmer.getValue()).getString("id");
		}
		//养殖场过滤
		StockingComm.setFarmFilter(this.prmtfarm, curCompanyID, farmerID,null);
		//批次过滤
		setBatchFilter();

	}

	private void setFarmerFilter(final KDBizPromptBox prmtfarmer,final String companyID) {
		// TODO Auto-generated method stub
		// prmtfarmer
		StockingComm.setFarmerFilter(prmtfarmer, companyID, true);

	}
	protected void beforeStoreFields(ActionEvent e) throws Exception {
		deleteEmptyDrugEntry();
		super.beforeStoreFields(e);
		Calendar cal=Calendar.getInstance();
		cal.setTime(this.pkBizDate.getTimestamp());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("bizDate",sdf.format(cal.getTime()),CompareType.GREATER_EQUALS));
		cal.add(Calendar.DATE,0);
		filter.getFilterItems().add(new FilterItemInfo("bizDate",sdf.format(cal.getTime()),CompareType.LESS));
		if(!oprtState.equals(OprtState.ADDNEW)&&this.editData.getId()!=null) {
			filter.getFilterItems().add(new FilterItemInfo("id",this.editData.getString("id"),CompareType.NOTEQUALS));
		}
		ev.setFilter(filter);
		CoreBaseCollection col = this.getBizInterface().getCollection(ev);
		if(col!=null&&col.size()>0) {
			MsgBox.showWarning("该批次今日日报已经存在，不能重复填报！");
			SysUtil.abort();
		}
		if(kdtAssEntrys.getRowCount()>1) {
			MsgBox.showWarning("养殖信息分录只能有一行！");
			SysUtil.abort();
		}
		for(int rowIndex=0;rowIndex<this.kdtAssEntrys.getRowCount();rowIndex++) {
			//存栏量为0
			if(UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex, "breekingStock").getValue()).signum()<=0&&UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex, "femaleBreedkingStock").getValue()).signum()<=0) {
				if(MsgBox.showConfirm2("第"+(rowIndex+1)+"行养殖信息分录存栏量为0，是否完全出栏？")==MsgBox.YES) {
					kdtAssEntrys.getCell(rowIndex, "isMarketed").setValue(true);
				}
			}
		}

		//饲料领用
		if(this.kdtEntrys.getRowCount()<=0) {
			MsgBox.showWarning("饲喂信息不能为空！");
			SysUtil.abort();
		}else {
			if(UIRuleUtil.getBigDecimal(kdtEntrys.getFootRow(0).getCell("dailyQtyAll").getValue()).compareTo(BigDecimal.ZERO) == 0){
				MsgBox.showWarning("饲喂量不能为零");
				SysUtil.abort();
			}
		}
		if(kdtAssEntrys.getRowCount() == 0){
			MsgBox.showWarning("死淘分录不能为空");
			SysUtil.abort();
		}
		
		
	}
	private void deleteEmptyDrugEntry() {
		// TODO Auto-generated method stub
		int count=this.kdtImmuneEntrys.getRowCount();
		for(int rowIndex=0;rowIndex<count;) {
			//领用量，使用量，批号都为空
			if(UIRuleUtil.isNull(kdtImmuneEntrys.getCell(rowIndex,"vaccineGetQty").getValue())&&UIRuleUtil.isNull(kdtImmuneEntrys.getCell(rowIndex,"vaccineUsedQty").getValue())&&UIRuleUtil.isNull(kdtImmuneEntrys.getCell(rowIndex,"lot").getValue())) {
				this.kdtImmuneEntrys.removeRow(rowIndex);
			}else{
				rowIndex++;
			}
			count=this.kdtImmuneEntrys.getRowCount();
		}

	}
	@Override
	public void loadFields() {
		// TODO Auto-generated method stub
		isLoadField=true;
		isLoadField=true;
		super.loadFields(); 
		isLoadField=false;

		this.txtweek.setText(String.valueOf(this.editData.getWeek()));
		this.txtweekDay.setText(String.valueOf(this.editData.getWeekDay()));
		if(this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)) {
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(true);
		}else if (this.editData.getBaseStatus().equals(BillBaseStatusEnum.SUBMITED)){
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(false);
		}else {
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(true);
		}

		setPurDayAge();
		//第一次新增，触发批次事件
		if(oprtState.equals(OprtState.ADDNEW)) {
			batch_changed();
			farm_changed(null);
		}

		setEntryLastStock();
		isLoadField=false;



	}
	private void setEntryLastStock() {
		// TODO Auto-generated method stub
		for(int rowIndex=0;rowIndex<this.kdtAssEntrys.getRowCount();rowIndex++) {
			try {
				kdtAssEntrys_Changed(rowIndex, kdtAssEntrys.getColumnIndex("deathQty"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	@Override
	public void storeFields() {//将业务数据加载到数据对象
		// TODO Auto-generated method stub
		super.storeFields();
		this.editData.setWeek(StringUtils.isNotEmpty(this.txtweek.getText())?Integer.valueOf(this.txtweek.getText()):0);
		this.editData.setWeekDay(StringUtils.isNotEmpty(this.txtweekDay.getText())?Integer.valueOf(this.txtweekDay.getText()):0);

	}
	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub


		super.actionSave_actionPerformed(e);
	}


	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(e);
	}

	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
		}
		super.actionRemove_actionPerformed(e);
	}
	/**
	 * output actionAudit_actionPerformed
	 */
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception
	{
		if(this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止再次审核！");
			SysUtil.abort();
		}
		if(!this.editData.getBaseStatus().equals(BillBaseStatusEnum.SUBMITED)) {
			MsgBox.showWarning("单据尚未提交，禁止审核！");
			SysUtil.abort();
		}
		super.actionAudit_actionPerformed(e);

		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		//VIEW查看状态
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}
	/**
	 * output actionUnAudit_actionPerformed
	 */
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
	{
		if(!this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据尚未审核，禁止反审核！");
			SysUtil.abort();
		}
		super.actionUnAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}


	@Override
	protected IObjectValue createNewDetailData(KDTable arg0) {
		// TODO Auto-generated method stub
		return null;
	}}