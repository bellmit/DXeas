/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.feedbiz.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.JDialog;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTResizeEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTResizeListener;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.dao.DataAccessException;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.base.permission.PermissionFactory;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CostCenterOrgUnitFactory;
import com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.custom.commld.ListenerUtil;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.farm.carnivorous.basebiz.FarmerGuaranteeBillInfo;
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BatchInfo;
import com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicy;
import com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicyFactory;
import com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicyInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmHouseEntryCollection;
import com.kingdee.eas.farm.carnivorous.basedata.FarmHouseEntryFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmHouseEntryInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.farm.carnivorous.basedata.MarginPolicy;
import com.kingdee.eas.farm.carnivorous.basedata.MarginPolicyFactory;
import com.kingdee.eas.farm.carnivorous.basedata.MarginPolicyInfo;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyFactory;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo;
import com.kingdee.eas.farm.carnivorous.basedata.SystemSettingInfo;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillCollection;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractCollection;
import com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractPolicyEntryCollection;
import com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractPolicyEntryFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractPolicyEntryInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.ContractType;
import com.kingdee.eas.farm.stocking.basedata.BreedDataFactory;
import com.kingdee.eas.farm.stocking.basedata.BreedDataInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.FarmsType;
import com.kingdee.eas.farm.stocking.basedata.StockingFarmTypeEnum;
import com.kingdee.eas.farm.stocking.basedata.StockingTypeEnum;
import com.kingdee.eas.farm.stocking.hatch.GenderType;
import com.kingdee.eas.farm.stocking.hatch.GenerateType;
import com.kingdee.eas.fi.cas.BillStatusEnum;
import com.kingdee.eas.framework.ObjectValueUtil;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.framework.util.UIConfigUtility;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.eas.wlhlcomm.client.UITools;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.util.NumericExceptionSubItem;

/**
 * output class name
 */
public class BatchContractBillEditUI extends AbstractBatchContractBillEditUI{
	private static final Logger logger = CoreUIObject.getLogger(BatchContractBillEditUI.class);
	private String curCompanyID;//当前财务组织
	private boolean isLoadField=false;
	private SystemSettingInfo sysSetting;
	private DataChangeListener[] ls1,ls2,ls3,ls4,ls5,ls6,ls7,ls8=null;
	private KDTResizeListener resizeListener;
	public BatchContractBillEditUI() throws Exception{
		super();
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
	}

