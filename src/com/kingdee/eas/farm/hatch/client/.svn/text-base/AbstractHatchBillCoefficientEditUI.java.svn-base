/**
 * output package name
 */
package com.kingdee.eas.farm.hatch.client;

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
public abstract class AbstractHatchBillCoefficientEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractHatchBillCoefficientEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisGroup;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisCompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBillType;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcarCoefficient;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfloor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contplate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contunitMei;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcarCoefficient;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfloor;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtplate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtunitMei;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDComboBox BillType;
    protected com.kingdee.eas.farm.hatch.HatchBillCoefficientInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractHatchBillCoefficientEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractHatchBillCoefficientEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisGroup = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisCompany = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contBillType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contcarCoefficient = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfloor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contplate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contunitMei = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtcarCoefficient = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfloor = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtplate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtunitMei = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kdtEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.BillType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.chkisGroup.setName("chkisGroup");
        this.chkisCompany.setName("chkisCompany");
        this.contcompany.setName("contcompany");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contBillType.setName("contBillType");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.prmtcompany.setName("prmtcompany");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel1.setName("kDPanel1");
        this.contcarCoefficient.setName("contcarCoefficient");
        this.contfloor.setName("contfloor");
        this.contplate.setName("contplate");
        this.contunitMei.setName("contunitMei");
        this.txtcarCoefficient.setName("txtcarCoefficient");
        this.txtfloor.setName("txtfloor");
        this.txtplate.setName("txtplate");
        this.txtunitMei.setName("txtunitMei");
        this.kdtEntry.setName("kdtEntry");
        this.BillType.setName("BillType");
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
        // chkisGroup		
        this.chkisGroup.setText(resHelper.getString("chkisGroup.text"));		
        this.chkisGroup.setVisible(true);		
        this.chkisGroup.setHorizontalAlignment(2);
        // chkisCompany		
        this.chkisCompany.setText(resHelper.getString("chkisCompany.text"));		
        this.chkisCompany.setVisible(true);		
        this.chkisCompany.setHorizontalAlignment(2);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // kDTabbedPane1
        // contBillType		
        this.contBillType.setBoundLabelText(resHelper.getString("contBillType.boundLabelText"));		
        this.contBillType.setBoundLabelLength(100);		
        this.contBillType.setBoundLabelUnderline(true);		
        this.contBillType.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setVisible(true);		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(false);
        // kDPanel2
        // kDPanel1
        // contcarCoefficient		
        this.contcarCoefficient.setBoundLabelText(resHelper.getString("contcarCoefficient.boundLabelText"));		
        this.contcarCoefficient.setBoundLabelLength(100);		
        this.contcarCoefficient.setBoundLabelUnderline(true);		
        this.contcarCoefficient.setVisible(true);
        // contfloor		
        this.contfloor.setBoundLabelText(resHelper.getString("contfloor.boundLabelText"));		
        this.contfloor.setBoundLabelLength(100);		
        this.contfloor.setBoundLabelUnderline(true);		
        this.contfloor.setVisible(true);
        // contplate		
        this.contplate.setBoundLabelText(resHelper.getString("contplate.boundLabelText"));		
        this.contplate.setBoundLabelLength(100);		
        this.contplate.setBoundLabelUnderline(true);		
        this.contplate.setVisible(true);
        // contunitMei		
        this.contunitMei.setBoundLabelText(resHelper.getString("contunitMei.boundLabelText"));		
        this.contunitMei.setBoundLabelLength(100);		
        this.contunitMei.setBoundLabelUnderline(true);		
        this.contunitMei.setVisible(true);
        // txtcarCoefficient		
        this.txtcarCoefficient.setVisible(true);		
        this.txtcarCoefficient.setHorizontalAlignment(2);		
        this.txtcarCoefficient.setDataType(1);		
        this.txtcarCoefficient.setSupportedEmpty(true);		
        this.txtcarCoefficient.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcarCoefficient.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcarCoefficient.setPrecision(4);		
        this.txtcarCoefficient.setRequired(false);
        // txtfloor		
        this.txtfloor.setVisible(true);		
        this.txtfloor.setHorizontalAlignment(2);		
        this.txtfloor.setDataType(1);		
        this.txtfloor.setSupportedEmpty(true);		
        this.txtfloor.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfloor.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfloor.setPrecision(4);		
        this.txtfloor.setRequired(false);
        // txtplate		
        this.txtplate.setVisible(true);		
        this.txtplate.setHorizontalAlignment(2);		
        this.txtplate.setDataType(1);		
        this.txtplate.setSupportedEmpty(true);		
        this.txtplate.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtplate.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtplate.setPrecision(4);		
        this.txtplate.setRequired(false);
        // txtunitMei		
        this.txtunitMei.setVisible(true);		
        this.txtunitMei.setHorizontalAlignment(2);		
        this.txtunitMei.setDataType(1);		
        this.txtunitMei.setSupportedEmpty(true);		
        this.txtunitMei.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtunitMei.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtunitMei.setPrecision(4);		
        this.txtunitMei.setRequired(false);
        // kdtEntry
		String kdtEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"storageOrgUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"stoOrgUnitNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{storageOrgUnit}</t:Cell><t:Cell>$Resource{stoOrgUnitNum}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtEntry.putBindContents("editData",new String[] {"seq","storageOrgUnit","stoOrgUnitNum"});


        this.kdtEntry.checkParsed();
        KDFormattedTextField kdtEntry_seq_TextField = new KDFormattedTextField();
        kdtEntry_seq_TextField.setName("kdtEntry_seq_TextField");
        kdtEntry_seq_TextField.setVisible(true);
        kdtEntry_seq_TextField.setEditable(true);
        kdtEntry_seq_TextField.setHorizontalAlignment(2);
        kdtEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtEntry_seq_TextField);
        this.kdtEntry.getColumn("seq").setEditor(kdtEntry_seq_CellEditor);
        final KDBizPromptBox kdtEntry_storageOrgUnit_PromptBox = new KDBizPromptBox();
        kdtEntry_storageOrgUnit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");
        kdtEntry_storageOrgUnit_PromptBox.setVisible(true);
        kdtEntry_storageOrgUnit_PromptBox.setEditable(true);
        kdtEntry_storageOrgUnit_PromptBox.setDisplayFormat("$number$");
        kdtEntry_storageOrgUnit_PromptBox.setEditFormat("$number$");
        kdtEntry_storageOrgUnit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_storageOrgUnit_CellEditor = new KDTDefaultCellEditor(kdtEntry_storageOrgUnit_PromptBox);
        this.kdtEntry.getColumn("storageOrgUnit").setEditor(kdtEntry_storageOrgUnit_CellEditor);
        ObjectValueRender kdtEntry_storageOrgUnit_OVR = new ObjectValueRender();
        kdtEntry_storageOrgUnit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("storageOrgUnit").setRenderer(kdtEntry_storageOrgUnit_OVR);
        KDTextField kdtEntry_stoOrgUnitNum_TextField = new KDTextField();
        kdtEntry_stoOrgUnitNum_TextField.setName("kdtEntry_stoOrgUnitNum_TextField");
        kdtEntry_stoOrgUnitNum_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntry_stoOrgUnitNum_CellEditor = new KDTDefaultCellEditor(kdtEntry_stoOrgUnitNum_TextField);
        this.kdtEntry.getColumn("stoOrgUnitNum").setEditor(kdtEntry_stoOrgUnitNum_CellEditor);
        // BillType		
        this.BillType.setVisible(true);		
        this.BillType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.hatch.HatchBillTypeEnum").toArray());		
        this.BillType.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {chkisGroup,chkisCompany,prmtcompany,txtcarCoefficient,txtfloor,txtplate,txtunitMei,BillType}));
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
        this.setBounds(new Rectangle(-1, -14, 342, 430));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(24, 32, 299, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(24, 67, 299, 19));
        this.add(kDLabelContainer2, null);
        chkisGroup.setBounds(new Rectangle(24, 135, 299, 19));
        this.add(chkisGroup, null);
        chkisCompany.setBounds(new Rectangle(24, 158, 299, 19));
        this.add(chkisCompany, null);
        contcompany.setBounds(new Rectangle(24, 186, 299, 19));
        this.add(contcompany, null);
        kDTabbedPane1.setBounds(new Rectangle(25, 218, 298, 205));
        this.add(kDTabbedPane1, null);
        contBillType.setBounds(new Rectangle(24, 101, 299, 19));
        this.add(contBillType, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        //kDPanel2
        kDPanel2.setLayout(null);        contcarCoefficient.setBounds(new Rectangle(12, 19, 270, 19));
        kDPanel2.add(contcarCoefficient, null);
        contfloor.setBounds(new Rectangle(12, 55, 270, 19));
        kDPanel2.add(contfloor, null);
        contplate.setBounds(new Rectangle(12, 91, 270, 19));
        kDPanel2.add(contplate, null);
        contunitMei.setBounds(new Rectangle(12, 128, 270, 19));
        kDPanel2.add(contunitMei, null);
        //contcarCoefficient
        contcarCoefficient.setBoundEditor(txtcarCoefficient);
        //contfloor
        contfloor.setBoundEditor(txtfloor);
        //contplate
        contplate.setBoundEditor(txtplate);
        //contunitMei
        contunitMei.setBoundEditor(txtunitMei);
        //kDPanel1
        kDPanel1.setLayout(null);        kdtEntry.setBounds(new Rectangle(3, 4, 285, 163));
        kdtEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntry,new com.kingdee.eas.farm.hatch.HatchBillCoefficientEntryInfo(),null,false);
        kDPanel1.add(kdtEntry_detailPanel, null);
        //contBillType
        contBillType.setBoundEditor(BillType);

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
		dataBinder.registerBinding("isGroup", boolean.class, this.chkisGroup, "selected");
		dataBinder.registerBinding("isCompany", boolean.class, this.chkisCompany, "selected");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("carCoefficient", java.math.BigDecimal.class, this.txtcarCoefficient, "value");
		dataBinder.registerBinding("floor", java.math.BigDecimal.class, this.txtfloor, "value");
		dataBinder.registerBinding("plate", java.math.BigDecimal.class, this.txtplate, "value");
		dataBinder.registerBinding("unitMei", java.math.BigDecimal.class, this.txtunitMei, "value");
		dataBinder.registerBinding("Entry.seq", int.class, this.kdtEntry, "seq.text");
		dataBinder.registerBinding("Entry", com.kingdee.eas.farm.hatch.HatchBillCoefficientEntryInfo.class, this.kdtEntry, "userObject");
		dataBinder.registerBinding("Entry.storageOrgUnit", java.lang.Object.class, this.kdtEntry, "storageOrgUnit.text");
		dataBinder.registerBinding("Entry.stoOrgUnitNum", String.class, this.kdtEntry, "stoOrgUnitNum.text");
		dataBinder.registerBinding("BillType", com.kingdee.eas.farm.hatch.HatchBillTypeEnum.class, this.BillType, "selectedItem");		
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
	    return "com.kingdee.eas.farm.hatch.app.HatchBillCoefficientEditUIHandler";
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
        this.chkisGroup.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.hatch.HatchBillCoefficientInfo)ov;
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
		getValidateHelper().registerBindProperty("isGroup", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isCompany", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("carCoefficient", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("floor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("plate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("unitMei", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.storageOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.stoOrgUnitNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BillType", ValidateHelper.ON_SAVE);    		
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
     * output kdtEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("storageOrgUnit".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"stoOrgUnitNum").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntry.getCell(rowIndex,"storageOrgUnit").getValue(),"number")));

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
        sic.add(new SelectorItemInfo("isGroup"));
        sic.add(new SelectorItemInfo("isCompany"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
        sic.add(new SelectorItemInfo("carCoefficient"));
        sic.add(new SelectorItemInfo("floor"));
        sic.add(new SelectorItemInfo("plate"));
        sic.add(new SelectorItemInfo("unitMei"));
    	sic.add(new SelectorItemInfo("Entry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.storageOrgUnit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entry.storageOrgUnit.id"));
			sic.add(new SelectorItemInfo("Entry.storageOrgUnit.name"));
        	sic.add(new SelectorItemInfo("Entry.storageOrgUnit.number"));
		}
    	sic.add(new SelectorItemInfo("Entry.stoOrgUnitNum"));
        sic.add(new SelectorItemInfo("BillType"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.hatch.client", "HatchBillCoefficientEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.hatch.client.HatchBillCoefficientEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.hatch.HatchBillCoefficientFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.hatch.HatchBillCoefficientInfo objectValue = new com.kingdee.eas.farm.hatch.HatchBillCoefficientInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
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
				vo.put("unitMei",new java.math.BigDecimal(1));
vo.put("BillType",new Integer(0));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}