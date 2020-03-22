/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata.client;

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
public abstract class AbstractCarviousFeedComMeatEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCarviousFeedComMeatEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contFICompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedData;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contname;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbeginDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contendDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtFICompany;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbreedData;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtname;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkbeginDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkendDate;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.farm.carnivorous.basedata.CarviousFeedComMeatInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractCarviousFeedComMeatEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCarviousFeedComMeatEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        //actionAudit
        this.actionAudit = new ActionAudit(this);
        getActionManager().registerAction("actionAudit", actionAudit);
        this.actionAudit.setExtendProperty("canForewarn", "true");
        this.actionAudit.setExtendProperty("userDefined", "true");
        this.actionAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionUnAudit
        this.actionUnAudit = new ActionUnAudit(this);
        getActionManager().registerAction("actionUnAudit", actionUnAudit);
        this.actionUnAudit.setExtendProperty("canForewarn", "true");
        this.actionUnAudit.setExtendProperty("userDefined", "true");
        this.actionUnAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contFICompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbreedData = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contname = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbeginDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contendDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.prmtFICompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbreedData = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtname = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkbeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkendDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contFICompany.setName("contFICompany");
        this.contbreedData.setName("contbreedData");
        this.contbaseStatus.setName("contbaseStatus");
        this.kdtEntrys.setName("kdtEntrys");
        this.contname.setName("contname");
        this.contbeginDate.setName("contbeginDate");
        this.contendDate.setName("contendDate");
        this.txtNumber.setName("txtNumber");
        this.txtDescription.setName("txtDescription");
        this.prmtFICompany.setName("prmtFICompany");
        this.prmtbreedData.setName("prmtbreedData");
        this.baseStatus.setName("baseStatus");
        this.txtname.setName("txtname");
        this.pkbeginDate.setName("pkbeginDate");
        this.pkendDate.setName("pkendDate");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
        // CoreUI		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);		
        this.kDLabelContainer1.setForeground(new java.awt.Color(0,0,0));
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelAlignment(7);		
        this.kDLabelContainer4.setVisible(true);
        // contFICompany		
        this.contFICompany.setBoundLabelText(resHelper.getString("contFICompany.boundLabelText"));		
        this.contFICompany.setBoundLabelLength(100);		
        this.contFICompany.setBoundLabelUnderline(true);		
        this.contFICompany.setVisible(true);
        // contbreedData		
        this.contbreedData.setBoundLabelText(resHelper.getString("contbreedData.boundLabelText"));		
        this.contbreedData.setBoundLabelLength(100);		
        this.contbreedData.setBoundLabelUnderline(true);		
        this.contbreedData.setVisible(true);		
        this.contbreedData.setForeground(new java.awt.Color(0,0,0));
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);		
        this.contbaseStatus.setForeground(new java.awt.Color(0,0,0));
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"minSymbol\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"minValue\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"2\" t:styleID=\"sCol2\" /><t:Column t:key=\"maxSymbol\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"3\" /><t:Column t:key=\"maxValue\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"price\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"oneDrugAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{minSymbol}</t:Cell><t:Cell>$Resource{minValue}</t:Cell><t:Cell>$Resource{maxSymbol}</t:Cell><t:Cell>$Resource{maxValue}</t:Cell><t:Cell>$Resource{price}</t:Cell><t:Cell>$Resource{oneDrugAmt}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));

                this.kdtEntrys.putBindContents("editData",new String[] {"seq","minSymbol","minValue","maxSymbol","maxValue","price","oneDrugAmt"});


        this.kdtEntrys.checkParsed();
        KDComboBox kdtEntrys_minSymbol_ComboBox = new KDComboBox();
        kdtEntrys_minSymbol_ComboBox.setName("kdtEntrys_minSymbol_ComboBox");
        kdtEntrys_minSymbol_ComboBox.setVisible(true);
        kdtEntrys_minSymbol_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.basedata.highSymbol").toArray());
        KDTDefaultCellEditor kdtEntrys_minSymbol_CellEditor = new KDTDefaultCellEditor(kdtEntrys_minSymbol_ComboBox);
        this.kdtEntrys.getColumn("minSymbol").setEditor(kdtEntrys_minSymbol_CellEditor);
        KDFormattedTextField kdtEntrys_minValue_TextField = new KDFormattedTextField();
        kdtEntrys_minValue_TextField.setName("kdtEntrys_minValue_TextField");
        kdtEntrys_minValue_TextField.setVisible(true);
        kdtEntrys_minValue_TextField.setEditable(true);
        kdtEntrys_minValue_TextField.setHorizontalAlignment(2);
        kdtEntrys_minValue_TextField.setDataType(1);
        	kdtEntrys_minValue_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_minValue_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_minValue_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_minValue_CellEditor = new KDTDefaultCellEditor(kdtEntrys_minValue_TextField);
        this.kdtEntrys.getColumn("minValue").setEditor(kdtEntrys_minValue_CellEditor);
        KDComboBox kdtEntrys_maxSymbol_ComboBox = new KDComboBox();
        kdtEntrys_maxSymbol_ComboBox.setName("kdtEntrys_maxSymbol_ComboBox");
        kdtEntrys_maxSymbol_ComboBox.setVisible(true);
        kdtEntrys_maxSymbol_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.basedata.LessSymbol").toArray());
        KDTDefaultCellEditor kdtEntrys_maxSymbol_CellEditor = new KDTDefaultCellEditor(kdtEntrys_maxSymbol_ComboBox);
        this.kdtEntrys.getColumn("maxSymbol").setEditor(kdtEntrys_maxSymbol_CellEditor);
        KDFormattedTextField kdtEntrys_maxValue_TextField = new KDFormattedTextField();
        kdtEntrys_maxValue_TextField.setName("kdtEntrys_maxValue_TextField");
        kdtEntrys_maxValue_TextField.setVisible(true);
        kdtEntrys_maxValue_TextField.setEditable(true);
        kdtEntrys_maxValue_TextField.setHorizontalAlignment(2);
        kdtEntrys_maxValue_TextField.setDataType(1);
        	kdtEntrys_maxValue_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_maxValue_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_maxValue_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_maxValue_CellEditor = new KDTDefaultCellEditor(kdtEntrys_maxValue_TextField);
        this.kdtEntrys.getColumn("maxValue").setEditor(kdtEntrys_maxValue_CellEditor);
        KDFormattedTextField kdtEntrys_price_TextField = new KDFormattedTextField();
        kdtEntrys_price_TextField.setName("kdtEntrys_price_TextField");
        kdtEntrys_price_TextField.setVisible(true);
        kdtEntrys_price_TextField.setEditable(true);
        kdtEntrys_price_TextField.setHorizontalAlignment(2);
        kdtEntrys_price_TextField.setDataType(1);
        	kdtEntrys_price_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_price_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_price_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_price_CellEditor = new KDTDefaultCellEditor(kdtEntrys_price_TextField);
        this.kdtEntrys.getColumn("price").setEditor(kdtEntrys_price_CellEditor);
        KDFormattedTextField kdtEntrys_oneDrugAmt_TextField = new KDFormattedTextField();
        kdtEntrys_oneDrugAmt_TextField.setName("kdtEntrys_oneDrugAmt_TextField");
        kdtEntrys_oneDrugAmt_TextField.setVisible(true);
        kdtEntrys_oneDrugAmt_TextField.setEditable(true);
        kdtEntrys_oneDrugAmt_TextField.setHorizontalAlignment(2);
        kdtEntrys_oneDrugAmt_TextField.setDataType(1);
        	kdtEntrys_oneDrugAmt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_oneDrugAmt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_oneDrugAmt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_oneDrugAmt_CellEditor = new KDTDefaultCellEditor(kdtEntrys_oneDrugAmt_TextField);
        this.kdtEntrys.getColumn("oneDrugAmt").setEditor(kdtEntrys_oneDrugAmt_CellEditor);
        // contname		
        this.contname.setBoundLabelText(resHelper.getString("contname.boundLabelText"));		
        this.contname.setBoundLabelLength(100);		
        this.contname.setBoundLabelUnderline(true);		
        this.contname.setVisible(true);
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
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setRequired(true);
        // txtDescription
        // prmtFICompany		
        this.prmtFICompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery4AsstAcct");		
        this.prmtFICompany.setVisible(true);		
        this.prmtFICompany.setEditable(true);		
        this.prmtFICompany.setDisplayFormat("$name$");		
        this.prmtFICompany.setEditFormat("$number$");		
        this.prmtFICompany.setCommitFormat("$number$");		
        this.prmtFICompany.setRequired(true);
        		setOrgF7(prmtFICompany,com.kingdee.eas.basedata.org.OrgType.getEnum("Company"));
					
        // prmtbreedData		
        this.prmtbreedData.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.BreedDataQuery");		
        this.prmtbreedData.setVisible(true);		
        this.prmtbreedData.setEditable(true);		
        this.prmtbreedData.setDisplayFormat("$name$");		
        this.prmtbreedData.setEditFormat("$number$");		
        this.prmtbreedData.setCommitFormat("$number$");		
        this.prmtbreedData.setRequired(true);
        		prmtbreedData.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI prmtbreedData_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtbreedData_F7ListUI == null) {
					try {
						prmtbreedData_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtbreedData_F7ListUI));
					prmtbreedData_F7ListUI.setF7Use(true,ctx);
					prmtbreedData.setSelector(prmtbreedData_F7ListUI);
				}
			}
		});
					
        // baseStatus		
        this.baseStatus.setVisible(true);		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(false);		
        this.baseStatus.setEnabled(false);
        // txtname		
        this.txtname.setVisible(true);		
        this.txtname.setHorizontalAlignment(2);		
        this.txtname.setMaxLength(255);		
        this.txtname.setRequired(false);
        // pkbeginDate		
        this.pkbeginDate.setVisible(true);		
        this.pkbeginDate.setRequired(false);
        // pkendDate		
        this.pkendDate.setVisible(true);		
        this.pkendDate.setRequired(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtbreedData,baseStatus,kdtEntrys,txtDescription,txtNumber,prmtFICompany,pkbeginDate,pkendDate}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 987));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1013, 987));
        kDLabelContainer1.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(10, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer4.setBounds(new Rectangle(341, 58, 270, 19));
        this.add(kDLabelContainer4, new KDLayout.Constraints(341, 58, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contFICompany.setBounds(new Rectangle(672, 10, 270, 19));
        this.add(contFICompany, new KDLayout.Constraints(672, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbreedData.setBounds(new Rectangle(10, 34, 270, 19));
        this.add(contbreedData, new KDLayout.Constraints(10, 34, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbaseStatus.setBounds(new Rectangle(10, 58, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(10, 58, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(10, 82, 942, 892));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.carnivorous.basedata.CarviousFeedComMeatEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(10, 82, 942, 892, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("minSymbol",">");
vo.put("maxSymbol","<");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        contname.setBounds(new Rectangle(341, 10, 270, 19));
        this.add(contname, new KDLayout.Constraints(341, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbeginDate.setBounds(new Rectangle(341, 34, 270, 19));
        this.add(contbeginDate, new KDLayout.Constraints(341, 34, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contendDate.setBounds(new Rectangle(672, 34, 270, 19));
        this.add(contendDate, new KDLayout.Constraints(672, 34, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contFICompany
        contFICompany.setBoundEditor(prmtFICompany);
        //contbreedData
        contbreedData.setBoundEditor(prmtbreedData);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //contname
        contname.setBoundEditor(txtname);
        //contbeginDate
        contbeginDate.setBoundEditor(pkbeginDate);
        //contendDate
        contendDate.setBoundEditor(pkendDate);

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
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("Entrys.seq", int.class, this.kdtEntrys, "seq.text");
		dataBinder.registerBinding("Entrys", com.kingdee.eas.farm.carnivorous.basedata.CarviousFeedComMeatEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("Entrys.minSymbol", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "minSymbol.text");
		dataBinder.registerBinding("Entrys.maxSymbol", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "maxSymbol.text");
		dataBinder.registerBinding("Entrys.minValue", java.math.BigDecimal.class, this.kdtEntrys, "minValue.text");
		dataBinder.registerBinding("Entrys.maxValue", java.math.BigDecimal.class, this.kdtEntrys, "maxValue.text");
		dataBinder.registerBinding("Entrys.price", java.math.BigDecimal.class, this.kdtEntrys, "price.text");
		dataBinder.registerBinding("Entrys.oneDrugAmt", java.math.BigDecimal.class, this.kdtEntrys, "oneDrugAmt.text");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("FICompany", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtFICompany, "data");
		dataBinder.registerBinding("breedData", com.kingdee.eas.farm.stocking.basedata.BreedDataInfo.class, this.prmtbreedData, "data");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("name", String.class, this.txtname, "text");
		dataBinder.registerBinding("beginDate", java.util.Date.class, this.pkbeginDate, "value");
		dataBinder.registerBinding("endDate", java.util.Date.class, this.pkendDate, "value");		
	}
	//Regiester UI State
	private void registerUIState(){
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtDescription, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtNumber, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtDescription, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtNumber, ActionStateConst.ENABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtDescription, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtNumber, ActionStateConst.DISABLED);		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.carnivorous.basedata.app.CarviousFeedComMeatEditUIHandler";
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
        this.prmtbreedData.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.carnivorous.basedata.CarviousFeedComMeatInfo)ov;
    }
    protected void removeByPK(IObjectPK pk) throws Exception {
    	IObjectValue editData = this.editData;
    	super.removeByPK(pk);
    	recycleNumberByOrg(editData,"Company",editData.getString("number"));
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
			protected com.kingdee.eas.basedata.org.OrgType getMainBizOrgType() {
			return com.kingdee.eas.basedata.org.OrgType.getEnum("Company");
		}

	protected KDBizPromptBox getMainBizOrg() {
		return prmtFICompany;
}


    /**
     * output loadFields method
     */
    public void loadFields()
    {
        		setAutoNumberByOrg("Company");
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
		getValidateHelper().registerBindProperty("Entrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.minSymbol", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.maxSymbol", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.minValue", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.maxValue", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.price", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.oneDrugAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FICompany", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedData", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("beginDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("endDate", ValidateHelper.ON_SAVE);    		
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
        if (STATUS_ADDNEW.equals(this.oprtState)) {
		            this.txtDescription.setEnabled(true);
		            this.txtNumber.setEnabled(true);
        } else if (STATUS_EDIT.equals(this.oprtState)) {
		            this.txtDescription.setEnabled(true);
		            this.txtNumber.setEnabled(true);
        } else if (STATUS_VIEW.equals(this.oprtState)) {
		            this.txtDescription.setEnabled(false);
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
    	sic.add(new SelectorItemInfo("Entrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("Entrys.minSymbol"));
    	sic.add(new SelectorItemInfo("Entrys.maxSymbol"));
    	sic.add(new SelectorItemInfo("Entrys.minValue"));
    	sic.add(new SelectorItemInfo("Entrys.maxValue"));
    	sic.add(new SelectorItemInfo("Entrys.price"));
    	sic.add(new SelectorItemInfo("Entrys.oneDrugAmt"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("description"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FICompany.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("FICompany.id"));
        	sic.add(new SelectorItemInfo("FICompany.number"));
        	sic.add(new SelectorItemInfo("FICompany.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("breedData.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("breedData.id"));
        	sic.add(new SelectorItemInfo("breedData.number"));
        	sic.add(new SelectorItemInfo("breedData.name"));
		}
        sic.add(new SelectorItemInfo("baseStatus"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("beginDate"));
        sic.add(new SelectorItemInfo("endDate"));
        return sic;
    }        
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.basedata.CarviousFeedComMeatFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.basedata.CarviousFeedComMeatFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractCarviousFeedComMeatEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractCarviousFeedComMeatEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.basedata.client", "CarviousFeedComMeatEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.client.CarviousFeedComMeatEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.basedata.CarviousFeedComMeatFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.basedata.CarviousFeedComMeatInfo objectValue = new com.kingdee.eas.farm.carnivorous.basedata.CarviousFeedComMeatInfo();
				if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")).getBoolean("isBizUnit"))
			objectValue.put("FICompany",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")));
 
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"price").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"毛鸡单价"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtNumber.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"编码"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtbreedData.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"品种"});
		}
			super.beforeStoreFields(arg0);
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
		vo.put("baseStatus",new Integer(1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}