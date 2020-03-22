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
public abstract class AbstractBEggCandlingBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractBEggCandlingBillEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthatchFactory;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallNoFertileEggQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallAddleEggQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallRottenEggQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallHatchEggQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoperator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallHealthEggQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthatchArea;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contincubator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contotherLoss;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contadminOrg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallBrokenEggQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbrokenEggQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfertilityRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthatchHouse;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteggType;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthatchDate;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisTraying;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttrayingDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgenderTy;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisProBabyBill;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisOtherIn;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmthatchFactory;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEggEntries;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEggEntries_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtFarmerSumEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtFarmerSumEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallNoFertileEggQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallAddleEggQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallRottenEggQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallHatchEggQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtoperator;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallHealthEggQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmthatchArea;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtincubator;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtotherLoss;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtadminOrg;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallBrokenEggQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbrokenEggQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfertilityRate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmthatchHouse;
    protected com.kingdee.bos.ctrl.swing.KDComboBox eggType;
    protected com.kingdee.bos.ctrl.swing.KDRadioButton radioHorizon;
    protected com.kingdee.bos.ctrl.swing.KDRadioButton radioVertical;
    protected com.kingdee.bos.ctrl.swing.KDRadioButton radioOrigin;
    protected com.kingdee.bos.ctrl.swing.KDButton btnSummary;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox cboxCPM;
    protected com.kingdee.bos.ctrl.swing.KDButton btnSaveModel;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtAreaSumEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtAreaSumEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkhatchDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pktrayingDate;
    protected com.kingdee.bos.ctrl.swing.KDComboBox genderTy;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAdjust;
    protected com.kingdee.eas.farm.hatch.BEggCandlingBillInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionAdjust actionAdjust = null;
    /**
     * output class constructor
     */
    public AbstractBEggCandlingBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractBEggCandlingBillEditUI.class.getName());
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
        //actionAdjust
        this.actionAdjust = new ActionAdjust(this);
        getActionManager().registerAction("actionAdjust", actionAdjust);
        this.actionAdjust.setExtendProperty("canForewarn", "true");
        this.actionAdjust.setExtendProperty("userDefined", "false");
        this.actionAdjust.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAdjust.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAdjust.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthatchFactory = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane2 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contallNoFertileEggQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallAddleEggQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallRottenEggQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallHatchEggQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoperator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallHealthEggQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthatchArea = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contincubator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contotherLoss = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contadminOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallBrokenEggQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbrokenEggQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfertilityRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthatchHouse = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteggType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.conthatchDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisTraying = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.conttrayingDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgenderTy = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisProBabyBill = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisOtherIn = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmthatchFactory = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEggEntries = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtFarmerSumEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.txtallNoFertileEggQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallAddleEggQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallRottenEggQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallHatchEggQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtoperator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtallHealthEggQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmthatchArea = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtincubator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtotherLoss = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtadminOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtallBrokenEggQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbrokenEggQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfertilityRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmthatchHouse = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.eggType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.radioHorizon = new com.kingdee.bos.ctrl.swing.KDRadioButton();
        this.radioVertical = new com.kingdee.bos.ctrl.swing.KDRadioButton();
        this.radioOrigin = new com.kingdee.bos.ctrl.swing.KDRadioButton();
        this.btnSummary = new com.kingdee.bos.ctrl.swing.KDButton();
        this.cboxCPM = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.btnSaveModel = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtAreaSumEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.pkhatchDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pktrayingDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.genderTy = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnAdjust = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.contauditTime.setName("contauditTime");
        this.contbaseStatus.setName("contbaseStatus");
        this.conthatchFactory.setName("conthatchFactory");
        this.kDTabbedPane2.setName("kDTabbedPane2");
        this.contallNoFertileEggQty.setName("contallNoFertileEggQty");
        this.contallAddleEggQty.setName("contallAddleEggQty");
        this.contallRottenEggQty.setName("contallRottenEggQty");
        this.contallHatchEggQty.setName("contallHatchEggQty");
        this.contoperator.setName("contoperator");
        this.contallHealthEggQty.setName("contallHealthEggQty");
        this.conthatchArea.setName("conthatchArea");
        this.contincubator.setName("contincubator");
        this.contotherLoss.setName("contotherLoss");
        this.contadminOrg.setName("contadminOrg");
        this.contallBrokenEggQty.setName("contallBrokenEggQty");
        this.contbrokenEggQty.setName("contbrokenEggQty");
        this.contfertilityRate.setName("contfertilityRate");
        this.conthatchHouse.setName("conthatchHouse");
        this.conteggType.setName("conteggType");
        this.kDPanel4.setName("kDPanel4");
        this.conthatchDate.setName("conthatchDate");
        this.chkisTraying.setName("chkisTraying");
        this.conttrayingDate.setName("conttrayingDate");
        this.contgenderTy.setName("contgenderTy");
        this.chkisProBabyBill.setName("chkisProBabyBill");
        this.chkisOtherIn.setName("chkisOtherIn");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.pkauditTime.setName("pkauditTime");
        this.baseStatus.setName("baseStatus");
        this.prmthatchFactory.setName("prmthatchFactory");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel3.setName("kDPanel3");
        this.kdtEggEntries.setName("kdtEggEntries");
        this.kdtFarmerSumEntry.setName("kdtFarmerSumEntry");
        this.txtallNoFertileEggQty.setName("txtallNoFertileEggQty");
        this.txtallAddleEggQty.setName("txtallAddleEggQty");
        this.txtallRottenEggQty.setName("txtallRottenEggQty");
        this.txtallHatchEggQty.setName("txtallHatchEggQty");
        this.prmtoperator.setName("prmtoperator");
        this.txtallHealthEggQty.setName("txtallHealthEggQty");
        this.prmthatchArea.setName("prmthatchArea");
        this.prmtincubator.setName("prmtincubator");
        this.txtotherLoss.setName("txtotherLoss");
        this.prmtadminOrg.setName("prmtadminOrg");
        this.txtallBrokenEggQty.setName("txtallBrokenEggQty");
        this.txtbrokenEggQty.setName("txtbrokenEggQty");
        this.txtfertilityRate.setName("txtfertilityRate");
        this.prmthatchHouse.setName("prmthatchHouse");
        this.eggType.setName("eggType");
        this.radioHorizon.setName("radioHorizon");
        this.radioVertical.setName("radioVertical");
        this.radioOrigin.setName("radioOrigin");
        this.btnSummary.setName("btnSummary");
        this.cboxCPM.setName("cboxCPM");
        this.btnSaveModel.setName("btnSaveModel");
        this.kDPanel1.setName("kDPanel1");
        this.kdtAreaSumEntry.setName("kdtAreaSumEntry");
        this.pkhatchDate.setName("pkhatchDate");
        this.pktrayingDate.setName("pktrayingDate");
        this.genderTy.setName("genderTy");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
        this.btnAdjust.setName("btnAdjust");
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
        // conthatchFactory		
        this.conthatchFactory.setBoundLabelText(resHelper.getString("conthatchFactory.boundLabelText"));		
        this.conthatchFactory.setBoundLabelLength(100);		
        this.conthatchFactory.setBoundLabelUnderline(true);		
        this.conthatchFactory.setVisible(true);
        // kDTabbedPane2
        // contallNoFertileEggQty		
        this.contallNoFertileEggQty.setBoundLabelText(resHelper.getString("contallNoFertileEggQty.boundLabelText"));		
        this.contallNoFertileEggQty.setBoundLabelLength(100);		
        this.contallNoFertileEggQty.setBoundLabelUnderline(true);		
        this.contallNoFertileEggQty.setVisible(true);
        // contallAddleEggQty		
        this.contallAddleEggQty.setBoundLabelText(resHelper.getString("contallAddleEggQty.boundLabelText"));		
        this.contallAddleEggQty.setBoundLabelLength(100);		
        this.contallAddleEggQty.setBoundLabelUnderline(true);		
        this.contallAddleEggQty.setVisible(true);
        // contallRottenEggQty		
        this.contallRottenEggQty.setBoundLabelText(resHelper.getString("contallRottenEggQty.boundLabelText"));		
        this.contallRottenEggQty.setBoundLabelLength(100);		
        this.contallRottenEggQty.setBoundLabelUnderline(true);		
        this.contallRottenEggQty.setVisible(true);
        // contallHatchEggQty		
        this.contallHatchEggQty.setBoundLabelText(resHelper.getString("contallHatchEggQty.boundLabelText"));		
        this.contallHatchEggQty.setBoundLabelLength(100);		
        this.contallHatchEggQty.setBoundLabelUnderline(true);		
        this.contallHatchEggQty.setVisible(true);
        // contoperator		
        this.contoperator.setBoundLabelText(resHelper.getString("contoperator.boundLabelText"));		
        this.contoperator.setBoundLabelLength(100);		
        this.contoperator.setBoundLabelUnderline(true);		
        this.contoperator.setVisible(true);
        // contallHealthEggQty		
        this.contallHealthEggQty.setBoundLabelText(resHelper.getString("contallHealthEggQty.boundLabelText"));		
        this.contallHealthEggQty.setBoundLabelLength(100);		
        this.contallHealthEggQty.setBoundLabelUnderline(true);		
        this.contallHealthEggQty.setVisible(true);
        // conthatchArea		
        this.conthatchArea.setBoundLabelText(resHelper.getString("conthatchArea.boundLabelText"));		
        this.conthatchArea.setBoundLabelLength(100);		
        this.conthatchArea.setBoundLabelUnderline(true);		
        this.conthatchArea.setVisible(false);
        // contincubator		
        this.contincubator.setBoundLabelText(resHelper.getString("contincubator.boundLabelText"));		
        this.contincubator.setBoundLabelLength(100);		
        this.contincubator.setBoundLabelUnderline(true);		
        this.contincubator.setVisible(false);
        // contotherLoss		
        this.contotherLoss.setBoundLabelText(resHelper.getString("contotherLoss.boundLabelText"));		
        this.contotherLoss.setBoundLabelLength(100);		
        this.contotherLoss.setBoundLabelUnderline(true);		
        this.contotherLoss.setVisible(false);
        // contadminOrg		
        this.contadminOrg.setBoundLabelText(resHelper.getString("contadminOrg.boundLabelText"));		
        this.contadminOrg.setBoundLabelLength(100);		
        this.contadminOrg.setBoundLabelUnderline(true);		
        this.contadminOrg.setVisible(false);
        // contallBrokenEggQty		
        this.contallBrokenEggQty.setBoundLabelText(resHelper.getString("contallBrokenEggQty.boundLabelText"));		
        this.contallBrokenEggQty.setBoundLabelLength(100);		
        this.contallBrokenEggQty.setBoundLabelUnderline(true);		
        this.contallBrokenEggQty.setVisible(true);
        // contbrokenEggQty		
        this.contbrokenEggQty.setBoundLabelText(resHelper.getString("contbrokenEggQty.boundLabelText"));		
        this.contbrokenEggQty.setBoundLabelLength(100);		
        this.contbrokenEggQty.setBoundLabelUnderline(true);		
        this.contbrokenEggQty.setVisible(false);
        // contfertilityRate		
        this.contfertilityRate.setBoundLabelText(resHelper.getString("contfertilityRate.boundLabelText"));		
        this.contfertilityRate.setBoundLabelLength(100);		
        this.contfertilityRate.setBoundLabelUnderline(true);		
        this.contfertilityRate.setVisible(false);
        // conthatchHouse		
        this.conthatchHouse.setBoundLabelText(resHelper.getString("conthatchHouse.boundLabelText"));		
        this.conthatchHouse.setBoundLabelLength(100);		
        this.conthatchHouse.setBoundLabelUnderline(true);		
        this.conthatchHouse.setVisible(false);
        // conteggType		
        this.conteggType.setBoundLabelText(resHelper.getString("conteggType.boundLabelText"));		
        this.conteggType.setBoundLabelLength(100);		
        this.conteggType.setBoundLabelUnderline(true);		
        this.conteggType.setVisible(true);
        // kDPanel4		
        this.kDPanel4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel4.border.title")));
        // conthatchDate		
        this.conthatchDate.setBoundLabelText(resHelper.getString("conthatchDate.boundLabelText"));		
        this.conthatchDate.setBoundLabelLength(100);		
        this.conthatchDate.setBoundLabelUnderline(true);		
        this.conthatchDate.setVisible(true);
        // chkisTraying		
        this.chkisTraying.setText(resHelper.getString("chkisTraying.text"));		
        this.chkisTraying.setHorizontalAlignment(2);		
        this.chkisTraying.setEnabled(false);
        // conttrayingDate		
        this.conttrayingDate.setBoundLabelText(resHelper.getString("conttrayingDate.boundLabelText"));		
        this.conttrayingDate.setBoundLabelLength(100);		
        this.conttrayingDate.setBoundLabelUnderline(true);		
        this.conttrayingDate.setVisible(true);
        // contgenderTy		
        this.contgenderTy.setBoundLabelText(resHelper.getString("contgenderTy.boundLabelText"));		
        this.contgenderTy.setBoundLabelLength(100);		
        this.contgenderTy.setBoundLabelUnderline(true);		
        this.contgenderTy.setVisible(true);
        // chkisProBabyBill		
        this.chkisProBabyBill.setText(resHelper.getString("chkisProBabyBill.text"));		
        this.chkisProBabyBill.setHorizontalAlignment(2);		
        this.chkisProBabyBill.setEnabled(false);
        // chkisOtherIn		
        this.chkisOtherIn.setText(resHelper.getString("chkisOtherIn.text"));		
        this.chkisOtherIn.setHorizontalAlignment(2);		
        this.chkisOtherIn.setEnabled(false);
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
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(false);		
        this.baseStatus.setEnabled(false);
        // prmthatchFactory		
        this.prmthatchFactory.setQueryInfo("com.kingdee.eas.farm.hatch.app.HatchBaseDataQuery");		
        this.prmthatchFactory.setEditable(true);		
        this.prmthatchFactory.setDisplayFormat("$name$");		
        this.prmthatchFactory.setEditFormat("$number$");		
        this.prmthatchFactory.setCommitFormat("$number$");		
        this.prmthatchFactory.setRequired(true);		
        this.prmthatchFactory.setEnabled(false);
        		prmthatchFactory.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.HatchBaseDataListUI prmthatchFactory_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmthatchFactory_F7ListUI == null) {
					try {
						prmthatchFactory_F7ListUI = new com.kingdee.eas.farm.hatch.client.HatchBaseDataListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmthatchFactory_F7ListUI));
					prmthatchFactory_F7ListUI.setF7Use(true,ctx);
					prmthatchFactory.setSelector(prmthatchFactory_F7ListUI);
				}
			}
		});
					
        // kDPanel2
        // kDPanel3
        // kdtEggEntries
		String kdtEggEntriesStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol1\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol8\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol9\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol10\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol11\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol12\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol13\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol15\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol16\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol17\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol18\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol19\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol20\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol21\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol22\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol23\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol24\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol25\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol26\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol27\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol28\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol29\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol30\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol31\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol32\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol33\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol34\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol35\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol36\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol37\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol38\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol39\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol40\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol41\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol42\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol43\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol44\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol45\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol46\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol47\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol48\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol49\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"hatchHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"incubator\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"hatchCarNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"eggSourceType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"isMix\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"eggDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"farm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"house\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"breedBatch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"outArea\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"farmer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"outFarm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"outHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"CostObject\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"outBatch\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"genderType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /><t:Column t:key=\"supplier\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"eggLog\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol19\" /><t:Column t:key=\"weekAge\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol20\" /><t:Column t:key=\"dayAge\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol21\" /><t:Column t:key=\"isFormal\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol22\" /><t:Column t:key=\"qc1lv1Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol23\" /><t:Column t:key=\"qc1lv2Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol24\" /><t:Column t:key=\"qc2lv1Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol25\" /><t:Column t:key=\"qc2lv2Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol26\" /><t:Column t:key=\"qc3lv1Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol27\" /><t:Column t:key=\"qc4lv1Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol28\" /><t:Column t:key=\"qc5lv1Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol29\" /><t:Column t:key=\"qc6lv1Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol30\" /><t:Column t:key=\"qcEggType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol31\" /><t:Column t:key=\"eggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol32\" /><t:Column t:key=\"healthEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol33\" /><t:Column t:key=\"lphealthEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol34\" /><t:Column t:key=\"noFertileEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol35\" /><t:Column t:key=\"brokenYolkQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol36\" /><t:Column t:key=\"addleEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol37\" /><t:Column t:key=\"lossQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"38\" t:styleID=\"sCol38\" /><t:Column t:key=\"otherEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"39\" t:styleID=\"sCol39\" /><t:Column t:key=\"fertilityRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"40\" t:styleID=\"sCol40\" /><t:Column t:key=\"liveEggRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"41\" t:styleID=\"sCol41\" /><t:Column t:key=\"addleEggRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"42\" t:styleID=\"sCol42\" /><t:Column t:key=\"diffEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"43\" t:styleID=\"sCol43\" /><t:Column t:key=\"brokenRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"44\" t:styleID=\"sCol44\" /><t:Column t:key=\"hatchsBox\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"45\" t:styleID=\"sCol45\" /><t:Column t:key=\"noFertileEggRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"46\" t:styleID=\"sCol46\" /><t:Column t:key=\"rottenRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"47\" t:styleID=\"sCol47\" /><t:Column t:key=\"rottenEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"48\" t:styleID=\"sCol48\" /><t:Column t:key=\"brokenEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"49\" t:styleID=\"sCol49\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{hatchHouse}</t:Cell><t:Cell>$Resource{incubator}</t:Cell><t:Cell>$Resource{hatchCarNum}</t:Cell><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{eggSourceType}</t:Cell><t:Cell>$Resource{isMix}</t:Cell><t:Cell>$Resource{eggDate}</t:Cell><t:Cell>$Resource{farm}</t:Cell><t:Cell>$Resource{house}</t:Cell><t:Cell>$Resource{breedBatch}</t:Cell><t:Cell>$Resource{outArea}</t:Cell><t:Cell>$Resource{farmer}</t:Cell><t:Cell>$Resource{outFarm}</t:Cell><t:Cell>$Resource{outHouse}</t:Cell><t:Cell>$Resource{CostObject}</t:Cell><t:Cell>$Resource{outBatch}</t:Cell><t:Cell>$Resource{genderType}</t:Cell><t:Cell>$Resource{supplier}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{eggLog}</t:Cell><t:Cell>$Resource{weekAge}</t:Cell><t:Cell>$Resource{dayAge}</t:Cell><t:Cell>$Resource{isFormal}</t:Cell><t:Cell>$Resource{qc1lv1Qty}</t:Cell><t:Cell>$Resource{qc1lv2Qty}</t:Cell><t:Cell>$Resource{qc2lv1Qty}</t:Cell><t:Cell>$Resource{qc2lv2Qty}</t:Cell><t:Cell>$Resource{qc3lv1Qty}</t:Cell><t:Cell>$Resource{qc4lv1Qty}</t:Cell><t:Cell>$Resource{qc5lv1Qty}</t:Cell><t:Cell>$Resource{qc6lv1Qty}</t:Cell><t:Cell>$Resource{qcEggType}</t:Cell><t:Cell>$Resource{eggQty}</t:Cell><t:Cell>$Resource{healthEggQty}</t:Cell><t:Cell>$Resource{lphealthEggQty}</t:Cell><t:Cell>$Resource{noFertileEggQty}</t:Cell><t:Cell>$Resource{brokenYolkQty}</t:Cell><t:Cell>$Resource{addleEggQty}</t:Cell><t:Cell>$Resource{lossQty}</t:Cell><t:Cell>$Resource{otherEggQty}</t:Cell><t:Cell>$Resource{fertilityRate}</t:Cell><t:Cell>$Resource{liveEggRate}</t:Cell><t:Cell>$Resource{addleEggRate}</t:Cell><t:Cell>$Resource{diffEggQty}</t:Cell><t:Cell>$Resource{brokenRate}</t:Cell><t:Cell>$Resource{hatchsBox}</t:Cell><t:Cell>$Resource{noFertileEggRate}</t:Cell><t:Cell>$Resource{rottenRate}</t:Cell><t:Cell>$Resource{rottenEggQty}</t:Cell><t:Cell>$Resource{brokenEggQty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEggEntries.setFormatXml(resHelper.translateString("kdtEggEntries",kdtEggEntriesStrXML));
        kdtEggEntries.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtEggEntries_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtEggEntries.putBindContents("editData",new String[] {"hatchHouse","incubator","hatchCarNum","seq","eggSourceType","isMix","eggDate","farm","house","breedBatch","outArea","farmer","outFarm","outHouse","CostObject","outBatch","genderType","supplier","material","eggLog","weekAge","dayAge","isFormal","qc1lv1Qty","qc1lv2Qty","qc2lv1Qty","qc2lv2Qty","qc3lv1Qty","qc4lv1Qty","qc5lv1Qty","qc6lv1Qty","qcEggType","eggQty","healthEggQty","lphealthEggQty","noFertileEggQty","brokenYolkQty","addleEggQty","lossQty","otherEggQty","fertilityRate","liveEggRate","addleEggRate","diffEggQty","brokenRate","hatchsBox","noFertileEggRate","rottenRate","rottenEggQty","brokenEggQty"});


        this.kdtEggEntries.checkParsed();
        final KDBizPromptBox kdtEggEntries_hatchHouse_PromptBox = new KDBizPromptBox();
        kdtEggEntries_hatchHouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.hatch.app.HatchHouseQuery");
        kdtEggEntries_hatchHouse_PromptBox.setVisible(true);
        kdtEggEntries_hatchHouse_PromptBox.setEditable(true);
        kdtEggEntries_hatchHouse_PromptBox.setDisplayFormat("$number$");
        kdtEggEntries_hatchHouse_PromptBox.setEditFormat("$number$");
        kdtEggEntries_hatchHouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntries_hatchHouse_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_hatchHouse_PromptBox);
        this.kdtEggEntries.getColumn("hatchHouse").setEditor(kdtEggEntries_hatchHouse_CellEditor);
        ObjectValueRender kdtEggEntries_hatchHouse_OVR = new ObjectValueRender();
        kdtEggEntries_hatchHouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntries.getColumn("hatchHouse").setRenderer(kdtEggEntries_hatchHouse_OVR);
        			kdtEggEntries_hatchHouse_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.HatchHouseListUI kdtEggEntries_hatchHouse_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEggEntries_hatchHouse_PromptBox_F7ListUI == null) {
					try {
						kdtEggEntries_hatchHouse_PromptBox_F7ListUI = new com.kingdee.eas.farm.hatch.client.HatchHouseListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEggEntries_hatchHouse_PromptBox_F7ListUI));
					kdtEggEntries_hatchHouse_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEggEntries_hatchHouse_PromptBox.setSelector(kdtEggEntries_hatchHouse_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEggEntries_incubator_PromptBox = new KDBizPromptBox();
        kdtEggEntries_incubator_PromptBox.setQueryInfo("com.kingdee.eas.farm.hatch.app.F7IncubatorQuery");
        kdtEggEntries_incubator_PromptBox.setVisible(true);
        kdtEggEntries_incubator_PromptBox.setEditable(true);
        kdtEggEntries_incubator_PromptBox.setDisplayFormat("$number$");
        kdtEggEntries_incubator_PromptBox.setEditFormat("$number$");
        kdtEggEntries_incubator_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntries_incubator_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_incubator_PromptBox);
        this.kdtEggEntries.getColumn("incubator").setEditor(kdtEggEntries_incubator_CellEditor);
        ObjectValueRender kdtEggEntries_incubator_OVR = new ObjectValueRender();
        kdtEggEntries_incubator_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntries.getColumn("incubator").setRenderer(kdtEggEntries_incubator_OVR);
        			kdtEggEntries_incubator_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.IncubatorListUI kdtEggEntries_incubator_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEggEntries_incubator_PromptBox_F7ListUI == null) {
					try {
						kdtEggEntries_incubator_PromptBox_F7ListUI = new com.kingdee.eas.farm.hatch.client.IncubatorListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEggEntries_incubator_PromptBox_F7ListUI));
					kdtEggEntries_incubator_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEggEntries_incubator_PromptBox.setSelector(kdtEggEntries_incubator_PromptBox_F7ListUI);
				}
			}
		});
					
        KDTextField kdtEggEntries_hatchCarNum_TextField = new KDTextField();
        kdtEggEntries_hatchCarNum_TextField.setName("kdtEggEntries_hatchCarNum_TextField");
        kdtEggEntries_hatchCarNum_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEggEntries_hatchCarNum_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_hatchCarNum_TextField);
        this.kdtEggEntries.getColumn("hatchCarNum").setEditor(kdtEggEntries_hatchCarNum_CellEditor);
        KDComboBox kdtEggEntries_eggSourceType_ComboBox = new KDComboBox();
        kdtEggEntries_eggSourceType_ComboBox.setName("kdtEggEntries_eggSourceType_ComboBox");
        kdtEggEntries_eggSourceType_ComboBox.setVisible(true);
        kdtEggEntries_eggSourceType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.hatch.EggSourceType").toArray());
        KDTDefaultCellEditor kdtEggEntries_eggSourceType_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_eggSourceType_ComboBox);
        this.kdtEggEntries.getColumn("eggSourceType").setEditor(kdtEggEntries_eggSourceType_CellEditor);
        KDCheckBox kdtEggEntries_isMix_CheckBox = new KDCheckBox();
        kdtEggEntries_isMix_CheckBox.setName("kdtEggEntries_isMix_CheckBox");
        KDTDefaultCellEditor kdtEggEntries_isMix_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_isMix_CheckBox);
        this.kdtEggEntries.getColumn("isMix").setEditor(kdtEggEntries_isMix_CellEditor);
        KDDatePicker kdtEggEntries_eggDate_DatePicker = new KDDatePicker();
        kdtEggEntries_eggDate_DatePicker.setName("kdtEggEntries_eggDate_DatePicker");
        kdtEggEntries_eggDate_DatePicker.setVisible(true);
        kdtEggEntries_eggDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEggEntries_eggDate_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_eggDate_DatePicker);
        this.kdtEggEntries.getColumn("eggDate").setEditor(kdtEggEntries_eggDate_CellEditor);
        final KDBizPromptBox kdtEggEntries_farm_PromptBox = new KDBizPromptBox();
        kdtEggEntries_farm_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.F7BreedStoorgSetQuery");
        kdtEggEntries_farm_PromptBox.setVisible(true);
        kdtEggEntries_farm_PromptBox.setEditable(true);
        kdtEggEntries_farm_PromptBox.setDisplayFormat("$number$");
        kdtEggEntries_farm_PromptBox.setEditFormat("$number$");
        kdtEggEntries_farm_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntries_farm_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_farm_PromptBox);
        this.kdtEggEntries.getColumn("farm").setEditor(kdtEggEntries_farm_CellEditor);
        ObjectValueRender kdtEggEntries_farm_OVR = new ObjectValueRender();
        kdtEggEntries_farm_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntries.getColumn("farm").setRenderer(kdtEggEntries_farm_OVR);
        final KDBizPromptBox kdtEggEntries_house_PromptBox = new KDBizPromptBox();
        kdtEggEntries_house_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseF7Query");
        kdtEggEntries_house_PromptBox.setVisible(true);
        kdtEggEntries_house_PromptBox.setEditable(true);
        kdtEggEntries_house_PromptBox.setDisplayFormat("$number$");
        kdtEggEntries_house_PromptBox.setEditFormat("$number$");
        kdtEggEntries_house_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntries_house_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_house_PromptBox);
        this.kdtEggEntries.getColumn("house").setEditor(kdtEggEntries_house_CellEditor);
        ObjectValueRender kdtEggEntries_house_OVR = new ObjectValueRender();
        kdtEggEntries_house_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntries.getColumn("house").setRenderer(kdtEggEntries_house_OVR);
        final KDBizPromptBox kdtEggEntries_breedBatch_PromptBox = new KDBizPromptBox();
        kdtEggEntries_breedBatch_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.ParentBreedBatchQuery");
        kdtEggEntries_breedBatch_PromptBox.setVisible(true);
        kdtEggEntries_breedBatch_PromptBox.setEditable(true);
        kdtEggEntries_breedBatch_PromptBox.setDisplayFormat("$number$");
        kdtEggEntries_breedBatch_PromptBox.setEditFormat("$number$");
        kdtEggEntries_breedBatch_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntries_breedBatch_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_breedBatch_PromptBox);
        this.kdtEggEntries.getColumn("breedBatch").setEditor(kdtEggEntries_breedBatch_CellEditor);
        ObjectValueRender kdtEggEntries_breedBatch_OVR = new ObjectValueRender();
        kdtEggEntries_breedBatch_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEggEntries.getColumn("breedBatch").setRenderer(kdtEggEntries_breedBatch_OVR);
        final KDBizPromptBox kdtEggEntries_outArea_PromptBox = new KDBizPromptBox();
        kdtEggEntries_outArea_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.F7FarmerGroupQuery");
        kdtEggEntries_outArea_PromptBox.setVisible(true);
        kdtEggEntries_outArea_PromptBox.setEditable(true);
        kdtEggEntries_outArea_PromptBox.setDisplayFormat("$number$");
        kdtEggEntries_outArea_PromptBox.setEditFormat("$number$");
        kdtEggEntries_outArea_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntries_outArea_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_outArea_PromptBox);
        this.kdtEggEntries.getColumn("outArea").setEditor(kdtEggEntries_outArea_CellEditor);
        ObjectValueRender kdtEggEntries_outArea_OVR = new ObjectValueRender();
        kdtEggEntries_outArea_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntries.getColumn("outArea").setRenderer(kdtEggEntries_outArea_OVR);
        final KDBizPromptBox kdtEggEntries_farmer_PromptBox = new KDBizPromptBox();
        kdtEggEntries_farmer_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmersQuery");
        kdtEggEntries_farmer_PromptBox.setVisible(true);
        kdtEggEntries_farmer_PromptBox.setEditable(true);
        kdtEggEntries_farmer_PromptBox.setDisplayFormat("$number$");
        kdtEggEntries_farmer_PromptBox.setEditFormat("$number$");
        kdtEggEntries_farmer_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntries_farmer_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_farmer_PromptBox);
        this.kdtEggEntries.getColumn("farmer").setEditor(kdtEggEntries_farmer_CellEditor);
        ObjectValueRender kdtEggEntries_farmer_OVR = new ObjectValueRender();
        kdtEggEntries_farmer_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntries.getColumn("farmer").setRenderer(kdtEggEntries_farmer_OVR);
        			kdtEggEntries_farmer_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI kdtEggEntries_farmer_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEggEntries_farmer_PromptBox_F7ListUI == null) {
					try {
						kdtEggEntries_farmer_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEggEntries_farmer_PromptBox_F7ListUI));
					kdtEggEntries_farmer_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEggEntries_farmer_PromptBox.setSelector(kdtEggEntries_farmer_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEggEntries_outFarm_PromptBox = new KDBizPromptBox();
        kdtEggEntries_outFarm_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmQuery");
        kdtEggEntries_outFarm_PromptBox.setVisible(true);
        kdtEggEntries_outFarm_PromptBox.setEditable(true);
        kdtEggEntries_outFarm_PromptBox.setDisplayFormat("$number$");
        kdtEggEntries_outFarm_PromptBox.setEditFormat("$number$");
        kdtEggEntries_outFarm_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntries_outFarm_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_outFarm_PromptBox);
        this.kdtEggEntries.getColumn("outFarm").setEditor(kdtEggEntries_outFarm_CellEditor);
        ObjectValueRender kdtEggEntries_outFarm_OVR = new ObjectValueRender();
        kdtEggEntries_outFarm_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntries.getColumn("outFarm").setRenderer(kdtEggEntries_outFarm_OVR);
        			kdtEggEntries_outFarm_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmListUI kdtEggEntries_outFarm_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEggEntries_outFarm_PromptBox_F7ListUI == null) {
					try {
						kdtEggEntries_outFarm_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEggEntries_outFarm_PromptBox_F7ListUI));
					kdtEggEntries_outFarm_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEggEntries_outFarm_PromptBox.setSelector(kdtEggEntries_outFarm_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEggEntries_outHouse_PromptBox = new KDBizPromptBox();
        kdtEggEntries_outHouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
        kdtEggEntries_outHouse_PromptBox.setVisible(true);
        kdtEggEntries_outHouse_PromptBox.setEditable(true);
        kdtEggEntries_outHouse_PromptBox.setDisplayFormat("$number$");
        kdtEggEntries_outHouse_PromptBox.setEditFormat("$number$");
        kdtEggEntries_outHouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntries_outHouse_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_outHouse_PromptBox);
        this.kdtEggEntries.getColumn("outHouse").setEditor(kdtEggEntries_outHouse_CellEditor);
        ObjectValueRender kdtEggEntries_outHouse_OVR = new ObjectValueRender();
        kdtEggEntries_outHouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntries.getColumn("outHouse").setRenderer(kdtEggEntries_outHouse_OVR);
        final KDBizPromptBox kdtEggEntries_CostObject_PromptBox = new KDBizPromptBox();
        kdtEggEntries_CostObject_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");
        kdtEggEntries_CostObject_PromptBox.setVisible(true);
        kdtEggEntries_CostObject_PromptBox.setEditable(true);
        kdtEggEntries_CostObject_PromptBox.setDisplayFormat("$number$");
        kdtEggEntries_CostObject_PromptBox.setEditFormat("$number$");
        kdtEggEntries_CostObject_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntries_CostObject_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_CostObject_PromptBox);
        this.kdtEggEntries.getColumn("CostObject").setEditor(kdtEggEntries_CostObject_CellEditor);
        ObjectValueRender kdtEggEntries_CostObject_OVR = new ObjectValueRender();
        kdtEggEntries_CostObject_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntries.getColumn("CostObject").setRenderer(kdtEggEntries_CostObject_OVR);
        final KDBizPromptBox kdtEggEntries_outBatch_PromptBox = new KDBizPromptBox();
        kdtEggEntries_outBatch_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.StockingBatchQuery");
        kdtEggEntries_outBatch_PromptBox.setVisible(true);
        kdtEggEntries_outBatch_PromptBox.setEditable(true);
        kdtEggEntries_outBatch_PromptBox.setDisplayFormat("$number$");
        kdtEggEntries_outBatch_PromptBox.setEditFormat("$number$");
        kdtEggEntries_outBatch_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntries_outBatch_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_outBatch_PromptBox);
        this.kdtEggEntries.getColumn("outBatch").setEditor(kdtEggEntries_outBatch_CellEditor);
        ObjectValueRender kdtEggEntries_outBatch_OVR = new ObjectValueRender();
        kdtEggEntries_outBatch_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEggEntries.getColumn("outBatch").setRenderer(kdtEggEntries_outBatch_OVR);
        			kdtEggEntries_outBatch_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI kdtEggEntries_outBatch_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEggEntries_outBatch_PromptBox_F7ListUI == null) {
					try {
						kdtEggEntries_outBatch_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEggEntries_outBatch_PromptBox_F7ListUI));
					kdtEggEntries_outBatch_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEggEntries_outBatch_PromptBox.setSelector(kdtEggEntries_outBatch_PromptBox_F7ListUI);
				}
			}
		});
					
        KDComboBox kdtEggEntries_genderType_ComboBox = new KDComboBox();
        kdtEggEntries_genderType_ComboBox.setName("kdtEggEntries_genderType_ComboBox");
        kdtEggEntries_genderType_ComboBox.setVisible(true);
        kdtEggEntries_genderType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.hatch.GenderType").toArray());
        KDTDefaultCellEditor kdtEggEntries_genderType_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_genderType_ComboBox);
        this.kdtEggEntries.getColumn("genderType").setEditor(kdtEggEntries_genderType_CellEditor);
        final KDBizPromptBox kdtEggEntries_supplier_PromptBox = new KDBizPromptBox();
        kdtEggEntries_supplier_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.F7SupplierDefaultQuery");
        kdtEggEntries_supplier_PromptBox.setVisible(true);
        kdtEggEntries_supplier_PromptBox.setEditable(true);
        kdtEggEntries_supplier_PromptBox.setDisplayFormat("$number$");
        kdtEggEntries_supplier_PromptBox.setEditFormat("$number$");
        kdtEggEntries_supplier_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntries_supplier_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_supplier_PromptBox);
        this.kdtEggEntries.getColumn("supplier").setEditor(kdtEggEntries_supplier_CellEditor);
        ObjectValueRender kdtEggEntries_supplier_OVR = new ObjectValueRender();
        kdtEggEntries_supplier_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntries.getColumn("supplier").setRenderer(kdtEggEntries_supplier_OVR);
        final KDBizPromptBox kdtEggEntries_material_PromptBox = new KDBizPromptBox();
        kdtEggEntries_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtEggEntries_material_PromptBox.setVisible(true);
        kdtEggEntries_material_PromptBox.setEditable(true);
        kdtEggEntries_material_PromptBox.setDisplayFormat("$number$");
        kdtEggEntries_material_PromptBox.setEditFormat("$number$");
        kdtEggEntries_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntries_material_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_material_PromptBox);
        this.kdtEggEntries.getColumn("material").setEditor(kdtEggEntries_material_CellEditor);
        ObjectValueRender kdtEggEntries_material_OVR = new ObjectValueRender();
        kdtEggEntries_material_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntries.getColumn("material").setRenderer(kdtEggEntries_material_OVR);
        KDTextField kdtEggEntries_eggLog_TextField = new KDTextField();
        kdtEggEntries_eggLog_TextField.setName("kdtEggEntries_eggLog_TextField");
        kdtEggEntries_eggLog_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEggEntries_eggLog_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_eggLog_TextField);
        this.kdtEggEntries.getColumn("eggLog").setEditor(kdtEggEntries_eggLog_CellEditor);
        KDTextField kdtEggEntries_weekAge_TextField = new KDTextField();
        kdtEggEntries_weekAge_TextField.setName("kdtEggEntries_weekAge_TextField");
        kdtEggEntries_weekAge_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEggEntries_weekAge_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_weekAge_TextField);
        this.kdtEggEntries.getColumn("weekAge").setEditor(kdtEggEntries_weekAge_CellEditor);
        KDFormattedTextField kdtEggEntries_dayAge_TextField = new KDFormattedTextField();
        kdtEggEntries_dayAge_TextField.setName("kdtEggEntries_dayAge_TextField");
        kdtEggEntries_dayAge_TextField.setVisible(true);
        kdtEggEntries_dayAge_TextField.setEditable(true);
        kdtEggEntries_dayAge_TextField.setHorizontalAlignment(2);
        kdtEggEntries_dayAge_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntries_dayAge_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_dayAge_TextField);
        this.kdtEggEntries.getColumn("dayAge").setEditor(kdtEggEntries_dayAge_CellEditor);
        KDCheckBox kdtEggEntries_isFormal_CheckBox = new KDCheckBox();
        kdtEggEntries_isFormal_CheckBox.setName("kdtEggEntries_isFormal_CheckBox");
        KDTDefaultCellEditor kdtEggEntries_isFormal_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_isFormal_CheckBox);
        this.kdtEggEntries.getColumn("isFormal").setEditor(kdtEggEntries_isFormal_CellEditor);
        KDFormattedTextField kdtEggEntries_qc1lv1Qty_TextField = new KDFormattedTextField();
        kdtEggEntries_qc1lv1Qty_TextField.setName("kdtEggEntries_qc1lv1Qty_TextField");
        kdtEggEntries_qc1lv1Qty_TextField.setVisible(true);
        kdtEggEntries_qc1lv1Qty_TextField.setEditable(true);
        kdtEggEntries_qc1lv1Qty_TextField.setHorizontalAlignment(2);
        kdtEggEntries_qc1lv1Qty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntries_qc1lv1Qty_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_qc1lv1Qty_TextField);
        this.kdtEggEntries.getColumn("qc1lv1Qty").setEditor(kdtEggEntries_qc1lv1Qty_CellEditor);
        KDFormattedTextField kdtEggEntries_qc1lv2Qty_TextField = new KDFormattedTextField();
        kdtEggEntries_qc1lv2Qty_TextField.setName("kdtEggEntries_qc1lv2Qty_TextField");
        kdtEggEntries_qc1lv2Qty_TextField.setVisible(true);
        kdtEggEntries_qc1lv2Qty_TextField.setEditable(true);
        kdtEggEntries_qc1lv2Qty_TextField.setHorizontalAlignment(2);
        kdtEggEntries_qc1lv2Qty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntries_qc1lv2Qty_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_qc1lv2Qty_TextField);
        this.kdtEggEntries.getColumn("qc1lv2Qty").setEditor(kdtEggEntries_qc1lv2Qty_CellEditor);
        KDFormattedTextField kdtEggEntries_qc2lv1Qty_TextField = new KDFormattedTextField();
        kdtEggEntries_qc2lv1Qty_TextField.setName("kdtEggEntries_qc2lv1Qty_TextField");
        kdtEggEntries_qc2lv1Qty_TextField.setVisible(true);
        kdtEggEntries_qc2lv1Qty_TextField.setEditable(true);
        kdtEggEntries_qc2lv1Qty_TextField.setHorizontalAlignment(2);
        kdtEggEntries_qc2lv1Qty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntries_qc2lv1Qty_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_qc2lv1Qty_TextField);
        this.kdtEggEntries.getColumn("qc2lv1Qty").setEditor(kdtEggEntries_qc2lv1Qty_CellEditor);
        KDFormattedTextField kdtEggEntries_qc2lv2Qty_TextField = new KDFormattedTextField();
        kdtEggEntries_qc2lv2Qty_TextField.setName("kdtEggEntries_qc2lv2Qty_TextField");
        kdtEggEntries_qc2lv2Qty_TextField.setVisible(true);
        kdtEggEntries_qc2lv2Qty_TextField.setEditable(true);
        kdtEggEntries_qc2lv2Qty_TextField.setHorizontalAlignment(2);
        kdtEggEntries_qc2lv2Qty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntries_qc2lv2Qty_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_qc2lv2Qty_TextField);
        this.kdtEggEntries.getColumn("qc2lv2Qty").setEditor(kdtEggEntries_qc2lv2Qty_CellEditor);
        KDFormattedTextField kdtEggEntries_qc3lv1Qty_TextField = new KDFormattedTextField();
        kdtEggEntries_qc3lv1Qty_TextField.setName("kdtEggEntries_qc3lv1Qty_TextField");
        kdtEggEntries_qc3lv1Qty_TextField.setVisible(true);
        kdtEggEntries_qc3lv1Qty_TextField.setEditable(true);
        kdtEggEntries_qc3lv1Qty_TextField.setHorizontalAlignment(2);
        kdtEggEntries_qc3lv1Qty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntries_qc3lv1Qty_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_qc3lv1Qty_TextField);
        this.kdtEggEntries.getColumn("qc3lv1Qty").setEditor(kdtEggEntries_qc3lv1Qty_CellEditor);
        KDFormattedTextField kdtEggEntries_qc4lv1Qty_TextField = new KDFormattedTextField();
        kdtEggEntries_qc4lv1Qty_TextField.setName("kdtEggEntries_qc4lv1Qty_TextField");
        kdtEggEntries_qc4lv1Qty_TextField.setVisible(true);
        kdtEggEntries_qc4lv1Qty_TextField.setEditable(true);
        kdtEggEntries_qc4lv1Qty_TextField.setHorizontalAlignment(2);
        kdtEggEntries_qc4lv1Qty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntries_qc4lv1Qty_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_qc4lv1Qty_TextField);
        this.kdtEggEntries.getColumn("qc4lv1Qty").setEditor(kdtEggEntries_qc4lv1Qty_CellEditor);
        KDFormattedTextField kdtEggEntries_qc5lv1Qty_TextField = new KDFormattedTextField();
        kdtEggEntries_qc5lv1Qty_TextField.setName("kdtEggEntries_qc5lv1Qty_TextField");
        kdtEggEntries_qc5lv1Qty_TextField.setVisible(true);
        kdtEggEntries_qc5lv1Qty_TextField.setEditable(true);
        kdtEggEntries_qc5lv1Qty_TextField.setHorizontalAlignment(2);
        kdtEggEntries_qc5lv1Qty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntries_qc5lv1Qty_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_qc5lv1Qty_TextField);
        this.kdtEggEntries.getColumn("qc5lv1Qty").setEditor(kdtEggEntries_qc5lv1Qty_CellEditor);
        KDFormattedTextField kdtEggEntries_qc6lv1Qty_TextField = new KDFormattedTextField();
        kdtEggEntries_qc6lv1Qty_TextField.setName("kdtEggEntries_qc6lv1Qty_TextField");
        kdtEggEntries_qc6lv1Qty_TextField.setVisible(true);
        kdtEggEntries_qc6lv1Qty_TextField.setEditable(true);
        kdtEggEntries_qc6lv1Qty_TextField.setHorizontalAlignment(2);
        kdtEggEntries_qc6lv1Qty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntries_qc6lv1Qty_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_qc6lv1Qty_TextField);
        this.kdtEggEntries.getColumn("qc6lv1Qty").setEditor(kdtEggEntries_qc6lv1Qty_CellEditor);
        KDComboBox kdtEggEntries_qcEggType_ComboBox = new KDComboBox();
        kdtEggEntries_qcEggType_ComboBox.setName("kdtEggEntries_qcEggType_ComboBox");
        kdtEggEntries_qcEggType_ComboBox.setVisible(true);
        kdtEggEntries_qcEggType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.hatch.QcEggTypeEnum").toArray());
        KDTDefaultCellEditor kdtEggEntries_qcEggType_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_qcEggType_ComboBox);
        this.kdtEggEntries.getColumn("qcEggType").setEditor(kdtEggEntries_qcEggType_CellEditor);
        KDFormattedTextField kdtEggEntries_eggQty_TextField = new KDFormattedTextField();
        kdtEggEntries_eggQty_TextField.setName("kdtEggEntries_eggQty_TextField");
        kdtEggEntries_eggQty_TextField.setVisible(true);
        kdtEggEntries_eggQty_TextField.setEditable(true);
        kdtEggEntries_eggQty_TextField.setHorizontalAlignment(2);
        kdtEggEntries_eggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntries_eggQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_eggQty_TextField);
        this.kdtEggEntries.getColumn("eggQty").setEditor(kdtEggEntries_eggQty_CellEditor);
        KDFormattedTextField kdtEggEntries_healthEggQty_TextField = new KDFormattedTextField();
        kdtEggEntries_healthEggQty_TextField.setName("kdtEggEntries_healthEggQty_TextField");
        kdtEggEntries_healthEggQty_TextField.setVisible(true);
        kdtEggEntries_healthEggQty_TextField.setEditable(true);
        kdtEggEntries_healthEggQty_TextField.setHorizontalAlignment(2);
        kdtEggEntries_healthEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntries_healthEggQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_healthEggQty_TextField);
        this.kdtEggEntries.getColumn("healthEggQty").setEditor(kdtEggEntries_healthEggQty_CellEditor);
        KDFormattedTextField kdtEggEntries_lphealthEggQty_TextField = new KDFormattedTextField();
        kdtEggEntries_lphealthEggQty_TextField.setName("kdtEggEntries_lphealthEggQty_TextField");
        kdtEggEntries_lphealthEggQty_TextField.setVisible(true);
        kdtEggEntries_lphealthEggQty_TextField.setEditable(true);
        kdtEggEntries_lphealthEggQty_TextField.setHorizontalAlignment(2);
        kdtEggEntries_lphealthEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntries_lphealthEggQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_lphealthEggQty_TextField);
        this.kdtEggEntries.getColumn("lphealthEggQty").setEditor(kdtEggEntries_lphealthEggQty_CellEditor);
        KDFormattedTextField kdtEggEntries_noFertileEggQty_TextField = new KDFormattedTextField();
        kdtEggEntries_noFertileEggQty_TextField.setName("kdtEggEntries_noFertileEggQty_TextField");
        kdtEggEntries_noFertileEggQty_TextField.setVisible(true);
        kdtEggEntries_noFertileEggQty_TextField.setEditable(true);
        kdtEggEntries_noFertileEggQty_TextField.setHorizontalAlignment(2);
        kdtEggEntries_noFertileEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntries_noFertileEggQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_noFertileEggQty_TextField);
        this.kdtEggEntries.getColumn("noFertileEggQty").setEditor(kdtEggEntries_noFertileEggQty_CellEditor);
        KDFormattedTextField kdtEggEntries_brokenYolkQty_TextField = new KDFormattedTextField();
        kdtEggEntries_brokenYolkQty_TextField.setName("kdtEggEntries_brokenYolkQty_TextField");
        kdtEggEntries_brokenYolkQty_TextField.setVisible(true);
        kdtEggEntries_brokenYolkQty_TextField.setEditable(true);
        kdtEggEntries_brokenYolkQty_TextField.setHorizontalAlignment(2);
        kdtEggEntries_brokenYolkQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntries_brokenYolkQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_brokenYolkQty_TextField);
        this.kdtEggEntries.getColumn("brokenYolkQty").setEditor(kdtEggEntries_brokenYolkQty_CellEditor);
        KDFormattedTextField kdtEggEntries_addleEggQty_TextField = new KDFormattedTextField();
        kdtEggEntries_addleEggQty_TextField.setName("kdtEggEntries_addleEggQty_TextField");
        kdtEggEntries_addleEggQty_TextField.setVisible(true);
        kdtEggEntries_addleEggQty_TextField.setEditable(true);
        kdtEggEntries_addleEggQty_TextField.setHorizontalAlignment(2);
        kdtEggEntries_addleEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntries_addleEggQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_addleEggQty_TextField);
        this.kdtEggEntries.getColumn("addleEggQty").setEditor(kdtEggEntries_addleEggQty_CellEditor);
        KDFormattedTextField kdtEggEntries_lossQty_TextField = new KDFormattedTextField();
        kdtEggEntries_lossQty_TextField.setName("kdtEggEntries_lossQty_TextField");
        kdtEggEntries_lossQty_TextField.setVisible(true);
        kdtEggEntries_lossQty_TextField.setEditable(true);
        kdtEggEntries_lossQty_TextField.setHorizontalAlignment(2);
        kdtEggEntries_lossQty_TextField.setDataType(1);
        	kdtEggEntries_lossQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEggEntries_lossQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEggEntries_lossQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEggEntries_lossQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_lossQty_TextField);
        this.kdtEggEntries.getColumn("lossQty").setEditor(kdtEggEntries_lossQty_CellEditor);
        KDFormattedTextField kdtEggEntries_otherEggQty_TextField = new KDFormattedTextField();
        kdtEggEntries_otherEggQty_TextField.setName("kdtEggEntries_otherEggQty_TextField");
        kdtEggEntries_otherEggQty_TextField.setVisible(true);
        kdtEggEntries_otherEggQty_TextField.setEditable(true);
        kdtEggEntries_otherEggQty_TextField.setHorizontalAlignment(2);
        kdtEggEntries_otherEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntries_otherEggQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_otherEggQty_TextField);
        this.kdtEggEntries.getColumn("otherEggQty").setEditor(kdtEggEntries_otherEggQty_CellEditor);
        KDFormattedTextField kdtEggEntries_fertilityRate_TextField = new KDFormattedTextField();
        kdtEggEntries_fertilityRate_TextField.setName("kdtEggEntries_fertilityRate_TextField");
        kdtEggEntries_fertilityRate_TextField.setVisible(true);
        kdtEggEntries_fertilityRate_TextField.setEditable(true);
        kdtEggEntries_fertilityRate_TextField.setHorizontalAlignment(2);
        kdtEggEntries_fertilityRate_TextField.setDataType(1);
        	kdtEggEntries_fertilityRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEggEntries_fertilityRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEggEntries_fertilityRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEggEntries_fertilityRate_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_fertilityRate_TextField);
        this.kdtEggEntries.getColumn("fertilityRate").setEditor(kdtEggEntries_fertilityRate_CellEditor);
        KDFormattedTextField kdtEggEntries_liveEggRate_TextField = new KDFormattedTextField();
        kdtEggEntries_liveEggRate_TextField.setName("kdtEggEntries_liveEggRate_TextField");
        kdtEggEntries_liveEggRate_TextField.setVisible(true);
        kdtEggEntries_liveEggRate_TextField.setEditable(true);
        kdtEggEntries_liveEggRate_TextField.setHorizontalAlignment(2);
        kdtEggEntries_liveEggRate_TextField.setDataType(1);
        	kdtEggEntries_liveEggRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEggEntries_liveEggRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEggEntries_liveEggRate_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEggEntries_liveEggRate_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_liveEggRate_TextField);
        this.kdtEggEntries.getColumn("liveEggRate").setEditor(kdtEggEntries_liveEggRate_CellEditor);
        KDFormattedTextField kdtEggEntries_addleEggRate_TextField = new KDFormattedTextField();
        kdtEggEntries_addleEggRate_TextField.setName("kdtEggEntries_addleEggRate_TextField");
        kdtEggEntries_addleEggRate_TextField.setVisible(true);
        kdtEggEntries_addleEggRate_TextField.setEditable(true);
        kdtEggEntries_addleEggRate_TextField.setHorizontalAlignment(2);
        kdtEggEntries_addleEggRate_TextField.setDataType(1);
        	kdtEggEntries_addleEggRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEggEntries_addleEggRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEggEntries_addleEggRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEggEntries_addleEggRate_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_addleEggRate_TextField);
        this.kdtEggEntries.getColumn("addleEggRate").setEditor(kdtEggEntries_addleEggRate_CellEditor);
        KDFormattedTextField kdtEggEntries_diffEggQty_TextField = new KDFormattedTextField();
        kdtEggEntries_diffEggQty_TextField.setName("kdtEggEntries_diffEggQty_TextField");
        kdtEggEntries_diffEggQty_TextField.setVisible(true);
        kdtEggEntries_diffEggQty_TextField.setEditable(true);
        kdtEggEntries_diffEggQty_TextField.setHorizontalAlignment(2);
        kdtEggEntries_diffEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntries_diffEggQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_diffEggQty_TextField);
        this.kdtEggEntries.getColumn("diffEggQty").setEditor(kdtEggEntries_diffEggQty_CellEditor);
        KDFormattedTextField kdtEggEntries_brokenRate_TextField = new KDFormattedTextField();
        kdtEggEntries_brokenRate_TextField.setName("kdtEggEntries_brokenRate_TextField");
        kdtEggEntries_brokenRate_TextField.setVisible(true);
        kdtEggEntries_brokenRate_TextField.setEditable(true);
        kdtEggEntries_brokenRate_TextField.setHorizontalAlignment(2);
        kdtEggEntries_brokenRate_TextField.setDataType(1);
        	kdtEggEntries_brokenRate_TextField.setMinimumValue(new java.math.BigDecimal("-999.999"));
        	kdtEggEntries_brokenRate_TextField.setMaximumValue(new java.math.BigDecimal("999.999"));
        kdtEggEntries_brokenRate_TextField.setPrecision(3);
        KDTDefaultCellEditor kdtEggEntries_brokenRate_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_brokenRate_TextField);
        this.kdtEggEntries.getColumn("brokenRate").setEditor(kdtEggEntries_brokenRate_CellEditor);
        final KDBizPromptBox kdtEggEntries_hatchsBox_PromptBox = new KDBizPromptBox();
        kdtEggEntries_hatchsBox_PromptBox.setQueryInfo("com.kingdee.eas.farm.hatch.app.F7HatchingBoxQuery");
        kdtEggEntries_hatchsBox_PromptBox.setVisible(true);
        kdtEggEntries_hatchsBox_PromptBox.setEditable(true);
        kdtEggEntries_hatchsBox_PromptBox.setDisplayFormat("$number$");
        kdtEggEntries_hatchsBox_PromptBox.setEditFormat("$number$");
        kdtEggEntries_hatchsBox_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntries_hatchsBox_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_hatchsBox_PromptBox);
        this.kdtEggEntries.getColumn("hatchsBox").setEditor(kdtEggEntries_hatchsBox_CellEditor);
        ObjectValueRender kdtEggEntries_hatchsBox_OVR = new ObjectValueRender();
        kdtEggEntries_hatchsBox_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntries.getColumn("hatchsBox").setRenderer(kdtEggEntries_hatchsBox_OVR);
        			kdtEggEntries_hatchsBox_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.HatchingBoxListUI kdtEggEntries_hatchsBox_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEggEntries_hatchsBox_PromptBox_F7ListUI == null) {
					try {
						kdtEggEntries_hatchsBox_PromptBox_F7ListUI = new com.kingdee.eas.farm.hatch.client.HatchingBoxListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEggEntries_hatchsBox_PromptBox_F7ListUI));
					kdtEggEntries_hatchsBox_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEggEntries_hatchsBox_PromptBox.setSelector(kdtEggEntries_hatchsBox_PromptBox_F7ListUI);
				}
			}
		});
					
        KDFormattedTextField kdtEggEntries_noFertileEggRate_TextField = new KDFormattedTextField();
        kdtEggEntries_noFertileEggRate_TextField.setName("kdtEggEntries_noFertileEggRate_TextField");
        kdtEggEntries_noFertileEggRate_TextField.setVisible(true);
        kdtEggEntries_noFertileEggRate_TextField.setEditable(true);
        kdtEggEntries_noFertileEggRate_TextField.setHorizontalAlignment(2);
        kdtEggEntries_noFertileEggRate_TextField.setDataType(1);
        	kdtEggEntries_noFertileEggRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEggEntries_noFertileEggRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEggEntries_noFertileEggRate_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEggEntries_noFertileEggRate_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_noFertileEggRate_TextField);
        this.kdtEggEntries.getColumn("noFertileEggRate").setEditor(kdtEggEntries_noFertileEggRate_CellEditor);
        KDFormattedTextField kdtEggEntries_rottenRate_TextField = new KDFormattedTextField();
        kdtEggEntries_rottenRate_TextField.setName("kdtEggEntries_rottenRate_TextField");
        kdtEggEntries_rottenRate_TextField.setVisible(true);
        kdtEggEntries_rottenRate_TextField.setEditable(true);
        kdtEggEntries_rottenRate_TextField.setHorizontalAlignment(2);
        kdtEggEntries_rottenRate_TextField.setDataType(1);
        	kdtEggEntries_rottenRate_TextField.setMinimumValue(new java.math.BigDecimal("-999.999"));
        	kdtEggEntries_rottenRate_TextField.setMaximumValue(new java.math.BigDecimal("999.999"));
        kdtEggEntries_rottenRate_TextField.setPrecision(3);
        KDTDefaultCellEditor kdtEggEntries_rottenRate_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_rottenRate_TextField);
        this.kdtEggEntries.getColumn("rottenRate").setEditor(kdtEggEntries_rottenRate_CellEditor);
        KDFormattedTextField kdtEggEntries_rottenEggQty_TextField = new KDFormattedTextField();
        kdtEggEntries_rottenEggQty_TextField.setName("kdtEggEntries_rottenEggQty_TextField");
        kdtEggEntries_rottenEggQty_TextField.setVisible(true);
        kdtEggEntries_rottenEggQty_TextField.setEditable(true);
        kdtEggEntries_rottenEggQty_TextField.setHorizontalAlignment(2);
        kdtEggEntries_rottenEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntries_rottenEggQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_rottenEggQty_TextField);
        this.kdtEggEntries.getColumn("rottenEggQty").setEditor(kdtEggEntries_rottenEggQty_CellEditor);
        KDFormattedTextField kdtEggEntries_brokenEggQty_TextField = new KDFormattedTextField();
        kdtEggEntries_brokenEggQty_TextField.setName("kdtEggEntries_brokenEggQty_TextField");
        kdtEggEntries_brokenEggQty_TextField.setVisible(true);
        kdtEggEntries_brokenEggQty_TextField.setEditable(true);
        kdtEggEntries_brokenEggQty_TextField.setHorizontalAlignment(2);
        kdtEggEntries_brokenEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntries_brokenEggQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntries_brokenEggQty_TextField);
        this.kdtEggEntries.getColumn("brokenEggQty").setEditor(kdtEggEntries_brokenEggQty_CellEditor);
        // kdtFarmerSumEntry
		String kdtFarmerSumEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol16\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"farmer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"supploer1\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"house\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"hgdlx\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"eggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"healthEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"noFertileEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"brokenYolkQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"addleEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"rottenEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"brokenEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"diffEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"fertilityRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"addleEggRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"brokenRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"rottenRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{farmer}</t:Cell><t:Cell>$Resource{supploer1}</t:Cell><t:Cell>$Resource{house}</t:Cell><t:Cell>$Resource{hgdlx}</t:Cell><t:Cell>$Resource{eggQty}</t:Cell><t:Cell>$Resource{healthEggQty}</t:Cell><t:Cell>$Resource{noFertileEggQty}</t:Cell><t:Cell>$Resource{brokenYolkQty}</t:Cell><t:Cell>$Resource{addleEggQty}</t:Cell><t:Cell>$Resource{rottenEggQty}</t:Cell><t:Cell>$Resource{brokenEggQty}</t:Cell><t:Cell>$Resource{diffEggQty}</t:Cell><t:Cell>$Resource{fertilityRate}</t:Cell><t:Cell>$Resource{addleEggRate}</t:Cell><t:Cell>$Resource{brokenRate}</t:Cell><t:Cell>$Resource{rottenRate}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtFarmerSumEntry.setFormatXml(resHelper.translateString("kdtFarmerSumEntry",kdtFarmerSumEntryStrXML));

                this.kdtFarmerSumEntry.putBindContents("editData",new String[] {"seq","farmer","supploer1","house","hgdlx","eggQty","healthEggQty","noFertileEggQty","brokenYolkQty","addleEggQty","rottenEggQty","brokenEggQty","diffEggQty","fertilityRate","addleEggRate","brokenRate","rottenRate"});


        this.kdtFarmerSumEntry.checkParsed();
        final KDBizPromptBox kdtFarmerSumEntry_farmer_PromptBox = new KDBizPromptBox();
        kdtFarmerSumEntry_farmer_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmersQuery");
        kdtFarmerSumEntry_farmer_PromptBox.setVisible(true);
        kdtFarmerSumEntry_farmer_PromptBox.setEditable(true);
        kdtFarmerSumEntry_farmer_PromptBox.setDisplayFormat("$number$");
        kdtFarmerSumEntry_farmer_PromptBox.setEditFormat("$number$");
        kdtFarmerSumEntry_farmer_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtFarmerSumEntry_farmer_CellEditor = new KDTDefaultCellEditor(kdtFarmerSumEntry_farmer_PromptBox);
        this.kdtFarmerSumEntry.getColumn("farmer").setEditor(kdtFarmerSumEntry_farmer_CellEditor);
        ObjectValueRender kdtFarmerSumEntry_farmer_OVR = new ObjectValueRender();
        kdtFarmerSumEntry_farmer_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtFarmerSumEntry.getColumn("farmer").setRenderer(kdtFarmerSumEntry_farmer_OVR);
        			kdtFarmerSumEntry_farmer_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI kdtFarmerSumEntry_farmer_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtFarmerSumEntry_farmer_PromptBox_F7ListUI == null) {
					try {
						kdtFarmerSumEntry_farmer_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtFarmerSumEntry_farmer_PromptBox_F7ListUI));
					kdtFarmerSumEntry_farmer_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtFarmerSumEntry_farmer_PromptBox.setSelector(kdtFarmerSumEntry_farmer_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtFarmerSumEntry_supploer1_PromptBox = new KDBizPromptBox();
        kdtFarmerSumEntry_supploer1_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.F7SupplierDefaultQuery");
        kdtFarmerSumEntry_supploer1_PromptBox.setVisible(true);
        kdtFarmerSumEntry_supploer1_PromptBox.setEditable(true);
        kdtFarmerSumEntry_supploer1_PromptBox.setDisplayFormat("$number$");
        kdtFarmerSumEntry_supploer1_PromptBox.setEditFormat("$number$");
        kdtFarmerSumEntry_supploer1_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtFarmerSumEntry_supploer1_CellEditor = new KDTDefaultCellEditor(kdtFarmerSumEntry_supploer1_PromptBox);
        this.kdtFarmerSumEntry.getColumn("supploer1").setEditor(kdtFarmerSumEntry_supploer1_CellEditor);
        ObjectValueRender kdtFarmerSumEntry_supploer1_OVR = new ObjectValueRender();
        kdtFarmerSumEntry_supploer1_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtFarmerSumEntry.getColumn("supploer1").setRenderer(kdtFarmerSumEntry_supploer1_OVR);
        final KDBizPromptBox kdtFarmerSumEntry_house_PromptBox = new KDBizPromptBox();
        kdtFarmerSumEntry_house_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
        kdtFarmerSumEntry_house_PromptBox.setVisible(true);
        kdtFarmerSumEntry_house_PromptBox.setEditable(true);
        kdtFarmerSumEntry_house_PromptBox.setDisplayFormat("$number$");
        kdtFarmerSumEntry_house_PromptBox.setEditFormat("$number$");
        kdtFarmerSumEntry_house_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtFarmerSumEntry_house_CellEditor = new KDTDefaultCellEditor(kdtFarmerSumEntry_house_PromptBox);
        this.kdtFarmerSumEntry.getColumn("house").setEditor(kdtFarmerSumEntry_house_CellEditor);
        ObjectValueRender kdtFarmerSumEntry_house_OVR = new ObjectValueRender();
        kdtFarmerSumEntry_house_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtFarmerSumEntry.getColumn("house").setRenderer(kdtFarmerSumEntry_house_OVR);
        KDComboBox kdtFarmerSumEntry_hgdlx_ComboBox = new KDComboBox();
        kdtFarmerSumEntry_hgdlx_ComboBox.setName("kdtFarmerSumEntry_hgdlx_ComboBox");
        kdtFarmerSumEntry_hgdlx_ComboBox.setVisible(true);
        kdtFarmerSumEntry_hgdlx_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.hatch.QcEggTypeEnum").toArray());
        KDTDefaultCellEditor kdtFarmerSumEntry_hgdlx_CellEditor = new KDTDefaultCellEditor(kdtFarmerSumEntry_hgdlx_ComboBox);
        this.kdtFarmerSumEntry.getColumn("hgdlx").setEditor(kdtFarmerSumEntry_hgdlx_CellEditor);
        KDFormattedTextField kdtFarmerSumEntry_eggQty_TextField = new KDFormattedTextField();
        kdtFarmerSumEntry_eggQty_TextField.setName("kdtFarmerSumEntry_eggQty_TextField");
        kdtFarmerSumEntry_eggQty_TextField.setVisible(true);
        kdtFarmerSumEntry_eggQty_TextField.setEditable(true);
        kdtFarmerSumEntry_eggQty_TextField.setHorizontalAlignment(2);
        kdtFarmerSumEntry_eggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtFarmerSumEntry_eggQty_CellEditor = new KDTDefaultCellEditor(kdtFarmerSumEntry_eggQty_TextField);
        this.kdtFarmerSumEntry.getColumn("eggQty").setEditor(kdtFarmerSumEntry_eggQty_CellEditor);
        KDFormattedTextField kdtFarmerSumEntry_healthEggQty_TextField = new KDFormattedTextField();
        kdtFarmerSumEntry_healthEggQty_TextField.setName("kdtFarmerSumEntry_healthEggQty_TextField");
        kdtFarmerSumEntry_healthEggQty_TextField.setVisible(true);
        kdtFarmerSumEntry_healthEggQty_TextField.setEditable(true);
        kdtFarmerSumEntry_healthEggQty_TextField.setHorizontalAlignment(2);
        kdtFarmerSumEntry_healthEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtFarmerSumEntry_healthEggQty_CellEditor = new KDTDefaultCellEditor(kdtFarmerSumEntry_healthEggQty_TextField);
        this.kdtFarmerSumEntry.getColumn("healthEggQty").setEditor(kdtFarmerSumEntry_healthEggQty_CellEditor);
        KDFormattedTextField kdtFarmerSumEntry_noFertileEggQty_TextField = new KDFormattedTextField();
        kdtFarmerSumEntry_noFertileEggQty_TextField.setName("kdtFarmerSumEntry_noFertileEggQty_TextField");
        kdtFarmerSumEntry_noFertileEggQty_TextField.setVisible(true);
        kdtFarmerSumEntry_noFertileEggQty_TextField.setEditable(true);
        kdtFarmerSumEntry_noFertileEggQty_TextField.setHorizontalAlignment(2);
        kdtFarmerSumEntry_noFertileEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtFarmerSumEntry_noFertileEggQty_CellEditor = new KDTDefaultCellEditor(kdtFarmerSumEntry_noFertileEggQty_TextField);
        this.kdtFarmerSumEntry.getColumn("noFertileEggQty").setEditor(kdtFarmerSumEntry_noFertileEggQty_CellEditor);
        KDFormattedTextField kdtFarmerSumEntry_brokenYolkQty_TextField = new KDFormattedTextField();
        kdtFarmerSumEntry_brokenYolkQty_TextField.setName("kdtFarmerSumEntry_brokenYolkQty_TextField");
        kdtFarmerSumEntry_brokenYolkQty_TextField.setVisible(true);
        kdtFarmerSumEntry_brokenYolkQty_TextField.setEditable(true);
        kdtFarmerSumEntry_brokenYolkQty_TextField.setHorizontalAlignment(2);
        kdtFarmerSumEntry_brokenYolkQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtFarmerSumEntry_brokenYolkQty_CellEditor = new KDTDefaultCellEditor(kdtFarmerSumEntry_brokenYolkQty_TextField);
        this.kdtFarmerSumEntry.getColumn("brokenYolkQty").setEditor(kdtFarmerSumEntry_brokenYolkQty_CellEditor);
        KDFormattedTextField kdtFarmerSumEntry_addleEggQty_TextField = new KDFormattedTextField();
        kdtFarmerSumEntry_addleEggQty_TextField.setName("kdtFarmerSumEntry_addleEggQty_TextField");
        kdtFarmerSumEntry_addleEggQty_TextField.setVisible(true);
        kdtFarmerSumEntry_addleEggQty_TextField.setEditable(true);
        kdtFarmerSumEntry_addleEggQty_TextField.setHorizontalAlignment(2);
        kdtFarmerSumEntry_addleEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtFarmerSumEntry_addleEggQty_CellEditor = new KDTDefaultCellEditor(kdtFarmerSumEntry_addleEggQty_TextField);
        this.kdtFarmerSumEntry.getColumn("addleEggQty").setEditor(kdtFarmerSumEntry_addleEggQty_CellEditor);
        KDFormattedTextField kdtFarmerSumEntry_rottenEggQty_TextField = new KDFormattedTextField();
        kdtFarmerSumEntry_rottenEggQty_TextField.setName("kdtFarmerSumEntry_rottenEggQty_TextField");
        kdtFarmerSumEntry_rottenEggQty_TextField.setVisible(true);
        kdtFarmerSumEntry_rottenEggQty_TextField.setEditable(true);
        kdtFarmerSumEntry_rottenEggQty_TextField.setHorizontalAlignment(2);
        kdtFarmerSumEntry_rottenEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtFarmerSumEntry_rottenEggQty_CellEditor = new KDTDefaultCellEditor(kdtFarmerSumEntry_rottenEggQty_TextField);
        this.kdtFarmerSumEntry.getColumn("rottenEggQty").setEditor(kdtFarmerSumEntry_rottenEggQty_CellEditor);
        KDFormattedTextField kdtFarmerSumEntry_brokenEggQty_TextField = new KDFormattedTextField();
        kdtFarmerSumEntry_brokenEggQty_TextField.setName("kdtFarmerSumEntry_brokenEggQty_TextField");
        kdtFarmerSumEntry_brokenEggQty_TextField.setVisible(true);
        kdtFarmerSumEntry_brokenEggQty_TextField.setEditable(true);
        kdtFarmerSumEntry_brokenEggQty_TextField.setHorizontalAlignment(2);
        kdtFarmerSumEntry_brokenEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtFarmerSumEntry_brokenEggQty_CellEditor = new KDTDefaultCellEditor(kdtFarmerSumEntry_brokenEggQty_TextField);
        this.kdtFarmerSumEntry.getColumn("brokenEggQty").setEditor(kdtFarmerSumEntry_brokenEggQty_CellEditor);
        KDFormattedTextField kdtFarmerSumEntry_diffEggQty_TextField = new KDFormattedTextField();
        kdtFarmerSumEntry_diffEggQty_TextField.setName("kdtFarmerSumEntry_diffEggQty_TextField");
        kdtFarmerSumEntry_diffEggQty_TextField.setVisible(true);
        kdtFarmerSumEntry_diffEggQty_TextField.setEditable(true);
        kdtFarmerSumEntry_diffEggQty_TextField.setHorizontalAlignment(2);
        kdtFarmerSumEntry_diffEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtFarmerSumEntry_diffEggQty_CellEditor = new KDTDefaultCellEditor(kdtFarmerSumEntry_diffEggQty_TextField);
        this.kdtFarmerSumEntry.getColumn("diffEggQty").setEditor(kdtFarmerSumEntry_diffEggQty_CellEditor);
        KDFormattedTextField kdtFarmerSumEntry_fertilityRate_TextField = new KDFormattedTextField();
        kdtFarmerSumEntry_fertilityRate_TextField.setName("kdtFarmerSumEntry_fertilityRate_TextField");
        kdtFarmerSumEntry_fertilityRate_TextField.setVisible(true);
        kdtFarmerSumEntry_fertilityRate_TextField.setEditable(true);
        kdtFarmerSumEntry_fertilityRate_TextField.setHorizontalAlignment(2);
        kdtFarmerSumEntry_fertilityRate_TextField.setDataType(1);
        	kdtFarmerSumEntry_fertilityRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtFarmerSumEntry_fertilityRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtFarmerSumEntry_fertilityRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtFarmerSumEntry_fertilityRate_CellEditor = new KDTDefaultCellEditor(kdtFarmerSumEntry_fertilityRate_TextField);
        this.kdtFarmerSumEntry.getColumn("fertilityRate").setEditor(kdtFarmerSumEntry_fertilityRate_CellEditor);
        KDFormattedTextField kdtFarmerSumEntry_addleEggRate_TextField = new KDFormattedTextField();
        kdtFarmerSumEntry_addleEggRate_TextField.setName("kdtFarmerSumEntry_addleEggRate_TextField");
        kdtFarmerSumEntry_addleEggRate_TextField.setVisible(true);
        kdtFarmerSumEntry_addleEggRate_TextField.setEditable(true);
        kdtFarmerSumEntry_addleEggRate_TextField.setHorizontalAlignment(2);
        kdtFarmerSumEntry_addleEggRate_TextField.setDataType(1);
        	kdtFarmerSumEntry_addleEggRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtFarmerSumEntry_addleEggRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtFarmerSumEntry_addleEggRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtFarmerSumEntry_addleEggRate_CellEditor = new KDTDefaultCellEditor(kdtFarmerSumEntry_addleEggRate_TextField);
        this.kdtFarmerSumEntry.getColumn("addleEggRate").setEditor(kdtFarmerSumEntry_addleEggRate_CellEditor);
        KDFormattedTextField kdtFarmerSumEntry_brokenRate_TextField = new KDFormattedTextField();
        kdtFarmerSumEntry_brokenRate_TextField.setName("kdtFarmerSumEntry_brokenRate_TextField");
        kdtFarmerSumEntry_brokenRate_TextField.setVisible(true);
        kdtFarmerSumEntry_brokenRate_TextField.setEditable(true);
        kdtFarmerSumEntry_brokenRate_TextField.setHorizontalAlignment(2);
        kdtFarmerSumEntry_brokenRate_TextField.setDataType(1);
        	kdtFarmerSumEntry_brokenRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtFarmerSumEntry_brokenRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtFarmerSumEntry_brokenRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtFarmerSumEntry_brokenRate_CellEditor = new KDTDefaultCellEditor(kdtFarmerSumEntry_brokenRate_TextField);
        this.kdtFarmerSumEntry.getColumn("brokenRate").setEditor(kdtFarmerSumEntry_brokenRate_CellEditor);
        KDFormattedTextField kdtFarmerSumEntry_rottenRate_TextField = new KDFormattedTextField();
        kdtFarmerSumEntry_rottenRate_TextField.setName("kdtFarmerSumEntry_rottenRate_TextField");
        kdtFarmerSumEntry_rottenRate_TextField.setVisible(true);
        kdtFarmerSumEntry_rottenRate_TextField.setEditable(true);
        kdtFarmerSumEntry_rottenRate_TextField.setHorizontalAlignment(2);
        kdtFarmerSumEntry_rottenRate_TextField.setDataType(1);
        	kdtFarmerSumEntry_rottenRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtFarmerSumEntry_rottenRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtFarmerSumEntry_rottenRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtFarmerSumEntry_rottenRate_CellEditor = new KDTDefaultCellEditor(kdtFarmerSumEntry_rottenRate_TextField);
        this.kdtFarmerSumEntry.getColumn("rottenRate").setEditor(kdtFarmerSumEntry_rottenRate_CellEditor);
        // txtallNoFertileEggQty		
        this.txtallNoFertileEggQty.setHorizontalAlignment(2);		
        this.txtallNoFertileEggQty.setDataType(0);		
        this.txtallNoFertileEggQty.setSupportedEmpty(true);		
        this.txtallNoFertileEggQty.setRequired(false);		
        this.txtallNoFertileEggQty.setEnabled(false);
        // txtallAddleEggQty		
        this.txtallAddleEggQty.setHorizontalAlignment(2);		
        this.txtallAddleEggQty.setDataType(0);		
        this.txtallAddleEggQty.setSupportedEmpty(true);		
        this.txtallAddleEggQty.setRequired(false);		
        this.txtallAddleEggQty.setEnabled(false);
        // txtallRottenEggQty		
        this.txtallRottenEggQty.setHorizontalAlignment(2);		
        this.txtallRottenEggQty.setDataType(0);		
        this.txtallRottenEggQty.setSupportedEmpty(true);		
        this.txtallRottenEggQty.setRequired(false);		
        this.txtallRottenEggQty.setEnabled(false);
        // txtallHatchEggQty		
        this.txtallHatchEggQty.setHorizontalAlignment(2);		
        this.txtallHatchEggQty.setDataType(0);		
        this.txtallHatchEggQty.setSupportedEmpty(true);		
        this.txtallHatchEggQty.setRequired(false);		
        this.txtallHatchEggQty.setEnabled(false);
        // prmtoperator		
        this.prmtoperator.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtoperator.setEditable(true);		
        this.prmtoperator.setDisplayFormat("$name$");		
        this.prmtoperator.setEditFormat("$number$");		
        this.prmtoperator.setCommitFormat("$number$");		
        this.prmtoperator.setRequired(false);
        // txtallHealthEggQty		
        this.txtallHealthEggQty.setHorizontalAlignment(2);		
        this.txtallHealthEggQty.setDataType(0);		
        this.txtallHealthEggQty.setSupportedEmpty(true);		
        this.txtallHealthEggQty.setRequired(false);		
        this.txtallHealthEggQty.setEnabled(false);
        // prmthatchArea		
        this.prmthatchArea.setQueryInfo("com.kingdee.eas.farm.hatch.app.HatchAreaQuery");		
        this.prmthatchArea.setEditable(true);		
        this.prmthatchArea.setDisplayFormat("$name$");		
        this.prmthatchArea.setEditFormat("$number$");		
        this.prmthatchArea.setCommitFormat("$number$");		
        this.prmthatchArea.setRequired(false);		
        this.prmthatchArea.setEnabled(false);		
        this.prmthatchArea.setVisible(false);
        // prmtincubator		
        this.prmtincubator.setQueryInfo("com.kingdee.eas.farm.hatch.app.IncubatorQuery");		
        this.prmtincubator.setEditable(true);		
        this.prmtincubator.setDisplayFormat("$name$");		
        this.prmtincubator.setEditFormat("$number$");		
        this.prmtincubator.setCommitFormat("$number$");		
        this.prmtincubator.setRequired(false);
        		prmtincubator.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.IncubatorListUI prmtincubator_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtincubator_F7ListUI == null) {
					try {
						prmtincubator_F7ListUI = new com.kingdee.eas.farm.hatch.client.IncubatorListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtincubator_F7ListUI));
					prmtincubator_F7ListUI.setF7Use(true,ctx);
					prmtincubator.setSelector(prmtincubator_F7ListUI);
				}
			}
		});
					
        // txtotherLoss		
        this.txtotherLoss.setHorizontalAlignment(2);		
        this.txtotherLoss.setDataType(0);		
        this.txtotherLoss.setSupportedEmpty(true);		
        this.txtotherLoss.setRequired(false);		
        this.txtotherLoss.setEnabled(false);		
        this.txtotherLoss.setVisible(false);
        // prmtadminOrg		
        this.prmtadminOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtadminOrg.setVisible(false);		
        this.prmtadminOrg.setEditable(true);		
        this.prmtadminOrg.setDisplayFormat("$name$");		
        this.prmtadminOrg.setEditFormat("$number$");		
        this.prmtadminOrg.setCommitFormat("$number$");		
        this.prmtadminOrg.setRequired(false);		
        this.prmtadminOrg.setEnabled(false);
        // txtallBrokenEggQty		
        this.txtallBrokenEggQty.setHorizontalAlignment(2);		
        this.txtallBrokenEggQty.setDataType(0);		
        this.txtallBrokenEggQty.setSupportedEmpty(true);		
        this.txtallBrokenEggQty.setRequired(false);		
        this.txtallBrokenEggQty.setEnabled(false);
        // txtbrokenEggQty		
        this.txtbrokenEggQty.setHorizontalAlignment(2);		
        this.txtbrokenEggQty.setDataType(0);		
        this.txtbrokenEggQty.setSupportedEmpty(true);		
        this.txtbrokenEggQty.setRequired(false);		
        this.txtbrokenEggQty.setEnabled(false);		
        this.txtbrokenEggQty.setVisible(false);
        // txtfertilityRate		
        this.txtfertilityRate.setVisible(false);		
        this.txtfertilityRate.setHorizontalAlignment(2);		
        this.txtfertilityRate.setDataType(1);		
        this.txtfertilityRate.setSupportedEmpty(true);		
        this.txtfertilityRate.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtfertilityRate.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtfertilityRate.setPrecision(2);		
        this.txtfertilityRate.setRequired(false);		
        this.txtfertilityRate.setEnabled(false);
        // prmthatchHouse		
        this.prmthatchHouse.setQueryInfo("com.kingdee.eas.farm.hatch.app.HatchHouseQuery");		
        this.prmthatchHouse.setEditable(true);		
        this.prmthatchHouse.setDisplayFormat("$name$");		
        this.prmthatchHouse.setEditFormat("$number$");		
        this.prmthatchHouse.setCommitFormat("$number$");		
        this.prmthatchHouse.setRequired(false);
        		prmthatchHouse.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.HatchHouseListUI prmthatchHouse_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmthatchHouse_F7ListUI == null) {
					try {
						prmthatchHouse_F7ListUI = new com.kingdee.eas.farm.hatch.client.HatchHouseListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmthatchHouse_F7ListUI));
					prmthatchHouse_F7ListUI.setF7Use(true,ctx);
					prmthatchHouse.setSelector(prmthatchHouse_F7ListUI);
				}
			}
		});
					
        // eggType		
        this.eggType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.hatch.EggType").toArray());		
        this.eggType.setRequired(true);		
        this.eggType.setEnabled(false);
        // radioHorizon		
        this.radioHorizon.setText(resHelper.getString("radioHorizon.text"));
        // radioVertical		
        this.radioVertical.setText(resHelper.getString("radioVertical.text"));
        // radioOrigin		
        this.radioOrigin.setText(resHelper.getString("radioOrigin.text"));
        // btnSummary		
        this.btnSummary.setText(resHelper.getString("btnSummary.text"));
        // cboxCPM		
        this.cboxCPM.setText(resHelper.getString("cboxCPM.text"));		
        this.cboxCPM.setVisible(false);
        // btnSaveModel		
        this.btnSaveModel.setText(resHelper.getString("btnSaveModel.text"));
        // kDPanel1		
        this.kDPanel1.setVisible(false);
        // kdtAreaSumEntry
		String kdtAreaSumEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"outArea\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"supplier\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"qcEggType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"eggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"healthEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"noFertileEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"brokenYolkQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"addleEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"rottenEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"brokenEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"diffEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"fertilityRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"addleEggRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{outArea}</t:Cell><t:Cell>$Resource{supplier}</t:Cell><t:Cell>$Resource{qcEggType}</t:Cell><t:Cell>$Resource{eggQty}</t:Cell><t:Cell>$Resource{healthEggQty}</t:Cell><t:Cell>$Resource{noFertileEggQty}</t:Cell><t:Cell>$Resource{brokenYolkQty}</t:Cell><t:Cell>$Resource{addleEggQty}</t:Cell><t:Cell>$Resource{rottenEggQty}</t:Cell><t:Cell>$Resource{brokenEggQty}</t:Cell><t:Cell>$Resource{diffEggQty}</t:Cell><t:Cell>$Resource{fertilityRate}</t:Cell><t:Cell>$Resource{addleEggRate}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtAreaSumEntry.setFormatXml(resHelper.translateString("kdtAreaSumEntry",kdtAreaSumEntryStrXML));		
        this.kdtAreaSumEntry.setVisible(false);

                this.kdtAreaSumEntry.putBindContents("editData",new String[] {"seq","outArea","supplier","qcEggType","eggQty","healthEggQty","noFertileEggQty","brokenYolkQty","addleEggQty","rottenEggQty","brokenEggQty","diffEggQty","fertilityRate","addleEggRate"});


        this.kdtAreaSumEntry.checkParsed();
        final KDBizPromptBox kdtAreaSumEntry_outArea_PromptBox = new KDBizPromptBox();
        kdtAreaSumEntry_outArea_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.F7FarmerGroupQuery");
        kdtAreaSumEntry_outArea_PromptBox.setVisible(true);
        kdtAreaSumEntry_outArea_PromptBox.setEditable(true);
        kdtAreaSumEntry_outArea_PromptBox.setDisplayFormat("$number$");
        kdtAreaSumEntry_outArea_PromptBox.setEditFormat("$number$");
        kdtAreaSumEntry_outArea_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtAreaSumEntry_outArea_CellEditor = new KDTDefaultCellEditor(kdtAreaSumEntry_outArea_PromptBox);
        this.kdtAreaSumEntry.getColumn("outArea").setEditor(kdtAreaSumEntry_outArea_CellEditor);
        ObjectValueRender kdtAreaSumEntry_outArea_OVR = new ObjectValueRender();
        kdtAreaSumEntry_outArea_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtAreaSumEntry.getColumn("outArea").setRenderer(kdtAreaSumEntry_outArea_OVR);
        final KDBizPromptBox kdtAreaSumEntry_supplier_PromptBox = new KDBizPromptBox();
        kdtAreaSumEntry_supplier_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.F7SupplierDefaultQuery");
        kdtAreaSumEntry_supplier_PromptBox.setVisible(true);
        kdtAreaSumEntry_supplier_PromptBox.setEditable(true);
        kdtAreaSumEntry_supplier_PromptBox.setDisplayFormat("$number$");
        kdtAreaSumEntry_supplier_PromptBox.setEditFormat("$number$");
        kdtAreaSumEntry_supplier_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtAreaSumEntry_supplier_CellEditor = new KDTDefaultCellEditor(kdtAreaSumEntry_supplier_PromptBox);
        this.kdtAreaSumEntry.getColumn("supplier").setEditor(kdtAreaSumEntry_supplier_CellEditor);
        ObjectValueRender kdtAreaSumEntry_supplier_OVR = new ObjectValueRender();
        kdtAreaSumEntry_supplier_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtAreaSumEntry.getColumn("supplier").setRenderer(kdtAreaSumEntry_supplier_OVR);
        KDComboBox kdtAreaSumEntry_qcEggType_ComboBox = new KDComboBox();
        kdtAreaSumEntry_qcEggType_ComboBox.setName("kdtAreaSumEntry_qcEggType_ComboBox");
        kdtAreaSumEntry_qcEggType_ComboBox.setVisible(true);
        kdtAreaSumEntry_qcEggType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.hatch.QcEggTypeEnum").toArray());
        KDTDefaultCellEditor kdtAreaSumEntry_qcEggType_CellEditor = new KDTDefaultCellEditor(kdtAreaSumEntry_qcEggType_ComboBox);
        this.kdtAreaSumEntry.getColumn("qcEggType").setEditor(kdtAreaSumEntry_qcEggType_CellEditor);
        KDFormattedTextField kdtAreaSumEntry_eggQty_TextField = new KDFormattedTextField();
        kdtAreaSumEntry_eggQty_TextField.setName("kdtAreaSumEntry_eggQty_TextField");
        kdtAreaSumEntry_eggQty_TextField.setVisible(true);
        kdtAreaSumEntry_eggQty_TextField.setEditable(true);
        kdtAreaSumEntry_eggQty_TextField.setHorizontalAlignment(2);
        kdtAreaSumEntry_eggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtAreaSumEntry_eggQty_CellEditor = new KDTDefaultCellEditor(kdtAreaSumEntry_eggQty_TextField);
        this.kdtAreaSumEntry.getColumn("eggQty").setEditor(kdtAreaSumEntry_eggQty_CellEditor);
        KDFormattedTextField kdtAreaSumEntry_healthEggQty_TextField = new KDFormattedTextField();
        kdtAreaSumEntry_healthEggQty_TextField.setName("kdtAreaSumEntry_healthEggQty_TextField");
        kdtAreaSumEntry_healthEggQty_TextField.setVisible(true);
        kdtAreaSumEntry_healthEggQty_TextField.setEditable(true);
        kdtAreaSumEntry_healthEggQty_TextField.setHorizontalAlignment(2);
        kdtAreaSumEntry_healthEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtAreaSumEntry_healthEggQty_CellEditor = new KDTDefaultCellEditor(kdtAreaSumEntry_healthEggQty_TextField);
        this.kdtAreaSumEntry.getColumn("healthEggQty").setEditor(kdtAreaSumEntry_healthEggQty_CellEditor);
        KDFormattedTextField kdtAreaSumEntry_noFertileEggQty_TextField = new KDFormattedTextField();
        kdtAreaSumEntry_noFertileEggQty_TextField.setName("kdtAreaSumEntry_noFertileEggQty_TextField");
        kdtAreaSumEntry_noFertileEggQty_TextField.setVisible(true);
        kdtAreaSumEntry_noFertileEggQty_TextField.setEditable(true);
        kdtAreaSumEntry_noFertileEggQty_TextField.setHorizontalAlignment(2);
        kdtAreaSumEntry_noFertileEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtAreaSumEntry_noFertileEggQty_CellEditor = new KDTDefaultCellEditor(kdtAreaSumEntry_noFertileEggQty_TextField);
        this.kdtAreaSumEntry.getColumn("noFertileEggQty").setEditor(kdtAreaSumEntry_noFertileEggQty_CellEditor);
        KDFormattedTextField kdtAreaSumEntry_brokenYolkQty_TextField = new KDFormattedTextField();
        kdtAreaSumEntry_brokenYolkQty_TextField.setName("kdtAreaSumEntry_brokenYolkQty_TextField");
        kdtAreaSumEntry_brokenYolkQty_TextField.setVisible(true);
        kdtAreaSumEntry_brokenYolkQty_TextField.setEditable(true);
        kdtAreaSumEntry_brokenYolkQty_TextField.setHorizontalAlignment(2);
        kdtAreaSumEntry_brokenYolkQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtAreaSumEntry_brokenYolkQty_CellEditor = new KDTDefaultCellEditor(kdtAreaSumEntry_brokenYolkQty_TextField);
        this.kdtAreaSumEntry.getColumn("brokenYolkQty").setEditor(kdtAreaSumEntry_brokenYolkQty_CellEditor);
        KDFormattedTextField kdtAreaSumEntry_addleEggQty_TextField = new KDFormattedTextField();
        kdtAreaSumEntry_addleEggQty_TextField.setName("kdtAreaSumEntry_addleEggQty_TextField");
        kdtAreaSumEntry_addleEggQty_TextField.setVisible(true);
        kdtAreaSumEntry_addleEggQty_TextField.setEditable(true);
        kdtAreaSumEntry_addleEggQty_TextField.setHorizontalAlignment(2);
        kdtAreaSumEntry_addleEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtAreaSumEntry_addleEggQty_CellEditor = new KDTDefaultCellEditor(kdtAreaSumEntry_addleEggQty_TextField);
        this.kdtAreaSumEntry.getColumn("addleEggQty").setEditor(kdtAreaSumEntry_addleEggQty_CellEditor);
        KDFormattedTextField kdtAreaSumEntry_rottenEggQty_TextField = new KDFormattedTextField();
        kdtAreaSumEntry_rottenEggQty_TextField.setName("kdtAreaSumEntry_rottenEggQty_TextField");
        kdtAreaSumEntry_rottenEggQty_TextField.setVisible(true);
        kdtAreaSumEntry_rottenEggQty_TextField.setEditable(true);
        kdtAreaSumEntry_rottenEggQty_TextField.setHorizontalAlignment(2);
        kdtAreaSumEntry_rottenEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtAreaSumEntry_rottenEggQty_CellEditor = new KDTDefaultCellEditor(kdtAreaSumEntry_rottenEggQty_TextField);
        this.kdtAreaSumEntry.getColumn("rottenEggQty").setEditor(kdtAreaSumEntry_rottenEggQty_CellEditor);
        KDFormattedTextField kdtAreaSumEntry_brokenEggQty_TextField = new KDFormattedTextField();
        kdtAreaSumEntry_brokenEggQty_TextField.setName("kdtAreaSumEntry_brokenEggQty_TextField");
        kdtAreaSumEntry_brokenEggQty_TextField.setVisible(true);
        kdtAreaSumEntry_brokenEggQty_TextField.setEditable(true);
        kdtAreaSumEntry_brokenEggQty_TextField.setHorizontalAlignment(2);
        kdtAreaSumEntry_brokenEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtAreaSumEntry_brokenEggQty_CellEditor = new KDTDefaultCellEditor(kdtAreaSumEntry_brokenEggQty_TextField);
        this.kdtAreaSumEntry.getColumn("brokenEggQty").setEditor(kdtAreaSumEntry_brokenEggQty_CellEditor);
        KDFormattedTextField kdtAreaSumEntry_diffEggQty_TextField = new KDFormattedTextField();
        kdtAreaSumEntry_diffEggQty_TextField.setName("kdtAreaSumEntry_diffEggQty_TextField");
        kdtAreaSumEntry_diffEggQty_TextField.setVisible(true);
        kdtAreaSumEntry_diffEggQty_TextField.setEditable(true);
        kdtAreaSumEntry_diffEggQty_TextField.setHorizontalAlignment(2);
        kdtAreaSumEntry_diffEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtAreaSumEntry_diffEggQty_CellEditor = new KDTDefaultCellEditor(kdtAreaSumEntry_diffEggQty_TextField);
        this.kdtAreaSumEntry.getColumn("diffEggQty").setEditor(kdtAreaSumEntry_diffEggQty_CellEditor);
        KDFormattedTextField kdtAreaSumEntry_fertilityRate_TextField = new KDFormattedTextField();
        kdtAreaSumEntry_fertilityRate_TextField.setName("kdtAreaSumEntry_fertilityRate_TextField");
        kdtAreaSumEntry_fertilityRate_TextField.setVisible(true);
        kdtAreaSumEntry_fertilityRate_TextField.setEditable(true);
        kdtAreaSumEntry_fertilityRate_TextField.setHorizontalAlignment(2);
        kdtAreaSumEntry_fertilityRate_TextField.setDataType(1);
        	kdtAreaSumEntry_fertilityRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtAreaSumEntry_fertilityRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtAreaSumEntry_fertilityRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtAreaSumEntry_fertilityRate_CellEditor = new KDTDefaultCellEditor(kdtAreaSumEntry_fertilityRate_TextField);
        this.kdtAreaSumEntry.getColumn("fertilityRate").setEditor(kdtAreaSumEntry_fertilityRate_CellEditor);
        KDFormattedTextField kdtAreaSumEntry_addleEggRate_TextField = new KDFormattedTextField();
        kdtAreaSumEntry_addleEggRate_TextField.setName("kdtAreaSumEntry_addleEggRate_TextField");
        kdtAreaSumEntry_addleEggRate_TextField.setVisible(true);
        kdtAreaSumEntry_addleEggRate_TextField.setEditable(true);
        kdtAreaSumEntry_addleEggRate_TextField.setHorizontalAlignment(2);
        kdtAreaSumEntry_addleEggRate_TextField.setDataType(1);
        	kdtAreaSumEntry_addleEggRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtAreaSumEntry_addleEggRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtAreaSumEntry_addleEggRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtAreaSumEntry_addleEggRate_CellEditor = new KDTDefaultCellEditor(kdtAreaSumEntry_addleEggRate_TextField);
        this.kdtAreaSumEntry.getColumn("addleEggRate").setEditor(kdtAreaSumEntry_addleEggRate_CellEditor);
        // pkhatchDate		
        this.pkhatchDate.setRequired(false);		
        this.pkhatchDate.setEnabled(false);
        // pktrayingDate		
        this.pktrayingDate.setRequired(false);		
        this.pktrayingDate.setEnabled(false);
        // genderTy		
        this.genderTy.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.hatch.GenderType").toArray());		
        this.genderTy.setRequired(false);		
        this.genderTy.setEnabled(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        // btnAdjust
        this.btnAdjust.setAction((IItemAction)ActionProxyFactory.getProxy(actionAdjust, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAdjust.setText(resHelper.getString("btnAdjust.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {pkauditTime,baseStatus,prmthatchFactory,txtallNoFertileEggQty,txtallAddleEggQty,txtallRottenEggQty,txtallHatchEggQty,prmtoperator,txtallHealthEggQty,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,prmthatchArea,prmtincubator,txtotherLoss,prmtadminOrg,txtallBrokenEggQty,txtbrokenEggQty,txtfertilityRate,prmthatchHouse,eggType,pkhatchDate,chkisTraying,pktrayingDate,genderTy,chkisProBabyBill,chkisOtherIn,kdtEggEntries,kdtFarmerSumEntry,kdtAreaSumEntry}));
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
        contCreator.setBounds(new Rectangle(373, 577, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(373, 577, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(373, 602, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(373, 602, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(725, 577, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(725, 577, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateTime.setBounds(new Rectangle(725, 602, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(725, 602, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(18, 13, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(18, 13, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(371, 39, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(371, 39, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(719, 65, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(719, 65, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(21, 577, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(21, 577, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(21, 602, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(21, 602, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbaseStatus.setBounds(new Rectangle(719, 39, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(719, 39, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conthatchFactory.setBounds(new Rectangle(371, 13, 270, 19));
        this.add(conthatchFactory, new KDLayout.Constraints(371, 13, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane2.setBounds(new Rectangle(15, 265, 985, 304));
        this.add(kDTabbedPane2, new KDLayout.Constraints(15, 265, 985, 304, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contallNoFertileEggQty.setBounds(new Rectangle(18, 91, 270, 19));
        this.add(contallNoFertileEggQty, new KDLayout.Constraints(18, 91, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contallAddleEggQty.setBounds(new Rectangle(18, 117, 270, 19));
        this.add(contallAddleEggQty, new KDLayout.Constraints(18, 117, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contallRottenEggQty.setBounds(new Rectangle(372, 114, 270, 19));
        this.add(contallRottenEggQty, new KDLayout.Constraints(372, 114, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contallHatchEggQty.setBounds(new Rectangle(719, 117, 270, 19));
        this.add(contallHatchEggQty, new KDLayout.Constraints(719, 117, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contoperator.setBounds(new Rectangle(719, 13, 270, 19));
        this.add(contoperator, new KDLayout.Constraints(719, 13, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contallHealthEggQty.setBounds(new Rectangle(371, 65, 270, 19));
        this.add(contallHealthEggQty, new KDLayout.Constraints(371, 65, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conthatchArea.setBounds(new Rectangle(18, 39, 270, 19));
        this.add(conthatchArea, new KDLayout.Constraints(18, 39, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contincubator.setBounds(new Rectangle(988, 115, 270, 19));
        this.add(contincubator, new KDLayout.Constraints(988, 115, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contotherLoss.setBounds(new Rectangle(775, 151, 270, 19));
        this.add(contotherLoss, new KDLayout.Constraints(775, 151, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contadminOrg.setBounds(new Rectangle(826, 150, 270, 19));
        this.add(contadminOrg, new KDLayout.Constraints(826, 150, 270, 19, 0));
        contallBrokenEggQty.setBounds(new Rectangle(719, 91, 270, 19));
        this.add(contallBrokenEggQty, new KDLayout.Constraints(719, 91, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbrokenEggQty.setBounds(new Rectangle(371, 89, 270, 19));
        this.add(contbrokenEggQty, new KDLayout.Constraints(371, 89, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfertilityRate.setBounds(new Rectangle(805, 139, 270, 19));
        this.add(contfertilityRate, new KDLayout.Constraints(805, 139, 270, 19, 0));
        conthatchHouse.setBounds(new Rectangle(964, 170, 270, 19));
        this.add(conthatchHouse, new KDLayout.Constraints(964, 170, 270, 19, 0));
        conteggType.setBounds(new Rectangle(18, 65, 270, 19));
        this.add(conteggType, new KDLayout.Constraints(18, 65, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDPanel4.setBounds(new Rectangle(15, 209, 985, 45));
        this.add(kDPanel4, new KDLayout.Constraints(15, 209, 985, 45, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        conthatchDate.setBounds(new Rectangle(18, 146, 270, 19));
        this.add(conthatchDate, new KDLayout.Constraints(18, 146, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisTraying.setBounds(new Rectangle(371, 146, 106, 19));
        this.add(chkisTraying, new KDLayout.Constraints(371, 146, 106, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttrayingDate.setBounds(new Rectangle(719, 146, 270, 19));
        this.add(conttrayingDate, new KDLayout.Constraints(719, 146, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contgenderTy.setBounds(new Rectangle(18, 174, 270, 19));
        this.add(contgenderTy, new KDLayout.Constraints(18, 174, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisProBabyBill.setBounds(new Rectangle(371, 175, 270, 19));
        this.add(chkisProBabyBill, new KDLayout.Constraints(371, 175, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisOtherIn.setBounds(new Rectangle(508, 146, 129, 19));
        this.add(chkisOtherIn, new KDLayout.Constraints(508, 146, 129, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //conthatchFactory
        conthatchFactory.setBoundEditor(prmthatchFactory);
        //kDTabbedPane2
        kDTabbedPane2.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        kDTabbedPane2.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 984, 271));        kdtEggEntries.setBounds(new Rectangle(1, 1, 978, 273));
        kdtEggEntries_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEggEntries,new com.kingdee.eas.farm.hatch.BEggCandlingBillEggEntryInfo(),null,false);
        kDPanel2.add(kdtEggEntries_detailPanel, new KDLayout.Constraints(1, 1, 978, 273, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtEggEntries_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("eggSourceType",new Integer(1));
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //kDPanel3
        kDPanel3.setLayout(new KDLayout());
        kDPanel3.putClientProperty("OriginalBounds", new Rectangle(0, 0, 984, 271));        kdtFarmerSumEntry.setBounds(new Rectangle(1, 2, 975, 267));
        kdtFarmerSumEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtFarmerSumEntry,new com.kingdee.eas.farm.hatch.BEggCandlingBillFarmerSumEntryInfo(),null,false);
        kDPanel3.add(kdtFarmerSumEntry_detailPanel, new KDLayout.Constraints(1, 2, 975, 267, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtFarmerSumEntry_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("hgdlx",new Integer(101));
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //contallNoFertileEggQty
        contallNoFertileEggQty.setBoundEditor(txtallNoFertileEggQty);
        //contallAddleEggQty
        contallAddleEggQty.setBoundEditor(txtallAddleEggQty);
        //contallRottenEggQty
        contallRottenEggQty.setBoundEditor(txtallRottenEggQty);
        //contallHatchEggQty
        contallHatchEggQty.setBoundEditor(txtallHatchEggQty);
        //contoperator
        contoperator.setBoundEditor(prmtoperator);
        //contallHealthEggQty
        contallHealthEggQty.setBoundEditor(txtallHealthEggQty);
        //conthatchArea
        conthatchArea.setBoundEditor(prmthatchArea);
        //contincubator
        contincubator.setBoundEditor(prmtincubator);
        //contotherLoss
        contotherLoss.setBoundEditor(txtotherLoss);
        //contadminOrg
        contadminOrg.setBoundEditor(prmtadminOrg);
        //contallBrokenEggQty
        contallBrokenEggQty.setBoundEditor(txtallBrokenEggQty);
        //contbrokenEggQty
        contbrokenEggQty.setBoundEditor(txtbrokenEggQty);
        //contfertilityRate
        contfertilityRate.setBoundEditor(txtfertilityRate);
        //conthatchHouse
        conthatchHouse.setBoundEditor(prmthatchHouse);
        //conteggType
        conteggType.setBoundEditor(eggType);
        //kDPanel4
        kDPanel4.setLayout(new KDLayout());
        kDPanel4.putClientProperty("OriginalBounds", new Rectangle(15, 209, 985, 45));        radioHorizon.setBounds(new Rectangle(28, 15, 140, 19));
        kDPanel4.add(radioHorizon, new KDLayout.Constraints(28, 15, 140, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        radioVertical.setBounds(new Rectangle(166, 15, 140, 19));
        kDPanel4.add(radioVertical, new KDLayout.Constraints(166, 15, 140, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        radioOrigin.setBounds(new Rectangle(337, 15, 140, 19));
        kDPanel4.add(radioOrigin, new KDLayout.Constraints(337, 15, 140, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnSummary.setBounds(new Rectangle(853, 12, 95, 21));
        kDPanel4.add(btnSummary, new KDLayout.Constraints(853, 12, 95, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        cboxCPM.setBounds(new Rectangle(485, 15, 140, 19));
        kDPanel4.add(cboxCPM, new KDLayout.Constraints(485, 15, 140, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnSaveModel.setBounds(new Rectangle(661, 12, 116, 21));
        kDPanel4.add(btnSaveModel, new KDLayout.Constraints(661, 12, 116, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDPanel1.setBounds(new Rectangle(775, 56, 981, 273));
        kDPanel4.add(kDPanel1, new KDLayout.Constraints(775, 56, 981, 273, 0));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(775, 56, 981, 273));        kdtAreaSumEntry.setBounds(new Rectangle(4, 3, 972, 244));
        kdtAreaSumEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtAreaSumEntry,new com.kingdee.eas.farm.hatch.BEggCandlingBillAreaSumEntryInfo(),null,false);
        kDPanel1.add(kdtAreaSumEntry_detailPanel, new KDLayout.Constraints(4, 3, 972, 244, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //conthatchDate
        conthatchDate.setBoundEditor(pkhatchDate);
        //conttrayingDate
        conttrayingDate.setBoundEditor(pktrayingDate);
        //contgenderTy
        contgenderTy.setBoundEditor(genderTy);

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
        this.toolBar.add(btnAdjust);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("isTraying", boolean.class, this.chkisTraying, "selected");
		dataBinder.registerBinding("isProBabyBill", boolean.class, this.chkisProBabyBill, "selected");
		dataBinder.registerBinding("isOtherIn", boolean.class, this.chkisOtherIn, "selected");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("hatchFactory", com.kingdee.eas.farm.hatch.HatchBaseDataInfo.class, this.prmthatchFactory, "data");
		dataBinder.registerBinding("EggEntries.seq", int.class, this.kdtEggEntries, "seq.text");
		dataBinder.registerBinding("EggEntries", com.kingdee.eas.farm.hatch.BEggCandlingBillEggEntryInfo.class, this.kdtEggEntries, "userObject");
		dataBinder.registerBinding("EggEntries.eggSourceType", com.kingdee.util.enums.Enum.class, this.kdtEggEntries, "eggSourceType.text");
		dataBinder.registerBinding("EggEntries.farm", java.lang.Object.class, this.kdtEggEntries, "farm.text");
		dataBinder.registerBinding("EggEntries.eggLog", String.class, this.kdtEggEntries, "eggLog.text");
		dataBinder.registerBinding("EggEntries.eggQty", int.class, this.kdtEggEntries, "eggQty.text");
		dataBinder.registerBinding("EggEntries.noFertileEggQty", int.class, this.kdtEggEntries, "noFertileEggQty.text");
		dataBinder.registerBinding("EggEntries.addleEggQty", int.class, this.kdtEggEntries, "addleEggQty.text");
		dataBinder.registerBinding("EggEntries.healthEggQty", int.class, this.kdtEggEntries, "healthEggQty.text");
		dataBinder.registerBinding("EggEntries.brokenEggQty", int.class, this.kdtEggEntries, "brokenEggQty.text");
		dataBinder.registerBinding("EggEntries.rottenEggQty", int.class, this.kdtEggEntries, "rottenEggQty.text");
		dataBinder.registerBinding("EggEntries.otherEggQty", int.class, this.kdtEggEntries, "otherEggQty.text");
		dataBinder.registerBinding("EggEntries.farmer", java.lang.Object.class, this.kdtEggEntries, "farmer.text");
		dataBinder.registerBinding("EggEntries.outFarm", java.lang.Object.class, this.kdtEggEntries, "outFarm.text");
		dataBinder.registerBinding("EggEntries.supplier", java.lang.Object.class, this.kdtEggEntries, "supplier.text");
		dataBinder.registerBinding("EggEntries.material", java.lang.Object.class, this.kdtEggEntries, "material.text");
		dataBinder.registerBinding("EggEntries.outBatch", java.lang.Object.class, this.kdtEggEntries, "outBatch.text");
		dataBinder.registerBinding("EggEntries.breedBatch", java.lang.Object.class, this.kdtEggEntries, "breedBatch.text");
		dataBinder.registerBinding("EggEntries.brokenYolkQty", int.class, this.kdtEggEntries, "brokenYolkQty.text");
		dataBinder.registerBinding("EggEntries.fertilityRate", java.math.BigDecimal.class, this.kdtEggEntries, "fertilityRate.text");
		dataBinder.registerBinding("EggEntries.house", java.lang.Object.class, this.kdtEggEntries, "house.text");
		dataBinder.registerBinding("EggEntries.outHouse", java.lang.Object.class, this.kdtEggEntries, "outHouse.text");
		dataBinder.registerBinding("EggEntries.hatchHouse", java.lang.Object.class, this.kdtEggEntries, "hatchHouse.text");
		dataBinder.registerBinding("EggEntries.qc1lv1Qty", int.class, this.kdtEggEntries, "qc1lv1Qty.text");
		dataBinder.registerBinding("EggEntries.qc1lv2Qty", int.class, this.kdtEggEntries, "qc1lv2Qty.text");
		dataBinder.registerBinding("EggEntries.qc2lv1Qty", int.class, this.kdtEggEntries, "qc2lv1Qty.text");
		dataBinder.registerBinding("EggEntries.qc2lv2Qty", int.class, this.kdtEggEntries, "qc2lv2Qty.text");
		dataBinder.registerBinding("EggEntries.qc3lv1Qty", int.class, this.kdtEggEntries, "qc3lv1Qty.text");
		dataBinder.registerBinding("EggEntries.qc4lv1Qty", int.class, this.kdtEggEntries, "qc4lv1Qty.text");
		dataBinder.registerBinding("EggEntries.qc5lv1Qty", int.class, this.kdtEggEntries, "qc5lv1Qty.text");
		dataBinder.registerBinding("EggEntries.qc6lv1Qty", int.class, this.kdtEggEntries, "qc6lv1Qty.text");
		dataBinder.registerBinding("EggEntries.incubator", java.lang.Object.class, this.kdtEggEntries, "incubator.text");
		dataBinder.registerBinding("EggEntries.hatchCarNum", String.class, this.kdtEggEntries, "hatchCarNum.text");
		dataBinder.registerBinding("EggEntries.outArea", java.lang.Object.class, this.kdtEggEntries, "outArea.text");
		dataBinder.registerBinding("EggEntries.isMix", boolean.class, this.kdtEggEntries, "isMix.text");
		dataBinder.registerBinding("EggEntries.qcEggType", com.kingdee.util.enums.Enum.class, this.kdtEggEntries, "qcEggType.text");
		dataBinder.registerBinding("EggEntries.weekAge", String.class, this.kdtEggEntries, "weekAge.text");
		dataBinder.registerBinding("EggEntries.dayAge", int.class, this.kdtEggEntries, "dayAge.text");
		dataBinder.registerBinding("EggEntries.isFormal", boolean.class, this.kdtEggEntries, "isFormal.text");
		dataBinder.registerBinding("EggEntries.diffEggQty", int.class, this.kdtEggEntries, "diffEggQty.text");
		dataBinder.registerBinding("EggEntries.addleEggRate", java.math.BigDecimal.class, this.kdtEggEntries, "addleEggRate.text");
		dataBinder.registerBinding("EggEntries.genderType", com.kingdee.util.enums.Enum.class, this.kdtEggEntries, "genderType.text");
		dataBinder.registerBinding("EggEntries.eggDate", java.util.Date.class, this.kdtEggEntries, "eggDate.text");
		dataBinder.registerBinding("EggEntries.lphealthEggQty", int.class, this.kdtEggEntries, "lphealthEggQty.text");
		dataBinder.registerBinding("EggEntries.lossQty", java.math.BigDecimal.class, this.kdtEggEntries, "lossQty.text");
		dataBinder.registerBinding("EggEntries.rottenRate", java.math.BigDecimal.class, this.kdtEggEntries, "rottenRate.text");
		dataBinder.registerBinding("EggEntries.brokenRate", java.math.BigDecimal.class, this.kdtEggEntries, "brokenRate.text");
		dataBinder.registerBinding("EggEntries.CostObject", java.lang.Object.class, this.kdtEggEntries, "CostObject.text");
		dataBinder.registerBinding("EggEntries.hatchsBox", java.lang.Object.class, this.kdtEggEntries, "hatchsBox.text");
		dataBinder.registerBinding("EggEntries.liveEggRate", java.math.BigDecimal.class, this.kdtEggEntries, "liveEggRate.text");
		dataBinder.registerBinding("EggEntries.noFertileEggRate", java.math.BigDecimal.class, this.kdtEggEntries, "noFertileEggRate.text");
		dataBinder.registerBinding("FarmerSumEntry.seq", int.class, this.kdtFarmerSumEntry, "seq.text");
		dataBinder.registerBinding("FarmerSumEntry", com.kingdee.eas.farm.hatch.BEggCandlingBillFarmerSumEntryInfo.class, this.kdtFarmerSumEntry, "userObject");
		dataBinder.registerBinding("FarmerSumEntry.farmer", java.lang.Object.class, this.kdtFarmerSumEntry, "farmer.text");
		dataBinder.registerBinding("FarmerSumEntry.eggQty", int.class, this.kdtFarmerSumEntry, "eggQty.text");
		dataBinder.registerBinding("FarmerSumEntry.healthEggQty", int.class, this.kdtFarmerSumEntry, "healthEggQty.text");
		dataBinder.registerBinding("FarmerSumEntry.noFertileEggQty", int.class, this.kdtFarmerSumEntry, "noFertileEggQty.text");
		dataBinder.registerBinding("FarmerSumEntry.brokenYolkQty", int.class, this.kdtFarmerSumEntry, "brokenYolkQty.text");
		dataBinder.registerBinding("FarmerSumEntry.addleEggQty", int.class, this.kdtFarmerSumEntry, "addleEggQty.text");
		dataBinder.registerBinding("FarmerSumEntry.rottenEggQty", int.class, this.kdtFarmerSumEntry, "rottenEggQty.text");
		dataBinder.registerBinding("FarmerSumEntry.brokenEggQty", int.class, this.kdtFarmerSumEntry, "brokenEggQty.text");
		dataBinder.registerBinding("FarmerSumEntry.diffEggQty", int.class, this.kdtFarmerSumEntry, "diffEggQty.text");
		dataBinder.registerBinding("FarmerSumEntry.fertilityRate", java.math.BigDecimal.class, this.kdtFarmerSumEntry, "fertilityRate.text");
		dataBinder.registerBinding("FarmerSumEntry.addleEggRate", java.math.BigDecimal.class, this.kdtFarmerSumEntry, "addleEggRate.text");
		dataBinder.registerBinding("FarmerSumEntry.house", java.lang.Object.class, this.kdtFarmerSumEntry, "house.text");
		dataBinder.registerBinding("FarmerSumEntry.supploer1", java.lang.Object.class, this.kdtFarmerSumEntry, "supploer1.text");
		dataBinder.registerBinding("FarmerSumEntry.hgdlx", com.kingdee.util.enums.Enum.class, this.kdtFarmerSumEntry, "hgdlx.text");
		dataBinder.registerBinding("FarmerSumEntry.brokenRate", java.math.BigDecimal.class, this.kdtFarmerSumEntry, "brokenRate.text");
		dataBinder.registerBinding("FarmerSumEntry.rottenRate", java.math.BigDecimal.class, this.kdtFarmerSumEntry, "rottenRate.text");
		dataBinder.registerBinding("allNoFertileEggQty", int.class, this.txtallNoFertileEggQty, "value");
		dataBinder.registerBinding("allAddleEggQty", int.class, this.txtallAddleEggQty, "value");
		dataBinder.registerBinding("allRottenEggQty", int.class, this.txtallRottenEggQty, "value");
		dataBinder.registerBinding("allHatchEggQty", int.class, this.txtallHatchEggQty, "value");
		dataBinder.registerBinding("operator", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtoperator, "data");
		dataBinder.registerBinding("allHealthEggQty", int.class, this.txtallHealthEggQty, "value");
		dataBinder.registerBinding("hatchArea", com.kingdee.eas.farm.hatch.HatchAreaInfo.class, this.prmthatchArea, "data");
		dataBinder.registerBinding("incubator", com.kingdee.eas.farm.hatch.IncubatorInfo.class, this.prmtincubator, "data");
		dataBinder.registerBinding("otherLoss", int.class, this.txtotherLoss, "value");
		dataBinder.registerBinding("adminOrg", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtadminOrg, "data");
		dataBinder.registerBinding("allBrokenEggQty", int.class, this.txtallBrokenEggQty, "value");
		dataBinder.registerBinding("brokenEggQty", int.class, this.txtbrokenEggQty, "value");
		dataBinder.registerBinding("fertilityRate", java.math.BigDecimal.class, this.txtfertilityRate, "value");
		dataBinder.registerBinding("hatchHouse", com.kingdee.eas.farm.hatch.HatchHouseInfo.class, this.prmthatchHouse, "data");
		dataBinder.registerBinding("eggType", com.kingdee.eas.farm.hatch.EggType.class, this.eggType, "selectedItem");
		dataBinder.registerBinding("AreaSumEntry.seq", int.class, this.kdtAreaSumEntry, "seq.text");
		dataBinder.registerBinding("AreaSumEntry", com.kingdee.eas.farm.hatch.BEggCandlingBillAreaSumEntryInfo.class, this.kdtAreaSumEntry, "userObject");
		dataBinder.registerBinding("AreaSumEntry.outArea", java.lang.Object.class, this.kdtAreaSumEntry, "outArea.text");
		dataBinder.registerBinding("AreaSumEntry.qcEggType", com.kingdee.util.enums.Enum.class, this.kdtAreaSumEntry, "qcEggType.text");
		dataBinder.registerBinding("AreaSumEntry.eggQty", int.class, this.kdtAreaSumEntry, "eggQty.text");
		dataBinder.registerBinding("AreaSumEntry.healthEggQty", int.class, this.kdtAreaSumEntry, "healthEggQty.text");
		dataBinder.registerBinding("AreaSumEntry.noFertileEggQty", int.class, this.kdtAreaSumEntry, "noFertileEggQty.text");
		dataBinder.registerBinding("AreaSumEntry.brokenYolkQty", int.class, this.kdtAreaSumEntry, "brokenYolkQty.text");
		dataBinder.registerBinding("AreaSumEntry.addleEggQty", int.class, this.kdtAreaSumEntry, "addleEggQty.text");
		dataBinder.registerBinding("AreaSumEntry.rottenEggQty", int.class, this.kdtAreaSumEntry, "rottenEggQty.text");
		dataBinder.registerBinding("AreaSumEntry.brokenEggQty", int.class, this.kdtAreaSumEntry, "brokenEggQty.text");
		dataBinder.registerBinding("AreaSumEntry.diffEggQty", int.class, this.kdtAreaSumEntry, "diffEggQty.text");
		dataBinder.registerBinding("AreaSumEntry.fertilityRate", java.math.BigDecimal.class, this.kdtAreaSumEntry, "fertilityRate.text");
		dataBinder.registerBinding("AreaSumEntry.addleEggRate", java.math.BigDecimal.class, this.kdtAreaSumEntry, "addleEggRate.text");
		dataBinder.registerBinding("AreaSumEntry.supplier", java.lang.Object.class, this.kdtAreaSumEntry, "supplier.text");
		dataBinder.registerBinding("hatchDate", java.util.Date.class, this.pkhatchDate, "value");
		dataBinder.registerBinding("trayingDate", java.util.Date.class, this.pktrayingDate, "value");
		dataBinder.registerBinding("genderTy", com.kingdee.eas.farm.stocking.hatch.GenderType.class, this.genderTy, "selectedItem");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.hatch.app.BEggCandlingBillEditUIHandler";
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
        this.pkauditTime.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.hatch.BEggCandlingBillInfo)ov;
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
	 * ????????§µ??
	 */
	protected void registerValidator() {
    	getValidateHelper().setCustomValidator( getValidator() );
		getValidateHelper().registerBindProperty("isTraying", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isProBabyBill", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isOtherIn", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hatchFactory", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.eggSourceType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.eggLog", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.eggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.noFertileEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.addleEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.healthEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.brokenEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.rottenEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.otherEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.outFarm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.supplier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.outBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.breedBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.brokenYolkQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.fertilityRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.house", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.outHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.hatchHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.qc1lv1Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.qc1lv2Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.qc2lv1Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.qc2lv2Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.qc3lv1Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.qc4lv1Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.qc5lv1Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.qc6lv1Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.incubator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.hatchCarNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.outArea", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.isMix", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.qcEggType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.weekAge", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.dayAge", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.isFormal", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.diffEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.addleEggRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.genderType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.eggDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.lphealthEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.lossQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.rottenRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.brokenRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.CostObject", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.hatchsBox", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.liveEggRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntries.noFertileEggRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmerSumEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmerSumEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmerSumEntry.farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmerSumEntry.eggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmerSumEntry.healthEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmerSumEntry.noFertileEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmerSumEntry.brokenYolkQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmerSumEntry.addleEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmerSumEntry.rottenEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmerSumEntry.brokenEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmerSumEntry.diffEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmerSumEntry.fertilityRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmerSumEntry.addleEggRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmerSumEntry.house", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmerSumEntry.supploer1", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmerSumEntry.hgdlx", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmerSumEntry.brokenRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmerSumEntry.rottenRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allNoFertileEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allAddleEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allRottenEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allHatchEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("operator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allHealthEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hatchArea", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("incubator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("otherLoss", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("adminOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allBrokenEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("brokenEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fertilityRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hatchHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eggType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AreaSumEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AreaSumEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AreaSumEntry.outArea", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AreaSumEntry.qcEggType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AreaSumEntry.eggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AreaSumEntry.healthEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AreaSumEntry.noFertileEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AreaSumEntry.brokenYolkQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AreaSumEntry.addleEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AreaSumEntry.rottenEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AreaSumEntry.brokenEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AreaSumEntry.diffEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AreaSumEntry.fertilityRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AreaSumEntry.addleEggRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AreaSumEntry.supplier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hatchDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("trayingDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("genderTy", ValidateHelper.ON_SAVE);    		
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
     * output kdtEggEntries_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEggEntries_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("farmer".equalsIgnoreCase(kdtEggEntries.getColumn(colIndex).getKey())) {
kdtEggEntries.getCell(rowIndex,"outArea").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEggEntries.getCell(rowIndex,"farmer").getValue(),"treeid"));

}

    if ("qc1lv1Qty".equalsIgnoreCase(kdtEggEntries.getColumn(colIndex).getKey())) {
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));

}

    if ("qc1lv2Qty".equalsIgnoreCase(kdtEggEntries.getColumn(colIndex).getKey())) {
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));

}

    if ("qc2lv1Qty".equalsIgnoreCase(kdtEggEntries.getColumn(colIndex).getKey())) {
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));

}

    if ("qc2lv2Qty".equalsIgnoreCase(kdtEggEntries.getColumn(colIndex).getKey())) {
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));

}

    if ("qc3lv1Qty".equalsIgnoreCase(kdtEggEntries.getColumn(colIndex).getKey())) {
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));

}

    if ("qc4lv1Qty".equalsIgnoreCase(kdtEggEntries.getColumn(colIndex).getKey())) {
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));

}

    if ("qc5lv1Qty".equalsIgnoreCase(kdtEggEntries.getColumn(colIndex).getKey())) {
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));

}

    if ("qc6lv1Qty".equalsIgnoreCase(kdtEggEntries.getColumn(colIndex).getKey())) {
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntries.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntries.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));

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
        sic.add(new SelectorItemInfo("isTraying"));
        sic.add(new SelectorItemInfo("isProBabyBill"));
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
        sic.add(new SelectorItemInfo("auditTime"));
        sic.add(new SelectorItemInfo("baseStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("hatchFactory.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("hatchFactory.id"));
        	sic.add(new SelectorItemInfo("hatchFactory.number"));
        	sic.add(new SelectorItemInfo("hatchFactory.name"));
		}
    	sic.add(new SelectorItemInfo("EggEntries.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntries.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("EggEntries.eggSourceType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntries.farm.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntries.farm.id"));
			sic.add(new SelectorItemInfo("EggEntries.farm.name"));
        	sic.add(new SelectorItemInfo("EggEntries.farm.number"));
		}
    	sic.add(new SelectorItemInfo("EggEntries.eggLog"));
    	sic.add(new SelectorItemInfo("EggEntries.eggQty"));
    	sic.add(new SelectorItemInfo("EggEntries.noFertileEggQty"));
    	sic.add(new SelectorItemInfo("EggEntries.addleEggQty"));
    	sic.add(new SelectorItemInfo("EggEntries.healthEggQty"));
    	sic.add(new SelectorItemInfo("EggEntries.brokenEggQty"));
    	sic.add(new SelectorItemInfo("EggEntries.rottenEggQty"));
    	sic.add(new SelectorItemInfo("EggEntries.otherEggQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntries.farmer.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntries.farmer.id"));
			sic.add(new SelectorItemInfo("EggEntries.farmer.name"));
        	sic.add(new SelectorItemInfo("EggEntries.farmer.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntries.outFarm.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntries.outFarm.id"));
			sic.add(new SelectorItemInfo("EggEntries.outFarm.name"));
        	sic.add(new SelectorItemInfo("EggEntries.outFarm.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntries.supplier.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntries.supplier.id"));
			sic.add(new SelectorItemInfo("EggEntries.supplier.name"));
        	sic.add(new SelectorItemInfo("EggEntries.supplier.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntries.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntries.material.id"));
			sic.add(new SelectorItemInfo("EggEntries.material.name"));
        	sic.add(new SelectorItemInfo("EggEntries.material.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntries.outBatch.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntries.outBatch.id"));
			sic.add(new SelectorItemInfo("EggEntries.outBatch.number"));
			sic.add(new SelectorItemInfo("EggEntries.outBatch.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntries.breedBatch.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntries.breedBatch.id"));
			sic.add(new SelectorItemInfo("EggEntries.breedBatch.number"));
		}
    	sic.add(new SelectorItemInfo("EggEntries.brokenYolkQty"));
    	sic.add(new SelectorItemInfo("EggEntries.fertilityRate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntries.house.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntries.house.id"));
			sic.add(new SelectorItemInfo("EggEntries.house.name"));
        	sic.add(new SelectorItemInfo("EggEntries.house.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntries.outHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntries.outHouse.id"));
			sic.add(new SelectorItemInfo("EggEntries.outHouse.name"));
        	sic.add(new SelectorItemInfo("EggEntries.outHouse.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntries.hatchHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntries.hatchHouse.id"));
			sic.add(new SelectorItemInfo("EggEntries.hatchHouse.name"));
        	sic.add(new SelectorItemInfo("EggEntries.hatchHouse.number"));
		}
    	sic.add(new SelectorItemInfo("EggEntries.qc1lv1Qty"));
    	sic.add(new SelectorItemInfo("EggEntries.qc1lv2Qty"));
    	sic.add(new SelectorItemInfo("EggEntries.qc2lv1Qty"));
    	sic.add(new SelectorItemInfo("EggEntries.qc2lv2Qty"));
    	sic.add(new SelectorItemInfo("EggEntries.qc3lv1Qty"));
    	sic.add(new SelectorItemInfo("EggEntries.qc4lv1Qty"));
    	sic.add(new SelectorItemInfo("EggEntries.qc5lv1Qty"));
    	sic.add(new SelectorItemInfo("EggEntries.qc6lv1Qty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntries.incubator.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntries.incubator.id"));
			sic.add(new SelectorItemInfo("EggEntries.incubator.name"));
        	sic.add(new SelectorItemInfo("EggEntries.incubator.number"));
		}
    	sic.add(new SelectorItemInfo("EggEntries.hatchCarNum"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntries.outArea.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntries.outArea.id"));
			sic.add(new SelectorItemInfo("EggEntries.outArea.name"));
        	sic.add(new SelectorItemInfo("EggEntries.outArea.number"));
		}
    	sic.add(new SelectorItemInfo("EggEntries.isMix"));
    	sic.add(new SelectorItemInfo("EggEntries.qcEggType"));
    	sic.add(new SelectorItemInfo("EggEntries.weekAge"));
    	sic.add(new SelectorItemInfo("EggEntries.dayAge"));
    	sic.add(new SelectorItemInfo("EggEntries.isFormal"));
    	sic.add(new SelectorItemInfo("EggEntries.diffEggQty"));
    	sic.add(new SelectorItemInfo("EggEntries.addleEggRate"));
    	sic.add(new SelectorItemInfo("EggEntries.genderType"));
    	sic.add(new SelectorItemInfo("EggEntries.eggDate"));
    	sic.add(new SelectorItemInfo("EggEntries.lphealthEggQty"));
    	sic.add(new SelectorItemInfo("EggEntries.lossQty"));
    	sic.add(new SelectorItemInfo("EggEntries.rottenRate"));
    	sic.add(new SelectorItemInfo("EggEntries.brokenRate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntries.CostObject.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntries.CostObject.id"));
			sic.add(new SelectorItemInfo("EggEntries.CostObject.name"));
        	sic.add(new SelectorItemInfo("EggEntries.CostObject.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntries.hatchsBox.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntries.hatchsBox.id"));
			sic.add(new SelectorItemInfo("EggEntries.hatchsBox.name"));
        	sic.add(new SelectorItemInfo("EggEntries.hatchsBox.number"));
		}
    	sic.add(new SelectorItemInfo("EggEntries.liveEggRate"));
    	sic.add(new SelectorItemInfo("EggEntries.noFertileEggRate"));
    	sic.add(new SelectorItemInfo("FarmerSumEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FarmerSumEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FarmerSumEntry.farmer.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("FarmerSumEntry.farmer.id"));
			sic.add(new SelectorItemInfo("FarmerSumEntry.farmer.name"));
        	sic.add(new SelectorItemInfo("FarmerSumEntry.farmer.number"));
		}
    	sic.add(new SelectorItemInfo("FarmerSumEntry.eggQty"));
    	sic.add(new SelectorItemInfo("FarmerSumEntry.healthEggQty"));
    	sic.add(new SelectorItemInfo("FarmerSumEntry.noFertileEggQty"));
    	sic.add(new SelectorItemInfo("FarmerSumEntry.brokenYolkQty"));
    	sic.add(new SelectorItemInfo("FarmerSumEntry.addleEggQty"));
    	sic.add(new SelectorItemInfo("FarmerSumEntry.rottenEggQty"));
    	sic.add(new SelectorItemInfo("FarmerSumEntry.brokenEggQty"));
    	sic.add(new SelectorItemInfo("FarmerSumEntry.diffEggQty"));
    	sic.add(new SelectorItemInfo("FarmerSumEntry.fertilityRate"));
    	sic.add(new SelectorItemInfo("FarmerSumEntry.addleEggRate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FarmerSumEntry.house.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("FarmerSumEntry.house.id"));
			sic.add(new SelectorItemInfo("FarmerSumEntry.house.name"));
        	sic.add(new SelectorItemInfo("FarmerSumEntry.house.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FarmerSumEntry.supploer1.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("FarmerSumEntry.supploer1.id"));
			sic.add(new SelectorItemInfo("FarmerSumEntry.supploer1.name"));
        	sic.add(new SelectorItemInfo("FarmerSumEntry.supploer1.number"));
		}
    	sic.add(new SelectorItemInfo("FarmerSumEntry.hgdlx"));
    	sic.add(new SelectorItemInfo("FarmerSumEntry.brokenRate"));
    	sic.add(new SelectorItemInfo("FarmerSumEntry.rottenRate"));
        sic.add(new SelectorItemInfo("allNoFertileEggQty"));
        sic.add(new SelectorItemInfo("allAddleEggQty"));
        sic.add(new SelectorItemInfo("allRottenEggQty"));
        sic.add(new SelectorItemInfo("allHatchEggQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("operator.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("operator.id"));
        	sic.add(new SelectorItemInfo("operator.number"));
        	sic.add(new SelectorItemInfo("operator.name"));
		}
        sic.add(new SelectorItemInfo("allHealthEggQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("hatchArea.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("hatchArea.id"));
        	sic.add(new SelectorItemInfo("hatchArea.number"));
        	sic.add(new SelectorItemInfo("hatchArea.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("incubator.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("incubator.id"));
        	sic.add(new SelectorItemInfo("incubator.number"));
        	sic.add(new SelectorItemInfo("incubator.name"));
		}
        sic.add(new SelectorItemInfo("otherLoss"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("adminOrg.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("adminOrg.id"));
        	sic.add(new SelectorItemInfo("adminOrg.number"));
        	sic.add(new SelectorItemInfo("adminOrg.name"));
		}
        sic.add(new SelectorItemInfo("allBrokenEggQty"));
        sic.add(new SelectorItemInfo("brokenEggQty"));
        sic.add(new SelectorItemInfo("fertilityRate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("hatchHouse.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("hatchHouse.id"));
        	sic.add(new SelectorItemInfo("hatchHouse.number"));
        	sic.add(new SelectorItemInfo("hatchHouse.name"));
		}
        sic.add(new SelectorItemInfo("eggType"));
    	sic.add(new SelectorItemInfo("AreaSumEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("AreaSumEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("AreaSumEntry.outArea.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("AreaSumEntry.outArea.id"));
			sic.add(new SelectorItemInfo("AreaSumEntry.outArea.name"));
        	sic.add(new SelectorItemInfo("AreaSumEntry.outArea.number"));
		}
    	sic.add(new SelectorItemInfo("AreaSumEntry.qcEggType"));
    	sic.add(new SelectorItemInfo("AreaSumEntry.eggQty"));
    	sic.add(new SelectorItemInfo("AreaSumEntry.healthEggQty"));
    	sic.add(new SelectorItemInfo("AreaSumEntry.noFertileEggQty"));
    	sic.add(new SelectorItemInfo("AreaSumEntry.brokenYolkQty"));
    	sic.add(new SelectorItemInfo("AreaSumEntry.addleEggQty"));
    	sic.add(new SelectorItemInfo("AreaSumEntry.rottenEggQty"));
    	sic.add(new SelectorItemInfo("AreaSumEntry.brokenEggQty"));
    	sic.add(new SelectorItemInfo("AreaSumEntry.diffEggQty"));
    	sic.add(new SelectorItemInfo("AreaSumEntry.fertilityRate"));
    	sic.add(new SelectorItemInfo("AreaSumEntry.addleEggRate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("AreaSumEntry.supplier.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("AreaSumEntry.supplier.id"));
			sic.add(new SelectorItemInfo("AreaSumEntry.supplier.name"));
        	sic.add(new SelectorItemInfo("AreaSumEntry.supplier.number"));
		}
        sic.add(new SelectorItemInfo("hatchDate"));
        sic.add(new SelectorItemInfo("trayingDate"));
        sic.add(new SelectorItemInfo("genderTy"));
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
        com.kingdee.eas.farm.hatch.BEggCandlingBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.hatch.BEggCandlingBillFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionAdjust_actionPerformed method
     */
    public void actionAdjust_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.hatch.BEggCandlingBillFactory.getRemoteInstance().adjust(editData);
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
	public RequestContext prepareActionAdjust(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAdjust() {
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
            innerActionPerformed("eas", AbstractBEggCandlingBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractBEggCandlingBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionAdjust class
     */     
    protected class ActionAdjust extends ItemAction {     
    
        public ActionAdjust()
        {
            this(null);
        }

        public ActionAdjust(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionAdjust.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAdjust.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAdjust.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractBEggCandlingBillEditUI.this, "ActionAdjust", "actionAdjust_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.hatch.client", "BEggCandlingBillEditUI");
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
        return com.kingdee.eas.farm.hatch.client.BEggCandlingBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.hatch.BEggCandlingBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.hatch.BEggCandlingBillInfo objectValue = new com.kingdee.eas.farm.hatch.BEggCandlingBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/hatch/BEggCandlingBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.hatch.app.BEggCandlingBillQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"ÒµÎñÈÕÆÚ"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmthatchFactory.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"·õ»¯³¡"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(eggType.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"ÖÖµ°ÀàÐÍ"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtEggEntries;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("baseStatus",new Integer(-1));
vo.put("eggType","Parent");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}        
				protected void setTableToSumField() {
			setTableToSumField(kdtEggEntries,new String[] {"eggQty","healthEggQty","lphealthEggQty","noFertileEggQty","brokenYolkQty","addleEggQty","otherEggQty","diffEggQty"});
		}


}