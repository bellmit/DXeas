/**
 * output package name
 */
package com.kingdee.eas.custom.signwasthetable.client;

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
public abstract class AbstractBailDays extends com.kingdee.eas.framework.client.CoreUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractBailDays.class);
    protected com.kingdee.bos.ctrl.swing.KDButton confirm;
    protected com.kingdee.bos.ctrl.swing.KDButton cancel;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kdDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtDays;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker datePicker;
    /**
     * output class constructor
     */
    public AbstractBailDays() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractBailDays.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.confirm = new com.kingdee.bos.ctrl.swing.KDButton();
        this.cancel = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtDays = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.datePicker = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.confirm.setName("confirm");
        this.cancel.setName("cancel");
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kdDate.setName("kdDate");
        this.txtDays.setName("txtDays");
        this.datePicker.setName("datePicker");
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
        // confirm		
        this.confirm.setText(resHelper.getString("confirm.text"));
        this.confirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                try {
                    confirm_mouseClicke(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });
        this.confirm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                try {
                    confirm_keyPresse(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });
        // cancel		
        this.cancel.setText(resHelper.getString("cancel.text"));
        this.cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                try {
                    cancel_mouseClicke(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });
        this.cancel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                try {
                    cancel_keyPresse(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);		
        this.kDLabelContainer1.setVisible(true);
        // kdDate		
        this.kdDate.setBoundLabelText(resHelper.getString("kdDate.boundLabelText"));		
        this.kdDate.setBoundLabelLength(100);		
        this.kdDate.setBoundLabelUnderline(true);		
        this.kdDate.setVisible(true);
        // txtDays		
        this.txtDays.setVisible(true);		
        this.txtDays.setHorizontalAlignment(2);		
        this.txtDays.setDataType(0);		
        this.txtDays.setSupportedEmpty(true);		
        this.txtDays.setRequired(false);
        // datePicker		
        this.datePicker.setVisible(true);		
        this.datePicker.setRequired(false);
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
        this.setBounds(new Rectangle(10, 10, 400, 220));
        this.setLayout(null);
        confirm.setBounds(new Rectangle(44, 137, 73, 28));
        this.add(confirm, null);
        cancel.setBounds(new Rectangle(273, 137, 73, 29));
        this.add(cancel, null);
        kDLabelContainer1.setBounds(new Rectangle(43, 82, 303, 19));
        this.add(kDLabelContainer1, null);
        kdDate.setBounds(new Rectangle(44, 36, 302, 19));
        this.add(kdDate, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtDays);
        //kdDate
        kdDate.setBoundEditor(datePicker);

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
	    return "com.kingdee.eas.custom.signwasthetable.app.BailDaysHandler";
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
     * output confirm_mouseClicke method
     */
    protected void confirm_mouseClicke(java.awt.event.MouseEvent e) throws Exception
    {
    }

    /**
     * output confirm_keyPresse method
     */
    protected void confirm_keyPresse(java.awt.event.KeyEvent e) throws Exception
    {
    }

    /**
     * output cancel_mouseClicke method
     */
    protected void cancel_mouseClicke(java.awt.event.MouseEvent e) throws Exception
    {
    }

    /**
     * output cancel_keyPresse method
     */
    protected void cancel_keyPresse(java.awt.event.KeyEvent e) throws Exception
    {
    }


    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.signwasthetable.client", "BailDays");
    }




}