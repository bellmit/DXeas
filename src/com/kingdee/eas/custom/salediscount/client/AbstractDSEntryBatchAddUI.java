/**
 * output package name
 */
package com.kingdee.eas.custom.salediscount.client;

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
public abstract class AbstractDSEntryBatchAddUI extends com.kingdee.eas.framework.client.CoreUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractDSEntryBatchAddUI.class);
    protected com.kingdee.bos.ctrl.swing.KDToolBar kDToolBar1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDButton btnConfirm;
    protected com.kingdee.bos.ctrl.swing.KDButton btnUnSelectAllCustomer;
    protected com.kingdee.bos.ctrl.swing.KDButton btnRemoveCustomer;
    protected com.kingdee.bos.ctrl.swing.KDButton btnSelectAllCustomer;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtCustomer;
    protected com.kingdee.bos.ctrl.swing.KDButton btnUnSelectAllMaterial;
    protected com.kingdee.bos.ctrl.swing.KDButton btnSelectAllMaterial;
    protected com.kingdee.bos.ctrl.swing.KDButton btnRemoveMaterial;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtMaterial;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCustomer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtMaterial;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer lbQty1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer lbQty2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer lbStandard2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer lbSwQty1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer lbSwStandard1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer lbSwQty2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer lbSwStandard4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer lbQty3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer lbStandard1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer lbSwStandard3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer lbSwStandard2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer lbStandard3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer lbSwQty3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer lbQty4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer lbStandard4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer lbSwQty4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer lbQty5;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer lbStandard5;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer lbSwStandard5;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer lbSwQty5;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer14;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfQty1;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfQty2;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfStandard2;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfSwQty1;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfSwStandard1;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfSwQty2;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfSwStandard4;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfQty3;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfStandard1;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfSwStandard3;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfSwStandard2;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfStandard3;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfSwQty3;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfQty4;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfStandard4;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfSwQty4;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfQty5;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfStandard5;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfSwStandard5;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfSwQty5;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtMaterialGroup;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer7;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer8;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer9;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfQtyLimit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfSDLimit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfSaleAmountLimit;
    /**
     * output class constructor
     */
    public AbstractDSEntryBatchAddUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractDSEntryBatchAddUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDToolBar1 = new com.kingdee.bos.ctrl.swing.KDToolBar();
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnConfirm = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnUnSelectAllCustomer = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnRemoveCustomer = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnSelectAllCustomer = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kdtCustomer = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.btnUnSelectAllMaterial = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnSelectAllMaterial = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnRemoveMaterial = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kdtMaterial = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.prmtCustomer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtMaterial = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.lbQty1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.lbQty2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.lbStandard2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.lbSwQty1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.lbSwStandard1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.lbSwQty2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.lbSwStandard4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.lbQty3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.lbStandard1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.lbSwStandard3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.lbSwStandard2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.lbStandard3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.lbSwQty3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.lbQty4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.lbStandard4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.lbSwQty4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.lbQty5 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.lbStandard5 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.lbSwStandard5 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.lbSwQty5 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer14 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.ftfQty1 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfQty2 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfStandard2 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfSwQty1 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfSwStandard1 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfSwQty2 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfSwStandard4 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfQty3 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfStandard1 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfSwStandard3 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfSwStandard2 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfStandard3 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfSwQty3 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfQty4 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfStandard4 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfSwQty4 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfQty5 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfStandard5 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfSwStandard5 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfSwQty5 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtMaterialGroup = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDLabelContainer7 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer8 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer9 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.ftfQtyLimit = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfSDLimit = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfSaleAmountLimit = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDToolBar1.setName("kDToolBar1");
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.btnConfirm.setName("btnConfirm");
        this.btnUnSelectAllCustomer.setName("btnUnSelectAllCustomer");
        this.btnRemoveCustomer.setName("btnRemoveCustomer");
        this.btnSelectAllCustomer.setName("btnSelectAllCustomer");
        this.kdtCustomer.setName("kdtCustomer");
        this.btnUnSelectAllMaterial.setName("btnUnSelectAllMaterial");
        this.btnSelectAllMaterial.setName("btnSelectAllMaterial");
        this.btnRemoveMaterial.setName("btnRemoveMaterial");
        this.kdtMaterial.setName("kdtMaterial");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.prmtCustomer.setName("prmtCustomer");
        this.prmtMaterial.setName("prmtMaterial");
        this.lbQty1.setName("lbQty1");
        this.lbQty2.setName("lbQty2");
        this.lbStandard2.setName("lbStandard2");
        this.lbSwQty1.setName("lbSwQty1");
        this.lbSwStandard1.setName("lbSwStandard1");
        this.lbSwQty2.setName("lbSwQty2");
        this.lbSwStandard4.setName("lbSwStandard4");
        this.lbQty3.setName("lbQty3");
        this.lbStandard1.setName("lbStandard1");
        this.lbSwStandard3.setName("lbSwStandard3");
        this.lbSwStandard2.setName("lbSwStandard2");
        this.lbStandard3.setName("lbStandard3");
        this.lbSwQty3.setName("lbSwQty3");
        this.lbQty4.setName("lbQty4");
        this.lbStandard4.setName("lbStandard4");
        this.lbSwQty4.setName("lbSwQty4");
        this.lbQty5.setName("lbQty5");
        this.lbStandard5.setName("lbStandard5");
        this.lbSwStandard5.setName("lbSwStandard5");
        this.lbSwQty5.setName("lbSwQty5");
        this.kDLabelContainer14.setName("kDLabelContainer14");
        this.ftfQty1.setName("ftfQty1");
        this.ftfQty2.setName("ftfQty2");
        this.ftfStandard2.setName("ftfStandard2");
        this.ftfSwQty1.setName("ftfSwQty1");
        this.ftfSwStandard1.setName("ftfSwStandard1");
        this.ftfSwQty2.setName("ftfSwQty2");
        this.ftfSwStandard4.setName("ftfSwStandard4");
        this.ftfQty3.setName("ftfQty3");
        this.ftfStandard1.setName("ftfStandard1");
        this.ftfSwStandard3.setName("ftfSwStandard3");
        this.ftfSwStandard2.setName("ftfSwStandard2");
        this.ftfStandard3.setName("ftfStandard3");
        this.ftfSwQty3.setName("ftfSwQty3");
        this.ftfQty4.setName("ftfQty4");
        this.ftfStandard4.setName("ftfStandard4");
        this.ftfSwQty4.setName("ftfSwQty4");
        this.ftfQty5.setName("ftfQty5");
        this.ftfStandard5.setName("ftfStandard5");
        this.ftfSwStandard5.setName("ftfSwStandard5");
        this.ftfSwQty5.setName("ftfSwQty5");
        this.prmtMaterialGroup.setName("prmtMaterialGroup");
        this.kDLabelContainer7.setName("kDLabelContainer7");
        this.kDLabelContainer8.setName("kDLabelContainer8");
        this.kDLabelContainer9.setName("kDLabelContainer9");
        this.ftfQtyLimit.setName("ftfQtyLimit");
        this.ftfSDLimit.setName("ftfSDLimit");
        this.ftfSaleAmountLimit.setName("ftfSaleAmountLimit");
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
        // kDToolBar1
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelUnderline(true);		
        this.kDLabelContainer1.setBoundLabelLength(100);
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelUnderline(true);		
        this.kDLabelContainer2.setBoundLabelLength(100);
        // btnConfirm		
        this.btnConfirm.setText(resHelper.getString("btnConfirm.text"));
        this.btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnConfirm_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnUnSelectAllCustomer		
        this.btnUnSelectAllCustomer.setText(resHelper.getString("btnUnSelectAllCustomer.text"));
        this.btnUnSelectAllCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnUnSelectAllCustomer_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnRemoveCustomer		
        this.btnRemoveCustomer.setText(resHelper.getString("btnRemoveCustomer.text"));
        this.btnRemoveCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnRemoveCustomer_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnSelectAllCustomer		
        this.btnSelectAllCustomer.setText(resHelper.getString("btnSelectAllCustomer.text"));
        this.btnSelectAllCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnSelectAllCustomer_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // kdtCustomer
		String kdtCustomerStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"customerID\" t:width=\"0\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"selected\" t:width=\"50\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"1\" /><t:Column t:key=\"number\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"2\" t:styleID=\"sCol2\" /><t:Column t:key=\"name\" t:width=\"300\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"3\" t:styleID=\"sCol3\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{customerID}</t:Cell><t:Cell>$Resource{selected}</t:Cell><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{name}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtCustomer.setFormatXml(resHelper.translateString("kdtCustomer",kdtCustomerStrXML));

        

        // btnUnSelectAllMaterial		
        this.btnUnSelectAllMaterial.setText(resHelper.getString("btnUnSelectAllMaterial.text"));
        this.btnUnSelectAllMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnUnSelectAllMaterial_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnSelectAllMaterial		
        this.btnSelectAllMaterial.setText(resHelper.getString("btnSelectAllMaterial.text"));
        this.btnSelectAllMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnSelectAllMaterial_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnRemoveMaterial		
        this.btnRemoveMaterial.setText(resHelper.getString("btnRemoveMaterial.text"));
        this.btnRemoveMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnRemoveMaterial_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // kdtMaterial
		String kdtMaterialStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"materialID\" t:width=\"0\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"selected\" t:width=\"50\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"number\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"name\" t:width=\"300\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{materialID}</t:Cell><t:Cell>$Resource{selected}</t:Cell><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{name}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtMaterial.setFormatXml(resHelper.translateString("kdtMaterial",kdtMaterialStrXML));

        

        // kDPanel1		
        this.kDPanel1.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel1.border.title")));
        // kDPanel2		
        this.kDPanel2.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel2.border.title")));
        // prmtCustomer
        this.prmtCustomer.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtCustomer_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // prmtMaterial
        this.prmtMaterial.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtMaterial_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // lbQty1		
        this.lbQty1.setBoundLabelText(resHelper.getString("lbQty1.boundLabelText"));		
        this.lbQty1.setBoundLabelUnderline(true);		
        this.lbQty1.setBoundLabelLength(50);
        // lbQty2		
        this.lbQty2.setBoundLabelText(resHelper.getString("lbQty2.boundLabelText"));		
        this.lbQty2.setBoundLabelUnderline(true);		
        this.lbQty2.setBoundLabelLength(50);
        // lbStandard2		
        this.lbStandard2.setBoundLabelText(resHelper.getString("lbStandard2.boundLabelText"));		
        this.lbStandard2.setBoundLabelUnderline(true);		
        this.lbStandard2.setBoundLabelLength(50);
        // lbSwQty1		
        this.lbSwQty1.setBoundLabelText(resHelper.getString("lbSwQty1.boundLabelText"));		
        this.lbSwQty1.setBoundLabelUnderline(true);		
        this.lbSwQty1.setBoundLabelLength(70);
        // lbSwStandard1		
        this.lbSwStandard1.setBoundLabelText(resHelper.getString("lbSwStandard1.boundLabelText"));		
        this.lbSwStandard1.setBoundLabelUnderline(true);		
        this.lbSwStandard1.setBoundLabelLength(70);
        // lbSwQty2		
        this.lbSwQty2.setBoundLabelText(resHelper.getString("lbSwQty2.boundLabelText"));		
        this.lbSwQty2.setBoundLabelUnderline(true);		
        this.lbSwQty2.setBoundLabelLength(70);
        // lbSwStandard4		
        this.lbSwStandard4.setBoundLabelText(resHelper.getString("lbSwStandard4.boundLabelText"));		
        this.lbSwStandard4.setBoundLabelUnderline(true);		
        this.lbSwStandard4.setBoundLabelLength(70);
        // lbQty3		
        this.lbQty3.setBoundLabelText(resHelper.getString("lbQty3.boundLabelText"));		
        this.lbQty3.setBoundLabelUnderline(true);		
        this.lbQty3.setBoundLabelLength(50);
        // lbStandard1		
        this.lbStandard1.setBoundLabelText(resHelper.getString("lbStandard1.boundLabelText"));		
        this.lbStandard1.setBoundLabelUnderline(true);		
        this.lbStandard1.setBoundLabelLength(50);
        // lbSwStandard3		
        this.lbSwStandard3.setBoundLabelText(resHelper.getString("lbSwStandard3.boundLabelText"));		
        this.lbSwStandard3.setBoundLabelUnderline(true);		
        this.lbSwStandard3.setBoundLabelLength(70);
        // lbSwStandard2		
        this.lbSwStandard2.setBoundLabelText(resHelper.getString("lbSwStandard2.boundLabelText"));		
        this.lbSwStandard2.setBoundLabelUnderline(true);		
        this.lbSwStandard2.setBoundLabelLength(70);
        // lbStandard3		
        this.lbStandard3.setBoundLabelText(resHelper.getString("lbStandard3.boundLabelText"));		
        this.lbStandard3.setBoundLabelUnderline(true);		
        this.lbStandard3.setBoundLabelLength(50);
        // lbSwQty3		
        this.lbSwQty3.setBoundLabelText(resHelper.getString("lbSwQty3.boundLabelText"));		
        this.lbSwQty3.setBoundLabelUnderline(true);		
        this.lbSwQty3.setBoundLabelLength(70);
        // lbQty4		
        this.lbQty4.setBoundLabelText(resHelper.getString("lbQty4.boundLabelText"));		
        this.lbQty4.setBoundLabelUnderline(true);		
        this.lbQty4.setBoundLabelLength(50);
        // lbStandard4		
        this.lbStandard4.setBoundLabelText(resHelper.getString("lbStandard4.boundLabelText"));		
        this.lbStandard4.setBoundLabelLength(50);		
        this.lbStandard4.setBoundLabelUnderline(true);
        // lbSwQty4		
        this.lbSwQty4.setBoundLabelText(resHelper.getString("lbSwQty4.boundLabelText"));		
        this.lbSwQty4.setBoundLabelUnderline(true);		
        this.lbSwQty4.setBoundLabelLength(70);
        // lbQty5		
        this.lbQty5.setBoundLabelText(resHelper.getString("lbQty5.boundLabelText"));		
        this.lbQty5.setBoundLabelLength(50);		
        this.lbQty5.setBoundLabelUnderline(true);
        // lbStandard5		
        this.lbStandard5.setBoundLabelText(resHelper.getString("lbStandard5.boundLabelText"));		
        this.lbStandard5.setBoundLabelUnderline(true);		
        this.lbStandard5.setBoundLabelLength(50);
        // lbSwStandard5		
        this.lbSwStandard5.setBoundLabelText(resHelper.getString("lbSwStandard5.boundLabelText"));		
        this.lbSwStandard5.setBoundLabelUnderline(true);		
        this.lbSwStandard5.setBoundLabelLength(70);
        // lbSwQty5		
        this.lbSwQty5.setBoundLabelText(resHelper.getString("lbSwQty5.boundLabelText"));		
        this.lbSwQty5.setBoundLabelUnderline(true);		
        this.lbSwQty5.setBoundLabelLength(70);
        // kDLabelContainer14		
        this.kDLabelContainer14.setBoundLabelText(resHelper.getString("kDLabelContainer14.boundLabelText"));		
        this.kDLabelContainer14.setBoundLabelLength(50);		
        this.kDLabelContainer14.setBoundLabelUnderline(true);
        // ftfQty1		
        this.ftfQty1.setDataType(1);
        // ftfQty2		
        this.ftfQty2.setDataType(1);
        // ftfStandard2		
        this.ftfStandard2.setDataType(1);
        // ftfSwQty1		
        this.ftfSwQty1.setDataType(1);
        // ftfSwStandard1
        // ftfSwQty2		
        this.ftfSwQty2.setDataType(1);
        // ftfSwStandard4
        // ftfQty3		
        this.ftfQty3.setDataType(1);
        // ftfStandard1		
        this.ftfStandard1.setDataType(1);
        // ftfSwStandard3
        // ftfSwStandard2
        // ftfStandard3		
        this.ftfStandard3.setDataType(1);
        // ftfSwQty3		
        this.ftfSwQty3.setDataType(1);
        // ftfQty4		
        this.ftfQty4.setDataType(1);
        // ftfStandard4		
        this.ftfStandard4.setDataType(1);
        // ftfSwQty4		
        this.ftfSwQty4.setDataType(1);
        // ftfQty5		
        this.ftfQty5.setDataType(1);
        // ftfStandard5		
        this.ftfStandard5.setDataType(1);
        // ftfSwStandard5
        // ftfSwQty5		
        this.ftfSwQty5.setDataType(1);
        // prmtMaterialGroup
        // kDLabelContainer7		
        this.kDLabelContainer7.setBoundLabelText(resHelper.getString("kDLabelContainer7.boundLabelText"));		
        this.kDLabelContainer7.setBoundLabelUnderline(true);		
        this.kDLabelContainer7.setBoundLabelLength(100);
        // kDLabelContainer8		
        this.kDLabelContainer8.setBoundLabelText(resHelper.getString("kDLabelContainer8.boundLabelText"));		
        this.kDLabelContainer8.setBoundLabelUnderline(true);		
        this.kDLabelContainer8.setBoundLabelLength(100);
        // kDLabelContainer9		
        this.kDLabelContainer9.setBoundLabelText(resHelper.getString("kDLabelContainer9.boundLabelText"));		
        this.kDLabelContainer9.setBoundLabelUnderline(true);		
        this.kDLabelContainer9.setBoundLabelLength(100);
        // ftfQtyLimit
        // ftfSDLimit
        // ftfSaleAmountLimit
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
		list.add(this.kDToolBar1);
		return (com.kingdee.bos.ctrl.swing.KDToolBar[])list.toArray(new com.kingdee.bos.ctrl.swing.KDToolBar[list.size()]);
	}




    /**
     * output initUIContentLayout method
     */
    public void initUIContentLayout()
    {
        this.setBounds(new Rectangle(10, 10, 1013, 629));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(19, 188, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(511, 188, 270, 19));
        this.add(kDLabelContainer2, null);
        btnConfirm.setBounds(new Rectangle(865, 202, 94, 21));
        this.add(btnConfirm, null);
        btnUnSelectAllCustomer.setBounds(new Rectangle(102, 216, 73, 21));
        this.add(btnUnSelectAllCustomer, null);
        btnRemoveCustomer.setBounds(new Rectangle(185, 216, 73, 21));
        this.add(btnRemoveCustomer, null);
        btnSelectAllCustomer.setBounds(new Rectangle(19, 216, 73, 21));
        this.add(btnSelectAllCustomer, null);
        kdtCustomer.setBounds(new Rectangle(13, 244, 490, 374));
        this.add(kdtCustomer, null);
        btnUnSelectAllMaterial.setBounds(new Rectangle(596, 216, 73, 21));
        this.add(btnUnSelectAllMaterial, null);
        btnSelectAllMaterial.setBounds(new Rectangle(512, 216, 73, 21));
        this.add(btnSelectAllMaterial, null);
        btnRemoveMaterial.setBounds(new Rectangle(678, 216, 73, 21));
        this.add(btnRemoveMaterial, null);
        kdtMaterial.setBounds(new Rectangle(511, 244, 490, 374));
        this.add(kdtMaterial, null);
        kDPanel1.setBounds(new Rectangle(11, 10, 993, 115));
        this.add(kDPanel1, null);
        kDPanel2.setBounds(new Rectangle(12, 129, 995, 52));
        this.add(kDPanel2, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(prmtCustomer);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(prmtMaterial);
        //kDPanel1
        kDPanel1.setLayout(null);        lbQty1.setBounds(new Rectangle(11, 20, 156, 19));
        kDPanel1.add(lbQty1, null);
        lbQty2.setBounds(new Rectangle(495, 20, 156, 19));
        kDPanel1.add(lbQty2, null);
        lbStandard2.setBounds(new Rectangle(658, 20, 156, 19));
        kDPanel1.add(lbStandard2, null);
        lbSwQty1.setBounds(new Rectangle(174, 20, 156, 19));
        kDPanel1.add(lbSwQty1, null);
        lbSwStandard1.setBounds(new Rectangle(335, 20, 156, 19));
        kDPanel1.add(lbSwStandard1, null);
        lbSwQty2.setBounds(new Rectangle(658, 20, 156, 19));
        kDPanel1.add(lbSwQty2, null);
        lbSwStandard4.setBounds(new Rectangle(820, 49, 156, 19));
        kDPanel1.add(lbSwStandard4, null);
        lbQty3.setBounds(new Rectangle(11, 49, 156, 19));
        kDPanel1.add(lbQty3, null);
        lbStandard1.setBounds(new Rectangle(174, 20, 156, 19));
        kDPanel1.add(lbStandard1, null);
        lbSwStandard3.setBounds(new Rectangle(335, 49, 156, 19));
        kDPanel1.add(lbSwStandard3, null);
        lbSwStandard2.setBounds(new Rectangle(820, 20, 156, 19));
        kDPanel1.add(lbSwStandard2, null);
        lbStandard3.setBounds(new Rectangle(174, 49, 156, 19));
        kDPanel1.add(lbStandard3, null);
        lbSwQty3.setBounds(new Rectangle(174, 49, 156, 19));
        kDPanel1.add(lbSwQty3, null);
        lbQty4.setBounds(new Rectangle(495, 49, 156, 19));
        kDPanel1.add(lbQty4, null);
        lbStandard4.setBounds(new Rectangle(658, 49, 156, 19));
        kDPanel1.add(lbStandard4, null);
        lbSwQty4.setBounds(new Rectangle(658, 49, 156, 19));
        kDPanel1.add(lbSwQty4, null);
        lbQty5.setBounds(new Rectangle(11, 79, 156, 19));
        kDPanel1.add(lbQty5, null);
        lbStandard5.setBounds(new Rectangle(174, 79, 156, 19));
        kDPanel1.add(lbStandard5, null);
        lbSwStandard5.setBounds(new Rectangle(335, 79, 156, 19));
        kDPanel1.add(lbSwStandard5, null);
        lbSwQty5.setBounds(new Rectangle(174, 79, 156, 19));
        kDPanel1.add(lbSwQty5, null);
        kDLabelContainer14.setBounds(new Rectangle(495, 79, 320, 19));
        kDPanel1.add(kDLabelContainer14, null);
        //lbQty1
        lbQty1.setBoundEditor(ftfQty1);
        //lbQty2
        lbQty2.setBoundEditor(ftfQty2);
        //lbStandard2
        lbStandard2.setBoundEditor(ftfStandard2);
        //lbSwQty1
        lbSwQty1.setBoundEditor(ftfSwQty1);
        //lbSwStandard1
        lbSwStandard1.setBoundEditor(ftfSwStandard1);
        //lbSwQty2
        lbSwQty2.setBoundEditor(ftfSwQty2);
        //lbSwStandard4
        lbSwStandard4.setBoundEditor(ftfSwStandard4);
        //lbQty3
        lbQty3.setBoundEditor(ftfQty3);
        //lbStandard1
        lbStandard1.setBoundEditor(ftfStandard1);
        //lbSwStandard3
        lbSwStandard3.setBoundEditor(ftfSwStandard3);
        //lbSwStandard2
        lbSwStandard2.setBoundEditor(ftfSwStandard2);
        //lbStandard3
        lbStandard3.setBoundEditor(ftfStandard3);
        //lbSwQty3
        lbSwQty3.setBoundEditor(ftfSwQty3);
        //lbQty4
        lbQty4.setBoundEditor(ftfQty4);
        //lbStandard4
        lbStandard4.setBoundEditor(ftfStandard4);
        //lbSwQty4
        lbSwQty4.setBoundEditor(ftfSwQty4);
        //lbQty5
        lbQty5.setBoundEditor(ftfQty5);
        //lbStandard5
        lbStandard5.setBoundEditor(ftfStandard5);
        //lbSwStandard5
        lbSwStandard5.setBoundEditor(ftfSwStandard5);
        //lbSwQty5
        lbSwQty5.setBoundEditor(ftfSwQty5);
        //kDLabelContainer14
        kDLabelContainer14.setBoundEditor(prmtMaterialGroup);
        //kDPanel2
        kDPanel2.setLayout(null);        kDLabelContainer7.setBounds(new Rectangle(18, 17, 270, 19));
        kDPanel2.add(kDLabelContainer7, null);
        kDLabelContainer8.setBounds(new Rectangle(330, 17, 270, 19));
        kDPanel2.add(kDLabelContainer8, null);
        kDLabelContainer9.setBounds(new Rectangle(643, 17, 270, 19));
        kDPanel2.add(kDLabelContainer9, null);
        //kDLabelContainer7
        kDLabelContainer7.setBoundEditor(ftfQtyLimit);
        //kDLabelContainer8
        kDLabelContainer8.setBoundEditor(ftfSDLimit);
        //kDLabelContainer9
        kDLabelContainer9.setBoundEditor(ftfSaleAmountLimit);

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
	    return "com.kingdee.eas.custom.salediscount.app.DSEntryBatchAddUIHandler";
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
     * output btnConfirm_actionPerformed method
     */
    protected void btnConfirm_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnUnSelectAllCustomer_actionPerformed method
     */
    protected void btnUnSelectAllCustomer_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnRemoveCustomer_actionPerformed method
     */
    protected void btnRemoveCustomer_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnSelectAllCustomer_actionPerformed method
     */
    protected void btnSelectAllCustomer_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnUnSelectAllMaterial_actionPerformed method
     */
    protected void btnUnSelectAllMaterial_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnSelectAllMaterial_actionPerformed method
     */
    protected void btnSelectAllMaterial_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnRemoveMaterial_actionPerformed method
     */
    protected void btnRemoveMaterial_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output prmtCustomer_dataChanged method
     */
    protected void prmtCustomer_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output prmtMaterial_dataChanged method
     */
    protected void prmtMaterial_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        //write your code here
    }


    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.salediscount.client", "DSEntryBatchAddUI");
    }




}