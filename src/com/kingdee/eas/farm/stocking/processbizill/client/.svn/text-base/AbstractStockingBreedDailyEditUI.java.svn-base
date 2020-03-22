/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

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
public abstract class AbstractStockingBreedDailyEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractStockingBreedDailyEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kdTabPanelMain;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoutSideTFrom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoutSideTTo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweather;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoutHumidityFrom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoutHumidityTo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfuel;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweek;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweekDay;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel1;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contelectricityQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcoalFual;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdieselFual;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstockingBatch;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator9;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttransInQty;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisInit;
    protected com.kingdee.bos.ctrl.swing.KDLabel lblDayAge;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnowBreedStage;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbizPerson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsumWeekDay;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcurrentCostObject;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisBreed;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkpreEgg;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisMature;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisAdjust;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkmaleOut;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkfemaleOut;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkdrugOut;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkimmuneOut;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkmaterialOut;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkqualityEggOut;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkunQualityEggOut;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanelFeed;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanelBreed;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanelEgg;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanelSendEgg;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanelDrug;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanelEnvi;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanelTrans;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanelLog;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtAssEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtAssEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEggEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEggEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtSendEggEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtSendEggEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtImmuneEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtImmuneEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtDrugEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtDrugEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEnvi;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEnvi_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtTransEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtTransEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedLog;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane scrollPanebreedLog;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtbreedLog;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtMatUserEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtMatUserEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoutSideTFrom;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoutSideTTo;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtweather;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoutHumidityFrom;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoutHumidityTo;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfuel;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtweek;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtweekDay;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtelectricityQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcoalFual;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdieselFual;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarm;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstockingBatch;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttransInQty;
    protected com.kingdee.bos.ctrl.swing.KDComboBox nowBreedStage;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbizPerson;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtsumWeekDay;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcurrentCostObject;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnGenNextBill;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionGenNextBill actionGenNextBill = null;
    protected ActionReShareCoalAndDiesel actionReShareCoalAndDiesel = null;
    /**
     * output class constructor
     */
    public AbstractStockingBreedDailyEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractStockingBreedDailyEditUI.class.getName());
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
        this.actionAudit.setExtendProperty("userDefined", "true");
        this.actionAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionUnAudit
        this.actionUnAudit = new ActionUnAudit(this);
        getActionManager().registerAction("actionUnAudit", actionUnAudit);
        this.actionUnAudit.setBindWorkFlow(true);
        this.actionUnAudit.setExtendProperty("canForewarn", "true");
        this.actionUnAudit.setExtendProperty("userDefined", "true");
        this.actionUnAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionGenNextBill
        this.actionGenNextBill = new ActionGenNextBill(this);
        getActionManager().registerAction("actionGenNextBill", actionGenNextBill);
        this.actionGenNextBill.setBindWorkFlow(true);
        this.actionGenNextBill.setExtendProperty("canForewarn", "true");
        this.actionGenNextBill.setExtendProperty("userDefined", "true");
        this.actionGenNextBill.setExtendProperty("isObjectUpdateLock", "false");
         this.actionGenNextBill.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionGenNextBill.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionGenNextBill.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionReShareCoalAndDiesel
        this.actionReShareCoalAndDiesel = new ActionReShareCoalAndDiesel(this);
        getActionManager().registerAction("actionReShareCoalAndDiesel", actionReShareCoalAndDiesel);
        this.actionReShareCoalAndDiesel.setExtendProperty("canForewarn", "true");
        this.actionReShareCoalAndDiesel.setExtendProperty("userDefined", "true");
        this.actionReShareCoalAndDiesel.setExtendProperty("isObjectUpdateLock", "false");
         this.actionReShareCoalAndDiesel.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionReShareCoalAndDiesel.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdTabPanelMain = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoutSideTFrom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoutSideTTo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweather = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoutHumidityFrom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoutHumidityTo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfuel = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweek = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweekDay = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabel1 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDLabel2 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.contelectricityQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcoalFual = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdieselFual = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contfarmer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstockingBatch = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator9 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.conttransInQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisInit = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.lblDayAge = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.contnowBreedStage = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbizPerson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsumWeekDay = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcurrentCostObject = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisBreed = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkpreEgg = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisMature = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisAdjust = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkmaleOut = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkfemaleOut = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkdrugOut = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkimmuneOut = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkmaterialOut = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkqualityEggOut = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkunQualityEggOut = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanelFeed = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanelBreed = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanelEgg = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanelSendEgg = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanelDrug = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanelEnvi = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanelTrans = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanelLog = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtAssEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtEggEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtSendEggEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtImmuneEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtDrugEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtEnvi = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtTransEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contbreedLog = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.scrollPanebreedLog = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txtbreedLog = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.kdtMatUserEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtoutSideTFrom = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtoutSideTTo = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtweather = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtoutHumidityFrom = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtoutHumidityTo = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtfuel = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtweek = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtweekDay = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtelectricityQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcoalFual = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdieselFual = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtfarmer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtfarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtstockingBatch = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txttransInQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.nowBreedStage = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtbizPerson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtsumWeekDay = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtcurrentCostObject = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.tBtnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnGenNextBill = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.mBtnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.mBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.kdTabPanelMain.setName("kdTabPanelMain");
        this.contbaseStatus.setName("contbaseStatus");
        this.contoutSideTFrom.setName("contoutSideTFrom");
        this.contoutSideTTo.setName("contoutSideTTo");
        this.contweather.setName("contweather");
        this.contoutHumidityFrom.setName("contoutHumidityFrom");
        this.contoutHumidityTo.setName("contoutHumidityTo");
        this.contauditTime.setName("contauditTime");
        this.contfuel.setName("contfuel");
        this.contweek.setName("contweek");
        this.contweekDay.setName("contweekDay");
        this.kDLabel1.setName("kDLabel1");
        this.kDLabel2.setName("kDLabel2");
        this.contelectricityQty.setName("contelectricityQty");
        this.contcoalFual.setName("contcoalFual");
        this.contdieselFual.setName("contdieselFual");
        this.contcompany.setName("contcompany");
        this.kDSeparator8.setName("kDSeparator8");
        this.contfarmer.setName("contfarmer");
        this.contfarm.setName("contfarm");
        this.contstockingBatch.setName("contstockingBatch");
        this.kDSeparator9.setName("kDSeparator9");
        this.conttransInQty.setName("conttransInQty");
        this.chkisInit.setName("chkisInit");
        this.lblDayAge.setName("lblDayAge");
        this.contnowBreedStage.setName("contnowBreedStage");
        this.contbizPerson.setName("contbizPerson");
        this.contsumWeekDay.setName("contsumWeekDay");
        this.contcurrentCostObject.setName("contcurrentCostObject");
        this.chkisBreed.setName("chkisBreed");
        this.chkpreEgg.setName("chkpreEgg");
        this.chkisMature.setName("chkisMature");
        this.chkisAdjust.setName("chkisAdjust");
        this.chkmaleOut.setName("chkmaleOut");
        this.chkfemaleOut.setName("chkfemaleOut");
        this.chkdrugOut.setName("chkdrugOut");
        this.chkimmuneOut.setName("chkimmuneOut");
        this.chkmaterialOut.setName("chkmaterialOut");
        this.chkqualityEggOut.setName("chkqualityEggOut");
        this.chkunQualityEggOut.setName("chkunQualityEggOut");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.kDPanelFeed.setName("kDPanelFeed");
        this.kDPanelBreed.setName("kDPanelBreed");
        this.kDPanelEgg.setName("kDPanelEgg");
        this.kDPanelSendEgg.setName("kDPanelSendEgg");
        this.kDPanelDrug.setName("kDPanelDrug");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanelEnvi.setName("kDPanelEnvi");
        this.kDPanelTrans.setName("kDPanelTrans");
        this.kDPanelLog.setName("kDPanelLog");
        this.kDPanel1.setName("kDPanel1");
        this.kdtEntrys.setName("kdtEntrys");
        this.kdtAssEntrys.setName("kdtAssEntrys");
        this.kdtEggEntry.setName("kdtEggEntry");
        this.kdtSendEggEntry.setName("kdtSendEggEntry");
        this.kdtImmuneEntrys.setName("kdtImmuneEntrys");
        this.kdtDrugEntrys.setName("kdtDrugEntrys");
        this.kdtEnvi.setName("kdtEnvi");
        this.kdtTransEntry.setName("kdtTransEntry");
        this.contbreedLog.setName("contbreedLog");
        this.scrollPanebreedLog.setName("scrollPanebreedLog");
        this.txtbreedLog.setName("txtbreedLog");
        this.kdtMatUserEntry.setName("kdtMatUserEntry");
        this.baseStatus.setName("baseStatus");
        this.txtoutSideTFrom.setName("txtoutSideTFrom");
        this.txtoutSideTTo.setName("txtoutSideTTo");
        this.txtweather.setName("txtweather");
        this.txtoutHumidityFrom.setName("txtoutHumidityFrom");
        this.txtoutHumidityTo.setName("txtoutHumidityTo");
        this.pkauditTime.setName("pkauditTime");
        this.txtfuel.setName("txtfuel");
        this.txtweek.setName("txtweek");
        this.txtweekDay.setName("txtweekDay");
        this.txtelectricityQty.setName("txtelectricityQty");
        this.txtcoalFual.setName("txtcoalFual");
        this.txtdieselFual.setName("txtdieselFual");
        this.prmtcompany.setName("prmtcompany");
        this.prmtfarmer.setName("prmtfarmer");
        this.prmtfarm.setName("prmtfarm");
        this.prmtstockingBatch.setName("prmtstockingBatch");
        this.txttransInQty.setName("txttransInQty");
        this.nowBreedStage.setName("nowBreedStage");
        this.prmtbizPerson.setName("prmtbizPerson");
        this.txtsumWeekDay.setName("txtsumWeekDay");
        this.prmtcurrentCostObject.setName("prmtcurrentCostObject");
        this.tBtnAudit.setName("tBtnAudit");
        this.tBtnUnAudit.setName("tBtnUnAudit");
        this.btnGenNextBill.setName("btnGenNextBill");
        this.mBtnAudit.setName("mBtnAudit");
        this.mBtnUnAudit.setName("mBtnUnAudit");
        // CoreUI		
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
        this.contCreator.setBoundLabelAlignment(7);		
        this.contCreator.setVisible(true);		
        this.contCreator.setForeground(new java.awt.Color(0,0,0));
        // contCreateTime		
        this.contCreateTime.setBoundLabelText(resHelper.getString("contCreateTime.boundLabelText"));		
        this.contCreateTime.setBoundLabelLength(100);		
        this.contCreateTime.setBoundLabelUnderline(true);		
        this.contCreateTime.setEnabled(false);		
        this.contCreateTime.setBoundLabelAlignment(7);		
        this.contCreateTime.setVisible(true);		
        this.contCreateTime.setForeground(new java.awt.Color(0,0,0));
        // contLastUpdateUser		
        this.contLastUpdateUser.setBoundLabelText(resHelper.getString("contLastUpdateUser.boundLabelText"));		
        this.contLastUpdateUser.setBoundLabelLength(100);		
        this.contLastUpdateUser.setBoundLabelUnderline(true);		
        this.contLastUpdateUser.setEnabled(false);		
        this.contLastUpdateUser.setBoundLabelAlignment(7);		
        this.contLastUpdateUser.setForeground(new java.awt.Color(0,0,0));
        // contLastUpdateTime		
        this.contLastUpdateTime.setBoundLabelText(resHelper.getString("contLastUpdateTime.boundLabelText"));		
        this.contLastUpdateTime.setBoundLabelLength(100);		
        this.contLastUpdateTime.setBoundLabelUnderline(true);		
        this.contLastUpdateTime.setEnabled(false);		
        this.contLastUpdateTime.setBoundLabelAlignment(7);		
        this.contLastUpdateTime.setForeground(new java.awt.Color(0,0,0));
        // contNumber		
        this.contNumber.setBoundLabelText(resHelper.getString("contNumber.boundLabelText"));		
        this.contNumber.setBoundLabelLength(100);		
        this.contNumber.setBoundLabelUnderline(true);		
        this.contNumber.setBoundLabelAlignment(7);		
        this.contNumber.setForeground(new java.awt.Color(0,0,0));
        // contBizDate		
        this.contBizDate.setBoundLabelText(resHelper.getString("contBizDate.boundLabelText"));		
        this.contBizDate.setBoundLabelLength(100);		
        this.contBizDate.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelAlignment(7);		
        this.contBizDate.setVisible(true);		
        this.contBizDate.setForeground(new java.awt.Color(0,0,0));
        // contDescription		
        this.contDescription.setBoundLabelText(resHelper.getString("contDescription.boundLabelText"));		
        this.contDescription.setBoundLabelLength(100);		
        this.contDescription.setBoundLabelUnderline(true);		
        this.contDescription.setBoundLabelAlignment(7);		
        this.contDescription.setVisible(false);		
        this.contDescription.setForeground(new java.awt.Color(0,0,0));
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);		
        this.contAuditor.setBoundLabelAlignment(7);		
        this.contAuditor.setVisible(true);		
        this.contAuditor.setForeground(new java.awt.Color(0,0,0));
        // kdTabPanelMain		
        this.kdTabPanelMain.setVisible(true);
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);
        // contoutSideTFrom		
        this.contoutSideTFrom.setBoundLabelText(resHelper.getString("contoutSideTFrom.boundLabelText"));		
        this.contoutSideTFrom.setBoundLabelLength(100);		
        this.contoutSideTFrom.setBoundLabelUnderline(true);		
        this.contoutSideTFrom.setVisible(true);
        // contoutSideTTo		
        this.contoutSideTTo.setBoundLabelText(resHelper.getString("contoutSideTTo.boundLabelText"));		
        this.contoutSideTTo.setBoundLabelLength(100);		
        this.contoutSideTTo.setBoundLabelUnderline(true);		
        this.contoutSideTTo.setVisible(true);
        // contweather		
        this.contweather.setBoundLabelText(resHelper.getString("contweather.boundLabelText"));		
        this.contweather.setBoundLabelLength(100);		
        this.contweather.setBoundLabelUnderline(true);		
        this.contweather.setVisible(false);
        // contoutHumidityFrom		
        this.contoutHumidityFrom.setBoundLabelText(resHelper.getString("contoutHumidityFrom.boundLabelText"));		
        this.contoutHumidityFrom.setBoundLabelLength(100);		
        this.contoutHumidityFrom.setBoundLabelUnderline(true);		
        this.contoutHumidityFrom.setVisible(false);
        // contoutHumidityTo		
        this.contoutHumidityTo.setBoundLabelText(resHelper.getString("contoutHumidityTo.boundLabelText"));		
        this.contoutHumidityTo.setBoundLabelLength(100);		
        this.contoutHumidityTo.setBoundLabelUnderline(true);		
        this.contoutHumidityTo.setVisible(false);
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // contfuel		
        this.contfuel.setBoundLabelText(resHelper.getString("contfuel.boundLabelText"));		
        this.contfuel.setBoundLabelLength(100);		
        this.contfuel.setBoundLabelUnderline(true);		
        this.contfuel.setVisible(false);		
        this.contfuel.setEnabled(false);
        // contweek		
        this.contweek.setBoundLabelText(resHelper.getString("contweek.boundLabelText"));		
        this.contweek.setBoundLabelLength(100);		
        this.contweek.setBoundLabelUnderline(true);
        // contweekDay		
        this.contweekDay.setBoundLabelText(resHelper.getString("contweekDay.boundLabelText"));		
        this.contweekDay.setBoundLabelLength(0);		
        this.contweekDay.setBoundLabelUnderline(true);		
        this.contweekDay.setVisible(true);
        // kDLabel1		
        this.kDLabel1.setText(resHelper.getString("kDLabel1.text"));
        // kDLabel2		
        this.kDLabel2.setText(resHelper.getString("kDLabel2.text"));
        // contelectricityQty		
        this.contelectricityQty.setBoundLabelText(resHelper.getString("contelectricityQty.boundLabelText"));		
        this.contelectricityQty.setBoundLabelLength(100);		
        this.contelectricityQty.setBoundLabelUnderline(true);		
        this.contelectricityQty.setVisible(false);
        // contcoalFual		
        this.contcoalFual.setBoundLabelText(resHelper.getString("contcoalFual.boundLabelText"));		
        this.contcoalFual.setBoundLabelLength(100);		
        this.contcoalFual.setBoundLabelUnderline(true);		
        this.contcoalFual.setVisible(false);
        // contdieselFual		
        this.contdieselFual.setBoundLabelText(resHelper.getString("contdieselFual.boundLabelText"));		
        this.contdieselFual.setBoundLabelLength(100);		
        this.contdieselFual.setBoundLabelUnderline(true);		
        this.contdieselFual.setVisible(false);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // kDSeparator8
        // contfarmer		
        this.contfarmer.setBoundLabelText(resHelper.getString("contfarmer.boundLabelText"));		
        this.contfarmer.setBoundLabelLength(100);		
        this.contfarmer.setBoundLabelUnderline(true);		
        this.contfarmer.setVisible(false);
        // contfarm		
        this.contfarm.setBoundLabelText(resHelper.getString("contfarm.boundLabelText"));		
        this.contfarm.setBoundLabelLength(100);		
        this.contfarm.setBoundLabelUnderline(true);		
        this.contfarm.setVisible(true);
        // contstockingBatch		
        this.contstockingBatch.setBoundLabelText(resHelper.getString("contstockingBatch.boundLabelText"));		
        this.contstockingBatch.setBoundLabelLength(100);		
        this.contstockingBatch.setBoundLabelUnderline(true);		
        this.contstockingBatch.setVisible(true);
        // kDSeparator9
        // conttransInQty		
        this.conttransInQty.setBoundLabelText(resHelper.getString("conttransInQty.boundLabelText"));		
        this.conttransInQty.setBoundLabelLength(100);		
        this.conttransInQty.setBoundLabelUnderline(true);		
        this.conttransInQty.setVisible(false);
        // chkisInit		
        this.chkisInit.setText(resHelper.getString("chkisInit.text"));		
        this.chkisInit.setHorizontalAlignment(2);
        // lblDayAge		
        this.lblDayAge.setText(resHelper.getString("lblDayAge.text"));
        // contnowBreedStage		
        this.contnowBreedStage.setBoundLabelText(resHelper.getString("contnowBreedStage.boundLabelText"));		
        this.contnowBreedStage.setBoundLabelLength(100);		
        this.contnowBreedStage.setBoundLabelUnderline(true);		
        this.contnowBreedStage.setVisible(true);
        // contbizPerson		
        this.contbizPerson.setBoundLabelText(resHelper.getString("contbizPerson.boundLabelText"));		
        this.contbizPerson.setBoundLabelLength(100);		
        this.contbizPerson.setBoundLabelUnderline(true);		
        this.contbizPerson.setVisible(false);
        // contsumWeekDay		
        this.contsumWeekDay.setBoundLabelText(resHelper.getString("contsumWeekDay.boundLabelText"));		
        this.contsumWeekDay.setBoundLabelLength(100);		
        this.contsumWeekDay.setBoundLabelUnderline(true);		
        this.contsumWeekDay.setVisible(false);
        // contcurrentCostObject		
        this.contcurrentCostObject.setBoundLabelText(resHelper.getString("contcurrentCostObject.boundLabelText"));		
        this.contcurrentCostObject.setBoundLabelLength(100);		
        this.contcurrentCostObject.setBoundLabelUnderline(true);		
        this.contcurrentCostObject.setVisible(false);
        // chkisBreed		
        this.chkisBreed.setHorizontalAlignment(2);		
        this.chkisBreed.setText(resHelper.getString("chkisBreed.text"));		
        this.chkisBreed.setVisible(false);
        // chkpreEgg		
        this.chkpreEgg.setText(resHelper.getString("chkpreEgg.text"));		
        this.chkpreEgg.setHorizontalAlignment(2);		
        this.chkpreEgg.setVisible(false);
        // chkisMature		
        this.chkisMature.setHorizontalAlignment(2);		
        this.chkisMature.setText(resHelper.getString("chkisMature.text"));		
        this.chkisMature.setVisible(false);
        // chkisAdjust		
        this.chkisAdjust.setText(resHelper.getString("chkisAdjust.text"));		
        this.chkisAdjust.setVisible(false);		
        this.chkisAdjust.setHorizontalAlignment(2);
        // chkmaleOut		
        this.chkmaleOut.setText(resHelper.getString("chkmaleOut.text"));		
        this.chkmaleOut.setHorizontalAlignment(2);		
        this.chkmaleOut.setEnabled(false);
        // chkfemaleOut		
        this.chkfemaleOut.setText(resHelper.getString("chkfemaleOut.text"));		
        this.chkfemaleOut.setHorizontalAlignment(2);		
        this.chkfemaleOut.setEnabled(false);
        // chkdrugOut		
        this.chkdrugOut.setText(resHelper.getString("chkdrugOut.text"));		
        this.chkdrugOut.setHorizontalAlignment(2);		
        this.chkdrugOut.setEnabled(false);
        // chkimmuneOut		
        this.chkimmuneOut.setText(resHelper.getString("chkimmuneOut.text"));		
        this.chkimmuneOut.setHorizontalAlignment(2);		
        this.chkimmuneOut.setEnabled(false);
        // chkmaterialOut		
        this.chkmaterialOut.setText(resHelper.getString("chkmaterialOut.text"));		
        this.chkmaterialOut.setHorizontalAlignment(2);		
        this.chkmaterialOut.setEnabled(false);
        // chkqualityEggOut		
        this.chkqualityEggOut.setText(resHelper.getString("chkqualityEggOut.text"));		
        this.chkqualityEggOut.setHorizontalAlignment(2);		
        this.chkqualityEggOut.setEnabled(false);
        // chkunQualityEggOut		
        this.chkunQualityEggOut.setText(resHelper.getString("chkunQualityEggOut.text"));		
        this.chkunQualityEggOut.setHorizontalAlignment(2);		
        this.chkunQualityEggOut.setEnabled(false);
        // prmtCreator		
        this.prmtCreator.setEnabled(false);		
        this.prmtCreator.setRequired(false);		
        this.prmtCreator.setForeground(new java.awt.Color(0,0,0));
        // kDDateCreateTime		
        this.kDDateCreateTime.setTimeEnabled(true);		
        this.kDDateCreateTime.setEnabled(false);		
        this.kDDateCreateTime.setRequired(false);		
        this.kDDateCreateTime.setForeground(new java.awt.Color(0,0,0));
        // prmtLastUpdateUser		
        this.prmtLastUpdateUser.setEnabled(false);		
        this.prmtLastUpdateUser.setRequired(false);		
        this.prmtLastUpdateUser.setForeground(new java.awt.Color(0,0,0));
        // kDDateLastUpdateTime		
        this.kDDateLastUpdateTime.setTimeEnabled(true);		
        this.kDDateLastUpdateTime.setEnabled(false);		
        this.kDDateLastUpdateTime.setRequired(false);		
        this.kDDateLastUpdateTime.setForeground(new java.awt.Color(0,0,0));
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setEnabled(true);		
        this.txtNumber.setHorizontalAlignment(2);		
        this.txtNumber.setRequired(false);		
        this.txtNumber.setForeground(new java.awt.Color(0,0,0));
        // pkBizDate		
        this.pkBizDate.setEnabled(true);		
        this.pkBizDate.setRequired(true);		
        this.pkBizDate.setForeground(new java.awt.Color(0,0,0));
        // txtDescription		
        this.txtDescription.setMaxLength(80);		
        this.txtDescription.setEnabled(true);		
        this.txtDescription.setHorizontalAlignment(2);		
        this.txtDescription.setRequired(false);		
        this.txtDescription.setForeground(new java.awt.Color(0,0,0));
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);		
        this.prmtAuditor.setRequired(false);		
        this.prmtAuditor.setForeground(new java.awt.Color(0,0,0));
        // kDPanelFeed		
        this.kDPanelFeed.setVisible(true);
        // kDPanelBreed		
        this.kDPanelBreed.setVisible(true);
        // kDPanelEgg
        // kDPanelSendEgg		
        this.kDPanelSendEgg.setOpaque(false);
        // kDPanelDrug
        // kDPanel2
        // kDPanelEnvi
        // kDPanelTrans		
        this.kDPanelTrans.setVisible(false);
        // kDPanelLog
        // kDPanel1
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol14\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol16\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"house\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"materialName\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"materialModel\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"unitQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"bagQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"dailyQtyAll\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"mqlbm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"feMaterail\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"femaleModel\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"femaleDailyQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"limitFeedType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"waterQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"averageBreed\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"packageQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /><t:Column t:key=\"description\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{house}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{materialModel}</t:Cell><t:Cell>$Resource{unitQty}</t:Cell><t:Cell>$Resource{bagQty}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{dailyQtyAll}</t:Cell><t:Cell>$Resource{mqlbm}</t:Cell><t:Cell>$Resource{feMaterail}</t:Cell><t:Cell>$Resource{femaleModel}</t:Cell><t:Cell>$Resource{femaleDailyQty}</t:Cell><t:Cell>$Resource{limitFeedType}</t:Cell><t:Cell>$Resource{waterQty}</t:Cell><t:Cell>$Resource{averageBreed}</t:Cell><t:Cell>$Resource{packageQty}</t:Cell><t:Cell>$Resource{description}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));
        kdtEntrys.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtEntrys_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtEntrys.putBindContents("editData",new String[] {"id","house","material","materialName","materialModel","unitQty","bagQty","unit","dailyQtyAll","mqlbm","feMaterail","femaleModel","femaleDailyQty","limitFeedType","waterQty","averageBreed","packageQty","description"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_house_PromptBox = new KDBizPromptBox();
        kdtEntrys_house_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
        kdtEntrys_house_PromptBox.setVisible(true);
        kdtEntrys_house_PromptBox.setEditable(true);
        kdtEntrys_house_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_house_PromptBox.setEditFormat("$number$");
        kdtEntrys_house_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_house_CellEditor = new KDTDefaultCellEditor(kdtEntrys_house_PromptBox);
        this.kdtEntrys.getColumn("house").setEditor(kdtEntrys_house_CellEditor);
        ObjectValueRender kdtEntrys_house_OVR = new ObjectValueRender();
        kdtEntrys_house_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("house").setRenderer(kdtEntrys_house_OVR);
        final KDBizPromptBox kdtEntrys_material_PromptBox = new KDBizPromptBox();
        kdtEntrys_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtEntrys_material_PromptBox.setVisible(true);
        kdtEntrys_material_PromptBox.setEditable(true);
        kdtEntrys_material_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_material_PromptBox.setEditFormat("$number$");
        kdtEntrys_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_material_CellEditor = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox);
        this.kdtEntrys.getColumn("material").setEditor(kdtEntrys_material_CellEditor);
        ObjectValueRender kdtEntrys_material_OVR = new ObjectValueRender();
        kdtEntrys_material_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("material").setRenderer(kdtEntrys_material_OVR);
        KDTextField kdtEntrys_materialName_TextField = new KDTextField();
        kdtEntrys_materialName_TextField.setName("kdtEntrys_materialName_TextField");
        kdtEntrys_materialName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_materialName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_materialName_TextField);
        this.kdtEntrys.getColumn("materialName").setEditor(kdtEntrys_materialName_CellEditor);
        KDTextField kdtEntrys_materialModel_TextField = new KDTextField();
        kdtEntrys_materialModel_TextField.setName("kdtEntrys_materialModel_TextField");
        kdtEntrys_materialModel_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_materialModel_CellEditor = new KDTDefaultCellEditor(kdtEntrys_materialModel_TextField);
        this.kdtEntrys.getColumn("materialModel").setEditor(kdtEntrys_materialModel_CellEditor);
        KDFormattedTextField kdtEntrys_unitQty_TextField = new KDFormattedTextField();
        kdtEntrys_unitQty_TextField.setName("kdtEntrys_unitQty_TextField");
        kdtEntrys_unitQty_TextField.setVisible(true);
        kdtEntrys_unitQty_TextField.setEditable(true);
        kdtEntrys_unitQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_unitQty_TextField.setDataType(1);
        	kdtEntrys_unitQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_unitQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_unitQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_unitQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_unitQty_TextField);
        this.kdtEntrys.getColumn("unitQty").setEditor(kdtEntrys_unitQty_CellEditor);
        KDFormattedTextField kdtEntrys_bagQty_TextField = new KDFormattedTextField();
        kdtEntrys_bagQty_TextField.setName("kdtEntrys_bagQty_TextField");
        kdtEntrys_bagQty_TextField.setVisible(true);
        kdtEntrys_bagQty_TextField.setEditable(true);
        kdtEntrys_bagQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_bagQty_TextField.setDataType(1);
        	kdtEntrys_bagQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_bagQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_bagQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_bagQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_bagQty_TextField);
        this.kdtEntrys.getColumn("bagQty").setEditor(kdtEntrys_bagQty_CellEditor);
        final KDBizPromptBox kdtEntrys_unit_PromptBox = new KDBizPromptBox();
        kdtEntrys_unit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtEntrys_unit_PromptBox.setVisible(true);
        kdtEntrys_unit_PromptBox.setEditable(true);
        kdtEntrys_unit_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_unit_PromptBox.setEditFormat("$number$");
        kdtEntrys_unit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_unit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_unit_PromptBox);
        this.kdtEntrys.getColumn("unit").setEditor(kdtEntrys_unit_CellEditor);
        ObjectValueRender kdtEntrys_unit_OVR = new ObjectValueRender();
        kdtEntrys_unit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("unit").setRenderer(kdtEntrys_unit_OVR);
        KDFormattedTextField kdtEntrys_dailyQtyAll_TextField = new KDFormattedTextField();
        kdtEntrys_dailyQtyAll_TextField.setName("kdtEntrys_dailyQtyAll_TextField");
        kdtEntrys_dailyQtyAll_TextField.setVisible(true);
        kdtEntrys_dailyQtyAll_TextField.setEditable(true);
        kdtEntrys_dailyQtyAll_TextField.setHorizontalAlignment(2);
        kdtEntrys_dailyQtyAll_TextField.setDataType(1);
        	kdtEntrys_dailyQtyAll_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_dailyQtyAll_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_dailyQtyAll_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_dailyQtyAll_CellEditor = new KDTDefaultCellEditor(kdtEntrys_dailyQtyAll_TextField);
        this.kdtEntrys.getColumn("dailyQtyAll").setEditor(kdtEntrys_dailyQtyAll_CellEditor);
        KDTextField kdtEntrys_mqlbm_TextField = new KDTextField();
        kdtEntrys_mqlbm_TextField.setName("kdtEntrys_mqlbm_TextField");
        kdtEntrys_mqlbm_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_mqlbm_CellEditor = new KDTDefaultCellEditor(kdtEntrys_mqlbm_TextField);
        this.kdtEntrys.getColumn("mqlbm").setEditor(kdtEntrys_mqlbm_CellEditor);
        final KDBizPromptBox kdtEntrys_feMaterail_PromptBox = new KDBizPromptBox();
        kdtEntrys_feMaterail_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtEntrys_feMaterail_PromptBox.setVisible(true);
        kdtEntrys_feMaterail_PromptBox.setEditable(true);
        kdtEntrys_feMaterail_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_feMaterail_PromptBox.setEditFormat("$number$");
        kdtEntrys_feMaterail_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_feMaterail_CellEditor = new KDTDefaultCellEditor(kdtEntrys_feMaterail_PromptBox);
        this.kdtEntrys.getColumn("feMaterail").setEditor(kdtEntrys_feMaterail_CellEditor);
        ObjectValueRender kdtEntrys_feMaterail_OVR = new ObjectValueRender();
        kdtEntrys_feMaterail_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("feMaterail").setRenderer(kdtEntrys_feMaterail_OVR);
        KDTextField kdtEntrys_femaleModel_TextField = new KDTextField();
        kdtEntrys_femaleModel_TextField.setName("kdtEntrys_femaleModel_TextField");
        kdtEntrys_femaleModel_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_femaleModel_CellEditor = new KDTDefaultCellEditor(kdtEntrys_femaleModel_TextField);
        this.kdtEntrys.getColumn("femaleModel").setEditor(kdtEntrys_femaleModel_CellEditor);
        KDFormattedTextField kdtEntrys_femaleDailyQty_TextField = new KDFormattedTextField();
        kdtEntrys_femaleDailyQty_TextField.setName("kdtEntrys_femaleDailyQty_TextField");
        kdtEntrys_femaleDailyQty_TextField.setVisible(true);
        kdtEntrys_femaleDailyQty_TextField.setEditable(true);
        kdtEntrys_femaleDailyQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_femaleDailyQty_TextField.setDataType(1);
        	kdtEntrys_femaleDailyQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_femaleDailyQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_femaleDailyQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_femaleDailyQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_femaleDailyQty_TextField);
        this.kdtEntrys.getColumn("femaleDailyQty").setEditor(kdtEntrys_femaleDailyQty_CellEditor);
        KDTextField kdtEntrys_limitFeedType_TextField = new KDTextField();
        kdtEntrys_limitFeedType_TextField.setName("kdtEntrys_limitFeedType_TextField");
        kdtEntrys_limitFeedType_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_limitFeedType_CellEditor = new KDTDefaultCellEditor(kdtEntrys_limitFeedType_TextField);
        this.kdtEntrys.getColumn("limitFeedType").setEditor(kdtEntrys_limitFeedType_CellEditor);
        KDFormattedTextField kdtEntrys_waterQty_TextField = new KDFormattedTextField();
        kdtEntrys_waterQty_TextField.setName("kdtEntrys_waterQty_TextField");
        kdtEntrys_waterQty_TextField.setVisible(true);
        kdtEntrys_waterQty_TextField.setEditable(true);
        kdtEntrys_waterQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_waterQty_TextField.setDataType(1);
        	kdtEntrys_waterQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_waterQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_waterQty_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_waterQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_waterQty_TextField);
        this.kdtEntrys.getColumn("waterQty").setEditor(kdtEntrys_waterQty_CellEditor);
        KDFormattedTextField kdtEntrys_averageBreed_TextField = new KDFormattedTextField();
        kdtEntrys_averageBreed_TextField.setName("kdtEntrys_averageBreed_TextField");
        kdtEntrys_averageBreed_TextField.setVisible(true);
        kdtEntrys_averageBreed_TextField.setEditable(true);
        kdtEntrys_averageBreed_TextField.setHorizontalAlignment(2);
        kdtEntrys_averageBreed_TextField.setDataType(1);
        	kdtEntrys_averageBreed_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_averageBreed_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_averageBreed_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_averageBreed_CellEditor = new KDTDefaultCellEditor(kdtEntrys_averageBreed_TextField);
        this.kdtEntrys.getColumn("averageBreed").setEditor(kdtEntrys_averageBreed_CellEditor);
        KDFormattedTextField kdtEntrys_packageQty_TextField = new KDFormattedTextField();
        kdtEntrys_packageQty_TextField.setName("kdtEntrys_packageQty_TextField");
        kdtEntrys_packageQty_TextField.setVisible(true);
        kdtEntrys_packageQty_TextField.setEditable(true);
        kdtEntrys_packageQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_packageQty_TextField.setDataType(1);
        	kdtEntrys_packageQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_packageQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_packageQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_packageQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_packageQty_TextField);
        this.kdtEntrys.getColumn("packageQty").setEditor(kdtEntrys_packageQty_CellEditor);
        KDTextField kdtEntrys_description_TextField = new KDTextField();
        kdtEntrys_description_TextField.setName("kdtEntrys_description_TextField");
        kdtEntrys_description_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_description_CellEditor = new KDTDefaultCellEditor(kdtEntrys_description_TextField);
        this.kdtEntrys.getColumn("description").setEditor(kdtEntrys_description_CellEditor);
        // kdtAssEntrys
		String kdtAssEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol9\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol16\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol17\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol18\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol19\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol20\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol22\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol23\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol24\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol25\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol26\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol27\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol28\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol29\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol30\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol31\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol32\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol33\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol34\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol35\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol36\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol37\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"0\" t:styleID=\"sCol0\" /><t:Column t:key=\"house\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"3\" /><t:Column t:key=\"week\" t:width=\"50\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" t:styleID=\"sCol2\" /><t:Column t:key=\"weekDays\" t:width=\"60\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" t:styleID=\"sCol3\" /><t:Column t:key=\"deathQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"6\" t:styleID=\"sCol4\" /><t:Column t:key=\"cullQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"7\" t:styleID=\"sCol5\" /><t:Column t:key=\"femaleDeathQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" t:styleID=\"sCol6\" /><t:Column t:key=\"femaleCullQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"9\" t:styleID=\"sCol7\" /><t:Column t:key=\"customer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"10\" t:styleID=\"sCol8\" /><t:Column t:key=\"breekingStock\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"11\" t:styleID=\"sCol9\" /><t:Column t:key=\"femaleBreedkingStock\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"12\" t:styleID=\"sCol10\" /><t:Column t:key=\"avgWeight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"13\" t:styleID=\"sCol11\" /><t:Column t:key=\"femaleQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"14\" t:styleID=\"sCol12\" /><t:Column t:key=\"gjUniformity\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"16\" t:styleID=\"sCol13\" /><t:Column t:key=\"mjUniformity\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"17\" t:styleID=\"sCol14\" /><t:Column t:key=\"isMarketed\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"18\" /><t:Column t:key=\"markedQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"19\" t:styleID=\"sCol16\" /><t:Column t:key=\"femaleMarketed\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"cullTotalWgt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"cullTotalAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol19\" /><t:Column t:key=\"cullAvgPrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol20\" /><t:Column t:key=\"description\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"adjustQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol22\" /><t:Column t:key=\"adjustFemaleQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol23\" /><t:Column t:key=\"breedTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol24\" /><t:Column t:key=\"lightingTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol25\" /><t:Column t:key=\"temperatureTo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol26\" /><t:Column t:key=\"temperatureFrom\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol27\" /><t:Column t:key=\"humidityTo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol28\" /><t:Column t:key=\"humidityFrom\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol29\" /><t:Column t:key=\"femaleLossW\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol30\" /><t:Column t:key=\"maleLossW\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol31\" /><t:Column t:key=\"femaleLossRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol32\" /><t:Column t:key=\"maleLossRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol33\" /><t:Column t:key=\"femaleLossStand\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol34\" /><t:Column t:key=\"maleLossStand\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol35\" /><t:Column t:key=\"femaleLosWeiRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol36\" /><t:Column t:key=\"maleLosWeiStand\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol37\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{house}</t:Cell><t:Cell>$Resource{week}</t:Cell><t:Cell>$Resource{weekDays}</t:Cell><t:Cell>$Resource{deathQty}</t:Cell><t:Cell>$Resource{cullQty}</t:Cell><t:Cell>$Resource{femaleDeathQty}</t:Cell><t:Cell>$Resource{femaleCullQty}</t:Cell><t:Cell>$Resource{customer}</t:Cell><t:Cell>$Resource{breekingStock}</t:Cell><t:Cell>$Resource{femaleBreedkingStock}</t:Cell><t:Cell>$Resource{avgWeight}</t:Cell><t:Cell>$Resource{femaleQty}</t:Cell><t:Cell>$Resource{gjUniformity}</t:Cell><t:Cell>$Resource{mjUniformity}</t:Cell><t:Cell>$Resource{isMarketed}</t:Cell><t:Cell>$Resource{markedQty}</t:Cell><t:Cell>$Resource{femaleMarketed}</t:Cell><t:Cell>$Resource{cullTotalWgt}</t:Cell><t:Cell>$Resource{cullTotalAmt}</t:Cell><t:Cell>$Resource{cullAvgPrice}</t:Cell><t:Cell>$Resource{description}</t:Cell><t:Cell>$Resource{adjustQty}</t:Cell><t:Cell>$Resource{adjustFemaleQty}</t:Cell><t:Cell>$Resource{breedTime}</t:Cell><t:Cell>$Resource{lightingTime}</t:Cell><t:Cell>$Resource{temperatureTo}</t:Cell><t:Cell>$Resource{temperatureFrom}</t:Cell><t:Cell>$Resource{humidityTo}</t:Cell><t:Cell>$Resource{humidityFrom}</t:Cell><t:Cell>$Resource{femaleLossW}</t:Cell><t:Cell>$Resource{maleLossW}</t:Cell><t:Cell>$Resource{femaleLossRate}</t:Cell><t:Cell>$Resource{maleLossRate}</t:Cell><t:Cell>$Resource{femaleLossStand}</t:Cell><t:Cell>$Resource{maleLossStand}</t:Cell><t:Cell>$Resource{femaleLosWeiRate}</t:Cell><t:Cell>$Resource{maleLosWeiStand}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtAssEntrys.setFormatXml(resHelper.translateString("kdtAssEntrys",kdtAssEntrysStrXML));
        kdtAssEntrys.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtAssEntrys_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtAssEntrys.putBindContents("editData",new String[] {"id","house","week","weekDays","deathQty","cullQty","femaleDeathQty","femaleCullQty","customer","breekingStock","femaleBreedkingStock","avgWeight","femaleQty","gjUniformity","mjUniformity","isMarketed","markedQty","femaleMarketed","cullTotalWgt","cullTotalAmt","cullAvgPrice","description","adjustQty","adjustFemaleQty","breedTime","lightingTime","temperatureTo","temperatureFrom","humidityTo","humidityFrom","femaleLossW","maleLossW","femaleLossRate","maleLossRate","femaleLossStand","maleLossStand","femaleLosWeiRate","maleLosWeiStand"});


        this.kdtAssEntrys.checkParsed();
        final KDBizPromptBox kdtAssEntrys_house_PromptBox = new KDBizPromptBox();
        kdtAssEntrys_house_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
        kdtAssEntrys_house_PromptBox.setVisible(true);
        kdtAssEntrys_house_PromptBox.setEditable(true);
        kdtAssEntrys_house_PromptBox.setDisplayFormat("$number$");
        kdtAssEntrys_house_PromptBox.setEditFormat("$number$");
        kdtAssEntrys_house_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtAssEntrys_house_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_house_PromptBox);
        this.kdtAssEntrys.getColumn("house").setEditor(kdtAssEntrys_house_CellEditor);
        ObjectValueRender kdtAssEntrys_house_OVR = new ObjectValueRender();
        kdtAssEntrys_house_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtAssEntrys.getColumn("house").setRenderer(kdtAssEntrys_house_OVR);
        KDFormattedTextField kdtAssEntrys_week_TextField = new KDFormattedTextField();
        kdtAssEntrys_week_TextField.setName("kdtAssEntrys_week_TextField");
        kdtAssEntrys_week_TextField.setVisible(true);
        kdtAssEntrys_week_TextField.setEditable(true);
        kdtAssEntrys_week_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_week_TextField.setDataType(0);
        KDTDefaultCellEditor kdtAssEntrys_week_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_week_TextField);
        this.kdtAssEntrys.getColumn("week").setEditor(kdtAssEntrys_week_CellEditor);
        KDFormattedTextField kdtAssEntrys_weekDays_TextField = new KDFormattedTextField();
        kdtAssEntrys_weekDays_TextField.setName("kdtAssEntrys_weekDays_TextField");
        kdtAssEntrys_weekDays_TextField.setVisible(true);
        kdtAssEntrys_weekDays_TextField.setEditable(true);
        kdtAssEntrys_weekDays_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_weekDays_TextField.setDataType(1);
        	kdtAssEntrys_weekDays_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtAssEntrys_weekDays_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtAssEntrys_weekDays_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtAssEntrys_weekDays_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_weekDays_TextField);
        this.kdtAssEntrys.getColumn("weekDays").setEditor(kdtAssEntrys_weekDays_CellEditor);
        KDFormattedTextField kdtAssEntrys_deathQty_TextField = new KDFormattedTextField();
        kdtAssEntrys_deathQty_TextField.setName("kdtAssEntrys_deathQty_TextField");
        kdtAssEntrys_deathQty_TextField.setVisible(true);
        kdtAssEntrys_deathQty_TextField.setEditable(true);
        kdtAssEntrys_deathQty_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_deathQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtAssEntrys_deathQty_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_deathQty_TextField);
        this.kdtAssEntrys.getColumn("deathQty").setEditor(kdtAssEntrys_deathQty_CellEditor);
        KDFormattedTextField kdtAssEntrys_cullQty_TextField = new KDFormattedTextField();
        kdtAssEntrys_cullQty_TextField.setName("kdtAssEntrys_cullQty_TextField");
        kdtAssEntrys_cullQty_TextField.setVisible(true);
        kdtAssEntrys_cullQty_TextField.setEditable(true);
        kdtAssEntrys_cullQty_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_cullQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtAssEntrys_cullQty_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_cullQty_TextField);
        this.kdtAssEntrys.getColumn("cullQty").setEditor(kdtAssEntrys_cullQty_CellEditor);
        KDFormattedTextField kdtAssEntrys_femaleDeathQty_TextField = new KDFormattedTextField();
        kdtAssEntrys_femaleDeathQty_TextField.setName("kdtAssEntrys_femaleDeathQty_TextField");
        kdtAssEntrys_femaleDeathQty_TextField.setVisible(true);
        kdtAssEntrys_femaleDeathQty_TextField.setEditable(true);
        kdtAssEntrys_femaleDeathQty_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_femaleDeathQty_TextField.setDataType(1);
        	kdtAssEntrys_femaleDeathQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtAssEntrys_femaleDeathQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtAssEntrys_femaleDeathQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtAssEntrys_femaleDeathQty_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_femaleDeathQty_TextField);
        this.kdtAssEntrys.getColumn("femaleDeathQty").setEditor(kdtAssEntrys_femaleDeathQty_CellEditor);
        KDFormattedTextField kdtAssEntrys_femaleCullQty_TextField = new KDFormattedTextField();
        kdtAssEntrys_femaleCullQty_TextField.setName("kdtAssEntrys_femaleCullQty_TextField");
        kdtAssEntrys_femaleCullQty_TextField.setVisible(true);
        kdtAssEntrys_femaleCullQty_TextField.setEditable(true);
        kdtAssEntrys_femaleCullQty_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_femaleCullQty_TextField.setDataType(1);
        	kdtAssEntrys_femaleCullQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtAssEntrys_femaleCullQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtAssEntrys_femaleCullQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtAssEntrys_femaleCullQty_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_femaleCullQty_TextField);
        this.kdtAssEntrys.getColumn("femaleCullQty").setEditor(kdtAssEntrys_femaleCullQty_CellEditor);
        final KDBizPromptBox kdtAssEntrys_customer_PromptBox = new KDBizPromptBox();
        kdtAssEntrys_customer_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.CustomerInfoQuery");
        kdtAssEntrys_customer_PromptBox.setVisible(true);
        kdtAssEntrys_customer_PromptBox.setEditable(true);
        kdtAssEntrys_customer_PromptBox.setDisplayFormat("$number$");
        kdtAssEntrys_customer_PromptBox.setEditFormat("$number$");
        kdtAssEntrys_customer_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtAssEntrys_customer_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_customer_PromptBox);
        this.kdtAssEntrys.getColumn("customer").setEditor(kdtAssEntrys_customer_CellEditor);
        ObjectValueRender kdtAssEntrys_customer_OVR = new ObjectValueRender();
        kdtAssEntrys_customer_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtAssEntrys.getColumn("customer").setRenderer(kdtAssEntrys_customer_OVR);
        KDFormattedTextField kdtAssEntrys_breekingStock_TextField = new KDFormattedTextField();
        kdtAssEntrys_breekingStock_TextField.setName("kdtAssEntrys_breekingStock_TextField");
        kdtAssEntrys_breekingStock_TextField.setVisible(true);
        kdtAssEntrys_breekingStock_TextField.setEditable(true);
        kdtAssEntrys_breekingStock_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_breekingStock_TextField.setDataType(0);
        KDTDefaultCellEditor kdtAssEntrys_breekingStock_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_breekingStock_TextField);
        this.kdtAssEntrys.getColumn("breekingStock").setEditor(kdtAssEntrys_breekingStock_CellEditor);
        KDFormattedTextField kdtAssEntrys_femaleBreedkingStock_TextField = new KDFormattedTextField();
        kdtAssEntrys_femaleBreedkingStock_TextField.setName("kdtAssEntrys_femaleBreedkingStock_TextField");
        kdtAssEntrys_femaleBreedkingStock_TextField.setVisible(true);
        kdtAssEntrys_femaleBreedkingStock_TextField.setEditable(true);
        kdtAssEntrys_femaleBreedkingStock_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_femaleBreedkingStock_TextField.setDataType(1);
        	kdtAssEntrys_femaleBreedkingStock_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtAssEntrys_femaleBreedkingStock_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtAssEntrys_femaleBreedkingStock_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtAssEntrys_femaleBreedkingStock_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_femaleBreedkingStock_TextField);
        this.kdtAssEntrys.getColumn("femaleBreedkingStock").setEditor(kdtAssEntrys_femaleBreedkingStock_CellEditor);
        KDFormattedTextField kdtAssEntrys_avgWeight_TextField = new KDFormattedTextField();
        kdtAssEntrys_avgWeight_TextField.setName("kdtAssEntrys_avgWeight_TextField");
        kdtAssEntrys_avgWeight_TextField.setVisible(true);
        kdtAssEntrys_avgWeight_TextField.setEditable(true);
        kdtAssEntrys_avgWeight_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_avgWeight_TextField.setDataType(1);
        	kdtAssEntrys_avgWeight_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtAssEntrys_avgWeight_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtAssEntrys_avgWeight_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtAssEntrys_avgWeight_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_avgWeight_TextField);
        this.kdtAssEntrys.getColumn("avgWeight").setEditor(kdtAssEntrys_avgWeight_CellEditor);
        KDFormattedTextField kdtAssEntrys_femaleQty_TextField = new KDFormattedTextField();
        kdtAssEntrys_femaleQty_TextField.setName("kdtAssEntrys_femaleQty_TextField");
        kdtAssEntrys_femaleQty_TextField.setVisible(true);
        kdtAssEntrys_femaleQty_TextField.setEditable(true);
        kdtAssEntrys_femaleQty_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_femaleQty_TextField.setDataType(1);
        	kdtAssEntrys_femaleQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtAssEntrys_femaleQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtAssEntrys_femaleQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtAssEntrys_femaleQty_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_femaleQty_TextField);
        this.kdtAssEntrys.getColumn("femaleQty").setEditor(kdtAssEntrys_femaleQty_CellEditor);
        KDFormattedTextField kdtAssEntrys_gjUniformity_TextField = new KDFormattedTextField();
        kdtAssEntrys_gjUniformity_TextField.setName("kdtAssEntrys_gjUniformity_TextField");
        kdtAssEntrys_gjUniformity_TextField.setVisible(true);
        kdtAssEntrys_gjUniformity_TextField.setEditable(true);
        kdtAssEntrys_gjUniformity_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_gjUniformity_TextField.setDataType(1);
        	kdtAssEntrys_gjUniformity_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtAssEntrys_gjUniformity_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtAssEntrys_gjUniformity_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtAssEntrys_gjUniformity_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_gjUniformity_TextField);
        this.kdtAssEntrys.getColumn("gjUniformity").setEditor(kdtAssEntrys_gjUniformity_CellEditor);
        KDFormattedTextField kdtAssEntrys_mjUniformity_TextField = new KDFormattedTextField();
        kdtAssEntrys_mjUniformity_TextField.setName("kdtAssEntrys_mjUniformity_TextField");
        kdtAssEntrys_mjUniformity_TextField.setVisible(true);
        kdtAssEntrys_mjUniformity_TextField.setEditable(true);
        kdtAssEntrys_mjUniformity_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_mjUniformity_TextField.setDataType(1);
        	kdtAssEntrys_mjUniformity_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtAssEntrys_mjUniformity_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtAssEntrys_mjUniformity_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtAssEntrys_mjUniformity_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_mjUniformity_TextField);
        this.kdtAssEntrys.getColumn("mjUniformity").setEditor(kdtAssEntrys_mjUniformity_CellEditor);
        KDCheckBox kdtAssEntrys_isMarketed_CheckBox = new KDCheckBox();
        kdtAssEntrys_isMarketed_CheckBox.setName("kdtAssEntrys_isMarketed_CheckBox");
        KDTDefaultCellEditor kdtAssEntrys_isMarketed_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_isMarketed_CheckBox);
        this.kdtAssEntrys.getColumn("isMarketed").setEditor(kdtAssEntrys_isMarketed_CellEditor);
        KDFormattedTextField kdtAssEntrys_markedQty_TextField = new KDFormattedTextField();
        kdtAssEntrys_markedQty_TextField.setName("kdtAssEntrys_markedQty_TextField");
        kdtAssEntrys_markedQty_TextField.setVisible(true);
        kdtAssEntrys_markedQty_TextField.setEditable(true);
        kdtAssEntrys_markedQty_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_markedQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtAssEntrys_markedQty_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_markedQty_TextField);
        this.kdtAssEntrys.getColumn("markedQty").setEditor(kdtAssEntrys_markedQty_CellEditor);
        KDFormattedTextField kdtAssEntrys_femaleMarketed_TextField = new KDFormattedTextField();
        kdtAssEntrys_femaleMarketed_TextField.setName("kdtAssEntrys_femaleMarketed_TextField");
        kdtAssEntrys_femaleMarketed_TextField.setVisible(true);
        kdtAssEntrys_femaleMarketed_TextField.setEditable(true);
        kdtAssEntrys_femaleMarketed_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_femaleMarketed_TextField.setDataType(0);
        KDTDefaultCellEditor kdtAssEntrys_femaleMarketed_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_femaleMarketed_TextField);
        this.kdtAssEntrys.getColumn("femaleMarketed").setEditor(kdtAssEntrys_femaleMarketed_CellEditor);
        KDFormattedTextField kdtAssEntrys_cullTotalWgt_TextField = new KDFormattedTextField();
        kdtAssEntrys_cullTotalWgt_TextField.setName("kdtAssEntrys_cullTotalWgt_TextField");
        kdtAssEntrys_cullTotalWgt_TextField.setVisible(true);
        kdtAssEntrys_cullTotalWgt_TextField.setEditable(true);
        kdtAssEntrys_cullTotalWgt_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_cullTotalWgt_TextField.setDataType(1);
        	kdtAssEntrys_cullTotalWgt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtAssEntrys_cullTotalWgt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtAssEntrys_cullTotalWgt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtAssEntrys_cullTotalWgt_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_cullTotalWgt_TextField);
        this.kdtAssEntrys.getColumn("cullTotalWgt").setEditor(kdtAssEntrys_cullTotalWgt_CellEditor);
        KDFormattedTextField kdtAssEntrys_cullTotalAmt_TextField = new KDFormattedTextField();
        kdtAssEntrys_cullTotalAmt_TextField.setName("kdtAssEntrys_cullTotalAmt_TextField");
        kdtAssEntrys_cullTotalAmt_TextField.setVisible(true);
        kdtAssEntrys_cullTotalAmt_TextField.setEditable(true);
        kdtAssEntrys_cullTotalAmt_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_cullTotalAmt_TextField.setDataType(1);
        	kdtAssEntrys_cullTotalAmt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtAssEntrys_cullTotalAmt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtAssEntrys_cullTotalAmt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtAssEntrys_cullTotalAmt_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_cullTotalAmt_TextField);
        this.kdtAssEntrys.getColumn("cullTotalAmt").setEditor(kdtAssEntrys_cullTotalAmt_CellEditor);
        KDFormattedTextField kdtAssEntrys_cullAvgPrice_TextField = new KDFormattedTextField();
        kdtAssEntrys_cullAvgPrice_TextField.setName("kdtAssEntrys_cullAvgPrice_TextField");
        kdtAssEntrys_cullAvgPrice_TextField.setVisible(true);
        kdtAssEntrys_cullAvgPrice_TextField.setEditable(true);
        kdtAssEntrys_cullAvgPrice_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_cullAvgPrice_TextField.setDataType(1);
        	kdtAssEntrys_cullAvgPrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtAssEntrys_cullAvgPrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtAssEntrys_cullAvgPrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtAssEntrys_cullAvgPrice_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_cullAvgPrice_TextField);
        this.kdtAssEntrys.getColumn("cullAvgPrice").setEditor(kdtAssEntrys_cullAvgPrice_CellEditor);
        KDTextField kdtAssEntrys_description_TextField = new KDTextField();
        kdtAssEntrys_description_TextField.setName("kdtAssEntrys_description_TextField");
        kdtAssEntrys_description_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtAssEntrys_description_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_description_TextField);
        this.kdtAssEntrys.getColumn("description").setEditor(kdtAssEntrys_description_CellEditor);
        KDFormattedTextField kdtAssEntrys_adjustQty_TextField = new KDFormattedTextField();
        kdtAssEntrys_adjustQty_TextField.setName("kdtAssEntrys_adjustQty_TextField");
        kdtAssEntrys_adjustQty_TextField.setVisible(true);
        kdtAssEntrys_adjustQty_TextField.setEditable(true);
        kdtAssEntrys_adjustQty_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_adjustQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtAssEntrys_adjustQty_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_adjustQty_TextField);
        this.kdtAssEntrys.getColumn("adjustQty").setEditor(kdtAssEntrys_adjustQty_CellEditor);
        KDFormattedTextField kdtAssEntrys_adjustFemaleQty_TextField = new KDFormattedTextField();
        kdtAssEntrys_adjustFemaleQty_TextField.setName("kdtAssEntrys_adjustFemaleQty_TextField");
        kdtAssEntrys_adjustFemaleQty_TextField.setVisible(true);
        kdtAssEntrys_adjustFemaleQty_TextField.setEditable(true);
        kdtAssEntrys_adjustFemaleQty_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_adjustFemaleQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtAssEntrys_adjustFemaleQty_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_adjustFemaleQty_TextField);
        this.kdtAssEntrys.getColumn("adjustFemaleQty").setEditor(kdtAssEntrys_adjustFemaleQty_CellEditor);
        KDFormattedTextField kdtAssEntrys_breedTime_TextField = new KDFormattedTextField();
        kdtAssEntrys_breedTime_TextField.setName("kdtAssEntrys_breedTime_TextField");
        kdtAssEntrys_breedTime_TextField.setVisible(true);
        kdtAssEntrys_breedTime_TextField.setEditable(true);
        kdtAssEntrys_breedTime_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_breedTime_TextField.setDataType(1);
        	kdtAssEntrys_breedTime_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtAssEntrys_breedTime_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtAssEntrys_breedTime_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtAssEntrys_breedTime_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_breedTime_TextField);
        this.kdtAssEntrys.getColumn("breedTime").setEditor(kdtAssEntrys_breedTime_CellEditor);
        KDFormattedTextField kdtAssEntrys_lightingTime_TextField = new KDFormattedTextField();
        kdtAssEntrys_lightingTime_TextField.setName("kdtAssEntrys_lightingTime_TextField");
        kdtAssEntrys_lightingTime_TextField.setVisible(true);
        kdtAssEntrys_lightingTime_TextField.setEditable(true);
        kdtAssEntrys_lightingTime_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_lightingTime_TextField.setDataType(1);
        	kdtAssEntrys_lightingTime_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtAssEntrys_lightingTime_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtAssEntrys_lightingTime_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtAssEntrys_lightingTime_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_lightingTime_TextField);
        this.kdtAssEntrys.getColumn("lightingTime").setEditor(kdtAssEntrys_lightingTime_CellEditor);
        KDFormattedTextField kdtAssEntrys_temperatureTo_TextField = new KDFormattedTextField();
        kdtAssEntrys_temperatureTo_TextField.setName("kdtAssEntrys_temperatureTo_TextField");
        kdtAssEntrys_temperatureTo_TextField.setVisible(true);
        kdtAssEntrys_temperatureTo_TextField.setEditable(true);
        kdtAssEntrys_temperatureTo_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_temperatureTo_TextField.setDataType(1);
        	kdtAssEntrys_temperatureTo_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtAssEntrys_temperatureTo_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtAssEntrys_temperatureTo_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtAssEntrys_temperatureTo_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_temperatureTo_TextField);
        this.kdtAssEntrys.getColumn("temperatureTo").setEditor(kdtAssEntrys_temperatureTo_CellEditor);
        KDFormattedTextField kdtAssEntrys_temperatureFrom_TextField = new KDFormattedTextField();
        kdtAssEntrys_temperatureFrom_TextField.setName("kdtAssEntrys_temperatureFrom_TextField");
        kdtAssEntrys_temperatureFrom_TextField.setVisible(true);
        kdtAssEntrys_temperatureFrom_TextField.setEditable(true);
        kdtAssEntrys_temperatureFrom_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_temperatureFrom_TextField.setDataType(1);
        	kdtAssEntrys_temperatureFrom_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtAssEntrys_temperatureFrom_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtAssEntrys_temperatureFrom_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtAssEntrys_temperatureFrom_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_temperatureFrom_TextField);
        this.kdtAssEntrys.getColumn("temperatureFrom").setEditor(kdtAssEntrys_temperatureFrom_CellEditor);
        KDFormattedTextField kdtAssEntrys_humidityTo_TextField = new KDFormattedTextField();
        kdtAssEntrys_humidityTo_TextField.setName("kdtAssEntrys_humidityTo_TextField");
        kdtAssEntrys_humidityTo_TextField.setVisible(true);
        kdtAssEntrys_humidityTo_TextField.setEditable(true);
        kdtAssEntrys_humidityTo_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_humidityTo_TextField.setDataType(1);
        	kdtAssEntrys_humidityTo_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtAssEntrys_humidityTo_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtAssEntrys_humidityTo_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtAssEntrys_humidityTo_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_humidityTo_TextField);
        this.kdtAssEntrys.getColumn("humidityTo").setEditor(kdtAssEntrys_humidityTo_CellEditor);
        KDFormattedTextField kdtAssEntrys_humidityFrom_TextField = new KDFormattedTextField();
        kdtAssEntrys_humidityFrom_TextField.setName("kdtAssEntrys_humidityFrom_TextField");
        kdtAssEntrys_humidityFrom_TextField.setVisible(true);
        kdtAssEntrys_humidityFrom_TextField.setEditable(true);
        kdtAssEntrys_humidityFrom_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_humidityFrom_TextField.setDataType(1);
        	kdtAssEntrys_humidityFrom_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtAssEntrys_humidityFrom_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtAssEntrys_humidityFrom_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtAssEntrys_humidityFrom_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_humidityFrom_TextField);
        this.kdtAssEntrys.getColumn("humidityFrom").setEditor(kdtAssEntrys_humidityFrom_CellEditor);
        KDFormattedTextField kdtAssEntrys_femaleLossW_TextField = new KDFormattedTextField();
        kdtAssEntrys_femaleLossW_TextField.setName("kdtAssEntrys_femaleLossW_TextField");
        kdtAssEntrys_femaleLossW_TextField.setVisible(true);
        kdtAssEntrys_femaleLossW_TextField.setEditable(true);
        kdtAssEntrys_femaleLossW_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_femaleLossW_TextField.setDataType(1);
        	kdtAssEntrys_femaleLossW_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtAssEntrys_femaleLossW_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtAssEntrys_femaleLossW_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtAssEntrys_femaleLossW_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_femaleLossW_TextField);
        this.kdtAssEntrys.getColumn("femaleLossW").setEditor(kdtAssEntrys_femaleLossW_CellEditor);
        KDFormattedTextField kdtAssEntrys_maleLossW_TextField = new KDFormattedTextField();
        kdtAssEntrys_maleLossW_TextField.setName("kdtAssEntrys_maleLossW_TextField");
        kdtAssEntrys_maleLossW_TextField.setVisible(true);
        kdtAssEntrys_maleLossW_TextField.setEditable(true);
        kdtAssEntrys_maleLossW_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_maleLossW_TextField.setDataType(1);
        	kdtAssEntrys_maleLossW_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtAssEntrys_maleLossW_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtAssEntrys_maleLossW_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtAssEntrys_maleLossW_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_maleLossW_TextField);
        this.kdtAssEntrys.getColumn("maleLossW").setEditor(kdtAssEntrys_maleLossW_CellEditor);
        KDFormattedTextField kdtAssEntrys_femaleLossRate_TextField = new KDFormattedTextField();
        kdtAssEntrys_femaleLossRate_TextField.setName("kdtAssEntrys_femaleLossRate_TextField");
        kdtAssEntrys_femaleLossRate_TextField.setVisible(true);
        kdtAssEntrys_femaleLossRate_TextField.setEditable(true);
        kdtAssEntrys_femaleLossRate_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_femaleLossRate_TextField.setDataType(1);
        	kdtAssEntrys_femaleLossRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtAssEntrys_femaleLossRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtAssEntrys_femaleLossRate_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtAssEntrys_femaleLossRate_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_femaleLossRate_TextField);
        this.kdtAssEntrys.getColumn("femaleLossRate").setEditor(kdtAssEntrys_femaleLossRate_CellEditor);
        KDFormattedTextField kdtAssEntrys_maleLossRate_TextField = new KDFormattedTextField();
        kdtAssEntrys_maleLossRate_TextField.setName("kdtAssEntrys_maleLossRate_TextField");
        kdtAssEntrys_maleLossRate_TextField.setVisible(true);
        kdtAssEntrys_maleLossRate_TextField.setEditable(true);
        kdtAssEntrys_maleLossRate_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_maleLossRate_TextField.setDataType(1);
        	kdtAssEntrys_maleLossRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtAssEntrys_maleLossRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtAssEntrys_maleLossRate_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtAssEntrys_maleLossRate_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_maleLossRate_TextField);
        this.kdtAssEntrys.getColumn("maleLossRate").setEditor(kdtAssEntrys_maleLossRate_CellEditor);
        KDFormattedTextField kdtAssEntrys_femaleLossStand_TextField = new KDFormattedTextField();
        kdtAssEntrys_femaleLossStand_TextField.setName("kdtAssEntrys_femaleLossStand_TextField");
        kdtAssEntrys_femaleLossStand_TextField.setVisible(true);
        kdtAssEntrys_femaleLossStand_TextField.setEditable(true);
        kdtAssEntrys_femaleLossStand_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_femaleLossStand_TextField.setDataType(1);
        	kdtAssEntrys_femaleLossStand_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtAssEntrys_femaleLossStand_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtAssEntrys_femaleLossStand_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtAssEntrys_femaleLossStand_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_femaleLossStand_TextField);
        this.kdtAssEntrys.getColumn("femaleLossStand").setEditor(kdtAssEntrys_femaleLossStand_CellEditor);
        KDFormattedTextField kdtAssEntrys_maleLossStand_TextField = new KDFormattedTextField();
        kdtAssEntrys_maleLossStand_TextField.setName("kdtAssEntrys_maleLossStand_TextField");
        kdtAssEntrys_maleLossStand_TextField.setVisible(true);
        kdtAssEntrys_maleLossStand_TextField.setEditable(true);
        kdtAssEntrys_maleLossStand_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_maleLossStand_TextField.setDataType(1);
        	kdtAssEntrys_maleLossStand_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtAssEntrys_maleLossStand_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtAssEntrys_maleLossStand_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtAssEntrys_maleLossStand_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_maleLossStand_TextField);
        this.kdtAssEntrys.getColumn("maleLossStand").setEditor(kdtAssEntrys_maleLossStand_CellEditor);
        KDFormattedTextField kdtAssEntrys_femaleLosWeiRate_TextField = new KDFormattedTextField();
        kdtAssEntrys_femaleLosWeiRate_TextField.setName("kdtAssEntrys_femaleLosWeiRate_TextField");
        kdtAssEntrys_femaleLosWeiRate_TextField.setVisible(true);
        kdtAssEntrys_femaleLosWeiRate_TextField.setEditable(true);
        kdtAssEntrys_femaleLosWeiRate_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_femaleLosWeiRate_TextField.setDataType(1);
        	kdtAssEntrys_femaleLosWeiRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtAssEntrys_femaleLosWeiRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtAssEntrys_femaleLosWeiRate_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtAssEntrys_femaleLosWeiRate_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_femaleLosWeiRate_TextField);
        this.kdtAssEntrys.getColumn("femaleLosWeiRate").setEditor(kdtAssEntrys_femaleLosWeiRate_CellEditor);
        KDFormattedTextField kdtAssEntrys_maleLosWeiStand_TextField = new KDFormattedTextField();
        kdtAssEntrys_maleLosWeiStand_TextField.setName("kdtAssEntrys_maleLosWeiStand_TextField");
        kdtAssEntrys_maleLosWeiStand_TextField.setVisible(true);
        kdtAssEntrys_maleLosWeiStand_TextField.setEditable(true);
        kdtAssEntrys_maleLosWeiStand_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_maleLosWeiStand_TextField.setDataType(1);
        	kdtAssEntrys_maleLosWeiStand_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtAssEntrys_maleLosWeiStand_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtAssEntrys_maleLosWeiStand_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtAssEntrys_maleLosWeiStand_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_maleLosWeiStand_TextField);
        this.kdtAssEntrys.getColumn("maleLosWeiStand").setEditor(kdtAssEntrys_maleLosWeiStand_CellEditor);
        // kdtEggEntry
		String kdtEggEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol16\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol17\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol18\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol19\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol20\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol21\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol22\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"px\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"house\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"materialName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"allQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"runQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"qcEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"unQCEgg\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"mutnatQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"zd\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"brokenQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"fxd\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"doubleQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"BBQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /><t:Column t:key=\"rd\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"smallEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"totalLossQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol19\" /><t:Column t:key=\"firstQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol20\" /><t:Column t:key=\"dz\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol21\" /><t:Column t:key=\"eggRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol22\" /><t:Column t:key=\"description\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{px}</t:Cell><t:Cell>$Resource{house}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{model}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{allQty}</t:Cell><t:Cell>$Resource{runQty}</t:Cell><t:Cell>$Resource{qcEggQty}</t:Cell><t:Cell>$Resource{unQCEgg}</t:Cell><t:Cell>$Resource{mutnatQty}</t:Cell><t:Cell>$Resource{zd}</t:Cell><t:Cell>$Resource{brokenQty}</t:Cell><t:Cell>$Resource{fxd}</t:Cell><t:Cell>$Resource{doubleQty}</t:Cell><t:Cell>$Resource{BBQty}</t:Cell><t:Cell>$Resource{rd}</t:Cell><t:Cell>$Resource{smallEggQty}</t:Cell><t:Cell>$Resource{totalLossQty}</t:Cell><t:Cell>$Resource{firstQty}</t:Cell><t:Cell>$Resource{dz}</t:Cell><t:Cell>$Resource{eggRate}</t:Cell><t:Cell>$Resource{description}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEggEntry.setFormatXml(resHelper.translateString("kdtEggEntry",kdtEggEntryStrXML));
        kdtEggEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtEggEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtEggEntry.putBindContents("editData",new String[] {"seq","px","house","material","materialName","model","unit","allQty","runQty","qcEggQty","unQCEgg","mutnatQty","zd","brokenQty","fxd","doubleQty","BBQty","rd","smallEggQty","totalLossQty","firstQty","dz","eggRate","description"});


        this.kdtEggEntry.checkParsed();
        KDComboBox kdtEggEntry_px_ComboBox = new KDComboBox();
        kdtEggEntry_px_ComboBox.setName("kdtEggEntry_px_ComboBox");
        kdtEggEntry_px_ComboBox.setVisible(true);
        kdtEggEntry_px_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.hatch.GenderType").toArray());
        KDTDefaultCellEditor kdtEggEntry_px_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_px_ComboBox);
        this.kdtEggEntry.getColumn("px").setEditor(kdtEggEntry_px_CellEditor);
        final KDBizPromptBox kdtEggEntry_house_PromptBox = new KDBizPromptBox();
        kdtEggEntry_house_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
        kdtEggEntry_house_PromptBox.setVisible(true);
        kdtEggEntry_house_PromptBox.setEditable(true);
        kdtEggEntry_house_PromptBox.setDisplayFormat("$number$");
        kdtEggEntry_house_PromptBox.setEditFormat("$number$");
        kdtEggEntry_house_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntry_house_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_house_PromptBox);
        this.kdtEggEntry.getColumn("house").setEditor(kdtEggEntry_house_CellEditor);
        ObjectValueRender kdtEggEntry_house_OVR = new ObjectValueRender();
        kdtEggEntry_house_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntry.getColumn("house").setRenderer(kdtEggEntry_house_OVR);
        final KDBizPromptBox kdtEggEntry_material_PromptBox = new KDBizPromptBox();
        kdtEggEntry_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtEggEntry_material_PromptBox.setVisible(true);
        kdtEggEntry_material_PromptBox.setEditable(true);
        kdtEggEntry_material_PromptBox.setDisplayFormat("$number$");
        kdtEggEntry_material_PromptBox.setEditFormat("$number$");
        kdtEggEntry_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntry_material_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_material_PromptBox);
        this.kdtEggEntry.getColumn("material").setEditor(kdtEggEntry_material_CellEditor);
        ObjectValueRender kdtEggEntry_material_OVR = new ObjectValueRender();
        kdtEggEntry_material_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEggEntry.getColumn("material").setRenderer(kdtEggEntry_material_OVR);
        KDTextField kdtEggEntry_materialName_TextField = new KDTextField();
        kdtEggEntry_materialName_TextField.setName("kdtEggEntry_materialName_TextField");
        kdtEggEntry_materialName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEggEntry_materialName_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_materialName_TextField);
        this.kdtEggEntry.getColumn("materialName").setEditor(kdtEggEntry_materialName_CellEditor);
        KDTextField kdtEggEntry_model_TextField = new KDTextField();
        kdtEggEntry_model_TextField.setName("kdtEggEntry_model_TextField");
        kdtEggEntry_model_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEggEntry_model_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_model_TextField);
        this.kdtEggEntry.getColumn("model").setEditor(kdtEggEntry_model_CellEditor);
        final KDBizPromptBox kdtEggEntry_unit_PromptBox = new KDBizPromptBox();
        kdtEggEntry_unit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtEggEntry_unit_PromptBox.setVisible(true);
        kdtEggEntry_unit_PromptBox.setEditable(true);
        kdtEggEntry_unit_PromptBox.setDisplayFormat("$number$");
        kdtEggEntry_unit_PromptBox.setEditFormat("$number$");
        kdtEggEntry_unit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntry_unit_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_unit_PromptBox);
        this.kdtEggEntry.getColumn("unit").setEditor(kdtEggEntry_unit_CellEditor);
        ObjectValueRender kdtEggEntry_unit_OVR = new ObjectValueRender();
        kdtEggEntry_unit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntry.getColumn("unit").setRenderer(kdtEggEntry_unit_OVR);
        KDFormattedTextField kdtEggEntry_allQty_TextField = new KDFormattedTextField();
        kdtEggEntry_allQty_TextField.setName("kdtEggEntry_allQty_TextField");
        kdtEggEntry_allQty_TextField.setVisible(true);
        kdtEggEntry_allQty_TextField.setEditable(true);
        kdtEggEntry_allQty_TextField.setHorizontalAlignment(2);
        kdtEggEntry_allQty_TextField.setDataType(1);
        	kdtEggEntry_allQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEggEntry_allQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEggEntry_allQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEggEntry_allQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_allQty_TextField);
        this.kdtEggEntry.getColumn("allQty").setEditor(kdtEggEntry_allQty_CellEditor);
        KDFormattedTextField kdtEggEntry_runQty_TextField = new KDFormattedTextField();
        kdtEggEntry_runQty_TextField.setName("kdtEggEntry_runQty_TextField");
        kdtEggEntry_runQty_TextField.setVisible(true);
        kdtEggEntry_runQty_TextField.setEditable(true);
        kdtEggEntry_runQty_TextField.setHorizontalAlignment(2);
        kdtEggEntry_runQty_TextField.setDataType(1);
        	kdtEggEntry_runQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEggEntry_runQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEggEntry_runQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEggEntry_runQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_runQty_TextField);
        this.kdtEggEntry.getColumn("runQty").setEditor(kdtEggEntry_runQty_CellEditor);
        KDFormattedTextField kdtEggEntry_qcEggQty_TextField = new KDFormattedTextField();
        kdtEggEntry_qcEggQty_TextField.setName("kdtEggEntry_qcEggQty_TextField");
        kdtEggEntry_qcEggQty_TextField.setVisible(true);
        kdtEggEntry_qcEggQty_TextField.setEditable(true);
        kdtEggEntry_qcEggQty_TextField.setHorizontalAlignment(2);
        kdtEggEntry_qcEggQty_TextField.setDataType(1);
        	kdtEggEntry_qcEggQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEggEntry_qcEggQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEggEntry_qcEggQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEggEntry_qcEggQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_qcEggQty_TextField);
        this.kdtEggEntry.getColumn("qcEggQty").setEditor(kdtEggEntry_qcEggQty_CellEditor);
        KDFormattedTextField kdtEggEntry_unQCEgg_TextField = new KDFormattedTextField();
        kdtEggEntry_unQCEgg_TextField.setName("kdtEggEntry_unQCEgg_TextField");
        kdtEggEntry_unQCEgg_TextField.setVisible(true);
        kdtEggEntry_unQCEgg_TextField.setEditable(true);
        kdtEggEntry_unQCEgg_TextField.setHorizontalAlignment(2);
        kdtEggEntry_unQCEgg_TextField.setDataType(1);
        	kdtEggEntry_unQCEgg_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEggEntry_unQCEgg_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEggEntry_unQCEgg_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEggEntry_unQCEgg_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_unQCEgg_TextField);
        this.kdtEggEntry.getColumn("unQCEgg").setEditor(kdtEggEntry_unQCEgg_CellEditor);
        KDFormattedTextField kdtEggEntry_mutnatQty_TextField = new KDFormattedTextField();
        kdtEggEntry_mutnatQty_TextField.setName("kdtEggEntry_mutnatQty_TextField");
        kdtEggEntry_mutnatQty_TextField.setVisible(true);
        kdtEggEntry_mutnatQty_TextField.setEditable(true);
        kdtEggEntry_mutnatQty_TextField.setHorizontalAlignment(2);
        kdtEggEntry_mutnatQty_TextField.setDataType(1);
        	kdtEggEntry_mutnatQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEggEntry_mutnatQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEggEntry_mutnatQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEggEntry_mutnatQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_mutnatQty_TextField);
        this.kdtEggEntry.getColumn("mutnatQty").setEditor(kdtEggEntry_mutnatQty_CellEditor);
        KDFormattedTextField kdtEggEntry_zd_TextField = new KDFormattedTextField();
        kdtEggEntry_zd_TextField.setName("kdtEggEntry_zd_TextField");
        kdtEggEntry_zd_TextField.setVisible(true);
        kdtEggEntry_zd_TextField.setEditable(true);
        kdtEggEntry_zd_TextField.setHorizontalAlignment(2);
        kdtEggEntry_zd_TextField.setDataType(1);
        	kdtEggEntry_zd_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEggEntry_zd_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEggEntry_zd_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEggEntry_zd_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_zd_TextField);
        this.kdtEggEntry.getColumn("zd").setEditor(kdtEggEntry_zd_CellEditor);
        KDFormattedTextField kdtEggEntry_brokenQty_TextField = new KDFormattedTextField();
        kdtEggEntry_brokenQty_TextField.setName("kdtEggEntry_brokenQty_TextField");
        kdtEggEntry_brokenQty_TextField.setVisible(true);
        kdtEggEntry_brokenQty_TextField.setEditable(true);
        kdtEggEntry_brokenQty_TextField.setHorizontalAlignment(2);
        kdtEggEntry_brokenQty_TextField.setDataType(1);
        	kdtEggEntry_brokenQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEggEntry_brokenQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEggEntry_brokenQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEggEntry_brokenQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_brokenQty_TextField);
        this.kdtEggEntry.getColumn("brokenQty").setEditor(kdtEggEntry_brokenQty_CellEditor);
        KDFormattedTextField kdtEggEntry_fxd_TextField = new KDFormattedTextField();
        kdtEggEntry_fxd_TextField.setName("kdtEggEntry_fxd_TextField");
        kdtEggEntry_fxd_TextField.setVisible(true);
        kdtEggEntry_fxd_TextField.setEditable(true);
        kdtEggEntry_fxd_TextField.setHorizontalAlignment(2);
        kdtEggEntry_fxd_TextField.setDataType(1);
        	kdtEggEntry_fxd_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEggEntry_fxd_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEggEntry_fxd_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEggEntry_fxd_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_fxd_TextField);
        this.kdtEggEntry.getColumn("fxd").setEditor(kdtEggEntry_fxd_CellEditor);
        KDFormattedTextField kdtEggEntry_doubleQty_TextField = new KDFormattedTextField();
        kdtEggEntry_doubleQty_TextField.setName("kdtEggEntry_doubleQty_TextField");
        kdtEggEntry_doubleQty_TextField.setVisible(true);
        kdtEggEntry_doubleQty_TextField.setEditable(true);
        kdtEggEntry_doubleQty_TextField.setHorizontalAlignment(2);
        kdtEggEntry_doubleQty_TextField.setDataType(1);
        	kdtEggEntry_doubleQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEggEntry_doubleQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEggEntry_doubleQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEggEntry_doubleQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_doubleQty_TextField);
        this.kdtEggEntry.getColumn("doubleQty").setEditor(kdtEggEntry_doubleQty_CellEditor);
        KDFormattedTextField kdtEggEntry_BBQty_TextField = new KDFormattedTextField();
        kdtEggEntry_BBQty_TextField.setName("kdtEggEntry_BBQty_TextField");
        kdtEggEntry_BBQty_TextField.setVisible(true);
        kdtEggEntry_BBQty_TextField.setEditable(true);
        kdtEggEntry_BBQty_TextField.setHorizontalAlignment(2);
        kdtEggEntry_BBQty_TextField.setDataType(1);
        	kdtEggEntry_BBQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEggEntry_BBQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEggEntry_BBQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEggEntry_BBQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_BBQty_TextField);
        this.kdtEggEntry.getColumn("BBQty").setEditor(kdtEggEntry_BBQty_CellEditor);
        KDFormattedTextField kdtEggEntry_rd_TextField = new KDFormattedTextField();
        kdtEggEntry_rd_TextField.setName("kdtEggEntry_rd_TextField");
        kdtEggEntry_rd_TextField.setVisible(true);
        kdtEggEntry_rd_TextField.setEditable(true);
        kdtEggEntry_rd_TextField.setHorizontalAlignment(2);
        kdtEggEntry_rd_TextField.setDataType(1);
        	kdtEggEntry_rd_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEggEntry_rd_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEggEntry_rd_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEggEntry_rd_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_rd_TextField);
        this.kdtEggEntry.getColumn("rd").setEditor(kdtEggEntry_rd_CellEditor);
        KDFormattedTextField kdtEggEntry_smallEggQty_TextField = new KDFormattedTextField();
        kdtEggEntry_smallEggQty_TextField.setName("kdtEggEntry_smallEggQty_TextField");
        kdtEggEntry_smallEggQty_TextField.setVisible(true);
        kdtEggEntry_smallEggQty_TextField.setEditable(true);
        kdtEggEntry_smallEggQty_TextField.setHorizontalAlignment(2);
        kdtEggEntry_smallEggQty_TextField.setDataType(1);
        	kdtEggEntry_smallEggQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEggEntry_smallEggQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEggEntry_smallEggQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEggEntry_smallEggQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_smallEggQty_TextField);
        this.kdtEggEntry.getColumn("smallEggQty").setEditor(kdtEggEntry_smallEggQty_CellEditor);
        KDFormattedTextField kdtEggEntry_totalLossQty_TextField = new KDFormattedTextField();
        kdtEggEntry_totalLossQty_TextField.setName("kdtEggEntry_totalLossQty_TextField");
        kdtEggEntry_totalLossQty_TextField.setVisible(true);
        kdtEggEntry_totalLossQty_TextField.setEditable(true);
        kdtEggEntry_totalLossQty_TextField.setHorizontalAlignment(2);
        kdtEggEntry_totalLossQty_TextField.setDataType(1);
        	kdtEggEntry_totalLossQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEggEntry_totalLossQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEggEntry_totalLossQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEggEntry_totalLossQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_totalLossQty_TextField);
        this.kdtEggEntry.getColumn("totalLossQty").setEditor(kdtEggEntry_totalLossQty_CellEditor);
        KDFormattedTextField kdtEggEntry_firstQty_TextField = new KDFormattedTextField();
        kdtEggEntry_firstQty_TextField.setName("kdtEggEntry_firstQty_TextField");
        kdtEggEntry_firstQty_TextField.setVisible(true);
        kdtEggEntry_firstQty_TextField.setEditable(true);
        kdtEggEntry_firstQty_TextField.setHorizontalAlignment(2);
        kdtEggEntry_firstQty_TextField.setDataType(1);
        	kdtEggEntry_firstQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEggEntry_firstQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEggEntry_firstQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEggEntry_firstQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_firstQty_TextField);
        this.kdtEggEntry.getColumn("firstQty").setEditor(kdtEggEntry_firstQty_CellEditor);
        KDFormattedTextField kdtEggEntry_dz_TextField = new KDFormattedTextField();
        kdtEggEntry_dz_TextField.setName("kdtEggEntry_dz_TextField");
        kdtEggEntry_dz_TextField.setVisible(true);
        kdtEggEntry_dz_TextField.setEditable(true);
        kdtEggEntry_dz_TextField.setHorizontalAlignment(2);
        kdtEggEntry_dz_TextField.setDataType(1);
        	kdtEggEntry_dz_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEggEntry_dz_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEggEntry_dz_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEggEntry_dz_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_dz_TextField);
        this.kdtEggEntry.getColumn("dz").setEditor(kdtEggEntry_dz_CellEditor);
        KDFormattedTextField kdtEggEntry_eggRate_TextField = new KDFormattedTextField();
        kdtEggEntry_eggRate_TextField.setName("kdtEggEntry_eggRate_TextField");
        kdtEggEntry_eggRate_TextField.setVisible(true);
        kdtEggEntry_eggRate_TextField.setEditable(true);
        kdtEggEntry_eggRate_TextField.setHorizontalAlignment(2);
        kdtEggEntry_eggRate_TextField.setDataType(1);
        	kdtEggEntry_eggRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEggEntry_eggRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEggEntry_eggRate_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEggEntry_eggRate_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_eggRate_TextField);
        this.kdtEggEntry.getColumn("eggRate").setEditor(kdtEggEntry_eggRate_CellEditor);
        KDTextField kdtEggEntry_description_TextField = new KDTextField();
        kdtEggEntry_description_TextField.setName("kdtEggEntry_description_TextField");
        kdtEggEntry_description_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEggEntry_description_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_description_TextField);
        this.kdtEggEntry.getColumn("description").setEditor(kdtEggEntry_description_CellEditor);
        // kdtSendEggEntry
		String kdtSendEggEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"house\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"allQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"qcQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{house}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{allQty}</t:Cell><t:Cell>$Resource{qcQty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtSendEggEntry.setFormatXml(resHelper.translateString("kdtSendEggEntry",kdtSendEggEntryStrXML));		
        this.kdtSendEggEntry.setVisible(false);

                this.kdtSendEggEntry.putBindContents("editData",new String[] {"seq","house","material","allQty","qcQty"});


        this.kdtSendEggEntry.checkParsed();
        final KDBizPromptBox kdtSendEggEntry_house_PromptBox = new KDBizPromptBox();
        kdtSendEggEntry_house_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
        kdtSendEggEntry_house_PromptBox.setVisible(true);
        kdtSendEggEntry_house_PromptBox.setEditable(true);
        kdtSendEggEntry_house_PromptBox.setDisplayFormat("$number$");
        kdtSendEggEntry_house_PromptBox.setEditFormat("$number$");
        kdtSendEggEntry_house_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtSendEggEntry_house_CellEditor = new KDTDefaultCellEditor(kdtSendEggEntry_house_PromptBox);
        this.kdtSendEggEntry.getColumn("house").setEditor(kdtSendEggEntry_house_CellEditor);
        ObjectValueRender kdtSendEggEntry_house_OVR = new ObjectValueRender();
        kdtSendEggEntry_house_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtSendEggEntry.getColumn("house").setRenderer(kdtSendEggEntry_house_OVR);
        final KDBizPromptBox kdtSendEggEntry_material_PromptBox = new KDBizPromptBox();
        kdtSendEggEntry_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtSendEggEntry_material_PromptBox.setVisible(true);
        kdtSendEggEntry_material_PromptBox.setEditable(true);
        kdtSendEggEntry_material_PromptBox.setDisplayFormat("$number$");
        kdtSendEggEntry_material_PromptBox.setEditFormat("$number$");
        kdtSendEggEntry_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtSendEggEntry_material_CellEditor = new KDTDefaultCellEditor(kdtSendEggEntry_material_PromptBox);
        this.kdtSendEggEntry.getColumn("material").setEditor(kdtSendEggEntry_material_CellEditor);
        ObjectValueRender kdtSendEggEntry_material_OVR = new ObjectValueRender();
        kdtSendEggEntry_material_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtSendEggEntry.getColumn("material").setRenderer(kdtSendEggEntry_material_OVR);
        KDFormattedTextField kdtSendEggEntry_allQty_TextField = new KDFormattedTextField();
        kdtSendEggEntry_allQty_TextField.setName("kdtSendEggEntry_allQty_TextField");
        kdtSendEggEntry_allQty_TextField.setVisible(true);
        kdtSendEggEntry_allQty_TextField.setEditable(true);
        kdtSendEggEntry_allQty_TextField.setHorizontalAlignment(2);
        kdtSendEggEntry_allQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtSendEggEntry_allQty_CellEditor = new KDTDefaultCellEditor(kdtSendEggEntry_allQty_TextField);
        this.kdtSendEggEntry.getColumn("allQty").setEditor(kdtSendEggEntry_allQty_CellEditor);
        KDFormattedTextField kdtSendEggEntry_qcQty_TextField = new KDFormattedTextField();
        kdtSendEggEntry_qcQty_TextField.setName("kdtSendEggEntry_qcQty_TextField");
        kdtSendEggEntry_qcQty_TextField.setVisible(true);
        kdtSendEggEntry_qcQty_TextField.setEditable(true);
        kdtSendEggEntry_qcQty_TextField.setHorizontalAlignment(2);
        kdtSendEggEntry_qcQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtSendEggEntry_qcQty_CellEditor = new KDTDefaultCellEditor(kdtSendEggEntry_qcQty_TextField);
        this.kdtSendEggEntry.getColumn("qcQty").setEditor(kdtSendEggEntry_qcQty_CellEditor);
        // kdtImmuneEntrys
		String kdtImmuneEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol16\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"house\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"vaccineMaterial\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"vaccineName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"vaccineUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"vaccineGetQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"vaccineUsedQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"dose\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"vaccineWay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"lot\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"supplier\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"manuDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"effectiveDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"responsible\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"descriptionNew\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"baseUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{house}</t:Cell><t:Cell>$Resource{vaccineMaterial}</t:Cell><t:Cell>$Resource{vaccineName}</t:Cell><t:Cell>$Resource{vaccineUnit}</t:Cell><t:Cell>$Resource{model}</t:Cell><t:Cell>$Resource{vaccineGetQty}</t:Cell><t:Cell>$Resource{vaccineUsedQty}</t:Cell><t:Cell>$Resource{dose}</t:Cell><t:Cell>$Resource{vaccineWay}</t:Cell><t:Cell>$Resource{lot}</t:Cell><t:Cell>$Resource{supplier}</t:Cell><t:Cell>$Resource{manuDate}</t:Cell><t:Cell>$Resource{effectiveDate}</t:Cell><t:Cell>$Resource{responsible}</t:Cell><t:Cell>$Resource{descriptionNew}</t:Cell><t:Cell>$Resource{baseUnit}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtImmuneEntrys.setFormatXml(resHelper.translateString("kdtImmuneEntrys",kdtImmuneEntrysStrXML));
        kdtImmuneEntrys.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtImmuneEntrys_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtImmuneEntrys.putBindContents("editData",new String[] {"seq","house","vaccineMaterial","vaccineName","vaccineUnit","model","vaccineGetQty","vaccineUsedQty","dose","vaccineWay","lot","supplier","manuDate","effectiveDate","responsible","descriptionNew","baseUnit"});


        this.kdtImmuneEntrys.checkParsed();
        final KDBizPromptBox kdtImmuneEntrys_house_PromptBox = new KDBizPromptBox();
        kdtImmuneEntrys_house_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
        kdtImmuneEntrys_house_PromptBox.setVisible(true);
        kdtImmuneEntrys_house_PromptBox.setEditable(true);
        kdtImmuneEntrys_house_PromptBox.setDisplayFormat("$number$");
        kdtImmuneEntrys_house_PromptBox.setEditFormat("$number$");
        kdtImmuneEntrys_house_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtImmuneEntrys_house_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_house_PromptBox);
        this.kdtImmuneEntrys.getColumn("house").setEditor(kdtImmuneEntrys_house_CellEditor);
        ObjectValueRender kdtImmuneEntrys_house_OVR = new ObjectValueRender();
        kdtImmuneEntrys_house_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtImmuneEntrys.getColumn("house").setRenderer(kdtImmuneEntrys_house_OVR);
        final KDBizPromptBox kdtImmuneEntrys_vaccineMaterial_PromptBox = new KDBizPromptBox();
        kdtImmuneEntrys_vaccineMaterial_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtImmuneEntrys_vaccineMaterial_PromptBox.setVisible(true);
        kdtImmuneEntrys_vaccineMaterial_PromptBox.setEditable(true);
        kdtImmuneEntrys_vaccineMaterial_PromptBox.setDisplayFormat("$number$");
        kdtImmuneEntrys_vaccineMaterial_PromptBox.setEditFormat("$number$");
        kdtImmuneEntrys_vaccineMaterial_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtImmuneEntrys_vaccineMaterial_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_vaccineMaterial_PromptBox);
        this.kdtImmuneEntrys.getColumn("vaccineMaterial").setEditor(kdtImmuneEntrys_vaccineMaterial_CellEditor);
        ObjectValueRender kdtImmuneEntrys_vaccineMaterial_OVR = new ObjectValueRender();
        kdtImmuneEntrys_vaccineMaterial_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtImmuneEntrys.getColumn("vaccineMaterial").setRenderer(kdtImmuneEntrys_vaccineMaterial_OVR);
        KDTextField kdtImmuneEntrys_vaccineName_TextField = new KDTextField();
        kdtImmuneEntrys_vaccineName_TextField.setName("kdtImmuneEntrys_vaccineName_TextField");
        kdtImmuneEntrys_vaccineName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtImmuneEntrys_vaccineName_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_vaccineName_TextField);
        this.kdtImmuneEntrys.getColumn("vaccineName").setEditor(kdtImmuneEntrys_vaccineName_CellEditor);
        KDTextField kdtImmuneEntrys_vaccineUnit_TextField = new KDTextField();
        kdtImmuneEntrys_vaccineUnit_TextField.setName("kdtImmuneEntrys_vaccineUnit_TextField");
        kdtImmuneEntrys_vaccineUnit_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtImmuneEntrys_vaccineUnit_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_vaccineUnit_TextField);
        this.kdtImmuneEntrys.getColumn("vaccineUnit").setEditor(kdtImmuneEntrys_vaccineUnit_CellEditor);
        KDTextField kdtImmuneEntrys_model_TextField = new KDTextField();
        kdtImmuneEntrys_model_TextField.setName("kdtImmuneEntrys_model_TextField");
        kdtImmuneEntrys_model_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtImmuneEntrys_model_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_model_TextField);
        this.kdtImmuneEntrys.getColumn("model").setEditor(kdtImmuneEntrys_model_CellEditor);
        KDFormattedTextField kdtImmuneEntrys_vaccineGetQty_TextField = new KDFormattedTextField();
        kdtImmuneEntrys_vaccineGetQty_TextField.setName("kdtImmuneEntrys_vaccineGetQty_TextField");
        kdtImmuneEntrys_vaccineGetQty_TextField.setVisible(true);
        kdtImmuneEntrys_vaccineGetQty_TextField.setEditable(true);
        kdtImmuneEntrys_vaccineGetQty_TextField.setHorizontalAlignment(2);
        kdtImmuneEntrys_vaccineGetQty_TextField.setDataType(1);
        	kdtImmuneEntrys_vaccineGetQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtImmuneEntrys_vaccineGetQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtImmuneEntrys_vaccineGetQty_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtImmuneEntrys_vaccineGetQty_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_vaccineGetQty_TextField);
        this.kdtImmuneEntrys.getColumn("vaccineGetQty").setEditor(kdtImmuneEntrys_vaccineGetQty_CellEditor);
        KDFormattedTextField kdtImmuneEntrys_vaccineUsedQty_TextField = new KDFormattedTextField();
        kdtImmuneEntrys_vaccineUsedQty_TextField.setName("kdtImmuneEntrys_vaccineUsedQty_TextField");
        kdtImmuneEntrys_vaccineUsedQty_TextField.setVisible(true);
        kdtImmuneEntrys_vaccineUsedQty_TextField.setEditable(true);
        kdtImmuneEntrys_vaccineUsedQty_TextField.setHorizontalAlignment(2);
        kdtImmuneEntrys_vaccineUsedQty_TextField.setDataType(1);
        	kdtImmuneEntrys_vaccineUsedQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtImmuneEntrys_vaccineUsedQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtImmuneEntrys_vaccineUsedQty_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtImmuneEntrys_vaccineUsedQty_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_vaccineUsedQty_TextField);
        this.kdtImmuneEntrys.getColumn("vaccineUsedQty").setEditor(kdtImmuneEntrys_vaccineUsedQty_CellEditor);
        KDFormattedTextField kdtImmuneEntrys_dose_TextField = new KDFormattedTextField();
        kdtImmuneEntrys_dose_TextField.setName("kdtImmuneEntrys_dose_TextField");
        kdtImmuneEntrys_dose_TextField.setVisible(true);
        kdtImmuneEntrys_dose_TextField.setEditable(true);
        kdtImmuneEntrys_dose_TextField.setHorizontalAlignment(2);
        kdtImmuneEntrys_dose_TextField.setDataType(1);
        	kdtImmuneEntrys_dose_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtImmuneEntrys_dose_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtImmuneEntrys_dose_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtImmuneEntrys_dose_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_dose_TextField);
        this.kdtImmuneEntrys.getColumn("dose").setEditor(kdtImmuneEntrys_dose_CellEditor);
        final KDBizPromptBox kdtImmuneEntrys_vaccineWay_PromptBox = new KDBizPromptBox();
        kdtImmuneEntrys_vaccineWay_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.ImmuneWayQuery");
        kdtImmuneEntrys_vaccineWay_PromptBox.setVisible(true);
        kdtImmuneEntrys_vaccineWay_PromptBox.setEditable(true);
        kdtImmuneEntrys_vaccineWay_PromptBox.setDisplayFormat("$number$");
        kdtImmuneEntrys_vaccineWay_PromptBox.setEditFormat("$number$");
        kdtImmuneEntrys_vaccineWay_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtImmuneEntrys_vaccineWay_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_vaccineWay_PromptBox);
        this.kdtImmuneEntrys.getColumn("vaccineWay").setEditor(kdtImmuneEntrys_vaccineWay_CellEditor);
        ObjectValueRender kdtImmuneEntrys_vaccineWay_OVR = new ObjectValueRender();
        kdtImmuneEntrys_vaccineWay_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtImmuneEntrys.getColumn("vaccineWay").setRenderer(kdtImmuneEntrys_vaccineWay_OVR);
        KDTextField kdtImmuneEntrys_lot_TextField = new KDTextField();
        kdtImmuneEntrys_lot_TextField.setName("kdtImmuneEntrys_lot_TextField");
        kdtImmuneEntrys_lot_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtImmuneEntrys_lot_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_lot_TextField);
        this.kdtImmuneEntrys.getColumn("lot").setEditor(kdtImmuneEntrys_lot_CellEditor);
        KDTextField kdtImmuneEntrys_supplier_TextField = new KDTextField();
        kdtImmuneEntrys_supplier_TextField.setName("kdtImmuneEntrys_supplier_TextField");
        kdtImmuneEntrys_supplier_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtImmuneEntrys_supplier_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_supplier_TextField);
        this.kdtImmuneEntrys.getColumn("supplier").setEditor(kdtImmuneEntrys_supplier_CellEditor);
        KDDatePicker kdtImmuneEntrys_manuDate_DatePicker = new KDDatePicker();
        kdtImmuneEntrys_manuDate_DatePicker.setName("kdtImmuneEntrys_manuDate_DatePicker");
        kdtImmuneEntrys_manuDate_DatePicker.setVisible(true);
        kdtImmuneEntrys_manuDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtImmuneEntrys_manuDate_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_manuDate_DatePicker);
        this.kdtImmuneEntrys.getColumn("manuDate").setEditor(kdtImmuneEntrys_manuDate_CellEditor);
        KDDatePicker kdtImmuneEntrys_effectiveDate_DatePicker = new KDDatePicker();
        kdtImmuneEntrys_effectiveDate_DatePicker.setName("kdtImmuneEntrys_effectiveDate_DatePicker");
        kdtImmuneEntrys_effectiveDate_DatePicker.setVisible(true);
        kdtImmuneEntrys_effectiveDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtImmuneEntrys_effectiveDate_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_effectiveDate_DatePicker);
        this.kdtImmuneEntrys.getColumn("effectiveDate").setEditor(kdtImmuneEntrys_effectiveDate_CellEditor);
        KDTextField kdtImmuneEntrys_responsible_TextField = new KDTextField();
        kdtImmuneEntrys_responsible_TextField.setName("kdtImmuneEntrys_responsible_TextField");
        kdtImmuneEntrys_responsible_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtImmuneEntrys_responsible_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_responsible_TextField);
        this.kdtImmuneEntrys.getColumn("responsible").setEditor(kdtImmuneEntrys_responsible_CellEditor);
        KDTextField kdtImmuneEntrys_descriptionNew_TextField = new KDTextField();
        kdtImmuneEntrys_descriptionNew_TextField.setName("kdtImmuneEntrys_descriptionNew_TextField");
        kdtImmuneEntrys_descriptionNew_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtImmuneEntrys_descriptionNew_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_descriptionNew_TextField);
        this.kdtImmuneEntrys.getColumn("descriptionNew").setEditor(kdtImmuneEntrys_descriptionNew_CellEditor);
        KDTextField kdtImmuneEntrys_baseUnit_TextField = new KDTextField();
        kdtImmuneEntrys_baseUnit_TextField.setName("kdtImmuneEntrys_baseUnit_TextField");
        kdtImmuneEntrys_baseUnit_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtImmuneEntrys_baseUnit_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_baseUnit_TextField);
        this.kdtImmuneEntrys.getColumn("baseUnit").setEditor(kdtImmuneEntrys_baseUnit_CellEditor);
        // kdtDrugEntrys
		String kdtDrugEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"house\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"materialName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"baseUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"mainIngredients\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"drugQuantity\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"dose\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"route\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"purpose\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"manufacturers\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"productionDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"expirationDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"responsible\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"batchLot\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{house}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{model}</t:Cell><t:Cell>$Resource{baseUnit}</t:Cell><t:Cell>$Resource{mainIngredients}</t:Cell><t:Cell>$Resource{drugQuantity}</t:Cell><t:Cell>$Resource{dose}</t:Cell><t:Cell>$Resource{route}</t:Cell><t:Cell>$Resource{purpose}</t:Cell><t:Cell>$Resource{manufacturers}</t:Cell><t:Cell>$Resource{productionDate}</t:Cell><t:Cell>$Resource{expirationDate}</t:Cell><t:Cell>$Resource{responsible}</t:Cell><t:Cell>$Resource{remark}</t:Cell><t:Cell>$Resource{batchLot}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtDrugEntrys.setFormatXml(resHelper.translateString("kdtDrugEntrys",kdtDrugEntrysStrXML));
        kdtDrugEntrys.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtDrugEntrys_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtDrugEntrys.putBindContents("editData",new String[] {"seq","house","material","materialName","model","baseUnit","mainIngredients","drugQuantity","dose","route","purpose","manufacturers","productionDate","expirationDate","responsible","remark","batchLot"});


        this.kdtDrugEntrys.checkParsed();
        final KDBizPromptBox kdtDrugEntrys_house_PromptBox = new KDBizPromptBox();
        kdtDrugEntrys_house_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
        kdtDrugEntrys_house_PromptBox.setVisible(true);
        kdtDrugEntrys_house_PromptBox.setEditable(true);
        kdtDrugEntrys_house_PromptBox.setDisplayFormat("$number$");
        kdtDrugEntrys_house_PromptBox.setEditFormat("$number$");
        kdtDrugEntrys_house_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtDrugEntrys_house_CellEditor = new KDTDefaultCellEditor(kdtDrugEntrys_house_PromptBox);
        this.kdtDrugEntrys.getColumn("house").setEditor(kdtDrugEntrys_house_CellEditor);
        ObjectValueRender kdtDrugEntrys_house_OVR = new ObjectValueRender();
        kdtDrugEntrys_house_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtDrugEntrys.getColumn("house").setRenderer(kdtDrugEntrys_house_OVR);
        final KDBizPromptBox kdtDrugEntrys_material_PromptBox = new KDBizPromptBox();
        kdtDrugEntrys_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtDrugEntrys_material_PromptBox.setVisible(true);
        kdtDrugEntrys_material_PromptBox.setEditable(true);
        kdtDrugEntrys_material_PromptBox.setDisplayFormat("$number$");
        kdtDrugEntrys_material_PromptBox.setEditFormat("$number$");
        kdtDrugEntrys_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtDrugEntrys_material_CellEditor = new KDTDefaultCellEditor(kdtDrugEntrys_material_PromptBox);
        this.kdtDrugEntrys.getColumn("material").setEditor(kdtDrugEntrys_material_CellEditor);
        ObjectValueRender kdtDrugEntrys_material_OVR = new ObjectValueRender();
        kdtDrugEntrys_material_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtDrugEntrys.getColumn("material").setRenderer(kdtDrugEntrys_material_OVR);
        KDTextField kdtDrugEntrys_materialName_TextField = new KDTextField();
        kdtDrugEntrys_materialName_TextField.setName("kdtDrugEntrys_materialName_TextField");
        kdtDrugEntrys_materialName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtDrugEntrys_materialName_CellEditor = new KDTDefaultCellEditor(kdtDrugEntrys_materialName_TextField);
        this.kdtDrugEntrys.getColumn("materialName").setEditor(kdtDrugEntrys_materialName_CellEditor);
        KDTextField kdtDrugEntrys_model_TextField = new KDTextField();
        kdtDrugEntrys_model_TextField.setName("kdtDrugEntrys_model_TextField");
        kdtDrugEntrys_model_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtDrugEntrys_model_CellEditor = new KDTDefaultCellEditor(kdtDrugEntrys_model_TextField);
        this.kdtDrugEntrys.getColumn("model").setEditor(kdtDrugEntrys_model_CellEditor);
        KDTextField kdtDrugEntrys_baseUnit_TextField = new KDTextField();
        kdtDrugEntrys_baseUnit_TextField.setName("kdtDrugEntrys_baseUnit_TextField");
        kdtDrugEntrys_baseUnit_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtDrugEntrys_baseUnit_CellEditor = new KDTDefaultCellEditor(kdtDrugEntrys_baseUnit_TextField);
        this.kdtDrugEntrys.getColumn("baseUnit").setEditor(kdtDrugEntrys_baseUnit_CellEditor);
        KDTextField kdtDrugEntrys_mainIngredients_TextField = new KDTextField();
        kdtDrugEntrys_mainIngredients_TextField.setName("kdtDrugEntrys_mainIngredients_TextField");
        kdtDrugEntrys_mainIngredients_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtDrugEntrys_mainIngredients_CellEditor = new KDTDefaultCellEditor(kdtDrugEntrys_mainIngredients_TextField);
        this.kdtDrugEntrys.getColumn("mainIngredients").setEditor(kdtDrugEntrys_mainIngredients_CellEditor);
        KDFormattedTextField kdtDrugEntrys_drugQuantity_TextField = new KDFormattedTextField();
        kdtDrugEntrys_drugQuantity_TextField.setName("kdtDrugEntrys_drugQuantity_TextField");
        kdtDrugEntrys_drugQuantity_TextField.setVisible(true);
        kdtDrugEntrys_drugQuantity_TextField.setEditable(true);
        kdtDrugEntrys_drugQuantity_TextField.setHorizontalAlignment(2);
        kdtDrugEntrys_drugQuantity_TextField.setDataType(1);
        	kdtDrugEntrys_drugQuantity_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtDrugEntrys_drugQuantity_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtDrugEntrys_drugQuantity_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtDrugEntrys_drugQuantity_CellEditor = new KDTDefaultCellEditor(kdtDrugEntrys_drugQuantity_TextField);
        this.kdtDrugEntrys.getColumn("drugQuantity").setEditor(kdtDrugEntrys_drugQuantity_CellEditor);
        KDFormattedTextField kdtDrugEntrys_dose_TextField = new KDFormattedTextField();
        kdtDrugEntrys_dose_TextField.setName("kdtDrugEntrys_dose_TextField");
        kdtDrugEntrys_dose_TextField.setVisible(true);
        kdtDrugEntrys_dose_TextField.setEditable(true);
        kdtDrugEntrys_dose_TextField.setHorizontalAlignment(2);
        kdtDrugEntrys_dose_TextField.setDataType(1);
        	kdtDrugEntrys_dose_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtDrugEntrys_dose_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtDrugEntrys_dose_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtDrugEntrys_dose_CellEditor = new KDTDefaultCellEditor(kdtDrugEntrys_dose_TextField);
        this.kdtDrugEntrys.getColumn("dose").setEditor(kdtDrugEntrys_dose_CellEditor);
        KDTextField kdtDrugEntrys_route_TextField = new KDTextField();
        kdtDrugEntrys_route_TextField.setName("kdtDrugEntrys_route_TextField");
        kdtDrugEntrys_route_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtDrugEntrys_route_CellEditor = new KDTDefaultCellEditor(kdtDrugEntrys_route_TextField);
        this.kdtDrugEntrys.getColumn("route").setEditor(kdtDrugEntrys_route_CellEditor);
        KDTextField kdtDrugEntrys_purpose_TextField = new KDTextField();
        kdtDrugEntrys_purpose_TextField.setName("kdtDrugEntrys_purpose_TextField");
        kdtDrugEntrys_purpose_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtDrugEntrys_purpose_CellEditor = new KDTDefaultCellEditor(kdtDrugEntrys_purpose_TextField);
        this.kdtDrugEntrys.getColumn("purpose").setEditor(kdtDrugEntrys_purpose_CellEditor);
        KDTextField kdtDrugEntrys_manufacturers_TextField = new KDTextField();
        kdtDrugEntrys_manufacturers_TextField.setName("kdtDrugEntrys_manufacturers_TextField");
        kdtDrugEntrys_manufacturers_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtDrugEntrys_manufacturers_CellEditor = new KDTDefaultCellEditor(kdtDrugEntrys_manufacturers_TextField);
        this.kdtDrugEntrys.getColumn("manufacturers").setEditor(kdtDrugEntrys_manufacturers_CellEditor);
        KDDatePicker kdtDrugEntrys_productionDate_DatePicker = new KDDatePicker();
        kdtDrugEntrys_productionDate_DatePicker.setName("kdtDrugEntrys_productionDate_DatePicker");
        kdtDrugEntrys_productionDate_DatePicker.setVisible(true);
        kdtDrugEntrys_productionDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtDrugEntrys_productionDate_CellEditor = new KDTDefaultCellEditor(kdtDrugEntrys_productionDate_DatePicker);
        this.kdtDrugEntrys.getColumn("productionDate").setEditor(kdtDrugEntrys_productionDate_CellEditor);
        KDDatePicker kdtDrugEntrys_expirationDate_DatePicker = new KDDatePicker();
        kdtDrugEntrys_expirationDate_DatePicker.setName("kdtDrugEntrys_expirationDate_DatePicker");
        kdtDrugEntrys_expirationDate_DatePicker.setVisible(true);
        kdtDrugEntrys_expirationDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtDrugEntrys_expirationDate_CellEditor = new KDTDefaultCellEditor(kdtDrugEntrys_expirationDate_DatePicker);
        this.kdtDrugEntrys.getColumn("expirationDate").setEditor(kdtDrugEntrys_expirationDate_CellEditor);
        KDTextField kdtDrugEntrys_responsible_TextField = new KDTextField();
        kdtDrugEntrys_responsible_TextField.setName("kdtDrugEntrys_responsible_TextField");
        kdtDrugEntrys_responsible_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtDrugEntrys_responsible_CellEditor = new KDTDefaultCellEditor(kdtDrugEntrys_responsible_TextField);
        this.kdtDrugEntrys.getColumn("responsible").setEditor(kdtDrugEntrys_responsible_CellEditor);
        KDTextField kdtDrugEntrys_remark_TextField = new KDTextField();
        kdtDrugEntrys_remark_TextField.setName("kdtDrugEntrys_remark_TextField");
        kdtDrugEntrys_remark_TextField.setMaxLength(250);
        KDTDefaultCellEditor kdtDrugEntrys_remark_CellEditor = new KDTDefaultCellEditor(kdtDrugEntrys_remark_TextField);
        this.kdtDrugEntrys.getColumn("remark").setEditor(kdtDrugEntrys_remark_CellEditor);
        KDTextField kdtDrugEntrys_batchLot_TextField = new KDTextField();
        kdtDrugEntrys_batchLot_TextField.setName("kdtDrugEntrys_batchLot_TextField");
        kdtDrugEntrys_batchLot_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtDrugEntrys_batchLot_CellEditor = new KDTDefaultCellEditor(kdtDrugEntrys_batchLot_TextField);
        this.kdtDrugEntrys.getColumn("batchLot").setEditor(kdtDrugEntrys_batchLot_CellEditor);
        // kdtEnvi
		String kdtEnviStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"house\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"breedTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"lightingTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"lightIntensity\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"nightFeedTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"lowTemp\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"highTemp\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"lowHumidity\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"highHumidity\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{house}</t:Cell><t:Cell>$Resource{breedTime}</t:Cell><t:Cell>$Resource{lightingTime}</t:Cell><t:Cell>$Resource{lightIntensity}</t:Cell><t:Cell>$Resource{nightFeedTime}</t:Cell><t:Cell>$Resource{lowTemp}</t:Cell><t:Cell>$Resource{highTemp}</t:Cell><t:Cell>$Resource{lowHumidity}</t:Cell><t:Cell>$Resource{highHumidity}</t:Cell><t:Cell>$Resource{remark}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEnvi.setFormatXml(resHelper.translateString("kdtEnvi",kdtEnviStrXML));

                this.kdtEnvi.putBindContents("editData",new String[] {"seq","house","breedTime","lightingTime","lightIntensity","nightFeedTime","lowTemp","highTemp","lowHumidity","highHumidity","remark"});


        this.kdtEnvi.checkParsed();
        final KDBizPromptBox kdtEnvi_house_PromptBox = new KDBizPromptBox();
        kdtEnvi_house_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
        kdtEnvi_house_PromptBox.setVisible(true);
        kdtEnvi_house_PromptBox.setEditable(true);
        kdtEnvi_house_PromptBox.setDisplayFormat("$number$");
        kdtEnvi_house_PromptBox.setEditFormat("$number$");
        kdtEnvi_house_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEnvi_house_CellEditor = new KDTDefaultCellEditor(kdtEnvi_house_PromptBox);
        this.kdtEnvi.getColumn("house").setEditor(kdtEnvi_house_CellEditor);
        ObjectValueRender kdtEnvi_house_OVR = new ObjectValueRender();
        kdtEnvi_house_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEnvi.getColumn("house").setRenderer(kdtEnvi_house_OVR);
        KDFormattedTextField kdtEnvi_breedTime_TextField = new KDFormattedTextField();
        kdtEnvi_breedTime_TextField.setName("kdtEnvi_breedTime_TextField");
        kdtEnvi_breedTime_TextField.setVisible(true);
        kdtEnvi_breedTime_TextField.setEditable(true);
        kdtEnvi_breedTime_TextField.setHorizontalAlignment(2);
        kdtEnvi_breedTime_TextField.setDataType(1);
        	kdtEnvi_breedTime_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEnvi_breedTime_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEnvi_breedTime_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEnvi_breedTime_CellEditor = new KDTDefaultCellEditor(kdtEnvi_breedTime_TextField);
        this.kdtEnvi.getColumn("breedTime").setEditor(kdtEnvi_breedTime_CellEditor);
        KDFormattedTextField kdtEnvi_lightingTime_TextField = new KDFormattedTextField();
        kdtEnvi_lightingTime_TextField.setName("kdtEnvi_lightingTime_TextField");
        kdtEnvi_lightingTime_TextField.setVisible(true);
        kdtEnvi_lightingTime_TextField.setEditable(true);
        kdtEnvi_lightingTime_TextField.setHorizontalAlignment(2);
        kdtEnvi_lightingTime_TextField.setDataType(1);
        	kdtEnvi_lightingTime_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEnvi_lightingTime_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEnvi_lightingTime_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEnvi_lightingTime_CellEditor = new KDTDefaultCellEditor(kdtEnvi_lightingTime_TextField);
        this.kdtEnvi.getColumn("lightingTime").setEditor(kdtEnvi_lightingTime_CellEditor);
        KDFormattedTextField kdtEnvi_lightIntensity_TextField = new KDFormattedTextField();
        kdtEnvi_lightIntensity_TextField.setName("kdtEnvi_lightIntensity_TextField");
        kdtEnvi_lightIntensity_TextField.setVisible(true);
        kdtEnvi_lightIntensity_TextField.setEditable(true);
        kdtEnvi_lightIntensity_TextField.setHorizontalAlignment(2);
        kdtEnvi_lightIntensity_TextField.setDataType(1);
        	kdtEnvi_lightIntensity_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEnvi_lightIntensity_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEnvi_lightIntensity_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEnvi_lightIntensity_CellEditor = new KDTDefaultCellEditor(kdtEnvi_lightIntensity_TextField);
        this.kdtEnvi.getColumn("lightIntensity").setEditor(kdtEnvi_lightIntensity_CellEditor);
        KDTextField kdtEnvi_nightFeedTime_TextField = new KDTextField();
        kdtEnvi_nightFeedTime_TextField.setName("kdtEnvi_nightFeedTime_TextField");
        kdtEnvi_nightFeedTime_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEnvi_nightFeedTime_CellEditor = new KDTDefaultCellEditor(kdtEnvi_nightFeedTime_TextField);
        this.kdtEnvi.getColumn("nightFeedTime").setEditor(kdtEnvi_nightFeedTime_CellEditor);
        KDFormattedTextField kdtEnvi_lowTemp_TextField = new KDFormattedTextField();
        kdtEnvi_lowTemp_TextField.setName("kdtEnvi_lowTemp_TextField");
        kdtEnvi_lowTemp_TextField.setVisible(true);
        kdtEnvi_lowTemp_TextField.setEditable(true);
        kdtEnvi_lowTemp_TextField.setHorizontalAlignment(2);
        kdtEnvi_lowTemp_TextField.setDataType(1);
        	kdtEnvi_lowTemp_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEnvi_lowTemp_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEnvi_lowTemp_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEnvi_lowTemp_CellEditor = new KDTDefaultCellEditor(kdtEnvi_lowTemp_TextField);
        this.kdtEnvi.getColumn("lowTemp").setEditor(kdtEnvi_lowTemp_CellEditor);
        KDFormattedTextField kdtEnvi_highTemp_TextField = new KDFormattedTextField();
        kdtEnvi_highTemp_TextField.setName("kdtEnvi_highTemp_TextField");
        kdtEnvi_highTemp_TextField.setVisible(true);
        kdtEnvi_highTemp_TextField.setEditable(true);
        kdtEnvi_highTemp_TextField.setHorizontalAlignment(2);
        kdtEnvi_highTemp_TextField.setDataType(1);
        	kdtEnvi_highTemp_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEnvi_highTemp_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEnvi_highTemp_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEnvi_highTemp_CellEditor = new KDTDefaultCellEditor(kdtEnvi_highTemp_TextField);
        this.kdtEnvi.getColumn("highTemp").setEditor(kdtEnvi_highTemp_CellEditor);
        KDFormattedTextField kdtEnvi_lowHumidity_TextField = new KDFormattedTextField();
        kdtEnvi_lowHumidity_TextField.setName("kdtEnvi_lowHumidity_TextField");
        kdtEnvi_lowHumidity_TextField.setVisible(true);
        kdtEnvi_lowHumidity_TextField.setEditable(true);
        kdtEnvi_lowHumidity_TextField.setHorizontalAlignment(2);
        kdtEnvi_lowHumidity_TextField.setDataType(1);
        	kdtEnvi_lowHumidity_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEnvi_lowHumidity_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEnvi_lowHumidity_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEnvi_lowHumidity_CellEditor = new KDTDefaultCellEditor(kdtEnvi_lowHumidity_TextField);
        this.kdtEnvi.getColumn("lowHumidity").setEditor(kdtEnvi_lowHumidity_CellEditor);
        KDFormattedTextField kdtEnvi_highHumidity_TextField = new KDFormattedTextField();
        kdtEnvi_highHumidity_TextField.setName("kdtEnvi_highHumidity_TextField");
        kdtEnvi_highHumidity_TextField.setVisible(true);
        kdtEnvi_highHumidity_TextField.setEditable(true);
        kdtEnvi_highHumidity_TextField.setHorizontalAlignment(2);
        kdtEnvi_highHumidity_TextField.setDataType(1);
        	kdtEnvi_highHumidity_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEnvi_highHumidity_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEnvi_highHumidity_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEnvi_highHumidity_CellEditor = new KDTDefaultCellEditor(kdtEnvi_highHumidity_TextField);
        this.kdtEnvi.getColumn("highHumidity").setEditor(kdtEnvi_highHumidity_CellEditor);
        KDTextField kdtEnvi_remark_TextField = new KDTextField();
        kdtEnvi_remark_TextField.setName("kdtEnvi_remark_TextField");
        kdtEnvi_remark_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEnvi_remark_CellEditor = new KDTDefaultCellEditor(kdtEnvi_remark_TextField);
        this.kdtEnvi.getColumn("remark").setEditor(kdtEnvi_remark_CellEditor);
        // kdtTransEntry
		String kdtTransEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:Protection locked=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"house\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"fromHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"transQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"transFemaleQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"fromStockingBatch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"fromFarmers\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"fromFarm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"description\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{house}</t:Cell><t:Cell>$Resource{fromHouse}</t:Cell><t:Cell>$Resource{transQty}</t:Cell><t:Cell>$Resource{transFemaleQty}</t:Cell><t:Cell>$Resource{fromStockingBatch}</t:Cell><t:Cell>$Resource{fromFarmers}</t:Cell><t:Cell>$Resource{fromFarm}</t:Cell><t:Cell>$Resource{description}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtTransEntry.setFormatXml(resHelper.translateString("kdtTransEntry",kdtTransEntryStrXML));

                this.kdtTransEntry.putBindContents("editData",new String[] {"seq","house","fromHouse","transQty","transFemaleQty","fromStockingBatch","fromFarmers","fromFarm","description"});


        this.kdtTransEntry.checkParsed();
        final KDBizPromptBox kdtTransEntry_house_PromptBox = new KDBizPromptBox();
        kdtTransEntry_house_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
        kdtTransEntry_house_PromptBox.setVisible(true);
        kdtTransEntry_house_PromptBox.setEditable(true);
        kdtTransEntry_house_PromptBox.setDisplayFormat("$number$");
        kdtTransEntry_house_PromptBox.setEditFormat("$number$");
        kdtTransEntry_house_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtTransEntry_house_CellEditor = new KDTDefaultCellEditor(kdtTransEntry_house_PromptBox);
        this.kdtTransEntry.getColumn("house").setEditor(kdtTransEntry_house_CellEditor);
        ObjectValueRender kdtTransEntry_house_OVR = new ObjectValueRender();
        kdtTransEntry_house_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtTransEntry.getColumn("house").setRenderer(kdtTransEntry_house_OVR);
        final KDBizPromptBox kdtTransEntry_fromHouse_PromptBox = new KDBizPromptBox();
        kdtTransEntry_fromHouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
        kdtTransEntry_fromHouse_PromptBox.setVisible(true);
        kdtTransEntry_fromHouse_PromptBox.setEditable(true);
        kdtTransEntry_fromHouse_PromptBox.setDisplayFormat("$number$");
        kdtTransEntry_fromHouse_PromptBox.setEditFormat("$number$");
        kdtTransEntry_fromHouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtTransEntry_fromHouse_CellEditor = new KDTDefaultCellEditor(kdtTransEntry_fromHouse_PromptBox);
        this.kdtTransEntry.getColumn("fromHouse").setEditor(kdtTransEntry_fromHouse_CellEditor);
        ObjectValueRender kdtTransEntry_fromHouse_OVR = new ObjectValueRender();
        kdtTransEntry_fromHouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtTransEntry.getColumn("fromHouse").setRenderer(kdtTransEntry_fromHouse_OVR);
        KDFormattedTextField kdtTransEntry_transQty_TextField = new KDFormattedTextField();
        kdtTransEntry_transQty_TextField.setName("kdtTransEntry_transQty_TextField");
        kdtTransEntry_transQty_TextField.setVisible(true);
        kdtTransEntry_transQty_TextField.setEditable(true);
        kdtTransEntry_transQty_TextField.setHorizontalAlignment(2);
        kdtTransEntry_transQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtTransEntry_transQty_CellEditor = new KDTDefaultCellEditor(kdtTransEntry_transQty_TextField);
        this.kdtTransEntry.getColumn("transQty").setEditor(kdtTransEntry_transQty_CellEditor);
        KDFormattedTextField kdtTransEntry_transFemaleQty_TextField = new KDFormattedTextField();
        kdtTransEntry_transFemaleQty_TextField.setName("kdtTransEntry_transFemaleQty_TextField");
        kdtTransEntry_transFemaleQty_TextField.setVisible(true);
        kdtTransEntry_transFemaleQty_TextField.setEditable(true);
        kdtTransEntry_transFemaleQty_TextField.setHorizontalAlignment(2);
        kdtTransEntry_transFemaleQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtTransEntry_transFemaleQty_CellEditor = new KDTDefaultCellEditor(kdtTransEntry_transFemaleQty_TextField);
        this.kdtTransEntry.getColumn("transFemaleQty").setEditor(kdtTransEntry_transFemaleQty_CellEditor);
        final KDBizPromptBox kdtTransEntry_fromStockingBatch_PromptBox = new KDBizPromptBox();
        kdtTransEntry_fromStockingBatch_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.StockingBatchQuery");
        kdtTransEntry_fromStockingBatch_PromptBox.setVisible(true);
        kdtTransEntry_fromStockingBatch_PromptBox.setEditable(true);
        kdtTransEntry_fromStockingBatch_PromptBox.setDisplayFormat("$number$");
        kdtTransEntry_fromStockingBatch_PromptBox.setEditFormat("$number$");
        kdtTransEntry_fromStockingBatch_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtTransEntry_fromStockingBatch_CellEditor = new KDTDefaultCellEditor(kdtTransEntry_fromStockingBatch_PromptBox);
        this.kdtTransEntry.getColumn("fromStockingBatch").setEditor(kdtTransEntry_fromStockingBatch_CellEditor);
        ObjectValueRender kdtTransEntry_fromStockingBatch_OVR = new ObjectValueRender();
        kdtTransEntry_fromStockingBatch_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtTransEntry.getColumn("fromStockingBatch").setRenderer(kdtTransEntry_fromStockingBatch_OVR);
        			kdtTransEntry_fromStockingBatch_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI kdtTransEntry_fromStockingBatch_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtTransEntry_fromStockingBatch_PromptBox_F7ListUI == null) {
					try {
						kdtTransEntry_fromStockingBatch_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtTransEntry_fromStockingBatch_PromptBox_F7ListUI));
					kdtTransEntry_fromStockingBatch_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtTransEntry_fromStockingBatch_PromptBox.setSelector(kdtTransEntry_fromStockingBatch_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtTransEntry_fromFarmers_PromptBox = new KDBizPromptBox();
        kdtTransEntry_fromFarmers_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmersQuery");
        kdtTransEntry_fromFarmers_PromptBox.setVisible(true);
        kdtTransEntry_fromFarmers_PromptBox.setEditable(true);
        kdtTransEntry_fromFarmers_PromptBox.setDisplayFormat("$number$");
        kdtTransEntry_fromFarmers_PromptBox.setEditFormat("$number$");
        kdtTransEntry_fromFarmers_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtTransEntry_fromFarmers_CellEditor = new KDTDefaultCellEditor(kdtTransEntry_fromFarmers_PromptBox);
        this.kdtTransEntry.getColumn("fromFarmers").setEditor(kdtTransEntry_fromFarmers_CellEditor);
        ObjectValueRender kdtTransEntry_fromFarmers_OVR = new ObjectValueRender();
        kdtTransEntry_fromFarmers_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtTransEntry.getColumn("fromFarmers").setRenderer(kdtTransEntry_fromFarmers_OVR);
        			kdtTransEntry_fromFarmers_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI kdtTransEntry_fromFarmers_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtTransEntry_fromFarmers_PromptBox_F7ListUI == null) {
					try {
						kdtTransEntry_fromFarmers_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtTransEntry_fromFarmers_PromptBox_F7ListUI));
					kdtTransEntry_fromFarmers_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtTransEntry_fromFarmers_PromptBox.setSelector(kdtTransEntry_fromFarmers_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtTransEntry_fromFarm_PromptBox = new KDBizPromptBox();
        kdtTransEntry_fromFarm_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmQuery");
        kdtTransEntry_fromFarm_PromptBox.setVisible(true);
        kdtTransEntry_fromFarm_PromptBox.setEditable(true);
        kdtTransEntry_fromFarm_PromptBox.setDisplayFormat("$number$");
        kdtTransEntry_fromFarm_PromptBox.setEditFormat("$number$");
        kdtTransEntry_fromFarm_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtTransEntry_fromFarm_CellEditor = new KDTDefaultCellEditor(kdtTransEntry_fromFarm_PromptBox);
        this.kdtTransEntry.getColumn("fromFarm").setEditor(kdtTransEntry_fromFarm_CellEditor);
        ObjectValueRender kdtTransEntry_fromFarm_OVR = new ObjectValueRender();
        kdtTransEntry_fromFarm_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtTransEntry.getColumn("fromFarm").setRenderer(kdtTransEntry_fromFarm_OVR);
        			kdtTransEntry_fromFarm_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmListUI kdtTransEntry_fromFarm_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtTransEntry_fromFarm_PromptBox_F7ListUI == null) {
					try {
						kdtTransEntry_fromFarm_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtTransEntry_fromFarm_PromptBox_F7ListUI));
					kdtTransEntry_fromFarm_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtTransEntry_fromFarm_PromptBox.setSelector(kdtTransEntry_fromFarm_PromptBox_F7ListUI);
				}
			}
		});
					
        KDTextField kdtTransEntry_description_TextField = new KDTextField();
        kdtTransEntry_description_TextField.setName("kdtTransEntry_description_TextField");
        kdtTransEntry_description_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtTransEntry_description_CellEditor = new KDTDefaultCellEditor(kdtTransEntry_description_TextField);
        this.kdtTransEntry.getColumn("description").setEditor(kdtTransEntry_description_CellEditor);
        // contbreedLog		
        this.contbreedLog.setBoundLabelText(resHelper.getString("contbreedLog.boundLabelText"));		
        this.contbreedLog.setBoundLabelLength(0);		
        this.contbreedLog.setBoundLabelUnderline(true);		
        this.contbreedLog.setVisible(true);
        // scrollPanebreedLog
        // txtbreedLog		
        this.txtbreedLog.setRequired(false);		
        this.txtbreedLog.setMaxLength(2000);
        // kdtMatUserEntry
		String kdtMatUserEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"matNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"matName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"matModel\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"matUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"matQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{matNum}</t:Cell><t:Cell>$Resource{matName}</t:Cell><t:Cell>$Resource{matModel}</t:Cell><t:Cell>$Resource{matUnit}</t:Cell><t:Cell>$Resource{matQty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtMatUserEntry.setFormatXml(resHelper.translateString("kdtMatUserEntry",kdtMatUserEntryStrXML));
        kdtMatUserEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtMatUserEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtMatUserEntry.putBindContents("editData",new String[] {"seq","matNum","matName","matModel","matUnit","matQty"});


        this.kdtMatUserEntry.checkParsed();
        final KDBizPromptBox kdtMatUserEntry_matNum_PromptBox = new KDBizPromptBox();
        kdtMatUserEntry_matNum_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtMatUserEntry_matNum_PromptBox.setVisible(true);
        kdtMatUserEntry_matNum_PromptBox.setEditable(true);
        kdtMatUserEntry_matNum_PromptBox.setDisplayFormat("$number$");
        kdtMatUserEntry_matNum_PromptBox.setEditFormat("$number$");
        kdtMatUserEntry_matNum_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtMatUserEntry_matNum_CellEditor = new KDTDefaultCellEditor(kdtMatUserEntry_matNum_PromptBox);
        this.kdtMatUserEntry.getColumn("matNum").setEditor(kdtMatUserEntry_matNum_CellEditor);
        ObjectValueRender kdtMatUserEntry_matNum_OVR = new ObjectValueRender();
        kdtMatUserEntry_matNum_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtMatUserEntry.getColumn("matNum").setRenderer(kdtMatUserEntry_matNum_OVR);
        KDTextField kdtMatUserEntry_matName_TextField = new KDTextField();
        kdtMatUserEntry_matName_TextField.setName("kdtMatUserEntry_matName_TextField");
        kdtMatUserEntry_matName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtMatUserEntry_matName_CellEditor = new KDTDefaultCellEditor(kdtMatUserEntry_matName_TextField);
        this.kdtMatUserEntry.getColumn("matName").setEditor(kdtMatUserEntry_matName_CellEditor);
        KDTextField kdtMatUserEntry_matModel_TextField = new KDTextField();
        kdtMatUserEntry_matModel_TextField.setName("kdtMatUserEntry_matModel_TextField");
        kdtMatUserEntry_matModel_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtMatUserEntry_matModel_CellEditor = new KDTDefaultCellEditor(kdtMatUserEntry_matModel_TextField);
        this.kdtMatUserEntry.getColumn("matModel").setEditor(kdtMatUserEntry_matModel_CellEditor);
        KDTextField kdtMatUserEntry_matUnit_TextField = new KDTextField();
        kdtMatUserEntry_matUnit_TextField.setName("kdtMatUserEntry_matUnit_TextField");
        kdtMatUserEntry_matUnit_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtMatUserEntry_matUnit_CellEditor = new KDTDefaultCellEditor(kdtMatUserEntry_matUnit_TextField);
        this.kdtMatUserEntry.getColumn("matUnit").setEditor(kdtMatUserEntry_matUnit_CellEditor);
        KDFormattedTextField kdtMatUserEntry_matQty_TextField = new KDFormattedTextField();
        kdtMatUserEntry_matQty_TextField.setName("kdtMatUserEntry_matQty_TextField");
        kdtMatUserEntry_matQty_TextField.setVisible(true);
        kdtMatUserEntry_matQty_TextField.setEditable(true);
        kdtMatUserEntry_matQty_TextField.setHorizontalAlignment(2);
        kdtMatUserEntry_matQty_TextField.setDataType(1);
        	kdtMatUserEntry_matQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtMatUserEntry_matQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtMatUserEntry_matQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtMatUserEntry_matQty_CellEditor = new KDTDefaultCellEditor(kdtMatUserEntry_matQty_TextField);
        this.kdtMatUserEntry.getColumn("matQty").setEditor(kdtMatUserEntry_matQty_CellEditor);
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(true);		
        this.baseStatus.setEnabled(false);
        // txtoutSideTFrom		
        this.txtoutSideTFrom.setHorizontalAlignment(2);		
        this.txtoutSideTFrom.setDataType(1);		
        this.txtoutSideTFrom.setSupportedEmpty(true);		
        this.txtoutSideTFrom.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtoutSideTFrom.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtoutSideTFrom.setPrecision(2);		
        this.txtoutSideTFrom.setRequired(false);
        // txtoutSideTTo		
        this.txtoutSideTTo.setHorizontalAlignment(2);		
        this.txtoutSideTTo.setDataType(1);		
        this.txtoutSideTTo.setSupportedEmpty(true);		
        this.txtoutSideTTo.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtoutSideTTo.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtoutSideTTo.setPrecision(2);		
        this.txtoutSideTTo.setRequired(false);
        // txtweather		
        this.txtweather.setHorizontalAlignment(2);		
        this.txtweather.setMaxLength(200);		
        this.txtweather.setRequired(false);
        // txtoutHumidityFrom		
        this.txtoutHumidityFrom.setHorizontalAlignment(2);		
        this.txtoutHumidityFrom.setDataType(1);		
        this.txtoutHumidityFrom.setSupportedEmpty(true);		
        this.txtoutHumidityFrom.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtoutHumidityFrom.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtoutHumidityFrom.setPrecision(2);		
        this.txtoutHumidityFrom.setRequired(false);
        // txtoutHumidityTo		
        this.txtoutHumidityTo.setHorizontalAlignment(2);		
        this.txtoutHumidityTo.setDataType(1);		
        this.txtoutHumidityTo.setSupportedEmpty(true);		
        this.txtoutHumidityTo.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtoutHumidityTo.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtoutHumidityTo.setPrecision(2);		
        this.txtoutHumidityTo.setRequired(false);
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // txtfuel		
        this.txtfuel.setHorizontalAlignment(2);		
        this.txtfuel.setDataType(1);		
        this.txtfuel.setSupportedEmpty(true);		
        this.txtfuel.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtfuel.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtfuel.setPrecision(2);		
        this.txtfuel.setRequired(false);		
        this.txtfuel.setEnabled(false);		
        this.txtfuel.setVisible(false);
        // txtweek		
        this.txtweek.setHorizontalAlignment(2);		
        this.txtweek.setDataType(0);		
        this.txtweek.setSupportedEmpty(true);		
        this.txtweek.setRequired(false);		
        this.txtweek.setEnabled(false);
        // txtweekDay		
        this.txtweekDay.setHorizontalAlignment(2);		
        this.txtweekDay.setDataType(0);		
        this.txtweekDay.setSupportedEmpty(true);		
        this.txtweekDay.setRequired(false);		
        this.txtweekDay.setEnabled(false);
        // txtelectricityQty		
        this.txtelectricityQty.setHorizontalAlignment(2);		
        this.txtelectricityQty.setDataType(1);		
        this.txtelectricityQty.setSupportedEmpty(true);		
        this.txtelectricityQty.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtelectricityQty.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtelectricityQty.setPrecision(2);		
        this.txtelectricityQty.setRequired(false);
        // txtcoalFual		
        this.txtcoalFual.setHorizontalAlignment(2);		
        this.txtcoalFual.setDataType(1);		
        this.txtcoalFual.setSupportedEmpty(true);		
        this.txtcoalFual.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtcoalFual.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtcoalFual.setPrecision(2);		
        this.txtcoalFual.setRequired(false);
        // txtdieselFual		
        this.txtdieselFual.setHorizontalAlignment(2);		
        this.txtdieselFual.setDataType(1);		
        this.txtdieselFual.setSupportedEmpty(true);		
        this.txtdieselFual.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtdieselFual.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtdieselFual.setPrecision(2);		
        this.txtdieselFual.setRequired(false);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
        // prmtfarmer		
        this.prmtfarmer.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmersQuery");		
        this.prmtfarmer.setEditable(true);		
        this.prmtfarmer.setDisplayFormat("$name$");		
        this.prmtfarmer.setEditFormat("$number$");		
        this.prmtfarmer.setCommitFormat("$number$");		
        this.prmtfarmer.setRequired(false);
        		prmtfarmer.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI prmtfarmer_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarmer_F7ListUI == null) {
					try {
						prmtfarmer_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtfarmer_F7ListUI));
					prmtfarmer_F7ListUI.setF7Use(true,ctx);
					prmtfarmer.setSelector(prmtfarmer_F7ListUI);
				}
			}
		});
					
        // prmtfarm		
        this.prmtfarm.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmQuery");		
        this.prmtfarm.setEditable(true);		
        this.prmtfarm.setDisplayFormat("$name$");		
        this.prmtfarm.setEditFormat("$number$");		
        this.prmtfarm.setCommitFormat("$number$");		
        this.prmtfarm.setRequired(true);
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
					
        // prmtstockingBatch		
        this.prmtstockingBatch.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.StockingBatchQuery");		
        this.prmtstockingBatch.setEditable(true);		
        this.prmtstockingBatch.setDisplayFormat("$number$");		
        this.prmtstockingBatch.setEditFormat("$number$");		
        this.prmtstockingBatch.setCommitFormat("$number$");		
        this.prmtstockingBatch.setRequired(true);
        		prmtstockingBatch.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI prmtstockingBatch_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtstockingBatch_F7ListUI == null) {
					try {
						prmtstockingBatch_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtstockingBatch_F7ListUI));
					prmtstockingBatch_F7ListUI.setF7Use(true,ctx);
					prmtstockingBatch.setSelector(prmtstockingBatch_F7ListUI);
				}
			}
		});
					
        // txttransInQty		
        this.txttransInQty.setHorizontalAlignment(2);		
        this.txttransInQty.setDataType(1);		
        this.txttransInQty.setSupportedEmpty(true);		
        this.txttransInQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttransInQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttransInQty.setPrecision(4);		
        this.txttransInQty.setRequired(false);		
        this.txttransInQty.setVisible(false);
        // nowBreedStage		
        this.nowBreedStage.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.FarmStageEnum").toArray());		
        this.nowBreedStage.setRequired(false);		
        this.nowBreedStage.setEnabled(false);
        // prmtbizPerson		
        this.prmtbizPerson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtbizPerson.setEditable(true);		
        this.prmtbizPerson.setDisplayFormat("$name$");		
        this.prmtbizPerson.setEditFormat("$number$");		
        this.prmtbizPerson.setCommitFormat("$number$");		
        this.prmtbizPerson.setRequired(false);
        // txtsumWeekDay		
        this.txtsumWeekDay.setVisible(false);		
        this.txtsumWeekDay.setHorizontalAlignment(2);		
        this.txtsumWeekDay.setMaxLength(100);		
        this.txtsumWeekDay.setRequired(false);		
        this.txtsumWeekDay.setEnabled(false);
        // prmtcurrentCostObject		
        this.prmtcurrentCostObject.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");		
        this.prmtcurrentCostObject.setEditable(true);		
        this.prmtcurrentCostObject.setDisplayFormat("$name$");		
        this.prmtcurrentCostObject.setEditFormat("$number$");		
        this.prmtcurrentCostObject.setCommitFormat("$number$");		
        this.prmtcurrentCostObject.setRequired(false);		
        this.prmtcurrentCostObject.setEnabled(false);		
        this.prmtcurrentCostObject.setVisible(false);
        // tBtnAudit
        this.tBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnAudit.setText(resHelper.getString("tBtnAudit.text"));
        // tBtnUnAudit
        this.tBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnUnAudit.setText(resHelper.getString("tBtnUnAudit.text"));
        // btnGenNextBill
        this.btnGenNextBill.setAction((IItemAction)ActionProxyFactory.getProxy(actionGenNextBill, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnGenNextBill.setText(resHelper.getString("btnGenNextBill.text"));
        // mBtnAudit
        this.mBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnAudit.setText(resHelper.getString("mBtnAudit.text"));
        // mBtnUnAudit
        this.mBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnUnAudit.setText(resHelper.getString("mBtnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {chkisMature,chkisBreed,prmtfarmer,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,baseStatus,txtoutSideTFrom,txtoutSideTTo,txtweather,txtoutHumidityFrom,txtoutHumidityTo,pkauditTime,txtfuel,txtbreedLog,txtweek,txtweekDay,txtelectricityQty,txtcoalFual,txtdieselFual,prmtcompany,prmtfarm,prmtstockingBatch,txttransInQty,chkisInit,nowBreedStage,prmtbizPerson,txtsumWeekDay,prmtcurrentCostObject,chkpreEgg,chkisAdjust,chkmaleOut,chkfemaleOut,chkdrugOut,chkimmuneOut,chkmaterialOut,chkqualityEggOut,chkunQualityEggOut,kdtAssEntrys,kdtEntrys,kdtImmuneEntrys,kdtEggEntry,kdtTransEntry,kdtEnvi,kdtSendEggEntry,kdtMatUserEntry,kdtDrugEntrys}));
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
        contCreator.setBounds(new Rectangle(12, 563, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(12, 563, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(12, 592, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(12, 592, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(368, 563, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(368, 563, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(368, 592, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(368, 592, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contNumber.setBounds(new Rectangle(19, 19, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(19, 19, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(373, 19, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(373, 19, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(1000, 120, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(1000, 120, 270, 19, 0));
        contAuditor.setBounds(new Rectangle(724, 563, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(724, 563, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kdTabPanelMain.setBounds(new Rectangle(15, 180, 993, 363));
        this.add(kdTabPanelMain, new KDLayout.Constraints(15, 180, 993, 363, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contbaseStatus.setBounds(new Rectangle(721, 19, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(721, 19, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contoutSideTFrom.setBounds(new Rectangle(373, 77, 270, 19));
        this.add(contoutSideTFrom, new KDLayout.Constraints(373, 77, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoutSideTTo.setBounds(new Rectangle(721, 77, 270, 19));
        this.add(contoutSideTTo, new KDLayout.Constraints(721, 77, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contweather.setBounds(new Rectangle(996, 201, 270, 19));
        this.add(contweather, new KDLayout.Constraints(996, 201, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoutHumidityFrom.setBounds(new Rectangle(974, 199, 270, 19));
        this.add(contoutHumidityFrom, new KDLayout.Constraints(974, 199, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoutHumidityTo.setBounds(new Rectangle(996, 215, 270, 19));
        this.add(contoutHumidityTo, new KDLayout.Constraints(996, 215, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contauditTime.setBounds(new Rectangle(724, 592, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(724, 592, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfuel.setBounds(new Rectangle(380, -149, 270, 19));
        this.add(contfuel, new KDLayout.Constraints(380, -149, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contweek.setBounds(new Rectangle(17, 49, 172, 19));
        this.add(contweek, new KDLayout.Constraints(17, 49, 172, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contweekDay.setBounds(new Rectangle(216, 49, 35, 19));
        this.add(contweekDay, new KDLayout.Constraints(216, 49, 35, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabel1.setBounds(new Rectangle(192, 49, 20, 19));
        this.add(kDLabel1, new KDLayout.Constraints(192, 49, 20, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabel2.setBounds(new Rectangle(255, 49, 26, 19));
        this.add(kDLabel2, new KDLayout.Constraints(255, 49, 26, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contelectricityQty.setBounds(new Rectangle(969, 213, 270, 19));
        this.add(contelectricityQty, new KDLayout.Constraints(969, 213, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcoalFual.setBounds(new Rectangle(967, 206, 270, 19));
        this.add(contcoalFual, new KDLayout.Constraints(967, 206, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdieselFual.setBounds(new Rectangle(996, 182, 270, 19));
        this.add(contdieselFual, new KDLayout.Constraints(996, 182, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompany.setBounds(new Rectangle(17, 79, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(17, 79, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator8.setBounds(new Rectangle(18, 169, 985, 8));
        this.add(kDSeparator8, new KDLayout.Constraints(18, 169, 985, 8, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contfarmer.setBounds(new Rectangle(219, -9, 270, 19));
        this.add(contfarmer, new KDLayout.Constraints(219, -9, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarm.setBounds(new Rectangle(373, 48, 270, 19));
        this.add(contfarm, new KDLayout.Constraints(373, 48, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contstockingBatch.setBounds(new Rectangle(721, 48, 270, 19));
        this.add(contstockingBatch, new KDLayout.Constraints(721, 48, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator9.setBounds(new Rectangle(11, 548, 998, 10));
        this.add(kDSeparator9, new KDLayout.Constraints(11, 548, 998, 10, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        conttransInQty.setBounds(new Rectangle(877, 182, 270, 19));
        this.add(conttransInQty, new KDLayout.Constraints(877, 182, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisInit.setBounds(new Rectangle(929, 107, 270, 19));
        this.add(chkisInit, new KDLayout.Constraints(929, 107, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        lblDayAge.setBounds(new Rectangle(291, 49, 55, 19));
        this.add(lblDayAge, new KDLayout.Constraints(291, 49, 55, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contnowBreedStage.setBounds(new Rectangle(18, 109, 270, 19));
        this.add(contnowBreedStage, new KDLayout.Constraints(18, 109, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbizPerson.setBounds(new Rectangle(938, 176, 270, 19));
        this.add(contbizPerson, new KDLayout.Constraints(938, 176, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsumWeekDay.setBounds(new Rectangle(998, 150, 270, 19));
        this.add(contsumWeekDay, new KDLayout.Constraints(998, 150, 270, 19, 0));
        contcurrentCostObject.setBounds(new Rectangle(875, 183, 270, 19));
        this.add(contcurrentCostObject, new KDLayout.Constraints(875, 183, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisBreed.setBounds(new Rectangle(933, 131, 75, 19));
        this.add(chkisBreed, new KDLayout.Constraints(933, 131, 75, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkpreEgg.setBounds(new Rectangle(862, 156, 69, 19));
        this.add(chkpreEgg, new KDLayout.Constraints(862, 156, 69, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisMature.setBounds(new Rectangle(915, 149, 78, 19));
        this.add(chkisMature, new KDLayout.Constraints(915, 149, 78, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisAdjust.setBounds(new Rectangle(877, 210, 270, 19));
        this.add(chkisAdjust, new KDLayout.Constraints(877, 210, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkmaleOut.setBounds(new Rectangle(373, 109, 95, 19));
        this.add(chkmaleOut, new KDLayout.Constraints(373, 109, 95, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkfemaleOut.setBounds(new Rectangle(524, 109, 109, 19));
        this.add(chkfemaleOut, new KDLayout.Constraints(524, 109, 109, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkdrugOut.setBounds(new Rectangle(721, 109, 77, 19));
        this.add(chkdrugOut, new KDLayout.Constraints(721, 109, 77, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkimmuneOut.setBounds(new Rectangle(825, 109, 87, 19));
        this.add(chkimmuneOut, new KDLayout.Constraints(825, 109, 87, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkmaterialOut.setBounds(new Rectangle(18, 142, 84, 19));
        this.add(chkmaterialOut, new KDLayout.Constraints(18, 142, 84, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkqualityEggOut.setBounds(new Rectangle(132, 142, 98, 19));
        this.add(chkqualityEggOut, new KDLayout.Constraints(132, 142, 98, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkunQualityEggOut.setBounds(new Rectangle(373, 142, 120, 19));
        this.add(chkunQualityEggOut, new KDLayout.Constraints(373, 142, 120, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //kdTabPanelMain
        kdTabPanelMain.add(kDPanelFeed, resHelper.getString("kDPanelFeed.constraints"));
        kdTabPanelMain.add(kDPanelBreed, resHelper.getString("kDPanelBreed.constraints"));
        kdTabPanelMain.add(kDPanelEgg, resHelper.getString("kDPanelEgg.constraints"));
        kdTabPanelMain.add(kDPanelSendEgg, resHelper.getString("kDPanelSendEgg.constraints"));
        kdTabPanelMain.add(kDPanelDrug, resHelper.getString("kDPanelDrug.constraints"));
        kdTabPanelMain.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        kdTabPanelMain.add(kDPanelEnvi, resHelper.getString("kDPanelEnvi.constraints"));
        kdTabPanelMain.add(kDPanelTrans, resHelper.getString("kDPanelTrans.constraints"));
        kdTabPanelMain.add(kDPanelLog, resHelper.getString("kDPanelLog.constraints"));
        kdTabPanelMain.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        //kDPanelFeed
        kDPanelFeed.setLayout(new KDLayout());
        kDPanelFeed.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 330));        kdtEntrys.setBounds(new Rectangle(1, 1, 982, 342));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEntryInfo(),null,false);
        kDPanelFeed.add(kdtEntrys_detailPanel, new KDLayout.Constraints(1, 1, 982, 342, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanelBreed
        kDPanelBreed.setLayout(new KDLayout());
        kDPanelBreed.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 330));        kdtAssEntrys.setBounds(new Rectangle(1, 1, 979, 337));
        kdtAssEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtAssEntrys,new com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyAssEntryInfo(),null,false);
        kDPanelBreed.add(kdtAssEntrys_detailPanel, new KDLayout.Constraints(1, 1, 979, 337, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanelEgg
        kDPanelEgg.setLayout(new KDLayout());
        kDPanelEgg.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 330));        kdtEggEntry.setBounds(new Rectangle(1, 1, 989, 339));
        kdtEggEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEggEntry,new com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEggEntryInfo(),null,false);
        kDPanelEgg.add(kdtEggEntry_detailPanel, new KDLayout.Constraints(1, 1, 989, 339, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanelSendEgg
        kDPanelSendEgg.setLayout(new KDLayout());
        kDPanelSendEgg.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 330));        kdtSendEggEntry.setBounds(new Rectangle(10, 3, 975, 338));
        kdtSendEggEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtSendEggEntry,new com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailySendEggEntryInfo(),null,false);
        kDPanelSendEgg.add(kdtSendEggEntry_detailPanel, new KDLayout.Constraints(10, 3, 975, 338, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanelDrug
        kDPanelDrug.setLayout(new KDLayout());
        kDPanelDrug.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 330));        kdtImmuneEntrys.setBounds(new Rectangle(0, 0, 987, 342));
        kdtImmuneEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtImmuneEntrys,new com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyImmuneEntryInfo(),null,false);
        kDPanelDrug.add(kdtImmuneEntrys_detailPanel, new KDLayout.Constraints(0, 0, 987, 342, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 330));        kdtDrugEntrys.setBounds(new Rectangle(2, 3, 983, 343));
        kdtDrugEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtDrugEntrys,new com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyDrugEntryInfo(),null,false);
        kDPanel2.add(kdtDrugEntrys_detailPanel, new KDLayout.Constraints(2, 3, 983, 343, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanelEnvi
        kDPanelEnvi.setLayout(new KDLayout());
        kDPanelEnvi.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 330));        kdtEnvi.setBounds(new Rectangle(1, -1, 984, 347));
        kdtEnvi_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEnvi,new com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEnviInfo(),null,false);
        kDPanelEnvi.add(kdtEnvi_detailPanel, new KDLayout.Constraints(1, -1, 984, 347, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanelTrans
        kDPanelTrans.setLayout(new KDLayout());
        kDPanelTrans.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 330));        kdtTransEntry.setBounds(new Rectangle(2, 2, 984, 348));
        kdtTransEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtTransEntry,new com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyTransEntryInfo(),null,false);
        kDPanelTrans.add(kdtTransEntry_detailPanel, new KDLayout.Constraints(2, 2, 984, 348, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanelLog
        kDPanelLog.setLayout(new KDLayout());
        kDPanelLog.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 330));        contbreedLog.setBounds(new Rectangle(-1, 0, 983, 340));
        kDPanelLog.add(contbreedLog, new KDLayout.Constraints(-1, 0, 983, 340, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contbreedLog
        contbreedLog.setBoundEditor(scrollPanebreedLog);
        //scrollPanebreedLog
        scrollPanebreedLog.getViewport().add(txtbreedLog, null);
        //kDPanel1
        kDPanel1.setLayout(null);        kdtMatUserEntry.setBounds(new Rectangle(1, 0, 989, 343));
        kdtMatUserEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtMatUserEntry,new com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyMatUserEntryInfo(),null,false);
        kDPanel1.add(kdtMatUserEntry_detailPanel, null);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //contoutSideTFrom
        contoutSideTFrom.setBoundEditor(txtoutSideTFrom);
        //contoutSideTTo
        contoutSideTTo.setBoundEditor(txtoutSideTTo);
        //contweather
        contweather.setBoundEditor(txtweather);
        //contoutHumidityFrom
        contoutHumidityFrom.setBoundEditor(txtoutHumidityFrom);
        //contoutHumidityTo
        contoutHumidityTo.setBoundEditor(txtoutHumidityTo);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contfuel
        contfuel.setBoundEditor(txtfuel);
        //contweek
        contweek.setBoundEditor(txtweek);
        //contweekDay
        contweekDay.setBoundEditor(txtweekDay);
        //contelectricityQty
        contelectricityQty.setBoundEditor(txtelectricityQty);
        //contcoalFual
        contcoalFual.setBoundEditor(txtcoalFual);
        //contdieselFual
        contdieselFual.setBoundEditor(txtdieselFual);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contfarmer
        contfarmer.setBoundEditor(prmtfarmer);
        //contfarm
        contfarm.setBoundEditor(prmtfarm);
        //contstockingBatch
        contstockingBatch.setBoundEditor(prmtstockingBatch);
        //conttransInQty
        conttransInQty.setBoundEditor(txttransInQty);
        //contnowBreedStage
        contnowBreedStage.setBoundEditor(nowBreedStage);
        //contbizPerson
        contbizPerson.setBoundEditor(prmtbizPerson);
        //contsumWeekDay
        contsumWeekDay.setBoundEditor(txtsumWeekDay);
        //contcurrentCostObject
        contcurrentCostObject.setBoundEditor(prmtcurrentCostObject);

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
        this.toolBar.add(btnSubmit);
        this.toolBar.add(btnReset);
        this.toolBar.add(tBtnAudit);
        this.toolBar.add(btnCopy);
        this.toolBar.add(tBtnUnAudit);
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
        this.toolBar.add(btnPCVoucher);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnDelPCVoucher);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(btnNextPerson);
        this.toolBar.add(btnGenNextBill);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("isInit", boolean.class, this.chkisInit, "selected");
		dataBinder.registerBinding("isBreed", boolean.class, this.chkisBreed, "selected");
		dataBinder.registerBinding("preEgg", boolean.class, this.chkpreEgg, "selected");
		dataBinder.registerBinding("isMature", boolean.class, this.chkisMature, "selected");
		dataBinder.registerBinding("isAdjust", boolean.class, this.chkisAdjust, "selected");
		dataBinder.registerBinding("maleOut", boolean.class, this.chkmaleOut, "selected");
		dataBinder.registerBinding("femaleOut", boolean.class, this.chkfemaleOut, "selected");
		dataBinder.registerBinding("drugOut", boolean.class, this.chkdrugOut, "selected");
		dataBinder.registerBinding("immuneOut", boolean.class, this.chkimmuneOut, "selected");
		dataBinder.registerBinding("materialOut", boolean.class, this.chkmaterialOut, "selected");
		dataBinder.registerBinding("qualityEggOut", boolean.class, this.chkqualityEggOut, "selected");
		dataBinder.registerBinding("unQualityEggOut", boolean.class, this.chkunQualityEggOut, "selected");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.material", java.lang.Object.class, this.kdtEntrys, "material.text");
		dataBinder.registerBinding("entrys.materialName", String.class, this.kdtEntrys, "materialName.text");
		dataBinder.registerBinding("entrys.dailyQtyAll", java.math.BigDecimal.class, this.kdtEntrys, "dailyQtyAll.text");
		dataBinder.registerBinding("entrys.waterQty", java.math.BigDecimal.class, this.kdtEntrys, "waterQty.text");
		dataBinder.registerBinding("entrys.limitFeedType", String.class, this.kdtEntrys, "limitFeedType.text");
		dataBinder.registerBinding("entrys.materialModel", String.class, this.kdtEntrys, "materialModel.text");
		dataBinder.registerBinding("entrys.unit", java.lang.Object.class, this.kdtEntrys, "unit.text");
		dataBinder.registerBinding("entrys.house", java.lang.Object.class, this.kdtEntrys, "house.text");
		dataBinder.registerBinding("entrys.unitQty", java.math.BigDecimal.class, this.kdtEntrys, "unitQty.text");
		dataBinder.registerBinding("entrys.bagQty", java.math.BigDecimal.class, this.kdtEntrys, "bagQty.text");
		dataBinder.registerBinding("entrys.femaleDailyQty", java.math.BigDecimal.class, this.kdtEntrys, "femaleDailyQty.text");
		dataBinder.registerBinding("entrys.feMaterail", java.lang.Object.class, this.kdtEntrys, "feMaterail.text");
		dataBinder.registerBinding("entrys.description", String.class, this.kdtEntrys, "description.text");
		dataBinder.registerBinding("entrys.mqlbm", String.class, this.kdtEntrys, "mqlbm.text");
		dataBinder.registerBinding("entrys.averageBreed", java.math.BigDecimal.class, this.kdtEntrys, "averageBreed.text");
		dataBinder.registerBinding("entrys.packageQty", java.math.BigDecimal.class, this.kdtEntrys, "packageQty.text");
		dataBinder.registerBinding("entrys.femaleModel", String.class, this.kdtEntrys, "femaleModel.text");
		dataBinder.registerBinding("AssEntrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtAssEntrys, "id.text");
		dataBinder.registerBinding("AssEntrys", com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyAssEntryInfo.class, this.kdtAssEntrys, "userObject");
		dataBinder.registerBinding("AssEntrys.breedTime", java.math.BigDecimal.class, this.kdtAssEntrys, "breedTime.text");
		dataBinder.registerBinding("AssEntrys.lightingTime", java.math.BigDecimal.class, this.kdtAssEntrys, "lightingTime.text");
		dataBinder.registerBinding("AssEntrys.temperatureTo", java.math.BigDecimal.class, this.kdtAssEntrys, "temperatureTo.text");
		dataBinder.registerBinding("AssEntrys.temperatureFrom", java.math.BigDecimal.class, this.kdtAssEntrys, "temperatureFrom.text");
		dataBinder.registerBinding("AssEntrys.humidityTo", java.math.BigDecimal.class, this.kdtAssEntrys, "humidityTo.text");
		dataBinder.registerBinding("AssEntrys.humidityFrom", java.math.BigDecimal.class, this.kdtAssEntrys, "humidityFrom.text");
		dataBinder.registerBinding("AssEntrys.deathQty", int.class, this.kdtAssEntrys, "deathQty.text");
		dataBinder.registerBinding("AssEntrys.cullQty", int.class, this.kdtAssEntrys, "cullQty.text");
		dataBinder.registerBinding("AssEntrys.breekingStock", int.class, this.kdtAssEntrys, "breekingStock.text");
		dataBinder.registerBinding("AssEntrys.isMarketed", boolean.class, this.kdtAssEntrys, "isMarketed.text");
		dataBinder.registerBinding("AssEntrys.femaleCullQty", java.math.BigDecimal.class, this.kdtAssEntrys, "femaleCullQty.text");
		dataBinder.registerBinding("AssEntrys.femaleDeathQty", java.math.BigDecimal.class, this.kdtAssEntrys, "femaleDeathQty.text");
		dataBinder.registerBinding("AssEntrys.femaleBreedkingStock", java.math.BigDecimal.class, this.kdtAssEntrys, "femaleBreedkingStock.text");
		dataBinder.registerBinding("AssEntrys.house", java.lang.Object.class, this.kdtAssEntrys, "house.text");
		dataBinder.registerBinding("AssEntrys.avgWeight", java.math.BigDecimal.class, this.kdtAssEntrys, "avgWeight.text");
		dataBinder.registerBinding("AssEntrys.femaleQty", java.math.BigDecimal.class, this.kdtAssEntrys, "femaleQty.text");
		dataBinder.registerBinding("AssEntrys.week", int.class, this.kdtAssEntrys, "week.text");
		dataBinder.registerBinding("AssEntrys.weekDays", java.math.BigDecimal.class, this.kdtAssEntrys, "weekDays.text");
		dataBinder.registerBinding("AssEntrys.markedQty", int.class, this.kdtAssEntrys, "markedQty.text");
		dataBinder.registerBinding("AssEntrys.adjustQty", int.class, this.kdtAssEntrys, "adjustQty.text");
		dataBinder.registerBinding("AssEntrys.adjustFemaleQty", int.class, this.kdtAssEntrys, "adjustFemaleQty.text");
		dataBinder.registerBinding("AssEntrys.femaleMarketed", int.class, this.kdtAssEntrys, "femaleMarketed.text");
		dataBinder.registerBinding("AssEntrys.cullTotalWgt", java.math.BigDecimal.class, this.kdtAssEntrys, "cullTotalWgt.text");
		dataBinder.registerBinding("AssEntrys.cullTotalAmt", java.math.BigDecimal.class, this.kdtAssEntrys, "cullTotalAmt.text");
		dataBinder.registerBinding("AssEntrys.cullAvgPrice", java.math.BigDecimal.class, this.kdtAssEntrys, "cullAvgPrice.text");
		dataBinder.registerBinding("AssEntrys.customer", java.lang.Object.class, this.kdtAssEntrys, "customer.text");
		dataBinder.registerBinding("AssEntrys.gjUniformity", java.math.BigDecimal.class, this.kdtAssEntrys, "gjUniformity.text");
		dataBinder.registerBinding("AssEntrys.mjUniformity", java.math.BigDecimal.class, this.kdtAssEntrys, "mjUniformity.text");
		dataBinder.registerBinding("AssEntrys.description", String.class, this.kdtAssEntrys, "description.text");
		dataBinder.registerBinding("AssEntrys.femaleLossW", java.math.BigDecimal.class, this.kdtAssEntrys, "femaleLossW.text");
		dataBinder.registerBinding("AssEntrys.maleLossW", java.math.BigDecimal.class, this.kdtAssEntrys, "maleLossW.text");
		dataBinder.registerBinding("AssEntrys.femaleLossRate", java.math.BigDecimal.class, this.kdtAssEntrys, "femaleLossRate.text");
		dataBinder.registerBinding("AssEntrys.maleLossRate", java.math.BigDecimal.class, this.kdtAssEntrys, "maleLossRate.text");
		dataBinder.registerBinding("AssEntrys.femaleLossStand", java.math.BigDecimal.class, this.kdtAssEntrys, "femaleLossStand.text");
		dataBinder.registerBinding("AssEntrys.maleLossStand", java.math.BigDecimal.class, this.kdtAssEntrys, "maleLossStand.text");
		dataBinder.registerBinding("AssEntrys.femaleLosWeiRate", java.math.BigDecimal.class, this.kdtAssEntrys, "femaleLosWeiRate.text");
		dataBinder.registerBinding("AssEntrys.maleLosWeiStand", java.math.BigDecimal.class, this.kdtAssEntrys, "maleLosWeiStand.text");
		dataBinder.registerBinding("EggEntry.seq", int.class, this.kdtEggEntry, "seq.text");
		dataBinder.registerBinding("EggEntry", com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEggEntryInfo.class, this.kdtEggEntry, "userObject");
		dataBinder.registerBinding("EggEntry.material", java.lang.Object.class, this.kdtEggEntry, "material.text");
		dataBinder.registerBinding("EggEntry.materialName", String.class, this.kdtEggEntry, "materialName.text");
		dataBinder.registerBinding("EggEntry.model", String.class, this.kdtEggEntry, "model.text");
		dataBinder.registerBinding("EggEntry.unit", java.lang.Object.class, this.kdtEggEntry, "unit.text");
		dataBinder.registerBinding("EggEntry.allQty", java.math.BigDecimal.class, this.kdtEggEntry, "allQty.text");
		dataBinder.registerBinding("EggEntry.runQty", java.math.BigDecimal.class, this.kdtEggEntry, "runQty.text");
		dataBinder.registerBinding("EggEntry.house", java.lang.Object.class, this.kdtEggEntry, "house.text");
		dataBinder.registerBinding("EggEntry.qcEggQty", java.math.BigDecimal.class, this.kdtEggEntry, "qcEggQty.text");
		dataBinder.registerBinding("EggEntry.smallEggQty", java.math.BigDecimal.class, this.kdtEggEntry, "smallEggQty.text");
		dataBinder.registerBinding("EggEntry.doubleQty", java.math.BigDecimal.class, this.kdtEggEntry, "doubleQty.text");
		dataBinder.registerBinding("EggEntry.brokenQty", java.math.BigDecimal.class, this.kdtEggEntry, "brokenQty.text");
		dataBinder.registerBinding("EggEntry.mutnatQty", java.math.BigDecimal.class, this.kdtEggEntry, "mutnatQty.text");
		dataBinder.registerBinding("EggEntry.firstQty", java.math.BigDecimal.class, this.kdtEggEntry, "firstQty.text");
		dataBinder.registerBinding("EggEntry.px", com.kingdee.util.enums.Enum.class, this.kdtEggEntry, "px.text");
		dataBinder.registerBinding("EggEntry.rd", java.math.BigDecimal.class, this.kdtEggEntry, "rd.text");
		dataBinder.registerBinding("EggEntry.fxd", java.math.BigDecimal.class, this.kdtEggEntry, "fxd.text");
		dataBinder.registerBinding("EggEntry.zd", java.math.BigDecimal.class, this.kdtEggEntry, "zd.text");
		dataBinder.registerBinding("EggEntry.description", String.class, this.kdtEggEntry, "description.text");
		dataBinder.registerBinding("EggEntry.dz", java.math.BigDecimal.class, this.kdtEggEntry, "dz.text");
		dataBinder.registerBinding("EggEntry.totalLossQty", java.math.BigDecimal.class, this.kdtEggEntry, "totalLossQty.text");
		dataBinder.registerBinding("EggEntry.unQCEgg", java.math.BigDecimal.class, this.kdtEggEntry, "unQCEgg.text");
		dataBinder.registerBinding("EggEntry.eggRate", java.math.BigDecimal.class, this.kdtEggEntry, "eggRate.text");
		dataBinder.registerBinding("EggEntry.BBQty", java.math.BigDecimal.class, this.kdtEggEntry, "BBQty.text");
		dataBinder.registerBinding("SendEggEntry.seq", int.class, this.kdtSendEggEntry, "seq.text");
		dataBinder.registerBinding("SendEggEntry", com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailySendEggEntryInfo.class, this.kdtSendEggEntry, "userObject");
		dataBinder.registerBinding("SendEggEntry.house", java.lang.Object.class, this.kdtSendEggEntry, "house.text");
		dataBinder.registerBinding("SendEggEntry.material", java.lang.Object.class, this.kdtSendEggEntry, "material.text");
		dataBinder.registerBinding("SendEggEntry.qcQty", int.class, this.kdtSendEggEntry, "qcQty.text");
		dataBinder.registerBinding("SendEggEntry.allQty", int.class, this.kdtSendEggEntry, "allQty.text");
		dataBinder.registerBinding("ImmuneEntrys.seq", int.class, this.kdtImmuneEntrys, "seq.text");
		dataBinder.registerBinding("ImmuneEntrys", com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyImmuneEntryInfo.class, this.kdtImmuneEntrys, "userObject");
		dataBinder.registerBinding("ImmuneEntrys.vaccineMaterial", java.lang.Object.class, this.kdtImmuneEntrys, "vaccineMaterial.text");
		dataBinder.registerBinding("ImmuneEntrys.vaccineGetQty", java.math.BigDecimal.class, this.kdtImmuneEntrys, "vaccineGetQty.text");
		dataBinder.registerBinding("ImmuneEntrys.vaccineUsedQty", java.math.BigDecimal.class, this.kdtImmuneEntrys, "vaccineUsedQty.text");
		dataBinder.registerBinding("ImmuneEntrys.vaccineUnit", String.class, this.kdtImmuneEntrys, "vaccineUnit.text");
		dataBinder.registerBinding("ImmuneEntrys.house", java.lang.Object.class, this.kdtImmuneEntrys, "house.text");
		dataBinder.registerBinding("ImmuneEntrys.lot", String.class, this.kdtImmuneEntrys, "lot.text");
		dataBinder.registerBinding("ImmuneEntrys.descriptionNew", String.class, this.kdtImmuneEntrys, "descriptionNew.text");
		dataBinder.registerBinding("ImmuneEntrys.supplier", String.class, this.kdtImmuneEntrys, "supplier.text");
		dataBinder.registerBinding("ImmuneEntrys.manuDate", java.util.Date.class, this.kdtImmuneEntrys, "manuDate.text");
		dataBinder.registerBinding("ImmuneEntrys.effectiveDate", java.util.Date.class, this.kdtImmuneEntrys, "effectiveDate.text");
		dataBinder.registerBinding("ImmuneEntrys.vaccineWay", java.lang.Object.class, this.kdtImmuneEntrys, "vaccineWay.text");
		dataBinder.registerBinding("ImmuneEntrys.responsible", String.class, this.kdtImmuneEntrys, "responsible.text");
		dataBinder.registerBinding("ImmuneEntrys.vaccineName", String.class, this.kdtImmuneEntrys, "vaccineName.text");
		dataBinder.registerBinding("ImmuneEntrys.dose", java.math.BigDecimal.class, this.kdtImmuneEntrys, "dose.text");
		dataBinder.registerBinding("ImmuneEntrys.model", String.class, this.kdtImmuneEntrys, "model.text");
		dataBinder.registerBinding("ImmuneEntrys.baseUnit", String.class, this.kdtImmuneEntrys, "baseUnit.text");
		dataBinder.registerBinding("DrugEntrys.seq", int.class, this.kdtDrugEntrys, "seq.text");
		dataBinder.registerBinding("DrugEntrys", com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyDrugEntryInfo.class, this.kdtDrugEntrys, "userObject");
		dataBinder.registerBinding("DrugEntrys.material", java.lang.Object.class, this.kdtDrugEntrys, "material.text");
		dataBinder.registerBinding("DrugEntrys.materialName", String.class, this.kdtDrugEntrys, "materialName.text");
		dataBinder.registerBinding("DrugEntrys.mainIngredients", String.class, this.kdtDrugEntrys, "mainIngredients.text");
		dataBinder.registerBinding("DrugEntrys.expirationDate", java.util.Date.class, this.kdtDrugEntrys, "expirationDate.text");
		dataBinder.registerBinding("DrugEntrys.dose", java.math.BigDecimal.class, this.kdtDrugEntrys, "dose.text");
		dataBinder.registerBinding("DrugEntrys.route", String.class, this.kdtDrugEntrys, "route.text");
		dataBinder.registerBinding("DrugEntrys.drugQuantity", java.math.BigDecimal.class, this.kdtDrugEntrys, "drugQuantity.text");
		dataBinder.registerBinding("DrugEntrys.purpose", String.class, this.kdtDrugEntrys, "purpose.text");
		dataBinder.registerBinding("DrugEntrys.responsible", String.class, this.kdtDrugEntrys, "responsible.text");
		dataBinder.registerBinding("DrugEntrys.house", java.lang.Object.class, this.kdtDrugEntrys, "house.text");
		dataBinder.registerBinding("DrugEntrys.remark", String.class, this.kdtDrugEntrys, "remark.text");
		dataBinder.registerBinding("DrugEntrys.productionDate", java.util.Date.class, this.kdtDrugEntrys, "productionDate.text");
		dataBinder.registerBinding("DrugEntrys.manufacturers", String.class, this.kdtDrugEntrys, "manufacturers.text");
		dataBinder.registerBinding("DrugEntrys.batchLot", String.class, this.kdtDrugEntrys, "batchLot.text");
		dataBinder.registerBinding("DrugEntrys.model", String.class, this.kdtDrugEntrys, "model.text");
		dataBinder.registerBinding("DrugEntrys.baseUnit", String.class, this.kdtDrugEntrys, "baseUnit.text");
		dataBinder.registerBinding("Envi.seq", int.class, this.kdtEnvi, "seq.text");
		dataBinder.registerBinding("Envi", com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEnviInfo.class, this.kdtEnvi, "userObject");
		dataBinder.registerBinding("Envi.house", java.lang.Object.class, this.kdtEnvi, "house.text");
		dataBinder.registerBinding("Envi.breedTime", java.math.BigDecimal.class, this.kdtEnvi, "breedTime.text");
		dataBinder.registerBinding("Envi.lightingTime", java.math.BigDecimal.class, this.kdtEnvi, "lightingTime.text");
		dataBinder.registerBinding("Envi.highTemp", java.math.BigDecimal.class, this.kdtEnvi, "highTemp.text");
		dataBinder.registerBinding("Envi.lowTemp", java.math.BigDecimal.class, this.kdtEnvi, "lowTemp.text");
		dataBinder.registerBinding("Envi.highHumidity", java.math.BigDecimal.class, this.kdtEnvi, "highHumidity.text");
		dataBinder.registerBinding("Envi.lowHumidity", java.math.BigDecimal.class, this.kdtEnvi, "lowHumidity.text");
		dataBinder.registerBinding("Envi.lightIntensity", java.math.BigDecimal.class, this.kdtEnvi, "lightIntensity.text");
		dataBinder.registerBinding("Envi.remark", String.class, this.kdtEnvi, "remark.text");
		dataBinder.registerBinding("Envi.nightFeedTime", String.class, this.kdtEnvi, "nightFeedTime.text");
		dataBinder.registerBinding("TransEntry.seq", int.class, this.kdtTransEntry, "seq.text");
		dataBinder.registerBinding("TransEntry", com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyTransEntryInfo.class, this.kdtTransEntry, "userObject");
		dataBinder.registerBinding("TransEntry.transQty", int.class, this.kdtTransEntry, "transQty.text");
		dataBinder.registerBinding("TransEntry.transFemaleQty", int.class, this.kdtTransEntry, "transFemaleQty.text");
		dataBinder.registerBinding("TransEntry.house", java.lang.Object.class, this.kdtTransEntry, "house.text");
		dataBinder.registerBinding("TransEntry.fromStockingBatch", java.lang.Object.class, this.kdtTransEntry, "fromStockingBatch.text");
		dataBinder.registerBinding("TransEntry.fromFarmers", java.lang.Object.class, this.kdtTransEntry, "fromFarmers.text");
		dataBinder.registerBinding("TransEntry.fromFarm", java.lang.Object.class, this.kdtTransEntry, "fromFarm.text");
		dataBinder.registerBinding("TransEntry.fromHouse", java.lang.Object.class, this.kdtTransEntry, "fromHouse.text");
		dataBinder.registerBinding("TransEntry.description", String.class, this.kdtTransEntry, "description.text");
		dataBinder.registerBinding("breedLog", String.class, this.txtbreedLog, "text");
		dataBinder.registerBinding("MatUserEntry.seq", int.class, this.kdtMatUserEntry, "seq.text");
		dataBinder.registerBinding("MatUserEntry", com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyMatUserEntryInfo.class, this.kdtMatUserEntry, "userObject");
		dataBinder.registerBinding("MatUserEntry.matNum", java.lang.Object.class, this.kdtMatUserEntry, "matNum.text");
		dataBinder.registerBinding("MatUserEntry.matName", String.class, this.kdtMatUserEntry, "matName.text");
		dataBinder.registerBinding("MatUserEntry.matModel", String.class, this.kdtMatUserEntry, "matModel.text");
		dataBinder.registerBinding("MatUserEntry.matUnit", String.class, this.kdtMatUserEntry, "matUnit.text");
		dataBinder.registerBinding("MatUserEntry.matQty", java.math.BigDecimal.class, this.kdtMatUserEntry, "matQty.text");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("outSideTFrom", java.math.BigDecimal.class, this.txtoutSideTFrom, "value");
		dataBinder.registerBinding("outSideTTo", java.math.BigDecimal.class, this.txtoutSideTTo, "value");
		dataBinder.registerBinding("weather", String.class, this.txtweather, "text");
		dataBinder.registerBinding("outHumidityFrom", java.math.BigDecimal.class, this.txtoutHumidityFrom, "value");
		dataBinder.registerBinding("outHumidityTo", java.math.BigDecimal.class, this.txtoutHumidityTo, "value");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("fuel", java.math.BigDecimal.class, this.txtfuel, "value");
		dataBinder.registerBinding("week", int.class, this.txtweek, "value");
		dataBinder.registerBinding("weekDay", int.class, this.txtweekDay, "value");
		dataBinder.registerBinding("electricityQty", java.math.BigDecimal.class, this.txtelectricityQty, "value");
		dataBinder.registerBinding("coalFual", java.math.BigDecimal.class, this.txtcoalFual, "value");
		dataBinder.registerBinding("dieselFual", java.math.BigDecimal.class, this.txtdieselFual, "value");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("farmer", com.kingdee.eas.farm.stocking.basedata.FarmersInfo.class, this.prmtfarmer, "data");
		dataBinder.registerBinding("farm", com.kingdee.eas.farm.stocking.basedata.FarmInfo.class, this.prmtfarm, "data");
		dataBinder.registerBinding("stockingBatch", com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo.class, this.prmtstockingBatch, "data");
		dataBinder.registerBinding("transInQty", java.math.BigDecimal.class, this.txttransInQty, "value");
		dataBinder.registerBinding("nowBreedStage", com.kingdee.eas.farm.stocking.basedata.FarmStageEnum.class, this.nowBreedStage, "selectedItem");
		dataBinder.registerBinding("bizPerson", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtbizPerson, "data");
		dataBinder.registerBinding("sumWeekDay", String.class, this.txtsumWeekDay, "text");
		dataBinder.registerBinding("currentCostObject", com.kingdee.eas.basedata.assistant.CostObjectInfo.class, this.prmtcurrentCostObject, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.stocking.processbizill.app.StockingBreedDailyEditUIHandler";
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
        this.chkisMature.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo)ov;
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
		getValidateHelper().registerBindProperty("isInit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isBreed", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("preEgg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isMature", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isAdjust", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("maleOut", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("femaleOut", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("drugOut", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("immuneOut", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("materialOut", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("qualityEggOut", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("unQualityEggOut", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.materialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.dailyQtyAll", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.waterQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.limitFeedType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.materialModel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.house", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.unitQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.bagQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.femaleDailyQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.feMaterail", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.mqlbm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.averageBreed", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.packageQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.femaleModel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.breedTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.lightingTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.temperatureTo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.temperatureFrom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.humidityTo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.humidityFrom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.deathQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.cullQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.breekingStock", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.isMarketed", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.femaleCullQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.femaleDeathQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.femaleBreedkingStock", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.house", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.avgWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.femaleQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.week", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.weekDays", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.markedQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.adjustQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.adjustFemaleQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.femaleMarketed", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.cullTotalWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.cullTotalAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.cullAvgPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.customer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.gjUniformity", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.mjUniformity", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.femaleLossW", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.maleLossW", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.femaleLossRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.maleLossRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.femaleLossStand", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.maleLossStand", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.femaleLosWeiRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.maleLosWeiStand", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.materialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.model", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.allQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.runQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.house", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.qcEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.smallEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.doubleQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.brokenQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.mutnatQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.firstQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.px", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.rd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.fxd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.zd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.dz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.totalLossQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.unQCEgg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.eggRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.BBQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SendEggEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SendEggEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SendEggEntry.house", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SendEggEntry.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SendEggEntry.qcQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SendEggEntry.allQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.vaccineMaterial", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.vaccineGetQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.vaccineUsedQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.vaccineUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.house", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.lot", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.descriptionNew", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.supplier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.manuDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.effectiveDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.vaccineWay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.responsible", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.vaccineName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.dose", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.model", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.baseUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntrys.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntrys.materialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntrys.mainIngredients", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntrys.expirationDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntrys.dose", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntrys.route", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntrys.drugQuantity", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntrys.purpose", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntrys.responsible", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntrys.house", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntrys.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntrys.productionDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntrys.manufacturers", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntrys.batchLot", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntrys.model", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntrys.baseUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Envi.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Envi", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Envi.house", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Envi.breedTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Envi.lightingTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Envi.highTemp", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Envi.lowTemp", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Envi.highHumidity", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Envi.lowHumidity", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Envi.lightIntensity", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Envi.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Envi.nightFeedTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntry.transQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntry.transFemaleQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntry.house", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntry.fromStockingBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntry.fromFarmers", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntry.fromFarm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntry.fromHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntry.description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedLog", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MatUserEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MatUserEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MatUserEntry.matNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MatUserEntry.matName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MatUserEntry.matModel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MatUserEntry.matUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MatUserEntry.matQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("outSideTFrom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("outSideTTo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("weather", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("outHumidityFrom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("outHumidityTo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fuel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("week", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("weekDay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("electricityQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("coalFual", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dieselFual", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("stockingBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("transInQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("nowBreedStage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizPerson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sumWeekDay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("currentCostObject", ValidateHelper.ON_SAVE);    		
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
     * output kdtEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"materialModel").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"material").getValue(),"model")));

}

    if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"unit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"material").getValue(),"baseUnit"));

}

    if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"materialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"material").getValue(),"name")));

}

    if ("unitQty".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"dailyQtyAll").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,"unitQty").getValue())* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,"bagQty").getValue())));

}

    if ("bagQty".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"dailyQtyAll").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,"unitQty").getValue())* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,"bagQty").getValue())));

}

    if ("feMaterail".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"mqlbm").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"feMaterail").getValue(),"number")));

}

    if ("feMaterail".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"femaleModel").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"feMaterail").getValue(),"model")));

}


    }

    /**
     * output kdtAssEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtAssEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("avgWeight".equalsIgnoreCase(kdtAssEntrys.getColumn(colIndex).getKey())) {
if (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtAssEntrys.getCell(rowIndex,"femaleQty").getValue())<= 0) 
{
    kdtAssEntrys.getCell(rowIndex,"femaleQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex,"avgWeight").getValue()));
}

}

    if ("femaleQty".equalsIgnoreCase(kdtAssEntrys.getColumn(colIndex).getKey())) {
if (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtAssEntrys.getCell(rowIndex,"avgWeight").getValue())<= 0) 
{
    kdtAssEntrys.getCell(rowIndex,"avgWeight").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex,"femaleQty").getValue()));
}

}


    }

    /**
     * output kdtEggEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEggEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("material".equalsIgnoreCase(kdtEggEntry.getColumn(colIndex).getKey())) {
kdtEggEntry.getCell(rowIndex,"materialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEggEntry.getCell(rowIndex,"material").getValue(),"name")));

}

    if ("material".equalsIgnoreCase(kdtEggEntry.getColumn(colIndex).getKey())) {
kdtEggEntry.getCell(rowIndex,"model").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEggEntry.getCell(rowIndex,"material").getValue(),"model")));

}

    if ("material".equalsIgnoreCase(kdtEggEntry.getColumn(colIndex).getKey())) {
kdtEggEntry.getCell(rowIndex,"unit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEggEntry.getCell(rowIndex,"material").getValue(),"baseUnit"));

}


    }

    /**
     * output kdtImmuneEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtImmuneEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("vaccineMaterial".equalsIgnoreCase(kdtImmuneEntrys.getColumn(colIndex).getKey())) {
kdtImmuneEntrys.getCell(rowIndex,"vaccineName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtImmuneEntrys.getCell(rowIndex,"vaccineMaterial").getValue(),"name")));

}

    if ("vaccineMaterial".equalsIgnoreCase(kdtImmuneEntrys.getColumn(colIndex).getKey())) {
kdtImmuneEntrys.getCell(rowIndex,"vaccineUnit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtImmuneEntrys.getCell(rowIndex,"vaccineMaterial").getValue(),"baseUnit.name")));

}

    if ("vaccineMaterial".equalsIgnoreCase(kdtImmuneEntrys.getColumn(colIndex).getKey())) {
kdtImmuneEntrys.getCell(rowIndex,"model").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtImmuneEntrys.getCell(rowIndex,"vaccineMaterial").getValue(),"model")));

}

    if ("vaccineMaterial".equalsIgnoreCase(kdtImmuneEntrys.getColumn(colIndex).getKey())) {
kdtImmuneEntrys.getCell(rowIndex,"baseUnit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtImmuneEntrys.getCell(rowIndex,"vaccineMaterial").getValue(),"baseUnit.name")));

}

    if ("vaccineMaterial".equalsIgnoreCase(kdtImmuneEntrys.getColumn(colIndex).getKey())) {
kdtImmuneEntrys.getCell(rowIndex,"baseUnit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtImmuneEntrys.getCell(rowIndex,"vaccineMaterial").getValue(),"baseUnit.name")));

}


    }

    /**
     * output kdtDrugEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtDrugEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("material".equalsIgnoreCase(kdtDrugEntrys.getColumn(colIndex).getKey())) {
kdtDrugEntrys.getCell(rowIndex,"materialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtDrugEntrys.getCell(rowIndex,"material").getValue(),"name")));

}

    if ("material".equalsIgnoreCase(kdtDrugEntrys.getColumn(colIndex).getKey())) {
kdtDrugEntrys.getCell(rowIndex,"model").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtDrugEntrys.getCell(rowIndex,"material").getValue(),"model")));

}

    if ("material".equalsIgnoreCase(kdtDrugEntrys.getColumn(colIndex).getKey())) {
kdtDrugEntrys.getCell(rowIndex,"baseUnit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtDrugEntrys.getCell(rowIndex,"material").getValue(),"baseUnit.name")));

}


    }

    /**
     * output kdtMatUserEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtMatUserEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("matNum".equalsIgnoreCase(kdtMatUserEntry.getColumn(colIndex).getKey())) {
kdtMatUserEntry.getCell(rowIndex,"matName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtMatUserEntry.getCell(rowIndex,"matNum").getValue(),"name")));

}

    if ("matNum".equalsIgnoreCase(kdtMatUserEntry.getColumn(colIndex).getKey())) {
kdtMatUserEntry.getCell(rowIndex,"matModel").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtMatUserEntry.getCell(rowIndex,"matNum").getValue(),"model")));

}

    if ("matNum".equalsIgnoreCase(kdtMatUserEntry.getColumn(colIndex).getKey())) {
kdtMatUserEntry.getCell(rowIndex,"matUnit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtMatUserEntry.getCell(rowIndex,"matNum").getValue(),"baseUnit.name")));

}


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
        sic.add(new SelectorItemInfo("isInit"));
        sic.add(new SelectorItemInfo("isBreed"));
        sic.add(new SelectorItemInfo("preEgg"));
        sic.add(new SelectorItemInfo("isMature"));
        sic.add(new SelectorItemInfo("isAdjust"));
        sic.add(new SelectorItemInfo("maleOut"));
        sic.add(new SelectorItemInfo("femaleOut"));
        sic.add(new SelectorItemInfo("drugOut"));
        sic.add(new SelectorItemInfo("immuneOut"));
        sic.add(new SelectorItemInfo("materialOut"));
        sic.add(new SelectorItemInfo("qualityEggOut"));
        sic.add(new SelectorItemInfo("unQualityEggOut"));
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
    	sic.add(new SelectorItemInfo("entrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.material.id"));
			sic.add(new SelectorItemInfo("entrys.material.number"));
			sic.add(new SelectorItemInfo("entrys.material.name"));
		}
    	sic.add(new SelectorItemInfo("entrys.materialName"));
    	sic.add(new SelectorItemInfo("entrys.dailyQtyAll"));
    	sic.add(new SelectorItemInfo("entrys.waterQty"));
    	sic.add(new SelectorItemInfo("entrys.limitFeedType"));
    	sic.add(new SelectorItemInfo("entrys.materialModel"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.unit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.unit.id"));
			sic.add(new SelectorItemInfo("entrys.unit.name"));
        	sic.add(new SelectorItemInfo("entrys.unit.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.house.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.house.id"));
			sic.add(new SelectorItemInfo("entrys.house.name"));
        	sic.add(new SelectorItemInfo("entrys.house.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.unitQty"));
    	sic.add(new SelectorItemInfo("entrys.bagQty"));
    	sic.add(new SelectorItemInfo("entrys.femaleDailyQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.feMaterail.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.feMaterail.id"));
			sic.add(new SelectorItemInfo("entrys.feMaterail.name"));
        	sic.add(new SelectorItemInfo("entrys.feMaterail.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.description"));
    	sic.add(new SelectorItemInfo("entrys.mqlbm"));
    	sic.add(new SelectorItemInfo("entrys.averageBreed"));
    	sic.add(new SelectorItemInfo("entrys.packageQty"));
    	sic.add(new SelectorItemInfo("entrys.femaleModel"));
    	sic.add(new SelectorItemInfo("AssEntrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("AssEntrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("AssEntrys.breedTime"));
    	sic.add(new SelectorItemInfo("AssEntrys.lightingTime"));
    	sic.add(new SelectorItemInfo("AssEntrys.temperatureTo"));
    	sic.add(new SelectorItemInfo("AssEntrys.temperatureFrom"));
    	sic.add(new SelectorItemInfo("AssEntrys.humidityTo"));
    	sic.add(new SelectorItemInfo("AssEntrys.humidityFrom"));
    	sic.add(new SelectorItemInfo("AssEntrys.deathQty"));
    	sic.add(new SelectorItemInfo("AssEntrys.cullQty"));
    	sic.add(new SelectorItemInfo("AssEntrys.breekingStock"));
    	sic.add(new SelectorItemInfo("AssEntrys.isMarketed"));
    	sic.add(new SelectorItemInfo("AssEntrys.femaleCullQty"));
    	sic.add(new SelectorItemInfo("AssEntrys.femaleDeathQty"));
    	sic.add(new SelectorItemInfo("AssEntrys.femaleBreedkingStock"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("AssEntrys.house.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("AssEntrys.house.id"));
			sic.add(new SelectorItemInfo("AssEntrys.house.name"));
        	sic.add(new SelectorItemInfo("AssEntrys.house.number"));
		}
    	sic.add(new SelectorItemInfo("AssEntrys.avgWeight"));
    	sic.add(new SelectorItemInfo("AssEntrys.femaleQty"));
    	sic.add(new SelectorItemInfo("AssEntrys.week"));
    	sic.add(new SelectorItemInfo("AssEntrys.weekDays"));
    	sic.add(new SelectorItemInfo("AssEntrys.markedQty"));
    	sic.add(new SelectorItemInfo("AssEntrys.adjustQty"));
    	sic.add(new SelectorItemInfo("AssEntrys.adjustFemaleQty"));
    	sic.add(new SelectorItemInfo("AssEntrys.femaleMarketed"));
    	sic.add(new SelectorItemInfo("AssEntrys.cullTotalWgt"));
    	sic.add(new SelectorItemInfo("AssEntrys.cullTotalAmt"));
    	sic.add(new SelectorItemInfo("AssEntrys.cullAvgPrice"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("AssEntrys.customer.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("AssEntrys.customer.id"));
			sic.add(new SelectorItemInfo("AssEntrys.customer.name"));
        	sic.add(new SelectorItemInfo("AssEntrys.customer.number"));
		}
    	sic.add(new SelectorItemInfo("AssEntrys.gjUniformity"));
    	sic.add(new SelectorItemInfo("AssEntrys.mjUniformity"));
    	sic.add(new SelectorItemInfo("AssEntrys.description"));
    	sic.add(new SelectorItemInfo("AssEntrys.femaleLossW"));
    	sic.add(new SelectorItemInfo("AssEntrys.maleLossW"));
    	sic.add(new SelectorItemInfo("AssEntrys.femaleLossRate"));
    	sic.add(new SelectorItemInfo("AssEntrys.maleLossRate"));
    	sic.add(new SelectorItemInfo("AssEntrys.femaleLossStand"));
    	sic.add(new SelectorItemInfo("AssEntrys.maleLossStand"));
    	sic.add(new SelectorItemInfo("AssEntrys.femaleLosWeiRate"));
    	sic.add(new SelectorItemInfo("AssEntrys.maleLosWeiStand"));
    	sic.add(new SelectorItemInfo("EggEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.material.id"));
			sic.add(new SelectorItemInfo("EggEntry.material.number"));
			sic.add(new SelectorItemInfo("EggEntry.material.name"));
		}
    	sic.add(new SelectorItemInfo("EggEntry.materialName"));
    	sic.add(new SelectorItemInfo("EggEntry.model"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.unit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.unit.id"));
			sic.add(new SelectorItemInfo("EggEntry.unit.name"));
        	sic.add(new SelectorItemInfo("EggEntry.unit.number"));
		}
    	sic.add(new SelectorItemInfo("EggEntry.allQty"));
    	sic.add(new SelectorItemInfo("EggEntry.runQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.house.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.house.id"));
			sic.add(new SelectorItemInfo("EggEntry.house.name"));
        	sic.add(new SelectorItemInfo("EggEntry.house.number"));
		}
    	sic.add(new SelectorItemInfo("EggEntry.qcEggQty"));
    	sic.add(new SelectorItemInfo("EggEntry.smallEggQty"));
    	sic.add(new SelectorItemInfo("EggEntry.doubleQty"));
    	sic.add(new SelectorItemInfo("EggEntry.brokenQty"));
    	sic.add(new SelectorItemInfo("EggEntry.mutnatQty"));
    	sic.add(new SelectorItemInfo("EggEntry.firstQty"));
    	sic.add(new SelectorItemInfo("EggEntry.px"));
    	sic.add(new SelectorItemInfo("EggEntry.rd"));
    	sic.add(new SelectorItemInfo("EggEntry.fxd"));
    	sic.add(new SelectorItemInfo("EggEntry.zd"));
    	sic.add(new SelectorItemInfo("EggEntry.description"));
    	sic.add(new SelectorItemInfo("EggEntry.dz"));
    	sic.add(new SelectorItemInfo("EggEntry.totalLossQty"));
    	sic.add(new SelectorItemInfo("EggEntry.unQCEgg"));
    	sic.add(new SelectorItemInfo("EggEntry.eggRate"));
    	sic.add(new SelectorItemInfo("EggEntry.BBQty"));
    	sic.add(new SelectorItemInfo("SendEggEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SendEggEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SendEggEntry.house.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("SendEggEntry.house.id"));
			sic.add(new SelectorItemInfo("SendEggEntry.house.name"));
        	sic.add(new SelectorItemInfo("SendEggEntry.house.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SendEggEntry.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("SendEggEntry.material.id"));
			sic.add(new SelectorItemInfo("SendEggEntry.material.name"));
        	sic.add(new SelectorItemInfo("SendEggEntry.material.number"));
		}
    	sic.add(new SelectorItemInfo("SendEggEntry.qcQty"));
    	sic.add(new SelectorItemInfo("SendEggEntry.allQty"));
    	sic.add(new SelectorItemInfo("ImmuneEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ImmuneEntrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ImmuneEntrys.vaccineMaterial.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("ImmuneEntrys.vaccineMaterial.id"));
			sic.add(new SelectorItemInfo("ImmuneEntrys.vaccineMaterial.name"));
        	sic.add(new SelectorItemInfo("ImmuneEntrys.vaccineMaterial.number"));
		}
    	sic.add(new SelectorItemInfo("ImmuneEntrys.vaccineGetQty"));
    	sic.add(new SelectorItemInfo("ImmuneEntrys.vaccineUsedQty"));
    	sic.add(new SelectorItemInfo("ImmuneEntrys.vaccineUnit"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ImmuneEntrys.house.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("ImmuneEntrys.house.id"));
			sic.add(new SelectorItemInfo("ImmuneEntrys.house.name"));
        	sic.add(new SelectorItemInfo("ImmuneEntrys.house.number"));
		}
    	sic.add(new SelectorItemInfo("ImmuneEntrys.lot"));
    	sic.add(new SelectorItemInfo("ImmuneEntrys.descriptionNew"));
    	sic.add(new SelectorItemInfo("ImmuneEntrys.supplier"));
    	sic.add(new SelectorItemInfo("ImmuneEntrys.manuDate"));
    	sic.add(new SelectorItemInfo("ImmuneEntrys.effectiveDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ImmuneEntrys.vaccineWay.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("ImmuneEntrys.vaccineWay.id"));
			sic.add(new SelectorItemInfo("ImmuneEntrys.vaccineWay.name"));
        	sic.add(new SelectorItemInfo("ImmuneEntrys.vaccineWay.number"));
		}
    	sic.add(new SelectorItemInfo("ImmuneEntrys.responsible"));
    	sic.add(new SelectorItemInfo("ImmuneEntrys.vaccineName"));
    	sic.add(new SelectorItemInfo("ImmuneEntrys.dose"));
    	sic.add(new SelectorItemInfo("ImmuneEntrys.model"));
    	sic.add(new SelectorItemInfo("ImmuneEntrys.baseUnit"));
    	sic.add(new SelectorItemInfo("DrugEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("DrugEntrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("DrugEntrys.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("DrugEntrys.material.id"));
			sic.add(new SelectorItemInfo("DrugEntrys.material.number"));
			sic.add(new SelectorItemInfo("DrugEntrys.material.name"));
		}
    	sic.add(new SelectorItemInfo("DrugEntrys.materialName"));
    	sic.add(new SelectorItemInfo("DrugEntrys.mainIngredients"));
    	sic.add(new SelectorItemInfo("DrugEntrys.expirationDate"));
    	sic.add(new SelectorItemInfo("DrugEntrys.dose"));
    	sic.add(new SelectorItemInfo("DrugEntrys.route"));
    	sic.add(new SelectorItemInfo("DrugEntrys.drugQuantity"));
    	sic.add(new SelectorItemInfo("DrugEntrys.purpose"));
    	sic.add(new SelectorItemInfo("DrugEntrys.responsible"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("DrugEntrys.house.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("DrugEntrys.house.id"));
			sic.add(new SelectorItemInfo("DrugEntrys.house.name"));
        	sic.add(new SelectorItemInfo("DrugEntrys.house.number"));
		}
    	sic.add(new SelectorItemInfo("DrugEntrys.remark"));
    	sic.add(new SelectorItemInfo("DrugEntrys.productionDate"));
    	sic.add(new SelectorItemInfo("DrugEntrys.manufacturers"));
    	sic.add(new SelectorItemInfo("DrugEntrys.batchLot"));
    	sic.add(new SelectorItemInfo("DrugEntrys.model"));
    	sic.add(new SelectorItemInfo("DrugEntrys.baseUnit"));
    	sic.add(new SelectorItemInfo("Envi.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Envi.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Envi.house.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Envi.house.id"));
			sic.add(new SelectorItemInfo("Envi.house.name"));
        	sic.add(new SelectorItemInfo("Envi.house.number"));
		}
    	sic.add(new SelectorItemInfo("Envi.breedTime"));
    	sic.add(new SelectorItemInfo("Envi.lightingTime"));
    	sic.add(new SelectorItemInfo("Envi.highTemp"));
    	sic.add(new SelectorItemInfo("Envi.lowTemp"));
    	sic.add(new SelectorItemInfo("Envi.highHumidity"));
    	sic.add(new SelectorItemInfo("Envi.lowHumidity"));
    	sic.add(new SelectorItemInfo("Envi.lightIntensity"));
    	sic.add(new SelectorItemInfo("Envi.remark"));
    	sic.add(new SelectorItemInfo("Envi.nightFeedTime"));
    	sic.add(new SelectorItemInfo("TransEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransEntry.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("TransEntry.transQty"));
    	sic.add(new SelectorItemInfo("TransEntry.transFemaleQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransEntry.house.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("TransEntry.house.id"));
			sic.add(new SelectorItemInfo("TransEntry.house.name"));
        	sic.add(new SelectorItemInfo("TransEntry.house.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransEntry.fromStockingBatch.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("TransEntry.fromStockingBatch.id"));
			sic.add(new SelectorItemInfo("TransEntry.fromStockingBatch.number"));
			sic.add(new SelectorItemInfo("TransEntry.fromStockingBatch.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransEntry.fromFarmers.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("TransEntry.fromFarmers.id"));
			sic.add(new SelectorItemInfo("TransEntry.fromFarmers.name"));
        	sic.add(new SelectorItemInfo("TransEntry.fromFarmers.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransEntry.fromFarm.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("TransEntry.fromFarm.id"));
			sic.add(new SelectorItemInfo("TransEntry.fromFarm.name"));
        	sic.add(new SelectorItemInfo("TransEntry.fromFarm.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransEntry.fromHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("TransEntry.fromHouse.id"));
			sic.add(new SelectorItemInfo("TransEntry.fromHouse.name"));
        	sic.add(new SelectorItemInfo("TransEntry.fromHouse.number"));
		}
    	sic.add(new SelectorItemInfo("TransEntry.description"));
        sic.add(new SelectorItemInfo("breedLog"));
    	sic.add(new SelectorItemInfo("MatUserEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("MatUserEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("MatUserEntry.matNum.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("MatUserEntry.matNum.id"));
			sic.add(new SelectorItemInfo("MatUserEntry.matNum.number"));
			sic.add(new SelectorItemInfo("MatUserEntry.matNum.name"));
		}
    	sic.add(new SelectorItemInfo("MatUserEntry.matName"));
    	sic.add(new SelectorItemInfo("MatUserEntry.matModel"));
    	sic.add(new SelectorItemInfo("MatUserEntry.matUnit"));
    	sic.add(new SelectorItemInfo("MatUserEntry.matQty"));
        sic.add(new SelectorItemInfo("baseStatus"));
        sic.add(new SelectorItemInfo("outSideTFrom"));
        sic.add(new SelectorItemInfo("outSideTTo"));
        sic.add(new SelectorItemInfo("weather"));
        sic.add(new SelectorItemInfo("outHumidityFrom"));
        sic.add(new SelectorItemInfo("outHumidityTo"));
        sic.add(new SelectorItemInfo("auditTime"));
        sic.add(new SelectorItemInfo("fuel"));
        sic.add(new SelectorItemInfo("week"));
        sic.add(new SelectorItemInfo("weekDay"));
        sic.add(new SelectorItemInfo("electricityQty"));
        sic.add(new SelectorItemInfo("coalFual"));
        sic.add(new SelectorItemInfo("dieselFual"));
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
			sic.add(new SelectorItemInfo("farmer.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farmer.id"));
        	sic.add(new SelectorItemInfo("farmer.number"));
        	sic.add(new SelectorItemInfo("farmer.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("farm.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farm.id"));
        	sic.add(new SelectorItemInfo("farm.number"));
        	sic.add(new SelectorItemInfo("farm.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("stockingBatch.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("stockingBatch.id"));
        	sic.add(new SelectorItemInfo("stockingBatch.number"));
        	sic.add(new SelectorItemInfo("stockingBatch.name"));
		}
        sic.add(new SelectorItemInfo("transInQty"));
        sic.add(new SelectorItemInfo("nowBreedStage"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("bizPerson.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("bizPerson.id"));
        	sic.add(new SelectorItemInfo("bizPerson.number"));
        	sic.add(new SelectorItemInfo("bizPerson.name"));
		}
        sic.add(new SelectorItemInfo("sumWeekDay"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("currentCostObject.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("currentCostObject.id"));
        	sic.add(new SelectorItemInfo("currentCostObject.number"));
        	sic.add(new SelectorItemInfo("currentCostObject.name"));
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
        com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionGenNextBill_actionPerformed method
     */
    public void actionGenNextBill_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyFactory.getRemoteInstance().genNextBill(editData);
    }
    	

    /**
     * output actionReShareCoalAndDiesel_actionPerformed method
     */
    public void actionReShareCoalAndDiesel_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyFactory.getRemoteInstance().reShareCoalAndDiesel(editData);
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
	public RequestContext prepareActionGenNextBill(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionGenNextBill() {
    	return false;
    }
	public RequestContext prepareActionReShareCoalAndDiesel(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionReShareCoalAndDiesel() {
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
            innerActionPerformed("eas", AbstractStockingBreedDailyEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractStockingBreedDailyEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionGenNextBill class
     */     
    protected class ActionGenNextBill extends ItemAction {     
    
        public ActionGenNextBill()
        {
            this(null);
        }

        public ActionGenNextBill(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionGenNextBill.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionGenNextBill.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionGenNextBill.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractStockingBreedDailyEditUI.this, "ActionGenNextBill", "actionGenNextBill_actionPerformed", e);
        }
    }

    /**
     * output ActionReShareCoalAndDiesel class
     */     
    protected class ActionReShareCoalAndDiesel extends ItemAction {     
    
        public ActionReShareCoalAndDiesel()
        {
            this(null);
        }

        public ActionReShareCoalAndDiesel(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionReShareCoalAndDiesel.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionReShareCoalAndDiesel.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionReShareCoalAndDiesel.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractStockingBreedDailyEditUI.this, "ActionReShareCoalAndDiesel", "actionReShareCoalAndDiesel_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.stocking.processbizill.client", "StockingBreedDailyEditUI");
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
        return com.kingdee.eas.farm.stocking.processbizill.client.StockingBreedDailyEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/stocking/processbizill/StockingBreedDaily";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.stocking.processbizill.app.StockingBreedDailyQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		for (int i=0,n=kdtImmuneEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtImmuneEntrys.getCell(i,"vaccineMaterial").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"疫苗"});
			}
		}
		for (int i=0,n=kdtImmuneEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtImmuneEntrys.getCell(i,"vaccineUsedQty").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"使用量"});
			}
		}
		for (int i=0,n=kdtDrugEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtDrugEntrys.getCell(i,"house").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"棚舍"});
			}
		}
		for (int i=0,n=kdtTransEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtTransEntry.getCell(i,"house").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"棚舍"});
			}
		}
		for (int i=0,n=kdtTransEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtTransEntry.getCell(i,"fromStockingBatch").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"转出批次"});
			}
		}
		for (int i=0,n=kdtTransEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtTransEntry.getCell(i,"fromFarm").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"转出养殖场"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(baseStatus.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"状态"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtfarm.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖场"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtstockingBatch.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"批次"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtEntrys;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("baseStatus",new Integer(-1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}        
				protected void setTableToSumField() {
			setTableToSumField(kdtEntrys,new String[] {"dailyQtyAll","waterQty"});
			setTableToSumField(kdtAssEntrys,new String[] {"deathQty","cullQty"});
		}


}