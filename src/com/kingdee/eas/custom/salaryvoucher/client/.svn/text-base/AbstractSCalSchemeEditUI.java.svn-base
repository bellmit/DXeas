/**
 * output package name
 */
package com.kingdee.eas.custom.salaryvoucher.client;

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
public abstract class AbstractSCalSchemeEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSCalSchemeEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsCalSchemeCode;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contscalSchemeName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contscalSchemeID;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperiodYear;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperiodMonth;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkenabled;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtsCalSchemeCode;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtscalSchemeName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtscalSchemeID;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtperiodYear;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtperiodMonth;
    protected com.kingdee.eas.custom.salaryvoucher.SCalSchemeInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractSCalSchemeEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractSCalSchemeEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsCalSchemeCode = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contscalSchemeName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contscalSchemeID = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperiodYear = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperiodMonth = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkenabled = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtsCalSchemeCode = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtscalSchemeName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtscalSchemeID = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtperiodYear = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtperiodMonth = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.contsCalSchemeCode.setName("contsCalSchemeCode");
        this.contscalSchemeName.setName("contscalSchemeName");
        this.contscalSchemeID.setName("contscalSchemeID");
        this.contperiodYear.setName("contperiodYear");
        this.contperiodMonth.setName("contperiodMonth");
        this.chkenabled.setName("chkenabled");
        this.txtNumber.setName("txtNumber");
        this.txtsCalSchemeCode.setName("txtsCalSchemeCode");
        this.txtscalSchemeName.setName("txtscalSchemeName");
        this.txtscalSchemeID.setName("txtscalSchemeID");
        this.txtperiodYear.setName("txtperiodYear");
        this.txtperiodMonth.setName("txtperiodMonth");
        // CoreUI		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);		
        this.kDLabelContainer1.setVisible(false);
        // contsCalSchemeCode		
        this.contsCalSchemeCode.setBoundLabelText(resHelper.getString("contsCalSchemeCode.boundLabelText"));		
        this.contsCalSchemeCode.setBoundLabelLength(100);		
        this.contsCalSchemeCode.setBoundLabelUnderline(true);		
        this.contsCalSchemeCode.setVisible(true);
        // contscalSchemeName		
        this.contscalSchemeName.setBoundLabelText(resHelper.getString("contscalSchemeName.boundLabelText"));		
        this.contscalSchemeName.setBoundLabelLength(100);		
        this.contscalSchemeName.setBoundLabelUnderline(true);		
        this.contscalSchemeName.setVisible(true);
        // contscalSchemeID		
        this.contscalSchemeID.setBoundLabelText(resHelper.getString("contscalSchemeID.boundLabelText"));		
        this.contscalSchemeID.setBoundLabelLength(100);		
        this.contscalSchemeID.setBoundLabelUnderline(true);		
        this.contscalSchemeID.setVisible(false);
        // contperiodYear		
        this.contperiodYear.setBoundLabelText(resHelper.getString("contperiodYear.boundLabelText"));		
        this.contperiodYear.setBoundLabelLength(100);		
        this.contperiodYear.setBoundLabelUnderline(true);		
        this.contperiodYear.setVisible(true);
        // contperiodMonth		
        this.contperiodMonth.setBoundLabelText(resHelper.getString("contperiodMonth.boundLabelText"));		
        this.contperiodMonth.setBoundLabelLength(100);		
        this.contperiodMonth.setBoundLabelUnderline(true);		
        this.contperiodMonth.setVisible(true);
        // chkenabled		
        this.chkenabled.setText(resHelper.getString("chkenabled.text"));		
        this.chkenabled.setVisible(true);		
        this.chkenabled.setHorizontalAlignment(2);
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setVisible(false);
        // txtsCalSchemeCode		
        this.txtsCalSchemeCode.setVisible(true);		
        this.txtsCalSchemeCode.setHorizontalAlignment(2);		
        this.txtsCalSchemeCode.setMaxLength(100);		
        this.txtsCalSchemeCode.setRequired(false);
        // txtscalSchemeName		
        this.txtscalSchemeName.setVisible(true);		
        this.txtscalSchemeName.setHorizontalAlignment(2);		
        this.txtscalSchemeName.setMaxLength(100);		
        this.txtscalSchemeName.setRequired(false);
        // txtscalSchemeID		
        this.txtscalSchemeID.setVisible(false);		
        this.txtscalSchemeID.setHorizontalAlignment(2);		
        this.txtscalSchemeID.setMaxLength(100);		
        this.txtscalSchemeID.setRequired(false);		
        this.txtscalSchemeID.setEnabled(false);
        // txtperiodYear		
        this.txtperiodYear.setVisible(true);		
        this.txtperiodYear.setHorizontalAlignment(2);		
        this.txtperiodYear.setDataType(0);		
        this.txtperiodYear.setSupportedEmpty(true);		
        this.txtperiodYear.setRequired(false);
        // txtperiodMonth		
        this.txtperiodMonth.setVisible(true);		
        this.txtperiodMonth.setHorizontalAlignment(2);		
        this.txtperiodMonth.setDataType(0);		
        this.txtperiodMonth.setSupportedEmpty(true);		
        this.txtperiodMonth.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtsCalSchemeCode,txtscalSchemeName,txtscalSchemeID,txtperiodYear,txtperiodMonth,chkenabled}));
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
        this.setBounds(new Rectangle(0, 0, 336, 254));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(214, 245, 270, 19));
        this.add(kDLabelContainer1, null);
        contsCalSchemeCode.setBounds(new Rectangle(33, 22, 270, 19));
        this.add(contsCalSchemeCode, null);
        contscalSchemeName.setBounds(new Rectangle(33, 68, 270, 19));
        this.add(contscalSchemeName, null);
        contscalSchemeID.setBounds(new Rectangle(229, 199, 270, 19));
        this.add(contscalSchemeID, null);
        contperiodYear.setBounds(new Rectangle(33, 114, 270, 19));
        this.add(contperiodYear, null);
        contperiodMonth.setBounds(new Rectangle(33, 160, 270, 19));
        this.add(contperiodMonth, null);
        chkenabled.setBounds(new Rectangle(33, 208, 270, 19));
        this.add(chkenabled, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //contsCalSchemeCode
        contsCalSchemeCode.setBoundEditor(txtsCalSchemeCode);
        //contscalSchemeName
        contscalSchemeName.setBoundEditor(txtscalSchemeName);
        //contscalSchemeID
        contscalSchemeID.setBoundEditor(txtscalSchemeID);
        //contperiodYear
        contperiodYear.setBoundEditor(txtperiodYear);
        //contperiodMonth
        contperiodMonth.setBoundEditor(txtperiodMonth);

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
		dataBinder.registerBinding("enabled", boolean.class, this.chkenabled, "selected");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("sCalSchemeCode", String.class, this.txtsCalSchemeCode, "text");
		dataBinder.registerBinding("scalSchemeName", String.class, this.txtscalSchemeName, "text");
		dataBinder.registerBinding("scalSchemeID", String.class, this.txtscalSchemeID, "text");
		dataBinder.registerBinding("periodYear", int.class, this.txtperiodYear, "value");
		dataBinder.registerBinding("periodMonth", int.class, this.txtperiodMonth, "value");		
	}
	//Regiester UI State
	private void registerUIState(){
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtNumber, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtNumber, ActionStateConst.ENABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtNumber, ActionStateConst.DISABLED);		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.salaryvoucher.app.SCalSchemeEditUIHandler";
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
        this.txtsCalSchemeCode.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.salaryvoucher.SCalSchemeInfo)ov;
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
		getValidateHelper().registerBindProperty("enabled", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sCalSchemeCode", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("scalSchemeName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("scalSchemeID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("periodYear", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("periodMonth", ValidateHelper.ON_SAVE);    		
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
        if (STATUS_ADDNEW.equals(this.oprtState)) {
		            this.txtNumber.setEnabled(true);
        } else if (STATUS_EDIT.equals(this.oprtState)) {
		            this.txtNumber.setEnabled(true);
        } else if (STATUS_VIEW.equals(this.oprtState)) {
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
        sic.add(new SelectorItemInfo("enabled"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("sCalSchemeCode"));
        sic.add(new SelectorItemInfo("scalSchemeName"));
        sic.add(new SelectorItemInfo("scalSchemeID"));
        sic.add(new SelectorItemInfo("periodYear"));
        sic.add(new SelectorItemInfo("periodMonth"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.salaryvoucher.client", "SCalSchemeEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.salaryvoucher.client.SCalSchemeEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.salaryvoucher.SCalSchemeFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.salaryvoucher.SCalSchemeInfo objectValue = new com.kingdee.eas.custom.salaryvoucher.SCalSchemeInfo();
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