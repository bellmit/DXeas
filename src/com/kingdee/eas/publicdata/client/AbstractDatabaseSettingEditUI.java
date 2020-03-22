/**
 * output package name
 */
package com.kingdee.eas.publicdata.client;

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
public abstract class AbstractDatabaseSettingEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractDatabaseSettingEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdbType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdbFileAddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contuserName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpassword;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contorgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdbIP;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdbName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdbPort;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdbNameJS;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBIMUDF0012;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDComboBox dbType;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdbFileAddress;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtuserName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpassword;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtorgUnit;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdbIP;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdbName;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdbPort;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane scrollPanedbNameJS;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtdbNameJS;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtBIMUDF0012;
    protected com.kingdee.eas.publicdata.DatabaseSettingInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractDatabaseSettingEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractDatabaseSettingEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdbType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdbFileAddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contuserName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpassword = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contorgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdbIP = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdbName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdbPort = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdbNameJS = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBIMUDF0012 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.dbType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtdbFileAddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtuserName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtpassword = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtorgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtdbIP = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtdbName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtdbPort = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.scrollPanedbNameJS = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txtdbNameJS = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.txtBIMUDF0012 = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contdbType.setName("contdbType");
        this.contdbFileAddress.setName("contdbFileAddress");
        this.contuserName.setName("contuserName");
        this.contpassword.setName("contpassword");
        this.contorgUnit.setName("contorgUnit");
        this.contdbIP.setName("contdbIP");
        this.contdbName.setName("contdbName");
        this.contdbPort.setName("contdbPort");
        this.contdbNameJS.setName("contdbNameJS");
        this.contBIMUDF0012.setName("contBIMUDF0012");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.dbType.setName("dbType");
        this.txtdbFileAddress.setName("txtdbFileAddress");
        this.txtuserName.setName("txtuserName");
        this.txtpassword.setName("txtpassword");
        this.prmtorgUnit.setName("prmtorgUnit");
        this.txtdbIP.setName("txtdbIP");
        this.txtdbName.setName("txtdbName");
        this.txtdbPort.setName("txtdbPort");
        this.scrollPanedbNameJS.setName("scrollPanedbNameJS");
        this.txtdbNameJS.setName("txtdbNameJS");
        this.txtBIMUDF0012.setName("txtBIMUDF0012");
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
        // contdbType		
        this.contdbType.setBoundLabelText(resHelper.getString("contdbType.boundLabelText"));		
        this.contdbType.setBoundLabelLength(100);		
        this.contdbType.setBoundLabelUnderline(true);		
        this.contdbType.setVisible(true);
        // contdbFileAddress		
        this.contdbFileAddress.setBoundLabelText(resHelper.getString("contdbFileAddress.boundLabelText"));		
        this.contdbFileAddress.setBoundLabelLength(100);		
        this.contdbFileAddress.setBoundLabelUnderline(true);		
        this.contdbFileAddress.setVisible(true);
        // contuserName		
        this.contuserName.setBoundLabelText(resHelper.getString("contuserName.boundLabelText"));		
        this.contuserName.setBoundLabelLength(100);		
        this.contuserName.setBoundLabelUnderline(true);		
        this.contuserName.setVisible(true);
        // contpassword		
        this.contpassword.setBoundLabelText(resHelper.getString("contpassword.boundLabelText"));		
        this.contpassword.setBoundLabelLength(100);		
        this.contpassword.setBoundLabelUnderline(true);		
        this.contpassword.setVisible(true);
        // contorgUnit		
        this.contorgUnit.setBoundLabelText(resHelper.getString("contorgUnit.boundLabelText"));		
        this.contorgUnit.setBoundLabelLength(100);		
        this.contorgUnit.setBoundLabelUnderline(true);		
        this.contorgUnit.setVisible(true);
        // contdbIP		
        this.contdbIP.setBoundLabelText(resHelper.getString("contdbIP.boundLabelText"));		
        this.contdbIP.setBoundLabelLength(100);		
        this.contdbIP.setBoundLabelUnderline(true);		
        this.contdbIP.setVisible(true);
        // contdbName		
        this.contdbName.setBoundLabelText(resHelper.getString("contdbName.boundLabelText"));		
        this.contdbName.setBoundLabelLength(100);		
        this.contdbName.setBoundLabelUnderline(true);		
        this.contdbName.setVisible(true);
        // contdbPort		
        this.contdbPort.setBoundLabelText(resHelper.getString("contdbPort.boundLabelText"));		
        this.contdbPort.setBoundLabelLength(100);		
        this.contdbPort.setBoundLabelUnderline(true);		
        this.contdbPort.setVisible(true);
        // contdbNameJS		
        this.contdbNameJS.setBoundLabelText(resHelper.getString("contdbNameJS.boundLabelText"));		
        this.contdbNameJS.setBoundLabelLength(100);		
        this.contdbNameJS.setBoundLabelUnderline(true);		
        this.contdbNameJS.setVisible(true);
        // contBIMUDF0012		
        this.contBIMUDF0012.setBoundLabelText(resHelper.getString("contBIMUDF0012.boundLabelText"));		
        this.contBIMUDF0012.setBoundLabelLength(100);		
        this.contBIMUDF0012.setBoundLabelUnderline(true);		
        this.contBIMUDF0012.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName		
        this.txtName.setRequired(true);
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);		
        this.txtSimpleName.setVisible(false);
        // txtDescription		
        this.txtDescription.setVisible(false);
        // dbType		
        this.dbType.setVisible(true);		
        this.dbType.addItems(EnumUtils.getEnumList("com.kingdee.eas.publicdata.dbType").toArray());		
        this.dbType.setRequired(true);
        // txtdbFileAddress		
        this.txtdbFileAddress.setVisible(true);		
        this.txtdbFileAddress.setHorizontalAlignment(2);		
        this.txtdbFileAddress.setMaxLength(200);		
        this.txtdbFileAddress.setRequired(false);
        // txtuserName		
        this.txtuserName.setVisible(true);		
        this.txtuserName.setHorizontalAlignment(2);		
        this.txtuserName.setMaxLength(100);		
        this.txtuserName.setRequired(false);
        // txtpassword		
        this.txtpassword.setVisible(true);		
        this.txtpassword.setHorizontalAlignment(2);		
        this.txtpassword.setMaxLength(100);		
        this.txtpassword.setRequired(false);
        // prmtorgUnit		
        this.prmtorgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtorgUnit.setVisible(true);		
        this.prmtorgUnit.setEditable(true);		
        this.prmtorgUnit.setDisplayFormat("$name$");		
        this.prmtorgUnit.setEditFormat("$number$");		
        this.prmtorgUnit.setCommitFormat("$number$");		
        this.prmtorgUnit.setRequired(true);
        // txtdbIP		
        this.txtdbIP.setVisible(true);		
        this.txtdbIP.setHorizontalAlignment(2);		
        this.txtdbIP.setMaxLength(100);		
        this.txtdbIP.setRequired(false);
        // txtdbName		
        this.txtdbName.setVisible(true);		
        this.txtdbName.setHorizontalAlignment(2);		
        this.txtdbName.setMaxLength(100);		
        this.txtdbName.setRequired(false);
        // txtdbPort		
        this.txtdbPort.setVisible(true);		
        this.txtdbPort.setHorizontalAlignment(2);		
        this.txtdbPort.setDataType(0);		
        this.txtdbPort.setSupportedEmpty(true);		
        this.txtdbPort.setRequired(false);
        // scrollPanedbNameJS
        // txtdbNameJS		
        this.txtdbNameJS.setVisible(true);		
        this.txtdbNameJS.setRequired(false);		
        this.txtdbNameJS.setMaxLength(500);
        // txtBIMUDF0012		
        this.txtBIMUDF0012.setVisible(false);		
        this.txtBIMUDF0012.setHorizontalAlignment(2);		
        this.txtBIMUDF0012.setMaxLength(100);		
        this.txtBIMUDF0012.setRequired(false);		
        this.txtBIMUDF0012.setEnabled(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {dbType,txtdbFileAddress,txtuserName,txtpassword,prmtorgUnit,txtdbIP,txtdbName,txtdbPort,txtdbNameJS}));
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
        this.setBounds(new Rectangle(0, 0, 620, 359));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(30, 52, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(322, 51, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(643, 120, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(643, 157, 270, 19));
        this.add(kDLabelContainer4, null);
        contdbType.setBounds(new Rectangle(322, 108, 270, 19));
        this.add(contdbType, null);
        contdbFileAddress.setBounds(new Rectangle(30, 166, 562, 19));
        this.add(contdbFileAddress, null);
        contuserName.setBounds(new Rectangle(30, 282, 270, 19));
        this.add(contuserName, null);
        contpassword.setBounds(new Rectangle(322, 279, 270, 19));
        this.add(contpassword, null);
        contorgUnit.setBounds(new Rectangle(30, 109, 270, 19));
        this.add(contorgUnit, null);
        contdbIP.setBounds(new Rectangle(30, 166, 270, 19));
        this.add(contdbIP, null);
        contdbName.setBounds(new Rectangle(30, 223, 270, 19));
        this.add(contdbName, null);
        contdbPort.setBounds(new Rectangle(322, 166, 270, 19));
        this.add(contdbPort, null);
        contdbNameJS.setBounds(new Rectangle(322, 223, 270, 19));
        this.add(contdbNameJS, null);
        contBIMUDF0012.setBounds(new Rectangle(339, 323, 270, 19));
        this.add(contBIMUDF0012, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contdbType
        contdbType.setBoundEditor(dbType);
        //contdbFileAddress
        contdbFileAddress.setBoundEditor(txtdbFileAddress);
        //contuserName
        contuserName.setBoundEditor(txtuserName);
        //contpassword
        contpassword.setBoundEditor(txtpassword);
        //contorgUnit
        contorgUnit.setBoundEditor(prmtorgUnit);
        //contdbIP
        contdbIP.setBoundEditor(txtdbIP);
        //contdbName
        contdbName.setBoundEditor(txtdbName);
        //contdbPort
        contdbPort.setBoundEditor(txtdbPort);
        //contdbNameJS
        contdbNameJS.setBoundEditor(scrollPanedbNameJS);
        //scrollPanedbNameJS
        scrollPanedbNameJS.getViewport().add(txtdbNameJS, null);
        //contBIMUDF0012
        contBIMUDF0012.setBoundEditor(txtBIMUDF0012);

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
		dataBinder.registerBinding("dbType", com.kingdee.eas.publicdata.dbType.class, this.dbType, "selectedItem");
		dataBinder.registerBinding("dbFileAddress", String.class, this.txtdbFileAddress, "text");
		dataBinder.registerBinding("userName", String.class, this.txtuserName, "text");
		dataBinder.registerBinding("password", String.class, this.txtpassword, "text");
		dataBinder.registerBinding("orgUnit", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtorgUnit, "data");
		dataBinder.registerBinding("dbIP", String.class, this.txtdbIP, "text");
		dataBinder.registerBinding("dbName", String.class, this.txtdbName, "text");
		dataBinder.registerBinding("dbPort", int.class, this.txtdbPort, "value");
		dataBinder.registerBinding("dbNameJS", String.class, this.txtdbNameJS, "text");
		dataBinder.registerBinding("BIMUDF0012", String.class, this.txtBIMUDF0012, "text");		
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
	    return "com.kingdee.eas.publicdata.app.DatabaseSettingEditUIHandler";
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
        this.dbType.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.publicdata.DatabaseSettingInfo)ov;
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
		getValidateHelper().registerBindProperty("dbType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dbFileAddress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("userName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("password", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("orgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dbIP", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dbName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dbPort", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dbNameJS", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BIMUDF0012", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("dbType"));
        sic.add(new SelectorItemInfo("dbFileAddress"));
        sic.add(new SelectorItemInfo("userName"));
        sic.add(new SelectorItemInfo("password"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("orgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("orgUnit.id"));
        	sic.add(new SelectorItemInfo("orgUnit.number"));
        	sic.add(new SelectorItemInfo("orgUnit.name"));
		}
        sic.add(new SelectorItemInfo("dbIP"));
        sic.add(new SelectorItemInfo("dbName"));
        sic.add(new SelectorItemInfo("dbPort"));
        sic.add(new SelectorItemInfo("dbNameJS"));
        sic.add(new SelectorItemInfo("BIMUDF0012"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.publicdata.client", "DatabaseSettingEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.publicdata.client.DatabaseSettingEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.publicdata.DatabaseSettingFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.publicdata.DatabaseSettingInfo objectValue = new com.kingdee.eas.publicdata.DatabaseSettingInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtName.getItemDataByLang(new LanguageInfo(com.kingdee.eas.common.client.SysContext.getSysContext().getLocale())))) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"名称"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(dbType.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"数据库类型"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtorgUnit.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"组织"});
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
		vo.put("dbType","4");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}