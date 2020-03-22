/**
 * output package name
 */
package com.kingdee.eas.farm.hatch.client;

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
public abstract class AbstractBEggTrayingBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractBEggTrayingBillEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthatchFactory;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallHatchEggQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoperator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallHealthEggQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthatchArea;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contincubator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contotherLoss;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallAddleEggQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallCandlingHealthEggQty;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtTransBoxEntries;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtTransBoxEntries_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthatchDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteggCandling;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteggType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contadjustBill;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgrentTy;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmthatchFactory;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEggEntries;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEggEntries_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallHatchEggQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtoperator;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallHealthEggQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmthatchArea;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtincubator;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtotherLoss;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallAddleEggQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallCandlingHealthEggQty;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkhatchDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkeggCandling;
    protected com.kingdee.bos.ctrl.swing.KDComboBox eggType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtadjustBill;
    protected com.kingdee.bos.ctrl.swing.KDComboBox grentTy;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAdjust;
    protected com.kingdee.eas.farm.hatch.BEggTrayingBillInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionAdjust actionAdjust = null;
    /**
     * output class constructor
     */
    public AbstractBEggTrayingBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractBEggTrayingBillEditUI.class.getName());
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
        this.actionAudit.setBindWorkFlow(true);
        this.actionAudit.setExtendProperty("canForewarn", "true");
        this.actionAudit.setExtendProperty("userDefined", "false");
        this.actionAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionUnAudit
        this.actionUnAudit = new ActionUnAudit(this);
        getActionManager().registerAction("actionUnAudit", actionUnAudit);
        this.actionUnAudit.setBindWorkFlow(true);
        this.actionUnAudit.setExtendProperty("canForewarn", "true");
        this.actionUnAudit.setExtendProperty("userDefined", "false");
        this.actionUnAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionAdjust
        this.actionAdjust = new ActionAdjust(this);
        getActionManager().registerAction("actionAdjust", actionAdjust);
        this.actionAdjust.setExtendProperty("canForewarn", "true");
        this.actionAdjust.setExtendProperty("userDefined", "false");
        this.actionAdjust.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAdjust.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAdjust.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthatchFactory = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane2 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contallHatchEggQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoperator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallHealthEggQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthatchArea = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contincubator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contotherLoss = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallAddleEggQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallCandlingHealthEggQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtTransBoxEntries = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.conthatchDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteggCandling = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteggType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contadjustBill = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgrentTy = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmthatchFactory = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEggEntries = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.txtallHatchEggQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtoperator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtallHealthEggQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmthatchArea = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtincubator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtotherLoss = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallAddleEggQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallCandlingHealthEggQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkhatchDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkeggCandling = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.eggType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtadjustBill = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.grentTy = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnAdjust = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.contauditTime.setName("contauditTime");
        this.contbaseStatus.setName("contbaseStatus");
        this.conthatchFactory.setName("conthatchFactory");
        this.kDTabbedPane2.setName("kDTabbedPane2");
        this.contallHatchEggQty.setName("contallHatchEggQty");
        this.contoperator.setName("contoperator");
        this.contallHealthEggQty.setName("contallHealthEggQty");
        this.conthatchArea.setName("conthatchArea");
        this.contincubator.setName("contincubator");
        this.contotherLoss.setName("contotherLoss");
        this.contallAddleEggQty.setName("contallAddleEggQty");
        this.contallCandlingHealthEggQty.setName("contallCandlingHealthEggQty");
        this.kdtTransBoxEntries.setName("kdtTransBoxEntries");
        this.conthatchDate.setName("conthatchDate");
        this.conteggCandling.setName("conteggCandling");
        this.conteggType.setName("conteggType");
        this.contadjustBill.setName("contadjustBill");
        this.contgrentTy.setName("contgrentTy");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.pkauditTime.setName("pkauditTime");
        this.baseStatus.setName("baseStatus");
        this.prmthatchFactory.setName("prmthatchFactory");
        this.kDPanel2.setName("kDPanel2");
        this.kdtEggEntries.setName("kdtEggEntries");
        this.txtallHatchEggQty.setName("txtallHatchEggQty");
        this.prmtoperator.setName("prmtoperator");
        this.txtallHealthEggQty.setName("txtallHealthEggQty");
        this.prmthatchArea.setName("prmthatchArea");
        this.prmtincubator.setName("prmtincubator");
        this.txtotherLoss.setName("txtotherLoss");
        this.txtallAddleEggQty.setName("txtallAddleEggQty");
        this.txtallCandlingHealthEggQty.setName("txtallCandlingHealthEggQty");
        this.pkhatchDate.setName("pkhatchDate");
        this.pkeggCandling.setName("pkeggCandling");
        this.eggType.setName("eggType");
        this.prmtadjustBill.setName("prmtadjustBill");
        this.grentTy.setName("grentTy");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
        this.btnAdjust.setName("btnAdjust");
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
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);
        // conthatchFactory		
        this.conthatchFactory.setBoundLabelText(resHelper.getString("conthatchFactory.boundLabelText"));		
        this.conthatchFactory.setBoundLabelLength(100);		
        this.conthatchFactory.setBoundLabelUnderline(true);		
        this.conthatchFactory.setVisible(true);
        // kDTabbedPane2
        // contallHatchEggQty		
        this.contallHatchEggQty.setBoundLabelText(resHelper.getString("contallHatchEggQty.boundLabelText"));		
        this.contallHatchEggQty.setBoundLabelLength(100);		
        this.contallHatchEggQty.setBoundLabelUnderline(true);		
        this.contallHatchEggQty.setVisible(true);
        // contoperator		
        this.contoperator.setBoundLabelText(resHelper.getString("contoperator.boundLabelText"));		
        this.contoperator.setBoundLabelLength(100);		
        this.contoperator.setBoundLabelUnderline(true);		
        this.contoperator.setVisible(true);
        // contallHealthEggQty		
        this.contallHealthEggQty.setBoundLabelText(resHelper.getString("contallHealthEggQty.boundLabelText"));		
        this.contallHealthEggQty.setBoundLabelLength(100);		
        this.contallHealthEggQty.setBoundLabelUnderline(true);		
        this.contallHealthEggQty.setVisible(true);
        // conthatchArea		
        this.conthatchArea.setBoundLabelText(resHelper.getString("conthatchArea.boundLabelText"));		
        this.conthatchArea.setBoundLabelLength(100);		
        this.conthatchArea.setBoundLabelUnderline(true);		
        this.conthatchArea.setVisible(false);
        // contincubator		
        this.contincubator.setBoundLabelText(resHelper.getString("contincubator.boundLabelText"));		
        this.contincubator.setBoundLabelLength(100);		
        this.contincubator.setBoundLabelUnderline(true);		
        this.contincubator.setVisible(false);
        // contotherLoss		
        this.contotherLoss.setBoundLabelText(resHelper.getString("contotherLoss.boundLabelText"));		
        this.contotherLoss.setBoundLabelLength(100);		
        this.contotherLoss.setBoundLabelUnderline(true);		
        this.contotherLoss.setVisible(true);
        // contallAddleEggQty		
        this.contallAddleEggQty.setBoundLabelText(resHelper.getString("contallAddleEggQty.boundLabelText"));		
        this.contallAddleEggQty.setBoundLabelLength(100);		
        this.contallAddleEggQty.setBoundLabelUnderline(true);		
        this.contallAddleEggQty.setVisible(true);
        // contallCandlingHealthEggQty		
        this.contallCandlingHealthEggQty.setBoundLabelText(resHelper.getString("contallCandlingHealthEggQty.boundLabelText"));		
        this.contallCandlingHealthEggQty.setBoundLabelLength(100);		
        this.contallCandlingHealthEggQty.setBoundLabelUnderline(true);		
        this.contallCandlingHealthEggQty.setVisible(true);
        // kdtTransBoxEntries
		String kdtTransBoxEntriesStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"hatchingBox\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"inQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"description\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{hatchingBox}</t:Cell><t:Cell>$Resource{inQty}</t:Cell><t:Cell>$Resource{description}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtTransBoxEntries.setFormatXml(resHelper.translateString("kdtTransBoxEntries",kdtTransBoxEntriesStrXML));

                this.kdtTransBoxEntries.putBindContents("editData",new String[] {"seq","hatchingBox","inQty","description"});


        this.kdtTransBoxEntries.checkParsed();
        final KDBizPromptBox kdtTransBoxEntries_hatchingBox_PromptBox = new KDBizPromptBox();
        kdtTransBoxEntries_hatchingBox_PromptBox.setQueryInfo("com.kingdee.eas.farm.hatch.app.F7HatchingBoxQuery");
        kdtTransBoxEntries_hatchingBox_PromptBox.setVisible(true);
        kdtTransBoxEntries_hatchingBox_PromptBox.setEditable(true);
        kdtTransBoxEntries_hatchingBox_PromptBox.setDisplayFormat("$number$");
        kdtTransBoxEntries_hatchingBox_PromptBox.setEditFormat("$number$");
        kdtTransBoxEntries_hatchingBox_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtTransBoxEntries_hatchingBox_CellEditor = new KDTDefaultCellEditor(kdtTransBoxEntries_hatchingBox_PromptBox);
        this.kdtTransBoxEntries.getColumn("hatchingBox").setEditor(kdtTransBoxEntries_hatchingBox_CellEditor);
        ObjectValueRender kdtTransBoxEntries_hatchingBox_OVR = new ObjectValueRender();
        kdtTransBoxEntries_hatchingBox_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtTransBoxEntries.getColumn("hatchingBox").setRenderer(kdtTransBoxEntries_hatchingBox_OVR);
        			kdtTransBoxEntries_hatchingBox_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.HatchingBoxListUI kdtTransBoxEntries_hatchingBox_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtTransBoxEntries_hatchingBox_PromptBox_F7ListUI == null) {
					try {
						kdtTransBoxEntries_hatchingBox_PromptBox_F7ListUI = new com.kingdee.eas.farm.hatch.client.HatchingBoxListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtTransBoxEntries_hatchingBox_PromptBox_F7ListUI));
					kdtTransBoxEntries_hatchingBox_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtTransBoxEntries_hatchingBox_PromptBox.setSelector(kdtTransBoxEntries_hatchingBox_PromptBox_F7ListUI);
				}
			}
		});
					
        KDFormattedTextField kdtTransBoxEntries_inQty_TextField = new KDFormattedTextField();
        kdtTransBoxEntries_inQty_TextField.setName("kdtTransBoxEntries_inQty_TextField");
        kdtTransBoxEntries_inQty_TextField.setVisible(true);
        kdtTransBoxEntries_inQty_TextField.setEditable(true);
        kdtTransBoxEntries_inQty_TextField.setHorizontalAlignment(2);
        kdtTransBoxEntries_inQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtTransBoxEntries_inQty_CellEditor = new KDTDefaultCellEditor(kdtTransBoxEntries_inQty_TextField);
        this.kdtTransBoxEntries.getColumn("inQty").setEditor(kdtTransBoxEntries_inQty_CellEditor);
        KDTextField kdtTransBoxEntries_description_TextField = new KDTextField();
        kdtTransBoxEntries_description_TextField.setName("kdtTransBoxEntries_description_TextField");
        kdtTransBoxEntries_description_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtTransBoxEntries_description_CellEditor = new KDTDefaultCellEditor(kdtTransBoxEntries_description_TextField);
        this.kdtTransBoxEntries.getColumn("description").setEditor(kdtTransBoxEntries_description_CellEditor);
        // conthatchDate		
        this.conthatchDate.setBoundLabelText(resHelper.getString("conthatchDate.boundLabelText"));		
        this.conthatchDate.setBoundLabelLength(100);		
        this.conthatchDate.setBoundLabelUnderline(true);		
        this.conthatchDate.setVisible(true);
        // conteggCandling		
        this.conteggCandling.setBoundLabelText(resHelper.getString("conteggCandling.boundLabelText"));		
        this.conteggCandling.setBoundLabelLength(100);		
        this.conteggCandling.setBoundLabelUnderline(true);		
        this.conteggCandling.setVisible(true);
        // conteggType		
        this.conteggType.setBoundLabelText(resHelper.getString("conteggType.boundLabelText"));		
        this.conteggType.setBoundLabelLength(100);		
        this.conteggType.setBoundLabelUnderline(true);		
        this.conteggType.setVisible(true);
        // contadjustBill		
        this.contadjustBill.setBoundLabelText(resHelper.getString("contadjustBill.boundLabelText"));		
        this.contadjustBill.setBoundLabelLength(100);		
        this.contadjustBill.setBoundLabelUnderline(true);		
        this.contadjustBill.setVisible(false);
        // contgrentTy		
        this.contgrentTy.setBoundLabelText(resHelper.getString("contgrentTy.boundLabelText"));		
        this.contgrentTy.setBoundLabelLength(100);		
        this.contgrentTy.setBoundLabelUnderline(true);		
        this.contgrentTy.setVisible(true);
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
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(false);		
        this.baseStatus.setEnabled(false);
        // prmthatchFactory		
        this.prmthatchFactory.setQueryInfo("com.kingdee.eas.farm.hatch.app.HatchBaseDataQuery");		
        this.prmthatchFactory.setEditable(true);		
        this.prmthatchFactory.setDisplayFormat("$name$");		
        this.prmthatchFactory.setEditFormat("$number$");		
        this.prmthatchFactory.setCommitFormat("$number$");		
        this.prmthatchFactory.setRequired(false);		
        this.prmthatchFactory.setEnabled(false);
        		prmthatchFactory.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.HatchBaseDataListUI prmthatchFactory_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmthatchFactory_F7ListUI == null) {
					try {
						prmthatchFactory_F7ListUI = new com.kingdee.eas.farm.hatch.client.HatchBaseDataListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmthatchFactory_F7ListUI));
					prmthatchFactory_F7ListUI.setF7Use(true,ctx);
					prmthatchFactory.setSelector(prmthatchFactory_F7ListUI);
				}
			}
		});
					
        // kDPanel2
        // kdtEggEntries
		String kdtEggEntriesStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol8\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol9\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol10\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol11\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol12\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol13\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol14\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol15\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol16\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol17\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol18\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol19\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol20\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol21\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol22\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol23\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol24\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol25\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol26\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol27\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol28\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol29\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol30\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"inBabyHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"hatchBox\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"outBabyHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"outBabyBox\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"hatchCarNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"eggSourceType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"isMix\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"outArea\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"genderType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"supplier\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"outBatch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"farmer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"farm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"outHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"CostObject\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"eggLog\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /><t:Column t:key=\"eggType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"ishunhe\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"eggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol19\" /><t:Column t:key=\"candingHealthEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol20\" /><t:Column t:key=\"candlingFertiRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol21\" /><t:Column t:key=\"sunBadEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol22\" /><t:Column t:key=\"trayingSadEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol23\" /><t:Column t:key=\"healthTrayingEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol24\" /><t:Column t:key=\"psEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol25\" /><t:Column t:key=\"healthEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol26\" /><t:Column t:key=\"addleEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol27\" /><t:Column t:key=\"trayingWeight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol28\" /><t:Column t:key=\"otherEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol29\" /><t:Column t:key=\"allFertilityRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol30\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{inBabyHouse}</t:Cell><t:Cell>$Resource{hatchBox}</t:Cell><t:Cell>$Resource{outBabyHouse}</t:Cell><t:Cell>$Resource{outBabyBox}</t:Cell><t:Cell>$Resource{hatchCarNum}</t:Cell><t:Cell>$Resource{eggSourceType}</t:Cell><t:Cell>$Resource{isMix}</t:Cell><t:Cell>$Resource{outArea}</t:Cell><t:Cell>$Resource{genderType}</t:Cell><t:Cell>$Resource{supplier}</t:Cell><t:Cell>$Resource{outBatch}</t:Cell><t:Cell>$Resource{farmer}</t:Cell><t:Cell>$Resource{farm}</t:Cell><t:Cell>$Resource{outHouse}</t:Cell><t:Cell>$Resource{CostObject}</t:Cell><t:Cell>$Resource{eggLog}</t:Cell><t:Cell>$Resource{eggType}</t:Cell><t:Cell>$Resource{ishunhe}</t:Cell><t:Cell>$Resource{eggQty}</t:Cell><t:Cell>$Resource{candingHealthEggQty}</t:Cell><t:Cell>$Resource{candlingFertiRate}</t:Cell><t:Cell>$Resource{sunBadEggQty}</t:Cell><t:Cell>$Resource{trayingSadEggQty}</t:Cell><t:Cell>$Resource{healthTrayingEggQty}</t:Cell><t:Cell>$Resource{psEggQty}</t:Cell><t:Cell>$Resource{healthEggQty}</t:Cell><t:Cell>$Resource{addleEggQty}</t:Cell><t:Cell>$Resource{trayingWeight}</t:Cell><t:Cell>$Resource{otherEggQty}</t:Cell><t:Cell>$Resource{allFertilityRate}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEggEntries.setFormatXml(resHelper.translateString("kdtEggEntries",kdtEggEntriesStrXML));

                this.kdtEggEntries.putBindContents("editData",new String[] {"seq","inBabyHouse","hatchBox","outBabyHouse","outBabyBox","hatchCarNum","eggSourceType","isMix","outArea","genderType","supplier","outBatch","farmer","farm","outHouse","CostObject","eggLog","eggType","ishunhe","eggQty","candingHealthEggQty","candlingFertiRate","sunBadEggQty","trayingSadEggQty","healthTrayingEggQty","psEggQty","healthEggQty","addleEggQty","trayingWeight","otherEggQty","allFertilityRate"});


        this.kdtEggEntries.checkParsed();
        final KDBizPromptBox kdtEggEntries_inBabyHouse_PromptBox = new KDBizPromptBox();
        kdtEggEntries_inBabyHouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.hatch.app.HatchHouseQuery");
        kdtEggEntries_inBabyHouse_PromptBox.setVisible(true);
        kdtEggEntries_inBabyHouse_PromptBox.setEditable(true);
        kdtEggEntries_inBabyHouse_PromptBox.setDisplayFormat("$number$");
        kdtEggEntries_inBabyHouse_PromptBox.setEditFormat("$number$");
        kdtEggEntries_inBabyHouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntries_inBabyHouse_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_inBabyHouse_PromptBox);
        this.kdtEggEntries.getColumn("inBabyHouse").setEditor(kdtEggEntries_inBabyHouse_CellEditor);
        ObjectValueRender kdtEggEntries_inBabyHouse_OVR = new ObjectValueRender();
        kdtEggEntries_inBabyHouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntries.getColumn("inBabyHouse").setRenderer(kdtEggEntries_inBabyHouse_OVR);
        			kdtEggEntries_inBabyHouse_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.HatchHouseListUI kdtEggEntries_inBabyHouse_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEggEntries_inBabyHouse_PromptBox_F7ListUI == null) {
					try {
						kdtEggEntries_inBabyHouse_PromptBox_F7ListUI = new com.kingdee.eas.farm.hatch.client.HatchHouseListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEggEntries_inBabyHouse_PromptBox_F7ListUI));
					kdtEggEntries_inBabyHouse_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEggEntries_inBabyHouse_PromptBox.setSelector(kdtEggEntries_inBabyHouse_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEggEntries_hatchBox_PromptBox = new KDBizPromptBox();
        kdtEggEntries_hatchBox_PromptBox.setQueryInfo("com.kingdee.eas.farm.hatch.app.F7IncubatorQuery");
        kdtEggEntries_hatchBox_PromptBox.setVisible(true);
        kdtEggEntries_hatchBox_PromptBox.setEditable(true);
        kdtEggEntries_hatchBox_PromptBox.setDisplayFormat("$number$");
        kdtEggEntries_hatchBox_PromptBox.setEditFormat("$number$");
        kdtEggEntries_hatchBox_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntries_hatchBox_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_hatchBox_PromptBox);
        this.kdtEggEntries.getColumn("hatchBox").setEditor(kdtEggEntries_hatchBox_CellEditor);
        ObjectValueRender kdtEggEntries_hatchBox_OVR = new ObjectValueRender();
        kdtEggEntries_hatchBox_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntries.getColumn("hatchBox").setRenderer(kdtEggEntries_hatchBox_OVR);
        			kdtEggEntries_hatchBox_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.IncubatorListUI kdtEggEntries_hatchBox_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEggEntries_hatchBox_PromptBox_F7ListUI == null) {
					try {
						kdtEggEntries_hatchBox_PromptBox_F7ListUI = new com.kingdee.eas.farm.hatch.client.IncubatorListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEggEntries_hatchBox_PromptBox_F7ListUI));
					kdtEggEntries_hatchBox_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEggEntries_hatchBox_PromptBox.setSelector(kdtEggEntries_hatchBox_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEggEntries_outBabyHouse_PromptBox = new KDBizPromptBox();
        kdtEggEntries_outBabyHouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.hatch.app.HatchHouseQuery");
        kdtEggEntries_outBabyHouse_PromptBox.setVisible(true);
        kdtEggEntries_outBabyHouse_PromptBox.setEditable(true);
        kdtEggEntries_outBabyHouse_PromptBox.setDisplayFormat("$number$");
        kdtEggEntries_outBabyHouse_PromptBox.setEditFormat("$number$");
        kdtEggEntries_outBabyHouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntries_outBabyHouse_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_outBabyHouse_PromptBox);
        this.kdtEggEntries.getColumn("outBabyHouse").setEditor(kdtEggEntries_outBabyHouse_CellEditor);
        ObjectValueRender kdtEggEntries_outBabyHouse_OVR = new ObjectValueRender();
        kdtEggEntries_outBabyHouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntries.getColumn("outBabyHouse").setRenderer(kdtEggEntries_outBabyHouse_OVR);
        			kdtEggEntries_outBabyHouse_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.HatchHouseListUI kdtEggEntries_outBabyHouse_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEggEntries_outBabyHouse_PromptBox_F7ListUI == null) {
					try {
						kdtEggEntries_outBabyHouse_PromptBox_F7ListUI = new com.kingdee.eas.farm.hatch.client.HatchHouseListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEggEntries_outBabyHouse_PromptBox_F7ListUI));
					kdtEggEntries_outBabyHouse_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEggEntries_outBabyHouse_PromptBox.setSelector(kdtEggEntries_outBabyHouse_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEggEntries_outBabyBox_PromptBox = new KDBizPromptBox();
        kdtEggEntries_outBabyBox_PromptBox.setQueryInfo("com.kingdee.eas.farm.hatch.app.F7HatchingBoxQuery");
        kdtEggEntries_outBabyBox_PromptBox.setVisible(true);
        kdtEggEntries_outBabyBox_PromptBox.setEditable(true);
        kdtEggEntries_outBabyBox_PromptBox.setDisplayFormat("$number$");
        kdtEggEntries_outBabyBox_PromptBox.setEditFormat("$number$");
        kdtEggEntries_outBabyBox_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntries_outBabyBox_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_outBabyBox_PromptBox);
        this.kdtEggEntries.getColumn("outBabyBox").setEditor(kdtEggEntries_outBabyBox_CellEditor);
        ObjectValueRender kdtEggEntries_outBabyBox_OVR = new ObjectValueRender();
        kdtEggEntries_outBabyBox_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntries.getColumn("outBabyBox").setRenderer(kdtEggEntries_outBabyBox_OVR);
        			kdtEggEntries_outBabyBox_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.HatchingBoxListUI kdtEggEntries_outBabyBox_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEggEntries_outBabyBox_PromptBox_F7ListUI == null) {
					try {
						kdtEggEntries_outBabyBox_PromptBox_F7ListUI = new com.kingdee.eas.farm.hatch.client.HatchingBoxListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEggEntries_outBabyBox_PromptBox_F7ListUI));
					kdtEggEntries_outBabyBox_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEggEntries_outBabyBox_PromptBox.setSelector(kdtEggEntries_outBabyBox_PromptBox_F7ListUI);
				}
			}
		});
					
        KDTextField kdtEggEntries_hatchCarNum_TextField = new KDTextField();
        kdtEggEntries_hatchCarNum_TextField.setName("kdtEggEntries_hatchCarNum_TextField");
        kdtEggEntries_hatchCarNum_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEggEntries_hatchCarNum_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_hatchCarNum_TextField);
        this.kdtEggEntries.getColumn("hatchCarNum").setEditor(kdtEggEntries_hatchCarNum_CellEditor);
        KDComboBox kdtEggEntries_eggSourceType_ComboBox = new KDComboBox();
        kdtEggEntries_eggSourceType_ComboBox.setName("kdtEggEntries_eggSourceType_ComboBox");
        kdtEggEntries_eggSourceType_ComboBox.setVisible(true);
        kdtEggEntries_eggSourceType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.hatch.EggSourceType").toArray());
        KDTDefaultCellEditor kdtEggEntries_eggSourceType_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_eggSourceType_ComboBox);
        this.kdtEggEntries.getColumn("eggSourceType").setEditor(kdtEggEntries_eggSourceType_CellEditor);
        KDCheckBox kdtEggEntries_isMix_CheckBox = new KDCheckBox();
        kdtEggEntries_isMix_CheckBox.setName("kdtEggEntries_isMix_CheckBox");
        KDTDefaultCellEditor kdtEggEntries_isMix_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_isMix_CheckBox);
        this.kdtEggEntries.getColumn("isMix").setEditor(kdtEggEntries_isMix_CellEditor);
        final KDBizPromptBox kdtEggEntries_outArea_PromptBox = new KDBizPromptBox();
        kdtEggEntries_outArea_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.F7FarmerGroupQuery");
        kdtEggEntries_outArea_PromptBox.setVisible(true);
        kdtEggEntries_outArea_PromptBox.setEditable(true);
        kdtEggEntries_outArea_PromptBox.setDisplayFormat("$number$");
        kdtEggEntries_outArea_PromptBox.setEditFormat("$number$");
        kdtEggEntries_outArea_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntries_outArea_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_outArea_PromptBox);
        this.kdtEggEntries.getColumn("outArea").setEditor(kdtEggEntries_outArea_CellEditor);
        ObjectValueRender kdtEggEntries_outArea_OVR = new ObjectValueRender();
        kdtEggEntries_outArea_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntries.getColumn("outArea").setRenderer(kdtEggEntries_outArea_OVR);
        KDComboBox kdtEggEntries_genderType_ComboBox = new KDComboBox();
        kdtEggEntries_genderType_ComboBox.setName("kdtEggEntries_genderType_ComboBox");
        kdtEggEntries_genderType_ComboBox.setVisible(true);
        kdtEggEntries_genderType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.hatch.GenderType").toArray());
        KDTDefaultCellEditor kdtEggEntries_genderType_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_genderType_ComboBox);
        this.kdtEggEntries.getColumn("genderType").setEditor(kdtEggEntries_genderType_CellEditor);
        final KDBizPromptBox kdtEggEntries_supplier_PromptBox = new KDBizPromptBox();
        kdtEggEntries_supplier_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.F7SupplierDefaultQuery");
        kdtEggEntries_supplier_PromptBox.setVisible(true);
        kdtEggEntries_supplier_PromptBox.setEditable(true);
        kdtEggEntries_supplier_PromptBox.setDisplayFormat("$number$");
        kdtEggEntries_supplier_PromptBox.setEditFormat("$number$");
        kdtEggEntries_supplier_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntries_supplier_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_supplier_PromptBox);
        this.kdtEggEntries.getColumn("supplier").setEditor(kdtEggEntries_supplier_CellEditor);
        ObjectValueRender kdtEggEntries_supplier_OVR = new ObjectValueRender();
        kdtEggEntries_supplier_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntries.getColumn("supplier").setRenderer(kdtEggEntries_supplier_OVR);
        final KDBizPromptBox kdtEggEntries_outBatch_PromptBox = new KDBizPromptBox();
        kdtEggEntries_outBatch_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.StockingBatchQuery");
        kdtEggEntries_outBatch_PromptBox.setVisible(true);
        kdtEggEntries_outBatch_PromptBox.setEditable(true);
        kdtEggEntries_outBatch_PromptBox.setDisplayFormat("$number$");
        kdtEggEntries_outBatch_PromptBox.setEditFormat("$number$");
        kdtEggEntries_outBatch_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntries_outBatch_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_outBatch_PromptBox);
        this.kdtEggEntries.getColumn("outBatch").setEditor(kdtEggEntries_outBatch_CellEditor);
        ObjectValueRender kdtEggEntries_outBatch_OVR = new ObjectValueRender();
        kdtEggEntries_outBatch_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntries.getColumn("outBatch").setRenderer(kdtEggEntries_outBatch_OVR);
        			kdtEggEntries_outBatch_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI kdtEggEntries_outBatch_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEggEntries_outBatch_PromptBox_F7ListUI == null) {
					try {
						kdtEggEntries_outBatch_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEggEntries_outBatch_PromptBox_F7ListUI));
					kdtEggEntries_outBatch_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEggEntries_outBatch_PromptBox.setSelector(kdtEggEntries_outBatch_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEggEntries_farmer_PromptBox = new KDBizPromptBox();
        kdtEggEntries_farmer_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmersQuery");
        kdtEggEntries_farmer_PromptBox.setVisible(true);
        kdtEggEntries_farmer_PromptBox.setEditable(true);
        kdtEggEntries_farmer_PromptBox.setDisplayFormat("$number$");
        kdtEggEntries_farmer_PromptBox.setEditFormat("$number$");
        kdtEggEntries_farmer_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntries_farmer_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_farmer_PromptBox);
        this.kdtEggEntries.getColumn("farmer").setEditor(kdtEggEntries_farmer_CellEditor);
        ObjectValueRender kdtEggEntries_farmer_OVR = new ObjectValueRender();
        kdtEggEntries_farmer_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntries.getColumn("farmer").setRenderer(kdtEggEntries_farmer_OVR);
        			kdtEggEntries_farmer_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI kdtEggEntries_farmer_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEggEntries_farmer_PromptBox_F7ListUI == null) {
					try {
						kdtEggEntries_farmer_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEggEntries_farmer_PromptBox_F7ListUI));
					kdtEggEntries_farmer_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEggEntries_farmer_PromptBox.setSelector(kdtEggEntries_farmer_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEggEntries_farm_PromptBox = new KDBizPromptBox();
        kdtEggEntries_farm_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmQuery");
        kdtEggEntries_farm_PromptBox.setVisible(true);
        kdtEggEntries_farm_PromptBox.setEditable(true);
        kdtEggEntries_farm_PromptBox.setDisplayFormat("$number$");
        kdtEggEntries_farm_PromptBox.setEditFormat("$number$");
        kdtEggEntries_farm_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntries_farm_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_farm_PromptBox);
        this.kdtEggEntries.getColumn("farm").setEditor(kdtEggEntries_farm_CellEditor);
        ObjectValueRender kdtEggEntries_farm_OVR = new ObjectValueRender();
        kdtEggEntries_farm_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntries.getColumn("farm").setRenderer(kdtEggEntries_farm_OVR);
        			kdtEggEntries_farm_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmListUI kdtEggEntries_farm_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEggEntries_farm_PromptBox_F7ListUI == null) {
					try {
						kdtEggEntries_farm_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEggEntries_farm_PromptBox_F7ListUI));
					kdtEggEntries_farm_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEggEntries_farm_PromptBox.setSelector(kdtEggEntries_farm_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEggEntries_outHouse_PromptBox = new KDBizPromptBox();
        kdtEggEntries_outHouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
        kdtEggEntries_outHouse_PromptBox.setVisible(true);
        kdtEggEntries_outHouse_PromptBox.setEditable(true);
        kdtEggEntries_outHouse_PromptBox.setDisplayFormat("$number$");
        kdtEggEntries_outHouse_PromptBox.setEditFormat("$number$");
        kdtEggEntries_outHouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntries_outHouse_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_outHouse_PromptBox);
        this.kdtEggEntries.getColumn("outHouse").setEditor(kdtEggEntries_outHouse_CellEditor);
        ObjectValueRender kdtEggEntries_outHouse_OVR = new ObjectValueRender();
        kdtEggEntries_outHouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntries.getColumn("outHouse").setRenderer(kdtEggEntries_outHouse_OVR);
        final KDBizPromptBox kdtEggEntries_CostObject_PromptBox = new KDBizPromptBox();
        kdtEggEntries_CostObject_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");
        kdtEggEntries_CostObject_PromptBox.setVisible(true);
        kdtEggEntries_CostObject_PromptBox.setEditable(true);
        kdtEggEntries_CostObject_PromptBox.setDisplayFormat("$number$");
        kdtEggEntries_CostObject_PromptBox.setEditFormat("$number$");
        kdtEggEntries_CostObject_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntries_CostObject_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_CostObject_PromptBox);
        this.kdtEggEntries.getColumn("CostObject").setEditor(kdtEggEntries_CostObject_CellEditor);
        ObjectValueRender kdtEggEntries_CostObject_OVR = new ObjectValueRender();
        kdtEggEntries_CostObject_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntries.getColumn("CostObject").setRenderer(kdtEggEntries_CostObject_OVR);
        KDTextField kdtEggEntries_eggLog_TextField = new KDTextField();
        kdtEggEntries_eggLog_TextField.setName("kdtEggEntries_eggLog_TextField");
        kdtEggEntries_eggLog_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEggEntries_eggLog_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_eggLog_TextField);
        this.kdtEggEntries.getColumn("eggLog").setEditor(kdtEggEntries_eggLog_CellEditor);
        KDComboBox kdtEggEntries_eggType_ComboBox = new KDComboBox();
        kdtEggEntries_eggType_ComboBox.setName("kdtEggEntries_eggType_ComboBox");
        kdtEggEntries_eggType_ComboBox.setVisible(true);
        kdtEggEntries_eggType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.hatch.QcEggTypeEnum").toArray());
        KDTDefaultCellEditor kdtEggEntries_eggType_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_eggType_ComboBox);
        this.kdtEggEntries.getColumn("eggType").setEditor(kdtEggEntries_eggType_CellEditor);
        KDCheckBox kdtEggEntries_ishunhe_CheckBox = new KDCheckBox();
        kdtEggEntries_ishunhe_CheckBox.setName("kdtEggEntries_ishunhe_CheckBox");
        KDTDefaultCellEditor kdtEggEntries_ishunhe_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_ishunhe_CheckBox);
        this.kdtEggEntries.getColumn("ishunhe").setEditor(kdtEggEntries_ishunhe_CellEditor);
        KDFormattedTextField kdtEggEntries_eggQty_TextField = new KDFormattedTextField();
        kdtEggEntries_eggQty_TextField.setName("kdtEggEntries_eggQty_TextField");
        kdtEggEntries_eggQty_TextField.setVisible(true);
        kdtEggEntries_eggQty_TextField.setEditable(true);
        kdtEggEntries_eggQty_TextField.setHorizontalAlignment(2);
        kdtEggEntries_eggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntries_eggQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_eggQty_TextField);
        this.kdtEggEntries.getColumn("eggQty").setEditor(kdtEggEntries_eggQty_CellEditor);
        KDFormattedTextField kdtEggEntries_candingHealthEggQty_TextField = new KDFormattedTextField();
        kdtEggEntries_candingHealthEggQty_TextField.setName("kdtEggEntries_candingHealthEggQty_TextField");
        kdtEggEntries_candingHealthEggQty_TextField.setVisible(true);
        kdtEggEntries_candingHealthEggQty_TextField.setEditable(true);
        kdtEggEntries_candingHealthEggQty_TextField.setHorizontalAlignment(2);
        kdtEggEntries_candingHealthEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntries_candingHealthEggQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_candingHealthEggQty_TextField);
        this.kdtEggEntries.getColumn("candingHealthEggQty").setEditor(kdtEggEntries_candingHealthEggQty_CellEditor);
        KDFormattedTextField kdtEggEntries_candlingFertiRate_TextField = new KDFormattedTextField();
        kdtEggEntries_candlingFertiRate_TextField.setName("kdtEggEntries_candlingFertiRate_TextField");
        kdtEggEntries_candlingFertiRate_TextField.setVisible(true);
        kdtEggEntries_candlingFertiRate_TextField.setEditable(true);
        kdtEggEntries_candlingFertiRate_TextField.setHorizontalAlignment(2);
        kdtEggEntries_candlingFertiRate_TextField.setDataType(1);
        	kdtEggEntries_candlingFertiRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEggEntries_candlingFertiRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEggEntries_candlingFertiRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEggEntries_candlingFertiRate_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_candlingFertiRate_TextField);
        this.kdtEggEntries.getColumn("candlingFertiRate").setEditor(kdtEggEntries_candlingFertiRate_CellEditor);
        KDFormattedTextField kdtEggEntries_sunBadEggQty_TextField = new KDFormattedTextField();
        kdtEggEntries_sunBadEggQty_TextField.setName("kdtEggEntries_sunBadEggQty_TextField");
        kdtEggEntries_sunBadEggQty_TextField.setVisible(true);
        kdtEggEntries_sunBadEggQty_TextField.setEditable(true);
        kdtEggEntries_sunBadEggQty_TextField.setHorizontalAlignment(2);
        kdtEggEntries_sunBadEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntries_sunBadEggQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_sunBadEggQty_TextField);
        this.kdtEggEntries.getColumn("sunBadEggQty").setEditor(kdtEggEntries_sunBadEggQty_CellEditor);
        KDFormattedTextField kdtEggEntries_trayingSadEggQty_TextField = new KDFormattedTextField();
        kdtEggEntries_trayingSadEggQty_TextField.setName("kdtEggEntries_trayingSadEggQty_TextField");
        kdtEggEntries_trayingSadEggQty_TextField.setVisible(true);
        kdtEggEntries_trayingSadEggQty_TextField.setEditable(true);
        kdtEggEntries_trayingSadEggQty_TextField.setHorizontalAlignment(2);
        kdtEggEntries_trayingSadEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntries_trayingSadEggQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_trayingSadEggQty_TextField);
        this.kdtEggEntries.getColumn("trayingSadEggQty").setEditor(kdtEggEntries_trayingSadEggQty_CellEditor);
        KDFormattedTextField kdtEggEntries_healthTrayingEggQty_TextField = new KDFormattedTextField();
        kdtEggEntries_healthTrayingEggQty_TextField.setName("kdtEggEntries_healthTrayingEggQty_TextField");
        kdtEggEntries_healthTrayingEggQty_TextField.setVisible(true);
        kdtEggEntries_healthTrayingEggQty_TextField.setEditable(true);
        kdtEggEntries_healthTrayingEggQty_TextField.setHorizontalAlignment(2);
        kdtEggEntries_healthTrayingEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntries_healthTrayingEggQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_healthTrayingEggQty_TextField);
        this.kdtEggEntries.getColumn("healthTrayingEggQty").setEditor(kdtEggEntries_healthTrayingEggQty_CellEditor);
        KDFormattedTextField kdtEggEntries_psEggQty_TextField = new KDFormattedTextField();
        kdtEggEntries_psEggQty_TextField.setName("kdtEggEntries_psEggQty_TextField");
        kdtEggEntries_psEggQty_TextField.setVisible(true);
        kdtEggEntries_psEggQty_TextField.setEditable(true);
        kdtEggEntries_psEggQty_TextField.setHorizontalAlignment(2);
        kdtEggEntries_psEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntries_psEggQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_psEggQty_TextField);
        this.kdtEggEntries.getColumn("psEggQty").setEditor(kdtEggEntries_psEggQty_CellEditor);
        KDFormattedTextField kdtEggEntries_healthEggQty_TextField = new KDFormattedTextField();
        kdtEggEntries_healthEggQty_TextField.setName("kdtEggEntries_healthEggQty_TextField");
        kdtEggEntries_healthEggQty_TextField.setVisible(true);
        kdtEggEntries_healthEggQty_TextField.setEditable(true);
        kdtEggEntries_healthEggQty_TextField.setHorizontalAlignment(2);
        kdtEggEntries_healthEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntries_healthEggQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_healthEggQty_TextField);
        this.kdtEggEntries.getColumn("healthEggQty").setEditor(kdtEggEntries_healthEggQty_CellEditor);
        KDFormattedTextField kdtEggEntries_addleEggQty_TextField = new KDFormattedTextField();
        kdtEggEntries_addleEggQty_TextField.setName("kdtEggEntries_addleEggQty_TextField");
        kdtEggEntries_addleEggQty_TextField.setVisible(true);
        kdtEggEntries_addleEggQty_TextField.setEditable(true);
        kdtEggEntries_addleEggQty_TextField.setHorizontalAlignment(2);
        kdtEggEntries_addleEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntries_addleEggQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_addleEggQty_TextField);
        this.kdtEggEntries.getColumn("addleEggQty").setEditor(kdtEggEntries_addleEggQty_CellEditor);
        KDFormattedTextField kdtEggEntries_trayingWeight_TextField = new KDFormattedTextField();
        kdtEggEntries_trayingWeight_TextField.setName("kdtEggEntries_trayingWeight_TextField");
        kdtEggEntries_trayingWeight_TextField.setVisible(true);
        kdtEggEntries_trayingWeight_TextField.setEditable(true);
        kdtEggEntries_trayingWeight_TextField.setHorizontalAlignment(2);
        kdtEggEntries_trayingWeight_TextField.setDataType(1);
        	kdtEggEntries_trayingWeight_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEggEntries_trayingWeight_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEggEntries_trayingWeight_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEggEntries_trayingWeight_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_trayingWeight_TextField);
        this.kdtEggEntries.getColumn("trayingWeight").setEditor(kdtEggEntries_trayingWeight_CellEditor);
        KDFormattedTextField kdtEggEntries_otherEggQty_TextField = new KDFormattedTextField();
        kdtEggEntries_otherEggQty_TextField.setName("kdtEggEntries_otherEggQty_TextField");
        kdtEggEntries_otherEggQty_TextField.setVisible(true);
        kdtEggEntries_otherEggQty_TextField.setEditable(true);
        kdtEggEntries_otherEggQty_TextField.setHorizontalAlignment(2);
        kdtEggEntries_otherEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntries_otherEggQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_otherEggQty_TextField);
        this.kdtEggEntries.getColumn("otherEggQty").setEditor(kdtEggEntries_otherEggQty_CellEditor);
        KDFormattedTextField kdtEggEntries_allFertilityRate_TextField = new KDFormattedTextField();
        kdtEggEntries_allFertilityRate_TextField.setName("kdtEggEntries_allFertilityRate_TextField");
        kdtEggEntries_allFertilityRate_TextField.setVisible(true);
        kdtEggEntries_allFertilityRate_TextField.setEditable(true);
        kdtEggEntries_allFertilityRate_TextField.setHorizontalAlignment(2);
        kdtEggEntries_allFertilityRate_TextField.setDataType(1);
        	kdtEggEntries_allFertilityRate_TextField.setMinimumValue(new java.math.BigDecimal("-999.999"));
        	kdtEggEntries_allFertilityRate_TextField.setMaximumValue(new java.math.BigDecimal("999.999"));
        kdtEggEntries_allFertilityRate_TextField.setPrecision(3);
        KDTDefaultCellEditor kdtEggEntries_allFertilityRate_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_allFertilityRate_TextField);
        this.kdtEggEntries.getColumn("allFertilityRate").setEditor(kdtEggEntries_allFertilityRate_CellEditor);
        // txtallHatchEggQty		
        this.txtallHatchEggQty.setHorizontalAlignment(2);		
        this.txtallHatchEggQty.setDataType(0);		
        this.txtallHatchEggQty.setSupportedEmpty(true);		
        this.txtallHatchEggQty.setRequired(false);		
        this.txtallHatchEggQty.setEnabled(false);
        // prmtoperator		
        this.prmtoperator.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtoperator.setEditable(true);		
        this.prmtoperator.setDisplayFormat("$name$");		
        this.prmtoperator.setEditFormat("$number$");		
        this.prmtoperator.setCommitFormat("$number$");		
        this.prmtoperator.setRequired(false);
        // txtallHealthEggQty		
        this.txtallHealthEggQty.setHorizontalAlignment(2);		
        this.txtallHealthEggQty.setDataType(0);		
        this.txtallHealthEggQty.setSupportedEmpty(true);		
        this.txtallHealthEggQty.setRequired(false);		
        this.txtallHealthEggQty.setEnabled(false);
        // prmthatchArea		
        this.prmthatchArea.setQueryInfo("com.kingdee.eas.farm.hatch.app.HatchAreaQuery");		
        this.prmthatchArea.setEditable(true);		
        this.prmthatchArea.setDisplayFormat("$name$");		
        this.prmthatchArea.setEditFormat("$number$");		
        this.prmthatchArea.setCommitFormat("$number$");		
        this.prmthatchArea.setRequired(false);		
        this.prmthatchArea.setVisible(false);
        // prmtincubator		
        this.prmtincubator.setQueryInfo("com.kingdee.eas.farm.hatch.app.IncubatorQuery");		
        this.prmtincubator.setEditable(true);		
        this.prmtincubator.setDisplayFormat("$name$");		
        this.prmtincubator.setEditFormat("$number$");		
        this.prmtincubator.setCommitFormat("$number$");		
        this.prmtincubator.setRequired(false);		
        this.prmtincubator.setEnabled(false);
        		prmtincubator.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.IncubatorListUI prmtincubator_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtincubator_F7ListUI == null) {
					try {
						prmtincubator_F7ListUI = new com.kingdee.eas.farm.hatch.client.IncubatorListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtincubator_F7ListUI));
					prmtincubator_F7ListUI.setF7Use(true,ctx);
					prmtincubator.setSelector(prmtincubator_F7ListUI);
				}
			}
		});
					
        // txtotherLoss		
        this.txtotherLoss.setHorizontalAlignment(2);		
        this.txtotherLoss.setDataType(0);		
        this.txtotherLoss.setSupportedEmpty(true);		
        this.txtotherLoss.setRequired(false);		
        this.txtotherLoss.setEnabled(false);
        // txtallAddleEggQty		
        this.txtallAddleEggQty.setHorizontalAlignment(2);		
        this.txtallAddleEggQty.setDataType(0);		
        this.txtallAddleEggQty.setSupportedEmpty(true);		
        this.txtallAddleEggQty.setRequired(false);		
        this.txtallAddleEggQty.setEnabled(false);
        // txtallCandlingHealthEggQty		
        this.txtallCandlingHealthEggQty.setHorizontalAlignment(2);		
        this.txtallCandlingHealthEggQty.setDataType(0);		
        this.txtallCandlingHealthEggQty.setSupportedEmpty(true);		
        this.txtallCandlingHealthEggQty.setRequired(false);		
        this.txtallCandlingHealthEggQty.setEnabled(false);
        // pkhatchDate		
        this.pkhatchDate.setRequired(false);		
        this.pkhatchDate.setEnabled(false);
        // pkeggCandling		
        this.pkeggCandling.setRequired(false);		
        this.pkeggCandling.setEnabled(false);
        // eggType		
        this.eggType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.hatch.EggType").toArray());		
        this.eggType.setRequired(false);		
        this.eggType.setEnabled(false);
        // prmtadjustBill		
        this.prmtadjustBill.setQueryInfo("com.kingdee.eas.farm.hatch.app.BEggTrayingBillQuery");		
        this.prmtadjustBill.setEditable(true);		
        this.prmtadjustBill.setDisplayFormat("$number$");		
        this.prmtadjustBill.setEditFormat("$number$");		
        this.prmtadjustBill.setCommitFormat("$number$");		
        this.prmtadjustBill.setRequired(false);
        // grentTy		
        this.grentTy.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.hatch.GenderType").toArray());		
        this.grentTy.setRequired(false);		
        this.grentTy.setEnabled(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        // btnAdjust
        this.btnAdjust.setAction((IItemAction)ActionProxyFactory.getProxy(actionAdjust, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAdjust.setText(resHelper.getString("btnAdjust.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {pkauditTime,baseStatus,prmthatchFactory,txtallHatchEggQty,prmtoperator,txtallHealthEggQty,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,prmthatchArea,prmtincubator,txtotherLoss,txtallAddleEggQty,txtallCandlingHealthEggQty,pkhatchDate,pkeggCandling,eggType,prmtadjustBill,grentTy,kdtEggEntries,kdtTransBoxEntries}));
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
        this.setBounds(new Rectangle(1, 0, 1013, 629));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(1, 0, 1013, 629));
        contCreator.setBounds(new Rectangle(373, 573, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(373, 573, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(373, 598, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(373, 598, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(725, 573, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(725, 573, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateTime.setBounds(new Rectangle(725, 598, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(725, 598, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(18, 17, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(18, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(371, 41, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(371, 41, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(719, 117, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(719, 117, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(21, 573, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(21, 573, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(21, 598, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(21, 598, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbaseStatus.setBounds(new Rectangle(719, 41, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(719, 41, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conthatchFactory.setBounds(new Rectangle(371, 17, 270, 19));
        this.add(conthatchFactory, new KDLayout.Constraints(371, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane2.setBounds(new Rectangle(15, 179, 985, 237));
        this.add(kDTabbedPane2, new KDLayout.Constraints(15, 179, 985, 237, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contallHatchEggQty.setBounds(new Rectangle(18, 65, 270, 19));
        this.add(contallHatchEggQty, new KDLayout.Constraints(18, 65, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoperator.setBounds(new Rectangle(719, 17, 270, 19));
        this.add(contoperator, new KDLayout.Constraints(719, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contallHealthEggQty.setBounds(new Rectangle(371, 89, 270, 19));
        this.add(contallHealthEggQty, new KDLayout.Constraints(371, 89, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conthatchArea.setBounds(new Rectangle(370, 156, 270, 19));
        this.add(conthatchArea, new KDLayout.Constraints(370, 156, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contincubator.setBounds(new Rectangle(839, 155, 270, 19));
        this.add(contincubator, new KDLayout.Constraints(839, 155, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contotherLoss.setBounds(new Rectangle(18, 114, 270, 19));
        this.add(contotherLoss, new KDLayout.Constraints(18, 114, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contallAddleEggQty.setBounds(new Rectangle(18, 89, 270, 19));
        this.add(contallAddleEggQty, new KDLayout.Constraints(18, 89, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contallCandlingHealthEggQty.setBounds(new Rectangle(371, 65, 270, 19));
        this.add(contallCandlingHealthEggQty, new KDLayout.Constraints(371, 65, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtTransBoxEntries.setBounds(new Rectangle(17, 426, 983, 137));
        kdtTransBoxEntries_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtTransBoxEntries,new com.kingdee.eas.farm.hatch.BEggTrayingBillTransBoxEntryInfo(),null,false);
        this.add(kdtTransBoxEntries_detailPanel, new KDLayout.Constraints(17, 426, 983, 137, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        conthatchDate.setBounds(new Rectangle(372, 117, 270, 19));
        this.add(conthatchDate, new KDLayout.Constraints(372, 117, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conteggCandling.setBounds(new Rectangle(719, 65, 270, 19));
        this.add(conteggCandling, new KDLayout.Constraints(719, 65, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conteggType.setBounds(new Rectangle(18, 40, 270, 19));
        this.add(conteggType, new KDLayout.Constraints(18, 40, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contadjustBill.setBounds(new Rectangle(847, 138, 270, 19));
        this.add(contadjustBill, new KDLayout.Constraints(847, 138, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contgrentTy.setBounds(new Rectangle(17, 143, 270, 19));
        this.add(contgrentTy, new KDLayout.Constraints(17, 143, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //conthatchFactory
        conthatchFactory.setBoundEditor(prmthatchFactory);
        //kDTabbedPane2
        kDTabbedPane2.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 984, 204));        kdtEggEntries.setBounds(new Rectangle(1, -1, 978, 207));
        kdtEggEntries_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEggEntries,new com.kingdee.eas.farm.hatch.BEggTrayingBillEggEntryInfo(),null,false);
        kDPanel2.add(kdtEggEntries_detailPanel, new KDLayout.Constraints(1, -1, 978, 207, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtEggEntries_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("eggSourceType",new Integer(1));
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //contallHatchEggQty
        contallHatchEggQty.setBoundEditor(txtallHatchEggQty);
        //contoperator
        contoperator.setBoundEditor(prmtoperator);
        //contallHealthEggQty
        contallHealthEggQty.setBoundEditor(txtallHealthEggQty);
        //conthatchArea
        conthatchArea.setBoundEditor(prmthatchArea);
        //contincubator
        contincubator.setBoundEditor(prmtincubator);
        //contotherLoss
        contotherLoss.setBoundEditor(txtotherLoss);
        //contallAddleEggQty
        contallAddleEggQty.setBoundEditor(txtallAddleEggQty);
        //contallCandlingHealthEggQty
        contallCandlingHealthEggQty.setBoundEditor(txtallCandlingHealthEggQty);
        //conthatchDate
        conthatchDate.setBoundEditor(pkhatchDate);
        //conteggCandling
        conteggCandling.setBoundEditor(pkeggCandling);
        //conteggType
        conteggType.setBoundEditor(eggType);
        //contadjustBill
        contadjustBill.setBoundEditor(prmtadjustBill);
        //contgrentTy
        contgrentTy.setBoundEditor(grentTy);

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
        this.toolBar.add(btnAdjust);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("TransBoxEntries.seq", int.class, this.kdtTransBoxEntries, "seq.text");
		dataBinder.registerBinding("TransBoxEntries", com.kingdee.eas.farm.hatch.BEggTrayingBillTransBoxEntryInfo.class, this.kdtTransBoxEntries, "userObject");
		dataBinder.registerBinding("TransBoxEntries.hatchingBox", java.lang.Object.class, this.kdtTransBoxEntries, "hatchingBox.text");
		dataBinder.registerBinding("TransBoxEntries.inQty", int.class, this.kdtTransBoxEntries, "inQty.text");
		dataBinder.registerBinding("TransBoxEntries.description", String.class, this.kdtTransBoxEntries, "description.text");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("hatchFactory", com.kingdee.eas.farm.hatch.HatchBaseDataInfo.class, this.prmthatchFactory, "data");
		dataBinder.registerBinding("EggEntries.seq", int.class, this.kdtEggEntries, "seq.text");
		dataBinder.registerBinding("EggEntries", com.kingdee.eas.farm.hatch.BEggTrayingBillEggEntryInfo.class, this.kdtEggEntries, "userObject");
		dataBinder.registerBinding("EggEntries.eggSourceType", com.kingdee.util.enums.Enum.class, this.kdtEggEntries, "eggSourceType.text");
		dataBinder.registerBinding("EggEntries.eggLog", String.class, this.kdtEggEntries, "eggLog.text");
		dataBinder.registerBinding("EggEntries.eggQty", int.class, this.kdtEggEntries, "eggQty.text");
		dataBinder.registerBinding("EggEntries.addleEggQty", int.class, this.kdtEggEntries, "addleEggQty.text");
		dataBinder.registerBinding("EggEntries.healthEggQty", int.class, this.kdtEggEntries, "healthEggQty.text");
		dataBinder.registerBinding("EggEntries.otherEggQty", int.class, this.kdtEggEntries, "otherEggQty.text");
		dataBinder.registerBinding("EggEntries.candingHealthEggQty", int.class, this.kdtEggEntries, "candingHealthEggQty.text");
		dataBinder.registerBinding("EggEntries.trayingWeight", java.math.BigDecimal.class, this.kdtEggEntries, "trayingWeight.text");
		dataBinder.registerBinding("EggEntries.hatchBox", java.lang.Object.class, this.kdtEggEntries, "hatchBox.text");
		dataBinder.registerBinding("EggEntries.outBabyBox", java.lang.Object.class, this.kdtEggEntries, "outBabyBox.text");
		dataBinder.registerBinding("EggEntries.outBabyHouse", java.lang.Object.class, this.kdtEggEntries, "outBabyHouse.text");
		dataBinder.registerBinding("EggEntries.inBabyHouse", java.lang.Object.class, this.kdtEggEntries, "inBabyHouse.text");
		dataBinder.registerBinding("EggEntries.isMix", boolean.class, this.kdtEggEntries, "isMix.text");
		dataBinder.registerBinding("EggEntries.outArea", java.lang.Object.class, this.kdtEggEntries, "outArea.text");
		dataBinder.registerBinding("EggEntries.supplier", java.lang.Object.class, this.kdtEggEntries, "supplier.text");
		dataBinder.registerBinding("EggEntries.outHouse", java.lang.Object.class, this.kdtEggEntries, "outHouse.text");
		dataBinder.registerBinding("EggEntries.eggType", com.kingdee.util.enums.Enum.class, this.kdtEggEntries, "eggType.text");
		dataBinder.registerBinding("EggEntries.sunBadEggQty", int.class, this.kdtEggEntries, "sunBadEggQty.text");
		dataBinder.registerBinding("EggEntries.trayingSadEggQty", int.class, this.kdtEggEntries, "trayingSadEggQty.text");
		dataBinder.registerBinding("EggEntries.healthTrayingEggQty", int.class, this.kdtEggEntries, "healthTrayingEggQty.text");
		dataBinder.registerBinding("EggEntries.candlingFertiRate", java.math.BigDecimal.class, this.kdtEggEntries, "candlingFertiRate.text");
		dataBinder.registerBinding("EggEntries.outBatch", java.lang.Object.class, this.kdtEggEntries, "outBatch.text");
		dataBinder.registerBinding("EggEntries.genderType", com.kingdee.util.enums.Enum.class, this.kdtEggEntries, "genderType.text");
		dataBinder.registerBinding("EggEntries.ishunhe", boolean.class, this.kdtEggEntries, "ishunhe.text");
		dataBinder.registerBinding("EggEntries.psEggQty", int.class, this.kdtEggEntries, "psEggQty.text");
		dataBinder.registerBinding("EggEntries.hatchCarNum", String.class, this.kdtEggEntries, "hatchCarNum.text");
		dataBinder.registerBinding("EggEntries.allFertilityRate", java.math.BigDecimal.class, this.kdtEggEntries, "allFertilityRate.text");
		dataBinder.registerBinding("EggEntries.CostObject", java.lang.Object.class, this.kdtEggEntries, "CostObject.text");
		dataBinder.registerBinding("EggEntries.farmer", java.lang.Object.class, this.kdtEggEntries, "farmer.text");
		dataBinder.registerBinding("EggEntries.farm", java.lang.Object.class, this.kdtEggEntries, "farm.text");
		dataBinder.registerBinding("allHatchEggQty", int.class, this.txtallHatchEggQty, "value");
		dataBinder.registerBinding("operator", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtoperator, "data");
		dataBinder.registerBinding("allHealthEggQty", int.class, this.txtallHealthEggQty, "value");
		dataBinder.registerBinding("hatchArea", com.kingdee.eas.farm.hatch.HatchAreaInfo.class, this.prmthatchArea, "data");
		dataBinder.registerBinding("incubator", com.kingdee.eas.farm.hatch.IncubatorInfo.class, this.prmtincubator, "data");
		dataBinder.registerBinding("otherLoss", int.class, this.txtotherLoss, "value");
		dataBinder.registerBinding("allAddleEggQty", int.class, this.txtallAddleEggQty, "value");
		dataBinder.registerBinding("allCandlingHealthEggQty", int.class, this.txtallCandlingHealthEggQty, "value");
		dataBinder.registerBinding("hatchDate", java.util.Date.class, this.pkhatchDate, "value");
		dataBinder.registerBinding("eggCandling", java.util.Date.class, this.pkeggCandling, "value");
		dataBinder.registerBinding("eggType", com.kingdee.eas.farm.hatch.EggType.class, this.eggType, "selectedItem");
		dataBinder.registerBinding("adjustBill", com.kingdee.eas.farm.hatch.BEggTrayingBillInfo.class, this.prmtadjustBill, "data");
		dataBinder.registerBinding("grentTy", com.kingdee.eas.farm.stocking.hatch.GenderType.class, this.grentTy, "selectedItem");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.hatch.app.BEggTrayingBillEditUIHandler";
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
        this.pkauditTime.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.hatch.BEggTrayingBillInfo)ov;
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
		getValidateHelper().registerBindProperty("TransBoxEntries.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransBoxEntries", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransBoxEntries.hatchingBox", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransBoxEntries.inQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransBoxEntries.description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hatchFactory", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.eggSourceType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.eggLog", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.eggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.addleEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.healthEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.otherEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.candingHealthEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.trayingWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.hatchBox", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.outBabyBox", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.outBabyHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.inBabyHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.isMix", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.outArea", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.supplier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.outHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.eggType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.sunBadEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.trayingSadEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.healthTrayingEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.candlingFertiRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.outBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.genderType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.ishunhe", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.psEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.hatchCarNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.allFertilityRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.CostObject", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allHatchEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("operator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allHealthEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hatchArea", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("incubator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("otherLoss", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allAddleEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allCandlingHealthEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hatchDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eggCandling", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eggType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("adjustBill", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("grentTy", ValidateHelper.ON_SAVE);    		
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
     * output getSelectors method
     */
    public SelectorItemCollection getSelectors()
    {
        SelectorItemCollection sic = new SelectorItemCollection();
		String selectorAll = System.getProperty("selector.all");
		if(StringUtils.isEmpty(selectorAll)){
			selectorAll = "true";
		}
    	sic.add(new SelectorItemInfo("TransBoxEntries.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransBoxEntries.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransBoxEntries.hatchingBox.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("TransBoxEntries.hatchingBox.id"));
			sic.add(new SelectorItemInfo("TransBoxEntries.hatchingBox.name"));
        	sic.add(new SelectorItemInfo("TransBoxEntries.hatchingBox.number"));
		}
    	sic.add(new SelectorItemInfo("TransBoxEntries.inQty"));
    	sic.add(new SelectorItemInfo("TransBoxEntries.description"));
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
        sic.add(new SelectorItemInfo("auditTime"));
        sic.add(new SelectorItemInfo("baseStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("hatchFactory.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("hatchFactory.id"));
        	sic.add(new SelectorItemInfo("hatchFactory.number"));
        	sic.add(new SelectorItemInfo("hatchFactory.name"));
		}
    	sic.add(new SelectorItemInfo("EggEntries.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntries.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("EggEntries.eggSourceType"));
    	sic.add(new SelectorItemInfo("EggEntries.eggLog"));
    	sic.add(new SelectorItemInfo("EggEntries.eggQty"));
    	sic.add(new SelectorItemInfo("EggEntries.addleEggQty"));
    	sic.add(new SelectorItemInfo("EggEntries.healthEggQty"));
    	sic.add(new SelectorItemInfo("EggEntries.otherEggQty"));
    	sic.add(new SelectorItemInfo("EggEntries.candingHealthEggQty"));
    	sic.add(new SelectorItemInfo("EggEntries.trayingWeight"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntries.hatchBox.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntries.hatchBox.id"));
			sic.add(new SelectorItemInfo("EggEntries.hatchBox.name"));
        	sic.add(new SelectorItemInfo("EggEntries.hatchBox.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntries.outBabyBox.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntries.outBabyBox.id"));
			sic.add(new SelectorItemInfo("EggEntries.outBabyBox.name"));
        	sic.add(new SelectorItemInfo("EggEntries.outBabyBox.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntries.outBabyHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntries.outBabyHouse.id"));
			sic.add(new SelectorItemInfo("EggEntries.outBabyHouse.name"));
        	sic.add(new SelectorItemInfo("EggEntries.outBabyHouse.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntries.inBabyHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntries.inBabyHouse.id"));
			sic.add(new SelectorItemInfo("EggEntries.inBabyHouse.name"));
        	sic.add(new SelectorItemInfo("EggEntries.inBabyHouse.number"));
		}
    	sic.add(new SelectorItemInfo("EggEntries.isMix"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntries.outArea.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntries.outArea.id"));
			sic.add(new SelectorItemInfo("EggEntries.outArea.name"));
        	sic.add(new SelectorItemInfo("EggEntries.outArea.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntries.supplier.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntries.supplier.id"));
			sic.add(new SelectorItemInfo("EggEntries.supplier.name"));
        	sic.add(new SelectorItemInfo("EggEntries.supplier.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntries.outHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntries.outHouse.id"));
			sic.add(new SelectorItemInfo("EggEntries.outHouse.name"));
        	sic.add(new SelectorItemInfo("EggEntries.outHouse.number"));
		}
    	sic.add(new SelectorItemInfo("EggEntries.eggType"));
    	sic.add(new SelectorItemInfo("EggEntries.sunBadEggQty"));
    	sic.add(new SelectorItemInfo("EggEntries.trayingSadEggQty"));
    	sic.add(new SelectorItemInfo("EggEntries.healthTrayingEggQty"));
    	sic.add(new SelectorItemInfo("EggEntries.candlingFertiRate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntries.outBatch.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntries.outBatch.id"));
			sic.add(new SelectorItemInfo("EggEntries.outBatch.name"));
        	sic.add(new SelectorItemInfo("EggEntries.outBatch.number"));
		}
    	sic.add(new SelectorItemInfo("EggEntries.genderType"));
    	sic.add(new SelectorItemInfo("EggEntries.ishunhe"));
    	sic.add(new SelectorItemInfo("EggEntries.psEggQty"));
    	sic.add(new SelectorItemInfo("EggEntries.hatchCarNum"));
    	sic.add(new SelectorItemInfo("EggEntries.allFertilityRate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntries.CostObject.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntries.CostObject.id"));
			sic.add(new SelectorItemInfo("EggEntries.CostObject.name"));
        	sic.add(new SelectorItemInfo("EggEntries.CostObject.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntries.farmer.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntries.farmer.id"));
			sic.add(new SelectorItemInfo("EggEntries.farmer.name"));
        	sic.add(new SelectorItemInfo("EggEntries.farmer.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntries.farm.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntries.farm.id"));
			sic.add(new SelectorItemInfo("EggEntries.farm.name"));
        	sic.add(new SelectorItemInfo("EggEntries.farm.number"));
		}
        sic.add(new SelectorItemInfo("allHatchEggQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("operator.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("operator.id"));
        	sic.add(new SelectorItemInfo("operator.number"));
        	sic.add(new SelectorItemInfo("operator.name"));
		}
        sic.add(new SelectorItemInfo("allHealthEggQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("hatchArea.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("hatchArea.id"));
        	sic.add(new SelectorItemInfo("hatchArea.number"));
        	sic.add(new SelectorItemInfo("hatchArea.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("incubator.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("incubator.id"));
        	sic.add(new SelectorItemInfo("incubator.number"));
        	sic.add(new SelectorItemInfo("incubator.name"));
		}
        sic.add(new SelectorItemInfo("otherLoss"));
        sic.add(new SelectorItemInfo("allAddleEggQty"));
        sic.add(new SelectorItemInfo("allCandlingHealthEggQty"));
        sic.add(new SelectorItemInfo("hatchDate"));
        sic.add(new SelectorItemInfo("eggCandling"));
        sic.add(new SelectorItemInfo("eggType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("adjustBill.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("adjustBill.id"));
        	sic.add(new SelectorItemInfo("adjustBill.number"));
		}
        sic.add(new SelectorItemInfo("grentTy"));
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
        com.kingdee.eas.farm.hatch.BEggTrayingBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.hatch.BEggTrayingBillFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionAdjust_actionPerformed method
     */
    public void actionAdjust_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.hatch.BEggTrayingBillFactory.getRemoteInstance().adjust(editData);
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
	public RequestContext prepareActionAdjust(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAdjust() {
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
            innerActionPerformed("eas", AbstractBEggTrayingBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractBEggTrayingBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionAdjust class
     */     
    protected class ActionAdjust extends ItemAction {     
    
        public ActionAdjust()
        {
            this(null);
        }

        public ActionAdjust(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionAdjust.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAdjust.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAdjust.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractBEggTrayingBillEditUI.this, "ActionAdjust", "actionAdjust_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.hatch.client", "BEggTrayingBillEditUI");
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
        return com.kingdee.eas.farm.hatch.client.BEggTrayingBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.hatch.BEggTrayingBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.hatch.BEggTrayingBillInfo objectValue = new com.kingdee.eas.farm.hatch.BEggTrayingBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/hatch/BEggTrayingBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.hatch.app.BEggTrayingBillQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		for (int i=0,n=kdtEggEntries.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEggEntries.getCell(i,"genderType").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"品系类别"});
			}
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtEggEntries;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("baseStatus",new Integer(-1));
vo.put("eggType","Parent");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}