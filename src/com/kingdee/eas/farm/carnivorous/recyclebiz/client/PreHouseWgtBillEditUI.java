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
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.dao.DataAccessException;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.CodingUtil;
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.SaleBizType;
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
import com.kingdee.bos.ctrl.swing.KDDatePicker;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;

/**
 * output class name
 */
public class PreHouseWgtBillEditUI extends AbstractPreHouseWgtBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(PreHouseWgtBillEditUI.class);
	private String curCompanyID;//当前财务组织
	private CompanyOrgUnitInfo company;
	private boolean isLoadField=false;
	private F7ContextManager f7Manager;
	/**
	 * output class constructor
	 */
	public PreHouseWgtBillEditUI() throws Exception
	{
		super();
	}


	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stublwwAAAA04TJxPGsV
		super.onLoad();
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		btnAudit.setIcon(ClientUtils.AuditIcon);
		btnUnAudit.setIcon(ClientUtils.UnAuditIcon);
		curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
		company=SysContext.getSysContext().getCurrentFIUnit();
		f7Manager = new F7ContextManager(this, OrgType.Storage);
		initControl();
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
		if(pkactualArriveTime.getValue()==null){
			pkactualArriveTime.setValue(new Date());
		}
	}

	private void initControl() {
		// TODO Auto-generated method stub
		pkactualArriveTime.setTimeEnabled(true);
		pkarriveTime.setTimeEnabled(true);

		this.prmtFICompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setFilter();			
			}});

		this.prmtfarmer.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				if(prmtfarmer.getValue()!=null){
					if(!isLoadField) {
						isLoadField=true;
						String farmerID=null,farmID=null;
						StockingComm.setFarmInfoByFarmer(prmtfarmer, prmtfarm);
						farmerID=((IPropertyContainer)prmtfarmer.getValue()).getString("id");
						try {
							FarmerInfo farmer=FarmerFactory.getRemoteInstance().getFarmerInfo(new ObjectUuidPK(farmerID));
							txtfarmerPhone.setText(farmer.getMobileTel());
						} catch (EASBizException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (BOSException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if(prmtfarm.getValue()!=null){
							farmID=((IPropertyContainer)prmtfarm.getValue()).getString("id");
							prmtbatchContract.setValue(StockingComm.getLastBatchContractInfo(null, farmerID, farmID,true));
						}	
						isLoadField=false;
					}}else{
						prmtfarm.setValue(null);
						txtfarmerPhone.setText(null);
					}
				setFilter();
			}});

		this.prmtfarm.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				if(prmtfarm.getValue()!=null){
					if(!isLoadField){
						isLoadField=true;
						prmtfarmer.setValue(StockingComm.getFarmerInfoByFarm(null, prmtfarm));
						isLoadField=false;
					}
					String farmerID = null;
					if(prmtfarmer.getValue()!=null){
						String farmID=((IPropertyContainer)prmtfarm.getValue()).getString("id");
						farmerID=((IPropertyContainer)prmtfarmer.getValue()).getString("id");
						try {
							FarmInfo  farm=FarmFactory.getRemoteInstance().getFarmInfo(new ObjectUuidPK(farmID));
							txtfarmAddress.setText(farm.getAddress());
							farmType.setSelectedItem(farm.getFaemsType());
						} catch (EASBizException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (BOSException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						prmtbatchContract.setValue(StockingComm.getLastBatchContractInfo(null, farmerID, farmID,true));

					}
				}else{
					prmtbatchContract.setValue(null);
					txtfarmAddress.setText(null);
					farmType.setSelectedItem(null);
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

		saleType.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				prmtcustomer.setValue(null);
				setFilter();
			}
		});

		DataChangeListener numChangeListener=new DataChangeListener() {
			public void dataChanged(DataChangeEvent e) {
				// TODO Auto-generated method stub
				calData();
			}
		};
		txtpreHouseQty.addDataChangeListener(numChangeListener);
		txtpreHouseTare.addDataChangeListener(numChangeListener);
		txtpreHouseGross.addDataChangeListener(numChangeListener);
		
		txtoutSalePrice.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				if(!isLoadField){
					BigDecimal price=UIRuleUtil.getBigDecimal(txtoutSalePrice.getBigDecimalValue());
					BigDecimal suttle=UIRuleUtil.getBigDecimal(txtpreHouseSuttle.getBigDecimalValue());
					BigDecimal amount=suttle.multiply(price);
					isLoadField=true;
					txtoutSaleAmt.setValue(amount);
					isLoadField=false;
				}
			}
		});

		txtoutSaleAmt.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				if(!isLoadField){
					if(UIRuleUtil.getBigDecimal(txtoutSaleAmt.getBigDecimalValue()).signum()==0&&UIRuleUtil.getBigDecimal(txtpreHouseSuttle.getBigDecimalValue()).signum()==0){
						return;
					}
					BigDecimal amount=UIRuleUtil.getBigDecimal(txtoutSaleAmt.getBigDecimalValue());
					BigDecimal suttle=UIRuleUtil.getBigDecimal(txtpreHouseSuttle.getBigDecimalValue());
					BigDecimal price=suttle.signum()==0?BigDecimal.ZERO:amount.divide(suttle,2,RoundingMode.HALF_UP);
					isLoadField=true;
					txtoutSalePrice.setValue(price);
					isLoadField=false;
				}
			}
		});
		
		this.prmtcar.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				if(prmtcar.getValue()!=null){
					SelectorItemCollection slor =new SelectorItemCollection();
					slor.add("*");
					slor.add("Entry.*");
					slor.add("Entry.driver.*");
					try {
						CarInfo car=CarFactory.getRemoteInstance().getCarInfo(new ObjectUuidPK(((IPropertyContainer)prmtcar.getValue()).getString("id")), slor);
						//						txtcarNumber.setText(car.getNumber());
						prmtdriver.setValue(null);
						CarEntryCollection carEntry=car.getEntry();
						for(int i=0;i<carEntry.size();i++){
							CarEntryInfo entry =carEntry.get(i);
							if(entry.isIsDefault()){
								prmtdriver.setValue(entry.getDriver());
								txtdriverPhone.setText(UIRuleUtil.getString(UIRuleUtil.getProperty((IObjectValue)prmtdriver.getValue(),"driverphone")));
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
					txtdriverPhone.setText(null);  
					prmtdriver.setValue(null);
				}
				setFilter();
			}
		});

		setFilter();
	}

	private void calData() {
		// TODO Auto-generated method stub
		BigDecimal preHouseTare=UIRuleUtil.getBigDecimal(txtpreHouseTare.getBigDecimalValue());
		BigDecimal preHouseGross=UIRuleUtil.getBigDecimal(txtpreHouseGross.getBigDecimalValue());
		BigDecimal preHouseSuttle=preHouseGross.subtract(preHouseTare);
		txtpreHouseSuttle.setValue(preHouseSuttle);
		txtrecQty.setValue(UIRuleUtil.getInt(txtpreHouseQty.getIntegerValue()));
		txtsettleWgt.setValue(preHouseSuttle);
		txtrecSuttle.setValue(preHouseSuttle);
		
		BigDecimal price=UIRuleUtil.getBigDecimal(txtoutSalePrice.getBigDecimalValue());
		BigDecimal suttle=UIRuleUtil.getBigDecimal(txtpreHouseSuttle.getBigDecimalValue());
		BigDecimal amount=suttle.multiply(price);
		txtoutSaleAmt.setValue(amount);	
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
			prmtbreedData.setValue(contractInfo.getBreedData());
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
			prmtbreedData.setValue(null);
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
			try {
				company=CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(new ObjectUuidPK(curCompanyID));
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				e.printStackTrace();
			}
		}else{
			curCompanyID=null;
		}
		f7Manager.registerBizCustomerF7(prmtcustomer, null, null, company);

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
		//客户过滤
		StockingComm.setCustomerFilterBySale(prmtcustomer, saleType.getSelectedItem()==null?null:(SaleBizType) saleType.getSelectedItem());
		//车辆过滤
		StockingComm.setCarFilter(prmtcar, curCompanyID,null);
	}


	@Override
	protected void verifyInput(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.verifyInput(e);
		if(UIRuleUtil.getInt(txtpreHouseQty.getIntegerValue())==0){
			MsgBox.showWarning("棚前只数不能为0");
			SysUtil.abort();
		}
		if(UIRuleUtil.getBigDecimal(txtpreHouseSuttle.getBigDecimalValue()).signum()==0){
			MsgBox.showWarning("棚前净重不能为0");
			SysUtil.abort();
		}
		if(UIRuleUtil.getBigDecimal(txtoutSalePrice.getBigDecimalValue()).signum()==0){
			if(MsgBox.showConfirm2("外卖价格为0,是否继续?")!=MsgBox.YES)
			SysUtil.abort();
		}
	}

	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
	}
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSubmit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
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


	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.carnivorous.recyclebiz.PreHouseWgtBillFactory.getRemoteInstance();
	}

	/**
	 * output createNewDetailData method
	 */
	protected IObjectValue createNewDetailData(KDTable table)
	{

		return null;
	}

	@Override
	protected void applyDefaultValue(IObjectValue vo) {
		// TODO Auto-generated method stub
	}
	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.carnivorous.recyclebiz.PreHouseWgtBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.recyclebiz.PreHouseWgtBillInfo();
		if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")).getBoolean("isBizUnit"))
			objectValue.put("FICompany",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")));

		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());
		return objectValue;
	}

}