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
public abstract class AbstractInjuryinsuranceEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractInjuryinsuranceEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompanyOrg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsureAmount;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDComboBox BillStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompanyOrg;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsureAmount;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton audit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton unaudit;
    protected com.kingdee.eas.custom.wages.InjuryinsuranceInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnaudit actionUnaudit = null;
    protected actionImportEx ActionImportEx = null;
    /**
     * output class constructor
     */
    public AbstractInjuryinsuranceEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractInjuryinsuranceEditUI.class.getName());
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
        this.contcompanyOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsureAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.BillStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtcompanyOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtsureAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
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
        this.contcompanyOrg.setName("contcompanyOrg");
        this.contsureAmount.setName("contsureAmount");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.BillStatus.setName("BillStatus");
        this.prmtcompanyOrg.setName("prmtcompanyOrg");
        this.txtsureAmount.setName("txtsureAmount");
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
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol17\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol18\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol19\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol20\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"person\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"personName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"company\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"opentime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"site\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"accdescription\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"Hospital\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"curetime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"costtype\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"insurancetype\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"filingdate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"isAppraisal\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"AppraisalClient\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"jdjg\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"cuser\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"sjfzr\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"ClaimMethod\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"SureAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol19\" /><t:Column t:key=\"companyAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol20\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"casetype\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{person}</t:Cell><t:Cell>$Resource{personName}</t:Cell><t:Cell>$Resource{company}</t:Cell><t:Cell>$Resource{opentime}</t:Cell><t:Cell>$Resource{site}</t:Cell><t:Cell>$Resource{accdescription}</t:Cell><t:Cell>$Resource{Hospital}</t:Cell><t:Cell>$Resource{curetime}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{costtype}</t:Cell><t:Cell>$Resource{insurancetype}</t:Cell><t:Cell>$Resource{filingdate}</t:Cell><t:Cell>$Resource{isAppraisal}</t:Cell><t:Cell>$Resource{AppraisalClient}</t:Cell><t:Cell>$Resource{jdjg}</t:Cell><t:Cell>$Resource{cuser}</t:Cell><t:Cell>$Resource{sjfzr}</t:Cell><t:Cell>$Resource{ClaimMethod}</t:Cell><t:Cell>$Resource{SureAmount}</t:Cell><t:Cell>$Resource{companyAmount}</t:Cell><t:Cell>$Resource{remark}</t:Cell><t:Cell>$Resource{casetype}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtEntrys.putBindContents("editData",new String[] {"id","person","personName","company","opentime","site","accdescription","Hospital","curetime","amount","costtype","insurancetype","filingdate","isAppraisal","AppraisalClient","jdjg","cuser","sjfzr","ClaimMethod","SureAmount","companyAmount","remark","casetype"});


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
        kdtEntrys_person_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("person").setRenderer(kdtEntrys_person_OVR);
        KDTextField kdtEntrys_personName_TextField = new KDTextField();
        kdtEntrys_personName_TextField.setName("kdtEntrys_personName_TextField");
        kdtEntrys_personName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_personName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_personName_TextField);
        this.kdtEntrys.getColumn("personName").setEditor(kdtEntrys_personName_CellEditor);
        final KDBizPromptBox kdtEntrys_company_PromptBox = new KDBizPromptBox();
        kdtEntrys_company_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery4AsstAcct");
        kdtEntrys_company_PromptBox.setVisible(true);
        kdtEntrys_company_PromptBox.setEditable(true);
        kdtEntrys_company_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_company_PromptBox.setEditFormat("$number$");
        kdtEntrys_company_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_company_CellEditor = new KDTDefaultCellEditor(kdtEntrys_company_PromptBox);
        this.kdtEntrys.getColumn("company").setEditor(kdtEntrys_company_CellEditor);
        ObjectValueRender kdtEntrys_company_OVR = new ObjectValueRender();
        kdtEntrys_company_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("company").setRenderer(kdtEntrys_company_OVR);
        KDDatePicker kdtEntrys_opentime_DatePicker = new KDDatePicker();
        kdtEntrys_opentime_DatePicker.setName("kdtEntrys_opentime_DatePicker");
        kdtEntrys_opentime_DatePicker.setVisible(true);
        kdtEntrys_opentime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_opentime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_opentime_DatePicker);
        this.kdtEntrys.getColumn("opentime").setEditor(kdtEntrys_opentime_CellEditor);
        KDTextField kdtEntrys_site_TextField = new KDTextField();
        kdtEntrys_site_TextField.setName("kdtEntrys_site_TextField");
        kdtEntrys_site_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_site_CellEditor = new KDTDefaultCellEditor(kdtEntrys_site_TextField);
        this.kdtEntrys.getColumn("site").setEditor(kdtEntrys_site_CellEditor);
        KDTextArea kdtEntrys_accdescription_TextArea = new KDTextArea();
        kdtEntrys_accdescription_TextArea.setName("kdtEntrys_accdescription_TextArea");
        kdtEntrys_accdescription_TextArea.setMaxLength(255);
        KDTDefaultCellEditor kdtEntrys_accdescription_CellEditor = new KDTDefaultCellEditor(kdtEntrys_accdescription_TextArea);
        this.kdtEntrys.getColumn("accdescription").setEditor(kdtEntrys_accdescription_CellEditor);
        final KDBizPromptBox kdtEntrys_Hospital_PromptBox = new KDBizPromptBox();
        kdtEntrys_Hospital_PromptBox.setQueryInfo("com.kingdee.eas.custom.wages.app.HospitalQuery");
        kdtEntrys_Hospital_PromptBox.setVisible(true);
        kdtEntrys_Hospital_PromptBox.setEditable(true);
        kdtEntrys_Hospital_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_Hospital_PromptBox.setEditFormat("$number$");
        kdtEntrys_Hospital_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_Hospital_CellEditor = new KDTDefaultCellEditor(kdtEntrys_Hospital_PromptBox);
        this.kdtEntrys.getColumn("Hospital").setEditor(kdtEntrys_Hospital_CellEditor);
        ObjectValueRender kdtEntrys_Hospital_OVR = new ObjectValueRender();
        kdtEntrys_Hospital_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("Hospital").setRenderer(kdtEntrys_Hospital_OVR);
        KDDatePicker kdtEntrys_curetime_DatePicker = new KDDatePicker();
        kdtEntrys_curetime_DatePicker.setName("kdtEntrys_curetime_DatePicker");
        kdtEntrys_curetime_DatePicker.setVisible(true);
        kdtEntrys_curetime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_curetime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_curetime_DatePicker);
        this.kdtEntrys.getColumn("curetime").setEditor(kdtEntrys_curetime_CellEditor);
        KDFormattedTextField kdtEntrys_amount_TextField = new KDFormattedTextField();
        kdtEntrys_amount_TextField.setName("kdtEntrys_amount_TextField");
        kdtEntrys_amount_TextField.setVisible(true);
        kdtEntrys_amount_TextField.setEditable(true);
        kdtEntrys_amount_TextField.setHorizontalAlignment(2);
        kdtEntrys_amount_TextField.setDataType(1);
        	kdtEntrys_amount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_amount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_amount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_amount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_amount_TextField);
        this.kdtEntrys.getColumn("amount").setEditor(kdtEntrys_amount_CellEditor);
        KDComboBox kdtEntrys_costtype_ComboBox = new KDComboBox();
        kdtEntrys_costtype_ComboBox.setName("kdtEntrys_costtype_ComboBox");
        kdtEntrys_costtype_ComboBox.setVisible(true);
        kdtEntrys_costtype_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.wages.Costtype").toArray());
        KDTDefaultCellEditor kdtEntrys_costtype_CellEditor = new KDTDefaultCellEditor(kdtEntrys_costtype_ComboBox);
        this.kdtEntrys.getColumn("costtype").setEditor(kdtEntrys_costtype_CellEditor);
        final KDBizPromptBox kdtEntrys_insurancetype_PromptBox = new KDBizPromptBox();
        kdtEntrys_insurancetype_PromptBox.setQueryInfo("com.kingdee.eas.custom.wages.app.InsuranceTypeQuery");
        kdtEntrys_insurancetype_PromptBox.setVisible(true);
        kdtEntrys_insurancetype_PromptBox.setEditable(true);
        kdtEntrys_insurancetype_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_insurancetype_PromptBox.setEditFormat("$number$");
        kdtEntrys_insurancetype_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_insurancetype_CellEditor = new KDTDefaultCellEditor(kdtEntrys_insurancetype_PromptBox);
        this.kdtEntrys.getColumn("insurancetype").setEditor(kdtEntrys_insurancetype_CellEditor);
        ObjectValueRender kdtEntrys_insurancetype_OVR = new ObjectValueRender();
        kdtEntrys_insurancetype_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("insurancetype").setRenderer(kdtEntrys_insurancetype_OVR);
        KDDatePicker kdtEntrys_filingdate_DatePicker = new KDDatePicker();
        kdtEntrys_filingdate_DatePicker.setName("kdtEntrys_filingdate_DatePicker");
        kdtEntrys_filingdate_DatePicker.setVisible(true);
        kdtEntrys_filingdate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_filingdate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_filingdate_DatePicker);
        this.kdtEntrys.getColumn("filingdate").setEditor(kdtEntrys_filingdate_CellEditor);
        KDCheckBox kdtEntrys_isAppraisal_CheckBox = new KDCheckBox();
        kdtEntrys_isAppraisal_CheckBox.setName("kdtEntrys_isAppraisal_CheckBox");
        KDTDefaultCellEditor kdtEntrys_isAppraisal_CellEditor = new KDTDefaultCellEditor(kdtEntrys_isAppraisal_CheckBox);
        this.kdtEntrys.getColumn("isAppraisal").setEditor(kdtEntrys_isAppraisal_CellEditor);
        final KDBizPromptBox kdtEntrys_AppraisalClient_PromptBox = new KDBizPromptBox();
        kdtEntrys_AppraisalClient_PromptBox.setQueryInfo("com.kingdee.eas.custom.wages.app.AppraisalclientQuery");
        kdtEntrys_AppraisalClient_PromptBox.setVisible(true);
        kdtEntrys_AppraisalClient_PromptBox.setEditable(true);
        kdtEntrys_AppraisalClient_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_AppraisalClient_PromptBox.setEditFormat("$number$");
        kdtEntrys_AppraisalClient_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_AppraisalClient_CellEditor = new KDTDefaultCellEditor(kdtEntrys_AppraisalClient_PromptBox);
        this.kdtEntrys.getColumn("AppraisalClient").setEditor(kdtEntrys_AppraisalClient_CellEditor);
        ObjectValueRender kdtEntrys_AppraisalClient_OVR = new ObjectValueRender();
        kdtEntrys_AppraisalClient_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("AppraisalClient").setRenderer(kdtEntrys_AppraisalClient_OVR);
        KDTextField kdtEntrys_jdjg_TextField = new KDTextField();
        kdtEntrys_jdjg_TextField.setName("kdtEntrys_jdjg_TextField");
        kdtEntrys_jdjg_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_jdjg_CellEditor = new KDTDefaultCellEditor(kdtEntrys_jdjg_TextField);
        this.kdtEntrys.getColumn("jdjg").setEditor(kdtEntrys_jdjg_CellEditor);
        final KDBizPromptBox kdtEntrys_cuser_PromptBox = new KDBizPromptBox();
        kdtEntrys_cuser_PromptBox.setQueryInfo("com.kingdee.eas.base.permission.app.F7AllUserQuery");
        kdtEntrys_cuser_PromptBox.setVisible(true);
        kdtEntrys_cuser_PromptBox.setEditable(true);
        kdtEntrys_cuser_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_cuser_PromptBox.setEditFormat("$number$");
        kdtEntrys_cuser_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_cuser_CellEditor = new KDTDefaultCellEditor(kdtEntrys_cuser_PromptBox);
        this.kdtEntrys.getColumn("cuser").setEditor(kdtEntrys_cuser_CellEditor);
        ObjectValueRender kdtEntrys_cuser_OVR = new ObjectValueRender();
        kdtEntrys_cuser_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("cuser").setRenderer(kdtEntrys_cuser_OVR);
        KDTextField kdtEntrys_sjfzr_TextField = new KDTextField();
        kdtEntrys_sjfzr_TextField.setName("kdtEntrys_sjfzr_TextField");
        kdtEntrys_sjfzr_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_sjfzr_CellEditor = new KDTDefaultCellEditor(kdtEntrys_sjfzr_TextField);
        this.kdtEntrys.getColumn("sjfzr").setEditor(kdtEntrys_sjfzr_CellEditor);
        KDComboBox kdtEntrys_ClaimMethod_ComboBox = new KDComboBox();
        kdtEntrys_ClaimMethod_ComboBox.setName("kdtEntrys_ClaimMethod_ComboBox");
        kdtEntrys_ClaimMethod_ComboBox.setVisible(true);
        kdtEntrys_ClaimMethod_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.wages.ClaimMethod").toArray());
        KDTDefaultCellEditor kdtEntrys_ClaimMethod_CellEditor = new KDTDefaultCellEditor(kdtEntrys_ClaimMethod_ComboBox);
        this.kdtEntrys.getColumn("ClaimMethod").setEditor(kdtEntrys_ClaimMethod_CellEditor);
        KDFormattedTextField kdtEntrys_SureAmount_TextField = new KDFormattedTextField();
        kdtEntrys_SureAmount_TextField.setName("kdtEntrys_SureAmount_TextField");
        kdtEntrys_SureAmount_TextField.setVisible(true);
        kdtEntrys_SureAmount_TextField.setEditable(true);
        kdtEntrys_SureAmount_TextField.setHorizontalAlignment(2);
        kdtEntrys_SureAmount_TextField.setDataType(1);
        	kdtEntrys_SureAmount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_SureAmount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_SureAmount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_SureAmount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_SureAmount_TextField);
        this.kdtEntrys.getColumn("SureAmount").setEditor(kdtEntrys_SureAmount_CellEditor);
        KDFormattedTextField kdtEntrys_companyAmount_TextField = new KDFormattedTextField();
        kdtEntrys_companyAmount_TextField.setName("kdtEntrys_companyAmount_TextField");
        kdtEntrys_companyAmount_TextField.setVisible(true);
        kdtEntrys_companyAmount_TextField.setEditable(true);
        kdtEntrys_companyAmount_TextField.setHorizontalAlignment(2);
        kdtEntrys_companyAmount_TextField.setDataType(1);
        	kdtEntrys_companyAmount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_companyAmount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_companyAmount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_companyAmount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_companyAmount_TextField);
        this.kdtEntrys.getColumn("companyAmount").setEditor(kdtEntrys_companyAmount_CellEditor);
        KDTextArea kdtEntrys_remark_TextArea = new KDTextArea();
        kdtEntrys_remark_TextArea.setName("kdtEntrys_remark_TextArea");
        kdtEntrys_remark_TextArea.setMaxLength(255);
        KDTDefaultCellEditor kdtEntrys_remark_CellEditor = new KDTDefaultCellEditor(kdtEntrys_remark_TextArea);
        this.kdtEntrys.getColumn("remark").setEditor(kdtEntrys_remark_CellEditor);
        KDComboBox kdtEntrys_casetype_ComboBox = new KDComboBox();
        kdtEntrys_casetype_ComboBox.setName("kdtEntrys_casetype_ComboBox");
        kdtEntrys_casetype_ComboBox.setVisible(true);
        kdtEntrys_casetype_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.wages.casetype").toArray());
        KDTDefaultCellEditor kdtEntrys_casetype_CellEditor = new KDTDefaultCellEditor(kdtEntrys_casetype_ComboBox);
        this.kdtEntrys.getColumn("casetype").setEditor(kdtEntrys_casetype_CellEditor);
        // contBillStatus		
        this.contBillStatus.setBoundLabelText(resHelper.getString("contBillStatus.boundLabelText"));		
        this.contBillStatus.setBoundLabelLength(100);		
        this.contBillStatus.setBoundLabelUnderline(true);		
        this.contBillStatus.setVisible(true);
        // importEx
        this.importEx.setAction((IItemAction)ActionProxyFactory.getProxy(ActionImportEx, new Class[] { IItemAction.class }, getServiceContext()));		
        this.importEx.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgMenumodule_icon_finance"));		
        this.importEx.setVisible(false);
        // contcompanyOrg		
        this.contcompanyOrg.setBoundLabelText(resHelper.getString("contcompanyOrg.boundLabelText"));		
        this.contcompanyOrg.setBoundLabelLength(100);		
        this.contcompanyOrg.setBoundLabelUnderline(true);		
        this.contcompanyOrg.setVisible(true);
        // contsureAmount		
        this.contsureAmount.setBoundLabelText(resHelper.getString("contsureAmount.boundLabelText"));		
        this.contsureAmount.setBoundLabelLength(100);		
        this.contsureAmount.setBoundLabelUnderline(true);		
        this.contsureAmount.setVisible(false);
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
        this.pkBizDate.setRequired(true);
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // BillStatus		
        this.BillStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.BillStatus.setRequired(false);		
        this.BillStatus.setEnabled(false);
        // prmtcompanyOrg		
        this.prmtcompanyOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompanyOrg.setEditable(true);		
        this.prmtcompanyOrg.setDisplayFormat("$name$");		
        this.prmtcompanyOrg.setEditFormat("$number$");		
        this.prmtcompanyOrg.setCommitFormat("$number$");		
        this.prmtcompanyOrg.setRequired(true);
        // txtsureAmount		
        this.txtsureAmount.setVisible(false);		
        this.txtsureAmount.setHorizontalAlignment(2);		
        this.txtsureAmount.setDataType(1);		
        this.txtsureAmount.setSupportedEmpty(true);		
        this.txtsureAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsureAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsureAmount.setPrecision(2);		
        this.txtsureAmount.setRequired(false);
        // audit
        this.audit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.audit.setText(resHelper.getString("audit.text"));
        // unaudit
        this.unaudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnaudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.unaudit.setText(resHelper.getString("unaudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,BillStatus,prmtcompanyOrg,txtsureAmount,kdtEntrys}));
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
        contCreator.setBounds(new Rectangle(372, 524, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(372, 524, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(730, 524, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(730, 524, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(372, 555, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(372, 555, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(730, 555, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(730, 555, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(13, 26, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(13, 26, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(351, 26, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(351, 26, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(13, 92, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(13, 92, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(15, 528, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(15, 528, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(12, 135, 991, 377));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.custom.wages.InjuryinsuranceEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(12, 135, 991, 377, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
		kdtEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("costtype","0");
vo.put("ClaimMethod","0");
vo.put("casetype","0");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        contBillStatus.setBounds(new Rectangle(13, 59, 270, 19));
        this.add(contBillStatus, new KDLayout.Constraints(13, 59, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        importEx.setBounds(new Rectangle(937, 82, 20, 21));
        this.add(importEx, new KDLayout.Constraints(937, 82, 20, 21, 0));
        contcompanyOrg.setBounds(new Rectangle(728, 26, 270, 19));
        this.add(contcompanyOrg, new KDLayout.Constraints(728, 26, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contsureAmount.setBounds(new Rectangle(351, 58, 270, 19));
        this.add(contsureAmount, new KDLayout.Constraints(351, 58, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contcompanyOrg
        contcompanyOrg.setBoundEditor(prmtcompanyOrg);
        //contsureAmount
        contsureAmount.setBoundEditor(txtsureAmount);

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
		dataBinder.registerBinding("entrys", com.kingdee.eas.custom.wages.InjuryinsuranceEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.remark", String.class, this.kdtEntrys, "remark.text");
		dataBinder.registerBinding("entrys.person", java.lang.Object.class, this.kdtEntrys, "person.text");
		dataBinder.registerBinding("entrys.personName", String.class, this.kdtEntrys, "personName.text");
		dataBinder.registerBinding("entrys.opentime", java.util.Date.class, this.kdtEntrys, "opentime.text");
		dataBinder.registerBinding("entrys.site", String.class, this.kdtEntrys, "site.text");
		dataBinder.registerBinding("entrys.accdescription", String.class, this.kdtEntrys, "accdescription.text");
		dataBinder.registerBinding("entrys.Hospital", java.lang.Object.class, this.kdtEntrys, "Hospital.text");
		dataBinder.registerBinding("entrys.curetime", java.util.Date.class, this.kdtEntrys, "curetime.text");
		dataBinder.registerBinding("entrys.amount", java.math.BigDecimal.class, this.kdtEntrys, "amount.text");
		dataBinder.registerBinding("entrys.insurancetype", java.lang.Object.class, this.kdtEntrys, "insurancetype.text");
		dataBinder.registerBinding("entrys.filingdate", java.util.Date.class, this.kdtEntrys, "filingdate.text");
		dataBinder.registerBinding("entrys.isAppraisal", boolean.class, this.kdtEntrys, "isAppraisal.text");
		dataBinder.registerBinding("entrys.jdjg", String.class, this.kdtEntrys, "jdjg.text");
		dataBinder.registerBinding("entrys.cuser", java.lang.Object.class, this.kdtEntrys, "cuser.text");
		dataBinder.registerBinding("entrys.SureAmount", java.math.BigDecimal.class, this.kdtEntrys, "SureAmount.text");
		dataBinder.registerBinding("entrys.company", java.lang.Object.class, this.kdtEntrys, "company.text");
		dataBinder.registerBinding("entrys.costtype", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "costtype.text");
		dataBinder.registerBinding("entrys.casetype", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "casetype.text");
		dataBinder.registerBinding("entrys.ClaimMethod", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "ClaimMethod.text");
		dataBinder.registerBinding("entrys.AppraisalClient", java.lang.Object.class, this.kdtEntrys, "AppraisalClient.text");
		dataBinder.registerBinding("entrys.companyAmount", java.math.BigDecimal.class, this.kdtEntrys, "companyAmount.text");
		dataBinder.registerBinding("entrys.sjfzr", String.class, this.kdtEntrys, "sjfzr.text");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("BillStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.BillStatus, "selectedItem");
		dataBinder.registerBinding("companyOrg", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompanyOrg, "data");
		dataBinder.registerBinding("sureAmount", java.math.BigDecimal.class, this.txtsureAmount, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.wages.app.InjuryinsuranceEditUIHandler";
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
        this.editData = (com.kingdee.eas.custom.wages.InjuryinsuranceInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.person", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.personName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.opentime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.site", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.accdescription", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Hospital", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.curetime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.insurancetype", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.filingdate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isAppraisal", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.jdjg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.cuser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.SureAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.costtype", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.casetype", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.ClaimMethod", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.AppraisalClient", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.companyAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sjfzr", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BillStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("companyOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sureAmount", ValidateHelper.ON_SAVE);    		
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
kdtEntrys.getCell(rowIndex,"personName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"person").getValue(),"name")));

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
    	sic.add(new SelectorItemInfo("entrys.remark"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.person.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.person.id"));
			sic.add(new SelectorItemInfo("entrys.person.number"));
			sic.add(new SelectorItemInfo("entrys.person.name"));
		}
    	sic.add(new SelectorItemInfo("entrys.personName"));
    	sic.add(new SelectorItemInfo("entrys.opentime"));
    	sic.add(new SelectorItemInfo("entrys.site"));
    	sic.add(new SelectorItemInfo("entrys.accdescription"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.Hospital.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.Hospital.id"));
			sic.add(new SelectorItemInfo("entrys.Hospital.name"));
        	sic.add(new SelectorItemInfo("entrys.Hospital.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.curetime"));
    	sic.add(new SelectorItemInfo("entrys.amount"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.insurancetype.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.insurancetype.id"));
			sic.add(new SelectorItemInfo("entrys.insurancetype.name"));
        	sic.add(new SelectorItemInfo("entrys.insurancetype.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.filingdate"));
    	sic.add(new SelectorItemInfo("entrys.isAppraisal"));
    	sic.add(new SelectorItemInfo("entrys.jdjg"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.cuser.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.cuser.id"));
			sic.add(new SelectorItemInfo("entrys.cuser.number"));
			sic.add(new SelectorItemInfo("entrys.cuser.name"));
		}
    	sic.add(new SelectorItemInfo("entrys.SureAmount"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.company.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.company.id"));
			sic.add(new SelectorItemInfo("entrys.company.name"));
        	sic.add(new SelectorItemInfo("entrys.company.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.costtype"));
    	sic.add(new SelectorItemInfo("entrys.casetype"));
    	sic.add(new SelectorItemInfo("entrys.ClaimMethod"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.AppraisalClient.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.AppraisalClient.id"));
			sic.add(new SelectorItemInfo("entrys.AppraisalClient.name"));
        	sic.add(new SelectorItemInfo("entrys.AppraisalClient.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.companyAmount"));
    	sic.add(new SelectorItemInfo("entrys.sjfzr"));
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
			sic.add(new SelectorItemInfo("companyOrg.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("companyOrg.id"));
        	sic.add(new SelectorItemInfo("companyOrg.number"));
        	sic.add(new SelectorItemInfo("companyOrg.name"));
		}
        sic.add(new SelectorItemInfo("sureAmount"));
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
        com.kingdee.eas.custom.wages.InjuryinsuranceFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnaudit_actionPerformed method
     */
    public void actionUnaudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.wages.InjuryinsuranceFactory.getRemoteInstance().unaudit(editData);
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
            innerActionPerformed("eas", AbstractInjuryinsuranceEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractInjuryinsuranceEditUI.this, "ActionUnaudit", "actionUnaudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractInjuryinsuranceEditUI.this, "actionImportEx", "actionImportEx_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.wages.client", "InjuryinsuranceEditUI");
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
        return com.kingdee.eas.custom.wages.client.InjuryinsuranceEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.wages.InjuryinsuranceFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.wages.InjuryinsuranceInfo objectValue = new com.kingdee.eas.custom.wages.InjuryinsuranceInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/wages/Injuryinsurance";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.wages.app.InjuryinsuranceQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompanyOrg.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"公司"});
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
		vo.put("BillStatus",new Integer(-1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}        
				protected void setTableToSumField() {
			setTableToSumField(kdtEntrys,new String[] {"SureAmount"});
		}


}