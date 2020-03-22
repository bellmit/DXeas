/**
 * output package name
 */
package com.kingdee.eas.farm.dayratecost.client;

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
public abstract class AbstractDayRateBaseSettingEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractDayRateBaseSettingEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcurrentPeriod;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisInit;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contintPeroid;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcurrentPeriod;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contseedMateiral;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contseedCostItem;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtseedMateiral;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtseedCostItem;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfullWorkQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfullWorkQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtintPeroid;
    protected com.kingdee.eas.farm.dayratecost.DayRateBaseSettingInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractDayRateBaseSettingEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractDayRateBaseSettingEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcurrentPeriod = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisInit = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contintPeroid = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcurrentPeriod = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contseedMateiral = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contseedCostItem = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtseedMateiral = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtseedCostItem = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.contfullWorkQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtfullWorkQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtintPeroid = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contcompany.setName("contcompany");
        this.contcurrentPeriod.setName("contcurrentPeriod");
        this.chkisInit.setName("chkisInit");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contintPeroid.setName("contintPeroid");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.prmtcompany.setName("prmtcompany");
        this.prmtcurrentPeriod.setName("prmtcurrentPeriod");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.contseedMateiral.setName("contseedMateiral");
        this.contseedCostItem.setName("contseedCostItem");
        this.prmtseedMateiral.setName("prmtseedMateiral");
        this.prmtseedCostItem.setName("prmtseedCostItem");
        this.contfullWorkQty.setName("contfullWorkQty");
        this.txtfullWorkQty.setName("txtfullWorkQty");
        this.prmtintPeroid.setName("prmtintPeroid");
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
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contcurrentPeriod		
        this.contcurrentPeriod.setBoundLabelText(resHelper.getString("contcurrentPeriod.boundLabelText"));		
        this.contcurrentPeriod.setBoundLabelLength(100);		
        this.contcurrentPeriod.setBoundLabelUnderline(true);		
        this.contcurrentPeriod.setVisible(true);
        // chkisInit		
        this.chkisInit.setText(resHelper.getString("chkisInit.text"));		
        this.chkisInit.setVisible(true);		
        this.chkisInit.setHorizontalAlignment(2);		
        this.chkisInit.setEnabled(false);
        // kDTabbedPane1
        // contintPeroid		
        this.contintPeroid.setBoundLabelText(resHelper.getString("contintPeroid.boundLabelText"));		
        this.contintPeroid.setBoundLabelLength(100);		
        this.contintPeroid.setBoundLabelUnderline(true);		
        this.contintPeroid.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setVisible(true);		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
        // prmtcurrentPeriod		
        this.prmtcurrentPeriod.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7PeriodQuery");		
        this.prmtcurrentPeriod.setVisible(true);		
        this.prmtcurrentPeriod.setEditable(true);		
        this.prmtcurrentPeriod.setDisplayFormat("$number$");		
        this.prmtcurrentPeriod.setEditFormat("$number$");		
        this.prmtcurrentPeriod.setCommitFormat("$number$");		
        this.prmtcurrentPeriod.setRequired(false);		
        this.prmtcurrentPeriod.setEnabled(false);
        // kDPanel1
        // kDPanel2
        // contseedMateiral		
        this.contseedMateiral.setBoundLabelText(resHelper.getString("contseedMateiral.boundLabelText"));		
        this.contseedMateiral.setBoundLabelLength(100);		
        this.contseedMateiral.setBoundLabelUnderline(true);		
        this.contseedMateiral.setVisible(true);
        // contseedCostItem		
        this.contseedCostItem.setBoundLabelText(resHelper.getString("contseedCostItem.boundLabelText"));		
        this.contseedCostItem.setBoundLabelLength(100);		
        this.contseedCostItem.setBoundLabelUnderline(true);		
        this.contseedCostItem.setVisible(true);
        // prmtseedMateiral		
        this.prmtseedMateiral.setQueryInfo("com.kingdee.eas.basedata.master.material.app.MaterialQuery");		
        this.prmtseedMateiral.setVisible(true);		
        this.prmtseedMateiral.setEditable(true);		
        this.prmtseedMateiral.setDisplayFormat("$number$");		
        this.prmtseedMateiral.setEditFormat("$number$");		
        this.prmtseedMateiral.setCommitFormat("$number$");		
        this.prmtseedMateiral.setRequired(true);
        // prmtseedCostItem		
        this.prmtseedCostItem.setQueryInfo("com.kingdee.eas.basedata.cm.app.CostItemListQuery");		
        this.prmtseedCostItem.setVisible(true);		
        this.prmtseedCostItem.setEditable(true);		
        this.prmtseedCostItem.setDisplayFormat("$name$");		
        this.prmtseedCostItem.setEditFormat("$number$");		
        this.prmtseedCostItem.setCommitFormat("$number$");		
        this.prmtseedCostItem.setRequired(true);
        // contfullWorkQty		
        this.contfullWorkQty.setBoundLabelText(resHelper.getString("contfullWorkQty.boundLabelText"));		
        this.contfullWorkQty.setBoundLabelLength(100);		
        this.contfullWorkQty.setBoundLabelUnderline(true);		
        this.contfullWorkQty.setVisible(true);
        // txtfullWorkQty		
        this.txtfullWorkQty.setVisible(true);		
        this.txtfullWorkQty.setHorizontalAlignment(2);		
        this.txtfullWorkQty.setDataType(0);		
        this.txtfullWorkQty.setSupportedEmpty(true);		
        this.txtfullWorkQty.setRequired(true);
        // prmtintPeroid		
        this.prmtintPeroid.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7PeriodQuery");		
        this.prmtintPeroid.setVisible(true);		
        this.prmtintPeroid.setEditable(true);		
        this.prmtintPeroid.setDisplayFormat("$number$");		
        this.prmtintPeroid.setEditFormat("$number$");		
        this.prmtintPeroid.setCommitFormat("$number$");		
        this.prmtintPeroid.setRequired(false);		
        this.prmtintPeroid.setEnabled(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtcompany,prmtcurrentPeriod,chkisInit,prmtseedMateiral,prmtseedCostItem,txtfullWorkQty,prmtintPeroid}));
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
        this.setBounds(new Rectangle(0, 0, 643, 339));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(41, 43, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(341, 43, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(686, 64, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(677, 19, 270, 19));
        this.add(kDLabelContainer4, null);
        contcompany.setBounds(new Rectangle(41, 79, 270, 19));
        this.add(contcompany, null);
        contcurrentPeriod.setBounds(new Rectangle(341, 79, 270, 19));
        this.add(contcurrentPeriod, null);
        chkisInit.setBounds(new Rectangle(41, 112, 270, 19));
        this.add(chkisInit, null);
        kDTabbedPane1.setBounds(new Rectangle(36, 138, 573, 168));
        this.add(kDTabbedPane1, null);
        contintPeroid.setBounds(new Rectangle(341, 112, 270, 19));
        this.add(contintPeroid, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contcurrentPeriod
        contcurrentPeriod.setBoundEditor(prmtcurrentPeriod);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //kDPanel1
        kDPanel1.setLayout(null);        contseedMateiral.setBounds(new Rectangle(10, 6, 270, 19));
        kDPanel1.add(contseedMateiral, null);
        contseedCostItem.setBounds(new Rectangle(10, 34, 270, 19));
        kDPanel1.add(contseedCostItem, null);
        //contseedMateiral
        contseedMateiral.setBoundEditor(prmtseedMateiral);
        //contseedCostItem
        contseedCostItem.setBoundEditor(prmtseedCostItem);
        //kDPanel2
        kDPanel2.setLayout(null);        contfullWorkQty.setBounds(new Rectangle(17, 19, 270, 19));
        kDPanel2.add(contfullWorkQty, null);
        //contfullWorkQty
        contfullWorkQty.setBoundEditor(txtfullWorkQty);
        //contintPeroid
        contintPeroid.setBoundEditor(prmtintPeroid);

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
		dataBinder.registerBinding("isInit", boolean.class, this.chkisInit, "selected");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("currentPeriod", com.kingdee.eas.basedata.assistant.PeriodInfo.class, this.prmtcurrentPeriod, "data");
		dataBinder.registerBinding("seedMateiral", com.kingdee.eas.basedata.master.material.MaterialInfo.class, this.prmtseedMateiral, "data");
		dataBinder.registerBinding("seedCostItem", com.kingdee.eas.basedata.cm.CostItemInfo.class, this.prmtseedCostItem, "data");
		dataBinder.registerBinding("fullWorkQty", int.class, this.txtfullWorkQty, "value");
		dataBinder.registerBinding("intPeroid", com.kingdee.eas.basedata.assistant.PeriodInfo.class, this.prmtintPeroid, "data");		
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
	    return "com.kingdee.eas.farm.dayratecost.app.DayRateBaseSettingEditUIHandler";
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
        this.prmtcompany.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.dayratecost.DayRateBaseSettingInfo)ov;
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
		getValidateHelper().registerBindProperty("isInit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("currentPeriod", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("seedMateiral", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("seedCostItem", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fullWorkQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("intPeroid", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("isInit"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("simpleName"));
        sic.add(new SelectorItemInfo("description"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("currentPeriod.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("currentPeriod.id"));
        	sic.add(new SelectorItemInfo("currentPeriod.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("seedMateiral.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("seedMateiral.id"));
        	sic.add(new SelectorItemInfo("seedMateiral.number"));
        	sic.add(new SelectorItemInfo("seedMateiral.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("seedCostItem.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("seedCostItem.id"));
        	sic.add(new SelectorItemInfo("seedCostItem.number"));
        	sic.add(new SelectorItemInfo("seedCostItem.name"));
		}
        sic.add(new SelectorItemInfo("fullWorkQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("intPeroid.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("intPeroid.id"));
        	sic.add(new SelectorItemInfo("intPeroid.number"));
		}
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.dayratecost.client", "DayRateBaseSettingEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.dayratecost.client.DayRateBaseSettingEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.dayratecost.DayRateBaseSettingFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.dayratecost.DayRateBaseSettingInfo objectValue = new com.kingdee.eas.farm.dayratecost.DayRateBaseSettingInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtseedMateiral.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"苗对应物料"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtseedCostItem.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"苗对应成本项目"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtfullWorkQty.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"最高工作量"});
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