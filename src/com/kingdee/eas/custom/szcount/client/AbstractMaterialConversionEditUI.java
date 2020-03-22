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
public abstract class AbstractMaterialConversionEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractMaterialConversionEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoneDise;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoneItem;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contonePackage;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel1;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel2;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompanyOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmaterial;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmaterialName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmaterialNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contspecifications;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoneDise;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoneItem;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtonePackage;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompanyOrgUnit;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtmaterial;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtmaterialName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtmaterialNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtspecifications;
    protected com.kingdee.eas.custom.szcount.MaterialConversionInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractMaterialConversionEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractMaterialConversionEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoneDise = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoneItem = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contonePackage = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabel1 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDLabel2 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDLabel3 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.contcompanyOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmaterial = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmaterialName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmaterialNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contspecifications = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtoneDise = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtoneItem = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtonePackage = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtcompanyOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtmaterial = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtmaterialName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtmaterialNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtspecifications = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contoneDise.setName("contoneDise");
        this.contoneItem.setName("contoneItem");
        this.contonePackage.setName("contonePackage");
        this.kDLabel1.setName("kDLabel1");
        this.kDLabel2.setName("kDLabel2");
        this.kDLabel3.setName("kDLabel3");
        this.contcompanyOrgUnit.setName("contcompanyOrgUnit");
        this.contmaterial.setName("contmaterial");
        this.contmaterialName.setName("contmaterialName");
        this.contmaterialNumber.setName("contmaterialNumber");
        this.contspecifications.setName("contspecifications");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.txtoneDise.setName("txtoneDise");
        this.txtoneItem.setName("txtoneItem");
        this.txtonePackage.setName("txtonePackage");
        this.prmtcompanyOrgUnit.setName("prmtcompanyOrgUnit");
        this.prmtmaterial.setName("prmtmaterial");
        this.txtmaterialName.setName("txtmaterialName");
        this.txtmaterialNumber.setName("txtmaterialNumber");
        this.txtspecifications.setName("txtspecifications");
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
        this.kDLabelContainer2.setVisible(false);
        // kDLabelContainer3		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelLength(100);		
        this.kDLabelContainer3.setBoundLabelUnderline(true);		
        this.kDLabelContainer3.setVisible(false);
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelAlignment(7);		
        this.kDLabelContainer4.setVisible(true);
        // contoneDise		
        this.contoneDise.setBoundLabelText(resHelper.getString("contoneDise.boundLabelText"));		
        this.contoneDise.setBoundLabelLength(100);		
        this.contoneDise.setBoundLabelUnderline(true);		
        this.contoneDise.setVisible(true);
        // contoneItem		
        this.contoneItem.setBoundLabelText(resHelper.getString("contoneItem.boundLabelText"));		
        this.contoneItem.setBoundLabelLength(100);		
        this.contoneItem.setBoundLabelUnderline(true);		
        this.contoneItem.setVisible(true);
        // contonePackage		
        this.contonePackage.setBoundLabelText(resHelper.getString("contonePackage.boundLabelText"));		
        this.contonePackage.setBoundLabelLength(100);		
        this.contonePackage.setBoundLabelUnderline(true);		
        this.contonePackage.setVisible(true);
        // kDLabel1		
        this.kDLabel1.setText(resHelper.getString("kDLabel1.text"));
        // kDLabel2		
        this.kDLabel2.setText(resHelper.getString("kDLabel2.text"));
        // kDLabel3		
        this.kDLabel3.setText(resHelper.getString("kDLabel3.text"));
        // contcompanyOrgUnit		
        this.contcompanyOrgUnit.setBoundLabelText(resHelper.getString("contcompanyOrgUnit.boundLabelText"));		
        this.contcompanyOrgUnit.setBoundLabelLength(100);		
        this.contcompanyOrgUnit.setBoundLabelUnderline(true);		
        this.contcompanyOrgUnit.setVisible(true);
        // contmaterial		
        this.contmaterial.setBoundLabelText(resHelper.getString("contmaterial.boundLabelText"));		
        this.contmaterial.setBoundLabelLength(100);		
        this.contmaterial.setBoundLabelUnderline(true);		
        this.contmaterial.setVisible(true);
        // contmaterialName		
        this.contmaterialName.setBoundLabelText(resHelper.getString("contmaterialName.boundLabelText"));		
        this.contmaterialName.setBoundLabelLength(100);		
        this.contmaterialName.setBoundLabelUnderline(true);		
        this.contmaterialName.setVisible(true);
        // contmaterialNumber		
        this.contmaterialNumber.setBoundLabelText(resHelper.getString("contmaterialNumber.boundLabelText"));		
        this.contmaterialNumber.setBoundLabelLength(100);		
        this.contmaterialNumber.setBoundLabelUnderline(true);		
        this.contmaterialNumber.setVisible(false);
        // contspecifications		
        this.contspecifications.setBoundLabelText(resHelper.getString("contspecifications.boundLabelText"));		
        this.contspecifications.setBoundLabelLength(100);		
        this.contspecifications.setBoundLabelUnderline(true);		
        this.contspecifications.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // txtoneDise		
        this.txtoneDise.setVisible(true);		
        this.txtoneDise.setHorizontalAlignment(2);		
        this.txtoneDise.setDataType(1);		
        this.txtoneDise.setSupportedEmpty(true);		
        this.txtoneDise.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtoneDise.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtoneDise.setPrecision(4);		
        this.txtoneDise.setRequired(true);
        // txtoneItem		
        this.txtoneItem.setVisible(true);		
        this.txtoneItem.setHorizontalAlignment(2);		
        this.txtoneItem.setDataType(1);		
        this.txtoneItem.setSupportedEmpty(true);		
        this.txtoneItem.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtoneItem.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtoneItem.setPrecision(4);		
        this.txtoneItem.setRequired(true);
        // txtonePackage		
        this.txtonePackage.setVisible(true);		
        this.txtonePackage.setHorizontalAlignment(2);		
        this.txtonePackage.setDataType(1);		
        this.txtonePackage.setSupportedEmpty(true);		
        this.txtonePackage.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtonePackage.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtonePackage.setPrecision(4);		
        this.txtonePackage.setRequired(true);
        // prmtcompanyOrgUnit		
        this.prmtcompanyOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompanyOrgUnit.setVisible(true);		
        this.prmtcompanyOrgUnit.setEditable(true);		
        this.prmtcompanyOrgUnit.setDisplayFormat("$name$");		
        this.prmtcompanyOrgUnit.setEditFormat("$number$");		
        this.prmtcompanyOrgUnit.setCommitFormat("$number$");		
        this.prmtcompanyOrgUnit.setRequired(false);
        // prmtmaterial		
        this.prmtmaterial.setQueryInfo("com.kingdee.eas.basedata.master.material.app.MaterialQuery");		
        this.prmtmaterial.setVisible(true);		
        this.prmtmaterial.setEditable(true);		
        this.prmtmaterial.setDisplayFormat("$number$");		
        this.prmtmaterial.setEditFormat("$number$");		
        this.prmtmaterial.setCommitFormat("$number$");		
        this.prmtmaterial.setRequired(true);
        prmtmaterial.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtmaterial_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtmaterialName		
        this.txtmaterialName.setVisible(true);		
        this.txtmaterialName.setHorizontalAlignment(2);		
        this.txtmaterialName.setMaxLength(80);		
        this.txtmaterialName.setRequired(false);
        // txtmaterialNumber		
        this.txtmaterialNumber.setVisible(true);		
        this.txtmaterialNumber.setHorizontalAlignment(2);		
        this.txtmaterialNumber.setMaxLength(80);		
        this.txtmaterialNumber.setRequired(false);
        // txtspecifications		
        this.txtspecifications.setVisible(true);		
        this.txtspecifications.setHorizontalAlignment(2);		
        this.txtspecifications.setMaxLength(80);		
        this.txtspecifications.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtoneDise,txtoneItem,txtonePackage,prmtcompanyOrgUnit,prmtmaterial,txtmaterialName,txtmaterialNumber,txtspecifications}));
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
        this.setBounds(new Rectangle(0, 0, 658, 264));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(35, 28, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(662, 5, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(385, 218, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(339, 28, 270, 19));
        this.add(kDLabelContainer4, null);
        contoneDise.setBounds(new Rectangle(35, 172, 220, 19));
        this.add(contoneDise, null);
        contoneItem.setBounds(new Rectangle(35, 136, 220, 19));
        this.add(contoneItem, null);
        contonePackage.setBounds(new Rectangle(35, 209, 220, 19));
        this.add(contonePackage, null);
        kDLabel1.setBounds(new Rectangle(261, 136, 36, 19));
        this.add(kDLabel1, null);
        kDLabel2.setBounds(new Rectangle(261, 172, 36, 19));
        this.add(kDLabel2, null);
        kDLabel3.setBounds(new Rectangle(261, 209, 36, 19));
        this.add(kDLabel3, null);
        contcompanyOrgUnit.setBounds(new Rectangle(339, 100, 270, 19));
        this.add(contcompanyOrgUnit, null);
        contmaterial.setBounds(new Rectangle(35, 64, 270, 19));
        this.add(contmaterial, null);
        contmaterialName.setBounds(new Rectangle(339, 64, 270, 19));
        this.add(contmaterialName, null);
        contmaterialNumber.setBounds(new Rectangle(359, 183, 270, 19));
        this.add(contmaterialNumber, null);
        contspecifications.setBounds(new Rectangle(35, 100, 270, 19));
        this.add(contspecifications, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contoneDise
        contoneDise.setBoundEditor(txtoneDise);
        //contoneItem
        contoneItem.setBoundEditor(txtoneItem);
        //contonePackage
        contonePackage.setBoundEditor(txtonePackage);
        //contcompanyOrgUnit
        contcompanyOrgUnit.setBoundEditor(prmtcompanyOrgUnit);
        //contmaterial
        contmaterial.setBoundEditor(prmtmaterial);
        //contmaterialName
        contmaterialName.setBoundEditor(txtmaterialName);
        //contmaterialNumber
        contmaterialNumber.setBoundEditor(txtmaterialNumber);
        //contspecifications
        contspecifications.setBoundEditor(txtspecifications);

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
		dataBinder.registerBinding("oneDise", java.math.BigDecimal.class, this.txtoneDise, "value");
		dataBinder.registerBinding("oneItem", java.math.BigDecimal.class, this.txtoneItem, "value");
		dataBinder.registerBinding("onePackage", java.math.BigDecimal.class, this.txtonePackage, "value");
		dataBinder.registerBinding("companyOrgUnit", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompanyOrgUnit, "data");
		dataBinder.registerBinding("material", com.kingdee.eas.basedata.master.material.MaterialInfo.class, this.prmtmaterial, "data");
		dataBinder.registerBinding("materialName", String.class, this.txtmaterialName, "text");
		dataBinder.registerBinding("materialNumber", String.class, this.txtmaterialNumber, "text");
		dataBinder.registerBinding("specifications", String.class, this.txtspecifications, "text");		
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
	    return "com.kingdee.eas.custom.szcount.app.MaterialConversionEditUIHandler";
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
        this.txtoneDise.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.szcount.MaterialConversionInfo)ov;
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
		getValidateHelper().registerBindProperty("oneDise", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("oneItem", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("onePackage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("companyOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("materialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("materialNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("specifications", ValidateHelper.ON_SAVE);    		
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
     * output prmtmaterial_Changed() method
     */
    public void prmtmaterial_Changed() throws Exception
    {
        System.out.println("prmtmaterial_Changed() Function is executed!");
            txtmaterialName.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtmaterial.getData(),"name")));

    txtmaterialNumber.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtmaterial.getData(),"number")));

    txtspecifications.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtmaterial.getData(),"model")));


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
        sic.add(new SelectorItemInfo("oneDise"));
        sic.add(new SelectorItemInfo("oneItem"));
        sic.add(new SelectorItemInfo("onePackage"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("companyOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("companyOrgUnit.id"));
        	sic.add(new SelectorItemInfo("companyOrgUnit.number"));
        	sic.add(new SelectorItemInfo("companyOrgUnit.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("material.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("material.id"));
        	sic.add(new SelectorItemInfo("material.number"));
        	sic.add(new SelectorItemInfo("material.name"));
		}
        sic.add(new SelectorItemInfo("materialName"));
        sic.add(new SelectorItemInfo("materialNumber"));
        sic.add(new SelectorItemInfo("specifications"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.szcount.client", "MaterialConversionEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.szcount.client.MaterialConversionEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.szcount.MaterialConversionFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.szcount.MaterialConversionInfo objectValue = new com.kingdee.eas.custom.szcount.MaterialConversionInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtoneDise.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"一盘"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtoneItem.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"一件"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtonePackage.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"一包"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtmaterial.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"物料编码"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {        
        return null;
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