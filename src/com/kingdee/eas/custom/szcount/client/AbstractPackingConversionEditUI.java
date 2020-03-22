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
public abstract class AbstractPackingConversionEditUI extends com.kingdee.eas.custom.wlhllicensemanager.client.WlhlBaseEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractPackingConversionEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmaterialProduct;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contproductNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmaterialPacking;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpackingNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contproductModel;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpackingModel;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpackingtoProduct;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmaterialPacking2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmaterialPackingN;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontpackingtoProduct2;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtmaterialProduct;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtproductNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtmaterialPacking;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpackingNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtproductModel;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpackingModel;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpackingtoProduct;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtmaterialPacking2;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtmaterialPackingN;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcontpackingtoProduct2;
    protected com.kingdee.eas.custom.szcount.PackingConversionInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractPackingConversionEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractPackingConversionEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.contmaterialProduct = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contproductNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmaterialPacking = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpackingNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contproductModel = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpackingModel = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpackingtoProduct = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmaterialPacking2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmaterialPackingN = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcontpackingtoProduct2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtmaterialProduct = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtproductNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtmaterialPacking = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtpackingNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtproductModel = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtpackingModel = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtpackingtoProduct = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtmaterialPacking2 = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtmaterialPackingN = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcontpackingtoProduct2 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contmaterialProduct.setName("contmaterialProduct");
        this.contproductNumber.setName("contproductNumber");
        this.contmaterialPacking.setName("contmaterialPacking");
        this.contpackingNumber.setName("contpackingNumber");
        this.contproductModel.setName("contproductModel");
        this.contpackingModel.setName("contpackingModel");
        this.contpackingtoProduct.setName("contpackingtoProduct");
        this.contmaterialPacking2.setName("contmaterialPacking2");
        this.contmaterialPackingN.setName("contmaterialPackingN");
        this.contcontpackingtoProduct2.setName("contcontpackingtoProduct2");
        this.prmtmaterialProduct.setName("prmtmaterialProduct");
        this.txtproductNumber.setName("txtproductNumber");
        this.prmtmaterialPacking.setName("prmtmaterialPacking");
        this.txtpackingNumber.setName("txtpackingNumber");
        this.txtproductModel.setName("txtproductModel");
        this.txtpackingModel.setName("txtpackingModel");
        this.txtpackingtoProduct.setName("txtpackingtoProduct");
        this.prmtmaterialPacking2.setName("prmtmaterialPacking2");
        this.txtmaterialPackingN.setName("txtmaterialPackingN");
        this.txtcontpackingtoProduct2.setName("txtcontpackingtoProduct2");
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
        this.txtSimpleName.setEnabled(false);		
        this.txtDescription.setEnabled(false);		
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
        // contmaterialProduct		
        this.contmaterialProduct.setBoundLabelText(resHelper.getString("contmaterialProduct.boundLabelText"));		
        this.contmaterialProduct.setBoundLabelLength(100);		
        this.contmaterialProduct.setBoundLabelUnderline(true);		
        this.contmaterialProduct.setVisible(true);
        // contproductNumber		
        this.contproductNumber.setBoundLabelText(resHelper.getString("contproductNumber.boundLabelText"));		
        this.contproductNumber.setBoundLabelLength(100);		
        this.contproductNumber.setBoundLabelUnderline(true);		
        this.contproductNumber.setVisible(true);
        // contmaterialPacking		
        this.contmaterialPacking.setBoundLabelText(resHelper.getString("contmaterialPacking.boundLabelText"));		
        this.contmaterialPacking.setBoundLabelLength(100);		
        this.contmaterialPacking.setBoundLabelUnderline(true);		
        this.contmaterialPacking.setVisible(true);
        // contpackingNumber		
        this.contpackingNumber.setBoundLabelText(resHelper.getString("contpackingNumber.boundLabelText"));		
        this.contpackingNumber.setBoundLabelLength(100);		
        this.contpackingNumber.setBoundLabelUnderline(true);		
        this.contpackingNumber.setVisible(true);
        // contproductModel		
        this.contproductModel.setBoundLabelText(resHelper.getString("contproductModel.boundLabelText"));		
        this.contproductModel.setBoundLabelLength(100);		
        this.contproductModel.setBoundLabelUnderline(true);		
        this.contproductModel.setVisible(true);
        // contpackingModel		
        this.contpackingModel.setBoundLabelText(resHelper.getString("contpackingModel.boundLabelText"));		
        this.contpackingModel.setBoundLabelLength(100);		
        this.contpackingModel.setBoundLabelUnderline(true);		
        this.contpackingModel.setVisible(true);
        // contpackingtoProduct		
        this.contpackingtoProduct.setBoundLabelText(resHelper.getString("contpackingtoProduct.boundLabelText"));		
        this.contpackingtoProduct.setBoundLabelLength(180);		
        this.contpackingtoProduct.setBoundLabelUnderline(true);		
        this.contpackingtoProduct.setVisible(true);
        // contmaterialPacking2		
        this.contmaterialPacking2.setBoundLabelText(resHelper.getString("contmaterialPacking2.boundLabelText"));		
        this.contmaterialPacking2.setBoundLabelLength(100);		
        this.contmaterialPacking2.setBoundLabelUnderline(true);		
        this.contmaterialPacking2.setVisible(true);
        // contmaterialPackingN		
        this.contmaterialPackingN.setBoundLabelText(resHelper.getString("contmaterialPackingN.boundLabelText"));		
        this.contmaterialPackingN.setBoundLabelLength(100);		
        this.contmaterialPackingN.setBoundLabelUnderline(true);		
        this.contmaterialPackingN.setVisible(true);
        // contcontpackingtoProduct2		
        this.contcontpackingtoProduct2.setBoundLabelText(resHelper.getString("contcontpackingtoProduct2.boundLabelText"));		
        this.contcontpackingtoProduct2.setBoundLabelLength(180);		
        this.contcontpackingtoProduct2.setBoundLabelUnderline(true);		
        this.contcontpackingtoProduct2.setVisible(true);
        // prmtmaterialProduct		
        this.prmtmaterialProduct.setQueryInfo("com.kingdee.eas.basedata.master.material.app.MaterialQuery");		
        this.prmtmaterialProduct.setVisible(true);		
        this.prmtmaterialProduct.setEditable(true);		
        this.prmtmaterialProduct.setDisplayFormat("$name$");		
        this.prmtmaterialProduct.setEditFormat("$number$");		
        this.prmtmaterialProduct.setCommitFormat("$number$");		
        this.prmtmaterialProduct.setRequired(false);
        prmtmaterialProduct.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtmaterialProduct_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtproductNumber		
        this.txtproductNumber.setVisible(true);		
        this.txtproductNumber.setHorizontalAlignment(2);		
        this.txtproductNumber.setMaxLength(80);		
        this.txtproductNumber.setRequired(false);
        // prmtmaterialPacking		
        this.prmtmaterialPacking.setQueryInfo("com.kingdee.eas.basedata.master.material.app.MaterialQuery");		
        this.prmtmaterialPacking.setVisible(true);		
        this.prmtmaterialPacking.setEditable(true);		
        this.prmtmaterialPacking.setDisplayFormat("$name$");		
        this.prmtmaterialPacking.setEditFormat("$number$");		
        this.prmtmaterialPacking.setCommitFormat("$number$");		
        this.prmtmaterialPacking.setRequired(false);
        prmtmaterialPacking.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtmaterialPacking_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtpackingNumber		
        this.txtpackingNumber.setVisible(true);		
        this.txtpackingNumber.setHorizontalAlignment(2);		
        this.txtpackingNumber.setMaxLength(80);		
        this.txtpackingNumber.setRequired(false);
        // txtproductModel		
        this.txtproductModel.setVisible(true);		
        this.txtproductModel.setHorizontalAlignment(2);		
        this.txtproductModel.setMaxLength(80);		
        this.txtproductModel.setRequired(false);
        // txtpackingModel		
        this.txtpackingModel.setVisible(true);		
        this.txtpackingModel.setHorizontalAlignment(2);		
        this.txtpackingModel.setMaxLength(80);		
        this.txtpackingModel.setRequired(false);
        // txtpackingtoProduct		
        this.txtpackingtoProduct.setVisible(true);		
        this.txtpackingtoProduct.setHorizontalAlignment(2);		
        this.txtpackingtoProduct.setDataType(1);		
        this.txtpackingtoProduct.setSupportedEmpty(true);		
        this.txtpackingtoProduct.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpackingtoProduct.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpackingtoProduct.setPrecision(4);		
        this.txtpackingtoProduct.setRequired(false);
        // prmtmaterialPacking2		
        this.prmtmaterialPacking2.setQueryInfo("com.kingdee.eas.basedata.master.material.app.MaterialQuery");		
        this.prmtmaterialPacking2.setVisible(true);		
        this.prmtmaterialPacking2.setEditable(true);		
        this.prmtmaterialPacking2.setDisplayFormat("$name$");		
        this.prmtmaterialPacking2.setEditFormat("$number$");		
        this.prmtmaterialPacking2.setCommitFormat("$number$");		
        this.prmtmaterialPacking2.setRequired(false);
        prmtmaterialPacking2.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtmaterialPacking2_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtmaterialPackingN		
        this.txtmaterialPackingN.setVisible(true);		
        this.txtmaterialPackingN.setHorizontalAlignment(2);		
        this.txtmaterialPackingN.setMaxLength(80);		
        this.txtmaterialPackingN.setRequired(false);
        // txtcontpackingtoProduct2		
        this.txtcontpackingtoProduct2.setVisible(true);		
        this.txtcontpackingtoProduct2.setHorizontalAlignment(2);		
        this.txtcontpackingtoProduct2.setDataType(1);		
        this.txtcontpackingtoProduct2.setSupportedEmpty(true);		
        this.txtcontpackingtoProduct2.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcontpackingtoProduct2.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcontpackingtoProduct2.setPrecision(4);		
        this.txtcontpackingtoProduct2.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtmaterialProduct,txtproductNumber,prmtmaterialPacking,txtpackingNumber,txtproductModel,txtpackingModel,txtpackingtoProduct,prmtmaterialPacking2,txtmaterialPackingN,txtcontpackingtoProduct2}));
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
        this.setBounds(new Rectangle(0, 0, 658, 341));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(20, 18, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(360, 18, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(579, 61, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(580, 44, 270, 19));
        this.add(kDLabelContainer4, null);
        contapprover.setBounds(new Rectangle(360, 263, 270, 19));
        this.add(contapprover, null);
        contapproveTime.setBounds(new Rectangle(360, 297, 270, 19));
        this.add(contapproveTime, null);
        contbaseStatus.setBounds(new Rectangle(20, 53, 270, 19));
        this.add(contbaseStatus, null);
        contcreator.setBounds(new Rectangle(20, 263, 270, 19));
        this.add(contcreator, null);
        contcreateTime.setBounds(new Rectangle(20, 297, 270, 19));
        this.add(contcreateTime, null);
        contmaterialProduct.setBounds(new Rectangle(20, 88, 270, 19));
        this.add(contmaterialProduct, null);
        contproductNumber.setBounds(new Rectangle(360, 88, 270, 19));
        this.add(contproductNumber, null);
        contmaterialPacking.setBounds(new Rectangle(20, 158, 270, 19));
        this.add(contmaterialPacking, null);
        contpackingNumber.setBounds(new Rectangle(359, 122, 270, 19));
        this.add(contpackingNumber, null);
        contproductModel.setBounds(new Rectangle(20, 123, 270, 19));
        this.add(contproductModel, null);
        contpackingModel.setBounds(new Rectangle(20, 193, 270, 19));
        this.add(contpackingModel, null);
        contpackingtoProduct.setBounds(new Rectangle(20, 228, 270, 19));
        this.add(contpackingtoProduct, null);
        contmaterialPacking2.setBounds(new Rectangle(360, 157, 270, 19));
        this.add(contmaterialPacking2, null);
        contmaterialPackingN.setBounds(new Rectangle(359, 192, 270, 19));
        this.add(contmaterialPackingN, null);
        contcontpackingtoProduct2.setBounds(new Rectangle(360, 228, 270, 19));
        this.add(contcontpackingtoProduct2, null);
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
        //contmaterialProduct
        contmaterialProduct.setBoundEditor(prmtmaterialProduct);
        //contproductNumber
        contproductNumber.setBoundEditor(txtproductNumber);
        //contmaterialPacking
        contmaterialPacking.setBoundEditor(prmtmaterialPacking);
        //contpackingNumber
        contpackingNumber.setBoundEditor(txtpackingNumber);
        //contproductModel
        contproductModel.setBoundEditor(txtproductModel);
        //contpackingModel
        contpackingModel.setBoundEditor(txtpackingModel);
        //contpackingtoProduct
        contpackingtoProduct.setBoundEditor(txtpackingtoProduct);
        //contmaterialPacking2
        contmaterialPacking2.setBoundEditor(prmtmaterialPacking2);
        //contmaterialPackingN
        contmaterialPackingN.setBoundEditor(txtmaterialPackingN);
        //contcontpackingtoProduct2
        contcontpackingtoProduct2.setBoundEditor(txtcontpackingtoProduct2);

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
		dataBinder.registerBinding("materialProduct", com.kingdee.eas.basedata.master.material.MaterialInfo.class, this.prmtmaterialProduct, "data");
		dataBinder.registerBinding("productNumber", String.class, this.txtproductNumber, "text");
		dataBinder.registerBinding("materialPacking", com.kingdee.eas.basedata.master.material.MaterialInfo.class, this.prmtmaterialPacking, "data");
		dataBinder.registerBinding("packingNumber", String.class, this.txtpackingNumber, "text");
		dataBinder.registerBinding("productModel", String.class, this.txtproductModel, "text");
		dataBinder.registerBinding("packingModel", String.class, this.txtpackingModel, "text");
		dataBinder.registerBinding("packingtoProduct", java.math.BigDecimal.class, this.txtpackingtoProduct, "value");
		dataBinder.registerBinding("materialPacking2", com.kingdee.eas.basedata.master.material.MaterialInfo.class, this.prmtmaterialPacking2, "data");
		dataBinder.registerBinding("materialPackingN", String.class, this.txtmaterialPackingN, "text");
		dataBinder.registerBinding("contpackingtoProduct2", java.math.BigDecimal.class, this.txtcontpackingtoProduct2, "value");		
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
	    return "com.kingdee.eas.custom.szcount.app.PackingConversionEditUIHandler";
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
        this.prmtmaterialProduct.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.szcount.PackingConversionInfo)ov;
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
		getValidateHelper().registerBindProperty("materialProduct", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("productNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("materialPacking", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("packingNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("productModel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("packingModel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("packingtoProduct", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("materialPacking2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("materialPackingN", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contpackingtoProduct2", ValidateHelper.ON_SAVE);    		
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
     * output prmtmaterialProduct_Changed() method
     */
    public void prmtmaterialProduct_Changed() throws Exception
    {
        System.out.println("prmtmaterialProduct_Changed() Function is executed!");
            txtproductNumber.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtmaterialProduct.getData(),"number")));

    txtproductModel.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtmaterialProduct.getData(),"model")));


    }

    /**
     * output prmtmaterialPacking_Changed() method
     */
    public void prmtmaterialPacking_Changed() throws Exception
    {
        System.out.println("prmtmaterialPacking_Changed() Function is executed!");
            txtpackingModel.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtmaterialPacking.getData(),"model")));

    txtpackingNumber.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtmaterialPacking.getData(),"number")));


    }

    /**
     * output prmtmaterialPacking2_Changed() method
     */
    public void prmtmaterialPacking2_Changed() throws Exception
    {
        System.out.println("prmtmaterialPacking2_Changed() Function is executed!");
            txtmaterialPackingN.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtmaterialPacking2.getData(),"number")));


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
			sic.add(new SelectorItemInfo("materialProduct.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("materialProduct.id"));
        	sic.add(new SelectorItemInfo("materialProduct.number"));
        	sic.add(new SelectorItemInfo("materialProduct.name"));
		}
        sic.add(new SelectorItemInfo("productNumber"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("materialPacking.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("materialPacking.id"));
        	sic.add(new SelectorItemInfo("materialPacking.number"));
        	sic.add(new SelectorItemInfo("materialPacking.name"));
		}
        sic.add(new SelectorItemInfo("packingNumber"));
        sic.add(new SelectorItemInfo("productModel"));
        sic.add(new SelectorItemInfo("packingModel"));
        sic.add(new SelectorItemInfo("packingtoProduct"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("materialPacking2.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("materialPacking2.id"));
        	sic.add(new SelectorItemInfo("materialPacking2.number"));
        	sic.add(new SelectorItemInfo("materialPacking2.name"));
		}
        sic.add(new SelectorItemInfo("materialPackingN"));
        sic.add(new SelectorItemInfo("contpackingtoProduct2"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.szcount.client", "PackingConversionEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.szcount.client.PackingConversionEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.szcount.PackingConversionFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.szcount.PackingConversionInfo objectValue = new com.kingdee.eas.custom.szcount.PackingConversionInfo();
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