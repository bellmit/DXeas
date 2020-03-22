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
public abstract class AbstractFeedBusinessDailyEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractFeedBusinessDailyEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthatchDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstoOrg;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel5;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane scrollPanehatchDescription;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txthatchDescription;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contentryQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contleaveQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contattendanceQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continitQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtentryQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtleaveQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtattendanceQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtinitQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstoOrg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsoybeanInventory;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contownInventory;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcornInventory;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsoybeanInventory;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtownInventory;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcornInventory;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contelecQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcoalQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contelecEnd;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contelecBegin;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtelecQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcoalQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtelecEnd;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtelecBegin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmotorcadeLeaveQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmotorcadeEntryQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmotorcadeAttendQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmotorcadeInitQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmotorcadeLeaveQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmotorcadeEntryQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmotorcadeAttendQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmotorcadeInitQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contproxyInventory;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contproxySoybeanInventory;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contproxyCornInventory;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtproxyInventory;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtproxySoybeanInventory;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtproxyCornInventory;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.farm.feedfactory.FeedBusinessDailyInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractFeedBusinessDailyEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractFeedBusinessDailyEditUI.class.getName());
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
        this.conthatchDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contstoOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel5 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.scrollPanehatchDescription = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txthatchDescription = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.contentryQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contleaveQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contattendanceQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continitQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtentryQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtleaveQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtattendanceQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtinitQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtstoOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.contsoybeanInventory = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contownInventory = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcornInventory = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtsoybeanInventory = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtownInventory = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcornInventory = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contelecQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcoalQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contelecEnd = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contelecBegin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtelecQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcoalQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtelecEnd = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtelecBegin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contmotorcadeLeaveQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmotorcadeEntryQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmotorcadeAttendQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmotorcadeInitQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtmotorcadeLeaveQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmotorcadeEntryQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmotorcadeAttendQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmotorcadeInitQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contproxyInventory = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contproxySoybeanInventory = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contproxyCornInventory = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtproxyInventory = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtproxySoybeanInventory = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtproxyCornInventory = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
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
        this.conthatchDescription.setName("conthatchDescription");
        this.contBizDate.setName("contBizDate");
        this.kDPanel3.setName("kDPanel3");
        this.contstoOrg.setName("contstoOrg");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel4.setName("kDPanel4");
        this.kDPanel5.setName("kDPanel5");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.pkauditTime.setName("pkauditTime");
        this.baseStatus.setName("baseStatus");
        this.scrollPanehatchDescription.setName("scrollPanehatchDescription");
        this.txthatchDescription.setName("txthatchDescription");
        this.pkBizDate.setName("pkBizDate");
        this.contentryQty.setName("contentryQty");
        this.contleaveQty.setName("contleaveQty");
        this.contattendanceQty.setName("contattendanceQty");
        this.continitQty.setName("continitQty");
        this.txtentryQty.setName("txtentryQty");
        this.txtleaveQty.setName("txtleaveQty");
        this.txtattendanceQty.setName("txtattendanceQty");
        this.txtinitQty.setName("txtinitQty");
        this.prmtstoOrg.setName("prmtstoOrg");
        this.contsoybeanInventory.setName("contsoybeanInventory");
        this.contownInventory.setName("contownInventory");
        this.contcornInventory.setName("contcornInventory");
        this.txtsoybeanInventory.setName("txtsoybeanInventory");
        this.txtownInventory.setName("txtownInventory");
        this.txtcornInventory.setName("txtcornInventory");
        this.contelecQty.setName("contelecQty");
        this.contcoalQty.setName("contcoalQty");
        this.contelecEnd.setName("contelecEnd");
        this.contelecBegin.setName("contelecBegin");
        this.txtelecQty.setName("txtelecQty");
        this.txtcoalQty.setName("txtcoalQty");
        this.txtelecEnd.setName("txtelecEnd");
        this.txtelecBegin.setName("txtelecBegin");
        this.contmotorcadeLeaveQty.setName("contmotorcadeLeaveQty");
        this.contmotorcadeEntryQty.setName("contmotorcadeEntryQty");
        this.contmotorcadeAttendQty.setName("contmotorcadeAttendQty");
        this.contmotorcadeInitQty.setName("contmotorcadeInitQty");
        this.txtmotorcadeLeaveQty.setName("txtmotorcadeLeaveQty");
        this.txtmotorcadeEntryQty.setName("txtmotorcadeEntryQty");
        this.txtmotorcadeAttendQty.setName("txtmotorcadeAttendQty");
        this.txtmotorcadeInitQty.setName("txtmotorcadeInitQty");
        this.contproxyInventory.setName("contproxyInventory");
        this.contproxySoybeanInventory.setName("contproxySoybeanInventory");
        this.contproxyCornInventory.setName("contproxyCornInventory");
        this.txtproxyInventory.setName("txtproxyInventory");
        this.txtproxySoybeanInventory.setName("txtproxySoybeanInventory");
        this.txtproxyCornInventory.setName("txtproxyCornInventory");
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
        // conthatchDescription		
        this.conthatchDescription.setBoundLabelText(resHelper.getString("conthatchDescription.boundLabelText"));		
        this.conthatchDescription.setBoundLabelLength(100);		
        this.conthatchDescription.setBoundLabelUnderline(true);		
        this.conthatchDescription.setVisible(true);
        // contBizDate		
        this.contBizDate.setBoundLabelText(resHelper.getString("contBizDate.boundLabelText"));		
        this.contBizDate.setBoundLabelLength(100);		
        this.contBizDate.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelAlignment(7);		
        this.contBizDate.setVisible(true);
        // kDPanel3		
        this.kDPanel3.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel3.border.title")));
        // contstoOrg		
        this.contstoOrg.setBoundLabelText(resHelper.getString("contstoOrg.boundLabelText"));		
        this.contstoOrg.setBoundLabelLength(100);		
        this.contstoOrg.setBoundLabelUnderline(true);		
        this.contstoOrg.setVisible(true);
        // kDPanel1		
        this.kDPanel1.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel1.border.title")));
        // kDPanel2		
        this.kDPanel2.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel2.border.title")));
        // kDPanel4		
        this.kDPanel4.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel4.border.title")));
        // kDPanel5		
        this.kDPanel5.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel5.border.title")));
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
        // scrollPanehatchDescription
        // txthatchDescription		
        this.txthatchDescription.setVisible(true);		
        this.txthatchDescription.setRequired(false);		
        this.txthatchDescription.setMaxLength(1000);
        // pkBizDate		
        this.pkBizDate.setVisible(true);		
        this.pkBizDate.setEnabled(true);		
        this.pkBizDate.setRequired(true);
        // contentryQty		
        this.contentryQty.setBoundLabelText(resHelper.getString("contentryQty.boundLabelText"));		
        this.contentryQty.setBoundLabelLength(100);		
        this.contentryQty.setBoundLabelUnderline(true);		
        this.contentryQty.setVisible(true);
        // contleaveQty		
        this.contleaveQty.setBoundLabelText(resHelper.getString("contleaveQty.boundLabelText"));		
        this.contleaveQty.setBoundLabelLength(100);		
        this.contleaveQty.setBoundLabelUnderline(true);		
        this.contleaveQty.setVisible(true);
        // contattendanceQty		
        this.contattendanceQty.setBoundLabelText(resHelper.getString("contattendanceQty.boundLabelText"));		
        this.contattendanceQty.setBoundLabelLength(100);		
        this.contattendanceQty.setBoundLabelUnderline(true);		
        this.contattendanceQty.setVisible(true);
        // continitQty		
        this.continitQty.setBoundLabelText(resHelper.getString("continitQty.boundLabelText"));		
        this.continitQty.setBoundLabelLength(100);		
        this.continitQty.setBoundLabelUnderline(true);		
        this.continitQty.setVisible(true);
        // txtentryQty		
        this.txtentryQty.setVisible(true);		
        this.txtentryQty.setHorizontalAlignment(2);		
        this.txtentryQty.setDataType(0);		
        this.txtentryQty.setSupportedEmpty(true);		
        this.txtentryQty.setRequired(false);
        // txtleaveQty		
        this.txtleaveQty.setVisible(true);		
        this.txtleaveQty.setHorizontalAlignment(2);		
        this.txtleaveQty.setDataType(0);		
        this.txtleaveQty.setSupportedEmpty(true);		
        this.txtleaveQty.setRequired(false);
        // txtattendanceQty		
        this.txtattendanceQty.setVisible(true);		
        this.txtattendanceQty.setHorizontalAlignment(2);		
        this.txtattendanceQty.setDataType(0);		
        this.txtattendanceQty.setSupportedEmpty(true);		
        this.txtattendanceQty.setRequired(true);
        // txtinitQty		
        this.txtinitQty.setVisible(true);		
        this.txtinitQty.setHorizontalAlignment(2);		
        this.txtinitQty.setDataType(0);		
        this.txtinitQty.setSupportedEmpty(true);		
        this.txtinitQty.setRequired(true);
        // prmtstoOrg		
        this.prmtstoOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtstoOrg.setVisible(true);		
        this.prmtstoOrg.setEditable(true);		
        this.prmtstoOrg.setDisplayFormat("$name$");		
        this.prmtstoOrg.setEditFormat("$number$");		
        this.prmtstoOrg.setCommitFormat("$number$");		
        this.prmtstoOrg.setRequired(false);		
        this.prmtstoOrg.setEnabled(false);
        // contsoybeanInventory		
        this.contsoybeanInventory.setBoundLabelText(resHelper.getString("contsoybeanInventory.boundLabelText"));		
        this.contsoybeanInventory.setBoundLabelLength(100);		
        this.contsoybeanInventory.setBoundLabelUnderline(true);		
        this.contsoybeanInventory.setVisible(true);
        // contownInventory		
        this.contownInventory.setBoundLabelText(resHelper.getString("contownInventory.boundLabelText"));		
        this.contownInventory.setBoundLabelLength(100);		
        this.contownInventory.setBoundLabelUnderline(true);		
        this.contownInventory.setVisible(true);
        // contcornInventory		
        this.contcornInventory.setBoundLabelText(resHelper.getString("contcornInventory.boundLabelText"));		
        this.contcornInventory.setBoundLabelLength(100);		
        this.contcornInventory.setBoundLabelUnderline(true);		
        this.contcornInventory.setVisible(true);
        // txtsoybeanInventory		
        this.txtsoybeanInventory.setVisible(true);		
        this.txtsoybeanInventory.setHorizontalAlignment(2);		
        this.txtsoybeanInventory.setDataType(1);		
        this.txtsoybeanInventory.setSupportedEmpty(true);		
        this.txtsoybeanInventory.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtsoybeanInventory.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtsoybeanInventory.setPrecision(2);		
        this.txtsoybeanInventory.setRequired(false);
        // txtownInventory		
        this.txtownInventory.setVisible(true);		
        this.txtownInventory.setHorizontalAlignment(2);		
        this.txtownInventory.setDataType(1);		
        this.txtownInventory.setSupportedEmpty(true);		
        this.txtownInventory.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtownInventory.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtownInventory.setPrecision(2);		
        this.txtownInventory.setRequired(false);
        // txtcornInventory		
        this.txtcornInventory.setVisible(true);		
        this.txtcornInventory.setHorizontalAlignment(2);		
        this.txtcornInventory.setDataType(1);		
        this.txtcornInventory.setSupportedEmpty(true);		
        this.txtcornInventory.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtcornInventory.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtcornInventory.setPrecision(2);		
        this.txtcornInventory.setRequired(false);
        // contelecQty		
        this.contelecQty.setBoundLabelText(resHelper.getString("contelecQty.boundLabelText"));		
        this.contelecQty.setBoundLabelLength(100);		
        this.contelecQty.setBoundLabelUnderline(true);		
        this.contelecQty.setVisible(true);
        // contcoalQty		
        this.contcoalQty.setBoundLabelText(resHelper.getString("contcoalQty.boundLabelText"));		
        this.contcoalQty.setBoundLabelLength(100);		
        this.contcoalQty.setBoundLabelUnderline(true);		
        this.contcoalQty.setVisible(true);
        // contelecEnd		
        this.contelecEnd.setBoundLabelText(resHelper.getString("contelecEnd.boundLabelText"));		
        this.contelecEnd.setBoundLabelLength(100);		
        this.contelecEnd.setBoundLabelUnderline(true);		
        this.contelecEnd.setVisible(true);
        // contelecBegin		
        this.contelecBegin.setBoundLabelText(resHelper.getString("contelecBegin.boundLabelText"));		
        this.contelecBegin.setBoundLabelLength(100);		
        this.contelecBegin.setBoundLabelUnderline(true);		
        this.contelecBegin.setVisible(true);
        // txtelecQty		
        this.txtelecQty.setVisible(true);		
        this.txtelecQty.setHorizontalAlignment(2);		
        this.txtelecQty.setDataType(1);		
        this.txtelecQty.setSupportedEmpty(true);		
        this.txtelecQty.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtelecQty.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtelecQty.setPrecision(2);		
        this.txtelecQty.setRequired(false);
        // txtcoalQty		
        this.txtcoalQty.setVisible(true);		
        this.txtcoalQty.setHorizontalAlignment(2);		
        this.txtcoalQty.setDataType(1);		
        this.txtcoalQty.setSupportedEmpty(true);		
        this.txtcoalQty.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtcoalQty.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtcoalQty.setPrecision(2);		
        this.txtcoalQty.setRequired(false);
        // txtelecEnd		
        this.txtelecEnd.setVisible(true);		
        this.txtelecEnd.setHorizontalAlignment(2);		
        this.txtelecEnd.setDataType(1);		
        this.txtelecEnd.setSupportedEmpty(true);		
        this.txtelecEnd.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtelecEnd.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtelecEnd.setPrecision(2);		
        this.txtelecEnd.setRequired(false);
        this.txtelecEnd.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtelecEnd_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtelecBegin		
        this.txtelecBegin.setVisible(true);		
        this.txtelecBegin.setHorizontalAlignment(2);		
        this.txtelecBegin.setDataType(1);		
        this.txtelecBegin.setSupportedEmpty(true);		
        this.txtelecBegin.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtelecBegin.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtelecBegin.setPrecision(2);		
        this.txtelecBegin.setRequired(false);
        this.txtelecBegin.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtelecBegin_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // contmotorcadeLeaveQty		
        this.contmotorcadeLeaveQty.setBoundLabelText(resHelper.getString("contmotorcadeLeaveQty.boundLabelText"));		
        this.contmotorcadeLeaveQty.setBoundLabelLength(100);		
        this.contmotorcadeLeaveQty.setBoundLabelUnderline(true);		
        this.contmotorcadeLeaveQty.setVisible(true);
        // contmotorcadeEntryQty		
        this.contmotorcadeEntryQty.setBoundLabelText(resHelper.getString("contmotorcadeEntryQty.boundLabelText"));		
        this.contmotorcadeEntryQty.setBoundLabelLength(100);		
        this.contmotorcadeEntryQty.setBoundLabelUnderline(true);		
        this.contmotorcadeEntryQty.setVisible(true);
        // contmotorcadeAttendQty		
        this.contmotorcadeAttendQty.setBoundLabelText(resHelper.getString("contmotorcadeAttendQty.boundLabelText"));		
        this.contmotorcadeAttendQty.setBoundLabelLength(100);		
        this.contmotorcadeAttendQty.setBoundLabelUnderline(true);		
        this.contmotorcadeAttendQty.setVisible(true);
        // contmotorcadeInitQty		
        this.contmotorcadeInitQty.setBoundLabelText(resHelper.getString("contmotorcadeInitQty.boundLabelText"));		
        this.contmotorcadeInitQty.setBoundLabelLength(100);		
        this.contmotorcadeInitQty.setBoundLabelUnderline(true);		
        this.contmotorcadeInitQty.setVisible(true);
        // txtmotorcadeLeaveQty		
        this.txtmotorcadeLeaveQty.setVisible(true);		
        this.txtmotorcadeLeaveQty.setHorizontalAlignment(2);		
        this.txtmotorcadeLeaveQty.setDataType(0);		
        this.txtmotorcadeLeaveQty.setSupportedEmpty(true);		
        this.txtmotorcadeLeaveQty.setRequired(false);
        // txtmotorcadeEntryQty		
        this.txtmotorcadeEntryQty.setVisible(true);		
        this.txtmotorcadeEntryQty.setHorizontalAlignment(2);		
        this.txtmotorcadeEntryQty.setDataType(0);		
        this.txtmotorcadeEntryQty.setSupportedEmpty(true);		
        this.txtmotorcadeEntryQty.setRequired(false);
        // txtmotorcadeAttendQty		
        this.txtmotorcadeAttendQty.setVisible(true);		
        this.txtmotorcadeAttendQty.setHorizontalAlignment(2);		
        this.txtmotorcadeAttendQty.setDataType(0);		
        this.txtmotorcadeAttendQty.setSupportedEmpty(true);		
        this.txtmotorcadeAttendQty.setRequired(false);
        // txtmotorcadeInitQty		
        this.txtmotorcadeInitQty.setVisible(true);		
        this.txtmotorcadeInitQty.setHorizontalAlignment(2);		
        this.txtmotorcadeInitQty.setDataType(0);		
        this.txtmotorcadeInitQty.setSupportedEmpty(true);		
        this.txtmotorcadeInitQty.setRequired(false);
        // contproxyInventory		
        this.contproxyInventory.setBoundLabelText(resHelper.getString("contproxyInventory.boundLabelText"));		
        this.contproxyInventory.setBoundLabelLength(100);		
        this.contproxyInventory.setBoundLabelUnderline(true);		
        this.contproxyInventory.setVisible(true);
        // contproxySoybeanInventory		
        this.contproxySoybeanInventory.setBoundLabelText(resHelper.getString("contproxySoybeanInventory.boundLabelText"));		
        this.contproxySoybeanInventory.setBoundLabelLength(100);		
        this.contproxySoybeanInventory.setBoundLabelUnderline(true);		
        this.contproxySoybeanInventory.setVisible(true);
        // contproxyCornInventory		
        this.contproxyCornInventory.setBoundLabelText(resHelper.getString("contproxyCornInventory.boundLabelText"));		
        this.contproxyCornInventory.setBoundLabelLength(100);		
        this.contproxyCornInventory.setBoundLabelUnderline(true);		
        this.contproxyCornInventory.setVisible(true);
        // txtproxyInventory		
        this.txtproxyInventory.setVisible(true);		
        this.txtproxyInventory.setHorizontalAlignment(2);		
        this.txtproxyInventory.setDataType(1);		
        this.txtproxyInventory.setSupportedEmpty(true);		
        this.txtproxyInventory.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtproxyInventory.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtproxyInventory.setPrecision(2);		
        this.txtproxyInventory.setRequired(false);
        // txtproxySoybeanInventory		
        this.txtproxySoybeanInventory.setVisible(true);		
        this.txtproxySoybeanInventory.setHorizontalAlignment(2);		
        this.txtproxySoybeanInventory.setDataType(1);		
        this.txtproxySoybeanInventory.setSupportedEmpty(true);		
        this.txtproxySoybeanInventory.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtproxySoybeanInventory.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtproxySoybeanInventory.setPrecision(2);		
        this.txtproxySoybeanInventory.setRequired(false);
        // txtproxyCornInventory		
        this.txtproxyCornInventory.setVisible(true);		
        this.txtproxyCornInventory.setHorizontalAlignment(2);		
        this.txtproxyCornInventory.setDataType(1);		
        this.txtproxyCornInventory.setSupportedEmpty(true);		
        this.txtproxyCornInventory.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtproxyCornInventory.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtproxyCornInventory.setPrecision(2);		
        this.txtproxyCornInventory.setRequired(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,pkauditTime,baseStatus,txthatchDescription,txtinitQty,txtentryQty,txtleaveQty,txtattendanceQty,prmtstoOrg,txtownInventory,txtproxyInventory,txtsoybeanInventory,txtcoalQty,txtelecQty,txtmotorcadeInitQty,txtmotorcadeAttendQty,txtmotorcadeEntryQty,txtmotorcadeLeaveQty,txtcornInventory,txtelecBegin,txtelecEnd,txtproxyCornInventory,txtproxySoybeanInventory}));
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
        this.setBounds(new Rectangle(0, 0, 650, 600));
        this.setLayout(null);
        contCreator.setBounds(new Rectangle(25, 517, 270, 19));
        this.add(contCreator, null);
        contCreateTime.setBounds(new Rectangle(25, 549, 270, 19));
        this.add(contCreateTime, null);
        contLastUpdateUser.setBounds(new Rectangle(3, 575, 270, 19));
        this.add(contLastUpdateUser, null);
        contLastUpdateTime.setBounds(new Rectangle(300, 577, 270, 19));
        this.add(contLastUpdateTime, null);
        contNumber.setBounds(new Rectangle(28, 25, 270, 19));
        this.add(contNumber, null);
        contDescription.setBounds(new Rectangle(21, -448, 270, 19));
        this.add(contDescription, null);
        contAuditor.setBounds(new Rectangle(351, 517, 270, 19));
        this.add(contAuditor, null);
        contauditTime.setBounds(new Rectangle(351, 547, 270, 19));
        this.add(contauditTime, null);
        contbaseStatus.setBounds(new Rectangle(348, 52, 270, 19));
        this.add(contbaseStatus, null);
        conthatchDescription.setBounds(new Rectangle(24, 466, 614, 38));
        this.add(conthatchDescription, null);
        contBizDate.setBounds(new Rectangle(28, 52, 270, 19));
        this.add(contBizDate, null);
        kDPanel3.setBounds(new Rectangle(15, 298, 619, 73));
        this.add(kDPanel3, null);
        contstoOrg.setBounds(new Rectangle(348, 25, 270, 19));
        this.add(contstoOrg, null);
        kDPanel1.setBounds(new Rectangle(15, 84, 303, 100));
        this.add(kDPanel1, null);
        kDPanel2.setBounds(new Rectangle(15, 217, 619, 77));
        this.add(kDPanel2, null);
        kDPanel4.setBounds(new Rectangle(15, 375, 619, 79));
        this.add(kDPanel4, null);
        kDPanel5.setBounds(new Rectangle(332, 84, 303, 100));
        this.add(kDPanel5, null);
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
        //conthatchDescription
        conthatchDescription.setBoundEditor(scrollPanehatchDescription);
        //scrollPanehatchDescription
        scrollPanehatchDescription.getViewport().add(txthatchDescription, null);
        //contBizDate
        contBizDate.setBoundEditor(pkBizDate);
        //kDPanel3
        kDPanel3.setLayout(null);        contentryQty.setBounds(new Rectangle(329, 36, 270, 19));
        kDPanel3.add(contentryQty, null);
        contleaveQty.setBounds(new Rectangle(17, 38, 270, 19));
        kDPanel3.add(contleaveQty, null);
        contattendanceQty.setBounds(new Rectangle(329, 12, 270, 19));
        kDPanel3.add(contattendanceQty, null);
        continitQty.setBounds(new Rectangle(17, 13, 270, 19));
        kDPanel3.add(continitQty, null);
        //contentryQty
        contentryQty.setBoundEditor(txtentryQty);
        //contleaveQty
        contleaveQty.setBoundEditor(txtleaveQty);
        //contattendanceQty
        contattendanceQty.setBoundEditor(txtattendanceQty);
        //continitQty
        continitQty.setBoundEditor(txtinitQty);
        //contstoOrg
        contstoOrg.setBoundEditor(prmtstoOrg);
        //kDPanel1
        kDPanel1.setLayout(null);        contsoybeanInventory.setBounds(new Rectangle(15, 67, 270, 19));
        kDPanel1.add(contsoybeanInventory, null);
        contownInventory.setBounds(new Rectangle(15, 16, 270, 19));
        kDPanel1.add(contownInventory, null);
        contcornInventory.setBounds(new Rectangle(15, 41, 270, 19));
        kDPanel1.add(contcornInventory, null);
        //contsoybeanInventory
        contsoybeanInventory.setBoundEditor(txtsoybeanInventory);
        //contownInventory
        contownInventory.setBoundEditor(txtownInventory);
        //contcornInventory
        contcornInventory.setBoundEditor(txtcornInventory);
        //kDPanel2
        kDPanel2.setLayout(null);        contelecQty.setBounds(new Rectangle(19, 39, 270, 19));
        kDPanel2.add(contelecQty, null);
        contcoalQty.setBounds(new Rectangle(332, 40, 270, 19));
        kDPanel2.add(contcoalQty, null);
        contelecEnd.setBounds(new Rectangle(332, 15, 270, 19));
        kDPanel2.add(contelecEnd, null);
        contelecBegin.setBounds(new Rectangle(19, 16, 270, 19));
        kDPanel2.add(contelecBegin, null);
        //contelecQty
        contelecQty.setBoundEditor(txtelecQty);
        //contcoalQty
        contcoalQty.setBoundEditor(txtcoalQty);
        //contelecEnd
        contelecEnd.setBoundEditor(txtelecEnd);
        //contelecBegin
        contelecBegin.setBoundEditor(txtelecBegin);
        //kDPanel4
        kDPanel4.setLayout(null);        contmotorcadeLeaveQty.setBounds(new Rectangle(330, 39, 270, 19));
        kDPanel4.add(contmotorcadeLeaveQty, null);
        contmotorcadeEntryQty.setBounds(new Rectangle(17, 39, 270, 19));
        kDPanel4.add(contmotorcadeEntryQty, null);
        contmotorcadeAttendQty.setBounds(new Rectangle(330, 14, 270, 19));
        kDPanel4.add(contmotorcadeAttendQty, null);
        contmotorcadeInitQty.setBounds(new Rectangle(17, 13, 270, 19));
        kDPanel4.add(contmotorcadeInitQty, null);
        //contmotorcadeLeaveQty
        contmotorcadeLeaveQty.setBoundEditor(txtmotorcadeLeaveQty);
        //contmotorcadeEntryQty
        contmotorcadeEntryQty.setBoundEditor(txtmotorcadeEntryQty);
        //contmotorcadeAttendQty
        contmotorcadeAttendQty.setBoundEditor(txtmotorcadeAttendQty);
        //contmotorcadeInitQty
        contmotorcadeInitQty.setBoundEditor(txtmotorcadeInitQty);
        //kDPanel5
        kDPanel5.setLayout(null);        contproxyInventory.setBounds(new Rectangle(15, 16, 270, 19));
        kDPanel5.add(contproxyInventory, null);
        contproxySoybeanInventory.setBounds(new Rectangle(15, 67, 270, 19));
        kDPanel5.add(contproxySoybeanInventory, null);
        contproxyCornInventory.setBounds(new Rectangle(15, 40, 270, 19));
        kDPanel5.add(contproxyCornInventory, null);
        //contproxyInventory
        contproxyInventory.setBoundEditor(txtproxyInventory);
        //contproxySoybeanInventory
        contproxySoybeanInventory.setBoundEditor(txtproxySoybeanInventory);
        //contproxyCornInventory
        contproxyCornInventory.setBoundEditor(txtproxyCornInventory);

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
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("hatchDescription", String.class, this.txthatchDescription, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("entryQty", int.class, this.txtentryQty, "value");
		dataBinder.registerBinding("leaveQty", int.class, this.txtleaveQty, "value");
		dataBinder.registerBinding("attendanceQty", int.class, this.txtattendanceQty, "value");
		dataBinder.registerBinding("initQty", int.class, this.txtinitQty, "value");
		dataBinder.registerBinding("stoOrg", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtstoOrg, "data");
		dataBinder.registerBinding("soybeanInventory", java.math.BigDecimal.class, this.txtsoybeanInventory, "value");
		dataBinder.registerBinding("ownInventory", java.math.BigDecimal.class, this.txtownInventory, "value");
		dataBinder.registerBinding("cornInventory", java.math.BigDecimal.class, this.txtcornInventory, "value");
		dataBinder.registerBinding("elecQty", java.math.BigDecimal.class, this.txtelecQty, "value");
		dataBinder.registerBinding("coalQty", java.math.BigDecimal.class, this.txtcoalQty, "value");
		dataBinder.registerBinding("elecEnd", java.math.BigDecimal.class, this.txtelecEnd, "value");
		dataBinder.registerBinding("elecBegin", java.math.BigDecimal.class, this.txtelecBegin, "value");
		dataBinder.registerBinding("motorcadeLeaveQty", int.class, this.txtmotorcadeLeaveQty, "value");
		dataBinder.registerBinding("motorcadeEntryQty", int.class, this.txtmotorcadeEntryQty, "value");
		dataBinder.registerBinding("motorcadeAttendQty", int.class, this.txtmotorcadeAttendQty, "value");
		dataBinder.registerBinding("motorcadeInitQty", int.class, this.txtmotorcadeInitQty, "value");
		dataBinder.registerBinding("proxyInventory", java.math.BigDecimal.class, this.txtproxyInventory, "value");
		dataBinder.registerBinding("proxySoybeanInventory", java.math.BigDecimal.class, this.txtproxySoybeanInventory, "value");
		dataBinder.registerBinding("proxyCornInventory", java.math.BigDecimal.class, this.txtproxyCornInventory, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.feedfactory.app.FeedBusinessDailyEditUIHandler";
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
        this.kDDateLastUpdateTime.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.feedfactory.FeedBusinessDailyInfo)ov;
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
		getValidateHelper().registerBindProperty("hatchDescription", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entryQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("leaveQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("attendanceQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("initQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("stoOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("soybeanInventory", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ownInventory", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cornInventory", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("elecQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("coalQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("elecEnd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("elecBegin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("motorcadeLeaveQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("motorcadeEntryQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("motorcadeAttendQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("motorcadeInitQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("proxyInventory", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("proxySoybeanInventory", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("proxyCornInventory", ValidateHelper.ON_SAVE);    		
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
     * output txtelecEnd_dataChanged method
     */
    protected void txtelecEnd_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output txtelecBegin_dataChanged method
     */
    protected void txtelecBegin_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
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
        sic.add(new SelectorItemInfo("hatchDescription"));
        sic.add(new SelectorItemInfo("bizDate"));
        sic.add(new SelectorItemInfo("entryQty"));
        sic.add(new SelectorItemInfo("leaveQty"));
        sic.add(new SelectorItemInfo("attendanceQty"));
        sic.add(new SelectorItemInfo("initQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("stoOrg.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("stoOrg.id"));
        	sic.add(new SelectorItemInfo("stoOrg.number"));
        	sic.add(new SelectorItemInfo("stoOrg.name"));
		}
        sic.add(new SelectorItemInfo("soybeanInventory"));
        sic.add(new SelectorItemInfo("ownInventory"));
        sic.add(new SelectorItemInfo("cornInventory"));
        sic.add(new SelectorItemInfo("elecQty"));
        sic.add(new SelectorItemInfo("coalQty"));
        sic.add(new SelectorItemInfo("elecEnd"));
        sic.add(new SelectorItemInfo("elecBegin"));
        sic.add(new SelectorItemInfo("motorcadeLeaveQty"));
        sic.add(new SelectorItemInfo("motorcadeEntryQty"));
        sic.add(new SelectorItemInfo("motorcadeAttendQty"));
        sic.add(new SelectorItemInfo("motorcadeInitQty"));
        sic.add(new SelectorItemInfo("proxyInventory"));
        sic.add(new SelectorItemInfo("proxySoybeanInventory"));
        sic.add(new SelectorItemInfo("proxyCornInventory"));
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
        com.kingdee.eas.farm.feedfactory.FeedBusinessDailyFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.feedfactory.FeedBusinessDailyFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractFeedBusinessDailyEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractFeedBusinessDailyEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.feedfactory.client", "FeedBusinessDailyEditUI");
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
        return com.kingdee.eas.farm.feedfactory.client.FeedBusinessDailyEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.feedfactory.FeedBusinessDailyFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.feedfactory.FeedBusinessDailyInfo objectValue = new com.kingdee.eas.farm.feedfactory.FeedBusinessDailyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/feedfactory/FeedBusinessDaily";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.feedfactory.app.FeedBusinessDailyQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtNumber.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"单据编号"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(baseStatus.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"状态"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtattendanceQty.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"当天出勤人数"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtinitQty.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"当天初始人数"});
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