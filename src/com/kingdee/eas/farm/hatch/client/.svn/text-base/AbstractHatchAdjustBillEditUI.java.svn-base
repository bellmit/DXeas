/**
 * output package name
 */
package com.kingdee.eas.farm.hatch.client;

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
public abstract class AbstractHatchAdjustBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractHatchAdjustBillEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsrcBill;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsrcBillType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstorageOrgUnit;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEggEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEggEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsrcBill;
    protected com.kingdee.bos.ctrl.swing.KDComboBox srcBillType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.farm.hatch.HatchAdjustBillInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractHatchAdjustBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractHatchAdjustBillEditUI.class.getName());
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
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane2 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contsrcBill = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsrcBillType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstorageOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEggEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.prmtsrcBill = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.srcBillType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtstorageOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contAuditor.setName("contAuditor");
        this.contauditTime.setName("contauditTime");
        this.contbaseStatus.setName("contbaseStatus");
        this.kDTabbedPane2.setName("kDTabbedPane2");
        this.contsrcBill.setName("contsrcBill");
        this.contsrcBillType.setName("contsrcBillType");
        this.contstorageOrgUnit.setName("contstorageOrgUnit");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.prmtAuditor.setName("prmtAuditor");
        this.pkauditTime.setName("pkauditTime");
        this.baseStatus.setName("baseStatus");
        this.kDPanel2.setName("kDPanel2");
        this.kdtEggEntry.setName("kdtEggEntry");
        this.prmtsrcBill.setName("prmtsrcBill");
        this.srcBillType.setName("srcBillType");
        this.prmtstorageOrgUnit.setName("prmtstorageOrgUnit");
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
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);
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
        // kDTabbedPane2
        // contsrcBill		
        this.contsrcBill.setBoundLabelText(resHelper.getString("contsrcBill.boundLabelText"));		
        this.contsrcBill.setBoundLabelLength(100);		
        this.contsrcBill.setBoundLabelUnderline(true);		
        this.contsrcBill.setVisible(true);
        // contsrcBillType		
        this.contsrcBillType.setBoundLabelText(resHelper.getString("contsrcBillType.boundLabelText"));		
        this.contsrcBillType.setBoundLabelLength(100);		
        this.contsrcBillType.setBoundLabelUnderline(true);		
        this.contsrcBillType.setVisible(true);
        // contstorageOrgUnit		
        this.contstorageOrgUnit.setBoundLabelText(resHelper.getString("contstorageOrgUnit.boundLabelText"));		
        this.contstorageOrgUnit.setBoundLabelLength(100);		
        this.contstorageOrgUnit.setBoundLabelUnderline(true);		
        this.contstorageOrgUnit.setVisible(true);
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
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(false);		
        this.baseStatus.setEnabled(false);
        // kDPanel2
        // kdtEggEntry
		String kdtEggEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol8\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol9\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol13\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol14\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol16\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol17\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol18\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol19\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol21\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol23\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol24\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol25\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol26\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol27\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol28\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol29\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol30\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol32\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"seqNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"hatchHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"incubator\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"hatchCarNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"eggSourceType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"isMix\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"farm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"house\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"breedBatch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"outArea\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"outBatch\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"genderType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"farmer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"outFarm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"outHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"18\" /><t:Column t:key=\"sendDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"19\" t:styleID=\"sCol16\" /><t:Column t:key=\"weeklyAge\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"dayAge\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"isFormal\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol19\" /><t:Column t:key=\"supplier\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol21\" /><t:Column t:key=\"eggLog\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"qc1lv1Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol23\" /><t:Column t:key=\"qc1lv2Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol24\" /><t:Column t:key=\"qc2lv1Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol25\" /><t:Column t:key=\"qc2lv2Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol26\" /><t:Column t:key=\"qc3lv1Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol27\" /><t:Column t:key=\"qc4lv1Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol28\" /><t:Column t:key=\"qc5lv1Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol29\" /><t:Column t:key=\"qc6lv1Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol30\" /><t:Column t:key=\"qcEggType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"eggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol32\" /><t:Column t:key=\"eggHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"babyBatch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{seqNum}</t:Cell><t:Cell>$Resource{hatchHouse}</t:Cell><t:Cell>$Resource{incubator}</t:Cell><t:Cell>$Resource{hatchCarNum}</t:Cell><t:Cell>$Resource{eggSourceType}</t:Cell><t:Cell>$Resource{isMix}</t:Cell><t:Cell>$Resource{farm}</t:Cell><t:Cell>$Resource{house}</t:Cell><t:Cell>$Resource{breedBatch}</t:Cell><t:Cell>$Resource{outArea}</t:Cell><t:Cell>$Resource{outBatch}</t:Cell><t:Cell>$Resource{genderType}</t:Cell><t:Cell>$Resource{farmer}</t:Cell><t:Cell>$Resource{outFarm}</t:Cell><t:Cell>$Resource{outHouse}</t:Cell><t:Cell>$Resource{sendDate}</t:Cell><t:Cell>$Resource{weeklyAge}</t:Cell><t:Cell>$Resource{dayAge}</t:Cell><t:Cell>$Resource{isFormal}</t:Cell><t:Cell>$Resource{supplier}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{eggLog}</t:Cell><t:Cell>$Resource{qc1lv1Qty}</t:Cell><t:Cell>$Resource{qc1lv2Qty}</t:Cell><t:Cell>$Resource{qc2lv1Qty}</t:Cell><t:Cell>$Resource{qc2lv2Qty}</t:Cell><t:Cell>$Resource{qc3lv1Qty}</t:Cell><t:Cell>$Resource{qc4lv1Qty}</t:Cell><t:Cell>$Resource{qc5lv1Qty}</t:Cell><t:Cell>$Resource{qc6lv1Qty}</t:Cell><t:Cell>$Resource{qcEggType}</t:Cell><t:Cell>$Resource{eggQty}</t:Cell><t:Cell>$Resource{eggHouse}</t:Cell><t:Cell>$Resource{babyBatch}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEggEntry.setFormatXml(resHelper.translateString("kdtEggEntry",kdtEggEntryStrXML));

                this.kdtEggEntry.putBindContents("editData",new String[] {"seq","seqNum","hatchHouse","incubator","hatchCarNum","eggSourceType","isMix","farm","house","breedBatch","outArea","outBatch","genderType","farmer","outFarm","outHouse","sendDate","weeklyAge","dayAge","isFormal","supplier","material","eggLog","qc1lv1Qty","qc1lv2Qty","qc2lv1Qty","qc2lv2Qty","qc3lv1Qty","qc4lv1Qty","qc5lv1Qty","qc6lv1Qty","qcEggType","eggQty","eggHouse","babyBatch"});


        this.kdtEggEntry.checkParsed();
        KDFormattedTextField kdtEggEntry_seqNum_TextField = new KDFormattedTextField();
        kdtEggEntry_seqNum_TextField.setName("kdtEggEntry_seqNum_TextField");
        kdtEggEntry_seqNum_TextField.setVisible(true);
        kdtEggEntry_seqNum_TextField.setEditable(true);
        kdtEggEntry_seqNum_TextField.setHorizontalAlignment(2);
        kdtEggEntry_seqNum_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntry_seqNum_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_seqNum_TextField);
        this.kdtEggEntry.getColumn("seqNum").setEditor(kdtEggEntry_seqNum_CellEditor);
        final KDBizPromptBox kdtEggEntry_hatchHouse_PromptBox = new KDBizPromptBox();
        kdtEggEntry_hatchHouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.hatch.app.HatchHouseQuery");
        kdtEggEntry_hatchHouse_PromptBox.setVisible(true);
        kdtEggEntry_hatchHouse_PromptBox.setEditable(true);
        kdtEggEntry_hatchHouse_PromptBox.setDisplayFormat("$number$");
        kdtEggEntry_hatchHouse_PromptBox.setEditFormat("$number$");
        kdtEggEntry_hatchHouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntry_hatchHouse_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_hatchHouse_PromptBox);
        this.kdtEggEntry.getColumn("hatchHouse").setEditor(kdtEggEntry_hatchHouse_CellEditor);
        ObjectValueRender kdtEggEntry_hatchHouse_OVR = new ObjectValueRender();
        kdtEggEntry_hatchHouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntry.getColumn("hatchHouse").setRenderer(kdtEggEntry_hatchHouse_OVR);
        			kdtEggEntry_hatchHouse_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.HatchHouseListUI kdtEggEntry_hatchHouse_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEggEntry_hatchHouse_PromptBox_F7ListUI == null) {
					try {
						kdtEggEntry_hatchHouse_PromptBox_F7ListUI = new com.kingdee.eas.farm.hatch.client.HatchHouseListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEggEntry_hatchHouse_PromptBox_F7ListUI));
					kdtEggEntry_hatchHouse_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEggEntry_hatchHouse_PromptBox.setSelector(kdtEggEntry_hatchHouse_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEggEntry_incubator_PromptBox = new KDBizPromptBox();
        kdtEggEntry_incubator_PromptBox.setQueryInfo("com.kingdee.eas.farm.hatch.app.F7IncubatorQuery");
        kdtEggEntry_incubator_PromptBox.setVisible(true);
        kdtEggEntry_incubator_PromptBox.setEditable(true);
        kdtEggEntry_incubator_PromptBox.setDisplayFormat("$number$");
        kdtEggEntry_incubator_PromptBox.setEditFormat("$number$");
        kdtEggEntry_incubator_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntry_incubator_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_incubator_PromptBox);
        this.kdtEggEntry.getColumn("incubator").setEditor(kdtEggEntry_incubator_CellEditor);
        ObjectValueRender kdtEggEntry_incubator_OVR = new ObjectValueRender();
        kdtEggEntry_incubator_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntry.getColumn("incubator").setRenderer(kdtEggEntry_incubator_OVR);
        			kdtEggEntry_incubator_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.IncubatorListUI kdtEggEntry_incubator_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEggEntry_incubator_PromptBox_F7ListUI == null) {
					try {
						kdtEggEntry_incubator_PromptBox_F7ListUI = new com.kingdee.eas.farm.hatch.client.IncubatorListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEggEntry_incubator_PromptBox_F7ListUI));
					kdtEggEntry_incubator_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEggEntry_incubator_PromptBox.setSelector(kdtEggEntry_incubator_PromptBox_F7ListUI);
				}
			}
		});
					
        KDTextField kdtEggEntry_hatchCarNum_TextField = new KDTextField();
        kdtEggEntry_hatchCarNum_TextField.setName("kdtEggEntry_hatchCarNum_TextField");
        kdtEggEntry_hatchCarNum_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEggEntry_hatchCarNum_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_hatchCarNum_TextField);
        this.kdtEggEntry.getColumn("hatchCarNum").setEditor(kdtEggEntry_hatchCarNum_CellEditor);
        KDComboBox kdtEggEntry_eggSourceType_ComboBox = new KDComboBox();
        kdtEggEntry_eggSourceType_ComboBox.setName("kdtEggEntry_eggSourceType_ComboBox");
        kdtEggEntry_eggSourceType_ComboBox.setVisible(true);
        kdtEggEntry_eggSourceType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.hatch.EggSourceType").toArray());
        KDTDefaultCellEditor kdtEggEntry_eggSourceType_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_eggSourceType_ComboBox);
        this.kdtEggEntry.getColumn("eggSourceType").setEditor(kdtEggEntry_eggSourceType_CellEditor);
        KDCheckBox kdtEggEntry_isMix_CheckBox = new KDCheckBox();
        kdtEggEntry_isMix_CheckBox.setName("kdtEggEntry_isMix_CheckBox");
        KDTDefaultCellEditor kdtEggEntry_isMix_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_isMix_CheckBox);
        this.kdtEggEntry.getColumn("isMix").setEditor(kdtEggEntry_isMix_CellEditor);
        final KDBizPromptBox kdtEggEntry_farm_PromptBox = new KDBizPromptBox();
        kdtEggEntry_farm_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.F7BreedStoorgSetQuery");
        kdtEggEntry_farm_PromptBox.setVisible(true);
        kdtEggEntry_farm_PromptBox.setEditable(true);
        kdtEggEntry_farm_PromptBox.setDisplayFormat("$number$");
        kdtEggEntry_farm_PromptBox.setEditFormat("$number$");
        kdtEggEntry_farm_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntry_farm_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_farm_PromptBox);
        this.kdtEggEntry.getColumn("farm").setEditor(kdtEggEntry_farm_CellEditor);
        ObjectValueRender kdtEggEntry_farm_OVR = new ObjectValueRender();
        kdtEggEntry_farm_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntry.getColumn("farm").setRenderer(kdtEggEntry_farm_OVR);
        final KDBizPromptBox kdtEggEntry_house_PromptBox = new KDBizPromptBox();
        kdtEggEntry_house_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseF7Query");
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
        final KDBizPromptBox kdtEggEntry_breedBatch_PromptBox = new KDBizPromptBox();
        kdtEggEntry_breedBatch_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");
        kdtEggEntry_breedBatch_PromptBox.setVisible(true);
        kdtEggEntry_breedBatch_PromptBox.setEditable(true);
        kdtEggEntry_breedBatch_PromptBox.setDisplayFormat("$number$");
        kdtEggEntry_breedBatch_PromptBox.setEditFormat("$number$");
        kdtEggEntry_breedBatch_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntry_breedBatch_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_breedBatch_PromptBox);
        this.kdtEggEntry.getColumn("breedBatch").setEditor(kdtEggEntry_breedBatch_CellEditor);
        ObjectValueRender kdtEggEntry_breedBatch_OVR = new ObjectValueRender();
        kdtEggEntry_breedBatch_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntry.getColumn("breedBatch").setRenderer(kdtEggEntry_breedBatch_OVR);
        final KDBizPromptBox kdtEggEntry_outBatch_PromptBox = new KDBizPromptBox();
        kdtEggEntry_outBatch_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.StockingBatchQuery");
        kdtEggEntry_outBatch_PromptBox.setVisible(true);
        kdtEggEntry_outBatch_PromptBox.setEditable(true);
        kdtEggEntry_outBatch_PromptBox.setDisplayFormat("$number$");
        kdtEggEntry_outBatch_PromptBox.setEditFormat("$number$");
        kdtEggEntry_outBatch_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntry_outBatch_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_outBatch_PromptBox);
        this.kdtEggEntry.getColumn("outBatch").setEditor(kdtEggEntry_outBatch_CellEditor);
        ObjectValueRender kdtEggEntry_outBatch_OVR = new ObjectValueRender();
        kdtEggEntry_outBatch_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntry.getColumn("outBatch").setRenderer(kdtEggEntry_outBatch_OVR);
        			kdtEggEntry_outBatch_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI kdtEggEntry_outBatch_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEggEntry_outBatch_PromptBox_F7ListUI == null) {
					try {
						kdtEggEntry_outBatch_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEggEntry_outBatch_PromptBox_F7ListUI));
					kdtEggEntry_outBatch_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEggEntry_outBatch_PromptBox.setSelector(kdtEggEntry_outBatch_PromptBox_F7ListUI);
				}
			}
		});
					
        KDComboBox kdtEggEntry_genderType_ComboBox = new KDComboBox();
        kdtEggEntry_genderType_ComboBox.setName("kdtEggEntry_genderType_ComboBox");
        kdtEggEntry_genderType_ComboBox.setVisible(true);
        kdtEggEntry_genderType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.hatch.GenderType").toArray());
        KDTDefaultCellEditor kdtEggEntry_genderType_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_genderType_ComboBox);
        this.kdtEggEntry.getColumn("genderType").setEditor(kdtEggEntry_genderType_CellEditor);
        final KDBizPromptBox kdtEggEntry_farmer_PromptBox = new KDBizPromptBox();
        kdtEggEntry_farmer_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmersQuery");
        kdtEggEntry_farmer_PromptBox.setVisible(true);
        kdtEggEntry_farmer_PromptBox.setEditable(true);
        kdtEggEntry_farmer_PromptBox.setDisplayFormat("$number$");
        kdtEggEntry_farmer_PromptBox.setEditFormat("$number$");
        kdtEggEntry_farmer_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntry_farmer_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_farmer_PromptBox);
        this.kdtEggEntry.getColumn("farmer").setEditor(kdtEggEntry_farmer_CellEditor);
        ObjectValueRender kdtEggEntry_farmer_OVR = new ObjectValueRender();
        kdtEggEntry_farmer_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntry.getColumn("farmer").setRenderer(kdtEggEntry_farmer_OVR);
        			kdtEggEntry_farmer_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI kdtEggEntry_farmer_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEggEntry_farmer_PromptBox_F7ListUI == null) {
					try {
						kdtEggEntry_farmer_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEggEntry_farmer_PromptBox_F7ListUI));
					kdtEggEntry_farmer_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEggEntry_farmer_PromptBox.setSelector(kdtEggEntry_farmer_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEggEntry_outFarm_PromptBox = new KDBizPromptBox();
        kdtEggEntry_outFarm_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmQuery");
        kdtEggEntry_outFarm_PromptBox.setVisible(true);
        kdtEggEntry_outFarm_PromptBox.setEditable(true);
        kdtEggEntry_outFarm_PromptBox.setDisplayFormat("$number$");
        kdtEggEntry_outFarm_PromptBox.setEditFormat("$number$");
        kdtEggEntry_outFarm_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntry_outFarm_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_outFarm_PromptBox);
        this.kdtEggEntry.getColumn("outFarm").setEditor(kdtEggEntry_outFarm_CellEditor);
        ObjectValueRender kdtEggEntry_outFarm_OVR = new ObjectValueRender();
        kdtEggEntry_outFarm_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntry.getColumn("outFarm").setRenderer(kdtEggEntry_outFarm_OVR);
        			kdtEggEntry_outFarm_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmListUI kdtEggEntry_outFarm_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEggEntry_outFarm_PromptBox_F7ListUI == null) {
					try {
						kdtEggEntry_outFarm_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEggEntry_outFarm_PromptBox_F7ListUI));
					kdtEggEntry_outFarm_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEggEntry_outFarm_PromptBox.setSelector(kdtEggEntry_outFarm_PromptBox_F7ListUI);
				}
			}
		});
					
        KDDatePicker kdtEggEntry_sendDate_DatePicker = new KDDatePicker();
        kdtEggEntry_sendDate_DatePicker.setName("kdtEggEntry_sendDate_DatePicker");
        kdtEggEntry_sendDate_DatePicker.setVisible(true);
        kdtEggEntry_sendDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEggEntry_sendDate_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_sendDate_DatePicker);
        this.kdtEggEntry.getColumn("sendDate").setEditor(kdtEggEntry_sendDate_CellEditor);
        KDTextField kdtEggEntry_weeklyAge_TextField = new KDTextField();
        kdtEggEntry_weeklyAge_TextField.setName("kdtEggEntry_weeklyAge_TextField");
        kdtEggEntry_weeklyAge_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEggEntry_weeklyAge_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_weeklyAge_TextField);
        this.kdtEggEntry.getColumn("weeklyAge").setEditor(kdtEggEntry_weeklyAge_CellEditor);
        KDFormattedTextField kdtEggEntry_dayAge_TextField = new KDFormattedTextField();
        kdtEggEntry_dayAge_TextField.setName("kdtEggEntry_dayAge_TextField");
        kdtEggEntry_dayAge_TextField.setVisible(true);
        kdtEggEntry_dayAge_TextField.setEditable(true);
        kdtEggEntry_dayAge_TextField.setHorizontalAlignment(2);
        kdtEggEntry_dayAge_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntry_dayAge_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_dayAge_TextField);
        this.kdtEggEntry.getColumn("dayAge").setEditor(kdtEggEntry_dayAge_CellEditor);
        KDCheckBox kdtEggEntry_isFormal_CheckBox = new KDCheckBox();
        kdtEggEntry_isFormal_CheckBox.setName("kdtEggEntry_isFormal_CheckBox");
        KDTDefaultCellEditor kdtEggEntry_isFormal_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_isFormal_CheckBox);
        this.kdtEggEntry.getColumn("isFormal").setEditor(kdtEggEntry_isFormal_CellEditor);
        final KDBizPromptBox kdtEggEntry_supplier_PromptBox = new KDBizPromptBox();
        kdtEggEntry_supplier_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.F7SupplierDefaultQuery");
        kdtEggEntry_supplier_PromptBox.setVisible(true);
        kdtEggEntry_supplier_PromptBox.setEditable(true);
        kdtEggEntry_supplier_PromptBox.setDisplayFormat("$number$");
        kdtEggEntry_supplier_PromptBox.setEditFormat("$number$");
        kdtEggEntry_supplier_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntry_supplier_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_supplier_PromptBox);
        this.kdtEggEntry.getColumn("supplier").setEditor(kdtEggEntry_supplier_CellEditor);
        ObjectValueRender kdtEggEntry_supplier_OVR = new ObjectValueRender();
        kdtEggEntry_supplier_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntry.getColumn("supplier").setRenderer(kdtEggEntry_supplier_OVR);
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
        kdtEggEntry_material_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntry.getColumn("material").setRenderer(kdtEggEntry_material_OVR);
        KDTextField kdtEggEntry_eggLog_TextField = new KDTextField();
        kdtEggEntry_eggLog_TextField.setName("kdtEggEntry_eggLog_TextField");
        kdtEggEntry_eggLog_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEggEntry_eggLog_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_eggLog_TextField);
        this.kdtEggEntry.getColumn("eggLog").setEditor(kdtEggEntry_eggLog_CellEditor);
        KDFormattedTextField kdtEggEntry_qc1lv1Qty_TextField = new KDFormattedTextField();
        kdtEggEntry_qc1lv1Qty_TextField.setName("kdtEggEntry_qc1lv1Qty_TextField");
        kdtEggEntry_qc1lv1Qty_TextField.setVisible(true);
        kdtEggEntry_qc1lv1Qty_TextField.setEditable(true);
        kdtEggEntry_qc1lv1Qty_TextField.setHorizontalAlignment(2);
        kdtEggEntry_qc1lv1Qty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntry_qc1lv1Qty_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_qc1lv1Qty_TextField);
        this.kdtEggEntry.getColumn("qc1lv1Qty").setEditor(kdtEggEntry_qc1lv1Qty_CellEditor);
        KDFormattedTextField kdtEggEntry_qc1lv2Qty_TextField = new KDFormattedTextField();
        kdtEggEntry_qc1lv2Qty_TextField.setName("kdtEggEntry_qc1lv2Qty_TextField");
        kdtEggEntry_qc1lv2Qty_TextField.setVisible(true);
        kdtEggEntry_qc1lv2Qty_TextField.setEditable(true);
        kdtEggEntry_qc1lv2Qty_TextField.setHorizontalAlignment(2);
        kdtEggEntry_qc1lv2Qty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntry_qc1lv2Qty_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_qc1lv2Qty_TextField);
        this.kdtEggEntry.getColumn("qc1lv2Qty").setEditor(kdtEggEntry_qc1lv2Qty_CellEditor);
        KDFormattedTextField kdtEggEntry_qc2lv1Qty_TextField = new KDFormattedTextField();
        kdtEggEntry_qc2lv1Qty_TextField.setName("kdtEggEntry_qc2lv1Qty_TextField");
        kdtEggEntry_qc2lv1Qty_TextField.setVisible(true);
        kdtEggEntry_qc2lv1Qty_TextField.setEditable(true);
        kdtEggEntry_qc2lv1Qty_TextField.setHorizontalAlignment(2);
        kdtEggEntry_qc2lv1Qty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntry_qc2lv1Qty_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_qc2lv1Qty_TextField);
        this.kdtEggEntry.getColumn("qc2lv1Qty").setEditor(kdtEggEntry_qc2lv1Qty_CellEditor);
        KDFormattedTextField kdtEggEntry_qc2lv2Qty_TextField = new KDFormattedTextField();
        kdtEggEntry_qc2lv2Qty_TextField.setName("kdtEggEntry_qc2lv2Qty_TextField");
        kdtEggEntry_qc2lv2Qty_TextField.setVisible(true);
        kdtEggEntry_qc2lv2Qty_TextField.setEditable(true);
        kdtEggEntry_qc2lv2Qty_TextField.setHorizontalAlignment(2);
        kdtEggEntry_qc2lv2Qty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntry_qc2lv2Qty_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_qc2lv2Qty_TextField);
        this.kdtEggEntry.getColumn("qc2lv2Qty").setEditor(kdtEggEntry_qc2lv2Qty_CellEditor);
        KDFormattedTextField kdtEggEntry_qc3lv1Qty_TextField = new KDFormattedTextField();
        kdtEggEntry_qc3lv1Qty_TextField.setName("kdtEggEntry_qc3lv1Qty_TextField");
        kdtEggEntry_qc3lv1Qty_TextField.setVisible(true);
        kdtEggEntry_qc3lv1Qty_TextField.setEditable(true);
        kdtEggEntry_qc3lv1Qty_TextField.setHorizontalAlignment(2);
        kdtEggEntry_qc3lv1Qty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntry_qc3lv1Qty_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_qc3lv1Qty_TextField);
        this.kdtEggEntry.getColumn("qc3lv1Qty").setEditor(kdtEggEntry_qc3lv1Qty_CellEditor);
        KDFormattedTextField kdtEggEntry_qc4lv1Qty_TextField = new KDFormattedTextField();
        kdtEggEntry_qc4lv1Qty_TextField.setName("kdtEggEntry_qc4lv1Qty_TextField");
        kdtEggEntry_qc4lv1Qty_TextField.setVisible(true);
        kdtEggEntry_qc4lv1Qty_TextField.setEditable(true);
        kdtEggEntry_qc4lv1Qty_TextField.setHorizontalAlignment(2);
        kdtEggEntry_qc4lv1Qty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntry_qc4lv1Qty_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_qc4lv1Qty_TextField);
        this.kdtEggEntry.getColumn("qc4lv1Qty").setEditor(kdtEggEntry_qc4lv1Qty_CellEditor);
        KDFormattedTextField kdtEggEntry_qc5lv1Qty_TextField = new KDFormattedTextField();
        kdtEggEntry_qc5lv1Qty_TextField.setName("kdtEggEntry_qc5lv1Qty_TextField");
        kdtEggEntry_qc5lv1Qty_TextField.setVisible(true);
        kdtEggEntry_qc5lv1Qty_TextField.setEditable(true);
        kdtEggEntry_qc5lv1Qty_TextField.setHorizontalAlignment(2);
        kdtEggEntry_qc5lv1Qty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntry_qc5lv1Qty_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_qc5lv1Qty_TextField);
        this.kdtEggEntry.getColumn("qc5lv1Qty").setEditor(kdtEggEntry_qc5lv1Qty_CellEditor);
        KDFormattedTextField kdtEggEntry_qc6lv1Qty_TextField = new KDFormattedTextField();
        kdtEggEntry_qc6lv1Qty_TextField.setName("kdtEggEntry_qc6lv1Qty_TextField");
        kdtEggEntry_qc6lv1Qty_TextField.setVisible(true);
        kdtEggEntry_qc6lv1Qty_TextField.setEditable(true);
        kdtEggEntry_qc6lv1Qty_TextField.setHorizontalAlignment(2);
        kdtEggEntry_qc6lv1Qty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntry_qc6lv1Qty_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_qc6lv1Qty_TextField);
        this.kdtEggEntry.getColumn("qc6lv1Qty").setEditor(kdtEggEntry_qc6lv1Qty_CellEditor);
        KDComboBox kdtEggEntry_qcEggType_ComboBox = new KDComboBox();
        kdtEggEntry_qcEggType_ComboBox.setName("kdtEggEntry_qcEggType_ComboBox");
        kdtEggEntry_qcEggType_ComboBox.setVisible(true);
        kdtEggEntry_qcEggType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.hatch.QcEggTypeEnum").toArray());
        KDTDefaultCellEditor kdtEggEntry_qcEggType_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_qcEggType_ComboBox);
        this.kdtEggEntry.getColumn("qcEggType").setEditor(kdtEggEntry_qcEggType_CellEditor);
        KDFormattedTextField kdtEggEntry_eggQty_TextField = new KDFormattedTextField();
        kdtEggEntry_eggQty_TextField.setName("kdtEggEntry_eggQty_TextField");
        kdtEggEntry_eggQty_TextField.setVisible(true);
        kdtEggEntry_eggQty_TextField.setEditable(true);
        kdtEggEntry_eggQty_TextField.setHorizontalAlignment(2);
        kdtEggEntry_eggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntry_eggQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_eggQty_TextField);
        this.kdtEggEntry.getColumn("eggQty").setEditor(kdtEggEntry_eggQty_CellEditor);
        final KDBizPromptBox kdtEggEntry_eggHouse_PromptBox = new KDBizPromptBox();
        kdtEggEntry_eggHouse_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7AllWarehouseQuery");
        kdtEggEntry_eggHouse_PromptBox.setVisible(true);
        kdtEggEntry_eggHouse_PromptBox.setEditable(true);
        kdtEggEntry_eggHouse_PromptBox.setDisplayFormat("$number$");
        kdtEggEntry_eggHouse_PromptBox.setEditFormat("$number$");
        kdtEggEntry_eggHouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntry_eggHouse_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_eggHouse_PromptBox);
        this.kdtEggEntry.getColumn("eggHouse").setEditor(kdtEggEntry_eggHouse_CellEditor);
        ObjectValueRender kdtEggEntry_eggHouse_OVR = new ObjectValueRender();
        kdtEggEntry_eggHouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntry.getColumn("eggHouse").setRenderer(kdtEggEntry_eggHouse_OVR);
        KDTextField kdtEggEntry_babyBatch_TextField = new KDTextField();
        kdtEggEntry_babyBatch_TextField.setName("kdtEggEntry_babyBatch_TextField");
        kdtEggEntry_babyBatch_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEggEntry_babyBatch_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_babyBatch_TextField);
        this.kdtEggEntry.getColumn("babyBatch").setEditor(kdtEggEntry_babyBatch_CellEditor);
        // prmtsrcBill		
        this.prmtsrcBill.setQueryInfo("com.kingdee.eas.farm.hatch.app.BEggHatchBillQuery");		
        this.prmtsrcBill.setVisible(true);		
        this.prmtsrcBill.setEditable(true);		
        this.prmtsrcBill.setDisplayFormat("$number$");		
        this.prmtsrcBill.setEditFormat("$number$");		
        this.prmtsrcBill.setCommitFormat("$number$");		
        this.prmtsrcBill.setRequired(false);
        // srcBillType		
        this.srcBillType.setVisible(true);		
        this.srcBillType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.hatch.HatchBillTypeEnum").toArray());		
        this.srcBillType.setRequired(false);
        // prmtstorageOrgUnit		
        this.prmtstorageOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtstorageOrgUnit.setVisible(true);		
        this.prmtstorageOrgUnit.setEditable(true);		
        this.prmtstorageOrgUnit.setDisplayFormat("$name$");		
        this.prmtstorageOrgUnit.setEditFormat("$number$");		
        this.prmtstorageOrgUnit.setCommitFormat("$number$");		
        this.prmtstorageOrgUnit.setRequired(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,pkauditTime,baseStatus,kdtEggEntry,prmtsrcBill,srcBillType,prmtstorageOrgUnit}));
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
        contCreator.setBounds(new Rectangle(373, 571, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(373, 571, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(373, 596, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(373, 596, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(725, 571, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(725, 571, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateTime.setBounds(new Rectangle(725, 596, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(725, 596, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(18, 27, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(18, 27, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(349, 27, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(349, 27, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(21, 571, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(21, 571, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(21, 596, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(21, 596, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbaseStatus.setBounds(new Rectangle(725, 27, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(725, 27, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDTabbedPane2.setBounds(new Rectangle(16, 94, 977, 460));
        this.add(kDTabbedPane2, new KDLayout.Constraints(16, 94, 977, 460, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contsrcBill.setBounds(new Rectangle(18, 64, 270, 19));
        this.add(contsrcBill, new KDLayout.Constraints(18, 64, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsrcBillType.setBounds(new Rectangle(349, 64, 270, 19));
        this.add(contsrcBillType, new KDLayout.Constraints(349, 64, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contstorageOrgUnit.setBounds(new Rectangle(725, 64, 270, 19));
        this.add(contstorageOrgUnit, new KDLayout.Constraints(725, 64, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //contAuditor
        contAuditor.setBoundEditor(prmtAuditor);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //kDTabbedPane2
        kDTabbedPane2.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 976, 427));        kdtEggEntry.setBounds(new Rectangle(-1, 40, 972, 311));
        kdtEggEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEggEntry,new com.kingdee.eas.farm.hatch.HatchAdjustBillEggEntryInfo(),null,false);
        kDPanel2.add(kdtEggEntry_detailPanel, new KDLayout.Constraints(-1, 40, 972, 311, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtEggEntry_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("eggSourceType",new Integer(2));
vo.put("genderType","2");
vo.put("qcEggType",new Integer(1));
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //contsrcBill
        contsrcBill.setBoundEditor(prmtsrcBill);
        //contsrcBillType
        contsrcBillType.setBoundEditor(srcBillType);
        //contstorageOrgUnit
        contstorageOrgUnit.setBoundEditor(prmtstorageOrgUnit);

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
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("EggEntry.seq", int.class, this.kdtEggEntry, "seq.text");
		dataBinder.registerBinding("EggEntry", com.kingdee.eas.farm.hatch.HatchAdjustBillEggEntryInfo.class, this.kdtEggEntry, "userObject");
		dataBinder.registerBinding("EggEntry.eggSourceType", com.kingdee.util.enums.Enum.class, this.kdtEggEntry, "eggSourceType.text");
		dataBinder.registerBinding("EggEntry.farm", java.lang.Object.class, this.kdtEggEntry, "farm.text");
		dataBinder.registerBinding("EggEntry.eggHouse", java.lang.Object.class, this.kdtEggEntry, "eggHouse.text");
		dataBinder.registerBinding("EggEntry.eggLog", String.class, this.kdtEggEntry, "eggLog.text");
		dataBinder.registerBinding("EggEntry.eggQty", int.class, this.kdtEggEntry, "eggQty.text");
		dataBinder.registerBinding("EggEntry.outFarm", java.lang.Object.class, this.kdtEggEntry, "outFarm.text");
		dataBinder.registerBinding("EggEntry.farmer", java.lang.Object.class, this.kdtEggEntry, "farmer.text");
		dataBinder.registerBinding("EggEntry.supplier", java.lang.Object.class, this.kdtEggEntry, "supplier.text");
		dataBinder.registerBinding("EggEntry.material", java.lang.Object.class, this.kdtEggEntry, "material.text");
		dataBinder.registerBinding("EggEntry.breedBatch", java.lang.Object.class, this.kdtEggEntry, "breedBatch.text");
		dataBinder.registerBinding("EggEntry.babyBatch", String.class, this.kdtEggEntry, "babyBatch.text");
		dataBinder.registerBinding("EggEntry.outBatch", java.lang.Object.class, this.kdtEggEntry, "outBatch.text");
		dataBinder.registerBinding("EggEntry.house", java.lang.Object.class, this.kdtEggEntry, "house.text");
		dataBinder.registerBinding("EggEntry.hatchHouse", java.lang.Object.class, this.kdtEggEntry, "hatchHouse.text");
		dataBinder.registerBinding("EggEntry.incubator", java.lang.Object.class, this.kdtEggEntry, "incubator.text");
		dataBinder.registerBinding("EggEntry.outHouse", java.lang.Object.class, this.kdtEggEntry, "outHouse.text");
		dataBinder.registerBinding("EggEntry.qc1lv1Qty", int.class, this.kdtEggEntry, "qc1lv1Qty.text");
		dataBinder.registerBinding("EggEntry.qc1lv2Qty", int.class, this.kdtEggEntry, "qc1lv2Qty.text");
		dataBinder.registerBinding("EggEntry.qc2lv1Qty", int.class, this.kdtEggEntry, "qc2lv1Qty.text");
		dataBinder.registerBinding("EggEntry.qc2lv2Qty", int.class, this.kdtEggEntry, "qc2lv2Qty.text");
		dataBinder.registerBinding("EggEntry.qc4lv1Qty", int.class, this.kdtEggEntry, "qc4lv1Qty.text");
		dataBinder.registerBinding("EggEntry.qc3lv1Qty", int.class, this.kdtEggEntry, "qc3lv1Qty.text");
		dataBinder.registerBinding("EggEntry.qc5lv1Qty", int.class, this.kdtEggEntry, "qc5lv1Qty.text");
		dataBinder.registerBinding("EggEntry.qc6lv1Qty", int.class, this.kdtEggEntry, "qc6lv1Qty.text");
		dataBinder.registerBinding("EggEntry.hatchCarNum", String.class, this.kdtEggEntry, "hatchCarNum.text");
		dataBinder.registerBinding("EggEntry.outArea", java.lang.Object.class, this.kdtEggEntry, "outArea.text");
		dataBinder.registerBinding("EggEntry.isMix", boolean.class, this.kdtEggEntry, "isMix.text");
		dataBinder.registerBinding("EggEntry.qcEggType", com.kingdee.util.enums.Enum.class, this.kdtEggEntry, "qcEggType.text");
		dataBinder.registerBinding("EggEntry.sendDate", java.util.Date.class, this.kdtEggEntry, "sendDate.text");
		dataBinder.registerBinding("EggEntry.dayAge", int.class, this.kdtEggEntry, "dayAge.text");
		dataBinder.registerBinding("EggEntry.isFormal", boolean.class, this.kdtEggEntry, "isFormal.text");
		dataBinder.registerBinding("EggEntry.weeklyAge", String.class, this.kdtEggEntry, "weeklyAge.text");
		dataBinder.registerBinding("EggEntry.genderType", com.kingdee.util.enums.Enum.class, this.kdtEggEntry, "genderType.text");
		dataBinder.registerBinding("EggEntry.seqNum", int.class, this.kdtEggEntry, "seqNum.text");
		dataBinder.registerBinding("srcBill", com.kingdee.eas.farm.hatch.BEggHatchBillInfo.class, this.prmtsrcBill, "data");
		dataBinder.registerBinding("srcBillType", com.kingdee.eas.farm.hatch.HatchBillTypeEnum.class, this.srcBillType, "selectedItem");
		dataBinder.registerBinding("storageOrgUnit", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtstorageOrgUnit, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.hatch.app.HatchAdjustBillEditUIHandler";
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
        this.txtNumber.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.hatch.HatchAdjustBillInfo)ov;
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
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.eggSourceType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.eggHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.eggLog", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.eggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.outFarm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.supplier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.breedBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.babyBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.outBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.house", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.hatchHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.incubator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.outHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.qc1lv1Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.qc1lv2Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.qc2lv1Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.qc2lv2Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.qc4lv1Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.qc3lv1Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.qc5lv1Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.qc6lv1Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.hatchCarNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.outArea", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.isMix", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.qcEggType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.sendDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.dayAge", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.isFormal", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.weeklyAge", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.genderType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.seqNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("srcBill", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("srcBillType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("storageOrgUnit", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("baseStatus"));
    	sic.add(new SelectorItemInfo("EggEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("EggEntry.eggSourceType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.farm.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.farm.id"));
			sic.add(new SelectorItemInfo("EggEntry.farm.name"));
        	sic.add(new SelectorItemInfo("EggEntry.farm.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.eggHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.eggHouse.id"));
			sic.add(new SelectorItemInfo("EggEntry.eggHouse.name"));
        	sic.add(new SelectorItemInfo("EggEntry.eggHouse.number"));
		}
    	sic.add(new SelectorItemInfo("EggEntry.eggLog"));
    	sic.add(new SelectorItemInfo("EggEntry.eggQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.outFarm.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.outFarm.id"));
			sic.add(new SelectorItemInfo("EggEntry.outFarm.name"));
        	sic.add(new SelectorItemInfo("EggEntry.outFarm.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.farmer.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.farmer.id"));
			sic.add(new SelectorItemInfo("EggEntry.farmer.name"));
        	sic.add(new SelectorItemInfo("EggEntry.farmer.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.supplier.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.supplier.id"));
			sic.add(new SelectorItemInfo("EggEntry.supplier.name"));
        	sic.add(new SelectorItemInfo("EggEntry.supplier.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.material.id"));
			sic.add(new SelectorItemInfo("EggEntry.material.name"));
        	sic.add(new SelectorItemInfo("EggEntry.material.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.breedBatch.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.breedBatch.id"));
			sic.add(new SelectorItemInfo("EggEntry.breedBatch.name"));
        	sic.add(new SelectorItemInfo("EggEntry.breedBatch.number"));
		}
    	sic.add(new SelectorItemInfo("EggEntry.babyBatch"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.outBatch.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.outBatch.id"));
			sic.add(new SelectorItemInfo("EggEntry.outBatch.name"));
        	sic.add(new SelectorItemInfo("EggEntry.outBatch.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.house.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.house.id"));
			sic.add(new SelectorItemInfo("EggEntry.house.name"));
        	sic.add(new SelectorItemInfo("EggEntry.house.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.hatchHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.hatchHouse.id"));
			sic.add(new SelectorItemInfo("EggEntry.hatchHouse.name"));
        	sic.add(new SelectorItemInfo("EggEntry.hatchHouse.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.incubator.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.incubator.id"));
			sic.add(new SelectorItemInfo("EggEntry.incubator.name"));
        	sic.add(new SelectorItemInfo("EggEntry.incubator.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.outHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.outHouse.id"));
			sic.add(new SelectorItemInfo("EggEntry.outHouse.name"));
        	sic.add(new SelectorItemInfo("EggEntry.outHouse.number"));
		}
    	sic.add(new SelectorItemInfo("EggEntry.qc1lv1Qty"));
    	sic.add(new SelectorItemInfo("EggEntry.qc1lv2Qty"));
    	sic.add(new SelectorItemInfo("EggEntry.qc2lv1Qty"));
    	sic.add(new SelectorItemInfo("EggEntry.qc2lv2Qty"));
    	sic.add(new SelectorItemInfo("EggEntry.qc4lv1Qty"));
    	sic.add(new SelectorItemInfo("EggEntry.qc3lv1Qty"));
    	sic.add(new SelectorItemInfo("EggEntry.qc5lv1Qty"));
    	sic.add(new SelectorItemInfo("EggEntry.qc6lv1Qty"));
    	sic.add(new SelectorItemInfo("EggEntry.hatchCarNum"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.outArea.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.outArea.id"));
			sic.add(new SelectorItemInfo("EggEntry.outArea.name"));
        	sic.add(new SelectorItemInfo("EggEntry.outArea.number"));
		}
    	sic.add(new SelectorItemInfo("EggEntry.isMix"));
    	sic.add(new SelectorItemInfo("EggEntry.qcEggType"));
    	sic.add(new SelectorItemInfo("EggEntry.sendDate"));
    	sic.add(new SelectorItemInfo("EggEntry.dayAge"));
    	sic.add(new SelectorItemInfo("EggEntry.isFormal"));
    	sic.add(new SelectorItemInfo("EggEntry.weeklyAge"));
    	sic.add(new SelectorItemInfo("EggEntry.genderType"));
    	sic.add(new SelectorItemInfo("EggEntry.seqNum"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("srcBill.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("srcBill.id"));
        	sic.add(new SelectorItemInfo("srcBill.number"));
		}
        sic.add(new SelectorItemInfo("srcBillType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("storageOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("storageOrgUnit.id"));
        	sic.add(new SelectorItemInfo("storageOrgUnit.number"));
        	sic.add(new SelectorItemInfo("storageOrgUnit.name"));
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
        com.kingdee.eas.farm.hatch.HatchAdjustBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.hatch.HatchAdjustBillFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractHatchAdjustBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractHatchAdjustBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.hatch.client", "HatchAdjustBillEditUI");
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
        return com.kingdee.eas.farm.hatch.client.HatchAdjustBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.hatch.HatchAdjustBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.hatch.HatchAdjustBillInfo objectValue = new com.kingdee.eas.farm.hatch.HatchAdjustBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/hatch/HatchAdjustBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.hatch.app.HatchAdjustBillQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		for (int i=0,n=kdtEggEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEggEntry.getCell(i,"hatchCarNum").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"孵化车号"});
			}
		}
		for (int i=0,n=kdtEggEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEggEntry.getCell(i,"genderType").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"品系"});
			}
		}
		for (int i=0,n=kdtEggEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEggEntry.getCell(i,"eggHouse").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"蛋库"});
			}
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtEggEntry;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("srcBillType",new Integer(0));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}