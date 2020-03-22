/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata.client;

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
public abstract class AbstractFarmerModifyUI extends com.kingdee.eas.framework.client.CoreUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractFarmerModifyUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer dynamicFieldContainer;
    protected com.kingdee.bos.ctrl.swing.KDButton kDButton1;
    protected com.kingdee.bos.ctrl.swing.KDButton kDButton2;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator2;
    protected com.kingdee.bos.ctrl.swing.KDComboBox listField;
    protected com.kingdee.bos.ctrl.swing.KDTextField kDTextField1;
    protected ActionListChanged actionListChanged = null;
    protected ActionForcedLoad actionForcedLoad = null;
    /**
     * output class constructor
     */
    public AbstractFarmerModifyUI() throws Exception
    {
        super();
        jbInit();
        
        initUIP();
    }

    /**
     * output jbInit method
     */
    private void jbInit() throws Exception
    {
        this.resHelper = new ResourceBundleHelper(AbstractFarmerModifyUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        //actionListChanged
        this.actionListChanged = new ActionListChanged(this);
        getActionManager().registerAction("actionListChanged", actionListChanged);
         this.actionListChanged.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionForcedLoad
        this.actionForcedLoad = new ActionForcedLoad(this);
        getActionManager().registerAction("actionForcedLoad", actionForcedLoad);
         this.actionForcedLoad.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.dynamicFieldContainer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDButton1 = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kDButton2 = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kDSeparator2 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.listField = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.kDTextField1 = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.dynamicFieldContainer.setName("dynamicFieldContainer");
        this.kDButton1.setName("kDButton1");
        this.kDButton2.setName("kDButton2");
        this.kDSeparator2.setName("kDSeparator2");
        this.listField.setName("listField");
        this.kDTextField1.setName("kDTextField1");
        // CoreUI
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);
        // dynamicFieldContainer		
        this.dynamicFieldContainer.setBoundLabelText(resHelper.getString("dynamicFieldContainer.boundLabelText"));		
        this.dynamicFieldContainer.setBoundLabelLength(100);		
        this.dynamicFieldContainer.setBoundLabelUnderline(true);
        // kDButton1		
        this.kDButton1.setText(resHelper.getString("kDButton1.text"));
        this.kDButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    cmdOK_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // kDButton2		
        this.kDButton2.setText(resHelper.getString("kDButton2.text"));
        this.kDButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    cmdCancel_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // kDSeparator2
        // listField
        this.listField.setAction((IItemAction)ActionProxyFactory.getProxy(actionListChanged, new Class[] { IItemAction.class }, getServiceContext()));
        // kDTextField1
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
        this.setBounds(new Rectangle(10, 10, 320, 250));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(10, 60, 300, 19));
        this.add(kDLabelContainer1, null);
        dynamicFieldContainer.setBounds(new Rectangle(10, 101, 300, 19));
        this.add(dynamicFieldContainer, null);
        kDButton1.setBounds(new Rectangle(69, 216, 73, 21));
        this.add(kDButton1, null);
        kDButton2.setBounds(new Rectangle(168, 216, 73, 21));
        this.add(kDButton2, null);
        kDSeparator2.setBounds(new Rectangle(-2, 206, 334, 10));
        this.add(kDSeparator2, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(listField);
        //dynamicFieldContainer
        dynamicFieldContainer.setBoundEditor(kDTextField1);

    }


    /**
     * output initUIMenuBarLayout method
     */
    public void initUIMenuBarLayout()
    {
        this.menuBar.add(menuFile);
        this.menuBar.add(menuTool);
        this.menuBar.add(MenuService);
        this.menuBar.add(menuHelp);
        //menuFile
        menuFile.add(menuItemPageSetup);
        menuFile.add(kDSeparator1);
        menuFile.add(menuItemCloudFeed);
        menuFile.add(menuItemCloudScreen);
        menuFile.add(menuItemCloudShare);
        menuFile.add(kdSeparatorFWFile1);
        menuFile.add(menuItemExitCurrent);
        //menuTool
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemCalculator);
        menuTool.add(menuItemToolBarCustom);
        //MenuService
        MenuService.add(MenuItemKnowStore);
        MenuService.add(MenuItemAnwser);
        MenuService.add(SepratorService);
        MenuService.add(MenuItemRemoteAssist);
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
        this.toolBar.add(btnPageSetup);
        this.toolBar.add(btnCloud);
        this.toolBar.add(btnXunTong);
        this.toolBar.add(kDSeparatorCloud);


    }

	//Regiester control's property binding.
	private void registerBindings(){		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.carnivorous.basedata.app.FarmerModifyUIHandler";
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
    }

    /**
     * output cmdOK_actionPerformed method
     */
    protected void cmdOK_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output cmdCancel_actionPerformed method
     */
    protected void cmdCancel_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    	

    /**
     * output actionListChanged_actionPerformed method
     */
    public void actionListChanged_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionForcedLoad_actionPerformed method
     */
    public void actionForcedLoad_actionPerformed(ActionEvent e) throws Exception
    {
    }
	public RequestContext prepareActionListChanged(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionListChanged() {
    	return false;
    }
	public RequestContext prepareActionForcedLoad(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionForcedLoad() {
    	return false;
    }

    /**
     * output ActionListChanged class
     */     
    protected class ActionListChanged extends ItemAction {     
    
        public ActionListChanged()
        {
            this(null);
        }

        public ActionListChanged(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionListChanged.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionListChanged.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionListChanged.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractFarmerModifyUI.this, "ActionListChanged", "actionListChanged_actionPerformed", e);
        }
    }

    /**
     * output ActionForcedLoad class
     */     
    protected class ActionForcedLoad extends ItemAction {     
    
        public ActionForcedLoad()
        {
            this(null);
        }

        public ActionForcedLoad(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("ActionForcedLoad.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionForcedLoad.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionForcedLoad.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractFarmerModifyUI.this, "ActionForcedLoad", "actionForcedLoad_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.basedata.client", "FarmerModifyUI");
    }




}