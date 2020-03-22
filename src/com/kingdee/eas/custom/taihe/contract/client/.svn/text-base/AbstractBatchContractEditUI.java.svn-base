/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.contract.client;

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
public abstract class AbstractBatchContractEditUI extends com.kingdee.eas.custom.wlhllicensemanager.client.WlhlCoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractBatchContractEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisSuccessive;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontractType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbeginDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contendDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsuccessiveQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfeedType;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsuccessiveContract;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane2;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtAllotEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtAllotEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkwhetherClose;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkinitialization;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkwhetherRepeat;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcontractType;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkbeginDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkendDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsuccessiveQty;
    protected com.kingdee.bos.ctrl.swing.KDComboBox feedType;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtremark;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsuccessiveContract;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsupplier;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpartyBAddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcapacity;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoutDaysStd;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrecycleEndDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdiffDays;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpartyBCell;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpartyBID;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpartyBBank;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpartyBAccount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrecycleBeginDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpurchasePerson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contheaderCell;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmAddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continitialCumulativeQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrecoveredQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnonRecoveryQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrecoveryRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmManager;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbuildDate;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkprohibitArea;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsupplier;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpartyBAddress;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarm;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcapacity;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoutDaysStd;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkrecycleEndDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdiffDays;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkinDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpartyBCell;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpartyBID;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpartyBBank;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpartyBAccount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtinQty;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkrecycleBeginDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpurchasePerson;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfarmer;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtheaderCell;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfarmAddress;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtinitialCumulativeQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtrecoveredQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtnonRecoveryQty;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtrecoveryRate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtmManager;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkbuildDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontractSafePrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpolicyProAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contreceiveAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbasePrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontractProAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcurrentDaysPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contactualAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpolicySafePrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsettlePolicy;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenSzCoeff;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator9;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthedgingPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfixedCoeff;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contshareCoeff;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator10;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contawardPolicy;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyzjincrease;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenSource;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcontractSafePrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpolicyProAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtreceiveAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbasePrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcontractProAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcurrentDaysPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtactualAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpolicySafePrice;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsettlePolicy;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickenSzCoeff;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txthedgingPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfixedCoeff;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtshareCoeff;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtawardPolicy;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyzjincrease;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtchickenSource;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnDistribution;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnClose;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnBackClose;
    protected com.kingdee.eas.custom.taihe.contract.BatchContractInfo editData = null;
    protected ActionDistribution actionDistribution = null;
    protected ActionClose actionClose = null;
    protected ActionBackClose actionBackClose = null;
    protected ActionAllAudit actionAllAudit = null;
    /**
     * output class constructor
     */
    public AbstractBatchContractEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractBatchContractEditUI.class.getName());
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
        //actionDistribution
        this.actionDistribution = new ActionDistribution(this);
        getActionManager().registerAction("actionDistribution", actionDistribution);
        this.actionDistribution.setBindWorkFlow(true);
        this.actionDistribution.setExtendProperty("canForewarn", "true");
        this.actionDistribution.setExtendProperty("userDefined", "true");
        this.actionDistribution.setExtendProperty("isObjectUpdateLock", "false");
         this.actionDistribution.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionDistribution.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionDistribution.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionClose
        this.actionClose = new ActionClose(this);
        getActionManager().registerAction("actionClose", actionClose);
        this.actionClose.setExtendProperty("canForewarn", "true");
        this.actionClose.setExtendProperty("userDefined", "true");
        this.actionClose.setExtendProperty("isObjectUpdateLock", "false");
         this.actionClose.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionClose.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionBackClose
        this.actionBackClose = new ActionBackClose(this);
        getActionManager().registerAction("actionBackClose", actionBackClose);
        this.actionBackClose.setExtendProperty("canForewarn", "true");
        this.actionBackClose.setExtendProperty("userDefined", "true");
        this.actionBackClose.setExtendProperty("isObjectUpdateLock", "false");
         this.actionBackClose.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionBackClose.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionAllAudit
        this.actionAllAudit = new ActionAllAudit(this);
        getActionManager().registerAction("actionAllAudit", actionAllAudit);
        this.actionAllAudit.setExtendProperty("canForewarn", "true");
        this.actionAllAudit.setExtendProperty("userDefined", "true");
        this.actionAllAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAllAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAllAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.chkisSuccessive = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contcontractType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbeginDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contendDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsuccessiveQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfeedType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contsuccessiveContract = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane2 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.kdtAllotEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.chkwhetherClose = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkinitialization = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkwhetherRepeat = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.prmtcontractType = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkbeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkendDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtsuccessiveQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.feedType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.txtremark = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.prmtsuccessiveContract = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contsupplier = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpartyBAddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcapacity = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoutDaysStd = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrecycleEndDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdiffDays = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpartyBCell = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpartyBID = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpartyBBank = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpartyBAccount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrecycleBeginDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpurchasePerson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contheaderCell = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmAddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continitialCumulativeQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrecoveredQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contnonRecoveryQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrecoveryRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmManager = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbuildDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkprohibitArea = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.prmtsupplier = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtpartyBAddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtfarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtcapacity = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtoutDaysStd = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkrecycleEndDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtdiffDays = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkinDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtpartyBCell = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtpartyBID = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtpartyBBank = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtpartyBAccount = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtinQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkrecycleBeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtpurchasePerson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtfarmer = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtheaderCell = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtfarmAddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtinitialCumulativeQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtrecoveredQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtnonRecoveryQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtrecoveryRate = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtmManager = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkbuildDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.contcontractSafePrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpolicyProAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contreceiveAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbasePrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcontractProAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcurrentDaysPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contactualAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpolicySafePrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsettlePolicy = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchickenSzCoeff = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDSeparator9 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.conthedgingPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfixedCoeff = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contshareCoeff = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator10 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contawardPolicy = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyzjincrease = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchickenSource = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtcontractSafePrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpolicyProAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtreceiveAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbasePrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcontractProAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcurrentDaysPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtactualAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpolicySafePrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtsettlePolicy = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtchickenSzCoeff = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txthedgingPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfixedCoeff = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtshareCoeff = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtawardPolicy = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtyzjincrease = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtchickenSource = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.btnDistribution = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnClose = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnBackClose = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.chkisSuccessive.setName("chkisSuccessive");
        this.contcontractType.setName("contcontractType");
        this.contbeginDate.setName("contbeginDate");
        this.contendDate.setName("contendDate");
        this.contsuccessiveQty.setName("contsuccessiveQty");
        this.contfeedType.setName("contfeedType");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contsuccessiveContract.setName("contsuccessiveContract");
        this.kDTabbedPane2.setName("kDTabbedPane2");
        this.kdtAllotEntry.setName("kdtAllotEntry");
        this.chkwhetherClose.setName("chkwhetherClose");
        this.chkinitialization.setName("chkinitialization");
        this.chkwhetherRepeat.setName("chkwhetherRepeat");
        this.prmtcontractType.setName("prmtcontractType");
        this.pkbeginDate.setName("pkbeginDate");
        this.pkendDate.setName("pkendDate");
        this.txtsuccessiveQty.setName("txtsuccessiveQty");
        this.feedType.setName("feedType");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kdtEntry.setName("kdtEntry");
        this.txtremark.setName("txtremark");
        this.prmtsuccessiveContract.setName("prmtsuccessiveContract");
        this.kDPanel3.setName("kDPanel3");
        this.kDPanel4.setName("kDPanel4");
        this.contsupplier.setName("contsupplier");
        this.contpartyBAddress.setName("contpartyBAddress");
        this.contfarm.setName("contfarm");
        this.contcapacity.setName("contcapacity");
        this.contoutDaysStd.setName("contoutDaysStd");
        this.contrecycleEndDate.setName("contrecycleEndDate");
        this.contdiffDays.setName("contdiffDays");
        this.continDate.setName("continDate");
        this.contpartyBCell.setName("contpartyBCell");
        this.contpartyBID.setName("contpartyBID");
        this.contpartyBBank.setName("contpartyBBank");
        this.contpartyBAccount.setName("contpartyBAccount");
        this.continQty.setName("continQty");
        this.contrecycleBeginDate.setName("contrecycleBeginDate");
        this.contcompany.setName("contcompany");
        this.contpurchasePerson.setName("contpurchasePerson");
        this.contfarmer.setName("contfarmer");
        this.contheaderCell.setName("contheaderCell");
        this.contfarmAddress.setName("contfarmAddress");
        this.continitialCumulativeQty.setName("continitialCumulativeQty");
        this.contrecoveredQty.setName("contrecoveredQty");
        this.contnonRecoveryQty.setName("contnonRecoveryQty");
        this.contrecoveryRate.setName("contrecoveryRate");
        this.contmManager.setName("contmManager");
        this.contbuildDate.setName("contbuildDate");
        this.chkprohibitArea.setName("chkprohibitArea");
        this.prmtsupplier.setName("prmtsupplier");
        this.txtpartyBAddress.setName("txtpartyBAddress");
        this.prmtfarm.setName("prmtfarm");
        this.txtcapacity.setName("txtcapacity");
        this.txtoutDaysStd.setName("txtoutDaysStd");
        this.pkrecycleEndDate.setName("pkrecycleEndDate");
        this.txtdiffDays.setName("txtdiffDays");
        this.pkinDate.setName("pkinDate");
        this.txtpartyBCell.setName("txtpartyBCell");
        this.txtpartyBID.setName("txtpartyBID");
        this.txtpartyBBank.setName("txtpartyBBank");
        this.txtpartyBAccount.setName("txtpartyBAccount");
        this.txtinQty.setName("txtinQty");
        this.pkrecycleBeginDate.setName("pkrecycleBeginDate");
        this.prmtcompany.setName("prmtcompany");
        this.prmtpurchasePerson.setName("prmtpurchasePerson");
        this.txtfarmer.setName("txtfarmer");
        this.txtheaderCell.setName("txtheaderCell");
        this.txtfarmAddress.setName("txtfarmAddress");
        this.txtinitialCumulativeQty.setName("txtinitialCumulativeQty");
        this.txtrecoveredQty.setName("txtrecoveredQty");
        this.txtnonRecoveryQty.setName("txtnonRecoveryQty");
        this.txtrecoveryRate.setName("txtrecoveryRate");
        this.txtmManager.setName("txtmManager");
        this.pkbuildDate.setName("pkbuildDate");
        this.contcontractSafePrice.setName("contcontractSafePrice");
        this.contpolicyProAmt.setName("contpolicyProAmt");
        this.contreceiveAmt.setName("contreceiveAmt");
        this.contbasePrice.setName("contbasePrice");
        this.contcontractProAmt.setName("contcontractProAmt");
        this.contcurrentDaysPrice.setName("contcurrentDaysPrice");
        this.contactualAmt.setName("contactualAmt");
        this.contpolicySafePrice.setName("contpolicySafePrice");
        this.contsettlePolicy.setName("contsettlePolicy");
        this.contchickenSzCoeff.setName("contchickenSzCoeff");
        this.kDSeparator8.setName("kDSeparator8");
        this.kDSeparator9.setName("kDSeparator9");
        this.conthedgingPrice.setName("conthedgingPrice");
        this.contfixedCoeff.setName("contfixedCoeff");
        this.contshareCoeff.setName("contshareCoeff");
        this.kDSeparator10.setName("kDSeparator10");
        this.contawardPolicy.setName("contawardPolicy");
        this.contyzjincrease.setName("contyzjincrease");
        this.contchickenSource.setName("contchickenSource");
        this.txtcontractSafePrice.setName("txtcontractSafePrice");
        this.txtpolicyProAmt.setName("txtpolicyProAmt");
        this.txtreceiveAmt.setName("txtreceiveAmt");
        this.txtbasePrice.setName("txtbasePrice");
        this.txtcontractProAmt.setName("txtcontractProAmt");
        this.txtcurrentDaysPrice.setName("txtcurrentDaysPrice");
        this.txtactualAmt.setName("txtactualAmt");
        this.txtpolicySafePrice.setName("txtpolicySafePrice");
        this.prmtsettlePolicy.setName("prmtsettlePolicy");
        this.txtchickenSzCoeff.setName("txtchickenSzCoeff");
        this.txthedgingPrice.setName("txthedgingPrice");
        this.txtfixedCoeff.setName("txtfixedCoeff");
        this.txtshareCoeff.setName("txtshareCoeff");
        this.prmtawardPolicy.setName("prmtawardPolicy");
        this.txtyzjincrease.setName("txtyzjincrease");
        this.txtchickenSource.setName("txtchickenSource");
        this.btnDistribution.setName("btnDistribution");
        this.btnClose.setName("btnClose");
        this.btnBackClose.setName("btnBackClose");
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
        this.contCreator.setBoundLabelText(resHelper.getString("contCreator.boundLabelText"));		
        this.contCreator.setBoundLabelLength(100);		
        this.contCreator.setBoundLabelUnderline(true);		
        this.contCreator.setEnabled(false);		
        this.contCreateTime.setBoundLabelText(resHelper.getString("contCreateTime.boundLabelText"));		
        this.contCreateTime.setBoundLabelLength(100);		
        this.contCreateTime.setBoundLabelUnderline(true);		
        this.contCreateTime.setEnabled(false);		
        this.contLastUpdateUser.setBoundLabelText(resHelper.getString("contLastUpdateUser.boundLabelText"));		
        this.contLastUpdateUser.setBoundLabelLength(100);		
        this.contLastUpdateUser.setBoundLabelUnderline(true);		
        this.contLastUpdateUser.setEnabled(false);		
        this.contLastUpdateUser.setVisible(true);		
        this.contLastUpdateTime.setBoundLabelText(resHelper.getString("contLastUpdateTime.boundLabelText"));		
        this.contLastUpdateTime.setBoundLabelLength(100);		
        this.contLastUpdateTime.setBoundLabelUnderline(true);		
        this.contLastUpdateTime.setEnabled(false);		
        this.contLastUpdateTime.setVisible(true);		
        this.contNumber.setBoundLabelText(resHelper.getString("contNumber.boundLabelText"));		
        this.contNumber.setBoundLabelLength(100);		
        this.contNumber.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelText(resHelper.getString("contBizDate.boundLabelText"));		
        this.contBizDate.setBoundLabelLength(100);		
        this.contBizDate.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelAlignment(7);		
        this.contBizDate.setVisible(true);		
        this.contDescription.setVisible(false);		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);		
        this.prmtCreator.setEnabled(false);		
        this.kDDateCreateTime.setTimeEnabled(true);		
        this.kDDateCreateTime.setEnabled(false);		
        this.prmtLastUpdateUser.setEnabled(false);		
        this.kDDateLastUpdateTime.setTimeEnabled(true);		
        this.kDDateLastUpdateTime.setEnabled(false);		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setRequired(true);		
        this.pkBizDate.setVisible(true);		
        this.pkBizDate.setEnabled(true);		
        this.pkBizDate.setRequired(true);		
        this.prmtAuditor.setEnabled(false);		
        this.pkauditTime.setVisible(true);		
        this.pkauditTime.setRequired(false);		
        this.billStatus.setVisible(true);		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // chkisSuccessive		
        this.chkisSuccessive.setText(resHelper.getString("chkisSuccessive.text"));		
        this.chkisSuccessive.setVisible(true);		
        this.chkisSuccessive.setHorizontalAlignment(2);
        // contcontractType		
        this.contcontractType.setBoundLabelText(resHelper.getString("contcontractType.boundLabelText"));		
        this.contcontractType.setBoundLabelLength(100);		
        this.contcontractType.setBoundLabelUnderline(true);		
        this.contcontractType.setVisible(true);
        // contbeginDate		
        this.contbeginDate.setBoundLabelText(resHelper.getString("contbeginDate.boundLabelText"));		
        this.contbeginDate.setBoundLabelLength(100);		
        this.contbeginDate.setBoundLabelUnderline(true);		
        this.contbeginDate.setVisible(true);
        // contendDate		
        this.contendDate.setBoundLabelText(resHelper.getString("contendDate.boundLabelText"));		
        this.contendDate.setBoundLabelLength(100);		
        this.contendDate.setBoundLabelUnderline(true);		
        this.contendDate.setVisible(false);
        // contsuccessiveQty		
        this.contsuccessiveQty.setBoundLabelText(resHelper.getString("contsuccessiveQty.boundLabelText"));		
        this.contsuccessiveQty.setBoundLabelLength(100);		
        this.contsuccessiveQty.setBoundLabelUnderline(true);		
        this.contsuccessiveQty.setVisible(true);
        // contfeedType		
        this.contfeedType.setBoundLabelText(resHelper.getString("contfeedType.boundLabelText"));		
        this.contfeedType.setBoundLabelLength(100);		
        this.contfeedType.setBoundLabelUnderline(true);		
        this.contfeedType.setVisible(true);
        // kDTabbedPane1
        // contsuccessiveContract		
        this.contsuccessiveContract.setBoundLabelText(resHelper.getString("contsuccessiveContract.boundLabelText"));		
        this.contsuccessiveContract.setBoundLabelLength(100);		
        this.contsuccessiveContract.setBoundLabelUnderline(true);		
        this.contsuccessiveContract.setVisible(true);
        // kDTabbedPane2
        // kdtAllotEntry
		String kdtAllotEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"allotUser\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"allotTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"allotOrg\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{allotUser}</t:Cell><t:Cell>$Resource{allotTime}</t:Cell><t:Cell>$Resource{allotOrg}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtAllotEntry.setFormatXml(resHelper.translateString("kdtAllotEntry",kdtAllotEntryStrXML));

                this.kdtAllotEntry.putBindContents("editData",new String[] {"seq","allotUser","allotTime","allotOrg"});


        this.kdtAllotEntry.checkParsed();
        final KDBizPromptBox kdtAllotEntry_allotUser_PromptBox = new KDBizPromptBox();
        kdtAllotEntry_allotUser_PromptBox.setQueryInfo("com.kingdee.eas.base.permission.app.F7AllUserQuery");
        kdtAllotEntry_allotUser_PromptBox.setVisible(true);
        kdtAllotEntry_allotUser_PromptBox.setEditable(true);
        kdtAllotEntry_allotUser_PromptBox.setDisplayFormat("$number$");
        kdtAllotEntry_allotUser_PromptBox.setEditFormat("$number$");
        kdtAllotEntry_allotUser_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtAllotEntry_allotUser_CellEditor = new KDTDefaultCellEditor(kdtAllotEntry_allotUser_PromptBox);
        this.kdtAllotEntry.getColumn("allotUser").setEditor(kdtAllotEntry_allotUser_CellEditor);
        ObjectValueRender kdtAllotEntry_allotUser_OVR = new ObjectValueRender();
        kdtAllotEntry_allotUser_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtAllotEntry.getColumn("allotUser").setRenderer(kdtAllotEntry_allotUser_OVR);
        KDDatePicker kdtAllotEntry_allotTime_DatePicker = new KDDatePicker();
        kdtAllotEntry_allotTime_DatePicker.setName("kdtAllotEntry_allotTime_DatePicker");
        kdtAllotEntry_allotTime_DatePicker.setVisible(true);
        kdtAllotEntry_allotTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtAllotEntry_allotTime_CellEditor = new KDTDefaultCellEditor(kdtAllotEntry_allotTime_DatePicker);
        this.kdtAllotEntry.getColumn("allotTime").setEditor(kdtAllotEntry_allotTime_CellEditor);
        final KDBizPromptBox kdtAllotEntry_allotOrg_PromptBox = new KDBizPromptBox();
        kdtAllotEntry_allotOrg_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery4AsstAcct");
        kdtAllotEntry_allotOrg_PromptBox.setVisible(true);
        kdtAllotEntry_allotOrg_PromptBox.setEditable(true);
        kdtAllotEntry_allotOrg_PromptBox.setDisplayFormat("$number$");
        kdtAllotEntry_allotOrg_PromptBox.setEditFormat("$number$");
        kdtAllotEntry_allotOrg_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtAllotEntry_allotOrg_CellEditor = new KDTDefaultCellEditor(kdtAllotEntry_allotOrg_PromptBox);
        this.kdtAllotEntry.getColumn("allotOrg").setEditor(kdtAllotEntry_allotOrg_CellEditor);
        ObjectValueRender kdtAllotEntry_allotOrg_OVR = new ObjectValueRender();
        kdtAllotEntry_allotOrg_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtAllotEntry.getColumn("allotOrg").setRenderer(kdtAllotEntry_allotOrg_OVR);
        // chkwhetherClose		
        this.chkwhetherClose.setText(resHelper.getString("chkwhetherClose.text"));		
        this.chkwhetherClose.setVisible(true);		
        this.chkwhetherClose.setHorizontalAlignment(2);		
        this.chkwhetherClose.setEnabled(false);
        // chkinitialization		
        this.chkinitialization.setText(resHelper.getString("chkinitialization.text"));		
        this.chkinitialization.setVisible(true);		
        this.chkinitialization.setHorizontalAlignment(2);
        // chkwhetherRepeat		
        this.chkwhetherRepeat.setText(resHelper.getString("chkwhetherRepeat.text"));		
        this.chkwhetherRepeat.setVisible(true);		
        this.chkwhetherRepeat.setHorizontalAlignment(2);
        // prmtcontractType		
        this.prmtcontractType.setQueryInfo("com.kingdee.eas.custom.signwasthetable.app.ContractTypeQuery");		
        this.prmtcontractType.setVisible(true);		
        this.prmtcontractType.setEditable(true);		
        this.prmtcontractType.setDisplayFormat("$name$");		
        this.prmtcontractType.setEditFormat("$number$");		
        this.prmtcontractType.setCommitFormat("$number$");		
        this.prmtcontractType.setRequired(true);
        // pkbeginDate		
        this.pkbeginDate.setVisible(true);		
        this.pkbeginDate.setRequired(true);
        // pkendDate		
        this.pkendDate.setRequired(false);
        // txtsuccessiveQty		
        this.txtsuccessiveQty.setVisible(true);		
        this.txtsuccessiveQty.setHorizontalAlignment(2);		
        this.txtsuccessiveQty.setDataType(1);		
        this.txtsuccessiveQty.setSupportedEmpty(true);		
        this.txtsuccessiveQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsuccessiveQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsuccessiveQty.setPrecision(4);		
        this.txtsuccessiveQty.setRequired(false);
        // feedType		
        this.feedType.setVisible(true);		
        this.feedType.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.taihe.contract.FeedType").toArray());		
        this.feedType.setRequired(false);
        // kDPanel1
        // kDPanel2
        // kdtEntry
		String kdtEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"receiveBill\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"receiveBillAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"usedAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"currentAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{receiveBill}</t:Cell><t:Cell>$Resource{receiveBillAmt}</t:Cell><t:Cell>$Resource{usedAmt}</t:Cell><t:Cell>$Resource{currentAmt}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntry.setFormatXml(resHelper.translateString("kdtEntry",kdtEntryStrXML));

                this.kdtEntry.putBindContents("editData",new String[] {"seq","receiveBill","receiveBillAmt","usedAmt","currentAmt"});


        this.kdtEntry.checkParsed();
        final KDBizPromptBox kdtEntry_receiveBill_PromptBox = new KDBizPromptBox();
        kdtEntry_receiveBill_PromptBox.setQueryInfo("com.kingdee.eas.ma.crbg.app.ReceiveBillQuery");
        kdtEntry_receiveBill_PromptBox.setVisible(true);
        kdtEntry_receiveBill_PromptBox.setEditable(true);
        kdtEntry_receiveBill_PromptBox.setDisplayFormat("$number$");
        kdtEntry_receiveBill_PromptBox.setEditFormat("$number$");
        kdtEntry_receiveBill_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_receiveBill_CellEditor = new KDTDefaultCellEditor(kdtEntry_receiveBill_PromptBox);
        this.kdtEntry.getColumn("receiveBill").setEditor(kdtEntry_receiveBill_CellEditor);
        ObjectValueRender kdtEntry_receiveBill_OVR = new ObjectValueRender();
        kdtEntry_receiveBill_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntry.getColumn("receiveBill").setRenderer(kdtEntry_receiveBill_OVR);
        KDFormattedTextField kdtEntry_receiveBillAmt_TextField = new KDFormattedTextField();
        kdtEntry_receiveBillAmt_TextField.setName("kdtEntry_receiveBillAmt_TextField");
        kdtEntry_receiveBillAmt_TextField.setVisible(true);
        kdtEntry_receiveBillAmt_TextField.setEditable(true);
        kdtEntry_receiveBillAmt_TextField.setHorizontalAlignment(2);
        kdtEntry_receiveBillAmt_TextField.setDataType(1);
        	kdtEntry_receiveBillAmt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_receiveBillAmt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_receiveBillAmt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_receiveBillAmt_CellEditor = new KDTDefaultCellEditor(kdtEntry_receiveBillAmt_TextField);
        this.kdtEntry.getColumn("receiveBillAmt").setEditor(kdtEntry_receiveBillAmt_CellEditor);
        KDFormattedTextField kdtEntry_usedAmt_TextField = new KDFormattedTextField();
        kdtEntry_usedAmt_TextField.setName("kdtEntry_usedAmt_TextField");
        kdtEntry_usedAmt_TextField.setVisible(true);
        kdtEntry_usedAmt_TextField.setEditable(true);
        kdtEntry_usedAmt_TextField.setHorizontalAlignment(2);
        kdtEntry_usedAmt_TextField.setDataType(1);
        	kdtEntry_usedAmt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_usedAmt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_usedAmt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_usedAmt_CellEditor = new KDTDefaultCellEditor(kdtEntry_usedAmt_TextField);
        this.kdtEntry.getColumn("usedAmt").setEditor(kdtEntry_usedAmt_CellEditor);
        KDFormattedTextField kdtEntry_currentAmt_TextField = new KDFormattedTextField();
        kdtEntry_currentAmt_TextField.setName("kdtEntry_currentAmt_TextField");
        kdtEntry_currentAmt_TextField.setVisible(true);
        kdtEntry_currentAmt_TextField.setEditable(true);
        kdtEntry_currentAmt_TextField.setHorizontalAlignment(2);
        kdtEntry_currentAmt_TextField.setDataType(1);
        	kdtEntry_currentAmt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_currentAmt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_currentAmt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_currentAmt_CellEditor = new KDTDefaultCellEditor(kdtEntry_currentAmt_TextField);
        this.kdtEntry.getColumn("currentAmt").setEditor(kdtEntry_currentAmt_CellEditor);
        // txtremark		
        this.txtremark.setVisible(true);		
        this.txtremark.setRequired(false);		
        this.txtremark.setMaxLength(255);
        // prmtsuccessiveContract		
        this.prmtsuccessiveContract.setQueryInfo("com.kingdee.eas.custom.taihe.contract.app.SuccessiveContractQuery");		
        this.prmtsuccessiveContract.setVisible(true);		
        this.prmtsuccessiveContract.setEditable(true);		
        this.prmtsuccessiveContract.setDisplayFormat("$number$");		
        this.prmtsuccessiveContract.setEditFormat("$number$");		
        this.prmtsuccessiveContract.setCommitFormat("$number$");		
        this.prmtsuccessiveContract.setRequired(false);
        prmtsuccessiveContract.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtsuccessiveContract_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // kDPanel3
        // kDPanel4
        // contsupplier		
        this.contsupplier.setBoundLabelText(resHelper.getString("contsupplier.boundLabelText"));		
        this.contsupplier.setBoundLabelLength(100);		
        this.contsupplier.setBoundLabelUnderline(true);		
        this.contsupplier.setVisible(true);
        // contpartyBAddress		
        this.contpartyBAddress.setBoundLabelText(resHelper.getString("contpartyBAddress.boundLabelText"));		
        this.contpartyBAddress.setBoundLabelLength(100);		
        this.contpartyBAddress.setBoundLabelUnderline(true);		
        this.contpartyBAddress.setVisible(true);		
        this.contpartyBAddress.setForeground(new java.awt.Color(0,0,0));
        // contfarm		
        this.contfarm.setBoundLabelText(resHelper.getString("contfarm.boundLabelText"));		
        this.contfarm.setBoundLabelLength(100);		
        this.contfarm.setBoundLabelUnderline(true);		
        this.contfarm.setVisible(true);		
        this.contfarm.setForeground(new java.awt.Color(0,0,0));
        // contcapacity		
        this.contcapacity.setBoundLabelText(resHelper.getString("contcapacity.boundLabelText"));		
        this.contcapacity.setBoundLabelLength(100);		
        this.contcapacity.setBoundLabelUnderline(true);		
        this.contcapacity.setVisible(true);		
        this.contcapacity.setForeground(new java.awt.Color(0,0,0));
        // contoutDaysStd		
        this.contoutDaysStd.setBoundLabelText(resHelper.getString("contoutDaysStd.boundLabelText"));		
        this.contoutDaysStd.setBoundLabelLength(100);		
        this.contoutDaysStd.setBoundLabelUnderline(true);		
        this.contoutDaysStd.setVisible(true);		
        this.contoutDaysStd.setForeground(new java.awt.Color(0,0,0));
        // contrecycleEndDate		
        this.contrecycleEndDate.setBoundLabelText(resHelper.getString("contrecycleEndDate.boundLabelText"));		
        this.contrecycleEndDate.setBoundLabelLength(100);		
        this.contrecycleEndDate.setBoundLabelUnderline(true);		
        this.contrecycleEndDate.setVisible(true);		
        this.contrecycleEndDate.setForeground(new java.awt.Color(0,0,0));
        // contdiffDays		
        this.contdiffDays.setBoundLabelText(resHelper.getString("contdiffDays.boundLabelText"));		
        this.contdiffDays.setBoundLabelLength(100);		
        this.contdiffDays.setBoundLabelUnderline(true);		
        this.contdiffDays.setVisible(true);
        // continDate		
        this.continDate.setBoundLabelText(resHelper.getString("continDate.boundLabelText"));		
        this.continDate.setBoundLabelLength(100);		
        this.continDate.setBoundLabelUnderline(true);		
        this.continDate.setVisible(true);
        // contpartyBCell		
        this.contpartyBCell.setBoundLabelText(resHelper.getString("contpartyBCell.boundLabelText"));		
        this.contpartyBCell.setBoundLabelLength(100);		
        this.contpartyBCell.setBoundLabelUnderline(true);		
        this.contpartyBCell.setVisible(true);
        // contpartyBID		
        this.contpartyBID.setBoundLabelText(resHelper.getString("contpartyBID.boundLabelText"));		
        this.contpartyBID.setBoundLabelLength(100);		
        this.contpartyBID.setBoundLabelUnderline(true);		
        this.contpartyBID.setVisible(true);
        // contpartyBBank		
        this.contpartyBBank.setBoundLabelText(resHelper.getString("contpartyBBank.boundLabelText"));		
        this.contpartyBBank.setBoundLabelLength(100);		
        this.contpartyBBank.setBoundLabelUnderline(true);		
        this.contpartyBBank.setVisible(true);
        // contpartyBAccount		
        this.contpartyBAccount.setBoundLabelText(resHelper.getString("contpartyBAccount.boundLabelText"));		
        this.contpartyBAccount.setBoundLabelLength(100);		
        this.contpartyBAccount.setBoundLabelUnderline(true);		
        this.contpartyBAccount.setVisible(true);
        // continQty		
        this.continQty.setBoundLabelText(resHelper.getString("continQty.boundLabelText"));		
        this.continQty.setBoundLabelLength(100);		
        this.continQty.setBoundLabelUnderline(true);		
        this.continQty.setVisible(true);
        // contrecycleBeginDate		
        this.contrecycleBeginDate.setBoundLabelText(resHelper.getString("contrecycleBeginDate.boundLabelText"));		
        this.contrecycleBeginDate.setBoundLabelLength(100);		
        this.contrecycleBeginDate.setBoundLabelUnderline(true);		
        this.contrecycleBeginDate.setVisible(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contpurchasePerson		
        this.contpurchasePerson.setBoundLabelText(resHelper.getString("contpurchasePerson.boundLabelText"));		
        this.contpurchasePerson.setBoundLabelLength(100);		
        this.contpurchasePerson.setBoundLabelUnderline(true);		
        this.contpurchasePerson.setVisible(true);
        // contfarmer		
        this.contfarmer.setBoundLabelText(resHelper.getString("contfarmer.boundLabelText"));		
        this.contfarmer.setBoundLabelLength(100);		
        this.contfarmer.setBoundLabelUnderline(true);		
        this.contfarmer.setVisible(true);
        // contheaderCell		
        this.contheaderCell.setBoundLabelText(resHelper.getString("contheaderCell.boundLabelText"));		
        this.contheaderCell.setBoundLabelLength(100);		
        this.contheaderCell.setBoundLabelUnderline(true);		
        this.contheaderCell.setVisible(true);
        // contfarmAddress		
        this.contfarmAddress.setBoundLabelText(resHelper.getString("contfarmAddress.boundLabelText"));		
        this.contfarmAddress.setBoundLabelLength(100);		
        this.contfarmAddress.setBoundLabelUnderline(true);		
        this.contfarmAddress.setVisible(true);
        // continitialCumulativeQty		
        this.continitialCumulativeQty.setBoundLabelText(resHelper.getString("continitialCumulativeQty.boundLabelText"));		
        this.continitialCumulativeQty.setBoundLabelLength(100);		
        this.continitialCumulativeQty.setBoundLabelUnderline(true);		
        this.continitialCumulativeQty.setVisible(true);
        // contrecoveredQty		
        this.contrecoveredQty.setBoundLabelText(resHelper.getString("contrecoveredQty.boundLabelText"));		
        this.contrecoveredQty.setBoundLabelLength(100);		
        this.contrecoveredQty.setBoundLabelUnderline(true);		
        this.contrecoveredQty.setVisible(true);
        // contnonRecoveryQty		
        this.contnonRecoveryQty.setBoundLabelText(resHelper.getString("contnonRecoveryQty.boundLabelText"));		
        this.contnonRecoveryQty.setBoundLabelLength(100);		
        this.contnonRecoveryQty.setBoundLabelUnderline(true);		
        this.contnonRecoveryQty.setVisible(true);
        // contrecoveryRate		
        this.contrecoveryRate.setBoundLabelText(resHelper.getString("contrecoveryRate.boundLabelText"));		
        this.contrecoveryRate.setBoundLabelLength(100);		
        this.contrecoveryRate.setBoundLabelUnderline(true);		
        this.contrecoveryRate.setVisible(true);
        // contmManager		
        this.contmManager.setBoundLabelText(resHelper.getString("contmManager.boundLabelText"));		
        this.contmManager.setBoundLabelLength(100);		
        this.contmManager.setBoundLabelUnderline(true);		
        this.contmManager.setVisible(true);
        // contbuildDate		
        this.contbuildDate.setBoundLabelText(resHelper.getString("contbuildDate.boundLabelText"));		
        this.contbuildDate.setBoundLabelLength(100);		
        this.contbuildDate.setBoundLabelUnderline(true);		
        this.contbuildDate.setVisible(true);
        // chkprohibitArea		
        this.chkprohibitArea.setText(resHelper.getString("chkprohibitArea.text"));		
        this.chkprohibitArea.setVisible(true);		
        this.chkprohibitArea.setHorizontalAlignment(2);		
        this.chkprohibitArea.setEnabled(false);
        // prmtsupplier		
        this.prmtsupplier.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.PSupplierQuery");		
        this.prmtsupplier.setVisible(true);		
        this.prmtsupplier.setEditable(true);		
        this.prmtsupplier.setDisplayFormat("$name$");		
        this.prmtsupplier.setEditFormat("$number$");		
        this.prmtsupplier.setCommitFormat("$number$");		
        this.prmtsupplier.setRequired(false);
        // txtpartyBAddress		
        this.txtpartyBAddress.setVisible(true);		
        this.txtpartyBAddress.setHorizontalAlignment(2);		
        this.txtpartyBAddress.setMaxLength(100);		
        this.txtpartyBAddress.setRequired(false);
        // prmtfarm		
        this.prmtfarm.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmQuery");		
        this.prmtfarm.setVisible(true);		
        this.prmtfarm.setEditable(true);		
        this.prmtfarm.setDisplayFormat("$name$");		
        this.prmtfarm.setEditFormat("$number$");		
        this.prmtfarm.setCommitFormat("$number$");		
        this.prmtfarm.setRequired(false);
        		prmtfarm.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmListUI prmtfarm_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarm_F7ListUI == null) {
					try {
						prmtfarm_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtfarm_F7ListUI));
					prmtfarm_F7ListUI.setF7Use(true,ctx);
					prmtfarm.setSelector(prmtfarm_F7ListUI);
				}
			}
		});
					
        prmtfarm.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtfarm_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtcapacity		
        this.txtcapacity.setVisible(true);		
        this.txtcapacity.setHorizontalAlignment(2);		
        this.txtcapacity.setDataType(1);		
        this.txtcapacity.setSupportedEmpty(true);		
        this.txtcapacity.setMinimumValue( new java.math.BigDecimal("-3.4028234663852886E38"));		
        this.txtcapacity.setMaximumValue( new java.math.BigDecimal("3.4028234663852886E38"));		
        this.txtcapacity.setPrecision(10);		
        this.txtcapacity.setRequired(false);
        // txtoutDaysStd		
        this.txtoutDaysStd.setVisible(true);		
        this.txtoutDaysStd.setHorizontalAlignment(2);		
        this.txtoutDaysStd.setDataType(0);		
        this.txtoutDaysStd.setSupportedEmpty(true);		
        this.txtoutDaysStd.setRequired(false);
        // pkrecycleEndDate		
        this.pkrecycleEndDate.setVisible(true);		
        this.pkrecycleEndDate.setRequired(false);
        // txtdiffDays		
        this.txtdiffDays.setVisible(true);		
        this.txtdiffDays.setHorizontalAlignment(2);		
        this.txtdiffDays.setDataType(0);		
        this.txtdiffDays.setSupportedEmpty(true);		
        this.txtdiffDays.setRequired(false);
        // pkinDate		
        this.pkinDate.setVisible(true);		
        this.pkinDate.setRequired(true);
        // txtpartyBCell		
        this.txtpartyBCell.setVisible(true);		
        this.txtpartyBCell.setHorizontalAlignment(2);		
        this.txtpartyBCell.setMaxLength(100);		
        this.txtpartyBCell.setRequired(false);
        // txtpartyBID		
        this.txtpartyBID.setVisible(true);		
        this.txtpartyBID.setHorizontalAlignment(2);		
        this.txtpartyBID.setMaxLength(100);		
        this.txtpartyBID.setRequired(false);
        // txtpartyBBank		
        this.txtpartyBBank.setVisible(true);		
        this.txtpartyBBank.setHorizontalAlignment(2);		
        this.txtpartyBBank.setMaxLength(100);		
        this.txtpartyBBank.setRequired(false);
        // txtpartyBAccount		
        this.txtpartyBAccount.setVisible(true);		
        this.txtpartyBAccount.setHorizontalAlignment(2);		
        this.txtpartyBAccount.setMaxLength(100);		
        this.txtpartyBAccount.setRequired(false);
        // txtinQty		
        this.txtinQty.setVisible(true);		
        this.txtinQty.setHorizontalAlignment(2);		
        this.txtinQty.setDataType(1);		
        this.txtinQty.setSupportedEmpty(true);		
        this.txtinQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtinQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtinQty.setPrecision(4);		
        this.txtinQty.setRequired(true);
        txtinQty.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				txtinQty_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // pkrecycleBeginDate		
        this.pkrecycleBeginDate.setVisible(true);		
        this.pkrecycleBeginDate.setRequired(false);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setVisible(true);		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(false);
        // prmtpurchasePerson		
        this.prmtpurchasePerson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtpurchasePerson.setVisible(true);		
        this.prmtpurchasePerson.setEditable(true);		
        this.prmtpurchasePerson.setDisplayFormat("$name$");		
        this.prmtpurchasePerson.setEditFormat("$number$");		
        this.prmtpurchasePerson.setCommitFormat("$number$");		
        this.prmtpurchasePerson.setRequired(true);
        // txtfarmer		
        this.txtfarmer.setVisible(true);		
        this.txtfarmer.setHorizontalAlignment(2);		
        this.txtfarmer.setMaxLength(80);		
        this.txtfarmer.setRequired(false);
        // txtheaderCell		
        this.txtheaderCell.setVisible(true);		
        this.txtheaderCell.setHorizontalAlignment(2);		
        this.txtheaderCell.setMaxLength(80);		
        this.txtheaderCell.setRequired(false);
        // txtfarmAddress		
        this.txtfarmAddress.setVisible(true);		
        this.txtfarmAddress.setHorizontalAlignment(2);		
        this.txtfarmAddress.setMaxLength(80);		
        this.txtfarmAddress.setRequired(true);
        // txtinitialCumulativeQty		
        this.txtinitialCumulativeQty.setVisible(true);		
        this.txtinitialCumulativeQty.setHorizontalAlignment(2);		
        this.txtinitialCumulativeQty.setDataType(1);		
        this.txtinitialCumulativeQty.setSupportedEmpty(true);		
        this.txtinitialCumulativeQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtinitialCumulativeQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtinitialCumulativeQty.setPrecision(4);		
        this.txtinitialCumulativeQty.setRequired(false);
        // txtrecoveredQty		
        this.txtrecoveredQty.setVisible(true);		
        this.txtrecoveredQty.setHorizontalAlignment(2);		
        this.txtrecoveredQty.setDataType(1);		
        this.txtrecoveredQty.setSupportedEmpty(true);		
        this.txtrecoveredQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtrecoveredQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtrecoveredQty.setPrecision(4);		
        this.txtrecoveredQty.setRequired(false);		
        this.txtrecoveredQty.setEnabled(false);
        // txtnonRecoveryQty		
        this.txtnonRecoveryQty.setVisible(true);		
        this.txtnonRecoveryQty.setHorizontalAlignment(2);		
        this.txtnonRecoveryQty.setDataType(1);		
        this.txtnonRecoveryQty.setSupportedEmpty(true);		
        this.txtnonRecoveryQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtnonRecoveryQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtnonRecoveryQty.setPrecision(4);		
        this.txtnonRecoveryQty.setRequired(false);		
        this.txtnonRecoveryQty.setEnabled(false);
        // txtrecoveryRate		
        this.txtrecoveryRate.setVisible(true);		
        this.txtrecoveryRate.setHorizontalAlignment(2);		
        this.txtrecoveryRate.setMaxLength(100);		
        this.txtrecoveryRate.setRequired(false);		
        this.txtrecoveryRate.setEnabled(false);
        // txtmManager		
        this.txtmManager.setVisible(true);		
        this.txtmManager.setHorizontalAlignment(2);		
        this.txtmManager.setMaxLength(80);		
        this.txtmManager.setRequired(false);		
        this.txtmManager.setEnabled(false);
        // pkbuildDate		
        this.pkbuildDate.setVisible(true);		
        this.pkbuildDate.setRequired(false);		
        this.pkbuildDate.setEnabled(false);
        // contcontractSafePrice		
        this.contcontractSafePrice.setBoundLabelText(resHelper.getString("contcontractSafePrice.boundLabelText"));		
        this.contcontractSafePrice.setBoundLabelLength(100);		
        this.contcontractSafePrice.setBoundLabelUnderline(true);		
        this.contcontractSafePrice.setVisible(true);		
        this.contcontractSafePrice.setForeground(new java.awt.Color(0,0,0));
        // contpolicyProAmt		
        this.contpolicyProAmt.setBoundLabelText(resHelper.getString("contpolicyProAmt.boundLabelText"));		
        this.contpolicyProAmt.setBoundLabelLength(100);		
        this.contpolicyProAmt.setBoundLabelUnderline(true);		
        this.contpolicyProAmt.setVisible(true);		
        this.contpolicyProAmt.setForeground(new java.awt.Color(0,0,0));
        // contreceiveAmt		
        this.contreceiveAmt.setBoundLabelText(resHelper.getString("contreceiveAmt.boundLabelText"));		
        this.contreceiveAmt.setBoundLabelLength(100);		
        this.contreceiveAmt.setBoundLabelUnderline(true);		
        this.contreceiveAmt.setVisible(true);		
        this.contreceiveAmt.setForeground(new java.awt.Color(0,0,0));
        // contbasePrice		
        this.contbasePrice.setBoundLabelText(resHelper.getString("contbasePrice.boundLabelText"));		
        this.contbasePrice.setBoundLabelLength(100);		
        this.contbasePrice.setBoundLabelUnderline(true);		
        this.contbasePrice.setVisible(true);
        // contcontractProAmt		
        this.contcontractProAmt.setBoundLabelText(resHelper.getString("contcontractProAmt.boundLabelText"));		
        this.contcontractProAmt.setBoundLabelLength(100);		
        this.contcontractProAmt.setBoundLabelUnderline(true);		
        this.contcontractProAmt.setVisible(true);
        // contcurrentDaysPrice		
        this.contcurrentDaysPrice.setBoundLabelText(resHelper.getString("contcurrentDaysPrice.boundLabelText"));		
        this.contcurrentDaysPrice.setBoundLabelLength(100);		
        this.contcurrentDaysPrice.setBoundLabelUnderline(true);		
        this.contcurrentDaysPrice.setVisible(true);
        // contactualAmt		
        this.contactualAmt.setBoundLabelText(resHelper.getString("contactualAmt.boundLabelText"));		
        this.contactualAmt.setBoundLabelLength(100);		
        this.contactualAmt.setBoundLabelUnderline(true);		
        this.contactualAmt.setVisible(true);
        // contpolicySafePrice		
        this.contpolicySafePrice.setBoundLabelText(resHelper.getString("contpolicySafePrice.boundLabelText"));		
        this.contpolicySafePrice.setBoundLabelLength(100);		
        this.contpolicySafePrice.setBoundLabelUnderline(true);		
        this.contpolicySafePrice.setVisible(true);
        // contsettlePolicy		
        this.contsettlePolicy.setBoundLabelText(resHelper.getString("contsettlePolicy.boundLabelText"));		
        this.contsettlePolicy.setBoundLabelLength(100);		
        this.contsettlePolicy.setBoundLabelUnderline(true);		
        this.contsettlePolicy.setVisible(true);
        // contchickenSzCoeff		
        this.contchickenSzCoeff.setBoundLabelText(resHelper.getString("contchickenSzCoeff.boundLabelText"));		
        this.contchickenSzCoeff.setBoundLabelLength(100);		
        this.contchickenSzCoeff.setBoundLabelUnderline(true);		
        this.contchickenSzCoeff.setVisible(true);
        // kDSeparator8
        // kDSeparator9
        // conthedgingPrice		
        this.conthedgingPrice.setBoundLabelText(resHelper.getString("conthedgingPrice.boundLabelText"));		
        this.conthedgingPrice.setBoundLabelLength(100);		
        this.conthedgingPrice.setBoundLabelUnderline(true);		
        this.conthedgingPrice.setVisible(true);
        // contfixedCoeff		
        this.contfixedCoeff.setBoundLabelText(resHelper.getString("contfixedCoeff.boundLabelText"));		
        this.contfixedCoeff.setBoundLabelLength(100);		
        this.contfixedCoeff.setBoundLabelUnderline(true);		
        this.contfixedCoeff.setVisible(true);
        // contshareCoeff		
        this.contshareCoeff.setBoundLabelText(resHelper.getString("contshareCoeff.boundLabelText"));		
        this.contshareCoeff.setBoundLabelLength(100);		
        this.contshareCoeff.setBoundLabelUnderline(true);		
        this.contshareCoeff.setVisible(true);
        // kDSeparator10
        // contawardPolicy		
        this.contawardPolicy.setBoundLabelText(resHelper.getString("contawardPolicy.boundLabelText"));		
        this.contawardPolicy.setBoundLabelLength(100);		
        this.contawardPolicy.setBoundLabelUnderline(true);		
        this.contawardPolicy.setVisible(true);
        // contyzjincrease		
        this.contyzjincrease.setBoundLabelText(resHelper.getString("contyzjincrease.boundLabelText"));		
        this.contyzjincrease.setBoundLabelLength(100);		
        this.contyzjincrease.setBoundLabelUnderline(true);		
        this.contyzjincrease.setVisible(true);
        // contchickenSource		
        this.contchickenSource.setBoundLabelText(resHelper.getString("contchickenSource.boundLabelText"));		
        this.contchickenSource.setBoundLabelLength(100);		
        this.contchickenSource.setBoundLabelUnderline(true);		
        this.contchickenSource.setVisible(true);
        // txtcontractSafePrice		
        this.txtcontractSafePrice.setVisible(true);		
        this.txtcontractSafePrice.setHorizontalAlignment(2);		
        this.txtcontractSafePrice.setDataType(1);		
        this.txtcontractSafePrice.setSupportedEmpty(true);		
        this.txtcontractSafePrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcontractSafePrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcontractSafePrice.setPrecision(4);		
        this.txtcontractSafePrice.setRequired(false);
        // txtpolicyProAmt		
        this.txtpolicyProAmt.setVisible(true);		
        this.txtpolicyProAmt.setHorizontalAlignment(2);		
        this.txtpolicyProAmt.setDataType(1);		
        this.txtpolicyProAmt.setSupportedEmpty(true);		
        this.txtpolicyProAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpolicyProAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpolicyProAmt.setPrecision(2);		
        this.txtpolicyProAmt.setRequired(false);
        // txtreceiveAmt		
        this.txtreceiveAmt.setVisible(true);		
        this.txtreceiveAmt.setHorizontalAlignment(2);		
        this.txtreceiveAmt.setDataType(1);		
        this.txtreceiveAmt.setSupportedEmpty(true);		
        this.txtreceiveAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtreceiveAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtreceiveAmt.setPrecision(2);		
        this.txtreceiveAmt.setRequired(false);
        // txtbasePrice		
        this.txtbasePrice.setVisible(true);		
        this.txtbasePrice.setHorizontalAlignment(2);		
        this.txtbasePrice.setDataType(1);		
        this.txtbasePrice.setSupportedEmpty(true);		
        this.txtbasePrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbasePrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbasePrice.setPrecision(4);		
        this.txtbasePrice.setRequired(false);
        txtbasePrice.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				txtbasePrice_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtcontractProAmt		
        this.txtcontractProAmt.setVisible(true);		
        this.txtcontractProAmt.setHorizontalAlignment(2);		
        this.txtcontractProAmt.setDataType(1);		
        this.txtcontractProAmt.setSupportedEmpty(true);		
        this.txtcontractProAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcontractProAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcontractProAmt.setPrecision(2);		
        this.txtcontractProAmt.setRequired(false);
        txtcontractProAmt.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				txtcontractProAmt_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtcurrentDaysPrice		
        this.txtcurrentDaysPrice.setVisible(true);		
        this.txtcurrentDaysPrice.setHorizontalAlignment(2);		
        this.txtcurrentDaysPrice.setDataType(1);		
        this.txtcurrentDaysPrice.setSupportedEmpty(true);		
        this.txtcurrentDaysPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcurrentDaysPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcurrentDaysPrice.setPrecision(4);		
        this.txtcurrentDaysPrice.setRequired(false);
        // txtactualAmt		
        this.txtactualAmt.setVisible(true);		
        this.txtactualAmt.setHorizontalAlignment(2);		
        this.txtactualAmt.setDataType(1);		
        this.txtactualAmt.setSupportedEmpty(true);		
        this.txtactualAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtactualAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtactualAmt.setPrecision(2);		
        this.txtactualAmt.setRequired(false);
        // txtpolicySafePrice		
        this.txtpolicySafePrice.setVisible(true);		
        this.txtpolicySafePrice.setHorizontalAlignment(2);		
        this.txtpolicySafePrice.setDataType(1);		
        this.txtpolicySafePrice.setSupportedEmpty(true);		
        this.txtpolicySafePrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpolicySafePrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpolicySafePrice.setPrecision(4);		
        this.txtpolicySafePrice.setRequired(false);		
        this.txtpolicySafePrice.setEnabled(false);
        // prmtsettlePolicy		
        this.prmtsettlePolicy.setQueryInfo("com.kingdee.eas.custom.taihe.settle.app.TaiHeSettlePolicyQuery");		
        this.prmtsettlePolicy.setVisible(true);		
        this.prmtsettlePolicy.setEditable(true);		
        this.prmtsettlePolicy.setDisplayFormat("$name$");		
        this.prmtsettlePolicy.setEditFormat("$number$");		
        this.prmtsettlePolicy.setCommitFormat("$number$");		
        this.prmtsettlePolicy.setRequired(true);
        // txtchickenSzCoeff		
        this.txtchickenSzCoeff.setVisible(true);		
        this.txtchickenSzCoeff.setHorizontalAlignment(2);		
        this.txtchickenSzCoeff.setDataType(1);		
        this.txtchickenSzCoeff.setSupportedEmpty(true);		
        this.txtchickenSzCoeff.setMinimumValue( new java.math.BigDecimal("-999.999"));		
        this.txtchickenSzCoeff.setMaximumValue( new java.math.BigDecimal("999.999"));		
        this.txtchickenSzCoeff.setPrecision(3);		
        this.txtchickenSzCoeff.setRequired(false);
        // txthedgingPrice		
        this.txthedgingPrice.setVisible(true);		
        this.txthedgingPrice.setHorizontalAlignment(2);		
        this.txthedgingPrice.setDataType(1);		
        this.txthedgingPrice.setSupportedEmpty(true);		
        this.txthedgingPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txthedgingPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txthedgingPrice.setPrecision(4);		
        this.txthedgingPrice.setRequired(false);
        txthedgingPrice.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				txthedgingPrice_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtfixedCoeff		
        this.txtfixedCoeff.setVisible(true);		
        this.txtfixedCoeff.setHorizontalAlignment(2);		
        this.txtfixedCoeff.setDataType(1);		
        this.txtfixedCoeff.setSupportedEmpty(true);		
        this.txtfixedCoeff.setMinimumValue( new java.math.BigDecimal("-999.999"));		
        this.txtfixedCoeff.setMaximumValue( new java.math.BigDecimal("999.999"));		
        this.txtfixedCoeff.setPrecision(3);		
        this.txtfixedCoeff.setRequired(false);
        txtfixedCoeff.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				txtfixedCoeff_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtshareCoeff		
        this.txtshareCoeff.setVisible(true);		
        this.txtshareCoeff.setHorizontalAlignment(2);		
        this.txtshareCoeff.setDataType(1);		
        this.txtshareCoeff.setSupportedEmpty(true);		
        this.txtshareCoeff.setMinimumValue( new java.math.BigDecimal("-999.999"));		
        this.txtshareCoeff.setMaximumValue( new java.math.BigDecimal("999.999"));		
        this.txtshareCoeff.setPrecision(3);		
        this.txtshareCoeff.setRequired(false);
        // prmtawardPolicy		
        this.prmtawardPolicy.setQueryInfo("com.kingdee.eas.custom.taihe.settle.app.SettleAwardPolicyQuery");		
        this.prmtawardPolicy.setVisible(true);		
        this.prmtawardPolicy.setEditable(true);		
        this.prmtawardPolicy.setDisplayFormat("$name$");		
        this.prmtawardPolicy.setEditFormat("$number$");		
        this.prmtawardPolicy.setCommitFormat("$number$");		
        this.prmtawardPolicy.setRequired(false);
        // txtyzjincrease		
        this.txtyzjincrease.setVisible(true);		
        this.txtyzjincrease.setHorizontalAlignment(2);		
        this.txtyzjincrease.setDataType(1);		
        this.txtyzjincrease.setSupportedEmpty(true);		
        this.txtyzjincrease.setMinimumValue( new java.math.BigDecimal("-3.4028234663852886E38"));		
        this.txtyzjincrease.setMaximumValue( new java.math.BigDecimal("3.4028234663852886E38"));		
        this.txtyzjincrease.setPrecision(10);		
        this.txtyzjincrease.setRequired(false);
        // txtchickenSource		
        this.txtchickenSource.setVisible(true);		
        this.txtchickenSource.setHorizontalAlignment(2);		
        this.txtchickenSource.setMaxLength(100);		
        this.txtchickenSource.setRequired(false);
        // btnDistribution
        this.btnDistribution.setAction((IItemAction)ActionProxyFactory.getProxy(actionDistribution, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnDistribution.setText(resHelper.getString("btnDistribution.text"));
        // btnClose
        this.btnClose.setAction((IItemAction)ActionProxyFactory.getProxy(actionClose, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnClose.setText(resHelper.getString("btnClose.text"));
        // btnBackClose
        this.btnBackClose.setAction((IItemAction)ActionProxyFactory.getProxy(actionBackClose, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnBackClose.setText(resHelper.getString("btnBackClose.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {chkisSuccessive,prmtcontractType,pkbeginDate,pkendDate,txtsuccessiveQty,txtpartyBCell,txtpartyBAddress,txtpartyBID,txtpartyBBank,txtpartyBAccount,prmtfarm,txtcapacity,feedType,pkinDate,txtinQty,txtoutDaysStd,txtdiffDays,pkrecycleBeginDate,pkrecycleEndDate,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,pkBizDate,txtNumber,txtpolicySafePrice,txtcontractSafePrice,txtcurrentDaysPrice,txtpolicyProAmt,txtcontractProAmt,txtreceiveAmt,txtactualAmt,pkauditTime,txtremark,billStatus,prmtcompany,txtbasePrice,prmtsupplier,prmtsuccessiveContract,prmtpurchasePerson,prmtsettlePolicy,txtchickenSzCoeff,txthedgingPrice,txtfixedCoeff,txtshareCoeff,prmtawardPolicy,txtfarmer,txtheaderCell,txtfarmAddress,chkwhetherClose,chkinitialization,txtinitialCumulativeQty,txtrecoveredQty,txtnonRecoveryQty,txtrecoveryRate,txtmManager,pkbuildDate,chkprohibitArea,chkwhetherRepeat,txtyzjincrease,txtchickenSource}));
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
        this.setBounds(new Rectangle(0, 0, 1017, 629));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1017, 629));
        contCreator.setBounds(new Rectangle(378, 577, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(378, 577, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(722, 577, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(722, 577, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(378, 602, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(378, 602, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(722, 602, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(722, 602, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(27, 12, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(27, 12, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(378, 12, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(378, 12, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(1000, 120, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(1000, 120, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(27, 577, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(27, 577, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(27, 602, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(27, 602, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(722, 12, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(722, 12, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkisSuccessive.setBounds(new Rectangle(27, 70, 95, 19));
        this.add(chkisSuccessive, new KDLayout.Constraints(27, 70, 95, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcontractType.setBounds(new Rectangle(27, 41, 270, 19));
        this.add(contcontractType, new KDLayout.Constraints(27, 41, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbeginDate.setBounds(new Rectangle(378, 41, 270, 19));
        this.add(contbeginDate, new KDLayout.Constraints(378, 41, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contendDate.setBounds(new Rectangle(979, 36, 270, 19));
        this.add(contendDate, new KDLayout.Constraints(979, 36, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contsuccessiveQty.setBounds(new Rectangle(836, 41, 155, 19));
        this.add(contsuccessiveQty, new KDLayout.Constraints(836, 41, 155, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfeedType.setBounds(new Rectangle(722, 70, 271, 19));
        this.add(contfeedType, new KDLayout.Constraints(722, 70, 271, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDTabbedPane1.setBounds(new Rectangle(20, 402, 976, 171));
        this.add(kDTabbedPane1, new KDLayout.Constraints(20, 402, 976, 171, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contsuccessiveContract.setBounds(new Rectangle(378, 70, 270, 19));
        this.add(contsuccessiveContract, new KDLayout.Constraints(378, 70, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane2.setBounds(new Rectangle(15, 104, 985, 288));
        this.add(kDTabbedPane2, new KDLayout.Constraints(15, 104, 985, 288, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kdtAllotEntry.setBounds(new Rectangle(1050, 305, 600, 170));
        kdtAllotEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtAllotEntry,new com.kingdee.eas.custom.taihe.contract.BatchContractAllotEntryInfo(),null,false);
        this.add(kdtAllotEntry_detailPanel, new KDLayout.Constraints(1050, 305, 600, 170, 0));
        chkwhetherClose.setBounds(new Rectangle(130, 70, 74, 19));
        this.add(chkwhetherClose, new KDLayout.Constraints(130, 70, 74, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkinitialization.setBounds(new Rectangle(213, 70, 96, 19));
        this.add(chkinitialization, new KDLayout.Constraints(213, 70, 96, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkwhetherRepeat.setBounds(new Rectangle(720, 45, 92, 19));
        this.add(chkwhetherRepeat, new KDLayout.Constraints(720, 45, 92, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //contcontractType
        contcontractType.setBoundEditor(prmtcontractType);
        //contbeginDate
        contbeginDate.setBoundEditor(pkbeginDate);
        //contendDate
        contendDate.setBoundEditor(pkendDate);
        //contsuccessiveQty
        contsuccessiveQty.setBoundEditor(txtsuccessiveQty);
        //contfeedType
        contfeedType.setBoundEditor(feedType);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 975, 138));        kdtEntry.setBounds(new Rectangle(0, 2, 968, 149));
        kdtEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntry,new com.kingdee.eas.custom.taihe.contract.BatchContractEntryInfo(),null,false);
        kDPanel1.add(kdtEntry_detailPanel, new KDLayout.Constraints(0, 2, 968, 149, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 975, 138));        txtremark.setBounds(new Rectangle(0, 1, 969, 151));
        kDPanel2.add(txtremark, new KDLayout.Constraints(0, 1, 969, 151, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contsuccessiveContract
        contsuccessiveContract.setBoundEditor(prmtsuccessiveContract);
        //kDTabbedPane2
        kDTabbedPane2.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        kDTabbedPane2.add(kDPanel4, resHelper.getString("kDPanel4.constraints"));
        //kDPanel3
        kDPanel3.setLayout(new KDLayout());
        kDPanel3.putClientProperty("OriginalBounds", new Rectangle(0, 0, 984, 255));        contsupplier.setBounds(new Rectangle(11, 8, 270, 19));
        kDPanel3.add(contsupplier, new KDLayout.Constraints(11, 8, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpartyBAddress.setBounds(new Rectangle(11, 35, 270, 19));
        kDPanel3.add(contpartyBAddress, new KDLayout.Constraints(11, 35, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarm.setBounds(new Rectangle(11, 62, 270, 19));
        kDPanel3.add(contfarm, new KDLayout.Constraints(11, 62, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcapacity.setBounds(new Rectangle(11, 89, 270, 19));
        kDPanel3.add(contcapacity, new KDLayout.Constraints(11, 89, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoutDaysStd.setBounds(new Rectangle(11, 170, 270, 19));
        kDPanel3.add(contoutDaysStd, new KDLayout.Constraints(11, 170, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contrecycleEndDate.setBounds(new Rectangle(362, 197, 270, 19));
        kDPanel3.add(contrecycleEndDate, new KDLayout.Constraints(362, 197, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdiffDays.setBounds(new Rectangle(362, 170, 270, 19));
        kDPanel3.add(contdiffDays, new KDLayout.Constraints(362, 170, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        continDate.setBounds(new Rectangle(11, 143, 270, 19));
        kDPanel3.add(continDate, new KDLayout.Constraints(11, 143, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpartyBCell.setBounds(new Rectangle(362, 35, 270, 19));
        kDPanel3.add(contpartyBCell, new KDLayout.Constraints(362, 35, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpartyBID.setBounds(new Rectangle(362, 8, 270, 19));
        kDPanel3.add(contpartyBID, new KDLayout.Constraints(362, 8, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpartyBBank.setBounds(new Rectangle(706, 8, 270, 19));
        kDPanel3.add(contpartyBBank, new KDLayout.Constraints(706, 8, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contpartyBAccount.setBounds(new Rectangle(706, 35, 270, 19));
        kDPanel3.add(contpartyBAccount, new KDLayout.Constraints(706, 35, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        continQty.setBounds(new Rectangle(362, 143, 270, 19));
        kDPanel3.add(continQty, new KDLayout.Constraints(362, 143, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contrecycleBeginDate.setBounds(new Rectangle(11, 197, 270, 19));
        kDPanel3.add(contrecycleBeginDate, new KDLayout.Constraints(11, 197, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompany.setBounds(new Rectangle(706, 143, 270, 19));
        kDPanel3.add(contcompany, new KDLayout.Constraints(706, 143, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contpurchasePerson.setBounds(new Rectangle(706, 89, 270, 19));
        kDPanel3.add(contpurchasePerson, new KDLayout.Constraints(706, 89, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfarmer.setBounds(new Rectangle(362, 62, 270, 19));
        kDPanel3.add(contfarmer, new KDLayout.Constraints(362, 62, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contheaderCell.setBounds(new Rectangle(706, 62, 270, 19));
        kDPanel3.add(contheaderCell, new KDLayout.Constraints(706, 62, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfarmAddress.setBounds(new Rectangle(362, 89, 270, 19));
        kDPanel3.add(contfarmAddress, new KDLayout.Constraints(362, 89, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        continitialCumulativeQty.setBounds(new Rectangle(706, 170, 270, 19));
        kDPanel3.add(continitialCumulativeQty, new KDLayout.Constraints(706, 170, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contrecoveredQty.setBounds(new Rectangle(11, 226, 270, 19));
        kDPanel3.add(contrecoveredQty, new KDLayout.Constraints(11, 226, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contnonRecoveryQty.setBounds(new Rectangle(362, 226, 270, 19));
        kDPanel3.add(contnonRecoveryQty, new KDLayout.Constraints(362, 226, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contrecoveryRate.setBounds(new Rectangle(706, 226, 270, 19));
        kDPanel3.add(contrecoveryRate, new KDLayout.Constraints(706, 226, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contmManager.setBounds(new Rectangle(11, 116, 270, 19));
        kDPanel3.add(contmManager, new KDLayout.Constraints(11, 116, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbuildDate.setBounds(new Rectangle(362, 116, 270, 19));
        kDPanel3.add(contbuildDate, new KDLayout.Constraints(362, 116, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkprohibitArea.setBounds(new Rectangle(706, 119, 270, 19));
        kDPanel3.add(chkprohibitArea, new KDLayout.Constraints(706, 119, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contsupplier
        contsupplier.setBoundEditor(prmtsupplier);
        //contpartyBAddress
        contpartyBAddress.setBoundEditor(txtpartyBAddress);
        //contfarm
        contfarm.setBoundEditor(prmtfarm);
        //contcapacity
        contcapacity.setBoundEditor(txtcapacity);
        //contoutDaysStd
        contoutDaysStd.setBoundEditor(txtoutDaysStd);
        //contrecycleEndDate
        contrecycleEndDate.setBoundEditor(pkrecycleEndDate);
        //contdiffDays
        contdiffDays.setBoundEditor(txtdiffDays);
        //continDate
        continDate.setBoundEditor(pkinDate);
        //contpartyBCell
        contpartyBCell.setBoundEditor(txtpartyBCell);
        //contpartyBID
        contpartyBID.setBoundEditor(txtpartyBID);
        //contpartyBBank
        contpartyBBank.setBoundEditor(txtpartyBBank);
        //contpartyBAccount
        contpartyBAccount.setBoundEditor(txtpartyBAccount);
        //continQty
        continQty.setBoundEditor(txtinQty);
        //contrecycleBeginDate
        contrecycleBeginDate.setBoundEditor(pkrecycleBeginDate);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contpurchasePerson
        contpurchasePerson.setBoundEditor(prmtpurchasePerson);
        //contfarmer
        contfarmer.setBoundEditor(txtfarmer);
        //contheaderCell
        contheaderCell.setBoundEditor(txtheaderCell);
        //contfarmAddress
        contfarmAddress.setBoundEditor(txtfarmAddress);
        //continitialCumulativeQty
        continitialCumulativeQty.setBoundEditor(txtinitialCumulativeQty);
        //contrecoveredQty
        contrecoveredQty.setBoundEditor(txtrecoveredQty);
        //contnonRecoveryQty
        contnonRecoveryQty.setBoundEditor(txtnonRecoveryQty);
        //contrecoveryRate
        contrecoveryRate.setBoundEditor(txtrecoveryRate);
        //contmManager
        contmManager.setBoundEditor(txtmManager);
        //contbuildDate
        contbuildDate.setBoundEditor(pkbuildDate);
        //kDPanel4
        kDPanel4.setLayout(new KDLayout());
        kDPanel4.putClientProperty("OriginalBounds", new Rectangle(0, 0, 984, 255));        contcontractSafePrice.setBounds(new Rectangle(20, 64, 270, 19));
        kDPanel4.add(contcontractSafePrice, new KDLayout.Constraints(20, 64, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpolicyProAmt.setBounds(new Rectangle(360, 176, 270, 19));
        kDPanel4.add(contpolicyProAmt, new KDLayout.Constraints(360, 176, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contreceiveAmt.setBounds(new Rectangle(20, 210, 270, 19));
        kDPanel4.add(contreceiveAmt, new KDLayout.Constraints(20, 210, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbasePrice.setBounds(new Rectangle(20, 112, 270, 19));
        kDPanel4.add(contbasePrice, new KDLayout.Constraints(20, 112, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcontractProAmt.setBounds(new Rectangle(20, 176, 270, 19));
        kDPanel4.add(contcontractProAmt, new KDLayout.Constraints(20, 176, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcurrentDaysPrice.setBounds(new Rectangle(700, 176, 270, 19));
        kDPanel4.add(contcurrentDaysPrice, new KDLayout.Constraints(700, 176, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contactualAmt.setBounds(new Rectangle(360, 210, 270, 19));
        kDPanel4.add(contactualAmt, new KDLayout.Constraints(360, 210, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpolicySafePrice.setBounds(new Rectangle(360, 64, 270, 19));
        kDPanel4.add(contpolicySafePrice, new KDLayout.Constraints(360, 64, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsettlePolicy.setBounds(new Rectangle(20, 18, 270, 19));
        kDPanel4.add(contsettlePolicy, new KDLayout.Constraints(20, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contchickenSzCoeff.setBounds(new Rectangle(700, 18, 270, 19));
        kDPanel4.add(contchickenSzCoeff, new KDLayout.Constraints(700, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator8.setBounds(new Rectangle(12, 50, 952, 10));
        kDPanel4.add(kDSeparator8, new KDLayout.Constraints(12, 50, 952, 10, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator9.setBounds(new Rectangle(12, 100, 958, 10));
        kDPanel4.add(kDSeparator9, new KDLayout.Constraints(12, 100, 958, 10, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        conthedgingPrice.setBounds(new Rectangle(360, 114, 270, 19));
        kDPanel4.add(conthedgingPrice, new KDLayout.Constraints(360, 114, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfixedCoeff.setBounds(new Rectangle(700, 116, 270, 19));
        kDPanel4.add(contfixedCoeff, new KDLayout.Constraints(700, 116, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contshareCoeff.setBounds(new Rectangle(20, 140, 270, 19));
        kDPanel4.add(contshareCoeff, new KDLayout.Constraints(20, 140, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator10.setBounds(new Rectangle(12, 167, 953, 10));
        kDPanel4.add(kDSeparator10, new KDLayout.Constraints(12, 167, 953, 10, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contawardPolicy.setBounds(new Rectangle(360, 18, 270, 19));
        kDPanel4.add(contawardPolicy, new KDLayout.Constraints(360, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contyzjincrease.setBounds(new Rectangle(700, 61, 270, 19));
        kDPanel4.add(contyzjincrease, new KDLayout.Constraints(700, 61, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contchickenSource.setBounds(new Rectangle(700, 207, 270, 19));
        kDPanel4.add(contchickenSource, new KDLayout.Constraints(700, 207, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contcontractSafePrice
        contcontractSafePrice.setBoundEditor(txtcontractSafePrice);
        //contpolicyProAmt
        contpolicyProAmt.setBoundEditor(txtpolicyProAmt);
        //contreceiveAmt
        contreceiveAmt.setBoundEditor(txtreceiveAmt);
        //contbasePrice
        contbasePrice.setBoundEditor(txtbasePrice);
        //contcontractProAmt
        contcontractProAmt.setBoundEditor(txtcontractProAmt);
        //contcurrentDaysPrice
        contcurrentDaysPrice.setBoundEditor(txtcurrentDaysPrice);
        //contactualAmt
        contactualAmt.setBoundEditor(txtactualAmt);
        //contpolicySafePrice
        contpolicySafePrice.setBoundEditor(txtpolicySafePrice);
        //contsettlePolicy
        contsettlePolicy.setBoundEditor(prmtsettlePolicy);
        //contchickenSzCoeff
        contchickenSzCoeff.setBoundEditor(txtchickenSzCoeff);
        //conthedgingPrice
        conthedgingPrice.setBoundEditor(txthedgingPrice);
        //contfixedCoeff
        contfixedCoeff.setBoundEditor(txtfixedCoeff);
        //contshareCoeff
        contshareCoeff.setBoundEditor(txtshareCoeff);
        //contawardPolicy
        contawardPolicy.setBoundEditor(prmtawardPolicy);
        //contyzjincrease
        contyzjincrease.setBoundEditor(txtyzjincrease);
        //contchickenSource
        contchickenSource.setBoundEditor(txtchickenSource);

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
        menuBiz.add(mBtnAudit);
        menuBiz.add(mBtnUnAudit);
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        menuBiz.add(MenuItemVoucher);
        menuBiz.add(MenuItemPCVoucher);
        menuBiz.add(menuItemDelVoucher);
        menuBiz.add(menuItemDelPCVoucher);
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
        this.toolBar.add(tBtnAudit);
        this.toolBar.add(tBtnUnAudit);
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
        this.toolBar.add(btnPCVoucher);
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnDelPCVoucher);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(btnNextPerson);
        this.toolBar.add(btnDistribution);
        this.toolBar.add(btnClose);
        this.toolBar.add(btnBackClose);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("isSuccessive", boolean.class, this.chkisSuccessive, "selected");
		dataBinder.registerBinding("AllotEntry.seq", int.class, this.kdtAllotEntry, "seq.text");
		dataBinder.registerBinding("AllotEntry", com.kingdee.eas.custom.taihe.contract.BatchContractAllotEntryInfo.class, this.kdtAllotEntry, "userObject");
		dataBinder.registerBinding("AllotEntry.allotUser", java.lang.Object.class, this.kdtAllotEntry, "allotUser.text");
		dataBinder.registerBinding("AllotEntry.allotTime", java.util.Date.class, this.kdtAllotEntry, "allotTime.text");
		dataBinder.registerBinding("AllotEntry.allotOrg", java.lang.Object.class, this.kdtAllotEntry, "allotOrg.text");
		dataBinder.registerBinding("whetherClose", boolean.class, this.chkwhetherClose, "selected");
		dataBinder.registerBinding("initialization", boolean.class, this.chkinitialization, "selected");
		dataBinder.registerBinding("whetherRepeat", boolean.class, this.chkwhetherRepeat, "selected");
		dataBinder.registerBinding("contractType", com.kingdee.eas.custom.signwasthetable.ContractTypeInfo.class, this.prmtcontractType, "data");
		dataBinder.registerBinding("beginDate", java.util.Date.class, this.pkbeginDate, "value");
		dataBinder.registerBinding("endDate", java.util.Date.class, this.pkendDate, "value");
		dataBinder.registerBinding("successiveQty", java.math.BigDecimal.class, this.txtsuccessiveQty, "value");
		dataBinder.registerBinding("feedType", com.kingdee.eas.custom.taihe.contract.FeedType.class, this.feedType, "selectedItem");
		dataBinder.registerBinding("Entry.seq", int.class, this.kdtEntry, "seq.text");
		dataBinder.registerBinding("Entry", com.kingdee.eas.custom.taihe.contract.BatchContractEntryInfo.class, this.kdtEntry, "userObject");
		dataBinder.registerBinding("Entry.receiveBill", java.lang.Object.class, this.kdtEntry, "receiveBill.text");
		dataBinder.registerBinding("Entry.receiveBillAmt", java.math.BigDecimal.class, this.kdtEntry, "receiveBillAmt.text");
		dataBinder.registerBinding("Entry.usedAmt", java.math.BigDecimal.class, this.kdtEntry, "usedAmt.text");
		dataBinder.registerBinding("Entry.currentAmt", java.math.BigDecimal.class, this.kdtEntry, "currentAmt.text");
		dataBinder.registerBinding("remark", String.class, this.txtremark, "text");
		dataBinder.registerBinding("successiveContract", com.kingdee.eas.custom.taihe.contract.SuccessiveContractInfo.class, this.prmtsuccessiveContract, "data");
		dataBinder.registerBinding("prohibitArea", boolean.class, this.chkprohibitArea, "selected");
		dataBinder.registerBinding("supplier", com.kingdee.eas.bdm.bdapply.SupplierReqInfo.class, this.prmtsupplier, "data");
		dataBinder.registerBinding("partyBAddress", String.class, this.txtpartyBAddress, "text");
		dataBinder.registerBinding("farm", com.kingdee.eas.farm.stocking.basedata.FarmInfo.class, this.prmtfarm, "data");
		dataBinder.registerBinding("capacity", java.math.BigDecimal.class, this.txtcapacity, "value");
		dataBinder.registerBinding("outDaysStd", int.class, this.txtoutDaysStd, "value");
		dataBinder.registerBinding("recycleEndDate", java.util.Date.class, this.pkrecycleEndDate, "value");
		dataBinder.registerBinding("diffDays", int.class, this.txtdiffDays, "value");
		dataBinder.registerBinding("inDate", java.util.Date.class, this.pkinDate, "value");
		dataBinder.registerBinding("partyBCell", String.class, this.txtpartyBCell, "text");
		dataBinder.registerBinding("partyBID", String.class, this.txtpartyBID, "text");
		dataBinder.registerBinding("partyBBank", String.class, this.txtpartyBBank, "text");
		dataBinder.registerBinding("partyBAccount", String.class, this.txtpartyBAccount, "text");
		dataBinder.registerBinding("inQty", java.math.BigDecimal.class, this.txtinQty, "value");
		dataBinder.registerBinding("recycleBeginDate", java.util.Date.class, this.pkrecycleBeginDate, "value");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("purchasePerson", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtpurchasePerson, "data");
		dataBinder.registerBinding("farmer", String.class, this.txtfarmer, "text");
		dataBinder.registerBinding("headerCell", String.class, this.txtheaderCell, "text");
		dataBinder.registerBinding("farmAddress", String.class, this.txtfarmAddress, "text");
		dataBinder.registerBinding("initialCumulativeQty", java.math.BigDecimal.class, this.txtinitialCumulativeQty, "value");
		dataBinder.registerBinding("recoveredQty", java.math.BigDecimal.class, this.txtrecoveredQty, "value");
		dataBinder.registerBinding("nonRecoveryQty", java.math.BigDecimal.class, this.txtnonRecoveryQty, "value");
		dataBinder.registerBinding("recoveryRate", String.class, this.txtrecoveryRate, "text");
		dataBinder.registerBinding("mManager", String.class, this.txtmManager, "text");
		dataBinder.registerBinding("buildDate", java.util.Date.class, this.pkbuildDate, "value");
		dataBinder.registerBinding("contractSafePrice", java.math.BigDecimal.class, this.txtcontractSafePrice, "value");
		dataBinder.registerBinding("policyProAmt", java.math.BigDecimal.class, this.txtpolicyProAmt, "value");
		dataBinder.registerBinding("receiveAmt", java.math.BigDecimal.class, this.txtreceiveAmt, "value");
		dataBinder.registerBinding("basePrice", java.math.BigDecimal.class, this.txtbasePrice, "value");
		dataBinder.registerBinding("contractProAmt", java.math.BigDecimal.class, this.txtcontractProAmt, "value");
		dataBinder.registerBinding("currentDaysPrice", java.math.BigDecimal.class, this.txtcurrentDaysPrice, "value");
		dataBinder.registerBinding("actualAmt", java.math.BigDecimal.class, this.txtactualAmt, "value");
		dataBinder.registerBinding("policySafePrice", java.math.BigDecimal.class, this.txtpolicySafePrice, "value");
		dataBinder.registerBinding("settlePolicy", com.kingdee.eas.custom.taihe.settle.TaiHeSettlePolicyInfo.class, this.prmtsettlePolicy, "data");
		dataBinder.registerBinding("chickenSzCoeff", java.math.BigDecimal.class, this.txtchickenSzCoeff, "value");
		dataBinder.registerBinding("hedgingPrice", java.math.BigDecimal.class, this.txthedgingPrice, "value");
		dataBinder.registerBinding("fixedCoeff", java.math.BigDecimal.class, this.txtfixedCoeff, "value");
		dataBinder.registerBinding("shareCoeff", java.math.BigDecimal.class, this.txtshareCoeff, "value");
		dataBinder.registerBinding("awardPolicy", com.kingdee.eas.custom.taihe.settle.SettleAwardPolicyInfo.class, this.prmtawardPolicy, "data");
		dataBinder.registerBinding("yzjincrease", java.math.BigDecimal.class, this.txtyzjincrease, "value");
		dataBinder.registerBinding("chickenSource", String.class, this.txtchickenSource, "text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.taihe.contract.app.BatchContractEditUIHandler";
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
        this.chkisSuccessive.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.taihe.contract.BatchContractInfo)ov;
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
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isSuccessive", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AllotEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AllotEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AllotEntry.allotUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AllotEntry.allotTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AllotEntry.allotOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("whetherClose", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("initialization", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("whetherRepeat", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contractType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("beginDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("endDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("successiveQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("feedType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.receiveBill", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.receiveBillAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.usedAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.currentAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("successiveContract", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("prohibitArea", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("supplier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("partyBAddress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("capacity", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("outDaysStd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("recycleEndDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("diffDays", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("inDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("partyBCell", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("partyBID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("partyBBank", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("partyBAccount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("inQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("recycleBeginDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("purchasePerson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("headerCell", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmAddress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("initialCumulativeQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("recoveredQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("nonRecoveryQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("recoveryRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mManager", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("buildDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contractSafePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("policyProAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("receiveAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("basePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contractProAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("currentDaysPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("actualAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("policySafePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("settlePolicy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenSzCoeff", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hedgingPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fixedCoeff", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("shareCoeff", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("awardPolicy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yzjincrease", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenSource", ValidateHelper.ON_SAVE);    		
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
     * output prmtsuccessiveContract_Changed() method
     */
    public void prmtsuccessiveContract_Changed() throws Exception
    {
        System.out.println("prmtsuccessiveContract_Changed() Function is executed!");
            prmtcontractType.setData(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtsuccessiveContract.getData(),"contractType"));
pkbeginDate.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getDateValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtsuccessiveContract.getData(),"beginDate")));
pkendDate.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getDateValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtsuccessiveContract.getData(),"endDate")));
prmtfarm.setData(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtsuccessiveContract.getData(),"farm"));
txtpartyBCell.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtsuccessiveContract.getData(),"partyBCell")));
txtpartyBAddress.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtsuccessiveContract.getData(),"partyBAddress")));
txtpartyBID.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtsuccessiveContract.getData(),"partyBID")));
txtpartyBBank.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtsuccessiveContract.getData(),"partyBBank")));
txtpartyBAccount.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtsuccessiveContract.getData(),"partyBBankNo")));
txtcapacity.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtsuccessiveContract.getData(),"capacity")));
feedType.setSelectedItem(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtsuccessiveContract.getData(),"feedingType"));
pkinDate.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getDateValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtsuccessiveContract.getData(),"upSeedingDate")));
txtinQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtsuccessiveContract.getData(),"upSeedingQty")));
prmtsettlePolicy.setData(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtsuccessiveContract.getData(),"statementPolicy"));
txtoutDaysStd.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtsuccessiveContract.getData(),"days")));
txtdiffDays.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtsuccessiveContract.getData(),"diffDays")));
prmtpurchasePerson.setData(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtsuccessiveContract.getData(),"purchasePerson"));
prmtsupplier.setData(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtsuccessiveContract.getData(),"Supplier"));
txtheaderCell.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtsuccessiveContract.getData(),"headerCell")));
txtpolicySafePrice.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtsuccessiveContract.getData(),"policyMinimum")));
txtcontractSafePrice.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtsuccessiveContract.getData(),"contractMinimum")));
txtpolicyProAmt.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtsuccessiveContract.getData(),"singleSecurityDeposit")));

    txtyzjincrease.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtsuccessiveContract.getData(),"yzjincrease")));


    }

    /**
     * output prmtfarm_Changed() method
     */
    public void prmtfarm_Changed() throws Exception
    {
        System.out.println("prmtfarm_Changed() Function is executed!");
            txtcapacity.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtfarm.getData(),"capacity")));

    txtfarmer.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtfarm.getData(),"theHeader")));

    txtheaderCell.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtfarm.getData(),"telePhone")));

    txtfarmAddress.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtfarm.getData(),"address")));

    txtmManager.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtfarm.getData(),"mManager.name")));

    pkbuildDate.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getDateValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtfarm.getData(),"buildDate")));

    chkprohibitArea.setSelected(com.kingdee.bos.ui.face.UIRuleUtil.getBooleanValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtfarm.getData(),"prohibitArea")));

    prmtsupplier.setData(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtfarm.getData(),"supplier"));


    }

    /**
     * output txtinQty_Changed() method
     */
    public void txtinQty_Changed() throws Exception
    {
        System.out.println("txtinQty_Changed() Function is executed!");
            txtreceiveAmt.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtcontractProAmt.getValue())* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtinQty.getValue())));


    }

    /**
     * output txtbasePrice_Changed() method
     */
    public void txtbasePrice_Changed() throws Exception
    {
        System.out.println("txtbasePrice_Changed() Function is executed!");
            txtcurrentDaysPrice.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtfixedCoeff.getValue())- ((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtbasePrice.getValue())- com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txthedgingPrice.getValue()))* 5)));


    }

    /**
     * output txtcontractProAmt_Changed() method
     */
    public void txtcontractProAmt_Changed() throws Exception
    {
        System.out.println("txtcontractProAmt_Changed() Function is executed!");
            txtreceiveAmt.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtcontractProAmt.getValue())* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtinQty.getValue())));


    }

    /**
     * output txthedgingPrice_Changed() method
     */
    public void txthedgingPrice_Changed() throws Exception
    {
        System.out.println("txthedgingPrice_Changed() Function is executed!");
            txtcurrentDaysPrice.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtfixedCoeff.getValue())- ((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtbasePrice.getValue())- com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txthedgingPrice.getValue()))* 5)));


    }

    /**
     * output txtfixedCoeff_Changed() method
     */
    public void txtfixedCoeff_Changed() throws Exception
    {
        System.out.println("txtfixedCoeff_Changed() Function is executed!");
            txtcurrentDaysPrice.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtfixedCoeff.getValue())- ((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtbasePrice.getValue())- com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txthedgingPrice.getValue()))* 5)));
txtcurrentDaysPrice.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtfixedCoeff.getValue())- ((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtbasePrice.getValue())- com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txthedgingPrice.getValue()))* 5)));


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
        sic.add(new SelectorItemInfo("bizDate"));
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
        sic.add(new SelectorItemInfo("billStatus"));
        sic.add(new SelectorItemInfo("isSuccessive"));
    	sic.add(new SelectorItemInfo("AllotEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("AllotEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("AllotEntry.allotUser.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("AllotEntry.allotUser.id"));
			sic.add(new SelectorItemInfo("AllotEntry.allotUser.number"));
			sic.add(new SelectorItemInfo("AllotEntry.allotUser.name"));
		}
    	sic.add(new SelectorItemInfo("AllotEntry.allotTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("AllotEntry.allotOrg.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("AllotEntry.allotOrg.id"));
			sic.add(new SelectorItemInfo("AllotEntry.allotOrg.name"));
        	sic.add(new SelectorItemInfo("AllotEntry.allotOrg.number"));
		}
        sic.add(new SelectorItemInfo("whetherClose"));
        sic.add(new SelectorItemInfo("initialization"));
        sic.add(new SelectorItemInfo("whetherRepeat"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("contractType.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("contractType.id"));
        	sic.add(new SelectorItemInfo("contractType.number"));
        	sic.add(new SelectorItemInfo("contractType.name"));
		}
        sic.add(new SelectorItemInfo("beginDate"));
        sic.add(new SelectorItemInfo("endDate"));
        sic.add(new SelectorItemInfo("successiveQty"));
        sic.add(new SelectorItemInfo("feedType"));
    	sic.add(new SelectorItemInfo("Entry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.receiveBill.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entry.receiveBill.id"));
			sic.add(new SelectorItemInfo("Entry.receiveBill.number"));
		}
    	sic.add(new SelectorItemInfo("Entry.receiveBillAmt"));
    	sic.add(new SelectorItemInfo("Entry.usedAmt"));
    	sic.add(new SelectorItemInfo("Entry.currentAmt"));
        sic.add(new SelectorItemInfo("remark"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("successiveContract.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("successiveContract.id"));
        	sic.add(new SelectorItemInfo("successiveContract.number"));
		}
        sic.add(new SelectorItemInfo("prohibitArea"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("supplier.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("supplier.id"));
        	sic.add(new SelectorItemInfo("supplier.number"));
        	sic.add(new SelectorItemInfo("supplier.name"));
		}
        sic.add(new SelectorItemInfo("partyBAddress"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("farm.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farm.id"));
        	sic.add(new SelectorItemInfo("farm.number"));
        	sic.add(new SelectorItemInfo("farm.name"));
		}
        sic.add(new SelectorItemInfo("capacity"));
        sic.add(new SelectorItemInfo("outDaysStd"));
        sic.add(new SelectorItemInfo("recycleEndDate"));
        sic.add(new SelectorItemInfo("diffDays"));
        sic.add(new SelectorItemInfo("inDate"));
        sic.add(new SelectorItemInfo("partyBCell"));
        sic.add(new SelectorItemInfo("partyBID"));
        sic.add(new SelectorItemInfo("partyBBank"));
        sic.add(new SelectorItemInfo("partyBAccount"));
        sic.add(new SelectorItemInfo("inQty"));
        sic.add(new SelectorItemInfo("recycleBeginDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("purchasePerson.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("purchasePerson.id"));
        	sic.add(new SelectorItemInfo("purchasePerson.number"));
        	sic.add(new SelectorItemInfo("purchasePerson.name"));
		}
        sic.add(new SelectorItemInfo("farmer"));
        sic.add(new SelectorItemInfo("headerCell"));
        sic.add(new SelectorItemInfo("farmAddress"));
        sic.add(new SelectorItemInfo("initialCumulativeQty"));
        sic.add(new SelectorItemInfo("recoveredQty"));
        sic.add(new SelectorItemInfo("nonRecoveryQty"));
        sic.add(new SelectorItemInfo("recoveryRate"));
        sic.add(new SelectorItemInfo("mManager"));
        sic.add(new SelectorItemInfo("buildDate"));
        sic.add(new SelectorItemInfo("contractSafePrice"));
        sic.add(new SelectorItemInfo("policyProAmt"));
        sic.add(new SelectorItemInfo("receiveAmt"));
        sic.add(new SelectorItemInfo("basePrice"));
        sic.add(new SelectorItemInfo("contractProAmt"));
        sic.add(new SelectorItemInfo("currentDaysPrice"));
        sic.add(new SelectorItemInfo("actualAmt"));
        sic.add(new SelectorItemInfo("policySafePrice"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("settlePolicy.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("settlePolicy.id"));
        	sic.add(new SelectorItemInfo("settlePolicy.number"));
        	sic.add(new SelectorItemInfo("settlePolicy.name"));
		}
        sic.add(new SelectorItemInfo("chickenSzCoeff"));
        sic.add(new SelectorItemInfo("hedgingPrice"));
        sic.add(new SelectorItemInfo("fixedCoeff"));
        sic.add(new SelectorItemInfo("shareCoeff"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("awardPolicy.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("awardPolicy.id"));
        	sic.add(new SelectorItemInfo("awardPolicy.number"));
        	sic.add(new SelectorItemInfo("awardPolicy.name"));
		}
        sic.add(new SelectorItemInfo("yzjincrease"));
        sic.add(new SelectorItemInfo("chickenSource"));
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
     * output actionDistribution_actionPerformed method
     */
    public void actionDistribution_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.taihe.contract.BatchContractFactory.getRemoteInstance().distribution(editData);
    }
    	

    /**
     * output actionClose_actionPerformed method
     */
    public void actionClose_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.taihe.contract.BatchContractFactory.getRemoteInstance().close(editData);
    }
    	

    /**
     * output actionBackClose_actionPerformed method
     */
    public void actionBackClose_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.taihe.contract.BatchContractFactory.getRemoteInstance().backClose(editData);
    }
    	

    /**
     * output actionAllAudit_actionPerformed method
     */
    public void actionAllAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.taihe.contract.BatchContractFactory.getRemoteInstance().allAudit(editData);
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
	public RequestContext prepareActionDistribution(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionDistribution() {
    	return false;
    }
	public RequestContext prepareActionClose(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionClose() {
    	return false;
    }
	public RequestContext prepareActionBackClose(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionBackClose() {
    	return false;
    }
	public RequestContext prepareActionAllAudit(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAllAudit() {
    	return false;
    }

    /**
     * output ActionDistribution class
     */     
    protected class ActionDistribution extends ItemAction {     
    
        public ActionDistribution()
        {
            this(null);
        }

        public ActionDistribution(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionDistribution.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionDistribution.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionDistribution.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractBatchContractEditUI.this, "ActionDistribution", "actionDistribution_actionPerformed", e);
        }
    }

    /**
     * output ActionClose class
     */     
    protected class ActionClose extends ItemAction {     
    
        public ActionClose()
        {
            this(null);
        }

        public ActionClose(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionClose.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionClose.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionClose.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractBatchContractEditUI.this, "ActionClose", "actionClose_actionPerformed", e);
        }
    }

    /**
     * output ActionBackClose class
     */     
    protected class ActionBackClose extends ItemAction {     
    
        public ActionBackClose()
        {
            this(null);
        }

        public ActionBackClose(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionBackClose.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionBackClose.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionBackClose.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractBatchContractEditUI.this, "ActionBackClose", "actionBackClose_actionPerformed", e);
        }
    }

    /**
     * output ActionAllAudit class
     */     
    protected class ActionAllAudit extends ItemAction {     
    
        public ActionAllAudit()
        {
            this(null);
        }

        public ActionAllAudit(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionAllAudit.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAllAudit.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAllAudit.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractBatchContractEditUI.this, "ActionAllAudit", "actionAllAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.taihe.contract.client", "BatchContractEditUI");
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
        return com.kingdee.eas.custom.taihe.contract.client.BatchContractEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.taihe.contract.BatchContractFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.taihe.contract.BatchContractInfo objectValue = new com.kingdee.eas.custom.taihe.contract.BatchContractInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/taihe/contract/BatchContract";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.taihe.contract.app.BatchContractQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcontractType.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"合同类型"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkbeginDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"签订开始日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkinDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"上苗日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtinQty.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"上苗数量"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtpurchasePerson.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"原料员"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtfarmAddress.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖场地址"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtsettlePolicy.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"结算政策"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtEntry;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("feedType","0");
		vo.put("outDaysStd",new Integer(39));
		vo.put("diffDays",new Integer(2));
		vo.put("contractSafePrice",new java.math.BigDecimal(0));
		vo.put("policyProAmt",new java.math.BigDecimal(0));
		vo.put("receiveAmt",new java.math.BigDecimal(0));
		vo.put("basePrice",new java.math.BigDecimal(0));
		vo.put("contractProAmt",new java.math.BigDecimal(0));
		vo.put("currentDaysPrice",new java.math.BigDecimal(0));
		vo.put("actualAmt",new java.math.BigDecimal(0));
		vo.put("policySafePrice",new java.math.BigDecimal(0));
		vo.put("chickenSzCoeff",new java.math.BigDecimal(0));
		vo.put("hedgingPrice",new java.math.BigDecimal(0));
		vo.put("fixedCoeff",new java.math.BigDecimal(0));
		vo.put("shareCoeff",new java.math.BigDecimal(0));
		vo.put("yzjincrease",new java.math.BigDecimal(0));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}