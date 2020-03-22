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
public abstract class AbstractDailyOutPutEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractDailyOutPutEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contWageOrganization;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contOrganForeman;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBillStatus;
    protected com.kingdee.bos.ctrl.swing.KDButton GetPerson;
    protected com.kingdee.bos.ctrl.swing.KDButton importEx;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtWageOrganization;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtOrganForeman;
    protected com.kingdee.bos.ctrl.swing.KDComboBox BillStatus;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton salarycount;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton audit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton unaudit;
    protected com.kingdee.eas.custom.wages.DailyOutPutInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnaudit actionUnaudit = null;
    protected ActionSalaryCount actionSalaryCount = null;
    protected actionImportExcel importExcel = null;
    /**
     * output class constructor
     */
    public AbstractDailyOutPutEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractDailyOutPutEditUI.class.getName());
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
        //actionSalaryCount
        this.actionSalaryCount = new ActionSalaryCount(this);
        getActionManager().registerAction("actionSalaryCount", actionSalaryCount);
        this.actionSalaryCount.setExtendProperty("canForewarn", "true");
        this.actionSalaryCount.setExtendProperty("userDefined", "true");
        this.actionSalaryCount.setExtendProperty("isObjectUpdateLock", "false");
         this.actionSalaryCount.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionSalaryCount.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //importExcel
        this.importExcel = new actionImportExcel(this);
        getActionManager().registerAction("importExcel", importExcel);
         this.importExcel.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contWageOrganization = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contOrganForeman = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.GetPerson = new com.kingdee.bos.ctrl.swing.KDButton();
        this.importEx = new com.kingdee.bos.ctrl.swing.KDButton();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtWageOrganization = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtOrganForeman = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.BillStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.salarycount = new com.kingdee.bos.ctrl.swing.KDWorkButton();
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
        this.contWageOrganization.setName("contWageOrganization");
        this.contOrganForeman.setName("contOrganForeman");
        this.contBillStatus.setName("contBillStatus");
        this.GetPerson.setName("GetPerson");
        this.importEx.setName("importEx");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtWageOrganization.setName("prmtWageOrganization");
        this.txtOrganForeman.setName("txtOrganForeman");
        this.BillStatus.setName("BillStatus");
        this.salarycount.setName("salarycount");
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
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"person\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"personnumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"frompost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"productratio\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"meteunit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"mnumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"isHelfday\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"isAbsenteeism\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"isLeave\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"isTemp\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"isNight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"overtime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"overday\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"daywages\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{person}</t:Cell><t:Cell>$Resource{personnumber}</t:Cell><t:Cell>$Resource{frompost}</t:Cell><t:Cell>$Resource{productratio}</t:Cell><t:Cell>$Resource{meteunit}</t:Cell><t:Cell>$Resource{mnumber}</t:Cell><t:Cell>$Resource{isHelfday}</t:Cell><t:Cell>$Resource{isAbsenteeism}</t:Cell><t:Cell>$Resource{isLeave}</t:Cell><t:Cell>$Resource{isTemp}</t:Cell><t:Cell>$Resource{isNight}</t:Cell><t:Cell>$Resource{overtime}</t:Cell><t:Cell>$Resource{overday}</t:Cell><t:Cell>$Resource{daywages}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtEntrys.putBindContents("editData",new String[] {"id","person","personnumber","frompost","productratio","meteunit","mnumber","isHelfday","isAbsenteeism","isLeave","isTemp","isNight","overtime","overday","daywages"});


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
        KDTextField kdtEntrys_personnumber_TextField = new KDTextField();
        kdtEntrys_personnumber_TextField.setName("kdtEntrys_personnumber_TextField");
        kdtEntrys_personnumber_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_personnumber_CellEditor = new KDTDefaultCellEditor(kdtEntrys_personnumber_TextField);
        this.kdtEntrys.getColumn("personnumber").setEditor(kdtEntrys_personnumber_CellEditor);
        final KDBizPromptBox kdtEntrys_frompost_PromptBox = new KDBizPromptBox();
        kdtEntrys_frompost_PromptBox.setQueryInfo("com.kingdee.eas.custom.wages.app.BasicPostQuery");
        kdtEntrys_frompost_PromptBox.setVisible(true);
        kdtEntrys_frompost_PromptBox.setEditable(true);
        kdtEntrys_frompost_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_frompost_PromptBox.setEditFormat("$number$");
        kdtEntrys_frompost_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_frompost_CellEditor = new KDTDefaultCellEditor(kdtEntrys_frompost_PromptBox);
        this.kdtEntrys.getColumn("frompost").setEditor(kdtEntrys_frompost_CellEditor);
        ObjectValueRender kdtEntrys_frompost_OVR = new ObjectValueRender();
        kdtEntrys_frompost_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("frompost").setRenderer(kdtEntrys_frompost_OVR);
        KDFormattedTextField kdtEntrys_productratio_TextField = new KDFormattedTextField();
        kdtEntrys_productratio_TextField.setName("kdtEntrys_productratio_TextField");
        kdtEntrys_productratio_TextField.setVisible(true);
        kdtEntrys_productratio_TextField.setEditable(true);
        kdtEntrys_productratio_TextField.setHorizontalAlignment(2);
        kdtEntrys_productratio_TextField.setDataType(1);
        	kdtEntrys_productratio_TextField.setMinimumValue(new java.math.BigDecimal("-3.4028234663852886E38"));
        	kdtEntrys_productratio_TextField.setMaximumValue(new java.math.BigDecimal("3.4028234663852886E38"));
        kdtEntrys_productratio_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_productratio_CellEditor = new KDTDefaultCellEditor(kdtEntrys_productratio_TextField);
        this.kdtEntrys.getColumn("productratio").setEditor(kdtEntrys_productratio_CellEditor);
        KDComboBox kdtEntrys_meteunit_ComboBox = new KDComboBox();
        kdtEntrys_meteunit_ComboBox.setName("kdtEntrys_meteunit_ComboBox");
        kdtEntrys_meteunit_ComboBox.setVisible(true);
        kdtEntrys_meteunit_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.wages.UnitOfMetering").toArray());
        KDTDefaultCellEditor kdtEntrys_meteunit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_meteunit_ComboBox);
        this.kdtEntrys.getColumn("meteunit").setEditor(kdtEntrys_meteunit_CellEditor);
        KDFormattedTextField kdtEntrys_mnumber_TextField = new KDFormattedTextField();
        kdtEntrys_mnumber_TextField.setName("kdtEntrys_mnumber_TextField");
        kdtEntrys_mnumber_TextField.setVisible(true);
        kdtEntrys_mnumber_TextField.setEditable(true);
        kdtEntrys_mnumber_TextField.setHorizontalAlignment(2);
        kdtEntrys_mnumber_TextField.setDataType(1);
        	kdtEntrys_mnumber_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_mnumber_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_mnumber_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_mnumber_CellEditor = new KDTDefaultCellEditor(kdtEntrys_mnumber_TextField);
        this.kdtEntrys.getColumn("mnumber").setEditor(kdtEntrys_mnumber_CellEditor);
        KDCheckBox kdtEntrys_isHelfday_CheckBox = new KDCheckBox();
        kdtEntrys_isHelfday_CheckBox.setName("kdtEntrys_isHelfday_CheckBox");
        KDTDefaultCellEditor kdtEntrys_isHelfday_CellEditor = new KDTDefaultCellEditor(kdtEntrys_isHelfday_CheckBox);
        this.kdtEntrys.getColumn("isHelfday").setEditor(kdtEntrys_isHelfday_CellEditor);
        KDCheckBox kdtEntrys_isAbsenteeism_CheckBox = new KDCheckBox();
        kdtEntrys_isAbsenteeism_CheckBox.setName("kdtEntrys_isAbsenteeism_CheckBox");
        KDTDefaultCellEditor kdtEntrys_isAbsenteeism_CellEditor = new KDTDefaultCellEditor(kdtEntrys_isAbsenteeism_CheckBox);
        this.kdtEntrys.getColumn("isAbsenteeism").setEditor(kdtEntrys_isAbsenteeism_CellEditor);
        KDCheckBox kdtEntrys_isLeave_CheckBox = new KDCheckBox();
        kdtEntrys_isLeave_CheckBox.setName("kdtEntrys_isLeave_CheckBox");
        KDTDefaultCellEditor kdtEntrys_isLeave_CellEditor = new KDTDefaultCellEditor(kdtEntrys_isLeave_CheckBox);
        this.kdtEntrys.getColumn("isLeave").setEditor(kdtEntrys_isLeave_CellEditor);
        KDCheckBox kdtEntrys_isTemp_CheckBox = new KDCheckBox();
        kdtEntrys_isTemp_CheckBox.setName("kdtEntrys_isTemp_CheckBox");
        KDTDefaultCellEditor kdtEntrys_isTemp_CellEditor = new KDTDefaultCellEditor(kdtEntrys_isTemp_CheckBox);
        this.kdtEntrys.getColumn("isTemp").setEditor(kdtEntrys_isTemp_CellEditor);
        KDCheckBox kdtEntrys_isNight_CheckBox = new KDCheckBox();
        kdtEntrys_isNight_CheckBox.setName("kdtEntrys_isNight_CheckBox");
        KDTDefaultCellEditor kdtEntrys_isNight_CellEditor = new KDTDefaultCellEditor(kdtEntrys_isNight_CheckBox);
        this.kdtEntrys.getColumn("isNight").setEditor(kdtEntrys_isNight_CellEditor);
        KDFormattedTextField kdtEntrys_overtime_TextField = new KDFormattedTextField();
        kdtEntrys_overtime_TextField.setName("kdtEntrys_overtime_TextField");
        kdtEntrys_overtime_TextField.setVisible(true);
        kdtEntrys_overtime_TextField.setEditable(true);
        kdtEntrys_overtime_TextField.setHorizontalAlignment(2);
        kdtEntrys_overtime_TextField.setDataType(1);
        	kdtEntrys_overtime_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_overtime_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_overtime_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_overtime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_overtime_TextField);
        this.kdtEntrys.getColumn("overtime").setEditor(kdtEntrys_overtime_CellEditor);
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
        KDFormattedTextField kdtEntrys_daywages_TextField = new KDFormattedTextField();
        kdtEntrys_daywages_TextField.setName("kdtEntrys_daywages_TextField");
        kdtEntrys_daywages_TextField.setVisible(true);
        kdtEntrys_daywages_TextField.setEditable(true);
        kdtEntrys_daywages_TextField.setHorizontalAlignment(2);
        kdtEntrys_daywages_TextField.setDataType(1);
        	kdtEntrys_daywages_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_daywages_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_daywages_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_daywages_CellEditor = new KDTDefaultCellEditor(kdtEntrys_daywages_TextField);
        this.kdtEntrys.getColumn("daywages").setEditor(kdtEntrys_daywages_CellEditor);
        // contWageOrganization		
        this.contWageOrganization.setBoundLabelText(resHelper.getString("contWageOrganization.boundLabelText"));		
        this.contWageOrganization.setBoundLabelLength(100);		
        this.contWageOrganization.setBoundLabelUnderline(true);		
        this.contWageOrganization.setVisible(true);
        // contOrganForeman		
        this.contOrganForeman.setBoundLabelText(resHelper.getString("contOrganForeman.boundLabelText"));		
        this.contOrganForeman.setBoundLabelLength(100);		
        this.contOrganForeman.setBoundLabelUnderline(true);		
        this.contOrganForeman.setVisible(true);
        // contBillStatus		
        this.contBillStatus.setBoundLabelText(resHelper.getString("contBillStatus.boundLabelText"));		
        this.contBillStatus.setBoundLabelLength(100);		
        this.contBillStatus.setBoundLabelUnderline(true);		
        this.contBillStatus.setVisible(true);
        // GetPerson		
        this.GetPerson.setText(resHelper.getString("GetPerson.text"));
        // importEx
        this.importEx.setAction((IItemAction)ActionProxyFactory.getProxy(importExcel, new Class[] { IItemAction.class }, getServiceContext()));		
        this.importEx.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_BZinput"));
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
        // prmtWageOrganization		
        this.prmtWageOrganization.setQueryInfo("com.kingdee.eas.custom.wages.app.WageOrganizationQuery");		
        this.prmtWageOrganization.setEditable(true);		
        this.prmtWageOrganization.setDisplayFormat("$name$");		
        this.prmtWageOrganization.setEditFormat("$number$");		
        this.prmtWageOrganization.setCommitFormat("$number$");		
        this.prmtWageOrganization.setRequired(false);
        		prmtWageOrganization.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.custom.wages.client.WageOrganizationListUI prmtWageOrganization_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtWageOrganization_F7ListUI == null) {
					try {
						prmtWageOrganization_F7ListUI = new com.kingdee.eas.custom.wages.client.WageOrganizationListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtWageOrganization_F7ListUI));
					prmtWageOrganization_F7ListUI.setF7Use(true,ctx);
					prmtWageOrganization.setSelector(prmtWageOrganization_F7ListUI);
				}
			}
		});
					
        prmtWageOrganization.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtWageOrganization_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtOrganForeman		
        this.txtOrganForeman.setHorizontalAlignment(2);		
        this.txtOrganForeman.setMaxLength(80);		
        this.txtOrganForeman.setRequired(false);
        // BillStatus		
        this.BillStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.BillStatus.setRequired(false);		
        this.BillStatus.setEnabled(false);
        // salarycount
        this.salarycount.setAction((IItemAction)ActionProxyFactory.getProxy(actionSalaryCount, new Class[] { IItemAction.class }, getServiceContext()));		
        this.salarycount.setText(resHelper.getString("salarycount.text"));
        // audit
        this.audit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.audit.setText(resHelper.getString("audit.text"));
        // unaudit
        this.unaudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnaudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.unaudit.setText(resHelper.getString("unaudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,prmtWageOrganization,txtOrganForeman,BillStatus,kdtEntrys}));
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
        contCreator.setBounds(new Rectangle(396, 524, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(396, 524, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(730, 524, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(730, 524, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(396, 555, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(396, 555, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(730, 555, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(730, 555, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(14, 28, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(14, 28, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(352, 65, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(352, 65, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(728, 66, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(728, 66, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(15, 528, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(15, 528, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(12, 131, 991, 385));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.custom.wages.DailyOutPutEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(12, 131, 991, 385, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
		kdtEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("meteunit","0");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        contWageOrganization.setBounds(new Rectangle(352, 25, 270, 19));
        this.add(contWageOrganization, new KDLayout.Constraints(352, 25, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contOrganForeman.setBounds(new Rectangle(728, 25, 270, 19));
        this.add(contOrganForeman, new KDLayout.Constraints(728, 25, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBillStatus.setBounds(new Rectangle(15, 65, 270, 19));
        this.add(contBillStatus, new KDLayout.Constraints(15, 65, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        GetPerson.setBounds(new Rectangle(15, 94, 108, 21));
        this.add(GetPerson, new KDLayout.Constraints(15, 94, 108, 21, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        importEx.setBounds(new Rectangle(820, 102, 20, 21));
        this.add(importEx, new KDLayout.Constraints(820, 102, 20, 21, 0));
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
        //contWageOrganization
        contWageOrganization.setBoundEditor(prmtWageOrganization);
        //contOrganForeman
        contOrganForeman.setBoundEditor(txtOrganForeman);
        //contBillStatus
        contBillStatus.setBoundEditor(BillStatus);

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
        this.toolBar.add(salarycount);
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
		dataBinder.registerBinding("entrys", com.kingdee.eas.custom.wages.DailyOutPutEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.person", java.lang.Object.class, this.kdtEntrys, "person.text");
		dataBinder.registerBinding("entrys.personnumber", String.class, this.kdtEntrys, "personnumber.text");
		dataBinder.registerBinding("entrys.frompost", java.lang.Object.class, this.kdtEntrys, "frompost.text");
		dataBinder.registerBinding("entrys.productratio", java.math.BigDecimal.class, this.kdtEntrys, "productratio.text");
		dataBinder.registerBinding("entrys.meteunit", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "meteunit.text");
		dataBinder.registerBinding("entrys.overtime", java.math.BigDecimal.class, this.kdtEntrys, "overtime.text");
		dataBinder.registerBinding("entrys.overday", java.math.BigDecimal.class, this.kdtEntrys, "overday.text");
		dataBinder.registerBinding("entrys.daywages", java.math.BigDecimal.class, this.kdtEntrys, "daywages.text");
		dataBinder.registerBinding("entrys.isAbsenteeism", boolean.class, this.kdtEntrys, "isAbsenteeism.text");
		dataBinder.registerBinding("entrys.isLeave", boolean.class, this.kdtEntrys, "isLeave.text");
		dataBinder.registerBinding("entrys.isTemp", boolean.class, this.kdtEntrys, "isTemp.text");
		dataBinder.registerBinding("entrys.isNight", boolean.class, this.kdtEntrys, "isNight.text");
		dataBinder.registerBinding("entrys.mnumber", java.math.BigDecimal.class, this.kdtEntrys, "mnumber.text");
		dataBinder.registerBinding("entrys.isHelfday", boolean.class, this.kdtEntrys, "isHelfday.text");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("WageOrganization", com.kingdee.eas.custom.wages.WageOrganizationInfo.class, this.prmtWageOrganization, "data");
		dataBinder.registerBinding("OrganForeman", String.class, this.txtOrganForeman, "text");
		dataBinder.registerBinding("BillStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.BillStatus, "selectedItem");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.wages.app.DailyOutPutEditUIHandler";
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
        this.editData = (com.kingdee.eas.custom.wages.DailyOutPutInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.personnumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.frompost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.productratio", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.meteunit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.overtime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.overday", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.daywages", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isAbsenteeism", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isLeave", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isTemp", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isNight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.mnumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isHelfday", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("WageOrganization", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OrganForeman", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BillStatus", ValidateHelper.ON_SAVE);    		
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
kdtEntrys.getCell(rowIndex,"personnumber").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"person").getValue(),"name")));

}

    if ("frompost".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"productratio").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"frompost").getValue(),"ProductRatio")));

}

    if ("frompost".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"meteunit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"frompost").getValue(),"UnitMetering"));

}


    }

    /**
     * output prmtWageOrganization_Changed() method
     */
    public void prmtWageOrganization_Changed() throws Exception
    {
        System.out.println("prmtWageOrganization_Changed() Function is executed!");
            txtOrganForeman.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtWageOrganization.getData(),"Foremanname.name")));


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
			sic.add(new SelectorItemInfo("entrys.person.number"));
			sic.add(new SelectorItemInfo("entrys.person.name"));
		}
    	sic.add(new SelectorItemInfo("entrys.personnumber"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.frompost.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.frompost.id"));
			sic.add(new SelectorItemInfo("entrys.frompost.name"));
        	sic.add(new SelectorItemInfo("entrys.frompost.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.productratio"));
    	sic.add(new SelectorItemInfo("entrys.meteunit"));
    	sic.add(new SelectorItemInfo("entrys.overtime"));
    	sic.add(new SelectorItemInfo("entrys.overday"));
    	sic.add(new SelectorItemInfo("entrys.daywages"));
    	sic.add(new SelectorItemInfo("entrys.isAbsenteeism"));
    	sic.add(new SelectorItemInfo("entrys.isLeave"));
    	sic.add(new SelectorItemInfo("entrys.isTemp"));
    	sic.add(new SelectorItemInfo("entrys.isNight"));
    	sic.add(new SelectorItemInfo("entrys.mnumber"));
    	sic.add(new SelectorItemInfo("entrys.isHelfday"));
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("WageOrganization.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("WageOrganization.id"));
        	sic.add(new SelectorItemInfo("WageOrganization.number"));
        	sic.add(new SelectorItemInfo("WageOrganization.name"));
		}
        sic.add(new SelectorItemInfo("OrganForeman"));
        sic.add(new SelectorItemInfo("BillStatus"));
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
        com.kingdee.eas.custom.wages.DailyOutPutFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnaudit_actionPerformed method
     */
    public void actionUnaudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.wages.DailyOutPutFactory.getRemoteInstance().unaudit(editData);
    }
    	

    /**
     * output actionSalaryCount_actionPerformed method
     */
    public void actionSalaryCount_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.wages.DailyOutPutFactory.getRemoteInstance().salaryCount(editData);
    }
    	

    /**
     * output actionImportExcel_actionPerformed method
     */
    public void actionImportExcel_actionPerformed(ActionEvent e) throws Exception
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
	public RequestContext prepareActionSalaryCount(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionSalaryCount() {
    	return false;
    }
	public RequestContext prepareactionImportExcel(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareactionImportExcel() {
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
            innerActionPerformed("eas", AbstractDailyOutPutEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractDailyOutPutEditUI.this, "ActionUnaudit", "actionUnaudit_actionPerformed", e);
        }
    }

    /**
     * output ActionSalaryCount class
     */     
    protected class ActionSalaryCount extends ItemAction {     
    
        public ActionSalaryCount()
        {
            this(null);
        }

        public ActionSalaryCount(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionSalaryCount.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionSalaryCount.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionSalaryCount.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractDailyOutPutEditUI.this, "ActionSalaryCount", "actionSalaryCount_actionPerformed", e);
        }
    }

    /**
     * output actionImportExcel class
     */     
    protected class actionImportExcel extends ItemAction {     
    
        public actionImportExcel()
        {
            this(null);
        }

        public actionImportExcel(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("actionImportExcel.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("actionImportExcel.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("actionImportExcel.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractDailyOutPutEditUI.this, "actionImportExcel", "actionImportExcel_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.wages.client", "DailyOutPutEditUI");
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
        return com.kingdee.eas.custom.wages.client.DailyOutPutEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.wages.DailyOutPutFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.wages.DailyOutPutInfo objectValue = new com.kingdee.eas.custom.wages.DailyOutPutInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/wages/DailyOutPut";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.wages.app.DailyOutPutQuery");
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