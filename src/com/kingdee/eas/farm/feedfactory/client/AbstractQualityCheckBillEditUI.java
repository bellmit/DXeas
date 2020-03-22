/**
 * output package name
 */
package com.kingdee.eas.farm.feedfactory.client;

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
public abstract class AbstractQualityCheckBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractQualityCheckBillEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweightBill;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmaterial;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsupplier;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttruckNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contarriveDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsendDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contconclusion;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsampleNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttakeOffPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttakeOffBasePrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttakeOffWeight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpurOrder;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpurOrderNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpriceAfterTakeOff;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpriceBeforeTakeOff;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contproductFactory;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsendPerson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contunloadArea;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBuckAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrealAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsumweight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalcon;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisWeight;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtweightBill;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperson;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtmaterial;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsupplier;
    protected com.kingdee.bos.ctrl.swing.KDTextField txttruckNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkarriveDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pksendDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane scrollPaneconclusion;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtconclusion;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtsampleNumber;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttakeOffPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttakeOffBasePrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttakeOffWeight;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpurOrder;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpurOrderNumber;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpriceAfterTakeOff;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpriceBeforeTakeOff;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtproductFactory;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtsendPerson;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtunloadArea;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtcontractItem;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtBuckAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtrealAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsumweight;
    protected com.kingdee.bos.ctrl.swing.KDComboBox totalcon;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.farm.feedfactory.QualityCheckBillInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractQualityCheckBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractQualityCheckBillEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        //actionSubmit
        String _tempStr = null;
        actionSubmit.setEnabled(true);
        actionSubmit.setDaemonRun(false);

        actionSubmit.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl S"));
        _tempStr = resHelper.getString("ActionSubmit.SHORT_DESCRIPTION");
        actionSubmit.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionSubmit.LONG_DESCRIPTION");
        actionSubmit.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionSubmit.NAME");
        actionSubmit.putValue(ItemAction.NAME, _tempStr);
        this.actionSubmit.setBindWorkFlow(true);
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionPrint
        actionPrint.setEnabled(true);
        actionPrint.setDaemonRun(false);

        actionPrint.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl P"));
        _tempStr = resHelper.getString("ActionPrint.SHORT_DESCRIPTION");
        actionPrint.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrint.LONG_DESCRIPTION");
        actionPrint.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrint.NAME");
        actionPrint.putValue(ItemAction.NAME, _tempStr);
         this.actionPrint.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionPrint.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionPrint.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionPrintPreview
        actionPrintPreview.setEnabled(true);
        actionPrintPreview.setDaemonRun(false);

        actionPrintPreview.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("shift ctrl P"));
        _tempStr = resHelper.getString("ActionPrintPreview.SHORT_DESCRIPTION");
        actionPrintPreview.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrintPreview.LONG_DESCRIPTION");
        actionPrintPreview.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrintPreview.NAME");
        actionPrintPreview.putValue(ItemAction.NAME, _tempStr);
         this.actionPrintPreview.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionPrintPreview.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionPrintPreview.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionAudit
        this.actionAudit = new ActionAudit(this);
        getActionManager().registerAction("actionAudit", actionAudit);
        this.actionAudit.setExtendProperty("canForewarn", "true");
        this.actionAudit.setExtendProperty("userDefined", "true");
        this.actionAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionUnAudit
        this.actionUnAudit = new ActionUnAudit(this);
        getActionManager().registerAction("actionUnAudit", actionUnAudit);
        this.actionUnAudit.setExtendProperty("canForewarn", "true");
        this.actionUnAudit.setExtendProperty("userDefined", "true");
        this.actionUnAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweightBill = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmaterial = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsupplier = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttruckNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contarriveDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsendDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contconclusion = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsampleNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttakeOffPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttakeOffBasePrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttakeOffWeight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpurOrder = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpurOrderNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpriceAfterTakeOff = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpriceBeforeTakeOff = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contproductFactory = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsendPerson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contunloadArea = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contBuckAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrealAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsumweight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalcon = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisWeight = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtweightBill = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtperson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtmaterial = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtsupplier = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txttruckNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkarriveDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pksendDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.scrollPaneconclusion = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txtconclusion = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.txtsampleNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txttakeOffPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttakeOffBasePrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttakeOffWeight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtpurOrder = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtpurOrderNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtpriceAfterTakeOff = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpriceBeforeTakeOff = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtproductFactory = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtsendPerson = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtunloadArea = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.txtcontractItem = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.txtBuckAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtrealAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsumweight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.totalcon = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.contweightBill.setName("contweightBill");
        this.contperson.setName("contperson");
        this.contmaterial.setName("contmaterial");
        this.contsupplier.setName("contsupplier");
        this.conttruckNumber.setName("conttruckNumber");
        this.contarriveDate.setName("contarriveDate");
        this.contsendDate.setName("contsendDate");
        this.contauditTime.setName("contauditTime");
        this.contbaseStatus.setName("contbaseStatus");
        this.contconclusion.setName("contconclusion");
        this.contsampleNumber.setName("contsampleNumber");
        this.conttakeOffPrice.setName("conttakeOffPrice");
        this.conttakeOffBasePrice.setName("conttakeOffBasePrice");
        this.conttakeOffWeight.setName("conttakeOffWeight");
        this.contpurOrder.setName("contpurOrder");
        this.contpurOrderNumber.setName("contpurOrderNumber");
        this.contpriceAfterTakeOff.setName("contpriceAfterTakeOff");
        this.contpriceBeforeTakeOff.setName("contpriceBeforeTakeOff");
        this.contproductFactory.setName("contproductFactory");
        this.contsendPerson.setName("contsendPerson");
        this.contunloadArea.setName("contunloadArea");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contBuckAmount.setName("contBuckAmount");
        this.contrealAmount.setName("contrealAmount");
        this.contsumweight.setName("contsumweight");
        this.conttotalcon.setName("conttotalcon");
        this.chkisWeight.setName("chkisWeight");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtweightBill.setName("prmtweightBill");
        this.prmtperson.setName("prmtperson");
        this.prmtmaterial.setName("prmtmaterial");
        this.prmtsupplier.setName("prmtsupplier");
        this.txttruckNumber.setName("txttruckNumber");
        this.pkarriveDate.setName("pkarriveDate");
        this.pksendDate.setName("pksendDate");
        this.pkauditTime.setName("pkauditTime");
        this.baseStatus.setName("baseStatus");
        this.scrollPaneconclusion.setName("scrollPaneconclusion");
        this.txtconclusion.setName("txtconclusion");
        this.txtsampleNumber.setName("txtsampleNumber");
        this.txttakeOffPrice.setName("txttakeOffPrice");
        this.txttakeOffBasePrice.setName("txttakeOffBasePrice");
        this.txttakeOffWeight.setName("txttakeOffWeight");
        this.prmtpurOrder.setName("prmtpurOrder");
        this.txtpurOrderNumber.setName("txtpurOrderNumber");
        this.txtpriceAfterTakeOff.setName("txtpriceAfterTakeOff");
        this.txtpriceBeforeTakeOff.setName("txtpriceBeforeTakeOff");
        this.txtproductFactory.setName("txtproductFactory");
        this.txtsendPerson.setName("txtsendPerson");
        this.txtunloadArea.setName("txtunloadArea");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kdtEntrys.setName("kdtEntrys");
        this.txtcontractItem.setName("txtcontractItem");
        this.txtBuckAmount.setName("txtBuckAmount");
        this.txtrealAmount.setName("txtrealAmount");
        this.txtsumweight.setName("txtsumweight");
        this.totalcon.setName("totalcon");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
        // CoreUI		
        this.btnTraceUp.setVisible(false);		
        this.btnTraceDown.setVisible(false);		
        this.btnCreateTo.setVisible(true);		
        this.btnAddLine.setVisible(false);		
        this.btnCopyLine.setVisible(false);		
        this.btnInsertLine.setVisible(false);		
        this.btnRemoveLine.setVisible(false);		
        this.btnAuditResult.setVisible(false);		
        this.separator1.setVisible(false);		
        this.menuItemCreateTo.setVisible(true);		
        this.separator3.setVisible(false);		
        this.menuItemTraceUp.setVisible(false);		
        this.menuItemTraceDown.setVisible(false);		
        this.menuTable1.setVisible(false);		
        this.menuItemAddLine.setVisible(false);		
        this.menuItemCopyLine.setVisible(false);		
        this.menuItemInsertLine.setVisible(false);		
        this.menuItemRemoveLine.setVisible(false);		
        this.menuItemViewSubmitProccess.setVisible(false);		
        this.menuItemViewDoProccess.setVisible(false);		
        this.menuItemAuditResult.setVisible(false);
        // contCreator		
        this.contCreator.setBoundLabelText(resHelper.getString("contCreator.boundLabelText"));		
        this.contCreator.setBoundLabelLength(100);		
        this.contCreator.setBoundLabelUnderline(true);		
        this.contCreator.setEnabled(false);
        // contCreateTime		
        this.contCreateTime.setBoundLabelText(resHelper.getString("contCreateTime.boundLabelText"));		
        this.contCreateTime.setBoundLabelLength(100);		
        this.contCreateTime.setBoundLabelUnderline(true);		
        this.contCreateTime.setEnabled(false);
        // contLastUpdateUser		
        this.contLastUpdateUser.setBoundLabelText(resHelper.getString("contLastUpdateUser.boundLabelText"));		
        this.contLastUpdateUser.setBoundLabelLength(100);		
        this.contLastUpdateUser.setBoundLabelUnderline(true);		
        this.contLastUpdateUser.setEnabled(false);		
        this.contLastUpdateUser.setVisible(false);
        // contLastUpdateTime		
        this.contLastUpdateTime.setBoundLabelText(resHelper.getString("contLastUpdateTime.boundLabelText"));		
        this.contLastUpdateTime.setBoundLabelLength(100);		
        this.contLastUpdateTime.setBoundLabelUnderline(true);		
        this.contLastUpdateTime.setEnabled(false);		
        this.contLastUpdateTime.setVisible(false);
        // contNumber		
        this.contNumber.setBoundLabelText(resHelper.getString("contNumber.boundLabelText"));		
        this.contNumber.setBoundLabelLength(130);		
        this.contNumber.setBoundLabelUnderline(true);
        // contBizDate		
        this.contBizDate.setBoundLabelText(resHelper.getString("contBizDate.boundLabelText"));		
        this.contBizDate.setBoundLabelLength(130);		
        this.contBizDate.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelAlignment(7);		
        this.contBizDate.setVisible(true);
        // contDescription		
        this.contDescription.setBoundLabelText(resHelper.getString("contDescription.boundLabelText"));		
        this.contDescription.setBoundLabelLength(130);		
        this.contDescription.setBoundLabelUnderline(true);
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);
        // contweightBill		
        this.contweightBill.setBoundLabelText(resHelper.getString("contweightBill.boundLabelText"));		
        this.contweightBill.setBoundLabelLength(130);		
        this.contweightBill.setBoundLabelUnderline(true);		
        this.contweightBill.setVisible(true);
        // contperson		
        this.contperson.setBoundLabelText(resHelper.getString("contperson.boundLabelText"));		
        this.contperson.setBoundLabelLength(130);		
        this.contperson.setBoundLabelUnderline(true);		
        this.contperson.setVisible(true);
        // contmaterial		
        this.contmaterial.setBoundLabelText(resHelper.getString("contmaterial.boundLabelText"));		
        this.contmaterial.setBoundLabelLength(130);		
        this.contmaterial.setBoundLabelUnderline(true);		
        this.contmaterial.setVisible(true);
        // contsupplier		
        this.contsupplier.setBoundLabelText(resHelper.getString("contsupplier.boundLabelText"));		
        this.contsupplier.setBoundLabelLength(130);		
        this.contsupplier.setBoundLabelUnderline(true);		
        this.contsupplier.setVisible(true);
        // conttruckNumber		
        this.conttruckNumber.setBoundLabelText(resHelper.getString("conttruckNumber.boundLabelText"));		
        this.conttruckNumber.setBoundLabelLength(130);		
        this.conttruckNumber.setBoundLabelUnderline(true);		
        this.conttruckNumber.setVisible(true);
        // contarriveDate		
        this.contarriveDate.setBoundLabelText(resHelper.getString("contarriveDate.boundLabelText"));		
        this.contarriveDate.setBoundLabelLength(130);		
        this.contarriveDate.setBoundLabelUnderline(true);		
        this.contarriveDate.setVisible(true);
        // contsendDate		
        this.contsendDate.setBoundLabelText(resHelper.getString("contsendDate.boundLabelText"));		
        this.contsendDate.setBoundLabelLength(130);		
        this.contsendDate.setBoundLabelUnderline(true);		
        this.contsendDate.setVisible(true);
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(130);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);
        // contconclusion		
        this.contconclusion.setBoundLabelText(resHelper.getString("contconclusion.boundLabelText"));		
        this.contconclusion.setBoundLabelLength(130);		
        this.contconclusion.setBoundLabelUnderline(true);		
        this.contconclusion.setVisible(true);
        // contsampleNumber		
        this.contsampleNumber.setBoundLabelText(resHelper.getString("contsampleNumber.boundLabelText"));		
        this.contsampleNumber.setBoundLabelLength(130);		
        this.contsampleNumber.setBoundLabelUnderline(true);		
        this.contsampleNumber.setVisible(false);
        // conttakeOffPrice		
        this.conttakeOffPrice.setBoundLabelText(resHelper.getString("conttakeOffPrice.boundLabelText"));		
        this.conttakeOffPrice.setBoundLabelLength(130);		
        this.conttakeOffPrice.setBoundLabelUnderline(true);		
        this.conttakeOffPrice.setVisible(true);
        // conttakeOffBasePrice		
        this.conttakeOffBasePrice.setBoundLabelText(resHelper.getString("conttakeOffBasePrice.boundLabelText"));		
        this.conttakeOffBasePrice.setBoundLabelLength(130);		
        this.conttakeOffBasePrice.setBoundLabelUnderline(true);		
        this.conttakeOffBasePrice.setVisible(false);
        // conttakeOffWeight		
        this.conttakeOffWeight.setBoundLabelText(resHelper.getString("conttakeOffWeight.boundLabelText"));		
        this.conttakeOffWeight.setBoundLabelLength(130);		
        this.conttakeOffWeight.setBoundLabelUnderline(true);		
        this.conttakeOffWeight.setVisible(false);
        // contpurOrder		
        this.contpurOrder.setBoundLabelText(resHelper.getString("contpurOrder.boundLabelText"));		
        this.contpurOrder.setBoundLabelLength(130);		
        this.contpurOrder.setBoundLabelUnderline(true);		
        this.contpurOrder.setVisible(true);
        // contpurOrderNumber		
        this.contpurOrderNumber.setBoundLabelText(resHelper.getString("contpurOrderNumber.boundLabelText"));		
        this.contpurOrderNumber.setBoundLabelLength(130);		
        this.contpurOrderNumber.setBoundLabelUnderline(true);		
        this.contpurOrderNumber.setVisible(false);
        // contpriceAfterTakeOff		
        this.contpriceAfterTakeOff.setBoundLabelText(resHelper.getString("contpriceAfterTakeOff.boundLabelText"));		
        this.contpriceAfterTakeOff.setBoundLabelLength(130);		
        this.contpriceAfterTakeOff.setBoundLabelUnderline(true);		
        this.contpriceAfterTakeOff.setVisible(false);
        // contpriceBeforeTakeOff		
        this.contpriceBeforeTakeOff.setBoundLabelText(resHelper.getString("contpriceBeforeTakeOff.boundLabelText"));		
        this.contpriceBeforeTakeOff.setBoundLabelLength(130);		
        this.contpriceBeforeTakeOff.setBoundLabelUnderline(true);		
        this.contpriceBeforeTakeOff.setVisible(false);
        // contproductFactory		
        this.contproductFactory.setBoundLabelText(resHelper.getString("contproductFactory.boundLabelText"));		
        this.contproductFactory.setBoundLabelLength(130);		
        this.contproductFactory.setBoundLabelUnderline(true);		
        this.contproductFactory.setVisible(true);
        // contsendPerson		
        this.contsendPerson.setBoundLabelText(resHelper.getString("contsendPerson.boundLabelText"));		
        this.contsendPerson.setBoundLabelLength(130);		
        this.contsendPerson.setBoundLabelUnderline(true);		
        this.contsendPerson.setVisible(true);
        // contunloadArea		
        this.contunloadArea.setBoundLabelText(resHelper.getString("contunloadArea.boundLabelText"));		
        this.contunloadArea.setBoundLabelLength(130);		
        this.contunloadArea.setBoundLabelUnderline(true);		
        this.contunloadArea.setVisible(true);
        // kDTabbedPane1
        // contBuckAmount		
        this.contBuckAmount.setBoundLabelText(resHelper.getString("contBuckAmount.boundLabelText"));		
        this.contBuckAmount.setBoundLabelLength(130);		
        this.contBuckAmount.setBoundLabelUnderline(true);		
        this.contBuckAmount.setVisible(false);
        // contrealAmount		
        this.contrealAmount.setBoundLabelText(resHelper.getString("contrealAmount.boundLabelText"));		
        this.contrealAmount.setBoundLabelLength(130);		
        this.contrealAmount.setBoundLabelUnderline(true);		
        this.contrealAmount.setVisible(false);
        // contsumweight		
        this.contsumweight.setBoundLabelText(resHelper.getString("contsumweight.boundLabelText"));		
        this.contsumweight.setBoundLabelLength(130);		
        this.contsumweight.setBoundLabelUnderline(true);		
        this.contsumweight.setVisible(true);
        // conttotalcon		
        this.conttotalcon.setBoundLabelText(resHelper.getString("conttotalcon.boundLabelText"));		
        this.conttotalcon.setBoundLabelLength(130);		
        this.conttotalcon.setBoundLabelUnderline(true);		
        this.conttotalcon.setVisible(true);
        // chkisWeight		
        this.chkisWeight.setText(resHelper.getString("chkisWeight.text"));		
        this.chkisWeight.setVisible(true);		
        this.chkisWeight.setHorizontalAlignment(2);		
        this.chkisWeight.setEnabled(false);
        // prmtCreator		
        this.prmtCreator.setEnabled(false);
        // kDDateCreateTime		
        this.kDDateCreateTime.setTimeEnabled(true);		
        this.kDDateCreateTime.setEnabled(false);
        // prmtLastUpdateUser		
        this.prmtLastUpdateUser.setEnabled(false);
        // kDDateLastUpdateTime		
        this.kDDateLastUpdateTime.setTimeEnabled(true);		
        this.kDDateLastUpdateTime.setEnabled(false);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // pkBizDate		
        this.pkBizDate.setEnabled(true);
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // prmtweightBill		
        this.prmtweightBill.setQueryInfo("com.kingdee.eas.weighbridge.app.InStorageBillQuery");		
        this.prmtweightBill.setEditable(true);		
        this.prmtweightBill.setDisplayFormat("$number$");		
        this.prmtweightBill.setEditFormat("$number$");		
        this.prmtweightBill.setCommitFormat("$number$");		
        this.prmtweightBill.setRequired(false);		
        this.prmtweightBill.setEnabled(false);
        // prmtperson		
        this.prmtperson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonFilterQuery");		
        this.prmtperson.setEditable(true);		
        this.prmtperson.setDisplayFormat("$name$");		
        this.prmtperson.setEditFormat("$number$");		
        this.prmtperson.setCommitFormat("$number$");		
        this.prmtperson.setRequired(true);
        // prmtmaterial		
        this.prmtmaterial.setQueryInfo("com.kingdee.eas.basedata.master.material.app.MaterialQuery");		
        this.prmtmaterial.setEditable(true);		
        this.prmtmaterial.setDisplayFormat("$name$");		
        this.prmtmaterial.setEditFormat("$number$");		
        this.prmtmaterial.setCommitFormat("$number$");		
        this.prmtmaterial.setRequired(true);
        this.prmtmaterial.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtmaterial_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // prmtsupplier		
        this.prmtsupplier.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.PSupplierQuery");		
        this.prmtsupplier.setEditable(true);		
        this.prmtsupplier.setDisplayFormat("$name$");		
        this.prmtsupplier.setEditFormat("$number$");		
        this.prmtsupplier.setCommitFormat("$number$");		
        this.prmtsupplier.setRequired(true);		
        this.prmtsupplier.setEnabled(false);
        // txttruckNumber		
        this.txttruckNumber.setHorizontalAlignment(2);		
        this.txttruckNumber.setMaxLength(100);		
        this.txttruckNumber.setRequired(false);		
        this.txttruckNumber.setEnabled(false);
        // pkarriveDate		
        this.pkarriveDate.setRequired(false);
        // pksendDate		
        this.pksendDate.setRequired(false);		
        this.pksendDate.setVisible(false);
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(false);		
        this.baseStatus.setEnabled(false);
        // scrollPaneconclusion
        // txtconclusion		
        this.txtconclusion.setRequired(false);		
        this.txtconclusion.setMaxLength(1000);
        // txtsampleNumber		
        this.txtsampleNumber.setHorizontalAlignment(2);		
        this.txtsampleNumber.setMaxLength(100);		
        this.txtsampleNumber.setRequired(false);		
        this.txtsampleNumber.setVisible(false);
        // txttakeOffPrice		
        this.txttakeOffPrice.setHorizontalAlignment(2);		
        this.txttakeOffPrice.setDataType(1);		
        this.txttakeOffPrice.setSupportedEmpty(true);		
        this.txttakeOffPrice.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txttakeOffPrice.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txttakeOffPrice.setPrecision(2);		
        this.txttakeOffPrice.setRequired(false);		
        this.txttakeOffPrice.setVisible(false);
        this.txttakeOffPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    txttakeOffPrice_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // txttakeOffBasePrice		
        this.txttakeOffBasePrice.setHorizontalAlignment(2);		
        this.txttakeOffBasePrice.setDataType(1);		
        this.txttakeOffBasePrice.setSupportedEmpty(true);		
        this.txttakeOffBasePrice.setMinimumValue( new java.math.BigDecimal("-1.0E22"));		
        this.txttakeOffBasePrice.setMaximumValue( new java.math.BigDecimal("1.0E22"));		
        this.txttakeOffBasePrice.setPrecision(6);		
        this.txttakeOffBasePrice.setRequired(false);		
        this.txttakeOffBasePrice.setVisible(false);
        // txttakeOffWeight		
        this.txttakeOffWeight.setVisible(false);		
        this.txttakeOffWeight.setHorizontalAlignment(2);		
        this.txttakeOffWeight.setDataType(1);		
        this.txttakeOffWeight.setSupportedEmpty(true);		
        this.txttakeOffWeight.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txttakeOffWeight.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txttakeOffWeight.setPrecision(2);		
        this.txttakeOffWeight.setRequired(false);
        // prmtpurOrder		
        this.prmtpurOrder.setQueryInfo("com.kingdee.eas.scm.sm.pur.app.PurOrderQuery");		
        this.prmtpurOrder.setEditable(true);		
        this.prmtpurOrder.setDisplayFormat("$number$");		
        this.prmtpurOrder.setEditFormat("$number$");		
        this.prmtpurOrder.setCommitFormat("$number$");		
        this.prmtpurOrder.setRequired(false);		
        this.prmtpurOrder.setEnabled(false);
        this.prmtpurOrder.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtpurOrder_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtpurOrderNumber		
        this.txtpurOrderNumber.setHorizontalAlignment(2);		
        this.txtpurOrderNumber.setMaxLength(100);		
        this.txtpurOrderNumber.setRequired(false);
        // txtpriceAfterTakeOff		
        this.txtpriceAfterTakeOff.setHorizontalAlignment(2);		
        this.txtpriceAfterTakeOff.setDataType(1);		
        this.txtpriceAfterTakeOff.setSupportedEmpty(true);		
        this.txtpriceAfterTakeOff.setMinimumValue( new java.math.BigDecimal("-1.0E22"));		
        this.txtpriceAfterTakeOff.setMaximumValue( new java.math.BigDecimal("1.0E22"));		
        this.txtpriceAfterTakeOff.setPrecision(6);		
        this.txtpriceAfterTakeOff.setRequired(false);		
        this.txtpriceAfterTakeOff.setEnabled(false);		
        this.txtpriceAfterTakeOff.setVisible(false);
        // txtpriceBeforeTakeOff		
        this.txtpriceBeforeTakeOff.setHorizontalAlignment(2);		
        this.txtpriceBeforeTakeOff.setDataType(1);		
        this.txtpriceBeforeTakeOff.setSupportedEmpty(true);		
        this.txtpriceBeforeTakeOff.setMinimumValue( new java.math.BigDecimal("-1.0E22"));		
        this.txtpriceBeforeTakeOff.setMaximumValue( new java.math.BigDecimal("1.0E22"));		
        this.txtpriceBeforeTakeOff.setPrecision(6);		
        this.txtpriceBeforeTakeOff.setRequired(false);		
        this.txtpriceBeforeTakeOff.setVisible(false);
        // txtproductFactory		
        this.txtproductFactory.setHorizontalAlignment(2);		
        this.txtproductFactory.setMaxLength(100);		
        this.txtproductFactory.setRequired(false);		
        this.txtproductFactory.setEnabled(false);
        // txtsendPerson		
        this.txtsendPerson.setHorizontalAlignment(2);		
        this.txtsendPerson.setMaxLength(100);		
        this.txtsendPerson.setRequired(false);		
        this.txtsendPerson.setVisible(false);
        // txtunloadArea		
        this.txtunloadArea.setHorizontalAlignment(2);		
        this.txtunloadArea.setMaxLength(100);		
        this.txtunloadArea.setRequired(false);
        // kDPanel1
        // kDPanel2
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol9\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol12\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol14\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"qcItem\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"qcresult0\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"qcresult1\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"qcresult2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"qcresult3\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"qcresult4\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"qcresult\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"qcUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"lower\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"upper\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"standardValue\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"allowDeffValue\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"gs\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"DeductWgt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"qcConclusion\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"qcPerson\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"description\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{qcItem}</t:Cell><t:Cell>$Resource{qcresult0}</t:Cell><t:Cell>$Resource{qcresult1}</t:Cell><t:Cell>$Resource{qcresult2}</t:Cell><t:Cell>$Resource{qcresult3}</t:Cell><t:Cell>$Resource{qcresult4}</t:Cell><t:Cell>$Resource{qcresult}</t:Cell><t:Cell>$Resource{qcUnit}</t:Cell><t:Cell>$Resource{lower}</t:Cell><t:Cell>$Resource{upper}</t:Cell><t:Cell>$Resource{standardValue}</t:Cell><t:Cell>$Resource{allowDeffValue}</t:Cell><t:Cell>$Resource{gs}</t:Cell><t:Cell>$Resource{DeductWgt}</t:Cell><t:Cell>$Resource{qcConclusion}</t:Cell><t:Cell>$Resource{qcPerson}</t:Cell><t:Cell>$Resource{description}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));

                this.kdtEntrys.putBindContents("editData",new String[] {"id","qcItem","qcresult0","qcresult1","qcresult2","qcresult3","qcresult4","qcresult","qcUnit","lower","upper","standardValue","allowDeffValue","gs","DeductWgt","qcConclusion","qcPerson","description"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_qcItem_PromptBox = new KDBizPromptBox();
        kdtEntrys_qcItem_PromptBox.setQueryInfo("com.kingdee.eas.qm.basedata.app.F7QCItemQuery");
        kdtEntrys_qcItem_PromptBox.setVisible(true);
        kdtEntrys_qcItem_PromptBox.setEditable(true);
        kdtEntrys_qcItem_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_qcItem_PromptBox.setEditFormat("$number$");
        kdtEntrys_qcItem_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_qcItem_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qcItem_PromptBox);
        this.kdtEntrys.getColumn("qcItem").setEditor(kdtEntrys_qcItem_CellEditor);
        ObjectValueRender kdtEntrys_qcItem_OVR = new ObjectValueRender();
        kdtEntrys_qcItem_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("qcItem").setRenderer(kdtEntrys_qcItem_OVR);
        			kdtEntrys_qcItem_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.qm.basedata.client.QCItemListUI kdtEntrys_qcItem_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_qcItem_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_qcItem_PromptBox_F7ListUI = new com.kingdee.eas.qm.basedata.client.QCItemListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_qcItem_PromptBox_F7ListUI));
					kdtEntrys_qcItem_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_qcItem_PromptBox.setSelector(kdtEntrys_qcItem_PromptBox_F7ListUI);
				}
			}
		});
					
        KDTextField kdtEntrys_qcresult0_TextField = new KDTextField();
        kdtEntrys_qcresult0_TextField.setName("kdtEntrys_qcresult0_TextField");
        kdtEntrys_qcresult0_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_qcresult0_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qcresult0_TextField);
        this.kdtEntrys.getColumn("qcresult0").setEditor(kdtEntrys_qcresult0_CellEditor);
        KDTextField kdtEntrys_qcresult1_TextField = new KDTextField();
        kdtEntrys_qcresult1_TextField.setName("kdtEntrys_qcresult1_TextField");
        kdtEntrys_qcresult1_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_qcresult1_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qcresult1_TextField);
        this.kdtEntrys.getColumn("qcresult1").setEditor(kdtEntrys_qcresult1_CellEditor);
        KDTextField kdtEntrys_qcresult2_TextField = new KDTextField();
        kdtEntrys_qcresult2_TextField.setName("kdtEntrys_qcresult2_TextField");
        kdtEntrys_qcresult2_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_qcresult2_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qcresult2_TextField);
        this.kdtEntrys.getColumn("qcresult2").setEditor(kdtEntrys_qcresult2_CellEditor);
        KDTextField kdtEntrys_qcresult3_TextField = new KDTextField();
        kdtEntrys_qcresult3_TextField.setName("kdtEntrys_qcresult3_TextField");
        kdtEntrys_qcresult3_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_qcresult3_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qcresult3_TextField);
        this.kdtEntrys.getColumn("qcresult3").setEditor(kdtEntrys_qcresult3_CellEditor);
        KDTextField kdtEntrys_qcresult4_TextField = new KDTextField();
        kdtEntrys_qcresult4_TextField.setName("kdtEntrys_qcresult4_TextField");
        kdtEntrys_qcresult4_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_qcresult4_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qcresult4_TextField);
        this.kdtEntrys.getColumn("qcresult4").setEditor(kdtEntrys_qcresult4_CellEditor);
        KDTextField kdtEntrys_qcresult_TextField = new KDTextField();
        kdtEntrys_qcresult_TextField.setName("kdtEntrys_qcresult_TextField");
        kdtEntrys_qcresult_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_qcresult_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qcresult_TextField);
        this.kdtEntrys.getColumn("qcresult").setEditor(kdtEntrys_qcresult_CellEditor);
        final KDBizPromptBox kdtEntrys_qcUnit_PromptBox = new KDBizPromptBox();
        kdtEntrys_qcUnit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtEntrys_qcUnit_PromptBox.setVisible(true);
        kdtEntrys_qcUnit_PromptBox.setEditable(true);
        kdtEntrys_qcUnit_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_qcUnit_PromptBox.setEditFormat("$number$");
        kdtEntrys_qcUnit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_qcUnit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qcUnit_PromptBox);
        this.kdtEntrys.getColumn("qcUnit").setEditor(kdtEntrys_qcUnit_CellEditor);
        ObjectValueRender kdtEntrys_qcUnit_OVR = new ObjectValueRender();
        kdtEntrys_qcUnit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("qcUnit").setRenderer(kdtEntrys_qcUnit_OVR);
        KDFormattedTextField kdtEntrys_lower_TextField = new KDFormattedTextField();
        kdtEntrys_lower_TextField.setName("kdtEntrys_lower_TextField");
        kdtEntrys_lower_TextField.setVisible(true);
        kdtEntrys_lower_TextField.setEditable(true);
        kdtEntrys_lower_TextField.setHorizontalAlignment(2);
        kdtEntrys_lower_TextField.setDataType(1);
        	kdtEntrys_lower_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E24"));
        	kdtEntrys_lower_TextField.setMaximumValue(new java.math.BigDecimal("1.0E24"));
        kdtEntrys_lower_TextField.setPrecision(4);
        KDTDefaultCellEditor kdtEntrys_lower_CellEditor = new KDTDefaultCellEditor(kdtEntrys_lower_TextField);
        this.kdtEntrys.getColumn("lower").setEditor(kdtEntrys_lower_CellEditor);
        KDFormattedTextField kdtEntrys_upper_TextField = new KDFormattedTextField();
        kdtEntrys_upper_TextField.setName("kdtEntrys_upper_TextField");
        kdtEntrys_upper_TextField.setVisible(true);
        kdtEntrys_upper_TextField.setEditable(true);
        kdtEntrys_upper_TextField.setHorizontalAlignment(2);
        kdtEntrys_upper_TextField.setDataType(1);
        	kdtEntrys_upper_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E24"));
        	kdtEntrys_upper_TextField.setMaximumValue(new java.math.BigDecimal("1.0E24"));
        kdtEntrys_upper_TextField.setPrecision(4);
        KDTDefaultCellEditor kdtEntrys_upper_CellEditor = new KDTDefaultCellEditor(kdtEntrys_upper_TextField);
        this.kdtEntrys.getColumn("upper").setEditor(kdtEntrys_upper_CellEditor);
        KDTextField kdtEntrys_standardValue_TextField = new KDTextField();
        kdtEntrys_standardValue_TextField.setName("kdtEntrys_standardValue_TextField");
        kdtEntrys_standardValue_TextField.setMaxLength(200);
        KDTDefaultCellEditor kdtEntrys_standardValue_CellEditor = new KDTDefaultCellEditor(kdtEntrys_standardValue_TextField);
        this.kdtEntrys.getColumn("standardValue").setEditor(kdtEntrys_standardValue_CellEditor);
        KDTextField kdtEntrys_allowDeffValue_TextField = new KDTextField();
        kdtEntrys_allowDeffValue_TextField.setName("kdtEntrys_allowDeffValue_TextField");
        kdtEntrys_allowDeffValue_TextField.setMaxLength(200);
        KDTDefaultCellEditor kdtEntrys_allowDeffValue_CellEditor = new KDTDefaultCellEditor(kdtEntrys_allowDeffValue_TextField);
        this.kdtEntrys.getColumn("allowDeffValue").setEditor(kdtEntrys_allowDeffValue_CellEditor);
        KDTextField kdtEntrys_gs_TextField = new KDTextField();
        kdtEntrys_gs_TextField.setName("kdtEntrys_gs_TextField");
        kdtEntrys_gs_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_gs_CellEditor = new KDTDefaultCellEditor(kdtEntrys_gs_TextField);
        this.kdtEntrys.getColumn("gs").setEditor(kdtEntrys_gs_CellEditor);
        KDFormattedTextField kdtEntrys_DeductWgt_TextField = new KDFormattedTextField();
        kdtEntrys_DeductWgt_TextField.setName("kdtEntrys_DeductWgt_TextField");
        kdtEntrys_DeductWgt_TextField.setVisible(true);
        kdtEntrys_DeductWgt_TextField.setEditable(true);
        kdtEntrys_DeductWgt_TextField.setHorizontalAlignment(2);
        kdtEntrys_DeductWgt_TextField.setDataType(1);
        	kdtEntrys_DeductWgt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_DeductWgt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_DeductWgt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_DeductWgt_CellEditor = new KDTDefaultCellEditor(kdtEntrys_DeductWgt_TextField);
        this.kdtEntrys.getColumn("DeductWgt").setEditor(kdtEntrys_DeductWgt_CellEditor);
        KDComboBox kdtEntrys_qcConclusion_ComboBox = new KDComboBox();
        kdtEntrys_qcConclusion_ComboBox.setName("kdtEntrys_qcConclusion_ComboBox");
        kdtEntrys_qcConclusion_ComboBox.setVisible(true);
        kdtEntrys_qcConclusion_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.feedfactory.QCResult").toArray());
        KDTDefaultCellEditor kdtEntrys_qcConclusion_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qcConclusion_ComboBox);
        this.kdtEntrys.getColumn("qcConclusion").setEditor(kdtEntrys_qcConclusion_CellEditor);
        final KDBizPromptBox kdtEntrys_qcPerson_PromptBox = new KDBizPromptBox();
        kdtEntrys_qcPerson_PromptBox.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");
        kdtEntrys_qcPerson_PromptBox.setVisible(true);
        kdtEntrys_qcPerson_PromptBox.setEditable(true);
        kdtEntrys_qcPerson_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_qcPerson_PromptBox.setEditFormat("$number$");
        kdtEntrys_qcPerson_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_qcPerson_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qcPerson_PromptBox);
        this.kdtEntrys.getColumn("qcPerson").setEditor(kdtEntrys_qcPerson_CellEditor);
        ObjectValueRender kdtEntrys_qcPerson_OVR = new ObjectValueRender();
        kdtEntrys_qcPerson_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("qcPerson").setRenderer(kdtEntrys_qcPerson_OVR);
        KDTextField kdtEntrys_description_TextField = new KDTextField();
        kdtEntrys_description_TextField.setName("kdtEntrys_description_TextField");
        kdtEntrys_description_TextField.setMaxLength(255);
        KDTDefaultCellEditor kdtEntrys_description_CellEditor = new KDTDefaultCellEditor(kdtEntrys_description_TextField);
        this.kdtEntrys.getColumn("description").setEditor(kdtEntrys_description_CellEditor);
        // txtcontractItem		
        this.txtcontractItem.setRequired(false);		
        this.txtcontractItem.setMaxLength(2000);
        // txtBuckAmount		
        this.txtBuckAmount.setHorizontalAlignment(2);		
        this.txtBuckAmount.setDataType(1);		
        this.txtBuckAmount.setSupportedEmpty(true);		
        this.txtBuckAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtBuckAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtBuckAmount.setPrecision(2);		
        this.txtBuckAmount.setRequired(false);		
        this.txtBuckAmount.setEnabled(false);		
        this.txtBuckAmount.setVisible(false);
        // txtrealAmount		
        this.txtrealAmount.setHorizontalAlignment(2);		
        this.txtrealAmount.setDataType(1);		
        this.txtrealAmount.setSupportedEmpty(true);		
        this.txtrealAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtrealAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtrealAmount.setPrecision(2);		
        this.txtrealAmount.setRequired(false);		
        this.txtrealAmount.setVisible(false);
        // txtsumweight		
        this.txtsumweight.setHorizontalAlignment(2);		
        this.txtsumweight.setDataType(1);		
        this.txtsumweight.setSupportedEmpty(true);		
        this.txtsumweight.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsumweight.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsumweight.setPrecision(4);		
        this.txtsumweight.setRequired(false);		
        this.txtsumweight.setEnabled(false);
        // totalcon		
        this.totalcon.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.feedfactory.QCReturn").toArray());		
        this.totalcon.setRequired(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtweightBill,prmtperson,prmtmaterial,prmtsupplier,txttruckNumber,pkarriveDate,pksendDate,pkauditTime,baseStatus,txtconclusion,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,txtsampleNumber,txttakeOffPrice,txttakeOffBasePrice,txttakeOffWeight,prmtpurOrder,txtpurOrderNumber,txtpriceBeforeTakeOff,txtpriceAfterTakeOff,txtproductFactory,txtsendPerson,txtunloadArea,txtBuckAmount,txtrealAmount,txtcontractItem,txtsumweight,totalcon,kdtEntrys,chkisWeight}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 500));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1013, 500));
        contCreator.setBounds(new Rectangle(10, 448, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(10, 448, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(10, 472, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(10, 472, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(370, 448, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(370, 448, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(370, 472, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(370, 472, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contNumber.setBounds(new Rectangle(10, 10, 300, 19));
        this.add(contNumber, new KDLayout.Constraints(10, 10, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(355, 56, 300, 19));
        this.add(contBizDate, new KDLayout.Constraints(355, 56, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(355, 79, 300, 19));
        this.add(contDescription, new KDLayout.Constraints(355, 79, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(731, 448, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(731, 448, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contweightBill.setBounds(new Rectangle(701, 102, 300, 19));
        this.add(contweightBill, new KDLayout.Constraints(701, 102, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contperson.setBounds(new Rectangle(701, 53, 300, 19));
        this.add(contperson, new KDLayout.Constraints(701, 53, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contmaterial.setBounds(new Rectangle(10, 33, 300, 19));
        this.add(contmaterial, new KDLayout.Constraints(10, 33, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsupplier.setBounds(new Rectangle(355, 33, 300, 19));
        this.add(contsupplier, new KDLayout.Constraints(355, 33, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttruckNumber.setBounds(new Rectangle(701, 30, 300, 19));
        this.add(conttruckNumber, new KDLayout.Constraints(701, 30, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contarriveDate.setBounds(new Rectangle(10, 56, 300, 19));
        this.add(contarriveDate, new KDLayout.Constraints(10, 56, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsendDate.setBounds(new Rectangle(-355, 56, 300, 19));
        this.add(contsendDate, new KDLayout.Constraints(-355, 56, 300, 19, 0));
        contauditTime.setBounds(new Rectangle(731, 472, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(731, 472, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbaseStatus.setBounds(new Rectangle(700, 8, 300, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(700, 8, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contconclusion.setBounds(new Rectangle(11, 143, 991, 69));
        this.add(contconclusion, new KDLayout.Constraints(11, 143, 991, 69, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contsampleNumber.setBounds(new Rectangle(10, 156, 300, 19));
        this.add(contsampleNumber, new KDLayout.Constraints(10, 156, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttakeOffPrice.setBounds(new Rectangle(10, -302, 300, 19));
        this.add(conttakeOffPrice, new KDLayout.Constraints(10, -302, 300, 19, 0));
        conttakeOffBasePrice.setBounds(new Rectangle(10, 150, 300, 19));
        this.add(conttakeOffBasePrice, new KDLayout.Constraints(10, 150, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttakeOffWeight.setBounds(new Rectangle(-681, 132, 300, 19));
        this.add(conttakeOffWeight, new KDLayout.Constraints(-681, 132, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contpurOrder.setBounds(new Rectangle(355, 10, 300, 19));
        this.add(contpurOrder, new KDLayout.Constraints(355, 10, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpurOrderNumber.setBounds(new Rectangle(588, 159, 300, 19));
        this.add(contpurOrderNumber, new KDLayout.Constraints(588, 159, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contpriceAfterTakeOff.setBounds(new Rectangle(355, 153, 300, 19));
        this.add(contpriceAfterTakeOff, new KDLayout.Constraints(355, 153, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpriceBeforeTakeOff.setBounds(new Rectangle(10, 139, 300, 19));
        this.add(contpriceBeforeTakeOff, new KDLayout.Constraints(10, 139, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contproductFactory.setBounds(new Rectangle(701, 77, 300, 19));
        this.add(contproductFactory, new KDLayout.Constraints(701, 77, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contsendPerson.setBounds(new Rectangle(-355, 151, 300, 19));
        this.add(contsendPerson, new KDLayout.Constraints(-355, 151, 300, 19, 0));
        contunloadArea.setBounds(new Rectangle(10, 105, 300, 19));
        this.add(contunloadArea, new KDLayout.Constraints(10, 105, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane1.setBounds(new Rectangle(11, 220, 987, 219));
        this.add(kDTabbedPane1, new KDLayout.Constraints(11, 220, 987, 219, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contBuckAmount.setBounds(new Rectangle(10, 154, 299, 19));
        this.add(contBuckAmount, new KDLayout.Constraints(10, 154, 299, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contrealAmount.setBounds(new Rectangle(717, 139, 301, 19));
        this.add(contrealAmount, new KDLayout.Constraints(717, 139, 301, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsumweight.setBounds(new Rectangle(10, 81, 299, 19));
        this.add(contsumweight, new KDLayout.Constraints(10, 81, 299, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttotalcon.setBounds(new Rectangle(355, 104, 299, 19));
        this.add(conttotalcon, new KDLayout.Constraints(355, 104, 299, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisWeight.setBounds(new Rectangle(9, 127, 270, 19));
        this.add(chkisWeight, new KDLayout.Constraints(9, 127, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contCreator
        contCreator.setBoundEditor(prmtCreator);
        //contCreateTime
        contCreateTime.setBoundEditor(kDDateCreateTime);
        //contLastUpdateUser
        contLastUpdateUser.setBoundEditor(prmtLastUpdateUser);
        //contLastUpdateTime
        contLastUpdateTime.setBoundEditor(kDDateLastUpdateTime);
        //contNumber
        contNumber.setBoundEditor(txtNumber);
        //contBizDate
        contBizDate.setBoundEditor(pkBizDate);
        //contDescription
        contDescription.setBoundEditor(txtDescription);
        //contAuditor
        contAuditor.setBoundEditor(prmtAuditor);
        //contweightBill
        contweightBill.setBoundEditor(prmtweightBill);
        //contperson
        contperson.setBoundEditor(prmtperson);
        //contmaterial
        contmaterial.setBoundEditor(prmtmaterial);
        //contsupplier
        contsupplier.setBoundEditor(prmtsupplier);
        //conttruckNumber
        conttruckNumber.setBoundEditor(txttruckNumber);
        //contarriveDate
        contarriveDate.setBoundEditor(pkarriveDate);
        //contsendDate
        contsendDate.setBoundEditor(pksendDate);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //contconclusion
        contconclusion.setBoundEditor(scrollPaneconclusion);
        //scrollPaneconclusion
        scrollPaneconclusion.getViewport().add(txtconclusion, null);
        //contsampleNumber
        contsampleNumber.setBoundEditor(txtsampleNumber);
        //conttakeOffPrice
        conttakeOffPrice.setBoundEditor(txttakeOffPrice);
        //conttakeOffBasePrice
        conttakeOffBasePrice.setBoundEditor(txttakeOffBasePrice);
        //conttakeOffWeight
        conttakeOffWeight.setBoundEditor(txttakeOffWeight);
        //contpurOrder
        contpurOrder.setBoundEditor(prmtpurOrder);
        //contpurOrderNumber
        contpurOrderNumber.setBoundEditor(txtpurOrderNumber);
        //contpriceAfterTakeOff
        contpriceAfterTakeOff.setBoundEditor(txtpriceAfterTakeOff);
        //contpriceBeforeTakeOff
        contpriceBeforeTakeOff.setBoundEditor(txtpriceBeforeTakeOff);
        //contproductFactory
        contproductFactory.setBoundEditor(txtproductFactory);
        //contsendPerson
        contsendPerson.setBoundEditor(txtsendPerson);
        //contunloadArea
        contunloadArea.setBoundEditor(txtunloadArea);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 986, 186));        kdtEntrys.setBounds(new Rectangle(3, 4, 975, 174));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.feedfactory.QualityCheckBillEntryInfo(),null,false);
        kDPanel1.add(kdtEntrys_detailPanel, new KDLayout.Constraints(3, 4, 975, 174, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("qcConclusion","1");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 986, 186));        txtcontractItem.setBounds(new Rectangle(4, 4, 975, 160));
        kDPanel2.add(txtcontractItem, new KDLayout.Constraints(4, 4, 975, 160, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contBuckAmount
        contBuckAmount.setBoundEditor(txtBuckAmount);
        //contrealAmount
        contrealAmount.setBoundEditor(txtrealAmount);
        //contsumweight
        contsumweight.setBoundEditor(txtsumweight);
        //conttotalcon
        conttotalcon.setBoundEditor(totalcon);

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
        menuBiz.add(MenuItemPCVoucher);
        menuBiz.add(menuItemDelPCVoucher);
        //menuTable1
        menuTable1.add(menuItemAddLine);
        menuTable1.add(menuItemCopyLine);
        menuTable1.add(menuItemInsertLine);
        menuTable1.add(menuItemRemoveLine);
        //menuTool
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemMsgFormat);
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
        this.toolBar.add(btnEdit);
        this.toolBar.add(btnXunTong);
        this.toolBar.add(btnSave);
        this.toolBar.add(kDSeparatorCloud);
        this.toolBar.add(btnReset);
        this.toolBar.add(btnSubmit);
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);
        this.toolBar.add(btnCopy);
        this.toolBar.add(btnRemove);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);
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
        this.toolBar.add(btnTraceUp);
        this.toolBar.add(btnTraceDown);
        this.toolBar.add(btnWorkFlowG);
        this.toolBar.add(btnSignature);
        this.toolBar.add(btnViewSignature);
        this.toolBar.add(separatorFW4);
        this.toolBar.add(btnNumberSign);
        this.toolBar.add(separatorFW7);
        this.toolBar.add(btnCreateFrom);
        this.toolBar.add(btnCopyFrom);
        this.toolBar.add(btnCreateTo);
        this.toolBar.add(separatorFW5);
        this.toolBar.add(separatorFW8);
        this.toolBar.add(btnAddLine);
        this.toolBar.add(btnCopyLine);
        this.toolBar.add(btnInsertLine);
        this.toolBar.add(btnRemoveLine);
        this.toolBar.add(separatorFW6);
        this.toolBar.add(separatorFW9);
        this.toolBar.add(btnVoucher);
        this.toolBar.add(btnPCVoucher);
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnDelPCVoucher);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(btnNextPerson);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("isWeight", boolean.class, this.chkisWeight, "selected");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("weightBill", com.kingdee.eas.weighbridge.InStorageBillInfo.class, this.prmtweightBill, "data");
		dataBinder.registerBinding("person", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtperson, "data");
		dataBinder.registerBinding("material", com.kingdee.eas.basedata.master.material.MaterialInfo.class, this.prmtmaterial, "data");
		dataBinder.registerBinding("supplier", com.kingdee.eas.basedata.master.cssp.SupplierInfo.class, this.prmtsupplier, "data");
		dataBinder.registerBinding("truckNumber", String.class, this.txttruckNumber, "text");
		dataBinder.registerBinding("arriveDate", java.util.Date.class, this.pkarriveDate, "value");
		dataBinder.registerBinding("sendDate", java.util.Date.class, this.pksendDate, "value");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("conclusion", String.class, this.txtconclusion, "text");
		dataBinder.registerBinding("sampleNumber", String.class, this.txtsampleNumber, "text");
		dataBinder.registerBinding("takeOffPrice", java.math.BigDecimal.class, this.txttakeOffPrice, "value");
		dataBinder.registerBinding("takeOffBasePrice", java.math.BigDecimal.class, this.txttakeOffBasePrice, "value");
		dataBinder.registerBinding("takeOffWeight", java.math.BigDecimal.class, this.txttakeOffWeight, "value");
		dataBinder.registerBinding("purOrder", com.kingdee.eas.scm.sm.pur.PurOrderInfo.class, this.prmtpurOrder, "data");
		dataBinder.registerBinding("purOrderNumber", String.class, this.txtpurOrderNumber, "text");
		dataBinder.registerBinding("priceAfterTakeOff", java.math.BigDecimal.class, this.txtpriceAfterTakeOff, "value");
		dataBinder.registerBinding("priceBeforeTakeOff", java.math.BigDecimal.class, this.txtpriceBeforeTakeOff, "value");
		dataBinder.registerBinding("productFactory", String.class, this.txtproductFactory, "text");
		dataBinder.registerBinding("sendPerson", String.class, this.txtsendPerson, "text");
		dataBinder.registerBinding("unloadArea", String.class, this.txtunloadArea, "text");
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.feedfactory.QualityCheckBillEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.qcItem", java.lang.Object.class, this.kdtEntrys, "qcItem.text");
		dataBinder.registerBinding("entrys.qcresult", String.class, this.kdtEntrys, "qcresult.text");
		dataBinder.registerBinding("entrys.qcUnit", java.lang.Object.class, this.kdtEntrys, "qcUnit.text");
		dataBinder.registerBinding("entrys.standardValue", String.class, this.kdtEntrys, "standardValue.text");
		dataBinder.registerBinding("entrys.allowDeffValue", String.class, this.kdtEntrys, "allowDeffValue.text");
		dataBinder.registerBinding("entrys.qcConclusion", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "qcConclusion.text");
		dataBinder.registerBinding("entrys.qcPerson", java.lang.Object.class, this.kdtEntrys, "qcPerson.text");
		dataBinder.registerBinding("entrys.description", String.class, this.kdtEntrys, "description.text");
		dataBinder.registerBinding("entrys.lower", java.math.BigDecimal.class, this.kdtEntrys, "lower.text");
		dataBinder.registerBinding("entrys.upper", java.math.BigDecimal.class, this.kdtEntrys, "upper.text");
		dataBinder.registerBinding("entrys.qcresult1", String.class, this.kdtEntrys, "qcresult1.text");
		dataBinder.registerBinding("entrys.qcresult2", String.class, this.kdtEntrys, "qcresult2.text");
		dataBinder.registerBinding("entrys.qcresult3", String.class, this.kdtEntrys, "qcresult3.text");
		dataBinder.registerBinding("entrys.qcresult4", String.class, this.kdtEntrys, "qcresult4.text");
		dataBinder.registerBinding("entrys.qcresult0", String.class, this.kdtEntrys, "qcresult0.text");
		dataBinder.registerBinding("entrys.gs", String.class, this.kdtEntrys, "gs.text");
		dataBinder.registerBinding("entrys.DeductWgt", java.math.BigDecimal.class, this.kdtEntrys, "DeductWgt.text");
		dataBinder.registerBinding("contractItem", String.class, this.txtcontractItem, "text");
		dataBinder.registerBinding("BuckAmount", java.math.BigDecimal.class, this.txtBuckAmount, "value");
		dataBinder.registerBinding("realAmount", java.math.BigDecimal.class, this.txtrealAmount, "value");
		dataBinder.registerBinding("sumweight", java.math.BigDecimal.class, this.txtsumweight, "value");
		dataBinder.registerBinding("totalcon", com.kingdee.eas.farm.feedfactory.QCReturn.class, this.totalcon, "selectedItem");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.feedfactory.app.QualityCheckBillEditUIHandler";
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
        this.prmtweightBill.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.feedfactory.QualityCheckBillInfo)ov;
    }
    protected void removeByPK(IObjectPK pk) throws Exception {
    	IObjectValue editData = this.editData;
    	super.removeByPK(pk);
    	recycleNumberByOrg(editData,"NONE",editData.getString("number"));
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
        		setAutoNumberByOrg("NONE");
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
		getValidateHelper().registerBindProperty("isWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("weightBill", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("person", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("supplier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("truckNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("arriveDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sendDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("conclusion", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sampleNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("takeOffPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("takeOffBasePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("takeOffWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("purOrder", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("purOrderNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("priceAfterTakeOff", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("priceBeforeTakeOff", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("productFactory", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sendPerson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("unloadArea", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qcItem", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qcresult", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qcUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.standardValue", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.allowDeffValue", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qcConclusion", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qcPerson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.lower", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.upper", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qcresult1", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qcresult2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qcresult3", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qcresult4", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qcresult0", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.gs", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.DeductWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contractItem", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BuckAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("realAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sumweight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalcon", ValidateHelper.ON_SAVE);    		
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
     * output prmtmaterial_dataChanged method
     */
    protected void prmtmaterial_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output txttakeOffPrice_actionPerformed method
     */
    protected void txttakeOffPrice_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output prmtpurOrder_dataChanged method
     */
    protected void prmtpurOrder_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
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
        sic.add(new SelectorItemInfo("isWeight"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("creator.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("creator.id"));
        	sic.add(new SelectorItemInfo("creator.number"));
        	sic.add(new SelectorItemInfo("creator.name"));
		}
        sic.add(new SelectorItemInfo("createTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("lastUpdateUser.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("lastUpdateUser.id"));
        	sic.add(new SelectorItemInfo("lastUpdateUser.number"));
        	sic.add(new SelectorItemInfo("lastUpdateUser.name"));
		}
        sic.add(new SelectorItemInfo("lastUpdateTime"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("bizDate"));
        sic.add(new SelectorItemInfo("description"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("auditor.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("auditor.id"));
        	sic.add(new SelectorItemInfo("auditor.number"));
        	sic.add(new SelectorItemInfo("auditor.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("weightBill.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("weightBill.id"));
        	sic.add(new SelectorItemInfo("weightBill.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("person.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("person.id"));
        	sic.add(new SelectorItemInfo("person.number"));
        	sic.add(new SelectorItemInfo("person.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("material.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("material.id"));
        	sic.add(new SelectorItemInfo("material.number"));
        	sic.add(new SelectorItemInfo("material.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("supplier.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("supplier.id"));
        	sic.add(new SelectorItemInfo("supplier.number"));
        	sic.add(new SelectorItemInfo("supplier.name"));
		}
        sic.add(new SelectorItemInfo("truckNumber"));
        sic.add(new SelectorItemInfo("arriveDate"));
        sic.add(new SelectorItemInfo("sendDate"));
        sic.add(new SelectorItemInfo("auditTime"));
        sic.add(new SelectorItemInfo("baseStatus"));
        sic.add(new SelectorItemInfo("conclusion"));
        sic.add(new SelectorItemInfo("sampleNumber"));
        sic.add(new SelectorItemInfo("takeOffPrice"));
        sic.add(new SelectorItemInfo("takeOffBasePrice"));
        sic.add(new SelectorItemInfo("takeOffWeight"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("purOrder.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("purOrder.id"));
        	sic.add(new SelectorItemInfo("purOrder.number"));
		}
        sic.add(new SelectorItemInfo("purOrderNumber"));
        sic.add(new SelectorItemInfo("priceAfterTakeOff"));
        sic.add(new SelectorItemInfo("priceBeforeTakeOff"));
        sic.add(new SelectorItemInfo("productFactory"));
        sic.add(new SelectorItemInfo("sendPerson"));
        sic.add(new SelectorItemInfo("unloadArea"));
    	sic.add(new SelectorItemInfo("entrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.qcItem.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.qcItem.id"));
			sic.add(new SelectorItemInfo("entrys.qcItem.name"));
        	sic.add(new SelectorItemInfo("entrys.qcItem.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.qcresult"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.qcUnit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.qcUnit.id"));
			sic.add(new SelectorItemInfo("entrys.qcUnit.name"));
        	sic.add(new SelectorItemInfo("entrys.qcUnit.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.standardValue"));
    	sic.add(new SelectorItemInfo("entrys.allowDeffValue"));
    	sic.add(new SelectorItemInfo("entrys.qcConclusion"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.qcPerson.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.qcPerson.id"));
			sic.add(new SelectorItemInfo("entrys.qcPerson.name"));
        	sic.add(new SelectorItemInfo("entrys.qcPerson.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.description"));
    	sic.add(new SelectorItemInfo("entrys.lower"));
    	sic.add(new SelectorItemInfo("entrys.upper"));
    	sic.add(new SelectorItemInfo("entrys.qcresult1"));
    	sic.add(new SelectorItemInfo("entrys.qcresult2"));
    	sic.add(new SelectorItemInfo("entrys.qcresult3"));
    	sic.add(new SelectorItemInfo("entrys.qcresult4"));
    	sic.add(new SelectorItemInfo("entrys.qcresult0"));
    	sic.add(new SelectorItemInfo("entrys.gs"));
    	sic.add(new SelectorItemInfo("entrys.DeductWgt"));
        sic.add(new SelectorItemInfo("contractItem"));
        sic.add(new SelectorItemInfo("BuckAmount"));
        sic.add(new SelectorItemInfo("realAmount"));
        sic.add(new SelectorItemInfo("sumweight"));
        sic.add(new SelectorItemInfo("totalcon"));
        return sic;
    }        
    	

    /**
     * output actionSubmit_actionPerformed method
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmit_actionPerformed(e);
    }
    	

    /**
     * output actionPrint_actionPerformed method
     */
    public void actionPrint_actionPerformed(ActionEvent e) throws Exception
    {
        ArrayList idList = new ArrayList();
    	if (editData != null && !StringUtils.isEmpty(editData.getString("id"))) {
    		idList.add(editData.getString("id"));
    	}
        if (idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
            return;
        com.kingdee.bos.ctrl.kdf.data.impl.BOSQueryDelegate data = new com.kingdee.eas.framework.util.CommonDataProvider(idList,getTDQueryPK());
        com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
        appHlp.print(getTDFileName(), data, javax.swing.SwingUtilities.getWindowAncestor(this));
    }
    	

    /**
     * output actionPrintPreview_actionPerformed method
     */
    public void actionPrintPreview_actionPerformed(ActionEvent e) throws Exception
    {
        ArrayList idList = new ArrayList();
        if (editData != null && !StringUtils.isEmpty(editData.getString("id"))) {
    		idList.add(editData.getString("id"));
    	}
        if (idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
            return;
        com.kingdee.bos.ctrl.kdf.data.impl.BOSQueryDelegate data = new com.kingdee.eas.framework.util.CommonDataProvider(idList,getTDQueryPK());
        com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
        appHlp.printPreview(getTDFileName(), data, javax.swing.SwingUtilities.getWindowAncestor(this));
    }
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.feedfactory.QualityCheckBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.feedfactory.QualityCheckBillFactory.getRemoteInstance().unAudit(editData);
    }
	public RequestContext prepareActionSubmit(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionSubmit(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionSubmit() {
    	return false;
    }
	public RequestContext prepareActionPrint(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionPrint(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionPrint() {
    	return false;
    }
	public RequestContext prepareActionPrintPreview(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionPrintPreview(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionPrintPreview() {
    	return false;
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
            innerActionPerformed("eas", AbstractQualityCheckBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractQualityCheckBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.feedfactory.client", "QualityCheckBillEditUI");
    }
    /**
     * output isBindWorkFlow method
     */
    public boolean isBindWorkFlow()
    {
        return true;
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.feedfactory.client.QualityCheckBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.feedfactory.QualityCheckBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.feedfactory.QualityCheckBillInfo objectValue = new com.kingdee.eas.farm.feedfactory.QualityCheckBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/feedfactory/QualityCheckBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.feedfactory.app.QualityCheckBillQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtperson.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"质检员"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtmaterial.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"检验原料"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtsupplier.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"供应商"});
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"qcItem").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"检验项目"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"qcresult").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"检测结果"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"qcConclusion").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"检测结论"});
			}
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtEntrys;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("baseStatus",new Integer(-1));
vo.put("totalcon","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}