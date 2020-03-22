/**
 * output package name
 */
package com.kingdee.eas.farm.food.client;

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
public abstract class AbstractTransportDailyEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractTransportDailyEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contStorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompanyOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDComboBox BillStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtStorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkAuditTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompanyOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtOilEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtOilEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.eas.farm.food.TransportDailyInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractTransportDailyEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractTransportDailyEditUI.class.getName());
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
        this.contBillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contStorageOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompanyOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.BillStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtStorageOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkAuditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtcompanyOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtOilEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.tBtnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
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
        this.contBillStatus.setName("contBillStatus");
        this.contStorageOrgUnit.setName("contStorageOrgUnit");
        this.contAuditTime.setName("contAuditTime");
        this.contcompanyOrgUnit.setName("contcompanyOrgUnit");
        this.kDSeparator8.setName("kDSeparator8");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.BillStatus.setName("BillStatus");
        this.prmtStorageOrgUnit.setName("prmtStorageOrgUnit");
        this.pkAuditTime.setName("pkAuditTime");
        this.prmtcompanyOrgUnit.setName("prmtcompanyOrgUnit");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kdtEntry.setName("kdtEntry");
        this.kdtOilEntry.setName("kdtOilEntry");
        this.tBtnAudit.setName("tBtnAudit");
        this.tBtnUnAudit.setName("tBtnUnAudit");
        this.mBtnAudit.setName("mBtnAudit");
        this.mBtnUnAudit.setName("mBtnUnAudit");
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
        // contBillStatus		
        this.contBillStatus.setBoundLabelText(resHelper.getString("contBillStatus.boundLabelText"));		
        this.contBillStatus.setBoundLabelLength(100);		
        this.contBillStatus.setBoundLabelUnderline(true);		
        this.contBillStatus.setVisible(true);
        // contStorageOrgUnit		
        this.contStorageOrgUnit.setBoundLabelText(resHelper.getString("contStorageOrgUnit.boundLabelText"));		
        this.contStorageOrgUnit.setBoundLabelLength(100);		
        this.contStorageOrgUnit.setBoundLabelUnderline(true);		
        this.contStorageOrgUnit.setVisible(true);
        // contAuditTime		
        this.contAuditTime.setBoundLabelText(resHelper.getString("contAuditTime.boundLabelText"));		
        this.contAuditTime.setBoundLabelLength(100);		
        this.contAuditTime.setBoundLabelUnderline(true);		
        this.contAuditTime.setVisible(true);
        // contcompanyOrgUnit		
        this.contcompanyOrgUnit.setBoundLabelText(resHelper.getString("contcompanyOrgUnit.boundLabelText"));		
        this.contcompanyOrgUnit.setBoundLabelLength(100);		
        this.contcompanyOrgUnit.setBoundLabelUnderline(true);		
        this.contcompanyOrgUnit.setVisible(true);
        // kDSeparator8
        // kDTabbedPane1
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
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // BillStatus		
        this.BillStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.BillStatus.setRequired(false);		
        this.BillStatus.setEnabled(false);
        // prmtStorageOrgUnit		
        this.prmtStorageOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtStorageOrgUnit.setEditable(true);		
        this.prmtStorageOrgUnit.setDisplayFormat("$name$");		
        this.prmtStorageOrgUnit.setEditFormat("$number$");		
        this.prmtStorageOrgUnit.setCommitFormat("$number$");		
        this.prmtStorageOrgUnit.setRequired(true);
        // pkAuditTime		
        this.pkAuditTime.setRequired(false);		
        this.pkAuditTime.setEnabled(false);
        // prmtcompanyOrgUnit		
        this.prmtcompanyOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompanyOrgUnit.setEditable(true);		
        this.prmtcompanyOrgUnit.setDisplayFormat("$name$");		
        this.prmtcompanyOrgUnit.setEditFormat("$number$");		
        this.prmtcompanyOrgUnit.setCommitFormat("$number$");		
        this.prmtcompanyOrgUnit.setRequired(true);
        // kDPanel1
        // kDPanel2
        // kdtEntry
		String kdtEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"car\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"count\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"DeliveryLine\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"beginStation\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"endStation\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"mileage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"startMileage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"endMileage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"todayMileage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"avgMileage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"todayMPG\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"avgMPG\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"violationTimes\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"lateLong\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{car}</t:Cell><t:Cell>$Resource{count}</t:Cell><t:Cell>$Resource{DeliveryLine}</t:Cell><t:Cell>$Resource{beginStation}</t:Cell><t:Cell>$Resource{endStation}</t:Cell><t:Cell>$Resource{mileage}</t:Cell><t:Cell>$Resource{startMileage}</t:Cell><t:Cell>$Resource{endMileage}</t:Cell><t:Cell>$Resource{todayMileage}</t:Cell><t:Cell>$Resource{avgMileage}</t:Cell><t:Cell>$Resource{todayMPG}</t:Cell><t:Cell>$Resource{avgMPG}</t:Cell><t:Cell>$Resource{violationTimes}</t:Cell><t:Cell>$Resource{lateLong}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntry.setFormatXml(resHelper.translateString("kdtEntry",kdtEntryStrXML));
        kdtEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtEntry.putBindContents("editData",new String[] {"seq","car","count","DeliveryLine","beginStation","endStation","mileage","startMileage","endMileage","todayMileage","avgMileage","todayMPG","avgMPG","violationTimes","lateLong"});


        this.kdtEntry.checkParsed();
        final KDBizPromptBox kdtEntry_car_PromptBox = new KDBizPromptBox();
        kdtEntry_car_PromptBox.setQueryInfo("com.kingdee.eas.publicdata.app.CarQuery");
        kdtEntry_car_PromptBox.setVisible(true);
        kdtEntry_car_PromptBox.setEditable(true);
        kdtEntry_car_PromptBox.setDisplayFormat("$number$");
        kdtEntry_car_PromptBox.setEditFormat("$number$");
        kdtEntry_car_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_car_CellEditor = new KDTDefaultCellEditor(kdtEntry_car_PromptBox);
        this.kdtEntry.getColumn("car").setEditor(kdtEntry_car_CellEditor);
        ObjectValueRender kdtEntry_car_OVR = new ObjectValueRender();
        kdtEntry_car_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntry.getColumn("car").setRenderer(kdtEntry_car_OVR);
        			kdtEntry_car_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.CarListUI kdtEntry_car_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntry_car_PromptBox_F7ListUI == null) {
					try {
						kdtEntry_car_PromptBox_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.CarListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntry_car_PromptBox_F7ListUI));
					kdtEntry_car_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntry_car_PromptBox.setSelector(kdtEntry_car_PromptBox_F7ListUI);
				}
			}
		});
					
        KDFormattedTextField kdtEntry_count_TextField = new KDFormattedTextField();
        kdtEntry_count_TextField.setName("kdtEntry_count_TextField");
        kdtEntry_count_TextField.setVisible(true);
        kdtEntry_count_TextField.setEditable(true);
        kdtEntry_count_TextField.setHorizontalAlignment(2);
        kdtEntry_count_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntry_count_CellEditor = new KDTDefaultCellEditor(kdtEntry_count_TextField);
        this.kdtEntry.getColumn("count").setEditor(kdtEntry_count_CellEditor);
        final KDBizPromptBox kdtEntry_DeliveryLine_PromptBox = new KDBizPromptBox();
        kdtEntry_DeliveryLine_PromptBox.setQueryInfo("com.kingdee.eas.delivery.basedata.app.DeliveryLineQuery");
        kdtEntry_DeliveryLine_PromptBox.setVisible(true);
        kdtEntry_DeliveryLine_PromptBox.setEditable(true);
        kdtEntry_DeliveryLine_PromptBox.setDisplayFormat("$number$");
        kdtEntry_DeliveryLine_PromptBox.setEditFormat("$number$");
        kdtEntry_DeliveryLine_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_DeliveryLine_CellEditor = new KDTDefaultCellEditor(kdtEntry_DeliveryLine_PromptBox);
        this.kdtEntry.getColumn("DeliveryLine").setEditor(kdtEntry_DeliveryLine_CellEditor);
        ObjectValueRender kdtEntry_DeliveryLine_OVR = new ObjectValueRender();
        kdtEntry_DeliveryLine_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("DeliveryLine").setRenderer(kdtEntry_DeliveryLine_OVR);
        KDTextField kdtEntry_beginStation_TextField = new KDTextField();
        kdtEntry_beginStation_TextField.setName("kdtEntry_beginStation_TextField");
        kdtEntry_beginStation_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntry_beginStation_CellEditor = new KDTDefaultCellEditor(kdtEntry_beginStation_TextField);
        this.kdtEntry.getColumn("beginStation").setEditor(kdtEntry_beginStation_CellEditor);
        KDTextField kdtEntry_endStation_TextField = new KDTextField();
        kdtEntry_endStation_TextField.setName("kdtEntry_endStation_TextField");
        kdtEntry_endStation_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntry_endStation_CellEditor = new KDTDefaultCellEditor(kdtEntry_endStation_TextField);
        this.kdtEntry.getColumn("endStation").setEditor(kdtEntry_endStation_CellEditor);
        KDFormattedTextField kdtEntry_mileage_TextField = new KDFormattedTextField();
        kdtEntry_mileage_TextField.setName("kdtEntry_mileage_TextField");
        kdtEntry_mileage_TextField.setVisible(true);
        kdtEntry_mileage_TextField.setEditable(true);
        kdtEntry_mileage_TextField.setHorizontalAlignment(2);
        kdtEntry_mileage_TextField.setDataType(1);
        	kdtEntry_mileage_TextField.setMinimumValue(new java.math.BigDecimal("-3.4028234663852886E38"));
        	kdtEntry_mileage_TextField.setMaximumValue(new java.math.BigDecimal("3.4028234663852886E38"));
        kdtEntry_mileage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_mileage_CellEditor = new KDTDefaultCellEditor(kdtEntry_mileage_TextField);
        this.kdtEntry.getColumn("mileage").setEditor(kdtEntry_mileage_CellEditor);
        KDFormattedTextField kdtEntry_startMileage_TextField = new KDFormattedTextField();
        kdtEntry_startMileage_TextField.setName("kdtEntry_startMileage_TextField");
        kdtEntry_startMileage_TextField.setVisible(true);
        kdtEntry_startMileage_TextField.setEditable(true);
        kdtEntry_startMileage_TextField.setHorizontalAlignment(2);
        kdtEntry_startMileage_TextField.setDataType(1);
        	kdtEntry_startMileage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_startMileage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_startMileage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_startMileage_CellEditor = new KDTDefaultCellEditor(kdtEntry_startMileage_TextField);
        this.kdtEntry.getColumn("startMileage").setEditor(kdtEntry_startMileage_CellEditor);
        KDFormattedTextField kdtEntry_endMileage_TextField = new KDFormattedTextField();
        kdtEntry_endMileage_TextField.setName("kdtEntry_endMileage_TextField");
        kdtEntry_endMileage_TextField.setVisible(true);
        kdtEntry_endMileage_TextField.setEditable(true);
        kdtEntry_endMileage_TextField.setHorizontalAlignment(2);
        kdtEntry_endMileage_TextField.setDataType(1);
        	kdtEntry_endMileage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_endMileage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_endMileage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_endMileage_CellEditor = new KDTDefaultCellEditor(kdtEntry_endMileage_TextField);
        this.kdtEntry.getColumn("endMileage").setEditor(kdtEntry_endMileage_CellEditor);
        KDFormattedTextField kdtEntry_todayMileage_TextField = new KDFormattedTextField();
        kdtEntry_todayMileage_TextField.setName("kdtEntry_todayMileage_TextField");
        kdtEntry_todayMileage_TextField.setVisible(true);
        kdtEntry_todayMileage_TextField.setEditable(true);
        kdtEntry_todayMileage_TextField.setHorizontalAlignment(2);
        kdtEntry_todayMileage_TextField.setDataType(1);
        	kdtEntry_todayMileage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_todayMileage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_todayMileage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_todayMileage_CellEditor = new KDTDefaultCellEditor(kdtEntry_todayMileage_TextField);
        this.kdtEntry.getColumn("todayMileage").setEditor(kdtEntry_todayMileage_CellEditor);
        KDFormattedTextField kdtEntry_avgMileage_TextField = new KDFormattedTextField();
        kdtEntry_avgMileage_TextField.setName("kdtEntry_avgMileage_TextField");
        kdtEntry_avgMileage_TextField.setVisible(true);
        kdtEntry_avgMileage_TextField.setEditable(true);
        kdtEntry_avgMileage_TextField.setHorizontalAlignment(2);
        kdtEntry_avgMileage_TextField.setDataType(1);
        	kdtEntry_avgMileage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_avgMileage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_avgMileage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_avgMileage_CellEditor = new KDTDefaultCellEditor(kdtEntry_avgMileage_TextField);
        this.kdtEntry.getColumn("avgMileage").setEditor(kdtEntry_avgMileage_CellEditor);
        KDFormattedTextField kdtEntry_todayMPG_TextField = new KDFormattedTextField();
        kdtEntry_todayMPG_TextField.setName("kdtEntry_todayMPG_TextField");
        kdtEntry_todayMPG_TextField.setVisible(true);
        kdtEntry_todayMPG_TextField.setEditable(true);
        kdtEntry_todayMPG_TextField.setHorizontalAlignment(2);
        kdtEntry_todayMPG_TextField.setDataType(1);
        	kdtEntry_todayMPG_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_todayMPG_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_todayMPG_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_todayMPG_CellEditor = new KDTDefaultCellEditor(kdtEntry_todayMPG_TextField);
        this.kdtEntry.getColumn("todayMPG").setEditor(kdtEntry_todayMPG_CellEditor);
        KDFormattedTextField kdtEntry_avgMPG_TextField = new KDFormattedTextField();
        kdtEntry_avgMPG_TextField.setName("kdtEntry_avgMPG_TextField");
        kdtEntry_avgMPG_TextField.setVisible(true);
        kdtEntry_avgMPG_TextField.setEditable(true);
        kdtEntry_avgMPG_TextField.setHorizontalAlignment(2);
        kdtEntry_avgMPG_TextField.setDataType(1);
        	kdtEntry_avgMPG_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_avgMPG_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_avgMPG_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_avgMPG_CellEditor = new KDTDefaultCellEditor(kdtEntry_avgMPG_TextField);
        this.kdtEntry.getColumn("avgMPG").setEditor(kdtEntry_avgMPG_CellEditor);
        KDFormattedTextField kdtEntry_violationTimes_TextField = new KDFormattedTextField();
        kdtEntry_violationTimes_TextField.setName("kdtEntry_violationTimes_TextField");
        kdtEntry_violationTimes_TextField.setVisible(true);
        kdtEntry_violationTimes_TextField.setEditable(true);
        kdtEntry_violationTimes_TextField.setHorizontalAlignment(2);
        kdtEntry_violationTimes_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntry_violationTimes_CellEditor = new KDTDefaultCellEditor(kdtEntry_violationTimes_TextField);
        this.kdtEntry.getColumn("violationTimes").setEditor(kdtEntry_violationTimes_CellEditor);
        KDFormattedTextField kdtEntry_lateLong_TextField = new KDFormattedTextField();
        kdtEntry_lateLong_TextField.setName("kdtEntry_lateLong_TextField");
        kdtEntry_lateLong_TextField.setVisible(true);
        kdtEntry_lateLong_TextField.setEditable(true);
        kdtEntry_lateLong_TextField.setHorizontalAlignment(2);
        kdtEntry_lateLong_TextField.setDataType(1);
        	kdtEntry_lateLong_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntry_lateLong_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntry_lateLong_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntry_lateLong_CellEditor = new KDTDefaultCellEditor(kdtEntry_lateLong_TextField);
        this.kdtEntry.getColumn("lateLong").setEditor(kdtEntry_lateLong_CellEditor);
        // kdtOilEntry
		String kdtOilEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"car\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"mileage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"price\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"urea\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{car}</t:Cell><t:Cell>$Resource{mileage}</t:Cell><t:Cell>$Resource{price}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{urea}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtOilEntry.setFormatXml(resHelper.translateString("kdtOilEntry",kdtOilEntryStrXML));
        kdtOilEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtOilEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtOilEntry.putBindContents("editData",new String[] {"seq","car","mileage","price","qty","amount","urea"});


        this.kdtOilEntry.checkParsed();
        final KDBizPromptBox kdtOilEntry_car_PromptBox = new KDBizPromptBox();
        kdtOilEntry_car_PromptBox.setQueryInfo("com.kingdee.eas.publicdata.app.CarQuery");
        kdtOilEntry_car_PromptBox.setVisible(true);
        kdtOilEntry_car_PromptBox.setEditable(true);
        kdtOilEntry_car_PromptBox.setDisplayFormat("$number$");
        kdtOilEntry_car_PromptBox.setEditFormat("$number$");
        kdtOilEntry_car_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtOilEntry_car_CellEditor = new KDTDefaultCellEditor(kdtOilEntry_car_PromptBox);
        this.kdtOilEntry.getColumn("car").setEditor(kdtOilEntry_car_CellEditor);
        ObjectValueRender kdtOilEntry_car_OVR = new ObjectValueRender();
        kdtOilEntry_car_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtOilEntry.getColumn("car").setRenderer(kdtOilEntry_car_OVR);
        			kdtOilEntry_car_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.CarListUI kdtOilEntry_car_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtOilEntry_car_PromptBox_F7ListUI == null) {
					try {
						kdtOilEntry_car_PromptBox_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.CarListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtOilEntry_car_PromptBox_F7ListUI));
					kdtOilEntry_car_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtOilEntry_car_PromptBox.setSelector(kdtOilEntry_car_PromptBox_F7ListUI);
				}
			}
		});
					
        KDFormattedTextField kdtOilEntry_mileage_TextField = new KDFormattedTextField();
        kdtOilEntry_mileage_TextField.setName("kdtOilEntry_mileage_TextField");
        kdtOilEntry_mileage_TextField.setVisible(true);
        kdtOilEntry_mileage_TextField.setEditable(true);
        kdtOilEntry_mileage_TextField.setHorizontalAlignment(2);
        kdtOilEntry_mileage_TextField.setDataType(1);
        	kdtOilEntry_mileage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtOilEntry_mileage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtOilEntry_mileage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtOilEntry_mileage_CellEditor = new KDTDefaultCellEditor(kdtOilEntry_mileage_TextField);
        this.kdtOilEntry.getColumn("mileage").setEditor(kdtOilEntry_mileage_CellEditor);
        KDFormattedTextField kdtOilEntry_price_TextField = new KDFormattedTextField();
        kdtOilEntry_price_TextField.setName("kdtOilEntry_price_TextField");
        kdtOilEntry_price_TextField.setVisible(true);
        kdtOilEntry_price_TextField.setEditable(true);
        kdtOilEntry_price_TextField.setHorizontalAlignment(2);
        kdtOilEntry_price_TextField.setDataType(1);
        	kdtOilEntry_price_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtOilEntry_price_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtOilEntry_price_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtOilEntry_price_CellEditor = new KDTDefaultCellEditor(kdtOilEntry_price_TextField);
        this.kdtOilEntry.getColumn("price").setEditor(kdtOilEntry_price_CellEditor);
        KDFormattedTextField kdtOilEntry_qty_TextField = new KDFormattedTextField();
        kdtOilEntry_qty_TextField.setName("kdtOilEntry_qty_TextField");
        kdtOilEntry_qty_TextField.setVisible(true);
        kdtOilEntry_qty_TextField.setEditable(true);
        kdtOilEntry_qty_TextField.setHorizontalAlignment(2);
        kdtOilEntry_qty_TextField.setDataType(1);
        	kdtOilEntry_qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtOilEntry_qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtOilEntry_qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtOilEntry_qty_CellEditor = new KDTDefaultCellEditor(kdtOilEntry_qty_TextField);
        this.kdtOilEntry.getColumn("qty").setEditor(kdtOilEntry_qty_CellEditor);
        KDFormattedTextField kdtOilEntry_amount_TextField = new KDFormattedTextField();
        kdtOilEntry_amount_TextField.setName("kdtOilEntry_amount_TextField");
        kdtOilEntry_amount_TextField.setVisible(true);
        kdtOilEntry_amount_TextField.setEditable(true);
        kdtOilEntry_amount_TextField.setHorizontalAlignment(2);
        kdtOilEntry_amount_TextField.setDataType(1);
        	kdtOilEntry_amount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtOilEntry_amount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtOilEntry_amount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtOilEntry_amount_CellEditor = new KDTDefaultCellEditor(kdtOilEntry_amount_TextField);
        this.kdtOilEntry.getColumn("amount").setEditor(kdtOilEntry_amount_CellEditor);
        KDFormattedTextField kdtOilEntry_urea_TextField = new KDFormattedTextField();
        kdtOilEntry_urea_TextField.setName("kdtOilEntry_urea_TextField");
        kdtOilEntry_urea_TextField.setVisible(true);
        kdtOilEntry_urea_TextField.setEditable(true);
        kdtOilEntry_urea_TextField.setHorizontalAlignment(2);
        kdtOilEntry_urea_TextField.setDataType(1);
        	kdtOilEntry_urea_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtOilEntry_urea_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtOilEntry_urea_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtOilEntry_urea_CellEditor = new KDTDefaultCellEditor(kdtOilEntry_urea_TextField);
        this.kdtOilEntry.getColumn("urea").setEditor(kdtOilEntry_urea_CellEditor);
        // tBtnAudit
        this.tBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnAudit.setText(resHelper.getString("tBtnAudit.text"));
        // tBtnUnAudit
        this.tBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnUnAudit.setText(resHelper.getString("tBtnUnAudit.text"));
        // mBtnAudit
        this.mBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnAudit.setText(resHelper.getString("mBtnAudit.text"));
        // mBtnUnAudit
        this.mBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnUnAudit.setText(resHelper.getString("mBtnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,BillStatus,prmtStorageOrgUnit,pkAuditTime,prmtcompanyOrgUnit,kdtEntry,kdtOilEntry}));
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
        this.setBounds(new Rectangle(0, 0, 722, 482));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 722, 482));
        contCreator.setBounds(new Rectangle(45, 397, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(45, 397, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(45, 428, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(45, 428, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(780, 349, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(780, 349, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(778, 380, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(778, 380, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contNumber.setBounds(new Rectangle(10, 18, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(10, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(434, 18, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(434, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contDescription.setBounds(new Rectangle(434, 81, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(434, 81, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(388, 397, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(388, 397, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contBillStatus.setBounds(new Rectangle(10, 82, 270, 19));
        this.add(contBillStatus, new KDLayout.Constraints(10, 82, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contStorageOrgUnit.setBounds(new Rectangle(10, 49, 270, 19));
        this.add(contStorageOrgUnit, new KDLayout.Constraints(10, 49, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditTime.setBounds(new Rectangle(388, 428, 270, 19));
        this.add(contAuditTime, new KDLayout.Constraints(388, 428, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompanyOrgUnit.setBounds(new Rectangle(434, 49, 270, 19));
        this.add(contcompanyOrgUnit, new KDLayout.Constraints(434, 49, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator8.setBounds(new Rectangle(-2, 115, 717, 8));
        this.add(kDSeparator8, new KDLayout.Constraints(-2, 115, 717, 8, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDTabbedPane1.setBounds(new Rectangle(15, 123, 683, 264));
        this.add(kDTabbedPane1, new KDLayout.Constraints(15, 123, 683, 264, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //contBillStatus
        contBillStatus.setBoundEditor(BillStatus);
        //contStorageOrgUnit
        contStorageOrgUnit.setBoundEditor(prmtStorageOrgUnit);
        //contAuditTime
        contAuditTime.setBoundEditor(pkAuditTime);
        //contcompanyOrgUnit
        contcompanyOrgUnit.setBoundEditor(prmtcompanyOrgUnit);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 682, 231));        kdtEntry.setBounds(new Rectangle(1, 1, 669, 227));
        kdtEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntry,new com.kingdee.eas.farm.food.TransportDailyEntryInfo(),null,false);
        kDPanel1.add(kdtEntry_detailPanel, new KDLayout.Constraints(1, 1, 669, 227, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtEntry_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
		vo.put("avgMPG",new java.math.BigDecimal(0.35));
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 682, 231));        kdtOilEntry.setBounds(new Rectangle(2, 1, 669, 222));
        kdtOilEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtOilEntry,new com.kingdee.eas.farm.food.TransportDailyOilEntryInfo(),null,false);
        kDPanel2.add(kdtOilEntry_detailPanel, new KDLayout.Constraints(2, 1, 669, 222, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));

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
        this.toolBar.add(tBtnAudit);
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
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("BillStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.BillStatus, "selectedItem");
		dataBinder.registerBinding("StorageOrgUnit", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtStorageOrgUnit, "data");
		dataBinder.registerBinding("AuditTime", java.util.Date.class, this.pkAuditTime, "value");
		dataBinder.registerBinding("companyOrgUnit", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompanyOrgUnit, "data");
		dataBinder.registerBinding("Entry.seq", int.class, this.kdtEntry, "seq.text");
		dataBinder.registerBinding("Entry", com.kingdee.eas.farm.food.TransportDailyEntryInfo.class, this.kdtEntry, "userObject");
		dataBinder.registerBinding("Entry.car", java.lang.Object.class, this.kdtEntry, "car.text");
		dataBinder.registerBinding("Entry.count", int.class, this.kdtEntry, "count.text");
		dataBinder.registerBinding("Entry.DeliveryLine", java.lang.Object.class, this.kdtEntry, "DeliveryLine.text");
		dataBinder.registerBinding("Entry.beginStation", String.class, this.kdtEntry, "beginStation.text");
		dataBinder.registerBinding("Entry.endStation", String.class, this.kdtEntry, "endStation.text");
		dataBinder.registerBinding("Entry.mileage", java.math.BigDecimal.class, this.kdtEntry, "mileage.text");
		dataBinder.registerBinding("Entry.startMileage", java.math.BigDecimal.class, this.kdtEntry, "startMileage.text");
		dataBinder.registerBinding("Entry.endMileage", java.math.BigDecimal.class, this.kdtEntry, "endMileage.text");
		dataBinder.registerBinding("Entry.todayMileage", java.math.BigDecimal.class, this.kdtEntry, "todayMileage.text");
		dataBinder.registerBinding("Entry.avgMileage", java.math.BigDecimal.class, this.kdtEntry, "avgMileage.text");
		dataBinder.registerBinding("Entry.todayMPG", java.math.BigDecimal.class, this.kdtEntry, "todayMPG.text");
		dataBinder.registerBinding("Entry.avgMPG", java.math.BigDecimal.class, this.kdtEntry, "avgMPG.text");
		dataBinder.registerBinding("Entry.violationTimes", int.class, this.kdtEntry, "violationTimes.text");
		dataBinder.registerBinding("Entry.lateLong", java.math.BigDecimal.class, this.kdtEntry, "lateLong.text");
		dataBinder.registerBinding("OilEntry.seq", int.class, this.kdtOilEntry, "seq.text");
		dataBinder.registerBinding("OilEntry", com.kingdee.eas.farm.food.TransportDailyOilEntryInfo.class, this.kdtOilEntry, "userObject");
		dataBinder.registerBinding("OilEntry.mileage", java.math.BigDecimal.class, this.kdtOilEntry, "mileage.text");
		dataBinder.registerBinding("OilEntry.amount", java.math.BigDecimal.class, this.kdtOilEntry, "amount.text");
		dataBinder.registerBinding("OilEntry.qty", java.math.BigDecimal.class, this.kdtOilEntry, "qty.text");
		dataBinder.registerBinding("OilEntry.car", java.lang.Object.class, this.kdtOilEntry, "car.text");
		dataBinder.registerBinding("OilEntry.price", java.math.BigDecimal.class, this.kdtOilEntry, "price.text");
		dataBinder.registerBinding("OilEntry.urea", java.math.BigDecimal.class, this.kdtOilEntry, "urea.text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.food.app.TransportDailyEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.food.TransportDailyInfo)ov;
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
		getValidateHelper().registerBindProperty("BillStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StorageOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AuditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("companyOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.car", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.count", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.DeliveryLine", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.beginStation", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.endStation", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.mileage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.startMileage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.endMileage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.todayMileage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.avgMileage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.todayMPG", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.avgMPG", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.violationTimes", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.lateLong", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OilEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OilEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OilEntry.mileage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OilEntry.amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OilEntry.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OilEntry.car", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OilEntry.price", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OilEntry.urea", ValidateHelper.ON_SAVE);    		
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
     * output kdtEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("count".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
if (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEntry.getCell(rowIndex,"count").getValue())> 0) 
{
    kdtEntry.getCell(rowIndex,"avgMileage").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntry.getCell(rowIndex,"todayMileage").getValue())/ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEntry.getCell(rowIndex,"count").getValue())));
}

}

    if ("DeliveryLine".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"beginStation").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntry.getCell(rowIndex,"DeliveryLine").getValue(),"beginStation.name")));

}

    if ("DeliveryLine".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"endStation").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntry.getCell(rowIndex,"DeliveryLine").getValue(),"endStation.name")));

}

    if ("DeliveryLine".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"mileage").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntry.getCell(rowIndex,"DeliveryLine").getValue(),"totalMileage")));

}

    if ("startMileage".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"todayMileage").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntry.getCell(rowIndex,"endMileage").getValue())- com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntry.getCell(rowIndex,"startMileage").getValue())));

}

    if ("startMileage".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
if (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEntry.getCell(rowIndex,"count").getValue())> 0) 
{
    kdtEntry.getCell(rowIndex,"avgMileage").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntry.getCell(rowIndex,"todayMileage").getValue())/ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEntry.getCell(rowIndex,"count").getValue())));
}

}

    if ("startMileage".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"todayMPG").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntry.getCell(rowIndex,"todayMileage").getValue())* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntry.getCell(rowIndex,"avgMPG").getValue())));

}

    if ("endMileage".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"todayMileage").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntry.getCell(rowIndex,"endMileage").getValue())- com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntry.getCell(rowIndex,"startMileage").getValue())));

}

    if ("endMileage".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
if (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEntry.getCell(rowIndex,"count").getValue())> 0) 
{
    kdtEntry.getCell(rowIndex,"avgMileage").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntry.getCell(rowIndex,"todayMileage").getValue())/ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEntry.getCell(rowIndex,"count").getValue())));
    kdtEntry.getCell(rowIndex,"avgMileage").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntry.getCell(rowIndex,"todayMileage").getValue())/ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEntry.getCell(rowIndex,"count").getValue())));
}

}

    if ("endMileage".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"todayMPG").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntry.getCell(rowIndex,"todayMileage").getValue())* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntry.getCell(rowIndex,"avgMPG").getValue())));

}

    if ("todayMPG".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
if (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEntry.getCell(rowIndex,"count").getValue())> 0) 
{
    kdtEntry.getCell(rowIndex,"avgMPG").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntry.getCell(rowIndex,"todayMPG").getValue())/ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEntry.getCell(rowIndex,"count").getValue())));
}

}

    if ("avgMPG".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"todayMPG").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntry.getCell(rowIndex,"avgMPG").getValue())* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntry.getCell(rowIndex,"todayMileage").getValue())));

}


    }

    /**
     * output kdtOilEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtOilEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("price".equalsIgnoreCase(kdtOilEntry.getColumn(colIndex).getKey())) {
if (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtOilEntry.getCell(rowIndex,"price").getValue())> 0) 
{
    kdtOilEntry.getCell(rowIndex,"qty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtOilEntry.getCell(rowIndex,"amount").getValue())/ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtOilEntry.getCell(rowIndex,"price").getValue())));
}

}

    if ("amount".equalsIgnoreCase(kdtOilEntry.getColumn(colIndex).getKey())) {
if (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtOilEntry.getCell(rowIndex,"price").getValue())> 0) 
{
    kdtOilEntry.getCell(rowIndex,"qty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtOilEntry.getCell(rowIndex,"amount").getValue())/ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtOilEntry.getCell(rowIndex,"price").getValue())));
}

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
        sic.add(new SelectorItemInfo("BillStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("StorageOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("StorageOrgUnit.id"));
        	sic.add(new SelectorItemInfo("StorageOrgUnit.number"));
        	sic.add(new SelectorItemInfo("StorageOrgUnit.name"));
		}
        sic.add(new SelectorItemInfo("AuditTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("companyOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("companyOrgUnit.id"));
        	sic.add(new SelectorItemInfo("companyOrgUnit.number"));
        	sic.add(new SelectorItemInfo("companyOrgUnit.name"));
		}
    	sic.add(new SelectorItemInfo("Entry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.car.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entry.car.id"));
			sic.add(new SelectorItemInfo("Entry.car.number"));
			sic.add(new SelectorItemInfo("Entry.car.name"));
		}
    	sic.add(new SelectorItemInfo("Entry.count"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.DeliveryLine.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entry.DeliveryLine.id"));
			sic.add(new SelectorItemInfo("Entry.DeliveryLine.name"));
        	sic.add(new SelectorItemInfo("Entry.DeliveryLine.number"));
		}
    	sic.add(new SelectorItemInfo("Entry.beginStation"));
    	sic.add(new SelectorItemInfo("Entry.endStation"));
    	sic.add(new SelectorItemInfo("Entry.mileage"));
    	sic.add(new SelectorItemInfo("Entry.startMileage"));
    	sic.add(new SelectorItemInfo("Entry.endMileage"));
    	sic.add(new SelectorItemInfo("Entry.todayMileage"));
    	sic.add(new SelectorItemInfo("Entry.avgMileage"));
    	sic.add(new SelectorItemInfo("Entry.todayMPG"));
    	sic.add(new SelectorItemInfo("Entry.avgMPG"));
    	sic.add(new SelectorItemInfo("Entry.violationTimes"));
    	sic.add(new SelectorItemInfo("Entry.lateLong"));
    	sic.add(new SelectorItemInfo("OilEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("OilEntry.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("OilEntry.mileage"));
    	sic.add(new SelectorItemInfo("OilEntry.amount"));
    	sic.add(new SelectorItemInfo("OilEntry.qty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("OilEntry.car.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("OilEntry.car.id"));
			sic.add(new SelectorItemInfo("OilEntry.car.number"));
			sic.add(new SelectorItemInfo("OilEntry.car.name"));
		}
    	sic.add(new SelectorItemInfo("OilEntry.price"));
    	sic.add(new SelectorItemInfo("OilEntry.urea"));
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
        com.kingdee.eas.farm.food.TransportDailyFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.food.TransportDailyFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractTransportDailyEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractTransportDailyEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.food.client", "TransportDailyEditUI");
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
        return com.kingdee.eas.farm.food.client.TransportDailyEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.food.TransportDailyFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.food.TransportDailyInfo objectValue = new com.kingdee.eas.farm.food.TransportDailyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/food/TransportDaily";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.food.app.TransportDailyQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtStorageOrgUnit.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"库存组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompanyOrgUnit.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
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
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}