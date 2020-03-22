/**
 * output package name
 */
package com.kingdee.eas.custom.signwasthetable.client;

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
public abstract class AbstractSignWasTheTableEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSignWasTheTableEditUI.class);
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditors;
    protected com.kingdee.bos.ctrl.swing.KDTextField txttext1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel3;
    protected com.kingdee.bos.ctrl.swing.KDTextField txttext2;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtKeyWord;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel4;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtorgSupp;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer LabelNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer LabelDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer LabelStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer LabelDepartment;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer LabelAddresses;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer LabelType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer LabelPresentedPerson;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contreason;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsalePerson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contposition;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contupperPosition;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpredictAmt;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkAuditTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditors;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtadminOrgUnit;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtaddresses;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbillType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpresentedPerson;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane scrollPanereason;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtreason;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsalePerson;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtposition;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtupperPosition;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpredictAmt;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnRefresh;
    protected javax.swing.JToolBar.Separator newSeparator1;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton Audit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton unAudit;
    protected com.kingdee.eas.custom.signwasthetable.SignWasTheTableInfo editData = null;
    protected ActionCheck actionCheck = null;
    protected ActionListener actionListener = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionBtnRefresh actionBtnRefresh = null;
    /**
     * output class constructor
     */
    public AbstractSignWasTheTableEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractSignWasTheTableEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        //actionPageSetup
        String _tempStr = null;
        actionPageSetup.setEnabled(true);
        actionPageSetup.setDaemonRun(false);

        _tempStr = resHelper.getString("ActionPageSetup.SHORT_DESCRIPTION");
        actionPageSetup.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPageSetup.LONG_DESCRIPTION");
        actionPageSetup.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPageSetup.NAME");
        actionPageSetup.putValue(ItemAction.NAME, _tempStr);
        this.actionPageSetup.setExtendProperty("userDefined", "false");
        this.actionPageSetup.setExtendProperty("isObjectUpdateLock", "false");
         this.actionPageSetup.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionPageSetup.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionSave
        actionSave.setEnabled(true);
        actionSave.setDaemonRun(false);

        actionSave.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("shift ctrl S"));
        _tempStr = resHelper.getString("ActionSave.SHORT_DESCRIPTION");
        actionSave.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionSave.LONG_DESCRIPTION");
        actionSave.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionSave.NAME");
        actionSave.putValue(ItemAction.NAME, _tempStr);
        this.actionSave.setExtendProperty("userDefined", "false");
        this.actionSave.setExtendProperty("isObjectUpdateLock", "false");
         this.actionSave.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionSave.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionSubmit
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
        this.actionSubmit.setExtendProperty("userDefined", "false");
        this.actionSubmit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
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
        //actionCheck
        this.actionCheck = new ActionCheck(this);
        getActionManager().registerAction("actionCheck", actionCheck);
        this.actionCheck.setExtendProperty("canForewarn", "true");
        this.actionCheck.setExtendProperty("userDefined", "true");
        this.actionCheck.setExtendProperty("isObjectUpdateLock", "false");
         this.actionCheck.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionCheck.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionListener
        this.actionListener = new ActionListener(this);
        getActionManager().registerAction("actionListener", actionListener);
        this.actionListener.setExtendProperty("canForewarn", "true");
        this.actionListener.setExtendProperty("userDefined", "true");
        this.actionListener.setExtendProperty("isObjectUpdateLock", "false");
         this.actionListener.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionListener.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionUnAudit
        this.actionUnAudit = new ActionUnAudit(this);
        getActionManager().registerAction("actionUnAudit", actionUnAudit);
        this.actionUnAudit.setExtendProperty("canForewarn", "true");
        this.actionUnAudit.setExtendProperty("userDefined", "true");
        this.actionUnAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionBtnRefresh
        this.actionBtnRefresh = new ActionBtnRefresh(this);
        getActionManager().registerAction("actionBtnRefresh", actionBtnRefresh);
        this.actionBtnRefresh.setExtendProperty("canForewarn", "true");
        this.actionBtnRefresh.setExtendProperty("userDefined", "false");
        this.actionBtnRefresh.setExtendProperty("isObjectUpdateLock", "false");
         this.actionBtnRefresh.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionBtnRefresh.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.kdtEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contAuditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditors = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txttext1 = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabel3 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.txttext2 = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtKeyWord = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kDLabel4 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.txtorgSupp = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.LabelNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.LabelDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.LabelStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.LabelDepartment = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.LabelAddresses = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.LabelType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.LabelPresentedPerson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contreason = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsalePerson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contposition = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contupperPosition = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpredictAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.pkAuditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtAuditors = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtadminOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtaddresses = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbillType = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtpresentedPerson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.scrollPanereason = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txtreason = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.prmtsalePerson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtposition = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtupperPosition = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtpredictAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.btnRefresh = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.newSeparator1 = new javax.swing.JToolBar.Separator();
        this.Audit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.unAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.kdtEntry.setName("kdtEntry");
        this.contAuditTime.setName("contAuditTime");
        this.contAuditors.setName("contAuditors");
        this.txttext1.setName("txttext1");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.kDLabel3.setName("kDLabel3");
        this.txttext2.setName("txttext2");
        this.txtKeyWord.setName("txtKeyWord");
        this.kDLabel4.setName("kDLabel4");
        this.txtorgSupp.setName("txtorgSupp");
        this.LabelNumber.setName("LabelNumber");
        this.LabelDate.setName("LabelDate");
        this.LabelStatus.setName("LabelStatus");
        this.LabelDepartment.setName("LabelDepartment");
        this.LabelAddresses.setName("LabelAddresses");
        this.LabelType.setName("LabelType");
        this.LabelPresentedPerson.setName("LabelPresentedPerson");
        this.kDSeparator8.setName("kDSeparator8");
        this.contreason.setName("contreason");
        this.contsalePerson.setName("contsalePerson");
        this.contposition.setName("contposition");
        this.contupperPosition.setName("contupperPosition");
        this.contpredictAmt.setName("contpredictAmt");
        this.pkAuditTime.setName("pkAuditTime");
        this.prmtAuditors.setName("prmtAuditors");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.billStatus.setName("billStatus");
        this.prmtadminOrgUnit.setName("prmtadminOrgUnit");
        this.prmtaddresses.setName("prmtaddresses");
        this.prmtbillType.setName("prmtbillType");
        this.prmtpresentedPerson.setName("prmtpresentedPerson");
        this.scrollPanereason.setName("scrollPanereason");
        this.txtreason.setName("txtreason");
        this.prmtsalePerson.setName("prmtsalePerson");
        this.prmtposition.setName("prmtposition");
        this.prmtupperPosition.setName("prmtupperPosition");
        this.txtpredictAmt.setName("txtpredictAmt");
        this.btnRefresh.setName("btnRefresh");
        this.newSeparator1.setName("newSeparator1");
        this.Audit.setName("Audit");
        this.unAudit.setName("unAudit");
        // CoreUI		
        this.setFont(resHelper.getFont("this.font"));		
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
        // kdtEntry
		String kdtEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"0\" t:styleID=\"sCol0\" /><t:Column t:key=\"Project\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"1\" /><t:Column t:key=\"Unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"2\" /><t:Column t:key=\"Quantity\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"3\" t:styleID=\"sCol3\" /><t:Column t:key=\"Price\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" t:styleID=\"sCol4\" /><t:Column t:key=\"Amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" t:styleID=\"sCol5\" /><t:Column t:key=\"Statement\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"6\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{Project}</t:Cell><t:Cell>$Resource{Unit}</t:Cell><t:Cell>$Resource{Quantity}</t:Cell><t:Cell>$Resource{Price}</t:Cell><t:Cell>$Resource{Amount}</t:Cell><t:Cell>$Resource{Statement}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtEntry.putBindContents("editData",new String[] {"seq","Project","Unit","Quantity","Price","Amount","Statement"});


        this.kdtEntry.checkParsed();
        KDFormattedTextField kdtEntry_seq_TextField = new KDFormattedTextField();
        kdtEntry_seq_TextField.setName("kdtEntry_seq_TextField");
        kdtEntry_seq_TextField.setVisible(true);
        kdtEntry_seq_TextField.setEditable(true);
        kdtEntry_seq_TextField.setHorizontalAlignment(2);
        kdtEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtEntry_seq_TextField);
        this.kdtEntry.getColumn("seq").setEditor(kdtEntry_seq_CellEditor);
        KDTextField kdtEntry_Project_TextField = new KDTextField();
        kdtEntry_Project_TextField.setName("kdtEntry_Project_TextField");
        kdtEntry_Project_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntry_Project_CellEditor = new KDTDefaultCellEditor(kdtEntry_Project_TextField);
        this.kdtEntry.getColumn("Project").setEditor(kdtEntry_Project_CellEditor);
        KDTextField kdtEntry_Unit_TextField = new KDTextField();
        kdtEntry_Unit_TextField.setName("kdtEntry_Unit_TextField");
        kdtEntry_Unit_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntry_Unit_CellEditor = new KDTDefaultCellEditor(kdtEntry_Unit_TextField);
        this.kdtEntry.getColumn("Unit").setEditor(kdtEntry_Unit_CellEditor);
        KDFormattedTextField kdtEntry_Quantity_TextField = new KDFormattedTextField();
        kdtEntry_Quantity_TextField.setName("kdtEntry_Quantity_TextField");
        kdtEntry_Quantity_TextField.setVisible(true);
        kdtEntry_Quantity_TextField.setEditable(true);
        kdtEntry_Quantity_TextField.setHorizontalAlignment(2);
        kdtEntry_Quantity_TextField.setDataType(1);
        	kdtEntry_Quantity_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_Quantity_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_Quantity_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_Quantity_CellEditor = new KDTDefaultCellEditor(kdtEntry_Quantity_TextField);
        this.kdtEntry.getColumn("Quantity").setEditor(kdtEntry_Quantity_CellEditor);
        KDFormattedTextField kdtEntry_Price_TextField = new KDFormattedTextField();
        kdtEntry_Price_TextField.setName("kdtEntry_Price_TextField");
        kdtEntry_Price_TextField.setVisible(true);
        kdtEntry_Price_TextField.setEditable(true);
        kdtEntry_Price_TextField.setHorizontalAlignment(2);
        kdtEntry_Price_TextField.setDataType(1);
        	kdtEntry_Price_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_Price_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_Price_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_Price_CellEditor = new KDTDefaultCellEditor(kdtEntry_Price_TextField);
        this.kdtEntry.getColumn("Price").setEditor(kdtEntry_Price_CellEditor);
        KDFormattedTextField kdtEntry_Amount_TextField = new KDFormattedTextField();
        kdtEntry_Amount_TextField.setName("kdtEntry_Amount_TextField");
        kdtEntry_Amount_TextField.setVisible(true);
        kdtEntry_Amount_TextField.setEditable(true);
        kdtEntry_Amount_TextField.setHorizontalAlignment(2);
        kdtEntry_Amount_TextField.setDataType(1);
        	kdtEntry_Amount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_Amount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_Amount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_Amount_CellEditor = new KDTDefaultCellEditor(kdtEntry_Amount_TextField);
        this.kdtEntry.getColumn("Amount").setEditor(kdtEntry_Amount_CellEditor);
        KDTextField kdtEntry_Statement_TextField = new KDTextField();
        kdtEntry_Statement_TextField.setName("kdtEntry_Statement_TextField");
        kdtEntry_Statement_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntry_Statement_CellEditor = new KDTDefaultCellEditor(kdtEntry_Statement_TextField);
        this.kdtEntry.getColumn("Statement").setEditor(kdtEntry_Statement_CellEditor);
        // contAuditTime		
        this.contAuditTime.setBoundLabelText(resHelper.getString("contAuditTime.boundLabelText"));		
        this.contAuditTime.setBoundLabelLength(100);		
        this.contAuditTime.setVisible(true);
        // contAuditors		
        this.contAuditors.setBoundLabelText(resHelper.getString("contAuditors.boundLabelText"));		
        this.contAuditors.setBoundLabelLength(100);		
        this.contAuditors.setVisible(true);
        // txttext1		
        this.txttext1.setHorizontalAlignment(2);		
        this.txttext1.setMaxLength(100);		
        this.txttext1.setRequired(false);		
        this.txttext1.setText(resHelper.getString("txttext1.text"));		
        this.txttext1.setFont(resHelper.getFont("txttext1.font"));		
        this.txttext1.setEnabled(false);
        this.txttext1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    txttext1_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // contLastUpdateTime		
        this.contLastUpdateTime.setBoundLabelText(resHelper.getString("contLastUpdateTime.boundLabelText"));		
        this.contLastUpdateTime.setBoundLabelLength(100);		
        this.contLastUpdateTime.setBoundLabelUnderline(true);		
        this.contLastUpdateTime.setEnabled(false);		
        this.contLastUpdateTime.setVisible(false);
        // kDLabel3		
        this.kDLabel3.setText(resHelper.getString("kDLabel3.text"));		
        this.kDLabel3.setFont(resHelper.getFont("kDLabel3.font"));
        // txttext2		
        this.txttext2.setHorizontalAlignment(2);		
        this.txttext2.setMaxLength(100);		
        this.txttext2.setRequired(false);		
        this.txttext2.setText(resHelper.getString("txttext2.text"));		
        this.txttext2.setFont(resHelper.getFont("txttext2.font"));		
        this.txttext2.setEnabled(false);
        // txtKeyWord		
        this.txtKeyWord.setHorizontalAlignment(2);		
        this.txtKeyWord.setMaxLength(150);		
        this.txtKeyWord.setRequired(true);		
        this.txtKeyWord.setFont(resHelper.getFont("txtKeyWord.font"));		
        this.txtKeyWord.setBackground(new java.awt.Color(236,255,255));
        // kDLabel4		
        this.kDLabel4.setFont(resHelper.getFont("kDLabel4.font"));		
        this.kDLabel4.setHorizontalAlignment(0);		
        this.kDLabel4.setHorizontalTextPosition(0);
        // txtorgSupp		
        this.txtorgSupp.setVisible(false);		
        this.txtorgSupp.setHorizontalAlignment(2);		
        this.txtorgSupp.setMaxLength(100);		
        this.txtorgSupp.setRequired(false);		
        this.txtorgSupp.setEnabled(false);
        // LabelNumber		
        this.LabelNumber.setBoundLabelText(resHelper.getString("LabelNumber.boundLabelText"));		
        this.LabelNumber.setBoundLabelLength(100);		
        this.LabelNumber.setBoundLabelUnderline(true);
        // LabelDate		
        this.LabelDate.setBoundLabelText(resHelper.getString("LabelDate.boundLabelText"));		
        this.LabelDate.setBoundLabelLength(100);		
        this.LabelDate.setBoundLabelUnderline(true);
        // LabelStatus		
        this.LabelStatus.setBoundLabelText(resHelper.getString("LabelStatus.boundLabelText"));		
        this.LabelStatus.setBoundLabelLength(100);		
        this.LabelStatus.setBoundLabelUnderline(true);
        // LabelDepartment		
        this.LabelDepartment.setBoundLabelText(resHelper.getString("LabelDepartment.boundLabelText"));		
        this.LabelDepartment.setBoundLabelLength(100);		
        this.LabelDepartment.setBoundLabelUnderline(true);
        // LabelAddresses		
        this.LabelAddresses.setBoundLabelText(resHelper.getString("LabelAddresses.boundLabelText"));		
        this.LabelAddresses.setBoundLabelLength(100);		
        this.LabelAddresses.setBoundLabelUnderline(true);
        // LabelType		
        this.LabelType.setBoundLabelText(resHelper.getString("LabelType.boundLabelText"));		
        this.LabelType.setBoundLabelLength(100);		
        this.LabelType.setBoundLabelUnderline(true);
        // LabelPresentedPerson		
        this.LabelPresentedPerson.setBoundLabelText(resHelper.getString("LabelPresentedPerson.boundLabelText"));		
        this.LabelPresentedPerson.setBoundLabelLength(100);		
        this.LabelPresentedPerson.setBoundLabelUnderline(true);
        // kDSeparator8
        // contreason		
        this.contreason.setBoundLabelText(resHelper.getString("contreason.boundLabelText"));		
        this.contreason.setBoundLabelLength(0);		
        this.contreason.setBoundLabelUnderline(true);		
        this.contreason.setVisible(true);
        // contsalePerson		
        this.contsalePerson.setBoundLabelText(resHelper.getString("contsalePerson.boundLabelText"));		
        this.contsalePerson.setBoundLabelLength(100);		
        this.contsalePerson.setBoundLabelUnderline(true);		
        this.contsalePerson.setVisible(true);
        // contposition		
        this.contposition.setBoundLabelText(resHelper.getString("contposition.boundLabelText"));		
        this.contposition.setBoundLabelLength(100);		
        this.contposition.setBoundLabelUnderline(true);		
        this.contposition.setVisible(false);
        // contupperPosition		
        this.contupperPosition.setBoundLabelText(resHelper.getString("contupperPosition.boundLabelText"));		
        this.contupperPosition.setBoundLabelLength(100);		
        this.contupperPosition.setBoundLabelUnderline(true);		
        this.contupperPosition.setVisible(false);
        // contpredictAmt		
        this.contpredictAmt.setBoundLabelText(resHelper.getString("contpredictAmt.boundLabelText"));		
        this.contpredictAmt.setBoundLabelLength(100);		
        this.contpredictAmt.setBoundLabelUnderline(true);		
        this.contpredictAmt.setVisible(true);
        // pkAuditTime		
        this.pkAuditTime.setRequired(false);
        this.pkAuditTime.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    pkAuditTime_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // prmtAuditors		
        this.prmtAuditors.setQueryInfo("com.kingdee.eas.base.permission.app.UserListQuery");		
        this.prmtAuditors.setEditable(true);		
        this.prmtAuditors.setDisplayFormat("$number$");		
        this.prmtAuditors.setEditFormat("$number$");		
        this.prmtAuditors.setCommitFormat("$number$");		
        this.prmtAuditors.setRequired(false);
        // kDDateLastUpdateTime		
        this.kDDateLastUpdateTime.setTimeEnabled(true);		
        this.kDDateLastUpdateTime.setEnabled(false);		
        this.kDDateLastUpdateTime.setVisible(false);
        // txtNumber		
        this.txtNumber.setHorizontalAlignment(2);		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setRequired(false);
        // pkBizDate		
        this.pkBizDate.setEnabled(true);		
        this.pkBizDate.setRequired(true);
        // billStatus		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.signwasthetable.billStatus").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // prmtadminOrgUnit		
        this.prmtadminOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtadminOrgUnit.setEditable(true);		
        this.prmtadminOrgUnit.setDisplayFormat("$name$");		
        this.prmtadminOrgUnit.setEditFormat("$number$");		
        this.prmtadminOrgUnit.setCommitFormat("$number$");		
        this.prmtadminOrgUnit.setRequired(true);
        this.prmtadminOrgUnit.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtadminOrgUnit_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // prmtaddresses		
        this.prmtaddresses.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtaddresses.setEditable(true);		
        this.prmtaddresses.setDisplayFormat("$name$");		
        this.prmtaddresses.setEditFormat("$number$");		
        this.prmtaddresses.setCommitFormat("$number$");		
        this.prmtaddresses.setRequired(true);
        // prmtbillType		
        this.prmtbillType.setQueryInfo("com.kingdee.eas.custom.signwasthetable.app.SignBDQuery");		
        this.prmtbillType.setEditable(true);		
        this.prmtbillType.setDisplayFormat("$name$");		
        this.prmtbillType.setEditFormat("$number$");		
        this.prmtbillType.setCommitFormat("$number$");		
        this.prmtbillType.setRequired(true);
        this.prmtbillType.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtbillType_dataChang(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // prmtpresentedPerson		
        this.prmtpresentedPerson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtpresentedPerson.setEditable(true);		
        this.prmtpresentedPerson.setDisplayFormat("$name$");		
        this.prmtpresentedPerson.setEditFormat("$number$");		
        this.prmtpresentedPerson.setCommitFormat("$number$");		
        this.prmtpresentedPerson.setRequired(true);
        this.prmtpresentedPerson.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtpresentedPerson_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // scrollPanereason
        // txtreason		
        this.txtreason.setVisible(true);		
        this.txtreason.setRequired(true);		
        this.txtreason.setMaxLength(2000);
        // prmtsalePerson		
        this.prmtsalePerson.setQueryInfo("com.kingdee.eas.basedata.scm.sd.sale.app.F7SalePersonQuery");		
        this.prmtsalePerson.setVisible(true);		
        this.prmtsalePerson.setEditable(true);		
        this.prmtsalePerson.setDisplayFormat("$name$");		
        this.prmtsalePerson.setEditFormat("$number$");		
        this.prmtsalePerson.setCommitFormat("$number$");		
        this.prmtsalePerson.setRequired(false);
        this.prmtsalePerson.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtsalePerson_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // prmtposition		
        this.prmtposition.setQueryInfo("com.kingdee.eas.hr.org.app.PositionHRListQuery");		
        this.prmtposition.setVisible(false);		
        this.prmtposition.setEditable(true);		
        this.prmtposition.setDisplayFormat("$name$");		
        this.prmtposition.setEditFormat("$number$");		
        this.prmtposition.setCommitFormat("$number$");		
        this.prmtposition.setRequired(false);
        // prmtupperPosition		
        this.prmtupperPosition.setQueryInfo("com.kingdee.eas.hr.org.app.PositionHRListQuery");		
        this.prmtupperPosition.setVisible(false);		
        this.prmtupperPosition.setEditable(true);		
        this.prmtupperPosition.setDisplayFormat("$name$");		
        this.prmtupperPosition.setEditFormat("$number$");		
        this.prmtupperPosition.setCommitFormat("$number$");		
        this.prmtupperPosition.setRequired(false);
        // txtpredictAmt		
        this.txtpredictAmt.setVisible(true);		
        this.txtpredictAmt.setHorizontalAlignment(2);		
        this.txtpredictAmt.setDataType(1);		
        this.txtpredictAmt.setSupportedEmpty(true);		
        this.txtpredictAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpredictAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpredictAmt.setPrecision(2);		
        this.txtpredictAmt.setRequired(false);
        // btnRefresh
        this.btnRefresh.setAction((IItemAction)ActionProxyFactory.getProxy(actionBtnRefresh, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnRefresh.setText(resHelper.getString("btnRefresh.text"));
        // newSeparator1		
        this.newSeparator1.setOrientation(1);
        // Audit
        this.Audit.setAction((IItemAction)ActionProxyFactory.getProxy(actionCheck, new Class[] { IItemAction.class }, getServiceContext()));		
        this.Audit.setText(resHelper.getString("Audit.text"));
        // unAudit
        this.unAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.unAudit.setText(resHelper.getString("unAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,prmtaddresses,prmtpresentedPerson,txtKeyWord,kDDateLastUpdateTime,txttext1,txttext2,prmtAuditors,pkAuditTime,billStatus,prmtadminOrgUnit,txtorgSupp,prmtbillType,kdtEntry,txtreason,prmtsalePerson,prmtposition,prmtupperPosition,txtpredictAmt}));
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
        kdtEntry.setBounds(new Rectangle(117, 416, 772, 196));
        kdtEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntry,new com.kingdee.eas.custom.signwasthetable.SignWasTheTableEntryInfo(),null,false);
        this.add(kdtEntry_detailPanel, new KDLayout.Constraints(117, 416, 772, 196, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditTime.setBounds(new Rectangle(530, 570, 270, 19));
        this.add(contAuditTime, new KDLayout.Constraints(530, 570, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditors.setBounds(new Rectangle(530, 531, 270, 19));
        this.add(contAuditors, new KDLayout.Constraints(530, 531, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        txttext1.setBounds(new Rectangle(118, 195, 770, 32));
        this.add(txttext1, new KDLayout.Constraints(118, 195, 770, 32, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateTime.setBounds(new Rectangle(832, 594, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(832, 594, 270, 19, 0));
        kDLabel3.setBounds(new Rectangle(503, 28, 77, 19));
        this.add(kDLabel3, new KDLayout.Constraints(503, 28, 77, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        txttext2.setBounds(new Rectangle(118, 135, 770, 32));
        this.add(txttext2, new KDLayout.Constraints(118, 135, 770, 32, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        txtKeyWord.setBounds(new Rectangle(118, 165, 770, 32));
        this.add(txtKeyWord, new KDLayout.Constraints(118, 165, 770, 32, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabel4.setBounds(new Rectangle(229, 0, 615, 36));
        this.add(kDLabel4, new KDLayout.Constraints(229, 0, 615, 36, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        txtorgSupp.setBounds(new Rectangle(60, 8, 170, 19));
        this.add(txtorgSupp, new KDLayout.Constraints(60, 8, 170, 19, 0));
        LabelNumber.setBounds(new Rectangle(687, 54, 270, 19));
        this.add(LabelNumber, new KDLayout.Constraints(687, 54, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        LabelDate.setBounds(new Rectangle(378, 54, 270, 19));
        this.add(LabelDate, new KDLayout.Constraints(378, 54, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        LabelStatus.setBounds(new Rectangle(687, 82, 270, 19));
        this.add(LabelStatus, new KDLayout.Constraints(687, 82, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        LabelDepartment.setBounds(new Rectangle(378, 82, 270, 19));
        this.add(LabelDepartment, new KDLayout.Constraints(378, 82, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        LabelAddresses.setBounds(new Rectangle(60, 54, 270, 19));
        this.add(LabelAddresses, new KDLayout.Constraints(60, 54, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        LabelType.setBounds(new Rectangle(60, 108, 270, 19));
        this.add(LabelType, new KDLayout.Constraints(60, 108, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        LabelPresentedPerson.setBounds(new Rectangle(60, 81, 270, 19));
        this.add(LabelPresentedPerson, new KDLayout.Constraints(60, 81, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator8.setBounds(new Rectangle(25, 402, 967, 8));
        this.add(kDSeparator8, new KDLayout.Constraints(25, 402, 967, 8, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contreason.setBounds(new Rectangle(116, 223, 774, 178));
        this.add(contreason, new KDLayout.Constraints(116, 223, 774, 178, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contsalePerson.setBounds(new Rectangle(684, 11, 270, 19));
        this.add(contsalePerson, new KDLayout.Constraints(684, 11, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contposition.setBounds(new Rectangle(688, 110, 270, 19));
        this.add(contposition, new KDLayout.Constraints(688, 110, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contupperPosition.setBounds(new Rectangle(688, 32, 270, 19));
        this.add(contupperPosition, new KDLayout.Constraints(688, 32, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contpredictAmt.setBounds(new Rectangle(378, 108, 270, 19));
        this.add(contpredictAmt, new KDLayout.Constraints(378, 108, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contAuditTime
        contAuditTime.setBoundEditor(pkAuditTime);
        //contAuditors
        contAuditors.setBoundEditor(prmtAuditors);
        //contLastUpdateTime
        contLastUpdateTime.setBoundEditor(kDDateLastUpdateTime);
        //LabelNumber
        LabelNumber.setBoundEditor(txtNumber);
        //LabelDate
        LabelDate.setBoundEditor(pkBizDate);
        //LabelStatus
        LabelStatus.setBoundEditor(billStatus);
        //LabelDepartment
        LabelDepartment.setBoundEditor(prmtadminOrgUnit);
        //LabelAddresses
        LabelAddresses.setBoundEditor(prmtaddresses);
        //LabelType
        LabelType.setBoundEditor(prmtbillType);
        //LabelPresentedPerson
        LabelPresentedPerson.setBoundEditor(prmtpresentedPerson);
        //contreason
        contreason.setBoundEditor(scrollPanereason);
        //scrollPanereason
        scrollPanereason.getViewport().add(txtreason, null);
        //contsalePerson
        contsalePerson.setBoundEditor(prmtsalePerson);
        //contposition
        contposition.setBoundEditor(prmtposition);
        //contupperPosition
        contupperPosition.setBoundEditor(prmtupperPosition);
        //contpredictAmt
        contpredictAmt.setBoundEditor(txtpredictAmt);

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
        this.toolBar.add(btnRefresh);
        this.toolBar.add(separatorFW1);
        this.toolBar.add(btnPrint);
        this.toolBar.add(btnPrintPreview);
        this.toolBar.add(btnAttachment);
        this.toolBar.add(newSeparator1);
        this.toolBar.add(btnFirst);
        this.toolBar.add(btnPre);
        this.toolBar.add(btnNext);
        this.toolBar.add(btnLast);
        this.toolBar.add(separatorFW2);
        this.toolBar.add(Audit);
        this.toolBar.add(unAudit);
        this.toolBar.add(separatorFW6);
        this.toolBar.add(separatorFW4);
        this.toolBar.add(btnTraceUp);
        this.toolBar.add(btnTraceDown);
        this.toolBar.add(btnWorkFlowG);
        this.toolBar.add(btnCreateFrom);
        this.toolBar.add(btnSignature);
        this.toolBar.add(btnCopyFrom);
        this.toolBar.add(btnViewSignature);
        this.toolBar.add(btnCreateTo);
        this.toolBar.add(separatorFW3);
        this.toolBar.add(btnNumberSign);
        this.toolBar.add(btnAddLine);
        this.toolBar.add(btnCopyLine);
        this.toolBar.add(btnVoucher);
        this.toolBar.add(btnInsertLine);
        this.toolBar.add(btnRemoveLine);
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(separatorFW7);
        this.toolBar.add(separatorFW9);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(separatorFW8);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(btnNextPerson);
        this.toolBar.add(separatorFW5);
        this.toolBar.add(btnPageSetup);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("Entry.seq", int.class, this.kdtEntry, "seq.text");
		dataBinder.registerBinding("Entry", com.kingdee.eas.custom.signwasthetable.SignWasTheTableEntryInfo.class, this.kdtEntry, "userObject");
		dataBinder.registerBinding("Entry.Amount", java.math.BigDecimal.class, this.kdtEntry, "Amount.text");
		dataBinder.registerBinding("Entry.Statement", String.class, this.kdtEntry, "Statement.text");
		dataBinder.registerBinding("Entry.Price", java.math.BigDecimal.class, this.kdtEntry, "Price.text");
		dataBinder.registerBinding("Entry.Quantity", java.math.BigDecimal.class, this.kdtEntry, "Quantity.text");
		dataBinder.registerBinding("Entry.Unit", String.class, this.kdtEntry, "Unit.text");
		dataBinder.registerBinding("Entry.Project", String.class, this.kdtEntry, "Project.text");
		dataBinder.registerBinding("text1", String.class, this.txttext1, "text");
		dataBinder.registerBinding("text2", String.class, this.txttext2, "text");
		dataBinder.registerBinding("KeyWord", String.class, this.txtKeyWord, "text");
		dataBinder.registerBinding("orgSupp", String.class, this.txtorgSupp, "text");
		dataBinder.registerBinding("AuditTime", java.util.Date.class, this.pkAuditTime, "value");
		dataBinder.registerBinding("Auditors", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditors, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.custom.signwasthetable.billStatus.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("adminOrgUnit", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtadminOrgUnit, "data");
		dataBinder.registerBinding("addresses", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtaddresses, "data");
		dataBinder.registerBinding("billType", com.kingdee.eas.custom.signwasthetable.SignBDInfo.class, this.prmtbillType, "data");
		dataBinder.registerBinding("presentedPerson", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtpresentedPerson, "data");
		dataBinder.registerBinding("reason", String.class, this.txtreason, "text");
		dataBinder.registerBinding("salePerson", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtsalePerson, "data");
		dataBinder.registerBinding("position", com.kingdee.eas.basedata.org.PositionInfo.class, this.prmtposition, "data");
		dataBinder.registerBinding("upperPosition", com.kingdee.eas.basedata.org.PositionInfo.class, this.prmtupperPosition, "data");
		dataBinder.registerBinding("predictAmt", java.math.BigDecimal.class, this.txtpredictAmt, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.signwasthetable.app.SignWasTheTableEditUIHandler";
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
        this.editData = (com.kingdee.eas.custom.signwasthetable.SignWasTheTableInfo)ov;
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
		getValidateHelper().registerBindProperty("Entry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.Amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.Statement", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.Price", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.Quantity", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.Unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.Project", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("text1", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("text2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("KeyWord", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("orgSupp", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AuditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Auditors", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("adminOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("addresses", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("presentedPerson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("reason", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("salePerson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("position", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("upperPosition", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("predictAmt", ValidateHelper.ON_SAVE);    		
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
     * output txttext1_actionPerformed method
     */
    protected void txttext1_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output pkAuditTime_dataChanged method
     */
    protected void pkAuditTime_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output prmtadminOrgUnit_dataChange method
     */
    protected void prmtadminOrgUnit_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output prmtbillType_dataChang method
     */
    protected void prmtbillType_dataChang(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output prmtpresentedPerson_dataChanged method
     */
    protected void prmtpresentedPerson_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output prmtsalePerson_dataChanged method
     */
    protected void prmtsalePerson_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        //write your code here
    }


    /**
     * output kdtEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("Quantity".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntry.getCell(rowIndex,"Price").getValue())|| com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntry.getCell(rowIndex,"Quantity").getValue())) 
{
}
else
{
    kdtEntry.getCell(rowIndex,"Amount").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntry.getCell(rowIndex,"Price").getValue())* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntry.getCell(rowIndex,"Quantity").getValue())));
}

}

    if ("Quantity".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntry.getCell(rowIndex,"Amount").getValue())|| com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntry.getCell(rowIndex,"Quantity").getValue())) 
{
}
else
{
    kdtEntry.getCell(rowIndex,"Price").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntry.getCell(rowIndex,"Amount").getValue())/ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntry.getCell(rowIndex,"Quantity").getValue())));
}

}

    if ("Price".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntry.getCell(rowIndex,"Price").getValue())|| com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntry.getCell(rowIndex,"Quantity").getValue())) 
{
}
else
{
    kdtEntry.getCell(rowIndex,"Amount").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntry.getCell(rowIndex,"Price").getValue())* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntry.getCell(rowIndex,"Quantity").getValue())));
}

}

    if ("Amount".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntry.getCell(rowIndex,"Amount").getValue())|| com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntry.getCell(rowIndex,"Quantity").getValue())) 
{
}
else
{
    kdtEntry.getCell(rowIndex,"Price").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntry.getCell(rowIndex,"Amount").getValue())/ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntry.getCell(rowIndex,"Quantity").getValue())));
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
    	sic.add(new SelectorItemInfo("Entry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("Entry.Amount"));
    	sic.add(new SelectorItemInfo("Entry.Statement"));
    	sic.add(new SelectorItemInfo("Entry.Price"));
    	sic.add(new SelectorItemInfo("Entry.Quantity"));
    	sic.add(new SelectorItemInfo("Entry.Unit"));
    	sic.add(new SelectorItemInfo("Entry.Project"));
        sic.add(new SelectorItemInfo("text1"));
        sic.add(new SelectorItemInfo("text2"));
        sic.add(new SelectorItemInfo("KeyWord"));
        sic.add(new SelectorItemInfo("orgSupp"));
        sic.add(new SelectorItemInfo("AuditTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Auditors.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("Auditors.id"));
        	sic.add(new SelectorItemInfo("Auditors.number"));
        	sic.add(new SelectorItemInfo("Auditors.name"));
		}
        sic.add(new SelectorItemInfo("lastUpdateTime"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("bizDate"));
        sic.add(new SelectorItemInfo("billStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("adminOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("adminOrgUnit.id"));
        	sic.add(new SelectorItemInfo("adminOrgUnit.number"));
        	sic.add(new SelectorItemInfo("adminOrgUnit.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("addresses.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("addresses.id"));
        	sic.add(new SelectorItemInfo("addresses.number"));
        	sic.add(new SelectorItemInfo("addresses.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("billType.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("billType.id"));
        	sic.add(new SelectorItemInfo("billType.number"));
        	sic.add(new SelectorItemInfo("billType.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("presentedPerson.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("presentedPerson.id"));
        	sic.add(new SelectorItemInfo("presentedPerson.number"));
        	sic.add(new SelectorItemInfo("presentedPerson.name"));
		}
        sic.add(new SelectorItemInfo("reason"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("salePerson.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("salePerson.id"));
        	sic.add(new SelectorItemInfo("salePerson.number"));
        	sic.add(new SelectorItemInfo("salePerson.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("position.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("position.id"));
        	sic.add(new SelectorItemInfo("position.number"));
        	sic.add(new SelectorItemInfo("position.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("upperPosition.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("upperPosition.id"));
        	sic.add(new SelectorItemInfo("upperPosition.number"));
        	sic.add(new SelectorItemInfo("upperPosition.name"));
		}
        sic.add(new SelectorItemInfo("predictAmt"));
        return sic;
    }        
    	

    /**
     * output actionPageSetup_actionPerformed method
     */
    public void actionPageSetup_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPageSetup_actionPerformed(e);
    }
    	

    /**
     * output actionSave_actionPerformed method
     */
    public void actionSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSave_actionPerformed(e);
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
     * output actionCheck_actionPerformed method
     */
    public void actionCheck_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.signwasthetable.SignWasTheTableFactory.getRemoteInstance().check(editData);
    }
    	

    /**
     * output actionListener_actionPerformed method
     */
    public void actionListener_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.signwasthetable.SignWasTheTableFactory.getRemoteInstance().listener(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.signwasthetable.SignWasTheTableFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionBtnRefresh_actionPerformed method
     */
    public void actionBtnRefresh_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.signwasthetable.SignWasTheTableFactory.getRemoteInstance().btnRefresh(editData);
    }
	public RequestContext prepareActionPageSetup(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionPageSetup(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionPageSetup() {
    	return false;
    }
	public RequestContext prepareActionSave(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionSave(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionSave() {
    	return false;
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
	public RequestContext prepareActionCheck(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionCheck() {
    	return false;
    }
	public RequestContext prepareActionListener(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionListener() {
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
	public RequestContext prepareActionBtnRefresh(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionBtnRefresh() {
    	return false;
    }

    /**
     * output ActionCheck class
     */     
    protected class ActionCheck extends ItemAction {     
    
        public ActionCheck()
        {
            this(null);
        }

        public ActionCheck(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionCheck.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCheck.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCheck.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractSignWasTheTableEditUI.this, "ActionCheck", "actionCheck_actionPerformed", e);
        }
    }

    /**
     * output ActionListener class
     */     
    protected class ActionListener extends ItemAction {     
    
        public ActionListener()
        {
            this(null);
        }

        public ActionListener(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionListener.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionListener.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionListener.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractSignWasTheTableEditUI.this, "ActionListener", "actionListener_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractSignWasTheTableEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionBtnRefresh class
     */     
    protected class ActionBtnRefresh extends ItemAction {     
    
        public ActionBtnRefresh()
        {
            this(null);
        }

        public ActionBtnRefresh(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionBtnRefresh.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionBtnRefresh.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionBtnRefresh.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractSignWasTheTableEditUI.this, "ActionBtnRefresh", "actionBtnRefresh_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.signwasthetable.client", "SignWasTheTableEditUI");
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
        return com.kingdee.eas.custom.signwasthetable.client.SignWasTheTableEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.signwasthetable.SignWasTheTableFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.signwasthetable.SignWasTheTableInfo objectValue = new com.kingdee.eas.custom.signwasthetable.SignWasTheTableInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/signwasthetable/SignWasTheTable";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.signwasthetable.app.SignWasTheTableQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtKeyWord.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"主旨"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtadminOrgUnit.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"行政组织单元"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtaddresses.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"受文者"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtbillType.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"签呈类型"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtpresentedPerson.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"呈送者"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtreason.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"说明"});
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
				vo.setString("text1","2、说明（理由、数据、附件、建议）");
		vo.setString("text2","1.主旨");
vo.put("billStatus","1");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}