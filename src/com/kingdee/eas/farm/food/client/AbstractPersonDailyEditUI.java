/**
 * output package name
 */
package com.kingdee.eas.farm.food.client;

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
public abstract class AbstractPersonDailyEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractPersonDailyEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contStorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompanyOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator9;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallPersonQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmanuPersonQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdevicePersonQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlogisticsPersonQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contFIPersonQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsynthesisPersonQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsalePersonQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmanuTodayQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdeceiveTodayQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlogisticsTodayQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contFITodayQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsynthesisTodayQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsaleTodayQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDComboBox BillStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtStorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkAuditTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompanyOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallPersonQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmanuPersonQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdevicePersonQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtlogisticsPersonQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtFIPersonQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsynthesisPersonQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsalePersonQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmanuTodayQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdeceiveTodayQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtlogisticsTodayQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtFITodayQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsynthesisTodayQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsaleTodayQty;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.eas.farm.food.PersonDailyInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractPersonDailyEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractPersonDailyEditUI.class.getName());
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
        this.contBillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contStorageOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompanyOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDSeparator9 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contallPersonQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmanuPersonQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdevicePersonQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlogisticsPersonQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contFIPersonQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsynthesisPersonQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsalePersonQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmanuTodayQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdeceiveTodayQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlogisticsTodayQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contFITodayQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsynthesisTodayQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsaleTodayQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.BillStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtStorageOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkAuditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtcompanyOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtallPersonQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmanuPersonQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdevicePersonQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtlogisticsPersonQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtFIPersonQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsynthesisPersonQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsalePersonQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmanuTodayQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdeceiveTodayQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtlogisticsTodayQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtFITodayQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsynthesisTodayQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsaleTodayQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.tBtnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.mBtnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.mBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.contBillStatus.setName("contBillStatus");
        this.contStorageOrgUnit.setName("contStorageOrgUnit");
        this.contAuditTime.setName("contAuditTime");
        this.contcompanyOrgUnit.setName("contcompanyOrgUnit");
        this.kDSeparator8.setName("kDSeparator8");
        this.kDSeparator9.setName("kDSeparator9");
        this.contallPersonQty.setName("contallPersonQty");
        this.contmanuPersonQty.setName("contmanuPersonQty");
        this.contdevicePersonQty.setName("contdevicePersonQty");
        this.contlogisticsPersonQty.setName("contlogisticsPersonQty");
        this.contFIPersonQty.setName("contFIPersonQty");
        this.contsynthesisPersonQty.setName("contsynthesisPersonQty");
        this.contsalePersonQty.setName("contsalePersonQty");
        this.contmanuTodayQty.setName("contmanuTodayQty");
        this.contdeceiveTodayQty.setName("contdeceiveTodayQty");
        this.contlogisticsTodayQty.setName("contlogisticsTodayQty");
        this.contFITodayQty.setName("contFITodayQty");
        this.contsynthesisTodayQty.setName("contsynthesisTodayQty");
        this.contsaleTodayQty.setName("contsaleTodayQty");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.BillStatus.setName("BillStatus");
        this.prmtStorageOrgUnit.setName("prmtStorageOrgUnit");
        this.pkAuditTime.setName("pkAuditTime");
        this.prmtcompanyOrgUnit.setName("prmtcompanyOrgUnit");
        this.txtallPersonQty.setName("txtallPersonQty");
        this.txtmanuPersonQty.setName("txtmanuPersonQty");
        this.txtdevicePersonQty.setName("txtdevicePersonQty");
        this.txtlogisticsPersonQty.setName("txtlogisticsPersonQty");
        this.txtFIPersonQty.setName("txtFIPersonQty");
        this.txtsynthesisPersonQty.setName("txtsynthesisPersonQty");
        this.txtsalePersonQty.setName("txtsalePersonQty");
        this.txtmanuTodayQty.setName("txtmanuTodayQty");
        this.txtdeceiveTodayQty.setName("txtdeceiveTodayQty");
        this.txtlogisticsTodayQty.setName("txtlogisticsTodayQty");
        this.txtFITodayQty.setName("txtFITodayQty");
        this.txtsynthesisTodayQty.setName("txtsynthesisTodayQty");
        this.txtsaleTodayQty.setName("txtsaleTodayQty");
        this.tBtnAudit.setName("tBtnAudit");
        this.tBtnUnAudit.setName("tBtnUnAudit");
        this.mBtnAudit.setName("mBtnAudit");
        this.mBtnUnAudit.setName("mBtnUnAudit");
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
        this.contNumber.setBoundLabelLength(100);		
        this.contNumber.setBoundLabelUnderline(true);
        // contBizDate		
        this.contBizDate.setBoundLabelText(resHelper.getString("contBizDate.boundLabelText"));		
        this.contBizDate.setBoundLabelLength(100);		
        this.contBizDate.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelAlignment(7);		
        this.contBizDate.setVisible(true);
        // contDescription		
        this.contDescription.setBoundLabelText(resHelper.getString("contDescription.boundLabelText"));		
        this.contDescription.setBoundLabelLength(100);		
        this.contDescription.setBoundLabelUnderline(true);
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);
        // contBillStatus		
        this.contBillStatus.setBoundLabelText(resHelper.getString("contBillStatus.boundLabelText"));		
        this.contBillStatus.setBoundLabelLength(100);		
        this.contBillStatus.setBoundLabelUnderline(true);		
        this.contBillStatus.setVisible(true);
        // contStorageOrgUnit		
        this.contStorageOrgUnit.setBoundLabelText(resHelper.getString("contStorageOrgUnit.boundLabelText"));		
        this.contStorageOrgUnit.setBoundLabelLength(100);		
        this.contStorageOrgUnit.setBoundLabelUnderline(true);		
        this.contStorageOrgUnit.setVisible(true);
        // contAuditTime		
        this.contAuditTime.setBoundLabelText(resHelper.getString("contAuditTime.boundLabelText"));		
        this.contAuditTime.setBoundLabelLength(100);		
        this.contAuditTime.setBoundLabelUnderline(true);		
        this.contAuditTime.setVisible(true);
        // contcompanyOrgUnit		
        this.contcompanyOrgUnit.setBoundLabelText(resHelper.getString("contcompanyOrgUnit.boundLabelText"));		
        this.contcompanyOrgUnit.setBoundLabelLength(100);		
        this.contcompanyOrgUnit.setBoundLabelUnderline(true);		
        this.contcompanyOrgUnit.setVisible(true);
        // kDSeparator8
        // kDSeparator9
        // contallPersonQty		
        this.contallPersonQty.setBoundLabelText(resHelper.getString("contallPersonQty.boundLabelText"));		
        this.contallPersonQty.setBoundLabelLength(100);		
        this.contallPersonQty.setBoundLabelUnderline(true);		
        this.contallPersonQty.setVisible(true);
        // contmanuPersonQty		
        this.contmanuPersonQty.setBoundLabelText(resHelper.getString("contmanuPersonQty.boundLabelText"));		
        this.contmanuPersonQty.setBoundLabelLength(100);		
        this.contmanuPersonQty.setBoundLabelUnderline(true);		
        this.contmanuPersonQty.setVisible(true);
        // contdevicePersonQty		
        this.contdevicePersonQty.setBoundLabelText(resHelper.getString("contdevicePersonQty.boundLabelText"));		
        this.contdevicePersonQty.setBoundLabelLength(100);		
        this.contdevicePersonQty.setBoundLabelUnderline(true);		
        this.contdevicePersonQty.setVisible(true);
        // contlogisticsPersonQty		
        this.contlogisticsPersonQty.setBoundLabelText(resHelper.getString("contlogisticsPersonQty.boundLabelText"));		
        this.contlogisticsPersonQty.setBoundLabelLength(100);		
        this.contlogisticsPersonQty.setBoundLabelUnderline(true);		
        this.contlogisticsPersonQty.setVisible(true);
        // contFIPersonQty		
        this.contFIPersonQty.setBoundLabelText(resHelper.getString("contFIPersonQty.boundLabelText"));		
        this.contFIPersonQty.setBoundLabelLength(100);		
        this.contFIPersonQty.setBoundLabelUnderline(true);		
        this.contFIPersonQty.setVisible(true);
        // contsynthesisPersonQty		
        this.contsynthesisPersonQty.setBoundLabelText(resHelper.getString("contsynthesisPersonQty.boundLabelText"));		
        this.contsynthesisPersonQty.setBoundLabelLength(100);		
        this.contsynthesisPersonQty.setBoundLabelUnderline(true);		
        this.contsynthesisPersonQty.setVisible(true);
        // contsalePersonQty		
        this.contsalePersonQty.setBoundLabelText(resHelper.getString("contsalePersonQty.boundLabelText"));		
        this.contsalePersonQty.setBoundLabelLength(100);		
        this.contsalePersonQty.setBoundLabelUnderline(true);		
        this.contsalePersonQty.setVisible(true);
        // contmanuTodayQty		
        this.contmanuTodayQty.setBoundLabelText(resHelper.getString("contmanuTodayQty.boundLabelText"));		
        this.contmanuTodayQty.setBoundLabelLength(100);		
        this.contmanuTodayQty.setBoundLabelUnderline(true);		
        this.contmanuTodayQty.setVisible(true);
        // contdeceiveTodayQty		
        this.contdeceiveTodayQty.setBoundLabelText(resHelper.getString("contdeceiveTodayQty.boundLabelText"));		
        this.contdeceiveTodayQty.setBoundLabelLength(100);		
        this.contdeceiveTodayQty.setBoundLabelUnderline(true);		
        this.contdeceiveTodayQty.setVisible(true);
        // contlogisticsTodayQty		
        this.contlogisticsTodayQty.setBoundLabelText(resHelper.getString("contlogisticsTodayQty.boundLabelText"));		
        this.contlogisticsTodayQty.setBoundLabelLength(100);		
        this.contlogisticsTodayQty.setBoundLabelUnderline(true);		
        this.contlogisticsTodayQty.setVisible(true);
        // contFITodayQty		
        this.contFITodayQty.setBoundLabelText(resHelper.getString("contFITodayQty.boundLabelText"));		
        this.contFITodayQty.setBoundLabelLength(100);		
        this.contFITodayQty.setBoundLabelUnderline(true);		
        this.contFITodayQty.setVisible(true);
        // contsynthesisTodayQty		
        this.contsynthesisTodayQty.setBoundLabelText(resHelper.getString("contsynthesisTodayQty.boundLabelText"));		
        this.contsynthesisTodayQty.setBoundLabelLength(100);		
        this.contsynthesisTodayQty.setBoundLabelUnderline(true);		
        this.contsynthesisTodayQty.setVisible(true);
        // contsaleTodayQty		
        this.contsaleTodayQty.setBoundLabelText(resHelper.getString("contsaleTodayQty.boundLabelText"));		
        this.contsaleTodayQty.setBoundLabelLength(100);		
        this.contsaleTodayQty.setBoundLabelUnderline(true);		
        this.contsaleTodayQty.setVisible(true);
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
        // BillStatus		
        this.BillStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.BillStatus.setRequired(false);		
        this.BillStatus.setEnabled(false);
        // prmtStorageOrgUnit		
        this.prmtStorageOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtStorageOrgUnit.setEditable(true);		
        this.prmtStorageOrgUnit.setDisplayFormat("$name$");		
        this.prmtStorageOrgUnit.setEditFormat("$number$");		
        this.prmtStorageOrgUnit.setCommitFormat("$number$");		
        this.prmtStorageOrgUnit.setRequired(true);
        // pkAuditTime		
        this.pkAuditTime.setRequired(false);		
        this.pkAuditTime.setEnabled(false);
        // prmtcompanyOrgUnit		
        this.prmtcompanyOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompanyOrgUnit.setEditable(true);		
        this.prmtcompanyOrgUnit.setDisplayFormat("$name$");		
        this.prmtcompanyOrgUnit.setEditFormat("$number$");		
        this.prmtcompanyOrgUnit.setCommitFormat("$number$");		
        this.prmtcompanyOrgUnit.setRequired(true);
        // txtallPersonQty		
        this.txtallPersonQty.setVisible(true);		
        this.txtallPersonQty.setHorizontalAlignment(2);		
        this.txtallPersonQty.setSupportedEmpty(true);		
        this.txtallPersonQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallPersonQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallPersonQty.setPrecision(4);		
        this.txtallPersonQty.setRequired(false);		
        this.txtallPersonQty.setEnabled(false);
        // txtmanuPersonQty		
        this.txtmanuPersonQty.setVisible(true);		
        this.txtmanuPersonQty.setHorizontalAlignment(2);		
        this.txtmanuPersonQty.setSupportedEmpty(true);		
        this.txtmanuPersonQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmanuPersonQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmanuPersonQty.setPrecision(4);		
        this.txtmanuPersonQty.setRequired(false);
        txtmanuPersonQty.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				txtmanuPersonQty_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtdevicePersonQty		
        this.txtdevicePersonQty.setVisible(true);		
        this.txtdevicePersonQty.setHorizontalAlignment(2);		
        this.txtdevicePersonQty.setSupportedEmpty(true);		
        this.txtdevicePersonQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdevicePersonQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdevicePersonQty.setPrecision(4);		
        this.txtdevicePersonQty.setRequired(false);
        txtdevicePersonQty.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				txtdevicePersonQty_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtlogisticsPersonQty		
        this.txtlogisticsPersonQty.setVisible(true);		
        this.txtlogisticsPersonQty.setHorizontalAlignment(2);		
        this.txtlogisticsPersonQty.setSupportedEmpty(true);		
        this.txtlogisticsPersonQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtlogisticsPersonQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtlogisticsPersonQty.setPrecision(4);		
        this.txtlogisticsPersonQty.setRequired(false);
        txtlogisticsPersonQty.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				txtlogisticsPersonQty_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtFIPersonQty		
        this.txtFIPersonQty.setVisible(true);		
        this.txtFIPersonQty.setHorizontalAlignment(2);		
        this.txtFIPersonQty.setSupportedEmpty(true);		
        this.txtFIPersonQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtFIPersonQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtFIPersonQty.setPrecision(4);		
        this.txtFIPersonQty.setRequired(false);
        txtFIPersonQty.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				txtFIPersonQty_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtsynthesisPersonQty		
        this.txtsynthesisPersonQty.setVisible(true);		
        this.txtsynthesisPersonQty.setHorizontalAlignment(2);		
        this.txtsynthesisPersonQty.setSupportedEmpty(true);		
        this.txtsynthesisPersonQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsynthesisPersonQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsynthesisPersonQty.setPrecision(4);		
        this.txtsynthesisPersonQty.setRequired(false);
        txtsynthesisPersonQty.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				txtsynthesisPersonQty_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtsalePersonQty		
        this.txtsalePersonQty.setVisible(true);		
        this.txtsalePersonQty.setHorizontalAlignment(2);		
        this.txtsalePersonQty.setSupportedEmpty(true);		
        this.txtsalePersonQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsalePersonQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsalePersonQty.setPrecision(4);		
        this.txtsalePersonQty.setRequired(false);
        txtsalePersonQty.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				txtsalePersonQty_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtmanuTodayQty		
        this.txtmanuTodayQty.setVisible(true);		
        this.txtmanuTodayQty.setHorizontalAlignment(2);		
        this.txtmanuTodayQty.setSupportedEmpty(true);		
        this.txtmanuTodayQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmanuTodayQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmanuTodayQty.setPrecision(4);		
        this.txtmanuTodayQty.setRequired(false);
        // txtdeceiveTodayQty		
        this.txtdeceiveTodayQty.setVisible(true);		
        this.txtdeceiveTodayQty.setHorizontalAlignment(2);		
        this.txtdeceiveTodayQty.setSupportedEmpty(true);		
        this.txtdeceiveTodayQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdeceiveTodayQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdeceiveTodayQty.setPrecision(4);		
        this.txtdeceiveTodayQty.setRequired(false);
        // txtlogisticsTodayQty		
        this.txtlogisticsTodayQty.setVisible(true);		
        this.txtlogisticsTodayQty.setHorizontalAlignment(2);		
        this.txtlogisticsTodayQty.setSupportedEmpty(true);		
        this.txtlogisticsTodayQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtlogisticsTodayQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtlogisticsTodayQty.setPrecision(4);		
        this.txtlogisticsTodayQty.setRequired(false);
        // txtFITodayQty		
        this.txtFITodayQty.setVisible(true);		
        this.txtFITodayQty.setHorizontalAlignment(2);		
        this.txtFITodayQty.setDataType(0);		
        this.txtFITodayQty.setSupportedEmpty(true);		
        this.txtFITodayQty.setRequired(false);
        // txtsynthesisTodayQty		
        this.txtsynthesisTodayQty.setVisible(true);		
        this.txtsynthesisTodayQty.setHorizontalAlignment(2);		
        this.txtsynthesisTodayQty.setDataType(0);		
        this.txtsynthesisTodayQty.setSupportedEmpty(true);		
        this.txtsynthesisTodayQty.setRequired(false);
        // txtsaleTodayQty		
        this.txtsaleTodayQty.setVisible(true);		
        this.txtsaleTodayQty.setHorizontalAlignment(2);		
        this.txtsaleTodayQty.setDataType(0);		
        this.txtsaleTodayQty.setSupportedEmpty(true);		
        this.txtsaleTodayQty.setRequired(false);
        // tBtnAudit
        this.tBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnAudit.setText(resHelper.getString("tBtnAudit.text"));
        // tBtnUnAudit
        this.tBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnUnAudit.setText(resHelper.getString("tBtnUnAudit.text"));
        // mBtnAudit
        this.mBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnAudit.setText(resHelper.getString("mBtnAudit.text"));
        // mBtnUnAudit
        this.mBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnUnAudit.setText(resHelper.getString("mBtnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,BillStatus,prmtStorageOrgUnit,pkAuditTime,prmtcompanyOrgUnit,txtallPersonQty,txtmanuPersonQty,txtdevicePersonQty,txtlogisticsPersonQty,txtFIPersonQty,txtsynthesisPersonQty,txtsalePersonQty,txtmanuTodayQty,txtdeceiveTodayQty,txtlogisticsTodayQty,txtFITodayQty,txtsynthesisTodayQty,txtsaleTodayQty}));
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
        this.setBounds(new Rectangle(0, 0, 722, 482));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 722, 482));
        contCreator.setBounds(new Rectangle(45, 379, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(45, 379, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(45, 410, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(45, 410, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(780, 349, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(780, 349, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(778, 380, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(778, 380, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contNumber.setBounds(new Rectangle(45, 34, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(45, 34, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(388, 34, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(388, 34, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contDescription.setBounds(new Rectangle(388, 98, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(388, 98, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(388, 379, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(388, 379, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contBillStatus.setBounds(new Rectangle(45, 98, 270, 19));
        this.add(contBillStatus, new KDLayout.Constraints(45, 98, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contStorageOrgUnit.setBounds(new Rectangle(45, 65, 270, 19));
        this.add(contStorageOrgUnit, new KDLayout.Constraints(45, 65, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditTime.setBounds(new Rectangle(388, 410, 270, 19));
        this.add(contAuditTime, new KDLayout.Constraints(388, 410, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompanyOrgUnit.setBounds(new Rectangle(388, 65, 270, 19));
        this.add(contcompanyOrgUnit, new KDLayout.Constraints(388, 65, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator8.setBounds(new Rectangle(32, 133, 652, 6));
        this.add(kDSeparator8, new KDLayout.Constraints(32, 133, 652, 6, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator9.setBounds(new Rectangle(29, 367, 661, 9));
        this.add(kDSeparator9, new KDLayout.Constraints(29, 367, 661, 9, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contallPersonQty.setBounds(new Rectangle(44, 147, 270, 19));
        this.add(contallPersonQty, new KDLayout.Constraints(44, 147, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmanuPersonQty.setBounds(new Rectangle(44, 177, 270, 19));
        this.add(contmanuPersonQty, new KDLayout.Constraints(44, 177, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdevicePersonQty.setBounds(new Rectangle(44, 207, 270, 19));
        this.add(contdevicePersonQty, new KDLayout.Constraints(44, 207, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contlogisticsPersonQty.setBounds(new Rectangle(44, 237, 270, 19));
        this.add(contlogisticsPersonQty, new KDLayout.Constraints(44, 237, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contFIPersonQty.setBounds(new Rectangle(44, 267, 270, 19));
        this.add(contFIPersonQty, new KDLayout.Constraints(44, 267, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsynthesisPersonQty.setBounds(new Rectangle(44, 297, 270, 19));
        this.add(contsynthesisPersonQty, new KDLayout.Constraints(44, 297, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsalePersonQty.setBounds(new Rectangle(44, 327, 270, 19));
        this.add(contsalePersonQty, new KDLayout.Constraints(44, 327, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmanuTodayQty.setBounds(new Rectangle(388, 177, 270, 19));
        this.add(contmanuTodayQty, new KDLayout.Constraints(388, 177, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contdeceiveTodayQty.setBounds(new Rectangle(388, 207, 270, 19));
        this.add(contdeceiveTodayQty, new KDLayout.Constraints(388, 207, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contlogisticsTodayQty.setBounds(new Rectangle(388, 237, 270, 19));
        this.add(contlogisticsTodayQty, new KDLayout.Constraints(388, 237, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contFITodayQty.setBounds(new Rectangle(388, 267, 270, 19));
        this.add(contFITodayQty, new KDLayout.Constraints(388, 267, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contsynthesisTodayQty.setBounds(new Rectangle(388, 297, 270, 19));
        this.add(contsynthesisTodayQty, new KDLayout.Constraints(388, 297, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contsaleTodayQty.setBounds(new Rectangle(388, 327, 270, 19));
        this.add(contsaleTodayQty, new KDLayout.Constraints(388, 327, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //contBillStatus
        contBillStatus.setBoundEditor(BillStatus);
        //contStorageOrgUnit
        contStorageOrgUnit.setBoundEditor(prmtStorageOrgUnit);
        //contAuditTime
        contAuditTime.setBoundEditor(pkAuditTime);
        //contcompanyOrgUnit
        contcompanyOrgUnit.setBoundEditor(prmtcompanyOrgUnit);
        //contallPersonQty
        contallPersonQty.setBoundEditor(txtallPersonQty);
        //contmanuPersonQty
        contmanuPersonQty.setBoundEditor(txtmanuPersonQty);
        //contdevicePersonQty
        contdevicePersonQty.setBoundEditor(txtdevicePersonQty);
        //contlogisticsPersonQty
        contlogisticsPersonQty.setBoundEditor(txtlogisticsPersonQty);
        //contFIPersonQty
        contFIPersonQty.setBoundEditor(txtFIPersonQty);
        //contsynthesisPersonQty
        contsynthesisPersonQty.setBoundEditor(txtsynthesisPersonQty);
        //contsalePersonQty
        contsalePersonQty.setBoundEditor(txtsalePersonQty);
        //contmanuTodayQty
        contmanuTodayQty.setBoundEditor(txtmanuTodayQty);
        //contdeceiveTodayQty
        contdeceiveTodayQty.setBoundEditor(txtdeceiveTodayQty);
        //contlogisticsTodayQty
        contlogisticsTodayQty.setBoundEditor(txtlogisticsTodayQty);
        //contFITodayQty
        contFITodayQty.setBoundEditor(txtFITodayQty);
        //contsynthesisTodayQty
        contsynthesisTodayQty.setBoundEditor(txtsynthesisTodayQty);
        //contsaleTodayQty
        contsaleTodayQty.setBoundEditor(txtsaleTodayQty);

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
        menuBiz.add(mBtnAudit);
        menuBiz.add(mBtnUnAudit);
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
        this.toolBar.add(btnCopy);
        this.toolBar.add(tBtnAudit);
        this.toolBar.add(tBtnUnAudit);
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
		dataBinder.registerBinding("BillStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.BillStatus, "selectedItem");
		dataBinder.registerBinding("StorageOrgUnit", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtStorageOrgUnit, "data");
		dataBinder.registerBinding("AuditTime", java.util.Date.class, this.pkAuditTime, "value");
		dataBinder.registerBinding("companyOrgUnit", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompanyOrgUnit, "data");
		dataBinder.registerBinding("allPersonQty", java.math.BigDecimal.class, this.txtallPersonQty, "value");
		dataBinder.registerBinding("manuPersonQty", java.math.BigDecimal.class, this.txtmanuPersonQty, "value");
		dataBinder.registerBinding("devicePersonQty", java.math.BigDecimal.class, this.txtdevicePersonQty, "value");
		dataBinder.registerBinding("logisticsPersonQty", java.math.BigDecimal.class, this.txtlogisticsPersonQty, "value");
		dataBinder.registerBinding("FIPersonQty", java.math.BigDecimal.class, this.txtFIPersonQty, "value");
		dataBinder.registerBinding("synthesisPersonQty", java.math.BigDecimal.class, this.txtsynthesisPersonQty, "value");
		dataBinder.registerBinding("salePersonQty", java.math.BigDecimal.class, this.txtsalePersonQty, "value");
		dataBinder.registerBinding("manuTodayQty", java.math.BigDecimal.class, this.txtmanuTodayQty, "value");
		dataBinder.registerBinding("deceiveTodayQty", int.class, this.txtdeceiveTodayQty, "value");
		dataBinder.registerBinding("logisticsTodayQty", int.class, this.txtlogisticsTodayQty, "value");
		dataBinder.registerBinding("FITodayQty", int.class, this.txtFITodayQty, "value");
		dataBinder.registerBinding("synthesisTodayQty", int.class, this.txtsynthesisTodayQty, "value");
		dataBinder.registerBinding("saleTodayQty", int.class, this.txtsaleTodayQty, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.food.app.PersonDailyEditUIHandler";
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
        this.txtNumber.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.food.PersonDailyInfo)ov;
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
		getValidateHelper().registerBindProperty("BillStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StorageOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AuditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("companyOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allPersonQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("manuPersonQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("devicePersonQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("logisticsPersonQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FIPersonQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("synthesisPersonQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("salePersonQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("manuTodayQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("deceiveTodayQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("logisticsTodayQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FITodayQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("synthesisTodayQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("saleTodayQty", ValidateHelper.ON_SAVE);    		
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
     * output txtmanuPersonQty_Changed() method
     */
    public void txtmanuPersonQty_Changed() throws Exception
    {
        System.out.println("txtmanuPersonQty_Changed() Function is executed!");
            txtallPersonQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmanuPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtdevicePersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtlogisticsPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtFIPersonQty.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsynthesisPersonQty.getValue())))))+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsalePersonQty.getValue())));
txtallPersonQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmanuPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtdevicePersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtlogisticsPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtFIPersonQty.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsynthesisPersonQty.getValue())))))+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsalePersonQty.getValue())));
txtallPersonQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmanuPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtdevicePersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtlogisticsPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtFIPersonQty.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsynthesisPersonQty.getValue())))))+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsalePersonQty.getValue())));
txtallPersonQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmanuPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtdevicePersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtlogisticsPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtFIPersonQty.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsynthesisPersonQty.getValue())))))+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsalePersonQty.getValue())));
txtallPersonQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmanuPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtdevicePersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtlogisticsPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtFIPersonQty.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsynthesisPersonQty.getValue())))))+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsalePersonQty.getValue())));
txtallPersonQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmanuPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtdevicePersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtlogisticsPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtFIPersonQty.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsynthesisPersonQty.getValue())))))+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsalePersonQty.getValue())));
txtallPersonQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmanuPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtdevicePersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtlogisticsPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtFIPersonQty.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsynthesisPersonQty.getValue())))))+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsalePersonQty.getValue())));
txtallPersonQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmanuPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtdevicePersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtlogisticsPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtFIPersonQty.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsynthesisPersonQty.getValue())))))+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsalePersonQty.getValue())));
txtallPersonQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmanuPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtdevicePersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtlogisticsPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtFIPersonQty.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsynthesisPersonQty.getValue())))))+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsalePersonQty.getValue())));
txtallPersonQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmanuPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtdevicePersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtlogisticsPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtFIPersonQty.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsynthesisPersonQty.getValue())))))+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsalePersonQty.getValue())));
txtallPersonQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmanuPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtdevicePersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtlogisticsPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtFIPersonQty.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsynthesisPersonQty.getValue())))))+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsalePersonQty.getValue())));
txtallPersonQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmanuPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtdevicePersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtlogisticsPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtFIPersonQty.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsynthesisPersonQty.getValue())))))+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsalePersonQty.getValue())));
txtallPersonQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmanuPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtdevicePersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtlogisticsPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtFIPersonQty.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsynthesisPersonQty.getValue())))))+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsalePersonQty.getValue())));
txtallPersonQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmanuPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtdevicePersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtlogisticsPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtFIPersonQty.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsynthesisPersonQty.getValue())))))+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsalePersonQty.getValue())));
txtallPersonQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmanuPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtdevicePersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtlogisticsPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtFIPersonQty.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsynthesisPersonQty.getValue())))))+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsalePersonQty.getValue())));
txtallPersonQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmanuPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtdevicePersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtlogisticsPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtFIPersonQty.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsynthesisPersonQty.getValue())))))+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsalePersonQty.getValue())));


    }

    /**
     * output txtdevicePersonQty_Changed() method
     */
    public void txtdevicePersonQty_Changed() throws Exception
    {
        System.out.println("txtdevicePersonQty_Changed() Function is executed!");
            txtallPersonQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmanuPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtdevicePersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtlogisticsPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtFIPersonQty.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsynthesisPersonQty.getValue())))))+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsalePersonQty.getValue())));


    }

    /**
     * output txtlogisticsPersonQty_Changed() method
     */
    public void txtlogisticsPersonQty_Changed() throws Exception
    {
        System.out.println("txtlogisticsPersonQty_Changed() Function is executed!");
            txtallPersonQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmanuPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtdevicePersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtlogisticsPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtFIPersonQty.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsynthesisPersonQty.getValue())))))+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsalePersonQty.getValue())));


    }

    /**
     * output txtFIPersonQty_Changed() method
     */
    public void txtFIPersonQty_Changed() throws Exception
    {
        System.out.println("txtFIPersonQty_Changed() Function is executed!");
            txtallPersonQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmanuPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtdevicePersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtlogisticsPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtFIPersonQty.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsynthesisPersonQty.getValue())))))+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsalePersonQty.getValue())));
txtallPersonQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmanuPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtdevicePersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtlogisticsPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtFIPersonQty.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsynthesisPersonQty.getValue())))))+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsalePersonQty.getValue())));


    }

    /**
     * output txtsynthesisPersonQty_Changed() method
     */
    public void txtsynthesisPersonQty_Changed() throws Exception
    {
        System.out.println("txtsynthesisPersonQty_Changed() Function is executed!");
            txtallPersonQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmanuPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtdevicePersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtlogisticsPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtFIPersonQty.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsynthesisPersonQty.getValue())))))+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsalePersonQty.getValue())));
txtallPersonQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmanuPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtdevicePersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtlogisticsPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtFIPersonQty.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsynthesisPersonQty.getValue())))))+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsalePersonQty.getValue())));
txtallPersonQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmanuPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtdevicePersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtlogisticsPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtFIPersonQty.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsynthesisPersonQty.getValue())))))+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsalePersonQty.getValue())));
txtallPersonQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmanuPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtdevicePersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtlogisticsPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtFIPersonQty.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsynthesisPersonQty.getValue())))))+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsalePersonQty.getValue())));


    }

    /**
     * output txtsalePersonQty_Changed() method
     */
    public void txtsalePersonQty_Changed() throws Exception
    {
        System.out.println("txtsalePersonQty_Changed() Function is executed!");
            txtallPersonQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmanuPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtdevicePersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtlogisticsPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtFIPersonQty.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsynthesisPersonQty.getValue())))))+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsalePersonQty.getValue())));
txtallPersonQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmanuPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtdevicePersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtlogisticsPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtFIPersonQty.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsynthesisPersonQty.getValue())))))+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsalePersonQty.getValue())));
txtallPersonQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmanuPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtdevicePersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtlogisticsPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtFIPersonQty.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsynthesisPersonQty.getValue())))))+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsalePersonQty.getValue())));
txtallPersonQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmanuPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtdevicePersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtlogisticsPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtFIPersonQty.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsynthesisPersonQty.getValue())))))+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsalePersonQty.getValue())));
txtallPersonQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmanuPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtdevicePersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtlogisticsPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtFIPersonQty.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsynthesisPersonQty.getValue())))))+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsalePersonQty.getValue())));
txtallPersonQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmanuPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtdevicePersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtlogisticsPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtFIPersonQty.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsynthesisPersonQty.getValue())))))+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsalePersonQty.getValue())));
txtallPersonQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmanuPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtdevicePersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtlogisticsPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtFIPersonQty.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsynthesisPersonQty.getValue())))))+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsalePersonQty.getValue())));
txtallPersonQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmanuPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtdevicePersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtlogisticsPersonQty.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtFIPersonQty.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsynthesisPersonQty.getValue())))))+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsalePersonQty.getValue())));


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
        sic.add(new SelectorItemInfo("BillStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("StorageOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("StorageOrgUnit.id"));
        	sic.add(new SelectorItemInfo("StorageOrgUnit.number"));
        	sic.add(new SelectorItemInfo("StorageOrgUnit.name"));
		}
        sic.add(new SelectorItemInfo("AuditTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("companyOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("companyOrgUnit.id"));
        	sic.add(new SelectorItemInfo("companyOrgUnit.number"));
        	sic.add(new SelectorItemInfo("companyOrgUnit.name"));
		}
        sic.add(new SelectorItemInfo("allPersonQty"));
        sic.add(new SelectorItemInfo("manuPersonQty"));
        sic.add(new SelectorItemInfo("devicePersonQty"));
        sic.add(new SelectorItemInfo("logisticsPersonQty"));
        sic.add(new SelectorItemInfo("FIPersonQty"));
        sic.add(new SelectorItemInfo("synthesisPersonQty"));
        sic.add(new SelectorItemInfo("salePersonQty"));
        sic.add(new SelectorItemInfo("manuTodayQty"));
        sic.add(new SelectorItemInfo("deceiveTodayQty"));
        sic.add(new SelectorItemInfo("logisticsTodayQty"));
        sic.add(new SelectorItemInfo("FITodayQty"));
        sic.add(new SelectorItemInfo("synthesisTodayQty"));
        sic.add(new SelectorItemInfo("saleTodayQty"));
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
        com.kingdee.eas.farm.food.PersonDailyFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.food.PersonDailyFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractPersonDailyEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractPersonDailyEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.food.client", "PersonDailyEditUI");
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
        return com.kingdee.eas.farm.food.client.PersonDailyEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.food.PersonDailyFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.food.PersonDailyInfo objectValue = new com.kingdee.eas.farm.food.PersonDailyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/food/PersonDaily";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.food.app.PersonDailyQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtStorageOrgUnit.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"库存组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompanyOrgUnit.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {        
        return null;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}