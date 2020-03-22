/**
 * output package name
 */
package com.kingdee.eas.farm.pig.client;

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
public abstract class AbstractPigHouseEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractPigHouseEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contarea;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpigFarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdeletedStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstoOrg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstandardPigQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpigHouseType;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtarea;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpigFarm;
    protected com.kingdee.bos.ctrl.swing.KDComboBox deletedStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstoOrg;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtstandardPigQty;
    protected com.kingdee.bos.ctrl.swing.KDComboBox pigHouseType;
    protected com.kingdee.eas.farm.pig.PigHouseInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractPigHouseEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractPigHouseEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contarea = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpigFarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdeletedStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstoOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstandardPigQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpigHouseType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtarea = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtpigFarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.deletedStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtstoOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtstandardPigQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pigHouseType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contarea.setName("contarea");
        this.contpigFarm.setName("contpigFarm");
        this.contdeletedStatus.setName("contdeletedStatus");
        this.contstoOrg.setName("contstoOrg");
        this.contstandardPigQty.setName("contstandardPigQty");
        this.contpigHouseType.setName("contpigHouseType");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.txtarea.setName("txtarea");
        this.prmtpigFarm.setName("prmtpigFarm");
        this.deletedStatus.setName("deletedStatus");
        this.prmtstoOrg.setName("prmtstoOrg");
        this.txtstandardPigQty.setName("txtstandardPigQty");
        this.pigHouseType.setName("pigHouseType");
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
        // contarea		
        this.contarea.setBoundLabelText(resHelper.getString("contarea.boundLabelText"));		
        this.contarea.setBoundLabelLength(100);		
        this.contarea.setBoundLabelUnderline(true);		
        this.contarea.setVisible(true);
        // contpigFarm		
        this.contpigFarm.setBoundLabelText(resHelper.getString("contpigFarm.boundLabelText"));		
        this.contpigFarm.setBoundLabelLength(100);		
        this.contpigFarm.setBoundLabelUnderline(true);		
        this.contpigFarm.setVisible(true);
        // contdeletedStatus		
        this.contdeletedStatus.setBoundLabelText(resHelper.getString("contdeletedStatus.boundLabelText"));		
        this.contdeletedStatus.setBoundLabelLength(100);		
        this.contdeletedStatus.setBoundLabelUnderline(true);		
        this.contdeletedStatus.setVisible(true);
        // contstoOrg		
        this.contstoOrg.setBoundLabelText(resHelper.getString("contstoOrg.boundLabelText"));		
        this.contstoOrg.setBoundLabelLength(100);		
        this.contstoOrg.setBoundLabelUnderline(true);		
        this.contstoOrg.setVisible(true);
        // contstandardPigQty		
        this.contstandardPigQty.setBoundLabelText(resHelper.getString("contstandardPigQty.boundLabelText"));		
        this.contstandardPigQty.setBoundLabelLength(100);		
        this.contstandardPigQty.setBoundLabelUnderline(true);		
        this.contstandardPigQty.setVisible(true);
        // contpigHouseType		
        this.contpigHouseType.setBoundLabelText(resHelper.getString("contpigHouseType.boundLabelText"));		
        this.contpigHouseType.setBoundLabelLength(100);		
        this.contpigHouseType.setBoundLabelUnderline(true);		
        this.contpigHouseType.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setRequired(true);
        // txtName		
        this.txtName.setRequired(true);
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // txtarea		
        this.txtarea.setVisible(true);		
        this.txtarea.setHorizontalAlignment(2);		
        this.txtarea.setDataType(1);		
        this.txtarea.setSupportedEmpty(true);		
        this.txtarea.setMinimumValue( new java.math.BigDecimal("-9.999999999E7"));		
        this.txtarea.setMaximumValue( new java.math.BigDecimal("9.999999999E7"));		
        this.txtarea.setPrecision(2);		
        this.txtarea.setRequired(false);
        // prmtpigFarm		
        this.prmtpigFarm.setQueryInfo("com.kingdee.eas.farm.pig.app.PigFarmQuery");		
        this.prmtpigFarm.setVisible(true);		
        this.prmtpigFarm.setEditable(true);		
        this.prmtpigFarm.setDisplayFormat("$name$");		
        this.prmtpigFarm.setEditFormat("$number$");		
        this.prmtpigFarm.setCommitFormat("$number$");		
        this.prmtpigFarm.setRequired(true);
        		prmtpigFarm.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.pig.client.PigFarmListUI prmtpigFarm_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtpigFarm_F7ListUI == null) {
					try {
						prmtpigFarm_F7ListUI = new com.kingdee.eas.farm.pig.client.PigFarmListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtpigFarm_F7ListUI));
					prmtpigFarm_F7ListUI.setF7Use(true,ctx);
					prmtpigFarm.setSelector(prmtpigFarm_F7ListUI);
				}
			}
		});
					
        this.prmtpigFarm.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtpigFarm_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // deletedStatus		
        this.deletedStatus.setVisible(true);		
        this.deletedStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.pig.DisableState").toArray());		
        this.deletedStatus.setRequired(false);		
        this.deletedStatus.setEnabled(false);
        // prmtstoOrg		
        this.prmtstoOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtstoOrg.setVisible(true);		
        this.prmtstoOrg.setEditable(true);		
        this.prmtstoOrg.setDisplayFormat("$name$");		
        this.prmtstoOrg.setEditFormat("$number$");		
        this.prmtstoOrg.setCommitFormat("$number$");		
        this.prmtstoOrg.setRequired(true);		
        this.prmtstoOrg.setEnabled(false);
        // txtstandardPigQty		
        this.txtstandardPigQty.setVisible(true);		
        this.txtstandardPigQty.setHorizontalAlignment(2);		
        this.txtstandardPigQty.setDataType(0);		
        this.txtstandardPigQty.setSupportedEmpty(true);		
        this.txtstandardPigQty.setRequired(false);
        // pigHouseType		
        this.pigHouseType.setVisible(true);		
        this.pigHouseType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.pig.PigHouseType").toArray());		
        this.pigHouseType.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtarea,prmtpigFarm,deletedStatus,prmtstoOrg,txtstandardPigQty,pigHouseType}));
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
        this.setBounds(new Rectangle(0, 0, 650, 600));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(32, 36, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(358, 36, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(32, -64, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(32, 147, 270, 19));
        this.add(kDLabelContainer4, null);
        contarea.setBounds(new Rectangle(358, 118, 270, 19));
        this.add(contarea, null);
        contpigFarm.setBounds(new Rectangle(32, 65, 270, 19));
        this.add(contpigFarm, null);
        contdeletedStatus.setBounds(new Rectangle(358, 147, 270, 19));
        this.add(contdeletedStatus, null);
        contstoOrg.setBounds(new Rectangle(358, 65, 270, 19));
        this.add(contstoOrg, null);
        contstandardPigQty.setBounds(new Rectangle(32, 118, 270, 19));
        this.add(contstandardPigQty, null);
        contpigHouseType.setBounds(new Rectangle(32, 92, 270, 19));
        this.add(contpigHouseType, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contarea
        contarea.setBoundEditor(txtarea);
        //contpigFarm
        contpigFarm.setBoundEditor(prmtpigFarm);
        //contdeletedStatus
        contdeletedStatus.setBoundEditor(deletedStatus);
        //contstoOrg
        contstoOrg.setBoundEditor(prmtstoOrg);
        //contstandardPigQty
        contstandardPigQty.setBoundEditor(txtstandardPigQty);
        //contpigHouseType
        contpigHouseType.setBoundEditor(pigHouseType);

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
		dataBinder.registerBinding("area", java.math.BigDecimal.class, this.txtarea, "value");
		dataBinder.registerBinding("pigFarm", com.kingdee.eas.farm.pig.PigFarmInfo.class, this.prmtpigFarm, "data");
		dataBinder.registerBinding("deletedStatus", com.kingdee.eas.farm.pig.DisableState.class, this.deletedStatus, "selectedItem");
		dataBinder.registerBinding("stoOrg", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtstoOrg, "data");
		dataBinder.registerBinding("standardPigQty", int.class, this.txtstandardPigQty, "value");
		dataBinder.registerBinding("pigHouseType", com.kingdee.eas.farm.pig.PigHouseType.class, this.pigHouseType, "selectedItem");		
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
	    return "com.kingdee.eas.farm.pig.app.PigHouseEditUIHandler";
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
        this.txtarea.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.pig.PigHouseInfo)ov;
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
	 * ????????У??
	 */
	protected void registerValidator() {
    	getValidateHelper().setCustomValidator( getValidator() );
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("area", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("pigFarm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("deletedStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("stoOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("standardPigQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("pigHouseType", ValidateHelper.ON_SAVE);    		
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
     * output prmtpigFarm_dataChanged method
     */
    protected void prmtpigFarm_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        //write your code here
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
        sic.add(new SelectorItemInfo("area"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("pigFarm.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("pigFarm.id"));
        	sic.add(new SelectorItemInfo("pigFarm.number"));
        	sic.add(new SelectorItemInfo("pigFarm.name"));
		}
        sic.add(new SelectorItemInfo("deletedStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("stoOrg.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("stoOrg.id"));
        	sic.add(new SelectorItemInfo("stoOrg.number"));
        	sic.add(new SelectorItemInfo("stoOrg.name"));
		}
        sic.add(new SelectorItemInfo("standardPigQty"));
        sic.add(new SelectorItemInfo("pigHouseType"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.pig.client", "PigHouseEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.pig.client.PigHouseEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.pig.PigHouseFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.pig.PigHouseInfo objectValue = new com.kingdee.eas.farm.pig.PigHouseInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtNumber.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"编码"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtName.getItemDataByLang(new LanguageInfo(com.kingdee.eas.common.client.SysContext.getSysContext().getLocale())))) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"名称"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtpigFarm.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖场"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtstoOrg.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"对应库存组织"});
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
		vo.put("deletedStatus",new Integer(1));
vo.put("pigHouseType","1");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}