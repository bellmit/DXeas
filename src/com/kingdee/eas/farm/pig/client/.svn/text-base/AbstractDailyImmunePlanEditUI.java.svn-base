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
public abstract class AbstractDailyImmunePlanEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractDailyImmunePlanEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpigFarmType;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkbyPigFarmType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contactiveDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdisableDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimmuneBeginDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimmuneEndDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimmuneMaterial;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimmuneMode;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contunit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contqty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdeletedStatus;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDComboBox pigFarmType;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkactiveDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkdisableDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkimmuneBeginDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkimmuneEndDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtimmuneMaterial;
    protected com.kingdee.bos.ctrl.swing.KDComboBox immuneMode;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtunit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtqty;
    protected com.kingdee.bos.ctrl.swing.KDComboBox deletedStatus;
    protected com.kingdee.eas.farm.pig.DailyImmunePlanInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractDailyImmunePlanEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractDailyImmunePlanEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpigFarmType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkbyPigFarmType = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contactiveDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdisableDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimmuneBeginDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimmuneEndDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimmuneMaterial = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimmuneMode = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contunit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contqty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdeletedStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.pigFarmType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.pkactiveDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkdisableDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkimmuneBeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkimmuneEndDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtimmuneMaterial = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.immuneMode = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtunit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtqty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.deletedStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contpigFarmType.setName("contpigFarmType");
        this.chkbyPigFarmType.setName("chkbyPigFarmType");
        this.contactiveDate.setName("contactiveDate");
        this.contdisableDate.setName("contdisableDate");
        this.contimmuneBeginDate.setName("contimmuneBeginDate");
        this.contimmuneEndDate.setName("contimmuneEndDate");
        this.contimmuneMaterial.setName("contimmuneMaterial");
        this.contimmuneMode.setName("contimmuneMode");
        this.contunit.setName("contunit");
        this.contqty.setName("contqty");
        this.contdeletedStatus.setName("contdeletedStatus");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.pigFarmType.setName("pigFarmType");
        this.pkactiveDate.setName("pkactiveDate");
        this.pkdisableDate.setName("pkdisableDate");
        this.pkimmuneBeginDate.setName("pkimmuneBeginDate");
        this.pkimmuneEndDate.setName("pkimmuneEndDate");
        this.prmtimmuneMaterial.setName("prmtimmuneMaterial");
        this.immuneMode.setName("immuneMode");
        this.prmtunit.setName("prmtunit");
        this.txtqty.setName("txtqty");
        this.deletedStatus.setName("deletedStatus");
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
        // contpigFarmType		
        this.contpigFarmType.setBoundLabelText(resHelper.getString("contpigFarmType.boundLabelText"));		
        this.contpigFarmType.setBoundLabelLength(100);		
        this.contpigFarmType.setBoundLabelUnderline(true);		
        this.contpigFarmType.setVisible(true);
        // chkbyPigFarmType		
        this.chkbyPigFarmType.setText(resHelper.getString("chkbyPigFarmType.text"));		
        this.chkbyPigFarmType.setVisible(true);		
        this.chkbyPigFarmType.setHorizontalAlignment(2);
        // contactiveDate		
        this.contactiveDate.setBoundLabelText(resHelper.getString("contactiveDate.boundLabelText"));		
        this.contactiveDate.setBoundLabelLength(100);		
        this.contactiveDate.setBoundLabelUnderline(true);		
        this.contactiveDate.setVisible(true);
        // contdisableDate		
        this.contdisableDate.setBoundLabelText(resHelper.getString("contdisableDate.boundLabelText"));		
        this.contdisableDate.setBoundLabelLength(100);		
        this.contdisableDate.setBoundLabelUnderline(true);		
        this.contdisableDate.setVisible(true);
        // contimmuneBeginDate		
        this.contimmuneBeginDate.setBoundLabelText(resHelper.getString("contimmuneBeginDate.boundLabelText"));		
        this.contimmuneBeginDate.setBoundLabelLength(100);		
        this.contimmuneBeginDate.setBoundLabelUnderline(true);		
        this.contimmuneBeginDate.setVisible(true);
        // contimmuneEndDate		
        this.contimmuneEndDate.setBoundLabelText(resHelper.getString("contimmuneEndDate.boundLabelText"));		
        this.contimmuneEndDate.setBoundLabelLength(100);		
        this.contimmuneEndDate.setBoundLabelUnderline(true);		
        this.contimmuneEndDate.setVisible(true);
        // contimmuneMaterial		
        this.contimmuneMaterial.setBoundLabelText(resHelper.getString("contimmuneMaterial.boundLabelText"));		
        this.contimmuneMaterial.setBoundLabelLength(100);		
        this.contimmuneMaterial.setBoundLabelUnderline(true);		
        this.contimmuneMaterial.setVisible(true);
        // contimmuneMode		
        this.contimmuneMode.setBoundLabelText(resHelper.getString("contimmuneMode.boundLabelText"));		
        this.contimmuneMode.setBoundLabelLength(100);		
        this.contimmuneMode.setBoundLabelUnderline(true);		
        this.contimmuneMode.setVisible(true);
        // contunit		
        this.contunit.setBoundLabelText(resHelper.getString("contunit.boundLabelText"));		
        this.contunit.setBoundLabelLength(100);		
        this.contunit.setBoundLabelUnderline(true);		
        this.contunit.setVisible(true);
        // contqty		
        this.contqty.setBoundLabelText(resHelper.getString("contqty.boundLabelText"));		
        this.contqty.setBoundLabelLength(100);		
        this.contqty.setBoundLabelUnderline(true);		
        this.contqty.setVisible(true);
        // contdeletedStatus		
        this.contdeletedStatus.setBoundLabelText(resHelper.getString("contdeletedStatus.boundLabelText"));		
        this.contdeletedStatus.setBoundLabelLength(100);		
        this.contdeletedStatus.setBoundLabelUnderline(true);		
        this.contdeletedStatus.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // pigFarmType		
        this.pigFarmType.setVisible(true);		
        this.pigFarmType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.pig.PigFarmType").toArray());		
        this.pigFarmType.setRequired(false);
        // pkactiveDate		
        this.pkactiveDate.setVisible(true);		
        this.pkactiveDate.setRequired(false);
        // pkdisableDate		
        this.pkdisableDate.setVisible(true);		
        this.pkdisableDate.setRequired(false);
        // pkimmuneBeginDate		
        this.pkimmuneBeginDate.setVisible(true);		
        this.pkimmuneBeginDate.setRequired(false);
        // pkimmuneEndDate		
        this.pkimmuneEndDate.setVisible(true);		
        this.pkimmuneEndDate.setRequired(false);
        // prmtimmuneMaterial		
        this.prmtimmuneMaterial.setQueryInfo("com.kingdee.eas.basedata.master.material.app.MaterialQuery");		
        this.prmtimmuneMaterial.setVisible(true);		
        this.prmtimmuneMaterial.setEditable(true);		
        this.prmtimmuneMaterial.setDisplayFormat("$name$");		
        this.prmtimmuneMaterial.setEditFormat("$number$");		
        this.prmtimmuneMaterial.setCommitFormat("$number$");		
        this.prmtimmuneMaterial.setRequired(false);
        // immuneMode		
        this.immuneMode.setVisible(true);		
        this.immuneMode.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.pig.ImmuneMode").toArray());		
        this.immuneMode.setRequired(false);
        // prmtunit		
        this.prmtunit.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");		
        this.prmtunit.setVisible(true);		
        this.prmtunit.setEditable(true);		
        this.prmtunit.setDisplayFormat("$name$");		
        this.prmtunit.setEditFormat("$number$");		
        this.prmtunit.setCommitFormat("$number$");		
        this.prmtunit.setRequired(false);
        // txtqty		
        this.txtqty.setVisible(true);		
        this.txtqty.setHorizontalAlignment(2);		
        this.txtqty.setDataType(1);		
        this.txtqty.setSupportedEmpty(true);		
        this.txtqty.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtqty.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtqty.setPrecision(2);		
        this.txtqty.setRequired(false);
        // deletedStatus		
        this.deletedStatus.setVisible(true);		
        this.deletedStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.pig.DisableState").toArray());		
        this.deletedStatus.setRequired(false);		
        this.deletedStatus.setEnabled(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {pigFarmType,chkbyPigFarmType,pkactiveDate,pkdisableDate,pkimmuneBeginDate,pkimmuneEndDate,prmtimmuneMaterial,immuneMode,prmtunit,txtqty,deletedStatus}));
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
        kDLabelContainer1.setBounds(new Rectangle(35, 41, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(340, 41, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(67, -111, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(35, 263, 270, 19));
        this.add(kDLabelContainer4, null);
        contpigFarmType.setBounds(new Rectangle(114, 78, 182, 19));
        this.add(contpigFarmType, null);
        chkbyPigFarmType.setBounds(new Rectangle(35, 78, 81, 19));
        this.add(chkbyPigFarmType, null);
        contactiveDate.setBounds(new Rectangle(35, 189, 270, 19));
        this.add(contactiveDate, null);
        contdisableDate.setBounds(new Rectangle(340, 189, 270, 19));
        this.add(contdisableDate, null);
        contimmuneBeginDate.setBounds(new Rectangle(35, 226, 270, 19));
        this.add(contimmuneBeginDate, null);
        contimmuneEndDate.setBounds(new Rectangle(340, 226, 270, 19));
        this.add(contimmuneEndDate, null);
        contimmuneMaterial.setBounds(new Rectangle(35, 115, 270, 19));
        this.add(contimmuneMaterial, null);
        contimmuneMode.setBounds(new Rectangle(340, 115, 270, 19));
        this.add(contimmuneMode, null);
        contunit.setBounds(new Rectangle(35, 152, 270, 19));
        this.add(contunit, null);
        contqty.setBounds(new Rectangle(340, 152, 270, 19));
        this.add(contqty, null);
        contdeletedStatus.setBounds(new Rectangle(340, 78, 270, 19));
        this.add(contdeletedStatus, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contpigFarmType
        contpigFarmType.setBoundEditor(pigFarmType);
        //contactiveDate
        contactiveDate.setBoundEditor(pkactiveDate);
        //contdisableDate
        contdisableDate.setBoundEditor(pkdisableDate);
        //contimmuneBeginDate
        contimmuneBeginDate.setBoundEditor(pkimmuneBeginDate);
        //contimmuneEndDate
        contimmuneEndDate.setBoundEditor(pkimmuneEndDate);
        //contimmuneMaterial
        contimmuneMaterial.setBoundEditor(prmtimmuneMaterial);
        //contimmuneMode
        contimmuneMode.setBoundEditor(immuneMode);
        //contunit
        contunit.setBoundEditor(prmtunit);
        //contqty
        contqty.setBoundEditor(txtqty);
        //contdeletedStatus
        contdeletedStatus.setBoundEditor(deletedStatus);

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
		dataBinder.registerBinding("byPigFarmType", boolean.class, this.chkbyPigFarmType, "selected");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("pigFarmType", com.kingdee.eas.farm.pig.PigFarmType.class, this.pigFarmType, "selectedItem");
		dataBinder.registerBinding("activeDate", java.util.Date.class, this.pkactiveDate, "value");
		dataBinder.registerBinding("disableDate", java.util.Date.class, this.pkdisableDate, "value");
		dataBinder.registerBinding("immuneBeginDate", java.util.Date.class, this.pkimmuneBeginDate, "value");
		dataBinder.registerBinding("immuneEndDate", java.util.Date.class, this.pkimmuneEndDate, "value");
		dataBinder.registerBinding("immuneMaterial", com.kingdee.eas.basedata.master.material.MaterialInfo.class, this.prmtimmuneMaterial, "data");
		dataBinder.registerBinding("immuneMode", com.kingdee.eas.farm.pig.ImmuneMode.class, this.immuneMode, "selectedItem");
		dataBinder.registerBinding("unit", com.kingdee.eas.basedata.assistant.MeasureUnitInfo.class, this.prmtunit, "data");
		dataBinder.registerBinding("qty", java.math.BigDecimal.class, this.txtqty, "value");
		dataBinder.registerBinding("deletedStatus", com.kingdee.eas.farm.pig.DisableState.class, this.deletedStatus, "selectedItem");		
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
	    return "com.kingdee.eas.farm.pig.app.DailyImmunePlanEditUIHandler";
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
        this.pigFarmType.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.pig.DailyImmunePlanInfo)ov;
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
		getValidateHelper().registerBindProperty("byPigFarmType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("pigFarmType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("activeDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("disableDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("immuneBeginDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("immuneEndDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("immuneMaterial", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("immuneMode", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("deletedStatus", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("byPigFarmType"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("simpleName"));
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("pigFarmType"));
        sic.add(new SelectorItemInfo("activeDate"));
        sic.add(new SelectorItemInfo("disableDate"));
        sic.add(new SelectorItemInfo("immuneBeginDate"));
        sic.add(new SelectorItemInfo("immuneEndDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("immuneMaterial.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("immuneMaterial.id"));
        	sic.add(new SelectorItemInfo("immuneMaterial.number"));
        	sic.add(new SelectorItemInfo("immuneMaterial.name"));
		}
        sic.add(new SelectorItemInfo("immuneMode"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("unit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("unit.id"));
        	sic.add(new SelectorItemInfo("unit.number"));
        	sic.add(new SelectorItemInfo("unit.name"));
		}
        sic.add(new SelectorItemInfo("qty"));
        sic.add(new SelectorItemInfo("deletedStatus"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.pig.client", "DailyImmunePlanEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.pig.client.DailyImmunePlanEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.pig.DailyImmunePlanFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.pig.DailyImmunePlanInfo objectValue = new com.kingdee.eas.farm.pig.DailyImmunePlanInfo();
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
		vo.put("pigFarmType","1");
vo.put("immuneMode","1");
vo.put("deletedStatus",new Integer(1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}