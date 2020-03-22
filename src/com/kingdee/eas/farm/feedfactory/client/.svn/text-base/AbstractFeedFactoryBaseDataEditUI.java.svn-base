/**
 * output package name
 */
package com.kingdee.eas.farm.feedfactory.client;

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
public abstract class AbstractFeedFactoryBaseDataEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractFeedFactoryBaseDataEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfeedFactory;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator5;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstartLoadTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contendLoadTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmaxEntruckCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlunchBeginTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlunchEndTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlunchTimecost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLoadingTimes;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contqcOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfeedFactory;
    protected com.kingdee.bos.ctrl.swing.KDTimePicker startLoadTime;
    protected com.kingdee.bos.ctrl.swing.KDTimePicker endLoadTime;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmaxEntruckCount;
    protected com.kingdee.bos.ctrl.swing.KDTimePicker lunchBeginTime;
    protected com.kingdee.bos.ctrl.swing.KDTimePicker lunchEndTime;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtlunchTimecost;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtLoadingTimes;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtqcOrgUnit;
    protected com.kingdee.eas.farm.feedfactory.FeedFactoryBaseDataInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractFeedFactoryBaseDataEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractFeedFactoryBaseDataEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfeedFactory = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator5 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contstartLoadTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contendLoadTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmaxEntruckCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlunchBeginTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlunchEndTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlunchTimecost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLoadingTimes = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contqcOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.prmtfeedFactory = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.startLoadTime = new com.kingdee.bos.ctrl.swing.KDTimePicker();
        this.endLoadTime = new com.kingdee.bos.ctrl.swing.KDTimePicker();
        this.txtmaxEntruckCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.lunchBeginTime = new com.kingdee.bos.ctrl.swing.KDTimePicker();
        this.lunchEndTime = new com.kingdee.bos.ctrl.swing.KDTimePicker();
        this.txtlunchTimecost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtLoadingTimes = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtqcOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contfeedFactory.setName("contfeedFactory");
        this.kDSeparator5.setName("kDSeparator5");
        this.contstartLoadTime.setName("contstartLoadTime");
        this.contendLoadTime.setName("contendLoadTime");
        this.contmaxEntruckCount.setName("contmaxEntruckCount");
        this.contlunchBeginTime.setName("contlunchBeginTime");
        this.contlunchEndTime.setName("contlunchEndTime");
        this.contlunchTimecost.setName("contlunchTimecost");
        this.contbaseStatus.setName("contbaseStatus");
        this.contLoadingTimes.setName("contLoadingTimes");
        this.contqcOrgUnit.setName("contqcOrgUnit");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.prmtfeedFactory.setName("prmtfeedFactory");
        this.startLoadTime.setName("startLoadTime");
        this.endLoadTime.setName("endLoadTime");
        this.txtmaxEntruckCount.setName("txtmaxEntruckCount");
        this.lunchBeginTime.setName("lunchBeginTime");
        this.lunchEndTime.setName("lunchEndTime");
        this.txtlunchTimecost.setName("txtlunchTimecost");
        this.baseStatus.setName("baseStatus");
        this.txtLoadingTimes.setName("txtLoadingTimes");
        this.prmtqcOrgUnit.setName("prmtqcOrgUnit");
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
        // contfeedFactory		
        this.contfeedFactory.setBoundLabelText(resHelper.getString("contfeedFactory.boundLabelText"));		
        this.contfeedFactory.setBoundLabelLength(100);		
        this.contfeedFactory.setBoundLabelUnderline(true);		
        this.contfeedFactory.setVisible(true);
        // kDSeparator5
        // contstartLoadTime		
        this.contstartLoadTime.setBoundLabelText(resHelper.getString("contstartLoadTime.boundLabelText"));		
        this.contstartLoadTime.setBoundLabelLength(100);		
        this.contstartLoadTime.setBoundLabelUnderline(true);		
        this.contstartLoadTime.setVisible(true);
        // contendLoadTime		
        this.contendLoadTime.setBoundLabelText(resHelper.getString("contendLoadTime.boundLabelText"));		
        this.contendLoadTime.setBoundLabelLength(100);		
        this.contendLoadTime.setBoundLabelUnderline(true);		
        this.contendLoadTime.setVisible(true);
        // contmaxEntruckCount		
        this.contmaxEntruckCount.setBoundLabelText(resHelper.getString("contmaxEntruckCount.boundLabelText"));		
        this.contmaxEntruckCount.setBoundLabelLength(100);		
        this.contmaxEntruckCount.setBoundLabelUnderline(true);		
        this.contmaxEntruckCount.setVisible(true);
        // contlunchBeginTime		
        this.contlunchBeginTime.setBoundLabelText(resHelper.getString("contlunchBeginTime.boundLabelText"));		
        this.contlunchBeginTime.setBoundLabelLength(100);		
        this.contlunchBeginTime.setBoundLabelUnderline(true);		
        this.contlunchBeginTime.setVisible(true);
        // contlunchEndTime		
        this.contlunchEndTime.setBoundLabelText(resHelper.getString("contlunchEndTime.boundLabelText"));		
        this.contlunchEndTime.setBoundLabelLength(100);		
        this.contlunchEndTime.setBoundLabelUnderline(true);		
        this.contlunchEndTime.setVisible(true);
        // contlunchTimecost		
        this.contlunchTimecost.setBoundLabelText(resHelper.getString("contlunchTimecost.boundLabelText"));		
        this.contlunchTimecost.setBoundLabelLength(100);		
        this.contlunchTimecost.setBoundLabelUnderline(true);		
        this.contlunchTimecost.setVisible(true);
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);
        // contLoadingTimes		
        this.contLoadingTimes.setBoundLabelText(resHelper.getString("contLoadingTimes.boundLabelText"));		
        this.contLoadingTimes.setBoundLabelLength(100);		
        this.contLoadingTimes.setBoundLabelUnderline(true);		
        this.contLoadingTimes.setVisible(true);
        // contqcOrgUnit		
        this.contqcOrgUnit.setBoundLabelText(resHelper.getString("contqcOrgUnit.boundLabelText"));		
        this.contqcOrgUnit.setBoundLabelLength(100);		
        this.contqcOrgUnit.setBoundLabelUnderline(true);		
        this.contqcOrgUnit.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // prmtfeedFactory		
        this.prmtfeedFactory.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtfeedFactory.setEditable(true);		
        this.prmtfeedFactory.setDisplayFormat("$name$");		
        this.prmtfeedFactory.setEditFormat("$number$");		
        this.prmtfeedFactory.setCommitFormat("$number$");		
        this.prmtfeedFactory.setRequired(false);
        // startLoadTime
        // endLoadTime
        // txtmaxEntruckCount		
        this.txtmaxEntruckCount.setHorizontalAlignment(2);		
        this.txtmaxEntruckCount.setDataType(0);		
        this.txtmaxEntruckCount.setSupportedEmpty(true);		
        this.txtmaxEntruckCount.setRequired(false);
        // lunchBeginTime
        // lunchEndTime
        // txtlunchTimecost		
        this.txtlunchTimecost.setHorizontalAlignment(2);		
        this.txtlunchTimecost.setDataType(0);		
        this.txtlunchTimecost.setSupportedEmpty(true);		
        this.txtlunchTimecost.setRequired(false);
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(false);
        // txtLoadingTimes		
        this.txtLoadingTimes.setHorizontalAlignment(2);		
        this.txtLoadingTimes.setDataType(0);		
        this.txtLoadingTimes.setSupportedEmpty(true);		
        this.txtLoadingTimes.setRequired(false);
        // prmtqcOrgUnit		
        this.prmtqcOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtqcOrgUnit.setEditable(true);		
        this.prmtqcOrgUnit.setDisplayFormat("$name$");		
        this.prmtqcOrgUnit.setEditFormat("$number$");		
        this.prmtqcOrgUnit.setCommitFormat("$number$");		
        this.prmtqcOrgUnit.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtName,txtNumber,txtDescription,txtSimpleName,prmtfeedFactory,prmtqcOrgUnit,startLoadTime,endLoadTime,txtmaxEntruckCount,lunchBeginTime,lunchEndTime,txtlunchTimecost,baseStatus,txtLoadingTimes}));
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
        this.setBounds(new Rectangle(0, 1, 668, 629));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(35, 39, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(355, 39, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(51, -85, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(355, 71, 270, 19));
        this.add(kDLabelContainer4, null);
        contfeedFactory.setBounds(new Rectangle(35, 71, 270, 19));
        this.add(contfeedFactory, null);
        kDSeparator5.setBounds(new Rectangle(38, 147, 594, 10));
        this.add(kDSeparator5, null);
        contstartLoadTime.setBounds(new Rectangle(35, 177, 270, 19));
        this.add(contstartLoadTime, null);
        contendLoadTime.setBounds(new Rectangle(355, 177, 270, 19));
        this.add(contendLoadTime, null);
        contmaxEntruckCount.setBounds(new Rectangle(35, 213, 270, 19));
        this.add(contmaxEntruckCount, null);
        contlunchBeginTime.setBounds(new Rectangle(35, 286, 270, 19));
        this.add(contlunchBeginTime, null);
        contlunchEndTime.setBounds(new Rectangle(355, 286, 270, 19));
        this.add(contlunchEndTime, null);
        contlunchTimecost.setBounds(new Rectangle(35, 322, 270, 19));
        this.add(contlunchTimecost, null);
        contbaseStatus.setBounds(new Rectangle(355, 102, 270, 19));
        this.add(contbaseStatus, null);
        contLoadingTimes.setBounds(new Rectangle(354, 213, 270, 19));
        this.add(contLoadingTimes, null);
        contqcOrgUnit.setBounds(new Rectangle(35, 102, 270, 19));
        this.add(contqcOrgUnit, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contfeedFactory
        contfeedFactory.setBoundEditor(prmtfeedFactory);
        //contstartLoadTime
        contstartLoadTime.setBoundEditor(startLoadTime);
        //contendLoadTime
        contendLoadTime.setBoundEditor(endLoadTime);
        //contmaxEntruckCount
        contmaxEntruckCount.setBoundEditor(txtmaxEntruckCount);
        //contlunchBeginTime
        contlunchBeginTime.setBoundEditor(lunchBeginTime);
        //contlunchEndTime
        contlunchEndTime.setBoundEditor(lunchEndTime);
        //contlunchTimecost
        contlunchTimecost.setBoundEditor(txtlunchTimecost);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //contLoadingTimes
        contLoadingTimes.setBoundEditor(txtLoadingTimes);
        //contqcOrgUnit
        contqcOrgUnit.setBoundEditor(prmtqcOrgUnit);

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
		dataBinder.registerBinding("feedFactory", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtfeedFactory, "data");
		dataBinder.registerBinding("startLoadTime", java.sql.Time.class, this.startLoadTime, "value");
		dataBinder.registerBinding("endLoadTime", java.sql.Time.class, this.endLoadTime, "value");
		dataBinder.registerBinding("maxEntruckCount", int.class, this.txtmaxEntruckCount, "value");
		dataBinder.registerBinding("lunchBeginTime", java.sql.Time.class, this.lunchBeginTime, "value");
		dataBinder.registerBinding("lunchEndTime", java.sql.Time.class, this.lunchEndTime, "value");
		dataBinder.registerBinding("lunchTimecost", int.class, this.txtlunchTimecost, "value");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("LoadingTimes", int.class, this.txtLoadingTimes, "value");
		dataBinder.registerBinding("qcOrgUnit", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtqcOrgUnit, "data");		
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
	    return "com.kingdee.eas.farm.feedfactory.app.FeedFactoryBaseDataEditUIHandler";
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
        this.txtName.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.feedfactory.FeedFactoryBaseDataInfo)ov;
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
		getValidateHelper().registerBindProperty("feedFactory", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("startLoadTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("endLoadTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("maxEntruckCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lunchBeginTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lunchEndTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lunchTimecost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LoadingTimes", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("qcOrgUnit", ValidateHelper.ON_SAVE);    		
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
			sic.add(new SelectorItemInfo("feedFactory.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("feedFactory.id"));
        	sic.add(new SelectorItemInfo("feedFactory.number"));
        	sic.add(new SelectorItemInfo("feedFactory.name"));
		}
        sic.add(new SelectorItemInfo("startLoadTime"));
        sic.add(new SelectorItemInfo("endLoadTime"));
        sic.add(new SelectorItemInfo("maxEntruckCount"));
        sic.add(new SelectorItemInfo("lunchBeginTime"));
        sic.add(new SelectorItemInfo("lunchEndTime"));
        sic.add(new SelectorItemInfo("lunchTimecost"));
        sic.add(new SelectorItemInfo("baseStatus"));
        sic.add(new SelectorItemInfo("LoadingTimes"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("qcOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("qcOrgUnit.id"));
        	sic.add(new SelectorItemInfo("qcOrgUnit.number"));
        	sic.add(new SelectorItemInfo("qcOrgUnit.name"));
		}
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.feedfactory.client", "FeedFactoryBaseDataEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.feedfactory.client.FeedFactoryBaseDataEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.feedfactory.FeedFactoryBaseDataFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.feedfactory.FeedFactoryBaseDataInfo objectValue = new com.kingdee.eas.farm.feedfactory.FeedFactoryBaseDataInfo();
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
		vo.put("baseStatus",new Integer(-1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}