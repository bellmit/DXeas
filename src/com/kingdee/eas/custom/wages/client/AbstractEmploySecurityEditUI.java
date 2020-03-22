/**
 * output package name
 */
package com.kingdee.eas.custom.wages.client;

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
public abstract class AbstractEmploySecurityEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractEmploySecurityEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBillStatus;
    protected com.kingdee.bos.ctrl.swing.KDButton importEx;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contname;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDComboBox BillStatus;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtname;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton audit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton unaudit;
    protected com.kingdee.eas.custom.wages.EmploySecurityInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnaudit actionUnaudit = null;
    protected actionImportEx ActionImportEx = null;
    /**
     * output class constructor
     */
    public AbstractEmploySecurityEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractEmploySecurityEditUI.class.getName());
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
        //ActionImportEx
        this.ActionImportEx = new actionImportEx(this);
        getActionManager().registerAction("ActionImportEx", ActionImportEx);
         this.ActionImportEx.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contBillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.importEx = new com.kingdee.bos.ctrl.swing.KDButton();
        this.contname = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.BillStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtname = new com.kingdee.bos.ctrl.swing.KDTextField();
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
        this.contBillStatus.setName("contBillStatus");
        this.importEx.setName("importEx");
        this.contname.setName("contname");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.BillStatus.setName("BillStatus");
        this.txtname.setName("txtname");
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
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"person\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"personnumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"department\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"post\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"sbbh\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"cbyf\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"htkssj\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"htdqsj\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"card\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"jfjs\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"jfyf\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"sydwbl\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"yldwbl\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"ylgrbl\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"yiliaodwbl\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"grdwbl\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"gsdwbl\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"shiyedwbl\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"sygrbl\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"grdeyl\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"dwdeyl\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"grbjwnyl\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"dwyjf\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"gryjf\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"dwjn\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{person}</t:Cell><t:Cell>$Resource{personnumber}</t:Cell><t:Cell>$Resource{department}</t:Cell><t:Cell>$Resource{post}</t:Cell><t:Cell>$Resource{sbbh}</t:Cell><t:Cell>$Resource{cbyf}</t:Cell><t:Cell>$Resource{htkssj}</t:Cell><t:Cell>$Resource{htdqsj}</t:Cell><t:Cell>$Resource{card}</t:Cell><t:Cell>$Resource{jfjs}</t:Cell><t:Cell>$Resource{jfyf}</t:Cell><t:Cell>$Resource{sydwbl}</t:Cell><t:Cell>$Resource{yldwbl}</t:Cell><t:Cell>$Resource{ylgrbl}</t:Cell><t:Cell>$Resource{yiliaodwbl}</t:Cell><t:Cell>$Resource{grdwbl}</t:Cell><t:Cell>$Resource{gsdwbl}</t:Cell><t:Cell>$Resource{shiyedwbl}</t:Cell><t:Cell>$Resource{sygrbl}</t:Cell><t:Cell>$Resource{grdeyl}</t:Cell><t:Cell>$Resource{dwdeyl}</t:Cell><t:Cell>$Resource{grbjwnyl}</t:Cell><t:Cell>$Resource{dwyjf}</t:Cell><t:Cell>$Resource{gryjf}</t:Cell><t:Cell>$Resource{dwjn}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtEntrys.putBindContents("editData",new String[] {"id","person","personnumber","department","post","sbbh","cbyf","htkssj","htdqsj","card","jfjs","jfyf","sydwbl","yldwbl","ylgrbl","yiliaodwbl","grdwbl","gsdwbl","shiyedwbl","sygrbl","grdeyl","dwdeyl","grbjwnyl","dwyjf","gryjf","dwjn"});


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
        KDTextField kdtEntrys_personnumber_TextField = new KDTextField();
        kdtEntrys_personnumber_TextField.setName("kdtEntrys_personnumber_TextField");
        kdtEntrys_personnumber_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_personnumber_CellEditor = new KDTDefaultCellEditor(kdtEntrys_personnumber_TextField);
        this.kdtEntrys.getColumn("personnumber").setEditor(kdtEntrys_personnumber_CellEditor);
        KDTextField kdtEntrys_department_TextField = new KDTextField();
        kdtEntrys_department_TextField.setName("kdtEntrys_department_TextField");
        kdtEntrys_department_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_department_CellEditor = new KDTDefaultCellEditor(kdtEntrys_department_TextField);
        this.kdtEntrys.getColumn("department").setEditor(kdtEntrys_department_CellEditor);
        KDTextField kdtEntrys_post_TextField = new KDTextField();
        kdtEntrys_post_TextField.setName("kdtEntrys_post_TextField");
        kdtEntrys_post_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_post_CellEditor = new KDTDefaultCellEditor(kdtEntrys_post_TextField);
        this.kdtEntrys.getColumn("post").setEditor(kdtEntrys_post_CellEditor);
        KDTextField kdtEntrys_sbbh_TextField = new KDTextField();
        kdtEntrys_sbbh_TextField.setName("kdtEntrys_sbbh_TextField");
        kdtEntrys_sbbh_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_sbbh_CellEditor = new KDTDefaultCellEditor(kdtEntrys_sbbh_TextField);
        this.kdtEntrys.getColumn("sbbh").setEditor(kdtEntrys_sbbh_CellEditor);
        KDTextField kdtEntrys_cbyf_TextField = new KDTextField();
        kdtEntrys_cbyf_TextField.setName("kdtEntrys_cbyf_TextField");
        kdtEntrys_cbyf_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_cbyf_CellEditor = new KDTDefaultCellEditor(kdtEntrys_cbyf_TextField);
        this.kdtEntrys.getColumn("cbyf").setEditor(kdtEntrys_cbyf_CellEditor);
        KDTextField kdtEntrys_htkssj_TextField = new KDTextField();
        kdtEntrys_htkssj_TextField.setName("kdtEntrys_htkssj_TextField");
        kdtEntrys_htkssj_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_htkssj_CellEditor = new KDTDefaultCellEditor(kdtEntrys_htkssj_TextField);
        this.kdtEntrys.getColumn("htkssj").setEditor(kdtEntrys_htkssj_CellEditor);
        KDTextField kdtEntrys_htdqsj_TextField = new KDTextField();
        kdtEntrys_htdqsj_TextField.setName("kdtEntrys_htdqsj_TextField");
        kdtEntrys_htdqsj_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_htdqsj_CellEditor = new KDTDefaultCellEditor(kdtEntrys_htdqsj_TextField);
        this.kdtEntrys.getColumn("htdqsj").setEditor(kdtEntrys_htdqsj_CellEditor);
        KDTextField kdtEntrys_card_TextField = new KDTextField();
        kdtEntrys_card_TextField.setName("kdtEntrys_card_TextField");
        kdtEntrys_card_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_card_CellEditor = new KDTDefaultCellEditor(kdtEntrys_card_TextField);
        this.kdtEntrys.getColumn("card").setEditor(kdtEntrys_card_CellEditor);
        KDTextField kdtEntrys_jfjs_TextField = new KDTextField();
        kdtEntrys_jfjs_TextField.setName("kdtEntrys_jfjs_TextField");
        kdtEntrys_jfjs_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_jfjs_CellEditor = new KDTDefaultCellEditor(kdtEntrys_jfjs_TextField);
        this.kdtEntrys.getColumn("jfjs").setEditor(kdtEntrys_jfjs_CellEditor);
        KDTextField kdtEntrys_jfyf_TextField = new KDTextField();
        kdtEntrys_jfyf_TextField.setName("kdtEntrys_jfyf_TextField");
        kdtEntrys_jfyf_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_jfyf_CellEditor = new KDTDefaultCellEditor(kdtEntrys_jfyf_TextField);
        this.kdtEntrys.getColumn("jfyf").setEditor(kdtEntrys_jfyf_CellEditor);
        KDTextField kdtEntrys_sydwbl_TextField = new KDTextField();
        kdtEntrys_sydwbl_TextField.setName("kdtEntrys_sydwbl_TextField");
        kdtEntrys_sydwbl_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_sydwbl_CellEditor = new KDTDefaultCellEditor(kdtEntrys_sydwbl_TextField);
        this.kdtEntrys.getColumn("sydwbl").setEditor(kdtEntrys_sydwbl_CellEditor);
        KDTextField kdtEntrys_yldwbl_TextField = new KDTextField();
        kdtEntrys_yldwbl_TextField.setName("kdtEntrys_yldwbl_TextField");
        kdtEntrys_yldwbl_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_yldwbl_CellEditor = new KDTDefaultCellEditor(kdtEntrys_yldwbl_TextField);
        this.kdtEntrys.getColumn("yldwbl").setEditor(kdtEntrys_yldwbl_CellEditor);
        KDTextField kdtEntrys_ylgrbl_TextField = new KDTextField();
        kdtEntrys_ylgrbl_TextField.setName("kdtEntrys_ylgrbl_TextField");
        kdtEntrys_ylgrbl_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_ylgrbl_CellEditor = new KDTDefaultCellEditor(kdtEntrys_ylgrbl_TextField);
        this.kdtEntrys.getColumn("ylgrbl").setEditor(kdtEntrys_ylgrbl_CellEditor);
        KDTextField kdtEntrys_yiliaodwbl_TextField = new KDTextField();
        kdtEntrys_yiliaodwbl_TextField.setName("kdtEntrys_yiliaodwbl_TextField");
        kdtEntrys_yiliaodwbl_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_yiliaodwbl_CellEditor = new KDTDefaultCellEditor(kdtEntrys_yiliaodwbl_TextField);
        this.kdtEntrys.getColumn("yiliaodwbl").setEditor(kdtEntrys_yiliaodwbl_CellEditor);
        KDTextField kdtEntrys_grdwbl_TextField = new KDTextField();
        kdtEntrys_grdwbl_TextField.setName("kdtEntrys_grdwbl_TextField");
        kdtEntrys_grdwbl_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_grdwbl_CellEditor = new KDTDefaultCellEditor(kdtEntrys_grdwbl_TextField);
        this.kdtEntrys.getColumn("grdwbl").setEditor(kdtEntrys_grdwbl_CellEditor);
        KDTextField kdtEntrys_gsdwbl_TextField = new KDTextField();
        kdtEntrys_gsdwbl_TextField.setName("kdtEntrys_gsdwbl_TextField");
        kdtEntrys_gsdwbl_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_gsdwbl_CellEditor = new KDTDefaultCellEditor(kdtEntrys_gsdwbl_TextField);
        this.kdtEntrys.getColumn("gsdwbl").setEditor(kdtEntrys_gsdwbl_CellEditor);
        KDTextField kdtEntrys_shiyedwbl_TextField = new KDTextField();
        kdtEntrys_shiyedwbl_TextField.setName("kdtEntrys_shiyedwbl_TextField");
        kdtEntrys_shiyedwbl_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_shiyedwbl_CellEditor = new KDTDefaultCellEditor(kdtEntrys_shiyedwbl_TextField);
        this.kdtEntrys.getColumn("shiyedwbl").setEditor(kdtEntrys_shiyedwbl_CellEditor);
        KDTextField kdtEntrys_sygrbl_TextField = new KDTextField();
        kdtEntrys_sygrbl_TextField.setName("kdtEntrys_sygrbl_TextField");
        kdtEntrys_sygrbl_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_sygrbl_CellEditor = new KDTDefaultCellEditor(kdtEntrys_sygrbl_TextField);
        this.kdtEntrys.getColumn("sygrbl").setEditor(kdtEntrys_sygrbl_CellEditor);
        KDTextField kdtEntrys_grdeyl_TextField = new KDTextField();
        kdtEntrys_grdeyl_TextField.setName("kdtEntrys_grdeyl_TextField");
        kdtEntrys_grdeyl_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_grdeyl_CellEditor = new KDTDefaultCellEditor(kdtEntrys_grdeyl_TextField);
        this.kdtEntrys.getColumn("grdeyl").setEditor(kdtEntrys_grdeyl_CellEditor);
        KDTextField kdtEntrys_dwdeyl_TextField = new KDTextField();
        kdtEntrys_dwdeyl_TextField.setName("kdtEntrys_dwdeyl_TextField");
        kdtEntrys_dwdeyl_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_dwdeyl_CellEditor = new KDTDefaultCellEditor(kdtEntrys_dwdeyl_TextField);
        this.kdtEntrys.getColumn("dwdeyl").setEditor(kdtEntrys_dwdeyl_CellEditor);
        KDTextField kdtEntrys_grbjwnyl_TextField = new KDTextField();
        kdtEntrys_grbjwnyl_TextField.setName("kdtEntrys_grbjwnyl_TextField");
        kdtEntrys_grbjwnyl_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_grbjwnyl_CellEditor = new KDTDefaultCellEditor(kdtEntrys_grbjwnyl_TextField);
        this.kdtEntrys.getColumn("grbjwnyl").setEditor(kdtEntrys_grbjwnyl_CellEditor);
        KDTextField kdtEntrys_dwyjf_TextField = new KDTextField();
        kdtEntrys_dwyjf_TextField.setName("kdtEntrys_dwyjf_TextField");
        kdtEntrys_dwyjf_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_dwyjf_CellEditor = new KDTDefaultCellEditor(kdtEntrys_dwyjf_TextField);
        this.kdtEntrys.getColumn("dwyjf").setEditor(kdtEntrys_dwyjf_CellEditor);
        KDTextField kdtEntrys_gryjf_TextField = new KDTextField();
        kdtEntrys_gryjf_TextField.setName("kdtEntrys_gryjf_TextField");
        kdtEntrys_gryjf_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_gryjf_CellEditor = new KDTDefaultCellEditor(kdtEntrys_gryjf_TextField);
        this.kdtEntrys.getColumn("gryjf").setEditor(kdtEntrys_gryjf_CellEditor);
        KDTextField kdtEntrys_dwjn_TextField = new KDTextField();
        kdtEntrys_dwjn_TextField.setName("kdtEntrys_dwjn_TextField");
        kdtEntrys_dwjn_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_dwjn_CellEditor = new KDTDefaultCellEditor(kdtEntrys_dwjn_TextField);
        this.kdtEntrys.getColumn("dwjn").setEditor(kdtEntrys_dwjn_CellEditor);
        // contBillStatus		
        this.contBillStatus.setBoundLabelText(resHelper.getString("contBillStatus.boundLabelText"));		
        this.contBillStatus.setBoundLabelLength(100);		
        this.contBillStatus.setBoundLabelUnderline(true);		
        this.contBillStatus.setVisible(true);
        // importEx
        this.importEx.setAction((IItemAction)ActionProxyFactory.getProxy(ActionImportEx, new Class[] { IItemAction.class }, getServiceContext()));		
        this.importEx.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgMenumodule_icon_finance"));
        // contname		
        this.contname.setBoundLabelText(resHelper.getString("contname.boundLabelText"));		
        this.contname.setBoundLabelLength(100);		
        this.contname.setBoundLabelUnderline(true);		
        this.contname.setVisible(true);
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
        this.txtNumber.setEnabled(false);
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
        // txtname		
        this.txtname.setVisible(true);		
        this.txtname.setHorizontalAlignment(2);		
        this.txtname.setMaxLength(100);		
        this.txtname.setRequired(false);
        // audit
        this.audit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.audit.setText(resHelper.getString("audit.text"));
        // unaudit
        this.unaudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnaudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.unaudit.setText(resHelper.getString("unaudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,BillStatus,kdtEntrys,txtname}));
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
        contCreator.setBounds(new Rectangle(381, 524, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(381, 524, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(730, 524, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(730, 524, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(381, 555, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(381, 555, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(730, 555, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(730, 555, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(15, 22, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(15, 22, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(351, 63, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(351, 63, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(727, 62, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(727, 62, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(15, 528, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(15, 528, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(12, 99, 991, 413));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.custom.wages.EmploySecurityEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(12, 99, 991, 413, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBillStatus.setBounds(new Rectangle(15, 64, 270, 19));
        this.add(contBillStatus, new KDLayout.Constraints(15, 64, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        importEx.setBounds(new Rectangle(664, 74, 20, 21));
        this.add(importEx, new KDLayout.Constraints(664, 74, 20, 21, 0));
        contname.setBounds(new Rectangle(352, 21, 270, 19));
        this.add(contname, new KDLayout.Constraints(352, 21, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contname
        contname.setBoundEditor(txtname);

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
		dataBinder.registerBinding("entrys", com.kingdee.eas.custom.wages.EmploySecurityEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.sbbh", String.class, this.kdtEntrys, "sbbh.text");
		dataBinder.registerBinding("entrys.cbyf", String.class, this.kdtEntrys, "cbyf.text");
		dataBinder.registerBinding("entrys.card", String.class, this.kdtEntrys, "card.text");
		dataBinder.registerBinding("entrys.jfjs", String.class, this.kdtEntrys, "jfjs.text");
		dataBinder.registerBinding("entrys.jfyf", String.class, this.kdtEntrys, "jfyf.text");
		dataBinder.registerBinding("entrys.sydwbl", String.class, this.kdtEntrys, "sydwbl.text");
		dataBinder.registerBinding("entrys.yldwbl", String.class, this.kdtEntrys, "yldwbl.text");
		dataBinder.registerBinding("entrys.yiliaodwbl", String.class, this.kdtEntrys, "yiliaodwbl.text");
		dataBinder.registerBinding("entrys.grdwbl", String.class, this.kdtEntrys, "grdwbl.text");
		dataBinder.registerBinding("entrys.gsdwbl", String.class, this.kdtEntrys, "gsdwbl.text");
		dataBinder.registerBinding("entrys.shiyedwbl", String.class, this.kdtEntrys, "shiyedwbl.text");
		dataBinder.registerBinding("entrys.grdeyl", String.class, this.kdtEntrys, "grdeyl.text");
		dataBinder.registerBinding("entrys.dwdeyl", String.class, this.kdtEntrys, "dwdeyl.text");
		dataBinder.registerBinding("entrys.grbjwnyl", String.class, this.kdtEntrys, "grbjwnyl.text");
		dataBinder.registerBinding("entrys.dwyjf", String.class, this.kdtEntrys, "dwyjf.text");
		dataBinder.registerBinding("entrys.gryjf", String.class, this.kdtEntrys, "gryjf.text");
		dataBinder.registerBinding("entrys.dwjn", String.class, this.kdtEntrys, "dwjn.text");
		dataBinder.registerBinding("entrys.sygrbl", String.class, this.kdtEntrys, "sygrbl.text");
		dataBinder.registerBinding("entrys.ylgrbl", String.class, this.kdtEntrys, "ylgrbl.text");
		dataBinder.registerBinding("entrys.department", String.class, this.kdtEntrys, "department.text");
		dataBinder.registerBinding("entrys.post", String.class, this.kdtEntrys, "post.text");
		dataBinder.registerBinding("entrys.htdqsj", String.class, this.kdtEntrys, "htdqsj.text");
		dataBinder.registerBinding("entrys.htkssj", String.class, this.kdtEntrys, "htkssj.text");
		dataBinder.registerBinding("entrys.person", java.lang.Object.class, this.kdtEntrys, "person.text");
		dataBinder.registerBinding("entrys.personnumber", String.class, this.kdtEntrys, "personnumber.text");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("BillStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.BillStatus, "selectedItem");
		dataBinder.registerBinding("name", String.class, this.txtname, "text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.wages.app.EmploySecurityEditUIHandler";
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
        this.editData = (com.kingdee.eas.custom.wages.EmploySecurityInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.sbbh", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.cbyf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.card", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.jfjs", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.jfyf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sydwbl", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.yldwbl", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.yiliaodwbl", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.grdwbl", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.gsdwbl", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.shiyedwbl", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.grdeyl", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.dwdeyl", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.grbjwnyl", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.dwyjf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.gryjf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.dwjn", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sygrbl", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.ylgrbl", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.department", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.post", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.htdqsj", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.htkssj", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.person", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.personnumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BillStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    		
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
            if ("person".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"personnumber").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"person").getValue(),"number")));

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
    	sic.add(new SelectorItemInfo("entrys.sbbh"));
    	sic.add(new SelectorItemInfo("entrys.cbyf"));
    	sic.add(new SelectorItemInfo("entrys.card"));
    	sic.add(new SelectorItemInfo("entrys.jfjs"));
    	sic.add(new SelectorItemInfo("entrys.jfyf"));
    	sic.add(new SelectorItemInfo("entrys.sydwbl"));
    	sic.add(new SelectorItemInfo("entrys.yldwbl"));
    	sic.add(new SelectorItemInfo("entrys.yiliaodwbl"));
    	sic.add(new SelectorItemInfo("entrys.grdwbl"));
    	sic.add(new SelectorItemInfo("entrys.gsdwbl"));
    	sic.add(new SelectorItemInfo("entrys.shiyedwbl"));
    	sic.add(new SelectorItemInfo("entrys.grdeyl"));
    	sic.add(new SelectorItemInfo("entrys.dwdeyl"));
    	sic.add(new SelectorItemInfo("entrys.grbjwnyl"));
    	sic.add(new SelectorItemInfo("entrys.dwyjf"));
    	sic.add(new SelectorItemInfo("entrys.gryjf"));
    	sic.add(new SelectorItemInfo("entrys.dwjn"));
    	sic.add(new SelectorItemInfo("entrys.sygrbl"));
    	sic.add(new SelectorItemInfo("entrys.ylgrbl"));
    	sic.add(new SelectorItemInfo("entrys.department"));
    	sic.add(new SelectorItemInfo("entrys.post"));
    	sic.add(new SelectorItemInfo("entrys.htdqsj"));
    	sic.add(new SelectorItemInfo("entrys.htkssj"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.person.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.person.id"));
			sic.add(new SelectorItemInfo("entrys.person.name"));
        	sic.add(new SelectorItemInfo("entrys.person.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.personnumber"));
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
        sic.add(new SelectorItemInfo("name"));
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
        com.kingdee.eas.custom.wages.EmploySecurityFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnaudit_actionPerformed method
     */
    public void actionUnaudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.wages.EmploySecurityFactory.getRemoteInstance().unaudit(editData);
    }
    	

    /**
     * output actionImportEx_actionPerformed method
     */
    public void actionImportEx_actionPerformed(ActionEvent e) throws Exception
    {
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
	public RequestContext prepareactionImportEx(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareactionImportEx() {
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
            innerActionPerformed("eas", AbstractEmploySecurityEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractEmploySecurityEditUI.this, "ActionUnaudit", "actionUnaudit_actionPerformed", e);
        }
    }

    /**
     * output actionImportEx class
     */     
    protected class actionImportEx extends ItemAction {     
    
        public actionImportEx()
        {
            this(null);
        }

        public actionImportEx(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("actionImportEx.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("actionImportEx.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("actionImportEx.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractEmploySecurityEditUI.this, "actionImportEx", "actionImportEx_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.wages.client", "EmploySecurityEditUI");
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
        return com.kingdee.eas.custom.wages.client.EmploySecurityEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.wages.EmploySecurityFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.wages.EmploySecurityInfo objectValue = new com.kingdee.eas.custom.wages.EmploySecurityInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/wages/EmploySecurity";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.wages.app.EmploySecurityQuery");
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
		vo.put("BillStatus",new Integer(-1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}