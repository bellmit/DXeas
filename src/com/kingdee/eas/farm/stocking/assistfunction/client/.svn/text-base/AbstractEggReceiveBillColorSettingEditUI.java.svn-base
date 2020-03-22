/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.assistfunction.client;

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
public abstract class AbstractEggReceiveBillColorSettingEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractEggReceiveBillColorSettingEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmeiQtyR;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmeiQtyG;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmeiQtyB;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contwgtR;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contwgtG;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contwgtB;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contavgWgtR;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contavgWgtG;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contavgWgtB;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contuser;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmeiQtyR;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmeiQtyG;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmeiQtyB;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtwgtR;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtwgtG;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtwgtB;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtavgWgtR;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtavgWgtG;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtavgWgtB;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtuser;
    protected com.kingdee.eas.farm.stocking.assistfunction.EggReceiveBillColorSettingInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractEggReceiveBillColorSettingEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractEggReceiveBillColorSettingEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmeiQtyR = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmeiQtyG = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmeiQtyB = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contwgtR = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contwgtG = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contwgtB = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contavgWgtR = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contavgWgtG = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contavgWgtB = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contuser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtmeiQtyR = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmeiQtyG = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmeiQtyB = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtwgtR = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtwgtG = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtwgtB = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtavgWgtR = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtavgWgtG = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtavgWgtB = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtuser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.contmeiQtyR.setName("contmeiQtyR");
        this.contmeiQtyG.setName("contmeiQtyG");
        this.contmeiQtyB.setName("contmeiQtyB");
        this.contwgtR.setName("contwgtR");
        this.contwgtG.setName("contwgtG");
        this.contwgtB.setName("contwgtB");
        this.contavgWgtR.setName("contavgWgtR");
        this.contavgWgtG.setName("contavgWgtG");
        this.contavgWgtB.setName("contavgWgtB");
        this.contuser.setName("contuser");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtmeiQtyR.setName("txtmeiQtyR");
        this.txtmeiQtyG.setName("txtmeiQtyG");
        this.txtmeiQtyB.setName("txtmeiQtyB");
        this.txtwgtR.setName("txtwgtR");
        this.txtwgtG.setName("txtwgtG");
        this.txtwgtB.setName("txtwgtB");
        this.txtavgWgtR.setName("txtavgWgtR");
        this.txtavgWgtG.setName("txtavgWgtG");
        this.txtavgWgtB.setName("txtavgWgtB");
        this.prmtuser.setName("prmtuser");
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
        // contmeiQtyR		
        this.contmeiQtyR.setBoundLabelText(resHelper.getString("contmeiQtyR.boundLabelText"));		
        this.contmeiQtyR.setBoundLabelLength(100);		
        this.contmeiQtyR.setBoundLabelUnderline(true);		
        this.contmeiQtyR.setVisible(true);
        // contmeiQtyG		
        this.contmeiQtyG.setBoundLabelText(resHelper.getString("contmeiQtyG.boundLabelText"));		
        this.contmeiQtyG.setBoundLabelLength(100);		
        this.contmeiQtyG.setBoundLabelUnderline(true);		
        this.contmeiQtyG.setVisible(true);
        // contmeiQtyB		
        this.contmeiQtyB.setBoundLabelText(resHelper.getString("contmeiQtyB.boundLabelText"));		
        this.contmeiQtyB.setBoundLabelLength(100);		
        this.contmeiQtyB.setBoundLabelUnderline(true);		
        this.contmeiQtyB.setVisible(true);
        // contwgtR		
        this.contwgtR.setBoundLabelText(resHelper.getString("contwgtR.boundLabelText"));		
        this.contwgtR.setBoundLabelLength(100);		
        this.contwgtR.setBoundLabelUnderline(true);		
        this.contwgtR.setVisible(true);
        // contwgtG		
        this.contwgtG.setBoundLabelText(resHelper.getString("contwgtG.boundLabelText"));		
        this.contwgtG.setBoundLabelLength(100);		
        this.contwgtG.setBoundLabelUnderline(true);		
        this.contwgtG.setVisible(true);
        // contwgtB		
        this.contwgtB.setBoundLabelText(resHelper.getString("contwgtB.boundLabelText"));		
        this.contwgtB.setBoundLabelLength(100);		
        this.contwgtB.setBoundLabelUnderline(true);		
        this.contwgtB.setVisible(true);
        // contavgWgtR		
        this.contavgWgtR.setBoundLabelText(resHelper.getString("contavgWgtR.boundLabelText"));		
        this.contavgWgtR.setBoundLabelLength(100);		
        this.contavgWgtR.setBoundLabelUnderline(true);		
        this.contavgWgtR.setVisible(true);
        // contavgWgtG		
        this.contavgWgtG.setBoundLabelText(resHelper.getString("contavgWgtG.boundLabelText"));		
        this.contavgWgtG.setBoundLabelLength(100);		
        this.contavgWgtG.setBoundLabelUnderline(true);		
        this.contavgWgtG.setVisible(true);
        // contavgWgtB		
        this.contavgWgtB.setBoundLabelText(resHelper.getString("contavgWgtB.boundLabelText"));		
        this.contavgWgtB.setBoundLabelLength(100);		
        this.contavgWgtB.setBoundLabelUnderline(true);		
        this.contavgWgtB.setVisible(true);
        // contuser		
        this.contuser.setBoundLabelText(resHelper.getString("contuser.boundLabelText"));		
        this.contuser.setBoundLabelLength(100);		
        this.contuser.setBoundLabelUnderline(true);		
        this.contuser.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtmeiQtyR		
        this.txtmeiQtyR.setVisible(true);		
        this.txtmeiQtyR.setHorizontalAlignment(2);		
        this.txtmeiQtyR.setDataType(0);		
        this.txtmeiQtyR.setSupportedEmpty(true);		
        this.txtmeiQtyR.setRequired(false);
        // txtmeiQtyG		
        this.txtmeiQtyG.setVisible(true);		
        this.txtmeiQtyG.setHorizontalAlignment(2);		
        this.txtmeiQtyG.setDataType(0);		
        this.txtmeiQtyG.setSupportedEmpty(true);		
        this.txtmeiQtyG.setRequired(false);
        // txtmeiQtyB		
        this.txtmeiQtyB.setVisible(true);		
        this.txtmeiQtyB.setHorizontalAlignment(2);		
        this.txtmeiQtyB.setDataType(0);		
        this.txtmeiQtyB.setSupportedEmpty(true);		
        this.txtmeiQtyB.setRequired(false);
        // txtwgtR		
        this.txtwgtR.setVisible(true);		
        this.txtwgtR.setHorizontalAlignment(2);		
        this.txtwgtR.setDataType(0);		
        this.txtwgtR.setSupportedEmpty(true);		
        this.txtwgtR.setRequired(false);
        // txtwgtG		
        this.txtwgtG.setVisible(true);		
        this.txtwgtG.setHorizontalAlignment(2);		
        this.txtwgtG.setDataType(0);		
        this.txtwgtG.setSupportedEmpty(true);		
        this.txtwgtG.setRequired(false);
        // txtwgtB		
        this.txtwgtB.setVisible(true);		
        this.txtwgtB.setHorizontalAlignment(2);		
        this.txtwgtB.setDataType(0);		
        this.txtwgtB.setSupportedEmpty(true);		
        this.txtwgtB.setRequired(false);
        // txtavgWgtR		
        this.txtavgWgtR.setVisible(true);		
        this.txtavgWgtR.setHorizontalAlignment(2);		
        this.txtavgWgtR.setDataType(0);		
        this.txtavgWgtR.setSupportedEmpty(true);		
        this.txtavgWgtR.setRequired(false);
        // txtavgWgtG		
        this.txtavgWgtG.setVisible(true);		
        this.txtavgWgtG.setHorizontalAlignment(2);		
        this.txtavgWgtG.setDataType(0);		
        this.txtavgWgtG.setSupportedEmpty(true);		
        this.txtavgWgtG.setRequired(false);
        // txtavgWgtB		
        this.txtavgWgtB.setVisible(true);		
        this.txtavgWgtB.setHorizontalAlignment(2);		
        this.txtavgWgtB.setDataType(0);		
        this.txtavgWgtB.setSupportedEmpty(true);		
        this.txtavgWgtB.setRequired(false);
        // prmtuser		
        this.prmtuser.setQueryInfo("com.kingdee.eas.base.permission.app.UserListQuery");		
        this.prmtuser.setVisible(true);		
        this.prmtuser.setEditable(true);		
        this.prmtuser.setDisplayFormat("$number$");		
        this.prmtuser.setEditFormat("$number$");		
        this.prmtuser.setCommitFormat("$number$");		
        this.prmtuser.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtmeiQtyR,txtmeiQtyG,txtmeiQtyB,txtwgtR,txtwgtG,txtwgtB,txtavgWgtR,txtavgWgtG,txtavgWgtB,prmtuser}));
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
        this.setBounds(new Rectangle(0, 0, 339, 428));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(34, 24, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(34, 56, 270, 19));
        this.add(kDLabelContainer2, null);
        contmeiQtyR.setBounds(new Rectangle(34, 88, 270, 19));
        this.add(contmeiQtyR, null);
        contmeiQtyG.setBounds(new Rectangle(34, 120, 270, 19));
        this.add(contmeiQtyG, null);
        contmeiQtyB.setBounds(new Rectangle(34, 152, 270, 19));
        this.add(contmeiQtyB, null);
        contwgtR.setBounds(new Rectangle(34, 184, 270, 19));
        this.add(contwgtR, null);
        contwgtG.setBounds(new Rectangle(34, 216, 270, 19));
        this.add(contwgtG, null);
        contwgtB.setBounds(new Rectangle(34, 248, 270, 19));
        this.add(contwgtB, null);
        contavgWgtR.setBounds(new Rectangle(34, 280, 270, 19));
        this.add(contavgWgtR, null);
        contavgWgtG.setBounds(new Rectangle(34, 312, 270, 19));
        this.add(contavgWgtG, null);
        contavgWgtB.setBounds(new Rectangle(34, 347, 270, 19));
        this.add(contavgWgtB, null);
        contuser.setBounds(new Rectangle(34, 386, 270, 19));
        this.add(contuser, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //contmeiQtyR
        contmeiQtyR.setBoundEditor(txtmeiQtyR);
        //contmeiQtyG
        contmeiQtyG.setBoundEditor(txtmeiQtyG);
        //contmeiQtyB
        contmeiQtyB.setBoundEditor(txtmeiQtyB);
        //contwgtR
        contwgtR.setBoundEditor(txtwgtR);
        //contwgtG
        contwgtG.setBoundEditor(txtwgtG);
        //contwgtB
        contwgtB.setBoundEditor(txtwgtB);
        //contavgWgtR
        contavgWgtR.setBoundEditor(txtavgWgtR);
        //contavgWgtG
        contavgWgtG.setBoundEditor(txtavgWgtG);
        //contavgWgtB
        contavgWgtB.setBoundEditor(txtavgWgtB);
        //contuser
        contuser.setBoundEditor(prmtuser);

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
		dataBinder.registerBinding("meiQtyR", int.class, this.txtmeiQtyR, "value");
		dataBinder.registerBinding("meiQtyG", int.class, this.txtmeiQtyG, "value");
		dataBinder.registerBinding("meiQtyB", int.class, this.txtmeiQtyB, "value");
		dataBinder.registerBinding("wgtR", int.class, this.txtwgtR, "value");
		dataBinder.registerBinding("wgtG", int.class, this.txtwgtG, "value");
		dataBinder.registerBinding("wgtB", int.class, this.txtwgtB, "value");
		dataBinder.registerBinding("avgWgtR", int.class, this.txtavgWgtR, "value");
		dataBinder.registerBinding("avgWgtG", int.class, this.txtavgWgtG, "value");
		dataBinder.registerBinding("avgWgtB", int.class, this.txtavgWgtB, "value");
		dataBinder.registerBinding("user", com.kingdee.eas.base.permission.UserInfo.class, this.prmtuser, "data");		
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
	    return "com.kingdee.eas.farm.stocking.assistfunction.app.EggReceiveBillColorSettingEditUIHandler";
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
        this.txtmeiQtyR.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.stocking.assistfunction.EggReceiveBillColorSettingInfo)ov;
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
		getValidateHelper().registerBindProperty("meiQtyR", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("meiQtyG", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("meiQtyB", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("wgtR", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("wgtG", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("wgtB", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("avgWgtR", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("avgWgtG", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("avgWgtB", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("user", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("meiQtyR"));
        sic.add(new SelectorItemInfo("meiQtyG"));
        sic.add(new SelectorItemInfo("meiQtyB"));
        sic.add(new SelectorItemInfo("wgtR"));
        sic.add(new SelectorItemInfo("wgtG"));
        sic.add(new SelectorItemInfo("wgtB"));
        sic.add(new SelectorItemInfo("avgWgtR"));
        sic.add(new SelectorItemInfo("avgWgtG"));
        sic.add(new SelectorItemInfo("avgWgtB"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("user.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("user.id"));
        	sic.add(new SelectorItemInfo("user.number"));
        	sic.add(new SelectorItemInfo("user.name"));
		}
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.stocking.assistfunction.client", "EggReceiveBillColorSettingEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.stocking.assistfunction.client.EggReceiveBillColorSettingEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.assistfunction.EggReceiveBillColorSettingFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.assistfunction.EggReceiveBillColorSettingInfo objectValue = new com.kingdee.eas.farm.stocking.assistfunction.EggReceiveBillColorSettingInfo();
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
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}