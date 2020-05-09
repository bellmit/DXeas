/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.settle.client;

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
public abstract class AbstractCarcassDisrateEditUI extends com.kingdee.eas.custom.wlhllicensemanager.client.WlhlBaseEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCarcassDisrateEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteffectDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contuneffectDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpurchaseType;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkhouseBefore;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkeffectDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkuneffectDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtDisRateEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtDisRateEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDComboBox purchaseType;
    protected com.kingdee.eas.custom.taihe.settle.CarcassDisrateInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractCarcassDisrateEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCarcassDisrateEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.conteffectDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contuneffectDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contpurchaseType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkhouseBefore = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.pkeffectDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkuneffectDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtDisRateEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.purchaseType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.conteffectDate.setName("conteffectDate");
        this.contuneffectDate.setName("contuneffectDate");
        this.contcompany.setName("contcompany");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contpurchaseType.setName("contpurchaseType");
        this.chkhouseBefore.setName("chkhouseBefore");
        this.pkeffectDate.setName("pkeffectDate");
        this.pkuneffectDate.setName("pkuneffectDate");
        this.prmtcompany.setName("prmtcompany");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kdtDisRateEntry.setName("kdtDisRateEntry");
        this.kdtEntry.setName("kdtEntry");
        this.purchaseType.setName("purchaseType");
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
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelLength(100);		
        this.kDLabelContainer3.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelAlignment(7);		
        this.kDLabelContainer4.setVisible(true);		
        this.txtNumber.setMaxLength(80);		
        this.txtName.setRequired(true);		
        this.txtSimpleName.setMaxLength(80);
        // conteffectDate		
        this.conteffectDate.setBoundLabelText(resHelper.getString("conteffectDate.boundLabelText"));		
        this.conteffectDate.setBoundLabelLength(100);		
        this.conteffectDate.setBoundLabelUnderline(true);		
        this.conteffectDate.setVisible(true);
        // contuneffectDate		
        this.contuneffectDate.setBoundLabelText(resHelper.getString("contuneffectDate.boundLabelText"));		
        this.contuneffectDate.setBoundLabelLength(100);		
        this.contuneffectDate.setBoundLabelUnderline(true);		
        this.contuneffectDate.setVisible(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // kDTabbedPane1
        // contpurchaseType		
        this.contpurchaseType.setBoundLabelText(resHelper.getString("contpurchaseType.boundLabelText"));		
        this.contpurchaseType.setBoundLabelLength(100);		
        this.contpurchaseType.setBoundLabelUnderline(true);		
        this.contpurchaseType.setVisible(true);
        // chkhouseBefore		
        this.chkhouseBefore.setText(resHelper.getString("chkhouseBefore.text"));		
        this.chkhouseBefore.setVisible(true);		
        this.chkhouseBefore.setHorizontalAlignment(2);
        // pkeffectDate		
        this.pkeffectDate.setRequired(true);
        // pkuneffectDate		
        this.pkuneffectDate.setRequired(true);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
        // kDPanel1
        // kDPanel2
        // kdtDisRateEntry
		String kdtDisRateEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"wgtType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"disRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{wgtType}</t:Cell><t:Cell>$Resource{disRate}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtDisRateEntry.setFormatXml(resHelper.translateString("kdtDisRateEntry",kdtDisRateEntryStrXML));

                this.kdtDisRateEntry.putBindContents("editData",new String[] {"seq","wgtType","disRate"});


        this.kdtDisRateEntry.checkParsed();
        KDFormattedTextField kdtDisRateEntry_seq_TextField = new KDFormattedTextField();
        kdtDisRateEntry_seq_TextField.setName("kdtDisRateEntry_seq_TextField");
        kdtDisRateEntry_seq_TextField.setVisible(true);
        kdtDisRateEntry_seq_TextField.setEditable(true);
        kdtDisRateEntry_seq_TextField.setHorizontalAlignment(2);
        kdtDisRateEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtDisRateEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtDisRateEntry_seq_TextField);
        this.kdtDisRateEntry.getColumn("seq").setEditor(kdtDisRateEntry_seq_CellEditor);
        KDComboBox kdtDisRateEntry_wgtType_ComboBox = new KDComboBox();
        kdtDisRateEntry_wgtType_ComboBox.setName("kdtDisRateEntry_wgtType_ComboBox");
        kdtDisRateEntry_wgtType_ComboBox.setVisible(true);
        kdtDisRateEntry_wgtType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.taihe.weight.CarcassType").toArray());
        KDTDefaultCellEditor kdtDisRateEntry_wgtType_CellEditor = new KDTDefaultCellEditor(kdtDisRateEntry_wgtType_ComboBox);
        this.kdtDisRateEntry.getColumn("wgtType").setEditor(kdtDisRateEntry_wgtType_CellEditor);
        KDFormattedTextField kdtDisRateEntry_disRate_TextField = new KDFormattedTextField();
        kdtDisRateEntry_disRate_TextField.setName("kdtDisRateEntry_disRate_TextField");
        kdtDisRateEntry_disRate_TextField.setVisible(true);
        kdtDisRateEntry_disRate_TextField.setEditable(true);
        kdtDisRateEntry_disRate_TextField.setHorizontalAlignment(2);
        kdtDisRateEntry_disRate_TextField.setDataType(1);
        	kdtDisRateEntry_disRate_TextField.setMinimumValue(new java.math.BigDecimal("-999.999"));
        	kdtDisRateEntry_disRate_TextField.setMaximumValue(new java.math.BigDecimal("999.999"));
        kdtDisRateEntry_disRate_TextField.setPrecision(3);
        KDTDefaultCellEditor kdtDisRateEntry_disRate_CellEditor = new KDTDefaultCellEditor(kdtDisRateEntry_disRate_TextField);
        this.kdtDisRateEntry.getColumn("disRate").setEditor(kdtDisRateEntry_disRate_CellEditor);
        // kdtEntry
		String kdtEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"avgWgtCell\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"avgWgtFloor\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"rate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{avgWgtCell}</t:Cell><t:Cell>$Resource{avgWgtFloor}</t:Cell><t:Cell>$Resource{rate}</t:Cell><t:Cell>$Resource{remark}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntry.setFormatXml(resHelper.translateString("kdtEntry",kdtEntryStrXML));

                this.kdtEntry.putBindContents("editData",new String[] {"seq","avgWgtCell","avgWgtFloor","rate","remark"});


        this.kdtEntry.checkParsed();
        KDFormattedTextField kdtEntry_seq_TextField = new KDFormattedTextField();
        kdtEntry_seq_TextField.setName("kdtEntry_seq_TextField");
        kdtEntry_seq_TextField.setVisible(true);
        kdtEntry_seq_TextField.setEditable(true);
        kdtEntry_seq_TextField.setHorizontalAlignment(2);
        kdtEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtEntry_seq_TextField);
        this.kdtEntry.getColumn("seq").setEditor(kdtEntry_seq_CellEditor);
        KDFormattedTextField kdtEntry_avgWgtCell_TextField = new KDFormattedTextField();
        kdtEntry_avgWgtCell_TextField.setName("kdtEntry_avgWgtCell_TextField");
        kdtEntry_avgWgtCell_TextField.setVisible(true);
        kdtEntry_avgWgtCell_TextField.setEditable(true);
        kdtEntry_avgWgtCell_TextField.setHorizontalAlignment(2);
        kdtEntry_avgWgtCell_TextField.setDataType(1);
        	kdtEntry_avgWgtCell_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_avgWgtCell_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_avgWgtCell_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_avgWgtCell_CellEditor = new KDTDefaultCellEditor(kdtEntry_avgWgtCell_TextField);
        this.kdtEntry.getColumn("avgWgtCell").setEditor(kdtEntry_avgWgtCell_CellEditor);
        KDFormattedTextField kdtEntry_avgWgtFloor_TextField = new KDFormattedTextField();
        kdtEntry_avgWgtFloor_TextField.setName("kdtEntry_avgWgtFloor_TextField");
        kdtEntry_avgWgtFloor_TextField.setVisible(true);
        kdtEntry_avgWgtFloor_TextField.setEditable(true);
        kdtEntry_avgWgtFloor_TextField.setHorizontalAlignment(2);
        kdtEntry_avgWgtFloor_TextField.setDataType(1);
        	kdtEntry_avgWgtFloor_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_avgWgtFloor_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_avgWgtFloor_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_avgWgtFloor_CellEditor = new KDTDefaultCellEditor(kdtEntry_avgWgtFloor_TextField);
        this.kdtEntry.getColumn("avgWgtFloor").setEditor(kdtEntry_avgWgtFloor_CellEditor);
        KDFormattedTextField kdtEntry_rate_TextField = new KDFormattedTextField();
        kdtEntry_rate_TextField.setName("kdtEntry_rate_TextField");
        kdtEntry_rate_TextField.setVisible(true);
        kdtEntry_rate_TextField.setEditable(true);
        kdtEntry_rate_TextField.setHorizontalAlignment(2);
        kdtEntry_rate_TextField.setDataType(1);
        	kdtEntry_rate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_rate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_rate_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_rate_CellEditor = new KDTDefaultCellEditor(kdtEntry_rate_TextField);
        this.kdtEntry.getColumn("rate").setEditor(kdtEntry_rate_CellEditor);
        KDTextField kdtEntry_remark_TextField = new KDTextField();
        kdtEntry_remark_TextField.setName("kdtEntry_remark_TextField");
        kdtEntry_remark_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntry_remark_CellEditor = new KDTDefaultCellEditor(kdtEntry_remark_TextField);
        this.kdtEntry.getColumn("remark").setEditor(kdtEntry_remark_CellEditor);
        // purchaseType		
        this.purchaseType.setVisible(true);		
        this.purchaseType.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.taihe.settle.SettlePurchaseTypeEnum").toArray());		
        this.purchaseType.setRequired(true);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {baseStatus,txtName,txtNumber,txtDescription,txtSimpleName,prmtcreator,pkcreateTime,prmtapprover,pkapproveTime,pkeffectDate,pkuneffectDate,prmtcompany,kdtDisRateEntry,kdtEntry,purchaseType,chkhouseBefore}));
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
        this.setBounds(new Rectangle(0, 0, 657, 476));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(22, 22, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(352, 21, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(672, 77, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(669, 108, 270, 19));
        this.add(kDLabelContainer4, null);
        contapprover.setBounds(new Rectangle(347, 393, 270, 19));
        this.add(contapprover, null);
        contapproveTime.setBounds(new Rectangle(347, 432, 270, 19));
        this.add(contapproveTime, null);
        contbaseStatus.setBounds(new Rectangle(354, 88, 270, 19));
        this.add(contbaseStatus, null);
        contcreator.setBounds(new Rectangle(17, 393, 270, 19));
        this.add(contcreator, null);
        contcreateTime.setBounds(new Rectangle(17, 432, 270, 19));
        this.add(contcreateTime, null);
        conteffectDate.setBounds(new Rectangle(22, 55, 270, 19));
        this.add(conteffectDate, null);
        contuneffectDate.setBounds(new Rectangle(351, 55, 270, 19));
        this.add(contuneffectDate, null);
        contcompany.setBounds(new Rectangle(22, 88, 270, 19));
        this.add(contcompany, null);
        kDTabbedPane1.setBounds(new Rectangle(5, 155, 623, 222));
        this.add(kDTabbedPane1, null);
        contpurchaseType.setBounds(new Rectangle(22, 124, 270, 19));
        this.add(contpurchaseType, null);
        chkhouseBefore.setBounds(new Rectangle(354, 124, 270, 19));
        this.add(chkhouseBefore, null);
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
        //conteffectDate
        conteffectDate.setBoundEditor(pkeffectDate);
        //contuneffectDate
        contuneffectDate.setBoundEditor(pkuneffectDate);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //kDPanel1
        kDPanel1.setLayout(null);        kdtDisRateEntry.setBounds(new Rectangle(-1, 1, 619, 185));
        kdtDisRateEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtDisRateEntry,new com.kingdee.eas.custom.taihe.settle.CarcassDisrateDisRateEntryInfo(),null,false);
        kDPanel1.add(kdtDisRateEntry_detailPanel, null);
        //kDPanel2
        kDPanel2.setLayout(null);        kdtEntry.setBounds(new Rectangle(4, 1, 613, 189));
        kdtEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntry,new com.kingdee.eas.custom.taihe.settle.CarcassDisrateEntryInfo(),null,false);
        kDPanel2.add(kdtEntry_detailPanel, null);
        //contpurchaseType
        contpurchaseType.setBoundEditor(purchaseType);

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
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("approver", com.kingdee.eas.base.permission.UserInfo.class, this.prmtapprover, "data");
		dataBinder.registerBinding("approveTime", java.util.Date.class, this.pkapproveTime, "value");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.custom.wlhllicensemanager.UsedStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtcreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.pkcreateTime, "value");
		dataBinder.registerBinding("houseBefore", boolean.class, this.chkhouseBefore, "selected");
		dataBinder.registerBinding("effectDate", java.util.Date.class, this.pkeffectDate, "value");
		dataBinder.registerBinding("uneffectDate", java.util.Date.class, this.pkuneffectDate, "value");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("DisRateEntry.seq", int.class, this.kdtDisRateEntry, "seq.text");
		dataBinder.registerBinding("DisRateEntry", com.kingdee.eas.custom.taihe.settle.CarcassDisrateDisRateEntryInfo.class, this.kdtDisRateEntry, "userObject");
		dataBinder.registerBinding("DisRateEntry.disRate", java.math.BigDecimal.class, this.kdtDisRateEntry, "disRate.text");
		dataBinder.registerBinding("DisRateEntry.wgtType", com.kingdee.util.enums.Enum.class, this.kdtDisRateEntry, "wgtType.text");
		dataBinder.registerBinding("Entry.seq", int.class, this.kdtEntry, "seq.text");
		dataBinder.registerBinding("Entry", com.kingdee.eas.custom.taihe.settle.CarcassDisrateEntryInfo.class, this.kdtEntry, "userObject");
		dataBinder.registerBinding("Entry.avgWgtCell", java.math.BigDecimal.class, this.kdtEntry, "avgWgtCell.text");
		dataBinder.registerBinding("Entry.avgWgtFloor", java.math.BigDecimal.class, this.kdtEntry, "avgWgtFloor.text");
		dataBinder.registerBinding("Entry.rate", java.math.BigDecimal.class, this.kdtEntry, "rate.text");
		dataBinder.registerBinding("Entry.remark", String.class, this.kdtEntry, "remark.text");
		dataBinder.registerBinding("purchaseType", com.kingdee.eas.custom.taihe.settle.SettlePurchaseTypeEnum.class, this.purchaseType, "selectedItem");		
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
	    return "com.kingdee.eas.custom.taihe.settle.app.CarcassDisrateEditUIHandler";
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
        this.baseStatus.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.taihe.settle.CarcassDisrateInfo)ov;
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
		getValidateHelper().registerBindProperty("houseBefore", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("effectDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("uneffectDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DisRateEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DisRateEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DisRateEntry.disRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DisRateEntry.wgtType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.avgWgtCell", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.avgWgtFloor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.rate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("purchaseType", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("houseBefore"));
        sic.add(new SelectorItemInfo("effectDate"));
        sic.add(new SelectorItemInfo("uneffectDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
    	sic.add(new SelectorItemInfo("DisRateEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("DisRateEntry.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("DisRateEntry.disRate"));
    	sic.add(new SelectorItemInfo("DisRateEntry.wgtType"));
    	sic.add(new SelectorItemInfo("Entry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("Entry.avgWgtCell"));
    	sic.add(new SelectorItemInfo("Entry.avgWgtFloor"));
    	sic.add(new SelectorItemInfo("Entry.rate"));
    	sic.add(new SelectorItemInfo("Entry.remark"));
        sic.add(new SelectorItemInfo("purchaseType"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.taihe.settle.client", "CarcassDisrateEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.taihe.settle.client.CarcassDisrateEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.taihe.settle.CarcassDisrateFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.taihe.settle.CarcassDisrateInfo objectValue = new com.kingdee.eas.custom.taihe.settle.CarcassDisrateInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkeffectDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"生效日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkuneffectDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"失效日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"公司"});
		}
		for (int i=0,n=kdtDisRateEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtDisRateEntry.getCell(i,"wgtType").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"胴体类型"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(purchaseType.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"收购类型"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtDisRateEntry;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("purchaseType",new Integer(1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}