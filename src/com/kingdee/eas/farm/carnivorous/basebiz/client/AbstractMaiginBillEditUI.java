/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basebiz.client;

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
public abstract class AbstractMaiginBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractMaiginBillEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpayAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditOpinion;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbizType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalMargin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contenableMargin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoccupyMargin;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkFivouchered;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contvoucherNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contidentity;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbankNo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contphone;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmoneySource;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisHasReceivingBill;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisHasPaymentBill;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbEBank;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbEBankAddress;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkliquidated;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contguaranty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contkConFeedSubsidy;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contkPolicySubsidy;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contkPunishAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contkOtherAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contactualPayAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contactualKPunishAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contactualKConFeedSub;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contactualKPolicySub;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contactualKOtherAmt;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator9;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarm;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpayAmount;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane scrollPaneauditOpinion;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtauditOpinion;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.swing.KDComboBox bizType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalMargin;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtenableMargin;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoccupyMargin;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtvoucherNum;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtidentity;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbankNo;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtphone;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperson;
    protected com.kingdee.bos.ctrl.swing.KDComboBox moneySource;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbEBank;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbEBankAddress;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtguaranty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtkConFeedSubsidy;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtkPolicySubsidy;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtkPunishAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtkOtherAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtactualPayAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtactualKPunishAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtactualKConFeedSub;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtactualKPolicySub;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtactualKOtherAmt;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarm;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnViewGuaranteeBill;
    protected com.kingdee.eas.farm.carnivorous.basebiz.MaiginBillInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionViewGuaranteeBill actionViewGuaranteeBill = null;
    /**
     * output class constructor
     */
    public AbstractMaiginBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractMaiginBillEditUI.class.getName());
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
        //actionNumberSign
        actionNumberSign.setEnabled(true);
        actionNumberSign.setDaemonRun(false);

        _tempStr = resHelper.getString("ActionNumberSign.SHORT_DESCRIPTION");
        actionNumberSign.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionNumberSign.LONG_DESCRIPTION");
        actionNumberSign.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionNumberSign.NAME");
        actionNumberSign.putValue(ItemAction.NAME, _tempStr);
        this.actionNumberSign.setExtendProperty("userDefined", "false");
        this.actionNumberSign.setExtendProperty("isObjectUpdateLock", "false");
         this.actionNumberSign.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionAudit
        this.actionAudit = new ActionAudit(this);
        getActionManager().registerAction("actionAudit", actionAudit);
        this.actionAudit.setBindWorkFlow(true);
        this.actionAudit.setExtendProperty("canForewarn", "true");
        this.actionAudit.setExtendProperty("userDefined", "true");
        this.actionAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionUnAudit
        this.actionUnAudit = new ActionUnAudit(this);
        getActionManager().registerAction("actionUnAudit", actionUnAudit);
        this.actionUnAudit.setBindWorkFlow(true);
        this.actionUnAudit.setExtendProperty("canForewarn", "true");
        this.actionUnAudit.setExtendProperty("userDefined", "true");
        this.actionUnAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionViewGuaranteeBill
        this.actionViewGuaranteeBill = new ActionViewGuaranteeBill(this);
        getActionManager().registerAction("actionViewGuaranteeBill", actionViewGuaranteeBill);
        this.actionViewGuaranteeBill.setExtendProperty("canForewarn", "true");
        this.actionViewGuaranteeBill.setExtendProperty("userDefined", "true");
        this.actionViewGuaranteeBill.setExtendProperty("isObjectUpdateLock", "false");
         this.actionViewGuaranteeBill.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionViewGuaranteeBill.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpayAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditOpinion = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbizType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalMargin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contenableMargin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoccupyMargin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkFivouchered = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contvoucherNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contidentity = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbankNo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contphone = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmoneySource = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisHasReceivingBill = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisHasPaymentBill = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contbEBank = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbEBankAddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkliquidated = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contguaranty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contkConFeedSubsidy = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contkPolicySubsidy = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contkPunishAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contkOtherAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contactualPayAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contactualKPunishAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contactualKConFeedSub = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contactualKPolicySub = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contactualKOtherAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDSeparator9 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contfarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtpayAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.scrollPaneauditOpinion = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txtauditOpinion = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.bizType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtfarmer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txttotalMargin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtenableMargin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtoccupyMargin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtvoucherNum = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtidentity = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbankNo = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtphone = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtperson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.moneySource = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtbEBank = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtbEBankAddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtguaranty = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtkConFeedSubsidy = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtkPolicySubsidy = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtkPunishAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtkOtherAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtactualPayAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtactualKPunishAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtactualKConFeedSub = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtactualKPolicySub = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtactualKOtherAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtfarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnViewGuaranteeBill = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.contpayAmount.setName("contpayAmount");
        this.contauditTime.setName("contauditTime");
        this.contauditOpinion.setName("contauditOpinion");
        this.contbillStatus.setName("contbillStatus");
        this.contbizType.setName("contbizType");
        this.contfarmer.setName("contfarmer");
        this.contcompany.setName("contcompany");
        this.conttotalMargin.setName("conttotalMargin");
        this.contenableMargin.setName("contenableMargin");
        this.contoccupyMargin.setName("contoccupyMargin");
        this.chkFivouchered.setName("chkFivouchered");
        this.contvoucherNum.setName("contvoucherNum");
        this.contidentity.setName("contidentity");
        this.contbankNo.setName("contbankNo");
        this.contphone.setName("contphone");
        this.contperson.setName("contperson");
        this.contmoneySource.setName("contmoneySource");
        this.chkisHasReceivingBill.setName("chkisHasReceivingBill");
        this.chkisHasPaymentBill.setName("chkisHasPaymentBill");
        this.contbEBank.setName("contbEBank");
        this.contbEBankAddress.setName("contbEBankAddress");
        this.chkliquidated.setName("chkliquidated");
        this.kdtEntrys.setName("kdtEntrys");
        this.contguaranty.setName("contguaranty");
        this.contkConFeedSubsidy.setName("contkConFeedSubsidy");
        this.contkPolicySubsidy.setName("contkPolicySubsidy");
        this.contkPunishAmt.setName("contkPunishAmt");
        this.contkOtherAmt.setName("contkOtherAmt");
        this.contactualPayAmt.setName("contactualPayAmt");
        this.contactualKPunishAmt.setName("contactualKPunishAmt");
        this.contactualKConFeedSub.setName("contactualKConFeedSub");
        this.contactualKPolicySub.setName("contactualKPolicySub");
        this.contactualKOtherAmt.setName("contactualKOtherAmt");
        this.kDSeparator8.setName("kDSeparator8");
        this.kDSeparator9.setName("kDSeparator9");
        this.contfarm.setName("contfarm");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.txtpayAmount.setName("txtpayAmount");
        this.pkauditTime.setName("pkauditTime");
        this.scrollPaneauditOpinion.setName("scrollPaneauditOpinion");
        this.txtauditOpinion.setName("txtauditOpinion");
        this.billStatus.setName("billStatus");
        this.bizType.setName("bizType");
        this.prmtfarmer.setName("prmtfarmer");
        this.prmtcompany.setName("prmtcompany");
        this.txttotalMargin.setName("txttotalMargin");
        this.txtenableMargin.setName("txtenableMargin");
        this.txtoccupyMargin.setName("txtoccupyMargin");
        this.prmtvoucherNum.setName("prmtvoucherNum");
        this.txtidentity.setName("txtidentity");
        this.txtbankNo.setName("txtbankNo");
        this.txtphone.setName("txtphone");
        this.prmtperson.setName("prmtperson");
        this.moneySource.setName("moneySource");
        this.prmtbEBank.setName("prmtbEBank");
        this.txtbEBankAddress.setName("txtbEBankAddress");
        this.prmtguaranty.setName("prmtguaranty");
        this.txtkConFeedSubsidy.setName("txtkConFeedSubsidy");
        this.txtkPolicySubsidy.setName("txtkPolicySubsidy");
        this.txtkPunishAmt.setName("txtkPunishAmt");
        this.txtkOtherAmt.setName("txtkOtherAmt");
        this.txtactualPayAmt.setName("txtactualPayAmt");
        this.txtactualKPunishAmt.setName("txtactualKPunishAmt");
        this.txtactualKConFeedSub.setName("txtactualKConFeedSub");
        this.txtactualKPolicySub.setName("txtactualKPolicySub");
        this.txtactualKOtherAmt.setName("txtactualKOtherAmt");
        this.prmtfarm.setName("prmtfarm");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
        this.btnViewGuaranteeBill.setName("btnViewGuaranteeBill");
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
        this.contCreator.setForeground(new java.awt.Color(0,0,0));
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
        this.contLastUpdateUser.setForeground(new java.awt.Color(0,0,0));
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
        // contpayAmount		
        this.contpayAmount.setBoundLabelText(resHelper.getString("contpayAmount.boundLabelText"));		
        this.contpayAmount.setBoundLabelLength(100);		
        this.contpayAmount.setBoundLabelUnderline(true);		
        this.contpayAmount.setVisible(true);
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // contauditOpinion		
        this.contauditOpinion.setBoundLabelText(resHelper.getString("contauditOpinion.boundLabelText"));		
        this.contauditOpinion.setBoundLabelLength(100);		
        this.contauditOpinion.setBoundLabelUnderline(true);		
        this.contauditOpinion.setVisible(true);
        // contbillStatus		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);
        // contbizType		
        this.contbizType.setBoundLabelText(resHelper.getString("contbizType.boundLabelText"));		
        this.contbizType.setBoundLabelLength(100);		
        this.contbizType.setBoundLabelUnderline(true);		
        this.contbizType.setVisible(true);
        // contfarmer		
        this.contfarmer.setBoundLabelText(resHelper.getString("contfarmer.boundLabelText"));		
        this.contfarmer.setBoundLabelLength(100);		
        this.contfarmer.setBoundLabelUnderline(true);		
        this.contfarmer.setVisible(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // conttotalMargin		
        this.conttotalMargin.setBoundLabelText(resHelper.getString("conttotalMargin.boundLabelText"));		
        this.conttotalMargin.setBoundLabelLength(100);		
        this.conttotalMargin.setBoundLabelUnderline(true);		
        this.conttotalMargin.setVisible(true);
        // contenableMargin		
        this.contenableMargin.setBoundLabelText(resHelper.getString("contenableMargin.boundLabelText"));		
        this.contenableMargin.setBoundLabelLength(100);		
        this.contenableMargin.setBoundLabelUnderline(true);		
        this.contenableMargin.setVisible(false);
        // contoccupyMargin		
        this.contoccupyMargin.setBoundLabelText(resHelper.getString("contoccupyMargin.boundLabelText"));		
        this.contoccupyMargin.setBoundLabelLength(100);		
        this.contoccupyMargin.setBoundLabelUnderline(true);		
        this.contoccupyMargin.setVisible(false);
        // chkFivouchered		
        this.chkFivouchered.setHorizontalAlignment(2);		
        this.chkFivouchered.setEnabled(false);		
        this.chkFivouchered.setText(resHelper.getString("chkFivouchered.text"));
        // contvoucherNum		
        this.contvoucherNum.setBoundLabelText(resHelper.getString("contvoucherNum.boundLabelText"));		
        this.contvoucherNum.setBoundLabelLength(100);		
        this.contvoucherNum.setBoundLabelUnderline(true);		
        this.contvoucherNum.setVisible(true);
        // contidentity		
        this.contidentity.setBoundLabelText(resHelper.getString("contidentity.boundLabelText"));		
        this.contidentity.setBoundLabelLength(100);		
        this.contidentity.setBoundLabelUnderline(true);		
        this.contidentity.setVisible(true);
        // contbankNo		
        this.contbankNo.setBoundLabelText(resHelper.getString("contbankNo.boundLabelText"));		
        this.contbankNo.setBoundLabelLength(100);		
        this.contbankNo.setBoundLabelUnderline(true);		
        this.contbankNo.setVisible(true);
        // contphone		
        this.contphone.setBoundLabelText(resHelper.getString("contphone.boundLabelText"));		
        this.contphone.setBoundLabelLength(100);		
        this.contphone.setBoundLabelUnderline(true);		
        this.contphone.setVisible(true);
        // contperson		
        this.contperson.setBoundLabelText(resHelper.getString("contperson.boundLabelText"));		
        this.contperson.setBoundLabelLength(100);		
        this.contperson.setBoundLabelUnderline(true);		
        this.contperson.setVisible(true);
        // contmoneySource		
        this.contmoneySource.setBoundLabelText(resHelper.getString("contmoneySource.boundLabelText"));		
        this.contmoneySource.setBoundLabelLength(100);		
        this.contmoneySource.setBoundLabelUnderline(true);		
        this.contmoneySource.setVisible(true);
        // chkisHasReceivingBill		
        this.chkisHasReceivingBill.setText(resHelper.getString("chkisHasReceivingBill.text"));		
        this.chkisHasReceivingBill.setHorizontalAlignment(2);		
        this.chkisHasReceivingBill.setEnabled(false);
        // chkisHasPaymentBill		
        this.chkisHasPaymentBill.setText(resHelper.getString("chkisHasPaymentBill.text"));		
        this.chkisHasPaymentBill.setHorizontalAlignment(2);		
        this.chkisHasPaymentBill.setEnabled(false);
        // contbEBank		
        this.contbEBank.setBoundLabelText(resHelper.getString("contbEBank.boundLabelText"));		
        this.contbEBank.setBoundLabelLength(100);		
        this.contbEBank.setBoundLabelUnderline(true);		
        this.contbEBank.setVisible(true);
        // contbEBankAddress		
        this.contbEBankAddress.setBoundLabelText(resHelper.getString("contbEBankAddress.boundLabelText"));		
        this.contbEBankAddress.setBoundLabelLength(100);		
        this.contbEBankAddress.setBoundLabelUnderline(true);		
        this.contbEBankAddress.setVisible(true);
        // chkliquidated		
        this.chkliquidated.setText(resHelper.getString("chkliquidated.text"));		
        this.chkliquidated.setHorizontalAlignment(2);		
        this.chkliquidated.setEnabled(false);
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"farm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"inDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"batchContract\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"breedData\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"contractQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" t:styleID=\"sCol5\" /><t:Column t:key=\"batchQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"6\" t:styleID=\"sCol6\" /><t:Column t:key=\"minMargin\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"singleMargin\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"status\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{farm}</t:Cell><t:Cell>$Resource{inDate}</t:Cell><t:Cell>$Resource{batchContract}</t:Cell><t:Cell>$Resource{breedData}</t:Cell><t:Cell>$Resource{contractQty}</t:Cell><t:Cell>$Resource{batchQty}</t:Cell><t:Cell>$Resource{minMargin}</t:Cell><t:Cell>$Resource{singleMargin}</t:Cell><t:Cell>$Resource{status}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));

                this.kdtEntrys.putBindContents("editData",new String[] {"seq","farm","inDate","batchContract","breedData","contractQty","batchQty","minMargin","singleMargin","status"});


        this.kdtEntrys.checkParsed();
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
					
        KDDatePicker kdtEntrys_inDate_DatePicker = new KDDatePicker();
        kdtEntrys_inDate_DatePicker.setName("kdtEntrys_inDate_DatePicker");
        kdtEntrys_inDate_DatePicker.setVisible(true);
        kdtEntrys_inDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_inDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_inDate_DatePicker);
        this.kdtEntrys.getColumn("inDate").setEditor(kdtEntrys_inDate_CellEditor);
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
        final KDBizPromptBox kdtEntrys_breedData_PromptBox = new KDBizPromptBox();
        kdtEntrys_breedData_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.BreedDataQuery");
        kdtEntrys_breedData_PromptBox.setVisible(true);
        kdtEntrys_breedData_PromptBox.setEditable(true);
        kdtEntrys_breedData_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_breedData_PromptBox.setEditFormat("$number$");
        kdtEntrys_breedData_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_breedData_CellEditor = new KDTDefaultCellEditor(kdtEntrys_breedData_PromptBox);
        this.kdtEntrys.getColumn("breedData").setEditor(kdtEntrys_breedData_CellEditor);
        ObjectValueRender kdtEntrys_breedData_OVR = new ObjectValueRender();
        kdtEntrys_breedData_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("breedData").setRenderer(kdtEntrys_breedData_OVR);
        			kdtEntrys_breedData_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI kdtEntrys_breedData_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_breedData_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_breedData_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_breedData_PromptBox_F7ListUI));
					kdtEntrys_breedData_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_breedData_PromptBox.setSelector(kdtEntrys_breedData_PromptBox_F7ListUI);
				}
			}
		});
					
        KDFormattedTextField kdtEntrys_contractQty_TextField = new KDFormattedTextField();
        kdtEntrys_contractQty_TextField.setName("kdtEntrys_contractQty_TextField");
        kdtEntrys_contractQty_TextField.setVisible(true);
        kdtEntrys_contractQty_TextField.setEditable(true);
        kdtEntrys_contractQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_contractQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_contractQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_contractQty_TextField);
        this.kdtEntrys.getColumn("contractQty").setEditor(kdtEntrys_contractQty_CellEditor);
        KDFormattedTextField kdtEntrys_batchQty_TextField = new KDFormattedTextField();
        kdtEntrys_batchQty_TextField.setName("kdtEntrys_batchQty_TextField");
        kdtEntrys_batchQty_TextField.setVisible(true);
        kdtEntrys_batchQty_TextField.setEditable(true);
        kdtEntrys_batchQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_batchQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_batchQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_batchQty_TextField);
        this.kdtEntrys.getColumn("batchQty").setEditor(kdtEntrys_batchQty_CellEditor);
        KDFormattedTextField kdtEntrys_minMargin_TextField = new KDFormattedTextField();
        kdtEntrys_minMargin_TextField.setName("kdtEntrys_minMargin_TextField");
        kdtEntrys_minMargin_TextField.setVisible(true);
        kdtEntrys_minMargin_TextField.setEditable(true);
        kdtEntrys_minMargin_TextField.setHorizontalAlignment(2);
        kdtEntrys_minMargin_TextField.setDataType(1);
        	kdtEntrys_minMargin_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_minMargin_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_minMargin_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_minMargin_CellEditor = new KDTDefaultCellEditor(kdtEntrys_minMargin_TextField);
        this.kdtEntrys.getColumn("minMargin").setEditor(kdtEntrys_minMargin_CellEditor);
        KDFormattedTextField kdtEntrys_singleMargin_TextField = new KDFormattedTextField();
        kdtEntrys_singleMargin_TextField.setName("kdtEntrys_singleMargin_TextField");
        kdtEntrys_singleMargin_TextField.setVisible(true);
        kdtEntrys_singleMargin_TextField.setEditable(true);
        kdtEntrys_singleMargin_TextField.setHorizontalAlignment(2);
        kdtEntrys_singleMargin_TextField.setDataType(1);
        	kdtEntrys_singleMargin_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_singleMargin_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_singleMargin_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_singleMargin_CellEditor = new KDTDefaultCellEditor(kdtEntrys_singleMargin_TextField);
        this.kdtEntrys.getColumn("singleMargin").setEditor(kdtEntrys_singleMargin_CellEditor);
        KDTextField kdtEntrys_status_TextField = new KDTextField();
        kdtEntrys_status_TextField.setName("kdtEntrys_status_TextField");
        kdtEntrys_status_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_status_CellEditor = new KDTDefaultCellEditor(kdtEntrys_status_TextField);
        this.kdtEntrys.getColumn("status").setEditor(kdtEntrys_status_CellEditor);
        // contguaranty		
        this.contguaranty.setBoundLabelText(resHelper.getString("contguaranty.boundLabelText"));		
        this.contguaranty.setBoundLabelLength(100);		
        this.contguaranty.setBoundLabelUnderline(true);		
        this.contguaranty.setVisible(true);
        // contkConFeedSubsidy		
        this.contkConFeedSubsidy.setBoundLabelText(resHelper.getString("contkConFeedSubsidy.boundLabelText"));		
        this.contkConFeedSubsidy.setBoundLabelLength(120);		
        this.contkConFeedSubsidy.setBoundLabelUnderline(true);		
        this.contkConFeedSubsidy.setVisible(true);
        // contkPolicySubsidy		
        this.contkPolicySubsidy.setBoundLabelText(resHelper.getString("contkPolicySubsidy.boundLabelText"));		
        this.contkPolicySubsidy.setBoundLabelLength(120);		
        this.contkPolicySubsidy.setBoundLabelUnderline(true);		
        this.contkPolicySubsidy.setVisible(true);
        // contkPunishAmt		
        this.contkPunishAmt.setBoundLabelText(resHelper.getString("contkPunishAmt.boundLabelText"));		
        this.contkPunishAmt.setBoundLabelLength(120);		
        this.contkPunishAmt.setBoundLabelUnderline(true);		
        this.contkPunishAmt.setVisible(true);
        // contkOtherAmt		
        this.contkOtherAmt.setBoundLabelText(resHelper.getString("contkOtherAmt.boundLabelText"));		
        this.contkOtherAmt.setBoundLabelLength(120);		
        this.contkOtherAmt.setBoundLabelUnderline(true);		
        this.contkOtherAmt.setVisible(true);
        // contactualPayAmt		
        this.contactualPayAmt.setBoundLabelText(resHelper.getString("contactualPayAmt.boundLabelText"));		
        this.contactualPayAmt.setBoundLabelLength(100);		
        this.contactualPayAmt.setBoundLabelUnderline(true);		
        this.contactualPayAmt.setVisible(true);
        // contactualKPunishAmt		
        this.contactualKPunishAmt.setBoundLabelText(resHelper.getString("contactualKPunishAmt.boundLabelText"));		
        this.contactualKPunishAmt.setBoundLabelLength(120);		
        this.contactualKPunishAmt.setBoundLabelUnderline(true);		
        this.contactualKPunishAmt.setVisible(true);
        // contactualKConFeedSub		
        this.contactualKConFeedSub.setBoundLabelText(resHelper.getString("contactualKConFeedSub.boundLabelText"));		
        this.contactualKConFeedSub.setBoundLabelLength(120);		
        this.contactualKConFeedSub.setBoundLabelUnderline(true);		
        this.contactualKConFeedSub.setVisible(true);
        // contactualKPolicySub		
        this.contactualKPolicySub.setBoundLabelText(resHelper.getString("contactualKPolicySub.boundLabelText"));		
        this.contactualKPolicySub.setBoundLabelLength(120);		
        this.contactualKPolicySub.setBoundLabelUnderline(true);		
        this.contactualKPolicySub.setVisible(true);
        // contactualKOtherAmt		
        this.contactualKOtherAmt.setBoundLabelText(resHelper.getString("contactualKOtherAmt.boundLabelText"));		
        this.contactualKOtherAmt.setBoundLabelLength(120);		
        this.contactualKOtherAmt.setBoundLabelUnderline(true);		
        this.contactualKOtherAmt.setVisible(true);
        // kDSeparator8
        // kDSeparator9
        // contfarm		
        this.contfarm.setBoundLabelText(resHelper.getString("contfarm.boundLabelText"));		
        this.contfarm.setBoundLabelLength(100);		
        this.contfarm.setBoundLabelUnderline(true);		
        this.contfarm.setVisible(true);
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
        this.txtNumber.setEnabled(false);
        // pkBizDate		
        this.pkBizDate.setEnabled(true);		
        this.pkBizDate.setRequired(true);
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // txtpayAmount		
        this.txtpayAmount.setHorizontalAlignment(2);		
        this.txtpayAmount.setDataType(1);		
        this.txtpayAmount.setSupportedEmpty(true);		
        this.txtpayAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpayAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpayAmount.setPrecision(2);		
        this.txtpayAmount.setRequired(true);		
        this.txtpayAmount.setEnabled(false);
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // scrollPaneauditOpinion
        // txtauditOpinion		
        this.txtauditOpinion.setRequired(false);		
        this.txtauditOpinion.setMaxLength(500);
        // billStatus		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // bizType		
        this.bizType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.basebiz.bizType").toArray());		
        this.bizType.setRequired(false);
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
					
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
        		setOrgF7(prmtcompany,com.kingdee.eas.basedata.org.OrgType.getEnum("Company"));
					
        // txttotalMargin		
        this.txttotalMargin.setHorizontalAlignment(2);		
        this.txttotalMargin.setDataType(1);		
        this.txttotalMargin.setSupportedEmpty(true);		
        this.txttotalMargin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttotalMargin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttotalMargin.setPrecision(2);		
        this.txttotalMargin.setRequired(false);		
        this.txttotalMargin.setEnabled(false);
        // txtenableMargin		
        this.txtenableMargin.setHorizontalAlignment(2);		
        this.txtenableMargin.setDataType(1);		
        this.txtenableMargin.setSupportedEmpty(true);		
        this.txtenableMargin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtenableMargin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtenableMargin.setPrecision(10);		
        this.txtenableMargin.setRequired(false);		
        this.txtenableMargin.setEnabled(false);		
        this.txtenableMargin.setVisible(false);
        // txtoccupyMargin		
        this.txtoccupyMargin.setHorizontalAlignment(2);		
        this.txtoccupyMargin.setDataType(1);		
        this.txtoccupyMargin.setSupportedEmpty(true);		
        this.txtoccupyMargin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtoccupyMargin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtoccupyMargin.setPrecision(2);		
        this.txtoccupyMargin.setRequired(false);		
        this.txtoccupyMargin.setEnabled(false);		
        this.txtoccupyMargin.setVisible(false);
        // prmtvoucherNum		
        this.prmtvoucherNum.setQueryInfo("com.kingdee.eas.fi.gl.app.VoucherEntryQuery");		
        this.prmtvoucherNum.setEditable(true);		
        this.prmtvoucherNum.setDisplayFormat("$number$");		
        this.prmtvoucherNum.setEditFormat("$number$");		
        this.prmtvoucherNum.setCommitFormat("$number$");		
        this.prmtvoucherNum.setRequired(false);		
        this.prmtvoucherNum.setEnabled(false);
        // txtidentity		
        this.txtidentity.setHorizontalAlignment(2);		
        this.txtidentity.setMaxLength(100);		
        this.txtidentity.setRequired(false);		
        this.txtidentity.setEnabled(false);
        // txtbankNo		
        this.txtbankNo.setHorizontalAlignment(2);		
        this.txtbankNo.setMaxLength(100);		
        this.txtbankNo.setRequired(false);
        // txtphone		
        this.txtphone.setHorizontalAlignment(2);		
        this.txtphone.setMaxLength(100);		
        this.txtphone.setRequired(false);		
        this.txtphone.setEnabled(false);
        // prmtperson		
        this.prmtperson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtperson.setEditable(true);		
        this.prmtperson.setDisplayFormat("$name$");		
        this.prmtperson.setEditFormat("$number$");		
        this.prmtperson.setCommitFormat("$number$");		
        this.prmtperson.setRequired(false);		
        this.prmtperson.setEnabled(false);
        // moneySource		
        this.moneySource.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.basebiz.moneySource").toArray());		
        this.moneySource.setRequired(false);		
        this.moneySource.setEnabled(false);
        // prmtbEBank		
        this.prmtbEBank.setQueryInfo("com.kingdee.eas.fm.be.app.BEBankQuery");		
        this.prmtbEBank.setEditable(true);		
        this.prmtbEBank.setDisplayFormat("$name$");		
        this.prmtbEBank.setEditFormat("$number$");		
        this.prmtbEBank.setCommitFormat("$number$");		
        this.prmtbEBank.setRequired(false);
        prmtbEBank.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtbEBank_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtbEBankAddress		
        this.txtbEBankAddress.setHorizontalAlignment(2);		
        this.txtbEBankAddress.setMaxLength(80);		
        this.txtbEBankAddress.setRequired(false);
        // prmtguaranty		
        this.prmtguaranty.setQueryInfo("com.kingdee.eas.farm.carnivorous.basebiz.app.FarmerGuaranteeBillQuery");		
        this.prmtguaranty.setEditable(true);		
        this.prmtguaranty.setDisplayFormat("$number$");		
        this.prmtguaranty.setEditFormat("$number$");		
        this.prmtguaranty.setCommitFormat("$number$");		
        this.prmtguaranty.setRequired(false);
        		EntityViewInfo eviprmtguaranty = new EntityViewInfo ();
		eviprmtguaranty.setFilter(com.kingdee.eas.framework.FrameWorkUtils.getF7FilterInfoByAuthorizedOrg(com.kingdee.eas.basedata.org.OrgType.getEnum("Company"),"FICompany.id"));
		prmtguaranty.setEntityViewInfo(eviprmtguaranty);
					
        // txtkConFeedSubsidy		
        this.txtkConFeedSubsidy.setVisible(true);		
        this.txtkConFeedSubsidy.setHorizontalAlignment(2);		
        this.txtkConFeedSubsidy.setDataType(1);		
        this.txtkConFeedSubsidy.setSupportedEmpty(true);		
        this.txtkConFeedSubsidy.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtkConFeedSubsidy.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtkConFeedSubsidy.setPrecision(4);		
        this.txtkConFeedSubsidy.setRequired(false);		
        this.txtkConFeedSubsidy.setEnabled(false);
        // txtkPolicySubsidy		
        this.txtkPolicySubsidy.setVisible(true);		
        this.txtkPolicySubsidy.setHorizontalAlignment(2);		
        this.txtkPolicySubsidy.setDataType(1);		
        this.txtkPolicySubsidy.setSupportedEmpty(true);		
        this.txtkPolicySubsidy.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtkPolicySubsidy.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtkPolicySubsidy.setPrecision(2);		
        this.txtkPolicySubsidy.setRequired(false);		
        this.txtkPolicySubsidy.setEnabled(false);
        // txtkPunishAmt		
        this.txtkPunishAmt.setVisible(true);		
        this.txtkPunishAmt.setHorizontalAlignment(2);		
        this.txtkPunishAmt.setDataType(1);		
        this.txtkPunishAmt.setSupportedEmpty(true);		
        this.txtkPunishAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtkPunishAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtkPunishAmt.setPrecision(2);		
        this.txtkPunishAmt.setRequired(false);		
        this.txtkPunishAmt.setEnabled(false);
        // txtkOtherAmt		
        this.txtkOtherAmt.setVisible(true);		
        this.txtkOtherAmt.setHorizontalAlignment(2);		
        this.txtkOtherAmt.setDataType(1);		
        this.txtkOtherAmt.setSupportedEmpty(true);		
        this.txtkOtherAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtkOtherAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtkOtherAmt.setPrecision(2);		
        this.txtkOtherAmt.setRequired(false);		
        this.txtkOtherAmt.setEnabled(false);
        // txtactualPayAmt		
        this.txtactualPayAmt.setVisible(true);		
        this.txtactualPayAmt.setHorizontalAlignment(2);		
        this.txtactualPayAmt.setDataType(1);		
        this.txtactualPayAmt.setSupportedEmpty(true);		
        this.txtactualPayAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtactualPayAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtactualPayAmt.setPrecision(2);		
        this.txtactualPayAmt.setRequired(false);		
        this.txtactualPayAmt.setEnabled(false);
        // txtactualKPunishAmt		
        this.txtactualKPunishAmt.setVisible(true);		
        this.txtactualKPunishAmt.setHorizontalAlignment(2);		
        this.txtactualKPunishAmt.setDataType(1);		
        this.txtactualKPunishAmt.setSupportedEmpty(true);		
        this.txtactualKPunishAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtactualKPunishAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtactualKPunishAmt.setPrecision(2);		
        this.txtactualKPunishAmt.setRequired(false);		
        this.txtactualKPunishAmt.setEnabled(false);
        // txtactualKConFeedSub		
        this.txtactualKConFeedSub.setVisible(true);		
        this.txtactualKConFeedSub.setHorizontalAlignment(2);		
        this.txtactualKConFeedSub.setDataType(1);		
        this.txtactualKConFeedSub.setSupportedEmpty(true);		
        this.txtactualKConFeedSub.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtactualKConFeedSub.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtactualKConFeedSub.setPrecision(2);		
        this.txtactualKConFeedSub.setRequired(false);		
        this.txtactualKConFeedSub.setEnabled(false);
        // txtactualKPolicySub		
        this.txtactualKPolicySub.setVisible(true);		
        this.txtactualKPolicySub.setHorizontalAlignment(2);		
        this.txtactualKPolicySub.setDataType(1);		
        this.txtactualKPolicySub.setSupportedEmpty(true);		
        this.txtactualKPolicySub.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtactualKPolicySub.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtactualKPolicySub.setPrecision(2);		
        this.txtactualKPolicySub.setRequired(false);		
        this.txtactualKPolicySub.setEnabled(false);
        // txtactualKOtherAmt		
        this.txtactualKOtherAmt.setVisible(true);		
        this.txtactualKOtherAmt.setHorizontalAlignment(2);		
        this.txtactualKOtherAmt.setDataType(1);		
        this.txtactualKOtherAmt.setSupportedEmpty(true);		
        this.txtactualKOtherAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtactualKOtherAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtactualKOtherAmt.setPrecision(2);		
        this.txtactualKOtherAmt.setRequired(false);		
        this.txtactualKOtherAmt.setEnabled(false);
        // prmtfarm		
        this.prmtfarm.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmQuery");		
        this.prmtfarm.setVisible(true);		
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
					
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        // btnViewGuaranteeBill
        this.btnViewGuaranteeBill.setAction((IItemAction)ActionProxyFactory.getProxy(actionViewGuaranteeBill, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnViewGuaranteeBill.setText(resHelper.getString("btnViewGuaranteeBill.text"));		
        this.btnViewGuaranteeBill.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_linkviewbill"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {chkFivouchered,txtenableMargin,txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,txtpayAmount,pkauditTime,txtauditOpinion,prmtcompany,billStatus,bizType,prmtfarmer,txttotalMargin,txtoccupyMargin,prmtvoucherNum,txtidentity,txtbankNo,txtphone,prmtperson,moneySource,chkisHasReceivingBill,chkisHasPaymentBill,prmtbEBank,txtbEBankAddress,chkliquidated,prmtguaranty,kdtEntrys,txtkPolicySubsidy,txtkConFeedSubsidy,txtkPunishAmt,txtkOtherAmt,txtactualPayAmt,txtactualKPunishAmt,txtactualKConFeedSub,txtactualKPolicySub,txtactualKOtherAmt,prmtfarm}));
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
        this.setBounds(new Rectangle(0, 0, 1161, 654));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1161, 654));
        contCreator.setBounds(new Rectangle(369, 566, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(369, 566, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(819, 565, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(819, 565, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(368, 604, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(368, 604, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(818, 603, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(818, 603, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(26, 16, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(26, 16, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(310, 16, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(310, 16, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(310, 274, 271, 19));
        this.add(contDescription, new KDLayout.Constraints(310, 274, 271, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(26, 566, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(26, 566, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpayAmount.setBounds(new Rectangle(310, 134, 270, 19));
        this.add(contpayAmount, new KDLayout.Constraints(310, 134, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(26, 604, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(26, 604, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditOpinion.setBounds(new Rectangle(26, 443, 1065, 100));
        this.add(contauditOpinion, new KDLayout.Constraints(26, 443, 1065, 100, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contbillStatus.setBounds(new Rectangle(594, 16, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(594, 16, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbizType.setBounds(new Rectangle(26, 45, 270, 19));
        this.add(contbizType, new KDLayout.Constraints(26, 45, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmer.setBounds(new Rectangle(310, 45, 270, 19));
        this.add(contfarmer, new KDLayout.Constraints(310, 45, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompany.setBounds(new Rectangle(882, 16, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(882, 16, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conttotalMargin.setBounds(new Rectangle(310, 103, 270, 19));
        this.add(conttotalMargin, new KDLayout.Constraints(310, 103, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contenableMargin.setBounds(new Rectangle(596, 171, 270, 19));
        this.add(contenableMargin, new KDLayout.Constraints(596, 171, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoccupyMargin.setBounds(new Rectangle(885, 174, 270, 19));
        this.add(contoccupyMargin, new KDLayout.Constraints(885, 174, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkFivouchered.setBounds(new Rectangle(594, 274, 116, 19));
        this.add(chkFivouchered, new KDLayout.Constraints(594, 274, 116, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contvoucherNum.setBounds(new Rectangle(26, 274, 270, 19));
        this.add(contvoucherNum, new KDLayout.Constraints(26, 274, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contidentity.setBounds(new Rectangle(594, 45, 270, 19));
        this.add(contidentity, new KDLayout.Constraints(594, 45, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbankNo.setBounds(new Rectangle(882, 74, 270, 19));
        this.add(contbankNo, new KDLayout.Constraints(882, 74, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contphone.setBounds(new Rectangle(882, 45, 270, 19));
        this.add(contphone, new KDLayout.Constraints(882, 45, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contperson.setBounds(new Rectangle(882, 102, 270, 19));
        this.add(contperson, new KDLayout.Constraints(882, 102, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contmoneySource.setBounds(new Rectangle(310, 74, 270, 19));
        this.add(contmoneySource, new KDLayout.Constraints(310, 74, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisHasReceivingBill.setBounds(new Rectangle(736, 274, 131, 19));
        this.add(chkisHasReceivingBill, new KDLayout.Constraints(736, 274, 131, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisHasPaymentBill.setBounds(new Rectangle(882, 274, 132, 19));
        this.add(chkisHasPaymentBill, new KDLayout.Constraints(882, 274, 132, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbEBank.setBounds(new Rectangle(594, 74, 270, 19));
        this.add(contbEBank, new KDLayout.Constraints(594, 74, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbEBankAddress.setBounds(new Rectangle(26, 103, 270, 19));
        this.add(contbEBankAddress, new KDLayout.Constraints(26, 103, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkliquidated.setBounds(new Rectangle(26, 174, 257, 19));
        this.add(chkliquidated, new KDLayout.Constraints(26, 174, 257, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(26, 309, 1066, 119));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.carnivorous.basebiz.MaiginBillEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(26, 309, 1066, 119, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contguaranty.setBounds(new Rectangle(26, 134, 270, 19));
        this.add(contguaranty, new KDLayout.Constraints(26, 134, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contkConFeedSubsidy.setBounds(new Rectangle(310, 198, 270, 19));
        this.add(contkConFeedSubsidy, new KDLayout.Constraints(310, 198, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contkPolicySubsidy.setBounds(new Rectangle(594, 198, 270, 19));
        this.add(contkPolicySubsidy, new KDLayout.Constraints(594, 198, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contkPunishAmt.setBounds(new Rectangle(26, 198, 270, 19));
        this.add(contkPunishAmt, new KDLayout.Constraints(26, 198, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contkOtherAmt.setBounds(new Rectangle(882, 198, 270, 19));
        this.add(contkOtherAmt, new KDLayout.Constraints(882, 198, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contactualPayAmt.setBounds(new Rectangle(594, 102, 270, 19));
        this.add(contactualPayAmt, new KDLayout.Constraints(594, 102, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contactualKPunishAmt.setBounds(new Rectangle(26, 228, 270, 19));
        this.add(contactualKPunishAmt, new KDLayout.Constraints(26, 228, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contactualKConFeedSub.setBounds(new Rectangle(310, 228, 270, 19));
        this.add(contactualKConFeedSub, new KDLayout.Constraints(310, 228, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contactualKPolicySub.setBounds(new Rectangle(594, 228, 270, 19));
        this.add(contactualKPolicySub, new KDLayout.Constraints(594, 228, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contactualKOtherAmt.setBounds(new Rectangle(882, 228, 270, 19));
        this.add(contactualKOtherAmt, new KDLayout.Constraints(882, 228, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator8.setBounds(new Rectangle(-6, 163, 1210, 8));
        this.add(kDSeparator8, new KDLayout.Constraints(-6, 163, 1210, 8, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator9.setBounds(new Rectangle(-6, 261, 1427, 8));
        this.add(kDSeparator9, new KDLayout.Constraints(-6, 261, 1427, 8, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contfarm.setBounds(new Rectangle(26, 74, 270, 19));
        this.add(contfarm, new KDLayout.Constraints(26, 74, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contpayAmount
        contpayAmount.setBoundEditor(txtpayAmount);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contauditOpinion
        contauditOpinion.setBoundEditor(scrollPaneauditOpinion);
        //scrollPaneauditOpinion
        scrollPaneauditOpinion.getViewport().add(txtauditOpinion, null);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //contbizType
        contbizType.setBoundEditor(bizType);
        //contfarmer
        contfarmer.setBoundEditor(prmtfarmer);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //conttotalMargin
        conttotalMargin.setBoundEditor(txttotalMargin);
        //contenableMargin
        contenableMargin.setBoundEditor(txtenableMargin);
        //contoccupyMargin
        contoccupyMargin.setBoundEditor(txtoccupyMargin);
        //contvoucherNum
        contvoucherNum.setBoundEditor(prmtvoucherNum);
        //contidentity
        contidentity.setBoundEditor(txtidentity);
        //contbankNo
        contbankNo.setBoundEditor(txtbankNo);
        //contphone
        contphone.setBoundEditor(txtphone);
        //contperson
        contperson.setBoundEditor(prmtperson);
        //contmoneySource
        contmoneySource.setBoundEditor(moneySource);
        //contbEBank
        contbEBank.setBoundEditor(prmtbEBank);
        //contbEBankAddress
        contbEBankAddress.setBoundEditor(txtbEBankAddress);
        //contguaranty
        contguaranty.setBoundEditor(prmtguaranty);
        //contkConFeedSubsidy
        contkConFeedSubsidy.setBoundEditor(txtkConFeedSubsidy);
        //contkPolicySubsidy
        contkPolicySubsidy.setBoundEditor(txtkPolicySubsidy);
        //contkPunishAmt
        contkPunishAmt.setBoundEditor(txtkPunishAmt);
        //contkOtherAmt
        contkOtherAmt.setBoundEditor(txtkOtherAmt);
        //contactualPayAmt
        contactualPayAmt.setBoundEditor(txtactualPayAmt);
        //contactualKPunishAmt
        contactualKPunishAmt.setBoundEditor(txtactualKPunishAmt);
        //contactualKConFeedSub
        contactualKConFeedSub.setBoundEditor(txtactualKConFeedSub);
        //contactualKPolicySub
        contactualKPolicySub.setBoundEditor(txtactualKPolicySub);
        //contactualKOtherAmt
        contactualKOtherAmt.setBoundEditor(txtactualKOtherAmt);
        //contfarm
        contfarm.setBoundEditor(prmtfarm);

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
        this.toolBar.add(btnViewGuaranteeBill);
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
        this.toolBar.add(btnPCVoucher);
        this.toolBar.add(btnVoucher);
        this.toolBar.add(btnDelPCVoucher);
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(btnNextPerson);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("Fivouchered", boolean.class, this.chkFivouchered, "selected");
		dataBinder.registerBinding("isHasReceivingBill", boolean.class, this.chkisHasReceivingBill, "selected");
		dataBinder.registerBinding("isHasPaymentBill", boolean.class, this.chkisHasPaymentBill, "selected");
		dataBinder.registerBinding("liquidated", boolean.class, this.chkliquidated, "selected");
		dataBinder.registerBinding("Entrys.seq", int.class, this.kdtEntrys, "seq.text");
		dataBinder.registerBinding("Entrys", com.kingdee.eas.farm.carnivorous.basebiz.MaiginBillEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("Entrys.farm", java.lang.Object.class, this.kdtEntrys, "farm.text");
		dataBinder.registerBinding("Entrys.inDate", java.util.Date.class, this.kdtEntrys, "inDate.text");
		dataBinder.registerBinding("Entrys.batchContract", java.lang.Object.class, this.kdtEntrys, "batchContract.text");
		dataBinder.registerBinding("Entrys.breedData", java.lang.Object.class, this.kdtEntrys, "breedData.text");
		dataBinder.registerBinding("Entrys.batchQty", int.class, this.kdtEntrys, "batchQty.text");
		dataBinder.registerBinding("Entrys.minMargin", java.math.BigDecimal.class, this.kdtEntrys, "minMargin.text");
		dataBinder.registerBinding("Entrys.status", String.class, this.kdtEntrys, "status.text");
		dataBinder.registerBinding("Entrys.singleMargin", java.math.BigDecimal.class, this.kdtEntrys, "singleMargin.text");
		dataBinder.registerBinding("Entrys.contractQty", int.class, this.kdtEntrys, "contractQty.text");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("payAmount", java.math.BigDecimal.class, this.txtpayAmount, "value");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("auditOpinion", String.class, this.txtauditOpinion, "text");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("bizType", com.kingdee.eas.farm.carnivorous.basebiz.bizType.class, this.bizType, "selectedItem");
		dataBinder.registerBinding("farmer", com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo.class, this.prmtfarmer, "data");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("totalMargin", java.math.BigDecimal.class, this.txttotalMargin, "value");
		dataBinder.registerBinding("enableMargin", java.math.BigDecimal.class, this.txtenableMargin, "value");
		dataBinder.registerBinding("occupyMargin", java.math.BigDecimal.class, this.txtoccupyMargin, "value");
		dataBinder.registerBinding("voucherNum", com.kingdee.eas.fi.gl.VoucherInfo.class, this.prmtvoucherNum, "data");
		dataBinder.registerBinding("identity", String.class, this.txtidentity, "text");
		dataBinder.registerBinding("bankNo", String.class, this.txtbankNo, "text");
		dataBinder.registerBinding("phone", String.class, this.txtphone, "text");
		dataBinder.registerBinding("person", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtperson, "data");
		dataBinder.registerBinding("moneySource", com.kingdee.eas.farm.carnivorous.basebiz.moneySource.class, this.moneySource, "selectedItem");
		dataBinder.registerBinding("bEBank", com.kingdee.eas.fm.be.BEBankInfo.class, this.prmtbEBank, "data");
		dataBinder.registerBinding("bEBankAddress", String.class, this.txtbEBankAddress, "text");
		dataBinder.registerBinding("guaranty", com.kingdee.eas.farm.carnivorous.basebiz.FarmerGuaranteeBillInfo.class, this.prmtguaranty, "data");
		dataBinder.registerBinding("kConFeedSubsidy", java.math.BigDecimal.class, this.txtkConFeedSubsidy, "value");
		dataBinder.registerBinding("kPolicySubsidy", java.math.BigDecimal.class, this.txtkPolicySubsidy, "value");
		dataBinder.registerBinding("kPunishAmt", java.math.BigDecimal.class, this.txtkPunishAmt, "value");
		dataBinder.registerBinding("kOtherAmt", java.math.BigDecimal.class, this.txtkOtherAmt, "value");
		dataBinder.registerBinding("actualPayAmt", java.math.BigDecimal.class, this.txtactualPayAmt, "value");
		dataBinder.registerBinding("actualKPunishAmt", java.math.BigDecimal.class, this.txtactualKPunishAmt, "value");
		dataBinder.registerBinding("actualKConFeedSub", java.math.BigDecimal.class, this.txtactualKConFeedSub, "value");
		dataBinder.registerBinding("actualKPolicySub", java.math.BigDecimal.class, this.txtactualKPolicySub, "value");
		dataBinder.registerBinding("actualKOtherAmt", java.math.BigDecimal.class, this.txtactualKOtherAmt, "value");
		dataBinder.registerBinding("farm", com.kingdee.eas.farm.carnivorous.basedata.FarmInfo.class, this.prmtfarm, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.carnivorous.basebiz.app.MaiginBillEditUIHandler";
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
        this.chkFivouchered.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.carnivorous.basebiz.MaiginBillInfo)ov;
    }
    protected void removeByPK(IObjectPK pk) throws Exception {
    	IObjectValue editData = this.editData;
    	super.removeByPK(pk);
    	recycleNumberByOrg(editData,"Company",editData.getString("number"));
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
			protected com.kingdee.eas.basedata.org.OrgType getMainBizOrgType() {
			return com.kingdee.eas.basedata.org.OrgType.getEnum("Company");
		}

	protected KDBizPromptBox getMainBizOrg() {
		return prmtcompany;
}


    /**
     * output loadFields method
     */
    public void loadFields()
    {
        		setAutoNumberByOrg("Company");
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
		getValidateHelper().registerBindProperty("Fivouchered", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isHasReceivingBill", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isHasPaymentBill", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("liquidated", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.inDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.batchContract", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.breedData", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.batchQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.minMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.status", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.singleMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.contractQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("payAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditOpinion", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("enableMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("occupyMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("voucherNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("identity", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bankNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("phone", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("person", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("moneySource", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bEBank", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bEBankAddress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("guaranty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("kConFeedSubsidy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("kPolicySubsidy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("kPunishAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("kOtherAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("actualPayAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("actualKPunishAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("actualKConFeedSub", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("actualKPolicySub", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("actualKOtherAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farm", ValidateHelper.ON_SAVE);    		
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
     * output prmtbEBank_Changed() method
     */
    public void prmtbEBank_Changed() throws Exception
    {
        System.out.println("prmtbEBank_Changed() Function is executed!");
            txtbEBankAddress.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtbEBank.getData(),"Adress")));


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
        sic.add(new SelectorItemInfo("Fivouchered"));
        sic.add(new SelectorItemInfo("isHasReceivingBill"));
        sic.add(new SelectorItemInfo("isHasPaymentBill"));
        sic.add(new SelectorItemInfo("liquidated"));
    	sic.add(new SelectorItemInfo("Entrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entrys.farm.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entrys.farm.id"));
			sic.add(new SelectorItemInfo("Entrys.farm.name"));
        	sic.add(new SelectorItemInfo("Entrys.farm.number"));
		}
    	sic.add(new SelectorItemInfo("Entrys.inDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entrys.batchContract.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entrys.batchContract.id"));
			sic.add(new SelectorItemInfo("Entrys.batchContract.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entrys.breedData.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entrys.breedData.id"));
			sic.add(new SelectorItemInfo("Entrys.breedData.name"));
        	sic.add(new SelectorItemInfo("Entrys.breedData.number"));
		}
    	sic.add(new SelectorItemInfo("Entrys.batchQty"));
    	sic.add(new SelectorItemInfo("Entrys.minMargin"));
    	sic.add(new SelectorItemInfo("Entrys.status"));
    	sic.add(new SelectorItemInfo("Entrys.singleMargin"));
    	sic.add(new SelectorItemInfo("Entrys.contractQty"));
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
        sic.add(new SelectorItemInfo("payAmount"));
        sic.add(new SelectorItemInfo("auditTime"));
        sic.add(new SelectorItemInfo("auditOpinion"));
        sic.add(new SelectorItemInfo("billStatus"));
        sic.add(new SelectorItemInfo("bizType"));
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
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
        sic.add(new SelectorItemInfo("totalMargin"));
        sic.add(new SelectorItemInfo("enableMargin"));
        sic.add(new SelectorItemInfo("occupyMargin"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("voucherNum.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("voucherNum.id"));
        	sic.add(new SelectorItemInfo("voucherNum.number"));
		}
        sic.add(new SelectorItemInfo("identity"));
        sic.add(new SelectorItemInfo("bankNo"));
        sic.add(new SelectorItemInfo("phone"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("person.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("person.id"));
        	sic.add(new SelectorItemInfo("person.number"));
        	sic.add(new SelectorItemInfo("person.name"));
		}
        sic.add(new SelectorItemInfo("moneySource"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("bEBank.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("bEBank.id"));
        	sic.add(new SelectorItemInfo("bEBank.number"));
        	sic.add(new SelectorItemInfo("bEBank.name"));
		}
        sic.add(new SelectorItemInfo("bEBankAddress"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("guaranty.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("guaranty.id"));
        	sic.add(new SelectorItemInfo("guaranty.number"));
		}
        sic.add(new SelectorItemInfo("kConFeedSubsidy"));
        sic.add(new SelectorItemInfo("kPolicySubsidy"));
        sic.add(new SelectorItemInfo("kPunishAmt"));
        sic.add(new SelectorItemInfo("kOtherAmt"));
        sic.add(new SelectorItemInfo("actualPayAmt"));
        sic.add(new SelectorItemInfo("actualKPunishAmt"));
        sic.add(new SelectorItemInfo("actualKConFeedSub"));
        sic.add(new SelectorItemInfo("actualKPolicySub"));
        sic.add(new SelectorItemInfo("actualKOtherAmt"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("farm.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farm.id"));
        	sic.add(new SelectorItemInfo("farm.number"));
        	sic.add(new SelectorItemInfo("farm.name"));
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
     * output actionNumberSign_actionPerformed method
     */
    public void actionNumberSign_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionNumberSign_actionPerformed(e);
    }
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.basebiz.MaiginBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.basebiz.MaiginBillFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionViewGuaranteeBill_actionPerformed method
     */
    public void actionViewGuaranteeBill_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.basebiz.MaiginBillFactory.getRemoteInstance().viewGuaranteeBill(editData);
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
	public RequestContext prepareActionNumberSign(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionNumberSign(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionNumberSign() {
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
	public RequestContext prepareActionViewGuaranteeBill(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionViewGuaranteeBill() {
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
            innerActionPerformed("eas", AbstractMaiginBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractMaiginBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionViewGuaranteeBill class
     */     
    protected class ActionViewGuaranteeBill extends ItemAction {     
    
        public ActionViewGuaranteeBill()
        {
            this(null);
        }

        public ActionViewGuaranteeBill(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionViewGuaranteeBill.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionViewGuaranteeBill.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionViewGuaranteeBill.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractMaiginBillEditUI.this, "ActionViewGuaranteeBill", "actionViewGuaranteeBill_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.basebiz.client", "MaiginBillEditUI");
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
        return com.kingdee.eas.farm.carnivorous.basebiz.client.MaiginBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.basebiz.MaiginBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.basebiz.MaiginBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.basebiz.MaiginBillInfo();
				if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")).getBoolean("isBizUnit"))
			objectValue.put("company",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")));
 
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/carnivorous/basebiz/MaiginBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.carnivorous.basebiz.app.MaiginBillQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtNumber.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"单据编号"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtpayAmount.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"缴费金额"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtfarmer.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖户"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"公司"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtfarm.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖场"});
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
vo.put("bizType","1");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}