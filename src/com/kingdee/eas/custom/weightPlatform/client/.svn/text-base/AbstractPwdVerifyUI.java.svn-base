/**
 * output package name
 */
package com.kingdee.eas.custom.weightPlatform.client;

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
public abstract class AbstractPwdVerifyUI extends com.kingdee.eas.framework.client.CoreUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractPwdVerifyUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel1;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnOK;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnCancel;
    protected com.kingdee.bos.ctrl.swing.KDPasswordField txtPassword;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btn7;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btn8;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btn9;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btn4;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btn5;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btn6;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btn1;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btn2;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btn3;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnBackSpace;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btn0;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnClear;
    /**
     * output class constructor
     */
    public AbstractPwdVerifyUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractPwdVerifyUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabel1 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.btnOK = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnCancel = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.txtPassword = new com.kingdee.bos.ctrl.swing.KDPasswordField();
        this.btn7 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btn8 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btn9 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btn4 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btn5 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btn6 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btn1 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btn2 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btn3 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnBackSpace = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btn0 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnClear = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.kDLabel1.setName("kDLabel1");
        this.btnOK.setName("btnOK");
        this.btnCancel.setName("btnCancel");
        this.txtPassword.setName("txtPassword");
        this.btn7.setName("btn7");
        this.btn8.setName("btn8");
        this.btn9.setName("btn9");
        this.btn4.setName("btn4");
        this.btn5.setName("btn5");
        this.btn6.setName("btn6");
        this.btn1.setName("btn1");
        this.btn2.setName("btn2");
        this.btn3.setName("btn3");
        this.btnBackSpace.setName("btnBackSpace");
        this.btn0.setName("btn0");
        this.btnClear.setName("btnClear");
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
        // kDLabel1		
        this.kDLabel1.setText(resHelper.getString("kDLabel1.text"));		
        this.kDLabel1.setFont(resHelper.getFont("kDLabel1.font"));
        // btnOK		
        this.btnOK.setText(resHelper.getString("btnOK.text"));
        this.btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnOK_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnCancel		
        this.btnCancel.setText(resHelper.getString("btnCancel.text"));
        this.btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnCancel_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // txtPassword		
        this.txtPassword.setFont(resHelper.getFont("txtPassword.font"));
        // btn7		
        this.btn7.setText(resHelper.getString("btn7.text"));
        // btn8		
        this.btn8.setText(resHelper.getString("btn8.text"));
        // btn9		
        this.btn9.setText(resHelper.getString("btn9.text"));
        // btn4		
        this.btn4.setText(resHelper.getString("btn4.text"));
        // btn5		
        this.btn5.setText(resHelper.getString("btn5.text"));
        // btn6		
        this.btn6.setText(resHelper.getString("btn6.text"));
        // btn1		
        this.btn1.setText(resHelper.getString("btn1.text"));
        // btn2		
        this.btn2.setText(resHelper.getString("btn2.text"));
        // btn3		
        this.btn3.setText(resHelper.getString("btn3.text"));
        // btnBackSpace		
        this.btnBackSpace.setText(resHelper.getString("btnBackSpace.text"));
        this.btnBackSpace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnBackSpace_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btn0		
        this.btn0.setText(resHelper.getString("btn0.text"));
        // btnClear		
        this.btnClear.setText(resHelper.getString("btnClear.text"));
        this.btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnClear_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
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
        this.setBounds(new Rectangle(10, 10, 400, 200));
        this.setLayout(null);
        kDLabel1.setBounds(new Rectangle(22, 22, 152, 27));
        this.add(kDLabel1, null);
        btnOK.setBounds(new Rectangle(16, 103, 80, 40));
        this.add(btnOK, null);
        btnCancel.setBounds(new Rectangle(120, 103, 80, 40));
        this.add(btnCancel, null);
        txtPassword.setBounds(new Rectangle(16, 59, 184, 38));
        this.add(txtPassword, null);
        btn7.setBounds(new Rectangle(237, 12, 42, 40));
        this.add(btn7, null);
        btn8.setBounds(new Rectangle(293, 12, 42, 40));
        this.add(btn8, null);
        btn9.setBounds(new Rectangle(344, 12, 42, 40));
        this.add(btn9, null);
        btn4.setBounds(new Rectangle(237, 58, 42, 40));
        this.add(btn4, null);
        btn5.setBounds(new Rectangle(293, 58, 42, 40));
        this.add(btn5, null);
        btn6.setBounds(new Rectangle(344, 58, 42, 40));
        this.add(btn6, null);
        btn1.setBounds(new Rectangle(237, 104, 42, 40));
        this.add(btn1, null);
        btn2.setBounds(new Rectangle(293, 104, 42, 40));
        this.add(btn2, null);
        btn3.setBounds(new Rectangle(344, 104, 42, 40));
        this.add(btn3, null);
        btnBackSpace.setBounds(new Rectangle(261, 150, 72, 40));
        this.add(btnBackSpace, null);
        btn0.setBounds(new Rectangle(344, 150, 42, 40));
        this.add(btn0, null);
        btnClear.setBounds(new Rectangle(184, 150, 67, 40));
        this.add(btnClear, null);

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
	    return "com.kingdee.eas.custom.weightPlatform.app.PwdVerifyUIHandler";
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
     * output btnOK_actionPerformed method
     */
    protected void btnOK_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output btnCancel_actionPerformed method
     */
    protected void btnCancel_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output btnBackSpace_actionPerformed method
     */
    protected void btnBackSpace_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output btnClear_actionPerformed method
     */
    protected void btnClear_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }


    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.weightPlatform.client", "PwdVerifyUI");
    }




}