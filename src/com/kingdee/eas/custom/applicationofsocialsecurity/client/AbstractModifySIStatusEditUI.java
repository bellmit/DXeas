/**
 * output package name
 */
package com.kingdee.eas.custom.applicationofsocialsecurity.client;

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
public abstract class AbstractModifySIStatusEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractModifySIStatusEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisIn;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDButton btnSelectNull;
    protected com.kingdee.bos.ctrl.swing.KDButton btnConfirm;
    protected com.kingdee.bos.ctrl.swing.KDButton btnSelectAll;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contSIStatus;
    protected com.kingdee.bos.ctrl.swing.KDButton btnFselect;
    protected com.kingdee.bos.ctrl.swing.KDButton btnFilter;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contenterDateFrom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contenterDateTo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpersonName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpersonNum;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cBoxSSStatus;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkenterDateFrom;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkenterDateTo;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cBoxCompany;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpersonName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpersonNum;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUndoAll;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnDoSelected;
    protected com.kingdee.eas.custom.applicationofsocialsecurity.ModifySIStatusInfo editData = null;
    protected ActionUndoAll actionUndoAll = null;
    protected ActionUndoSelected actionUndoSelected = null;
    /**
     * output class constructor
     */
    public AbstractModifySIStatusEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractModifySIStatusEditUI.class.getName());
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
        //actionUndoAll
        this.actionUndoAll = new ActionUndoAll(this);
        getActionManager().registerAction("actionUndoAll", actionUndoAll);
        this.actionUndoAll.setExtendProperty("canForewarn", "true");
        this.actionUndoAll.setExtendProperty("userDefined", "false");
        this.actionUndoAll.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUndoAll.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUndoAll.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionUndoSelected
        this.actionUndoSelected = new ActionUndoSelected(this);
        getActionManager().registerAction("actionUndoSelected", actionUndoSelected);
        this.actionUndoSelected.setExtendProperty("canForewarn", "true");
        this.actionUndoSelected.setExtendProperty("userDefined", "false");
        this.actionUndoSelected.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUndoSelected.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUndoSelected.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.chkisIn = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.btnSelectNull = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnConfirm = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnSelectAll = new com.kingdee.bos.ctrl.swing.KDButton();
        this.contSIStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnFselect = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnFilter = new com.kingdee.bos.ctrl.swing.KDButton();
        this.contenterDateFrom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contenterDateTo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpersonName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpersonNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.cBoxSSStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.pkenterDateFrom = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkenterDateTo = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.cBoxCompany = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtpersonName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtpersonNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.btnUndoAll = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnDoSelected = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.chkisIn.setName("chkisIn");
        this.kdtEntrys.setName("kdtEntrys");
        this.btnSelectNull.setName("btnSelectNull");
        this.btnConfirm.setName("btnConfirm");
        this.btnSelectAll.setName("btnSelectAll");
        this.contSIStatus.setName("contSIStatus");
        this.btnFselect.setName("btnFselect");
        this.btnFilter.setName("btnFilter");
        this.contenterDateFrom.setName("contenterDateFrom");
        this.contenterDateTo.setName("contenterDateTo");
        this.contCompany.setName("contCompany");
        this.contpersonName.setName("contpersonName");
        this.contpersonNum.setName("contpersonNum");
        this.cBoxSSStatus.setName("cBoxSSStatus");
        this.pkenterDateFrom.setName("pkenterDateFrom");
        this.pkenterDateTo.setName("pkenterDateTo");
        this.cBoxCompany.setName("cBoxCompany");
        this.txtpersonName.setName("txtpersonName");
        this.txtpersonNum.setName("txtpersonNum");
        this.btnUndoAll.setName("btnUndoAll");
        this.btnUnDoSelected.setName("btnUnDoSelected");
        // CoreUI		
        this.btnTraceUp.setVisible(false);		
        this.btnTraceDown.setVisible(false);		
        this.btnCreateTo.setVisible(true);		
        this.btnAddLine.setVisible(false);		
        this.btnCopyLine.setVisible(false);		
        this.btnInsertLine.setVisible(false);		
        this.btnRemoveLine.setVisible(false);		
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
        // chkisIn		
        this.chkisIn.setText(resHelper.getString("chkisIn.text"));		
        this.chkisIn.setHorizontalAlignment(2);		
        this.chkisIn.setRequired(true);
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"isSelected\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"shrPersonNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"shrPersonName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"empType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"srcSIStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"desSIStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"enterDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"company\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"department\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"position\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"gender\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"contact\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{isSelected}</t:Cell><t:Cell>$Resource{shrPersonNum}</t:Cell><t:Cell>$Resource{shrPersonName}</t:Cell><t:Cell>$Resource{empType}</t:Cell><t:Cell>$Resource{srcSIStatus}</t:Cell><t:Cell>$Resource{desSIStatus}</t:Cell><t:Cell>$Resource{enterDate}</t:Cell><t:Cell>$Resource{company}</t:Cell><t:Cell>$Resource{department}</t:Cell><t:Cell>$Resource{position}</t:Cell><t:Cell>$Resource{gender}</t:Cell><t:Cell>$Resource{contact}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));
        this.kdtEntrys.addKDTEditListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter() {
            public void editStarting(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) {
                try {
                    kdtEntrys_editStartin(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
            public void editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) {
                try {
                    kdtEntrys_editStopp(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });

                this.kdtEntrys.putBindContents("editData",new String[] {"id","isSelected","shrPersonNum","shrPersonName","empType","srcSIStatus","desSIStatus","enterDate","company","department","position","gender","contact"});


        this.kdtEntrys.checkParsed();
        KDCheckBox kdtEntrys_isSelected_CheckBox = new KDCheckBox();
        kdtEntrys_isSelected_CheckBox.setName("kdtEntrys_isSelected_CheckBox");
        KDTDefaultCellEditor kdtEntrys_isSelected_CellEditor = new KDTDefaultCellEditor(kdtEntrys_isSelected_CheckBox);
        this.kdtEntrys.getColumn("isSelected").setEditor(kdtEntrys_isSelected_CellEditor);
        KDTextField kdtEntrys_shrPersonNum_TextField = new KDTextField();
        kdtEntrys_shrPersonNum_TextField.setName("kdtEntrys_shrPersonNum_TextField");
        kdtEntrys_shrPersonNum_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_shrPersonNum_CellEditor = new KDTDefaultCellEditor(kdtEntrys_shrPersonNum_TextField);
        this.kdtEntrys.getColumn("shrPersonNum").setEditor(kdtEntrys_shrPersonNum_CellEditor);
        KDTextField kdtEntrys_shrPersonName_TextField = new KDTextField();
        kdtEntrys_shrPersonName_TextField.setName("kdtEntrys_shrPersonName_TextField");
        kdtEntrys_shrPersonName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_shrPersonName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_shrPersonName_TextField);
        this.kdtEntrys.getColumn("shrPersonName").setEditor(kdtEntrys_shrPersonName_CellEditor);
        KDTextField kdtEntrys_empType_TextField = new KDTextField();
        kdtEntrys_empType_TextField.setName("kdtEntrys_empType_TextField");
        kdtEntrys_empType_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_empType_CellEditor = new KDTDefaultCellEditor(kdtEntrys_empType_TextField);
        this.kdtEntrys.getColumn("empType").setEditor(kdtEntrys_empType_CellEditor);
        KDTextField kdtEntrys_srcSIStatus_TextField = new KDTextField();
        kdtEntrys_srcSIStatus_TextField.setName("kdtEntrys_srcSIStatus_TextField");
        kdtEntrys_srcSIStatus_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_srcSIStatus_CellEditor = new KDTDefaultCellEditor(kdtEntrys_srcSIStatus_TextField);
        this.kdtEntrys.getColumn("srcSIStatus").setEditor(kdtEntrys_srcSIStatus_CellEditor);
        KDTextField kdtEntrys_desSIStatus_TextField = new KDTextField();
        kdtEntrys_desSIStatus_TextField.setName("kdtEntrys_desSIStatus_TextField");
        kdtEntrys_desSIStatus_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_desSIStatus_CellEditor = new KDTDefaultCellEditor(kdtEntrys_desSIStatus_TextField);
        this.kdtEntrys.getColumn("desSIStatus").setEditor(kdtEntrys_desSIStatus_CellEditor);
        KDDatePicker kdtEntrys_enterDate_DatePicker = new KDDatePicker();
        kdtEntrys_enterDate_DatePicker.setName("kdtEntrys_enterDate_DatePicker");
        kdtEntrys_enterDate_DatePicker.setVisible(true);
        kdtEntrys_enterDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_enterDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_enterDate_DatePicker);
        this.kdtEntrys.getColumn("enterDate").setEditor(kdtEntrys_enterDate_CellEditor);
        KDTextField kdtEntrys_company_TextField = new KDTextField();
        kdtEntrys_company_TextField.setName("kdtEntrys_company_TextField");
        kdtEntrys_company_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_company_CellEditor = new KDTDefaultCellEditor(kdtEntrys_company_TextField);
        this.kdtEntrys.getColumn("company").setEditor(kdtEntrys_company_CellEditor);
        KDTextField kdtEntrys_department_TextField = new KDTextField();
        kdtEntrys_department_TextField.setName("kdtEntrys_department_TextField");
        kdtEntrys_department_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_department_CellEditor = new KDTDefaultCellEditor(kdtEntrys_department_TextField);
        this.kdtEntrys.getColumn("department").setEditor(kdtEntrys_department_CellEditor);
        KDTextField kdtEntrys_position_TextField = new KDTextField();
        kdtEntrys_position_TextField.setName("kdtEntrys_position_TextField");
        kdtEntrys_position_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_position_CellEditor = new KDTDefaultCellEditor(kdtEntrys_position_TextField);
        this.kdtEntrys.getColumn("position").setEditor(kdtEntrys_position_CellEditor);
        KDComboBox kdtEntrys_gender_ComboBox = new KDComboBox();
        kdtEntrys_gender_ComboBox.setName("kdtEntrys_gender_ComboBox");
        kdtEntrys_gender_ComboBox.setVisible(true);
        kdtEntrys_gender_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.basedata.person.Genders").toArray());
        KDTDefaultCellEditor kdtEntrys_gender_CellEditor = new KDTDefaultCellEditor(kdtEntrys_gender_ComboBox);
        this.kdtEntrys.getColumn("gender").setEditor(kdtEntrys_gender_CellEditor);
        KDTextField kdtEntrys_contact_TextField = new KDTextField();
        kdtEntrys_contact_TextField.setName("kdtEntrys_contact_TextField");
        kdtEntrys_contact_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_contact_CellEditor = new KDTDefaultCellEditor(kdtEntrys_contact_TextField);
        this.kdtEntrys.getColumn("contact").setEditor(kdtEntrys_contact_CellEditor);
        // btnSelectNull		
        this.btnSelectNull.setText(resHelper.getString("btnSelectNull.text"));
        this.btnSelectNull.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                try {
                    btnSelectNull_mouseClick(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });
        // btnConfirm		
        this.btnConfirm.setText(resHelper.getString("btnConfirm.text"));
        this.btnConfirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                try {
                    btnConfirm_mouseClick(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });
        // btnSelectAll		
        this.btnSelectAll.setText(resHelper.getString("btnSelectAll.text"));
        this.btnSelectAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                try {
                    btnSelectAll_mouseClick(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });
        // contSIStatus		
        this.contSIStatus.setBoundLabelText(resHelper.getString("contSIStatus.boundLabelText"));		
        this.contSIStatus.setBoundLabelLength(100);		
        this.contSIStatus.setBoundLabelUnderline(true);
        // btnFselect		
        this.btnFselect.setText(resHelper.getString("btnFselect.text"));
        this.btnFselect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                try {
                    btnFselect_mouseClick(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });
        // btnFilter		
        this.btnFilter.setText(resHelper.getString("btnFilter.text"));
        this.btnFilter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                try {
                    btnFilter_mouseClick(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });
        // contenterDateFrom		
        this.contenterDateFrom.setBoundLabelText(resHelper.getString("contenterDateFrom.boundLabelText"));		
        this.contenterDateFrom.setBoundLabelLength(100);		
        this.contenterDateFrom.setBoundLabelUnderline(true);		
        this.contenterDateFrom.setVisible(true);
        // contenterDateTo		
        this.contenterDateTo.setBoundLabelText(resHelper.getString("contenterDateTo.boundLabelText"));		
        this.contenterDateTo.setBoundLabelLength(100);		
        this.contenterDateTo.setBoundLabelUnderline(true);		
        this.contenterDateTo.setVisible(true);
        // contCompany		
        this.contCompany.setBoundLabelText(resHelper.getString("contCompany.boundLabelText"));		
        this.contCompany.setBoundLabelLength(100);		
        this.contCompany.setBoundLabelUnderline(true);
        // contpersonName		
        this.contpersonName.setBoundLabelText(resHelper.getString("contpersonName.boundLabelText"));		
        this.contpersonName.setBoundLabelLength(100);		
        this.contpersonName.setBoundLabelUnderline(true);		
        this.contpersonName.setVisible(true);
        // contpersonNum		
        this.contpersonNum.setBoundLabelText(resHelper.getString("contpersonNum.boundLabelText"));		
        this.contpersonNum.setBoundLabelLength(100);		
        this.contpersonNum.setBoundLabelUnderline(true);		
        this.contpersonNum.setVisible(true);
        // cBoxSSStatus
        // pkenterDateFrom		
        this.pkenterDateFrom.setRequired(false);
        // pkenterDateTo		
        this.pkenterDateTo.setRequired(false);
        // cBoxCompany
        // txtpersonName		
        this.txtpersonName.setHorizontalAlignment(2);		
        this.txtpersonName.setMaxLength(100);		
        this.txtpersonName.setRequired(false);
        // txtpersonNum		
        this.txtpersonNum.setHorizontalAlignment(2);		
        this.txtpersonNum.setMaxLength(100);		
        this.txtpersonNum.setRequired(false);
        // btnUndoAll
        this.btnUndoAll.setAction((IItemAction)ActionProxyFactory.getProxy(actionUndoAll, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUndoAll.setText(resHelper.getString("btnUndoAll.text"));
        // btnUnDoSelected
        this.btnUnDoSelected.setAction((IItemAction)ActionProxyFactory.getProxy(actionUndoSelected, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnDoSelected.setText(resHelper.getString("btnUnDoSelected.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {pkenterDateFrom,pkenterDateTo,chkisIn,txtpersonName,txtpersonNum,kdtEntrys}));
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
        this.setBounds(new Rectangle(0, 0, 746, 602));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 746, 602));
        chkisIn.setBounds(new Rectangle(521, 83, 51, 19));
        this.add(chkisIn, new KDLayout.Constraints(521, 83, 51, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kdtEntrys.setBounds(new Rectangle(10, 153, 722, 411));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.custom.applicationofsocialsecurity.ModifySIStatusEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(10, 153, 722, 411, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("gender",new Integer(1));
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        btnSelectNull.setBounds(new Rectangle(89, 116, 62, 21));
        this.add(btnSelectNull, new KDLayout.Constraints(89, 116, 62, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnConfirm.setBounds(new Rectangle(670, 116, 62, 21));
        this.add(btnConfirm, new KDLayout.Constraints(670, 116, 62, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        btnSelectAll.setBounds(new Rectangle(14, 116, 62, 21));
        this.add(btnSelectAll, new KDLayout.Constraints(14, 116, 62, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contSIStatus.setBounds(new Rectangle(521, 53, 218, 19));
        this.add(contSIStatus, new KDLayout.Constraints(521, 53, 218, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        btnFselect.setBounds(new Rectangle(178, 117, 62, 21));
        this.add(btnFselect, new KDLayout.Constraints(178, 117, 62, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnFilter.setBounds(new Rectangle(583, 116, 62, 21));
        this.add(btnFilter, new KDLayout.Constraints(583, 116, 62, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contenterDateFrom.setBounds(new Rectangle(10, 19, 218, 19));
        this.add(contenterDateFrom, new KDLayout.Constraints(10, 19, 218, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contenterDateTo.setBounds(new Rectangle(273, 19, 218, 19));
        this.add(contenterDateTo, new KDLayout.Constraints(273, 19, 218, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCompany.setBounds(new Rectangle(521, 19, 218, 19));
        this.add(contCompany, new KDLayout.Constraints(521, 19, 218, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contpersonName.setBounds(new Rectangle(273, 53, 218, 19));
        this.add(contpersonName, new KDLayout.Constraints(273, 53, 218, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpersonNum.setBounds(new Rectangle(10, 53, 218, 19));
        this.add(contpersonNum, new KDLayout.Constraints(10, 53, 218, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contSIStatus
        contSIStatus.setBoundEditor(cBoxSSStatus);
        //contenterDateFrom
        contenterDateFrom.setBoundEditor(pkenterDateFrom);
        //contenterDateTo
        contenterDateTo.setBoundEditor(pkenterDateTo);
        //contCompany
        contCompany.setBoundEditor(cBoxCompany);
        //contpersonName
        contpersonName.setBoundEditor(txtpersonName);
        //contpersonNum
        contpersonNum.setBoundEditor(txtpersonNum);

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
        this.toolBar.add(btnUndoAll);
        this.toolBar.add(btnUnDoSelected);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("isIn", boolean.class, this.chkisIn, "selected");
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.custom.applicationofsocialsecurity.ModifySIStatusEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.isSelected", boolean.class, this.kdtEntrys, "isSelected.text");
		dataBinder.registerBinding("entrys.shrPersonNum", String.class, this.kdtEntrys, "shrPersonNum.text");
		dataBinder.registerBinding("entrys.shrPersonName", String.class, this.kdtEntrys, "shrPersonName.text");
		dataBinder.registerBinding("entrys.enterDate", java.util.Date.class, this.kdtEntrys, "enterDate.text");
		dataBinder.registerBinding("entrys.department", String.class, this.kdtEntrys, "department.text");
		dataBinder.registerBinding("entrys.gender", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "gender.text");
		dataBinder.registerBinding("entrys.contact", String.class, this.kdtEntrys, "contact.text");
		dataBinder.registerBinding("entrys.position", String.class, this.kdtEntrys, "position.text");
		dataBinder.registerBinding("entrys.srcSIStatus", String.class, this.kdtEntrys, "srcSIStatus.text");
		dataBinder.registerBinding("entrys.desSIStatus", String.class, this.kdtEntrys, "desSIStatus.text");
		dataBinder.registerBinding("entrys.empType", String.class, this.kdtEntrys, "empType.text");
		dataBinder.registerBinding("entrys.company", String.class, this.kdtEntrys, "company.text");
		dataBinder.registerBinding("enterDateFrom", java.util.Date.class, this.pkenterDateFrom, "value");
		dataBinder.registerBinding("enterDateTo", java.util.Date.class, this.pkenterDateTo, "value");
		dataBinder.registerBinding("personName", String.class, this.txtpersonName, "text");
		dataBinder.registerBinding("personNum", String.class, this.txtpersonNum, "text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.applicationofsocialsecurity.app.ModifySIStatusEditUIHandler";
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
        this.pkenterDateFrom.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.applicationofsocialsecurity.ModifySIStatusInfo)ov;
    }

    /**
     * output loadFields method
     */
    public void loadFields()
    {
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
		getValidateHelper().registerBindProperty("isIn", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isSelected", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.shrPersonNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.shrPersonName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.enterDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.department", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.gender", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.contact", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.position", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.srcSIStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.desSIStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.empType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("enterDateFrom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("enterDateTo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("personName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("personNum", ValidateHelper.ON_SAVE);    		
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
     * output kdtEntrys_editStartin method
     */
    protected void kdtEntrys_editStartin(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
    }

    /**
     * output kdtEntrys_editStopp method
     */
    protected void kdtEntrys_editStopp(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
    }

    /**
     * output btnSelectNull_mouseClick method
     */
    protected void btnSelectNull_mouseClick(java.awt.event.MouseEvent e) throws Exception
    {
    }

    /**
     * output btnConfirm_mouseClick method
     */
    protected void btnConfirm_mouseClick(java.awt.event.MouseEvent e) throws Exception
    {
    }

    /**
     * output btnSelectAll_mouseClick method
     */
    protected void btnSelectAll_mouseClick(java.awt.event.MouseEvent e) throws Exception
    {
    }

    /**
     * output btnFselect_mouseClick method
     */
    protected void btnFselect_mouseClick(java.awt.event.MouseEvent e) throws Exception
    {
    }

    /**
     * output btnFilter_mouseClick method
     */
    protected void btnFilter_mouseClick(java.awt.event.MouseEvent e) throws Exception
    {
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
        sic.add(new SelectorItemInfo("isIn"));
    	sic.add(new SelectorItemInfo("entrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("entrys.isSelected"));
    	sic.add(new SelectorItemInfo("entrys.shrPersonNum"));
    	sic.add(new SelectorItemInfo("entrys.shrPersonName"));
    	sic.add(new SelectorItemInfo("entrys.enterDate"));
    	sic.add(new SelectorItemInfo("entrys.department"));
    	sic.add(new SelectorItemInfo("entrys.gender"));
    	sic.add(new SelectorItemInfo("entrys.contact"));
    	sic.add(new SelectorItemInfo("entrys.position"));
    	sic.add(new SelectorItemInfo("entrys.srcSIStatus"));
    	sic.add(new SelectorItemInfo("entrys.desSIStatus"));
    	sic.add(new SelectorItemInfo("entrys.empType"));
    	sic.add(new SelectorItemInfo("entrys.company"));
        sic.add(new SelectorItemInfo("enterDateFrom"));
        sic.add(new SelectorItemInfo("enterDateTo"));
        sic.add(new SelectorItemInfo("personName"));
        sic.add(new SelectorItemInfo("personNum"));
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
     * output actionUndoAll_actionPerformed method
     */
    public void actionUndoAll_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.applicationofsocialsecurity.ModifySIStatusFactory.getRemoteInstance().undoAll(editData);
    }
    	

    /**
     * output actionUndoSelected_actionPerformed method
     */
    public void actionUndoSelected_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.applicationofsocialsecurity.ModifySIStatusFactory.getRemoteInstance().undoSelected(editData);
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
	public RequestContext prepareActionUndoAll(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionUndoAll() {
    	return false;
    }
	public RequestContext prepareActionUndoSelected(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionUndoSelected() {
    	return false;
    }

    /**
     * output ActionUndoAll class
     */     
    protected class ActionUndoAll extends ItemAction {     
    
        public ActionUndoAll()
        {
            this(null);
        }

        public ActionUndoAll(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionUndoAll.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUndoAll.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUndoAll.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractModifySIStatusEditUI.this, "ActionUndoAll", "actionUndoAll_actionPerformed", e);
        }
    }

    /**
     * output ActionUndoSelected class
     */     
    protected class ActionUndoSelected extends ItemAction {     
    
        public ActionUndoSelected()
        {
            this(null);
        }

        public ActionUndoSelected(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionUndoSelected.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUndoSelected.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUndoSelected.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractModifySIStatusEditUI.this, "ActionUndoSelected", "actionUndoSelected_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.applicationofsocialsecurity.client", "ModifySIStatusEditUI");
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
        return com.kingdee.eas.custom.applicationofsocialsecurity.client.ModifySIStatusEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.applicationofsocialsecurity.ModifySIStatusFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.applicationofsocialsecurity.ModifySIStatusInfo objectValue = new com.kingdee.eas.custom.applicationofsocialsecurity.ModifySIStatusInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/applicationofsocialsecurity/ModifySIStatus";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.applicationofsocialsecurity.app.ModifySIStatusQuery");
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