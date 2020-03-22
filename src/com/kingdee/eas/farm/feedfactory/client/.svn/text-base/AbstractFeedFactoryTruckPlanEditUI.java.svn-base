/**
 * output package name
 */
package com.kingdee.eas.farm.feedfactory.client;

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
public abstract class AbstractFeedFactoryTruckPlanEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractFeedFactoryTruckPlanEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtAssEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtAssEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDButton btnGetPlan;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUp;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnDown;
    protected com.kingdee.bos.ctrl.swing.KDButton btnGeneteTruckPlan;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbeginTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlunchBeginTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlunchEndTime;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnSplit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contprepackedTruckCount;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkorderByTruck;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtTruckEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtTruckEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.swing.KDTimePicker beginTime;
    protected com.kingdee.bos.ctrl.swing.KDTimePicker lunchBeginTime;
    protected com.kingdee.bos.ctrl.swing.KDTimePicker lunchEndTime;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtprepackedTruckCount;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanInfo editData = null;
    protected ActionGetFodderPlan actionGetFodderPlan = null;
    protected ActionGenerateTruckPlan actionGenerateTruckPlan = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractFeedFactoryTruckPlanEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractFeedFactoryTruckPlanEditUI.class.getName());
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
        //actionGetFodderPlan
        this.actionGetFodderPlan = new ActionGetFodderPlan(this);
        getActionManager().registerAction("actionGetFodderPlan", actionGetFodderPlan);
        this.actionGetFodderPlan.setExtendProperty("canForewarn", "true");
        this.actionGetFodderPlan.setExtendProperty("userDefined", "true");
        this.actionGetFodderPlan.setExtendProperty("isObjectUpdateLock", "false");
         this.actionGetFodderPlan.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionGetFodderPlan.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionGenerateTruckPlan
        this.actionGenerateTruckPlan = new ActionGenerateTruckPlan(this);
        getActionManager().registerAction("actionGenerateTruckPlan", actionGenerateTruckPlan);
        this.actionGenerateTruckPlan.setExtendProperty("canForewarn", "true");
        this.actionGenerateTruckPlan.setExtendProperty("userDefined", "true");
        this.actionGenerateTruckPlan.setExtendProperty("isObjectUpdateLock", "false");
         this.actionGenerateTruckPlan.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionGenerateTruckPlan.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
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
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtAssEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.btnGetPlan = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnUp = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnDown = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnGeneteTruckPlan = new com.kingdee.bos.ctrl.swing.KDButton();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbeginTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlunchBeginTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlunchEndTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnSplit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contprepackedTruckCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkorderByTruck = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.kdtTruckEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.beginTime = new com.kingdee.bos.ctrl.swing.KDTimePicker();
        this.lunchBeginTime = new com.kingdee.bos.ctrl.swing.KDTimePicker();
        this.lunchEndTime = new com.kingdee.bos.ctrl.swing.KDTimePicker();
        this.txtprepackedTruckCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
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
        this.kdtEntrys.setName("kdtEntrys");
        this.kdtAssEntrys.setName("kdtAssEntrys");
        this.btnGetPlan.setName("btnGetPlan");
        this.btnUp.setName("btnUp");
        this.btnDown.setName("btnDown");
        this.btnGeneteTruckPlan.setName("btnGeneteTruckPlan");
        this.contauditTime.setName("contauditTime");
        this.contbaseStatus.setName("contbaseStatus");
        this.contbeginTime.setName("contbeginTime");
        this.contlunchBeginTime.setName("contlunchBeginTime");
        this.contlunchEndTime.setName("contlunchEndTime");
        this.btnSplit.setName("btnSplit");
        this.contprepackedTruckCount.setName("contprepackedTruckCount");
        this.chkorderByTruck.setName("chkorderByTruck");
        this.kdtTruckEntrys.setName("kdtTruckEntrys");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.pkauditTime.setName("pkauditTime");
        this.baseStatus.setName("baseStatus");
        this.beginTime.setName("beginTime");
        this.lunchBeginTime.setName("lunchBeginTime");
        this.lunchEndTime.setName("lunchEndTime");
        this.txtprepackedTruckCount.setName("txtprepackedTruckCount");
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
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol9\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol16\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol17\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol18\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"planSeq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"farm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"tower\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"materialName\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"farmDesc\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"truck\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"truckSeq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"drive\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"tel\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"fodderPort\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"haveLunch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"lunchPlace\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"beginLoadTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"leaveFFTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"truckArriveTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"leaveFarmTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /><t:Column t:key=\"backToFFTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"materialID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{planSeq}</t:Cell><t:Cell>$Resource{farm}</t:Cell><t:Cell>$Resource{tower}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{farmDesc}</t:Cell><t:Cell>$Resource{truck}</t:Cell><t:Cell>$Resource{truckSeq}</t:Cell><t:Cell>$Resource{drive}</t:Cell><t:Cell>$Resource{tel}</t:Cell><t:Cell>$Resource{fodderPort}</t:Cell><t:Cell>$Resource{haveLunch}</t:Cell><t:Cell>$Resource{lunchPlace}</t:Cell><t:Cell>$Resource{beginLoadTime}</t:Cell><t:Cell>$Resource{leaveFFTime}</t:Cell><t:Cell>$Resource{truckArriveTime}</t:Cell><t:Cell>$Resource{leaveFarmTime}</t:Cell><t:Cell>$Resource{backToFFTime}</t:Cell><t:Cell>$Resource{materialID}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtEntrys.putBindContents("editData",new String[] {"id","planSeq","farm","tower","materialName","farmDesc","truck","truckSeq","drive","tel","fodderPort","haveLunch","lunchPlace","beginLoadTime","leaveFFTime","truckArriveTime","leaveFarmTime","backToFFTime","materialID"});


        this.kdtEntrys.checkParsed();
        KDFormattedTextField kdtEntrys_planSeq_TextField = new KDFormattedTextField();
        kdtEntrys_planSeq_TextField.setName("kdtEntrys_planSeq_TextField");
        kdtEntrys_planSeq_TextField.setVisible(true);
        kdtEntrys_planSeq_TextField.setEditable(true);
        kdtEntrys_planSeq_TextField.setHorizontalAlignment(2);
        kdtEntrys_planSeq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_planSeq_CellEditor = new KDTDefaultCellEditor(kdtEntrys_planSeq_TextField);
        this.kdtEntrys.getColumn("planSeq").setEditor(kdtEntrys_planSeq_CellEditor);
        final KDBizPromptBox kdtEntrys_farm_PromptBox = new KDBizPromptBox();
        kdtEntrys_farm_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");
        kdtEntrys_farm_PromptBox.setVisible(true);
        kdtEntrys_farm_PromptBox.setEditable(true);
        kdtEntrys_farm_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_farm_PromptBox.setEditFormat("$number$");
        kdtEntrys_farm_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_farm_CellEditor = new KDTDefaultCellEditor(kdtEntrys_farm_PromptBox);
        this.kdtEntrys.getColumn("farm").setEditor(kdtEntrys_farm_CellEditor);
        ObjectValueRender kdtEntrys_farm_OVR = new ObjectValueRender();
        kdtEntrys_farm_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("farm").setRenderer(kdtEntrys_farm_OVR);
        final KDBizPromptBox kdtEntrys_tower_PromptBox = new KDBizPromptBox();
        kdtEntrys_tower_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7AllWarehouseQuery");
        kdtEntrys_tower_PromptBox.setVisible(true);
        kdtEntrys_tower_PromptBox.setEditable(true);
        kdtEntrys_tower_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_tower_PromptBox.setEditFormat("$number$");
        kdtEntrys_tower_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_tower_CellEditor = new KDTDefaultCellEditor(kdtEntrys_tower_PromptBox);
        this.kdtEntrys.getColumn("tower").setEditor(kdtEntrys_tower_CellEditor);
        ObjectValueRender kdtEntrys_tower_OVR = new ObjectValueRender();
        kdtEntrys_tower_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("tower").setRenderer(kdtEntrys_tower_OVR);
        KDTextField kdtEntrys_materialName_TextField = new KDTextField();
        kdtEntrys_materialName_TextField.setName("kdtEntrys_materialName_TextField");
        kdtEntrys_materialName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_materialName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_materialName_TextField);
        this.kdtEntrys.getColumn("materialName").setEditor(kdtEntrys_materialName_CellEditor);
        KDTextField kdtEntrys_farmDesc_TextField = new KDTextField();
        kdtEntrys_farmDesc_TextField.setName("kdtEntrys_farmDesc_TextField");
        kdtEntrys_farmDesc_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_farmDesc_CellEditor = new KDTDefaultCellEditor(kdtEntrys_farmDesc_TextField);
        this.kdtEntrys.getColumn("farmDesc").setEditor(kdtEntrys_farmDesc_CellEditor);
        final KDBizPromptBox kdtEntrys_truck_PromptBox = new KDBizPromptBox();
        kdtEntrys_truck_PromptBox.setQueryInfo("com.kingdee.eas.farm.feedfactory.app.FeedTruckQuery");
        kdtEntrys_truck_PromptBox.setVisible(true);
        kdtEntrys_truck_PromptBox.setEditable(true);
        kdtEntrys_truck_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_truck_PromptBox.setEditFormat("$number$");
        kdtEntrys_truck_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_truck_CellEditor = new KDTDefaultCellEditor(kdtEntrys_truck_PromptBox);
        this.kdtEntrys.getColumn("truck").setEditor(kdtEntrys_truck_CellEditor);
        ObjectValueRender kdtEntrys_truck_OVR = new ObjectValueRender();
        kdtEntrys_truck_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("truck").setRenderer(kdtEntrys_truck_OVR);
        			kdtEntrys_truck_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feedfactory.client.FeedTruckListUI kdtEntrys_truck_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_truck_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_truck_PromptBox_F7ListUI = new com.kingdee.eas.farm.feedfactory.client.FeedTruckListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_truck_PromptBox_F7ListUI));
					kdtEntrys_truck_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_truck_PromptBox.setSelector(kdtEntrys_truck_PromptBox_F7ListUI);
				}
			}
		});
					
        KDFormattedTextField kdtEntrys_truckSeq_TextField = new KDFormattedTextField();
        kdtEntrys_truckSeq_TextField.setName("kdtEntrys_truckSeq_TextField");
        kdtEntrys_truckSeq_TextField.setVisible(true);
        kdtEntrys_truckSeq_TextField.setEditable(true);
        kdtEntrys_truckSeq_TextField.setHorizontalAlignment(2);
        kdtEntrys_truckSeq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_truckSeq_CellEditor = new KDTDefaultCellEditor(kdtEntrys_truckSeq_TextField);
        this.kdtEntrys.getColumn("truckSeq").setEditor(kdtEntrys_truckSeq_CellEditor);
        KDTextField kdtEntrys_drive_TextField = new KDTextField();
        kdtEntrys_drive_TextField.setName("kdtEntrys_drive_TextField");
        kdtEntrys_drive_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_drive_CellEditor = new KDTDefaultCellEditor(kdtEntrys_drive_TextField);
        this.kdtEntrys.getColumn("drive").setEditor(kdtEntrys_drive_CellEditor);
        KDTextField kdtEntrys_tel_TextField = new KDTextField();
        kdtEntrys_tel_TextField.setName("kdtEntrys_tel_TextField");
        kdtEntrys_tel_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_tel_CellEditor = new KDTDefaultCellEditor(kdtEntrys_tel_TextField);
        this.kdtEntrys.getColumn("tel").setEditor(kdtEntrys_tel_CellEditor);
        KDTextField kdtEntrys_fodderPort_TextField = new KDTextField();
        kdtEntrys_fodderPort_TextField.setName("kdtEntrys_fodderPort_TextField");
        kdtEntrys_fodderPort_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_fodderPort_CellEditor = new KDTDefaultCellEditor(kdtEntrys_fodderPort_TextField);
        this.kdtEntrys.getColumn("fodderPort").setEditor(kdtEntrys_fodderPort_CellEditor);
        KDCheckBox kdtEntrys_haveLunch_CheckBox = new KDCheckBox();
        kdtEntrys_haveLunch_CheckBox.setName("kdtEntrys_haveLunch_CheckBox");
        KDTDefaultCellEditor kdtEntrys_haveLunch_CellEditor = new KDTDefaultCellEditor(kdtEntrys_haveLunch_CheckBox);
        this.kdtEntrys.getColumn("haveLunch").setEditor(kdtEntrys_haveLunch_CellEditor);
        KDTextField kdtEntrys_lunchPlace_TextField = new KDTextField();
        kdtEntrys_lunchPlace_TextField.setName("kdtEntrys_lunchPlace_TextField");
        kdtEntrys_lunchPlace_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_lunchPlace_CellEditor = new KDTDefaultCellEditor(kdtEntrys_lunchPlace_TextField);
        this.kdtEntrys.getColumn("lunchPlace").setEditor(kdtEntrys_lunchPlace_CellEditor);
        KDDatePicker kdtEntrys_beginLoadTime_DatePicker = new KDDatePicker();
        kdtEntrys_beginLoadTime_DatePicker.setName("kdtEntrys_beginLoadTime_DatePicker");
        kdtEntrys_beginLoadTime_DatePicker.setVisible(true);
        kdtEntrys_beginLoadTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_beginLoadTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_beginLoadTime_DatePicker);
        this.kdtEntrys.getColumn("beginLoadTime").setEditor(kdtEntrys_beginLoadTime_CellEditor);
        KDDatePicker kdtEntrys_leaveFFTime_DatePicker = new KDDatePicker();
        kdtEntrys_leaveFFTime_DatePicker.setName("kdtEntrys_leaveFFTime_DatePicker");
        kdtEntrys_leaveFFTime_DatePicker.setVisible(true);
        kdtEntrys_leaveFFTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_leaveFFTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_leaveFFTime_DatePicker);
        this.kdtEntrys.getColumn("leaveFFTime").setEditor(kdtEntrys_leaveFFTime_CellEditor);
        KDDatePicker kdtEntrys_truckArriveTime_DatePicker = new KDDatePicker();
        kdtEntrys_truckArriveTime_DatePicker.setName("kdtEntrys_truckArriveTime_DatePicker");
        kdtEntrys_truckArriveTime_DatePicker.setVisible(true);
        kdtEntrys_truckArriveTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_truckArriveTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_truckArriveTime_DatePicker);
        this.kdtEntrys.getColumn("truckArriveTime").setEditor(kdtEntrys_truckArriveTime_CellEditor);
        KDDatePicker kdtEntrys_leaveFarmTime_DatePicker = new KDDatePicker();
        kdtEntrys_leaveFarmTime_DatePicker.setName("kdtEntrys_leaveFarmTime_DatePicker");
        kdtEntrys_leaveFarmTime_DatePicker.setVisible(true);
        kdtEntrys_leaveFarmTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_leaveFarmTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_leaveFarmTime_DatePicker);
        this.kdtEntrys.getColumn("leaveFarmTime").setEditor(kdtEntrys_leaveFarmTime_CellEditor);
        KDDatePicker kdtEntrys_backToFFTime_DatePicker = new KDDatePicker();
        kdtEntrys_backToFFTime_DatePicker.setName("kdtEntrys_backToFFTime_DatePicker");
        kdtEntrys_backToFFTime_DatePicker.setVisible(true);
        kdtEntrys_backToFFTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_backToFFTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_backToFFTime_DatePicker);
        this.kdtEntrys.getColumn("backToFFTime").setEditor(kdtEntrys_backToFFTime_CellEditor);
        KDTextField kdtEntrys_materialID_TextField = new KDTextField();
        kdtEntrys_materialID_TextField.setName("kdtEntrys_materialID_TextField");
        kdtEntrys_materialID_TextField.setMaxLength(44);
        KDTDefaultCellEditor kdtEntrys_materialID_CellEditor = new KDTDefaultCellEditor(kdtEntrys_materialID_TextField);
        this.kdtEntrys.getColumn("materialID").setEditor(kdtEntrys_materialID_CellEditor);
        // kdtAssEntrys
		String kdtAssEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"farm\" t:width=\"80\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"tower\" t:width=\"50\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"inventory\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"material\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"fodderQty\" t:width=\"80\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"farmDesc\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"isIgnore\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"truck\" t:width=\"50\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"truckCount\" t:width=\"80\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"mergeTrunckNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"fodderPort\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{farm}</t:Cell><t:Cell>$Resource{tower}</t:Cell><t:Cell>$Resource{inventory}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{fodderQty}</t:Cell><t:Cell>$Resource{farmDesc}</t:Cell><t:Cell>$Resource{isIgnore}</t:Cell><t:Cell>$Resource{truck}</t:Cell><t:Cell>$Resource{truckCount}</t:Cell><t:Cell>$Resource{mergeTrunckNum}</t:Cell><t:Cell>$Resource{fodderPort}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtAssEntrys.setFormatXml(resHelper.translateString("kdtAssEntrys",kdtAssEntrysStrXML));

                this.kdtAssEntrys.putBindContents("editData",new String[] {"id","farm","tower","inventory","material","fodderQty","farmDesc","isIgnore","truck","truckCount","mergeTrunckNum","fodderPort"});


        this.kdtAssEntrys.checkParsed();
        final KDBizPromptBox kdtAssEntrys_farm_PromptBox = new KDBizPromptBox();
        kdtAssEntrys_farm_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");
        kdtAssEntrys_farm_PromptBox.setVisible(true);
        kdtAssEntrys_farm_PromptBox.setEditable(true);
        kdtAssEntrys_farm_PromptBox.setDisplayFormat("$number$");
        kdtAssEntrys_farm_PromptBox.setEditFormat("$number$");
        kdtAssEntrys_farm_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtAssEntrys_farm_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_farm_PromptBox);
        this.kdtAssEntrys.getColumn("farm").setEditor(kdtAssEntrys_farm_CellEditor);
        ObjectValueRender kdtAssEntrys_farm_OVR = new ObjectValueRender();
        kdtAssEntrys_farm_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtAssEntrys.getColumn("farm").setRenderer(kdtAssEntrys_farm_OVR);
        final KDBizPromptBox kdtAssEntrys_tower_PromptBox = new KDBizPromptBox();
        kdtAssEntrys_tower_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7AllWarehouseQuery");
        kdtAssEntrys_tower_PromptBox.setVisible(true);
        kdtAssEntrys_tower_PromptBox.setEditable(true);
        kdtAssEntrys_tower_PromptBox.setDisplayFormat("$number$");
        kdtAssEntrys_tower_PromptBox.setEditFormat("$number$");
        kdtAssEntrys_tower_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtAssEntrys_tower_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_tower_PromptBox);
        this.kdtAssEntrys.getColumn("tower").setEditor(kdtAssEntrys_tower_CellEditor);
        ObjectValueRender kdtAssEntrys_tower_OVR = new ObjectValueRender();
        kdtAssEntrys_tower_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtAssEntrys.getColumn("tower").setRenderer(kdtAssEntrys_tower_OVR);
        KDFormattedTextField kdtAssEntrys_inventory_TextField = new KDFormattedTextField();
        kdtAssEntrys_inventory_TextField.setName("kdtAssEntrys_inventory_TextField");
        kdtAssEntrys_inventory_TextField.setVisible(true);
        kdtAssEntrys_inventory_TextField.setEditable(true);
        kdtAssEntrys_inventory_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_inventory_TextField.setDataType(1);
        	kdtAssEntrys_inventory_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtAssEntrys_inventory_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtAssEntrys_inventory_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtAssEntrys_inventory_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_inventory_TextField);
        this.kdtAssEntrys.getColumn("inventory").setEditor(kdtAssEntrys_inventory_CellEditor);
        final KDBizPromptBox kdtAssEntrys_material_PromptBox = new KDBizPromptBox();
        kdtAssEntrys_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtAssEntrys_material_PromptBox.setVisible(true);
        kdtAssEntrys_material_PromptBox.setEditable(true);
        kdtAssEntrys_material_PromptBox.setDisplayFormat("$number$");
        kdtAssEntrys_material_PromptBox.setEditFormat("$number$");
        kdtAssEntrys_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtAssEntrys_material_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_material_PromptBox);
        this.kdtAssEntrys.getColumn("material").setEditor(kdtAssEntrys_material_CellEditor);
        ObjectValueRender kdtAssEntrys_material_OVR = new ObjectValueRender();
        kdtAssEntrys_material_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtAssEntrys.getColumn("material").setRenderer(kdtAssEntrys_material_OVR);
        KDFormattedTextField kdtAssEntrys_fodderQty_TextField = new KDFormattedTextField();
        kdtAssEntrys_fodderQty_TextField.setName("kdtAssEntrys_fodderQty_TextField");
        kdtAssEntrys_fodderQty_TextField.setVisible(true);
        kdtAssEntrys_fodderQty_TextField.setEditable(true);
        kdtAssEntrys_fodderQty_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_fodderQty_TextField.setDataType(1);
        	kdtAssEntrys_fodderQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtAssEntrys_fodderQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtAssEntrys_fodderQty_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtAssEntrys_fodderQty_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_fodderQty_TextField);
        this.kdtAssEntrys.getColumn("fodderQty").setEditor(kdtAssEntrys_fodderQty_CellEditor);
        KDTextField kdtAssEntrys_farmDesc_TextField = new KDTextField();
        kdtAssEntrys_farmDesc_TextField.setName("kdtAssEntrys_farmDesc_TextField");
        kdtAssEntrys_farmDesc_TextField.setMaxLength(200);
        KDTDefaultCellEditor kdtAssEntrys_farmDesc_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_farmDesc_TextField);
        this.kdtAssEntrys.getColumn("farmDesc").setEditor(kdtAssEntrys_farmDesc_CellEditor);
        KDCheckBox kdtAssEntrys_isIgnore_CheckBox = new KDCheckBox();
        kdtAssEntrys_isIgnore_CheckBox.setName("kdtAssEntrys_isIgnore_CheckBox");
        KDTDefaultCellEditor kdtAssEntrys_isIgnore_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_isIgnore_CheckBox);
        this.kdtAssEntrys.getColumn("isIgnore").setEditor(kdtAssEntrys_isIgnore_CellEditor);
        final KDBizPromptBox kdtAssEntrys_truck_PromptBox = new KDBizPromptBox();
        kdtAssEntrys_truck_PromptBox.setQueryInfo("com.kingdee.eas.farm.feedfactory.app.FeedTruckQuery");
        kdtAssEntrys_truck_PromptBox.setVisible(true);
        kdtAssEntrys_truck_PromptBox.setEditable(true);
        kdtAssEntrys_truck_PromptBox.setDisplayFormat("$number$");
        kdtAssEntrys_truck_PromptBox.setEditFormat("$number$");
        kdtAssEntrys_truck_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtAssEntrys_truck_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_truck_PromptBox);
        this.kdtAssEntrys.getColumn("truck").setEditor(kdtAssEntrys_truck_CellEditor);
        ObjectValueRender kdtAssEntrys_truck_OVR = new ObjectValueRender();
        kdtAssEntrys_truck_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtAssEntrys.getColumn("truck").setRenderer(kdtAssEntrys_truck_OVR);
        			kdtAssEntrys_truck_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feedfactory.client.FeedTruckListUI kdtAssEntrys_truck_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtAssEntrys_truck_PromptBox_F7ListUI == null) {
					try {
						kdtAssEntrys_truck_PromptBox_F7ListUI = new com.kingdee.eas.farm.feedfactory.client.FeedTruckListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtAssEntrys_truck_PromptBox_F7ListUI));
					kdtAssEntrys_truck_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtAssEntrys_truck_PromptBox.setSelector(kdtAssEntrys_truck_PromptBox_F7ListUI);
				}
			}
		});
					
        KDFormattedTextField kdtAssEntrys_truckCount_TextField = new KDFormattedTextField();
        kdtAssEntrys_truckCount_TextField.setName("kdtAssEntrys_truckCount_TextField");
        kdtAssEntrys_truckCount_TextField.setVisible(true);
        kdtAssEntrys_truckCount_TextField.setEditable(true);
        kdtAssEntrys_truckCount_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_truckCount_TextField.setDataType(0);
        KDTDefaultCellEditor kdtAssEntrys_truckCount_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_truckCount_TextField);
        this.kdtAssEntrys.getColumn("truckCount").setEditor(kdtAssEntrys_truckCount_CellEditor);
        KDTextField kdtAssEntrys_mergeTrunckNum_TextField = new KDTextField();
        kdtAssEntrys_mergeTrunckNum_TextField.setName("kdtAssEntrys_mergeTrunckNum_TextField");
        kdtAssEntrys_mergeTrunckNum_TextField.setMaxLength(20);
        KDTDefaultCellEditor kdtAssEntrys_mergeTrunckNum_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_mergeTrunckNum_TextField);
        this.kdtAssEntrys.getColumn("mergeTrunckNum").setEditor(kdtAssEntrys_mergeTrunckNum_CellEditor);
        KDTextField kdtAssEntrys_fodderPort_TextField = new KDTextField();
        kdtAssEntrys_fodderPort_TextField.setName("kdtAssEntrys_fodderPort_TextField");
        kdtAssEntrys_fodderPort_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtAssEntrys_fodderPort_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_fodderPort_TextField);
        this.kdtAssEntrys.getColumn("fodderPort").setEditor(kdtAssEntrys_fodderPort_CellEditor);
        // btnGetPlan
        this.btnGetPlan.setAction((IItemAction)ActionProxyFactory.getProxy(actionGetFodderPlan, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnGetPlan.setText(resHelper.getString("btnGetPlan.text"));
        // btnUp		
        this.btnUp.setText(resHelper.getString("btnUp.text"));
        this.btnUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnUp_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnDown		
        this.btnDown.setText(resHelper.getString("btnDown.text"));
        this.btnDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnDown_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnGeneteTruckPlan
        this.btnGeneteTruckPlan.setAction((IItemAction)ActionProxyFactory.getProxy(actionGenerateTruckPlan, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnGeneteTruckPlan.setText(resHelper.getString("btnGeneteTruckPlan.text"));
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
        // contbeginTime		
        this.contbeginTime.setBoundLabelText(resHelper.getString("contbeginTime.boundLabelText"));		
        this.contbeginTime.setBoundLabelLength(100);		
        this.contbeginTime.setBoundLabelUnderline(true);		
        this.contbeginTime.setVisible(true);
        // contlunchBeginTime		
        this.contlunchBeginTime.setBoundLabelText(resHelper.getString("contlunchBeginTime.boundLabelText"));		
        this.contlunchBeginTime.setBoundLabelLength(100);		
        this.contlunchBeginTime.setBoundLabelUnderline(true);		
        this.contlunchBeginTime.setVisible(true);
        // contlunchEndTime		
        this.contlunchEndTime.setBoundLabelText(resHelper.getString("contlunchEndTime.boundLabelText"));		
        this.contlunchEndTime.setBoundLabelLength(100);		
        this.contlunchEndTime.setBoundLabelUnderline(true);		
        this.contlunchEndTime.setVisible(true);
        // btnSplit		
        this.btnSplit.setText(resHelper.getString("btnSplit.text"));
        this.btnSplit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnSplit_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // contprepackedTruckCount		
        this.contprepackedTruckCount.setBoundLabelText(resHelper.getString("contprepackedTruckCount.boundLabelText"));		
        this.contprepackedTruckCount.setBoundLabelLength(100);		
        this.contprepackedTruckCount.setBoundLabelUnderline(true);		
        this.contprepackedTruckCount.setVisible(true);
        // chkorderByTruck		
        this.chkorderByTruck.setText(resHelper.getString("chkorderByTruck.text"));		
        this.chkorderByTruck.setHorizontalAlignment(2);
        // kdtTruckEntrys
		String kdtTruckEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;time</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;time</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"0\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"truck\" t:width=\"50\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"allCount\" t:width=\"50\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"lunchPlace\" t:width=\"80\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"beginTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"endTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{truck}</t:Cell><t:Cell>$Resource{allCount}</t:Cell><t:Cell>$Resource{lunchPlace}</t:Cell><t:Cell>$Resource{beginTime}</t:Cell><t:Cell>$Resource{endTime}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtTruckEntrys.setFormatXml(resHelper.translateString("kdtTruckEntrys",kdtTruckEntrysStrXML));

                this.kdtTruckEntrys.putBindContents("editData",new String[] {"seq","truck","allCount","lunchPlace","beginTime","endTime"});


        this.kdtTruckEntrys.checkParsed();
        KDFormattedTextField kdtTruckEntrys_seq_TextField = new KDFormattedTextField();
        kdtTruckEntrys_seq_TextField.setName("kdtTruckEntrys_seq_TextField");
        kdtTruckEntrys_seq_TextField.setVisible(true);
        kdtTruckEntrys_seq_TextField.setEditable(true);
        kdtTruckEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtTruckEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtTruckEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtTruckEntrys_seq_TextField);
        this.kdtTruckEntrys.getColumn("seq").setEditor(kdtTruckEntrys_seq_CellEditor);
        final KDBizPromptBox kdtTruckEntrys_truck_PromptBox = new KDBizPromptBox();
        kdtTruckEntrys_truck_PromptBox.setQueryInfo("com.kingdee.eas.farm.feedfactory.app.FeedTruckQuery");
        kdtTruckEntrys_truck_PromptBox.setVisible(true);
        kdtTruckEntrys_truck_PromptBox.setEditable(true);
        kdtTruckEntrys_truck_PromptBox.setDisplayFormat("$number$");
        kdtTruckEntrys_truck_PromptBox.setEditFormat("$number$");
        kdtTruckEntrys_truck_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtTruckEntrys_truck_CellEditor = new KDTDefaultCellEditor(kdtTruckEntrys_truck_PromptBox);
        this.kdtTruckEntrys.getColumn("truck").setEditor(kdtTruckEntrys_truck_CellEditor);
        ObjectValueRender kdtTruckEntrys_truck_OVR = new ObjectValueRender();
        kdtTruckEntrys_truck_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtTruckEntrys.getColumn("truck").setRenderer(kdtTruckEntrys_truck_OVR);
        			kdtTruckEntrys_truck_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feedfactory.client.FeedTruckListUI kdtTruckEntrys_truck_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtTruckEntrys_truck_PromptBox_F7ListUI == null) {
					try {
						kdtTruckEntrys_truck_PromptBox_F7ListUI = new com.kingdee.eas.farm.feedfactory.client.FeedTruckListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtTruckEntrys_truck_PromptBox_F7ListUI));
					kdtTruckEntrys_truck_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtTruckEntrys_truck_PromptBox.setSelector(kdtTruckEntrys_truck_PromptBox_F7ListUI);
				}
			}
		});
					
        KDFormattedTextField kdtTruckEntrys_allCount_TextField = new KDFormattedTextField();
        kdtTruckEntrys_allCount_TextField.setName("kdtTruckEntrys_allCount_TextField");
        kdtTruckEntrys_allCount_TextField.setVisible(true);
        kdtTruckEntrys_allCount_TextField.setEditable(true);
        kdtTruckEntrys_allCount_TextField.setHorizontalAlignment(2);
        kdtTruckEntrys_allCount_TextField.setDataType(0);
        KDTDefaultCellEditor kdtTruckEntrys_allCount_CellEditor = new KDTDefaultCellEditor(kdtTruckEntrys_allCount_TextField);
        this.kdtTruckEntrys.getColumn("allCount").setEditor(kdtTruckEntrys_allCount_CellEditor);
        KDTextField kdtTruckEntrys_lunchPlace_TextField = new KDTextField();
        kdtTruckEntrys_lunchPlace_TextField.setName("kdtTruckEntrys_lunchPlace_TextField");
        kdtTruckEntrys_lunchPlace_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtTruckEntrys_lunchPlace_CellEditor = new KDTDefaultCellEditor(kdtTruckEntrys_lunchPlace_TextField);
        this.kdtTruckEntrys.getColumn("lunchPlace").setEditor(kdtTruckEntrys_lunchPlace_CellEditor);
        KDTimePicker kdtTruckEntrys_beginTime_TimePicker = new KDTimePicker();
        kdtTruckEntrys_beginTime_TimePicker.setName("kdtTruckEntrys_beginTime_TimePicker");
        kdtTruckEntrys_beginTime_TimePicker.setVisible(true);
        KDTDefaultCellEditor kdtTruckEntrys_beginTime_CellEditor = new KDTDefaultCellEditor(kdtTruckEntrys_beginTime_TimePicker);
        this.kdtTruckEntrys.getColumn("beginTime").setEditor(kdtTruckEntrys_beginTime_CellEditor);
        KDTimePicker kdtTruckEntrys_endTime_TimePicker = new KDTimePicker();
        kdtTruckEntrys_endTime_TimePicker.setName("kdtTruckEntrys_endTime_TimePicker");
        kdtTruckEntrys_endTime_TimePicker.setVisible(true);
        KDTDefaultCellEditor kdtTruckEntrys_endTime_CellEditor = new KDTDefaultCellEditor(kdtTruckEntrys_endTime_TimePicker);
        this.kdtTruckEntrys.getColumn("endTime").setEditor(kdtTruckEntrys_endTime_CellEditor);
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
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(false);		
        this.baseStatus.setEnabled(false);
        // beginTime
        // lunchBeginTime
        // lunchEndTime
        // txtprepackedTruckCount		
        this.txtprepackedTruckCount.setHorizontalAlignment(2);		
        this.txtprepackedTruckCount.setDataType(0);		
        this.txtprepackedTruckCount.setSupportedEmpty(true);		
        this.txtprepackedTruckCount.setRequired(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,pkauditTime,baseStatus,beginTime,lunchBeginTime,lunchEndTime,txtprepackedTruckCount,chkorderByTruck,kdtAssEntrys,kdtEntrys,kdtTruckEntrys}));
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
        contCreator.setBounds(new Rectangle(18, 577, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(18, 577, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(18, 600, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(18, 600, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(372, 577, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(372, 577, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(372, 600, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(372, 600, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contNumber.setBounds(new Rectangle(12, 17, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(12, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(370, 17, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(370, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(370, 67, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(370, 67, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(727, 577, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(727, 577, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kdtEntrys.setBounds(new Rectangle(15, 320, 983, 244));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(15, 320, 983, 244, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kdtAssEntrys.setBounds(new Rectangle(15, 120, 615, 184));
        kdtAssEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtAssEntrys,new com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanAssEntryInfo(),null,false);
        this.add(kdtAssEntrys_detailPanel, new KDLayout.Constraints(15, 120, 615, 184, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnGetPlan.setBounds(new Rectangle(554, 95, 108, 21));
        this.add(btnGetPlan, new KDLayout.Constraints(554, 95, 108, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnUp.setBounds(new Rectangle(19, 97, 59, 19));
        this.add(btnUp, new KDLayout.Constraints(19, 97, 59, 19, 0));
        btnDown.setBounds(new Rectangle(84, 97, 59, 19));
        this.add(btnDown, new KDLayout.Constraints(84, 97, 59, 19, 0));
        btnGeneteTruckPlan.setBounds(new Rectangle(871, 95, 122, 21));
        this.add(btnGeneteTruckPlan, new KDLayout.Constraints(871, 95, 122, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contauditTime.setBounds(new Rectangle(727, 600, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(727, 600, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbaseStatus.setBounds(new Rectangle(725, 17, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(725, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbeginTime.setBounds(new Rectangle(12, 42, 270, 19));
        this.add(contbeginTime, new KDLayout.Constraints(12, 42, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contlunchBeginTime.setBounds(new Rectangle(370, 42, 270, 19));
        this.add(contlunchBeginTime, new KDLayout.Constraints(370, 42, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contlunchEndTime.setBounds(new Rectangle(725, 42, 270, 19));
        this.add(contlunchEndTime, new KDLayout.Constraints(725, 42, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        btnSplit.setBounds(new Rectangle(149, 97, 59, 19));
        this.add(btnSplit, new KDLayout.Constraints(149, 97, 59, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contprepackedTruckCount.setBounds(new Rectangle(12, 67, 270, 19));
        this.add(contprepackedTruckCount, new KDLayout.Constraints(12, 67, 270, 19, 0));
        chkorderByTruck.setBounds(new Rectangle(723, 67, 270, 19));
        this.add(chkorderByTruck, new KDLayout.Constraints(723, 67, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kdtTruckEntrys.setBounds(new Rectangle(634, 120, 363, 182));
        kdtTruckEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtTruckEntrys,new com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanTruckEntryInfo(),null,false);
        this.add(kdtTruckEntrys_detailPanel, new KDLayout.Constraints(634, 120, 363, 182, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //contbeginTime
        contbeginTime.setBoundEditor(beginTime);
        //contlunchBeginTime
        contlunchBeginTime.setBoundEditor(lunchBeginTime);
        //contlunchEndTime
        contlunchEndTime.setBoundEditor(lunchEndTime);
        //contprepackedTruckCount
        contprepackedTruckCount.setBoundEditor(txtprepackedTruckCount);

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
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.farm", java.lang.Object.class, this.kdtEntrys, "farm.text");
		dataBinder.registerBinding("entrys.tower", java.lang.Object.class, this.kdtEntrys, "tower.text");
		dataBinder.registerBinding("entrys.truck", java.lang.Object.class, this.kdtEntrys, "truck.text");
		dataBinder.registerBinding("entrys.drive", String.class, this.kdtEntrys, "drive.text");
		dataBinder.registerBinding("entrys.tel", String.class, this.kdtEntrys, "tel.text");
		dataBinder.registerBinding("entrys.beginLoadTime", java.util.Date.class, this.kdtEntrys, "beginLoadTime.text");
		dataBinder.registerBinding("entrys.leaveFFTime", java.util.Date.class, this.kdtEntrys, "leaveFFTime.text");
		dataBinder.registerBinding("entrys.truckArriveTime", java.util.Date.class, this.kdtEntrys, "truckArriveTime.text");
		dataBinder.registerBinding("entrys.leaveFarmTime", java.util.Date.class, this.kdtEntrys, "leaveFarmTime.text");
		dataBinder.registerBinding("entrys.backToFFTime", java.util.Date.class, this.kdtEntrys, "backToFFTime.text");
		dataBinder.registerBinding("entrys.planSeq", int.class, this.kdtEntrys, "planSeq.text");
		dataBinder.registerBinding("entrys.truckSeq", int.class, this.kdtEntrys, "truckSeq.text");
		dataBinder.registerBinding("entrys.haveLunch", boolean.class, this.kdtEntrys, "haveLunch.text");
		dataBinder.registerBinding("entrys.lunchPlace", String.class, this.kdtEntrys, "lunchPlace.text");
		dataBinder.registerBinding("entrys.fodderPort", String.class, this.kdtEntrys, "fodderPort.text");
		dataBinder.registerBinding("entrys.farmDesc", String.class, this.kdtEntrys, "farmDesc.text");
		dataBinder.registerBinding("entrys.materialName", String.class, this.kdtEntrys, "materialName.text");
		dataBinder.registerBinding("entrys.materialID", String.class, this.kdtEntrys, "materialID.text");
		dataBinder.registerBinding("AssEntrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtAssEntrys, "id.text");
		dataBinder.registerBinding("AssEntrys", com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanAssEntryInfo.class, this.kdtAssEntrys, "userObject");
		dataBinder.registerBinding("AssEntrys.farm", java.lang.Object.class, this.kdtAssEntrys, "farm.text");
		dataBinder.registerBinding("AssEntrys.tower", java.lang.Object.class, this.kdtAssEntrys, "tower.text");
		dataBinder.registerBinding("AssEntrys.inventory", java.math.BigDecimal.class, this.kdtAssEntrys, "inventory.text");
		dataBinder.registerBinding("AssEntrys.material", java.lang.Object.class, this.kdtAssEntrys, "material.text");
		dataBinder.registerBinding("AssEntrys.fodderQty", java.math.BigDecimal.class, this.kdtAssEntrys, "fodderQty.text");
		dataBinder.registerBinding("AssEntrys.truck", java.lang.Object.class, this.kdtAssEntrys, "truck.text");
		dataBinder.registerBinding("AssEntrys.truckCount", int.class, this.kdtAssEntrys, "truckCount.text");
		dataBinder.registerBinding("AssEntrys.isIgnore", boolean.class, this.kdtAssEntrys, "isIgnore.text");
		dataBinder.registerBinding("AssEntrys.mergeTrunckNum", String.class, this.kdtAssEntrys, "mergeTrunckNum.text");
		dataBinder.registerBinding("AssEntrys.fodderPort", String.class, this.kdtAssEntrys, "fodderPort.text");
		dataBinder.registerBinding("AssEntrys.farmDesc", String.class, this.kdtAssEntrys, "farmDesc.text");
		dataBinder.registerBinding("orderByTruck", boolean.class, this.chkorderByTruck, "selected");
		dataBinder.registerBinding("TruckEntrys.seq", int.class, this.kdtTruckEntrys, "seq.text");
		dataBinder.registerBinding("TruckEntrys", com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanTruckEntryInfo.class, this.kdtTruckEntrys, "userObject");
		dataBinder.registerBinding("TruckEntrys.truck", java.lang.Object.class, this.kdtTruckEntrys, "truck.text");
		dataBinder.registerBinding("TruckEntrys.allCount", int.class, this.kdtTruckEntrys, "allCount.text");
		dataBinder.registerBinding("TruckEntrys.lunchPlace", String.class, this.kdtTruckEntrys, "lunchPlace.text");
		dataBinder.registerBinding("TruckEntrys.beginTime", java.sql.Time.class, this.kdtTruckEntrys, "beginTime.text");
		dataBinder.registerBinding("TruckEntrys.endTime", java.sql.Time.class, this.kdtTruckEntrys, "endTime.text");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("beginTime", java.sql.Time.class, this.beginTime, "value");
		dataBinder.registerBinding("lunchBeginTime", java.sql.Time.class, this.lunchBeginTime, "value");
		dataBinder.registerBinding("lunchEndTime", java.sql.Time.class, this.lunchEndTime, "value");
		dataBinder.registerBinding("prepackedTruckCount", int.class, this.txtprepackedTruckCount, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.feedfactory.app.FeedFactoryTruckPlanEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanInfo)ov;
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
	 * ????????§µ??
	 */
	protected void registerValidator() {
    	getValidateHelper().setCustomValidator( getValidator() );
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.tower", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.truck", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.drive", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.tel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.beginLoadTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.leaveFFTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.truckArriveTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.leaveFarmTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.backToFFTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.planSeq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.truckSeq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.haveLunch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.lunchPlace", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.fodderPort", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.farmDesc", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.materialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.materialID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.tower", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.inventory", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.fodderQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.truck", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.truckCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.isIgnore", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.mergeTrunckNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.fodderPort", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.farmDesc", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("orderByTruck", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TruckEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TruckEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TruckEntrys.truck", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TruckEntrys.allCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TruckEntrys.lunchPlace", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TruckEntrys.beginTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TruckEntrys.endTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("beginTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lunchBeginTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lunchEndTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("prepackedTruckCount", ValidateHelper.ON_SAVE);    		
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
     * output btnUp_actionPerformed method
     */
    protected void btnUp_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnDown_actionPerformed method
     */
    protected void btnDown_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnSplit_actionPerformed method
     */
    protected void btnSplit_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }


    /**
     * output kdtEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("truck".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"drive").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"truck").getValue(),"driver.name")));

}

    if ("truck".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"tel").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"truck").getValue(),"driverTel")));

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
    	sic.add(new SelectorItemInfo("entrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.farm.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.farm.id"));
			sic.add(new SelectorItemInfo("entrys.farm.name"));
        	sic.add(new SelectorItemInfo("entrys.farm.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.tower.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.tower.id"));
			sic.add(new SelectorItemInfo("entrys.tower.name"));
        	sic.add(new SelectorItemInfo("entrys.tower.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.truck.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.truck.id"));
			sic.add(new SelectorItemInfo("entrys.truck.number"));
			sic.add(new SelectorItemInfo("entrys.truck.name"));
		}
    	sic.add(new SelectorItemInfo("entrys.drive"));
    	sic.add(new SelectorItemInfo("entrys.tel"));
    	sic.add(new SelectorItemInfo("entrys.beginLoadTime"));
    	sic.add(new SelectorItemInfo("entrys.leaveFFTime"));
    	sic.add(new SelectorItemInfo("entrys.truckArriveTime"));
    	sic.add(new SelectorItemInfo("entrys.leaveFarmTime"));
    	sic.add(new SelectorItemInfo("entrys.backToFFTime"));
    	sic.add(new SelectorItemInfo("entrys.planSeq"));
    	sic.add(new SelectorItemInfo("entrys.truckSeq"));
    	sic.add(new SelectorItemInfo("entrys.haveLunch"));
    	sic.add(new SelectorItemInfo("entrys.lunchPlace"));
    	sic.add(new SelectorItemInfo("entrys.fodderPort"));
    	sic.add(new SelectorItemInfo("entrys.farmDesc"));
    	sic.add(new SelectorItemInfo("entrys.materialName"));
    	sic.add(new SelectorItemInfo("entrys.materialID"));
    	sic.add(new SelectorItemInfo("AssEntrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("AssEntrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("AssEntrys.farm.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("AssEntrys.farm.id"));
			sic.add(new SelectorItemInfo("AssEntrys.farm.name"));
        	sic.add(new SelectorItemInfo("AssEntrys.farm.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("AssEntrys.tower.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("AssEntrys.tower.id"));
			sic.add(new SelectorItemInfo("AssEntrys.tower.name"));
        	sic.add(new SelectorItemInfo("AssEntrys.tower.number"));
		}
    	sic.add(new SelectorItemInfo("AssEntrys.inventory"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("AssEntrys.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("AssEntrys.material.id"));
			sic.add(new SelectorItemInfo("AssEntrys.material.name"));
        	sic.add(new SelectorItemInfo("AssEntrys.material.number"));
		}
    	sic.add(new SelectorItemInfo("AssEntrys.fodderQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("AssEntrys.truck.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("AssEntrys.truck.id"));
			sic.add(new SelectorItemInfo("AssEntrys.truck.number"));
			sic.add(new SelectorItemInfo("AssEntrys.truck.name"));
		}
    	sic.add(new SelectorItemInfo("AssEntrys.truckCount"));
    	sic.add(new SelectorItemInfo("AssEntrys.isIgnore"));
    	sic.add(new SelectorItemInfo("AssEntrys.mergeTrunckNum"));
    	sic.add(new SelectorItemInfo("AssEntrys.fodderPort"));
    	sic.add(new SelectorItemInfo("AssEntrys.farmDesc"));
        sic.add(new SelectorItemInfo("orderByTruck"));
    	sic.add(new SelectorItemInfo("TruckEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TruckEntrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TruckEntrys.truck.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("TruckEntrys.truck.id"));
			sic.add(new SelectorItemInfo("TruckEntrys.truck.number"));
			sic.add(new SelectorItemInfo("TruckEntrys.truck.name"));
		}
    	sic.add(new SelectorItemInfo("TruckEntrys.allCount"));
    	sic.add(new SelectorItemInfo("TruckEntrys.lunchPlace"));
    	sic.add(new SelectorItemInfo("TruckEntrys.beginTime"));
    	sic.add(new SelectorItemInfo("TruckEntrys.endTime"));
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
        sic.add(new SelectorItemInfo("baseStatus"));
        sic.add(new SelectorItemInfo("beginTime"));
        sic.add(new SelectorItemInfo("lunchBeginTime"));
        sic.add(new SelectorItemInfo("lunchEndTime"));
        sic.add(new SelectorItemInfo("prepackedTruckCount"));
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
     * output actionGetFodderPlan_actionPerformed method
     */
    public void actionGetFodderPlan_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanFactory.getRemoteInstance().getFodderPlan(editData);
    }
    	

    /**
     * output actionGenerateTruckPlan_actionPerformed method
     */
    public void actionGenerateTruckPlan_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanFactory.getRemoteInstance().generateTruckPlan(editData);
    }
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanFactory.getRemoteInstance().unAudit(editData);
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
	public RequestContext prepareActionGetFodderPlan(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionGetFodderPlan() {
    	return false;
    }
	public RequestContext prepareActionGenerateTruckPlan(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionGenerateTruckPlan() {
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
     * output ActionGetFodderPlan class
     */     
    protected class ActionGetFodderPlan extends ItemAction {     
    
        public ActionGetFodderPlan()
        {
            this(null);
        }

        public ActionGetFodderPlan(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionGetFodderPlan.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionGetFodderPlan.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionGetFodderPlan.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractFeedFactoryTruckPlanEditUI.this, "ActionGetFodderPlan", "actionGetFodderPlan_actionPerformed", e);
        }
    }

    /**
     * output ActionGenerateTruckPlan class
     */     
    protected class ActionGenerateTruckPlan extends ItemAction {     
    
        public ActionGenerateTruckPlan()
        {
            this(null);
        }

        public ActionGenerateTruckPlan(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionGenerateTruckPlan.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionGenerateTruckPlan.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionGenerateTruckPlan.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractFeedFactoryTruckPlanEditUI.this, "ActionGenerateTruckPlan", "actionGenerateTruckPlan_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractFeedFactoryTruckPlanEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractFeedFactoryTruckPlanEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.feedfactory.client", "FeedFactoryTruckPlanEditUI");
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
        return com.kingdee.eas.farm.feedfactory.client.FeedFactoryTruckPlanEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanInfo objectValue = new com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/feedfactory/FeedFactoryTruckPlan";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.feedfactory.app.FeedFactoryTruckPlanQuery");
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
		vo.put("baseStatus",new Integer(0));
		vo.put("prepackedTruckCount",new Integer(0));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}