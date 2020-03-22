/**
 * output package name
 */
package com.kingdee.eas.farm.breed.business.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.EventListener;
import java.util.Map;

import java_cup.internal_error;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.bi.model.commonui.propsheet.beans.value.LongValue;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.breed.BreedModelEntryInfo;
import com.kingdee.eas.farm.breed.HenhouseFactory;
import com.kingdee.eas.farm.breed.HenhouseInfo;
import com.kingdee.eas.farm.breed.HenhouseType;
import com.kingdee.eas.farm.breed.layegg.LayEggFacadeFactory;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

/**
 * output class name
 */
public class CCBreedPlanEditUI extends AbstractCCBreedPlanEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(CCBreedPlanEditUI.class);

	//商品鸡场的饲喂规范
	Map<String,BreedModelEntryInfo>standard;
	/**
	 * output class constructor
	 */
	public CCBreedPlanEditUI() throws Exception
	{
		super();
		// 图标设置
		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
	}

	/**
	 * 初始化
	 */
	@Override
	public void onLoad() throws Exception {

		super.onLoad();
		// 设置全屏		
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());


		//		f7Init();

		// 设置鸡舍类别
		//		setHenhouseType(null);
		// 设置过滤条件
		setHenhouseFilter(null);

		if("ADDNEW".equals(this.getOprtState())){
			this.baseStatus.setSelectedIndex(1);
		}


		kdtEntrys.addKDTEditListener(new KDTEditAdapter() {
			public void editStopped(KDTEditEvent e) {
				try {
					kdtEntrys_Changed(e.getRowIndex(),e.getColIndex());
				}
				catch (Exception exc) {
					handUIException(exc);
				}
			}
		});
		//		
		//		this.prmtbreedBatch.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
		//            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
		//                try {
		//                    prmtbreedBatch_dataChanged(e);
		//                } catch (Exception exc) {
		//                    handUIException(exc);
		//                } finally {
		//                }
		//            }
		//        });



		//获得商品鸡场的饲喂规范
		standard=LayEggFacadeFactory.getRemoteInstance().getFeedStandard("3");
		if(standard==null||standard.size()<=0)
		{
			MsgBox.showInfo("未获取当前商品鸡场的饲喂规范信息，请先维护饲喂规范信息");
			SysUtil.abort();
		}
	}

	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		super.loadFields();
	}

	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}

	/**
	 * output btnAddLine_actionPerformed method
	 */
	protected void btnAddLine_actionPerformed(java.awt.event.ActionEvent e) throws Exception
	{
		super.btnAddLine_actionPerformed(e);
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.breed.business.CCBreedPlanFactory.getRemoteInstance();
	}

	/**
	 * output createNewDetailData method
	 */
	protected IObjectValue createNewDetailData(KDTable table)
	{

		return null;
	}

	/**
	 * output applyDefaultValue method
	 */
	protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("baseStatus",new Integer(0));
		vo.put("houseType","3");

	} 
	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.breed.business.CCBreedPlanInfo objectValue = new com.kingdee.eas.farm.breed.business.CCBreedPlanInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());
		objectValue.setBaseStatus(BillBaseStatusEnum.ADD);
		objectValue.setHouseType(HenhouseType.CC);
		objectValue.setStoOrg(SysContext.getSysContext().getCurrentStorageUnit());
		objectValue.setBreedDays(Integer.parseInt(String.valueOf(getStandardDays())));
		return objectValue;
	}

	/**
	 * 根据上孵计划获得入栏计划
	 */
	@Override
	public void actionGetCCBreedPlan_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		super.actionGetCCBreedPlan_actionPerformed(e);
	}

	/**
	 * 重载单据内容
	 * @throws Exception 
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void reloadData() throws EASBizException, BOSException, Exception{

		if ((this.editData == null) || (this.editData.getId() == null)) {
			return;
		}
		IObjectPK pk = new ObjectUuidPK(this.editData.getId());
		setDataObject(getValue(pk));
		EventListener[] lsts = removeDetailTableListener(KDTPropertyChangeListener.class);
		loadFields();
		restoreDetailTableListener(KDTPropertyChangeListener.class, lsts);
		initOldData(this.editData);
		setSave(true);
		setSaved(true);
		// 中断
		SysUtil.abort();



	}

	/**
	 * 设置鸡舍过滤条件
	 */
	private void setHenhouseFilter(HenhouseType selHenhouseType){


		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		if(selHenhouseType != null){
			filter.getFilterItems().add(new FilterItemInfo("houseType",selHenhouseType.getValue(),CompareType.EQUALS));

		}
		StorageOrgUnitInfo cuInfo = SysContext.getSysContext().getCurrentStorageUnit();
		filter.getFilterItems().add(new FilterItemInfo("chickenFarm.id",cuInfo.getId().toString(),CompareType.EQUALS));

		evi.setFilter(filter);
		final KDBizPromptBox kdtEntrys_henHouse_PromptBox = new KDBizPromptBox();
		kdtEntrys_henHouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseF7Query");
		kdtEntrys_henHouse_PromptBox.setVisible(true);
		kdtEntrys_henHouse_PromptBox.setEditable(true);
		kdtEntrys_henHouse_PromptBox.setDisplayFormat("$number$");
		kdtEntrys_henHouse_PromptBox.setEditFormat("$number$");
		kdtEntrys_henHouse_PromptBox.setCommitFormat("$number$");
		kdtEntrys_henHouse_PromptBox.setEntityViewInfo(evi);
		KDTDefaultCellEditor kdtEntrys_henHouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henHouse_PromptBox);
		this.kdtEntrys.getColumn("henHouse").setEditor(kdtEntrys_henHouse_CellEditor);
		ObjectValueRender kdtEntrys_henHouse_OVR = new ObjectValueRender();
		kdtEntrys_henHouse_OVR.setFormat(new BizDataFormat("$number$"));
		this.kdtEntrys.getColumn("henHouse").setRenderer(kdtEntrys_henHouse_OVR);




	}

	/**
	 * 校验
	 */
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		super.beforeStoreFields(arg0);

		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtstoOrg.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖场"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(houseType.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"鸡舍类别"});
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"henHouse").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"鸡舍"});
			}
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"incoopDate").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"入栏日期"});
			}
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"initQty").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"入栏量"});
			}else{
				Integer initQty = (Integer) kdtEntrys.getCell(i,"initQty").getValue();
				if(initQty != null && initQty.intValue() <= 0){
					throw new EASBizException(new NumericExceptionSubItem("01","入栏量必须大于0"));
				}
			}
		}

	}

	/**
	 * 提交前校验
	 */
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		if(this.baseStatus.getSelectedItem() == null || 
				BillBaseStatusEnum.ADD.equals(this.baseStatus.getSelectedItem()) || 
				BillBaseStatusEnum.TEMPORARILYSAVED.equals(this.baseStatus.getSelectedItem()) ||
				BillBaseStatusEnum.SUBMITED.equals(this.baseStatus.getSelectedItem()) ){
			try{

				super.actionSubmit_actionPerformed(e);

			}catch(BOSException bose){
				MsgBox.showError(bose.getMessage());
				SysUtil.abort();
			}


		}else{
			MsgBox.showWarning("只能提交未审核的批次");
			SysUtil.abort();
		}

	}
	/**
	 * 审核
	 */
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		if(this.editData == null || this.editData.getId() == null || !this.editData.getBaseStatus().equals(BillBaseStatusEnum.SUBMITED)){
			MsgBox.showWarning("不能审核未提交的单据");
			SysUtil.abort();
		}
		try{

			super.actionAudit_actionPerformed(e);
			MsgBox.showWarning("审核完成");
			reloadData();

		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
	}
	/**
	 * 反审核
	 */
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		if(this.editData == null || this.editData.getId() == null || !this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)){
			MsgBox.showWarning("只能反审核处于审核状态的批次");
			SysUtil.abort();
		}
		try{
			super.actionUnAudit_actionPerformed(e);
			MsgBox.showWarning("反审核完成");
			reloadData();
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
	}


	/**
	 * output kdtEntrys_Changed(int rowIndex,int colIndex) method
	 */
	public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
	{


		if ("henHouse".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
			kdtEntrys.getCell(rowIndex,"henhouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"henHouse").getValue(),"name")));
		}

		// 计算 养殖密度
		if ("initQty".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey()) || "henHouse".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
			HenhouseInfo currHenhouseInfo = (HenhouseInfo) kdtEntrys.getCell(rowIndex,"henHouse").getValue();
			int initQty = (Integer) kdtEntrys.getCell(rowIndex,"initQty").getValue();
			BigDecimal currDensity = new BigDecimal("0");
			if(currHenhouseInfo != null){
				currHenhouseInfo = HenhouseFactory.getRemoteInstance().getHenhouseInfo(new ObjectUuidPK(currHenhouseInfo.getId()));
				BigDecimal area = currHenhouseInfo.getArea();
				if(area != null && area.compareTo(new BigDecimal("0")) != 0){
					BigDecimal initQtyBD = new BigDecimal(initQty);
					currDensity = initQtyBD.divide(area,2,RoundingMode.HALF_UP);
				}
			}
			// 设置库存
			kdtEntrys.getCell(rowIndex,"stockingdensity").setValue(currDensity);
		}



		//计算出栏日期		
		if ("incoopDate".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey()))
			if(kdtEntrys.getRow(rowIndex).getCell(colIndex).getValue()==null)
				return;
			else if(txtbreedDays.getIntegerValue()!=null&&txtbreedDays.getIntegerValue()>0)
			{
				Date initDate = (Date)kdtEntrys.getRow(rowIndex).getCell(colIndex).getValue();
				kdtEntrys.getRow(rowIndex).getCell("slaughterDate").setValue(new Date(initDate.getTime()+txtbreedDays.getLongValue()*24*60*60*1000));
			}
			else
			{
				long days=getStandardDays();				
				if(days==0)
				{
					MsgBox.showInfo("未找到启用的商品鸡场的饲喂规范");
					return;
				}
				Date initDate = (Date)kdtEntrys.getRow(rowIndex).getCell(colIndex).getValue();
				kdtEntrys.getRow(rowIndex).getCell("slaughterDate").setValue(new Date(initDate.getTime()+days*24*60*60*1000));
			}

		//计算预计出栏量
		if ("initQty".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey()))
		{
			if(kdtEntrys.getRow(rowIndex).getCell(colIndex).getValue()==null)
				return;
			BigDecimal rate=getAllcullAndDeathRate();
			BigDecimal amt = new BigDecimal(String.valueOf(kdtEntrys.getRow(rowIndex).getCell(colIndex).getValue()));
			BigDecimal cullAndDeath = amt.multiply(rate).divide(new BigDecimal("100"),0,BigDecimal.ROUND_HALF_EVEN);
			kdtEntrys.getRow(rowIndex).getCell("slaughterAmt").setValue(amt.subtract(cullAndDeath));
		}
	}
	/**
	 * 获得商品鸡场总的死淘率【假定日标准死淘率是指 当日死淘数/入栏量】
	 * @return
	 */
	private BigDecimal getAllcullAndDeathRate() {
		Integer days;
		// TODO Auto-generated method stub
		if(txtbreedDays.getIntegerValue()!=null&&txtbreedDays.getIntegerValue()>0)
			days=txtbreedDays.getIntegerValue();
		else
			days=Integer.parseInt(String.valueOf(getStandardDays()));
		StringBuffer sb=new StringBuffer();
		sb.append(" select t1.fid,sum(t2.cfdailyDCRate) from CT_FM_BreedModel t1");
		sb.append(" inner join CT_FM_BreedModelEntrys t2 on t2.fparentid=t1.fid");
		sb.append(" and t2.CFDays<=").append(days);
		sb.append(" where t1.cfhouseType='3' and t1.cfdeletedstatus='1' ");
		sb.append(" group by t1.fid");
		BigDecimal rate=BigDecimal.ZERO;
		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			while(rs.next())
			{
				if(rate.equals(BigDecimal.ZERO))
				{
					rate=new BigDecimal(rs.getString("sum(t2.cfdailyDCRate)"));
				}
				else
					throw new EASBizException(new NumericExceptionSubItem("001","存在不止一个启用的商品鸡饲喂规范"));
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
		return rate;
	}

	/**
	 * 查询商品鸡场饲喂规范的标准饲喂时间
	 */
	private long getStandardDays() {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		sb.append(" select cfbreeddays from CT_FM_BreedModel");
		sb.append(" where cfhouseType='3' and cfdeletedstatus='1'");
		long days=0;
		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			while(rs.next())
			{
				if(days==0)
					days=Long.parseLong(rs.getString("cfbreeddays"));
				else
					throw new EASBizException(new NumericExceptionSubItem("001","存在不止一个启用的商品鸡场的饲喂规范"));
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return days;
	}

	/**
	 * 手动修改 标准饲喂周期
	 */
	@Override
	protected void txtbreedDays_dataChange(DataChangeEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(kdtEntrys.getRowCount()==0||txtbreedDays.getIntegerValue()==null)
			return;
		 Long days = Long.valueOf(txtbreedDays.getIntegerValue().toString());
		for(int i=0;i<kdtEntrys.getRowCount();i++)
			if(kdtEntrys.getCell(i, "incoopDate").getValue()!=null){
				Date incoopDate = (Date)kdtEntrys.getCell(i, "incoopDate").getValue();
				Date date = new Date(incoopDate.getTime()+days*24*3600*1000);
				kdtEntrys.getCell(i, "slaughterDate").setValue(date);
			}
		super.txtbreedDays_dataChange(e);
	}

}