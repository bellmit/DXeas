/**
 * output package name
 */
package com.kingdee.eas.farm.food.client;

import java.awt.event.ActionEvent;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.KDDatePicker;
import com.kingdee.bos.ctrl.swing.KDTextField;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.basedata.scm.common.BillTypeInfo;
import com.kingdee.eas.basedata.scm.common.BizTypeInfo;
import com.kingdee.eas.basedata.scm.common.TransactionTypeInfo;
import com.kingdee.eas.basedata.scm.common.util.SCMBaseCommonUtil;
import com.kingdee.eas.basedata.scm.im.inv.InvUpdateTypeInfo;
import com.kingdee.eas.basedata.scm.im.inv.LocationInfo;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.food.CManufactureBillEntryInfo;
import com.kingdee.eas.farm.food.CManufactureBillInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.client.SCMClientUtils;
import com.kingdee.eas.scm.im.inv.InvCommonUtils;
import com.kingdee.eas.scm.im.inv.client.InvClientUtils;

/**
 * output class name
 */
public class CManufactureBillEditUI extends AbstractCManufactureBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(CManufactureBillEditUI.class);
    
    /**
     * output class constructor
     */
    public CManufactureBillEditUI() throws Exception
    {
        super();
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
        for(int i=0;i<this.editData.getEntry().size();i++) {
        	this.editData.getEntry().get(i).setBizDate(new java.util.Date());
        }
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
     * output txtTotalAmount_actionPerformed method
     */
    protected void txtTotalAmount_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.txtTotalAmount_actionPerformed(e);
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
     * output actionEdit_actionPerformed
     */
    public void actionEdit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionEdit_actionPerformed(e);
    }

    /**
     * output actionRemove_actionPerformed
     */
    public void actionRemove_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemove_actionPerformed(e);
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

        int size = this.kdtEntry.getRowCount();
        if (size > 1) {
          IRow iRow = this.kdtEntry.getRow(size - 2);
          CostObjectInfo costObject = (CostObjectInfo)iRow.getCell(getDetailTable().getColumnIndex("costObject")).getValue();
          String objectName = (String)iRow.getCell(getDetailTable().getColumnIndex("costObjectName")).getValue();
          iRow = this.kdtEntry.getRow(size - 1);
          iRow.getCell(getDetailTable().getColumnIndex("costObject")).setValue(costObject);
          iRow.getCell(getDetailTable().getColumnIndex("costObjectName")).setValue(objectName);
        }
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
        int size = this.kdtEntry.getSelectManager().size();

        if (size > 0) {
          int selectTop = this.kdtEntry.getSelectManager().get().getTop();

          if (selectTop > 0) {
            IRow iRow = this.kdtEntry.getRow(selectTop - 1);
            CostObjectInfo costObject = (CostObjectInfo)iRow.getCell(getDetailTable().getColumnIndex("costObject")).getValue();
            String objectName = (String)iRow.getCell(getDetailTable().getColumnIndex("costObjectName")).getValue();
            iRow = this.kdtEntry.getRow(selectTop);
            iRow.getCell(getDetailTable().getColumnIndex("costObject")).setValue(costObject);
            iRow.getCell(getDetailTable().getColumnIndex("costObjectName")).setValue(objectName);
          }
        }
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
     * output actionFillColumn_actionPerformed
     */
    public void actionFillColumn_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionFillColumn_actionPerformed(e);
    }

    /**
     * output actionClearBill_actionPerformed
     */
    public void actionClearBill_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionClearBill_actionPerformed(e);
    }

    /**
     * output actionAudit_actionPerformed
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAudit_actionPerformed(e);
    }

    /**
     * output actionUnAudit_actionPerformed
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionUnAudit_actionPerformed(e);
    }

    /**
     * output actionQueryByMaterial_actionPerformed
     */
    public void actionQueryByMaterial_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionQueryByMaterial_actionPerformed(e);
    }

    /**
     * output actionDecompose_actionPerformed
     */
    public void actionDecompose_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionDecompose_actionPerformed(e);
    }

    /**
     * output actionSplitLine_actionPerformed
     */
    public void actionSplitLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSplitLine_actionPerformed(e);
    }

    /**
     * output actionQueryGeneralInventory_actionPerformed
     */
    public void actionQueryGeneralInventory_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionQueryGeneralInventory_actionPerformed(e);
    }

    /**
     * output actionMaterialView_actionPerformed
     */
    public void actionMaterialView_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionMaterialView_actionPerformed(e);
    }

    /**
     * output actionCustomerView_actionPerformed
     */
    public void actionCustomerView_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCustomerView_actionPerformed(e);
    }

    /**
     * output actionSupplierView_actionPerformed
     */
    public void actionSupplierView_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSupplierView_actionPerformed(e);
    }

    /**
     * output actionSplitOption_actionPerformed
     */
    public void actionSplitOption_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSplitOption_actionPerformed(e);
    }

    /**
     * output actionInvBillOption_actionPerformed
     */
    public void actionInvBillOption_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionInvBillOption_actionPerformed(e);
    }

    /**
     * output actionBillReservation_actionPerformed
     */
    public void actionBillReservation_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionBillReservation_actionPerformed(e);
    }

    /**
     * output actionReservationQuery_actionPerformed
     */
    public void actionReservationQuery_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionReservationQuery_actionPerformed(e);
    }

    /**
     * output actionObject2BillReservation_actionPerformed
     */
    public void actionObject2BillReservation_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionObject2BillReservation_actionPerformed(e);
    }

    /**
     * output actionBill2BillReservation_actionPerformed
     */
    public void actionBill2BillReservation_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionBill2BillReservation_actionPerformed(e);
    }

    /**
     * output actionInventorySum_actionPerformed
     */
    public void actionInventorySum_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionInventorySum_actionPerformed(e);
    }

    /**
     * output actionDiscard_actionPerformed
     */
    public void actionDiscard_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionDiscard_actionPerformed(e);
    }

    /**
     * output actionSerialNumber_actionPerformed
     */
    public void actionSerialNumber_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSerialNumber_actionPerformed(e);
    }

    /**
     * output actionSNsplit_actionPerformed
     */
    public void actionSNsplit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSNsplit_actionPerformed(e);
    }

    /**
     * output actionOffSet_actionPerformed
     */
    public void actionOffSet_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionOffSet_actionPerformed(e);
    }

    /**
     * output actionQuickAddLine_actionPerformed
     */
    public void actionQuickAddLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionQuickAddLine_actionPerformed(e);
    }

    /**
     * output actionBackFlush_actionPerformed
     */
    public void actionBackFlush_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionBackFlush_actionPerformed(e);
    }

    /**
     * output actionUnBackFlush_actionPerformed
     */
    public void actionUnBackFlush_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionUnBackFlush_actionPerformed(e);
    }

    /**
     * output actionInteractionBackFlush_actionPerformed
     */
    public void actionInteractionBackFlush_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionInteractionBackFlush_actionPerformed(e);
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.food.CManufactureBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        /*com.kingdee.eas.farm.food.CManufactureBillInfo objectValue = new com.kingdee.eas.farm.food.CManufactureBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new java.util.Date());
        objectValue.setNumber("12244");
        return objectValue;*/
    	CManufactureBillInfo manufactureRecBillInfo = null;
    	try {
    	  manufactureRecBillInfo = new CManufactureBillInfo();//;ManufactureRecBillAgent.create();
//    	  manufactureRecBillInfo.setNumber("123444");

    	  BillTypeInfo aBillTypeInfo = new BillTypeInfo();
    	  aBillTypeInfo.setId(BOSUuid.read("50957179-0105-1000-e000-0167c0a812fd463ED552"));
    	  aBillTypeInfo.setNumber("105");
    	  manufactureRecBillInfo.setBillType(aBillTypeInfo);

    	  manufactureRecBillInfo.setTotalQty(ZERO);
    	  manufactureRecBillInfo.setTotalStandardCost(ZERO);
    	  manufactureRecBillInfo.setTotalActualCost(ZERO);
    	  manufactureRecBillInfo.setTotalAmount(ZERO);
    	  manufactureRecBillInfo.setBaseStatus(BillBaseStatusEnum.ADD);

    	  manufactureRecBillInfo.setFiVouchered(false);
    	  manufactureRecBillInfo.setCreateTime(SCMClientUtils.getServerDate());
    	  manufactureRecBillInfo.setBizDate(manufactureRecBillInfo.getCreateTime());

    	  UserInfo aUserInfo = SysContext.getSysContext().getCurrentUserInfo();
    	  manufactureRecBillInfo.setCreator(aUserInfo);



    	  BizTypeInfo bizType = SCMBaseCommonUtil.getDefaultBizTypeInfo(null, "Nz878AEgEADgAABFwKg/GiQHQ1w=", "50957179-0105-1000-e000-0167c0a812fd463ED552");
    	  manufactureRecBillInfo.setBizType(bizType);




    	  if (bizType != null) {
    	    TransactionTypeInfo tti = InvCommonUtils.getDefaultTransactionType(null, "50957179-0105-1000-e000-0167c0a812fd463ED552", bizType.getId().toString());
    	    manufactureRecBillInfo.setTransactionType(tti);
    	  }
    	  this.sou = ((StorageOrgUnitInfo)getDefaultMainBizOrg());
    	  setCouBySou();
    	  if (this.cou != null) {
    	    manufactureRecBillInfo.setStorageOrgUnit(this.sou);
    	  }
    	  CManufactureBillEntryInfo aManufactureRecBillEntryInfo = (CManufactureBillEntryInfo)createNewDetailData(this.kdtEntry);

    	  aManufactureRecBillEntryInfo.setStorageOrgUnit(this.sou);
    	  aManufactureRecBillEntryInfo.setCompanyOrgUnit(this.cou);

    	  if (manufactureRecBillInfo.getTransactionType() != null) {
    	    InvUpdateTypeInfo invUpdateTypeInfo = InvCommonUtils.getDefaultInvUpdateType("50957179-0105-1000-e000-0167c0a812fd463ED552", manufactureRecBillInfo.getTransactionType());
    	        aManufactureRecBillEntryInfo.setInvUpdateType(invUpdateTypeInfo);
    	      }

    	      manufactureRecBillInfo.getEntry().add(aManufactureRecBillEntryInfo);
    	    } catch (Exception e) {
    	      handUIException(e);
    	    }

    	    return manufactureRecBillInfo;
    }
	@Override
	protected KDTable getDetailTable() {
		 return this.kdtEntry;
	}
	public KDBizPromptBox getMainOrgUnit() {
		return this.prmtStorageOrgUnit;
	}
	public KDTextField getNumTextField()
	{
	  return this.txtNumber;
	}

	protected KDDatePicker getBizDateField() {
	  return this.pkBizDate;
	}
	 public void afterAddLine(KDTable table, IObjectValue lineData)
	 {
	   super.afterAddLine(table, lineData);

	   int size = table.getRowCount();
	   int actionRow = table.getRowCount() - 1;

	   if ((this.batchCarryWarehouseLocation) && (size > 0) && (!(getCachedParameterValue("INM008")))) {
	     IRow curRow = table.getRow(0);
	     WarehouseInfo wi = (WarehouseInfo)curRow.getCell(table.getColumnIndex("warehouse")).getValue();
	     table.getCell(table.getRowCount() - 1, "warehouse").setValue(wi);
	     PersonInfo personInfo = (PersonInfo)curRow.getCell(table.getColumnIndex("stocker")).getValue();
	     table.getCell(table.getRowCount() - 1, "stocker").setValue(personInfo);

	     LocationInfo aLocationInfo = (LocationInfo)curRow.getCell(table.getColumnIndex("location")).getValue();
	     table.getCell(table.getRowCount() - 1, "location").setValue(aLocationInfo);
	   }
	   else if (table.getCell(table.getRowCount() - 1, "warehouse").getValue() == null) {
	     table.getCell(table.getRowCount() - 1, "location").getStyleAttributes().setLocked(true);

	   }
	 }
	 public IObjectValue createNewDetailData(KDTable table)
	 {
	   CManufactureBillEntryInfo manufactureRecBillEntryInfo = null;
	   try {
	     manufactureRecBillEntryInfo = new CManufactureBillEntryInfo();//;ManufactureRecBillEntryAgent.create();
	   } catch (Exception e) {
	     handUIException(e);

	   }

	   manufactureRecBillEntryInfo.setIsPresent(false);


	   manufactureRecBillEntryInfo.setQty(InvClientUtils.ZERO);
	   manufactureRecBillEntryInfo.setAssistQty(InvClientUtils.ZERO);
	   manufactureRecBillEntryInfo.setBaseQty(InvClientUtils.ZERO);
	   manufactureRecBillEntryInfo.setReverseQty(InvClientUtils.ZERO);
	   manufactureRecBillEntryInfo.setReceiveQty(InvClientUtils.ZERO);


	   manufactureRecBillEntryInfo.setUnitActualCost(InvClientUtils.ZERO);
	   manufactureRecBillEntryInfo.setActualCost(InvClientUtils.ZERO);
	   manufactureRecBillEntryInfo.setUnitStandardCost(InvClientUtils.ZERO);
	   manufactureRecBillEntryInfo.setStandardCost(InvClientUtils.ZERO);
	   manufactureRecBillEntryInfo.setPrice(InvClientUtils.ZERO);
	   manufactureRecBillEntryInfo.setAmount(InvClientUtils.ZERO);

	   manufactureRecBillEntryInfo.setStorageOrgUnit(this.sou);
	   manufactureRecBillEntryInfo.setCompanyOrgUnit(this.cou);

	   manufactureRecBillEntryInfo.setManuBillEntrySeq(0);

	   manufactureRecBillEntryInfo.setSaleOrderEntrySeq(0);

	   batchCarryWarehouseLocation(getDetailTable(), manufactureRecBillEntryInfo);

	   fillCurEntryByFirsrRow(manufactureRecBillEntryInfo, new String[] { getCustomerColName(), getSupplierColName() });
	   try {
	     manufactureRecBillEntryInfo.setInvUpdateType(getDefaultInvUpdateTypeInfo(buildInvUpdateTypeEntityView(-1, false)));
	   } catch (EASBizException e) {
	     handUIException(e);
	   } catch (BOSException e) {
	     handUIException(e);
	   }
	   return manufactureRecBillEntryInfo;
	 }
	  protected String getCustomerColName()
	  {
	    return null;
	  }



	  protected String getSupplierColName()
	  {
	    return null;
	  }
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.txtNumber.setRequired(false);
		this.txtNumber.setEnabled(true);
	}
	  
}