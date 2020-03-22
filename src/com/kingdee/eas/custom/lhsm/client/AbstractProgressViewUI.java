/**
 * output package name
 */
package com.kingdee.eas.custom.lhsm.client;

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
public abstract class AbstractProgressViewUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractProgressViewUI.class);
    protected com.kingdee.bos.ctrl.swing.KDProgressBar kDPbTotal;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel1;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel2;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel3;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel4;
    protected com.kingdee.bos.ctrl.swing.KDProgressBar kDPbSF;
    protected com.kingdee.bos.ctrl.swing.KDProgressBar kDPbSO;
    protected com.kingdee.bos.ctrl.swing.KDProgressBar kDPbIssue;
    protected com.kingdee.bos.ctrl.swing.KDProgressBar kDPbAR;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel5;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel6;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel7;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel8;
    protected com.kingdee.eas.framework.CoreBaseInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractProgressViewUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractProgressViewUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDPbTotal = new com.kingdee.bos.ctrl.swing.KDProgressBar();
        this.kDLabel1 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDLabel2 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDLabel3 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDLabel4 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDPbSF = new com.kingdee.bos.ctrl.swing.KDProgressBar();
        this.kDPbSO = new com.kingdee.bos.ctrl.swing.KDProgressBar();
        this.kDPbIssue = new com.kingdee.bos.ctrl.swing.KDProgressBar();
        this.kDPbAR = new com.kingdee.bos.ctrl.swing.KDProgressBar();
        this.kDLabel5 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDLabel6 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDLabel7 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDLabel8 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDPbTotal.setName("kDPbTotal");
        this.kDLabel1.setName("kDLabel1");
        this.kDLabel2.setName("kDLabel2");
        this.kDLabel3.setName("kDLabel3");
        this.kDLabel4.setName("kDLabel4");
        this.kDPbSF.setName("kDPbSF");
        this.kDPbSO.setName("kDPbSO");
        this.kDPbIssue.setName("kDPbIssue");
        this.kDPbAR.setName("kDPbAR");
        this.kDLabel5.setName("kDLabel5");
        this.kDLabel6.setName("kDLabel6");
        this.kDLabel7.setName("kDLabel7");
        this.kDLabel8.setName("kDLabel8");
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
        // kDPbTotal
        // kDLabel1		
        this.kDLabel1.setText(resHelper.getString("kDLabel1.text"));
        // kDLabel2		
        this.kDLabel2.setText(resHelper.getString("kDLabel2.text"));
        // kDLabel3		
        this.kDLabel3.setText(resHelper.getString("kDLabel3.text"));
        // kDLabel4		
        this.kDLabel4.setText(resHelper.getString("kDLabel4.text"));
        // kDPbSF
        // kDPbSO
        // kDPbIssue
        // kDPbAR
        // kDLabel5		
        this.kDLabel5.setText(resHelper.getString("kDLabel5.text"));
        // kDLabel6		
        this.kDLabel6.setText(resHelper.getString("kDLabel6.text"));
        // kDLabel7		
        this.kDLabel7.setText(resHelper.getString("kDLabel7.text"));
        // kDLabel8		
        this.kDLabel8.setText(resHelper.getString("kDLabel8.text"));
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
        this.setBounds(new Rectangle(10, 10, 500, 400));
        this.setLayout(null);
        kDPbTotal.setBounds(new Rectangle(33, 61, 413, 21));
        this.add(kDPbTotal, null);
        kDLabel1.setBounds(new Rectangle(33, 114, 60, 19));
        this.add(kDLabel1, null);
        kDLabel2.setBounds(new Rectangle(33, 165, 60, 19));
        this.add(kDLabel2, null);
        kDLabel3.setBounds(new Rectangle(33, 216, 60, 19));
        this.add(kDLabel3, null);
        kDLabel4.setBounds(new Rectangle(33, 269, 60, 19));
        this.add(kDLabel4, null);
        kDPbSF.setBounds(new Rectangle(99, 114, 291, 21));
        this.add(kDPbSF, null);
        kDPbSO.setBounds(new Rectangle(99, 165, 291, 21));
        this.add(kDPbSO, null);
        kDPbIssue.setBounds(new Rectangle(99, 216, 291, 21));
        this.add(kDPbIssue, null);
        kDPbAR.setBounds(new Rectangle(99, 269, 291, 21));
        this.add(kDPbAR, null);
        kDLabel5.setBounds(new Rectangle(399, 114, 100, 19));
        this.add(kDLabel5, null);
        kDLabel6.setBounds(new Rectangle(399, 165, 100, 19));
        this.add(kDLabel6, null);
        kDLabel7.setBounds(new Rectangle(399, 216, 100, 19));
        this.add(kDLabel7, null);
        kDLabel8.setBounds(new Rectangle(399, 269, 100, 19));
        this.add(kDLabel8, null);

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
	    return "com.kingdee.eas.custom.lhsm.app.ProgressViewUIHandler";
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
        return new MetaDataPK("com.kingdee.eas.custom.lhsm.client", "ProgressViewUI");
    }




}