	@Override
	public void beforeActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		super.beforeActionPerformed(e);
		ls1 = this.prmtcompany.getListeners(DataChangeListener.class);
		for(int index=0;index<ls1.length;index++) {
			this.prmtcompany.removeDataChangeListener(ls1[index]);
		}
		ls2 = this.prmtcompany.getListeners(DataChangeListener.class);
		for(int index=0;index<ls2.length;index++) {
			this.prmtfarm.removeDataChangeListener(ls2[index]);
		}
		ls3=this.prmtfarmer.getListeners(DataChangeListener.class);
		for(int index=0;index<ls3.length;index++) {
			this.prmtfarmer.removeDataChangeListener(ls3[index]);
		}
		ls4=this.prmtconFeedContract.getListeners(DataChangeListener.class);
		for(int index=0;index<ls4.length;index++) {
			this.prmtconFeedContract.removeDataChangeListener(ls4[index]);
		}
		ls5=this.prmtbatch.getListeners(DataChangeListener.class);
		for(int index=0;index<ls5.length;index++) {
			this.prmtbatch.removeDataChangeListener(ls5[index]);
		}
		ls6=this.prmtmarginPolicy.getListeners(DataChangeListener.class);
		for(int index=0;index<ls6.length;index++) {
			this.prmtmarginPolicy.removeDataChangeListener(ls6[index]);
		}
		ls7=this.txtfemaleBreedQty.getListeners(DataChangeListener.class);
		for(int index=0;index<ls7.length;index++) {
			this.txtfemaleBreedQty.removeDataChangeListener(ls7[index]);
		}
		ls8=this.prmtsettlementPolicy.getListeners(DataChangeListener.class);
		for(int index=0;index<ls8.length;index++) {
			this.prmtsettlementPolicy.removeDataChangeListener(ls8[index]);
		}
	}

	@Override
	public void afterActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		super.afterActionPerformed(e);
		for(int index=0;index<ls1.length;index++) {
			this.prmtcompany.addDataChangeListener(ls1[index]);
		}
		for(int index=0;index<ls2.length;index++) {
			this.prmtfarm.addDataChangeListener(ls2[index]);
		}
		for(int index=0;index<ls3.length;index++) {
			this.prmtfarmer.addDataChangeListener(ls3[index]);
		}
		for(int index=0;index<ls4.length;index++) {
			this.prmtconFeedContract.addDataChangeListener(ls4[index]);
		}
		for(int index=0;index<ls5.length;index++) {
			this.prmtbatch.addDataChangeListener(ls5[index]);
		}
		for(int index=0;index<ls6.length;index++) {
			this.prmtmarginPolicy.addDataChangeListener(ls6[index]);
		}
		for(int index=0;index<ls7.length;index++) {
			this.txtfemaleBreedQty.addDataChangeListener(ls7[index]);
		}
		for(int index=0;index<ls8.length;index++) {
			this.prmtsettlementPolicy.addDataChangeListener(ls8[index]);
		}
	}

	public void loadFields(){
		actionCopy.setVisible(false);
		actionCopy.setEnabled(true);
		isLoadField=true;
		super.loadFields(); 
		isLoadField=false;	
		btnCancel.setVisible(true);
		btnCancelCancel.setVisible(true);
		setUIStatus();
		UITools.apendFootRow(kdtReceiveBillEntry, new String[]{"receiveAmount"});
		setFilter();
	}


	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.beforeStoreFields(e);
		storeFields();
		//		if(StockingComm.checkIsHasSameContract(null, editData.getFarmer().getId().toString(), editData.getFarm().getId().toString(), editData.getBizDate(), true)){
		//			MsgBox.showWarning("存在已审核的同一养殖户/场且同一日期的批次合同,操作失败!");
		//			SysUtil.abort();
		//		}
		if(StockingComm.checkIsHasSameContract(null, editData.getFarmer().getId().toString(), editData.getFarm().getId().toString(), editData.getBizDate(), false)){		
			if(MsgBox.showConfirm2("当前养殖户/场在合同日期的上下7天内已有批次合同,是否继续操作?")!=MsgBox.YES){
				return;
			}
		}
		checkIsHasUnSettle();
		super.actionSave_actionPerformed(e);
	}

	private void checkIsHasUnSettle() {
		try {
			String curBatchContractID=null;
			if(editData.getId()!=null){
				curBatchContractID=editData.getId().toString();
			}
			Boolean isHasUnSettledBatch = StockingComm.isHasUnSettledBatch(null, ((IPropertyContainer)prmtfarmer.getValue()).getString("id"), ((IPropertyContainer)prmtfarm.getValue()).getString("id"),curBatchContractID);
			SettlePolicyInfo policy = SettlePolicyFactory.getRemoteInstance().getSettlePolicyInfo(new ObjectUuidPK(((IPropertyContainer)prmtsettlementPolicy.getValue()).getString("id")));
			boolean isForbidUnSettle = UIRuleUtil.getBooleanValue(policy.isIsForbidUnSettle());
			if(isForbidUnSettle){
				if(isHasUnSettledBatch){
					MsgBox.showWarning("该养殖户/场存在未结算的批次合同,操作失败!");
					SysUtil.abort();
				}
			}else{
				if(isHasUnSettledBatch){
					MsgBox.showWarning("该养殖户/场存在未结算的批次合同,请注意!");
				}
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setUIStatus() {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(true);
			this.actionEdit.setEnabled(false);
			this.actionCancel.setEnabled(false);
			this.actionSave.setEnabled(false);
			this.actionSubmit.setEnabled(false);
		}else if (this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)){
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(false);
			this.actionCancelCancel.setEnabled(false);
			this.actionCancel.setEnabled(false);
		}else if (this.editData.getBillStatus().equals(BillBaseStatusEnum.cancel)){
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(false);
			this.actionCancelCancel.setEnabled(true);
			this.actionEdit.setEnabled(false);
			this.actionCancel.setEnabled(false);
			this.actionSave.setEnabled(false);
			this.actionSubmit.setEnabled(false);
		}else if (this.editData.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)){
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(false);
			this.actionCancelCancel.setEnabled(false);
			this.actionCancel.setEnabled(true);
		}else{
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(false);
			this.actionCancelCancel.setEnabled(false);
			this.actionCancel.setEnabled(false);
			this.actionEdit.setEnabled(true);
		}
	}



	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.beforeStoreFields(e);
		storeFields();
		//		if(StockingComm.checkIsHasSameContract(null, editData.getFarmer().getId().toString(), editData.getFarm().getId().toString(), editData.getBizDate(), true)){
		//			MsgBox.showWarning("存在已审核的同一养殖户/场且同一日期的批次合同,操作失败!");
		//			SysUtil.abort();
		//		}
		if(StockingComm.checkIsHasSameContract(null, editData.getFarmer().getId().toString(), editData.getFarm().getId().toString(), editData.getBizDate(), false)){		
			if(MsgBox.showConfirm2("当前养殖户/场在合同日期的上下7天内已有批次合同,是否继续操作?")!=MsgBox.YES){
				return;
			}
		}
		checkIsHasUnSettle();
		super.actionSubmit_actionPerformed(e);
		if(editData.getId()==null)
			super.actionPre_actionPerformed(e);
	}
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)||this.editData.getBillStatus().equals(BillBaseStatusEnum.cancel)) {
			MsgBox.showWarning("单据已经审核或禁用，禁止修改！");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(e);
	}

	@Override
	public void actionCancelCancel_actionPerformed(ActionEvent e)
	throws Exception {
		checkIsHasUnSettle();
		super.actionCancelCancel_actionPerformed(e);
	}

	@Override
	public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
		if(UIRuleUtil.getBigDecimal(txtusedMargin.getBigDecimalValue()).signum()!=0){
			MsgBox.showWarning("实际用保证金不为0，操作失败！");
			SysUtil.abort();
		}
		super.actionCancel_actionPerformed(e);
	}

	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)||this.editData.getBillStatus().equals(BillBaseStatusEnum.cancel)) {
			MsgBox.showWarning("单据已经审核或禁用，禁止修改！");
			SysUtil.abort();
		}
		//		try{
		super.actionRemove_actionPerformed(e);
		//		}catch(Exception e1){
		//			throw new Exception(e1.getMessage());
		//		}
	}

	@Override
	public void actionViewGuaranteeBill_actionPerformed(ActionEvent e)
	throws Exception {
		if(prmtguaranty.getValue()==null){
			MsgBox.showWarning("该单据未关联担保书!");
			SysUtil.abort();
		}
		String billID=((IPropertyContainer)prmtguaranty.getValue()).getString("id");
		UIContext uiContext = new UIContext(this);
		uiContext.put("ID", billID);
		IUIWindow uiWindow = null;
		if (SwingUtilities.getWindowAncestor(this) != null
				&& (SwingUtilities.getWindowAncestor(this) instanceof JDialog))
			uiWindow = UIFactory.createUIFactory(
			"com.kingdee.eas.base.uiframe.client.UIModelDialogFactory")
			.create("com.kingdee.eas.farm.carnivorous.basebiz.client.FarmerGuaranteeBillEditUI", uiContext, null, OprtState.VIEW);
		else
			uiWindow = UIFactory.createUIFactory(getEditUIModal()).create(
					"com.kingdee.eas.farm.carnivorous.basebiz.client.FarmerGuaranteeBillEditUI", uiContext, null, OprtState.VIEW);
		uiWindow.show();
	}

	@Override
	public void actionChangIsFeedBig_actionPerformed(ActionEvent e)
	throws Exception {
		if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("只能对已审核且未结算的合同进行变更!");
			SysUtil.abort();
		}
		BatchContractBillFactory.getRemoteInstance().changeIsFeedBig(editData);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("变更成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
		setUIStatus();
	}

	protected String getEditUIModal() {
		String openModel = UIConfigUtility.getOpenModel();
		if (openModel != null)
			return openModel;
		else
			return "com.kingdee.eas.base.uiframe.client.UINewFrameFactory";
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
		beforeStoreFields(e);
		super.actionAudit_actionPerformed(e);

		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		lockUIForViewStatus();
		setOprtState(STATUS_VIEW);
		setNextMessageText("审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
		setUIStatus();
	}
	/**
	 * output actionUnAudit_actionPerformed
	 */
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception{
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
		setUIStatus();
	}

	@Override
	public void actionRevoke_actionPerformed(ActionEvent e) throws Exception {
		if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据尚未审核，禁止作废！");
			SysUtil.abort();
		}
		if(MsgBox.showConfirm2("作废操作不可撤销,是否继续?")!=MsgBox.YES){
			return;
		}
		super.actionRevoke_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("作废成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
		setUIStatus();
	}

	public void storeFields(){
		super.storeFields();
	}

	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception{
		return com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory.getRemoteInstance();
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
		com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new java.util.Date());
		objectValue.setContractDate(new java.util.Date());
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setBillStatus(BillBaseStatusEnum.ADD);
		objectValue.setBreedType(StockingTypeEnum.Business);
		objectValue.setContractType(ContractType.contract);
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		objectValue.setUsedMargin(BigDecimal.ZERO);


		return objectValue;
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		sysSetting =  StockingComm.getSystemSettingInfo(null, SysContext.getSysContext().getCurrentFIUnit().getString("id"));
		super.onLoad();
		curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
		initControl();
		if(oprtState.equals("ADDNEW"))
			contractType.setSelectedItem(ContractType.contract);
	}

	private void initControl() {
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));

		CompanyF7 cf7=new CompanyF7();
		cf7.setIsCUFilter(true);
		this.prmtcompany.setSelector(cf7);

		this.prmtMarginBill.setDisplayFormat("$number$");
		this.prmtMarginBill.setRequired(true);
		this.prmtperson.setRequired(true);
		this.txtfemaleBreedQty.setRequired(true);

		this.prmthouse.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.carviousFarmHouseQuery");		
		this.prmthouse.setVisible(true);		
		this.prmthouse.setEditable(true);		
		this.prmthouse.setDisplayFormat("$name$");		
		this.prmthouse.setEditFormat("$number$");		
		this.prmthouse.setCommitFormat("$number$");		
		this.prmthouse.setRequired(false);

		// prmtbreedData		
		this.prmtbreedData.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.BreedDataQuery");		
		this.prmtbreedData.setEditable(true);		
		this.prmtbreedData.setDisplayFormat("$name$");		
		this.prmtbreedData.setEditFormat("$number$");		
		this.prmtbreedData.setCommitFormat("$number$");		
		this.prmtbreedData.setRequired(true);


		setFilter();

		pkBizDate.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				setConFeedContract();
				setGuaranty();
				setFilter();
				pkcontractDate.setValue(pkBizDate.getValue());
			}
		});

		this.prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setFilter();
			}});

		prmtsettlementPolicy.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {
				setBreedPrice();
			}
		});

		prmtconFeedContract.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				if(prmtconFeedContract.getValue()!=null){
					try {
						SelectorItemCollection slor=new SelectorItemCollection();
						slor.add("*");
						slor.add("conFeedPolicy.*");
						slor.add("PolicyEntry.*");
						ConFeedContractInfo conFeedContractInfo = ConFeedContractFactory.getRemoteInstance().getConFeedContractInfo(new ObjectUuidPK(((IPropertyContainer)prmtconFeedContract.getValue()).getString("id")), slor);
						ConFeedContractPolicyEntryCollection entrys=conFeedContractInfo.getPolicyEntry();
						for(int i=0;i<entrys.size();i++){
							if(entrys.get(i).isIsDefault()){
								ConFeedPolicyInfo policy=ConFeedPolicyFactory.getRemoteInstance().getConFeedPolicyInfo(new ObjectUuidPK(entrys.get(i).getConfeedPolicy().getId()));
								prmtconFeedPolicy.setValue(policy);	
								txtsubsidyPrice.setValue(policy.getSubsidy());
							}
						}
					} catch (EASBizException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BOSException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{					
					txtsubsidyPrice.setValue(null);
					prmtconFeedPolicy.setValue(null);
				}
				setFilter();
			}});

		prmtfarmer.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				// TODO Auto-generated method stub
				farmer_changed(e);
				setConFeedContract();
				setFilter();
			}});

		//养殖场变更事件
		prmtfarm.addDataChangeListener(new DataChangeListener(){

			public void dataChanged(DataChangeEvent e) {
				// TODO Auto-generated method stub
				farm_changed(e);
				setConFeedContract();
				setFilter();
			}});

		//棚舍变更事件
		prmthouse.addDataChangeListener(new DataChangeListener(){

			public void dataChanged(DataChangeEvent e) {
				// TODO Auto-generated method stub
				//设置成本中心
				setconstCnter();
			}});

		//批次变更事件
		prmtbatch.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				batch_changed(arg0);
			}
		});


		//保证金改变事件
		prmtmarginPolicy.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				marginPolicy_changed(arg0);
			}
		});

		txtfemaleBreedQty.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				marginPolicy_changed(arg0);
				if(UIRuleUtil.getBigDecimal(txtfemaleBreedQty.getBigDecimalValue()).signum()!=0){
					txtactualSingleMargin.setValue(UIRuleUtil.getBigDecimal(txtusedMargin.getBigDecimalValue()).divide(UIRuleUtil.getBigDecimal(txtfemaleBreedQty.getBigDecimalValue()),2,RoundingMode.HALF_UP));
				}else{
					txtactualSingleMargin.setValue(BigDecimal.ZERO);
				}
			}
		});

		txtusedMargin.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				if(UIRuleUtil.getBigDecimal(txtfemaleBreedQty.getBigDecimalValue()).signum()!=0){
					txtactualSingleMargin.setValue(UIRuleUtil.getBigDecimal(txtusedMargin.getBigDecimalValue()).divide(UIRuleUtil.getBigDecimal(txtfemaleBreedQty.getBigDecimalValue()),2,RoundingMode.HALF_UP));
				}else{
					txtactualSingleMargin.setValue(BigDecimal.ZERO);
				}
			}
		});

		//品种改变事件
		prmtbreedData.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				setFilter();
				prmtsettlementPolicy.setValue(null);
				prmtmarginPolicy.setValue(null);
				setBreedPrice();


				//				prmtbreedData.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.BreedDataQuery");		
				//				prmtbreedData.setEditable(true);		
				//				prmtbreedData.setDisplayFormat("$name$");		
				//				prmtbreedData.setEditFormat("$number$");		
				//				prmtbreedData.setCommitFormat("$number$");		
				//				prmtbreedData.setRequired(true);
				//
				//				SelectorListener[] ls = prmtbreedData.getSelectorListeners();
				//				for(int i=0;i<ls.length;i++) {
				//					prmtbreedData.removeSelectorListener(ls[i]);
				//				}
				//				FilterInfo filter=new FilterInfo();
				//				filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.ENABLE_VALUE,CompareType.EQUALS));
				//				filter.getFilterItems().add(new FilterItemInfo("generateType",GenerateType.Commerce,CompareType.EQUALS));
				//				EntityViewInfo evi=new EntityViewInfo();
				//				evi.setFilter(filter);
				//				prmtbreedData.setEntityViewInfo(evi);

			}
		});
	}

	private void setBreedPrice() {
		// TODO Auto-generated method stub
		if(prmtbreedData.getValue()!=null&&prmtsettlementPolicy.getValue()!=null){
			ArrayList<String> seedIDs=StockingComm.getSeedIDs(null, ((IPropertyContainer)prmtbreedData.getValue()).getString("id"));
			if(seedIDs.size()==0||seedIDs.size()>1){
				MsgBox.showWarning("品种资料对应种苗物料未维护或维护了多个!");
				txtbreedPrice.setValue(null);
			}else{
				BigDecimal price = StockingComm.getBasePrice(null,((IPropertyContainer)prmtsettlementPolicy.getValue()).getString("id"),seedIDs.get(0));
				txtbreedPrice.setValue(price);
			}
		}else{
			txtbreedPrice.setValue(null);
		}
	}


	private void setFarmFilter() {
		String farmerID=null;
		if(prmtfarmer.getValue()!=null) {
			farmerID=((IPropertyContainer) prmtfarmer.getValue()).getString("id");
		}
		//养殖场过滤
		StockingComm.setFarmFilter(this.prmtfarm, curCompanyID, farmerID, true);
	}


	private void setConFeedContract() {
		// TODO Auto-generated method stub
		if(this.prmtcompany.getValue()!=null) {
			curCompanyID=((IPropertyContainer) this.prmtcompany.getValue()).getString("id");
		}else{
			curCompanyID=null;
		}
		Date bizDate=null;
		if(this.pkBizDate.getValue()!=null) {
			bizDate=(Date) pkBizDate.getValue();
		}
		String farmerID=null,farmID=null;
		if(prmtfarmer.getValue()!=null) {
			farmerID=((IPropertyContainer) prmtfarmer.getValue()).getString("id");
		}
		if(prmtfarm.getValue()!=null) {
			farmID=((IPropertyContainer) prmtfarm.getValue()).getString("id");
		}
		EntityViewInfo ev = StockingComm.setConFeedContractFilter(prmtconFeedContract, curCompanyID, farmerID, farmID, bizDate);	
		try {
			ConFeedContractCollection conFeedContractCollection = ConFeedContractFactory.getRemoteInstance().getConFeedContractCollection(ev);
			if(conFeedContractCollection.size()>0){
				prmtconFeedContract.setValue(conFeedContractCollection.get(0));
			}else{
				prmtconFeedContract.setValue(null);
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 设置过滤条件
	 * @param companyID
	 */
	private void setFilter() {
		if(this.prmtcompany.getValue()!=null) {
			curCompanyID=((IPropertyContainer) this.prmtcompany.getValue()).getString("id");
		}else{
			curCompanyID=null;
		}
		Date bizDate=null;
		if(this.pkBizDate.getValue()!=null) {
			bizDate=(Date) pkBizDate.getValue();
		}
		//品种过滤
		StockingComm.setBreedDataFilter(prmtbreedData,GenerateType.Commerce);



		//人员过滤
		com.kingdee.eas.farm.stocking.common.StockingClientComm.makeApplierF7(this.prmtperson, curCompanyID, this, false);
		//批次过滤
		String farmerID=null,farmID=null;
		if(prmtfarmer.getValue()!=null) {
			farmerID=((IPropertyContainer) prmtfarmer.getValue()).getString("id");
		}
		if(prmtfarm.getValue()!=null) {
			farmID=((IPropertyContainer) prmtfarm.getValue()).getString("id");
		}
		//养殖户过滤
		StockingComm.setFarmerFilter(prmtfarmer, curCompanyID,false);
		setFarmFilter();
		//设置担保申请表过滤
		StockingComm.setGuaranteeBillFilter(prmtguaranty, curCompanyID,farmerID,bizDate);
		//设置连养合同过滤条件
		StockingComm.setConFeedContractFilter(prmtconFeedContract, curCompanyID, farmerID, farmID, bizDate);	
		//设置结算政策过滤
		StockingComm.setSettlementPolicyFilter(prmtsettlementPolicy, pkBizDate, curCompanyID, prmtbreedData,true);
		//设置保证金政策过滤
		StockingComm.setMarginPolicyFilter(prmtmarginPolicy, curCompanyID, bizDate, prmtbreedData, true);
		//设置连养政策过滤
		StockingComm.setConFeedPolicyFilter(prmtconFeedPolicy, curCompanyID, bizDate);
		//设置屠宰点过滤
		StockingComm.setCalUnitFilter(prmtslaughterPoint, curCompanyID);
	}


	@Override
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if(prmtfarmer.getValue()!=null){
			String id = ((IPropertyContainer)prmtfarmer.getValue()).getString("id");
			FarmerInfo farmerInfo = FarmerFactory.getRemoteInstance().getFarmerInfo(new ObjectUuidPK(id));
			txttotalMargin.setValue(farmerInfo.getTotalMargin());
			txtoccupyMargin.setValue(farmerInfo.getOccupyMargin());
			txtenableMargin.setValue(farmerInfo.getEnableMargin());
			FarmInfo farmInfo = (FarmInfo) prmtfarm.getValue();
			farmInfo = FarmFactory.getRemoteInstance().getFarmInfo(new ObjectUuidPK(farmInfo.getId()));
			//公司自养，棚舍必填
			if(!farmInfo.getFarmType().equals(StockingFarmTypeEnum.stocking)){
				if(prmthouse.getValue() == null){
					MsgBox.showWarning("养殖类型为自养，棚舍为必录项！");
					SysUtil.abort();
				}
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtperson.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务员"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtfemaleBreedQty.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"合同数量"});
		}

		if(txtusedMargin.getBigDecimalValue()==null){
			txtusedMargin.setValue(BigDecimal.ZERO);
		}
		BigDecimal usedMargin=txtusedMargin.getBigDecimalValue()==null?BigDecimal.ZERO:txtusedMargin.getBigDecimalValue();
		BigDecimal enableMargin=txtenableMargin.getBigDecimalValue()==null?BigDecimal.ZERO:txtenableMargin.getBigDecimalValue();

		if(usedMargin.abs().compareTo(enableMargin.abs())>0){
			MsgBox.showWarning("实际用保证金的绝对值不能大于可用保证金的绝对值");
			SysUtil.abort();
		}
		if(!this.chkisTemplate.isSelected()) {
			super.beforeStoreFields(arg0);
		}

		if(prmtfarm.getValue()!=null){
			Boolean isHasUnRecContract = StockingComm.isHasUnRecContract(null, ((IPropertyContainer)prmtfarm.getValue()).getString("id"));
			//			if(isHasUnRecContract){
			//				MsgBox.showWarning("该养殖场包含未交鸡批次,操作失败!");
			//				SysUtil.abort();
			//			}
		}
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
		editData.setBillStatus(BillBaseStatusEnum.ADD);
		editData.setFarmer(null);
		editData.setBizDate(new java.util.Date());
		setOprtState("ADDNEW");
		setDataObject(editData);
		loadFields();
		showCopyAddNew();
		actionCopy.setEnabled(false);
		chkMenuItemSubmitAndAddNew.setVisible(true);
		setDefaultFocused();

		setMakeRelations(null);
	}


	private void setGuaranty() {
		if(prmtfarmer.getValue()==null||pkBizDate.getValue()==null){
			prmtguaranty.setValue(null);
			return;
		}
		String id = ((IPropertyContainer)prmtfarmer.getValue()).getString("id");
		FarmerGuaranteeBillInfo guaranteeBill = StockingComm.getGuaranteeBill(null,id,(Date) pkBizDate.getValue());
		prmtguaranty.setValue(guaranteeBill);
	}

	private void farmer_changed(DataChangeEvent arg0) {
		DataChangeListener[] farmLis = ListenerUtil.F7GetDateChangeListener(prmtfarm);
		if(prmtfarmer.getValue()!=null){
			try {
				ListenerUtil.F7RemoveDateChangeListener(prmtfarm);
				StockingComm.setFarmInfoByFarmer(prmtfarmer,prmtfarm);
				if(prmtfarm.getValue()!=null){
					txtfarmAddress.setText((String) UIRuleUtil.getProperty((IObjectValue) prmtfarm.getValue(), "address"));
				}
				ListenerUtil.F7AddDateChangeListener(prmtfarm, farmLis);
				String id = ((IPropertyContainer)prmtfarmer.getValue()).getString("id");
				SelectorItemCollection slor=new SelectorItemCollection();
				slor.add("*");
				FarmerInfo farmerInfo = FarmerFactory.getRemoteInstance().getFarmerInfo(new ObjectUuidPK(id), slor);
				setGuaranty();
				txtmobileTel.setStringValue(farmerInfo.getMobileTel());
				txtidentity.setStringValue(farmerInfo.getIdentity());
				txttotalMargin.setValue(farmerInfo.getTotalMargin());
				txtoccupyMargin.setValue(farmerInfo.getOccupyMargin());
				txtenableMargin.setValue(farmerInfo.getEnableMargin());
				if(farmerInfo.getPerson()!=null){
					PersonInfo person=PersonFactory.getRemoteInstance().getPersonInfo(new ObjectUuidPK(farmerInfo.getPerson().getId()));
					prmtperson.setValue(person);}
				prmtconFeedContract.setValue(null);
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			txtmobileTel.setStringValue(null);
			txtidentity.setStringValue(null);
			txttotalMargin.setValue(null);
			txtoccupyMargin.setValue(null);
			txtenableMargin.setValue(null);
			prmtfarm.setValue(null);
			prmtperson.setValue(null);
			prmtconFeedContract.setValue(null);
			prmtguaranty.setValue(null);
		}
		farm_changed(arg0);
	}

	private void farm_changed(DataChangeEvent e) {
		DataChangeListener[] conFeedLis = ListenerUtil.F7GetDateChangeListener(prmtconFeedContract);
		if(prmtfarm.getValue()!=null){
			FarmerInfo farmerInfo = StockingComm.getFarmerInfoByFarm(null,prmtfarm);
			DataChangeListener[] farmerLis = ListenerUtil.F7GetDateChangeListener(prmtfarmer);
			ListenerUtil.F7RemoveDateChangeListener(prmtfarmer);
			prmtfarmer.setValue(farmerInfo);
			ListenerUtil.F7AddDateChangeListener(prmtfarmer, farmerLis);
			try {
				txtmobileTel.setStringValue(farmerInfo.getMobileTel());
				txtidentity.setStringValue(farmerInfo.getIdentity());
				txttotalMargin.setValue(farmerInfo.getTotalMargin());
				txtoccupyMargin.setValue(farmerInfo.getOccupyMargin());
				txtenableMargin.setValue(farmerInfo.getEnableMargin());
				if(farmerInfo.getPerson()!=null){
					PersonInfo person=PersonFactory.getRemoteInstance().getPersonInfo(new ObjectUuidPK(farmerInfo.getPerson().getId()));
					prmtperson.setValue(person);
				}
				FarmsType type=UIRuleUtil.getProperty((IObjectValue) prmtfarm.getValue(),"faemsType")==null?null:(FarmsType) UIRuleUtil.getProperty((IObjectValue) prmtfarm.getValue(),"faemsType");
				farmsType.setSelectedItem(type);
				prmtconFeedContract.setValue(null);

				//根据养殖场自动带出里程数
				FarmInfo farmInfo = (FarmInfo) prmtfarm.getValue();
				farmInfo = FarmFactory.getRemoteInstance().getFarmInfo(new ObjectUuidPK(farmInfo.getId()));
				if(farmInfo.getMileStd() != null){
					txtfeedInstance.setValue(farmInfo.getMileStd());
				}
				//设置成本中心
				setconstCnter();
			} catch (DataAccessException e1) {
				e1.printStackTrace();
			} catch (BOSException e1) {
				e1.printStackTrace();
			}catch (EASBizException e1) {
				e1.printStackTrace();
			}
		}else{
			prmtbatch.setValue(null);
			farmsType.setSelectedItem(null);
			prmtconFeedContract.setValue(null);
		}
	}

	/**
	 * 设置成本中心
	 */
	private void setconstCnter() {
		// TODO Auto-generated method stub
		try {
			if(prmtfarm.getValue() != null){
				FarmInfo farmInfo = (FarmInfo) prmtfarm.getValue();
				farmInfo = FarmFactory.getRemoteInstance().getFarmInfo(new ObjectUuidPK(farmInfo.getId()));
				//如果是养户放养-成本中心取养殖场资料的成本中心
				if(farmInfo.getFarmType().equals(StockingFarmTypeEnum.stocking)){
					CostCenterOrgUnitInfo costInfo = farmInfo.getCostCenter();
					if(costInfo != null){
						costInfo = CostCenterOrgUnitFactory.getRemoteInstance().getCostCenterOrgUnitInfo(new ObjectUuidPK(costInfo.getId()));
						prmtcostCenter.setValue(costInfo);
						prmthouse.setValue(null);
					}
				}else{
					if(prmthouse.getValue() != null){
						FarmHouseEntryInfo houseInfo = (FarmHouseEntryInfo) prmthouse.getValue();
						FarmHouseEntryCollection entryColl = farmInfo.getHouseEntry();
						FarmHouseEntryInfo entryInfo = null;
						for(int i = 0,size = entryColl.size();i<size;i++){
							entryInfo = FarmHouseEntryFactory.getRemoteInstance().getFarmHouseEntryInfo(new ObjectUuidPK(entryColl.get(i).getId()));
							System.out.println("-------------------------");
							System.out.println(houseInfo.getId().toString()+houseInfo.getNumber());
							System.out.println(entryInfo.getId().toString()+entryInfo.getNumber());
							System.out.println("---------------------------");
							if(houseInfo.getId().toString().equalsIgnoreCase(entryInfo.getId().toString())){
								CostCenterOrgUnitInfo costInfo = entryInfo.getCostCentor();
								costInfo = CostCenterOrgUnitFactory.getRemoteInstance().getCostCenterOrgUnitInfo(new ObjectUuidPK(costInfo.getId()));
								prmtcostCenter.setValue(costInfo); 
								break;
							}else{
								prmtcostCenter.setValue(null);
							}
						}
					}
				}
			}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void marginPolicy_changed(DataChangeEvent e) {
		// TODO Auto-generated method stub
		if(prmtmarginPolicy.getValue()!=null){
			String policyID=((IPropertyContainer)prmtmarginPolicy.getValue()).getString("id");
			try {
				MarginPolicyInfo info=MarginPolicyFactory.getRemoteInstance().getMarginPolicyInfo(new ObjectUuidPK(policyID));
				BigDecimal standardPrice=info.getSingleMargin()==null?BigDecimal.ZERO:info.getSingleMargin();
				BigDecimal minPrice=info.getMinMargin()==null?BigDecimal.ZERO:info.getMinMargin();
				BigDecimal qty=	txtfemaleBreedQty.getBigDecimalValue()==null?BigDecimal.ZERO:txtfemaleBreedQty.getBigDecimalValue();
				txtminMargin.setValue(minPrice.multiply(qty));
				txtstandardMargin.setValue(standardPrice.multiply(qty));			
			} catch (EASBizException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (BOSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} }else{
				txtminMargin.setValue(null);
				txtstandardMargin.setValue(null);
			}

	}

	private void batch_changed(DataChangeEvent arg0) {
		// TODO Auto-generated method stub
		if(prmtbatch.getValue()!=null){
			String batchId = ((IPropertyContainer)prmtbatch.getValue()).getString("id");
			//重复性校验
			String str = "select * from T_FM_BatchContractBill where FBatchID='"+batchId+"'";
			if(editData.getId()!=null)
				str+=" and FID<>'"+editData.getString("id")+"'";
			try {
				if(SQLExecutorFactory.getRemoteInstance(str).executeSQL().size()>0){
					prmtbatch.setValue(null);
					commUtils.giveUserTipsAndRetire("当前批次已被其他合同引用");
				}
			} catch (BOSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("*");
			slor.add("farmer.*");
			slor.add("farm.*");
			slor.add("breedData.*");
			slor.add("person.*");
			slor.add("bizPerson.*");
			try {
				BatchInfo batchInfo = BatchFactory.getRemoteInstance().getBatchInfo(new ObjectUuidPK(batchId),slor);
				DataChangeListener[] farmerLis = ListenerUtil.F7GetDateChangeListener(prmtfarmer);
				DataChangeListener[] farmerLis2 = ListenerUtil.F7GetDateChangeListener(prmtfarm);
				ListenerUtil.F7RemoveDateChangeListener(prmtfarmer);
				ListenerUtil.F7RemoveDateChangeListener(prmtfarm);
				prmtfarmer.setValue(batchInfo.getFarmer());
				txtidentity.setStringValue(batchInfo.getFarmer().getIdentity());
				txtmobileTel.setStringValue(batchInfo.getFarmer().getMobileTel());
				prmtfarm.setValue(batchInfo.getFarm());
				ListenerUtil.F7AddDateChangeListener(prmtfarmer, farmerLis);
				ListenerUtil.F7AddDateChangeListener(prmtfarm, farmerLis2);

				pkactualBreedDate.setValue(batchInfo.getInDate());
				txtactualFemaleQty.setValue(batchInfo.getFemaleQty());
				txtfemaleBreedQty.setValue(batchInfo.getFemaleQty());
				if(prmtsettlementPolicy.getValue()!=null){
					String id = ((IPropertyContainer)prmtsettlementPolicy.getValue()).getString("id");
					SelectorItemCollection selector=new SelectorItemCollection();
					selector.add("*");
					SettlePolicyInfo policyInfo = SettlePolicyFactory.getRemoteInstance().getSettlePolicyInfo(new ObjectUuidPK(id), selector);
					pkpreditRecDate.setValue(DateUtilsComm.addDays(batchInfo.getInDate(), policyInfo.getOutDaysStd()));
				}else
					pkpreditRecDate.setValue(DateUtilsComm.addDays(batchInfo.getInDate(), 0));
				prmtbreedData.setValue(batchInfo.getBreedData());

				//带出采购员和技术员
				BreedSeedReceiveBillCollection coll = BreedSeedReceiveBillFactory.getRemoteInstance().getBreedSeedReceiveBillCollection("where batch='"+batchId+"'");
				if(coll.size()>0){
					BreedSeedReceiveBillInfo receiveBillInfo = coll.get(0);
					slor=new SelectorItemCollection();
					slor.add("person.*");
					slor.add("bizPerson.*");
					BreedSeedReceiveBillInfo breedSeedReceiveBillInfo = BreedSeedReceiveBillFactory.getRemoteInstance().getBreedSeedReceiveBillInfo(new ObjectUuidPK(receiveBillInfo.getString("id")),slor);
					prmtperson.setValue(breedSeedReceiveBillInfo.getPerson());
				}
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}