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
public abstract class AbstractOilPriceEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractOilPriceEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoilname;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstartdate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdailyprice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstandardprice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompanyorgunit;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtoilname;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkstartdate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdailyprice;
    protected com.kingdee.bos.ctrl.swing.KDComboBox state;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtstandardprice;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompanyorgunit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton review;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton unreview;
    protected com.kingdee.eas.farm.feemanager.basedata.OilPriceInfo editData = null;
    protected ActionReview actionReview = null;
    protected ActionUnreview actionUnreview = null;
    /**
     * output class constructor
     */
    public AbstractOilPriceEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractOilPriceEditUI.class.getName());
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
        this.contoilname = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstartdate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdailyprice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstandardprice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompanyorgunit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtoilname = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkstartdate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtdailyprice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.state = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtstandardprice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtcompanyorgunit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.review = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.unreview = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contoilname.setName("contoilname");
        this.contstartdate.setName("contstartdate");
        this.contdailyprice.setName("contdailyprice");
        this.contstate.setName("contstate");
        this.contstandardprice.setName("contstandardprice");
        this.contcompanyorgunit.setName("contcompanyorgunit");
        this.txtoilname.setName("txtoilname");
        this.pkstartdate.setName("pkstartdate");
        this.txtdailyprice.setName("txtdailyprice");
        this.state.setName("state");
        this.txtstandardprice.setName("txtstandardprice");
        this.prmtcompanyorgunit.setName("prmtcompanyorgunit");
        this.review.setName("review");
        this.unreview.setName("unreview");
        // CoreUI		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);
        // contoilname		
        this.contoilname.setBoundLabelText(resHelper.getString("contoilname.boundLabelText"));		
        this.contoilname.setBoundLabelLength(100);		
        this.contoilname.setBoundLabelUnderline(true);		
        this.contoilname.setVisible(true);
        // contstartdate		
        this.contstartdate.setBoundLabelText(resHelper.getString("contstartdate.boundLabelText"));		
        this.contstartdate.setBoundLabelLength(100);		
        this.contstartdate.setBoundLabelUnderline(true);		
        this.contstartdate.setVisible(true);
        // contdailyprice		
        this.contdailyprice.setBoundLabelText(resHelper.getString("contdailyprice.boundLabelText"));		
        this.contdailyprice.setBoundLabelLength(100);		
        this.contdailyprice.setBoundLabelUnderline(true);		
        this.contdailyprice.setVisible(true);
        // contstate		
        this.contstate.setBoundLabelText(resHelper.getString("contstate.boundLabelText"));		
        this.contstate.setBoundLabelLength(100);		
        this.contstate.setBoundLabelUnderline(true);		
        this.contstate.setVisible(true);
        // contstandardprice		
        this.contstandardprice.setBoundLabelText(resHelper.getString("contstandardprice.boundLabelText"));		
        this.contstandardprice.setBoundLabelLength(100);		
        this.contstandardprice.setBoundLabelUnderline(true);		
        this.contstandardprice.setVisible(true);
        // contcompanyorgunit		
        this.contcompanyorgunit.setBoundLabelText(resHelper.getString("contcompanyorgunit.boundLabelText"));		
        this.contcompanyorgunit.setBoundLabelLength(100);		
        this.contcompanyorgunit.setBoundLabelUnderline(true);		
        this.contcompanyorgunit.setVisible(true);
        // txtoilname		
        this.txtoilname.setHorizontalAlignment(2);		
        this.txtoilname.setMaxLength(100);		
        this.txtoilname.setRequired(false);
        // pkstartdate		
        this.pkstartdate.setRequired(true);
        // txtdailyprice		
        this.txtdailyprice.setHorizontalAlignment(2);		
        this.txtdailyprice.setDataType(1);		
        this.txtdailyprice.setSupportedEmpty(true);		
        this.txtdailyprice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdailyprice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdailyprice.setPrecision(2);		
        this.txtdailyprice.setRequired(true);
        // state		
        this.state.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.state.setRequired(false);		
        this.state.setEnabled(false);
        // txtstandardprice		
        this.txtstandardprice.setVisible(true);		
        this.txtstandardprice.setHorizontalAlignment(2);		
        this.txtstandardprice.setDataType(1);		
        this.txtstandardprice.setSupportedEmpty(true);		
        this.txtstandardprice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtstandardprice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtstandardprice.setPrecision(2);		
        this.txtstandardprice.setRequired(false);		
        this.txtstandardprice.setEnabled(false);
        // prmtcompanyorgunit		
        this.prmtcompanyorgunit.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompanyorgunit.setVisible(true);		
        this.prmtcompanyorgunit.setEditable(true);		
        this.prmtcompanyorgunit.setDisplayFormat("$name$");		
        this.prmtcompanyorgunit.setEditFormat("$number$");		
        this.prmtcompanyorgunit.setCommitFormat("$number$");		
        this.prmtcompanyorgunit.setRequired(true);
        // review
        this.review.setAction((IItemAction)ActionProxyFactory.getProxy(actionReview, new Class[] { IItemAction.class }, getServiceContext()));		
        this.review.setText(resHelper.getString("review.text"));
        // unreview
        this.unreview.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnreview, new Class[] { IItemAction.class }, getServiceContext()));		
        this.unreview.setText(resHelper.getString("unreview.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtoilname,txtdailyprice,pkstartdate,state,txtstandardprice,prmtcompanyorgunit}));
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
        this.setBounds(new Rectangle(1, 0, 400, 520));
        this.setLayout(null);
        contoilname.setBounds(new Rectangle(58, 133, 270, 19));
        this.add(contoilname, null);
        contstartdate.setBounds(new Rectangle(61, 251, 270, 19));
        this.add(contstartdate, null);
        contdailyprice.setBounds(new Rectangle(59, 199, 270, 19));
        this.add(contdailyprice, null);
        contstate.setBounds(new Rectangle(62, 308, 270, 19));
        this.add(contstate, null);
        contstandardprice.setBounds(new Rectangle(-1160, 147, 270, 19));
        this.add(contstandardprice, null);
        contcompanyorgunit.setBounds(new Rectangle(60, 85, 270, 19));
        this.add(contcompanyorgunit, null);
        //contoilname
        contoilname.setBoundEditor(txtoilname);
        //contstartdate
        contstartdate.setBoundEditor(pkstartdate);
        //contdailyprice
        contdailyprice.setBoundEditor(txtdailyprice);
        //contstate
        contstate.setBoundEditor(state);
        //contstandardprice
        contstandardprice.setBoundEditor(txtstandardprice);
        //contcompanyorgunit
        contcompanyorgunit.setBoundEditor(prmtcompanyorgunit);

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
		dataBinder.registerBinding("oilname", String.class, this.txtoilname, "text");
		dataBinder.registerBinding("startdate", java.util.Date.class, this.pkstartdate, "value");
		dataBinder.registerBinding("dailyprice", java.math.BigDecimal.class, this.txtdailyprice, "value");
		dataBinder.registerBinding("state", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.state, "selectedItem");
		dataBinder.registerBinding("standardprice", java.math.BigDecimal.class, this.txtstandardprice, "value");
		dataBinder.registerBinding("companyorgunit", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompanyorgunit, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.feemanager.basedata.app.OilPriceEditUIHandler";
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
        this.txtoilname.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.feemanager.basedata.OilPriceInfo)ov;
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
		getValidateHelper().registerBindProperty("oilname", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("startdate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dailyprice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("state", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("standardprice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("companyorgunit", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("oilname"));
        sic.add(new SelectorItemInfo("startdate"));
        sic.add(new SelectorItemInfo("dailyprice"));
        sic.add(new SelectorItemInfo("state"));
        sic.add(new SelectorItemInfo("standardprice"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("companyorgunit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("companyorgunit.id"));
        	sic.add(new SelectorItemInfo("companyorgunit.number"));
        	sic.add(new SelectorItemInfo("companyorgunit.name"));
		}
        return sic;
    }        
    	

    /**
     * output actionReview_actionPerformed method
     */
    public void actionReview_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.feemanager.basedata.OilPriceFactory.getRemoteInstance().review(editData);
    }
    	

    /**
     * output actionUnreview_actionPerformed method
     */
    public void actionUnreview_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.feemanager.basedata.OilPriceFactory.getRemoteInstance().unreview(editData);
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
            innerActionPerformed("eas", AbstractOilPriceEditUI.this, "ActionReview", "actionReview_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractOilPriceEditUI.this, "ActionUnreview", "actionUnreview_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.feemanager.basedata.client", "OilPriceEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.feemanager.basedata.client.OilPriceEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.feemanager.basedata.OilPriceFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.feemanager.basedata.OilPriceInfo objectValue = new com.kingdee.eas.farm.feemanager.basedata.OilPriceInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkstartdate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"生效日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtdailyprice.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"油品今日价格"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompanyorgunit.getData())) {
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