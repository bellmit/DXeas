/**
 * output package name
 */
package com.kingdee.eas.custom.szcount.client;

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
public abstract class AbstractCopy_SzSemiCountMobileUI extends com.kingdee.eas.framework.client.CoreUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCopy_SzSemiCountMobileUI.class);
    protected com.kingdee.bos.ctrl.swing.KDWorkButton xl;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton jjl;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton qt;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tl;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton cl;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox material;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox HouseName;
    protected com.kingdee.bos.ctrl.swing.KDLabel strokeCounterName;
    protected com.kingdee.bos.ctrl.swing.KDLabel strokeCounters;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel4;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel5;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox strokeName;
    protected com.kingdee.bos.ctrl.swing.KDComboBox strokePosts;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton deleteButton;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton HyBtn;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton QyBtn;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDate;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable2;
    protected com.kingdee.bos.ctrl.swing.KDLabel finishedProductType;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton previousPage;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton nextPage;
    protected com.kingdee.bos.ctrl.swing.KDLabel numberOfPages;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton clear;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel1;
    protected com.kingdee.bos.ctrl.swing.KDTextField weight;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel2;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton kDWorkButton2;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel3;
    protected com.kingdee.bos.ctrl.swing.KDLabel measureType;
    protected com.kingdee.bos.ctrl.swing.KDTextField materials;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton bb1;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton bb3;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton bb6;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton bb5;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton bb4;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton bb7;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton bb9;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton bb8;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton bb2;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton bb0;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton cancel;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton affirm;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton minus;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton spot;
    protected com.kingdee.bos.ctrl.swing.KDLabel materialNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabel materialNumbers;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel5;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel6;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable1;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable3;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable4;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable5;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable6;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker productDateF7;
    protected ActionQY actionQY = null;
    protected ActionHY actionHY = null;
    protected ActionCheck actionCheck = null;
    protected actionxlselect actionXlselect = null;
    protected actiontlselect actionTlselect = null;
    protected actionclselect actionClselect = null;
    protected actionjjlselect actionJjlselect = null;
    protected actionqtselect actionQtselect = null;
    /**
     * output class constructor
     */
    public AbstractCopy_SzSemiCountMobileUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCopy_SzSemiCountMobileUI.class.getName());
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
        //actionXlselect
        this.actionXlselect = new actionxlselect(this);
        getActionManager().registerAction("actionXlselect", actionXlselect);
         this.actionXlselect.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionTlselect
        this.actionTlselect = new actiontlselect(this);
        getActionManager().registerAction("actionTlselect", actionTlselect);
         this.actionTlselect.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionClselect
        this.actionClselect = new actionclselect(this);
        getActionManager().registerAction("actionClselect", actionClselect);
         this.actionClselect.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionJjlselect
        this.actionJjlselect = new actionjjlselect(this);
        getActionManager().registerAction("actionJjlselect", actionJjlselect);
         this.actionJjlselect.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionQtselect
        this.actionQtselect = new actionqtselect(this);
        getActionManager().registerAction("actionQtselect", actionQtselect);
         this.actionQtselect.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        this.xl = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.jjl = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.qt = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tl = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.cl = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.material = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.HouseName = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.strokeCounterName = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.strokeCounters = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDLabel4 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDLabel5 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.strokeName = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.strokePosts = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.deleteButton = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.HyBtn = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.QyBtn = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTable2 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.finishedProductType = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.previousPage = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.nextPage = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.numberOfPages = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.clear = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.kDLabel1 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.weight = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kDLabel2 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDWorkButton2 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.kDLabel3 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.measureType = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.materials = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.bb1 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.bb3 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.bb6 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.bb5 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.bb4 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.bb7 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.bb9 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.bb8 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.bb2 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.bb0 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.cancel = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.affirm = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.minus = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.spot = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.materialNumber = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.materialNumbers = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel5 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel6 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDTable1 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDTable3 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDTable4 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDTable5 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDTable6 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.productDateF7 = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.xl.setName("xl");
        this.jjl.setName("jjl");
        this.qt.setName("qt");
        this.tl.setName("tl");
        this.cl.setName("cl");
        this.material.setName("material");
        this.kDPanel1.setName("kDPanel1");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.HouseName.setName("HouseName");
        this.strokeCounterName.setName("strokeCounterName");
        this.strokeCounters.setName("strokeCounters");
        this.kDLabel4.setName("kDLabel4");
        this.kDLabel5.setName("kDLabel5");
        this.strokeName.setName("strokeName");
        this.strokePosts.setName("strokePosts");
        this.deleteButton.setName("deleteButton");
        this.HyBtn.setName("HyBtn");
        this.QyBtn.setName("QyBtn");
        this.contDate.setName("contDate");
        this.kDTable2.setName("kDTable2");
        this.finishedProductType.setName("finishedProductType");
        this.previousPage.setName("previousPage");
        this.nextPage.setName("nextPage");
        this.numberOfPages.setName("numberOfPages");
        this.clear.setName("clear");
        this.kDLabel1.setName("kDLabel1");
        this.weight.setName("weight");
        this.kDLabel2.setName("kDLabel2");
        this.kDWorkButton2.setName("kDWorkButton2");
        this.kDLabel3.setName("kDLabel3");
        this.measureType.setName("measureType");
        this.materials.setName("materials");
        this.bb1.setName("bb1");
        this.bb3.setName("bb3");
        this.bb6.setName("bb6");
        this.bb5.setName("bb5");
        this.bb4.setName("bb4");
        this.bb7.setName("bb7");
        this.bb9.setName("bb9");
        this.bb8.setName("bb8");
        this.bb2.setName("bb2");
        this.bb0.setName("bb0");
        this.cancel.setName("cancel");
        this.affirm.setName("affirm");
        this.minus.setName("minus");
        this.spot.setName("spot");
        this.materialNumber.setName("materialNumber");
        this.materialNumbers.setName("materialNumbers");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel3.setName("kDPanel3");
        this.kDPanel4.setName("kDPanel4");
        this.kDPanel5.setName("kDPanel5");
        this.kDPanel6.setName("kDPanel6");
        this.kDTable1.setName("kDTable1");
        this.kDTable3.setName("kDTable3");
        this.kDTable4.setName("kDTable4");
        this.kDTable5.setName("kDTable5");
        this.kDTable6.setName("kDTable6");
        this.productDateF7.setName("productDateF7");
        // CoreUI		
        this.setBorder(null);		
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
        // xl
        this.xl.setAction((IItemAction)ActionProxyFactory.getProxy(actionXlselect, new Class[] { IItemAction.class }, getServiceContext()));		
        this.xl.setText(resHelper.getString("xl.text"));		
        this.xl.setFont(resHelper.getFont("xl.font"));
        this.xl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    xl_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // jjl
        this.jjl.setAction((IItemAction)ActionProxyFactory.getProxy(actionJjlselect, new Class[] { IItemAction.class }, getServiceContext()));		
        this.jjl.setText(resHelper.getString("jjl.text"));		
        this.jjl.setFont(resHelper.getFont("jjl.font"));
        // qt
        this.qt.setAction((IItemAction)ActionProxyFactory.getProxy(actionQtselect, new Class[] { IItemAction.class }, getServiceContext()));		
        this.qt.setText(resHelper.getString("qt.text"));		
        this.qt.setFont(resHelper.getFont("qt.font"));
        // tl
        this.tl.setAction((IItemAction)ActionProxyFactory.getProxy(actionTlselect, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tl.setText(resHelper.getString("tl.text"));		
        this.tl.setFont(resHelper.getFont("tl.font"));
        // cl
        this.cl.setAction((IItemAction)ActionProxyFactory.getProxy(actionClselect, new Class[] { IItemAction.class }, getServiceContext()));		
        this.cl.setText(resHelper.getString("cl.text"));		
        this.cl.setFont(resHelper.getFont("cl.font"));
        this.cl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    cl_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // material		
        this.material.setVisible(false);
        // kDPanel1		
        this.kDPanel1.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel1.border.title")));
        // kDTabbedPane1
        // HouseName		
        this.HouseName.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7AllWarehouseQuery");
        // strokeCounterName		
        this.strokeCounterName.setText(resHelper.getString("strokeCounterName.text"));		
        this.strokeCounterName.setFont(resHelper.getFont("strokeCounterName.font"));
        // strokeCounters		
        this.strokeCounters.setFont(resHelper.getFont("strokeCounters.font"));
        // kDLabel4		
        this.kDLabel4.setText(resHelper.getString("kDLabel4.text"));		
        this.kDLabel4.setFont(resHelper.getFont("kDLabel4.font"));
        // kDLabel5		
        this.kDLabel5.setText(resHelper.getString("kDLabel5.text"));		
        this.kDLabel5.setFont(resHelper.getFont("kDLabel5.font"));
        // strokeName
        // strokePosts
        this.strokePosts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    strokePosts_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // deleteButton		
        this.deleteButton.setText(resHelper.getString("deleteButton.text"));
        this.deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    deleteButton_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // HyBtn
        this.HyBtn.setAction((IItemAction)ActionProxyFactory.getProxy(actionHY, new Class[] { IItemAction.class }, getServiceContext()));		
        this.HyBtn.setText(resHelper.getString("HyBtn.text"));
        this.HyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    HyBtn_actionPerformed(e);
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
        // contDate		
        this.contDate.setBoundLabelText(resHelper.getString("contDate.boundLabelText"));		
        this.contDate.setBoundLabelUnderline(true);		
        this.contDate.setBoundLabelLength(60);
        // kDTable2
		String kDTable2StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles /><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"category\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"materialUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"1\" /><t:Column t:key=\"quantity\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"2\" /><t:Column t:key=\"materialNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{category}</t:Cell><t:Cell>$Resource{materialUnit}</t:Cell><t:Cell>$Resource{quantity}</t:Cell><t:Cell>$Resource{materialNumber}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kDTable2.setFormatXml(resHelper.translateString("kDTable2",kDTable2StrXML));

        

        // finishedProductType
        // previousPage		
        this.previousPage.setText(resHelper.getString("previousPage.text"));		
        this.previousPage.setFont(resHelper.getFont("previousPage.font"));		
        this.previousPage.setForeground(new java.awt.Color(0,0,0));
        this.previousPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    previousPage_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // nextPage		
        this.nextPage.setText(resHelper.getString("nextPage.text"));		
        this.nextPage.setFont(resHelper.getFont("nextPage.font"));		
        this.nextPage.setForeground(new java.awt.Color(0,0,0));
        this.nextPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    nextPage_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // numberOfPages		
        this.numberOfPages.setText(resHelper.getString("numberOfPages.text"));		
        this.numberOfPages.setFont(resHelper.getFont("numberOfPages.font"));
        // clear		
        this.clear.setText(resHelper.getString("clear.text"));		
        this.clear.setFont(resHelper.getFont("clear.font"));		
        this.clear.setForeground(new java.awt.Color(0,0,0));
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
        this.kDLabel1.setForeground(new java.awt.Color(255,128,128));
        // weight		
        this.weight.setFont(resHelper.getFont("weight.font"));
        this.weight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    weight_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // kDLabel2		
        this.kDLabel2.setText(resHelper.getString("kDLabel2.text"));		
        this.kDLabel2.setFont(resHelper.getFont("kDLabel2.font"));		
        this.kDLabel2.setBackground(new java.awt.Color(255,0,0));		
        this.kDLabel2.setForeground(new java.awt.Color(255,128,128));
        // kDWorkButton2		
        this.kDWorkButton2.setText(resHelper.getString("kDWorkButton2.text"));		
        this.kDWorkButton2.setFont(resHelper.getFont("kDWorkButton2.font"));		
        this.kDWorkButton2.setForeground(new java.awt.Color(0,0,0));
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
        // kDLabel3		
        this.kDLabel3.setText(resHelper.getString("kDLabel3.text"));		
        this.kDLabel3.setFont(resHelper.getFont("kDLabel3.font"));
        // measureType		
        this.measureType.setFont(resHelper.getFont("measureType.font"));
        // materials		
        this.materials.setEnabled(false);		
        this.materials.setFont(resHelper.getFont("materials.font"));
        this.materials.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    materials_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // bb1		
        this.bb1.setText(resHelper.getString("bb1.text"));		
        this.bb1.setFont(resHelper.getFont("bb1.font"));		
        this.bb1.setForeground(new java.awt.Color(0,0,0));
        this.bb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    bb1_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // bb3		
        this.bb3.setText(resHelper.getString("bb3.text"));		
        this.bb3.setFont(resHelper.getFont("bb3.font"));		
        this.bb3.setForeground(new java.awt.Color(0,0,0));
        this.bb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    bb3_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // bb6		
        this.bb6.setText(resHelper.getString("bb6.text"));		
        this.bb6.setFont(resHelper.getFont("bb6.font"));		
        this.bb6.setForeground(new java.awt.Color(0,0,0));
        this.bb6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    bb6_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // bb5		
        this.bb5.setText(resHelper.getString("bb5.text"));		
        this.bb5.setFont(resHelper.getFont("bb5.font"));		
        this.bb5.setForeground(new java.awt.Color(0,0,0));
        this.bb5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    bb5_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // bb4		
        this.bb4.setText(resHelper.getString("bb4.text"));		
        this.bb4.setFont(resHelper.getFont("bb4.font"));		
        this.bb4.setForeground(new java.awt.Color(0,0,0));
        this.bb4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    bb4_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // bb7		
        this.bb7.setText(resHelper.getString("bb7.text"));		
        this.bb7.setFont(resHelper.getFont("bb7.font"));		
        this.bb7.setForeground(new java.awt.Color(0,0,0));
        this.bb7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    bb7_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // bb9		
        this.bb9.setText(resHelper.getString("bb9.text"));		
        this.bb9.setFont(resHelper.getFont("bb9.font"));		
        this.bb9.setForeground(new java.awt.Color(0,0,0));
        this.bb9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    bb9_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // bb8		
        this.bb8.setText(resHelper.getString("bb8.text"));		
        this.bb8.setFont(resHelper.getFont("bb8.font"));		
        this.bb8.setForeground(new java.awt.Color(0,0,0));
        this.bb8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    bb8_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // bb2		
        this.bb2.setText(resHelper.getString("bb2.text"));		
        this.bb2.setFont(resHelper.getFont("bb2.font"));		
        this.bb2.setForeground(new java.awt.Color(0,0,0));
        this.bb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    bb2_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // bb0		
        this.bb0.setText(resHelper.getString("bb0.text"));		
        this.bb0.setFont(resHelper.getFont("bb0.font"));		
        this.bb0.setForeground(new java.awt.Color(0,0,0));
        this.bb0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    bb0_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // cancel		
        this.cancel.setText(resHelper.getString("cancel.text"));		
        this.cancel.setFont(resHelper.getFont("cancel.font"));		
        this.cancel.setForeground(new java.awt.Color(0,0,0));
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
        // affirm		
        this.affirm.setText(resHelper.getString("affirm.text"));		
        this.affirm.setFont(resHelper.getFont("affirm.font"));		
        this.affirm.setForeground(new java.awt.Color(255,0,0));
        this.affirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    affirm_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // minus		
        this.minus.setText(resHelper.getString("minus.text"));		
        this.minus.setFont(resHelper.getFont("minus.font"));		
        this.minus.setForeground(new java.awt.Color(0,0,0));
        this.minus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    minus_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // spot		
        this.spot.setText(resHelper.getString("spot.text"));		
        this.spot.setFont(resHelper.getFont("spot.font"));		
        this.spot.setForeground(new java.awt.Color(0,0,0));
        this.spot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    spot_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // materialNumber		
        this.materialNumber.setText(resHelper.getString("materialNumber.text"));		
        this.materialNumber.setFont(resHelper.getFont("materialNumber.font"));
        // materialNumbers		
        this.materialNumbers.setFont(resHelper.getFont("materialNumbers.font"));
        // kDPanel2		
        this.kDPanel2.setFont(resHelper.getFont("kDPanel2.font"));
        // kDPanel3
        // kDPanel4
        // kDPanel5
        // kDPanel6
        // kDTable1
		String kDTable1StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol1\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"category\" t:width=\"180\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"materialNumber\" t:width=\"1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"basicUnit\" t:width=\"110\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"assistUnit\" t:width=\"1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"materialModel\" t:width=\"90\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" /><t:Column t:key=\"todayAddUp\" t:width=\"90\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{category}</t:Cell><t:Cell>$Resource{materialNumber}</t:Cell><t:Cell>$Resource{basicUnit}</t:Cell><t:Cell>$Resource{assistUnit}</t:Cell><t:Cell>$Resource{materialModel}</t:Cell><t:Cell>$Resource{todayAddUp}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kDTable1.setFormatXml(resHelper.translateString("kDTable1",kDTable1StrXML));

        

        // kDTable3
		String kDTable3StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol1\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"category\" t:width=\"180\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"materialNumber\" t:width=\"1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"basicUnit\" t:width=\"1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"assistUnit\" t:width=\"110\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"materialModel\" t:width=\"90\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" /><t:Column t:key=\"todayAddUp\" t:width=\"90\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{category}</t:Cell><t:Cell>$Resource{materialNumber}</t:Cell><t:Cell>$Resource{basicUnit}</t:Cell><t:Cell>$Resource{assistUnit}</t:Cell><t:Cell>$Resource{materialModel}</t:Cell><t:Cell>$Resource{todayAddUp}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kDTable3.setFormatXml(resHelper.translateString("kDTable3",kDTable3StrXML));

        

        // kDTable4
		String kDTable4StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol1\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"category\" t:width=\"180\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"materialNumber\" t:width=\"1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"basicUnit\" t:width=\"110\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"assistUnit\" t:width=\"1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"materialModel\" t:width=\"90\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" /><t:Column t:key=\"todayAddUp\" t:width=\"90\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{category}</t:Cell><t:Cell>$Resource{materialNumber}</t:Cell><t:Cell>$Resource{basicUnit}</t:Cell><t:Cell>$Resource{assistUnit}</t:Cell><t:Cell>$Resource{materialModel}</t:Cell><t:Cell>$Resource{todayAddUp}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kDTable4.setFormatXml(resHelper.translateString("kDTable4",kDTable4StrXML));

        

        // kDTable5
		String kDTable5StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol1\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"category\" t:width=\"180\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"materialNumber\" t:width=\"1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"basicUnit\" t:width=\"110\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"assistUnit\" t:width=\"1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"materialModel\" t:width=\"90\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" /><t:Column t:key=\"todayAddUp\" t:width=\"90\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{category}</t:Cell><t:Cell>$Resource{materialNumber}</t:Cell><t:Cell>$Resource{basicUnit}</t:Cell><t:Cell>$Resource{assistUnit}</t:Cell><t:Cell>$Resource{materialModel}</t:Cell><t:Cell>$Resource{todayAddUp}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kDTable5.setFormatXml(resHelper.translateString("kDTable5",kDTable5StrXML));

        

        // kDTable6
		String kDTable6StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol1\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"category\" t:width=\"180\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"materialNumber\" t:width=\"1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"basicUnit\" t:width=\"110\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"assistUnit\" t:width=\"1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"materialModel\" t:width=\"90\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" /><t:Column t:key=\"todayAddUp\" t:width=\"90\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{category}</t:Cell><t:Cell>$Resource{materialNumber}</t:Cell><t:Cell>$Resource{basicUnit}</t:Cell><t:Cell>$Resource{assistUnit}</t:Cell><t:Cell>$Resource{materialModel}</t:Cell><t:Cell>$Resource{todayAddUp}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kDTable6.setFormatXml(resHelper.translateString("kDTable6",kDTable6StrXML));

        

        // productDateF7
        this.productDateF7.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    productDateF7_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
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
        this.setBounds(new Rectangle(10, 10, 1000, 625));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(10, 10, 1000, 625));
        xl.setBounds(new Rectangle(2, 2, 90, 35));
        this.add(xl, new KDLayout.Constraints(2, 2, 90, 35, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        jjl.setBounds(new Rectangle(311, 2, 100, 35));
        this.add(jjl, new KDLayout.Constraints(311, 2, 100, 35, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        qt.setBounds(new Rectangle(427, 2, 90, 35));
        this.add(qt, new KDLayout.Constraints(427, 2, 90, 35, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        tl.setBounds(new Rectangle(105, 2, 90, 35));
        this.add(tl, new KDLayout.Constraints(105, 2, 90, 35, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        cl.setBounds(new Rectangle(208, 2, 90, 35));
        this.add(cl, new KDLayout.Constraints(208, 2, 90, 35, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        material.setBounds(new Rectangle(803, 71, 195, 48));
        this.add(material, new KDLayout.Constraints(803, 71, 195, 48, 0));
        kDPanel1.setBounds(new Rectangle(521, 220, 477, 393));
        this.add(kDPanel1, new KDLayout.Constraints(521, 220, 477, 393, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDTabbedPane1.setBounds(new Rectangle(1, 56, 516, 496));
        this.add(kDTabbedPane1, new KDLayout.Constraints(1, 56, 516, 496, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        HouseName.setBounds(new Rectangle(604, 164, 189, 20));
        this.add(HouseName, new KDLayout.Constraints(604, 164, 189, 20, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        strokeCounterName.setBounds(new Rectangle(536, 191, 68, 19));
        this.add(strokeCounterName, new KDLayout.Constraints(536, 191, 68, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        strokeCounters.setBounds(new Rectangle(604, 191, 140, 20));
        this.add(strokeCounters, new KDLayout.Constraints(604, 191, 140, 20, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabel4.setBounds(new Rectangle(536, 164, 49, 19));
        this.add(kDLabel4, new KDLayout.Constraints(536, 164, 49, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabel5.setBounds(new Rectangle(536, 138, 83, 19));
        this.add(kDLabel5, new KDLayout.Constraints(536, 138, 83, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        strokeName.setBounds(new Rectangle(919, 52, 79, 19));
        this.add(strokeName, new KDLayout.Constraints(919, 52, 79, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        strokePosts.setBounds(new Rectangle(604, 138, 189, 20));
        this.add(strokePosts, new KDLayout.Constraints(604, 138, 189, 20, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        deleteButton.setBounds(new Rectangle(901, 121, 97, 26));
        this.add(deleteButton, new KDLayout.Constraints(901, 121, 97, 26, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        HyBtn.setBounds(new Rectangle(748, 87, 40, 30));
        this.add(HyBtn, new KDLayout.Constraints(748, 87, 40, 30, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        QyBtn.setBounds(new Rectangle(524, 86, 40, 30));
        this.add(QyBtn, new KDLayout.Constraints(524, 86, 40, 30, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDate.setBounds(new Rectangle(566, 95, 179, 19));
        this.add(contDate, new KDLayout.Constraints(566, 95, 179, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTable2.setBounds(new Rectangle(521, 2, 477, 118));
        this.add(kDTable2, new KDLayout.Constraints(521, 2, 477, 118, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        finishedProductType.setBounds(new Rectangle(745, 123, 63, 27));
        this.add(finishedProductType, new KDLayout.Constraints(745, 123, 63, 27, 0));
        previousPage.setBounds(new Rectangle(44, 564, 100, 35));
        this.add(previousPage, new KDLayout.Constraints(44, 564, 100, 35, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        nextPage.setBounds(new Rectangle(379, 564, 100, 35));
        this.add(nextPage, new KDLayout.Constraints(379, 564, 100, 35, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        numberOfPages.setBounds(new Rectangle(246, 564, 30, 35));
        this.add(numberOfPages, new KDLayout.Constraints(246, 564, 30, 35, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(521, 220, 477, 393));        clear.setBounds(new Rectangle(10, 223, 100, 47));
        kDPanel1.add(clear, new KDLayout.Constraints(10, 223, 100, 47, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabel1.setBounds(new Rectangle(15, 51, 95, 40));
        kDPanel1.add(kDLabel1, new KDLayout.Constraints(15, 51, 95, 40, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        weight.setBounds(new Rectangle(96, 56, 317, 30));
        kDPanel1.add(weight, new KDLayout.Constraints(96, 56, 317, 30, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabel2.setBounds(new Rectangle(15, 12, 95, 40));
        kDPanel1.add(kDLabel2, new KDLayout.Constraints(15, 12, 95, 40, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDWorkButton2.setBounds(new Rectangle(10, 329, 100, 47));
        kDPanel1.add(kDWorkButton2, new KDLayout.Constraints(10, 329, 100, 47, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabel3.setBounds(new Rectangle(14, 87, 140, 40));
        kDPanel1.add(kDLabel3, new KDLayout.Constraints(14, 87, 140, 40, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        measureType.setBounds(new Rectangle(13, 121, 206, 41));
        kDPanel1.add(measureType, new KDLayout.Constraints(13, 121, 206, 41, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        materials.setBounds(new Rectangle(96, 17, 317, 30));
        kDPanel1.add(materials, new KDLayout.Constraints(96, 17, 317, 30, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        bb1.setBounds(new Rectangle(127, 276, 100, 47));
        kDPanel1.add(bb1, new KDLayout.Constraints(127, 276, 100, 47, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        bb3.setBounds(new Rectangle(363, 276, 100, 47));
        kDPanel1.add(bb3, new KDLayout.Constraints(363, 276, 100, 47, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        bb6.setBounds(new Rectangle(363, 223, 100, 47));
        kDPanel1.add(bb6, new KDLayout.Constraints(363, 223, 100, 47, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        bb5.setBounds(new Rectangle(244, 223, 100, 47));
        kDPanel1.add(bb5, new KDLayout.Constraints(244, 223, 100, 47, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        bb4.setBounds(new Rectangle(127, 223, 100, 47));
        kDPanel1.add(bb4, new KDLayout.Constraints(127, 223, 100, 47, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        bb7.setBounds(new Rectangle(127, 170, 100, 47));
        kDPanel1.add(bb7, new KDLayout.Constraints(127, 170, 100, 47, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        bb9.setBounds(new Rectangle(363, 170, 100, 47));
        kDPanel1.add(bb9, new KDLayout.Constraints(363, 170, 100, 47, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        bb8.setBounds(new Rectangle(244, 170, 100, 47));
        kDPanel1.add(bb8, new KDLayout.Constraints(244, 170, 100, 47, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        bb2.setBounds(new Rectangle(244, 276, 100, 47));
        kDPanel1.add(bb2, new KDLayout.Constraints(244, 276, 100, 47, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        bb0.setBounds(new Rectangle(127, 329, 100, 47));
        kDPanel1.add(bb0, new KDLayout.Constraints(127, 329, 100, 47, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        cancel.setBounds(new Rectangle(10, 170, 100, 47));
        kDPanel1.add(cancel, new KDLayout.Constraints(10, 170, 100, 47, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        affirm.setBounds(new Rectangle(363, 329, 100, 47));
        kDPanel1.add(affirm, new KDLayout.Constraints(363, 329, 100, 47, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        minus.setBounds(new Rectangle(10, 276, 100, 47));
        kDPanel1.add(minus, new KDLayout.Constraints(10, 276, 100, 47, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        spot.setBounds(new Rectangle(244, 329, 100, 47));
        kDPanel1.add(spot, new KDLayout.Constraints(244, 329, 100, 47, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        materialNumber.setBounds(new Rectangle(252, 87, 192, 40));
        kDPanel1.add(materialNumber, new KDLayout.Constraints(252, 87, 192, 40, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        materialNumbers.setBounds(new Rectangle(252, 121, 192, 40));
        kDPanel1.add(materialNumbers, new KDLayout.Constraints(252, 121, 192, 40, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        kDTabbedPane1.add(kDPanel4, resHelper.getString("kDPanel4.constraints"));
        kDTabbedPane1.add(kDPanel5, resHelper.getString("kDPanel5.constraints"));
        kDTabbedPane1.add(kDPanel6, resHelper.getString("kDPanel6.constraints"));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 515, 463));        kDTable1.setBounds(new Rectangle(0, 0, 510, 462));
        kDPanel2.add(kDTable1, new KDLayout.Constraints(0, 0, 510, 462, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel3
        kDPanel3.setLayout(new KDLayout());
        kDPanel3.putClientProperty("OriginalBounds", new Rectangle(0, 0, 515, 463));        kDTable3.setBounds(new Rectangle(0, 0, 510, 462));
        kDPanel3.add(kDTable3, new KDLayout.Constraints(0, 0, 510, 462, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel4
        kDPanel4.setLayout(new KDLayout());
        kDPanel4.putClientProperty("OriginalBounds", new Rectangle(0, 0, 515, 463));        kDTable4.setBounds(new Rectangle(0, 0, 510, 462));
        kDPanel4.add(kDTable4, new KDLayout.Constraints(0, 0, 510, 462, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel5
        kDPanel5.setLayout(new KDLayout());
        kDPanel5.putClientProperty("OriginalBounds", new Rectangle(0, 0, 515, 463));        kDTable5.setBounds(new Rectangle(0, 0, 510, 462));
        kDPanel5.add(kDTable5, new KDLayout.Constraints(0, 0, 510, 462, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel6
        kDPanel6.setLayout(new KDLayout());
        kDPanel6.putClientProperty("OriginalBounds", new Rectangle(0, 0, 515, 463));        kDTable6.setBounds(new Rectangle(0, 0, 510, 462));
        kDPanel6.add(kDTable6, new KDLayout.Constraints(0, 0, 510, 462, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contDate
        contDate.setBoundEditor(productDateF7);

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
	    return "com.kingdee.eas.custom.szcount.app.Copy_SzSemiCountMobileUIHandler";
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
     * output xl_actionPerformed method
     */
    protected void xl_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output cl_actionPerformed method
     */
    protected void cl_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output strokePosts_actionPerformed method
     */
    protected void strokePosts_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output deleteButton_actionPerformed method
     */
    protected void deleteButton_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output HyBtn_actionPerformed method
     */
    protected void HyBtn_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output QyBtn_actionPerformed method
     */
    protected void QyBtn_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output previousPage_actionPerformed method
     */
    protected void previousPage_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output nextPage_actionPerformed method
     */
    protected void nextPage_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output clear_actionPerformed method
     */
    protected void clear_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output weight_actionPerformed method
     */
    protected void weight_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output print_actionPerformed method
     */
    protected void print_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output materials_actionPerformed method
     */
    protected void materials_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output bb1_actionPerformed method
     */
    protected void bb1_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output bb3_actionPerformed method
     */
    protected void bb3_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output bb6_actionPerformed method
     */
    protected void bb6_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output bb5_actionPerformed method
     */
    protected void bb5_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output bb4_actionPerformed method
     */
    protected void bb4_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output bb7_actionPerformed method
     */
    protected void bb7_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output bb9_actionPerformed method
     */
    protected void bb9_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output bb8_actionPerformed method
     */
    protected void bb8_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output bb2_actionPerformed method
     */
    protected void bb2_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output bb0_actionPerformed method
     */
    protected void bb0_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output cancel_actionPerformed method
     */
    protected void cancel_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output affirm_actionPerformed method
     */
    protected void affirm_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output minus_actionPerformed method
     */
    protected void minus_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output spot_actionPerformed method
     */
    protected void spot_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output productDateF7_dataChanged method
     */
    protected void productDateF7_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
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
    	

    /**
     * output actionxlselect_actionPerformed method
     */
    public void actionxlselect_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actiontlselect_actionPerformed method
     */
    public void actiontlselect_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionclselect_actionPerformed method
     */
    public void actionclselect_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionjjlselect_actionPerformed method
     */
    public void actionjjlselect_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionqtselect_actionPerformed method
     */
    public void actionqtselect_actionPerformed(ActionEvent e) throws Exception
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
	public RequestContext prepareactionxlselect(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareactionxlselect() {
    	return false;
    }
	public RequestContext prepareactiontlselect(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareactiontlselect() {
    	return false;
    }
	public RequestContext prepareactionclselect(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareactionclselect() {
    	return false;
    }
	public RequestContext prepareactionjjlselect(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareactionjjlselect() {
    	return false;
    }
	public RequestContext prepareactionqtselect(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareactionqtselect() {
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
            innerActionPerformed("eas", AbstractCopy_SzSemiCountMobileUI.this, "ActionQY", "actionQY_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractCopy_SzSemiCountMobileUI.this, "ActionHY", "actionHY_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractCopy_SzSemiCountMobileUI.this, "ActionCheck", "actionCheck_actionPerformed", e);
        }
    }

    /**
     * output actionxlselect class
     */     
    protected class actionxlselect extends ItemAction {     
    
        public actionxlselect()
        {
            this(null);
        }

        public actionxlselect(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("actionxlselect.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("actionxlselect.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("actionxlselect.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_SzSemiCountMobileUI.this, "actionxlselect", "actionxlselect_actionPerformed", e);
        }
    }

    /**
     * output actiontlselect class
     */     
    protected class actiontlselect extends ItemAction {     
    
        public actiontlselect()
        {
            this(null);
        }

        public actiontlselect(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("actiontlselect.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("actiontlselect.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("actiontlselect.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_SzSemiCountMobileUI.this, "actiontlselect", "actiontlselect_actionPerformed", e);
        }
    }

    /**
     * output actionclselect class
     */     
    protected class actionclselect extends ItemAction {     
    
        public actionclselect()
        {
            this(null);
        }

        public actionclselect(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("actionclselect.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("actionclselect.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("actionclselect.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_SzSemiCountMobileUI.this, "actionclselect", "actionclselect_actionPerformed", e);
        }
    }

    /**
     * output actionjjlselect class
     */     
    protected class actionjjlselect extends ItemAction {     
    
        public actionjjlselect()
        {
            this(null);
        }

        public actionjjlselect(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("actionjjlselect.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("actionjjlselect.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("actionjjlselect.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_SzSemiCountMobileUI.this, "actionjjlselect", "actionjjlselect_actionPerformed", e);
        }
    }

    /**
     * output actionqtselect class
     */     
    protected class actionqtselect extends ItemAction {     
    
        public actionqtselect()
        {
            this(null);
        }

        public actionqtselect(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("actionqtselect.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("actionqtselect.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("actionqtselect.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCopy_SzSemiCountMobileUI.this, "actionqtselect", "actionqtselect_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.szcount.client", "Copy_SzSemiCountMobileUI");
    }




}