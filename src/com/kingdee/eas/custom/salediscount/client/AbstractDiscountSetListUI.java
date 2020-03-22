/**
 * output package name
 */
package com.kingdee.eas.custom.salediscount.client;

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
public abstract class AbstractDiscountSetListUI extends com.kingdee.eas.framework.client.CoreBillListUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractDiscountSetListUI.class);
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnBlocked;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnBlocked;
    protected com.kingdee.bos.ctrl.swing.KDMenu menuImportData;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemImportCustomerMaterial;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemImportCustomerMaterialGroup;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemImportCustomerGroupMaterial;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemImportCustomerGroupMaterialGroup;
    protected com.kingdee.bos.ctrl.swing.KDMenu menuExportData;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemExportCustomerMaterial;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemExportCustomerMaterialGroup;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemExportCustomerGroupMaterial;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemExportCustomerGroupMaterialGroup;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemUnBlock;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemBlock;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemUnAudit;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionBlock actionBlock = null;
    protected ActionUnBlock actionUnBlock = null;
    protected ActionImportCustomerMaterial actionImportCustomerMaterial = null;
    protected ActionImportCustomerMaterialGroup actionImportCustomerMaterialGroup = null;
    protected ActionImportCustomerGroupMaterial actionImportCustomerGroupMaterial = null;
    protected ActionImportCustomerGroupMaterialGroup actionImportCustomerGroupMaterialGroup = null;
    protected ActionExportCustomerMaterial actionExportCustomerMaterial = null;
    protected ActionExportCustomerMaterialGroup actionExportCustomerMaterialGroup = null;
    protected ActionExportCustomerGroupMaterial actionExportCustomerGroupMaterial = null;
    protected ActionExportCustomerGroupMaterialGroup actionExportCustomerGroupMaterialGroup = null;
    /**
     * output class constructor
     */
    public AbstractDiscountSetListUI() throws Exception
    {
        super();
        this.defaultObjectName = "mainQuery";
        jbInit();
        
        initUIP();
    }

    /**
     * output jbInit method
     */
    private void jbInit() throws Exception
    {
        this.resHelper = new ResourceBundleHelper(AbstractDiscountSetListUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        mainQueryPK = new MetaDataPK("com.kingdee.eas.custom.salediscount.app", "DiscountSetQuery");
        //actionAudit
        this.actionAudit = new ActionAudit(this);
        getActionManager().registerAction("actionAudit", actionAudit);
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionUnAudit
        this.actionUnAudit = new ActionUnAudit(this);
        getActionManager().registerAction("actionUnAudit", actionUnAudit);
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionBlock
        this.actionBlock = new ActionBlock(this);
        getActionManager().registerAction("actionBlock", actionBlock);
         this.actionBlock.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionUnBlock
        this.actionUnBlock = new ActionUnBlock(this);
        getActionManager().registerAction("actionUnBlock", actionUnBlock);
         this.actionUnBlock.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionImportCustomerMaterial
        this.actionImportCustomerMaterial = new ActionImportCustomerMaterial(this);
        getActionManager().registerAction("actionImportCustomerMaterial", actionImportCustomerMaterial);
         this.actionImportCustomerMaterial.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionImportCustomerMaterialGroup
        this.actionImportCustomerMaterialGroup = new ActionImportCustomerMaterialGroup(this);
        getActionManager().registerAction("actionImportCustomerMaterialGroup", actionImportCustomerMaterialGroup);
         this.actionImportCustomerMaterialGroup.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionImportCustomerGroupMaterial
        this.actionImportCustomerGroupMaterial = new ActionImportCustomerGroupMaterial(this);
        getActionManager().registerAction("actionImportCustomerGroupMaterial", actionImportCustomerGroupMaterial);
         this.actionImportCustomerGroupMaterial.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionImportCustomerGroupMaterialGroup
        this.actionImportCustomerGroupMaterialGroup = new ActionImportCustomerGroupMaterialGroup(this);
        getActionManager().registerAction("actionImportCustomerGroupMaterialGroup", actionImportCustomerGroupMaterialGroup);
         this.actionImportCustomerGroupMaterialGroup.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionExportCustomerMaterial
        this.actionExportCustomerMaterial = new ActionExportCustomerMaterial(this);
        getActionManager().registerAction("actionExportCustomerMaterial", actionExportCustomerMaterial);
         this.actionExportCustomerMaterial.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionExportCustomerMaterialGroup
        this.actionExportCustomerMaterialGroup = new ActionExportCustomerMaterialGroup(this);
        getActionManager().registerAction("actionExportCustomerMaterialGroup", actionExportCustomerMaterialGroup);
         this.actionExportCustomerMaterialGroup.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionExportCustomerGroupMaterial
        this.actionExportCustomerGroupMaterial = new ActionExportCustomerGroupMaterial(this);
        getActionManager().registerAction("actionExportCustomerGroupMaterial", actionExportCustomerGroupMaterial);
         this.actionExportCustomerGroupMaterial.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionExportCustomerGroupMaterialGroup
        this.actionExportCustomerGroupMaterialGroup = new ActionExportCustomerGroupMaterialGroup(this);
        getActionManager().registerAction("actionExportCustomerGroupMaterialGroup", actionExportCustomerGroupMaterialGroup);
         this.actionExportCustomerGroupMaterialGroup.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnBlocked = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnBlocked = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.menuImportData = new com.kingdee.bos.ctrl.swing.KDMenu();
        this.menuItemImportCustomerMaterial = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemImportCustomerMaterialGroup = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemImportCustomerGroupMaterial = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemImportCustomerGroupMaterialGroup = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuExportData = new com.kingdee.bos.ctrl.swing.KDMenu();
        this.menuItemExportCustomerMaterial = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemExportCustomerMaterialGroup = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemExportCustomerGroupMaterial = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemExportCustomerGroupMaterialGroup = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemUnBlock = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemBlock = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.menuItemUnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
        this.btnBlocked.setName("btnBlocked");
        this.btnUnBlocked.setName("btnUnBlocked");
        this.menuImportData.setName("menuImportData");
        this.menuItemImportCustomerMaterial.setName("menuItemImportCustomerMaterial");
        this.menuItemImportCustomerMaterialGroup.setName("menuItemImportCustomerMaterialGroup");
        this.menuItemImportCustomerGroupMaterial.setName("menuItemImportCustomerGroupMaterial");
        this.menuItemImportCustomerGroupMaterialGroup.setName("menuItemImportCustomerGroupMaterialGroup");
        this.menuExportData.setName("menuExportData");
        this.menuItemExportCustomerMaterial.setName("menuItemExportCustomerMaterial");
        this.menuItemExportCustomerMaterialGroup.setName("menuItemExportCustomerMaterialGroup");
        this.menuItemExportCustomerGroupMaterial.setName("menuItemExportCustomerGroupMaterial");
        this.menuItemExportCustomerGroupMaterialGroup.setName("menuItemExportCustomerGroupMaterialGroup");
        this.menuItemUnBlock.setName("menuItemUnBlock");
        this.menuItemBlock.setName("menuItemBlock");
        this.menuItemAudit.setName("menuItemAudit");
        this.menuItemUnAudit.setName("menuItemUnAudit");
        // CoreUI
		String tblMainStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"name\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"isAllCustomer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"3\" t:styleID=\"sCol3\" /><t:Column t:key=\"discountType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"4\" /><t:Column t:key=\"dsNameType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" /><t:Column t:key=\"saleOrgUnit.number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"6\" t:styleID=\"sCol6\" /><t:Column t:key=\"saleOrgUnit.name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"7\" /><t:Column t:key=\"blockedStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"8\" /><t:Column t:key=\"checkedStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"9\" /><t:Column t:key=\"effectiveDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"10\" /><t:Column t:key=\"expireDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"11\" /><t:Column t:key=\"auditDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"true\" t:required=\"false\" t:index=\"12\" /><t:Column t:key=\"isLimitMerge\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"13\" /><t:Column t:key=\"byMonthQtyLimit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"14\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{name}</t:Cell><t:Cell>$Resource{isAllCustomer}</t:Cell><t:Cell>$Resource{discountType}</t:Cell><t:Cell>$Resource{dsNameType}</t:Cell><t:Cell>$Resource{saleOrgUnit.number}</t:Cell><t:Cell>$Resource{saleOrgUnit.name}</t:Cell><t:Cell>$Resource{blockedStatus}</t:Cell><t:Cell>$Resource{checkedStatus}</t:Cell><t:Cell>$Resource{effectiveDate}</t:Cell><t:Cell>$Resource{expireDate}</t:Cell><t:Cell>$Resource{auditDate}</t:Cell><t:Cell>$Resource{isLimitMerge}</t:Cell><t:Cell>$Resource{byMonthQtyLimit}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.tblMain.setFormatXml(resHelper.translateString("tblMain",tblMainStrXML));
                this.tblMain.putBindContents("mainQuery",new String[] {"id","number","name","isAllCustomer","discountType","dsNameType","saleOrgUnit.number","saleOrgUnit.name","blockedStatus","checkedStatus","effectiveDate","expireDate","auditDate","isLimitMerge","byMonthQtyLimit"});

		
        this.menuItemImportData.setText(resHelper.getString("menuItemImportData.text"));		
        this.menuItemImportData.setEnabled(false);		
        this.menuItemExportData.setText(resHelper.getString("menuItemExportData.text"));		
        this.menuItemExportData.setToolTipText(resHelper.getString("menuItemExportData.toolTipText"));		
        this.separatorFW2.setVisible(true);		
        this.btnCreateTo.setVisible(false);		
        this.separatorFW3.setVisible(false);		
        this.btnTraceUp.setVisible(false);		
        this.btnTraceDown.setVisible(false);		
        this.separatorFW4.setVisible(false);		
        this.btnVoucher.setVisible(false);		
        this.btnDelVoucher.setVisible(false);		
        this.btnAuditResult.setVisible(false);		
        this.btnWFViewdoProccess.setVisible(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        // btnBlocked
        this.btnBlocked.setAction((IItemAction)ActionProxyFactory.getProxy(actionBlock, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnBlocked.setText(resHelper.getString("btnBlocked.text"));
        // btnUnBlocked
        this.btnUnBlocked.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnBlock, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnBlocked.setText(resHelper.getString("btnUnBlocked.text"));		
        this.btnUnBlocked.setToolTipText(resHelper.getString("btnUnBlocked.toolTipText"));
        // menuImportData		
        this.menuImportData.setText(resHelper.getString("menuImportData.text"));
        // menuItemImportCustomerMaterial
        this.menuItemImportCustomerMaterial.setAction((IItemAction)ActionProxyFactory.getProxy(actionImportCustomerMaterial, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemImportCustomerMaterial.setText(resHelper.getString("menuItemImportCustomerMaterial.text"));
        // menuItemImportCustomerMaterialGroup
        this.menuItemImportCustomerMaterialGroup.setAction((IItemAction)ActionProxyFactory.getProxy(actionImportCustomerMaterialGroup, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemImportCustomerMaterialGroup.setText(resHelper.getString("menuItemImportCustomerMaterialGroup.text"));
        // menuItemImportCustomerGroupMaterial
        this.menuItemImportCustomerGroupMaterial.setAction((IItemAction)ActionProxyFactory.getProxy(actionImportCustomerGroupMaterial, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemImportCustomerGroupMaterial.setText(resHelper.getString("menuItemImportCustomerGroupMaterial.text"));
        // menuItemImportCustomerGroupMaterialGroup
        this.menuItemImportCustomerGroupMaterialGroup.setAction((IItemAction)ActionProxyFactory.getProxy(actionImportCustomerGroupMaterialGroup, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemImportCustomerGroupMaterialGroup.setText(resHelper.getString("menuItemImportCustomerGroupMaterialGroup.text"));
        // menuExportData		
        this.menuExportData.setText(resHelper.getString("menuExportData.text"));
        // menuItemExportCustomerMaterial
        this.menuItemExportCustomerMaterial.setAction((IItemAction)ActionProxyFactory.getProxy(actionExportCustomerMaterial, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemExportCustomerMaterial.setText(resHelper.getString("menuItemExportCustomerMaterial.text"));
        // menuItemExportCustomerMaterialGroup
        this.menuItemExportCustomerMaterialGroup.setAction((IItemAction)ActionProxyFactory.getProxy(actionExportCustomerMaterialGroup, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemExportCustomerMaterialGroup.setText(resHelper.getString("menuItemExportCustomerMaterialGroup.text"));
        // menuItemExportCustomerGroupMaterial
        this.menuItemExportCustomerGroupMaterial.setAction((IItemAction)ActionProxyFactory.getProxy(actionExportCustomerGroupMaterial, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemExportCustomerGroupMaterial.setText(resHelper.getString("menuItemExportCustomerGroupMaterial.text"));
        // menuItemExportCustomerGroupMaterialGroup
        this.menuItemExportCustomerGroupMaterialGroup.setAction((IItemAction)ActionProxyFactory.getProxy(actionExportCustomerGroupMaterialGroup, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemExportCustomerGroupMaterialGroup.setText(resHelper.getString("menuItemExportCustomerGroupMaterialGroup.text"));
        // menuItemUnBlock
        this.menuItemUnBlock.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnBlock, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemUnBlock.setText(resHelper.getString("menuItemUnBlock.text"));		
        this.menuItemUnBlock.setMnemonic(83);
        // menuItemBlock
        this.menuItemBlock.setAction((IItemAction)ActionProxyFactory.getProxy(actionBlock, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemBlock.setText(resHelper.getString("menuItemBlock.text"));		
        this.menuItemBlock.setMnemonic(67);
        // menuItemAudit
        this.menuItemAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemAudit.setText(resHelper.getString("menuItemAudit.text"));		
        this.menuItemAudit.setMnemonic(80);
        // menuItemUnAudit
        this.menuItemUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemUnAudit.setText(resHelper.getString("menuItemUnAudit.text"));		
        this.menuItemUnAudit.setMnemonic(85);
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
        this.setBounds(new Rectangle(10, 10, 1013, 629));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(10, 10, 1013, 629));
        tblMain.setBounds(new Rectangle(10, 10, 996, 580));
        this.add(tblMain, new KDLayout.Constraints(10, 10, 996, 580, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));

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
        this.menuBar.add(menuWorkFlow);
        this.menuBar.add(menuTools);
        this.menuBar.add(menuHelp);
        //menuFile
        menuFile.add(menuItemAddNew);
        menuFile.add(menuItemImportData);
        menuFile.add(menuItemCloudFeed);
        menuFile.add(menuItemExportData);
        menuFile.add(menuItemCloudScreen);
        menuFile.add(menuImportData);
        menuFile.add(menuItemCloudShare);
        menuFile.add(menuExportData);
        menuFile.add(kdSeparatorFWFile1);
        menuFile.add(separatorFile1);
        menuFile.add(MenuItemAttachment);
        menuFile.add(kDSeparator1);
        menuFile.add(menuItemPageSetup);
        menuFile.add(menuItemPrint);
        menuFile.add(menuItemPrintPreview);
        menuFile.add(kDSeparator2);
        menuFile.add(menuItemExitCurrent);
        //menuImportData
        menuImportData.add(menuItemImportCustomerMaterial);
        menuImportData.add(menuItemImportCustomerMaterialGroup);
        menuImportData.add(menuItemImportCustomerGroupMaterial);
        menuImportData.add(menuItemImportCustomerGroupMaterialGroup);
        //menuExportData
        menuExportData.add(menuItemExportCustomerMaterial);
        menuExportData.add(menuItemExportCustomerMaterialGroup);
        menuExportData.add(menuItemExportCustomerGroupMaterial);
        menuExportData.add(menuItemExportCustomerGroupMaterialGroup);
        //menuEdit
        menuEdit.add(menuItemEdit);
        menuEdit.add(menuItemRemove);
        menuEdit.add(kDSeparator3);
        menuEdit.add(kDSeparator4);
        menuEdit.add(menuItemCreateTo);
        menuEdit.add(menuItemCopyTo);
        //MenuService
        MenuService.add(MenuItemKnowStore);
        MenuService.add(MenuItemAnwser);
        MenuService.add(SepratorService);
        MenuService.add(MenuItemRemoteAssist);
        //menuView
        menuView.add(menuItemView);
        menuView.add(menuItemLocate);
        menuView.add(kDSeparator5);
        menuView.add(menuItemQuery);
        menuView.add(menuItemRefresh);
        menuView.add(menuItemSwitchView);
        menuView.add(separatorView1);
        menuView.add(menuItemTraceUp);
        menuView.add(menuItemTraceDown);
        menuView.add(menuItemQueryScheme);
        menuView.add(kDSeparator6);
        //menuBiz
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        menuBiz.add(menuItemVoucher);
        menuBiz.add(menuItemDelVoucher);
        menuBiz.add(menuItemUnBlock);
        menuBiz.add(menuItemBlock);
        menuBiz.add(menuItemAudit);
        menuBiz.add(menuItemUnAudit);
        //menuTool
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemCalculator);
        menuTool.add(menuItemToolBarCustom);
        //menuWorkFlow
        menuWorkFlow.add(menuItemViewDoProccess);
        menuWorkFlow.add(menuItemMultiapprove);
        menuWorkFlow.add(menuItemWorkFlowG);
        menuWorkFlow.add(menuItemWorkFlowList);
        menuWorkFlow.add(separatorWF1);
        menuWorkFlow.add(menuItemNextPerson);
        menuWorkFlow.add(menuItemAuditResult);
        menuWorkFlow.add(kDSeparator7);
        menuWorkFlow.add(menuItemSendSmsMessage);
        //menuTools
        menuTools.add(menuMail);
        menuTools.add(menuItemStartWorkFlow);
        menuTools.add(menuItemPublishReport);
        //menuMail
        menuMail.add(menuItemToHTML);
        menuMail.add(menuItemCopyScreen);
        menuMail.add(menuItemToExcel);
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
        this.toolBar.add(btnView);
        this.toolBar.add(btnXunTong);
        this.toolBar.add(btnEdit);
        this.toolBar.add(kDSeparatorCloud);
        this.toolBar.add(btnRemove);
        this.toolBar.add(btnRefresh);
        this.toolBar.add(btnLocate);
        this.toolBar.add(btnAttachment);
        this.toolBar.add(separatorFW1);
        this.toolBar.add(btnPrint);
        this.toolBar.add(btnPrintPreview);
        this.toolBar.add(separatorFW2);
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);
        this.toolBar.add(btnBlocked);
        this.toolBar.add(btnUnBlocked);
        this.toolBar.add(btnPageSetup);
        this.toolBar.add(btnQueryScheme);
        this.toolBar.add(btnQuery);
        this.toolBar.add(btnVoucher);
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(separatorFW3);
        this.toolBar.add(btnCreateTo);
        this.toolBar.add(btnWorkFlowList);
        this.toolBar.add(btnCopyTo);
        this.toolBar.add(btnSignature);
        this.toolBar.add(btnTraceUp);
        this.toolBar.add(btnViewSignature);
        this.toolBar.add(btnWorkFlowG);
        this.toolBar.add(btnNumberSign);
        this.toolBar.add(btnTraceDown);
        this.toolBar.add(separatorFW4);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnNextPerson);
        this.toolBar.add(btnCancel);
        this.toolBar.add(btnCancelCancel);


    }

	//Regiester control's property binding.
	private void registerBindings(){		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.salediscount.app.DiscountSetListUIHandler";
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
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
    }

    /**
     * output loadFields method
     */
    public void loadFields()
    {
        dataBinder.loadFields();
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
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
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
        sic.add(new SelectorItemInfo("id"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("effectiveDate"));
        sic.add(new SelectorItemInfo("expireDate"));
        sic.add(new SelectorItemInfo("auditDate"));
        sic.add(new SelectorItemInfo("saleOrgUnit.number"));
        sic.add(new SelectorItemInfo("saleOrgUnit.name"));
        sic.add(new SelectorItemInfo("checkedStatus"));
        sic.add(new SelectorItemInfo("discountType"));
        sic.add(new SelectorItemInfo("blockedStatus"));
        sic.add(new SelectorItemInfo("isLimitMerge"));
        sic.add(new SelectorItemInfo("dsNameType"));
        sic.add(new SelectorItemInfo("byMonthQtyLimit"));
        sic.add(new SelectorItemInfo("isAllCustomer"));
        return sic;
    }        
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionBlock_actionPerformed method
     */
    public void actionBlock_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionUnBlock_actionPerformed method
     */
    public void actionUnBlock_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionImportCustomerMaterial_actionPerformed method
     */
    public void actionImportCustomerMaterial_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionImportCustomerMaterialGroup_actionPerformed method
     */
    public void actionImportCustomerMaterialGroup_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionImportCustomerGroupMaterial_actionPerformed method
     */
    public void actionImportCustomerGroupMaterial_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionImportCustomerGroupMaterialGroup_actionPerformed method
     */
    public void actionImportCustomerGroupMaterialGroup_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionExportCustomerMaterial_actionPerformed method
     */
    public void actionExportCustomerMaterial_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionExportCustomerMaterialGroup_actionPerformed method
     */
    public void actionExportCustomerMaterialGroup_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionExportCustomerGroupMaterial_actionPerformed method
     */
    public void actionExportCustomerGroupMaterial_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionExportCustomerGroupMaterialGroup_actionPerformed method
     */
    public void actionExportCustomerGroupMaterialGroup_actionPerformed(ActionEvent e) throws Exception
    {
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
	public RequestContext prepareActionBlock(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionBlock() {
    	return false;
    }
	public RequestContext prepareActionUnBlock(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionUnBlock() {
    	return false;
    }
	public RequestContext prepareActionImportCustomerMaterial(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionImportCustomerMaterial() {
    	return false;
    }
	public RequestContext prepareActionImportCustomerMaterialGroup(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionImportCustomerMaterialGroup() {
    	return false;
    }
	public RequestContext prepareActionImportCustomerGroupMaterial(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionImportCustomerGroupMaterial() {
    	return false;
    }
	public RequestContext prepareActionImportCustomerGroupMaterialGroup(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionImportCustomerGroupMaterialGroup() {
    	return false;
    }
	public RequestContext prepareActionExportCustomerMaterial(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionExportCustomerMaterial() {
    	return false;
    }
	public RequestContext prepareActionExportCustomerMaterialGroup(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionExportCustomerMaterialGroup() {
    	return false;
    }
	public RequestContext prepareActionExportCustomerGroupMaterial(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionExportCustomerGroupMaterial() {
    	return false;
    }
	public RequestContext prepareActionExportCustomerGroupMaterialGroup(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionExportCustomerGroupMaterialGroup() {
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
            this.setEnabled(false);
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
            innerActionPerformed("eas", AbstractDiscountSetListUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            this.setEnabled(false);
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
            innerActionPerformed("eas", AbstractDiscountSetListUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionBlock class
     */     
    protected class ActionBlock extends ItemAction {     
    
        public ActionBlock()
        {
            this(null);
        }

        public ActionBlock(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("ActionBlock.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionBlock.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionBlock.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractDiscountSetListUI.this, "ActionBlock", "actionBlock_actionPerformed", e);
        }
    }

    /**
     * output ActionUnBlock class
     */     
    protected class ActionUnBlock extends ItemAction {     
    
        public ActionUnBlock()
        {
            this(null);
        }

        public ActionUnBlock(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("ActionUnBlock.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnBlock.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnBlock.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractDiscountSetListUI.this, "ActionUnBlock", "actionUnBlock_actionPerformed", e);
        }
    }

    /**
     * output ActionImportCustomerMaterial class
     */     
    protected class ActionImportCustomerMaterial extends ItemAction {     
    
        public ActionImportCustomerMaterial()
        {
            this(null);
        }

        public ActionImportCustomerMaterial(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionImportCustomerMaterial.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionImportCustomerMaterial.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionImportCustomerMaterial.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractDiscountSetListUI.this, "ActionImportCustomerMaterial", "actionImportCustomerMaterial_actionPerformed", e);
        }
    }

    /**
     * output ActionImportCustomerMaterialGroup class
     */     
    protected class ActionImportCustomerMaterialGroup extends ItemAction {     
    
        public ActionImportCustomerMaterialGroup()
        {
            this(null);
        }

        public ActionImportCustomerMaterialGroup(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionImportCustomerMaterialGroup.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionImportCustomerMaterialGroup.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionImportCustomerMaterialGroup.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractDiscountSetListUI.this, "ActionImportCustomerMaterialGroup", "actionImportCustomerMaterialGroup_actionPerformed", e);
        }
    }

    /**
     * output ActionImportCustomerGroupMaterial class
     */     
    protected class ActionImportCustomerGroupMaterial extends ItemAction {     
    
        public ActionImportCustomerGroupMaterial()
        {
            this(null);
        }

        public ActionImportCustomerGroupMaterial(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionImportCustomerGroupMaterial.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionImportCustomerGroupMaterial.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionImportCustomerGroupMaterial.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractDiscountSetListUI.this, "ActionImportCustomerGroupMaterial", "actionImportCustomerGroupMaterial_actionPerformed", e);
        }
    }

    /**
     * output ActionImportCustomerGroupMaterialGroup class
     */     
    protected class ActionImportCustomerGroupMaterialGroup extends ItemAction {     
    
        public ActionImportCustomerGroupMaterialGroup()
        {
            this(null);
        }

        public ActionImportCustomerGroupMaterialGroup(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionImportCustomerGroupMaterialGroup.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionImportCustomerGroupMaterialGroup.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionImportCustomerGroupMaterialGroup.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractDiscountSetListUI.this, "ActionImportCustomerGroupMaterialGroup", "actionImportCustomerGroupMaterialGroup_actionPerformed", e);
        }
    }

    /**
     * output ActionExportCustomerMaterial class
     */     
    protected class ActionExportCustomerMaterial extends ItemAction {     
    
        public ActionExportCustomerMaterial()
        {
            this(null);
        }

        public ActionExportCustomerMaterial(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionExportCustomerMaterial.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionExportCustomerMaterial.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionExportCustomerMaterial.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractDiscountSetListUI.this, "ActionExportCustomerMaterial", "actionExportCustomerMaterial_actionPerformed", e);
        }
    }

    /**
     * output ActionExportCustomerMaterialGroup class
     */     
    protected class ActionExportCustomerMaterialGroup extends ItemAction {     
    
        public ActionExportCustomerMaterialGroup()
        {
            this(null);
        }

        public ActionExportCustomerMaterialGroup(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionExportCustomerMaterialGroup.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionExportCustomerMaterialGroup.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionExportCustomerMaterialGroup.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractDiscountSetListUI.this, "ActionExportCustomerMaterialGroup", "actionExportCustomerMaterialGroup_actionPerformed", e);
        }
    }

    /**
     * output ActionExportCustomerGroupMaterial class
     */     
    protected class ActionExportCustomerGroupMaterial extends ItemAction {     
    
        public ActionExportCustomerGroupMaterial()
        {
            this(null);
        }

        public ActionExportCustomerGroupMaterial(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionExportCustomerGroupMaterial.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionExportCustomerGroupMaterial.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionExportCustomerGroupMaterial.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractDiscountSetListUI.this, "ActionExportCustomerGroupMaterial", "actionExportCustomerGroupMaterial_actionPerformed", e);
        }
    }

    /**
     * output ActionExportCustomerGroupMaterialGroup class
     */     
    protected class ActionExportCustomerGroupMaterialGroup extends ItemAction {     
    
        public ActionExportCustomerGroupMaterialGroup()
        {
            this(null);
        }

        public ActionExportCustomerGroupMaterialGroup(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("ActionExportCustomerGroupMaterialGroup.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionExportCustomerGroupMaterialGroup.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionExportCustomerGroupMaterialGroup.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractDiscountSetListUI.this, "ActionExportCustomerGroupMaterialGroup", "actionExportCustomerGroupMaterialGroup_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.salediscount.client", "DiscountSetListUI");
    }




}