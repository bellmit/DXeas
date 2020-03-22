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
public abstract class AbstractBatchContractBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractBatchContractBillEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisTemplate;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator9;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisInit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contMarginBill;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseRecPrice;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisRecSettled;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane2;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisSetMargin;
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
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contidentity;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontractDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmobileTel;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedType;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontractEndDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarm;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel5;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontractType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contconFeedContract;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contconFeedPolicy;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmAddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contguaranty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsubsidyPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contguaranteeBeginDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contguaranteeEndDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfeedInstance;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contputPolicy;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbasePriceAdjust;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthouse;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcostCenter;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtidentity;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkcontractDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperson;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtmobileTel;
    protected com.kingdee.bos.ctrl.swing.KDComboBox breedType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedData;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfemaleBreedQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contactualBreedDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contactualFemaleQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsettlementPolicy;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpreditRecDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdiffDay;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrecyBeginDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrecyEndDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatch;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmsType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedPrice;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisFeedBig;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contslaughterPoint;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcostObject;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbreedData;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfemaleBreedQty;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkactualBreedDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtactualFemaleQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsettlementPolicy;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkpreditRecDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdiffDay;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkrecyBeginDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkrecyEndDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbatch;
    protected com.kingdee.bos.ctrl.swing.KDComboBox farmsType;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbreedPrice;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtslaughterPoint;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcostObject;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkcontractEndDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contremark;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmarginPolicy;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contenableMargin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstandardMargin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contminMargin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contusedMargin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contunlockMargin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalMargin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoccupyMargin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contactualSingleMargin;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtremark;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtmarginPolicy;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtenableMargin;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtstandardMargin;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtminMargin;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtusedMargin;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtunlockMargin;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalMargin;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoccupyMargin;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtactualSingleMargin;
    protected com.kingdee.bos.ctrl.swing.KDComboBox contractType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtconFeedContract;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtconFeedPolicy;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfarmAddress;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtguaranty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsubsidyPrice;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkguaranteeBeginDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkguaranteeEndDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfeedInstance;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtputPolicy;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbasePriceAdjust;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmthouse;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcostCenter;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtMarginBill;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbaseRecPrice;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtReceiveBillEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtReceiveBillEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtcontractContext;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnRevoke;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnViewGuaranteeBill;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnChangIsFeedBig;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDSeparator newSeparator3;
    protected com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionIsTemplate actionIsTemplate = null;
    protected ActionIsInit actionIsInit = null;
    protected ActionViewGuaranteeBill actionViewGuaranteeBill = null;
    protected ActionRevoke actionRevoke = null;
    protected ActionChangIsFeedBig actionChangIsFeedBig = null;
    /**
     * output class constructor
     */
    public AbstractBatchContractBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractBatchContractBillEditUI.class.getName());
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
        //actionIsTemplate
        this.actionIsTemplate = new ActionIsTemplate(this);
        getActionManager().registerAction("actionIsTemplate", actionIsTemplate);
        this.actionIsTemplate.setExtendProperty("canForewarn", "true");
        this.actionIsTemplate.setExtendProperty("userDefined", "false");
        this.actionIsTemplate.setExtendProperty("isObjectUpdateLock", "false");
         this.actionIsTemplate.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionIsTemplate.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionIsInit
        this.actionIsInit = new ActionIsInit(this);
        getActionManager().registerAction("actionIsInit", actionIsInit);
        this.actionIsInit.setExtendProperty("canForewarn", "true");
        this.actionIsInit.setExtendProperty("userDefined", "false");
        this.actionIsInit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionIsInit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionIsInit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionViewGuaranteeBill
        this.actionViewGuaranteeBill = new ActionViewGuaranteeBill(this);
        getActionManager().registerAction("actionViewGuaranteeBill", actionViewGuaranteeBill);
        this.actionViewGuaranteeBill.setBindWorkFlow(true);
        this.actionViewGuaranteeBill.setExtendProperty("canForewarn", "true");
        this.actionViewGuaranteeBill.setExtendProperty("userDefined", "true");
        this.actionViewGuaranteeBill.setExtendProperty("isObjectUpdateLock", "false");
         this.actionViewGuaranteeBill.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionViewGuaranteeBill.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionViewGuaranteeBill.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionRevoke
        this.actionRevoke = new ActionRevoke(this);
        getActionManager().registerAction("actionRevoke", actionRevoke);
        this.actionRevoke.setBindWorkFlow(true);
        this.actionRevoke.setExtendProperty("canForewarn", "true");
        this.actionRevoke.setExtendProperty("userDefined", "true");
        this.actionRevoke.setExtendProperty("isObjectUpdateLock", "false");
         this.actionRevoke.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionRevoke.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionRevoke.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionChangIsFeedBig
        this.actionChangIsFeedBig = new ActionChangIsFeedBig(this);
        getActionManager().registerAction("actionChangIsFeedBig", actionChangIsFeedBig);
         this.actionChangIsFeedBig.addService(new com.kingdee.eas.framework.client.service.PermissionService());
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
        this.chkisTemplate = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.kDSeparator9 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.chkisInit = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contMarginBill = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseRecPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisRecSettled = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.kDTabbedPane2 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.chkisSetMargin = new com.kingdee.bos.ctrl.swing.KDCheckBox();
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
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contidentity = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcontractDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmobileTel = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbreedType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contcontractEndDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDPanel5 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contcontractType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contconFeedContract = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contconFeedPolicy = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmAddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contguaranty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsubsidyPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contguaranteeBeginDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contguaranteeEndDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfeedInstance = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contputPolicy = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbasePriceAdjust = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthouse = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcostCenter = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtidentity = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkcontractDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtperson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtmobileTel = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.breedType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.contbreedData = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfemaleBreedQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contactualBreedDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contactualFemaleQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsettlementPolicy = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpreditRecDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdiffDay = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrecyBeginDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrecyEndDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbatch = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmsType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbreedPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisFeedBig = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contslaughterPoint = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcostObject = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtbreedData = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtfemaleBreedQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkactualBreedDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtactualFemaleQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtsettlementPolicy = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkpreditRecDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtdiffDay = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkrecyBeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkrecyEndDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtbatch = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.farmsType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtbreedPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtslaughterPoint = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcostObject = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkcontractEndDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtfarmer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtfarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.contremark = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmarginPolicy = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contenableMargin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstandardMargin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contminMargin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contusedMargin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contunlockMargin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalMargin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoccupyMargin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contactualSingleMargin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtremark = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtmarginPolicy = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtenableMargin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtstandardMargin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtminMargin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtusedMargin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtunlockMargin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttotalMargin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtoccupyMargin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtactualSingleMargin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contractType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtconFeedContract = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtconFeedPolicy = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtfarmAddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtguaranty = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtsubsidyPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkguaranteeBeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkguaranteeEndDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtfeedInstance = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtputPolicy = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbasePriceAdjust = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmthouse = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcostCenter = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtMarginBill = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtbaseRecPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtReceiveBillEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.txtcontractContext = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.tBtnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnRevoke = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnViewGuaranteeBill = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnChangIsFeedBig = new com.kingdee.bos.ctrl.swing.KDWorkButton();
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
        this.chkisTemplate.setName("chkisTemplate");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.kDSeparator9.setName("kDSeparator9");
        this.chkisInit.setName("chkisInit");
        this.contMarginBill.setName("contMarginBill");
        this.contbaseRecPrice.setName("contbaseRecPrice");
        this.chkisRecSettled.setName("chkisRecSettled");
        this.kDTabbedPane2.setName("kDTabbedPane2");
        this.chkisSetMargin.setName("chkisSetMargin");
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
        this.kDPanel1.setName("kDPanel1");
        this.contidentity.setName("contidentity");
        this.contcontractDate.setName("contcontractDate");
        this.contperson.setName("contperson");
        this.contmobileTel.setName("contmobileTel");
        this.contbreedType.setName("contbreedType");
        this.kDPanel2.setName("kDPanel2");
        this.contcontractEndDate.setName("contcontractEndDate");
        this.contfarmer.setName("contfarmer");
        this.contfarm.setName("contfarm");
        this.kDPanel5.setName("kDPanel5");
        this.contcontractType.setName("contcontractType");
        this.contconFeedContract.setName("contconFeedContract");
        this.contconFeedPolicy.setName("contconFeedPolicy");
        this.contfarmAddress.setName("contfarmAddress");
        this.contguaranty.setName("contguaranty");
        this.contsubsidyPrice.setName("contsubsidyPrice");
        this.contguaranteeBeginDate.setName("contguaranteeBeginDate");
        this.contguaranteeEndDate.setName("contguaranteeEndDate");
        this.contfeedInstance.setName("contfeedInstance");
        this.contputPolicy.setName("contputPolicy");
        this.contbasePriceAdjust.setName("contbasePriceAdjust");
        this.conthouse.setName("conthouse");
        this.contcostCenter.setName("contcostCenter");
        this.txtidentity.setName("txtidentity");
        this.pkcontractDate.setName("pkcontractDate");
        this.prmtperson.setName("prmtperson");
        this.txtmobileTel.setName("txtmobileTel");
        this.breedType.setName("breedType");
        this.contbreedData.setName("contbreedData");
        this.contfemaleBreedQty.setName("contfemaleBreedQty");
        this.contactualBreedDate.setName("contactualBreedDate");
        this.contactualFemaleQty.setName("contactualFemaleQty");
        this.contsettlementPolicy.setName("contsettlementPolicy");
        this.contpreditRecDate.setName("contpreditRecDate");
        this.contdiffDay.setName("contdiffDay");
        this.contrecyBeginDate.setName("contrecyBeginDate");
        this.contrecyEndDate.setName("contrecyEndDate");
        this.contbatch.setName("contbatch");
        this.contfarmsType.setName("contfarmsType");
        this.contbreedPrice.setName("contbreedPrice");
        this.chkisFeedBig.setName("chkisFeedBig");
        this.contslaughterPoint.setName("contslaughterPoint");
        this.contcostObject.setName("contcostObject");
        this.prmtbreedData.setName("prmtbreedData");
        this.txtfemaleBreedQty.setName("txtfemaleBreedQty");
        this.pkactualBreedDate.setName("pkactualBreedDate");
        this.txtactualFemaleQty.setName("txtactualFemaleQty");
        this.prmtsettlementPolicy.setName("prmtsettlementPolicy");
        this.pkpreditRecDate.setName("pkpreditRecDate");
        this.txtdiffDay.setName("txtdiffDay");
        this.pkrecyBeginDate.setName("pkrecyBeginDate");
        this.pkrecyEndDate.setName("pkrecyEndDate");
        this.prmtbatch.setName("prmtbatch");
        this.farmsType.setName("farmsType");
        this.txtbreedPrice.setName("txtbreedPrice");
        this.prmtslaughterPoint.setName("prmtslaughterPoint");
        this.prmtcostObject.setName("prmtcostObject");
        this.pkcontractEndDate.setName("pkcontractEndDate");
        this.prmtfarmer.setName("prmtfarmer");
        this.prmtfarm.setName("prmtfarm");
        this.contremark.setName("contremark");
        this.contmarginPolicy.setName("contmarginPolicy");
        this.contenableMargin.setName("contenableMargin");
        this.contstandardMargin.setName("contstandardMargin");
        this.contminMargin.setName("contminMargin");
        this.contusedMargin.setName("contusedMargin");
        this.contunlockMargin.setName("contunlockMargin");
        this.conttotalMargin.setName("conttotalMargin");
        this.contoccupyMargin.setName("contoccupyMargin");
        this.contactualSingleMargin.setName("contactualSingleMargin");
        this.txtremark.setName("txtremark");
        this.prmtmarginPolicy.setName("prmtmarginPolicy");
        this.txtenableMargin.setName("txtenableMargin");
        this.txtstandardMargin.setName("txtstandardMargin");
        this.txtminMargin.setName("txtminMargin");
        this.txtusedMargin.setName("txtusedMargin");
        this.txtunlockMargin.setName("txtunlockMargin");
        this.txttotalMargin.setName("txttotalMargin");
        this.txtoccupyMargin.setName("txtoccupyMargin");
        this.txtactualSingleMargin.setName("txtactualSingleMargin");
        this.contractType.setName("contractType");
        this.prmtconFeedContract.setName("prmtconFeedContract");
        this.prmtconFeedPolicy.setName("prmtconFeedPolicy");
        this.txtfarmAddress.setName("txtfarmAddress");
        this.prmtguaranty.setName("prmtguaranty");
        this.txtsubsidyPrice.setName("txtsubsidyPrice");
        this.pkguaranteeBeginDate.setName("pkguaranteeBeginDate");
        this.pkguaranteeEndDate.setName("pkguaranteeEndDate");
        this.txtfeedInstance.setName("txtfeedInstance");
        this.prmtputPolicy.setName("prmtputPolicy");
        this.prmtbasePriceAdjust.setName("prmtbasePriceAdjust");
        this.prmthouse.setName("prmthouse");
        this.prmtcostCenter.setName("prmtcostCenter");
        this.prmtMarginBill.setName("prmtMarginBill");
        this.txtbaseRecPrice.setName("txtbaseRecPrice");
        this.kDPanel3.setName("kDPanel3");
        this.kDPanel4.setName("kDPanel4");
        this.kdtReceiveBillEntry.setName("kdtReceiveBillEntry");
        this.txtcontractContext.setName("txtcontractContext");
        this.tBtnAudit.setName("tBtnAudit");
        this.tBtnUnAudit.setName("tBtnUnAudit");
        this.btnRevoke.setName("btnRevoke");
        this.btnViewGuaranteeBill.setName("btnViewGuaranteeBill");
        this.btnChangIsFeedBig.setName("btnChangIsFeedBig");
        this.mBtnAudit.setName("mBtnAudit");
        this.mBtnUnAudit.setName("mBtnUnAudit");
        this.newSeparator3.setName("newSeparator3");
        // CoreUI		
        this.btnCopy.setVisible(false);		
        this.btnCancelCancel.setVisible(true);		
        this.btnCancelCancel.setEnabled(true);		
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
        // chkisTemplate		
        this.chkisTemplate.setText(resHelper.getString("chkisTemplate.text"));		
        this.chkisTemplate.setHorizontalAlignment(2);		
        this.chkisTemplate.setVisible(false);
        // kDTabbedPane1
        // kDSeparator9
        // chkisInit		
        this.chkisInit.setText(resHelper.getString("chkisInit.text"));		
        this.chkisInit.setHorizontalAlignment(2);		
        this.chkisInit.setVisible(false);
        // contMarginBill		
        this.contMarginBill.setBoundLabelText(resHelper.getString("contMarginBill.boundLabelText"));		
        this.contMarginBill.setBoundLabelLength(100);		
        this.contMarginBill.setBoundLabelUnderline(true);		
        this.contMarginBill.setVisible(false);
        // contbaseRecPrice		
        this.contbaseRecPrice.setBoundLabelText(resHelper.getString("contbaseRecPrice.boundLabelText"));		
        this.contbaseRecPrice.setBoundLabelLength(100);		
        this.contbaseRecPrice.setBoundLabelUnderline(true);		
        this.contbaseRecPrice.setVisible(false);
        // chkisRecSettled		
        this.chkisRecSettled.setText(resHelper.getString("chkisRecSettled.text"));		
        this.chkisRecSettled.setVisible(true);		
        this.chkisRecSettled.setHorizontalAlignment(2);		
        this.chkisRecSettled.setEnabled(false);
        // kDTabbedPane2		
        this.kDTabbedPane2.setVisible(false);
        // chkisSetMargin		
        this.chkisSetMargin.setText(resHelper.getString("chkisSetMargin.text"));		
        this.chkisSetMargin.setVisible(true);		
        this.chkisSetMargin.setHorizontalAlignment(2);
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
        this.txtNumber.setRequired(false);		
        this.txtNumber.setEnabled(false);
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
        // kDPanel1
        // contidentity		
        this.contidentity.setBoundLabelText(resHelper.getString("contidentity.boundLabelText"));		
        this.contidentity.setBoundLabelLength(100);		
        this.contidentity.setBoundLabelUnderline(true);		
        this.contidentity.setVisible(true);
        // contcontractDate		
        this.contcontractDate.setBoundLabelText(resHelper.getString("contcontractDate.boundLabelText"));		
        this.contcontractDate.setBoundLabelLength(100);		
        this.contcontractDate.setBoundLabelUnderline(true);		
        this.contcontractDate.setVisible(true);
        // contperson		
        this.contperson.setBoundLabelText(resHelper.getString("contperson.boundLabelText"));		
        this.contperson.setBoundLabelLength(100);		
        this.contperson.setBoundLabelUnderline(true);		
        this.contperson.setVisible(true);
        // contmobileTel		
        this.contmobileTel.setBoundLabelText(resHelper.getString("contmobileTel.boundLabelText"));		
        this.contmobileTel.setBoundLabelLength(100);		
        this.contmobileTel.setBoundLabelUnderline(true);		
        this.contmobileTel.setVisible(true);
        // contbreedType		
        this.contbreedType.setBoundLabelText(resHelper.getString("contbreedType.boundLabelText"));		
        this.contbreedType.setBoundLabelLength(100);		
        this.contbreedType.setBoundLabelUnderline(true);		
        this.contbreedType.setVisible(true);
        // kDPanel2		
        this.kDPanel2.setBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)));
        // contcontractEndDate		
        this.contcontractEndDate.setBoundLabelText(resHelper.getString("contcontractEndDate.boundLabelText"));		
        this.contcontractEndDate.setBoundLabelLength(100);		
        this.contcontractEndDate.setBoundLabelUnderline(true);		
        this.contcontractEndDate.setVisible(true);
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
        // kDPanel5		
        this.kDPanel5.setBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)));
        // contcontractType		
        this.contcontractType.setBoundLabelText(resHelper.getString("contcontractType.boundLabelText"));		
        this.contcontractType.setBoundLabelLength(100);		
        this.contcontractType.setBoundLabelUnderline(true);		
        this.contcontractType.setVisible(true);
        // contconFeedContract		
        this.contconFeedContract.setBoundLabelText(resHelper.getString("contconFeedContract.boundLabelText"));		
        this.contconFeedContract.setBoundLabelLength(100);		
        this.contconFeedContract.setBoundLabelUnderline(true);		
        this.contconFeedContract.setVisible(true);
        // contconFeedPolicy		
        this.contconFeedPolicy.setBoundLabelText(resHelper.getString("contconFeedPolicy.boundLabelText"));		
        this.contconFeedPolicy.setBoundLabelLength(100);		
        this.contconFeedPolicy.setBoundLabelUnderline(true);		
        this.contconFeedPolicy.setVisible(true);
        // contfarmAddress		
        this.contfarmAddress.setBoundLabelText(resHelper.getString("contfarmAddress.boundLabelText"));		
        this.contfarmAddress.setBoundLabelLength(100);		
        this.contfarmAddress.setBoundLabelUnderline(true);		
        this.contfarmAddress.setVisible(true);
        // contguaranty		
        this.contguaranty.setBoundLabelText(resHelper.getString("contguaranty.boundLabelText"));		
        this.contguaranty.setBoundLabelLength(100);		
        this.contguaranty.setBoundLabelUnderline(true);		
        this.contguaranty.setVisible(true);
        // contsubsidyPrice		
        this.contsubsidyPrice.setBoundLabelText(resHelper.getString("contsubsidyPrice.boundLabelText"));		
        this.contsubsidyPrice.setBoundLabelLength(100);		
        this.contsubsidyPrice.setBoundLabelUnderline(true);		
        this.contsubsidyPrice.setVisible(true);
        // contguaranteeBeginDate		
        this.contguaranteeBeginDate.setBoundLabelText(resHelper.getString("contguaranteeBeginDate.boundLabelText"));		
        this.contguaranteeBeginDate.setBoundLabelLength(100);		
        this.contguaranteeBeginDate.setBoundLabelUnderline(true);		
        this.contguaranteeBeginDate.setVisible(true);
        // contguaranteeEndDate		
        this.contguaranteeEndDate.setBoundLabelText(resHelper.getString("contguaranteeEndDate.boundLabelText"));		
        this.contguaranteeEndDate.setBoundLabelLength(100);		
        this.contguaranteeEndDate.setBoundLabelUnderline(true);		
        this.contguaranteeEndDate.setVisible(true);
        // contfeedInstance		
        this.contfeedInstance.setBoundLabelText(resHelper.getString("contfeedInstance.boundLabelText"));		
        this.contfeedInstance.setBoundLabelLength(100);		
        this.contfeedInstance.setBoundLabelUnderline(true);		
        this.contfeedInstance.setVisible(true);
        // contputPolicy		
        this.contputPolicy.setBoundLabelText(resHelper.getString("contputPolicy.boundLabelText"));		
        this.contputPolicy.setBoundLabelLength(100);		
        this.contputPolicy.setBoundLabelUnderline(true);		
        this.contputPolicy.setVisible(true);
        // contbasePriceAdjust		
        this.contbasePriceAdjust.setBoundLabelText(resHelper.getString("contbasePriceAdjust.boundLabelText"));		
        this.contbasePriceAdjust.setBoundLabelLength(100);		
        this.contbasePriceAdjust.setBoundLabelUnderline(true);		
        this.contbasePriceAdjust.setVisible(true);
        // conthouse		
        this.conthouse.setBoundLabelText(resHelper.getString("conthouse.boundLabelText"));		
        this.conthouse.setBoundLabelLength(100);		
        this.conthouse.setBoundLabelUnderline(true);		
        this.conthouse.setVisible(true);
        // contcostCenter		
        this.contcostCenter.setBoundLabelText(resHelper.getString("contcostCenter.boundLabelText"));		
        this.contcostCenter.setBoundLabelLength(100);		
        this.contcostCenter.setBoundLabelUnderline(true);		
        this.contcostCenter.setVisible(true);
        // txtidentity		
        this.txtidentity.setHorizontalAlignment(2);		
        this.txtidentity.setMaxLength(80);		
        this.txtidentity.setRequired(false);		
        this.txtidentity.setEnabled(false);
        // pkcontractDate		
        this.pkcontractDate.setRequired(false);
        // prmtperson		
        this.prmtperson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtperson.setEditable(true);		
        this.prmtperson.setDisplayFormat("$name$");		
        this.prmtperson.setEditFormat("$number$");		
        this.prmtperson.setCommitFormat("$number$");		
        this.prmtperson.setRequired(false);
        // txtmobileTel		
        this.txtmobileTel.setHorizontalAlignment(2);		
        this.txtmobileTel.setMaxLength(80);		
        this.txtmobileTel.setRequired(false);		
        this.txtmobileTel.setEnabled(false);
        // breedType		
        this.breedType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.StockingTypeEnum").toArray());		
        this.breedType.setRequired(true);
        // contbreedData		
        this.contbreedData.setBoundLabelText(resHelper.getString("contbreedData.boundLabelText"));		
        this.contbreedData.setBoundLabelLength(100);		
        this.contbreedData.setBoundLabelUnderline(true);		
        this.contbreedData.setVisible(true);
        // contfemaleBreedQty		
        this.contfemaleBreedQty.setBoundLabelText(resHelper.getString("contfemaleBreedQty.boundLabelText"));		
        this.contfemaleBreedQty.setBoundLabelLength(100);		
        this.contfemaleBreedQty.setBoundLabelUnderline(true);		
        this.contfemaleBreedQty.setVisible(true);
        // contactualBreedDate		
        this.contactualBreedDate.setBoundLabelText(resHelper.getString("contactualBreedDate.boundLabelText"));		
        this.contactualBreedDate.setBoundLabelLength(100);		
        this.contactualBreedDate.setBoundLabelUnderline(true);		
        this.contactualBreedDate.setVisible(true);
        // contactualFemaleQty		
        this.contactualFemaleQty.setBoundLabelText(resHelper.getString("contactualFemaleQty.boundLabelText"));		
        this.contactualFemaleQty.setBoundLabelLength(100);		
        this.contactualFemaleQty.setBoundLabelUnderline(true);		
        this.contactualFemaleQty.setVisible(true);
        // contsettlementPolicy		
        this.contsettlementPolicy.setBoundLabelText(resHelper.getString("contsettlementPolicy.boundLabelText"));		
        this.contsettlementPolicy.setBoundLabelLength(100);		
        this.contsettlementPolicy.setBoundLabelUnderline(true);		
        this.contsettlementPolicy.setVisible(true);
        // contpreditRecDate		
        this.contpreditRecDate.setBoundLabelText(resHelper.getString("contpreditRecDate.boundLabelText"));		
        this.contpreditRecDate.setBoundLabelLength(100);		
        this.contpreditRecDate.setBoundLabelUnderline(true);		
        this.contpreditRecDate.setVisible(true);
        // contdiffDay		
        this.contdiffDay.setBoundLabelText(resHelper.getString("contdiffDay.boundLabelText"));		
        this.contdiffDay.setBoundLabelLength(100);		
        this.contdiffDay.setBoundLabelUnderline(true);		
        this.contdiffDay.setVisible(true);
        // contrecyBeginDate		
        this.contrecyBeginDate.setBoundLabelText(resHelper.getString("contrecyBeginDate.boundLabelText"));		
        this.contrecyBeginDate.setBoundLabelLength(100);		
        this.contrecyBeginDate.setBoundLabelUnderline(true);		
        this.contrecyBeginDate.setVisible(true);
        // contrecyEndDate		
        this.contrecyEndDate.setBoundLabelText(resHelper.getString("contrecyEndDate.boundLabelText"));		
        this.contrecyEndDate.setBoundLabelLength(100);		
        this.contrecyEndDate.setBoundLabelUnderline(true);		
        this.contrecyEndDate.setVisible(true);
        // contbatch		
        this.contbatch.setBoundLabelText(resHelper.getString("contbatch.boundLabelText"));		
        this.contbatch.setBoundLabelLength(100);		
        this.contbatch.setBoundLabelUnderline(true);		
        this.contbatch.setVisible(true);
        // contfarmsType		
        this.contfarmsType.setBoundLabelText(resHelper.getString("contfarmsType.boundLabelText"));		
        this.contfarmsType.setBoundLabelLength(100);		
        this.contfarmsType.setBoundLabelUnderline(true);		
        this.contfarmsType.setVisible(true);
        // contbreedPrice		
        this.contbreedPrice.setBoundLabelText(resHelper.getString("contbreedPrice.boundLabelText"));		
        this.contbreedPrice.setBoundLabelLength(100);		
        this.contbreedPrice.setBoundLabelUnderline(true);		
        this.contbreedPrice.setVisible(true);
        // chkisFeedBig		
        this.chkisFeedBig.setText(resHelper.getString("chkisFeedBig.text"));		
        this.chkisFeedBig.setVisible(false);		
        this.chkisFeedBig.setHorizontalAlignment(2);
        // contslaughterPoint		
        this.contslaughterPoint.setBoundLabelText(resHelper.getString("contslaughterPoint.boundLabelText"));		
        this.contslaughterPoint.setBoundLabelLength(100);		
        this.contslaughterPoint.setBoundLabelUnderline(true);		
        this.contslaughterPoint.setVisible(true);
        // contcostObject		
        this.contcostObject.setBoundLabelText(resHelper.getString("contcostObject.boundLabelText"));		
        this.contcostObject.setBoundLabelLength(100);		
        this.contcostObject.setBoundLabelUnderline(true);		
        this.contcostObject.setVisible(true);
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
					
        // txtfemaleBreedQty		
        this.txtfemaleBreedQty.setHorizontalAlignment(2);		
        this.txtfemaleBreedQty.setDataType(1);		
        this.txtfemaleBreedQty.setSupportedEmpty(true);		
        this.txtfemaleBreedQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfemaleBreedQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfemaleBreedQty.setPrecision(4);		
        this.txtfemaleBreedQty.setRequired(false);
        // pkactualBreedDate		
        this.pkactualBreedDate.setRequired(false);		
        this.pkactualBreedDate.setEnabled(false);
        // txtactualFemaleQty		
        this.txtactualFemaleQty.setHorizontalAlignment(2);		
        this.txtactualFemaleQty.setDataType(1);		
        this.txtactualFemaleQty.setSupportedEmpty(true);		
        this.txtactualFemaleQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtactualFemaleQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtactualFemaleQty.setPrecision(4);		
        this.txtactualFemaleQty.setRequired(false);		
        this.txtactualFemaleQty.setEnabled(false);
        // prmtsettlementPolicy		
        this.prmtsettlementPolicy.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.SettlePolicyQuery");		
        this.prmtsettlementPolicy.setEditable(true);		
        this.prmtsettlementPolicy.setDisplayFormat("$name$");		
        this.prmtsettlementPolicy.setEditFormat("$number$");		
        this.prmtsettlementPolicy.setCommitFormat("$number$");		
        this.prmtsettlementPolicy.setRequired(true);
        		prmtsettlementPolicy.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.SettlePolicyListUI prmtsettlementPolicy_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtsettlementPolicy_F7ListUI == null) {
					try {
						prmtsettlementPolicy_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.SettlePolicyListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtsettlementPolicy_F7ListUI));
					prmtsettlementPolicy_F7ListUI.setF7Use(true,ctx);
					prmtsettlementPolicy.setSelector(prmtsettlementPolicy_F7ListUI);
				}
			}
		});
					
        // pkpreditRecDate		
        this.pkpreditRecDate.setRequired(false);
        // txtdiffDay		
        this.txtdiffDay.setHorizontalAlignment(2);		
        this.txtdiffDay.setDataType(0);		
        this.txtdiffDay.setSupportedEmpty(true);		
        this.txtdiffDay.setRequired(false);
        // pkrecyBeginDate		
        this.pkrecyBeginDate.setRequired(false);		
        this.pkrecyBeginDate.setEnabled(false);
        // pkrecyEndDate		
        this.pkrecyEndDate.setRequired(false);		
        this.pkrecyEndDate.setEnabled(false);
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
					
        // farmsType		
        this.farmsType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.FarmsType").toArray());		
        this.farmsType.setRequired(false);		
        this.farmsType.setEnabled(false);
        // txtbreedPrice		
        this.txtbreedPrice.setHorizontalAlignment(2);		
        this.txtbreedPrice.setDataType(1);		
        this.txtbreedPrice.setSupportedEmpty(true);		
        this.txtbreedPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbreedPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbreedPrice.setPrecision(4);		
        this.txtbreedPrice.setRequired(false);
        // prmtslaughterPoint		
        this.prmtslaughterPoint.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FreightCalPointQuery");		
        this.prmtslaughterPoint.setVisible(true);		
        this.prmtslaughterPoint.setEditable(true);		
        this.prmtslaughterPoint.setDisplayFormat("$name$");		
        this.prmtslaughterPoint.setEditFormat("$number$");		
        this.prmtslaughterPoint.setCommitFormat("$number$");		
        this.prmtslaughterPoint.setRequired(false);
        		EntityViewInfo eviprmtslaughterPoint = new EntityViewInfo ();
		eviprmtslaughterPoint.setFilter(com.kingdee.eas.framework.FrameWorkUtils.getF7FilterInfoByAuthorizedOrg(com.kingdee.eas.basedata.org.OrgType.getEnum("Company"),"FICompany.id"));
		prmtslaughterPoint.setEntityViewInfo(eviprmtslaughterPoint);
					
        // prmtcostObject		
        this.prmtcostObject.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");		
        this.prmtcostObject.setVisible(true);		
        this.prmtcostObject.setEditable(true);		
        this.prmtcostObject.setDisplayFormat("$name$");		
        this.prmtcostObject.setEditFormat("$number$");		
        this.prmtcostObject.setCommitFormat("$number$");		
        this.prmtcostObject.setRequired(false);
        // pkcontractEndDate		
        this.pkcontractEndDate.setRequired(false);
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

        // contremark		
        this.contremark.setBoundLabelText(resHelper.getString("contremark.boundLabelText"));		
        this.contremark.setBoundLabelLength(100);		
        this.contremark.setBoundLabelUnderline(true);		
        this.contremark.setVisible(true);
        // contmarginPolicy		
        this.contmarginPolicy.setBoundLabelText(resHelper.getString("contmarginPolicy.boundLabelText"));		
        this.contmarginPolicy.setBoundLabelLength(100);		
        this.contmarginPolicy.setBoundLabelUnderline(true);		
        this.contmarginPolicy.setVisible(true);
        // contenableMargin		
        this.contenableMargin.setBoundLabelText(resHelper.getString("contenableMargin.boundLabelText"));		
        this.contenableMargin.setBoundLabelLength(100);		
        this.contenableMargin.setBoundLabelUnderline(true);		
        this.contenableMargin.setVisible(true);
        // contstandardMargin		
        this.contstandardMargin.setBoundLabelText(resHelper.getString("contstandardMargin.boundLabelText"));		
        this.contstandardMargin.setBoundLabelLength(100);		
        this.contstandardMargin.setBoundLabelUnderline(true);		
        this.contstandardMargin.setVisible(true);
        // contminMargin		
        this.contminMargin.setBoundLabelText(resHelper.getString("contminMargin.boundLabelText"));		
        this.contminMargin.setBoundLabelLength(100);		
        this.contminMargin.setBoundLabelUnderline(true);		
        this.contminMargin.setVisible(true);
        // contusedMargin		
        this.contusedMargin.setBoundLabelText(resHelper.getString("contusedMargin.boundLabelText"));		
        this.contusedMargin.setBoundLabelLength(100);		
        this.contusedMargin.setBoundLabelUnderline(true);		
        this.contusedMargin.setVisible(true);
        // contunlockMargin		
        this.contunlockMargin.setBoundLabelText(resHelper.getString("contunlockMargin.boundLabelText"));		
        this.contunlockMargin.setBoundLabelLength(100);		
        this.contunlockMargin.setBoundLabelUnderline(true);		
        this.contunlockMargin.setVisible(true);
        // conttotalMargin		
        this.conttotalMargin.setBoundLabelText(resHelper.getString("conttotalMargin.boundLabelText"));		
        this.conttotalMargin.setBoundLabelLength(100);		
        this.conttotalMargin.setBoundLabelUnderline(true);		
        this.conttotalMargin.setVisible(true);
        // contoccupyMargin		
        this.contoccupyMargin.setBoundLabelText(resHelper.getString("contoccupyMargin.boundLabelText"));		
        this.contoccupyMargin.setBoundLabelLength(100);		
        this.contoccupyMargin.setBoundLabelUnderline(true);		
        this.contoccupyMargin.setVisible(true);
        // contactualSingleMargin		
        this.contactualSingleMargin.setBoundLabelText(resHelper.getString("contactualSingleMargin.boundLabelText"));		
        this.contactualSingleMargin.setBoundLabelLength(100);		
        this.contactualSingleMargin.setBoundLabelUnderline(true);		
        this.contactualSingleMargin.setVisible(true);
        // txtremark		
        this.txtremark.setHorizontalAlignment(2);		
        this.txtremark.setMaxLength(100);		
        this.txtremark.setRequired(false);
        // prmtmarginPolicy		
        this.prmtmarginPolicy.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.MarginPolicyQuery");		
        this.prmtmarginPolicy.setEditable(true);		
        this.prmtmarginPolicy.setDisplayFormat("$name$");		
        this.prmtmarginPolicy.setEditFormat("$number$");		
        this.prmtmarginPolicy.setCommitFormat("$number$");		
        this.prmtmarginPolicy.setRequired(false);		
        this.prmtmarginPolicy.setLabelLength(70);
        		EntityViewInfo eviprmtmarginPolicy = new EntityViewInfo ();
		eviprmtmarginPolicy.setFilter(com.kingdee.eas.framework.FrameWorkUtils.getF7FilterInfoByAuthorizedOrg(com.kingdee.eas.basedata.org.OrgType.getEnum("Company"),"FICompany.id"));
		prmtmarginPolicy.setEntityViewInfo(eviprmtmarginPolicy);
					
        		prmtmarginPolicy.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.MarginPolicyListUI prmtmarginPolicy_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtmarginPolicy_F7ListUI == null) {
					try {
						prmtmarginPolicy_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.MarginPolicyListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtmarginPolicy_F7ListUI));
					prmtmarginPolicy_F7ListUI.setF7Use(true,ctx);
					prmtmarginPolicy.setSelector(prmtmarginPolicy_F7ListUI);
				}
			}
		});
					
        // txtenableMargin		
        this.txtenableMargin.setHorizontalAlignment(2);		
        this.txtenableMargin.setDataType(1);		
        this.txtenableMargin.setSupportedEmpty(true);		
        this.txtenableMargin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtenableMargin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtenableMargin.setPrecision(2);		
        this.txtenableMargin.setRequired(false);		
        this.txtenableMargin.setEnabled(false);
        // txtstandardMargin		
        this.txtstandardMargin.setHorizontalAlignment(2);		
        this.txtstandardMargin.setDataType(1);		
        this.txtstandardMargin.setSupportedEmpty(true);		
        this.txtstandardMargin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtstandardMargin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtstandardMargin.setPrecision(2);		
        this.txtstandardMargin.setRequired(false);		
        this.txtstandardMargin.setEnabled(false);
        // txtminMargin		
        this.txtminMargin.setHorizontalAlignment(2);		
        this.txtminMargin.setDataType(1);		
        this.txtminMargin.setSupportedEmpty(true);		
        this.txtminMargin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtminMargin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtminMargin.setPrecision(2);		
        this.txtminMargin.setRequired(false);		
        this.txtminMargin.setEnabled(false);
        // txtusedMargin		
        this.txtusedMargin.setHorizontalAlignment(2);		
        this.txtusedMargin.setDataType(1);		
        this.txtusedMargin.setSupportedEmpty(true);		
        this.txtusedMargin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtusedMargin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtusedMargin.setPrecision(2);		
        this.txtusedMargin.setRequired(false);
        // txtunlockMargin		
        this.txtunlockMargin.setHorizontalAlignment(2);		
        this.txtunlockMargin.setDataType(1);		
        this.txtunlockMargin.setSupportedEmpty(true);		
        this.txtunlockMargin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtunlockMargin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtunlockMargin.setPrecision(2);		
        this.txtunlockMargin.setRequired(false);		
        this.txtunlockMargin.setEnabled(false);
        // txttotalMargin		
        this.txttotalMargin.setHorizontalAlignment(2);		
        this.txttotalMargin.setDataType(1);		
        this.txttotalMargin.setSupportedEmpty(true);		
        this.txttotalMargin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttotalMargin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttotalMargin.setPrecision(2);		
        this.txttotalMargin.setRequired(false);		
        this.txttotalMargin.setEnabled(false);
        // txtoccupyMargin		
        this.txtoccupyMargin.setHorizontalAlignment(2);		
        this.txtoccupyMargin.setDataType(1);		
        this.txtoccupyMargin.setSupportedEmpty(true);		
        this.txtoccupyMargin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtoccupyMargin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtoccupyMargin.setPrecision(2);		
        this.txtoccupyMargin.setRequired(false);		
        this.txtoccupyMargin.setEnabled(false);
        // txtactualSingleMargin		
        this.txtactualSingleMargin.setHorizontalAlignment(2);		
        this.txtactualSingleMargin.setDataType(1);		
        this.txtactualSingleMargin.setSupportedEmpty(true);		
        this.txtactualSingleMargin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtactualSingleMargin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtactualSingleMargin.setPrecision(2);		
        this.txtactualSingleMargin.setRequired(false);		
        this.txtactualSingleMargin.setEnabled(false);
        // contractType		
        this.contractType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.feedbiz.ContractType").toArray());		
        this.contractType.setRequired(false);
        // prmtconFeedContract		
        this.prmtconFeedContract.setQueryInfo("com.kingdee.eas.farm.carnivorous.feedbiz.app.ConFeedContractQuery");		
        this.prmtconFeedContract.setEditable(true);		
        this.prmtconFeedContract.setDisplayFormat("$number$");		
        this.prmtconFeedContract.setEditFormat("$number$");		
        this.prmtconFeedContract.setCommitFormat("$number$");		
        this.prmtconFeedContract.setRequired(false);
        // prmtconFeedPolicy		
        this.prmtconFeedPolicy.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.ConFeedPolicyQuery");		
        this.prmtconFeedPolicy.setEditable(true);		
        this.prmtconFeedPolicy.setDisplayFormat("$name$");		
        this.prmtconFeedPolicy.setEditFormat("$number$");		
        this.prmtconFeedPolicy.setCommitFormat("$number$");		
        this.prmtconFeedPolicy.setRequired(false);		
        this.prmtconFeedPolicy.setEnabled(false);
        		EntityViewInfo eviprmtconFeedPolicy = new EntityViewInfo ();
		eviprmtconFeedPolicy.setFilter(com.kingdee.eas.framework.FrameWorkUtils.getF7FilterInfoByAuthorizedOrg(com.kingdee.eas.basedata.org.OrgType.getEnum("Company"),"FICompany.id"));
		prmtconFeedPolicy.setEntityViewInfo(eviprmtconFeedPolicy);
					
        		prmtconFeedPolicy.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.ConFeedPolicyListUI prmtconFeedPolicy_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtconFeedPolicy_F7ListUI == null) {
					try {
						prmtconFeedPolicy_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.ConFeedPolicyListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtconFeedPolicy_F7ListUI));
					prmtconFeedPolicy_F7ListUI.setF7Use(true,ctx);
					prmtconFeedPolicy.setSelector(prmtconFeedPolicy_F7ListUI);
				}
			}
		});
					
        // txtfarmAddress		
        this.txtfarmAddress.setHorizontalAlignment(2);		
        this.txtfarmAddress.setMaxLength(80);		
        this.txtfarmAddress.setRequired(false);		
        this.txtfarmAddress.setEnabled(false);
        // prmtguaranty		
        this.prmtguaranty.setQueryInfo("com.kingdee.eas.farm.carnivorous.basebiz.app.FarmerGuaranteeBillQuery");		
        this.prmtguaranty.setVisible(true);		
        this.prmtguaranty.setEditable(true);		
        this.prmtguaranty.setDisplayFormat("$number$");		
        this.prmtguaranty.setEditFormat("$number$");		
        this.prmtguaranty.setCommitFormat("$number$");		
        this.prmtguaranty.setRequired(false);
        		EntityViewInfo eviprmtguaranty = new EntityViewInfo ();
		eviprmtguaranty.setFilter(com.kingdee.eas.framework.FrameWorkUtils.getF7FilterInfoByAuthorizedOrg(com.kingdee.eas.basedata.org.OrgType.getEnum("Company"),"FICompany.id"));
		prmtguaranty.setEntityViewInfo(eviprmtguaranty);
					
        prmtguaranty.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtguaranty_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtsubsidyPrice		
        this.txtsubsidyPrice.setVisible(true);		
        this.txtsubsidyPrice.setHorizontalAlignment(2);		
        this.txtsubsidyPrice.setDataType(1);		
        this.txtsubsidyPrice.setSupportedEmpty(true);		
        this.txtsubsidyPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsubsidyPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsubsidyPrice.setPrecision(4);		
        this.txtsubsidyPrice.setRequired(false);		
        this.txtsubsidyPrice.setEnabled(false);
        // pkguaranteeBeginDate		
        this.pkguaranteeBeginDate.setVisible(true);		
        this.pkguaranteeBeginDate.setRequired(false);		
        this.pkguaranteeBeginDate.setEnabled(false);
        // pkguaranteeEndDate		
        this.pkguaranteeEndDate.setVisible(true);		
        this.pkguaranteeEndDate.setRequired(false);		
        this.pkguaranteeEndDate.setEnabled(false);
        // txtfeedInstance		
        this.txtfeedInstance.setVisible(true);		
        this.txtfeedInstance.setHorizontalAlignment(2);		
        this.txtfeedInstance.setDataType(1);		
        this.txtfeedInstance.setSupportedEmpty(true);		
        this.txtfeedInstance.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfeedInstance.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfeedInstance.setPrecision(10);		
        this.txtfeedInstance.setRequired(false);
        // prmtputPolicy		
        this.prmtputPolicy.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.InvestmentPolicyChickenQuery");		
        this.prmtputPolicy.setVisible(true);		
        this.prmtputPolicy.setEditable(true);		
        this.prmtputPolicy.setDisplayFormat("$name$");		
        this.prmtputPolicy.setEditFormat("$number$");		
        this.prmtputPolicy.setCommitFormat("$number$");		
        this.prmtputPolicy.setRequired(false);
        // prmtbasePriceAdjust		
        this.prmtbasePriceAdjust.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.BasePriceAdjustPolicyQuery");		
        this.prmtbasePriceAdjust.setVisible(true);		
        this.prmtbasePriceAdjust.setEditable(true);		
        this.prmtbasePriceAdjust.setDisplayFormat("$number$");		
        this.prmtbasePriceAdjust.setEditFormat("$number$");		
        this.prmtbasePriceAdjust.setCommitFormat("$number$");		
        this.prmtbasePriceAdjust.setRequired(false);
        
    	this.prmthouse.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.carviousFarmHouseQuery");		
		this.prmthouse.setVisible(true);		
		this.prmthouse.setEditable(true);		
		this.prmthouse.setDisplayFormat("$name$");		
		this.prmthouse.setEditFormat("$number$");		
		this.prmthouse.setCommitFormat("$number$");		
		this.prmthouse.setRequired(false);
        
