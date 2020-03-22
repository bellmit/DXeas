/**
 * output package name
 */
package com.kingdee.eas.custom.signwasthetable.client;

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
public abstract class AbstractContractEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractContractEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contFIUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontractType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontractStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbailAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcurrency;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contexchangeRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontractName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbailRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contversion;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCapitalLocalCurrency;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAmountLocalCurrency;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAmountOriCurrency;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCapitaloriCurrency;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contassureDept;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsignDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpartyC;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpartyB;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtPayment;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtPayment_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtPayInfo;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtPayInfo_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchangeDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperVersionID;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contisHistory;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpaymentRemove;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contisLastOverflow;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontractNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontractNature;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contassurer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpartyA;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkinitial;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcheckBeforeAcceptance;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbailAmtDays;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contremark;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsignTable;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtremark;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtFIUnit;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcontractType;
    protected com.kingdee.bos.ctrl.swing.KDComboBox contractStatus;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbailAmount;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcurrency;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtexchangeRate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcontractName;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbailRate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtversion;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtCapitalLocalCurrency;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtAmountLocalCurrency;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtAmountOriCurrency;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtCapitaloriCurrency;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtassureDept;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pksignDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpartyC;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpartyB;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkchangeDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtperVersionID;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtisHistory;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpaymentRemove;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtisLastOverflow;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcontractNum;
    protected com.kingdee.bos.ctrl.swing.KDComboBox contractNature;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtassurer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpartyA;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkcheckBeforeAcceptance;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbailAmtDays;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsignTable;
    protected javax.swing.JToolBar.Separator newSeparator1;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton Audit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton UnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnRefresh;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton toPayReq;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton cmChange;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton viewChange;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton upVersion;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnsetBailDays;
    protected com.kingdee.eas.custom.signwasthetable.ContractInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionCmChange actionCmChange = null;
    protected ActionUpVersion actionUpVersion = null;
    protected ActionToPayReq actionToPayReq = null;
    protected ActionViewHistory actionViewHistory = null;
    protected ActionInitial actionInitial = null;
    protected ActionRefresh actionRefresh = null;
    protected ActionSetBailDays actionSetBailDays = null;
    protected ActionOverPay actionOverPay = null;
    protected ActionOverView actionOverView = null;
    /**
     * output class constructor
     */
    public AbstractContractEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractContractEditUI.class.getName());
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
        this.actionAudit.setBindWorkFlow(true);
        this.actionAudit.setExtendProperty("canForewarn", "true");
        this.actionAudit.setExtendProperty("userDefined", "false");
        this.actionAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionUnAudit
        this.actionUnAudit = new ActionUnAudit(this);
        getActionManager().registerAction("actionUnAudit", actionUnAudit);
        this.actionUnAudit.setBindWorkFlow(true);
        this.actionUnAudit.setExtendProperty("canForewarn", "true");
        this.actionUnAudit.setExtendProperty("userDefined", "false");
        this.actionUnAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionCmChange
        this.actionCmChange = new ActionCmChange(this);
        getActionManager().registerAction("actionCmChange", actionCmChange);
        this.actionCmChange.setExtendProperty("canForewarn", "true");
        this.actionCmChange.setExtendProperty("userDefined", "false");
        this.actionCmChange.setExtendProperty("isObjectUpdateLock", "false");
         this.actionCmChange.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionCmChange.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionUpVersion
        this.actionUpVersion = new ActionUpVersion(this);
        getActionManager().registerAction("actionUpVersion", actionUpVersion);
        this.actionUpVersion.setExtendProperty("canForewarn", "true");
        this.actionUpVersion.setExtendProperty("userDefined", "false");
        this.actionUpVersion.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUpVersion.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUpVersion.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionToPayReq
        this.actionToPayReq = new ActionToPayReq(this);
        getActionManager().registerAction("actionToPayReq", actionToPayReq);
        this.actionToPayReq.setExtendProperty("canForewarn", "true");
        this.actionToPayReq.setExtendProperty("userDefined", "false");
        this.actionToPayReq.setExtendProperty("isObjectUpdateLock", "false");
         this.actionToPayReq.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionToPayReq.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionViewHistory
        this.actionViewHistory = new ActionViewHistory(this);
        getActionManager().registerAction("actionViewHistory", actionViewHistory);
        this.actionViewHistory.setExtendProperty("canForewarn", "true");
        this.actionViewHistory.setExtendProperty("userDefined", "false");
        this.actionViewHistory.setExtendProperty("isObjectUpdateLock", "false");
         this.actionViewHistory.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionViewHistory.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionInitial
        this.actionInitial = new ActionInitial(this);
        getActionManager().registerAction("actionInitial", actionInitial);
        this.actionInitial.setExtendProperty("canForewarn", "true");
        this.actionInitial.setExtendProperty("userDefined", "false");
        this.actionInitial.setExtendProperty("isObjectUpdateLock", "false");
         this.actionInitial.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionInitial.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionRefresh
        this.actionRefresh = new ActionRefresh(this);
        getActionManager().registerAction("actionRefresh", actionRefresh);
        this.actionRefresh.setExtendProperty("canForewarn", "true");
        this.actionRefresh.setExtendProperty("userDefined", "false");
        this.actionRefresh.setExtendProperty("isObjectUpdateLock", "false");
         this.actionRefresh.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionRefresh.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionSetBailDays
        this.actionSetBailDays = new ActionSetBailDays(this);
        getActionManager().registerAction("actionSetBailDays", actionSetBailDays);
        this.actionSetBailDays.setExtendProperty("canForewarn", "true");
        this.actionSetBailDays.setExtendProperty("userDefined", "false");
        this.actionSetBailDays.setExtendProperty("isObjectUpdateLock", "false");
         this.actionSetBailDays.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionSetBailDays.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionOverPay
        this.actionOverPay = new ActionOverPay(this);
        getActionManager().registerAction("actionOverPay", actionOverPay);
        this.actionOverPay.setExtendProperty("canForewarn", "true");
        this.actionOverPay.setExtendProperty("userDefined", "false");
        this.actionOverPay.setExtendProperty("isObjectUpdateLock", "false");
         this.actionOverPay.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionOverPay.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionOverView
        this.actionOverView = new ActionOverView(this);
        getActionManager().registerAction("actionOverView", actionOverView);
        this.actionOverView.setExtendProperty("canForewarn", "true");
        this.actionOverView.setExtendProperty("userDefined", "false");
        this.actionOverView.setExtendProperty("isObjectUpdateLock", "false");
         this.actionOverView.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionOverView.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contFIUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcontractType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcontractStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbailAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcurrency = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contexchangeRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcontractName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbailRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contversion = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCapitalLocalCurrency = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAmountLocalCurrency = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAmountOriCurrency = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCapitaloriCurrency = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contassureDept = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsignDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpartyC = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpartyB = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtPayment = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtPayInfo = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contchangeDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperVersionID = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contisHistory = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpaymentRemove = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contisLastOverflow = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcontractNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcontractNature = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contassurer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpartyA = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkinitial = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contcheckBeforeAcceptance = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbailAmtDays = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contremark = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsignTable = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtremark = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtFIUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcontractType = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.contractStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtbailAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtcurrency = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtexchangeRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcontractName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbailRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtversion = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtCapitalLocalCurrency = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtAmountLocalCurrency = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtAmountOriCurrency = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtCapitaloriCurrency = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtassureDept = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pksignDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtpartyC = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtpartyB = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkchangeDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtperVersionID = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtisHistory = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpaymentRemove = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtisLastOverflow = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcontractNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.contractNature = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtassurer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtpartyA = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkcheckBeforeAcceptance = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtbailAmtDays = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtsignTable = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.newSeparator1 = new javax.swing.JToolBar.Separator();
        this.Audit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.UnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnRefresh = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.toPayReq = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.cmChange = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.viewChange = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.upVersion = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnsetBailDays = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.contauditTime.setName("contauditTime");
        this.contFIUnit.setName("contFIUnit");
        this.contcontractType.setName("contcontractType");
        this.contcontractStatus.setName("contcontractStatus");
        this.contbailAmount.setName("contbailAmount");
        this.contcurrency.setName("contcurrency");
        this.contexchangeRate.setName("contexchangeRate");
        this.contcontractName.setName("contcontractName");
        this.contbailRate.setName("contbailRate");
        this.contversion.setName("contversion");
        this.contCapitalLocalCurrency.setName("contCapitalLocalCurrency");
        this.contAmountLocalCurrency.setName("contAmountLocalCurrency");
        this.contAmountOriCurrency.setName("contAmountOriCurrency");
        this.contCapitaloriCurrency.setName("contCapitaloriCurrency");
        this.contassureDept.setName("contassureDept");
        this.contsignDate.setName("contsignDate");
        this.contpartyC.setName("contpartyC");
        this.contpartyB.setName("contpartyB");
        this.kdtPayment.setName("kdtPayment");
        this.kdtPayInfo.setName("kdtPayInfo");
        this.contchangeDate.setName("contchangeDate");
        this.contperVersionID.setName("contperVersionID");
        this.contisHistory.setName("contisHistory");
        this.contpaymentRemove.setName("contpaymentRemove");
        this.contisLastOverflow.setName("contisLastOverflow");
        this.contcontractNum.setName("contcontractNum");
        this.contcontractNature.setName("contcontractNature");
        this.contassurer.setName("contassurer");
        this.contpartyA.setName("contpartyA");
        this.chkinitial.setName("chkinitial");
        this.contcheckBeforeAcceptance.setName("contcheckBeforeAcceptance");
        this.contbailAmtDays.setName("contbailAmtDays");
        this.contremark.setName("contremark");
        this.contsignTable.setName("contsignTable");
        this.txtremark.setName("txtremark");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.pkauditTime.setName("pkauditTime");
        this.prmtFIUnit.setName("prmtFIUnit");
        this.prmtcontractType.setName("prmtcontractType");
        this.contractStatus.setName("contractStatus");
        this.txtbailAmount.setName("txtbailAmount");
        this.prmtcurrency.setName("prmtcurrency");
        this.txtexchangeRate.setName("txtexchangeRate");
        this.txtcontractName.setName("txtcontractName");
        this.txtbailRate.setName("txtbailRate");
        this.txtversion.setName("txtversion");
        this.txtCapitalLocalCurrency.setName("txtCapitalLocalCurrency");
        this.txtAmountLocalCurrency.setName("txtAmountLocalCurrency");
        this.txtAmountOriCurrency.setName("txtAmountOriCurrency");
        this.txtCapitaloriCurrency.setName("txtCapitaloriCurrency");
        this.prmtassureDept.setName("prmtassureDept");
        this.pksignDate.setName("pksignDate");
        this.txtpartyC.setName("txtpartyC");
        this.prmtpartyB.setName("prmtpartyB");
        this.pkchangeDate.setName("pkchangeDate");
        this.txtperVersionID.setName("txtperVersionID");
        this.txtisHistory.setName("txtisHistory");
        this.txtpaymentRemove.setName("txtpaymentRemove");
        this.txtisLastOverflow.setName("txtisLastOverflow");
        this.txtcontractNum.setName("txtcontractNum");
        this.contractNature.setName("contractNature");
        this.prmtassurer.setName("prmtassurer");
        this.prmtpartyA.setName("prmtpartyA");
        this.pkcheckBeforeAcceptance.setName("pkcheckBeforeAcceptance");
        this.txtbailAmtDays.setName("txtbailAmtDays");
        this.prmtsignTable.setName("prmtsignTable");
        this.newSeparator1.setName("newSeparator1");
        this.Audit.setName("Audit");
        this.UnAudit.setName("UnAudit");
        this.btnRefresh.setName("btnRefresh");
        this.toPayReq.setName("toPayReq");
        this.cmChange.setName("cmChange");
        this.viewChange.setName("viewChange");
        this.upVersion.setName("upVersion");
        this.btnsetBailDays.setName("btnsetBailDays");
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
        // contLastUpdateTime		
        this.contLastUpdateTime.setBoundLabelText(resHelper.getString("contLastUpdateTime.boundLabelText"));		
        this.contLastUpdateTime.setBoundLabelLength(100);		
        this.contLastUpdateTime.setBoundLabelUnderline(true);		
        this.contLastUpdateTime.setEnabled(false);
        // contNumber		
        this.contNumber.setBoundLabelText(resHelper.getString("contNumber.boundLabelText"));		
        this.contNumber.setBoundLabelLength(100);		
        this.contNumber.setBoundLabelUnderline(true);
        // contBizDate		
        this.contBizDate.setBoundLabelText(resHelper.getString("contBizDate.boundLabelText"));		
        this.contBizDate.setBoundLabelLength(100);		
        this.contBizDate.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelAlignment(7);		
        this.contBizDate.setVisible(true);
        // contDescription		
        this.contDescription.setBoundLabelText(resHelper.getString("contDescription.boundLabelText"));		
        this.contDescription.setBoundLabelLength(100);		
        this.contDescription.setBoundLabelUnderline(true);		
        this.contDescription.setVisible(false);
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // contFIUnit		
        this.contFIUnit.setBoundLabelText(resHelper.getString("contFIUnit.boundLabelText"));		
        this.contFIUnit.setBoundLabelLength(100);		
        this.contFIUnit.setBoundLabelUnderline(true);		
        this.contFIUnit.setVisible(true);
        // contcontractType		
        this.contcontractType.setBoundLabelText(resHelper.getString("contcontractType.boundLabelText"));		
        this.contcontractType.setBoundLabelLength(100);		
        this.contcontractType.setBoundLabelUnderline(true);		
        this.contcontractType.setVisible(true);
        // contcontractStatus		
        this.contcontractStatus.setBoundLabelText(resHelper.getString("contcontractStatus.boundLabelText"));		
        this.contcontractStatus.setBoundLabelLength(100);		
        this.contcontractStatus.setBoundLabelUnderline(true);		
        this.contcontractStatus.setVisible(true);		
        this.contcontractStatus.setForeground(new java.awt.Color(0,0,0));
        // contbailAmount		
        this.contbailAmount.setBoundLabelText(resHelper.getString("contbailAmount.boundLabelText"));		
        this.contbailAmount.setBoundLabelLength(100);		
        this.contbailAmount.setBoundLabelUnderline(true);		
        this.contbailAmount.setVisible(true);
        // contcurrency		
        this.contcurrency.setBoundLabelText(resHelper.getString("contcurrency.boundLabelText"));		
        this.contcurrency.setBoundLabelLength(100);		
        this.contcurrency.setBoundLabelUnderline(true);		
        this.contcurrency.setVisible(true);
        // contexchangeRate		
        this.contexchangeRate.setBoundLabelText(resHelper.getString("contexchangeRate.boundLabelText"));		
        this.contexchangeRate.setBoundLabelLength(100);		
        this.contexchangeRate.setBoundLabelUnderline(true);		
        this.contexchangeRate.setVisible(true);		
        this.contexchangeRate.setForeground(new java.awt.Color(0,0,0));
        // contcontractName		
        this.contcontractName.setBoundLabelText(resHelper.getString("contcontractName.boundLabelText"));		
        this.contcontractName.setBoundLabelLength(100);		
        this.contcontractName.setBoundLabelUnderline(true);		
        this.contcontractName.setVisible(true);		
        this.contcontractName.setForeground(new java.awt.Color(0,0,0));
        // contbailRate		
        this.contbailRate.setBoundLabelText(resHelper.getString("contbailRate.boundLabelText"));		
        this.contbailRate.setBoundLabelLength(100);		
        this.contbailRate.setBoundLabelUnderline(true);		
        this.contbailRate.setVisible(true);		
        this.contbailRate.setForeground(new java.awt.Color(0,0,0));
        // contversion		
        this.contversion.setBoundLabelText(resHelper.getString("contversion.boundLabelText"));		
        this.contversion.setBoundLabelLength(100);		
        this.contversion.setBoundLabelUnderline(true);		
        this.contversion.setVisible(true);
        // contCapitalLocalCurrency		
        this.contCapitalLocalCurrency.setBoundLabelText(resHelper.getString("contCapitalLocalCurrency.boundLabelText"));		
        this.contCapitalLocalCurrency.setBoundLabelLength(100);		
        this.contCapitalLocalCurrency.setBoundLabelUnderline(true);		
        this.contCapitalLocalCurrency.setVisible(true);		
        this.contCapitalLocalCurrency.setForeground(new java.awt.Color(0,0,0));
        // contAmountLocalCurrency		
        this.contAmountLocalCurrency.setBoundLabelText(resHelper.getString("contAmountLocalCurrency.boundLabelText"));		
        this.contAmountLocalCurrency.setBoundLabelLength(100);		
        this.contAmountLocalCurrency.setBoundLabelUnderline(true);		
        this.contAmountLocalCurrency.setVisible(true);
        // contAmountOriCurrency		
        this.contAmountOriCurrency.setBoundLabelText(resHelper.getString("contAmountOriCurrency.boundLabelText"));		
        this.contAmountOriCurrency.setBoundLabelLength(100);		
        this.contAmountOriCurrency.setBoundLabelUnderline(true);		
        this.contAmountOriCurrency.setVisible(true);
        // contCapitaloriCurrency		
        this.contCapitaloriCurrency.setBoundLabelText(resHelper.getString("contCapitaloriCurrency.boundLabelText"));		
        this.contCapitaloriCurrency.setBoundLabelLength(100);		
        this.contCapitaloriCurrency.setBoundLabelUnderline(true);		
        this.contCapitaloriCurrency.setVisible(true);		
        this.contCapitaloriCurrency.setForeground(new java.awt.Color(0,0,0));
        // contassureDept		
        this.contassureDept.setBoundLabelText(resHelper.getString("contassureDept.boundLabelText"));		
        this.contassureDept.setBoundLabelLength(100);		
        this.contassureDept.setBoundLabelUnderline(true);		
        this.contassureDept.setVisible(true);
        // contsignDate		
        this.contsignDate.setBoundLabelText(resHelper.getString("contsignDate.boundLabelText"));		
        this.contsignDate.setBoundLabelLength(100);		
        this.contsignDate.setBoundLabelUnderline(true);		
        this.contsignDate.setVisible(true);
        // contpartyC		
        this.contpartyC.setBoundLabelText(resHelper.getString("contpartyC.boundLabelText"));		
        this.contpartyC.setBoundLabelLength(100);		
        this.contpartyC.setBoundLabelUnderline(true);		
        this.contpartyC.setVisible(true);
        // contpartyB		
        this.contpartyB.setBoundLabelText(resHelper.getString("contpartyB.boundLabelText"));		
        this.contpartyB.setBoundLabelLength(100);		
        this.contpartyB.setBoundLabelUnderline(true);		
        this.contpartyB.setVisible(true);		
        this.contpartyB.setForeground(new java.awt.Color(0,0,0));
        // kdtPayment
		String kdtPaymentStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol16\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol17\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol18\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"PhaseCoding\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"engneerProject\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"generalAssActType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"AdminOrg\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"isBailAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"payCondition\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"paymentRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"payAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"orgRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"requiredPayAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"unRequiredAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"payedAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"payingAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"payAmountLocal\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"reqPayAmountLocal\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"unReqAmtLocal\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /><t:Column t:key=\"payedAmountLocal\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"payingAmountLocal\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{PhaseCoding}</t:Cell><t:Cell>$Resource{engneerProject}</t:Cell><t:Cell>$Resource{generalAssActType}</t:Cell><t:Cell>$Resource{AdminOrg}</t:Cell><t:Cell>$Resource{isBailAmt}</t:Cell><t:Cell>$Resource{payCondition}</t:Cell><t:Cell>$Resource{paymentRate}</t:Cell><t:Cell>$Resource{payAmount}</t:Cell><t:Cell>$Resource{orgRate}</t:Cell><t:Cell>$Resource{requiredPayAmount}</t:Cell><t:Cell>$Resource{unRequiredAmt}</t:Cell><t:Cell>$Resource{payedAmount}</t:Cell><t:Cell>$Resource{payingAmount}</t:Cell><t:Cell>$Resource{payAmountLocal}</t:Cell><t:Cell>$Resource{reqPayAmountLocal}</t:Cell><t:Cell>$Resource{unReqAmtLocal}</t:Cell><t:Cell>$Resource{payedAmountLocal}</t:Cell><t:Cell>$Resource{payingAmountLocal}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtPayment.setFormatXml(resHelper.translateString("kdtPayment",kdtPaymentStrXML));
        this.kdtPayment.addKDTEditListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter() {
            public void editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) {
                try {
                    kdtPayment_editStop(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });

                this.kdtPayment.putBindContents("editData",new String[] {"seq","PhaseCoding","engneerProject","generalAssActType","AdminOrg","isBailAmt","payCondition","paymentRate","payAmount","orgRate","requiredPayAmount","unRequiredAmt","payedAmount","payingAmount","payAmountLocal","reqPayAmountLocal","unReqAmtLocal","payedAmountLocal","payingAmountLocal"});


        this.kdtPayment.checkParsed();
        KDFormattedTextField kdtPayment_PhaseCoding_TextField = new KDFormattedTextField();
        kdtPayment_PhaseCoding_TextField.setName("kdtPayment_PhaseCoding_TextField");
        kdtPayment_PhaseCoding_TextField.setVisible(true);
        kdtPayment_PhaseCoding_TextField.setEditable(true);
        kdtPayment_PhaseCoding_TextField.setHorizontalAlignment(2);
        kdtPayment_PhaseCoding_TextField.setDataType(0);
        KDTDefaultCellEditor kdtPayment_PhaseCoding_CellEditor = new KDTDefaultCellEditor(kdtPayment_PhaseCoding_TextField);
        this.kdtPayment.getColumn("PhaseCoding").setEditor(kdtPayment_PhaseCoding_CellEditor);
        final KDBizPromptBox kdtPayment_engneerProject_PromptBox = new KDBizPromptBox();
        kdtPayment_engneerProject_PromptBox.setQueryInfo("com.kingdee.eas.custom.signwasthetable.app.EngProjectQuery");
        kdtPayment_engneerProject_PromptBox.setVisible(true);
        kdtPayment_engneerProject_PromptBox.setEditable(true);
        kdtPayment_engneerProject_PromptBox.setDisplayFormat("$number$");
        kdtPayment_engneerProject_PromptBox.setEditFormat("$number$");
        kdtPayment_engneerProject_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtPayment_engneerProject_CellEditor = new KDTDefaultCellEditor(kdtPayment_engneerProject_PromptBox);
        this.kdtPayment.getColumn("engneerProject").setEditor(kdtPayment_engneerProject_CellEditor);
        ObjectValueRender kdtPayment_engneerProject_OVR = new ObjectValueRender();
        kdtPayment_engneerProject_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtPayment.getColumn("engneerProject").setRenderer(kdtPayment_engneerProject_OVR);
        			kdtPayment_engneerProject_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.custom.signwasthetable.client.EngProjectListUI kdtPayment_engneerProject_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtPayment_engneerProject_PromptBox_F7ListUI == null) {
					try {
						kdtPayment_engneerProject_PromptBox_F7ListUI = new com.kingdee.eas.custom.signwasthetable.client.EngProjectListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtPayment_engneerProject_PromptBox_F7ListUI));
					kdtPayment_engneerProject_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtPayment_engneerProject_PromptBox.setSelector(kdtPayment_engneerProject_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtPayment_generalAssActType_PromptBox = new KDBizPromptBox();
        kdtPayment_generalAssActType_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.auxacct.app.F7GeneralAsstActTypeQuery");
        kdtPayment_generalAssActType_PromptBox.setVisible(true);
        kdtPayment_generalAssActType_PromptBox.setEditable(true);
        kdtPayment_generalAssActType_PromptBox.setDisplayFormat("$number$");
        kdtPayment_generalAssActType_PromptBox.setEditFormat("$number$");
        kdtPayment_generalAssActType_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtPayment_generalAssActType_CellEditor = new KDTDefaultCellEditor(kdtPayment_generalAssActType_PromptBox);
        this.kdtPayment.getColumn("generalAssActType").setEditor(kdtPayment_generalAssActType_CellEditor);
        ObjectValueRender kdtPayment_generalAssActType_OVR = new ObjectValueRender();
        kdtPayment_generalAssActType_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtPayment.getColumn("generalAssActType").setRenderer(kdtPayment_generalAssActType_OVR);
        final KDBizPromptBox kdtPayment_AdminOrg_PromptBox = new KDBizPromptBox();
        kdtPayment_AdminOrg_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");
        kdtPayment_AdminOrg_PromptBox.setVisible(true);
        kdtPayment_AdminOrg_PromptBox.setEditable(true);
        kdtPayment_AdminOrg_PromptBox.setDisplayFormat("$number$");
        kdtPayment_AdminOrg_PromptBox.setEditFormat("$number$");
        kdtPayment_AdminOrg_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtPayment_AdminOrg_CellEditor = new KDTDefaultCellEditor(kdtPayment_AdminOrg_PromptBox);
        this.kdtPayment.getColumn("AdminOrg").setEditor(kdtPayment_AdminOrg_CellEditor);
        ObjectValueRender kdtPayment_AdminOrg_OVR = new ObjectValueRender();
        kdtPayment_AdminOrg_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtPayment.getColumn("AdminOrg").setRenderer(kdtPayment_AdminOrg_OVR);
        KDCheckBox kdtPayment_isBailAmt_CheckBox = new KDCheckBox();
        kdtPayment_isBailAmt_CheckBox.setName("kdtPayment_isBailAmt_CheckBox");
        KDTDefaultCellEditor kdtPayment_isBailAmt_CellEditor = new KDTDefaultCellEditor(kdtPayment_isBailAmt_CheckBox);
        this.kdtPayment.getColumn("isBailAmt").setEditor(kdtPayment_isBailAmt_CellEditor);
        KDTextField kdtPayment_payCondition_TextField = new KDTextField();
        kdtPayment_payCondition_TextField.setName("kdtPayment_payCondition_TextField");
        kdtPayment_payCondition_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtPayment_payCondition_CellEditor = new KDTDefaultCellEditor(kdtPayment_payCondition_TextField);
        this.kdtPayment.getColumn("payCondition").setEditor(kdtPayment_payCondition_CellEditor);
        KDFormattedTextField kdtPayment_paymentRate_TextField = new KDFormattedTextField();
        kdtPayment_paymentRate_TextField.setName("kdtPayment_paymentRate_TextField");
        kdtPayment_paymentRate_TextField.setVisible(true);
        kdtPayment_paymentRate_TextField.setEditable(true);
        kdtPayment_paymentRate_TextField.setHorizontalAlignment(2);
        kdtPayment_paymentRate_TextField.setDataType(1);
        	kdtPayment_paymentRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPayment_paymentRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPayment_paymentRate_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPayment_paymentRate_CellEditor = new KDTDefaultCellEditor(kdtPayment_paymentRate_TextField);
        this.kdtPayment.getColumn("paymentRate").setEditor(kdtPayment_paymentRate_CellEditor);
        KDFormattedTextField kdtPayment_payAmount_TextField = new KDFormattedTextField();
        kdtPayment_payAmount_TextField.setName("kdtPayment_payAmount_TextField");
        kdtPayment_payAmount_TextField.setVisible(true);
        kdtPayment_payAmount_TextField.setEditable(true);
        kdtPayment_payAmount_TextField.setHorizontalAlignment(2);
        kdtPayment_payAmount_TextField.setDataType(1);
        	kdtPayment_payAmount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPayment_payAmount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPayment_payAmount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPayment_payAmount_CellEditor = new KDTDefaultCellEditor(kdtPayment_payAmount_TextField);
        this.kdtPayment.getColumn("payAmount").setEditor(kdtPayment_payAmount_CellEditor);
        KDFormattedTextField kdtPayment_orgRate_TextField = new KDFormattedTextField();
        kdtPayment_orgRate_TextField.setName("kdtPayment_orgRate_TextField");
        kdtPayment_orgRate_TextField.setVisible(true);
        kdtPayment_orgRate_TextField.setEditable(true);
        kdtPayment_orgRate_TextField.setHorizontalAlignment(2);
        kdtPayment_orgRate_TextField.setDataType(1);
        	kdtPayment_orgRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPayment_orgRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPayment_orgRate_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPayment_orgRate_CellEditor = new KDTDefaultCellEditor(kdtPayment_orgRate_TextField);
        this.kdtPayment.getColumn("orgRate").setEditor(kdtPayment_orgRate_CellEditor);
        KDFormattedTextField kdtPayment_requiredPayAmount_TextField = new KDFormattedTextField();
        kdtPayment_requiredPayAmount_TextField.setName("kdtPayment_requiredPayAmount_TextField");
        kdtPayment_requiredPayAmount_TextField.setVisible(true);
        kdtPayment_requiredPayAmount_TextField.setEditable(true);
        kdtPayment_requiredPayAmount_TextField.setHorizontalAlignment(2);
        kdtPayment_requiredPayAmount_TextField.setDataType(1);
        	kdtPayment_requiredPayAmount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPayment_requiredPayAmount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPayment_requiredPayAmount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPayment_requiredPayAmount_CellEditor = new KDTDefaultCellEditor(kdtPayment_requiredPayAmount_TextField);
        this.kdtPayment.getColumn("requiredPayAmount").setEditor(kdtPayment_requiredPayAmount_CellEditor);
        KDFormattedTextField kdtPayment_unRequiredAmt_TextField = new KDFormattedTextField();
        kdtPayment_unRequiredAmt_TextField.setName("kdtPayment_unRequiredAmt_TextField");
        kdtPayment_unRequiredAmt_TextField.setVisible(true);
        kdtPayment_unRequiredAmt_TextField.setEditable(true);
        kdtPayment_unRequiredAmt_TextField.setHorizontalAlignment(2);
        kdtPayment_unRequiredAmt_TextField.setDataType(1);
        	kdtPayment_unRequiredAmt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPayment_unRequiredAmt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPayment_unRequiredAmt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPayment_unRequiredAmt_CellEditor = new KDTDefaultCellEditor(kdtPayment_unRequiredAmt_TextField);
        this.kdtPayment.getColumn("unRequiredAmt").setEditor(kdtPayment_unRequiredAmt_CellEditor);
        KDFormattedTextField kdtPayment_payedAmount_TextField = new KDFormattedTextField();
        kdtPayment_payedAmount_TextField.setName("kdtPayment_payedAmount_TextField");
        kdtPayment_payedAmount_TextField.setVisible(true);
        kdtPayment_payedAmount_TextField.setEditable(true);
        kdtPayment_payedAmount_TextField.setHorizontalAlignment(2);
        kdtPayment_payedAmount_TextField.setDataType(1);
        	kdtPayment_payedAmount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPayment_payedAmount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPayment_payedAmount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPayment_payedAmount_CellEditor = new KDTDefaultCellEditor(kdtPayment_payedAmount_TextField);
        this.kdtPayment.getColumn("payedAmount").setEditor(kdtPayment_payedAmount_CellEditor);
        KDFormattedTextField kdtPayment_payingAmount_TextField = new KDFormattedTextField();
        kdtPayment_payingAmount_TextField.setName("kdtPayment_payingAmount_TextField");
        kdtPayment_payingAmount_TextField.setVisible(true);
        kdtPayment_payingAmount_TextField.setEditable(true);
        kdtPayment_payingAmount_TextField.setHorizontalAlignment(2);
        kdtPayment_payingAmount_TextField.setDataType(1);
        	kdtPayment_payingAmount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPayment_payingAmount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPayment_payingAmount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPayment_payingAmount_CellEditor = new KDTDefaultCellEditor(kdtPayment_payingAmount_TextField);
        this.kdtPayment.getColumn("payingAmount").setEditor(kdtPayment_payingAmount_CellEditor);
        KDFormattedTextField kdtPayment_payAmountLocal_TextField = new KDFormattedTextField();
        kdtPayment_payAmountLocal_TextField.setName("kdtPayment_payAmountLocal_TextField");
        kdtPayment_payAmountLocal_TextField.setVisible(true);
        kdtPayment_payAmountLocal_TextField.setEditable(true);
        kdtPayment_payAmountLocal_TextField.setHorizontalAlignment(2);
        kdtPayment_payAmountLocal_TextField.setDataType(1);
        	kdtPayment_payAmountLocal_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPayment_payAmountLocal_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPayment_payAmountLocal_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPayment_payAmountLocal_CellEditor = new KDTDefaultCellEditor(kdtPayment_payAmountLocal_TextField);
        this.kdtPayment.getColumn("payAmountLocal").setEditor(kdtPayment_payAmountLocal_CellEditor);
        KDFormattedTextField kdtPayment_reqPayAmountLocal_TextField = new KDFormattedTextField();
        kdtPayment_reqPayAmountLocal_TextField.setName("kdtPayment_reqPayAmountLocal_TextField");
        kdtPayment_reqPayAmountLocal_TextField.setVisible(true);
        kdtPayment_reqPayAmountLocal_TextField.setEditable(true);
        kdtPayment_reqPayAmountLocal_TextField.setHorizontalAlignment(2);
        kdtPayment_reqPayAmountLocal_TextField.setDataType(1);
        	kdtPayment_reqPayAmountLocal_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPayment_reqPayAmountLocal_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPayment_reqPayAmountLocal_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPayment_reqPayAmountLocal_CellEditor = new KDTDefaultCellEditor(kdtPayment_reqPayAmountLocal_TextField);
        this.kdtPayment.getColumn("reqPayAmountLocal").setEditor(kdtPayment_reqPayAmountLocal_CellEditor);
        KDFormattedTextField kdtPayment_unReqAmtLocal_TextField = new KDFormattedTextField();
        kdtPayment_unReqAmtLocal_TextField.setName("kdtPayment_unReqAmtLocal_TextField");
        kdtPayment_unReqAmtLocal_TextField.setVisible(true);
        kdtPayment_unReqAmtLocal_TextField.setEditable(true);
        kdtPayment_unReqAmtLocal_TextField.setHorizontalAlignment(2);
        kdtPayment_unReqAmtLocal_TextField.setDataType(1);
        	kdtPayment_unReqAmtLocal_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPayment_unReqAmtLocal_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPayment_unReqAmtLocal_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPayment_unReqAmtLocal_CellEditor = new KDTDefaultCellEditor(kdtPayment_unReqAmtLocal_TextField);
        this.kdtPayment.getColumn("unReqAmtLocal").setEditor(kdtPayment_unReqAmtLocal_CellEditor);
        KDFormattedTextField kdtPayment_payedAmountLocal_TextField = new KDFormattedTextField();
        kdtPayment_payedAmountLocal_TextField.setName("kdtPayment_payedAmountLocal_TextField");
        kdtPayment_payedAmountLocal_TextField.setVisible(true);
        kdtPayment_payedAmountLocal_TextField.setEditable(true);
        kdtPayment_payedAmountLocal_TextField.setHorizontalAlignment(2);
        kdtPayment_payedAmountLocal_TextField.setDataType(1);
        	kdtPayment_payedAmountLocal_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPayment_payedAmountLocal_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPayment_payedAmountLocal_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPayment_payedAmountLocal_CellEditor = new KDTDefaultCellEditor(kdtPayment_payedAmountLocal_TextField);
        this.kdtPayment.getColumn("payedAmountLocal").setEditor(kdtPayment_payedAmountLocal_CellEditor);
        KDFormattedTextField kdtPayment_payingAmountLocal_TextField = new KDFormattedTextField();
        kdtPayment_payingAmountLocal_TextField.setName("kdtPayment_payingAmountLocal_TextField");
        kdtPayment_payingAmountLocal_TextField.setVisible(true);
        kdtPayment_payingAmountLocal_TextField.setEditable(true);
        kdtPayment_payingAmountLocal_TextField.setHorizontalAlignment(2);
        kdtPayment_payingAmountLocal_TextField.setDataType(1);
        	kdtPayment_payingAmountLocal_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPayment_payingAmountLocal_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPayment_payingAmountLocal_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPayment_payingAmountLocal_CellEditor = new KDTDefaultCellEditor(kdtPayment_payingAmountLocal_TextField);
        this.kdtPayment.getColumn("payingAmountLocal").setEditor(kdtPayment_payingAmountLocal_CellEditor);
        // kdtPayInfo
		String kdtPayInfoStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol1\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"payBillId\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"payAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"payAmountLocal\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"payDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"payReqBillID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"payReqBillreqAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"phaseCoding\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"PhaseID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"unOverFlow\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{payBillId}</t:Cell><t:Cell>$Resource{payAmount}</t:Cell><t:Cell>$Resource{payAmountLocal}</t:Cell><t:Cell>$Resource{payDate}</t:Cell><t:Cell>$Resource{payReqBillID}</t:Cell><t:Cell>$Resource{payReqBillreqAmt}</t:Cell><t:Cell>$Resource{phaseCoding}</t:Cell><t:Cell>$Resource{PhaseID}</t:Cell><t:Cell>$Resource{unOverFlow}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtPayInfo.setFormatXml(resHelper.translateString("kdtPayInfo",kdtPayInfoStrXML));		
        this.kdtPayInfo.setVisible(false);

                this.kdtPayInfo.putBindContents("editData",new String[] {"PayInfo.payBillId","PayInfo.payAmount","PayInfo.payAmountLocal","PayInfo.payDate","PayInfo.payReqBillID","PayInfo.payReqBillreqAmt","PayInfo.phaseCoding","PayInfo.PhaseID","PayInfo.unOverFlow"});


        this.kdtPayInfo.checkParsed();
        KDTextField kdtPayInfo_payBillId_TextField = new KDTextField();
        kdtPayInfo_payBillId_TextField.setName("kdtPayInfo_payBillId_TextField");
        kdtPayInfo_payBillId_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtPayInfo_payBillId_CellEditor = new KDTDefaultCellEditor(kdtPayInfo_payBillId_TextField);
        this.kdtPayInfo.getColumn("payBillId").setEditor(kdtPayInfo_payBillId_CellEditor);
        KDFormattedTextField kdtPayInfo_payAmount_TextField = new KDFormattedTextField();
        kdtPayInfo_payAmount_TextField.setName("kdtPayInfo_payAmount_TextField");
        kdtPayInfo_payAmount_TextField.setVisible(true);
        kdtPayInfo_payAmount_TextField.setEditable(true);
        kdtPayInfo_payAmount_TextField.setHorizontalAlignment(2);
        kdtPayInfo_payAmount_TextField.setDataType(1);
        	kdtPayInfo_payAmount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPayInfo_payAmount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPayInfo_payAmount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPayInfo_payAmount_CellEditor = new KDTDefaultCellEditor(kdtPayInfo_payAmount_TextField);
        this.kdtPayInfo.getColumn("payAmount").setEditor(kdtPayInfo_payAmount_CellEditor);
        KDFormattedTextField kdtPayInfo_payAmountLocal_TextField = new KDFormattedTextField();
        kdtPayInfo_payAmountLocal_TextField.setName("kdtPayInfo_payAmountLocal_TextField");
        kdtPayInfo_payAmountLocal_TextField.setVisible(true);
        kdtPayInfo_payAmountLocal_TextField.setEditable(true);
        kdtPayInfo_payAmountLocal_TextField.setHorizontalAlignment(2);
        kdtPayInfo_payAmountLocal_TextField.setDataType(1);
        	kdtPayInfo_payAmountLocal_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPayInfo_payAmountLocal_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPayInfo_payAmountLocal_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPayInfo_payAmountLocal_CellEditor = new KDTDefaultCellEditor(kdtPayInfo_payAmountLocal_TextField);
        this.kdtPayInfo.getColumn("payAmountLocal").setEditor(kdtPayInfo_payAmountLocal_CellEditor);
        KDDatePicker kdtPayInfo_payDate_DatePicker = new KDDatePicker();
        kdtPayInfo_payDate_DatePicker.setName("kdtPayInfo_payDate_DatePicker");
        kdtPayInfo_payDate_DatePicker.setVisible(true);
        kdtPayInfo_payDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtPayInfo_payDate_CellEditor = new KDTDefaultCellEditor(kdtPayInfo_payDate_DatePicker);
        this.kdtPayInfo.getColumn("payDate").setEditor(kdtPayInfo_payDate_CellEditor);
        KDTextField kdtPayInfo_payReqBillID_TextField = new KDTextField();
        kdtPayInfo_payReqBillID_TextField.setName("kdtPayInfo_payReqBillID_TextField");
        kdtPayInfo_payReqBillID_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtPayInfo_payReqBillID_CellEditor = new KDTDefaultCellEditor(kdtPayInfo_payReqBillID_TextField);
        this.kdtPayInfo.getColumn("payReqBillID").setEditor(kdtPayInfo_payReqBillID_CellEditor);
        KDFormattedTextField kdtPayInfo_payReqBillreqAmt_TextField = new KDFormattedTextField();
        kdtPayInfo_payReqBillreqAmt_TextField.setName("kdtPayInfo_payReqBillreqAmt_TextField");
        kdtPayInfo_payReqBillreqAmt_TextField.setVisible(true);
        kdtPayInfo_payReqBillreqAmt_TextField.setEditable(true);
        kdtPayInfo_payReqBillreqAmt_TextField.setHorizontalAlignment(2);
        kdtPayInfo_payReqBillreqAmt_TextField.setDataType(1);
        	kdtPayInfo_payReqBillreqAmt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPayInfo_payReqBillreqAmt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPayInfo_payReqBillreqAmt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPayInfo_payReqBillreqAmt_CellEditor = new KDTDefaultCellEditor(kdtPayInfo_payReqBillreqAmt_TextField);
        this.kdtPayInfo.getColumn("payReqBillreqAmt").setEditor(kdtPayInfo_payReqBillreqAmt_CellEditor);
        KDFormattedTextField kdtPayInfo_phaseCoding_TextField = new KDFormattedTextField();
        kdtPayInfo_phaseCoding_TextField.setName("kdtPayInfo_phaseCoding_TextField");
        kdtPayInfo_phaseCoding_TextField.setVisible(true);
        kdtPayInfo_phaseCoding_TextField.setEditable(true);
        kdtPayInfo_phaseCoding_TextField.setHorizontalAlignment(2);
        kdtPayInfo_phaseCoding_TextField.setDataType(0);
        KDTDefaultCellEditor kdtPayInfo_phaseCoding_CellEditor = new KDTDefaultCellEditor(kdtPayInfo_phaseCoding_TextField);
        this.kdtPayInfo.getColumn("phaseCoding").setEditor(kdtPayInfo_phaseCoding_CellEditor);
        KDTextField kdtPayInfo_PhaseID_TextField = new KDTextField();
        kdtPayInfo_PhaseID_TextField.setName("kdtPayInfo_PhaseID_TextField");
        kdtPayInfo_PhaseID_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtPayInfo_PhaseID_CellEditor = new KDTDefaultCellEditor(kdtPayInfo_PhaseID_TextField);
        this.kdtPayInfo.getColumn("PhaseID").setEditor(kdtPayInfo_PhaseID_CellEditor);
        KDFormattedTextField kdtPayInfo_unOverFlow_TextField = new KDFormattedTextField();
        kdtPayInfo_unOverFlow_TextField.setName("kdtPayInfo_unOverFlow_TextField");
        kdtPayInfo_unOverFlow_TextField.setVisible(true);
        kdtPayInfo_unOverFlow_TextField.setEditable(true);
        kdtPayInfo_unOverFlow_TextField.setHorizontalAlignment(2);
        kdtPayInfo_unOverFlow_TextField.setDataType(1);
        	kdtPayInfo_unOverFlow_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPayInfo_unOverFlow_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPayInfo_unOverFlow_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPayInfo_unOverFlow_CellEditor = new KDTDefaultCellEditor(kdtPayInfo_unOverFlow_TextField);
        this.kdtPayInfo.getColumn("unOverFlow").setEditor(kdtPayInfo_unOverFlow_CellEditor);
        // contchangeDate		
        this.contchangeDate.setBoundLabelText(resHelper.getString("contchangeDate.boundLabelText"));		
        this.contchangeDate.setBoundLabelLength(100);		
        this.contchangeDate.setBoundLabelUnderline(true);		
        this.contchangeDate.setVisible(false);
        // contperVersionID		
        this.contperVersionID.setBoundLabelText(resHelper.getString("contperVersionID.boundLabelText"));		
        this.contperVersionID.setBoundLabelLength(100);		
        this.contperVersionID.setBoundLabelUnderline(true);		
        this.contperVersionID.setVisible(false);
        // contisHistory		
        this.contisHistory.setBoundLabelText(resHelper.getString("contisHistory.boundLabelText"));		
        this.contisHistory.setBoundLabelLength(100);		
        this.contisHistory.setBoundLabelUnderline(true);		
        this.contisHistory.setVisible(false);
        // contpaymentRemove		
        this.contpaymentRemove.setBoundLabelText(resHelper.getString("contpaymentRemove.boundLabelText"));		
        this.contpaymentRemove.setBoundLabelLength(100);		
        this.contpaymentRemove.setBoundLabelUnderline(true);		
        this.contpaymentRemove.setVisible(false);
        // contisLastOverflow		
        this.contisLastOverflow.setBoundLabelText(resHelper.getString("contisLastOverflow.boundLabelText"));		
        this.contisLastOverflow.setBoundLabelLength(100);		
        this.contisLastOverflow.setBoundLabelUnderline(true);		
        this.contisLastOverflow.setVisible(false);
        // contcontractNum		
        this.contcontractNum.setBoundLabelText(resHelper.getString("contcontractNum.boundLabelText"));		
        this.contcontractNum.setBoundLabelLength(100);		
        this.contcontractNum.setBoundLabelUnderline(true);		
        this.contcontractNum.setVisible(false);
        // contcontractNature		
        this.contcontractNature.setBoundLabelText(resHelper.getString("contcontractNature.boundLabelText"));		
        this.contcontractNature.setBoundLabelLength(100);		
        this.contcontractNature.setBoundLabelUnderline(true);		
        this.contcontractNature.setVisible(true);
        this.contcontractNature.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                try {
                    contcontractNature_mouseClicke(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });
        // contassurer		
        this.contassurer.setBoundLabelText(resHelper.getString("contassurer.boundLabelText"));		
        this.contassurer.setBoundLabelLength(100);		
        this.contassurer.setBoundLabelUnderline(true);		
        this.contassurer.setVisible(true);
        // contpartyA		
        this.contpartyA.setBoundLabelText(resHelper.getString("contpartyA.boundLabelText"));		
        this.contpartyA.setBoundLabelLength(100);		
        this.contpartyA.setBoundLabelUnderline(true);		
        this.contpartyA.setVisible(true);
        // chkinitial		
        this.chkinitial.setText(resHelper.getString("chkinitial.text"));		
        this.chkinitial.setHorizontalAlignment(2);
        this.chkinitial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                try {
                    chkinitial_mouseClicke(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });
        // contcheckBeforeAcceptance		
        this.contcheckBeforeAcceptance.setBoundLabelText(resHelper.getString("contcheckBeforeAcceptance.boundLabelText"));		
        this.contcheckBeforeAcceptance.setBoundLabelLength(100);		
        this.contcheckBeforeAcceptance.setBoundLabelUnderline(true);		
        this.contcheckBeforeAcceptance.setVisible(true);
        // contbailAmtDays		
        this.contbailAmtDays.setBoundLabelText(resHelper.getString("contbailAmtDays.boundLabelText"));		
        this.contbailAmtDays.setBoundLabelLength(100);		
        this.contbailAmtDays.setBoundLabelUnderline(true);		
        this.contbailAmtDays.setVisible(true);
        // contremark		
        this.contremark.setBoundLabelText(resHelper.getString("contremark.boundLabelText"));		
        this.contremark.setBoundLabelLength(400);		
        this.contremark.setVisible(true);
        // contsignTable		
        this.contsignTable.setBoundLabelText(resHelper.getString("contsignTable.boundLabelText"));		
        this.contsignTable.setBoundLabelLength(100);		
        this.contsignTable.setBoundLabelUnderline(true);		
        this.contsignTable.setVisible(true);
        // txtremark		
        this.txtremark.setRequired(true);		
        this.txtremark.setMaxLength(2000);
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
        // pkBizDate		
        this.pkBizDate.setEnabled(true);		
        this.pkBizDate.setRequired(true);
        // txtDescription		
        this.txtDescription.setMaxLength(80);		
        this.txtDescription.setVisible(false);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // prmtFIUnit		
        this.prmtFIUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtFIUnit.setEditable(true);		
        this.prmtFIUnit.setDisplayFormat("$name$");		
        this.prmtFIUnit.setEditFormat("$number$");		
        this.prmtFIUnit.setCommitFormat("$number$");		
        this.prmtFIUnit.setRequired(false);		
        this.prmtFIUnit.setEnabled(false);
        // prmtcontractType		
        this.prmtcontractType.setQueryInfo("com.kingdee.eas.custom.signwasthetable.app.ContractTypeQuery");		
        this.prmtcontractType.setEditable(true);		
        this.prmtcontractType.setDisplayFormat("$name$");		
        this.prmtcontractType.setEditFormat("$number$");		
        this.prmtcontractType.setCommitFormat("$number$");		
        this.prmtcontractType.setRequired(true);
        this.prmtcontractType.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtcontractType_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // contractStatus		
        this.contractStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.signwasthetable.billStatus").toArray());		
        this.contractStatus.setRequired(true);		
        this.contractStatus.setEnabled(false);
        // txtbailAmount		
        this.txtbailAmount.setHorizontalAlignment(2);		
        this.txtbailAmount.setDataType(1);		
        this.txtbailAmount.setSupportedEmpty(true);		
        this.txtbailAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbailAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbailAmount.setPrecision(2);		
        this.txtbailAmount.setRequired(false);
        this.txtbailAmount.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtbailAmount_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // prmtcurrency		
        this.prmtcurrency.setQueryInfo("com.kingdee.eas.basedata.assistant.app.CurrencyQuery");		
        this.prmtcurrency.setEditable(true);		
        this.prmtcurrency.setDisplayFormat("$name$");		
        this.prmtcurrency.setEditFormat("$number$");		
        this.prmtcurrency.setCommitFormat("$number$");		
        this.prmtcurrency.setRequired(true);
        this.prmtcurrency.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtcurrency_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtexchangeRate		
        this.txtexchangeRate.setHorizontalAlignment(2);		
        this.txtexchangeRate.setDataType(1);		
        this.txtexchangeRate.setSupportedEmpty(true);		
        this.txtexchangeRate.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtexchangeRate.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtexchangeRate.setPrecision(10);		
        this.txtexchangeRate.setRequired(true);
        this.txtexchangeRate.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtexchangeRate_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtcontractName		
        this.txtcontractName.setHorizontalAlignment(2);		
        this.txtcontractName.setMaxLength(100);		
        this.txtcontractName.setRequired(true);
        // txtbailRate		
        this.txtbailRate.setHorizontalAlignment(2);		
        this.txtbailRate.setDataType(1);		
        this.txtbailRate.setSupportedEmpty(true);		
        this.txtbailRate.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbailRate.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbailRate.setPrecision(10);		
        this.txtbailRate.setRequired(false);
        this.txtbailRate.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtbailRate_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtversion		
        this.txtversion.setHorizontalAlignment(2);		
        this.txtversion.setMaxLength(100);		
        this.txtversion.setRequired(false);		
        this.txtversion.setEnabled(false);
        // txtCapitalLocalCurrency		
        this.txtCapitalLocalCurrency.setHorizontalAlignment(2);		
        this.txtCapitalLocalCurrency.setMaxLength(100);		
        this.txtCapitalLocalCurrency.setRequired(false);		
        this.txtCapitalLocalCurrency.setEnabled(false);
        // txtAmountLocalCurrency		
        this.txtAmountLocalCurrency.setHorizontalAlignment(2);		
        this.txtAmountLocalCurrency.setDataType(1);		
        this.txtAmountLocalCurrency.setSupportedEmpty(true);		
        this.txtAmountLocalCurrency.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtAmountLocalCurrency.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtAmountLocalCurrency.setPrecision(2);		
        this.txtAmountLocalCurrency.setRequired(false);		
        this.txtAmountLocalCurrency.setEnabled(false);
        // txtAmountOriCurrency		
        this.txtAmountOriCurrency.setHorizontalAlignment(2);		
        this.txtAmountOriCurrency.setDataType(1);		
        this.txtAmountOriCurrency.setSupportedEmpty(true);		
        this.txtAmountOriCurrency.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtAmountOriCurrency.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtAmountOriCurrency.setPrecision(2);		
        this.txtAmountOriCurrency.setRequired(false);
        this.txtAmountOriCurrency.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtAmountOriCurrency_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtCapitaloriCurrency		
        this.txtCapitaloriCurrency.setHorizontalAlignment(2);		
        this.txtCapitaloriCurrency.setMaxLength(100);		
        this.txtCapitaloriCurrency.setRequired(false);		
        this.txtCapitaloriCurrency.setEnabled(false);
        // prmtassureDept		
        this.prmtassureDept.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtassureDept.setEditable(true);		
        this.prmtassureDept.setDisplayFormat("$name$");		
        this.prmtassureDept.setEditFormat("$number$");		
        this.prmtassureDept.setCommitFormat("$number$");		
        this.prmtassureDept.setRequired(true);
        this.prmtassureDept.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtassureDept_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // pksignDate		
        this.pksignDate.setRequired(true);
        // txtpartyC		
        this.txtpartyC.setHorizontalAlignment(2);		
        this.txtpartyC.setMaxLength(100);		
        this.txtpartyC.setRequired(false);
        // prmtpartyB		
        this.prmtpartyB.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.PSupplierQuery");		
        this.prmtpartyB.setEditable(true);		
        this.prmtpartyB.setDisplayFormat("$name$");		
        this.prmtpartyB.setEditFormat("$number$");		
        this.prmtpartyB.setCommitFormat("$number$");		
        this.prmtpartyB.setRequired(true);
        // pkchangeDate		
        this.pkchangeDate.setVisible(false);		
        this.pkchangeDate.setRequired(false);
        // txtperVersionID		
        this.txtperVersionID.setVisible(false);		
        this.txtperVersionID.setHorizontalAlignment(2);		
        this.txtperVersionID.setMaxLength(100);		
        this.txtperVersionID.setRequired(false);
        // txtisHistory		
        this.txtisHistory.setVisible(false);		
        this.txtisHistory.setHorizontalAlignment(2);		
        this.txtisHistory.setDataType(0);		
        this.txtisHistory.setSupportedEmpty(true);		
        this.txtisHistory.setRequired(false);
        // txtpaymentRemove		
        this.txtpaymentRemove.setVisible(false);		
        this.txtpaymentRemove.setHorizontalAlignment(2);		
        this.txtpaymentRemove.setDataType(0);		
        this.txtpaymentRemove.setSupportedEmpty(true);		
        this.txtpaymentRemove.setRequired(false);
        // txtisLastOverflow		
        this.txtisLastOverflow.setVisible(false);		
        this.txtisLastOverflow.setHorizontalAlignment(2);		
        this.txtisLastOverflow.setDataType(0);		
        this.txtisLastOverflow.setSupportedEmpty(true);		
        this.txtisLastOverflow.setRequired(false);
        // txtcontractNum		
        this.txtcontractNum.setVisible(false);		
        this.txtcontractNum.setHorizontalAlignment(2);		
        this.txtcontractNum.setMaxLength(100);		
        this.txtcontractNum.setRequired(false);
        // contractNature		
        this.contractNature.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.signwasthetable.contractNature").toArray());		
        this.contractNature.setRequired(true);
        this.contractNature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    contractNature_actionPerforme(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // prmtassurer		
        this.prmtassurer.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtassurer.setEditable(true);		
        this.prmtassurer.setDisplayFormat("$name$");		
        this.prmtassurer.setEditFormat("$number$");		
        this.prmtassurer.setCommitFormat("$number$");		
        this.prmtassurer.setRequired(true);
        this.prmtassurer.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtassurer_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // prmtpartyA		
        this.prmtpartyA.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtpartyA.setEditable(true);		
        this.prmtpartyA.setDisplayFormat("$name$");		
        this.prmtpartyA.setEditFormat("$number$");		
        this.prmtpartyA.setCommitFormat("$number$");		
        this.prmtpartyA.setRequired(true);
        this.prmtpartyA.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtpartyA_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // pkcheckBeforeAcceptance		
        this.pkcheckBeforeAcceptance.setRequired(false);		
        this.pkcheckBeforeAcceptance.setEnabled(false);
        // txtbailAmtDays		
        this.txtbailAmtDays.setHorizontalAlignment(2);		
        this.txtbailAmtDays.setDataType(0);		
        this.txtbailAmtDays.setSupportedEmpty(true);		
        this.txtbailAmtDays.setRequired(false);		
        this.txtbailAmtDays.setEnabled(false);
        // prmtsignTable		
        this.prmtsignTable.setQueryInfo("com.kingdee.eas.custom.signwasthetable.app.SignWasTheTableQuery");		
        this.prmtsignTable.setEditable(true);		
        this.prmtsignTable.setDisplayFormat("$number$");		
        this.prmtsignTable.setEditFormat("$number$");		
        this.prmtsignTable.setCommitFormat("$number$");		
        this.prmtsignTable.setRequired(false);
        // newSeparator1		
        this.newSeparator1.setOrientation(1);
        // Audit
        this.Audit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.Audit.setText(resHelper.getString("Audit.text"));
        // UnAudit
        this.UnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.UnAudit.setText(resHelper.getString("UnAudit.text"));
        // btnRefresh
        this.btnRefresh.setAction((IItemAction)ActionProxyFactory.getProxy(actionRefresh, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnRefresh.setText(resHelper.getString("btnRefresh.text"));
        // toPayReq
        this.toPayReq.setAction((IItemAction)ActionProxyFactory.getProxy(actionToPayReq, new Class[] { IItemAction.class }, getServiceContext()));		
        this.toPayReq.setText(resHelper.getString("toPayReq.text"));
        // cmChange
        this.cmChange.setAction((IItemAction)ActionProxyFactory.getProxy(actionCmChange, new Class[] { IItemAction.class }, getServiceContext()));		
        this.cmChange.setText(resHelper.getString("cmChange.text"));
        // viewChange
        this.viewChange.setAction((IItemAction)ActionProxyFactory.getProxy(actionUpVersion, new Class[] { IItemAction.class }, getServiceContext()));		
        this.viewChange.setText(resHelper.getString("viewChange.text"));
        // upVersion
        this.upVersion.setAction((IItemAction)ActionProxyFactory.getProxy(actionViewHistory, new Class[] { IItemAction.class }, getServiceContext()));		
        this.upVersion.setText(resHelper.getString("upVersion.text"));
        // btnsetBailDays
        this.btnsetBailDays.setAction((IItemAction)ActionProxyFactory.getProxy(actionSetBailDays, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnsetBailDays.setText(resHelper.getString("btnsetBailDays.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {kdtPayInfo,pkauditTime,prmtFIUnit,prmtcontractType,contractStatus,txtbailAmount,prmtcurrency,txtexchangeRate,txtcontractName,txtbailRate,txtversion,txtCapitalLocalCurrency,txtAmountLocalCurrency,txtAmountOriCurrency,txtCapitaloriCurrency,prmtassureDept,pksignDate,txtpartyC,prmtpartyB,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,pkchangeDate,txtperVersionID,txtisHistory,txtpaymentRemove,txtisLastOverflow,txtcontractNum,contractNature,prmtassurer,prmtpartyA,chkinitial,pkcheckBeforeAcceptance,txtbailAmtDays,txtremark,prmtsignTable,kdtPayment}));
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
        this.setBounds(new Rectangle(0, 0, 976, 605));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 976, 605));
        contCreator.setBounds(new Rectangle(701, 563, 260, 19));
        this.add(contCreator, new KDLayout.Constraints(701, 563, 260, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contCreateTime.setBounds(new Rectangle(701, 534, 260, 19));
        this.add(contCreateTime, new KDLayout.Constraints(701, 534, 260, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(365, 534, 260, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(365, 534, 260, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(365, 563, 260, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(365, 563, 260, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contNumber.setBounds(new Rectangle(22, 15, 260, 19));
        this.add(contNumber, new KDLayout.Constraints(22, 15, 260, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(701, 15, 260, 19));
        this.add(contBizDate, new KDLayout.Constraints(701, 15, 260, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contDescription.setBounds(new Rectangle(918, 324, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(918, 324, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(22, 534, 260, 19));
        this.add(contAuditor, new KDLayout.Constraints(22, 534, 260, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(22, 563, 260, 19));
        this.add(contauditTime, new KDLayout.Constraints(22, 563, 260, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contFIUnit.setBounds(new Rectangle(22, 43, 260, 19));
        this.add(contFIUnit, new KDLayout.Constraints(22, 43, 260, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcontractType.setBounds(new Rectangle(701, 43, 260, 19));
        this.add(contcontractType, new KDLayout.Constraints(701, 43, 260, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcontractStatus.setBounds(new Rectangle(365, 43, 260, 19));
        this.add(contcontractStatus, new KDLayout.Constraints(365, 43, 260, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbailAmount.setBounds(new Rectangle(22, 211, 260, 19));
        this.add(contbailAmount, new KDLayout.Constraints(22, 211, 260, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcurrency.setBounds(new Rectangle(22, 127, 260, 19));
        this.add(contcurrency, new KDLayout.Constraints(22, 127, 260, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contexchangeRate.setBounds(new Rectangle(365, 127, 260, 19));
        this.add(contexchangeRate, new KDLayout.Constraints(365, 127, 260, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcontractName.setBounds(new Rectangle(365, 15, 260, 19));
        this.add(contcontractName, new KDLayout.Constraints(365, 15, 260, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbailRate.setBounds(new Rectangle(365, 211, 260, 19));
        this.add(contbailRate, new KDLayout.Constraints(365, 211, 260, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contversion.setBounds(new Rectangle(701, 155, 260, 19));
        this.add(contversion, new KDLayout.Constraints(701, 155, 260, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contCapitalLocalCurrency.setBounds(new Rectangle(365, 183, 260, 19));
        this.add(contCapitalLocalCurrency, new KDLayout.Constraints(365, 183, 260, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAmountLocalCurrency.setBounds(new Rectangle(22, 183, 260, 19));
        this.add(contAmountLocalCurrency, new KDLayout.Constraints(22, 183, 260, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAmountOriCurrency.setBounds(new Rectangle(22, 155, 260, 19));
        this.add(contAmountOriCurrency, new KDLayout.Constraints(22, 155, 260, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCapitaloriCurrency.setBounds(new Rectangle(365, 155, 260, 19));
        this.add(contCapitaloriCurrency, new KDLayout.Constraints(365, 155, 260, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contassureDept.setBounds(new Rectangle(701, 71, 260, 19));
        this.add(contassureDept, new KDLayout.Constraints(701, 71, 260, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contsignDate.setBounds(new Rectangle(701, 127, 260, 19));
        this.add(contsignDate, new KDLayout.Constraints(701, 127, 260, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contpartyC.setBounds(new Rectangle(701, 99, 260, 19));
        this.add(contpartyC, new KDLayout.Constraints(701, 99, 260, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contpartyB.setBounds(new Rectangle(365, 99, 260, 19));
        this.add(contpartyB, new KDLayout.Constraints(365, 99, 260, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtPayment.setBounds(new Rectangle(22, 362, 939, 162));
        kdtPayment_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtPayment,new com.kingdee.eas.custom.signwasthetable.ContractPaymentInfo(),null,false);
        this.add(kdtPayment_detailPanel, new KDLayout.Constraints(22, 362, 939, 162, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kdtPayInfo.setBounds(new Rectangle(977, 1231, 37, 13));
        kdtPayInfo_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtPayInfo,new com.kingdee.eas.custom.signwasthetable.ContractPaymentPayInfoInfo(),null,false);
        this.add(kdtPayInfo_detailPanel, new KDLayout.Constraints(977, 1231, 37, 13, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contchangeDate.setBounds(new Rectangle(917, 304, 270, 19));
        this.add(contchangeDate, new KDLayout.Constraints(917, 304, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contperVersionID.setBounds(new Rectangle(921, 388, 270, 19));
        this.add(contperVersionID, new KDLayout.Constraints(921, 388, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contisHistory.setBounds(new Rectangle(920, 344, 270, 19));
        this.add(contisHistory, new KDLayout.Constraints(920, 344, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contpaymentRemove.setBounds(new Rectangle(928, 429, 270, 19));
        this.add(contpaymentRemove, new KDLayout.Constraints(928, 429, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contisLastOverflow.setBounds(new Rectangle(925, 409, 270, 19));
        this.add(contisLastOverflow, new KDLayout.Constraints(925, 409, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contcontractNum.setBounds(new Rectangle(921, 366, 270, 19));
        this.add(contcontractNum, new KDLayout.Constraints(921, 366, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contcontractNature.setBounds(new Rectangle(22, 71, 260, 19));
        this.add(contcontractNature, new KDLayout.Constraints(22, 71, 260, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contassurer.setBounds(new Rectangle(365, 71, 260, 19));
        this.add(contassurer, new KDLayout.Constraints(365, 71, 260, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpartyA.setBounds(new Rectangle(22, 99, 260, 19));
        this.add(contpartyA, new KDLayout.Constraints(22, 99, 260, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkinitial.setBounds(new Rectangle(701, 211, 260, 19));
        this.add(chkinitial, new KDLayout.Constraints(701, 211, 260, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcheckBeforeAcceptance.setBounds(new Rectangle(365, 242, 260, 19));
        this.add(contcheckBeforeAcceptance, new KDLayout.Constraints(365, 242, 260, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbailAmtDays.setBounds(new Rectangle(23, 242, 260, 19));
        this.add(contbailAmtDays, new KDLayout.Constraints(23, 242, 260, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contremark.setBounds(new Rectangle(23, 275, 363, 19));
        this.add(contremark, new KDLayout.Constraints(23, 275, 363, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsignTable.setBounds(new Rectangle(701, 183, 260, 19));
        this.add(contsignTable, new KDLayout.Constraints(701, 183, 260, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        txtremark.setBounds(new Rectangle(22, 297, 939, 54));
        this.add(txtremark, new KDLayout.Constraints(22, 297, 939, 54, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //contBizDate
        contBizDate.setBoundEditor(pkBizDate);
        //contDescription
        contDescription.setBoundEditor(txtDescription);
        //contAuditor
        contAuditor.setBoundEditor(prmtAuditor);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contFIUnit
        contFIUnit.setBoundEditor(prmtFIUnit);
        //contcontractType
        contcontractType.setBoundEditor(prmtcontractType);
        //contcontractStatus
        contcontractStatus.setBoundEditor(contractStatus);
        //contbailAmount
        contbailAmount.setBoundEditor(txtbailAmount);
        //contcurrency
        contcurrency.setBoundEditor(prmtcurrency);
        //contexchangeRate
        contexchangeRate.setBoundEditor(txtexchangeRate);
        //contcontractName
        contcontractName.setBoundEditor(txtcontractName);
        //contbailRate
        contbailRate.setBoundEditor(txtbailRate);
        //contversion
        contversion.setBoundEditor(txtversion);
        //contCapitalLocalCurrency
        contCapitalLocalCurrency.setBoundEditor(txtCapitalLocalCurrency);
        //contAmountLocalCurrency
        contAmountLocalCurrency.setBoundEditor(txtAmountLocalCurrency);
        //contAmountOriCurrency
        contAmountOriCurrency.setBoundEditor(txtAmountOriCurrency);
        //contCapitaloriCurrency
        contCapitaloriCurrency.setBoundEditor(txtCapitaloriCurrency);
        //contassureDept
        contassureDept.setBoundEditor(prmtassureDept);
        //contsignDate
        contsignDate.setBoundEditor(pksignDate);
        //contpartyC
        contpartyC.setBoundEditor(txtpartyC);
        //contpartyB
        contpartyB.setBoundEditor(prmtpartyB);
        //contchangeDate
        contchangeDate.setBoundEditor(pkchangeDate);
        //contperVersionID
        contperVersionID.setBoundEditor(txtperVersionID);
        //contisHistory
        contisHistory.setBoundEditor(txtisHistory);
        //contpaymentRemove
        contpaymentRemove.setBoundEditor(txtpaymentRemove);
        //contisLastOverflow
        contisLastOverflow.setBoundEditor(txtisLastOverflow);
        //contcontractNum
        contcontractNum.setBoundEditor(txtcontractNum);
        //contcontractNature
        contcontractNature.setBoundEditor(contractNature);
        //contassurer
        contassurer.setBoundEditor(prmtassurer);
        //contpartyA
        contpartyA.setBoundEditor(prmtpartyA);
        //contcheckBeforeAcceptance
        contcheckBeforeAcceptance.setBoundEditor(pkcheckBeforeAcceptance);
        //contbailAmtDays
        contbailAmtDays.setBoundEditor(txtbailAmtDays);
        //contsignTable
        contsignTable.setBoundEditor(prmtsignTable);

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
        this.toolBar.add(btnSave);
        this.toolBar.add(btnEdit);
        this.toolBar.add(btnRemove);
        this.toolBar.add(btnCopy);
        this.toolBar.add(newSeparator1);
        this.toolBar.add(btnSubmit);
        this.toolBar.add(Audit);
        this.toolBar.add(UnAudit);
        this.toolBar.add(btnRefresh);
        this.toolBar.add(kDSeparatorCloud);
        this.toolBar.add(btnCreateFrom);
        this.toolBar.add(btnCreateTo);
        this.toolBar.add(toPayReq);
        this.toolBar.add(separatorFW1);
        this.toolBar.add(btnPageSetup);
        this.toolBar.add(btnPrint);
        this.toolBar.add(btnPrintPreview);
        this.toolBar.add(btnAttachment);
        this.toolBar.add(separatorFW2);
        this.toolBar.add(cmChange);
        this.toolBar.add(viewChange);
        this.toolBar.add(upVersion);
        this.toolBar.add(separatorFW3);
        this.toolBar.add(btnFirst);
        this.toolBar.add(btnPre);
        this.toolBar.add(btnNext);
        this.toolBar.add(btnLast);
        this.toolBar.add(btnTraceUp);
        this.toolBar.add(btnTraceDown);
        this.toolBar.add(btnSignature);
        this.toolBar.add(btnViewSignature);
        this.toolBar.add(separatorFW4);
        this.toolBar.add(btnNumberSign);
        this.toolBar.add(btnWorkFlowG);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnNextPerson);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(separatorFW7);
        this.toolBar.add(btnCopyFrom);
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
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnCloud);
        this.toolBar.add(btnReset);
        this.toolBar.add(btnXunTong);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);
        this.toolBar.add(btnsetBailDays);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("Payment.seq", int.class, this.kdtPayment, "seq.text");
		dataBinder.registerBinding("Payment", com.kingdee.eas.custom.signwasthetable.ContractPaymentInfo.class, this.kdtPayment, "userObject");
		dataBinder.registerBinding("Payment.PhaseCoding", int.class, this.kdtPayment, "PhaseCoding.text");
		dataBinder.registerBinding("Payment.AdminOrg", java.lang.Object.class, this.kdtPayment, "AdminOrg.text");
		dataBinder.registerBinding("Payment.payCondition", String.class, this.kdtPayment, "payCondition.text");
		dataBinder.registerBinding("Payment.paymentRate", java.math.BigDecimal.class, this.kdtPayment, "paymentRate.text");
		dataBinder.registerBinding("Payment.payAmount", java.math.BigDecimal.class, this.kdtPayment, "payAmount.text");
		dataBinder.registerBinding("Payment.payAmountLocal", java.math.BigDecimal.class, this.kdtPayment, "payAmountLocal.text");
		dataBinder.registerBinding("Payment.requiredPayAmount", java.math.BigDecimal.class, this.kdtPayment, "requiredPayAmount.text");
		dataBinder.registerBinding("Payment.reqPayAmountLocal", java.math.BigDecimal.class, this.kdtPayment, "reqPayAmountLocal.text");
		dataBinder.registerBinding("Payment.payedAmount", java.math.BigDecimal.class, this.kdtPayment, "payedAmount.text");
		dataBinder.registerBinding("Payment.payedAmountLocal", java.math.BigDecimal.class, this.kdtPayment, "payedAmountLocal.text");
		dataBinder.registerBinding("Payment.payingAmount", java.math.BigDecimal.class, this.kdtPayment, "payingAmount.text");
		dataBinder.registerBinding("Payment.payingAmountLocal", java.math.BigDecimal.class, this.kdtPayment, "payingAmountLocal.text");
		dataBinder.registerBinding("Payment.unRequiredAmt", java.math.BigDecimal.class, this.kdtPayment, "unRequiredAmt.text");
		dataBinder.registerBinding("Payment.unReqAmtLocal", java.math.BigDecimal.class, this.kdtPayment, "unReqAmtLocal.text");
		dataBinder.registerBinding("Payment.engneerProject", java.lang.Object.class, this.kdtPayment, "engneerProject.text");
		dataBinder.registerBinding("Payment.isBailAmt", boolean.class, this.kdtPayment, "isBailAmt.text");
		dataBinder.registerBinding("Payment.orgRate", java.math.BigDecimal.class, this.kdtPayment, "orgRate.text");
		dataBinder.registerBinding("Payment.generalAssActType", java.lang.Object.class, this.kdtPayment, "generalAssActType.text");
		dataBinder.registerBinding("Payment.PayInfo", com.kingdee.eas.custom.signwasthetable.ContractPaymentPayInfoInfo.class, this.kdtPayInfo, "userObject");
		dataBinder.registerBinding("Payment.PayInfo.payBillId", String.class, this.kdtPayInfo, "payBillId.text");
		dataBinder.registerBinding("Payment.PayInfo.payAmount", java.math.BigDecimal.class, this.kdtPayInfo, "payAmount.text");
		dataBinder.registerBinding("Payment.PayInfo.payAmountLocal", java.math.BigDecimal.class, this.kdtPayInfo, "payAmountLocal.text");
		dataBinder.registerBinding("Payment.PayInfo.payDate", java.util.Date.class, this.kdtPayInfo, "payDate.text");
		dataBinder.registerBinding("Payment.PayInfo.payReqBillID", String.class, this.kdtPayInfo, "payReqBillID.text");
		dataBinder.registerBinding("Payment.PayInfo.payReqBillreqAmt", java.math.BigDecimal.class, this.kdtPayInfo, "payReqBillreqAmt.text");
		dataBinder.registerBinding("Payment.PayInfo.phaseCoding", int.class, this.kdtPayInfo, "phaseCoding.text");
		dataBinder.registerBinding("Payment.PayInfo.PhaseID", String.class, this.kdtPayInfo, "PhaseID.text");
		dataBinder.registerBinding("Payment.PayInfo.unOverFlow", java.math.BigDecimal.class, this.kdtPayInfo, "unOverFlow.text");
		dataBinder.registerBinding("initial", boolean.class, this.chkinitial, "selected");
		dataBinder.registerBinding("remark", String.class, this.txtremark, "text");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("FIUnit", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtFIUnit, "data");
		dataBinder.registerBinding("contractType", com.kingdee.eas.custom.signwasthetable.ContractTypeInfo.class, this.prmtcontractType, "data");
		dataBinder.registerBinding("contractStatus", com.kingdee.eas.custom.signwasthetable.billStatus.class, this.contractStatus, "selectedItem");
		dataBinder.registerBinding("bailAmount", java.math.BigDecimal.class, this.txtbailAmount, "value");
		dataBinder.registerBinding("currency", com.kingdee.eas.basedata.assistant.CurrencyInfo.class, this.prmtcurrency, "data");
		dataBinder.registerBinding("exchangeRate", java.math.BigDecimal.class, this.txtexchangeRate, "value");
		dataBinder.registerBinding("contractName", String.class, this.txtcontractName, "text");
		dataBinder.registerBinding("bailRate", java.math.BigDecimal.class, this.txtbailRate, "value");
		dataBinder.registerBinding("version", String.class, this.txtversion, "text");
		dataBinder.registerBinding("CapitalLocalCurrency", String.class, this.txtCapitalLocalCurrency, "text");
		dataBinder.registerBinding("AmountLocalCurrency", java.math.BigDecimal.class, this.txtAmountLocalCurrency, "value");
		dataBinder.registerBinding("AmountOriCurrency", java.math.BigDecimal.class, this.txtAmountOriCurrency, "value");
		dataBinder.registerBinding("CapitaloriCurrency", String.class, this.txtCapitaloriCurrency, "text");
		dataBinder.registerBinding("assureDept", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtassureDept, "data");
		dataBinder.registerBinding("signDate", java.util.Date.class, this.pksignDate, "value");
		dataBinder.registerBinding("partyC", String.class, this.txtpartyC, "text");
		dataBinder.registerBinding("partyB", com.kingdee.eas.basedata.master.cssp.SupplierInfo.class, this.prmtpartyB, "data");
		dataBinder.registerBinding("changeDate", java.util.Date.class, this.pkchangeDate, "value");
		dataBinder.registerBinding("perVersionID", String.class, this.txtperVersionID, "text");
		dataBinder.registerBinding("isHistory", int.class, this.txtisHistory, "value");
		dataBinder.registerBinding("paymentRemove", int.class, this.txtpaymentRemove, "value");
		dataBinder.registerBinding("isLastOverflow", int.class, this.txtisLastOverflow, "value");
		dataBinder.registerBinding("contractNum", String.class, this.txtcontractNum, "text");
		dataBinder.registerBinding("contractNature", com.kingdee.eas.custom.signwasthetable.contractNature.class, this.contractNature, "selectedItem");
		dataBinder.registerBinding("assurer", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtassurer, "data");
		dataBinder.registerBinding("partyA", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtpartyA, "data");
		dataBinder.registerBinding("checkBeforeAcceptance", java.util.Date.class, this.pkcheckBeforeAcceptance, "value");
		dataBinder.registerBinding("bailAmtDays", int.class, this.txtbailAmtDays, "value");
		dataBinder.registerBinding("signTable", com.kingdee.eas.custom.signwasthetable.SignWasTheTableInfo.class, this.prmtsignTable, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.signwasthetable.app.ContractEditUIHandler";
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
        this.kdtPayInfo.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.signwasthetable.ContractInfo)ov;
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
		getValidateHelper().registerBindProperty("Payment.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Payment", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Payment.PhaseCoding", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Payment.AdminOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Payment.payCondition", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Payment.paymentRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Payment.payAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Payment.payAmountLocal", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Payment.requiredPayAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Payment.reqPayAmountLocal", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Payment.payedAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Payment.payedAmountLocal", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Payment.payingAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Payment.payingAmountLocal", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Payment.unRequiredAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Payment.unReqAmtLocal", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Payment.engneerProject", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Payment.isBailAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Payment.orgRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Payment.generalAssActType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Payment.PayInfo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Payment.PayInfo.payBillId", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Payment.PayInfo.payAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Payment.PayInfo.payAmountLocal", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Payment.PayInfo.payDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Payment.PayInfo.payReqBillID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Payment.PayInfo.payReqBillreqAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Payment.PayInfo.phaseCoding", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Payment.PayInfo.PhaseID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Payment.PayInfo.unOverFlow", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("initial", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FIUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contractType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contractStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bailAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("currency", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("exchangeRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contractName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bailRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("version", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CapitalLocalCurrency", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AmountLocalCurrency", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AmountOriCurrency", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CapitaloriCurrency", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("assureDept", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("signDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("partyC", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("partyB", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("changeDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("perVersionID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isHistory", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("paymentRemove", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isLastOverflow", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contractNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contractNature", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("assurer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("partyA", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("checkBeforeAcceptance", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bailAmtDays", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("signTable", ValidateHelper.ON_SAVE);    		
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
     * output kdtPayment_editStop method
     */
    protected void kdtPayment_editStop(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
    }

    /**
     * output contcontractNature_mouseClicke method
     */
    protected void contcontractNature_mouseClicke(java.awt.event.MouseEvent e) throws Exception
    {
    }

    /**
     * output chkinitial_mouseClicke method
     */
    protected void chkinitial_mouseClicke(java.awt.event.MouseEvent e) throws Exception
    {
    }

    /**
     * output prmtcontractType_dataChange method
     */
    protected void prmtcontractType_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output txtbailAmount_dataChange method
     */
    protected void txtbailAmount_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output prmtcurrency_dataChange method
     */
    protected void prmtcurrency_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output txtexchangeRate_dataChange method
     */
    protected void txtexchangeRate_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output txtbailRate_dataChange method
     */
    protected void txtbailRate_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output txtAmountOriCurrency_dataChange method
     */
    protected void txtAmountOriCurrency_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output prmtassureDept_dataChange method
     */
    protected void prmtassureDept_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output contractNature_actionPerforme method
     */
    protected void contractNature_actionPerforme(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output prmtassurer_dataChange method
     */
    protected void prmtassurer_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output prmtpartyA_dataChange method
     */
    protected void prmtpartyA_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
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
    	sic.add(new SelectorItemInfo("Payment.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Payment.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("Payment.PhaseCoding"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Payment.AdminOrg.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Payment.AdminOrg.id"));
			sic.add(new SelectorItemInfo("Payment.AdminOrg.name"));
        	sic.add(new SelectorItemInfo("Payment.AdminOrg.number"));
		}
    	sic.add(new SelectorItemInfo("Payment.payCondition"));
    	sic.add(new SelectorItemInfo("Payment.paymentRate"));
    	sic.add(new SelectorItemInfo("Payment.payAmount"));
    	sic.add(new SelectorItemInfo("Payment.payAmountLocal"));
    	sic.add(new SelectorItemInfo("Payment.requiredPayAmount"));
    	sic.add(new SelectorItemInfo("Payment.reqPayAmountLocal"));
    	sic.add(new SelectorItemInfo("Payment.payedAmount"));
    	sic.add(new SelectorItemInfo("Payment.payedAmountLocal"));
    	sic.add(new SelectorItemInfo("Payment.payingAmount"));
    	sic.add(new SelectorItemInfo("Payment.payingAmountLocal"));
    	sic.add(new SelectorItemInfo("Payment.unRequiredAmt"));
    	sic.add(new SelectorItemInfo("Payment.unReqAmtLocal"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Payment.engneerProject.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Payment.engneerProject.id"));
			sic.add(new SelectorItemInfo("Payment.engneerProject.name"));
        	sic.add(new SelectorItemInfo("Payment.engneerProject.number"));
		}
    	sic.add(new SelectorItemInfo("Payment.isBailAmt"));
    	sic.add(new SelectorItemInfo("Payment.orgRate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Payment.generalAssActType.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Payment.generalAssActType.id"));
			sic.add(new SelectorItemInfo("Payment.generalAssActType.name"));
        	sic.add(new SelectorItemInfo("Payment.generalAssActType.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Payment.PayInfo.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Payment.PayInfo.id"));
		}
    	sic.add(new SelectorItemInfo("Payment.PayInfo.payBillId"));
    	sic.add(new SelectorItemInfo("Payment.PayInfo.payAmount"));
    	sic.add(new SelectorItemInfo("Payment.PayInfo.payAmountLocal"));
    	sic.add(new SelectorItemInfo("Payment.PayInfo.payDate"));
    	sic.add(new SelectorItemInfo("Payment.PayInfo.payReqBillID"));
    	sic.add(new SelectorItemInfo("Payment.PayInfo.payReqBillreqAmt"));
    	sic.add(new SelectorItemInfo("Payment.PayInfo.phaseCoding"));
    	sic.add(new SelectorItemInfo("Payment.PayInfo.PhaseID"));
    	sic.add(new SelectorItemInfo("Payment.PayInfo.unOverFlow"));
        sic.add(new SelectorItemInfo("initial"));
        sic.add(new SelectorItemInfo("remark"));
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
        sic.add(new SelectorItemInfo("bizDate"));
        sic.add(new SelectorItemInfo("description"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("auditor.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("auditor.id"));
        	sic.add(new SelectorItemInfo("auditor.number"));
        	sic.add(new SelectorItemInfo("auditor.name"));
		}
        sic.add(new SelectorItemInfo("auditTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FIUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("FIUnit.id"));
        	sic.add(new SelectorItemInfo("FIUnit.number"));
        	sic.add(new SelectorItemInfo("FIUnit.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("contractType.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("contractType.id"));
        	sic.add(new SelectorItemInfo("contractType.number"));
        	sic.add(new SelectorItemInfo("contractType.name"));
		}
        sic.add(new SelectorItemInfo("contractStatus"));
        sic.add(new SelectorItemInfo("bailAmount"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("currency.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("currency.id"));
        	sic.add(new SelectorItemInfo("currency.number"));
        	sic.add(new SelectorItemInfo("currency.name"));
		}
        sic.add(new SelectorItemInfo("exchangeRate"));
        sic.add(new SelectorItemInfo("contractName"));
        sic.add(new SelectorItemInfo("bailRate"));
        sic.add(new SelectorItemInfo("version"));
        sic.add(new SelectorItemInfo("CapitalLocalCurrency"));
        sic.add(new SelectorItemInfo("AmountLocalCurrency"));
        sic.add(new SelectorItemInfo("AmountOriCurrency"));
        sic.add(new SelectorItemInfo("CapitaloriCurrency"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("assureDept.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("assureDept.id"));
        	sic.add(new SelectorItemInfo("assureDept.number"));
        	sic.add(new SelectorItemInfo("assureDept.name"));
		}
        sic.add(new SelectorItemInfo("signDate"));
        sic.add(new SelectorItemInfo("partyC"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("partyB.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("partyB.id"));
        	sic.add(new SelectorItemInfo("partyB.number"));
        	sic.add(new SelectorItemInfo("partyB.name"));
		}
        sic.add(new SelectorItemInfo("changeDate"));
        sic.add(new SelectorItemInfo("perVersionID"));
        sic.add(new SelectorItemInfo("isHistory"));
        sic.add(new SelectorItemInfo("paymentRemove"));
        sic.add(new SelectorItemInfo("isLastOverflow"));
        sic.add(new SelectorItemInfo("contractNum"));
        sic.add(new SelectorItemInfo("contractNature"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("assurer.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("assurer.id"));
        	sic.add(new SelectorItemInfo("assurer.number"));
        	sic.add(new SelectorItemInfo("assurer.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("partyA.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("partyA.id"));
        	sic.add(new SelectorItemInfo("partyA.number"));
        	sic.add(new SelectorItemInfo("partyA.name"));
		}
        sic.add(new SelectorItemInfo("checkBeforeAcceptance"));
        sic.add(new SelectorItemInfo("bailAmtDays"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("signTable.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("signTable.id"));
        	sic.add(new SelectorItemInfo("signTable.number"));
		}
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
        com.kingdee.eas.custom.signwasthetable.ContractFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.signwasthetable.ContractFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionCmChange_actionPerformed method
     */
    public void actionCmChange_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.signwasthetable.ContractFactory.getRemoteInstance().cmChange(editData);
    }
    	

    /**
     * output actionUpVersion_actionPerformed method
     */
    public void actionUpVersion_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.signwasthetable.ContractFactory.getRemoteInstance().upVersion(editData);
    }
    	

    /**
     * output actionToPayReq_actionPerformed method
     */
    public void actionToPayReq_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.signwasthetable.ContractFactory.getRemoteInstance().toPayReq(editData);
    }
    	

    /**
     * output actionViewHistory_actionPerformed method
     */
    public void actionViewHistory_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.signwasthetable.ContractFactory.getRemoteInstance().viewHistory(editData);
    }
    	

    /**
     * output actionInitial_actionPerformed method
     */
    public void actionInitial_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.signwasthetable.ContractFactory.getRemoteInstance().initial(editData);
    }
    	

    /**
     * output actionRefresh_actionPerformed method
     */
    public void actionRefresh_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.signwasthetable.ContractFactory.getRemoteInstance().refresh(editData);
    }
    	

    /**
     * output actionSetBailDays_actionPerformed method
     */
    public void actionSetBailDays_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.signwasthetable.ContractFactory.getRemoteInstance().setBailDays(editData);
    }
    	

    /**
     * output actionOverPay_actionPerformed method
     */
    public void actionOverPay_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.signwasthetable.ContractFactory.getRemoteInstance().overPay(editData);
    }
    	

    /**
     * output actionOverView_actionPerformed method
     */
    public void actionOverView_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.signwasthetable.ContractFactory.getRemoteInstance().overView(editData);
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
	public RequestContext prepareActionCmChange(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionCmChange() {
    	return false;
    }
	public RequestContext prepareActionUpVersion(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionUpVersion() {
    	return false;
    }
	public RequestContext prepareActionToPayReq(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionToPayReq() {
    	return false;
    }
	public RequestContext prepareActionViewHistory(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionViewHistory() {
    	return false;
    }
	public RequestContext prepareActionInitial(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionInitial() {
    	return false;
    }
	public RequestContext prepareActionRefresh(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionRefresh() {
    	return false;
    }
	public RequestContext prepareActionSetBailDays(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionSetBailDays() {
    	return false;
    }
	public RequestContext prepareActionOverPay(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionOverPay() {
    	return false;
    }
	public RequestContext prepareActionOverView(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionOverView() {
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
            innerActionPerformed("eas", AbstractContractEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractContractEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionCmChange class
     */     
    protected class ActionCmChange extends ItemAction {     
    
        public ActionCmChange()
        {
            this(null);
        }

        public ActionCmChange(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionCmChange.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCmChange.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCmChange.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractContractEditUI.this, "ActionCmChange", "actionCmChange_actionPerformed", e);
        }
    }

    /**
     * output ActionUpVersion class
     */     
    protected class ActionUpVersion extends ItemAction {     
    
        public ActionUpVersion()
        {
            this(null);
        }

        public ActionUpVersion(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionUpVersion.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUpVersion.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUpVersion.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractContractEditUI.this, "ActionUpVersion", "actionUpVersion_actionPerformed", e);
        }
    }

    /**
     * output ActionToPayReq class
     */     
    protected class ActionToPayReq extends ItemAction {     
    
        public ActionToPayReq()
        {
            this(null);
        }

        public ActionToPayReq(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionToPayReq.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionToPayReq.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionToPayReq.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractContractEditUI.this, "ActionToPayReq", "actionToPayReq_actionPerformed", e);
        }
    }

    /**
     * output ActionViewHistory class
     */     
    protected class ActionViewHistory extends ItemAction {     
    
        public ActionViewHistory()
        {
            this(null);
        }

        public ActionViewHistory(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionViewHistory.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionViewHistory.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionViewHistory.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractContractEditUI.this, "ActionViewHistory", "actionViewHistory_actionPerformed", e);
        }
    }

    /**
     * output ActionInitial class
     */     
    protected class ActionInitial extends ItemAction {     
    
        public ActionInitial()
        {
            this(null);
        }

        public ActionInitial(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionInitial.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionInitial.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionInitial.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractContractEditUI.this, "ActionInitial", "actionInitial_actionPerformed", e);
        }
    }

    /**
     * output ActionRefresh class
     */     
    protected class ActionRefresh extends ItemAction {     
    
        public ActionRefresh()
        {
            this(null);
        }

        public ActionRefresh(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionRefresh.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionRefresh.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionRefresh.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractContractEditUI.this, "ActionRefresh", "actionRefresh_actionPerformed", e);
        }
    }

    /**
     * output ActionSetBailDays class
     */     
    protected class ActionSetBailDays extends ItemAction {     
    
        public ActionSetBailDays()
        {
            this(null);
        }

        public ActionSetBailDays(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionSetBailDays.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionSetBailDays.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionSetBailDays.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractContractEditUI.this, "ActionSetBailDays", "actionSetBailDays_actionPerformed", e);
        }
    }

    /**
     * output ActionOverPay class
     */     
    protected class ActionOverPay extends ItemAction {     
    
        public ActionOverPay()
        {
            this(null);
        }

        public ActionOverPay(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionOverPay.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionOverPay.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionOverPay.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractContractEditUI.this, "ActionOverPay", "actionOverPay_actionPerformed", e);
        }
    }

    /**
     * output ActionOverView class
     */     
    protected class ActionOverView extends ItemAction {     
    
        public ActionOverView()
        {
            this(null);
        }

        public ActionOverView(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionOverView.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionOverView.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionOverView.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractContractEditUI.this, "ActionOverView", "actionOverView_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.signwasthetable.client", "ContractEditUI");
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
        return com.kingdee.eas.custom.signwasthetable.client.ContractEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.signwasthetable.ContractFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.signwasthetable.ContractInfo objectValue = new com.kingdee.eas.custom.signwasthetable.ContractInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/signwasthetable/Contract";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.signwasthetable.app.ContractQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		for (int i=0,n=kdtPayment.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtPayment.getCell(i,"PhaseCoding").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"阶段"});
			}
		}
		for (int i=0,n=kdtPayment.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtPayment.getCell(i,"payCondition").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"付款条件"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtremark.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"备注"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcontractType.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"合同类别"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(contractStatus.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"合同状态"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcurrency.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"币别"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtexchangeRate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"汇率"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtcontractName.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"合同名称"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtassureDept.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"责任部门"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pksignDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"签订日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtpartyB.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"乙方（供应商）"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(contractNature.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"合同性质"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtassurer.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"责任人"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtpartyA.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"甲方"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtPayment;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("contractStatus","1");
vo.put("contractNature","1");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}