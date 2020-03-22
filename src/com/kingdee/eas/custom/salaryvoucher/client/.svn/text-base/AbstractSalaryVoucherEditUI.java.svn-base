/**
 * output package name
 */
package com.kingdee.eas.custom.salaryvoucher.client;

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
public abstract class AbstractSalaryVoucherEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSalaryVoucherEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contname;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompanyOrg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contPeriodDeviationValue;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contvoucherType;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtname;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompanyOrg;
    protected com.kingdee.bos.ctrl.swing.KDComboBox status;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtPeriodDeviationValue;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtvoucherType;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtCmpItem;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtCmpItem_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtAssistActItem;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtAssistActItem_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtPerson;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtPerson_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDButton btnSelectAll;
    protected com.kingdee.bos.ctrl.swing.KDButton btnSelectNull;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkAuditTime;
    protected com.kingdee.eas.custom.salaryvoucher.SalaryVoucherInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractSalaryVoucherEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractSalaryVoucherEditUI.class.getName());
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
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contname = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompanyOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contPeriodDeviationValue = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contvoucherType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contAuditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtname = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtcompanyOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.status = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtPeriodDeviationValue = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtvoucherType = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtCmpItem = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kdtAssistActItem = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtPerson = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.btnSelectAll = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnSelectNull = new com.kingdee.bos.ctrl.swing.KDButton();
        this.pkAuditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.contname.setName("contname");
        this.contcompanyOrg.setName("contcompanyOrg");
        this.contstatus.setName("contstatus");
        this.contPeriodDeviationValue.setName("contPeriodDeviationValue");
        this.contvoucherType.setName("contvoucherType");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contAuditTime.setName("contAuditTime");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.txtname.setName("txtname");
        this.prmtcompanyOrg.setName("prmtcompanyOrg");
        this.status.setName("status");
        this.txtPeriodDeviationValue.setName("txtPeriodDeviationValue");
        this.prmtvoucherType.setName("prmtvoucherType");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel1.setName("kDPanel1");
        this.kdtEntrys.setName("kdtEntrys");
        this.kdtCmpItem.setName("kdtCmpItem");
        this.kDSeparator8.setName("kDSeparator8");
        this.kdtAssistActItem.setName("kdtAssistActItem");
        this.kdtPerson.setName("kdtPerson");
        this.btnSelectAll.setName("btnSelectAll");
        this.btnSelectNull.setName("btnSelectNull");
        this.pkAuditTime.setName("pkAuditTime");
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
        // contname		
        this.contname.setBoundLabelText(resHelper.getString("contname.boundLabelText"));		
        this.contname.setBoundLabelLength(100);		
        this.contname.setBoundLabelUnderline(true);		
        this.contname.setVisible(true);
        // contcompanyOrg		
        this.contcompanyOrg.setBoundLabelText(resHelper.getString("contcompanyOrg.boundLabelText"));		
        this.contcompanyOrg.setBoundLabelLength(100);		
        this.contcompanyOrg.setBoundLabelUnderline(true);		
        this.contcompanyOrg.setVisible(true);
        // contstatus		
        this.contstatus.setBoundLabelText(resHelper.getString("contstatus.boundLabelText"));		
        this.contstatus.setBoundLabelLength(100);		
        this.contstatus.setBoundLabelUnderline(true);		
        this.contstatus.setVisible(true);
        // contPeriodDeviationValue		
        this.contPeriodDeviationValue.setBoundLabelText(resHelper.getString("contPeriodDeviationValue.boundLabelText"));		
        this.contPeriodDeviationValue.setBoundLabelLength(100);		
        this.contPeriodDeviationValue.setBoundLabelUnderline(true);		
        this.contPeriodDeviationValue.setVisible(true);
        // contvoucherType		
        this.contvoucherType.setBoundLabelText(resHelper.getString("contvoucherType.boundLabelText"));		
        this.contvoucherType.setBoundLabelLength(100);		
        this.contvoucherType.setBoundLabelUnderline(true);		
        this.contvoucherType.setVisible(true);
        // kDTabbedPane1
        // contAuditTime		
        this.contAuditTime.setBoundLabelText(resHelper.getString("contAuditTime.boundLabelText"));		
        this.contAuditTime.setBoundLabelLength(100);		
        this.contAuditTime.setBoundLabelUnderline(true);		
        this.contAuditTime.setVisible(true);
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
        this.txtNumber.setRequired(true);
        // pkBizDate		
        this.pkBizDate.setEnabled(true);
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // txtname		
        this.txtname.setHorizontalAlignment(2);		
        this.txtname.setMaxLength(100);		
        this.txtname.setRequired(false);
        // prmtcompanyOrg		
        this.prmtcompanyOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompanyOrg.setEditable(true);		
        this.prmtcompanyOrg.setDisplayFormat("$name$");		
        this.prmtcompanyOrg.setEditFormat("$number$");		
        this.prmtcompanyOrg.setCommitFormat("$number$");		
        this.prmtcompanyOrg.setRequired(false);
        // status		
        this.status.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.salaryvoucher.voucherStatus").toArray());		
        this.status.setRequired(false);
        // txtPeriodDeviationValue		
        this.txtPeriodDeviationValue.setHorizontalAlignment(2);		
        this.txtPeriodDeviationValue.setDataType(0);		
        this.txtPeriodDeviationValue.setSupportedEmpty(true);		
        this.txtPeriodDeviationValue.setRequired(false);		
        this.txtPeriodDeviationValue.setEnabled(false);
        // prmtvoucherType		
        this.prmtvoucherType.setQueryInfo("com.kingdee.eas.basedata.assistant.app.VoucherTypeQuery");		
        this.prmtvoucherType.setEditable(true);		
        this.prmtvoucherType.setDisplayFormat("$name$");		
        this.prmtvoucherType.setEditFormat("$number$");		
        this.prmtvoucherType.setCommitFormat("$number$");		
        this.prmtvoucherType.setRequired(true);
        // kDPanel2
        // kDPanel1
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"Accounting\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"debitOrCredit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"abstactInfo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"scaleScheme\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{Accounting}</t:Cell><t:Cell>$Resource{debitOrCredit}</t:Cell><t:Cell>$Resource{abstactInfo}</t:Cell><t:Cell>$Resource{scaleScheme}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));

                this.kdtEntrys.putBindContents("editData",new String[] {"id","Accounting","debitOrCredit","abstactInfo","scaleScheme"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_Accounting_PromptBox = new KDBizPromptBox();
        kdtEntrys_Accounting_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.account.app.F7AccountViewQuery");
        kdtEntrys_Accounting_PromptBox.setVisible(true);
        kdtEntrys_Accounting_PromptBox.setEditable(true);
        kdtEntrys_Accounting_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_Accounting_PromptBox.setEditFormat("$number$");
        kdtEntrys_Accounting_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_Accounting_CellEditor = new KDTDefaultCellEditor(kdtEntrys_Accounting_PromptBox);
        this.kdtEntrys.getColumn("Accounting").setEditor(kdtEntrys_Accounting_CellEditor);
        ObjectValueRender kdtEntrys_Accounting_OVR = new ObjectValueRender();
        kdtEntrys_Accounting_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("Accounting").setRenderer(kdtEntrys_Accounting_OVR);
        KDComboBox kdtEntrys_debitOrCredit_ComboBox = new KDComboBox();
        kdtEntrys_debitOrCredit_ComboBox.setName("kdtEntrys_debitOrCredit_ComboBox");
        kdtEntrys_debitOrCredit_ComboBox.setVisible(true);
        kdtEntrys_debitOrCredit_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.fi.gr.cslrpt.DebitOrCreditEnum").toArray());
        KDTDefaultCellEditor kdtEntrys_debitOrCredit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_debitOrCredit_ComboBox);
        this.kdtEntrys.getColumn("debitOrCredit").setEditor(kdtEntrys_debitOrCredit_CellEditor);
        KDTextField kdtEntrys_abstactInfo_TextField = new KDTextField();
        kdtEntrys_abstactInfo_TextField.setName("kdtEntrys_abstactInfo_TextField");
        kdtEntrys_abstactInfo_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_abstactInfo_CellEditor = new KDTDefaultCellEditor(kdtEntrys_abstactInfo_TextField);
        this.kdtEntrys.getColumn("abstactInfo").setEditor(kdtEntrys_abstactInfo_CellEditor);
        final KDBizPromptBox kdtEntrys_scaleScheme_PromptBox = new KDBizPromptBox();
        kdtEntrys_scaleScheme_PromptBox.setQueryInfo("com.kingdee.eas.custom.salaryvoucher.app.SCalSchemeQuery");
        kdtEntrys_scaleScheme_PromptBox.setVisible(true);
        kdtEntrys_scaleScheme_PromptBox.setEditable(true);
        kdtEntrys_scaleScheme_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_scaleScheme_PromptBox.setEditFormat("$number$");
        kdtEntrys_scaleScheme_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_scaleScheme_CellEditor = new KDTDefaultCellEditor(kdtEntrys_scaleScheme_PromptBox);
        this.kdtEntrys.getColumn("scaleScheme").setEditor(kdtEntrys_scaleScheme_CellEditor);
        ObjectValueRender kdtEntrys_scaleScheme_OVR = new ObjectValueRender();
        kdtEntrys_scaleScheme_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("scaleScheme").setRenderer(kdtEntrys_scaleScheme_OVR);
        // kdtCmpItem
		String kdtCmpItemStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"cmpItemNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"cmpItemName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"cmpItemCode\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{cmpItemNum}</t:Cell><t:Cell>$Resource{cmpItemName}</t:Cell><t:Cell>$Resource{cmpItemCode}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtCmpItem.setFormatXml(resHelper.translateString("kdtCmpItem",kdtCmpItemStrXML));
        kdtCmpItem.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtCmpItem_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtCmpItem.putBindContents("editData",new String[] {"CmpItem.seq","CmpItem.cmpItemNum","CmpItem.cmpItemName","CmpItem.cmpItemCode"});


        this.kdtCmpItem.checkParsed();
        KDFormattedTextField kdtCmpItem_seq_TextField = new KDFormattedTextField();
        kdtCmpItem_seq_TextField.setName("kdtCmpItem_seq_TextField");
        kdtCmpItem_seq_TextField.setVisible(true);
        kdtCmpItem_seq_TextField.setEditable(true);
        kdtCmpItem_seq_TextField.setHorizontalAlignment(2);
        kdtCmpItem_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtCmpItem_seq_CellEditor = new KDTDefaultCellEditor(kdtCmpItem_seq_TextField);
        this.kdtCmpItem.getColumn("seq").setEditor(kdtCmpItem_seq_CellEditor);
        final KDBizPromptBox kdtCmpItem_cmpItemNum_PromptBox = new KDBizPromptBox();
        kdtCmpItem_cmpItemNum_PromptBox.setQueryInfo("com.kingdee.eas.custom.salaryvoucher.app.CmpItemQuery");
        kdtCmpItem_cmpItemNum_PromptBox.setVisible(true);
        kdtCmpItem_cmpItemNum_PromptBox.setEditable(true);
        kdtCmpItem_cmpItemNum_PromptBox.setDisplayFormat("$number$");
        kdtCmpItem_cmpItemNum_PromptBox.setEditFormat("$number$");
        kdtCmpItem_cmpItemNum_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtCmpItem_cmpItemNum_CellEditor = new KDTDefaultCellEditor(kdtCmpItem_cmpItemNum_PromptBox);
        this.kdtCmpItem.getColumn("cmpItemNum").setEditor(kdtCmpItem_cmpItemNum_CellEditor);
        ObjectValueRender kdtCmpItem_cmpItemNum_OVR = new ObjectValueRender();
        kdtCmpItem_cmpItemNum_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtCmpItem.getColumn("cmpItemNum").setRenderer(kdtCmpItem_cmpItemNum_OVR);
        KDTextField kdtCmpItem_cmpItemName_TextField = new KDTextField();
        kdtCmpItem_cmpItemName_TextField.setName("kdtCmpItem_cmpItemName_TextField");
        kdtCmpItem_cmpItemName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtCmpItem_cmpItemName_CellEditor = new KDTDefaultCellEditor(kdtCmpItem_cmpItemName_TextField);
        this.kdtCmpItem.getColumn("cmpItemName").setEditor(kdtCmpItem_cmpItemName_CellEditor);
        KDTextField kdtCmpItem_cmpItemCode_TextField = new KDTextField();
        kdtCmpItem_cmpItemCode_TextField.setName("kdtCmpItem_cmpItemCode_TextField");
        kdtCmpItem_cmpItemCode_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtCmpItem_cmpItemCode_CellEditor = new KDTDefaultCellEditor(kdtCmpItem_cmpItemCode_TextField);
        this.kdtCmpItem.getColumn("cmpItemCode").setEditor(kdtCmpItem_cmpItemCode_CellEditor);
        // kDSeparator8
        // kdtAssistActItem
		String kdtAssistActItemStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"assistActItemNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"assistActItemName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{assistActItemNum}</t:Cell><t:Cell>$Resource{assistActItemName}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtAssistActItem.setFormatXml(resHelper.translateString("kdtAssistActItem",kdtAssistActItemStrXML));

                this.kdtAssistActItem.putBindContents("editData",new String[] {"AssistActItem.seq","AssistActItem.assistActItemNum","AssistActItem.assistActItemName"});


        this.kdtAssistActItem.checkParsed();
        KDFormattedTextField kdtAssistActItem_seq_TextField = new KDFormattedTextField();
        kdtAssistActItem_seq_TextField.setName("kdtAssistActItem_seq_TextField");
        kdtAssistActItem_seq_TextField.setVisible(true);
        kdtAssistActItem_seq_TextField.setEditable(true);
        kdtAssistActItem_seq_TextField.setHorizontalAlignment(2);
        kdtAssistActItem_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtAssistActItem_seq_CellEditor = new KDTDefaultCellEditor(kdtAssistActItem_seq_TextField);
        this.kdtAssistActItem.getColumn("seq").setEditor(kdtAssistActItem_seq_CellEditor);
        KDTextField kdtAssistActItem_assistActItemNum_TextField = new KDTextField();
        kdtAssistActItem_assistActItemNum_TextField.setName("kdtAssistActItem_assistActItemNum_TextField");
        kdtAssistActItem_assistActItemNum_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtAssistActItem_assistActItemNum_CellEditor = new KDTDefaultCellEditor(kdtAssistActItem_assistActItemNum_TextField);
        this.kdtAssistActItem.getColumn("assistActItemNum").setEditor(kdtAssistActItem_assistActItemNum_CellEditor);
        KDTextField kdtAssistActItem_assistActItemName_TextField = new KDTextField();
        kdtAssistActItem_assistActItemName_TextField.setName("kdtAssistActItem_assistActItemName_TextField");
        kdtAssistActItem_assistActItemName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtAssistActItem_assistActItemName_CellEditor = new KDTDefaultCellEditor(kdtAssistActItem_assistActItemName_TextField);
        this.kdtAssistActItem.getColumn("assistActItemName").setEditor(kdtAssistActItem_assistActItemName_CellEditor);
        // kdtPerson
		String kdtPersonStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol8\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"selected\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"shrPersonNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"shrPersonName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"GreenDreamProject\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"GreenDreamProjectCode\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"GreenDreamProjectName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{selected}</t:Cell><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{name}</t:Cell><t:Cell>$Resource{shrPersonNum}</t:Cell><t:Cell>$Resource{shrPersonName}</t:Cell><t:Cell>$Resource{GreenDreamProject}</t:Cell><t:Cell>$Resource{GreenDreamProjectCode}</t:Cell><t:Cell>$Resource{GreenDreamProjectName}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtPerson.setFormatXml(resHelper.translateString("kdtPerson",kdtPersonStrXML));
        kdtPerson.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtPerson_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtPerson.putBindContents("editData",new String[] {"seq","selected","number","name","shrPersonNum","shrPersonName","GreenDreamProject","GreenDreamProjectCode","GreenDreamProjectName"});


        this.kdtPerson.checkParsed();
        KDFormattedTextField kdtPerson_seq_TextField = new KDFormattedTextField();
        kdtPerson_seq_TextField.setName("kdtPerson_seq_TextField");
        kdtPerson_seq_TextField.setVisible(true);
        kdtPerson_seq_TextField.setEditable(true);
        kdtPerson_seq_TextField.setHorizontalAlignment(2);
        kdtPerson_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtPerson_seq_CellEditor = new KDTDefaultCellEditor(kdtPerson_seq_TextField);
        this.kdtPerson.getColumn("seq").setEditor(kdtPerson_seq_CellEditor);
        KDCheckBox kdtPerson_selected_CheckBox = new KDCheckBox();
        kdtPerson_selected_CheckBox.setName("kdtPerson_selected_CheckBox");
        KDTDefaultCellEditor kdtPerson_selected_CellEditor = new KDTDefaultCellEditor(kdtPerson_selected_CheckBox);
        this.kdtPerson.getColumn("selected").setEditor(kdtPerson_selected_CellEditor);
        final KDBizPromptBox kdtPerson_number_PromptBox = new KDBizPromptBox();
        kdtPerson_number_PromptBox.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");
        kdtPerson_number_PromptBox.setVisible(true);
        kdtPerson_number_PromptBox.setEditable(true);
        kdtPerson_number_PromptBox.setDisplayFormat("$number$");
        kdtPerson_number_PromptBox.setEditFormat("$number$");
        kdtPerson_number_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtPerson_number_CellEditor = new KDTDefaultCellEditor(kdtPerson_number_PromptBox);
        this.kdtPerson.getColumn("number").setEditor(kdtPerson_number_CellEditor);
        ObjectValueRender kdtPerson_number_OVR = new ObjectValueRender();
        kdtPerson_number_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtPerson.getColumn("number").setRenderer(kdtPerson_number_OVR);
        KDTextField kdtPerson_name_TextField = new KDTextField();
        kdtPerson_name_TextField.setName("kdtPerson_name_TextField");
        kdtPerson_name_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtPerson_name_CellEditor = new KDTDefaultCellEditor(kdtPerson_name_TextField);
        this.kdtPerson.getColumn("name").setEditor(kdtPerson_name_CellEditor);
        KDTextField kdtPerson_shrPersonNum_TextField = new KDTextField();
        kdtPerson_shrPersonNum_TextField.setName("kdtPerson_shrPersonNum_TextField");
        kdtPerson_shrPersonNum_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtPerson_shrPersonNum_CellEditor = new KDTDefaultCellEditor(kdtPerson_shrPersonNum_TextField);
        this.kdtPerson.getColumn("shrPersonNum").setEditor(kdtPerson_shrPersonNum_CellEditor);
        KDTextField kdtPerson_shrPersonName_TextField = new KDTextField();
        kdtPerson_shrPersonName_TextField.setName("kdtPerson_shrPersonName_TextField");
        kdtPerson_shrPersonName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtPerson_shrPersonName_CellEditor = new KDTDefaultCellEditor(kdtPerson_shrPersonName_TextField);
        this.kdtPerson.getColumn("shrPersonName").setEditor(kdtPerson_shrPersonName_CellEditor);
        final KDBizPromptBox kdtPerson_GreenDreamProject_PromptBox = new KDBizPromptBox();
        kdtPerson_GreenDreamProject_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.auxacct.app.F7GeneralAsstActTypeQuery");
        kdtPerson_GreenDreamProject_PromptBox.setVisible(true);
        kdtPerson_GreenDreamProject_PromptBox.setEditable(true);
        kdtPerson_GreenDreamProject_PromptBox.setDisplayFormat("$number$");
        kdtPerson_GreenDreamProject_PromptBox.setEditFormat("$number$");
        kdtPerson_GreenDreamProject_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtPerson_GreenDreamProject_CellEditor = new KDTDefaultCellEditor(kdtPerson_GreenDreamProject_PromptBox);
        this.kdtPerson.getColumn("GreenDreamProject").setEditor(kdtPerson_GreenDreamProject_CellEditor);
        ObjectValueRender kdtPerson_GreenDreamProject_OVR = new ObjectValueRender();
        kdtPerson_GreenDreamProject_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtPerson.getColumn("GreenDreamProject").setRenderer(kdtPerson_GreenDreamProject_OVR);
        KDTextField kdtPerson_GreenDreamProjectCode_TextField = new KDTextField();
        kdtPerson_GreenDreamProjectCode_TextField.setName("kdtPerson_GreenDreamProjectCode_TextField");
        kdtPerson_GreenDreamProjectCode_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtPerson_GreenDreamProjectCode_CellEditor = new KDTDefaultCellEditor(kdtPerson_GreenDreamProjectCode_TextField);
        this.kdtPerson.getColumn("GreenDreamProjectCode").setEditor(kdtPerson_GreenDreamProjectCode_CellEditor);
        KDTextField kdtPerson_GreenDreamProjectName_TextField = new KDTextField();
        kdtPerson_GreenDreamProjectName_TextField.setName("kdtPerson_GreenDreamProjectName_TextField");
        kdtPerson_GreenDreamProjectName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtPerson_GreenDreamProjectName_CellEditor = new KDTDefaultCellEditor(kdtPerson_GreenDreamProjectName_TextField);
        this.kdtPerson.getColumn("GreenDreamProjectName").setEditor(kdtPerson_GreenDreamProjectName_CellEditor);
        // btnSelectAll		
        this.btnSelectAll.setText(resHelper.getString("btnSelectAll.text"));
        // btnSelectNull		
        this.btnSelectNull.setText(resHelper.getString("btnSelectNull.text"));
        // pkAuditTime		
        this.pkAuditTime.setRequired(false);		
        this.pkAuditTime.setEnabled(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {kdtAssistActItem,kdtCmpItem,txtname,prmtcompanyOrg,status,txtPeriodDeviationValue,prmtvoucherType,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,pkAuditTime,kdtPerson,kdtEntrys}));
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
        this.setBounds(new Rectangle(0, 0, 932, 600));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 932, 600));
        contCreator.setBounds(new Rectangle(326, 524, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(326, 524, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(633, 524, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(633, 524, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(326, 555, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(326, 555, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(633, 555, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(633, 555, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(20, 19, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(20, 19, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(767, 103, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(767, 103, 270, 19, 0));
        contDescription.setBounds(new Rectangle(822, 67, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(822, 67, 270, 19, 0));
        contAuditor.setBounds(new Rectangle(20, 528, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(20, 528, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contname.setBounds(new Rectangle(326, 19, 270, 19));
        this.add(contname, new KDLayout.Constraints(326, 19, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompanyOrg.setBounds(new Rectangle(633, 12, 270, 19));
        this.add(contcompanyOrg, new KDLayout.Constraints(633, 12, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contstatus.setBounds(new Rectangle(326, 54, 270, 19));
        this.add(contstatus, new KDLayout.Constraints(326, 54, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contPeriodDeviationValue.setBounds(new Rectangle(633, 48, 270, 19));
        this.add(contPeriodDeviationValue, new KDLayout.Constraints(633, 48, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contvoucherType.setBounds(new Rectangle(20, 56, 270, 19));
        this.add(contvoucherType, new KDLayout.Constraints(20, 56, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane1.setBounds(new Rectangle(20, 97, 883, 394));
        this.add(kDTabbedPane1, new KDLayout.Constraints(20, 97, 883, 394, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditTime.setBounds(new Rectangle(20, 555, 270, 19));
        this.add(contAuditTime, new KDLayout.Constraints(20, 555, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contname
        contname.setBoundEditor(txtname);
        //contcompanyOrg
        contcompanyOrg.setBoundEditor(prmtcompanyOrg);
        //contstatus
        contstatus.setBoundEditor(status);
        //contPeriodDeviationValue
        contPeriodDeviationValue.setBoundEditor(txtPeriodDeviationValue);
        //contvoucherType
        contvoucherType.setBoundEditor(prmtvoucherType);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 882, 361));        kdtEntrys.setBounds(new Rectangle(7, 6, 517, 144));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.custom.salaryvoucher.SalaryVoucherEntryInfo(),null,false);
        kDPanel2.add(kdtEntrys_detailPanel, new KDLayout.Constraints(7, 6, 517, 144, 0));
		kdtEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("debitOrCredit",new Integer(0));
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        kdtCmpItem.setBounds(new Rectangle(476, 196, 359, 149));
        kdtCmpItem_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtCmpItem,new com.kingdee.eas.custom.salaryvoucher.SalaryVoucherEntryCmpItemInfo(),null,false);
        kDPanel2.add(kdtCmpItem_detailPanel, new KDLayout.Constraints(476, 196, 359, 149, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator8.setBounds(new Rectangle(4, 171, 861, 10));
        kDPanel2.add(kDSeparator8, new KDLayout.Constraints(4, 171, 861, 10, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kdtAssistActItem.setBounds(new Rectangle(21, 196, 359, 153));
        kdtAssistActItem_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtAssistActItem,new com.kingdee.eas.custom.salaryvoucher.SalaryVoucherEntryAssistActItemInfo(),null,false);
        kDPanel2.add(kdtAssistActItem_detailPanel, new KDLayout.Constraints(21, 196, 359, 153, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //kDPanel1
        kDPanel1.setLayout(null);        kdtPerson.setBounds(new Rectangle(15, 48, 835, 294));
        kdtPerson_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtPerson,new com.kingdee.eas.custom.salaryvoucher.SalaryVoucherPersonInfo(),null,false);
        kDPanel1.add(kdtPerson_detailPanel, null);
        btnSelectAll.setBounds(new Rectangle(18, 6, 104, 29));
        kDPanel1.add(btnSelectAll, null);
        btnSelectNull.setBounds(new Rectangle(188, 6, 104, 29));
        kDPanel1.add(btnSelectNull, null);
        //contAuditTime
        contAuditTime.setBoundEditor(pkAuditTime);

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
		dataBinder.registerBinding("name", String.class, this.txtname, "text");
		dataBinder.registerBinding("companyOrg", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompanyOrg, "data");
		dataBinder.registerBinding("status", com.kingdee.eas.custom.salaryvoucher.voucherStatus.class, this.status, "selectedItem");
		dataBinder.registerBinding("PeriodDeviationValue", int.class, this.txtPeriodDeviationValue, "value");
		dataBinder.registerBinding("voucherType", com.kingdee.eas.basedata.assistant.VoucherTypeInfo.class, this.prmtvoucherType, "data");
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.custom.salaryvoucher.SalaryVoucherEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.debitOrCredit", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "debitOrCredit.text");
		dataBinder.registerBinding("entrys.abstactInfo", String.class, this.kdtEntrys, "abstactInfo.text");
		dataBinder.registerBinding("entrys.Accounting", java.lang.Object.class, this.kdtEntrys, "Accounting.text");
		dataBinder.registerBinding("entrys.scaleScheme", java.lang.Object.class, this.kdtEntrys, "scaleScheme.text");
		dataBinder.registerBinding("entrys.CmpItem.seq", int.class, this.kdtCmpItem, "seq.text");
		dataBinder.registerBinding("entrys.CmpItem", com.kingdee.eas.custom.salaryvoucher.SalaryVoucherEntryCmpItemInfo.class, this.kdtCmpItem, "userObject");
		dataBinder.registerBinding("entrys.CmpItem.cmpItemNum", java.lang.Object.class, this.kdtCmpItem, "cmpItemNum.text");
		dataBinder.registerBinding("entrys.CmpItem.cmpItemName", String.class, this.kdtCmpItem, "cmpItemName.text");
		dataBinder.registerBinding("entrys.CmpItem.cmpItemCode", String.class, this.kdtCmpItem, "cmpItemCode.text");
		dataBinder.registerBinding("entrys.AssistActItem.seq", int.class, this.kdtAssistActItem, "seq.text");
		dataBinder.registerBinding("entrys.AssistActItem", com.kingdee.eas.custom.salaryvoucher.SalaryVoucherEntryAssistActItemInfo.class, this.kdtAssistActItem, "userObject");
		dataBinder.registerBinding("entrys.AssistActItem.assistActItemNum", String.class, this.kdtAssistActItem, "assistActItemNum.text");
		dataBinder.registerBinding("entrys.AssistActItem.assistActItemName", String.class, this.kdtAssistActItem, "assistActItemName.text");
		dataBinder.registerBinding("Person.seq", int.class, this.kdtPerson, "seq.text");
		dataBinder.registerBinding("Person", com.kingdee.eas.custom.salaryvoucher.SalaryVoucherPersonInfo.class, this.kdtPerson, "userObject");
		dataBinder.registerBinding("Person.selected", boolean.class, this.kdtPerson, "selected.text");
		dataBinder.registerBinding("Person.number", java.lang.Object.class, this.kdtPerson, "number.text");
		dataBinder.registerBinding("Person.name", String.class, this.kdtPerson, "name.text");
		dataBinder.registerBinding("Person.shrPersonNum", String.class, this.kdtPerson, "shrPersonNum.text");
		dataBinder.registerBinding("Person.shrPersonName", String.class, this.kdtPerson, "shrPersonName.text");
		dataBinder.registerBinding("Person.GreenDreamProject", java.lang.Object.class, this.kdtPerson, "GreenDreamProject.text");
		dataBinder.registerBinding("Person.GreenDreamProjectCode", String.class, this.kdtPerson, "GreenDreamProjectCode.text");
		dataBinder.registerBinding("Person.GreenDreamProjectName", String.class, this.kdtPerson, "GreenDreamProjectName.text");
		dataBinder.registerBinding("AuditTime", java.util.Date.class, this.pkAuditTime, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.salaryvoucher.app.SalaryVoucherEditUIHandler";
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
        this.kdtAssistActItem.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.salaryvoucher.SalaryVoucherInfo)ov;
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
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("companyOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("status", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PeriodDeviationValue", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("voucherType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.debitOrCredit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.abstactInfo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Accounting", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.scaleScheme", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.CmpItem.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.CmpItem", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.CmpItem.cmpItemNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.CmpItem.cmpItemName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.CmpItem.cmpItemCode", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.AssistActItem.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.AssistActItem", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.AssistActItem.assistActItemNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.AssistActItem.assistActItemName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Person.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Person", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Person.selected", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Person.number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Person.name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Person.shrPersonNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Person.shrPersonName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Person.GreenDreamProject", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Person.GreenDreamProjectCode", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Person.GreenDreamProjectName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AuditTime", ValidateHelper.ON_SAVE);    		
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
     * output kdtCmpItem_Changed(int rowIndex,int colIndex) method
     */
    public void kdtCmpItem_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("cmpItemNum".equalsIgnoreCase(kdtCmpItem.getColumn(colIndex).getKey())) {
kdtCmpItem.getCell(rowIndex,"cmpItemName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtCmpItem.getCell(rowIndex,"cmpItemNum").getValue(),"name")));

}

    if ("cmpItemNum".equalsIgnoreCase(kdtCmpItem.getColumn(colIndex).getKey())) {
kdtCmpItem.getCell(rowIndex,"cmpItemCode").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtCmpItem.getCell(rowIndex,"cmpItemNum").getValue(),"number")));

}


    }

    /**
     * output kdtPerson_Changed(int rowIndex,int colIndex) method
     */
    public void kdtPerson_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("number".equalsIgnoreCase(kdtPerson.getColumn(colIndex).getKey())) {
kdtPerson.setName(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtPerson.getCell(rowIndex,"number").getValue(),"name")));

}

    if ("GreenDreamProject".equalsIgnoreCase(kdtPerson.getColumn(colIndex).getKey())) {
kdtPerson.getCell(rowIndex,"GreenDreamProjectCode").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtPerson.getCell(rowIndex,"GreenDreamProject").getValue(),"number")));

}

    if ("GreenDreamProject".equalsIgnoreCase(kdtPerson.getColumn(colIndex).getKey())) {
kdtPerson.getCell(rowIndex,"GreenDreamProjectName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtPerson.getCell(rowIndex,"GreenDreamProject").getValue(),"name")));

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
        sic.add(new SelectorItemInfo("name"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("companyOrg.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("companyOrg.id"));
        	sic.add(new SelectorItemInfo("companyOrg.number"));
        	sic.add(new SelectorItemInfo("companyOrg.name"));
		}
        sic.add(new SelectorItemInfo("status"));
        sic.add(new SelectorItemInfo("PeriodDeviationValue"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("voucherType.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("voucherType.id"));
        	sic.add(new SelectorItemInfo("voucherType.number"));
        	sic.add(new SelectorItemInfo("voucherType.name"));
		}
    	sic.add(new SelectorItemInfo("entrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("entrys.debitOrCredit"));
    	sic.add(new SelectorItemInfo("entrys.abstactInfo"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.Accounting.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.Accounting.id"));
			sic.add(new SelectorItemInfo("entrys.Accounting.name"));
        	sic.add(new SelectorItemInfo("entrys.Accounting.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.scaleScheme.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.scaleScheme.id"));
			sic.add(new SelectorItemInfo("entrys.scaleScheme.name"));
        	sic.add(new SelectorItemInfo("entrys.scaleScheme.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.CmpItem.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.CmpItem.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.CmpItem.id"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.CmpItem.cmpItemNum.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.CmpItem.cmpItemNum.id"));
			sic.add(new SelectorItemInfo("entrys.CmpItem.cmpItemNum.number"));
			sic.add(new SelectorItemInfo("entrys.CmpItem.cmpItemNum.name"));
		}
    	sic.add(new SelectorItemInfo("entrys.CmpItem.cmpItemName"));
    	sic.add(new SelectorItemInfo("entrys.CmpItem.cmpItemCode"));
    	sic.add(new SelectorItemInfo("entrys.AssistActItem.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.AssistActItem.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.AssistActItem.id"));
		}
    	sic.add(new SelectorItemInfo("entrys.AssistActItem.assistActItemNum"));
    	sic.add(new SelectorItemInfo("entrys.AssistActItem.assistActItemName"));
    	sic.add(new SelectorItemInfo("Person.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Person.*"));
		}
		else{
			sic.add(new SelectorItemInfo("Person.name"));
        	sic.add(new SelectorItemInfo("Person.number"));
		}
    	sic.add(new SelectorItemInfo("Person.selected"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Person.number.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Person.number.id"));
			sic.add(new SelectorItemInfo("Person.number.number"));
			sic.add(new SelectorItemInfo("Person.number.name"));
		}
    	sic.add(new SelectorItemInfo("Person.shrPersonNum"));
    	sic.add(new SelectorItemInfo("Person.shrPersonName"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Person.GreenDreamProject.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Person.GreenDreamProject.id"));
			sic.add(new SelectorItemInfo("Person.GreenDreamProject.name"));
        	sic.add(new SelectorItemInfo("Person.GreenDreamProject.number"));
		}
    	sic.add(new SelectorItemInfo("Person.GreenDreamProjectCode"));
    	sic.add(new SelectorItemInfo("Person.GreenDreamProjectName"));
        sic.add(new SelectorItemInfo("AuditTime"));
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

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.salaryvoucher.client", "SalaryVoucherEditUI");
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
        return com.kingdee.eas.custom.salaryvoucher.client.SalaryVoucherEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.salaryvoucher.SalaryVoucherFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.salaryvoucher.SalaryVoucherInfo objectValue = new com.kingdee.eas.custom.salaryvoucher.SalaryVoucherInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/salaryvoucher/SalaryVoucher";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.salaryvoucher.app.SalaryVoucherQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtNumber.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"单据编号"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtvoucherType.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"凭证类型"});
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"abstactInfo").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"摘要"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"scaleScheme").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"薪酬方案"});
			}
		}
		for (int i=0,n=kdtCmpItem.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtCmpItem.getCell(i,"cmpItemNum").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"薪酬项目编码"});
			}
		}
		for (int i=0,n=kdtCmpItem.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtCmpItem.getCell(i,"cmpItemName").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"薪酬项目名称"});
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
		vo.put("status","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}