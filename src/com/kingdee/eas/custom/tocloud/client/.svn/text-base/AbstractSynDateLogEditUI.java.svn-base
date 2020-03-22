/**
 * output package name
 */
package com.kingdee.eas.custom.tocloud.client;

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
public abstract class AbstractSynDateLogEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSynDateLogEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstorareBill;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstorareBill;
    protected com.kingdee.eas.custom.tocloud.SynDateLogInfo editData = null;
    protected ActionDeleteEntry actionDeleteEntry = null;
    /**
     * output class constructor
     */
    public AbstractSynDateLogEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractSynDateLogEditUI.class.getName());
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
        //actionDeleteEntry
        this.actionDeleteEntry = new ActionDeleteEntry(this);
        getActionManager().registerAction("actionDeleteEntry", actionDeleteEntry);
        this.actionDeleteEntry.setExtendProperty("canForewarn", "true");
        this.actionDeleteEntry.setExtendProperty("userDefined", "true");
        this.actionDeleteEntry.setExtendProperty("isObjectUpdateLock", "false");
         this.actionDeleteEntry.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionDeleteEntry.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contstorareBill = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtstorareBill = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.kdtEntrys.setName("kdtEntrys");
        this.contstorareBill.setName("contstorareBill");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtstorareBill.setName("prmtstorareBill");
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
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"targetSystemName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"bizTypeid\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"bizTypeName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"companyName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"synDateTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"entryid\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"billid\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"batchName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"house\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"Cloudid\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"CloudNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"isSuccess\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"costTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"synDateInformation\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"billNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"stockingBizDateStocking\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"storage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{targetSystemName}</t:Cell><t:Cell>$Resource{bizTypeid}</t:Cell><t:Cell>$Resource{bizTypeName}</t:Cell><t:Cell>$Resource{companyName}</t:Cell><t:Cell>$Resource{synDateTime}</t:Cell><t:Cell>$Resource{entryid}</t:Cell><t:Cell>$Resource{billid}</t:Cell><t:Cell>$Resource{batchName}</t:Cell><t:Cell>$Resource{house}</t:Cell><t:Cell>$Resource{Cloudid}</t:Cell><t:Cell>$Resource{CloudNum}</t:Cell><t:Cell>$Resource{isSuccess}</t:Cell><t:Cell>$Resource{costTime}</t:Cell><t:Cell>$Resource{synDateInformation}</t:Cell><t:Cell>$Resource{billNumber}</t:Cell><t:Cell>$Resource{stockingBizDateStocking}</t:Cell><t:Cell>$Resource{storage}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));

                this.kdtEntrys.putBindContents("editData",new String[] {"id","targetSystemName","bizTypeid","bizTypeName","companyName","synDateTime","entryid","billid","batchName","house","Cloudid","CloudNum","isSuccess","costTime","synDateInformation","billNumber","stockingBizDateStocking","storage"});


        this.kdtEntrys.checkParsed();
        KDTextField kdtEntrys_targetSystemName_TextField = new KDTextField();
        kdtEntrys_targetSystemName_TextField.setName("kdtEntrys_targetSystemName_TextField");
        kdtEntrys_targetSystemName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_targetSystemName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_targetSystemName_TextField);
        this.kdtEntrys.getColumn("targetSystemName").setEditor(kdtEntrys_targetSystemName_CellEditor);
        KDTextField kdtEntrys_bizTypeid_TextField = new KDTextField();
        kdtEntrys_bizTypeid_TextField.setName("kdtEntrys_bizTypeid_TextField");
        kdtEntrys_bizTypeid_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_bizTypeid_CellEditor = new KDTDefaultCellEditor(kdtEntrys_bizTypeid_TextField);
        this.kdtEntrys.getColumn("bizTypeid").setEditor(kdtEntrys_bizTypeid_CellEditor);
        KDTextField kdtEntrys_bizTypeName_TextField = new KDTextField();
        kdtEntrys_bizTypeName_TextField.setName("kdtEntrys_bizTypeName_TextField");
        kdtEntrys_bizTypeName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_bizTypeName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_bizTypeName_TextField);
        this.kdtEntrys.getColumn("bizTypeName").setEditor(kdtEntrys_bizTypeName_CellEditor);
        KDTextField kdtEntrys_companyName_TextField = new KDTextField();
        kdtEntrys_companyName_TextField.setName("kdtEntrys_companyName_TextField");
        kdtEntrys_companyName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_companyName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_companyName_TextField);
        this.kdtEntrys.getColumn("companyName").setEditor(kdtEntrys_companyName_CellEditor);
        KDTextField kdtEntrys_synDateTime_TextField = new KDTextField();
        kdtEntrys_synDateTime_TextField.setName("kdtEntrys_synDateTime_TextField");
        kdtEntrys_synDateTime_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_synDateTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_synDateTime_TextField);
        this.kdtEntrys.getColumn("synDateTime").setEditor(kdtEntrys_synDateTime_CellEditor);
        KDTextField kdtEntrys_entryid_TextField = new KDTextField();
        kdtEntrys_entryid_TextField.setName("kdtEntrys_entryid_TextField");
        kdtEntrys_entryid_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_entryid_CellEditor = new KDTDefaultCellEditor(kdtEntrys_entryid_TextField);
        this.kdtEntrys.getColumn("entryid").setEditor(kdtEntrys_entryid_CellEditor);
        KDTextField kdtEntrys_billid_TextField = new KDTextField();
        kdtEntrys_billid_TextField.setName("kdtEntrys_billid_TextField");
        kdtEntrys_billid_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_billid_CellEditor = new KDTDefaultCellEditor(kdtEntrys_billid_TextField);
        this.kdtEntrys.getColumn("billid").setEditor(kdtEntrys_billid_CellEditor);
        KDTextField kdtEntrys_batchName_TextField = new KDTextField();
        kdtEntrys_batchName_TextField.setName("kdtEntrys_batchName_TextField");
        kdtEntrys_batchName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_batchName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_batchName_TextField);
        this.kdtEntrys.getColumn("batchName").setEditor(kdtEntrys_batchName_CellEditor);
        KDTextField kdtEntrys_house_TextField = new KDTextField();
        kdtEntrys_house_TextField.setName("kdtEntrys_house_TextField");
        kdtEntrys_house_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_house_CellEditor = new KDTDefaultCellEditor(kdtEntrys_house_TextField);
        this.kdtEntrys.getColumn("house").setEditor(kdtEntrys_house_CellEditor);
        KDTextField kdtEntrys_Cloudid_TextField = new KDTextField();
        kdtEntrys_Cloudid_TextField.setName("kdtEntrys_Cloudid_TextField");
        kdtEntrys_Cloudid_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_Cloudid_CellEditor = new KDTDefaultCellEditor(kdtEntrys_Cloudid_TextField);
        this.kdtEntrys.getColumn("Cloudid").setEditor(kdtEntrys_Cloudid_CellEditor);
        KDTextField kdtEntrys_CloudNum_TextField = new KDTextField();
        kdtEntrys_CloudNum_TextField.setName("kdtEntrys_CloudNum_TextField");
        kdtEntrys_CloudNum_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_CloudNum_CellEditor = new KDTDefaultCellEditor(kdtEntrys_CloudNum_TextField);
        this.kdtEntrys.getColumn("CloudNum").setEditor(kdtEntrys_CloudNum_CellEditor);
        KDCheckBox kdtEntrys_isSuccess_CheckBox = new KDCheckBox();
        kdtEntrys_isSuccess_CheckBox.setName("kdtEntrys_isSuccess_CheckBox");
        KDTDefaultCellEditor kdtEntrys_isSuccess_CellEditor = new KDTDefaultCellEditor(kdtEntrys_isSuccess_CheckBox);
        this.kdtEntrys.getColumn("isSuccess").setEditor(kdtEntrys_isSuccess_CellEditor);
        KDTextField kdtEntrys_costTime_TextField = new KDTextField();
        kdtEntrys_costTime_TextField.setName("kdtEntrys_costTime_TextField");
        kdtEntrys_costTime_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_costTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_costTime_TextField);
        this.kdtEntrys.getColumn("costTime").setEditor(kdtEntrys_costTime_CellEditor);
        KDTextArea kdtEntrys_synDateInformation_TextArea = new KDTextArea();
        kdtEntrys_synDateInformation_TextArea.setName("kdtEntrys_synDateInformation_TextArea");
        kdtEntrys_synDateInformation_TextArea.setMaxLength(255);
        KDTDefaultCellEditor kdtEntrys_synDateInformation_CellEditor = new KDTDefaultCellEditor(kdtEntrys_synDateInformation_TextArea);
        this.kdtEntrys.getColumn("synDateInformation").setEditor(kdtEntrys_synDateInformation_CellEditor);
        KDTextField kdtEntrys_billNumber_TextField = new KDTextField();
        kdtEntrys_billNumber_TextField.setName("kdtEntrys_billNumber_TextField");
        kdtEntrys_billNumber_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_billNumber_CellEditor = new KDTDefaultCellEditor(kdtEntrys_billNumber_TextField);
        this.kdtEntrys.getColumn("billNumber").setEditor(kdtEntrys_billNumber_CellEditor);
        KDTextField kdtEntrys_stockingBizDateStocking_TextField = new KDTextField();
        kdtEntrys_stockingBizDateStocking_TextField.setName("kdtEntrys_stockingBizDateStocking_TextField");
        kdtEntrys_stockingBizDateStocking_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_stockingBizDateStocking_CellEditor = new KDTDefaultCellEditor(kdtEntrys_stockingBizDateStocking_TextField);
        this.kdtEntrys.getColumn("stockingBizDateStocking").setEditor(kdtEntrys_stockingBizDateStocking_CellEditor);
        final KDBizPromptBox kdtEntrys_storage_PromptBox = new KDBizPromptBox();
        kdtEntrys_storage_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");
        kdtEntrys_storage_PromptBox.setVisible(true);
        kdtEntrys_storage_PromptBox.setEditable(true);
        kdtEntrys_storage_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_storage_PromptBox.setEditFormat("$number$");
        kdtEntrys_storage_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_storage_CellEditor = new KDTDefaultCellEditor(kdtEntrys_storage_PromptBox);
        this.kdtEntrys.getColumn("storage").setEditor(kdtEntrys_storage_CellEditor);
        ObjectValueRender kdtEntrys_storage_OVR = new ObjectValueRender();
        kdtEntrys_storage_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("storage").setRenderer(kdtEntrys_storage_OVR);
        // contstorareBill		
        this.contstorareBill.setBoundLabelText(resHelper.getString("contstorareBill.boundLabelText"));		
        this.contstorareBill.setBoundLabelLength(100);		
        this.contstorareBill.setBoundLabelUnderline(true);		
        this.contstorareBill.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // pkBizDate		
        this.pkBizDate.setEnabled(true);
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // prmtstorareBill		
        this.prmtstorareBill.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtstorareBill.setVisible(true);		
        this.prmtstorareBill.setEditable(true);		
        this.prmtstorareBill.setDisplayFormat("$name$");		
        this.prmtstorareBill.setEditFormat("$number$");		
        this.prmtstorareBill.setCommitFormat("$number$");		
        this.prmtstorareBill.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,txtDescription,kdtEntrys,prmtstorareBill}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 483));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1013, 483));
        contNumber.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(10, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(353, 9, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(353, 9, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(978, 11, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(978, 11, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(10, 34, 991, 413));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.custom.tocloud.SynDateLogEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(10, 34, 991, 413, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contstorareBill.setBounds(new Rectangle(702, 9, 270, 19));
        this.add(contstorareBill, new KDLayout.Constraints(702, 9, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contNumber
        contNumber.setBoundEditor(txtNumber);
        //contBizDate
        contBizDate.setBoundEditor(pkBizDate);
        //contDescription
        contDescription.setBoundEditor(txtDescription);
        //contstorareBill
        contstorareBill.setBoundEditor(prmtstorareBill);

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
        this.toolBar.add(separatorFW9);
        this.toolBar.add(btnVoucher);
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnPCVoucher);
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
		dataBinder.registerBinding("entrys", com.kingdee.eas.custom.tocloud.SynDateLogEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.targetSystemName", String.class, this.kdtEntrys, "targetSystemName.text");
		dataBinder.registerBinding("entrys.bizTypeName", String.class, this.kdtEntrys, "bizTypeName.text");
		dataBinder.registerBinding("entrys.companyName", String.class, this.kdtEntrys, "companyName.text");
		dataBinder.registerBinding("entrys.synDateTime", String.class, this.kdtEntrys, "synDateTime.text");
		dataBinder.registerBinding("entrys.entryid", String.class, this.kdtEntrys, "entryid.text");
		dataBinder.registerBinding("entrys.billid", String.class, this.kdtEntrys, "billid.text");
		dataBinder.registerBinding("entrys.isSuccess", boolean.class, this.kdtEntrys, "isSuccess.text");
		dataBinder.registerBinding("entrys.costTime", String.class, this.kdtEntrys, "costTime.text");
		dataBinder.registerBinding("entrys.bizTypeid", String.class, this.kdtEntrys, "bizTypeid.text");
		dataBinder.registerBinding("entrys.synDateInformation", String.class, this.kdtEntrys, "synDateInformation.text");
		dataBinder.registerBinding("entrys.batchName", String.class, this.kdtEntrys, "batchName.text");
		dataBinder.registerBinding("entrys.house", String.class, this.kdtEntrys, "house.text");
		dataBinder.registerBinding("entrys.Cloudid", String.class, this.kdtEntrys, "Cloudid.text");
		dataBinder.registerBinding("entrys.CloudNum", String.class, this.kdtEntrys, "CloudNum.text");
		dataBinder.registerBinding("entrys.billNumber", String.class, this.kdtEntrys, "billNumber.text");
		dataBinder.registerBinding("entrys.stockingBizDateStocking", String.class, this.kdtEntrys, "stockingBizDateStocking.text");
		dataBinder.registerBinding("entrys.storage", java.lang.Object.class, this.kdtEntrys, "storage.text");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("storareBill", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtstorareBill, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.tocloud.app.SynDateLogEditUIHandler";
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
        this.editData = (com.kingdee.eas.custom.tocloud.SynDateLogInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.targetSystemName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.bizTypeName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.companyName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.synDateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.entryid", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.billid", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isSuccess", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.costTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.bizTypeid", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.synDateInformation", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.batchName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.house", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Cloudid", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.CloudNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.billNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.stockingBizDateStocking", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.storage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("storareBill", ValidateHelper.ON_SAVE);    		
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
    	sic.add(new SelectorItemInfo("entrys.targetSystemName"));
    	sic.add(new SelectorItemInfo("entrys.bizTypeName"));
    	sic.add(new SelectorItemInfo("entrys.companyName"));
    	sic.add(new SelectorItemInfo("entrys.synDateTime"));
    	sic.add(new SelectorItemInfo("entrys.entryid"));
    	sic.add(new SelectorItemInfo("entrys.billid"));
    	sic.add(new SelectorItemInfo("entrys.isSuccess"));
    	sic.add(new SelectorItemInfo("entrys.costTime"));
    	sic.add(new SelectorItemInfo("entrys.bizTypeid"));
    	sic.add(new SelectorItemInfo("entrys.synDateInformation"));
    	sic.add(new SelectorItemInfo("entrys.batchName"));
    	sic.add(new SelectorItemInfo("entrys.house"));
    	sic.add(new SelectorItemInfo("entrys.Cloudid"));
    	sic.add(new SelectorItemInfo("entrys.CloudNum"));
    	sic.add(new SelectorItemInfo("entrys.billNumber"));
    	sic.add(new SelectorItemInfo("entrys.stockingBizDateStocking"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.storage.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.storage.id"));
			sic.add(new SelectorItemInfo("entrys.storage.name"));
        	sic.add(new SelectorItemInfo("entrys.storage.number"));
		}
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("bizDate"));
        sic.add(new SelectorItemInfo("description"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("storareBill.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("storareBill.id"));
        	sic.add(new SelectorItemInfo("storareBill.number"));
        	sic.add(new SelectorItemInfo("storareBill.name"));
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
     * output actionDeleteEntry_actionPerformed method
     */
    public void actionDeleteEntry_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.tocloud.SynDateLogFactory.getRemoteInstance().deleteEntry(editData);
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
	public RequestContext prepareActionDeleteEntry(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionDeleteEntry() {
    	return false;
    }

    /**
     * output ActionDeleteEntry class
     */     
    protected class ActionDeleteEntry extends ItemAction {     
    
        public ActionDeleteEntry()
        {
            this(null);
        }

        public ActionDeleteEntry(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionDeleteEntry.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionDeleteEntry.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionDeleteEntry.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractSynDateLogEditUI.this, "ActionDeleteEntry", "actionDeleteEntry_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.tocloud.client", "SynDateLogEditUI");
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
        return com.kingdee.eas.custom.tocloud.client.SynDateLogEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.tocloud.SynDateLogFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.tocloud.SynDateLogInfo objectValue = new com.kingdee.eas.custom.tocloud.SynDateLogInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/tocloud/SynDateLog";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.tocloud.app.SynDateLogQuery");
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
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}