/**
 * output package name
 */
package com.kingdee.eas.farm.pig.ccpig.client;

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
public abstract class AbstractCCPigDailyEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCCPigDailyEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel6;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpigBatch;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtLiveStockEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtLiveStockEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contwarn;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnPotion;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel5;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel8;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel7;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtFeedDetailEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtFeedDetailEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtImmuneEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtImmuneEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtImmuneDetailEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtImmuneDetailEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtDCEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtDCEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtDeathEarNumberEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtDeathEarNumberEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtCullEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtCullEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtCullEarNumberEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtCullEarNumberEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtOutEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtOutEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtOutEarNumberEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtOutEarNumberEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEnviConEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEnviConEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedLog;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane scrollPanebreedLog;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtbreedLog;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweather;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoutHumidityTo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoutHumidityFrom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoutTemperatureTo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoutTemperatureFrom;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtweather;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoutHumidityTo;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoutHumidityFrom;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoutTemperatureTo;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoutTemperatureFrom;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpigBatch;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarm;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane scrollPanewarn;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtwarn;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.farm.pig.ccpig.CCPigDailyInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractCCPigDailyEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCCPigDailyEditUI.class.getName());
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
        this.actionAudit.setExtendProperty("userDefined", "true");
        this.actionAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionUnAudit
        this.actionUnAudit = new ActionUnAudit(this);
        getActionManager().registerAction("actionUnAudit", actionUnAudit);
        this.actionUnAudit.setExtendProperty("canForewarn", "true");
        this.actionUnAudit.setExtendProperty("userDefined", "true");
        this.actionUnAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDPanel6 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contpigBatch = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtLiveStockEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contfarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contwarn = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnPotion = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel5 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel8 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel7 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtFeedDetailEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtImmuneEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtImmuneDetailEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtDCEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtDeathEarNumberEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtCullEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtCullEarNumberEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtOutEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtOutEarNumberEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtEnviConEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contbreedLog = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.scrollPanebreedLog = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txtbreedLog = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.contweather = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoutHumidityTo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoutHumidityFrom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoutTemperatureTo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoutTemperatureFrom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtweather = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtoutHumidityTo = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtoutHumidityFrom = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtoutTemperatureTo = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtoutTemperatureFrom = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtpigBatch = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtfarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.scrollPanewarn = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txtwarn = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contauditTime.setName("contauditTime");
        this.contbaseStatus.setName("contbaseStatus");
        this.kDPanel6.setName("kDPanel6");
        this.contpigBatch.setName("contpigBatch");
        this.kdtLiveStockEntrys.setName("kdtLiveStockEntrys");
        this.contfarm.setName("contfarm");
        this.contwarn.setName("contwarn");
        this.btnPotion.setName("btnPotion");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel5.setName("kDPanel5");
        this.kDPanel8.setName("kDPanel8");
        this.kDPanel7.setName("kDPanel7");
        this.kDPanel3.setName("kDPanel3");
        this.kDPanel4.setName("kDPanel4");
        this.kdtEntrys.setName("kdtEntrys");
        this.kdtFeedDetailEntry.setName("kdtFeedDetailEntry");
        this.kdtImmuneEntrys.setName("kdtImmuneEntrys");
        this.kdtImmuneDetailEntry.setName("kdtImmuneDetailEntry");
        this.kdtDCEntrys.setName("kdtDCEntrys");
        this.kdtDeathEarNumberEntrys.setName("kdtDeathEarNumberEntrys");
        this.kdtCullEntrys.setName("kdtCullEntrys");
        this.kdtCullEarNumberEntrys.setName("kdtCullEarNumberEntrys");
        this.kdtOutEntrys.setName("kdtOutEntrys");
        this.kdtOutEarNumberEntrys.setName("kdtOutEarNumberEntrys");
        this.kdtEnviConEntry.setName("kdtEnviConEntry");
        this.contbreedLog.setName("contbreedLog");
        this.scrollPanebreedLog.setName("scrollPanebreedLog");
        this.txtbreedLog.setName("txtbreedLog");
        this.pkauditTime.setName("pkauditTime");
        this.baseStatus.setName("baseStatus");
        this.contweather.setName("contweather");
        this.contoutHumidityTo.setName("contoutHumidityTo");
        this.contoutHumidityFrom.setName("contoutHumidityFrom");
        this.contoutTemperatureTo.setName("contoutTemperatureTo");
        this.contoutTemperatureFrom.setName("contoutTemperatureFrom");
        this.txtweather.setName("txtweather");
        this.txtoutHumidityTo.setName("txtoutHumidityTo");
        this.txtoutHumidityFrom.setName("txtoutHumidityFrom");
        this.txtoutTemperatureTo.setName("txtoutTemperatureTo");
        this.txtoutTemperatureFrom.setName("txtoutTemperatureFrom");
        this.prmtpigBatch.setName("prmtpigBatch");
        this.prmtfarm.setName("prmtfarm");
        this.scrollPanewarn.setName("scrollPanewarn");
        this.txtwarn.setName("txtwarn");
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
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);
        // kDTabbedPane1
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);
        // kDPanel6		
        this.kDPanel6.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel6.border.title")));
        // contpigBatch		
        this.contpigBatch.setBoundLabelText(resHelper.getString("contpigBatch.boundLabelText"));		
        this.contpigBatch.setBoundLabelLength(100);		
        this.contpigBatch.setBoundLabelUnderline(true);		
        this.contpigBatch.setVisible(true);
        // kdtLiveStockEntrys
		String kdtLiveStockEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sTable\"><c:Alignment horizontal=\"left\" /><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\" t:styleID=\"sTable\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"pigHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"days\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"stockQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"culldeathQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"outQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"endStock\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"cullQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"deathQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{pigHouse}</t:Cell><t:Cell>$Resource{days}</t:Cell><t:Cell>$Resource{stockQty}</t:Cell><t:Cell>$Resource{culldeathQty}</t:Cell><t:Cell>$Resource{outQty}</t:Cell><t:Cell>$Resource{endStock}</t:Cell><t:Cell>$Resource{cullQty}</t:Cell><t:Cell>$Resource{deathQty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtLiveStockEntrys.setFormatXml(resHelper.translateString("kdtLiveStockEntrys",kdtLiveStockEntrysStrXML));

                this.kdtLiveStockEntrys.putBindContents("editData",new String[] {"seq","pigHouse","days","stockQty","culldeathQty","outQty","endStock","cullQty","deathQty"});


        this.kdtLiveStockEntrys.checkParsed();
        KDFormattedTextField kdtLiveStockEntrys_seq_TextField = new KDFormattedTextField();
        kdtLiveStockEntrys_seq_TextField.setName("kdtLiveStockEntrys_seq_TextField");
        kdtLiveStockEntrys_seq_TextField.setVisible(true);
        kdtLiveStockEntrys_seq_TextField.setEditable(true);
        kdtLiveStockEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtLiveStockEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtLiveStockEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtLiveStockEntrys_seq_TextField);
        this.kdtLiveStockEntrys.getColumn("seq").setEditor(kdtLiveStockEntrys_seq_CellEditor);
        final KDBizPromptBox kdtLiveStockEntrys_pigHouse_PromptBox = new KDBizPromptBox();
        kdtLiveStockEntrys_pigHouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.pig.app.PigHouseF7Query");
        kdtLiveStockEntrys_pigHouse_PromptBox.setVisible(true);
        kdtLiveStockEntrys_pigHouse_PromptBox.setEditable(true);
        kdtLiveStockEntrys_pigHouse_PromptBox.setDisplayFormat("$number$");
        kdtLiveStockEntrys_pigHouse_PromptBox.setEditFormat("$number$");
        kdtLiveStockEntrys_pigHouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtLiveStockEntrys_pigHouse_CellEditor = new KDTDefaultCellEditor(kdtLiveStockEntrys_pigHouse_PromptBox);
        this.kdtLiveStockEntrys.getColumn("pigHouse").setEditor(kdtLiveStockEntrys_pigHouse_CellEditor);
        ObjectValueRender kdtLiveStockEntrys_pigHouse_OVR = new ObjectValueRender();
        kdtLiveStockEntrys_pigHouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtLiveStockEntrys.getColumn("pigHouse").setRenderer(kdtLiveStockEntrys_pigHouse_OVR);
        			kdtLiveStockEntrys_pigHouse_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.pig.client.PigHouseListUI kdtLiveStockEntrys_pigHouse_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtLiveStockEntrys_pigHouse_PromptBox_F7ListUI == null) {
					try {
						kdtLiveStockEntrys_pigHouse_PromptBox_F7ListUI = new com.kingdee.eas.farm.pig.client.PigHouseListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtLiveStockEntrys_pigHouse_PromptBox_F7ListUI));
					kdtLiveStockEntrys_pigHouse_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtLiveStockEntrys_pigHouse_PromptBox.setSelector(kdtLiveStockEntrys_pigHouse_PromptBox_F7ListUI);
				}
			}
		});
					
        KDFormattedTextField kdtLiveStockEntrys_days_TextField = new KDFormattedTextField();
        kdtLiveStockEntrys_days_TextField.setName("kdtLiveStockEntrys_days_TextField");
        kdtLiveStockEntrys_days_TextField.setVisible(true);
        kdtLiveStockEntrys_days_TextField.setEditable(true);
        kdtLiveStockEntrys_days_TextField.setHorizontalAlignment(2);
        kdtLiveStockEntrys_days_TextField.setDataType(0);
        KDTDefaultCellEditor kdtLiveStockEntrys_days_CellEditor = new KDTDefaultCellEditor(kdtLiveStockEntrys_days_TextField);
        this.kdtLiveStockEntrys.getColumn("days").setEditor(kdtLiveStockEntrys_days_CellEditor);
        KDFormattedTextField kdtLiveStockEntrys_stockQty_TextField = new KDFormattedTextField();
        kdtLiveStockEntrys_stockQty_TextField.setName("kdtLiveStockEntrys_stockQty_TextField");
        kdtLiveStockEntrys_stockQty_TextField.setVisible(true);
        kdtLiveStockEntrys_stockQty_TextField.setEditable(true);
        kdtLiveStockEntrys_stockQty_TextField.setHorizontalAlignment(2);
        kdtLiveStockEntrys_stockQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtLiveStockEntrys_stockQty_CellEditor = new KDTDefaultCellEditor(kdtLiveStockEntrys_stockQty_TextField);
        this.kdtLiveStockEntrys.getColumn("stockQty").setEditor(kdtLiveStockEntrys_stockQty_CellEditor);
        KDFormattedTextField kdtLiveStockEntrys_culldeathQty_TextField = new KDFormattedTextField();
        kdtLiveStockEntrys_culldeathQty_TextField.setName("kdtLiveStockEntrys_culldeathQty_TextField");
        kdtLiveStockEntrys_culldeathQty_TextField.setVisible(true);
        kdtLiveStockEntrys_culldeathQty_TextField.setEditable(true);
        kdtLiveStockEntrys_culldeathQty_TextField.setHorizontalAlignment(2);
        kdtLiveStockEntrys_culldeathQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtLiveStockEntrys_culldeathQty_CellEditor = new KDTDefaultCellEditor(kdtLiveStockEntrys_culldeathQty_TextField);
        this.kdtLiveStockEntrys.getColumn("culldeathQty").setEditor(kdtLiveStockEntrys_culldeathQty_CellEditor);
        KDFormattedTextField kdtLiveStockEntrys_outQty_TextField = new KDFormattedTextField();
        kdtLiveStockEntrys_outQty_TextField.setName("kdtLiveStockEntrys_outQty_TextField");
        kdtLiveStockEntrys_outQty_TextField.setVisible(true);
        kdtLiveStockEntrys_outQty_TextField.setEditable(true);
        kdtLiveStockEntrys_outQty_TextField.setHorizontalAlignment(2);
        kdtLiveStockEntrys_outQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtLiveStockEntrys_outQty_CellEditor = new KDTDefaultCellEditor(kdtLiveStockEntrys_outQty_TextField);
        this.kdtLiveStockEntrys.getColumn("outQty").setEditor(kdtLiveStockEntrys_outQty_CellEditor);
        KDFormattedTextField kdtLiveStockEntrys_endStock_TextField = new KDFormattedTextField();
        kdtLiveStockEntrys_endStock_TextField.setName("kdtLiveStockEntrys_endStock_TextField");
        kdtLiveStockEntrys_endStock_TextField.setVisible(true);
        kdtLiveStockEntrys_endStock_TextField.setEditable(true);
        kdtLiveStockEntrys_endStock_TextField.setHorizontalAlignment(2);
        kdtLiveStockEntrys_endStock_TextField.setDataType(0);
        KDTDefaultCellEditor kdtLiveStockEntrys_endStock_CellEditor = new KDTDefaultCellEditor(kdtLiveStockEntrys_endStock_TextField);
        this.kdtLiveStockEntrys.getColumn("endStock").setEditor(kdtLiveStockEntrys_endStock_CellEditor);
        KDFormattedTextField kdtLiveStockEntrys_cullQty_TextField = new KDFormattedTextField();
        kdtLiveStockEntrys_cullQty_TextField.setName("kdtLiveStockEntrys_cullQty_TextField");
        kdtLiveStockEntrys_cullQty_TextField.setVisible(true);
        kdtLiveStockEntrys_cullQty_TextField.setEditable(true);
        kdtLiveStockEntrys_cullQty_TextField.setHorizontalAlignment(2);
        kdtLiveStockEntrys_cullQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtLiveStockEntrys_cullQty_CellEditor = new KDTDefaultCellEditor(kdtLiveStockEntrys_cullQty_TextField);
        this.kdtLiveStockEntrys.getColumn("cullQty").setEditor(kdtLiveStockEntrys_cullQty_CellEditor);
        KDFormattedTextField kdtLiveStockEntrys_deathQty_TextField = new KDFormattedTextField();
        kdtLiveStockEntrys_deathQty_TextField.setName("kdtLiveStockEntrys_deathQty_TextField");
        kdtLiveStockEntrys_deathQty_TextField.setVisible(true);
        kdtLiveStockEntrys_deathQty_TextField.setEditable(true);
        kdtLiveStockEntrys_deathQty_TextField.setHorizontalAlignment(2);
        kdtLiveStockEntrys_deathQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtLiveStockEntrys_deathQty_CellEditor = new KDTDefaultCellEditor(kdtLiveStockEntrys_deathQty_TextField);
        this.kdtLiveStockEntrys.getColumn("deathQty").setEditor(kdtLiveStockEntrys_deathQty_CellEditor);
        // contfarm		
        this.contfarm.setBoundLabelText(resHelper.getString("contfarm.boundLabelText"));		
        this.contfarm.setBoundLabelLength(100);		
        this.contfarm.setBoundLabelUnderline(true);		
        this.contfarm.setVisible(true);
        // contwarn		
        this.contwarn.setBoundLabelText(resHelper.getString("contwarn.boundLabelText"));		
        this.contwarn.setBoundLabelLength(100);		
        this.contwarn.setBoundLabelUnderline(true);		
        this.contwarn.setVisible(true);		
        this.contwarn.setForeground(new java.awt.Color(0,0,0));
        // btnPotion		
        this.btnPotion.setText(resHelper.getString("btnPotion.text"));		
        this.btnPotion.setFont(resHelper.getFont("btnPotion.font"));		
        this.btnPotion.setForeground(new java.awt.Color(255,0,0));		
        this.btnPotion.setVisible(false);
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
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // kDPanel1
        // kDPanel2
        // kDPanel5
        // kDPanel8
        // kDPanel7
        // kDPanel3
        // kDPanel4
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"pigHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"materialName\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"standardQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"actualQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{pigHouse}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{standardQty}</t:Cell><t:Cell>$Resource{actualQty}</t:Cell><t:Cell>$Resource{remark}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtEntrys.putBindContents("editData",new String[] {"id","pigHouse","material","materialName","standardQty","actualQty","remark"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_pigHouse_PromptBox = new KDBizPromptBox();
        kdtEntrys_pigHouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.pig.app.PigHouseF7Query");
        kdtEntrys_pigHouse_PromptBox.setVisible(true);
        kdtEntrys_pigHouse_PromptBox.setEditable(true);
        kdtEntrys_pigHouse_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_pigHouse_PromptBox.setEditFormat("$number$");
        kdtEntrys_pigHouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_pigHouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_pigHouse_PromptBox);
        this.kdtEntrys.getColumn("pigHouse").setEditor(kdtEntrys_pigHouse_CellEditor);
        ObjectValueRender kdtEntrys_pigHouse_OVR = new ObjectValueRender();
        kdtEntrys_pigHouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("pigHouse").setRenderer(kdtEntrys_pigHouse_OVR);
        			kdtEntrys_pigHouse_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.pig.client.PigHouseListUI kdtEntrys_pigHouse_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_pigHouse_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_pigHouse_PromptBox_F7ListUI = new com.kingdee.eas.farm.pig.client.PigHouseListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_pigHouse_PromptBox_F7ListUI));
					kdtEntrys_pigHouse_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_pigHouse_PromptBox.setSelector(kdtEntrys_pigHouse_PromptBox_F7ListUI);
				}
			}
		});
					
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
        KDFormattedTextField kdtEntrys_standardQty_TextField = new KDFormattedTextField();
        kdtEntrys_standardQty_TextField.setName("kdtEntrys_standardQty_TextField");
        kdtEntrys_standardQty_TextField.setVisible(true);
        kdtEntrys_standardQty_TextField.setEditable(true);
        kdtEntrys_standardQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_standardQty_TextField.setDataType(1);
        	kdtEntrys_standardQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_standardQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_standardQty_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_standardQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_standardQty_TextField);
        this.kdtEntrys.getColumn("standardQty").setEditor(kdtEntrys_standardQty_CellEditor);
        KDFormattedTextField kdtEntrys_actualQty_TextField = new KDFormattedTextField();
        kdtEntrys_actualQty_TextField.setName("kdtEntrys_actualQty_TextField");
        kdtEntrys_actualQty_TextField.setVisible(true);
        kdtEntrys_actualQty_TextField.setEditable(true);
        kdtEntrys_actualQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_actualQty_TextField.setDataType(1);
        	kdtEntrys_actualQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_actualQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_actualQty_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_actualQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_actualQty_TextField);
        this.kdtEntrys.getColumn("actualQty").setEditor(kdtEntrys_actualQty_CellEditor);
        KDTextField kdtEntrys_remark_TextField = new KDTextField();
        kdtEntrys_remark_TextField.setName("kdtEntrys_remark_TextField");
        kdtEntrys_remark_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_remark_CellEditor = new KDTDefaultCellEditor(kdtEntrys_remark_TextField);
        this.kdtEntrys.getColumn("remark").setEditor(kdtEntrys_remark_CellEditor);
        // kdtFeedDetailEntry
		String kdtFeedDetailEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"pigNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"feedQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{pigNumber}</t:Cell><t:Cell>$Resource{feedQty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtFeedDetailEntry.setFormatXml(resHelper.translateString("kdtFeedDetailEntry",kdtFeedDetailEntryStrXML));

                this.kdtFeedDetailEntry.putBindContents("editData",new String[] {"FeedDetailEntry.seq","FeedDetailEntry.pigNumber","FeedDetailEntry.feedQty"});


        this.kdtFeedDetailEntry.checkParsed();
        KDFormattedTextField kdtFeedDetailEntry_seq_TextField = new KDFormattedTextField();
        kdtFeedDetailEntry_seq_TextField.setName("kdtFeedDetailEntry_seq_TextField");
        kdtFeedDetailEntry_seq_TextField.setVisible(true);
        kdtFeedDetailEntry_seq_TextField.setEditable(true);
        kdtFeedDetailEntry_seq_TextField.setHorizontalAlignment(2);
        kdtFeedDetailEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtFeedDetailEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtFeedDetailEntry_seq_TextField);
        this.kdtFeedDetailEntry.getColumn("seq").setEditor(kdtFeedDetailEntry_seq_CellEditor);
        KDTextField kdtFeedDetailEntry_pigNumber_TextField = new KDTextField();
        kdtFeedDetailEntry_pigNumber_TextField.setName("kdtFeedDetailEntry_pigNumber_TextField");
        kdtFeedDetailEntry_pigNumber_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtFeedDetailEntry_pigNumber_CellEditor = new KDTDefaultCellEditor(kdtFeedDetailEntry_pigNumber_TextField);
        this.kdtFeedDetailEntry.getColumn("pigNumber").setEditor(kdtFeedDetailEntry_pigNumber_CellEditor);
        KDFormattedTextField kdtFeedDetailEntry_feedQty_TextField = new KDFormattedTextField();
        kdtFeedDetailEntry_feedQty_TextField.setName("kdtFeedDetailEntry_feedQty_TextField");
        kdtFeedDetailEntry_feedQty_TextField.setVisible(true);
        kdtFeedDetailEntry_feedQty_TextField.setEditable(true);
        kdtFeedDetailEntry_feedQty_TextField.setHorizontalAlignment(2);
        kdtFeedDetailEntry_feedQty_TextField.setDataType(1);
        	kdtFeedDetailEntry_feedQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtFeedDetailEntry_feedQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtFeedDetailEntry_feedQty_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtFeedDetailEntry_feedQty_CellEditor = new KDTDefaultCellEditor(kdtFeedDetailEntry_feedQty_TextField);
        this.kdtFeedDetailEntry.getColumn("feedQty").setEditor(kdtFeedDetailEntry_feedQty_CellEditor);
        // kdtImmuneEntrys
		String kdtImmuneEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"immuneSourceType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"pigHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"materialName\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"immuneMode\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{immuneSourceType}</t:Cell><t:Cell>$Resource{pigHouse}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{immuneMode}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{remark}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtImmuneEntrys.putBindContents("editData",new String[] {"seq","immuneSourceType","pigHouse","material","materialName","immuneMode","unit","qty","remark"});


        this.kdtImmuneEntrys.checkParsed();
        KDFormattedTextField kdtImmuneEntrys_seq_TextField = new KDFormattedTextField();
        kdtImmuneEntrys_seq_TextField.setName("kdtImmuneEntrys_seq_TextField");
        kdtImmuneEntrys_seq_TextField.setVisible(true);
        kdtImmuneEntrys_seq_TextField.setEditable(true);
        kdtImmuneEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtImmuneEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtImmuneEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_seq_TextField);
        this.kdtImmuneEntrys.getColumn("seq").setEditor(kdtImmuneEntrys_seq_CellEditor);
        KDComboBox kdtImmuneEntrys_immuneSourceType_ComboBox = new KDComboBox();
        kdtImmuneEntrys_immuneSourceType_ComboBox.setName("kdtImmuneEntrys_immuneSourceType_ComboBox");
        kdtImmuneEntrys_immuneSourceType_ComboBox.setVisible(true);
        kdtImmuneEntrys_immuneSourceType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.pig.immuneSourceType").toArray());
        KDTDefaultCellEditor kdtImmuneEntrys_immuneSourceType_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_immuneSourceType_ComboBox);
        this.kdtImmuneEntrys.getColumn("immuneSourceType").setEditor(kdtImmuneEntrys_immuneSourceType_CellEditor);
        final KDBizPromptBox kdtImmuneEntrys_pigHouse_PromptBox = new KDBizPromptBox();
        kdtImmuneEntrys_pigHouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.pig.app.PigHouseF7Query");
        kdtImmuneEntrys_pigHouse_PromptBox.setVisible(true);
        kdtImmuneEntrys_pigHouse_PromptBox.setEditable(true);
        kdtImmuneEntrys_pigHouse_PromptBox.setDisplayFormat("$number$");
        kdtImmuneEntrys_pigHouse_PromptBox.setEditFormat("$number$");
        kdtImmuneEntrys_pigHouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtImmuneEntrys_pigHouse_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_pigHouse_PromptBox);
        this.kdtImmuneEntrys.getColumn("pigHouse").setEditor(kdtImmuneEntrys_pigHouse_CellEditor);
        ObjectValueRender kdtImmuneEntrys_pigHouse_OVR = new ObjectValueRender();
        kdtImmuneEntrys_pigHouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtImmuneEntrys.getColumn("pigHouse").setRenderer(kdtImmuneEntrys_pigHouse_OVR);
        			kdtImmuneEntrys_pigHouse_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.pig.client.PigHouseListUI kdtImmuneEntrys_pigHouse_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtImmuneEntrys_pigHouse_PromptBox_F7ListUI == null) {
					try {
						kdtImmuneEntrys_pigHouse_PromptBox_F7ListUI = new com.kingdee.eas.farm.pig.client.PigHouseListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtImmuneEntrys_pigHouse_PromptBox_F7ListUI));
					kdtImmuneEntrys_pigHouse_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtImmuneEntrys_pigHouse_PromptBox.setSelector(kdtImmuneEntrys_pigHouse_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtImmuneEntrys_material_PromptBox = new KDBizPromptBox();
        kdtImmuneEntrys_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtImmuneEntrys_material_PromptBox.setVisible(true);
        kdtImmuneEntrys_material_PromptBox.setEditable(true);
        kdtImmuneEntrys_material_PromptBox.setDisplayFormat("$number$");
        kdtImmuneEntrys_material_PromptBox.setEditFormat("$number$");
        kdtImmuneEntrys_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtImmuneEntrys_material_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_material_PromptBox);
        this.kdtImmuneEntrys.getColumn("material").setEditor(kdtImmuneEntrys_material_CellEditor);
        ObjectValueRender kdtImmuneEntrys_material_OVR = new ObjectValueRender();
        kdtImmuneEntrys_material_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtImmuneEntrys.getColumn("material").setRenderer(kdtImmuneEntrys_material_OVR);
        KDTextField kdtImmuneEntrys_materialName_TextField = new KDTextField();
        kdtImmuneEntrys_materialName_TextField.setName("kdtImmuneEntrys_materialName_TextField");
        kdtImmuneEntrys_materialName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtImmuneEntrys_materialName_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_materialName_TextField);
        this.kdtImmuneEntrys.getColumn("materialName").setEditor(kdtImmuneEntrys_materialName_CellEditor);
        KDComboBox kdtImmuneEntrys_immuneMode_ComboBox = new KDComboBox();
        kdtImmuneEntrys_immuneMode_ComboBox.setName("kdtImmuneEntrys_immuneMode_ComboBox");
        kdtImmuneEntrys_immuneMode_ComboBox.setVisible(true);
        kdtImmuneEntrys_immuneMode_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.pig.ImmuneMode").toArray());
        KDTDefaultCellEditor kdtImmuneEntrys_immuneMode_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_immuneMode_ComboBox);
        this.kdtImmuneEntrys.getColumn("immuneMode").setEditor(kdtImmuneEntrys_immuneMode_CellEditor);
        KDTextField kdtImmuneEntrys_unit_TextField = new KDTextField();
        kdtImmuneEntrys_unit_TextField.setName("kdtImmuneEntrys_unit_TextField");
        kdtImmuneEntrys_unit_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtImmuneEntrys_unit_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_unit_TextField);
        this.kdtImmuneEntrys.getColumn("unit").setEditor(kdtImmuneEntrys_unit_CellEditor);
        KDFormattedTextField kdtImmuneEntrys_qty_TextField = new KDFormattedTextField();
        kdtImmuneEntrys_qty_TextField.setName("kdtImmuneEntrys_qty_TextField");
        kdtImmuneEntrys_qty_TextField.setVisible(true);
        kdtImmuneEntrys_qty_TextField.setEditable(true);
        kdtImmuneEntrys_qty_TextField.setHorizontalAlignment(2);
        kdtImmuneEntrys_qty_TextField.setDataType(1);
        	kdtImmuneEntrys_qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtImmuneEntrys_qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtImmuneEntrys_qty_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtImmuneEntrys_qty_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_qty_TextField);
        this.kdtImmuneEntrys.getColumn("qty").setEditor(kdtImmuneEntrys_qty_CellEditor);
        KDTextField kdtImmuneEntrys_remark_TextField = new KDTextField();
        kdtImmuneEntrys_remark_TextField.setName("kdtImmuneEntrys_remark_TextField");
        kdtImmuneEntrys_remark_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtImmuneEntrys_remark_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_remark_TextField);
        this.kdtImmuneEntrys.getColumn("remark").setEditor(kdtImmuneEntrys_remark_CellEditor);
        // kdtImmuneDetailEntry
		String kdtImmuneDetailEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"pigNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{pigNumber}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtImmuneDetailEntry.setFormatXml(resHelper.translateString("kdtImmuneDetailEntry",kdtImmuneDetailEntryStrXML));

                this.kdtImmuneDetailEntry.putBindContents("editData",new String[] {"ImmuneDetailEntry.seq","ImmuneDetailEntry.pigNumber"});


        this.kdtImmuneDetailEntry.checkParsed();
        KDFormattedTextField kdtImmuneDetailEntry_seq_TextField = new KDFormattedTextField();
        kdtImmuneDetailEntry_seq_TextField.setName("kdtImmuneDetailEntry_seq_TextField");
        kdtImmuneDetailEntry_seq_TextField.setVisible(true);
        kdtImmuneDetailEntry_seq_TextField.setEditable(true);
        kdtImmuneDetailEntry_seq_TextField.setHorizontalAlignment(2);
        kdtImmuneDetailEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtImmuneDetailEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtImmuneDetailEntry_seq_TextField);
        this.kdtImmuneDetailEntry.getColumn("seq").setEditor(kdtImmuneDetailEntry_seq_CellEditor);
        KDTextField kdtImmuneDetailEntry_pigNumber_TextField = new KDTextField();
        kdtImmuneDetailEntry_pigNumber_TextField.setName("kdtImmuneDetailEntry_pigNumber_TextField");
        kdtImmuneDetailEntry_pigNumber_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtImmuneDetailEntry_pigNumber_CellEditor = new KDTDefaultCellEditor(kdtImmuneDetailEntry_pigNumber_TextField);
        this.kdtImmuneDetailEntry.getColumn("pigNumber").setEditor(kdtImmuneDetailEntry_pigNumber_CellEditor);
        // kdtDCEntrys
		String kdtDCEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"pigHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"deathQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"deathWeight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"perWeight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"reason\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{pigHouse}</t:Cell><t:Cell>$Resource{deathQty}</t:Cell><t:Cell>$Resource{deathWeight}</t:Cell><t:Cell>$Resource{perWeight}</t:Cell><t:Cell>$Resource{reason}</t:Cell><t:Cell>$Resource{remark}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtDCEntrys.setFormatXml(resHelper.translateString("kdtDCEntrys",kdtDCEntrysStrXML));
        this.kdtDCEntrys.addKDTEditListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter() {
            public void editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) {
                try {
                    kdtDCEntrys_editStopped(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });

                this.kdtDCEntrys.putBindContents("editData",new String[] {"seq","pigHouse","deathQty","deathWeight","perWeight","reason","remark"});


        this.kdtDCEntrys.checkParsed();
        KDFormattedTextField kdtDCEntrys_seq_TextField = new KDFormattedTextField();
        kdtDCEntrys_seq_TextField.setName("kdtDCEntrys_seq_TextField");
        kdtDCEntrys_seq_TextField.setVisible(true);
        kdtDCEntrys_seq_TextField.setEditable(true);
        kdtDCEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtDCEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtDCEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtDCEntrys_seq_TextField);
        this.kdtDCEntrys.getColumn("seq").setEditor(kdtDCEntrys_seq_CellEditor);
        final KDBizPromptBox kdtDCEntrys_pigHouse_PromptBox = new KDBizPromptBox();
        kdtDCEntrys_pigHouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.pig.app.PigHouseF7Query");
        kdtDCEntrys_pigHouse_PromptBox.setVisible(true);
        kdtDCEntrys_pigHouse_PromptBox.setEditable(true);
        kdtDCEntrys_pigHouse_PromptBox.setDisplayFormat("$number$");
        kdtDCEntrys_pigHouse_PromptBox.setEditFormat("$number$");
        kdtDCEntrys_pigHouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtDCEntrys_pigHouse_CellEditor = new KDTDefaultCellEditor(kdtDCEntrys_pigHouse_PromptBox);
        this.kdtDCEntrys.getColumn("pigHouse").setEditor(kdtDCEntrys_pigHouse_CellEditor);
        ObjectValueRender kdtDCEntrys_pigHouse_OVR = new ObjectValueRender();
        kdtDCEntrys_pigHouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtDCEntrys.getColumn("pigHouse").setRenderer(kdtDCEntrys_pigHouse_OVR);
        			kdtDCEntrys_pigHouse_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.pig.client.PigHouseListUI kdtDCEntrys_pigHouse_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtDCEntrys_pigHouse_PromptBox_F7ListUI == null) {
					try {
						kdtDCEntrys_pigHouse_PromptBox_F7ListUI = new com.kingdee.eas.farm.pig.client.PigHouseListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtDCEntrys_pigHouse_PromptBox_F7ListUI));
					kdtDCEntrys_pigHouse_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtDCEntrys_pigHouse_PromptBox.setSelector(kdtDCEntrys_pigHouse_PromptBox_F7ListUI);
				}
			}
		});
					
        KDFormattedTextField kdtDCEntrys_deathQty_TextField = new KDFormattedTextField();
        kdtDCEntrys_deathQty_TextField.setName("kdtDCEntrys_deathQty_TextField");
        kdtDCEntrys_deathQty_TextField.setVisible(true);
        kdtDCEntrys_deathQty_TextField.setEditable(true);
        kdtDCEntrys_deathQty_TextField.setHorizontalAlignment(2);
        kdtDCEntrys_deathQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtDCEntrys_deathQty_CellEditor = new KDTDefaultCellEditor(kdtDCEntrys_deathQty_TextField);
        this.kdtDCEntrys.getColumn("deathQty").setEditor(kdtDCEntrys_deathQty_CellEditor);
        KDFormattedTextField kdtDCEntrys_deathWeight_TextField = new KDFormattedTextField();
        kdtDCEntrys_deathWeight_TextField.setName("kdtDCEntrys_deathWeight_TextField");
        kdtDCEntrys_deathWeight_TextField.setVisible(true);
        kdtDCEntrys_deathWeight_TextField.setEditable(true);
        kdtDCEntrys_deathWeight_TextField.setHorizontalAlignment(2);
        kdtDCEntrys_deathWeight_TextField.setDataType(1);
        	kdtDCEntrys_deathWeight_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtDCEntrys_deathWeight_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtDCEntrys_deathWeight_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtDCEntrys_deathWeight_CellEditor = new KDTDefaultCellEditor(kdtDCEntrys_deathWeight_TextField);
        this.kdtDCEntrys.getColumn("deathWeight").setEditor(kdtDCEntrys_deathWeight_CellEditor);
        KDFormattedTextField kdtDCEntrys_perWeight_TextField = new KDFormattedTextField();
        kdtDCEntrys_perWeight_TextField.setName("kdtDCEntrys_perWeight_TextField");
        kdtDCEntrys_perWeight_TextField.setVisible(true);
        kdtDCEntrys_perWeight_TextField.setEditable(true);
        kdtDCEntrys_perWeight_TextField.setHorizontalAlignment(2);
        kdtDCEntrys_perWeight_TextField.setDataType(1);
        	kdtDCEntrys_perWeight_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtDCEntrys_perWeight_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtDCEntrys_perWeight_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtDCEntrys_perWeight_CellEditor = new KDTDefaultCellEditor(kdtDCEntrys_perWeight_TextField);
        this.kdtDCEntrys.getColumn("perWeight").setEditor(kdtDCEntrys_perWeight_CellEditor);
        KDTextField kdtDCEntrys_reason_TextField = new KDTextField();
        kdtDCEntrys_reason_TextField.setName("kdtDCEntrys_reason_TextField");
        kdtDCEntrys_reason_TextField.setMaxLength(200);
        KDTDefaultCellEditor kdtDCEntrys_reason_CellEditor = new KDTDefaultCellEditor(kdtDCEntrys_reason_TextField);
        this.kdtDCEntrys.getColumn("reason").setEditor(kdtDCEntrys_reason_CellEditor);
        KDTextField kdtDCEntrys_remark_TextField = new KDTextField();
        kdtDCEntrys_remark_TextField.setName("kdtDCEntrys_remark_TextField");
        kdtDCEntrys_remark_TextField.setMaxLength(200);
        KDTDefaultCellEditor kdtDCEntrys_remark_CellEditor = new KDTDefaultCellEditor(kdtDCEntrys_remark_TextField);
        this.kdtDCEntrys.getColumn("remark").setEditor(kdtDCEntrys_remark_CellEditor);
        // kdtDeathEarNumberEntrys
		String kdtDeathEarNumberEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"pigNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{pigNumber}</t:Cell><t:Cell>$Resource{remark}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtDeathEarNumberEntrys.setFormatXml(resHelper.translateString("kdtDeathEarNumberEntrys",kdtDeathEarNumberEntrysStrXML));

                this.kdtDeathEarNumberEntrys.putBindContents("editData",new String[] {"DeathEarNumberEntrys.seq","DeathEarNumberEntrys.pigNumber","DeathEarNumberEntrys.remark"});


        this.kdtDeathEarNumberEntrys.checkParsed();
        KDFormattedTextField kdtDeathEarNumberEntrys_seq_TextField = new KDFormattedTextField();
        kdtDeathEarNumberEntrys_seq_TextField.setName("kdtDeathEarNumberEntrys_seq_TextField");
        kdtDeathEarNumberEntrys_seq_TextField.setVisible(true);
        kdtDeathEarNumberEntrys_seq_TextField.setEditable(true);
        kdtDeathEarNumberEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtDeathEarNumberEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtDeathEarNumberEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtDeathEarNumberEntrys_seq_TextField);
        this.kdtDeathEarNumberEntrys.getColumn("seq").setEditor(kdtDeathEarNumberEntrys_seq_CellEditor);
        KDTextField kdtDeathEarNumberEntrys_pigNumber_TextField = new KDTextField();
        kdtDeathEarNumberEntrys_pigNumber_TextField.setName("kdtDeathEarNumberEntrys_pigNumber_TextField");
        kdtDeathEarNumberEntrys_pigNumber_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtDeathEarNumberEntrys_pigNumber_CellEditor = new KDTDefaultCellEditor(kdtDeathEarNumberEntrys_pigNumber_TextField);
        this.kdtDeathEarNumberEntrys.getColumn("pigNumber").setEditor(kdtDeathEarNumberEntrys_pigNumber_CellEditor);
        KDTextField kdtDeathEarNumberEntrys_remark_TextField = new KDTextField();
        kdtDeathEarNumberEntrys_remark_TextField.setName("kdtDeathEarNumberEntrys_remark_TextField");
        kdtDeathEarNumberEntrys_remark_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtDeathEarNumberEntrys_remark_CellEditor = new KDTDefaultCellEditor(kdtDeathEarNumberEntrys_remark_TextField);
        this.kdtDeathEarNumberEntrys.getColumn("remark").setEditor(kdtDeathEarNumberEntrys_remark_CellEditor);
        // kdtCullEntrys
		String kdtCullEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"pigHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"cullQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"cullWeight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"perWeight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"reason\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{pigHouse}</t:Cell><t:Cell>$Resource{cullQty}</t:Cell><t:Cell>$Resource{cullWeight}</t:Cell><t:Cell>$Resource{perWeight}</t:Cell><t:Cell>$Resource{reason}</t:Cell><t:Cell>$Resource{remark}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtCullEntrys.setFormatXml(resHelper.translateString("kdtCullEntrys",kdtCullEntrysStrXML));
        this.kdtCullEntrys.addKDTEditListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter() {
            public void editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) {
                try {
                    kdtCullEntrys_editStopped(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });

                this.kdtCullEntrys.putBindContents("editData",new String[] {"seq","pigHouse","cullQty","cullWeight","perWeight","reason","remark"});


        this.kdtCullEntrys.checkParsed();
        KDFormattedTextField kdtCullEntrys_seq_TextField = new KDFormattedTextField();
        kdtCullEntrys_seq_TextField.setName("kdtCullEntrys_seq_TextField");
        kdtCullEntrys_seq_TextField.setVisible(true);
        kdtCullEntrys_seq_TextField.setEditable(true);
        kdtCullEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtCullEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtCullEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtCullEntrys_seq_TextField);
        this.kdtCullEntrys.getColumn("seq").setEditor(kdtCullEntrys_seq_CellEditor);
        final KDBizPromptBox kdtCullEntrys_pigHouse_PromptBox = new KDBizPromptBox();
        kdtCullEntrys_pigHouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.pig.app.PigHouseF7Query");
        kdtCullEntrys_pigHouse_PromptBox.setVisible(true);
        kdtCullEntrys_pigHouse_PromptBox.setEditable(true);
        kdtCullEntrys_pigHouse_PromptBox.setDisplayFormat("$number$");
        kdtCullEntrys_pigHouse_PromptBox.setEditFormat("$number$");
        kdtCullEntrys_pigHouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtCullEntrys_pigHouse_CellEditor = new KDTDefaultCellEditor(kdtCullEntrys_pigHouse_PromptBox);
        this.kdtCullEntrys.getColumn("pigHouse").setEditor(kdtCullEntrys_pigHouse_CellEditor);
        ObjectValueRender kdtCullEntrys_pigHouse_OVR = new ObjectValueRender();
        kdtCullEntrys_pigHouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtCullEntrys.getColumn("pigHouse").setRenderer(kdtCullEntrys_pigHouse_OVR);
        			kdtCullEntrys_pigHouse_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.pig.client.PigHouseListUI kdtCullEntrys_pigHouse_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtCullEntrys_pigHouse_PromptBox_F7ListUI == null) {
					try {
						kdtCullEntrys_pigHouse_PromptBox_F7ListUI = new com.kingdee.eas.farm.pig.client.PigHouseListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtCullEntrys_pigHouse_PromptBox_F7ListUI));
					kdtCullEntrys_pigHouse_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtCullEntrys_pigHouse_PromptBox.setSelector(kdtCullEntrys_pigHouse_PromptBox_F7ListUI);
				}
			}
		});
					
        KDFormattedTextField kdtCullEntrys_cullQty_TextField = new KDFormattedTextField();
        kdtCullEntrys_cullQty_TextField.setName("kdtCullEntrys_cullQty_TextField");
        kdtCullEntrys_cullQty_TextField.setVisible(true);
        kdtCullEntrys_cullQty_TextField.setEditable(true);
        kdtCullEntrys_cullQty_TextField.setHorizontalAlignment(2);
        kdtCullEntrys_cullQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtCullEntrys_cullQty_CellEditor = new KDTDefaultCellEditor(kdtCullEntrys_cullQty_TextField);
        this.kdtCullEntrys.getColumn("cullQty").setEditor(kdtCullEntrys_cullQty_CellEditor);
        KDFormattedTextField kdtCullEntrys_cullWeight_TextField = new KDFormattedTextField();
        kdtCullEntrys_cullWeight_TextField.setName("kdtCullEntrys_cullWeight_TextField");
        kdtCullEntrys_cullWeight_TextField.setVisible(true);
        kdtCullEntrys_cullWeight_TextField.setEditable(true);
        kdtCullEntrys_cullWeight_TextField.setHorizontalAlignment(2);
        kdtCullEntrys_cullWeight_TextField.setDataType(1);
        	kdtCullEntrys_cullWeight_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtCullEntrys_cullWeight_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtCullEntrys_cullWeight_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtCullEntrys_cullWeight_CellEditor = new KDTDefaultCellEditor(kdtCullEntrys_cullWeight_TextField);
        this.kdtCullEntrys.getColumn("cullWeight").setEditor(kdtCullEntrys_cullWeight_CellEditor);
        KDFormattedTextField kdtCullEntrys_perWeight_TextField = new KDFormattedTextField();
        kdtCullEntrys_perWeight_TextField.setName("kdtCullEntrys_perWeight_TextField");
        kdtCullEntrys_perWeight_TextField.setVisible(true);
        kdtCullEntrys_perWeight_TextField.setEditable(true);
        kdtCullEntrys_perWeight_TextField.setHorizontalAlignment(2);
        kdtCullEntrys_perWeight_TextField.setDataType(1);
        	kdtCullEntrys_perWeight_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtCullEntrys_perWeight_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtCullEntrys_perWeight_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtCullEntrys_perWeight_CellEditor = new KDTDefaultCellEditor(kdtCullEntrys_perWeight_TextField);
        this.kdtCullEntrys.getColumn("perWeight").setEditor(kdtCullEntrys_perWeight_CellEditor);
        KDTextField kdtCullEntrys_reason_TextField = new KDTextField();
        kdtCullEntrys_reason_TextField.setName("kdtCullEntrys_reason_TextField");
        kdtCullEntrys_reason_TextField.setMaxLength(200);
        KDTDefaultCellEditor kdtCullEntrys_reason_CellEditor = new KDTDefaultCellEditor(kdtCullEntrys_reason_TextField);
        this.kdtCullEntrys.getColumn("reason").setEditor(kdtCullEntrys_reason_CellEditor);
        KDTextField kdtCullEntrys_remark_TextField = new KDTextField();
        kdtCullEntrys_remark_TextField.setName("kdtCullEntrys_remark_TextField");
        kdtCullEntrys_remark_TextField.setMaxLength(200);
        KDTDefaultCellEditor kdtCullEntrys_remark_CellEditor = new KDTDefaultCellEditor(kdtCullEntrys_remark_TextField);
        this.kdtCullEntrys.getColumn("remark").setEditor(kdtCullEntrys_remark_CellEditor);
        // kdtCullEarNumberEntrys
		String kdtCullEarNumberEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"pigNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{pigNumber}</t:Cell><t:Cell>$Resource{remark}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtCullEarNumberEntrys.setFormatXml(resHelper.translateString("kdtCullEarNumberEntrys",kdtCullEarNumberEntrysStrXML));

                this.kdtCullEarNumberEntrys.putBindContents("editData",new String[] {"CullEarNumberEntrys.seq","CullEarNumberEntrys.pigNumber","CullEarNumberEntrys.remark"});


        this.kdtCullEarNumberEntrys.checkParsed();
        KDFormattedTextField kdtCullEarNumberEntrys_seq_TextField = new KDFormattedTextField();
        kdtCullEarNumberEntrys_seq_TextField.setName("kdtCullEarNumberEntrys_seq_TextField");
        kdtCullEarNumberEntrys_seq_TextField.setVisible(true);
        kdtCullEarNumberEntrys_seq_TextField.setEditable(true);
        kdtCullEarNumberEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtCullEarNumberEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtCullEarNumberEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtCullEarNumberEntrys_seq_TextField);
        this.kdtCullEarNumberEntrys.getColumn("seq").setEditor(kdtCullEarNumberEntrys_seq_CellEditor);
        KDTextField kdtCullEarNumberEntrys_pigNumber_TextField = new KDTextField();
        kdtCullEarNumberEntrys_pigNumber_TextField.setName("kdtCullEarNumberEntrys_pigNumber_TextField");
        kdtCullEarNumberEntrys_pigNumber_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtCullEarNumberEntrys_pigNumber_CellEditor = new KDTDefaultCellEditor(kdtCullEarNumberEntrys_pigNumber_TextField);
        this.kdtCullEarNumberEntrys.getColumn("pigNumber").setEditor(kdtCullEarNumberEntrys_pigNumber_CellEditor);
        KDTextField kdtCullEarNumberEntrys_remark_TextField = new KDTextField();
        kdtCullEarNumberEntrys_remark_TextField.setName("kdtCullEarNumberEntrys_remark_TextField");
        kdtCullEarNumberEntrys_remark_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtCullEarNumberEntrys_remark_CellEditor = new KDTDefaultCellEditor(kdtCullEarNumberEntrys_remark_TextField);
        this.kdtCullEarNumberEntrys.getColumn("remark").setEditor(kdtCullEarNumberEntrys_remark_CellEditor);
        // kdtOutEntrys
		String kdtOutEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"pigHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"allWeight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"weight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"avgWeight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"outLevel\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{pigHouse}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{allWeight}</t:Cell><t:Cell>$Resource{weight}</t:Cell><t:Cell>$Resource{avgWeight}</t:Cell><t:Cell>$Resource{outLevel}</t:Cell><t:Cell>$Resource{remark}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtOutEntrys.setFormatXml(resHelper.translateString("kdtOutEntrys",kdtOutEntrysStrXML));
        this.kdtOutEntrys.addKDTEditListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter() {
            public void editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) {
                try {
                    kdtOutEntrys_editStopped(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });

                this.kdtOutEntrys.putBindContents("editData",new String[] {"seq","pigHouse","qty","allWeight","weight","avgWeight","outLevel","remark"});


        this.kdtOutEntrys.checkParsed();
        KDFormattedTextField kdtOutEntrys_seq_TextField = new KDFormattedTextField();
        kdtOutEntrys_seq_TextField.setName("kdtOutEntrys_seq_TextField");
        kdtOutEntrys_seq_TextField.setVisible(true);
        kdtOutEntrys_seq_TextField.setEditable(true);
        kdtOutEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtOutEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtOutEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtOutEntrys_seq_TextField);
        this.kdtOutEntrys.getColumn("seq").setEditor(kdtOutEntrys_seq_CellEditor);
        final KDBizPromptBox kdtOutEntrys_pigHouse_PromptBox = new KDBizPromptBox();
        kdtOutEntrys_pigHouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.pig.app.PigHouseF7Query");
        kdtOutEntrys_pigHouse_PromptBox.setVisible(true);
        kdtOutEntrys_pigHouse_PromptBox.setEditable(true);
        kdtOutEntrys_pigHouse_PromptBox.setDisplayFormat("$number$");
        kdtOutEntrys_pigHouse_PromptBox.setEditFormat("$number$");
        kdtOutEntrys_pigHouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtOutEntrys_pigHouse_CellEditor = new KDTDefaultCellEditor(kdtOutEntrys_pigHouse_PromptBox);
        this.kdtOutEntrys.getColumn("pigHouse").setEditor(kdtOutEntrys_pigHouse_CellEditor);
        ObjectValueRender kdtOutEntrys_pigHouse_OVR = new ObjectValueRender();
        kdtOutEntrys_pigHouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtOutEntrys.getColumn("pigHouse").setRenderer(kdtOutEntrys_pigHouse_OVR);
        			kdtOutEntrys_pigHouse_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.pig.client.PigHouseListUI kdtOutEntrys_pigHouse_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtOutEntrys_pigHouse_PromptBox_F7ListUI == null) {
					try {
						kdtOutEntrys_pigHouse_PromptBox_F7ListUI = new com.kingdee.eas.farm.pig.client.PigHouseListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtOutEntrys_pigHouse_PromptBox_F7ListUI));
					kdtOutEntrys_pigHouse_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtOutEntrys_pigHouse_PromptBox.setSelector(kdtOutEntrys_pigHouse_PromptBox_F7ListUI);
				}
			}
		});
					
        KDFormattedTextField kdtOutEntrys_qty_TextField = new KDFormattedTextField();
        kdtOutEntrys_qty_TextField.setName("kdtOutEntrys_qty_TextField");
        kdtOutEntrys_qty_TextField.setVisible(true);
        kdtOutEntrys_qty_TextField.setEditable(true);
        kdtOutEntrys_qty_TextField.setHorizontalAlignment(2);
        kdtOutEntrys_qty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtOutEntrys_qty_CellEditor = new KDTDefaultCellEditor(kdtOutEntrys_qty_TextField);
        this.kdtOutEntrys.getColumn("qty").setEditor(kdtOutEntrys_qty_CellEditor);
        KDFormattedTextField kdtOutEntrys_allWeight_TextField = new KDFormattedTextField();
        kdtOutEntrys_allWeight_TextField.setName("kdtOutEntrys_allWeight_TextField");
        kdtOutEntrys_allWeight_TextField.setVisible(true);
        kdtOutEntrys_allWeight_TextField.setEditable(true);
        kdtOutEntrys_allWeight_TextField.setHorizontalAlignment(2);
        kdtOutEntrys_allWeight_TextField.setDataType(1);
        	kdtOutEntrys_allWeight_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtOutEntrys_allWeight_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtOutEntrys_allWeight_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtOutEntrys_allWeight_CellEditor = new KDTDefaultCellEditor(kdtOutEntrys_allWeight_TextField);
        this.kdtOutEntrys.getColumn("allWeight").setEditor(kdtOutEntrys_allWeight_CellEditor);
        KDTextField kdtOutEntrys_weight_TextField = new KDTextField();
        kdtOutEntrys_weight_TextField.setName("kdtOutEntrys_weight_TextField");
        kdtOutEntrys_weight_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtOutEntrys_weight_CellEditor = new KDTDefaultCellEditor(kdtOutEntrys_weight_TextField);
        this.kdtOutEntrys.getColumn("weight").setEditor(kdtOutEntrys_weight_CellEditor);
        KDFormattedTextField kdtOutEntrys_avgWeight_TextField = new KDFormattedTextField();
        kdtOutEntrys_avgWeight_TextField.setName("kdtOutEntrys_avgWeight_TextField");
        kdtOutEntrys_avgWeight_TextField.setVisible(true);
        kdtOutEntrys_avgWeight_TextField.setEditable(true);
        kdtOutEntrys_avgWeight_TextField.setHorizontalAlignment(2);
        kdtOutEntrys_avgWeight_TextField.setDataType(1);
        	kdtOutEntrys_avgWeight_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtOutEntrys_avgWeight_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtOutEntrys_avgWeight_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtOutEntrys_avgWeight_CellEditor = new KDTDefaultCellEditor(kdtOutEntrys_avgWeight_TextField);
        this.kdtOutEntrys.getColumn("avgWeight").setEditor(kdtOutEntrys_avgWeight_CellEditor);
        KDComboBox kdtOutEntrys_outLevel_ComboBox = new KDComboBox();
        kdtOutEntrys_outLevel_ComboBox.setName("kdtOutEntrys_outLevel_ComboBox");
        kdtOutEntrys_outLevel_ComboBox.setVisible(true);
        kdtOutEntrys_outLevel_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.pig.OutPigLevel").toArray());
        KDTDefaultCellEditor kdtOutEntrys_outLevel_CellEditor = new KDTDefaultCellEditor(kdtOutEntrys_outLevel_ComboBox);
        this.kdtOutEntrys.getColumn("outLevel").setEditor(kdtOutEntrys_outLevel_CellEditor);
        KDTextField kdtOutEntrys_remark_TextField = new KDTextField();
        kdtOutEntrys_remark_TextField.setName("kdtOutEntrys_remark_TextField");
        kdtOutEntrys_remark_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtOutEntrys_remark_CellEditor = new KDTDefaultCellEditor(kdtOutEntrys_remark_TextField);
        this.kdtOutEntrys.getColumn("remark").setEditor(kdtOutEntrys_remark_CellEditor);
        // kdtOutEarNumberEntrys
		String kdtOutEarNumberEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"pigNumber\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{pigNumber}</t:Cell><t:Cell>$Resource{remark}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtOutEarNumberEntrys.setFormatXml(resHelper.translateString("kdtOutEarNumberEntrys",kdtOutEarNumberEntrysStrXML));

                this.kdtOutEarNumberEntrys.putBindContents("editData",new String[] {"OutEarNumberEntrys.seq","OutEarNumberEntrys.pigNumber","OutEarNumberEntrys.remark"});


        this.kdtOutEarNumberEntrys.checkParsed();
        KDFormattedTextField kdtOutEarNumberEntrys_seq_TextField = new KDFormattedTextField();
        kdtOutEarNumberEntrys_seq_TextField.setName("kdtOutEarNumberEntrys_seq_TextField");
        kdtOutEarNumberEntrys_seq_TextField.setVisible(true);
        kdtOutEarNumberEntrys_seq_TextField.setEditable(true);
        kdtOutEarNumberEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtOutEarNumberEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtOutEarNumberEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtOutEarNumberEntrys_seq_TextField);
        this.kdtOutEarNumberEntrys.getColumn("seq").setEditor(kdtOutEarNumberEntrys_seq_CellEditor);
        KDTextField kdtOutEarNumberEntrys_pigNumber_TextField = new KDTextField();
        kdtOutEarNumberEntrys_pigNumber_TextField.setName("kdtOutEarNumberEntrys_pigNumber_TextField");
        kdtOutEarNumberEntrys_pigNumber_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtOutEarNumberEntrys_pigNumber_CellEditor = new KDTDefaultCellEditor(kdtOutEarNumberEntrys_pigNumber_TextField);
        this.kdtOutEarNumberEntrys.getColumn("pigNumber").setEditor(kdtOutEarNumberEntrys_pigNumber_CellEditor);
        KDTextField kdtOutEarNumberEntrys_remark_TextField = new KDTextField();
        kdtOutEarNumberEntrys_remark_TextField.setName("kdtOutEarNumberEntrys_remark_TextField");
        kdtOutEarNumberEntrys_remark_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtOutEarNumberEntrys_remark_CellEditor = new KDTDefaultCellEditor(kdtOutEarNumberEntrys_remark_TextField);
        this.kdtOutEarNumberEntrys.getColumn("remark").setEditor(kdtOutEarNumberEntrys_remark_CellEditor);
        // kdtEnviConEntry
		String kdtEnviConEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"pigHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"breedTimes\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"lightingTimes\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"temperatureFrom\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"temperatureTo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"humidityFrom\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"humidityTo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{pigHouse}</t:Cell><t:Cell>$Resource{breedTimes}</t:Cell><t:Cell>$Resource{lightingTimes}</t:Cell><t:Cell>$Resource{temperatureFrom}</t:Cell><t:Cell>$Resource{temperatureTo}</t:Cell><t:Cell>$Resource{humidityFrom}</t:Cell><t:Cell>$Resource{humidityTo}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEnviConEntry.setFormatXml(resHelper.translateString("kdtEnviConEntry",kdtEnviConEntryStrXML));

                this.kdtEnviConEntry.putBindContents("editData",new String[] {"seq","pigHouse","breedTimes","lightingTimes","temperatureFrom","temperatureTo","humidityFrom","humidityTo"});


        this.kdtEnviConEntry.checkParsed();
        KDFormattedTextField kdtEnviConEntry_seq_TextField = new KDFormattedTextField();
        kdtEnviConEntry_seq_TextField.setName("kdtEnviConEntry_seq_TextField");
        kdtEnviConEntry_seq_TextField.setVisible(true);
        kdtEnviConEntry_seq_TextField.setEditable(true);
        kdtEnviConEntry_seq_TextField.setHorizontalAlignment(2);
        kdtEnviConEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEnviConEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtEnviConEntry_seq_TextField);
        this.kdtEnviConEntry.getColumn("seq").setEditor(kdtEnviConEntry_seq_CellEditor);
        final KDBizPromptBox kdtEnviConEntry_pigHouse_PromptBox = new KDBizPromptBox();
        kdtEnviConEntry_pigHouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.pig.app.PigHouseF7Query");
        kdtEnviConEntry_pigHouse_PromptBox.setVisible(true);
        kdtEnviConEntry_pigHouse_PromptBox.setEditable(true);
        kdtEnviConEntry_pigHouse_PromptBox.setDisplayFormat("$number$");
        kdtEnviConEntry_pigHouse_PromptBox.setEditFormat("$number$");
        kdtEnviConEntry_pigHouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEnviConEntry_pigHouse_CellEditor = new KDTDefaultCellEditor(kdtEnviConEntry_pigHouse_PromptBox);
        this.kdtEnviConEntry.getColumn("pigHouse").setEditor(kdtEnviConEntry_pigHouse_CellEditor);
        ObjectValueRender kdtEnviConEntry_pigHouse_OVR = new ObjectValueRender();
        kdtEnviConEntry_pigHouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEnviConEntry.getColumn("pigHouse").setRenderer(kdtEnviConEntry_pigHouse_OVR);
        			kdtEnviConEntry_pigHouse_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.pig.client.PigHouseListUI kdtEnviConEntry_pigHouse_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEnviConEntry_pigHouse_PromptBox_F7ListUI == null) {
					try {
						kdtEnviConEntry_pigHouse_PromptBox_F7ListUI = new com.kingdee.eas.farm.pig.client.PigHouseListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEnviConEntry_pigHouse_PromptBox_F7ListUI));
					kdtEnviConEntry_pigHouse_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEnviConEntry_pigHouse_PromptBox.setSelector(kdtEnviConEntry_pigHouse_PromptBox_F7ListUI);
				}
			}
		});
					
        KDFormattedTextField kdtEnviConEntry_breedTimes_TextField = new KDFormattedTextField();
        kdtEnviConEntry_breedTimes_TextField.setName("kdtEnviConEntry_breedTimes_TextField");
        kdtEnviConEntry_breedTimes_TextField.setVisible(true);
        kdtEnviConEntry_breedTimes_TextField.setEditable(true);
        kdtEnviConEntry_breedTimes_TextField.setHorizontalAlignment(2);
        kdtEnviConEntry_breedTimes_TextField.setDataType(1);
        	kdtEnviConEntry_breedTimes_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEnviConEntry_breedTimes_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEnviConEntry_breedTimes_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEnviConEntry_breedTimes_CellEditor = new KDTDefaultCellEditor(kdtEnviConEntry_breedTimes_TextField);
        this.kdtEnviConEntry.getColumn("breedTimes").setEditor(kdtEnviConEntry_breedTimes_CellEditor);
        KDFormattedTextField kdtEnviConEntry_lightingTimes_TextField = new KDFormattedTextField();
        kdtEnviConEntry_lightingTimes_TextField.setName("kdtEnviConEntry_lightingTimes_TextField");
        kdtEnviConEntry_lightingTimes_TextField.setVisible(true);
        kdtEnviConEntry_lightingTimes_TextField.setEditable(true);
        kdtEnviConEntry_lightingTimes_TextField.setHorizontalAlignment(2);
        kdtEnviConEntry_lightingTimes_TextField.setDataType(1);
        	kdtEnviConEntry_lightingTimes_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEnviConEntry_lightingTimes_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEnviConEntry_lightingTimes_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEnviConEntry_lightingTimes_CellEditor = new KDTDefaultCellEditor(kdtEnviConEntry_lightingTimes_TextField);
        this.kdtEnviConEntry.getColumn("lightingTimes").setEditor(kdtEnviConEntry_lightingTimes_CellEditor);
        KDFormattedTextField kdtEnviConEntry_temperatureFrom_TextField = new KDFormattedTextField();
        kdtEnviConEntry_temperatureFrom_TextField.setName("kdtEnviConEntry_temperatureFrom_TextField");
        kdtEnviConEntry_temperatureFrom_TextField.setVisible(true);
        kdtEnviConEntry_temperatureFrom_TextField.setEditable(true);
        kdtEnviConEntry_temperatureFrom_TextField.setHorizontalAlignment(2);
        kdtEnviConEntry_temperatureFrom_TextField.setDataType(1);
        	kdtEnviConEntry_temperatureFrom_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEnviConEntry_temperatureFrom_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEnviConEntry_temperatureFrom_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEnviConEntry_temperatureFrom_CellEditor = new KDTDefaultCellEditor(kdtEnviConEntry_temperatureFrom_TextField);
        this.kdtEnviConEntry.getColumn("temperatureFrom").setEditor(kdtEnviConEntry_temperatureFrom_CellEditor);
        KDFormattedTextField kdtEnviConEntry_temperatureTo_TextField = new KDFormattedTextField();
        kdtEnviConEntry_temperatureTo_TextField.setName("kdtEnviConEntry_temperatureTo_TextField");
        kdtEnviConEntry_temperatureTo_TextField.setVisible(true);
        kdtEnviConEntry_temperatureTo_TextField.setEditable(true);
        kdtEnviConEntry_temperatureTo_TextField.setHorizontalAlignment(2);
        kdtEnviConEntry_temperatureTo_TextField.setDataType(1);
        	kdtEnviConEntry_temperatureTo_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEnviConEntry_temperatureTo_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEnviConEntry_temperatureTo_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEnviConEntry_temperatureTo_CellEditor = new KDTDefaultCellEditor(kdtEnviConEntry_temperatureTo_TextField);
        this.kdtEnviConEntry.getColumn("temperatureTo").setEditor(kdtEnviConEntry_temperatureTo_CellEditor);
        KDFormattedTextField kdtEnviConEntry_humidityFrom_TextField = new KDFormattedTextField();
        kdtEnviConEntry_humidityFrom_TextField.setName("kdtEnviConEntry_humidityFrom_TextField");
        kdtEnviConEntry_humidityFrom_TextField.setVisible(true);
        kdtEnviConEntry_humidityFrom_TextField.setEditable(true);
        kdtEnviConEntry_humidityFrom_TextField.setHorizontalAlignment(2);
        kdtEnviConEntry_humidityFrom_TextField.setDataType(1);
        	kdtEnviConEntry_humidityFrom_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEnviConEntry_humidityFrom_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEnviConEntry_humidityFrom_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEnviConEntry_humidityFrom_CellEditor = new KDTDefaultCellEditor(kdtEnviConEntry_humidityFrom_TextField);
        this.kdtEnviConEntry.getColumn("humidityFrom").setEditor(kdtEnviConEntry_humidityFrom_CellEditor);
        KDFormattedTextField kdtEnviConEntry_humidityTo_TextField = new KDFormattedTextField();
        kdtEnviConEntry_humidityTo_TextField.setName("kdtEnviConEntry_humidityTo_TextField");
        kdtEnviConEntry_humidityTo_TextField.setVisible(true);
        kdtEnviConEntry_humidityTo_TextField.setEditable(true);
        kdtEnviConEntry_humidityTo_TextField.setHorizontalAlignment(2);
        kdtEnviConEntry_humidityTo_TextField.setDataType(1);
        	kdtEnviConEntry_humidityTo_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEnviConEntry_humidityTo_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEnviConEntry_humidityTo_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEnviConEntry_humidityTo_CellEditor = new KDTDefaultCellEditor(kdtEnviConEntry_humidityTo_TextField);
        this.kdtEnviConEntry.getColumn("humidityTo").setEditor(kdtEnviConEntry_humidityTo_CellEditor);
        // contbreedLog		
        this.contbreedLog.setBoundLabelText(resHelper.getString("contbreedLog.boundLabelText"));		
        this.contbreedLog.setBoundLabelLength(0);		
        this.contbreedLog.setBoundLabelUnderline(true);		
        this.contbreedLog.setVisible(true);
        // scrollPanebreedLog
        // txtbreedLog		
        this.txtbreedLog.setRequired(false);		
        this.txtbreedLog.setMaxLength(800);
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(false);		
        this.baseStatus.setEnabled(false);
        // contweather		
        this.contweather.setBoundLabelText(resHelper.getString("contweather.boundLabelText"));		
        this.contweather.setBoundLabelLength(100);		
        this.contweather.setBoundLabelUnderline(true);		
        this.contweather.setVisible(true);
        // contoutHumidityTo		
        this.contoutHumidityTo.setBoundLabelText(resHelper.getString("contoutHumidityTo.boundLabelText"));		
        this.contoutHumidityTo.setBoundLabelLength(100);		
        this.contoutHumidityTo.setBoundLabelUnderline(true);		
        this.contoutHumidityTo.setVisible(true);
        // contoutHumidityFrom		
        this.contoutHumidityFrom.setBoundLabelText(resHelper.getString("contoutHumidityFrom.boundLabelText"));		
        this.contoutHumidityFrom.setBoundLabelLength(100);		
        this.contoutHumidityFrom.setBoundLabelUnderline(true);		
        this.contoutHumidityFrom.setVisible(true);
        // contoutTemperatureTo		
        this.contoutTemperatureTo.setBoundLabelText(resHelper.getString("contoutTemperatureTo.boundLabelText"));		
        this.contoutTemperatureTo.setBoundLabelLength(100);		
        this.contoutTemperatureTo.setBoundLabelUnderline(true);		
        this.contoutTemperatureTo.setVisible(true);
        // contoutTemperatureFrom		
        this.contoutTemperatureFrom.setBoundLabelText(resHelper.getString("contoutTemperatureFrom.boundLabelText"));		
        this.contoutTemperatureFrom.setBoundLabelLength(100);		
        this.contoutTemperatureFrom.setBoundLabelUnderline(true);		
        this.contoutTemperatureFrom.setVisible(true);
        // txtweather		
        this.txtweather.setHorizontalAlignment(2);		
        this.txtweather.setMaxLength(200);		
        this.txtweather.setRequired(false);
        // txtoutHumidityTo		
        this.txtoutHumidityTo.setHorizontalAlignment(2);		
        this.txtoutHumidityTo.setDataType(1);		
        this.txtoutHumidityTo.setSupportedEmpty(true);		
        this.txtoutHumidityTo.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtoutHumidityTo.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtoutHumidityTo.setPrecision(2);		
        this.txtoutHumidityTo.setRequired(false);
        // txtoutHumidityFrom		
        this.txtoutHumidityFrom.setHorizontalAlignment(2);		
        this.txtoutHumidityFrom.setDataType(1);		
        this.txtoutHumidityFrom.setSupportedEmpty(true);		
        this.txtoutHumidityFrom.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtoutHumidityFrom.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtoutHumidityFrom.setPrecision(2);		
        this.txtoutHumidityFrom.setRequired(false);
        // txtoutTemperatureTo		
        this.txtoutTemperatureTo.setHorizontalAlignment(2);		
        this.txtoutTemperatureTo.setDataType(1);		
        this.txtoutTemperatureTo.setSupportedEmpty(true);		
        this.txtoutTemperatureTo.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtoutTemperatureTo.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtoutTemperatureTo.setPrecision(2);		
        this.txtoutTemperatureTo.setRequired(false);
        // txtoutTemperatureFrom		
        this.txtoutTemperatureFrom.setHorizontalAlignment(2);		
        this.txtoutTemperatureFrom.setDataType(1);		
        this.txtoutTemperatureFrom.setSupportedEmpty(true);		
        this.txtoutTemperatureFrom.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtoutTemperatureFrom.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtoutTemperatureFrom.setPrecision(2);		
        this.txtoutTemperatureFrom.setRequired(false);
        // prmtpigBatch		
        this.prmtpigBatch.setQueryInfo("com.kingdee.eas.farm.pig.ccpig.app.CCPigBatchQuery");		
        this.prmtpigBatch.setEditable(true);		
        this.prmtpigBatch.setDisplayFormat("$number$");		
        this.prmtpigBatch.setEditFormat("$number$");		
        this.prmtpigBatch.setCommitFormat("$number$");		
        this.prmtpigBatch.setRequired(true);
        // prmtfarm		
        this.prmtfarm.setQueryInfo("com.kingdee.eas.farm.pig.app.PigFarmQuery");		
        this.prmtfarm.setEditable(true);		
        this.prmtfarm.setDisplayFormat("$name$");		
        this.prmtfarm.setEditFormat("$number$");		
        this.prmtfarm.setCommitFormat("$number$");		
        this.prmtfarm.setRequired(true);
        		prmtfarm.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.pig.client.PigFarmListUI prmtfarm_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarm_F7ListUI == null) {
					try {
						prmtfarm_F7ListUI = new com.kingdee.eas.farm.pig.client.PigFarmListUI();
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
					
        // scrollPanewarn
        // txtwarn		
        this.txtwarn.setRequired(false);		
        this.txtwarn.setMaxLength(500);		
        this.txtwarn.setEnabled(false);		
        this.txtwarn.setForeground(new java.awt.Color(255,0,0));
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {kdtFeedDetailEntry,kdtImmuneDetailEntry,kdtDeathEarNumberEntrys,kdtCullEarNumberEntrys,kdtOutEarNumberEntrys,pkauditTime,baseStatus,txtbreedLog,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,txtoutTemperatureFrom,txtoutTemperatureTo,txtoutHumidityFrom,txtoutHumidityTo,txtweather,prmtpigBatch,prmtfarm,txtwarn,kdtEnviConEntry,kdtImmuneEntrys,kdtEntrys,kdtDCEntrys,kdtOutEntrys,kdtLiveStockEntrys,kdtCullEntrys}));
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
        contCreator.setBounds(new Rectangle(11, 576, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(11, 576, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(11, 601, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(11, 601, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(369, 576, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(369, 576, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(369, 601, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(369, 601, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contNumber.setBounds(new Rectangle(19, 12, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(19, 12, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(733, 12, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(733, 12, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contDescription.setBounds(new Rectangle(376, 37, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(376, 37, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(727, 576, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(727, 576, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDTabbedPane1.setBounds(new Rectangle(11, 216, 995, 352));
        this.add(kDTabbedPane1, new KDLayout.Constraints(11, 216, 995, 352, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contauditTime.setBounds(new Rectangle(727, 601, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(727, 601, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbaseStatus.setBounds(new Rectangle(733, 37, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(733, 37, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDPanel6.setBounds(new Rectangle(10, 60, 541, 109));
        this.add(kDPanel6, new KDLayout.Constraints(10, 60, 541, 109, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpigBatch.setBounds(new Rectangle(377, 13, 270, 19));
        this.add(contpigBatch, new KDLayout.Constraints(377, 13, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtLiveStockEntrys.setBounds(new Rectangle(553, 60, 447, 109));
        kdtLiveStockEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtLiveStockEntrys,new com.kingdee.eas.farm.pig.ccpig.CCPigDailyLiveStockEntryInfo(),null,false);
        this.add(kdtLiveStockEntrys_detailPanel, new KDLayout.Constraints(553, 60, 447, 109, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfarm.setBounds(new Rectangle(19, 37, 270, 19));
        this.add(contfarm, new KDLayout.Constraints(19, 37, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contwarn.setBounds(new Rectangle(13, 175, 909, 40));
        this.add(contwarn, new KDLayout.Constraints(13, 175, 909, 40, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnPotion.setBounds(new Rectangle(923, 175, 84, 39));
        this.add(btnPotion, new KDLayout.Constraints(923, 175, 84, 39, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        kDTabbedPane1.add(kDPanel5, resHelper.getString("kDPanel5.constraints"));
        kDTabbedPane1.add(kDPanel8, resHelper.getString("kDPanel8.constraints"));
        kDTabbedPane1.add(kDPanel7, resHelper.getString("kDPanel7.constraints"));
        kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        kDTabbedPane1.add(kDPanel4, resHelper.getString("kDPanel4.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 994, 319));        kdtEntrys.setBounds(new Rectangle(2, 1, 694, 319));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.pig.ccpig.CCPigDailyEntryInfo(),null,false);
        kDPanel1.add(kdtEntrys_detailPanel, new KDLayout.Constraints(2, 1, 694, 319, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtFeedDetailEntry.setBounds(new Rectangle(701, 2, 286, 320));
        kdtFeedDetailEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtFeedDetailEntry,new com.kingdee.eas.farm.pig.ccpig.CCPigDailyEntryFeedDetailEntryInfo(),null,false);
        kDPanel1.add(kdtFeedDetailEntry_detailPanel, new KDLayout.Constraints(701, 2, 286, 320, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 994, 319));        kdtImmuneEntrys.setBounds(new Rectangle(1, 0, 745, 321));
        kdtImmuneEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtImmuneEntrys,new com.kingdee.eas.farm.pig.ccpig.CCPigDailyImmuneEntryInfo(),null,false);
        kDPanel2.add(kdtImmuneEntrys_detailPanel, new KDLayout.Constraints(1, 0, 745, 321, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
		kdtImmuneEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("immuneSourceType","1");
vo.put("immuneMode","1");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        kdtImmuneDetailEntry.setBounds(new Rectangle(748, 1, 238, 320));
        kdtImmuneDetailEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtImmuneDetailEntry,new com.kingdee.eas.farm.pig.ccpig.CCPigDailyImmuneEntryImmuneDetailEntryInfo(),null,false);
        kDPanel2.add(kdtImmuneDetailEntry_detailPanel, new KDLayout.Constraints(748, 1, 238, 320, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel5
        kDPanel5.setLayout(new KDLayout());
        kDPanel5.putClientProperty("OriginalBounds", new Rectangle(0, 0, 994, 319));        kdtDCEntrys.setBounds(new Rectangle(0, 0, 674, 319));
        kdtDCEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtDCEntrys,new com.kingdee.eas.farm.pig.ccpig.CCPigDailyDCEntryInfo(),null,false);
        kDPanel5.add(kdtDCEntrys_detailPanel, new KDLayout.Constraints(0, 0, 674, 319, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtDeathEarNumberEntrys.setBounds(new Rectangle(676, 2, 300, 319));
        kdtDeathEarNumberEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtDeathEarNumberEntrys,new com.kingdee.eas.farm.pig.ccpig.CCPigDailyDCEntryDeathEarNumberEntryInfo(),null,false);
        kDPanel5.add(kdtDeathEarNumberEntrys_detailPanel, new KDLayout.Constraints(676, 2, 300, 319, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel8
        kDPanel8.setLayout(new KDLayout());
        kDPanel8.putClientProperty("OriginalBounds", new Rectangle(0, 0, 994, 319));        kdtCullEntrys.setBounds(new Rectangle(0, -1, 690, 321));
        kdtCullEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtCullEntrys,new com.kingdee.eas.farm.pig.ccpig.CCPigDailyCullEntryInfo(),null,false);
        kDPanel8.add(kdtCullEntrys_detailPanel, new KDLayout.Constraints(0, -1, 690, 321, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtCullEarNumberEntrys.setBounds(new Rectangle(710, 10, 276, 310));
        kdtCullEarNumberEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtCullEarNumberEntrys,new com.kingdee.eas.farm.pig.ccpig.CCPigDailyCullEntryCullEarNumberEntryInfo(),null,false);
        kDPanel8.add(kdtCullEarNumberEntrys_detailPanel, new KDLayout.Constraints(710, 10, 276, 310, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel7
        kDPanel7.setLayout(new KDLayout());
        kDPanel7.putClientProperty("OriginalBounds", new Rectangle(0, 0, 994, 319));        kdtOutEntrys.setBounds(new Rectangle(2, 2, 572, 318));
        kdtOutEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtOutEntrys,new com.kingdee.eas.farm.pig.ccpig.CCPigDailyOutEntryInfo(),null,false);
        kDPanel7.add(kdtOutEntrys_detailPanel, new KDLayout.Constraints(2, 2, 572, 318, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
		kdtOutEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("outLevel","1");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        kdtOutEarNumberEntrys.setBounds(new Rectangle(606, 24, 381, 294));
        kdtOutEarNumberEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtOutEarNumberEntrys,new com.kingdee.eas.farm.pig.ccpig.CCPigDailyOutEntryOutEarNumberEntryInfo(),null,false);
        kDPanel7.add(kdtOutEarNumberEntrys_detailPanel, new KDLayout.Constraints(606, 24, 381, 294, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel3
        kDPanel3.setLayout(new KDLayout());
        kDPanel3.putClientProperty("OriginalBounds", new Rectangle(0, 0, 994, 319));        kdtEnviConEntry.setBounds(new Rectangle(0, 0, 976, 319));
        kdtEnviConEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEnviConEntry,new com.kingdee.eas.farm.pig.ccpig.CCPigDailyEnviConEntryInfo(),null,false);
        kDPanel3.add(kdtEnviConEntry_detailPanel, new KDLayout.Constraints(0, 0, 976, 319, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel4
        kDPanel4.setLayout(new KDLayout());
        kDPanel4.putClientProperty("OriginalBounds", new Rectangle(0, 0, 994, 319));        contbreedLog.setBounds(new Rectangle(1, 1, 985, 319));
        kDPanel4.add(contbreedLog, new KDLayout.Constraints(1, 1, 985, 319, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contbreedLog
        contbreedLog.setBoundEditor(scrollPanebreedLog);
        //scrollPanebreedLog
        scrollPanebreedLog.getViewport().add(txtbreedLog, null);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //kDPanel6
        kDPanel6.setLayout(new KDLayout());
        kDPanel6.putClientProperty("OriginalBounds", new Rectangle(10, 60, 541, 109));        contweather.setBounds(new Rectangle(15, 72, 466, 19));
        kDPanel6.add(contweather, new KDLayout.Constraints(15, 72, 466, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contoutHumidityTo.setBounds(new Rectangle(263, 45, 218, 19));
        kDPanel6.add(contoutHumidityTo, new KDLayout.Constraints(263, 45, 218, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contoutHumidityFrom.setBounds(new Rectangle(15, 45, 218, 19));
        kDPanel6.add(contoutHumidityFrom, new KDLayout.Constraints(15, 45, 218, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoutTemperatureTo.setBounds(new Rectangle(263, 18, 218, 19));
        kDPanel6.add(contoutTemperatureTo, new KDLayout.Constraints(263, 18, 218, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contoutTemperatureFrom.setBounds(new Rectangle(15, 18, 218, 19));
        kDPanel6.add(contoutTemperatureFrom, new KDLayout.Constraints(15, 18, 218, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contweather
        contweather.setBoundEditor(txtweather);
        //contoutHumidityTo
        contoutHumidityTo.setBoundEditor(txtoutHumidityTo);
        //contoutHumidityFrom
        contoutHumidityFrom.setBoundEditor(txtoutHumidityFrom);
        //contoutTemperatureTo
        contoutTemperatureTo.setBoundEditor(txtoutTemperatureTo);
        //contoutTemperatureFrom
        contoutTemperatureFrom.setBoundEditor(txtoutTemperatureFrom);
        //contpigBatch
        contpigBatch.setBoundEditor(prmtpigBatch);
        //contfarm
        contfarm.setBoundEditor(prmtfarm);
        //contwarn
        contwarn.setBoundEditor(scrollPanewarn);
        //scrollPanewarn
        scrollPanewarn.getViewport().add(txtwarn, null);

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
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(btnNextPerson);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("LiveStockEntrys.seq", int.class, this.kdtLiveStockEntrys, "seq.text");
		dataBinder.registerBinding("LiveStockEntrys", com.kingdee.eas.farm.pig.ccpig.CCPigDailyLiveStockEntryInfo.class, this.kdtLiveStockEntrys, "userObject");
		dataBinder.registerBinding("LiveStockEntrys.pigHouse", java.lang.Object.class, this.kdtLiveStockEntrys, "pigHouse.text");
		dataBinder.registerBinding("LiveStockEntrys.stockQty", int.class, this.kdtLiveStockEntrys, "stockQty.text");
		dataBinder.registerBinding("LiveStockEntrys.days", int.class, this.kdtLiveStockEntrys, "days.text");
		dataBinder.registerBinding("LiveStockEntrys.culldeathQty", int.class, this.kdtLiveStockEntrys, "culldeathQty.text");
		dataBinder.registerBinding("LiveStockEntrys.outQty", int.class, this.kdtLiveStockEntrys, "outQty.text");
		dataBinder.registerBinding("LiveStockEntrys.endStock", int.class, this.kdtLiveStockEntrys, "endStock.text");
		dataBinder.registerBinding("LiveStockEntrys.cullQty", int.class, this.kdtLiveStockEntrys, "cullQty.text");
		dataBinder.registerBinding("LiveStockEntrys.deathQty", int.class, this.kdtLiveStockEntrys, "deathQty.text");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.pig.ccpig.CCPigDailyEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.material", java.lang.Object.class, this.kdtEntrys, "material.text");
		dataBinder.registerBinding("entrys.materialName", String.class, this.kdtEntrys, "materialName.text");
		dataBinder.registerBinding("entrys.standardQty", java.math.BigDecimal.class, this.kdtEntrys, "standardQty.text");
		dataBinder.registerBinding("entrys.actualQty", java.math.BigDecimal.class, this.kdtEntrys, "actualQty.text");
		dataBinder.registerBinding("entrys.remark", String.class, this.kdtEntrys, "remark.text");
		dataBinder.registerBinding("entrys.pigHouse", java.lang.Object.class, this.kdtEntrys, "pigHouse.text");
		dataBinder.registerBinding("entrys.FeedDetailEntry.seq", int.class, this.kdtFeedDetailEntry, "seq.text");
		dataBinder.registerBinding("entrys.FeedDetailEntry", com.kingdee.eas.farm.pig.ccpig.CCPigDailyEntryFeedDetailEntryInfo.class, this.kdtFeedDetailEntry, "userObject");
		dataBinder.registerBinding("entrys.FeedDetailEntry.pigNumber", String.class, this.kdtFeedDetailEntry, "pigNumber.text");
		dataBinder.registerBinding("entrys.FeedDetailEntry.feedQty", java.math.BigDecimal.class, this.kdtFeedDetailEntry, "feedQty.text");
		dataBinder.registerBinding("ImmuneEntrys.seq", int.class, this.kdtImmuneEntrys, "seq.text");
		dataBinder.registerBinding("ImmuneEntrys", com.kingdee.eas.farm.pig.ccpig.CCPigDailyImmuneEntryInfo.class, this.kdtImmuneEntrys, "userObject");
		dataBinder.registerBinding("ImmuneEntrys.material", java.lang.Object.class, this.kdtImmuneEntrys, "material.text");
		dataBinder.registerBinding("ImmuneEntrys.qty", java.math.BigDecimal.class, this.kdtImmuneEntrys, "qty.text");
		dataBinder.registerBinding("ImmuneEntrys.unit", String.class, this.kdtImmuneEntrys, "unit.text");
		dataBinder.registerBinding("ImmuneEntrys.remark", String.class, this.kdtImmuneEntrys, "remark.text");
		dataBinder.registerBinding("ImmuneEntrys.materialName", String.class, this.kdtImmuneEntrys, "materialName.text");
		dataBinder.registerBinding("ImmuneEntrys.immuneMode", com.kingdee.util.enums.Enum.class, this.kdtImmuneEntrys, "immuneMode.text");
		dataBinder.registerBinding("ImmuneEntrys.pigHouse", java.lang.Object.class, this.kdtImmuneEntrys, "pigHouse.text");
		dataBinder.registerBinding("ImmuneEntrys.immuneSourceType", com.kingdee.util.enums.Enum.class, this.kdtImmuneEntrys, "immuneSourceType.text");
		dataBinder.registerBinding("ImmuneEntrys.ImmuneDetailEntry.seq", int.class, this.kdtImmuneDetailEntry, "seq.text");
		dataBinder.registerBinding("ImmuneEntrys.ImmuneDetailEntry", com.kingdee.eas.farm.pig.ccpig.CCPigDailyImmuneEntryImmuneDetailEntryInfo.class, this.kdtImmuneDetailEntry, "userObject");
		dataBinder.registerBinding("ImmuneEntrys.ImmuneDetailEntry.pigNumber", String.class, this.kdtImmuneDetailEntry, "pigNumber.text");
		dataBinder.registerBinding("DCEntrys.seq", int.class, this.kdtDCEntrys, "seq.text");
		dataBinder.registerBinding("DCEntrys", com.kingdee.eas.farm.pig.ccpig.CCPigDailyDCEntryInfo.class, this.kdtDCEntrys, "userObject");
		dataBinder.registerBinding("DCEntrys.remark", String.class, this.kdtDCEntrys, "remark.text");
		dataBinder.registerBinding("DCEntrys.deathQty", int.class, this.kdtDCEntrys, "deathQty.text");
		dataBinder.registerBinding("DCEntrys.deathWeight", java.math.BigDecimal.class, this.kdtDCEntrys, "deathWeight.text");
		dataBinder.registerBinding("DCEntrys.reason", String.class, this.kdtDCEntrys, "reason.text");
		dataBinder.registerBinding("DCEntrys.pigHouse", java.lang.Object.class, this.kdtDCEntrys, "pigHouse.text");
		dataBinder.registerBinding("DCEntrys.perWeight", java.math.BigDecimal.class, this.kdtDCEntrys, "perWeight.text");
		dataBinder.registerBinding("DCEntrys.DeathEarNumberEntrys.seq", int.class, this.kdtDeathEarNumberEntrys, "seq.text");
		dataBinder.registerBinding("DCEntrys.DeathEarNumberEntrys", com.kingdee.eas.farm.pig.ccpig.CCPigDailyDCEntryDeathEarNumberEntryInfo.class, this.kdtDeathEarNumberEntrys, "userObject");
		dataBinder.registerBinding("DCEntrys.DeathEarNumberEntrys.pigNumber", String.class, this.kdtDeathEarNumberEntrys, "pigNumber.text");
		dataBinder.registerBinding("DCEntrys.DeathEarNumberEntrys.remark", String.class, this.kdtDeathEarNumberEntrys, "remark.text");
		dataBinder.registerBinding("CullEntrys.seq", int.class, this.kdtCullEntrys, "seq.text");
		dataBinder.registerBinding("CullEntrys", com.kingdee.eas.farm.pig.ccpig.CCPigDailyCullEntryInfo.class, this.kdtCullEntrys, "userObject");
		dataBinder.registerBinding("CullEntrys.pigHouse", java.lang.Object.class, this.kdtCullEntrys, "pigHouse.text");
		dataBinder.registerBinding("CullEntrys.cullQty", int.class, this.kdtCullEntrys, "cullQty.text");
		dataBinder.registerBinding("CullEntrys.cullWeight", java.math.BigDecimal.class, this.kdtCullEntrys, "cullWeight.text");
		dataBinder.registerBinding("CullEntrys.reason", String.class, this.kdtCullEntrys, "reason.text");
		dataBinder.registerBinding("CullEntrys.remark", String.class, this.kdtCullEntrys, "remark.text");
		dataBinder.registerBinding("CullEntrys.perWeight", java.math.BigDecimal.class, this.kdtCullEntrys, "perWeight.text");
		dataBinder.registerBinding("CullEntrys.CullEarNumberEntrys.seq", int.class, this.kdtCullEarNumberEntrys, "seq.text");
		dataBinder.registerBinding("CullEntrys.CullEarNumberEntrys", com.kingdee.eas.farm.pig.ccpig.CCPigDailyCullEntryCullEarNumberEntryInfo.class, this.kdtCullEarNumberEntrys, "userObject");
		dataBinder.registerBinding("CullEntrys.CullEarNumberEntrys.pigNumber", String.class, this.kdtCullEarNumberEntrys, "pigNumber.text");
		dataBinder.registerBinding("CullEntrys.CullEarNumberEntrys.remark", String.class, this.kdtCullEarNumberEntrys, "remark.text");
		dataBinder.registerBinding("OutEntrys.seq", int.class, this.kdtOutEntrys, "seq.text");
		dataBinder.registerBinding("OutEntrys", com.kingdee.eas.farm.pig.ccpig.CCPigDailyOutEntryInfo.class, this.kdtOutEntrys, "userObject");
		dataBinder.registerBinding("OutEntrys.qty", int.class, this.kdtOutEntrys, "qty.text");
		dataBinder.registerBinding("OutEntrys.weight", String.class, this.kdtOutEntrys, "weight.text");
		dataBinder.registerBinding("OutEntrys.avgWeight", java.math.BigDecimal.class, this.kdtOutEntrys, "avgWeight.text");
		dataBinder.registerBinding("OutEntrys.pigHouse", java.lang.Object.class, this.kdtOutEntrys, "pigHouse.text");
		dataBinder.registerBinding("OutEntrys.outLevel", com.kingdee.util.enums.Enum.class, this.kdtOutEntrys, "outLevel.text");
		dataBinder.registerBinding("OutEntrys.remark", String.class, this.kdtOutEntrys, "remark.text");
		dataBinder.registerBinding("OutEntrys.allWeight", java.math.BigDecimal.class, this.kdtOutEntrys, "allWeight.text");
		dataBinder.registerBinding("OutEntrys.OutEarNumberEntrys.seq", int.class, this.kdtOutEarNumberEntrys, "seq.text");
		dataBinder.registerBinding("OutEntrys.OutEarNumberEntrys", com.kingdee.eas.farm.pig.ccpig.CCPigDailyOutEntryOutEarNumberEntryInfo.class, this.kdtOutEarNumberEntrys, "userObject");
		dataBinder.registerBinding("OutEntrys.OutEarNumberEntrys.pigNumber", String.class, this.kdtOutEarNumberEntrys, "pigNumber.text");
		dataBinder.registerBinding("OutEntrys.OutEarNumberEntrys.remark", String.class, this.kdtOutEarNumberEntrys, "remark.text");
		dataBinder.registerBinding("EnviConEntry.seq", int.class, this.kdtEnviConEntry, "seq.text");
		dataBinder.registerBinding("EnviConEntry", com.kingdee.eas.farm.pig.ccpig.CCPigDailyEnviConEntryInfo.class, this.kdtEnviConEntry, "userObject");
		dataBinder.registerBinding("EnviConEntry.breedTimes", java.math.BigDecimal.class, this.kdtEnviConEntry, "breedTimes.text");
		dataBinder.registerBinding("EnviConEntry.lightingTimes", java.math.BigDecimal.class, this.kdtEnviConEntry, "lightingTimes.text");
		dataBinder.registerBinding("EnviConEntry.temperatureFrom", java.math.BigDecimal.class, this.kdtEnviConEntry, "temperatureFrom.text");
		dataBinder.registerBinding("EnviConEntry.temperatureTo", java.math.BigDecimal.class, this.kdtEnviConEntry, "temperatureTo.text");
		dataBinder.registerBinding("EnviConEntry.humidityFrom", java.math.BigDecimal.class, this.kdtEnviConEntry, "humidityFrom.text");
		dataBinder.registerBinding("EnviConEntry.humidityTo", java.math.BigDecimal.class, this.kdtEnviConEntry, "humidityTo.text");
		dataBinder.registerBinding("EnviConEntry.pigHouse", java.lang.Object.class, this.kdtEnviConEntry, "pigHouse.text");
		dataBinder.registerBinding("breedLog", String.class, this.txtbreedLog, "text");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("weather", String.class, this.txtweather, "text");
		dataBinder.registerBinding("outHumidityTo", java.math.BigDecimal.class, this.txtoutHumidityTo, "value");
		dataBinder.registerBinding("outHumidityFrom", java.math.BigDecimal.class, this.txtoutHumidityFrom, "value");
		dataBinder.registerBinding("outTemperatureTo", java.math.BigDecimal.class, this.txtoutTemperatureTo, "value");
		dataBinder.registerBinding("outTemperatureFrom", java.math.BigDecimal.class, this.txtoutTemperatureFrom, "value");
		dataBinder.registerBinding("pigBatch", com.kingdee.eas.farm.pig.ccpig.CCPigBatchInfo.class, this.prmtpigBatch, "data");
		dataBinder.registerBinding("farm", com.kingdee.eas.farm.pig.PigFarmInfo.class, this.prmtfarm, "data");
		dataBinder.registerBinding("warn", String.class, this.txtwarn, "text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.pig.ccpig.app.CCPigDailyEditUIHandler";
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
        this.kdtFeedDetailEntry.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.pig.ccpig.CCPigDailyInfo)ov;
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
		getValidateHelper().registerBindProperty("LiveStockEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LiveStockEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LiveStockEntrys.pigHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LiveStockEntrys.stockQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LiveStockEntrys.days", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LiveStockEntrys.culldeathQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LiveStockEntrys.outQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LiveStockEntrys.endStock", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LiveStockEntrys.cullQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LiveStockEntrys.deathQty", ValidateHelper.ON_SAVE);    
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
		getValidateHelper().registerBindProperty("entrys.standardQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.actualQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.pigHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.FeedDetailEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.FeedDetailEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.FeedDetailEntry.pigNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.FeedDetailEntry.feedQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.materialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.immuneMode", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.pigHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.immuneSourceType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.ImmuneDetailEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.ImmuneDetailEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.ImmuneDetailEntry.pigNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DCEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DCEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DCEntrys.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DCEntrys.deathQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DCEntrys.deathWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DCEntrys.reason", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DCEntrys.pigHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DCEntrys.perWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DCEntrys.DeathEarNumberEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DCEntrys.DeathEarNumberEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DCEntrys.DeathEarNumberEntrys.pigNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DCEntrys.DeathEarNumberEntrys.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CullEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CullEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CullEntrys.pigHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CullEntrys.cullQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CullEntrys.cullWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CullEntrys.reason", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CullEntrys.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CullEntrys.perWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CullEntrys.CullEarNumberEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CullEntrys.CullEarNumberEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CullEntrys.CullEarNumberEntrys.pigNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CullEntrys.CullEarNumberEntrys.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OutEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OutEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OutEntrys.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OutEntrys.weight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OutEntrys.avgWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OutEntrys.pigHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OutEntrys.outLevel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OutEntrys.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OutEntrys.allWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OutEntrys.OutEarNumberEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OutEntrys.OutEarNumberEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OutEntrys.OutEarNumberEntrys.pigNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OutEntrys.OutEarNumberEntrys.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EnviConEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EnviConEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EnviConEntry.breedTimes", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EnviConEntry.lightingTimes", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EnviConEntry.temperatureFrom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EnviConEntry.temperatureTo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EnviConEntry.humidityFrom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EnviConEntry.humidityTo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EnviConEntry.pigHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedLog", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("weather", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("outHumidityTo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("outHumidityFrom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("outTemperatureTo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("outTemperatureFrom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("pigBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("warn", ValidateHelper.ON_SAVE);    		
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
     * output kdtDCEntrys_editStopped method
     */
    protected void kdtDCEntrys_editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output kdtCullEntrys_editStopped method
     */
    protected void kdtCullEntrys_editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output kdtOutEntrys_editStopped method
     */
    protected void kdtOutEntrys_editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
        //write your code here
    }


    /**
     * output kdtEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"materialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"material").getValue(),"name")));

}


    }

    /**
     * output kdtImmuneEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtImmuneEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("material".equalsIgnoreCase(kdtImmuneEntrys.getColumn(colIndex).getKey())) {
kdtImmuneEntrys.getCell(rowIndex,"unit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtImmuneEntrys.getCell(rowIndex,"material").getValue(),"baseUnit.name")));

}

    if ("material".equalsIgnoreCase(kdtImmuneEntrys.getColumn(colIndex).getKey())) {
kdtImmuneEntrys.getCell(rowIndex,"materialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtImmuneEntrys.getCell(rowIndex,"material").getValue(),"name")));

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
    	sic.add(new SelectorItemInfo("LiveStockEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("LiveStockEntrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("LiveStockEntrys.pigHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("LiveStockEntrys.pigHouse.id"));
			sic.add(new SelectorItemInfo("LiveStockEntrys.pigHouse.name"));
        	sic.add(new SelectorItemInfo("LiveStockEntrys.pigHouse.number"));
		}
    	sic.add(new SelectorItemInfo("LiveStockEntrys.stockQty"));
    	sic.add(new SelectorItemInfo("LiveStockEntrys.days"));
    	sic.add(new SelectorItemInfo("LiveStockEntrys.culldeathQty"));
    	sic.add(new SelectorItemInfo("LiveStockEntrys.outQty"));
    	sic.add(new SelectorItemInfo("LiveStockEntrys.endStock"));
    	sic.add(new SelectorItemInfo("LiveStockEntrys.cullQty"));
    	sic.add(new SelectorItemInfo("LiveStockEntrys.deathQty"));
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
    	sic.add(new SelectorItemInfo("entrys.standardQty"));
    	sic.add(new SelectorItemInfo("entrys.actualQty"));
    	sic.add(new SelectorItemInfo("entrys.remark"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.pigHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.pigHouse.id"));
			sic.add(new SelectorItemInfo("entrys.pigHouse.name"));
        	sic.add(new SelectorItemInfo("entrys.pigHouse.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.FeedDetailEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.FeedDetailEntry.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.FeedDetailEntry.id"));
		}
    	sic.add(new SelectorItemInfo("entrys.FeedDetailEntry.pigNumber"));
    	sic.add(new SelectorItemInfo("entrys.FeedDetailEntry.feedQty"));
    	sic.add(new SelectorItemInfo("ImmuneEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ImmuneEntrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ImmuneEntrys.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("ImmuneEntrys.material.id"));
			sic.add(new SelectorItemInfo("ImmuneEntrys.material.number"));
			sic.add(new SelectorItemInfo("ImmuneEntrys.material.name"));
		}
    	sic.add(new SelectorItemInfo("ImmuneEntrys.qty"));
    	sic.add(new SelectorItemInfo("ImmuneEntrys.unit"));
    	sic.add(new SelectorItemInfo("ImmuneEntrys.remark"));
    	sic.add(new SelectorItemInfo("ImmuneEntrys.materialName"));
    	sic.add(new SelectorItemInfo("ImmuneEntrys.immuneMode"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ImmuneEntrys.pigHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("ImmuneEntrys.pigHouse.id"));
			sic.add(new SelectorItemInfo("ImmuneEntrys.pigHouse.name"));
        	sic.add(new SelectorItemInfo("ImmuneEntrys.pigHouse.number"));
		}
    	sic.add(new SelectorItemInfo("ImmuneEntrys.immuneSourceType"));
    	sic.add(new SelectorItemInfo("ImmuneEntrys.ImmuneDetailEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ImmuneEntrys.ImmuneDetailEntry.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("ImmuneEntrys.ImmuneDetailEntry.id"));
		}
    	sic.add(new SelectorItemInfo("ImmuneEntrys.ImmuneDetailEntry.pigNumber"));
    	sic.add(new SelectorItemInfo("DCEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("DCEntrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("DCEntrys.remark"));
    	sic.add(new SelectorItemInfo("DCEntrys.deathQty"));
    	sic.add(new SelectorItemInfo("DCEntrys.deathWeight"));
    	sic.add(new SelectorItemInfo("DCEntrys.reason"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("DCEntrys.pigHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("DCEntrys.pigHouse.id"));
			sic.add(new SelectorItemInfo("DCEntrys.pigHouse.name"));
        	sic.add(new SelectorItemInfo("DCEntrys.pigHouse.number"));
		}
    	sic.add(new SelectorItemInfo("DCEntrys.perWeight"));
    	sic.add(new SelectorItemInfo("DCEntrys.DeathEarNumberEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("DCEntrys.DeathEarNumberEntrys.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("DCEntrys.DeathEarNumberEntrys.id"));
		}
    	sic.add(new SelectorItemInfo("DCEntrys.DeathEarNumberEntrys.pigNumber"));
    	sic.add(new SelectorItemInfo("DCEntrys.DeathEarNumberEntrys.remark"));
    	sic.add(new SelectorItemInfo("CullEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("CullEntrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("CullEntrys.pigHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("CullEntrys.pigHouse.id"));
			sic.add(new SelectorItemInfo("CullEntrys.pigHouse.name"));
        	sic.add(new SelectorItemInfo("CullEntrys.pigHouse.number"));
		}
    	sic.add(new SelectorItemInfo("CullEntrys.cullQty"));
    	sic.add(new SelectorItemInfo("CullEntrys.cullWeight"));
    	sic.add(new SelectorItemInfo("CullEntrys.reason"));
    	sic.add(new SelectorItemInfo("CullEntrys.remark"));
    	sic.add(new SelectorItemInfo("CullEntrys.perWeight"));
    	sic.add(new SelectorItemInfo("CullEntrys.CullEarNumberEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("CullEntrys.CullEarNumberEntrys.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("CullEntrys.CullEarNumberEntrys.id"));
		}
    	sic.add(new SelectorItemInfo("CullEntrys.CullEarNumberEntrys.pigNumber"));
    	sic.add(new SelectorItemInfo("CullEntrys.CullEarNumberEntrys.remark"));
    	sic.add(new SelectorItemInfo("OutEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("OutEntrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("OutEntrys.qty"));
    	sic.add(new SelectorItemInfo("OutEntrys.weight"));
    	sic.add(new SelectorItemInfo("OutEntrys.avgWeight"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("OutEntrys.pigHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("OutEntrys.pigHouse.id"));
			sic.add(new SelectorItemInfo("OutEntrys.pigHouse.name"));
        	sic.add(new SelectorItemInfo("OutEntrys.pigHouse.number"));
		}
    	sic.add(new SelectorItemInfo("OutEntrys.outLevel"));
    	sic.add(new SelectorItemInfo("OutEntrys.remark"));
    	sic.add(new SelectorItemInfo("OutEntrys.allWeight"));
    	sic.add(new SelectorItemInfo("OutEntrys.OutEarNumberEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("OutEntrys.OutEarNumberEntrys.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("OutEntrys.OutEarNumberEntrys.id"));
		}
    	sic.add(new SelectorItemInfo("OutEntrys.OutEarNumberEntrys.pigNumber"));
    	sic.add(new SelectorItemInfo("OutEntrys.OutEarNumberEntrys.remark"));
    	sic.add(new SelectorItemInfo("EnviConEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EnviConEntry.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("EnviConEntry.breedTimes"));
    	sic.add(new SelectorItemInfo("EnviConEntry.lightingTimes"));
    	sic.add(new SelectorItemInfo("EnviConEntry.temperatureFrom"));
    	sic.add(new SelectorItemInfo("EnviConEntry.temperatureTo"));
    	sic.add(new SelectorItemInfo("EnviConEntry.humidityFrom"));
    	sic.add(new SelectorItemInfo("EnviConEntry.humidityTo"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EnviConEntry.pigHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EnviConEntry.pigHouse.id"));
			sic.add(new SelectorItemInfo("EnviConEntry.pigHouse.name"));
        	sic.add(new SelectorItemInfo("EnviConEntry.pigHouse.number"));
		}
        sic.add(new SelectorItemInfo("breedLog"));
        sic.add(new SelectorItemInfo("auditTime"));
        sic.add(new SelectorItemInfo("baseStatus"));
        sic.add(new SelectorItemInfo("weather"));
        sic.add(new SelectorItemInfo("outHumidityTo"));
        sic.add(new SelectorItemInfo("outHumidityFrom"));
        sic.add(new SelectorItemInfo("outTemperatureTo"));
        sic.add(new SelectorItemInfo("outTemperatureFrom"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("pigBatch.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("pigBatch.id"));
        	sic.add(new SelectorItemInfo("pigBatch.number"));
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
        sic.add(new SelectorItemInfo("warn"));
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
        com.kingdee.eas.farm.pig.ccpig.CCPigDailyFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.pig.ccpig.CCPigDailyFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractCCPigDailyEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractCCPigDailyEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.pig.ccpig.client", "CCPigDailyEditUI");
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
        return com.kingdee.eas.farm.pig.ccpig.client.CCPigDailyEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.pig.ccpig.CCPigDailyFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.pig.ccpig.CCPigDailyInfo objectValue = new com.kingdee.eas.farm.pig.ccpig.CCPigDailyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/pig/ccpig/CCPigDaily";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.pig.ccpig.app.CCPigDailyQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"pigHouse").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"猪舍"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"material").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"饲料"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"actualQty").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"实际饲喂量(kg)"});
			}
		}
		for (int i=0,n=kdtImmuneEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtImmuneEntrys.getCell(i,"pigHouse").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"猪舍"});
			}
		}
		for (int i=0,n=kdtImmuneEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtImmuneEntrys.getCell(i,"material").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"疫苗"});
			}
		}
		for (int i=0,n=kdtImmuneEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtImmuneEntrys.getCell(i,"materialName").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"疫苗名称"});
			}
		}
		for (int i=0,n=kdtImmuneEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtImmuneEntrys.getCell(i,"immuneMode").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"免疫方式"});
			}
		}
		for (int i=0,n=kdtImmuneEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtImmuneEntrys.getCell(i,"qty").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"使用数量"});
			}
		}
		for (int i=0,n=kdtOutEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtOutEntrys.getCell(i,"pigHouse").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"猪舍"});
			}
		}
		for (int i=0,n=kdtOutEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtOutEntrys.getCell(i,"qty").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"头数"});
			}
		}
		for (int i=0,n=kdtEnviConEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEnviConEntry.getCell(i,"pigHouse").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"猪舍"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtpigBatch.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"批次编号"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtfarm.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖场"});
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
			setTableToSumField(kdtEntrys,new String[] {"standardQty"});
		}


}