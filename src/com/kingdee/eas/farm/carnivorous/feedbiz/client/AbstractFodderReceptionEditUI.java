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
public abstract class AbstractFodderReceptionEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractFodderReceptionEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator9;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisInit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdriver;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcarNo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlinkCell;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbizPerson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contvoucherNum;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisHasMaterialReq;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contreturnCompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfodderSourceType;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisHasSaleOrder;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisHasSaleReturn;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatchContract;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatch;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsettlePolicy;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweekDay;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contindate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatchQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsupplier;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcar;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisTiLiao;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisOtherIssue;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisHasSaleIssue;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisFromTiaoLiao;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisSanZhuang;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmerPhone;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmAddress;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisWeight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbunker;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contreturnOpinion;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcostCenter;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedData;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfeedInstance;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontractQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallowProcess;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstorageOrgUnit;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtdriver;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcarNo;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtlinkCell;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbizPerson;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperson;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billType;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtvoucherNum;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtreturnCompany;
    protected com.kingdee.bos.ctrl.swing.KDComboBox fodderSourceType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarm;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbatchContract;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbatch;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsettlePolicy;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtweekDay;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkindate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbatchQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsupplier;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcar;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfarmerPhone;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfarmAddress;
    protected com.kingdee.bos.ctrl.swing.KDComboBox bunker;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtreturnOpinion;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcostCenter;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbreedData;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfeedInstance;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contearlyStand;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contearlyVou;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contearlyAudit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contearlyUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contearlyAllow;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmidStand;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmidVouch;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmidAudit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmidUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmidAllow;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlateStand;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlateVoucher;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlateAudit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlateUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlateAllow;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtearlyStand;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtearlyVou;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtearlyAudit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtearlyUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtearlyAllow;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmidStand;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmidVouch;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmidAudit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmidUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmidAllow;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtlateStand;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtlateVoucher;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtlateAudit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtlateUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtlateAllow;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcontractQty;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtallowProcess;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnClose;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnClose;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnViewStdUse;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDSeparator newSeparator3;
    protected com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionViewStdUse actionViewStdUse = null;
    protected ActionChkVoucherFlag actionChkVoucherFlag = null;
    protected ActionChkVoucherAll actionChkVoucherAll = null;
    protected ActionBatchSubmit actionBatchSubmit = null;
    protected ActionClose actionClose = null;
    protected ActionUnClose actionUnClose = null;
    protected ActionUpdatePrice actionUpdatePrice = null;
    /**
     * output class constructor
     */
    public AbstractFodderReceptionEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractFodderReceptionEditUI.class.getName());
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
        this.actionSubmit.setExtendProperty("userDefined", "false");
        this.actionSubmit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
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
        this.actionAudit.setExtendProperty("userDefined", "false");
        this.actionAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionUnAudit
        this.actionUnAudit = new ActionUnAudit(this);
        getActionManager().registerAction("actionUnAudit", actionUnAudit);
        this.actionUnAudit.setExtendProperty("canForewarn", "true");
        this.actionUnAudit.setExtendProperty("userDefined", "false");
        this.actionUnAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionViewStdUse
        this.actionViewStdUse = new ActionViewStdUse(this);
        getActionManager().registerAction("actionViewStdUse", actionViewStdUse);
        this.actionViewStdUse.setExtendProperty("canForewarn", "true");
        this.actionViewStdUse.setExtendProperty("userDefined", "false");
        this.actionViewStdUse.setExtendProperty("isObjectUpdateLock", "false");
         this.actionViewStdUse.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionViewStdUse.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionChkVoucherFlag
        this.actionChkVoucherFlag = new ActionChkVoucherFlag(this);
        getActionManager().registerAction("actionChkVoucherFlag", actionChkVoucherFlag);
        this.actionChkVoucherFlag.setExtendProperty("canForewarn", "true");
        this.actionChkVoucherFlag.setExtendProperty("userDefined", "false");
        this.actionChkVoucherFlag.setExtendProperty("isObjectUpdateLock", "false");
         this.actionChkVoucherFlag.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionChkVoucherFlag.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionChkVoucherAll
        this.actionChkVoucherAll = new ActionChkVoucherAll(this);
        getActionManager().registerAction("actionChkVoucherAll", actionChkVoucherAll);
        this.actionChkVoucherAll.setExtendProperty("canForewarn", "true");
        this.actionChkVoucherAll.setExtendProperty("userDefined", "false");
        this.actionChkVoucherAll.setExtendProperty("isObjectUpdateLock", "false");
         this.actionChkVoucherAll.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionChkVoucherAll.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionBatchSubmit
        this.actionBatchSubmit = new ActionBatchSubmit(this);
        getActionManager().registerAction("actionBatchSubmit", actionBatchSubmit);
        this.actionBatchSubmit.setBindWorkFlow(true);
        this.actionBatchSubmit.setExtendProperty("canForewarn", "true");
        this.actionBatchSubmit.setExtendProperty("userDefined", "false");
        this.actionBatchSubmit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionBatchSubmit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionBatchSubmit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionBatchSubmit.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionClose
        this.actionClose = new ActionClose(this);
        getActionManager().registerAction("actionClose", actionClose);
        this.actionClose.setBindWorkFlow(true);
        this.actionClose.setExtendProperty("canForewarn", "true");
        this.actionClose.setExtendProperty("userDefined", "true");
        this.actionClose.setExtendProperty("isObjectUpdateLock", "false");
         this.actionClose.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionClose.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionClose.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionUnClose
        this.actionUnClose = new ActionUnClose(this);
        getActionManager().registerAction("actionUnClose", actionUnClose);
        this.actionUnClose.setBindWorkFlow(true);
        this.actionUnClose.setExtendProperty("canForewarn", "true");
        this.actionUnClose.setExtendProperty("userDefined", "true");
        this.actionUnClose.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnClose.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnClose.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionUnClose.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionUpdatePrice
        this.actionUpdatePrice = new ActionUpdatePrice(this);
        getActionManager().registerAction("actionUpdatePrice", actionUpdatePrice);
        this.actionUpdatePrice.setExtendProperty("canForewarn", "true");
        this.actionUpdatePrice.setExtendProperty("userDefined", "true");
        this.actionUpdatePrice.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUpdatePrice.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUpdatePrice.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDSeparator9 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contstorageOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisInit = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contdriver = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcarNo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlinkCell = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbizPerson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contvoucherNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisHasMaterialReq = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contreturnCompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfodderSourceType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisHasSaleOrder = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisHasSaleReturn = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contfarmer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbatchContract = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbatch = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsettlePolicy = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweekDay = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contindate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbatchQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsupplier = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcar = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisTiLiao = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisOtherIssue = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisHasSaleIssue = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisFromTiaoLiao = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisSanZhuang = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contfarmerPhone = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmAddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisWeight = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contbunker = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contreturnOpinion = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcostCenter = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbreedData = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfeedInstance = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contcontractQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallowProcess = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtstorageOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtdriver = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtcarNo = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtlinkCell = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtbizPerson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtperson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.billType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtvoucherNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtreturnCompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.fodderSourceType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtfarmer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtfarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbatchContract = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbatch = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtsettlePolicy = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtweekDay = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkindate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtbatchQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtsupplier = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcar = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtfarmerPhone = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtfarmAddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.bunker = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtreturnOpinion = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtcostCenter = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbreedData = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtfeedInstance = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contearlyStand = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contearlyVou = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contearlyAudit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contearlyUnAudit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contearlyAllow = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmidStand = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmidVouch = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmidAudit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmidUnAudit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmidAllow = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlateStand = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlateVoucher = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlateAudit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlateUnAudit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlateAllow = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtearlyStand = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtearlyVou = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtearlyAudit = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtearlyUnAudit = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtearlyAllow = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmidStand = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmidVouch = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmidAudit = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmidUnAudit = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmidAllow = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtlateStand = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtlateVoucher = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtlateAudit = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtlateUnAudit = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtlateAllow = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcontractQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallowProcess = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.tBtnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnClose = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnClose = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnViewStdUse = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.mBtnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.mBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.newSeparator3 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.contbillStatus.setName("contbillStatus");
        this.contcompany.setName("contcompany");
        this.contauditTime.setName("contauditTime");
        this.kDSeparator8.setName("kDSeparator8");
        this.kDSeparator9.setName("kDSeparator9");
        this.contstorageOrgUnit.setName("contstorageOrgUnit");
        this.chkisInit.setName("chkisInit");
        this.contdriver.setName("contdriver");
        this.contcarNo.setName("contcarNo");
        this.contlinkCell.setName("contlinkCell");
        this.contbizPerson.setName("contbizPerson");
        this.contperson.setName("contperson");
        this.contbillType.setName("contbillType");
        this.contvoucherNum.setName("contvoucherNum");
        this.chkisHasMaterialReq.setName("chkisHasMaterialReq");
        this.contreturnCompany.setName("contreturnCompany");
        this.contfodderSourceType.setName("contfodderSourceType");
        this.chkisHasSaleOrder.setName("chkisHasSaleOrder");
        this.chkisHasSaleReturn.setName("chkisHasSaleReturn");
        this.contfarmer.setName("contfarmer");
        this.contfarm.setName("contfarm");
        this.contbatchContract.setName("contbatchContract");
        this.contbatch.setName("contbatch");
        this.contsettlePolicy.setName("contsettlePolicy");
        this.contweekDay.setName("contweekDay");
        this.contindate.setName("contindate");
        this.contbatchQty.setName("contbatchQty");
        this.contsupplier.setName("contsupplier");
        this.contcar.setName("contcar");
        this.chkisTiLiao.setName("chkisTiLiao");
        this.chkisOtherIssue.setName("chkisOtherIssue");
        this.chkisHasSaleIssue.setName("chkisHasSaleIssue");
        this.chkisFromTiaoLiao.setName("chkisFromTiaoLiao");
        this.chkisSanZhuang.setName("chkisSanZhuang");
        this.contfarmerPhone.setName("contfarmerPhone");
        this.contfarmAddress.setName("contfarmAddress");
        this.chkisWeight.setName("chkisWeight");
        this.contbunker.setName("contbunker");
        this.contreturnOpinion.setName("contreturnOpinion");
        this.contcostCenter.setName("contcostCenter");
        this.contbreedData.setName("contbreedData");
        this.contfeedInstance.setName("contfeedInstance");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contcontractQty.setName("contcontractQty");
        this.contallowProcess.setName("contallowProcess");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.billStatus.setName("billStatus");
        this.prmtcompany.setName("prmtcompany");
        this.pkauditTime.setName("pkauditTime");
        this.prmtstorageOrgUnit.setName("prmtstorageOrgUnit");
        this.prmtdriver.setName("prmtdriver");
        this.txtcarNo.setName("txtcarNo");
        this.txtlinkCell.setName("txtlinkCell");
        this.prmtbizPerson.setName("prmtbizPerson");
        this.prmtperson.setName("prmtperson");
        this.billType.setName("billType");
        this.txtvoucherNum.setName("txtvoucherNum");
        this.prmtreturnCompany.setName("prmtreturnCompany");
        this.fodderSourceType.setName("fodderSourceType");
        this.prmtfarmer.setName("prmtfarmer");
        this.prmtfarm.setName("prmtfarm");
        this.prmtbatchContract.setName("prmtbatchContract");
        this.prmtbatch.setName("prmtbatch");
        this.prmtsettlePolicy.setName("prmtsettlePolicy");
        this.txtweekDay.setName("txtweekDay");
        this.pkindate.setName("pkindate");
        this.txtbatchQty.setName("txtbatchQty");
        this.prmtsupplier.setName("prmtsupplier");
        this.prmtcar.setName("prmtcar");
        this.txtfarmerPhone.setName("txtfarmerPhone");
        this.txtfarmAddress.setName("txtfarmAddress");
        this.bunker.setName("bunker");
        this.txtreturnOpinion.setName("txtreturnOpinion");
        this.prmtcostCenter.setName("prmtcostCenter");
        this.prmtbreedData.setName("prmtbreedData");
        this.txtfeedInstance.setName("txtfeedInstance");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kdtEntrys.setName("kdtEntrys");
        this.contearlyStand.setName("contearlyStand");
        this.contearlyVou.setName("contearlyVou");
        this.contearlyAudit.setName("contearlyAudit");
        this.contearlyUnAudit.setName("contearlyUnAudit");
        this.contearlyAllow.setName("contearlyAllow");
        this.contmidStand.setName("contmidStand");
        this.contmidVouch.setName("contmidVouch");
        this.contmidAudit.setName("contmidAudit");
        this.contmidUnAudit.setName("contmidUnAudit");
        this.contmidAllow.setName("contmidAllow");
        this.contlateStand.setName("contlateStand");
        this.contlateVoucher.setName("contlateVoucher");
        this.contlateAudit.setName("contlateAudit");
        this.contlateUnAudit.setName("contlateUnAudit");
        this.contlateAllow.setName("contlateAllow");
        this.txtearlyStand.setName("txtearlyStand");
        this.txtearlyVou.setName("txtearlyVou");
        this.txtearlyAudit.setName("txtearlyAudit");
        this.txtearlyUnAudit.setName("txtearlyUnAudit");
        this.txtearlyAllow.setName("txtearlyAllow");
        this.txtmidStand.setName("txtmidStand");
        this.txtmidVouch.setName("txtmidVouch");
        this.txtmidAudit.setName("txtmidAudit");
        this.txtmidUnAudit.setName("txtmidUnAudit");
        this.txtmidAllow.setName("txtmidAllow");
        this.txtlateStand.setName("txtlateStand");
        this.txtlateVoucher.setName("txtlateVoucher");
        this.txtlateAudit.setName("txtlateAudit");
        this.txtlateUnAudit.setName("txtlateUnAudit");
        this.txtlateAllow.setName("txtlateAllow");
        this.txtcontractQty.setName("txtcontractQty");
        this.txtallowProcess.setName("txtallowProcess");
        this.tBtnAudit.setName("tBtnAudit");
        this.tBtnUnAudit.setName("tBtnUnAudit");
        this.btnClose.setName("btnClose");
        this.btnUnClose.setName("btnUnClose");
        this.btnViewStdUse.setName("btnViewStdUse");
        this.mBtnAudit.setName("mBtnAudit");
        this.mBtnUnAudit.setName("mBtnUnAudit");
        this.newSeparator3.setName("newSeparator3");
        // CoreUI		
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
        // contbillStatus		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // kDSeparator8
        // kDSeparator9
        // contstorageOrgUnit		
        this.contstorageOrgUnit.setBoundLabelText(resHelper.getString("contstorageOrgUnit.boundLabelText"));		
        this.contstorageOrgUnit.setBoundLabelLength(100);		
        this.contstorageOrgUnit.setBoundLabelUnderline(true);		
        this.contstorageOrgUnit.setVisible(true);
        // chkisInit		
        this.chkisInit.setText(resHelper.getString("chkisInit.text"));		
        this.chkisInit.setHorizontalAlignment(2);		
        this.chkisInit.setVisible(false);
        // contdriver		
        this.contdriver.setBoundLabelText(resHelper.getString("contdriver.boundLabelText"));		
        this.contdriver.setBoundLabelLength(100);		
        this.contdriver.setBoundLabelUnderline(true);		
        this.contdriver.setVisible(true);
        // contcarNo		
        this.contcarNo.setBoundLabelText(resHelper.getString("contcarNo.boundLabelText"));		
        this.contcarNo.setBoundLabelLength(100);		
        this.contcarNo.setBoundLabelUnderline(true);		
        this.contcarNo.setVisible(false);
        // contlinkCell		
        this.contlinkCell.setBoundLabelText(resHelper.getString("contlinkCell.boundLabelText"));		
        this.contlinkCell.setBoundLabelLength(100);		
        this.contlinkCell.setBoundLabelUnderline(true);		
        this.contlinkCell.setVisible(true);
        // contbizPerson		
        this.contbizPerson.setBoundLabelText(resHelper.getString("contbizPerson.boundLabelText"));		
        this.contbizPerson.setBoundLabelLength(100);		
        this.contbizPerson.setBoundLabelUnderline(true);		
        this.contbizPerson.setVisible(false);
        // contperson		
        this.contperson.setBoundLabelText(resHelper.getString("contperson.boundLabelText"));		
        this.contperson.setBoundLabelLength(100);		
        this.contperson.setBoundLabelUnderline(true);
        // contbillType		
        this.contbillType.setBoundLabelText(resHelper.getString("contbillType.boundLabelText"));		
        this.contbillType.setBoundLabelLength(100);		
        this.contbillType.setBoundLabelUnderline(true);		
        this.contbillType.setVisible(true);
        // contvoucherNum		
        this.contvoucherNum.setBoundLabelText(resHelper.getString("contvoucherNum.boundLabelText"));		
        this.contvoucherNum.setBoundLabelLength(100);		
        this.contvoucherNum.setBoundLabelUnderline(true);		
        this.contvoucherNum.setVisible(false);
        // chkisHasMaterialReq		
        this.chkisHasMaterialReq.setText(resHelper.getString("chkisHasMaterialReq.text"));		
        this.chkisHasMaterialReq.setHorizontalAlignment(2);		
        this.chkisHasMaterialReq.setEnabled(false);
        // contreturnCompany		
        this.contreturnCompany.setBoundLabelText(resHelper.getString("contreturnCompany.boundLabelText"));		
        this.contreturnCompany.setBoundLabelLength(100);		
        this.contreturnCompany.setBoundLabelUnderline(true);		
        this.contreturnCompany.setVisible(true);
        // contfodderSourceType		
        this.contfodderSourceType.setBoundLabelText(resHelper.getString("contfodderSourceType.boundLabelText"));		
        this.contfodderSourceType.setBoundLabelLength(100);		
        this.contfodderSourceType.setBoundLabelUnderline(true);		
        this.contfodderSourceType.setVisible(true);
        // chkisHasSaleOrder		
        this.chkisHasSaleOrder.setText(resHelper.getString("chkisHasSaleOrder.text"));		
        this.chkisHasSaleOrder.setHorizontalAlignment(2);		
        this.chkisHasSaleOrder.setEnabled(false);		
        this.chkisHasSaleOrder.setVisible(false);
        // chkisHasSaleReturn		
        this.chkisHasSaleReturn.setText(resHelper.getString("chkisHasSaleReturn.text"));		
        this.chkisHasSaleReturn.setHorizontalAlignment(2);		
        this.chkisHasSaleReturn.setEnabled(false);		
        this.chkisHasSaleReturn.setVisible(false);
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
        // contbatchContract		
        this.contbatchContract.setBoundLabelText(resHelper.getString("contbatchContract.boundLabelText"));		
        this.contbatchContract.setBoundLabelLength(100);		
        this.contbatchContract.setBoundLabelUnderline(true);		
        this.contbatchContract.setVisible(true);
        // contbatch		
        this.contbatch.setBoundLabelText(resHelper.getString("contbatch.boundLabelText"));		
        this.contbatch.setBoundLabelLength(100);		
        this.contbatch.setBoundLabelUnderline(true);		
        this.contbatch.setVisible(true);
        // contsettlePolicy		
        this.contsettlePolicy.setBoundLabelText(resHelper.getString("contsettlePolicy.boundLabelText"));		
        this.contsettlePolicy.setBoundLabelLength(100);		
        this.contsettlePolicy.setBoundLabelUnderline(true);		
        this.contsettlePolicy.setVisible(true);
        // contweekDay		
        this.contweekDay.setBoundLabelText(resHelper.getString("contweekDay.boundLabelText"));		
        this.contweekDay.setBoundLabelLength(100);		
        this.contweekDay.setBoundLabelUnderline(true);		
        this.contweekDay.setVisible(true);
        // contindate		
        this.contindate.setBoundLabelText(resHelper.getString("contindate.boundLabelText"));		
        this.contindate.setBoundLabelLength(100);		
        this.contindate.setBoundLabelUnderline(true);		
        this.contindate.setVisible(true);
        // contbatchQty		
        this.contbatchQty.setBoundLabelText(resHelper.getString("contbatchQty.boundLabelText"));		
        this.contbatchQty.setBoundLabelLength(100);		
        this.contbatchQty.setBoundLabelUnderline(true);		
        this.contbatchQty.setVisible(true);
        // contsupplier		
        this.contsupplier.setBoundLabelText(resHelper.getString("contsupplier.boundLabelText"));		
        this.contsupplier.setBoundLabelLength(100);		
        this.contsupplier.setBoundLabelUnderline(true);		
        this.contsupplier.setVisible(true);
        // contcar		
        this.contcar.setBoundLabelText(resHelper.getString("contcar.boundLabelText"));		
        this.contcar.setBoundLabelLength(100);		
        this.contcar.setBoundLabelUnderline(true);		
        this.contcar.setVisible(true);
        // chkisTiLiao		
        this.chkisTiLiao.setText(resHelper.getString("chkisTiLiao.text"));		
        this.chkisTiLiao.setHorizontalAlignment(2);		
        this.chkisTiLiao.setEnabled(false);		
        this.chkisTiLiao.setVisible(false);
        // chkisOtherIssue		
        this.chkisOtherIssue.setText(resHelper.getString("chkisOtherIssue.text"));		
        this.chkisOtherIssue.setHorizontalAlignment(2);		
        this.chkisOtherIssue.setEnabled(false);
        // chkisHasSaleIssue		
        this.chkisHasSaleIssue.setText(resHelper.getString("chkisHasSaleIssue.text"));		
        this.chkisHasSaleIssue.setHorizontalAlignment(2);		
        this.chkisHasSaleIssue.setEnabled(false);		
        this.chkisHasSaleIssue.setVisible(false);
        // chkisFromTiaoLiao		
        this.chkisFromTiaoLiao.setText(resHelper.getString("chkisFromTiaoLiao.text"));		
        this.chkisFromTiaoLiao.setHorizontalAlignment(2);		
        this.chkisFromTiaoLiao.setEnabled(false);
        // chkisSanZhuang		
        this.chkisSanZhuang.setText(resHelper.getString("chkisSanZhuang.text"));		
        this.chkisSanZhuang.setHorizontalAlignment(2);		
        this.chkisSanZhuang.setEnabled(false);
        // contfarmerPhone		
        this.contfarmerPhone.setBoundLabelText(resHelper.getString("contfarmerPhone.boundLabelText"));		
        this.contfarmerPhone.setBoundLabelLength(100);		
        this.contfarmerPhone.setBoundLabelUnderline(true);		
        this.contfarmerPhone.setVisible(true);
        // contfarmAddress		
        this.contfarmAddress.setBoundLabelText(resHelper.getString("contfarmAddress.boundLabelText"));		
        this.contfarmAddress.setBoundLabelLength(100);		
        this.contfarmAddress.setBoundLabelUnderline(true);		
        this.contfarmAddress.setVisible(true);
        // chkisWeight		
        this.chkisWeight.setText(resHelper.getString("chkisWeight.text"));		
        this.chkisWeight.setHorizontalAlignment(2);		
        this.chkisWeight.setEnabled(false);
        // contbunker		
        this.contbunker.setBoundLabelText(resHelper.getString("contbunker.boundLabelText"));		
        this.contbunker.setBoundLabelLength(100);		
        this.contbunker.setBoundLabelUnderline(true);		
        this.contbunker.setVisible(true);
        // contreturnOpinion		
        this.contreturnOpinion.setBoundLabelText(resHelper.getString("contreturnOpinion.boundLabelText"));		
        this.contreturnOpinion.setBoundLabelLength(100);		
        this.contreturnOpinion.setBoundLabelUnderline(true);		
        this.contreturnOpinion.setVisible(true);
        // contcostCenter		
        this.contcostCenter.setBoundLabelText(resHelper.getString("contcostCenter.boundLabelText"));		
        this.contcostCenter.setBoundLabelLength(100);		
        this.contcostCenter.setBoundLabelUnderline(true);		
        this.contcostCenter.setVisible(true);
        // contbreedData		
        this.contbreedData.setBoundLabelText(resHelper.getString("contbreedData.boundLabelText"));		
        this.contbreedData.setBoundLabelLength(100);		
        this.contbreedData.setBoundLabelUnderline(true);		
        this.contbreedData.setVisible(true);
        // contfeedInstance		
        this.contfeedInstance.setBoundLabelText(resHelper.getString("contfeedInstance.boundLabelText"));		
        this.contfeedInstance.setBoundLabelLength(100);		
        this.contfeedInstance.setBoundLabelUnderline(true);		
        this.contfeedInstance.setVisible(true);
        // kDTabbedPane1
        // contcontractQty		
        this.contcontractQty.setBoundLabelText(resHelper.getString("contcontractQty.boundLabelText"));		
        this.contcontractQty.setBoundLabelLength(100);		
        this.contcontractQty.setBoundLabelUnderline(true);		
        this.contcontractQty.setVisible(true);
        // contallowProcess		
        this.contallowProcess.setBoundLabelText(resHelper.getString("contallowProcess.boundLabelText"));		
        this.contallowProcess.setBoundLabelLength(100);		
        this.contallowProcess.setBoundLabelUnderline(true);
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
        this.pkBizDate.setRequired(true);
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // billStatus		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // prmtstorageOrgUnit		
        this.prmtstorageOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtstorageOrgUnit.setEditable(true);		
        this.prmtstorageOrgUnit.setDisplayFormat("$name$");		
        this.prmtstorageOrgUnit.setEditFormat("$number$");		
        this.prmtstorageOrgUnit.setCommitFormat("$number$");		
        this.prmtstorageOrgUnit.setRequired(true);
        // prmtdriver		
        this.prmtdriver.setQueryInfo("com.kingdee.eas.farm.feemanager.basedata.app.DriverQuery");		
        this.prmtdriver.setEditable(true);		
        this.prmtdriver.setDisplayFormat("$drivername$");		
        this.prmtdriver.setEditFormat("$drivername$");		
        this.prmtdriver.setCommitFormat("$drivername$");		
        this.prmtdriver.setRequired(false);
        		prmtdriver.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI prmtdriver_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtdriver_F7ListUI == null) {
					try {
						prmtdriver_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtdriver_F7ListUI));
					prmtdriver_F7ListUI.setF7Use(true,ctx);
					prmtdriver.setSelector(prmtdriver_F7ListUI);
				}
			}
		});
					
        prmtdriver.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtdriver_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtcarNo		
        this.txtcarNo.setVisible(false);		
        this.txtcarNo.setHorizontalAlignment(2);		
        this.txtcarNo.setMaxLength(100);		
        this.txtcarNo.setRequired(false);
        // txtlinkCell		
        this.txtlinkCell.setHorizontalAlignment(2);		
        this.txtlinkCell.setMaxLength(80);		
        this.txtlinkCell.setRequired(false);		
        this.txtlinkCell.setEnabled(false);
        // prmtbizPerson		
        this.prmtbizPerson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtbizPerson.setVisible(false);		
        this.prmtbizPerson.setEditable(true);		
        this.prmtbizPerson.setDisplayFormat("$name$");		
        this.prmtbizPerson.setEditFormat("$number$");		
        this.prmtbizPerson.setCommitFormat("$number$");		
        this.prmtbizPerson.setRequired(false);
        // prmtperson		
        this.prmtperson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtperson.setEditable(true);		
        this.prmtperson.setDisplayFormat("$name$");		
        this.prmtperson.setEditFormat("$number$");		
        this.prmtperson.setCommitFormat("$number$");		
        this.prmtperson.setRequired(false);		
        this.prmtperson.setEnabled(false);
        // billType		
        this.billType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.feedbiz.FodderBillType").toArray());		
        this.billType.setRequired(true);
        // txtvoucherNum		
        this.txtvoucherNum.setVisible(false);		
        this.txtvoucherNum.setHorizontalAlignment(2);		
        this.txtvoucherNum.setMaxLength(100);		
        this.txtvoucherNum.setRequired(false);		
        this.txtvoucherNum.setEnabled(false);
        // prmtreturnCompany		
        this.prmtreturnCompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtreturnCompany.setEditable(true);		
        this.prmtreturnCompany.setDisplayFormat("$name$");		
        this.prmtreturnCompany.setEditFormat("$number$");		
        this.prmtreturnCompany.setCommitFormat("$number$");		
        this.prmtreturnCompany.setRequired(false);
        // fodderSourceType		
        this.fodderSourceType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.feedbiz.fodderSourceType").toArray());		
        this.fodderSourceType.setRequired(true);
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

        // prmtbatchContract		
        this.prmtbatchContract.setQueryInfo("com.kingdee.eas.farm.carnivorous.feedbiz.app.BatchContractBillQuery");		
        this.prmtbatchContract.setEditable(true);		
        this.prmtbatchContract.setDisplayFormat("$number$");		
        this.prmtbatchContract.setEditFormat("$number$");		
        this.prmtbatchContract.setCommitFormat("$number$");		
        this.prmtbatchContract.setRequired(true);
        // prmtbatch		
        this.prmtbatch.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.BatchQuery");		
        this.prmtbatch.setEditable(true);		
        this.prmtbatch.setDisplayFormat("$name$");		
        this.prmtbatch.setEditFormat("$number$");		
        this.prmtbatch.setCommitFormat("$number$");		
        this.prmtbatch.setRequired(false);		
        this.prmtbatch.setEnabled(false);
        		prmtbatch.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.BatchListUI prmtbatch_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtbatch_F7ListUI == null) {
					try {
						prmtbatch_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.BatchListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtbatch_F7ListUI));
					prmtbatch_F7ListUI.setF7Use(true,ctx);
					prmtbatch.setSelector(prmtbatch_F7ListUI);
				}
			}
		});
					
        // prmtsettlePolicy		
        this.prmtsettlePolicy.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.SettlePolicyQuery");		
        this.prmtsettlePolicy.setEditable(true);		
        this.prmtsettlePolicy.setDisplayFormat("$name$");		
        this.prmtsettlePolicy.setEditFormat("$number$");		
        this.prmtsettlePolicy.setCommitFormat("$number$");		
        this.prmtsettlePolicy.setRequired(false);		
        this.prmtsettlePolicy.setEnabled(false);
        		prmtsettlePolicy.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.SettlePolicyListUI prmtsettlePolicy_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtsettlePolicy_F7ListUI == null) {
					try {
						prmtsettlePolicy_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.SettlePolicyListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtsettlePolicy_F7ListUI));
					prmtsettlePolicy_F7ListUI.setF7Use(true,ctx);
					prmtsettlePolicy.setSelector(prmtsettlePolicy_F7ListUI);
				}
			}
		});
					
        // txtweekDay		
        this.txtweekDay.setHorizontalAlignment(2);		
        this.txtweekDay.setDataType(0);		
        this.txtweekDay.setSupportedEmpty(true);		
        this.txtweekDay.setRequired(false);		
        this.txtweekDay.setEnabled(false);
        // pkindate		
        this.pkindate.setRequired(false);		
        this.pkindate.setEnabled(false);
        // txtbatchQty		
        this.txtbatchQty.setHorizontalAlignment(2);		
        this.txtbatchQty.setDataType(1);		
        this.txtbatchQty.setSupportedEmpty(true);		
        this.txtbatchQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbatchQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbatchQty.setPrecision(4);		
        this.txtbatchQty.setRequired(false);		
        this.txtbatchQty.setEnabled(false);
        // prmtsupplier		
        this.prmtsupplier.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.PSupplierQuery");		
        this.prmtsupplier.setEditable(true);		
        this.prmtsupplier.setDisplayFormat("$name$");		
        this.prmtsupplier.setEditFormat("$number$");		
        this.prmtsupplier.setCommitFormat("$number$");		
        this.prmtsupplier.setRequired(false);		
        this.prmtsupplier.setEnabled(false);
        // prmtcar		
        this.prmtcar.setQueryInfo("com.kingdee.eas.publicdata.app.CarQuery");		
        this.prmtcar.setEditable(true);		
        this.prmtcar.setDisplayFormat("$number$");		
        this.prmtcar.setEditFormat("$number$");		
        this.prmtcar.setCommitFormat("$number$");		
        this.prmtcar.setRequired(false);
        		prmtcar.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.CarListUI prmtcar_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtcar_F7ListUI == null) {
					try {
						prmtcar_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.CarListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtcar_F7ListUI));
					prmtcar_F7ListUI.setF7Use(true,ctx);
					prmtcar.setSelector(prmtcar_F7ListUI);
				}
			}
		});
					
        // txtfarmerPhone		
        this.txtfarmerPhone.setHorizontalAlignment(2);		
        this.txtfarmerPhone.setMaxLength(80);		
        this.txtfarmerPhone.setRequired(false);		
        this.txtfarmerPhone.setEnabled(false);
        // txtfarmAddress		
        this.txtfarmAddress.setHorizontalAlignment(2);		
        this.txtfarmAddress.setMaxLength(80);		
        this.txtfarmAddress.setRequired(false);		
        this.txtfarmAddress.setEnabled(false);
        // bunker		
        this.bunker.setVisible(true);		
        this.bunker.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.basedata.BunkerEnum").toArray());		
        this.bunker.setRequired(false);		
        this.bunker.setEnabled(false);
        // txtreturnOpinion		
        this.txtreturnOpinion.setVisible(true);		
        this.txtreturnOpinion.setHorizontalAlignment(2);		
        this.txtreturnOpinion.setMaxLength(255);		
        this.txtreturnOpinion.setRequired(false);		
        this.txtreturnOpinion.setEnabled(false);
        // prmtcostCenter		
        this.prmtcostCenter.setQueryInfo("com.kingdee.eas.basedata.org.app.CostCenterItemQuery");		
        this.prmtcostCenter.setVisible(true);		
        this.prmtcostCenter.setEditable(true);		
        this.prmtcostCenter.setDisplayFormat("$name$");		
        this.prmtcostCenter.setEditFormat("$number$");		
        this.prmtcostCenter.setCommitFormat("$number$");		
        this.prmtcostCenter.setRequired(true);
        // prmtbreedData		
        this.prmtbreedData.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.BreedDataQuery");		
        this.prmtbreedData.setVisible(true);		
        this.prmtbreedData.setEditable(true);		
        this.prmtbreedData.setDisplayFormat("$name$");		
        this.prmtbreedData.setEditFormat("$number$");		
        this.prmtbreedData.setCommitFormat("$number$");		
        this.prmtbreedData.setRequired(false);
        		prmtbreedData.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI prmtbreedData_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtbreedData_F7ListUI == null) {
					try {
						prmtbreedData_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtbreedData_F7ListUI));
					prmtbreedData_F7ListUI.setF7Use(true,ctx);
					prmtbreedData.setSelector(prmtbreedData_F7ListUI);
				}
			}
		});
					
        // txtfeedInstance		
        this.txtfeedInstance.setVisible(true);		
        this.txtfeedInstance.setHorizontalAlignment(2);		
        this.txtfeedInstance.setDataType(1);		
        this.txtfeedInstance.setSupportedEmpty(true);		
        this.txtfeedInstance.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfeedInstance.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfeedInstance.setPrecision(10);		
        this.txtfeedInstance.setRequired(false);		
        this.txtfeedInstance.setEnabled(false);
        // kDPanel1
        // kDPanel2
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol16\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol17\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol18\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol19\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol20\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol22\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol23\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol24\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol25\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol26\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol27\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol28\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol29\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"materialName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"unitQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"bagQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"receiveQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"confirmQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"totalReceivedQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"14\" t:styleID=\"sCol9\" /><t:Column t:key=\"feedStandard\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"15\" t:styleID=\"sCol10\" /><t:Column t:key=\"basePrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"16\" t:styleID=\"sCol11\" /><t:Column t:key=\"receivePrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"17\" t:styleID=\"sCol12\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"18\" t:styleID=\"sCol13\" /><t:Column t:key=\"driver\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"19\" t:styleID=\"sCol14\" /><t:Column t:key=\"warehouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"20\" /><t:Column t:key=\"unitCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"21\" t:styleID=\"sCol16\" /><t:Column t:key=\"actualCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"22\" t:styleID=\"sCol17\" /><t:Column t:key=\"person\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"23\" t:styleID=\"sCol18\" /><t:Column t:key=\"bizPerson\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"24\" t:styleID=\"sCol19\" /><t:Column t:key=\"confirmTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"25\" t:styleID=\"sCol20\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"farmer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol22\" /><t:Column t:key=\"weekAge\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol23\" /><t:Column t:key=\"farm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol24\" /><t:Column t:key=\"batch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol25\" /><t:Column t:key=\"batchContract\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol26\" /><t:Column t:key=\"productionDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol27\" /><t:Column t:key=\"shift\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol28\" /><t:Column t:key=\"hjFee\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol29\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{model}</t:Cell><t:Cell>$Resource{unitQty}</t:Cell><t:Cell>$Resource{bagQty}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{receiveQty}</t:Cell><t:Cell>$Resource{confirmQty}</t:Cell><t:Cell>$Resource{totalReceivedQty}</t:Cell><t:Cell>$Resource{feedStandard}</t:Cell><t:Cell>$Resource{basePrice}</t:Cell><t:Cell>$Resource{receivePrice}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{driver}</t:Cell><t:Cell>$Resource{warehouse}</t:Cell><t:Cell>$Resource{unitCost}</t:Cell><t:Cell>$Resource{actualCost}</t:Cell><t:Cell>$Resource{person}</t:Cell><t:Cell>$Resource{bizPerson}</t:Cell><t:Cell>$Resource{confirmTime}</t:Cell><t:Cell>$Resource{remark}</t:Cell><t:Cell>$Resource{farmer}</t:Cell><t:Cell>$Resource{weekAge}</t:Cell><t:Cell>$Resource{farm}</t:Cell><t:Cell>$Resource{batch}</t:Cell><t:Cell>$Resource{batchContract}</t:Cell><t:Cell>$Resource{productionDate}</t:Cell><t:Cell>$Resource{shift}</t:Cell><t:Cell>$Resource{hjFee}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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

        this.kdtEntrys.addKDTEditListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter() {
            public void editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) {
                try {
                    kdtEntrys_editStopped(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
            public void editStarting(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) {
                try {
                    kdtEntrys_editStarting(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });

                this.kdtEntrys.putBindContents("editData",new String[] {"id","material","materialName","model","unitQty","bagQty","unit","receiveQty","confirmQty","totalReceivedQty","feedStandard","basePrice","receivePrice","amount","driver","warehouse","unitCost","actualCost","person","bizPerson","confirmTime","remark","farmer","weekAge","farm","batch","batchContract","productionDate","shift","hjFee"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_material_PromptBox = new KDBizPromptBox();
        kdtEntrys_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtEntrys_material_PromptBox.setVisible(true);
        kdtEntrys_material_PromptBox.setEditable(true);
        kdtEntrys_material_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_material_PromptBox.setEditFormat("$number$");
        kdtEntrys_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_material_CellEditor = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox);
        this.kdtEntrys.getColumn("material").setEditor(kdtEntrys_material_CellEditor);
        ObjectValueRender kdtEntrys_material_OVR = new ObjectValueRender();
        kdtEntrys_material_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("material").setRenderer(kdtEntrys_material_OVR);
        KDTextField kdtEntrys_materialName_TextField = new KDTextField();
        kdtEntrys_materialName_TextField.setName("kdtEntrys_materialName_TextField");
        kdtEntrys_materialName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_materialName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_materialName_TextField);
        this.kdtEntrys.getColumn("materialName").setEditor(kdtEntrys_materialName_CellEditor);
        KDTextField kdtEntrys_model_TextField = new KDTextField();
        kdtEntrys_model_TextField.setName("kdtEntrys_model_TextField");
        kdtEntrys_model_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_model_CellEditor = new KDTDefaultCellEditor(kdtEntrys_model_TextField);
        this.kdtEntrys.getColumn("model").setEditor(kdtEntrys_model_CellEditor);
        KDFormattedTextField kdtEntrys_unitQty_TextField = new KDFormattedTextField();
        kdtEntrys_unitQty_TextField.setName("kdtEntrys_unitQty_TextField");
        kdtEntrys_unitQty_TextField.setVisible(true);
        kdtEntrys_unitQty_TextField.setEditable(true);
        kdtEntrys_unitQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_unitQty_TextField.setDataType(1);
        	kdtEntrys_unitQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_unitQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_unitQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_unitQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_unitQty_TextField);
        this.kdtEntrys.getColumn("unitQty").setEditor(kdtEntrys_unitQty_CellEditor);
        KDFormattedTextField kdtEntrys_bagQty_TextField = new KDFormattedTextField();
        kdtEntrys_bagQty_TextField.setName("kdtEntrys_bagQty_TextField");
        kdtEntrys_bagQty_TextField.setVisible(true);
        kdtEntrys_bagQty_TextField.setEditable(true);
        kdtEntrys_bagQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_bagQty_TextField.setDataType(1);
        	kdtEntrys_bagQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_bagQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_bagQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_bagQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_bagQty_TextField);
        this.kdtEntrys.getColumn("bagQty").setEditor(kdtEntrys_bagQty_CellEditor);
        final KDBizPromptBox kdtEntrys_unit_PromptBox = new KDBizPromptBox();
        kdtEntrys_unit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtEntrys_unit_PromptBox.setVisible(true);
        kdtEntrys_unit_PromptBox.setEditable(true);
        kdtEntrys_unit_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_unit_PromptBox.setEditFormat("$number$");
        kdtEntrys_unit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_unit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_unit_PromptBox);
        this.kdtEntrys.getColumn("unit").setEditor(kdtEntrys_unit_CellEditor);
        ObjectValueRender kdtEntrys_unit_OVR = new ObjectValueRender();
        kdtEntrys_unit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("unit").setRenderer(kdtEntrys_unit_OVR);
        KDFormattedTextField kdtEntrys_receiveQty_TextField = new KDFormattedTextField();
        kdtEntrys_receiveQty_TextField.setName("kdtEntrys_receiveQty_TextField");
        kdtEntrys_receiveQty_TextField.setVisible(true);
        kdtEntrys_receiveQty_TextField.setEditable(true);
        kdtEntrys_receiveQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_receiveQty_TextField.setDataType(1);
        	kdtEntrys_receiveQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_receiveQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_receiveQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_receiveQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_receiveQty_TextField);
        this.kdtEntrys.getColumn("receiveQty").setEditor(kdtEntrys_receiveQty_CellEditor);
        KDFormattedTextField kdtEntrys_confirmQty_TextField = new KDFormattedTextField();
        kdtEntrys_confirmQty_TextField.setName("kdtEntrys_confirmQty_TextField");
        kdtEntrys_confirmQty_TextField.setVisible(true);
        kdtEntrys_confirmQty_TextField.setEditable(true);
        kdtEntrys_confirmQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_confirmQty_TextField.setDataType(1);
        	kdtEntrys_confirmQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_confirmQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_confirmQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_confirmQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_confirmQty_TextField);
        this.kdtEntrys.getColumn("confirmQty").setEditor(kdtEntrys_confirmQty_CellEditor);
        KDFormattedTextField kdtEntrys_totalReceivedQty_TextField = new KDFormattedTextField();
        kdtEntrys_totalReceivedQty_TextField.setName("kdtEntrys_totalReceivedQty_TextField");
        kdtEntrys_totalReceivedQty_TextField.setVisible(true);
        kdtEntrys_totalReceivedQty_TextField.setEditable(true);
        kdtEntrys_totalReceivedQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_totalReceivedQty_TextField.setDataType(1);
        	kdtEntrys_totalReceivedQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_totalReceivedQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_totalReceivedQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_totalReceivedQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_totalReceivedQty_TextField);
        this.kdtEntrys.getColumn("totalReceivedQty").setEditor(kdtEntrys_totalReceivedQty_CellEditor);
        KDFormattedTextField kdtEntrys_feedStandard_TextField = new KDFormattedTextField();
        kdtEntrys_feedStandard_TextField.setName("kdtEntrys_feedStandard_TextField");
        kdtEntrys_feedStandard_TextField.setVisible(true);
        kdtEntrys_feedStandard_TextField.setEditable(true);
        kdtEntrys_feedStandard_TextField.setHorizontalAlignment(2);
        kdtEntrys_feedStandard_TextField.setDataType(1);
        	kdtEntrys_feedStandard_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_feedStandard_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_feedStandard_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_feedStandard_CellEditor = new KDTDefaultCellEditor(kdtEntrys_feedStandard_TextField);
        this.kdtEntrys.getColumn("feedStandard").setEditor(kdtEntrys_feedStandard_CellEditor);
        KDFormattedTextField kdtEntrys_basePrice_TextField = new KDFormattedTextField();
        kdtEntrys_basePrice_TextField.setName("kdtEntrys_basePrice_TextField");
        kdtEntrys_basePrice_TextField.setVisible(true);
        kdtEntrys_basePrice_TextField.setEditable(true);
        kdtEntrys_basePrice_TextField.setHorizontalAlignment(2);
        kdtEntrys_basePrice_TextField.setDataType(1);
        	kdtEntrys_basePrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_basePrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_basePrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_basePrice_CellEditor = new KDTDefaultCellEditor(kdtEntrys_basePrice_TextField);
        this.kdtEntrys.getColumn("basePrice").setEditor(kdtEntrys_basePrice_CellEditor);
        KDFormattedTextField kdtEntrys_receivePrice_TextField = new KDFormattedTextField();
        kdtEntrys_receivePrice_TextField.setName("kdtEntrys_receivePrice_TextField");
        kdtEntrys_receivePrice_TextField.setVisible(true);
        kdtEntrys_receivePrice_TextField.setEditable(true);
        kdtEntrys_receivePrice_TextField.setHorizontalAlignment(2);
        kdtEntrys_receivePrice_TextField.setDataType(1);
        	kdtEntrys_receivePrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_receivePrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_receivePrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_receivePrice_CellEditor = new KDTDefaultCellEditor(kdtEntrys_receivePrice_TextField);
        this.kdtEntrys.getColumn("receivePrice").setEditor(kdtEntrys_receivePrice_CellEditor);
        KDFormattedTextField kdtEntrys_amount_TextField = new KDFormattedTextField();
        kdtEntrys_amount_TextField.setName("kdtEntrys_amount_TextField");
        kdtEntrys_amount_TextField.setVisible(true);
        kdtEntrys_amount_TextField.setEditable(true);
        kdtEntrys_amount_TextField.setHorizontalAlignment(2);
        kdtEntrys_amount_TextField.setDataType(1);
        	kdtEntrys_amount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_amount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_amount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_amount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_amount_TextField);
        this.kdtEntrys.getColumn("amount").setEditor(kdtEntrys_amount_CellEditor);
        final KDBizPromptBox kdtEntrys_driver_PromptBox = new KDBizPromptBox();
        kdtEntrys_driver_PromptBox.setQueryInfo("com.kingdee.eas.farm.feemanager.basedata.app.DriverQuery");
        kdtEntrys_driver_PromptBox.setVisible(true);
        kdtEntrys_driver_PromptBox.setEditable(true);
        kdtEntrys_driver_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_driver_PromptBox.setEditFormat("$number$");
        kdtEntrys_driver_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_driver_CellEditor = new KDTDefaultCellEditor(kdtEntrys_driver_PromptBox);
        this.kdtEntrys.getColumn("driver").setEditor(kdtEntrys_driver_CellEditor);
        ObjectValueRender kdtEntrys_driver_OVR = new ObjectValueRender();
        kdtEntrys_driver_OVR.setFormat(new BizDataFormat("$drivername$"));
        this.kdtEntrys.getColumn("driver").setRenderer(kdtEntrys_driver_OVR);
        			kdtEntrys_driver_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI kdtEntrys_driver_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_driver_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_driver_PromptBox_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_driver_PromptBox_F7ListUI));
					kdtEntrys_driver_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_driver_PromptBox.setSelector(kdtEntrys_driver_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEntrys_warehouse_PromptBox = new KDBizPromptBox();
        kdtEntrys_warehouse_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7AllWarehouseQuery");
        kdtEntrys_warehouse_PromptBox.setVisible(true);
        kdtEntrys_warehouse_PromptBox.setEditable(true);
        kdtEntrys_warehouse_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_warehouse_PromptBox.setEditFormat("$number$");
        kdtEntrys_warehouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_warehouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_warehouse_PromptBox);
        this.kdtEntrys.getColumn("warehouse").setEditor(kdtEntrys_warehouse_CellEditor);
        ObjectValueRender kdtEntrys_warehouse_OVR = new ObjectValueRender();
        kdtEntrys_warehouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("warehouse").setRenderer(kdtEntrys_warehouse_OVR);
        KDFormattedTextField kdtEntrys_unitCost_TextField = new KDFormattedTextField();
        kdtEntrys_unitCost_TextField.setName("kdtEntrys_unitCost_TextField");
        kdtEntrys_unitCost_TextField.setVisible(true);
        kdtEntrys_unitCost_TextField.setEditable(true);
        kdtEntrys_unitCost_TextField.setHorizontalAlignment(2);
        kdtEntrys_unitCost_TextField.setDataType(1);
        	kdtEntrys_unitCost_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_unitCost_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_unitCost_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_unitCost_CellEditor = new KDTDefaultCellEditor(kdtEntrys_unitCost_TextField);
        this.kdtEntrys.getColumn("unitCost").setEditor(kdtEntrys_unitCost_CellEditor);
        KDFormattedTextField kdtEntrys_actualCost_TextField = new KDFormattedTextField();
        kdtEntrys_actualCost_TextField.setName("kdtEntrys_actualCost_TextField");
        kdtEntrys_actualCost_TextField.setVisible(true);
        kdtEntrys_actualCost_TextField.setEditable(true);
        kdtEntrys_actualCost_TextField.setHorizontalAlignment(2);
        kdtEntrys_actualCost_TextField.setDataType(1);
        	kdtEntrys_actualCost_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_actualCost_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_actualCost_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_actualCost_CellEditor = new KDTDefaultCellEditor(kdtEntrys_actualCost_TextField);
        this.kdtEntrys.getColumn("actualCost").setEditor(kdtEntrys_actualCost_CellEditor);
        final KDBizPromptBox kdtEntrys_person_PromptBox = new KDBizPromptBox();
        kdtEntrys_person_PromptBox.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");
        kdtEntrys_person_PromptBox.setVisible(true);
        kdtEntrys_person_PromptBox.setEditable(true);
        kdtEntrys_person_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_person_PromptBox.setEditFormat("$number$");
        kdtEntrys_person_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_person_CellEditor = new KDTDefaultCellEditor(kdtEntrys_person_PromptBox);
        this.kdtEntrys.getColumn("person").setEditor(kdtEntrys_person_CellEditor);
        ObjectValueRender kdtEntrys_person_OVR = new ObjectValueRender();
        kdtEntrys_person_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("person").setRenderer(kdtEntrys_person_OVR);
        final KDBizPromptBox kdtEntrys_bizPerson_PromptBox = new KDBizPromptBox();
        kdtEntrys_bizPerson_PromptBox.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");
        kdtEntrys_bizPerson_PromptBox.setVisible(true);
        kdtEntrys_bizPerson_PromptBox.setEditable(true);
        kdtEntrys_bizPerson_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_bizPerson_PromptBox.setEditFormat("$number$");
        kdtEntrys_bizPerson_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_bizPerson_CellEditor = new KDTDefaultCellEditor(kdtEntrys_bizPerson_PromptBox);
        this.kdtEntrys.getColumn("bizPerson").setEditor(kdtEntrys_bizPerson_CellEditor);
        ObjectValueRender kdtEntrys_bizPerson_OVR = new ObjectValueRender();
        kdtEntrys_bizPerson_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("bizPerson").setRenderer(kdtEntrys_bizPerson_OVR);
        KDDatePicker kdtEntrys_confirmTime_DatePicker = new KDDatePicker();
        kdtEntrys_confirmTime_DatePicker.setName("kdtEntrys_confirmTime_DatePicker");
        kdtEntrys_confirmTime_DatePicker.setVisible(true);
        kdtEntrys_confirmTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_confirmTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_confirmTime_DatePicker);
        this.kdtEntrys.getColumn("confirmTime").setEditor(kdtEntrys_confirmTime_CellEditor);
        KDTextField kdtEntrys_remark_TextField = new KDTextField();
        kdtEntrys_remark_TextField.setName("kdtEntrys_remark_TextField");
        kdtEntrys_remark_TextField.setMaxLength(250);
        KDTDefaultCellEditor kdtEntrys_remark_CellEditor = new KDTDefaultCellEditor(kdtEntrys_remark_TextField);
        this.kdtEntrys.getColumn("remark").setEditor(kdtEntrys_remark_CellEditor);
        final KDBizPromptBox kdtEntrys_farmer_PromptBox = new KDBizPromptBox();
        kdtEntrys_farmer_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerQuery");
        kdtEntrys_farmer_PromptBox.setVisible(true);
        kdtEntrys_farmer_PromptBox.setEditable(true);
        kdtEntrys_farmer_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_farmer_PromptBox.setEditFormat("$number$");
        kdtEntrys_farmer_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_farmer_CellEditor = new KDTDefaultCellEditor(kdtEntrys_farmer_PromptBox);
        this.kdtEntrys.getColumn("farmer").setEditor(kdtEntrys_farmer_CellEditor);
        ObjectValueRender kdtEntrys_farmer_OVR = new ObjectValueRender();
        kdtEntrys_farmer_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("farmer").setRenderer(kdtEntrys_farmer_OVR);
        			kdtEntrys_farmer_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.FarmerListUI kdtEntrys_farmer_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_farmer_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_farmer_PromptBox_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.FarmerListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_farmer_PromptBox_F7ListUI));
					kdtEntrys_farmer_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_farmer_PromptBox.setSelector(kdtEntrys_farmer_PromptBox_F7ListUI);
				}
			}
		});
					
        KDTextField kdtEntrys_weekAge_TextField = new KDTextField();
        kdtEntrys_weekAge_TextField.setName("kdtEntrys_weekAge_TextField");
        kdtEntrys_weekAge_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_weekAge_CellEditor = new KDTDefaultCellEditor(kdtEntrys_weekAge_TextField);
        this.kdtEntrys.getColumn("weekAge").setEditor(kdtEntrys_weekAge_CellEditor);
        final KDBizPromptBox kdtEntrys_farm_PromptBox = new KDBizPromptBox();
        kdtEntrys_farm_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmQuery");
        kdtEntrys_farm_PromptBox.setVisible(true);
        kdtEntrys_farm_PromptBox.setEditable(true);
        kdtEntrys_farm_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_farm_PromptBox.setEditFormat("$number$");
        kdtEntrys_farm_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_farm_CellEditor = new KDTDefaultCellEditor(kdtEntrys_farm_PromptBox);
        this.kdtEntrys.getColumn("farm").setEditor(kdtEntrys_farm_CellEditor);
        ObjectValueRender kdtEntrys_farm_OVR = new ObjectValueRender();
        kdtEntrys_farm_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("farm").setRenderer(kdtEntrys_farm_OVR);
        			kdtEntrys_farm_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.FarmListUI kdtEntrys_farm_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_farm_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_farm_PromptBox_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.FarmListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_farm_PromptBox_F7ListUI));
					kdtEntrys_farm_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_farm_PromptBox.setSelector(kdtEntrys_farm_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEntrys_batch_PromptBox = new KDBizPromptBox();
        kdtEntrys_batch_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.BatchQuery");
        kdtEntrys_batch_PromptBox.setVisible(true);
        kdtEntrys_batch_PromptBox.setEditable(true);
        kdtEntrys_batch_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_batch_PromptBox.setEditFormat("$number$");
        kdtEntrys_batch_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_batch_CellEditor = new KDTDefaultCellEditor(kdtEntrys_batch_PromptBox);
        this.kdtEntrys.getColumn("batch").setEditor(kdtEntrys_batch_CellEditor);
        ObjectValueRender kdtEntrys_batch_OVR = new ObjectValueRender();
        kdtEntrys_batch_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("batch").setRenderer(kdtEntrys_batch_OVR);
        			kdtEntrys_batch_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.BatchListUI kdtEntrys_batch_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_batch_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_batch_PromptBox_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.BatchListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_batch_PromptBox_F7ListUI));
					kdtEntrys_batch_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_batch_PromptBox.setSelector(kdtEntrys_batch_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEntrys_batchContract_PromptBox = new KDBizPromptBox();
        kdtEntrys_batchContract_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.feedbiz.app.BatchContractBillQuery");
        kdtEntrys_batchContract_PromptBox.setVisible(true);
        kdtEntrys_batchContract_PromptBox.setEditable(true);
        kdtEntrys_batchContract_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_batchContract_PromptBox.setEditFormat("$number$");
        kdtEntrys_batchContract_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_batchContract_CellEditor = new KDTDefaultCellEditor(kdtEntrys_batchContract_PromptBox);
        this.kdtEntrys.getColumn("batchContract").setEditor(kdtEntrys_batchContract_CellEditor);
        ObjectValueRender kdtEntrys_batchContract_OVR = new ObjectValueRender();
        kdtEntrys_batchContract_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("batchContract").setRenderer(kdtEntrys_batchContract_OVR);
        KDDatePicker kdtEntrys_productionDate_DatePicker = new KDDatePicker();
        kdtEntrys_productionDate_DatePicker.setName("kdtEntrys_productionDate_DatePicker");
        kdtEntrys_productionDate_DatePicker.setVisible(true);
        kdtEntrys_productionDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_productionDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_productionDate_DatePicker);
        this.kdtEntrys.getColumn("productionDate").setEditor(kdtEntrys_productionDate_CellEditor);
        KDTextField kdtEntrys_shift_TextField = new KDTextField();
        kdtEntrys_shift_TextField.setName("kdtEntrys_shift_TextField");
        kdtEntrys_shift_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_shift_CellEditor = new KDTDefaultCellEditor(kdtEntrys_shift_TextField);
        this.kdtEntrys.getColumn("shift").setEditor(kdtEntrys_shift_CellEditor);
        KDFormattedTextField kdtEntrys_hjFee_TextField = new KDFormattedTextField();
        kdtEntrys_hjFee_TextField.setName("kdtEntrys_hjFee_TextField");
        kdtEntrys_hjFee_TextField.setVisible(true);
        kdtEntrys_hjFee_TextField.setEditable(true);
        kdtEntrys_hjFee_TextField.setHorizontalAlignment(2);
        kdtEntrys_hjFee_TextField.setDataType(1);
        	kdtEntrys_hjFee_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_hjFee_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_hjFee_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_hjFee_CellEditor = new KDTDefaultCellEditor(kdtEntrys_hjFee_TextField);
        this.kdtEntrys.getColumn("hjFee").setEditor(kdtEntrys_hjFee_CellEditor);
        // contearlyStand		
        this.contearlyStand.setBoundLabelText(resHelper.getString("contearlyStand.boundLabelText"));		
        this.contearlyStand.setBoundLabelLength(180);		
        this.contearlyStand.setBoundLabelUnderline(true);		
        this.contearlyStand.setVisible(true);
        // contearlyVou		
        this.contearlyVou.setBoundLabelText(resHelper.getString("contearlyVou.boundLabelText"));		
        this.contearlyVou.setBoundLabelLength(180);		
        this.contearlyVou.setBoundLabelUnderline(true);		
        this.contearlyVou.setVisible(true);
        // contearlyAudit		
        this.contearlyAudit.setBoundLabelText(resHelper.getString("contearlyAudit.boundLabelText"));		
        this.contearlyAudit.setBoundLabelLength(180);		
        this.contearlyAudit.setBoundLabelUnderline(true);		
        this.contearlyAudit.setVisible(true);
        // contearlyUnAudit		
        this.contearlyUnAudit.setBoundLabelText(resHelper.getString("contearlyUnAudit.boundLabelText"));		
        this.contearlyUnAudit.setBoundLabelLength(180);		
        this.contearlyUnAudit.setBoundLabelUnderline(true);		
        this.contearlyUnAudit.setVisible(true);
        // contearlyAllow		
        this.contearlyAllow.setBoundLabelText(resHelper.getString("contearlyAllow.boundLabelText"));		
        this.contearlyAllow.setBoundLabelLength(200);		
        this.contearlyAllow.setBoundLabelUnderline(true);		
        this.contearlyAllow.setVisible(true);
        // contmidStand		
        this.contmidStand.setBoundLabelText(resHelper.getString("contmidStand.boundLabelText"));		
        this.contmidStand.setBoundLabelLength(180);		
        this.contmidStand.setBoundLabelUnderline(true);		
        this.contmidStand.setVisible(true);
        // contmidVouch		
        this.contmidVouch.setBoundLabelText(resHelper.getString("contmidVouch.boundLabelText"));		
        this.contmidVouch.setBoundLabelLength(180);		
        this.contmidVouch.setBoundLabelUnderline(true);		
        this.contmidVouch.setVisible(true);
        // contmidAudit		
        this.contmidAudit.setBoundLabelText(resHelper.getString("contmidAudit.boundLabelText"));		
        this.contmidAudit.setBoundLabelLength(180);		
        this.contmidAudit.setBoundLabelUnderline(true);		
        this.contmidAudit.setVisible(true);
        // contmidUnAudit		
        this.contmidUnAudit.setBoundLabelText(resHelper.getString("contmidUnAudit.boundLabelText"));		
        this.contmidUnAudit.setBoundLabelLength(180);		
        this.contmidUnAudit.setBoundLabelUnderline(true);		
        this.contmidUnAudit.setVisible(true);
        // contmidAllow		
        this.contmidAllow.setBoundLabelText(resHelper.getString("contmidAllow.boundLabelText"));		
        this.contmidAllow.setBoundLabelLength(200);		
        this.contmidAllow.setBoundLabelUnderline(true);		
        this.contmidAllow.setVisible(true);
        // contlateStand		
        this.contlateStand.setBoundLabelText(resHelper.getString("contlateStand.boundLabelText"));		
        this.contlateStand.setBoundLabelLength(180);		
        this.contlateStand.setBoundLabelUnderline(true);		
        this.contlateStand.setVisible(false);
        // contlateVoucher		
        this.contlateVoucher.setBoundLabelText(resHelper.getString("contlateVoucher.boundLabelText"));		
        this.contlateVoucher.setBoundLabelLength(180);		
        this.contlateVoucher.setBoundLabelUnderline(true);		
        this.contlateVoucher.setVisible(false);
        // contlateAudit		
        this.contlateAudit.setBoundLabelText(resHelper.getString("contlateAudit.boundLabelText"));		
        this.contlateAudit.setBoundLabelLength(180);		
        this.contlateAudit.setBoundLabelUnderline(true);		
        this.contlateAudit.setVisible(false);
        // contlateUnAudit		
        this.contlateUnAudit.setBoundLabelText(resHelper.getString("contlateUnAudit.boundLabelText"));		
        this.contlateUnAudit.setBoundLabelLength(180);		
        this.contlateUnAudit.setBoundLabelUnderline(true);		
        this.contlateUnAudit.setVisible(false);
        // contlateAllow		
        this.contlateAllow.setBoundLabelText(resHelper.getString("contlateAllow.boundLabelText"));		
        this.contlateAllow.setBoundLabelLength(200);		
        this.contlateAllow.setBoundLabelUnderline(true);		
        this.contlateAllow.setVisible(false);
        // txtearlyStand		
        this.txtearlyStand.setVisible(true);		
        this.txtearlyStand.setHorizontalAlignment(2);		
        this.txtearlyStand.setDataType(1);		
        this.txtearlyStand.setSupportedEmpty(true);		
        this.txtearlyStand.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtearlyStand.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtearlyStand.setPrecision(10);		
        this.txtearlyStand.setRequired(false);
        // txtearlyVou		
        this.txtearlyVou.setVisible(true);		
        this.txtearlyVou.setHorizontalAlignment(2);		
        this.txtearlyVou.setDataType(1);		
        this.txtearlyVou.setSupportedEmpty(true);		
        this.txtearlyVou.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtearlyVou.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtearlyVou.setPrecision(10);		
        this.txtearlyVou.setRequired(false);
        // txtearlyAudit		
        this.txtearlyAudit.setVisible(true);		
        this.txtearlyAudit.setHorizontalAlignment(2);		
        this.txtearlyAudit.setDataType(1);		
        this.txtearlyAudit.setSupportedEmpty(true);		
        this.txtearlyAudit.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtearlyAudit.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtearlyAudit.setPrecision(10);		
        this.txtearlyAudit.setRequired(false);
        // txtearlyUnAudit		
        this.txtearlyUnAudit.setVisible(true);		
        this.txtearlyUnAudit.setHorizontalAlignment(2);		
        this.txtearlyUnAudit.setDataType(1);		
        this.txtearlyUnAudit.setSupportedEmpty(true);		
        this.txtearlyUnAudit.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtearlyUnAudit.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtearlyUnAudit.setPrecision(10);		
        this.txtearlyUnAudit.setRequired(false);
        // txtearlyAllow		
        this.txtearlyAllow.setVisible(true);		
        this.txtearlyAllow.setHorizontalAlignment(2);		
        this.txtearlyAllow.setDataType(1);		
        this.txtearlyAllow.setSupportedEmpty(true);		
        this.txtearlyAllow.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtearlyAllow.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtearlyAllow.setPrecision(10);		
        this.txtearlyAllow.setRequired(false);
        // txtmidStand		
        this.txtmidStand.setVisible(true);		
        this.txtmidStand.setHorizontalAlignment(2);		
        this.txtmidStand.setDataType(1);		
        this.txtmidStand.setSupportedEmpty(true);		
        this.txtmidStand.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmidStand.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmidStand.setPrecision(10);		
        this.txtmidStand.setRequired(false);
        // txtmidVouch		
        this.txtmidVouch.setVisible(true);		
        this.txtmidVouch.setHorizontalAlignment(2);		
        this.txtmidVouch.setDataType(1);		
        this.txtmidVouch.setSupportedEmpty(true);		
        this.txtmidVouch.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmidVouch.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmidVouch.setPrecision(10);		
        this.txtmidVouch.setRequired(false);
        // txtmidAudit		
        this.txtmidAudit.setVisible(true);		
        this.txtmidAudit.setHorizontalAlignment(2);		
        this.txtmidAudit.setDataType(1);		
        this.txtmidAudit.setSupportedEmpty(true);		
        this.txtmidAudit.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmidAudit.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmidAudit.setPrecision(10);		
        this.txtmidAudit.setRequired(false);
        // txtmidUnAudit		
        this.txtmidUnAudit.setVisible(true);		
        this.txtmidUnAudit.setHorizontalAlignment(2);		
        this.txtmidUnAudit.setDataType(1);		
        this.txtmidUnAudit.setSupportedEmpty(true);		
        this.txtmidUnAudit.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmidUnAudit.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmidUnAudit.setPrecision(10);		
        this.txtmidUnAudit.setRequired(false);
        // txtmidAllow		
        this.txtmidAllow.setVisible(true);		
        this.txtmidAllow.setHorizontalAlignment(2);		
        this.txtmidAllow.setDataType(1);		
        this.txtmidAllow.setSupportedEmpty(true);		
        this.txtmidAllow.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmidAllow.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmidAllow.setPrecision(10);		
        this.txtmidAllow.setRequired(false);
        // txtlateStand		
        this.txtlateStand.setVisible(false);		
        this.txtlateStand.setHorizontalAlignment(2);		
        this.txtlateStand.setDataType(1);		
        this.txtlateStand.setSupportedEmpty(true);		
        this.txtlateStand.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtlateStand.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtlateStand.setPrecision(10);		
        this.txtlateStand.setRequired(false);
        // txtlateVoucher		
        this.txtlateVoucher.setVisible(false);		
        this.txtlateVoucher.setHorizontalAlignment(2);		
        this.txtlateVoucher.setDataType(1);		
        this.txtlateVoucher.setSupportedEmpty(true);		
        this.txtlateVoucher.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtlateVoucher.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtlateVoucher.setPrecision(10);		
        this.txtlateVoucher.setRequired(false);
        // txtlateAudit		
        this.txtlateAudit.setVisible(false);		
        this.txtlateAudit.setHorizontalAlignment(2);		
        this.txtlateAudit.setDataType(1);		
        this.txtlateAudit.setSupportedEmpty(true);		
        this.txtlateAudit.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtlateAudit.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtlateAudit.setPrecision(10);		
        this.txtlateAudit.setRequired(false);
        // txtlateUnAudit		
        this.txtlateUnAudit.setVisible(false);		
        this.txtlateUnAudit.setHorizontalAlignment(2);		
        this.txtlateUnAudit.setDataType(1);		
        this.txtlateUnAudit.setSupportedEmpty(true);		
        this.txtlateUnAudit.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtlateUnAudit.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtlateUnAudit.setPrecision(10);		
        this.txtlateUnAudit.setRequired(false);
        // txtlateAllow		
        this.txtlateAllow.setVisible(false);		
        this.txtlateAllow.setHorizontalAlignment(2);		
        this.txtlateAllow.setDataType(1);		
        this.txtlateAllow.setSupportedEmpty(true);		
        this.txtlateAllow.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtlateAllow.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtlateAllow.setPrecision(10);		
        this.txtlateAllow.setRequired(false);
        // txtcontractQty		
        this.txtcontractQty.setVisible(true);		
        this.txtcontractQty.setHorizontalAlignment(2);		
        this.txtcontractQty.setDataType(1);		
        this.txtcontractQty.setSupportedEmpty(true);		
        this.txtcontractQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcontractQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcontractQty.setPrecision(10);		
        this.txtcontractQty.setRequired(false);		
        this.txtcontractQty.setEnabled(false);
        // txtallowProcess		
        this.txtallowProcess.setHorizontalAlignment(2);		
        this.txtallowProcess.setMaxLength(100);		
        this.txtallowProcess.setRequired(false);		
        this.txtallowProcess.setEnabled(false);
        // tBtnAudit
        this.tBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnAudit.setText(resHelper.getString("tBtnAudit.text"));
        // tBtnUnAudit
        this.tBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnUnAudit.setText(resHelper.getString("tBtnUnAudit.text"));
        // btnClose
        this.btnClose.setAction((IItemAction)ActionProxyFactory.getProxy(actionClose, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnClose.setText(resHelper.getString("btnClose.text"));		
        this.btnClose.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_close"));
        // btnUnClose
        this.btnUnClose.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnClose, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnClose.setText(resHelper.getString("btnUnClose.text"));		
        this.btnUnClose.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTable_success"));
        // btnViewStdUse
        this.btnViewStdUse.setAction((IItemAction)ActionProxyFactory.getProxy(actionViewStdUse, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnViewStdUse.setText(resHelper.getString("btnViewStdUse.text"));
        // mBtnAudit
        this.mBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnAudit.setText(resHelper.getString("mBtnAudit.text"));
        // mBtnUnAudit
        this.mBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnUnAudit.setText(resHelper.getString("mBtnUnAudit.text"));
        // newSeparator3
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {chkisHasSaleOrder,chkisHasSaleReturn,txtNumber,pkBizDate,prmtstorageOrgUnit,txtDescription,billStatus,prmtcompany,pkauditTime,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,chkisInit,prmtdriver,txtcarNo,txtlinkCell,prmtperson,prmtbizPerson,billType,kdtEntrys,txtvoucherNum,chkisHasMaterialReq,prmtreturnCompany,fodderSourceType,prmtfarmer,prmtfarm,prmtbatchContract,prmtbatch,prmtsettlePolicy,txtweekDay,pkindate,txtbatchQty,prmtsupplier,prmtcar,chkisTiLiao,chkisOtherIssue,chkisHasSaleIssue,chkisFromTiaoLiao,chkisSanZhuang,txtfarmerPhone,txtfarmAddress,chkisWeight,bunker,txtreturnOpinion,prmtcostCenter,prmtbreedData,txtfeedInstance,txtearlyStand,txtearlyVou,txtearlyAudit,txtearlyUnAudit,txtearlyAllow,txtmidStand,txtmidVouch,txtmidAudit,txtmidUnAudit,txtmidAllow,txtlateStand,txtlateVoucher,txtlateAudit,txtlateUnAudit,txtlateAllow,txtcontractQty,txtallowProcess}));
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
        this.setBounds(new Rectangle(0, -118, 1182, 658));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, -118, 1182, 658));
        contCreator.setBounds(new Rectangle(377, 584, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(377, 584, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(831, 586, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(831, 586, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(377, 612, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(377, 612, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(831, 614, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(831, 614, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(21, 13, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(21, 13, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(305, 13, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(305, 13, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(893, 173, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(893, 173, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(35, 584, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(35, 584, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(604, 12, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(604, 12, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompany.setBounds(new Rectangle(21, 45, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(21, 45, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(35, 612, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(35, 612, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator8.setBounds(new Rectangle(-17, 573, 1251, 8));
        this.add(kDSeparator8, new KDLayout.Constraints(-17, 573, 1251, 8, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator9.setBounds(new Rectangle(18, 267, 1179, 8));
        this.add(kDSeparator9, new KDLayout.Constraints(18, 267, 1179, 8, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contstorageOrgUnit.setBounds(new Rectangle(305, 45, 270, 19));
        this.add(contstorageOrgUnit, new KDLayout.Constraints(305, 45, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisInit.setBounds(new Rectangle(1168, 302, 270, 19));
        this.add(chkisInit, new KDLayout.Constraints(1168, 302, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contdriver.setBounds(new Rectangle(305, 173, 270, 19));
        this.add(contdriver, new KDLayout.Constraints(305, 173, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcarNo.setBounds(new Rectangle(1168, 330, 270, 19));
        this.add(contcarNo, new KDLayout.Constraints(1168, 330, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contlinkCell.setBounds(new Rectangle(604, 173, 270, 19));
        this.add(contlinkCell, new KDLayout.Constraints(604, 173, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbizPerson.setBounds(new Rectangle(1165, 275, 270, 19));
        this.add(contbizPerson, new KDLayout.Constraints(1165, 275, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contperson.setBounds(new Rectangle(21, 109, 270, 19));
        this.add(contperson, new KDLayout.Constraints(21, 109, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillType.setBounds(new Rectangle(893, 12, 270, 19));
        this.add(contbillType, new KDLayout.Constraints(893, 12, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contvoucherNum.setBounds(new Rectangle(1171, 359, 270, 19));
        this.add(contvoucherNum, new KDLayout.Constraints(1171, 359, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkisHasMaterialReq.setBounds(new Rectangle(1187, 240, 25, 19));
        this.add(chkisHasMaterialReq, new KDLayout.Constraints(1187, 240, 25, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contreturnCompany.setBounds(new Rectangle(604, 140, 270, 19));
        this.add(contreturnCompany, new KDLayout.Constraints(604, 140, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfodderSourceType.setBounds(new Rectangle(305, 141, 270, 19));
        this.add(contfodderSourceType, new KDLayout.Constraints(305, 141, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisHasSaleOrder.setBounds(new Rectangle(-1, 229, 147, 19));
        this.add(chkisHasSaleOrder, new KDLayout.Constraints(-1, 229, 147, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisHasSaleReturn.setBounds(new Rectangle(3, 226, 154, 20));
        this.add(chkisHasSaleReturn, new KDLayout.Constraints(3, 226, 154, 20, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmer.setBounds(new Rectangle(604, 44, 270, 19));
        this.add(contfarmer, new KDLayout.Constraints(604, 44, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarm.setBounds(new Rectangle(893, 44, 270, 19));
        this.add(contfarm, new KDLayout.Constraints(893, 44, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbatchContract.setBounds(new Rectangle(604, 76, 270, 19));
        this.add(contbatchContract, new KDLayout.Constraints(604, 76, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbatch.setBounds(new Rectangle(893, 76, 270, 19));
        this.add(contbatch, new KDLayout.Constraints(893, 76, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contsettlePolicy.setBounds(new Rectangle(305, 109, 270, 19));
        this.add(contsettlePolicy, new KDLayout.Constraints(305, 109, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contweekDay.setBounds(new Rectangle(21, 141, 270, 19));
        this.add(contweekDay, new KDLayout.Constraints(21, 141, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contindate.setBounds(new Rectangle(893, 108, 270, 19));
        this.add(contindate, new KDLayout.Constraints(893, 108, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbatchQty.setBounds(new Rectangle(604, 108, 270, 19));
        this.add(contbatchQty, new KDLayout.Constraints(604, 108, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsupplier.setBounds(new Rectangle(893, 140, 270, 19));
        this.add(contsupplier, new KDLayout.Constraints(893, 140, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcar.setBounds(new Rectangle(21, 173, 270, 19));
        this.add(contcar, new KDLayout.Constraints(21, 173, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisTiLiao.setBounds(new Rectangle(1189, 239, 25, 19));
        this.add(chkisTiLiao, new KDLayout.Constraints(1189, 239, 25, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisOtherIssue.setBounds(new Rectangle(1200, 241, 25, 19));
        this.add(chkisOtherIssue, new KDLayout.Constraints(1200, 241, 25, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisHasSaleIssue.setBounds(new Rectangle(1188, 240, 25, 20));
        this.add(chkisHasSaleIssue, new KDLayout.Constraints(1188, 240, 25, 20, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisFromTiaoLiao.setBounds(new Rectangle(109, 242, 113, 19));
        this.add(chkisFromTiaoLiao, new KDLayout.Constraints(109, 242, 113, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisSanZhuang.setBounds(new Rectangle(23, 242, 83, 19));
        this.add(chkisSanZhuang, new KDLayout.Constraints(23, 242, 83, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmerPhone.setBounds(new Rectangle(21, 77, 270, 19));
        this.add(contfarmerPhone, new KDLayout.Constraints(21, 77, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmAddress.setBounds(new Rectangle(305, 77, 270, 19));
        this.add(contfarmAddress, new KDLayout.Constraints(305, 77, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisWeight.setBounds(new Rectangle(226, 242, 83, 19));
        this.add(chkisWeight, new KDLayout.Constraints(226, 242, 83, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbunker.setBounds(new Rectangle(21, 205, 270, 19));
        this.add(contbunker, new KDLayout.Constraints(21, 205, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contreturnOpinion.setBounds(new Rectangle(305, 205, 272, 19));
        this.add(contreturnOpinion, new KDLayout.Constraints(305, 205, 272, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcostCenter.setBounds(new Rectangle(893, 204, 270, 19));
        this.add(contcostCenter, new KDLayout.Constraints(893, 204, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbreedData.setBounds(new Rectangle(609, 204, 270, 19));
        this.add(contbreedData, new KDLayout.Constraints(609, 204, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfeedInstance.setBounds(new Rectangle(308, 240, 270, 19));
        this.add(contfeedInstance, new KDLayout.Constraints(308, 240, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane1.setBounds(new Rectangle(24, 282, 1142, 283));
        this.add(kDTabbedPane1, new KDLayout.Constraints(24, 282, 1142, 283, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contcontractQty.setBounds(new Rectangle(609, 240, 270, 19));
        this.add(contcontractQty, new KDLayout.Constraints(609, 240, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contallowProcess.setBounds(new Rectangle(893, 240, 270, 19));
        this.add(contallowProcess, new KDLayout.Constraints(893, 240, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contstorageOrgUnit
        contstorageOrgUnit.setBoundEditor(prmtstorageOrgUnit);
        //contdriver
        contdriver.setBoundEditor(prmtdriver);
        //contcarNo
        contcarNo.setBoundEditor(txtcarNo);
        //contlinkCell
        contlinkCell.setBoundEditor(txtlinkCell);
        //contbizPerson
        contbizPerson.setBoundEditor(prmtbizPerson);
        //contperson
        contperson.setBoundEditor(prmtperson);
        //contbillType
        contbillType.setBoundEditor(billType);
        //contvoucherNum
        contvoucherNum.setBoundEditor(txtvoucherNum);
        //contreturnCompany
        contreturnCompany.setBoundEditor(prmtreturnCompany);
        //contfodderSourceType
        contfodderSourceType.setBoundEditor(fodderSourceType);
        //contfarmer
        contfarmer.setBoundEditor(prmtfarmer);
        //contfarm
        contfarm.setBoundEditor(prmtfarm);
        //contbatchContract
        contbatchContract.setBoundEditor(prmtbatchContract);
        //contbatch
        contbatch.setBoundEditor(prmtbatch);
        //contsettlePolicy
        contsettlePolicy.setBoundEditor(prmtsettlePolicy);
        //contweekDay
        contweekDay.setBoundEditor(txtweekDay);
        //contindate
        contindate.setBoundEditor(pkindate);
        //contbatchQty
        contbatchQty.setBoundEditor(txtbatchQty);
        //contsupplier
        contsupplier.setBoundEditor(prmtsupplier);
        //contcar
        contcar.setBoundEditor(prmtcar);
        //contfarmerPhone
        contfarmerPhone.setBoundEditor(txtfarmerPhone);
        //contfarmAddress
        contfarmAddress.setBoundEditor(txtfarmAddress);
        //contbunker
        contbunker.setBoundEditor(bunker);
        //contreturnOpinion
        contreturnOpinion.setBoundEditor(txtreturnOpinion);
        //contcostCenter
        contcostCenter.setBoundEditor(prmtcostCenter);
        //contbreedData
        contbreedData.setBoundEditor(prmtbreedData);
        //contfeedInstance
        contfeedInstance.setBoundEditor(txtfeedInstance);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1141, 250));        kdtEntrys.setBounds(new Rectangle(1, 4, 1127, 242));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionEntryInfo(),null,false);
        kDPanel1.add(kdtEntrys_detailPanel, new KDLayout.Constraints(1, 4, 1127, 242, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel2
        kDPanel2.setLayout(null);        contearlyStand.setBounds(new Rectangle(20, 14, 270, 19));
        kDPanel2.add(contearlyStand, null);
        contearlyVou.setBounds(new Rectangle(20, 52, 270, 19));
        kDPanel2.add(contearlyVou, null);
        contearlyAudit.setBounds(new Rectangle(20, 90, 270, 19));
        kDPanel2.add(contearlyAudit, null);
        contearlyUnAudit.setBounds(new Rectangle(20, 128, 270, 19));
        kDPanel2.add(contearlyUnAudit, null);
        contearlyAllow.setBounds(new Rectangle(20, 167, 270, 19));
        kDPanel2.add(contearlyAllow, null);
        contmidStand.setBounds(new Rectangle(348, 14, 270, 19));
        kDPanel2.add(contmidStand, null);
        contmidVouch.setBounds(new Rectangle(348, 52, 270, 19));
        kDPanel2.add(contmidVouch, null);
        contmidAudit.setBounds(new Rectangle(348, 90, 270, 19));
        kDPanel2.add(contmidAudit, null);
        contmidUnAudit.setBounds(new Rectangle(348, 128, 270, 19));
        kDPanel2.add(contmidUnAudit, null);
        contmidAllow.setBounds(new Rectangle(348, 167, 270, 19));
        kDPanel2.add(contmidAllow, null);
        contlateStand.setBounds(new Rectangle(660, 14, 270, 19));
        kDPanel2.add(contlateStand, null);
        contlateVoucher.setBounds(new Rectangle(660, 52, 270, 19));
        kDPanel2.add(contlateVoucher, null);
        contlateAudit.setBounds(new Rectangle(660, 90, 270, 19));
        kDPanel2.add(contlateAudit, null);
        contlateUnAudit.setBounds(new Rectangle(660, 128, 270, 19));
        kDPanel2.add(contlateUnAudit, null);
        contlateAllow.setBounds(new Rectangle(660, 167, 270, 19));
        kDPanel2.add(contlateAllow, null);
        //contearlyStand
        contearlyStand.setBoundEditor(txtearlyStand);
        //contearlyVou
        contearlyVou.setBoundEditor(txtearlyVou);
        //contearlyAudit
        contearlyAudit.setBoundEditor(txtearlyAudit);
        //contearlyUnAudit
        contearlyUnAudit.setBoundEditor(txtearlyUnAudit);
        //contearlyAllow
        contearlyAllow.setBoundEditor(txtearlyAllow);
        //contmidStand
        contmidStand.setBoundEditor(txtmidStand);
        //contmidVouch
        contmidVouch.setBoundEditor(txtmidVouch);
        //contmidAudit
        contmidAudit.setBoundEditor(txtmidAudit);
        //contmidUnAudit
        contmidUnAudit.setBoundEditor(txtmidUnAudit);
        //contmidAllow
        contmidAllow.setBoundEditor(txtmidAllow);
        //contlateStand
        contlateStand.setBoundEditor(txtlateStand);
        //contlateVoucher
        contlateVoucher.setBoundEditor(txtlateVoucher);
        //contlateAudit
        contlateAudit.setBoundEditor(txtlateAudit);
        //contlateUnAudit
        contlateUnAudit.setBoundEditor(txtlateUnAudit);
        //contlateAllow
        contlateAllow.setBoundEditor(txtlateAllow);
        //contcontractQty
        contcontractQty.setBoundEditor(txtcontractQty);
        //contallowProcess
        contallowProcess.setBoundEditor(txtallowProcess);

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
        menuBiz.add(newSeparator3);
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        menuBiz.add(MenuItemPCVoucher);
        menuBiz.add(MenuItemVoucher);
        menuBiz.add(menuItemDelPCVoucher);
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
        this.toolBar.add(tBtnAudit);
        this.toolBar.add(tBtnUnAudit);
        this.toolBar.add(btnClose);
        this.toolBar.add(btnUnClose);
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
        this.toolBar.add(btnPCVoucher);
        this.toolBar.add(separatorFW9);
        this.toolBar.add(btnDelPCVoucher);
        this.toolBar.add(btnVoucher);
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(btnNextPerson);
        this.toolBar.add(btnViewStdUse);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("isInit", boolean.class, this.chkisInit, "selected");
		dataBinder.registerBinding("isHasMaterialReq", boolean.class, this.chkisHasMaterialReq, "selected");
		dataBinder.registerBinding("isHasSaleOrder", boolean.class, this.chkisHasSaleOrder, "selected");
		dataBinder.registerBinding("isHasSaleReturn", boolean.class, this.chkisHasSaleReturn, "selected");
		dataBinder.registerBinding("isTiLiao", boolean.class, this.chkisTiLiao, "selected");
		dataBinder.registerBinding("isOtherIssue", boolean.class, this.chkisOtherIssue, "selected");
		dataBinder.registerBinding("isHasSaleIssue", boolean.class, this.chkisHasSaleIssue, "selected");
		dataBinder.registerBinding("isFromTiaoLiao", boolean.class, this.chkisFromTiaoLiao, "selected");
		dataBinder.registerBinding("isSanZhuang", boolean.class, this.chkisSanZhuang, "selected");
		dataBinder.registerBinding("isWeight", boolean.class, this.chkisWeight, "selected");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("storageOrgUnit", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtstorageOrgUnit, "data");
		dataBinder.registerBinding("driver", com.kingdee.eas.farm.feemanager.basedata.DriverInfo.class, this.prmtdriver, "data");
		dataBinder.registerBinding("carNo", String.class, this.txtcarNo, "text");
		dataBinder.registerBinding("linkCell", String.class, this.txtlinkCell, "text");
		dataBinder.registerBinding("bizPerson", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtbizPerson, "data");
		dataBinder.registerBinding("person", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtperson, "data");
		dataBinder.registerBinding("billType", com.kingdee.eas.farm.carnivorous.feedbiz.FodderBillType.class, this.billType, "selectedItem");
		dataBinder.registerBinding("voucherNum", String.class, this.txtvoucherNum, "text");
		dataBinder.registerBinding("returnCompany", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtreturnCompany, "data");
		dataBinder.registerBinding("fodderSourceType", com.kingdee.eas.farm.carnivorous.feedbiz.fodderSourceType.class, this.fodderSourceType, "selectedItem");
		dataBinder.registerBinding("farmer", com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo.class, this.prmtfarmer, "data");
		dataBinder.registerBinding("farm", com.kingdee.eas.farm.carnivorous.basedata.FarmInfo.class, this.prmtfarm, "data");
		dataBinder.registerBinding("batchContract", com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo.class, this.prmtbatchContract, "data");
		dataBinder.registerBinding("batch", com.kingdee.eas.farm.carnivorous.basedata.BatchInfo.class, this.prmtbatch, "data");
		dataBinder.registerBinding("settlePolicy", com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo.class, this.prmtsettlePolicy, "data");
		dataBinder.registerBinding("weekDay", int.class, this.txtweekDay, "value");
		dataBinder.registerBinding("indate", java.util.Date.class, this.pkindate, "value");
		dataBinder.registerBinding("batchQty", java.math.BigDecimal.class, this.txtbatchQty, "value");
		dataBinder.registerBinding("supplier", com.kingdee.eas.basedata.master.cssp.SupplierInfo.class, this.prmtsupplier, "data");
		dataBinder.registerBinding("car", com.kingdee.eas.publicdata.CarInfo.class, this.prmtcar, "data");
		dataBinder.registerBinding("farmerPhone", String.class, this.txtfarmerPhone, "text");
		dataBinder.registerBinding("farmAddress", String.class, this.txtfarmAddress, "text");
		dataBinder.registerBinding("bunker", com.kingdee.eas.farm.carnivorous.basedata.BunkerEnum.class, this.bunker, "selectedItem");
		dataBinder.registerBinding("returnOpinion", String.class, this.txtreturnOpinion, "text");
		dataBinder.registerBinding("costCenter", com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo.class, this.prmtcostCenter, "data");
		dataBinder.registerBinding("breedData", com.kingdee.eas.farm.stocking.basedata.BreedDataInfo.class, this.prmtbreedData, "data");
		dataBinder.registerBinding("feedInstance", java.math.BigDecimal.class, this.txtfeedInstance, "value");
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.material", java.lang.Object.class, this.kdtEntrys, "material.text");
		dataBinder.registerBinding("entrys.materialName", String.class, this.kdtEntrys, "materialName.text");
		dataBinder.registerBinding("entrys.model", String.class, this.kdtEntrys, "model.text");
		dataBinder.registerBinding("entrys.warehouse", java.lang.Object.class, this.kdtEntrys, "warehouse.text");
		dataBinder.registerBinding("entrys.receiveQty", java.math.BigDecimal.class, this.kdtEntrys, "receiveQty.text");
		dataBinder.registerBinding("entrys.confirmQty", java.math.BigDecimal.class, this.kdtEntrys, "confirmQty.text");
		dataBinder.registerBinding("entrys.receivePrice", java.math.BigDecimal.class, this.kdtEntrys, "receivePrice.text");
		dataBinder.registerBinding("entrys.unit", java.lang.Object.class, this.kdtEntrys, "unit.text");
		dataBinder.registerBinding("entrys.amount", java.math.BigDecimal.class, this.kdtEntrys, "amount.text");
		dataBinder.registerBinding("entrys.basePrice", java.math.BigDecimal.class, this.kdtEntrys, "basePrice.text");
		dataBinder.registerBinding("entrys.unitQty", java.math.BigDecimal.class, this.kdtEntrys, "unitQty.text");
		dataBinder.registerBinding("entrys.bagQty", java.math.BigDecimal.class, this.kdtEntrys, "bagQty.text");
		dataBinder.registerBinding("entrys.weekAge", String.class, this.kdtEntrys, "weekAge.text");
		dataBinder.registerBinding("entrys.driver", java.lang.Object.class, this.kdtEntrys, "driver.text");
		dataBinder.registerBinding("entrys.farmer", java.lang.Object.class, this.kdtEntrys, "farmer.text");
		dataBinder.registerBinding("entrys.farm", java.lang.Object.class, this.kdtEntrys, "farm.text");
		dataBinder.registerBinding("entrys.batch", java.lang.Object.class, this.kdtEntrys, "batch.text");
		dataBinder.registerBinding("entrys.batchContract", java.lang.Object.class, this.kdtEntrys, "batchContract.text");
		dataBinder.registerBinding("entrys.unitCost", java.math.BigDecimal.class, this.kdtEntrys, "unitCost.text");
		dataBinder.registerBinding("entrys.actualCost", java.math.BigDecimal.class, this.kdtEntrys, "actualCost.text");
		dataBinder.registerBinding("entrys.person", java.lang.Object.class, this.kdtEntrys, "person.text");
		dataBinder.registerBinding("entrys.bizPerson", java.lang.Object.class, this.kdtEntrys, "bizPerson.text");
		dataBinder.registerBinding("entrys.confirmTime", java.util.Date.class, this.kdtEntrys, "confirmTime.text");
		dataBinder.registerBinding("entrys.feedStandard", java.math.BigDecimal.class, this.kdtEntrys, "feedStandard.text");
		dataBinder.registerBinding("entrys.totalReceivedQty", java.math.BigDecimal.class, this.kdtEntrys, "totalReceivedQty.text");
		dataBinder.registerBinding("entrys.remark", String.class, this.kdtEntrys, "remark.text");
		dataBinder.registerBinding("entrys.productionDate", java.util.Date.class, this.kdtEntrys, "productionDate.text");
		dataBinder.registerBinding("entrys.shift", String.class, this.kdtEntrys, "shift.text");
		dataBinder.registerBinding("entrys.hjFee", java.math.BigDecimal.class, this.kdtEntrys, "hjFee.text");
		dataBinder.registerBinding("earlyStand", java.math.BigDecimal.class, this.txtearlyStand, "value");
		dataBinder.registerBinding("earlyVou", java.math.BigDecimal.class, this.txtearlyVou, "value");
		dataBinder.registerBinding("earlyAudit", java.math.BigDecimal.class, this.txtearlyAudit, "value");
		dataBinder.registerBinding("earlyUnAudit", java.math.BigDecimal.class, this.txtearlyUnAudit, "value");
		dataBinder.registerBinding("earlyAllow", java.math.BigDecimal.class, this.txtearlyAllow, "value");
		dataBinder.registerBinding("midStand", java.math.BigDecimal.class, this.txtmidStand, "value");
		dataBinder.registerBinding("midVouch", java.math.BigDecimal.class, this.txtmidVouch, "value");
		dataBinder.registerBinding("midAudit", java.math.BigDecimal.class, this.txtmidAudit, "value");
		dataBinder.registerBinding("midUnAudit", java.math.BigDecimal.class, this.txtmidUnAudit, "value");
		dataBinder.registerBinding("midAllow", java.math.BigDecimal.class, this.txtmidAllow, "value");
		dataBinder.registerBinding("lateStand", java.math.BigDecimal.class, this.txtlateStand, "value");
		dataBinder.registerBinding("lateVoucher", java.math.BigDecimal.class, this.txtlateVoucher, "value");
		dataBinder.registerBinding("lateAudit", java.math.BigDecimal.class, this.txtlateAudit, "value");
		dataBinder.registerBinding("lateUnAudit", java.math.BigDecimal.class, this.txtlateUnAudit, "value");
		dataBinder.registerBinding("lateAllow", java.math.BigDecimal.class, this.txtlateAllow, "value");
		dataBinder.registerBinding("contractQty", java.math.BigDecimal.class, this.txtcontractQty, "value");
		dataBinder.registerBinding("allowProcess", String.class, this.txtallowProcess, "text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.carnivorous.feedbiz.app.FodderReceptionEditUIHandler";
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
        this.chkisHasSaleOrder.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionInfo)ov;
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
		getValidateHelper().registerBindProperty("isInit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isHasMaterialReq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isHasSaleOrder", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isHasSaleReturn", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isTiLiao", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isOtherIssue", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isHasSaleIssue", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isFromTiaoLiao", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isSanZhuang", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("storageOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("driver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("carNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("linkCell", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizPerson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("person", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("voucherNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("returnCompany", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fodderSourceType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batchContract", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("settlePolicy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("weekDay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("indate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batchQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("supplier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("car", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmerPhone", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmAddress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bunker", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("returnOpinion", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("costCenter", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedData", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("feedInstance", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.materialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.model", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.warehouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.receiveQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.confirmQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.receivePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.basePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.unitQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.bagQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.weekAge", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.driver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.batch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.batchContract", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.unitCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.actualCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.person", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.bizPerson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.confirmTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.feedStandard", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.totalReceivedQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.productionDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.shift", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.hjFee", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("earlyStand", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("earlyVou", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("earlyAudit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("earlyUnAudit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("earlyAllow", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("midStand", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("midVouch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("midAudit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("midUnAudit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("midAllow", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lateStand", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lateVoucher", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lateAudit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lateUnAudit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lateAllow", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contractQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allowProcess", ValidateHelper.ON_SAVE);    		
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
     * output kdtEntrys_editStopped method
     */
    protected void kdtEntrys_editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
    }

    /**
     * output kdtEntrys_editStarting method
     */
    protected void kdtEntrys_editStarting(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
    }


    /**
     * output prmtdriver_Changed() method
     */
    public void prmtdriver_Changed() throws Exception
    {
        System.out.println("prmtdriver_Changed() Function is executed!");
            txtlinkCell.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtdriver.getData(),"driverphone")));

    txtcarNo.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtdriver.getData(),"drivercarinfo")));


    }

    /**
     * output prmtfarmer_Changed() method
     */
    public void prmtfarmer_Changed() throws Exception
    {
        System.out.println("prmtfarmer_Changed() Function is executed!");
            txtfarmerPhone.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtfarmer.getData(),"mobileTel")));


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
     * output kdtEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"materialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"material").getValue(),"name")));

}

    if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"model").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"material").getValue(),"model")));

}

    if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"unit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"material").getValue(),"baseUnit"));

}

    if ("unitQty".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"receiveQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,"unitQty").getValue())* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,"bagQty").getValue())));

}

    if ("bagQty".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"receiveQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,"unitQty").getValue())* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,"bagQty").getValue())));

}

    if ("receiveQty".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
if (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,"confirmQty").getValue())<= 0) 
{
    kdtEntrys.getCell(rowIndex,"confirmQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex,"receiveQty").getValue()));
}

}

    if ("confirmQty".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"amount").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,"receivePrice").getValue())* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,"confirmQty").getValue())));

}

    if ("basePrice".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
if (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,"receivePrice").getValue())<= 0) 
{
    kdtEntrys.getCell(rowIndex,"receivePrice").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex,"basePrice").getValue()));
}

}

    if ("receivePrice".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"amount").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,"receivePrice").getValue())* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,"confirmQty").getValue())));

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
        sic.add(new SelectorItemInfo("isInit"));
        sic.add(new SelectorItemInfo("isHasMaterialReq"));
        sic.add(new SelectorItemInfo("isHasSaleOrder"));
        sic.add(new SelectorItemInfo("isHasSaleReturn"));
        sic.add(new SelectorItemInfo("isTiLiao"));
        sic.add(new SelectorItemInfo("isOtherIssue"));
        sic.add(new SelectorItemInfo("isHasSaleIssue"));
        sic.add(new SelectorItemInfo("isFromTiaoLiao"));
        sic.add(new SelectorItemInfo("isSanZhuang"));
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
        sic.add(new SelectorItemInfo("billStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
        sic.add(new SelectorItemInfo("auditTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("storageOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("storageOrgUnit.id"));
        	sic.add(new SelectorItemInfo("storageOrgUnit.number"));
        	sic.add(new SelectorItemInfo("storageOrgUnit.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("driver.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("driver.id"));
        	sic.add(new SelectorItemInfo("driver.number"));
        	sic.add(new SelectorItemInfo("driver.name"));
        	sic.add(new SelectorItemInfo("driver.drivername"));
		}
        sic.add(new SelectorItemInfo("carNo"));
        sic.add(new SelectorItemInfo("linkCell"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("bizPerson.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("bizPerson.id"));
        	sic.add(new SelectorItemInfo("bizPerson.number"));
        	sic.add(new SelectorItemInfo("bizPerson.name"));
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
        sic.add(new SelectorItemInfo("billType"));
        sic.add(new SelectorItemInfo("voucherNum"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("returnCompany.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("returnCompany.id"));
        	sic.add(new SelectorItemInfo("returnCompany.number"));
        	sic.add(new SelectorItemInfo("returnCompany.name"));
		}
        sic.add(new SelectorItemInfo("fodderSourceType"));
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("batchContract.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("batchContract.id"));
        	sic.add(new SelectorItemInfo("batchContract.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("batch.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("batch.id"));
        	sic.add(new SelectorItemInfo("batch.number"));
        	sic.add(new SelectorItemInfo("batch.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("settlePolicy.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("settlePolicy.id"));
        	sic.add(new SelectorItemInfo("settlePolicy.number"));
        	sic.add(new SelectorItemInfo("settlePolicy.name"));
		}
        sic.add(new SelectorItemInfo("weekDay"));
        sic.add(new SelectorItemInfo("indate"));
        sic.add(new SelectorItemInfo("batchQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("supplier.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("supplier.id"));
        	sic.add(new SelectorItemInfo("supplier.number"));
        	sic.add(new SelectorItemInfo("supplier.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("car.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("car.id"));
        	sic.add(new SelectorItemInfo("car.number"));
        	sic.add(new SelectorItemInfo("car.name"));
		}
        sic.add(new SelectorItemInfo("farmerPhone"));
        sic.add(new SelectorItemInfo("farmAddress"));
        sic.add(new SelectorItemInfo("bunker"));
        sic.add(new SelectorItemInfo("returnOpinion"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("costCenter.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("costCenter.id"));
        	sic.add(new SelectorItemInfo("costCenter.number"));
        	sic.add(new SelectorItemInfo("costCenter.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("breedData.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("breedData.id"));
        	sic.add(new SelectorItemInfo("breedData.number"));
        	sic.add(new SelectorItemInfo("breedData.name"));
		}
        sic.add(new SelectorItemInfo("feedInstance"));
    	sic.add(new SelectorItemInfo("entrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.material.id"));
			sic.add(new SelectorItemInfo("entrys.material.number"));
			sic.add(new SelectorItemInfo("entrys.material.name"));
		}
    	sic.add(new SelectorItemInfo("entrys.materialName"));
    	sic.add(new SelectorItemInfo("entrys.model"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.warehouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.warehouse.id"));
			sic.add(new SelectorItemInfo("entrys.warehouse.name"));
        	sic.add(new SelectorItemInfo("entrys.warehouse.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.receiveQty"));
    	sic.add(new SelectorItemInfo("entrys.confirmQty"));
    	sic.add(new SelectorItemInfo("entrys.receivePrice"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.unit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.unit.id"));
			sic.add(new SelectorItemInfo("entrys.unit.name"));
        	sic.add(new SelectorItemInfo("entrys.unit.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.amount"));
    	sic.add(new SelectorItemInfo("entrys.basePrice"));
    	sic.add(new SelectorItemInfo("entrys.unitQty"));
    	sic.add(new SelectorItemInfo("entrys.bagQty"));
    	sic.add(new SelectorItemInfo("entrys.weekAge"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.driver.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.driver.id"));
			sic.add(new SelectorItemInfo("entrys.driver.drivername"));
			sic.add(new SelectorItemInfo("entrys.driver.name"));
        	sic.add(new SelectorItemInfo("entrys.driver.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.farmer.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.farmer.id"));
			sic.add(new SelectorItemInfo("entrys.farmer.name"));
        	sic.add(new SelectorItemInfo("entrys.farmer.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.farm.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.farm.id"));
			sic.add(new SelectorItemInfo("entrys.farm.name"));
        	sic.add(new SelectorItemInfo("entrys.farm.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.batch.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.batch.id"));
			sic.add(new SelectorItemInfo("entrys.batch.number"));
			sic.add(new SelectorItemInfo("entrys.batch.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.batchContract.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.batchContract.id"));
			sic.add(new SelectorItemInfo("entrys.batchContract.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.unitCost"));
    	sic.add(new SelectorItemInfo("entrys.actualCost"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.person.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.person.id"));
			sic.add(new SelectorItemInfo("entrys.person.name"));
        	sic.add(new SelectorItemInfo("entrys.person.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.bizPerson.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.bizPerson.id"));
			sic.add(new SelectorItemInfo("entrys.bizPerson.name"));
        	sic.add(new SelectorItemInfo("entrys.bizPerson.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.confirmTime"));
    	sic.add(new SelectorItemInfo("entrys.feedStandard"));
    	sic.add(new SelectorItemInfo("entrys.totalReceivedQty"));
    	sic.add(new SelectorItemInfo("entrys.remark"));
    	sic.add(new SelectorItemInfo("entrys.productionDate"));
    	sic.add(new SelectorItemInfo("entrys.shift"));
    	sic.add(new SelectorItemInfo("entrys.hjFee"));
        sic.add(new SelectorItemInfo("earlyStand"));
        sic.add(new SelectorItemInfo("earlyVou"));
        sic.add(new SelectorItemInfo("earlyAudit"));
        sic.add(new SelectorItemInfo("earlyUnAudit"));
        sic.add(new SelectorItemInfo("earlyAllow"));
        sic.add(new SelectorItemInfo("midStand"));
        sic.add(new SelectorItemInfo("midVouch"));
        sic.add(new SelectorItemInfo("midAudit"));
        sic.add(new SelectorItemInfo("midUnAudit"));
        sic.add(new SelectorItemInfo("midAllow"));
        sic.add(new SelectorItemInfo("lateStand"));
        sic.add(new SelectorItemInfo("lateVoucher"));
        sic.add(new SelectorItemInfo("lateAudit"));
        sic.add(new SelectorItemInfo("lateUnAudit"));
        sic.add(new SelectorItemInfo("lateAllow"));
        sic.add(new SelectorItemInfo("contractQty"));
        sic.add(new SelectorItemInfo("allowProcess"));
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
        com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionViewStdUse_actionPerformed method
     */
    public void actionViewStdUse_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionFactory.getRemoteInstance().viewStdUse(editData);
    }
    	

    /**
     * output actionChkVoucherFlag_actionPerformed method
     */
    public void actionChkVoucherFlag_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionFactory.getRemoteInstance().chkVoucherFlag(editData);
    }
    	

    /**
     * output actionChkVoucherAll_actionPerformed method
     */
    public void actionChkVoucherAll_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionFactory.getRemoteInstance().chkVoucherAll(editData);
    }
    	

    /**
     * output actionBatchSubmit_actionPerformed method
     */
    public void actionBatchSubmit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionFactory.getRemoteInstance().batchSubmit(editData);
    }
    	

    /**
     * output actionClose_actionPerformed method
     */
    public void actionClose_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionFactory.getRemoteInstance().close(editData);
    }
    	

    /**
     * output actionUnClose_actionPerformed method
     */
    public void actionUnClose_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionFactory.getRemoteInstance().unClose(editData);
    }
    	

    /**
     * output actionUpdatePrice_actionPerformed method
     */
    public void actionUpdatePrice_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionFactory.getRemoteInstance().updatePrice(editData);
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
	public RequestContext prepareActionViewStdUse(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionViewStdUse() {
    	return false;
    }
	public RequestContext prepareActionChkVoucherFlag(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionChkVoucherFlag() {
    	return false;
    }
	public RequestContext prepareActionChkVoucherAll(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionChkVoucherAll() {
    	return false;
    }
	public RequestContext prepareActionBatchSubmit(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionBatchSubmit() {
    	return false;
    }
	public RequestContext prepareActionClose(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionClose() {
    	return false;
    }
	public RequestContext prepareActionUnClose(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionUnClose() {
    	return false;
    }
	public RequestContext prepareActionUpdatePrice(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionUpdatePrice() {
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
            innerActionPerformed("eas", AbstractFodderReceptionEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractFodderReceptionEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionViewStdUse class
     */     
    protected class ActionViewStdUse extends ItemAction {     
    
        public ActionViewStdUse()
        {
            this(null);
        }

        public ActionViewStdUse(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionViewStdUse.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionViewStdUse.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionViewStdUse.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractFodderReceptionEditUI.this, "ActionViewStdUse", "actionViewStdUse_actionPerformed", e);
        }
    }

    /**
     * output ActionChkVoucherFlag class
     */     
    protected class ActionChkVoucherFlag extends ItemAction {     
    
        public ActionChkVoucherFlag()
        {
            this(null);
        }

        public ActionChkVoucherFlag(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionChkVoucherFlag.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionChkVoucherFlag.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionChkVoucherFlag.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractFodderReceptionEditUI.this, "ActionChkVoucherFlag", "actionChkVoucherFlag_actionPerformed", e);
        }
    }

    /**
     * output ActionChkVoucherAll class
     */     
    protected class ActionChkVoucherAll extends ItemAction {     
    
        public ActionChkVoucherAll()
        {
            this(null);
        }

        public ActionChkVoucherAll(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionChkVoucherAll.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionChkVoucherAll.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionChkVoucherAll.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractFodderReceptionEditUI.this, "ActionChkVoucherAll", "actionChkVoucherAll_actionPerformed", e);
        }
    }

    /**
     * output ActionBatchSubmit class
     */     
    protected class ActionBatchSubmit extends ItemAction {     
    
        public ActionBatchSubmit()
        {
            this(null);
        }

        public ActionBatchSubmit(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionBatchSubmit.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionBatchSubmit.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionBatchSubmit.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractFodderReceptionEditUI.this, "ActionBatchSubmit", "actionBatchSubmit_actionPerformed", e);
        }
    }

    /**
     * output ActionClose class
     */     
    protected class ActionClose extends ItemAction {     
    
        public ActionClose()
        {
            this(null);
        }

        public ActionClose(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionClose.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionClose.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionClose.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractFodderReceptionEditUI.this, "ActionClose", "actionClose_actionPerformed", e);
        }
    }

    /**
     * output ActionUnClose class
     */     
    protected class ActionUnClose extends ItemAction {     
    
        public ActionUnClose()
        {
            this(null);
        }

        public ActionUnClose(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionUnClose.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnClose.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnClose.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractFodderReceptionEditUI.this, "ActionUnClose", "actionUnClose_actionPerformed", e);
        }
    }

    /**
     * output ActionUpdatePrice class
     */     
    protected class ActionUpdatePrice extends ItemAction {     
    
        public ActionUpdatePrice()
        {
            this(null);
        }

        public ActionUpdatePrice(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionUpdatePrice.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUpdatePrice.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUpdatePrice.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractFodderReceptionEditUI.this, "ActionUpdatePrice", "actionUpdatePrice_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.feedbiz.client", "FodderReceptionEditUI");
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
        return com.kingdee.eas.farm.carnivorous.feedbiz.client.FodderReceptionEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionInfo objectValue = new com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/carnivorous/feedbiz/FodderReception";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.carnivorous.feedbiz.app.FodderReceptionQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtstorageOrgUnit.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"库存组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(billType.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"单据类型"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(fodderSourceType.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"来源类型"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtfarmer.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖户"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtfarm.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖场"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtbatchContract.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"批次合同"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcostCenter.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"成本中心"});
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"material").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"饲料编码"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"unit").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"单位"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"warehouse").getValue())) {
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
		vo.put("billStatus",new Integer(-1));
vo.put("billType","1");
vo.put("fodderSourceType","0");
vo.put("bunker","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}