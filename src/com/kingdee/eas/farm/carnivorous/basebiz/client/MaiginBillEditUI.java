/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basebiz.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.SwingUtilities;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.DataAccessException;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.kscript.debug.SetValue;
import com.kingdee.bos.metadata.bot.BOTRelationFactory;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.basedata.assistant.IPrintIntegration;
import com.kingdee.eas.basedata.assistant.PrintIntegrationFactory;
import com.kingdee.eas.basedata.assistant.PrintIntegrationInfo;
import com.kingdee.eas.basedata.assistant.util.CommonPrintIntegrationDataProvider;
import com.kingdee.eas.basedata.assistant.util.PrintIntegrationManager;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.UIUtil;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.farm.carnivorous.basebiz.FarmerGuaranteeBillInfo;
import com.kingdee.eas.farm.carnivorous.basebiz.MaiginBillFactory;
import com.kingdee.eas.farm.carnivorous.basebiz.MaiginBillInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo;
import com.kingdee.eas.framework.print.MultiapproveDataProvider;
import com.kingdee.eas.framework.util.UIConfigUtility;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.util.MultiDataSourceDataProviderProxy;
import com.kingdee.eas.scm.common.util.SCMCommonDataProvider;
import com.kingdee.eas.scm.im.inv.client.InvClientUtils;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class MaiginBillEditUI extends AbstractMaiginBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(MaiginBillEditUI.class);
	private boolean isLoadField=false;
	/**
	 * output class constructor
	 */
	public MaiginBillEditUI() throws Exception
	{
		super();
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		btnAudit.setIcon(ClientUtils.AuditIcon);
		btnUnAudit.setIcon(ClientUtils.UnAuditIcon);
		setUITitle("保证金收退单");
		initControl();
	}

	private void initControl() {
		// TODO Auto-generated method stub
		kdtEntrys_detailPanel.getEntryTable().setEditable(false);
		kdtEntrys_detailPanel.getAddNewLineButton().setVisible(false);
		kdtEntrys_detailPanel.getInsertLineButton().setVisible(false);
		kdtEntrys_detailPanel.getRemoveLinesButton().setVisible(false);
		kdtEntrys_detailPanel.getEntryTable().getStyleAttributes().setLocked(true); 

		//生成凭证按钮可见可编辑
		btnVoucher.setVisible(true);
		btnVoucher.setEnabled(true);



		moneySource.setEnabled(true);	
		if(!oprtState.equalsIgnoreCase("view")){
			if(bizType.getSelectedItem()!=null){
				if(bizType.getSelectedItem()==com.kingdee.eas.farm.carnivorous.basebiz.bizType.receive){
					moneySource.setEnabled(true);	
					chkliquidated.setEnabled(false);
				}else{
					moneySource.setEnabled(false);	
					chkliquidated.setEnabled(true);
				}
			}
			chkliquidated_changed();
		}

		DataChangeListener setActualListener=new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setActualData();
				setActualPayAmt();
			}
		};
		txtkConFeedSubsidy.addDataChangeListener(setActualListener);
		txtkOtherAmt.addDataChangeListener(setActualListener);
		txtkPolicySubsidy.addDataChangeListener(setActualListener);
		txtkPunishAmt.addDataChangeListener(setActualListener);
		txtpayAmount.addDataChangeListener(setActualListener);

		DataChangeListener setAcPayListener=new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setActualPayAmt();
			}
		};

		txtactualKConFeedSub.addDataChangeListener(setAcPayListener);
		txtactualKOtherAmt.addDataChangeListener(setAcPayListener);
		txtactualKPolicySub.addDataChangeListener(setAcPayListener);
		txtactualKPunishAmt.addDataChangeListener(setAcPayListener);

		pkBizDate.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				setGuaranty();
				setFilter();
			}
		});

		prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent areg0) {
				if(prmtcompany.getValue()!=null){
					setFilter();
				}
			}	
		});

		prmtfarmer.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				kdtEntrys.removeRows();
				if(prmtfarmer.getValue()!=null){
					try {
						SelectorItemCollection slor =new SelectorItemCollection();
						slor.add("*");
						slor.add("person.*");
						slor.add("bEBank.*");
						FarmerInfo farmer=FarmerFactory.getRemoteInstance().getFarmerInfo(new ObjectUuidPK(((IPropertyContainer)prmtfarmer.getValue()).getString("id")), slor);				
						setGuaranty();
						//						txttotalMargin.setValue(farmer.getTotalMargin());
						txtoccupyMargin.setValue(farmer.getOccupyMargin());
						txtenableMargin.setValue(farmer.getEnableMargin());
						txtidentity.setText(farmer.getIdentity());
						txtbankNo.setText(farmer.getBankNo());
						prmtbEBank.setValue(farmer.getBEBank());
						txtphone.setText(farmer.getMobileTel());
						prmtperson.setValue(farmer.getPerson());
						setEntrys(farmer.getId().toString());
					} catch (DataAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BOSException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (EASBizException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}else{
					txttotalMargin.setValue(null);
					txtoccupyMargin.setValue(null);
					txtenableMargin.setValue(null);
					txtidentity.setText(null);
					txtbankNo.setText(null);
					txtphone.setText(null);
					prmtperson.setValue(null);
					prmtbEBank.setValue(null);
					prmtguaranty.setValue(null);
					kdtEntrys.removeRows();
				}	
				chkliquidated_changed();
				setfiels();
			}
		});

		prmtfarm.addDataChangeListener(new DataChangeListener(){

			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub

				if(prmtfarm.getValue() != null && !billStatus.getSelectedItem().equals(BillBaseStatusEnum.AUDITED)){
					FarmInfo farmInfo = (FarmInfo) prmtfarm.getValue();
					txttotalMargin.setValue(farmInfo.getMarginAmt());
				}
			}

		});



		bizType.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(bizType.getSelectedItem()!=null){
					if(bizType.getSelectedItem()==com.kingdee.eas.farm.carnivorous.basebiz.bizType.receive){
						moneySource.setSelectedItem(com.kingdee.eas.farm.carnivorous.basebiz.moneySource.FromSettle);
						moneySource.setEnabled(true);	
						chkliquidated.setEnabled(false);
						chkliquidated.setSelected(false);
						chkliquidated_changed();
					}else{
						moneySource.setEnabled(false);	
						moneySource.setSelectedItem(com.kingdee.eas.farm.carnivorous.basebiz.moneySource.NULL);
						chkliquidated.setEnabled(true);
					}
				}
			}
		});

		chkliquidated.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				chkliquidated_changed();
			}
		});

		setFilter();
	}

	/**
	 * 设置过滤
	 */
	protected void setfiels() {
		// TODO Auto-generated method stub
		String curCompanyID = null;
		if(this.prmtcompany.getValue()!=null) {
			curCompanyID=((IPropertyContainer) this.prmtcompany.getValue()).getString("id");
		}
		String farmerID=prmtfarmer.getValue()==null?"":((FarmerInfo)prmtfarmer.getValue()).getId().toString();
		//养殖场过滤
		StockingComm.setFarmFilter(prmtfarm, curCompanyID, farmerID,true);

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

	private void setActualData() {
		BigDecimal kConFeedSubsidy = UIRuleUtil.getBigDecimal(txtkConFeedSubsidy.getBigDecimalValue());
		BigDecimal kOtherAmt = UIRuleUtil.getBigDecimal(txtkOtherAmt.getBigDecimalValue());
		BigDecimal kPolicySubsidy = UIRuleUtil.getBigDecimal(txtkPolicySubsidy.getBigDecimalValue());
		BigDecimal kPunishAmt = UIRuleUtil.getBigDecimal(txtkPunishAmt.getBigDecimalValue());

		txtactualKConFeedSub.setValue(kConFeedSubsidy);
		txtactualKOtherAmt.setValue(kOtherAmt);
		txtactualKPolicySub.setValue(kPolicySubsidy);
		txtactualKPunishAmt.setValue(kPunishAmt);
	}

	private void setActualPayAmt() {
		BigDecimal kConFeedSubsidy = UIRuleUtil.getBigDecimal(txtactualKConFeedSub.getBigDecimalValue());
		BigDecimal kOtherAmt = UIRuleUtil.getBigDecimal(txtactualKOtherAmt.getBigDecimalValue());
		BigDecimal kPolicySubsidy = UIRuleUtil.getBigDecimal(txtactualKPolicySub.getBigDecimalValue());
		BigDecimal kPunishAmt = UIRuleUtil.getBigDecimal(txtactualKPunishAmt.getBigDecimalValue());
		BigDecimal payAmount = UIRuleUtil.getBigDecimal(txtpayAmount.getBigDecimalValue());
		BigDecimal actualPayAmt=payAmount.subtract(kConFeedSubsidy).subtract(kOtherAmt).subtract(kPolicySubsidy).subtract(kPunishAmt);
		txtactualPayAmt.setValue(actualPayAmt);
	}

	private void chkliquidated_changed() {
		if(!isLoadField){
			if(chkliquidated.isSelected()){
				if(prmtfarmer.getValue()==null){
					MsgBox.showWarning("养殖户未填写!");
					chkliquidated.setSelected(false);
				}else{
					try {
						FarmerInfo farmer=FarmerFactory.getRemoteInstance().getFarmerInfo(new ObjectUuidPK(((IPropertyContainer)prmtfarmer.getValue()).getString("id")));
						if(UIRuleUtil.getBigDecimal(farmer.getOccupyMargin()).signum()!=0){
							MsgBox.showWarning("养殖户的占用保证金不为0,操作失败!");
							chkliquidated.setSelected(false);
						}else{
							txtpayAmount.setEnabled(false);
							txtpayAmount.setValue(UIRuleUtil.getBigDecimal(farmer.getEnableMargin()));
							setActualPayAmt();
						}
					} catch (EASBizException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BOSException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}				
				}}
			if(chkliquidated.isSelected()){
				txtkConFeedSubsidy.setEnabled(true);
				txtkOtherAmt.setEnabled(true);
				txtkPolicySubsidy.setEnabled(true);
				txtkPunishAmt.setEnabled(true);
				txtactualKConFeedSub.setEnabled(true);
				txtactualKOtherAmt.setEnabled(true);
				txtactualKPolicySub.setEnabled(true);
				txtactualKPunishAmt.setEnabled(true);
			}else{
				txtkConFeedSubsidy.setEnabled(false);
				txtkOtherAmt.setEnabled(false);
				txtkPolicySubsidy.setEnabled(false);
				txtkPunishAmt.setEnabled(false);
				txtactualKConFeedSub.setEnabled(false);
				txtactualKOtherAmt.setEnabled(false);
				txtactualKPolicySub.setEnabled(false);
				txtactualKPunishAmt.setEnabled(false);
				txtpayAmount.setEnabled(true);
				txtkConFeedSubsidy.setValue(null);
				txtkOtherAmt.setValue(null);
				txtkPolicySubsidy.setValue(null);
				txtkPunishAmt.setValue(null);
				txtactualKConFeedSub.setValue(null);
				txtactualKOtherAmt.setValue(null);
				txtactualKPolicySub.setValue(null);
				txtactualKPunishAmt.setValue(null);
				txtactualPayAmt.setValue(null);
			}
		}
	}


	@Override
	protected void verifyInput(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.verifyInput(e);

		if(editData.getPayAmount()!=null&&editData.getPayAmount().signum()==0){
			MsgBox.showWarning("保证金不能为空或等于0！");
			SysUtil.abort();
		}

		if(editData.getBizType()==com.kingdee.eas.farm.carnivorous.basebiz.bizType.returnBack){
			BigDecimal payAmount =editData.getPayAmount()==null?BigDecimal.ZERO:editData.getPayAmount();
			BigDecimal enableMargin = editData.getTotalMargin()==null?BigDecimal.ZERO:editData.getTotalMargin();
			if(payAmount.compareTo(enableMargin)>0){
				MsgBox.showWarning("退还保证金不能大于可用保证金！");
				SysUtil.abort();
			}
		}else{
			if(editData.getMoneySource()==null||editData.getMoneySource()==com.kingdee.eas.farm.carnivorous.basebiz.moneySource.NULL){
				MsgBox.showWarning("收取保证金时,款项来源不能为空！");
				SysUtil.abort();
			}
			if(editData.getMoneySource()==com.kingdee.eas.farm.carnivorous.basebiz.moneySource.Arrears&&txtpayAmount.getBigDecimalValue().signum()>=0){
				MsgBox.showWarning("款项来源为赊借款时,本次保证金金额必须为负数！");
				SysUtil.abort();
			}
		}
		if(editData.getMoneySource()==null||editData.getMoneySource()!=com.kingdee.eas.farm.carnivorous.basebiz.moneySource.Arrears){
			if(txtpayAmount.getBigDecimalValue().signum()<=0){
				MsgBox.showWarning("退保证金或收保证金且款项来源不为赊借款时,本次保证金金额必须为正数！");
				SysUtil.abort();
			}
		}
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
	}


	private void setEntrys(String farmerID) {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select fid from T_FM_BatchContractBill")
			.append(" where FFarmerID='").append(farmerID).append("'")
			.append(" and FBillStatus=").append(4).append(" order by FFarmID asc,FBizDate desc");
			IRowSet rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			while(rs.next()) {
				SelectorItemCollection slor=new SelectorItemCollection();
				slor.add("*");
				slor.add("breedData.*");
				slor.add("farm.*");
				BatchContractBillInfo batchContract = BatchContractBillFactory.getRemoteInstance().getBatchContractBillInfo(new ObjectUuidPK(rs.getString("fid")),slor);
				IRow row = kdtEntrys.addRow();
				row.getCell("farm").setValue(batchContract.getFarm());
				row.getCell("inDate").setValue(batchContract.getActualBreedDate());
				row.getCell("batchContract").setValue(batchContract);
				row.getCell("breedData").setValue(batchContract.getBreedData());
				row.getCell("batchQty").setValue(batchContract.getActualFemaleQty());
				row.getCell("contractQty").setValue(batchContract.getFemaleBreedQty());
				BigDecimal usedMargin = UIRuleUtil.getBigDecimal(batchContract.getUsedMargin());
				row.getCell("minMargin").setValue(usedMargin);
				BigDecimal actualFemaleQty = UIRuleUtil.getBigDecimal(batchContract.getActualFemaleQty());			
				row.getCell("singleMargin").setValue(actualFemaleQty.signum()==0?BigDecimal.ZERO:usedMargin.divide(actualFemaleQty,2,RoundingMode.HALF_UP));
				row.getCell("status").setValue(UIRuleUtil.getBooleanValue(batchContract.isIsRecSettled())?"已结算":"在养");
			}		
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void actionVoucher_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionVoucher_actionPerformed(e);
		if(editData.getId()==null)
			return;
		//校验生成凭证
		ArrayList<String> destObejctIDs = BOTRelationFactory.getRemoteInstance().getDestObjIdByDestType(editData.getId().toString(), "2652E01E");
		if(destObejctIDs.size()==1){
			CommFacadeFactory.getRemoteInstance().excuteUpdateSql("update CT_FM_MaiginBill set CFVoucherNumID='"+destObejctIDs.get(0)+"' where fid='"+editData.getString("id")+"'");
		}
		UIUtil.refreshEditUI(this);
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

	protected String getEditUIModal() {
		String openModel = UIConfigUtility.getOpenModel();
		if (openModel != null)
			return openModel;
		else
			return "com.kingdee.eas.base.uiframe.client.UINewFrameFactory";
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
		if(bizType.getSelectedItem()!=null){
			if(bizType.getSelectedItem()==com.kingdee.eas.farm.carnivorous.basebiz.bizType.receive){
				moneySource.setEnabled(true);	
				chkliquidated.setEnabled(false);
			}else{
				moneySource.setEnabled(false);	
				chkliquidated.setEnabled(true);
			}
		}
		chkliquidated_changed();
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
	public void actionPrint_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if (editData == null)
			return;
		BillBaseStatusEnum billBaseStatus = editData.getBillStatus();
		if (editData.getId() == null
				|| billBaseStatus != null
				&& (billBaseStatus.getValue() == 0 || billBaseStatus.getValue() == 1)) {
			MsgBox.showInfo(this, InvClientUtils
					.getResource("CanPrintAndPrintView"));
			SysUtil.abort();
		}
		BeforeInvokePrintFunction(true);
	}

	public void actionPrintPreview_actionPerformed(ActionEvent e)
	throws Exception {
		if (editData == null)
			return;
		BillBaseStatusEnum billBaseStatus = editData.getBillStatus();
		if (editData.getId() == null
				|| billBaseStatus != null
				&& (billBaseStatus.getValue() == 0 || billBaseStatus.getValue() == 1)) {
			MsgBox.showInfo(this, InvClientUtils.getResource("CanPrintAndPrintView"));
			SysUtil.abort();
		}
		BeforeInvokePrintFunction(false);
	}

	protected void BeforeInvokePrintFunction(boolean isPrint) {
		ArrayList idList;
		idList = new ArrayList();
		if (editData != null && !StringUtils.isEmpty(editData.getString("id")))
			idList.add(editData.getString("id"));
		if (idList == null || idList.size() == 0 || getTDQueryPK() == null|| getTDFileName() == null)
			return;
		try {
			String bosType = getBizInterface().getType().toString();
			IPrintIntegration printInte = PrintIntegrationFactory.getRemoteInstance();
			java.util.List infoList = printInte.getBillsPrintInfoByList(idList,bosType);
			if (infoList.size() > 0) {
				StringBuffer sb = new StringBuffer();
				SelectorItemCollection sic = new SelectorItemCollection();
				sic.add(new SelectorItemInfo("id"));
				sic.add(new SelectorItemInfo("number"));
				for (int i = 0; i < 1; i++) {
					PrintIntegrationInfo info = (PrintIntegrationInfo) infoList.get(i);
					PrintIntegrationInfo info2 = PrintIntegrationFactory.getRemoteInstance().getPrintIntegrationInfo(new ObjectUuidPK(info.getId()),getPrintIntegrationSelector());
					//修改处
					MaiginBillInfo bill = MaiginBillFactory.getRemoteInstance().getMaiginBillInfo(new ObjectUuidPK(info2.getPrintBillID()),sic);
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String lastPrtTime = format.format(info2.getLastPrintTime());
					sb.append(MessageFormat.format(EASResource.getString("com.kingdee.eas.scm.sd.sale.SALEAutoGenerateResource","58_SaleOrderEditUI"),new Object[] {bill.getNumber().toString(),info2.getLastPrintUser().getName().toString(),lastPrtTime,(new Integer(info2.getPrintedNumber())).toString() }));
				}
				int flag = 0;
				if (isPrint)
					flag = MsgBox.showConfirm2(MessageFormat.format(EASResource.getString("com.kingdee.eas.scm.sd.sale.SALEAutoGenerateResource","56_SaleOrderEditUI"),new Object[] { "\n\r\n\r",sb.toString() }));
				else
					flag = MsgBox.showConfirm2(MessageFormat.format(EASResource.getString("com.kingdee.eas.scm.sd.sale.SALEAutoGenerateResource","57_SaleOrderEditUI"),new Object[] { "\n\r\n\r",sb.toString() }));
				if (flag == 2)
					return;
			}
		} catch (Exception e) {
			super.handleException(e);
		}

		try {
			invokePrintFunction(isPrint);
		} catch (Exception e) {
			super.handleException(e);
		}
		return;
	}

	private SelectorItemCollection getPrintIntegrationSelector() {
		SelectorItemCollection piSic = new SelectorItemCollection();
		piSic.add(new SelectorItemInfo("id"));
		piSic.add(new SelectorItemInfo("lastPrintTime"));
		piSic.add(new SelectorItemInfo("printedNumber"));
		piSic.add(new SelectorItemInfo("printBillID"));
		piSic.add(new SelectorItemInfo("lastPrintUser.name"));
		return piSic;
	}


	protected void invokePrintFunction(boolean isPrint) {
		ArrayList idList = new ArrayList();
		if (editData != null && !StringUtils.isEmpty(editData.getString("id")))
			idList.add(editData.getString("id"));
		if (idList == null || idList.size() == 0 || getTDQueryPK() == null|| getTDFileName() == null)
			return;
		com.kingdee.eas.scm.common.util.MultiDataSourceDataProviderProxy data = new MultiDataSourceDataProviderProxy();
		SCMCommonDataProvider mainQueryData = new SCMCommonDataProvider(idList,getTDQueryPK());
		mainQueryData.setFilter(getPrintFilter(idList));
		data.put("MainQuery", mainQueryData);
		MultiapproveDataProvider multiapproveDataSource = new MultiapproveDataProvider(getSelectedIdForPrint(), isShowMultiapproveHistoryForPrint(),"billId");
		multiapproveDataSource.setMultiapproveDataFilter(getMultiapproveDataFilter());
		data.put(getMultiapproveQueryNameForPrint(), multiapproveDataSource);
		KDNoteHelper appHlp = new KDNoteHelper();
		CommonPrintIntegrationDataProvider printQueryData = new CommonPrintIntegrationDataProvider(editData.getBOSType().toString(), PrintIntegrationManager.getPrintQueryPK());
		data.put("PrintQuery", printQueryData);
		PrintIntegrationManager.initPrint(appHlp, editData.getBOSType(),idList, getTDFileName(),"com.kingdee.eas.scm.common.SCMResource", true);
		if (isPrint)
			appHlp.print(getTDFileName(), data, SwingUtilities.getWindowAncestor(this));
		else
			appHlp.printPreview(getTDFileName(), data, SwingUtilities.getWindowAncestor(this));
	}

	protected FilterInfo getPrintFilter(List ids) {
		FilterInfo filter = new FilterInfo();
		if (ids.size() == 1) {
			filter.getFilterItems().add(
					new FilterItemInfo("id", ids.toArray()[0].toString(),
							CompareType.EQUALS));
		} else {
			filter.getFilterItems().add(
					new FilterItemInfo("id", new HashSet(ids),
							CompareType.INCLUDE));
		}
		filter.getFilterItems().add(
				new FilterItemInfo("billStatus", new Integer(0),
						CompareType.NOTEQUALS));
		filter.getFilterItems().add(
				new FilterItemInfo("billStatus", new Integer(1),
						CompareType.NOTEQUALS));
		filter.setMaskString("#0 and #1 and #2");
		return filter;
	}





	private void setFilter() {
		String companyID=null;
		if(this.prmtcompany.getValue()!=null) {
			companyID=((IPropertyContainer) this.prmtcompany.getValue()).getString("id");
		}
		//养殖户过滤
		StockingComm.setFarmerFilter(prmtfarmer, companyID, false);
		//设置担保申请表过滤
		String farmerID="";
		if(prmtfarmer.getValue()!=null){
			farmerID=((IPropertyContainer) this.prmtfarmer.getValue()).getString("id");
		}
		Date bizDate=null;
		if(this.pkBizDate.getValue()!=null) {
			bizDate=(Date) pkBizDate.getValue();
		}
		StockingComm.setGuaranteeBillFilter(prmtguaranty, companyID,farmerID,bizDate);
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.carnivorous.basebiz.MaiginBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.basebiz.MaiginBillInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setBizDate(new Date());
		objectValue.setMoneySource(com.kingdee.eas.farm.carnivorous.basebiz.moneySource.FromSettle);
		return objectValue;
	}
	@Override
	protected IObjectValue createNewDetailData(KDTable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}