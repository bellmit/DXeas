/**
 * output package name
 */
package com.kingdee.eas.farm.hatch.client;

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
public abstract class AbstractCountUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCountUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCar;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contFloor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contPlate;
    protected com.kingdee.bos.ctrl.swing.KDButton btnConfirm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contMei;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtCar;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtFloor;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtPlate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtMei;
    protected com.kingdee.eas.framework.CoreBaseInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractCountUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCountUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.contCar = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contFloor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contPlate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnConfirm = new com.kingdee.bos.ctrl.swing.KDButton();
        this.contMei = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtCar = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtFloor = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtPlate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtMei = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contCar.setName("contCar");
        this.contFloor.setName("contFloor");
        this.contPlate.setName("contPlate");
        this.btnConfirm.setName("btnConfirm");
        this.contMei.setName("contMei");
        this.txtCar.setName("txtCar");
        this.txtFloor.setName("txtFloor");
        this.txtPlate.setName("txtPlate");
        this.txtMei.setName("txtMei");
        // CoreUI		
        this.btnPageSetup.setVisible(false);		
        this.btnCloud.setVisible(false);		
        this.btnXunTong.setVisible(false);		
        this.kDSeparatorCloud.setVisible(false);		
        this.menuItemPageSetup.setVisible(false);		
        this.menuItemCloudFeed.setVisible(false);		
        this.menuItemCloudScreen.setEnabled(false);		
        this.menuItemCloudScreen.setVisible(false);		
        this.menuItemCloudShare.setVisible(false);		
        this.kdSeparatorFWFile1.setVisible(false);		
        this.kDSeparator2.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);		
        this.kDSeparator4.setVisible(false);		
        this.kDSeparator4.setEnabled(false);		
        this.rMenuItemSubmit.setVisible(false);		
        this.rMenuItemSubmit.setEnabled(false);		
        this.rMenuItemSubmitAndAddNew.setVisible(false);		
        this.rMenuItemSubmitAndAddNew.setEnabled(false);		
        this.rMenuItemSubmitAndPrint.setVisible(false);		
        this.rMenuItemSubmitAndPrint.setEnabled(false);		
        this.btnReset.setEnabled(false);		
        this.btnReset.setVisible(false);		
        this.menuItemReset.setEnabled(false);		
        this.menuItemReset.setVisible(false);
        // contCar		
        this.contCar.setBoundLabelText(resHelper.getString("contCar.boundLabelText"));		
        this.contCar.setBoundLabelLength(100);		
        this.contCar.setBoundLabelUnderline(true);		
        this.contCar.setVisible(true);
        // contFloor		
        this.contFloor.setBoundLabelText(resHelper.getString("contFloor.boundLabelText"));		
        this.contFloor.setBoundLabelLength(100);		
        this.contFloor.setBoundLabelUnderline(true);		
        this.contFloor.setVisible(true);
        // contPlate		
        this.contPlate.setBoundLabelText(resHelper.getString("contPlate.boundLabelText"));		
        this.contPlate.setBoundLabelLength(100);		
        this.contPlate.setBoundLabelUnderline(true);		
        this.contPlate.setVisible(true);
        // btnConfirm		
        this.btnConfirm.setText(resHelper.getString("btnConfirm.text"));
        // contMei		
        this.contMei.setBoundLabelText(resHelper.getString("contMei.boundLabelText"));		
        this.contMei.setBoundLabelLength(100);		
        this.contMei.setBoundLabelUnderline(true);		
        this.contMei.setVisible(true);
        // txtCar		
        this.txtCar.setHorizontalAlignment(2);		
        this.txtCar.setDataType(0);		
        this.txtCar.setSupportedEmpty(true);		
        this.txtCar.setRequired(false);
        // txtFloor		
        this.txtFloor.setHorizontalAlignment(2);		
        this.txtFloor.setDataType(0);		
        this.txtFloor.setSupportedEmpty(true);		
        this.txtFloor.setRequired(false);
        // txtPlate		
        this.txtPlate.setHorizontalAlignment(2);		
        this.txtPlate.setDataType(0);		
        this.txtPlate.setSupportedEmpty(true);		
        this.txtPlate.setRequired(false);
        // txtMei		
        this.txtMei.setHorizontalAlignment(2);		
        this.txtMei.setDataType(0);		
        this.txtMei.setSupportedEmpty(true);		
        this.txtMei.setRequired(false);
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
        this.setBounds(new Rectangle(10, 10, 300, 240));
        this.setLayout(null);
        contCar.setBounds(new Rectangle(17, 22, 270, 19));
        this.add(contCar, null);
        contFloor.setBounds(new Rectangle(17, 57, 270, 19));
        this.add(contFloor, null);
        contPlate.setBounds(new Rectangle(17, 100, 270, 19));
        this.add(contPlate, null);
        btnConfirm.setBounds(new Rectangle(173, 178, 114, 31));
        this.add(btnConfirm, null);
        contMei.setBounds(new Rectangle(17, 142, 270, 19));
        this.add(contMei, null);
        //contCar
        contCar.setBoundEditor(txtCar);
        //contFloor
        contFloor.setBoundEditor(txtFloor);
        //contPlate
        contPlate.setBoundEditor(txtPlate);
        //contMei
        contMei.setBoundEditor(txtMei);

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
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.hatch.app.CountUIHandler";
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
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.framework.CoreBaseInfo)ov;
    }

    /**
     * output loadFields method
     */
    public void loadFields()
    {
        dataBinder.loadFields();
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
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
        if (STATUS_ADDNEW.equals(this.oprtState)) {
        } else if (STATUS_EDIT.equals(this.oprtState)) {
        } else if (STATUS_VIEW.equals(this.oprtState)) {
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
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.hatch.client", "CountUI");
    }




}