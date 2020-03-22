/**
 * output package name
 */
package com.kingdee.eas.farm.food.stocount.client;

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
public abstract class AbstractSemiCountOperateWeightUI extends com.kingdee.eas.framework.client.CoreUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSemiCountOperateWeightUI.class);
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer startdate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer enddate;
    protected com.kingdee.bos.ctrl.swing.KDButton select;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDatePicker2;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDatePicker3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer bizdate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer countpoint;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer countperson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer materialunit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton cancel;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton scales;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton clear;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel1;
    protected com.kingdee.bos.ctrl.swing.KDTextField weight;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox material;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel2;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton print;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel3;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDatePicker1;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox countpointf7;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox countpersonf7;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox materialunitf7;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox materialunittypef7;
    /**
     * output class constructor
     */
    public AbstractSemiCountOperateWeightUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractSemiCountOperateWeightUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDTable1 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.startdate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.enddate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.select = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDDatePicker2 = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.kDDatePicker3 = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.bizdate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.countpoint = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.countperson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.materialunit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.cancel = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.scales = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.clear = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.kDLabel1 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.weight = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.material = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDLabel2 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.print = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.kDLabel3 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDLabel4 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDDatePicker1 = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.countpointf7 = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.countpersonf7 = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.materialunitf7 = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.materialunittypef7 = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDTable1.setName("kDTable1");
        this.startdate.setName("startdate");
        this.enddate.setName("enddate");
        this.select.setName("select");
        this.kDPanel1.setName("kDPanel1");
        this.kDDatePicker2.setName("kDDatePicker2");
        this.kDDatePicker3.setName("kDDatePicker3");
        this.bizdate.setName("bizdate");
        this.countpoint.setName("countpoint");
        this.countperson.setName("countperson");
        this.materialunit.setName("materialunit");
        this.cancel.setName("cancel");
        this.scales.setName("scales");
        this.clear.setName("clear");
        this.kDLabel1.setName("kDLabel1");
        this.weight.setName("weight");
        this.material.setName("material");
        this.kDLabel2.setName("kDLabel2");
        this.print.setName("print");
        this.kDLabel3.setName("kDLabel3");
        this.kDLabel4.setName("kDLabel4");
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDDatePicker1.setName("kDDatePicker1");
        this.countpointf7.setName("countpointf7");
        this.countpersonf7.setName("countpersonf7");
        this.materialunitf7.setName("materialunitf7");
        this.materialunittypef7.setName("materialunittypef7");
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
        // kDTable1
		String kDTable1StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles /><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"column1\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"column2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"column3\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"column4\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"column5\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"column6\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"column7\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{column1}</t:Cell><t:Cell>$Resource{column2}</t:Cell><t:Cell>$Resource{column3}</t:Cell><t:Cell>$Resource{column4}</t:Cell><t:Cell>$Resource{column5}</t:Cell><t:Cell>$Resource{column6}</t:Cell><t:Cell>$Resource{column7}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kDTable1.setFormatXml(resHelper.translateString("kDTable1",kDTable1StrXML));

        

        // startdate		
        this.startdate.setBoundLabelText(resHelper.getString("startdate.boundLabelText"));		
        this.startdate.setBoundLabelUnderline(true);		
        this.startdate.setBoundLabelLength(60);		
        this.startdate.setEnabled(false);		
        this.startdate.setVisible(false);
        // enddate		
        this.enddate.setBoundLabelText(resHelper.getString("enddate.boundLabelText"));		
        this.enddate.setBoundLabelUnderline(true);		
        this.enddate.setBoundLabelLength(60);		
        this.enddate.setEnabled(false);		
        this.enddate.setVisible(false);
        // select		
        this.select.setText(resHelper.getString("select.text"));		
        this.select.setEnabled(false);		
        this.select.setVisible(false);
        // kDPanel1		
        this.kDPanel1.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel1.border.title")));
        // kDDatePicker2
        // kDDatePicker3
        // bizdate		
        this.bizdate.setBoundLabelText(resHelper.getString("bizdate.boundLabelText"));		
        this.bizdate.setBoundLabelUnderline(true);		
        this.bizdate.setBoundLabelLength(100);
        // countpoint		
        this.countpoint.setBoundLabelText(resHelper.getString("countpoint.boundLabelText"));		
        this.countpoint.setBoundLabelUnderline(true);		
        this.countpoint.setBoundLabelLength(100);		
        this.countpoint.setEnabled(false);
        // countperson		
        this.countperson.setBoundLabelText(resHelper.getString("countperson.boundLabelText"));		
        this.countperson.setBoundLabelUnderline(true);		
        this.countperson.setBoundLabelLength(100);		
        this.countperson.setEnabled(false);
        // materialunit		
        this.materialunit.setBoundLabelText(resHelper.getString("materialunit.boundLabelText"));		
        this.materialunit.setBoundLabelUnderline(true);		
        this.materialunit.setBoundLabelLength(100);
        // cancel		
        this.cancel.setText(resHelper.getString("cancel.text"));		
        this.cancel.setFont(resHelper.getFont("cancel.font"));
        this.cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    cancel_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // scales		
        this.scales.setText(resHelper.getString("scales.text"));		
        this.scales.setFont(resHelper.getFont("scales.font"));
        this.scales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    scales_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // clear		
        this.clear.setText(resHelper.getString("clear.text"));		
        this.clear.setFont(resHelper.getFont("clear.font"));
        this.clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    clear_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // kDLabel1		
        this.kDLabel1.setText(resHelper.getString("kDLabel1.text"));		
        this.kDLabel1.setFont(resHelper.getFont("kDLabel1.font"));
        // weight
        // material
        // kDLabel2		
        this.kDLabel2.setText(resHelper.getString("kDLabel2.text"));		
        this.kDLabel2.setFont(resHelper.getFont("kDLabel2.font"));
        // print		
        this.print.setText(resHelper.getString("print.text"));		
        this.print.setFont(resHelper.getFont("print.font"));
        this.print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    print_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // kDLabel3		
        this.kDLabel3.setText(resHelper.getString("kDLabel3.text"));		
        this.kDLabel3.setFont(resHelper.getFont("kDLabel3.font"));		
        this.kDLabel3.setForeground(new java.awt.Color(86,210,45));		
        this.kDLabel3.setHorizontalAlignment(4);
        // kDLabel4		
        this.kDLabel4.setText(resHelper.getString("kDLabel4.text"));		
        this.kDLabel4.setFont(resHelper.getFont("kDLabel4.font"));		
        this.kDLabel4.setForeground(new java.awt.Color(0,187,0));
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelUnderline(true);		
        this.kDLabelContainer1.setBoundLabelLength(100);
        // kDDatePicker1		
        this.kDDatePicker1.setEnabled(false);
        // countpointf7
        // countpersonf7
        // materialunitf7		
        this.materialunitf7.setEnabled(false);
        // materialunittypef7		
        this.materialunittypef7.setEnabled(false);
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
        this.setLayout(null);
        kDTable1.setBounds(new Rectangle(11, 36, 575, 512));
        this.add(kDTable1, null);
        startdate.setBounds(new Rectangle(20, 10, 187, 19));
        this.add(startdate, null);
        enddate.setBounds(new Rectangle(228, 11, 187, 19));
        this.add(enddate, null);
        select.setBounds(new Rectangle(465, 11, 73, 21));
        this.add(select, null);
        kDPanel1.setBounds(new Rectangle(595, 13, 394, 559));
        this.add(kDPanel1, null);
        //startdate
        startdate.setBoundEditor(kDDatePicker2);
        //enddate
        enddate.setBoundEditor(kDDatePicker3);
        //kDPanel1
        kDPanel1.setLayout(null);        bizdate.setBounds(new Rectangle(28, 43, 310, 19));
        kDPanel1.add(bizdate, null);
        countpoint.setBounds(new Rectangle(27, 74, 310, 19));
        kDPanel1.add(countpoint, null);
        countperson.setBounds(new Rectangle(26, 112, 315, 19));
        kDPanel1.add(countperson, null);
        materialunit.setBounds(new Rectangle(26, 212, 314, 19));
        kDPanel1.add(materialunit, null);
        cancel.setBounds(new Rectangle(216, 484, 130, 58));
        kDPanel1.add(cancel, null);
        scales.setBounds(new Rectangle(44, 392, 130, 58));
        kDPanel1.add(scales, null);
        clear.setBounds(new Rectangle(215, 392, 130, 58));
        kDPanel1.add(clear, null);
        kDLabel1.setBounds(new Rectangle(34, 273, 187, 74));
        kDPanel1.add(kDLabel1, null);
        weight.setBounds(new Rectangle(173, 275, 169, 48));
        kDPanel1.add(weight, null);
        material.setBounds(new Rectangle(127, 148, 215, 48));
        kDPanel1.add(material, null);
        kDLabel2.setBounds(new Rectangle(23, 133, 79, 74));
        kDPanel1.add(kDLabel2, null);
        print.setBounds(new Rectangle(45, 482, 130, 58));
        kDPanel1.add(print, null);
        kDLabel3.setBounds(new Rectangle(16, 298, 219, 96));
        kDPanel1.add(kDLabel3, null);
        kDLabel4.setBounds(new Rectangle(241, 339, 100, 31));
        kDPanel1.add(kDLabel4, null);
        kDLabelContainer1.setBounds(new Rectangle(25, 252, 315, 19));
        kDPanel1.add(kDLabelContainer1, null);
        //bizdate
        bizdate.setBoundEditor(kDDatePicker1);
        //countpoint
        countpoint.setBoundEditor(countpointf7);
        //countperson
        countperson.setBoundEditor(countpersonf7);
        //materialunit
        materialunit.setBoundEditor(materialunitf7);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(materialunittypef7);

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
	    return "com.kingdee.eas.farm.food.stocount.app.SemiCountOperateWeightUIHandler";
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
     * output cancel_actionPerformed method
     */
    protected void cancel_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output scales_actionPerformed method
     */
    protected void scales_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output clear_actionPerformed method
     */
    protected void clear_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output print_actionPerformed method
     */
    protected void print_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }


    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.food.stocount.client", "SemiCountOperateWeightUI");
    }




}