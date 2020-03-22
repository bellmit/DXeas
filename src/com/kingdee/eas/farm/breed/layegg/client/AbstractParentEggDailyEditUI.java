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
public abstract class AbstractParentEggDailyEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractParentEggDailyEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweek;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweekDay;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel1;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfeedFarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatch;
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
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtTransEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtTransEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtImmuneEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtImmuneEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtFodderEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtFodderEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedLog;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane scrollPanebreedLog;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtbreedLog;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtweek;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtweekDay;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfeedFarm;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbatch;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnRefreshInventory;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnGenNextBill;
    protected com.kingdee.eas.farm.breed.layegg.ParentEggDailyInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionGenNextBill actionGenNextBill = null;
    protected ActionReShareInfos actionReShareInfos = null;
    protected ActionRefreshInventory actionRefreshInventory = null;
    /**
     * output class constructor
     */
    public AbstractParentEggDailyEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractParentEggDailyEditUI.class.getName());
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
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweek = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweekDay = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabel1 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDLabel2 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.contfeedFarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbatch = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
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
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtTransEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtImmuneEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtFodderEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contbreedLog = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.scrollPanebreedLog = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txtbreedLog = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtweek = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtweekDay = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtfeedFarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbatch = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
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
        this.contauditTime.setName("contauditTime");
        this.contweek.setName("contweek");
        this.contweekDay.setName("contweekDay");
        this.kDLabel1.setName("kDLabel1");
        this.kDLabel2.setName("kDLabel2");
        this.contfeedFarm.setName("contfeedFarm");
        this.contbatch.setName("contbatch");
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
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel3.setName("kDPanel3");
        this.kDPanel4.setName("kDPanel4");
        this.kdtEntrys.setName("kdtEntrys");
        this.kdtTransEntrys.setName("kdtTransEntrys");
        this.kdtImmuneEntrys.setName("kdtImmuneEntrys");
        this.kdtFodderEntrys.setName("kdtFodderEntrys");
        this.contbreedLog.setName("contbreedLog");
        this.scrollPanebreedLog.setName("scrollPanebreedLog");
        this.txtbreedLog.setName("txtbreedLog");
        this.baseStatus.setName("baseStatus");
        this.pkauditTime.setName("pkauditTime");
        this.txtweek.setName("txtweek");
        this.txtweekDay.setName("txtweekDay");
        this.prmtfeedFarm.setName("prmtfeedFarm");
        this.prmtbatch.setName("prmtbatch");
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
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
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
        // contfeedFarm		
        this.contfeedFarm.setBoundLabelText(resHelper.getString("contfeedFarm.boundLabelText"));		
        this.contfeedFarm.setBoundLabelLength(100);		
        this.contfeedFarm.setBoundLabelUnderline(true);		
        this.contfeedFarm.setVisible(true);
        // contbatch		
        this.contbatch.setBoundLabelText(resHelper.getString("contbatch.boundLabelText"));		
        this.contbatch.setBoundLabelLength(100);		
        this.contbatch.setBoundLabelUnderline(true);		
        this.contbatch.setVisible(true);
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
        // kDPanel2
        // kDPanel1
        // kDPanel3
        // kDPanel4
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"henhouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"henhouseName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"initQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"deathQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"dropQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"eggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"standardQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"actualQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"waterBegin\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"waterEndQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"waterQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{henhouse}</t:Cell><t:Cell>$Resource{henhouseName}</t:Cell><t:Cell>$Resource{initQty}</t:Cell><t:Cell>$Resource{deathQty}</t:Cell><t:Cell>$Resource{dropQty}</t:Cell><t:Cell>$Resource{eggQty}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{standardQty}</t:Cell><t:Cell>$Resource{actualQty}</t:Cell><t:Cell>$Resource{waterBegin}</t:Cell><t:Cell>$Resource{waterEndQty}</t:Cell><t:Cell>$Resource{waterQty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtEntrys.putBindContents("editData",new String[] {"id","henhouse","henhouseName","initQty","deathQty","dropQty","eggQty","material","unit","standardQty","actualQty","waterBegin","waterEndQty","waterQty"});


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
        KDFormattedTextField kdtEntrys_initQty_TextField = new KDFormattedTextField();
        kdtEntrys_initQty_TextField.setName("kdtEntrys_initQty_TextField");
        kdtEntrys_initQty_TextField.setVisible(true);
        kdtEntrys_initQty_TextField.setEditable(true);
        kdtEntrys_initQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_initQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_initQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_initQty_TextField);
        this.kdtEntrys.getColumn("initQty").setEditor(kdtEntrys_initQty_CellEditor);
        KDFormattedTextField kdtEntrys_deathQty_TextField = new KDFormattedTextField();
        kdtEntrys_deathQty_TextField.setName("kdtEntrys_deathQty_TextField");
        kdtEntrys_deathQty_TextField.setVisible(true);
        kdtEntrys_deathQty_TextField.setEditable(true);
        kdtEntrys_deathQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_deathQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_deathQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_deathQty_TextField);
        this.kdtEntrys.getColumn("deathQty").setEditor(kdtEntrys_deathQty_CellEditor);
        KDFormattedTextField kdtEntrys_dropQty_TextField = new KDFormattedTextField();
        kdtEntrys_dropQty_TextField.setName("kdtEntrys_dropQty_TextField");
        kdtEntrys_dropQty_TextField.setVisible(true);
        kdtEntrys_dropQty_TextField.setEditable(true);
        kdtEntrys_dropQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_dropQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_dropQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_dropQty_TextField);
        this.kdtEntrys.getColumn("dropQty").setEditor(kdtEntrys_dropQty_CellEditor);
        KDFormattedTextField kdtEntrys_eggQty_TextField = new KDFormattedTextField();
        kdtEntrys_eggQty_TextField.setName("kdtEntrys_eggQty_TextField");
        kdtEntrys_eggQty_TextField.setVisible(true);
        kdtEntrys_eggQty_TextField.setEditable(true);
        kdtEntrys_eggQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_eggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_eggQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_eggQty_TextField);
        this.kdtEntrys.getColumn("eggQty").setEditor(kdtEntrys_eggQty_CellEditor);
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
        kdtEntrys_material_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("material").setRenderer(kdtEntrys_material_OVR);
        KDTextField kdtEntrys_unit_TextField = new KDTextField();
        kdtEntrys_unit_TextField.setName("kdtEntrys_unit_TextField");
        kdtEntrys_unit_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_unit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_unit_TextField);
        this.kdtEntrys.getColumn("unit").setEditor(kdtEntrys_unit_CellEditor);
        KDFormattedTextField kdtEntrys_standardQty_TextField = new KDFormattedTextField();
        kdtEntrys_standardQty_TextField.setName("kdtEntrys_standardQty_TextField");
        kdtEntrys_standardQty_TextField.setVisible(true);
        kdtEntrys_standardQty_TextField.setEditable(true);
        kdtEntrys_standardQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_standardQty_TextField.setDataType(1);
        	kdtEntrys_standardQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E24"));
        	kdtEntrys_standardQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E24"));
        kdtEntrys_standardQty_TextField.setPrecision(4);
        KDTDefaultCellEditor kdtEntrys_standardQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_standardQty_TextField);
        this.kdtEntrys.getColumn("standardQty").setEditor(kdtEntrys_standardQty_CellEditor);
        KDFormattedTextField kdtEntrys_actualQty_TextField = new KDFormattedTextField();
        kdtEntrys_actualQty_TextField.setName("kdtEntrys_actualQty_TextField");
        kdtEntrys_actualQty_TextField.setVisible(true);
        kdtEntrys_actualQty_TextField.setEditable(true);
        kdtEntrys_actualQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_actualQty_TextField.setDataType(1);
        	kdtEntrys_actualQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E24"));
        	kdtEntrys_actualQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E24"));
        kdtEntrys_actualQty_TextField.setPrecision(4);
        KDTDefaultCellEditor kdtEntrys_actualQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_actualQty_TextField);
        this.kdtEntrys.getColumn("actualQty").setEditor(kdtEntrys_actualQty_CellEditor);
        KDFormattedTextField kdtEntrys_waterBegin_TextField = new KDFormattedTextField();
        kdtEntrys_waterBegin_TextField.setName("kdtEntrys_waterBegin_TextField");
        kdtEntrys_waterBegin_TextField.setVisible(true);
        kdtEntrys_waterBegin_TextField.setEditable(true);
        kdtEntrys_waterBegin_TextField.setHorizontalAlignment(2);
        kdtEntrys_waterBegin_TextField.setDataType(1);
        	kdtEntrys_waterBegin_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_waterBegin_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_waterBegin_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_waterBegin_CellEditor = new KDTDefaultCellEditor(kdtEntrys_waterBegin_TextField);
        this.kdtEntrys.getColumn("waterBegin").setEditor(kdtEntrys_waterBegin_CellEditor);
        KDFormattedTextField kdtEntrys_waterEndQty_TextField = new KDFormattedTextField();
        kdtEntrys_waterEndQty_TextField.setName("kdtEntrys_waterEndQty_TextField");
        kdtEntrys_waterEndQty_TextField.setVisible(true);
        kdtEntrys_waterEndQty_TextField.setEditable(true);
        kdtEntrys_waterEndQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_waterEndQty_TextField.setDataType(1);
        	kdtEntrys_waterEndQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_waterEndQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_waterEndQty_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_waterEndQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_waterEndQty_TextField);
        this.kdtEntrys.getColumn("waterEndQty").setEditor(kdtEntrys_waterEndQty_CellEditor);
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
        // kdtTransEntrys
		String kdtTransEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"isFromOtherBatch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"fromBatch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"fromHenhouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"toHenhouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"transQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{isFromOtherBatch}</t:Cell><t:Cell>$Resource{fromBatch}</t:Cell><t:Cell>$Resource{fromHenhouse}</t:Cell><t:Cell>$Resource{toHenhouse}</t:Cell><t:Cell>$Resource{transQty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtTransEntrys.setFormatXml(resHelper.translateString("kdtTransEntrys",kdtTransEntrysStrXML));

                this.kdtTransEntrys.putBindContents("editData",new String[] {"seq","isFromOtherBatch","fromBatch","fromHenhouse","toHenhouse","transQty"});


        this.kdtTransEntrys.checkParsed();
        KDFormattedTextField kdtTransEntrys_seq_TextField = new KDFormattedTextField();
        kdtTransEntrys_seq_TextField.setName("kdtTransEntrys_seq_TextField");
        kdtTransEntrys_seq_TextField.setVisible(true);
        kdtTransEntrys_seq_TextField.setEditable(true);
        kdtTransEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtTransEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtTransEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtTransEntrys_seq_TextField);
        this.kdtTransEntrys.getColumn("seq").setEditor(kdtTransEntrys_seq_CellEditor);
        KDCheckBox kdtTransEntrys_isFromOtherBatch_CheckBox = new KDCheckBox();
        kdtTransEntrys_isFromOtherBatch_CheckBox.setName("kdtTransEntrys_isFromOtherBatch_CheckBox");
        KDTDefaultCellEditor kdtTransEntrys_isFromOtherBatch_CellEditor = new KDTDefaultCellEditor(kdtTransEntrys_isFromOtherBatch_CheckBox);
        this.kdtTransEntrys.getColumn("isFromOtherBatch").setEditor(kdtTransEntrys_isFromOtherBatch_CellEditor);
        final KDBizPromptBox kdtTransEntrys_fromBatch_PromptBox = new KDBizPromptBox();
        kdtTransEntrys_fromBatch_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.ParentBreedBatchQuery");
        kdtTransEntrys_fromBatch_PromptBox.setVisible(true);
        kdtTransEntrys_fromBatch_PromptBox.setEditable(true);
        kdtTransEntrys_fromBatch_PromptBox.setDisplayFormat("$number$");
        kdtTransEntrys_fromBatch_PromptBox.setEditFormat("$number$");
        kdtTransEntrys_fromBatch_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtTransEntrys_fromBatch_CellEditor = new KDTDefaultCellEditor(kdtTransEntrys_fromBatch_PromptBox);
        this.kdtTransEntrys.getColumn("fromBatch").setEditor(kdtTransEntrys_fromBatch_CellEditor);
        ObjectValueRender kdtTransEntrys_fromBatch_OVR = new ObjectValueRender();
        kdtTransEntrys_fromBatch_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtTransEntrys.getColumn("fromBatch").setRenderer(kdtTransEntrys_fromBatch_OVR);
        final KDBizPromptBox kdtTransEntrys_fromHenhouse_PromptBox = new KDBizPromptBox();
        kdtTransEntrys_fromHenhouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseF7Query");
        kdtTransEntrys_fromHenhouse_PromptBox.setVisible(true);
        kdtTransEntrys_fromHenhouse_PromptBox.setEditable(true);
        kdtTransEntrys_fromHenhouse_PromptBox.setDisplayFormat("$number$");
        kdtTransEntrys_fromHenhouse_PromptBox.setEditFormat("$number$");
        kdtTransEntrys_fromHenhouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtTransEntrys_fromHenhouse_CellEditor = new KDTDefaultCellEditor(kdtTransEntrys_fromHenhouse_PromptBox);
        this.kdtTransEntrys.getColumn("fromHenhouse").setEditor(kdtTransEntrys_fromHenhouse_CellEditor);
        ObjectValueRender kdtTransEntrys_fromHenhouse_OVR = new ObjectValueRender();
        kdtTransEntrys_fromHenhouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtTransEntrys.getColumn("fromHenhouse").setRenderer(kdtTransEntrys_fromHenhouse_OVR);
        final KDBizPromptBox kdtTransEntrys_toHenhouse_PromptBox = new KDBizPromptBox();
        kdtTransEntrys_toHenhouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseF7Query");
        kdtTransEntrys_toHenhouse_PromptBox.setVisible(true);
        kdtTransEntrys_toHenhouse_PromptBox.setEditable(true);
        kdtTransEntrys_toHenhouse_PromptBox.setDisplayFormat("$number$");
        kdtTransEntrys_toHenhouse_PromptBox.setEditFormat("$number$");
        kdtTransEntrys_toHenhouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtTransEntrys_toHenhouse_CellEditor = new KDTDefaultCellEditor(kdtTransEntrys_toHenhouse_PromptBox);
        this.kdtTransEntrys.getColumn("toHenhouse").setEditor(kdtTransEntrys_toHenhouse_CellEditor);
        ObjectValueRender kdtTransEntrys_toHenhouse_OVR = new ObjectValueRender();
        kdtTransEntrys_toHenhouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtTransEntrys.getColumn("toHenhouse").setRenderer(kdtTransEntrys_toHenhouse_OVR);
        KDFormattedTextField kdtTransEntrys_transQty_TextField = new KDFormattedTextField();
        kdtTransEntrys_transQty_TextField.setName("kdtTransEntrys_transQty_TextField");
        kdtTransEntrys_transQty_TextField.setVisible(true);
        kdtTransEntrys_transQty_TextField.setEditable(true);
        kdtTransEntrys_transQty_TextField.setHorizontalAlignment(2);
        kdtTransEntrys_transQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtTransEntrys_transQty_CellEditor = new KDTDefaultCellEditor(kdtTransEntrys_transQty_TextField);
        this.kdtTransEntrys.getColumn("transQty").setEditor(kdtTransEntrys_transQty_CellEditor);
        // kdtImmuneEntrys
		String kdtImmuneEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"vaccineMaterial\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"vaccineUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"vaccineGetQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"vaccineUsedQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol4\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{vaccineMaterial}</t:Cell><t:Cell>$Resource{vaccineUnit}</t:Cell><t:Cell>$Resource{vaccineGetQty}</t:Cell><t:Cell>$Resource{vaccineUsedQty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtImmuneEntrys.putBindContents("editData",new String[] {"seq","vaccineMaterial","vaccineUnit","vaccineGetQty","vaccineUsedQty"});


        this.kdtImmuneEntrys.checkParsed();
        KDFormattedTextField kdtImmuneEntrys_seq_TextField = new KDFormattedTextField();
        kdtImmuneEntrys_seq_TextField.setName("kdtImmuneEntrys_seq_TextField");
        kdtImmuneEntrys_seq_TextField.setVisible(true);
        kdtImmuneEntrys_seq_TextField.setEditable(true);
        kdtImmuneEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtImmuneEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtImmuneEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_seq_TextField);
        this.kdtImmuneEntrys.getColumn("seq").setEditor(kdtImmuneEntrys_seq_CellEditor);
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
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
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
        // prmtfeedFarm		
        this.prmtfeedFarm.setQueryInfo("com.kingdee.eas.farm.breed.app.BreedStoorgSetQuery");		
        this.prmtfeedFarm.setEditable(true);		
        this.prmtfeedFarm.setDisplayFormat("$name$");		
        this.prmtfeedFarm.setEditFormat("$number$");		
        this.prmtfeedFarm.setCommitFormat("$number$");		
        this.prmtfeedFarm.setRequired(false);
        // prmtbatch		
        this.prmtbatch.setQueryInfo("com.kingdee.eas.farm.breed.app.ParentBreedBatchQuery");		
        this.prmtbatch.setEditable(true);		
        this.prmtbatch.setDisplayFormat("$number$");		
        this.prmtbatch.setEditFormat("$number$");		
        this.prmtbatch.setCommitFormat("$number$");		
        this.prmtbatch.setRequired(false);
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
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,baseStatus,pkauditTime,txtbreedLog,txtweek,txtweekDay,prmtfeedFarm,prmtbatch,kdtEntrys,kdtImmuneEntrys,kdtFodderEntrys,kdtTransEntrys}));
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
        contNumber.setBounds(new Rectangle(14, 15, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(14, 15, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(722, 40, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(722, 40, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contDescription.setBounds(new Rectangle(14, 62, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(14, 62, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(730, 605, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(730, 605, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        paneBIZLayerControl17.setBounds(new Rectangle(15, 94, 993, 506));
        this.add(paneBIZLayerControl17, new KDLayout.Constraints(15, 94, 993, 506, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contbaseStatus.setBounds(new Rectangle(722, 17, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(722, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contauditTime.setBounds(new Rectangle(730, 627, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(730, 627, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contweek.setBounds(new Rectangle(14, 39, 151, 19));
        this.add(contweek, new KDLayout.Constraints(14, 39, 151, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contweekDay.setBounds(new Rectangle(202, 39, 39, 19));
        this.add(contweekDay, new KDLayout.Constraints(202, 39, 39, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabel1.setBounds(new Rectangle(174, 39, 22, 19));
        this.add(kDLabel1, new KDLayout.Constraints(174, 39, 22, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabel2.setBounds(new Rectangle(252, 39, 28, 19));
        this.add(kDLabel2, new KDLayout.Constraints(252, 39, 28, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfeedFarm.setBounds(new Rectangle(371, 18, 270, 19));
        this.add(contfeedFarm, new KDLayout.Constraints(371, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbatch.setBounds(new Rectangle(371, 42, 270, 19));
        this.add(contbatch, new KDLayout.Constraints(371, 42, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        paneBIZLayerControl17.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        paneBIZLayerControl17.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        paneBIZLayerControl17.add(kDPanel4, resHelper.getString("kDPanel4.constraints"));
        //baseTab
        baseTab.setLayout(new KDLayout());
        baseTab.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 473));        kdtEntrys.setBounds(new Rectangle(1, 1, 982, 435));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.breed.layegg.ParentEggDailyEntryInfo(),null,false);
        baseTab.add(kdtEntrys_detailPanel, new KDLayout.Constraints(1, 1, 982, 435, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 473));        kdtTransEntrys.setBounds(new Rectangle(1, 1, 985, 436));
        kdtTransEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtTransEntrys,new com.kingdee.eas.farm.breed.layegg.ParentEggDailyTransEntryInfo(),null,false);
        kDPanel2.add(kdtTransEntrys_detailPanel, new KDLayout.Constraints(1, 1, 985, 436, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 473));        kdtImmuneEntrys.setBounds(new Rectangle(-1, -1, 990, 436));
        kdtImmuneEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtImmuneEntrys,new com.kingdee.eas.farm.breed.layegg.ParentEggDailyImmuneEntryInfo(),null,false);
        kDPanel1.add(kdtImmuneEntrys_detailPanel, new KDLayout.Constraints(-1, -1, 990, 436, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel3
        kDPanel3.setLayout(new KDLayout());
        kDPanel3.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 473));        kdtFodderEntrys.setBounds(new Rectangle(0, 0, 987, 435));
        kdtFodderEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtFodderEntrys,new com.kingdee.eas.farm.breed.layegg.ParentEggDailyFodderEntryInfo(),null,false);
        kDPanel3.add(kdtFodderEntrys_detailPanel, new KDLayout.Constraints(0, 0, 987, 435, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel4
        kDPanel4.setLayout(new KDLayout());
        kDPanel4.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 473));        contbreedLog.setBounds(new Rectangle(-1, 0, 983, 435));
        kDPanel4.add(contbreedLog, new KDLayout.Constraints(-1, 0, 983, 435, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contbreedLog
        contbreedLog.setBoundEditor(scrollPanebreedLog);
        //scrollPanebreedLog
        scrollPanebreedLog.getViewport().add(txtbreedLog, null);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contweek
        contweek.setBoundEditor(txtweek);
        //contweekDay
        contweekDay.setBoundEditor(txtweekDay);
        //contfeedFarm
        contfeedFarm.setBoundEditor(prmtfeedFarm);
        //contbatch
        contbatch.setBoundEditor(prmtbatch);

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
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.breed.layegg.ParentEggDailyEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.waterQty", java.math.BigDecimal.class, this.kdtEntrys, "waterQty.text");
		dataBinder.registerBinding("entrys.henhouse", java.lang.Object.class, this.kdtEntrys, "henhouse.text");
		dataBinder.registerBinding("entrys.henhouseName", String.class, this.kdtEntrys, "henhouseName.text");
		dataBinder.registerBinding("entrys.initQty", int.class, this.kdtEntrys, "initQty.text");
		dataBinder.registerBinding("entrys.material", java.lang.Object.class, this.kdtEntrys, "material.text");
		dataBinder.registerBinding("entrys.standardQty", java.math.BigDecimal.class, this.kdtEntrys, "standardQty.text");
		dataBinder.registerBinding("entrys.actualQty", java.math.BigDecimal.class, this.kdtEntrys, "actualQty.text");
		dataBinder.registerBinding("entrys.unit", String.class, this.kdtEntrys, "unit.text");
		dataBinder.registerBinding("entrys.deathQty", int.class, this.kdtEntrys, "deathQty.text");
		dataBinder.registerBinding("entrys.dropQty", int.class, this.kdtEntrys, "dropQty.text");
		dataBinder.registerBinding("entrys.eggQty", int.class, this.kdtEntrys, "eggQty.text");
		dataBinder.registerBinding("entrys.waterBegin", java.math.BigDecimal.class, this.kdtEntrys, "waterBegin.text");
		dataBinder.registerBinding("entrys.waterEndQty", java.math.BigDecimal.class, this.kdtEntrys, "waterEndQty.text");
		dataBinder.registerBinding("TransEntrys.seq", int.class, this.kdtTransEntrys, "seq.text");
		dataBinder.registerBinding("TransEntrys", com.kingdee.eas.farm.breed.layegg.ParentEggDailyTransEntryInfo.class, this.kdtTransEntrys, "userObject");
		dataBinder.registerBinding("TransEntrys.isFromOtherBatch", boolean.class, this.kdtTransEntrys, "isFromOtherBatch.text");
		dataBinder.registerBinding("TransEntrys.fromBatch", java.lang.Object.class, this.kdtTransEntrys, "fromBatch.text");
		dataBinder.registerBinding("TransEntrys.fromHenhouse", java.lang.Object.class, this.kdtTransEntrys, "fromHenhouse.text");
		dataBinder.registerBinding("TransEntrys.toHenhouse", java.lang.Object.class, this.kdtTransEntrys, "toHenhouse.text");
		dataBinder.registerBinding("TransEntrys.transQty", int.class, this.kdtTransEntrys, "transQty.text");
		dataBinder.registerBinding("ImmuneEntrys.seq", int.class, this.kdtImmuneEntrys, "seq.text");
		dataBinder.registerBinding("ImmuneEntrys", com.kingdee.eas.farm.breed.layegg.ParentEggDailyImmuneEntryInfo.class, this.kdtImmuneEntrys, "userObject");
		dataBinder.registerBinding("ImmuneEntrys.vaccineMaterial", java.lang.Object.class, this.kdtImmuneEntrys, "vaccineMaterial.text");
		dataBinder.registerBinding("ImmuneEntrys.vaccineGetQty", java.math.BigDecimal.class, this.kdtImmuneEntrys, "vaccineGetQty.text");
		dataBinder.registerBinding("ImmuneEntrys.vaccineUsedQty", java.math.BigDecimal.class, this.kdtImmuneEntrys, "vaccineUsedQty.text");
		dataBinder.registerBinding("ImmuneEntrys.vaccineUnit", String.class, this.kdtImmuneEntrys, "vaccineUnit.text");
		dataBinder.registerBinding("FodderEntrys.seq", int.class, this.kdtFodderEntrys, "seq.text");
		dataBinder.registerBinding("FodderEntrys", com.kingdee.eas.farm.breed.layegg.ParentEggDailyFodderEntryInfo.class, this.kdtFodderEntrys, "userObject");
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
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("week", int.class, this.txtweek, "value");
		dataBinder.registerBinding("weekDay", int.class, this.txtweekDay, "value");
		dataBinder.registerBinding("feedFarm", com.kingdee.eas.farm.breed.BreedStoorgSetInfo.class, this.prmtfeedFarm, "data");
		dataBinder.registerBinding("batch", com.kingdee.eas.farm.breed.ParentBreedBatchInfo.class, this.prmtbatch, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.breed.layegg.app.ParentEggDailyEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.breed.layegg.ParentEggDailyInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.waterQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.henhouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.henhouseName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.initQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.standardQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.actualQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.deathQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.dropQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.eggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.waterBegin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.waterEndQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntrys.isFromOtherBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntrys.fromBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntrys.fromHenhouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntrys.toHenhouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntrys.transQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.vaccineMaterial", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.vaccineGetQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.vaccineUsedQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.vaccineUnit", ValidateHelper.ON_SAVE);    
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
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("week", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("weekDay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("feedFarm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batch", ValidateHelper.ON_SAVE);    		
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
kdtEntrys.getCell(rowIndex,"henhouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"henhouse").getValue(),"name")));

}

    if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"unit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"material").getValue(),"baseUnit.name")));

}


    }

    /**
     * output kdtImmuneEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtImmuneEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
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
    	sic.add(new SelectorItemInfo("entrys.waterQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.henhouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.henhouse.id"));
			sic.add(new SelectorItemInfo("entrys.henhouse.number"));
			sic.add(new SelectorItemInfo("entrys.henhouse.name"));
		}
    	sic.add(new SelectorItemInfo("entrys.henhouseName"));
    	sic.add(new SelectorItemInfo("entrys.initQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.material.id"));
			sic.add(new SelectorItemInfo("entrys.material.name"));
        	sic.add(new SelectorItemInfo("entrys.material.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.standardQty"));
    	sic.add(new SelectorItemInfo("entrys.actualQty"));
    	sic.add(new SelectorItemInfo("entrys.unit"));
    	sic.add(new SelectorItemInfo("entrys.deathQty"));
    	sic.add(new SelectorItemInfo("entrys.dropQty"));
    	sic.add(new SelectorItemInfo("entrys.eggQty"));
    	sic.add(new SelectorItemInfo("entrys.waterBegin"));
    	sic.add(new SelectorItemInfo("entrys.waterEndQty"));
    	sic.add(new SelectorItemInfo("TransEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransEntrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("TransEntrys.isFromOtherBatch"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransEntrys.fromBatch.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("TransEntrys.fromBatch.id"));
			sic.add(new SelectorItemInfo("TransEntrys.fromBatch.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransEntrys.fromHenhouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("TransEntrys.fromHenhouse.id"));
			sic.add(new SelectorItemInfo("TransEntrys.fromHenhouse.name"));
        	sic.add(new SelectorItemInfo("TransEntrys.fromHenhouse.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransEntrys.toHenhouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("TransEntrys.toHenhouse.id"));
			sic.add(new SelectorItemInfo("TransEntrys.toHenhouse.name"));
        	sic.add(new SelectorItemInfo("TransEntrys.toHenhouse.number"));
		}
    	sic.add(new SelectorItemInfo("TransEntrys.transQty"));
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
        sic.add(new SelectorItemInfo("auditTime"));
        sic.add(new SelectorItemInfo("week"));
        sic.add(new SelectorItemInfo("weekDay"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("feedFarm.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("feedFarm.id"));
        	sic.add(new SelectorItemInfo("feedFarm.number"));
        	sic.add(new SelectorItemInfo("feedFarm.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("batch.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("batch.id"));
        	sic.add(new SelectorItemInfo("batch.number"));
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
        com.kingdee.eas.farm.breed.layegg.ParentEggDailyFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.breed.layegg.ParentEggDailyFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionGenNextBill_actionPerformed method
     */
    public void actionGenNextBill_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.breed.layegg.ParentEggDailyFactory.getRemoteInstance().genNextBill(editData);
    }
    	

    /**
     * output actionReShareInfos_actionPerformed method
     */
    public void actionReShareInfos_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.breed.layegg.ParentEggDailyFactory.getRemoteInstance().reShareInfos(editData);
    }
    	

    /**
     * output actionRefreshInventory_actionPerformed method
     */
    public void actionRefreshInventory_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.breed.layegg.ParentEggDailyFactory.getRemoteInstance().refreshInventory(editData);
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
            innerActionPerformed("eas", AbstractParentEggDailyEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractParentEggDailyEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractParentEggDailyEditUI.this, "ActionGenNextBill", "actionGenNextBill_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractParentEggDailyEditUI.this, "ActionReShareInfos", "actionReShareInfos_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractParentEggDailyEditUI.this, "ActionRefreshInventory", "actionRefreshInventory_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.breed.layegg.client", "ParentEggDailyEditUI");
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
        return com.kingdee.eas.farm.breed.layegg.client.ParentEggDailyEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.breed.layegg.ParentEggDailyFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.breed.layegg.ParentEggDailyInfo objectValue = new com.kingdee.eas.farm.breed.layegg.ParentEggDailyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/breed/layegg/ParentEggDaily";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.breed.layegg.app.ParentEggDailyQuery");
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
		for (int i=0,n=kdtFodderEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtFodderEntrys.getCell(i,"fodderTower").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"料塔"});
			}
		}
		for (int i=0,n=kdtFodderEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtFodderEntrys.getCell(i,"towerInventory").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"当前剩余库存(公斤)"});
			}
		}
		for (int i=0,n=kdtFodderEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtFodderEntrys.getCell(i,"fodderMaterial").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"饲料"});
			}
		}
		for (int i=0,n=kdtFodderEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtFodderEntrys.getCell(i,"fodderDate").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"要料日期"});
			}
		}
		for (int i=0,n=kdtFodderEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtFodderEntrys.getCell(i,"fodderQty").getValue())) {
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
			setTableToSumField(kdtEntrys,new String[] {"waterQty"});
			setTableToSumField(kdtFodderEntrys,new String[] {"fodderQty"});
		}


}