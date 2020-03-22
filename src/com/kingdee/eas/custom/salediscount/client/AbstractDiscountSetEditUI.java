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
public abstract class AbstractDiscountSetEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractDiscountSetEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contEffectiveDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contExpireDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contPriceComposition;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contPriceCompDetail;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDSplitPane kDSplitPane1;
    protected com.kingdee.bos.ctrl.swing.KDComboBox priceComposition;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contSaleOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdiscountType;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisEnableAim;
    protected com.kingdee.bos.ctrl.swing.KDButton btnCopyToEntries;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdsNameType;
    protected com.kingdee.bos.ctrl.swing.KDButton btnSetQtyStandard;
    protected com.kingdee.bos.ctrl.swing.KDButton btnSetLimit;
    protected com.kingdee.bos.ctrl.swing.KDButton btnEnableEntry;
    protected com.kingdee.bos.ctrl.swing.KDButton btnForbiddenEntry;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisLimitMerge;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnDisplayCustomer;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkbyMonthQtyLimit;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaccumulaEnddate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaccumulaBeginDate;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntries;
    protected com.kingdee.bos.ctrl.swing.KDComboBox comboPriceCompDetailMaterial;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisAllCustomer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkEffectiveDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkExpireDate;
    protected com.kingdee.bos.ctrl.swing.KDComboBox comboPriceCompDetailCustomer;
    protected com.kingdee.bos.ctrl.swing.KDComboBox comboCheckedStatus;
    protected com.kingdee.bos.ctrl.swing.KDComboBox comboBlockedStatus;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDTreeView kDTreeView1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDTree treeMain;
    protected com.kingdee.bos.ctrl.swing.KDComboBox comboCustomerGroupStandard;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkIncluded;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtSaleOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDComboBox discountType;
    protected com.kingdee.bos.ctrl.swing.KDComboBox dsNameType;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkaccumulaEnddate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkaccumulaBeginDate;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAuditEntries;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAuditEntries;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnBatchAddEntry;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnCopyEntry;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem menuItemQueryPriority;
    protected com.kingdee.eas.custom.salediscount.DiscountSetInfo editData = null;
    protected ActionAuditEntries actionAuditEntries = null;
    protected ActionUnAuditEntries actionUnAuditEntries = null;
    protected ActionCopyEntry actionCopyEntry = null;
    protected ActionPriorityQuery actionPriorityQuery = null;
    protected ActionBatchAddEntry actionBatchAddEntry = null;
    protected ActionEnableEntry actionEnableEntry = null;
    protected ActionForbiddenEntry actionForbiddenEntry = null;
    /**
     * output class constructor
     */
    public AbstractDiscountSetEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractDiscountSetEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        //actionAuditEntries
        this.actionAuditEntries = new ActionAuditEntries(this);
        getActionManager().registerAction("actionAuditEntries", actionAuditEntries);
        //actionUnAuditEntries
        this.actionUnAuditEntries = new ActionUnAuditEntries(this);
        getActionManager().registerAction("actionUnAuditEntries", actionUnAuditEntries);
        //actionCopyEntry
        this.actionCopyEntry = new ActionCopyEntry(this);
        getActionManager().registerAction("actionCopyEntry", actionCopyEntry);
         this.actionCopyEntry.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionPriorityQuery
        this.actionPriorityQuery = new ActionPriorityQuery(this);
        getActionManager().registerAction("actionPriorityQuery", actionPriorityQuery);
         this.actionPriorityQuery.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionBatchAddEntry
        this.actionBatchAddEntry = new ActionBatchAddEntry(this);
        getActionManager().registerAction("actionBatchAddEntry", actionBatchAddEntry);
        this.actionBatchAddEntry.setExtendProperty("canForewarn", "true");
        this.actionBatchAddEntry.setExtendProperty("userDefined", "true");
        this.actionBatchAddEntry.setExtendProperty("isObjectUpdateLock", "false");
         this.actionBatchAddEntry.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionBatchAddEntry.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionEnableEntry
        this.actionEnableEntry = new ActionEnableEntry(this);
        getActionManager().registerAction("actionEnableEntry", actionEnableEntry);
        this.actionEnableEntry.setExtendProperty("canForewarn", "true");
        this.actionEnableEntry.setExtendProperty("userDefined", "true");
        this.actionEnableEntry.setExtendProperty("isObjectUpdateLock", "false");
         this.actionEnableEntry.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionEnableEntry.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionForbiddenEntry
        this.actionForbiddenEntry = new ActionForbiddenEntry(this);
        getActionManager().registerAction("actionForbiddenEntry", actionForbiddenEntry);
        this.actionForbiddenEntry.setExtendProperty("canForewarn", "true");
        this.actionForbiddenEntry.setExtendProperty("userDefined", "true");
        this.actionForbiddenEntry.setExtendProperty("isObjectUpdateLock", "false");
         this.actionForbiddenEntry.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionForbiddenEntry.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contEffectiveDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contExpireDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contPriceComposition = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contPriceCompDetail = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSplitPane1 = new com.kingdee.bos.ctrl.swing.KDSplitPane();
        this.priceComposition = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.contSaleOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdiscountType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisEnableAim = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.btnCopyToEntries = new com.kingdee.bos.ctrl.swing.KDButton();
        this.contdsNameType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnSetQtyStandard = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnSetLimit = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnEnableEntry = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnForbiddenEntry = new com.kingdee.bos.ctrl.swing.KDButton();
        this.chkisLimitMerge = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.btnDisplayCustomer = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.chkbyMonthQtyLimit = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contaccumulaEnddate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contaccumulaBeginDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtEntries = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.comboPriceCompDetailMaterial = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.chkisAllCustomer = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkEffectiveDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkExpireDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.comboPriceCompDetailCustomer = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.comboCheckedStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.comboBlockedStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDTreeView1 = new com.kingdee.bos.ctrl.swing.KDTreeView();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.treeMain = new com.kingdee.bos.ctrl.swing.KDTree();
        this.comboCustomerGroupStandard = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.chkIncluded = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.prmtSaleOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.discountType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.dsNameType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.pkaccumulaEnddate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkaccumulaBeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.btnAuditEntries = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAuditEntries = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnBatchAddEntry = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnCopyEntry = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.menuItemQueryPriority = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.contName.setName("contName");
        this.contNumber.setName("contNumber");
        this.contEffectiveDate.setName("contEffectiveDate");
        this.contExpireDate.setName("contExpireDate");
        this.contPriceComposition.setName("contPriceComposition");
        this.contPriceCompDetail.setName("contPriceCompDetail");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDSplitPane1.setName("kDSplitPane1");
        this.priceComposition.setName("priceComposition");
        this.contSaleOrgUnit.setName("contSaleOrgUnit");
        this.contdiscountType.setName("contdiscountType");
        this.chkisEnableAim.setName("chkisEnableAim");
        this.btnCopyToEntries.setName("btnCopyToEntries");
        this.contdsNameType.setName("contdsNameType");
        this.btnSetQtyStandard.setName("btnSetQtyStandard");
        this.btnSetLimit.setName("btnSetLimit");
        this.btnEnableEntry.setName("btnEnableEntry");
        this.btnForbiddenEntry.setName("btnForbiddenEntry");
        this.chkisLimitMerge.setName("chkisLimitMerge");
        this.btnDisplayCustomer.setName("btnDisplayCustomer");
        this.chkbyMonthQtyLimit.setName("chkbyMonthQtyLimit");
        this.kDSeparator8.setName("kDSeparator8");
        this.contaccumulaEnddate.setName("contaccumulaEnddate");
        this.contaccumulaBeginDate.setName("contaccumulaBeginDate");
        this.kdtEntries.setName("kdtEntries");
        this.comboPriceCompDetailMaterial.setName("comboPriceCompDetailMaterial");
        this.chkisAllCustomer.setName("chkisAllCustomer");
        this.txtName.setName("txtName");
        this.txtNumber.setName("txtNumber");
        this.pkEffectiveDate.setName("pkEffectiveDate");
        this.pkExpireDate.setName("pkExpireDate");
        this.comboPriceCompDetailCustomer.setName("comboPriceCompDetailCustomer");
        this.comboCheckedStatus.setName("comboCheckedStatus");
        this.comboBlockedStatus.setName("comboBlockedStatus");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kDTreeView1.setName("kDTreeView1");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.treeMain.setName("treeMain");
        this.comboCustomerGroupStandard.setName("comboCustomerGroupStandard");
        this.chkIncluded.setName("chkIncluded");
        this.prmtSaleOrgUnit.setName("prmtSaleOrgUnit");
        this.discountType.setName("discountType");
        this.dsNameType.setName("dsNameType");
        this.pkaccumulaEnddate.setName("pkaccumulaEnddate");
        this.pkaccumulaBeginDate.setName("pkaccumulaBeginDate");
        this.btnAuditEntries.setName("btnAuditEntries");
        this.btnUnAuditEntries.setName("btnUnAuditEntries");
        this.btnBatchAddEntry.setName("btnBatchAddEntry");
        this.btnCopyEntry.setName("btnCopyEntry");
        this.menuItemQueryPriority.setName("menuItemQueryPriority");
        // CoreUI		
        this.setPreferredSize(new Dimension(1013,629));		
        this.menuBiz.setVisible(false);		
        this.btnTraceUp.setVisible(false);		
        this.btnTraceDown.setVisible(false);		
        this.btnCreateFrom.setVisible(false);		
        this.btnAuditResult.setVisible(false);		
        this.menuItemCreateFrom.setVisible(false);		
        this.menuItemCopyFrom.setVisible(false);		
        this.menuWorkflow.setVisible(false);
        // contName		
        this.contName.setBoundLabelText(resHelper.getString("contName.boundLabelText"));		
        this.contName.setBoundLabelLength(100);		
        this.contName.setBoundLabelUnderline(true);
        // contNumber		
        this.contNumber.setBoundLabelText(resHelper.getString("contNumber.boundLabelText"));		
        this.contNumber.setBoundLabelLength(100);		
        this.contNumber.setBoundLabelUnderline(true);
        // contEffectiveDate		
        this.contEffectiveDate.setBoundLabelText(resHelper.getString("contEffectiveDate.boundLabelText"));		
        this.contEffectiveDate.setBoundLabelLength(100);		
        this.contEffectiveDate.setBoundLabelUnderline(true);
        // contExpireDate		
        this.contExpireDate.setBoundLabelText(resHelper.getString("contExpireDate.boundLabelText"));		
        this.contExpireDate.setBoundLabelLength(100);		
        this.contExpireDate.setBoundLabelUnderline(true);
        // contPriceComposition		
        this.contPriceComposition.setBoundLabelText(resHelper.getString("contPriceComposition.boundLabelText"));		
        this.contPriceComposition.setBoundLabelLength(100);		
        this.contPriceComposition.setBoundLabelUnderline(true);		
        this.contPriceComposition.setVisible(false);		
        this.contPriceComposition.setEnabled(false);
        // contPriceCompDetail		
        this.contPriceCompDetail.setBoundLabelText(resHelper.getString("contPriceCompDetail.boundLabelText"));		
        this.contPriceCompDetail.setBoundLabelLength(1);		
        this.contPriceCompDetail.setBoundLabelUnderline(true);		
        this.contPriceCompDetail.setVisible(false);
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelLength(70);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);
        // kDLabelContainer3		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelLength(50);		
        this.kDLabelContainer3.setBoundLabelUnderline(true);
        // kDSplitPane1		
        this.kDSplitPane1.setDividerLocation(200);		
        this.kDSplitPane1.setVisible(false);		
        this.kDSplitPane1.setEnabled(false);
        // priceComposition		
        this.priceComposition.setVisible(false);		
        this.priceComposition.addItems(EnumUtils.getEnumList("com.kingdee.eas.basedata.scm.common.PriceCompositionEnum").toArray());
        // contSaleOrgUnit		
        this.contSaleOrgUnit.setBoundLabelText(resHelper.getString("contSaleOrgUnit.boundLabelText"));		
        this.contSaleOrgUnit.setBoundLabelLength(100);		
        this.contSaleOrgUnit.setBoundLabelUnderline(true);
        // contdiscountType		
        this.contdiscountType.setBoundLabelText(resHelper.getString("contdiscountType.boundLabelText"));		
        this.contdiscountType.setBoundLabelLength(100);		
        this.contdiscountType.setBoundLabelUnderline(true);		
        this.contdiscountType.setVisible(true);
        // chkisEnableAim		
        this.chkisEnableAim.setText(resHelper.getString("chkisEnableAim.text"));		
        this.chkisEnableAim.setHorizontalAlignment(2);		
        this.chkisEnableAim.setEnabled(false);		
        this.chkisEnableAim.setVisible(false);
        // btnCopyToEntries		
        this.btnCopyToEntries.setText(resHelper.getString("btnCopyToEntries.text"));
        this.btnCopyToEntries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnCopyToEntries_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // contdsNameType		
        this.contdsNameType.setBoundLabelText(resHelper.getString("contdsNameType.boundLabelText"));		
        this.contdsNameType.setBoundLabelLength(100);		
        this.contdsNameType.setBoundLabelUnderline(true);		
        this.contdsNameType.setVisible(true);
        // btnSetQtyStandard		
        this.btnSetQtyStandard.setText(resHelper.getString("btnSetQtyStandard.text"));
        this.btnSetQtyStandard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnSetQtyStandard_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnSetLimit		
        this.btnSetLimit.setText(resHelper.getString("btnSetLimit.text"));
        this.btnSetLimit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnSetLimit_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnEnableEntry
        this.btnEnableEntry.setAction((IItemAction)ActionProxyFactory.getProxy(actionEnableEntry, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnEnableEntry.setText(resHelper.getString("btnEnableEntry.text"));
        this.btnEnableEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnEnableEntry_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnForbiddenEntry
        this.btnForbiddenEntry.setAction((IItemAction)ActionProxyFactory.getProxy(actionForbiddenEntry, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnForbiddenEntry.setText(resHelper.getString("btnForbiddenEntry.text"));
        this.btnForbiddenEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnForbiddenEntry_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // chkisLimitMerge		
        this.chkisLimitMerge.setText(resHelper.getString("chkisLimitMerge.text"));		
        this.chkisLimitMerge.setHorizontalAlignment(2);
        // btnDisplayCustomer		
        this.btnDisplayCustomer.setText(resHelper.getString("btnDisplayCustomer.text"));		
        this.btnDisplayCustomer.setVisible(false);
        this.btnDisplayCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnDisplayCustomer_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // chkbyMonthQtyLimit		
        this.chkbyMonthQtyLimit.setText(resHelper.getString("chkbyMonthQtyLimit.text"));		
        this.chkbyMonthQtyLimit.setHorizontalAlignment(2);
        this.chkbyMonthQtyLimit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    chkbyMonthQtyLimit_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // kDSeparator8
        // contaccumulaEnddate		
        this.contaccumulaEnddate.setBoundLabelText(resHelper.getString("contaccumulaEnddate.boundLabelText"));		
        this.contaccumulaEnddate.setBoundLabelLength(100);		
        this.contaccumulaEnddate.setBoundLabelUnderline(true);		
        this.contaccumulaEnddate.setVisible(true);
        // contaccumulaBeginDate		
        this.contaccumulaBeginDate.setBoundLabelText(resHelper.getString("contaccumulaBeginDate.boundLabelText"));		
        this.contaccumulaBeginDate.setBoundLabelLength(100);		
        this.contaccumulaBeginDate.setBoundLabelUnderline(true);		
        this.contaccumulaBeginDate.setVisible(true);
        // kdtEntries
		String kdtEntriesStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol8\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol9\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol10\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol16\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol17\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol18\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol19\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol20\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol21\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol22\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol23\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol24\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol25\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol26\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol27\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol28\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol29\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol30\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol31\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol32\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol33\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol36\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol37\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol38\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol39\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol40\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"accumulaMaterialGroup\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"customerNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"customerName\" t:width=\"250\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"materialNumber\" t:width=\"120\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"materialName\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"materialModel\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"asistProperty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"discountCondition\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"basicUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"discountUnitType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"qty1\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"swQty1\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"swStandard1\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"standard1\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"qty2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"swQty2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /><t:Column t:key=\"swStandard2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"standard2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"qty3\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol19\" /><t:Column t:key=\"swQty3\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol20\" /><t:Column t:key=\"swStandard3\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol21\" /><t:Column t:key=\"standard3\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol22\" /><t:Column t:key=\"qty4\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol23\" /><t:Column t:key=\"swQty4\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol24\" /><t:Column t:key=\"swStandard4\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol25\" /><t:Column t:key=\"standard4\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol26\" /><t:Column t:key=\"qty5\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol27\" /><t:Column t:key=\"swQty5\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol28\" /><t:Column t:key=\"swStandard5\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol29\" /><t:Column t:key=\"standard5\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol30\" /><t:Column t:key=\"qtyLimit\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol31\" /><t:Column t:key=\"sdLimit\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol32\" /><t:Column t:key=\"saleAmountLimit\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol33\" /><t:Column t:key=\"lockedState\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"currency\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol36\" /><t:Column t:key=\"effectiveDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol37\" /><t:Column t:key=\"expireDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol38\" /><t:Column t:key=\"saleLeadTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol39\" /><t:Column t:key=\"checkedStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol40\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{accumulaMaterialGroup}</t:Cell><t:Cell>$Resource{customerNumber}</t:Cell><t:Cell>$Resource{customerName}</t:Cell><t:Cell>$Resource{materialNumber}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{materialModel}</t:Cell><t:Cell>$Resource{asistProperty}</t:Cell><t:Cell>$Resource{discountCondition}</t:Cell><t:Cell>$Resource{basicUnit}</t:Cell><t:Cell>$Resource{discountUnitType}</t:Cell><t:Cell>$Resource{qty1}</t:Cell><t:Cell>$Resource{swQty1}</t:Cell><t:Cell>$Resource{swStandard1}</t:Cell><t:Cell>$Resource{standard1}</t:Cell><t:Cell>$Resource{qty2}</t:Cell><t:Cell>$Resource{swQty2}</t:Cell><t:Cell>$Resource{swStandard2}</t:Cell><t:Cell>$Resource{standard2}</t:Cell><t:Cell>$Resource{qty3}</t:Cell><t:Cell>$Resource{swQty3}</t:Cell><t:Cell>$Resource{swStandard3}</t:Cell><t:Cell>$Resource{standard3}</t:Cell><t:Cell>$Resource{qty4}</t:Cell><t:Cell>$Resource{swQty4}</t:Cell><t:Cell>$Resource{swStandard4}</t:Cell><t:Cell>$Resource{standard4}</t:Cell><t:Cell>$Resource{qty5}</t:Cell><t:Cell>$Resource{swQty5}</t:Cell><t:Cell>$Resource{swStandard5}</t:Cell><t:Cell>$Resource{standard5}</t:Cell><t:Cell>$Resource{qtyLimit}</t:Cell><t:Cell>$Resource{sdLimit}</t:Cell><t:Cell>$Resource{saleAmountLimit}</t:Cell><t:Cell>$Resource{lockedState}</t:Cell><t:Cell>$Resource{remark}</t:Cell><t:Cell>$Resource{currency}</t:Cell><t:Cell>$Resource{effectiveDate}</t:Cell><t:Cell>$Resource{expireDate}</t:Cell><t:Cell>$Resource{saleLeadTime}</t:Cell><t:Cell>$Resource{checkedStatus}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntries.setFormatXml(resHelper.translateString("kdtEntries",kdtEntriesStrXML));

                this.kdtEntries.putBindContents("editData",new String[] {"id","accumulaMaterialGroup","customer","customer.name","material","material.name","material.model","asistProperty","discountCondition","measureUnit","discountUnitType","qty1","swQty1","swStandard1","standard1","qty2","swQty2","swStandard2","standard2","qty3","swQty3","swStandard3","standard3","qty4","swQty4","swStandard4","standard4","qty5","swQty5","swStandard5","Standard5","qtyLimit","sdLimit","saleAmountLimit","lockedState","remark","currency","effectiveDate","expireDate","saleLeadTime","checkedStatus"});


        this.kdtEntries.checkParsed();
        final KDBizPromptBox kdtEntries_customerNumber_PromptBox = new KDBizPromptBox();
        kdtEntries_customerNumber_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.CustomerInfoQuery");
        kdtEntries_customerNumber_PromptBox.setVisible(true);
        kdtEntries_customerNumber_PromptBox.setEditable(true);
        kdtEntries_customerNumber_PromptBox.setDisplayFormat("$number$");
        kdtEntries_customerNumber_PromptBox.setEditFormat("$number$");
        kdtEntries_customerNumber_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntries_customerNumber_CellEditor = new KDTDefaultCellEditor(kdtEntries_customerNumber_PromptBox);
        this.kdtEntries.getColumn("customerNumber").setEditor(kdtEntries_customerNumber_CellEditor);
        ObjectValueRender kdtEntries_customerNumber_OVR = new ObjectValueRender();
        kdtEntries_customerNumber_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntries.getColumn("customerNumber").setRenderer(kdtEntries_customerNumber_OVR);
        final KDBizPromptBox kdtEntries_materialNumber_PromptBox = new KDBizPromptBox();
        kdtEntries_materialNumber_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtEntries_materialNumber_PromptBox.setVisible(true);
        kdtEntries_materialNumber_PromptBox.setEditable(true);
        kdtEntries_materialNumber_PromptBox.setDisplayFormat("$number$");
        kdtEntries_materialNumber_PromptBox.setEditFormat("$number$");
        kdtEntries_materialNumber_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntries_materialNumber_CellEditor = new KDTDefaultCellEditor(kdtEntries_materialNumber_PromptBox);
        this.kdtEntries.getColumn("materialNumber").setEditor(kdtEntries_materialNumber_CellEditor);
        ObjectValueRender kdtEntries_materialNumber_OVR = new ObjectValueRender();
        kdtEntries_materialNumber_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntries.getColumn("materialNumber").setRenderer(kdtEntries_materialNumber_OVR);
        KDTextField kdtEntries_materialModel_TextField = new KDTextField();
        kdtEntries_materialModel_TextField.setName("kdtEntries_materialModel_TextField");
        kdtEntries_materialModel_TextField.setMaxLength(255);
        KDTDefaultCellEditor kdtEntries_materialModel_CellEditor = new KDTDefaultCellEditor(kdtEntries_materialModel_TextField);
        this.kdtEntries.getColumn("materialModel").setEditor(kdtEntries_materialModel_CellEditor);
        final KDBizPromptBox kdtEntries_asistProperty_PromptBox = new KDBizPromptBox();
        kdtEntries_asistProperty_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7AsstAttrValueQuery");
        kdtEntries_asistProperty_PromptBox.setVisible(true);
        kdtEntries_asistProperty_PromptBox.setEditable(true);
        kdtEntries_asistProperty_PromptBox.setDisplayFormat("$number$");
        kdtEntries_asistProperty_PromptBox.setEditFormat("$number$");
        kdtEntries_asistProperty_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntries_asistProperty_CellEditor = new KDTDefaultCellEditor(kdtEntries_asistProperty_PromptBox);
        this.kdtEntries.getColumn("asistProperty").setEditor(kdtEntries_asistProperty_CellEditor);
        ObjectValueRender kdtEntries_asistProperty_OVR = new ObjectValueRender();
        kdtEntries_asistProperty_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntries.getColumn("asistProperty").setRenderer(kdtEntries_asistProperty_OVR);
        KDComboBox kdtEntries_discountCondition_ComboBox = new KDComboBox();
        kdtEntries_discountCondition_ComboBox.setName("kdtEntries_discountCondition_ComboBox");
        kdtEntries_discountCondition_ComboBox.setVisible(true);
        kdtEntries_discountCondition_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.basedata.scm.common.DiscountConditionEnum").toArray());
        KDTDefaultCellEditor kdtEntries_discountCondition_CellEditor = new KDTDefaultCellEditor(kdtEntries_discountCondition_ComboBox);
        this.kdtEntries.getColumn("discountCondition").setEditor(kdtEntries_discountCondition_CellEditor);
        final KDBizPromptBox kdtEntries_basicUnit_PromptBox = new KDBizPromptBox();
        kdtEntries_basicUnit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtEntries_basicUnit_PromptBox.setVisible(true);
        kdtEntries_basicUnit_PromptBox.setEditable(true);
        kdtEntries_basicUnit_PromptBox.setDisplayFormat("$number$");
        kdtEntries_basicUnit_PromptBox.setEditFormat("$number$");
        kdtEntries_basicUnit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntries_basicUnit_CellEditor = new KDTDefaultCellEditor(kdtEntries_basicUnit_PromptBox);
        this.kdtEntries.getColumn("basicUnit").setEditor(kdtEntries_basicUnit_CellEditor);
        ObjectValueRender kdtEntries_basicUnit_OVR = new ObjectValueRender();
        kdtEntries_basicUnit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntries.getColumn("basicUnit").setRenderer(kdtEntries_basicUnit_OVR);
        KDComboBox kdtEntries_discountUnitType_ComboBox = new KDComboBox();
        kdtEntries_discountUnitType_ComboBox.setName("kdtEntries_discountUnitType_ComboBox");
        kdtEntries_discountUnitType_ComboBox.setVisible(true);
        kdtEntries_discountUnitType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.salediscount.DiscountUnitTypeEnum").toArray());
        KDTDefaultCellEditor kdtEntries_discountUnitType_CellEditor = new KDTDefaultCellEditor(kdtEntries_discountUnitType_ComboBox);
        this.kdtEntries.getColumn("discountUnitType").setEditor(kdtEntries_discountUnitType_CellEditor);
        KDFormattedTextField kdtEntries_qty1_TextField = new KDFormattedTextField();
        kdtEntries_qty1_TextField.setName("kdtEntries_qty1_TextField");
        kdtEntries_qty1_TextField.setVisible(true);
        kdtEntries_qty1_TextField.setEditable(true);
        kdtEntries_qty1_TextField.setHorizontalAlignment(2);
        kdtEntries_qty1_TextField.setDataType(1);
        	kdtEntries_qty1_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntries_qty1_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntries_qty1_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntries_qty1_CellEditor = new KDTDefaultCellEditor(kdtEntries_qty1_TextField);
        this.kdtEntries.getColumn("qty1").setEditor(kdtEntries_qty1_CellEditor);
        KDFormattedTextField kdtEntries_swQty1_TextField = new KDFormattedTextField();
        kdtEntries_swQty1_TextField.setName("kdtEntries_swQty1_TextField");
        kdtEntries_swQty1_TextField.setVisible(true);
        kdtEntries_swQty1_TextField.setEditable(true);
        kdtEntries_swQty1_TextField.setHorizontalAlignment(2);
        kdtEntries_swQty1_TextField.setDataType(1);
        	kdtEntries_swQty1_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E24"));
        	kdtEntries_swQty1_TextField.setMaximumValue(new java.math.BigDecimal("1.0E24"));
        kdtEntries_swQty1_TextField.setPrecision(4);
        KDTDefaultCellEditor kdtEntries_swQty1_CellEditor = new KDTDefaultCellEditor(kdtEntries_swQty1_TextField);
        this.kdtEntries.getColumn("swQty1").setEditor(kdtEntries_swQty1_CellEditor);
        KDFormattedTextField kdtEntries_swStandard1_TextField = new KDFormattedTextField();
        kdtEntries_swStandard1_TextField.setName("kdtEntries_swStandard1_TextField");
        kdtEntries_swStandard1_TextField.setVisible(true);
        kdtEntries_swStandard1_TextField.setEditable(true);
        kdtEntries_swStandard1_TextField.setHorizontalAlignment(2);
        kdtEntries_swStandard1_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntries_swStandard1_CellEditor = new KDTDefaultCellEditor(kdtEntries_swStandard1_TextField);
        this.kdtEntries.getColumn("swStandard1").setEditor(kdtEntries_swStandard1_CellEditor);
        KDFormattedTextField kdtEntries_standard1_TextField = new KDFormattedTextField();
        kdtEntries_standard1_TextField.setName("kdtEntries_standard1_TextField");
        kdtEntries_standard1_TextField.setVisible(true);
        kdtEntries_standard1_TextField.setEditable(true);
        kdtEntries_standard1_TextField.setHorizontalAlignment(2);
        kdtEntries_standard1_TextField.setDataType(1);
        	kdtEntries_standard1_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntries_standard1_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntries_standard1_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntries_standard1_CellEditor = new KDTDefaultCellEditor(kdtEntries_standard1_TextField);
        this.kdtEntries.getColumn("standard1").setEditor(kdtEntries_standard1_CellEditor);
        KDFormattedTextField kdtEntries_qty2_TextField = new KDFormattedTextField();
        kdtEntries_qty2_TextField.setName("kdtEntries_qty2_TextField");
        kdtEntries_qty2_TextField.setVisible(true);
        kdtEntries_qty2_TextField.setEditable(true);
        kdtEntries_qty2_TextField.setHorizontalAlignment(2);
        kdtEntries_qty2_TextField.setDataType(1);
        	kdtEntries_qty2_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntries_qty2_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntries_qty2_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntries_qty2_CellEditor = new KDTDefaultCellEditor(kdtEntries_qty2_TextField);
        this.kdtEntries.getColumn("qty2").setEditor(kdtEntries_qty2_CellEditor);
        KDFormattedTextField kdtEntries_swQty2_TextField = new KDFormattedTextField();
        kdtEntries_swQty2_TextField.setName("kdtEntries_swQty2_TextField");
        kdtEntries_swQty2_TextField.setVisible(true);
        kdtEntries_swQty2_TextField.setEditable(true);
        kdtEntries_swQty2_TextField.setHorizontalAlignment(2);
        kdtEntries_swQty2_TextField.setDataType(1);
        	kdtEntries_swQty2_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E24"));
        	kdtEntries_swQty2_TextField.setMaximumValue(new java.math.BigDecimal("1.0E24"));
        kdtEntries_swQty2_TextField.setPrecision(4);
        KDTDefaultCellEditor kdtEntries_swQty2_CellEditor = new KDTDefaultCellEditor(kdtEntries_swQty2_TextField);
        this.kdtEntries.getColumn("swQty2").setEditor(kdtEntries_swQty2_CellEditor);
        KDFormattedTextField kdtEntries_swStandard2_TextField = new KDFormattedTextField();
        kdtEntries_swStandard2_TextField.setName("kdtEntries_swStandard2_TextField");
        kdtEntries_swStandard2_TextField.setVisible(true);
        kdtEntries_swStandard2_TextField.setEditable(true);
        kdtEntries_swStandard2_TextField.setHorizontalAlignment(2);
        kdtEntries_swStandard2_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntries_swStandard2_CellEditor = new KDTDefaultCellEditor(kdtEntries_swStandard2_TextField);
        this.kdtEntries.getColumn("swStandard2").setEditor(kdtEntries_swStandard2_CellEditor);
        KDFormattedTextField kdtEntries_standard2_TextField = new KDFormattedTextField();
        kdtEntries_standard2_TextField.setName("kdtEntries_standard2_TextField");
        kdtEntries_standard2_TextField.setVisible(true);
        kdtEntries_standard2_TextField.setEditable(true);
        kdtEntries_standard2_TextField.setHorizontalAlignment(2);
        kdtEntries_standard2_TextField.setDataType(1);
        	kdtEntries_standard2_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntries_standard2_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntries_standard2_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntries_standard2_CellEditor = new KDTDefaultCellEditor(kdtEntries_standard2_TextField);
        this.kdtEntries.getColumn("standard2").setEditor(kdtEntries_standard2_CellEditor);
        KDFormattedTextField kdtEntries_qty3_TextField = new KDFormattedTextField();
        kdtEntries_qty3_TextField.setName("kdtEntries_qty3_TextField");
        kdtEntries_qty3_TextField.setVisible(true);
        kdtEntries_qty3_TextField.setEditable(true);
        kdtEntries_qty3_TextField.setHorizontalAlignment(2);
        kdtEntries_qty3_TextField.setDataType(1);
        	kdtEntries_qty3_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntries_qty3_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntries_qty3_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntries_qty3_CellEditor = new KDTDefaultCellEditor(kdtEntries_qty3_TextField);
        this.kdtEntries.getColumn("qty3").setEditor(kdtEntries_qty3_CellEditor);
        KDFormattedTextField kdtEntries_swQty3_TextField = new KDFormattedTextField();
        kdtEntries_swQty3_TextField.setName("kdtEntries_swQty3_TextField");
        kdtEntries_swQty3_TextField.setVisible(true);
        kdtEntries_swQty3_TextField.setEditable(true);
        kdtEntries_swQty3_TextField.setHorizontalAlignment(2);
        kdtEntries_swQty3_TextField.setDataType(1);
        	kdtEntries_swQty3_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E24"));
        	kdtEntries_swQty3_TextField.setMaximumValue(new java.math.BigDecimal("1.0E24"));
        kdtEntries_swQty3_TextField.setPrecision(4);
        KDTDefaultCellEditor kdtEntries_swQty3_CellEditor = new KDTDefaultCellEditor(kdtEntries_swQty3_TextField);
        this.kdtEntries.getColumn("swQty3").setEditor(kdtEntries_swQty3_CellEditor);
        KDFormattedTextField kdtEntries_swStandard3_TextField = new KDFormattedTextField();
        kdtEntries_swStandard3_TextField.setName("kdtEntries_swStandard3_TextField");
        kdtEntries_swStandard3_TextField.setVisible(true);
        kdtEntries_swStandard3_TextField.setEditable(true);
        kdtEntries_swStandard3_TextField.setHorizontalAlignment(2);
        kdtEntries_swStandard3_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntries_swStandard3_CellEditor = new KDTDefaultCellEditor(kdtEntries_swStandard3_TextField);
        this.kdtEntries.getColumn("swStandard3").setEditor(kdtEntries_swStandard3_CellEditor);
        KDFormattedTextField kdtEntries_standard3_TextField = new KDFormattedTextField();
        kdtEntries_standard3_TextField.setName("kdtEntries_standard3_TextField");
        kdtEntries_standard3_TextField.setVisible(true);
        kdtEntries_standard3_TextField.setEditable(true);
        kdtEntries_standard3_TextField.setHorizontalAlignment(2);
        kdtEntries_standard3_TextField.setDataType(1);
        	kdtEntries_standard3_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntries_standard3_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntries_standard3_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntries_standard3_CellEditor = new KDTDefaultCellEditor(kdtEntries_standard3_TextField);
        this.kdtEntries.getColumn("standard3").setEditor(kdtEntries_standard3_CellEditor);
        KDFormattedTextField kdtEntries_qty4_TextField = new KDFormattedTextField();
        kdtEntries_qty4_TextField.setName("kdtEntries_qty4_TextField");
        kdtEntries_qty4_TextField.setVisible(true);
        kdtEntries_qty4_TextField.setEditable(true);
        kdtEntries_qty4_TextField.setHorizontalAlignment(2);
        kdtEntries_qty4_TextField.setDataType(1);
        	kdtEntries_qty4_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntries_qty4_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntries_qty4_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntries_qty4_CellEditor = new KDTDefaultCellEditor(kdtEntries_qty4_TextField);
        this.kdtEntries.getColumn("qty4").setEditor(kdtEntries_qty4_CellEditor);
        KDFormattedTextField kdtEntries_swQty4_TextField = new KDFormattedTextField();
        kdtEntries_swQty4_TextField.setName("kdtEntries_swQty4_TextField");
        kdtEntries_swQty4_TextField.setVisible(true);
        kdtEntries_swQty4_TextField.setEditable(true);
        kdtEntries_swQty4_TextField.setHorizontalAlignment(2);
        kdtEntries_swQty4_TextField.setDataType(1);
        	kdtEntries_swQty4_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E24"));
        	kdtEntries_swQty4_TextField.setMaximumValue(new java.math.BigDecimal("1.0E24"));
        kdtEntries_swQty4_TextField.setPrecision(4);
        KDTDefaultCellEditor kdtEntries_swQty4_CellEditor = new KDTDefaultCellEditor(kdtEntries_swQty4_TextField);
        this.kdtEntries.getColumn("swQty4").setEditor(kdtEntries_swQty4_CellEditor);
        KDFormattedTextField kdtEntries_swStandard4_TextField = new KDFormattedTextField();
        kdtEntries_swStandard4_TextField.setName("kdtEntries_swStandard4_TextField");
        kdtEntries_swStandard4_TextField.setVisible(true);
        kdtEntries_swStandard4_TextField.setEditable(true);
        kdtEntries_swStandard4_TextField.setHorizontalAlignment(2);
        kdtEntries_swStandard4_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntries_swStandard4_CellEditor = new KDTDefaultCellEditor(kdtEntries_swStandard4_TextField);
        this.kdtEntries.getColumn("swStandard4").setEditor(kdtEntries_swStandard4_CellEditor);
        KDFormattedTextField kdtEntries_standard4_TextField = new KDFormattedTextField();
        kdtEntries_standard4_TextField.setName("kdtEntries_standard4_TextField");
        kdtEntries_standard4_TextField.setVisible(true);
        kdtEntries_standard4_TextField.setEditable(true);
        kdtEntries_standard4_TextField.setHorizontalAlignment(2);
        kdtEntries_standard4_TextField.setDataType(1);
        	kdtEntries_standard4_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntries_standard4_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntries_standard4_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntries_standard4_CellEditor = new KDTDefaultCellEditor(kdtEntries_standard4_TextField);
        this.kdtEntries.getColumn("standard4").setEditor(kdtEntries_standard4_CellEditor);
        KDFormattedTextField kdtEntries_qty5_TextField = new KDFormattedTextField();
        kdtEntries_qty5_TextField.setName("kdtEntries_qty5_TextField");
        kdtEntries_qty5_TextField.setVisible(true);
        kdtEntries_qty5_TextField.setEditable(true);
        kdtEntries_qty5_TextField.setHorizontalAlignment(2);
        kdtEntries_qty5_TextField.setDataType(1);
        	kdtEntries_qty5_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntries_qty5_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntries_qty5_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntries_qty5_CellEditor = new KDTDefaultCellEditor(kdtEntries_qty5_TextField);
        this.kdtEntries.getColumn("qty5").setEditor(kdtEntries_qty5_CellEditor);
        KDFormattedTextField kdtEntries_swQty5_TextField = new KDFormattedTextField();
        kdtEntries_swQty5_TextField.setName("kdtEntries_swQty5_TextField");
        kdtEntries_swQty5_TextField.setVisible(true);
        kdtEntries_swQty5_TextField.setEditable(true);
        kdtEntries_swQty5_TextField.setHorizontalAlignment(2);
        kdtEntries_swQty5_TextField.setDataType(1);
        	kdtEntries_swQty5_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E24"));
        	kdtEntries_swQty5_TextField.setMaximumValue(new java.math.BigDecimal("1.0E24"));
        kdtEntries_swQty5_TextField.setPrecision(4);
        KDTDefaultCellEditor kdtEntries_swQty5_CellEditor = new KDTDefaultCellEditor(kdtEntries_swQty5_TextField);
        this.kdtEntries.getColumn("swQty5").setEditor(kdtEntries_swQty5_CellEditor);
        KDFormattedTextField kdtEntries_swStandard5_TextField = new KDFormattedTextField();
        kdtEntries_swStandard5_TextField.setName("kdtEntries_swStandard5_TextField");
        kdtEntries_swStandard5_TextField.setVisible(true);
        kdtEntries_swStandard5_TextField.setEditable(true);
        kdtEntries_swStandard5_TextField.setHorizontalAlignment(2);
        kdtEntries_swStandard5_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntries_swStandard5_CellEditor = new KDTDefaultCellEditor(kdtEntries_swStandard5_TextField);
        this.kdtEntries.getColumn("swStandard5").setEditor(kdtEntries_swStandard5_CellEditor);
        KDFormattedTextField kdtEntries_standard5_TextField = new KDFormattedTextField();
        kdtEntries_standard5_TextField.setName("kdtEntries_standard5_TextField");
        kdtEntries_standard5_TextField.setVisible(true);
        kdtEntries_standard5_TextField.setEditable(true);
        kdtEntries_standard5_TextField.setHorizontalAlignment(2);
        kdtEntries_standard5_TextField.setDataType(1);
        	kdtEntries_standard5_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntries_standard5_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntries_standard5_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntries_standard5_CellEditor = new KDTDefaultCellEditor(kdtEntries_standard5_TextField);
        this.kdtEntries.getColumn("standard5").setEditor(kdtEntries_standard5_CellEditor);
        KDFormattedTextField kdtEntries_qtyLimit_TextField = new KDFormattedTextField();
        kdtEntries_qtyLimit_TextField.setName("kdtEntries_qtyLimit_TextField");
        kdtEntries_qtyLimit_TextField.setVisible(true);
        kdtEntries_qtyLimit_TextField.setEditable(true);
        kdtEntries_qtyLimit_TextField.setHorizontalAlignment(2);
        kdtEntries_qtyLimit_TextField.setDataType(1);
        	kdtEntries_qtyLimit_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntries_qtyLimit_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntries_qtyLimit_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntries_qtyLimit_CellEditor = new KDTDefaultCellEditor(kdtEntries_qtyLimit_TextField);
        this.kdtEntries.getColumn("qtyLimit").setEditor(kdtEntries_qtyLimit_CellEditor);
        KDFormattedTextField kdtEntries_sdLimit_TextField = new KDFormattedTextField();
        kdtEntries_sdLimit_TextField.setName("kdtEntries_sdLimit_TextField");
        kdtEntries_sdLimit_TextField.setVisible(true);
        kdtEntries_sdLimit_TextField.setEditable(true);
        kdtEntries_sdLimit_TextField.setHorizontalAlignment(2);
        kdtEntries_sdLimit_TextField.setDataType(1);
        	kdtEntries_sdLimit_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntries_sdLimit_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntries_sdLimit_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntries_sdLimit_CellEditor = new KDTDefaultCellEditor(kdtEntries_sdLimit_TextField);
        this.kdtEntries.getColumn("sdLimit").setEditor(kdtEntries_sdLimit_CellEditor);
        KDFormattedTextField kdtEntries_saleAmountLimit_TextField = new KDFormattedTextField();
        kdtEntries_saleAmountLimit_TextField.setName("kdtEntries_saleAmountLimit_TextField");
        kdtEntries_saleAmountLimit_TextField.setVisible(true);
        kdtEntries_saleAmountLimit_TextField.setEditable(true);
        kdtEntries_saleAmountLimit_TextField.setHorizontalAlignment(2);
        kdtEntries_saleAmountLimit_TextField.setDataType(1);
        	kdtEntries_saleAmountLimit_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntries_saleAmountLimit_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntries_saleAmountLimit_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntries_saleAmountLimit_CellEditor = new KDTDefaultCellEditor(kdtEntries_saleAmountLimit_TextField);
        this.kdtEntries.getColumn("saleAmountLimit").setEditor(kdtEntries_saleAmountLimit_CellEditor);
        KDComboBox kdtEntries_lockedState_ComboBox = new KDComboBox();
        kdtEntries_lockedState_ComboBox.setName("kdtEntries_lockedState_ComboBox");
        kdtEntries_lockedState_ComboBox.setVisible(true);
        kdtEntries_lockedState_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.salediscount.EntryState").toArray());
        KDTDefaultCellEditor kdtEntries_lockedState_CellEditor = new KDTDefaultCellEditor(kdtEntries_lockedState_ComboBox);
        this.kdtEntries.getColumn("lockedState").setEditor(kdtEntries_lockedState_CellEditor);
        KDTextField kdtEntries_remark_TextField = new KDTextField();
        kdtEntries_remark_TextField.setName("kdtEntries_remark_TextField");
        kdtEntries_remark_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntries_remark_CellEditor = new KDTDefaultCellEditor(kdtEntries_remark_TextField);
        this.kdtEntries.getColumn("remark").setEditor(kdtEntries_remark_CellEditor);
        final KDBizPromptBox kdtEntries_currency_PromptBox = new KDBizPromptBox();
        kdtEntries_currency_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.CurrencyQuery");
        kdtEntries_currency_PromptBox.setVisible(true);
        kdtEntries_currency_PromptBox.setEditable(true);
        kdtEntries_currency_PromptBox.setDisplayFormat("$number$");
        kdtEntries_currency_PromptBox.setEditFormat("$number$");
        kdtEntries_currency_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntries_currency_CellEditor = new KDTDefaultCellEditor(kdtEntries_currency_PromptBox);
        this.kdtEntries.getColumn("currency").setEditor(kdtEntries_currency_CellEditor);
        ObjectValueRender kdtEntries_currency_OVR = new ObjectValueRender();
        kdtEntries_currency_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntries.getColumn("currency").setRenderer(kdtEntries_currency_OVR);
        KDDatePicker kdtEntries_effectiveDate_DatePicker = new KDDatePicker();
        kdtEntries_effectiveDate_DatePicker.setName("kdtEntries_effectiveDate_DatePicker");
        kdtEntries_effectiveDate_DatePicker.setVisible(true);
        kdtEntries_effectiveDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntries_effectiveDate_CellEditor = new KDTDefaultCellEditor(kdtEntries_effectiveDate_DatePicker);
        this.kdtEntries.getColumn("effectiveDate").setEditor(kdtEntries_effectiveDate_CellEditor);
        KDDatePicker kdtEntries_expireDate_DatePicker = new KDDatePicker();
        kdtEntries_expireDate_DatePicker.setName("kdtEntries_expireDate_DatePicker");
        kdtEntries_expireDate_DatePicker.setVisible(true);
        kdtEntries_expireDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntries_expireDate_CellEditor = new KDTDefaultCellEditor(kdtEntries_expireDate_DatePicker);
        this.kdtEntries.getColumn("expireDate").setEditor(kdtEntries_expireDate_CellEditor);
        KDFormattedTextField kdtEntries_saleLeadTime_TextField = new KDFormattedTextField();
        kdtEntries_saleLeadTime_TextField.setName("kdtEntries_saleLeadTime_TextField");
        kdtEntries_saleLeadTime_TextField.setVisible(true);
        kdtEntries_saleLeadTime_TextField.setEditable(true);
        kdtEntries_saleLeadTime_TextField.setHorizontalAlignment(2);
        kdtEntries_saleLeadTime_TextField.setDataType(1);
        kdtEntries_saleLeadTime_TextField.setPrecision(16);
        KDTDefaultCellEditor kdtEntries_saleLeadTime_CellEditor = new KDTDefaultCellEditor(kdtEntries_saleLeadTime_TextField);
        this.kdtEntries.getColumn("saleLeadTime").setEditor(kdtEntries_saleLeadTime_CellEditor);
        KDComboBox kdtEntries_checkedStatus_ComboBox = new KDComboBox();
        kdtEntries_checkedStatus_ComboBox.setName("kdtEntries_checkedStatus_ComboBox");
        kdtEntries_checkedStatus_ComboBox.setVisible(true);
        kdtEntries_checkedStatus_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.framework.CheckedStatusEnum").toArray());
        KDTDefaultCellEditor kdtEntries_checkedStatus_CellEditor = new KDTDefaultCellEditor(kdtEntries_checkedStatus_ComboBox);
        this.kdtEntries.getColumn("checkedStatus").setEditor(kdtEntries_checkedStatus_CellEditor);
        // comboPriceCompDetailMaterial		
        this.comboPriceCompDetailMaterial.addItems(EnumUtils.getEnumList("com.kingdee.eas.basedata.scm.common.PriceCompDetailEnum").toArray());		
        this.comboPriceCompDetailMaterial.setRequired(true);		
        this.comboPriceCompDetailMaterial.setEnabled(false);		
        this.comboPriceCompDetailMaterial.setVisible(false);
        // chkisAllCustomer		
        this.chkisAllCustomer.setText(resHelper.getString("chkisAllCustomer.text"));		
        this.chkisAllCustomer.setVisible(true);		
        this.chkisAllCustomer.setHorizontalAlignment(2);
        this.chkisAllCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    chkisAllCustomer_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // txtName		
        this.txtName.setRequired(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setRequired(true);
        // pkEffectiveDate
        // pkExpireDate
        // comboPriceCompDetailCustomer		
        this.comboPriceCompDetailCustomer.addItems(EnumUtils.getEnumList("com.kingdee.eas.basedata.scm.common.PriceCompDetailEnum").toArray());		
        this.comboPriceCompDetailCustomer.setRequired(true);		
        this.comboPriceCompDetailCustomer.setEnabled(false);		
        this.comboPriceCompDetailCustomer.setVisible(false);
        // comboCheckedStatus		
        this.comboCheckedStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.framework.CheckedStatusEnum").toArray());		
        this.comboCheckedStatus.setEnabled(false);
        // comboBlockedStatus		
        this.comboBlockedStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.basedata.scm.sd.sale.ForbidStatusEnum").toArray());		
        this.comboBlockedStatus.setEnabled(false);
        // kDPanel1
        // kDPanel2
        // kDTreeView1
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(75);		
        this.kDLabelContainer4.setEnabled(false);		
        this.kDLabelContainer4.setVisible(false);
        // treeMain		
        this.treeMain.setVisible(false);
        // comboCustomerGroupStandard		
        this.comboCustomerGroupStandard.setEnabled(false);		
        this.comboCustomerGroupStandard.setVisible(false);
        // chkIncluded		
        this.chkIncluded.setText(resHelper.getString("chkIncluded.text"));		
        this.chkIncluded.setVisible(false);
        // prmtSaleOrgUnit		
        this.prmtSaleOrgUnit.setCommitFormat("$number$");		
        this.prmtSaleOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.SaleOrgUnitQuery");		
        this.prmtSaleOrgUnit.setDisplayFormat("$number$");		
        this.prmtSaleOrgUnit.setEditFormat("$number$");		
        this.prmtSaleOrgUnit.setRequired(true);		
        this.prmtSaleOrgUnit.setLabelVisible(true);		
        this.prmtSaleOrgUnit.setEditable(true);
        // discountType		
        this.discountType.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.salediscount.DiscountTypeEnum").toArray());		
        this.discountType.setRequired(false);
        this.discountType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    discountType_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // dsNameType		
        this.dsNameType.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.salediscount.DsNameTypeEnum").toArray());		
        this.dsNameType.setRequired(false);
        // pkaccumulaEnddate		
        this.pkaccumulaEnddate.setRequired(false);
        // pkaccumulaBeginDate		
        this.pkaccumulaBeginDate.setRequired(false);
        // btnAuditEntries
        this.btnAuditEntries.setAction((IItemAction)ActionProxyFactory.getProxy(actionAuditEntries, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAuditEntries.setText(resHelper.getString("btnAuditEntries.text"));
        // btnUnAuditEntries
        this.btnUnAuditEntries.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAuditEntries, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAuditEntries.setText(resHelper.getString("btnUnAuditEntries.text"));
        // btnBatchAddEntry
        this.btnBatchAddEntry.setAction((IItemAction)ActionProxyFactory.getProxy(actionBatchAddEntry, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnBatchAddEntry.setText(resHelper.getString("btnBatchAddEntry.text"));
        // btnCopyEntry
        this.btnCopyEntry.setAction((IItemAction)ActionProxyFactory.getProxy(actionCopyEntry, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnCopyEntry.setText(resHelper.getString("btnCopyEntry.text"));
        // menuItemQueryPriority
        this.menuItemQueryPriority.setAction((IItemAction)ActionProxyFactory.getProxy(actionPriorityQuery, new Class[] { IItemAction.class }, getServiceContext()));		
        this.menuItemQueryPriority.setText(resHelper.getString("menuItemQueryPriority.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {pkEffectiveDate,pkExpireDate,comboBlockedStatus,comboCheckedStatus,priceComposition,comboPriceCompDetailCustomer,comboPriceCompDetailMaterial,txtName,comboCustomerGroupStandard,prmtSaleOrgUnit,discountType,chkisEnableAim,txtNumber,dsNameType,chkisLimitMerge,chkbyMonthQtyLimit,pkaccumulaBeginDate,pkaccumulaEnddate,kdtEntries,chkisAllCustomer}));
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
        this.setBounds(new Rectangle(10, 10, 1013, 629));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(10, 10, 1013, 629));
        contName.setBounds(new Rectangle(363, 12, 270, 19));
        this.add(contName, new KDLayout.Constraints(363, 12, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contNumber.setBounds(new Rectangle(10, 12, 274, 19));
        this.add(contNumber, new KDLayout.Constraints(10, 12, 274, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contEffectiveDate.setBounds(new Rectangle(363, 33, 270, 19));
        this.add(contEffectiveDate, new KDLayout.Constraints(363, 33, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contExpireDate.setBounds(new Rectangle(724, 33, 270, 19));
        this.add(contExpireDate, new KDLayout.Constraints(724, 33, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contPriceComposition.setBounds(new Rectangle(301, 599, 181, 19));
        this.add(contPriceComposition, new KDLayout.Constraints(301, 599, 181, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contPriceCompDetail.setBounds(new Rectangle(187, 90, 87, 19));
        this.add(contPriceCompDetail, new KDLayout.Constraints(187, 90, 87, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer2.setBounds(new Rectangle(10, 56, 141, 19));
        this.add(kDLabelContainer2, new KDLayout.Constraints(10, 56, 141, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer3.setBounds(new Rectangle(159, 56, 125, 19));
        this.add(kDLabelContainer3, new KDLayout.Constraints(159, 56, 125, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSplitPane1.setBounds(new Rectangle(654, 601, 341, 20));
        this.add(kDSplitPane1, new KDLayout.Constraints(654, 601, 341, 20, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        priceComposition.setBounds(new Rectangle(291, 2, 170, 17));
        this.add(priceComposition, new KDLayout.Constraints(291, 2, 170, 17, 0));
        contSaleOrgUnit.setBounds(new Rectangle(10, 33, 274, 19));
        this.add(contSaleOrgUnit, new KDLayout.Constraints(10, 33, 274, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdiscountType.setBounds(new Rectangle(363, 56, 270, 19));
        this.add(contdiscountType, new KDLayout.Constraints(363, 56, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisEnableAim.setBounds(new Rectangle(905, 56, 99, 19));
        this.add(chkisEnableAim, new KDLayout.Constraints(905, 56, 99, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        btnCopyToEntries.setBounds(new Rectangle(10, 112, 274, 21));
        this.add(btnCopyToEntries, new KDLayout.Constraints(10, 112, 274, 21, 0));
        contdsNameType.setBounds(new Rectangle(724, 12, 270, 19));
        this.add(contdsNameType, new KDLayout.Constraints(724, 12, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        btnSetQtyStandard.setBounds(new Rectangle(363, 112, 134, 21));
        this.add(btnSetQtyStandard, new KDLayout.Constraints(363, 112, 134, 21, 0));
        btnSetLimit.setBounds(new Rectangle(502, 112, 134, 21));
        this.add(btnSetLimit, new KDLayout.Constraints(502, 112, 134, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnEnableEntry.setBounds(new Rectangle(724, 112, 134, 21));
        this.add(btnEnableEntry, new KDLayout.Constraints(724, 112, 134, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnForbiddenEntry.setBounds(new Rectangle(860, 112, 134, 21));
        this.add(btnForbiddenEntry, new KDLayout.Constraints(860, 112, 134, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkisLimitMerge.setBounds(new Rectangle(724, 56, 183, 19));
        this.add(chkisLimitMerge, new KDLayout.Constraints(724, 56, 183, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnDisplayCustomer.setBounds(new Rectangle(12, 135, 200, 19));
        this.add(btnDisplayCustomer, new KDLayout.Constraints(12, 135, 200, 19, 0));
        chkbyMonthQtyLimit.setBounds(new Rectangle(11, 85, 106, 19));
        this.add(chkbyMonthQtyLimit, new KDLayout.Constraints(11, 85, 106, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator8.setBounds(new Rectangle(11, 79, 993, 10));
        this.add(kDSeparator8, new KDLayout.Constraints(11, 79, 993, 10, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contaccumulaEnddate.setBounds(new Rectangle(728, 86, 270, 19));
        this.add(contaccumulaEnddate, new KDLayout.Constraints(728, 86, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contaccumulaBeginDate.setBounds(new Rectangle(363, 85, 270, 19));
        this.add(contaccumulaBeginDate, new KDLayout.Constraints(363, 85, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntries.setBounds(new Rectangle(9, 158, 985, 464));
        this.add(kdtEntries, new KDLayout.Constraints(9, 158, 985, 464, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        comboPriceCompDetailMaterial.setBounds(new Rectangle(493, 602, 86, 19));
        this.add(comboPriceCompDetailMaterial, new KDLayout.Constraints(493, 602, 86, 19, 0));
        chkisAllCustomer.setBounds(new Rectangle(123, 85, 115, 19));
        this.add(chkisAllCustomer, new KDLayout.Constraints(123, 85, 115, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contName
        contName.setBoundEditor(txtName);
        //contNumber
        contNumber.setBoundEditor(txtNumber);
        //contEffectiveDate
        contEffectiveDate.setBoundEditor(pkEffectiveDate);
        //contExpireDate
        contExpireDate.setBoundEditor(pkExpireDate);
        //contPriceComposition
        contPriceComposition.setBoundEditor(comboPriceCompDetailCustomer);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(comboCheckedStatus);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(comboBlockedStatus);
        //kDSplitPane1
        kDSplitPane1.add(kDPanel1, "left");
        kDSplitPane1.add(kDPanel2, "right");
        //kDPanel1
kDPanel1.setLayout(new BorderLayout(0, 0));        kDPanel1.add(kDTreeView1, BorderLayout.CENTER);
        kDPanel1.add(kDLabelContainer4, BorderLayout.NORTH);
        //kDTreeView1
        kDTreeView1.setTree(treeMain);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(comboCustomerGroupStandard);
        //kDPanel2
kDPanel2.setLayout(new BorderLayout(0, 0));        kDPanel2.add(chkIncluded, BorderLayout.NORTH);
        //contSaleOrgUnit
        contSaleOrgUnit.setBoundEditor(prmtSaleOrgUnit);
        //contdiscountType
        contdiscountType.setBoundEditor(discountType);
        //contdsNameType
        contdsNameType.setBoundEditor(dsNameType);
        //contaccumulaEnddate
        contaccumulaEnddate.setBoundEditor(pkaccumulaEnddate);
        //contaccumulaBeginDate
        contaccumulaBeginDate.setBoundEditor(pkaccumulaBeginDate);

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
        this.menuBar.add(menuTable1);
        this.menuBar.add(menuTool);
        this.menuBar.add(menuWorkflow);
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
        menuFile.add(kDSeparator6);
        menuFile.add(menuItemSendMail);
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
        menuEdit.add(separator1);
        menuEdit.add(menuItemCreateFrom);
        menuEdit.add(menuItemCreateTo);
        menuEdit.add(menuItemCopyFrom);
        menuEdit.add(separatorEdit1);
        menuEdit.add(menuItemEnterToNextRow);
        menuEdit.add(separator2);
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
        menuView.add(separator3);
        menuView.add(menuItemTraceUp);
        menuView.add(menuItemTraceDown);
        menuView.add(kDSeparator7);
        menuView.add(menuItemLocate);
        //menuBiz
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        menuBiz.add(MenuItemVoucher);
        menuBiz.add(menuItemDelVoucher);
        //menuTable1
        menuTable1.add(menuItemAddLine);
        menuTable1.add(menuItemCopyLine);
        menuTable1.add(menuItemInsertLine);
        menuTable1.add(menuItemRemoveLine);
        //menuTool
        menuTool.add(menuItemMsgFormat);
        menuTool.add(menuItemQueryPriority);
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemCalculator);
        menuTool.add(menuItemToolBarCustom);
        //menuWorkflow
        menuWorkflow.add(menuItemStartWorkFlow);
        menuWorkflow.add(separatorWF1);
        menuWorkflow.add(menuItemViewSubmitProccess);
        menuWorkflow.add(menuItemViewDoProccess);
        menuWorkflow.add(MenuItemWFG);
        menuWorkflow.add(menuItemWorkFlowList);
        menuWorkflow.add(separatorWF2);
        menuWorkflow.add(menuItemMultiapprove);
        menuWorkflow.add(menuItemNextPerson);
        menuWorkflow.add(menuItemAuditResult);
        menuWorkflow.add(kDSeparator5);
        menuWorkflow.add(kDMenuItemSendMessage);
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
        this.toolBar.add(btnXunTong);
        this.toolBar.add(btnEdit);
        this.toolBar.add(kDSeparatorCloud);
        this.toolBar.add(btnReset);
        this.toolBar.add(btnSave);
        this.toolBar.add(btnSubmit);
        this.toolBar.add(btnCopy);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnAttachment);
        this.toolBar.add(btnRemove);
        this.toolBar.add(btnCancel);
        this.toolBar.add(btnAuditEntries);
        this.toolBar.add(separatorFW1);
        this.toolBar.add(btnUnAuditEntries);
        this.toolBar.add(btnPrint);
        this.toolBar.add(btnPrintPreview);
        this.toolBar.add(btnFirst);
        this.toolBar.add(btnPre);
        this.toolBar.add(btnNext);
        this.toolBar.add(btnLast);
        this.toolBar.add(separatorFW2);
        this.toolBar.add(btnBatchAddEntry);
        this.toolBar.add(btnAddLine);
        this.toolBar.add(btnInsertLine);
        this.toolBar.add(btnRemoveLine);
        this.toolBar.add(btnPageSetup);
        this.toolBar.add(separatorFW3);
        this.toolBar.add(btnSignature);
        this.toolBar.add(btnViewSignature);
        this.toolBar.add(btnCreateFrom);
        this.toolBar.add(btnNumberSign);
        this.toolBar.add(btnCopyFrom);
        this.toolBar.add(btnWorkFlowG);
        this.toolBar.add(btnTraceUp);
        this.toolBar.add(separatorFW4);
        this.toolBar.add(btnTraceDown);
        this.toolBar.add(btnCreateTo);
        this.toolBar.add(separatorFW7);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnCopyLine);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(separatorFW5);
        this.toolBar.add(separatorFW8);
        this.toolBar.add(btnCopyEntry);
        this.toolBar.add(separatorFW6);
        this.toolBar.add(separatorFW9);
        this.toolBar.add(btnVoucher);
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnNextPerson);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("priceComposition", com.kingdee.eas.basedata.scm.common.PriceCompositionEnum.class, this.priceComposition, "selectedItem");
		dataBinder.registerBinding("isEnableAim", boolean.class, this.chkisEnableAim, "selected");
		dataBinder.registerBinding("isLimitMerge", boolean.class, this.chkisLimitMerge, "selected");
		dataBinder.registerBinding("byMonthQtyLimit", boolean.class, this.chkbyMonthQtyLimit, "selected");
		dataBinder.registerBinding("entries.effectiveDate", java.util.Date.class, this.kdtEntries, "effectiveDate.text");
		dataBinder.registerBinding("entries.expireDate", java.util.Date.class, this.kdtEntries, "expireDate.text");
		dataBinder.registerBinding("entries.asistProperty", String.class, this.kdtEntries, "asistProperty.text");
		dataBinder.registerBinding("entries.remark", String.class, this.kdtEntries, "remark.text");
		dataBinder.registerBinding("entries.saleLeadTime", float.class, this.kdtEntries, "saleLeadTime.text");
		dataBinder.registerBinding("entries.checkedStatus", com.kingdee.util.enums.Enum.class, this.kdtEntries, "checkedStatus.text");
		dataBinder.registerBinding("entries.discountCondition", com.kingdee.util.enums.Enum.class, this.kdtEntries, "discountCondition.text");
		dataBinder.registerBinding("entries.customer.name", String.class, this.kdtEntries, "customerName.text");
		dataBinder.registerBinding("entries.material.name", String.class, this.kdtEntries, "materialName.text");
		dataBinder.registerBinding("entries.customer", com.kingdee.eas.basedata.master.cssp.CustomerInfo.class, this.kdtEntries, "customerNumber.text");
		dataBinder.registerBinding("entries.currency", com.kingdee.eas.basedata.assistant.CurrencyInfo.class, this.kdtEntries, "currency.text");
		dataBinder.registerBinding("entries.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntries, "id.text");
		dataBinder.registerBinding("entries.material", com.kingdee.eas.basedata.master.material.MaterialInfo.class, this.kdtEntries, "materialNumber.text");
		dataBinder.registerBinding("entries", com.kingdee.eas.custom.salediscount.DiscountSetEntryInfo.class, this.kdtEntries, "userObject");
		dataBinder.registerBinding("entries.measureUnit", com.kingdee.eas.basedata.assistant.MeasureUnitInfo.class, this.kdtEntries, "basicUnit.text");
		dataBinder.registerBinding("entries.material.model", String.class, this.kdtEntries, "materialModel.text");
		dataBinder.registerBinding("entries.qty1", java.math.BigDecimal.class, this.kdtEntries, "qty1.text");
		dataBinder.registerBinding("entries.standard1", java.math.BigDecimal.class, this.kdtEntries, "standard1.text");
		dataBinder.registerBinding("entries.qty2", java.math.BigDecimal.class, this.kdtEntries, "qty2.text");
		dataBinder.registerBinding("entries.standard2", java.math.BigDecimal.class, this.kdtEntries, "standard2.text");
		dataBinder.registerBinding("entries.discountUnitType", com.kingdee.util.enums.Enum.class, this.kdtEntries, "discountUnitType.text");
		dataBinder.registerBinding("entries.qtyLimit", java.math.BigDecimal.class, this.kdtEntries, "qtyLimit.text");
		dataBinder.registerBinding("entries.sdLimit", java.math.BigDecimal.class, this.kdtEntries, "sdLimit.text");
		dataBinder.registerBinding("entries.saleAmountLimit", java.math.BigDecimal.class, this.kdtEntries, "saleAmountLimit.text");
		dataBinder.registerBinding("entries.swQty1", java.math.BigDecimal.class, this.kdtEntries, "swQty1.text");
		dataBinder.registerBinding("entries.swQty2", java.math.BigDecimal.class, this.kdtEntries, "swQty2.text");
		dataBinder.registerBinding("entries.swStandard2", int.class, this.kdtEntries, "swStandard2.text");
		dataBinder.registerBinding("entries.swStandard1", int.class, this.kdtEntries, "swStandard1.text");
		dataBinder.registerBinding("entries.lockedState", com.kingdee.util.enums.Enum.class, this.kdtEntries, "lockedState.text");
		dataBinder.registerBinding("entries.qty3", java.math.BigDecimal.class, this.kdtEntries, "qty3.text");
		dataBinder.registerBinding("entries.swQty3", java.math.BigDecimal.class, this.kdtEntries, "swQty3.text");
		dataBinder.registerBinding("entries.swStandard3", int.class, this.kdtEntries, "swStandard3.text");
		dataBinder.registerBinding("entries.standard3", java.math.BigDecimal.class, this.kdtEntries, "standard3.text");
		dataBinder.registerBinding("entries.qty4", java.math.BigDecimal.class, this.kdtEntries, "qty4.text");
		dataBinder.registerBinding("entries.swQty4", java.math.BigDecimal.class, this.kdtEntries, "swQty4.text");
		dataBinder.registerBinding("entries.swStandard4", int.class, this.kdtEntries, "swStandard4.text");
		dataBinder.registerBinding("entries.standard4", java.math.BigDecimal.class, this.kdtEntries, "standard4.text");
		dataBinder.registerBinding("entries.qty5", java.math.BigDecimal.class, this.kdtEntries, "qty5.text");
		dataBinder.registerBinding("entries.swQty5", java.math.BigDecimal.class, this.kdtEntries, "swQty5.text");
		dataBinder.registerBinding("entries.swStandard5", int.class, this.kdtEntries, "swStandard5.text");
		dataBinder.registerBinding("entries.Standard5", java.math.BigDecimal.class, this.kdtEntries, "standard5.text");
		dataBinder.registerBinding("entries.accumulaMaterialGroup", java.lang.Object.class, this.kdtEntries, "accumulaMaterialGroup.text");
		dataBinder.registerBinding("priceCompDetailmaterial", com.kingdee.eas.basedata.scm.common.PriceCompDetailEnum.class, this.comboPriceCompDetailMaterial, "selectedItem");
		dataBinder.registerBinding("isAllCustomer", boolean.class, this.chkisAllCustomer, "selected");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("effectiveDate", java.util.Date.class, this.pkEffectiveDate, "value");
		dataBinder.registerBinding("expireDate", java.util.Date.class, this.pkExpireDate, "value");
		dataBinder.registerBinding("priceCompDetailCustomer", com.kingdee.eas.basedata.scm.common.PriceCompDetailEnum.class, this.comboPriceCompDetailCustomer, "selectedItem");
		dataBinder.registerBinding("checkedStatus", com.kingdee.eas.framework.CheckedStatusEnum.class, this.comboCheckedStatus, "selectedItem");
		dataBinder.registerBinding("blockedStatus", com.kingdee.eas.basedata.scm.sd.sale.ForbidStatusEnum.class, this.comboBlockedStatus, "selectedItem");
		dataBinder.registerBinding("groupStandardCustomer", com.kingdee.eas.basedata.master.cssp.CSSPGroupStandardInfo.class, this.comboCustomerGroupStandard, "selectedItem");
		dataBinder.registerBinding("saleOrgUnit", com.kingdee.eas.basedata.org.SaleOrgUnitInfo.class, this.prmtSaleOrgUnit, "data");
		dataBinder.registerBinding("discountType", com.kingdee.eas.custom.salediscount.DiscountTypeEnum.class, this.discountType, "selectedItem");
		dataBinder.registerBinding("dsNameType", com.kingdee.eas.custom.salediscount.DsNameTypeEnum.class, this.dsNameType, "selectedItem");
		dataBinder.registerBinding("accumulaEnddate", java.util.Date.class, this.pkaccumulaEnddate, "value");
		dataBinder.registerBinding("accumulaBeginDate", java.util.Date.class, this.pkaccumulaBeginDate, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.salediscount.app.DiscountSetEditUIHandler";
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
        this.pkEffectiveDate.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.salediscount.DiscountSetInfo)ov;
    }
    protected void removeByPK(IObjectPK pk) throws Exception {
    	IObjectValue editData = this.editData;
    	super.removeByPK(pk);
    	recycleNumberByOrg(editData,null,editData.getString("number"));
    }
    
    protected void recycleNumberByOrg(IObjectValue editData,String orgType,String number) {
        if (!StringUtils.isEmpty(number))
        {
            try {
            	String companyID = null;            
            	com.kingdee.eas.base.codingrule.ICodingRuleManager iCodingRuleManager = com.kingdee.eas.base.codingrule.CodingRuleManagerFactory.getRemoteInstance();
				if(!com.kingdee.util.StringUtils.isEmpty(orgType) && !"NONE".equalsIgnoreCase(orgType) && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType))!=null) {
					companyID =com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType)).getString("id");
				}
				else if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit() != null) {
					companyID = ((com.kingdee.eas.basedata.org.OrgUnitInfo)com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit()).getString("id");
            	}				
				if (!StringUtils.isEmpty(companyID) && iCodingRuleManager.isExist(editData, companyID) && iCodingRuleManager.isUseIntermitNumber(editData, companyID)) {
					iCodingRuleManager.recycleNumber(editData,companyID,number);					
				}
            }
            catch (Exception e)
            {
                handUIException(e);
            }
        }
    }
    protected void setAutoNumberByOrg(String orgType) {
    	if (editData == null) return;
		if (editData.getNumber() == null) {
            try {
            	String companyID = null;
				if(!com.kingdee.util.StringUtils.isEmpty(orgType) && !"NONE".equalsIgnoreCase(orgType) && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType))!=null) {
					companyID = com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType)).getString("id");
				}
				else if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit() != null) {
					companyID = ((com.kingdee.eas.basedata.org.OrgUnitInfo)com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit()).getString("id");
            	}
				com.kingdee.eas.base.codingrule.ICodingRuleManager iCodingRuleManager = com.kingdee.eas.base.codingrule.CodingRuleManagerFactory.getRemoteInstance();
		        if (iCodingRuleManager.isExist(editData, companyID)) {
		            if (iCodingRuleManager.isAddView(editData, companyID)) {
		            	editData.setNumber(iCodingRuleManager.getNumber(editData,companyID));
		            }
	                txtNumber.setEnabled(false);
		        }
            }
            catch (Exception e) {
                handUIException(e);
                this.oldData = editData;
                com.kingdee.eas.util.SysUtil.abort();
            } 
        } 
        else {
            if (editData.getNumber().trim().length() > 0) {
                txtNumber.setText(editData.getNumber());
            }
        }
    }

    /**
     * output loadFields method
     */
    public void loadFields()
    {
        		setAutoNumberByOrg(null);
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
	 * ????????§µ??
	 */
	protected void registerValidator() {
    	getValidateHelper().setCustomValidator( getValidator() );
		getValidateHelper().registerBindProperty("priceComposition", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isEnableAim", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isLimitMerge", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("byMonthQtyLimit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.effectiveDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.expireDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.asistProperty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.saleLeadTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.checkedStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.discountCondition", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.customer.name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.material.name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.customer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.currency", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.measureUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.material.model", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.qty1", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.standard1", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.qty2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.standard2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.discountUnitType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.qtyLimit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.sdLimit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.saleAmountLimit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.swQty1", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.swQty2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.swStandard2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.swStandard1", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.lockedState", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.qty3", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.swQty3", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.swStandard3", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.standard3", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.qty4", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.swQty4", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.swStandard4", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.standard4", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.qty5", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.swQty5", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.swStandard5", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.Standard5", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entries.accumulaMaterialGroup", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("priceCompDetailmaterial", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isAllCustomer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("effectiveDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("expireDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("priceCompDetailCustomer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("checkedStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("blockedStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("groupStandardCustomer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("saleOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("discountType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dsNameType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("accumulaEnddate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("accumulaBeginDate", ValidateHelper.ON_SAVE);    		
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
        } else if (STATUS_FINDVIEW.equals(this.oprtState)) {
        }
    }

    /**
     * output btnCopyToEntries_actionPerformed method
     */
    protected void btnCopyToEntries_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnSetQtyStandard_actionPerformed method
     */
    protected void btnSetQtyStandard_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnSetLimit_actionPerformed method
     */
    protected void btnSetLimit_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnEnableEntry_actionPerformed method
     */
    protected void btnEnableEntry_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnForbiddenEntry_actionPerformed method
     */
    protected void btnForbiddenEntry_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnDisplayCustomer_actionPerformed method
     */
    protected void btnDisplayCustomer_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output chkbyMonthQtyLimit_actionPerformed method
     */
    protected void chkbyMonthQtyLimit_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output chkisAllCustomer_actionPerformed method
     */
    protected void chkisAllCustomer_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output discountType_actionPerformed method
     */
    protected void discountType_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
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
        sic.add(new SelectorItemInfo("priceComposition"));
        sic.add(new SelectorItemInfo("isEnableAim"));
        sic.add(new SelectorItemInfo("isLimitMerge"));
        sic.add(new SelectorItemInfo("byMonthQtyLimit"));
    	sic.add(new SelectorItemInfo("entries.effectiveDate"));
    	sic.add(new SelectorItemInfo("entries.expireDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entries.asistProperty.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entries.asistProperty.id"));
			sic.add(new SelectorItemInfo("entries.asistProperty.name"));
        	sic.add(new SelectorItemInfo("entries.asistProperty.number"));
		}
    	sic.add(new SelectorItemInfo("entries.remark"));
    	sic.add(new SelectorItemInfo("entries.saleLeadTime"));
    	sic.add(new SelectorItemInfo("entries.checkedStatus"));
    	sic.add(new SelectorItemInfo("entries.discountCondition"));
    	sic.add(new SelectorItemInfo("entries.customer.name"));
    	sic.add(new SelectorItemInfo("entries.material.name"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entries.customer.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entries.customer.id"));
        	sic.add(new SelectorItemInfo("entries.customer.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entries.currency.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entries.currency.id"));
			sic.add(new SelectorItemInfo("entries.currency.name"));
        	sic.add(new SelectorItemInfo("entries.currency.number"));
		}
    	sic.add(new SelectorItemInfo("entries.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entries.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entries.material.id"));
        	sic.add(new SelectorItemInfo("entries.material.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entries.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entries.measureUnit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entries.measureUnit.id"));
			sic.add(new SelectorItemInfo("entries.measureUnit.name"));
        	sic.add(new SelectorItemInfo("entries.measureUnit.number"));
		}
    	sic.add(new SelectorItemInfo("entries.material.model"));
    	sic.add(new SelectorItemInfo("entries.qty1"));
    	sic.add(new SelectorItemInfo("entries.standard1"));
    	sic.add(new SelectorItemInfo("entries.qty2"));
    	sic.add(new SelectorItemInfo("entries.standard2"));
    	sic.add(new SelectorItemInfo("entries.discountUnitType"));
    	sic.add(new SelectorItemInfo("entries.qtyLimit"));
    	sic.add(new SelectorItemInfo("entries.sdLimit"));
    	sic.add(new SelectorItemInfo("entries.saleAmountLimit"));
    	sic.add(new SelectorItemInfo("entries.swQty1"));
    	sic.add(new SelectorItemInfo("entries.swQty2"));
    	sic.add(new SelectorItemInfo("entries.swStandard2"));
    	sic.add(new SelectorItemInfo("entries.swStandard1"));
    	sic.add(new SelectorItemInfo("entries.lockedState"));
    	sic.add(new SelectorItemInfo("entries.qty3"));
    	sic.add(new SelectorItemInfo("entries.swQty3"));
    	sic.add(new SelectorItemInfo("entries.swStandard3"));
    	sic.add(new SelectorItemInfo("entries.standard3"));
    	sic.add(new SelectorItemInfo("entries.qty4"));
    	sic.add(new SelectorItemInfo("entries.swQty4"));
    	sic.add(new SelectorItemInfo("entries.swStandard4"));
    	sic.add(new SelectorItemInfo("entries.standard4"));
    	sic.add(new SelectorItemInfo("entries.qty5"));
    	sic.add(new SelectorItemInfo("entries.swQty5"));
    	sic.add(new SelectorItemInfo("entries.swStandard5"));
    	sic.add(new SelectorItemInfo("entries.Standard5"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entries.accumulaMaterialGroup.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entries.accumulaMaterialGroup.id"));
			sic.add(new SelectorItemInfo("entries.accumulaMaterialGroup.name"));
        	sic.add(new SelectorItemInfo("entries.accumulaMaterialGroup.number"));
		}
        sic.add(new SelectorItemInfo("priceCompDetailmaterial"));
        sic.add(new SelectorItemInfo("isAllCustomer"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("effectiveDate"));
        sic.add(new SelectorItemInfo("expireDate"));
        sic.add(new SelectorItemInfo("priceCompDetailCustomer"));
        sic.add(new SelectorItemInfo("checkedStatus"));
        sic.add(new SelectorItemInfo("blockedStatus"));
        sic.add(new SelectorItemInfo("groupStandardCustomer"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("saleOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("saleOrgUnit.id"));
        	sic.add(new SelectorItemInfo("saleOrgUnit.number"));
        	sic.add(new SelectorItemInfo("saleOrgUnit.name"));
		}
        sic.add(new SelectorItemInfo("discountType"));
        sic.add(new SelectorItemInfo("dsNameType"));
        sic.add(new SelectorItemInfo("accumulaEnddate"));
        sic.add(new SelectorItemInfo("accumulaBeginDate"));
        return sic;
    }        
    	

    /**
     * output actionAuditEntries_actionPerformed method
     */
    public void actionAuditEntries_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionUnAuditEntries_actionPerformed method
     */
    public void actionUnAuditEntries_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionCopyEntry_actionPerformed method
     */
    public void actionCopyEntry_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionPriorityQuery_actionPerformed method
     */
    public void actionPriorityQuery_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionBatchAddEntry_actionPerformed method
     */
    public void actionBatchAddEntry_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.salediscount.DiscountSetFactory.getRemoteInstance().batchAddEntry(editData);
    }
    	

    /**
     * output actionEnableEntry_actionPerformed method
     */
    public void actionEnableEntry_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.salediscount.DiscountSetFactory.getRemoteInstance().enableEntry(editData);
    }
    	

    /**
     * output actionForbiddenEntry_actionPerformed method
     */
    public void actionForbiddenEntry_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.salediscount.DiscountSetFactory.getRemoteInstance().forbiddenEntry(editData);
    }
	public RequestContext prepareActionAuditEntries(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAuditEntries() {
    	return false;
    }
	public RequestContext prepareActionUnAuditEntries(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionUnAuditEntries() {
    	return false;
    }
	public RequestContext prepareActionCopyEntry(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionCopyEntry() {
    	return false;
    }
	public RequestContext prepareActionPriorityQuery(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionPriorityQuery() {
    	return false;
    }
	public RequestContext prepareActionBatchAddEntry(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionBatchAddEntry() {
    	return false;
    }
	public RequestContext prepareActionEnableEntry(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionEnableEntry() {
    	return false;
    }
	public RequestContext prepareActionForbiddenEntry(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionForbiddenEntry() {
    	return false;
    }

    /**
     * output ActionAuditEntries class
     */     
    protected class ActionAuditEntries extends ItemAction {     
    
        public ActionAuditEntries()
        {
            this(null);
        }

        public ActionAuditEntries(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionAuditEntries.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAuditEntries.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAuditEntries.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractDiscountSetEditUI.this, "ActionAuditEntries", "actionAuditEntries_actionPerformed", e);
        }
    }

    /**
     * output ActionUnAuditEntries class
     */     
    protected class ActionUnAuditEntries extends ItemAction {     
    
        public ActionUnAuditEntries()
        {
            this(null);
        }

        public ActionUnAuditEntries(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("ActionUnAuditEntries.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnAuditEntries.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnAuditEntries.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractDiscountSetEditUI.this, "ActionUnAuditEntries", "actionUnAuditEntries_actionPerformed", e);
        }
    }

    /**
     * output ActionCopyEntry class
     */     
    protected class ActionCopyEntry extends ItemAction {     
    
        public ActionCopyEntry()
        {
            this(null);
        }

        public ActionCopyEntry(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("ActionCopyEntry.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCopyEntry.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCopyEntry.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractDiscountSetEditUI.this, "ActionCopyEntry", "actionCopyEntry_actionPerformed", e);
        }
    }

    /**
     * output ActionPriorityQuery class
     */     
    protected class ActionPriorityQuery extends ItemAction {     
    
        public ActionPriorityQuery()
        {
            this(null);
        }

        public ActionPriorityQuery(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("ActionPriorityQuery.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionPriorityQuery.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionPriorityQuery.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractDiscountSetEditUI.this, "ActionPriorityQuery", "actionPriorityQuery_actionPerformed", e);
        }
    }

    /**
     * output ActionBatchAddEntry class
     */     
    protected class ActionBatchAddEntry extends ItemAction {     
    
        public ActionBatchAddEntry()
        {
            this(null);
        }

        public ActionBatchAddEntry(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionBatchAddEntry.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionBatchAddEntry.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionBatchAddEntry.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractDiscountSetEditUI.this, "ActionBatchAddEntry", "actionBatchAddEntry_actionPerformed", e);
        }
    }

    /**
     * output ActionEnableEntry class
     */     
    protected class ActionEnableEntry extends ItemAction {     
    
        public ActionEnableEntry()
        {
            this(null);
        }

        public ActionEnableEntry(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionEnableEntry.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionEnableEntry.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionEnableEntry.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractDiscountSetEditUI.this, "ActionEnableEntry", "actionEnableEntry_actionPerformed", e);
        }
    }

    /**
     * output ActionForbiddenEntry class
     */     
    protected class ActionForbiddenEntry extends ItemAction {     
    
        public ActionForbiddenEntry()
        {
            this(null);
        }

        public ActionForbiddenEntry(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionForbiddenEntry.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionForbiddenEntry.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionForbiddenEntry.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractDiscountSetEditUI.this, "ActionForbiddenEntry", "actionForbiddenEntry_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.salediscount.client", "DiscountSetEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.salediscount.client.DiscountSetEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.salediscount.DiscountSetFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.salediscount.DiscountSetInfo objectValue = new com.kingdee.eas.custom.salediscount.DiscountSetInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/salediscount/DiscountSet";
	}
    protected IMetaDataPK getTDQueryPK() {
	return null;    	
	}
    

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtEntries;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("discountType","1");
vo.put("dsNameType","1");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}