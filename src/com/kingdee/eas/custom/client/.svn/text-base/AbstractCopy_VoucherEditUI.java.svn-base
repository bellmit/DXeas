/**
 * output package name
 */
package com.kingdee.eas.custom.client;

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
public abstract class AbstractCopy_VoucherEditUI extends com.kingdee.eas.framework.client.BillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCopy_VoucherEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAddAssistRecord;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnInsertAssistRecord;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnVerify;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnRemoveAssistRecord;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer5;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer6;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer7;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer lblCtnCurrency;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer9;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer10;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer11;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer12;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer13;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer14;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer15;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnShowBal;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton importBalance;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAutoVerify;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnImpExchangeRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer8;
    protected com.kingdee.bos.ctrl.swing.KDSpinner spnAttachments;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker dateBizDate;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cbxVoucherType;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker dateBookedDate;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cbxPeriod;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cbxCurrency;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtCreator;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtCashier;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtPoster;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox bizPromptHandler;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtCanceller;
    protected com.kingdee.bos.ctrl.swing.KDSplitPane splitPane;
    protected com.kingdee.bos.ctrl.swing.KDLabel lblTotal;
    protected com.kingdee.bos.ctrl.swing.KDLabel lblLD;
    protected com.kingdee.bos.ctrl.swing.KDLabel lblLC;
    protected com.kingdee.bos.ctrl.swing.KDContainer ctnEntry;
    protected com.kingdee.bos.ctrl.swing.KDContainer ctnRecord;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable tblDetail;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel5;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable tblAssistRecord;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel6;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel7;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel8;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel9;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtCompany;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCompany;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnit;
    protected javax.swing.JToolBar.Separator separator4;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnShowQtyAmnt;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnBookOption;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnEditCashflow;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAdjunct;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAccountBalance;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAssistant;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAdjustVoucher;
    protected javax.swing.JToolBar.Separator wfSpt;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnCheckGrp;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAntiAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAuditBack;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnHandCheck;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnCheck;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAntiCheck;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnPost;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAntiPost;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnBgAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAntiBgAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAuditNext;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnViewmbgCtrlBal;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnLocalAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemAutoBalance;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuImport;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuExport;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuImportFile;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemPrintParameter;
    protected com.kingdee.bos.ctrl.swing.KDMenu menuVchPrintGrp;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator10;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItenColOption;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemCPrint;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemColPrintView;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemCrossPrint;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemCrossPrintView;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemUnit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem miOption;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemBgAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemAntiBgAudit;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemShowQtyAmnt;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator13;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuAuditMessage;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemSubsidiaryLedger;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemSubsidiaryLedgerAssist;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemEditCashflow;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemBookOption;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuViewmbgCtrlBal;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemMgCtrl;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator11;
    protected com.kingdee.bos.ctrl.swing.KDMenu kDMenu1;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuCancle;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuCancelCancel;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator14;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemCheck;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemHandCheck;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemAntiCheck;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemAntiAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuAuditBack;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemPost;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemAntiPost;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemAdjustVoucher;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemAuditNext;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemLocalAudit;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator9;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemAddAssistRecord;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemInsertAssistRecord;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemRemoveAssistRecord;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemVerify;
    protected com.kingdee.eas.fi.gl.VoucherInfo editData = null;
    protected ActionAddAssistRecord actionAddAssistRecord = null;
    protected ActionInsertAssistRecord actionInsertAssistRecord = null;
    protected ActionRemoveAssistRecord actionRemoveAssistRecord = null;
    protected ActionVerify actionVerify = null;
    protected ActionEditCashflow actionEditCashflow = null;
    protected ActionCheck actionCheck = null;
    protected ActionAntiCheck actionAntiCheck = null;
    protected ActionAudit actionAudit = null;
    protected ActionAntiAudit actionAntiAudit = null;
    protected ActionPost actionPost = null;
    protected ActionAntiPost actionAntiPost = null;
    protected ActionShowQtyAmnt actionShowQtyAmnt = null;
    protected ActionBgAudit actionBgAudit = null;
    protected ActionAntiBgAudit actionAntiBgAudit = null;
    protected ActionOption actionOption = null;
    protected ActionBookOption actionBookOption = null;
    protected ActionImport actionImport = null;
    protected ActionPrintOption actionPrintOption = null;
    protected ActionColPrint ActionColPrint = null;
    protected ActionColPrintView actionColPrintView = null;
    protected ActionAccountBalance actionAccountBalance = null;
    protected ActionAssistant actionAssistant = null;
    protected ActionHandCheck actionHandCheck = null;
    protected ActionImportFile actionImportFile = null;
    protected ActionCrossPrint actionCrossPrint = null;
    protected ActionAdjunct actionAdjunct = null;
    protected ActionViewmbgCtrlBal actionViewmbgCtrlBal = null;
    protected ActionVoucherPrintParameter actionVoucherPrintParameter = null;
    protected ActionCrossPrintView actionCrossPrintView = null;
    protected ActionImportBalance actionImportBalance = null;
    protected ActionSubmitPrint actionSubmitPrint = null;
    protected ActionEntryCellDown actionEntryCellDown = null;
    protected ActionSubsidiaryLedger actionSubsidiaryLedger = null;
    protected ActionSubsidiaryLedgerAssist actionSubsidiaryLedgerAssist = null;
    protected ActionAsstCellDown actionAsstCellDown = null;
    protected ActionUnit actionUnit = null;
    protected ActionMgCtrl actionMgCtrl = null;
    protected ActionAdjustVoucher actionAdjustVoucher = null;
    protected ActionLocalAudit actionLocalAudit = null;
    protected ActionAutoVerify actionAutoVerify = null;
    protected ActionAuditNext actionAuditNext = null;
    protected ActionImpExchangeRate actionImpExchangeRate = null;
    protected ActionAuditBack actionAuditBack = null;
    protected ActionAuditMessage actionAuditMessage = null;
    protected ActionAutoBalance actionAutoBalance = null;
    /**
     * output class constructor
     */
    public AbstractCopy_VoucherEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCopy_VoucherEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        //actionPageSetup
        String _tempStr = null;
        actionPageSetup.setEnabled(true);
        actionPageSetup.setDaemonRun(false);

        actionPageSetup.putValue(ItemAction.ACTION_COMMAND_KEY, "pageSetup");
        _tempStr = resHelper.getString("ActionPageSetup.SHORT_DESCRIPTION");
        actionPageSetup.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPageSetup.LONG_DESCRIPTION");
        actionPageSetup.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPageSetup.NAME");
        actionPageSetup.putValue(ItemAction.NAME, _tempStr);
         this.actionPageSetup.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionPageSetup.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionPageSetup.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionCalculator
        actionCalculator.setEnabled(true);
        actionCalculator.setDaemonRun(false);

        actionCalculator.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("F12"));
        actionCalculator.putValue(ItemAction.ACTION_COMMAND_KEY, "calculator");
        _tempStr = resHelper.getString("ActionCalculator.SHORT_DESCRIPTION");
        actionCalculator.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionCalculator.LONG_DESCRIPTION");
        actionCalculator.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionCalculator.NAME");
        actionCalculator.putValue(ItemAction.NAME, _tempStr);
         this.actionCalculator.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionCalculator.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionCalculator.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionExport
        actionExport.setEnabled(false);
        actionExport.setDaemonRun(false);

        actionExport.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl shift G"));
        _tempStr = resHelper.getString("ActionExport.SHORT_DESCRIPTION");
        actionExport.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionExport.LONG_DESCRIPTION");
        actionExport.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionExport.NAME");
        actionExport.putValue(ItemAction.NAME, _tempStr);
         this.actionExport.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionSave
        actionSave.setEnabled(true);
        actionSave.setDaemonRun(false);

        actionSave.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl shift S"));
        actionSave.putValue(ItemAction.ACTION_COMMAND_KEY, "save");
        _tempStr = resHelper.getString("ActionSave.SHORT_DESCRIPTION");
        actionSave.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionSave.LONG_DESCRIPTION");
        actionSave.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionSave.NAME");
        actionSave.putValue(ItemAction.NAME, _tempStr);
         this.actionSave.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionSave.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionSave.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionSubmit
        actionSubmit.setEnabled(true);
        actionSubmit.setDaemonRun(false);

        actionSubmit.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl S"));
        actionSubmit.putValue(ItemAction.ACTION_COMMAND_KEY, "submit");
        _tempStr = resHelper.getString("ActionSubmit.SHORT_DESCRIPTION");
        actionSubmit.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionSubmit.LONG_DESCRIPTION");
        actionSubmit.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionSubmit.NAME");
        actionSubmit.putValue(ItemAction.NAME, _tempStr);
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionCancel
        actionCancel.setEnabled(true);
        actionCancel.setDaemonRun(false);

        actionCancel.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("alt J"));
        actionCancel.putValue(ItemAction.ACTION_COMMAND_KEY, "cancel");
        actionCancel.putValue(ItemAction.MNEMONIC_KEY, new Integer(KeyEvent.VK_N));
        _tempStr = resHelper.getString("ActionCancel.SHORT_DESCRIPTION");
        actionCancel.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionCancel.LONG_DESCRIPTION");
        actionCancel.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionCancel.NAME");
        actionCancel.putValue(ItemAction.NAME, _tempStr);
         this.actionCancel.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionCancel.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionCancel.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionCancelCancel
        actionCancelCancel.setEnabled(true);
        actionCancelCancel.setDaemonRun(false);

        actionCancelCancel.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("alt I"));
        actionCancelCancel.putValue(ItemAction.ACTION_COMMAND_KEY, "cancelCancel");
        actionCancelCancel.putValue(ItemAction.MNEMONIC_KEY, new Integer(KeyEvent.VK_E));
        _tempStr = resHelper.getString("ActionCancelCancel.SHORT_DESCRIPTION");
        actionCancelCancel.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionCancelCancel.LONG_DESCRIPTION");
        actionCancelCancel.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionCancelCancel.NAME");
        actionCancelCancel.putValue(ItemAction.NAME, _tempStr);
        this.actionCancelCancel.setBindWorkFlow(true);
         this.actionCancelCancel.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionCancelCancel.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionCancelCancel.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionFirst
        actionFirst.setEnabled(true);
        actionFirst.setDaemonRun(false);

        actionFirst.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl shift <"));
        actionFirst.putValue(ItemAction.ACTION_COMMAND_KEY, "first");
        _tempStr = resHelper.getString("ActionFirst.SHORT_DESCRIPTION");
        actionFirst.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionFirst.LONG_DESCRIPTION");
        actionFirst.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionFirst.NAME");
        actionFirst.putValue(ItemAction.NAME, _tempStr);
         this.actionFirst.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionFirst.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionFirst.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionPre
        actionPre.setEnabled(true);
        actionPre.setDaemonRun(false);

        actionPre.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl <"));
        actionPre.putValue(ItemAction.ACTION_COMMAND_KEY, "pre");
        _tempStr = resHelper.getString("ActionPre.SHORT_DESCRIPTION");
        actionPre.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPre.LONG_DESCRIPTION");
        actionPre.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPre.NAME");
        actionPre.putValue(ItemAction.NAME, _tempStr);
         this.actionPre.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionPre.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionPre.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionNext
        actionNext.setEnabled(true);
        actionNext.setDaemonRun(false);

        actionNext.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl >"));
        actionNext.putValue(ItemAction.ACTION_COMMAND_KEY, "next");
        _tempStr = resHelper.getString("ActionNext.SHORT_DESCRIPTION");
        actionNext.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionNext.LONG_DESCRIPTION");
        actionNext.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionNext.NAME");
        actionNext.putValue(ItemAction.NAME, _tempStr);
         this.actionNext.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionNext.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionNext.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionLast
        actionLast.setEnabled(true);
        actionLast.setDaemonRun(false);

        actionLast.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl shift >"));
        actionLast.putValue(ItemAction.ACTION_COMMAND_KEY, "last");
        _tempStr = resHelper.getString("ActionLast.SHORT_DESCRIPTION");
        actionLast.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionLast.LONG_DESCRIPTION");
        actionLast.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionLast.NAME");
        actionLast.putValue(ItemAction.NAME, _tempStr);
         this.actionLast.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionLast.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionLast.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionPrint
        actionPrint.setEnabled(true);
        actionPrint.setDaemonRun(false);

        actionPrint.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl P"));
        actionPrint.putValue(ItemAction.ACTION_COMMAND_KEY, "print");
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

        actionPrintPreview.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl shift P"));
        actionPrintPreview.putValue(ItemAction.ACTION_COMMAND_KEY, "printPreview");
        _tempStr = resHelper.getString("ActionPrintPreview.SHORT_DESCRIPTION");
        actionPrintPreview.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrintPreview.LONG_DESCRIPTION");
        actionPrintPreview.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrintPreview.NAME");
        actionPrintPreview.putValue(ItemAction.NAME, _tempStr);
         this.actionPrintPreview.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionPrintPreview.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionPrintPreview.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionCopy
        actionCopy.setEnabled(true);
        actionCopy.setDaemonRun(false);

        actionCopy.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl shift C"));
        actionCopy.putValue(ItemAction.ACTION_COMMAND_KEY, "copy");
        _tempStr = resHelper.getString("ActionCopy.SHORT_DESCRIPTION");
        actionCopy.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionCopy.LONG_DESCRIPTION");
        actionCopy.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionCopy.NAME");
        actionCopy.putValue(ItemAction.NAME, _tempStr);
         this.actionCopy.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionCopy.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionCopy.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionAddNew
        actionAddNew.setEnabled(true);
        actionAddNew.setDaemonRun(false);

        actionAddNew.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl N"));
        actionAddNew.putValue(ItemAction.ACTION_COMMAND_KEY, "addNew");
        _tempStr = resHelper.getString("ActionAddNew.SHORT_DESCRIPTION");
        actionAddNew.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionAddNew.LONG_DESCRIPTION");
        actionAddNew.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionAddNew.NAME");
        actionAddNew.putValue(ItemAction.NAME, _tempStr);
         this.actionAddNew.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAddNew.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionAddNew.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionAddLine
        actionAddLine.setEnabled(true);
        actionAddLine.setDaemonRun(false);

        actionAddLine.putValue(ItemAction.ACTION_COMMAND_KEY, "addLine");
        _tempStr = resHelper.getString("ActionAddLine.SHORT_DESCRIPTION");
        actionAddLine.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionAddLine.LONG_DESCRIPTION");
        actionAddLine.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionAddLine.NAME");
        actionAddLine.putValue(ItemAction.NAME, _tempStr);
         this.actionAddLine.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAddLine.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionAddLine.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionInsertLine
        actionInsertLine.setEnabled(true);
        actionInsertLine.setDaemonRun(false);

        actionInsertLine.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl I"));
        actionInsertLine.putValue(ItemAction.ACTION_COMMAND_KEY, "insertLine");
        _tempStr = resHelper.getString("ActionInsertLine.SHORT_DESCRIPTION");
        actionInsertLine.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionInsertLine.LONG_DESCRIPTION");
        actionInsertLine.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionInsertLine.NAME");
        actionInsertLine.putValue(ItemAction.NAME, _tempStr);
         this.actionInsertLine.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionInsertLine.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionInsertLine.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionRemoveLine
        actionRemoveLine.setEnabled(true);
        actionRemoveLine.setDaemonRun(false);

        actionRemoveLine.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl D"));
        actionRemoveLine.putValue(ItemAction.ACTION_COMMAND_KEY, "removeLine");
        _tempStr = resHelper.getString("ActionRemoveLine.SHORT_DESCRIPTION");
        actionRemoveLine.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionRemoveLine.LONG_DESCRIPTION");
        actionRemoveLine.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionRemoveLine.NAME");
        actionRemoveLine.putValue(ItemAction.NAME, _tempStr);
         this.actionRemoveLine.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionRemoveLine.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionRemoveLine.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionTraceUp
        actionTraceUp.setEnabled(false);
        actionTraceUp.setDaemonRun(false);

        actionTraceUp.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("F8"));
        actionTraceUp.putValue(ItemAction.MNEMONIC_KEY, new Integer(KeyEvent.VK_U));
        _tempStr = resHelper.getString("ActionTraceUp.SHORT_DESCRIPTION");
        actionTraceUp.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionTraceUp.LONG_DESCRIPTION");
        actionTraceUp.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionTraceUp.NAME");
        actionTraceUp.putValue(ItemAction.NAME, _tempStr);
         this.actionTraceUp.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionViewSubmitProccess
        actionViewSubmitProccess.setEnabled(false);
        actionViewSubmitProccess.setDaemonRun(false);

        _tempStr = resHelper.getString("ActionViewSubmitProccess.SHORT_DESCRIPTION");
        actionViewSubmitProccess.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionViewSubmitProccess.LONG_DESCRIPTION");
        actionViewSubmitProccess.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionViewSubmitProccess.NAME");
        actionViewSubmitProccess.putValue(ItemAction.NAME, _tempStr);
         this.actionViewSubmitProccess.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionViewDoProccess
        actionViewDoProccess.setEnabled(true);
        actionViewDoProccess.setDaemonRun(false);

        _tempStr = resHelper.getString("ActionViewDoProccess.SHORT_DESCRIPTION");
        actionViewDoProccess.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionViewDoProccess.LONG_DESCRIPTION");
        actionViewDoProccess.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionViewDoProccess.NAME");
        actionViewDoProccess.putValue(ItemAction.NAME, _tempStr);
         this.actionViewDoProccess.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionAddAssistRecord
        this.actionAddAssistRecord = new ActionAddAssistRecord(this);
        getActionManager().registerAction("actionAddAssistRecord", actionAddAssistRecord);
         this.actionAddAssistRecord.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAddAssistRecord.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionAddAssistRecord.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionInsertAssistRecord
        this.actionInsertAssistRecord = new ActionInsertAssistRecord(this);
        getActionManager().registerAction("actionInsertAssistRecord", actionInsertAssistRecord);
         this.actionInsertAssistRecord.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionInsertAssistRecord.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionInsertAssistRecord.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionRemoveAssistRecord
        this.actionRemoveAssistRecord = new ActionRemoveAssistRecord(this);
        getActionManager().registerAction("actionRemoveAssistRecord", actionRemoveAssistRecord);
         this.actionRemoveAssistRecord.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionRemoveAssistRecord.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionRemoveAssistRecord.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionVerify
        this.actionVerify = new ActionVerify(this);
        getActionManager().registerAction("actionVerify", actionVerify);
         this.actionVerify.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionVerify.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionVerify.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionEditCashflow
        this.actionEditCashflow = new ActionEditCashflow(this);
        getActionManager().registerAction("actionEditCashflow", actionEditCashflow);
         this.actionEditCashflow.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionEditCashflow.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionEditCashflow.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionCheck
        this.actionCheck = new ActionCheck(this);
        getActionManager().registerAction("actionCheck", actionCheck);
         this.actionCheck.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionCheck.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionCheck.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionAntiCheck
        this.actionAntiCheck = new ActionAntiCheck(this);
        getActionManager().registerAction("actionAntiCheck", actionAntiCheck);
         this.actionAntiCheck.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAntiCheck.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionAntiCheck.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionAudit
        this.actionAudit = new ActionAudit(this);
        getActionManager().registerAction("actionAudit", actionAudit);
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionAntiAudit
        this.actionAntiAudit = new ActionAntiAudit(this);
        getActionManager().registerAction("actionAntiAudit", actionAntiAudit);
         this.actionAntiAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAntiAudit.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionAntiAudit.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionPost
        this.actionPost = new ActionPost(this);
        getActionManager().registerAction("actionPost", actionPost);
         this.actionPost.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionPost.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionPost.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionAntiPost
        this.actionAntiPost = new ActionAntiPost(this);
        getActionManager().registerAction("actionAntiPost", actionAntiPost);
         this.actionAntiPost.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAntiPost.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionAntiPost.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionShowQtyAmnt
        this.actionShowQtyAmnt = new ActionShowQtyAmnt(this);
        getActionManager().registerAction("actionShowQtyAmnt", actionShowQtyAmnt);
         this.actionShowQtyAmnt.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionShowQtyAmnt.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionShowQtyAmnt.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionBgAudit
        this.actionBgAudit = new ActionBgAudit(this);
        getActionManager().registerAction("actionBgAudit", actionBgAudit);
         this.actionBgAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionBgAudit.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionBgAudit.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionAntiBgAudit
        this.actionAntiBgAudit = new ActionAntiBgAudit(this);
        getActionManager().registerAction("actionAntiBgAudit", actionAntiBgAudit);
         this.actionAntiBgAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAntiBgAudit.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionAntiBgAudit.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionOption
        this.actionOption = new ActionOption(this);
        getActionManager().registerAction("actionOption", actionOption);
         this.actionOption.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionOption.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionOption.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionBookOption
        this.actionBookOption = new ActionBookOption(this);
        getActionManager().registerAction("actionBookOption", actionBookOption);
         this.actionBookOption.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionBookOption.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionBookOption.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionImport
        this.actionImport = new ActionImport(this);
        getActionManager().registerAction("actionImport", actionImport);
         this.actionImport.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionPrintOption
        this.actionPrintOption = new ActionPrintOption(this);
        getActionManager().registerAction("actionPrintOption", actionPrintOption);
         this.actionPrintOption.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //ActionColPrint
        this.ActionColPrint = new ActionColPrint(this);
        getActionManager().registerAction("ActionColPrint", ActionColPrint);
         this.ActionColPrint.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionColPrintView
        this.actionColPrintView = new ActionColPrintView(this);
        getActionManager().registerAction("actionColPrintView", actionColPrintView);
         this.actionColPrintView.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionAccountBalance
        this.actionAccountBalance = new ActionAccountBalance(this);
        getActionManager().registerAction("actionAccountBalance", actionAccountBalance);
         this.actionAccountBalance.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionAssistant
        this.actionAssistant = new ActionAssistant(this);
        getActionManager().registerAction("actionAssistant", actionAssistant);
         this.actionAssistant.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionHandCheck
        this.actionHandCheck = new ActionHandCheck(this);
        getActionManager().registerAction("actionHandCheck", actionHandCheck);
         this.actionHandCheck.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionImportFile
        this.actionImportFile = new ActionImportFile(this);
        getActionManager().registerAction("actionImportFile", actionImportFile);
         this.actionImportFile.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionCrossPrint
        this.actionCrossPrint = new ActionCrossPrint(this);
        getActionManager().registerAction("actionCrossPrint", actionCrossPrint);
         this.actionCrossPrint.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionAdjunct
        this.actionAdjunct = new ActionAdjunct(this);
        getActionManager().registerAction("actionAdjunct", actionAdjunct);
         this.actionAdjunct.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionViewmbgCtrlBal
        this.actionViewmbgCtrlBal = new ActionViewmbgCtrlBal(this);
        getActionManager().registerAction("actionViewmbgCtrlBal", actionViewmbgCtrlBal);
         this.actionViewmbgCtrlBal.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionVoucherPrintParameter
        this.actionVoucherPrintParameter = new ActionVoucherPrintParameter(this);
        getActionManager().registerAction("actionVoucherPrintParameter", actionVoucherPrintParameter);
         this.actionVoucherPrintParameter.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionCrossPrintView
        this.actionCrossPrintView = new ActionCrossPrintView(this);
        getActionManager().registerAction("actionCrossPrintView", actionCrossPrintView);
         this.actionCrossPrintView.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionImportBalance
        this.actionImportBalance = new ActionImportBalance(this);
        getActionManager().registerAction("actionImportBalance", actionImportBalance);
         this.actionImportBalance.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionSubmitPrint
        this.actionSubmitPrint = new ActionSubmitPrint(this);
        getActionManager().registerAction("actionSubmitPrint", actionSubmitPrint);
         this.actionSubmitPrint.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionEntryCellDown
        this.actionEntryCellDown = new ActionEntryCellDown(this);
        getActionManager().registerAction("actionEntryCellDown", actionEntryCellDown);
         this.actionEntryCellDown.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionSubsidiaryLedger
        this.actionSubsidiaryLedger = new ActionSubsidiaryLedger(this);
        getActionManager().registerAction("actionSubsidiaryLedger", actionSubsidiaryLedger);
         this.actionSubsidiaryLedger.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionSubsidiaryLedgerAssist
        this.actionSubsidiaryLedgerAssist = new ActionSubsidiaryLedgerAssist(this);
        getActionManager().registerAction("actionSubsidiaryLedgerAssist", actionSubsidiaryLedgerAssist);
         this.actionSubsidiaryLedgerAssist.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionAsstCellDown
        this.actionAsstCellDown = new ActionAsstCellDown(this);
        getActionManager().registerAction("actionAsstCellDown", actionAsstCellDown);
         this.actionAsstCellDown.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionUnit
        this.actionUnit = new ActionUnit(this);
        getActionManager().registerAction("actionUnit", actionUnit);
         this.actionUnit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionMgCtrl
        this.actionMgCtrl = new ActionMgCtrl(this);
        getActionManager().registerAction("actionMgCtrl", actionMgCtrl);
         this.actionMgCtrl.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionAdjustVoucher
        this.actionAdjustVoucher = new ActionAdjustVoucher(this);
        getActionManager().registerAction("actionAdjustVoucher", actionAdjustVoucher);
         this.actionAdjustVoucher.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionLocalAudit
        this.actionLocalAudit = new ActionLocalAudit(this);
        getActionManager().registerAction("actionLocalAudit", actionLocalAudit);
         this.actionLocalAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionAutoVerify
        this.actionAutoVerify = new ActionAutoVerify(this);
        getActionManager().registerAction("actionAutoVerify", actionAutoVerify);
         this.actionAutoVerify.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionAuditNext
        this.actionAuditNext = new ActionAuditNext(this);
        getActionManager().registerAction("actionAuditNext", actionAuditNext);
         this.actionAuditNext.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionImpExchangeRate
        this.actionImpExchangeRate = new ActionImpExchangeRate(this);
        getActionManager().registerAction("actionImpExchangeRate", actionImpExchangeRate);
         this.actionImpExchangeRate.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionAuditBack
        this.actionAuditBack = new ActionAuditBack(this);
        getActionManager().registerAction("actionAuditBack", actionAuditBack);
         this.actionAuditBack.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAuditBack.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionAuditBack.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionAuditMessage
        this.actionAuditMessage = new ActionAuditMessage(this);
        getActionManager().registerAction("actionAuditMessage", actionAuditMessage);
         this.actionAuditMessage.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionAutoBalance
        this.actionAutoBalance = new ActionAutoBalance(this);
        getActionManager().registerAction("actionAutoBalance", actionAutoBalance);
         this.actionAutoBalance.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        this.btnAddAssistRecord = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnInsertAssistRecord = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnVerify = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnRemoveAssistRecord = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer5 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer6 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer7 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.lblCtnCurrency = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer9 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer10 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer11 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer12 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer13 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer14 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer15 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.btnShowBal = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.importBalance = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnAutoVerify = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnImpExchangeRate = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer8 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.spnAttachments = new com.kingdee.bos.ctrl.swing.KDSpinner();
        this.dateBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.cbxVoucherType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.dateBookedDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.cbxPeriod = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.cbxCurrency = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtCreator = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtAuditor = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtCashier = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtPoster = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.bizPromptHandler = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtCanceller = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.splitPane = new com.kingdee.bos.ctrl.swing.KDSplitPane();
        this.lblTotal = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.lblLD = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.lblLC = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.ctnEntry = new com.kingdee.bos.ctrl.swing.KDContainer();
        this.ctnRecord = new com.kingdee.bos.ctrl.swing.KDContainer();
        this.tblDetail = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel5 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.tblAssistRecord = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDPanel6 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel7 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel8 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel9 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.txtCompany = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtCompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.btnUnit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.separator4 = new javax.swing.JToolBar.Separator();
        this.btnShowQtyAmnt = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnBookOption = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnEditCashflow = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnAdjunct = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnAccountBalance = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnAssistant = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnAdjustVoucher = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.wfSpt = new javax.swing.JToolBar.Separator();
        this.btnCheckGrp = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnAntiAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnAuditBack = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnHandCheck = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnCheck = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnAntiCheck = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnPost = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnAntiPost = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnBgAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnAntiBgAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnAuditNext = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnViewmbgCtrlBal = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnLocalAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.menuItemAutoBalance = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuImport = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuExport = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuImportFile = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemPrintParameter = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuVchPrintGrp = new com.kingdee.bos.ctrl.swing.KDMenu();
        this.kDSeparator10 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.menuItenColOption = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemCPrint = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemColPrintView = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemCrossPrint = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemCrossPrintView = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemUnit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.miOption = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemBgAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemAntiBgAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.menuItemShowQtyAmnt = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.kDSeparator13 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.menuAuditMessage = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemSubsidiaryLedger = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemSubsidiaryLedgerAssist = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemEditCashflow = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemBookOption = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuViewmbgCtrlBal = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemMgCtrl = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.kDSeparator11 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDMenu1 = new com.kingdee.bos.ctrl.swing.KDMenu();
        this.menuCancle = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuCancelCancel = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.kDSeparator14 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.menuItemCheck = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemHandCheck = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemAntiCheck = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemAntiAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuAuditBack = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemPost = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemAntiPost = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemAdjustVoucher = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemAuditNext = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemLocalAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.kDSeparator9 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.menuItemAddAssistRecord = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemInsertAssistRecord = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemRemoveAssistRecord = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemVerify = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.btnAddAssistRecord.setName("btnAddAssistRecord");
        this.btnInsertAssistRecord.setName("btnInsertAssistRecord");
        this.btnVerify.setName("btnVerify");
        this.btnRemoveAssistRecord.setName("btnRemoveAssistRecord");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.kDLabelContainer5.setName("kDLabelContainer5");
        this.kDLabelContainer6.setName("kDLabelContainer6");
        this.kDLabelContainer7.setName("kDLabelContainer7");
        this.lblCtnCurrency.setName("lblCtnCurrency");
        this.kDLabelContainer9.setName("kDLabelContainer9");
        this.kDLabelContainer10.setName("kDLabelContainer10");
        this.kDLabelContainer11.setName("kDLabelContainer11");
        this.kDLabelContainer12.setName("kDLabelContainer12");
        this.kDLabelContainer13.setName("kDLabelContainer13");
        this.kDLabelContainer14.setName("kDLabelContainer14");
        this.kDLabelContainer15.setName("kDLabelContainer15");
        this.kDPanel1.setName("kDPanel1");
        this.btnShowBal.setName("btnShowBal");
        this.importBalance.setName("importBalance");
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.btnAutoVerify.setName("btnAutoVerify");
        this.btnImpExchangeRate.setName("btnImpExchangeRate");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer8.setName("kDLabelContainer8");
        this.spnAttachments.setName("spnAttachments");
        this.dateBizDate.setName("dateBizDate");
        this.cbxVoucherType.setName("cbxVoucherType");
        this.dateBookedDate.setName("dateBookedDate");
        this.cbxPeriod.setName("cbxPeriod");
        this.cbxCurrency.setName("cbxCurrency");
        this.txtNumber.setName("txtNumber");
        this.txtCreator.setName("txtCreator");
        this.txtAuditor.setName("txtAuditor");
        this.txtCashier.setName("txtCashier");
        this.txtPoster.setName("txtPoster");
        this.bizPromptHandler.setName("bizPromptHandler");
        this.txtCanceller.setName("txtCanceller");
        this.splitPane.setName("splitPane");
        this.lblTotal.setName("lblTotal");
        this.lblLD.setName("lblLD");
        this.lblLC.setName("lblLC");
        this.ctnEntry.setName("ctnEntry");
        this.ctnRecord.setName("ctnRecord");
        this.tblDetail.setName("tblDetail");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel3.setName("kDPanel3");
        this.kDPanel4.setName("kDPanel4");
        this.kDPanel5.setName("kDPanel5");
        this.tblAssistRecord.setName("tblAssistRecord");
        this.kDPanel6.setName("kDPanel6");
        this.kDPanel7.setName("kDPanel7");
        this.kDPanel8.setName("kDPanel8");
        this.kDPanel9.setName("kDPanel9");
        this.txtCompany.setName("txtCompany");
        this.txtDescription.setName("txtDescription");
        this.prmtCompany.setName("prmtCompany");
        this.btnUnit.setName("btnUnit");
        this.separator4.setName("separator4");
        this.btnShowQtyAmnt.setName("btnShowQtyAmnt");
        this.btnBookOption.setName("btnBookOption");
        this.btnEditCashflow.setName("btnEditCashflow");
        this.btnAdjunct.setName("btnAdjunct");
        this.btnAccountBalance.setName("btnAccountBalance");
        this.btnAssistant.setName("btnAssistant");
        this.btnAdjustVoucher.setName("btnAdjustVoucher");
        this.wfSpt.setName("wfSpt");
        this.btnCheckGrp.setName("btnCheckGrp");
        this.btnAudit.setName("btnAudit");
        this.btnAntiAudit.setName("btnAntiAudit");
        this.btnAuditBack.setName("btnAuditBack");
        this.btnHandCheck.setName("btnHandCheck");
        this.btnCheck.setName("btnCheck");
        this.btnAntiCheck.setName("btnAntiCheck");
        this.btnPost.setName("btnPost");
        this.btnAntiPost.setName("btnAntiPost");
        this.btnBgAudit.setName("btnBgAudit");
        this.btnAntiBgAudit.setName("btnAntiBgAudit");
        this.btnAuditNext.setName("btnAuditNext");
        this.btnViewmbgCtrlBal.setName("btnViewmbgCtrlBal");
        this.btnLocalAudit.setName("btnLocalAudit");
        this.menuItemAutoBalance.setName("menuItemAutoBalance");
        this.menuImport.setName("menuImport");
        this.menuExport.setName("menuExport");
        this.menuImportFile.setName("menuImportFile");
        this.menuItemPrintParameter.setName("menuItemPrintParameter");
        this.menuVchPrintGrp.setName("menuVchPrintGrp");
        this.kDSeparator10.setName("kDSeparator10");
        this.menuItenColOption.setName("menuItenColOption");
        this.menuItemCPrint.setName("menuItemCPrint");
        this.menuItemColPrintView.setName("menuItemColPrintView");
        this.menuItemCrossPrint.setName("menuItemCrossPrint");
        this.menuItemCrossPrintView.setName("menuItemCrossPrintView");
        this.menuItemUnit.setName("menuItemUnit");
        this.miOption.setName("miOption");
        this.menuItemBgAudit.setName("menuItemBgAudit");
        this.menuItemAntiBgAudit.setName("menuItemAntiBgAudit");
        this.kDSeparator8.setName("kDSeparator8");
        this.menuItemShowQtyAmnt.setName("menuItemShowQtyAmnt");
        this.kDSeparator13.setName("kDSeparator13");
        this.menuAuditMessage.setName("menuAuditMessage");
        this.menuItemSubsidiaryLedger.setName("menuItemSubsidiaryLedger");
        this.menuItemSubsidiaryLedgerAssist.setName("menuItemSubsidiaryLedgerAssist");
        this.menuItemEditCashflow.setName("menuItemEditCashflow");
        this.menuItemBookOption.setName("menuItemBookOption");
        this.menuViewmbgCtrlBal.setName("menuViewmbgCtrlBal");
        this.menuItemMgCtrl.setName("menuItemMgCtrl");
        this.kDSeparator11.setName("kDSeparator11");
        this.kDMenu1.setName("kDMenu1");
        this.menuCancle.setName("menuCancle");
        this.menuCancelCancel.setName("menuCancelCancel");
        this.kDSeparator14.setName("kDSeparator14");
        this.menuItemCheck.setName("menuItemCheck");
        this.menuItemHandCheck.setName("menuItemHandCheck");
        this.menuItemAntiCheck.setName("menuItemAntiCheck");
        this.menuItemAudit.setName("menuItemAudit");
        this.menuItemAntiAudit.setName("menuItemAntiAudit");
        this.menuAuditBack.setName("menuAuditBack");
        this.menuItemPost.setName("menuItemPost");
        this.menuItemAntiPost.setName("menuItemAntiPost");
        this.menuItemAdjustVoucher.setName("menuItemAdjustVoucher");
        this.menuItemAuditNext.setName("menuItemAuditNext");
        this.menuItemLocalAudit.setName("menuItemLocalAudit");
        this.kDSeparator9.setName("kDSeparator9");
        this.menuItemAddAssistRecord.setName("menuItemAddAssistRecord");
        this.menuItemInsertAssistRecord.setName("menuItemInsertAssistRecord");
        this.menuItemRemoveAssistRecord.setName("menuItemRemoveAssistRecord");
        this.menuItemVerify.setName("menuItemVerify");
        // CoreUI		
        this.menuFile.setText(resHelper.getString("menuFile.text"));		
        this.menuFile.setToolTipText(resHelper.getString("menuFile.toolTipText"));		
        this.menuItemPageSetup.setText(resHelper.getString("menuItemPageSetup.text"));		
        this.menuItemPageSetup.setToolTipText(resHelper.getString("menuItemPageSetup.toolTipText"));		
        this.menuItemPageSetup.setMnemonic(76);		
        this.kDSeparator1.setOrientation(1);
        this.menuItemCalculator.setAction((IItemAction)ActionProxyFactory.getProxy(actionCalculator, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemCalculator.setText(resHelper.getString("menuItemCalculator.text"));		
        this.menuItemCalculator.setVisible(true);		
        this.menuItemCalculator.setToolTipText(resHelper.getString("menuItemCalculator.toolTipText"));		
        this.menuItemToolBarCustom.setEnabled(false);		
        this.menuItemToolBarCustom.setVisible(false);		
        this.btnAddNew.setText(resHelper.getString("btnAddNew.text"));		
        this.btnAddNew.setToolTipText(resHelper.getString("btnAddNew.toolTipText"));		
        this.btnSave.setText(resHelper.getString("btnSave.text"));		
        this.btnSave.setToolTipText(resHelper.getString("btnSave.toolTipText"));		
        this.btnSubmit.setText(resHelper.getString("btnSubmit.text"));		
        this.btnSubmit.setToolTipText(resHelper.getString("btnSubmit.toolTipText"));		
        this.btnCopy.setText(resHelper.getString("btnCopy.text"));		
        this.btnCopy.setToolTipText(resHelper.getString("btnCopy.toolTipText"));		
        this.btnCancelCancel.setText(resHelper.getString("btnCancelCancel.text"));		
        this.btnCancelCancel.setToolTipText(resHelper.getString("btnCancelCancel.toolTipText"));		
        this.btnCancelCancel.setVisible(false);		
        this.btnCancelCancel.setMnemonic(73);		
        this.btnCancel.setText(resHelper.getString("btnCancel.text"));		
        this.btnCancel.setToolTipText(resHelper.getString("btnCancel.toolTipText"));		
        this.btnCancel.setVisible(false);		
        this.menuItemAddNew.setText(resHelper.getString("menuItemAddNew.text"));		
        this.menuItemAddNew.setToolTipText(resHelper.getString("menuItemAddNew.toolTipText"));		
        this.menuItemSave.setText(resHelper.getString("menuItemSave.text"));		
        this.menuItemSave.setToolTipText(resHelper.getString("menuItemSave.toolTipText"));		
        this.menuItemSubmit.setText(resHelper.getString("menuItemSubmit.text"));		
        this.menuItemSubmit.setToolTipText(resHelper.getString("menuItemSubmit.toolTipText"));		
        this.menuItemPrint.setToolTipText(resHelper.getString("menuItemPrint.toolTipText"));		
        this.menuItemPrintPreview.setToolTipText(resHelper.getString("menuItemPrintPreview.toolTipText"));		
        this.kDSeparator3.setOrientation(1);		
        this.menuItemCopy.setText(resHelper.getString("menuItemCopy.text"));		
        this.menuItemCopy.setToolTipText(resHelper.getString("menuItemCopy.toolTipText"));		
        this.menuItemFirst.setToolTipText(resHelper.getString("menuItemFirst.toolTipText"));		
        this.menuItemPre.setToolTipText(resHelper.getString("menuItemPre.toolTipText"));		
        this.menuItemNext.setToolTipText(resHelper.getString("menuItemNext.toolTipText"));		
        this.menuItemLast.setToolTipText(resHelper.getString("menuItemLast.toolTipText"));		
        this.menuItemEdit.setText(resHelper.getString("menuItemEdit.text"));		
        this.menuItemRemove.setText(resHelper.getString("menuItemRemove.text"));
        this.chkMenuItemSubmitAndAddNew.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent e) {
                try {
                    chkMenuItemSubmitAndAddNew_stateChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        this.menuItemCancelCancel.setAction((IItemAction)ActionProxyFactory.getProxy(actionBgAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemCancelCancel.setText(resHelper.getString("menuItemCancelCancel.text"));		
        this.menuItemCancelCancel.setMnemonic(69);		
        this.menuItemCancelCancel.setToolTipText(resHelper.getString("menuItemCancelCancel.toolTipText"));
        this.menuItemCancel.setAction((IItemAction)ActionProxyFactory.getProxy(actionBgAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemCancel.setText(resHelper.getString("menuItemCancel.text"));		
        this.menuItemCancel.setMnemonic(73);		
        this.menuItemCancel.setToolTipText(resHelper.getString("menuItemCancel.toolTipText"));
        this.btnTraceUp.setAction((IItemAction)ActionProxyFactory.getProxy(actionTraceUp, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnTraceUp.setText(resHelper.getString("btnTraceUp.text"));		
        this.btnTraceUp.setToolTipText(resHelper.getString("btnTraceUp.toolTipText"));
        this.btnAddLine.setAction((IItemAction)ActionProxyFactory.getProxy(actionAddLine, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAddLine.setText(resHelper.getString("btnAddLine.text"));		
        this.btnAddLine.setToolTipText(resHelper.getString("btnAddLine.toolTipText"));		
        this.btnAddLine.setFocusable(false);
        this.btnInsertLine.setAction((IItemAction)ActionProxyFactory.getProxy(actionInsertLine, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnInsertLine.setText(resHelper.getString("btnInsertLine.text"));		
        this.btnInsertLine.setToolTipText(resHelper.getString("btnInsertLine.toolTipText"));		
        this.btnInsertLine.setFocusable(false);
        this.btnRemoveLine.setAction((IItemAction)ActionProxyFactory.getProxy(actionRemoveLine, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnRemoveLine.setText(resHelper.getString("btnRemoveLine.text"));		
        this.btnRemoveLine.setToolTipText(resHelper.getString("btnRemoveLine.toolTipText"));		
        this.btnRemoveLine.setFocusable(false);
        this.btnWFViewdoProccess.setAction((IItemAction)ActionProxyFactory.getProxy(actionViewDoProccess, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnWFViewdoProccess.setText(resHelper.getString("btnWFViewdoProccess.text"));
        this.btnWFViewSubmitProccess.setAction((IItemAction)ActionProxyFactory.getProxy(actionViewSubmitProccess, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnWFViewSubmitProccess.setText(resHelper.getString("btnWFViewSubmitProccess.text"));		
        this.separator2.setEnabled(false);		
        this.menuItemTraceUp.setText(resHelper.getString("menuItemTraceUp.text"));		
        this.menuItemTraceDown.setVisible(false);		
        this.menuItemTraceDown.setEnabled(false);		
        this.menuItemRemoveLine.setText(resHelper.getString("menuItemRemoveLine.text"));
        // btnAddAssistRecord
        this.btnAddAssistRecord.setAction((IItemAction)ActionProxyFactory.getProxy(actionAddAssistRecord, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAddAssistRecord.setText(resHelper.getString("btnAddAssistRecord.text"));		
        this.btnAddAssistRecord.setToolTipText(resHelper.getString("btnAddAssistRecord.toolTipText"));		
        this.btnAddAssistRecord.setFocusable(false);
        // btnInsertAssistRecord
        this.btnInsertAssistRecord.setAction((IItemAction)ActionProxyFactory.getProxy(actionInsertAssistRecord, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnInsertAssistRecord.setText(resHelper.getString("btnInsertAssistRecord.text"));		
        this.btnInsertAssistRecord.setToolTipText(resHelper.getString("btnInsertAssistRecord.toolTipText"));		
        this.btnInsertAssistRecord.setFocusable(false);
        // btnVerify
        this.btnVerify.setAction((IItemAction)ActionProxyFactory.getProxy(actionVerify, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnVerify.setText(resHelper.getString("btnVerify.text"));		
        this.btnVerify.setToolTipText(resHelper.getString("btnVerify.toolTipText"));		
        this.btnVerify.setFocusable(false);
        // btnRemoveAssistRecord
        this.btnRemoveAssistRecord.setAction((IItemAction)ActionProxyFactory.getProxy(actionRemoveAssistRecord, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnRemoveAssistRecord.setText(resHelper.getString("btnRemoveAssistRecord.text"));		
        this.btnRemoveAssistRecord.setToolTipText(resHelper.getString("btnRemoveAssistRecord.toolTipText"));		
        this.btnRemoveAssistRecord.setFocusable(false);
        // kDLabelContainer3		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelLength(40);		
        this.kDLabelContainer3.setBoundLabelUnderline(true);
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(60);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);
        // kDLabelContainer5		
        this.kDLabelContainer5.setBoundLabelText(resHelper.getString("kDLabelContainer5.boundLabelText"));		
        this.kDLabelContainer5.setBoundLabelLength(60);		
        this.kDLabelContainer5.setBoundLabelUnderline(true);
        // kDLabelContainer6		
        this.kDLabelContainer6.setBoundLabelText(resHelper.getString("kDLabelContainer6.boundLabelText"));		
        this.kDLabelContainer6.setBoundLabelLength(60);		
        this.kDLabelContainer6.setBoundLabelUnderline(true);
        // kDLabelContainer7		
        this.kDLabelContainer7.setBoundLabelText(resHelper.getString("kDLabelContainer7.boundLabelText"));		
        this.kDLabelContainer7.setBoundLabelLength(60);		
        this.kDLabelContainer7.setBoundLabelUnderline(true);
        // lblCtnCurrency		
        this.lblCtnCurrency.setBoundLabelText(resHelper.getString("lblCtnCurrency.boundLabelText"));		
        this.lblCtnCurrency.setBoundLabelLength(30);		
        this.lblCtnCurrency.setVisible(false);		
        this.lblCtnCurrency.setBoundLabelUnderline(true);
        // kDLabelContainer9		
        this.kDLabelContainer9.setBoundLabelText(resHelper.getString("kDLabelContainer9.boundLabelText"));		
        this.kDLabelContainer9.setBoundLabelLength(60);		
        this.kDLabelContainer9.setBoundLabelUnderline(true);
        // kDLabelContainer10		
        this.kDLabelContainer10.setBoundLabelText(resHelper.getString("kDLabelContainer10.boundLabelText"));		
        this.kDLabelContainer10.setBoundLabelLength(50);		
        this.kDLabelContainer10.setBoundLabelUnderline(true);
        // kDLabelContainer11		
        this.kDLabelContainer11.setBoundLabelText(resHelper.getString("kDLabelContainer11.boundLabelText"));		
        this.kDLabelContainer11.setBoundLabelLength(50);		
        this.kDLabelContainer11.setBoundLabelUnderline(true);
        // kDLabelContainer12		
        this.kDLabelContainer12.setBoundLabelText(resHelper.getString("kDLabelContainer12.boundLabelText"));		
        this.kDLabelContainer12.setBoundLabelLength(50);		
        this.kDLabelContainer12.setBoundLabelUnderline(true);
        // kDLabelContainer13		
        this.kDLabelContainer13.setBoundLabelText(resHelper.getString("kDLabelContainer13.boundLabelText"));		
        this.kDLabelContainer13.setBoundLabelLength(50);		
        this.kDLabelContainer13.setBoundLabelUnderline(true);
        // kDLabelContainer14		
        this.kDLabelContainer14.setBoundLabelText(resHelper.getString("kDLabelContainer14.boundLabelText"));		
        this.kDLabelContainer14.setBoundLabelLength(40);		
        this.kDLabelContainer14.setVisible(false);		
        this.kDLabelContainer14.setBoundLabelUnderline(true);
        // kDLabelContainer15		
        this.kDLabelContainer15.setBoundLabelText(resHelper.getString("kDLabelContainer15.boundLabelText"));		
        this.kDLabelContainer15.setBoundLabelLength(50);		
        this.kDLabelContainer15.setBoundLabelUnderline(true);
        // kDPanel1		
        this.kDPanel1.setBorder(BorderFactory.createLineBorder(new Color(145,148,140),1));
        // btnShowBal		
        this.btnShowBal.setText(resHelper.getString("btnShowBal.text"));		
        this.btnShowBal.setVisible(false);		
        this.btnShowBal.setEnabled(false);
        // importBalance
        this.importBalance.setAction((IItemAction)ActionProxyFactory.getProxy(actionImportBalance, new Class[] { IItemAction.class }, getServiceContext()));		
        this.importBalance.setText(resHelper.getString("importBalance.text"));
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(60);		
        this.kDLabelContainer1.setVisible(false);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);
        // btnAutoVerify
        this.btnAutoVerify.setAction((IItemAction)ActionProxyFactory.getProxy(actionAutoVerify, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAutoVerify.setText(resHelper.getString("btnAutoVerify.text"));
        // btnImpExchangeRate
        this.btnImpExchangeRate.setAction((IItemAction)ActionProxyFactory.getProxy(actionImpExchangeRate, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnImpExchangeRate.setText(resHelper.getString("btnImpExchangeRate.text"));		
        this.btnImpExchangeRate.setToolTipText(resHelper.getString("btnImpExchangeRate.toolTipText"));		
        this.btnImpExchangeRate.setEnabled(false);		
        this.btnImpExchangeRate.setVisible(false);		
        this.btnImpExchangeRate.setSelectedIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_handworkcollate"));
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelLength(60);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);
        // kDLabelContainer8		
        this.kDLabelContainer8.setBoundLabelText(resHelper.getString("kDLabelContainer8.boundLabelText"));		
        this.kDLabelContainer8.setBoundLabelLength(60);
        // spnAttachments
        // dateBizDate
        // cbxVoucherType
        // dateBookedDate
        // cbxPeriod		
        this.cbxPeriod.setEnabled(false);
        // cbxCurrency
        // txtNumber
        // txtCreator		
        this.txtCreator.setText(resHelper.getString("txtCreator.text"));		
        this.txtCreator.setEnabled(false);
        // txtAuditor		
        this.txtAuditor.setText(resHelper.getString("txtAuditor.text"));		
        this.txtAuditor.setEnabled(false);
        // txtCashier		
        this.txtCashier.setText(resHelper.getString("txtCashier.text"));		
        this.txtCashier.setEnabled(false);
        // txtPoster		
        this.txtPoster.setText(resHelper.getString("txtPoster.text"));		
        this.txtPoster.setEnabled(false);
        // bizPromptHandler		
        this.bizPromptHandler.setEditFormat("$number$");		
        this.bizPromptHandler.setDisplayFormat("$name$");		
        this.bizPromptHandler.setCommitFormat("$number$");		
        this.bizPromptHandler.setQueryInfo("com.kingdee.eas.fi.gl.app.VoucherUserQuery");		
        this.bizPromptHandler.setEditable(true);
        // txtCanceller		
        this.txtCanceller.setText(resHelper.getString("txtCanceller.text"));		
        this.txtCanceller.setEnabled(false);
        // splitPane		
        this.splitPane.setResizeWeight(0.6);		
        this.splitPane.setOpaque(false);		
        this.splitPane.setOrientation(0);
        // lblTotal		
        this.lblTotal.setText(resHelper.getString("lblTotal.text"));
        // lblLD		
        this.lblLD.setText(resHelper.getString("lblLD.text"));
        // lblLC		
        this.lblLC.setText(resHelper.getString("lblLC.text"));
        // ctnEntry		
        this.ctnEntry.setEnableActive(resHelper.getBoolean("ctnEntry.enableActive"));		
        this.ctnEntry.setTitle(resHelper.getString("ctnEntry.title"));		
        this.ctnEntry.setPreferredSize(new Dimension(0,300));		
        this.ctnEntry.setMinimumSize(new Dimension(0,0));		
        this.ctnEntry.setTitleStyle(2);
        // ctnRecord		
        this.ctnRecord.setEnableActive(resHelper.getBoolean("ctnRecord.enableActive"));		
        this.ctnRecord.setTitle(resHelper.getString("ctnRecord.title"));		
        this.ctnRecord.setTitleStyle(2);
        // tblDetail
		String tblDetailStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol3\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol8\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol11\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"e.description\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"0\" /><t:Column t:key=\"e.profitCenter\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"1\" /><t:Column t:key=\"e.account\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"2\" /><t:Column t:key=\"e.currency\" t:width=\"80\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"3\" t:styleID=\"sCol3\" /><t:Column t:key=\"e.measureUnit\" t:width=\"80\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"4\" t:styleID=\"sCol4\" /><t:Column t:key=\"e.price\" t:width=\"60\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"5\" t:styleID=\"sCol5\" /><t:Column t:key=\"e.quantity\" t:width=\"60\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"6\" t:styleID=\"sCol6\" /><t:Column t:key=\"e.amount\" t:width=\"60\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"7\" t:styleID=\"sCol7\" /><t:Column t:key=\"e.localExchangeRate\" t:width=\"60\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"8\" t:styleID=\"sCol8\" /><t:Column t:key=\"e.localAmountDebit\" t:width=\"120\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"9\" /><t:Column t:key=\"e.localAmountCredit\" t:width=\"120\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"10\" /><t:Column t:key=\"e.reportingExchangeRate\" t:width=\"60\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"11\" t:styleID=\"sCol11\" /><t:Column t:key=\"e.reportingAmountDebit\" t:width=\"120\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"12\" /><t:Column t:key=\"e.reportingAmountCredit\" t:width=\"120\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"13\" /><t:Column t:key=\"e.customer\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"14\" /></t:ColumnGroup><t:Head><t:Row t:name=\"head1\" t:height=\"27\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{e.description}</t:Cell><t:Cell>$Resource{e.profitCenter}</t:Cell><t:Cell>$Resource{e.account}</t:Cell><t:Cell>$Resource{e.currency}</t:Cell><t:Cell>$Resource{e.measureUnit}</t:Cell><t:Cell>$Resource{e.price}</t:Cell><t:Cell>$Resource{e.quantity}</t:Cell><t:Cell>$Resource{e.amount}</t:Cell><t:Cell>$Resource{e.localExchangeRate}</t:Cell><t:Cell>$Resource{e.localAmountDebit}</t:Cell><t:Cell>$Resource{e.localAmountCredit}</t:Cell><t:Cell>$Resource{e.reportingExchangeRate}</t:Cell><t:Cell>$Resource{e.reportingAmountDebit}</t:Cell><t:Cell>$Resource{e.reportingAmountCredit}</t:Cell><t:Cell>$Resource{e.customer}</t:Cell></t:Row><t:Row t:name=\"header2\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{e.description_Row2}</t:Cell><t:Cell>$Resource{e.profitCenter_Row2}</t:Cell><t:Cell>$Resource{e.account_Row2}</t:Cell><t:Cell>$Resource{e.currency_Row2}</t:Cell><t:Cell>$Resource{e.measureUnit_Row2}</t:Cell><t:Cell>$Resource{e.price_Row2}</t:Cell><t:Cell>$Resource{e.quantity_Row2}</t:Cell><t:Cell>$Resource{e.amount_Row2}</t:Cell><t:Cell>$Resource{e.localExchangeRate_Row2}</t:Cell><t:Cell>$Resource{e.localAmountDebit_Row2}</t:Cell><t:Cell>$Resource{e.localAmountCredit_Row2}</t:Cell><t:Cell>$Resource{e.reportingExchangeRate_Row2}</t:Cell><t:Cell>$Resource{e.reportingAmountDebit_Row2}</t:Cell><t:Cell>$Resource{e.reportingAmountCredit_Row2}</t:Cell><t:Cell>$Resource{e.customer_Row2}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head><t:Block t:top=\"0\" t:left=\"0\" t:bottom=\"1\" t:right=\"0\" /><t:Block t:top=\"0\" t:left=\"1\" t:bottom=\"1\" t:right=\"1\" /><t:Block t:top=\"0\" t:left=\"2\" t:bottom=\"1\" t:right=\"2\" /><t:Block t:top=\"0\" t:left=\"3\" t:bottom=\"1\" t:right=\"3\" /><t:Block t:top=\"0\" t:left=\"4\" t:bottom=\"1\" t:right=\"4\" /><t:Block t:top=\"0\" t:left=\"5\" t:bottom=\"1\" t:right=\"5\" /><t:Block t:top=\"0\" t:left=\"8\" t:bottom=\"1\" t:right=\"8\" /><t:Block t:top=\"0\" t:left=\"11\" t:bottom=\"1\" t:right=\"11\" /><t:Block t:top=\"0\" t:left=\"14\" t:bottom=\"1\" t:right=\"14\" /><t:Block t:top=\"0\" t:left=\"6\" t:bottom=\"1\" t:right=\"6\" /></t:Head></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.tblDetail.setFormatXml(resHelper.translateString("tblDetail",tblDetailStrXML));		
        this.tblDetail.setPreferredSize(new Dimension(-1,-1));

        

        // kDPanel2		
        this.kDPanel2.setPreferredSize(new Dimension(-1,4));		
        this.kDPanel2.setMinimumSize(new Dimension(-1,4));		
        this.kDPanel2.setOpaque(false);
        // kDPanel3		
        this.kDPanel3.setPreferredSize(new Dimension(8,-1));		
        this.kDPanel3.setMinimumSize(new Dimension(8,-1));		
        this.kDPanel3.setOpaque(false);
        // kDPanel4		
        this.kDPanel4.setPreferredSize(new Dimension(8,-1));		
        this.kDPanel4.setMinimumSize(new Dimension(8,-1));		
        this.kDPanel4.setOpaque(false);
        // kDPanel5		
        this.kDPanel5.setPreferredSize(new Dimension(-1,4));		
        this.kDPanel5.setMinimumSize(new Dimension(-1,4));		
        this.kDPanel5.setOpaque(false);
        // tblAssistRecord
		String tblAssistRecordStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol2\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"bizDate\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" /><t:Column t:key=\"description\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" /><t:Column t:key=\"endDate\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:styleID=\"sCol2\" /><t:Column t:key=\"measureUnit\" t:width=\"80\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" /><t:Column t:key=\"price\" t:width=\"60\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" /><t:Column t:key=\"quantity\" t:width=\"60\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:styleID=\"sCol5\" /><t:Column t:key=\"amount\" t:width=\"60\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:styleID=\"sCol6\" /><t:Column t:key=\"localAmount\" t:width=\"120\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" /><t:Column t:key=\"reportingAmount\" t:width=\"120\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"21\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{bizDate}</t:Cell><t:Cell>$Resource{description}</t:Cell><t:Cell>$Resource{endDate}</t:Cell><t:Cell>$Resource{measureUnit}</t:Cell><t:Cell>$Resource{price}</t:Cell><t:Cell>$Resource{quantity}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{localAmount}</t:Cell><t:Cell>$Resource{reportingAmount}</t:Cell></t:Row><t:Row t:name=\"header2\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{bizDate_Row2}</t:Cell><t:Cell>$Resource{description_Row2}</t:Cell><t:Cell>$Resource{endDate_Row2}</t:Cell><t:Cell>$Resource{measureUnit_Row2}</t:Cell><t:Cell>$Resource{price_Row2}</t:Cell><t:Cell>$Resource{quantity_Row2}</t:Cell><t:Cell>$Resource{amount_Row2}</t:Cell><t:Cell>$Resource{localAmount_Row2}</t:Cell><t:Cell>$Resource{reportingAmount_Row2}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head><t:Block t:top=\"0\" t:left=\"0\" t:bottom=\"1\" t:right=\"0\" /><t:Block t:top=\"0\" t:left=\"1\" t:bottom=\"1\" t:right=\"1\" /><t:Block t:top=\"0\" t:left=\"2\" t:bottom=\"1\" t:right=\"2\" /><t:Block t:top=\"0\" t:left=\"3\" t:bottom=\"1\" t:right=\"3\" /><t:Block t:top=\"0\" t:left=\"4\" t:bottom=\"1\" t:right=\"4\" /><t:Block t:top=\"0\" t:left=\"5\" t:bottom=\"1\" t:right=\"5\" /></t:Head></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot> ";
		
        this.tblAssistRecord.setFormatXml(resHelper.translateString("tblAssistRecord",tblAssistRecordStrXML));

        

        // kDPanel6		
        this.kDPanel6.setPreferredSize(new Dimension(-1,4));		
        this.kDPanel6.setOpaque(false);		
        this.kDPanel6.setMinimumSize(new Dimension(-1,4));
        // kDPanel7		
        this.kDPanel7.setPreferredSize(new Dimension(8,-1));		
        this.kDPanel7.setOpaque(false);		
        this.kDPanel7.setMinimumSize(new Dimension(8,-1));
        // kDPanel8		
        this.kDPanel8.setPreferredSize(new Dimension(8,-1));		
        this.kDPanel8.setMinimumSize(new Dimension(8,-1));		
        this.kDPanel8.setOpaque(false);		
        this.kDPanel8.setBorder(null);
        // kDPanel9		
        this.kDPanel9.setPreferredSize(new Dimension(-1,4));		
        this.kDPanel9.setMinimumSize(new Dimension(-1,4));		
        this.kDPanel9.setOpaque(false);
        // txtCompany		
        this.txtCompany.setText(resHelper.getString("txtCompany.text"));		
        this.txtCompany.setEnabled(false);
        // txtDescription
        // prmtCompany		
        this.prmtCompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");
        // btnUnit
        this.btnUnit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnit.setText(resHelper.getString("btnUnit.text"));		
        this.btnUnit.setToolTipText(resHelper.getString("btnUnit.toolTipText"));
        // separator4		
        this.separator4.setOrientation(1);
        // btnShowQtyAmnt
        this.btnShowQtyAmnt.setAction((IItemAction)ActionProxyFactory.getProxy(actionShowQtyAmnt, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnShowQtyAmnt.setText(resHelper.getString("btnShowQtyAmnt.text"));		
        this.btnShowQtyAmnt.setToolTipText(resHelper.getString("btnShowQtyAmnt.toolTipText"));
        // btnBookOption
        this.btnBookOption.setAction((IItemAction)ActionProxyFactory.getProxy(actionBookOption, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnBookOption.setText(resHelper.getString("btnBookOption.text"));		
        this.btnBookOption.setToolTipText(resHelper.getString("btnBookOption.toolTipText"));
        // btnEditCashflow
        this.btnEditCashflow.setAction((IItemAction)ActionProxyFactory.getProxy(actionEditCashflow, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnEditCashflow.setText(resHelper.getString("btnEditCashflow.text"));		
        this.btnEditCashflow.setToolTipText(resHelper.getString("btnEditCashflow.toolTipText"));
        // btnAdjunct
        this.btnAdjunct.setAction((IItemAction)ActionProxyFactory.getProxy(actionAdjunct, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAdjunct.setText(resHelper.getString("btnAdjunct.text"));		
        this.btnAdjunct.setToolTipText(resHelper.getString("btnAdjunct.toolTipText"));
        // btnAccountBalance
        this.btnAccountBalance.setAction((IItemAction)ActionProxyFactory.getProxy(actionAccountBalance, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAccountBalance.setText(resHelper.getString("btnAccountBalance.text"));		
        this.btnAccountBalance.setVisible(false);		
        this.btnAccountBalance.setToolTipText(resHelper.getString("btnAccountBalance.toolTipText"));
        // btnAssistant
        this.btnAssistant.setAction((IItemAction)ActionProxyFactory.getProxy(actionAssistant, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAssistant.setText(resHelper.getString("btnAssistant.text"));		
        this.btnAssistant.setVisible(false);		
        this.btnAssistant.setToolTipText(resHelper.getString("btnAssistant.toolTipText"));
        // btnAdjustVoucher
        this.btnAdjustVoucher.setAction((IItemAction)ActionProxyFactory.getProxy(actionAdjustVoucher, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAdjustVoucher.setText(resHelper.getString("btnAdjustVoucher.text"));		
        this.btnAdjustVoucher.setToolTipText(resHelper.getString("btnAdjustVoucher.toolTipText"));
        // wfSpt		
        this.wfSpt.setOrientation(1);		
        this.wfSpt.setVisible(false);		
        this.wfSpt.setEnabled(false);
        // btnCheckGrp		
        this.btnCheckGrp.setText(resHelper.getString("btnCheckGrp.text"));		
        this.btnCheckGrp.setToolTipText(resHelper.getString("btnCheckGrp.toolTipText"));
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));		
        this.btnAudit.setVisible(false);		
        this.btnAudit.setToolTipText(resHelper.getString("btnAudit.toolTipText"));		
        this.btnAudit.setMnemonic(68);
        // btnAntiAudit
        this.btnAntiAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAntiAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAntiAudit.setText(resHelper.getString("btnAntiAudit.text"));		
        this.btnAntiAudit.setVisible(false);		
        this.btnAntiAudit.setToolTipText(resHelper.getString("btnAntiAudit.toolTipText"));
        // btnAuditBack
        this.btnAuditBack.setAction((IItemAction)ActionProxyFactory.getProxy(actionAuditBack, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAuditBack.setText(resHelper.getString("btnAuditBack.text"));		
        this.btnAuditBack.setVisible(false);
        // btnHandCheck
        this.btnHandCheck.setAction((IItemAction)ActionProxyFactory.getProxy(actionHandCheck, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnHandCheck.setText(resHelper.getString("btnHandCheck.text"));		
        this.btnHandCheck.setVisible(false);
        // btnCheck
        this.btnCheck.setAction((IItemAction)ActionProxyFactory.getProxy(actionCheck, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnCheck.setText(resHelper.getString("btnCheck.text"));		
        this.btnCheck.setVisible(false);		
        this.btnCheck.setToolTipText(resHelper.getString("btnCheck.toolTipText"));
        // btnAntiCheck
        this.btnAntiCheck.setAction((IItemAction)ActionProxyFactory.getProxy(actionAntiCheck, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAntiCheck.setText(resHelper.getString("btnAntiCheck.text"));		
        this.btnAntiCheck.setVisible(false);		
        this.btnAntiCheck.setToolTipText(resHelper.getString("btnAntiCheck.toolTipText"));
        // btnPost
        this.btnPost.setAction((IItemAction)ActionProxyFactory.getProxy(actionPost, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnPost.setText(resHelper.getString("btnPost.text"));		
        this.btnPost.setVisible(false);		
        this.btnPost.setToolTipText(resHelper.getString("btnPost.toolTipText"));
        // btnAntiPost
        this.btnAntiPost.setAction((IItemAction)ActionProxyFactory.getProxy(actionAntiPost, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAntiPost.setText(resHelper.getString("btnAntiPost.text"));		
        this.btnAntiPost.setVisible(false);		
        this.btnAntiPost.setToolTipText(resHelper.getString("btnAntiPost.toolTipText"));
        // btnBgAudit
        this.btnBgAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionBgAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnBgAudit.setText(resHelper.getString("btnBgAudit.text"));		
        this.btnBgAudit.setToolTipText(resHelper.getString("btnBgAudit.toolTipText"));		
        this.btnBgAudit.setVisible(false);
        // btnAntiBgAudit
        this.btnAntiBgAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAntiBgAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAntiBgAudit.setText(resHelper.getString("btnAntiBgAudit.text"));		
        this.btnAntiBgAudit.setToolTipText(resHelper.getString("btnAntiBgAudit.toolTipText"));		
        this.btnAntiBgAudit.setVisible(false);
        // btnAuditNext
        this.btnAuditNext.setAction((IItemAction)ActionProxyFactory.getProxy(actionAuditNext, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAuditNext.setText(resHelper.getString("btnAuditNext.text"));		
        this.btnAuditNext.setToolTipText(resHelper.getString("btnAuditNext.toolTipText"));
        // btnViewmbgCtrlBal
        this.btnViewmbgCtrlBal.setAction((IItemAction)ActionProxyFactory.getProxy(actionViewmbgCtrlBal, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnViewmbgCtrlBal.setText(resHelper.getString("btnViewmbgCtrlBal.text"));		
        this.btnViewmbgCtrlBal.setToolTipText(resHelper.getString("btnViewmbgCtrlBal.toolTipText"));
        // btnLocalAudit
        this.btnLocalAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionLocalAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnLocalAudit.setText(resHelper.getString("btnLocalAudit.text"));		
        this.btnLocalAudit.setToolTipText(resHelper.getString("btnLocalAudit.toolTipText"));
        // menuItemAutoBalance
        this.menuItemAutoBalance.setAction((IItemAction)ActionProxyFactory.getProxy(actionAutoBalance, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemAutoBalance.setText(resHelper.getString("menuItemAutoBalance.text"));
        // menuImport
        this.menuImport.setAction((IItemAction)ActionProxyFactory.getProxy(actionImport, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuImport.setText(resHelper.getString("menuImport.text"));		
        this.menuImport.setToolTipText(resHelper.getString("menuImport.toolTipText"));		
        this.menuImport.setActionCommand("M");		
        this.menuImport.setMnemonic(77);
        // menuExport
        this.menuExport.setAction((IItemAction)ActionProxyFactory.getProxy(actionExport, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuExport.setText(resHelper.getString("menuExport.text"));		
        this.menuExport.setToolTipText(resHelper.getString("menuExport.toolTipText"));		
        this.menuExport.setMnemonic(69);
        // menuImportFile
        this.menuImportFile.setAction((IItemAction)ActionProxyFactory.getProxy(actionImportFile, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuImportFile.setText(resHelper.getString("menuImportFile.text"));		
        this.menuImportFile.setToolTipText(resHelper.getString("menuImportFile.toolTipText"));		
        this.menuImportFile.setMnemonic(73);
        // menuItemPrintParameter
        this.menuItemPrintParameter.setAction((IItemAction)ActionProxyFactory.getProxy(actionVoucherPrintParameter, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemPrintParameter.setText(resHelper.getString("menuItemPrintParameter.text"));		
        this.menuItemPrintParameter.setMnemonic(84);		
        this.menuItemPrintParameter.setToolTipText(resHelper.getString("menuItemPrintParameter.toolTipText"));
        // menuVchPrintGrp		
        this.menuVchPrintGrp.setText(resHelper.getString("menuVchPrintGrp.text"));		
        this.menuVchPrintGrp.setMnemonic(80);
        // kDSeparator10
        // menuItenColOption
        this.menuItenColOption.setAction((IItemAction)ActionProxyFactory.getProxy(actionPrintOption, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItenColOption.setText(resHelper.getString("menuItenColOption.text"));
        // menuItemCPrint
        this.menuItemCPrint.setAction((IItemAction)ActionProxyFactory.getProxy(ActionColPrint, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemCPrint.setText(resHelper.getString("menuItemCPrint.text"));
        // menuItemColPrintView
        this.menuItemColPrintView.setAction((IItemAction)ActionProxyFactory.getProxy(actionColPrintView, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemColPrintView.setText(resHelper.getString("menuItemColPrintView.text"));
        // menuItemCrossPrint
        this.menuItemCrossPrint.setAction((IItemAction)ActionProxyFactory.getProxy(actionCrossPrint, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemCrossPrint.setText(resHelper.getString("menuItemCrossPrint.text"));
        // menuItemCrossPrintView
        this.menuItemCrossPrintView.setAction((IItemAction)ActionProxyFactory.getProxy(actionCrossPrintView, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemCrossPrintView.setText(resHelper.getString("menuItemCrossPrintView.text"));
        // menuItemUnit
        this.menuItemUnit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemUnit.setText(resHelper.getString("menuItemUnit.text"));		
        this.menuItemUnit.setToolTipText(resHelper.getString("menuItemUnit.toolTipText"));		
        this.menuItemUnit.setMnemonic(66);
        // miOption
        this.miOption.setAction((IItemAction)ActionProxyFactory.getProxy(actionOption, new Class[] { IItemAction.class }, getServiceContext()));		
        this.miOption.setText(resHelper.getString("miOption.text"));		
        this.miOption.setToolTipText(resHelper.getString("miOption.toolTipText"));		
        this.miOption.setMnemonic(79);
        // menuItemBgAudit
        this.menuItemBgAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionBgAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemBgAudit.setText(resHelper.getString("menuItemBgAudit.text"));		
        this.menuItemBgAudit.setToolTipText(resHelper.getString("menuItemBgAudit.toolTipText"));		
        this.menuItemBgAudit.setVisible(false);
        // menuItemAntiBgAudit
        this.menuItemAntiBgAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAntiBgAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemAntiBgAudit.setText(resHelper.getString("menuItemAntiBgAudit.text"));		
        this.menuItemAntiBgAudit.setToolTipText(resHelper.getString("menuItemAntiBgAudit.toolTipText"));		
        this.menuItemAntiBgAudit.setVisible(false);
        // kDSeparator8
        // menuItemShowQtyAmnt
        this.menuItemShowQtyAmnt.setAction((IItemAction)ActionProxyFactory.getProxy(actionShowQtyAmnt, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemShowQtyAmnt.setText(resHelper.getString("menuItemShowQtyAmnt.text"));		
        this.menuItemShowQtyAmnt.setToolTipText(resHelper.getString("menuItemShowQtyAmnt.toolTipText"));		
        this.menuItemShowQtyAmnt.setMnemonic(77);
        // kDSeparator13		
        this.kDSeparator13.setVisible(false);
        // menuAuditMessage
        this.menuAuditMessage.setAction((IItemAction)ActionProxyFactory.getProxy(actionAuditMessage, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuAuditMessage.setText(resHelper.getString("menuAuditMessage.text"));
        // menuItemSubsidiaryLedger
        this.menuItemSubsidiaryLedger.setAction((IItemAction)ActionProxyFactory.getProxy(actionSubsidiaryLedger, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemSubsidiaryLedger.setText(resHelper.getString("menuItemSubsidiaryLedger.text"));		
        this.menuItemSubsidiaryLedger.setMnemonic(83);
        // menuItemSubsidiaryLedgerAssist
        this.menuItemSubsidiaryLedgerAssist.setAction((IItemAction)ActionProxyFactory.getProxy(actionSubsidiaryLedgerAssist, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemSubsidiaryLedgerAssist.setText(resHelper.getString("menuItemSubsidiaryLedgerAssist.text"));		
        this.menuItemSubsidiaryLedgerAssist.setMnemonic(65);
        // menuItemEditCashflow
        this.menuItemEditCashflow.setAction((IItemAction)ActionProxyFactory.getProxy(actionEditCashflow, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemEditCashflow.setText(resHelper.getString("menuItemEditCashflow.text"));		
        this.menuItemEditCashflow.setToolTipText(resHelper.getString("menuItemEditCashflow.toolTipText"));		
        this.menuItemEditCashflow.setMnemonic(67);
        // menuItemBookOption
        this.menuItemBookOption.setAction((IItemAction)ActionProxyFactory.getProxy(actionBookOption, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemBookOption.setText(resHelper.getString("menuItemBookOption.text"));		
        this.menuItemBookOption.setToolTipText(resHelper.getString("menuItemBookOption.toolTipText"));		
        this.menuItemBookOption.setMnemonic(66);
        // menuViewmbgCtrlBal
        this.menuViewmbgCtrlBal.setAction((IItemAction)ActionProxyFactory.getProxy(actionViewmbgCtrlBal, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuViewmbgCtrlBal.setText(resHelper.getString("menuViewmbgCtrlBal.text"));		
        this.menuViewmbgCtrlBal.setToolTipText(resHelper.getString("menuViewmbgCtrlBal.toolTipText"));		
        this.menuViewmbgCtrlBal.setMnemonic(77);		
        this.menuViewmbgCtrlBal.setVisible(false);		
        this.menuViewmbgCtrlBal.setEnabled(false);
        // menuItemMgCtrl
        this.menuItemMgCtrl.setAction((IItemAction)ActionProxyFactory.getProxy(actionMgCtrl, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemMgCtrl.setText(resHelper.getString("menuItemMgCtrl.text"));		
        this.menuItemMgCtrl.setToolTipText(resHelper.getString("menuItemMgCtrl.toolTipText"));		
        this.menuItemMgCtrl.setMnemonic(71);
        // kDSeparator11
        // kDMenu1		
        this.kDMenu1.setText(resHelper.getString("kDMenu1.text"));		
        this.kDMenu1.setMnemonic(68);
        // menuCancle
        this.menuCancle.setAction((IItemAction)ActionProxyFactory.getProxy(actionCancel, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuCancle.setText(resHelper.getString("menuCancle.text"));		
        this.menuCancle.setMnemonic(73);
        // menuCancelCancel
        this.menuCancelCancel.setAction((IItemAction)ActionProxyFactory.getProxy(actionCancelCancel, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuCancelCancel.setText(resHelper.getString("menuCancelCancel.text"));		
        this.menuCancelCancel.setMnemonic(74);
        // kDSeparator14
        // menuItemCheck
        this.menuItemCheck.setAction((IItemAction)ActionProxyFactory.getProxy(actionCheck, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemCheck.setText(resHelper.getString("menuItemCheck.text"));		
        this.menuItemCheck.setToolTipText(resHelper.getString("menuItemCheck.toolTipText"));		
        this.menuItemCheck.setMnemonic(71);
        // menuItemHandCheck
        this.menuItemHandCheck.setAction((IItemAction)ActionProxyFactory.getProxy(actionHandCheck, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemHandCheck.setText(resHelper.getString("menuItemHandCheck.text"));		
        this.menuItemHandCheck.setToolTipText(resHelper.getString("menuItemHandCheck.toolTipText"));
        // menuItemAntiCheck
        this.menuItemAntiCheck.setAction((IItemAction)ActionProxyFactory.getProxy(actionAntiCheck, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemAntiCheck.setText(resHelper.getString("menuItemAntiCheck.text"));		
        this.menuItemAntiCheck.setToolTipText(resHelper.getString("menuItemAntiCheck.toolTipText"));		
        this.menuItemAntiCheck.setMnemonic(66);
        // menuItemAudit
        this.menuItemAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemAudit.setText(resHelper.getString("menuItemAudit.text"));		
        this.menuItemAudit.setToolTipText(resHelper.getString("menuItemAudit.toolTipText"));		
        this.menuItemAudit.setMnemonic(80);
        // menuItemAntiAudit
        this.menuItemAntiAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAntiAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemAntiAudit.setText(resHelper.getString("menuItemAntiAudit.text"));		
        this.menuItemAntiAudit.setToolTipText(resHelper.getString("menuItemAntiAudit.toolTipText"));		
        this.menuItemAntiAudit.setMnemonic(85);
        // menuAuditBack
        this.menuAuditBack.setAction((IItemAction)ActionProxyFactory.getProxy(actionAuditBack, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuAuditBack.setText(resHelper.getString("menuAuditBack.text"));
        // menuItemPost
        this.menuItemPost.setAction((IItemAction)ActionProxyFactory.getProxy(actionPost, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemPost.setText(resHelper.getString("menuItemPost.text"));		
        this.menuItemPost.setToolTipText(resHelper.getString("menuItemPost.toolTipText"));		
        this.menuItemPost.setMnemonic(75);
        // menuItemAntiPost
        this.menuItemAntiPost.setAction((IItemAction)ActionProxyFactory.getProxy(actionAntiPost, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemAntiPost.setText(resHelper.getString("menuItemAntiPost.text"));		
        this.menuItemAntiPost.setToolTipText(resHelper.getString("menuItemAntiPost.toolTipText"));		
        this.menuItemAntiPost.setMnemonic(78);
        // menuItemAdjustVoucher
        this.menuItemAdjustVoucher.setAction((IItemAction)ActionProxyFactory.getProxy(actionAdjustVoucher, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemAdjustVoucher.setText(resHelper.getString("menuItemAdjustVoucher.text"));		
        this.menuItemAdjustVoucher.setToolTipText(resHelper.getString("menuItemAdjustVoucher.toolTipText"));		
        this.menuItemAdjustVoucher.setMnemonic(72);
        // menuItemAuditNext
        this.menuItemAuditNext.setAction((IItemAction)ActionProxyFactory.getProxy(actionAuditNext, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemAuditNext.setText(resHelper.getString("menuItemAuditNext.text"));		
        this.menuItemAuditNext.setToolTipText(resHelper.getString("menuItemAuditNext.toolTipText"));		
        this.menuItemAuditNext.setMnemonic(65);
        // menuItemLocalAudit
        this.menuItemLocalAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionLocalAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemLocalAudit.setText(resHelper.getString("menuItemLocalAudit.text"));		
        this.menuItemLocalAudit.setToolTipText(resHelper.getString("menuItemLocalAudit.toolTipText"));		
        this.menuItemLocalAudit.setMnemonic(76);
        // kDSeparator9
        // menuItemAddAssistRecord
        this.menuItemAddAssistRecord.setAction((IItemAction)ActionProxyFactory.getProxy(actionAddAssistRecord, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemAddAssistRecord.setText(resHelper.getString("menuItemAddAssistRecord.text"));		
        this.menuItemAddAssistRecord.setToolTipText(resHelper.getString("menuItemAddAssistRecord.toolTipText"));		
        this.menuItemAddAssistRecord.setMnemonic(87);
        // menuItemInsertAssistRecord
        this.menuItemInsertAssistRecord.setAction((IItemAction)ActionProxyFactory.getProxy(actionInsertAssistRecord, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemInsertAssistRecord.setText(resHelper.getString("menuItemInsertAssistRecord.text"));		
        this.menuItemInsertAssistRecord.setToolTipText(resHelper.getString("menuItemInsertAssistRecord.toolTipText"));		
        this.menuItemInsertAssistRecord.setMnemonic(83);
        // menuItemRemoveAssistRecord
        this.menuItemRemoveAssistRecord.setAction((IItemAction)ActionProxyFactory.getProxy(actionRemoveAssistRecord, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemRemoveAssistRecord.setText(resHelper.getString("menuItemRemoveAssistRecord.text"));		
        this.menuItemRemoveAssistRecord.setToolTipText(resHelper.getString("menuItemRemoveAssistRecord.toolTipText"));		
        this.menuItemRemoveAssistRecord.setMnemonic(69);
        // menuItemVerify
        this.menuItemVerify.setAction((IItemAction)ActionProxyFactory.getProxy(actionVerify, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemVerify.setText(resHelper.getString("menuItemVerify.text"));		
        this.menuItemVerify.setToolTipText(resHelper.getString("menuItemVerify.toolTipText"));		
        this.menuItemVerify.setMnemonic(86);
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
        this.setBounds(new Rectangle(10, 10, 800, 620));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(10, 10, 800, 620));
        btnAddLine.setBounds(new Rectangle(492, 60, 26, 18));
        this.add(btnAddLine, new KDLayout.Constraints(492, 60, 26, 18, 0));
        btnInsertLine.setBounds(new Rectangle(504, 48, 26, 18));
        this.add(btnInsertLine, new KDLayout.Constraints(504, 48, 26, 18, 0));
        btnRemoveLine.setBounds(new Rectangle(495, 37, 26, 18));
        this.add(btnRemoveLine, new KDLayout.Constraints(495, 37, 26, 18, 0));
        btnAddAssistRecord.setBounds(new Rectangle(504, 0, 26, 18));
        this.add(btnAddAssistRecord, new KDLayout.Constraints(504, 0, 26, 18, 0));
        btnInsertAssistRecord.setBounds(new Rectangle(492, 24, 26, 18));
        this.add(btnInsertAssistRecord, new KDLayout.Constraints(492, 24, 26, 18, 0));
        btnVerify.setBounds(new Rectangle(508, 12, 50, 18));
        this.add(btnVerify, new KDLayout.Constraints(508, 12, 50, 18, 0));
        btnRemoveAssistRecord.setBounds(new Rectangle(504, 24, 26, 18));
        this.add(btnRemoveAssistRecord, new KDLayout.Constraints(504, 24, 26, 18, 0));
        kDLabelContainer3.setBounds(new Rectangle(597, 34, 87, 19));
        this.add(kDLabelContainer3, new KDLayout.Constraints(597, 34, 87, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer4.setBounds(new Rectangle(400, 10, 175, 19));
        this.add(kDLabelContainer4, new KDLayout.Constraints(400, 10, 175, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer5.setBounds(new Rectangle(12, 34, 175, 19));
        this.add(kDLabelContainer5, new KDLayout.Constraints(12, 34, 175, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer6.setBounds(new Rectangle(211, 10, 175, 19));
        this.add(kDLabelContainer6, new KDLayout.Constraints(211, 10, 175, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer7.setBounds(new Rectangle(597, 10, 194, 19));
        this.add(kDLabelContainer7, new KDLayout.Constraints(597, 10, 194, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        lblCtnCurrency.setBounds(new Rectangle(689, 34, 101, 19));
        this.add(lblCtnCurrency, new KDLayout.Constraints(689, 34, 101, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabelContainer9.setBounds(new Rectangle(211, 34, 175, 19));
        this.add(kDLabelContainer9, new KDLayout.Constraints(211, 34, 175, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer10.setBounds(new Rectangle(20, 591, 130, 19));
        this.add(kDLabelContainer10, new KDLayout.Constraints(20, 591, 130, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer11.setBounds(new Rectangle(184, 591, 130, 19));
        this.add(kDLabelContainer11, new KDLayout.Constraints(184, 591, 130, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer12.setBounds(new Rectangle(347, 591, 130, 19));
        this.add(kDLabelContainer12, new KDLayout.Constraints(347, 591, 130, 19, KDLayout.Constraints.ANCHOR_CENTRE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer13.setBounds(new Rectangle(495, 591, 130, 19));
        this.add(kDLabelContainer13, new KDLayout.Constraints(495, 591, 130, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer14.setBounds(new Rectangle(504, 596, 150, 19));
        this.add(kDLabelContainer14, new KDLayout.Constraints(504, 596, 150, 19, 0));
        kDLabelContainer15.setBounds(new Rectangle(654, 591, 130, 19));
        this.add(kDLabelContainer15, new KDLayout.Constraints(654, 591, 130, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDPanel1.setBounds(new Rectangle(11, 58, 780, 528));
        this.add(kDPanel1, new KDLayout.Constraints(11, 58, 780, 528, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        btnShowBal.setBounds(new Rectangle(252, 60, 22, 19));
        this.add(btnShowBal, new KDLayout.Constraints(252, 60, 22, 19, 0));
        importBalance.setBounds(new Rectangle(516, 60, 22, 19));
        this.add(importBalance, new KDLayout.Constraints(516, 60, 22, 19, 0));
        kDLabelContainer1.setBounds(new Rectangle(288, 600, 200, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(288, 600, 200, 19, 0));
        btnAutoVerify.setBounds(new Rectangle(600, 11, 22, 19));
        this.add(btnAutoVerify, new KDLayout.Constraints(600, 11, 22, 19, 0));
        btnImpExchangeRate.setBounds(new Rectangle(596, 39, 22, 19));
        this.add(btnImpExchangeRate, new KDLayout.Constraints(596, 39, 22, 19, 0));
        kDLabelContainer2.setBounds(new Rectangle(400, 35, 175, 19));
        this.add(kDLabelContainer2, new KDLayout.Constraints(400, 35, 175, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer8.setBounds(new Rectangle(12, 10, 175, 19));
        this.add(kDLabelContainer8, new KDLayout.Constraints(12, 10, 175, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(spnAttachments);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(dateBizDate);
        //kDLabelContainer5
        kDLabelContainer5.setBoundEditor(cbxVoucherType);
        //kDLabelContainer6
        kDLabelContainer6.setBoundEditor(dateBookedDate);
        //kDLabelContainer7
        kDLabelContainer7.setBoundEditor(cbxPeriod);
        //lblCtnCurrency
        lblCtnCurrency.setBoundEditor(cbxCurrency);
        //kDLabelContainer9
        kDLabelContainer9.setBoundEditor(txtNumber);
        //kDLabelContainer10
        kDLabelContainer10.setBoundEditor(txtCreator);
        //kDLabelContainer11
        kDLabelContainer11.setBoundEditor(txtAuditor);
        //kDLabelContainer12
        kDLabelContainer12.setBoundEditor(txtCashier);
        //kDLabelContainer13
        kDLabelContainer13.setBoundEditor(txtPoster);
        //kDLabelContainer14
        kDLabelContainer14.setBoundEditor(bizPromptHandler);
        //kDLabelContainer15
        kDLabelContainer15.setBoundEditor(txtCanceller);
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(11, 58, 780, 528));        splitPane.setBounds(new Rectangle(1, 1, 778, 497));
        kDPanel1.add(splitPane, new KDLayout.Constraints(1, 1, 778, 497, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        lblTotal.setBounds(new Rectangle(13, 500, 350, 19));
        kDPanel1.add(lblTotal, new KDLayout.Constraints(13, 500, 350, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        lblLD.setBounds(new Rectangle(364, 500, 198, 19));
        kDPanel1.add(lblLD, new KDLayout.Constraints(364, 500, 198, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_RIGHT));
        lblLC.setBounds(new Rectangle(563, 500, 198, 19));
        kDPanel1.add(lblLC, new KDLayout.Constraints(563, 500, 198, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_RIGHT));
        //splitPane
        splitPane.add(ctnEntry, "top");
        splitPane.add(ctnRecord, "bottom");
        //ctnEntry
ctnEntry.getContentPane().setLayout(new BorderLayout(0, 0));        ctnEntry.getContentPane().add(tblDetail, BorderLayout.CENTER);
        ctnEntry.getContentPane().add(kDPanel2, BorderLayout.NORTH);
        ctnEntry.getContentPane().add(kDPanel3, BorderLayout.WEST);
        ctnEntry.getContentPane().add(kDPanel4, BorderLayout.EAST);
        ctnEntry.getContentPane().add(kDPanel5, BorderLayout.SOUTH);
        kDPanel2.setLayout(null);        kDPanel3.setLayout(null);        kDPanel4.setLayout(null);        kDPanel5.setLayout(null);        //ctnRecord
ctnRecord.getContentPane().setLayout(new BorderLayout(0, 0));        ctnRecord.getContentPane().add(tblAssistRecord, BorderLayout.CENTER);
        ctnRecord.getContentPane().add(kDPanel6, BorderLayout.NORTH);
        ctnRecord.getContentPane().add(kDPanel7, BorderLayout.WEST);
        ctnRecord.getContentPane().add(kDPanel8, BorderLayout.EAST);
        ctnRecord.getContentPane().add(kDPanel9, BorderLayout.SOUTH);
        kDPanel6.setLayout(null);        kDPanel7.setLayout(null);        kDPanel8.setLayout(null);        kDPanel9.setLayout(null);        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtCompany);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtDescription);
        //kDLabelContainer8
        kDLabelContainer8.setBoundEditor(prmtCompany);

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
        menuFile.add(menuItemSave);
        menuFile.add(menuItemCloudFeed);
        menuFile.add(menuItemSubmit);
        menuFile.add(menuItemCloudScreen);
        menuFile.add(menuSubmitOption);
        menuFile.add(menuItemCloudShare);
        menuFile.add(menuItemAutoBalance);
        menuFile.add(menuItemPageSetup);
        menuFile.add(kdSeparatorFWFile1);
        menuFile.add(rMenuItemSubmit);
        menuFile.add(rMenuItemSubmitAndAddNew);
        menuFile.add(kDSeparator7);
        menuFile.add(rMenuItemSubmitAndPrint);
        menuFile.add(menuImport);
        menuFile.add(separatorFile1);
        menuFile.add(menuExport);
        menuFile.add(MenuItemAttachment);
        menuFile.add(menuImportFile);
        menuFile.add(kDSeparator2);
        menuFile.add(menuItemSendMail);
        menuFile.add(menuItemPrintParameter);
        menuFile.add(menuVchPrintGrp);
        menuFile.add(kDSeparator4);
        menuFile.add(menuItemExitCurrent);
        //menuSubmitOption
        menuSubmitOption.add(chkMenuItemSubmitAndAddNew);
        menuSubmitOption.add(chkMenuItemSubmitAndPrint);
        //menuVchPrintGrp
        menuVchPrintGrp.add(menuItemPrint);
        menuVchPrintGrp.add(menuItemPrintPreview);
        menuVchPrintGrp.add(kDSeparator10);
        menuVchPrintGrp.add(menuItenColOption);
        menuVchPrintGrp.add(menuItemCPrint);
        menuVchPrintGrp.add(menuItemColPrintView);
        menuVchPrintGrp.add(menuItemCrossPrint);
        menuVchPrintGrp.add(menuItemCrossPrintView);
        //menuEdit
        menuEdit.add(menuItemCopy);
        menuEdit.add(menuItemEdit);
        menuEdit.add(menuItemRemove);
        menuEdit.add(menuItemCreateTo);
        menuEdit.add(menuItemReset);
        menuEdit.add(menuItemUnit);
        menuEdit.add(separator1);
        menuEdit.add(separatorEdit1);
        menuEdit.add(miOption);
        menuEdit.add(separator2);
        menuEdit.add(menuItemCreateFrom);
        menuEdit.add(menuItemEnterToNextRow);
        menuEdit.add(menuItemCopyFrom);
        menuEdit.add(menuItemBgAudit);
        menuEdit.add(menuItemAntiBgAudit);
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
        menuView.add(kDSeparator8);
        menuView.add(menuItemShowQtyAmnt);
        menuView.add(kDSeparator13);
        menuView.add(menuItemTraceUp);
        menuView.add(menuItemLocate);
        menuView.add(menuItemTraceDown);
        menuView.add(menuAuditMessage);
        menuView.add(menuItemSubsidiaryLedger);
        menuView.add(menuItemSubsidiaryLedgerAssist);
        //menuBiz
        menuBiz.add(MenuItemVoucher);
        menuBiz.add(menuItemEditCashflow);
        menuBiz.add(menuItemBookOption);
        menuBiz.add(menuViewmbgCtrlBal);
        menuBiz.add(menuItemMgCtrl);
        menuBiz.add(kDSeparator11);
        menuBiz.add(kDMenu1);
        menuBiz.add(menuItemDelVoucher);
        menuBiz.add(menuItemAdjustVoucher);
        menuBiz.add(menuItemAuditNext);
        menuBiz.add(menuItemLocalAudit);
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        //kDMenu1
        kDMenu1.add(menuCancle);
        kDMenu1.add(menuCancelCancel);
        kDMenu1.add(kDSeparator14);
        kDMenu1.add(menuItemCheck);
        kDMenu1.add(menuItemHandCheck);
        kDMenu1.add(menuItemAntiCheck);
        kDMenu1.add(menuItemAudit);
        kDMenu1.add(menuItemAntiAudit);
        kDMenu1.add(menuAuditBack);
        kDMenu1.add(menuItemPost);
        kDMenu1.add(menuItemAntiPost);
        //menuTable1
        menuTable1.add(menuItemAddLine);
        menuTable1.add(menuItemCopyLine);
        menuTable1.add(menuItemInsertLine);
        menuTable1.add(menuItemRemoveLine);
        menuTable1.add(kDSeparator9);
        menuTable1.add(menuItemAddAssistRecord);
        menuTable1.add(menuItemInsertAssistRecord);
        menuTable1.add(menuItemRemoveAssistRecord);
        menuTable1.add(menuItemVerify);
        //menuTool
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemMsgFormat);
        menuTool.add(kDSeparator6);
        menuTool.add(menuItemCalculator);
        menuTool.add(menuItemToolBarCustom);
        //menuWorkflow
        menuWorkflow.add(menuItemStartWorkFlow);
        menuWorkflow.add(separatorWF1);
        menuWorkflow.add(MenuItemWFG);
        menuWorkflow.add(menuItemWorkFlowList);
        menuWorkflow.add(separatorWF2);
        menuWorkflow.add(menuItemMultiapprove);
        menuWorkflow.add(menuItemViewSubmitProccess);
        menuWorkflow.add(menuItemNextPerson);
        menuWorkflow.add(menuItemAuditResult);
        menuWorkflow.add(kDSeparator5);
        menuWorkflow.add(menuItemViewDoProccess);
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
        this.toolBar.add(btnUnit);
        this.toolBar.add(btnPageSetup);
        this.toolBar.add(btnRemove);
        this.toolBar.add(btnAttachment);
        this.toolBar.add(btnPrint);
        this.toolBar.add(separatorFW1);
        this.toolBar.add(btnPrintPreview);
        this.toolBar.add(kDSeparator3);
        this.toolBar.add(btnFirst);
        this.toolBar.add(separatorFW2);
        this.toolBar.add(btnPre);
        this.toolBar.add(btnNext);
        this.toolBar.add(btnLast);
        this.toolBar.add(kDSeparator1);
        this.toolBar.add(separator4);
        this.toolBar.add(separatorFW3);
        this.toolBar.add(btnTraceUp);
        this.toolBar.add(btnSignature);
        this.toolBar.add(btnShowQtyAmnt);
        this.toolBar.add(btnWorkFlowG);
        this.toolBar.add(btnNumberSign);
        this.toolBar.add(btnViewSignature);
        this.toolBar.add(separatorFW4);
        this.toolBar.add(btnBookOption);
        this.toolBar.add(separatorFW7);
        this.toolBar.add(btnEditCashflow);
        this.toolBar.add(btnAdjunct);
        this.toolBar.add(btnCreateFrom);
        this.toolBar.add(btnCreateTo);
        this.toolBar.add(btnCopyLine);
        this.toolBar.add(separatorFW5);
        this.toolBar.add(btnAccountBalance);
        this.toolBar.add(btnCopyFrom);
        this.toolBar.add(separatorFW8);
        this.toolBar.add(btnAssistant);
        this.toolBar.add(btnAdjustVoucher);
        this.toolBar.add(btnCancel);
        this.toolBar.add(separatorFW6);
        this.toolBar.add(btnTraceDown);
        this.toolBar.add(separatorFW9);
        this.toolBar.add(btnVoucher);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(wfSpt);
        this.toolBar.add(btnNextPerson);
        this.toolBar.add(btnCheckGrp);
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnAntiAudit);
        this.toolBar.add(btnAuditBack);
        this.toolBar.add(btnHandCheck);
        this.toolBar.add(btnCheck);
        this.toolBar.add(btnAntiCheck);
        this.toolBar.add(btnPost);
        this.toolBar.add(btnAntiPost);
        this.toolBar.add(btnBgAudit);
        this.toolBar.add(btnAntiBgAudit);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(btnAuditNext);
        this.toolBar.add(btnViewmbgCtrlBal);
        this.toolBar.add(btnLocalAudit);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("attachments", int.class, this.spnAttachments, "value");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.dateBizDate, "value");
		dataBinder.registerBinding("bookedDate", java.util.Date.class, this.dateBookedDate, "value");
		dataBinder.registerBinding("period", com.kingdee.eas.basedata.assistant.PeriodInfo.class, this.cbxPeriod, "selectedItem");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("creator.name", String.class, this.txtCreator, "text");
		dataBinder.registerBinding("auditor.name", String.class, this.txtAuditor, "text");
		dataBinder.registerBinding("cashier.name", String.class, this.txtCashier, "text");
		dataBinder.registerBinding("poster.name", String.class, this.txtPoster, "text");
		dataBinder.registerBinding("canceller.name", String.class, this.txtCanceller, "text");
		dataBinder.registerBinding("company.name", String.class, this.txtCompany, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.app.Copy_VoucherEditUIHandler";
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
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.fi.gl.VoucherInfo)ov;
    }

    /**
     * output loadFields method
     */
    public void loadFields()
    {
        dataBinder.loadFields();
    }
    /**
     * output storeFields method
     */
    public void storeFields()
    {
		dataBinder.storeFields();
    }

	/**
	 * ????????§µ??
	 */
	protected void registerValidator() {
    	getValidateHelper().setCustomValidator( getValidator() );
		getValidateHelper().registerBindProperty("attachments", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bookedDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("period", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator.name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor.name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cashier.name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("poster.name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("canceller.name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company.name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    		
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
     * output chkMenuItemSubmitAndAddNew_stateChanged method
     */
    protected void chkMenuItemSubmitAndAddNew_stateChanged(javax.swing.event.ChangeEvent e) throws Exception
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
        sic.add(new SelectorItemInfo("attachments"));
        sic.add(new SelectorItemInfo("bizDate"));
        sic.add(new SelectorItemInfo("bookedDate"));
        sic.add(new SelectorItemInfo("period"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("creator.name"));
        sic.add(new SelectorItemInfo("auditor.name"));
        sic.add(new SelectorItemInfo("cashier.name"));
        sic.add(new SelectorItemInfo("poster.name"));
        sic.add(new SelectorItemInfo("canceller.name"));
        sic.add(new SelectorItemInfo("company.name"));
        sic.add(new SelectorItemInfo("description"));
        return sic;
    }        
    	

    /**
     * output actionPageSetup_actionPerformed method
     */
    public void actionPageSetup_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPageSetup_actionPerformed(e);
    }
    	

    /**
     * output actionCalculator_actionPerformed method
     */
    public void actionCalculator_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCalculator_actionPerformed(e);
    }
    	

    /**
     * output actionExport_actionPerformed method
     */
    public void actionExport_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExport_actionPerformed(e);
    }
    	

    /**
     * output actionSave_actionPerformed method
     */
    public void actionSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSave_actionPerformed(e);
    }
    	

    /**
     * output actionSubmit_actionPerformed method
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmit_actionPerformed(e);
    }
    	

    /**
     * output actionCancel_actionPerformed method
     */
    public void actionCancel_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCancel_actionPerformed(e);
    }
    	

    /**
     * output actionCancelCancel_actionPerformed method
     */
    public void actionCancelCancel_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCancelCancel_actionPerformed(e);
    }
    	

    /**
     * output actionFirst_actionPerformed method
     */
    public void actionFirst_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionFirst_actionPerformed(e);
    }
    	

    /**
     * output actionPre_actionPerformed method
     */
    public void actionPre_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPre_actionPerformed(e);
    }
    	

    /**
     * output actionNext_actionPerformed method
     */
    public void actionNext_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionNext_actionPerformed(e);
    }
    	

    /**
     * output actionLast_actionPerformed method
     */
    public void actionLast_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLast_actionPerformed(e);
    }
    	

    /**
     * output actionPrint_actionPerformed method
     */
    public void actionPrint_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPrint_actionPerformed(e);
    }
    	

    /**
     * output actionPrintPreview_actionPerformed method
     */
    public void actionPrintPreview_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPrintPreview_actionPerformed(e);
    }
    	

    /**
     * output actionCopy_actionPerformed method
     */
    public void actionCopy_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopy_actionPerformed(e);
    }
    	

    /**
     * output actionAddNew_actionPerformed method
     */
    public void actionAddNew_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAddNew_actionPerformed(e);
    }
    	

    /**
     * output actionAddLine_actionPerformed method
     */
    public void actionAddLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAddLine_actionPerformed(e);
    }
    	

    /**
     * output actionInsertLine_actionPerformed method
     */
    public void actionInsertLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionInsertLine_actionPerformed(e);
    }
    	

    /**
     * output actionRemoveLine_actionPerformed method
     */
    public void actionRemoveLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemoveLine_actionPerformed(e);
    }
    	

    /**
     * output actionTraceUp_actionPerformed method
     */
    public void actionTraceUp_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionTraceUp_actionPerformed(e);
    }
    	

    /**
     * output actionViewSubmitProccess_actionPerformed method
     */
    public void actionViewSubmitProccess_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionViewSubmitProccess_actionPerformed(e);
    }
    	

    /**
     * output actionViewDoProccess_actionPerformed method
     */
    public void actionViewDoProccess_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionViewDoProccess_actionPerformed(e);
    }
    	

    /**
     * output actionAddAssistRecord_actionPerformed method
     */
    public void actionAddAssistRecord_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionInsertAssistRecord_actionPerformed method
     */
    public void actionInsertAssistRecord_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionRemoveAssistRecord_actionPerformed method
     */
    public void actionRemoveAssistRecord_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionVerify_actionPerformed method
     */
    public void actionVerify_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionEditCashflow_actionPerformed method
     */
    public void actionEditCashflow_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionCheck_actionPerformed method
     */
    public void actionCheck_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionAntiCheck_actionPerformed method
     */
    public void actionAntiCheck_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionAntiAudit_actionPerformed method
     */
    public void actionAntiAudit_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionPost_actionPerformed method
     */
    public void actionPost_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionAntiPost_actionPerformed method
     */
    public void actionAntiPost_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionShowQtyAmnt_actionPerformed method
     */
    public void actionShowQtyAmnt_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionBgAudit_actionPerformed method
     */
    public void actionBgAudit_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionAntiBgAudit_actionPerformed method
     */
    public void actionAntiBgAudit_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionOption_actionPerformed method
     */
    public void actionOption_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionBookOption_actionPerformed method
     */
    public void actionBookOption_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionImport_actionPerformed method
     */
    public void actionImport_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionPrintOption_actionPerformed method
     */
    public void actionPrintOption_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionColPrint_actionPerformed method
     */
    public void actionColPrint_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionColPrintView_actionPerformed method
     */
    public void actionColPrintView_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionAccountBalance_actionPerformed method
     */
    public void actionAccountBalance_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionAssistant_actionPerformed method
     */
    public void actionAssistant_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionHandCheck_actionPerformed method
     */
    public void actionHandCheck_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionImportFile_actionPerformed method
     */
    public void actionImportFile_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionCrossPrint_actionPerformed method
     */
    public void actionCrossPrint_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionAdjunct_actionPerformed method
     */
    public void actionAdjunct_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionViewmbgCtrlBal_actionPerformed method
     */
    public void actionViewmbgCtrlBal_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionVoucherPrintParameter_actionPerformed method
     */
    public void actionVoucherPrintParameter_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionCrossPrintView_actionPerformed method
     */
    public void actionCrossPrintView_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionImportBalance_actionPerformed method
     */
    public void actionImportBalance_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionSubmitPrint_actionPerformed method
     */
    public void actionSubmitPrint_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionEntryCellDown_actionPerformed method
     */
    public void actionEntryCellDown_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionSubsidiaryLedger_actionPerformed method
     */
    public void actionSubsidiaryLedger_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionSubsidiaryLedgerAssist_actionPerformed method
     */
    public void actionSubsidiaryLedgerAssist_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionAsstCellDown_actionPerformed method
     */
    public void actionAsstCellDown_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionUnit_actionPerformed method
     */
    public void actionUnit_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionMgCtrl_actionPerformed method
     */
    public void actionMgCtrl_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionAdjustVoucher_actionPerformed method
     */
    public void actionAdjustVoucher_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionLocalAudit_actionPerformed method
     */
    public void actionLocalAudit_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionAutoVerify_actionPerformed method
     */
    public void actionAutoVerify_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionAuditNext_actionPerformed method
     */
    public void actionAuditNext_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionImpExchangeRate_actionPerformed method
     */
    public void actionImpExchangeRate_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionAuditBack_actionPerformed method
     */
    public void actionAuditBack_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionAuditMessage_actionPerformed method
     */
    public void actionAuditMessage_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionAutoBalance_actionPerformed method
     */
    public void actionAutoBalance_actionPerformed(ActionEvent e) throws Exception
    {
    }
	public RequestContext prepareActionPageSetup(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionPageSetup(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionPageSetup() {
    	return false;
    }
	public RequestContext prepareActionCalculator(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionCalculator(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionCalculator() {
    	return false;
    }
	public RequestContext prepareActionExport(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionExport(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionExport() {
    	return false;
    }
	public RequestContext prepareActionSave(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionSave(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionSave() {
    	return false;
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
	public RequestContext prepareActionCancel(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionCancel(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionCancel() {
    	return false;
    }
	public RequestContext prepareActionCancelCancel(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionCancelCancel(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionCancelCancel() {
    	return false;
    }
	public RequestContext prepareActionFirst(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionFirst(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionFirst() {
    	return false;
    }
	public RequestContext prepareActionPre(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionPre(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionPre() {
    	return false;
    }
	public RequestContext prepareActionNext(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionNext(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionNext() {
    	return false;
    }
	public RequestContext prepareActionLast(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionLast(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionLast() {
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
	public RequestContext prepareActionCopy(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionCopy(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionCopy() {
    	return false;
    }
	public RequestContext prepareActionAddNew(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionAddNew(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAddNew() {
    	return false;
    }
	public RequestContext prepareActionAddLine(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionAddLine(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAddLine() {
    	return false;
    }
	public RequestContext prepareActionInsertLine(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionInsertLine(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionInsertLine() {
    	return false;
    }
	public RequestContext prepareActionRemoveLine(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionRemoveLine(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionRemoveLine() {
    	return false;
    }
	public RequestContext prepareActionTraceUp(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionTraceUp(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionTraceUp() {
    	return false;
    }
	public RequestContext prepareActionViewSubmitProccess(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionViewSubmitProccess(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionViewSubmitProccess() {
    	return false;
    }
	public RequestContext prepareActionViewDoProccess(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionViewDoProccess(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionViewDoProccess() {
    	return false;
    }
	public RequestContext prepareActionAddAssistRecord(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAddAssistRecord() {
    	return false;
    }
	public RequestContext prepareActionInsertAssistRecord(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionInsertAssistRecord() {
    	return false;
    }
	public RequestContext prepareActionRemoveAssistRecord(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionRemoveAssistRecord() {
    	return false;
    }
	public RequestContext prepareActionVerify(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionVerify() {
    	return false;
    }
	public RequestContext prepareActionEditCashflow(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionEditCashflow() {
    	return false;
    }
	public RequestContext prepareActionCheck(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionCheck() {
    	return false;
    }
	public RequestContext prepareActionAntiCheck(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAntiCheck() {
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
	public RequestContext prepareActionAntiAudit(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAntiAudit() {
    	return false;
    }
	public RequestContext prepareActionPost(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionPost() {
    	return false;
    }
	public RequestContext prepareActionAntiPost(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAntiPost() {
    	return false;
    }
	public RequestContext prepareActionShowQtyAmnt(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionShowQtyAmnt() {
    	return false;
    }
	public RequestContext prepareActionBgAudit(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionBgAudit() {
    	return false;
    }
	public RequestContext prepareActionAntiBgAudit(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAntiBgAudit() {
    	return false;
    }
	public RequestContext prepareActionOption(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionOption() {
    	return false;
    }
	public RequestContext prepareActionBookOption(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionBookOption() {
    	return false;
    }
	public RequestContext prepareActionImport(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionImport() {
    	return false;
    }
	public RequestContext prepareActionPrintOption(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionPrintOption() {
    	return false;
    }
	public RequestContext prepareActionColPrint(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionColPrint() {
    	return false;
    }
	public RequestContext prepareActionColPrintView(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionColPrintView() {
    	return false;
    }
	public RequestContext prepareActionAccountBalance(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAccountBalance() {
    	return false;
    }
	public RequestContext prepareActionAssistant(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAssistant() {
    	return false;
    }
	public RequestContext prepareActionHandCheck(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionHandCheck() {
    	return false;
    }
	public RequestContext prepareActionImportFile(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionImportFile() {
    	return false;
    }
	public RequestContext prepareActionCrossPrint(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionCrossPrint() {
    	return false;
    }
	public RequestContext prepareActionAdjunct(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAdjunct() {
    	return false;
    }
	public RequestContext prepareActionViewmbgCtrlBal(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionViewmbgCtrlBal() {
    	return false;
    }
	public RequestContext prepareActionVoucherPrintParameter(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionVoucherPrintParameter() {
    	return false;
    }
	public RequestContext prepareActionCrossPrintView(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionCrossPrintView() {
    	return false;
    }
	public RequestContext prepareActionImportBalance(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionImportBalance() {
    	return false;
    }
	public RequestContext prepareActionSubmitPrint(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionSubmitPrint() {
    	return false;
    }
	public RequestContext prepareActionEntryCellDown(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionEntryCellDown() {
    	return false;
    }
	public RequestContext prepareActionSubsidiaryLedger(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionSubsidiaryLedger() {
    	return false;
    }
	public RequestContext prepareActionSubsidiaryLedgerAssist(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionSubsidiaryLedgerAssist() {
    	return false;
    }
	public RequestContext prepareActionAsstCellDown(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAsstCellDown() {
    	return false;
    }
	public RequestContext prepareActionUnit(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionUnit() {
    	return false;
    }
	public RequestContext prepareActionMgCtrl(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionMgCtrl() {
    	return false;
    }
	public RequestContext prepareActionAdjustVoucher(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAdjustVoucher() {
    	return false;
    }
	public RequestContext prepareActionLocalAudit(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionLocalAudit() {
    	return false;
    }
	public RequestContext prepareActionAutoVerify(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAutoVerify() {
    	return false;
    }
	public RequestContext prepareActionAuditNext(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAuditNext() {
    	return false;
    }
	public RequestContext prepareActionImpExchangeRate(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionImpExchangeRate() {
    	return false;
    }
	public RequestContext prepareActionAuditBack(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAuditBack() {
    	return false;
    }
	public RequestContext prepareActionAuditMessage(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAuditMessage() {
    	return false;
    }
	public RequestContext prepareActionAutoBalance(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAutoBalance() {
    	return false;
    }

    /**
     * output ActionAddAssistRecord class
     */     
    protected class ActionAddAssistRecord extends ItemAction {     
    
        public ActionAddAssistRecord()
        {
            this(null);
        }

        public ActionAddAssistRecord(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl shift K"));
            this.putValue(ItemAction.ACTION_COMMAND_KEY, "addAssistRecord");
            _tempStr = resHelper.getString("ActionAddAssistRecord.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAddAssistRecord.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAddAssistRecord.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionAddAssistRecord", "actionAddAssistRecord_actionPerformed", e);
        }
    }

    /**
     * output ActionInsertAssistRecord class
     */     
    protected class ActionInsertAssistRecord extends ItemAction {     
    
        public ActionInsertAssistRecord()
        {
            this(null);
        }

        public ActionInsertAssistRecord(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl shift J"));
            this.putValue(ItemAction.ACTION_COMMAND_KEY, "insertAssistRecord");
            _tempStr = resHelper.getString("ActionInsertAssistRecord.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionInsertAssistRecord.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionInsertAssistRecord.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionInsertAssistRecord", "actionInsertAssistRecord_actionPerformed", e);
        }
    }

    /**
     * output ActionRemoveAssistRecord class
     */     
    protected class ActionRemoveAssistRecord extends ItemAction {     
    
        public ActionRemoveAssistRecord()
        {
            this(null);
        }

        public ActionRemoveAssistRecord(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl shift L"));
            this.putValue(ItemAction.ACTION_COMMAND_KEY, "removeAssistRecord");
            _tempStr = resHelper.getString("ActionRemoveAssistRecord.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionRemoveAssistRecord.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionRemoveAssistRecord.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionRemoveAssistRecord", "actionRemoveAssistRecord_actionPerformed", e);
        }
    }

    /**
     * output ActionVerify class
     */     
    protected class ActionVerify extends ItemAction {     
    
        public ActionVerify()
        {
            this(null);
        }

        public ActionVerify(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl shift V"));
            this.putValue(ItemAction.ACTION_COMMAND_KEY, "verify");
            _tempStr = resHelper.getString("ActionVerify.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionVerify.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionVerify.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionVerify", "actionVerify_actionPerformed", e);
        }
    }

    /**
     * output ActionEditCashflow class
     */     
    protected class ActionEditCashflow extends ItemAction {     
    
        public ActionEditCashflow()
        {
            this(null);
        }

        public ActionEditCashflow(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl H"));
            this.putValue(ItemAction.ACTION_COMMAND_KEY, "editCashflow");
            _tempStr = resHelper.getString("ActionEditCashflow.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionEditCashflow.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionEditCashflow.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionEditCashflow", "actionEditCashflow_actionPerformed", e);
        }
    }

    /**
     * output ActionCheck class
     */     
    protected class ActionCheck extends ItemAction {     
    
        public ActionCheck()
        {
            this(null);
        }

        public ActionCheck(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("alt G"));
            this.putValue(ItemAction.ACTION_COMMAND_KEY, "check");
            this.putValue(ItemAction.MNEMONIC_KEY, new Integer(KeyEvent.VK_G));
            _tempStr = resHelper.getString("ActionCheck.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCheck.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCheck.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionCheck", "actionCheck_actionPerformed", e);
        }
    }

    /**
     * output ActionAntiCheck class
     */     
    protected class ActionAntiCheck extends ItemAction {     
    
        public ActionAntiCheck()
        {
            this(null);
        }

        public ActionAntiCheck(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("alt shift C"));
            this.putValue(ItemAction.ACTION_COMMAND_KEY, "antiCheck");
            this.putValue(ItemAction.MNEMONIC_KEY, new Integer(KeyEvent.VK_C));
            _tempStr = resHelper.getString("ActionAntiCheck.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAntiCheck.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAntiCheck.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionAntiCheck", "actionAntiCheck_actionPerformed", e);
        }
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
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl U"));
            this.putValue(ItemAction.ACTION_COMMAND_KEY, "audit");
            this.putValue(ItemAction.MNEMONIC_KEY, new Integer(KeyEvent.VK_P));
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
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionAntiAudit class
     */     
    protected class ActionAntiAudit extends ItemAction {     
    
        public ActionAntiAudit()
        {
            this(null);
        }

        public ActionAntiAudit(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl shift U"));
            this.putValue(ItemAction.ACTION_COMMAND_KEY, "antiAudit");
            _tempStr = resHelper.getString("ActionAntiAudit.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAntiAudit.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAntiAudit.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionAntiAudit", "actionAntiAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionPost class
     */     
    protected class ActionPost extends ItemAction {     
    
        public ActionPost()
        {
            this(null);
        }

        public ActionPost(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("alt K"));
            this.putValue(ItemAction.ACTION_COMMAND_KEY, "post");
            this.putValue(ItemAction.MNEMONIC_KEY, new Integer(KeyEvent.VK_K));
            _tempStr = resHelper.getString("ActionPost.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionPost.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionPost.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionPost", "actionPost_actionPerformed", e);
        }
    }

    /**
     * output ActionAntiPost class
     */     
    protected class ActionAntiPost extends ItemAction {     
    
        public ActionAntiPost()
        {
            this(null);
        }

        public ActionAntiPost(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("alt N"));
            this.putValue(ItemAction.ACTION_COMMAND_KEY, "antiPost");
            _tempStr = resHelper.getString("ActionAntiPost.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAntiPost.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAntiPost.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionAntiPost", "actionAntiPost_actionPerformed", e);
        }
    }

    /**
     * output ActionShowQtyAmnt class
     */     
    protected class ActionShowQtyAmnt extends ItemAction {     
    
        public ActionShowQtyAmnt()
        {
            this(null);
        }

        public ActionShowQtyAmnt(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl Q"));
            this.putValue(ItemAction.ACTION_COMMAND_KEY, "showQtyAmnt");
            _tempStr = resHelper.getString("ActionShowQtyAmnt.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionShowQtyAmnt.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionShowQtyAmnt.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionShowQtyAmnt", "actionShowQtyAmnt_actionPerformed", e);
        }
    }

    /**
     * output ActionBgAudit class
     */     
    protected class ActionBgAudit extends ItemAction {     
    
        public ActionBgAudit()
        {
            this(null);
        }

        public ActionBgAudit(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            this.putValue(ItemAction.ACTION_COMMAND_KEY, "bgAudit");
            _tempStr = resHelper.getString("ActionBgAudit.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionBgAudit.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionBgAudit.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionBgAudit", "actionBgAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionAntiBgAudit class
     */     
    protected class ActionAntiBgAudit extends ItemAction {     
    
        public ActionAntiBgAudit()
        {
            this(null);
        }

        public ActionAntiBgAudit(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACTION_COMMAND_KEY, "antiBgAudit");
            _tempStr = resHelper.getString("ActionAntiBgAudit.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAntiBgAudit.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAntiBgAudit.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionAntiBgAudit", "actionAntiBgAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionOption class
     */     
    protected class ActionOption extends ItemAction {     
    
        public ActionOption()
        {
            this(null);
        }

        public ActionOption(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("F11"));
            this.putValue(ItemAction.ACTION_COMMAND_KEY, "option");
            _tempStr = resHelper.getString("ActionOption.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionOption.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionOption.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionOption", "actionOption_actionPerformed", e);
        }
    }

    /**
     * output ActionBookOption class
     */     
    protected class ActionBookOption extends ItemAction {     
    
        public ActionBookOption()
        {
            this(null);
        }

        public ActionBookOption(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionBookOption.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionBookOption.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionBookOption.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionBookOption", "actionBookOption_actionPerformed", e);
        }
    }

    /**
     * output ActionImport class
     */     
    protected class ActionImport extends ItemAction {     
    
        public ActionImport()
        {
            this(null);
        }

        public ActionImport(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl M"));
            this.putValue(ItemAction.ACTION_COMMAND_KEY, "import");
            _tempStr = resHelper.getString("ActionImport.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionImport.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionImport.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionImport", "actionImport_actionPerformed", e);
        }
    }

    /**
     * output ActionPrintOption class
     */     
    protected class ActionPrintOption extends ItemAction {     
    
        public ActionPrintOption()
        {
            this(null);
        }

        public ActionPrintOption(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl T"));
            _tempStr = resHelper.getString("ActionPrintOption.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionPrintOption.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionPrintOption.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionPrintOption", "actionPrintOption_actionPerformed", e);
        }
    }

    /**
     * output ActionColPrint class
     */     
    protected class ActionColPrint extends ItemAction {     
    
        public ActionColPrint()
        {
            this(null);
        }

        public ActionColPrint(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("ActionColPrint.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionColPrint.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionColPrint.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionColPrint", "actionColPrint_actionPerformed", e);
        }
    }

    /**
     * output ActionColPrintView class
     */     
    protected class ActionColPrintView extends ItemAction {     
    
        public ActionColPrintView()
        {
            this(null);
        }

        public ActionColPrintView(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl shift T"));
            _tempStr = resHelper.getString("ActionColPrintView.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionColPrintView.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionColPrintView.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionColPrintView", "actionColPrintView_actionPerformed", e);
        }
    }

    /**
     * output ActionAccountBalance class
     */     
    protected class ActionAccountBalance extends ItemAction {     
    
        public ActionAccountBalance()
        {
            this(null);
        }

        public ActionAccountBalance(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("ActionAccountBalance.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAccountBalance.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAccountBalance.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionAccountBalance", "actionAccountBalance_actionPerformed", e);
        }
    }

    /**
     * output ActionAssistant class
     */     
    protected class ActionAssistant extends ItemAction {     
    
        public ActionAssistant()
        {
            this(null);
        }

        public ActionAssistant(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("ActionAssistant.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAssistant.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAssistant.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionAssistant", "actionAssistant_actionPerformed", e);
        }
    }

    /**
     * output ActionHandCheck class
     */     
    protected class ActionHandCheck extends ItemAction {     
    
        public ActionHandCheck()
        {
            this(null);
        }

        public ActionHandCheck(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("alt V"));
            _tempStr = resHelper.getString("ActionHandCheck.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionHandCheck.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionHandCheck.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionHandCheck", "actionHandCheck_actionPerformed", e);
        }
    }

    /**
     * output ActionImportFile class
     */     
    protected class ActionImportFile extends ItemAction {     
    
        public ActionImportFile()
        {
            this(null);
        }

        public ActionImportFile(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl shift M"));
            _tempStr = resHelper.getString("ActionImportFile.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionImportFile.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionImportFile.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionImportFile", "actionImportFile_actionPerformed", e);
        }
    }

    /**
     * output ActionCrossPrint class
     */     
    protected class ActionCrossPrint extends ItemAction {     
    
        public ActionCrossPrint()
        {
            this(null);
        }

        public ActionCrossPrint(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl R"));
            _tempStr = resHelper.getString("ActionCrossPrint.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCrossPrint.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCrossPrint.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionCrossPrint", "actionCrossPrint_actionPerformed", e);
        }
    }

    /**
     * output ActionAdjunct class
     */     
    protected class ActionAdjunct extends ItemAction {     
    
        public ActionAdjunct()
        {
            this(null);
        }

        public ActionAdjunct(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("ActionAdjunct.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAdjunct.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAdjunct.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionAdjunct", "actionAdjunct_actionPerformed", e);
        }
    }

    /**
     * output ActionViewmbgCtrlBal class
     */     
    protected class ActionViewmbgCtrlBal extends ItemAction {     
    
        public ActionViewmbgCtrlBal()
        {
            this(null);
        }

        public ActionViewmbgCtrlBal(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl shift B"));
            this.putValue(ItemAction.ACTION_COMMAND_KEY, "viewmbgCtrlBal");
            _tempStr = resHelper.getString("ActionViewmbgCtrlBal.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionViewmbgCtrlBal.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionViewmbgCtrlBal.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionViewmbgCtrlBal", "actionViewmbgCtrlBal_actionPerformed", e);
        }
    }

    /**
     * output ActionVoucherPrintParameter class
     */     
    protected class ActionVoucherPrintParameter extends ItemAction {     
    
        public ActionVoucherPrintParameter()
        {
            this(null);
        }

        public ActionVoucherPrintParameter(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("ActionVoucherPrintParameter.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionVoucherPrintParameter.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionVoucherPrintParameter.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionVoucherPrintParameter", "actionVoucherPrintParameter_actionPerformed", e);
        }
    }

    /**
     * output ActionCrossPrintView class
     */     
    protected class ActionCrossPrintView extends ItemAction {     
    
        public ActionCrossPrintView()
        {
            this(null);
        }

        public ActionCrossPrintView(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl shift R"));
            _tempStr = resHelper.getString("ActionCrossPrintView.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCrossPrintView.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCrossPrintView.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionCrossPrintView", "actionCrossPrintView_actionPerformed", e);
        }
    }

    /**
     * output ActionImportBalance class
     */     
    protected class ActionImportBalance extends ItemAction {     
    
        public ActionImportBalance()
        {
            this(null);
        }

        public ActionImportBalance(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("ActionImportBalance.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionImportBalance.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionImportBalance.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionImportBalance", "actionImportBalance_actionPerformed", e);
        }
    }

    /**
     * output ActionSubmitPrint class
     */     
    protected class ActionSubmitPrint extends ItemAction {     
    
        public ActionSubmitPrint()
        {
            this(null);
        }

        public ActionSubmitPrint(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("ActionSubmitPrint.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionSubmitPrint.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionSubmitPrint.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionSubmitPrint", "actionSubmitPrint_actionPerformed", e);
        }
    }

    /**
     * output ActionEntryCellDown class
     */     
    protected class ActionEntryCellDown extends ItemAction {     
    
        public ActionEntryCellDown()
        {
            this(null);
        }

        public ActionEntryCellDown(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl 1"));
            this.putValue(ItemAction.MNEMONIC_KEY, new Integer(KeyEvent.VK_1));
            _tempStr = resHelper.getString("ActionEntryCellDown.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionEntryCellDown.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionEntryCellDown.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionEntryCellDown", "actionEntryCellDown_actionPerformed", e);
        }
    }

    /**
     * output ActionSubsidiaryLedger class
     */     
    protected class ActionSubsidiaryLedger extends ItemAction {     
    
        public ActionSubsidiaryLedger()
        {
            this(null);
        }

        public ActionSubsidiaryLedger(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("alt shift S"));
            _tempStr = resHelper.getString("ActionSubsidiaryLedger.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionSubsidiaryLedger.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionSubsidiaryLedger.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionSubsidiaryLedger", "actionSubsidiaryLedger_actionPerformed", e);
        }
    }

    /**
     * output ActionSubsidiaryLedgerAssist class
     */     
    protected class ActionSubsidiaryLedgerAssist extends ItemAction {     
    
        public ActionSubsidiaryLedgerAssist()
        {
            this(null);
        }

        public ActionSubsidiaryLedgerAssist(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("alt shift A"));
            _tempStr = resHelper.getString("ActionSubsidiaryLedgerAssist.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionSubsidiaryLedgerAssist.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionSubsidiaryLedgerAssist.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionSubsidiaryLedgerAssist", "actionSubsidiaryLedgerAssist_actionPerformed", e);
        }
    }

    /**
     * output ActionAsstCellDown class
     */     
    protected class ActionAsstCellDown extends ItemAction {     
    
        public ActionAsstCellDown()
        {
            this(null);
        }

        public ActionAsstCellDown(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionAsstCellDown.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAsstCellDown.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAsstCellDown.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionAsstCellDown", "actionAsstCellDown_actionPerformed", e);
        }
    }

    /**
     * output ActionUnit class
     */     
    protected class ActionUnit extends ItemAction {     
    
        public ActionUnit()
        {
            this(null);
        }

        public ActionUnit(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl B"));
            _tempStr = resHelper.getString("ActionUnit.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnit.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnit.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionUnit", "actionUnit_actionPerformed", e);
        }
    }

    /**
     * output ActionMgCtrl class
     */     
    protected class ActionMgCtrl extends ItemAction {     
    
        public ActionMgCtrl()
        {
            this(null);
        }

        public ActionMgCtrl(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl G"));
            _tempStr = resHelper.getString("ActionMgCtrl.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionMgCtrl.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionMgCtrl.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionMgCtrl", "actionMgCtrl_actionPerformed", e);
        }
    }

    /**
     * output ActionAdjustVoucher class
     */     
    protected class ActionAdjustVoucher extends ItemAction {     
    
        public ActionAdjustVoucher()
        {
            this(null);
        }

        public ActionAdjustVoucher(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("ActionAdjustVoucher.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAdjustVoucher.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAdjustVoucher.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionAdjustVoucher", "actionAdjustVoucher_actionPerformed", e);
        }
    }

    /**
     * output ActionLocalAudit class
     */     
    protected class ActionLocalAudit extends ItemAction {     
    
        public ActionLocalAudit()
        {
            this(null);
        }

        public ActionLocalAudit(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl L"));
            _tempStr = resHelper.getString("ActionLocalAudit.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionLocalAudit.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionLocalAudit.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionLocalAudit", "actionLocalAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionAutoVerify class
     */     
    protected class ActionAutoVerify extends ItemAction {     
    
        public ActionAutoVerify()
        {
            this(null);
        }

        public ActionAutoVerify(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionAutoVerify.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAutoVerify.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAutoVerify.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionAutoVerify", "actionAutoVerify_actionPerformed", e);
        }
    }

    /**
     * output ActionAuditNext class
     */     
    protected class ActionAuditNext extends ItemAction {     
    
        public ActionAuditNext()
        {
            this(null);
        }

        public ActionAuditNext(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl shift A"));
            _tempStr = resHelper.getString("ActionAuditNext.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAuditNext.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAuditNext.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionAuditNext", "actionAuditNext_actionPerformed", e);
        }
    }

    /**
     * output ActionImpExchangeRate class
     */     
    protected class ActionImpExchangeRate extends ItemAction {     
    
        public ActionImpExchangeRate()
        {
            this(null);
        }

        public ActionImpExchangeRate(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("ActionImpExchangeRate.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionImpExchangeRate.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionImpExchangeRate.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionImpExchangeRate", "actionImpExchangeRate_actionPerformed", e);
        }
    }

    /**
     * output ActionAuditBack class
     */     
    protected class ActionAuditBack extends ItemAction {     
    
        public ActionAuditBack()
        {
            this(null);
        }

        public ActionAuditBack(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("alt Z"));
            this.putValue(ItemAction.MNEMONIC_KEY, new Integer(KeyEvent.VK_Z));
            _tempStr = resHelper.getString("ActionAuditBack.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAuditBack.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAuditBack.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionAuditBack", "actionAuditBack_actionPerformed", e);
        }
    }

    /**
     * output ActionAuditMessage class
     */     
    protected class ActionAuditMessage extends ItemAction {     
    
        public ActionAuditMessage()
        {
            this(null);
        }

        public ActionAuditMessage(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("alt shift M"));
            this.putValue(ItemAction.MNEMONIC_KEY, new Integer(KeyEvent.VK_M));
            _tempStr = resHelper.getString("ActionAuditMessage.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAuditMessage.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAuditMessage.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionAuditMessage", "actionAuditMessage_actionPerformed", e);
        }
    }

    /**
     * output ActionAutoBalance class
     */     
    protected class ActionAutoBalance extends ItemAction {     
    
        public ActionAutoBalance()
        {
            this(null);
        }

        public ActionAutoBalance(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionAutoBalance.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAutoBalance.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAutoBalance.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_VoucherEditUI.this, "ActionAutoBalance", "actionAutoBalance_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.client", "Copy_VoucherEditUI");
    }
    /**
     * output isBindWorkFlow method
     */
    public boolean isBindWorkFlow()
    {
        return true;
    }




}