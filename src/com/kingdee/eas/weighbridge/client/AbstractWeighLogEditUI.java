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
public abstract class AbstractWeighLogEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractWeighLogEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contuser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contotherCarInfo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcarNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdataSource;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contplatform;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtuser;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtotherCarInfo;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcarNumber;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtweight;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdataSource;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkcreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtplatform;
    protected com.kingdee.eas.weighbridge.WeighLogInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractWeighLogEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractWeighLogEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contuser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contotherCarInfo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcarNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdataSource = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contplatform = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.prmtuser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtotherCarInfo = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtcarNumber = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtweight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdataSource = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkcreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtplatform = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contuser.setName("contuser");
        this.contotherCarInfo.setName("contotherCarInfo");
        this.contcarNumber.setName("contcarNumber");
        this.contweight.setName("contweight");
        this.contdataSource.setName("contdataSource");
        this.contcreateTime.setName("contcreateTime");
        this.contcompany.setName("contcompany");
        this.contplatform.setName("contplatform");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.prmtuser.setName("prmtuser");
        this.txtotherCarInfo.setName("txtotherCarInfo");
        this.prmtcarNumber.setName("prmtcarNumber");
        this.txtweight.setName("txtweight");
        this.txtdataSource.setName("txtdataSource");
        this.pkcreateTime.setName("pkcreateTime");
        this.prmtcompany.setName("prmtcompany");
        this.prmtplatform.setName("prmtplatform");
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
        // contuser		
        this.contuser.setBoundLabelText(resHelper.getString("contuser.boundLabelText"));		
        this.contuser.setBoundLabelLength(100);		
        this.contuser.setBoundLabelUnderline(true);		
        this.contuser.setVisible(true);
        // contotherCarInfo		
        this.contotherCarInfo.setBoundLabelText(resHelper.getString("contotherCarInfo.boundLabelText"));		
        this.contotherCarInfo.setBoundLabelLength(100);		
        this.contotherCarInfo.setBoundLabelUnderline(true);		
        this.contotherCarInfo.setVisible(true);
        // contcarNumber		
        this.contcarNumber.setBoundLabelText(resHelper.getString("contcarNumber.boundLabelText"));		
        this.contcarNumber.setBoundLabelLength(100);		
        this.contcarNumber.setBoundLabelUnderline(true);		
        this.contcarNumber.setVisible(true);
        // contweight		
        this.contweight.setBoundLabelText(resHelper.getString("contweight.boundLabelText"));		
        this.contweight.setBoundLabelLength(100);		
        this.contweight.setBoundLabelUnderline(true);		
        this.contweight.setVisible(true);
        // contdataSource		
        this.contdataSource.setBoundLabelText(resHelper.getString("contdataSource.boundLabelText"));		
        this.contdataSource.setBoundLabelLength(100);		
        this.contdataSource.setBoundLabelUnderline(true);		
        this.contdataSource.setVisible(true);
        // contcreateTime		
        this.contcreateTime.setBoundLabelText(resHelper.getString("contcreateTime.boundLabelText"));		
        this.contcreateTime.setBoundLabelLength(100);		
        this.contcreateTime.setBoundLabelUnderline(true);		
        this.contcreateTime.setVisible(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contplatform		
        this.contplatform.setBoundLabelText(resHelper.getString("contplatform.boundLabelText"));		
        this.contplatform.setBoundLabelLength(100);		
        this.contplatform.setBoundLabelUnderline(true);		
        this.contplatform.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setEnabled(false);		
        this.txtNumber.setVisible(false);
        // txtName		
        this.txtName.setEnabled(false);		
        this.txtName.setVisible(false);
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);		
        this.txtSimpleName.setEnabled(false);		
        this.txtSimpleName.setVisible(false);
        // txtDescription		
        this.txtDescription.setEnabled(false);		
        this.txtDescription.setVisible(false);
        // prmtuser		
        this.prmtuser.setQueryInfo("com.kingdee.eas.base.permission.app.UserListQuery");		
        this.prmtuser.setVisible(true);		
        this.prmtuser.setEditable(true);		
        this.prmtuser.setDisplayFormat("$number$ $name$");		
        this.prmtuser.setEditFormat("$number$");		
        this.prmtuser.setCommitFormat("$number$");		
        this.prmtuser.setRequired(false);		
        this.prmtuser.setEnabled(false);
        // txtotherCarInfo		
        this.txtotherCarInfo.setVisible(true);		
        this.txtotherCarInfo.setHorizontalAlignment(2);		
        this.txtotherCarInfo.setMaxLength(100);		
        this.txtotherCarInfo.setRequired(false);		
        this.txtotherCarInfo.setEnabled(false);
        // prmtcarNumber		
        this.prmtcarNumber.setQueryInfo("com.kingdee.eas.publicdata.app.CarQuery");		
        this.prmtcarNumber.setVisible(true);		
        this.prmtcarNumber.setEditable(true);		
        this.prmtcarNumber.setDisplayFormat("$carOrder$  $number$");		
        this.prmtcarNumber.setEditFormat("$number$");		
        this.prmtcarNumber.setCommitFormat("$number$");		
        this.prmtcarNumber.setRequired(false);		
        this.prmtcarNumber.setEnabled(false);
        		prmtcarNumber.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.CarListUI prmtcarNumber_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtcarNumber_F7ListUI == null) {
					try {
						prmtcarNumber_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.CarListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtcarNumber_F7ListUI));
					prmtcarNumber_F7ListUI.setF7Use(true,ctx);
					prmtcarNumber.setSelector(prmtcarNumber_F7ListUI);
				}
			}
		});
					
        // txtweight		
        this.txtweight.setVisible(true);		
        this.txtweight.setHorizontalAlignment(2);		
        this.txtweight.setDataType(1);		
        this.txtweight.setSupportedEmpty(true);		
        this.txtweight.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtweight.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtweight.setPrecision(2);		
        this.txtweight.setRequired(false);		
        this.txtweight.setEnabled(false);
        // txtdataSource		
        this.txtdataSource.setVisible(true);		
        this.txtdataSource.setHorizontalAlignment(2);		
        this.txtdataSource.setMaxLength(100);		
        this.txtdataSource.setRequired(false);		
        this.txtdataSource.setEnabled(false);
        // pkcreateTime		
        this.pkcreateTime.setVisible(true);		
        this.pkcreateTime.setRequired(false);		
        this.pkcreateTime.setEnabled(false);		
        this.pkcreateTime.setTimeEnabled(true);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setVisible(true);		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(false);		
        this.prmtcompany.setEnabled(false);
        // prmtplatform		
        this.prmtplatform.setQueryInfo("com.kingdee.eas.weighbridge.app.WeighBridgeQuery");		
        this.prmtplatform.setVisible(true);		
        this.prmtplatform.setEditable(true);		
        this.prmtplatform.setDisplayFormat("$name$");		
        this.prmtplatform.setEditFormat("$number$");		
        this.prmtplatform.setCommitFormat("$number$");		
        this.prmtplatform.setRequired(false);		
        this.prmtplatform.setEnabled(false);
        		prmtplatform.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.weighbridge.client.WeighBridgeListUI prmtplatform_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtplatform_F7ListUI == null) {
					try {
						prmtplatform_F7ListUI = new com.kingdee.eas.weighbridge.client.WeighBridgeListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtplatform_F7ListUI));
					prmtplatform_F7ListUI.setF7Use(true,ctx);
					prmtplatform.setSelector(prmtplatform_F7ListUI);
				}
			}
		});
					
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {pkcreateTime,prmtuser,txtotherCarInfo,txtSimpleName,txtDescription,txtNumber,txtName,prmtcarNumber,txtweight,txtdataSource,prmtcompany,prmtplatform}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 629));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(102, -44, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(102, -44, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(102, -44, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(102, -44, 270, 19));
        this.add(kDLabelContainer4, null);
        contuser.setBounds(new Rectangle(111, 138, 270, 19));
        this.add(contuser, null);
        contotherCarInfo.setBounds(new Rectangle(111, 214, 270, 19));
        this.add(contotherCarInfo, null);
        contcarNumber.setBounds(new Rectangle(111, 176, 270, 19));
        this.add(contcarNumber, null);
        contweight.setBounds(new Rectangle(111, 100, 270, 19));
        this.add(contweight, null);
        contdataSource.setBounds(new Rectangle(111, 252, 270, 19));
        this.add(contdataSource, null);
        contcreateTime.setBounds(new Rectangle(111, 296, 270, 19));
        this.add(contcreateTime, null);
        contcompany.setBounds(new Rectangle(111, 24, 270, 19));
        this.add(contcompany, null);
        contplatform.setBounds(new Rectangle(111, 62, 270, 19));
        this.add(contplatform, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contuser
        contuser.setBoundEditor(prmtuser);
        //contotherCarInfo
        contotherCarInfo.setBoundEditor(txtotherCarInfo);
        //contcarNumber
        contcarNumber.setBoundEditor(prmtcarNumber);
        //contweight
        contweight.setBoundEditor(txtweight);
        //contdataSource
        contdataSource.setBoundEditor(txtdataSource);
        //contcreateTime
        contcreateTime.setBoundEditor(pkcreateTime);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contplatform
        contplatform.setBoundEditor(prmtplatform);

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
		dataBinder.registerBinding("user", com.kingdee.eas.base.permission.UserInfo.class, this.prmtuser, "data");
		dataBinder.registerBinding("otherCarInfo", String.class, this.txtotherCarInfo, "text");
		dataBinder.registerBinding("carNumber", com.kingdee.eas.publicdata.CarInfo.class, this.prmtcarNumber, "data");
		dataBinder.registerBinding("weight", java.math.BigDecimal.class, this.txtweight, "value");
		dataBinder.registerBinding("dataSource", String.class, this.txtdataSource, "text");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.pkcreateTime, "value");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("platform", com.kingdee.eas.weighbridge.WeighBridgeInfo.class, this.prmtplatform, "data");		
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
	    return "com.kingdee.eas.weighbridge.app.WeighLogEditUIHandler";
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
        this.pkcreateTime.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.weighbridge.WeighLogInfo)ov;
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
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("user", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("otherCarInfo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("carNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("weight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dataSource", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("platform", ValidateHelper.ON_SAVE);    		
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
			sic.add(new SelectorItemInfo("user.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("user.id"));
        	sic.add(new SelectorItemInfo("user.number"));
        	sic.add(new SelectorItemInfo("user.name"));
		}
        sic.add(new SelectorItemInfo("otherCarInfo"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("carNumber.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("carNumber.id"));
        	sic.add(new SelectorItemInfo("carNumber.number"));
        	sic.add(new SelectorItemInfo("carNumber.name"));
        	sic.add(new SelectorItemInfo("carNumber.carOrder"));
		}
        sic.add(new SelectorItemInfo("weight"));
        sic.add(new SelectorItemInfo("dataSource"));
        sic.add(new SelectorItemInfo("createTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("platform.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("platform.id"));
        	sic.add(new SelectorItemInfo("platform.number"));
        	sic.add(new SelectorItemInfo("platform.name"));
		}
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.weighbridge.client", "WeighLogEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.weighbridge.client.WeighLogEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.weighbridge.WeighLogFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.weighbridge.WeighLogInfo objectValue = new com.kingdee.eas.weighbridge.WeighLogInfo();
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