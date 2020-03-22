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
public abstract class AbstractPurFrightEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractPurFrightEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsupplier;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttruckNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contarriveDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsendDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpurOrder;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpurOrderNumber;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsumweight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contycts;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contycje;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contkzje;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contFrightPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsuppile;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsuppchkz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contSfrightPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdepartment;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoutDate;
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
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsupplier;
    protected com.kingdee.bos.ctrl.swing.KDTextField txttruckNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkarriveDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pksendDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpurOrder;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpurOrderNumber;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsumweight;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtycts;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtycje;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtkzje;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtFrightPrice;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsuppile;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsuppchkz;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtSfrightPrice;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtdepartment;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkoutDate;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.farm.feedfactory.PurFrightInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractPurFrightEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractPurFrightEditUI.class.getName());
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
        this.contsupplier = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttruckNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contarriveDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsendDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpurOrder = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpurOrderNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contsumweight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contycts = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contycje = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contkzje = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contFrightPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsuppile = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsuppchkz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contSfrightPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdepartment = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoutDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
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
        this.prmtsupplier = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txttruckNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkarriveDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pksendDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtpurOrder = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtpurOrderNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.txtsumweight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtycts = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtycje = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtkzje = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtFrightPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtsuppile = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtsuppchkz = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtSfrightPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtdepartment = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkoutDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
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
        this.contsupplier.setName("contsupplier");
        this.conttruckNumber.setName("conttruckNumber");
        this.contarriveDate.setName("contarriveDate");
        this.contsendDate.setName("contsendDate");
        this.contauditTime.setName("contauditTime");
        this.contbaseStatus.setName("contbaseStatus");
        this.contpurOrder.setName("contpurOrder");
        this.contpurOrderNumber.setName("contpurOrderNumber");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contsumweight.setName("contsumweight");
        this.contycts.setName("contycts");
        this.contycje.setName("contycje");
        this.contkzje.setName("contkzje");
        this.contFrightPrice.setName("contFrightPrice");
        this.contsuppile.setName("contsuppile");
        this.contsuppchkz.setName("contsuppchkz");
        this.contSfrightPrice.setName("contSfrightPrice");
        this.contdepartment.setName("contdepartment");
        this.contoutDate.setName("contoutDate");
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
        this.prmtsupplier.setName("prmtsupplier");
        this.txttruckNumber.setName("txttruckNumber");
        this.pkarriveDate.setName("pkarriveDate");
        this.pksendDate.setName("pksendDate");
        this.pkauditTime.setName("pkauditTime");
        this.baseStatus.setName("baseStatus");
        this.prmtpurOrder.setName("prmtpurOrder");
        this.txtpurOrderNumber.setName("txtpurOrderNumber");
        this.kDPanel1.setName("kDPanel1");
        this.kdtEntrys.setName("kdtEntrys");
        this.txtsumweight.setName("txtsumweight");
        this.txtycts.setName("txtycts");
        this.txtycje.setName("txtycje");
        this.txtkzje.setName("txtkzje");
        this.txtFrightPrice.setName("txtFrightPrice");
        this.prmtsuppile.setName("prmtsuppile");
        this.txtsuppchkz.setName("txtsuppchkz");
        this.txtSfrightPrice.setName("txtSfrightPrice");
        this.prmtdepartment.setName("prmtdepartment");
        this.pkoutDate.setName("pkoutDate");
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
        this.contweightBill.setVisible(false);
        // contperson		
        this.contperson.setBoundLabelText(resHelper.getString("contperson.boundLabelText"));		
        this.contperson.setBoundLabelLength(130);		
        this.contperson.setBoundLabelUnderline(true);		
        this.contperson.setVisible(true);
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
        // kDTabbedPane1
        // contsumweight		
        this.contsumweight.setBoundLabelText(resHelper.getString("contsumweight.boundLabelText"));		
        this.contsumweight.setBoundLabelLength(130);		
        this.contsumweight.setBoundLabelUnderline(true);		
        this.contsumweight.setVisible(true);
        // contycts		
        this.contycts.setBoundLabelText(resHelper.getString("contycts.boundLabelText"));		
        this.contycts.setBoundLabelLength(130);		
        this.contycts.setBoundLabelUnderline(true);		
        this.contycts.setVisible(true);
        // contycje		
        this.contycje.setBoundLabelText(resHelper.getString("contycje.boundLabelText"));		
        this.contycje.setBoundLabelLength(130);		
        this.contycje.setBoundLabelUnderline(true);		
        this.contycje.setVisible(true);
        // contkzje		
        this.contkzje.setBoundLabelText(resHelper.getString("contkzje.boundLabelText"));		
        this.contkzje.setBoundLabelLength(130);		
        this.contkzje.setBoundLabelUnderline(true);		
        this.contkzje.setVisible(true);
        // contFrightPrice		
        this.contFrightPrice.setBoundLabelText(resHelper.getString("contFrightPrice.boundLabelText"));		
        this.contFrightPrice.setBoundLabelLength(130);		
        this.contFrightPrice.setBoundLabelUnderline(true);		
        this.contFrightPrice.setVisible(true);
        // contsuppile		
        this.contsuppile.setBoundLabelText(resHelper.getString("contsuppile.boundLabelText"));		
        this.contsuppile.setBoundLabelLength(130);		
        this.contsuppile.setBoundLabelUnderline(true);		
        this.contsuppile.setVisible(true);
        // contsuppchkz		
        this.contsuppchkz.setBoundLabelText(resHelper.getString("contsuppchkz.boundLabelText"));		
        this.contsuppchkz.setBoundLabelLength(130);		
        this.contsuppchkz.setBoundLabelUnderline(true);		
        this.contsuppchkz.setVisible(true);
        // contSfrightPrice		
        this.contSfrightPrice.setBoundLabelText(resHelper.getString("contSfrightPrice.boundLabelText"));		
        this.contSfrightPrice.setBoundLabelLength(130);		
        this.contSfrightPrice.setBoundLabelUnderline(true);		
        this.contSfrightPrice.setVisible(true);
        // contdepartment		
        this.contdepartment.setBoundLabelText(resHelper.getString("contdepartment.boundLabelText"));		
        this.contdepartment.setBoundLabelLength(130);		
        this.contdepartment.setBoundLabelUnderline(true);		
        this.contdepartment.setVisible(true);
        // contoutDate		
        this.contoutDate.setBoundLabelText(resHelper.getString("contoutDate.boundLabelText"));		
        this.contoutDate.setBoundLabelLength(130);		
        this.contoutDate.setBoundLabelUnderline(true);		
        this.contoutDate.setVisible(true);
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
        this.prmtweightBill.setVisible(false);
        // prmtperson		
        this.prmtperson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonFilterQuery");		
        this.prmtperson.setEditable(true);		
        this.prmtperson.setDisplayFormat("$name$");		
        this.prmtperson.setEditFormat("$number$");		
        this.prmtperson.setCommitFormat("$number$");		
        this.prmtperson.setRequired(true);
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
        // kDPanel1
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"Materiel\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"MaterielName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"Amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"yldj\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"Warehouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{Materiel}</t:Cell><t:Cell>$Resource{MaterielName}</t:Cell><t:Cell>$Resource{Amount}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{yldj}</t:Cell><t:Cell>$Resource{Warehouse}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));
        kdtEntrys.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtEntrys_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtEntrys.putBindContents("editData",new String[] {"id","Materiel","MaterielName","Amount","qty","yldj","Warehouse"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_Materiel_PromptBox = new KDBizPromptBox();
        kdtEntrys_Materiel_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtEntrys_Materiel_PromptBox.setVisible(true);
        kdtEntrys_Materiel_PromptBox.setEditable(true);
        kdtEntrys_Materiel_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_Materiel_PromptBox.setEditFormat("$number$");
        kdtEntrys_Materiel_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_Materiel_CellEditor = new KDTDefaultCellEditor(kdtEntrys_Materiel_PromptBox);
        this.kdtEntrys.getColumn("Materiel").setEditor(kdtEntrys_Materiel_CellEditor);
        ObjectValueRender kdtEntrys_Materiel_OVR = new ObjectValueRender();
        kdtEntrys_Materiel_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("Materiel").setRenderer(kdtEntrys_Materiel_OVR);
        KDTextField kdtEntrys_MaterielName_TextField = new KDTextField();
        kdtEntrys_MaterielName_TextField.setName("kdtEntrys_MaterielName_TextField");
        kdtEntrys_MaterielName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_MaterielName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_MaterielName_TextField);
        this.kdtEntrys.getColumn("MaterielName").setEditor(kdtEntrys_MaterielName_CellEditor);
        KDFormattedTextField kdtEntrys_Amount_TextField = new KDFormattedTextField();
        kdtEntrys_Amount_TextField.setName("kdtEntrys_Amount_TextField");
        kdtEntrys_Amount_TextField.setVisible(true);
        kdtEntrys_Amount_TextField.setEditable(true);
        kdtEntrys_Amount_TextField.setHorizontalAlignment(2);
        kdtEntrys_Amount_TextField.setDataType(1);
        	kdtEntrys_Amount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_Amount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_Amount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_Amount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_Amount_TextField);
        this.kdtEntrys.getColumn("Amount").setEditor(kdtEntrys_Amount_CellEditor);
        KDFormattedTextField kdtEntrys_qty_TextField = new KDFormattedTextField();
        kdtEntrys_qty_TextField.setName("kdtEntrys_qty_TextField");
        kdtEntrys_qty_TextField.setVisible(true);
        kdtEntrys_qty_TextField.setEditable(true);
        kdtEntrys_qty_TextField.setHorizontalAlignment(2);
        kdtEntrys_qty_TextField.setDataType(1);
        	kdtEntrys_qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_qty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qty_TextField);
        this.kdtEntrys.getColumn("qty").setEditor(kdtEntrys_qty_CellEditor);
        KDFormattedTextField kdtEntrys_yldj_TextField = new KDFormattedTextField();
        kdtEntrys_yldj_TextField.setName("kdtEntrys_yldj_TextField");
        kdtEntrys_yldj_TextField.setVisible(true);
        kdtEntrys_yldj_TextField.setEditable(true);
        kdtEntrys_yldj_TextField.setHorizontalAlignment(2);
        kdtEntrys_yldj_TextField.setDataType(1);
        	kdtEntrys_yldj_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_yldj_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_yldj_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_yldj_CellEditor = new KDTDefaultCellEditor(kdtEntrys_yldj_TextField);
        this.kdtEntrys.getColumn("yldj").setEditor(kdtEntrys_yldj_CellEditor);
        final KDBizPromptBox kdtEntrys_Warehouse_PromptBox = new KDBizPromptBox();
        kdtEntrys_Warehouse_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7AllWarehouseQuery");
        kdtEntrys_Warehouse_PromptBox.setVisible(true);
        kdtEntrys_Warehouse_PromptBox.setEditable(true);
        kdtEntrys_Warehouse_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_Warehouse_PromptBox.setEditFormat("$number$");
        kdtEntrys_Warehouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_Warehouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_Warehouse_PromptBox);
        this.kdtEntrys.getColumn("Warehouse").setEditor(kdtEntrys_Warehouse_CellEditor);
        ObjectValueRender kdtEntrys_Warehouse_OVR = new ObjectValueRender();
        kdtEntrys_Warehouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("Warehouse").setRenderer(kdtEntrys_Warehouse_OVR);
        // txtsumweight		
        this.txtsumweight.setHorizontalAlignment(2);		
        this.txtsumweight.setDataType(1);		
        this.txtsumweight.setSupportedEmpty(true);		
        this.txtsumweight.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsumweight.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsumweight.setPrecision(4);		
        this.txtsumweight.setRequired(false);		
        this.txtsumweight.setEnabled(false);
        // txtycts		
        this.txtycts.setHorizontalAlignment(2);		
        this.txtycts.setDataType(0);		
        this.txtycts.setSupportedEmpty(true);		
        this.txtycts.setRequired(false);
        // txtycje		
        this.txtycje.setHorizontalAlignment(2);		
        this.txtycje.setDataType(1);		
        this.txtycje.setSupportedEmpty(true);		
        this.txtycje.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtycje.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtycje.setPrecision(2);		
        this.txtycje.setRequired(false);
        // txtkzje		
        this.txtkzje.setHorizontalAlignment(2);		
        this.txtkzje.setDataType(1);		
        this.txtkzje.setSupportedEmpty(true);		
        this.txtkzje.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtkzje.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtkzje.setPrecision(2);		
        this.txtkzje.setRequired(false);
        // txtFrightPrice		
        this.txtFrightPrice.setHorizontalAlignment(2);		
        this.txtFrightPrice.setDataType(1);		
        this.txtFrightPrice.setSupportedEmpty(true);		
        this.txtFrightPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtFrightPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtFrightPrice.setPrecision(4);		
        this.txtFrightPrice.setRequired(false);
        // prmtsuppile		
        this.prmtsuppile.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.PSupplierQuery");		
        this.prmtsuppile.setEditable(true);		
        this.prmtsuppile.setDisplayFormat("$name$");		
        this.prmtsuppile.setEditFormat("$number$");		
        this.prmtsuppile.setCommitFormat("$number$");		
        this.prmtsuppile.setRequired(false);
        // txtsuppchkz		
        this.txtsuppchkz.setHorizontalAlignment(2);		
        this.txtsuppchkz.setDataType(1);		
        this.txtsuppchkz.setSupportedEmpty(true);		
        this.txtsuppchkz.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsuppchkz.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsuppchkz.setPrecision(4);		
        this.txtsuppchkz.setRequired(false);
        // txtSfrightPrice		
        this.txtSfrightPrice.setHorizontalAlignment(2);		
        this.txtSfrightPrice.setDataType(1);		
        this.txtSfrightPrice.setSupportedEmpty(true);		
        this.txtSfrightPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtSfrightPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtSfrightPrice.setPrecision(4);		
        this.txtSfrightPrice.setRequired(false);
        // prmtdepartment		
        this.prmtdepartment.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtdepartment.setEditable(true);		
        this.prmtdepartment.setDisplayFormat("$name$");		
        this.prmtdepartment.setEditFormat("$number$");		
        this.prmtdepartment.setCommitFormat("$number$");		
        this.prmtdepartment.setRequired(false);
        // pkoutDate		
        this.pkoutDate.setVisible(true);		
        this.pkoutDate.setRequired(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtweightBill,prmtperson,prmtsupplier,txttruckNumber,pkarriveDate,pksendDate,pkauditTime,baseStatus,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,prmtpurOrder,txtpurOrderNumber,txtsumweight,txtycts,txtycje,txtkzje,txtFrightPrice,prmtsuppile,txtsuppchkz,txtSfrightPrice,prmtdepartment,kdtEntrys,pkoutDate}));
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
        this.setBounds(new Rectangle(0, -1, 1013, 500));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, -1, 1013, 500));
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
        contDescription.setBounds(new Rectangle(702, 127, 300, 19));
        this.add(contDescription, new KDLayout.Constraints(702, 127, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(731, 448, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(731, 448, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contweightBill.setBounds(new Rectangle(701, 102, 300, 19));
        this.add(contweightBill, new KDLayout.Constraints(701, 102, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contperson.setBounds(new Rectangle(701, 53, 300, 19));
        this.add(contperson, new KDLayout.Constraints(701, 53, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
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
        contpurOrder.setBounds(new Rectangle(355, 10, 300, 19));
        this.add(contpurOrder, new KDLayout.Constraints(355, 10, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpurOrderNumber.setBounds(new Rectangle(691, 143, 300, 19));
        this.add(contpurOrderNumber, new KDLayout.Constraints(691, 143, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDTabbedPane1.setBounds(new Rectangle(11, 188, 987, 251));
        this.add(kDTabbedPane1, new KDLayout.Constraints(11, 188, 987, 251, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contsumweight.setBounds(new Rectangle(356, 102, 299, 19));
        this.add(contsumweight, new KDLayout.Constraints(356, 102, 299, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contycts.setBounds(new Rectangle(701, 79, 300, 19));
        this.add(contycts, new KDLayout.Constraints(701, 79, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contycje.setBounds(new Rectangle(11, 105, 300, 19));
        this.add(contycje, new KDLayout.Constraints(11, 105, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contkzje.setBounds(new Rectangle(10, 80, 301, 19));
        this.add(contkzje, new KDLayout.Constraints(10, 80, 301, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contFrightPrice.setBounds(new Rectangle(9, 34, 300, 19));
        this.add(contFrightPrice, new KDLayout.Constraints(9, 34, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsuppile.setBounds(new Rectangle(355, 126, 300, 19));
        this.add(contsuppile, new KDLayout.Constraints(355, 126, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsuppchkz.setBounds(new Rectangle(10, 130, 299, 19));
        this.add(contsuppchkz, new KDLayout.Constraints(10, 130, 299, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contSfrightPrice.setBounds(new Rectangle(356, 79, 299, 19));
        this.add(contSfrightPrice, new KDLayout.Constraints(356, 79, 299, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdepartment.setBounds(new Rectangle(10, 156, 298, 19));
        this.add(contdepartment, new KDLayout.Constraints(10, 156, 298, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoutDate.setBounds(new Rectangle(356, 153, 302, 19));
        this.add(contoutDate, new KDLayout.Constraints(356, 153, 302, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contpurOrder
        contpurOrder.setBoundEditor(prmtpurOrder);
        //contpurOrderNumber
        contpurOrderNumber.setBoundEditor(txtpurOrderNumber);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 986, 218));        kdtEntrys.setBounds(new Rectangle(0, 4, 975, 245));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.feedfactory.PurFrightEntryInfo(),null,false);
        kDPanel1.add(kdtEntrys_detailPanel, new KDLayout.Constraints(0, 4, 975, 245, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contsumweight
        contsumweight.setBoundEditor(txtsumweight);
        //contycts
        contycts.setBoundEditor(txtycts);
        //contycje
        contycje.setBoundEditor(txtycje);
        //contkzje
        contkzje.setBoundEditor(txtkzje);
        //contFrightPrice
        contFrightPrice.setBoundEditor(txtFrightPrice);
        //contsuppile
        contsuppile.setBoundEditor(prmtsuppile);
        //contsuppchkz
        contsuppchkz.setBoundEditor(txtsuppchkz);
        //contSfrightPrice
        contSfrightPrice.setBoundEditor(txtSfrightPrice);
        //contdepartment
        contdepartment.setBoundEditor(prmtdepartment);
        //contoutDate
        contoutDate.setBoundEditor(pkoutDate);

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
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(btnNextPerson);


    }

	//Regiester control's property binding.
	private void registerBindings(){
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
		dataBinder.registerBinding("supplier", com.kingdee.eas.basedata.master.cssp.SupplierInfo.class, this.prmtsupplier, "data");
		dataBinder.registerBinding("truckNumber", String.class, this.txttruckNumber, "text");
		dataBinder.registerBinding("arriveDate", java.util.Date.class, this.pkarriveDate, "value");
		dataBinder.registerBinding("sendDate", java.util.Date.class, this.pksendDate, "value");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("purOrder", com.kingdee.eas.scm.sm.pur.PurOrderInfo.class, this.prmtpurOrder, "data");
		dataBinder.registerBinding("purOrderNumber", String.class, this.txtpurOrderNumber, "text");
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.feedfactory.PurFrightEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.Materiel", java.lang.Object.class, this.kdtEntrys, "Materiel.text");
		dataBinder.registerBinding("entrys.MaterielName", String.class, this.kdtEntrys, "MaterielName.text");
		dataBinder.registerBinding("entrys.Amount", java.math.BigDecimal.class, this.kdtEntrys, "Amount.text");
		dataBinder.registerBinding("entrys.Warehouse", java.lang.Object.class, this.kdtEntrys, "Warehouse.text");
		dataBinder.registerBinding("entrys.qty", java.math.BigDecimal.class, this.kdtEntrys, "qty.text");
		dataBinder.registerBinding("entrys.yldj", java.math.BigDecimal.class, this.kdtEntrys, "yldj.text");
		dataBinder.registerBinding("sumweight", java.math.BigDecimal.class, this.txtsumweight, "value");
		dataBinder.registerBinding("ycts", int.class, this.txtycts, "value");
		dataBinder.registerBinding("ycje", java.math.BigDecimal.class, this.txtycje, "value");
		dataBinder.registerBinding("kzje", java.math.BigDecimal.class, this.txtkzje, "value");
		dataBinder.registerBinding("FrightPrice", java.math.BigDecimal.class, this.txtFrightPrice, "value");
		dataBinder.registerBinding("suppile", com.kingdee.eas.basedata.master.cssp.SupplierInfo.class, this.prmtsuppile, "data");
		dataBinder.registerBinding("suppchkz", java.math.BigDecimal.class, this.txtsuppchkz, "value");
		dataBinder.registerBinding("SfrightPrice", java.math.BigDecimal.class, this.txtSfrightPrice, "value");
		dataBinder.registerBinding("department", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtdepartment, "data");
		dataBinder.registerBinding("outDate", java.util.Date.class, this.pkoutDate, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.feedfactory.app.PurFrightEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.feedfactory.PurFrightInfo)ov;
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
		getValidateHelper().registerBindProperty("supplier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("truckNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("arriveDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sendDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("purOrder", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("purOrderNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Materiel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.MaterielName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Warehouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.yldj", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sumweight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ycts", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ycje", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("kzje", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FrightPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("suppile", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("suppchkz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SfrightPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("department", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("outDate", ValidateHelper.ON_SAVE);    		
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
     * output prmtpurOrder_dataChanged method
     */
    protected void prmtpurOrder_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        //write your code here
    }


    /**
     * output kdtEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("Materiel".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"MaterielName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"Materiel").getValue(),"name")));

}


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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("purOrder.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("purOrder.id"));
        	sic.add(new SelectorItemInfo("purOrder.number"));
		}
        sic.add(new SelectorItemInfo("purOrderNumber"));
    	sic.add(new SelectorItemInfo("entrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.Materiel.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.Materiel.id"));
			sic.add(new SelectorItemInfo("entrys.Materiel.number"));
			sic.add(new SelectorItemInfo("entrys.Materiel.name"));
		}
    	sic.add(new SelectorItemInfo("entrys.MaterielName"));
    	sic.add(new SelectorItemInfo("entrys.Amount"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.Warehouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.Warehouse.id"));
			sic.add(new SelectorItemInfo("entrys.Warehouse.name"));
        	sic.add(new SelectorItemInfo("entrys.Warehouse.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.qty"));
    	sic.add(new SelectorItemInfo("entrys.yldj"));
        sic.add(new SelectorItemInfo("sumweight"));
        sic.add(new SelectorItemInfo("ycts"));
        sic.add(new SelectorItemInfo("ycje"));
        sic.add(new SelectorItemInfo("kzje"));
        sic.add(new SelectorItemInfo("FrightPrice"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("suppile.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("suppile.id"));
        	sic.add(new SelectorItemInfo("suppile.number"));
        	sic.add(new SelectorItemInfo("suppile.name"));
		}
        sic.add(new SelectorItemInfo("suppchkz"));
        sic.add(new SelectorItemInfo("SfrightPrice"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("department.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("department.id"));
        	sic.add(new SelectorItemInfo("department.number"));
        	sic.add(new SelectorItemInfo("department.name"));
		}
        sic.add(new SelectorItemInfo("outDate"));
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
        com.kingdee.eas.farm.feedfactory.PurFrightFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.feedfactory.PurFrightFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractPurFrightEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractPurFrightEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.feedfactory.client", "PurFrightEditUI");
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
        return com.kingdee.eas.farm.feedfactory.client.PurFrightEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.feedfactory.PurFrightFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.feedfactory.PurFrightInfo objectValue = new com.kingdee.eas.farm.feedfactory.PurFrightInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/feedfactory/PurFright";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.feedfactory.app.PurFrightQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtperson.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"质检员"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtsupplier.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"供应商"});
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"Warehouse").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"仓库"});
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
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}