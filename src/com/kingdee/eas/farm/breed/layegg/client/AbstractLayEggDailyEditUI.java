/**
 * output package name
 */
package com.kingdee.eas.farm.breed.layegg.client;

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
public abstract class AbstractLayEggDailyEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractLayEggDailyEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane paneBIZLayerControl17;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoutSideTFrom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoutSideTTo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweather;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoutHumidityFrom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoutHumidityTo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfuel;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contelectricityQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweek;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweekDay;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel1;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contqualifiedQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcommodityQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdoubleYolkQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcoalFual;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdieselFual;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisFixed;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkhadFixed;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contparentBatch;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisTransBrood;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbroodCostObject;
    protected com.kingdee.bos.ctrl.swing.KDContainer kDContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstoOrg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbabyCostObject;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteggCostObject;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkhadBrood;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsumDay;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDPanel baseTab;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel5;
    protected com.kingdee.bos.ctrl.swing.KDPanel assTab;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel6;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntryFieldEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntryFieldEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel3;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtLayEggEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtLayEggEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtCullDeathEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtCullDeathEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtAssEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtAssEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtImmuneEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtImmuneEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtTransHenhouseEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtTransHenhouseEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtFodderEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtFodderEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedLog;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane scrollPanebreedLog;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtbreedLog;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoutSideTFrom;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoutSideTTo;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtweather;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoutHumidityFrom;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoutHumidityTo;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfuel;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtelectricityQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtweek;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtweekDay;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtqualifiedQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcommodityQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdoubleYolkQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcoalFual;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdieselFual;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtparentBatch;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbroodCostObject;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtConveyor;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtConveyor_detailPanel = null;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarm;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstoOrg;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbabyCostObject;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmteggCostObject;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsumDay;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnRefreshInventory;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnGenNextBill;
    protected com.kingdee.eas.farm.breed.layegg.LayEggDailyInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionGenNextBill actionGenNextBill = null;
    protected ActionReShareInfos actionReShareInfos = null;
    protected ActionRefreshInventory actionRefreshInventory = null;
    protected ActionToStockDaily actionToStockDaily = null;
    /**
     * output class constructor
     */
    public AbstractLayEggDailyEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractLayEggDailyEditUI.class.getName());
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
        //actionReShareInfos
        this.actionReShareInfos = new ActionReShareInfos(this);
        getActionManager().registerAction("actionReShareInfos", actionReShareInfos);
        this.actionReShareInfos.setExtendProperty("canForewarn", "true");
        this.actionReShareInfos.setExtendProperty("userDefined", "true");
        this.actionReShareInfos.setExtendProperty("isObjectUpdateLock", "false");
         this.actionReShareInfos.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionReShareInfos.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionRefreshInventory
        this.actionRefreshInventory = new ActionRefreshInventory(this);
        getActionManager().registerAction("actionRefreshInventory", actionRefreshInventory);
        this.actionRefreshInventory.setExtendProperty("canForewarn", "true");
        this.actionRefreshInventory.setExtendProperty("userDefined", "true");
        this.actionRefreshInventory.setExtendProperty("isObjectUpdateLock", "false");
         this.actionRefreshInventory.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionRefreshInventory.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionToStockDaily
        this.actionToStockDaily = new ActionToStockDaily(this);
        getActionManager().registerAction("actionToStockDaily", actionToStockDaily);
        this.actionToStockDaily.setExtendProperty("canForewarn", "true");
        this.actionToStockDaily.setExtendProperty("userDefined", "true");
        this.actionToStockDaily.setExtendProperty("isObjectUpdateLock", "false");
         this.actionToStockDaily.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionToStockDaily.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.paneBIZLayerControl17 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoutSideTFrom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoutSideTTo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweather = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoutHumidityFrom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoutHumidityTo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfuel = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contelectricityQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweek = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweekDay = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabel1 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDLabel2 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.contqualifiedQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcommodityQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdoubleYolkQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcoalFual = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdieselFual = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisFixed = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkhadFixed = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contparentBatch = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisTransBrood = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contbroodCostObject = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDContainer1 = new com.kingdee.bos.ctrl.swing.KDContainer();
        this.contfarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstoOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbabyCostObject = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteggCostObject = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkhadBrood = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contsumDay = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.baseTab = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel5 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.assTab = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel6 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtEntryFieldEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDLabel3 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kdtLayEggEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtCullDeathEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtAssEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtImmuneEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtTransHenhouseEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtFodderEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contbreedLog = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.scrollPanebreedLog = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txtbreedLog = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtoutSideTFrom = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtoutSideTTo = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtweather = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtoutHumidityFrom = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtoutHumidityTo = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtfuel = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtelectricityQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtweek = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtweekDay = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtqualifiedQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcommodityQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdoubleYolkQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcoalFual = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdieselFual = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtparentBatch = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbroodCostObject = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kdtConveyor = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.prmtfarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtstoOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbabyCostObject = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmteggCostObject = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtsumDay = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnRefreshInventory = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnGenNextBill = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.paneBIZLayerControl17.setName("paneBIZLayerControl17");
        this.contbaseStatus.setName("contbaseStatus");
        this.contoutSideTFrom.setName("contoutSideTFrom");
        this.contoutSideTTo.setName("contoutSideTTo");
        this.contweather.setName("contweather");
        this.contoutHumidityFrom.setName("contoutHumidityFrom");
        this.contoutHumidityTo.setName("contoutHumidityTo");
        this.contauditTime.setName("contauditTime");
        this.contfuel.setName("contfuel");
        this.contelectricityQty.setName("contelectricityQty");
        this.contweek.setName("contweek");
        this.contweekDay.setName("contweekDay");
        this.kDLabel1.setName("kDLabel1");
        this.kDLabel2.setName("kDLabel2");
        this.contqualifiedQty.setName("contqualifiedQty");
        this.contcommodityQty.setName("contcommodityQty");
        this.contdoubleYolkQty.setName("contdoubleYolkQty");
        this.contcoalFual.setName("contcoalFual");
        this.contdieselFual.setName("contdieselFual");
        this.chkisFixed.setName("chkisFixed");
        this.chkhadFixed.setName("chkhadFixed");
        this.contparentBatch.setName("contparentBatch");
        this.chkisTransBrood.setName("chkisTransBrood");
        this.contbroodCostObject.setName("contbroodCostObject");
        this.kDContainer1.setName("kDContainer1");
        this.contfarm.setName("contfarm");
        this.contstoOrg.setName("contstoOrg");
        this.contbabyCostObject.setName("contbabyCostObject");
        this.conteggCostObject.setName("conteggCostObject");
        this.chkhadBrood.setName("chkhadBrood");
        this.contsumDay.setName("contsumDay");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.baseTab.setName("baseTab");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel5.setName("kDPanel5");
        this.assTab.setName("assTab");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel6.setName("kDPanel6");
        this.kDPanel3.setName("kDPanel3");
        this.kDPanel4.setName("kDPanel4");
        this.kdtEntrys.setName("kdtEntrys");
        this.kdtEntryFieldEntrys.setName("kdtEntryFieldEntrys");
        this.kDLabel3.setName("kDLabel3");
        this.kdtLayEggEntrys.setName("kdtLayEggEntrys");
        this.kdtCullDeathEntrys.setName("kdtCullDeathEntrys");
        this.kdtAssEntrys.setName("kdtAssEntrys");
        this.kdtImmuneEntrys.setName("kdtImmuneEntrys");
        this.kdtTransHenhouseEntrys.setName("kdtTransHenhouseEntrys");
        this.kdtFodderEntrys.setName("kdtFodderEntrys");
        this.contbreedLog.setName("contbreedLog");
        this.scrollPanebreedLog.setName("scrollPanebreedLog");
        this.txtbreedLog.setName("txtbreedLog");
        this.baseStatus.setName("baseStatus");
        this.txtoutSideTFrom.setName("txtoutSideTFrom");
        this.txtoutSideTTo.setName("txtoutSideTTo");
        this.txtweather.setName("txtweather");
        this.txtoutHumidityFrom.setName("txtoutHumidityFrom");
        this.txtoutHumidityTo.setName("txtoutHumidityTo");
        this.pkauditTime.setName("pkauditTime");
        this.txtfuel.setName("txtfuel");
        this.txtelectricityQty.setName("txtelectricityQty");
        this.txtweek.setName("txtweek");
        this.txtweekDay.setName("txtweekDay");
        this.txtqualifiedQty.setName("txtqualifiedQty");
        this.txtcommodityQty.setName("txtcommodityQty");
        this.txtdoubleYolkQty.setName("txtdoubleYolkQty");
        this.txtcoalFual.setName("txtcoalFual");
        this.txtdieselFual.setName("txtdieselFual");
        this.prmtparentBatch.setName("prmtparentBatch");
        this.prmtbroodCostObject.setName("prmtbroodCostObject");
        this.kdtConveyor.setName("kdtConveyor");
        this.prmtfarm.setName("prmtfarm");
        this.prmtstoOrg.setName("prmtstoOrg");
        this.prmtbabyCostObject.setName("prmtbabyCostObject");
        this.prmteggCostObject.setName("prmteggCostObject");
        this.txtsumDay.setName("txtsumDay");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
        this.btnRefreshInventory.setName("btnRefreshInventory");
        this.btnGenNextBill.setName("btnGenNextBill");
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
        this.contLastUpdateUser.setVisible(false);		
        this.contLastUpdateUser.setBoundLabelAlignment(7);		
        this.contLastUpdateUser.setForeground(new java.awt.Color(0,0,0));
        // contLastUpdateTime		
        this.contLastUpdateTime.setBoundLabelText(resHelper.getString("contLastUpdateTime.boundLabelText"));		
        this.contLastUpdateTime.setBoundLabelLength(100);		
        this.contLastUpdateTime.setBoundLabelUnderline(true);		
        this.contLastUpdateTime.setEnabled(false);		
        this.contLastUpdateTime.setVisible(false);		
        this.contLastUpdateTime.setBoundLabelAlignment(7);		
        this.contLastUpdateTime.setForeground(new java.awt.Color(0,0,0));
        // contNumber		
        this.contNumber.setBoundLabelText(resHelper.getString("contNumber.boundLabelText"));		
        this.contNumber.setBoundLabelLength(100);		
        this.contNumber.setBoundLabelUnderline(true);		
        this.contNumber.setBoundLabelAlignment(7);		
        this.contNumber.setVisible(true);		
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
        this.contDescription.setVisible(true);		
        this.contDescription.setForeground(new java.awt.Color(0,0,0));
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);		
        this.contAuditor.setBoundLabelAlignment(7);		
        this.contAuditor.setVisible(true);		
        this.contAuditor.setForeground(new java.awt.Color(0,0,0));
        // paneBIZLayerControl17		
        this.paneBIZLayerControl17.setVisible(true);
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
        this.contweather.setVisible(true);
        // contoutHumidityFrom		
        this.contoutHumidityFrom.setBoundLabelText(resHelper.getString("contoutHumidityFrom.boundLabelText"));		
        this.contoutHumidityFrom.setBoundLabelLength(100);		
        this.contoutHumidityFrom.setBoundLabelUnderline(true);		
        this.contoutHumidityFrom.setVisible(true);
        // contoutHumidityTo		
        this.contoutHumidityTo.setBoundLabelText(resHelper.getString("contoutHumidityTo.boundLabelText"));		
        this.contoutHumidityTo.setBoundLabelLength(100);		
        this.contoutHumidityTo.setBoundLabelUnderline(true);		
        this.contoutHumidityTo.setVisible(true);
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
        // contelectricityQty		
        this.contelectricityQty.setBoundLabelText(resHelper.getString("contelectricityQty.boundLabelText"));		
        this.contelectricityQty.setBoundLabelLength(100);		
        this.contelectricityQty.setBoundLabelUnderline(true);		
        this.contelectricityQty.setVisible(true);
        // contweek		
        this.contweek.setBoundLabelText(resHelper.getString("contweek.boundLabelText"));		
        this.contweek.setBoundLabelLength(100);		
        this.contweek.setBoundLabelUnderline(true);		
        this.contweek.setVisible(true);
        // contweekDay		
        this.contweekDay.setBoundLabelText(resHelper.getString("contweekDay.boundLabelText"));		
        this.contweekDay.setBoundLabelLength(0);		
        this.contweekDay.setBoundLabelUnderline(true);		
        this.contweekDay.setVisible(true);
        // kDLabel1		
        this.kDLabel1.setText(resHelper.getString("kDLabel1.text"));
        // kDLabel2		
        this.kDLabel2.setText(resHelper.getString("kDLabel2.text"));
        // contqualifiedQty		
        this.contqualifiedQty.setBoundLabelText(resHelper.getString("contqualifiedQty.boundLabelText"));		
        this.contqualifiedQty.setBoundLabelLength(100);		
        this.contqualifiedQty.setBoundLabelUnderline(true);		
        this.contqualifiedQty.setVisible(false);
        // contcommodityQty		
        this.contcommodityQty.setBoundLabelText(resHelper.getString("contcommodityQty.boundLabelText"));		
        this.contcommodityQty.setBoundLabelLength(100);		
        this.contcommodityQty.setBoundLabelUnderline(true);		
        this.contcommodityQty.setVisible(false);
        // contdoubleYolkQty		
        this.contdoubleYolkQty.setBoundLabelText(resHelper.getString("contdoubleYolkQty.boundLabelText"));		
        this.contdoubleYolkQty.setBoundLabelLength(100);		
        this.contdoubleYolkQty.setBoundLabelUnderline(true);		
        this.contdoubleYolkQty.setVisible(false);
        // contcoalFual		
        this.contcoalFual.setBoundLabelText(resHelper.getString("contcoalFual.boundLabelText"));		
        this.contcoalFual.setBoundLabelLength(100);		
        this.contcoalFual.setBoundLabelUnderline(true);		
        this.contcoalFual.setVisible(true);
        // contdieselFual		
        this.contdieselFual.setBoundLabelText(resHelper.getString("contdieselFual.boundLabelText"));		
        this.contdieselFual.setBoundLabelLength(100);		
        this.contdieselFual.setBoundLabelUnderline(true);		
        this.contdieselFual.setVisible(true);
        // chkisFixed		
        this.chkisFixed.setText(resHelper.getString("chkisFixed.text"));		
        this.chkisFixed.setHorizontalAlignment(2);
        this.chkisFixed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    chkisFixed_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // chkhadFixed		
        this.chkhadFixed.setText(resHelper.getString("chkhadFixed.text"));		
        this.chkhadFixed.setHorizontalAlignment(2);		
        this.chkhadFixed.setEnabled(false);
        // contparentBatch		
        this.contparentBatch.setBoundLabelText(resHelper.getString("contparentBatch.boundLabelText"));		
        this.contparentBatch.setBoundLabelLength(100);		
        this.contparentBatch.setBoundLabelUnderline(true);		
        this.contparentBatch.setVisible(true);
        // chkisTransBrood		
        this.chkisTransBrood.setText(resHelper.getString("chkisTransBrood.text"));		
        this.chkisTransBrood.setHorizontalAlignment(2);
        this.chkisTransBrood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    chkisTransBrood_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // contbroodCostObject		
        this.contbroodCostObject.setBoundLabelText(resHelper.getString("contbroodCostObject.boundLabelText"));		
        this.contbroodCostObject.setBoundLabelLength(100);		
        this.contbroodCostObject.setBoundLabelUnderline(true);
        // kDContainer1		
        this.kDContainer1.setVisible(false);
        // contfarm		
        this.contfarm.setBoundLabelText(resHelper.getString("contfarm.boundLabelText"));		
        this.contfarm.setBoundLabelLength(100);		
        this.contfarm.setBoundLabelUnderline(true);		
        this.contfarm.setVisible(true);
        // contstoOrg		
        this.contstoOrg.setBoundLabelText(resHelper.getString("contstoOrg.boundLabelText"));		
        this.contstoOrg.setBoundLabelLength(100);		
        this.contstoOrg.setBoundLabelUnderline(true);
        // contbabyCostObject		
        this.contbabyCostObject.setBoundLabelText(resHelper.getString("contbabyCostObject.boundLabelText"));		
        this.contbabyCostObject.setBoundLabelLength(100);		
        this.contbabyCostObject.setBoundLabelUnderline(true);		
        this.contbabyCostObject.setVisible(false);
        // conteggCostObject		
        this.conteggCostObject.setBoundLabelText(resHelper.getString("conteggCostObject.boundLabelText"));		
        this.conteggCostObject.setBoundLabelLength(100);		
        this.conteggCostObject.setBoundLabelUnderline(true);		
        this.conteggCostObject.setVisible(true);
        // chkhadBrood		
        this.chkhadBrood.setText(resHelper.getString("chkhadBrood.text"));		
        this.chkhadBrood.setHorizontalAlignment(2);		
        this.chkhadBrood.setEnabled(false);
        // contsumDay		
        this.contsumDay.setBoundLabelText(resHelper.getString("contsumDay.boundLabelText"));		
        this.contsumDay.setBoundLabelLength(40);		
        this.contsumDay.setBoundLabelUnderline(true);		
        this.contsumDay.setVisible(true);
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
        this.prmtLastUpdateUser.setVisible(false);		
        this.prmtLastUpdateUser.setRequired(false);		
        this.prmtLastUpdateUser.setForeground(new java.awt.Color(0,0,0));
        // kDDateLastUpdateTime		
        this.kDDateLastUpdateTime.setTimeEnabled(true);		
        this.kDDateLastUpdateTime.setEnabled(false);		
        this.kDDateLastUpdateTime.setVisible(false);		
        this.kDDateLastUpdateTime.setRequired(false);		
        this.kDDateLastUpdateTime.setForeground(new java.awt.Color(0,0,0));
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setEnabled(true);		
        this.txtNumber.setHorizontalAlignment(2);		
        this.txtNumber.setRequired(true);		
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
        // baseTab		
        this.baseTab.setVisible(true);
        // kDPanel2
        // kDPanel5
        // assTab		
        this.assTab.setVisible(true);
        // kDPanel1
        // kDPanel6
        // kDPanel3
        // kDPanel4
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol10\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"henhouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"henhouseName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"henMaterial\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"henMaterialName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"henMaterialModel\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"henQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"henAverageWeight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"cockMaterial\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"cockMaterialName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"cockMaterialModel\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"cockQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"waterQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"cockAverageWeight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"uniformityCV\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"uniformity\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{henhouse}</t:Cell><t:Cell>$Resource{henhouseName}</t:Cell><t:Cell>$Resource{henMaterial}</t:Cell><t:Cell>$Resource{henMaterialName}</t:Cell><t:Cell>$Resource{henMaterialModel}</t:Cell><t:Cell>$Resource{henQty}</t:Cell><t:Cell>$Resource{henAverageWeight}</t:Cell><t:Cell>$Resource{cockMaterial}</t:Cell><t:Cell>$Resource{cockMaterialName}</t:Cell><t:Cell>$Resource{cockMaterialModel}</t:Cell><t:Cell>$Resource{cockQty}</t:Cell><t:Cell>$Resource{waterQty}</t:Cell><t:Cell>$Resource{cockAverageWeight}</t:Cell><t:Cell>$Resource{uniformityCV}</t:Cell><t:Cell>$Resource{uniformity}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtEntrys.putBindContents("editData",new String[] {"id","henhouse","henhouseName","henMaterial","henMaterialName","henMaterialModel","henQty","henAverageWeight","cockMaterial","cockMaterialName","cockMaterialModel","cockQty","waterQty","cockAverageWeight","uniformityCV","uniformity"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_henhouse_PromptBox = new KDBizPromptBox();
        kdtEntrys_henhouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseF7Query");
        kdtEntrys_henhouse_PromptBox.setVisible(true);
        kdtEntrys_henhouse_PromptBox.setEditable(true);
        kdtEntrys_henhouse_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_henhouse_PromptBox.setEditFormat("$number$");
        kdtEntrys_henhouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_henhouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henhouse_PromptBox);
        this.kdtEntrys.getColumn("henhouse").setEditor(kdtEntrys_henhouse_CellEditor);
        ObjectValueRender kdtEntrys_henhouse_OVR = new ObjectValueRender();
        kdtEntrys_henhouse_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("henhouse").setRenderer(kdtEntrys_henhouse_OVR);
        KDTextField kdtEntrys_henhouseName_TextField = new KDTextField();
        kdtEntrys_henhouseName_TextField.setName("kdtEntrys_henhouseName_TextField");
        kdtEntrys_henhouseName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_henhouseName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henhouseName_TextField);
        this.kdtEntrys.getColumn("henhouseName").setEditor(kdtEntrys_henhouseName_CellEditor);
        final KDBizPromptBox kdtEntrys_henMaterial_PromptBox = new KDBizPromptBox();
        kdtEntrys_henMaterial_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtEntrys_henMaterial_PromptBox.setVisible(true);
        kdtEntrys_henMaterial_PromptBox.setEditable(true);
        kdtEntrys_henMaterial_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_henMaterial_PromptBox.setEditFormat("$number$");
        kdtEntrys_henMaterial_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_henMaterial_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henMaterial_PromptBox);
        this.kdtEntrys.getColumn("henMaterial").setEditor(kdtEntrys_henMaterial_CellEditor);
        ObjectValueRender kdtEntrys_henMaterial_OVR = new ObjectValueRender();
        kdtEntrys_henMaterial_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("henMaterial").setRenderer(kdtEntrys_henMaterial_OVR);
        KDTextField kdtEntrys_henMaterialName_TextField = new KDTextField();
        kdtEntrys_henMaterialName_TextField.setName("kdtEntrys_henMaterialName_TextField");
        kdtEntrys_henMaterialName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_henMaterialName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henMaterialName_TextField);
        this.kdtEntrys.getColumn("henMaterialName").setEditor(kdtEntrys_henMaterialName_CellEditor);
        KDTextField kdtEntrys_henMaterialModel_TextField = new KDTextField();
        kdtEntrys_henMaterialModel_TextField.setName("kdtEntrys_henMaterialModel_TextField");
        kdtEntrys_henMaterialModel_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_henMaterialModel_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henMaterialModel_TextField);
        this.kdtEntrys.getColumn("henMaterialModel").setEditor(kdtEntrys_henMaterialModel_CellEditor);
        KDFormattedTextField kdtEntrys_henQty_TextField = new KDFormattedTextField();
        kdtEntrys_henQty_TextField.setName("kdtEntrys_henQty_TextField");
        kdtEntrys_henQty_TextField.setVisible(true);
        kdtEntrys_henQty_TextField.setEditable(true);
        kdtEntrys_henQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_henQty_TextField.setDataType(1);
        	kdtEntrys_henQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_henQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_henQty_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_henQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henQty_TextField);
        this.kdtEntrys.getColumn("henQty").setEditor(kdtEntrys_henQty_CellEditor);
        KDFormattedTextField kdtEntrys_henAverageWeight_TextField = new KDFormattedTextField();
        kdtEntrys_henAverageWeight_TextField.setName("kdtEntrys_henAverageWeight_TextField");
        kdtEntrys_henAverageWeight_TextField.setVisible(true);
        kdtEntrys_henAverageWeight_TextField.setEditable(true);
        kdtEntrys_henAverageWeight_TextField.setHorizontalAlignment(2);
        kdtEntrys_henAverageWeight_TextField.setDataType(1);
        	kdtEntrys_henAverageWeight_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_henAverageWeight_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_henAverageWeight_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_henAverageWeight_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henAverageWeight_TextField);
        this.kdtEntrys.getColumn("henAverageWeight").setEditor(kdtEntrys_henAverageWeight_CellEditor);
        final KDBizPromptBox kdtEntrys_cockMaterial_PromptBox = new KDBizPromptBox();
        kdtEntrys_cockMaterial_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtEntrys_cockMaterial_PromptBox.setVisible(true);
        kdtEntrys_cockMaterial_PromptBox.setEditable(true);
        kdtEntrys_cockMaterial_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_cockMaterial_PromptBox.setEditFormat("$number$");
        kdtEntrys_cockMaterial_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_cockMaterial_CellEditor = new KDTDefaultCellEditor(kdtEntrys_cockMaterial_PromptBox);
        this.kdtEntrys.getColumn("cockMaterial").setEditor(kdtEntrys_cockMaterial_CellEditor);
        ObjectValueRender kdtEntrys_cockMaterial_OVR = new ObjectValueRender();
        kdtEntrys_cockMaterial_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("cockMaterial").setRenderer(kdtEntrys_cockMaterial_OVR);
        KDTextField kdtEntrys_cockMaterialName_TextField = new KDTextField();
        kdtEntrys_cockMaterialName_TextField.setName("kdtEntrys_cockMaterialName_TextField");
        kdtEntrys_cockMaterialName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_cockMaterialName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_cockMaterialName_TextField);
        this.kdtEntrys.getColumn("cockMaterialName").setEditor(kdtEntrys_cockMaterialName_CellEditor);
        KDTextField kdtEntrys_cockMaterialModel_TextField = new KDTextField();
        kdtEntrys_cockMaterialModel_TextField.setName("kdtEntrys_cockMaterialModel_TextField");
        kdtEntrys_cockMaterialModel_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_cockMaterialModel_CellEditor = new KDTDefaultCellEditor(kdtEntrys_cockMaterialModel_TextField);
        this.kdtEntrys.getColumn("cockMaterialModel").setEditor(kdtEntrys_cockMaterialModel_CellEditor);
        KDFormattedTextField kdtEntrys_cockQty_TextField = new KDFormattedTextField();
        kdtEntrys_cockQty_TextField.setName("kdtEntrys_cockQty_TextField");
        kdtEntrys_cockQty_TextField.setVisible(true);
        kdtEntrys_cockQty_TextField.setEditable(true);
        kdtEntrys_cockQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_cockQty_TextField.setDataType(1);
        	kdtEntrys_cockQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_cockQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_cockQty_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_cockQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_cockQty_TextField);
        this.kdtEntrys.getColumn("cockQty").setEditor(kdtEntrys_cockQty_CellEditor);
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
        KDFormattedTextField kdtEntrys_cockAverageWeight_TextField = new KDFormattedTextField();
        kdtEntrys_cockAverageWeight_TextField.setName("kdtEntrys_cockAverageWeight_TextField");
        kdtEntrys_cockAverageWeight_TextField.setVisible(true);
        kdtEntrys_cockAverageWeight_TextField.setEditable(true);
        kdtEntrys_cockAverageWeight_TextField.setHorizontalAlignment(2);
        kdtEntrys_cockAverageWeight_TextField.setDataType(1);
        	kdtEntrys_cockAverageWeight_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_cockAverageWeight_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_cockAverageWeight_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_cockAverageWeight_CellEditor = new KDTDefaultCellEditor(kdtEntrys_cockAverageWeight_TextField);
        this.kdtEntrys.getColumn("cockAverageWeight").setEditor(kdtEntrys_cockAverageWeight_CellEditor);
        KDFormattedTextField kdtEntrys_uniformityCV_TextField = new KDFormattedTextField();
        kdtEntrys_uniformityCV_TextField.setName("kdtEntrys_uniformityCV_TextField");
        kdtEntrys_uniformityCV_TextField.setVisible(true);
        kdtEntrys_uniformityCV_TextField.setEditable(true);
        kdtEntrys_uniformityCV_TextField.setHorizontalAlignment(2);
        kdtEntrys_uniformityCV_TextField.setDataType(1);
        	kdtEntrys_uniformityCV_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_uniformityCV_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_uniformityCV_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_uniformityCV_CellEditor = new KDTDefaultCellEditor(kdtEntrys_uniformityCV_TextField);
        this.kdtEntrys.getColumn("uniformityCV").setEditor(kdtEntrys_uniformityCV_CellEditor);
        KDFormattedTextField kdtEntrys_uniformity_TextField = new KDFormattedTextField();
        kdtEntrys_uniformity_TextField.setName("kdtEntrys_uniformity_TextField");
        kdtEntrys_uniformity_TextField.setVisible(true);
        kdtEntrys_uniformity_TextField.setEditable(true);
        kdtEntrys_uniformity_TextField.setHorizontalAlignment(2);
        kdtEntrys_uniformity_TextField.setDataType(1);
        	kdtEntrys_uniformity_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E27"));
        	kdtEntrys_uniformity_TextField.setMaximumValue(new java.math.BigDecimal("1.0E27"));
        kdtEntrys_uniformity_TextField.setPrecision(1);
        KDTDefaultCellEditor kdtEntrys_uniformity_CellEditor = new KDTDefaultCellEditor(kdtEntrys_uniformity_TextField);
        this.kdtEntrys.getColumn("uniformity").setEditor(kdtEntrys_uniformity_CellEditor);
        // kdtEntryFieldEntrys
		String kdtEntryFieldEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"0\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"field\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"henQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"cockQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{field}</t:Cell><t:Cell>$Resource{henQty}</t:Cell><t:Cell>$Resource{cockQty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntryFieldEntrys.setFormatXml(resHelper.translateString("kdtEntryFieldEntrys",kdtEntryFieldEntrysStrXML));		
        this.kdtEntryFieldEntrys.setVisible(false);

                this.kdtEntryFieldEntrys.putBindContents("editData",new String[] {"EntryFieldEntrys.seq","EntryFieldEntrys.field","EntryFieldEntrys.henQty","EntryFieldEntrys.cockQty"});


        this.kdtEntryFieldEntrys.checkParsed();
        KDFormattedTextField kdtEntryFieldEntrys_seq_TextField = new KDFormattedTextField();
        kdtEntryFieldEntrys_seq_TextField.setName("kdtEntryFieldEntrys_seq_TextField");
        kdtEntryFieldEntrys_seq_TextField.setVisible(true);
        kdtEntryFieldEntrys_seq_TextField.setEditable(true);
        kdtEntryFieldEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtEntryFieldEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntryFieldEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtEntryFieldEntrys_seq_TextField);
        this.kdtEntryFieldEntrys.getColumn("seq").setEditor(kdtEntryFieldEntrys_seq_CellEditor);
        final KDBizPromptBox kdtEntryFieldEntrys_field_PromptBox = new KDBizPromptBox();
        kdtEntryFieldEntrys_field_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HouseFieldQuery");
        kdtEntryFieldEntrys_field_PromptBox.setVisible(true);
        kdtEntryFieldEntrys_field_PromptBox.setEditable(true);
        kdtEntryFieldEntrys_field_PromptBox.setDisplayFormat("$number$");
        kdtEntryFieldEntrys_field_PromptBox.setEditFormat("$number$");
        kdtEntryFieldEntrys_field_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntryFieldEntrys_field_CellEditor = new KDTDefaultCellEditor(kdtEntryFieldEntrys_field_PromptBox);
        this.kdtEntryFieldEntrys.getColumn("field").setEditor(kdtEntryFieldEntrys_field_CellEditor);
        ObjectValueRender kdtEntryFieldEntrys_field_OVR = new ObjectValueRender();
        kdtEntryFieldEntrys_field_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntryFieldEntrys.getColumn("field").setRenderer(kdtEntryFieldEntrys_field_OVR);
        KDFormattedTextField kdtEntryFieldEntrys_henQty_TextField = new KDFormattedTextField();
        kdtEntryFieldEntrys_henQty_TextField.setName("kdtEntryFieldEntrys_henQty_TextField");
        kdtEntryFieldEntrys_henQty_TextField.setVisible(true);
        kdtEntryFieldEntrys_henQty_TextField.setEditable(true);
        kdtEntryFieldEntrys_henQty_TextField.setHorizontalAlignment(2);
        kdtEntryFieldEntrys_henQty_TextField.setDataType(1);
        	kdtEntryFieldEntrys_henQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntryFieldEntrys_henQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntryFieldEntrys_henQty_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntryFieldEntrys_henQty_CellEditor = new KDTDefaultCellEditor(kdtEntryFieldEntrys_henQty_TextField);
        this.kdtEntryFieldEntrys.getColumn("henQty").setEditor(kdtEntryFieldEntrys_henQty_CellEditor);
        KDFormattedTextField kdtEntryFieldEntrys_cockQty_TextField = new KDFormattedTextField();
        kdtEntryFieldEntrys_cockQty_TextField.setName("kdtEntryFieldEntrys_cockQty_TextField");
        kdtEntryFieldEntrys_cockQty_TextField.setVisible(true);
        kdtEntryFieldEntrys_cockQty_TextField.setEditable(true);
        kdtEntryFieldEntrys_cockQty_TextField.setHorizontalAlignment(2);
        kdtEntryFieldEntrys_cockQty_TextField.setDataType(1);
        	kdtEntryFieldEntrys_cockQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntryFieldEntrys_cockQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntryFieldEntrys_cockQty_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntryFieldEntrys_cockQty_CellEditor = new KDTDefaultCellEditor(kdtEntryFieldEntrys_cockQty_TextField);
        this.kdtEntryFieldEntrys.getColumn("cockQty").setEditor(kdtEntryFieldEntrys_cockQty_CellEditor);
        // kDLabel3		
        this.kDLabel3.setText(resHelper.getString("kDLabel3.text"));		
        this.kDLabel3.setFont(resHelper.getFont("kDLabel3.font"));		
        this.kDLabel3.setEnabled(false);		
        this.kDLabel3.setVisible(false);
        // kdtLayEggEntrys
		String kdtLayEggEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"henhouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"henhouseName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"allEggs\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"eggWeight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"qualifiedEggs\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"freakEggs\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"doubleYolkEggs\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"brokenEggs\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"softegg\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"Primieggs\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"squalifiedEgg\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"DirtyEgg\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"doubleYolklv\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"qualifiedEgglv\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{henhouse}</t:Cell><t:Cell>$Resource{henhouseName}</t:Cell><t:Cell>$Resource{allEggs}</t:Cell><t:Cell>$Resource{eggWeight}</t:Cell><t:Cell>$Resource{qualifiedEggs}</t:Cell><t:Cell>$Resource{freakEggs}</t:Cell><t:Cell>$Resource{doubleYolkEggs}</t:Cell><t:Cell>$Resource{brokenEggs}</t:Cell><t:Cell>$Resource{softegg}</t:Cell><t:Cell>$Resource{Primieggs}</t:Cell><t:Cell>$Resource{squalifiedEgg}</t:Cell><t:Cell>$Resource{DirtyEgg}</t:Cell><t:Cell>$Resource{doubleYolklv}</t:Cell><t:Cell>$Resource{qualifiedEgglv}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtLayEggEntrys.setFormatXml(resHelper.translateString("kdtLayEggEntrys",kdtLayEggEntrysStrXML));
        kdtLayEggEntrys.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtLayEggEntrys_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtLayEggEntrys.putBindContents("editData",new String[] {"seq","henhouse","henhouseName","allEggs","eggWeight","qualifiedEggs","freakEggs","doubleYolkEggs","brokenEggs","softegg","Primieggs","squalifiedEgg","DirtyEgg","doubleYolklv","qualifiedEgglv"});


        this.kdtLayEggEntrys.checkParsed();
        KDFormattedTextField kdtLayEggEntrys_seq_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_seq_TextField.setName("kdtLayEggEntrys_seq_TextField");
        kdtLayEggEntrys_seq_TextField.setVisible(true);
        kdtLayEggEntrys_seq_TextField.setEditable(true);
        kdtLayEggEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtLayEggEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_seq_TextField);
        this.kdtLayEggEntrys.getColumn("seq").setEditor(kdtLayEggEntrys_seq_CellEditor);
        final KDBizPromptBox kdtLayEggEntrys_henhouse_PromptBox = new KDBizPromptBox();
        kdtLayEggEntrys_henhouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseF7Query");
        kdtLayEggEntrys_henhouse_PromptBox.setVisible(true);
        kdtLayEggEntrys_henhouse_PromptBox.setEditable(true);
        kdtLayEggEntrys_henhouse_PromptBox.setDisplayFormat("$number$");
        kdtLayEggEntrys_henhouse_PromptBox.setEditFormat("$number$");
        kdtLayEggEntrys_henhouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtLayEggEntrys_henhouse_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_henhouse_PromptBox);
        this.kdtLayEggEntrys.getColumn("henhouse").setEditor(kdtLayEggEntrys_henhouse_CellEditor);
        ObjectValueRender kdtLayEggEntrys_henhouse_OVR = new ObjectValueRender();
        kdtLayEggEntrys_henhouse_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtLayEggEntrys.getColumn("henhouse").setRenderer(kdtLayEggEntrys_henhouse_OVR);
        KDTextField kdtLayEggEntrys_henhouseName_TextField = new KDTextField();
        kdtLayEggEntrys_henhouseName_TextField.setName("kdtLayEggEntrys_henhouseName_TextField");
        kdtLayEggEntrys_henhouseName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtLayEggEntrys_henhouseName_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_henhouseName_TextField);
        this.kdtLayEggEntrys.getColumn("henhouseName").setEditor(kdtLayEggEntrys_henhouseName_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_allEggs_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_allEggs_TextField.setName("kdtLayEggEntrys_allEggs_TextField");
        kdtLayEggEntrys_allEggs_TextField.setVisible(true);
        kdtLayEggEntrys_allEggs_TextField.setEditable(true);
        kdtLayEggEntrys_allEggs_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_allEggs_TextField.setDataType(0);
        KDTDefaultCellEditor kdtLayEggEntrys_allEggs_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_allEggs_TextField);
        this.kdtLayEggEntrys.getColumn("allEggs").setEditor(kdtLayEggEntrys_allEggs_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_eggWeight_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_eggWeight_TextField.setName("kdtLayEggEntrys_eggWeight_TextField");
        kdtLayEggEntrys_eggWeight_TextField.setVisible(true);
        kdtLayEggEntrys_eggWeight_TextField.setEditable(true);
        kdtLayEggEntrys_eggWeight_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_eggWeight_TextField.setDataType(1);
        	kdtLayEggEntrys_eggWeight_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtLayEggEntrys_eggWeight_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtLayEggEntrys_eggWeight_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtLayEggEntrys_eggWeight_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_eggWeight_TextField);
        this.kdtLayEggEntrys.getColumn("eggWeight").setEditor(kdtLayEggEntrys_eggWeight_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_qualifiedEggs_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_qualifiedEggs_TextField.setName("kdtLayEggEntrys_qualifiedEggs_TextField");
        kdtLayEggEntrys_qualifiedEggs_TextField.setVisible(true);
        kdtLayEggEntrys_qualifiedEggs_TextField.setEditable(true);
        kdtLayEggEntrys_qualifiedEggs_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_qualifiedEggs_TextField.setDataType(0);
        KDTDefaultCellEditor kdtLayEggEntrys_qualifiedEggs_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_qualifiedEggs_TextField);
        this.kdtLayEggEntrys.getColumn("qualifiedEggs").setEditor(kdtLayEggEntrys_qualifiedEggs_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_freakEggs_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_freakEggs_TextField.setName("kdtLayEggEntrys_freakEggs_TextField");
        kdtLayEggEntrys_freakEggs_TextField.setVisible(true);
        kdtLayEggEntrys_freakEggs_TextField.setEditable(true);
        kdtLayEggEntrys_freakEggs_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_freakEggs_TextField.setDataType(0);
        KDTDefaultCellEditor kdtLayEggEntrys_freakEggs_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_freakEggs_TextField);
        this.kdtLayEggEntrys.getColumn("freakEggs").setEditor(kdtLayEggEntrys_freakEggs_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_doubleYolkEggs_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_doubleYolkEggs_TextField.setName("kdtLayEggEntrys_doubleYolkEggs_TextField");
        kdtLayEggEntrys_doubleYolkEggs_TextField.setVisible(true);
        kdtLayEggEntrys_doubleYolkEggs_TextField.setEditable(true);
        kdtLayEggEntrys_doubleYolkEggs_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_doubleYolkEggs_TextField.setDataType(0);
        KDTDefaultCellEditor kdtLayEggEntrys_doubleYolkEggs_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_doubleYolkEggs_TextField);
        this.kdtLayEggEntrys.getColumn("doubleYolkEggs").setEditor(kdtLayEggEntrys_doubleYolkEggs_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_brokenEggs_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_brokenEggs_TextField.setName("kdtLayEggEntrys_brokenEggs_TextField");
        kdtLayEggEntrys_brokenEggs_TextField.setVisible(true);
        kdtLayEggEntrys_brokenEggs_TextField.setEditable(true);
        kdtLayEggEntrys_brokenEggs_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_brokenEggs_TextField.setDataType(0);
        KDTDefaultCellEditor kdtLayEggEntrys_brokenEggs_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_brokenEggs_TextField);
        this.kdtLayEggEntrys.getColumn("brokenEggs").setEditor(kdtLayEggEntrys_brokenEggs_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_softegg_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_softegg_TextField.setName("kdtLayEggEntrys_softegg_TextField");
        kdtLayEggEntrys_softegg_TextField.setVisible(true);
        kdtLayEggEntrys_softegg_TextField.setEditable(true);
        kdtLayEggEntrys_softegg_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_softegg_TextField.setDataType(0);
        KDTDefaultCellEditor kdtLayEggEntrys_softegg_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_softegg_TextField);
        this.kdtLayEggEntrys.getColumn("softegg").setEditor(kdtLayEggEntrys_softegg_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_Primieggs_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_Primieggs_TextField.setName("kdtLayEggEntrys_Primieggs_TextField");
        kdtLayEggEntrys_Primieggs_TextField.setVisible(true);
        kdtLayEggEntrys_Primieggs_TextField.setEditable(true);
        kdtLayEggEntrys_Primieggs_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_Primieggs_TextField.setDataType(0);
        KDTDefaultCellEditor kdtLayEggEntrys_Primieggs_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_Primieggs_TextField);
        this.kdtLayEggEntrys.getColumn("Primieggs").setEditor(kdtLayEggEntrys_Primieggs_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_squalifiedEgg_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_squalifiedEgg_TextField.setName("kdtLayEggEntrys_squalifiedEgg_TextField");
        kdtLayEggEntrys_squalifiedEgg_TextField.setVisible(true);
        kdtLayEggEntrys_squalifiedEgg_TextField.setEditable(true);
        kdtLayEggEntrys_squalifiedEgg_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_squalifiedEgg_TextField.setDataType(0);
        KDTDefaultCellEditor kdtLayEggEntrys_squalifiedEgg_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_squalifiedEgg_TextField);
        this.kdtLayEggEntrys.getColumn("squalifiedEgg").setEditor(kdtLayEggEntrys_squalifiedEgg_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_DirtyEgg_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_DirtyEgg_TextField.setName("kdtLayEggEntrys_DirtyEgg_TextField");
        kdtLayEggEntrys_DirtyEgg_TextField.setVisible(true);
        kdtLayEggEntrys_DirtyEgg_TextField.setEditable(true);
        kdtLayEggEntrys_DirtyEgg_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_DirtyEgg_TextField.setDataType(0);
        KDTDefaultCellEditor kdtLayEggEntrys_DirtyEgg_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_DirtyEgg_TextField);
        this.kdtLayEggEntrys.getColumn("DirtyEgg").setEditor(kdtLayEggEntrys_DirtyEgg_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_doubleYolklv_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_doubleYolklv_TextField.setName("kdtLayEggEntrys_doubleYolklv_TextField");
        kdtLayEggEntrys_doubleYolklv_TextField.setVisible(true);
        kdtLayEggEntrys_doubleYolklv_TextField.setEditable(true);
        kdtLayEggEntrys_doubleYolklv_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_doubleYolklv_TextField.setDataType(1);
        	kdtLayEggEntrys_doubleYolklv_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E24"));
        	kdtLayEggEntrys_doubleYolklv_TextField.setMaximumValue(new java.math.BigDecimal("1.0E24"));
        kdtLayEggEntrys_doubleYolklv_TextField.setPrecision(4);
        KDTDefaultCellEditor kdtLayEggEntrys_doubleYolklv_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_doubleYolklv_TextField);
        this.kdtLayEggEntrys.getColumn("doubleYolklv").setEditor(kdtLayEggEntrys_doubleYolklv_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_qualifiedEgglv_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_qualifiedEgglv_TextField.setName("kdtLayEggEntrys_qualifiedEgglv_TextField");
        kdtLayEggEntrys_qualifiedEgglv_TextField.setVisible(true);
        kdtLayEggEntrys_qualifiedEgglv_TextField.setEditable(true);
        kdtLayEggEntrys_qualifiedEgglv_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_qualifiedEgglv_TextField.setDataType(1);
        	kdtLayEggEntrys_qualifiedEgglv_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E24"));
        	kdtLayEggEntrys_qualifiedEgglv_TextField.setMaximumValue(new java.math.BigDecimal("1.0E24"));
        kdtLayEggEntrys_qualifiedEgglv_TextField.setPrecision(4);
        KDTDefaultCellEditor kdtLayEggEntrys_qualifiedEgglv_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_qualifiedEgglv_TextField);
        this.kdtLayEggEntrys.getColumn("qualifiedEgglv").setEditor(kdtLayEggEntrys_qualifiedEgglv_CellEditor);
        // kdtCullDeathEntrys
		String kdtCullDeathEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"henhouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"henhouseName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"henDeath\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"henCull\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"henBatchCull\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"henhouseBreekingStock\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"cockDeath\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"cockCull\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"cockBatchCull\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"cockBreekingStock\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{henhouse}</t:Cell><t:Cell>$Resource{henhouseName}</t:Cell><t:Cell>$Resource{henDeath}</t:Cell><t:Cell>$Resource{henCull}</t:Cell><t:Cell>$Resource{henBatchCull}</t:Cell><t:Cell>$Resource{henhouseBreekingStock}</t:Cell><t:Cell>$Resource{cockDeath}</t:Cell><t:Cell>$Resource{cockCull}</t:Cell><t:Cell>$Resource{cockBatchCull}</t:Cell><t:Cell>$Resource{cockBreekingStock}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtCullDeathEntrys.setFormatXml(resHelper.translateString("kdtCullDeathEntrys",kdtCullDeathEntrysStrXML));
        kdtCullDeathEntrys.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtCullDeathEntrys_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtCullDeathEntrys.putBindContents("editData",new String[] {"seq","henhouse","henhouseName","henDeath","henCull","henBatchCull","henhouseBreekingStock","cockDeath","cockCull","cockBatchCull","cockBreekingStock"});


        this.kdtCullDeathEntrys.checkParsed();
        KDFormattedTextField kdtCullDeathEntrys_seq_TextField = new KDFormattedTextField();
        kdtCullDeathEntrys_seq_TextField.setName("kdtCullDeathEntrys_seq_TextField");
        kdtCullDeathEntrys_seq_TextField.setVisible(true);
        kdtCullDeathEntrys_seq_TextField.setEditable(true);
        kdtCullDeathEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtCullDeathEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtCullDeathEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtCullDeathEntrys_seq_TextField);
        this.kdtCullDeathEntrys.getColumn("seq").setEditor(kdtCullDeathEntrys_seq_CellEditor);
        final KDBizPromptBox kdtCullDeathEntrys_henhouse_PromptBox = new KDBizPromptBox();
        kdtCullDeathEntrys_henhouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseF7Query");
        kdtCullDeathEntrys_henhouse_PromptBox.setVisible(true);
        kdtCullDeathEntrys_henhouse_PromptBox.setEditable(true);
        kdtCullDeathEntrys_henhouse_PromptBox.setDisplayFormat("$number$");
        kdtCullDeathEntrys_henhouse_PromptBox.setEditFormat("$number$");
        kdtCullDeathEntrys_henhouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtCullDeathEntrys_henhouse_CellEditor = new KDTDefaultCellEditor(kdtCullDeathEntrys_henhouse_PromptBox);
        this.kdtCullDeathEntrys.getColumn("henhouse").setEditor(kdtCullDeathEntrys_henhouse_CellEditor);
        ObjectValueRender kdtCullDeathEntrys_henhouse_OVR = new ObjectValueRender();
        kdtCullDeathEntrys_henhouse_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtCullDeathEntrys.getColumn("henhouse").setRenderer(kdtCullDeathEntrys_henhouse_OVR);
        KDTextField kdtCullDeathEntrys_henhouseName_TextField = new KDTextField();
        kdtCullDeathEntrys_henhouseName_TextField.setName("kdtCullDeathEntrys_henhouseName_TextField");
        kdtCullDeathEntrys_henhouseName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtCullDeathEntrys_henhouseName_CellEditor = new KDTDefaultCellEditor(kdtCullDeathEntrys_henhouseName_TextField);
        this.kdtCullDeathEntrys.getColumn("henhouseName").setEditor(kdtCullDeathEntrys_henhouseName_CellEditor);
        KDFormattedTextField kdtCullDeathEntrys_henDeath_TextField = new KDFormattedTextField();
        kdtCullDeathEntrys_henDeath_TextField.setName("kdtCullDeathEntrys_henDeath_TextField");
        kdtCullDeathEntrys_henDeath_TextField.setVisible(true);
        kdtCullDeathEntrys_henDeath_TextField.setEditable(true);
        kdtCullDeathEntrys_henDeath_TextField.setHorizontalAlignment(2);
        kdtCullDeathEntrys_henDeath_TextField.setDataType(0);
        KDTDefaultCellEditor kdtCullDeathEntrys_henDeath_CellEditor = new KDTDefaultCellEditor(kdtCullDeathEntrys_henDeath_TextField);
        this.kdtCullDeathEntrys.getColumn("henDeath").setEditor(kdtCullDeathEntrys_henDeath_CellEditor);
        KDFormattedTextField kdtCullDeathEntrys_henCull_TextField = new KDFormattedTextField();
        kdtCullDeathEntrys_henCull_TextField.setName("kdtCullDeathEntrys_henCull_TextField");
        kdtCullDeathEntrys_henCull_TextField.setVisible(true);
        kdtCullDeathEntrys_henCull_TextField.setEditable(true);
        kdtCullDeathEntrys_henCull_TextField.setHorizontalAlignment(2);
        kdtCullDeathEntrys_henCull_TextField.setDataType(0);
        KDTDefaultCellEditor kdtCullDeathEntrys_henCull_CellEditor = new KDTDefaultCellEditor(kdtCullDeathEntrys_henCull_TextField);
        this.kdtCullDeathEntrys.getColumn("henCull").setEditor(kdtCullDeathEntrys_henCull_CellEditor);
        KDFormattedTextField kdtCullDeathEntrys_henBatchCull_TextField = new KDFormattedTextField();
        kdtCullDeathEntrys_henBatchCull_TextField.setName("kdtCullDeathEntrys_henBatchCull_TextField");
        kdtCullDeathEntrys_henBatchCull_TextField.setVisible(true);
        kdtCullDeathEntrys_henBatchCull_TextField.setEditable(true);
        kdtCullDeathEntrys_henBatchCull_TextField.setHorizontalAlignment(2);
        kdtCullDeathEntrys_henBatchCull_TextField.setDataType(0);
        KDTDefaultCellEditor kdtCullDeathEntrys_henBatchCull_CellEditor = new KDTDefaultCellEditor(kdtCullDeathEntrys_henBatchCull_TextField);
        this.kdtCullDeathEntrys.getColumn("henBatchCull").setEditor(kdtCullDeathEntrys_henBatchCull_CellEditor);
        KDFormattedTextField kdtCullDeathEntrys_henhouseBreekingStock_TextField = new KDFormattedTextField();
        kdtCullDeathEntrys_henhouseBreekingStock_TextField.setName("kdtCullDeathEntrys_henhouseBreekingStock_TextField");
        kdtCullDeathEntrys_henhouseBreekingStock_TextField.setVisible(true);
        kdtCullDeathEntrys_henhouseBreekingStock_TextField.setEditable(true);
        kdtCullDeathEntrys_henhouseBreekingStock_TextField.setHorizontalAlignment(2);
        kdtCullDeathEntrys_henhouseBreekingStock_TextField.setDataType(0);
        KDTDefaultCellEditor kdtCullDeathEntrys_henhouseBreekingStock_CellEditor = new KDTDefaultCellEditor(kdtCullDeathEntrys_henhouseBreekingStock_TextField);
        this.kdtCullDeathEntrys.getColumn("henhouseBreekingStock").setEditor(kdtCullDeathEntrys_henhouseBreekingStock_CellEditor);
        KDFormattedTextField kdtCullDeathEntrys_cockDeath_TextField = new KDFormattedTextField();
        kdtCullDeathEntrys_cockDeath_TextField.setName("kdtCullDeathEntrys_cockDeath_TextField");
        kdtCullDeathEntrys_cockDeath_TextField.setVisible(true);
        kdtCullDeathEntrys_cockDeath_TextField.setEditable(true);
        kdtCullDeathEntrys_cockDeath_TextField.setHorizontalAlignment(2);
        kdtCullDeathEntrys_cockDeath_TextField.setDataType(0);
        KDTDefaultCellEditor kdtCullDeathEntrys_cockDeath_CellEditor = new KDTDefaultCellEditor(kdtCullDeathEntrys_cockDeath_TextField);
        this.kdtCullDeathEntrys.getColumn("cockDeath").setEditor(kdtCullDeathEntrys_cockDeath_CellEditor);
        KDFormattedTextField kdtCullDeathEntrys_cockCull_TextField = new KDFormattedTextField();
        kdtCullDeathEntrys_cockCull_TextField.setName("kdtCullDeathEntrys_cockCull_TextField");
        kdtCullDeathEntrys_cockCull_TextField.setVisible(true);
        kdtCullDeathEntrys_cockCull_TextField.setEditable(true);
        kdtCullDeathEntrys_cockCull_TextField.setHorizontalAlignment(2);
        kdtCullDeathEntrys_cockCull_TextField.setDataType(0);
        KDTDefaultCellEditor kdtCullDeathEntrys_cockCull_CellEditor = new KDTDefaultCellEditor(kdtCullDeathEntrys_cockCull_TextField);
        this.kdtCullDeathEntrys.getColumn("cockCull").setEditor(kdtCullDeathEntrys_cockCull_CellEditor);
        KDFormattedTextField kdtCullDeathEntrys_cockBatchCull_TextField = new KDFormattedTextField();
        kdtCullDeathEntrys_cockBatchCull_TextField.setName("kdtCullDeathEntrys_cockBatchCull_TextField");
        kdtCullDeathEntrys_cockBatchCull_TextField.setVisible(true);
        kdtCullDeathEntrys_cockBatchCull_TextField.setEditable(true);
        kdtCullDeathEntrys_cockBatchCull_TextField.setHorizontalAlignment(2);
        kdtCullDeathEntrys_cockBatchCull_TextField.setDataType(0);
        KDTDefaultCellEditor kdtCullDeathEntrys_cockBatchCull_CellEditor = new KDTDefaultCellEditor(kdtCullDeathEntrys_cockBatchCull_TextField);
        this.kdtCullDeathEntrys.getColumn("cockBatchCull").setEditor(kdtCullDeathEntrys_cockBatchCull_CellEditor);
        KDFormattedTextField kdtCullDeathEntrys_cockBreekingStock_TextField = new KDFormattedTextField();
        kdtCullDeathEntrys_cockBreekingStock_TextField.setName("kdtCullDeathEntrys_cockBreekingStock_TextField");
        kdtCullDeathEntrys_cockBreekingStock_TextField.setVisible(true);
        kdtCullDeathEntrys_cockBreekingStock_TextField.setEditable(true);
        kdtCullDeathEntrys_cockBreekingStock_TextField.setHorizontalAlignment(2);
        kdtCullDeathEntrys_cockBreekingStock_TextField.setDataType(0);
        KDTDefaultCellEditor kdtCullDeathEntrys_cockBreekingStock_CellEditor = new KDTDefaultCellEditor(kdtCullDeathEntrys_cockBreekingStock_TextField);
        this.kdtCullDeathEntrys.getColumn("cockBreekingStock").setEditor(kdtCullDeathEntrys_cockBreekingStock_CellEditor);
        // kdtAssEntrys
		String kdtAssEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"henhouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"henhouseName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"breedTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"lightingTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"temperatureTo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"temperatureFrom\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"humidityTo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"humidityFrom\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{henhouse}</t:Cell><t:Cell>$Resource{henhouseName}</t:Cell><t:Cell>$Resource{breedTime}</t:Cell><t:Cell>$Resource{lightingTime}</t:Cell><t:Cell>$Resource{temperatureTo}</t:Cell><t:Cell>$Resource{temperatureFrom}</t:Cell><t:Cell>$Resource{humidityTo}</t:Cell><t:Cell>$Resource{humidityFrom}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtAssEntrys.putBindContents("editData",new String[] {"id","henhouse","henhouseName","breedTime","lightingTime","temperatureTo","temperatureFrom","humidityTo","humidityFrom"});


        this.kdtAssEntrys.checkParsed();
        final KDBizPromptBox kdtAssEntrys_henhouse_PromptBox = new KDBizPromptBox();
        kdtAssEntrys_henhouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseF7Query");
        kdtAssEntrys_henhouse_PromptBox.setVisible(true);
        kdtAssEntrys_henhouse_PromptBox.setEditable(true);
        kdtAssEntrys_henhouse_PromptBox.setDisplayFormat("$number$");
        kdtAssEntrys_henhouse_PromptBox.setEditFormat("$number$");
        kdtAssEntrys_henhouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtAssEntrys_henhouse_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_henhouse_PromptBox);
        this.kdtAssEntrys.getColumn("henhouse").setEditor(kdtAssEntrys_henhouse_CellEditor);
        ObjectValueRender kdtAssEntrys_henhouse_OVR = new ObjectValueRender();
        kdtAssEntrys_henhouse_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtAssEntrys.getColumn("henhouse").setRenderer(kdtAssEntrys_henhouse_OVR);
        KDTextField kdtAssEntrys_henhouseName_TextField = new KDTextField();
        kdtAssEntrys_henhouseName_TextField.setName("kdtAssEntrys_henhouseName_TextField");
        kdtAssEntrys_henhouseName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtAssEntrys_henhouseName_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_henhouseName_TextField);
        this.kdtAssEntrys.getColumn("henhouseName").setEditor(kdtAssEntrys_henhouseName_CellEditor);
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
        // kdtImmuneEntrys
		String kdtImmuneEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"henhouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"henhouseName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"vaccineMaterial\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"vaccineUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"vaccineGetQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"vaccineUsedQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol6\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{henhouse}</t:Cell><t:Cell>$Resource{henhouseName}</t:Cell><t:Cell>$Resource{vaccineMaterial}</t:Cell><t:Cell>$Resource{vaccineUnit}</t:Cell><t:Cell>$Resource{vaccineGetQty}</t:Cell><t:Cell>$Resource{vaccineUsedQty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtImmuneEntrys.putBindContents("editData",new String[] {"seq","henhouse","henhouseName","vaccineMaterial","vaccineUnit","vaccineGetQty","vaccineUsedQty"});


        this.kdtImmuneEntrys.checkParsed();
        KDFormattedTextField kdtImmuneEntrys_seq_TextField = new KDFormattedTextField();
        kdtImmuneEntrys_seq_TextField.setName("kdtImmuneEntrys_seq_TextField");
        kdtImmuneEntrys_seq_TextField.setVisible(true);
        kdtImmuneEntrys_seq_TextField.setEditable(true);
        kdtImmuneEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtImmuneEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtImmuneEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_seq_TextField);
        this.kdtImmuneEntrys.getColumn("seq").setEditor(kdtImmuneEntrys_seq_CellEditor);
        final KDBizPromptBox kdtImmuneEntrys_henhouse_PromptBox = new KDBizPromptBox();
        kdtImmuneEntrys_henhouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseF7Query");
        kdtImmuneEntrys_henhouse_PromptBox.setVisible(true);
        kdtImmuneEntrys_henhouse_PromptBox.setEditable(true);
        kdtImmuneEntrys_henhouse_PromptBox.setDisplayFormat("$number$");
        kdtImmuneEntrys_henhouse_PromptBox.setEditFormat("$number$");
        kdtImmuneEntrys_henhouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtImmuneEntrys_henhouse_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_henhouse_PromptBox);
        this.kdtImmuneEntrys.getColumn("henhouse").setEditor(kdtImmuneEntrys_henhouse_CellEditor);
        ObjectValueRender kdtImmuneEntrys_henhouse_OVR = new ObjectValueRender();
        kdtImmuneEntrys_henhouse_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtImmuneEntrys.getColumn("henhouse").setRenderer(kdtImmuneEntrys_henhouse_OVR);
        KDTextField kdtImmuneEntrys_henhouseName_TextField = new KDTextField();
        kdtImmuneEntrys_henhouseName_TextField.setName("kdtImmuneEntrys_henhouseName_TextField");
        kdtImmuneEntrys_henhouseName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtImmuneEntrys_henhouseName_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_henhouseName_TextField);
        this.kdtImmuneEntrys.getColumn("henhouseName").setEditor(kdtImmuneEntrys_henhouseName_CellEditor);
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
        KDTextField kdtImmuneEntrys_vaccineUnit_TextField = new KDTextField();
        kdtImmuneEntrys_vaccineUnit_TextField.setName("kdtImmuneEntrys_vaccineUnit_TextField");
        kdtImmuneEntrys_vaccineUnit_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtImmuneEntrys_vaccineUnit_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_vaccineUnit_TextField);
        this.kdtImmuneEntrys.getColumn("vaccineUnit").setEditor(kdtImmuneEntrys_vaccineUnit_CellEditor);
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
        // kdtTransHenhouseEntrys
		String kdtTransHenhouseEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"isBuy\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"supplier\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"isFromOtherBatch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"fromBatch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"fromHenhouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"fromField\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"toHenhouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"toField\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"transHenQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"transCockQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"henAsFixedQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"cockAsFixedQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"asTransEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{isBuy}</t:Cell><t:Cell>$Resource{supplier}</t:Cell><t:Cell>$Resource{isFromOtherBatch}</t:Cell><t:Cell>$Resource{fromBatch}</t:Cell><t:Cell>$Resource{fromHenhouse}</t:Cell><t:Cell>$Resource{fromField}</t:Cell><t:Cell>$Resource{toHenhouse}</t:Cell><t:Cell>$Resource{toField}</t:Cell><t:Cell>$Resource{transHenQty}</t:Cell><t:Cell>$Resource{transCockQty}</t:Cell><t:Cell>$Resource{henAsFixedQty}</t:Cell><t:Cell>$Resource{cockAsFixedQty}</t:Cell><t:Cell>$Resource{asTransEggQty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtTransHenhouseEntrys.setFormatXml(resHelper.translateString("kdtTransHenhouseEntrys",kdtTransHenhouseEntrysStrXML));

                this.kdtTransHenhouseEntrys.putBindContents("editData",new String[] {"seq","isBuy","supplier","isFromOtherBatch","fromBatch","fromHenhouse","fromField","toHenhouse","toField","transHenQty","transCockQty","henAsFixedQty","cockAsFixedQty","asTransEggQty"});


        this.kdtTransHenhouseEntrys.checkParsed();
        KDFormattedTextField kdtTransHenhouseEntrys_seq_TextField = new KDFormattedTextField();
        kdtTransHenhouseEntrys_seq_TextField.setName("kdtTransHenhouseEntrys_seq_TextField");
        kdtTransHenhouseEntrys_seq_TextField.setVisible(true);
        kdtTransHenhouseEntrys_seq_TextField.setEditable(true);
        kdtTransHenhouseEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtTransHenhouseEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtTransHenhouseEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtTransHenhouseEntrys_seq_TextField);
        this.kdtTransHenhouseEntrys.getColumn("seq").setEditor(kdtTransHenhouseEntrys_seq_CellEditor);
        KDCheckBox kdtTransHenhouseEntrys_isBuy_CheckBox = new KDCheckBox();
        kdtTransHenhouseEntrys_isBuy_CheckBox.setName("kdtTransHenhouseEntrys_isBuy_CheckBox");
        KDTDefaultCellEditor kdtTransHenhouseEntrys_isBuy_CellEditor = new KDTDefaultCellEditor(kdtTransHenhouseEntrys_isBuy_CheckBox);
        this.kdtTransHenhouseEntrys.getColumn("isBuy").setEditor(kdtTransHenhouseEntrys_isBuy_CellEditor);
        final KDBizPromptBox kdtTransHenhouseEntrys_supplier_PromptBox = new KDBizPromptBox();
        kdtTransHenhouseEntrys_supplier_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.F7SupplierDefaultQuery");
        kdtTransHenhouseEntrys_supplier_PromptBox.setVisible(true);
        kdtTransHenhouseEntrys_supplier_PromptBox.setEditable(true);
        kdtTransHenhouseEntrys_supplier_PromptBox.setDisplayFormat("$number$");
        kdtTransHenhouseEntrys_supplier_PromptBox.setEditFormat("$number$");
        kdtTransHenhouseEntrys_supplier_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtTransHenhouseEntrys_supplier_CellEditor = new KDTDefaultCellEditor(kdtTransHenhouseEntrys_supplier_PromptBox);
        this.kdtTransHenhouseEntrys.getColumn("supplier").setEditor(kdtTransHenhouseEntrys_supplier_CellEditor);
        ObjectValueRender kdtTransHenhouseEntrys_supplier_OVR = new ObjectValueRender();
        kdtTransHenhouseEntrys_supplier_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtTransHenhouseEntrys.getColumn("supplier").setRenderer(kdtTransHenhouseEntrys_supplier_OVR);
        KDCheckBox kdtTransHenhouseEntrys_isFromOtherBatch_CheckBox = new KDCheckBox();
        kdtTransHenhouseEntrys_isFromOtherBatch_CheckBox.setName("kdtTransHenhouseEntrys_isFromOtherBatch_CheckBox");
        KDTDefaultCellEditor kdtTransHenhouseEntrys_isFromOtherBatch_CellEditor = new KDTDefaultCellEditor(kdtTransHenhouseEntrys_isFromOtherBatch_CheckBox);
        this.kdtTransHenhouseEntrys.getColumn("isFromOtherBatch").setEditor(kdtTransHenhouseEntrys_isFromOtherBatch_CellEditor);
        final KDBizPromptBox kdtTransHenhouseEntrys_fromBatch_PromptBox = new KDBizPromptBox();
        kdtTransHenhouseEntrys_fromBatch_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.ParentBreedBatchQuery");
        kdtTransHenhouseEntrys_fromBatch_PromptBox.setVisible(true);
        kdtTransHenhouseEntrys_fromBatch_PromptBox.setEditable(true);
        kdtTransHenhouseEntrys_fromBatch_PromptBox.setDisplayFormat("$number$");
        kdtTransHenhouseEntrys_fromBatch_PromptBox.setEditFormat("$number$");
        kdtTransHenhouseEntrys_fromBatch_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtTransHenhouseEntrys_fromBatch_CellEditor = new KDTDefaultCellEditor(kdtTransHenhouseEntrys_fromBatch_PromptBox);
        this.kdtTransHenhouseEntrys.getColumn("fromBatch").setEditor(kdtTransHenhouseEntrys_fromBatch_CellEditor);
        ObjectValueRender kdtTransHenhouseEntrys_fromBatch_OVR = new ObjectValueRender();
        kdtTransHenhouseEntrys_fromBatch_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtTransHenhouseEntrys.getColumn("fromBatch").setRenderer(kdtTransHenhouseEntrys_fromBatch_OVR);
        final KDBizPromptBox kdtTransHenhouseEntrys_fromHenhouse_PromptBox = new KDBizPromptBox();
        kdtTransHenhouseEntrys_fromHenhouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseF7Query");
        kdtTransHenhouseEntrys_fromHenhouse_PromptBox.setVisible(true);
        kdtTransHenhouseEntrys_fromHenhouse_PromptBox.setEditable(true);
        kdtTransHenhouseEntrys_fromHenhouse_PromptBox.setDisplayFormat("$number$");
        kdtTransHenhouseEntrys_fromHenhouse_PromptBox.setEditFormat("$number$");
        kdtTransHenhouseEntrys_fromHenhouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtTransHenhouseEntrys_fromHenhouse_CellEditor = new KDTDefaultCellEditor(kdtTransHenhouseEntrys_fromHenhouse_PromptBox);
        this.kdtTransHenhouseEntrys.getColumn("fromHenhouse").setEditor(kdtTransHenhouseEntrys_fromHenhouse_CellEditor);
        ObjectValueRender kdtTransHenhouseEntrys_fromHenhouse_OVR = new ObjectValueRender();
        kdtTransHenhouseEntrys_fromHenhouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtTransHenhouseEntrys.getColumn("fromHenhouse").setRenderer(kdtTransHenhouseEntrys_fromHenhouse_OVR);
        final KDBizPromptBox kdtTransHenhouseEntrys_fromField_PromptBox = new KDBizPromptBox();
        kdtTransHenhouseEntrys_fromField_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HouseFieldQuery");
        kdtTransHenhouseEntrys_fromField_PromptBox.setVisible(true);
        kdtTransHenhouseEntrys_fromField_PromptBox.setEditable(true);
        kdtTransHenhouseEntrys_fromField_PromptBox.setDisplayFormat("$number$");
        kdtTransHenhouseEntrys_fromField_PromptBox.setEditFormat("$number$");
        kdtTransHenhouseEntrys_fromField_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtTransHenhouseEntrys_fromField_CellEditor = new KDTDefaultCellEditor(kdtTransHenhouseEntrys_fromField_PromptBox);
        this.kdtTransHenhouseEntrys.getColumn("fromField").setEditor(kdtTransHenhouseEntrys_fromField_CellEditor);
        ObjectValueRender kdtTransHenhouseEntrys_fromField_OVR = new ObjectValueRender();
        kdtTransHenhouseEntrys_fromField_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtTransHenhouseEntrys.getColumn("fromField").setRenderer(kdtTransHenhouseEntrys_fromField_OVR);
        final KDBizPromptBox kdtTransHenhouseEntrys_toHenhouse_PromptBox = new KDBizPromptBox();
        kdtTransHenhouseEntrys_toHenhouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseF7Query");
        kdtTransHenhouseEntrys_toHenhouse_PromptBox.setVisible(true);
        kdtTransHenhouseEntrys_toHenhouse_PromptBox.setEditable(true);
        kdtTransHenhouseEntrys_toHenhouse_PromptBox.setDisplayFormat("$number$");
        kdtTransHenhouseEntrys_toHenhouse_PromptBox.setEditFormat("$number$");
        kdtTransHenhouseEntrys_toHenhouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtTransHenhouseEntrys_toHenhouse_CellEditor = new KDTDefaultCellEditor(kdtTransHenhouseEntrys_toHenhouse_PromptBox);
        this.kdtTransHenhouseEntrys.getColumn("toHenhouse").setEditor(kdtTransHenhouseEntrys_toHenhouse_CellEditor);
        ObjectValueRender kdtTransHenhouseEntrys_toHenhouse_OVR = new ObjectValueRender();
        kdtTransHenhouseEntrys_toHenhouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtTransHenhouseEntrys.getColumn("toHenhouse").setRenderer(kdtTransHenhouseEntrys_toHenhouse_OVR);
        final KDBizPromptBox kdtTransHenhouseEntrys_toField_PromptBox = new KDBizPromptBox();
        kdtTransHenhouseEntrys_toField_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HouseFieldQuery");
        kdtTransHenhouseEntrys_toField_PromptBox.setVisible(true);
        kdtTransHenhouseEntrys_toField_PromptBox.setEditable(true);
        kdtTransHenhouseEntrys_toField_PromptBox.setDisplayFormat("$number$");
        kdtTransHenhouseEntrys_toField_PromptBox.setEditFormat("$number$");
        kdtTransHenhouseEntrys_toField_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtTransHenhouseEntrys_toField_CellEditor = new KDTDefaultCellEditor(kdtTransHenhouseEntrys_toField_PromptBox);
        this.kdtTransHenhouseEntrys.getColumn("toField").setEditor(kdtTransHenhouseEntrys_toField_CellEditor);
        ObjectValueRender kdtTransHenhouseEntrys_toField_OVR = new ObjectValueRender();
        kdtTransHenhouseEntrys_toField_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtTransHenhouseEntrys.getColumn("toField").setRenderer(kdtTransHenhouseEntrys_toField_OVR);
        KDFormattedTextField kdtTransHenhouseEntrys_transHenQty_TextField = new KDFormattedTextField();
        kdtTransHenhouseEntrys_transHenQty_TextField.setName("kdtTransHenhouseEntrys_transHenQty_TextField");
        kdtTransHenhouseEntrys_transHenQty_TextField.setVisible(true);
        kdtTransHenhouseEntrys_transHenQty_TextField.setEditable(true);
        kdtTransHenhouseEntrys_transHenQty_TextField.setHorizontalAlignment(2);
        kdtTransHenhouseEntrys_transHenQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtTransHenhouseEntrys_transHenQty_CellEditor = new KDTDefaultCellEditor(kdtTransHenhouseEntrys_transHenQty_TextField);
        this.kdtTransHenhouseEntrys.getColumn("transHenQty").setEditor(kdtTransHenhouseEntrys_transHenQty_CellEditor);
        KDFormattedTextField kdtTransHenhouseEntrys_transCockQty_TextField = new KDFormattedTextField();
        kdtTransHenhouseEntrys_transCockQty_TextField.setName("kdtTransHenhouseEntrys_transCockQty_TextField");
        kdtTransHenhouseEntrys_transCockQty_TextField.setVisible(true);
        kdtTransHenhouseEntrys_transCockQty_TextField.setEditable(true);
        kdtTransHenhouseEntrys_transCockQty_TextField.setHorizontalAlignment(2);
        kdtTransHenhouseEntrys_transCockQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtTransHenhouseEntrys_transCockQty_CellEditor = new KDTDefaultCellEditor(kdtTransHenhouseEntrys_transCockQty_TextField);
        this.kdtTransHenhouseEntrys.getColumn("transCockQty").setEditor(kdtTransHenhouseEntrys_transCockQty_CellEditor);
        KDFormattedTextField kdtTransHenhouseEntrys_henAsFixedQty_TextField = new KDFormattedTextField();
        kdtTransHenhouseEntrys_henAsFixedQty_TextField.setName("kdtTransHenhouseEntrys_henAsFixedQty_TextField");
        kdtTransHenhouseEntrys_henAsFixedQty_TextField.setVisible(true);
        kdtTransHenhouseEntrys_henAsFixedQty_TextField.setEditable(true);
        kdtTransHenhouseEntrys_henAsFixedQty_TextField.setHorizontalAlignment(2);
        kdtTransHenhouseEntrys_henAsFixedQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtTransHenhouseEntrys_henAsFixedQty_CellEditor = new KDTDefaultCellEditor(kdtTransHenhouseEntrys_henAsFixedQty_TextField);
        this.kdtTransHenhouseEntrys.getColumn("henAsFixedQty").setEditor(kdtTransHenhouseEntrys_henAsFixedQty_CellEditor);
        KDFormattedTextField kdtTransHenhouseEntrys_cockAsFixedQty_TextField = new KDFormattedTextField();
        kdtTransHenhouseEntrys_cockAsFixedQty_TextField.setName("kdtTransHenhouseEntrys_cockAsFixedQty_TextField");
        kdtTransHenhouseEntrys_cockAsFixedQty_TextField.setVisible(true);
        kdtTransHenhouseEntrys_cockAsFixedQty_TextField.setEditable(true);
        kdtTransHenhouseEntrys_cockAsFixedQty_TextField.setHorizontalAlignment(2);
        kdtTransHenhouseEntrys_cockAsFixedQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtTransHenhouseEntrys_cockAsFixedQty_CellEditor = new KDTDefaultCellEditor(kdtTransHenhouseEntrys_cockAsFixedQty_TextField);
        this.kdtTransHenhouseEntrys.getColumn("cockAsFixedQty").setEditor(kdtTransHenhouseEntrys_cockAsFixedQty_CellEditor);
        KDFormattedTextField kdtTransHenhouseEntrys_asTransEggQty_TextField = new KDFormattedTextField();
        kdtTransHenhouseEntrys_asTransEggQty_TextField.setName("kdtTransHenhouseEntrys_asTransEggQty_TextField");
        kdtTransHenhouseEntrys_asTransEggQty_TextField.setVisible(true);
        kdtTransHenhouseEntrys_asTransEggQty_TextField.setEditable(true);
        kdtTransHenhouseEntrys_asTransEggQty_TextField.setHorizontalAlignment(2);
        kdtTransHenhouseEntrys_asTransEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtTransHenhouseEntrys_asTransEggQty_CellEditor = new KDTDefaultCellEditor(kdtTransHenhouseEntrys_asTransEggQty_TextField);
        this.kdtTransHenhouseEntrys.getColumn("asTransEggQty").setEditor(kdtTransHenhouseEntrys_asTransEggQty_CellEditor);
        // kdtFodderEntrys
		String kdtFodderEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"fodderTower\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"fodderTowerName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"towerInventory\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"fodderMaterial\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"fodderMaterialName\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"fodderMaterialModel\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"fodderDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"fodderQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"fodderDesc\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{fodderTower}</t:Cell><t:Cell>$Resource{fodderTowerName}</t:Cell><t:Cell>$Resource{towerInventory}</t:Cell><t:Cell>$Resource{fodderMaterial}</t:Cell><t:Cell>$Resource{fodderMaterialName}</t:Cell><t:Cell>$Resource{fodderMaterialModel}</t:Cell><t:Cell>$Resource{fodderDate}</t:Cell><t:Cell>$Resource{fodderQty}</t:Cell><t:Cell>$Resource{fodderDesc}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtFodderEntrys.setFormatXml(resHelper.translateString("kdtFodderEntrys",kdtFodderEntrysStrXML));
        kdtFodderEntrys.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtFodderEntrys_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtFodderEntrys.putBindContents("editData",new String[] {"seq","fodderTower","fodderTowerName","towerInventory","fodderMaterial","fodderMaterialName","fodderMaterialModel","fodderDate","fodderQty","fodderDesc"});


        this.kdtFodderEntrys.checkParsed();
        KDFormattedTextField kdtFodderEntrys_seq_TextField = new KDFormattedTextField();
        kdtFodderEntrys_seq_TextField.setName("kdtFodderEntrys_seq_TextField");
        kdtFodderEntrys_seq_TextField.setVisible(true);
        kdtFodderEntrys_seq_TextField.setEditable(true);
        kdtFodderEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtFodderEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtFodderEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_seq_TextField);
        this.kdtFodderEntrys.getColumn("seq").setEditor(kdtFodderEntrys_seq_CellEditor);
        final KDBizPromptBox kdtFodderEntrys_fodderTower_PromptBox = new KDBizPromptBox();
        kdtFodderEntrys_fodderTower_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7AllWarehouseQuery");
        kdtFodderEntrys_fodderTower_PromptBox.setVisible(true);
        kdtFodderEntrys_fodderTower_PromptBox.setEditable(true);
        kdtFodderEntrys_fodderTower_PromptBox.setDisplayFormat("$number$");
        kdtFodderEntrys_fodderTower_PromptBox.setEditFormat("$number$");
        kdtFodderEntrys_fodderTower_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtFodderEntrys_fodderTower_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_fodderTower_PromptBox);
        this.kdtFodderEntrys.getColumn("fodderTower").setEditor(kdtFodderEntrys_fodderTower_CellEditor);
        ObjectValueRender kdtFodderEntrys_fodderTower_OVR = new ObjectValueRender();
        kdtFodderEntrys_fodderTower_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtFodderEntrys.getColumn("fodderTower").setRenderer(kdtFodderEntrys_fodderTower_OVR);
        KDTextField kdtFodderEntrys_fodderTowerName_TextField = new KDTextField();
        kdtFodderEntrys_fodderTowerName_TextField.setName("kdtFodderEntrys_fodderTowerName_TextField");
        kdtFodderEntrys_fodderTowerName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtFodderEntrys_fodderTowerName_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_fodderTowerName_TextField);
        this.kdtFodderEntrys.getColumn("fodderTowerName").setEditor(kdtFodderEntrys_fodderTowerName_CellEditor);
        KDFormattedTextField kdtFodderEntrys_towerInventory_TextField = new KDFormattedTextField();
        kdtFodderEntrys_towerInventory_TextField.setName("kdtFodderEntrys_towerInventory_TextField");
        kdtFodderEntrys_towerInventory_TextField.setVisible(true);
        kdtFodderEntrys_towerInventory_TextField.setEditable(true);
        kdtFodderEntrys_towerInventory_TextField.setHorizontalAlignment(2);
        kdtFodderEntrys_towerInventory_TextField.setDataType(1);
        	kdtFodderEntrys_towerInventory_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtFodderEntrys_towerInventory_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtFodderEntrys_towerInventory_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtFodderEntrys_towerInventory_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_towerInventory_TextField);
        this.kdtFodderEntrys.getColumn("towerInventory").setEditor(kdtFodderEntrys_towerInventory_CellEditor);
        final KDBizPromptBox kdtFodderEntrys_fodderMaterial_PromptBox = new KDBizPromptBox();
        kdtFodderEntrys_fodderMaterial_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtFodderEntrys_fodderMaterial_PromptBox.setVisible(true);
        kdtFodderEntrys_fodderMaterial_PromptBox.setEditable(true);
        kdtFodderEntrys_fodderMaterial_PromptBox.setDisplayFormat("$number$");
        kdtFodderEntrys_fodderMaterial_PromptBox.setEditFormat("$number$");
        kdtFodderEntrys_fodderMaterial_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtFodderEntrys_fodderMaterial_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_fodderMaterial_PromptBox);
        this.kdtFodderEntrys.getColumn("fodderMaterial").setEditor(kdtFodderEntrys_fodderMaterial_CellEditor);
        ObjectValueRender kdtFodderEntrys_fodderMaterial_OVR = new ObjectValueRender();
        kdtFodderEntrys_fodderMaterial_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtFodderEntrys.getColumn("fodderMaterial").setRenderer(kdtFodderEntrys_fodderMaterial_OVR);
        KDTextField kdtFodderEntrys_fodderMaterialName_TextField = new KDTextField();
        kdtFodderEntrys_fodderMaterialName_TextField.setName("kdtFodderEntrys_fodderMaterialName_TextField");
        kdtFodderEntrys_fodderMaterialName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtFodderEntrys_fodderMaterialName_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_fodderMaterialName_TextField);
        this.kdtFodderEntrys.getColumn("fodderMaterialName").setEditor(kdtFodderEntrys_fodderMaterialName_CellEditor);
        KDTextField kdtFodderEntrys_fodderMaterialModel_TextField = new KDTextField();
        kdtFodderEntrys_fodderMaterialModel_TextField.setName("kdtFodderEntrys_fodderMaterialModel_TextField");
        kdtFodderEntrys_fodderMaterialModel_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtFodderEntrys_fodderMaterialModel_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_fodderMaterialModel_TextField);
        this.kdtFodderEntrys.getColumn("fodderMaterialModel").setEditor(kdtFodderEntrys_fodderMaterialModel_CellEditor);
        KDDatePicker kdtFodderEntrys_fodderDate_DatePicker = new KDDatePicker();
        kdtFodderEntrys_fodderDate_DatePicker.setName("kdtFodderEntrys_fodderDate_DatePicker");
        kdtFodderEntrys_fodderDate_DatePicker.setVisible(true);
        kdtFodderEntrys_fodderDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtFodderEntrys_fodderDate_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_fodderDate_DatePicker);
        this.kdtFodderEntrys.getColumn("fodderDate").setEditor(kdtFodderEntrys_fodderDate_CellEditor);
        KDFormattedTextField kdtFodderEntrys_fodderQty_TextField = new KDFormattedTextField();
        kdtFodderEntrys_fodderQty_TextField.setName("kdtFodderEntrys_fodderQty_TextField");
        kdtFodderEntrys_fodderQty_TextField.setVisible(true);
        kdtFodderEntrys_fodderQty_TextField.setEditable(true);
        kdtFodderEntrys_fodderQty_TextField.setHorizontalAlignment(2);
        kdtFodderEntrys_fodderQty_TextField.setDataType(1);
        	kdtFodderEntrys_fodderQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtFodderEntrys_fodderQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtFodderEntrys_fodderQty_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtFodderEntrys_fodderQty_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_fodderQty_TextField);
        this.kdtFodderEntrys.getColumn("fodderQty").setEditor(kdtFodderEntrys_fodderQty_CellEditor);
        KDTextField kdtFodderEntrys_fodderDesc_TextField = new KDTextField();
        kdtFodderEntrys_fodderDesc_TextField.setName("kdtFodderEntrys_fodderDesc_TextField");
        kdtFodderEntrys_fodderDesc_TextField.setMaxLength(200);
        KDTDefaultCellEditor kdtFodderEntrys_fodderDesc_CellEditor = new KDTDefaultCellEditor(kdtFodderEntrys_fodderDesc_TextField);
        this.kdtFodderEntrys.getColumn("fodderDesc").setEditor(kdtFodderEntrys_fodderDesc_CellEditor);
        // contbreedLog		
        this.contbreedLog.setBoundLabelText(resHelper.getString("contbreedLog.boundLabelText"));		
        this.contbreedLog.setBoundLabelLength(0);		
        this.contbreedLog.setBoundLabelUnderline(true);		
        this.contbreedLog.setVisible(true);
        // scrollPanebreedLog
        // txtbreedLog		
        this.txtbreedLog.setRequired(false);		
        this.txtbreedLog.setMaxLength(2000);
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
        this.txtfuel.setVisible(false);		
        this.txtfuel.setEnabled(false);
        // txtelectricityQty		
        this.txtelectricityQty.setHorizontalAlignment(2);		
        this.txtelectricityQty.setDataType(1);		
        this.txtelectricityQty.setSupportedEmpty(true);		
        this.txtelectricityQty.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtelectricityQty.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtelectricityQty.setPrecision(2);		
        this.txtelectricityQty.setRequired(false);
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
        // txtqualifiedQty		
        this.txtqualifiedQty.setHorizontalAlignment(2);		
        this.txtqualifiedQty.setDataType(0);		
        this.txtqualifiedQty.setSupportedEmpty(true);		
        this.txtqualifiedQty.setRequired(false);		
        this.txtqualifiedQty.setVisible(false);
        // txtcommodityQty		
        this.txtcommodityQty.setHorizontalAlignment(2);		
        this.txtcommodityQty.setDataType(0);		
        this.txtcommodityQty.setSupportedEmpty(true);		
        this.txtcommodityQty.setRequired(false);		
        this.txtcommodityQty.setVisible(false);
        // txtdoubleYolkQty		
        this.txtdoubleYolkQty.setHorizontalAlignment(2);		
        this.txtdoubleYolkQty.setDataType(0);		
        this.txtdoubleYolkQty.setSupportedEmpty(true);		
        this.txtdoubleYolkQty.setRequired(false);		
        this.txtdoubleYolkQty.setEnabled(false);		
        this.txtdoubleYolkQty.setVisible(false);
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
        // prmtparentBatch		
        this.prmtparentBatch.setQueryInfo("com.kingdee.eas.farm.breed.app.ParentBreedBatchQuery");		
        this.prmtparentBatch.setEditable(true);		
        this.prmtparentBatch.setDisplayFormat("$number$");		
        this.prmtparentBatch.setEditFormat("$number$");		
        this.prmtparentBatch.setCommitFormat("$number$");		
        this.prmtparentBatch.setRequired(true);
        this.prmtparentBatch.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtparentBatch_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // prmtbroodCostObject		
        this.prmtbroodCostObject.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");		
        this.prmtbroodCostObject.setEditable(true);		
        this.prmtbroodCostObject.setDisplayFormat("$name$");		
        this.prmtbroodCostObject.setEditFormat("$number$");		
        this.prmtbroodCostObject.setCommitFormat("$number$");		
        this.prmtbroodCostObject.setRequired(false);		
        this.prmtbroodCostObject.setEnabled(false);
        // kdtConveyor
		String kdtConveyorStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"conveyorNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"henhouseDesc\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"qualifiedEggs\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"freakEggs\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"doubleYolkedEggs\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"brokenEggs\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"eggAverageWeight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"doubleYolkInventory\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"doubleYolkTransQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"freakInventory\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"freakTransQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"qualifyInventory\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"qulifiedTransQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{conveyorNumber}</t:Cell><t:Cell>$Resource{henhouseDesc}</t:Cell><t:Cell>$Resource{qualifiedEggs}</t:Cell><t:Cell>$Resource{freakEggs}</t:Cell><t:Cell>$Resource{doubleYolkedEggs}</t:Cell><t:Cell>$Resource{brokenEggs}</t:Cell><t:Cell>$Resource{eggAverageWeight}</t:Cell><t:Cell>$Resource{doubleYolkInventory}</t:Cell><t:Cell>$Resource{doubleYolkTransQty}</t:Cell><t:Cell>$Resource{freakInventory}</t:Cell><t:Cell>$Resource{freakTransQty}</t:Cell><t:Cell>$Resource{qualifyInventory}</t:Cell><t:Cell>$Resource{qulifiedTransQty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtConveyor.setFormatXml(resHelper.translateString("kdtConveyor",kdtConveyorStrXML));
        kdtConveyor.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtConveyor_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtConveyor.putBindContents("editData",new String[] {"seq","conveyorNumber","henhouseDesc","qualifiedEggs","freakEggs","doubleYolkedEggs","brokenEggs","eggAverageWeight","doubleYolkInventory","doubleYolkTransQty","freakInventory","freakTransQty","qualifyInventory","qulifiedTransQty"});


        this.kdtConveyor.checkParsed();
        KDFormattedTextField kdtConveyor_seq_TextField = new KDFormattedTextField();
        kdtConveyor_seq_TextField.setName("kdtConveyor_seq_TextField");
        kdtConveyor_seq_TextField.setVisible(true);
        kdtConveyor_seq_TextField.setEditable(true);
        kdtConveyor_seq_TextField.setHorizontalAlignment(2);
        kdtConveyor_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtConveyor_seq_CellEditor = new KDTDefaultCellEditor(kdtConveyor_seq_TextField);
        this.kdtConveyor.getColumn("seq").setEditor(kdtConveyor_seq_CellEditor);
        final KDBizPromptBox kdtConveyor_conveyorNumber_PromptBox = new KDBizPromptBox();
        kdtConveyor_conveyorNumber_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.layegg.app.EggConveyorQuery");
        kdtConveyor_conveyorNumber_PromptBox.setVisible(true);
        kdtConveyor_conveyorNumber_PromptBox.setEditable(true);
        kdtConveyor_conveyorNumber_PromptBox.setDisplayFormat("$number$");
        kdtConveyor_conveyorNumber_PromptBox.setEditFormat("$number$");
        kdtConveyor_conveyorNumber_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtConveyor_conveyorNumber_CellEditor = new KDTDefaultCellEditor(kdtConveyor_conveyorNumber_PromptBox);
        this.kdtConveyor.getColumn("conveyorNumber").setEditor(kdtConveyor_conveyorNumber_CellEditor);
        ObjectValueRender kdtConveyor_conveyorNumber_OVR = new ObjectValueRender();
        kdtConveyor_conveyorNumber_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtConveyor.getColumn("conveyorNumber").setRenderer(kdtConveyor_conveyorNumber_OVR);
        			kdtConveyor_conveyorNumber_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.breed.layegg.client.EggConveyorListUI kdtConveyor_conveyorNumber_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtConveyor_conveyorNumber_PromptBox_F7ListUI == null) {
					try {
						kdtConveyor_conveyorNumber_PromptBox_F7ListUI = new com.kingdee.eas.farm.breed.layegg.client.EggConveyorListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtConveyor_conveyorNumber_PromptBox_F7ListUI));
					kdtConveyor_conveyorNumber_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtConveyor_conveyorNumber_PromptBox.setSelector(kdtConveyor_conveyorNumber_PromptBox_F7ListUI);
				}
			}
		});
					
        KDTextField kdtConveyor_henhouseDesc_TextField = new KDTextField();
        kdtConveyor_henhouseDesc_TextField.setName("kdtConveyor_henhouseDesc_TextField");
        kdtConveyor_henhouseDesc_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtConveyor_henhouseDesc_CellEditor = new KDTDefaultCellEditor(kdtConveyor_henhouseDesc_TextField);
        this.kdtConveyor.getColumn("henhouseDesc").setEditor(kdtConveyor_henhouseDesc_CellEditor);
        KDFormattedTextField kdtConveyor_qualifiedEggs_TextField = new KDFormattedTextField();
        kdtConveyor_qualifiedEggs_TextField.setName("kdtConveyor_qualifiedEggs_TextField");
        kdtConveyor_qualifiedEggs_TextField.setVisible(true);
        kdtConveyor_qualifiedEggs_TextField.setEditable(true);
        kdtConveyor_qualifiedEggs_TextField.setHorizontalAlignment(2);
        kdtConveyor_qualifiedEggs_TextField.setDataType(0);
        KDTDefaultCellEditor kdtConveyor_qualifiedEggs_CellEditor = new KDTDefaultCellEditor(kdtConveyor_qualifiedEggs_TextField);
        this.kdtConveyor.getColumn("qualifiedEggs").setEditor(kdtConveyor_qualifiedEggs_CellEditor);
        KDFormattedTextField kdtConveyor_freakEggs_TextField = new KDFormattedTextField();
        kdtConveyor_freakEggs_TextField.setName("kdtConveyor_freakEggs_TextField");
        kdtConveyor_freakEggs_TextField.setVisible(true);
        kdtConveyor_freakEggs_TextField.setEditable(true);
        kdtConveyor_freakEggs_TextField.setHorizontalAlignment(2);
        kdtConveyor_freakEggs_TextField.setDataType(0);
        KDTDefaultCellEditor kdtConveyor_freakEggs_CellEditor = new KDTDefaultCellEditor(kdtConveyor_freakEggs_TextField);
        this.kdtConveyor.getColumn("freakEggs").setEditor(kdtConveyor_freakEggs_CellEditor);
        KDFormattedTextField kdtConveyor_doubleYolkedEggs_TextField = new KDFormattedTextField();
        kdtConveyor_doubleYolkedEggs_TextField.setName("kdtConveyor_doubleYolkedEggs_TextField");
        kdtConveyor_doubleYolkedEggs_TextField.setVisible(true);
        kdtConveyor_doubleYolkedEggs_TextField.setEditable(true);
        kdtConveyor_doubleYolkedEggs_TextField.setHorizontalAlignment(2);
        kdtConveyor_doubleYolkedEggs_TextField.setDataType(0);
        KDTDefaultCellEditor kdtConveyor_doubleYolkedEggs_CellEditor = new KDTDefaultCellEditor(kdtConveyor_doubleYolkedEggs_TextField);
        this.kdtConveyor.getColumn("doubleYolkedEggs").setEditor(kdtConveyor_doubleYolkedEggs_CellEditor);
        KDFormattedTextField kdtConveyor_brokenEggs_TextField = new KDFormattedTextField();
        kdtConveyor_brokenEggs_TextField.setName("kdtConveyor_brokenEggs_TextField");
        kdtConveyor_brokenEggs_TextField.setVisible(true);
        kdtConveyor_brokenEggs_TextField.setEditable(true);
        kdtConveyor_brokenEggs_TextField.setHorizontalAlignment(2);
        kdtConveyor_brokenEggs_TextField.setDataType(0);
        KDTDefaultCellEditor kdtConveyor_brokenEggs_CellEditor = new KDTDefaultCellEditor(kdtConveyor_brokenEggs_TextField);
        this.kdtConveyor.getColumn("brokenEggs").setEditor(kdtConveyor_brokenEggs_CellEditor);
        KDFormattedTextField kdtConveyor_eggAverageWeight_TextField = new KDFormattedTextField();
        kdtConveyor_eggAverageWeight_TextField.setName("kdtConveyor_eggAverageWeight_TextField");
        kdtConveyor_eggAverageWeight_TextField.setVisible(true);
        kdtConveyor_eggAverageWeight_TextField.setEditable(true);
        kdtConveyor_eggAverageWeight_TextField.setHorizontalAlignment(2);
        kdtConveyor_eggAverageWeight_TextField.setDataType(1);
        	kdtConveyor_eggAverageWeight_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtConveyor_eggAverageWeight_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtConveyor_eggAverageWeight_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtConveyor_eggAverageWeight_CellEditor = new KDTDefaultCellEditor(kdtConveyor_eggAverageWeight_TextField);
        this.kdtConveyor.getColumn("eggAverageWeight").setEditor(kdtConveyor_eggAverageWeight_CellEditor);
        KDFormattedTextField kdtConveyor_doubleYolkInventory_TextField = new KDFormattedTextField();
        kdtConveyor_doubleYolkInventory_TextField.setName("kdtConveyor_doubleYolkInventory_TextField");
        kdtConveyor_doubleYolkInventory_TextField.setVisible(true);
        kdtConveyor_doubleYolkInventory_TextField.setEditable(true);
        kdtConveyor_doubleYolkInventory_TextField.setHorizontalAlignment(2);
        kdtConveyor_doubleYolkInventory_TextField.setDataType(1);
        	kdtConveyor_doubleYolkInventory_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtConveyor_doubleYolkInventory_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtConveyor_doubleYolkInventory_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtConveyor_doubleYolkInventory_CellEditor = new KDTDefaultCellEditor(kdtConveyor_doubleYolkInventory_TextField);
        this.kdtConveyor.getColumn("doubleYolkInventory").setEditor(kdtConveyor_doubleYolkInventory_CellEditor);
        KDFormattedTextField kdtConveyor_doubleYolkTransQty_TextField = new KDFormattedTextField();
        kdtConveyor_doubleYolkTransQty_TextField.setName("kdtConveyor_doubleYolkTransQty_TextField");
        kdtConveyor_doubleYolkTransQty_TextField.setVisible(true);
        kdtConveyor_doubleYolkTransQty_TextField.setEditable(true);
        kdtConveyor_doubleYolkTransQty_TextField.setHorizontalAlignment(2);
        kdtConveyor_doubleYolkTransQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtConveyor_doubleYolkTransQty_CellEditor = new KDTDefaultCellEditor(kdtConveyor_doubleYolkTransQty_TextField);
        this.kdtConveyor.getColumn("doubleYolkTransQty").setEditor(kdtConveyor_doubleYolkTransQty_CellEditor);
        KDFormattedTextField kdtConveyor_freakInventory_TextField = new KDFormattedTextField();
        kdtConveyor_freakInventory_TextField.setName("kdtConveyor_freakInventory_TextField");
        kdtConveyor_freakInventory_TextField.setVisible(true);
        kdtConveyor_freakInventory_TextField.setEditable(true);
        kdtConveyor_freakInventory_TextField.setHorizontalAlignment(2);
        kdtConveyor_freakInventory_TextField.setDataType(1);
        	kdtConveyor_freakInventory_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtConveyor_freakInventory_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtConveyor_freakInventory_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtConveyor_freakInventory_CellEditor = new KDTDefaultCellEditor(kdtConveyor_freakInventory_TextField);
        this.kdtConveyor.getColumn("freakInventory").setEditor(kdtConveyor_freakInventory_CellEditor);
        KDFormattedTextField kdtConveyor_freakTransQty_TextField = new KDFormattedTextField();
        kdtConveyor_freakTransQty_TextField.setName("kdtConveyor_freakTransQty_TextField");
        kdtConveyor_freakTransQty_TextField.setVisible(true);
        kdtConveyor_freakTransQty_TextField.setEditable(true);
        kdtConveyor_freakTransQty_TextField.setHorizontalAlignment(2);
        kdtConveyor_freakTransQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtConveyor_freakTransQty_CellEditor = new KDTDefaultCellEditor(kdtConveyor_freakTransQty_TextField);
        this.kdtConveyor.getColumn("freakTransQty").setEditor(kdtConveyor_freakTransQty_CellEditor);
        KDFormattedTextField kdtConveyor_qualifyInventory_TextField = new KDFormattedTextField();
        kdtConveyor_qualifyInventory_TextField.setName("kdtConveyor_qualifyInventory_TextField");
        kdtConveyor_qualifyInventory_TextField.setVisible(true);
        kdtConveyor_qualifyInventory_TextField.setEditable(true);
        kdtConveyor_qualifyInventory_TextField.setHorizontalAlignment(2);
        kdtConveyor_qualifyInventory_TextField.setDataType(1);
        	kdtConveyor_qualifyInventory_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtConveyor_qualifyInventory_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtConveyor_qualifyInventory_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtConveyor_qualifyInventory_CellEditor = new KDTDefaultCellEditor(kdtConveyor_qualifyInventory_TextField);
        this.kdtConveyor.getColumn("qualifyInventory").setEditor(kdtConveyor_qualifyInventory_CellEditor);
        KDFormattedTextField kdtConveyor_qulifiedTransQty_TextField = new KDFormattedTextField();
        kdtConveyor_qulifiedTransQty_TextField.setName("kdtConveyor_qulifiedTransQty_TextField");
        kdtConveyor_qulifiedTransQty_TextField.setVisible(true);
        kdtConveyor_qulifiedTransQty_TextField.setEditable(true);
        kdtConveyor_qulifiedTransQty_TextField.setHorizontalAlignment(2);
        kdtConveyor_qulifiedTransQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtConveyor_qulifiedTransQty_CellEditor = new KDTDefaultCellEditor(kdtConveyor_qulifiedTransQty_TextField);
        this.kdtConveyor.getColumn("qulifiedTransQty").setEditor(kdtConveyor_qulifiedTransQty_CellEditor);
        // prmtfarm		
        this.prmtfarm.setQueryInfo("com.kingdee.eas.farm.breed.app.BreedStoorgSetQuery");		
        this.prmtfarm.setEditable(true);		
        this.prmtfarm.setDisplayFormat("$name$");		
        this.prmtfarm.setEditFormat("$number$");		
        this.prmtfarm.setCommitFormat("$number$");		
        this.prmtfarm.setRequired(false);		
        this.prmtfarm.setEnabled(false);
        // prmtstoOrg		
        this.prmtstoOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtstoOrg.setVisible(false);		
        this.prmtstoOrg.setEditable(true);		
        this.prmtstoOrg.setDisplayFormat("$name$");		
        this.prmtstoOrg.setEditFormat("$number$");		
        this.prmtstoOrg.setCommitFormat("$number$");		
        this.prmtstoOrg.setRequired(false);		
        this.prmtstoOrg.setEnabled(false);
        // prmtbabyCostObject		
        this.prmtbabyCostObject.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");		
        this.prmtbabyCostObject.setVisible(false);		
        this.prmtbabyCostObject.setEditable(true);		
        this.prmtbabyCostObject.setDisplayFormat("$name$");		
        this.prmtbabyCostObject.setEditFormat("$number$");		
        this.prmtbabyCostObject.setCommitFormat("$number$");		
        this.prmtbabyCostObject.setRequired(false);		
        this.prmtbabyCostObject.setEnabled(false);
        // prmteggCostObject		
        this.prmteggCostObject.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");		
        this.prmteggCostObject.setEditable(true);		
        this.prmteggCostObject.setDisplayFormat("$name$");		
        this.prmteggCostObject.setEditFormat("$number$");		
        this.prmteggCostObject.setCommitFormat("$number$");		
        this.prmteggCostObject.setRequired(false);		
        this.prmteggCostObject.setEnabled(false);
        // txtsumDay		
        this.txtsumDay.setHorizontalAlignment(2);		
        this.txtsumDay.setDataType(0);		
        this.txtsumDay.setSupportedEmpty(true);		
        this.txtsumDay.setRequired(false);		
        this.txtsumDay.setEnabled(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        // btnRefreshInventory
        this.btnRefreshInventory.setAction((IItemAction)ActionProxyFactory.getProxy(actionRefreshInventory, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnRefreshInventory.setText(resHelper.getString("btnRefreshInventory.text"));
        // btnGenNextBill
        this.btnGenNextBill.setAction((IItemAction)ActionProxyFactory.getProxy(actionGenNextBill, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnGenNextBill.setText(resHelper.getString("btnGenNextBill.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {pkBizDate,kdtEntryFieldEntrys,prmtparentBatch,chkisTransBrood,txtweek,txtweekDay,baseStatus,prmtbroodCostObject,kDDateLastUpdateTime,prmtLastUpdateUser,txtelectricityQty,txtqualifiedQty,txtcommodityQty,txtdoubleYolkQty,txtbreedLog,txtcoalFual,txtdieselFual,chkisFixed,chkhadFixed,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,txtNumber,txtoutSideTFrom,txtoutSideTTo,txtweather,txtoutHumidityFrom,txtoutHumidityTo,pkauditTime,txtfuel,prmtfarm,prmtstoOrg,prmtbabyCostObject,prmteggCostObject,chkhadBrood,txtsumDay,kdtAssEntrys,kdtEntrys,kdtConveyor,kdtLayEggEntrys,kdtCullDeathEntrys,kdtImmuneEntrys,kdtFodderEntrys,kdtTransHenhouseEntrys}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 659));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1013, 659));
        contCreator.setBounds(new Rectangle(18, 605, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(18, 605, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(18, 627, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(18, 627, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(374, 605, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(374, 605, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(374, 627, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(374, 627, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contNumber.setBounds(new Rectangle(12, 15, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(12, 15, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(724, 61, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(724, 61, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contDescription.setBounds(new Rectangle(724, 131, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(724, 131, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(730, 605, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(730, 605, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        paneBIZLayerControl17.setBounds(new Rectangle(15, 176, 993, 424));
        this.add(paneBIZLayerControl17, new KDLayout.Constraints(15, 176, 993, 424, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contbaseStatus.setBounds(new Rectangle(724, 38, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(724, 38, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contoutSideTFrom.setBounds(new Rectangle(12, 38, 270, 19));
        this.add(contoutSideTFrom, new KDLayout.Constraints(12, 38, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoutSideTTo.setBounds(new Rectangle(368, 38, 270, 19));
        this.add(contoutSideTTo, new KDLayout.Constraints(368, 38, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contweather.setBounds(new Rectangle(12, 84, 270, 19));
        this.add(contweather, new KDLayout.Constraints(12, 84, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoutHumidityFrom.setBounds(new Rectangle(12, 61, 270, 19));
        this.add(contoutHumidityFrom, new KDLayout.Constraints(12, 61, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoutHumidityTo.setBounds(new Rectangle(368, 61, 270, 19));
        this.add(contoutHumidityTo, new KDLayout.Constraints(368, 61, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(730, 627, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(730, 627, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfuel.setBounds(new Rectangle(678, -128, 270, 19));
        this.add(contfuel, new KDLayout.Constraints(678, -128, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contelectricityQty.setBounds(new Rectangle(724, 84, 270, 19));
        this.add(contelectricityQty, new KDLayout.Constraints(724, 84, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contweek.setBounds(new Rectangle(12, 107, 151, 19));
        this.add(contweek, new KDLayout.Constraints(12, 107, 151, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contweekDay.setBounds(new Rectangle(183, 107, 39, 19));
        this.add(contweekDay, new KDLayout.Constraints(183, 107, 39, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabel1.setBounds(new Rectangle(167, 107, 22, 19));
        this.add(kDLabel1, new KDLayout.Constraints(167, 107, 22, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabel2.setBounds(new Rectangle(229, 107, 28, 19));
        this.add(kDLabel2, new KDLayout.Constraints(229, 107, 28, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contqualifiedQty.setBounds(new Rectangle(655, -130, 270, 19));
        this.add(contqualifiedQty, new KDLayout.Constraints(655, -130, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcommodityQty.setBounds(new Rectangle(368, -129, 270, 19));
        this.add(contcommodityQty, new KDLayout.Constraints(368, -129, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdoubleYolkQty.setBounds(new Rectangle(724, -130, 270, 19));
        this.add(contdoubleYolkQty, new KDLayout.Constraints(724, -130, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcoalFual.setBounds(new Rectangle(368, 84, 270, 19));
        this.add(contcoalFual, new KDLayout.Constraints(368, 84, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdieselFual.setBounds(new Rectangle(724, 107, 270, 19));
        this.add(contdieselFual, new KDLayout.Constraints(724, 107, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkisFixed.setBounds(new Rectangle(444, 107, 77, 19));
        this.add(chkisFixed, new KDLayout.Constraints(444, 107, 77, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkhadFixed.setBounds(new Rectangle(587, 107, 51, 19));
        this.add(chkhadFixed, new KDLayout.Constraints(587, 107, 51, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contparentBatch.setBounds(new Rectangle(368, 15, 270, 19));
        this.add(contparentBatch, new KDLayout.Constraints(368, 15, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisTransBrood.setBounds(new Rectangle(368, 107, 79, 19));
        this.add(chkisTransBrood, new KDLayout.Constraints(368, 107, 79, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbroodCostObject.setBounds(new Rectangle(368, 131, 270, 19));
        this.add(contbroodCostObject, new KDLayout.Constraints(368, 131, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDContainer1.setBounds(new Rectangle(43, 649, 986, 56));
        this.add(kDContainer1, new KDLayout.Constraints(43, 649, 986, 56, 0));
        contfarm.setBounds(new Rectangle(724, 15, 270, 19));
        this.add(contfarm, new KDLayout.Constraints(724, 15, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contstoOrg.setBounds(new Rectangle(707, -20, 270, 19));
        this.add(contstoOrg, new KDLayout.Constraints(707, -20, 270, 19, 0));
        contbabyCostObject.setBounds(new Rectangle(323, 154, 270, 19));
        this.add(contbabyCostObject, new KDLayout.Constraints(323, 154, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conteggCostObject.setBounds(new Rectangle(12, 131, 270, 19));
        this.add(conteggCostObject, new KDLayout.Constraints(12, 131, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkhadBrood.setBounds(new Rectangle(526, 107, 52, 19));
        this.add(chkhadBrood, new KDLayout.Constraints(526, 107, 52, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsumDay.setBounds(new Rectangle(246, 104, 110, 19));
        this.add(contsumDay, new KDLayout.Constraints(246, 104, 110, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //paneBIZLayerControl17
        paneBIZLayerControl17.add(baseTab, resHelper.getString("baseTab.constraints"));
        paneBIZLayerControl17.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        paneBIZLayerControl17.add(kDPanel5, resHelper.getString("kDPanel5.constraints"));
        paneBIZLayerControl17.add(assTab, resHelper.getString("assTab.constraints"));
        paneBIZLayerControl17.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        paneBIZLayerControl17.add(kDPanel6, resHelper.getString("kDPanel6.constraints"));
        paneBIZLayerControl17.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        paneBIZLayerControl17.add(kDPanel4, resHelper.getString("kDPanel4.constraints"));
        //baseTab
        baseTab.setLayout(new KDLayout());
        baseTab.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 391));        kdtEntrys.setBounds(new Rectangle(1, 1, 988, 393));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.breed.layegg.LayEggDailyEntryInfo(),null,false);
        baseTab.add(kdtEntrys_detailPanel, new KDLayout.Constraints(1, 1, 988, 393, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntryFieldEntrys.setBounds(new Rectangle(-7313, -3333, 256, 360));
        kdtEntryFieldEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntryFieldEntrys,new com.kingdee.eas.farm.breed.layegg.LayEggDailyEntryEntryFieldEntryInfo(),null,false);
        baseTab.add(kdtEntryFieldEntrys_detailPanel, new KDLayout.Constraints(-7313, -3333, 256, 360, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabel3.setBounds(new Rectangle(-731, 6, 146, 25));
        baseTab.add(kDLabel3, new KDLayout.Constraints(-731, 6, 146, 25, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 391));        kdtLayEggEntrys.setBounds(new Rectangle(0, 1, 988, 394));
        kdtLayEggEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtLayEggEntrys,new com.kingdee.eas.farm.breed.layegg.LayEggDailyLayEggEntryInfo(),null,false);
        kDPanel2.add(kdtLayEggEntrys_detailPanel, new KDLayout.Constraints(0, 1, 988, 394, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel5
        kDPanel5.setLayout(new KDLayout());
        kDPanel5.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 391));        kdtCullDeathEntrys.setBounds(new Rectangle(0, 0, 987, 395));
        kdtCullDeathEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtCullDeathEntrys,new com.kingdee.eas.farm.breed.layegg.LayEggDailyCullDeathEntryInfo(),null,false);
        kDPanel5.add(kdtCullDeathEntrys_detailPanel, new KDLayout.Constraints(0, 0, 987, 395, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //assTab
        assTab.setLayout(new KDLayout());
        assTab.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 391));        kdtAssEntrys.setBounds(new Rectangle(2, -1, 986, 396));
        kdtAssEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtAssEntrys,new com.kingdee.eas.farm.breed.layegg.LayEggDailyAssEntryInfo(),null,false);
        assTab.add(kdtAssEntrys_detailPanel, new KDLayout.Constraints(2, -1, 986, 396, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 391));        kdtImmuneEntrys.setBounds(new Rectangle(-1, -1, 990, 398));
        kdtImmuneEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtImmuneEntrys,new com.kingdee.eas.farm.breed.layegg.LayEggDailyImmuneEntryInfo(),null,false);
        kDPanel1.add(kdtImmuneEntrys_detailPanel, new KDLayout.Constraints(-1, -1, 990, 398, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel6
        kDPanel6.setLayout(new KDLayout());
        kDPanel6.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 391));        kdtTransHenhouseEntrys.setBounds(new Rectangle(2, 1, 984, 394));
        kdtTransHenhouseEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtTransHenhouseEntrys,new com.kingdee.eas.farm.breed.layegg.LayEggDailyTransHenhouseEntryInfo(),null,false);
        kDPanel6.add(kdtTransHenhouseEntrys_detailPanel, new KDLayout.Constraints(2, 1, 984, 394, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel3
        kDPanel3.setLayout(new KDLayout());
        kDPanel3.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 391));        kdtFodderEntrys.setBounds(new Rectangle(0, 0, 987, 396));
        kdtFodderEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtFodderEntrys,new com.kingdee.eas.farm.breed.layegg.LayEggDailyFodderEntryInfo(),null,false);
        kDPanel3.add(kdtFodderEntrys_detailPanel, new KDLayout.Constraints(0, 0, 987, 396, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel4
        kDPanel4.setLayout(new KDLayout());
        kDPanel4.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 391));        contbreedLog.setBounds(new Rectangle(-1, 0, 983, 395));
        kDPanel4.add(contbreedLog, new KDLayout.Constraints(-1, 0, 983, 395, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contbreedLog
        contbreedLog.setBoundEditor(scrollPanebreedLog);
        //scrollPanebreedLog
        scrollPanebreedLog.getViewport().add(txtbreedLog, null);
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
        //contelectricityQty
        contelectricityQty.setBoundEditor(txtelectricityQty);
        //contweek
        contweek.setBoundEditor(txtweek);
        //contweekDay
        contweekDay.setBoundEditor(txtweekDay);
        //contqualifiedQty
        contqualifiedQty.setBoundEditor(txtqualifiedQty);
        //contcommodityQty
        contcommodityQty.setBoundEditor(txtcommodityQty);
        //contdoubleYolkQty
        contdoubleYolkQty.setBoundEditor(txtdoubleYolkQty);
        //contcoalFual
        contcoalFual.setBoundEditor(txtcoalFual);
        //contdieselFual
        contdieselFual.setBoundEditor(txtdieselFual);
        //contparentBatch
        contparentBatch.setBoundEditor(prmtparentBatch);
        //contbroodCostObject
        contbroodCostObject.setBoundEditor(prmtbroodCostObject);
        //kDContainer1
        kDContainer1.getContentPane().setLayout(new KDLayout());
        kDContainer1.getContentPane().putClientProperty("OriginalBounds", new Rectangle(43, 649, 986, 56));        kdtConveyor.setBounds(new Rectangle(-2, 0, 985, 133));
        kdtConveyor_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtConveyor,new com.kingdee.eas.farm.breed.layegg.LayEggDailyConveyorInfo(),null,false);
        kDContainer1.getContentPane().add(kdtConveyor_detailPanel, new KDLayout.Constraints(-2, 0, 985, 133, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contfarm
        contfarm.setBoundEditor(prmtfarm);
        //contstoOrg
        contstoOrg.setBoundEditor(prmtstoOrg);
        //contbabyCostObject
        contbabyCostObject.setBoundEditor(prmtbabyCostObject);
        //conteggCostObject
        conteggCostObject.setBoundEditor(prmteggCostObject);
        //contsumDay
        contsumDay.setBoundEditor(txtsumDay);

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
        menuBiz.add(MenuItemPCVoucher);
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
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);
        this.toolBar.add(btnCopy);
        this.toolBar.add(btnRefreshInventory);
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
        this.toolBar.add(btnPCVoucher);
        this.toolBar.add(btnVoucher);
        this.toolBar.add(btnDelPCVoucher);
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(btnNextPerson);
        this.toolBar.add(btnGenNextBill);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("isFixed", boolean.class, this.chkisFixed, "selected");
		dataBinder.registerBinding("hadFixed", boolean.class, this.chkhadFixed, "selected");
		dataBinder.registerBinding("isTransBrood", boolean.class, this.chkisTransBrood, "selected");
		dataBinder.registerBinding("hadBrood", boolean.class, this.chkhadBrood, "selected");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.breed.layegg.LayEggDailyEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.henhouse", java.lang.Object.class, this.kdtEntrys, "henhouse.text");
		dataBinder.registerBinding("entrys.henMaterial", java.lang.Object.class, this.kdtEntrys, "henMaterial.text");
		dataBinder.registerBinding("entrys.henMaterialName", String.class, this.kdtEntrys, "henMaterialName.text");
		dataBinder.registerBinding("entrys.henQty", java.math.BigDecimal.class, this.kdtEntrys, "henQty.text");
		dataBinder.registerBinding("entrys.cockMaterial", java.lang.Object.class, this.kdtEntrys, "cockMaterial.text");
		dataBinder.registerBinding("entrys.cockMaterialName", String.class, this.kdtEntrys, "cockMaterialName.text");
		dataBinder.registerBinding("entrys.cockQty", java.math.BigDecimal.class, this.kdtEntrys, "cockQty.text");
		dataBinder.registerBinding("entrys.waterQty", java.math.BigDecimal.class, this.kdtEntrys, "waterQty.text");
		dataBinder.registerBinding("entrys.henhouseName", String.class, this.kdtEntrys, "henhouseName.text");
		dataBinder.registerBinding("entrys.henAverageWeight", java.math.BigDecimal.class, this.kdtEntrys, "henAverageWeight.text");
		dataBinder.registerBinding("entrys.cockAverageWeight", java.math.BigDecimal.class, this.kdtEntrys, "cockAverageWeight.text");
		dataBinder.registerBinding("entrys.henMaterialModel", String.class, this.kdtEntrys, "henMaterialModel.text");
		dataBinder.registerBinding("entrys.cockMaterialModel", String.class, this.kdtEntrys, "cockMaterialModel.text");
		dataBinder.registerBinding("entrys.uniformityCV", java.math.BigDecimal.class, this.kdtEntrys, "uniformityCV.text");
		dataBinder.registerBinding("entrys.uniformity", java.math.BigDecimal.class, this.kdtEntrys, "uniformity.text");
		dataBinder.registerBinding("entrys.EntryFieldEntrys.seq", int.class, this.kdtEntryFieldEntrys, "seq.text");
		dataBinder.registerBinding("entrys.EntryFieldEntrys", com.kingdee.eas.farm.breed.layegg.LayEggDailyEntryEntryFieldEntryInfo.class, this.kdtEntryFieldEntrys, "userObject");
		dataBinder.registerBinding("entrys.EntryFieldEntrys.field", java.lang.Object.class, this.kdtEntryFieldEntrys, "field.text");
		dataBinder.registerBinding("entrys.EntryFieldEntrys.henQty", java.math.BigDecimal.class, this.kdtEntryFieldEntrys, "henQty.text");
		dataBinder.registerBinding("entrys.EntryFieldEntrys.cockQty", java.math.BigDecimal.class, this.kdtEntryFieldEntrys, "cockQty.text");
		dataBinder.registerBinding("LayEggEntrys.seq", int.class, this.kdtLayEggEntrys, "seq.text");
		dataBinder.registerBinding("LayEggEntrys", com.kingdee.eas.farm.breed.layegg.LayEggDailyLayEggEntryInfo.class, this.kdtLayEggEntrys, "userObject");
		dataBinder.registerBinding("LayEggEntrys.henhouse", java.lang.Object.class, this.kdtLayEggEntrys, "henhouse.text");
		dataBinder.registerBinding("LayEggEntrys.henhouseName", String.class, this.kdtLayEggEntrys, "henhouseName.text");
		dataBinder.registerBinding("LayEggEntrys.qualifiedEggs", int.class, this.kdtLayEggEntrys, "qualifiedEggs.text");
		dataBinder.registerBinding("LayEggEntrys.freakEggs", int.class, this.kdtLayEggEntrys, "freakEggs.text");
		dataBinder.registerBinding("LayEggEntrys.doubleYolkEggs", int.class, this.kdtLayEggEntrys, "doubleYolkEggs.text");
		dataBinder.registerBinding("LayEggEntrys.brokenEggs", int.class, this.kdtLayEggEntrys, "brokenEggs.text");
		dataBinder.registerBinding("LayEggEntrys.eggWeight", java.math.BigDecimal.class, this.kdtLayEggEntrys, "eggWeight.text");
		dataBinder.registerBinding("LayEggEntrys.allEggs", int.class, this.kdtLayEggEntrys, "allEggs.text");
		dataBinder.registerBinding("LayEggEntrys.softegg", int.class, this.kdtLayEggEntrys, "softegg.text");
		dataBinder.registerBinding("LayEggEntrys.doubleYolklv", java.math.BigDecimal.class, this.kdtLayEggEntrys, "doubleYolklv.text");
		dataBinder.registerBinding("LayEggEntrys.qualifiedEgglv", java.math.BigDecimal.class, this.kdtLayEggEntrys, "qualifiedEgglv.text");
		dataBinder.registerBinding("LayEggEntrys.Primieggs", int.class, this.kdtLayEggEntrys, "Primieggs.text");
		dataBinder.registerBinding("LayEggEntrys.squalifiedEgg", int.class, this.kdtLayEggEntrys, "squalifiedEgg.text");
		dataBinder.registerBinding("LayEggEntrys.DirtyEgg", int.class, this.kdtLayEggEntrys, "DirtyEgg.text");
		dataBinder.registerBinding("CullDeathEntrys.seq", int.class, this.kdtCullDeathEntrys, "seq.text");
		dataBinder.registerBinding("CullDeathEntrys", com.kingdee.eas.farm.breed.layegg.LayEggDailyCullDeathEntryInfo.class, this.kdtCullDeathEntrys, "userObject");
		dataBinder.registerBinding("CullDeathEntrys.henDeath", int.class, this.kdtCullDeathEntrys, "henDeath.text");
		dataBinder.registerBinding("CullDeathEntrys.henCull", int.class, this.kdtCullDeathEntrys, "henCull.text");
		dataBinder.registerBinding("CullDeathEntrys.cockDeath", int.class, this.kdtCullDeathEntrys, "cockDeath.text");
		dataBinder.registerBinding("CullDeathEntrys.cockCull", int.class, this.kdtCullDeathEntrys, "cockCull.text");
		dataBinder.registerBinding("CullDeathEntrys.cockBatchCull", int.class, this.kdtCullDeathEntrys, "cockBatchCull.text");
		dataBinder.registerBinding("CullDeathEntrys.henhouse", java.lang.Object.class, this.kdtCullDeathEntrys, "henhouse.text");
		dataBinder.registerBinding("CullDeathEntrys.henhouseName", String.class, this.kdtCullDeathEntrys, "henhouseName.text");
		dataBinder.registerBinding("CullDeathEntrys.henBatchCull", int.class, this.kdtCullDeathEntrys, "henBatchCull.text");
		dataBinder.registerBinding("CullDeathEntrys.henhouseBreekingStock", int.class, this.kdtCullDeathEntrys, "henhouseBreekingStock.text");
		dataBinder.registerBinding("CullDeathEntrys.cockBreekingStock", int.class, this.kdtCullDeathEntrys, "cockBreekingStock.text");
		dataBinder.registerBinding("AssEntrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtAssEntrys, "id.text");
		dataBinder.registerBinding("AssEntrys", com.kingdee.eas.farm.breed.layegg.LayEggDailyAssEntryInfo.class, this.kdtAssEntrys, "userObject");
		dataBinder.registerBinding("AssEntrys.breedTime", java.math.BigDecimal.class, this.kdtAssEntrys, "breedTime.text");
		dataBinder.registerBinding("AssEntrys.lightingTime", java.math.BigDecimal.class, this.kdtAssEntrys, "lightingTime.text");
		dataBinder.registerBinding("AssEntrys.temperatureTo", java.math.BigDecimal.class, this.kdtAssEntrys, "temperatureTo.text");
		dataBinder.registerBinding("AssEntrys.temperatureFrom", java.math.BigDecimal.class, this.kdtAssEntrys, "temperatureFrom.text");
		dataBinder.registerBinding("AssEntrys.humidityTo", java.math.BigDecimal.class, this.kdtAssEntrys, "humidityTo.text");
		dataBinder.registerBinding("AssEntrys.humidityFrom", java.math.BigDecimal.class, this.kdtAssEntrys, "humidityFrom.text");
		dataBinder.registerBinding("AssEntrys.henhouse", java.lang.Object.class, this.kdtAssEntrys, "henhouse.text");
		dataBinder.registerBinding("AssEntrys.henhouseName", String.class, this.kdtAssEntrys, "henhouseName.text");
		dataBinder.registerBinding("ImmuneEntrys.seq", int.class, this.kdtImmuneEntrys, "seq.text");
		dataBinder.registerBinding("ImmuneEntrys", com.kingdee.eas.farm.breed.layegg.LayEggDailyImmuneEntryInfo.class, this.kdtImmuneEntrys, "userObject");
		dataBinder.registerBinding("ImmuneEntrys.henhouse", java.lang.Object.class, this.kdtImmuneEntrys, "henhouse.text");
		dataBinder.registerBinding("ImmuneEntrys.henhouseName", String.class, this.kdtImmuneEntrys, "henhouseName.text");
		dataBinder.registerBinding("ImmuneEntrys.vaccineMaterial", java.lang.Object.class, this.kdtImmuneEntrys, "vaccineMaterial.text");
		dataBinder.registerBinding("ImmuneEntrys.vaccineGetQty", java.math.BigDecimal.class, this.kdtImmuneEntrys, "vaccineGetQty.text");
		dataBinder.registerBinding("ImmuneEntrys.vaccineUsedQty", java.math.BigDecimal.class, this.kdtImmuneEntrys, "vaccineUsedQty.text");
		dataBinder.registerBinding("ImmuneEntrys.vaccineUnit", String.class, this.kdtImmuneEntrys, "vaccineUnit.text");
		dataBinder.registerBinding("TransHenhouseEntrys.seq", int.class, this.kdtTransHenhouseEntrys, "seq.text");
		dataBinder.registerBinding("TransHenhouseEntrys", com.kingdee.eas.farm.breed.layegg.LayEggDailyTransHenhouseEntryInfo.class, this.kdtTransHenhouseEntrys, "userObject");
		dataBinder.registerBinding("TransHenhouseEntrys.isFromOtherBatch", boolean.class, this.kdtTransHenhouseEntrys, "isFromOtherBatch.text");
		dataBinder.registerBinding("TransHenhouseEntrys.fromHenhouse", java.lang.Object.class, this.kdtTransHenhouseEntrys, "fromHenhouse.text");
		dataBinder.registerBinding("TransHenhouseEntrys.toHenhouse", java.lang.Object.class, this.kdtTransHenhouseEntrys, "toHenhouse.text");
		dataBinder.registerBinding("TransHenhouseEntrys.transHenQty", int.class, this.kdtTransHenhouseEntrys, "transHenQty.text");
		dataBinder.registerBinding("TransHenhouseEntrys.transCockQty", int.class, this.kdtTransHenhouseEntrys, "transCockQty.text");
		dataBinder.registerBinding("TransHenhouseEntrys.asTransEggQty", int.class, this.kdtTransHenhouseEntrys, "asTransEggQty.text");
		dataBinder.registerBinding("TransHenhouseEntrys.isBuy", boolean.class, this.kdtTransHenhouseEntrys, "isBuy.text");
		dataBinder.registerBinding("TransHenhouseEntrys.supplier", java.lang.Object.class, this.kdtTransHenhouseEntrys, "supplier.text");
		dataBinder.registerBinding("TransHenhouseEntrys.fromField", java.lang.Object.class, this.kdtTransHenhouseEntrys, "fromField.text");
		dataBinder.registerBinding("TransHenhouseEntrys.toField", java.lang.Object.class, this.kdtTransHenhouseEntrys, "toField.text");
		dataBinder.registerBinding("TransHenhouseEntrys.fromBatch", java.lang.Object.class, this.kdtTransHenhouseEntrys, "fromBatch.text");
		dataBinder.registerBinding("TransHenhouseEntrys.henAsFixedQty", int.class, this.kdtTransHenhouseEntrys, "henAsFixedQty.text");
		dataBinder.registerBinding("TransHenhouseEntrys.cockAsFixedQty", int.class, this.kdtTransHenhouseEntrys, "cockAsFixedQty.text");
		dataBinder.registerBinding("FodderEntrys.seq", int.class, this.kdtFodderEntrys, "seq.text");
		dataBinder.registerBinding("FodderEntrys", com.kingdee.eas.farm.breed.layegg.LayEggDailyFodderEntryInfo.class, this.kdtFodderEntrys, "userObject");
		dataBinder.registerBinding("FodderEntrys.fodderTower", java.lang.Object.class, this.kdtFodderEntrys, "fodderTower.text");
		dataBinder.registerBinding("FodderEntrys.fodderMaterial", java.lang.Object.class, this.kdtFodderEntrys, "fodderMaterial.text");
		dataBinder.registerBinding("FodderEntrys.fodderMaterialName", String.class, this.kdtFodderEntrys, "fodderMaterialName.text");
		dataBinder.registerBinding("FodderEntrys.fodderMaterialModel", String.class, this.kdtFodderEntrys, "fodderMaterialModel.text");
		dataBinder.registerBinding("FodderEntrys.fodderDate", java.util.Date.class, this.kdtFodderEntrys, "fodderDate.text");
		dataBinder.registerBinding("FodderEntrys.fodderQty", java.math.BigDecimal.class, this.kdtFodderEntrys, "fodderQty.text");
		dataBinder.registerBinding("FodderEntrys.fodderDesc", String.class, this.kdtFodderEntrys, "fodderDesc.text");
		dataBinder.registerBinding("FodderEntrys.fodderTowerName", String.class, this.kdtFodderEntrys, "fodderTowerName.text");
		dataBinder.registerBinding("FodderEntrys.towerInventory", java.math.BigDecimal.class, this.kdtFodderEntrys, "towerInventory.text");
		dataBinder.registerBinding("breedLog", String.class, this.txtbreedLog, "text");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("outSideTFrom", java.math.BigDecimal.class, this.txtoutSideTFrom, "value");
		dataBinder.registerBinding("outSideTTo", java.math.BigDecimal.class, this.txtoutSideTTo, "value");
		dataBinder.registerBinding("weather", String.class, this.txtweather, "text");
		dataBinder.registerBinding("outHumidityFrom", java.math.BigDecimal.class, this.txtoutHumidityFrom, "value");
		dataBinder.registerBinding("outHumidityTo", java.math.BigDecimal.class, this.txtoutHumidityTo, "value");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("fuel", java.math.BigDecimal.class, this.txtfuel, "value");
		dataBinder.registerBinding("electricityQty", java.math.BigDecimal.class, this.txtelectricityQty, "value");
		dataBinder.registerBinding("week", int.class, this.txtweek, "value");
		dataBinder.registerBinding("weekDay", int.class, this.txtweekDay, "value");
		dataBinder.registerBinding("qualifiedQty", int.class, this.txtqualifiedQty, "value");
		dataBinder.registerBinding("commodityQty", int.class, this.txtcommodityQty, "value");
		dataBinder.registerBinding("doubleYolkQty", int.class, this.txtdoubleYolkQty, "value");
		dataBinder.registerBinding("coalFual", java.math.BigDecimal.class, this.txtcoalFual, "value");
		dataBinder.registerBinding("dieselFual", java.math.BigDecimal.class, this.txtdieselFual, "value");
		dataBinder.registerBinding("parentBatch", com.kingdee.eas.farm.breed.ParentBreedBatchInfo.class, this.prmtparentBatch, "data");
		dataBinder.registerBinding("broodCostObject", com.kingdee.eas.basedata.assistant.CostObjectInfo.class, this.prmtbroodCostObject, "data");
		dataBinder.registerBinding("Conveyor.seq", int.class, this.kdtConveyor, "seq.text");
		dataBinder.registerBinding("Conveyor", com.kingdee.eas.farm.breed.layegg.LayEggDailyConveyorInfo.class, this.kdtConveyor, "userObject");
		dataBinder.registerBinding("Conveyor.conveyorNumber", java.lang.Object.class, this.kdtConveyor, "conveyorNumber.text");
		dataBinder.registerBinding("Conveyor.henhouseDesc", String.class, this.kdtConveyor, "henhouseDesc.text");
		dataBinder.registerBinding("Conveyor.qualifiedEggs", int.class, this.kdtConveyor, "qualifiedEggs.text");
		dataBinder.registerBinding("Conveyor.freakEggs", int.class, this.kdtConveyor, "freakEggs.text");
		dataBinder.registerBinding("Conveyor.doubleYolkedEggs", int.class, this.kdtConveyor, "doubleYolkedEggs.text");
		dataBinder.registerBinding("Conveyor.brokenEggs", int.class, this.kdtConveyor, "brokenEggs.text");
		dataBinder.registerBinding("Conveyor.eggAverageWeight", java.math.BigDecimal.class, this.kdtConveyor, "eggAverageWeight.text");
		dataBinder.registerBinding("Conveyor.doubleYolkTransQty", int.class, this.kdtConveyor, "doubleYolkTransQty.text");
		dataBinder.registerBinding("Conveyor.freakTransQty", int.class, this.kdtConveyor, "freakTransQty.text");
		dataBinder.registerBinding("Conveyor.qulifiedTransQty", int.class, this.kdtConveyor, "qulifiedTransQty.text");
		dataBinder.registerBinding("Conveyor.doubleYolkInventory", java.math.BigDecimal.class, this.kdtConveyor, "doubleYolkInventory.text");
		dataBinder.registerBinding("Conveyor.freakInventory", java.math.BigDecimal.class, this.kdtConveyor, "freakInventory.text");
		dataBinder.registerBinding("Conveyor.qualifyInventory", java.math.BigDecimal.class, this.kdtConveyor, "qualifyInventory.text");
		dataBinder.registerBinding("farm", com.kingdee.eas.farm.breed.BreedStoorgSetInfo.class, this.prmtfarm, "data");
		dataBinder.registerBinding("stoOrg", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtstoOrg, "data");
		dataBinder.registerBinding("babyCostObject", com.kingdee.eas.basedata.assistant.CostObjectInfo.class, this.prmtbabyCostObject, "data");
		dataBinder.registerBinding("eggCostObject", com.kingdee.eas.basedata.assistant.CostObjectInfo.class, this.prmteggCostObject, "data");
		dataBinder.registerBinding("sumDay", int.class, this.txtsumDay, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.breed.layegg.app.LayEggDailyEditUIHandler";
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
        this.pkBizDate.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.breed.layegg.LayEggDailyInfo)ov;
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
	 * ????????��??
	 */
	protected void registerValidator() {
    	getValidateHelper().setCustomValidator( getValidator() );
		getValidateHelper().registerBindProperty("isFixed", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hadFixed", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isTransBrood", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hadBrood", ValidateHelper.ON_SAVE);    
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
		getValidateHelper().registerBindProperty("entrys.henhouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.henMaterial", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.henMaterialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.henQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.cockMaterial", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.cockMaterialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.cockQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.waterQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.henhouseName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.henAverageWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.cockAverageWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.henMaterialModel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.cockMaterialModel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.uniformityCV", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.uniformity", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.EntryFieldEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.EntryFieldEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.EntryFieldEntrys.field", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.EntryFieldEntrys.henQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.EntryFieldEntrys.cockQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.henhouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.henhouseName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.qualifiedEggs", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.freakEggs", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.doubleYolkEggs", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.brokenEggs", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.eggWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.allEggs", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.softegg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.doubleYolklv", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.qualifiedEgglv", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.Primieggs", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.squalifiedEgg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.DirtyEgg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CullDeathEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CullDeathEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CullDeathEntrys.henDeath", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CullDeathEntrys.henCull", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CullDeathEntrys.cockDeath", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CullDeathEntrys.cockCull", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CullDeathEntrys.cockBatchCull", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CullDeathEntrys.henhouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CullDeathEntrys.henhouseName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CullDeathEntrys.henBatchCull", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CullDeathEntrys.henhouseBreekingStock", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CullDeathEntrys.cockBreekingStock", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.breedTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.lightingTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.temperatureTo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.temperatureFrom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.humidityTo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.humidityFrom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.henhouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.henhouseName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.henhouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.henhouseName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.vaccineMaterial", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.vaccineGetQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.vaccineUsedQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.vaccineUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransHenhouseEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransHenhouseEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransHenhouseEntrys.isFromOtherBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransHenhouseEntrys.fromHenhouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransHenhouseEntrys.toHenhouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransHenhouseEntrys.transHenQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransHenhouseEntrys.transCockQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransHenhouseEntrys.asTransEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransHenhouseEntrys.isBuy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransHenhouseEntrys.supplier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransHenhouseEntrys.fromField", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransHenhouseEntrys.toField", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransHenhouseEntrys.fromBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransHenhouseEntrys.henAsFixedQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransHenhouseEntrys.cockAsFixedQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.fodderTower", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.fodderMaterial", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.fodderMaterialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.fodderMaterialModel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.fodderDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.fodderQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.fodderDesc", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.fodderTowerName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderEntrys.towerInventory", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedLog", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("outSideTFrom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("outSideTTo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("weather", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("outHumidityFrom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("outHumidityTo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fuel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("electricityQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("week", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("weekDay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("qualifiedQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("commodityQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("doubleYolkQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("coalFual", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dieselFual", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("parentBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("broodCostObject", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Conveyor.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Conveyor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Conveyor.conveyorNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Conveyor.henhouseDesc", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Conveyor.qualifiedEggs", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Conveyor.freakEggs", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Conveyor.doubleYolkedEggs", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Conveyor.brokenEggs", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Conveyor.eggAverageWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Conveyor.doubleYolkTransQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Conveyor.freakTransQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Conveyor.qulifiedTransQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Conveyor.doubleYolkInventory", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Conveyor.freakInventory", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Conveyor.qualifyInventory", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("stoOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("babyCostObject", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eggCostObject", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sumDay", ValidateHelper.ON_SAVE);    		
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
     * output chkisFixed_actionPerformed method
     */
    protected void chkisFixed_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output chkisTransBrood_actionPerformed method
     */
    protected void chkisTransBrood_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output prmtparentBatch_dataChanged method
     */
    protected void prmtparentBatch_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        //write your code here
    }


    /**
     * output kdtEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("henhouse".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"henhouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"henhouse").getValue(),"warehouse.name")));

}

    if ("henhouse".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"henhouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"henhouse").getValue(),"warehouse.name")));

}

    if ("henMaterial".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"henMaterialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"henMaterial").getValue(),"name")));

}

    if ("henMaterial".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"henMaterialModel").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"henMaterial").getValue(),"model")));

}

    if ("cockMaterial".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"cockMaterialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"cockMaterial").getValue(),"name")));

}

    if ("cockMaterial".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"cockMaterialModel").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"cockMaterial").getValue(),"model")));

}


    }

    /**
     * output kdtLayEggEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtLayEggEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("henhouse".equalsIgnoreCase(kdtLayEggEntrys.getColumn(colIndex).getKey())) {
kdtLayEggEntrys.getCell(rowIndex,"henhouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtLayEggEntrys.getCell(rowIndex,"henhouse").getValue(),"warehouse.name")));

}

    if ("henhouse".equalsIgnoreCase(kdtLayEggEntrys.getColumn(colIndex).getKey())) {
kdtLayEggEntrys.getCell(rowIndex,"henhouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtLayEggEntrys.getCell(rowIndex,"henhouse").getValue(),"warehouse.name")));

}

    if ("allEggs".equalsIgnoreCase(kdtLayEggEntrys.getColumn(colIndex).getKey())) {
kdtLayEggEntrys.getCell(rowIndex,"qualifiedEgglv").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtLayEggEntrys.getCell(rowIndex,"allEggs").getValue())/ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtCullDeathEntrys.getCell(rowIndex,"henhouseBreekingStock").getValue())));

}

    if ("qualifiedEggs".equalsIgnoreCase(kdtLayEggEntrys.getColumn(colIndex).getKey())) {
kdtLayEggEntrys.getCell(rowIndex,"allEggs").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtLayEggEntrys.getCell(rowIndex,"qualifiedEggs").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtLayEggEntrys.getCell(rowIndex,"freakEggs").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtLayEggEntrys.getCell(rowIndex,"doubleYolkEggs").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtLayEggEntrys.getCell(rowIndex,"brokenEggs").getValue())))));

}

    if ("freakEggs".equalsIgnoreCase(kdtLayEggEntrys.getColumn(colIndex).getKey())) {
kdtLayEggEntrys.getCell(rowIndex,"allEggs").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtLayEggEntrys.getCell(rowIndex,"qualifiedEggs").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtLayEggEntrys.getCell(rowIndex,"freakEggs").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtLayEggEntrys.getCell(rowIndex,"doubleYolkEggs").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtLayEggEntrys.getCell(rowIndex,"brokenEggs").getValue())))));

}

    if ("doubleYolkEggs".equalsIgnoreCase(kdtLayEggEntrys.getColumn(colIndex).getKey())) {
kdtLayEggEntrys.getCell(rowIndex,"allEggs").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtLayEggEntrys.getCell(rowIndex,"qualifiedEggs").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtLayEggEntrys.getCell(rowIndex,"freakEggs").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtLayEggEntrys.getCell(rowIndex,"doubleYolkEggs").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtLayEggEntrys.getCell(rowIndex,"brokenEggs").getValue())))));

}

    if ("brokenEggs".equalsIgnoreCase(kdtLayEggEntrys.getColumn(colIndex).getKey())) {
kdtLayEggEntrys.getCell(rowIndex,"allEggs").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtLayEggEntrys.getCell(rowIndex,"qualifiedEggs").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtLayEggEntrys.getCell(rowIndex,"freakEggs").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtLayEggEntrys.getCell(rowIndex,"doubleYolkEggs").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtLayEggEntrys.getCell(rowIndex,"brokenEggs").getValue())))));

}


    }

    /**
     * output kdtCullDeathEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtCullDeathEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("henhouse".equalsIgnoreCase(kdtCullDeathEntrys.getColumn(colIndex).getKey())) {
kdtCullDeathEntrys.getCell(rowIndex,"henhouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtCullDeathEntrys.getCell(rowIndex,"henhouse").getValue(),"warehouse.name")));

}

    if ("henhouse".equalsIgnoreCase(kdtCullDeathEntrys.getColumn(colIndex).getKey())) {
kdtCullDeathEntrys.getCell(rowIndex,"henhouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtCullDeathEntrys.getCell(rowIndex,"henhouse").getValue(),"warehouse.name")));

}


    }

    /**
     * output kdtAssEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtAssEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("henhouse".equalsIgnoreCase(kdtAssEntrys.getColumn(colIndex).getKey())) {
kdtAssEntrys.getCell(rowIndex,"henhouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtAssEntrys.getCell(rowIndex,"henhouse").getValue(),"warehouse.name")));

}

    if ("henhouse".equalsIgnoreCase(kdtAssEntrys.getColumn(colIndex).getKey())) {
kdtAssEntrys.getCell(rowIndex,"henhouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtAssEntrys.getCell(rowIndex,"henhouse").getValue(),"warehouse.name")));

}


    }

    /**
     * output kdtImmuneEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtImmuneEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("henhouse".equalsIgnoreCase(kdtImmuneEntrys.getColumn(colIndex).getKey())) {
kdtImmuneEntrys.getCell(rowIndex,"henhouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtImmuneEntrys.getCell(rowIndex,"henhouse").getValue(),"name")));

}

    if ("vaccineMaterial".equalsIgnoreCase(kdtImmuneEntrys.getColumn(colIndex).getKey())) {
kdtImmuneEntrys.getCell(rowIndex,"vaccineUnit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtImmuneEntrys.getCell(rowIndex,"vaccineMaterial").getValue(),"baseUnit.name")));

}


    }

    /**
     * output kdtFodderEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtFodderEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("fodderTower".equalsIgnoreCase(kdtFodderEntrys.getColumn(colIndex).getKey())) {
kdtFodderEntrys.getCell(rowIndex,"fodderTowerName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtFodderEntrys.getCell(rowIndex,"fodderTower").getValue(),"name")));

}

    if ("fodderMaterial".equalsIgnoreCase(kdtFodderEntrys.getColumn(colIndex).getKey())) {
kdtFodderEntrys.getCell(rowIndex,"fodderMaterialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtFodderEntrys.getCell(rowIndex,"fodderMaterial").getValue(),"name")));

}

    if ("fodderMaterial".equalsIgnoreCase(kdtFodderEntrys.getColumn(colIndex).getKey())) {
kdtFodderEntrys.getCell(rowIndex,"fodderMaterialModel").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtFodderEntrys.getCell(rowIndex,"fodderMaterial").getValue(),"model")));

}


    }

    /**
     * output kdtConveyor_Changed(int rowIndex,int colIndex) method
     */
    public void kdtConveyor_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("conveyorNumber".equalsIgnoreCase(kdtConveyor.getColumn(colIndex).getKey())) {
kdtConveyor.getCell(rowIndex,"henhouseDesc").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtConveyor.getCell(rowIndex,"conveyorNumber").getValue(),"henhouseDesc")));

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
        sic.add(new SelectorItemInfo("isFixed"));
        sic.add(new SelectorItemInfo("hadFixed"));
        sic.add(new SelectorItemInfo("isTransBrood"));
        sic.add(new SelectorItemInfo("hadBrood"));
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
			sic.add(new SelectorItemInfo("entrys.henhouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.henhouse.id"));
			sic.add(new SelectorItemInfo("entrys.henhouse.number"));
			sic.add(new SelectorItemInfo("entrys.henhouse.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.henMaterial.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.henMaterial.id"));
			sic.add(new SelectorItemInfo("entrys.henMaterial.number"));
			sic.add(new SelectorItemInfo("entrys.henMaterial.name"));
		}
    	sic.add(new SelectorItemInfo("entrys.henMaterialName"));
    	sic.add(new SelectorItemInfo("entrys.henQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.cockMaterial.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.cockMaterial.id"));
			sic.add(new SelectorItemInfo("entrys.cockMaterial.number"));
			sic.add(new SelectorItemInfo("entrys.cockMaterial.name"));
		}
    	sic.add(new SelectorItemInfo("entrys.cockMaterialName"));
    	sic.add(new SelectorItemInfo("entrys.cockQty"));
    	sic.add(new SelectorItemInfo("entrys.waterQty"));
    	sic.add(new SelectorItemInfo("entrys.henhouseName"));
    	sic.add(new SelectorItemInfo("entrys.henAverageWeight"));
    	sic.add(new SelectorItemInfo("entrys.cockAverageWeight"));
    	sic.add(new SelectorItemInfo("entrys.henMaterialModel"));
    	sic.add(new SelectorItemInfo("entrys.cockMaterialModel"));
    	sic.add(new SelectorItemInfo("entrys.uniformityCV"));
    	sic.add(new SelectorItemInfo("entrys.uniformity"));
    	sic.add(new SelectorItemInfo("entrys.EntryFieldEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.EntryFieldEntrys.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.EntryFieldEntrys.id"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.EntryFieldEntrys.field.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.EntryFieldEntrys.field.id"));
			sic.add(new SelectorItemInfo("entrys.EntryFieldEntrys.field.name"));
        	sic.add(new SelectorItemInfo("entrys.EntryFieldEntrys.field.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.EntryFieldEntrys.henQty"));
    	sic.add(new SelectorItemInfo("entrys.EntryFieldEntrys.cockQty"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("LayEggEntrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("LayEggEntrys.henhouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("LayEggEntrys.henhouse.id"));
			sic.add(new SelectorItemInfo("LayEggEntrys.henhouse.number"));
			sic.add(new SelectorItemInfo("LayEggEntrys.henhouse.name"));
		}
    	sic.add(new SelectorItemInfo("LayEggEntrys.henhouseName"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.qualifiedEggs"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.freakEggs"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.doubleYolkEggs"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.brokenEggs"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.eggWeight"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.allEggs"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.softegg"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.doubleYolklv"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.qualifiedEgglv"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.Primieggs"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.squalifiedEgg"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.DirtyEgg"));
    	sic.add(new SelectorItemInfo("CullDeathEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("CullDeathEntrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("CullDeathEntrys.henDeath"));
    	sic.add(new SelectorItemInfo("CullDeathEntrys.henCull"));
    	sic.add(new SelectorItemInfo("CullDeathEntrys.cockDeath"));
    	sic.add(new SelectorItemInfo("CullDeathEntrys.cockCull"));
    	sic.add(new SelectorItemInfo("CullDeathEntrys.cockBatchCull"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("CullDeathEntrys.henhouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("CullDeathEntrys.henhouse.id"));
			sic.add(new SelectorItemInfo("CullDeathEntrys.henhouse.number"));
			sic.add(new SelectorItemInfo("CullDeathEntrys.henhouse.name"));
		}
    	sic.add(new SelectorItemInfo("CullDeathEntrys.henhouseName"));
    	sic.add(new SelectorItemInfo("CullDeathEntrys.henBatchCull"));
    	sic.add(new SelectorItemInfo("CullDeathEntrys.henhouseBreekingStock"));
    	sic.add(new SelectorItemInfo("CullDeathEntrys.cockBreekingStock"));
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("AssEntrys.henhouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("AssEntrys.henhouse.id"));
			sic.add(new SelectorItemInfo("AssEntrys.henhouse.number"));
			sic.add(new SelectorItemInfo("AssEntrys.henhouse.name"));
		}
    	sic.add(new SelectorItemInfo("AssEntrys.henhouseName"));
    	sic.add(new SelectorItemInfo("ImmuneEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ImmuneEntrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ImmuneEntrys.henhouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("ImmuneEntrys.henhouse.id"));
			sic.add(new SelectorItemInfo("ImmuneEntrys.henhouse.number"));
			sic.add(new SelectorItemInfo("ImmuneEntrys.henhouse.name"));
		}
    	sic.add(new SelectorItemInfo("ImmuneEntrys.henhouseName"));
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
    	sic.add(new SelectorItemInfo("TransHenhouseEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransHenhouseEntrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("TransHenhouseEntrys.isFromOtherBatch"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransHenhouseEntrys.fromHenhouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("TransHenhouseEntrys.fromHenhouse.id"));
			sic.add(new SelectorItemInfo("TransHenhouseEntrys.fromHenhouse.name"));
        	sic.add(new SelectorItemInfo("TransHenhouseEntrys.fromHenhouse.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransHenhouseEntrys.toHenhouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("TransHenhouseEntrys.toHenhouse.id"));
			sic.add(new SelectorItemInfo("TransHenhouseEntrys.toHenhouse.name"));
        	sic.add(new SelectorItemInfo("TransHenhouseEntrys.toHenhouse.number"));
		}
    	sic.add(new SelectorItemInfo("TransHenhouseEntrys.transHenQty"));
    	sic.add(new SelectorItemInfo("TransHenhouseEntrys.transCockQty"));
    	sic.add(new SelectorItemInfo("TransHenhouseEntrys.asTransEggQty"));
    	sic.add(new SelectorItemInfo("TransHenhouseEntrys.isBuy"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransHenhouseEntrys.supplier.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("TransHenhouseEntrys.supplier.id"));
			sic.add(new SelectorItemInfo("TransHenhouseEntrys.supplier.name"));
        	sic.add(new SelectorItemInfo("TransHenhouseEntrys.supplier.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransHenhouseEntrys.fromField.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("TransHenhouseEntrys.fromField.id"));
			sic.add(new SelectorItemInfo("TransHenhouseEntrys.fromField.name"));
        	sic.add(new SelectorItemInfo("TransHenhouseEntrys.fromField.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransHenhouseEntrys.toField.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("TransHenhouseEntrys.toField.id"));
			sic.add(new SelectorItemInfo("TransHenhouseEntrys.toField.name"));
        	sic.add(new SelectorItemInfo("TransHenhouseEntrys.toField.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransHenhouseEntrys.fromBatch.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("TransHenhouseEntrys.fromBatch.id"));
			sic.add(new SelectorItemInfo("TransHenhouseEntrys.fromBatch.number"));
		}
    	sic.add(new SelectorItemInfo("TransHenhouseEntrys.henAsFixedQty"));
    	sic.add(new SelectorItemInfo("TransHenhouseEntrys.cockAsFixedQty"));
    	sic.add(new SelectorItemInfo("FodderEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FodderEntrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FodderEntrys.fodderTower.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("FodderEntrys.fodderTower.id"));
			sic.add(new SelectorItemInfo("FodderEntrys.fodderTower.name"));
        	sic.add(new SelectorItemInfo("FodderEntrys.fodderTower.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FodderEntrys.fodderMaterial.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("FodderEntrys.fodderMaterial.id"));
			sic.add(new SelectorItemInfo("FodderEntrys.fodderMaterial.number"));
			sic.add(new SelectorItemInfo("FodderEntrys.fodderMaterial.name"));
		}
    	sic.add(new SelectorItemInfo("FodderEntrys.fodderMaterialName"));
    	sic.add(new SelectorItemInfo("FodderEntrys.fodderMaterialModel"));
    	sic.add(new SelectorItemInfo("FodderEntrys.fodderDate"));
    	sic.add(new SelectorItemInfo("FodderEntrys.fodderQty"));
    	sic.add(new SelectorItemInfo("FodderEntrys.fodderDesc"));
    	sic.add(new SelectorItemInfo("FodderEntrys.fodderTowerName"));
    	sic.add(new SelectorItemInfo("FodderEntrys.towerInventory"));
        sic.add(new SelectorItemInfo("breedLog"));
        sic.add(new SelectorItemInfo("baseStatus"));
        sic.add(new SelectorItemInfo("outSideTFrom"));
        sic.add(new SelectorItemInfo("outSideTTo"));
        sic.add(new SelectorItemInfo("weather"));
        sic.add(new SelectorItemInfo("outHumidityFrom"));
        sic.add(new SelectorItemInfo("outHumidityTo"));
        sic.add(new SelectorItemInfo("auditTime"));
        sic.add(new SelectorItemInfo("fuel"));
        sic.add(new SelectorItemInfo("electricityQty"));
        sic.add(new SelectorItemInfo("week"));
        sic.add(new SelectorItemInfo("weekDay"));
        sic.add(new SelectorItemInfo("qualifiedQty"));
        sic.add(new SelectorItemInfo("commodityQty"));
        sic.add(new SelectorItemInfo("doubleYolkQty"));
        sic.add(new SelectorItemInfo("coalFual"));
        sic.add(new SelectorItemInfo("dieselFual"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("parentBatch.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("parentBatch.id"));
        	sic.add(new SelectorItemInfo("parentBatch.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("broodCostObject.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("broodCostObject.id"));
        	sic.add(new SelectorItemInfo("broodCostObject.number"));
        	sic.add(new SelectorItemInfo("broodCostObject.name"));
		}
    	sic.add(new SelectorItemInfo("Conveyor.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Conveyor.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Conveyor.conveyorNumber.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Conveyor.conveyorNumber.id"));
			sic.add(new SelectorItemInfo("Conveyor.conveyorNumber.number"));
			sic.add(new SelectorItemInfo("Conveyor.conveyorNumber.name"));
		}
    	sic.add(new SelectorItemInfo("Conveyor.henhouseDesc"));
    	sic.add(new SelectorItemInfo("Conveyor.qualifiedEggs"));
    	sic.add(new SelectorItemInfo("Conveyor.freakEggs"));
    	sic.add(new SelectorItemInfo("Conveyor.doubleYolkedEggs"));
    	sic.add(new SelectorItemInfo("Conveyor.brokenEggs"));
    	sic.add(new SelectorItemInfo("Conveyor.eggAverageWeight"));
    	sic.add(new SelectorItemInfo("Conveyor.doubleYolkTransQty"));
    	sic.add(new SelectorItemInfo("Conveyor.freakTransQty"));
    	sic.add(new SelectorItemInfo("Conveyor.qulifiedTransQty"));
    	sic.add(new SelectorItemInfo("Conveyor.doubleYolkInventory"));
    	sic.add(new SelectorItemInfo("Conveyor.freakInventory"));
    	sic.add(new SelectorItemInfo("Conveyor.qualifyInventory"));
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
			sic.add(new SelectorItemInfo("stoOrg.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("stoOrg.id"));
        	sic.add(new SelectorItemInfo("stoOrg.number"));
        	sic.add(new SelectorItemInfo("stoOrg.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("babyCostObject.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("babyCostObject.id"));
        	sic.add(new SelectorItemInfo("babyCostObject.number"));
        	sic.add(new SelectorItemInfo("babyCostObject.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("eggCostObject.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("eggCostObject.id"));
        	sic.add(new SelectorItemInfo("eggCostObject.number"));
        	sic.add(new SelectorItemInfo("eggCostObject.name"));
		}
        sic.add(new SelectorItemInfo("sumDay"));
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
        com.kingdee.eas.farm.breed.layegg.LayEggDailyFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.breed.layegg.LayEggDailyFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionGenNextBill_actionPerformed method
     */
    public void actionGenNextBill_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.breed.layegg.LayEggDailyFactory.getRemoteInstance().genNextBill(editData);
    }
    	

    /**
     * output actionReShareInfos_actionPerformed method
     */
    public void actionReShareInfos_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.breed.layegg.LayEggDailyFactory.getRemoteInstance().reShareInfos(editData);
    }
    	

    /**
     * output actionRefreshInventory_actionPerformed method
     */
    public void actionRefreshInventory_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.breed.layegg.LayEggDailyFactory.getRemoteInstance().refreshInventory(editData);
    }
    	

    /**
     * output actionToStockDaily_actionPerformed method
     */
    public void actionToStockDaily_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.breed.layegg.LayEggDailyFactory.getRemoteInstance().toStockDaily(editData);
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
	public RequestContext prepareActionReShareInfos(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionReShareInfos() {
    	return false;
    }
	public RequestContext prepareActionRefreshInventory(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionRefreshInventory() {
    	return false;
    }
	public RequestContext prepareActionToStockDaily(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionToStockDaily() {
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
            innerActionPerformed("eas", AbstractLayEggDailyEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractLayEggDailyEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractLayEggDailyEditUI.this, "ActionGenNextBill", "actionGenNextBill_actionPerformed", e);
        }
    }

    /**
     * output ActionReShareInfos class
     */     
    protected class ActionReShareInfos extends ItemAction {     
    
        public ActionReShareInfos()
        {
            this(null);
        }

        public ActionReShareInfos(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionReShareInfos.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionReShareInfos.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionReShareInfos.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractLayEggDailyEditUI.this, "ActionReShareInfos", "actionReShareInfos_actionPerformed", e);
        }
    }

    /**
     * output ActionRefreshInventory class
     */     
    protected class ActionRefreshInventory extends ItemAction {     
    
        public ActionRefreshInventory()
        {
            this(null);
        }

        public ActionRefreshInventory(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionRefreshInventory.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionRefreshInventory.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionRefreshInventory.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractLayEggDailyEditUI.this, "ActionRefreshInventory", "actionRefreshInventory_actionPerformed", e);
        }
    }

    /**
     * output ActionToStockDaily class
     */     
    protected class ActionToStockDaily extends ItemAction {     
    
        public ActionToStockDaily()
        {
            this(null);
        }

        public ActionToStockDaily(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionToStockDaily.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionToStockDaily.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionToStockDaily.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractLayEggDailyEditUI.this, "ActionToStockDaily", "actionToStockDaily_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.breed.layegg.client", "LayEggDailyEditUI");
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
        return com.kingdee.eas.farm.breed.layegg.client.LayEggDailyEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.breed.layegg.LayEggDailyFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.breed.layegg.LayEggDailyInfo objectValue = new com.kingdee.eas.farm.breed.layegg.LayEggDailyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/breed/layegg/LayEggDaily";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.breed.layegg.app.LayEggDailyQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtNumber.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"���ݱ��"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"ҵ������"});
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"henhouse").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"����"});
			}
		}
		for (int i=0,n=kdtLayEggEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtLayEggEntrys.getCell(i,"henhouse").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"����"});
			}
		}
		for (int i=0,n=kdtCullDeathEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtCullDeathEntrys.getCell(i,"henhouse").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"����"});
			}
		}
		for (int i=0,n=kdtAssEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtAssEntrys.getCell(i,"henhouse").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"����"});
			}
		}
		for (int i=0,n=kdtImmuneEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtImmuneEntrys.getCell(i,"henhouse").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"����"});
			}
		}
		for (int i=0,n=kdtImmuneEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtImmuneEntrys.getCell(i,"vaccineMaterial").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"����"});
			}
		}
		for (int i=0,n=kdtImmuneEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtImmuneEntrys.getCell(i,"vaccineUsedQty").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"ʹ����"});
			}
		}
		for (int i=0,n=kdtFodderEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtFodderEntrys.getCell(i,"fodderTower").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"����"});
			}
		}
		for (int i=0,n=kdtFodderEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtFodderEntrys.getCell(i,"towerInventory").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"��ǰʣ����(����)"});
			}
		}
		for (int i=0,n=kdtFodderEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtFodderEntrys.getCell(i,"fodderMaterial").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"����"});
			}
		}
		for (int i=0,n=kdtFodderEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtFodderEntrys.getCell(i,"fodderDate").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"Ҫ������"});
			}
		}
		for (int i=0,n=kdtFodderEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtFodderEntrys.getCell(i,"fodderQty").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"����(����)"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(baseStatus.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"״̬"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtparentBatch.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"��ֳ����"});
		}
		for (int i=0,n=kdtConveyor.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtConveyor.getCell(i,"conveyorNumber").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"���ʹ�"});
			}
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
			setTableToSumField(kdtEntrys,new String[] {"henQty","cockQty","waterQty"});
			setTableToSumField(kdtLayEggEntrys,new String[] {"allEggs","qualifiedEggs"});
			setTableToSumField(kdtCullDeathEntrys,new String[] {"henDeath","henCull","henBatchCull","henhouseBreekingStock","cockDeath","cockCull","cockBatchCull","cockBreekingStock"});
			setTableToSumField(kdtFodderEntrys,new String[] {"fodderQty"});
			setTableToSumField(kdtConveyor,new String[] {"qualifiedEggs","freakEggs","doubleYolkedEggs","brokenEggs","doubleYolkInventory","doubleYolkTransQty","freakInventory","freakTransQty","qualifyInventory","qulifiedTransQty"});
		}


}