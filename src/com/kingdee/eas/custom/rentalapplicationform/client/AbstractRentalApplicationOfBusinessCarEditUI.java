/**
 * output package name
 */
package com.kingdee.eas.custom.rentalapplicationform.client;

import org.apache.log4j.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;
import javax.swing.BorderFactory;
import javax.swing.event.*;
import javax.swing.KeyStroke;

import com.kingdee.bos.ctrl.swing.*;
import com.kingdee.bos.ctrl.kdf.table.*;
import com.kingdee.bos.ctrl.kdf.data.event.*;
import com.kingdee.bos.dao.*;
import com.kingdee.bos.dao.query.*;
import com.kingdee.bos.metadata.*;
import com.kingdee.bos.metadata.entity.*;
import com.kingdee.bos.ui.face.*;
import com.kingdee.bos.ui.util.ResourceBundleHelper;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.enums.EnumUtils;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.ctrl.swing.event.*;
import com.kingdee.bos.ctrl.kdf.table.event.*;
import com.kingdee.bos.ctrl.extendcontrols.*;
import com.kingdee.bos.ctrl.kdf.util.render.*;
import com.kingdee.bos.ui.face.IItemAction;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.bos.ui.util.IUIActionPostman;
import com.kingdee.bos.appframework.client.servicebinding.ActionProxyFactory;
import com.kingdee.bos.appframework.uistatemanage.ActionStateConst;
import com.kingdee.bos.appframework.validator.ValidateHelper;
import com.kingdee.bos.appframework.uip.UINavigator;


/**
 * output class name
 */
