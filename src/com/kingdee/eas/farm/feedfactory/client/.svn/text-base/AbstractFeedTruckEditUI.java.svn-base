/**
 * output package name
 */
package com.kingdee.eas.farm.feedfactory.client;

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
public abstract class AbstractFeedTruckEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractFeedTruckEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlicensePlate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttare;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdriver;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator5;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdriverTel;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstatu;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contloadTimes;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contunloadTimes;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttruckType;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator6;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpotCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpotWeight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbuyDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contuplimit;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtlicensePlate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttare;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtdriver;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdriverTel;
    protected com.kingdee.bos.ctrl.swing.KDComboBox statu;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtloadTimes;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtunloadTimes;
    protected com.kingdee.bos.ctrl.swing.KDComboBox truckType;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpotCount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpotWeight;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkbuyDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtuplimit;
    protected com.kingdee.eas.farm.feedfactory.FeedTruckInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractFeedTruckEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractFeedTruckEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlicensePlate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttare = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdriver = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator5 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contdriverTel = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstatu = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contloadTimes = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contunloadTimes = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttruckType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator6 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contpotCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpotWeight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbuyDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contuplimit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtlicensePlate = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txttare = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtdriver = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtdriverTel = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.statu = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtloadTimes = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtunloadTimes = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.truckType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtpotCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpotWeight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkbuyDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtuplimit = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contlicensePlate.setName("contlicensePlate");
        this.conttare.setName("conttare");
        this.contdriver.setName("contdriver");
        this.kDSeparator5.setName("kDSeparator5");
        this.contdriverTel.setName("contdriverTel");
        this.contstatu.setName("contstatu");
        this.contloadTimes.setName("contloadTimes");
        this.contunloadTimes.setName("contunloadTimes");
        this.conttruckType.setName("conttruckType");
        this.kDSeparator6.setName("kDSeparator6");
        this.contpotCount.setName("contpotCount");
        this.contpotWeight.setName("contpotWeight");
        this.contbuyDate.setName("contbuyDate");
        this.contuplimit.setName("contuplimit");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.txtlicensePlate.setName("txtlicensePlate");
        this.txttare.setName("txttare");
        this.prmtdriver.setName("prmtdriver");
        this.txtdriverTel.setName("txtdriverTel");
        this.statu.setName("statu");
        this.txtloadTimes.setName("txtloadTimes");
        this.txtunloadTimes.setName("txtunloadTimes");
        this.truckType.setName("truckType");
        this.txtpotCount.setName("txtpotCount");
        this.txtpotWeight.setName("txtpotWeight");
        this.pkbuyDate.setName("pkbuyDate");
        this.txtuplimit.setName("txtuplimit");
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
        // contlicensePlate		
        this.contlicensePlate.setBoundLabelText(resHelper.getString("contlicensePlate.boundLabelText"));		
        this.contlicensePlate.setBoundLabelLength(100);		
        this.contlicensePlate.setBoundLabelUnderline(true);		
        this.contlicensePlate.setVisible(true);
        // conttare		
        this.conttare.setBoundLabelText(resHelper.getString("conttare.boundLabelText"));		
        this.conttare.setBoundLabelLength(100);		
        this.conttare.setBoundLabelUnderline(true);		
        this.conttare.setVisible(true);
        // contdriver		
        this.contdriver.setBoundLabelText(resHelper.getString("contdriver.boundLabelText"));		
        this.contdriver.setBoundLabelLength(100);		
        this.contdriver.setBoundLabelUnderline(true);		
        this.contdriver.setVisible(true);
        // kDSeparator5
        // contdriverTel		
        this.contdriverTel.setBoundLabelText(resHelper.getString("contdriverTel.boundLabelText"));		
        this.contdriverTel.setBoundLabelLength(100);		
        this.contdriverTel.setBoundLabelUnderline(true);		
        this.contdriverTel.setVisible(true);
        // contstatu		
        this.contstatu.setBoundLabelText(resHelper.getString("contstatu.boundLabelText"));		
        this.contstatu.setBoundLabelLength(100);		
        this.contstatu.setBoundLabelUnderline(true);		
        this.contstatu.setVisible(true);
        // contloadTimes		
        this.contloadTimes.setBoundLabelText(resHelper.getString("contloadTimes.boundLabelText"));		
        this.contloadTimes.setBoundLabelLength(100);		
        this.contloadTimes.setBoundLabelUnderline(true);		
        this.contloadTimes.setVisible(true);
        // contunloadTimes		
        this.contunloadTimes.setBoundLabelText(resHelper.getString("contunloadTimes.boundLabelText"));		
        this.contunloadTimes.setBoundLabelLength(100);		
        this.contunloadTimes.setBoundLabelUnderline(true);		
        this.contunloadTimes.setVisible(true);
        // conttruckType		
        this.conttruckType.setBoundLabelText(resHelper.getString("conttruckType.boundLabelText"));		
        this.conttruckType.setBoundLabelLength(100);		
        this.conttruckType.setBoundLabelUnderline(true);		
        this.conttruckType.setVisible(true);
        // kDSeparator6
        // contpotCount		
        this.contpotCount.setBoundLabelText(resHelper.getString("contpotCount.boundLabelText"));		
        this.contpotCount.setBoundLabelLength(100);		
        this.contpotCount.setBoundLabelUnderline(true);		
        this.contpotCount.setVisible(true);
        // contpotWeight		
        this.contpotWeight.setBoundLabelText(resHelper.getString("contpotWeight.boundLabelText"));		
        this.contpotWeight.setBoundLabelLength(100);		
        this.contpotWeight.setBoundLabelUnderline(true);		
        this.contpotWeight.setVisible(true);
        // contbuyDate		
        this.contbuyDate.setBoundLabelText(resHelper.getString("contbuyDate.boundLabelText"));		
        this.contbuyDate.setBoundLabelLength(100);		
        this.contbuyDate.setBoundLabelUnderline(true);		
        this.contbuyDate.setVisible(true);
        // contuplimit		
        this.contuplimit.setBoundLabelText(resHelper.getString("contuplimit.boundLabelText"));		
        this.contuplimit.setBoundLabelLength(100);		
        this.contuplimit.setBoundLabelUnderline(true);		
        this.contuplimit.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // txtlicensePlate		
        this.txtlicensePlate.setVisible(true);		
        this.txtlicensePlate.setHorizontalAlignment(2);		
        this.txtlicensePlate.setMaxLength(100);		
        this.txtlicensePlate.setRequired(false);
        // txttare		
        this.txttare.setVisible(true);		
        this.txttare.setHorizontalAlignment(2);		
        this.txttare.setDataType(1);		
        this.txttare.setSupportedEmpty(true);		
        this.txttare.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txttare.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txttare.setPrecision(2);		
        this.txttare.setRequired(false);
        // prmtdriver		
        this.prmtdriver.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtdriver.setVisible(true);		
        this.prmtdriver.setEditable(true);		
        this.prmtdriver.setDisplayFormat("$name$");		
        this.prmtdriver.setEditFormat("$number$");		
        this.prmtdriver.setCommitFormat("$number$");		
        this.prmtdriver.setRequired(false);
        // txtdriverTel		
        this.txtdriverTel.setVisible(true);		
        this.txtdriverTel.setHorizontalAlignment(2);		
        this.txtdriverTel.setMaxLength(100);		
        this.txtdriverTel.setRequired(false);
        // statu		
        this.statu.setVisible(true);		
        this.statu.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.feedfactory.TruckState").toArray());		
        this.statu.setRequired(false);
        // txtloadTimes		
        this.txtloadTimes.setVisible(true);		
        this.txtloadTimes.setHorizontalAlignment(2);		
        this.txtloadTimes.setDataType(0);		
        this.txtloadTimes.setSupportedEmpty(true);		
        this.txtloadTimes.setRequired(false);
        // txtunloadTimes		
        this.txtunloadTimes.setVisible(true);		
        this.txtunloadTimes.setHorizontalAlignment(2);		
        this.txtunloadTimes.setDataType(0);		
        this.txtunloadTimes.setSupportedEmpty(true);		
        this.txtunloadTimes.setRequired(false);
        // truckType		
        this.truckType.setVisible(true);		
        this.truckType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.feedfactory.TruckType").toArray());		
        this.truckType.setRequired(false);
        // txtpotCount		
        this.txtpotCount.setVisible(true);		
        this.txtpotCount.setHorizontalAlignment(2);		
        this.txtpotCount.setDataType(0);		
        this.txtpotCount.setSupportedEmpty(true);		
        this.txtpotCount.setRequired(false);
        // txtpotWeight		
        this.txtpotWeight.setVisible(true);		
        this.txtpotWeight.setHorizontalAlignment(2);		
        this.txtpotWeight.setDataType(1);		
        this.txtpotWeight.setSupportedEmpty(true);		
        this.txtpotWeight.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtpotWeight.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtpotWeight.setPrecision(2);		
        this.txtpotWeight.setRequired(false);
        // pkbuyDate		
        this.pkbuyDate.setVisible(true);		
        this.pkbuyDate.setRequired(false);
        // txtuplimit		
        this.txtuplimit.setVisible(true);		
        this.txtuplimit.setHorizontalAlignment(2);		
        this.txtuplimit.setDataType(1);		
        this.txtuplimit.setSupportedEmpty(true);		
        this.txtuplimit.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtuplimit.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtuplimit.setPrecision(2);		
        this.txtuplimit.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtlicensePlate,txttare,prmtdriver,txtdriverTel,statu,txtloadTimes,txtunloadTimes,truckType,txtpotCount,txtpotWeight,pkbuyDate,txtuplimit}));
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
        this.setBounds(new Rectangle(0, 0, 680, 629));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(52, 45, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(370, 45, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(112, -235, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(112, -235, 270, 19));
        this.add(kDLabelContainer4, null);
        contlicensePlate.setBounds(new Rectangle(52, 80, 270, 19));
        this.add(contlicensePlate, null);
        conttare.setBounds(new Rectangle(52, 224, 270, 19));
        this.add(conttare, null);
        contdriver.setBounds(new Rectangle(52, 115, 270, 19));
        this.add(contdriver, null);
        kDSeparator5.setBounds(new Rectangle(52, 334, 590, 10));
        this.add(kDSeparator5, null);
        contdriverTel.setBounds(new Rectangle(370, 115, 270, 19));
        this.add(contdriverTel, null);
        contstatu.setBounds(new Rectangle(370, 150, 270, 19));
        this.add(contstatu, null);
        contloadTimes.setBounds(new Rectangle(52, 350, 270, 19));
        this.add(contloadTimes, null);
        contunloadTimes.setBounds(new Rectangle(370, 350, 270, 19));
        this.add(contunloadTimes, null);
        conttruckType.setBounds(new Rectangle(52, 150, 270, 19));
        this.add(conttruckType, null);
        kDSeparator6.setBounds(new Rectangle(52, 206, 586, 10));
        this.add(kDSeparator6, null);
        contpotCount.setBounds(new Rectangle(52, 257, 270, 19));
        this.add(contpotCount, null);
        contpotWeight.setBounds(new Rectangle(370, 257, 270, 19));
        this.add(contpotWeight, null);
        contbuyDate.setBounds(new Rectangle(370, 80, 270, 19));
        this.add(contbuyDate, null);
        contuplimit.setBounds(new Rectangle(370, 224, 270, 19));
        this.add(contuplimit, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contlicensePlate
        contlicensePlate.setBoundEditor(txtlicensePlate);
        //conttare
        conttare.setBoundEditor(txttare);
        //contdriver
        contdriver.setBoundEditor(prmtdriver);
        //contdriverTel
        contdriverTel.setBoundEditor(txtdriverTel);
        //contstatu
        contstatu.setBoundEditor(statu);
        //contloadTimes
        contloadTimes.setBoundEditor(txtloadTimes);
        //contunloadTimes
        contunloadTimes.setBoundEditor(txtunloadTimes);
        //conttruckType
        conttruckType.setBoundEditor(truckType);
        //contpotCount
        contpotCount.setBoundEditor(txtpotCount);
        //contpotWeight
        contpotWeight.setBoundEditor(txtpotWeight);
        //contbuyDate
        contbuyDate.setBoundEditor(pkbuyDate);
        //contuplimit
        contuplimit.setBoundEditor(txtuplimit);

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
		dataBinder.registerBinding("licensePlate", String.class, this.txtlicensePlate, "text");
		dataBinder.registerBinding("tare", java.math.BigDecimal.class, this.txttare, "value");
		dataBinder.registerBinding("driver", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtdriver, "data");
		dataBinder.registerBinding("driverTel", String.class, this.txtdriverTel, "text");
		dataBinder.registerBinding("statu", com.kingdee.eas.farm.feedfactory.TruckState.class, this.statu, "selectedItem");
		dataBinder.registerBinding("loadTimes", int.class, this.txtloadTimes, "value");
		dataBinder.registerBinding("unloadTimes", int.class, this.txtunloadTimes, "value");
		dataBinder.registerBinding("truckType", com.kingdee.eas.farm.feedfactory.TruckType.class, this.truckType, "selectedItem");
		dataBinder.registerBinding("potCount", int.class, this.txtpotCount, "value");
		dataBinder.registerBinding("potWeight", java.math.BigDecimal.class, this.txtpotWeight, "value");
		dataBinder.registerBinding("buyDate", java.util.Date.class, this.pkbuyDate, "value");
		dataBinder.registerBinding("uplimit", java.math.BigDecimal.class, this.txtuplimit, "value");		
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
	    return "com.kingdee.eas.farm.feedfactory.app.FeedTruckEditUIHandler";
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
        this.txtlicensePlate.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.feedfactory.FeedTruckInfo)ov;
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
		getValidateHelper().registerBindProperty("licensePlate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("tare", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("driver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("driverTel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("statu", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("loadTimes", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("unloadTimes", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("truckType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("potCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("potWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("buyDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("uplimit", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("licensePlate"));
        sic.add(new SelectorItemInfo("tare"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("driver.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("driver.id"));
        	sic.add(new SelectorItemInfo("driver.number"));
        	sic.add(new SelectorItemInfo("driver.name"));
		}
        sic.add(new SelectorItemInfo("driverTel"));
        sic.add(new SelectorItemInfo("statu"));
        sic.add(new SelectorItemInfo("loadTimes"));
        sic.add(new SelectorItemInfo("unloadTimes"));
        sic.add(new SelectorItemInfo("truckType"));
        sic.add(new SelectorItemInfo("potCount"));
        sic.add(new SelectorItemInfo("potWeight"));
        sic.add(new SelectorItemInfo("buyDate"));
        sic.add(new SelectorItemInfo("uplimit"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.feedfactory.client", "FeedTruckEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.feedfactory.client.FeedTruckEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.feedfactory.FeedTruckFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.feedfactory.FeedTruckInfo objectValue = new com.kingdee.eas.farm.feedfactory.FeedTruckInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
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
		vo.put("statu","1");
vo.put("truckType","1");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}