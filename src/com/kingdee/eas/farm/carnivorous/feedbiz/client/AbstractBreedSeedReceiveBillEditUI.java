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
public abstract class AbstractBreedSeedReceiveBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractBreedSeedReceiveBillEditUI.class);
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
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedData;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatch;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatchContract;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdriver;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbizType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contvoucherNum;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisHasMaterialReq;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisHasSaleIssue;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contseedSourceType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsourceHatchArea;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contactualBizdate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsettlePolicy;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpurSupplier;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisOtherIssue;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmerPhone;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmAddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contseedSource;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcostObject;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisInsertImm;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisManuIn;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisOtherIn;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenPerson;
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
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbreedData;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarm;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbatch;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbatchContract;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtdriver;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperson;
    protected com.kingdee.bos.ctrl.swing.KDComboBox bizType;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtvoucherNum;
    protected com.kingdee.bos.ctrl.swing.KDComboBox seedSourceType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsourceHatchArea;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkactualBizdate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsettlePolicy;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpurSupplier;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfarmerPhone;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfarmAddress;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtseedSource;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcostObject;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtchickenPerson;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnClose;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnClose;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAddDriver;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDSeparator newSeparator3;
    protected com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionChkVoucherFlag actionChkVoucherFlag = null;
    protected ActionChkVoucherAll actionChkVoucherAll = null;
    protected ActionClose actionClose = null;
    protected ActionUnClose actionUnClose = null;
    protected ActionUpdatePrice actionUpdatePrice = null;
    /**
     * output class constructor
     */
    public AbstractBreedSeedReceiveBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractBreedSeedReceiveBillEditUI.class.getName());
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
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contstorageOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbreedData = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbatch = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbatchContract = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdriver = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbizType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contvoucherNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisHasMaterialReq = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisHasSaleIssue = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contseedSourceType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsourceHatchArea = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contactualBizdate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsettlePolicy = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpurSupplier = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisOtherIssue = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contfarmerPhone = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmAddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contseedSource = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcostObject = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisInsertImm = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisManuIn = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisOtherIn = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contchickenPerson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
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
        this.prmtbreedData = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtfarmer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtfarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbatch = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbatchContract = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtdriver = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtperson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.bizType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtvoucherNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.seedSourceType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtsourceHatchArea = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkactualBizdate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtsettlePolicy = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtpurSupplier = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtfarmerPhone = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtfarmAddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtseedSource = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtcostObject = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtchickenPerson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.tBtnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnClose = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnClose = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnAddDriver = new com.kingdee.bos.ctrl.swing.KDWorkButton();
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
        this.kdtEntrys.setName("kdtEntrys");
        this.contstorageOrgUnit.setName("contstorageOrgUnit");
        this.contbreedData.setName("contbreedData");
        this.contfarmer.setName("contfarmer");
        this.contfarm.setName("contfarm");
        this.contbatch.setName("contbatch");
        this.contbatchContract.setName("contbatchContract");
        this.contdriver.setName("contdriver");
        this.contperson.setName("contperson");
        this.contbizType.setName("contbizType");
        this.contvoucherNum.setName("contvoucherNum");
        this.chkisHasMaterialReq.setName("chkisHasMaterialReq");
        this.chkisHasSaleIssue.setName("chkisHasSaleIssue");
        this.contseedSourceType.setName("contseedSourceType");
        this.contsourceHatchArea.setName("contsourceHatchArea");
        this.contactualBizdate.setName("contactualBizdate");
        this.contsettlePolicy.setName("contsettlePolicy");
        this.contpurSupplier.setName("contpurSupplier");
        this.chkisOtherIssue.setName("chkisOtherIssue");
        this.contfarmerPhone.setName("contfarmerPhone");
        this.contfarmAddress.setName("contfarmAddress");
        this.contseedSource.setName("contseedSource");
        this.contcostObject.setName("contcostObject");
        this.chkisInsertImm.setName("chkisInsertImm");
        this.chkisManuIn.setName("chkisManuIn");
        this.chkisOtherIn.setName("chkisOtherIn");
        this.contchickenPerson.setName("contchickenPerson");
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
        this.prmtbreedData.setName("prmtbreedData");
        this.prmtfarmer.setName("prmtfarmer");
        this.prmtfarm.setName("prmtfarm");
        this.prmtbatch.setName("prmtbatch");
        this.prmtbatchContract.setName("prmtbatchContract");
        this.prmtdriver.setName("prmtdriver");
        this.prmtperson.setName("prmtperson");
        this.bizType.setName("bizType");
        this.txtvoucherNum.setName("txtvoucherNum");
        this.seedSourceType.setName("seedSourceType");
        this.prmtsourceHatchArea.setName("prmtsourceHatchArea");
        this.pkactualBizdate.setName("pkactualBizdate");
        this.prmtsettlePolicy.setName("prmtsettlePolicy");
        this.prmtpurSupplier.setName("prmtpurSupplier");
        this.txtfarmerPhone.setName("txtfarmerPhone");
        this.txtfarmAddress.setName("txtfarmAddress");
        this.txtseedSource.setName("txtseedSource");
        this.prmtcostObject.setName("prmtcostObject");
        this.prmtchickenPerson.setName("prmtchickenPerson");
        this.tBtnAudit.setName("tBtnAudit");
        this.tBtnUnAudit.setName("tBtnUnAudit");
        this.btnClose.setName("btnClose");
        this.btnUnClose.setName("btnUnClose");
        this.btnAddDriver.setName("btnAddDriver");
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
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol16\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol17\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol18\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol19\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol20\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol22\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol23\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol26\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol27\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"house\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"materialName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"receiveQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"lossQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"supplementQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" t:styleID=\"sCol8\" /><t:Column t:key=\"giftQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"9\" t:styleID=\"sCol9\" /><t:Column t:key=\"allReceiveQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"10\" t:styleID=\"sCol10\" /><t:Column t:key=\"returnChicken\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"11\" t:styleID=\"sCol11\" /><t:Column t:key=\"confirmQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"12\" t:styleID=\"sCol12\" /><t:Column t:key=\"basePrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"13\" t:styleID=\"sCol13\" /><t:Column t:key=\"receivePrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"14\" t:styleID=\"sCol14\" /><t:Column t:key=\"policySettleAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"15\" t:styleID=\"sCol15\" /><t:Column t:key=\"contractPrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"16\" t:styleID=\"sCol16\" /><t:Column t:key=\"contractAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"actualPrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"actualAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol19\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol20\" /><t:Column t:key=\"warehouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"unitCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol22\" /><t:Column t:key=\"actualCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol23\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"materialBatch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"allRQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol26\" /><t:Column t:key=\"gqty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol27\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{house}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{model}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{receiveQty}</t:Cell><t:Cell>$Resource{lossQty}</t:Cell><t:Cell>$Resource{supplementQty}</t:Cell><t:Cell>$Resource{giftQty}</t:Cell><t:Cell>$Resource{allReceiveQty}</t:Cell><t:Cell>$Resource{returnChicken}</t:Cell><t:Cell>$Resource{confirmQty}</t:Cell><t:Cell>$Resource{basePrice}</t:Cell><t:Cell>$Resource{receivePrice}</t:Cell><t:Cell>$Resource{policySettleAmt}</t:Cell><t:Cell>$Resource{contractPrice}</t:Cell><t:Cell>$Resource{contractAmt}</t:Cell><t:Cell>$Resource{actualPrice}</t:Cell><t:Cell>$Resource{actualAmt}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{warehouse}</t:Cell><t:Cell>$Resource{unitCost}</t:Cell><t:Cell>$Resource{actualCost}</t:Cell><t:Cell>$Resource{remark}</t:Cell><t:Cell>$Resource{materialBatch}</t:Cell><t:Cell>$Resource{allRQty}</t:Cell><t:Cell>$Resource{gqty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtEntrys.putBindContents("editData",new String[] {"id","house","material","materialName","model","unit","receiveQty","lossQty","supplementQty","giftQty","allReceiveQty","returnChicken","confirmQty","basePrice","receivePrice","policySettleAmt","contractPrice","contractAmt","actualPrice","actualAmt","amount","warehouse","unitCost","actualCost","remark","materialBatch","allRQty","gqty"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_house_PromptBox = new KDBizPromptBox();
        kdtEntrys_house_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
        kdtEntrys_house_PromptBox.setVisible(true);
        kdtEntrys_house_PromptBox.setEditable(true);
        kdtEntrys_house_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_house_PromptBox.setEditFormat("$number$");
        kdtEntrys_house_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_house_CellEditor = new KDTDefaultCellEditor(kdtEntrys_house_PromptBox);
        this.kdtEntrys.getColumn("house").setEditor(kdtEntrys_house_CellEditor);
        ObjectValueRender kdtEntrys_house_OVR = new ObjectValueRender();
        kdtEntrys_house_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("house").setRenderer(kdtEntrys_house_OVR);
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
        KDFormattedTextField kdtEntrys_lossQty_TextField = new KDFormattedTextField();
        kdtEntrys_lossQty_TextField.setName("kdtEntrys_lossQty_TextField");
        kdtEntrys_lossQty_TextField.setVisible(true);
        kdtEntrys_lossQty_TextField.setEditable(true);
        kdtEntrys_lossQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_lossQty_TextField.setDataType(1);
        	kdtEntrys_lossQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_lossQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_lossQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_lossQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_lossQty_TextField);
        this.kdtEntrys.getColumn("lossQty").setEditor(kdtEntrys_lossQty_CellEditor);
        KDFormattedTextField kdtEntrys_supplementQty_TextField = new KDFormattedTextField();
        kdtEntrys_supplementQty_TextField.setName("kdtEntrys_supplementQty_TextField");
        kdtEntrys_supplementQty_TextField.setVisible(true);
        kdtEntrys_supplementQty_TextField.setEditable(true);
        kdtEntrys_supplementQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_supplementQty_TextField.setDataType(1);
        	kdtEntrys_supplementQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_supplementQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_supplementQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_supplementQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_supplementQty_TextField);
        this.kdtEntrys.getColumn("supplementQty").setEditor(kdtEntrys_supplementQty_CellEditor);
        KDFormattedTextField kdtEntrys_giftQty_TextField = new KDFormattedTextField();
        kdtEntrys_giftQty_TextField.setName("kdtEntrys_giftQty_TextField");
        kdtEntrys_giftQty_TextField.setVisible(true);
        kdtEntrys_giftQty_TextField.setEditable(true);
        kdtEntrys_giftQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_giftQty_TextField.setDataType(1);
        	kdtEntrys_giftQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_giftQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_giftQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_giftQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_giftQty_TextField);
        this.kdtEntrys.getColumn("giftQty").setEditor(kdtEntrys_giftQty_CellEditor);
        KDFormattedTextField kdtEntrys_allReceiveQty_TextField = new KDFormattedTextField();
        kdtEntrys_allReceiveQty_TextField.setName("kdtEntrys_allReceiveQty_TextField");
        kdtEntrys_allReceiveQty_TextField.setVisible(true);
        kdtEntrys_allReceiveQty_TextField.setEditable(true);
        kdtEntrys_allReceiveQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_allReceiveQty_TextField.setDataType(1);
        	kdtEntrys_allReceiveQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_allReceiveQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_allReceiveQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_allReceiveQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_allReceiveQty_TextField);
        this.kdtEntrys.getColumn("allReceiveQty").setEditor(kdtEntrys_allReceiveQty_CellEditor);
        KDFormattedTextField kdtEntrys_returnChicken_TextField = new KDFormattedTextField();
        kdtEntrys_returnChicken_TextField.setName("kdtEntrys_returnChicken_TextField");
        kdtEntrys_returnChicken_TextField.setVisible(true);
        kdtEntrys_returnChicken_TextField.setEditable(true);
        kdtEntrys_returnChicken_TextField.setHorizontalAlignment(2);
        kdtEntrys_returnChicken_TextField.setDataType(1);
        	kdtEntrys_returnChicken_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_returnChicken_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_returnChicken_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_returnChicken_CellEditor = new KDTDefaultCellEditor(kdtEntrys_returnChicken_TextField);
        this.kdtEntrys.getColumn("returnChicken").setEditor(kdtEntrys_returnChicken_CellEditor);
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
        KDFormattedTextField kdtEntrys_policySettleAmt_TextField = new KDFormattedTextField();
        kdtEntrys_policySettleAmt_TextField.setName("kdtEntrys_policySettleAmt_TextField");
        kdtEntrys_policySettleAmt_TextField.setVisible(true);
        kdtEntrys_policySettleAmt_TextField.setEditable(true);
        kdtEntrys_policySettleAmt_TextField.setHorizontalAlignment(2);
        kdtEntrys_policySettleAmt_TextField.setDataType(1);
        	kdtEntrys_policySettleAmt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_policySettleAmt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_policySettleAmt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_policySettleAmt_CellEditor = new KDTDefaultCellEditor(kdtEntrys_policySettleAmt_TextField);
        this.kdtEntrys.getColumn("policySettleAmt").setEditor(kdtEntrys_policySettleAmt_CellEditor);
        KDFormattedTextField kdtEntrys_contractPrice_TextField = new KDFormattedTextField();
        kdtEntrys_contractPrice_TextField.setName("kdtEntrys_contractPrice_TextField");
        kdtEntrys_contractPrice_TextField.setVisible(true);
        kdtEntrys_contractPrice_TextField.setEditable(true);
        kdtEntrys_contractPrice_TextField.setHorizontalAlignment(2);
        kdtEntrys_contractPrice_TextField.setDataType(1);
        	kdtEntrys_contractPrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_contractPrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_contractPrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_contractPrice_CellEditor = new KDTDefaultCellEditor(kdtEntrys_contractPrice_TextField);
        this.kdtEntrys.getColumn("contractPrice").setEditor(kdtEntrys_contractPrice_CellEditor);
        KDFormattedTextField kdtEntrys_contractAmt_TextField = new KDFormattedTextField();
        kdtEntrys_contractAmt_TextField.setName("kdtEntrys_contractAmt_TextField");
        kdtEntrys_contractAmt_TextField.setVisible(true);
        kdtEntrys_contractAmt_TextField.setEditable(true);
        kdtEntrys_contractAmt_TextField.setHorizontalAlignment(2);
        kdtEntrys_contractAmt_TextField.setDataType(1);
        	kdtEntrys_contractAmt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_contractAmt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_contractAmt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_contractAmt_CellEditor = new KDTDefaultCellEditor(kdtEntrys_contractAmt_TextField);
        this.kdtEntrys.getColumn("contractAmt").setEditor(kdtEntrys_contractAmt_CellEditor);
        KDFormattedTextField kdtEntrys_actualPrice_TextField = new KDFormattedTextField();
        kdtEntrys_actualPrice_TextField.setName("kdtEntrys_actualPrice_TextField");
        kdtEntrys_actualPrice_TextField.setVisible(true);
        kdtEntrys_actualPrice_TextField.setEditable(true);
        kdtEntrys_actualPrice_TextField.setHorizontalAlignment(2);
        kdtEntrys_actualPrice_TextField.setDataType(1);
        	kdtEntrys_actualPrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_actualPrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_actualPrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_actualPrice_CellEditor = new KDTDefaultCellEditor(kdtEntrys_actualPrice_TextField);
        this.kdtEntrys.getColumn("actualPrice").setEditor(kdtEntrys_actualPrice_CellEditor);
        KDFormattedTextField kdtEntrys_actualAmt_TextField = new KDFormattedTextField();
        kdtEntrys_actualAmt_TextField.setName("kdtEntrys_actualAmt_TextField");
        kdtEntrys_actualAmt_TextField.setVisible(true);
        kdtEntrys_actualAmt_TextField.setEditable(true);
        kdtEntrys_actualAmt_TextField.setHorizontalAlignment(2);
        kdtEntrys_actualAmt_TextField.setDataType(1);
        	kdtEntrys_actualAmt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_actualAmt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_actualAmt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_actualAmt_CellEditor = new KDTDefaultCellEditor(kdtEntrys_actualAmt_TextField);
        this.kdtEntrys.getColumn("actualAmt").setEditor(kdtEntrys_actualAmt_CellEditor);
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
        KDTextField kdtEntrys_remark_TextField = new KDTextField();
        kdtEntrys_remark_TextField.setName("kdtEntrys_remark_TextField");
        kdtEntrys_remark_TextField.setMaxLength(250);
        KDTDefaultCellEditor kdtEntrys_remark_CellEditor = new KDTDefaultCellEditor(kdtEntrys_remark_TextField);
        this.kdtEntrys.getColumn("remark").setEditor(kdtEntrys_remark_CellEditor);
        KDTextField kdtEntrys_materialBatch_TextField = new KDTextField();
        kdtEntrys_materialBatch_TextField.setName("kdtEntrys_materialBatch_TextField");
        kdtEntrys_materialBatch_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_materialBatch_CellEditor = new KDTDefaultCellEditor(kdtEntrys_materialBatch_TextField);
        this.kdtEntrys.getColumn("materialBatch").setEditor(kdtEntrys_materialBatch_CellEditor);
        KDFormattedTextField kdtEntrys_allRQty_TextField = new KDFormattedTextField();
        kdtEntrys_allRQty_TextField.setName("kdtEntrys_allRQty_TextField");
        kdtEntrys_allRQty_TextField.setVisible(true);
        kdtEntrys_allRQty_TextField.setEditable(true);
        kdtEntrys_allRQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_allRQty_TextField.setDataType(1);
        	kdtEntrys_allRQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_allRQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_allRQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_allRQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_allRQty_TextField);
        this.kdtEntrys.getColumn("allRQty").setEditor(kdtEntrys_allRQty_CellEditor);
        KDFormattedTextField kdtEntrys_gqty_TextField = new KDFormattedTextField();
        kdtEntrys_gqty_TextField.setName("kdtEntrys_gqty_TextField");
        kdtEntrys_gqty_TextField.setVisible(true);
        kdtEntrys_gqty_TextField.setEditable(true);
        kdtEntrys_gqty_TextField.setHorizontalAlignment(2);
        kdtEntrys_gqty_TextField.setDataType(1);
        	kdtEntrys_gqty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_gqty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_gqty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_gqty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_gqty_TextField);
        this.kdtEntrys.getColumn("gqty").setEditor(kdtEntrys_gqty_CellEditor);
        // contstorageOrgUnit		
        this.contstorageOrgUnit.setBoundLabelText(resHelper.getString("contstorageOrgUnit.boundLabelText"));		
        this.contstorageOrgUnit.setBoundLabelLength(100);		
        this.contstorageOrgUnit.setBoundLabelUnderline(true);		
        this.contstorageOrgUnit.setVisible(true);
        // contbreedData		
        this.contbreedData.setBoundLabelText(resHelper.getString("contbreedData.boundLabelText"));		
        this.contbreedData.setBoundLabelLength(100);		
        this.contbreedData.setBoundLabelUnderline(true);		
        this.contbreedData.setVisible(true);
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
        // contbatch		
        this.contbatch.setBoundLabelText(resHelper.getString("contbatch.boundLabelText"));		
        this.contbatch.setBoundLabelLength(100);		
        this.contbatch.setBoundLabelUnderline(true);		
        this.contbatch.setVisible(true);
        // contbatchContract		
        this.contbatchContract.setBoundLabelText(resHelper.getString("contbatchContract.boundLabelText"));		
        this.contbatchContract.setBoundLabelLength(100);		
        this.contbatchContract.setBoundLabelUnderline(true);		
        this.contbatchContract.setVisible(true);
        // contdriver		
        this.contdriver.setBoundLabelText(resHelper.getString("contdriver.boundLabelText"));		
        this.contdriver.setBoundLabelLength(100);		
        this.contdriver.setBoundLabelUnderline(true);		
        this.contdriver.setVisible(false);
        // contperson		
        this.contperson.setBoundLabelText(resHelper.getString("contperson.boundLabelText"));		
        this.contperson.setBoundLabelLength(100);		
        this.contperson.setBoundLabelUnderline(true);		
        this.contperson.setVisible(true);
        // contbizType		
        this.contbizType.setBoundLabelText(resHelper.getString("contbizType.boundLabelText"));		
        this.contbizType.setBoundLabelLength(100);		
        this.contbizType.setBoundLabelUnderline(true);		
        this.contbizType.setVisible(true);
        // contvoucherNum		
        this.contvoucherNum.setBoundLabelText(resHelper.getString("contvoucherNum.boundLabelText"));		
        this.contvoucherNum.setBoundLabelLength(100);		
        this.contvoucherNum.setBoundLabelUnderline(true);		
        this.contvoucherNum.setVisible(false);
        // chkisHasMaterialReq		
        this.chkisHasMaterialReq.setText(resHelper.getString("chkisHasMaterialReq.text"));		
        this.chkisHasMaterialReq.setHorizontalAlignment(2);		
        this.chkisHasMaterialReq.setEnabled(false);
        // chkisHasSaleIssue		
        this.chkisHasSaleIssue.setText(resHelper.getString("chkisHasSaleIssue.text"));		
        this.chkisHasSaleIssue.setVisible(false);		
        this.chkisHasSaleIssue.setHorizontalAlignment(2);		
        this.chkisHasSaleIssue.setEnabled(false);
        // contseedSourceType		
        this.contseedSourceType.setBoundLabelText(resHelper.getString("contseedSourceType.boundLabelText"));		
        this.contseedSourceType.setBoundLabelLength(100);		
        this.contseedSourceType.setBoundLabelUnderline(true);		
        this.contseedSourceType.setVisible(true);
        // contsourceHatchArea		
        this.contsourceHatchArea.setBoundLabelText(resHelper.getString("contsourceHatchArea.boundLabelText"));		
        this.contsourceHatchArea.setBoundLabelLength(100);		
        this.contsourceHatchArea.setBoundLabelUnderline(true);		
        this.contsourceHatchArea.setVisible(true);
        // contactualBizdate		
        this.contactualBizdate.setBoundLabelText(resHelper.getString("contactualBizdate.boundLabelText"));		
        this.contactualBizdate.setBoundLabelLength(100);		
        this.contactualBizdate.setBoundLabelUnderline(true);		
        this.contactualBizdate.setVisible(true);
        // contsettlePolicy		
        this.contsettlePolicy.setBoundLabelText(resHelper.getString("contsettlePolicy.boundLabelText"));		
        this.contsettlePolicy.setBoundLabelLength(100);		
        this.contsettlePolicy.setBoundLabelUnderline(true);		
        this.contsettlePolicy.setVisible(true);
        // contpurSupplier		
        this.contpurSupplier.setBoundLabelText(resHelper.getString("contpurSupplier.boundLabelText"));		
        this.contpurSupplier.setBoundLabelLength(100);		
        this.contpurSupplier.setBoundLabelUnderline(true);		
        this.contpurSupplier.setVisible(true);
        // chkisOtherIssue		
        this.chkisOtherIssue.setText(resHelper.getString("chkisOtherIssue.text"));		
        this.chkisOtherIssue.setVisible(false);		
        this.chkisOtherIssue.setHorizontalAlignment(2);		
        this.chkisOtherIssue.setEnabled(false);
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
        // contseedSource		
        this.contseedSource.setBoundLabelText(resHelper.getString("contseedSource.boundLabelText"));		
        this.contseedSource.setBoundLabelLength(100);		
        this.contseedSource.setBoundLabelUnderline(true);		
        this.contseedSource.setVisible(false);
        // contcostObject		
        this.contcostObject.setBoundLabelText(resHelper.getString("contcostObject.boundLabelText"));		
        this.contcostObject.setBoundLabelLength(100);		
        this.contcostObject.setBoundLabelUnderline(true);		
        this.contcostObject.setVisible(true);
        // chkisInsertImm		
        this.chkisInsertImm.setText(resHelper.getString("chkisInsertImm.text"));		
        this.chkisInsertImm.setHorizontalAlignment(2);
        // chkisManuIn		
        this.chkisManuIn.setText(resHelper.getString("chkisManuIn.text"));		
        this.chkisManuIn.setHorizontalAlignment(2);		
        this.chkisManuIn.setEnabled(false);
        // chkisOtherIn		
        this.chkisOtherIn.setText(resHelper.getString("chkisOtherIn.text"));		
        this.chkisOtherIn.setHorizontalAlignment(2);		
        this.chkisOtherIn.setEnabled(false);
        // contchickenPerson		
        this.contchickenPerson.setBoundLabelText(resHelper.getString("contchickenPerson.boundLabelText"));		
        this.contchickenPerson.setBoundLabelLength(100);		
        this.contchickenPerson.setBoundLabelUnderline(true);		
        this.contchickenPerson.setVisible(true);
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
        // prmtbreedData		
        this.prmtbreedData.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.BreedDataQuery");		
        this.prmtbreedData.setEditable(true);		
        this.prmtbreedData.setDisplayFormat("$name$");		
        this.prmtbreedData.setEditFormat("$number$");		
        this.prmtbreedData.setCommitFormat("$number$");		
        this.prmtbreedData.setRequired(true);
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
					
        // prmtfarmer		
        this.prmtfarmer.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerQuery");		
        this.prmtfarmer.setEditable(true);		
        this.prmtfarmer.setDisplayFormat("$name$");		
        this.prmtfarmer.setEditFormat("$name$");		
        this.prmtfarmer.setCommitFormat("$name$");		
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
        this.prmtfarm.setEditFormat("$name$");		
        this.prmtfarm.setCommitFormat("$name$");		
        this.prmtfarm.setRequired(false);
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

        // prmtbatch		
        this.prmtbatch.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.BatchQuery");		
        this.prmtbatch.setEditable(true);		
        this.prmtbatch.setDisplayFormat("$number$");		
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
					
        // prmtbatchContract		
        this.prmtbatchContract.setQueryInfo("com.kingdee.eas.farm.carnivorous.feedbiz.app.BatchContractBillQuery");		
        this.prmtbatchContract.setEditable(true);		
        this.prmtbatchContract.setDisplayFormat("$number$");		
        this.prmtbatchContract.setEditFormat("$number$");		
        this.prmtbatchContract.setCommitFormat("$number$");		
        this.prmtbatchContract.setRequired(false);
        // prmtdriver		
        this.prmtdriver.setQueryInfo("com.kingdee.eas.farm.feemanager.basedata.app.DriverQuery");		
        this.prmtdriver.setVisible(false);		
        this.prmtdriver.setEditable(true);		
        this.prmtdriver.setDisplayFormat("$drivername$");		
        this.prmtdriver.setEditFormat("$number$");		
        this.prmtdriver.setCommitFormat("$number$");		
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
					
        // prmtperson		
        this.prmtperson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtperson.setEditable(true);		
        this.prmtperson.setDisplayFormat("$name$");		
        this.prmtperson.setEditFormat("$number$");		
        this.prmtperson.setCommitFormat("$number$");		
        this.prmtperson.setRequired(false);		
        this.prmtperson.setEnabled(false);
        // bizType		
        this.bizType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.feedbiz.BizTypeEnum").toArray());		
        this.bizType.setRequired(false);
        // txtvoucherNum		
        this.txtvoucherNum.setVisible(false);		
        this.txtvoucherNum.setHorizontalAlignment(2);		
        this.txtvoucherNum.setMaxLength(100);		
        this.txtvoucherNum.setRequired(false);		
        this.txtvoucherNum.setEnabled(false);
        // seedSourceType		
        this.seedSourceType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.feedbiz.SeedSourceType").toArray());		
        this.seedSourceType.setRequired(true);
        // prmtsourceHatchArea		
        this.prmtsourceHatchArea.setQueryInfo("com.kingdee.eas.farm.hatch.app.HatchBaseDataQuery");		
        this.prmtsourceHatchArea.setEditable(true);		
        this.prmtsourceHatchArea.setDisplayFormat("$name$");		
        this.prmtsourceHatchArea.setEditFormat("$number$");		
        this.prmtsourceHatchArea.setCommitFormat("$number$");		
        this.prmtsourceHatchArea.setRequired(true);
        		prmtsourceHatchArea.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.HatchBaseDataListUI prmtsourceHatchArea_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtsourceHatchArea_F7ListUI == null) {
					try {
						prmtsourceHatchArea_F7ListUI = new com.kingdee.eas.farm.hatch.client.HatchBaseDataListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtsourceHatchArea_F7ListUI));
					prmtsourceHatchArea_F7ListUI.setF7Use(true,ctx);
					prmtsourceHatchArea.setSelector(prmtsourceHatchArea_F7ListUI);
				}
			}
		});
					
        // pkactualBizdate		
        this.pkactualBizdate.setRequired(false);		
        this.pkactualBizdate.setEnabled(false);
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
					
        // prmtpurSupplier		
        this.prmtpurSupplier.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.PSupplierQuery");		
        this.prmtpurSupplier.setEditable(true);		
        this.prmtpurSupplier.setDisplayFormat("$name$");		
        this.prmtpurSupplier.setEditFormat("$number$");		
        this.prmtpurSupplier.setCommitFormat("$number$");		
        this.prmtpurSupplier.setRequired(false);		
        this.prmtpurSupplier.setEnabled(false);
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
        // txtseedSource		
        this.txtseedSource.setHorizontalAlignment(2);		
        this.txtseedSource.setMaxLength(255);		
        this.txtseedSource.setRequired(false);		
        this.txtseedSource.setEnabled(false);		
        this.txtseedSource.setVisible(false);
        // prmtcostObject		
        this.prmtcostObject.setQueryInfo("com.kingdee.eas.basedata.org.app.CostCenterItemQuery");		
        this.prmtcostObject.setEditable(true);		
        this.prmtcostObject.setDisplayFormat("$name$");		
        this.prmtcostObject.setEditFormat("$number$");		
        this.prmtcostObject.setCommitFormat("$number$");		
        this.prmtcostObject.setRequired(true);
        // prmtchickenPerson		
        this.prmtchickenPerson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtchickenPerson.setEditable(true);		
        this.prmtchickenPerson.setDisplayFormat("$name$");		
        this.prmtchickenPerson.setEditFormat("$number$");		
        this.prmtchickenPerson.setCommitFormat("$number$");		
        this.prmtchickenPerson.setRequired(false);
        // tBtnAudit
        this.tBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnAudit.setText(resHelper.getString("tBtnAudit.text"));
        // tBtnUnAudit
        this.tBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnUnAudit.setText(resHelper.getString("tBtnUnAudit.text"));
        // btnClose
        this.btnClose.setAction((IItemAction)ActionProxyFactory.getProxy(actionClose, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnClose.setText(resHelper.getString("btnClose.text"));		
        this.btnClose.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgState_iconclose_1"));
        // btnUnClose
        this.btnUnClose.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnClose, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnClose.setText(resHelper.getString("btnUnClose.text"));		
        this.btnUnClose.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTable_success"));
        // btnAddDriver		
        this.btnAddDriver.setText(resHelper.getString("btnAddDriver.text"));
        // mBtnAudit
        this.mBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnAudit.setText(resHelper.getString("mBtnAudit.text"));
        // mBtnUnAudit
        this.mBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnUnAudit.setText(resHelper.getString("mBtnUnAudit.text"));
        // newSeparator3
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {chkisHasSaleIssue,pkactualBizdate,txtNumber,pkBizDate,billStatus,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,prmtcompany,pkauditTime,prmtstorageOrgUnit,prmtbreedData,prmtfarmer,prmtfarm,prmtbatch,prmtbatchContract,prmtdriver,prmtperson,bizType,txtvoucherNum,chkisHasMaterialReq,seedSourceType,prmtsourceHatchArea,prmtsettlePolicy,prmtpurSupplier,chkisOtherIssue,txtfarmerPhone,txtfarmAddress,txtseedSource,prmtcostObject,chkisInsertImm,chkisManuIn,chkisOtherIn,prmtchickenPerson,kdtEntrys}));
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
        this.setBounds(new Rectangle(0, 0, 1272, 675));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1272, 675));
        contCreator.setBounds(new Rectangle(488, 605, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(488, 605, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(904, 609, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(904, 609, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(488, 638, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(488, 638, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(904, 642, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(904, 642, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(25, 10, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(25, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(341, 10, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(341, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(977, 146, 271, 19));
        this.add(contDescription, new KDLayout.Constraints(977, 146, 271, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(28, 608, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(28, 608, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(977, 10, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(977, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompany.setBounds(new Rectangle(659, 10, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(659, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(28, 641, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(28, 641, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator8.setBounds(new Rectangle(68, 591, 1226, 16));
        this.add(kDSeparator8, new KDLayout.Constraints(68, 591, 1226, 16, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator9.setBounds(new Rectangle(18, 247, 1242, 8));
        this.add(kDSeparator9, new KDLayout.Constraints(18, 247, 1242, 8, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kdtEntrys.setBounds(new Rectangle(23, 258, 1212, 332));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(23, 258, 1212, 332, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contstorageOrgUnit.setBounds(new Rectangle(341, 44, 270, 19));
        this.add(contstorageOrgUnit, new KDLayout.Constraints(341, 44, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbreedData.setBounds(new Rectangle(341, 112, 270, 19));
        this.add(contbreedData, new KDLayout.Constraints(341, 112, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmer.setBounds(new Rectangle(659, 44, 270, 19));
        this.add(contfarmer, new KDLayout.Constraints(659, 44, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarm.setBounds(new Rectangle(977, 44, 270, 19));
        this.add(contfarm, new KDLayout.Constraints(977, 44, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbatch.setBounds(new Rectangle(977, 78, 270, 19));
        this.add(contbatch, new KDLayout.Constraints(977, 78, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbatchContract.setBounds(new Rectangle(659, 78, 270, 19));
        this.add(contbatchContract, new KDLayout.Constraints(659, 78, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdriver.setBounds(new Rectangle(1248, 163, 270, 19));
        this.add(contdriver, new KDLayout.Constraints(1248, 163, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contperson.setBounds(new Rectangle(659, 112, 270, 19));
        this.add(contperson, new KDLayout.Constraints(659, 112, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbizType.setBounds(new Rectangle(25, 44, 270, 19));
        this.add(contbizType, new KDLayout.Constraints(25, 44, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contvoucherNum.setBounds(new Rectangle(1246, 183, 277, 19));
        this.add(contvoucherNum, new KDLayout.Constraints(1246, 183, 277, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkisHasMaterialReq.setBounds(new Rectangle(26, 214, 157, 19));
        this.add(chkisHasMaterialReq, new KDLayout.Constraints(26, 214, 157, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisHasSaleIssue.setBounds(new Rectangle(789, 216, 173, 19));
        this.add(chkisHasSaleIssue, new KDLayout.Constraints(789, 216, 173, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contseedSourceType.setBounds(new Rectangle(25, 146, 270, 19));
        this.add(contseedSourceType, new KDLayout.Constraints(25, 146, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsourceHatchArea.setBounds(new Rectangle(341, 146, 270, 19));
        this.add(contsourceHatchArea, new KDLayout.Constraints(341, 146, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contactualBizdate.setBounds(new Rectangle(977, 112, 270, 19));
        this.add(contactualBizdate, new KDLayout.Constraints(977, 112, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contsettlePolicy.setBounds(new Rectangle(25, 112, 270, 19));
        this.add(contsettlePolicy, new KDLayout.Constraints(25, 112, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpurSupplier.setBounds(new Rectangle(659, 146, 270, 19));
        this.add(contpurSupplier, new KDLayout.Constraints(659, 146, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisOtherIssue.setBounds(new Rectangle(666, 222, 165, 19));
        this.add(chkisOtherIssue, new KDLayout.Constraints(666, 222, 165, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmerPhone.setBounds(new Rectangle(25, 78, 270, 19));
        this.add(contfarmerPhone, new KDLayout.Constraints(25, 78, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmAddress.setBounds(new Rectangle(341, 78, 270, 19));
        this.add(contfarmAddress, new KDLayout.Constraints(341, 78, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contseedSource.setBounds(new Rectangle(353, 176, 272, 19));
        this.add(contseedSource, new KDLayout.Constraints(353, 176, 272, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcostObject.setBounds(new Rectangle(980, 180, 270, 19));
        this.add(contcostObject, new KDLayout.Constraints(980, 180, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkisInsertImm.setBounds(new Rectangle(146, 214, 104, 19));
        this.add(chkisInsertImm, new KDLayout.Constraints(146, 214, 104, 19, 0));
        chkisManuIn.setBounds(new Rectangle(502, 214, 132, 19));
        this.add(chkisManuIn, new KDLayout.Constraints(502, 214, 132, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisOtherIn.setBounds(new Rectangle(341, 214, 105, 19));
        this.add(chkisOtherIn, new KDLayout.Constraints(341, 214, 105, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contchickenPerson.setBounds(new Rectangle(25, 177, 270, 19));
        this.add(contchickenPerson, new KDLayout.Constraints(25, 177, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contbreedData
        contbreedData.setBoundEditor(prmtbreedData);
        //contfarmer
        contfarmer.setBoundEditor(prmtfarmer);
        //contfarm
        contfarm.setBoundEditor(prmtfarm);
        //contbatch
        contbatch.setBoundEditor(prmtbatch);
        //contbatchContract
        contbatchContract.setBoundEditor(prmtbatchContract);
        //contdriver
        contdriver.setBoundEditor(prmtdriver);
        //contperson
        contperson.setBoundEditor(prmtperson);
        //contbizType
        contbizType.setBoundEditor(bizType);
        //contvoucherNum
        contvoucherNum.setBoundEditor(txtvoucherNum);
        //contseedSourceType
        contseedSourceType.setBoundEditor(seedSourceType);
        //contsourceHatchArea
        contsourceHatchArea.setBoundEditor(prmtsourceHatchArea);
        //contactualBizdate
        contactualBizdate.setBoundEditor(pkactualBizdate);
        //contsettlePolicy
        contsettlePolicy.setBoundEditor(prmtsettlePolicy);
        //contpurSupplier
        contpurSupplier.setBoundEditor(prmtpurSupplier);
        //contfarmerPhone
        contfarmerPhone.setBoundEditor(txtfarmerPhone);
        //contfarmAddress
        contfarmAddress.setBoundEditor(txtfarmAddress);
        //contseedSource
        contseedSource.setBoundEditor(txtseedSource);
        //contcostObject
        contcostObject.setBoundEditor(prmtcostObject);
        //contchickenPerson
        contchickenPerson.setBoundEditor(prmtchickenPerson);

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
        this.toolBar.add(btnAddDriver);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.receiveQty", java.math.BigDecimal.class, this.kdtEntrys, "receiveQty.text");
		dataBinder.registerBinding("entrys.receivePrice", java.math.BigDecimal.class, this.kdtEntrys, "receivePrice.text");
		dataBinder.registerBinding("entrys.warehouse", java.lang.Object.class, this.kdtEntrys, "warehouse.text");
		dataBinder.registerBinding("entrys.confirmQty", java.math.BigDecimal.class, this.kdtEntrys, "confirmQty.text");
		dataBinder.registerBinding("entrys.basePrice", java.math.BigDecimal.class, this.kdtEntrys, "basePrice.text");
		dataBinder.registerBinding("entrys.material", java.lang.Object.class, this.kdtEntrys, "material.text");
		dataBinder.registerBinding("entrys.materialName", String.class, this.kdtEntrys, "materialName.text");
		dataBinder.registerBinding("entrys.model", String.class, this.kdtEntrys, "model.text");
		dataBinder.registerBinding("entrys.unit", java.lang.Object.class, this.kdtEntrys, "unit.text");
		dataBinder.registerBinding("entrys.amount", java.math.BigDecimal.class, this.kdtEntrys, "amount.text");
		dataBinder.registerBinding("entrys.supplementQty", java.math.BigDecimal.class, this.kdtEntrys, "supplementQty.text");
		dataBinder.registerBinding("entrys.lossQty", java.math.BigDecimal.class, this.kdtEntrys, "lossQty.text");
		dataBinder.registerBinding("entrys.allReceiveQty", java.math.BigDecimal.class, this.kdtEntrys, "allReceiveQty.text");
		dataBinder.registerBinding("entrys.unitCost", java.math.BigDecimal.class, this.kdtEntrys, "unitCost.text");
		dataBinder.registerBinding("entrys.actualCost", java.math.BigDecimal.class, this.kdtEntrys, "actualCost.text");
		dataBinder.registerBinding("entrys.giftQty", java.math.BigDecimal.class, this.kdtEntrys, "giftQty.text");
		dataBinder.registerBinding("entrys.remark", String.class, this.kdtEntrys, "remark.text");
		dataBinder.registerBinding("entrys.materialBatch", String.class, this.kdtEntrys, "materialBatch.text");
		dataBinder.registerBinding("entrys.allRQty", java.math.BigDecimal.class, this.kdtEntrys, "allRQty.text");
		dataBinder.registerBinding("entrys.gqty", java.math.BigDecimal.class, this.kdtEntrys, "gqty.text");
		dataBinder.registerBinding("entrys.house", java.lang.Object.class, this.kdtEntrys, "house.text");
		dataBinder.registerBinding("entrys.returnChicken", java.math.BigDecimal.class, this.kdtEntrys, "returnChicken.text");
		dataBinder.registerBinding("entrys.contractPrice", java.math.BigDecimal.class, this.kdtEntrys, "contractPrice.text");
		dataBinder.registerBinding("entrys.actualPrice", java.math.BigDecimal.class, this.kdtEntrys, "actualPrice.text");
		dataBinder.registerBinding("entrys.policySettleAmt", java.math.BigDecimal.class, this.kdtEntrys, "policySettleAmt.text");
		dataBinder.registerBinding("entrys.contractAmt", java.math.BigDecimal.class, this.kdtEntrys, "contractAmt.text");
		dataBinder.registerBinding("entrys.actualAmt", java.math.BigDecimal.class, this.kdtEntrys, "actualAmt.text");
		dataBinder.registerBinding("isHasMaterialReq", boolean.class, this.chkisHasMaterialReq, "selected");
		dataBinder.registerBinding("isHasSaleIssue", boolean.class, this.chkisHasSaleIssue, "selected");
		dataBinder.registerBinding("isOtherIssue", boolean.class, this.chkisOtherIssue, "selected");
		dataBinder.registerBinding("isInsertImm", boolean.class, this.chkisInsertImm, "selected");
		dataBinder.registerBinding("isManuIn", boolean.class, this.chkisManuIn, "selected");
		dataBinder.registerBinding("isOtherIn", boolean.class, this.chkisOtherIn, "selected");
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
		dataBinder.registerBinding("breedData", com.kingdee.eas.farm.stocking.basedata.BreedDataInfo.class, this.prmtbreedData, "data");
		dataBinder.registerBinding("farmer", com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo.class, this.prmtfarmer, "data");
		dataBinder.registerBinding("farm", com.kingdee.eas.farm.carnivorous.basedata.FarmInfo.class, this.prmtfarm, "data");
		dataBinder.registerBinding("batch", com.kingdee.eas.farm.carnivorous.basedata.BatchInfo.class, this.prmtbatch, "data");
		dataBinder.registerBinding("batchContract", com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo.class, this.prmtbatchContract, "data");
		dataBinder.registerBinding("driver", com.kingdee.eas.farm.feemanager.basedata.DriverInfo.class, this.prmtdriver, "data");
		dataBinder.registerBinding("person", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtperson, "data");
		dataBinder.registerBinding("bizType", com.kingdee.eas.farm.carnivorous.feedbiz.BizTypeEnum.class, this.bizType, "selectedItem");
		dataBinder.registerBinding("voucherNum", String.class, this.txtvoucherNum, "text");
		dataBinder.registerBinding("seedSourceType", com.kingdee.eas.farm.carnivorous.feedbiz.SeedSourceType.class, this.seedSourceType, "selectedItem");
		dataBinder.registerBinding("sourceHatchArea", com.kingdee.eas.farm.hatch.HatchBaseDataInfo.class, this.prmtsourceHatchArea, "data");
		dataBinder.registerBinding("actualBizdate", java.util.Date.class, this.pkactualBizdate, "value");
		dataBinder.registerBinding("settlePolicy", com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo.class, this.prmtsettlePolicy, "data");
		dataBinder.registerBinding("purSupplier", com.kingdee.eas.basedata.master.cssp.SupplierInfo.class, this.prmtpurSupplier, "data");
		dataBinder.registerBinding("farmerPhone", String.class, this.txtfarmerPhone, "text");
		dataBinder.registerBinding("farmAddress", String.class, this.txtfarmAddress, "text");
		dataBinder.registerBinding("seedSource", String.class, this.txtseedSource, "text");
		dataBinder.registerBinding("costObject", com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo.class, this.prmtcostObject, "data");
		dataBinder.registerBinding("chickenPerson", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtchickenPerson, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.carnivorous.feedbiz.app.BreedSeedReceiveBillEditUIHandler";
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
        this.chkisHasSaleIssue.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.receiveQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.receivePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.warehouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.confirmQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.basePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.materialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.model", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.supplementQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.lossQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.allReceiveQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.unitCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.actualCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.giftQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.materialBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.allRQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.gqty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.house", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.returnChicken", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.contractPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.actualPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.policySettleAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.contractAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.actualAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isHasMaterialReq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isHasSaleIssue", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isOtherIssue", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isInsertImm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isManuIn", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isOtherIn", ValidateHelper.ON_SAVE);    
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
		getValidateHelper().registerBindProperty("breedData", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batchContract", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("driver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("person", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("voucherNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("seedSourceType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sourceHatchArea", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("actualBizdate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("settlePolicy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("purSupplier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmerPhone", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmAddress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("seedSource", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("costObject", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenPerson", ValidateHelper.ON_SAVE);    		
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
     * output getSelectors method
     */
    public SelectorItemCollection getSelectors()
    {
        SelectorItemCollection sic = new SelectorItemCollection();
		String selectorAll = System.getProperty("selector.all");
		if(StringUtils.isEmpty(selectorAll)){
			selectorAll = "true";
		}
    	sic.add(new SelectorItemInfo("entrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("entrys.receiveQty"));
    	sic.add(new SelectorItemInfo("entrys.receivePrice"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.warehouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.warehouse.id"));
			sic.add(new SelectorItemInfo("entrys.warehouse.name"));
        	sic.add(new SelectorItemInfo("entrys.warehouse.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.confirmQty"));
    	sic.add(new SelectorItemInfo("entrys.basePrice"));
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
			sic.add(new SelectorItemInfo("entrys.unit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.unit.id"));
			sic.add(new SelectorItemInfo("entrys.unit.name"));
        	sic.add(new SelectorItemInfo("entrys.unit.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.amount"));
    	sic.add(new SelectorItemInfo("entrys.supplementQty"));
    	sic.add(new SelectorItemInfo("entrys.lossQty"));
    	sic.add(new SelectorItemInfo("entrys.allReceiveQty"));
    	sic.add(new SelectorItemInfo("entrys.unitCost"));
    	sic.add(new SelectorItemInfo("entrys.actualCost"));
    	sic.add(new SelectorItemInfo("entrys.giftQty"));
    	sic.add(new SelectorItemInfo("entrys.remark"));
    	sic.add(new SelectorItemInfo("entrys.materialBatch"));
    	sic.add(new SelectorItemInfo("entrys.allRQty"));
    	sic.add(new SelectorItemInfo("entrys.gqty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.house.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.house.id"));
			sic.add(new SelectorItemInfo("entrys.house.name"));
        	sic.add(new SelectorItemInfo("entrys.house.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.returnChicken"));
    	sic.add(new SelectorItemInfo("entrys.contractPrice"));
    	sic.add(new SelectorItemInfo("entrys.actualPrice"));
    	sic.add(new SelectorItemInfo("entrys.policySettleAmt"));
    	sic.add(new SelectorItemInfo("entrys.contractAmt"));
    	sic.add(new SelectorItemInfo("entrys.actualAmt"));
        sic.add(new SelectorItemInfo("isHasMaterialReq"));
        sic.add(new SelectorItemInfo("isHasSaleIssue"));
        sic.add(new SelectorItemInfo("isOtherIssue"));
        sic.add(new SelectorItemInfo("isInsertImm"));
        sic.add(new SelectorItemInfo("isManuIn"));
        sic.add(new SelectorItemInfo("isOtherIn"));
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
			sic.add(new SelectorItemInfo("breedData.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("breedData.id"));
        	sic.add(new SelectorItemInfo("breedData.number"));
        	sic.add(new SelectorItemInfo("breedData.name"));
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
			sic.add(new SelectorItemInfo("batchContract.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("batchContract.id"));
        	sic.add(new SelectorItemInfo("batchContract.number"));
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("person.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("person.id"));
        	sic.add(new SelectorItemInfo("person.number"));
        	sic.add(new SelectorItemInfo("person.name"));
		}
        sic.add(new SelectorItemInfo("bizType"));
        sic.add(new SelectorItemInfo("voucherNum"));
        sic.add(new SelectorItemInfo("seedSourceType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("sourceHatchArea.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("sourceHatchArea.id"));
        	sic.add(new SelectorItemInfo("sourceHatchArea.number"));
        	sic.add(new SelectorItemInfo("sourceHatchArea.name"));
		}
        sic.add(new SelectorItemInfo("actualBizdate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("settlePolicy.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("settlePolicy.id"));
        	sic.add(new SelectorItemInfo("settlePolicy.number"));
        	sic.add(new SelectorItemInfo("settlePolicy.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("purSupplier.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("purSupplier.id"));
        	sic.add(new SelectorItemInfo("purSupplier.number"));
        	sic.add(new SelectorItemInfo("purSupplier.name"));
		}
        sic.add(new SelectorItemInfo("farmerPhone"));
        sic.add(new SelectorItemInfo("farmAddress"));
        sic.add(new SelectorItemInfo("seedSource"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("costObject.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("costObject.id"));
        	sic.add(new SelectorItemInfo("costObject.number"));
        	sic.add(new SelectorItemInfo("costObject.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("chickenPerson.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("chickenPerson.id"));
        	sic.add(new SelectorItemInfo("chickenPerson.number"));
        	sic.add(new SelectorItemInfo("chickenPerson.name"));
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
        com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionChkVoucherFlag_actionPerformed method
     */
    public void actionChkVoucherFlag_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillFactory.getRemoteInstance().chkVoucherFlag(editData);
    }
    	

    /**
     * output actionChkVoucherAll_actionPerformed method
     */
    public void actionChkVoucherAll_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillFactory.getRemoteInstance().chkVoucherAll(editData);
    }
    	

    /**
     * output actionClose_actionPerformed method
     */
    public void actionClose_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillFactory.getRemoteInstance().close(editData);
    }
    	

    /**
     * output actionUnClose_actionPerformed method
     */
    public void actionUnClose_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillFactory.getRemoteInstance().unClose(editData);
    }
    	

    /**
     * output actionUpdatePrice_actionPerformed method
     */
    public void actionUpdatePrice_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillFactory.getRemoteInstance().updatePrice(editData);
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
            innerActionPerformed("eas", AbstractBreedSeedReceiveBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractBreedSeedReceiveBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractBreedSeedReceiveBillEditUI.this, "ActionChkVoucherFlag", "actionChkVoucherFlag_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractBreedSeedReceiveBillEditUI.this, "ActionChkVoucherAll", "actionChkVoucherAll_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractBreedSeedReceiveBillEditUI.this, "ActionClose", "actionClose_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractBreedSeedReceiveBillEditUI.this, "ActionUnClose", "actionUnClose_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractBreedSeedReceiveBillEditUI.this, "ActionUpdatePrice", "actionUpdatePrice_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.feedbiz.client", "BreedSeedReceiveBillEditUI");
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
        return com.kingdee.eas.farm.carnivorous.feedbiz.client.BreedSeedReceiveBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/carnivorous/feedbiz/BreedSeedReceiveBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.carnivorous.feedbiz.app.BreedSeedReceiveBillQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"material").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"种苗编码"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"unit").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"单位"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"warehouse").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"领用仓库"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtNumber.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"单据编号"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtstorageOrgUnit.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"库存组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtbreedData.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"品种"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtfarmer.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖户"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(seedSourceType.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"雏苗来源类型"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtsourceHatchArea.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"来源孵化场"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcostObject.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"成本中心"});
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
vo.put("bizType","0");
vo.put("seedSourceType","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}        
				protected void setTableToSumField() {
			setTableToSumField(kdtEntrys,new String[] {"receiveQty","lossQty","supplementQty","giftQty","allReceiveQty","returnChicken","confirmQty","contractAmt","actualAmt","amount","actualCost"});
		}


}