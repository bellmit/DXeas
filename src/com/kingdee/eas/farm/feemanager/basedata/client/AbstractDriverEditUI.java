/**
 * output package name
 */
package com.kingdee.eas.farm.feemanager.basedata.client;

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
public abstract class AbstractDriverEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractDriverEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdrivername;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdriverplace;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdrivercardid;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdriverage;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdrivercarinfo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdriverphone;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCompanyOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdrivername;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdriverplace;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdrivercardid;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdriverage;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdrivercarinfo;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdriverphone;
    protected com.kingdee.bos.ctrl.swing.KDComboBox state;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCompanyOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton review;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton unreview;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.farm.feemanager.basedata.DriverInfo editData = null;
    protected ActionReview actionReview = null;
    protected ActionUnreview actionUnreview = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractDriverEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractDriverEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        //actionReview
        this.actionReview = new ActionReview(this);
        getActionManager().registerAction("actionReview", actionReview);
        this.actionReview.setExtendProperty("canForewarn", "true");
        this.actionReview.setExtendProperty("userDefined", "false");
        this.actionReview.setExtendProperty("isObjectUpdateLock", "false");
         this.actionReview.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionReview.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionUnreview
        this.actionUnreview = new ActionUnreview(this);
        getActionManager().registerAction("actionUnreview", actionUnreview);
        this.actionUnreview.setExtendProperty("canForewarn", "true");
        this.actionUnreview.setExtendProperty("userDefined", "false");
        this.actionUnreview.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnreview.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnreview.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionAudit
        this.actionAudit = new ActionAudit(this);
        getActionManager().registerAction("actionAudit", actionAudit);
        this.actionAudit.setExtendProperty("canForewarn", "true");
        this.actionAudit.setExtendProperty("userDefined", "true");
        this.actionAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionUnAudit
        this.actionUnAudit = new ActionUnAudit(this);
        getActionManager().registerAction("actionUnAudit", actionUnAudit);
        this.actionUnAudit.setExtendProperty("canForewarn", "true");
        this.actionUnAudit.setExtendProperty("userDefined", "true");
        this.actionUnAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contdrivername = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdriverplace = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdrivercardid = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdriverage = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdrivercarinfo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdriverphone = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCompanyOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtdrivername = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtdriverplace = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtdrivercardid = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtdriverage = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtdrivercarinfo = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtdriverphone = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.state = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtCompanyOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.review = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.unreview = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contdrivername.setName("contdrivername");
        this.contdriverplace.setName("contdriverplace");
        this.contdrivercardid.setName("contdrivercardid");
        this.contdriverage.setName("contdriverage");
        this.contdrivercarinfo.setName("contdrivercarinfo");
        this.contdriverphone.setName("contdriverphone");
        this.contstate.setName("contstate");
        this.contCompanyOrgUnit.setName("contCompanyOrgUnit");
        this.contbaseStatus.setName("contbaseStatus");
        this.txtdrivername.setName("txtdrivername");
        this.txtdriverplace.setName("txtdriverplace");
        this.txtdrivercardid.setName("txtdrivercardid");
        this.txtdriverage.setName("txtdriverage");
        this.txtdrivercarinfo.setName("txtdrivercarinfo");
        this.txtdriverphone.setName("txtdriverphone");
        this.state.setName("state");
        this.prmtCompanyOrgUnit.setName("prmtCompanyOrgUnit");
        this.baseStatus.setName("baseStatus");
        this.review.setName("review");
        this.unreview.setName("unreview");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
        // CoreUI		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);
        // contdrivername		
        this.contdrivername.setBoundLabelText(resHelper.getString("contdrivername.boundLabelText"));		
        this.contdrivername.setBoundLabelLength(100);		
        this.contdrivername.setBoundLabelUnderline(true);		
        this.contdrivername.setVisible(true);
        // contdriverplace		
        this.contdriverplace.setBoundLabelText(resHelper.getString("contdriverplace.boundLabelText"));		
        this.contdriverplace.setBoundLabelLength(100);		
        this.contdriverplace.setBoundLabelUnderline(true);		
        this.contdriverplace.setVisible(true);
        // contdrivercardid		
        this.contdrivercardid.setBoundLabelText(resHelper.getString("contdrivercardid.boundLabelText"));		
        this.contdrivercardid.setBoundLabelLength(100);		
        this.contdrivercardid.setBoundLabelUnderline(true);		
        this.contdrivercardid.setVisible(true);
        // contdriverage		
        this.contdriverage.setBoundLabelText(resHelper.getString("contdriverage.boundLabelText"));		
        this.contdriverage.setBoundLabelLength(100);		
        this.contdriverage.setBoundLabelUnderline(true);		
        this.contdriverage.setVisible(true);
        // contdrivercarinfo		
        this.contdrivercarinfo.setBoundLabelText(resHelper.getString("contdrivercarinfo.boundLabelText"));		
        this.contdrivercarinfo.setBoundLabelLength(100);		
        this.contdrivercarinfo.setBoundLabelUnderline(true);		
        this.contdrivercarinfo.setVisible(true);
        // contdriverphone		
        this.contdriverphone.setBoundLabelText(resHelper.getString("contdriverphone.boundLabelText"));		
        this.contdriverphone.setBoundLabelLength(100);		
        this.contdriverphone.setBoundLabelUnderline(true);		
        this.contdriverphone.setVisible(true);
        // contstate		
        this.contstate.setBoundLabelText(resHelper.getString("contstate.boundLabelText"));		
        this.contstate.setBoundLabelLength(100);		
        this.contstate.setBoundLabelUnderline(true);		
        this.contstate.setVisible(false);
        // contCompanyOrgUnit		
        this.contCompanyOrgUnit.setBoundLabelText(resHelper.getString("contCompanyOrgUnit.boundLabelText"));		
        this.contCompanyOrgUnit.setBoundLabelLength(100);		
        this.contCompanyOrgUnit.setBoundLabelUnderline(true);		
        this.contCompanyOrgUnit.setVisible(true);
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);
        // txtdrivername		
        this.txtdrivername.setVisible(true);		
        this.txtdrivername.setHorizontalAlignment(2);		
        this.txtdrivername.setMaxLength(100);		
        this.txtdrivername.setRequired(false);
        // txtdriverplace		
        this.txtdriverplace.setVisible(true);		
        this.txtdriverplace.setHorizontalAlignment(2);		
        this.txtdriverplace.setMaxLength(100);		
        this.txtdriverplace.setRequired(false);
        // txtdrivercardid		
        this.txtdrivercardid.setVisible(true);		
        this.txtdrivercardid.setHorizontalAlignment(2);		
        this.txtdrivercardid.setMaxLength(100);		
        this.txtdrivercardid.setRequired(false);
        // txtdriverage		
        this.txtdriverage.setVisible(true);		
        this.txtdriverage.setHorizontalAlignment(2);		
        this.txtdriverage.setMaxLength(100);		
        this.txtdriverage.setRequired(false);
        // txtdrivercarinfo		
        this.txtdrivercarinfo.setVisible(true);		
        this.txtdrivercarinfo.setHorizontalAlignment(2);		
        this.txtdrivercarinfo.setMaxLength(100);		
        this.txtdrivercarinfo.setRequired(false);
        // txtdriverphone		
        this.txtdriverphone.setVisible(true);		
        this.txtdriverphone.setHorizontalAlignment(2);		
        this.txtdriverphone.setMaxLength(100);		
        this.txtdriverphone.setRequired(false);
        // state		
        this.state.setVisible(false);		
        this.state.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.state.setRequired(false);		
        this.state.setEnabled(false);
        // prmtCompanyOrgUnit		
        this.prmtCompanyOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtCompanyOrgUnit.setVisible(true);		
        this.prmtCompanyOrgUnit.setEditable(true);		
        this.prmtCompanyOrgUnit.setDisplayFormat("$name$");		
        this.prmtCompanyOrgUnit.setEditFormat("$number$");		
        this.prmtCompanyOrgUnit.setCommitFormat("$number$");		
        this.prmtCompanyOrgUnit.setRequired(true);
        // baseStatus		
        this.baseStatus.setVisible(true);		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(false);		
        this.baseStatus.setEnabled(false);
        // review
        this.review.setAction((IItemAction)ActionProxyFactory.getProxy(actionReview, new Class[] { IItemAction.class }, getServiceContext()));		
        this.review.setText(resHelper.getString("review.text"));
        // unreview
        this.unreview.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnreview, new Class[] { IItemAction.class }, getServiceContext()));		
        this.unreview.setText(resHelper.getString("unreview.text"));
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtdrivername,txtdriverplace,txtdrivercardid,txtdriverage,txtdrivercarinfo,txtdriverphone,state,prmtCompanyOrgUnit,baseStatus}));
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
        this.setBounds(new Rectangle(0, 0, 430, 509));
        this.setLayout(null);
        contdrivername.setBounds(new Rectangle(70, 76, 270, 19));
        this.add(contdrivername, null);
        contdriverplace.setBounds(new Rectangle(71, 124, 270, 19));
        this.add(contdriverplace, null);
        contdrivercardid.setBounds(new Rectangle(70, 177, 270, 19));
        this.add(contdrivercardid, null);
        contdriverage.setBounds(new Rectangle(70, 290, 270, 19));
        this.add(contdriverage, null);
        contdrivercarinfo.setBounds(new Rectangle(69, 350, 270, 19));
        this.add(contdrivercarinfo, null);
        contdriverphone.setBounds(new Rectangle(71, 231, 270, 19));
        this.add(contdriverphone, null);
        contstate.setBounds(new Rectangle(419, 368, 270, 19));
        this.add(contstate, null);
        contCompanyOrgUnit.setBounds(new Rectangle(71, 31, 270, 19));
        this.add(contCompanyOrgUnit, null);
        contbaseStatus.setBounds(new Rectangle(71, 404, 270, 19));
        this.add(contbaseStatus, null);
        //contdrivername
        contdrivername.setBoundEditor(txtdrivername);
        //contdriverplace
        contdriverplace.setBoundEditor(txtdriverplace);
        //contdrivercardid
        contdrivercardid.setBoundEditor(txtdrivercardid);
        //contdriverage
        contdriverage.setBoundEditor(txtdriverage);
        //contdrivercarinfo
        contdrivercarinfo.setBoundEditor(txtdrivercarinfo);
        //contdriverphone
        contdriverphone.setBoundEditor(txtdriverphone);
        //contstate
        contstate.setBoundEditor(state);
        //contCompanyOrgUnit
        contCompanyOrgUnit.setBoundEditor(prmtCompanyOrgUnit);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);

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
        this.toolBar.add(review);
        this.toolBar.add(unreview);
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("drivername", String.class, this.txtdrivername, "text");
		dataBinder.registerBinding("driverplace", String.class, this.txtdriverplace, "text");
		dataBinder.registerBinding("drivercardid", String.class, this.txtdrivercardid, "text");
		dataBinder.registerBinding("driverage", String.class, this.txtdriverage, "text");
		dataBinder.registerBinding("drivercarinfo", String.class, this.txtdrivercarinfo, "text");
		dataBinder.registerBinding("driverphone", String.class, this.txtdriverphone, "text");
		dataBinder.registerBinding("state", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.state, "selectedItem");
		dataBinder.registerBinding("CompanyOrgUnit", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtCompanyOrgUnit, "data");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.class, this.baseStatus, "selectedItem");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.feemanager.basedata.app.DriverEditUIHandler";
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
        this.txtdrivername.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.feemanager.basedata.DriverInfo)ov;
    }

    /**
     * output loadFields method
     */
    public void loadFields()
    {
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
		getValidateHelper().registerBindProperty("drivername", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("driverplace", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("drivercardid", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("driverage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("drivercarinfo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("driverphone", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("state", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CompanyOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    		
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
        if (STATUS_ADDNEW.equals(this.oprtState)) {
        } else if (STATUS_EDIT.equals(this.oprtState)) {
        } else if (STATUS_VIEW.equals(this.oprtState)) {
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
        sic.add(new SelectorItemInfo("drivername"));
        sic.add(new SelectorItemInfo("driverplace"));
        sic.add(new SelectorItemInfo("drivercardid"));
        sic.add(new SelectorItemInfo("driverage"));
        sic.add(new SelectorItemInfo("drivercarinfo"));
        sic.add(new SelectorItemInfo("driverphone"));
        sic.add(new SelectorItemInfo("state"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("CompanyOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("CompanyOrgUnit.id"));
        	sic.add(new SelectorItemInfo("CompanyOrgUnit.number"));
        	sic.add(new SelectorItemInfo("CompanyOrgUnit.name"));
		}
        sic.add(new SelectorItemInfo("baseStatus"));
        return sic;
    }        
    	

    /**
     * output actionReview_actionPerformed method
     */
    public void actionReview_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.feemanager.basedata.DriverFactory.getRemoteInstance().review(editData);
    }
    	

    /**
     * output actionUnreview_actionPerformed method
     */
    public void actionUnreview_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.feemanager.basedata.DriverFactory.getRemoteInstance().unreview(editData);
    }
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.feemanager.basedata.DriverFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.feemanager.basedata.DriverFactory.getRemoteInstance().unAudit(editData);
    }
	public RequestContext prepareActionReview(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionReview() {
    	return false;
    }
	public RequestContext prepareActionUnreview(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionUnreview() {
    	return false;
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
     * output ActionReview class
     */     
    protected class ActionReview extends ItemAction {     
    
        public ActionReview()
        {
            this(null);
        }

        public ActionReview(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionReview.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionReview.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionReview.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractDriverEditUI.this, "ActionReview", "actionReview_actionPerformed", e);
        }
    }

    /**
     * output ActionUnreview class
     */     
    protected class ActionUnreview extends ItemAction {     
    
        public ActionUnreview()
        {
            this(null);
        }

        public ActionUnreview(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionUnreview.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnreview.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnreview.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractDriverEditUI.this, "ActionUnreview", "actionUnreview_actionPerformed", e);
        }
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
            innerActionPerformed("eas", AbstractDriverEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractDriverEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.feemanager.basedata.client", "DriverEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.feemanager.basedata.client.DriverEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.feemanager.basedata.DriverFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.feemanager.basedata.DriverInfo objectValue = new com.kingdee.eas.farm.feemanager.basedata.DriverInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtCompanyOrgUnit.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
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
		vo.put("state",new Integer(-1));
vo.put("baseStatus",new Integer(1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}