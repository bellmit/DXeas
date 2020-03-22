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
public abstract class AbstractMarketPolicyEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractMarketPolicyEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompanyOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyieldRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontractPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmarketType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmarketChicOrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmarketSmartPrice;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompanyOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtauditor;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyieldRate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcontractPrice;
    protected com.kingdee.bos.ctrl.swing.KDComboBox marketType;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmarketChicOrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmarketSmartPrice;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.farm.carnivorous.basedata.MarketPolicyInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractMarketPolicyEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractMarketPolicyEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        //actionAudit
        this.actionAudit = new ActionAudit(this);
        getActionManager().registerAction("actionAudit", actionAudit);
        this.actionAudit.setExtendProperty("canForewarn", "true");
        this.actionAudit.setExtendProperty("userDefined", "false");
        this.actionAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionUnAudit
        this.actionUnAudit = new ActionUnAudit(this);
        getActionManager().registerAction("actionUnAudit", actionUnAudit);
        this.actionUnAudit.setExtendProperty("canForewarn", "true");
        this.actionUnAudit.setExtendProperty("userDefined", "false");
        this.actionUnAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompanyOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyieldRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcontractPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmarketType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmarketChicOrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmarketSmartPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.prmtcompanyOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtauditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtyieldRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcontractPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.marketType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtmarketChicOrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmarketSmartPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.contcompanyOrgUnit.setName("contcompanyOrgUnit");
        this.contbillStatus.setName("contbillStatus");
        this.contauditor.setName("contauditor");
        this.contauditTime.setName("contauditTime");
        this.contyieldRate.setName("contyieldRate");
        this.contcontractPrice.setName("contcontractPrice");
        this.contmarketType.setName("contmarketType");
        this.contmarketChicOrice.setName("contmarketChicOrice");
        this.contmarketSmartPrice.setName("contmarketSmartPrice");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.prmtcompanyOrgUnit.setName("prmtcompanyOrgUnit");
        this.billStatus.setName("billStatus");
        this.prmtauditor.setName("prmtauditor");
        this.pkauditTime.setName("pkauditTime");
        this.txtyieldRate.setName("txtyieldRate");
        this.txtcontractPrice.setName("txtcontractPrice");
        this.marketType.setName("marketType");
        this.txtmarketChicOrice.setName("txtmarketChicOrice");
        this.txtmarketSmartPrice.setName("txtmarketSmartPrice");
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
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelLength(100);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);
        // contcompanyOrgUnit		
        this.contcompanyOrgUnit.setBoundLabelText(resHelper.getString("contcompanyOrgUnit.boundLabelText"));		
        this.contcompanyOrgUnit.setBoundLabelLength(100);		
        this.contcompanyOrgUnit.setBoundLabelUnderline(true);		
        this.contcompanyOrgUnit.setVisible(true);
        // contbillStatus		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);
        // contauditor		
        this.contauditor.setBoundLabelText(resHelper.getString("contauditor.boundLabelText"));		
        this.contauditor.setBoundLabelLength(100);		
        this.contauditor.setBoundLabelUnderline(true);		
        this.contauditor.setVisible(true);
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // contyieldRate		
        this.contyieldRate.setBoundLabelText(resHelper.getString("contyieldRate.boundLabelText"));		
        this.contyieldRate.setBoundLabelLength(100);		
        this.contyieldRate.setBoundLabelUnderline(true);		
        this.contyieldRate.setVisible(false);
        // contcontractPrice		
        this.contcontractPrice.setBoundLabelText(resHelper.getString("contcontractPrice.boundLabelText"));		
        this.contcontractPrice.setBoundLabelLength(100);		
        this.contcontractPrice.setBoundLabelUnderline(true);		
        this.contcontractPrice.setVisible(false);
        // contmarketType		
        this.contmarketType.setBoundLabelText(resHelper.getString("contmarketType.boundLabelText"));		
        this.contmarketType.setBoundLabelLength(100);		
        this.contmarketType.setBoundLabelUnderline(true);		
        this.contmarketType.setVisible(true);
        // contmarketChicOrice		
        this.contmarketChicOrice.setBoundLabelText(resHelper.getString("contmarketChicOrice.boundLabelText"));		
        this.contmarketChicOrice.setBoundLabelLength(120);		
        this.contmarketChicOrice.setBoundLabelUnderline(true);		
        this.contmarketChicOrice.setVisible(true);
        // contmarketSmartPrice		
        this.contmarketSmartPrice.setBoundLabelText(resHelper.getString("contmarketSmartPrice.boundLabelText"));		
        this.contmarketSmartPrice.setBoundLabelLength(120);		
        this.contmarketSmartPrice.setBoundLabelUnderline(true);		
        this.contmarketSmartPrice.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // prmtcompanyOrgUnit		
        this.prmtcompanyOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompanyOrgUnit.setVisible(true);		
        this.prmtcompanyOrgUnit.setEditable(true);		
        this.prmtcompanyOrgUnit.setDisplayFormat("$name$");		
        this.prmtcompanyOrgUnit.setEditFormat("$number$");		
        this.prmtcompanyOrgUnit.setCommitFormat("$number$");		
        this.prmtcompanyOrgUnit.setRequired(false);
        // billStatus		
        this.billStatus.setVisible(true);		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // prmtauditor		
        this.prmtauditor.setQueryInfo("com.kingdee.eas.base.permission.app.UserListQuery");		
        this.prmtauditor.setVisible(true);		
        this.prmtauditor.setEditable(true);		
        this.prmtauditor.setDisplayFormat("$number$");		
        this.prmtauditor.setEditFormat("$number$");		
        this.prmtauditor.setCommitFormat("$number$");		
        this.prmtauditor.setRequired(false);		
        this.prmtauditor.setEnabled(false);
        // pkauditTime		
        this.pkauditTime.setVisible(true);		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // txtyieldRate		
        this.txtyieldRate.setVisible(false);		
        this.txtyieldRate.setHorizontalAlignment(2);		
        this.txtyieldRate.setDataType(1);		
        this.txtyieldRate.setSupportedEmpty(true);		
        this.txtyieldRate.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyieldRate.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyieldRate.setPrecision(10);		
        this.txtyieldRate.setRequired(false);
        // txtcontractPrice		
        this.txtcontractPrice.setVisible(false);		
        this.txtcontractPrice.setHorizontalAlignment(2);		
        this.txtcontractPrice.setDataType(1);		
        this.txtcontractPrice.setSupportedEmpty(true);		
        this.txtcontractPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcontractPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcontractPrice.setPrecision(4);		
        this.txtcontractPrice.setRequired(false);
        // marketType		
        this.marketType.setVisible(true);		
        this.marketType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.recyclebiz.MarketType").toArray());		
        this.marketType.setRequired(false);
        // txtmarketChicOrice		
        this.txtmarketChicOrice.setVisible(true);		
        this.txtmarketChicOrice.setHorizontalAlignment(2);		
        this.txtmarketChicOrice.setDataType(1);		
        this.txtmarketChicOrice.setSupportedEmpty(true);		
        this.txtmarketChicOrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmarketChicOrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmarketChicOrice.setPrecision(4);		
        this.txtmarketChicOrice.setRequired(false);
        // txtmarketSmartPrice		
        this.txtmarketSmartPrice.setVisible(true);		
        this.txtmarketSmartPrice.setHorizontalAlignment(2);		
        this.txtmarketSmartPrice.setDataType(1);		
        this.txtmarketSmartPrice.setSupportedEmpty(true);		
        this.txtmarketSmartPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmarketSmartPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmarketSmartPrice.setPrecision(10);		
        this.txtmarketSmartPrice.setRequired(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtcompanyOrgUnit,billStatus,prmtauditor,pkauditTime,txtyieldRate,txtcontractPrice,marketType,txtmarketChicOrice}));
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
        this.setBounds(new Rectangle(0, 0, 315, 256));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(10, 34, 270, 19));
        this.add(kDLabelContainer2, null);
        contcompanyOrgUnit.setBounds(new Rectangle(10, 58, 270, 19));
        this.add(contcompanyOrgUnit, null);
        contbillStatus.setBounds(new Rectangle(10, 113, 270, 19));
        this.add(contbillStatus, null);
        contauditor.setBounds(new Rectangle(10, 185, 270, 19));
        this.add(contauditor, null);
        contauditTime.setBounds(new Rectangle(10, 209, 270, 19));
        this.add(contauditTime, null);
        contyieldRate.setBounds(new Rectangle(292, 129, 270, 19));
        this.add(contyieldRate, null);
        contcontractPrice.setBounds(new Rectangle(292, 105, 270, 19));
        this.add(contcontractPrice, null);
        contmarketType.setBounds(new Rectangle(10, 82, 270, 19));
        this.add(contmarketType, null);
        contmarketChicOrice.setBounds(new Rectangle(10, 137, 270, 19));
        this.add(contmarketChicOrice, null);
        contmarketSmartPrice.setBounds(new Rectangle(10, 161, 270, 19));
        this.add(contmarketSmartPrice, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //contcompanyOrgUnit
        contcompanyOrgUnit.setBoundEditor(prmtcompanyOrgUnit);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //contauditor
        contauditor.setBoundEditor(prmtauditor);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contyieldRate
        contyieldRate.setBoundEditor(txtyieldRate);
        //contcontractPrice
        contcontractPrice.setBoundEditor(txtcontractPrice);
        //contmarketType
        contmarketType.setBoundEditor(marketType);
        //contmarketChicOrice
        contmarketChicOrice.setBoundEditor(txtmarketChicOrice);
        //contmarketSmartPrice
        contmarketSmartPrice.setBoundEditor(txtmarketSmartPrice);

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
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("companyOrgUnit", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompanyOrgUnit, "data");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtauditor, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("yieldRate", java.math.BigDecimal.class, this.txtyieldRate, "value");
		dataBinder.registerBinding("contractPrice", java.math.BigDecimal.class, this.txtcontractPrice, "value");
		dataBinder.registerBinding("marketType", com.kingdee.eas.farm.carnivorous.recyclebiz.MarketType.class, this.marketType, "selectedItem");
		dataBinder.registerBinding("marketChicOrice", java.math.BigDecimal.class, this.txtmarketChicOrice, "value");
		dataBinder.registerBinding("marketSmartPrice", java.math.BigDecimal.class, this.txtmarketSmartPrice, "value");		
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
	    return "com.kingdee.eas.farm.carnivorous.basedata.app.MarketPolicyEditUIHandler";
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
        this.prmtcompanyOrgUnit.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.carnivorous.basedata.MarketPolicyInfo)ov;
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
		getValidateHelper().registerBindProperty("companyOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yieldRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contractPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("marketType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("marketChicOrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("marketSmartPrice", ValidateHelper.ON_SAVE);    		
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
			sic.add(new SelectorItemInfo("companyOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("companyOrgUnit.id"));
        	sic.add(new SelectorItemInfo("companyOrgUnit.number"));
        	sic.add(new SelectorItemInfo("companyOrgUnit.name"));
		}
        sic.add(new SelectorItemInfo("billStatus"));
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
        sic.add(new SelectorItemInfo("yieldRate"));
        sic.add(new SelectorItemInfo("contractPrice"));
        sic.add(new SelectorItemInfo("marketType"));
        sic.add(new SelectorItemInfo("marketChicOrice"));
        sic.add(new SelectorItemInfo("marketSmartPrice"));
        return sic;
    }        
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.basedata.MarketPolicyFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.basedata.MarketPolicyFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractMarketPolicyEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractMarketPolicyEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.basedata.client", "MarketPolicyEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.client.MarketPolicyEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.basedata.MarketPolicyFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.basedata.MarketPolicyInfo objectValue = new com.kingdee.eas.farm.carnivorous.basedata.MarketPolicyInfo();
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
		vo.put("billStatus",new Integer(-1));
vo.put("marketType","1");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}