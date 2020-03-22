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
public abstract class AbstractConnectServerEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractConnectServerEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contIP;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contport;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdataBaseName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contuserName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contuserPassword;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contname;
    protected com.kingdee.bos.ctrl.swing.KDButton btnTestConnection;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstatus;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtIP;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtport;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdataBaseName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtuserName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtuserPassword;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtnumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtname;
    protected com.kingdee.bos.ctrl.swing.KDComboBox status;
    protected com.kingdee.eas.custom.salaryvoucher.ConnectServerInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractConnectServerEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractConnectServerEditUI.class.getName());
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
        this.contIP = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contport = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdataBaseName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contuserName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contuserPassword = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contnumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contname = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnTestConnection = new com.kingdee.bos.ctrl.swing.KDButton();
        this.contstatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtIP = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtport = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtdataBaseName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtuserName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtuserPassword = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtnumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtname = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.status = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.contIP.setName("contIP");
        this.contport.setName("contport");
        this.contdataBaseName.setName("contdataBaseName");
        this.contuserName.setName("contuserName");
        this.contuserPassword.setName("contuserPassword");
        this.contnumber.setName("contnumber");
        this.contname.setName("contname");
        this.btnTestConnection.setName("btnTestConnection");
        this.contstatus.setName("contstatus");
        this.txtIP.setName("txtIP");
        this.txtport.setName("txtport");
        this.txtdataBaseName.setName("txtdataBaseName");
        this.txtuserName.setName("txtuserName");
        this.txtuserPassword.setName("txtuserPassword");
        this.txtnumber.setName("txtnumber");
        this.txtname.setName("txtname");
        this.status.setName("status");
        // CoreUI		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);
        // contIP		
        this.contIP.setBoundLabelText(resHelper.getString("contIP.boundLabelText"));		
        this.contIP.setBoundLabelLength(100);		
        this.contIP.setBoundLabelUnderline(true);		
        this.contIP.setVisible(true);
        // contport		
        this.contport.setBoundLabelText(resHelper.getString("contport.boundLabelText"));		
        this.contport.setBoundLabelLength(100);		
        this.contport.setBoundLabelUnderline(true);		
        this.contport.setVisible(true);
        // contdataBaseName		
        this.contdataBaseName.setBoundLabelText(resHelper.getString("contdataBaseName.boundLabelText"));		
        this.contdataBaseName.setBoundLabelLength(100);		
        this.contdataBaseName.setBoundLabelUnderline(true);		
        this.contdataBaseName.setVisible(true);
        // contuserName		
        this.contuserName.setBoundLabelText(resHelper.getString("contuserName.boundLabelText"));		
        this.contuserName.setBoundLabelLength(100);		
        this.contuserName.setBoundLabelUnderline(true);		
        this.contuserName.setVisible(true);
        // contuserPassword		
        this.contuserPassword.setBoundLabelText(resHelper.getString("contuserPassword.boundLabelText"));		
        this.contuserPassword.setBoundLabelLength(100);		
        this.contuserPassword.setBoundLabelUnderline(true);		
        this.contuserPassword.setVisible(true);
        // contnumber		
        this.contnumber.setBoundLabelText(resHelper.getString("contnumber.boundLabelText"));		
        this.contnumber.setBoundLabelLength(100);		
        this.contnumber.setBoundLabelUnderline(true);		
        this.contnumber.setVisible(true);
        // contname		
        this.contname.setBoundLabelText(resHelper.getString("contname.boundLabelText"));		
        this.contname.setBoundLabelLength(100);		
        this.contname.setBoundLabelUnderline(true);		
        this.contname.setVisible(true);
        // btnTestConnection		
        this.btnTestConnection.setText(resHelper.getString("btnTestConnection.text"));
        this.btnTestConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnTestConnection_actionPerforme(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // contstatus		
        this.contstatus.setBoundLabelText(resHelper.getString("contstatus.boundLabelText"));		
        this.contstatus.setBoundLabelLength(100);		
        this.contstatus.setBoundLabelUnderline(true);		
        this.contstatus.setVisible(true);
        // txtIP		
        this.txtIP.setVisible(true);		
        this.txtIP.setHorizontalAlignment(2);		
        this.txtIP.setMaxLength(100);		
        this.txtIP.setRequired(true);
        this.txtIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    txtIP_actionPerforme(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // txtport		
        this.txtport.setVisible(true);		
        this.txtport.setHorizontalAlignment(2);		
        this.txtport.setMaxLength(100);		
        this.txtport.setRequired(true);
        // txtdataBaseName		
        this.txtdataBaseName.setVisible(true);		
        this.txtdataBaseName.setHorizontalAlignment(2);		
        this.txtdataBaseName.setMaxLength(100);		
        this.txtdataBaseName.setRequired(true);
        // txtuserName		
        this.txtuserName.setVisible(true);		
        this.txtuserName.setHorizontalAlignment(2);		
        this.txtuserName.setMaxLength(100);		
        this.txtuserName.setRequired(true);
        // txtuserPassword		
        this.txtuserPassword.setVisible(true);		
        this.txtuserPassword.setHorizontalAlignment(2);		
        this.txtuserPassword.setMaxLength(100);		
        this.txtuserPassword.setRequired(true);
        // txtnumber		
        this.txtnumber.setVisible(true);		
        this.txtnumber.setHorizontalAlignment(2);		
        this.txtnumber.setMaxLength(80);		
        this.txtnumber.setRequired(true);
        // txtname		
        this.txtname.setVisible(true);		
        this.txtname.setHorizontalAlignment(2);		
        this.txtname.setMaxLength(255);		
        this.txtname.setRequired(true);
        // status		
        this.status.setVisible(true);		
        this.status.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.salaryvoucher.voucherStatus").toArray());		
        this.status.setRequired(false);		
        this.status.setEnabled(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtIP,txtport,txtdataBaseName,txtuserName,txtuserPassword,status}));
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
        this.setBounds(new Rectangle(0, 0, 337, 373));
        this.setLayout(null);
        contIP.setBounds(new Rectangle(31, 102, 270, 19));
        this.add(contIP, null);
        contport.setBounds(new Rectangle(31, 143, 270, 19));
        this.add(contport, null);
        contdataBaseName.setBounds(new Rectangle(31, 184, 270, 19));
        this.add(contdataBaseName, null);
        contuserName.setBounds(new Rectangle(31, 225, 270, 19));
        this.add(contuserName, null);
        contuserPassword.setBounds(new Rectangle(31, 268, 270, 19));
        this.add(contuserPassword, null);
        contnumber.setBounds(new Rectangle(31, 61, 270, 19));
        this.add(contnumber, null);
        contname.setBounds(new Rectangle(31, 20, 270, 19));
        this.add(contname, null);
        btnTestConnection.setBounds(new Rectangle(126, 336, 97, 21));
        this.add(btnTestConnection, null);
        contstatus.setBounds(new Rectangle(31, 303, 270, 19));
        this.add(contstatus, null);
        //contIP
        contIP.setBoundEditor(txtIP);
        //contport
        contport.setBoundEditor(txtport);
        //contdataBaseName
        contdataBaseName.setBoundEditor(txtdataBaseName);
        //contuserName
        contuserName.setBoundEditor(txtuserName);
        //contuserPassword
        contuserPassword.setBoundEditor(txtuserPassword);
        //contnumber
        contnumber.setBoundEditor(txtnumber);
        //contname
        contname.setBoundEditor(txtname);
        //contstatus
        contstatus.setBoundEditor(status);

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
		dataBinder.registerBinding("IP", String.class, this.txtIP, "text");
		dataBinder.registerBinding("port", String.class, this.txtport, "text");
		dataBinder.registerBinding("dataBaseName", String.class, this.txtdataBaseName, "text");
		dataBinder.registerBinding("userName", String.class, this.txtuserName, "text");
		dataBinder.registerBinding("userPassword", String.class, this.txtuserPassword, "text");
		dataBinder.registerBinding("number", String.class, this.txtnumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtname, "text");
		dataBinder.registerBinding("status", com.kingdee.eas.custom.salaryvoucher.voucherStatus.class, this.status, "selectedItem");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.salaryvoucher.app.ConnectServerEditUIHandler";
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
        this.txtIP.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.salaryvoucher.ConnectServerInfo)ov;
    }

    /**
     * output loadFields method
     */
    public void loadFields()
    {
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
		getValidateHelper().registerBindProperty("IP", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("port", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dataBaseName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("userName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("userPassword", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("status", ValidateHelper.ON_SAVE);    		
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
     * output btnTestConnection_actionPerforme method
     */
    protected void btnTestConnection_actionPerforme(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output txtIP_actionPerforme method
     */
    protected void txtIP_actionPerforme(java.awt.event.ActionEvent e) throws Exception
    {
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
        sic.add(new SelectorItemInfo("IP"));
        sic.add(new SelectorItemInfo("port"));
        sic.add(new SelectorItemInfo("dataBaseName"));
        sic.add(new SelectorItemInfo("userName"));
        sic.add(new SelectorItemInfo("userPassword"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("status"));
        return sic;
    }        
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.salaryvoucher.ConnectServerFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.salaryvoucher.ConnectServerFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractConnectServerEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractConnectServerEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.salaryvoucher.client", "ConnectServerEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.salaryvoucher.client.ConnectServerEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.salaryvoucher.ConnectServerFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.salaryvoucher.ConnectServerInfo objectValue = new com.kingdee.eas.custom.salaryvoucher.ConnectServerInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtIP.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"IP地址"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtport.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"端口"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtdataBaseName.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"数据库名"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtuserName.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"用户名"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtuserPassword.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"密码"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtnumber.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"编码"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtname.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"名称"});
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
		vo.put("status","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}