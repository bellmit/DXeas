/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.recyclebiz.client;

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
public abstract class AbstractCKCloseAccountUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCKCloseAccountUI.class);
    protected com.kingdee.bos.ctrl.swing.KDEditorPane txtInformation;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contPeriodd;
    protected com.kingdee.bos.ctrl.swing.KDButton btnClose;
    protected com.kingdee.bos.ctrl.swing.KDButton btnUnClose;
    protected com.kingdee.bos.ctrl.swing.KDButton btnExit;
    protected com.kingdee.bos.ctrl.swing.KDLabel txtInfo;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator5;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCompany;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtPeriod;
    protected com.kingdee.eas.framework.CoreBaseInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractCKCloseAccountUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCKCloseAccountUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.txtInformation = new com.kingdee.bos.ctrl.swing.KDEditorPane();
        this.contCompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contPeriodd = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnClose = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnUnClose = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnExit = new com.kingdee.bos.ctrl.swing.KDButton();
        this.txtInfo = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDSeparator5 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.prmtCompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtPeriod = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtInformation.setName("txtInformation");
        this.contCompany.setName("contCompany");
        this.contPeriodd.setName("contPeriodd");
        this.btnClose.setName("btnClose");
        this.btnUnClose.setName("btnUnClose");
        this.btnExit.setName("btnExit");
        this.txtInfo.setName("txtInfo");
        this.kDSeparator5.setName("kDSeparator5");
        this.prmtCompany.setName("prmtCompany");
        this.prmtPeriod.setName("prmtPeriod");
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
        // txtInformation
        // contCompany		
        this.contCompany.setBoundLabelText(resHelper.getString("contCompany.boundLabelText"));		
        this.contCompany.setBoundLabelUnderline(true);		
        this.contCompany.setBoundLabelLength(100);
        // contPeriodd		
        this.contPeriodd.setBoundLabelText(resHelper.getString("contPeriodd.boundLabelText"));		
        this.contPeriodd.setBoundLabelUnderline(true);		
        this.contPeriodd.setBoundLabelLength(100);
        // btnClose		
        this.btnClose.setText(resHelper.getString("btnClose.text"));
        this.btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnClose_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnUnClose		
        this.btnUnClose.setText(resHelper.getString("btnUnClose.text"));
        this.btnUnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnUnClose_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnExit		
        this.btnExit.setText(resHelper.getString("btnExit.text"));
        this.btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnExit_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // txtInfo		
        this.txtInfo.setText(resHelper.getString("txtInfo.text"));		
        this.txtInfo.setOpaque(true);		
        this.txtInfo.setForeground(new java.awt.Color(255,0,0));		
        this.txtInfo.setFont(resHelper.getFont("txtInfo.font"));
        // kDSeparator5
        // prmtCompany
        // prmtPeriod
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
        this.setBounds(new Rectangle(10, 10, 1013, 629));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(10, 10, 1013, 629));
        txtInformation.setBounds(new Rectangle(26, 15, 595, 584));
        this.add(txtInformation, new KDLayout.Constraints(26, 15, 595, 584, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCompany.setBounds(new Rectangle(683, 143, 270, 19));
        this.add(contCompany, new KDLayout.Constraints(683, 143, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contPeriodd.setBounds(new Rectangle(683, 196, 270, 19));
        this.add(contPeriodd, new KDLayout.Constraints(683, 196, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        btnClose.setBounds(new Rectangle(733, 257, 187, 32));
        this.add(btnClose, new KDLayout.Constraints(733, 257, 187, 32, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        btnUnClose.setBounds(new Rectangle(733, 323, 187, 32));
        this.add(btnUnClose, new KDLayout.Constraints(733, 323, 187, 32, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        btnExit.setBounds(new Rectangle(733, 391, 187, 32));
        this.add(btnExit, new KDLayout.Constraints(733, 391, 187, 32, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        txtInfo.setBounds(new Rectangle(684, 73, 314, 50));
        this.add(txtInfo, new KDLayout.Constraints(684, 73, 314, 50, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator5.setBounds(new Rectangle(681, 125, 276, 8));
        this.add(kDSeparator5, new KDLayout.Constraints(681, 125, 276, 8, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contCompany
        contCompany.setBoundEditor(prmtCompany);
        //contPeriodd
        contPeriodd.setBoundEditor(prmtPeriod);

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
	    return "com.kingdee.eas.farm.carnivorous.recyclebiz.app.CKCloseAccountUIHandler";
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
     * output btnClose_actionPerformed method
     */
    protected void btnClose_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output btnUnClose_actionPerformed method
     */
    protected void btnUnClose_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output btnExit_actionPerformed method
     */
    protected void btnExit_actionPerformed(java.awt.event.ActionEvent e) throws Exception
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
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.recyclebiz.client", "CKCloseAccountUI");
    }




}