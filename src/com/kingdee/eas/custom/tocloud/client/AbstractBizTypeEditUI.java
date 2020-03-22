/**
 * output package name
 */
package com.kingdee.eas.custom.tocloud.client;

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
public abstract class AbstractBizTypeEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractBizTypeEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBosType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contquery;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttargetSystem;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimplClass;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatchQuery;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contStorageOranization;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisBatchFilter;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisReturn;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtBosType;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtquery;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmttargetSystem;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtimplClass;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbatchQuery;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtStorageOranization;
    protected com.kingdee.eas.custom.tocloud.BizTypeInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractBizTypeEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractBizTypeEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBosType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contquery = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttargetSystem = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimplClass = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbatchQuery = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contStorageOranization = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisBatchFilter = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisReturn = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtBosType = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtquery = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmttargetSystem = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtimplClass = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbatchQuery = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtStorageOranization = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contBosType.setName("contBosType");
        this.contquery.setName("contquery");
        this.conttargetSystem.setName("conttargetSystem");
        this.contimplClass.setName("contimplClass");
        this.contbatchQuery.setName("contbatchQuery");
        this.contStorageOranization.setName("contStorageOranization");
        this.chkisBatchFilter.setName("chkisBatchFilter");
        this.chkisReturn.setName("chkisReturn");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.txtBosType.setName("txtBosType");
        this.txtquery.setName("txtquery");
        this.prmttargetSystem.setName("prmttargetSystem");
        this.txtimplClass.setName("txtimplClass");
        this.txtbatchQuery.setName("txtbatchQuery");
        this.prmtStorageOranization.setName("prmtStorageOranization");
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
        // contBosType		
        this.contBosType.setBoundLabelText(resHelper.getString("contBosType.boundLabelText"));		
        this.contBosType.setBoundLabelLength(100);		
        this.contBosType.setBoundLabelUnderline(true);		
        this.contBosType.setVisible(true);
        // contquery		
        this.contquery.setBoundLabelText(resHelper.getString("contquery.boundLabelText"));		
        this.contquery.setBoundLabelLength(100);		
        this.contquery.setBoundLabelUnderline(true);		
        this.contquery.setVisible(true);
        // conttargetSystem		
        this.conttargetSystem.setBoundLabelText(resHelper.getString("conttargetSystem.boundLabelText"));		
        this.conttargetSystem.setBoundLabelLength(100);		
        this.conttargetSystem.setBoundLabelUnderline(true);		
        this.conttargetSystem.setVisible(true);
        // contimplClass		
        this.contimplClass.setBoundLabelText(resHelper.getString("contimplClass.boundLabelText"));		
        this.contimplClass.setBoundLabelLength(100);		
        this.contimplClass.setBoundLabelUnderline(true);		
        this.contimplClass.setVisible(true);
        // contbatchQuery		
        this.contbatchQuery.setBoundLabelText(resHelper.getString("contbatchQuery.boundLabelText"));		
        this.contbatchQuery.setBoundLabelLength(100);		
        this.contbatchQuery.setBoundLabelUnderline(true);		
        this.contbatchQuery.setVisible(true);
        // contStorageOranization		
        this.contStorageOranization.setBoundLabelText(resHelper.getString("contStorageOranization.boundLabelText"));		
        this.contStorageOranization.setBoundLabelLength(100);		
        this.contStorageOranization.setBoundLabelUnderline(true);		
        this.contStorageOranization.setVisible(true);
        // chkisBatchFilter		
        this.chkisBatchFilter.setText(resHelper.getString("chkisBatchFilter.text"));		
        this.chkisBatchFilter.setVisible(true);		
        this.chkisBatchFilter.setHorizontalAlignment(2);
        // chkisReturn		
        this.chkisReturn.setText(resHelper.getString("chkisReturn.text"));		
        this.chkisReturn.setVisible(true);		
        this.chkisReturn.setHorizontalAlignment(2);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // txtBosType		
        this.txtBosType.setHorizontalAlignment(2);		
        this.txtBosType.setMaxLength(100);		
        this.txtBosType.setRequired(false);
        // txtquery		
        this.txtquery.setHorizontalAlignment(2);		
        this.txtquery.setMaxLength(100);		
        this.txtquery.setRequired(false);
        // prmttargetSystem		
        this.prmttargetSystem.setQueryInfo("com.kingdee.eas.custom.tocloud.app.TargetSystemQuery");		
        this.prmttargetSystem.setEditable(true);		
        this.prmttargetSystem.setDisplayFormat("$name$");		
        this.prmttargetSystem.setEditFormat("$number$");		
        this.prmttargetSystem.setCommitFormat("$number$");		
        this.prmttargetSystem.setRequired(false);
        		prmttargetSystem.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.custom.tocloud.client.TargetSystemListUI prmttargetSystem_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmttargetSystem_F7ListUI == null) {
					try {
						prmttargetSystem_F7ListUI = new com.kingdee.eas.custom.tocloud.client.TargetSystemListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmttargetSystem_F7ListUI));
					prmttargetSystem_F7ListUI.setF7Use(true,ctx);
					prmttargetSystem.setSelector(prmttargetSystem_F7ListUI);
				}
			}
		});
					
        // txtimplClass		
        this.txtimplClass.setHorizontalAlignment(2);		
        this.txtimplClass.setMaxLength(255);		
        this.txtimplClass.setRequired(false);
        // txtbatchQuery		
        this.txtbatchQuery.setVisible(true);		
        this.txtbatchQuery.setHorizontalAlignment(2);		
        this.txtbatchQuery.setMaxLength(100);		
        this.txtbatchQuery.setRequired(false);
        // prmtStorageOranization		
        this.prmtStorageOranization.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtStorageOranization.setVisible(true);		
        this.prmtStorageOranization.setEditable(true);		
        this.prmtStorageOranization.setDisplayFormat("$name$");		
        this.prmtStorageOranization.setEditFormat("$number$");		
        this.prmtStorageOranization.setCommitFormat("$number$");		
        this.prmtStorageOranization.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtquery,txtName,txtNumber,txtDescription,txtSimpleName,txtBosType,txtimplClass,prmttargetSystem,txtbatchQuery,prmtStorageOranization,chkisBatchFilter,chkisReturn}));
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
        this.setBounds(new Rectangle(0, 0, 400, 488));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 400, 488));
        kDLabelContainer1.setBounds(new Rectangle(66, 44, 270, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(66, 44, 270, 19, 0));
        kDLabelContainer2.setBounds(new Rectangle(66, 78, 270, 19));
        this.add(kDLabelContainer2, new KDLayout.Constraints(66, 78, 270, 19, 0));
        kDLabelContainer3.setBounds(new Rectangle(66, 112, 270, 19));
        this.add(kDLabelContainer3, new KDLayout.Constraints(66, 112, 270, 19, 0));
        kDLabelContainer4.setBounds(new Rectangle(66, 146, 270, 19));
        this.add(kDLabelContainer4, new KDLayout.Constraints(66, 146, 270, 19, 0));
        contBosType.setBounds(new Rectangle(66, 180, 270, 19));
        this.add(contBosType, new KDLayout.Constraints(66, 180, 270, 19, 0));
        contquery.setBounds(new Rectangle(66, 214, 270, 19));
        this.add(contquery, new KDLayout.Constraints(66, 214, 270, 19, 0));
        conttargetSystem.setBounds(new Rectangle(66, 282, 270, 19));
        this.add(conttargetSystem, new KDLayout.Constraints(66, 282, 270, 19, 0));
        contimplClass.setBounds(new Rectangle(66, 248, 270, 19));
        this.add(contimplClass, new KDLayout.Constraints(66, 248, 270, 19, 0));
        contbatchQuery.setBounds(new Rectangle(66, 316, 270, 19));
        this.add(contbatchQuery, new KDLayout.Constraints(66, 316, 270, 19, 0));
        contStorageOranization.setBounds(new Rectangle(66, 350, 270, 19));
        this.add(contStorageOranization, new KDLayout.Constraints(66, 350, 270, 19, 0));
        chkisBatchFilter.setBounds(new Rectangle(66, 388, 270, 19));
        this.add(chkisBatchFilter, new KDLayout.Constraints(66, 388, 270, 19, 0));
        chkisReturn.setBounds(new Rectangle(66, 412, 270, 19));
        this.add(chkisReturn, new KDLayout.Constraints(66, 412, 270, 19, 0));
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contBosType
        contBosType.setBoundEditor(txtBosType);
        //contquery
        contquery.setBoundEditor(txtquery);
        //conttargetSystem
        conttargetSystem.setBoundEditor(prmttargetSystem);
        //contimplClass
        contimplClass.setBoundEditor(txtimplClass);
        //contbatchQuery
        contbatchQuery.setBoundEditor(txtbatchQuery);
        //contStorageOranization
        contStorageOranization.setBoundEditor(prmtStorageOranization);

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
		dataBinder.registerBinding("isBatchFilter", boolean.class, this.chkisBatchFilter, "selected");
		dataBinder.registerBinding("isReturn", boolean.class, this.chkisReturn, "selected");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("BosType", String.class, this.txtBosType, "text");
		dataBinder.registerBinding("query", String.class, this.txtquery, "text");
		dataBinder.registerBinding("targetSystem", com.kingdee.eas.custom.tocloud.TargetSystemInfo.class, this.prmttargetSystem, "data");
		dataBinder.registerBinding("implClass", String.class, this.txtimplClass, "text");
		dataBinder.registerBinding("batchQuery", String.class, this.txtbatchQuery, "text");
		dataBinder.registerBinding("StorageOranization", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtStorageOranization, "data");		
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
	    return "com.kingdee.eas.custom.tocloud.app.BizTypeEditUIHandler";
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
        this.txtquery.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.tocloud.BizTypeInfo)ov;
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
		getValidateHelper().registerBindProperty("isBatchFilter", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isReturn", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BosType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("query", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("targetSystem", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("implClass", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batchQuery", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StorageOranization", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("isBatchFilter"));
        sic.add(new SelectorItemInfo("isReturn"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("simpleName"));
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("BosType"));
        sic.add(new SelectorItemInfo("query"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("targetSystem.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("targetSystem.id"));
        	sic.add(new SelectorItemInfo("targetSystem.number"));
        	sic.add(new SelectorItemInfo("targetSystem.name"));
		}
        sic.add(new SelectorItemInfo("implClass"));
        sic.add(new SelectorItemInfo("batchQuery"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("StorageOranization.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("StorageOranization.id"));
        	sic.add(new SelectorItemInfo("StorageOranization.number"));
        	sic.add(new SelectorItemInfo("StorageOranization.name"));
		}
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.tocloud.client", "BizTypeEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.tocloud.client.BizTypeEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.tocloud.BizTypeFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.tocloud.BizTypeInfo objectValue = new com.kingdee.eas.custom.tocloud.BizTypeInfo();
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