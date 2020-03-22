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
public abstract class AbstractPersonRelationEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractPersonRelationEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompanyOrg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contshrPerson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contshrPersonName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAdminOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpersonNature;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contPersonNatureCode;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contPersonNatureName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contEASperson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contEASPersonName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contEASPersonNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompanyOrg;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtshrPerson;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtshrPersonName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAdminOrgUnit;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpersonNature;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtPersonNatureCode;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtPersonNatureName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtEASperson;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtEASPersonName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtEASPersonNum;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.custom.salaryvoucher.PersonRelationInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractPersonRelationEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractPersonRelationEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        //actionAudit
        this.actionAudit = new ActionAudit(this);
        getActionManager().registerAction("actionAudit", actionAudit);
        this.actionAudit.setExtendProperty("canForewarn", "true");
        this.actionAudit.setExtendProperty("userDefined", "false");
        this.actionAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionUnAudit
        this.actionUnAudit = new ActionUnAudit(this);
        getActionManager().registerAction("actionUnAudit", actionUnAudit);
        this.actionUnAudit.setExtendProperty("canForewarn", "true");
        this.actionUnAudit.setExtendProperty("userDefined", "false");
        this.actionUnAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompanyOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contshrPerson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contshrPersonName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAdminOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpersonNature = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contPersonNatureCode = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contPersonNatureName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contEASperson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contEASPersonName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contEASPersonNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtcompanyOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtshrPerson = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtshrPersonName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAdminOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtpersonNature = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtPersonNatureCode = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtPersonNatureName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtEASperson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtEASPersonName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtEASPersonNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.contcompanyOrg.setName("contcompanyOrg");
        this.contshrPerson.setName("contshrPerson");
        this.contshrPersonName.setName("contshrPersonName");
        this.contAdminOrgUnit.setName("contAdminOrgUnit");
        this.contpersonNature.setName("contpersonNature");
        this.contPersonNatureCode.setName("contPersonNatureCode");
        this.contPersonNatureName.setName("contPersonNatureName");
        this.contEASperson.setName("contEASperson");
        this.contEASPersonName.setName("contEASPersonName");
        this.contEASPersonNum.setName("contEASPersonNum");
        this.contbillStatus.setName("contbillStatus");
        this.txtNumber.setName("txtNumber");
        this.prmtcompanyOrg.setName("prmtcompanyOrg");
        this.txtshrPerson.setName("txtshrPerson");
        this.txtshrPersonName.setName("txtshrPersonName");
        this.prmtAdminOrgUnit.setName("prmtAdminOrgUnit");
        this.prmtpersonNature.setName("prmtpersonNature");
        this.txtPersonNatureCode.setName("txtPersonNatureCode");
        this.txtPersonNatureName.setName("txtPersonNatureName");
        this.prmtEASperson.setName("prmtEASperson");
        this.txtEASPersonName.setName("txtEASPersonName");
        this.txtEASPersonNum.setName("txtEASPersonNum");
        this.billStatus.setName("billStatus");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
        // CoreUI		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);
        // contcompanyOrg		
        this.contcompanyOrg.setBoundLabelText(resHelper.getString("contcompanyOrg.boundLabelText"));		
        this.contcompanyOrg.setBoundLabelLength(100);		
        this.contcompanyOrg.setBoundLabelUnderline(true);		
        this.contcompanyOrg.setVisible(true);
        // contshrPerson		
        this.contshrPerson.setBoundLabelText(resHelper.getString("contshrPerson.boundLabelText"));		
        this.contshrPerson.setBoundLabelLength(100);		
        this.contshrPerson.setBoundLabelUnderline(true);		
        this.contshrPerson.setVisible(true);
        // contshrPersonName		
        this.contshrPersonName.setBoundLabelText(resHelper.getString("contshrPersonName.boundLabelText"));		
        this.contshrPersonName.setBoundLabelLength(100);		
        this.contshrPersonName.setBoundLabelUnderline(true);		
        this.contshrPersonName.setVisible(true);
        // contAdminOrgUnit		
        this.contAdminOrgUnit.setBoundLabelText(resHelper.getString("contAdminOrgUnit.boundLabelText"));		
        this.contAdminOrgUnit.setBoundLabelLength(100);		
        this.contAdminOrgUnit.setBoundLabelUnderline(true);		
        this.contAdminOrgUnit.setVisible(true);
        // contpersonNature		
        this.contpersonNature.setBoundLabelText(resHelper.getString("contpersonNature.boundLabelText"));		
        this.contpersonNature.setBoundLabelLength(100);		
        this.contpersonNature.setBoundLabelUnderline(true);		
        this.contpersonNature.setVisible(true);
        // contPersonNatureCode		
        this.contPersonNatureCode.setBoundLabelText(resHelper.getString("contPersonNatureCode.boundLabelText"));		
        this.contPersonNatureCode.setBoundLabelLength(100);		
        this.contPersonNatureCode.setBoundLabelUnderline(true);		
        this.contPersonNatureCode.setVisible(true);
        // contPersonNatureName		
        this.contPersonNatureName.setBoundLabelText(resHelper.getString("contPersonNatureName.boundLabelText"));		
        this.contPersonNatureName.setBoundLabelLength(100);		
        this.contPersonNatureName.setBoundLabelUnderline(true);		
        this.contPersonNatureName.setVisible(true);
        // contEASperson		
        this.contEASperson.setBoundLabelText(resHelper.getString("contEASperson.boundLabelText"));		
        this.contEASperson.setBoundLabelLength(100);		
        this.contEASperson.setBoundLabelUnderline(true);		
        this.contEASperson.setVisible(true);
        // contEASPersonName		
        this.contEASPersonName.setBoundLabelText(resHelper.getString("contEASPersonName.boundLabelText"));		
        this.contEASPersonName.setBoundLabelLength(100);		
        this.contEASPersonName.setBoundLabelUnderline(true);		
        this.contEASPersonName.setVisible(true);
        // contEASPersonNum		
        this.contEASPersonNum.setBoundLabelText(resHelper.getString("contEASPersonNum.boundLabelText"));		
        this.contEASPersonNum.setBoundLabelLength(100);		
        this.contEASPersonNum.setBoundLabelUnderline(true);		
        this.contEASPersonNum.setVisible(false);
        // contbillStatus		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setRequired(true);
        // prmtcompanyOrg		
        this.prmtcompanyOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompanyOrg.setVisible(true);		
        this.prmtcompanyOrg.setEditable(true);		
        this.prmtcompanyOrg.setDisplayFormat("$name$");		
        this.prmtcompanyOrg.setEditFormat("$number$");		
        this.prmtcompanyOrg.setCommitFormat("$number$");		
        this.prmtcompanyOrg.setRequired(true);
        // txtshrPerson		
        this.txtshrPerson.setVisible(true);		
        this.txtshrPerson.setHorizontalAlignment(2);		
        this.txtshrPerson.setMaxLength(100);		
        this.txtshrPerson.setRequired(true);
        // txtshrPersonName		
        this.txtshrPersonName.setVisible(true);		
        this.txtshrPersonName.setHorizontalAlignment(2);		
        this.txtshrPersonName.setMaxLength(100);		
        this.txtshrPersonName.setRequired(false);
        // prmtAdminOrgUnit		
        this.prmtAdminOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtAdminOrgUnit.setVisible(true);		
        this.prmtAdminOrgUnit.setEditable(true);		
        this.prmtAdminOrgUnit.setDisplayFormat("$name$");		
        this.prmtAdminOrgUnit.setEditFormat("$number$");		
        this.prmtAdminOrgUnit.setCommitFormat("$number$");		
        this.prmtAdminOrgUnit.setRequired(true);
        // prmtpersonNature		
        this.prmtpersonNature.setQueryInfo("com.kingdee.eas.basedata.master.auxacct.app.GeneralAsstActTypeQuery");		
        this.prmtpersonNature.setVisible(true);		
        this.prmtpersonNature.setEditable(true);		
        this.prmtpersonNature.setDisplayFormat("$name$");		
        this.prmtpersonNature.setEditFormat("$number$");		
        this.prmtpersonNature.setCommitFormat("$number$");		
        this.prmtpersonNature.setRequired(false);
        prmtpersonNature.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtpersonNature_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtPersonNatureCode		
        this.txtPersonNatureCode.setVisible(false);		
        this.txtPersonNatureCode.setHorizontalAlignment(2);		
        this.txtPersonNatureCode.setMaxLength(80);		
        this.txtPersonNatureCode.setRequired(false);
        // txtPersonNatureName		
        this.txtPersonNatureName.setVisible(false);		
        this.txtPersonNatureName.setHorizontalAlignment(2);		
        this.txtPersonNatureName.setMaxLength(80);		
        this.txtPersonNatureName.setRequired(false);
        // prmtEASperson		
        this.prmtEASperson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtEASperson.setVisible(true);		
        this.prmtEASperson.setEditable(true);		
        this.prmtEASperson.setDisplayFormat("$number$");		
        this.prmtEASperson.setEditFormat("$number$");		
        this.prmtEASperson.setCommitFormat("$number$");		
        this.prmtEASperson.setRequired(true);
        prmtEASperson.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtEASperson_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtEASPersonName		
        this.txtEASPersonName.setVisible(true);		
        this.txtEASPersonName.setHorizontalAlignment(2);		
        this.txtEASPersonName.setMaxLength(80);		
        this.txtEASPersonName.setRequired(false);		
        this.txtEASPersonName.setEnabled(false);
        // txtEASPersonNum		
        this.txtEASPersonNum.setVisible(false);		
        this.txtEASPersonNum.setHorizontalAlignment(2);		
        this.txtEASPersonNum.setMaxLength(80);		
        this.txtEASPersonNum.setRequired(false);
        // billStatus		
        this.billStatus.setVisible(true);		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.salaryvoucher.voucherStatus").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtcompanyOrg,txtshrPerson,txtshrPersonName,prmtAdminOrgUnit,prmtpersonNature,txtPersonNatureCode,txtPersonNatureName,prmtEASperson,txtEASPersonName,txtEASPersonNum,billStatus}));
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
        this.setBounds(new Rectangle(0, 0, 361, 361));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(20, 21, 315, 19));
        this.add(kDLabelContainer1, null);
        contcompanyOrg.setBounds(new Rectangle(20, 60, 315, 19));
        this.add(contcompanyOrg, null);
        contshrPerson.setBounds(new Rectangle(20, 177, 315, 19));
        this.add(contshrPerson, null);
        contshrPersonName.setBounds(new Rectangle(20, 216, 315, 19));
        this.add(contshrPersonName, null);
        contAdminOrgUnit.setBounds(new Rectangle(20, 255, 315, 19));
        this.add(contAdminOrgUnit, null);
        contpersonNature.setBounds(new Rectangle(20, 296, 315, 19));
        this.add(contpersonNature, null);
        contPersonNatureCode.setBounds(new Rectangle(299, 170, 270, 19));
        this.add(contPersonNatureCode, null);
        contPersonNatureName.setBounds(new Rectangle(292, 313, 270, 19));
        this.add(contPersonNatureName, null);
        contEASperson.setBounds(new Rectangle(20, 99, 315, 19));
        this.add(contEASperson, null);
        contEASPersonName.setBounds(new Rectangle(20, 138, 315, 19));
        this.add(contEASPersonName, null);
        contEASPersonNum.setBounds(new Rectangle(312, 226, 270, 19));
        this.add(contEASPersonNum, null);
        contbillStatus.setBounds(new Rectangle(20, 333, 315, 19));
        this.add(contbillStatus, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //contcompanyOrg
        contcompanyOrg.setBoundEditor(prmtcompanyOrg);
        //contshrPerson
        contshrPerson.setBoundEditor(txtshrPerson);
        //contshrPersonName
        contshrPersonName.setBoundEditor(txtshrPersonName);
        //contAdminOrgUnit
        contAdminOrgUnit.setBoundEditor(prmtAdminOrgUnit);
        //contpersonNature
        contpersonNature.setBoundEditor(prmtpersonNature);
        //contPersonNatureCode
        contPersonNatureCode.setBoundEditor(txtPersonNatureCode);
        //contPersonNatureName
        contPersonNatureName.setBoundEditor(txtPersonNatureName);
        //contEASperson
        contEASperson.setBoundEditor(prmtEASperson);
        //contEASPersonName
        contEASPersonName.setBoundEditor(txtEASPersonName);
        //contEASPersonNum
        contEASPersonNum.setBoundEditor(txtEASPersonNum);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);

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
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("companyOrg", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompanyOrg, "data");
		dataBinder.registerBinding("shrPerson", String.class, this.txtshrPerson, "text");
		dataBinder.registerBinding("shrPersonName", String.class, this.txtshrPersonName, "text");
		dataBinder.registerBinding("AdminOrgUnit", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtAdminOrgUnit, "data");
		dataBinder.registerBinding("personNature", com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo.class, this.prmtpersonNature, "data");
		dataBinder.registerBinding("PersonNatureCode", String.class, this.txtPersonNatureCode, "text");
		dataBinder.registerBinding("PersonNatureName", String.class, this.txtPersonNatureName, "text");
		dataBinder.registerBinding("EASperson", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtEASperson, "data");
		dataBinder.registerBinding("EASPersonName", String.class, this.txtEASPersonName, "text");
		dataBinder.registerBinding("EASPersonNum", String.class, this.txtEASPersonNum, "text");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.custom.salaryvoucher.voucherStatus.class, this.billStatus, "selectedItem");		
	}
	//Regiester UI State
	private void registerUIState(){
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtNumber, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtNumber, ActionStateConst.ENABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtNumber, ActionStateConst.DISABLED);		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.salaryvoucher.app.PersonRelationEditUIHandler";
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
        this.prmtcompanyOrg.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.salaryvoucher.PersonRelationInfo)ov;
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
		getValidateHelper().registerBindProperty("companyOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("shrPerson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("shrPersonName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AdminOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("personNature", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PersonNatureCode", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PersonNatureName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EASperson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EASPersonName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EASPersonNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    		
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
     * output prmtpersonNature_Changed() method
     */
    public void prmtpersonNature_Changed() throws Exception
    {
        System.out.println("prmtpersonNature_Changed() Function is executed!");
            txtPersonNatureCode.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtpersonNature.getData(),"number")));

    txtPersonNatureName.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtpersonNature.getData(),"name")));


    }

    /**
     * output prmtEASperson_Changed() method
     */
    public void prmtEASperson_Changed() throws Exception
    {
        System.out.println("prmtEASperson_Changed() Function is executed!");
            txtEASPersonName.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtEASperson.getData(),"name")));

    txtEASPersonNum.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtEASperson.getData(),"number")));


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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("companyOrg.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("companyOrg.id"));
        	sic.add(new SelectorItemInfo("companyOrg.number"));
        	sic.add(new SelectorItemInfo("companyOrg.name"));
		}
        sic.add(new SelectorItemInfo("shrPerson"));
        sic.add(new SelectorItemInfo("shrPersonName"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("AdminOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("AdminOrgUnit.id"));
        	sic.add(new SelectorItemInfo("AdminOrgUnit.number"));
        	sic.add(new SelectorItemInfo("AdminOrgUnit.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("personNature.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("personNature.id"));
        	sic.add(new SelectorItemInfo("personNature.number"));
        	sic.add(new SelectorItemInfo("personNature.name"));
		}
        sic.add(new SelectorItemInfo("PersonNatureCode"));
        sic.add(new SelectorItemInfo("PersonNatureName"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EASperson.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("EASperson.id"));
        	sic.add(new SelectorItemInfo("EASperson.number"));
        	sic.add(new SelectorItemInfo("EASperson.name"));
		}
        sic.add(new SelectorItemInfo("EASPersonName"));
        sic.add(new SelectorItemInfo("EASPersonNum"));
        sic.add(new SelectorItemInfo("billStatus"));
        return sic;
    }        
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.salaryvoucher.PersonRelationFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.salaryvoucher.PersonRelationFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractPersonRelationEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractPersonRelationEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.salaryvoucher.client", "PersonRelationEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.salaryvoucher.client.PersonRelationEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.salaryvoucher.PersonRelationFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.salaryvoucher.PersonRelationInfo objectValue = new com.kingdee.eas.custom.salaryvoucher.PersonRelationInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtNumber.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"编码"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompanyOrg.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtshrPerson.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"shr人员编码"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtAdminOrgUnit.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"行政组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtEASperson.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"EAS人员"});
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
		vo.put("billStatus","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}