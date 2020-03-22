/**
 * output package name
 */
package com.kingdee.eas.farm.food.stocount.client;

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
public abstract class AbstractCountPositionSetEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCountPositionSetEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcountset;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
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
    protected com.kingdee.eas.farm.food.stocount.CountPositionSetInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractCountPositionSetEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCountPositionSetEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcountset = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
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
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contcompany.setName("contcompany");
        this.contcountset.setName("contcountset");
        this.contbaseStatus.setName("contbaseStatus");
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
		String kdtMaterialEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"baseUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"inventoryUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"materialtype\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"defaultQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{baseUnit}</t:Cell><t:Cell>$Resource{inventoryUnit}</t:Cell><t:Cell>$Resource{materialtype}</t:Cell><t:Cell>$Resource{defaultQty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtMaterialEntry.putBindContents("editData",new String[] {"seq","material","baseUnit","inventoryUnit","materialtype","defaultQty"});


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
        final KDBizPromptBox kdtMaterialEntry_baseUnit_PromptBox = new KDBizPromptBox();
        kdtMaterialEntry_baseUnit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtMaterialEntry_baseUnit_PromptBox.setVisible(true);
        kdtMaterialEntry_baseUnit_PromptBox.setEditable(true);
        kdtMaterialEntry_baseUnit_PromptBox.setDisplayFormat("$number$");
        kdtMaterialEntry_baseUnit_PromptBox.setEditFormat("$number$");
        kdtMaterialEntry_baseUnit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtMaterialEntry_baseUnit_CellEditor = new KDTDefaultCellEditor(kdtMaterialEntry_baseUnit_PromptBox);
        this.kdtMaterialEntry.getColumn("baseUnit").setEditor(kdtMaterialEntry_baseUnit_CellEditor);
        ObjectValueRender kdtMaterialEntry_baseUnit_OVR = new ObjectValueRender();
        kdtMaterialEntry_baseUnit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtMaterialEntry.getColumn("baseUnit").setRenderer(kdtMaterialEntry_baseUnit_OVR);
        final KDBizPromptBox kdtMaterialEntry_inventoryUnit_PromptBox = new KDBizPromptBox();
        kdtMaterialEntry_inventoryUnit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtMaterialEntry_inventoryUnit_PromptBox.setVisible(true);
        kdtMaterialEntry_inventoryUnit_PromptBox.setEditable(true);
        kdtMaterialEntry_inventoryUnit_PromptBox.setDisplayFormat("$number$");
        kdtMaterialEntry_inventoryUnit_PromptBox.setEditFormat("$number$");
        kdtMaterialEntry_inventoryUnit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtMaterialEntry_inventoryUnit_CellEditor = new KDTDefaultCellEditor(kdtMaterialEntry_inventoryUnit_PromptBox);
        this.kdtMaterialEntry.getColumn("inventoryUnit").setEditor(kdtMaterialEntry_inventoryUnit_CellEditor);
        ObjectValueRender kdtMaterialEntry_inventoryUnit_OVR = new ObjectValueRender();
        kdtMaterialEntry_inventoryUnit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtMaterialEntry.getColumn("inventoryUnit").setRenderer(kdtMaterialEntry_inventoryUnit_OVR);
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
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(false);
        // countset		
        this.countset.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.food.stocount.CountSet").toArray());		
        this.countset.setRequired(false);
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.food.stocount.canorcancel").toArray());		
        this.baseStatus.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtName,txtNumber,txtDescription,txtSimpleName,prmtcompany,countset,baseStatus,kdtMaterialEntry,kdtOperatorEntry}));
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
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(46, 41, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(371, 41, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(724, 40, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(47, 78, 270, 19));
        this.add(kDLabelContainer4, null);
        kDTabbedPane1.setBounds(new Rectangle(34, 116, 954, 495));
        this.add(kDTabbedPane1, null);
        contcompany.setBounds(new Rectangle(371, 77, 270, 19));
        this.add(contcompany, null);
        contcountset.setBounds(new Rectangle(723, 76, 270, 19));
        this.add(contcountset, null);
        contbaseStatus.setBounds(new Rectangle(725, 14, 270, 19));
        this.add(contbaseStatus, null);
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
        kDPanel1.setLayout(null);        kdtOperatorEntry.setBounds(new Rectangle(7, 3, 938, 458));
        kdtOperatorEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtOperatorEntry,new com.kingdee.eas.farm.food.stocount.CountPositionSetOperatorEntryInfo(),null,false);
        kDPanel1.add(kdtOperatorEntry_detailPanel, null);
        //kDPanel2
        kDPanel2.setLayout(null);        kdtMaterialEntry.setBounds(new Rectangle(7, 5, 936, 454));
        kdtMaterialEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtMaterialEntry,new com.kingdee.eas.farm.food.stocount.CountPositionSetMaterialEntryInfo(),null,false);
        kDPanel2.add(kdtMaterialEntry_detailPanel, null);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contcountset
        contcountset.setBoundEditor(countset);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);

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
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("OperatorEntry.seq", int.class, this.kdtOperatorEntry, "seq.text");
		dataBinder.registerBinding("OperatorEntry", com.kingdee.eas.farm.food.stocount.CountPositionSetOperatorEntryInfo.class, this.kdtOperatorEntry, "userObject");
		dataBinder.registerBinding("OperatorEntry.person", java.lang.Object.class, this.kdtOperatorEntry, "person.text");
		dataBinder.registerBinding("MaterialEntry.seq", int.class, this.kdtMaterialEntry, "seq.text");
		dataBinder.registerBinding("MaterialEntry", com.kingdee.eas.farm.food.stocount.CountPositionSetMaterialEntryInfo.class, this.kdtMaterialEntry, "userObject");
		dataBinder.registerBinding("MaterialEntry.material", java.lang.Object.class, this.kdtMaterialEntry, "material.text");
		dataBinder.registerBinding("MaterialEntry.baseUnit", java.lang.Object.class, this.kdtMaterialEntry, "baseUnit.text");
		dataBinder.registerBinding("MaterialEntry.defaultQty", java.math.BigDecimal.class, this.kdtMaterialEntry, "defaultQty.text");
		dataBinder.registerBinding("MaterialEntry.materialtype", String.class, this.kdtMaterialEntry, "materialtype.text");
		dataBinder.registerBinding("MaterialEntry.inventoryUnit", java.lang.Object.class, this.kdtMaterialEntry, "inventoryUnit.text");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("countset", com.kingdee.eas.farm.food.stocount.CountSet.class, this.countset, "selectedItem");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.farm.food.stocount.canorcancel.class, this.baseStatus, "selectedItem");		
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
	    return "com.kingdee.eas.farm.food.stocount.app.CountPositionSetEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.food.stocount.CountPositionSetInfo)ov;
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
		getValidateHelper().registerBindProperty("MaterialEntry.baseUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MaterialEntry.defaultQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MaterialEntry.materialtype", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MaterialEntry.inventoryUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("countset", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    		
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("MaterialEntry.baseUnit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("MaterialEntry.baseUnit.id"));
			sic.add(new SelectorItemInfo("MaterialEntry.baseUnit.name"));
        	sic.add(new SelectorItemInfo("MaterialEntry.baseUnit.number"));
		}
    	sic.add(new SelectorItemInfo("MaterialEntry.defaultQty"));
    	sic.add(new SelectorItemInfo("MaterialEntry.materialtype"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("MaterialEntry.inventoryUnit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("MaterialEntry.inventoryUnit.id"));
			sic.add(new SelectorItemInfo("MaterialEntry.inventoryUnit.name"));
        	sic.add(new SelectorItemInfo("MaterialEntry.inventoryUnit.number"));
		}
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
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.food.stocount.client", "CountPositionSetEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.food.stocount.client.CountPositionSetEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.food.stocount.CountPositionSetFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.food.stocount.CountPositionSetInfo objectValue = new com.kingdee.eas.farm.food.stocount.CountPositionSetInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
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