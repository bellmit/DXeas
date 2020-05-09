/**
 * output package name
 */
package com.kingdee.eas.farm.breed.business.client;

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
public abstract class AbstractCommecialChilkenDailyEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCommecialChilkenDailyEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdays;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcoalFual;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdieselFual;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continitPersonQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contleavePersonQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contentryPersonQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contattendPersonQty;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisHenhouseEmpty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedBatch;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweek;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contday;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contconfirmTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDPanel baseTab;
    protected com.kingdee.bos.ctrl.swing.KDPanel assTab;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtAssEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtAssEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtImmuneEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtImmuneEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtFodderPlanEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtFodderPlanEntrys_detailPanel = null;
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
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdays;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcoalFual;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdieselFual;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtinitPersonQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtleavePersonQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtentryPersonQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtattendPersonQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbreedBatch;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarm;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmer;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtweek;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtday;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkconfirmTime;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnGenNextBill;
    protected com.kingdee.eas.farm.breed.business.CommecialChilkenDailyInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionGenNextBill actionGenNextBill = null;
    /**
     * output class constructor
     */
    public AbstractCommecialChilkenDailyEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCommecialChilkenDailyEditUI.class.getName());
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
        this.contdays = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcoalFual = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdieselFual = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continitPersonQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contleavePersonQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contentryPersonQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contattendPersonQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisHenhouseEmpty = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contbreedBatch = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweek = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contday = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contconfirmTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.baseTab = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.assTab = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtAssEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtImmuneEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtFodderPlanEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
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
        this.txtdays = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcoalFual = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdieselFual = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtinitPersonQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtleavePersonQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtentryPersonQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtattendPersonQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtbreedBatch = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtfarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtfarmer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtweek = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtday = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkconfirmTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
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
        this.contdays.setName("contdays");
        this.contcoalFual.setName("contcoalFual");
        this.contdieselFual.setName("contdieselFual");
        this.continitPersonQty.setName("continitPersonQty");
        this.contleavePersonQty.setName("contleavePersonQty");
        this.contentryPersonQty.setName("contentryPersonQty");
        this.contattendPersonQty.setName("contattendPersonQty");
        this.chkisHenhouseEmpty.setName("chkisHenhouseEmpty");
        this.contbreedBatch.setName("contbreedBatch");
        this.contcompany.setName("contcompany");
        this.contfarm.setName("contfarm");
        this.contfarmer.setName("contfarmer");
        this.contweek.setName("contweek");
        this.contday.setName("contday");
        this.contconfirmTime.setName("contconfirmTime");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.baseTab.setName("baseTab");
        this.assTab.setName("assTab");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel4.setName("kDPanel4");
        this.kdtEntrys.setName("kdtEntrys");
        this.kdtAssEntrys.setName("kdtAssEntrys");
        this.kdtImmuneEntrys.setName("kdtImmuneEntrys");
        this.kdtFodderPlanEntrys.setName("kdtFodderPlanEntrys");
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
        this.txtdays.setName("txtdays");
        this.txtcoalFual.setName("txtcoalFual");
        this.txtdieselFual.setName("txtdieselFual");
        this.txtinitPersonQty.setName("txtinitPersonQty");
        this.txtleavePersonQty.setName("txtleavePersonQty");
        this.txtentryPersonQty.setName("txtentryPersonQty");
        this.txtattendPersonQty.setName("txtattendPersonQty");
        this.prmtbreedBatch.setName("prmtbreedBatch");
        this.prmtcompany.setName("prmtcompany");
        this.prmtfarm.setName("prmtfarm");
        this.prmtfarmer.setName("prmtfarmer");
        this.txtweek.setName("txtweek");
        this.txtday.setName("txtday");
        this.pkconfirmTime.setName("pkconfirmTime");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
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
        // contdays		
        this.contdays.setBoundLabelText(resHelper.getString("contdays.boundLabelText"));		
        this.contdays.setBoundLabelLength(100);		
        this.contdays.setBoundLabelUnderline(true);		
        this.contdays.setVisible(false);
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
        // continitPersonQty		
        this.continitPersonQty.setBoundLabelText(resHelper.getString("continitPersonQty.boundLabelText"));		
        this.continitPersonQty.setBoundLabelLength(100);		
        this.continitPersonQty.setBoundLabelUnderline(true);		
        this.continitPersonQty.setVisible(false);
        // contleavePersonQty		
        this.contleavePersonQty.setBoundLabelText(resHelper.getString("contleavePersonQty.boundLabelText"));		
        this.contleavePersonQty.setBoundLabelLength(100);		
        this.contleavePersonQty.setBoundLabelUnderline(true);		
        this.contleavePersonQty.setVisible(false);
        // contentryPersonQty		
        this.contentryPersonQty.setBoundLabelText(resHelper.getString("contentryPersonQty.boundLabelText"));		
        this.contentryPersonQty.setBoundLabelLength(100);		
        this.contentryPersonQty.setBoundLabelUnderline(true);		
        this.contentryPersonQty.setVisible(true);
        // contattendPersonQty		
        this.contattendPersonQty.setBoundLabelText(resHelper.getString("contattendPersonQty.boundLabelText"));		
        this.contattendPersonQty.setBoundLabelLength(100);		
        this.contattendPersonQty.setBoundLabelUnderline(true);		
        this.contattendPersonQty.setVisible(false);
        // chkisHenhouseEmpty		
        this.chkisHenhouseEmpty.setText(resHelper.getString("chkisHenhouseEmpty.text"));		
        this.chkisHenhouseEmpty.setHorizontalAlignment(2);
        // contbreedBatch		
        this.contbreedBatch.setBoundLabelText(resHelper.getString("contbreedBatch.boundLabelText"));		
        this.contbreedBatch.setBoundLabelLength(100);		
        this.contbreedBatch.setBoundLabelUnderline(true);		
        this.contbreedBatch.setVisible(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contfarm		
        this.contfarm.setBoundLabelText(resHelper.getString("contfarm.boundLabelText"));		
        this.contfarm.setBoundLabelLength(100);		
        this.contfarm.setBoundLabelUnderline(true);		
        this.contfarm.setVisible(true);
        // contfarmer		
        this.contfarmer.setBoundLabelText(resHelper.getString("contfarmer.boundLabelText"));		
        this.contfarmer.setBoundLabelLength(100);		
        this.contfarmer.setBoundLabelUnderline(true);		
        this.contfarmer.setVisible(true);
        // contweek		
        this.contweek.setBoundLabelText(resHelper.getString("contweek.boundLabelText"));		
        this.contweek.setBoundLabelLength(60);		
        this.contweek.setBoundLabelUnderline(true);		
        this.contweek.setVisible(true);
        // contday		
        this.contday.setBoundLabelText(resHelper.getString("contday.boundLabelText"));		
        this.contday.setBoundLabelLength(60);		
        this.contday.setBoundLabelUnderline(true);		
        this.contday.setVisible(true);
        // contconfirmTime		
        this.contconfirmTime.setBoundLabelText(resHelper.getString("contconfirmTime.boundLabelText"));		
        this.contconfirmTime.setBoundLabelLength(100);		
        this.contconfirmTime.setBoundLabelUnderline(true);		
        this.contconfirmTime.setVisible(true);
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
        // baseTab		
        this.baseTab.setVisible(true);
        // assTab		
        this.assTab.setVisible(true);
        // kDPanel1
        // kDPanel2
        // kDPanel4
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"henhouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"henhouseName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"days\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"materialName\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"materialModel\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"standardFeedQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"dailyQtyAll\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"waterQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"averageWeight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{henhouse}</t:Cell><t:Cell>$Resource{henhouseName}</t:Cell><t:Cell>$Resource{days}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{materialModel}</t:Cell><t:Cell>$Resource{standardFeedQty}</t:Cell><t:Cell>$Resource{dailyQtyAll}</t:Cell><t:Cell>$Resource{waterQty}</t:Cell><t:Cell>$Resource{averageWeight}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtEntrys.putBindContents("editData",new String[] {"id","henhouse","henhouseName","days","material","materialName","materialModel","standardFeedQty","dailyQtyAll","waterQty","averageWeight"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_henhouse_PromptBox = new KDBizPromptBox();
        kdtEntrys_henhouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
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
        KDFormattedTextField kdtEntrys_days_TextField = new KDFormattedTextField();
        kdtEntrys_days_TextField.setName("kdtEntrys_days_TextField");
        kdtEntrys_days_TextField.setVisible(true);
        kdtEntrys_days_TextField.setEditable(true);
        kdtEntrys_days_TextField.setHorizontalAlignment(2);
        kdtEntrys_days_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_days_CellEditor = new KDTDefaultCellEditor(kdtEntrys_days_TextField);
        this.kdtEntrys.getColumn("days").setEditor(kdtEntrys_days_CellEditor);
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
        KDFormattedTextField kdtEntrys_standardFeedQty_TextField = new KDFormattedTextField();
        kdtEntrys_standardFeedQty_TextField.setName("kdtEntrys_standardFeedQty_TextField");
        kdtEntrys_standardFeedQty_TextField.setVisible(true);
        kdtEntrys_standardFeedQty_TextField.setEditable(true);
        kdtEntrys_standardFeedQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_standardFeedQty_TextField.setDataType(1);
        	kdtEntrys_standardFeedQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_standardFeedQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_standardFeedQty_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_standardFeedQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_standardFeedQty_TextField);
        this.kdtEntrys.getColumn("standardFeedQty").setEditor(kdtEntrys_standardFeedQty_CellEditor);
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
        KDFormattedTextField kdtEntrys_averageWeight_TextField = new KDFormattedTextField();
        kdtEntrys_averageWeight_TextField.setName("kdtEntrys_averageWeight_TextField");
        kdtEntrys_averageWeight_TextField.setVisible(true);
        kdtEntrys_averageWeight_TextField.setEditable(true);
        kdtEntrys_averageWeight_TextField.setHorizontalAlignment(2);
        kdtEntrys_averageWeight_TextField.setDataType(1);
        	kdtEntrys_averageWeight_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_averageWeight_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_averageWeight_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_averageWeight_CellEditor = new KDTDefaultCellEditor(kdtEntrys_averageWeight_TextField);
        this.kdtEntrys.getColumn("averageWeight").setEditor(kdtEntrys_averageWeight_CellEditor);
        // kdtAssEntrys
		String kdtAssEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"henhouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"henhouseName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"days\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"cullAndDeath\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"transQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"breedingStock\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"isMarketed\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"marketQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"breedTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"lightingTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"temperatureTo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"temperatureFrom\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"humidityTo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"humidityFrom\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{henhouse}</t:Cell><t:Cell>$Resource{henhouseName}</t:Cell><t:Cell>$Resource{days}</t:Cell><t:Cell>$Resource{cullAndDeath}</t:Cell><t:Cell>$Resource{transQty}</t:Cell><t:Cell>$Resource{breedingStock}</t:Cell><t:Cell>$Resource{isMarketed}</t:Cell><t:Cell>$Resource{marketQty}</t:Cell><t:Cell>$Resource{breedTime}</t:Cell><t:Cell>$Resource{lightingTime}</t:Cell><t:Cell>$Resource{temperatureTo}</t:Cell><t:Cell>$Resource{temperatureFrom}</t:Cell><t:Cell>$Resource{humidityTo}</t:Cell><t:Cell>$Resource{humidityFrom}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtAssEntrys.putBindContents("editData",new String[] {"id","henhouse","henhouseName","days","cullAndDeath","transQty","breedingStock","isMarketed","marketQty","breedTime","lightingTime","temperatureTo","temperatureFrom","humidityTo","humidityFrom"});


        this.kdtAssEntrys.checkParsed();
        final KDBizPromptBox kdtAssEntrys_henhouse_PromptBox = new KDBizPromptBox();
        kdtAssEntrys_henhouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
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
        KDFormattedTextField kdtAssEntrys_days_TextField = new KDFormattedTextField();
        kdtAssEntrys_days_TextField.setName("kdtAssEntrys_days_TextField");
        kdtAssEntrys_days_TextField.setVisible(true);
        kdtAssEntrys_days_TextField.setEditable(true);
        kdtAssEntrys_days_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_days_TextField.setDataType(0);
        KDTDefaultCellEditor kdtAssEntrys_days_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_days_TextField);
        this.kdtAssEntrys.getColumn("days").setEditor(kdtAssEntrys_days_CellEditor);
        KDFormattedTextField kdtAssEntrys_cullAndDeath_TextField = new KDFormattedTextField();
        kdtAssEntrys_cullAndDeath_TextField.setName("kdtAssEntrys_cullAndDeath_TextField");
        kdtAssEntrys_cullAndDeath_TextField.setVisible(true);
        kdtAssEntrys_cullAndDeath_TextField.setEditable(true);
        kdtAssEntrys_cullAndDeath_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_cullAndDeath_TextField.setDataType(0);
        KDTDefaultCellEditor kdtAssEntrys_cullAndDeath_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_cullAndDeath_TextField);
        this.kdtAssEntrys.getColumn("cullAndDeath").setEditor(kdtAssEntrys_cullAndDeath_CellEditor);
        KDFormattedTextField kdtAssEntrys_transQty_TextField = new KDFormattedTextField();
        kdtAssEntrys_transQty_TextField.setName("kdtAssEntrys_transQty_TextField");
        kdtAssEntrys_transQty_TextField.setVisible(true);
        kdtAssEntrys_transQty_TextField.setEditable(true);
        kdtAssEntrys_transQty_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_transQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtAssEntrys_transQty_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_transQty_TextField);
        this.kdtAssEntrys.getColumn("transQty").setEditor(kdtAssEntrys_transQty_CellEditor);
        KDFormattedTextField kdtAssEntrys_breedingStock_TextField = new KDFormattedTextField();
        kdtAssEntrys_breedingStock_TextField.setName("kdtAssEntrys_breedingStock_TextField");
        kdtAssEntrys_breedingStock_TextField.setVisible(true);
        kdtAssEntrys_breedingStock_TextField.setEditable(true);
        kdtAssEntrys_breedingStock_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_breedingStock_TextField.setDataType(0);
        KDTDefaultCellEditor kdtAssEntrys_breedingStock_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_breedingStock_TextField);
        this.kdtAssEntrys.getColumn("breedingStock").setEditor(kdtAssEntrys_breedingStock_CellEditor);
        KDCheckBox kdtAssEntrys_isMarketed_CheckBox = new KDCheckBox();
        kdtAssEntrys_isMarketed_CheckBox.setName("kdtAssEntrys_isMarketed_CheckBox");
        KDTDefaultCellEditor kdtAssEntrys_isMarketed_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_isMarketed_CheckBox);
        this.kdtAssEntrys.getColumn("isMarketed").setEditor(kdtAssEntrys_isMarketed_CellEditor);
        KDFormattedTextField kdtAssEntrys_marketQty_TextField = new KDFormattedTextField();
        kdtAssEntrys_marketQty_TextField.setName("kdtAssEntrys_marketQty_TextField");
        kdtAssEntrys_marketQty_TextField.setVisible(true);
        kdtAssEntrys_marketQty_TextField.setEditable(true);
        kdtAssEntrys_marketQty_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_marketQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtAssEntrys_marketQty_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_marketQty_TextField);
        this.kdtAssEntrys.getColumn("marketQty").setEditor(kdtAssEntrys_marketQty_CellEditor);
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
		String kdtImmuneEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"henhouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"henhouseName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"days\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"vaccineMaterial\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"vaccineUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"vaccineGetQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"vaccineUsedQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol7\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{henhouse}</t:Cell><t:Cell>$Resource{henhouseName}</t:Cell><t:Cell>$Resource{days}</t:Cell><t:Cell>$Resource{vaccineMaterial}</t:Cell><t:Cell>$Resource{vaccineUnit}</t:Cell><t:Cell>$Resource{vaccineGetQty}</t:Cell><t:Cell>$Resource{vaccineUsedQty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtImmuneEntrys.putBindContents("editData",new String[] {"seq","henhouse","henhouseName","days","vaccineMaterial","vaccineUnit","vaccineGetQty","vaccineUsedQty"});


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
        kdtImmuneEntrys_henhouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
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
        KDFormattedTextField kdtImmuneEntrys_days_TextField = new KDFormattedTextField();
        kdtImmuneEntrys_days_TextField.setName("kdtImmuneEntrys_days_TextField");
        kdtImmuneEntrys_days_TextField.setVisible(true);
        kdtImmuneEntrys_days_TextField.setEditable(true);
        kdtImmuneEntrys_days_TextField.setHorizontalAlignment(2);
        kdtImmuneEntrys_days_TextField.setDataType(0);
        KDTDefaultCellEditor kdtImmuneEntrys_days_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_days_TextField);
        this.kdtImmuneEntrys.getColumn("days").setEditor(kdtImmuneEntrys_days_CellEditor);
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
        // kdtFodderPlanEntrys
		String kdtFodderPlanEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"fodderTower\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"flodderTowerName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"TowerInventory\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"fodderMaterial\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"fodderMaterialName\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"fodderMaterialModel\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"fodderDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"fodderQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"fodderDesc\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{fodderTower}</t:Cell><t:Cell>$Resource{flodderTowerName}</t:Cell><t:Cell>$Resource{TowerInventory}</t:Cell><t:Cell>$Resource{fodderMaterial}</t:Cell><t:Cell>$Resource{fodderMaterialName}</t:Cell><t:Cell>$Resource{fodderMaterialModel}</t:Cell><t:Cell>$Resource{fodderDate}</t:Cell><t:Cell>$Resource{fodderQty}</t:Cell><t:Cell>$Resource{fodderDesc}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtFodderPlanEntrys.setFormatXml(resHelper.translateString("kdtFodderPlanEntrys",kdtFodderPlanEntrysStrXML));
        kdtFodderPlanEntrys.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtFodderPlanEntrys_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtFodderPlanEntrys.putBindContents("editData",new String[] {"seq","fodderTower","flodderTowerName","TowerInventory","fodderMaterial","fodderMaterialName","fodderMaterialModel","fodderDate","fodderQty","fodderDesc"});


        this.kdtFodderPlanEntrys.checkParsed();
        KDFormattedTextField kdtFodderPlanEntrys_seq_TextField = new KDFormattedTextField();
        kdtFodderPlanEntrys_seq_TextField.setName("kdtFodderPlanEntrys_seq_TextField");
        kdtFodderPlanEntrys_seq_TextField.setVisible(true);
        kdtFodderPlanEntrys_seq_TextField.setEditable(true);
        kdtFodderPlanEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtFodderPlanEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtFodderPlanEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtFodderPlanEntrys_seq_TextField);
        this.kdtFodderPlanEntrys.getColumn("seq").setEditor(kdtFodderPlanEntrys_seq_CellEditor);
        final KDBizPromptBox kdtFodderPlanEntrys_fodderTower_PromptBox = new KDBizPromptBox();
        kdtFodderPlanEntrys_fodderTower_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7AllWarehouseQuery");
        kdtFodderPlanEntrys_fodderTower_PromptBox.setVisible(true);
        kdtFodderPlanEntrys_fodderTower_PromptBox.setEditable(true);
        kdtFodderPlanEntrys_fodderTower_PromptBox.setDisplayFormat("$number$");
        kdtFodderPlanEntrys_fodderTower_PromptBox.setEditFormat("$number$");
        kdtFodderPlanEntrys_fodderTower_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtFodderPlanEntrys_fodderTower_CellEditor = new KDTDefaultCellEditor(kdtFodderPlanEntrys_fodderTower_PromptBox);
        this.kdtFodderPlanEntrys.getColumn("fodderTower").setEditor(kdtFodderPlanEntrys_fodderTower_CellEditor);
        ObjectValueRender kdtFodderPlanEntrys_fodderTower_OVR = new ObjectValueRender();
        kdtFodderPlanEntrys_fodderTower_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtFodderPlanEntrys.getColumn("fodderTower").setRenderer(kdtFodderPlanEntrys_fodderTower_OVR);
        KDTextField kdtFodderPlanEntrys_flodderTowerName_TextField = new KDTextField();
        kdtFodderPlanEntrys_flodderTowerName_TextField.setName("kdtFodderPlanEntrys_flodderTowerName_TextField");
        kdtFodderPlanEntrys_flodderTowerName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtFodderPlanEntrys_flodderTowerName_CellEditor = new KDTDefaultCellEditor(kdtFodderPlanEntrys_flodderTowerName_TextField);
        this.kdtFodderPlanEntrys.getColumn("flodderTowerName").setEditor(kdtFodderPlanEntrys_flodderTowerName_CellEditor);
        KDFormattedTextField kdtFodderPlanEntrys_TowerInventory_TextField = new KDFormattedTextField();
        kdtFodderPlanEntrys_TowerInventory_TextField.setName("kdtFodderPlanEntrys_TowerInventory_TextField");
        kdtFodderPlanEntrys_TowerInventory_TextField.setVisible(true);
        kdtFodderPlanEntrys_TowerInventory_TextField.setEditable(true);
        kdtFodderPlanEntrys_TowerInventory_TextField.setHorizontalAlignment(2);
        kdtFodderPlanEntrys_TowerInventory_TextField.setDataType(1);
        	kdtFodderPlanEntrys_TowerInventory_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtFodderPlanEntrys_TowerInventory_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtFodderPlanEntrys_TowerInventory_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtFodderPlanEntrys_TowerInventory_CellEditor = new KDTDefaultCellEditor(kdtFodderPlanEntrys_TowerInventory_TextField);
        this.kdtFodderPlanEntrys.getColumn("TowerInventory").setEditor(kdtFodderPlanEntrys_TowerInventory_CellEditor);
        final KDBizPromptBox kdtFodderPlanEntrys_fodderMaterial_PromptBox = new KDBizPromptBox();
        kdtFodderPlanEntrys_fodderMaterial_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtFodderPlanEntrys_fodderMaterial_PromptBox.setVisible(true);
        kdtFodderPlanEntrys_fodderMaterial_PromptBox.setEditable(true);
        kdtFodderPlanEntrys_fodderMaterial_PromptBox.setDisplayFormat("$number$");
        kdtFodderPlanEntrys_fodderMaterial_PromptBox.setEditFormat("$number$");
        kdtFodderPlanEntrys_fodderMaterial_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtFodderPlanEntrys_fodderMaterial_CellEditor = new KDTDefaultCellEditor(kdtFodderPlanEntrys_fodderMaterial_PromptBox);
        this.kdtFodderPlanEntrys.getColumn("fodderMaterial").setEditor(kdtFodderPlanEntrys_fodderMaterial_CellEditor);
        ObjectValueRender kdtFodderPlanEntrys_fodderMaterial_OVR = new ObjectValueRender();
        kdtFodderPlanEntrys_fodderMaterial_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtFodderPlanEntrys.getColumn("fodderMaterial").setRenderer(kdtFodderPlanEntrys_fodderMaterial_OVR);
        KDTextField kdtFodderPlanEntrys_fodderMaterialName_TextField = new KDTextField();
        kdtFodderPlanEntrys_fodderMaterialName_TextField.setName("kdtFodderPlanEntrys_fodderMaterialName_TextField");
        kdtFodderPlanEntrys_fodderMaterialName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtFodderPlanEntrys_fodderMaterialName_CellEditor = new KDTDefaultCellEditor(kdtFodderPlanEntrys_fodderMaterialName_TextField);
        this.kdtFodderPlanEntrys.getColumn("fodderMaterialName").setEditor(kdtFodderPlanEntrys_fodderMaterialName_CellEditor);
        KDTextField kdtFodderPlanEntrys_fodderMaterialModel_TextField = new KDTextField();
        kdtFodderPlanEntrys_fodderMaterialModel_TextField.setName("kdtFodderPlanEntrys_fodderMaterialModel_TextField");
        kdtFodderPlanEntrys_fodderMaterialModel_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtFodderPlanEntrys_fodderMaterialModel_CellEditor = new KDTDefaultCellEditor(kdtFodderPlanEntrys_fodderMaterialModel_TextField);
        this.kdtFodderPlanEntrys.getColumn("fodderMaterialModel").setEditor(kdtFodderPlanEntrys_fodderMaterialModel_CellEditor);
        KDDatePicker kdtFodderPlanEntrys_fodderDate_DatePicker = new KDDatePicker();
        kdtFodderPlanEntrys_fodderDate_DatePicker.setName("kdtFodderPlanEntrys_fodderDate_DatePicker");
        kdtFodderPlanEntrys_fodderDate_DatePicker.setVisible(true);
        kdtFodderPlanEntrys_fodderDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtFodderPlanEntrys_fodderDate_CellEditor = new KDTDefaultCellEditor(kdtFodderPlanEntrys_fodderDate_DatePicker);
        this.kdtFodderPlanEntrys.getColumn("fodderDate").setEditor(kdtFodderPlanEntrys_fodderDate_CellEditor);
        KDFormattedTextField kdtFodderPlanEntrys_fodderQty_TextField = new KDFormattedTextField();
        kdtFodderPlanEntrys_fodderQty_TextField.setName("kdtFodderPlanEntrys_fodderQty_TextField");
        kdtFodderPlanEntrys_fodderQty_TextField.setVisible(true);
        kdtFodderPlanEntrys_fodderQty_TextField.setEditable(true);
        kdtFodderPlanEntrys_fodderQty_TextField.setHorizontalAlignment(2);
        kdtFodderPlanEntrys_fodderQty_TextField.setDataType(1);
        	kdtFodderPlanEntrys_fodderQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtFodderPlanEntrys_fodderQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtFodderPlanEntrys_fodderQty_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtFodderPlanEntrys_fodderQty_CellEditor = new KDTDefaultCellEditor(kdtFodderPlanEntrys_fodderQty_TextField);
        this.kdtFodderPlanEntrys.getColumn("fodderQty").setEditor(kdtFodderPlanEntrys_fodderQty_CellEditor);
        KDTextField kdtFodderPlanEntrys_fodderDesc_TextField = new KDTextField();
        kdtFodderPlanEntrys_fodderDesc_TextField.setName("kdtFodderPlanEntrys_fodderDesc_TextField");
        kdtFodderPlanEntrys_fodderDesc_TextField.setMaxLength(200);
        KDTDefaultCellEditor kdtFodderPlanEntrys_fodderDesc_CellEditor = new KDTDefaultCellEditor(kdtFodderPlanEntrys_fodderDesc_TextField);
        this.kdtFodderPlanEntrys.getColumn("fodderDesc").setEditor(kdtFodderPlanEntrys_fodderDesc_CellEditor);
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
        // txtdays		
        this.txtdays.setHorizontalAlignment(2);		
        this.txtdays.setDataType(0);		
        this.txtdays.setSupportedEmpty(true);		
        this.txtdays.setRequired(false);		
        this.txtdays.setEnabled(false);		
        this.txtdays.setVisible(false);		
        this.txtdays.setOpaque(false);
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
        // txtinitPersonQty		
        this.txtinitPersonQty.setHorizontalAlignment(2);		
        this.txtinitPersonQty.setDataType(0);		
        this.txtinitPersonQty.setSupportedEmpty(true);		
        this.txtinitPersonQty.setRequired(false);		
        this.txtinitPersonQty.setVisible(false);
        // txtleavePersonQty		
        this.txtleavePersonQty.setHorizontalAlignment(2);		
        this.txtleavePersonQty.setDataType(0);		
        this.txtleavePersonQty.setSupportedEmpty(true);		
        this.txtleavePersonQty.setRequired(false);		
        this.txtleavePersonQty.setVisible(false);
        // txtentryPersonQty		
        this.txtentryPersonQty.setHorizontalAlignment(2);		
        this.txtentryPersonQty.setDataType(0);		
        this.txtentryPersonQty.setSupportedEmpty(true);		
        this.txtentryPersonQty.setRequired(false);
        // txtattendPersonQty		
        this.txtattendPersonQty.setHorizontalAlignment(2);		
        this.txtattendPersonQty.setDataType(0);		
        this.txtattendPersonQty.setSupportedEmpty(true);		
        this.txtattendPersonQty.setRequired(false);		
        this.txtattendPersonQty.setVisible(false);
        // prmtbreedBatch		
        this.prmtbreedBatch.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.BatchQuery");		
        this.prmtbreedBatch.setVisible(true);		
        this.prmtbreedBatch.setEditable(true);		
        this.prmtbreedBatch.setDisplayFormat("$name$");		
        this.prmtbreedBatch.setEditFormat("$number$");		
        this.prmtbreedBatch.setCommitFormat("$number$");		
        this.prmtbreedBatch.setRequired(false);
        		prmtbreedBatch.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.BatchListUI prmtbreedBatch_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtbreedBatch_F7ListUI == null) {
					try {
						prmtbreedBatch_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.BatchListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtbreedBatch_F7ListUI));
					prmtbreedBatch_F7ListUI.setF7Use(true,ctx);
					prmtbreedBatch.setSelector(prmtbreedBatch_F7ListUI);
				}
			}
		});
					
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setVisible(true);		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(false);
        // prmtfarm		
        this.prmtfarm.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmQuery");		
        this.prmtfarm.setVisible(true);		
        this.prmtfarm.setEditable(true);		
        this.prmtfarm.setDisplayFormat("$name$");		
        this.prmtfarm.setEditFormat("$number$");		
        this.prmtfarm.setCommitFormat("$number$");		
        this.prmtfarm.setRequired(false);
        		prmtfarm.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.FarmListUI prmtfarm_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarm_F7ListUI == null) {
					try {
						prmtfarm_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.FarmListUI();
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
					
        // prmtfarmer		
        this.prmtfarmer.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerQuery");		
        this.prmtfarmer.setVisible(true);		
        this.prmtfarmer.setEditable(true);		
        this.prmtfarmer.setDisplayFormat("$name$");		
        this.prmtfarmer.setEditFormat("$number$");		
        this.prmtfarmer.setCommitFormat("$number$");		
        this.prmtfarmer.setRequired(false);
        		prmtfarmer.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.FarmerListUI prmtfarmer_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarmer_F7ListUI == null) {
					try {
						prmtfarmer_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.FarmerListUI();
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
					
        // txtweek		
        this.txtweek.setVisible(true);		
        this.txtweek.setHorizontalAlignment(2);		
        this.txtweek.setDataType(0);		
        this.txtweek.setSupportedEmpty(true);		
        this.txtweek.setRequired(false);
        // txtday		
        this.txtday.setVisible(true);		
        this.txtday.setHorizontalAlignment(2);		
        this.txtday.setDataType(0);		
        this.txtday.setSupportedEmpty(true);		
        this.txtday.setRequired(false);
        // pkconfirmTime		
        this.pkconfirmTime.setVisible(true);		
        this.pkconfirmTime.setRequired(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        // btnGenNextBill
        this.btnGenNextBill.setAction((IItemAction)ActionProxyFactory.getProxy(actionGenNextBill, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnGenNextBill.setText(resHelper.getString("btnGenNextBill.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,baseStatus,txtoutSideTFrom,txtoutSideTTo,txtweather,txtoutHumidityFrom,txtoutHumidityTo,pkauditTime,txtfuel,txtbreedLog,txtelectricityQty,txtdays,txtcoalFual,txtdieselFual,txtinitPersonQty,txtentryPersonQty,txtleavePersonQty,txtattendPersonQty,chkisHenhouseEmpty,kdtAssEntrys,kdtEntrys,kdtImmuneEntrys,kdtFodderPlanEntrys,prmtbreedBatch,prmtcompany,prmtfarm,prmtfarmer,txtweek,txtday,pkconfirmTime}));
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
        contNumber.setBounds(new Rectangle(12, 16, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(12, 16, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(725, 70, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(725, 70, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contDescription.setBounds(new Rectangle(724, -120, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(724, -120, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(724, 563, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(724, 563, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        paneBIZLayerControl17.setBounds(new Rectangle(15, 205, 993, 347));
        this.add(paneBIZLayerControl17, new KDLayout.Constraints(15, 205, 993, 347, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contbaseStatus.setBounds(new Rectangle(725, 46, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(725, 46, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contoutSideTFrom.setBounds(new Rectangle(12, 42, 270, 19));
        this.add(contoutSideTFrom, new KDLayout.Constraints(12, 42, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoutSideTTo.setBounds(new Rectangle(372, 95, 270, 19));
        this.add(contoutSideTTo, new KDLayout.Constraints(372, 95, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contweather.setBounds(new Rectangle(12, 94, 270, 19));
        this.add(contweather, new KDLayout.Constraints(12, 94, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoutHumidityFrom.setBounds(new Rectangle(12, 68, 270, 19));
        this.add(contoutHumidityFrom, new KDLayout.Constraints(12, 68, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoutHumidityTo.setBounds(new Rectangle(372, 121, 270, 19));
        this.add(contoutHumidityTo, new KDLayout.Constraints(372, 121, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(724, 592, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(724, 592, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfuel.setBounds(new Rectangle(368, -147, 270, 19));
        this.add(contfuel, new KDLayout.Constraints(368, -147, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contelectricityQty.setBounds(new Rectangle(12, 120, 270, 19));
        this.add(contelectricityQty, new KDLayout.Constraints(12, 120, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdays.setBounds(new Rectangle(12, -148, 270, 19));
        this.add(contdays, new KDLayout.Constraints(12, -148, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcoalFual.setBounds(new Rectangle(372, 147, 270, 19));
        this.add(contcoalFual, new KDLayout.Constraints(372, 147, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdieselFual.setBounds(new Rectangle(725, 96, 270, 19));
        this.add(contdieselFual, new KDLayout.Constraints(725, 96, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        continitPersonQty.setBounds(new Rectangle(985, 165, 270, 19));
        this.add(continitPersonQty, new KDLayout.Constraints(985, 165, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contleavePersonQty.setBounds(new Rectangle(977, 180, 270, 19));
        this.add(contleavePersonQty, new KDLayout.Constraints(977, 180, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contentryPersonQty.setBounds(new Rectangle(12, 147, 270, 19));
        this.add(contentryPersonQty, new KDLayout.Constraints(12, 147, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contattendPersonQty.setBounds(new Rectangle(994, 184, 270, 19));
        this.add(contattendPersonQty, new KDLayout.Constraints(994, 184, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkisHenhouseEmpty.setBounds(new Rectangle(12, 174, 270, 19));
        this.add(chkisHenhouseEmpty, new KDLayout.Constraints(12, 174, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbreedBatch.setBounds(new Rectangle(372, 16, 270, 19));
        this.add(contbreedBatch, new KDLayout.Constraints(372, 16, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompany.setBounds(new Rectangle(726, 16, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(726, 16, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfarm.setBounds(new Rectangle(372, 41, 270, 19));
        this.add(contfarm, new KDLayout.Constraints(372, 41, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmer.setBounds(new Rectangle(372, 71, 270, 19));
        this.add(contfarmer, new KDLayout.Constraints(372, 71, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contweek.setBounds(new Rectangle(725, 122, 126, 19));
        this.add(contweek, new KDLayout.Constraints(725, 122, 126, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contday.setBounds(new Rectangle(887, 122, 108, 19));
        this.add(contday, new KDLayout.Constraints(887, 122, 108, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contconfirmTime.setBounds(new Rectangle(725, 147, 270, 19));
        this.add(contconfirmTime, new KDLayout.Constraints(725, 147, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
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
        paneBIZLayerControl17.add(assTab, resHelper.getString("assTab.constraints"));
        paneBIZLayerControl17.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        paneBIZLayerControl17.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        paneBIZLayerControl17.add(kDPanel4, resHelper.getString("kDPanel4.constraints"));
        //baseTab
        baseTab.setLayout(new KDLayout());
        baseTab.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 314));        kdtEntrys.setBounds(new Rectangle(1, 1, 982, 315));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.breed.business.CommecialChilkenDailyEntryInfo(),null,false);
        baseTab.add(kdtEntrys_detailPanel, new KDLayout.Constraints(1, 1, 982, 315, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //assTab
        assTab.setLayout(new KDLayout());
        assTab.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 314));        kdtAssEntrys.setBounds(new Rectangle(1, 1, 979, 315));
        kdtAssEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtAssEntrys,new com.kingdee.eas.farm.breed.business.CommecialChilkenDailyAssEntryInfo(),null,false);
        assTab.add(kdtAssEntrys_detailPanel, new KDLayout.Constraints(1, 1, 979, 315, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtAssEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
		vo.put("cullAndDeath",new Integer(0));
		vo.put("transQty",new Integer(0));
		vo.put("breedingStock",new Integer(0));
		vo.put("marketQty",new Integer(0));
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 314));        kdtImmuneEntrys.setBounds(new Rectangle(0, -1, 987, 317));
        kdtImmuneEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtImmuneEntrys,new com.kingdee.eas.farm.breed.business.CommecialChilkenDailyImmuneEntryInfo(),null,false);
        kDPanel1.add(kdtImmuneEntrys_detailPanel, new KDLayout.Constraints(0, -1, 987, 317, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 314));        kdtFodderPlanEntrys.setBounds(new Rectangle(0, 1, 987, 314));
        kdtFodderPlanEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtFodderPlanEntrys,new com.kingdee.eas.farm.breed.business.CommecialChilkenDailyFodderPlanEntryInfo(),null,false);
        kDPanel2.add(kdtFodderPlanEntrys_detailPanel, new KDLayout.Constraints(0, 1, 987, 314, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel4
        kDPanel4.setLayout(new KDLayout());
        kDPanel4.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 314));        contbreedLog.setBounds(new Rectangle(-1, 2, 987, 313));
        kDPanel4.add(contbreedLog, new KDLayout.Constraints(-1, 2, 987, 313, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //contdays
        contdays.setBoundEditor(txtdays);
        //contcoalFual
        contcoalFual.setBoundEditor(txtcoalFual);
        //contdieselFual
        contdieselFual.setBoundEditor(txtdieselFual);
        //continitPersonQty
        continitPersonQty.setBoundEditor(txtinitPersonQty);
        //contleavePersonQty
        contleavePersonQty.setBoundEditor(txtleavePersonQty);
        //contentryPersonQty
        contentryPersonQty.setBoundEditor(txtentryPersonQty);
        //contattendPersonQty
        contattendPersonQty.setBoundEditor(txtattendPersonQty);
        //contbreedBatch
        contbreedBatch.setBoundEditor(prmtbreedBatch);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contfarm
        contfarm.setBoundEditor(prmtfarm);
        //contfarmer
        contfarmer.setBoundEditor(prmtfarmer);
        //contweek
        contweek.setBoundEditor(txtweek);
        //contday
        contday.setBoundEditor(txtday);
        //contconfirmTime
        contconfirmTime.setBoundEditor(pkconfirmTime);

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
        this.toolBar.add(btnPCVoucher);
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnDelPCVoucher);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(btnNextPerson);
        this.toolBar.add(btnGenNextBill);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("isHenhouseEmpty", boolean.class, this.chkisHenhouseEmpty, "selected");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.breed.business.CommecialChilkenDailyEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.material", java.lang.Object.class, this.kdtEntrys, "material.text");
		dataBinder.registerBinding("entrys.materialName", String.class, this.kdtEntrys, "materialName.text");
		dataBinder.registerBinding("entrys.dailyQtyAll", java.math.BigDecimal.class, this.kdtEntrys, "dailyQtyAll.text");
		dataBinder.registerBinding("entrys.henhouse", java.lang.Object.class, this.kdtEntrys, "henhouse.text");
		dataBinder.registerBinding("entrys.waterQty", java.math.BigDecimal.class, this.kdtEntrys, "waterQty.text");
		dataBinder.registerBinding("entrys.henhouseName", String.class, this.kdtEntrys, "henhouseName.text");
		dataBinder.registerBinding("entrys.days", int.class, this.kdtEntrys, "days.text");
		dataBinder.registerBinding("entrys.averageWeight", java.math.BigDecimal.class, this.kdtEntrys, "averageWeight.text");
		dataBinder.registerBinding("entrys.standardFeedQty", java.math.BigDecimal.class, this.kdtEntrys, "standardFeedQty.text");
		dataBinder.registerBinding("entrys.materialModel", String.class, this.kdtEntrys, "materialModel.text");
		dataBinder.registerBinding("AssEntrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtAssEntrys, "id.text");
		dataBinder.registerBinding("AssEntrys", com.kingdee.eas.farm.breed.business.CommecialChilkenDailyAssEntryInfo.class, this.kdtAssEntrys, "userObject");
		dataBinder.registerBinding("AssEntrys.breedTime", java.math.BigDecimal.class, this.kdtAssEntrys, "breedTime.text");
		dataBinder.registerBinding("AssEntrys.lightingTime", java.math.BigDecimal.class, this.kdtAssEntrys, "lightingTime.text");
		dataBinder.registerBinding("AssEntrys.temperatureTo", java.math.BigDecimal.class, this.kdtAssEntrys, "temperatureTo.text");
		dataBinder.registerBinding("AssEntrys.temperatureFrom", java.math.BigDecimal.class, this.kdtAssEntrys, "temperatureFrom.text");
		dataBinder.registerBinding("AssEntrys.humidityTo", java.math.BigDecimal.class, this.kdtAssEntrys, "humidityTo.text");
		dataBinder.registerBinding("AssEntrys.humidityFrom", java.math.BigDecimal.class, this.kdtAssEntrys, "humidityFrom.text");
		dataBinder.registerBinding("AssEntrys.cullAndDeath", int.class, this.kdtAssEntrys, "cullAndDeath.text");
		dataBinder.registerBinding("AssEntrys.henhouse", java.lang.Object.class, this.kdtAssEntrys, "henhouse.text");
		dataBinder.registerBinding("AssEntrys.henhouseName", String.class, this.kdtAssEntrys, "henhouseName.text");
		dataBinder.registerBinding("AssEntrys.days", int.class, this.kdtAssEntrys, "days.text");
		dataBinder.registerBinding("AssEntrys.breedingStock", int.class, this.kdtAssEntrys, "breedingStock.text");
		dataBinder.registerBinding("AssEntrys.isMarketed", boolean.class, this.kdtAssEntrys, "isMarketed.text");
		dataBinder.registerBinding("AssEntrys.marketQty", int.class, this.kdtAssEntrys, "marketQty.text");
		dataBinder.registerBinding("AssEntrys.transQty", int.class, this.kdtAssEntrys, "transQty.text");
		dataBinder.registerBinding("ImmuneEntrys.seq", int.class, this.kdtImmuneEntrys, "seq.text");
		dataBinder.registerBinding("ImmuneEntrys", com.kingdee.eas.farm.breed.business.CommecialChilkenDailyImmuneEntryInfo.class, this.kdtImmuneEntrys, "userObject");
		dataBinder.registerBinding("ImmuneEntrys.vaccineMaterial", java.lang.Object.class, this.kdtImmuneEntrys, "vaccineMaterial.text");
		dataBinder.registerBinding("ImmuneEntrys.vaccineGetQty", java.math.BigDecimal.class, this.kdtImmuneEntrys, "vaccineGetQty.text");
		dataBinder.registerBinding("ImmuneEntrys.vaccineUsedQty", java.math.BigDecimal.class, this.kdtImmuneEntrys, "vaccineUsedQty.text");
		dataBinder.registerBinding("ImmuneEntrys.henhouse", java.lang.Object.class, this.kdtImmuneEntrys, "henhouse.text");
		dataBinder.registerBinding("ImmuneEntrys.henhouseName", String.class, this.kdtImmuneEntrys, "henhouseName.text");
		dataBinder.registerBinding("ImmuneEntrys.days", int.class, this.kdtImmuneEntrys, "days.text");
		dataBinder.registerBinding("ImmuneEntrys.vaccineUnit", String.class, this.kdtImmuneEntrys, "vaccineUnit.text");
		dataBinder.registerBinding("FodderPlanEntrys.seq", int.class, this.kdtFodderPlanEntrys, "seq.text");
		dataBinder.registerBinding("FodderPlanEntrys", com.kingdee.eas.farm.breed.business.CommecialChilkenDailyFodderPlanEntryInfo.class, this.kdtFodderPlanEntrys, "userObject");
		dataBinder.registerBinding("FodderPlanEntrys.fodderDate", java.util.Date.class, this.kdtFodderPlanEntrys, "fodderDate.text");
		dataBinder.registerBinding("FodderPlanEntrys.fodderQty", java.math.BigDecimal.class, this.kdtFodderPlanEntrys, "fodderQty.text");
		dataBinder.registerBinding("FodderPlanEntrys.fodderDesc", String.class, this.kdtFodderPlanEntrys, "fodderDesc.text");
		dataBinder.registerBinding("FodderPlanEntrys.fodderTower", java.lang.Object.class, this.kdtFodderPlanEntrys, "fodderTower.text");
		dataBinder.registerBinding("FodderPlanEntrys.fodderMaterial", java.lang.Object.class, this.kdtFodderPlanEntrys, "fodderMaterial.text");
		dataBinder.registerBinding("FodderPlanEntrys.fodderMaterialName", String.class, this.kdtFodderPlanEntrys, "fodderMaterialName.text");
		dataBinder.registerBinding("FodderPlanEntrys.fodderMaterialModel", String.class, this.kdtFodderPlanEntrys, "fodderMaterialModel.text");
		dataBinder.registerBinding("FodderPlanEntrys.flodderTowerName", String.class, this.kdtFodderPlanEntrys, "flodderTowerName.text");
		dataBinder.registerBinding("FodderPlanEntrys.TowerInventory", java.math.BigDecimal.class, this.kdtFodderPlanEntrys, "TowerInventory.text");
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
		dataBinder.registerBinding("days", int.class, this.txtdays, "value");
		dataBinder.registerBinding("coalFual", java.math.BigDecimal.class, this.txtcoalFual, "value");
		dataBinder.registerBinding("dieselFual", java.math.BigDecimal.class, this.txtdieselFual, "value");
		dataBinder.registerBinding("initPersonQty", int.class, this.txtinitPersonQty, "value");
		dataBinder.registerBinding("leavePersonQty", int.class, this.txtleavePersonQty, "value");
		dataBinder.registerBinding("entryPersonQty", int.class, this.txtentryPersonQty, "value");
		dataBinder.registerBinding("attendPersonQty", int.class, this.txtattendPersonQty, "value");
		dataBinder.registerBinding("breedBatch", com.kingdee.eas.farm.carnivorous.basedata.BatchInfo.class, this.prmtbreedBatch, "data");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("farm", com.kingdee.eas.farm.carnivorous.basedata.FarmInfo.class, this.prmtfarm, "data");
		dataBinder.registerBinding("farmer", com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo.class, this.prmtfarmer, "data");
		dataBinder.registerBinding("week", int.class, this.txtweek, "value");
		dataBinder.registerBinding("day", int.class, this.txtday, "value");
		dataBinder.registerBinding("confirmTime", java.util.Date.class, this.pkconfirmTime, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.breed.business.app.CommecialChilkenDailyEditUIHandler";
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
        this.kDDateLastUpdateTime.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.breed.business.CommecialChilkenDailyInfo)ov;
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
		getValidateHelper().registerBindProperty("isHenhouseEmpty", ValidateHelper.ON_SAVE);    
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
		getValidateHelper().registerBindProperty("entrys.henhouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.waterQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.henhouseName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.days", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.averageWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.standardFeedQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.materialModel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.breedTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.lightingTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.temperatureTo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.temperatureFrom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.humidityTo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.humidityFrom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.cullAndDeath", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.henhouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.henhouseName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.days", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.breedingStock", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.isMarketed", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.marketQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.transQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.vaccineMaterial", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.vaccineGetQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.vaccineUsedQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.henhouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.henhouseName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.days", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.vaccineUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderPlanEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderPlanEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderPlanEntrys.fodderDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderPlanEntrys.fodderQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderPlanEntrys.fodderDesc", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderPlanEntrys.fodderTower", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderPlanEntrys.fodderMaterial", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderPlanEntrys.fodderMaterialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderPlanEntrys.fodderMaterialModel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderPlanEntrys.flodderTowerName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FodderPlanEntrys.TowerInventory", ValidateHelper.ON_SAVE);    
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
		getValidateHelper().registerBindProperty("days", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("coalFual", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dieselFual", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("initPersonQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("leavePersonQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entryPersonQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("attendPersonQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("week", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("day", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("confirmTime", ValidateHelper.ON_SAVE);    		
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
            if ("henhouse".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"henhouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"henhouse").getValue(),"warehouse.name")));

}

    if ("henhouse".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"henhouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"henhouse").getValue(),"warehouse.name")));

}

    if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"materialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"material").getValue(),"name")));

}

    if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"materialModel").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"material").getValue(),"model")));

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
     * output kdtFodderPlanEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtFodderPlanEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("fodderTower".equalsIgnoreCase(kdtFodderPlanEntrys.getColumn(colIndex).getKey())) {
kdtFodderPlanEntrys.getCell(rowIndex,"flodderTowerName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtFodderPlanEntrys.getCell(rowIndex,"fodderTower").getValue(),"name")));

}

    if ("fodderMaterial".equalsIgnoreCase(kdtFodderPlanEntrys.getColumn(colIndex).getKey())) {
kdtFodderPlanEntrys.getCell(rowIndex,"fodderMaterialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtFodderPlanEntrys.getCell(rowIndex,"fodderMaterial").getValue(),"name")));

}

    if ("fodderMaterial".equalsIgnoreCase(kdtFodderPlanEntrys.getColumn(colIndex).getKey())) {
kdtFodderPlanEntrys.getCell(rowIndex,"fodderMaterialModel").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtFodderPlanEntrys.getCell(rowIndex,"fodderMaterial").getValue(),"model")));

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
        sic.add(new SelectorItemInfo("isHenhouseEmpty"));
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.henhouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.henhouse.id"));
			sic.add(new SelectorItemInfo("entrys.henhouse.number"));
			sic.add(new SelectorItemInfo("entrys.henhouse.name"));
		}
    	sic.add(new SelectorItemInfo("entrys.waterQty"));
    	sic.add(new SelectorItemInfo("entrys.henhouseName"));
    	sic.add(new SelectorItemInfo("entrys.days"));
    	sic.add(new SelectorItemInfo("entrys.averageWeight"));
    	sic.add(new SelectorItemInfo("entrys.standardFeedQty"));
    	sic.add(new SelectorItemInfo("entrys.materialModel"));
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
    	sic.add(new SelectorItemInfo("AssEntrys.cullAndDeath"));
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
    	sic.add(new SelectorItemInfo("AssEntrys.days"));
    	sic.add(new SelectorItemInfo("AssEntrys.breedingStock"));
    	sic.add(new SelectorItemInfo("AssEntrys.isMarketed"));
    	sic.add(new SelectorItemInfo("AssEntrys.marketQty"));
    	sic.add(new SelectorItemInfo("AssEntrys.transQty"));
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
    	sic.add(new SelectorItemInfo("ImmuneEntrys.days"));
    	sic.add(new SelectorItemInfo("ImmuneEntrys.vaccineUnit"));
    	sic.add(new SelectorItemInfo("FodderPlanEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FodderPlanEntrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("FodderPlanEntrys.fodderDate"));
    	sic.add(new SelectorItemInfo("FodderPlanEntrys.fodderQty"));
    	sic.add(new SelectorItemInfo("FodderPlanEntrys.fodderDesc"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FodderPlanEntrys.fodderTower.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("FodderPlanEntrys.fodderTower.id"));
			sic.add(new SelectorItemInfo("FodderPlanEntrys.fodderTower.name"));
        	sic.add(new SelectorItemInfo("FodderPlanEntrys.fodderTower.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FodderPlanEntrys.fodderMaterial.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("FodderPlanEntrys.fodderMaterial.id"));
			sic.add(new SelectorItemInfo("FodderPlanEntrys.fodderMaterial.name"));
        	sic.add(new SelectorItemInfo("FodderPlanEntrys.fodderMaterial.number"));
		}
    	sic.add(new SelectorItemInfo("FodderPlanEntrys.fodderMaterialName"));
    	sic.add(new SelectorItemInfo("FodderPlanEntrys.fodderMaterialModel"));
    	sic.add(new SelectorItemInfo("FodderPlanEntrys.flodderTowerName"));
    	sic.add(new SelectorItemInfo("FodderPlanEntrys.TowerInventory"));
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
        sic.add(new SelectorItemInfo("days"));
        sic.add(new SelectorItemInfo("coalFual"));
        sic.add(new SelectorItemInfo("dieselFual"));
        sic.add(new SelectorItemInfo("initPersonQty"));
        sic.add(new SelectorItemInfo("leavePersonQty"));
        sic.add(new SelectorItemInfo("entryPersonQty"));
        sic.add(new SelectorItemInfo("attendPersonQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("breedBatch.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("breedBatch.id"));
        	sic.add(new SelectorItemInfo("breedBatch.number"));
        	sic.add(new SelectorItemInfo("breedBatch.name"));
		}
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
			sic.add(new SelectorItemInfo("farm.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farm.id"));
        	sic.add(new SelectorItemInfo("farm.number"));
        	sic.add(new SelectorItemInfo("farm.name"));
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
        sic.add(new SelectorItemInfo("week"));
        sic.add(new SelectorItemInfo("day"));
        sic.add(new SelectorItemInfo("confirmTime"));
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
        com.kingdee.eas.farm.breed.business.CommecialChilkenDailyFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.breed.business.CommecialChilkenDailyFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionGenNextBill_actionPerformed method
     */
    public void actionGenNextBill_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.breed.business.CommecialChilkenDailyFactory.getRemoteInstance().genNextBill(editData);
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
            innerActionPerformed("eas", AbstractCommecialChilkenDailyEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractCommecialChilkenDailyEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractCommecialChilkenDailyEditUI.this, "ActionGenNextBill", "actionGenNextBill_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.breed.business.client", "CommecialChilkenDailyEditUI");
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
        return com.kingdee.eas.farm.breed.business.client.CommecialChilkenDailyEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.breed.business.CommecialChilkenDailyFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.breed.business.CommecialChilkenDailyInfo objectValue = new com.kingdee.eas.farm.breed.business.CommecialChilkenDailyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/breed/business/CommecialChilkenDaily";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.breed.business.app.CommecialChilkenDailyQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"material").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"饲料"});
			}
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
		for (int i=0,n=kdtFodderPlanEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtFodderPlanEntrys.getCell(i,"fodderTower").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"料塔"});
			}
		}
		for (int i=0,n=kdtFodderPlanEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtFodderPlanEntrys.getCell(i,"TowerInventory").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"当前剩余库存(公斤)"});
			}
		}
		for (int i=0,n=kdtFodderPlanEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtFodderPlanEntrys.getCell(i,"fodderMaterial").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"饲料"});
			}
		}
		for (int i=0,n=kdtFodderPlanEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtFodderPlanEntrys.getCell(i,"fodderDate").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"要料日期"});
			}
		}
		for (int i=0,n=kdtFodderPlanEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtFodderPlanEntrys.getCell(i,"fodderQty").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"数量(公斤)"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(baseStatus.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"状态"});
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
			setTableToSumField(kdtAssEntrys,new String[] {"cullAndDeath","breedingStock","marketQty"});
			setTableToSumField(kdtFodderPlanEntrys,new String[] {"fodderQty"});
		}


}