/**
 * output package name
 */
package com.kingdee.eas.weighbridge.client;

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
public abstract class AbstractPurorderUpdateLogEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractPurorderUpdateLogEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillID;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoldWeightQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoldSettleQty;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbillID;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoldWeightQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoldSettleQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnewWeightQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnewSettleQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtnewWeightQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtnewSettleQty;
    protected com.kingdee.eas.weighbridge.PurorderUpdateLogInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractPurorderUpdateLogEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractPurorderUpdateLogEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillID = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoldWeightQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoldSettleQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbillID = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtoldWeightQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtoldSettleQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contnewWeightQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contnewSettleQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtnewWeightQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtnewSettleQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.contbillID.setName("contbillID");
        this.contoldWeightQty.setName("contoldWeightQty");
        this.contoldSettleQty.setName("contoldSettleQty");
        this.txtNumber.setName("txtNumber");
        this.txtbillID.setName("txtbillID");
        this.txtoldWeightQty.setName("txtoldWeightQty");
        this.txtoldSettleQty.setName("txtoldSettleQty");
        this.contnewWeightQty.setName("contnewWeightQty");
        this.contnewSettleQty.setName("contnewSettleQty");
        this.txtnewWeightQty.setName("txtnewWeightQty");
        this.txtnewSettleQty.setName("txtnewSettleQty");
        // CoreUI		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);
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
        // kDPanel1		
        this.kDPanel1.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel1.border.title")));
        // kDPanel2		
        this.kDPanel2.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel2.border.title")));
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);
        // contbillID		
        this.contbillID.setBoundLabelText(resHelper.getString("contbillID.boundLabelText"));		
        this.contbillID.setBoundLabelLength(100);		
        this.contbillID.setBoundLabelUnderline(true);		
        this.contbillID.setVisible(true);
        // contoldWeightQty		
        this.contoldWeightQty.setBoundLabelText(resHelper.getString("contoldWeightQty.boundLabelText"));		
        this.contoldWeightQty.setBoundLabelLength(100);		
        this.contoldWeightQty.setBoundLabelUnderline(true);		
        this.contoldWeightQty.setVisible(true);
        // contoldSettleQty		
        this.contoldSettleQty.setBoundLabelText(resHelper.getString("contoldSettleQty.boundLabelText"));		
        this.contoldSettleQty.setBoundLabelLength(100);		
        this.contoldSettleQty.setBoundLabelUnderline(true);		
        this.contoldSettleQty.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setEnabled(false);
        // txtbillID		
        this.txtbillID.setVisible(true);		
        this.txtbillID.setHorizontalAlignment(2);		
        this.txtbillID.setMaxLength(44);		
        this.txtbillID.setRequired(false);		
        this.txtbillID.setEnabled(false);
        // txtoldWeightQty		
        this.txtoldWeightQty.setVisible(true);		
        this.txtoldWeightQty.setHorizontalAlignment(2);		
        this.txtoldWeightQty.setDataType(1);		
        this.txtoldWeightQty.setSupportedEmpty(true);		
        this.txtoldWeightQty.setMinimumValue( new java.math.BigDecimal("-1.0E24"));		
        this.txtoldWeightQty.setMaximumValue( new java.math.BigDecimal("1.0E24"));		
        this.txtoldWeightQty.setPrecision(4);		
        this.txtoldWeightQty.setRequired(false);		
        this.txtoldWeightQty.setEnabled(false);
        // txtoldSettleQty		
        this.txtoldSettleQty.setVisible(true);		
        this.txtoldSettleQty.setHorizontalAlignment(2);		
        this.txtoldSettleQty.setDataType(1);		
        this.txtoldSettleQty.setSupportedEmpty(true);		
        this.txtoldSettleQty.setMinimumValue( new java.math.BigDecimal("-1.0E24"));		
        this.txtoldSettleQty.setMaximumValue( new java.math.BigDecimal("1.0E24"));		
        this.txtoldSettleQty.setPrecision(4);		
        this.txtoldSettleQty.setRequired(false);		
        this.txtoldSettleQty.setEnabled(false);
        // contnewWeightQty		
        this.contnewWeightQty.setBoundLabelText(resHelper.getString("contnewWeightQty.boundLabelText"));		
        this.contnewWeightQty.setBoundLabelLength(100);		
        this.contnewWeightQty.setBoundLabelUnderline(true);		
        this.contnewWeightQty.setVisible(true);
        // contnewSettleQty		
        this.contnewSettleQty.setBoundLabelText(resHelper.getString("contnewSettleQty.boundLabelText"));		
        this.contnewSettleQty.setBoundLabelLength(100);		
        this.contnewSettleQty.setBoundLabelUnderline(true);		
        this.contnewSettleQty.setVisible(true);
        // txtnewWeightQty		
        this.txtnewWeightQty.setVisible(true);		
        this.txtnewWeightQty.setHorizontalAlignment(2);		
        this.txtnewWeightQty.setDataType(1);		
        this.txtnewWeightQty.setSupportedEmpty(true);		
        this.txtnewWeightQty.setMinimumValue( new java.math.BigDecimal("-1.0E24"));		
        this.txtnewWeightQty.setMaximumValue( new java.math.BigDecimal("1.0E24"));		
        this.txtnewWeightQty.setPrecision(4);		
        this.txtnewWeightQty.setRequired(false);
        // txtnewSettleQty		
        this.txtnewSettleQty.setVisible(true);		
        this.txtnewSettleQty.setHorizontalAlignment(2);		
        this.txtnewSettleQty.setDataType(1);		
        this.txtnewSettleQty.setSupportedEmpty(true);		
        this.txtnewSettleQty.setMinimumValue( new java.math.BigDecimal("-1.0E24"));		
        this.txtnewSettleQty.setMaximumValue( new java.math.BigDecimal("1.0E24"));		
        this.txtnewSettleQty.setPrecision(4);		
        this.txtnewSettleQty.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtbillID,txtoldWeightQty,txtoldSettleQty,txtnewWeightQty,txtnewSettleQty}));
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
        this.setBounds(new Rectangle(0, 0, 400, 400));
        this.setLayout(null);
        kDLabelContainer2.setBounds(new Rectangle(111, -273, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(111, -273, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(55, 339, 270, 19));
        this.add(kDLabelContainer4, null);
        kDPanel1.setBounds(new Rectangle(30, 32, 350, 161));
        this.add(kDPanel1, null);
        kDPanel2.setBounds(new Rectangle(30, 216, 350, 111));
        this.add(kDPanel2, null);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //kDPanel1
        kDPanel1.setLayout(null);        kDLabelContainer1.setBounds(new Rectangle(26, 32, 270, 19));
        kDPanel1.add(kDLabelContainer1, null);
        contbillID.setBounds(new Rectangle(26, 61, 270, 19));
        kDPanel1.add(contbillID, null);
        contoldWeightQty.setBounds(new Rectangle(26, 90, 270, 19));
        kDPanel1.add(contoldWeightQty, null);
        contoldSettleQty.setBounds(new Rectangle(26, 120, 270, 19));
        kDPanel1.add(contoldSettleQty, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //contbillID
        contbillID.setBoundEditor(txtbillID);
        //contoldWeightQty
        contoldWeightQty.setBoundEditor(txtoldWeightQty);
        //contoldSettleQty
        contoldSettleQty.setBoundEditor(txtoldSettleQty);
        //kDPanel2
        kDPanel2.setLayout(null);        contnewWeightQty.setBounds(new Rectangle(29, 30, 270, 19));
        kDPanel2.add(contnewWeightQty, null);
        contnewSettleQty.setBounds(new Rectangle(29, 59, 270, 19));
        kDPanel2.add(contnewSettleQty, null);
        //contnewWeightQty
        contnewWeightQty.setBoundEditor(txtnewWeightQty);
        //contnewSettleQty
        contnewSettleQty.setBoundEditor(txtnewSettleQty);

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
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("billID", String.class, this.txtbillID, "text");
		dataBinder.registerBinding("oldWeightQty", java.math.BigDecimal.class, this.txtoldWeightQty, "value");
		dataBinder.registerBinding("oldSettleQty", java.math.BigDecimal.class, this.txtoldSettleQty, "value");
		dataBinder.registerBinding("newWeightQty", java.math.BigDecimal.class, this.txtnewWeightQty, "value");
		dataBinder.registerBinding("newSettleQty", java.math.BigDecimal.class, this.txtnewSettleQty, "value");		
	}
	//Regiester UI State
	private void registerUIState(){
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtDescription, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtSimpleName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtDescription, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtSimpleName, ActionStateConst.ENABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtName, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtDescription, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtSimpleName, ActionStateConst.DISABLED);		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.weighbridge.app.PurorderUpdateLogEditUIHandler";
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
        this.txtbillID.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.weighbridge.PurorderUpdateLogInfo)ov;
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
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("oldWeightQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("oldSettleQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("newWeightQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("newSettleQty", ValidateHelper.ON_SAVE);    		
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
		            this.txtSimpleName.setEnabled(true);
        } else if (STATUS_EDIT.equals(this.oprtState)) {
		            this.txtName.setEnabled(true);
		            this.txtDescription.setEnabled(true);
		            this.txtSimpleName.setEnabled(true);
        } else if (STATUS_VIEW.equals(this.oprtState)) {
		            this.txtName.setEnabled(false);
		            this.txtDescription.setEnabled(false);
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
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("simpleName"));
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("billID"));
        sic.add(new SelectorItemInfo("oldWeightQty"));
        sic.add(new SelectorItemInfo("oldSettleQty"));
        sic.add(new SelectorItemInfo("newWeightQty"));
        sic.add(new SelectorItemInfo("newSettleQty"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.weighbridge.client", "PurorderUpdateLogEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.weighbridge.client.PurorderUpdateLogEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.weighbridge.PurorderUpdateLogFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.weighbridge.PurorderUpdateLogInfo objectValue = new com.kingdee.eas.weighbridge.PurorderUpdateLogInfo();
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