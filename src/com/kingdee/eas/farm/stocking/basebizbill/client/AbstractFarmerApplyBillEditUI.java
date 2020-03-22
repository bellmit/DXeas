/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basebizbill.client;

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
public abstract class AbstractFarmerApplyBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractFarmerApplyBillEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbankName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbankNo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contexperience;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator9;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedLvl;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contWoM;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmerGroup;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contage;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnation;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteduLvl;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfamilyPeronCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbankAccountNo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBEBank;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contactualName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtname;
    protected com.kingdee.bos.ctrl.swing.KDComboBox sex;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtidentity;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtmobileTel;
    protected com.kingdee.bos.ctrl.swing.KDTextField txttel;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtaddress;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbankName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbankNo;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtexperience;
    protected com.kingdee.bos.ctrl.swing.KDComboBox breedLvl;
    protected com.kingdee.bos.ctrl.swing.KDComboBox WoM;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmerGroup;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmer;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtage;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtnation;
    protected com.kingdee.bos.ctrl.swing.KDComboBox eduLvl;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfamilyPeronCount;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbankAccountNo;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtBEBank;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtactualName;
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
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDSeparator newSeparator3;
    protected com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionIsTemplate actionIsTemplate = null;
    protected ActionIsCheckItemEntry actionIsCheckItemEntry = null;
    public final static String STATUS_AUDIT = "audit";
    /**
     * output class constructor
     */
    public AbstractFarmerApplyBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractFarmerApplyBillEditUI.class.getName());
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
        this.contbankName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbankNo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contexperience = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator9 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contbreedLvl = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contWoM = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmerGroup = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contage = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contnation = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteduLvl = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfamilyPeronCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbankAccountNo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBEBank = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contactualName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtname = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.sex = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtidentity = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtmobileTel = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txttel = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtaddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbankName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbankNo = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtexperience = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.breedLvl = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.WoM = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtfarmerGroup = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtfarmer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtage = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtnation = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.eduLvl = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtfamilyPeronCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbankAccountNo = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtBEBank = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtactualName = new com.kingdee.bos.ctrl.swing.KDTextField();
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
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contcompany.setName("contcompany");
        this.contauditTime.setName("contauditTime");
        this.kDSeparator8.setName("kDSeparator8");
        this.kDSeparator10.setName("kDSeparator10");
        this.chkisTemplate.setName("chkisTemplate");
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
        this.contbankName.setName("contbankName");
        this.contbankNo.setName("contbankNo");
        this.contexperience.setName("contexperience");
        this.kDSeparator9.setName("kDSeparator9");
        this.contbreedLvl.setName("contbreedLvl");
        this.contWoM.setName("contWoM");
        this.contfarmerGroup.setName("contfarmerGroup");
        this.contfarmer.setName("contfarmer");
        this.contage.setName("contage");
        this.contnation.setName("contnation");
        this.conteduLvl.setName("conteduLvl");
        this.contfamilyPeronCount.setName("contfamilyPeronCount");
        this.contbankAccountNo.setName("contbankAccountNo");
        this.contBEBank.setName("contBEBank");
        this.contactualName.setName("contactualName");
        this.txtname.setName("txtname");
        this.sex.setName("sex");
        this.txtidentity.setName("txtidentity");
        this.txtmobileTel.setName("txtmobileTel");
        this.txttel.setName("txttel");
        this.txtaddress.setName("txtaddress");
        this.txtbankName.setName("txtbankName");
        this.txtbankNo.setName("txtbankNo");
        this.txtexperience.setName("txtexperience");
        this.breedLvl.setName("breedLvl");
        this.WoM.setName("WoM");
        this.prmtfarmerGroup.setName("prmtfarmerGroup");
        this.prmtfarmer.setName("prmtfarmer");
        this.txtage.setName("txtage");
        this.txtnation.setName("txtnation");
        this.eduLvl.setName("eduLvl");
        this.txtfamilyPeronCount.setName("txtfamilyPeronCount");
        this.txtbankAccountNo.setName("txtbankAccountNo");
        this.prmtBEBank.setName("prmtBEBank");
        this.txtactualName.setName("txtactualName");
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
        // contbankName		
        this.contbankName.setBoundLabelText(resHelper.getString("contbankName.boundLabelText"));		
        this.contbankName.setBoundLabelLength(100);		
        this.contbankName.setBoundLabelUnderline(true);		
        this.contbankName.setVisible(true);
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
        // contfarmerGroup		
        this.contfarmerGroup.setBoundLabelText(resHelper.getString("contfarmerGroup.boundLabelText"));		
        this.contfarmerGroup.setBoundLabelLength(100);		
        this.contfarmerGroup.setBoundLabelUnderline(true);		
        this.contfarmerGroup.setVisible(true);
        // contfarmer		
        this.contfarmer.setBoundLabelText(resHelper.getString("contfarmer.boundLabelText"));		
        this.contfarmer.setBoundLabelLength(100);		
        this.contfarmer.setBoundLabelUnderline(true);
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
        // contBEBank		
        this.contBEBank.setBoundLabelText(resHelper.getString("contBEBank.boundLabelText"));		
        this.contBEBank.setBoundLabelLength(100);		
        this.contBEBank.setBoundLabelUnderline(true);		
        this.contBEBank.setVisible(true);
        // contactualName		
        this.contactualName.setBoundLabelText(resHelper.getString("contactualName.boundLabelText"));		
        this.contactualName.setBoundLabelLength(100);		
        this.contactualName.setBoundLabelUnderline(true);		
        this.contactualName.setVisible(true);
        // txtname		
        this.txtname.setHorizontalAlignment(2);		
        this.txtname.setMaxLength(20);		
        this.txtname.setRequired(true);
        // sex		
        this.sex.addItems(EnumUtils.getEnumList("com.kingdee.eas.basedata.person.Genders").toArray());		
        this.sex.setRequired(true);
        // txtidentity		
        this.txtidentity.setHorizontalAlignment(2);		
        this.txtidentity.setMaxLength(20);		
        this.txtidentity.setRequired(true);
        // txtmobileTel		
        this.txtmobileTel.setHorizontalAlignment(2);		
        this.txtmobileTel.setMaxLength(20);		
        this.txtmobileTel.setRequired(true);
        // txttel		
        this.txttel.setHorizontalAlignment(2);		
        this.txttel.setMaxLength(20);		
        this.txttel.setRequired(false);
        // txtaddress		
        this.txtaddress.setHorizontalAlignment(2);		
        this.txtaddress.setMaxLength(200);		
        this.txtaddress.setRequired(false);
        // txtbankName		
        this.txtbankName.setHorizontalAlignment(2);		
        this.txtbankName.setMaxLength(100);		
        this.txtbankName.setRequired(true);
        // txtbankNo		
        this.txtbankNo.setHorizontalAlignment(2);		
        this.txtbankNo.setMaxLength(30);		
        this.txtbankNo.setRequired(true);
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
        this.breedLvl.setRequired(true);
        // WoM		
        this.WoM.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.BreedLvlEnum").toArray());		
        this.WoM.setRequired(false);
        // prmtfarmerGroup		
        this.prmtfarmerGroup.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmerGroupQuery");		
        this.prmtfarmerGroup.setEditable(true);		
        this.prmtfarmerGroup.setDisplayFormat("$name$");		
        this.prmtfarmerGroup.setEditFormat("$number$");		
        this.prmtfarmerGroup.setCommitFormat("$number$");		
        this.prmtfarmerGroup.setRequired(true);
        // prmtfarmer		
        this.prmtfarmer.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmersQuery");		
        this.prmtfarmer.setEditable(true);		
        this.prmtfarmer.setDisplayFormat("$name$");		
        this.prmtfarmer.setEditFormat("$number$");		
        this.prmtfarmer.setCommitFormat("$number$");		
        this.prmtfarmer.setRequired(false);		
        this.prmtfarmer.setEnabled(false);
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
					
        // txtage		
        this.txtage.setVisible(true);		
        this.txtage.setHorizontalAlignment(2);		
        this.txtage.setDataType(0);		
        this.txtage.setSupportedEmpty(true);		
        this.txtage.setRequired(false);
        // txtnation		
        this.txtnation.setVisible(true);		
        this.txtnation.setHorizontalAlignment(2);		
        this.txtnation.setMaxLength(20);		
        this.txtnation.setRequired(false);
        // eduLvl		
        this.eduLvl.setVisible(true);		
        this.eduLvl.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.EduLvlEnum").toArray());		
        this.eduLvl.setRequired(false);
        // txtfamilyPeronCount		
        this.txtfamilyPeronCount.setVisible(true);		
        this.txtfamilyPeronCount.setHorizontalAlignment(2);		
        this.txtfamilyPeronCount.setDataType(0);		
        this.txtfamilyPeronCount.setSupportedEmpty(true);		
        this.txtfamilyPeronCount.setRequired(false);
        // txtbankAccountNo		
        this.txtbankAccountNo.setVisible(true);		
        this.txtbankAccountNo.setHorizontalAlignment(2);		
        this.txtbankAccountNo.setMaxLength(100);		
        this.txtbankAccountNo.setRequired(true);
        // prmtBEBank		
        this.prmtBEBank.setQueryInfo("com.kingdee.eas.fm.be.app.BEBankQuery");		
        this.prmtBEBank.setVisible(true);		
        this.prmtBEBank.setEditable(true);		
        this.prmtBEBank.setDisplayFormat("$name$");		
        this.prmtBEBank.setEditFormat("$number$");		
        this.prmtBEBank.setCommitFormat("$number$");		
        this.prmtBEBank.setRequired(false);
        // txtactualName		
        this.txtactualName.setVisible(true);		
        this.txtactualName.setHorizontalAlignment(2);		
        this.txtactualName.setMaxLength(100);		
        this.txtactualName.setRequired(false);
        // kdtFarmEntry
		String kdtFarmEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"farm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"area\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"floorArea\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"succahQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"address\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"farmGroup\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{farm}</t:Cell><t:Cell>$Resource{name}</t:Cell><t:Cell>$Resource{area}</t:Cell><t:Cell>$Resource{floorArea}</t:Cell><t:Cell>$Resource{succahQty}</t:Cell><t:Cell>$Resource{address}</t:Cell><t:Cell>$Resource{farmGroup}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtFarmEntry.setFormatXml(resHelper.translateString("kdtFarmEntry",kdtFarmEntryStrXML));
        kdtFarmEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtFarmEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtFarmEntry.putBindContents("editData",new String[] {"seq","farm","name","area","floorArea","succahQty","address","farmGroup"});


        this.kdtFarmEntry.checkParsed();
        final KDBizPromptBox kdtFarmEntry_farm_PromptBox = new KDBizPromptBox();
        kdtFarmEntry_farm_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmQuery");
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
			com.kingdee.eas.farm.stocking.basedata.client.FarmListUI kdtFarmEntry_farm_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtFarmEntry_farm_PromptBox_F7ListUI == null) {
					try {
						kdtFarmEntry_farm_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmListUI();
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
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"checkItem\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"checkContext\" t:width=\"250\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"checkResult\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{checkItem}</t:Cell><t:Cell>$Resource{checkContext}</t:Cell><t:Cell>$Resource{checkResult}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtEntrys.putBindContents("editData",new String[] {"id","checkItem","checkContext","checkResult"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_checkItem_PromptBox = new KDBizPromptBox();
        kdtEntrys_checkItem_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.CheckItemQuery");
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
        			kdtEntrys_checkItem_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.CheckItemListUI kdtEntrys_checkItem_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_checkItem_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_checkItem_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.CheckItemListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_checkItem_PromptBox_F7ListUI));
					kdtEntrys_checkItem_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_checkItem_PromptBox.setSelector(kdtEntrys_checkItem_PromptBox_F7ListUI);
				}
			}
		});
					
        KDTextField kdtEntrys_checkContext_TextField = new KDTextField();
        kdtEntrys_checkContext_TextField.setName("kdtEntrys_checkContext_TextField");
        kdtEntrys_checkContext_TextField.setMaxLength(200);
        KDTDefaultCellEditor kdtEntrys_checkContext_CellEditor = new KDTDefaultCellEditor(kdtEntrys_checkContext_TextField);
        this.kdtEntrys.getColumn("checkContext").setEditor(kdtEntrys_checkContext_CellEditor);
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
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,billStatus,prmtcompany,txtname,sex,txtidentity,txtmobileTel,txttel,txtaddress,txtbankNo,txtbankName,pkauditTime,txtexperience,breedLvl,txtscore,prmtssessmentPerson,chkisTemplate,WoM,checkResult,prmtfarmer,prmtfarmerGroup,kdtEntrys,kdtFarmEntry,txtage,txtnation,eduLvl,txtfamilyPeronCount,txtbankAccountNo,prmtBEBank,txtactualName}));
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
        contDescription.setBounds(new Rectangle(355, 57, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(355, 57, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(30, 552, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(30, 552, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(690, 20, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(690, 20, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDTabbedPane1.setBounds(new Rectangle(22, 114, 979, 413));
        this.add(kDTabbedPane1, new KDLayout.Constraints(22, 114, 979, 413, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompany.setBounds(new Rectangle(20, 57, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(20, 57, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(30, 579, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(30, 579, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator8.setBounds(new Rectangle(20, 538, 980, 10));
        this.add(kDSeparator8, new KDLayout.Constraints(20, 538, 980, 10, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator10.setBounds(new Rectangle(21, 94, 955, 10));
        this.add(kDSeparator10, new KDLayout.Constraints(21, 94, 955, 10, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        chkisTemplate.setBounds(new Rectangle(690, 57, 270, 19));
        this.add(chkisTemplate, new KDLayout.Constraints(690, 57, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
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
        contmobileTel.setBounds(new Rectangle(16, 121, 270, 19));
        kDPanel1.add(contmobileTel, new KDLayout.Constraints(16, 121, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttel.setBounds(new Rectangle(336, 121, 270, 19));
        kDPanel1.add(conttel, new KDLayout.Constraints(336, 121, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contaddress.setBounds(new Rectangle(16, 186, 909, 19));
        kDPanel1.add(contaddress, new KDLayout.Constraints(16, 186, 909, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contbankName.setBounds(new Rectangle(336, 279, 270, 19));
        kDPanel1.add(contbankName, new KDLayout.Constraints(336, 279, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbankNo.setBounds(new Rectangle(336, 240, 270, 19));
        kDPanel1.add(contbankNo, new KDLayout.Constraints(336, 240, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contexperience.setBounds(new Rectangle(336, 152, 270, 19));
        kDPanel1.add(contexperience, new KDLayout.Constraints(336, 152, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator9.setBounds(new Rectangle(16, 218, 923, 8));
        kDPanel1.add(kDSeparator9, new KDLayout.Constraints(16, 218, 923, 8, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contbreedLvl.setBounds(new Rectangle(16, 152, 270, 19));
        kDPanel1.add(contbreedLvl, new KDLayout.Constraints(16, 152, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contWoM.setBounds(new Rectangle(656, 121, 270, 19));
        kDPanel1.add(contWoM, new KDLayout.Constraints(656, 121, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfarmerGroup.setBounds(new Rectangle(656, 152, 270, 19));
        kDPanel1.add(contfarmerGroup, new KDLayout.Constraints(656, 152, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfarmer.setBounds(new Rectangle(656, 240, 270, 19));
        kDPanel1.add(contfarmer, new KDLayout.Constraints(656, 240, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contage.setBounds(new Rectangle(16, 59, 270, 19));
        kDPanel1.add(contage, new KDLayout.Constraints(16, 59, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contnation.setBounds(new Rectangle(336, 59, 270, 19));
        kDPanel1.add(contnation, new KDLayout.Constraints(336, 59, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conteduLvl.setBounds(new Rectangle(657, 59, 270, 19));
        kDPanel1.add(conteduLvl, new KDLayout.Constraints(657, 59, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfamilyPeronCount.setBounds(new Rectangle(16, 90, 270, 19));
        kDPanel1.add(contfamilyPeronCount, new KDLayout.Constraints(16, 90, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbankAccountNo.setBounds(new Rectangle(16, 279, 270, 19));
        kDPanel1.add(contbankAccountNo, new KDLayout.Constraints(16, 279, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBEBank.setBounds(new Rectangle(16, 240, 270, 19));
        kDPanel1.add(contBEBank, new KDLayout.Constraints(16, 240, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contactualName.setBounds(new Rectangle(336, 90, 270, 19));
        kDPanel1.add(contactualName, new KDLayout.Constraints(336, 90, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contbankName
        contbankName.setBoundEditor(txtbankName);
        //contbankNo
        contbankNo.setBoundEditor(txtbankNo);
        //contexperience
        contexperience.setBoundEditor(txtexperience);
        //contbreedLvl
        contbreedLvl.setBoundEditor(breedLvl);
        //contWoM
        contWoM.setBoundEditor(WoM);
        //contfarmerGroup
        contfarmerGroup.setBoundEditor(prmtfarmerGroup);
        //contfarmer
        contfarmer.setBoundEditor(prmtfarmer);
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
        //contBEBank
        contBEBank.setBoundEditor(prmtBEBank);
        //contactualName
        contactualName.setBoundEditor(txtactualName);
        //kDPanel4
        kDPanel4.setLayout(new KDLayout());
        kDPanel4.putClientProperty("OriginalBounds", new Rectangle(0, 0, 978, 380));        kdtFarmEntry.setBounds(new Rectangle(2, 1, 969, 375));
        kdtFarmEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtFarmEntry,new com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillFarmEntryInfo(),null,false);
        kDPanel4.add(kdtFarmEntry_detailPanel, new KDLayout.Constraints(2, 1, 969, 375, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 978, 380));        kdtEntrys.setBounds(new Rectangle(1, 0, 968, 319));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillEntryInfo(),null,false);
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
		dataBinder.registerBinding("bankName", String.class, this.txtbankName, "text");
		dataBinder.registerBinding("bankNo", String.class, this.txtbankNo, "text");
		dataBinder.registerBinding("experience", java.math.BigDecimal.class, this.txtexperience, "value");
		dataBinder.registerBinding("breedLvl", com.kingdee.eas.farm.stocking.basedata.BreedLvlEnum.class, this.breedLvl, "selectedItem");
		dataBinder.registerBinding("WoM", com.kingdee.eas.farm.stocking.basedata.BreedLvlEnum.class, this.WoM, "selectedItem");
		dataBinder.registerBinding("farmerGroup", com.kingdee.eas.farm.stocking.basedata.FarmersInfo.class, this.prmtfarmerGroup, "data");
		dataBinder.registerBinding("farmer", com.kingdee.eas.farm.stocking.basedata.FarmersInfo.class, this.prmtfarmer, "data");
		dataBinder.registerBinding("age", int.class, this.txtage, "value");
		dataBinder.registerBinding("nation", String.class, this.txtnation, "text");
		dataBinder.registerBinding("eduLvl", com.kingdee.eas.farm.stocking.basedata.EduLvlEnum.class, this.eduLvl, "selectedItem");
		dataBinder.registerBinding("familyPeronCount", int.class, this.txtfamilyPeronCount, "value");
		dataBinder.registerBinding("bankAccountNo", String.class, this.txtbankAccountNo, "text");
		dataBinder.registerBinding("BEBank", com.kingdee.eas.fm.be.BEBankInfo.class, this.prmtBEBank, "data");
		dataBinder.registerBinding("actualName", String.class, this.txtactualName, "text");
		dataBinder.registerBinding("FarmEntry.seq", int.class, this.kdtFarmEntry, "seq.text");
		dataBinder.registerBinding("FarmEntry", com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillFarmEntryInfo.class, this.kdtFarmEntry, "userObject");
		dataBinder.registerBinding("FarmEntry.name", String.class, this.kdtFarmEntry, "name.text");
		dataBinder.registerBinding("FarmEntry.address", String.class, this.kdtFarmEntry, "address.text");
		dataBinder.registerBinding("FarmEntry.area", java.math.BigDecimal.class, this.kdtFarmEntry, "area.text");
		dataBinder.registerBinding("FarmEntry.succahQty", int.class, this.kdtFarmEntry, "succahQty.text");
		dataBinder.registerBinding("FarmEntry.farm", java.lang.Object.class, this.kdtFarmEntry, "farm.text");
		dataBinder.registerBinding("FarmEntry.farmGroup", java.lang.Object.class, this.kdtFarmEntry, "farmGroup.text");
		dataBinder.registerBinding("FarmEntry.floorArea", java.math.BigDecimal.class, this.kdtFarmEntry, "floorArea.text");
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.checkResult", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "checkResult.text");
		dataBinder.registerBinding("entrys.checkItem", java.lang.Object.class, this.kdtEntrys, "checkItem.text");
		dataBinder.registerBinding("entrys.checkContext", String.class, this.kdtEntrys, "checkContext.text");
		dataBinder.registerBinding("score", java.math.BigDecimal.class, this.txtscore, "value");
		dataBinder.registerBinding("ssessmentPerson", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtssessmentPerson, "data");
		dataBinder.registerBinding("checkResult", com.kingdee.eas.farm.stocking.basedata.CheckResultEnum.class, this.checkResult, "selectedItem");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");		
	}
	//Regiester UI State
	private void registerUIState(){					 	        		
	        getActionManager().registerUIState(STATUS_EDIT, this.kdtEntrys, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.kdtEntrys, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_FINDVIEW, this.kdtEntrys, ActionStateConst.DISABLED);
	        getActionManager().registerUIState(STATUS_AUDIT, this.kdtEntrys, ActionStateConst.ENABLED);		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.stocking.basebizbill.app.FarmerApplyBillEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillInfo)ov;
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
		getValidateHelper().registerBindProperty("bankName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bankNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("experience", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedLvl", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("WoM", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmerGroup", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("age", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("nation", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eduLvl", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("familyPeronCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bankAccountNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BEBank", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("actualName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmEntry.name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmEntry.address", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmEntry.area", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmEntry.succahQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmEntry.farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmEntry.farmGroup", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmEntry.floorArea", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.checkResult", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.checkItem", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.checkContext", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("score", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ssessmentPerson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("checkResult", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    		
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
        if (STATUS_ADDNEW.equals(this.oprtState)) {
		            this.kdtEntrys.getColumn("checkItem").getStyleAttributes().setLocked(true);
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
     * output kdtFarmEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtFarmEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("farm".equalsIgnoreCase(kdtFarmEntry.getColumn(colIndex).getKey())) {
kdtFarmEntry.setName(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtFarmEntry.getCell(rowIndex,"farm").getValue(),"name")));
kdtFarmEntry.getCell(rowIndex,"area").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtFarmEntry.getCell(rowIndex,"farm").getValue(),"area")));
kdtFarmEntry.getCell(rowIndex,"address").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtFarmEntry.getCell(rowIndex,"farm").getValue(),"address")));

}


    }

    /**
     * output kdtEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("checkItem".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"checkContext").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"checkItem").getValue(),"context")));

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
        sic.add(new SelectorItemInfo("bankName"));
        sic.add(new SelectorItemInfo("bankNo"));
        sic.add(new SelectorItemInfo("experience"));
        sic.add(new SelectorItemInfo("breedLvl"));
        sic.add(new SelectorItemInfo("WoM"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("farmerGroup.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farmerGroup.id"));
        	sic.add(new SelectorItemInfo("farmerGroup.number"));
        	sic.add(new SelectorItemInfo("farmerGroup.name"));
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
        sic.add(new SelectorItemInfo("age"));
        sic.add(new SelectorItemInfo("nation"));
        sic.add(new SelectorItemInfo("eduLvl"));
        sic.add(new SelectorItemInfo("familyPeronCount"));
        sic.add(new SelectorItemInfo("bankAccountNo"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("BEBank.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("BEBank.id"));
        	sic.add(new SelectorItemInfo("BEBank.number"));
        	sic.add(new SelectorItemInfo("BEBank.name"));
		}
        sic.add(new SelectorItemInfo("actualName"));
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
    	sic.add(new SelectorItemInfo("FarmEntry.floorArea"));
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
    	sic.add(new SelectorItemInfo("entrys.checkContext"));
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
        com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionIsTemplate_actionPerformed method
     */
    public void actionIsTemplate_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillFactory.getRemoteInstance().isTemplate(editData);
    }
    	

    /**
     * output actionIsCheckItemEntry_actionPerformed method
     */
    public void actionIsCheckItemEntry_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillFactory.getRemoteInstance().isCheckItemEntry(editData);
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
            innerActionPerformed("eas", AbstractFarmerApplyBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractFarmerApplyBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractFarmerApplyBillEditUI.this, "ActionIsTemplate", "actionIsTemplate_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractFarmerApplyBillEditUI.this, "ActionIsCheckItemEntry", "actionIsCheckItemEntry_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.stocking.basebizbill.client", "FarmerApplyBillEditUI");
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
        return com.kingdee.eas.farm.stocking.basebizbill.client.FarmerApplyBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillInfo objectValue = new com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/stocking/basebizbill/FarmerApplyBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.stocking.basebizbill.app.FarmerApplyBillQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtname.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"姓名"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(sex.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"性别"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtidentity.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"身份证号码"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtmobileTel.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"手机号码"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtbankName.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"银行名称"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtbankNo.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"银行账号"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(breedLvl.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖水平"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtfarmerGroup.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养户分类"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtbankAccountNo.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"银行开户人姓名"});
		}
		for (int i=0,n=kdtFarmEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtFarmEntry.getCell(i,"name").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"名称"});
			}
		}
		for (int i=0,n=kdtFarmEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtFarmEntry.getCell(i,"farmGroup").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖场分类"});
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
vo.put("WoM",new Integer(1));
vo.put("eduLvl",new Integer(1));
vo.put("checkResult",new Integer(1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}