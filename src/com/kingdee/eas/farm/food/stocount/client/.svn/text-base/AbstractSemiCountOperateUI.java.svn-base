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
public abstract class AbstractSemiCountOperateUI extends com.kingdee.eas.framework.client.CoreUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSemiCountOperateUI.class);
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer startdate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer enddate;
    protected com.kingdee.bos.ctrl.swing.KDButton select;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDatePicker2;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDatePicker3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer bizdate1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer countpoint;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer countperson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer materialunit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton cancel;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton QyBtn;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton clear;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel1;
    protected com.kingdee.bos.ctrl.swing.KDTextField weight;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox material;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer materialunittype;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDate;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton HyBtn;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer inventoryUnit;
    protected com.kingdee.bos.ctrl.swing.KDTextField warehouse;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel3;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton kDWorkButton2;
    protected com.kingdee.bos.ctrl.swing.KDComboBox classes;
    protected com.kingdee.bos.ctrl.swing.KDLabel classtxt;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker bizdate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox countpointf7;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox countpersonf7;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox materialunitf7;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox materialunittypef7;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker productDateF7;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox inventoryUnitF7;
    protected ActionQY actionQY = null;
    protected ActionHY actionHY = null;
    protected ActionCheck actionCheck = null;
    /**
     * output class constructor
     */
    public AbstractSemiCountOperateUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractSemiCountOperateUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        //actionQY
        this.actionQY = new ActionQY(this);
        getActionManager().registerAction("actionQY", actionQY);
         this.actionQY.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionHY
        this.actionHY = new ActionHY(this);
        getActionManager().registerAction("actionHY", actionHY);
         this.actionHY.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionCheck
        this.actionCheck = new ActionCheck(this);
        getActionManager().registerAction("actionCheck", actionCheck);
         this.actionCheck.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        this.kDTable1 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.startdate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.enddate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.select = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDDatePicker2 = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.kDDatePicker3 = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.bizdate1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.countpoint = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.countperson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.materialunit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.cancel = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.QyBtn = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.clear = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.kDLabel1 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.weight = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.material = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDLabel2 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.materialunittype = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.HyBtn = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.inventoryUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.warehouse = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kDLabel3 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDWorkButton2 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.classes = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.classtxt = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.bizdate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.countpointf7 = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.countpersonf7 = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.materialunitf7 = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.materialunittypef7 = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.productDateF7 = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.inventoryUnitF7 = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDTable1.setName("kDTable1");
        this.startdate.setName("startdate");
        this.enddate.setName("enddate");
        this.select.setName("select");
        this.kDPanel1.setName("kDPanel1");
        this.kDDatePicker2.setName("kDDatePicker2");
        this.kDDatePicker3.setName("kDDatePicker3");
        this.bizdate1.setName("bizdate1");
        this.countpoint.setName("countpoint");
        this.countperson.setName("countperson");
        this.materialunit.setName("materialunit");
        this.cancel.setName("cancel");
        this.QyBtn.setName("QyBtn");
        this.clear.setName("clear");
        this.kDLabel1.setName("kDLabel1");
        this.weight.setName("weight");
        this.material.setName("material");
        this.kDLabel2.setName("kDLabel2");
        this.materialunittype.setName("materialunittype");
        this.contDate.setName("contDate");
        this.HyBtn.setName("HyBtn");
        this.inventoryUnit.setName("inventoryUnit");
        this.warehouse.setName("warehouse");
        this.kDLabel3.setName("kDLabel3");
        this.kDWorkButton2.setName("kDWorkButton2");
        this.classes.setName("classes");
        this.classtxt.setName("classtxt");
        this.bizdate.setName("bizdate");
        this.countpointf7.setName("countpointf7");
        this.countpersonf7.setName("countpersonf7");
        this.materialunitf7.setName("materialunitf7");
        this.materialunittypef7.setName("materialunittypef7");
        this.productDateF7.setName("productDateF7");
        this.inventoryUnitF7.setName("inventoryUnitF7");
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
		String kDTable1StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles /><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"column1\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"column2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"column3\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"column4\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"column5\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"column6\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{column1}</t:Cell><t:Cell>$Resource{column2}</t:Cell><t:Cell>$Resource{column3}</t:Cell><t:Cell>$Resource{column4}</t:Cell><t:Cell>$Resource{column5}</t:Cell><t:Cell>$Resource{column6}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kDTable1.setFormatXml(resHelper.translateString("kDTable1",kDTable1StrXML));

        

        // startdate		
        this.startdate.setBoundLabelText(resHelper.getString("startdate.boundLabelText"));		
        this.startdate.setBoundLabelUnderline(true);		
        this.startdate.setBoundLabelLength(60);
        // enddate		
        this.enddate.setBoundLabelText(resHelper.getString("enddate.boundLabelText"));		
        this.enddate.setBoundLabelUnderline(true);		
        this.enddate.setBoundLabelLength(60);
        // select
        this.select.setAction((IItemAction)ActionProxyFactory.getProxy(actionCheck, new Class[] { IItemAction.class }, getServiceContext()));		
        this.select.setText(resHelper.getString("select.text"));
        // kDPanel1		
        this.kDPanel1.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel1.border.title")));
        // kDDatePicker2
        // kDDatePicker3
        // bizdate1		
        this.bizdate1.setBoundLabelText(resHelper.getString("bizdate1.boundLabelText"));		
        this.bizdate1.setBoundLabelUnderline(true);		
        this.bizdate1.setBoundLabelLength(100);
        // countpoint		
        this.countpoint.setBoundLabelText(resHelper.getString("countpoint.boundLabelText"));		
        this.countpoint.setBoundLabelUnderline(true);		
        this.countpoint.setBoundLabelLength(100);
        // countperson		
        this.countperson.setBoundLabelText(resHelper.getString("countperson.boundLabelText"));		
        this.countperson.setBoundLabelUnderline(true);		
        this.countperson.setBoundLabelLength(100);
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
        // QyBtn
        this.QyBtn.setAction((IItemAction)ActionProxyFactory.getProxy(actionQY, new Class[] { IItemAction.class }, getServiceContext()));		
        this.QyBtn.setText(resHelper.getString("QyBtn.text"));		
        this.QyBtn.setFont(resHelper.getFont("QyBtn.font"));
        this.QyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    QyBtn_actionPerformed(e);
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
        this.kDLabel1.setBackground(new java.awt.Color(255,0,0));		
        this.kDLabel1.setForeground(new java.awt.Color(255,0,0));
        // weight
        // material
        // kDLabel2		
        this.kDLabel2.setText(resHelper.getString("kDLabel2.text"));		
        this.kDLabel2.setFont(resHelper.getFont("kDLabel2.font"));		
        this.kDLabel2.setBackground(new java.awt.Color(255,0,0));		
        this.kDLabel2.setForeground(new java.awt.Color(255,0,0));
        // materialunittype		
        this.materialunittype.setBoundLabelText(resHelper.getString("materialunittype.boundLabelText"));		
        this.materialunittype.setBoundLabelUnderline(true);		
        this.materialunittype.setBoundLabelLength(100);
        // contDate		
        this.contDate.setBoundLabelText(resHelper.getString("contDate.boundLabelText"));
        // HyBtn
        this.HyBtn.setAction((IItemAction)ActionProxyFactory.getProxy(actionHY, new Class[] { IItemAction.class }, getServiceContext()));		
        this.HyBtn.setText(resHelper.getString("HyBtn.text"));		
        this.HyBtn.setFont(resHelper.getFont("HyBtn.font"));
        // inventoryUnit		
        this.inventoryUnit.setBoundLabelText(resHelper.getString("inventoryUnit.boundLabelText"));
        // warehouse		
        this.warehouse.setEnabled(false);		
        this.warehouse.setVisible(false);
        // kDLabel3		
        this.kDLabel3.setText(resHelper.getString("kDLabel3.text"));		
        this.kDLabel3.setFont(resHelper.getFont("kDLabel3.font"));		
        this.kDLabel3.setVisible(false);		
        this.kDLabel3.setEnabled(false);
        // kDWorkButton2		
        this.kDWorkButton2.setText(resHelper.getString("kDWorkButton2.text"));		
        this.kDWorkButton2.setFont(resHelper.getFont("kDWorkButton2.font"));
        this.kDWorkButton2.addActionListener(new java.awt.event.ActionListener() {
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
        // classes
        // classtxt		
        this.classtxt.setText(resHelper.getString("classtxt.text"));		
        this.classtxt.setFont(resHelper.getFont("classtxt.font"));
        // bizdate		
        this.bizdate.setEnabled(false);
        // countpointf7		
        this.countpointf7.setEnabled(false);
        // countpersonf7		
        this.countpersonf7.setEnabled(false);
        // materialunitf7		
        this.materialunitf7.setEnabled(false);
        // materialunittypef7		
        this.materialunittypef7.setEnabled(false);
        // productDateF7
        // inventoryUnitF7
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
        this.setBounds(new Rectangle(10, 10, 1200, 629));
        this.setLayout(null);
        kDTable1.setBounds(new Rectangle(11, 36, 567, 549));
        this.add(kDTable1, null);
        startdate.setBounds(new Rectangle(20, 10, 187, 19));
        this.add(startdate, null);
        enddate.setBounds(new Rectangle(228, 11, 187, 19));
        this.add(enddate, null);
        select.setBounds(new Rectangle(465, 11, 73, 21));
        this.add(select, null);
        kDPanel1.setBounds(new Rectangle(586, 37, 452, 551));
        this.add(kDPanel1, null);
        //startdate
        startdate.setBoundEditor(kDDatePicker2);
        //enddate
        enddate.setBoundEditor(kDDatePicker3);
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(586, 37, 452, 551));        bizdate1.setBounds(new Rectangle(30, 37, 368, 25));
        kDPanel1.add(bizdate1, new KDLayout.Constraints(30, 37, 368, 25, 0));
        countpoint.setBounds(new Rectangle(30, 74, 368, 19));
        kDPanel1.add(countpoint, new KDLayout.Constraints(30, 74, 368, 19, 0));
        countperson.setBounds(new Rectangle(30, 107, 368, 19));
        kDPanel1.add(countperson, new KDLayout.Constraints(30, 107, 368, 19, 0));
        materialunit.setBounds(new Rectangle(30, 277, 368, 19));
        kDPanel1.add(materialunit, new KDLayout.Constraints(30, 277, 368, 19, 0));
        cancel.setBounds(new Rectangle(318, 480, 114, 55));
        kDPanel1.add(cancel, new KDLayout.Constraints(318, 480, 114, 55, 0));
        QyBtn.setBounds(new Rectangle(5, 150, 130, 58));
        kDPanel1.add(QyBtn, new KDLayout.Constraints(5, 150, 130, 58, 0));
        clear.setBounds(new Rectangle(18, 479, 115, 55));
        kDPanel1.add(clear, new KDLayout.Constraints(18, 479, 115, 55, 0));
        kDLabel1.setBounds(new Rectangle(26, 335, 121, 74));
        kDPanel1.add(kDLabel1, new KDLayout.Constraints(26, 335, 121, 74, 0));
        weight.setBounds(new Rectangle(133, 345, 262, 48));
        kDPanel1.add(weight, new KDLayout.Constraints(133, 345, 262, 48, 0));
        material.setBounds(new Rectangle(133, 223, 262, 48));
        kDPanel1.add(material, new KDLayout.Constraints(133, 223, 262, 48, 0));
        kDLabel2.setBounds(new Rectangle(26, 218, 97, 54));
        kDPanel1.add(kDLabel2, new KDLayout.Constraints(26, 218, 97, 54, 0));
        materialunittype.setBounds(new Rectangle(30, 323, 368, 19));
        kDPanel1.add(materialunittype, new KDLayout.Constraints(30, 323, 368, 19, 0));
        contDate.setBounds(new Rectangle(134, 167, 169, 19));
        kDPanel1.add(contDate, new KDLayout.Constraints(134, 167, 169, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        HyBtn.setBounds(new Rectangle(307, 148, 130, 58));
        kDPanel1.add(HyBtn, new KDLayout.Constraints(307, 148, 130, 58, 0));
        inventoryUnit.setBounds(new Rectangle(30, 301, 368, 19));
        kDPanel1.add(inventoryUnit, new KDLayout.Constraints(30, 301, 368, 19, 0));
        warehouse.setBounds(new Rectangle(134, 407, 58, 23));
        kDPanel1.add(warehouse, new KDLayout.Constraints(134, 407, 58, 23, 0));
        kDLabel3.setBounds(new Rectangle(53, 401, 99, 33));
        kDPanel1.add(kDLabel3, new KDLayout.Constraints(53, 401, 99, 33, 0));
        kDWorkButton2.setBounds(new Rectangle(152, 439, 149, 77));
        kDPanel1.add(kDWorkButton2, new KDLayout.Constraints(152, 439, 149, 77, 0));
        classes.setBounds(new Rectangle(269, 408, 126, 19));
        kDPanel1.add(classes, new KDLayout.Constraints(269, 408, 126, 19, 0));
        classtxt.setBounds(new Rectangle(204, 404, 69, 29));
        kDPanel1.add(classtxt, new KDLayout.Constraints(204, 404, 69, 29, 0));
        //bizdate1
        bizdate1.setBoundEditor(bizdate);
        //countpoint
        countpoint.setBoundEditor(countpointf7);
        //countperson
        countperson.setBoundEditor(countpersonf7);
        //materialunit
        materialunit.setBoundEditor(materialunitf7);
        //materialunittype
        materialunittype.setBoundEditor(materialunittypef7);
        //contDate
        contDate.setBoundEditor(productDateF7);
        //inventoryUnit
        inventoryUnit.setBoundEditor(inventoryUnitF7);

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
	    return "com.kingdee.eas.farm.food.stocount.app.SemiCountOperateUIHandler";
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
     * output QyBtn_actionPerformed method
     */
    protected void QyBtn_actionPerformed(java.awt.event.ActionEvent e) throws Exception
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
     * output actionQY_actionPerformed method
     */
    public void actionQY_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionHY_actionPerformed method
     */
    public void actionHY_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionCheck_actionPerformed method
     */
    public void actionCheck_actionPerformed(ActionEvent e) throws Exception
    {
    }
	public RequestContext prepareActionQY(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionQY() {
    	return false;
    }
	public RequestContext prepareActionHY(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionHY() {
    	return false;
    }
	public RequestContext prepareActionCheck(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionCheck() {
    	return false;
    }

    /**
     * output ActionQY class
     */     
    protected class ActionQY extends ItemAction {     
    
        public ActionQY()
        {
            this(null);
        }

        public ActionQY(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("ActionQY.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionQY.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionQY.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractSemiCountOperateUI.this, "ActionQY", "actionQY_actionPerformed", e);
        }
    }

    /**
     * output ActionHY class
     */     
    protected class ActionHY extends ItemAction {     
    
        public ActionHY()
        {
            this(null);
        }

        public ActionHY(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("ActionHY.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionHY.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionHY.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractSemiCountOperateUI.this, "ActionHY", "actionHY_actionPerformed", e);
        }
    }

    /**
     * output ActionCheck class
     */     
    protected class ActionCheck extends ItemAction {     
    
        public ActionCheck()
        {
            this(null);
        }

        public ActionCheck(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionCheck.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCheck.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCheck.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractSemiCountOperateUI.this, "ActionCheck", "actionCheck_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.food.stocount.client", "SemiCountOperateUI");
    }




}