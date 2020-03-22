/**
 * output package name
 */
package com.kingdee.eas.farm.food.client;

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
public abstract class AbstractFoodBaseDataEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractFoodBaseDataEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthitchTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcatchTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contunitQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteveryCarCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbasketQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcarHandlingTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweghtTimeCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbeginHitchTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttransDeviceTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txthitchTime;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcatchTime;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtunitQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txteveryCarCount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbasketQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcarHandlingTime;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtweghtTimeCost;
    protected com.kingdee.bos.ctrl.swing.KDTimePicker beginHitchTime;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttransDeviceTime;
    protected com.kingdee.eas.farm.food.FoodBaseDataInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractFoodBaseDataEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractFoodBaseDataEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthitchTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcatchTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contunitQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstorageOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteveryCarCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbasketQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcarHandlingTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweghtTimeCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbeginHitchTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttransDeviceTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txthitchTime = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcatchTime = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtunitQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtstorageOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txteveryCarCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbasketQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcarHandlingTime = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtweghtTimeCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.beginHitchTime = new com.kingdee.bos.ctrl.swing.KDTimePicker();
        this.txttransDeviceTime = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.conthitchTime.setName("conthitchTime");
        this.contcatchTime.setName("contcatchTime");
        this.contunitQty.setName("contunitQty");
        this.contstorageOrgUnit.setName("contstorageOrgUnit");
        this.conteveryCarCount.setName("conteveryCarCount");
        this.contbasketQty.setName("contbasketQty");
        this.contcarHandlingTime.setName("contcarHandlingTime");
        this.contweghtTimeCost.setName("contweghtTimeCost");
        this.contbeginHitchTime.setName("contbeginHitchTime");
        this.conttransDeviceTime.setName("conttransDeviceTime");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.txthitchTime.setName("txthitchTime");
        this.txtcatchTime.setName("txtcatchTime");
        this.txtunitQty.setName("txtunitQty");
        this.prmtstorageOrgUnit.setName("prmtstorageOrgUnit");
        this.txteveryCarCount.setName("txteveryCarCount");
        this.txtbasketQty.setName("txtbasketQty");
        this.txtcarHandlingTime.setName("txtcarHandlingTime");
        this.txtweghtTimeCost.setName("txtweghtTimeCost");
        this.beginHitchTime.setName("beginHitchTime");
        this.txttransDeviceTime.setName("txttransDeviceTime");
        // CoreUI		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);		
        this.kDLabelContainer1.setVisible(false);
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelLength(120);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);
        // kDLabelContainer3		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelLength(100);		
        this.kDLabelContainer3.setBoundLabelUnderline(true);		
        this.kDLabelContainer3.setVisible(false);
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(120);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelAlignment(7);		
        this.kDLabelContainer4.setVisible(true);
        // conthitchTime		
        this.conthitchTime.setBoundLabelText(resHelper.getString("conthitchTime.boundLabelText"));		
        this.conthitchTime.setBoundLabelLength(120);		
        this.conthitchTime.setBoundLabelUnderline(true);		
        this.conthitchTime.setVisible(true);
        // contcatchTime		
        this.contcatchTime.setBoundLabelText(resHelper.getString("contcatchTime.boundLabelText"));		
        this.contcatchTime.setBoundLabelLength(120);		
        this.contcatchTime.setBoundLabelUnderline(true);		
        this.contcatchTime.setVisible(true);
        // contunitQty		
        this.contunitQty.setBoundLabelText(resHelper.getString("contunitQty.boundLabelText"));		
        this.contunitQty.setBoundLabelLength(120);		
        this.contunitQty.setBoundLabelUnderline(true);		
        this.contunitQty.setVisible(true);
        // contstorageOrgUnit		
        this.contstorageOrgUnit.setBoundLabelText(resHelper.getString("contstorageOrgUnit.boundLabelText"));		
        this.contstorageOrgUnit.setBoundLabelLength(120);		
        this.contstorageOrgUnit.setBoundLabelUnderline(true);		
        this.contstorageOrgUnit.setVisible(true);
        // conteveryCarCount		
        this.conteveryCarCount.setBoundLabelText(resHelper.getString("conteveryCarCount.boundLabelText"));		
        this.conteveryCarCount.setBoundLabelLength(120);		
        this.conteveryCarCount.setBoundLabelUnderline(true);		
        this.conteveryCarCount.setVisible(true);
        // contbasketQty		
        this.contbasketQty.setBoundLabelText(resHelper.getString("contbasketQty.boundLabelText"));		
        this.contbasketQty.setBoundLabelLength(120);		
        this.contbasketQty.setBoundLabelUnderline(true);		
        this.contbasketQty.setVisible(true);
        // contcarHandlingTime		
        this.contcarHandlingTime.setBoundLabelText(resHelper.getString("contcarHandlingTime.boundLabelText"));		
        this.contcarHandlingTime.setBoundLabelLength(120);		
        this.contcarHandlingTime.setBoundLabelUnderline(true);		
        this.contcarHandlingTime.setVisible(true);
        // contweghtTimeCost		
        this.contweghtTimeCost.setBoundLabelText(resHelper.getString("contweghtTimeCost.boundLabelText"));		
        this.contweghtTimeCost.setBoundLabelLength(120);		
        this.contweghtTimeCost.setBoundLabelUnderline(true);		
        this.contweghtTimeCost.setVisible(true);
        // contbeginHitchTime		
        this.contbeginHitchTime.setBoundLabelText(resHelper.getString("contbeginHitchTime.boundLabelText"));		
        this.contbeginHitchTime.setBoundLabelLength(120);		
        this.contbeginHitchTime.setBoundLabelUnderline(true);		
        this.contbeginHitchTime.setVisible(true);
        // conttransDeviceTime		
        this.conttransDeviceTime.setBoundLabelText(resHelper.getString("conttransDeviceTime.boundLabelText"));		
        this.conttransDeviceTime.setBoundLabelLength(120);		
        this.conttransDeviceTime.setBoundLabelUnderline(true);		
        this.conttransDeviceTime.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setVisible(false);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);		
        this.txtSimpleName.setVisible(false);
        // txtDescription
        // txthitchTime		
        this.txthitchTime.setVisible(true);		
        this.txthitchTime.setHorizontalAlignment(2);		
        this.txthitchTime.setDataType(1);		
        this.txthitchTime.setSupportedEmpty(true);		
        this.txthitchTime.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txthitchTime.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txthitchTime.setPrecision(4);		
        this.txthitchTime.setRequired(true);
        // txtcatchTime		
        this.txtcatchTime.setVisible(true);		
        this.txtcatchTime.setHorizontalAlignment(2);		
        this.txtcatchTime.setDataType(1);		
        this.txtcatchTime.setSupportedEmpty(true);		
        this.txtcatchTime.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcatchTime.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcatchTime.setPrecision(4);		
        this.txtcatchTime.setRequired(true);
        // txtunitQty		
        this.txtunitQty.setVisible(true);		
        this.txtunitQty.setHorizontalAlignment(2);		
        this.txtunitQty.setDataType(1);		
        this.txtunitQty.setSupportedEmpty(true);		
        this.txtunitQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtunitQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtunitQty.setPrecision(4);		
        this.txtunitQty.setRequired(true);
        // prmtstorageOrgUnit		
        this.prmtstorageOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtstorageOrgUnit.setVisible(true);		
        this.prmtstorageOrgUnit.setEditable(true);		
        this.prmtstorageOrgUnit.setDisplayFormat("$name$");		
        this.prmtstorageOrgUnit.setEditFormat("$number$");		
        this.prmtstorageOrgUnit.setCommitFormat("$number$");		
        this.prmtstorageOrgUnit.setRequired(true);
        // txteveryCarCount		
        this.txteveryCarCount.setVisible(true);		
        this.txteveryCarCount.setHorizontalAlignment(2);		
        this.txteveryCarCount.setDataType(0);		
        this.txteveryCarCount.setSupportedEmpty(true);		
        this.txteveryCarCount.setRequired(true);
        // txtbasketQty		
        this.txtbasketQty.setVisible(true);		
        this.txtbasketQty.setHorizontalAlignment(2);		
        this.txtbasketQty.setDataType(0);		
        this.txtbasketQty.setSupportedEmpty(true);		
        this.txtbasketQty.setRequired(true);
        // txtcarHandlingTime		
        this.txtcarHandlingTime.setVisible(true);		
        this.txtcarHandlingTime.setHorizontalAlignment(2);		
        this.txtcarHandlingTime.setDataType(1);		
        this.txtcarHandlingTime.setSupportedEmpty(true);		
        this.txtcarHandlingTime.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcarHandlingTime.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcarHandlingTime.setPrecision(4);		
        this.txtcarHandlingTime.setRequired(false);
        // txtweghtTimeCost		
        this.txtweghtTimeCost.setVisible(true);		
        this.txtweghtTimeCost.setHorizontalAlignment(2);		
        this.txtweghtTimeCost.setDataType(1);		
        this.txtweghtTimeCost.setSupportedEmpty(true);		
        this.txtweghtTimeCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtweghtTimeCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtweghtTimeCost.setPrecision(4);		
        this.txtweghtTimeCost.setRequired(false);
        // beginHitchTime		
        this.beginHitchTime.setVisible(true);
        // txttransDeviceTime		
        this.txttransDeviceTime.setVisible(true);		
        this.txttransDeviceTime.setHorizontalAlignment(2);		
        this.txttransDeviceTime.setDataType(1);		
        this.txttransDeviceTime.setSupportedEmpty(true);		
        this.txttransDeviceTime.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttransDeviceTime.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttransDeviceTime.setPrecision(4);		
        this.txttransDeviceTime.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txthitchTime,txtcatchTime,txtunitQty,prmtstorageOrgUnit,txteveryCarCount,txtbasketQty,txtcarHandlingTime,txtweghtTimeCost,beginHitchTime,txttransDeviceTime}));
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
        this.setBounds(new Rectangle(0, 0, 401, 478));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(730, 91, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(50, 47, 300, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(744, 130, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(50, 80, 300, 19));
        this.add(kDLabelContainer4, null);
        conthitchTime.setBounds(new Rectangle(50, 179, 300, 19));
        this.add(conthitchTime, null);
        contcatchTime.setBounds(new Rectangle(50, 344, 300, 19));
        this.add(contcatchTime, null);
        contunitQty.setBounds(new Rectangle(50, 311, 300, 19));
        this.add(contunitQty, null);
        contstorageOrgUnit.setBounds(new Rectangle(50, 113, 300, 19));
        this.add(contstorageOrgUnit, null);
        conteveryCarCount.setBounds(new Rectangle(50, 382, 300, 19));
        this.add(conteveryCarCount, null);
        contbasketQty.setBounds(new Rectangle(50, 278, 300, 19));
        this.add(contbasketQty, null);
        contcarHandlingTime.setBounds(new Rectangle(50, 212, 300, 19));
        this.add(contcarHandlingTime, null);
        contweghtTimeCost.setBounds(new Rectangle(50, 245, 300, 19));
        this.add(contweghtTimeCost, null);
        contbeginHitchTime.setBounds(new Rectangle(50, 146, 300, 19));
        this.add(contbeginHitchTime, null);
        conttransDeviceTime.setBounds(new Rectangle(50, 419, 300, 19));
        this.add(conttransDeviceTime, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //conthitchTime
        conthitchTime.setBoundEditor(txthitchTime);
        //contcatchTime
        contcatchTime.setBoundEditor(txtcatchTime);
        //contunitQty
        contunitQty.setBoundEditor(txtunitQty);
        //contstorageOrgUnit
        contstorageOrgUnit.setBoundEditor(prmtstorageOrgUnit);
        //conteveryCarCount
        conteveryCarCount.setBoundEditor(txteveryCarCount);
        //contbasketQty
        contbasketQty.setBoundEditor(txtbasketQty);
        //contcarHandlingTime
        contcarHandlingTime.setBoundEditor(txtcarHandlingTime);
        //contweghtTimeCost
        contweghtTimeCost.setBoundEditor(txtweghtTimeCost);
        //contbeginHitchTime
        contbeginHitchTime.setBoundEditor(beginHitchTime);
        //conttransDeviceTime
        conttransDeviceTime.setBoundEditor(txttransDeviceTime);

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
		dataBinder.registerBinding("hitchTime", java.math.BigDecimal.class, this.txthitchTime, "value");
		dataBinder.registerBinding("catchTime", java.math.BigDecimal.class, this.txtcatchTime, "value");
		dataBinder.registerBinding("unitQty", java.math.BigDecimal.class, this.txtunitQty, "value");
		dataBinder.registerBinding("storageOrgUnit", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtstorageOrgUnit, "data");
		dataBinder.registerBinding("everyCarCount", int.class, this.txteveryCarCount, "value");
		dataBinder.registerBinding("basketQty", int.class, this.txtbasketQty, "value");
		dataBinder.registerBinding("carHandlingTime", java.math.BigDecimal.class, this.txtcarHandlingTime, "value");
		dataBinder.registerBinding("weghtTimeCost", java.math.BigDecimal.class, this.txtweghtTimeCost, "value");
		dataBinder.registerBinding("beginHitchTime", java.sql.Time.class, this.beginHitchTime, "value");
		dataBinder.registerBinding("transDeviceTime", java.math.BigDecimal.class, this.txttransDeviceTime, "value");		
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
	    return "com.kingdee.eas.farm.food.app.FoodBaseDataEditUIHandler";
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
        this.txthitchTime.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.food.FoodBaseDataInfo)ov;
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
		getValidateHelper().registerBindProperty("hitchTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("catchTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("unitQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("storageOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("everyCarCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("basketQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("carHandlingTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("weghtTimeCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("beginHitchTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("transDeviceTime", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("hitchTime"));
        sic.add(new SelectorItemInfo("catchTime"));
        sic.add(new SelectorItemInfo("unitQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("storageOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("storageOrgUnit.id"));
        	sic.add(new SelectorItemInfo("storageOrgUnit.number"));
        	sic.add(new SelectorItemInfo("storageOrgUnit.name"));
		}
        sic.add(new SelectorItemInfo("everyCarCount"));
        sic.add(new SelectorItemInfo("basketQty"));
        sic.add(new SelectorItemInfo("carHandlingTime"));
        sic.add(new SelectorItemInfo("weghtTimeCost"));
        sic.add(new SelectorItemInfo("beginHitchTime"));
        sic.add(new SelectorItemInfo("transDeviceTime"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.food.client", "FoodBaseDataEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.food.client.FoodBaseDataEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.food.FoodBaseDataFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.food.FoodBaseDataInfo objectValue = new com.kingdee.eas.farm.food.FoodBaseDataInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txthitchTime.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"挂鸡时间（分钟/车）"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtcatchTime.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"抓鸡时间（分钟/车）"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtunitQty.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"单筐只数"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtstorageOrgUnit.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"库存组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txteveryCarCount.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"每次派车数"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtbasketQty.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"每车筐数"});
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