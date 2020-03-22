/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata.client;

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
public abstract class AbstractFeedWithHisNumberEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractFeedWithHisNumberEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnum1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnum2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnum3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnum4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbeginDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contendDate;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisCancelCancel;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnum5;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnum6;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnum7;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtnum1;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtnum2;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtnum3;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtnum4;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkbeginDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkendDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtnum5;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtnum6;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtnum7;
    protected com.kingdee.eas.farm.stocking.basedata.FeedWithHisNumberInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractFeedWithHisNumberEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractFeedWithHisNumberEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contnum1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contnum2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contnum3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contnum4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbeginDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contendDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisCancelCancel = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contnum5 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contnum6 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contnum7 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.prmtnum1 = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtnum2 = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtnum3 = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtnum4 = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkbeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkendDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtnum5 = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtnum6 = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtnum7 = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.contnum1.setName("contnum1");
        this.contnum2.setName("contnum2");
        this.contnum3.setName("contnum3");
        this.contnum4.setName("contnum4");
        this.contbeginDate.setName("contbeginDate");
        this.contendDate.setName("contendDate");
        this.chkisCancelCancel.setName("chkisCancelCancel");
        this.contnum5.setName("contnum5");
        this.contnum6.setName("contnum6");
        this.contnum7.setName("contnum7");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.prmtnum1.setName("prmtnum1");
        this.prmtnum2.setName("prmtnum2");
        this.prmtnum3.setName("prmtnum3");
        this.prmtnum4.setName("prmtnum4");
        this.pkbeginDate.setName("pkbeginDate");
        this.pkendDate.setName("pkendDate");
        this.prmtnum5.setName("prmtnum5");
        this.prmtnum6.setName("prmtnum6");
        this.prmtnum7.setName("prmtnum7");
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
        // contnum1		
        this.contnum1.setBoundLabelText(resHelper.getString("contnum1.boundLabelText"));		
        this.contnum1.setBoundLabelLength(100);		
        this.contnum1.setBoundLabelUnderline(true);		
        this.contnum1.setVisible(true);
        // contnum2		
        this.contnum2.setBoundLabelText(resHelper.getString("contnum2.boundLabelText"));		
        this.contnum2.setBoundLabelLength(100);		
        this.contnum2.setBoundLabelUnderline(true);		
        this.contnum2.setVisible(true);
        // contnum3		
        this.contnum3.setBoundLabelText(resHelper.getString("contnum3.boundLabelText"));		
        this.contnum3.setBoundLabelLength(100);		
        this.contnum3.setBoundLabelUnderline(true);		
        this.contnum3.setVisible(true);
        // contnum4		
        this.contnum4.setBoundLabelText(resHelper.getString("contnum4.boundLabelText"));		
        this.contnum4.setBoundLabelLength(100);		
        this.contnum4.setBoundLabelUnderline(true);		
        this.contnum4.setVisible(true);
        // contbeginDate		
        this.contbeginDate.setBoundLabelText(resHelper.getString("contbeginDate.boundLabelText"));		
        this.contbeginDate.setBoundLabelLength(100);		
        this.contbeginDate.setBoundLabelUnderline(true);		
        this.contbeginDate.setVisible(true);
        // contendDate		
        this.contendDate.setBoundLabelText(resHelper.getString("contendDate.boundLabelText"));		
        this.contendDate.setBoundLabelLength(100);		
        this.contendDate.setBoundLabelUnderline(true);		
        this.contendDate.setVisible(true);
        // chkisCancelCancel		
        this.chkisCancelCancel.setText(resHelper.getString("chkisCancelCancel.text"));		
        this.chkisCancelCancel.setVisible(true);		
        this.chkisCancelCancel.setHorizontalAlignment(2);
        // contnum5		
        this.contnum5.setBoundLabelText(resHelper.getString("contnum5.boundLabelText"));		
        this.contnum5.setBoundLabelLength(100);		
        this.contnum5.setBoundLabelUnderline(true);		
        this.contnum5.setVisible(true);
        // contnum6		
        this.contnum6.setBoundLabelText(resHelper.getString("contnum6.boundLabelText"));		
        this.contnum6.setBoundLabelLength(100);		
        this.contnum6.setBoundLabelUnderline(true);		
        this.contnum6.setVisible(true);
        // contnum7		
        this.contnum7.setBoundLabelText(resHelper.getString("contnum7.boundLabelText"));		
        this.contnum7.setBoundLabelLength(100);		
        this.contnum7.setBoundLabelUnderline(true);		
        this.contnum7.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // prmtnum1		
        this.prmtnum1.setQueryInfo("com.kingdee.eas.basedata.master.material.app.MaterialQuery");		
        this.prmtnum1.setVisible(true);		
        this.prmtnum1.setEditable(true);		
        this.prmtnum1.setDisplayFormat("$name$");		
        this.prmtnum1.setEditFormat("$number$");		
        this.prmtnum1.setCommitFormat("$number$");		
        this.prmtnum1.setRequired(false);
        // prmtnum2		
        this.prmtnum2.setQueryInfo("com.kingdee.eas.basedata.master.material.app.MaterialQuery");		
        this.prmtnum2.setVisible(true);		
        this.prmtnum2.setEditable(true);		
        this.prmtnum2.setDisplayFormat("$name$");		
        this.prmtnum2.setEditFormat("$number$");		
        this.prmtnum2.setCommitFormat("$number$");		
        this.prmtnum2.setRequired(false);
        // prmtnum3		
        this.prmtnum3.setQueryInfo("com.kingdee.eas.basedata.master.material.app.MaterialQuery");		
        this.prmtnum3.setVisible(true);		
        this.prmtnum3.setEditable(true);		
        this.prmtnum3.setDisplayFormat("$name$");		
        this.prmtnum3.setEditFormat("$number$");		
        this.prmtnum3.setCommitFormat("$number$");		
        this.prmtnum3.setRequired(false);
        // prmtnum4		
        this.prmtnum4.setQueryInfo("com.kingdee.eas.basedata.master.material.app.MaterialQuery");		
        this.prmtnum4.setVisible(true);		
        this.prmtnum4.setEditable(true);		
        this.prmtnum4.setDisplayFormat("$name$");		
        this.prmtnum4.setEditFormat("$number$");		
        this.prmtnum4.setCommitFormat("$number$");		
        this.prmtnum4.setRequired(false);
        // pkbeginDate		
        this.pkbeginDate.setVisible(true);		
        this.pkbeginDate.setRequired(false);
        // pkendDate		
        this.pkendDate.setVisible(true);		
        this.pkendDate.setRequired(false);
        // prmtnum5		
        this.prmtnum5.setQueryInfo("com.kingdee.eas.basedata.master.material.app.MaterialQuery");		
        this.prmtnum5.setVisible(true);		
        this.prmtnum5.setEditable(true);		
        this.prmtnum5.setDisplayFormat("$name$");		
        this.prmtnum5.setEditFormat("$number$");		
        this.prmtnum5.setCommitFormat("$number$");		
        this.prmtnum5.setRequired(false);
        // prmtnum6		
        this.prmtnum6.setQueryInfo("com.kingdee.eas.basedata.master.material.app.MaterialQuery");		
        this.prmtnum6.setVisible(true);		
        this.prmtnum6.setEditable(true);		
        this.prmtnum6.setDisplayFormat("$name$");		
        this.prmtnum6.setEditFormat("$number$");		
        this.prmtnum6.setCommitFormat("$number$");		
        this.prmtnum6.setRequired(false);
        // prmtnum7		
        this.prmtnum7.setQueryInfo("com.kingdee.eas.basedata.master.material.app.MaterialQuery");		
        this.prmtnum7.setVisible(true);		
        this.prmtnum7.setEditable(true);		
        this.prmtnum7.setDisplayFormat("$name$");		
        this.prmtnum7.setEditFormat("$number$");		
        this.prmtnum7.setCommitFormat("$number$");		
        this.prmtnum7.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtnum1,pkbeginDate,pkendDate,chkisCancelCancel,prmtnum5,prmtnum6,prmtnum7}));
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
        this.setBounds(new Rectangle(0, 0, 330, 329));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(25, 16, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(25, 41, 270, 19));
        this.add(kDLabelContainer2, null);
        contnum1.setBounds(new Rectangle(25, 68, 270, 19));
        this.add(contnum1, null);
        contnum2.setBounds(new Rectangle(25, 94, 270, 19));
        this.add(contnum2, null);
        contnum3.setBounds(new Rectangle(25, 121, 270, 19));
        this.add(contnum3, null);
        contnum4.setBounds(new Rectangle(25, 146, 270, 19));
        this.add(contnum4, null);
        contbeginDate.setBounds(new Rectangle(25, 252, 270, 19));
        this.add(contbeginDate, null);
        contendDate.setBounds(new Rectangle(25, 277, 270, 19));
        this.add(contendDate, null);
        chkisCancelCancel.setBounds(new Rectangle(24, 304, 270, 19));
        this.add(chkisCancelCancel, null);
        contnum5.setBounds(new Rectangle(25, 172, 270, 19));
        this.add(contnum5, null);
        contnum6.setBounds(new Rectangle(25, 198, 270, 19));
        this.add(contnum6, null);
        contnum7.setBounds(new Rectangle(25, 224, 270, 19));
        this.add(contnum7, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //contnum1
        contnum1.setBoundEditor(prmtnum1);
        //contnum2
        contnum2.setBoundEditor(prmtnum2);
        //contnum3
        contnum3.setBoundEditor(prmtnum3);
        //contnum4
        contnum4.setBoundEditor(prmtnum4);
        //contbeginDate
        contbeginDate.setBoundEditor(pkbeginDate);
        //contendDate
        contendDate.setBoundEditor(pkendDate);
        //contnum5
        contnum5.setBoundEditor(prmtnum5);
        //contnum6
        contnum6.setBoundEditor(prmtnum6);
        //contnum7
        contnum7.setBoundEditor(prmtnum7);

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
		dataBinder.registerBinding("isCancelCancel", boolean.class, this.chkisCancelCancel, "selected");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("num1", com.kingdee.eas.basedata.master.material.MaterialInfo.class, this.prmtnum1, "data");
		dataBinder.registerBinding("num2", com.kingdee.eas.basedata.master.material.MaterialInfo.class, this.prmtnum2, "data");
		dataBinder.registerBinding("num3", com.kingdee.eas.basedata.master.material.MaterialInfo.class, this.prmtnum3, "data");
		dataBinder.registerBinding("num4", com.kingdee.eas.basedata.master.material.MaterialInfo.class, this.prmtnum4, "data");
		dataBinder.registerBinding("beginDate", java.util.Date.class, this.pkbeginDate, "value");
		dataBinder.registerBinding("endDate", java.util.Date.class, this.pkendDate, "value");
		dataBinder.registerBinding("num5", com.kingdee.eas.basedata.master.material.MaterialInfo.class, this.prmtnum5, "data");
		dataBinder.registerBinding("num6", com.kingdee.eas.basedata.master.material.MaterialInfo.class, this.prmtnum6, "data");
		dataBinder.registerBinding("num7", com.kingdee.eas.basedata.master.material.MaterialInfo.class, this.prmtnum7, "data");		
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
	    return "com.kingdee.eas.farm.stocking.basedata.app.FeedWithHisNumberEditUIHandler";
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
        this.prmtnum1.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.stocking.basedata.FeedWithHisNumberInfo)ov;
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
		getValidateHelper().registerBindProperty("isCancelCancel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("num1", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("num2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("num3", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("num4", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("beginDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("endDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("num5", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("num6", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("num7", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("isCancelCancel"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("num1.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("num1.id"));
        	sic.add(new SelectorItemInfo("num1.number"));
        	sic.add(new SelectorItemInfo("num1.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("num2.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("num2.id"));
        	sic.add(new SelectorItemInfo("num2.number"));
        	sic.add(new SelectorItemInfo("num2.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("num3.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("num3.id"));
        	sic.add(new SelectorItemInfo("num3.number"));
        	sic.add(new SelectorItemInfo("num3.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("num4.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("num4.id"));
        	sic.add(new SelectorItemInfo("num4.number"));
        	sic.add(new SelectorItemInfo("num4.name"));
		}
        sic.add(new SelectorItemInfo("beginDate"));
        sic.add(new SelectorItemInfo("endDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("num5.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("num5.id"));
        	sic.add(new SelectorItemInfo("num5.number"));
        	sic.add(new SelectorItemInfo("num5.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("num6.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("num6.id"));
        	sic.add(new SelectorItemInfo("num6.number"));
        	sic.add(new SelectorItemInfo("num6.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("num7.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("num7.id"));
        	sic.add(new SelectorItemInfo("num7.number"));
        	sic.add(new SelectorItemInfo("num7.name"));
		}
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.stocking.basedata.client", "FeedWithHisNumberEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.stocking.basedata.client.FeedWithHisNumberEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.basedata.FeedWithHisNumberFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.basedata.FeedWithHisNumberInfo objectValue = new com.kingdee.eas.farm.stocking.basedata.FeedWithHisNumberInfo();
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