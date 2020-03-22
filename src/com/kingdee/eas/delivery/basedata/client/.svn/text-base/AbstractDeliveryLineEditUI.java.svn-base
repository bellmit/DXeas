/**
 * output package name
 */
package com.kingdee.eas.delivery.basedata.client;

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
public abstract class AbstractDeliveryLineEditUI extends com.kingdee.eas.basedata.framework.client.DataBaseSIEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractDeliveryLineEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntry;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbeginStation;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contendStation;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdefaultTranType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalMileage;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdefaultCarrier;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contavgHour;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contavgMinute;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisInner;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfromStorageOrg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttoStorageOrg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdefaultCarCount;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbeginStation;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtendStation;
    protected com.kingdee.bos.ctrl.swing.KDComboBox defaultTranType;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalMileage;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtdefaultCarrier;
    protected com.kingdee.bos.ctrl.swing.KDComboBox status;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtavgHour;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtavgMinute;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfromStorageOrg;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmttoStorageOrg;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdefaultCarCount;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAddLine;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnInsertLine;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnRemoveLine;
    protected com.kingdee.bos.ctrl.swing.KDMenu menuTable;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemAddLine;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemInsertLine;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemRemoveLine;
    protected com.kingdee.eas.delivery.basedata.DeliveryLineInfo editData = null;
    protected ActionAddLine actionAddLine = null;
    protected ActionInsertLine actionInsertLine = null;
    protected ActionRemoveLine actionRemoveLine = null;
    /**
     * output class constructor
     */
    public AbstractDeliveryLineEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractDeliveryLineEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        //actionCancel
        String _tempStr = null;
        actionCancel.setEnabled(true);
        actionCancel.setDaemonRun(false);

        actionCancel.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl -"));
        _tempStr = resHelper.getString("ActionCancel.SHORT_DESCRIPTION");
        actionCancel.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionCancel.LONG_DESCRIPTION");
        actionCancel.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionCancel.NAME");
        actionCancel.putValue(ItemAction.NAME, _tempStr);
        this.actionCancel.setExtendProperty("isObjectUpdateLock", "false");
         this.actionCancel.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionCancel.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
         this.actionCancel.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
        //actionCancelCancel
        actionCancelCancel.setEnabled(true);
        actionCancelCancel.setDaemonRun(false);

        actionCancelCancel.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl +"));
        _tempStr = resHelper.getString("ActionCancelCancel.SHORT_DESCRIPTION");
        actionCancelCancel.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionCancelCancel.LONG_DESCRIPTION");
        actionCancelCancel.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionCancelCancel.NAME");
        actionCancelCancel.putValue(ItemAction.NAME, _tempStr);
        this.actionCancelCancel.setExtendProperty("isObjectUpdateLock", "false");
         this.actionCancelCancel.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionCancelCancel.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
         this.actionCancelCancel.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
        //actionEdit
        actionEdit.setEnabled(true);
        actionEdit.setDaemonRun(false);

        actionEdit.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl E"));
        _tempStr = resHelper.getString("ActionEdit.SHORT_DESCRIPTION");
        actionEdit.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionEdit.LONG_DESCRIPTION");
        actionEdit.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionEdit.NAME");
        actionEdit.putValue(ItemAction.NAME, _tempStr);
        this.actionEdit.setExtendProperty("isObjectUpdateLock", "true");
         this.actionEdit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionEdit.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
        //actionRemove
        actionRemove.setEnabled(false);
        actionRemove.setDaemonRun(false);

        actionRemove.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl D"));
        _tempStr = resHelper.getString("ActionRemove.SHORT_DESCRIPTION");
        actionRemove.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionRemove.LONG_DESCRIPTION");
        actionRemove.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionRemove.NAME");
        actionRemove.putValue(ItemAction.NAME, _tempStr);
        this.actionRemove.setExtendProperty("isObjectUpdateLock", "true");
         this.actionRemove.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionRemove.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
        //actionAddLine
        this.actionAddLine = new ActionAddLine(this);
        getActionManager().registerAction("actionAddLine", actionAddLine);
         this.actionAddLine.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionInsertLine
        this.actionInsertLine = new ActionInsertLine(this);
        getActionManager().registerAction("actionInsertLine", actionInsertLine);
         this.actionInsertLine.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionRemoveLine
        this.actionRemoveLine = new ActionRemoveLine(this);
        getActionManager().registerAction("actionRemoveLine", actionRemoveLine);
         this.actionRemoveLine.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contbeginStation = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contendStation = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdefaultTranType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalMileage = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdefaultCarrier = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contavgHour = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contavgMinute = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisInner = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contfromStorageOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttoStorageOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdefaultCarCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.prmtbeginStation = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtendStation = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.defaultTranType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txttotalMileage = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtdefaultCarrier = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.status = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtavgHour = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtavgMinute = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtfromStorageOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmttoStorageOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtdefaultCarCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.btnAddLine = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnInsertLine = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnRemoveLine = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.menuTable = new com.kingdee.bos.ctrl.swing.KDMenu();
        this.menuItemAddLine = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemInsertLine = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemRemoveLine = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.kdtEntry.setName("kdtEntry");
        this.contbeginStation.setName("contbeginStation");
        this.contendStation.setName("contendStation");
        this.contdefaultTranType.setName("contdefaultTranType");
        this.conttotalMileage.setName("conttotalMileage");
        this.contdefaultCarrier.setName("contdefaultCarrier");
        this.contstatus.setName("contstatus");
        this.contavgHour.setName("contavgHour");
        this.contavgMinute.setName("contavgMinute");
        this.chkisInner.setName("chkisInner");
        this.contfromStorageOrg.setName("contfromStorageOrg");
        this.conttoStorageOrg.setName("conttoStorageOrg");
        this.contdefaultCarCount.setName("contdefaultCarCount");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.prmtbeginStation.setName("prmtbeginStation");
        this.prmtendStation.setName("prmtendStation");
        this.defaultTranType.setName("defaultTranType");
        this.txttotalMileage.setName("txttotalMileage");
        this.prmtdefaultCarrier.setName("prmtdefaultCarrier");
        this.status.setName("status");
        this.txtavgHour.setName("txtavgHour");
        this.txtavgMinute.setName("txtavgMinute");
        this.prmtfromStorageOrg.setName("prmtfromStorageOrg");
        this.prmttoStorageOrg.setName("prmttoStorageOrg");
        this.txtdefaultCarCount.setName("txtdefaultCarCount");
        this.btnAddLine.setName("btnAddLine");
        this.btnInsertLine.setName("btnInsertLine");
        this.btnRemoveLine.setName("btnRemoveLine");
        this.menuTable.setName("menuTable");
        this.menuItemAddLine.setName("menuItemAddLine");
        this.menuItemInsertLine.setName("menuItemInsertLine");
        this.menuItemRemoveLine.setName("menuItemRemoveLine");
        // CoreUI		
        this.setMaximumSize(new Dimension(590,385));		
        this.btnSave.setVisible(false);		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(182);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);		
        this.kDLabelContainer1.setBoundLabelAlignment(7);		
        this.kDLabelContainer1.setVisible(true);		
        this.kDLabelContainer1.setForeground(new java.awt.Color(0,0,0));		
        this.kDLabelContainer1.setFocusCycleRoot(true);
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelLength(137);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);		
        this.kDLabelContainer2.setBoundLabelAlignment(7);		
        this.kDLabelContainer2.setVisible(true);		
        this.kDLabelContainer2.setForeground(new java.awt.Color(0,0,0));
        // kDLabelContainer3		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelLength(100);		
        this.kDLabelContainer3.setBoundLabelUnderline(true);		
        this.kDLabelContainer3.setBoundLabelAlignment(7);		
        this.kDLabelContainer3.setVisible(false);		
        this.kDLabelContainer3.setForeground(new java.awt.Color(0,0,0));
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelAlignment(7);		
        this.kDLabelContainer4.setVisible(false);		
        this.kDLabelContainer4.setForeground(new java.awt.Color(0,0,0));
        // kdtEntry
		String kdtEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /><c:Alignment horizontal=\"right\" /></c:Style><c:Style id=\"sCol6\"><c:Alignment horizontal=\"right\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"detailLine\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"detailBegin\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"detailEnd\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"detailTranType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"detailCarrier\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"detailMileage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol6\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{detailLine}</t:Cell><t:Cell>$Resource{detailBegin}</t:Cell><t:Cell>$Resource{detailEnd}</t:Cell><t:Cell>$Resource{detailTranType}</t:Cell><t:Cell>$Resource{detailCarrier}</t:Cell><t:Cell>$Resource{detailMileage}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntry.setFormatXml(resHelper.translateString("kdtEntry",kdtEntryStrXML));

                this.kdtEntry.putBindContents("editData",new String[] {"id","detailLine","detailLine.beginStation.name","detailLine.endStation.name","detailTranType","detailCarrier","detailMileage"});


        this.kdtEntry.checkParsed();
        final KDBizPromptBox kdtEntry_detailLine_PromptBox = new KDBizPromptBox();
        kdtEntry_detailLine_PromptBox.setQueryInfo("com.kingdee.eas.delivery.basedata.app.DeliveryLineQuery");
        kdtEntry_detailLine_PromptBox.setVisible(true);
        kdtEntry_detailLine_PromptBox.setEditable(true);
        kdtEntry_detailLine_PromptBox.setDisplayFormat("$number$");
        kdtEntry_detailLine_PromptBox.setEditFormat("$number$");
        kdtEntry_detailLine_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_detailLine_CellEditor = new KDTDefaultCellEditor(kdtEntry_detailLine_PromptBox);
        this.kdtEntry.getColumn("detailLine").setEditor(kdtEntry_detailLine_CellEditor);
        ObjectValueRender kdtEntry_detailLine_OVR = new ObjectValueRender();
        kdtEntry_detailLine_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("detailLine").setRenderer(kdtEntry_detailLine_OVR);
        KDTextField kdtEntry_detailBegin_TextField = new KDTextField();
        kdtEntry_detailBegin_TextField.setName("kdtEntry_detailBegin_TextField");
        kdtEntry_detailBegin_TextField.setMaxLength(255);
        KDTDefaultCellEditor kdtEntry_detailBegin_CellEditor = new KDTDefaultCellEditor(kdtEntry_detailBegin_TextField);
        this.kdtEntry.getColumn("detailBegin").setEditor(kdtEntry_detailBegin_CellEditor);
        KDTextField kdtEntry_detailEnd_TextField = new KDTextField();
        kdtEntry_detailEnd_TextField.setName("kdtEntry_detailEnd_TextField");
        kdtEntry_detailEnd_TextField.setMaxLength(255);
        KDTDefaultCellEditor kdtEntry_detailEnd_CellEditor = new KDTDefaultCellEditor(kdtEntry_detailEnd_TextField);
        this.kdtEntry.getColumn("detailEnd").setEditor(kdtEntry_detailEnd_CellEditor);
        KDComboBox kdtEntry_detailTranType_ComboBox = new KDComboBox();
        kdtEntry_detailTranType_ComboBox.setName("kdtEntry_detailTranType_ComboBox");
        kdtEntry_detailTranType_ComboBox.setVisible(true);
        kdtEntry_detailTranType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.im.dt.TransportTypeEnum").toArray());
        KDTDefaultCellEditor kdtEntry_detailTranType_CellEditor = new KDTDefaultCellEditor(kdtEntry_detailTranType_ComboBox);
        this.kdtEntry.getColumn("detailTranType").setEditor(kdtEntry_detailTranType_CellEditor);
        final KDBizPromptBox kdtEntry_detailCarrier_PromptBox = new KDBizPromptBox();
        kdtEntry_detailCarrier_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.F7SupplierDefaultQuery");
        kdtEntry_detailCarrier_PromptBox.setVisible(true);
        kdtEntry_detailCarrier_PromptBox.setEditable(true);
        kdtEntry_detailCarrier_PromptBox.setDisplayFormat("$number$");
        kdtEntry_detailCarrier_PromptBox.setEditFormat("$number$");
        kdtEntry_detailCarrier_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_detailCarrier_CellEditor = new KDTDefaultCellEditor(kdtEntry_detailCarrier_PromptBox);
        this.kdtEntry.getColumn("detailCarrier").setEditor(kdtEntry_detailCarrier_CellEditor);
        ObjectValueRender kdtEntry_detailCarrier_OVR = new ObjectValueRender();
        kdtEntry_detailCarrier_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("detailCarrier").setRenderer(kdtEntry_detailCarrier_OVR);
        KDFormattedTextField kdtEntry_detailMileage_TextField = new KDFormattedTextField();
        kdtEntry_detailMileage_TextField.setName("kdtEntry_detailMileage_TextField");
        kdtEntry_detailMileage_TextField.setVisible(true);
        kdtEntry_detailMileage_TextField.setEditable(true);
        kdtEntry_detailMileage_TextField.setHorizontalAlignment(2);
        kdtEntry_detailMileage_TextField.setDataType(1);
        	kdtEntry_detailMileage_TextField.setMinimumValue(new java.math.BigDecimal("-999.9999999999"));
        	kdtEntry_detailMileage_TextField.setMaximumValue(new java.math.BigDecimal("999.9999999999"));
        kdtEntry_detailMileage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_detailMileage_CellEditor = new KDTDefaultCellEditor(kdtEntry_detailMileage_TextField);
        this.kdtEntry.getColumn("detailMileage").setEditor(kdtEntry_detailMileage_CellEditor);
        // contbeginStation		
        this.contbeginStation.setBoundLabelText(resHelper.getString("contbeginStation.boundLabelText"));		
        this.contbeginStation.setBoundLabelLength(182);		
        this.contbeginStation.setBoundLabelUnderline(true);		
        this.contbeginStation.setVisible(true);		
        this.contbeginStation.setBoundLabelAlignment(7);		
        this.contbeginStation.setForeground(new java.awt.Color(0,0,0));
        // contendStation		
        this.contendStation.setBoundLabelText(resHelper.getString("contendStation.boundLabelText"));		
        this.contendStation.setBoundLabelLength(137);		
        this.contendStation.setBoundLabelUnderline(true);		
        this.contendStation.setVisible(true);		
        this.contendStation.setBoundLabelAlignment(7);		
        this.contendStation.setForeground(new java.awt.Color(0,0,0));
        // contdefaultTranType		
        this.contdefaultTranType.setBoundLabelText(resHelper.getString("contdefaultTranType.boundLabelText"));		
        this.contdefaultTranType.setBoundLabelLength(182);		
        this.contdefaultTranType.setBoundLabelUnderline(true);		
        this.contdefaultTranType.setVisible(true);		
        this.contdefaultTranType.setBoundLabelAlignment(7);		
        this.contdefaultTranType.setForeground(new java.awt.Color(0,0,0));
        // conttotalMileage		
        this.conttotalMileage.setBoundLabelText(resHelper.getString("conttotalMileage.boundLabelText"));		
        this.conttotalMileage.setBoundLabelLength(182);		
        this.conttotalMileage.setBoundLabelUnderline(true);		
        this.conttotalMileage.setVisible(true);		
        this.conttotalMileage.setBoundLabelAlignment(7);		
        this.conttotalMileage.setForeground(new java.awt.Color(0,0,0));
        // contdefaultCarrier		
        this.contdefaultCarrier.setBoundLabelText(resHelper.getString("contdefaultCarrier.boundLabelText"));		
        this.contdefaultCarrier.setBoundLabelLength(137);		
        this.contdefaultCarrier.setBoundLabelUnderline(true);		
        this.contdefaultCarrier.setVisible(true);		
        this.contdefaultCarrier.setBoundLabelAlignment(7);		
        this.contdefaultCarrier.setForeground(new java.awt.Color(0,0,0));
        // contstatus		
        this.contstatus.setBoundLabelText(resHelper.getString("contstatus.boundLabelText"));		
        this.contstatus.setBoundLabelLength(137);		
        this.contstatus.setBoundLabelUnderline(true);		
        this.contstatus.setVisible(true);		
        this.contstatus.setBoundLabelAlignment(7);		
        this.contstatus.setForeground(new java.awt.Color(0,0,0));
        // contavgHour		
        this.contavgHour.setBoundLabelText(resHelper.getString("contavgHour.boundLabelText"));		
        this.contavgHour.setBoundLabelLength(100);		
        this.contavgHour.setBoundLabelUnderline(true);		
        this.contavgHour.setVisible(true);
        // contavgMinute		
        this.contavgMinute.setBoundLabelText(resHelper.getString("contavgMinute.boundLabelText"));		
        this.contavgMinute.setBoundLabelLength(50);		
        this.contavgMinute.setBoundLabelUnderline(true);		
        this.contavgMinute.setVisible(true);
        // chkisInner		
        this.chkisInner.setText(resHelper.getString("chkisInner.text"));		
        this.chkisInner.setVisible(true);		
        this.chkisInner.setHorizontalAlignment(2);
        // contfromStorageOrg		
        this.contfromStorageOrg.setBoundLabelText(resHelper.getString("contfromStorageOrg.boundLabelText"));		
        this.contfromStorageOrg.setBoundLabelLength(182);		
        this.contfromStorageOrg.setBoundLabelUnderline(true);		
        this.contfromStorageOrg.setVisible(true);
        // conttoStorageOrg		
        this.conttoStorageOrg.setBoundLabelText(resHelper.getString("conttoStorageOrg.boundLabelText"));		
        this.conttoStorageOrg.setBoundLabelLength(137);		
        this.conttoStorageOrg.setBoundLabelUnderline(true);		
        this.conttoStorageOrg.setVisible(true);
        // contdefaultCarCount		
        this.contdefaultCarCount.setBoundLabelText(resHelper.getString("contdefaultCarCount.boundLabelText"));		
        this.contdefaultCarCount.setBoundLabelLength(80);		
        this.contdefaultCarCount.setBoundLabelUnderline(true);		
        this.contdefaultCarCount.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setVisible(true);		
        this.txtNumber.setEnabled(true);		
        this.txtNumber.setHorizontalAlignment(2);		
        this.txtNumber.setForeground(new java.awt.Color(0,0,0));		
        this.txtNumber.setRequired(true);		
        this.txtNumber.setFocusCycleRoot(true);
        // txtName		
        this.txtName.setVisible(true);		
        this.txtName.setEnabled(true);		
        this.txtName.setForeground(new java.awt.Color(0,0,0));		
        this.txtName.setRequired(true);
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);		
        this.txtSimpleName.setVisible(false);		
        this.txtSimpleName.setEnabled(true);		
        this.txtSimpleName.setHorizontalAlignment(2);		
        this.txtSimpleName.setForeground(new java.awt.Color(0,0,0));		
        this.txtSimpleName.setRequired(false);
        // txtDescription		
        this.txtDescription.setVisible(false);		
        this.txtDescription.setEnabled(true);		
        this.txtDescription.setForeground(new java.awt.Color(0,0,0));		
        this.txtDescription.setRequired(false);
        // prmtbeginStation		
        this.prmtbeginStation.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7AddressQuery");		
        this.prmtbeginStation.setEditable(true);		
        this.prmtbeginStation.setDisplayFormat("$name$");		
        this.prmtbeginStation.setEditFormat("$number$");		
        this.prmtbeginStation.setCommitFormat("$number$");		
        this.prmtbeginStation.setRequired(false);		
        this.prmtbeginStation.setEnabled(true);		
        this.prmtbeginStation.setForeground(new java.awt.Color(0,0,0));
        // prmtendStation		
        this.prmtendStation.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7AddressQuery");		
        this.prmtendStation.setEditable(true);		
        this.prmtendStation.setDisplayFormat("$name$");		
        this.prmtendStation.setEditFormat("$number$");		
        this.prmtendStation.setCommitFormat("$number$");		
        this.prmtendStation.setRequired(false);		
        this.prmtendStation.setEnabled(true);		
        this.prmtendStation.setForeground(new java.awt.Color(0,0,0));
        // defaultTranType		
        this.defaultTranType.setVisible(true);		
        this.defaultTranType.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.im.dt.TransportTypeEnum").toArray());		
        this.defaultTranType.setRequired(true);		
        this.defaultTranType.setEnabled(true);		
        this.defaultTranType.setForeground(new java.awt.Color(0,0,0));
        // txttotalMileage		
        this.txttotalMileage.setVisible(true);		
        this.txttotalMileage.setHorizontalAlignment(2);		
        this.txttotalMileage.setDataType(1);		
        this.txttotalMileage.setSupportedEmpty(true);		
        this.txttotalMileage.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txttotalMileage.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txttotalMileage.setPrecision(2);		
        this.txttotalMileage.setRequired(true);		
        this.txttotalMileage.setEnabled(true);		
        this.txttotalMileage.setForeground(new java.awt.Color(0,0,0));
        // prmtdefaultCarrier		
        this.prmtdefaultCarrier.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.F7CarrierQueryWithDefaultStandard");		
        this.prmtdefaultCarrier.setVisible(true);		
        this.prmtdefaultCarrier.setEditable(true);		
        this.prmtdefaultCarrier.setDisplayFormat("$name$");		
        this.prmtdefaultCarrier.setEditFormat("$number$");		
        this.prmtdefaultCarrier.setCommitFormat("$number$");		
        this.prmtdefaultCarrier.setRequired(false);		
        this.prmtdefaultCarrier.setEnabled(true);		
        this.prmtdefaultCarrier.setForeground(new java.awt.Color(0,0,0));
        // status		
        this.status.setVisible(true);		
        this.status.setRequired(true);		
        this.status.setForeground(new java.awt.Color(0,0,0));		
        this.status.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.im.dt.BillStatusEnum").toArray());		
        this.status.setSelectedIndex(3);		
        this.status.setEnabled(false);
        // txtavgHour		
        this.txtavgHour.setVisible(true);		
        this.txtavgHour.setHorizontalAlignment(2);		
        this.txtavgHour.setDataType(1);		
        this.txtavgHour.setSupportedEmpty(true);		
        this.txtavgHour.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtavgHour.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtavgHour.setPrecision(4);		
        this.txtavgHour.setRequired(false);
        // txtavgMinute		
        this.txtavgMinute.setVisible(true);		
        this.txtavgMinute.setHorizontalAlignment(2);		
        this.txtavgMinute.setDataType(1);		
        this.txtavgMinute.setSupportedEmpty(true);		
        this.txtavgMinute.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtavgMinute.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtavgMinute.setPrecision(4);		
        this.txtavgMinute.setRequired(false);
        // prmtfromStorageOrg		
        this.prmtfromStorageOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtfromStorageOrg.setVisible(true);		
        this.prmtfromStorageOrg.setEditable(true);		
        this.prmtfromStorageOrg.setDisplayFormat("$name$");		
        this.prmtfromStorageOrg.setEditFormat("$number$");		
        this.prmtfromStorageOrg.setCommitFormat("$number$");		
        this.prmtfromStorageOrg.setRequired(false);
        // prmttoStorageOrg		
        this.prmttoStorageOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmttoStorageOrg.setVisible(true);		
        this.prmttoStorageOrg.setEditable(true);		
        this.prmttoStorageOrg.setDisplayFormat("$name$");		
        this.prmttoStorageOrg.setEditFormat("$number$");		
        this.prmttoStorageOrg.setCommitFormat("$number$");		
        this.prmttoStorageOrg.setRequired(false);
        // txtdefaultCarCount		
        this.txtdefaultCarCount.setVisible(true);		
        this.txtdefaultCarCount.setHorizontalAlignment(2);		
        this.txtdefaultCarCount.setDataType(0);		
        this.txtdefaultCarCount.setSupportedEmpty(true);		
        this.txtdefaultCarCount.setRequired(false);
        // btnAddLine
        this.btnAddLine.setAction((IItemAction)ActionProxyFactory.getProxy(actionAddLine, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAddLine.setText(resHelper.getString("btnAddLine.text"));		
        this.btnAddLine.setToolTipText(resHelper.getString("btnAddLine.toolTipText"));
        // btnInsertLine
        this.btnInsertLine.setAction((IItemAction)ActionProxyFactory.getProxy(actionInsertLine, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnInsertLine.setText(resHelper.getString("btnInsertLine.text"));		
        this.btnInsertLine.setToolTipText(resHelper.getString("btnInsertLine.toolTipText"));
        // btnRemoveLine
        this.btnRemoveLine.setAction((IItemAction)ActionProxyFactory.getProxy(actionRemoveLine, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnRemoveLine.setText(resHelper.getString("btnRemoveLine.text"));		
        this.btnRemoveLine.setToolTipText(resHelper.getString("btnRemoveLine.toolTipText"));
        // menuTable		
        this.menuTable.setText(resHelper.getString("menuTable.text"));		
        this.menuTable.setMnemonic(84);
        // menuItemAddLine
        this.menuItemAddLine.setAction((IItemAction)ActionProxyFactory.getProxy(actionAddLine, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemAddLine.setText(resHelper.getString("menuItemAddLine.text"));		
        this.menuItemAddLine.setMnemonic(78);		
        this.menuItemAddLine.setToolTipText(resHelper.getString("menuItemAddLine.toolTipText"));
        // menuItemInsertLine
        this.menuItemInsertLine.setAction((IItemAction)ActionProxyFactory.getProxy(actionInsertLine, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemInsertLine.setText(resHelper.getString("menuItemInsertLine.text"));		
        this.menuItemInsertLine.setMnemonic(73);
        // menuItemRemoveLine
        this.menuItemRemoveLine.setAction((IItemAction)ActionProxyFactory.getProxy(actionRemoveLine, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemRemoveLine.setText(resHelper.getString("menuItemRemoveLine.text"));		
        this.menuItemRemoveLine.setMnemonic(68);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,txtName,prmtbeginStation,prmtendStation,defaultTranType,prmtdefaultCarrier,txttotalMileage,status,kdtEntry,txtDescription,txtavgHour,txtSimpleName,txtavgMinute,chkisInner,prmtfromStorageOrg,prmttoStorageOrg,txtdefaultCarCount}));
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
        this.setBounds(new Rectangle(0, 0, 689, 385));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(10, 10, 352, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(372, 10, 307, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(470, 171, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(412, 216, 270, 19));
        this.add(kDLabelContainer4, null);
        kdtEntry.setBounds(new Rectangle(10, 162, 669, 210));
        this.add(kdtEntry, null);
        contbeginStation.setBounds(new Rectangle(10, 32, 352, 19));
        this.add(contbeginStation, null);
        contendStation.setBounds(new Rectangle(372, 32, 307, 19));
        this.add(contendStation, null);
        contdefaultTranType.setBounds(new Rectangle(10, 59, 352, 19));
        this.add(contdefaultTranType, null);
        conttotalMileage.setBounds(new Rectangle(10, 81, 352, 19));
        this.add(conttotalMileage, null);
        contdefaultCarrier.setBounds(new Rectangle(372, 59, 307, 19));
        this.add(contdefaultCarrier, null);
        contstatus.setBounds(new Rectangle(372, 81, 307, 19));
        this.add(contstatus, null);
        contavgHour.setBounds(new Rectangle(10, 106, 197, 19));
        this.add(contavgHour, null);
        contavgMinute.setBounds(new Rectangle(211, 106, 151, 19));
        this.add(contavgMinute, null);
        chkisInner.setBounds(new Rectangle(372, 106, 114, 19));
        this.add(chkisInner, null);
        contfromStorageOrg.setBounds(new Rectangle(10, 132, 352, 19));
        this.add(contfromStorageOrg, null);
        conttoStorageOrg.setBounds(new Rectangle(372, 132, 307, 19));
        this.add(conttoStorageOrg, null);
        contdefaultCarCount.setBounds(new Rectangle(489, 106, 190, 19));
        this.add(contdefaultCarCount, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contbeginStation
        contbeginStation.setBoundEditor(prmtbeginStation);
        //contendStation
        contendStation.setBoundEditor(prmtendStation);
        //contdefaultTranType
        contdefaultTranType.setBoundEditor(defaultTranType);
        //conttotalMileage
        conttotalMileage.setBoundEditor(txttotalMileage);
        //contdefaultCarrier
        contdefaultCarrier.setBoundEditor(prmtdefaultCarrier);
        //contstatus
        contstatus.setBoundEditor(status);
        //contavgHour
        contavgHour.setBoundEditor(txtavgHour);
        //contavgMinute
        contavgMinute.setBoundEditor(txtavgMinute);
        //contfromStorageOrg
        contfromStorageOrg.setBoundEditor(prmtfromStorageOrg);
        //conttoStorageOrg
        conttoStorageOrg.setBoundEditor(prmttoStorageOrg);
        //contdefaultCarCount
        contdefaultCarCount.setBoundEditor(txtdefaultCarCount);

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
        this.menuBar.add(menuTable);
        this.menuBar.add(menuTool);
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
        //menuBiz
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        //menuTable
        menuTable.add(menuItemAddLine);
        menuTable.add(menuItemInsertLine);
        menuTable.add(menuItemRemoveLine);
        //menuTool
        menuTool.add(menuItemMsgFormat);
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemCalculator);
        menuTool.add(menuItemToolBarCustom);
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
        this.toolBar.add(btnReset);
        this.toolBar.add(kDSeparatorCloud);
        this.toolBar.add(btnSubmit);
        this.toolBar.add(btnCopy);
        this.toolBar.add(btnRemove);
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
        this.toolBar.add(btnAddLine);
        this.toolBar.add(btnInsertLine);
        this.toolBar.add(btnRemoveLine);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("entry.detailMileage", java.math.BigDecimal.class, this.kdtEntry, "detailMileage.text");
		dataBinder.registerBinding("entry", com.kingdee.eas.delivery.basedata.DeliveryLineEntryInfo.class, this.kdtEntry, "userObject");
		dataBinder.registerBinding("entry.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntry, "id.text");
		dataBinder.registerBinding("entry.detailLine.beginStation.name", String.class, this.kdtEntry, "detailBegin.text");
		dataBinder.registerBinding("entry.detailLine.endStation.name", String.class, this.kdtEntry, "detailEnd.text");
		dataBinder.registerBinding("entry.detailCarrier", com.kingdee.eas.basedata.master.cssp.SupplierInfo.class, this.kdtEntry, "detailCarrier.text");
		dataBinder.registerBinding("entry.detailTranType", com.kingdee.util.enums.Enum.class, this.kdtEntry, "detailTranType.text");
		dataBinder.registerBinding("entry.detailLine", com.kingdee.eas.scm.im.dt.DeliveryLineEntryInfo.class, this.kdtEntry, "detailLine.text");
		dataBinder.registerBinding("isInner", boolean.class, this.chkisInner, "selected");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("beginStation", com.kingdee.eas.basedata.assistant.AddressInfo.class, this.prmtbeginStation, "data");
		dataBinder.registerBinding("endStation", com.kingdee.eas.basedata.assistant.AddressInfo.class, this.prmtendStation, "data");
		dataBinder.registerBinding("defaultTranType", com.kingdee.eas.scm.im.dt.TransportTypeEnum.class, this.defaultTranType, "selectedItem");
		dataBinder.registerBinding("totalMileage", java.math.BigDecimal.class, this.txttotalMileage, "value");
		dataBinder.registerBinding("defaultCarrier", com.kingdee.eas.basedata.master.cssp.SupplierInfo.class, this.prmtdefaultCarrier, "data");
		dataBinder.registerBinding("status", com.kingdee.eas.scm.im.dt.BillStatusEnum.class, this.status, "selectedItem");
		dataBinder.registerBinding("avgHour", java.math.BigDecimal.class, this.txtavgHour, "value");
		dataBinder.registerBinding("avgMinute", java.math.BigDecimal.class, this.txtavgMinute, "value");
		dataBinder.registerBinding("fromStorageOrg", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtfromStorageOrg, "data");
		dataBinder.registerBinding("toStorageOrg", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmttoStorageOrg, "data");
		dataBinder.registerBinding("defaultCarCount", int.class, this.txtdefaultCarCount, "value");		
	}
	//Regiester UI State
	private void registerUIState(){
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtDescription, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtDescription, ActionStateConst.ENABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtName, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtDescription, ActionStateConst.DISABLED);		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.delivery.basedata.app.DeliveryLineEditUIHandler";
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
        this.editData = (com.kingdee.eas.delivery.basedata.DeliveryLineInfo)ov;
    }
    protected void removeByPK(IObjectPK pk) throws Exception {
    	IObjectValue editData = this.editData;
    	super.removeByPK(pk);
    	recycleNumberByOrg(editData,"ControlUnit",editData.getString("number"));
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
        		setAutoNumberByOrg("ControlUnit");
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
		getValidateHelper().registerBindProperty("entry.detailMileage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.detailLine.beginStation.name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.detailLine.endStation.name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.detailCarrier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.detailTranType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entry.detailLine", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isInner", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("beginStation", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("endStation", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("defaultTranType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalMileage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("defaultCarrier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("status", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("avgHour", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("avgMinute", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fromStorageOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("toStorageOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("defaultCarCount", ValidateHelper.ON_SAVE);    		
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
        if (STATUS_ADDNEW.equals(this.oprtState)) {
		            this.txtName.setEnabled(true);
		            this.txtDescription.setEnabled(true);
        } else if (STATUS_EDIT.equals(this.oprtState)) {
		            this.txtName.setEnabled(true);
		            this.txtDescription.setEnabled(true);
        } else if (STATUS_VIEW.equals(this.oprtState)) {
		            this.txtName.setEnabled(false);
		            this.txtDescription.setEnabled(false);
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
    	sic.add(new SelectorItemInfo("entry.detailMileage"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entry.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("entry.id"));
    	sic.add(new SelectorItemInfo("entry.detailLine.beginStation.name"));
    	sic.add(new SelectorItemInfo("entry.detailLine.endStation.name"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entry.detailCarrier.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entry.detailCarrier.id"));
			sic.add(new SelectorItemInfo("entry.detailCarrier.name"));
        	sic.add(new SelectorItemInfo("entry.detailCarrier.number"));
		}
    	sic.add(new SelectorItemInfo("entry.detailTranType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entry.detailLine.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entry.detailLine.id"));
			sic.add(new SelectorItemInfo("entry.detailLine.name"));
        	sic.add(new SelectorItemInfo("entry.detailLine.number"));
		}
        sic.add(new SelectorItemInfo("isInner"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("beginStation.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("beginStation.id"));
        	sic.add(new SelectorItemInfo("beginStation.number"));
        	sic.add(new SelectorItemInfo("beginStation.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("endStation.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("endStation.id"));
        	sic.add(new SelectorItemInfo("endStation.number"));
        	sic.add(new SelectorItemInfo("endStation.name"));
		}
        sic.add(new SelectorItemInfo("defaultTranType"));
        sic.add(new SelectorItemInfo("totalMileage"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("defaultCarrier.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("defaultCarrier.id"));
        	sic.add(new SelectorItemInfo("defaultCarrier.number"));
        	sic.add(new SelectorItemInfo("defaultCarrier.name"));
		}
        sic.add(new SelectorItemInfo("status"));
        sic.add(new SelectorItemInfo("avgHour"));
        sic.add(new SelectorItemInfo("avgMinute"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("fromStorageOrg.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("fromStorageOrg.id"));
        	sic.add(new SelectorItemInfo("fromStorageOrg.number"));
        	sic.add(new SelectorItemInfo("fromStorageOrg.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("toStorageOrg.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("toStorageOrg.id"));
        	sic.add(new SelectorItemInfo("toStorageOrg.number"));
        	sic.add(new SelectorItemInfo("toStorageOrg.name"));
		}
        sic.add(new SelectorItemInfo("defaultCarCount"));
        return sic;
    }        
    	

    /**
     * output actionCancel_actionPerformed method
     */
    public void actionCancel_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCancel_actionPerformed(e);
    }
    	

    /**
     * output actionCancelCancel_actionPerformed method
     */
    public void actionCancelCancel_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCancelCancel_actionPerformed(e);
    }
    	

    /**
     * output actionEdit_actionPerformed method
     */
    public void actionEdit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionEdit_actionPerformed(e);
    }
    	

    /**
     * output actionRemove_actionPerformed method
     */
    public void actionRemove_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemove_actionPerformed(e);
    }
    	

    /**
     * output actionAddLine_actionPerformed method
     */
    public void actionAddLine_actionPerformed(ActionEvent e) throws Exception
    {
        //write your code here
    }
    	

    /**
     * output actionInsertLine_actionPerformed method
     */
    public void actionInsertLine_actionPerformed(ActionEvent e) throws Exception
    {
        //write your code here
    }
    	

    /**
     * output actionRemoveLine_actionPerformed method
     */
    public void actionRemoveLine_actionPerformed(ActionEvent e) throws Exception
    {
        //write your code here
    }
	public RequestContext prepareActionCancel(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionCancel(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionCancel() {
    	return false;
    }
	public RequestContext prepareActionCancelCancel(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionCancelCancel(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionCancelCancel() {
    	return false;
    }
	public RequestContext prepareActionEdit(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionEdit(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionEdit() {
    	return false;
    }
	public RequestContext prepareActionRemove(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionRemove(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionRemove() {
    	return false;
    }
	public RequestContext prepareActionAddLine(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAddLine() {
    	return false;
    }
	public RequestContext prepareActionInsertLine(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionInsertLine() {
    	return false;
    }
	public RequestContext prepareActionRemoveLine(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionRemoveLine() {
    	return false;
    }

    /**
     * output ActionAddLine class
     */     
    protected class ActionAddLine extends ItemAction {     
    
        public ActionAddLine()
        {
            this(null);
        }

        public ActionAddLine(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("shift ctrl N"));
            _tempStr = resHelper.getString("ActionAddLine.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAddLine.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAddLine.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractDeliveryLineEditUI.this, "ActionAddLine", "actionAddLine_actionPerformed", e);
        }
    }

    /**
     * output ActionInsertLine class
     */     
    protected class ActionInsertLine extends ItemAction {     
    
        public ActionInsertLine()
        {
            this(null);
        }

        public ActionInsertLine(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl shift I"));
            _tempStr = resHelper.getString("ActionInsertLine.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionInsertLine.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionInsertLine.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractDeliveryLineEditUI.this, "ActionInsertLine", "actionInsertLine_actionPerformed", e);
        }
    }

    /**
     * output ActionRemoveLine class
     */     
    protected class ActionRemoveLine extends ItemAction {     
    
        public ActionRemoveLine()
        {
            this(null);
        }

        public ActionRemoveLine(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl shift D"));
            _tempStr = resHelper.getString("ActionRemoveLine.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionRemoveLine.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionRemoveLine.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractDeliveryLineEditUI.this, "ActionRemoveLine", "actionRemoveLine_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.delivery.basedata.client", "DeliveryLineEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.delivery.basedata.client.DeliveryLineEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.delivery.basedata.DeliveryLineFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.delivery.basedata.DeliveryLineInfo objectValue = new com.kingdee.eas.delivery.basedata.DeliveryLineInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }



    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
				vo.put("totalMileage",new java.math.BigDecimal(0));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}