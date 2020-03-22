/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.weight.client;

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
public abstract class AbstractTransportCoeEditUI extends com.kingdee.eas.custom.wlhllicensemanager.client.WlhlBaseEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractTransportCoeEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbeginDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contendDate;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcarcassPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDAOImpl;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkbeginDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkendDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcarcassPrice;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDAOImpl;
    protected com.kingdee.eas.custom.taihe.weight.TransportCoeInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractTransportCoeEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractTransportCoeEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbeginDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contendDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contcarcassPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDAOImpl = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkbeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkendDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtcarcassPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtDAOImpl = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.contcompany.setName("contcompany");
        this.contbeginDate.setName("contbeginDate");
        this.contendDate.setName("contendDate");
        this.kdtEntry.setName("kdtEntry");
        this.contcarcassPrice.setName("contcarcassPrice");
        this.contDAOImpl.setName("contDAOImpl");
        this.prmtcompany.setName("prmtcompany");
        this.pkbeginDate.setName("pkbeginDate");
        this.pkendDate.setName("pkendDate");
        this.txtcarcassPrice.setName("txtcarcassPrice");
        this.txtDAOImpl.setName("txtDAOImpl");
        // CoreUI		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelLength(100);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);		
        this.kDLabelContainer3.setVisible(false);		
        this.kDLabelContainer4.setVisible(false);		
        this.txtNumber.setMaxLength(80);		
        this.txtName.setRequired(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contbeginDate		
        this.contbeginDate.setBoundLabelText(resHelper.getString("contbeginDate.boundLabelText"));		
        this.contbeginDate.setBoundLabelLength(100);		
        this.contbeginDate.setBoundLabelUnderline(true);		
        this.contbeginDate.setVisible(true);
        // contendDate		
        this.contendDate.setBoundLabelText(resHelper.getString("contendDate.boundLabelText"));		
        this.contendDate.setBoundLabelLength(100);		
        this.contendDate.setBoundLabelUnderline(true);		
        this.contendDate.setVisible(true);
        // kdtEntry
		String kdtEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"lowCage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"topCage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"safeTon\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"lowKm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"topKm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"freightPrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"userTonKm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"useTon\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"userKm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{lowCage}</t:Cell><t:Cell>$Resource{topCage}</t:Cell><t:Cell>$Resource{safeTon}</t:Cell><t:Cell>$Resource{lowKm}</t:Cell><t:Cell>$Resource{topKm}</t:Cell><t:Cell>$Resource{freightPrice}</t:Cell><t:Cell>$Resource{userTonKm}</t:Cell><t:Cell>$Resource{useTon}</t:Cell><t:Cell>$Resource{userKm}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntry.setFormatXml(resHelper.translateString("kdtEntry",kdtEntryStrXML));

                this.kdtEntry.putBindContents("editData",new String[] {"seq","lowCage","topCage","safeTon","lowKm","topKm","freightPrice","userTonKm","useTon","userKm"});


        this.kdtEntry.checkParsed();
        KDFormattedTextField kdtEntry_seq_TextField = new KDFormattedTextField();
        kdtEntry_seq_TextField.setName("kdtEntry_seq_TextField");
        kdtEntry_seq_TextField.setVisible(true);
        kdtEntry_seq_TextField.setEditable(true);
        kdtEntry_seq_TextField.setHorizontalAlignment(2);
        kdtEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtEntry_seq_TextField);
        this.kdtEntry.getColumn("seq").setEditor(kdtEntry_seq_CellEditor);
        KDFormattedTextField kdtEntry_lowCage_TextField = new KDFormattedTextField();
        kdtEntry_lowCage_TextField.setName("kdtEntry_lowCage_TextField");
        kdtEntry_lowCage_TextField.setVisible(true);
        kdtEntry_lowCage_TextField.setEditable(true);
        kdtEntry_lowCage_TextField.setHorizontalAlignment(2);
        kdtEntry_lowCage_TextField.setDataType(1);
        	kdtEntry_lowCage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_lowCage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_lowCage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_lowCage_CellEditor = new KDTDefaultCellEditor(kdtEntry_lowCage_TextField);
        this.kdtEntry.getColumn("lowCage").setEditor(kdtEntry_lowCage_CellEditor);
        KDFormattedTextField kdtEntry_topCage_TextField = new KDFormattedTextField();
        kdtEntry_topCage_TextField.setName("kdtEntry_topCage_TextField");
        kdtEntry_topCage_TextField.setVisible(true);
        kdtEntry_topCage_TextField.setEditable(true);
        kdtEntry_topCage_TextField.setHorizontalAlignment(2);
        kdtEntry_topCage_TextField.setDataType(1);
        	kdtEntry_topCage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_topCage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_topCage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_topCage_CellEditor = new KDTDefaultCellEditor(kdtEntry_topCage_TextField);
        this.kdtEntry.getColumn("topCage").setEditor(kdtEntry_topCage_CellEditor);
        KDFormattedTextField kdtEntry_safeTon_TextField = new KDFormattedTextField();
        kdtEntry_safeTon_TextField.setName("kdtEntry_safeTon_TextField");
        kdtEntry_safeTon_TextField.setVisible(true);
        kdtEntry_safeTon_TextField.setEditable(true);
        kdtEntry_safeTon_TextField.setHorizontalAlignment(2);
        kdtEntry_safeTon_TextField.setDataType(1);
        	kdtEntry_safeTon_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_safeTon_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_safeTon_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_safeTon_CellEditor = new KDTDefaultCellEditor(kdtEntry_safeTon_TextField);
        this.kdtEntry.getColumn("safeTon").setEditor(kdtEntry_safeTon_CellEditor);
        KDFormattedTextField kdtEntry_lowKm_TextField = new KDFormattedTextField();
        kdtEntry_lowKm_TextField.setName("kdtEntry_lowKm_TextField");
        kdtEntry_lowKm_TextField.setVisible(true);
        kdtEntry_lowKm_TextField.setEditable(true);
        kdtEntry_lowKm_TextField.setHorizontalAlignment(2);
        kdtEntry_lowKm_TextField.setDataType(1);
        	kdtEntry_lowKm_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_lowKm_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_lowKm_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_lowKm_CellEditor = new KDTDefaultCellEditor(kdtEntry_lowKm_TextField);
        this.kdtEntry.getColumn("lowKm").setEditor(kdtEntry_lowKm_CellEditor);
        KDFormattedTextField kdtEntry_topKm_TextField = new KDFormattedTextField();
        kdtEntry_topKm_TextField.setName("kdtEntry_topKm_TextField");
        kdtEntry_topKm_TextField.setVisible(true);
        kdtEntry_topKm_TextField.setEditable(true);
        kdtEntry_topKm_TextField.setHorizontalAlignment(2);
        kdtEntry_topKm_TextField.setDataType(1);
        	kdtEntry_topKm_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_topKm_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_topKm_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_topKm_CellEditor = new KDTDefaultCellEditor(kdtEntry_topKm_TextField);
        this.kdtEntry.getColumn("topKm").setEditor(kdtEntry_topKm_CellEditor);
        KDFormattedTextField kdtEntry_freightPrice_TextField = new KDFormattedTextField();
        kdtEntry_freightPrice_TextField.setName("kdtEntry_freightPrice_TextField");
        kdtEntry_freightPrice_TextField.setVisible(true);
        kdtEntry_freightPrice_TextField.setEditable(true);
        kdtEntry_freightPrice_TextField.setHorizontalAlignment(2);
        kdtEntry_freightPrice_TextField.setDataType(1);
        	kdtEntry_freightPrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_freightPrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_freightPrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_freightPrice_CellEditor = new KDTDefaultCellEditor(kdtEntry_freightPrice_TextField);
        this.kdtEntry.getColumn("freightPrice").setEditor(kdtEntry_freightPrice_CellEditor);
        KDCheckBox kdtEntry_userTonKm_CheckBox = new KDCheckBox();
        kdtEntry_userTonKm_CheckBox.setName("kdtEntry_userTonKm_CheckBox");
        KDTDefaultCellEditor kdtEntry_userTonKm_CellEditor = new KDTDefaultCellEditor(kdtEntry_userTonKm_CheckBox);
        this.kdtEntry.getColumn("userTonKm").setEditor(kdtEntry_userTonKm_CellEditor);
        KDCheckBox kdtEntry_useTon_CheckBox = new KDCheckBox();
        kdtEntry_useTon_CheckBox.setName("kdtEntry_useTon_CheckBox");
        KDTDefaultCellEditor kdtEntry_useTon_CellEditor = new KDTDefaultCellEditor(kdtEntry_useTon_CheckBox);
        this.kdtEntry.getColumn("useTon").setEditor(kdtEntry_useTon_CellEditor);
        KDCheckBox kdtEntry_userKm_CheckBox = new KDCheckBox();
        kdtEntry_userKm_CheckBox.setName("kdtEntry_userKm_CheckBox");
        KDTDefaultCellEditor kdtEntry_userKm_CellEditor = new KDTDefaultCellEditor(kdtEntry_userKm_CheckBox);
        this.kdtEntry.getColumn("userKm").setEditor(kdtEntry_userKm_CellEditor);
        // contcarcassPrice		
        this.contcarcassPrice.setBoundLabelText(resHelper.getString("contcarcassPrice.boundLabelText"));		
        this.contcarcassPrice.setBoundLabelLength(120);		
        this.contcarcassPrice.setBoundLabelUnderline(true);		
        this.contcarcassPrice.setVisible(true);
        // contDAOImpl		
        this.contDAOImpl.setBoundLabelText(resHelper.getString("contDAOImpl.boundLabelText"));		
        this.contDAOImpl.setBoundLabelLength(100);		
        this.contDAOImpl.setBoundLabelUnderline(true);		
        this.contDAOImpl.setVisible(true);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
        // pkbeginDate		
        this.pkbeginDate.setRequired(false);
        // pkendDate		
        this.pkendDate.setRequired(true);
        // txtcarcassPrice		
        this.txtcarcassPrice.setVisible(true);		
        this.txtcarcassPrice.setHorizontalAlignment(2);		
        this.txtcarcassPrice.setDataType(1);		
        this.txtcarcassPrice.setSupportedEmpty(true);		
        this.txtcarcassPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcarcassPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcarcassPrice.setPrecision(4);		
        this.txtcarcassPrice.setRequired(false);
        // txtDAOImpl		
        this.txtDAOImpl.setVisible(true);		
        this.txtDAOImpl.setHorizontalAlignment(2);		
        this.txtDAOImpl.setMaxLength(200);		
        this.txtDAOImpl.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtcompany,pkbeginDate,pkendDate,txtNumber,txtName,kdtEntry,txtcarcassPrice,txtDAOImpl}));
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
        this.setBounds(new Rectangle(0, 0, 930, 450));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 930, 450));
        kDLabelContainer1.setBounds(new Rectangle(14, 19, 270, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(14, 19, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer2.setBounds(new Rectangle(324, 19, 270, 19));
        this.add(kDLabelContainer2, new KDLayout.Constraints(324, 19, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer3.setBounds(new Rectangle(894, 222, 270, 19));
        this.add(kDLabelContainer3, new KDLayout.Constraints(894, 222, 270, 19, 0));
        kDLabelContainer4.setBounds(new Rectangle(886, 265, 270, 19));
        this.add(kDLabelContainer4, new KDLayout.Constraints(886, 265, 270, 19, 0));
        contapprover.setBounds(new Rectangle(324, 381, 270, 19));
        this.add(contapprover, new KDLayout.Constraints(324, 381, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contapproveTime.setBounds(new Rectangle(635, 381, 270, 19));
        this.add(contapproveTime, new KDLayout.Constraints(635, 381, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbaseStatus.setBounds(new Rectangle(635, 19, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(635, 19, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcreator.setBounds(new Rectangle(14, 414, 270, 19));
        this.add(contcreator, new KDLayout.Constraints(14, 414, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcreateTime.setBounds(new Rectangle(14, 381, 270, 19));
        this.add(contcreateTime, new KDLayout.Constraints(14, 381, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompany.setBounds(new Rectangle(635, 50, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(635, 50, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbeginDate.setBounds(new Rectangle(14, 50, 270, 19));
        this.add(contbeginDate, new KDLayout.Constraints(14, 50, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contendDate.setBounds(new Rectangle(324, 50, 270, 19));
        this.add(contendDate, new KDLayout.Constraints(324, 50, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntry.setBounds(new Rectangle(7, 114, 907, 257));
        kdtEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntry,new com.kingdee.eas.custom.taihe.weight.TransportCoeEntryInfo(),null,false);
        this.add(kdtEntry_detailPanel, new KDLayout.Constraints(7, 114, 907, 257, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contcarcassPrice.setBounds(new Rectangle(14, 82, 270, 19));
        this.add(contcarcassPrice, new KDLayout.Constraints(14, 82, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDAOImpl.setBounds(new Rectangle(324, 82, 583, 19));
        this.add(contDAOImpl, new KDLayout.Constraints(324, 82, 583, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contapprover
        contapprover.setBoundEditor(prmtapprover);
        //contapproveTime
        contapproveTime.setBoundEditor(pkapproveTime);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //contcreator
        contcreator.setBoundEditor(prmtcreator);
        //contcreateTime
        contcreateTime.setBoundEditor(pkcreateTime);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contbeginDate
        contbeginDate.setBoundEditor(pkbeginDate);
        //contendDate
        contendDate.setBoundEditor(pkendDate);
        //contcarcassPrice
        contcarcassPrice.setBoundEditor(txtcarcassPrice);
        //contDAOImpl
        contDAOImpl.setBoundEditor(txtDAOImpl);

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
        menuBiz.add(mBtnApprove);
        menuBiz.add(mBtnUnApprove);
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
        this.toolBar.add(tBtnApprove);
        this.toolBar.add(tBtnUnApprove);
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
        this.toolBar.add(btnAttachment);
        this.toolBar.add(separatorFW1);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("approver", com.kingdee.eas.base.permission.UserInfo.class, this.prmtapprover, "data");
		dataBinder.registerBinding("approveTime", java.util.Date.class, this.pkapproveTime, "value");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.custom.wlhllicensemanager.UsedStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtcreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.pkcreateTime, "value");
		dataBinder.registerBinding("Entry.seq", int.class, this.kdtEntry, "seq.text");
		dataBinder.registerBinding("Entry", com.kingdee.eas.custom.taihe.weight.TransportCoeEntryInfo.class, this.kdtEntry, "userObject");
		dataBinder.registerBinding("Entry.lowKm", java.math.BigDecimal.class, this.kdtEntry, "lowKm.text");
		dataBinder.registerBinding("Entry.topKm", java.math.BigDecimal.class, this.kdtEntry, "topKm.text");
		dataBinder.registerBinding("Entry.safeTon", java.math.BigDecimal.class, this.kdtEntry, "safeTon.text");
		dataBinder.registerBinding("Entry.lowCage", java.math.BigDecimal.class, this.kdtEntry, "lowCage.text");
		dataBinder.registerBinding("Entry.topCage", java.math.BigDecimal.class, this.kdtEntry, "topCage.text");
		dataBinder.registerBinding("Entry.freightPrice", java.math.BigDecimal.class, this.kdtEntry, "freightPrice.text");
		dataBinder.registerBinding("Entry.useTon", boolean.class, this.kdtEntry, "useTon.text");
		dataBinder.registerBinding("Entry.userTonKm", boolean.class, this.kdtEntry, "userTonKm.text");
		dataBinder.registerBinding("Entry.userKm", boolean.class, this.kdtEntry, "userKm.text");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("beginDate", java.util.Date.class, this.pkbeginDate, "value");
		dataBinder.registerBinding("endDate", java.util.Date.class, this.pkendDate, "value");
		dataBinder.registerBinding("carcassPrice", java.math.BigDecimal.class, this.txtcarcassPrice, "value");
		dataBinder.registerBinding("DAOImpl", String.class, this.txtDAOImpl, "text");		
	}
	//Regiester UI State
	private void registerUIState(){
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtNumber, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtNumber, ActionStateConst.ENABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtName, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtNumber, ActionStateConst.DISABLED);		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.taihe.weight.app.TransportCoeEditUIHandler";
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
        this.prmtcompany.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.taihe.weight.TransportCoeInfo)ov;
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
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("approver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("approveTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.lowKm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.topKm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.safeTon", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.lowCage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.topCage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.freightPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.useTon", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.userTonKm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.userKm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("beginDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("endDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("carcassPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DAOImpl", ValidateHelper.ON_SAVE);    		
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
        if (STATUS_ADDNEW.equals(this.oprtState)) {
		            this.txtName.setEnabled(true);
		            this.txtNumber.setEnabled(true);
        } else if (STATUS_EDIT.equals(this.oprtState)) {
		            this.txtName.setEnabled(true);
		            this.txtNumber.setEnabled(true);
        } else if (STATUS_VIEW.equals(this.oprtState)) {
		            this.txtName.setEnabled(false);
		            this.txtNumber.setEnabled(false);
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("approver.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("approver.id"));
        	sic.add(new SelectorItemInfo("approver.number"));
        	sic.add(new SelectorItemInfo("approver.name"));
		}
        sic.add(new SelectorItemInfo("approveTime"));
        sic.add(new SelectorItemInfo("baseStatus"));
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
    	sic.add(new SelectorItemInfo("Entry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("Entry.lowKm"));
    	sic.add(new SelectorItemInfo("Entry.topKm"));
    	sic.add(new SelectorItemInfo("Entry.safeTon"));
    	sic.add(new SelectorItemInfo("Entry.lowCage"));
    	sic.add(new SelectorItemInfo("Entry.topCage"));
    	sic.add(new SelectorItemInfo("Entry.freightPrice"));
    	sic.add(new SelectorItemInfo("Entry.useTon"));
    	sic.add(new SelectorItemInfo("Entry.userTonKm"));
    	sic.add(new SelectorItemInfo("Entry.userKm"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
        sic.add(new SelectorItemInfo("beginDate"));
        sic.add(new SelectorItemInfo("endDate"));
        sic.add(new SelectorItemInfo("carcassPrice"));
        sic.add(new SelectorItemInfo("DAOImpl"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.taihe.weight.client", "TransportCoeEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.taihe.weight.client.TransportCoeEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.taihe.weight.TransportCoeFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.taihe.weight.TransportCoeInfo objectValue = new com.kingdee.eas.custom.taihe.weight.TransportCoeInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"公司"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkendDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"结束日期"});
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
				vo.put("carcassPrice",new java.math.BigDecimal(9));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}