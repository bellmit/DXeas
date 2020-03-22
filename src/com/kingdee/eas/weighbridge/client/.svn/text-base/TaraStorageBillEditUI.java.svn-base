/**
 * output package name
 */
package com.kingdee.eas.weighbridge.client;

import java.awt.Toolkit;
import java.awt.event.*;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.weighbridge.WeighBaseStatus;
import com.kingdee.eas.weighbridge.WeighBizType;
import com.kingdee.eas.weighbridge.comm.WeighbridgeCommUtils;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.KDDatePicker;

/**
 * output class name
 */
public class TaraStorageBillEditUI extends AbstractTaraStorageBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(TaraStorageBillEditUI.class);
    
    /**
     * output class constructor
     */
    public TaraStorageBillEditUI() throws Exception
    {
        super();
        this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
//        if(!this.oprtState.equalsIgnoreCase(STATUS_ADDNEW)) {
//        	if(this.editData.getBizType().equals(WeighBizType.Pur)) {
//				this.contorderStorageOrgUnit.setVisible(false);
//				this.contsupplier.setVisible(true);
//        	}else if(this.editData.getBizType().equals(WeighBizType.TransIn)||this.editData.getBizType().equals(WeighBizType.GroupPur)) {
//        		this.contorderStorageOrgUnit.setVisible(true);
//				this.contsupplier.setVisible(false);
//        	} 
//        }else {
//        	this.contorderStorageOrgUnit.setVisible(false);
//			this.contsupplier.setVisible(true);
//        }
//        if(this.editData.getBillStatus().equals(WeighBaseStatus.audit)) {
//			this.mBtnAudit.setEnabled(false);
//			this.mBtnUnAudit.setEnabled(true);
//			this.tBtnAudit.setEnabled(false);
//			this.tBtnUnAudit.setEnabled(true);
//		}else if (this.editData.getBillStatus().equals(WeighBaseStatus.finish)){
//			this.mBtnAudit.setEnabled(true);
//			this.mBtnUnAudit.setEnabled(false);
//			this.tBtnAudit.setEnabled(true);
//			this.tBtnUnAudit.setEnabled(false);
//		}else {
//			this.mBtnAudit.setEnabled(false);
//			this.mBtnUnAudit.setEnabled(false);
//			this.tBtnAudit.setEnabled(false);
//			this.tBtnUnAudit.setEnabled(false);
//		}
    }
    
    /**
     * output actionEdit_actionPerformed
     */
    public void actionEdit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(WeighbridgeCommUtils.checkBillStatus(this.editData.getBillStatus(),WeighBaseStatus.finish)||WeighbridgeCommUtils.checkBillStatus(this.editData.getBillStatus(),WeighBaseStatus.audit)) {
			MsgBox.showWarning("单据已经完成或审核，禁止修改！");
			SysUtil.abort();
    	}
        super.actionEdit_actionPerformed(e);
    }

    /**
     * output actionRemove_actionPerformed
     */
    public void actionRemove_actionPerformed(ActionEvent e) throws Exception
    {
    	if(WeighbridgeCommUtils.checkBillStatus(this.editData.getBillStatus(),WeighBaseStatus.finish)||WeighbridgeCommUtils.checkBillStatus(this.editData.getBillStatus(),WeighBaseStatus.audit)) {
			MsgBox.showWarning("单据已经完成或审核，禁止修改！");
			SysUtil.abort();
    	}
        super.actionRemove_actionPerformed(e);
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
     * output menuItemEnterToNextRow_itemStateChanged method
     */
    protected void menuItemEnterToNextRow_itemStateChanged(java.awt.event.ItemEvent e) throws Exception
    {
        super.menuItemEnterToNextRow_itemStateChanged(e);
    }

    /**
     * output MenuItemPCVoucher_actionPerformed method
     */
    protected void MenuItemPCVoucher_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.MenuItemPCVoucher_actionPerformed(e);
    }

    /**
     * output menuItemDelPCVoucher_actionPerformed method
     */
    protected void menuItemDelPCVoucher_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.menuItemDelPCVoucher_actionPerformed(e);
    }

    /**
     * output actionPageSetup_actionPerformed
     */
    public void actionPageSetup_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPageSetup_actionPerformed(e);
    }

    /**
     * output actionExitCurrent_actionPerformed
     */
    public void actionExitCurrent_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExitCurrent_actionPerformed(e);
    }

    /**
     * output actionHelp_actionPerformed
     */
    public void actionHelp_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHelp_actionPerformed(e);
    }

    /**
     * output actionAbout_actionPerformed
     */
    public void actionAbout_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAbout_actionPerformed(e);
    }

    /**
     * output actionOnLoad_actionPerformed
     */
    public void actionOnLoad_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionOnLoad_actionPerformed(e);
    }

    /**
     * output actionSendMessage_actionPerformed
     */
    public void actionSendMessage_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendMessage_actionPerformed(e);
    }

    /**
     * output actionCalculator_actionPerformed
     */
    public void actionCalculator_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCalculator_actionPerformed(e);
    }

    /**
     * output actionExport_actionPerformed
     */
    public void actionExport_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExport_actionPerformed(e);
    }

    /**
     * output actionExportSelected_actionPerformed
     */
    public void actionExportSelected_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSelected_actionPerformed(e);
    }

    /**
     * output actionRegProduct_actionPerformed
     */
    public void actionRegProduct_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRegProduct_actionPerformed(e);
    }

    /**
     * output actionPersonalSite_actionPerformed
     */
    public void actionPersonalSite_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPersonalSite_actionPerformed(e);
    }

    /**
     * output actionProcductVal_actionPerformed
     */
    public void actionProcductVal_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionProcductVal_actionPerformed(e);
    }

    /**
     * output actionExportSave_actionPerformed
     */
    public void actionExportSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSave_actionPerformed(e);
    }

    /**
     * output actionExportSelectedSave_actionPerformed
     */
    public void actionExportSelectedSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSelectedSave_actionPerformed(e);
    }

    /**
     * output actionKnowStore_actionPerformed
     */
    public void actionKnowStore_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionKnowStore_actionPerformed(e);
    }

    /**
     * output actionAnswer_actionPerformed
     */
    public void actionAnswer_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAnswer_actionPerformed(e);
    }

    /**
     * output actionRemoteAssist_actionPerformed
     */
    public void actionRemoteAssist_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemoteAssist_actionPerformed(e);
    }

    /**
     * output actionPopupCopy_actionPerformed
     */
    public void actionPopupCopy_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPopupCopy_actionPerformed(e);
    }

    /**
     * output actionHTMLForMail_actionPerformed
     */
    public void actionHTMLForMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHTMLForMail_actionPerformed(e);
    }

    /**
     * output actionExcelForMail_actionPerformed
     */
    public void actionExcelForMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExcelForMail_actionPerformed(e);
    }

    /**
     * output actionHTMLForRpt_actionPerformed
     */
    public void actionHTMLForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHTMLForRpt_actionPerformed(e);
    }

    /**
     * output actionExcelForRpt_actionPerformed
     */
    public void actionExcelForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExcelForRpt_actionPerformed(e);
    }

    /**
     * output actionLinkForRpt_actionPerformed
     */
    public void actionLinkForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLinkForRpt_actionPerformed(e);
    }

    /**
     * output actionPopupPaste_actionPerformed
     */
    public void actionPopupPaste_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPopupPaste_actionPerformed(e);
    }

    /**
     * output actionToolBarCustom_actionPerformed
     */
    public void actionToolBarCustom_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionToolBarCustom_actionPerformed(e);
    }

    /**
     * output actionCloudFeed_actionPerformed
     */
    public void actionCloudFeed_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudFeed_actionPerformed(e);
    }

    /**
     * output actionCloudShare_actionPerformed
     */
    public void actionCloudShare_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudShare_actionPerformed(e);
    }

    /**
     * output actionCloudScreen_actionPerformed
     */
    public void actionCloudScreen_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudScreen_actionPerformed(e);
    }

    /**
     * output actionXunTongFeed_actionPerformed
     */
    public void actionXunTongFeed_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionXunTongFeed_actionPerformed(e);
    }

    /**
     * output actionSave_actionPerformed
     */
    public void actionSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSave_actionPerformed(e);
    }

    /**
     * output actionSubmit_actionPerformed
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmit_actionPerformed(e);
    }

    /**
     * output actionCancel_actionPerformed
     */
    public void actionCancel_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCancel_actionPerformed(e);
    }

    /**
     * output actionCancelCancel_actionPerformed
     */
    public void actionCancelCancel_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCancelCancel_actionPerformed(e);
    }

    /**
     * output actionFirst_actionPerformed
     */
    public void actionFirst_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionFirst_actionPerformed(e);
    }

    /**
     * output actionPre_actionPerformed
     */
    public void actionPre_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPre_actionPerformed(e);
    }

    /**
     * output actionNext_actionPerformed
     */
    public void actionNext_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionNext_actionPerformed(e);
    }

    /**
     * output actionLast_actionPerformed
     */
    public void actionLast_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLast_actionPerformed(e);
    }

    /**
     * output actionPrint_actionPerformed
     */
    public void actionPrint_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPrint_actionPerformed(e);
    }

    /**
     * output actionPrintPreview_actionPerformed
     */
    public void actionPrintPreview_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPrintPreview_actionPerformed(e);
    }

    /**
     * output actionCopy_actionPerformed
     */
    public void actionCopy_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopy_actionPerformed(e);
    }

    /**
     * output actionAddNew_actionPerformed
     */
    public void actionAddNew_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAddNew_actionPerformed(e);
    }

   

    /**
     * output actionAttachment_actionPerformed
     */
    public void actionAttachment_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAttachment_actionPerformed(e);
    }

    /**
     * output actionSubmitOption_actionPerformed
     */
    public void actionSubmitOption_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmitOption_actionPerformed(e);
    }

    /**
     * output actionReset_actionPerformed
     */
    public void actionReset_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionReset_actionPerformed(e);
    }

    /**
     * output actionMsgFormat_actionPerformed
     */
    public void actionMsgFormat_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionMsgFormat_actionPerformed(e);
    }

    /**
     * output actionAddLine_actionPerformed
     */
    public void actionAddLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAddLine_actionPerformed(e);
    }

    /**
     * output actionCopyLine_actionPerformed
     */
    public void actionCopyLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopyLine_actionPerformed(e);
    }

    /**
     * output actionInsertLine_actionPerformed
     */
    public void actionInsertLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionInsertLine_actionPerformed(e);
    }

    /**
     * output actionRemoveLine_actionPerformed
     */
    public void actionRemoveLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemoveLine_actionPerformed(e);
    }

    /**
     * output actionCreateFrom_actionPerformed
     */
    public void actionCreateFrom_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCreateFrom_actionPerformed(e);
    }

    /**
     * output actionCopyFrom_actionPerformed
     */
    public void actionCopyFrom_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopyFrom_actionPerformed(e);
    }

    /**
     * output actionAuditResult_actionPerformed
     */
    public void actionAuditResult_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAuditResult_actionPerformed(e);
    }

    /**
     * output actionTraceUp_actionPerformed
     */
    public void actionTraceUp_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionTraceUp_actionPerformed(e);
    }

    /**
     * output actionTraceDown_actionPerformed
     */
    public void actionTraceDown_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionTraceDown_actionPerformed(e);
    }

    /**
     * output actionViewSubmitProccess_actionPerformed
     */
    public void actionViewSubmitProccess_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionViewSubmitProccess_actionPerformed(e);
    }

    /**
     * output actionViewDoProccess_actionPerformed
     */
    public void actionViewDoProccess_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionViewDoProccess_actionPerformed(e);
    }

    /**
     * output actionMultiapprove_actionPerformed
     */
    public void actionMultiapprove_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionMultiapprove_actionPerformed(e);
    }

    /**
     * output actionNextPerson_actionPerformed
     */
    public void actionNextPerson_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionNextPerson_actionPerformed(e);
    }

    /**
     * output actionStartWorkFlow_actionPerformed
     */
    public void actionStartWorkFlow_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionStartWorkFlow_actionPerformed(e);
    }

    /**
     * output actionVoucher_actionPerformed
     */
    public void actionVoucher_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionVoucher_actionPerformed(e);
    }

    /**
     * output actionDelVoucher_actionPerformed
     */
    public void actionDelVoucher_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionDelVoucher_actionPerformed(e);
    }

    /**
     * output actionWorkFlowG_actionPerformed
     */
    public void actionWorkFlowG_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionWorkFlowG_actionPerformed(e);
    }

    /**
     * output actionCreateTo_actionPerformed
     */
    public void actionCreateTo_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCreateTo_actionPerformed(e);
    }

    /**
     * output actionSendingMessage_actionPerformed
     */
    public void actionSendingMessage_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendingMessage_actionPerformed(e);
    }

    /**
     * output actionSignature_actionPerformed
     */
    public void actionSignature_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSignature_actionPerformed(e);
    }

    /**
     * output actionWorkflowList_actionPerformed
     */
    public void actionWorkflowList_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionWorkflowList_actionPerformed(e);
    }

    /**
     * output actionViewSignature_actionPerformed
     */
    public void actionViewSignature_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionViewSignature_actionPerformed(e);
    }

    /**
     * output actionSendMail_actionPerformed
     */
    public void actionSendMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendMail_actionPerformed(e);
    }

    /**
     * output actionLocate_actionPerformed
     */
    public void actionLocate_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLocate_actionPerformed(e);
    }

    /**
     * output actionNumberSign_actionPerformed
     */
    public void actionNumberSign_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionNumberSign_actionPerformed(e);
    }

    /**
     * output actionPCVoucher_actionPerformed
     */
    public void actionPCVoucher_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPCVoucher_actionPerformed(e);
    }

    /**
     * output actionDelPCVoucher_actionPerformed
     */
    public void actionDelPCVoucher_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionDelPCVoucher_actionPerformed(e);
    }

   

    /**
     * output actionUpdateSourceBill_actionPerformed
     */
    public void actionUpdateSourceBill_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionUpdateSourceBill_actionPerformed(e);
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.weighbridge.TaraStorageBillFactory.getRemoteInstance();
    }

    /**
     * output createNewDetailData method
     */
    protected IObjectValue createNewDetailData(KDTable table)
    {
		
        return null;
    }
    @Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		super.onShow();
		initControl();
		//customInitControl();
	}
    private void initControl() {
    	this.pkinTime.setTimeEnabled(true);
    	this.pkoutTime.setTimeEnabled(true);
    	
    	CompanyF7 ff7=new CompanyF7();
    	ff7.setIsCUFilter(true);
    	this.prmtcompany.setSelector(ff7);
    	ff7.setIsCUFilter(false);
    	this.prmtorderCompany.setSelector(ff7);
    	
    	this.contLastUpdateTime.setVisible(true);
		this.contLastUpdateUser.setVisible(true);
    	
    	this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
    	
    	 KDDatePicker kdtEntrys_weighTime_DatePicker = new KDDatePicker();
    	 //KDTimePicker kdtEntrys_weighTime_DatePicker = new KDTimePicker();
    	// kdtEntrys_weighTime_DatePicker.setDateEnabled(true);
    	 kdtEntrys_weighTime_DatePicker.setDatePattern("yyyy-MM-dd HH:mm:ss");
         kdtEntrys_weighTime_DatePicker.setName("kdtEntrys_weighTime_DatePicker");
         kdtEntrys_weighTime_DatePicker.setVisible(true);
         kdtEntrys_weighTime_DatePicker.setEditable(true);
         kdtEntrys_weighTime_DatePicker.setTimeEnabled(true);
         KDTDefaultCellEditor kdtEntrys_weighTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_weighTime_DatePicker);
         this.kdtEntrys.getColumn("weighTime").setEditor(kdtEntrys_weighTime_CellEditor);
         
         this.kdtEntrys.getColumn("weighTime2").setEditor(kdtEntrys_weighTime_CellEditor);
         this.kdtEntrys.getColumn("weighTimeGross").setEditor(kdtEntrys_weighTime_CellEditor);
         
         this.kdtEntrys.getColumn("weighTime").getStyleAttributes().setNumberFormat("yyyy-MM-dd HH:mm:ss");
         this.kdtEntrys.getColumn("weighTime2").getStyleAttributes().setNumberFormat("yyyy-MM-dd HH:mm:ss");
         this.kdtEntrys.getColumn("weighTimeGross").getStyleAttributes().setNumberFormat("yyyy-MM-dd HH:mm:ss");
         
         this.bizType.removeItem(WeighBizType.Sale);
         this.bizType.removeItem(WeighBizType.TransOut);
         this.bizType.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(bizType.getSelectedItem().equals(WeighBizType.Pur)) {
					contsupplier.setVisible(true);
					prmtorderStorageOrgUnit.setValue(null);
					contorderStorageOrgUnit.setVisible(false);
				}else{
					contorderStorageOrgUnit.setVisible(true);
					prmtsupplier.setValue(null);
					contsupplier.setVisible(false);
				}
			}});
         
         this.btnCancel.setVisible(true);
		 this.btnCancelCancel.setVisible(true);
		 
		 this.prmtcar.setRequired(false);
    }
    /**
     * output actionAudit_actionPerformed
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(WeighbridgeCommUtils.checkBillStatus(this.editData.getBillStatus(),WeighBaseStatus.audit)) {
    		MsgBox.showWarning("单据已经审核，禁止再次审核！");
    		SysUtil.abort();
    	}
    	if(!WeighbridgeCommUtils.checkBillStatus(this.editData.getBillStatus(),WeighBaseStatus.finish)) {
    		MsgBox.showWarning("单据尚未过磅完成，禁止审核！");
    		SysUtil.abort();
    	}
		super.actionAudit_actionPerformed(e);
		/*this.setDataObject(this.editData);
		this.loadFields();*/
		this.editData.setBillStatus(WeighBaseStatus.audit);
		this.loadData();
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
    	if(!WeighbridgeCommUtils.checkBillStatus(this.editData.getBillStatus(),WeighBaseStatus.audit)) {
    		MsgBox.showWarning("单据尚未审核，禁止反审核！");
    		SysUtil.abort();
    	}
		super.actionUnAudit_actionPerformed(e);
		this.editData.setBillStatus(WeighBaseStatus.save);
		this.loadData();
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.weighbridge.TaraStorageBillInfo objectValue = new com.kingdee.eas.weighbridge.TaraStorageBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new java.util.Date());
        return objectValue;
    }

}