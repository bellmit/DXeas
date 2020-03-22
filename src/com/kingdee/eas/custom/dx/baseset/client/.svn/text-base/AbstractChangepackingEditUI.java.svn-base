/**
 * output package name
 */
package com.kingdee.eas.custom.dx.baseset.client;

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
public abstract class AbstractChangepackingEditUI extends com.kingdee.eas.custom.wlhllicensemanager.client.WlhlCoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractChangepackingEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator9;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator10;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator15;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnGetData;
    protected com.kingdee.eas.custom.dx.baseset.ChangepackingInfo editData = null;
    protected ActionGetData actionGetData = null;
    /**
     * output class constructor
     */
    public AbstractChangepackingEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractChangepackingEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        //actionGetData
        this.actionGetData = new ActionGetData(this);
        getActionManager().registerAction("actionGetData", actionGetData);
        this.actionGetData.setExtendProperty("canForewarn", "true");
        this.actionGetData.setExtendProperty("userDefined", "false");
        this.actionGetData.setExtendProperty("isObjectUpdateLock", "false");
         this.actionGetData.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionGetData.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDSeparator9 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDSeparator10 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDSeparator15 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.btnGetData = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.kDSeparator8.setName("kDSeparator8");
        this.kDSeparator9.setName("kDSeparator9");
        this.kDSeparator10.setName("kDSeparator10");
        this.kDSeparator15.setName("kDSeparator15");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contcompany.setName("contcompany");
        this.kDPanel3.setName("kDPanel3");
        this.kDPanel1.setName("kDPanel1");
        this.kdtEntry.setName("kdtEntry");
        this.prmtcompany.setName("prmtcompany");
        this.btnGetData.setName("btnGetData");
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
        this.contCreator.setBoundLabelText(resHelper.getString("contCreator.boundLabelText"));		
        this.contCreator.setBoundLabelLength(100);		
        this.contCreator.setBoundLabelUnderline(true);		
        this.contCreator.setEnabled(false);		
        this.contCreateTime.setBoundLabelText(resHelper.getString("contCreateTime.boundLabelText"));		
        this.contCreateTime.setBoundLabelLength(100);		
        this.contCreateTime.setBoundLabelUnderline(true);		
        this.contCreateTime.setEnabled(false);		
        this.contLastUpdateUser.setBoundLabelText(resHelper.getString("contLastUpdateUser.boundLabelText"));		
        this.contLastUpdateUser.setBoundLabelLength(100);		
        this.contLastUpdateUser.setBoundLabelUnderline(true);		
        this.contLastUpdateUser.setEnabled(false);		
        this.contLastUpdateUser.setVisible(true);		
        this.contLastUpdateTime.setBoundLabelText(resHelper.getString("contLastUpdateTime.boundLabelText"));		
        this.contLastUpdateTime.setBoundLabelLength(100);		
        this.contLastUpdateTime.setBoundLabelUnderline(true);		
        this.contLastUpdateTime.setEnabled(false);		
        this.contLastUpdateTime.setVisible(true);		
        this.contNumber.setBoundLabelText(resHelper.getString("contNumber.boundLabelText"));		
        this.contNumber.setBoundLabelLength(100);		
        this.contNumber.setBoundLabelUnderline(true);		
        this.contNumber.setVisible(false);		
        this.contBizDate.setBoundLabelText(resHelper.getString("contBizDate.boundLabelText"));		
        this.contBizDate.setBoundLabelLength(100);		
        this.contBizDate.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelAlignment(7);		
        this.contBizDate.setVisible(true);		
        this.contDescription.setBoundLabelText(resHelper.getString("contDescription.boundLabelText"));		
        this.contDescription.setBoundLabelLength(100);		
        this.contDescription.setBoundLabelUnderline(true);		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);		
        this.prmtCreator.setEnabled(false);		
        this.kDDateCreateTime.setTimeEnabled(true);		
        this.kDDateCreateTime.setEnabled(false);		
        this.prmtLastUpdateUser.setEnabled(false);		
        this.kDDateLastUpdateTime.setTimeEnabled(true);		
        this.kDDateLastUpdateTime.setEnabled(false);		
        this.txtNumber.setMaxLength(80);		
        this.pkBizDate.setEnabled(true);		
        this.txtDescription.setMaxLength(80);		
        this.prmtAuditor.setEnabled(false);
        // kDSeparator8
        // kDSeparator9
        // kDSeparator10
        // kDSeparator15
        // kDTabbedPane1
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // kDPanel3
        // kDPanel1		
        this.kDPanel1.setVisible(false);
        // kdtEntry
		String kdtEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat><c:Alignment horizontal=\"right\" /></c:Style><c:Style id=\"sCol7\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol11\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"materialNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"materialName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"packMaterial\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"packMaterialName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"packMaterialMod\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"packM1Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"packMtwo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"packMtwoName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"packMtwomod\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"packM2Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{materialNum}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{model}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{packMaterial}</t:Cell><t:Cell>$Resource{packMaterialName}</t:Cell><t:Cell>$Resource{packMaterialMod}</t:Cell><t:Cell>$Resource{packM1Qty}</t:Cell><t:Cell>$Resource{packMtwo}</t:Cell><t:Cell>$Resource{packMtwoName}</t:Cell><t:Cell>$Resource{packMtwomod}</t:Cell><t:Cell>$Resource{packM2Qty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtEntry.putBindContents("editData",new String[] {"seq","materialNum","materialName","model","qty","packMaterial","packMaterialName","packMaterialMod","packM1Qty","packMtwo","packMtwoName","packMtwomod","packM2Qty"});


        this.kdtEntry.checkParsed();
        final KDBizPromptBox kdtEntry_materialNum_PromptBox = new KDBizPromptBox();
        kdtEntry_materialNum_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtEntry_materialNum_PromptBox.setVisible(true);
        kdtEntry_materialNum_PromptBox.setEditable(true);
        kdtEntry_materialNum_PromptBox.setDisplayFormat("$number$");
        kdtEntry_materialNum_PromptBox.setEditFormat("$number$");
        kdtEntry_materialNum_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_materialNum_CellEditor = new KDTDefaultCellEditor(kdtEntry_materialNum_PromptBox);
        this.kdtEntry.getColumn("materialNum").setEditor(kdtEntry_materialNum_CellEditor);
        ObjectValueRender kdtEntry_materialNum_OVR = new ObjectValueRender();
        kdtEntry_materialNum_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntry.getColumn("materialNum").setRenderer(kdtEntry_materialNum_OVR);
        KDTextField kdtEntry_materialName_TextField = new KDTextField();
        kdtEntry_materialName_TextField.setName("kdtEntry_materialName_TextField");
        kdtEntry_materialName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntry_materialName_CellEditor = new KDTDefaultCellEditor(kdtEntry_materialName_TextField);
        this.kdtEntry.getColumn("materialName").setEditor(kdtEntry_materialName_CellEditor);
        KDTextField kdtEntry_model_TextField = new KDTextField();
        kdtEntry_model_TextField.setName("kdtEntry_model_TextField");
        kdtEntry_model_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntry_model_CellEditor = new KDTDefaultCellEditor(kdtEntry_model_TextField);
        this.kdtEntry.getColumn("model").setEditor(kdtEntry_model_CellEditor);
        KDFormattedTextField kdtEntry_qty_TextField = new KDFormattedTextField();
        kdtEntry_qty_TextField.setName("kdtEntry_qty_TextField");
        kdtEntry_qty_TextField.setVisible(true);
        kdtEntry_qty_TextField.setEditable(true);
        kdtEntry_qty_TextField.setHorizontalAlignment(2);
        kdtEntry_qty_TextField.setDataType(1);
        	kdtEntry_qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_qty_CellEditor = new KDTDefaultCellEditor(kdtEntry_qty_TextField);
        this.kdtEntry.getColumn("qty").setEditor(kdtEntry_qty_CellEditor);
        final KDBizPromptBox kdtEntry_packMaterial_PromptBox = new KDBizPromptBox();
        kdtEntry_packMaterial_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtEntry_packMaterial_PromptBox.setVisible(true);
        kdtEntry_packMaterial_PromptBox.setEditable(true);
        kdtEntry_packMaterial_PromptBox.setDisplayFormat("$number$");
        kdtEntry_packMaterial_PromptBox.setEditFormat("$number$");
        kdtEntry_packMaterial_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_packMaterial_CellEditor = new KDTDefaultCellEditor(kdtEntry_packMaterial_PromptBox);
        this.kdtEntry.getColumn("packMaterial").setEditor(kdtEntry_packMaterial_CellEditor);
        ObjectValueRender kdtEntry_packMaterial_OVR = new ObjectValueRender();
        kdtEntry_packMaterial_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntry.getColumn("packMaterial").setRenderer(kdtEntry_packMaterial_OVR);
        KDTextField kdtEntry_packMaterialName_TextField = new KDTextField();
        kdtEntry_packMaterialName_TextField.setName("kdtEntry_packMaterialName_TextField");
        kdtEntry_packMaterialName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntry_packMaterialName_CellEditor = new KDTDefaultCellEditor(kdtEntry_packMaterialName_TextField);
        this.kdtEntry.getColumn("packMaterialName").setEditor(kdtEntry_packMaterialName_CellEditor);
        KDTextField kdtEntry_packMaterialMod_TextField = new KDTextField();
        kdtEntry_packMaterialMod_TextField.setName("kdtEntry_packMaterialMod_TextField");
        kdtEntry_packMaterialMod_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntry_packMaterialMod_CellEditor = new KDTDefaultCellEditor(kdtEntry_packMaterialMod_TextField);
        this.kdtEntry.getColumn("packMaterialMod").setEditor(kdtEntry_packMaterialMod_CellEditor);
        KDFormattedTextField kdtEntry_packM1Qty_TextField = new KDFormattedTextField();
        kdtEntry_packM1Qty_TextField.setName("kdtEntry_packM1Qty_TextField");
        kdtEntry_packM1Qty_TextField.setVisible(true);
        kdtEntry_packM1Qty_TextField.setEditable(true);
        kdtEntry_packM1Qty_TextField.setHorizontalAlignment(2);
        kdtEntry_packM1Qty_TextField.setDataType(1);
        	kdtEntry_packM1Qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_packM1Qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_packM1Qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_packM1Qty_CellEditor = new KDTDefaultCellEditor(kdtEntry_packM1Qty_TextField);
        this.kdtEntry.getColumn("packM1Qty").setEditor(kdtEntry_packM1Qty_CellEditor);
        final KDBizPromptBox kdtEntry_packMtwo_PromptBox = new KDBizPromptBox();
        kdtEntry_packMtwo_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtEntry_packMtwo_PromptBox.setVisible(true);
        kdtEntry_packMtwo_PromptBox.setEditable(true);
        kdtEntry_packMtwo_PromptBox.setDisplayFormat("$number$");
        kdtEntry_packMtwo_PromptBox.setEditFormat("$number$");
        kdtEntry_packMtwo_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_packMtwo_CellEditor = new KDTDefaultCellEditor(kdtEntry_packMtwo_PromptBox);
        this.kdtEntry.getColumn("packMtwo").setEditor(kdtEntry_packMtwo_CellEditor);
        ObjectValueRender kdtEntry_packMtwo_OVR = new ObjectValueRender();
        kdtEntry_packMtwo_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntry.getColumn("packMtwo").setRenderer(kdtEntry_packMtwo_OVR);
        KDTextField kdtEntry_packMtwoName_TextField = new KDTextField();
        kdtEntry_packMtwoName_TextField.setName("kdtEntry_packMtwoName_TextField");
        kdtEntry_packMtwoName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntry_packMtwoName_CellEditor = new KDTDefaultCellEditor(kdtEntry_packMtwoName_TextField);
        this.kdtEntry.getColumn("packMtwoName").setEditor(kdtEntry_packMtwoName_CellEditor);
        KDTextField kdtEntry_packMtwomod_TextField = new KDTextField();
        kdtEntry_packMtwomod_TextField.setName("kdtEntry_packMtwomod_TextField");
        kdtEntry_packMtwomod_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntry_packMtwomod_CellEditor = new KDTDefaultCellEditor(kdtEntry_packMtwomod_TextField);
        this.kdtEntry.getColumn("packMtwomod").setEditor(kdtEntry_packMtwomod_CellEditor);
        KDFormattedTextField kdtEntry_packM2Qty_TextField = new KDFormattedTextField();
        kdtEntry_packM2Qty_TextField.setName("kdtEntry_packM2Qty_TextField");
        kdtEntry_packM2Qty_TextField.setVisible(true);
        kdtEntry_packM2Qty_TextField.setEditable(true);
        kdtEntry_packM2Qty_TextField.setHorizontalAlignment(2);
        kdtEntry_packM2Qty_TextField.setDataType(1);
        	kdtEntry_packM2Qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_packM2Qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_packM2Qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_packM2Qty_CellEditor = new KDTDefaultCellEditor(kdtEntry_packM2Qty_TextField);
        this.kdtEntry.getColumn("packM2Qty").setEditor(kdtEntry_packM2Qty_CellEditor);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(false);
        // btnGetData
        this.btnGetData.setAction((IItemAction)ActionProxyFactory.getProxy(actionGetData, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnGetData.setText(resHelper.getString("btnGetData.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,pkauditTime,billStatus,prmtcompany,kdtEntry}));
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
        this.setBounds(new Rectangle(0, 0, 1217, 629));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1217, 629));
        contCreator.setBounds(new Rectangle(318, 557, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(318, 557, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(318, 586, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(318, 586, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(617, 557, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(617, 557, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(617, 586, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(617, 586, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(14, 17, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(14, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(917, 557, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(917, 557, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(19, 557, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(19, 557, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(19, 586, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(19, 586, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(917, 17, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(917, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator8.setBounds(new Rectangle(15, 44, 1190, 10));
        this.add(kDSeparator8, new KDLayout.Constraints(15, 44, 1190, 10, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator9.setBounds(new Rectangle(15, 51, 1190, 10));
        this.add(kDSeparator9, new KDLayout.Constraints(15, 51, 1190, 10, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator10.setBounds(new Rectangle(445, 315, 1, 1));
        this.add(kDSeparator10, new KDLayout.Constraints(445, 315, 1, 1, 0));
        kDSeparator15.setBounds(new Rectangle(19, 543, 1190, 10));
        this.add(kDSeparator15, new KDLayout.Constraints(19, 543, 1190, 10, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDTabbedPane1.setBounds(new Rectangle(9, 64, 1183, 469));
        this.add(kDTabbedPane1, new KDLayout.Constraints(9, 64, 1183, 469, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompany.setBounds(new Rectangle(440, 18, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(440, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contCreator
        contCreator.setBoundEditor(prmtCreator);
        //contCreateTime
        contCreateTime.setBoundEditor(kDDateCreateTime);
        //contLastUpdateUser
        contLastUpdateUser.setBoundEditor(prmtLastUpdateUser);
        //contLastUpdateTime
        contLastUpdateTime.setBoundEditor(kDDateLastUpdateTime);
        //contBizDate
        contBizDate.setBoundEditor(pkBizDate);
        //contDescription
        contDescription.setBoundEditor(txtDescription);
        //contAuditor
        contAuditor.setBoundEditor(prmtAuditor);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        //kDPanel3
        kDPanel3.setLayout(new KDLayout());
        kDPanel3.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1182, 436));        kDPanel1.setBounds(new Rectangle(613, 301, 874, 198));
        kDPanel3.add(kDPanel1, new KDLayout.Constraints(613, 301, 874, 198, 0));
        kdtEntry.setBounds(new Rectangle(2, 21, 1173, 408));
        kdtEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntry,new com.kingdee.eas.custom.dx.baseset.ChangepackingEntryInfo(),null,false);
        kDPanel3.add(kdtEntry_detailPanel, new KDLayout.Constraints(2, 21, 1173, 408, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //kDPanel1
        kDPanel1.setLayout(null);        contNumber.setBounds(new Rectangle(20, 51, 270, 19));
        kDPanel1.add(contNumber, null);
        //contNumber
        contNumber.setBoundEditor(txtNumber);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);

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
        menuBiz.add(mBtnAudit);
        menuBiz.add(mBtnUnAudit);
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        menuBiz.add(MenuItemVoucher);
        menuBiz.add(MenuItemPCVoucher);
        menuBiz.add(menuItemDelVoucher);
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
        this.toolBar.add(tBtnAudit);
        this.toolBar.add(tBtnUnAudit);
        this.toolBar.add(btnGetData);
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
        this.toolBar.add(btnPCVoucher);
        this.toolBar.add(btnVoucher);
        this.toolBar.add(btnDelPCVoucher);
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
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("Entry.seq", int.class, this.kdtEntry, "seq.text");
		dataBinder.registerBinding("Entry", com.kingdee.eas.custom.dx.baseset.ChangepackingEntryInfo.class, this.kdtEntry, "userObject");
		dataBinder.registerBinding("Entry.materialNum", java.lang.Object.class, this.kdtEntry, "materialNum.text");
		dataBinder.registerBinding("Entry.materialName", String.class, this.kdtEntry, "materialName.text");
		dataBinder.registerBinding("Entry.model", String.class, this.kdtEntry, "model.text");
		dataBinder.registerBinding("Entry.qty", java.math.BigDecimal.class, this.kdtEntry, "qty.text");
		dataBinder.registerBinding("Entry.packMaterialName", String.class, this.kdtEntry, "packMaterialName.text");
		dataBinder.registerBinding("Entry.packMaterial", java.lang.Object.class, this.kdtEntry, "packMaterial.text");
		dataBinder.registerBinding("Entry.packMaterialMod", String.class, this.kdtEntry, "packMaterialMod.text");
		dataBinder.registerBinding("Entry.packMtwo", java.lang.Object.class, this.kdtEntry, "packMtwo.text");
		dataBinder.registerBinding("Entry.packMtwoName", String.class, this.kdtEntry, "packMtwoName.text");
		dataBinder.registerBinding("Entry.packMtwomod", String.class, this.kdtEntry, "packMtwomod.text");
		dataBinder.registerBinding("Entry.packM1Qty", java.math.BigDecimal.class, this.kdtEntry, "packM1Qty.text");
		dataBinder.registerBinding("Entry.packM2Qty", java.math.BigDecimal.class, this.kdtEntry, "packM2Qty.text");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.dx.baseset.app.ChangepackingEditUIHandler";
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
        this.editData = (com.kingdee.eas.custom.dx.baseset.ChangepackingInfo)ov;
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
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.materialNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.materialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.model", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.packMaterialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.packMaterial", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.packMaterialMod", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.packMtwo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.packMtwoName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.packMtwomod", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.packM1Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.packM2Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    		
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
     * output kdtEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("materialNum".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"materialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntry.getCell(rowIndex,"materialNum").getValue(),"name")));

}

    if ("materialNum".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"model").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntry.getCell(rowIndex,"materialNum").getValue(),"model")));

}

    if ("packMaterial".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"packMaterialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntry.getCell(rowIndex,"packMaterial").getValue(),"name")));
kdtEntry.getCell(rowIndex,"packMaterialMod").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntry.getCell(rowIndex,"packMaterial").getValue(),"model")));

}

    if ("packMtwo".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"packMtwoName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntry.getCell(rowIndex,"packMtwo").getValue(),"name")));

}

    if ("packMtwo".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"packMtwomod").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntry.getCell(rowIndex,"packMtwo").getValue(),"model")));

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
        sic.add(new SelectorItemInfo("auditTime"));
        sic.add(new SelectorItemInfo("billStatus"));
    	sic.add(new SelectorItemInfo("Entry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.materialNum.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entry.materialNum.id"));
			sic.add(new SelectorItemInfo("Entry.materialNum.number"));
			sic.add(new SelectorItemInfo("Entry.materialNum.name"));
		}
    	sic.add(new SelectorItemInfo("Entry.materialName"));
    	sic.add(new SelectorItemInfo("Entry.model"));
    	sic.add(new SelectorItemInfo("Entry.qty"));
    	sic.add(new SelectorItemInfo("Entry.packMaterialName"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.packMaterial.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entry.packMaterial.id"));
			sic.add(new SelectorItemInfo("Entry.packMaterial.number"));
			sic.add(new SelectorItemInfo("Entry.packMaterial.name"));
		}
    	sic.add(new SelectorItemInfo("Entry.packMaterialMod"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.packMtwo.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entry.packMtwo.id"));
			sic.add(new SelectorItemInfo("Entry.packMtwo.number"));
			sic.add(new SelectorItemInfo("Entry.packMtwo.name"));
		}
    	sic.add(new SelectorItemInfo("Entry.packMtwoName"));
    	sic.add(new SelectorItemInfo("Entry.packMtwomod"));
    	sic.add(new SelectorItemInfo("Entry.packM1Qty"));
    	sic.add(new SelectorItemInfo("Entry.packM2Qty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
        return sic;
    }        
    	

    /**
     * output actionGetData_actionPerformed method
     */
    public void actionGetData_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.dx.baseset.ChangepackingFactory.getRemoteInstance().getData(editData);
    }
	public RequestContext prepareActionGetData(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionGetData() {
    	return false;
    }

    /**
     * output ActionGetData class
     */     
    protected class ActionGetData extends ItemAction {     
    
        public ActionGetData()
        {
            this(null);
        }

        public ActionGetData(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionGetData.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionGetData.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionGetData.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractChangepackingEditUI.this, "ActionGetData", "actionGetData_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.dx.baseset.client", "ChangepackingEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.dx.baseset.client.ChangepackingEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.dx.baseset.ChangepackingFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.dx.baseset.ChangepackingInfo objectValue = new com.kingdee.eas.custom.dx.baseset.ChangepackingInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/dx/baseset/Changepacking";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.dx.baseset.app.ChangepackingQuery");
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
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}        
				protected void setTableToSumField() {
			setTableToSumField(kdtEntry,new String[] {"qty"});
		}


}