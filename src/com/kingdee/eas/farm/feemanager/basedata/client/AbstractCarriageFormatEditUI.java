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
public abstract class AbstractCarriageFormatEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCarriageFormatEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcarriagename;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcarriagesize;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contFKilpfreightkil;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCompanyOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstartdate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contenddate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcarriagename;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcarriagesize;
    protected com.kingdee.bos.ctrl.swing.KDComboBox state;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtFKilpfreightkil;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCompanyOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkstartdate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkenddate;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton review;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton unreview;
    protected com.kingdee.eas.farm.feemanager.basedata.CarriageFormatInfo editData = null;
    protected ActionReview actionReview = null;
    protected ActionUnreview actionUnreview = null;
    /**
     * output class constructor
     */
    public AbstractCarriageFormatEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCarriageFormatEditUI.class.getName());
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
        this.contcarriagename = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcarriagesize = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contFKilpfreightkil = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCompanyOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstartdate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contenddate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtcarriagename = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcarriagesize = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.state = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtFKilpfreightkil = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtCompanyOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkstartdate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkenddate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.review = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.unreview = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contcarriagename.setName("contcarriagename");
        this.contcarriagesize.setName("contcarriagesize");
        this.contstate.setName("contstate");
        this.contFKilpfreightkil.setName("contFKilpfreightkil");
        this.contCompanyOrgUnit.setName("contCompanyOrgUnit");
        this.contstartdate.setName("contstartdate");
        this.contenddate.setName("contenddate");
        this.txtcarriagename.setName("txtcarriagename");
        this.txtcarriagesize.setName("txtcarriagesize");
        this.state.setName("state");
        this.txtFKilpfreightkil.setName("txtFKilpfreightkil");
        this.prmtCompanyOrgUnit.setName("prmtCompanyOrgUnit");
        this.pkstartdate.setName("pkstartdate");
        this.pkenddate.setName("pkenddate");
        this.review.setName("review");
        this.unreview.setName("unreview");
        // CoreUI		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);
        // contcarriagename		
        this.contcarriagename.setBoundLabelText(resHelper.getString("contcarriagename.boundLabelText"));		
        this.contcarriagename.setBoundLabelLength(100);		
        this.contcarriagename.setBoundLabelUnderline(true);		
        this.contcarriagename.setVisible(true);
        // contcarriagesize		
        this.contcarriagesize.setBoundLabelText(resHelper.getString("contcarriagesize.boundLabelText"));		
        this.contcarriagesize.setBoundLabelLength(100);		
        this.contcarriagesize.setBoundLabelUnderline(true);		
        this.contcarriagesize.setVisible(true);
        // contstate		
        this.contstate.setBoundLabelText(resHelper.getString("contstate.boundLabelText"));		
        this.contstate.setBoundLabelLength(100);		
        this.contstate.setBoundLabelUnderline(true);		
        this.contstate.setVisible(true);
        // contFKilpfreightkil		
        this.contFKilpfreightkil.setBoundLabelText(resHelper.getString("contFKilpfreightkil.boundLabelText"));		
        this.contFKilpfreightkil.setBoundLabelLength(100);		
        this.contFKilpfreightkil.setBoundLabelUnderline(true);		
        this.contFKilpfreightkil.setVisible(true);
        // contCompanyOrgUnit		
        this.contCompanyOrgUnit.setBoundLabelText(resHelper.getString("contCompanyOrgUnit.boundLabelText"));		
        this.contCompanyOrgUnit.setBoundLabelLength(100);		
        this.contCompanyOrgUnit.setBoundLabelUnderline(true);		
        this.contCompanyOrgUnit.setVisible(true);
        // contstartdate		
        this.contstartdate.setBoundLabelText(resHelper.getString("contstartdate.boundLabelText"));		
        this.contstartdate.setBoundLabelLength(100);		
        this.contstartdate.setBoundLabelUnderline(true);		
        this.contstartdate.setVisible(true);
        // contenddate		
        this.contenddate.setBoundLabelText(resHelper.getString("contenddate.boundLabelText"));		
        this.contenddate.setBoundLabelLength(100);		
        this.contenddate.setBoundLabelUnderline(true);		
        this.contenddate.setVisible(true);
        // txtcarriagename		
        this.txtcarriagename.setVisible(true);		
        this.txtcarriagename.setHorizontalAlignment(2);		
        this.txtcarriagename.setMaxLength(100);		
        this.txtcarriagename.setRequired(false);
        // txtcarriagesize		
        this.txtcarriagesize.setVisible(true);		
        this.txtcarriagesize.setHorizontalAlignment(2);		
        this.txtcarriagesize.setMaxLength(100);		
        this.txtcarriagesize.setRequired(false);
        // state		
        this.state.setVisible(true);		
        this.state.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.state.setRequired(false);		
        this.state.setEnabled(false);
        // txtFKilpfreightkil		
        this.txtFKilpfreightkil.setVisible(true);		
        this.txtFKilpfreightkil.setHorizontalAlignment(2);		
        this.txtFKilpfreightkil.setDataType(1);		
        this.txtFKilpfreightkil.setSupportedEmpty(true);		
        this.txtFKilpfreightkil.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtFKilpfreightkil.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtFKilpfreightkil.setPrecision(2);		
        this.txtFKilpfreightkil.setRequired(false);
        // prmtCompanyOrgUnit		
        this.prmtCompanyOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtCompanyOrgUnit.setVisible(true);		
        this.prmtCompanyOrgUnit.setEditable(true);		
        this.prmtCompanyOrgUnit.setDisplayFormat("$name$");		
        this.prmtCompanyOrgUnit.setEditFormat("$number$");		
        this.prmtCompanyOrgUnit.setCommitFormat("$number$");		
        this.prmtCompanyOrgUnit.setRequired(true);
        // pkstartdate		
        this.pkstartdate.setVisible(true);		
        this.pkstartdate.setRequired(false);
        // pkenddate		
        this.pkenddate.setVisible(true);		
        this.pkenddate.setRequired(false);
        // review
        this.review.setAction((IItemAction)ActionProxyFactory.getProxy(actionReview, new Class[] { IItemAction.class }, getServiceContext()));		
        this.review.setText(resHelper.getString("review.text"));
        // unreview
        this.unreview.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnreview, new Class[] { IItemAction.class }, getServiceContext()));		
        this.unreview.setText(resHelper.getString("unreview.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtcarriagename,txtcarriagesize,state,txtFKilpfreightkil,prmtCompanyOrgUnit,pkstartdate,pkenddate}));
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
        this.setBounds(new Rectangle(0, 0, 400, 350));
        this.setLayout(null);
        contcarriagename.setBounds(new Rectangle(47, 89, 270, 19));
        this.add(contcarriagename, null);
        contcarriagesize.setBounds(new Rectangle(46, 135, 270, 19));
        this.add(contcarriagesize, null);
        contstate.setBounds(new Rectangle(46, 230, 270, 19));
        this.add(contstate, null);
        contFKilpfreightkil.setBounds(new Rectangle(45, 179, 270, 19));
        this.add(contFKilpfreightkil, null);
        contCompanyOrgUnit.setBounds(new Rectangle(48, 41, 270, 19));
        this.add(contCompanyOrgUnit, null);
        contstartdate.setBounds(new Rectangle(46, 279, 270, 19));
        this.add(contstartdate, null);
        contenddate.setBounds(new Rectangle(47, 320, 270, 19));
        this.add(contenddate, null);
        //contcarriagename
        contcarriagename.setBoundEditor(txtcarriagename);
        //contcarriagesize
        contcarriagesize.setBoundEditor(txtcarriagesize);
        //contstate
        contstate.setBoundEditor(state);
        //contFKilpfreightkil
        contFKilpfreightkil.setBoundEditor(txtFKilpfreightkil);
        //contCompanyOrgUnit
        contCompanyOrgUnit.setBoundEditor(prmtCompanyOrgUnit);
        //contstartdate
        contstartdate.setBoundEditor(pkstartdate);
        //contenddate
        contenddate.setBoundEditor(pkenddate);

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
        this.toolBar.add(review);
        this.toolBar.add(unreview);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("carriagename", String.class, this.txtcarriagename, "text");
		dataBinder.registerBinding("carriagesize", String.class, this.txtcarriagesize, "text");
		dataBinder.registerBinding("state", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.state, "selectedItem");
		dataBinder.registerBinding("FKilpfreightkil", java.math.BigDecimal.class, this.txtFKilpfreightkil, "value");
		dataBinder.registerBinding("CompanyOrgUnit", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtCompanyOrgUnit, "data");
		dataBinder.registerBinding("startdate", java.util.Date.class, this.pkstartdate, "value");
		dataBinder.registerBinding("enddate", java.util.Date.class, this.pkenddate, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.feemanager.basedata.app.CarriageFormatEditUIHandler";
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
        this.txtcarriagename.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.feemanager.basedata.CarriageFormatInfo)ov;
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
		getValidateHelper().registerBindProperty("carriagename", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("carriagesize", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("state", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FKilpfreightkil", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CompanyOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("startdate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("enddate", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("carriagename"));
        sic.add(new SelectorItemInfo("carriagesize"));
        sic.add(new SelectorItemInfo("state"));
        sic.add(new SelectorItemInfo("FKilpfreightkil"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("CompanyOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("CompanyOrgUnit.id"));
        	sic.add(new SelectorItemInfo("CompanyOrgUnit.number"));
        	sic.add(new SelectorItemInfo("CompanyOrgUnit.name"));
		}
        sic.add(new SelectorItemInfo("startdate"));
        sic.add(new SelectorItemInfo("enddate"));
        return sic;
    }        
    	

    /**
     * output actionReview_actionPerformed method
     */
    public void actionReview_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.feemanager.basedata.CarriageFormatFactory.getRemoteInstance().review(editData);
    }
    	

    /**
     * output actionUnreview_actionPerformed method
     */
    public void actionUnreview_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.feemanager.basedata.CarriageFormatFactory.getRemoteInstance().unreview(editData);
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
            innerActionPerformed("eas", AbstractCarriageFormatEditUI.this, "ActionReview", "actionReview_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractCarriageFormatEditUI.this, "ActionUnreview", "actionUnreview_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.feemanager.basedata.client", "CarriageFormatEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.feemanager.basedata.client.CarriageFormatEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.feemanager.basedata.CarriageFormatFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.feemanager.basedata.CarriageFormatInfo objectValue = new com.kingdee.eas.farm.feemanager.basedata.CarriageFormatInfo();
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
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}