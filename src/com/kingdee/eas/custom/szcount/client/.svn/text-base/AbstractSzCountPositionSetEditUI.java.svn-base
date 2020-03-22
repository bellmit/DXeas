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
public abstract class AbstractSzCountPositionSetEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSzCountPositionSetEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcountset;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompanyOrg;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisManufacture;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisIceFrish;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtOperatorEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtOperatorEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtMaterialEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtMaterialEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDComboBox countset;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompanyOrg;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton importEx;
    protected com.kingdee.eas.custom.szcount.SzCountPositionSetInfo editData = null;
    protected ActionImportforEx actionImportforEx = null;
    /**
     * output class constructor
     */
    public AbstractSzCountPositionSetEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractSzCountPositionSetEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        //actionImportforEx
        this.actionImportforEx = new ActionImportforEx(this);
        getActionManager().registerAction("actionImportforEx", actionImportforEx);
        this.actionImportforEx.setExtendProperty("canForewarn", "true");
        this.actionImportforEx.setExtendProperty("userDefined", "true");
        this.actionImportforEx.setExtendProperty("isObjectUpdateLock", "false");
         this.actionImportforEx.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionImportforEx.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcountset = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompanyOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisManufacture = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisIceFrish = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtOperatorEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtMaterialEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.countset = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtcompanyOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.importEx = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contcompany.setName("contcompany");
        this.contcountset.setName("contcountset");
        this.contbaseStatus.setName("contbaseStatus");
        this.contcompanyOrg.setName("contcompanyOrg");
        this.chkisManufacture.setName("chkisManufacture");
        this.chkisIceFrish.setName("chkisIceFrish");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kdtOperatorEntry.setName("kdtOperatorEntry");
        this.kdtMaterialEntry.setName("kdtMaterialEntry");
        this.prmtcompany.setName("prmtcompany");
        this.countset.setName("countset");
        this.baseStatus.setName("baseStatus");
        this.prmtcompanyOrg.setName("prmtcompanyOrg");
        this.importEx.setName("importEx");
        // CoreUI		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelLength(100);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);
        // kDLabelContainer3		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelLength(100);		
        this.kDLabelContainer3.setBoundLabelUnderline(true);
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelAlignment(7);		
        this.kDLabelContainer4.setVisible(true);
        // kDTabbedPane1
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contcountset		
        this.contcountset.setBoundLabelText(resHelper.getString("contcountset.boundLabelText"));		
        this.contcountset.setBoundLabelLength(100);		
        this.contcountset.setBoundLabelUnderline(true);		
        this.contcountset.setVisible(true);
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);
        // contcompanyOrg		
        this.contcompanyOrg.setBoundLabelText(resHelper.getString("contcompanyOrg.boundLabelText"));		
        this.contcompanyOrg.setBoundLabelLength(100);		
        this.contcompanyOrg.setBoundLabelUnderline(true);		
        this.contcompanyOrg.setVisible(true);
        // chkisManufacture		
        this.chkisManufacture.setText(resHelper.getString("chkisManufacture.text"));		
        this.chkisManufacture.setVisible(true);		
        this.chkisManufacture.setHorizontalAlignment(2);
        // chkisIceFrish		
        this.chkisIceFrish.setText(resHelper.getString("chkisIceFrish.text"));		
        this.chkisIceFrish.setVisible(true);		
        this.chkisIceFrish.setHorizontalAlignment(2);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // kDPanel1
        // kDPanel2
        // kdtOperatorEntry
		String kdtOperatorEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"person\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{person}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtOperatorEntry.setFormatXml(resHelper.translateString("kdtOperatorEntry",kdtOperatorEntryStrXML));

                this.kdtOperatorEntry.putBindContents("editData",new String[] {"seq","person"});


        this.kdtOperatorEntry.checkParsed();
        KDFormattedTextField kdtOperatorEntry_seq_TextField = new KDFormattedTextField();
        kdtOperatorEntry_seq_TextField.setName("kdtOperatorEntry_seq_TextField");
        kdtOperatorEntry_seq_TextField.setVisible(true);
        kdtOperatorEntry_seq_TextField.setEditable(true);
        kdtOperatorEntry_seq_TextField.setHorizontalAlignment(2);
        kdtOperatorEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtOperatorEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtOperatorEntry_seq_TextField);
        this.kdtOperatorEntry.getColumn("seq").setEditor(kdtOperatorEntry_seq_CellEditor);
        final KDBizPromptBox kdtOperatorEntry_person_PromptBox = new KDBizPromptBox();
        kdtOperatorEntry_person_PromptBox.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");
        kdtOperatorEntry_person_PromptBox.setVisible(true);
        kdtOperatorEntry_person_PromptBox.setEditable(true);
        kdtOperatorEntry_person_PromptBox.setDisplayFormat("$number$");
        kdtOperatorEntry_person_PromptBox.setEditFormat("$number$");
        kdtOperatorEntry_person_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtOperatorEntry_person_CellEditor = new KDTDefaultCellEditor(kdtOperatorEntry_person_PromptBox);
        this.kdtOperatorEntry.getColumn("person").setEditor(kdtOperatorEntry_person_CellEditor);
        ObjectValueRender kdtOperatorEntry_person_OVR = new ObjectValueRender();
        kdtOperatorEntry_person_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtOperatorEntry.getColumn("person").setRenderer(kdtOperatorEntry_person_OVR);
        // kdtMaterialEntry
		String kdtMaterialEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"materialNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"baseUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"inventoryUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"materialtype\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"defaultQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"isCount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"materialGroup\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{materialNum}</t:Cell><t:Cell>$Resource{baseUnit}</t:Cell><t:Cell>$Resource{inventoryUnit}</t:Cell><t:Cell>$Resource{materialtype}</t:Cell><t:Cell>$Resource{defaultQty}</t:Cell><t:Cell>$Resource{isCount}</t:Cell><t:Cell>$Resource{materialGroup}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtMaterialEntry.setFormatXml(resHelper.translateString("kdtMaterialEntry",kdtMaterialEntryStrXML));
        kdtMaterialEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtMaterialEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtMaterialEntry.putBindContents("editData",new String[] {"seq","material","materialNum","baseUnit","inventoryUnit","materialtype","defaultQty","isCount","materialGroup"});


        this.kdtMaterialEntry.checkParsed();
        KDFormattedTextField kdtMaterialEntry_seq_TextField = new KDFormattedTextField();
        kdtMaterialEntry_seq_TextField.setName("kdtMaterialEntry_seq_TextField");
        kdtMaterialEntry_seq_TextField.setVisible(true);
        kdtMaterialEntry_seq_TextField.setEditable(true);
        kdtMaterialEntry_seq_TextField.setHorizontalAlignment(2);
        kdtMaterialEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtMaterialEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtMaterialEntry_seq_TextField);
        this.kdtMaterialEntry.getColumn("seq").setEditor(kdtMaterialEntry_seq_CellEditor);
        final KDBizPromptBox kdtMaterialEntry_material_PromptBox = new KDBizPromptBox();
        kdtMaterialEntry_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtMaterialEntry_material_PromptBox.setVisible(true);
        kdtMaterialEntry_material_PromptBox.setEditable(true);
        kdtMaterialEntry_material_PromptBox.setDisplayFormat("$number$");
        kdtMaterialEntry_material_PromptBox.setEditFormat("$number$");
        kdtMaterialEntry_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtMaterialEntry_material_CellEditor = new KDTDefaultCellEditor(kdtMaterialEntry_material_PromptBox);
        this.kdtMaterialEntry.getColumn("material").setEditor(kdtMaterialEntry_material_CellEditor);
        ObjectValueRender kdtMaterialEntry_material_OVR = new ObjectValueRender();
        kdtMaterialEntry_material_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtMaterialEntry.getColumn("material").setRenderer(kdtMaterialEntry_material_OVR);
        KDTextField kdtMaterialEntry_materialNum_TextField = new KDTextField();
        kdtMaterialEntry_materialNum_TextField.setName("kdtMaterialEntry_materialNum_TextField");
        kdtMaterialEntry_materialNum_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtMaterialEntry_materialNum_CellEditor = new KDTDefaultCellEditor(kdtMaterialEntry_materialNum_TextField);
        this.kdtMaterialEntry.getColumn("materialNum").setEditor(kdtMaterialEntry_materialNum_CellEditor);
        KDTextField kdtMaterialEntry_baseUnit_TextField = new KDTextField();
        kdtMaterialEntry_baseUnit_TextField.setName("kdtMaterialEntry_baseUnit_TextField");
        kdtMaterialEntry_baseUnit_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtMaterialEntry_baseUnit_CellEditor = new KDTDefaultCellEditor(kdtMaterialEntry_baseUnit_TextField);
        this.kdtMaterialEntry.getColumn("baseUnit").setEditor(kdtMaterialEntry_baseUnit_CellEditor);
        KDTextField kdtMaterialEntry_inventoryUnit_TextField = new KDTextField();
        kdtMaterialEntry_inventoryUnit_TextField.setName("kdtMaterialEntry_inventoryUnit_TextField");
        kdtMaterialEntry_inventoryUnit_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtMaterialEntry_inventoryUnit_CellEditor = new KDTDefaultCellEditor(kdtMaterialEntry_inventoryUnit_TextField);
        this.kdtMaterialEntry.getColumn("inventoryUnit").setEditor(kdtMaterialEntry_inventoryUnit_CellEditor);
        KDTextField kdtMaterialEntry_materialtype_TextField = new KDTextField();
        kdtMaterialEntry_materialtype_TextField.setName("kdtMaterialEntry_materialtype_TextField");
        kdtMaterialEntry_materialtype_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtMaterialEntry_materialtype_CellEditor = new KDTDefaultCellEditor(kdtMaterialEntry_materialtype_TextField);
        this.kdtMaterialEntry.getColumn("materialtype").setEditor(kdtMaterialEntry_materialtype_CellEditor);
        KDFormattedTextField kdtMaterialEntry_defaultQty_TextField = new KDFormattedTextField();
        kdtMaterialEntry_defaultQty_TextField.setName("kdtMaterialEntry_defaultQty_TextField");
        kdtMaterialEntry_defaultQty_TextField.setVisible(true);
        kdtMaterialEntry_defaultQty_TextField.setEditable(true);
        kdtMaterialEntry_defaultQty_TextField.setHorizontalAlignment(2);
        kdtMaterialEntry_defaultQty_TextField.setDataType(1);
        	kdtMaterialEntry_defaultQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E24"));
        	kdtMaterialEntry_defaultQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E24"));
        kdtMaterialEntry_defaultQty_TextField.setPrecision(4);
        KDTDefaultCellEditor kdtMaterialEntry_defaultQty_CellEditor = new KDTDefaultCellEditor(kdtMaterialEntry_defaultQty_TextField);
        this.kdtMaterialEntry.getColumn("defaultQty").setEditor(kdtMaterialEntry_defaultQty_CellEditor);
        KDCheckBox kdtMaterialEntry_isCount_CheckBox = new KDCheckBox();
        kdtMaterialEntry_isCount_CheckBox.setName("kdtMaterialEntry_isCount_CheckBox");
        KDTDefaultCellEditor kdtMaterialEntry_isCount_CellEditor = new KDTDefaultCellEditor(kdtMaterialEntry_isCount_CheckBox);
        this.kdtMaterialEntry.getColumn("isCount").setEditor(kdtMaterialEntry_isCount_CellEditor);
        KDTextField kdtMaterialEntry_materialGroup_TextField = new KDTextField();
        kdtMaterialEntry_materialGroup_TextField.setName("kdtMaterialEntry_materialGroup_TextField");
        kdtMaterialEntry_materialGroup_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtMaterialEntry_materialGroup_CellEditor = new KDTDefaultCellEditor(kdtMaterialEntry_materialGroup_TextField);
        this.kdtMaterialEntry.getColumn("materialGroup").setEditor(kdtMaterialEntry_materialGroup_CellEditor);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(false);
        // countset		
        this.countset.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.szcount.szCountSet").toArray());		
        this.countset.setRequired(false);
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.szcount.szcanorcancel").toArray());		
        this.baseStatus.setRequired(false);
        // prmtcompanyOrg		
        this.prmtcompanyOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompanyOrg.setEditable(true);		
        this.prmtcompanyOrg.setDisplayFormat("$name$");		
        this.prmtcompanyOrg.setEditFormat("$number$");		
        this.prmtcompanyOrg.setCommitFormat("$number$");		
        this.prmtcompanyOrg.setRequired(true);
        // importEx
        this.importEx.setAction((IItemAction)ActionProxyFactory.getProxy(actionImportforEx, new Class[] { IItemAction.class }, getServiceContext()));		
        this.importEx.setText(resHelper.getString("importEx.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtName,txtNumber,txtDescription,txtSimpleName,prmtcompany,countset,baseStatus,prmtcompanyOrg,kdtMaterialEntry,kdtOperatorEntry,chkisManufacture,chkisIceFrish}));
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
        kDLabelContainer1.setBounds(new Rectangle(46, 43, 270, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(46, 43, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer2.setBounds(new Rectangle(371, 43, 270, 19));
        this.add(kDLabelContainer2, new KDLayout.Constraints(371, 43, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer3.setBounds(new Rectangle(47, 84, 270, 19));
        this.add(kDLabelContainer3, new KDLayout.Constraints(47, 84, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer4.setBounds(new Rectangle(370, 9, 270, 19));
        this.add(kDLabelContainer4, new KDLayout.Constraints(370, 9, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane1.setBounds(new Rectangle(34, 116, 954, 495));
        this.add(kDTabbedPane1, new KDLayout.Constraints(34, 116, 954, 495, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompany.setBounds(new Rectangle(715, 5, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(715, 5, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcountset.setBounds(new Rectangle(371, 84, 270, 19));
        this.add(contcountset, new KDLayout.Constraints(371, 84, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbaseStatus.setBounds(new Rectangle(46, 9, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(46, 9, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompanyOrg.setBounds(new Rectangle(715, 46, 270, 19));
        this.add(contcompanyOrg, new KDLayout.Constraints(715, 46, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkisManufacture.setBounds(new Rectangle(714, 74, 139, 19));
        this.add(chkisManufacture, new KDLayout.Constraints(714, 74, 139, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkisIceFrish.setBounds(new Rectangle(714, 99, 154, 19));
        this.add(chkisIceFrish, new KDLayout.Constraints(714, 99, 154, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 953, 462));        kdtOperatorEntry.setBounds(new Rectangle(7, 3, 938, 458));
        kdtOperatorEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtOperatorEntry,new com.kingdee.eas.custom.szcount.SzCountPositionSetOperatorEntryInfo(),null,false);
        kDPanel1.add(kdtOperatorEntry_detailPanel, new KDLayout.Constraints(7, 3, 938, 458, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 953, 462));        kdtMaterialEntry.setBounds(new Rectangle(7, 5, 936, 454));
        kdtMaterialEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtMaterialEntry,new com.kingdee.eas.custom.szcount.SzCountPositionSetMaterialEntryInfo(),null,false);
        kDPanel2.add(kdtMaterialEntry_detailPanel, new KDLayout.Constraints(7, 5, 936, 454, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contcountset
        contcountset.setBoundEditor(countset);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //contcompanyOrg
        contcompanyOrg.setBoundEditor(prmtcompanyOrg);

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
        this.toolBar.add(btnReset);
        this.toolBar.add(kDSeparatorCloud);
        this.toolBar.add(btnSave);
        this.toolBar.add(btnSubmit);
        this.toolBar.add(importEx);
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
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("isManufacture", boolean.class, this.chkisManufacture, "selected");
		dataBinder.registerBinding("isIceFrish", boolean.class, this.chkisIceFrish, "selected");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("OperatorEntry.seq", int.class, this.kdtOperatorEntry, "seq.text");
		dataBinder.registerBinding("OperatorEntry", com.kingdee.eas.custom.szcount.SzCountPositionSetOperatorEntryInfo.class, this.kdtOperatorEntry, "userObject");
		dataBinder.registerBinding("OperatorEntry.person", java.lang.Object.class, this.kdtOperatorEntry, "person.text");
		dataBinder.registerBinding("MaterialEntry.seq", int.class, this.kdtMaterialEntry, "seq.text");
		dataBinder.registerBinding("MaterialEntry", com.kingdee.eas.custom.szcount.SzCountPositionSetMaterialEntryInfo.class, this.kdtMaterialEntry, "userObject");
		dataBinder.registerBinding("MaterialEntry.material", java.lang.Object.class, this.kdtMaterialEntry, "material.text");
		dataBinder.registerBinding("MaterialEntry.defaultQty", java.math.BigDecimal.class, this.kdtMaterialEntry, "defaultQty.text");
		dataBinder.registerBinding("MaterialEntry.materialtype", String.class, this.kdtMaterialEntry, "materialtype.text");
		dataBinder.registerBinding("MaterialEntry.baseUnit", String.class, this.kdtMaterialEntry, "baseUnit.text");
		dataBinder.registerBinding("MaterialEntry.inventoryUnit", String.class, this.kdtMaterialEntry, "inventoryUnit.text");
		dataBinder.registerBinding("MaterialEntry.materialNum", String.class, this.kdtMaterialEntry, "materialNum.text");
		dataBinder.registerBinding("MaterialEntry.isCount", boolean.class, this.kdtMaterialEntry, "isCount.text");
		dataBinder.registerBinding("MaterialEntry.materialGroup", String.class, this.kdtMaterialEntry, "materialGroup.text");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("countset", com.kingdee.eas.custom.szcount.szCountSet.class, this.countset, "selectedItem");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.custom.szcount.szcanorcancel.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("companyOrg", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompanyOrg, "data");		
	}
	//Regiester UI State
	private void registerUIState(){
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtDescription, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtNumber, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtSimpleName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtDescription, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtNumber, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtSimpleName, ActionStateConst.ENABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtName, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtDescription, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtNumber, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtSimpleName, ActionStateConst.DISABLED);		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.szcount.app.SzCountPositionSetEditUIHandler";
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
        this.txtName.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.szcount.SzCountPositionSetInfo)ov;
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
		getValidateHelper().registerBindProperty("isManufacture", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isIceFrish", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OperatorEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OperatorEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OperatorEntry.person", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MaterialEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MaterialEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MaterialEntry.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MaterialEntry.defaultQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MaterialEntry.materialtype", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MaterialEntry.baseUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MaterialEntry.inventoryUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MaterialEntry.materialNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MaterialEntry.isCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MaterialEntry.materialGroup", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("countset", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("companyOrg", ValidateHelper.ON_SAVE);    		
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
		            this.txtNumber.setEnabled(true);
		            this.txtSimpleName.setEnabled(true);
        } else if (STATUS_EDIT.equals(this.oprtState)) {
		            this.txtName.setEnabled(true);
		            this.txtDescription.setEnabled(true);
		            this.txtNumber.setEnabled(true);
		            this.txtSimpleName.setEnabled(true);
        } else if (STATUS_VIEW.equals(this.oprtState)) {
		            this.txtName.setEnabled(false);
		            this.txtDescription.setEnabled(false);
		            this.txtNumber.setEnabled(false);
		            this.txtSimpleName.setEnabled(false);
        }
    }


    /**
     * output kdtMaterialEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtMaterialEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("material".equalsIgnoreCase(kdtMaterialEntry.getColumn(colIndex).getKey())) {
kdtMaterialEntry.getCell(rowIndex,"materialtype").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtMaterialEntry.getCell(rowIndex,"material").getValue(),"model")));

}

    if ("material".equalsIgnoreCase(kdtMaterialEntry.getColumn(colIndex).getKey())) {
kdtMaterialEntry.getCell(rowIndex,"baseUnit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtMaterialEntry.getCell(rowIndex,"material").getValue(),"baseUnit.name")));

}

    if ("material".equalsIgnoreCase(kdtMaterialEntry.getColumn(colIndex).getKey())) {
kdtMaterialEntry.getCell(rowIndex,"inventoryUnit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtMaterialEntry.getCell(rowIndex,"material").getValue(),"baseUnit.name")));

}

    if ("material".equalsIgnoreCase(kdtMaterialEntry.getColumn(colIndex).getKey())) {
kdtMaterialEntry.getCell(rowIndex,"materialNum").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtMaterialEntry.getCell(rowIndex,"material").getValue(),"number")));

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
        sic.add(new SelectorItemInfo("isManufacture"));
        sic.add(new SelectorItemInfo("isIceFrish"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("simpleName"));
        sic.add(new SelectorItemInfo("description"));
    	sic.add(new SelectorItemInfo("OperatorEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("OperatorEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("OperatorEntry.person.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("OperatorEntry.person.id"));
			sic.add(new SelectorItemInfo("OperatorEntry.person.name"));
        	sic.add(new SelectorItemInfo("OperatorEntry.person.number"));
		}
    	sic.add(new SelectorItemInfo("MaterialEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("MaterialEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("MaterialEntry.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("MaterialEntry.material.id"));
			sic.add(new SelectorItemInfo("MaterialEntry.material.name"));
        	sic.add(new SelectorItemInfo("MaterialEntry.material.number"));
		}
    	sic.add(new SelectorItemInfo("MaterialEntry.defaultQty"));
    	sic.add(new SelectorItemInfo("MaterialEntry.materialtype"));
    	sic.add(new SelectorItemInfo("MaterialEntry.baseUnit"));
    	sic.add(new SelectorItemInfo("MaterialEntry.inventoryUnit"));
    	sic.add(new SelectorItemInfo("MaterialEntry.materialNum"));
    	sic.add(new SelectorItemInfo("MaterialEntry.isCount"));
    	sic.add(new SelectorItemInfo("MaterialEntry.materialGroup"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
        sic.add(new SelectorItemInfo("countset"));
        sic.add(new SelectorItemInfo("baseStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("companyOrg.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("companyOrg.id"));
        	sic.add(new SelectorItemInfo("companyOrg.number"));
        	sic.add(new SelectorItemInfo("companyOrg.name"));
		}
        return sic;
    }        
    	

    /**
     * output actionImportforEx_actionPerformed method
     */
    public void actionImportforEx_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.szcount.SzCountPositionSetFactory.getRemoteInstance().importforEx(editData);
    }
	public RequestContext prepareActionImportforEx(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionImportforEx() {
    	return false;
    }

    /**
     * output ActionImportforEx class
     */     
    protected class ActionImportforEx extends ItemAction {     
    
        public ActionImportforEx()
        {
            this(null);
        }

        public ActionImportforEx(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionImportforEx.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionImportforEx.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionImportforEx.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractSzCountPositionSetEditUI.this, "ActionImportforEx", "actionImportforEx_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.szcount.client", "SzCountPositionSetEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.szcount.client.SzCountPositionSetEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.szcount.SzCountPositionSetFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.szcount.SzCountPositionSetInfo objectValue = new com.kingdee.eas.custom.szcount.SzCountPositionSetInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		for (int i=0,n=kdtMaterialEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtMaterialEntry.getCell(i,"material").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"产品"});
			}
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
        return kdtOperatorEntry;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("countset","0");
vo.put("baseStatus","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}