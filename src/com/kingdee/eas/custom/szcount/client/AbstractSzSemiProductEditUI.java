/**
 * output package name
 */
package com.kingdee.eas.custom.szcount.client;

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
public abstract class AbstractSzSemiProductEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSzSemiProductEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contclasses;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthouseName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contproductionDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkwhetherProduction;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstation;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttimeLong;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDComboBox status;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperson;
    protected com.kingdee.bos.ctrl.swing.KDComboBox count;
    protected com.kingdee.bos.ctrl.swing.KDComboBox classes;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmthouseName;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkproductionDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstation;
    protected com.kingdee.bos.ctrl.swing.KDTextField txttimeLong;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton audit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton unaudit;
    protected com.kingdee.eas.custom.szcount.SzSemiProductInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnaudit actionUnaudit = null;
    protected ActionCountInterface actionCountInterface = null;
    /**
     * output class constructor
     */
    public AbstractSzSemiProductEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractSzSemiProductEditUI.class.getName());
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
        //actionCountInterface
        this.actionCountInterface = new ActionCountInterface(this);
        getActionManager().registerAction("actionCountInterface", actionCountInterface);
        this.actionCountInterface.setExtendProperty("canForewarn", "true");
        this.actionCountInterface.setExtendProperty("userDefined", "true");
        this.actionCountInterface.setExtendProperty("isObjectUpdateLock", "false");
         this.actionCountInterface.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionCountInterface.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contstatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contclasses = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthouseName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contproductionDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkwhetherProduction = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contstation = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttimeLong = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.status = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtperson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.count = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.classes = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmthouseName = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkproductionDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtstation = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txttimeLong = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.audit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.unaudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.kdtEntrys.setName("kdtEntrys");
        this.contstatus.setName("contstatus");
        this.contperson.setName("contperson");
        this.contcount.setName("contcount");
        this.contclasses.setName("contclasses");
        this.conthouseName.setName("conthouseName");
        this.contauditTime.setName("contauditTime");
        this.contproductionDate.setName("contproductionDate");
        this.contcompany.setName("contcompany");
        this.chkwhetherProduction.setName("chkwhetherProduction");
        this.contstation.setName("contstation");
        this.conttimeLong.setName("conttimeLong");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.status.setName("status");
        this.prmtperson.setName("prmtperson");
        this.count.setName("count");
        this.classes.setName("classes");
        this.prmthouseName.setName("prmthouseName");
        this.pkauditTime.setName("pkauditTime");
        this.pkproductionDate.setName("pkproductionDate");
        this.prmtcompany.setName("prmtcompany");
        this.prmtstation.setName("prmtstation");
        this.txttimeLong.setName("txttimeLong");
        this.audit.setName("audit");
        this.unaudit.setName("unaudit");
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
        this.contAuditor.setEnabled(false);		
        this.contAuditor.setVisible(false);
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"batch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"materialnumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"materialtype\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"mbaseunit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"measureUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"countNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"weight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"finishedProductType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"wareHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"CostObject\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{batch}</t:Cell><t:Cell>$Resource{materialnumber}</t:Cell><t:Cell>$Resource{materialtype}</t:Cell><t:Cell>$Resource{mbaseunit}</t:Cell><t:Cell>$Resource{measureUnit}</t:Cell><t:Cell>$Resource{countNumber}</t:Cell><t:Cell>$Resource{weight}</t:Cell><t:Cell>$Resource{finishedProductType}</t:Cell><t:Cell>$Resource{wareHouse}</t:Cell><t:Cell>$Resource{CostObject}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtEntrys.putBindContents("editData",new String[] {"id","material","batch","materialnumber","materialtype","mbaseunit","measureUnit","countNumber","weight","finishedProductType","wareHouse","CostObject"});


        this.kdtEntrys.checkParsed();
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
        KDTextField kdtEntrys_batch_TextField = new KDTextField();
        kdtEntrys_batch_TextField.setName("kdtEntrys_batch_TextField");
        kdtEntrys_batch_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_batch_CellEditor = new KDTDefaultCellEditor(kdtEntrys_batch_TextField);
        this.kdtEntrys.getColumn("batch").setEditor(kdtEntrys_batch_CellEditor);
        KDTextField kdtEntrys_materialnumber_TextField = new KDTextField();
        kdtEntrys_materialnumber_TextField.setName("kdtEntrys_materialnumber_TextField");
        kdtEntrys_materialnumber_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_materialnumber_CellEditor = new KDTDefaultCellEditor(kdtEntrys_materialnumber_TextField);
        this.kdtEntrys.getColumn("materialnumber").setEditor(kdtEntrys_materialnumber_CellEditor);
        KDTextField kdtEntrys_materialtype_TextField = new KDTextField();
        kdtEntrys_materialtype_TextField.setName("kdtEntrys_materialtype_TextField");
        kdtEntrys_materialtype_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_materialtype_CellEditor = new KDTDefaultCellEditor(kdtEntrys_materialtype_TextField);
        this.kdtEntrys.getColumn("materialtype").setEditor(kdtEntrys_materialtype_CellEditor);
        KDTextField kdtEntrys_mbaseunit_TextField = new KDTextField();
        kdtEntrys_mbaseunit_TextField.setName("kdtEntrys_mbaseunit_TextField");
        kdtEntrys_mbaseunit_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_mbaseunit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_mbaseunit_TextField);
        this.kdtEntrys.getColumn("mbaseunit").setEditor(kdtEntrys_mbaseunit_CellEditor);
        KDTextField kdtEntrys_measureUnit_TextField = new KDTextField();
        kdtEntrys_measureUnit_TextField.setName("kdtEntrys_measureUnit_TextField");
        kdtEntrys_measureUnit_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_measureUnit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_measureUnit_TextField);
        this.kdtEntrys.getColumn("measureUnit").setEditor(kdtEntrys_measureUnit_CellEditor);
        KDTextField kdtEntrys_countNumber_TextField = new KDTextField();
        kdtEntrys_countNumber_TextField.setName("kdtEntrys_countNumber_TextField");
        kdtEntrys_countNumber_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_countNumber_CellEditor = new KDTDefaultCellEditor(kdtEntrys_countNumber_TextField);
        this.kdtEntrys.getColumn("countNumber").setEditor(kdtEntrys_countNumber_CellEditor);
        KDFormattedTextField kdtEntrys_weight_TextField = new KDFormattedTextField();
        kdtEntrys_weight_TextField.setName("kdtEntrys_weight_TextField");
        kdtEntrys_weight_TextField.setVisible(true);
        kdtEntrys_weight_TextField.setEditable(true);
        kdtEntrys_weight_TextField.setHorizontalAlignment(2);
        kdtEntrys_weight_TextField.setDataType(1);
        	kdtEntrys_weight_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_weight_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_weight_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_weight_CellEditor = new KDTDefaultCellEditor(kdtEntrys_weight_TextField);
        this.kdtEntrys.getColumn("weight").setEditor(kdtEntrys_weight_CellEditor);
        KDTextField kdtEntrys_finishedProductType_TextField = new KDTextField();
        kdtEntrys_finishedProductType_TextField.setName("kdtEntrys_finishedProductType_TextField");
        kdtEntrys_finishedProductType_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_finishedProductType_CellEditor = new KDTDefaultCellEditor(kdtEntrys_finishedProductType_TextField);
        this.kdtEntrys.getColumn("finishedProductType").setEditor(kdtEntrys_finishedProductType_CellEditor);
        final KDBizPromptBox kdtEntrys_wareHouse_PromptBox = new KDBizPromptBox();
        kdtEntrys_wareHouse_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7AllWarehouseQuery");
        kdtEntrys_wareHouse_PromptBox.setVisible(true);
        kdtEntrys_wareHouse_PromptBox.setEditable(true);
        kdtEntrys_wareHouse_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_wareHouse_PromptBox.setEditFormat("$number$");
        kdtEntrys_wareHouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_wareHouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_wareHouse_PromptBox);
        this.kdtEntrys.getColumn("wareHouse").setEditor(kdtEntrys_wareHouse_CellEditor);
        ObjectValueRender kdtEntrys_wareHouse_OVR = new ObjectValueRender();
        kdtEntrys_wareHouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("wareHouse").setRenderer(kdtEntrys_wareHouse_OVR);
        final KDBizPromptBox kdtEntrys_CostObject_PromptBox = new KDBizPromptBox();
        kdtEntrys_CostObject_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");
        kdtEntrys_CostObject_PromptBox.setVisible(true);
        kdtEntrys_CostObject_PromptBox.setEditable(true);
        kdtEntrys_CostObject_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_CostObject_PromptBox.setEditFormat("$number$");
        kdtEntrys_CostObject_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_CostObject_CellEditor = new KDTDefaultCellEditor(kdtEntrys_CostObject_PromptBox);
        this.kdtEntrys.getColumn("CostObject").setEditor(kdtEntrys_CostObject_CellEditor);
        ObjectValueRender kdtEntrys_CostObject_OVR = new ObjectValueRender();
        kdtEntrys_CostObject_OVR.setFormat(new BizDataFormat("$calculateMode$"));
        this.kdtEntrys.getColumn("CostObject").setRenderer(kdtEntrys_CostObject_OVR);
        // contstatus		
        this.contstatus.setBoundLabelText(resHelper.getString("contstatus.boundLabelText"));		
        this.contstatus.setBoundLabelLength(100);		
        this.contstatus.setBoundLabelUnderline(true);		
        this.contstatus.setVisible(true);
        // contperson		
        this.contperson.setBoundLabelText(resHelper.getString("contperson.boundLabelText"));		
        this.contperson.setBoundLabelLength(100);		
        this.contperson.setBoundLabelUnderline(true);		
        this.contperson.setVisible(true);
        // contcount		
        this.contcount.setBoundLabelText(resHelper.getString("contcount.boundLabelText"));		
        this.contcount.setBoundLabelLength(100);		
        this.contcount.setBoundLabelUnderline(true);		
        this.contcount.setVisible(true);
        // contclasses		
        this.contclasses.setBoundLabelText(resHelper.getString("contclasses.boundLabelText"));		
        this.contclasses.setBoundLabelLength(100);		
        this.contclasses.setBoundLabelUnderline(true);		
        this.contclasses.setVisible(true);
        // conthouseName		
        this.conthouseName.setBoundLabelText(resHelper.getString("conthouseName.boundLabelText"));		
        this.conthouseName.setBoundLabelLength(100);		
        this.conthouseName.setBoundLabelUnderline(true);		
        this.conthouseName.setVisible(false);
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(false);
        // contproductionDate		
        this.contproductionDate.setBoundLabelText(resHelper.getString("contproductionDate.boundLabelText"));		
        this.contproductionDate.setBoundLabelLength(100);		
        this.contproductionDate.setBoundLabelUnderline(true);		
        this.contproductionDate.setVisible(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // chkwhetherProduction		
        this.chkwhetherProduction.setText(resHelper.getString("chkwhetherProduction.text"));		
        this.chkwhetherProduction.setHorizontalAlignment(2);
        // contstation		
        this.contstation.setBoundLabelText(resHelper.getString("contstation.boundLabelText"));		
        this.contstation.setBoundLabelLength(100);		
        this.contstation.setBoundLabelUnderline(true);		
        this.contstation.setVisible(true);
        // conttimeLong		
        this.conttimeLong.setBoundLabelText(resHelper.getString("conttimeLong.boundLabelText"));		
        this.conttimeLong.setBoundLabelLength(100);		
        this.conttimeLong.setBoundLabelUnderline(true);		
        this.conttimeLong.setVisible(false);
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
        // status		
        this.status.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.status.setRequired(false);		
        this.status.setEnabled(false);
        // prmtperson		
        this.prmtperson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonFilterQuery");		
        this.prmtperson.setEditable(true);		
        this.prmtperson.setDisplayFormat("$name$");		
        this.prmtperson.setEditFormat("$number$");		
        this.prmtperson.setCommitFormat("$number$");		
        this.prmtperson.setRequired(false);		
        this.prmtperson.setEnabled(false);
        // count		
        this.count.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.szcount.szCountSet").toArray());		
        this.count.setRequired(false);
        // classes		
        this.classes.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.szcount.szClasses").toArray());		
        this.classes.setRequired(false);
        // prmthouseName		
        this.prmthouseName.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.WarehouseQuery");		
        this.prmthouseName.setEditable(true);		
        this.prmthouseName.setDisplayFormat("$name$");		
        this.prmthouseName.setEditFormat("$number$");		
        this.prmthouseName.setCommitFormat("$number$");		
        this.prmthouseName.setRequired(false);
        // pkauditTime		
        this.pkauditTime.setRequired(false);
        // pkproductionDate		
        this.pkproductionDate.setRequired(false);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(false);
        // prmtstation		
        this.prmtstation.setQueryInfo("com.kingdee.eas.custom.szcount.app.SzCountPositionSetQuery");		
        this.prmtstation.setVisible(true);		
        this.prmtstation.setEditable(true);		
        this.prmtstation.setDisplayFormat("$name$");		
        this.prmtstation.setEditFormat("$number$");		
        this.prmtstation.setCommitFormat("$number$");		
        this.prmtstation.setRequired(false);
        		prmtstation.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.custom.szcount.client.SzCountPositionSetListUI prmtstation_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtstation_F7ListUI == null) {
					try {
						prmtstation_F7ListUI = new com.kingdee.eas.custom.szcount.client.SzCountPositionSetListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtstation_F7ListUI));
					prmtstation_F7ListUI.setF7Use(true,ctx);
					prmtstation.setSelector(prmtstation_F7ListUI);
				}
			}
		});
					
        // txttimeLong		
        this.txttimeLong.setVisible(true);		
        this.txttimeLong.setHorizontalAlignment(2);		
        this.txttimeLong.setMaxLength(100);		
        this.txttimeLong.setRequired(false);
        // audit
        this.audit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.audit.setText(resHelper.getString("audit.text"));
        // unaudit
        this.unaudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnaudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.unaudit.setText(resHelper.getString("unaudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,status,prmtperson,count,classes,prmthouseName,pkauditTime,pkproductionDate,prmtcompany,chkwhetherProduction,kdtEntrys,prmtstation,txttimeLong}));
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
        this.setBounds(new Rectangle(0, 0, 1027, 639));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1027, 639));
        contCreator.setBounds(new Rectangle(377, 524, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(377, 524, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(730, 524, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(730, 524, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(377, 555, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(377, 555, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(730, 555, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(730, 555, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(21, 54, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(21, 54, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(367, 54, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(367, 54, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(13, -430, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(13, -430, 270, 19, 0));
        contAuditor.setBounds(new Rectangle(15, 528, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(15, 528, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(12, 187, 991, 316));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.custom.szcount.SzSemiProductEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(12, 187, 991, 316, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contstatus.setBounds(new Rectangle(21, 94, 270, 19));
        this.add(contstatus, new KDLayout.Constraints(21, 94, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contperson.setBounds(new Rectangle(21, 134, 270, 19));
        this.add(contperson, new KDLayout.Constraints(21, 134, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcount.setBounds(new Rectangle(705, 134, 270, 19));
        this.add(contcount, new KDLayout.Constraints(705, 134, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contclasses.setBounds(new Rectangle(375, 590, 270, 19));
        this.add(contclasses, new KDLayout.Constraints(375, 590, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conthouseName.setBounds(new Rectangle(689, 8, 270, 19));
        this.add(conthouseName, new KDLayout.Constraints(689, 8, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contauditTime.setBounds(new Rectangle(15, 555, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(15, 555, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contproductionDate.setBounds(new Rectangle(367, 94, 270, 19));
        this.add(contproductionDate, new KDLayout.Constraints(367, 94, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompany.setBounds(new Rectangle(705, 54, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(705, 54, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkwhetherProduction.setBounds(new Rectangle(705, 94, 270, 19));
        this.add(chkwhetherProduction, new KDLayout.Constraints(705, 94, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contstation.setBounds(new Rectangle(367, 134, 270, 19));
        this.add(contstation, new KDLayout.Constraints(367, 134, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttimeLong.setBounds(new Rectangle(368, 12, 270, 19));
        this.add(conttimeLong, new KDLayout.Constraints(368, 12, 270, 19, 0));
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
        //contstatus
        contstatus.setBoundEditor(status);
        //contperson
        contperson.setBoundEditor(prmtperson);
        //contcount
        contcount.setBoundEditor(count);
        //contclasses
        contclasses.setBoundEditor(classes);
        //conthouseName
        conthouseName.setBoundEditor(prmthouseName);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contproductionDate
        contproductionDate.setBoundEditor(pkproductionDate);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contstation
        contstation.setBoundEditor(prmtstation);
        //conttimeLong
        conttimeLong.setBoundEditor(txttimeLong);

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
        this.toolBar.add(btnVoucher);
        this.toolBar.add(btnPCVoucher);
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnDelPCVoucher);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(btnNextPerson);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.custom.szcount.SzSemiProductEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.material", java.lang.Object.class, this.kdtEntrys, "material.text");
		dataBinder.registerBinding("entrys.batch", String.class, this.kdtEntrys, "batch.text");
		dataBinder.registerBinding("entrys.materialnumber", String.class, this.kdtEntrys, "materialnumber.text");
		dataBinder.registerBinding("entrys.materialtype", String.class, this.kdtEntrys, "materialtype.text");
		dataBinder.registerBinding("entrys.mbaseunit", String.class, this.kdtEntrys, "mbaseunit.text");
		dataBinder.registerBinding("entrys.weight", java.math.BigDecimal.class, this.kdtEntrys, "weight.text");
		dataBinder.registerBinding("entrys.finishedProductType", String.class, this.kdtEntrys, "finishedProductType.text");
		dataBinder.registerBinding("entrys.measureUnit", String.class, this.kdtEntrys, "measureUnit.text");
		dataBinder.registerBinding("entrys.wareHouse", java.lang.Object.class, this.kdtEntrys, "wareHouse.text");
		dataBinder.registerBinding("entrys.countNumber", String.class, this.kdtEntrys, "countNumber.text");
		dataBinder.registerBinding("entrys.CostObject", java.lang.Object.class, this.kdtEntrys, "CostObject.text");
		dataBinder.registerBinding("whetherProduction", boolean.class, this.chkwhetherProduction, "selected");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("status", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.status, "selectedItem");
		dataBinder.registerBinding("person", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtperson, "data");
		dataBinder.registerBinding("count", com.kingdee.eas.custom.szcount.szCountSet.class, this.count, "selectedItem");
		dataBinder.registerBinding("classes", com.kingdee.eas.custom.szcount.szClasses.class, this.classes, "selectedItem");
		dataBinder.registerBinding("houseName", com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo.class, this.prmthouseName, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("productionDate", java.util.Date.class, this.pkproductionDate, "value");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("station", com.kingdee.eas.custom.szcount.SzCountPositionSetInfo.class, this.prmtstation, "data");
		dataBinder.registerBinding("timeLong", String.class, this.txttimeLong, "text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.szcount.app.SzSemiProductEditUIHandler";
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
        this.editData = (com.kingdee.eas.custom.szcount.SzSemiProductInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.batch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.materialnumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.materialtype", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.mbaseunit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.weight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.finishedProductType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.measureUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.wareHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.countNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.CostObject", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("whetherProduction", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("status", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("person", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("count", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("classes", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("houseName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("productionDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("station", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("timeLong", ValidateHelper.ON_SAVE);    		
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
            if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"materialnumber").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"material").getValue(),"number")));

}

    if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"materialtype").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"material").getValue(),"model")));

}

    if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"mbaseunit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"material").getValue(),"baseUnit.name")));

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
			sic.add(new SelectorItemInfo("entrys.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.material.id"));
			sic.add(new SelectorItemInfo("entrys.material.name"));
        	sic.add(new SelectorItemInfo("entrys.material.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.batch"));
    	sic.add(new SelectorItemInfo("entrys.materialnumber"));
    	sic.add(new SelectorItemInfo("entrys.materialtype"));
    	sic.add(new SelectorItemInfo("entrys.mbaseunit"));
    	sic.add(new SelectorItemInfo("entrys.weight"));
    	sic.add(new SelectorItemInfo("entrys.finishedProductType"));
    	sic.add(new SelectorItemInfo("entrys.measureUnit"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.wareHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.wareHouse.id"));
			sic.add(new SelectorItemInfo("entrys.wareHouse.name"));
        	sic.add(new SelectorItemInfo("entrys.wareHouse.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.countNumber"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.CostObject.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.CostObject.id"));
			sic.add(new SelectorItemInfo("entrys.CostObject.calculateMode"));
			sic.add(new SelectorItemInfo("entrys.CostObject.name"));
        	sic.add(new SelectorItemInfo("entrys.CostObject.number"));
		}
        sic.add(new SelectorItemInfo("whetherProduction"));
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
        sic.add(new SelectorItemInfo("status"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("person.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("person.id"));
        	sic.add(new SelectorItemInfo("person.number"));
        	sic.add(new SelectorItemInfo("person.name"));
		}
        sic.add(new SelectorItemInfo("count"));
        sic.add(new SelectorItemInfo("classes"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("houseName.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("houseName.id"));
        	sic.add(new SelectorItemInfo("houseName.number"));
        	sic.add(new SelectorItemInfo("houseName.name"));
		}
        sic.add(new SelectorItemInfo("auditTime"));
        sic.add(new SelectorItemInfo("productionDate"));
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
			sic.add(new SelectorItemInfo("station.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("station.id"));
        	sic.add(new SelectorItemInfo("station.number"));
        	sic.add(new SelectorItemInfo("station.name"));
		}
        sic.add(new SelectorItemInfo("timeLong"));
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
        com.kingdee.eas.custom.szcount.SzSemiProductFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnaudit_actionPerformed method
     */
    public void actionUnaudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.szcount.SzSemiProductFactory.getRemoteInstance().unaudit(editData);
    }
    	

    /**
     * output actionCountInterface_actionPerformed method
     */
    public void actionCountInterface_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.szcount.SzSemiProductFactory.getRemoteInstance().countInterface(editData);
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
	public RequestContext prepareActionCountInterface(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionCountInterface() {
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
            innerActionPerformed("eas", AbstractSzSemiProductEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractSzSemiProductEditUI.this, "ActionUnaudit", "actionUnaudit_actionPerformed", e);
        }
    }

    /**
     * output ActionCountInterface class
     */     
    protected class ActionCountInterface extends ItemAction {     
    
        public ActionCountInterface()
        {
            this(null);
        }

        public ActionCountInterface(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionCountInterface.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCountInterface.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCountInterface.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractSzSemiProductEditUI.this, "ActionCountInterface", "actionCountInterface_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.szcount.client", "SzSemiProductEditUI");
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
        return com.kingdee.eas.custom.szcount.client.SzSemiProductEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.szcount.SzSemiProductFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.szcount.SzSemiProductInfo objectValue = new com.kingdee.eas.custom.szcount.SzSemiProductInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/szcount/SzSemiProduct";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.szcount.app.SzSemiProductQuery");
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
		vo.put("status",new Integer(-1));
vo.put("count","0");
vo.put("classes","01");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}