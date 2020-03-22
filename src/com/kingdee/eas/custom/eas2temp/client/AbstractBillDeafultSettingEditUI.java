/**
 * output package name
 */
package com.kingdee.eas.custom.eas2temp.client;

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
public abstract class AbstractBillDeafultSettingEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractBillDeafultSettingEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcostCenterUnitOrg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contYLWarehouse;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbackWarehouse;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCPWarehouse;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbackWarehouse;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCPWarehouse;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLLWarehouse;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLLWarehouse;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcostCenterUnitOrg;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtYLWarehouse;
    protected com.kingdee.eas.custom.eas2temp.BillDeafultSettingInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractBillDeafultSettingEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractBillDeafultSettingEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstorageOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contcostCenterUnitOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contYLWarehouse = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.prmtstorageOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contbackWarehouse = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCPWarehouse = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtbackWarehouse = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtCPWarehouse = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.contLLWarehouse = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtLLWarehouse = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcostCenterUnitOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtYLWarehouse = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contstorageOrgUnit.setName("contstorageOrgUnit");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contcostCenterUnitOrg.setName("contcostCenterUnitOrg");
        this.contYLWarehouse.setName("contYLWarehouse");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.prmtstorageOrgUnit.setName("prmtstorageOrgUnit");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.contbackWarehouse.setName("contbackWarehouse");
        this.contCPWarehouse.setName("contCPWarehouse");
        this.prmtbackWarehouse.setName("prmtbackWarehouse");
        this.prmtCPWarehouse.setName("prmtCPWarehouse");
        this.contLLWarehouse.setName("contLLWarehouse");
        this.prmtLLWarehouse.setName("prmtLLWarehouse");
        this.prmtcostCenterUnitOrg.setName("prmtcostCenterUnitOrg");
        this.prmtYLWarehouse.setName("prmtYLWarehouse");
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
        // contstorageOrgUnit		
        this.contstorageOrgUnit.setBoundLabelText(resHelper.getString("contstorageOrgUnit.boundLabelText"));		
        this.contstorageOrgUnit.setBoundLabelLength(100);		
        this.contstorageOrgUnit.setBoundLabelUnderline(true);		
        this.contstorageOrgUnit.setVisible(true);
        // kDTabbedPane1
        // contcostCenterUnitOrg		
        this.contcostCenterUnitOrg.setBoundLabelText(resHelper.getString("contcostCenterUnitOrg.boundLabelText"));		
        this.contcostCenterUnitOrg.setBoundLabelLength(100);		
        this.contcostCenterUnitOrg.setBoundLabelUnderline(true);		
        this.contcostCenterUnitOrg.setVisible(true);
        // contYLWarehouse		
        this.contYLWarehouse.setBoundLabelText(resHelper.getString("contYLWarehouse.boundLabelText"));		
        this.contYLWarehouse.setBoundLabelLength(100);		
        this.contYLWarehouse.setBoundLabelUnderline(true);		
        this.contYLWarehouse.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // prmtstorageOrgUnit		
        this.prmtstorageOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtstorageOrgUnit.setVisible(true);		
        this.prmtstorageOrgUnit.setEditable(true);		
        this.prmtstorageOrgUnit.setDisplayFormat("$name$");		
        this.prmtstorageOrgUnit.setEditFormat("$number$");		
        this.prmtstorageOrgUnit.setCommitFormat("$number$");		
        this.prmtstorageOrgUnit.setRequired(false);
        // kDPanel1
        // kDPanel2
        // contbackWarehouse		
        this.contbackWarehouse.setBoundLabelText(resHelper.getString("contbackWarehouse.boundLabelText"));		
        this.contbackWarehouse.setBoundLabelLength(100);		
        this.contbackWarehouse.setBoundLabelUnderline(true);		
        this.contbackWarehouse.setVisible(true);
        // contCPWarehouse		
        this.contCPWarehouse.setBoundLabelText(resHelper.getString("contCPWarehouse.boundLabelText"));		
        this.contCPWarehouse.setBoundLabelLength(100);		
        this.contCPWarehouse.setBoundLabelUnderline(true);		
        this.contCPWarehouse.setVisible(true);
        // prmtbackWarehouse		
        this.prmtbackWarehouse.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.WarehouseQuery");		
        this.prmtbackWarehouse.setVisible(true);		
        this.prmtbackWarehouse.setEditable(true);		
        this.prmtbackWarehouse.setDisplayFormat("$name$");		
        this.prmtbackWarehouse.setEditFormat("$number$");		
        this.prmtbackWarehouse.setCommitFormat("$number$");		
        this.prmtbackWarehouse.setRequired(false);
        // prmtCPWarehouse		
        this.prmtCPWarehouse.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.WarehouseQuery");		
        this.prmtCPWarehouse.setVisible(true);		
        this.prmtCPWarehouse.setEditable(true);		
        this.prmtCPWarehouse.setDisplayFormat("$name$");		
        this.prmtCPWarehouse.setEditFormat("$number$");		
        this.prmtCPWarehouse.setCommitFormat("$number$");		
        this.prmtCPWarehouse.setRequired(false);
        // contLLWarehouse		
        this.contLLWarehouse.setBoundLabelText(resHelper.getString("contLLWarehouse.boundLabelText"));		
        this.contLLWarehouse.setBoundLabelLength(100);		
        this.contLLWarehouse.setBoundLabelUnderline(true);		
        this.contLLWarehouse.setVisible(true);
        // prmtLLWarehouse		
        this.prmtLLWarehouse.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.WarehouseQuery");		
        this.prmtLLWarehouse.setVisible(true);		
        this.prmtLLWarehouse.setEditable(true);		
        this.prmtLLWarehouse.setDisplayFormat("$name$");		
        this.prmtLLWarehouse.setEditFormat("$number$");		
        this.prmtLLWarehouse.setCommitFormat("$number$");		
        this.prmtLLWarehouse.setRequired(false);
        // prmtcostCenterUnitOrg		
        this.prmtcostCenterUnitOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.CostCenterItemQuery");		
        this.prmtcostCenterUnitOrg.setVisible(true);		
        this.prmtcostCenterUnitOrg.setEditable(true);		
        this.prmtcostCenterUnitOrg.setDisplayFormat("$name$");		
        this.prmtcostCenterUnitOrg.setEditFormat("$number$");		
        this.prmtcostCenterUnitOrg.setCommitFormat("$number$");		
        this.prmtcostCenterUnitOrg.setRequired(false);
        // prmtYLWarehouse		
        this.prmtYLWarehouse.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.WarehouseQuery");		
        this.prmtYLWarehouse.setVisible(true);		
        this.prmtYLWarehouse.setEditable(true);		
        this.prmtYLWarehouse.setDisplayFormat("$name$");		
        this.prmtYLWarehouse.setEditFormat("$number$");		
        this.prmtYLWarehouse.setCommitFormat("$number$");		
        this.prmtYLWarehouse.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtstorageOrgUnit,prmtcostCenterUnitOrg,prmtYLWarehouse,prmtbackWarehouse,prmtCPWarehouse,prmtLLWarehouse}));
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
        this.setBounds(new Rectangle(0, 0, 643, 446));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(41, 68, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(335, 68, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(-284, 18, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(-284, 55, 270, 19));
        this.add(kDLabelContainer4, null);
        contstorageOrgUnit.setBounds(new Rectangle(39, 117, 270, 19));
        this.add(contstorageOrgUnit, null);
        kDTabbedPane1.setBounds(new Rectangle(37, 206, 564, 218));
        this.add(kDTabbedPane1, null);
        contcostCenterUnitOrg.setBounds(new Rectangle(331, 114, 270, 19));
        this.add(contcostCenterUnitOrg, null);
        contYLWarehouse.setBounds(new Rectangle(40, 167, 270, 19));
        this.add(contYLWarehouse, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contstorageOrgUnit
        contstorageOrgUnit.setBoundEditor(prmtstorageOrgUnit);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //kDPanel1
        kDPanel1.setLayout(null);        contbackWarehouse.setBounds(new Rectangle(8, 20, 270, 19));
        kDPanel1.add(contbackWarehouse, null);
        contCPWarehouse.setBounds(new Rectangle(6, 67, 270, 19));
        kDPanel1.add(contCPWarehouse, null);
        //contbackWarehouse
        contbackWarehouse.setBoundEditor(prmtbackWarehouse);
        //contCPWarehouse
        contCPWarehouse.setBoundEditor(prmtCPWarehouse);
        //kDPanel2
        kDPanel2.setLayout(null);        contLLWarehouse.setBounds(new Rectangle(8, 22, 270, 19));
        kDPanel2.add(contLLWarehouse, null);
        //contLLWarehouse
        contLLWarehouse.setBoundEditor(prmtLLWarehouse);
        //contcostCenterUnitOrg
        contcostCenterUnitOrg.setBoundEditor(prmtcostCenterUnitOrg);
        //contYLWarehouse
        contYLWarehouse.setBoundEditor(prmtYLWarehouse);

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
		dataBinder.registerBinding("storageOrgUnit", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtstorageOrgUnit, "data");
		dataBinder.registerBinding("backWarehouse", com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo.class, this.prmtbackWarehouse, "data");
		dataBinder.registerBinding("CPWarehouse", com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo.class, this.prmtCPWarehouse, "data");
		dataBinder.registerBinding("LLWarehouse", com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo.class, this.prmtLLWarehouse, "data");
		dataBinder.registerBinding("costCenterUnitOrg", com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo.class, this.prmtcostCenterUnitOrg, "data");
		dataBinder.registerBinding("YLWarehouse", com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo.class, this.prmtYLWarehouse, "data");		
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
	    return "com.kingdee.eas.custom.eas2temp.app.BillDeafultSettingEditUIHandler";
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
        this.prmtstorageOrgUnit.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.eas2temp.BillDeafultSettingInfo)ov;
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
		getValidateHelper().registerBindProperty("storageOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("backWarehouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CPWarehouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LLWarehouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("costCenterUnitOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("YLWarehouse", ValidateHelper.ON_SAVE);    		
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("storageOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("storageOrgUnit.id"));
        	sic.add(new SelectorItemInfo("storageOrgUnit.number"));
        	sic.add(new SelectorItemInfo("storageOrgUnit.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("backWarehouse.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("backWarehouse.id"));
        	sic.add(new SelectorItemInfo("backWarehouse.number"));
        	sic.add(new SelectorItemInfo("backWarehouse.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("CPWarehouse.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("CPWarehouse.id"));
        	sic.add(new SelectorItemInfo("CPWarehouse.number"));
        	sic.add(new SelectorItemInfo("CPWarehouse.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("LLWarehouse.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("LLWarehouse.id"));
        	sic.add(new SelectorItemInfo("LLWarehouse.number"));
        	sic.add(new SelectorItemInfo("LLWarehouse.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("costCenterUnitOrg.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("costCenterUnitOrg.id"));
        	sic.add(new SelectorItemInfo("costCenterUnitOrg.number"));
        	sic.add(new SelectorItemInfo("costCenterUnitOrg.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("YLWarehouse.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("YLWarehouse.id"));
        	sic.add(new SelectorItemInfo("YLWarehouse.number"));
        	sic.add(new SelectorItemInfo("YLWarehouse.name"));
		}
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.eas2temp.client", "BillDeafultSettingEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.eas2temp.client.BillDeafultSettingEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.eas2temp.BillDeafultSettingFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.eas2temp.BillDeafultSettingInfo objectValue = new com.kingdee.eas.custom.eas2temp.BillDeafultSettingInfo();
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