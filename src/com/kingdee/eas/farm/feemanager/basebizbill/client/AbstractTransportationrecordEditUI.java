/**
 * output package name
 */
package com.kingdee.eas.farm.feemanager.basebizbill.client;

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
public abstract class AbstractTransportationrecordEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractTransportationrecordEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane paneBIZLayerControl17;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcar;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfreight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompanyOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdrive;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsingleMileage;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalMileage;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contavePrice;
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
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtAssEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtAssEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtCarEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtCarEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcar;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfreight;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompanyOrgUnit;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtdrive;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsingleMileage;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalMileage;
    protected com.kingdee.bos.ctrl.swing.KDComboBox status;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtavePrice;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton audit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton auditback;
    protected javax.swing.JToolBar.Separator newSeparator1;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton calfright;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton sendend;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUpdateMileage;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAppointPerformer;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnViewUpdate;
    protected com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionAuditback actionAuditback = null;
    protected ActionSendend actionSendend = null;
    protected ActionCalfright actionCalfright = null;
    protected ActionUpdateMileage actionUpdateMileage = null;
    protected ActionAppointPerson actionAppointPerson = null;
    protected ActionViewUpdateMileage actionViewUpdateMileage = null;
    /**
     * output class constructor
     */
    public AbstractTransportationrecordEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractTransportationrecordEditUI.class.getName());
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
        //actionAuditback
        this.actionAuditback = new ActionAuditback(this);
        getActionManager().registerAction("actionAuditback", actionAuditback);
        this.actionAuditback.setBindWorkFlow(true);
        this.actionAuditback.setExtendProperty("canForewarn", "true");
        this.actionAuditback.setExtendProperty("userDefined", "false");
        this.actionAuditback.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAuditback.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAuditback.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionAuditback.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionSendend
        this.actionSendend = new ActionSendend(this);
        getActionManager().registerAction("actionSendend", actionSendend);
        this.actionSendend.setBindWorkFlow(true);
        this.actionSendend.setExtendProperty("canForewarn", "true");
        this.actionSendend.setExtendProperty("userDefined", "false");
        this.actionSendend.setExtendProperty("isObjectUpdateLock", "false");
         this.actionSendend.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionSendend.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionSendend.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionCalfright
        this.actionCalfright = new ActionCalfright(this);
        getActionManager().registerAction("actionCalfright", actionCalfright);
        this.actionCalfright.setBindWorkFlow(true);
        this.actionCalfright.setExtendProperty("canForewarn", "true");
        this.actionCalfright.setExtendProperty("userDefined", "false");
        this.actionCalfright.setExtendProperty("isObjectUpdateLock", "false");
         this.actionCalfright.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionCalfright.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionCalfright.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionUpdateMileage
        this.actionUpdateMileage = new ActionUpdateMileage(this);
        getActionManager().registerAction("actionUpdateMileage", actionUpdateMileage);
        this.actionUpdateMileage.setBindWorkFlow(true);
        this.actionUpdateMileage.setExtendProperty("canForewarn", "true");
        this.actionUpdateMileage.setExtendProperty("userDefined", "false");
        this.actionUpdateMileage.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUpdateMileage.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUpdateMileage.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionUpdateMileage.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionAppointPerson
        this.actionAppointPerson = new ActionAppointPerson(this);
        getActionManager().registerAction("actionAppointPerson", actionAppointPerson);
        this.actionAppointPerson.setBindWorkFlow(true);
        this.actionAppointPerson.setExtendProperty("canForewarn", "true");
        this.actionAppointPerson.setExtendProperty("userDefined", "false");
        this.actionAppointPerson.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAppointPerson.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAppointPerson.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionAppointPerson.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionViewUpdateMileage
        this.actionViewUpdateMileage = new ActionViewUpdateMileage(this);
        getActionManager().registerAction("actionViewUpdateMileage", actionViewUpdateMileage);
        this.actionViewUpdateMileage.setExtendProperty("canForewarn", "true");
        this.actionViewUpdateMileage.setExtendProperty("userDefined", "false");
        this.actionViewUpdateMileage.setExtendProperty("isObjectUpdateLock", "false");
         this.actionViewUpdateMileage.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionViewUpdateMileage.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.paneBIZLayerControl17 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contcar = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfreight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompanyOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdrive = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsingleMileage = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalMileage = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contavePrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
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
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtAssEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtCarEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.prmtcar = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtfreight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtcompanyOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtdrive = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtsingleMileage = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttotalMileage = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.status = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txttotalQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtavePrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.audit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.auditback = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.newSeparator1 = new javax.swing.JToolBar.Separator();
        this.calfright = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.sendend = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUpdateMileage = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnAppointPerformer = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnViewUpdate = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.paneBIZLayerControl17.setName("paneBIZLayerControl17");
        this.contcar.setName("contcar");
        this.contfreight.setName("contfreight");
        this.contcompanyOrgUnit.setName("contcompanyOrgUnit");
        this.contdrive.setName("contdrive");
        this.contsingleMileage.setName("contsingleMileage");
        this.conttotalMileage.setName("conttotalMileage");
        this.contstatus.setName("contstatus");
        this.conttotalQty.setName("conttotalQty");
        this.contavePrice.setName("contavePrice");
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
        this.kdtEntrys.setName("kdtEntrys");
        this.kdtAssEntrys.setName("kdtAssEntrys");
        this.kdtCarEntry.setName("kdtCarEntry");
        this.prmtcar.setName("prmtcar");
        this.txtfreight.setName("txtfreight");
        this.prmtcompanyOrgUnit.setName("prmtcompanyOrgUnit");
        this.prmtdrive.setName("prmtdrive");
        this.txtsingleMileage.setName("txtsingleMileage");
        this.txttotalMileage.setName("txttotalMileage");
        this.status.setName("status");
        this.txttotalQty.setName("txttotalQty");
        this.txtavePrice.setName("txtavePrice");
        this.audit.setName("audit");
        this.auditback.setName("auditback");
        this.newSeparator1.setName("newSeparator1");
        this.calfright.setName("calfright");
        this.sendend.setName("sendend");
        this.btnUpdateMileage.setName("btnUpdateMileage");
        this.btnAppointPerformer.setName("btnAppointPerformer");
        this.btnViewUpdate.setName("btnViewUpdate");
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
        // contcar		
        this.contcar.setBoundLabelText(resHelper.getString("contcar.boundLabelText"));		
        this.contcar.setBoundLabelLength(100);		
        this.contcar.setBoundLabelUnderline(true);		
        this.contcar.setVisible(true);
        // contfreight		
        this.contfreight.setBoundLabelText(resHelper.getString("contfreight.boundLabelText"));		
        this.contfreight.setBoundLabelLength(100);		
        this.contfreight.setBoundLabelUnderline(true);		
        this.contfreight.setVisible(true);
        // contcompanyOrgUnit		
        this.contcompanyOrgUnit.setBoundLabelText(resHelper.getString("contcompanyOrgUnit.boundLabelText"));		
        this.contcompanyOrgUnit.setBoundLabelLength(100);		
        this.contcompanyOrgUnit.setBoundLabelUnderline(true);		
        this.contcompanyOrgUnit.setVisible(true);
        // contdrive		
        this.contdrive.setBoundLabelText(resHelper.getString("contdrive.boundLabelText"));		
        this.contdrive.setBoundLabelLength(100);		
        this.contdrive.setBoundLabelUnderline(true);		
        this.contdrive.setVisible(true);
        // contsingleMileage		
        this.contsingleMileage.setBoundLabelText(resHelper.getString("contsingleMileage.boundLabelText"));		
        this.contsingleMileage.setBoundLabelLength(100);		
        this.contsingleMileage.setBoundLabelUnderline(true);		
        this.contsingleMileage.setVisible(true);
        // conttotalMileage		
        this.conttotalMileage.setBoundLabelText(resHelper.getString("conttotalMileage.boundLabelText"));		
        this.conttotalMileage.setBoundLabelLength(100);		
        this.conttotalMileage.setBoundLabelUnderline(true);		
        this.conttotalMileage.setVisible(true);
        // contstatus		
        this.contstatus.setBoundLabelText(resHelper.getString("contstatus.boundLabelText"));		
        this.contstatus.setBoundLabelLength(100);		
        this.contstatus.setBoundLabelUnderline(true);		
        this.contstatus.setVisible(true);
        // conttotalQty		
        this.conttotalQty.setBoundLabelText(resHelper.getString("conttotalQty.boundLabelText"));		
        this.conttotalQty.setBoundLabelLength(100);		
        this.conttotalQty.setBoundLabelUnderline(true);		
        this.conttotalQty.setVisible(true);
        // contavePrice		
        this.contavePrice.setBoundLabelText(resHelper.getString("contavePrice.boundLabelText"));		
        this.contavePrice.setBoundLabelLength(100);		
        this.contavePrice.setBoundLabelUnderline(true);		
        this.contavePrice.setVisible(true);
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
        this.pkBizDate.setEnabled(false);		
        this.pkBizDate.setRequired(false);		
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
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"salesid\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"stockout\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"salesman\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"customer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"address\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"materiel\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"materrelnumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"lossnumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"replenishnumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"realnumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{salesid}</t:Cell><t:Cell>$Resource{stockout}</t:Cell><t:Cell>$Resource{salesman}</t:Cell><t:Cell>$Resource{customer}</t:Cell><t:Cell>$Resource{address}</t:Cell><t:Cell>$Resource{materiel}</t:Cell><t:Cell>$Resource{materrelnumber}</t:Cell><t:Cell>$Resource{lossnumber}</t:Cell><t:Cell>$Resource{replenishnumber}</t:Cell><t:Cell>$Resource{realnumber}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtEntrys.putBindContents("editData",new String[] {"id","salesid","stockout","salesman","customer","address","materiel","materrelnumber","lossnumber","replenishnumber","realnumber"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_salesid_PromptBox = new KDBizPromptBox();
        kdtEntrys_salesid_PromptBox.setQueryInfo("com.kingdee.eas.scm.sd.sale.app.F7SaleOrderForQuery");
        kdtEntrys_salesid_PromptBox.setVisible(true);
        kdtEntrys_salesid_PromptBox.setEditable(true);
        kdtEntrys_salesid_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_salesid_PromptBox.setEditFormat("$number$");
        kdtEntrys_salesid_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_salesid_CellEditor = new KDTDefaultCellEditor(kdtEntrys_salesid_PromptBox);
        this.kdtEntrys.getColumn("salesid").setEditor(kdtEntrys_salesid_CellEditor);
        ObjectValueRender kdtEntrys_salesid_OVR = new ObjectValueRender();
        kdtEntrys_salesid_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("salesid").setRenderer(kdtEntrys_salesid_OVR);
        final KDBizPromptBox kdtEntrys_stockout_PromptBox = new KDBizPromptBox();
        kdtEntrys_stockout_PromptBox.setQueryInfo("com.kingdee.eas.scm.im.inv.SaleIssueBillQuery");
        kdtEntrys_stockout_PromptBox.setVisible(true);
        kdtEntrys_stockout_PromptBox.setEditable(true);
        kdtEntrys_stockout_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_stockout_PromptBox.setEditFormat("$number$");
        kdtEntrys_stockout_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_stockout_CellEditor = new KDTDefaultCellEditor(kdtEntrys_stockout_PromptBox);
        this.kdtEntrys.getColumn("stockout").setEditor(kdtEntrys_stockout_CellEditor);
        ObjectValueRender kdtEntrys_stockout_OVR = new ObjectValueRender();
        kdtEntrys_stockout_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("stockout").setRenderer(kdtEntrys_stockout_OVR);
        final KDBizPromptBox kdtEntrys_salesman_PromptBox = new KDBizPromptBox();
        kdtEntrys_salesman_PromptBox.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");
        kdtEntrys_salesman_PromptBox.setVisible(true);
        kdtEntrys_salesman_PromptBox.setEditable(true);
        kdtEntrys_salesman_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_salesman_PromptBox.setEditFormat("$number$");
        kdtEntrys_salesman_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_salesman_CellEditor = new KDTDefaultCellEditor(kdtEntrys_salesman_PromptBox);
        this.kdtEntrys.getColumn("salesman").setEditor(kdtEntrys_salesman_CellEditor);
        ObjectValueRender kdtEntrys_salesman_OVR = new ObjectValueRender();
        kdtEntrys_salesman_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("salesman").setRenderer(kdtEntrys_salesman_OVR);
        final KDBizPromptBox kdtEntrys_customer_PromptBox = new KDBizPromptBox();
        kdtEntrys_customer_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.CustomerInfoQuery");
        kdtEntrys_customer_PromptBox.setVisible(true);
        kdtEntrys_customer_PromptBox.setEditable(true);
        kdtEntrys_customer_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_customer_PromptBox.setEditFormat("$number$");
        kdtEntrys_customer_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_customer_CellEditor = new KDTDefaultCellEditor(kdtEntrys_customer_PromptBox);
        this.kdtEntrys.getColumn("customer").setEditor(kdtEntrys_customer_CellEditor);
        ObjectValueRender kdtEntrys_customer_OVR = new ObjectValueRender();
        kdtEntrys_customer_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("customer").setRenderer(kdtEntrys_customer_OVR);
        KDTextField kdtEntrys_address_TextField = new KDTextField();
        kdtEntrys_address_TextField.setName("kdtEntrys_address_TextField");
        kdtEntrys_address_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_address_CellEditor = new KDTDefaultCellEditor(kdtEntrys_address_TextField);
        this.kdtEntrys.getColumn("address").setEditor(kdtEntrys_address_CellEditor);
        final KDBizPromptBox kdtEntrys_materiel_PromptBox = new KDBizPromptBox();
        kdtEntrys_materiel_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtEntrys_materiel_PromptBox.setVisible(true);
        kdtEntrys_materiel_PromptBox.setEditable(true);
        kdtEntrys_materiel_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_materiel_PromptBox.setEditFormat("$number$");
        kdtEntrys_materiel_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_materiel_CellEditor = new KDTDefaultCellEditor(kdtEntrys_materiel_PromptBox);
        this.kdtEntrys.getColumn("materiel").setEditor(kdtEntrys_materiel_CellEditor);
        ObjectValueRender kdtEntrys_materiel_OVR = new ObjectValueRender();
        kdtEntrys_materiel_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("materiel").setRenderer(kdtEntrys_materiel_OVR);
        KDFormattedTextField kdtEntrys_materrelnumber_TextField = new KDFormattedTextField();
        kdtEntrys_materrelnumber_TextField.setName("kdtEntrys_materrelnumber_TextField");
        kdtEntrys_materrelnumber_TextField.setVisible(true);
        kdtEntrys_materrelnumber_TextField.setEditable(true);
        kdtEntrys_materrelnumber_TextField.setHorizontalAlignment(2);
        kdtEntrys_materrelnumber_TextField.setDataType(1);
        	kdtEntrys_materrelnumber_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_materrelnumber_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_materrelnumber_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_materrelnumber_CellEditor = new KDTDefaultCellEditor(kdtEntrys_materrelnumber_TextField);
        this.kdtEntrys.getColumn("materrelnumber").setEditor(kdtEntrys_materrelnumber_CellEditor);
        KDFormattedTextField kdtEntrys_lossnumber_TextField = new KDFormattedTextField();
        kdtEntrys_lossnumber_TextField.setName("kdtEntrys_lossnumber_TextField");
        kdtEntrys_lossnumber_TextField.setVisible(true);
        kdtEntrys_lossnumber_TextField.setEditable(true);
        kdtEntrys_lossnumber_TextField.setHorizontalAlignment(2);
        kdtEntrys_lossnumber_TextField.setDataType(1);
        	kdtEntrys_lossnumber_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_lossnumber_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_lossnumber_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_lossnumber_CellEditor = new KDTDefaultCellEditor(kdtEntrys_lossnumber_TextField);
        this.kdtEntrys.getColumn("lossnumber").setEditor(kdtEntrys_lossnumber_CellEditor);
        KDFormattedTextField kdtEntrys_replenishnumber_TextField = new KDFormattedTextField();
        kdtEntrys_replenishnumber_TextField.setName("kdtEntrys_replenishnumber_TextField");
        kdtEntrys_replenishnumber_TextField.setVisible(true);
        kdtEntrys_replenishnumber_TextField.setEditable(true);
        kdtEntrys_replenishnumber_TextField.setHorizontalAlignment(2);
        kdtEntrys_replenishnumber_TextField.setDataType(1);
        	kdtEntrys_replenishnumber_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_replenishnumber_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_replenishnumber_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_replenishnumber_CellEditor = new KDTDefaultCellEditor(kdtEntrys_replenishnumber_TextField);
        this.kdtEntrys.getColumn("replenishnumber").setEditor(kdtEntrys_replenishnumber_CellEditor);
        KDFormattedTextField kdtEntrys_realnumber_TextField = new KDFormattedTextField();
        kdtEntrys_realnumber_TextField.setName("kdtEntrys_realnumber_TextField");
        kdtEntrys_realnumber_TextField.setVisible(true);
        kdtEntrys_realnumber_TextField.setEditable(true);
        kdtEntrys_realnumber_TextField.setHorizontalAlignment(2);
        kdtEntrys_realnumber_TextField.setDataType(1);
        	kdtEntrys_realnumber_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_realnumber_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_realnumber_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_realnumber_CellEditor = new KDTDefaultCellEditor(kdtEntrys_realnumber_TextField);
        this.kdtEntrys.getColumn("realnumber").setEditor(kdtEntrys_realnumber_CellEditor);
        // kdtAssEntrys
		String kdtAssEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol1\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"settle\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"formula\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"price\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{settle}</t:Cell><t:Cell>$Resource{formula}</t:Cell><t:Cell>$Resource{price}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtAssEntrys.setFormatXml(resHelper.translateString("kdtAssEntrys",kdtAssEntrysStrXML));

                this.kdtAssEntrys.putBindContents("editData",new String[] {"id","settle","formula","price"});


        this.kdtAssEntrys.checkParsed();
        KDTextField kdtAssEntrys_settle_TextField = new KDTextField();
        kdtAssEntrys_settle_TextField.setName("kdtAssEntrys_settle_TextField");
        kdtAssEntrys_settle_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtAssEntrys_settle_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_settle_TextField);
        this.kdtAssEntrys.getColumn("settle").setEditor(kdtAssEntrys_settle_CellEditor);
        KDTextField kdtAssEntrys_formula_TextField = new KDTextField();
        kdtAssEntrys_formula_TextField.setName("kdtAssEntrys_formula_TextField");
        kdtAssEntrys_formula_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtAssEntrys_formula_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_formula_TextField);
        this.kdtAssEntrys.getColumn("formula").setEditor(kdtAssEntrys_formula_CellEditor);
        KDFormattedTextField kdtAssEntrys_price_TextField = new KDFormattedTextField();
        kdtAssEntrys_price_TextField.setName("kdtAssEntrys_price_TextField");
        kdtAssEntrys_price_TextField.setVisible(true);
        kdtAssEntrys_price_TextField.setEditable(true);
        kdtAssEntrys_price_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_price_TextField.setDataType(1);
        	kdtAssEntrys_price_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtAssEntrys_price_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtAssEntrys_price_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtAssEntrys_price_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_price_TextField);
        this.kdtAssEntrys.getColumn("price").setEditor(kdtAssEntrys_price_CellEditor);
        // kdtCarEntry
		String kdtCarEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"driver\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"car\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"beginDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"endDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{driver}</t:Cell><t:Cell>$Resource{car}</t:Cell><t:Cell>$Resource{beginDate}</t:Cell><t:Cell>$Resource{endDate}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtCarEntry.setFormatXml(resHelper.translateString("kdtCarEntry",kdtCarEntryStrXML));

                this.kdtCarEntry.putBindContents("editData",new String[] {"seq","driver","car","beginDate","endDate"});


        this.kdtCarEntry.checkParsed();
        final KDBizPromptBox kdtCarEntry_driver_PromptBox = new KDBizPromptBox();
        kdtCarEntry_driver_PromptBox.setQueryInfo("com.kingdee.eas.farm.feemanager.basedata.app.DriverQuery");
        kdtCarEntry_driver_PromptBox.setVisible(true);
        kdtCarEntry_driver_PromptBox.setEditable(true);
        kdtCarEntry_driver_PromptBox.setDisplayFormat("$number$");
        kdtCarEntry_driver_PromptBox.setEditFormat("$number$");
        kdtCarEntry_driver_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtCarEntry_driver_CellEditor = new KDTDefaultCellEditor(kdtCarEntry_driver_PromptBox);
        this.kdtCarEntry.getColumn("driver").setEditor(kdtCarEntry_driver_CellEditor);
        ObjectValueRender kdtCarEntry_driver_OVR = new ObjectValueRender();
        kdtCarEntry_driver_OVR.setFormat(new BizDataFormat("$drivername$"));
        this.kdtCarEntry.getColumn("driver").setRenderer(kdtCarEntry_driver_OVR);
        			kdtCarEntry_driver_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI kdtCarEntry_driver_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtCarEntry_driver_PromptBox_F7ListUI == null) {
					try {
						kdtCarEntry_driver_PromptBox_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtCarEntry_driver_PromptBox_F7ListUI));
					kdtCarEntry_driver_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtCarEntry_driver_PromptBox.setSelector(kdtCarEntry_driver_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtCarEntry_car_PromptBox = new KDBizPromptBox();
        kdtCarEntry_car_PromptBox.setQueryInfo("com.kingdee.eas.publicdata.app.CarQuery");
        kdtCarEntry_car_PromptBox.setVisible(true);
        kdtCarEntry_car_PromptBox.setEditable(true);
        kdtCarEntry_car_PromptBox.setDisplayFormat("$number$");
        kdtCarEntry_car_PromptBox.setEditFormat("$number$");
        kdtCarEntry_car_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtCarEntry_car_CellEditor = new KDTDefaultCellEditor(kdtCarEntry_car_PromptBox);
        this.kdtCarEntry.getColumn("car").setEditor(kdtCarEntry_car_CellEditor);
        ObjectValueRender kdtCarEntry_car_OVR = new ObjectValueRender();
        kdtCarEntry_car_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtCarEntry.getColumn("car").setRenderer(kdtCarEntry_car_OVR);
        			kdtCarEntry_car_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.CarListUI kdtCarEntry_car_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtCarEntry_car_PromptBox_F7ListUI == null) {
					try {
						kdtCarEntry_car_PromptBox_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.CarListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtCarEntry_car_PromptBox_F7ListUI));
					kdtCarEntry_car_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtCarEntry_car_PromptBox.setSelector(kdtCarEntry_car_PromptBox_F7ListUI);
				}
			}
		});
					
        KDDatePicker kdtCarEntry_beginDate_DatePicker = new KDDatePicker();
        kdtCarEntry_beginDate_DatePicker.setName("kdtCarEntry_beginDate_DatePicker");
        kdtCarEntry_beginDate_DatePicker.setVisible(true);
        kdtCarEntry_beginDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtCarEntry_beginDate_CellEditor = new KDTDefaultCellEditor(kdtCarEntry_beginDate_DatePicker);
        this.kdtCarEntry.getColumn("beginDate").setEditor(kdtCarEntry_beginDate_CellEditor);
        KDDatePicker kdtCarEntry_endDate_DatePicker = new KDDatePicker();
        kdtCarEntry_endDate_DatePicker.setName("kdtCarEntry_endDate_DatePicker");
        kdtCarEntry_endDate_DatePicker.setVisible(true);
        kdtCarEntry_endDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtCarEntry_endDate_CellEditor = new KDTDefaultCellEditor(kdtCarEntry_endDate_DatePicker);
        this.kdtCarEntry.getColumn("endDate").setEditor(kdtCarEntry_endDate_CellEditor);
        // prmtcar		
        this.prmtcar.setQueryInfo("com.kingdee.eas.publicdata.app.CarQuery");		
        this.prmtcar.setEditable(true);		
        this.prmtcar.setDisplayFormat("$name$");		
        this.prmtcar.setEditFormat("$number$");		
        this.prmtcar.setCommitFormat("$number$");		
        this.prmtcar.setRequired(false);
        		prmtcar.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.CarListUI prmtcar_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtcar_F7ListUI == null) {
					try {
						prmtcar_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.CarListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtcar_F7ListUI));
					prmtcar_F7ListUI.setF7Use(true,ctx);
					prmtcar.setSelector(prmtcar_F7ListUI);
				}
			}
		});
					
        prmtcar.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtcar_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtfreight		
        this.txtfreight.setHorizontalAlignment(2);		
        this.txtfreight.setDataType(1);		
        this.txtfreight.setSupportedEmpty(true);		
        this.txtfreight.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfreight.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfreight.setPrecision(2);		
        this.txtfreight.setRequired(false);
        // prmtcompanyOrgUnit		
        this.prmtcompanyOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompanyOrgUnit.setEditable(true);		
        this.prmtcompanyOrgUnit.setDisplayFormat("$name$");		
        this.prmtcompanyOrgUnit.setEditFormat("$number$");		
        this.prmtcompanyOrgUnit.setCommitFormat("$number$");		
        this.prmtcompanyOrgUnit.setRequired(true);
        // prmtdrive		
        this.prmtdrive.setQueryInfo("com.kingdee.eas.farm.feemanager.basedata.app.DriverQuery");		
        this.prmtdrive.setEditable(true);		
        this.prmtdrive.setDisplayFormat("$drivername$");		
        this.prmtdrive.setEditFormat("$number$");		
        this.prmtdrive.setCommitFormat("$number$");		
        this.prmtdrive.setRequired(false);
        		prmtdrive.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI prmtdrive_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtdrive_F7ListUI == null) {
					try {
						prmtdrive_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtdrive_F7ListUI));
					prmtdrive_F7ListUI.setF7Use(true,ctx);
					prmtdrive.setSelector(prmtdrive_F7ListUI);
				}
			}
		});
					
        // txtsingleMileage		
        this.txtsingleMileage.setVisible(true);		
        this.txtsingleMileage.setHorizontalAlignment(2);		
        this.txtsingleMileage.setDataType(1);		
        this.txtsingleMileage.setSupportedEmpty(true);		
        this.txtsingleMileage.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsingleMileage.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsingleMileage.setPrecision(4);		
        this.txtsingleMileage.setRequired(false);
        // txttotalMileage		
        this.txttotalMileage.setVisible(true);		
        this.txttotalMileage.setHorizontalAlignment(2);		
        this.txttotalMileage.setDataType(1);		
        this.txttotalMileage.setSupportedEmpty(true);		
        this.txttotalMileage.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttotalMileage.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttotalMileage.setPrecision(4);		
        this.txttotalMileage.setRequired(false);
        // status		
        this.status.setVisible(true);		
        this.status.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.feemanager.basebizbill.BillStatusEnum").toArray());		
        this.status.setRequired(false);		
        this.status.setEnabled(false);
        // txttotalQty		
        this.txttotalQty.setVisible(true);		
        this.txttotalQty.setDataType(1);		
        this.txttotalQty.setSupportedEmpty(true);		
        this.txttotalQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttotalQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttotalQty.setPrecision(4);		
        this.txttotalQty.setRequired(false);		
        this.txttotalQty.setEnabled(false);
        // txtavePrice		
        this.txtavePrice.setVisible(true);		
        this.txtavePrice.setDataType(1);		
        this.txtavePrice.setSupportedEmpty(true);		
        this.txtavePrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtavePrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtavePrice.setPrecision(4);		
        this.txtavePrice.setRequired(false);		
        this.txtavePrice.setEnabled(false);
        // audit
        this.audit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.audit.setText(resHelper.getString("audit.text"));
        // auditback
        this.auditback.setAction((IItemAction)ActionProxyFactory.getProxy(actionAuditback, new Class[] { IItemAction.class }, getServiceContext()));		
        this.auditback.setText(resHelper.getString("auditback.text"));
        // newSeparator1		
        this.newSeparator1.setOrientation(1);
        // calfright
        this.calfright.setAction((IItemAction)ActionProxyFactory.getProxy(actionCalfright, new Class[] { IItemAction.class }, getServiceContext()));		
        this.calfright.setText(resHelper.getString("calfright.text"));
        // sendend
        this.sendend.setAction((IItemAction)ActionProxyFactory.getProxy(actionSendend, new Class[] { IItemAction.class }, getServiceContext()));		
        this.sendend.setText(resHelper.getString("sendend.text"));
        // btnUpdateMileage
        this.btnUpdateMileage.setAction((IItemAction)ActionProxyFactory.getProxy(actionUpdateMileage, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUpdateMileage.setText(resHelper.getString("btnUpdateMileage.text"));
        // btnAppointPerformer
        this.btnAppointPerformer.setAction((IItemAction)ActionProxyFactory.getProxy(actionAppointPerson, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAppointPerformer.setText(resHelper.getString("btnAppointPerformer.text"));
        // btnViewUpdate
        this.btnViewUpdate.setAction((IItemAction)ActionProxyFactory.getProxy(actionViewUpdateMileage, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnViewUpdate.setText(resHelper.getString("btnViewUpdate.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,prmtcar,txtfreight,prmtcompanyOrgUnit,prmtdrive,kdtAssEntrys,kdtEntrys,txtsingleMileage,txttotalMileage,status,txttotalQty,txtavePrice}));
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
        contCreator.setBounds(new Rectangle(367, 562, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(367, 562, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(729, 562, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(729, 562, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(367, 593, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(367, 593, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(729, 593, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(729, 593, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(14, 17, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(14, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(367, 17, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(367, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(734, -96, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(734, -96, 270, 19, 0));
        contAuditor.setBounds(new Rectangle(13, 593, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(13, 593, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        paneBIZLayerControl17.setBounds(new Rectangle(6, 155, 993, 397));
        this.add(paneBIZLayerControl17, new KDLayout.Constraints(6, 155, 993, 397, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contcar.setBounds(new Rectangle(14, 53, 270, 19));
        this.add(contcar, new KDLayout.Constraints(14, 53, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfreight.setBounds(new Rectangle(729, 53, 270, 19));
        this.add(contfreight, new KDLayout.Constraints(729, 53, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompanyOrgUnit.setBounds(new Rectangle(729, 89, 270, 19));
        this.add(contcompanyOrgUnit, new KDLayout.Constraints(729, 89, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contdrive.setBounds(new Rectangle(14, 89, 270, 19));
        this.add(contdrive, new KDLayout.Constraints(14, 89, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsingleMileage.setBounds(new Rectangle(367, 53, 270, 19));
        this.add(contsingleMileage, new KDLayout.Constraints(367, 53, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttotalMileage.setBounds(new Rectangle(367, 89, 270, 19));
        this.add(conttotalMileage, new KDLayout.Constraints(367, 89, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contstatus.setBounds(new Rectangle(729, 17, 270, 19));
        this.add(contstatus, new KDLayout.Constraints(729, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conttotalQty.setBounds(new Rectangle(14, 126, 270, 19));
        this.add(conttotalQty, new KDLayout.Constraints(14, 126, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contavePrice.setBounds(new Rectangle(367, 126, 270, 19));
        this.add(contavePrice, new KDLayout.Constraints(367, 126, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //baseTab
        baseTab.setLayout(new KDLayout());
        baseTab.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 364));        kdtEntrys.setBounds(new Rectangle(0, 1, 975, 384));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordEntryInfo(),null,false);
        baseTab.add(kdtEntrys_detailPanel, new KDLayout.Constraints(0, 1, 975, 384, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //assTab
        assTab.setLayout(new KDLayout());
        assTab.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 364));        kdtAssEntrys.setBounds(new Rectangle(1, 1, 979, 385));
        kdtAssEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtAssEntrys,new com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordAssEntryInfo(),null,false);
        assTab.add(kdtAssEntrys_detailPanel, new KDLayout.Constraints(1, 1, 979, 385, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 364));        kdtCarEntry.setBounds(new Rectangle(6, 9, 976, 379));
        kdtCarEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtCarEntry,new com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordCarEntryInfo(),null,false);
        kDPanel1.add(kdtCarEntry_detailPanel, new KDLayout.Constraints(6, 9, 976, 379, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contcar
        contcar.setBoundEditor(prmtcar);
        //contfreight
        contfreight.setBoundEditor(txtfreight);
        //contcompanyOrgUnit
        contcompanyOrgUnit.setBoundEditor(prmtcompanyOrgUnit);
        //contdrive
        contdrive.setBoundEditor(prmtdrive);
        //contsingleMileage
        contsingleMileage.setBoundEditor(txtsingleMileage);
        //conttotalMileage
        conttotalMileage.setBoundEditor(txttotalMileage);
        //contstatus
        contstatus.setBoundEditor(status);
        //conttotalQty
        conttotalQty.setBoundEditor(txttotalQty);
        //contavePrice
        contavePrice.setBoundEditor(txtavePrice);

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
        this.toolBar.add(audit);
        this.toolBar.add(auditback);
        this.toolBar.add(btnVoucher);
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(btnNextPerson);
        this.toolBar.add(newSeparator1);
        this.toolBar.add(calfright);
        this.toolBar.add(sendend);
        this.toolBar.add(btnUpdateMileage);
        this.toolBar.add(btnAppointPerformer);
        this.toolBar.add(btnViewUpdate);


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
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.salesid", java.lang.Object.class, this.kdtEntrys, "salesid.text");
		dataBinder.registerBinding("entrys.stockout", java.lang.Object.class, this.kdtEntrys, "stockout.text");
		dataBinder.registerBinding("entrys.salesman", java.lang.Object.class, this.kdtEntrys, "salesman.text");
		dataBinder.registerBinding("entrys.address", String.class, this.kdtEntrys, "address.text");
		dataBinder.registerBinding("entrys.customer", java.lang.Object.class, this.kdtEntrys, "customer.text");
		dataBinder.registerBinding("entrys.materrelnumber", java.math.BigDecimal.class, this.kdtEntrys, "materrelnumber.text");
		dataBinder.registerBinding("entrys.materiel", java.lang.Object.class, this.kdtEntrys, "materiel.text");
		dataBinder.registerBinding("entrys.lossnumber", java.math.BigDecimal.class, this.kdtEntrys, "lossnumber.text");
		dataBinder.registerBinding("entrys.realnumber", java.math.BigDecimal.class, this.kdtEntrys, "realnumber.text");
		dataBinder.registerBinding("entrys.replenishnumber", java.math.BigDecimal.class, this.kdtEntrys, "replenishnumber.text");
		dataBinder.registerBinding("AssEntrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtAssEntrys, "id.text");
		dataBinder.registerBinding("AssEntrys", com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordAssEntryInfo.class, this.kdtAssEntrys, "userObject");
		dataBinder.registerBinding("AssEntrys.settle", String.class, this.kdtAssEntrys, "settle.text");
		dataBinder.registerBinding("AssEntrys.price", java.math.BigDecimal.class, this.kdtAssEntrys, "price.text");
		dataBinder.registerBinding("AssEntrys.formula", String.class, this.kdtAssEntrys, "formula.text");
		dataBinder.registerBinding("CarEntry.seq", int.class, this.kdtCarEntry, "seq.text");
		dataBinder.registerBinding("CarEntry", com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordCarEntryInfo.class, this.kdtCarEntry, "userObject");
		dataBinder.registerBinding("CarEntry.driver", java.lang.Object.class, this.kdtCarEntry, "driver.text");
		dataBinder.registerBinding("CarEntry.car", java.lang.Object.class, this.kdtCarEntry, "car.text");
		dataBinder.registerBinding("CarEntry.beginDate", java.util.Date.class, this.kdtCarEntry, "beginDate.text");
		dataBinder.registerBinding("CarEntry.endDate", java.util.Date.class, this.kdtCarEntry, "endDate.text");
		dataBinder.registerBinding("car", com.kingdee.eas.publicdata.CarInfo.class, this.prmtcar, "data");
		dataBinder.registerBinding("freight", java.math.BigDecimal.class, this.txtfreight, "value");
		dataBinder.registerBinding("companyOrgUnit", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompanyOrgUnit, "data");
		dataBinder.registerBinding("drive", com.kingdee.eas.farm.feemanager.basedata.DriverInfo.class, this.prmtdrive, "data");
		dataBinder.registerBinding("singleMileage", java.math.BigDecimal.class, this.txtsingleMileage, "value");
		dataBinder.registerBinding("totalMileage", java.math.BigDecimal.class, this.txttotalMileage, "value");
		dataBinder.registerBinding("status", com.kingdee.eas.farm.feemanager.basebizbill.BillStatusEnum.class, this.status, "selectedItem");
		dataBinder.registerBinding("totalQty", java.math.BigDecimal.class, this.txttotalQty, "value");
		dataBinder.registerBinding("avePrice", java.math.BigDecimal.class, this.txtavePrice, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.feemanager.basebizbill.app.TransportationrecordEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.salesid", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.stockout", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.salesman", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.address", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.customer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.materrelnumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.materiel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.lossnumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.realnumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.replenishnumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.settle", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.price", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.formula", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CarEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CarEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CarEntry.driver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CarEntry.car", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CarEntry.beginDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CarEntry.endDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("car", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("freight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("companyOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("drive", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("singleMileage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalMileage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("status", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("avePrice", ValidateHelper.ON_SAVE);    		
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
            if ("salesid".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"salesman").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"salesid").getValue(),"salePerson.name")));

}

    if ("salesid".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"customer").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"salesid").getValue(),"orderCustomer.name")));

}


    }

    /**
     * output prmtcar_Changed() method
     */
    public void prmtcar_Changed() throws Exception
    {
        System.out.println("prmtcar_Changed() Function is executed!");
            prmtdrive.setData(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtcar.getData(),"driver.name"));


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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.salesid.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.salesid.id"));
			sic.add(new SelectorItemInfo("entrys.salesid.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.stockout.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.stockout.id"));
			sic.add(new SelectorItemInfo("entrys.stockout.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.salesman.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.salesman.id"));
			sic.add(new SelectorItemInfo("entrys.salesman.name"));
        	sic.add(new SelectorItemInfo("entrys.salesman.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.address"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.customer.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.customer.id"));
			sic.add(new SelectorItemInfo("entrys.customer.name"));
        	sic.add(new SelectorItemInfo("entrys.customer.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.materrelnumber"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.materiel.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.materiel.id"));
			sic.add(new SelectorItemInfo("entrys.materiel.name"));
        	sic.add(new SelectorItemInfo("entrys.materiel.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.lossnumber"));
    	sic.add(new SelectorItemInfo("entrys.realnumber"));
    	sic.add(new SelectorItemInfo("entrys.replenishnumber"));
    	sic.add(new SelectorItemInfo("AssEntrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("AssEntrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("AssEntrys.settle"));
    	sic.add(new SelectorItemInfo("AssEntrys.price"));
    	sic.add(new SelectorItemInfo("AssEntrys.formula"));
    	sic.add(new SelectorItemInfo("CarEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("CarEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("CarEntry.driver.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("CarEntry.driver.id"));
			sic.add(new SelectorItemInfo("CarEntry.driver.drivername"));
			sic.add(new SelectorItemInfo("CarEntry.driver.name"));
        	sic.add(new SelectorItemInfo("CarEntry.driver.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("CarEntry.car.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("CarEntry.car.id"));
			sic.add(new SelectorItemInfo("CarEntry.car.name"));
        	sic.add(new SelectorItemInfo("CarEntry.car.number"));
		}
    	sic.add(new SelectorItemInfo("CarEntry.beginDate"));
    	sic.add(new SelectorItemInfo("CarEntry.endDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("car.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("car.id"));
        	sic.add(new SelectorItemInfo("car.number"));
        	sic.add(new SelectorItemInfo("car.name"));
		}
        sic.add(new SelectorItemInfo("freight"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("companyOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("companyOrgUnit.id"));
        	sic.add(new SelectorItemInfo("companyOrgUnit.number"));
        	sic.add(new SelectorItemInfo("companyOrgUnit.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("drive.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("drive.id"));
        	sic.add(new SelectorItemInfo("drive.number"));
        	sic.add(new SelectorItemInfo("drive.name"));
        	sic.add(new SelectorItemInfo("drive.drivername"));
		}
        sic.add(new SelectorItemInfo("singleMileage"));
        sic.add(new SelectorItemInfo("totalMileage"));
        sic.add(new SelectorItemInfo("status"));
        sic.add(new SelectorItemInfo("totalQty"));
        sic.add(new SelectorItemInfo("avePrice"));
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
        com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionAuditback_actionPerformed method
     */
    public void actionAuditback_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordFactory.getRemoteInstance().auditback(editData);
    }
    	

    /**
     * output actionSendend_actionPerformed method
     */
    public void actionSendend_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordFactory.getRemoteInstance().sendend(editData);
    }
    	

    /**
     * output actionCalfright_actionPerformed method
     */
    public void actionCalfright_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordFactory.getRemoteInstance().calfright(editData);
    }
    	

    /**
     * output actionUpdateMileage_actionPerformed method
     */
    public void actionUpdateMileage_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordFactory.getRemoteInstance().updateMileage(editData);
    }
    	

    /**
     * output actionAppointPerson_actionPerformed method
     */
    public void actionAppointPerson_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordFactory.getRemoteInstance().appointPerson(editData);
    }
    	

    /**
     * output actionViewUpdateMileage_actionPerformed method
     */
    public void actionViewUpdateMileage_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordFactory.getRemoteInstance().viewUpdateMileage(editData);
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
	public RequestContext prepareActionAuditback(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAuditback() {
    	return false;
    }
	public RequestContext prepareActionSendend(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionSendend() {
    	return false;
    }
	public RequestContext prepareActionCalfright(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionCalfright() {
    	return false;
    }
	public RequestContext prepareActionUpdateMileage(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionUpdateMileage() {
    	return false;
    }
	public RequestContext prepareActionAppointPerson(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAppointPerson() {
    	return false;
    }
	public RequestContext prepareActionViewUpdateMileage(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionViewUpdateMileage() {
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
            innerActionPerformed("eas", AbstractTransportationrecordEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionAuditback class
     */     
    protected class ActionAuditback extends ItemAction {     
    
        public ActionAuditback()
        {
            this(null);
        }

        public ActionAuditback(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionAuditback.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAuditback.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAuditback.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractTransportationrecordEditUI.this, "ActionAuditback", "actionAuditback_actionPerformed", e);
        }
    }

    /**
     * output ActionSendend class
     */     
    protected class ActionSendend extends ItemAction {     
    
        public ActionSendend()
        {
            this(null);
        }

        public ActionSendend(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionSendend.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionSendend.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionSendend.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractTransportationrecordEditUI.this, "ActionSendend", "actionSendend_actionPerformed", e);
        }
    }

    /**
     * output ActionCalfright class
     */     
    protected class ActionCalfright extends ItemAction {     
    
        public ActionCalfright()
        {
            this(null);
        }

        public ActionCalfright(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionCalfright.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCalfright.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCalfright.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractTransportationrecordEditUI.this, "ActionCalfright", "actionCalfright_actionPerformed", e);
        }
    }

    /**
     * output ActionUpdateMileage class
     */     
    protected class ActionUpdateMileage extends ItemAction {     
    
        public ActionUpdateMileage()
        {
            this(null);
        }

        public ActionUpdateMileage(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionUpdateMileage.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUpdateMileage.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUpdateMileage.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractTransportationrecordEditUI.this, "ActionUpdateMileage", "actionUpdateMileage_actionPerformed", e);
        }
    }

    /**
     * output ActionAppointPerson class
     */     
    protected class ActionAppointPerson extends ItemAction {     
    
        public ActionAppointPerson()
        {
            this(null);
        }

        public ActionAppointPerson(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionAppointPerson.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAppointPerson.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAppointPerson.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractTransportationrecordEditUI.this, "ActionAppointPerson", "actionAppointPerson_actionPerformed", e);
        }
    }

    /**
     * output ActionViewUpdateMileage class
     */     
    protected class ActionViewUpdateMileage extends ItemAction {     
    
        public ActionViewUpdateMileage()
        {
            this(null);
        }

        public ActionViewUpdateMileage(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionViewUpdateMileage.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionViewUpdateMileage.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionViewUpdateMileage.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractTransportationrecordEditUI.this, "ActionViewUpdateMileage", "actionViewUpdateMileage_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.feemanager.basebizbill.client", "TransportationrecordEditUI");
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
        return com.kingdee.eas.farm.feemanager.basebizbill.client.TransportationrecordEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordInfo objectValue = new com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/feemanager/basebizbill/Transportationrecord";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.feemanager.basebizbill.app.TransportationrecordQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompanyOrgUnit.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
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
		vo.put("status","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}