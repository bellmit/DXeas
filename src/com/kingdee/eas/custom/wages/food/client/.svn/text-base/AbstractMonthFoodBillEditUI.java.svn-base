/**
 * output package name
 */
package com.kingdee.eas.custom.wages.food.client;

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
public abstract class AbstractMonthFoodBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractMonthFoodBillEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperiod;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbegindate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contenddate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperiod;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkbegindate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkenddate;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton audit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton unaudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton Getperson;
    protected javax.swing.JToolBar.Separator newSeparator2;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton Wagecalcul;
    protected javax.swing.JToolBar.Separator newSeparator1;
    protected com.kingdee.eas.custom.wages.food.MonthFoodBillInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnaudit actionUnaudit = null;
    protected ActionGetPerson actionGetPerson = null;
    protected ActionWagecalculation actionWagecalculation = null;
    /**
     * output class constructor
     */
    public AbstractMonthFoodBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractMonthFoodBillEditUI.class.getName());
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
        //actionUnaudit
        this.actionUnaudit = new ActionUnaudit(this);
        getActionManager().registerAction("actionUnaudit", actionUnaudit);
        this.actionUnaudit.setExtendProperty("canForewarn", "true");
        this.actionUnaudit.setExtendProperty("userDefined", "true");
        this.actionUnaudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnaudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnaudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionGetPerson
        this.actionGetPerson = new ActionGetPerson(this);
        getActionManager().registerAction("actionGetPerson", actionGetPerson);
        this.actionGetPerson.setExtendProperty("canForewarn", "true");
        this.actionGetPerson.setExtendProperty("userDefined", "true");
        this.actionGetPerson.setExtendProperty("isObjectUpdateLock", "false");
         this.actionGetPerson.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionGetPerson.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionWagecalculation
        this.actionWagecalculation = new ActionWagecalculation(this);
        getActionManager().registerAction("actionWagecalculation", actionWagecalculation);
        this.actionWagecalculation.setExtendProperty("canForewarn", "true");
        this.actionWagecalculation.setExtendProperty("userDefined", "true");
        this.actionWagecalculation.setExtendProperty("isObjectUpdateLock", "false");
         this.actionWagecalculation.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionWagecalculation.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperiod = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbegindate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contenddate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtperiod = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkbegindate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkenddate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.audit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.unaudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.Getperson = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.newSeparator2 = new javax.swing.JToolBar.Separator();
        this.Wagecalcul = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.newSeparator1 = new javax.swing.JToolBar.Separator();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.kdtEntrys.setName("kdtEntrys");
        this.contbillStatus.setName("contbillStatus");
        this.contperiod.setName("contperiod");
        this.contbegindate.setName("contbegindate");
        this.contenddate.setName("contenddate");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.billStatus.setName("billStatus");
        this.prmtperiod.setName("prmtperiod");
        this.pkbegindate.setName("pkbegindate");
        this.pkenddate.setName("pkenddate");
        this.audit.setName("audit");
        this.unaudit.setName("unaudit");
        this.Getperson.setName("Getperson");
        this.newSeparator2.setName("newSeparator2");
        this.Wagecalcul.setName("Wagecalcul");
        this.newSeparator1.setName("newSeparator1");
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
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol16\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol17\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol18\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol19\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol20\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol21\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol22\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol23\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol24\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol25\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol26\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol27\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol28\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol29\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol30\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol31\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol32\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol34\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol35\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol36\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol37\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol38\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol39\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol42\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol43\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol44\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol45\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol46\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"person\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"post\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"fromgroup\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"banknumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"Accountopening\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"personnumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"timeofentry\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"attendanceday\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"actualattenday\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"basicwages\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"basicattendance\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"PostSalary\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"Postattendance\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"subsidywages\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"StandardAward\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"checkworkwages\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /><t:Column t:key=\"byjfkh\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"fullworkwages\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"fullwages\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol19\" /><t:Column t:key=\"leaveday\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol20\" /><t:Column t:key=\"absenteeismday\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol21\" /><t:Column t:key=\"jjrbz\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol22\" /><t:Column t:key=\"Awards\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol23\" /><t:Column t:key=\"qualitydebit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol24\" /><t:Column t:key=\"notificationwages\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol25\" /><t:Column t:key=\"jgzbx\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol26\" /><t:Column t:key=\"overtimeD\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol27\" /><t:Column t:key=\"overdayamount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol28\" /><t:Column t:key=\"Attendanceratio\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol29\" /><t:Column t:key=\"overday\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol30\" /><t:Column t:key=\"repairmonth\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol31\" /><t:Column t:key=\"adjustAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol32\" /><t:Column t:key=\"adjustRemarks\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"wagespay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol34\" /><t:Column t:key=\"socialsecurity\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol35\" /><t:Column t:key=\"taxableincome\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol36\" /><t:Column t:key=\"persontax\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol37\" /><t:Column t:key=\"recruitwages\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol38\" /><t:Column t:key=\"Payroll\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol39\" /><t:Column t:key=\"Commute\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"nightwork\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"Deductedloss\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol42\" /><t:Column t:key=\"Accidentinsurance\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol43\" /><t:Column t:key=\"deAccident\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol44\" /><t:Column t:key=\"bhjkzsf\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol45\" /><t:Column t:key=\"newEntry\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol46\" /><t:Column t:key=\"isSpeedfrom\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"Remarks\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{person}</t:Cell><t:Cell>$Resource{post}</t:Cell><t:Cell>$Resource{fromgroup}</t:Cell><t:Cell>$Resource{banknumber}</t:Cell><t:Cell>$Resource{Accountopening}</t:Cell><t:Cell>$Resource{personnumber}</t:Cell><t:Cell>$Resource{timeofentry}</t:Cell><t:Cell>$Resource{attendanceday}</t:Cell><t:Cell>$Resource{actualattenday}</t:Cell><t:Cell>$Resource{basicwages}</t:Cell><t:Cell>$Resource{basicattendance}</t:Cell><t:Cell>$Resource{PostSalary}</t:Cell><t:Cell>$Resource{Postattendance}</t:Cell><t:Cell>$Resource{subsidywages}</t:Cell><t:Cell>$Resource{StandardAward}</t:Cell><t:Cell>$Resource{checkworkwages}</t:Cell><t:Cell>$Resource{byjfkh}</t:Cell><t:Cell>$Resource{fullworkwages}</t:Cell><t:Cell>$Resource{fullwages}</t:Cell><t:Cell>$Resource{leaveday}</t:Cell><t:Cell>$Resource{absenteeismday}</t:Cell><t:Cell>$Resource{jjrbz}</t:Cell><t:Cell>$Resource{Awards}</t:Cell><t:Cell>$Resource{qualitydebit}</t:Cell><t:Cell>$Resource{notificationwages}</t:Cell><t:Cell>$Resource{jgzbx}</t:Cell><t:Cell>$Resource{overtimeD}</t:Cell><t:Cell>$Resource{overdayamount}</t:Cell><t:Cell>$Resource{Attendanceratio}</t:Cell><t:Cell>$Resource{overday}</t:Cell><t:Cell>$Resource{repairmonth}</t:Cell><t:Cell>$Resource{adjustAmount}</t:Cell><t:Cell>$Resource{adjustRemarks}</t:Cell><t:Cell>$Resource{wagespay}</t:Cell><t:Cell>$Resource{socialsecurity}</t:Cell><t:Cell>$Resource{taxableincome}</t:Cell><t:Cell>$Resource{persontax}</t:Cell><t:Cell>$Resource{recruitwages}</t:Cell><t:Cell>$Resource{Payroll}</t:Cell><t:Cell>$Resource{Commute}</t:Cell><t:Cell>$Resource{nightwork}</t:Cell><t:Cell>$Resource{Deductedloss}</t:Cell><t:Cell>$Resource{Accidentinsurance}</t:Cell><t:Cell>$Resource{deAccident}</t:Cell><t:Cell>$Resource{bhjkzsf}</t:Cell><t:Cell>$Resource{newEntry}</t:Cell><t:Cell>$Resource{isSpeedfrom}</t:Cell><t:Cell>$Resource{Remarks}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));

                this.kdtEntrys.putBindContents("editData",new String[] {"id","person","post","fromgroup","banknumber","Accountopening","personnumber","timeofentry","attendanceday","actualattenday","basicwages","basicattendance","PostSalary","Postattendance","subsidywages","StandardAward","checkworkwages","byjfkh","fullworkwages","fullwages","leaveday","absenteeismday","jjrbz","Awards","qualitydebit","notificationwages","jgzbx","overtimeD","overdayamount","Attendanceratio","overday","repairmonth","adjustAmount","adjustRemarks","wagespay","socialsecurity","taxableincome","persontax","recruitwages","Payroll","Commute","nightwork","Deductedloss","Accidentinsurance","deAccident","bhjkzsf","newEntry","isSpeedfrom","Remarks"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_person_PromptBox = new KDBizPromptBox();
        kdtEntrys_person_PromptBox.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");
        kdtEntrys_person_PromptBox.setVisible(true);
        kdtEntrys_person_PromptBox.setEditable(true);
        kdtEntrys_person_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_person_PromptBox.setEditFormat("$number$");
        kdtEntrys_person_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_person_CellEditor = new KDTDefaultCellEditor(kdtEntrys_person_PromptBox);
        this.kdtEntrys.getColumn("person").setEditor(kdtEntrys_person_CellEditor);
        ObjectValueRender kdtEntrys_person_OVR = new ObjectValueRender();
        kdtEntrys_person_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("person").setRenderer(kdtEntrys_person_OVR);
        final KDBizPromptBox kdtEntrys_post_PromptBox = new KDBizPromptBox();
        kdtEntrys_post_PromptBox.setQueryInfo("com.kingdee.eas.custom.wages.food.app.BasicPostFoodQuery");
        kdtEntrys_post_PromptBox.setVisible(true);
        kdtEntrys_post_PromptBox.setEditable(true);
        kdtEntrys_post_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_post_PromptBox.setEditFormat("$number$");
        kdtEntrys_post_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_post_CellEditor = new KDTDefaultCellEditor(kdtEntrys_post_PromptBox);
        this.kdtEntrys.getColumn("post").setEditor(kdtEntrys_post_CellEditor);
        ObjectValueRender kdtEntrys_post_OVR = new ObjectValueRender();
        kdtEntrys_post_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("post").setRenderer(kdtEntrys_post_OVR);
        final KDBizPromptBox kdtEntrys_fromgroup_PromptBox = new KDBizPromptBox();
        kdtEntrys_fromgroup_PromptBox.setQueryInfo("com.kingdee.eas.custom.wages.food.app.WageFoodOrganQuery");
        kdtEntrys_fromgroup_PromptBox.setVisible(true);
        kdtEntrys_fromgroup_PromptBox.setEditable(true);
        kdtEntrys_fromgroup_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_fromgroup_PromptBox.setEditFormat("$number$");
        kdtEntrys_fromgroup_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_fromgroup_CellEditor = new KDTDefaultCellEditor(kdtEntrys_fromgroup_PromptBox);
        this.kdtEntrys.getColumn("fromgroup").setEditor(kdtEntrys_fromgroup_CellEditor);
        ObjectValueRender kdtEntrys_fromgroup_OVR = new ObjectValueRender();
        kdtEntrys_fromgroup_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("fromgroup").setRenderer(kdtEntrys_fromgroup_OVR);
        			kdtEntrys_fromgroup_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.custom.wages.food.client.WageFoodOrganListUI kdtEntrys_fromgroup_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_fromgroup_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_fromgroup_PromptBox_F7ListUI = new com.kingdee.eas.custom.wages.food.client.WageFoodOrganListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_fromgroup_PromptBox_F7ListUI));
					kdtEntrys_fromgroup_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_fromgroup_PromptBox.setSelector(kdtEntrys_fromgroup_PromptBox_F7ListUI);
				}
			}
		});
					
        KDTextField kdtEntrys_banknumber_TextField = new KDTextField();
        kdtEntrys_banknumber_TextField.setName("kdtEntrys_banknumber_TextField");
        kdtEntrys_banknumber_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_banknumber_CellEditor = new KDTDefaultCellEditor(kdtEntrys_banknumber_TextField);
        this.kdtEntrys.getColumn("banknumber").setEditor(kdtEntrys_banknumber_CellEditor);
        KDTextField kdtEntrys_Accountopening_TextField = new KDTextField();
        kdtEntrys_Accountopening_TextField.setName("kdtEntrys_Accountopening_TextField");
        kdtEntrys_Accountopening_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_Accountopening_CellEditor = new KDTDefaultCellEditor(kdtEntrys_Accountopening_TextField);
        this.kdtEntrys.getColumn("Accountopening").setEditor(kdtEntrys_Accountopening_CellEditor);
        KDTextField kdtEntrys_personnumber_TextField = new KDTextField();
        kdtEntrys_personnumber_TextField.setName("kdtEntrys_personnumber_TextField");
        kdtEntrys_personnumber_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_personnumber_CellEditor = new KDTDefaultCellEditor(kdtEntrys_personnumber_TextField);
        this.kdtEntrys.getColumn("personnumber").setEditor(kdtEntrys_personnumber_CellEditor);
        KDDatePicker kdtEntrys_timeofentry_DatePicker = new KDDatePicker();
        kdtEntrys_timeofentry_DatePicker.setName("kdtEntrys_timeofentry_DatePicker");
        kdtEntrys_timeofentry_DatePicker.setVisible(true);
        kdtEntrys_timeofentry_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_timeofentry_CellEditor = new KDTDefaultCellEditor(kdtEntrys_timeofentry_DatePicker);
        this.kdtEntrys.getColumn("timeofentry").setEditor(kdtEntrys_timeofentry_CellEditor);
        KDFormattedTextField kdtEntrys_attendanceday_TextField = new KDFormattedTextField();
        kdtEntrys_attendanceday_TextField.setName("kdtEntrys_attendanceday_TextField");
        kdtEntrys_attendanceday_TextField.setVisible(true);
        kdtEntrys_attendanceday_TextField.setEditable(true);
        kdtEntrys_attendanceday_TextField.setHorizontalAlignment(2);
        kdtEntrys_attendanceday_TextField.setDataType(1);
        	kdtEntrys_attendanceday_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_attendanceday_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_attendanceday_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_attendanceday_CellEditor = new KDTDefaultCellEditor(kdtEntrys_attendanceday_TextField);
        this.kdtEntrys.getColumn("attendanceday").setEditor(kdtEntrys_attendanceday_CellEditor);
        KDFormattedTextField kdtEntrys_actualattenday_TextField = new KDFormattedTextField();
        kdtEntrys_actualattenday_TextField.setName("kdtEntrys_actualattenday_TextField");
        kdtEntrys_actualattenday_TextField.setVisible(true);
        kdtEntrys_actualattenday_TextField.setEditable(true);
        kdtEntrys_actualattenday_TextField.setHorizontalAlignment(2);
        kdtEntrys_actualattenday_TextField.setDataType(1);
        	kdtEntrys_actualattenday_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_actualattenday_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_actualattenday_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_actualattenday_CellEditor = new KDTDefaultCellEditor(kdtEntrys_actualattenday_TextField);
        this.kdtEntrys.getColumn("actualattenday").setEditor(kdtEntrys_actualattenday_CellEditor);
        KDFormattedTextField kdtEntrys_basicwages_TextField = new KDFormattedTextField();
        kdtEntrys_basicwages_TextField.setName("kdtEntrys_basicwages_TextField");
        kdtEntrys_basicwages_TextField.setVisible(true);
        kdtEntrys_basicwages_TextField.setEditable(true);
        kdtEntrys_basicwages_TextField.setHorizontalAlignment(2);
        kdtEntrys_basicwages_TextField.setDataType(1);
        	kdtEntrys_basicwages_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_basicwages_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_basicwages_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_basicwages_CellEditor = new KDTDefaultCellEditor(kdtEntrys_basicwages_TextField);
        this.kdtEntrys.getColumn("basicwages").setEditor(kdtEntrys_basicwages_CellEditor);
        KDFormattedTextField kdtEntrys_basicattendance_TextField = new KDFormattedTextField();
        kdtEntrys_basicattendance_TextField.setName("kdtEntrys_basicattendance_TextField");
        kdtEntrys_basicattendance_TextField.setVisible(true);
        kdtEntrys_basicattendance_TextField.setEditable(true);
        kdtEntrys_basicattendance_TextField.setHorizontalAlignment(2);
        kdtEntrys_basicattendance_TextField.setDataType(1);
        	kdtEntrys_basicattendance_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_basicattendance_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_basicattendance_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_basicattendance_CellEditor = new KDTDefaultCellEditor(kdtEntrys_basicattendance_TextField);
        this.kdtEntrys.getColumn("basicattendance").setEditor(kdtEntrys_basicattendance_CellEditor);
        KDFormattedTextField kdtEntrys_PostSalary_TextField = new KDFormattedTextField();
        kdtEntrys_PostSalary_TextField.setName("kdtEntrys_PostSalary_TextField");
        kdtEntrys_PostSalary_TextField.setVisible(true);
        kdtEntrys_PostSalary_TextField.setEditable(true);
        kdtEntrys_PostSalary_TextField.setHorizontalAlignment(2);
        kdtEntrys_PostSalary_TextField.setDataType(1);
        	kdtEntrys_PostSalary_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_PostSalary_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_PostSalary_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_PostSalary_CellEditor = new KDTDefaultCellEditor(kdtEntrys_PostSalary_TextField);
        this.kdtEntrys.getColumn("PostSalary").setEditor(kdtEntrys_PostSalary_CellEditor);
        KDFormattedTextField kdtEntrys_Postattendance_TextField = new KDFormattedTextField();
        kdtEntrys_Postattendance_TextField.setName("kdtEntrys_Postattendance_TextField");
        kdtEntrys_Postattendance_TextField.setVisible(true);
        kdtEntrys_Postattendance_TextField.setEditable(true);
        kdtEntrys_Postattendance_TextField.setHorizontalAlignment(2);
        kdtEntrys_Postattendance_TextField.setDataType(1);
        	kdtEntrys_Postattendance_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_Postattendance_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_Postattendance_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_Postattendance_CellEditor = new KDTDefaultCellEditor(kdtEntrys_Postattendance_TextField);
        this.kdtEntrys.getColumn("Postattendance").setEditor(kdtEntrys_Postattendance_CellEditor);
        KDFormattedTextField kdtEntrys_subsidywages_TextField = new KDFormattedTextField();
        kdtEntrys_subsidywages_TextField.setName("kdtEntrys_subsidywages_TextField");
        kdtEntrys_subsidywages_TextField.setVisible(true);
        kdtEntrys_subsidywages_TextField.setEditable(true);
        kdtEntrys_subsidywages_TextField.setHorizontalAlignment(2);
        kdtEntrys_subsidywages_TextField.setDataType(1);
        	kdtEntrys_subsidywages_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_subsidywages_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_subsidywages_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_subsidywages_CellEditor = new KDTDefaultCellEditor(kdtEntrys_subsidywages_TextField);
        this.kdtEntrys.getColumn("subsidywages").setEditor(kdtEntrys_subsidywages_CellEditor);
        KDFormattedTextField kdtEntrys_StandardAward_TextField = new KDFormattedTextField();
        kdtEntrys_StandardAward_TextField.setName("kdtEntrys_StandardAward_TextField");
        kdtEntrys_StandardAward_TextField.setVisible(true);
        kdtEntrys_StandardAward_TextField.setEditable(true);
        kdtEntrys_StandardAward_TextField.setHorizontalAlignment(2);
        kdtEntrys_StandardAward_TextField.setDataType(1);
        	kdtEntrys_StandardAward_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_StandardAward_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_StandardAward_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_StandardAward_CellEditor = new KDTDefaultCellEditor(kdtEntrys_StandardAward_TextField);
        this.kdtEntrys.getColumn("StandardAward").setEditor(kdtEntrys_StandardAward_CellEditor);
        KDFormattedTextField kdtEntrys_checkworkwages_TextField = new KDFormattedTextField();
        kdtEntrys_checkworkwages_TextField.setName("kdtEntrys_checkworkwages_TextField");
        kdtEntrys_checkworkwages_TextField.setVisible(true);
        kdtEntrys_checkworkwages_TextField.setEditable(true);
        kdtEntrys_checkworkwages_TextField.setHorizontalAlignment(2);
        kdtEntrys_checkworkwages_TextField.setDataType(1);
        	kdtEntrys_checkworkwages_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_checkworkwages_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_checkworkwages_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_checkworkwages_CellEditor = new KDTDefaultCellEditor(kdtEntrys_checkworkwages_TextField);
        this.kdtEntrys.getColumn("checkworkwages").setEditor(kdtEntrys_checkworkwages_CellEditor);
        KDFormattedTextField kdtEntrys_byjfkh_TextField = new KDFormattedTextField();
        kdtEntrys_byjfkh_TextField.setName("kdtEntrys_byjfkh_TextField");
        kdtEntrys_byjfkh_TextField.setVisible(true);
        kdtEntrys_byjfkh_TextField.setEditable(true);
        kdtEntrys_byjfkh_TextField.setHorizontalAlignment(2);
        kdtEntrys_byjfkh_TextField.setDataType(1);
        	kdtEntrys_byjfkh_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_byjfkh_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_byjfkh_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_byjfkh_CellEditor = new KDTDefaultCellEditor(kdtEntrys_byjfkh_TextField);
        this.kdtEntrys.getColumn("byjfkh").setEditor(kdtEntrys_byjfkh_CellEditor);
        KDFormattedTextField kdtEntrys_fullworkwages_TextField = new KDFormattedTextField();
        kdtEntrys_fullworkwages_TextField.setName("kdtEntrys_fullworkwages_TextField");
        kdtEntrys_fullworkwages_TextField.setVisible(true);
        kdtEntrys_fullworkwages_TextField.setEditable(true);
        kdtEntrys_fullworkwages_TextField.setHorizontalAlignment(2);
        kdtEntrys_fullworkwages_TextField.setDataType(1);
        	kdtEntrys_fullworkwages_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_fullworkwages_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_fullworkwages_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_fullworkwages_CellEditor = new KDTDefaultCellEditor(kdtEntrys_fullworkwages_TextField);
        this.kdtEntrys.getColumn("fullworkwages").setEditor(kdtEntrys_fullworkwages_CellEditor);
        KDFormattedTextField kdtEntrys_fullwages_TextField = new KDFormattedTextField();
        kdtEntrys_fullwages_TextField.setName("kdtEntrys_fullwages_TextField");
        kdtEntrys_fullwages_TextField.setVisible(true);
        kdtEntrys_fullwages_TextField.setEditable(true);
        kdtEntrys_fullwages_TextField.setHorizontalAlignment(2);
        kdtEntrys_fullwages_TextField.setDataType(1);
        	kdtEntrys_fullwages_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_fullwages_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_fullwages_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_fullwages_CellEditor = new KDTDefaultCellEditor(kdtEntrys_fullwages_TextField);
        this.kdtEntrys.getColumn("fullwages").setEditor(kdtEntrys_fullwages_CellEditor);
        KDFormattedTextField kdtEntrys_leaveday_TextField = new KDFormattedTextField();
        kdtEntrys_leaveday_TextField.setName("kdtEntrys_leaveday_TextField");
        kdtEntrys_leaveday_TextField.setVisible(true);
        kdtEntrys_leaveday_TextField.setEditable(true);
        kdtEntrys_leaveday_TextField.setHorizontalAlignment(2);
        kdtEntrys_leaveday_TextField.setDataType(1);
        	kdtEntrys_leaveday_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_leaveday_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_leaveday_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_leaveday_CellEditor = new KDTDefaultCellEditor(kdtEntrys_leaveday_TextField);
        this.kdtEntrys.getColumn("leaveday").setEditor(kdtEntrys_leaveday_CellEditor);
        KDFormattedTextField kdtEntrys_absenteeismday_TextField = new KDFormattedTextField();
        kdtEntrys_absenteeismday_TextField.setName("kdtEntrys_absenteeismday_TextField");
        kdtEntrys_absenteeismday_TextField.setVisible(true);
        kdtEntrys_absenteeismday_TextField.setEditable(true);
        kdtEntrys_absenteeismday_TextField.setHorizontalAlignment(2);
        kdtEntrys_absenteeismday_TextField.setDataType(1);
        	kdtEntrys_absenteeismday_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_absenteeismday_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_absenteeismday_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_absenteeismday_CellEditor = new KDTDefaultCellEditor(kdtEntrys_absenteeismday_TextField);
        this.kdtEntrys.getColumn("absenteeismday").setEditor(kdtEntrys_absenteeismday_CellEditor);
        KDFormattedTextField kdtEntrys_jjrbz_TextField = new KDFormattedTextField();
        kdtEntrys_jjrbz_TextField.setName("kdtEntrys_jjrbz_TextField");
        kdtEntrys_jjrbz_TextField.setVisible(true);
        kdtEntrys_jjrbz_TextField.setEditable(true);
        kdtEntrys_jjrbz_TextField.setHorizontalAlignment(2);
        kdtEntrys_jjrbz_TextField.setDataType(1);
        	kdtEntrys_jjrbz_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_jjrbz_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_jjrbz_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_jjrbz_CellEditor = new KDTDefaultCellEditor(kdtEntrys_jjrbz_TextField);
        this.kdtEntrys.getColumn("jjrbz").setEditor(kdtEntrys_jjrbz_CellEditor);
        KDFormattedTextField kdtEntrys_Awards_TextField = new KDFormattedTextField();
        kdtEntrys_Awards_TextField.setName("kdtEntrys_Awards_TextField");
        kdtEntrys_Awards_TextField.setVisible(true);
        kdtEntrys_Awards_TextField.setEditable(true);
        kdtEntrys_Awards_TextField.setHorizontalAlignment(2);
        kdtEntrys_Awards_TextField.setDataType(1);
        	kdtEntrys_Awards_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_Awards_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_Awards_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_Awards_CellEditor = new KDTDefaultCellEditor(kdtEntrys_Awards_TextField);
        this.kdtEntrys.getColumn("Awards").setEditor(kdtEntrys_Awards_CellEditor);
        KDFormattedTextField kdtEntrys_qualitydebit_TextField = new KDFormattedTextField();
        kdtEntrys_qualitydebit_TextField.setName("kdtEntrys_qualitydebit_TextField");
        kdtEntrys_qualitydebit_TextField.setVisible(true);
        kdtEntrys_qualitydebit_TextField.setEditable(true);
        kdtEntrys_qualitydebit_TextField.setHorizontalAlignment(2);
        kdtEntrys_qualitydebit_TextField.setDataType(1);
        	kdtEntrys_qualitydebit_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_qualitydebit_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_qualitydebit_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_qualitydebit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qualitydebit_TextField);
        this.kdtEntrys.getColumn("qualitydebit").setEditor(kdtEntrys_qualitydebit_CellEditor);
        KDFormattedTextField kdtEntrys_notificationwages_TextField = new KDFormattedTextField();
        kdtEntrys_notificationwages_TextField.setName("kdtEntrys_notificationwages_TextField");
        kdtEntrys_notificationwages_TextField.setVisible(true);
        kdtEntrys_notificationwages_TextField.setEditable(true);
        kdtEntrys_notificationwages_TextField.setHorizontalAlignment(2);
        kdtEntrys_notificationwages_TextField.setDataType(1);
        	kdtEntrys_notificationwages_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_notificationwages_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_notificationwages_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_notificationwages_CellEditor = new KDTDefaultCellEditor(kdtEntrys_notificationwages_TextField);
        this.kdtEntrys.getColumn("notificationwages").setEditor(kdtEntrys_notificationwages_CellEditor);
        KDFormattedTextField kdtEntrys_jgzbx_TextField = new KDFormattedTextField();
        kdtEntrys_jgzbx_TextField.setName("kdtEntrys_jgzbx_TextField");
        kdtEntrys_jgzbx_TextField.setVisible(true);
        kdtEntrys_jgzbx_TextField.setEditable(true);
        kdtEntrys_jgzbx_TextField.setHorizontalAlignment(2);
        kdtEntrys_jgzbx_TextField.setDataType(1);
        	kdtEntrys_jgzbx_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_jgzbx_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_jgzbx_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_jgzbx_CellEditor = new KDTDefaultCellEditor(kdtEntrys_jgzbx_TextField);
        this.kdtEntrys.getColumn("jgzbx").setEditor(kdtEntrys_jgzbx_CellEditor);
        KDFormattedTextField kdtEntrys_overtimeD_TextField = new KDFormattedTextField();
        kdtEntrys_overtimeD_TextField.setName("kdtEntrys_overtimeD_TextField");
        kdtEntrys_overtimeD_TextField.setVisible(true);
        kdtEntrys_overtimeD_TextField.setEditable(true);
        kdtEntrys_overtimeD_TextField.setHorizontalAlignment(2);
        kdtEntrys_overtimeD_TextField.setDataType(1);
        	kdtEntrys_overtimeD_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_overtimeD_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_overtimeD_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_overtimeD_CellEditor = new KDTDefaultCellEditor(kdtEntrys_overtimeD_TextField);
        this.kdtEntrys.getColumn("overtimeD").setEditor(kdtEntrys_overtimeD_CellEditor);
        KDFormattedTextField kdtEntrys_overdayamount_TextField = new KDFormattedTextField();
        kdtEntrys_overdayamount_TextField.setName("kdtEntrys_overdayamount_TextField");
        kdtEntrys_overdayamount_TextField.setVisible(true);
        kdtEntrys_overdayamount_TextField.setEditable(true);
        kdtEntrys_overdayamount_TextField.setHorizontalAlignment(2);
        kdtEntrys_overdayamount_TextField.setDataType(1);
        	kdtEntrys_overdayamount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_overdayamount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_overdayamount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_overdayamount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_overdayamount_TextField);
        this.kdtEntrys.getColumn("overdayamount").setEditor(kdtEntrys_overdayamount_CellEditor);
        KDFormattedTextField kdtEntrys_Attendanceratio_TextField = new KDFormattedTextField();
        kdtEntrys_Attendanceratio_TextField.setName("kdtEntrys_Attendanceratio_TextField");
        kdtEntrys_Attendanceratio_TextField.setVisible(true);
        kdtEntrys_Attendanceratio_TextField.setEditable(true);
        kdtEntrys_Attendanceratio_TextField.setHorizontalAlignment(2);
        kdtEntrys_Attendanceratio_TextField.setDataType(1);
        	kdtEntrys_Attendanceratio_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_Attendanceratio_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_Attendanceratio_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_Attendanceratio_CellEditor = new KDTDefaultCellEditor(kdtEntrys_Attendanceratio_TextField);
        this.kdtEntrys.getColumn("Attendanceratio").setEditor(kdtEntrys_Attendanceratio_CellEditor);
        KDFormattedTextField kdtEntrys_overday_TextField = new KDFormattedTextField();
        kdtEntrys_overday_TextField.setName("kdtEntrys_overday_TextField");
        kdtEntrys_overday_TextField.setVisible(true);
        kdtEntrys_overday_TextField.setEditable(true);
        kdtEntrys_overday_TextField.setHorizontalAlignment(2);
        kdtEntrys_overday_TextField.setDataType(1);
        	kdtEntrys_overday_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_overday_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_overday_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_overday_CellEditor = new KDTDefaultCellEditor(kdtEntrys_overday_TextField);
        this.kdtEntrys.getColumn("overday").setEditor(kdtEntrys_overday_CellEditor);
        KDFormattedTextField kdtEntrys_repairmonth_TextField = new KDFormattedTextField();
        kdtEntrys_repairmonth_TextField.setName("kdtEntrys_repairmonth_TextField");
        kdtEntrys_repairmonth_TextField.setVisible(true);
        kdtEntrys_repairmonth_TextField.setEditable(true);
        kdtEntrys_repairmonth_TextField.setHorizontalAlignment(2);
        kdtEntrys_repairmonth_TextField.setDataType(1);
        	kdtEntrys_repairmonth_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_repairmonth_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_repairmonth_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_repairmonth_CellEditor = new KDTDefaultCellEditor(kdtEntrys_repairmonth_TextField);
        this.kdtEntrys.getColumn("repairmonth").setEditor(kdtEntrys_repairmonth_CellEditor);
        KDFormattedTextField kdtEntrys_adjustAmount_TextField = new KDFormattedTextField();
        kdtEntrys_adjustAmount_TextField.setName("kdtEntrys_adjustAmount_TextField");
        kdtEntrys_adjustAmount_TextField.setVisible(true);
        kdtEntrys_adjustAmount_TextField.setEditable(true);
        kdtEntrys_adjustAmount_TextField.setHorizontalAlignment(2);
        kdtEntrys_adjustAmount_TextField.setDataType(1);
        	kdtEntrys_adjustAmount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_adjustAmount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_adjustAmount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_adjustAmount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_adjustAmount_TextField);
        this.kdtEntrys.getColumn("adjustAmount").setEditor(kdtEntrys_adjustAmount_CellEditor);
        KDTextArea kdtEntrys_adjustRemarks_TextArea = new KDTextArea();
        kdtEntrys_adjustRemarks_TextArea.setName("kdtEntrys_adjustRemarks_TextArea");
        kdtEntrys_adjustRemarks_TextArea.setMaxLength(255);
        KDTDefaultCellEditor kdtEntrys_adjustRemarks_CellEditor = new KDTDefaultCellEditor(kdtEntrys_adjustRemarks_TextArea);
        this.kdtEntrys.getColumn("adjustRemarks").setEditor(kdtEntrys_adjustRemarks_CellEditor);
        KDFormattedTextField kdtEntrys_wagespay_TextField = new KDFormattedTextField();
        kdtEntrys_wagespay_TextField.setName("kdtEntrys_wagespay_TextField");
        kdtEntrys_wagespay_TextField.setVisible(true);
        kdtEntrys_wagespay_TextField.setEditable(true);
        kdtEntrys_wagespay_TextField.setHorizontalAlignment(2);
        kdtEntrys_wagespay_TextField.setDataType(1);
        	kdtEntrys_wagespay_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_wagespay_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_wagespay_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_wagespay_CellEditor = new KDTDefaultCellEditor(kdtEntrys_wagespay_TextField);
        this.kdtEntrys.getColumn("wagespay").setEditor(kdtEntrys_wagespay_CellEditor);
        KDFormattedTextField kdtEntrys_socialsecurity_TextField = new KDFormattedTextField();
        kdtEntrys_socialsecurity_TextField.setName("kdtEntrys_socialsecurity_TextField");
        kdtEntrys_socialsecurity_TextField.setVisible(true);
        kdtEntrys_socialsecurity_TextField.setEditable(true);
        kdtEntrys_socialsecurity_TextField.setHorizontalAlignment(2);
        kdtEntrys_socialsecurity_TextField.setDataType(1);
        	kdtEntrys_socialsecurity_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_socialsecurity_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_socialsecurity_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_socialsecurity_CellEditor = new KDTDefaultCellEditor(kdtEntrys_socialsecurity_TextField);
        this.kdtEntrys.getColumn("socialsecurity").setEditor(kdtEntrys_socialsecurity_CellEditor);
        KDFormattedTextField kdtEntrys_taxableincome_TextField = new KDFormattedTextField();
        kdtEntrys_taxableincome_TextField.setName("kdtEntrys_taxableincome_TextField");
        kdtEntrys_taxableincome_TextField.setVisible(true);
        kdtEntrys_taxableincome_TextField.setEditable(true);
        kdtEntrys_taxableincome_TextField.setHorizontalAlignment(2);
        kdtEntrys_taxableincome_TextField.setDataType(1);
        	kdtEntrys_taxableincome_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_taxableincome_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_taxableincome_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_taxableincome_CellEditor = new KDTDefaultCellEditor(kdtEntrys_taxableincome_TextField);
        this.kdtEntrys.getColumn("taxableincome").setEditor(kdtEntrys_taxableincome_CellEditor);
        KDFormattedTextField kdtEntrys_persontax_TextField = new KDFormattedTextField();
        kdtEntrys_persontax_TextField.setName("kdtEntrys_persontax_TextField");
        kdtEntrys_persontax_TextField.setVisible(true);
        kdtEntrys_persontax_TextField.setEditable(true);
        kdtEntrys_persontax_TextField.setHorizontalAlignment(2);
        kdtEntrys_persontax_TextField.setDataType(1);
        	kdtEntrys_persontax_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_persontax_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_persontax_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_persontax_CellEditor = new KDTDefaultCellEditor(kdtEntrys_persontax_TextField);
        this.kdtEntrys.getColumn("persontax").setEditor(kdtEntrys_persontax_CellEditor);
        KDFormattedTextField kdtEntrys_recruitwages_TextField = new KDFormattedTextField();
        kdtEntrys_recruitwages_TextField.setName("kdtEntrys_recruitwages_TextField");
        kdtEntrys_recruitwages_TextField.setVisible(true);
        kdtEntrys_recruitwages_TextField.setEditable(true);
        kdtEntrys_recruitwages_TextField.setHorizontalAlignment(2);
        kdtEntrys_recruitwages_TextField.setDataType(1);
        	kdtEntrys_recruitwages_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_recruitwages_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_recruitwages_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_recruitwages_CellEditor = new KDTDefaultCellEditor(kdtEntrys_recruitwages_TextField);
        this.kdtEntrys.getColumn("recruitwages").setEditor(kdtEntrys_recruitwages_CellEditor);
        KDFormattedTextField kdtEntrys_Payroll_TextField = new KDFormattedTextField();
        kdtEntrys_Payroll_TextField.setName("kdtEntrys_Payroll_TextField");
        kdtEntrys_Payroll_TextField.setVisible(true);
        kdtEntrys_Payroll_TextField.setEditable(true);
        kdtEntrys_Payroll_TextField.setHorizontalAlignment(2);
        kdtEntrys_Payroll_TextField.setDataType(1);
        	kdtEntrys_Payroll_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_Payroll_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_Payroll_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_Payroll_CellEditor = new KDTDefaultCellEditor(kdtEntrys_Payroll_TextField);
        this.kdtEntrys.getColumn("Payroll").setEditor(kdtEntrys_Payroll_CellEditor);
        KDCheckBox kdtEntrys_Commute_CheckBox = new KDCheckBox();
        kdtEntrys_Commute_CheckBox.setName("kdtEntrys_Commute_CheckBox");
        KDTDefaultCellEditor kdtEntrys_Commute_CellEditor = new KDTDefaultCellEditor(kdtEntrys_Commute_CheckBox);
        this.kdtEntrys.getColumn("Commute").setEditor(kdtEntrys_Commute_CellEditor);
        KDCheckBox kdtEntrys_nightwork_CheckBox = new KDCheckBox();
        kdtEntrys_nightwork_CheckBox.setName("kdtEntrys_nightwork_CheckBox");
        KDTDefaultCellEditor kdtEntrys_nightwork_CellEditor = new KDTDefaultCellEditor(kdtEntrys_nightwork_CheckBox);
        this.kdtEntrys.getColumn("nightwork").setEditor(kdtEntrys_nightwork_CellEditor);
        KDFormattedTextField kdtEntrys_Deductedloss_TextField = new KDFormattedTextField();
        kdtEntrys_Deductedloss_TextField.setName("kdtEntrys_Deductedloss_TextField");
        kdtEntrys_Deductedloss_TextField.setVisible(true);
        kdtEntrys_Deductedloss_TextField.setEditable(true);
        kdtEntrys_Deductedloss_TextField.setHorizontalAlignment(2);
        kdtEntrys_Deductedloss_TextField.setDataType(1);
        	kdtEntrys_Deductedloss_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_Deductedloss_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_Deductedloss_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_Deductedloss_CellEditor = new KDTDefaultCellEditor(kdtEntrys_Deductedloss_TextField);
        this.kdtEntrys.getColumn("Deductedloss").setEditor(kdtEntrys_Deductedloss_CellEditor);
        KDFormattedTextField kdtEntrys_Accidentinsurance_TextField = new KDFormattedTextField();
        kdtEntrys_Accidentinsurance_TextField.setName("kdtEntrys_Accidentinsurance_TextField");
        kdtEntrys_Accidentinsurance_TextField.setVisible(true);
        kdtEntrys_Accidentinsurance_TextField.setEditable(true);
        kdtEntrys_Accidentinsurance_TextField.setHorizontalAlignment(2);
        kdtEntrys_Accidentinsurance_TextField.setDataType(1);
        	kdtEntrys_Accidentinsurance_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_Accidentinsurance_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_Accidentinsurance_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_Accidentinsurance_CellEditor = new KDTDefaultCellEditor(kdtEntrys_Accidentinsurance_TextField);
        this.kdtEntrys.getColumn("Accidentinsurance").setEditor(kdtEntrys_Accidentinsurance_CellEditor);
        KDFormattedTextField kdtEntrys_deAccident_TextField = new KDFormattedTextField();
        kdtEntrys_deAccident_TextField.setName("kdtEntrys_deAccident_TextField");
        kdtEntrys_deAccident_TextField.setVisible(true);
        kdtEntrys_deAccident_TextField.setEditable(true);
        kdtEntrys_deAccident_TextField.setHorizontalAlignment(2);
        kdtEntrys_deAccident_TextField.setDataType(1);
        	kdtEntrys_deAccident_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_deAccident_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_deAccident_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_deAccident_CellEditor = new KDTDefaultCellEditor(kdtEntrys_deAccident_TextField);
        this.kdtEntrys.getColumn("deAccident").setEditor(kdtEntrys_deAccident_CellEditor);
        KDFormattedTextField kdtEntrys_bhjkzsf_TextField = new KDFormattedTextField();
        kdtEntrys_bhjkzsf_TextField.setName("kdtEntrys_bhjkzsf_TextField");
        kdtEntrys_bhjkzsf_TextField.setVisible(true);
        kdtEntrys_bhjkzsf_TextField.setEditable(true);
        kdtEntrys_bhjkzsf_TextField.setHorizontalAlignment(2);
        kdtEntrys_bhjkzsf_TextField.setDataType(1);
        	kdtEntrys_bhjkzsf_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_bhjkzsf_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_bhjkzsf_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_bhjkzsf_CellEditor = new KDTDefaultCellEditor(kdtEntrys_bhjkzsf_TextField);
        this.kdtEntrys.getColumn("bhjkzsf").setEditor(kdtEntrys_bhjkzsf_CellEditor);
        KDFormattedTextField kdtEntrys_newEntry_TextField = new KDFormattedTextField();
        kdtEntrys_newEntry_TextField.setName("kdtEntrys_newEntry_TextField");
        kdtEntrys_newEntry_TextField.setVisible(true);
        kdtEntrys_newEntry_TextField.setEditable(true);
        kdtEntrys_newEntry_TextField.setHorizontalAlignment(2);
        kdtEntrys_newEntry_TextField.setDataType(1);
        	kdtEntrys_newEntry_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_newEntry_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_newEntry_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_newEntry_CellEditor = new KDTDefaultCellEditor(kdtEntrys_newEntry_TextField);
        this.kdtEntrys.getColumn("newEntry").setEditor(kdtEntrys_newEntry_CellEditor);
        KDCheckBox kdtEntrys_isSpeedfrom_CheckBox = new KDCheckBox();
        kdtEntrys_isSpeedfrom_CheckBox.setName("kdtEntrys_isSpeedfrom_CheckBox");
        KDTDefaultCellEditor kdtEntrys_isSpeedfrom_CellEditor = new KDTDefaultCellEditor(kdtEntrys_isSpeedfrom_CheckBox);
        this.kdtEntrys.getColumn("isSpeedfrom").setEditor(kdtEntrys_isSpeedfrom_CellEditor);
        KDTextArea kdtEntrys_Remarks_TextArea = new KDTextArea();
        kdtEntrys_Remarks_TextArea.setName("kdtEntrys_Remarks_TextArea");
        kdtEntrys_Remarks_TextArea.setMaxLength(255);
        KDTDefaultCellEditor kdtEntrys_Remarks_CellEditor = new KDTDefaultCellEditor(kdtEntrys_Remarks_TextArea);
        this.kdtEntrys.getColumn("Remarks").setEditor(kdtEntrys_Remarks_CellEditor);
        // contbillStatus		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);
        // contperiod		
        this.contperiod.setBoundLabelText(resHelper.getString("contperiod.boundLabelText"));		
        this.contperiod.setBoundLabelLength(100);		
        this.contperiod.setBoundLabelUnderline(true);		
        this.contperiod.setVisible(true);
        // contbegindate		
        this.contbegindate.setBoundLabelText(resHelper.getString("contbegindate.boundLabelText"));		
        this.contbegindate.setBoundLabelLength(100);		
        this.contbegindate.setBoundLabelUnderline(true);		
        this.contbegindate.setVisible(true);
        // contenddate		
        this.contenddate.setBoundLabelText(resHelper.getString("contenddate.boundLabelText"));		
        this.contenddate.setBoundLabelLength(100);		
        this.contenddate.setBoundLabelUnderline(true);		
        this.contenddate.setVisible(true);
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
        // billStatus		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.billStatus.setRequired(false);
        // prmtperiod		
        this.prmtperiod.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7PeriodQuery");		
        this.prmtperiod.setEditable(true);		
        this.prmtperiod.setDisplayFormat("$number$");		
        this.prmtperiod.setEditFormat("$number$");		
        this.prmtperiod.setCommitFormat("$number$");		
        this.prmtperiod.setRequired(false);
        // pkbegindate		
        this.pkbegindate.setRequired(false);
        // pkenddate		
        this.pkenddate.setRequired(false);
        // audit
        this.audit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.audit.setText(resHelper.getString("audit.text"));
        // unaudit
        this.unaudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnaudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.unaudit.setText(resHelper.getString("unaudit.text"));
        // Getperson
        this.Getperson.setAction((IItemAction)ActionProxyFactory.getProxy(actionGetPerson, new Class[] { IItemAction.class }, getServiceContext()));		
        this.Getperson.setText(resHelper.getString("Getperson.text"));
        // newSeparator2		
        this.newSeparator2.setOrientation(1);
        // Wagecalcul
        this.Wagecalcul.setAction((IItemAction)ActionProxyFactory.getProxy(actionWagecalculation, new Class[] { IItemAction.class }, getServiceContext()));		
        this.Wagecalcul.setText(resHelper.getString("Wagecalcul.text"));
        // newSeparator1		
        this.newSeparator1.setOrientation(1);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,billStatus,prmtperiod,pkbegindate,pkenddate,kdtEntrys}));
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
        contCreator.setBounds(new Rectangle(379, 524, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(379, 524, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(730, 524, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(730, 524, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(379, 555, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(379, 555, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(730, 555, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(730, 555, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(12, 14, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(12, 14, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(379, 66, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(379, 66, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(728, 66, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(728, 66, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(15, 528, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(15, 528, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(12, 99, 991, 413));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.custom.wages.food.MonthFoodBillEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(12, 99, 991, 413, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
		vo.put("attendanceday",new java.math.BigDecimal(0));
		vo.put("actualattenday",new java.math.BigDecimal(0));
		vo.put("basicwages",new java.math.BigDecimal(0));
		vo.put("subsidywages",new java.math.BigDecimal(0));
		vo.put("checkworkwages",new java.math.BigDecimal(0));
		vo.put("fullworkwages",new java.math.BigDecimal(0));
		vo.put("leaveday",new java.math.BigDecimal(0));
		vo.put("absenteeismday",new java.math.BigDecimal(0));
		vo.put("qualitydebit",new java.math.BigDecimal(0));
		vo.put("notificationwages",new java.math.BigDecimal(0));
		vo.put("jgzbx",new java.math.BigDecimal(0));
		vo.put("overtimeD",new java.math.BigDecimal(0));
		vo.put("repairmonth",new java.math.BigDecimal(0));
		vo.put("wagespay",new java.math.BigDecimal(0));
		vo.put("socialsecurity",new java.math.BigDecimal(0));
		vo.put("taxableincome",new java.math.BigDecimal(0));
		vo.put("recruitwages",new java.math.BigDecimal(0));
		vo.put("Payroll",new java.math.BigDecimal(0));
		vo.put("Deductedloss",new java.math.BigDecimal(0));
		vo.put("Accidentinsurance",new java.math.BigDecimal(0));
		vo.put("newEntry",new java.math.BigDecimal(0));
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        contbillStatus.setBounds(new Rectangle(13, 66, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(13, 66, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contperiod.setBounds(new Rectangle(-379, 15, 270, 19));
        this.add(contperiod, new KDLayout.Constraints(-379, 15, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbegindate.setBounds(new Rectangle(378, 14, 270, 19));
        this.add(contbegindate, new KDLayout.Constraints(378, 14, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contenddate.setBounds(new Rectangle(728, 14, 270, 19));
        this.add(contenddate, new KDLayout.Constraints(728, 14, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //contperiod
        contperiod.setBoundEditor(prmtperiod);
        //contbegindate
        contbegindate.setBoundEditor(pkbegindate);
        //contenddate
        contenddate.setBoundEditor(pkenddate);

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
        this.toolBar.add(audit);
        this.toolBar.add(unaudit);
        this.toolBar.add(separatorFW9);
        this.toolBar.add(Getperson);
        this.toolBar.add(newSeparator2);
        this.toolBar.add(Wagecalcul);
        this.toolBar.add(newSeparator1);
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
		dataBinder.registerBinding("entrys", com.kingdee.eas.custom.wages.food.MonthFoodBillEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.person", java.lang.Object.class, this.kdtEntrys, "person.text");
		dataBinder.registerBinding("entrys.timeofentry", java.util.Date.class, this.kdtEntrys, "timeofentry.text");
		dataBinder.registerBinding("entrys.attendanceday", java.math.BigDecimal.class, this.kdtEntrys, "attendanceday.text");
		dataBinder.registerBinding("entrys.actualattenday", java.math.BigDecimal.class, this.kdtEntrys, "actualattenday.text");
		dataBinder.registerBinding("entrys.leaveday", java.math.BigDecimal.class, this.kdtEntrys, "leaveday.text");
		dataBinder.registerBinding("entrys.absenteeismday", java.math.BigDecimal.class, this.kdtEntrys, "absenteeismday.text");
		dataBinder.registerBinding("entrys.fullworkwages", java.math.BigDecimal.class, this.kdtEntrys, "fullworkwages.text");
		dataBinder.registerBinding("entrys.basicwages", java.math.BigDecimal.class, this.kdtEntrys, "basicwages.text");
		dataBinder.registerBinding("entrys.checkworkwages", java.math.BigDecimal.class, this.kdtEntrys, "checkworkwages.text");
		dataBinder.registerBinding("entrys.overtimeD", java.math.BigDecimal.class, this.kdtEntrys, "overtimeD.text");
		dataBinder.registerBinding("entrys.subsidywages", java.math.BigDecimal.class, this.kdtEntrys, "subsidywages.text");
		dataBinder.registerBinding("entrys.recruitwages", java.math.BigDecimal.class, this.kdtEntrys, "recruitwages.text");
		dataBinder.registerBinding("entrys.qualitydebit", java.math.BigDecimal.class, this.kdtEntrys, "qualitydebit.text");
		dataBinder.registerBinding("entrys.notificationwages", java.math.BigDecimal.class, this.kdtEntrys, "notificationwages.text");
		dataBinder.registerBinding("entrys.repairmonth", java.math.BigDecimal.class, this.kdtEntrys, "repairmonth.text");
		dataBinder.registerBinding("entrys.jgzbx", java.math.BigDecimal.class, this.kdtEntrys, "jgzbx.text");
		dataBinder.registerBinding("entrys.wagespay", java.math.BigDecimal.class, this.kdtEntrys, "wagespay.text");
		dataBinder.registerBinding("entrys.socialsecurity", java.math.BigDecimal.class, this.kdtEntrys, "socialsecurity.text");
		dataBinder.registerBinding("entrys.taxableincome", java.math.BigDecimal.class, this.kdtEntrys, "taxableincome.text");
		dataBinder.registerBinding("entrys.Payroll", java.math.BigDecimal.class, this.kdtEntrys, "Payroll.text");
		dataBinder.registerBinding("entrys.Accidentinsurance", java.math.BigDecimal.class, this.kdtEntrys, "Accidentinsurance.text");
		dataBinder.registerBinding("entrys.Deductedloss", java.math.BigDecimal.class, this.kdtEntrys, "Deductedloss.text");
		dataBinder.registerBinding("entrys.newEntry", java.math.BigDecimal.class, this.kdtEntrys, "newEntry.text");
		dataBinder.registerBinding("entrys.Remarks", String.class, this.kdtEntrys, "Remarks.text");
		dataBinder.registerBinding("entrys.isSpeedfrom", boolean.class, this.kdtEntrys, "isSpeedfrom.text");
		dataBinder.registerBinding("entrys.banknumber", String.class, this.kdtEntrys, "banknumber.text");
		dataBinder.registerBinding("entrys.Accountopening", String.class, this.kdtEntrys, "Accountopening.text");
		dataBinder.registerBinding("entrys.Commute", boolean.class, this.kdtEntrys, "Commute.text");
		dataBinder.registerBinding("entrys.nightwork", boolean.class, this.kdtEntrys, "nightwork.text");
		dataBinder.registerBinding("entrys.personnumber", String.class, this.kdtEntrys, "personnumber.text");
		dataBinder.registerBinding("entrys.persontax", java.math.BigDecimal.class, this.kdtEntrys, "persontax.text");
		dataBinder.registerBinding("entrys.adjustAmount", java.math.BigDecimal.class, this.kdtEntrys, "adjustAmount.text");
		dataBinder.registerBinding("entrys.adjustRemarks", String.class, this.kdtEntrys, "adjustRemarks.text");
		dataBinder.registerBinding("entrys.byjfkh", java.math.BigDecimal.class, this.kdtEntrys, "byjfkh.text");
		dataBinder.registerBinding("entrys.jjrbz", java.math.BigDecimal.class, this.kdtEntrys, "jjrbz.text");
		dataBinder.registerBinding("entrys.PostSalary", java.math.BigDecimal.class, this.kdtEntrys, "PostSalary.text");
		dataBinder.registerBinding("entrys.Postattendance", java.math.BigDecimal.class, this.kdtEntrys, "Postattendance.text");
		dataBinder.registerBinding("entrys.deAccident", java.math.BigDecimal.class, this.kdtEntrys, "deAccident.text");
		dataBinder.registerBinding("entrys.bhjkzsf", java.math.BigDecimal.class, this.kdtEntrys, "bhjkzsf.text");
		dataBinder.registerBinding("entrys.Awards", java.math.BigDecimal.class, this.kdtEntrys, "Awards.text");
		dataBinder.registerBinding("entrys.overdayamount", java.math.BigDecimal.class, this.kdtEntrys, "overdayamount.text");
		dataBinder.registerBinding("entrys.Attendanceratio", java.math.BigDecimal.class, this.kdtEntrys, "Attendanceratio.text");
		dataBinder.registerBinding("entrys.overday", java.math.BigDecimal.class, this.kdtEntrys, "overday.text");
		dataBinder.registerBinding("entrys.post", java.lang.Object.class, this.kdtEntrys, "post.text");
		dataBinder.registerBinding("entrys.fromgroup", java.lang.Object.class, this.kdtEntrys, "fromgroup.text");
		dataBinder.registerBinding("entrys.basicattendance", java.math.BigDecimal.class, this.kdtEntrys, "basicattendance.text");
		dataBinder.registerBinding("entrys.fullwages", java.math.BigDecimal.class, this.kdtEntrys, "fullwages.text");
		dataBinder.registerBinding("entrys.StandardAward", java.math.BigDecimal.class, this.kdtEntrys, "StandardAward.text");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("period", com.kingdee.eas.basedata.assistant.PeriodInfo.class, this.prmtperiod, "data");
		dataBinder.registerBinding("begindate", java.util.Date.class, this.pkbegindate, "value");
		dataBinder.registerBinding("enddate", java.util.Date.class, this.pkenddate, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.wages.food.app.MonthFoodBillEditUIHandler";
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
        this.editData = (com.kingdee.eas.custom.wages.food.MonthFoodBillInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.person", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.timeofentry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.attendanceday", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.actualattenday", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.leaveday", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.absenteeismday", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.fullworkwages", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.basicwages", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.checkworkwages", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.overtimeD", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.subsidywages", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.recruitwages", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qualitydebit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.notificationwages", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.repairmonth", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.jgzbx", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.wagespay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.socialsecurity", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.taxableincome", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Payroll", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Accidentinsurance", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Deductedloss", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.newEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Remarks", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isSpeedfrom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.banknumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Accountopening", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Commute", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.nightwork", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.personnumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.persontax", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.adjustAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.adjustRemarks", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.byjfkh", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.jjrbz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.PostSalary", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Postattendance", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.deAccident", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.bhjkzsf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Awards", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.overdayamount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Attendanceratio", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.overday", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.post", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.fromgroup", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.basicattendance", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.fullwages", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.StandardAward", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("period", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("begindate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("enddate", ValidateHelper.ON_SAVE);    		
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
    	sic.add(new SelectorItemInfo("entrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.person.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.person.id"));
			sic.add(new SelectorItemInfo("entrys.person.name"));
        	sic.add(new SelectorItemInfo("entrys.person.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.timeofentry"));
    	sic.add(new SelectorItemInfo("entrys.attendanceday"));
    	sic.add(new SelectorItemInfo("entrys.actualattenday"));
    	sic.add(new SelectorItemInfo("entrys.leaveday"));
    	sic.add(new SelectorItemInfo("entrys.absenteeismday"));
    	sic.add(new SelectorItemInfo("entrys.fullworkwages"));
    	sic.add(new SelectorItemInfo("entrys.basicwages"));
    	sic.add(new SelectorItemInfo("entrys.checkworkwages"));
    	sic.add(new SelectorItemInfo("entrys.overtimeD"));
    	sic.add(new SelectorItemInfo("entrys.subsidywages"));
    	sic.add(new SelectorItemInfo("entrys.recruitwages"));
    	sic.add(new SelectorItemInfo("entrys.qualitydebit"));
    	sic.add(new SelectorItemInfo("entrys.notificationwages"));
    	sic.add(new SelectorItemInfo("entrys.repairmonth"));
    	sic.add(new SelectorItemInfo("entrys.jgzbx"));
    	sic.add(new SelectorItemInfo("entrys.wagespay"));
    	sic.add(new SelectorItemInfo("entrys.socialsecurity"));
    	sic.add(new SelectorItemInfo("entrys.taxableincome"));
    	sic.add(new SelectorItemInfo("entrys.Payroll"));
    	sic.add(new SelectorItemInfo("entrys.Accidentinsurance"));
    	sic.add(new SelectorItemInfo("entrys.Deductedloss"));
    	sic.add(new SelectorItemInfo("entrys.newEntry"));
    	sic.add(new SelectorItemInfo("entrys.Remarks"));
    	sic.add(new SelectorItemInfo("entrys.isSpeedfrom"));
    	sic.add(new SelectorItemInfo("entrys.banknumber"));
    	sic.add(new SelectorItemInfo("entrys.Accountopening"));
    	sic.add(new SelectorItemInfo("entrys.Commute"));
    	sic.add(new SelectorItemInfo("entrys.nightwork"));
    	sic.add(new SelectorItemInfo("entrys.personnumber"));
    	sic.add(new SelectorItemInfo("entrys.persontax"));
    	sic.add(new SelectorItemInfo("entrys.adjustAmount"));
    	sic.add(new SelectorItemInfo("entrys.adjustRemarks"));
    	sic.add(new SelectorItemInfo("entrys.byjfkh"));
    	sic.add(new SelectorItemInfo("entrys.jjrbz"));
    	sic.add(new SelectorItemInfo("entrys.PostSalary"));
    	sic.add(new SelectorItemInfo("entrys.Postattendance"));
    	sic.add(new SelectorItemInfo("entrys.deAccident"));
    	sic.add(new SelectorItemInfo("entrys.bhjkzsf"));
    	sic.add(new SelectorItemInfo("entrys.Awards"));
    	sic.add(new SelectorItemInfo("entrys.overdayamount"));
    	sic.add(new SelectorItemInfo("entrys.Attendanceratio"));
    	sic.add(new SelectorItemInfo("entrys.overday"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.post.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.post.id"));
			sic.add(new SelectorItemInfo("entrys.post.name"));
        	sic.add(new SelectorItemInfo("entrys.post.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.fromgroup.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.fromgroup.id"));
			sic.add(new SelectorItemInfo("entrys.fromgroup.name"));
        	sic.add(new SelectorItemInfo("entrys.fromgroup.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.basicattendance"));
    	sic.add(new SelectorItemInfo("entrys.fullwages"));
    	sic.add(new SelectorItemInfo("entrys.StandardAward"));
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
        sic.add(new SelectorItemInfo("billStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("period.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("period.id"));
        	sic.add(new SelectorItemInfo("period.number"));
		}
        sic.add(new SelectorItemInfo("begindate"));
        sic.add(new SelectorItemInfo("enddate"));
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
        com.kingdee.eas.custom.wages.food.MonthFoodBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnaudit_actionPerformed method
     */
    public void actionUnaudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.wages.food.MonthFoodBillFactory.getRemoteInstance().unaudit(editData);
    }
    	

    /**
     * output actionGetPerson_actionPerformed method
     */
    public void actionGetPerson_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.wages.food.MonthFoodBillFactory.getRemoteInstance().getPerson(editData);
    }
    	

    /**
     * output actionWagecalculation_actionPerformed method
     */
    public void actionWagecalculation_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.wages.food.MonthFoodBillFactory.getRemoteInstance().wagecalculation(editData);
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
	public RequestContext prepareActionUnaudit(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionUnaudit() {
    	return false;
    }
	public RequestContext prepareActionGetPerson(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionGetPerson() {
    	return false;
    }
	public RequestContext prepareActionWagecalculation(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionWagecalculation() {
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
            innerActionPerformed("eas", AbstractMonthFoodBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionUnaudit class
     */     
    protected class ActionUnaudit extends ItemAction {     
    
        public ActionUnaudit()
        {
            this(null);
        }

        public ActionUnaudit(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionUnaudit.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnaudit.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnaudit.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractMonthFoodBillEditUI.this, "ActionUnaudit", "actionUnaudit_actionPerformed", e);
        }
    }

    /**
     * output ActionGetPerson class
     */     
    protected class ActionGetPerson extends ItemAction {     
    
        public ActionGetPerson()
        {
            this(null);
        }

        public ActionGetPerson(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionGetPerson.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionGetPerson.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionGetPerson.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractMonthFoodBillEditUI.this, "ActionGetPerson", "actionGetPerson_actionPerformed", e);
        }
    }

    /**
     * output ActionWagecalculation class
     */     
    protected class ActionWagecalculation extends ItemAction {     
    
        public ActionWagecalculation()
        {
            this(null);
        }

        public ActionWagecalculation(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionWagecalculation.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionWagecalculation.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionWagecalculation.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractMonthFoodBillEditUI.this, "ActionWagecalculation", "actionWagecalculation_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.wages.food.client", "MonthFoodBillEditUI");
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
        return com.kingdee.eas.custom.wages.food.client.MonthFoodBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.wages.food.MonthFoodBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.wages.food.MonthFoodBillInfo objectValue = new com.kingdee.eas.custom.wages.food.MonthFoodBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/wages/food/MonthFoodBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.wages.food.app.MonthFoodBillQuery");
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
		vo.put("billStatus",new Integer(-1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}