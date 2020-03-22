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
public abstract class AbstractFarmerQualicationApplEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractFarmerQualicationApplEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator10;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisTemplate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmerGroup;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkonlyFarm;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkaddFarm;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contname;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsex;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contidentity;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmobileTel;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttel;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbankNo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contexperience;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator9;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedLvl;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contWoM;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contage;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnation;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteduLvl;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfamilyPeronCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbankAccountNo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBEBank;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmActualName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmerGrop;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttechnologyPerson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbankAddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmerType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contguaranty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsystemCustomer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsystemSupplier;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtname;
    protected com.kingdee.bos.ctrl.swing.KDComboBox sex;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtidentity;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtmobileTel;
    protected com.kingdee.bos.ctrl.swing.KDTextField txttel;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtaddress;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbankNo;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtexperience;
    protected com.kingdee.bos.ctrl.swing.KDComboBox breedLvl;
    protected com.kingdee.bos.ctrl.swing.KDComboBox WoM;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtage;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtnation;
    protected com.kingdee.bos.ctrl.swing.KDComboBox eduLvl;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfamilyPeronCount;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbankAccountNo;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtBEBank;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfarmActualName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmerGrop;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmttechnologyPerson;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbankAddress;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmerType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtguaranty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsystemCustomer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsystemSupplier;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtFarmEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtFarmEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contscore;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contssessmentPerson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcheckResult;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtscore;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtssessmentPerson;
    protected com.kingdee.bos.ctrl.swing.KDComboBox checkResult;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmerGroup;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnViewGuaranteeBill;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDSeparator newSeparator3;
    protected com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionIsTemplate actionIsTemplate = null;
    protected ActionIsCheckItemEntry actionIsCheckItemEntry = null;
    protected ActionViewGuaranteeBill actionViewGuaranteeBill = null;
    public final static String STATUS_AUDIT = "audit";
    /**
     * output class constructor
     */
    public AbstractFarmerQualicationApplEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractFarmerQualicationApplEditUI.class.getName());
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
        //actionIsCheckItemEntry
        this.actionIsCheckItemEntry = new ActionIsCheckItemEntry(this);
        getActionManager().registerAction("actionIsCheckItemEntry", actionIsCheckItemEntry);
        this.actionIsCheckItemEntry.setExtendProperty("canForewarn", "true");
        this.actionIsCheckItemEntry.setExtendProperty("userDefined", "false");
        this.actionIsCheckItemEntry.setExtendProperty("isObjectUpdateLock", "false");
         this.actionIsCheckItemEntry.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionIsCheckItemEntry.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
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
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDSeparator10 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.chkisTemplate = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contfarmerGroup = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkonlyFarm = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkaddFarm = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contname = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsex = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contidentity = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmobileTel = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttel = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contaddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbankNo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contexperience = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator9 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contbreedLvl = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contWoM = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contage = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contnation = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteduLvl = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfamilyPeronCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbankAccountNo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBEBank = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmActualName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmerGrop = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttechnologyPerson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbankAddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmerType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contguaranty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsystemCustomer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsystemSupplier = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtname = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.sex = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtidentity = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtmobileTel = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txttel = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtaddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbankNo = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtexperience = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.breedLvl = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.WoM = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtage = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtnation = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.eduLvl = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtfamilyPeronCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbankAccountNo = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtfarmer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtBEBank = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtfarmActualName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtfarmerGrop = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmttechnologyPerson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtbankAddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtfarmerType = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtguaranty = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtsystemCustomer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtsystemSupplier = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kdtFarmEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contscore = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contssessmentPerson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcheckResult = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtscore = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtssessmentPerson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.checkResult = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtfarmerGroup = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.tBtnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnViewGuaranteeBill = new com.kingdee.bos.ctrl.swing.KDWorkButton();
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
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contcompany.setName("contcompany");
        this.contauditTime.setName("contauditTime");
        this.kDSeparator8.setName("kDSeparator8");
        this.kDSeparator10.setName("kDSeparator10");
        this.chkisTemplate.setName("chkisTemplate");
        this.contfarmerGroup.setName("contfarmerGroup");
        this.chkonlyFarm.setName("chkonlyFarm");
        this.chkaddFarm.setName("chkaddFarm");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.billStatus.setName("billStatus");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel4.setName("kDPanel4");
        this.kDPanel2.setName("kDPanel2");
        this.contname.setName("contname");
        this.contsex.setName("contsex");
        this.contidentity.setName("contidentity");
        this.contmobileTel.setName("contmobileTel");
        this.conttel.setName("conttel");
        this.contaddress.setName("contaddress");
        this.contbankNo.setName("contbankNo");
        this.contexperience.setName("contexperience");
        this.kDSeparator9.setName("kDSeparator9");
        this.contbreedLvl.setName("contbreedLvl");
        this.contWoM.setName("contWoM");
        this.contage.setName("contage");
        this.contnation.setName("contnation");
        this.conteduLvl.setName("conteduLvl");
        this.contfamilyPeronCount.setName("contfamilyPeronCount");
        this.contbankAccountNo.setName("contbankAccountNo");
        this.contfarmer.setName("contfarmer");
        this.contBEBank.setName("contBEBank");
        this.contfarmActualName.setName("contfarmActualName");
        this.contfarmerGrop.setName("contfarmerGrop");
        this.conttechnologyPerson.setName("conttechnologyPerson");
        this.contbankAddress.setName("contbankAddress");
        this.contfarmerType.setName("contfarmerType");
        this.contguaranty.setName("contguaranty");
        this.contsystemCustomer.setName("contsystemCustomer");
        this.contsystemSupplier.setName("contsystemSupplier");
        this.txtname.setName("txtname");
        this.sex.setName("sex");
        this.txtidentity.setName("txtidentity");
        this.txtmobileTel.setName("txtmobileTel");
        this.txttel.setName("txttel");
        this.txtaddress.setName("txtaddress");
        this.txtbankNo.setName("txtbankNo");
        this.txtexperience.setName("txtexperience");
        this.breedLvl.setName("breedLvl");
        this.WoM.setName("WoM");
        this.txtage.setName("txtage");
        this.txtnation.setName("txtnation");
        this.eduLvl.setName("eduLvl");
        this.txtfamilyPeronCount.setName("txtfamilyPeronCount");
        this.txtbankAccountNo.setName("txtbankAccountNo");
        this.prmtfarmer.setName("prmtfarmer");
        this.prmtBEBank.setName("prmtBEBank");
        this.txtfarmActualName.setName("txtfarmActualName");
        this.prmtfarmerGrop.setName("prmtfarmerGrop");
        this.prmttechnologyPerson.setName("prmttechnologyPerson");
        this.txtbankAddress.setName("txtbankAddress");
        this.prmtfarmerType.setName("prmtfarmerType");
        this.prmtguaranty.setName("prmtguaranty");
        this.prmtsystemCustomer.setName("prmtsystemCustomer");
        this.prmtsystemSupplier.setName("prmtsystemSupplier");
        this.kdtFarmEntry.setName("kdtFarmEntry");
        this.kdtEntrys.setName("kdtEntrys");
        this.contscore.setName("contscore");
        this.contssessmentPerson.setName("contssessmentPerson");
        this.contcheckResult.setName("contcheckResult");
        this.txtscore.setName("txtscore");
        this.prmtssessmentPerson.setName("prmtssessmentPerson");
        this.checkResult.setName("checkResult");
        this.prmtcompany.setName("prmtcompany");
        this.pkauditTime.setName("pkauditTime");
        this.prmtfarmerGroup.setName("prmtfarmerGroup");
        this.tBtnAudit.setName("tBtnAudit");
        this.tBtnUnAudit.setName("tBtnUnAudit");
        this.btnViewGuaranteeBill.setName("btnViewGuaranteeBill");
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
        // contbillStatus		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);
        // kDTabbedPane1
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
        // kDSeparator10
        // chkisTemplate		
        this.chkisTemplate.setText(resHelper.getString("chkisTemplate.text"));		
        this.chkisTemplate.setHorizontalAlignment(2);		
        this.chkisTemplate.setVisible(false);
        // contfarmerGroup		
        this.contfarmerGroup.setBoundLabelText(resHelper.getString("contfarmerGroup.boundLabelText"));		
        this.contfarmerGroup.setBoundLabelLength(100);		
        this.contfarmerGroup.setBoundLabelUnderline(true);		
        this.contfarmerGroup.setVisible(false);
        // chkonlyFarm		
        this.chkonlyFarm.setText(resHelper.getString("chkonlyFarm.text"));		
        this.chkonlyFarm.setVisible(false);		
        this.chkonlyFarm.setHorizontalAlignment(2);
        // chkaddFarm		
        this.chkaddFarm.setText(resHelper.getString("chkaddFarm.text"));		
        this.chkaddFarm.setHorizontalAlignment(2);
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
        // billStatus		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // kDPanel1
        // kDPanel4
        // kDPanel2
        // contname		
        this.contname.setBoundLabelText(resHelper.getString("contname.boundLabelText"));		
        this.contname.setBoundLabelLength(100);		
        this.contname.setBoundLabelUnderline(true);		
        this.contname.setVisible(true);
        // contsex		
        this.contsex.setBoundLabelText(resHelper.getString("contsex.boundLabelText"));		
        this.contsex.setBoundLabelLength(100);		
        this.contsex.setBoundLabelUnderline(true);		
        this.contsex.setVisible(true);
        // contidentity		
        this.contidentity.setBoundLabelText(resHelper.getString("contidentity.boundLabelText"));		
        this.contidentity.setBoundLabelLength(100);		
        this.contidentity.setBoundLabelUnderline(true);		
        this.contidentity.setVisible(true);
        // contmobileTel		
        this.contmobileTel.setBoundLabelText(resHelper.getString("contmobileTel.boundLabelText"));		
        this.contmobileTel.setBoundLabelLength(100);		
        this.contmobileTel.setBoundLabelUnderline(true);		
        this.contmobileTel.setVisible(true);
        // conttel		
        this.conttel.setBoundLabelText(resHelper.getString("conttel.boundLabelText"));		
        this.conttel.setBoundLabelLength(100);		
        this.conttel.setBoundLabelUnderline(true);		
        this.conttel.setVisible(true);
        // contaddress		
        this.contaddress.setBoundLabelText(resHelper.getString("contaddress.boundLabelText"));		
        this.contaddress.setBoundLabelLength(100);		
        this.contaddress.setBoundLabelUnderline(true);		
        this.contaddress.setVisible(true);
        // contbankNo		
        this.contbankNo.setBoundLabelText(resHelper.getString("contbankNo.boundLabelText"));		
        this.contbankNo.setBoundLabelLength(100);		
        this.contbankNo.setBoundLabelUnderline(true);		
        this.contbankNo.setVisible(true);
        // contexperience		
        this.contexperience.setBoundLabelText(resHelper.getString("contexperience.boundLabelText"));		
        this.contexperience.setBoundLabelLength(100);		
        this.contexperience.setBoundLabelUnderline(true);		
        this.contexperience.setVisible(true);
        // kDSeparator9
        // contbreedLvl		
        this.contbreedLvl.setBoundLabelText(resHelper.getString("contbreedLvl.boundLabelText"));		
        this.contbreedLvl.setBoundLabelLength(100);		
        this.contbreedLvl.setBoundLabelUnderline(true);		
        this.contbreedLvl.setVisible(true);
        // contWoM		
        this.contWoM.setBoundLabelText(resHelper.getString("contWoM.boundLabelText"));		
        this.contWoM.setBoundLabelLength(100);		
        this.contWoM.setBoundLabelUnderline(true);		
        this.contWoM.setVisible(true);
        // contage		
        this.contage.setBoundLabelText(resHelper.getString("contage.boundLabelText"));		
        this.contage.setBoundLabelLength(100);		
        this.contage.setBoundLabelUnderline(true);		
        this.contage.setVisible(true);
        // contnation		
        this.contnation.setBoundLabelText(resHelper.getString("contnation.boundLabelText"));		
        this.contnation.setBoundLabelLength(100);		
        this.contnation.setBoundLabelUnderline(true);		
        this.contnation.setVisible(true);
        // conteduLvl		
        this.conteduLvl.setBoundLabelText(resHelper.getString("conteduLvl.boundLabelText"));		
        this.conteduLvl.setBoundLabelLength(100);		
        this.conteduLvl.setBoundLabelUnderline(true);		
        this.conteduLvl.setVisible(true);
        // contfamilyPeronCount		
        this.contfamilyPeronCount.setBoundLabelText(resHelper.getString("contfamilyPeronCount.boundLabelText"));		
        this.contfamilyPeronCount.setBoundLabelLength(100);		
        this.contfamilyPeronCount.setBoundLabelUnderline(true);		
        this.contfamilyPeronCount.setVisible(true);
        // contbankAccountNo		
        this.contbankAccountNo.setBoundLabelText(resHelper.getString("contbankAccountNo.boundLabelText"));		
        this.contbankAccountNo.setBoundLabelLength(100);		
        this.contbankAccountNo.setBoundLabelUnderline(true);		
        this.contbankAccountNo.setVisible(true);
        // contfarmer		
        this.contfarmer.setBoundLabelText(resHelper.getString("contfarmer.boundLabelText"));		
        this.contfarmer.setBoundLabelLength(100);		
        this.contfarmer.setBoundLabelUnderline(true);		
        this.contfarmer.setVisible(true);
        // contBEBank		
        this.contBEBank.setBoundLabelText(resHelper.getString("contBEBank.boundLabelText"));		
        this.contBEBank.setBoundLabelLength(100);		
        this.contBEBank.setBoundLabelUnderline(true);
        // contfarmActualName		
        this.contfarmActualName.setBoundLabelText(resHelper.getString("contfarmActualName.boundLabelText"));		
        this.contfarmActualName.setBoundLabelLength(100);		
        this.contfarmActualName.setBoundLabelUnderline(true);		
        this.contfarmActualName.setVisible(true);
        // contfarmerGrop		
        this.contfarmerGrop.setBoundLabelText(resHelper.getString("contfarmerGrop.boundLabelText"));		
        this.contfarmerGrop.setBoundLabelLength(100);		
        this.contfarmerGrop.setBoundLabelUnderline(true);		
        this.contfarmerGrop.setVisible(true);
        // conttechnologyPerson		
        this.conttechnologyPerson.setBoundLabelText(resHelper.getString("conttechnologyPerson.boundLabelText"));		
        this.conttechnologyPerson.setBoundLabelLength(100);		
        this.conttechnologyPerson.setBoundLabelUnderline(true);		
        this.conttechnologyPerson.setVisible(true);
        // contbankAddress		
        this.contbankAddress.setBoundLabelText(resHelper.getString("contbankAddress.boundLabelText"));		
        this.contbankAddress.setBoundLabelLength(100);		
        this.contbankAddress.setBoundLabelUnderline(true);		
        this.contbankAddress.setVisible(true);
        // contfarmerType		
        this.contfarmerType.setBoundLabelText(resHelper.getString("contfarmerType.boundLabelText"));		
        this.contfarmerType.setBoundLabelLength(100);		
        this.contfarmerType.setBoundLabelUnderline(true);		
        this.contfarmerType.setVisible(true);
        // contguaranty		
        this.contguaranty.setBoundLabelText(resHelper.getString("contguaranty.boundLabelText"));		
        this.contguaranty.setBoundLabelLength(100);		
        this.contguaranty.setBoundLabelUnderline(true);		
        this.contguaranty.setVisible(true);
        // contsystemCustomer		
        this.contsystemCustomer.setBoundLabelText(resHelper.getString("contsystemCustomer.boundLabelText"));		
        this.contsystemCustomer.setBoundLabelLength(100);		
        this.contsystemCustomer.setBoundLabelUnderline(true);		
        this.contsystemCustomer.setVisible(true);
        // contsystemSupplier		
        this.contsystemSupplier.setBoundLabelText(resHelper.getString("contsystemSupplier.boundLabelText"));		
        this.contsystemSupplier.setBoundLabelLength(100);		
        this.contsystemSupplier.setBoundLabelUnderline(true);		
        this.contsystemSupplier.setVisible(true);
        // txtname		
        this.txtname.setHorizontalAlignment(2);		
        this.txtname.setMaxLength(20);		
        this.txtname.setRequired(false);
        // sex		
        this.sex.addItems(EnumUtils.getEnumList("com.kingdee.eas.basedata.person.Genders").toArray());		
        this.sex.setRequired(false);
        // txtidentity		
        this.txtidentity.setHorizontalAlignment(2);		
        this.txtidentity.setMaxLength(20);		
        this.txtidentity.setRequired(false);
        // txtmobileTel		
        this.txtmobileTel.setHorizontalAlignment(2);		
        this.txtmobileTel.setMaxLength(20);		
        this.txtmobileTel.setRequired(false);
        // txttel		
        this.txttel.setHorizontalAlignment(2);		
        this.txttel.setMaxLength(20);		
        this.txttel.setRequired(false);
        // txtaddress		
        this.txtaddress.setHorizontalAlignment(2);		
        this.txtaddress.setMaxLength(200);		
        this.txtaddress.setRequired(false);
        // txtbankNo		
        this.txtbankNo.setHorizontalAlignment(2);		
        this.txtbankNo.setMaxLength(30);		
        this.txtbankNo.setRequired(false);
        // txtexperience		
        this.txtexperience.setHorizontalAlignment(2);		
        this.txtexperience.setDataType(1);		
        this.txtexperience.setSupportedEmpty(true);		
        this.txtexperience.setMinimumValue( new java.math.BigDecimal("-999.99"));		
        this.txtexperience.setMaximumValue( new java.math.BigDecimal("999.99"));		
        this.txtexperience.setPrecision(4);		
        this.txtexperience.setRequired(false);
        // breedLvl		
        this.breedLvl.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.BreedLvlEnum").toArray());		
        this.breedLvl.setRequired(false);
        // WoM		
        this.WoM.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.BreedLvlEnum").toArray());		
        this.WoM.setRequired(false);
        // txtage		
        this.txtage.setHorizontalAlignment(2);		
        this.txtage.setDataType(0);		
        this.txtage.setSupportedEmpty(true);		
        this.txtage.setRequired(false);
        // txtnation		
        this.txtnation.setHorizontalAlignment(2);		
        this.txtnation.setMaxLength(20);		
        this.txtnation.setRequired(false);
        // eduLvl		
        this.eduLvl.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.EduLvlEnum").toArray());		
        this.eduLvl.setRequired(false);
        // txtfamilyPeronCount		
        this.txtfamilyPeronCount.setHorizontalAlignment(2);		
        this.txtfamilyPeronCount.setDataType(0);		
        this.txtfamilyPeronCount.setSupportedEmpty(true);		
        this.txtfamilyPeronCount.setRequired(false);
        // txtbankAccountNo		
        this.txtbankAccountNo.setHorizontalAlignment(2);		
        this.txtbankAccountNo.setMaxLength(100);		
        this.txtbankAccountNo.setRequired(false);
        // prmtfarmer		
        this.prmtfarmer.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerQuery");		
        this.prmtfarmer.setEditable(true);		
        this.prmtfarmer.setDisplayFormat("$name$");		
        this.prmtfarmer.setEditFormat("$number$");		
        this.prmtfarmer.setCommitFormat("$number$");		
        this.prmtfarmer.setRequired(false);		
        this.prmtfarmer.setEnabled(false);
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
					
        // prmtBEBank		
        this.prmtBEBank.setQueryInfo("com.kingdee.eas.fm.be.app.BEBankQuery");		
        this.prmtBEBank.setEditable(true);		
        this.prmtBEBank.setDisplayFormat("$name$");		
        this.prmtBEBank.setEditFormat("$number$");		
        this.prmtBEBank.setCommitFormat("$number$");		
        this.prmtBEBank.setRequired(false);
        // txtfarmActualName		
        this.txtfarmActualName.setHorizontalAlignment(2);		
        this.txtfarmActualName.setMaxLength(100);		
        this.txtfarmActualName.setRequired(false);
        // prmtfarmerGrop		
        this.prmtfarmerGrop.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerQuery");		
        this.prmtfarmerGrop.setEditable(true);		
        this.prmtfarmerGrop.setDisplayFormat("$name$");		
        this.prmtfarmerGrop.setEditFormat("$number$");		
        this.prmtfarmerGrop.setCommitFormat("$number$");		
        this.prmtfarmerGrop.setRequired(false);
        		prmtfarmerGrop.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.FarmerListUI prmtfarmerGrop_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarmerGrop_F7ListUI == null) {
					try {
						prmtfarmerGrop_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.FarmerListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtfarmerGrop_F7ListUI));
					prmtfarmerGrop_F7ListUI.setF7Use(true,ctx);
					prmtfarmerGrop.setSelector(prmtfarmerGrop_F7ListUI);
				}
			}
		});
					
        // prmttechnologyPerson		
        this.prmttechnologyPerson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmttechnologyPerson.setEditable(true);		
        this.prmttechnologyPerson.setDisplayFormat("$name$");		
        this.prmttechnologyPerson.setEditFormat("$number$");		
        this.prmttechnologyPerson.setCommitFormat("$number$");		
        this.prmttechnologyPerson.setRequired(false);
        // txtbankAddress		
        this.txtbankAddress.setHorizontalAlignment(2);		
        this.txtbankAddress.setMaxLength(100);		
        this.txtbankAddress.setRequired(false);
        // prmtfarmerType		
        this.prmtfarmerType.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerTypeQuery");		
        this.prmtfarmerType.setEditable(true);		
        this.prmtfarmerType.setDisplayFormat("$name$");		
        this.prmtfarmerType.setEditFormat("$number$");		
        this.prmtfarmerType.setCommitFormat("$number$");		
        this.prmtfarmerType.setRequired(false);
        		EntityViewInfo eviprmtfarmerType = new EntityViewInfo ();
		eviprmtfarmerType.setFilter(com.kingdee.eas.framework.FrameWorkUtils.getF7FilterInfoByAuthorizedOrg(com.kingdee.eas.basedata.org.OrgType.getEnum("Company"),"FICompany.id"));
		prmtfarmerType.setEntityViewInfo(eviprmtfarmerType);
					
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
					
        // prmtsystemCustomer		
        this.prmtsystemCustomer.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.CustomerInfoQuery");		
        this.prmtsystemCustomer.setEditable(true);		
        this.prmtsystemCustomer.setDisplayFormat("$name$");		
        this.prmtsystemCustomer.setEditFormat("$number$");		
        this.prmtsystemCustomer.setCommitFormat("$number$");		
        this.prmtsystemCustomer.setRequired(false);
        // prmtsystemSupplier		
        this.prmtsystemSupplier.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.PSupplierQuery");		
        this.prmtsystemSupplier.setEditable(true);		
        this.prmtsystemSupplier.setDisplayFormat("$name$");		
        this.prmtsystemSupplier.setEditFormat("$number$");		
        this.prmtsystemSupplier.setCommitFormat("$number$");		
        this.prmtsystemSupplier.setRequired(false);
        // kdtFarmEntry
		String kdtFarmEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol14\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"farm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"farmQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"costCenter\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"farmTypea\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"5\" /><t:Column t:key=\"area\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"6\" t:styleID=\"sCol6\" /><t:Column t:key=\"floorArea\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"7\" t:styleID=\"sCol7\" /><t:Column t:key=\"succahQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" t:styleID=\"sCol8\" /><t:Column t:key=\"address\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"9\" /><t:Column t:key=\"farmGrop\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"10\" /><t:Column t:key=\"mileStd\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"recyMiles\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"farmGroup\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"transPrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"mnemonicCode\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{farm}</t:Cell><t:Cell>$Resource{name}</t:Cell><t:Cell>$Resource{farmQty}</t:Cell><t:Cell>$Resource{costCenter}</t:Cell><t:Cell>$Resource{farmTypea}</t:Cell><t:Cell>$Resource{area}</t:Cell><t:Cell>$Resource{floorArea}</t:Cell><t:Cell>$Resource{succahQty}</t:Cell><t:Cell>$Resource{address}</t:Cell><t:Cell>$Resource{farmGrop}</t:Cell><t:Cell>$Resource{mileStd}</t:Cell><t:Cell>$Resource{recyMiles}</t:Cell><t:Cell>$Resource{farmGroup}</t:Cell><t:Cell>$Resource{transPrice}</t:Cell><t:Cell>$Resource{mnemonicCode}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtFarmEntry.setFormatXml(resHelper.translateString("kdtFarmEntry",kdtFarmEntryStrXML));

                this.kdtFarmEntry.putBindContents("editData",new String[] {"seq","farm","name","farmQty","costCenter","farmTypea","area","floorArea","succahQty","address","farmGrop","mileStd","recyMiles","farmGroup","transPrice","mnemonicCode"});


        this.kdtFarmEntry.checkParsed();
        final KDBizPromptBox kdtFarmEntry_farm_PromptBox = new KDBizPromptBox();
        kdtFarmEntry_farm_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmQuery");
        kdtFarmEntry_farm_PromptBox.setVisible(true);
        kdtFarmEntry_farm_PromptBox.setEditable(true);
        kdtFarmEntry_farm_PromptBox.setDisplayFormat("$number$");
        kdtFarmEntry_farm_PromptBox.setEditFormat("$number$");
        kdtFarmEntry_farm_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtFarmEntry_farm_CellEditor = new KDTDefaultCellEditor(kdtFarmEntry_farm_PromptBox);
        this.kdtFarmEntry.getColumn("farm").setEditor(kdtFarmEntry_farm_CellEditor);
        ObjectValueRender kdtFarmEntry_farm_OVR = new ObjectValueRender();
        kdtFarmEntry_farm_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtFarmEntry.getColumn("farm").setRenderer(kdtFarmEntry_farm_OVR);
        			kdtFarmEntry_farm_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.FarmListUI kdtFarmEntry_farm_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtFarmEntry_farm_PromptBox_F7ListUI == null) {
					try {
						kdtFarmEntry_farm_PromptBox_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.FarmListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtFarmEntry_farm_PromptBox_F7ListUI));
					kdtFarmEntry_farm_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtFarmEntry_farm_PromptBox.setSelector(kdtFarmEntry_farm_PromptBox_F7ListUI);
				}
			}
		});
					
        KDTextField kdtFarmEntry_name_TextField = new KDTextField();
        kdtFarmEntry_name_TextField.setName("kdtFarmEntry_name_TextField");
        kdtFarmEntry_name_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtFarmEntry_name_CellEditor = new KDTDefaultCellEditor(kdtFarmEntry_name_TextField);
        this.kdtFarmEntry.getColumn("name").setEditor(kdtFarmEntry_name_CellEditor);
        KDFormattedTextField kdtFarmEntry_farmQty_TextField = new KDFormattedTextField();
        kdtFarmEntry_farmQty_TextField.setName("kdtFarmEntry_farmQty_TextField");
        kdtFarmEntry_farmQty_TextField.setVisible(true);
        kdtFarmEntry_farmQty_TextField.setEditable(true);
        kdtFarmEntry_farmQty_TextField.setHorizontalAlignment(2);
        kdtFarmEntry_farmQty_TextField.setDataType(1);
        	kdtFarmEntry_farmQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtFarmEntry_farmQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtFarmEntry_farmQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtFarmEntry_farmQty_CellEditor = new KDTDefaultCellEditor(kdtFarmEntry_farmQty_TextField);
        this.kdtFarmEntry.getColumn("farmQty").setEditor(kdtFarmEntry_farmQty_CellEditor);
        final KDBizPromptBox kdtFarmEntry_costCenter_PromptBox = new KDBizPromptBox();
        kdtFarmEntry_costCenter_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.CostCenterItemQuery");
        kdtFarmEntry_costCenter_PromptBox.setVisible(true);
        kdtFarmEntry_costCenter_PromptBox.setEditable(true);
        kdtFarmEntry_costCenter_PromptBox.setDisplayFormat("$number$");
        kdtFarmEntry_costCenter_PromptBox.setEditFormat("$number$");
        kdtFarmEntry_costCenter_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtFarmEntry_costCenter_CellEditor = new KDTDefaultCellEditor(kdtFarmEntry_costCenter_PromptBox);
        this.kdtFarmEntry.getColumn("costCenter").setEditor(kdtFarmEntry_costCenter_CellEditor);
        ObjectValueRender kdtFarmEntry_costCenter_OVR = new ObjectValueRender();
        kdtFarmEntry_costCenter_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtFarmEntry.getColumn("costCenter").setRenderer(kdtFarmEntry_costCenter_OVR);
        KDComboBox kdtFarmEntry_farmTypea_ComboBox = new KDComboBox();
        kdtFarmEntry_farmTypea_ComboBox.setName("kdtFarmEntry_farmTypea_ComboBox");
        kdtFarmEntry_farmTypea_ComboBox.setVisible(true);
        kdtFarmEntry_farmTypea_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.FarmsType").toArray());
        KDTDefaultCellEditor kdtFarmEntry_farmTypea_CellEditor = new KDTDefaultCellEditor(kdtFarmEntry_farmTypea_ComboBox);
        this.kdtFarmEntry.getColumn("farmTypea").setEditor(kdtFarmEntry_farmTypea_CellEditor);
        KDFormattedTextField kdtFarmEntry_area_TextField = new KDFormattedTextField();
        kdtFarmEntry_area_TextField.setName("kdtFarmEntry_area_TextField");
        kdtFarmEntry_area_TextField.setVisible(true);
        kdtFarmEntry_area_TextField.setEditable(true);
        kdtFarmEntry_area_TextField.setHorizontalAlignment(2);
        kdtFarmEntry_area_TextField.setDataType(1);
        	kdtFarmEntry_area_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtFarmEntry_area_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtFarmEntry_area_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtFarmEntry_area_CellEditor = new KDTDefaultCellEditor(kdtFarmEntry_area_TextField);
        this.kdtFarmEntry.getColumn("area").setEditor(kdtFarmEntry_area_CellEditor);
        KDFormattedTextField kdtFarmEntry_floorArea_TextField = new KDFormattedTextField();
        kdtFarmEntry_floorArea_TextField.setName("kdtFarmEntry_floorArea_TextField");
        kdtFarmEntry_floorArea_TextField.setVisible(true);
        kdtFarmEntry_floorArea_TextField.setEditable(true);
        kdtFarmEntry_floorArea_TextField.setHorizontalAlignment(2);
        kdtFarmEntry_floorArea_TextField.setDataType(1);
        	kdtFarmEntry_floorArea_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtFarmEntry_floorArea_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtFarmEntry_floorArea_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtFarmEntry_floorArea_CellEditor = new KDTDefaultCellEditor(kdtFarmEntry_floorArea_TextField);
        this.kdtFarmEntry.getColumn("floorArea").setEditor(kdtFarmEntry_floorArea_CellEditor);
        KDFormattedTextField kdtFarmEntry_succahQty_TextField = new KDFormattedTextField();
        kdtFarmEntry_succahQty_TextField.setName("kdtFarmEntry_succahQty_TextField");
        kdtFarmEntry_succahQty_TextField.setVisible(true);
        kdtFarmEntry_succahQty_TextField.setEditable(true);
        kdtFarmEntry_succahQty_TextField.setHorizontalAlignment(2);
        kdtFarmEntry_succahQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtFarmEntry_succahQty_CellEditor = new KDTDefaultCellEditor(kdtFarmEntry_succahQty_TextField);
        this.kdtFarmEntry.getColumn("succahQty").setEditor(kdtFarmEntry_succahQty_CellEditor);
        KDTextField kdtFarmEntry_address_TextField = new KDTextField();
        kdtFarmEntry_address_TextField.setName("kdtFarmEntry_address_TextField");
        kdtFarmEntry_address_TextField.setMaxLength(200);
        KDTDefaultCellEditor kdtFarmEntry_address_CellEditor = new KDTDefaultCellEditor(kdtFarmEntry_address_TextField);
        this.kdtFarmEntry.getColumn("address").setEditor(kdtFarmEntry_address_CellEditor);
        KDFormattedTextField kdtFarmEntry_mileStd_TextField = new KDFormattedTextField();
        kdtFarmEntry_mileStd_TextField.setName("kdtFarmEntry_mileStd_TextField");
        kdtFarmEntry_mileStd_TextField.setVisible(true);
        kdtFarmEntry_mileStd_TextField.setEditable(true);
        kdtFarmEntry_mileStd_TextField.setHorizontalAlignment(2);
        kdtFarmEntry_mileStd_TextField.setDataType(1);
        	kdtFarmEntry_mileStd_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtFarmEntry_mileStd_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtFarmEntry_mileStd_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtFarmEntry_mileStd_CellEditor = new KDTDefaultCellEditor(kdtFarmEntry_mileStd_TextField);
        this.kdtFarmEntry.getColumn("mileStd").setEditor(kdtFarmEntry_mileStd_CellEditor);
        KDFormattedTextField kdtFarmEntry_recyMiles_TextField = new KDFormattedTextField();
        kdtFarmEntry_recyMiles_TextField.setName("kdtFarmEntry_recyMiles_TextField");
        kdtFarmEntry_recyMiles_TextField.setVisible(true);
        kdtFarmEntry_recyMiles_TextField.setEditable(true);
        kdtFarmEntry_recyMiles_TextField.setHorizontalAlignment(2);
        kdtFarmEntry_recyMiles_TextField.setDataType(1);
        	kdtFarmEntry_recyMiles_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtFarmEntry_recyMiles_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtFarmEntry_recyMiles_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtFarmEntry_recyMiles_CellEditor = new KDTDefaultCellEditor(kdtFarmEntry_recyMiles_TextField);
        this.kdtFarmEntry.getColumn("recyMiles").setEditor(kdtFarmEntry_recyMiles_CellEditor);
        KDFormattedTextField kdtFarmEntry_transPrice_TextField = new KDFormattedTextField();
        kdtFarmEntry_transPrice_TextField.setName("kdtFarmEntry_transPrice_TextField");
        kdtFarmEntry_transPrice_TextField.setVisible(true);
        kdtFarmEntry_transPrice_TextField.setEditable(true);
        kdtFarmEntry_transPrice_TextField.setHorizontalAlignment(2);
        kdtFarmEntry_transPrice_TextField.setDataType(1);
        	kdtFarmEntry_transPrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtFarmEntry_transPrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtFarmEntry_transPrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtFarmEntry_transPrice_CellEditor = new KDTDefaultCellEditor(kdtFarmEntry_transPrice_TextField);
        this.kdtFarmEntry.getColumn("transPrice").setEditor(kdtFarmEntry_transPrice_CellEditor);
        KDTextField kdtFarmEntry_mnemonicCode_TextField = new KDTextField();
        kdtFarmEntry_mnemonicCode_TextField.setName("kdtFarmEntry_mnemonicCode_TextField");
        kdtFarmEntry_mnemonicCode_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtFarmEntry_mnemonicCode_CellEditor = new KDTDefaultCellEditor(kdtFarmEntry_mnemonicCode_TextField);
        this.kdtFarmEntry.getColumn("mnemonicCode").setEditor(kdtFarmEntry_mnemonicCode_CellEditor);
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"checkItem\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"checkContent\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"checkResult\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{checkItem}</t:Cell><t:Cell>$Resource{checkContent}</t:Cell><t:Cell>$Resource{checkResult}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtEntrys.putBindContents("editData",new String[] {"id","checkItem","checkContent","checkResult"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_checkItem_PromptBox = new KDBizPromptBox();
        kdtEntrys_checkItem_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmingCheckItemQuery");
        kdtEntrys_checkItem_PromptBox.setVisible(true);
        kdtEntrys_checkItem_PromptBox.setEditable(true);
        kdtEntrys_checkItem_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_checkItem_PromptBox.setEditFormat("$number$");
        kdtEntrys_checkItem_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_checkItem_CellEditor = new KDTDefaultCellEditor(kdtEntrys_checkItem_PromptBox);
        this.kdtEntrys.getColumn("checkItem").setEditor(kdtEntrys_checkItem_CellEditor);
        ObjectValueRender kdtEntrys_checkItem_OVR = new ObjectValueRender();
        kdtEntrys_checkItem_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("checkItem").setRenderer(kdtEntrys_checkItem_OVR);
        			EntityViewInfo evikdtEntrys_checkItem_PromptBox = new EntityViewInfo ();
		evikdtEntrys_checkItem_PromptBox.setFilter(com.kingdee.eas.framework.FrameWorkUtils.getF7FilterInfoByAuthorizedOrg(com.kingdee.eas.basedata.org.OrgType.getEnum("Company"),"FICompany.id"));
		kdtEntrys_checkItem_PromptBox.setEntityViewInfo(evikdtEntrys_checkItem_PromptBox);
					
        KDTextField kdtEntrys_checkContent_TextField = new KDTextField();
        kdtEntrys_checkContent_TextField.setName("kdtEntrys_checkContent_TextField");
        kdtEntrys_checkContent_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_checkContent_CellEditor = new KDTDefaultCellEditor(kdtEntrys_checkContent_TextField);
        this.kdtEntrys.getColumn("checkContent").setEditor(kdtEntrys_checkContent_CellEditor);
        KDComboBox kdtEntrys_checkResult_ComboBox = new KDComboBox();
        kdtEntrys_checkResult_ComboBox.setName("kdtEntrys_checkResult_ComboBox");
        kdtEntrys_checkResult_ComboBox.setVisible(true);
        kdtEntrys_checkResult_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.CheckResultEnum").toArray());
        KDTDefaultCellEditor kdtEntrys_checkResult_CellEditor = new KDTDefaultCellEditor(kdtEntrys_checkResult_ComboBox);
        this.kdtEntrys.getColumn("checkResult").setEditor(kdtEntrys_checkResult_CellEditor);
        // contscore		
        this.contscore.setBoundLabelText(resHelper.getString("contscore.boundLabelText"));		
        this.contscore.setBoundLabelLength(100);		
        this.contscore.setBoundLabelUnderline(true);		
        this.contscore.setVisible(true);
        // contssessmentPerson		
        this.contssessmentPerson.setBoundLabelText(resHelper.getString("contssessmentPerson.boundLabelText"));		
        this.contssessmentPerson.setBoundLabelLength(100);		
        this.contssessmentPerson.setBoundLabelUnderline(true);		
        this.contssessmentPerson.setVisible(true);
        // contcheckResult		
        this.contcheckResult.setBoundLabelText(resHelper.getString("contcheckResult.boundLabelText"));		
        this.contcheckResult.setBoundLabelLength(100);		
        this.contcheckResult.setBoundLabelUnderline(true);		
        this.contcheckResult.setVisible(true);
        // txtscore		
        this.txtscore.setHorizontalAlignment(2);		
        this.txtscore.setDataType(1);		
        this.txtscore.setSupportedEmpty(true);		
        this.txtscore.setMinimumValue( new java.math.BigDecimal("-999.99"));		
        this.txtscore.setMaximumValue( new java.math.BigDecimal("999.99"));		
        this.txtscore.setPrecision(2);		
        this.txtscore.setRequired(false);
        // prmtssessmentPerson		
        this.prmtssessmentPerson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtssessmentPerson.setEditable(true);		
        this.prmtssessmentPerson.setDisplayFormat("$name$");		
        this.prmtssessmentPerson.setEditFormat("$number$");		
        this.prmtssessmentPerson.setCommitFormat("$number$");		
        this.prmtssessmentPerson.setRequired(false);
        // checkResult		
        this.checkResult.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.CheckResultEnum").toArray());		
        this.checkResult.setRequired(false);
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
        // prmtfarmerGroup		
        this.prmtfarmerGroup.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtfarmerGroup.setEditable(true);		
        this.prmtfarmerGroup.setDisplayFormat("$name$");		
        this.prmtfarmerGroup.setEditFormat("$number$");		
        this.prmtfarmerGroup.setCommitFormat("$number$");		
        this.prmtfarmerGroup.setRequired(false);		
        this.prmtfarmerGroup.setVisible(false);
        // tBtnAudit
        this.tBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnAudit.setText(resHelper.getString("tBtnAudit.text"));
        // tBtnUnAudit
        this.tBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnUnAudit.setText(resHelper.getString("tBtnUnAudit.text"));
        // btnViewGuaranteeBill
        this.btnViewGuaranteeBill.setAction((IItemAction)ActionProxyFactory.getProxy(actionViewGuaranteeBill, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnViewGuaranteeBill.setText(resHelper.getString("btnViewGuaranteeBill.text"));		
        this.btnViewGuaranteeBill.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_linkviewbill"));
        // mBtnAudit
        this.mBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnAudit.setText(resHelper.getString("mBtnAudit.text"));
        // mBtnUnAudit
        this.mBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnUnAudit.setText(resHelper.getString("mBtnUnAudit.text"));
        // newSeparator3
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,billStatus,prmtcompany,txtname,sex,txtidentity,txtmobileTel,txttel,txtaddress,txtbankNo,pkauditTime,txtexperience,breedLvl,txtscore,prmtssessmentPerson,chkisTemplate,WoM,checkResult,txtage,txtnation,eduLvl,txtfamilyPeronCount,txtbankAccountNo,prmtfarmer,prmtfarmerGroup,prmtBEBank,txtfarmActualName,prmtfarmerGrop,prmttechnologyPerson,txtbankAddress,chkonlyFarm,prmtfarmerType,prmtguaranty,chkaddFarm,prmtsystemCustomer,prmtsystemSupplier,kdtEntrys,kdtFarmEntry}));
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
        contCreator.setBounds(new Rectangle(380, 552, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(380, 552, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(731, 552, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(731, 552, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(380, 579, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(380, 579, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(731, 579, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(731, 579, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(20, 20, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(20, 20, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(355, 20, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(355, 20, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(355, 56, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(355, 56, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(30, 552, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(30, 552, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(690, 20, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(690, 20, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDTabbedPane1.setBounds(new Rectangle(22, 114, 979, 413));
        this.add(kDTabbedPane1, new KDLayout.Constraints(22, 114, 979, 413, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompany.setBounds(new Rectangle(20, 56, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(20, 56, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(30, 579, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(30, 579, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator8.setBounds(new Rectangle(20, 538, 980, 10));
        this.add(kDSeparator8, new KDLayout.Constraints(20, 538, 980, 10, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator10.setBounds(new Rectangle(21, 94, 955, 10));
        this.add(kDSeparator10, new KDLayout.Constraints(21, 94, 955, 10, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        chkisTemplate.setBounds(new Rectangle(996, 68, 86, 19));
        this.add(chkisTemplate, new KDLayout.Constraints(996, 68, 86, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfarmerGroup.setBounds(new Rectangle(999, 87, 270, 19));
        this.add(contfarmerGroup, new KDLayout.Constraints(999, 87, 270, 19, 0));
        chkonlyFarm.setBounds(new Rectangle(985, 36, 270, 19));
        this.add(chkonlyFarm, new KDLayout.Constraints(985, 36, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkaddFarm.setBounds(new Rectangle(690, 56, 270, 19));
        this.add(chkaddFarm, new KDLayout.Constraints(690, 56, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel4, resHelper.getString("kDPanel4.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 978, 380));        contname.setBounds(new Rectangle(16, 28, 270, 19));
        kDPanel1.add(contname, new KDLayout.Constraints(16, 28, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsex.setBounds(new Rectangle(336, 28, 270, 19));
        kDPanel1.add(contsex, new KDLayout.Constraints(336, 28, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contidentity.setBounds(new Rectangle(656, 28, 270, 19));
        kDPanel1.add(contidentity, new KDLayout.Constraints(656, 28, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contmobileTel.setBounds(new Rectangle(16, 133, 270, 19));
        kDPanel1.add(contmobileTel, new KDLayout.Constraints(16, 133, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttel.setBounds(new Rectangle(336, 133, 270, 19));
        kDPanel1.add(conttel, new KDLayout.Constraints(336, 133, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contaddress.setBounds(new Rectangle(16, 168, 909, 19));
        kDPanel1.add(contaddress, new KDLayout.Constraints(16, 168, 909, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contbankNo.setBounds(new Rectangle(336, 274, 270, 19));
        kDPanel1.add(contbankNo, new KDLayout.Constraints(336, 274, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contexperience.setBounds(new Rectangle(656, 203, 270, 19));
        kDPanel1.add(contexperience, new KDLayout.Constraints(656, 203, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator9.setBounds(new Rectangle(2, 267, 923, 8));
        kDPanel1.add(kDSeparator9, new KDLayout.Constraints(2, 267, 923, 8, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contbreedLvl.setBounds(new Rectangle(336, 203, 270, 19));
        kDPanel1.add(contbreedLvl, new KDLayout.Constraints(336, 203, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contWoM.setBounds(new Rectangle(16, 238, 270, 19));
        kDPanel1.add(contWoM, new KDLayout.Constraints(16, 238, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contage.setBounds(new Rectangle(16, 63, 270, 19));
        kDPanel1.add(contage, new KDLayout.Constraints(16, 63, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contnation.setBounds(new Rectangle(336, 63, 270, 19));
        kDPanel1.add(contnation, new KDLayout.Constraints(336, 63, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conteduLvl.setBounds(new Rectangle(656, 63, 270, 19));
        kDPanel1.add(conteduLvl, new KDLayout.Constraints(656, 63, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfamilyPeronCount.setBounds(new Rectangle(16, 98, 270, 19));
        kDPanel1.add(contfamilyPeronCount, new KDLayout.Constraints(16, 98, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbankAccountNo.setBounds(new Rectangle(16, 311, 270, 19));
        kDPanel1.add(contbankAccountNo, new KDLayout.Constraints(16, 311, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmer.setBounds(new Rectangle(656, 274, 270, 19));
        kDPanel1.add(contfarmer, new KDLayout.Constraints(656, 274, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contBEBank.setBounds(new Rectangle(16, 273, 270, 19));
        kDPanel1.add(contBEBank, new KDLayout.Constraints(16, 273, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmActualName.setBounds(new Rectangle(336, 98, 270, 19));
        kDPanel1.add(contfarmActualName, new KDLayout.Constraints(336, 98, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmerGrop.setBounds(new Rectangle(656, 133, 270, 19));
        kDPanel1.add(contfarmerGrop, new KDLayout.Constraints(656, 133, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conttechnologyPerson.setBounds(new Rectangle(656, 98, 270, 19));
        kDPanel1.add(conttechnologyPerson, new KDLayout.Constraints(656, 98, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbankAddress.setBounds(new Rectangle(336, 311, 593, 19));
        kDPanel1.add(contbankAddress, new KDLayout.Constraints(336, 311, 593, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfarmerType.setBounds(new Rectangle(16, 203, 270, 19));
        kDPanel1.add(contfarmerType, new KDLayout.Constraints(16, 203, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contguaranty.setBounds(new Rectangle(336, 238, 270, 19));
        kDPanel1.add(contguaranty, new KDLayout.Constraints(336, 238, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsystemCustomer.setBounds(new Rectangle(17, 342, 270, 19));
        kDPanel1.add(contsystemCustomer, new KDLayout.Constraints(17, 342, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsystemSupplier.setBounds(new Rectangle(336, 342, 270, 19));
        kDPanel1.add(contsystemSupplier, new KDLayout.Constraints(336, 342, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contname
        contname.setBoundEditor(txtname);
        //contsex
        contsex.setBoundEditor(sex);
        //contidentity
        contidentity.setBoundEditor(txtidentity);
        //contmobileTel
        contmobileTel.setBoundEditor(txtmobileTel);
        //conttel
        conttel.setBoundEditor(txttel);
        //contaddress
        contaddress.setBoundEditor(txtaddress);
        //contbankNo
        contbankNo.setBoundEditor(txtbankNo);
        //contexperience
        contexperience.setBoundEditor(txtexperience);
        //contbreedLvl
        contbreedLvl.setBoundEditor(breedLvl);
        //contWoM
        contWoM.setBoundEditor(WoM);
        //contage
        contage.setBoundEditor(txtage);
        //contnation
        contnation.setBoundEditor(txtnation);
        //conteduLvl
        conteduLvl.setBoundEditor(eduLvl);
        //contfamilyPeronCount
        contfamilyPeronCount.setBoundEditor(txtfamilyPeronCount);
        //contbankAccountNo
        contbankAccountNo.setBoundEditor(txtbankAccountNo);
        //contfarmer
        contfarmer.setBoundEditor(prmtfarmer);
        //contBEBank
        contBEBank.setBoundEditor(prmtBEBank);
        //contfarmActualName
        contfarmActualName.setBoundEditor(txtfarmActualName);
        //contfarmerGrop
        contfarmerGrop.setBoundEditor(prmtfarmerGrop);
        //conttechnologyPerson
        conttechnologyPerson.setBoundEditor(prmttechnologyPerson);
        //contbankAddress
        contbankAddress.setBoundEditor(txtbankAddress);
        //contfarmerType
        contfarmerType.setBoundEditor(prmtfarmerType);
        //contguaranty
        contguaranty.setBoundEditor(prmtguaranty);
        //contsystemCustomer
        contsystemCustomer.setBoundEditor(prmtsystemCustomer);
        //contsystemSupplier
        contsystemSupplier.setBoundEditor(prmtsystemSupplier);
        //kDPanel4
        kDPanel4.setLayout(new KDLayout());
        kDPanel4.putClientProperty("OriginalBounds", new Rectangle(0, 0, 978, 380));        kdtFarmEntry.setBounds(new Rectangle(2, 1, 969, 375));
        kdtFarmEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtFarmEntry,new com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplFarmEntryInfo(),null,false);
        kDPanel4.add(kdtFarmEntry_detailPanel, new KDLayout.Constraints(2, 1, 969, 375, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtFarmEntry_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("farmTypea","0");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 978, 380));        kdtEntrys.setBounds(new Rectangle(1, 0, 968, 319));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplEntryInfo(),null,false);
        kDPanel2.add(kdtEntrys_detailPanel, new KDLayout.Constraints(1, 0, 968, 319, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("checkResult",new Integer(1));
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        contscore.setBounds(new Rectangle(15, 338, 270, 19));
        kDPanel2.add(contscore, new KDLayout.Constraints(15, 338, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contssessmentPerson.setBounds(new Rectangle(684, 338, 270, 19));
        kDPanel2.add(contssessmentPerson, new KDLayout.Constraints(684, 338, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcheckResult.setBounds(new Rectangle(349, 338, 270, 19));
        kDPanel2.add(contcheckResult, new KDLayout.Constraints(349, 338, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contscore
        contscore.setBoundEditor(txtscore);
        //contssessmentPerson
        contssessmentPerson.setBoundEditor(prmtssessmentPerson);
        //contcheckResult
        contcheckResult.setBoundEditor(checkResult);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contfarmerGroup
        contfarmerGroup.setBoundEditor(prmtfarmerGroup);

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
        this.toolBar.add(btnViewGuaranteeBill);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("isTemplate", boolean.class, this.chkisTemplate, "selected");
		dataBinder.registerBinding("onlyFarm", boolean.class, this.chkonlyFarm, "selected");
		dataBinder.registerBinding("addFarm", boolean.class, this.chkaddFarm, "selected");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("name", String.class, this.txtname, "text");
		dataBinder.registerBinding("sex", com.kingdee.eas.basedata.person.Genders.class, this.sex, "selectedItem");
		dataBinder.registerBinding("identity", String.class, this.txtidentity, "text");
		dataBinder.registerBinding("mobileTel", String.class, this.txtmobileTel, "text");
		dataBinder.registerBinding("tel", String.class, this.txttel, "text");
		dataBinder.registerBinding("address", String.class, this.txtaddress, "text");
		dataBinder.registerBinding("bankNo", String.class, this.txtbankNo, "text");
		dataBinder.registerBinding("experience", java.math.BigDecimal.class, this.txtexperience, "value");
		dataBinder.registerBinding("breedLvl", com.kingdee.eas.farm.stocking.basedata.BreedLvlEnum.class, this.breedLvl, "selectedItem");
		dataBinder.registerBinding("WoM", com.kingdee.eas.farm.stocking.basedata.BreedLvlEnum.class, this.WoM, "selectedItem");
		dataBinder.registerBinding("age", int.class, this.txtage, "value");
		dataBinder.registerBinding("nation", String.class, this.txtnation, "text");
		dataBinder.registerBinding("eduLvl", com.kingdee.eas.farm.stocking.basedata.EduLvlEnum.class, this.eduLvl, "selectedItem");
		dataBinder.registerBinding("familyPeronCount", int.class, this.txtfamilyPeronCount, "value");
		dataBinder.registerBinding("bankAccountNo", String.class, this.txtbankAccountNo, "text");
		dataBinder.registerBinding("farmer", com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo.class, this.prmtfarmer, "data");
		dataBinder.registerBinding("BEBank", com.kingdee.eas.fm.be.BEBankInfo.class, this.prmtBEBank, "data");
		dataBinder.registerBinding("farmActualName", String.class, this.txtfarmActualName, "text");
		dataBinder.registerBinding("farmerGrop", com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo.class, this.prmtfarmerGrop, "data");
		dataBinder.registerBinding("technologyPerson", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmttechnologyPerson, "data");
		dataBinder.registerBinding("bankAddress", String.class, this.txtbankAddress, "text");
		dataBinder.registerBinding("farmerType", com.kingdee.eas.farm.carnivorous.basedata.FarmerTypeInfo.class, this.prmtfarmerType, "data");
		dataBinder.registerBinding("guaranty", com.kingdee.eas.farm.carnivorous.basebiz.FarmerGuaranteeBillInfo.class, this.prmtguaranty, "data");
		dataBinder.registerBinding("systemCustomer", com.kingdee.eas.basedata.master.cssp.CustomerInfo.class, this.prmtsystemCustomer, "data");
		dataBinder.registerBinding("systemSupplier", com.kingdee.eas.basedata.master.cssp.SupplierInfo.class, this.prmtsystemSupplier, "data");
		dataBinder.registerBinding("FarmEntry.seq", int.class, this.kdtFarmEntry, "seq.text");
		dataBinder.registerBinding("FarmEntry", com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplFarmEntryInfo.class, this.kdtFarmEntry, "userObject");
		dataBinder.registerBinding("FarmEntry.name", String.class, this.kdtFarmEntry, "name.text");
		dataBinder.registerBinding("FarmEntry.address", String.class, this.kdtFarmEntry, "address.text");
		dataBinder.registerBinding("FarmEntry.area", java.math.BigDecimal.class, this.kdtFarmEntry, "area.text");
		dataBinder.registerBinding("FarmEntry.succahQty", int.class, this.kdtFarmEntry, "succahQty.text");
		dataBinder.registerBinding("FarmEntry.floorArea", java.math.BigDecimal.class, this.kdtFarmEntry, "floorArea.text");
		dataBinder.registerBinding("FarmEntry.farm", java.lang.Object.class, this.kdtFarmEntry, "farm.text");
		dataBinder.registerBinding("FarmEntry.farmGroup", java.lang.Object.class, this.kdtFarmEntry, "farmGroup.text");
		dataBinder.registerBinding("FarmEntry.mileStd", java.math.BigDecimal.class, this.kdtFarmEntry, "mileStd.text");
		dataBinder.registerBinding("FarmEntry.recyMiles", java.math.BigDecimal.class, this.kdtFarmEntry, "recyMiles.text");
		dataBinder.registerBinding("FarmEntry.farmGrop", java.lang.Object.class, this.kdtFarmEntry, "farmGrop.text");
		dataBinder.registerBinding("FarmEntry.mnemonicCode", String.class, this.kdtFarmEntry, "mnemonicCode.text");
		dataBinder.registerBinding("FarmEntry.farmQty", java.math.BigDecimal.class, this.kdtFarmEntry, "farmQty.text");
		dataBinder.registerBinding("FarmEntry.farmTypea", com.kingdee.util.enums.Enum.class, this.kdtFarmEntry, "farmTypea.text");
		dataBinder.registerBinding("FarmEntry.costCenter", java.lang.Object.class, this.kdtFarmEntry, "costCenter.text");
		dataBinder.registerBinding("FarmEntry.transPrice", java.math.BigDecimal.class, this.kdtFarmEntry, "transPrice.text");
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.checkResult", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "checkResult.text");
		dataBinder.registerBinding("entrys.checkItem", java.lang.Object.class, this.kdtEntrys, "checkItem.text");
		dataBinder.registerBinding("entrys.checkContent", String.class, this.kdtEntrys, "checkContent.text");
		dataBinder.registerBinding("score", java.math.BigDecimal.class, this.txtscore, "value");
		dataBinder.registerBinding("ssessmentPerson", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtssessmentPerson, "data");
		dataBinder.registerBinding("checkResult", com.kingdee.eas.farm.stocking.basedata.CheckResultEnum.class, this.checkResult, "selectedItem");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("farmerGroup", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtfarmerGroup, "data");		
	}
	//Regiester UI State
	private void registerUIState(){					 	        		
	        getActionManager().registerUIState(STATUS_EDIT, this.kdtEntrys, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.kdtEntrys, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_FINDVIEW, this.kdtEntrys, ActionStateConst.DISABLED);
	        getActionManager().registerUIState(STATUS_AUDIT, this.kdtEntrys, ActionStateConst.ENABLED);		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.carnivorous.basebiz.app.FarmerQualicationApplEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplInfo)ov;
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
		getValidateHelper().registerBindProperty("onlyFarm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("addFarm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sex", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("identity", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mobileTel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("tel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("address", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bankNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("experience", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedLvl", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("WoM", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("age", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("nation", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eduLvl", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("familyPeronCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bankAccountNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BEBank", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmActualName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmerGrop", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("technologyPerson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bankAddress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmerType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("guaranty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("systemCustomer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("systemSupplier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmEntry.name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmEntry.address", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmEntry.area", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmEntry.succahQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmEntry.floorArea", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmEntry.farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmEntry.farmGroup", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmEntry.mileStd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmEntry.recyMiles", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmEntry.farmGrop", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmEntry.mnemonicCode", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmEntry.farmQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmEntry.farmTypea", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmEntry.costCenter", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmEntry.transPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.checkResult", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.checkItem", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.checkContent", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("score", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ssessmentPerson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("checkResult", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmerGroup", ValidateHelper.ON_SAVE);    		
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
        if (STATUS_ADDNEW.equals(this.oprtState)) {
        } else if (STATUS_EDIT.equals(this.oprtState)) {
		            this.kdtEntrys.setEnabled(false);
        } else if (STATUS_VIEW.equals(this.oprtState)) {
		            this.kdtEntrys.setEnabled(false);
        } else if (STATUS_FINDVIEW.equals(this.oprtState)) {
		            this.kdtEntrys.setEnabled(false);
        } else if (STATUS_AUDIT.equals(this.oprtState)) {
		            this.kdtEntrys.setVisible(true);
		            this.kdtEntrys.setEnabled(true);
        }
    }


    /**
     * output kdtEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("checkItem".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"checkContent").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"checkItem").getValue(),"content")));

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
        sic.add(new SelectorItemInfo("onlyFarm"));
        sic.add(new SelectorItemInfo("addFarm"));
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
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("sex"));
        sic.add(new SelectorItemInfo("identity"));
        sic.add(new SelectorItemInfo("mobileTel"));
        sic.add(new SelectorItemInfo("tel"));
        sic.add(new SelectorItemInfo("address"));
        sic.add(new SelectorItemInfo("bankNo"));
        sic.add(new SelectorItemInfo("experience"));
        sic.add(new SelectorItemInfo("breedLvl"));
        sic.add(new SelectorItemInfo("WoM"));
        sic.add(new SelectorItemInfo("age"));
        sic.add(new SelectorItemInfo("nation"));
        sic.add(new SelectorItemInfo("eduLvl"));
        sic.add(new SelectorItemInfo("familyPeronCount"));
        sic.add(new SelectorItemInfo("bankAccountNo"));
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
			sic.add(new SelectorItemInfo("BEBank.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("BEBank.id"));
        	sic.add(new SelectorItemInfo("BEBank.number"));
        	sic.add(new SelectorItemInfo("BEBank.name"));
		}
        sic.add(new SelectorItemInfo("farmActualName"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("farmerGrop.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farmerGrop.id"));
        	sic.add(new SelectorItemInfo("farmerGrop.number"));
        	sic.add(new SelectorItemInfo("farmerGrop.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("technologyPerson.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("technologyPerson.id"));
        	sic.add(new SelectorItemInfo("technologyPerson.number"));
        	sic.add(new SelectorItemInfo("technologyPerson.name"));
		}
        sic.add(new SelectorItemInfo("bankAddress"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("farmerType.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farmerType.id"));
        	sic.add(new SelectorItemInfo("farmerType.number"));
        	sic.add(new SelectorItemInfo("farmerType.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("guaranty.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("guaranty.id"));
        	sic.add(new SelectorItemInfo("guaranty.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("systemCustomer.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("systemCustomer.id"));
        	sic.add(new SelectorItemInfo("systemCustomer.number"));
        	sic.add(new SelectorItemInfo("systemCustomer.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("systemSupplier.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("systemSupplier.id"));
        	sic.add(new SelectorItemInfo("systemSupplier.number"));
        	sic.add(new SelectorItemInfo("systemSupplier.name"));
		}
    	sic.add(new SelectorItemInfo("FarmEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FarmEntry.*"));
		}
		else{
			sic.add(new SelectorItemInfo("FarmEntry.name"));
		}
    	sic.add(new SelectorItemInfo("FarmEntry.address"));
    	sic.add(new SelectorItemInfo("FarmEntry.area"));
    	sic.add(new SelectorItemInfo("FarmEntry.succahQty"));
    	sic.add(new SelectorItemInfo("FarmEntry.floorArea"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FarmEntry.farm.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("FarmEntry.farm.id"));
			sic.add(new SelectorItemInfo("FarmEntry.farm.number"));
			sic.add(new SelectorItemInfo("FarmEntry.farm.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FarmEntry.farmGroup.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("FarmEntry.farmGroup.id"));
			sic.add(new SelectorItemInfo("FarmEntry.farmGroup.name"));
        	sic.add(new SelectorItemInfo("FarmEntry.farmGroup.number"));
		}
    	sic.add(new SelectorItemInfo("FarmEntry.mileStd"));
    	sic.add(new SelectorItemInfo("FarmEntry.recyMiles"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FarmEntry.farmGrop.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("FarmEntry.farmGrop.id"));
			sic.add(new SelectorItemInfo("FarmEntry.farmGrop.name"));
        	sic.add(new SelectorItemInfo("FarmEntry.farmGrop.number"));
		}
    	sic.add(new SelectorItemInfo("FarmEntry.mnemonicCode"));
    	sic.add(new SelectorItemInfo("FarmEntry.farmQty"));
    	sic.add(new SelectorItemInfo("FarmEntry.farmTypea"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FarmEntry.costCenter.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("FarmEntry.costCenter.id"));
			sic.add(new SelectorItemInfo("FarmEntry.costCenter.name"));
        	sic.add(new SelectorItemInfo("FarmEntry.costCenter.number"));
		}
    	sic.add(new SelectorItemInfo("FarmEntry.transPrice"));
    	sic.add(new SelectorItemInfo("entrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("entrys.checkResult"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.checkItem.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.checkItem.id"));
			sic.add(new SelectorItemInfo("entrys.checkItem.name"));
        	sic.add(new SelectorItemInfo("entrys.checkItem.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.checkContent"));
        sic.add(new SelectorItemInfo("score"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ssessmentPerson.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("ssessmentPerson.id"));
        	sic.add(new SelectorItemInfo("ssessmentPerson.number"));
        	sic.add(new SelectorItemInfo("ssessmentPerson.name"));
		}
        sic.add(new SelectorItemInfo("checkResult"));
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
			sic.add(new SelectorItemInfo("farmerGroup.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farmerGroup.id"));
        	sic.add(new SelectorItemInfo("farmerGroup.number"));
        	sic.add(new SelectorItemInfo("farmerGroup.name"));
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
        com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionIsTemplate_actionPerformed method
     */
    public void actionIsTemplate_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplFactory.getRemoteInstance().isTemplate(editData);
    }
    	

    /**
     * output actionIsCheckItemEntry_actionPerformed method
     */
    public void actionIsCheckItemEntry_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplFactory.getRemoteInstance().isCheckItemEntry(editData);
    }
    	

    /**
     * output actionViewGuaranteeBill_actionPerformed method
     */
    public void actionViewGuaranteeBill_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplFactory.getRemoteInstance().viewGuaranteeBill(editData);
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
	public RequestContext prepareActionIsCheckItemEntry(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionIsCheckItemEntry() {
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
            innerActionPerformed("eas", AbstractFarmerQualicationApplEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractFarmerQualicationApplEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractFarmerQualicationApplEditUI.this, "ActionIsTemplate", "actionIsTemplate_actionPerformed", e);
        }
    }

    /**
     * output ActionIsCheckItemEntry class
     */     
    protected class ActionIsCheckItemEntry extends ItemAction {     
    
        public ActionIsCheckItemEntry()
        {
            this(null);
        }

        public ActionIsCheckItemEntry(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionIsCheckItemEntry.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionIsCheckItemEntry.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionIsCheckItemEntry.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractFarmerQualicationApplEditUI.this, "ActionIsCheckItemEntry", "actionIsCheckItemEntry_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractFarmerQualicationApplEditUI.this, "ActionViewGuaranteeBill", "actionViewGuaranteeBill_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.basebiz.client", "FarmerQualicationApplEditUI");
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
        return com.kingdee.eas.farm.carnivorous.basebiz.client.FarmerQualicationApplEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplInfo objectValue = new com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/carnivorous/basebiz/FarmerQualicationAppl";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.carnivorous.basebiz.app.FarmerQualicationApplQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		for (int i=0,n=kdtFarmEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtFarmEntry.getCell(i,"name").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"名称"});
			}
		}
		for (int i=0,n=kdtFarmEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtFarmEntry.getCell(i,"farmQty").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖规模"});
			}
		}
		for (int i=0,n=kdtFarmEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtFarmEntry.getCell(i,"costCenter").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"成本中心"});
			}
		}
		for (int i=0,n=kdtFarmEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtFarmEntry.getCell(i,"farmTypea").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖模式"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"checkItem").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"评定项目"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"checkResult").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"评定结果"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtFarmEntry;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("billStatus",new Integer(-1));
vo.put("sex",new Integer(1));
vo.put("breedLvl",new Integer(3));
vo.put("WoM",new Integer(4));
vo.put("eduLvl",new Integer(1));
vo.put("checkResult",new Integer(1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}