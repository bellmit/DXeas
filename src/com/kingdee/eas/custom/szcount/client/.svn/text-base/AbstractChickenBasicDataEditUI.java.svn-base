/**
 * output package name
 */
package com.kingdee.eas.custom.szcount.client;

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
public abstract class AbstractChickenBasicDataEditUI extends com.kingdee.eas.custom.wlhllicensemanager.client.WlhlBaseEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractChickenBasicDataEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenCropPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenMixedOilPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenIntestinesPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenFeatherPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenBooldPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttonPrice;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickenCropPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickenMixedOilPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickenIntestinesPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickenFeatherPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickenBooldPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttonPrice;
    protected com.kingdee.eas.custom.szcount.ChickenBasicDataInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractChickenBasicDataEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractChickenBasicDataEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchickenCropPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchickenMixedOilPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchickenIntestinesPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchickenFeatherPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchickenBooldPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttonPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtchickenCropPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtchickenMixedOilPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtchickenIntestinesPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtchickenFeatherPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtchickenBooldPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttonPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contcompany.setName("contcompany");
        this.contchickenCropPrice.setName("contchickenCropPrice");
        this.contchickenMixedOilPrice.setName("contchickenMixedOilPrice");
        this.contchickenIntestinesPrice.setName("contchickenIntestinesPrice");
        this.contchickenFeatherPrice.setName("contchickenFeatherPrice");
        this.contchickenBooldPrice.setName("contchickenBooldPrice");
        this.conttonPrice.setName("conttonPrice");
        this.prmtcompany.setName("prmtcompany");
        this.txtchickenCropPrice.setName("txtchickenCropPrice");
        this.txtchickenMixedOilPrice.setName("txtchickenMixedOilPrice");
        this.txtchickenIntestinesPrice.setName("txtchickenIntestinesPrice");
        this.txtchickenFeatherPrice.setName("txtchickenFeatherPrice");
        this.txtchickenBooldPrice.setName("txtchickenBooldPrice");
        this.txttonPrice.setName("txttonPrice");
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
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelAlignment(7);		
        this.kDLabelContainer4.setVisible(true);		
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
        this.prmtapprover.setVisible(true);		
        this.prmtapprover.setEditable(true);		
        this.prmtapprover.setDisplayFormat("$number$");		
        this.prmtapprover.setEditFormat("$number$");		
        this.prmtapprover.setCommitFormat("$number$");		
        this.prmtapprover.setRequired(false);		
        this.prmtapprover.setEnabled(false);		
        this.pkapproveTime.setVisible(true);		
        this.pkapproveTime.setRequired(false);		
        this.pkapproveTime.setEnabled(false);		
        this.baseStatus.setVisible(true);		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.wlhllicensemanager.UsedStatusEnum").toArray());		
        this.baseStatus.setRequired(false);		
        this.prmtcreator.setVisible(true);		
        this.prmtcreator.setEditable(true);		
        this.prmtcreator.setDisplayFormat("$name$");		
        this.prmtcreator.setEditFormat("$number$");		
        this.prmtcreator.setCommitFormat("$number$");		
        this.prmtcreator.setRequired(false);		
        this.prmtcreator.setEnabled(false);		
        this.pkcreateTime.setVisible(true);		
        this.pkcreateTime.setRequired(false);		
        this.pkcreateTime.setEnabled(false);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contchickenCropPrice		
        this.contchickenCropPrice.setBoundLabelText(resHelper.getString("contchickenCropPrice.boundLabelText"));		
        this.contchickenCropPrice.setBoundLabelLength(100);		
        this.contchickenCropPrice.setBoundLabelUnderline(true);		
        this.contchickenCropPrice.setVisible(true);
        // contchickenMixedOilPrice		
        this.contchickenMixedOilPrice.setBoundLabelText(resHelper.getString("contchickenMixedOilPrice.boundLabelText"));		
        this.contchickenMixedOilPrice.setBoundLabelLength(100);		
        this.contchickenMixedOilPrice.setBoundLabelUnderline(true);		
        this.contchickenMixedOilPrice.setVisible(true);
        // contchickenIntestinesPrice		
        this.contchickenIntestinesPrice.setBoundLabelText(resHelper.getString("contchickenIntestinesPrice.boundLabelText"));		
        this.contchickenIntestinesPrice.setBoundLabelLength(100);		
        this.contchickenIntestinesPrice.setBoundLabelUnderline(true);		
        this.contchickenIntestinesPrice.setVisible(true);
        // contchickenFeatherPrice		
        this.contchickenFeatherPrice.setBoundLabelText(resHelper.getString("contchickenFeatherPrice.boundLabelText"));		
        this.contchickenFeatherPrice.setBoundLabelLength(100);		
        this.contchickenFeatherPrice.setBoundLabelUnderline(true);		
        this.contchickenFeatherPrice.setVisible(true);
        // contchickenBooldPrice		
        this.contchickenBooldPrice.setBoundLabelText(resHelper.getString("contchickenBooldPrice.boundLabelText"));		
        this.contchickenBooldPrice.setBoundLabelLength(100);		
        this.contchickenBooldPrice.setBoundLabelUnderline(true);		
        this.contchickenBooldPrice.setVisible(true);
        // conttonPrice		
        this.conttonPrice.setBoundLabelText(resHelper.getString("conttonPrice.boundLabelText"));		
        this.conttonPrice.setBoundLabelLength(100);		
        this.conttonPrice.setBoundLabelUnderline(true);		
        this.conttonPrice.setVisible(true);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setVisible(true);		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(false);
        // txtchickenCropPrice		
        this.txtchickenCropPrice.setVisible(true);		
        this.txtchickenCropPrice.setHorizontalAlignment(2);		
        this.txtchickenCropPrice.setDataType(1);		
        this.txtchickenCropPrice.setSupportedEmpty(true);		
        this.txtchickenCropPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchickenCropPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchickenCropPrice.setPrecision(4);		
        this.txtchickenCropPrice.setRequired(false);
        // txtchickenMixedOilPrice		
        this.txtchickenMixedOilPrice.setVisible(true);		
        this.txtchickenMixedOilPrice.setHorizontalAlignment(2);		
        this.txtchickenMixedOilPrice.setDataType(1);		
        this.txtchickenMixedOilPrice.setSupportedEmpty(true);		
        this.txtchickenMixedOilPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchickenMixedOilPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchickenMixedOilPrice.setPrecision(4);		
        this.txtchickenMixedOilPrice.setRequired(false);
        // txtchickenIntestinesPrice		
        this.txtchickenIntestinesPrice.setVisible(true);		
        this.txtchickenIntestinesPrice.setHorizontalAlignment(2);		
        this.txtchickenIntestinesPrice.setDataType(1);		
        this.txtchickenIntestinesPrice.setSupportedEmpty(true);		
        this.txtchickenIntestinesPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchickenIntestinesPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchickenIntestinesPrice.setPrecision(4);		
        this.txtchickenIntestinesPrice.setRequired(false);
        // txtchickenFeatherPrice		
        this.txtchickenFeatherPrice.setVisible(true);		
        this.txtchickenFeatherPrice.setHorizontalAlignment(2);		
        this.txtchickenFeatherPrice.setDataType(1);		
        this.txtchickenFeatherPrice.setSupportedEmpty(true);		
        this.txtchickenFeatherPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchickenFeatherPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchickenFeatherPrice.setPrecision(4);		
        this.txtchickenFeatherPrice.setRequired(false);
        // txtchickenBooldPrice		
        this.txtchickenBooldPrice.setVisible(true);		
        this.txtchickenBooldPrice.setHorizontalAlignment(2);		
        this.txtchickenBooldPrice.setDataType(1);		
        this.txtchickenBooldPrice.setSupportedEmpty(true);		
        this.txtchickenBooldPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchickenBooldPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchickenBooldPrice.setPrecision(4);		
        this.txtchickenBooldPrice.setRequired(false);
        // txttonPrice		
        this.txttonPrice.setVisible(true);		
        this.txttonPrice.setHorizontalAlignment(2);		
        this.txttonPrice.setDataType(1);		
        this.txttonPrice.setSupportedEmpty(true);		
        this.txttonPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttonPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttonPrice.setPrecision(2);		
        this.txttonPrice.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtcompany,txtchickenBooldPrice,txtchickenFeatherPrice,txtchickenIntestinesPrice,txtchickenCropPrice,txtchickenMixedOilPrice,txttonPrice}));
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
        this.setBounds(new Rectangle(0, 0, 705, 342));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(15, 18, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(15, 55, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(15, 89, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(15, 123, 270, 19));
        this.add(kDLabelContainer4, null);
        contapprover.setBounds(new Rectangle(15, 259, 270, 19));
        this.add(contapprover, null);
        contapproveTime.setBounds(new Rectangle(15, 293, 270, 19));
        this.add(contapproveTime, null);
        contbaseStatus.setBounds(new Rectangle(15, 157, 270, 19));
        this.add(contbaseStatus, null);
        contcreator.setBounds(new Rectangle(15, 225, 270, 19));
        this.add(contcreator, null);
        contcreateTime.setBounds(new Rectangle(15, 191, 270, 19));
        this.add(contcreateTime, null);
        contcompany.setBounds(new Rectangle(366, 18, 270, 19));
        this.add(contcompany, null);
        contchickenCropPrice.setBounds(new Rectangle(366, 154, 270, 19));
        this.add(contchickenCropPrice, null);
        contchickenMixedOilPrice.setBounds(new Rectangle(366, 188, 270, 19));
        this.add(contchickenMixedOilPrice, null);
        contchickenIntestinesPrice.setBounds(new Rectangle(366, 120, 270, 19));
        this.add(contchickenIntestinesPrice, null);
        contchickenFeatherPrice.setBounds(new Rectangle(366, 86, 270, 19));
        this.add(contchickenFeatherPrice, null);
        contchickenBooldPrice.setBounds(new Rectangle(366, 52, 270, 19));
        this.add(contchickenBooldPrice, null);
        conttonPrice.setBounds(new Rectangle(366, 225, 270, 19));
        this.add(conttonPrice, null);
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
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contchickenCropPrice
        contchickenCropPrice.setBoundEditor(txtchickenCropPrice);
        //contchickenMixedOilPrice
        contchickenMixedOilPrice.setBoundEditor(txtchickenMixedOilPrice);
        //contchickenIntestinesPrice
        contchickenIntestinesPrice.setBoundEditor(txtchickenIntestinesPrice);
        //contchickenFeatherPrice
        contchickenFeatherPrice.setBoundEditor(txtchickenFeatherPrice);
        //contchickenBooldPrice
        contchickenBooldPrice.setBoundEditor(txtchickenBooldPrice);
        //conttonPrice
        conttonPrice.setBoundEditor(txttonPrice);

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
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("chickenCropPrice", java.math.BigDecimal.class, this.txtchickenCropPrice, "value");
		dataBinder.registerBinding("chickenMixedOilPrice", java.math.BigDecimal.class, this.txtchickenMixedOilPrice, "value");
		dataBinder.registerBinding("chickenIntestinesPrice", java.math.BigDecimal.class, this.txtchickenIntestinesPrice, "value");
		dataBinder.registerBinding("chickenFeatherPrice", java.math.BigDecimal.class, this.txtchickenFeatherPrice, "value");
		dataBinder.registerBinding("chickenBooldPrice", java.math.BigDecimal.class, this.txtchickenBooldPrice, "value");
		dataBinder.registerBinding("tonPrice", java.math.BigDecimal.class, this.txttonPrice, "value");		
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
	    return "com.kingdee.eas.custom.szcount.app.ChickenBasicDataEditUIHandler";
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
        this.prmtcompany.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.szcount.ChickenBasicDataInfo)ov;
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
		getValidateHelper().registerBindProperty("approver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("approveTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenCropPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenMixedOilPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenIntestinesPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenFeatherPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenBooldPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("tonPrice", ValidateHelper.ON_SAVE);    		
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
        sic.add(new SelectorItemInfo("chickenCropPrice"));
        sic.add(new SelectorItemInfo("chickenMixedOilPrice"));
        sic.add(new SelectorItemInfo("chickenIntestinesPrice"));
        sic.add(new SelectorItemInfo("chickenFeatherPrice"));
        sic.add(new SelectorItemInfo("chickenBooldPrice"));
        sic.add(new SelectorItemInfo("tonPrice"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.szcount.client", "ChickenBasicDataEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.szcount.client.ChickenBasicDataEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.szcount.ChickenBasicDataFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.szcount.ChickenBasicDataInfo objectValue = new com.kingdee.eas.custom.szcount.ChickenBasicDataInfo();
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