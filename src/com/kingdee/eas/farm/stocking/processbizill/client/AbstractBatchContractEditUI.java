/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

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
public abstract class AbstractBatchContractEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractBatchContractEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contidentity;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontractDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmobileTel;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedType;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contMarginBill;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contMarginBillAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contreceiveBill;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontractEndDate;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane2;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmer;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtidentity;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkcontractDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperson;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtmobileTel;
    protected com.kingdee.bos.ctrl.swing.KDComboBox breedType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstockingBatch;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedData;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsettlementPolicy;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfemaleBreedQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contactualBreedDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contactualbreedQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contactualFemaleQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstockingBatch;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkbreedDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbreedQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbreedData;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsettlementPolicy;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfemaleBreedQty;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkactualBreedDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtactualbreedQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtactualFemaleQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtMarginBill;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtMarginBillAmount;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarm;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtreceiveBill;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkcontractEndDate;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtReceiveBillEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtReceiveBillEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtcontractContext;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDSeparator newSeparator3;
    protected com.kingdee.eas.farm.stocking.processbizill.BatchContractInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionIsTemplate actionIsTemplate = null;
    protected ActionIsInit actionIsInit = null;
    /**
     * output class constructor
     */
    public AbstractBatchContractEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractBatchContractEditUI.class.getName());
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
        this.contfarmer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contidentity = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcontractDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmobileTel = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbreedType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contMarginBill = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contMarginBillAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contreceiveBill = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcontractEndDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane2 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.prmtfarmer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtidentity = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkcontractDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtperson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtmobileTel = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.breedType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.contstockingBatch = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbreedDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbreedQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbreedData = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsettlementPolicy = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfemaleBreedQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contactualBreedDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contactualbreedQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contactualFemaleQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtstockingBatch = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkbreedDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtbreedQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtbreedData = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtsettlementPolicy = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtfemaleBreedQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkactualBreedDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtactualbreedQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtactualFemaleQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtMarginBill = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtMarginBillAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtfarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtreceiveBill = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkcontractEndDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtReceiveBillEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.txtcontractContext = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.tBtnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
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
        this.contfarmer.setName("contfarmer");
        this.contidentity.setName("contidentity");
        this.contcontractDate.setName("contcontractDate");
        this.contperson.setName("contperson");
        this.contmobileTel.setName("contmobileTel");
        this.contbreedType.setName("contbreedType");
        this.kDPanel2.setName("kDPanel2");
        this.contMarginBill.setName("contMarginBill");
        this.contMarginBillAmount.setName("contMarginBillAmount");
        this.contfarm.setName("contfarm");
        this.contreceiveBill.setName("contreceiveBill");
        this.contcontractEndDate.setName("contcontractEndDate");
        this.kDTabbedPane2.setName("kDTabbedPane2");
        this.prmtfarmer.setName("prmtfarmer");
        this.txtidentity.setName("txtidentity");
        this.pkcontractDate.setName("pkcontractDate");
        this.prmtperson.setName("prmtperson");
        this.txtmobileTel.setName("txtmobileTel");
        this.breedType.setName("breedType");
        this.contstockingBatch.setName("contstockingBatch");
        this.contbreedDate.setName("contbreedDate");
        this.contbreedQty.setName("contbreedQty");
        this.contbreedData.setName("contbreedData");
        this.contsettlementPolicy.setName("contsettlementPolicy");
        this.contfemaleBreedQty.setName("contfemaleBreedQty");
        this.contactualBreedDate.setName("contactualBreedDate");
        this.contactualbreedQty.setName("contactualbreedQty");
        this.contactualFemaleQty.setName("contactualFemaleQty");
        this.prmtstockingBatch.setName("prmtstockingBatch");
        this.pkbreedDate.setName("pkbreedDate");
        this.txtbreedQty.setName("txtbreedQty");
        this.prmtbreedData.setName("prmtbreedData");
        this.prmtsettlementPolicy.setName("prmtsettlementPolicy");
        this.txtfemaleBreedQty.setName("txtfemaleBreedQty");
        this.pkactualBreedDate.setName("pkactualBreedDate");
        this.txtactualbreedQty.setName("txtactualbreedQty");
        this.txtactualFemaleQty.setName("txtactualFemaleQty");
        this.prmtMarginBill.setName("prmtMarginBill");
        this.txtMarginBillAmount.setName("txtMarginBillAmount");
        this.prmtfarm.setName("prmtfarm");
        this.prmtreceiveBill.setName("prmtreceiveBill");
        this.pkcontractEndDate.setName("pkcontractEndDate");
        this.kDPanel3.setName("kDPanel3");
        this.kDPanel4.setName("kDPanel4");
        this.kdtReceiveBillEntry.setName("kdtReceiveBillEntry");
        this.txtcontractContext.setName("txtcontractContext");
        this.tBtnAudit.setName("tBtnAudit");
        this.tBtnUnAudit.setName("tBtnUnAudit");
        this.mBtnAudit.setName("mBtnAudit");
        this.mBtnUnAudit.setName("mBtnUnAudit");
        this.newSeparator3.setName("newSeparator3");
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
        // kDTabbedPane1
        // kDSeparator9
        // chkisInit		
        this.chkisInit.setText(resHelper.getString("chkisInit.text"));		
        this.chkisInit.setHorizontalAlignment(2);
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
        // kDPanel1
        // contfarmer		
        this.contfarmer.setBoundLabelText(resHelper.getString("contfarmer.boundLabelText"));		
        this.contfarmer.setBoundLabelLength(100);		
        this.contfarmer.setBoundLabelUnderline(true);		
        this.contfarmer.setVisible(true);
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
        // contMarginBill		
        this.contMarginBill.setBoundLabelText(resHelper.getString("contMarginBill.boundLabelText"));		
        this.contMarginBill.setBoundLabelLength(100);		
        this.contMarginBill.setBoundLabelUnderline(true);		
        this.contMarginBill.setVisible(false);
        // contMarginBillAmount		
        this.contMarginBillAmount.setBoundLabelText(resHelper.getString("contMarginBillAmount.boundLabelText"));		
        this.contMarginBillAmount.setBoundLabelLength(100);		
        this.contMarginBillAmount.setBoundLabelUnderline(true);		
        this.contMarginBillAmount.setVisible(true);
        // contfarm		
        this.contfarm.setBoundLabelText(resHelper.getString("contfarm.boundLabelText"));		
        this.contfarm.setBoundLabelLength(100);		
        this.contfarm.setBoundLabelUnderline(true);		
        this.contfarm.setVisible(true);
        // contreceiveBill		
        this.contreceiveBill.setBoundLabelText(resHelper.getString("contreceiveBill.boundLabelText"));		
        this.contreceiveBill.setBoundLabelLength(100);		
        this.contreceiveBill.setBoundLabelUnderline(true);		
        this.contreceiveBill.setVisible(false);
        // contcontractEndDate		
        this.contcontractEndDate.setBoundLabelText(resHelper.getString("contcontractEndDate.boundLabelText"));		
        this.contcontractEndDate.setBoundLabelLength(100);		
        this.contcontractEndDate.setBoundLabelUnderline(true);		
        this.contcontractEndDate.setVisible(true);
        // kDTabbedPane2
        // prmtfarmer		
        this.prmtfarmer.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmersQuery");		
        this.prmtfarmer.setEditable(true);		
        this.prmtfarmer.setDisplayFormat("$name$");		
        this.prmtfarmer.setEditFormat("$number$");		
        this.prmtfarmer.setCommitFormat("$number$");		
        this.prmtfarmer.setRequired(true);
        		prmtfarmer.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI prmtfarmer_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarmer_F7ListUI == null) {
					try {
						prmtfarmer_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI();
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

        // txtidentity		
        this.txtidentity.setHorizontalAlignment(2);		
        this.txtidentity.setMaxLength(80);		
        this.txtidentity.setRequired(false);
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
        // breedType		
        this.breedType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.StockingTypeEnum").toArray());		
        this.breedType.setRequired(true);
        // contstockingBatch		
        this.contstockingBatch.setBoundLabelText(resHelper.getString("contstockingBatch.boundLabelText"));		
        this.contstockingBatch.setBoundLabelLength(100);		
        this.contstockingBatch.setBoundLabelUnderline(true);		
        this.contstockingBatch.setVisible(true);
        // contbreedDate		
        this.contbreedDate.setBoundLabelText(resHelper.getString("contbreedDate.boundLabelText"));		
        this.contbreedDate.setBoundLabelLength(100);		
        this.contbreedDate.setBoundLabelUnderline(true);		
        this.contbreedDate.setVisible(true);
        // contbreedQty		
        this.contbreedQty.setBoundLabelText(resHelper.getString("contbreedQty.boundLabelText"));		
        this.contbreedQty.setBoundLabelLength(100);		
        this.contbreedQty.setBoundLabelUnderline(true);		
        this.contbreedQty.setVisible(true);
        // contbreedData		
        this.contbreedData.setBoundLabelText(resHelper.getString("contbreedData.boundLabelText"));		
        this.contbreedData.setBoundLabelLength(100);		
        this.contbreedData.setBoundLabelUnderline(true);		
        this.contbreedData.setVisible(true);
        // contsettlementPolicy		
        this.contsettlementPolicy.setBoundLabelText(resHelper.getString("contsettlementPolicy.boundLabelText"));		
        this.contsettlementPolicy.setBoundLabelLength(100);		
        this.contsettlementPolicy.setBoundLabelUnderline(true);		
        this.contsettlementPolicy.setVisible(true);
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
        // contactualbreedQty		
        this.contactualbreedQty.setBoundLabelText(resHelper.getString("contactualbreedQty.boundLabelText"));		
        this.contactualbreedQty.setBoundLabelLength(100);		
        this.contactualbreedQty.setBoundLabelUnderline(true);		
        this.contactualbreedQty.setVisible(true);
        // contactualFemaleQty		
        this.contactualFemaleQty.setBoundLabelText(resHelper.getString("contactualFemaleQty.boundLabelText"));		
        this.contactualFemaleQty.setBoundLabelLength(100);		
        this.contactualFemaleQty.setBoundLabelUnderline(true);		
        this.contactualFemaleQty.setVisible(true);
        // prmtstockingBatch		
        this.prmtstockingBatch.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.StockingBatchQuery");		
        this.prmtstockingBatch.setEditable(true);		
        this.prmtstockingBatch.setDisplayFormat("$number$");		
        this.prmtstockingBatch.setEditFormat("$number$");		
        this.prmtstockingBatch.setCommitFormat("$number$");		
        this.prmtstockingBatch.setRequired(false);		
        this.prmtstockingBatch.setEnabled(false);
        		prmtstockingBatch.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI prmtstockingBatch_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtstockingBatch_F7ListUI == null) {
					try {
						prmtstockingBatch_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtstockingBatch_F7ListUI));
					prmtstockingBatch_F7ListUI.setF7Use(true,ctx);
					prmtstockingBatch.setSelector(prmtstockingBatch_F7ListUI);
				}
			}
		});
					
        // pkbreedDate		
        this.pkbreedDate.setRequired(false);
        // txtbreedQty		
        this.txtbreedQty.setHorizontalAlignment(2);		
        this.txtbreedQty.setDataType(1);		
        this.txtbreedQty.setSupportedEmpty(true);		
        this.txtbreedQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbreedQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbreedQty.setPrecision(4);		
        this.txtbreedQty.setRequired(true);
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
					
        // prmtsettlementPolicy		
        this.prmtsettlementPolicy.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.StatementsPolicyQuery");		
        this.prmtsettlementPolicy.setEditable(true);		
        this.prmtsettlementPolicy.setDisplayFormat("$name$");		
        this.prmtsettlementPolicy.setEditFormat("$number$");		
        this.prmtsettlementPolicy.setCommitFormat("$number$");		
        this.prmtsettlementPolicy.setRequired(true);
        		prmtsettlementPolicy.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.StatementsPolicyListUI prmtsettlementPolicy_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtsettlementPolicy_F7ListUI == null) {
					try {
						prmtsettlementPolicy_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.StatementsPolicyListUI();
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
					
        prmtsettlementPolicy.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtsettlementPolicy_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
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
        this.txtfemaleBreedQty.setRequired(true);
        // pkactualBreedDate		
        this.pkactualBreedDate.setRequired(false);		
        this.pkactualBreedDate.setEnabled(false);
        // txtactualbreedQty		
        this.txtactualbreedQty.setHorizontalAlignment(2);		
        this.txtactualbreedQty.setDataType(1);		
        this.txtactualbreedQty.setSupportedEmpty(true);		
        this.txtactualbreedQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtactualbreedQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtactualbreedQty.setPrecision(4);		
        this.txtactualbreedQty.setRequired(false);		
        this.txtactualbreedQty.setEnabled(false);
        // txtactualFemaleQty		
        this.txtactualFemaleQty.setHorizontalAlignment(2);		
        this.txtactualFemaleQty.setDataType(1);		
        this.txtactualFemaleQty.setSupportedEmpty(true);		
        this.txtactualFemaleQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtactualFemaleQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtactualFemaleQty.setPrecision(4);		
        this.txtactualFemaleQty.setRequired(false);		
        this.txtactualFemaleQty.setEnabled(false);
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

        // txtMarginBillAmount		
        this.txtMarginBillAmount.setHorizontalAlignment(2);		
        this.txtMarginBillAmount.setDataType(1);		
        this.txtMarginBillAmount.setSupportedEmpty(true);		
        this.txtMarginBillAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtMarginBillAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtMarginBillAmount.setPrecision(2);		
        this.txtMarginBillAmount.setRequired(false);		
        this.txtMarginBillAmount.setEnabled(false);
        // prmtfarm		
        this.prmtfarm.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmQuery");		
        this.prmtfarm.setEditable(true);		
        this.prmtfarm.setDisplayFormat("$name$");		
        this.prmtfarm.setEditFormat("$number$");		
        this.prmtfarm.setCommitFormat("$number$");		
        this.prmtfarm.setRequired(true);
        		prmtfarm.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmListUI prmtfarm_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarm_F7ListUI == null) {
					try {
						prmtfarm_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmListUI();
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
					
        // prmtreceiveBill		
        this.prmtreceiveBill.setQueryInfo("com.kingdee.eas.fi.cas.CasReceivingBillQuery");		
        this.prmtreceiveBill.setEditable(true);		
        this.prmtreceiveBill.setDisplayFormat("$number$");		
        this.prmtreceiveBill.setEditFormat("$number$");		
        this.prmtreceiveBill.setCommitFormat("$number$");		
        this.prmtreceiveBill.setRequired(false);		
        this.prmtreceiveBill.setVisible(false);
        		EntityViewInfo eviprmtreceiveBill = new EntityViewInfo ();
		eviprmtreceiveBill.setFilter(com.kingdee.eas.framework.FrameWorkUtils.getF7FilterInfoByAuthorizedOrg(com.kingdee.eas.basedata.org.OrgType.getEnum("Company"),"company.id"));
		prmtreceiveBill.setEntityViewInfo(eviprmtreceiveBill);
					
        prmtreceiveBill.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtreceiveBill_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // pkcontractEndDate		
        this.pkcontractEndDate.setRequired(false);
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
        // mBtnAudit
        this.mBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnAudit.setText(resHelper.getString("mBtnAudit.text"));
        // mBtnUnAudit
        this.mBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnUnAudit.setText(resHelper.getString("mBtnUnAudit.text"));
        // newSeparator3
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,prmtcompany,chkisTemplate,billStatus,pkcontractDate,pkcontractEndDate,prmtperson,prmtfarmer,txtidentity,txtmobileTel,txtcontractContext,breedType,prmtstockingBatch,pkbreedDate,txtDescription,txtbreedQty,prmtMarginBill,txtMarginBillAmount,prmtbreedData,prmtsettlementPolicy,prmtfarm,txtfemaleBreedQty,chkisInit,prmtreceiveBill,prmtAuditor,pkauditTime,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,pkactualBreedDate,txtactualbreedQty,txtactualFemaleQty,kdtReceiveBillEntry}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 629));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1013, 629));
        contCreator.setBounds(new Rectangle(379, 555, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(379, 555, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(379, 583, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(379, 583, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(724, 555, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(724, 555, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateTime.setBounds(new Rectangle(724, 583, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(724, 583, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(20, 17, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(20, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(364, 17, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(364, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(364, 48, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(364, 48, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(29, 555, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(29, 555, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(708, 17, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(708, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompany.setBounds(new Rectangle(20, 48, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(20, 48, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(29, 583, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(29, 583, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator8.setBounds(new Rectangle(18, 543, 980, 8));
        this.add(kDSeparator8, new KDLayout.Constraints(18, 543, 980, 8, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        chkisTemplate.setBounds(new Rectangle(708, 48, 76, 19));
        this.add(chkisTemplate, new KDLayout.Constraints(708, 48, 76, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane1.setBounds(new Rectangle(17, 97, 981, 438));
        this.add(kDTabbedPane1, new KDLayout.Constraints(17, 97, 981, 438, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator9.setBounds(new Rectangle(5, 87, 986, 8));
        this.add(kDSeparator9, new KDLayout.Constraints(5, 87, 986, 8, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        chkisInit.setBounds(new Rectangle(849, 48, 129, 19));
        this.add(chkisInit, new KDLayout.Constraints(849, 48, 129, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
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
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 980, 405));        contfarmer.setBounds(new Rectangle(18, 59, 270, 19));
        kDPanel1.add(contfarmer, new KDLayout.Constraints(18, 59, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contidentity.setBounds(new Rectangle(355, 59, 270, 19));
        kDPanel1.add(contidentity, new KDLayout.Constraints(355, 59, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcontractDate.setBounds(new Rectangle(18, 9, 270, 19));
        kDPanel1.add(contcontractDate, new KDLayout.Constraints(18, 9, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contperson.setBounds(new Rectangle(700, 11, 270, 19));
        kDPanel1.add(contperson, new KDLayout.Constraints(700, 11, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contmobileTel.setBounds(new Rectangle(700, 59, 270, 19));
        kDPanel1.add(contmobileTel, new KDLayout.Constraints(700, 59, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbreedType.setBounds(new Rectangle(18, 34, 270, 19));
        kDPanel1.add(contbreedType, new KDLayout.Constraints(18, 34, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDPanel2.setBounds(new Rectangle(4, 113, 966, 100));
        kDPanel1.add(kDPanel2, new KDLayout.Constraints(4, 113, 966, 100, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contMarginBill.setBounds(new Rectangle(789, 84, 270, 19));
        kDPanel1.add(contMarginBill, new KDLayout.Constraints(789, 84, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contMarginBillAmount.setBounds(new Rectangle(355, 34, 270, 19));
        kDPanel1.add(contMarginBillAmount, new KDLayout.Constraints(355, 34, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarm.setBounds(new Rectangle(18, 86, 270, 19));
        kDPanel1.add(contfarm, new KDLayout.Constraints(18, 86, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contreceiveBill.setBounds(new Rectangle(678, 88, 270, 19));
        kDPanel1.add(contreceiveBill, new KDLayout.Constraints(678, 88, 270, 19, 0));
        contcontractEndDate.setBounds(new Rectangle(355, 9, 270, 19));
        kDPanel1.add(contcontractEndDate, new KDLayout.Constraints(355, 9, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane2.setBounds(new Rectangle(3, 216, 967, 192));
        kDPanel1.add(kDTabbedPane2, new KDLayout.Constraints(3, 216, 967, 192, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contfarmer
        contfarmer.setBoundEditor(prmtfarmer);
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
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(4, 113, 966, 100));        contstockingBatch.setBounds(new Rectangle(14, 37, 270, 19));
        kDPanel2.add(contstockingBatch, new KDLayout.Constraints(14, 37, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbreedDate.setBounds(new Rectangle(14, 12, 270, 19));
        kDPanel2.add(contbreedDate, new KDLayout.Constraints(14, 12, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbreedQty.setBounds(new Rectangle(345, 37, 270, 19));
        kDPanel2.add(contbreedQty, new KDLayout.Constraints(345, 37, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbreedData.setBounds(new Rectangle(345, 12, 270, 19));
        kDPanel2.add(contbreedData, new KDLayout.Constraints(345, 12, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsettlementPolicy.setBounds(new Rectangle(673, 12, 270, 19));
        kDPanel2.add(contsettlementPolicy, new KDLayout.Constraints(673, 12, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfemaleBreedQty.setBounds(new Rectangle(673, 37, 270, 19));
        kDPanel2.add(contfemaleBreedQty, new KDLayout.Constraints(673, 37, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contactualBreedDate.setBounds(new Rectangle(14, 64, 270, 19));
        kDPanel2.add(contactualBreedDate, new KDLayout.Constraints(14, 64, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contactualbreedQty.setBounds(new Rectangle(345, 64, 270, 19));
        kDPanel2.add(contactualbreedQty, new KDLayout.Constraints(345, 64, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contactualFemaleQty.setBounds(new Rectangle(673, 64, 270, 19));
        kDPanel2.add(contactualFemaleQty, new KDLayout.Constraints(673, 64, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contstockingBatch
        contstockingBatch.setBoundEditor(prmtstockingBatch);
        //contbreedDate
        contbreedDate.setBoundEditor(pkbreedDate);
        //contbreedQty
        contbreedQty.setBoundEditor(txtbreedQty);
        //contbreedData
        contbreedData.setBoundEditor(prmtbreedData);
        //contsettlementPolicy
        contsettlementPolicy.setBoundEditor(prmtsettlementPolicy);
        //contfemaleBreedQty
        contfemaleBreedQty.setBoundEditor(txtfemaleBreedQty);
        //contactualBreedDate
        contactualBreedDate.setBoundEditor(pkactualBreedDate);
        //contactualbreedQty
        contactualbreedQty.setBoundEditor(txtactualbreedQty);
        //contactualFemaleQty
        contactualFemaleQty.setBoundEditor(txtactualFemaleQty);
        //contMarginBill
        contMarginBill.setBoundEditor(prmtMarginBill);
        //contMarginBillAmount
        contMarginBillAmount.setBoundEditor(txtMarginBillAmount);
        //contfarm
        contfarm.setBoundEditor(prmtfarm);
        //contreceiveBill
        contreceiveBill.setBoundEditor(prmtreceiveBill);
        //contcontractEndDate
        contcontractEndDate.setBoundEditor(pkcontractEndDate);
        //kDTabbedPane2
        kDTabbedPane2.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        kDTabbedPane2.add(kDPanel4, resHelper.getString("kDPanel4.constraints"));
        //kDPanel3
        kDPanel3.setLayout(new KDLayout());
        kDPanel3.putClientProperty("OriginalBounds", new Rectangle(0, 0, 966, 159));        kdtReceiveBillEntry.setBounds(new Rectangle(0, -1, 963, 160));
        kdtReceiveBillEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtReceiveBillEntry,new com.kingdee.eas.farm.stocking.processbizill.BatchContractReceiveBillEntryInfo(),null,false);
        kDPanel3.add(kdtReceiveBillEntry_detailPanel, new KDLayout.Constraints(0, -1, 963, 160, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel4
        kDPanel4.setLayout(new KDLayout());
        kDPanel4.putClientProperty("OriginalBounds", new Rectangle(0, 0, 966, 159));        txtcontractContext.setBounds(new Rectangle(1, 1, 957, 157));
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
        this.toolBar.add(tBtnAudit);
        this.toolBar.add(tBtnUnAudit);
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
		dataBinder.registerBinding("isTemplate", boolean.class, this.chkisTemplate, "selected");
		dataBinder.registerBinding("isInit", boolean.class, this.chkisInit, "selected");
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
		dataBinder.registerBinding("farmer", com.kingdee.eas.farm.stocking.basedata.FarmersInfo.class, this.prmtfarmer, "data");
		dataBinder.registerBinding("identity", String.class, this.txtidentity, "text");
		dataBinder.registerBinding("contractDate", java.util.Date.class, this.pkcontractDate, "value");
		dataBinder.registerBinding("person", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtperson, "data");
		dataBinder.registerBinding("mobileTel", String.class, this.txtmobileTel, "text");
		dataBinder.registerBinding("breedType", com.kingdee.eas.farm.stocking.basedata.StockingTypeEnum.class, this.breedType, "selectedItem");
		dataBinder.registerBinding("stockingBatch", com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo.class, this.prmtstockingBatch, "data");
		dataBinder.registerBinding("breedDate", java.util.Date.class, this.pkbreedDate, "value");
		dataBinder.registerBinding("breedQty", java.math.BigDecimal.class, this.txtbreedQty, "value");
		dataBinder.registerBinding("breedData", com.kingdee.eas.farm.stocking.basedata.BreedDataInfo.class, this.prmtbreedData, "data");
		dataBinder.registerBinding("settlementPolicy", com.kingdee.eas.farm.stocking.basedata.StatementsPolicyInfo.class, this.prmtsettlementPolicy, "data");
		dataBinder.registerBinding("femaleBreedQty", java.math.BigDecimal.class, this.txtfemaleBreedQty, "value");
		dataBinder.registerBinding("actualBreedDate", java.util.Date.class, this.pkactualBreedDate, "value");
		dataBinder.registerBinding("actualbreedQty", java.math.BigDecimal.class, this.txtactualbreedQty, "value");
		dataBinder.registerBinding("actualFemaleQty", java.math.BigDecimal.class, this.txtactualFemaleQty, "value");
		dataBinder.registerBinding("MarginBill", com.kingdee.eas.farm.stocking.basebizbill.MarginBillInfo.class, this.prmtMarginBill, "data");
		dataBinder.registerBinding("MarginBillAmount", java.math.BigDecimal.class, this.txtMarginBillAmount, "value");
		dataBinder.registerBinding("farm", com.kingdee.eas.farm.stocking.basedata.FarmInfo.class, this.prmtfarm, "data");
		dataBinder.registerBinding("receiveBill", com.kingdee.eas.fi.cas.ReceivingBillInfo.class, this.prmtreceiveBill, "data");
		dataBinder.registerBinding("contractEndDate", java.util.Date.class, this.pkcontractEndDate, "value");
		dataBinder.registerBinding("ReceiveBillEntry.seq", int.class, this.kdtReceiveBillEntry, "seq.text");
		dataBinder.registerBinding("ReceiveBillEntry", com.kingdee.eas.farm.stocking.processbizill.BatchContractReceiveBillEntryInfo.class, this.kdtReceiveBillEntry, "userObject");
		dataBinder.registerBinding("ReceiveBillEntry.receiveBill", java.lang.Object.class, this.kdtReceiveBillEntry, "receiveBill.text");
		dataBinder.registerBinding("ReceiveBillEntry.receiveAmount", java.math.BigDecimal.class, this.kdtReceiveBillEntry, "receiveAmount.text");
		dataBinder.registerBinding("ReceiveBillEntry.receiveBizDate", java.util.Date.class, this.kdtReceiveBillEntry, "receiveBizDate.text");
		dataBinder.registerBinding("contractContext", String.class, this.txtcontractContext, "text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.stocking.processbizill.app.BatchContractEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.stocking.processbizill.BatchContractInfo)ov;
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
		getValidateHelper().registerBindProperty("farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("identity", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contractDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("person", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mobileTel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("stockingBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedData", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("settlementPolicy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("femaleBreedQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("actualBreedDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("actualbreedQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("actualFemaleQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MarginBill", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MarginBillAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("receiveBill", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contractEndDate", ValidateHelper.ON_SAVE);    
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
     * output prmtfarmer_Changed() method
     */
    public void prmtfarmer_Changed() throws Exception
    {
        System.out.println("prmtfarmer_Changed() Function is executed!");
            txtidentity.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtfarmer.getData(),"identity")));

    txtmobileTel.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtfarmer.getData(),"mobileTel")));


    }

    /**
     * output prmtsettlementPolicy_Changed() method
     */
    public void prmtsettlementPolicy_Changed() throws Exception
    {
        System.out.println("prmtsettlementPolicy_Changed() Function is executed!");
            prmtbreedData.setData(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtsettlementPolicy.getData(),"breedData"));


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
     * output prmtreceiveBill_Changed() method
     */
    public void prmtreceiveBill_Changed() throws Exception
    {
        System.out.println("prmtreceiveBill_Changed() Function is executed!");
            txtMarginBillAmount.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtreceiveBill.getData(),"actRecAmt")));


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
			sic.add(new SelectorItemInfo("farmer.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farmer.id"));
        	sic.add(new SelectorItemInfo("farmer.number"));
        	sic.add(new SelectorItemInfo("farmer.name"));
		}
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("stockingBatch.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("stockingBatch.id"));
        	sic.add(new SelectorItemInfo("stockingBatch.number"));
        	sic.add(new SelectorItemInfo("stockingBatch.name"));
		}
        sic.add(new SelectorItemInfo("breedDate"));
        sic.add(new SelectorItemInfo("breedQty"));
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
			sic.add(new SelectorItemInfo("settlementPolicy.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("settlementPolicy.id"));
        	sic.add(new SelectorItemInfo("settlementPolicy.number"));
        	sic.add(new SelectorItemInfo("settlementPolicy.name"));
		}
        sic.add(new SelectorItemInfo("femaleBreedQty"));
        sic.add(new SelectorItemInfo("actualBreedDate"));
        sic.add(new SelectorItemInfo("actualbreedQty"));
        sic.add(new SelectorItemInfo("actualFemaleQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("MarginBill.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("MarginBill.id"));
        	sic.add(new SelectorItemInfo("MarginBill.number"));
		}
        sic.add(new SelectorItemInfo("MarginBillAmount"));
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
			sic.add(new SelectorItemInfo("receiveBill.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("receiveBill.id"));
        	sic.add(new SelectorItemInfo("receiveBill.number"));
		}
        sic.add(new SelectorItemInfo("contractEndDate"));
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
        com.kingdee.eas.farm.stocking.processbizill.BatchContractFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.processbizill.BatchContractFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionIsTemplate_actionPerformed method
     */
    public void actionIsTemplate_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.processbizill.BatchContractFactory.getRemoteInstance().isTemplate(editData);
    }
    	

    /**
     * output actionIsInit_actionPerformed method
     */
    public void actionIsInit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.processbizill.BatchContractFactory.getRemoteInstance().isInit(editData);
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
            innerActionPerformed("eas", AbstractBatchContractEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractBatchContractEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractBatchContractEditUI.this, "ActionIsTemplate", "actionIsTemplate_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractBatchContractEditUI.this, "ActionIsInit", "actionIsInit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.stocking.processbizill.client", "BatchContractEditUI");
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
        return com.kingdee.eas.farm.stocking.processbizill.client.BatchContractEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.processbizill.BatchContractFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.processbizill.BatchContractInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.BatchContractInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/stocking/processbizill/BatchContract";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.stocking.processbizill.app.BatchContractQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtNumber.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"单据编号"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtfarmer.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养户名称"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(breedType.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖类型"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtbreedQty.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"上苗数量"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtbreedData.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"品种"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtsettlementPolicy.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"结算政策"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtfemaleBreedQty.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"母禽数量"});
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
        return kdtReceiveBillEntry;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("billStatus",new Integer(-1));
vo.put("breedType",new Integer(1));
		vo.put("breedQty",new java.math.BigDecimal(0));
		vo.put("femaleBreedQty",new java.math.BigDecimal(0));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}