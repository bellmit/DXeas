/**
 * output package name
 */
package com.kingdee.eas.custom.tocloud.client;

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
public abstract class AbstractDataSynPlateformUI extends com.kingdee.eas.framework.client.CoreUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractDataSynPlateformUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainerTargetSystem;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainerBizType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainerCompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainerDateS;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainerDateE;
    protected com.kingdee.bos.ctrl.swing.KDButton kDButtonSyn;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTableEntry;
    protected com.kingdee.bos.ctrl.swing.KDButton kDButtonQuery;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton kDWorkButton1;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton kDWorkButton2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer stockingBatch;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox kDBizPromptBoxTargetSystem;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox kDBizPromptBoxBizType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox kDBizPromptBoxCompany;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDatePickerDateS;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDatePickerDateE;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox kDBizPromptBox1;
    /**
     * output class constructor
     */
    public AbstractDataSynPlateformUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractDataSynPlateformUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainerTargetSystem = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainerBizType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainerCompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainerDateS = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainerDateE = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDButtonSyn = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kDTableEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDButtonQuery = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kDWorkButton1 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.kDWorkButton2 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.stockingBatch = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDBizPromptBoxTargetSystem = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDBizPromptBoxBizType = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDBizPromptBoxCompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDatePickerDateS = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.kDDatePickerDateE = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.kDBizPromptBox1 = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDLabelContainerTargetSystem.setName("kDLabelContainerTargetSystem");
        this.kDLabelContainerBizType.setName("kDLabelContainerBizType");
        this.kDLabelContainerCompany.setName("kDLabelContainerCompany");
        this.kDLabelContainerDateS.setName("kDLabelContainerDateS");
        this.kDLabelContainerDateE.setName("kDLabelContainerDateE");
        this.kDButtonSyn.setName("kDButtonSyn");
        this.kDTableEntry.setName("kDTableEntry");
        this.kDButtonQuery.setName("kDButtonQuery");
        this.kDWorkButton1.setName("kDWorkButton1");
        this.kDWorkButton2.setName("kDWorkButton2");
        this.stockingBatch.setName("stockingBatch");
        this.kDBizPromptBoxTargetSystem.setName("kDBizPromptBoxTargetSystem");
        this.kDBizPromptBoxBizType.setName("kDBizPromptBoxBizType");
        this.kDBizPromptBoxCompany.setName("kDBizPromptBoxCompany");
        this.kDDatePickerDateS.setName("kDDatePickerDateS");
        this.kDDatePickerDateE.setName("kDDatePickerDateE");
        this.kDBizPromptBox1.setName("kDBizPromptBox1");
        // CoreUI
        // kDLabelContainerTargetSystem		
        this.kDLabelContainerTargetSystem.setBoundLabelText(resHelper.getString("kDLabelContainerTargetSystem.boundLabelText"));		
        this.kDLabelContainerTargetSystem.setBoundLabelUnderline(true);		
        this.kDLabelContainerTargetSystem.setBoundLabelLength(100);
        // kDLabelContainerBizType		
        this.kDLabelContainerBizType.setBoundLabelText(resHelper.getString("kDLabelContainerBizType.boundLabelText"));		
        this.kDLabelContainerBizType.setBoundLabelUnderline(true);		
        this.kDLabelContainerBizType.setBoundLabelLength(100);
        // kDLabelContainerCompany		
        this.kDLabelContainerCompany.setBoundLabelText(resHelper.getString("kDLabelContainerCompany.boundLabelText"));		
        this.kDLabelContainerCompany.setBoundLabelLength(100);		
        this.kDLabelContainerCompany.setBoundLabelUnderline(true);
        // kDLabelContainerDateS		
        this.kDLabelContainerDateS.setBoundLabelText(resHelper.getString("kDLabelContainerDateS.boundLabelText"));		
        this.kDLabelContainerDateS.setBoundLabelLength(100);		
        this.kDLabelContainerDateS.setBoundLabelUnderline(true);
        // kDLabelContainerDateE		
        this.kDLabelContainerDateE.setBoundLabelText(resHelper.getString("kDLabelContainerDateE.boundLabelText"));		
        this.kDLabelContainerDateE.setBoundLabelLength(100);		
        this.kDLabelContainerDateE.setBoundLabelUnderline(true);
        // kDButtonSyn		
        this.kDButtonSyn.setText(resHelper.getString("kDButtonSyn.text"));
        this.kDButtonSyn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    kDButtonSyn_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // kDTableEntry

        

        // kDButtonQuery		
        this.kDButtonQuery.setText(resHelper.getString("kDButtonQuery.text"));
        this.kDButtonQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    kDButtonQuery_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // kDWorkButton1		
        this.kDWorkButton1.setText(resHelper.getString("kDWorkButton1.text"));
        this.kDWorkButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    kDWorkButton1_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // kDWorkButton2		
        this.kDWorkButton2.setText(resHelper.getString("kDWorkButton2.text"));
        this.kDWorkButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    kDWorkButton2_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // stockingBatch		
        this.stockingBatch.setBoundLabelText(resHelper.getString("stockingBatch.boundLabelText"));		
        this.stockingBatch.setBoundLabelLength(100);		
        this.stockingBatch.setBoundLabelUnderline(true);
        // kDBizPromptBoxTargetSystem
        // kDBizPromptBoxBizType
        // kDBizPromptBoxCompany
        // kDDatePickerDateS
        // kDDatePickerDateE
        // kDBizPromptBox1		
        this.kDBizPromptBox1.setLabelLength(100);
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
        this.setBounds(new Rectangle(10, 10, 1016, 600));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(10, 10, 1016, 600));
        kDLabelContainerTargetSystem.setBounds(new Rectangle(14, 14, 270, 19));
        this.add(kDLabelContainerTargetSystem, new KDLayout.Constraints(14, 14, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainerBizType.setBounds(new Rectangle(717, 14, 270, 19));
        this.add(kDLabelContainerBizType, new KDLayout.Constraints(717, 14, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainerCompany.setBounds(new Rectangle(364, 14, 270, 19));
        this.add(kDLabelContainerCompany, new KDLayout.Constraints(364, 14, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainerDateS.setBounds(new Rectangle(14, 38, 270, 19));
        this.add(kDLabelContainerDateS, new KDLayout.Constraints(14, 38, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainerDateE.setBounds(new Rectangle(364, 38, 270, 19));
        this.add(kDLabelContainerDateE, new KDLayout.Constraints(364, 38, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDButtonSyn.setBounds(new Rectangle(897, 66, 89, 21));
        this.add(kDButtonSyn, new KDLayout.Constraints(897, 66, 89, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTableEntry.setBounds(new Rectangle(13, 96, 986, 472));
        this.add(kDTableEntry, new KDLayout.Constraints(13, 96, 986, 472, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDButtonQuery.setBounds(new Rectangle(713, 66, 89, 21));
        this.add(kDButtonQuery, new KDLayout.Constraints(713, 66, 89, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDWorkButton1.setBounds(new Rectangle(20, 65, 86, 24));
        this.add(kDWorkButton1, new KDLayout.Constraints(20, 65, 86, 24, 0));
        kDWorkButton2.setBounds(new Rectangle(189, 65, 86, 24));
        this.add(kDWorkButton2, new KDLayout.Constraints(189, 65, 86, 24, 0));
        stockingBatch.setBounds(new Rectangle(717, 39, 270, 19));
        this.add(stockingBatch, new KDLayout.Constraints(717, 39, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //kDLabelContainerTargetSystem
        kDLabelContainerTargetSystem.setBoundEditor(kDBizPromptBoxTargetSystem);
        //kDLabelContainerBizType
        kDLabelContainerBizType.setBoundEditor(kDBizPromptBoxBizType);
        //kDLabelContainerCompany
        kDLabelContainerCompany.setBoundEditor(kDBizPromptBoxCompany);
        //kDLabelContainerDateS
        kDLabelContainerDateS.setBoundEditor(kDDatePickerDateS);
        //kDLabelContainerDateE
        kDLabelContainerDateE.setBoundEditor(kDDatePickerDateE);
        //stockingBatch
        stockingBatch.setBoundEditor(kDBizPromptBox1);

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
	    return "com.kingdee.eas.custom.tocloud.app.DataSynPlateformUIHandler";
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
     * output kDButtonSyn_actionPerformed method
     */
    protected void kDButtonSyn_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output kDButtonQuery_actionPerformed method
     */
    protected void kDButtonQuery_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output kDWorkButton1_actionPerformed method
     */
    protected void kDWorkButton1_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output kDWorkButton2_actionPerformed method
     */
    protected void kDWorkButton2_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }


    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.tocloud.client", "DataSynPlateformUI");
    }




}