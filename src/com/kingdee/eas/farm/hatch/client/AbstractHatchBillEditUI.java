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
public abstract class AbstractHatchBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractHatchBillEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthatchDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstorageOrg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteggStoOrg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteggConveyor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteggBatch;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbabyChickBatch;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedBatch;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchikenBatch;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmteggStoOrg;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmteggConveyor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmteggBatch;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbabyChickBatch;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbreedBatch;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtchikenBatch;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteggQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthatchTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continvubatorBox;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txteggQty;
    protected com.kingdee.bos.ctrl.swing.KDTimePicker hatchTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperson;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtinvubatorBox;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane scrollPanehatchDescription;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txthatchDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstorageOrg;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.farm.hatch.HatchBillInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractHatchBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractHatchBillEditUI.class.getName());
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
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.conthatchDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstorageOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.conteggStoOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteggConveyor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteggBatch = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbabyChickBatch = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbreedBatch = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchikenBatch = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmteggStoOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmteggConveyor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmteggBatch = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbabyChickBatch = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbreedBatch = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtchikenBatch = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteggQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthatchTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continvubatorBox = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txteggQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.hatchTime = new com.kingdee.bos.ctrl.swing.KDTimePicker();
        this.prmtperson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtinvubatorBox = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.scrollPanehatchDescription = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txthatchDescription = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.prmtstorageOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.contauditTime.setName("contauditTime");
        this.contbaseStatus.setName("contbaseStatus");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.conthatchDescription.setName("conthatchDescription");
        this.contstorageOrg.setName("contstorageOrg");
        this.contcompany.setName("contcompany");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.pkauditTime.setName("pkauditTime");
        this.baseStatus.setName("baseStatus");
        this.conteggStoOrg.setName("conteggStoOrg");
        this.conteggConveyor.setName("conteggConveyor");
        this.conteggBatch.setName("conteggBatch");
        this.contbabyChickBatch.setName("contbabyChickBatch");
        this.contbreedBatch.setName("contbreedBatch");
        this.contchikenBatch.setName("contchikenBatch");
        this.prmteggStoOrg.setName("prmteggStoOrg");
        this.prmteggConveyor.setName("prmteggConveyor");
        this.prmteggBatch.setName("prmteggBatch");
        this.prmtbabyChickBatch.setName("prmtbabyChickBatch");
        this.prmtbreedBatch.setName("prmtbreedBatch");
        this.txtchikenBatch.setName("txtchikenBatch");
        this.contBizDate.setName("contBizDate");
        this.conteggQty.setName("conteggQty");
        this.conthatchTime.setName("conthatchTime");
        this.contperson.setName("contperson");
        this.continvubatorBox.setName("continvubatorBox");
        this.pkBizDate.setName("pkBizDate");
        this.txteggQty.setName("txteggQty");
        this.hatchTime.setName("hatchTime");
        this.prmtperson.setName("prmtperson");
        this.prmtinvubatorBox.setName("prmtinvubatorBox");
        this.scrollPanehatchDescription.setName("scrollPanehatchDescription");
        this.txthatchDescription.setName("txthatchDescription");
        this.prmtstorageOrg.setName("prmtstorageOrg");
        this.prmtcompany.setName("prmtcompany");
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
        this.contNumber.setBoundLabelLength(100);		
        this.contNumber.setBoundLabelUnderline(true);
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
        // kDPanel1		
        this.kDPanel1.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel1.border.title")));
        // kDPanel2		
        this.kDPanel2.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel2.border.title")));
        // conthatchDescription		
        this.conthatchDescription.setBoundLabelText(resHelper.getString("conthatchDescription.boundLabelText"));		
        this.conthatchDescription.setBoundLabelLength(100);		
        this.conthatchDescription.setBoundLabelUnderline(true);		
        this.conthatchDescription.setVisible(true);
        // contstorageOrg		
        this.contstorageOrg.setBoundLabelText(resHelper.getString("contstorageOrg.boundLabelText"));		
        this.contstorageOrg.setBoundLabelLength(100);		
        this.contstorageOrg.setBoundLabelUnderline(true);		
        this.contstorageOrg.setVisible(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
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
        this.txtNumber.setRequired(true);
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // pkauditTime		
        this.pkauditTime.setVisible(true);		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // baseStatus		
        this.baseStatus.setVisible(true);		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(true);		
        this.baseStatus.setEnabled(false);
        // conteggStoOrg		
        this.conteggStoOrg.setBoundLabelText(resHelper.getString("conteggStoOrg.boundLabelText"));		
        this.conteggStoOrg.setBoundLabelLength(100);		
        this.conteggStoOrg.setBoundLabelUnderline(true);		
        this.conteggStoOrg.setVisible(true);
        // conteggConveyor		
        this.conteggConveyor.setBoundLabelText(resHelper.getString("conteggConveyor.boundLabelText"));		
        this.conteggConveyor.setBoundLabelLength(100);		
        this.conteggConveyor.setBoundLabelUnderline(true);		
        this.conteggConveyor.setVisible(true);
        // conteggBatch		
        this.conteggBatch.setBoundLabelText(resHelper.getString("conteggBatch.boundLabelText"));		
        this.conteggBatch.setBoundLabelLength(100);		
        this.conteggBatch.setBoundLabelUnderline(true);		
        this.conteggBatch.setVisible(true);
        // contbabyChickBatch		
        this.contbabyChickBatch.setBoundLabelText(resHelper.getString("contbabyChickBatch.boundLabelText"));		
        this.contbabyChickBatch.setBoundLabelLength(100);		
        this.contbabyChickBatch.setBoundLabelUnderline(true);		
        this.contbabyChickBatch.setVisible(true);
        // contbreedBatch		
        this.contbreedBatch.setBoundLabelText(resHelper.getString("contbreedBatch.boundLabelText"));		
        this.contbreedBatch.setBoundLabelLength(100);		
        this.contbreedBatch.setBoundLabelUnderline(true);		
        this.contbreedBatch.setVisible(true);
        // contchikenBatch		
        this.contchikenBatch.setBoundLabelText(resHelper.getString("contchikenBatch.boundLabelText"));		
        this.contchikenBatch.setBoundLabelLength(100);		
        this.contchikenBatch.setBoundLabelUnderline(true);		
        this.contchikenBatch.setVisible(true);
        // prmteggStoOrg		
        this.prmteggStoOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmteggStoOrg.setVisible(true);		
        this.prmteggStoOrg.setEditable(true);		
        this.prmteggStoOrg.setDisplayFormat("$name$");		
        this.prmteggStoOrg.setEditFormat("$number$");		
        this.prmteggStoOrg.setCommitFormat("$number$");		
        this.prmteggStoOrg.setRequired(true);
        // prmteggConveyor		
        this.prmteggConveyor.setQueryInfo("com.kingdee.eas.farm.breed.layegg.app.EggConveyorQuery");		
        this.prmteggConveyor.setVisible(true);		
        this.prmteggConveyor.setEditable(true);		
        this.prmteggConveyor.setDisplayFormat("$name$");		
        this.prmteggConveyor.setEditFormat("$number$");		
        this.prmteggConveyor.setCommitFormat("$number$");		
        this.prmteggConveyor.setRequired(false);
        		prmteggConveyor.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.breed.layegg.client.EggConveyorListUI prmteggConveyor_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmteggConveyor_F7ListUI == null) {
					try {
						prmteggConveyor_F7ListUI = new com.kingdee.eas.farm.breed.layegg.client.EggConveyorListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmteggConveyor_F7ListUI));
					prmteggConveyor_F7ListUI.setF7Use(true,ctx);
					prmteggConveyor.setSelector(prmteggConveyor_F7ListUI);
				}
			}
		});
					
        // prmteggBatch		
        this.prmteggBatch.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");		
        this.prmteggBatch.setVisible(true);		
        this.prmteggBatch.setEditable(true);		
        this.prmteggBatch.setDisplayFormat("$name$");		
        this.prmteggBatch.setEditFormat("$number$");		
        this.prmteggBatch.setCommitFormat("$number$");		
        this.prmteggBatch.setRequired(false);
        // prmtbabyChickBatch		
        this.prmtbabyChickBatch.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");		
        this.prmtbabyChickBatch.setVisible(true);		
        this.prmtbabyChickBatch.setEditable(true);		
        this.prmtbabyChickBatch.setDisplayFormat("$name$");		
        this.prmtbabyChickBatch.setEditFormat("$number$");		
        this.prmtbabyChickBatch.setCommitFormat("$number$");		
        this.prmtbabyChickBatch.setRequired(false);
        // prmtbreedBatch		
        this.prmtbreedBatch.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");		
        this.prmtbreedBatch.setVisible(true);		
        this.prmtbreedBatch.setEditable(true);		
        this.prmtbreedBatch.setDisplayFormat("$batchNumber$");		
        this.prmtbreedBatch.setEditFormat("$number$");		
        this.prmtbreedBatch.setCommitFormat("$number$");		
        this.prmtbreedBatch.setRequired(false);
        // txtchikenBatch		
        this.txtchikenBatch.setVisible(true);		
        this.txtchikenBatch.setHorizontalAlignment(2);		
        this.txtchikenBatch.setMaxLength(100);		
        this.txtchikenBatch.setRequired(false);
        // contBizDate		
        this.contBizDate.setBoundLabelText(resHelper.getString("contBizDate.boundLabelText"));		
        this.contBizDate.setBoundLabelLength(100);		
        this.contBizDate.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelAlignment(7);		
        this.contBizDate.setVisible(true);
        // conteggQty		
        this.conteggQty.setBoundLabelText(resHelper.getString("conteggQty.boundLabelText"));		
        this.conteggQty.setBoundLabelLength(100);		
        this.conteggQty.setBoundLabelUnderline(true);		
        this.conteggQty.setVisible(true);
        // conthatchTime		
        this.conthatchTime.setBoundLabelText(resHelper.getString("conthatchTime.boundLabelText"));		
        this.conthatchTime.setBoundLabelLength(100);		
        this.conthatchTime.setBoundLabelUnderline(true);		
        this.conthatchTime.setVisible(true);
        // contperson		
        this.contperson.setBoundLabelText(resHelper.getString("contperson.boundLabelText"));		
        this.contperson.setBoundLabelLength(100);		
        this.contperson.setBoundLabelUnderline(true);		
        this.contperson.setVisible(true);
        // continvubatorBox		
        this.continvubatorBox.setBoundLabelText(resHelper.getString("continvubatorBox.boundLabelText"));		
        this.continvubatorBox.setBoundLabelLength(100);		
        this.continvubatorBox.setBoundLabelUnderline(true);		
        this.continvubatorBox.setVisible(true);
        // pkBizDate		
        this.pkBizDate.setVisible(true);		
        this.pkBizDate.setEnabled(true);		
        this.pkBizDate.setRequired(true);
        // txteggQty		
        this.txteggQty.setVisible(true);		
        this.txteggQty.setHorizontalAlignment(2);		
        this.txteggQty.setDataType(0);		
        this.txteggQty.setSupportedEmpty(true);		
        this.txteggQty.setRequired(true);
        // hatchTime		
        this.hatchTime.setVisible(true);
        // prmtperson		
        this.prmtperson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonFilterQuery");		
        this.prmtperson.setVisible(true);		
        this.prmtperson.setEditable(true);		
        this.prmtperson.setDisplayFormat("$name$");		
        this.prmtperson.setEditFormat("$number$");		
        this.prmtperson.setCommitFormat("$number$");		
        this.prmtperson.setRequired(false);
        // prmtinvubatorBox		
        this.prmtinvubatorBox.setQueryInfo("com.kingdee.eas.farm.hatch.app.IncubatorQuery");		
        this.prmtinvubatorBox.setVisible(true);		
        this.prmtinvubatorBox.setEditable(true);		
        this.prmtinvubatorBox.setDisplayFormat("$name$");		
        this.prmtinvubatorBox.setEditFormat("$number$");		
        this.prmtinvubatorBox.setCommitFormat("$number$");		
        this.prmtinvubatorBox.setRequired(false);
        		prmtinvubatorBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.IncubatorListUI prmtinvubatorBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtinvubatorBox_F7ListUI == null) {
					try {
						prmtinvubatorBox_F7ListUI = new com.kingdee.eas.farm.hatch.client.IncubatorListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtinvubatorBox_F7ListUI));
					prmtinvubatorBox_F7ListUI.setF7Use(true,ctx);
					prmtinvubatorBox.setSelector(prmtinvubatorBox_F7ListUI);
				}
			}
		});
					
        // scrollPanehatchDescription
        // txthatchDescription		
        this.txthatchDescription.setVisible(true);		
        this.txthatchDescription.setRequired(false);		
        this.txthatchDescription.setMaxLength(1000);
        // prmtstorageOrg		
        this.prmtstorageOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtstorageOrg.setVisible(true);		
        this.prmtstorageOrg.setEditable(true);		
        this.prmtstorageOrg.setDisplayFormat("$name$");		
        this.prmtstorageOrg.setEditFormat("$number$");		
        this.prmtstorageOrg.setCommitFormat("$number$");		
        this.prmtstorageOrg.setRequired(false);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setVisible(true);		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmteggStoOrg,prmteggBatch,prmtperson,prmteggConveyor,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,pkauditTime,baseStatus,txteggQty,prmtbabyChickBatch,hatchTime,txthatchDescription,prmtinvubatorBox,prmtstorageOrg,prmtcompany,prmtbreedBatch,txtchikenBatch}));
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
        this.setBounds(new Rectangle(0, 0, 660, 600));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 660, 600));
        contCreator.setBounds(new Rectangle(25, 517, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(25, 517, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(25, 549, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(25, 549, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(3, 575, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(3, 575, 270, 19, 0));
        contLastUpdateTime.setBounds(new Rectangle(300, 577, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(300, 577, 270, 19, 0));
        contNumber.setBounds(new Rectangle(28, 25, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(28, 25, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(21, -448, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(21, -448, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(351, 517, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(351, 517, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contauditTime.setBounds(new Rectangle(351, 547, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(351, 547, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbaseStatus.setBounds(new Rectangle(353, 25, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(353, 25, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDPanel1.setBounds(new Rectangle(12, 75, 633, 156));
        this.add(kDPanel1, new KDLayout.Constraints(12, 75, 633, 156, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDPanel2.setBounds(new Rectangle(12, 244, 633, 150));
        this.add(kDPanel2, new KDLayout.Constraints(12, 244, 633, 150, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        conthatchDescription.setBounds(new Rectangle(17, 408, 631, 98));
        this.add(conthatchDescription, new KDLayout.Constraints(17, 408, 631, 98, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contstorageOrg.setBounds(new Rectangle(0, -100, 270, 19));
        this.add(contstorageOrg, new KDLayout.Constraints(0, -100, 270, 19, 0));
        contcompany.setBounds(new Rectangle(0, -100, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(0, -100, 270, 19, 0));
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
        //contDescription
        contDescription.setBoundEditor(txtDescription);
        //contAuditor
        contAuditor.setBoundEditor(prmtAuditor);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(12, 75, 633, 156));        conteggStoOrg.setBounds(new Rectangle(29, 36, 270, 19));
        kDPanel1.add(conteggStoOrg, new KDLayout.Constraints(29, 36, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conteggConveyor.setBounds(new Rectangle(29, 72, 270, 19));
        kDPanel1.add(conteggConveyor, new KDLayout.Constraints(29, 72, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conteggBatch.setBounds(new Rectangle(29, 109, 270, 19));
        kDPanel1.add(conteggBatch, new KDLayout.Constraints(29, 109, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbabyChickBatch.setBounds(new Rectangle(338, 109, 270, 19));
        kDPanel1.add(contbabyChickBatch, new KDLayout.Constraints(338, 109, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbreedBatch.setBounds(new Rectangle(338, 36, 270, 19));
        kDPanel1.add(contbreedBatch, new KDLayout.Constraints(338, 36, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contchikenBatch.setBounds(new Rectangle(338, 72, 270, 19));
        kDPanel1.add(contchikenBatch, new KDLayout.Constraints(338, 72, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //conteggStoOrg
        conteggStoOrg.setBoundEditor(prmteggStoOrg);
        //conteggConveyor
        conteggConveyor.setBoundEditor(prmteggConveyor);
        //conteggBatch
        conteggBatch.setBoundEditor(prmteggBatch);
        //contbabyChickBatch
        contbabyChickBatch.setBoundEditor(prmtbabyChickBatch);
        //contbreedBatch
        contbreedBatch.setBoundEditor(prmtbreedBatch);
        //contchikenBatch
        contchikenBatch.setBoundEditor(txtchikenBatch);
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(12, 244, 633, 150));        contBizDate.setBounds(new Rectangle(29, 67, 270, 19));
        kDPanel2.add(contBizDate, new KDLayout.Constraints(29, 67, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conteggQty.setBounds(new Rectangle(340, 28, 270, 19));
        kDPanel2.add(conteggQty, new KDLayout.Constraints(340, 28, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conthatchTime.setBounds(new Rectangle(340, 67, 270, 19));
        kDPanel2.add(conthatchTime, new KDLayout.Constraints(340, 67, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contperson.setBounds(new Rectangle(29, 108, 270, 19));
        kDPanel2.add(contperson, new KDLayout.Constraints(29, 108, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        continvubatorBox.setBounds(new Rectangle(29, 28, 270, 19));
        kDPanel2.add(continvubatorBox, new KDLayout.Constraints(29, 28, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contBizDate
        contBizDate.setBoundEditor(pkBizDate);
        //conteggQty
        conteggQty.setBoundEditor(txteggQty);
        //conthatchTime
        conthatchTime.setBoundEditor(hatchTime);
        //contperson
        contperson.setBoundEditor(prmtperson);
        //continvubatorBox
        continvubatorBox.setBoundEditor(prmtinvubatorBox);
        //conthatchDescription
        conthatchDescription.setBoundEditor(scrollPanehatchDescription);
        //scrollPanehatchDescription
        scrollPanehatchDescription.getViewport().add(txthatchDescription, null);
        //contstorageOrg
        contstorageOrg.setBoundEditor(prmtstorageOrg);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);

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
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("eggStoOrg", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmteggStoOrg, "data");
		dataBinder.registerBinding("eggConveyor", com.kingdee.eas.farm.breed.layegg.EggConveyorInfo.class, this.prmteggConveyor, "data");
		dataBinder.registerBinding("eggBatch", com.kingdee.eas.basedata.assistant.CostObjectInfo.class, this.prmteggBatch, "data");
		dataBinder.registerBinding("babyChickBatch", com.kingdee.eas.basedata.assistant.CostObjectInfo.class, this.prmtbabyChickBatch, "data");
		dataBinder.registerBinding("breedBatch", com.kingdee.eas.basedata.assistant.CostObjectInfo.class, this.prmtbreedBatch, "data");
		dataBinder.registerBinding("chikenBatch", String.class, this.txtchikenBatch, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("eggQty", int.class, this.txteggQty, "value");
		dataBinder.registerBinding("hatchTime", java.sql.Time.class, this.hatchTime, "value");
		dataBinder.registerBinding("person", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtperson, "data");
		dataBinder.registerBinding("invubatorBox", com.kingdee.eas.farm.hatch.IncubatorInfo.class, this.prmtinvubatorBox, "data");
		dataBinder.registerBinding("hatchDescription", String.class, this.txthatchDescription, "text");
		dataBinder.registerBinding("storageOrg", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtstorageOrg, "data");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.hatch.app.HatchBillEditUIHandler";
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
        this.prmteggStoOrg.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.hatch.HatchBillInfo)ov;
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
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eggStoOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eggConveyor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eggBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("babyChickBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chikenBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hatchTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("person", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("invubatorBox", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hatchDescription", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("storageOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    		
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
			sic.add(new SelectorItemInfo("eggStoOrg.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("eggStoOrg.id"));
        	sic.add(new SelectorItemInfo("eggStoOrg.number"));
        	sic.add(new SelectorItemInfo("eggStoOrg.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("eggConveyor.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("eggConveyor.id"));
        	sic.add(new SelectorItemInfo("eggConveyor.number"));
        	sic.add(new SelectorItemInfo("eggConveyor.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("eggBatch.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("eggBatch.id"));
        	sic.add(new SelectorItemInfo("eggBatch.number"));
        	sic.add(new SelectorItemInfo("eggBatch.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("babyChickBatch.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("babyChickBatch.id"));
        	sic.add(new SelectorItemInfo("babyChickBatch.number"));
        	sic.add(new SelectorItemInfo("babyChickBatch.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("breedBatch.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("breedBatch.id"));
        	sic.add(new SelectorItemInfo("breedBatch.number"));
        	sic.add(new SelectorItemInfo("breedBatch.name"));
        	sic.add(new SelectorItemInfo("breedBatch.batchNumber"));
		}
        sic.add(new SelectorItemInfo("chikenBatch"));
        sic.add(new SelectorItemInfo("bizDate"));
        sic.add(new SelectorItemInfo("eggQty"));
        sic.add(new SelectorItemInfo("hatchTime"));
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
			sic.add(new SelectorItemInfo("invubatorBox.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("invubatorBox.id"));
        	sic.add(new SelectorItemInfo("invubatorBox.number"));
        	sic.add(new SelectorItemInfo("invubatorBox.name"));
		}
        sic.add(new SelectorItemInfo("hatchDescription"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("storageOrg.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("storageOrg.id"));
        	sic.add(new SelectorItemInfo("storageOrg.number"));
        	sic.add(new SelectorItemInfo("storageOrg.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
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
        com.kingdee.eas.farm.hatch.HatchBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.hatch.HatchBillFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractHatchBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractHatchBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.hatch.client", "HatchBillEditUI");
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
        return com.kingdee.eas.farm.hatch.client.HatchBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.hatch.HatchBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.hatch.HatchBillInfo objectValue = new com.kingdee.eas.farm.hatch.HatchBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/hatch/HatchBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.hatch.app.HatchBillQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtNumber.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"单据编号"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(baseStatus.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"状态"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmteggStoOrg.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"来源产蛋场"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txteggQty.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"上孵数量"});
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
		vo.put("baseStatus",new Integer(-1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}