/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.feedbiz.client;

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
public abstract class AbstractConFeedContractEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractConFeedContractEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontractType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbeginDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contendDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsuccessiveQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgm;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyear;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmerType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contidentity;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmAddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continitSettledNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcurSettledNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continitSubsidies;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcumulativeSub;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcontractType;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkbeginDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkendDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsuccessiveQty;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarm;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtgm;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtPolicyEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtPolicyEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtFeedEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtFeedEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contremark;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane scrollPaneremark;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtremark;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperson;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyear;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmerType;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtidentity;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfarmAddress;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtinitSettledNum;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcurSettledNum;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtinitSubsidies;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcumulativeSub;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUpdateFeed;
    protected com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionUpdateFeed actionUpdateFeed = null;
    /**
     * output class constructor
     */
    public AbstractConFeedContractEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractConFeedContractEditUI.class.getName());
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
        this.actionUnAudit.setExtendProperty("canForewarn", "true");
        this.actionUnAudit.setExtendProperty("userDefined", "false");
        this.actionUnAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionUpdateFeed
        this.actionUpdateFeed = new ActionUpdateFeed(this);
        getActionManager().registerAction("actionUpdateFeed", actionUpdateFeed);
        this.actionUpdateFeed.setBindWorkFlow(true);
        this.actionUpdateFeed.setExtendProperty("canForewarn", "true");
        this.actionUpdateFeed.setExtendProperty("userDefined", "true");
        this.actionUpdateFeed.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUpdateFeed.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUpdateFeed.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionUpdateFeed.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcontractType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbeginDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contendDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsuccessiveQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contperson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyear = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmerType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contidentity = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmAddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continitSettledNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcurSettledNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continitSubsidies = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcumulativeSub = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcontractType = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkbeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkendDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtsuccessiveQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtfarmer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtfarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtgm = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtPolicyEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtFeedEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contremark = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.scrollPaneremark = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txtremark = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.prmtperson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtyear = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtfarmerType = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtidentity = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtfarmAddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtinitSettledNum = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcurSettledNum = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtinitSubsidies = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcumulativeSub = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUpdateFeed = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contAuditor.setName("contAuditor");
        this.contcontractType.setName("contcontractType");
        this.contbeginDate.setName("contbeginDate");
        this.contendDate.setName("contendDate");
        this.contsuccessiveQty.setName("contsuccessiveQty");
        this.contbillStatus.setName("contbillStatus");
        this.contauditTime.setName("contauditTime");
        this.contcompany.setName("contcompany");
        this.contfarmer.setName("contfarmer");
        this.contfarm.setName("contfarm");
        this.contgm.setName("contgm");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contperson.setName("contperson");
        this.contyear.setName("contyear");
        this.contfarmerType.setName("contfarmerType");
        this.contidentity.setName("contidentity");
        this.contfarmAddress.setName("contfarmAddress");
        this.continitSettledNum.setName("continitSettledNum");
        this.contcurSettledNum.setName("contcurSettledNum");
        this.continitSubsidies.setName("continitSubsidies");
        this.contcumulativeSub.setName("contcumulativeSub");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtcontractType.setName("prmtcontractType");
        this.pkbeginDate.setName("pkbeginDate");
        this.pkendDate.setName("pkendDate");
        this.txtsuccessiveQty.setName("txtsuccessiveQty");
        this.billStatus.setName("billStatus");
        this.pkauditTime.setName("pkauditTime");
        this.prmtcompany.setName("prmtcompany");
        this.prmtfarmer.setName("prmtfarmer");
        this.prmtfarm.setName("prmtfarm");
        this.txtgm.setName("txtgm");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel3.setName("kDPanel3");
        this.kDPanel2.setName("kDPanel2");
        this.kdtPolicyEntry.setName("kdtPolicyEntry");
        this.kdtFeedEntrys.setName("kdtFeedEntrys");
        this.contremark.setName("contremark");
        this.scrollPaneremark.setName("scrollPaneremark");
        this.txtremark.setName("txtremark");
        this.prmtperson.setName("prmtperson");
        this.txtyear.setName("txtyear");
        this.prmtfarmerType.setName("prmtfarmerType");
        this.txtidentity.setName("txtidentity");
        this.txtfarmAddress.setName("txtfarmAddress");
        this.txtinitSettledNum.setName("txtinitSettledNum");
        this.txtcurSettledNum.setName("txtcurSettledNum");
        this.txtinitSubsidies.setName("txtinitSubsidies");
        this.txtcumulativeSub.setName("txtcumulativeSub");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
        this.btnUpdateFeed.setName("btnUpdateFeed");
        // CoreUI		
        this.btnCancelCancel.setText(resHelper.getString("btnCancelCancel.text"));		
        this.btnCancelCancel.setToolTipText(resHelper.getString("btnCancelCancel.toolTipText"));		
        this.btnCancelCancel.setVisible(true);		
        this.btnCancelCancel.setEnabled(true);		
        this.btnCancel.setText(resHelper.getString("btnCancel.text"));		
        this.btnCancel.setToolTipText(resHelper.getString("btnCancel.toolTipText"));		
        this.btnCancel.setEnabled(true);		
        this.btnCancel.setVisible(true);		
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
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);
        // contcontractType		
        this.contcontractType.setBoundLabelText(resHelper.getString("contcontractType.boundLabelText"));		
        this.contcontractType.setBoundLabelLength(100);		
        this.contcontractType.setBoundLabelUnderline(true);		
        this.contcontractType.setVisible(true);
        // contbeginDate		
        this.contbeginDate.setBoundLabelText(resHelper.getString("contbeginDate.boundLabelText"));		
        this.contbeginDate.setBoundLabelLength(100);		
        this.contbeginDate.setBoundLabelUnderline(true);		
        this.contbeginDate.setVisible(true);
        // contendDate		
        this.contendDate.setBoundLabelText(resHelper.getString("contendDate.boundLabelText"));		
        this.contendDate.setBoundLabelLength(100);		
        this.contendDate.setBoundLabelUnderline(true);		
        this.contendDate.setVisible(true);
        // contsuccessiveQty		
        this.contsuccessiveQty.setBoundLabelText(resHelper.getString("contsuccessiveQty.boundLabelText"));		
        this.contsuccessiveQty.setBoundLabelLength(100);		
        this.contsuccessiveQty.setBoundLabelUnderline(true);		
        this.contsuccessiveQty.setVisible(true);
        // contbillStatus		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contfarmer		
        this.contfarmer.setBoundLabelText(resHelper.getString("contfarmer.boundLabelText"));		
        this.contfarmer.setBoundLabelLength(100);		
        this.contfarmer.setBoundLabelUnderline(true);		
        this.contfarmer.setVisible(true);
        // contfarm		
        this.contfarm.setBoundLabelText(resHelper.getString("contfarm.boundLabelText"));		
        this.contfarm.setBoundLabelLength(100);		
        this.contfarm.setBoundLabelUnderline(true);		
        this.contfarm.setVisible(true);
        // contgm		
        this.contgm.setBoundLabelText(resHelper.getString("contgm.boundLabelText"));		
        this.contgm.setBoundLabelLength(100);		
        this.contgm.setBoundLabelUnderline(true);		
        this.contgm.setVisible(true);
        // kDTabbedPane1
        // contperson		
        this.contperson.setBoundLabelText(resHelper.getString("contperson.boundLabelText"));		
        this.contperson.setBoundLabelLength(100);		
        this.contperson.setBoundLabelUnderline(true);		
        this.contperson.setVisible(true);
        // contyear		
        this.contyear.setBoundLabelText(resHelper.getString("contyear.boundLabelText"));		
        this.contyear.setBoundLabelLength(100);		
        this.contyear.setBoundLabelUnderline(true);		
        this.contyear.setVisible(true);
        // contfarmerType		
        this.contfarmerType.setBoundLabelText(resHelper.getString("contfarmerType.boundLabelText"));		
        this.contfarmerType.setBoundLabelLength(100);		
        this.contfarmerType.setBoundLabelUnderline(true);		
        this.contfarmerType.setVisible(true);
        // contidentity		
        this.contidentity.setBoundLabelText(resHelper.getString("contidentity.boundLabelText"));		
        this.contidentity.setBoundLabelLength(100);		
        this.contidentity.setBoundLabelUnderline(true);		
        this.contidentity.setVisible(true);
        // contfarmAddress		
        this.contfarmAddress.setBoundLabelText(resHelper.getString("contfarmAddress.boundLabelText"));		
        this.contfarmAddress.setBoundLabelLength(100);		
        this.contfarmAddress.setBoundLabelUnderline(true);		
        this.contfarmAddress.setVisible(true);
        // continitSettledNum		
        this.continitSettledNum.setBoundLabelText(resHelper.getString("continitSettledNum.boundLabelText"));		
        this.continitSettledNum.setBoundLabelLength(100);		
        this.continitSettledNum.setBoundLabelUnderline(true);		
        this.continitSettledNum.setVisible(true);
        // contcurSettledNum		
        this.contcurSettledNum.setBoundLabelText(resHelper.getString("contcurSettledNum.boundLabelText"));		
        this.contcurSettledNum.setBoundLabelLength(100);		
        this.contcurSettledNum.setBoundLabelUnderline(true);		
        this.contcurSettledNum.setVisible(true);
        // continitSubsidies		
        this.continitSubsidies.setBoundLabelText(resHelper.getString("continitSubsidies.boundLabelText"));		
        this.continitSubsidies.setBoundLabelLength(100);		
        this.continitSubsidies.setBoundLabelUnderline(true);		
        this.continitSubsidies.setVisible(true);
        // contcumulativeSub		
        this.contcumulativeSub.setBoundLabelText(resHelper.getString("contcumulativeSub.boundLabelText"));		
        this.contcumulativeSub.setBoundLabelLength(100);		
        this.contcumulativeSub.setBoundLabelUnderline(true);		
        this.contcumulativeSub.setVisible(true);
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
        // pkBizDate		
        this.pkBizDate.setEnabled(true);		
        this.pkBizDate.setRequired(true);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // prmtcontractType		
        this.prmtcontractType.setQueryInfo("com.kingdee.eas.custom.signwasthetable.app.ContractTypeQuery");		
        this.prmtcontractType.setEditable(true);		
        this.prmtcontractType.setDisplayFormat("$name$");		
        this.prmtcontractType.setEditFormat("$number$");		
        this.prmtcontractType.setCommitFormat("$number$");		
        this.prmtcontractType.setRequired(false);
        // pkbeginDate		
        this.pkbeginDate.setRequired(true);
        // pkendDate		
        this.pkendDate.setRequired(true);
        // txtsuccessiveQty		
        this.txtsuccessiveQty.setHorizontalAlignment(2);		
        this.txtsuccessiveQty.setDataType(0);		
        this.txtsuccessiveQty.setSupportedEmpty(true);		
        this.txtsuccessiveQty.setRequired(false);
        // billStatus		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
        // prmtfarmer		
        this.prmtfarmer.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerQuery");		
        this.prmtfarmer.setEditable(true);		
        this.prmtfarmer.setDisplayFormat("$name$");		
        this.prmtfarmer.setEditFormat("$number$");		
        this.prmtfarmer.setCommitFormat("$number$");		
        this.prmtfarmer.setRequired(true);
        		prmtfarmer.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.FarmerListUI prmtfarmer_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarmer_F7ListUI == null) {
					try {
						prmtfarmer_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.FarmerListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtfarmer_F7ListUI));
					prmtfarmer_F7ListUI.setF7Use(true,ctx);
					prmtfarmer.setSelector(prmtfarmer_F7ListUI);
				}
			}
		});
					
        prmtfarmer.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtfarmer_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // prmtfarm		
        this.prmtfarm.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmQuery");		
        this.prmtfarm.setEditable(true);		
        this.prmtfarm.setDisplayFormat("$name$");		
        this.prmtfarm.setEditFormat("$number$");		
        this.prmtfarm.setCommitFormat("$number$");		
        this.prmtfarm.setRequired(true);
        		prmtfarm.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.FarmListUI prmtfarm_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarm_F7ListUI == null) {
					try {
						prmtfarm_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.FarmListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtfarm_F7ListUI));
					prmtfarm_F7ListUI.setF7Use(true,ctx);
					prmtfarm.setSelector(prmtfarm_F7ListUI);
				}
			}
		});
					
        prmtfarm.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtfarm_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtgm		
        this.txtgm.setHorizontalAlignment(2);		
        this.txtgm.setMaxLength(100);		
        this.txtgm.setRequired(false);
        // kDPanel1
        // kDPanel3
        // kDPanel2
        // kdtPolicyEntry
		String kdtPolicyEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol8\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"confeedPolicy\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"year\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"2\" t:styleID=\"sCol2\" /><t:Column t:key=\"beginDate\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"3\" t:styleID=\"sCol3\" /><t:Column t:key=\"endDate\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"4\" t:styleID=\"sCol4\" /><t:Column t:key=\"isDefault\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" /><t:Column t:key=\"breedData\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"subsidyType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"subsidy\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{confeedPolicy}</t:Cell><t:Cell>$Resource{year}</t:Cell><t:Cell>$Resource{beginDate}</t:Cell><t:Cell>$Resource{endDate}</t:Cell><t:Cell>$Resource{isDefault}</t:Cell><t:Cell>$Resource{breedData}</t:Cell><t:Cell>$Resource{subsidyType}</t:Cell><t:Cell>$Resource{subsidy}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtPolicyEntry.setFormatXml(resHelper.translateString("kdtPolicyEntry",kdtPolicyEntryStrXML));
        kdtPolicyEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtPolicyEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtPolicyEntry.putBindContents("editData",new String[] {"seq","confeedPolicy","year","beginDate","endDate","isDefault","breedData","subsidyType","subsidy"});


        this.kdtPolicyEntry.checkParsed();
        KDFormattedTextField kdtPolicyEntry_seq_TextField = new KDFormattedTextField();
        kdtPolicyEntry_seq_TextField.setName("kdtPolicyEntry_seq_TextField");
        kdtPolicyEntry_seq_TextField.setVisible(true);
        kdtPolicyEntry_seq_TextField.setEditable(true);
        kdtPolicyEntry_seq_TextField.setHorizontalAlignment(2);
        kdtPolicyEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtPolicyEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtPolicyEntry_seq_TextField);
        this.kdtPolicyEntry.getColumn("seq").setEditor(kdtPolicyEntry_seq_CellEditor);
        final KDBizPromptBox kdtPolicyEntry_confeedPolicy_PromptBox = new KDBizPromptBox();
        kdtPolicyEntry_confeedPolicy_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.ConFeedPolicyQuery");
        kdtPolicyEntry_confeedPolicy_PromptBox.setVisible(true);
        kdtPolicyEntry_confeedPolicy_PromptBox.setEditable(true);
        kdtPolicyEntry_confeedPolicy_PromptBox.setDisplayFormat("$number$");
        kdtPolicyEntry_confeedPolicy_PromptBox.setEditFormat("$number$");
        kdtPolicyEntry_confeedPolicy_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtPolicyEntry_confeedPolicy_CellEditor = new KDTDefaultCellEditor(kdtPolicyEntry_confeedPolicy_PromptBox);
        this.kdtPolicyEntry.getColumn("confeedPolicy").setEditor(kdtPolicyEntry_confeedPolicy_CellEditor);
        ObjectValueRender kdtPolicyEntry_confeedPolicy_OVR = new ObjectValueRender();
        kdtPolicyEntry_confeedPolicy_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtPolicyEntry.getColumn("confeedPolicy").setRenderer(kdtPolicyEntry_confeedPolicy_OVR);
        			EntityViewInfo evikdtPolicyEntry_confeedPolicy_PromptBox = new EntityViewInfo ();
		evikdtPolicyEntry_confeedPolicy_PromptBox.setFilter(com.kingdee.eas.framework.FrameWorkUtils.getF7FilterInfoByAuthorizedOrg(com.kingdee.eas.basedata.org.OrgType.getEnum("Company"),"FICompany.id"));
		kdtPolicyEntry_confeedPolicy_PromptBox.setEntityViewInfo(evikdtPolicyEntry_confeedPolicy_PromptBox);
					
        			kdtPolicyEntry_confeedPolicy_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.ConFeedPolicyListUI kdtPolicyEntry_confeedPolicy_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtPolicyEntry_confeedPolicy_PromptBox_F7ListUI == null) {
					try {
						kdtPolicyEntry_confeedPolicy_PromptBox_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.ConFeedPolicyListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtPolicyEntry_confeedPolicy_PromptBox_F7ListUI));
					kdtPolicyEntry_confeedPolicy_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtPolicyEntry_confeedPolicy_PromptBox.setSelector(kdtPolicyEntry_confeedPolicy_PromptBox_F7ListUI);
				}
			}
		});
					
        KDFormattedTextField kdtPolicyEntry_year_TextField = new KDFormattedTextField();
        kdtPolicyEntry_year_TextField.setName("kdtPolicyEntry_year_TextField");
        kdtPolicyEntry_year_TextField.setVisible(true);
        kdtPolicyEntry_year_TextField.setEditable(true);
        kdtPolicyEntry_year_TextField.setHorizontalAlignment(2);
        kdtPolicyEntry_year_TextField.setDataType(0);
        KDTDefaultCellEditor kdtPolicyEntry_year_CellEditor = new KDTDefaultCellEditor(kdtPolicyEntry_year_TextField);
        this.kdtPolicyEntry.getColumn("year").setEditor(kdtPolicyEntry_year_CellEditor);
        KDDatePicker kdtPolicyEntry_beginDate_DatePicker = new KDDatePicker();
        kdtPolicyEntry_beginDate_DatePicker.setName("kdtPolicyEntry_beginDate_DatePicker");
        kdtPolicyEntry_beginDate_DatePicker.setVisible(true);
        kdtPolicyEntry_beginDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtPolicyEntry_beginDate_CellEditor = new KDTDefaultCellEditor(kdtPolicyEntry_beginDate_DatePicker);
        this.kdtPolicyEntry.getColumn("beginDate").setEditor(kdtPolicyEntry_beginDate_CellEditor);
        KDDatePicker kdtPolicyEntry_endDate_DatePicker = new KDDatePicker();
        kdtPolicyEntry_endDate_DatePicker.setName("kdtPolicyEntry_endDate_DatePicker");
        kdtPolicyEntry_endDate_DatePicker.setVisible(true);
        kdtPolicyEntry_endDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtPolicyEntry_endDate_CellEditor = new KDTDefaultCellEditor(kdtPolicyEntry_endDate_DatePicker);
        this.kdtPolicyEntry.getColumn("endDate").setEditor(kdtPolicyEntry_endDate_CellEditor);
        KDCheckBox kdtPolicyEntry_isDefault_CheckBox = new KDCheckBox();
        kdtPolicyEntry_isDefault_CheckBox.setName("kdtPolicyEntry_isDefault_CheckBox");
        KDTDefaultCellEditor kdtPolicyEntry_isDefault_CellEditor = new KDTDefaultCellEditor(kdtPolicyEntry_isDefault_CheckBox);
        this.kdtPolicyEntry.getColumn("isDefault").setEditor(kdtPolicyEntry_isDefault_CellEditor);
        final KDBizPromptBox kdtPolicyEntry_breedData_PromptBox = new KDBizPromptBox();
        kdtPolicyEntry_breedData_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.BreedDataQuery");
        kdtPolicyEntry_breedData_PromptBox.setVisible(true);
        kdtPolicyEntry_breedData_PromptBox.setEditable(true);
        kdtPolicyEntry_breedData_PromptBox.setDisplayFormat("$number$");
        kdtPolicyEntry_breedData_PromptBox.setEditFormat("$number$");
        kdtPolicyEntry_breedData_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtPolicyEntry_breedData_CellEditor = new KDTDefaultCellEditor(kdtPolicyEntry_breedData_PromptBox);
        this.kdtPolicyEntry.getColumn("breedData").setEditor(kdtPolicyEntry_breedData_CellEditor);
        ObjectValueRender kdtPolicyEntry_breedData_OVR = new ObjectValueRender();
        kdtPolicyEntry_breedData_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtPolicyEntry.getColumn("breedData").setRenderer(kdtPolicyEntry_breedData_OVR);
        			kdtPolicyEntry_breedData_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI kdtPolicyEntry_breedData_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtPolicyEntry_breedData_PromptBox_F7ListUI == null) {
					try {
						kdtPolicyEntry_breedData_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtPolicyEntry_breedData_PromptBox_F7ListUI));
					kdtPolicyEntry_breedData_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtPolicyEntry_breedData_PromptBox.setSelector(kdtPolicyEntry_breedData_PromptBox_F7ListUI);
				}
			}
		});
					
        KDComboBox kdtPolicyEntry_subsidyType_ComboBox = new KDComboBox();
        kdtPolicyEntry_subsidyType_ComboBox.setName("kdtPolicyEntry_subsidyType_ComboBox");
        kdtPolicyEntry_subsidyType_ComboBox.setVisible(true);
        kdtPolicyEntry_subsidyType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.basedata.SubsidyType").toArray());
        KDTDefaultCellEditor kdtPolicyEntry_subsidyType_CellEditor = new KDTDefaultCellEditor(kdtPolicyEntry_subsidyType_ComboBox);
        this.kdtPolicyEntry.getColumn("subsidyType").setEditor(kdtPolicyEntry_subsidyType_CellEditor);
        KDFormattedTextField kdtPolicyEntry_subsidy_TextField = new KDFormattedTextField();
        kdtPolicyEntry_subsidy_TextField.setName("kdtPolicyEntry_subsidy_TextField");
        kdtPolicyEntry_subsidy_TextField.setVisible(true);
        kdtPolicyEntry_subsidy_TextField.setEditable(true);
        kdtPolicyEntry_subsidy_TextField.setHorizontalAlignment(2);
        kdtPolicyEntry_subsidy_TextField.setDataType(1);
        	kdtPolicyEntry_subsidy_TextField.setMinimumValue(new java.math.BigDecimal("-3.4028234663852886E38"));
        	kdtPolicyEntry_subsidy_TextField.setMaximumValue(new java.math.BigDecimal("3.4028234663852886E38"));
        kdtPolicyEntry_subsidy_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPolicyEntry_subsidy_CellEditor = new KDTDefaultCellEditor(kdtPolicyEntry_subsidy_TextField);
        this.kdtPolicyEntry.getColumn("subsidy").setEditor(kdtPolicyEntry_subsidy_CellEditor);
        // kdtFeedEntrys
		String kdtFeedEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"batchContract\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"conFeedPolicy\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"subsidyPrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"inDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"batchQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"recDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"inContractWgt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"subsidyAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"settleStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{batchContract}</t:Cell><t:Cell>$Resource{conFeedPolicy}</t:Cell><t:Cell>$Resource{subsidyPrice}</t:Cell><t:Cell>$Resource{inDate}</t:Cell><t:Cell>$Resource{batchQty}</t:Cell><t:Cell>$Resource{recDate}</t:Cell><t:Cell>$Resource{inContractWgt}</t:Cell><t:Cell>$Resource{subsidyAmount}</t:Cell><t:Cell>$Resource{settleStatus}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtFeedEntrys.setFormatXml(resHelper.translateString("kdtFeedEntrys",kdtFeedEntrysStrXML));

                this.kdtFeedEntrys.putBindContents("editData",new String[] {"seq","batchContract","conFeedPolicy","subsidyPrice","inDate","batchQty","recDate","inContractWgt","subsidyAmount","settleStatus"});


        this.kdtFeedEntrys.checkParsed();
        KDFormattedTextField kdtFeedEntrys_seq_TextField = new KDFormattedTextField();
        kdtFeedEntrys_seq_TextField.setName("kdtFeedEntrys_seq_TextField");
        kdtFeedEntrys_seq_TextField.setVisible(true);
        kdtFeedEntrys_seq_TextField.setEditable(true);
        kdtFeedEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtFeedEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtFeedEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtFeedEntrys_seq_TextField);
        this.kdtFeedEntrys.getColumn("seq").setEditor(kdtFeedEntrys_seq_CellEditor);
        final KDBizPromptBox kdtFeedEntrys_batchContract_PromptBox = new KDBizPromptBox();
        kdtFeedEntrys_batchContract_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.feedbiz.app.BatchContractBillQuery");
        kdtFeedEntrys_batchContract_PromptBox.setVisible(true);
        kdtFeedEntrys_batchContract_PromptBox.setEditable(true);
        kdtFeedEntrys_batchContract_PromptBox.setDisplayFormat("$number$");
        kdtFeedEntrys_batchContract_PromptBox.setEditFormat("$number$");
        kdtFeedEntrys_batchContract_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtFeedEntrys_batchContract_CellEditor = new KDTDefaultCellEditor(kdtFeedEntrys_batchContract_PromptBox);
        this.kdtFeedEntrys.getColumn("batchContract").setEditor(kdtFeedEntrys_batchContract_CellEditor);
        ObjectValueRender kdtFeedEntrys_batchContract_OVR = new ObjectValueRender();
        kdtFeedEntrys_batchContract_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtFeedEntrys.getColumn("batchContract").setRenderer(kdtFeedEntrys_batchContract_OVR);
        final KDBizPromptBox kdtFeedEntrys_conFeedPolicy_PromptBox = new KDBizPromptBox();
        kdtFeedEntrys_conFeedPolicy_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.ConFeedPolicyQuery");
        kdtFeedEntrys_conFeedPolicy_PromptBox.setVisible(true);
        kdtFeedEntrys_conFeedPolicy_PromptBox.setEditable(true);
        kdtFeedEntrys_conFeedPolicy_PromptBox.setDisplayFormat("$number$");
        kdtFeedEntrys_conFeedPolicy_PromptBox.setEditFormat("$number$");
        kdtFeedEntrys_conFeedPolicy_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtFeedEntrys_conFeedPolicy_CellEditor = new KDTDefaultCellEditor(kdtFeedEntrys_conFeedPolicy_PromptBox);
        this.kdtFeedEntrys.getColumn("conFeedPolicy").setEditor(kdtFeedEntrys_conFeedPolicy_CellEditor);
        ObjectValueRender kdtFeedEntrys_conFeedPolicy_OVR = new ObjectValueRender();
        kdtFeedEntrys_conFeedPolicy_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtFeedEntrys.getColumn("conFeedPolicy").setRenderer(kdtFeedEntrys_conFeedPolicy_OVR);
        			EntityViewInfo evikdtFeedEntrys_conFeedPolicy_PromptBox = new EntityViewInfo ();
		evikdtFeedEntrys_conFeedPolicy_PromptBox.setFilter(com.kingdee.eas.framework.FrameWorkUtils.getF7FilterInfoByAuthorizedOrg(com.kingdee.eas.basedata.org.OrgType.getEnum("Company"),"FICompany.id"));
		kdtFeedEntrys_conFeedPolicy_PromptBox.setEntityViewInfo(evikdtFeedEntrys_conFeedPolicy_PromptBox);
					
        			kdtFeedEntrys_conFeedPolicy_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.ConFeedPolicyListUI kdtFeedEntrys_conFeedPolicy_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtFeedEntrys_conFeedPolicy_PromptBox_F7ListUI == null) {
					try {
						kdtFeedEntrys_conFeedPolicy_PromptBox_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.ConFeedPolicyListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtFeedEntrys_conFeedPolicy_PromptBox_F7ListUI));
					kdtFeedEntrys_conFeedPolicy_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtFeedEntrys_conFeedPolicy_PromptBox.setSelector(kdtFeedEntrys_conFeedPolicy_PromptBox_F7ListUI);
				}
			}
		});
					
        KDFormattedTextField kdtFeedEntrys_subsidyPrice_TextField = new KDFormattedTextField();
        kdtFeedEntrys_subsidyPrice_TextField.setName("kdtFeedEntrys_subsidyPrice_TextField");
        kdtFeedEntrys_subsidyPrice_TextField.setVisible(true);
        kdtFeedEntrys_subsidyPrice_TextField.setEditable(true);
        kdtFeedEntrys_subsidyPrice_TextField.setHorizontalAlignment(2);
        kdtFeedEntrys_subsidyPrice_TextField.setDataType(1);
        	kdtFeedEntrys_subsidyPrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtFeedEntrys_subsidyPrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtFeedEntrys_subsidyPrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtFeedEntrys_subsidyPrice_CellEditor = new KDTDefaultCellEditor(kdtFeedEntrys_subsidyPrice_TextField);
        this.kdtFeedEntrys.getColumn("subsidyPrice").setEditor(kdtFeedEntrys_subsidyPrice_CellEditor);
        KDDatePicker kdtFeedEntrys_inDate_DatePicker = new KDDatePicker();
        kdtFeedEntrys_inDate_DatePicker.setName("kdtFeedEntrys_inDate_DatePicker");
        kdtFeedEntrys_inDate_DatePicker.setVisible(true);
        kdtFeedEntrys_inDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtFeedEntrys_inDate_CellEditor = new KDTDefaultCellEditor(kdtFeedEntrys_inDate_DatePicker);
        this.kdtFeedEntrys.getColumn("inDate").setEditor(kdtFeedEntrys_inDate_CellEditor);
        KDFormattedTextField kdtFeedEntrys_batchQty_TextField = new KDFormattedTextField();
        kdtFeedEntrys_batchQty_TextField.setName("kdtFeedEntrys_batchQty_TextField");
        kdtFeedEntrys_batchQty_TextField.setVisible(true);
        kdtFeedEntrys_batchQty_TextField.setEditable(true);
        kdtFeedEntrys_batchQty_TextField.setHorizontalAlignment(2);
        kdtFeedEntrys_batchQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtFeedEntrys_batchQty_CellEditor = new KDTDefaultCellEditor(kdtFeedEntrys_batchQty_TextField);
        this.kdtFeedEntrys.getColumn("batchQty").setEditor(kdtFeedEntrys_batchQty_CellEditor);
        KDDatePicker kdtFeedEntrys_recDate_DatePicker = new KDDatePicker();
        kdtFeedEntrys_recDate_DatePicker.setName("kdtFeedEntrys_recDate_DatePicker");
        kdtFeedEntrys_recDate_DatePicker.setVisible(true);
        kdtFeedEntrys_recDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtFeedEntrys_recDate_CellEditor = new KDTDefaultCellEditor(kdtFeedEntrys_recDate_DatePicker);
        this.kdtFeedEntrys.getColumn("recDate").setEditor(kdtFeedEntrys_recDate_CellEditor);
        KDFormattedTextField kdtFeedEntrys_inContractWgt_TextField = new KDFormattedTextField();
        kdtFeedEntrys_inContractWgt_TextField.setName("kdtFeedEntrys_inContractWgt_TextField");
        kdtFeedEntrys_inContractWgt_TextField.setVisible(true);
        kdtFeedEntrys_inContractWgt_TextField.setEditable(true);
        kdtFeedEntrys_inContractWgt_TextField.setHorizontalAlignment(2);
        kdtFeedEntrys_inContractWgt_TextField.setDataType(1);
        	kdtFeedEntrys_inContractWgt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtFeedEntrys_inContractWgt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtFeedEntrys_inContractWgt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtFeedEntrys_inContractWgt_CellEditor = new KDTDefaultCellEditor(kdtFeedEntrys_inContractWgt_TextField);
        this.kdtFeedEntrys.getColumn("inContractWgt").setEditor(kdtFeedEntrys_inContractWgt_CellEditor);
        KDFormattedTextField kdtFeedEntrys_subsidyAmount_TextField = new KDFormattedTextField();
        kdtFeedEntrys_subsidyAmount_TextField.setName("kdtFeedEntrys_subsidyAmount_TextField");
        kdtFeedEntrys_subsidyAmount_TextField.setVisible(true);
        kdtFeedEntrys_subsidyAmount_TextField.setEditable(true);
        kdtFeedEntrys_subsidyAmount_TextField.setHorizontalAlignment(2);
        kdtFeedEntrys_subsidyAmount_TextField.setDataType(1);
        	kdtFeedEntrys_subsidyAmount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtFeedEntrys_subsidyAmount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtFeedEntrys_subsidyAmount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtFeedEntrys_subsidyAmount_CellEditor = new KDTDefaultCellEditor(kdtFeedEntrys_subsidyAmount_TextField);
        this.kdtFeedEntrys.getColumn("subsidyAmount").setEditor(kdtFeedEntrys_subsidyAmount_CellEditor);
        KDTextField kdtFeedEntrys_settleStatus_TextField = new KDTextField();
        kdtFeedEntrys_settleStatus_TextField.setName("kdtFeedEntrys_settleStatus_TextField");
        kdtFeedEntrys_settleStatus_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtFeedEntrys_settleStatus_CellEditor = new KDTDefaultCellEditor(kdtFeedEntrys_settleStatus_TextField);
        this.kdtFeedEntrys.getColumn("settleStatus").setEditor(kdtFeedEntrys_settleStatus_CellEditor);
        // contremark		
        this.contremark.setBoundLabelText(resHelper.getString("contremark.boundLabelText"));		
        this.contremark.setBoundLabelLength(0);		
        this.contremark.setBoundLabelUnderline(true);		
        this.contremark.setVisible(true);
        // scrollPaneremark
        // txtremark		
        this.txtremark.setRequired(false);		
        this.txtremark.setMaxLength(255);
        // prmtperson		
        this.prmtperson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtperson.setEditable(true);		
        this.prmtperson.setDisplayFormat("$name$");		
        this.prmtperson.setEditFormat("$number$");		
        this.prmtperson.setCommitFormat("$number$");		
        this.prmtperson.setRequired(false);		
        this.prmtperson.setEnabled(false);
        // txtyear		
        this.txtyear.setHorizontalAlignment(2);		
        this.txtyear.setDataType(0);		
        this.txtyear.setSupportedEmpty(true);		
        this.txtyear.setRequired(false);
        // prmtfarmerType		
        this.prmtfarmerType.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerTypeQuery");		
        this.prmtfarmerType.setEditable(true);		
        this.prmtfarmerType.setDisplayFormat("$name$");		
        this.prmtfarmerType.setEditFormat("$number$");		
        this.prmtfarmerType.setCommitFormat("$number$");		
        this.prmtfarmerType.setRequired(false);		
        this.prmtfarmerType.setEnabled(false);
        		EntityViewInfo eviprmtfarmerType = new EntityViewInfo ();
		eviprmtfarmerType.setFilter(com.kingdee.eas.framework.FrameWorkUtils.getF7FilterInfoByAuthorizedOrg(com.kingdee.eas.basedata.org.OrgType.getEnum("Company"),"FICompany.id"));
		prmtfarmerType.setEntityViewInfo(eviprmtfarmerType);
					
        // txtidentity		
        this.txtidentity.setHorizontalAlignment(2);		
        this.txtidentity.setMaxLength(80);		
        this.txtidentity.setRequired(false);		
        this.txtidentity.setEnabled(false);
        // txtfarmAddress		
        this.txtfarmAddress.setHorizontalAlignment(2);		
        this.txtfarmAddress.setMaxLength(80);		
        this.txtfarmAddress.setRequired(false);		
        this.txtfarmAddress.setEnabled(false);
        // txtinitSettledNum		
        this.txtinitSettledNum.setHorizontalAlignment(2);		
        this.txtinitSettledNum.setDataType(0);		
        this.txtinitSettledNum.setSupportedEmpty(true);		
        this.txtinitSettledNum.setRequired(false);
        // txtcurSettledNum		
        this.txtcurSettledNum.setHorizontalAlignment(2);		
        this.txtcurSettledNum.setDataType(0);		
        this.txtcurSettledNum.setSupportedEmpty(true);		
        this.txtcurSettledNum.setRequired(false);		
        this.txtcurSettledNum.setEnabled(false);
        // txtinitSubsidies		
        this.txtinitSubsidies.setHorizontalAlignment(2);		
        this.txtinitSubsidies.setDataType(1);		
        this.txtinitSubsidies.setSupportedEmpty(true);		
        this.txtinitSubsidies.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtinitSubsidies.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtinitSubsidies.setPrecision(2);		
        this.txtinitSubsidies.setRequired(false);
        // txtcumulativeSub		
        this.txtcumulativeSub.setHorizontalAlignment(2);		
        this.txtcumulativeSub.setDataType(1);		
        this.txtcumulativeSub.setSupportedEmpty(true);		
        this.txtcumulativeSub.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcumulativeSub.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcumulativeSub.setPrecision(2);		
        this.txtcumulativeSub.setRequired(false);		
        this.txtcumulativeSub.setEnabled(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        // btnUpdateFeed
        this.btnUpdateFeed.setAction((IItemAction)ActionProxyFactory.getProxy(actionUpdateFeed, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUpdateFeed.setText(resHelper.getString("btnUpdateFeed.text"));		
        this.btnUpdateFeed.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_demandnoncedata"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtremark,txtNumber,pkBizDate,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,prmtcontractType,pkbeginDate,pkendDate,txtsuccessiveQty,billStatus,pkauditTime,prmtcompany,prmtfarmer,prmtfarm,txtgm,prmtperson,txtyear,prmtfarmerType,txtidentity,txtfarmAddress,txtinitSettledNum,txtcurSettledNum,txtinitSubsidies,txtcumulativeSub,kdtFeedEntrys,kdtPolicyEntry}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 546));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1013, 546));
        contCreator.setBounds(new Rectangle(369, 462, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(369, 462, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(719, 462, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(719, 462, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(369, 493, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(369, 493, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(719, 493, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(719, 493, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(29, 19, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(29, 19, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(29, 190, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(29, 190, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(26, 464, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(26, 464, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcontractType.setBounds(new Rectangle(374, 19, 270, 19));
        this.add(contcontractType, new KDLayout.Constraints(374, 19, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbeginDate.setBounds(new Rectangle(374, 190, 270, 19));
        this.add(contbeginDate, new KDLayout.Constraints(374, 190, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contendDate.setBounds(new Rectangle(707, 190, 270, 19));
        this.add(contendDate, new KDLayout.Constraints(707, 190, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contsuccessiveQty.setBounds(new Rectangle(374, 75, 270, 19));
        this.add(contsuccessiveQty, new KDLayout.Constraints(374, 75, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(707, 19, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(707, 19, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contauditTime.setBounds(new Rectangle(26, 495, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(26, 495, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompany.setBounds(new Rectangle(29, 47, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(29, 47, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmer.setBounds(new Rectangle(374, 47, 270, 19));
        this.add(contfarmer, new KDLayout.Constraints(374, 47, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarm.setBounds(new Rectangle(707, 47, 270, 19));
        this.add(contfarm, new KDLayout.Constraints(707, 47, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contgm.setBounds(new Rectangle(707, 75, 270, 19));
        this.add(contgm, new KDLayout.Constraints(707, 75, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDTabbedPane1.setBounds(new Rectangle(24, 229, 973, 216));
        this.add(kDTabbedPane1, new KDLayout.Constraints(24, 229, 973, 216, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contperson.setBounds(new Rectangle(707, 103, 270, 19));
        this.add(contperson, new KDLayout.Constraints(707, 103, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contyear.setBounds(new Rectangle(29, 75, 270, 19));
        this.add(contyear, new KDLayout.Constraints(29, 75, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmerType.setBounds(new Rectangle(29, 131, 270, 19));
        this.add(contfarmerType, new KDLayout.Constraints(29, 131, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contidentity.setBounds(new Rectangle(29, 103, 270, 19));
        this.add(contidentity, new KDLayout.Constraints(29, 103, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmAddress.setBounds(new Rectangle(374, 103, 270, 19));
        this.add(contfarmAddress, new KDLayout.Constraints(374, 103, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        continitSettledNum.setBounds(new Rectangle(374, 131, 270, 19));
        this.add(continitSettledNum, new KDLayout.Constraints(374, 131, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcurSettledNum.setBounds(new Rectangle(707, 131, 270, 19));
        this.add(contcurSettledNum, new KDLayout.Constraints(707, 131, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        continitSubsidies.setBounds(new Rectangle(29, 159, 270, 19));
        this.add(continitSubsidies, new KDLayout.Constraints(29, 159, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcumulativeSub.setBounds(new Rectangle(374, 159, 270, 19));
        this.add(contcumulativeSub, new KDLayout.Constraints(374, 159, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contAuditor
        contAuditor.setBoundEditor(prmtAuditor);
        //contcontractType
        contcontractType.setBoundEditor(prmtcontractType);
        //contbeginDate
        contbeginDate.setBoundEditor(pkbeginDate);
        //contendDate
        contendDate.setBoundEditor(pkendDate);
        //contsuccessiveQty
        contsuccessiveQty.setBoundEditor(txtsuccessiveQty);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contfarmer
        contfarmer.setBoundEditor(prmtfarmer);
        //contfarm
        contfarm.setBoundEditor(prmtfarm);
        //contgm
        contgm.setBoundEditor(txtgm);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 972, 183));        kdtPolicyEntry.setBounds(new Rectangle(7, 5, 951, 170));
        kdtPolicyEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtPolicyEntry,new com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractPolicyEntryInfo(),null,false);
        kDPanel1.add(kdtPolicyEntry_detailPanel, new KDLayout.Constraints(7, 5, 951, 170, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtPolicyEntry_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("subsidyType","0");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //kDPanel3
        kDPanel3.setLayout(new KDLayout());
        kDPanel3.putClientProperty("OriginalBounds", new Rectangle(0, 0, 972, 183));        kdtFeedEntrys.setBounds(new Rectangle(2, 2, 962, 178));
        kdtFeedEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtFeedEntrys,new com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractFeedEntryInfo(),null,false);
        kDPanel3.add(kdtFeedEntrys_detailPanel, new KDLayout.Constraints(2, 2, 962, 178, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 972, 183));        contremark.setBounds(new Rectangle(13, 12, 944, 159));
        kDPanel2.add(contremark, new KDLayout.Constraints(13, 12, 944, 159, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contremark
        contremark.setBoundEditor(scrollPaneremark);
        //scrollPaneremark
        scrollPaneremark.getViewport().add(txtremark, null);
        //contperson
        contperson.setBoundEditor(prmtperson);
        //contyear
        contyear.setBoundEditor(txtyear);
        //contfarmerType
        contfarmerType.setBoundEditor(prmtfarmerType);
        //contidentity
        contidentity.setBoundEditor(txtidentity);
        //contfarmAddress
        contfarmAddress.setBoundEditor(txtfarmAddress);
        //continitSettledNum
        continitSettledNum.setBoundEditor(txtinitSettledNum);
        //contcurSettledNum
        contcurSettledNum.setBoundEditor(txtcurSettledNum);
        //continitSubsidies
        continitSubsidies.setBoundEditor(txtinitSubsidies);
        //contcumulativeSub
        contcumulativeSub.setBoundEditor(txtcumulativeSub);

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
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);
        this.toolBar.add(btnCopy);
        this.toolBar.add(btnRemove);
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
        this.toolBar.add(btnUpdateFeed);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("contractType", com.kingdee.eas.custom.signwasthetable.ContractTypeInfo.class, this.prmtcontractType, "data");
		dataBinder.registerBinding("beginDate", java.util.Date.class, this.pkbeginDate, "value");
		dataBinder.registerBinding("endDate", java.util.Date.class, this.pkendDate, "value");
		dataBinder.registerBinding("successiveQty", int.class, this.txtsuccessiveQty, "value");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("farmer", com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo.class, this.prmtfarmer, "data");
		dataBinder.registerBinding("farm", com.kingdee.eas.farm.carnivorous.basedata.FarmInfo.class, this.prmtfarm, "data");
		dataBinder.registerBinding("gm", String.class, this.txtgm, "text");
		dataBinder.registerBinding("PolicyEntry.seq", int.class, this.kdtPolicyEntry, "seq.text");
		dataBinder.registerBinding("PolicyEntry", com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractPolicyEntryInfo.class, this.kdtPolicyEntry, "userObject");
		dataBinder.registerBinding("PolicyEntry.confeedPolicy", java.lang.Object.class, this.kdtPolicyEntry, "confeedPolicy.text");
		dataBinder.registerBinding("PolicyEntry.beginDate", java.util.Date.class, this.kdtPolicyEntry, "beginDate.text");
		dataBinder.registerBinding("PolicyEntry.endDate", java.util.Date.class, this.kdtPolicyEntry, "endDate.text");
		dataBinder.registerBinding("PolicyEntry.isDefault", boolean.class, this.kdtPolicyEntry, "isDefault.text");
		dataBinder.registerBinding("PolicyEntry.year", int.class, this.kdtPolicyEntry, "year.text");
		dataBinder.registerBinding("PolicyEntry.breedData", java.lang.Object.class, this.kdtPolicyEntry, "breedData.text");
		dataBinder.registerBinding("PolicyEntry.subsidyType", com.kingdee.util.enums.Enum.class, this.kdtPolicyEntry, "subsidyType.text");
		dataBinder.registerBinding("PolicyEntry.subsidy", java.math.BigDecimal.class, this.kdtPolicyEntry, "subsidy.text");
		dataBinder.registerBinding("FeedEntrys.seq", int.class, this.kdtFeedEntrys, "seq.text");
		dataBinder.registerBinding("FeedEntrys", com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractFeedEntryInfo.class, this.kdtFeedEntrys, "userObject");
		dataBinder.registerBinding("FeedEntrys.batchContract", java.lang.Object.class, this.kdtFeedEntrys, "batchContract.text");
		dataBinder.registerBinding("FeedEntrys.conFeedPolicy", java.lang.Object.class, this.kdtFeedEntrys, "conFeedPolicy.text");
		dataBinder.registerBinding("FeedEntrys.subsidyPrice", java.math.BigDecimal.class, this.kdtFeedEntrys, "subsidyPrice.text");
		dataBinder.registerBinding("FeedEntrys.inDate", java.util.Date.class, this.kdtFeedEntrys, "inDate.text");
		dataBinder.registerBinding("FeedEntrys.batchQty", int.class, this.kdtFeedEntrys, "batchQty.text");
		dataBinder.registerBinding("FeedEntrys.recDate", java.util.Date.class, this.kdtFeedEntrys, "recDate.text");
		dataBinder.registerBinding("FeedEntrys.subsidyAmount", java.math.BigDecimal.class, this.kdtFeedEntrys, "subsidyAmount.text");
		dataBinder.registerBinding("FeedEntrys.settleStatus", String.class, this.kdtFeedEntrys, "settleStatus.text");
		dataBinder.registerBinding("FeedEntrys.inContractWgt", java.math.BigDecimal.class, this.kdtFeedEntrys, "inContractWgt.text");
		dataBinder.registerBinding("remark", String.class, this.txtremark, "text");
		dataBinder.registerBinding("person", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtperson, "data");
		dataBinder.registerBinding("year", int.class, this.txtyear, "value");
		dataBinder.registerBinding("farmerType", com.kingdee.eas.farm.carnivorous.basedata.FarmerTypeInfo.class, this.prmtfarmerType, "data");
		dataBinder.registerBinding("identity", String.class, this.txtidentity, "text");
		dataBinder.registerBinding("farmAddress", String.class, this.txtfarmAddress, "text");
		dataBinder.registerBinding("initSettledNum", int.class, this.txtinitSettledNum, "value");
		dataBinder.registerBinding("curSettledNum", int.class, this.txtcurSettledNum, "value");
		dataBinder.registerBinding("initSubsidies", java.math.BigDecimal.class, this.txtinitSubsidies, "value");
		dataBinder.registerBinding("cumulativeSub", java.math.BigDecimal.class, this.txtcumulativeSub, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.carnivorous.feedbiz.app.ConFeedContractEditUIHandler";
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
        this.txtremark.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractInfo)ov;
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
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contractType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("beginDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("endDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("successiveQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("gm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PolicyEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PolicyEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PolicyEntry.confeedPolicy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PolicyEntry.beginDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PolicyEntry.endDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PolicyEntry.isDefault", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PolicyEntry.year", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PolicyEntry.breedData", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PolicyEntry.subsidyType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PolicyEntry.subsidy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FeedEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FeedEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FeedEntrys.batchContract", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FeedEntrys.conFeedPolicy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FeedEntrys.subsidyPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FeedEntrys.inDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FeedEntrys.batchQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FeedEntrys.recDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FeedEntrys.subsidyAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FeedEntrys.settleStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FeedEntrys.inContractWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("person", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("year", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmerType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("identity", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmAddress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("initSettledNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("curSettledNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("initSubsidies", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cumulativeSub", ValidateHelper.ON_SAVE);    		
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
     * output prmtfarmer_Changed() method
     */
    public void prmtfarmer_Changed() throws Exception
    {
        System.out.println("prmtfarmer_Changed() Function is executed!");
            txtidentity.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtfarmer.getData(),"identity")));


    }

    /**
     * output prmtfarm_Changed() method
     */
    public void prmtfarm_Changed() throws Exception
    {
        System.out.println("prmtfarm_Changed() Function is executed!");
            txtfarmAddress.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtfarm.getData(),"address")));


    }

    /**
     * output kdtPolicyEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtPolicyEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("confeedPolicy".equalsIgnoreCase(kdtPolicyEntry.getColumn(colIndex).getKey())) {
kdtPolicyEntry.getCell(rowIndex,"subsidyType").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtPolicyEntry.getCell(rowIndex,"confeedPolicy").getValue(),"subsidyType"));

}

    if ("confeedPolicy".equalsIgnoreCase(kdtPolicyEntry.getColumn(colIndex).getKey())) {
kdtPolicyEntry.getCell(rowIndex,"subsidy").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtPolicyEntry.getCell(rowIndex,"confeedPolicy").getValue(),"subsidy")));

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
			sic.add(new SelectorItemInfo("contractType.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("contractType.id"));
        	sic.add(new SelectorItemInfo("contractType.number"));
        	sic.add(new SelectorItemInfo("contractType.name"));
		}
        sic.add(new SelectorItemInfo("beginDate"));
        sic.add(new SelectorItemInfo("endDate"));
        sic.add(new SelectorItemInfo("successiveQty"));
        sic.add(new SelectorItemInfo("billStatus"));
        sic.add(new SelectorItemInfo("auditTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("farmer.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farmer.id"));
        	sic.add(new SelectorItemInfo("farmer.number"));
        	sic.add(new SelectorItemInfo("farmer.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("farm.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farm.id"));
        	sic.add(new SelectorItemInfo("farm.number"));
        	sic.add(new SelectorItemInfo("farm.name"));
		}
        sic.add(new SelectorItemInfo("gm"));
    	sic.add(new SelectorItemInfo("PolicyEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("PolicyEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("PolicyEntry.confeedPolicy.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("PolicyEntry.confeedPolicy.id"));
			sic.add(new SelectorItemInfo("PolicyEntry.confeedPolicy.name"));
        	sic.add(new SelectorItemInfo("PolicyEntry.confeedPolicy.number"));
		}
    	sic.add(new SelectorItemInfo("PolicyEntry.beginDate"));
    	sic.add(new SelectorItemInfo("PolicyEntry.endDate"));
    	sic.add(new SelectorItemInfo("PolicyEntry.isDefault"));
    	sic.add(new SelectorItemInfo("PolicyEntry.year"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("PolicyEntry.breedData.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("PolicyEntry.breedData.id"));
			sic.add(new SelectorItemInfo("PolicyEntry.breedData.name"));
        	sic.add(new SelectorItemInfo("PolicyEntry.breedData.number"));
		}
    	sic.add(new SelectorItemInfo("PolicyEntry.subsidyType"));
    	sic.add(new SelectorItemInfo("PolicyEntry.subsidy"));
    	sic.add(new SelectorItemInfo("FeedEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FeedEntrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FeedEntrys.batchContract.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("FeedEntrys.batchContract.id"));
			sic.add(new SelectorItemInfo("FeedEntrys.batchContract.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FeedEntrys.conFeedPolicy.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("FeedEntrys.conFeedPolicy.id"));
			sic.add(new SelectorItemInfo("FeedEntrys.conFeedPolicy.number"));
			sic.add(new SelectorItemInfo("FeedEntrys.conFeedPolicy.name"));
		}
    	sic.add(new SelectorItemInfo("FeedEntrys.subsidyPrice"));
    	sic.add(new SelectorItemInfo("FeedEntrys.inDate"));
    	sic.add(new SelectorItemInfo("FeedEntrys.batchQty"));
    	sic.add(new SelectorItemInfo("FeedEntrys.recDate"));
    	sic.add(new SelectorItemInfo("FeedEntrys.subsidyAmount"));
    	sic.add(new SelectorItemInfo("FeedEntrys.settleStatus"));
    	sic.add(new SelectorItemInfo("FeedEntrys.inContractWgt"));
        sic.add(new SelectorItemInfo("remark"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("person.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("person.id"));
        	sic.add(new SelectorItemInfo("person.number"));
        	sic.add(new SelectorItemInfo("person.name"));
		}
        sic.add(new SelectorItemInfo("year"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("farmerType.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farmerType.id"));
        	sic.add(new SelectorItemInfo("farmerType.number"));
        	sic.add(new SelectorItemInfo("farmerType.name"));
		}
        sic.add(new SelectorItemInfo("identity"));
        sic.add(new SelectorItemInfo("farmAddress"));
        sic.add(new SelectorItemInfo("initSettledNum"));
        sic.add(new SelectorItemInfo("curSettledNum"));
        sic.add(new SelectorItemInfo("initSubsidies"));
        sic.add(new SelectorItemInfo("cumulativeSub"));
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
        com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionUpdateFeed_actionPerformed method
     */
    public void actionUpdateFeed_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractFactory.getRemoteInstance().updateFeed(editData);
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
	public RequestContext prepareActionUpdateFeed(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionUpdateFeed() {
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
            innerActionPerformed("eas", AbstractConFeedContractEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractConFeedContractEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionUpdateFeed class
     */     
    protected class ActionUpdateFeed extends ItemAction {     
    
        public ActionUpdateFeed()
        {
            this(null);
        }

        public ActionUpdateFeed(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionUpdateFeed.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUpdateFeed.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUpdateFeed.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractConFeedContractEditUI.this, "ActionUpdateFeed", "actionUpdateFeed_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.feedbiz.client", "ConFeedContractEditUI");
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
        return com.kingdee.eas.farm.carnivorous.feedbiz.client.ConFeedContractEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractInfo objectValue = new com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/carnivorous/feedbiz/ConFeedContract";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.carnivorous.feedbiz.app.ConFeedContractQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtNumber.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"单据编号"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkbeginDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"合同开始日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkendDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"合同终止日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"公司"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtfarmer.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖户"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtfarm.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖场"});
		}
		for (int i=0,n=kdtPolicyEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtPolicyEntry.getCell(i,"confeedPolicy").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"连养政策"});
			}
		}
		for (int i=0,n=kdtPolicyEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtPolicyEntry.getCell(i,"beginDate").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"起始日期"});
			}
		}
		for (int i=0,n=kdtPolicyEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtPolicyEntry.getCell(i,"endDate").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"终止日期"});
			}
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtPolicyEntry;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("billStatus",new Integer(-1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}