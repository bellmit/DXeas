/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.sewagedetection.client;

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
public abstract class AbstractCheckItemEditUI extends com.kingdee.eas.custom.wlhllicensemanager.client.WlhlBaseEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCheckItemEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contupperLimit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continIndex;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtupperLimit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtinIndex;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.eas.custom.taihe.sewagedetection.CheckItemInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractCheckItemEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCheckItemEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.contupperLimit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continIndex = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtupperLimit = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtinIndex = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.contupperLimit.setName("contupperLimit");
        this.continIndex.setName("continIndex");
        this.contcompany.setName("contcompany");
        this.txtupperLimit.setName("txtupperLimit");
        this.txtinIndex.setName("txtinIndex");
        this.prmtcompany.setName("prmtcompany");
        // CoreUI		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelLength(100);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelLength(100);		
        this.kDLabelContainer3.setBoundLabelUnderline(true);		
        this.kDLabelContainer3.setVisible(false);		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelAlignment(7);		
        this.kDLabelContainer4.setVisible(false);		
        this.contapprover.setBoundLabelText(resHelper.getString("contapprover.boundLabelText"));		
        this.contapprover.setBoundLabelLength(100);		
        this.contapprover.setBoundLabelUnderline(true);		
        this.contapprover.setVisible(true);		
        this.contapproveTime.setBoundLabelText(resHelper.getString("contapproveTime.boundLabelText"));		
        this.contapproveTime.setBoundLabelLength(100);		
        this.contapproveTime.setBoundLabelUnderline(true);		
        this.contapproveTime.setVisible(true);		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);		
        this.contcreator.setBoundLabelText(resHelper.getString("contcreator.boundLabelText"));		
        this.contcreator.setBoundLabelLength(100);		
        this.contcreator.setBoundLabelUnderline(true);		
        this.contcreator.setVisible(true);		
        this.contcreateTime.setBoundLabelText(resHelper.getString("contcreateTime.boundLabelText"));		
        this.contcreateTime.setBoundLabelLength(100);		
        this.contcreateTime.setBoundLabelUnderline(true);		
        this.contcreateTime.setVisible(true);		
        this.txtNumber.setMaxLength(80);		
        this.txtSimpleName.setMaxLength(80);		
        this.txtSimpleName.setVisible(false);		
        this.txtDescription.setVisible(false);		
        this.prmtapprover.setEditable(true);		
        this.prmtapprover.setDisplayFormat("$number$");		
        this.prmtapprover.setEditFormat("$number$");		
        this.prmtapprover.setCommitFormat("$number$");		
        this.prmtapprover.setRequired(false);		
        this.prmtapprover.setEnabled(false);		
        this.pkapproveTime.setRequired(false);		
        this.pkapproveTime.setEnabled(false);		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.wlhllicensemanager.UsedStatusEnum").toArray());		
        this.baseStatus.setRequired(false);		
        this.prmtcreator.setEditable(true);		
        this.prmtcreator.setDisplayFormat("$name$");		
        this.prmtcreator.setEditFormat("$number$");		
        this.prmtcreator.setCommitFormat("$number$");		
        this.prmtcreator.setRequired(false);		
        this.prmtcreator.setEnabled(false);		
        this.pkcreateTime.setRequired(false);		
        this.pkcreateTime.setEnabled(false);
        // contupperLimit		
        this.contupperLimit.setBoundLabelText(resHelper.getString("contupperLimit.boundLabelText"));		
        this.contupperLimit.setBoundLabelLength(100);		
        this.contupperLimit.setBoundLabelUnderline(true);		
        this.contupperLimit.setVisible(true);
        // continIndex		
        this.continIndex.setBoundLabelText(resHelper.getString("continIndex.boundLabelText"));		
        this.continIndex.setBoundLabelLength(100);		
        this.continIndex.setBoundLabelUnderline(true);		
        this.continIndex.setVisible(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // txtupperLimit		
        this.txtupperLimit.setHorizontalAlignment(2);		
        this.txtupperLimit.setDataType(1);		
        this.txtupperLimit.setSupportedEmpty(true);		
        this.txtupperLimit.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtupperLimit.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtupperLimit.setPrecision(4);		
        this.txtupperLimit.setRequired(false);
        // txtinIndex		
        this.txtinIndex.setVisible(true);		
        this.txtinIndex.setHorizontalAlignment(2);		
        this.txtinIndex.setDataType(1);		
        this.txtinIndex.setSupportedEmpty(true);		
        this.txtinIndex.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtinIndex.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtinIndex.setPrecision(4);		
        this.txtinIndex.setRequired(false);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setVisible(true);		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtapprover,pkapproveTime,baseStatus,txtName,txtNumber,txtDescription,txtSimpleName,prmtcreator,pkcreateTime,txtupperLimit,txtinIndex,prmtcompany}));
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
        this.setBounds(new Rectangle(0, 0, 306, 390));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(15, 16, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(15, 48, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(541, 84, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(541, 118, 270, 19));
        this.add(kDLabelContainer4, null);
        contapprover.setBounds(new Rectangle(15, 303, 270, 19));
        this.add(contapprover, null);
        contapproveTime.setBounds(new Rectangle(15, 342, 270, 19));
        this.add(contapproveTime, null);
        contbaseStatus.setBounds(new Rectangle(14, 85, 270, 19));
        this.add(contbaseStatus, null);
        contcreator.setBounds(new Rectangle(15, 264, 270, 19));
        this.add(contcreator, null);
        contcreateTime.setBounds(new Rectangle(15, 226, 270, 19));
        this.add(contcreateTime, null);
        contupperLimit.setBounds(new Rectangle(14, 155, 270, 19));
        this.add(contupperLimit, null);
        continIndex.setBounds(new Rectangle(15, 191, 270, 19));
        this.add(continIndex, null);
        contcompany.setBounds(new Rectangle(14, 120, 270, 19));
        this.add(contcompany, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contapprover
        contapprover.setBoundEditor(prmtapprover);
        //contapproveTime
        contapproveTime.setBoundEditor(pkapproveTime);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //contcreator
        contcreator.setBoundEditor(prmtcreator);
        //contcreateTime
        contcreateTime.setBoundEditor(pkcreateTime);
        //contupperLimit
        contupperLimit.setBoundEditor(txtupperLimit);
        //continIndex
        continIndex.setBoundEditor(txtinIndex);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);

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
        menuBiz.add(mBtnApprove);
        menuBiz.add(mBtnUnApprove);
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
        this.toolBar.add(tBtnApprove);
        this.toolBar.add(tBtnUnApprove);
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
        this.toolBar.add(btnAttachment);
        this.toolBar.add(separatorFW1);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("approver", com.kingdee.eas.base.permission.UserInfo.class, this.prmtapprover, "data");
		dataBinder.registerBinding("approveTime", java.util.Date.class, this.pkapproveTime, "value");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.custom.wlhllicensemanager.UsedStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtcreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.pkcreateTime, "value");
		dataBinder.registerBinding("upperLimit", java.math.BigDecimal.class, this.txtupperLimit, "value");
		dataBinder.registerBinding("inIndex", java.math.BigDecimal.class, this.txtinIndex, "value");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");		
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
	    return "com.kingdee.eas.custom.taihe.sewagedetection.app.CheckItemEditUIHandler";
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
        this.prmtapprover.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.taihe.sewagedetection.CheckItemInfo)ov;
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
	 * ????????��??
	 */
	protected void registerValidator() {
    	getValidateHelper().setCustomValidator( getValidator() );
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("approver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("approveTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("upperLimit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("inIndex", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    		
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
			sic.add(new SelectorItemInfo("approver.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("approver.id"));
        	sic.add(new SelectorItemInfo("approver.number"));
        	sic.add(new SelectorItemInfo("approver.name"));
		}
        sic.add(new SelectorItemInfo("approveTime"));
        sic.add(new SelectorItemInfo("baseStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("creator.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("creator.id"));
        	sic.add(new SelectorItemInfo("creator.number"));
        	sic.add(new SelectorItemInfo("creator.name"));
		}
        sic.add(new SelectorItemInfo("createTime"));
        sic.add(new SelectorItemInfo("upperLimit"));
        sic.add(new SelectorItemInfo("inIndex"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.taihe.sewagedetection.client", "CheckItemEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.taihe.sewagedetection.client.CheckItemEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.taihe.sewagedetection.CheckItemFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.taihe.sewagedetection.CheckItemInfo objectValue = new com.kingdee.eas.custom.taihe.sewagedetection.CheckItemInfo();
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