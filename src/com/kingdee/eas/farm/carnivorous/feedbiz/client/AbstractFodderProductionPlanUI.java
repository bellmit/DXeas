/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.feedbiz.client;

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
public abstract class AbstractFodderProductionPlanUI extends com.kingdee.eas.framework.client.CoreUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractFodderProductionPlanUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conBeginDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conEndDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conDayRange;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnQuery;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator2;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBeginDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkEndDate;
    protected com.kingdee.bos.ctrl.swing.KDNumberTextField txtDayRange;
    protected com.kingdee.bos.ctrl.swing.KDPanel kdPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtDetailEntrys;
    protected com.kingdee.bos.ctrl.swing.KDNumberTextField txt308Rate;
    protected com.kingdee.bos.ctrl.swing.KDNumberTextField txt817Rate;
    /**
     * output class constructor
     */
    public AbstractFodderProductionPlanUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractFodderProductionPlanUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.conBeginDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conEndDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conDayRange = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnQuery = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.kDSeparator2 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.pkBeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkEndDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDayRange = new com.kingdee.bos.ctrl.swing.KDNumberTextField();
        this.kdPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtDetailEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.txt308Rate = new com.kingdee.bos.ctrl.swing.KDNumberTextField();
        this.txt817Rate = new com.kingdee.bos.ctrl.swing.KDNumberTextField();
        this.conBeginDate.setName("conBeginDate");
        this.conEndDate.setName("conEndDate");
        this.conDayRange.setName("conDayRange");
        this.btnQuery.setName("btnQuery");
        this.kDSeparator2.setName("kDSeparator2");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.pkBeginDate.setName("pkBeginDate");
        this.pkEndDate.setName("pkEndDate");
        this.txtDayRange.setName("txtDayRange");
        this.kdPanel2.setName("kdPanel2");
        this.kDPanel1.setName("kDPanel1");
        this.kdtEntrys.setName("kdtEntrys");
        this.kdtDetailEntrys.setName("kdtDetailEntrys");
        this.txt308Rate.setName("txt308Rate");
        this.txt817Rate.setName("txt817Rate");
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
        // conBeginDate		
        this.conBeginDate.setBoundLabelText(resHelper.getString("conBeginDate.boundLabelText"));		
        this.conBeginDate.setBoundLabelUnderline(true);		
        this.conBeginDate.setBoundLabelLength(120);
        // conEndDate		
        this.conEndDate.setBoundLabelText(resHelper.getString("conEndDate.boundLabelText"));		
        this.conEndDate.setBoundLabelUnderline(true);		
        this.conEndDate.setBoundLabelLength(120);
        // conDayRange		
        this.conDayRange.setBoundLabelText(resHelper.getString("conDayRange.boundLabelText"));		
        this.conDayRange.setBoundLabelUnderline(true);		
        this.conDayRange.setBoundLabelLength(120);
        // btnQuery		
        this.btnQuery.setText(resHelper.getString("btnQuery.text"));		
        this.btnQuery.setFont(resHelper.getFont("btnQuery.font"));
        this.btnQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnQuery_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // kDSeparator2
        // kDTabbedPane1
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelUnderline(true);		
        this.kDLabelContainer1.setBoundLabelLength(120);
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelUnderline(true);		
        this.kDLabelContainer2.setBoundLabelLength(120);
        // pkBeginDate
        // pkEndDate
        // txtDayRange
        // kdPanel2
        // kDPanel1
        // kdtEntrys

        

        // kdtDetailEntrys

        

        // txt308Rate		
        this.txt308Rate.setDataType(6);
        // txt817Rate		
        this.txt817Rate.setDataType(6);
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
        conBeginDate.setBounds(new Rectangle(43, 27, 270, 19));
        this.add(conBeginDate, new KDLayout.Constraints(43, 27, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conEndDate.setBounds(new Rectangle(359, 27, 270, 19));
        this.add(conEndDate, new KDLayout.Constraints(359, 27, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conDayRange.setBounds(new Rectangle(675, 27, 270, 19));
        this.add(conDayRange, new KDLayout.Constraints(675, 27, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        btnQuery.setBounds(new Rectangle(812, 65, 127, 36));
        this.add(btnQuery, new KDLayout.Constraints(812, 65, 127, 36, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator2.setBounds(new Rectangle(-84, 110, 1390, 10));
        this.add(kDSeparator2, new KDLayout.Constraints(-84, 110, 1390, 10, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDTabbedPane1.setBounds(new Rectangle(3, 124, 1005, 500));
        this.add(kDTabbedPane1, new KDLayout.Constraints(3, 124, 1005, 500, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabelContainer1.setBounds(new Rectangle(43, 71, 270, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(43, 71, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer2.setBounds(new Rectangle(359, 71, 270, 19));
        this.add(kDLabelContainer2, new KDLayout.Constraints(359, 71, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //conBeginDate
        conBeginDate.setBoundEditor(pkBeginDate);
        //conEndDate
        conEndDate.setBoundEditor(pkEndDate);
        //conDayRange
        conDayRange.setBoundEditor(txtDayRange);
        //kDTabbedPane1
        kDTabbedPane1.add(kdPanel2, resHelper.getString("kdPanel2.constraints"));
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        //kdPanel2
        kdPanel2.setLayout(new KDLayout());
        kdPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1004, 467));        kdtEntrys.setBounds(new Rectangle(2, 3, 995, 461));
        kdPanel2.add(kdtEntrys, new KDLayout.Constraints(2, 3, 995, 461, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1004, 467));        kdtDetailEntrys.setBounds(new Rectangle(2, 2, 994, 463));
        kDPanel1.add(kdtDetailEntrys, new KDLayout.Constraints(2, 2, 994, 463, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txt308Rate);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txt817Rate);

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
	    return "com.kingdee.eas.farm.carnivorous.feedbiz.app.FodderProductionPlanUIHandler";
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
     * output btnQuery_actionPerformed method
     */
    protected void btnQuery_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }


    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.feedbiz.client", "FodderProductionPlanUI");
    }




}