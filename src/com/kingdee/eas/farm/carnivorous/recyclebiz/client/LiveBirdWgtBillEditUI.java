/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.recyclebiz.client;

import java.awt.Toolkit;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.kscript.debug.SetValue;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.dao.DataAccessException;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.CodingUtil;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.custom.commld.ListenerUtil;
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo;
import com.kingdee.eas.farm.carnivorous.basedata.SystemSettingInfo;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.SaleBizType;
import com.kingdee.eas.farm.stocking.basedata.SettleItemType;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.publicdata.CarEntryCollection;
import com.kingdee.eas.publicdata.CarEntryInfo;
import com.kingdee.eas.publicdata.CarFactory;
import com.kingdee.eas.publicdata.CarInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;

/**
 * output class name
 */
public class LiveBirdWgtBillEditUI extends AbstractLiveBirdWgtBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(LiveBirdWgtBillEditUI.class);
	private String curCompanyID;//当前财务组织
	private boolean isLoadField=false;

	/**
	 * output class constructor
	 */
	public LiveBirdWgtBillEditUI() throws Exception
	{
		super();
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		btnAudit.setIcon(ClientUtils.AuditIcon);
		btnUnAudit.setIcon(ClientUtils.UnAuditIcon);
		curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
	}
	public void loadFields()
	{
		isLoadField=true;
		super.loadFields();
		isLoadField=false;

		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(true);
		}else if (this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)){
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(false);
		}else {
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(true);
		}
		StockingComm.makeApplierF7(prmtperson, ((IPropertyContainer)prmtFICompany.getValue()).getString("id"), this, false);
		initControl();
	}

	private void initControl() {
		// TODO Auto-generated method stub
		setFilter();
		this.prmtFICompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setFilter();
			}});


		this.prmtfarmer.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				if(prmtfarmer.getValue()!=null){
					if(!isLoadField) {
						String farmerID=null,farmID=null;
						DataChangeListener[] listener = ListenerUtil.F7GetDateChangeListener(prmtfarm);
						ListenerUtil.F7RemoveDateChangeListener(prmtfarm);
						StockingComm.setFarmInfoByFarmer(prmtfarmer, prmtfarm);
						ListenerUtil.F7AddDateChangeListener(prmtfarm, listener);

						farmerID=((IPropertyContainer)prmtfarmer.getValue()).getString("id");
						if(prmtfarm.getValue()!=null){
							farmID=((IPropertyContainer)prmtfarm.getValue()).getString("id");
							prmtbatchContract.setValue(StockingComm.getLastBatchContractInfo(null, farmerID, farmID,true));
						}	
						isLoadField=false;
					}}else{
						prmtfarm.setValue(null);
					}
				setFilter();
			}});

		this.prmtfarm.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				if(prmtfarm.getValue()!=null){
					if(!isLoadField){
						isLoadField=true;
						prmtfarmer.setValue(StockingComm.getFarmerInfoByFarm(null, prmtfarm));
						String farmerID = null;
						if(prmtfarmer.getValue()!=null){
							String farmID=((IPropertyContainer)prmtfarm.getValue()).getString("id");
							farmerID=((IPropertyContainer)prmtfarmer.getValue()).getString("id");
							prmtbatchContract.setValue(StockingComm.getLastBatchContractInfo(null, farmerID, farmID,true));
						}		;
						isLoadField=false;
					}
				}else{
					prmtbatchContract.setValue(null);
				}
				setFilter();
			}});

		this.prmtbatch.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				batch_changed(e);
			}});

		prmtbatchContract.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				try {
					prmtbatchContract_Changed(arg0);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});

		txtpreHouseSuttle.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				updateWgt();
			}
		});
		txtpreHouseGross.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				updateWgt();
			}
		});
		txtsettleQty.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				updateWgt();
			}
		});
		
		
		kdtSaleEntrys.addKDTEditListener(new KDTEditAdapter(){
			
			@Override
			public void editStopped(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStopped(e);
				kdtSaleEntrys_EditStoped(e.getRowIndex(), e.getColIndex());
			}
		});
	}


	
	private void updateWgt() {
		// TODO Auto-generated method stub
		BigDecimal preInHouseTare=UIRuleUtil.getBigDecimal(txtpreHouseTare.getBigDecimalValue());
		BigDecimal preInHouseGross=UIRuleUtil.getBigDecimal(txtpreHouseGross.getBigDecimalValue());
		BigDecimal suttle=preInHouseTare.subtract(preInHouseGross);
		txtpreHouseSuttle.setValue(suttle);
		BigDecimal settleQty=UIRuleUtil.getBigDecimal(txtsettleQty.getBigDecimalValue());
		BigDecimal averageWgt=settleQty.signum()==0?BigDecimal.ZERO:suttle.divide(settleQty,2,RoundingMode.HALF_UP);
		txtaverageWgt.setValue(averageWgt);
	}
	
	private void kdtSaleEntrys_EditStoped(int rowIndex,int colIndex) {
		// TODO Auto-generated method stub		
		if(kdtSaleEntrys.getColumnKey(colIndex).equalsIgnoreCase("car")){
			if(kdtSaleEntrys.getCell(rowIndex, colIndex).getValue()!=null){
				SelectorItemCollection slor =new SelectorItemCollection();
				slor.add("*");
				slor.add("Entry.*");
				slor.add("Entry.driver.*");
				try {
					CarInfo car=CarFactory.getRemoteInstance().getCarInfo(new ObjectUuidPK(((IPropertyContainer)kdtSaleEntrys.getCell(rowIndex, colIndex).getValue()).getString("id")), slor);
					//						txtcarNumber.setText(car.getNumber());
					kdtSaleEntrys.getCell(rowIndex, "driver").setValue(null);
					CarEntryCollection carEntry=car.getEntry();
					for(int i=0;i<carEntry.size();i++){
						CarEntryInfo entry =carEntry.get(i);
						if(entry.isIsDefault()){
							kdtSaleEntrys.getCell(rowIndex, "driver").setValue(entry.getDriver());
							break;
						}
					}
				} catch (EASBizException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (BOSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else{
				kdtSaleEntrys.getCell(rowIndex, "driver").setValue(null);
			}
			String carID=kdtSaleEntrys.getCell(rowIndex,"car").getValue()==null?null:((IPropertyContainer)kdtSaleEntrys.getCell(rowIndex,"car").getValue()).getString("id");
			StockingComm.setDriverFilter((KDBizPromptBox)kdtSaleEntrys.getColumn("driver").getEditor().getComponent(), curCompanyID, carID);
		}
		
			if(kdtSaleEntrys.getCell(rowIndex, "salebizType").getValue()!=null&&kdtSaleEntrys.getCell(rowIndex, "salebizType").getValue()!=SaleBizType.inner){
				kdtSaleEntrys.getCell(rowIndex, "purchaseOrg").setValue(null);
			}
		
			if(kdtSaleEntrys.getCell(rowIndex, "salebizType").getValue()!=null&&kdtSaleEntrys.getCell(rowIndex, "salebizType").getValue()!=SaleBizType.out){
				kdtSaleEntrys.getCell(rowIndex, "customer").setValue(null);
			}
	}

	/**
	 * 批次改变
	 */
	private void batch_changed(DataChangeEvent e) {
		isLoadField=true;
		if(e.getNewValue()!=null) {
			try {
				pkinDate.setValue(UIRuleUtil.getProperty((IObjectValue) e.getNewValue(), "inDate"));
				txtbatchQty.setValue(UIRuleUtil.getProperty((IObjectValue) e.getNewValue(), "femaleQty"));
			} catch (DataAccessException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			} catch (BOSException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}		
		}else{
			pkinDate.setValue(null);
			txtbatchQty.setValue(null);
		}
		isLoadField=false;
	}




	public void prmtbatchContract_Changed(DataChangeEvent arg0) throws Exception {
		if(prmtbatchContract.getValue()!=null){
			String contractID=((IPropertyContainer) prmtbatchContract.getValue()).getString("id");
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("*");
			slor.add("breedData.*");
			slor.add("farmer.*");
			slor.add("farm.*");
			slor.add("person.*");
			slor.add("batch.*");
			slor.add("settlementPolicy.*");
			BatchContractBillInfo contractInfo = BatchContractBillFactory.getRemoteInstance().getBatchContractBillInfo(new ObjectUuidPK(contractID),slor );
			prmtsettlePolicy.setValue(contractInfo.getSettlementPolicy());
			prmtperson.setValue(contractInfo.getPerson());
			String batchID=StockingComm.getBatchIDByContractID(null, contractID);
			isLoadField=true;
			if(StringUtils.isNotEmpty(batchID)) {
				this.prmtbatch.setValue(BatchFactory.getRemoteInstance().getBatchInfo(new ObjectUuidPK(batchID)));
			}else {
				this.prmtbatch.setValue(null);
			}
			isLoadField=false;
		}else{
			this.prmtbatch.setValue(null);
			prmtsettlePolicy.setValue(null);
			prmtperson.setValue(null);
		}
		setFilter();
	}

	/**
	 * 设置过滤条件
	 * @param companyID
	 */
	private void setFilter() {
		if(this.prmtFICompany.getValue()!=null) {
			curCompanyID=((IPropertyContainer) this.prmtFICompany.getValue()).getString("id");
		}else{
			curCompanyID=null;
		}


		String farmerID="";
		String farmID="";

		farmerID=prmtfarmer.getValue()==null?"":((FarmerInfo)prmtfarmer.getValue()).getId().toString();
		farmID=prmtfarm.getValue()==null?"":((FarmInfo)prmtfarm.getValue()).getId().toString();

		//养殖户过滤
		StockingComm.setFarmerFilter(prmtfarmer, curCompanyID,false);
		//养殖场过滤
		StockingComm.setFarmFilter(prmtfarm, curCompanyID, farmerID,true);
		//合同过滤
		StockingComm.setBatchContractFilter(prmtbatchContract, curCompanyID,farmerID,farmID,true,true);


		//车辆过滤
//		StockingComm.setCarFilter((KDBizPromptBox)kdtSaleEntrys.getColumn("car").getEditor().getComponent(), curCompanyID);
		//司机过滤
		StockingComm.setDriverFilter((KDBizPromptBox)kdtSaleEntrys.getColumn("driver").getEditor().getComponent(), curCompanyID, null);
	}


	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
	}

	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(e);
	}

	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
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
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止再次审核！");
			SysUtil.abort();
		}
		if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)) {
			MsgBox.showWarning("单据尚未提交，禁止审核！");
			SysUtil.abort();
		}

		if(WorkFlowUtil.checkBillInWorkflow(null,editData.getId().toString())){
			MsgBox.showWarning("当前单据尚在工作流执行过程,不能执行该操作");
			SysUtil.abort();
		}

		super.actionAudit_actionPerformed(e);

		this.doAfterSave(new ObjectUuidPK(editData.getId()));

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
		if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
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
		editData.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		//        editData.setNumber(null);
		//		editData.setFarmer(null);
		editData.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		editData.setNumber(CodingUtil.getNewNumberByCodingRule(null, editData));
		//		editData.setBizDate(new java.util.Date());
		setOprtState("ADDNEW");
		setDataObject(editData);
		loadFields();
		showCopyAddNew();
		//		editData.setPerson(null);
		actionCopy.setEnabled(false);
		chkMenuItemSubmitAndAddNew.setVisible(true);
		setDefaultFocused();
		isLoadField=false;

		setMakeRelations(null);

	}
	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.carnivorous.recyclebiz.LiveBirdWgtBillFactory.getRemoteInstance();
	}

	/**
	 * output createNewDetailData method
	 */
	protected IObjectValue createNewDetailData(KDTable table)
	{

		return null;
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.carnivorous.recyclebiz.LiveBirdWgtBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.recyclebiz.LiveBirdWgtBillInfo();
		if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")).getBoolean("isBizUnit"))
			objectValue.put("FICompany",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")));

		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());
		return objectValue;
	}

}