//        // prmthouse		
//        this.prmthouse.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.ConFeedPolicyQuery");		
//        this.prmthouse.setVisible(true);		
//        this.prmthouse.setEditable(true);		
//        this.prmthouse.setDisplayFormat("$name$");		
//        this.prmthouse.setEditFormat("$number$");		
//        this.prmthouse.setCommitFormat("$number$");		
//        this.prmthouse.setRequired(false);
//        		EntityViewInfo eviprmthouse = new EntityViewInfo ();
//		eviprmthouse.setFilter(com.kingdee.eas.framework.FrameWorkUtils.getF7FilterInfoByAuthorizedOrg(com.kingdee.eas.basedata.org.OrgType.getEnum("Company"),"FICompany.id"));
//		prmthouse.setEntityViewInfo(eviprmthouse);
//					
//        		prmthouse.addSelectorListener(new SelectorListener() {
//			com.kingdee.eas.farm.carnivorous.basedata.client.ConFeedPolicyListUI prmthouse_F7ListUI = null;
//			public void willShow(SelectorEvent e) {
//				if (prmthouse_F7ListUI == null) {
//					try {
//						prmthouse_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.ConFeedPolicyListUI();
//					} catch (Exception e1) {
//						e1.printStackTrace();
//					}
//					HashMap ctx = new HashMap();
//					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmthouse_F7ListUI));
//					prmthouse_F7ListUI.setF7Use(true,ctx);
//					prmthouse.setSelector(prmthouse_F7ListUI);
//				}
//			}
//		});
					
        // prmtcostCenter		
        this.prmtcostCenter.setQueryInfo("com.kingdee.eas.basedata.org.app.CostCenterItemQuery");		
        this.prmtcostCenter.setVisible(true);		
        this.prmtcostCenter.setEditable(true);		
        this.prmtcostCenter.setDisplayFormat("$name$");		
        this.prmtcostCenter.setEditFormat("$number$");		
        this.prmtcostCenter.setCommitFormat("$number$");		
        this.prmtcostCenter.setRequired(true);		
        this.prmtcostCenter.setEnabled(false);
        // prmtMarginBill		
        this.prmtMarginBill.setQueryInfo("com.kingdee.eas.farm.stocking.basebizbill.app.MarginBillQuery");		
        this.prmtMarginBill.setVisible(false);		
        this.prmtMarginBill.setEditable(true);		
        this.prmtMarginBill.setDisplayFormat("$number$");		
        this.prmtMarginBill.setEditFormat("$number$");		
        this.prmtMarginBill.setCommitFormat("$number$");		
        this.prmtMarginBill.setRequired(false);
        prmtMarginBill.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtMarginBill_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtbaseRecPrice		
        this.txtbaseRecPrice.setVisible(false);		
        this.txtbaseRecPrice.setHorizontalAlignment(2);		
        this.txtbaseRecPrice.setDataType(1);		
        this.txtbaseRecPrice.setSupportedEmpty(true);		
        this.txtbaseRecPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbaseRecPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbaseRecPrice.setPrecision(4);		
        this.txtbaseRecPrice.setRequired(false);
        // kDPanel3
        // kDPanel4
        // kdtReceiveBillEntry
		String kdtReceiveBillEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"receiveBill\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"receiveBizDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"receiveAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{receiveBill}</t:Cell><t:Cell>$Resource{receiveBizDate}</t:Cell><t:Cell>$Resource{receiveAmount}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtReceiveBillEntry.setFormatXml(resHelper.translateString("kdtReceiveBillEntry",kdtReceiveBillEntryStrXML));
        kdtReceiveBillEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtReceiveBillEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtReceiveBillEntry.putBindContents("editData",new String[] {"seq","receiveBill","receiveBizDate","receiveAmount"});


        this.kdtReceiveBillEntry.checkParsed();
        final KDBizPromptBox kdtReceiveBillEntry_receiveBill_PromptBox = new KDBizPromptBox();
        kdtReceiveBillEntry_receiveBill_PromptBox.setQueryInfo("com.kingdee.eas.fi.cas.ReceivingBillQuery");
        kdtReceiveBillEntry_receiveBill_PromptBox.setVisible(true);
        kdtReceiveBillEntry_receiveBill_PromptBox.setEditable(true);
        kdtReceiveBillEntry_receiveBill_PromptBox.setDisplayFormat("$number$");
        kdtReceiveBillEntry_receiveBill_PromptBox.setEditFormat("$number$");
        kdtReceiveBillEntry_receiveBill_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtReceiveBillEntry_receiveBill_CellEditor = new KDTDefaultCellEditor(kdtReceiveBillEntry_receiveBill_PromptBox);
        this.kdtReceiveBillEntry.getColumn("receiveBill").setEditor(kdtReceiveBillEntry_receiveBill_CellEditor);
        ObjectValueRender kdtReceiveBillEntry_receiveBill_OVR = new ObjectValueRender();
        kdtReceiveBillEntry_receiveBill_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtReceiveBillEntry.getColumn("receiveBill").setRenderer(kdtReceiveBillEntry_receiveBill_OVR);
        			EntityViewInfo evikdtReceiveBillEntry_receiveBill_PromptBox = new EntityViewInfo ();
		evikdtReceiveBillEntry_receiveBill_PromptBox.setFilter(com.kingdee.eas.framework.FrameWorkUtils.getF7FilterInfoByAuthorizedOrg(com.kingdee.eas.basedata.org.OrgType.getEnum("Company"),"company.id"));
		kdtReceiveBillEntry_receiveBill_PromptBox.setEntityViewInfo(evikdtReceiveBillEntry_receiveBill_PromptBox);
					
        KDDatePicker kdtReceiveBillEntry_receiveBizDate_DatePicker = new KDDatePicker();
        kdtReceiveBillEntry_receiveBizDate_DatePicker.setName("kdtReceiveBillEntry_receiveBizDate_DatePicker");
        kdtReceiveBillEntry_receiveBizDate_DatePicker.setVisible(true);
        kdtReceiveBillEntry_receiveBizDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtReceiveBillEntry_receiveBizDate_CellEditor = new KDTDefaultCellEditor(kdtReceiveBillEntry_receiveBizDate_DatePicker);
        this.kdtReceiveBillEntry.getColumn("receiveBizDate").setEditor(kdtReceiveBillEntry_receiveBizDate_CellEditor);
        KDFormattedTextField kdtReceiveBillEntry_receiveAmount_TextField = new KDFormattedTextField();
        kdtReceiveBillEntry_receiveAmount_TextField.setName("kdtReceiveBillEntry_receiveAmount_TextField");
        kdtReceiveBillEntry_receiveAmount_TextField.setVisible(true);
        kdtReceiveBillEntry_receiveAmount_TextField.setEditable(true);
        kdtReceiveBillEntry_receiveAmount_TextField.setHorizontalAlignment(2);
        kdtReceiveBillEntry_receiveAmount_TextField.setDataType(1);
        	kdtReceiveBillEntry_receiveAmount_TextField.setMinimumValue(new java.math.BigDecimal("-3.4028234663852886E38"));
        	kdtReceiveBillEntry_receiveAmount_TextField.setMaximumValue(new java.math.BigDecimal("3.4028234663852886E38"));
        kdtReceiveBillEntry_receiveAmount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtReceiveBillEntry_receiveAmount_CellEditor = new KDTDefaultCellEditor(kdtReceiveBillEntry_receiveAmount_TextField);
        this.kdtReceiveBillEntry.getColumn("receiveAmount").setEditor(kdtReceiveBillEntry_receiveAmount_CellEditor);
        // txtcontractContext		
        this.txtcontractContext.setRequired(false);		
        this.txtcontractContext.setMaxLength(500);
        // tBtnAudit
        this.tBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnAudit.setText(resHelper.getString("tBtnAudit.text"));
        // tBtnUnAudit
        this.tBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnUnAudit.setText(resHelper.getString("tBtnUnAudit.text"));
        // btnRevoke
        this.btnRevoke.setAction((IItemAction)ActionProxyFactory.getProxy(actionRevoke, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnRevoke.setText(resHelper.getString("btnRevoke.text"));		
        this.btnRevoke.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("image_default_remove"));
        // btnViewGuaranteeBill
        this.btnViewGuaranteeBill.setAction((IItemAction)ActionProxyFactory.getProxy(actionViewGuaranteeBill, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnViewGuaranteeBill.setText(resHelper.getString("btnViewGuaranteeBill.text"));		
        this.btnViewGuaranteeBill.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_linkviewbill"));
        // btnChangIsFeedBig
        this.btnChangIsFeedBig.setAction((IItemAction)ActionProxyFactory.getProxy(actionChangIsFeedBig, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnChangIsFeedBig.setText(resHelper.getString("btnChangIsFeedBig.text"));		
        this.btnChangIsFeedBig.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_automatching"));
        // mBtnAudit
        this.mBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnAudit.setText(resHelper.getString("mBtnAudit.text"));
        // mBtnUnAudit
        this.mBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnUnAudit.setText(resHelper.getString("mBtnUnAudit.text"));
        // newSeparator3
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,prmtcompany,chkisTemplate,billStatus,pkcontractDate,pkcontractEndDate,prmtperson,txtidentity,txtmobileTel,txtcontractContext,breedType,txtDescription,prmtMarginBill,prmtbreedData,txtfemaleBreedQty,chkisInit,prmtAuditor,pkauditTime,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,pkactualBreedDate,txtactualFemaleQty,prmtfarmer,prmtfarm,prmtsettlementPolicy,contractType,pkpreditRecDate,txtdiffDay,pkrecyBeginDate,pkrecyEndDate,txtbaseRecPrice,prmtbatch,txtremark,prmtmarginPolicy,txtenableMargin,txtstandardMargin,txtminMargin,txtusedMargin,prmtconFeedContract,txtunlockMargin,kdtReceiveBillEntry,txttotalMargin,txtoccupyMargin,farmsType,prmtconFeedPolicy,txtactualSingleMargin,txtfarmAddress,txtbreedPrice,chkisRecSettled,prmtguaranty,txtsubsidyPrice,chkisFeedBig,prmtslaughterPoint,pkguaranteeBeginDate,pkguaranteeEndDate,txtfeedInstance,prmtcostObject,prmtputPolicy,prmtbasePriceAdjust,chkisSetMargin,prmthouse,prmtcostCenter}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 658));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1013, 658));
        contCreator.setBounds(new Rectangle(378, 595, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(378, 595, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(378, 623, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(378, 623, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(723, 595, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(723, 595, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateTime.setBounds(new Rectangle(723, 623, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(723, 623, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(20, 17, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(20, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(364, 17, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(364, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(364, 48, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(364, 48, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(28, 595, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(28, 595, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(708, 17, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(708, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompany.setBounds(new Rectangle(20, 48, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(20, 48, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(28, 623, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(28, 623, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator8.setBounds(new Rectangle(-37, 583, 1083, 8));
        this.add(kDSeparator8, new KDLayout.Constraints(-37, 583, 1083, 8, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        chkisTemplate.setBounds(new Rectangle(1026, 19, 62, 19));
        this.add(chkisTemplate, new KDLayout.Constraints(1026, 19, 62, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane1.setBounds(new Rectangle(14, 95, 986, 487));
        this.add(kDTabbedPane1, new KDLayout.Constraints(14, 95, 986, 487, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator9.setBounds(new Rectangle(6, 86, 986, 8));
        this.add(kDSeparator9, new KDLayout.Constraints(6, 86, 986, 8, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        chkisInit.setBounds(new Rectangle(1030, 40, 84, 19));
        this.add(chkisInit, new KDLayout.Constraints(1030, 40, 84, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contMarginBill.setBounds(new Rectangle(1024, 34, 270, 19));
        this.add(contMarginBill, new KDLayout.Constraints(1024, 34, 270, 19, 0));
        contbaseRecPrice.setBounds(new Rectangle(985, 57, 270, 19));
        this.add(contbaseRecPrice, new KDLayout.Constraints(985, 57, 270, 19, 0));
        chkisRecSettled.setBounds(new Rectangle(708, 48, 115, 19));
        this.add(chkisRecSettled, new KDLayout.Constraints(708, 48, 115, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane2.setBounds(new Rectangle(1026, 537, 967, 8));
        this.add(kDTabbedPane2, new KDLayout.Constraints(1026, 537, 967, 8, 0));
        chkisSetMargin.setBounds(new Rectangle(852, 48, 120, 19));
        this.add(chkisSetMargin, new KDLayout.Constraints(852, 48, 120, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 985, 454));        contidentity.setBounds(new Rectangle(360, 33, 270, 19));
        kDPanel1.add(contidentity, new KDLayout.Constraints(360, 33, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcontractDate.setBounds(new Rectangle(34, 10, 270, 19));
        kDPanel1.add(contcontractDate, new KDLayout.Constraints(34, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contperson.setBounds(new Rectangle(687, 12, 270, 19));
        kDPanel1.add(contperson, new KDLayout.Constraints(687, 12, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contmobileTel.setBounds(new Rectangle(687, 35, 270, 19));
        kDPanel1.add(contmobileTel, new KDLayout.Constraints(687, 35, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbreedType.setBounds(new Rectangle(34, 34, 270, 19));
        kDPanel1.add(contbreedType, new KDLayout.Constraints(34, 34, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDPanel2.setBounds(new Rectangle(19, 183, 957, 152));
        kDPanel1.add(kDPanel2, new KDLayout.Constraints(19, 183, 957, 152, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contcontractEndDate.setBounds(new Rectangle(360, 9, 270, 19));
        kDPanel1.add(contcontractEndDate, new KDLayout.Constraints(360, 9, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmer.setBounds(new Rectangle(34, 58, 270, 19));
        kDPanel1.add(contfarmer, new KDLayout.Constraints(34, 58, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarm.setBounds(new Rectangle(360, 57, 270, 19));
        kDPanel1.add(contfarm, new KDLayout.Constraints(360, 57, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDPanel5.setBounds(new Rectangle(18, 338, 950, 112));
        kDPanel1.add(kDPanel5, new KDLayout.Constraints(18, 338, 950, 112, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contcontractType.setBounds(new Rectangle(33, 130, 271, 19));
        kDPanel1.add(contcontractType, new KDLayout.Constraints(33, 130, 271, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contconFeedContract.setBounds(new Rectangle(34, 82, 270, 19));
        kDPanel1.add(contconFeedContract, new KDLayout.Constraints(34, 82, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contconFeedPolicy.setBounds(new Rectangle(360, 81, 270, 19));
        kDPanel1.add(contconFeedPolicy, new KDLayout.Constraints(360, 81, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmAddress.setBounds(new Rectangle(687, 58, 270, 19));
        kDPanel1.add(contfarmAddress, new KDLayout.Constraints(687, 58, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contguaranty.setBounds(new Rectangle(34, 107, 270, 19));
        kDPanel1.add(contguaranty, new KDLayout.Constraints(34, 107, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsubsidyPrice.setBounds(new Rectangle(687, 81, 270, 19));
        kDPanel1.add(contsubsidyPrice, new KDLayout.Constraints(687, 81, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contguaranteeBeginDate.setBounds(new Rectangle(360, 107, 270, 19));
        kDPanel1.add(contguaranteeBeginDate, new KDLayout.Constraints(360, 107, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contguaranteeEndDate.setBounds(new Rectangle(687, 107, 270, 19));
        kDPanel1.add(contguaranteeEndDate, new KDLayout.Constraints(687, 107, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfeedInstance.setBounds(new Rectangle(361, 130, 270, 19));
        kDPanel1.add(contfeedInstance, new KDLayout.Constraints(361, 130, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contputPolicy.setBounds(new Rectangle(687, 130, 270, 19));
        kDPanel1.add(contputPolicy, new KDLayout.Constraints(687, 130, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbasePriceAdjust.setBounds(new Rectangle(33, 155, 270, 19));
        kDPanel1.add(contbasePriceAdjust, new KDLayout.Constraints(33, 155, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conthouse.setBounds(new Rectangle(361, 155, 270, 19));
        kDPanel1.add(conthouse, new KDLayout.Constraints(361, 155, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcostCenter.setBounds(new Rectangle(687, 155, 270, 19));
        kDPanel1.add(contcostCenter, new KDLayout.Constraints(687, 155, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contidentity
        contidentity.setBoundEditor(txtidentity);
        //contcontractDate
        contcontractDate.setBoundEditor(pkcontractDate);
        //contperson
        contperson.setBoundEditor(prmtperson);
        //contmobileTel
        contmobileTel.setBoundEditor(txtmobileTel);
        //contbreedType
        contbreedType.setBoundEditor(breedType);
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(19, 183, 957, 152));        contbreedData.setBounds(new Rectangle(21, 12, 270, 19));
        kDPanel2.add(contbreedData, new KDLayout.Constraints(21, 12, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfemaleBreedQty.setBounds(new Rectangle(666, 13, 270, 19));
        kDPanel2.add(contfemaleBreedQty, new KDLayout.Constraints(666, 13, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contactualBreedDate.setBounds(new Rectangle(21, 62, 270, 19));
        kDPanel2.add(contactualBreedDate, new KDLayout.Constraints(21, 62, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contactualFemaleQty.setBounds(new Rectangle(344, 62, 270, 19));
        kDPanel2.add(contactualFemaleQty, new KDLayout.Constraints(344, 62, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsettlementPolicy.setBounds(new Rectangle(344, 12, 270, 19));
        kDPanel2.add(contsettlementPolicy, new KDLayout.Constraints(344, 12, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpreditRecDate.setBounds(new Rectangle(666, 62, 270, 19));
        kDPanel2.add(contpreditRecDate, new KDLayout.Constraints(666, 62, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contdiffDay.setBounds(new Rectangle(21, 87, 270, 19));
        kDPanel2.add(contdiffDay, new KDLayout.Constraints(21, 87, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contrecyBeginDate.setBounds(new Rectangle(344, 87, 270, 19));
        kDPanel2.add(contrecyBeginDate, new KDLayout.Constraints(344, 87, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contrecyEndDate.setBounds(new Rectangle(666, 87, 270, 19));
        kDPanel2.add(contrecyEndDate, new KDLayout.Constraints(666, 87, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbatch.setBounds(new Rectangle(21, 37, 270, 19));
        kDPanel2.add(contbatch, new KDLayout.Constraints(21, 37, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmsType.setBounds(new Rectangle(666, 36, 270, 19));
        kDPanel2.add(contfarmsType, new KDLayout.Constraints(666, 36, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbreedPrice.setBounds(new Rectangle(344, 37, 270, 19));
        kDPanel2.add(contbreedPrice, new KDLayout.Constraints(344, 37, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisFeedBig.setBounds(new Rectangle(696, 113, 270, 19));
        kDPanel2.add(chkisFeedBig, new KDLayout.Constraints(696, 113, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contslaughterPoint.setBounds(new Rectangle(21, 115, 270, 19));
        kDPanel2.add(contslaughterPoint, new KDLayout.Constraints(21, 115, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcostObject.setBounds(new Rectangle(344, 115, 270, 19));
        kDPanel2.add(contcostObject, new KDLayout.Constraints(344, 115, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contbreedData
        contbreedData.setBoundEditor(prmtbreedData);
        //contfemaleBreedQty
        contfemaleBreedQty.setBoundEditor(txtfemaleBreedQty);
        //contactualBreedDate
        contactualBreedDate.setBoundEditor(pkactualBreedDate);
        //contactualFemaleQty
        contactualFemaleQty.setBoundEditor(txtactualFemaleQty);
        //contsettlementPolicy
        contsettlementPolicy.setBoundEditor(prmtsettlementPolicy);
        //contpreditRecDate
        contpreditRecDate.setBoundEditor(pkpreditRecDate);
        //contdiffDay
        contdiffDay.setBoundEditor(txtdiffDay);
        //contrecyBeginDate
        contrecyBeginDate.setBoundEditor(pkrecyBeginDate);
        //contrecyEndDate
        contrecyEndDate.setBoundEditor(pkrecyEndDate);
        //contbatch
        contbatch.setBoundEditor(prmtbatch);
        //contfarmsType
        contfarmsType.setBoundEditor(farmsType);
        //contbreedPrice
        contbreedPrice.setBoundEditor(txtbreedPrice);
        //contslaughterPoint
        contslaughterPoint.setBoundEditor(prmtslaughterPoint);
        //contcostObject
        contcostObject.setBoundEditor(prmtcostObject);
        //contcontractEndDate
        contcontractEndDate.setBoundEditor(pkcontractEndDate);
        //contfarmer
        contfarmer.setBoundEditor(prmtfarmer);
        //contfarm
        contfarm.setBoundEditor(prmtfarm);
        //kDPanel5
        kDPanel5.setLayout(new KDLayout());
        kDPanel5.putClientProperty("OriginalBounds", new Rectangle(18, 338, 950, 112));        contremark.setBounds(new Rectangle(259, 66, 661, 19));
        kDPanel5.add(contremark, new KDLayout.Constraints(259, 66, 661, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmarginPolicy.setBounds(new Rectangle(21, 18, 218, 19));
        kDPanel5.add(contmarginPolicy, new KDLayout.Constraints(21, 18, 218, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contenableMargin.setBounds(new Rectangle(720, 18, 208, 19));
        kDPanel5.add(contenableMargin, new KDLayout.Constraints(720, 18, 208, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contstandardMargin.setBounds(new Rectangle(257, 42, 216, 19));
        kDPanel5.add(contstandardMargin, new KDLayout.Constraints(257, 42, 216, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contminMargin.setBounds(new Rectangle(21, 42, 218, 19));
        kDPanel5.add(contminMargin, new KDLayout.Constraints(21, 42, 218, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contusedMargin.setBounds(new Rectangle(497, 42, 203, 19));
        kDPanel5.add(contusedMargin, new KDLayout.Constraints(497, 42, 203, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contunlockMargin.setBounds(new Rectangle(720, 42, 207, 19));
        kDPanel5.add(contunlockMargin, new KDLayout.Constraints(720, 42, 207, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conttotalMargin.setBounds(new Rectangle(257, 18, 214, 19));
        kDPanel5.add(conttotalMargin, new KDLayout.Constraints(257, 18, 214, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoccupyMargin.setBounds(new Rectangle(497, 18, 203, 19));
        kDPanel5.add(contoccupyMargin, new KDLayout.Constraints(497, 18, 203, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contactualSingleMargin.setBounds(new Rectangle(21, 66, 218, 19));
        kDPanel5.add(contactualSingleMargin, new KDLayout.Constraints(21, 66, 218, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contremark
        contremark.setBoundEditor(txtremark);
        //contmarginPolicy
        contmarginPolicy.setBoundEditor(prmtmarginPolicy);
        //contenableMargin
        contenableMargin.setBoundEditor(txtenableMargin);
        //contstandardMargin
        contstandardMargin.setBoundEditor(txtstandardMargin);
        //contminMargin
        contminMargin.setBoundEditor(txtminMargin);
        //contusedMargin
        contusedMargin.setBoundEditor(txtusedMargin);
        //contunlockMargin
        contunlockMargin.setBoundEditor(txtunlockMargin);
        //conttotalMargin
        conttotalMargin.setBoundEditor(txttotalMargin);
        //contoccupyMargin
        contoccupyMargin.setBoundEditor(txtoccupyMargin);
        //contactualSingleMargin
        contactualSingleMargin.setBoundEditor(txtactualSingleMargin);
        //contcontractType
        contcontractType.setBoundEditor(contractType);
        //contconFeedContract
        contconFeedContract.setBoundEditor(prmtconFeedContract);
        //contconFeedPolicy
        contconFeedPolicy.setBoundEditor(prmtconFeedPolicy);
        //contfarmAddress
        contfarmAddress.setBoundEditor(txtfarmAddress);
        //contguaranty
        contguaranty.setBoundEditor(prmtguaranty);
        //contsubsidyPrice
        contsubsidyPrice.setBoundEditor(txtsubsidyPrice);
        //contguaranteeBeginDate
        contguaranteeBeginDate.setBoundEditor(pkguaranteeBeginDate);
        //contguaranteeEndDate
        contguaranteeEndDate.setBoundEditor(pkguaranteeEndDate);
        //contfeedInstance
        contfeedInstance.setBoundEditor(txtfeedInstance);
        //contputPolicy
        contputPolicy.setBoundEditor(prmtputPolicy);
        //contbasePriceAdjust
        contbasePriceAdjust.setBoundEditor(prmtbasePriceAdjust);
        //conthouse
        conthouse.setBoundEditor(prmthouse);
        //contcostCenter
        contcostCenter.setBoundEditor(prmtcostCenter);
        //contMarginBill
        contMarginBill.setBoundEditor(prmtMarginBill);
        //contbaseRecPrice
        contbaseRecPrice.setBoundEditor(txtbaseRecPrice);
        //kDTabbedPane2
        kDTabbedPane2.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        kDTabbedPane2.add(kDPanel4, resHelper.getString("kDPanel4.constraints"));
        //kDPanel3
        kDPanel3.setLayout(new KDLayout());
        kDPanel3.putClientProperty("OriginalBounds", new Rectangle(0, 0, 966, 1));        kdtReceiveBillEntry.setBounds(new Rectangle(-4, -4, 963, 160));
        kdtReceiveBillEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtReceiveBillEntry,new com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillReceiveBillEntryInfo(),null,false);
        kDPanel3.add(kdtReceiveBillEntry_detailPanel, new KDLayout.Constraints(-4, -4, 963, 160, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel4
        kDPanel4.setLayout(new KDLayout());
        kDPanel4.putClientProperty("OriginalBounds", new Rectangle(0, 0, 966, 1));        txtcontractContext.setBounds(new Rectangle(1, 1, 957, 157));
        kDPanel4.add(txtcontractContext, new KDLayout.Constraints(1, 1, 957, 157, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));

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
        this.toolBar.add(btnCopy);
        this.toolBar.add(btnRemove);
        this.toolBar.add(tBtnAudit);
        this.toolBar.add(tBtnUnAudit);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);
        this.toolBar.add(btnRevoke);
        this.toolBar.add(btnViewGuaranteeBill);
        this.toolBar.add(btnChangIsFeedBig);
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
        this.toolBar.add(btnPCVoucher);
        this.toolBar.add(separatorFW6);
        this.toolBar.add(btnDelPCVoucher);
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
		dataBinder.registerBinding("isTemplate", boolean.class, this.chkisTemplate, "selected");
		dataBinder.registerBinding("isInit", boolean.class, this.chkisInit, "selected");
		dataBinder.registerBinding("isRecSettled", boolean.class, this.chkisRecSettled, "selected");
		dataBinder.registerBinding("isSetMargin", boolean.class, this.chkisSetMargin, "selected");
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
		dataBinder.registerBinding("identity", String.class, this.txtidentity, "text");
		dataBinder.registerBinding("contractDate", java.util.Date.class, this.pkcontractDate, "value");
		dataBinder.registerBinding("person", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtperson, "data");
		dataBinder.registerBinding("mobileTel", String.class, this.txtmobileTel, "text");
		dataBinder.registerBinding("breedType", com.kingdee.eas.farm.stocking.basedata.StockingTypeEnum.class, this.breedType, "selectedItem");
		dataBinder.registerBinding("isFeedBig", boolean.class, this.chkisFeedBig, "selected");
		dataBinder.registerBinding("breedData", com.kingdee.eas.farm.stocking.basedata.BreedDataInfo.class, this.prmtbreedData, "data");
		dataBinder.registerBinding("femaleBreedQty", java.math.BigDecimal.class, this.txtfemaleBreedQty, "value");
		dataBinder.registerBinding("actualBreedDate", java.util.Date.class, this.pkactualBreedDate, "value");
		dataBinder.registerBinding("actualFemaleQty", java.math.BigDecimal.class, this.txtactualFemaleQty, "value");
		dataBinder.registerBinding("settlementPolicy", com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo.class, this.prmtsettlementPolicy, "data");
		dataBinder.registerBinding("preditRecDate", java.util.Date.class, this.pkpreditRecDate, "value");
		dataBinder.registerBinding("diffDay", int.class, this.txtdiffDay, "value");
		dataBinder.registerBinding("recyBeginDate", java.util.Date.class, this.pkrecyBeginDate, "value");
		dataBinder.registerBinding("recyEndDate", java.util.Date.class, this.pkrecyEndDate, "value");
		dataBinder.registerBinding("batch", com.kingdee.eas.farm.carnivorous.basedata.BatchInfo.class, this.prmtbatch, "data");
		dataBinder.registerBinding("farmsType", com.kingdee.eas.farm.stocking.basedata.FarmsType.class, this.farmsType, "selectedItem");
		dataBinder.registerBinding("breedPrice", java.math.BigDecimal.class, this.txtbreedPrice, "value");
		dataBinder.registerBinding("slaughterPoint", com.kingdee.eas.farm.carnivorous.basedata.FreightCalPointInfo.class, this.prmtslaughterPoint, "data");
		dataBinder.registerBinding("costObject", com.kingdee.eas.basedata.assistant.CostObjectInfo.class, this.prmtcostObject, "data");
		dataBinder.registerBinding("contractEndDate", java.util.Date.class, this.pkcontractEndDate, "value");
		dataBinder.registerBinding("farmer", com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo.class, this.prmtfarmer, "data");
		dataBinder.registerBinding("farm", com.kingdee.eas.farm.carnivorous.basedata.FarmInfo.class, this.prmtfarm, "data");
		dataBinder.registerBinding("remark", String.class, this.txtremark, "text");
		dataBinder.registerBinding("marginPolicy", com.kingdee.eas.farm.carnivorous.basedata.MarginPolicyInfo.class, this.prmtmarginPolicy, "data");
		dataBinder.registerBinding("enableMargin", java.math.BigDecimal.class, this.txtenableMargin, "value");
		dataBinder.registerBinding("standardMargin", java.math.BigDecimal.class, this.txtstandardMargin, "value");
		dataBinder.registerBinding("minMargin", java.math.BigDecimal.class, this.txtminMargin, "value");
		dataBinder.registerBinding("usedMargin", java.math.BigDecimal.class, this.txtusedMargin, "value");
		dataBinder.registerBinding("unlockMargin", java.math.BigDecimal.class, this.txtunlockMargin, "value");
		dataBinder.registerBinding("totalMargin", java.math.BigDecimal.class, this.txttotalMargin, "value");
		dataBinder.registerBinding("occupyMargin", java.math.BigDecimal.class, this.txtoccupyMargin, "value");
		dataBinder.registerBinding("actualSingleMargin", java.math.BigDecimal.class, this.txtactualSingleMargin, "value");
		dataBinder.registerBinding("contractType", com.kingdee.eas.farm.carnivorous.feedbiz.ContractType.class, this.contractType, "selectedItem");
		dataBinder.registerBinding("conFeedContract", com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractInfo.class, this.prmtconFeedContract, "data");
		dataBinder.registerBinding("conFeedPolicy", com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicyInfo.class, this.prmtconFeedPolicy, "data");
		dataBinder.registerBinding("farmAddress", String.class, this.txtfarmAddress, "text");
		dataBinder.registerBinding("guaranty", com.kingdee.eas.farm.carnivorous.basebiz.FarmerGuaranteeBillInfo.class, this.prmtguaranty, "data");
		dataBinder.registerBinding("subsidyPrice", java.math.BigDecimal.class, this.txtsubsidyPrice, "value");
		dataBinder.registerBinding("guaranteeBeginDate", java.util.Date.class, this.pkguaranteeBeginDate, "value");
		dataBinder.registerBinding("guaranteeEndDate", java.util.Date.class, this.pkguaranteeEndDate, "value");
		dataBinder.registerBinding("feedInstance", java.math.BigDecimal.class, this.txtfeedInstance, "value");
		dataBinder.registerBinding("putPolicy", com.kingdee.eas.farm.carnivorous.basedata.InvestmentPolicyChickenInfo.class, this.prmtputPolicy, "data");
		dataBinder.registerBinding("basePriceAdjust", com.kingdee.eas.farm.carnivorous.basedata.BasePriceAdjustPolicyInfo.class, this.prmtbasePriceAdjust, "data");
		dataBinder.registerBinding("house", com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicyInfo.class, this.prmthouse, "data");
		dataBinder.registerBinding("costCenter", com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo.class, this.prmtcostCenter, "data");
		dataBinder.registerBinding("MarginBill", com.kingdee.eas.farm.stocking.basebizbill.MarginBillInfo.class, this.prmtMarginBill, "data");
		dataBinder.registerBinding("baseRecPrice", java.math.BigDecimal.class, this.txtbaseRecPrice, "value");
		dataBinder.registerBinding("ReceiveBillEntry.seq", int.class, this.kdtReceiveBillEntry, "seq.text");
		dataBinder.registerBinding("ReceiveBillEntry", com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillReceiveBillEntryInfo.class, this.kdtReceiveBillEntry, "userObject");
		dataBinder.registerBinding("ReceiveBillEntry.receiveBill", java.lang.Object.class, this.kdtReceiveBillEntry, "receiveBill.text");
		dataBinder.registerBinding("ReceiveBillEntry.receiveAmount", java.math.BigDecimal.class, this.kdtReceiveBillEntry, "receiveAmount.text");
		dataBinder.registerBinding("ReceiveBillEntry.receiveBizDate", java.util.Date.class, this.kdtReceiveBillEntry, "receiveBizDate.text");
		dataBinder.registerBinding("contractContext", String.class, this.txtcontractContext, "text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.carnivorous.feedbiz.app.BatchContractBillEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo)ov;
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
		getValidateHelper().registerBindProperty("isTemplate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isInit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isRecSettled", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isSetMargin", ValidateHelper.ON_SAVE);    
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
		getValidateHelper().registerBindProperty("identity", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contractDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("person", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mobileTel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isFeedBig", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedData", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("femaleBreedQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("actualBreedDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("actualFemaleQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("settlementPolicy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("preditRecDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("diffDay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("recyBeginDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("recyEndDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmsType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("slaughterPoint", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("costObject", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contractEndDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("marginPolicy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("enableMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("standardMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("minMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("usedMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("unlockMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("occupyMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("actualSingleMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contractType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("conFeedContract", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("conFeedPolicy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmAddress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("guaranty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("subsidyPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("guaranteeBeginDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("guaranteeEndDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("feedInstance", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("putPolicy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("basePriceAdjust", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("house", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("costCenter", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MarginBill", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseRecPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ReceiveBillEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ReceiveBillEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ReceiveBillEntry.receiveBill", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ReceiveBillEntry.receiveAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ReceiveBillEntry.receiveBizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contractContext", ValidateHelper.ON_SAVE);    		
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
     * output prmtfarm_Changed() method
     */
    public void prmtfarm_Changed() throws Exception
    {
        System.out.println("prmtfarm_Changed() Function is executed!");
            txtfarmAddress.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtfarm.getData(),"address")));


    }

    /**
     * output prmtguaranty_Changed() method
     */
    public void prmtguaranty_Changed() throws Exception
    {
        System.out.println("prmtguaranty_Changed() Function is executed!");
            pkguaranteeBeginDate.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getDateValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtguaranty.getData(),"beginDate")));

    pkguaranteeEndDate.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getDateValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtguaranty.getData(),"endDate")));


    }

    /**
     * output prmtMarginBill_Changed() method
     */
    public void prmtMarginBill_Changed() throws Exception
    {
        System.out.println("prmtMarginBill_Changed() Function is executed!");
            prmtfarmer.setData(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtMarginBill.getData(),"farmer"));


    }

    /**
     * output kdtReceiveBillEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtReceiveBillEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("receiveBill".equalsIgnoreCase(kdtReceiveBillEntry.getColumn(colIndex).getKey())) {
kdtReceiveBillEntry.getCell(rowIndex,"receiveAmount").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtReceiveBillEntry.getCell(rowIndex,"receiveBill").getValue(),"actRecAmt")));

}

    if ("receiveBill".equalsIgnoreCase(kdtReceiveBillEntry.getColumn(colIndex).getKey())) {
kdtReceiveBillEntry.getCell(rowIndex,"receiveBizDate").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getDateValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtReceiveBillEntry.getCell(rowIndex,"receiveBill").getValue(),"bizDate")));

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
        sic.add(new SelectorItemInfo("isTemplate"));
        sic.add(new SelectorItemInfo("isInit"));
        sic.add(new SelectorItemInfo("isRecSettled"));
        sic.add(new SelectorItemInfo("isSetMargin"));
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
        sic.add(new SelectorItemInfo("identity"));
        sic.add(new SelectorItemInfo("contractDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("person.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("person.id"));
        	sic.add(new SelectorItemInfo("person.number"));
        	sic.add(new SelectorItemInfo("person.name"));
		}
        sic.add(new SelectorItemInfo("mobileTel"));
        sic.add(new SelectorItemInfo("breedType"));
        sic.add(new SelectorItemInfo("isFeedBig"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("breedData.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("breedData.id"));
        	sic.add(new SelectorItemInfo("breedData.number"));
        	sic.add(new SelectorItemInfo("breedData.name"));
		}
        sic.add(new SelectorItemInfo("femaleBreedQty"));
        sic.add(new SelectorItemInfo("actualBreedDate"));
        sic.add(new SelectorItemInfo("actualFemaleQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("settlementPolicy.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("settlementPolicy.id"));
        	sic.add(new SelectorItemInfo("settlementPolicy.number"));
        	sic.add(new SelectorItemInfo("settlementPolicy.name"));
		}
        sic.add(new SelectorItemInfo("preditRecDate"));
        sic.add(new SelectorItemInfo("diffDay"));
        sic.add(new SelectorItemInfo("recyBeginDate"));
        sic.add(new SelectorItemInfo("recyEndDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("batch.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("batch.id"));
        	sic.add(new SelectorItemInfo("batch.number"));
        	sic.add(new SelectorItemInfo("batch.name"));
		}
        sic.add(new SelectorItemInfo("farmsType"));
        sic.add(new SelectorItemInfo("breedPrice"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("slaughterPoint.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("slaughterPoint.id"));
        	sic.add(new SelectorItemInfo("slaughterPoint.number"));
        	sic.add(new SelectorItemInfo("slaughterPoint.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("costObject.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("costObject.id"));
        	sic.add(new SelectorItemInfo("costObject.number"));
        	sic.add(new SelectorItemInfo("costObject.name"));
		}
        sic.add(new SelectorItemInfo("contractEndDate"));
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
        sic.add(new SelectorItemInfo("remark"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("marginPolicy.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("marginPolicy.id"));
        	sic.add(new SelectorItemInfo("marginPolicy.number"));
        	sic.add(new SelectorItemInfo("marginPolicy.name"));
		}
        sic.add(new SelectorItemInfo("enableMargin"));
        sic.add(new SelectorItemInfo("standardMargin"));
        sic.add(new SelectorItemInfo("minMargin"));
        sic.add(new SelectorItemInfo("usedMargin"));
        sic.add(new SelectorItemInfo("unlockMargin"));
        sic.add(new SelectorItemInfo("totalMargin"));
        sic.add(new SelectorItemInfo("occupyMargin"));
        sic.add(new SelectorItemInfo("actualSingleMargin"));
        sic.add(new SelectorItemInfo("contractType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("conFeedContract.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("conFeedContract.id"));
        	sic.add(new SelectorItemInfo("conFeedContract.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("conFeedPolicy.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("conFeedPolicy.id"));
        	sic.add(new SelectorItemInfo("conFeedPolicy.number"));
        	sic.add(new SelectorItemInfo("conFeedPolicy.name"));
		}
        sic.add(new SelectorItemInfo("farmAddress"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("guaranty.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("guaranty.id"));
        	sic.add(new SelectorItemInfo("guaranty.number"));
		}
        sic.add(new SelectorItemInfo("subsidyPrice"));
        sic.add(new SelectorItemInfo("guaranteeBeginDate"));
        sic.add(new SelectorItemInfo("guaranteeEndDate"));
        sic.add(new SelectorItemInfo("feedInstance"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("putPolicy.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("putPolicy.id"));
        	sic.add(new SelectorItemInfo("putPolicy.number"));
        	sic.add(new SelectorItemInfo("putPolicy.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("basePriceAdjust.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("basePriceAdjust.id"));
        	sic.add(new SelectorItemInfo("basePriceAdjust.number"));
        	sic.add(new SelectorItemInfo("basePriceAdjust.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("house.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("house.id"));
        	sic.add(new SelectorItemInfo("house.number"));
        	sic.add(new SelectorItemInfo("house.name"));
		}
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
			sic.add(new SelectorItemInfo("MarginBill.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("MarginBill.id"));
        	sic.add(new SelectorItemInfo("MarginBill.number"));
		}
        sic.add(new SelectorItemInfo("baseRecPrice"));
    	sic.add(new SelectorItemInfo("ReceiveBillEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ReceiveBillEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ReceiveBillEntry.receiveBill.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("ReceiveBillEntry.receiveBill.id"));
			sic.add(new SelectorItemInfo("ReceiveBillEntry.receiveBill.number"));
		}
    	sic.add(new SelectorItemInfo("ReceiveBillEntry.receiveAmount"));
    	sic.add(new SelectorItemInfo("ReceiveBillEntry.receiveBizDate"));
        sic.add(new SelectorItemInfo("contractContext"));
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
        com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionIsTemplate_actionPerformed method
     */
    public void actionIsTemplate_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory.getRemoteInstance().isTemplate(editData);
    }
    	

    /**
     * output actionIsInit_actionPerformed method
     */
    public void actionIsInit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory.getRemoteInstance().isInit(editData);
    }
    	

    /**
     * output actionViewGuaranteeBill_actionPerformed method
     */
    public void actionViewGuaranteeBill_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory.getRemoteInstance().viewGuaranteeBill(editData);
    }
    	

    /**
     * output actionRevoke_actionPerformed method
     */
    public void actionRevoke_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory.getRemoteInstance().revoke(editData);
    }
    	

    /**
     * output actionChangIsFeedBig_actionPerformed method
     */
    public void actionChangIsFeedBig_actionPerformed(ActionEvent e) throws Exception
    {
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
	public RequestContext prepareActionIsTemplate(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionIsTemplate() {
    	return false;
    }
	public RequestContext prepareActionIsInit(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionIsInit() {
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
	public RequestContext prepareActionRevoke(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionRevoke() {
    	return false;
    }
	public RequestContext prepareActionChangIsFeedBig(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionChangIsFeedBig() {
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
            innerActionPerformed("eas", AbstractBatchContractBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractBatchContractBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionIsTemplate class
     */     
    protected class ActionIsTemplate extends ItemAction {     
    
        public ActionIsTemplate()
        {
            this(null);
        }

        public ActionIsTemplate(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionIsTemplate.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionIsTemplate.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionIsTemplate.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractBatchContractBillEditUI.this, "ActionIsTemplate", "actionIsTemplate_actionPerformed", e);
        }
    }

    /**
     * output ActionIsInit class
     */     
    protected class ActionIsInit extends ItemAction {     
    
        public ActionIsInit()
        {
            this(null);
        }

        public ActionIsInit(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionIsInit.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionIsInit.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionIsInit.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractBatchContractBillEditUI.this, "ActionIsInit", "actionIsInit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractBatchContractBillEditUI.this, "ActionViewGuaranteeBill", "actionViewGuaranteeBill_actionPerformed", e);
        }
    }

    /**
     * output ActionRevoke class
     */     
    protected class ActionRevoke extends ItemAction {     
    
        public ActionRevoke()
        {
            this(null);
        }

        public ActionRevoke(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionRevoke.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionRevoke.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionRevoke.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractBatchContractBillEditUI.this, "ActionRevoke", "actionRevoke_actionPerformed", e);
        }
    }

    /**
     * output ActionChangIsFeedBig class
     */     
    protected class ActionChangIsFeedBig extends ItemAction {     
    
        public ActionChangIsFeedBig()
        {
            this(null);
        }

        public ActionChangIsFeedBig(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionChangIsFeedBig.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionChangIsFeedBig.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionChangIsFeedBig.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractBatchContractBillEditUI.this, "ActionChangIsFeedBig", "actionChangIsFeedBig_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.feedbiz.client", "BatchContractBillEditUI");
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
        return com.kingdee.eas.farm.carnivorous.feedbiz.client.BatchContractBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/carnivorous/feedbiz/BatchContractBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.carnivorous.feedbiz.app.BatchContractBillQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(breedType.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖类型"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtbreedData.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"品种"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtsettlementPolicy.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"结算政策"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtfarmer.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖户"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtfarm.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖场"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcostCenter.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"成本中心"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtReceiveBillEntry;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("billStatus",new Integer(-1));
vo.put("breedType",new Integer(2));
		vo.put("femaleBreedQty",new java.math.BigDecimal(0));
vo.put("farmsType","0");
vo.put("contractType","2");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}