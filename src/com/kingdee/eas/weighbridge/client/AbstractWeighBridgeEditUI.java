/**
 * output package name
 */
package com.kingdee.eas.weighbridge.client;

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
public abstract class AbstractWeighBridgeEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractWeighBridgeEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contPort;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBaudRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contParity;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDataBits;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contStopBits;
    protected com.kingdee.bos.ctrl.swing.KDButton btnTest;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtShow;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbeginChar;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contendChar;
    protected com.kingdee.bos.ctrl.swing.KDButton btnStop;
    protected com.kingdee.bos.ctrl.swing.KDLabel labTitle;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttxtJSScript;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDComboBox Port;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtBaudRate;
    protected com.kingdee.bos.ctrl.swing.KDComboBox Parity;
    protected com.kingdee.bos.ctrl.swing.KDComboBox DataBits;
    protected com.kingdee.bos.ctrl.swing.KDComboBox StopBits;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbeginChar;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtendChar;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane scrollPanetxtJSScript;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txttxtJSScript;
    protected com.kingdee.eas.weighbridge.WeighBridgeInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractWeighBridgeEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractWeighBridgeEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contPort = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBaudRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contParity = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDataBits = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contStopBits = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnTest = new com.kingdee.bos.ctrl.swing.KDButton();
        this.txtShow = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.contbeginChar = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contendChar = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnStop = new com.kingdee.bos.ctrl.swing.KDButton();
        this.labTitle = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.conttxtJSScript = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.Port = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtBaudRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.Parity = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.DataBits = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.StopBits = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtbeginChar = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtendChar = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.scrollPanetxtJSScript = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txttxtJSScript = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contPort.setName("contPort");
        this.contBaudRate.setName("contBaudRate");
        this.contParity.setName("contParity");
        this.contDataBits.setName("contDataBits");
        this.contStopBits.setName("contStopBits");
        this.btnTest.setName("btnTest");
        this.txtShow.setName("txtShow");
        this.contbeginChar.setName("contbeginChar");
        this.contendChar.setName("contendChar");
        this.btnStop.setName("btnStop");
        this.labTitle.setName("labTitle");
        this.conttxtJSScript.setName("conttxtJSScript");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.Port.setName("Port");
        this.txtBaudRate.setName("txtBaudRate");
        this.Parity.setName("Parity");
        this.DataBits.setName("DataBits");
        this.StopBits.setName("StopBits");
        this.txtbeginChar.setName("txtbeginChar");
        this.txtendChar.setName("txtendChar");
        this.scrollPanetxtJSScript.setName("scrollPanetxtJSScript");
        this.txttxtJSScript.setName("txttxtJSScript");
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
        // contPort		
        this.contPort.setBoundLabelText(resHelper.getString("contPort.boundLabelText"));		
        this.contPort.setBoundLabelLength(100);		
        this.contPort.setBoundLabelUnderline(true);		
        this.contPort.setVisible(true);
        // contBaudRate		
        this.contBaudRate.setBoundLabelText(resHelper.getString("contBaudRate.boundLabelText"));		
        this.contBaudRate.setBoundLabelLength(100);		
        this.contBaudRate.setBoundLabelUnderline(true);		
        this.contBaudRate.setVisible(true);
        // contParity		
        this.contParity.setBoundLabelText(resHelper.getString("contParity.boundLabelText"));		
        this.contParity.setBoundLabelLength(100);		
        this.contParity.setBoundLabelUnderline(true);		
        this.contParity.setVisible(true);
        // contDataBits		
        this.contDataBits.setBoundLabelText(resHelper.getString("contDataBits.boundLabelText"));		
        this.contDataBits.setBoundLabelLength(100);		
        this.contDataBits.setBoundLabelUnderline(true);		
        this.contDataBits.setVisible(true);
        // contStopBits		
        this.contStopBits.setBoundLabelText(resHelper.getString("contStopBits.boundLabelText"));		
        this.contStopBits.setBoundLabelLength(100);		
        this.contStopBits.setBoundLabelUnderline(true);		
        this.contStopBits.setVisible(true);
        // btnTest		
        this.btnTest.setText(resHelper.getString("btnTest.text"));
        // txtShow
        // contbeginChar		
        this.contbeginChar.setBoundLabelText(resHelper.getString("contbeginChar.boundLabelText"));		
        this.contbeginChar.setBoundLabelLength(100);		
        this.contbeginChar.setBoundLabelUnderline(true);		
        this.contbeginChar.setVisible(true);
        // contendChar		
        this.contendChar.setBoundLabelText(resHelper.getString("contendChar.boundLabelText"));		
        this.contendChar.setBoundLabelLength(100);		
        this.contendChar.setBoundLabelUnderline(true);		
        this.contendChar.setVisible(true);
        // btnStop		
        this.btnStop.setText(resHelper.getString("btnStop.text"));
        // labTitle		
        this.labTitle.setText(resHelper.getString("labTitle.text"));
        // conttxtJSScript		
        this.conttxtJSScript.setBoundLabelText(resHelper.getString("conttxtJSScript.boundLabelText"));		
        this.conttxtJSScript.setBoundLabelLength(100);		
        this.conttxtJSScript.setBoundLabelUnderline(true);		
        this.conttxtJSScript.setVisible(true);		
        this.conttxtJSScript.setBoundLabelAlignment(1);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName		
        this.txtName.setRequired(true);
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);		
        this.txtSimpleName.setVisible(false);
        // txtDescription
        // Port		
        this.Port.setVisible(true);		
        this.Port.addItems(EnumUtils.getEnumList("com.kingdee.eas.weighbridge.PortNum").toArray());		
        this.Port.setRequired(true);
        // txtBaudRate		
        this.txtBaudRate.setVisible(true);		
        this.txtBaudRate.setHorizontalAlignment(2);		
        this.txtBaudRate.setDataType(0);		
        this.txtBaudRate.setSupportedEmpty(true);		
        this.txtBaudRate.setRequired(true);
        // Parity		
        this.Parity.setVisible(true);		
        this.Parity.addItems(EnumUtils.getEnumList("com.kingdee.eas.weighbridge.Parity").toArray());		
        this.Parity.setRequired(true);
        // DataBits		
        this.DataBits.setVisible(true);		
        this.DataBits.addItems(EnumUtils.getEnumList("com.kingdee.eas.weighbridge.DataBits").toArray());		
        this.DataBits.setRequired(true);
        // StopBits		
        this.StopBits.setVisible(true);		
        this.StopBits.addItems(EnumUtils.getEnumList("com.kingdee.eas.weighbridge.StopBits").toArray());		
        this.StopBits.setRequired(true);
        // txtbeginChar		
        this.txtbeginChar.setVisible(true);		
        this.txtbeginChar.setHorizontalAlignment(2);		
        this.txtbeginChar.setMaxLength(100);		
        this.txtbeginChar.setRequired(false);
        // txtendChar		
        this.txtendChar.setVisible(true);		
        this.txtendChar.setHorizontalAlignment(2);		
        this.txtendChar.setMaxLength(100);		
        this.txtendChar.setRequired(false);
        // scrollPanetxtJSScript
        // txttxtJSScript		
        this.txttxtJSScript.setVisible(true);		
        this.txttxtJSScript.setRequired(false);		
        this.txttxtJSScript.setMaxLength(500);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {Port,txtBaudRate,Parity,DataBits,StopBits,txtbeginChar,txtendChar,txttxtJSScript}));
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
        this.setBounds(new Rectangle(0, 0, 654, 400));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(35, 33, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(35, 64, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(708, 59, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(35, 95, 270, 19));
        this.add(kDLabelContainer4, null);
        contPort.setBounds(new Rectangle(35, 126, 270, 19));
        this.add(contPort, null);
        contBaudRate.setBounds(new Rectangle(35, 157, 270, 19));
        this.add(contBaudRate, null);
        contParity.setBounds(new Rectangle(35, 188, 270, 19));
        this.add(contParity, null);
        contDataBits.setBounds(new Rectangle(35, 219, 270, 19));
        this.add(contDataBits, null);
        contStopBits.setBounds(new Rectangle(35, 250, 270, 19));
        this.add(contStopBits, null);
        btnTest.setBounds(new Rectangle(472, 344, 58, 21));
        this.add(btnTest, null);
        txtShow.setBounds(new Rectangle(35, 344, 271, 19));
        this.add(txtShow, null);
        contbeginChar.setBounds(new Rectangle(35, 281, 270, 19));
        this.add(contbeginChar, null);
        contendChar.setBounds(new Rectangle(35, 312, 270, 19));
        this.add(contendChar, null);
        btnStop.setBounds(new Rectangle(562, 344, 60, 21));
        this.add(btnStop, null);
        labTitle.setBounds(new Rectangle(325, 344, 100, 19));
        this.add(labTitle, null);
        conttxtJSScript.setBounds(new Rectangle(325, 25, 297, 304));
        this.add(conttxtJSScript, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contPort
        contPort.setBoundEditor(Port);
        //contBaudRate
        contBaudRate.setBoundEditor(txtBaudRate);
        //contParity
        contParity.setBoundEditor(Parity);
        //contDataBits
        contDataBits.setBoundEditor(DataBits);
        //contStopBits
        contStopBits.setBoundEditor(StopBits);
        //contbeginChar
        contbeginChar.setBoundEditor(txtbeginChar);
        //contendChar
        contendChar.setBoundEditor(txtendChar);
        //conttxtJSScript
        conttxtJSScript.setBoundEditor(scrollPanetxtJSScript);
        //scrollPanetxtJSScript
        scrollPanetxtJSScript.getViewport().add(txttxtJSScript, null);

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
		dataBinder.registerBinding("Port", com.kingdee.eas.weighbridge.PortNum.class, this.Port, "selectedItem");
		dataBinder.registerBinding("BaudRate", int.class, this.txtBaudRate, "value");
		dataBinder.registerBinding("Parity", com.kingdee.eas.weighbridge.Parity.class, this.Parity, "selectedItem");
		dataBinder.registerBinding("DataBits", com.kingdee.eas.weighbridge.DataBits.class, this.DataBits, "selectedItem");
		dataBinder.registerBinding("StopBits", com.kingdee.eas.weighbridge.StopBits.class, this.StopBits, "selectedItem");
		dataBinder.registerBinding("beginChar", String.class, this.txtbeginChar, "text");
		dataBinder.registerBinding("endChar", String.class, this.txtendChar, "text");
		dataBinder.registerBinding("txtJSScript", String.class, this.txttxtJSScript, "text");		
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
	    return "com.kingdee.eas.weighbridge.app.WeighBridgeEditUIHandler";
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
        this.Port.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.weighbridge.WeighBridgeInfo)ov;
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
		getValidateHelper().registerBindProperty("Port", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BaudRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Parity", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DataBits", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StopBits", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("beginChar", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("endChar", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("txtJSScript", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("Port"));
        sic.add(new SelectorItemInfo("BaudRate"));
        sic.add(new SelectorItemInfo("Parity"));
        sic.add(new SelectorItemInfo("DataBits"));
        sic.add(new SelectorItemInfo("StopBits"));
        sic.add(new SelectorItemInfo("beginChar"));
        sic.add(new SelectorItemInfo("endChar"));
        sic.add(new SelectorItemInfo("txtJSScript"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.weighbridge.client", "WeighBridgeEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.weighbridge.client.WeighBridgeEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.weighbridge.WeighBridgeFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.weighbridge.WeighBridgeInfo objectValue = new com.kingdee.eas.weighbridge.WeighBridgeInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtName.getItemDataByLang(new LanguageInfo(com.kingdee.eas.common.client.SysContext.getSysContext().getLocale())))) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"名称"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(Port.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"端口"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtBaudRate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"波特率"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(Parity.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"奇偶校验"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(DataBits.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"数据位"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(StopBits.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"停止位"});
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
		vo.put("Port","0");
		vo.put("BaudRate",new Integer(2400));
vo.put("Parity","0");
vo.put("DataBits","5");
vo.put("StopBits","1");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}