public abstract class AbstractRentalApplicationOfBusinessCarEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractRentalApplicationOfBusinessCarEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contapplyDepartment;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contapplier;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontact;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contvisitor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contvisitorContract;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdestinationAddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpickUpTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contvisitorQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfeeFrom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfeeTo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contusedDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabel labelPurpose;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpickUpInCompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpickUpOutCompany;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator9;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator10;
    protected com.kingdee.bos.ctrl.swing.KDLabel labelStatement;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpurpose;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contremark;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator11;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtapplyDepartment;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtapplier;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcontact;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtvisitor;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtvisitorContract;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdestinationAddress;
    protected com.kingdee.bos.ctrl.swing.KDTimePicker pickUpTime;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtvisitorQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfeeFrom;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfeeTo;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkusedDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditDate;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpickUpInCompany;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpickUpOutCompany;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane scrollPanepurpose;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtpurpose;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane scrollPaneremark;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtremark;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.custom.rentalapplicationform.RentalApplicationOfBusinessCarInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractRentalApplicationOfBusinessCarEditUI() throws Exception
    {
        super();
        this.defaultObjectName = "editData";
        jbInit();
        
        initUIP();
    }

    /**
     * output jbInit method
     */
    private void jbInit() throws Exception
    {
        this.resHelper = new ResourceBundleHelper(AbstractRentalApplicationOfBusinessCarEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        //actionSubmit
        String _tempStr = null;
        actionSubmit.setEnabled(true);
        actionSubmit.setDaemonRun(false);

        actionSubmit.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl S"));
        _tempStr = resHelper.getString("ActionSubmit.SHORT_DESCRIPTION");
        actionSubmit.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionSubmit.LONG_DESCRIPTION");
        actionSubmit.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionSubmit.NAME");
        actionSubmit.putValue(ItemAction.NAME, _tempStr);
        this.actionSubmit.setBindWorkFlow(true);
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionPrint
        actionPrint.setEnabled(true);
        actionPrint.setDaemonRun(false);

        actionPrint.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl P"));
        _tempStr = resHelper.getString("ActionPrint.SHORT_DESCRIPTION");
        actionPrint.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrint.LONG_DESCRIPTION");
        actionPrint.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrint.NAME");
        actionPrint.putValue(ItemAction.NAME, _tempStr);
         this.actionPrint.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionPrint.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionPrint.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionPrintPreview
        actionPrintPreview.setEnabled(true);
        actionPrintPreview.setDaemonRun(false);

        actionPrintPreview.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("shift ctrl P"));
        _tempStr = resHelper.getString("ActionPrintPreview.SHORT_DESCRIPTION");
        actionPrintPreview.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrintPreview.LONG_DESCRIPTION");
        actionPrintPreview.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrintPreview.NAME");
        actionPrintPreview.putValue(ItemAction.NAME, _tempStr);
         this.actionPrintPreview.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionPrintPreview.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionPrintPreview.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionAudit
        this.actionAudit = new ActionAudit(this);
        getActionManager().registerAction("actionAudit", actionAudit);
        this.actionAudit.setExtendProperty("canForewarn", "true");
        this.actionAudit.setExtendProperty("userDefined", "false");
        this.actionAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionUnAudit
        this.actionUnAudit = new ActionUnAudit(this);
        getActionManager().registerAction("actionUnAudit", actionUnAudit);
        this.actionUnAudit.setExtendProperty("canForewarn", "true");
        this.actionUnAudit.setExtendProperty("userDefined", "false");
        this.actionUnAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contapplyDepartment = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contapplier = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcontact = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contvisitor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contvisitorContract = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdestinationAddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpickUpTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contvisitorQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfeeFrom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfeeTo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contusedDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.labelPurpose = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.contpickUpInCompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpickUpOutCompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDSeparator9 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDSeparator10 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.labelStatement = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.contpurpose = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contremark = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator11 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtapplyDepartment = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtapplier = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtcontact = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtvisitor = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtvisitorContract = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtdestinationAddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pickUpTime = new com.kingdee.bos.ctrl.swing.KDTimePicker();
        this.txtvisitorQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfeeFrom = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfeeTo = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkusedDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkauditDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtpickUpInCompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtpickUpOutCompany = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.scrollPanepurpose = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txtpurpose = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.scrollPaneremark = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txtremark = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contAuditor.setName("contAuditor");
        this.contapplyDepartment.setName("contapplyDepartment");
        this.contapplier.setName("contapplier");
        this.contcontact.setName("contcontact");
        this.contvisitor.setName("contvisitor");
        this.contvisitorContract.setName("contvisitorContract");
        this.contdestinationAddress.setName("contdestinationAddress");
        this.contpickUpTime.setName("contpickUpTime");
        this.contvisitorQty.setName("contvisitorQty");
        this.contfeeFrom.setName("contfeeFrom");
        this.contfeeTo.setName("contfeeTo");
        this.contusedDate.setName("contusedDate");
        this.contauditDate.setName("contauditDate");
        this.contbillStatus.setName("contbillStatus");
        this.labelPurpose.setName("labelPurpose");
        this.contpickUpInCompany.setName("contpickUpInCompany");
        this.contpickUpOutCompany.setName("contpickUpOutCompany");
        this.kDSeparator8.setName("kDSeparator8");
        this.kDSeparator9.setName("kDSeparator9");
        this.kDSeparator10.setName("kDSeparator10");
        this.labelStatement.setName("labelStatement");
        this.contpurpose.setName("contpurpose");
        this.contremark.setName("contremark");
        this.kDSeparator11.setName("kDSeparator11");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtapplyDepartment.setName("prmtapplyDepartment");
        this.prmtapplier.setName("prmtapplier");
        this.txtcontact.setName("txtcontact");
        this.txtvisitor.setName("txtvisitor");
        this.txtvisitorContract.setName("txtvisitorContract");
        this.txtdestinationAddress.setName("txtdestinationAddress");
        this.pickUpTime.setName("pickUpTime");
        this.txtvisitorQty.setName("txtvisitorQty");
        this.txtfeeFrom.setName("txtfeeFrom");
        this.txtfeeTo.setName("txtfeeTo");
        this.pkusedDate.setName("pkusedDate");
        this.pkauditDate.setName("pkauditDate");
        this.billStatus.setName("billStatus");
        this.prmtpickUpInCompany.setName("prmtpickUpInCompany");
        this.txtpickUpOutCompany.setName("txtpickUpOutCompany");
        this.scrollPanepurpose.setName("scrollPanepurpose");
        this.txtpurpose.setName("txtpurpose");
        this.scrollPaneremark.setName("scrollPaneremark");
        this.txtremark.setName("txtremark");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
        // CoreUI		
        this.btnTraceUp.setVisible(false);		
        this.btnTraceDown.setVisible(false);		
        this.btnCreateTo.setVisible(true);		
        this.btnAddLine.setVisible(false);		
        this.btnCopyLine.setVisible(false);		
        this.btnInsertLine.setVisible(false);		
        this.btnRemoveLine.setVisible(false);		
        this.btnAuditResult.setVisible(false);		
        this.separator1.setVisible(false);		
        this.menuItemCreateTo.setVisible(true);		
        this.separator3.setVisible(false);		
        this.menuItemTraceUp.setVisible(false);		
        this.menuItemTraceDown.setVisible(false);		
        this.menuTable1.setVisible(false);		
        this.menuItemAddLine.setVisible(false);		
        this.menuItemCopyLine.setVisible(false);		
        this.menuItemInsertLine.setVisible(false);		
        this.menuItemRemoveLine.setVisible(false);		
        this.menuItemViewSubmitProccess.setVisible(false);		
        this.menuItemViewDoProccess.setVisible(false);		
        this.menuItemAuditResult.setVisible(false);
        // contCreator		
        this.contCreator.setBoundLabelText(resHelper.getString("contCreator.boundLabelText"));		
        this.contCreator.setBoundLabelLength(100);		
        this.contCreator.setBoundLabelUnderline(true);		
        this.contCreator.setEnabled(false);
        // contCreateTime		
        this.contCreateTime.setBoundLabelText(resHelper.getString("contCreateTime.boundLabelText"));		
        this.contCreateTime.setBoundLabelLength(100);		
        this.contCreateTime.setBoundLabelUnderline(true);		
        this.contCreateTime.setEnabled(false);
        // contLastUpdateUser		
        this.contLastUpdateUser.setBoundLabelText(resHelper.getString("contLastUpdateUser.boundLabelText"));		
        this.contLastUpdateUser.setBoundLabelLength(100);		
        this.contLastUpdateUser.setBoundLabelUnderline(true);		
        this.contLastUpdateUser.setEnabled(false);		
        this.contLastUpdateUser.setVisible(false);
        // contLastUpdateTime		
        this.contLastUpdateTime.setBoundLabelText(resHelper.getString("contLastUpdateTime.boundLabelText"));		
        this.contLastUpdateTime.setBoundLabelLength(100);		
        this.contLastUpdateTime.setBoundLabelUnderline(true);		
        this.contLastUpdateTime.setEnabled(false);		
        this.contLastUpdateTime.setVisible(false);
        // contNumber		
        this.contNumber.setBoundLabelText(resHelper.getString("contNumber.boundLabelText"));		
        this.contNumber.setBoundLabelLength(100);		
        this.contNumber.setBoundLabelUnderline(true);
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);
        // contapplyDepartment		
        this.contapplyDepartment.setBoundLabelText(resHelper.getString("contapplyDepartment.boundLabelText"));		
        this.contapplyDepartment.setBoundLabelLength(100);		
        this.contapplyDepartment.setBoundLabelUnderline(true);		
        this.contapplyDepartment.setVisible(true);
        // contapplier		
        this.contapplier.setBoundLabelText(resHelper.getString("contapplier.boundLabelText"));		
        this.contapplier.setBoundLabelLength(100);		
        this.contapplier.setBoundLabelUnderline(true);		
        this.contapplier.setVisible(true);
        // contcontact		
        this.contcontact.setBoundLabelText(resHelper.getString("contcontact.boundLabelText"));		
        this.contcontact.setBoundLabelLength(100);		
        this.contcontact.setBoundLabelUnderline(true);		
        this.contcontact.setVisible(true);
        // contvisitor		
        this.contvisitor.setBoundLabelText(resHelper.getString("contvisitor.boundLabelText"));		
        this.contvisitor.setBoundLabelLength(100);		
        this.contvisitor.setBoundLabelUnderline(true);		
        this.contvisitor.setVisible(true);
        // contvisitorContract		
        this.contvisitorContract.setBoundLabelText(resHelper.getString("contvisitorContract.boundLabelText"));		
        this.contvisitorContract.setBoundLabelLength(100);		
        this.contvisitorContract.setBoundLabelUnderline(true);		
        this.contvisitorContract.setVisible(true);
        // contdestinationAddress		
        this.contdestinationAddress.setBoundLabelText(resHelper.getString("contdestinationAddress.boundLabelText"));		
        this.contdestinationAddress.setBoundLabelLength(130);		
        this.contdestinationAddress.setBoundLabelUnderline(true);		
        this.contdestinationAddress.setVisible(true);
        // contpickUpTime		
        this.contpickUpTime.setBoundLabelText(resHelper.getString("contpickUpTime.boundLabelText"));		
        this.contpickUpTime.setBoundLabelLength(130);		
        this.contpickUpTime.setBoundLabelUnderline(true);		
        this.contpickUpTime.setVisible(true);
        // contvisitorQty		
        this.contvisitorQty.setBoundLabelText(resHelper.getString("contvisitorQty.boundLabelText"));		
        this.contvisitorQty.setBoundLabelLength(100);		
        this.contvisitorQty.setBoundLabelUnderline(true);		
        this.contvisitorQty.setVisible(true);
        // contfeeFrom		
        this.contfeeFrom.setBoundLabelText(resHelper.getString("contfeeFrom.boundLabelText"));		
        this.contfeeFrom.setBoundLabelLength(130);		
        this.contfeeFrom.setBoundLabelUnderline(true);		
        this.contfeeFrom.setVisible(true);
        // contfeeTo		
        this.contfeeTo.setBoundLabelText(resHelper.getString("contfeeTo.boundLabelText"));		
        this.contfeeTo.setBoundLabelLength(130);		
        this.contfeeTo.setBoundLabelUnderline(true);		
        this.contfeeTo.setVisible(true);
        // contusedDate		
        this.contusedDate.setBoundLabelText(resHelper.getString("contusedDate.boundLabelText"));		
        this.contusedDate.setBoundLabelLength(100);		
        this.contusedDate.setBoundLabelUnderline(true);		
        this.contusedDate.setVisible(true);
        // contauditDate		
        this.contauditDate.setBoundLabelText(resHelper.getString("contauditDate.boundLabelText"));		
        this.contauditDate.setBoundLabelLength(100);		
        this.contauditDate.setBoundLabelUnderline(true);		
        this.contauditDate.setVisible(true);
        // contbillStatus		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);
        // labelPurpose		
        this.labelPurpose.setText(resHelper.getString("labelPurpose.text"));
        // contpickUpInCompany		
        this.contpickUpInCompany.setBoundLabelText(resHelper.getString("contpickUpInCompany.boundLabelText"));		
        this.contpickUpInCompany.setBoundLabelLength(130);		
        this.contpickUpInCompany.setBoundLabelUnderline(true);		
        this.contpickUpInCompany.setVisible(true);
        // contpickUpOutCompany		
        this.contpickUpOutCompany.setBoundLabelText(resHelper.getString("contpickUpOutCompany.boundLabelText"));		
        this.contpickUpOutCompany.setBoundLabelLength(130);		
        this.contpickUpOutCompany.setBoundLabelUnderline(true);		
        this.contpickUpOutCompany.setVisible(true);
        // kDSeparator8
        // kDSeparator9
        // kDSeparator10
        // labelStatement		
        this.labelStatement.setText(resHelper.getString("labelStatement.text"));
        // contpurpose		
        this.contpurpose.setBoundLabelText(resHelper.getString("contpurpose.boundLabelText"));		
        this.contpurpose.setBoundLabelLength(0);		
        this.contpurpose.setBoundLabelUnderline(true);		
        this.contpurpose.setVisible(true);
        // contremark		
        this.contremark.setBoundLabelText(resHelper.getString("contremark.boundLabelText"));		
        this.contremark.setBoundLabelLength(0);		
        this.contremark.setBoundLabelUnderline(true);		
        this.contremark.setVisible(true);
        // kDSeparator11
        // prmtCreator		
        this.prmtCreator.setEnabled(false);
        // kDDateCreateTime		
        this.kDDateCreateTime.setTimeEnabled(true);		
        this.kDDateCreateTime.setEnabled(false);
        // prmtLastUpdateUser		
        this.prmtLastUpdateUser.setEnabled(false);
        // kDDateLastUpdateTime		
        this.kDDateLastUpdateTime.setTimeEnabled(true);		
        this.kDDateLastUpdateTime.setEnabled(false);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // prmtapplyDepartment		
        this.prmtapplyDepartment.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtapplyDepartment.setVisible(true);		
        this.prmtapplyDepartment.setEditable(true);		
        this.prmtapplyDepartment.setDisplayFormat("$name$");		
        this.prmtapplyDepartment.setEditFormat("$number$");		
        this.prmtapplyDepartment.setCommitFormat("$number$");		
        this.prmtapplyDepartment.setRequired(true);
        // prmtapplier		
        this.prmtapplier.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtapplier.setVisible(true);		
        this.prmtapplier.setEditable(true);		
        this.prmtapplier.setDisplayFormat("$name$");		
        this.prmtapplier.setEditFormat("$number$");		
        this.prmtapplier.setCommitFormat("$number$");		
        this.prmtapplier.setRequired(true);
        this.prmtapplier.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtapplier_dataChang(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtcontact		
        this.txtcontact.setVisible(true);		
        this.txtcontact.setHorizontalAlignment(2);		
        this.txtcontact.setMaxLength(100);		
        this.txtcontact.setRequired(false);
        // txtvisitor		
        this.txtvisitor.setVisible(true);		
        this.txtvisitor.setHorizontalAlignment(2);		
        this.txtvisitor.setMaxLength(100);		
        this.txtvisitor.setRequired(true);
        // txtvisitorContract		
        this.txtvisitorContract.setVisible(true);		
        this.txtvisitorContract.setHorizontalAlignment(2);		
        this.txtvisitorContract.setMaxLength(100);		
        this.txtvisitorContract.setRequired(false);
        // txtdestinationAddress		
        this.txtdestinationAddress.setVisible(true);		
        this.txtdestinationAddress.setHorizontalAlignment(2);		
        this.txtdestinationAddress.setMaxLength(100);		
        this.txtdestinationAddress.setRequired(true);
        // pickUpTime		
        this.pickUpTime.setVisible(true);		
        this.pickUpTime.setRequired(true);
        // txtvisitorQty		
        this.txtvisitorQty.setVisible(true);		
        this.txtvisitorQty.setHorizontalAlignment(2);		
        this.txtvisitorQty.setDataType(0);		
        this.txtvisitorQty.setSupportedEmpty(true);		
        this.txtvisitorQty.setRequired(false);
        // txtfeeFrom		
        this.txtfeeFrom.setVisible(true);		
        this.txtfeeFrom.setHorizontalAlignment(2);		
        this.txtfeeFrom.setDataType(1);		
        this.txtfeeFrom.setSupportedEmpty(true);		
        this.txtfeeFrom.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfeeFrom.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfeeFrom.setPrecision(2);		
        this.txtfeeFrom.setRequired(false);
        // txtfeeTo		
        this.txtfeeTo.setVisible(true);		
        this.txtfeeTo.setHorizontalAlignment(2);		
        this.txtfeeTo.setDataType(1);		
        this.txtfeeTo.setSupportedEmpty(true);		
        this.txtfeeTo.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfeeTo.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfeeTo.setPrecision(2);		
        this.txtfeeTo.setRequired(false);
        // pkusedDate		
        this.pkusedDate.setVisible(true);		
        this.pkusedDate.setRequired(true);
        // pkauditDate		
        this.pkauditDate.setVisible(true);		
        this.pkauditDate.setRequired(false);		
        this.pkauditDate.setEnabled(false);
        // billStatus		
        this.billStatus.setVisible(true);		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.rentalapplicationform.billStatus").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // prmtpickUpInCompany		
        this.prmtpickUpInCompany.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtpickUpInCompany.setVisible(true);		
        this.prmtpickUpInCompany.setEditable(true);		
        this.prmtpickUpInCompany.setDisplayFormat("$name$");		
        this.prmtpickUpInCompany.setEditFormat("$number$");		
        this.prmtpickUpInCompany.setCommitFormat("$number$");		
        this.prmtpickUpInCompany.setRequired(false);
        // txtpickUpOutCompany		
        this.txtpickUpOutCompany.setVisible(true);		
        this.txtpickUpOutCompany.setHorizontalAlignment(2);		
        this.txtpickUpOutCompany.setMaxLength(100);		
        this.txtpickUpOutCompany.setRequired(false);
        // scrollPanepurpose
        // txtpurpose		
        this.txtpurpose.setVisible(true);		
        this.txtpurpose.setRequired(false);		
        this.txtpurpose.setMaxLength(500);
        // scrollPaneremark
        // txtremark		
        this.txtremark.setVisible(true);		
        this.txtremark.setRequired(false);		
        this.txtremark.setMaxLength(500);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtapplyDepartment,prmtapplier,txtcontact,txtvisitor,txtvisitorContract,txtdestinationAddress,pickUpTime,txtvisitorQty,txtfeeFrom,txtfeeTo,pkusedDate,pkauditDate,billStatus,prmtpickUpInCompany,txtpickUpOutCompany,txtpurpose,txtremark}));
        this.setFocusCycleRoot(true);
		//Register control's property binding
		registerBindings();
		registerUIState();


    }

	public com.kingdee.bos.ctrl.swing.KDToolBar[] getUIMultiToolBar(){
		java.util.List list = new java.util.ArrayList();
		com.kingdee.bos.ctrl.swing.KDToolBar[] bars = super.getUIMultiToolBar();
		if (bars != null) {
			list.addAll(java.util.Arrays.asList(bars));
		}
		return (com.kingdee.bos.ctrl.swing.KDToolBar[])list.toArray(new com.kingdee.bos.ctrl.swing.KDToolBar[list.size()]);
	}




    /**
     * output initUIContentLayout method
     */
    public void initUIContentLayout()
    {
        this.setBounds(new Rectangle(0, 0, 1013, 629));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1013, 629));
        contCreator.setBounds(new Rectangle(379, 559, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(379, 559, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(720, 559, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(720, 559, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(379, 600, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(379, 600, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(720, 600, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(720, 600, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(24, 25, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(24, 25, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(29, 559, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(29, 559, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contapplyDepartment.setBounds(new Rectangle(24, 65, 270, 19));
        this.add(contapplyDepartment, new KDLayout.Constraints(24, 65, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contapplier.setBounds(new Rectangle(374, 65, 270, 19));
        this.add(contapplier, new KDLayout.Constraints(374, 65, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcontact.setBounds(new Rectangle(720, 65, 270, 19));
        this.add(contcontact, new KDLayout.Constraints(720, 65, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contvisitor.setBounds(new Rectangle(24, 135, 270, 19));
        this.add(contvisitor, new KDLayout.Constraints(24, 135, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contvisitorContract.setBounds(new Rectangle(720, 135, 270, 19));
        this.add(contvisitorContract, new KDLayout.Constraints(720, 135, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contdestinationAddress.setBounds(new Rectangle(24, 339, 300, 19));
        this.add(contdestinationAddress, new KDLayout.Constraints(24, 339, 300, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpickUpTime.setBounds(new Rectangle(365, 339, 300, 19));
        this.add(contpickUpTime, new KDLayout.Constraints(365, 339, 300, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contvisitorQty.setBounds(new Rectangle(374, 135, 270, 19));
        this.add(contvisitorQty, new KDLayout.Constraints(374, 135, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfeeFrom.setBounds(new Rectangle(24, 390, 300, 19));
        this.add(contfeeFrom, new KDLayout.Constraints(24, 390, 300, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfeeTo.setBounds(new Rectangle(365, 390, 300, 19));
        this.add(contfeeTo, new KDLayout.Constraints(365, 390, 300, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contusedDate.setBounds(new Rectangle(374, 25, 270, 19));
        this.add(contusedDate, new KDLayout.Constraints(374, 25, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditDate.setBounds(new Rectangle(29, 600, 270, 19));
        this.add(contauditDate, new KDLayout.Constraints(29, 600, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(720, 25, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(720, 25, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        labelPurpose.setBounds(new Rectangle(29, 171, 100, 19));
        this.add(labelPurpose, new KDLayout.Constraints(29, 171, 100, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpickUpInCompany.setBounds(new Rectangle(701, 339, 300, 19));
        this.add(contpickUpInCompany, new KDLayout.Constraints(701, 339, 300, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contpickUpOutCompany.setBounds(new Rectangle(701, 390, 300, 19));
        this.add(contpickUpOutCompany, new KDLayout.Constraints(701, 390, 300, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator8.setBounds(new Rectangle(24, 111, 971, 5));
        this.add(kDSeparator8, new KDLayout.Constraints(24, 111, 971, 5, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator9.setBounds(new Rectangle(24, 308, 971, 8));
        this.add(kDSeparator9, new KDLayout.Constraints(24, 308, 971, 8, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator10.setBounds(new Rectangle(28, 424, 971, 8));
        this.add(kDSeparator10, new KDLayout.Constraints(28, 424, 971, 8, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        labelStatement.setBounds(new Rectangle(24, 440, 100, 19));
        this.add(labelStatement, new KDLayout.Constraints(24, 440, 100, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpurpose.setBounds(new Rectangle(24, 194, 971, 96));
        this.add(contpurpose, new KDLayout.Constraints(24, 194, 971, 96, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contremark.setBounds(new Rectangle(24, 463, 971, 74));
        this.add(contremark, new KDLayout.Constraints(24, 463, 971, 74, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator11.setBounds(new Rectangle(28, 545, 971, 8));
        this.add(kDSeparator11, new KDLayout.Constraints(28, 545, 971, 8, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contCreator
        contCreator.setBoundEditor(prmtCreator);
        //contCreateTime
        contCreateTime.setBoundEditor(kDDateCreateTime);
        //contLastUpdateUser
        contLastUpdateUser.setBoundEditor(prmtLastUpdateUser);
        //contLastUpdateTime
        contLastUpdateTime.setBoundEditor(kDDateLastUpdateTime);
        //contNumber
        contNumber.setBoundEditor(txtNumber);
        //contAuditor
        contAuditor.setBoundEditor(prmtAuditor);
        //contapplyDepartment
        contapplyDepartment.setBoundEditor(prmtapplyDepartment);
        //contapplier
        contapplier.setBoundEditor(prmtapplier);
        //contcontact
        contcontact.setBoundEditor(txtcontact);
        //contvisitor
        contvisitor.setBoundEditor(txtvisitor);
        //contvisitorContract
        contvisitorContract.setBoundEditor(txtvisitorContract);
        //contdestinationAddress
        contdestinationAddress.setBoundEditor(txtdestinationAddress);
        //contpickUpTime
        contpickUpTime.setBoundEditor(pickUpTime);
        //contvisitorQty
        contvisitorQty.setBoundEditor(txtvisitorQty);
        //contfeeFrom
        contfeeFrom.setBoundEditor(txtfeeFrom);
        //contfeeTo
        contfeeTo.setBoundEditor(txtfeeTo);
        //contusedDate
        contusedDate.setBoundEditor(pkusedDate);
        //contauditDate
        contauditDate.setBoundEditor(pkauditDate);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //contpickUpInCompany
        contpickUpInCompany.setBoundEditor(prmtpickUpInCompany);
        //contpickUpOutCompany
        contpickUpOutCompany.setBoundEditor(txtpickUpOutCompany);
        //contpurpose
        contpurpose.setBoundEditor(scrollPanepurpose);
        //scrollPanepurpose
        scrollPanepurpose.getViewport().add(txtpurpose, null);
        //contremark
        contremark.setBoundEditor(scrollPaneremark);
        //scrollPaneremark
        scrollPaneremark.getViewport().add(txtremark, null);

    }


    /**
     * output initUIMenuBarLayout method
     */
    public void initUIMenuBarLayout()
    {
        this.menuBar.add(menuFile);
        this.menuBar.add(menuEdit);
        this.menuBar.add(MenuService);
        this.menuBar.add(menuView);
        this.menuBar.add(menuBiz);
        this.menuBar.add(menuTable1);
        this.menuBar.add(menuTool);
        this.menuBar.add(menuWorkflow);
        this.menuBar.add(menuHelp);
        //menuFile
        menuFile.add(menuItemAddNew);
        menuFile.add(kDSeparator1);
        menuFile.add(menuItemCloudFeed);
        menuFile.add(menuItemSave);
        menuFile.add(menuItemCloudScreen);
        menuFile.add(menuItemSubmit);
        menuFile.add(menuItemCloudShare);
        menuFile.add(menuSubmitOption);
        menuFile.add(kdSeparatorFWFile1);
        menuFile.add(rMenuItemSubmit);
        menuFile.add(rMenuItemSubmitAndAddNew);
        menuFile.add(rMenuItemSubmitAndPrint);
        menuFile.add(separatorFile1);
        menuFile.add(MenuItemAttachment);
        menuFile.add(kDSeparator2);
        menuFile.add(menuItemPageSetup);
        menuFile.add(menuItemPrint);
        menuFile.add(menuItemPrintPreview);
        menuFile.add(kDSeparator6);
        menuFile.add(menuItemSendMail);
        menuFile.add(kDSeparator3);
        menuFile.add(menuItemExitCurrent);
        //menuSubmitOption
        menuSubmitOption.add(chkMenuItemSubmitAndAddNew);
        menuSubmitOption.add(chkMenuItemSubmitAndPrint);
        //menuEdit
        menuEdit.add(menuItemCopy);
        menuEdit.add(menuItemEdit);
        menuEdit.add(menuItemRemove);
        menuEdit.add(kDSeparator4);
        menuEdit.add(menuItemReset);
        menuEdit.add(separator1);
        menuEdit.add(menuItemCreateFrom);
        menuEdit.add(menuItemCreateTo);
        menuEdit.add(menuItemCopyFrom);
        menuEdit.add(separatorEdit1);
        menuEdit.add(menuItemEnterToNextRow);
        menuEdit.add(separator2);
        //MenuService
        MenuService.add(MenuItemKnowStore);
        MenuService.add(MenuItemAnwser);
        MenuService.add(SepratorService);
        MenuService.add(MenuItemRemoteAssist);
        //menuView
        menuView.add(menuItemFirst);
        menuView.add(menuItemPre);
        menuView.add(menuItemNext);
        menuView.add(menuItemLast);
        menuView.add(separator3);
        menuView.add(menuItemTraceUp);
        menuView.add(menuItemTraceDown);
        menuView.add(kDSeparator7);
        menuView.add(menuItemLocate);
        //menuBiz
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        menuBiz.add(MenuItemVoucher);
        menuBiz.add(menuItemDelVoucher);
        //menuTable1
        menuTable1.add(menuItemAddLine);
        menuTable1.add(menuItemCopyLine);
        menuTable1.add(menuItemInsertLine);
        menuTable1.add(menuItemRemoveLine);
        //menuTool
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemMsgFormat);
        menuTool.add(menuItemCalculator);
        menuTool.add(menuItemToolBarCustom);
        //menuWorkflow
        menuWorkflow.add(menuItemStartWorkFlow);
        menuWorkflow.add(separatorWF1);
        menuWorkflow.add(menuItemViewSubmitProccess);
        menuWorkflow.add(menuItemViewDoProccess);
        menuWorkflow.add(MenuItemWFG);
        menuWorkflow.add(menuItemWorkFlowList);
        menuWorkflow.add(separatorWF2);
        menuWorkflow.add(menuItemMultiapprove);
        menuWorkflow.add(menuItemNextPerson);
        menuWorkflow.add(menuItemAuditResult);
        menuWorkflow.add(kDSeparator5);
        menuWorkflow.add(kDMenuItemSendMessage);
        //menuHelp
        menuHelp.add(menuItemHelp);
        menuHelp.add(kDSeparator12);
        menuHelp.add(menuItemRegPro);
        menuHelp.add(menuItemPersonalSite);
        menuHelp.add(helpseparatorDiv);
        menuHelp.add(menuitemProductval);
        menuHelp.add(kDSeparatorProduct);
        menuHelp.add(menuItemAbout);

    }

    /**
     * output initUIToolBarLayout method
     */
    public void initUIToolBarLayout()
    {
        this.toolBar.add(btnAddNew);
        this.toolBar.add(btnCloud);
        this.toolBar.add(btnEdit);
        this.toolBar.add(btnXunTong);
        this.toolBar.add(btnSave);
        this.toolBar.add(kDSeparatorCloud);
        this.toolBar.add(btnReset);
        this.toolBar.add(btnSubmit);
        this.toolBar.add(btnCopy);
        this.toolBar.add(btnRemove);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);
        this.toolBar.add(btnAttachment);
        this.toolBar.add(separatorFW1);
        this.toolBar.add(btnPageSetup);
        this.toolBar.add(btnPrint);
        this.toolBar.add(btnPrintPreview);
        this.toolBar.add(separatorFW2);
        this.toolBar.add(btnFirst);
        this.toolBar.add(btnPre);
        this.toolBar.add(btnNext);
        this.toolBar.add(btnLast);
        this.toolBar.add(separatorFW3);
        this.toolBar.add(btnTraceUp);
        this.toolBar.add(btnTraceDown);
        this.toolBar.add(btnWorkFlowG);
        this.toolBar.add(btnSignature);
        this.toolBar.add(btnViewSignature);
        this.toolBar.add(separatorFW4);
        this.toolBar.add(btnNumberSign);
        this.toolBar.add(separatorFW7);
        this.toolBar.add(btnCreateFrom);
        this.toolBar.add(btnCopyFrom);
        this.toolBar.add(btnCreateTo);
        this.toolBar.add(separatorFW5);
        this.toolBar.add(separatorFW8);
        this.toolBar.add(btnAddLine);
        this.toolBar.add(btnCopyLine);
        this.toolBar.add(btnInsertLine);
        this.toolBar.add(btnRemoveLine);
        this.toolBar.add(separatorFW6);
        this.toolBar.add(separatorFW9);
        this.toolBar.add(btnVoucher);
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(btnNextPerson);
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("applyDepartment", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtapplyDepartment, "data");
		dataBinder.registerBinding("applier", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtapplier, "data");
		dataBinder.registerBinding("contact", String.class, this.txtcontact, "text");
		dataBinder.registerBinding("visitor", String.class, this.txtvisitor, "text");
		dataBinder.registerBinding("visitorContract", String.class, this.txtvisitorContract, "text");
		dataBinder.registerBinding("destinationAddress", String.class, this.txtdestinationAddress, "text");
		dataBinder.registerBinding("pickUpTime", java.sql.Time.class, this.pickUpTime, "value");
		dataBinder.registerBinding("visitorQty", int.class, this.txtvisitorQty, "value");
		dataBinder.registerBinding("feeFrom", java.math.BigDecimal.class, this.txtfeeFrom, "value");
		dataBinder.registerBinding("feeTo", java.math.BigDecimal.class, this.txtfeeTo, "value");
		dataBinder.registerBinding("usedDate", java.util.Date.class, this.pkusedDate, "value");
		dataBinder.registerBinding("auditDate", java.util.Date.class, this.pkauditDate, "value");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.custom.rentalapplicationform.billStatus.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("pickUpInCompany", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtpickUpInCompany, "data");
		dataBinder.registerBinding("pickUpOutCompany", String.class, this.txtpickUpOutCompany, "text");
		dataBinder.registerBinding("purpose", String.class, this.txtpurpose, "text");
		dataBinder.registerBinding("remark", String.class, this.txtremark, "text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.rentalapplicationform.app.RentalApplicationOfBusinessCarEditUIHandler";
	}
	public IUIActionPostman prepareInit() {
		IUIActionPostman clientHanlder = super.prepareInit();
		if (clientHanlder != null) {
			RequestContext request = new RequestContext();
    		request.setClassName(getUIHandlerClassName());
			clientHanlder.setRequestContext(request);
		}
		return clientHanlder;
    }
	
	public boolean isPrepareInit() {
    	return false;
    }
    protected void initUIP() {
        super.initUIP();
    }


    /**
     * output onShow method
     */
    public void onShow() throws Exception
    {
        super.onShow();
        this.prmtapplyDepartment.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.rentalapplicationform.RentalApplicationOfBusinessCarInfo)ov;
    }
    protected void removeByPK(IObjectPK pk) throws Exception {
    	IObjectValue editData = this.editData;
    	super.removeByPK(pk);
    	recycleNumberByOrg(editData,"NONE",editData.getString("number"));
    }
    
    protected void recycleNumberByOrg(IObjectValue editData,String orgType,String number) {
        if (!StringUtils.isEmpty(number))
        {
            try {
            	String companyID = null;            
            	com.kingdee.eas.base.codingrule.ICodingRuleManager iCodingRuleManager = com.kingdee.eas.base.codingrule.CodingRuleManagerFactory.getRemoteInstance();
				if(!com.kingdee.util.StringUtils.isEmpty(orgType) && !"NONE".equalsIgnoreCase(orgType) && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType))!=null) {
					companyID =com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType)).getString("id");
				}
				else if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit() != null) {
					companyID = ((com.kingdee.eas.basedata.org.OrgUnitInfo)com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit()).getString("id");
            	}				
				if (!StringUtils.isEmpty(companyID) && iCodingRuleManager.isExist(editData, companyID) && iCodingRuleManager.isUseIntermitNumber(editData, companyID)) {
					iCodingRuleManager.recycleNumber(editData,companyID,number);					
				}
            }
            catch (Exception e)
            {
                handUIException(e);
            }
        }
    }
    protected void setAutoNumberByOrg(String orgType) {
    	if (editData == null) return;
		if (editData.getNumber() == null) {
            try {
            	String companyID = null;
				if(!com.kingdee.util.StringUtils.isEmpty(orgType) && !"NONE".equalsIgnoreCase(orgType) && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType))!=null) {
					companyID = com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType)).getString("id");
				}
				else if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit() != null) {
					companyID = ((com.kingdee.eas.basedata.org.OrgUnitInfo)com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit()).getString("id");
            	}
				com.kingdee.eas.base.codingrule.ICodingRuleManager iCodingRuleManager = com.kingdee.eas.base.codingrule.CodingRuleManagerFactory.getRemoteInstance();
		        if (iCodingRuleManager.isExist(editData, companyID)) {
		            if (iCodingRuleManager.isAddView(editData, companyID)) {
		            	editData.setNumber(iCodingRuleManager.getNumber(editData,companyID));
		            }
	                txtNumber.setEnabled(false);
		        }
            }
            catch (Exception e) {
                handUIException(e);
                this.oldData = editData;
                com.kingdee.eas.util.SysUtil.abort();
            } 
        } 
        else {
            if (editData.getNumber().trim().length() > 0) {
                txtNumber.setText(editData.getNumber());
            }
        }
    }

    /**
     * output loadFields method
     */
    public void loadFields()
    {
        		setAutoNumberByOrg("NONE");
        dataBinder.loadFields();
    }
		protected void setOrgF7(KDBizPromptBox f7,com.kingdee.eas.basedata.org.OrgType orgType) throws Exception
		{
			com.kingdee.eas.basedata.org.client.f7.NewOrgUnitFilterInfoProducer oufip = new com.kingdee.eas.basedata.org.client.f7.NewOrgUnitFilterInfoProducer(orgType);
			oufip.getModel().setIsCUFilter(true);
			f7.setFilterInfoProducer(oufip);
		}

    /**
     * output storeFields method
     */
    public void storeFields()
    {
		dataBinder.storeFields();
    }

	/**
	 * ????????У??
	 */
	protected void registerValidator() {
    	getValidateHelper().setCustomValidator( getValidator() );
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("applyDepartment", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("applier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contact", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("visitor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("visitorContract", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("destinationAddress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("pickUpTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("visitorQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("feeFrom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("feeTo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("usedDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("pickUpInCompany", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("pickUpOutCompany", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("purpose", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("remark", ValidateHelper.ON_SAVE);    		
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
        if (STATUS_ADDNEW.equals(this.oprtState)) {
        } else if (STATUS_EDIT.equals(this.oprtState)) {
        } else if (STATUS_VIEW.equals(this.oprtState)) {
        } else if (STATUS_FINDVIEW.equals(this.oprtState)) {
        }
    }

    /**
     * output prmtapplier_dataChang method
     */
    protected void prmtapplier_dataChang(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output getSelectors method
     */
    public SelectorItemCollection getSelectors()
    {
        SelectorItemCollection sic = new SelectorItemCollection();
		String selectorAll = System.getProperty("selector.all");
		if(StringUtils.isEmpty(selectorAll)){
			selectorAll = "true";
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("creator.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("creator.id"));
        	sic.add(new SelectorItemInfo("creator.number"));
        	sic.add(new SelectorItemInfo("creator.name"));
		}
        sic.add(new SelectorItemInfo("createTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("lastUpdateUser.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("lastUpdateUser.id"));
        	sic.add(new SelectorItemInfo("lastUpdateUser.number"));
        	sic.add(new SelectorItemInfo("lastUpdateUser.name"));
		}
        sic.add(new SelectorItemInfo("lastUpdateTime"));
        sic.add(new SelectorItemInfo("number"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("auditor.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("auditor.id"));
        	sic.add(new SelectorItemInfo("auditor.number"));
        	sic.add(new SelectorItemInfo("auditor.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("applyDepartment.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("applyDepartment.id"));
        	sic.add(new SelectorItemInfo("applyDepartment.number"));
        	sic.add(new SelectorItemInfo("applyDepartment.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("applier.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("applier.id"));
        	sic.add(new SelectorItemInfo("applier.number"));
        	sic.add(new SelectorItemInfo("applier.name"));
		}
        sic.add(new SelectorItemInfo("contact"));
        sic.add(new SelectorItemInfo("visitor"));
        sic.add(new SelectorItemInfo("visitorContract"));
        sic.add(new SelectorItemInfo("destinationAddress"));
        sic.add(new SelectorItemInfo("pickUpTime"));
        sic.add(new SelectorItemInfo("visitorQty"));
        sic.add(new SelectorItemInfo("feeFrom"));
        sic.add(new SelectorItemInfo("feeTo"));
        sic.add(new SelectorItemInfo("usedDate"));
        sic.add(new SelectorItemInfo("auditDate"));
        sic.add(new SelectorItemInfo("billStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("pickUpInCompany.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("pickUpInCompany.id"));
        	sic.add(new SelectorItemInfo("pickUpInCompany.number"));
        	sic.add(new SelectorItemInfo("pickUpInCompany.name"));
		}
        sic.add(new SelectorItemInfo("pickUpOutCompany"));
        sic.add(new SelectorItemInfo("purpose"));
        sic.add(new SelectorItemInfo("remark"));
        return sic;
    }        
    	

    /**
     * output actionSubmit_actionPerformed method
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmit_actionPerformed(e);
    }
    	

    /**
     * output actionPrint_actionPerformed method
     */
    public void actionPrint_actionPerformed(ActionEvent e) throws Exception
    {
        ArrayList idList = new ArrayList();
    	if (editData != null && !StringUtils.isEmpty(editData.getString("id"))) {
    		idList.add(editData.getString("id"));
    	}
        if (idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
            return;
        com.kingdee.bos.ctrl.kdf.data.impl.BOSQueryDelegate data = new com.kingdee.eas.framework.util.CommonDataProvider(idList,getTDQueryPK());
        com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
        appHlp.print(getTDFileName(), data, javax.swing.SwingUtilities.getWindowAncestor(this));
    }
    	

    /**
     * output actionPrintPreview_actionPerformed method
     */
    public void actionPrintPreview_actionPerformed(ActionEvent e) throws Exception
    {
        ArrayList idList = new ArrayList();
        if (editData != null && !StringUtils.isEmpty(editData.getString("id"))) {
    		idList.add(editData.getString("id"));
    	}
        if (idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
            return;
        com.kingdee.bos.ctrl.kdf.data.impl.BOSQueryDelegate data = new com.kingdee.eas.framework.util.CommonDataProvider(idList,getTDQueryPK());
        com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
        appHlp.printPreview(getTDFileName(), data, javax.swing.SwingUtilities.getWindowAncestor(this));
    }
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.rentalapplicationform.RentalApplicationOfBusinessCarFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.rentalapplicationform.RentalApplicationOfBusinessCarFactory.getRemoteInstance().unAudit(editData);
    }
	public RequestContext prepareActionSubmit(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionSubmit(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionSubmit() {
    	return false;
    }
	public RequestContext prepareActionPrint(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionPrint(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionPrint() {
    	return false;
    }
	public RequestContext prepareActionPrintPreview(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionPrintPreview(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionPrintPreview() {
    	return false;
    }
	public RequestContext prepareActionAudit(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAudit() {
    	return false;
    }
	public RequestContext prepareActionUnAudit(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionUnAudit() {
    	return false;
    }

    /**
     * output ActionAudit class
     */     
    protected class ActionAudit extends ItemAction {     
    
        public ActionAudit()
        {
            this(null);
        }

        public ActionAudit(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionAudit.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAudit.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAudit.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractRentalApplicationOfBusinessCarEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionUnAudit class
     */     
    protected class ActionUnAudit extends ItemAction {     
    
        public ActionUnAudit()
        {
            this(null);
        }

        public ActionUnAudit(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionUnAudit.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnAudit.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnAudit.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractRentalApplicationOfBusinessCarEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.rentalapplicationform.client", "RentalApplicationOfBusinessCarEditUI");
    }
    /**
     * output isBindWorkFlow method
     */
    public boolean isBindWorkFlow()
    {
        return true;
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.rentalapplicationform.client.RentalApplicationOfBusinessCarEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.rentalapplicationform.RentalApplicationOfBusinessCarFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.rentalapplicationform.RentalApplicationOfBusinessCarInfo objectValue = new com.kingdee.eas.custom.rentalapplicationform.RentalApplicationOfBusinessCarInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/rentalapplicationform/RentalApplicationOfBusinessCar";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.rentalapplicationform.app.RentalApplicationOfBusinessCarQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtapplyDepartment.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"申请部门"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtapplier.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"申请人"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtvisitor.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"来访人员"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtdestinationAddress.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"接机/站地点"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pickUpTime.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"接机/站时间"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkusedDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"车辆使用日期"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {        
        return null;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
				vo.put("visitorQty",new Integer(1));
vo.put("billStatus","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}