/**
 * output package name
 */
package com.kingdee.eas.custom.settlebill.client;

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
public abstract class AbstractSettleBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSettleBillEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane paneBIZLayerControl17;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaccountUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdepartment;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpolicy;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoperator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contslaughterPlace;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfeedToMeat;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsurvivalRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmedicineUsage;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdisinfectant;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfeedingAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmedicineAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contotherAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contunitWeight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdayAge;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contunitAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrebackCostAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrebackCostPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgrossDuckSalePrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contunitEatQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyieldRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contremark;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkFivouchered;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickCostAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdrugCostAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfeedCostAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfeedBaseQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalAmt_1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfeedToMeat_1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfeedToMeat_2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contunitEatQty_1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsendCars;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatchContract;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contseriousContract;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontractType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDPanel baseTab;
    protected com.kingdee.bos.ctrl.swing.KDPanel otherTab;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtOtherEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtOtherEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtSubsidy;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtSubsidy_detailPanel = null;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtaccountUnit;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtdepartment;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmer;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpolicy;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtoperator;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtslaughterPlace;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfeedToMeat;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsurvivalRate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmedicineUsage;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdisinfectant;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfeedingAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmedicineAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtotherAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtunitWeight;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdayAge;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtunitAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtrebackCostAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtrebackCostPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgrossDuckSalePrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtunitEatQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyieldRate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickAmt;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtremark;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfarm;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickCostAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdrugCostAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfeedCostAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfeedBaseQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalAmt_1;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfeedToMeat_1;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfeedToMeat_2;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtunitEatQty_1;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkinDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsendCars;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbatchContract;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtseriousContract;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcontractType;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnGetCostAmt;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnExeSet;
    protected com.kingdee.eas.custom.settlebill.SettleBillInfo editData = null;
    protected ActionGetCostAmt actionGetCostAmt = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionCheckVoucher actionCheckVoucher = null;
    protected ActionExeSet actionExeSet = null;
    /**
     * output class constructor
     */
    public AbstractSettleBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractSettleBillEditUI.class.getName());
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
        //actionGetCostAmt
        this.actionGetCostAmt = new ActionGetCostAmt(this);
        getActionManager().registerAction("actionGetCostAmt", actionGetCostAmt);
        this.actionGetCostAmt.setExtendProperty("canForewarn", "true");
        this.actionGetCostAmt.setExtendProperty("userDefined", "true");
        this.actionGetCostAmt.setExtendProperty("isObjectUpdateLock", "false");
         this.actionGetCostAmt.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionGetCostAmt.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
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
        //actionCheckVoucher
        this.actionCheckVoucher = new ActionCheckVoucher(this);
        getActionManager().registerAction("actionCheckVoucher", actionCheckVoucher);
        this.actionCheckVoucher.setExtendProperty("canForewarn", "true");
        this.actionCheckVoucher.setExtendProperty("userDefined", "false");
        this.actionCheckVoucher.setExtendProperty("isObjectUpdateLock", "false");
         this.actionCheckVoucher.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionCheckVoucher.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionExeSet
        this.actionExeSet = new ActionExeSet(this);
        getActionManager().registerAction("actionExeSet", actionExeSet);
        this.actionExeSet.setExtendProperty("canForewarn", "true");
        this.actionExeSet.setExtendProperty("userDefined", "true");
        this.actionExeSet.setExtendProperty("isObjectUpdateLock", "false");
         this.actionExeSet.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionExeSet.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.paneBIZLayerControl17 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contaccountUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdepartment = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpolicy = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoperator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contslaughterPlace = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfeedToMeat = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsurvivalRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmedicineUsage = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdisinfectant = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfeedingAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmedicineAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contotherAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contunitWeight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdayAge = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contunitAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrebackCostAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrebackCostPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgrossDuckSalePrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contunitEatQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyieldRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchickAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contremark = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkFivouchered = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contchickCostAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdrugCostAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfeedCostAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfeedBaseQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchickQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalAmt_1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfeedToMeat_1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfeedToMeat_2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contunitEatQty_1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsendCars = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbatchContract = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contseriousContract = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcontractType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.baseTab = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.otherTab = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtOtherEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtSubsidy = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.prmtaccountUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtdepartment = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtfarmer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtpolicy = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtoperator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtslaughterPlace = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtfeedToMeat = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsurvivalRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmedicineUsage = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdisinfectant = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfeedingAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmedicineAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtotherAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtunitWeight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdayAge = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttotalAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtunitAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtrebackCostAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtrebackCostPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtgrossDuckSalePrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtunitEatQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyieldRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtchickAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtremark = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtfarm = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtchickCostAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdrugCostAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfeedCostAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfeedBaseQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtchickQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttotalAmt_1 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfeedToMeat_1 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfeedToMeat_2 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtunitEatQty_1 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkinDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtsendCars = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbatchContract = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtseriousContract = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcontractType = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.btnGetCostAmt = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnExeSet = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.paneBIZLayerControl17.setName("paneBIZLayerControl17");
        this.contaccountUnit.setName("contaccountUnit");
        this.contdepartment.setName("contdepartment");
        this.contfarmer.setName("contfarmer");
        this.contpolicy.setName("contpolicy");
        this.contoperator.setName("contoperator");
        this.contslaughterPlace.setName("contslaughterPlace");
        this.contfeedToMeat.setName("contfeedToMeat");
        this.contsurvivalRate.setName("contsurvivalRate");
        this.contmedicineUsage.setName("contmedicineUsage");
        this.contdisinfectant.setName("contdisinfectant");
        this.contfeedingAmt.setName("contfeedingAmt");
        this.contmedicineAmt.setName("contmedicineAmt");
        this.contotherAmt.setName("contotherAmt");
        this.contunitWeight.setName("contunitWeight");
        this.contdayAge.setName("contdayAge");
        this.conttotalAmt.setName("conttotalAmt");
        this.contunitAmt.setName("contunitAmt");
        this.contrebackCostAmt.setName("contrebackCostAmt");
        this.contrebackCostPrice.setName("contrebackCostPrice");
        this.contgrossDuckSalePrice.setName("contgrossDuckSalePrice");
        this.contunitEatQty.setName("contunitEatQty");
        this.contyieldRate.setName("contyieldRate");
        this.contchickAmt.setName("contchickAmt");
        this.contremark.setName("contremark");
        this.contfarm.setName("contfarm");
        this.contbillStatus.setName("contbillStatus");
        this.chkFivouchered.setName("chkFivouchered");
        this.contchickCostAmt.setName("contchickCostAmt");
        this.contdrugCostAmt.setName("contdrugCostAmt");
        this.contfeedCostAmt.setName("contfeedCostAmt");
        this.contfeedBaseQty.setName("contfeedBaseQty");
        this.contchickQty.setName("contchickQty");
        this.conttotalAmt_1.setName("conttotalAmt_1");
        this.contfeedToMeat_1.setName("contfeedToMeat_1");
        this.contfeedToMeat_2.setName("contfeedToMeat_2");
        this.contunitEatQty_1.setName("contunitEatQty_1");
        this.continDate.setName("continDate");
        this.contsendCars.setName("contsendCars");
        this.contbatchContract.setName("contbatchContract");
        this.contseriousContract.setName("contseriousContract");
        this.contcontractType.setName("contcontractType");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.baseTab.setName("baseTab");
        this.otherTab.setName("otherTab");
        this.kDPanel2.setName("kDPanel2");
        this.kdtEntrys.setName("kdtEntrys");
        this.kdtOtherEntrys.setName("kdtOtherEntrys");
        this.kdtSubsidy.setName("kdtSubsidy");
        this.prmtaccountUnit.setName("prmtaccountUnit");
        this.prmtdepartment.setName("prmtdepartment");
        this.prmtfarmer.setName("prmtfarmer");
        this.txtpolicy.setName("txtpolicy");
        this.prmtoperator.setName("prmtoperator");
        this.txtslaughterPlace.setName("txtslaughterPlace");
        this.txtfeedToMeat.setName("txtfeedToMeat");
        this.txtsurvivalRate.setName("txtsurvivalRate");
        this.txtmedicineUsage.setName("txtmedicineUsage");
        this.txtdisinfectant.setName("txtdisinfectant");
        this.txtfeedingAmt.setName("txtfeedingAmt");
        this.txtmedicineAmt.setName("txtmedicineAmt");
        this.txtotherAmt.setName("txtotherAmt");
        this.txtunitWeight.setName("txtunitWeight");
        this.txtdayAge.setName("txtdayAge");
        this.txttotalAmt.setName("txttotalAmt");
        this.txtunitAmt.setName("txtunitAmt");
        this.txtrebackCostAmt.setName("txtrebackCostAmt");
        this.txtrebackCostPrice.setName("txtrebackCostPrice");
        this.txtgrossDuckSalePrice.setName("txtgrossDuckSalePrice");
        this.txtunitEatQty.setName("txtunitEatQty");
        this.txtyieldRate.setName("txtyieldRate");
        this.txtchickAmt.setName("txtchickAmt");
        this.txtremark.setName("txtremark");
        this.txtfarm.setName("txtfarm");
        this.billStatus.setName("billStatus");
        this.txtchickCostAmt.setName("txtchickCostAmt");
        this.txtdrugCostAmt.setName("txtdrugCostAmt");
        this.txtfeedCostAmt.setName("txtfeedCostAmt");
        this.txtfeedBaseQty.setName("txtfeedBaseQty");
        this.txtchickQty.setName("txtchickQty");
        this.txttotalAmt_1.setName("txttotalAmt_1");
        this.txtfeedToMeat_1.setName("txtfeedToMeat_1");
        this.txtfeedToMeat_2.setName("txtfeedToMeat_2");
        this.txtunitEatQty_1.setName("txtunitEatQty_1");
        this.pkinDate.setName("pkinDate");
        this.prmtsendCars.setName("prmtsendCars");
        this.prmtbatchContract.setName("prmtbatchContract");
        this.prmtseriousContract.setName("prmtseriousContract");
        this.prmtcontractType.setName("prmtcontractType");
        this.btnGetCostAmt.setName("btnGetCostAmt");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
        this.btnExeSet.setName("btnExeSet");
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
        this.contCreator.setBoundLabelAlignment(7);		
        this.contCreator.setVisible(true);		
        this.contCreator.setForeground(new java.awt.Color(0,0,0));
        // contCreateTime		
        this.contCreateTime.setBoundLabelText(resHelper.getString("contCreateTime.boundLabelText"));		
        this.contCreateTime.setBoundLabelLength(100);		
        this.contCreateTime.setBoundLabelUnderline(true);		
        this.contCreateTime.setEnabled(false);		
        this.contCreateTime.setBoundLabelAlignment(7);		
        this.contCreateTime.setVisible(true);		
        this.contCreateTime.setForeground(new java.awt.Color(0,0,0));
        // contLastUpdateUser		
        this.contLastUpdateUser.setBoundLabelText(resHelper.getString("contLastUpdateUser.boundLabelText"));		
        this.contLastUpdateUser.setBoundLabelLength(100);		
        this.contLastUpdateUser.setBoundLabelUnderline(true);		
        this.contLastUpdateUser.setEnabled(false);		
        this.contLastUpdateUser.setVisible(false);		
        this.contLastUpdateUser.setBoundLabelAlignment(7);		
        this.contLastUpdateUser.setForeground(new java.awt.Color(0,0,0));
        // contLastUpdateTime		
        this.contLastUpdateTime.setBoundLabelText(resHelper.getString("contLastUpdateTime.boundLabelText"));		
        this.contLastUpdateTime.setBoundLabelLength(100);		
        this.contLastUpdateTime.setBoundLabelUnderline(true);		
        this.contLastUpdateTime.setEnabled(false);		
        this.contLastUpdateTime.setVisible(false);		
        this.contLastUpdateTime.setBoundLabelAlignment(7);		
        this.contLastUpdateTime.setForeground(new java.awt.Color(0,0,0));
        // contNumber		
        this.contNumber.setBoundLabelText(resHelper.getString("contNumber.boundLabelText"));		
        this.contNumber.setBoundLabelLength(80);		
        this.contNumber.setBoundLabelUnderline(true);		
        this.contNumber.setBoundLabelAlignment(7);		
        this.contNumber.setVisible(true);		
        this.contNumber.setForeground(new java.awt.Color(0,0,0));
        // contBizDate		
        this.contBizDate.setBoundLabelText(resHelper.getString("contBizDate.boundLabelText"));		
        this.contBizDate.setBoundLabelLength(80);		
        this.contBizDate.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelAlignment(7);		
        this.contBizDate.setVisible(true);		
        this.contBizDate.setForeground(new java.awt.Color(0,0,0));
        // contDescription		
        this.contDescription.setBoundLabelText(resHelper.getString("contDescription.boundLabelText"));		
        this.contDescription.setBoundLabelLength(80);		
        this.contDescription.setBoundLabelUnderline(true);		
        this.contDescription.setBoundLabelAlignment(7);		
        this.contDescription.setVisible(true);		
        this.contDescription.setForeground(new java.awt.Color(0,0,0));
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);		
        this.contAuditor.setBoundLabelAlignment(7);		
        this.contAuditor.setVisible(true);		
        this.contAuditor.setForeground(new java.awt.Color(0,0,0));
        // paneBIZLayerControl17		
        this.paneBIZLayerControl17.setVisible(true);
        // contaccountUnit		
        this.contaccountUnit.setBoundLabelText(resHelper.getString("contaccountUnit.boundLabelText"));		
        this.contaccountUnit.setBoundLabelLength(80);		
        this.contaccountUnit.setBoundLabelUnderline(true);		
        this.contaccountUnit.setVisible(true);		
        this.contaccountUnit.setForeground(new java.awt.Color(0,0,0));
        // contdepartment		
        this.contdepartment.setBoundLabelText(resHelper.getString("contdepartment.boundLabelText"));		
        this.contdepartment.setBoundLabelLength(80);		
        this.contdepartment.setBoundLabelUnderline(true);		
        this.contdepartment.setVisible(true);		
        this.contdepartment.setForeground(new java.awt.Color(0,0,0));
        // contfarmer		
        this.contfarmer.setBoundLabelText(resHelper.getString("contfarmer.boundLabelText"));		
        this.contfarmer.setBoundLabelLength(80);		
        this.contfarmer.setBoundLabelUnderline(true);		
        this.contfarmer.setVisible(true);		
        this.contfarmer.setForeground(new java.awt.Color(0,0,0));
        // contpolicy		
        this.contpolicy.setBoundLabelText(resHelper.getString("contpolicy.boundLabelText"));		
        this.contpolicy.setBoundLabelLength(80);		
        this.contpolicy.setBoundLabelUnderline(true);		
        this.contpolicy.setVisible(true);		
        this.contpolicy.setForeground(new java.awt.Color(0,0,0));
        // contoperator		
        this.contoperator.setBoundLabelText(resHelper.getString("contoperator.boundLabelText"));		
        this.contoperator.setBoundLabelLength(80);		
        this.contoperator.setBoundLabelUnderline(true);		
        this.contoperator.setVisible(true);		
        this.contoperator.setForeground(new java.awt.Color(0,0,0));
        // contslaughterPlace		
        this.contslaughterPlace.setBoundLabelText(resHelper.getString("contslaughterPlace.boundLabelText"));		
        this.contslaughterPlace.setBoundLabelLength(80);		
        this.contslaughterPlace.setBoundLabelUnderline(true);		
        this.contslaughterPlace.setVisible(true);		
        this.contslaughterPlace.setForeground(new java.awt.Color(0,0,0));
        // contfeedToMeat		
        this.contfeedToMeat.setBoundLabelText(resHelper.getString("contfeedToMeat.boundLabelText"));		
        this.contfeedToMeat.setBoundLabelLength(80);		
        this.contfeedToMeat.setBoundLabelUnderline(true);		
        this.contfeedToMeat.setVisible(true);		
        this.contfeedToMeat.setForeground(new java.awt.Color(0,0,0));
        // contsurvivalRate		
        this.contsurvivalRate.setBoundLabelText(resHelper.getString("contsurvivalRate.boundLabelText"));		
        this.contsurvivalRate.setBoundLabelLength(80);		
        this.contsurvivalRate.setBoundLabelUnderline(true);		
        this.contsurvivalRate.setVisible(true);		
        this.contsurvivalRate.setForeground(new java.awt.Color(0,0,0));
        // contmedicineUsage		
        this.contmedicineUsage.setBoundLabelText(resHelper.getString("contmedicineUsage.boundLabelText"));		
        this.contmedicineUsage.setBoundLabelLength(80);		
        this.contmedicineUsage.setBoundLabelUnderline(true);		
        this.contmedicineUsage.setVisible(true);		
        this.contmedicineUsage.setForeground(new java.awt.Color(0,0,0));
        // contdisinfectant		
        this.contdisinfectant.setBoundLabelText(resHelper.getString("contdisinfectant.boundLabelText"));		
        this.contdisinfectant.setBoundLabelLength(80);		
        this.contdisinfectant.setBoundLabelUnderline(true);		
        this.contdisinfectant.setVisible(true);		
        this.contdisinfectant.setForeground(new java.awt.Color(0,0,0));
        // contfeedingAmt		
        this.contfeedingAmt.setBoundLabelText(resHelper.getString("contfeedingAmt.boundLabelText"));		
        this.contfeedingAmt.setBoundLabelLength(80);		
        this.contfeedingAmt.setBoundLabelUnderline(true);		
        this.contfeedingAmt.setVisible(true);		
        this.contfeedingAmt.setForeground(new java.awt.Color(0,0,0));
        // contmedicineAmt		
        this.contmedicineAmt.setBoundLabelText(resHelper.getString("contmedicineAmt.boundLabelText"));		
        this.contmedicineAmt.setBoundLabelLength(80);		
        this.contmedicineAmt.setBoundLabelUnderline(true);		
        this.contmedicineAmt.setVisible(true);		
        this.contmedicineAmt.setForeground(new java.awt.Color(0,0,0));
        // contotherAmt		
        this.contotherAmt.setBoundLabelText(resHelper.getString("contotherAmt.boundLabelText"));		
        this.contotherAmt.setBoundLabelLength(80);		
        this.contotherAmt.setBoundLabelUnderline(true);		
        this.contotherAmt.setVisible(true);		
        this.contotherAmt.setForeground(new java.awt.Color(0,0,0));
        // contunitWeight		
        this.contunitWeight.setBoundLabelText(resHelper.getString("contunitWeight.boundLabelText"));		
        this.contunitWeight.setBoundLabelLength(80);		
        this.contunitWeight.setBoundLabelUnderline(true);		
        this.contunitWeight.setVisible(true);		
        this.contunitWeight.setForeground(new java.awt.Color(0,0,0));
        // contdayAge		
        this.contdayAge.setBoundLabelText(resHelper.getString("contdayAge.boundLabelText"));		
        this.contdayAge.setBoundLabelLength(80);		
        this.contdayAge.setBoundLabelUnderline(true);		
        this.contdayAge.setVisible(true);		
        this.contdayAge.setForeground(new java.awt.Color(0,0,0));
        // conttotalAmt		
        this.conttotalAmt.setBoundLabelText(resHelper.getString("conttotalAmt.boundLabelText"));		
        this.conttotalAmt.setBoundLabelLength(80);		
        this.conttotalAmt.setBoundLabelUnderline(true);		
        this.conttotalAmt.setVisible(true);		
        this.conttotalAmt.setForeground(new java.awt.Color(0,0,0));
        // contunitAmt		
        this.contunitAmt.setBoundLabelText(resHelper.getString("contunitAmt.boundLabelText"));		
        this.contunitAmt.setBoundLabelLength(80);		
        this.contunitAmt.setBoundLabelUnderline(true);		
        this.contunitAmt.setVisible(true);		
        this.contunitAmt.setForeground(new java.awt.Color(0,0,0));
        // contrebackCostAmt		
        this.contrebackCostAmt.setBoundLabelText(resHelper.getString("contrebackCostAmt.boundLabelText"));		
        this.contrebackCostAmt.setBoundLabelLength(80);		
        this.contrebackCostAmt.setBoundLabelUnderline(true);		
        this.contrebackCostAmt.setVisible(true);		
        this.contrebackCostAmt.setForeground(new java.awt.Color(0,0,0));
        // contrebackCostPrice		
        this.contrebackCostPrice.setBoundLabelText(resHelper.getString("contrebackCostPrice.boundLabelText"));		
        this.contrebackCostPrice.setBoundLabelLength(80);		
        this.contrebackCostPrice.setBoundLabelUnderline(true);		
        this.contrebackCostPrice.setVisible(true);		
        this.contrebackCostPrice.setForeground(new java.awt.Color(0,0,0));
        // contgrossDuckSalePrice		
        this.contgrossDuckSalePrice.setBoundLabelText(resHelper.getString("contgrossDuckSalePrice.boundLabelText"));		
        this.contgrossDuckSalePrice.setBoundLabelLength(80);		
        this.contgrossDuckSalePrice.setBoundLabelUnderline(true);		
        this.contgrossDuckSalePrice.setVisible(true);		
        this.contgrossDuckSalePrice.setForeground(new java.awt.Color(0,0,0));
        // contunitEatQty		
        this.contunitEatQty.setBoundLabelText(resHelper.getString("contunitEatQty.boundLabelText"));		
        this.contunitEatQty.setBoundLabelLength(80);		
        this.contunitEatQty.setBoundLabelUnderline(true);		
        this.contunitEatQty.setVisible(true);		
        this.contunitEatQty.setForeground(new java.awt.Color(0,0,0));
        // contyieldRate		
        this.contyieldRate.setBoundLabelText(resHelper.getString("contyieldRate.boundLabelText"));		
        this.contyieldRate.setBoundLabelLength(80);		
        this.contyieldRate.setBoundLabelUnderline(true);		
        this.contyieldRate.setVisible(true);		
        this.contyieldRate.setForeground(new java.awt.Color(0,0,0));
        // contchickAmt		
        this.contchickAmt.setBoundLabelText(resHelper.getString("contchickAmt.boundLabelText"));		
        this.contchickAmt.setBoundLabelLength(80);		
        this.contchickAmt.setBoundLabelUnderline(true);		
        this.contchickAmt.setVisible(true);		
        this.contchickAmt.setForeground(new java.awt.Color(0,0,0));
        // contremark		
        this.contremark.setBoundLabelText(resHelper.getString("contremark.boundLabelText"));		
        this.contremark.setBoundLabelLength(80);		
        this.contremark.setBoundLabelUnderline(true);		
        this.contremark.setVisible(true);		
        this.contremark.setForeground(new java.awt.Color(0,0,0));
        // contfarm		
        this.contfarm.setBoundLabelText(resHelper.getString("contfarm.boundLabelText"));		
        this.contfarm.setBoundLabelLength(80);		
        this.contfarm.setBoundLabelUnderline(true);		
        this.contfarm.setVisible(true);		
        this.contfarm.setForeground(new java.awt.Color(0,0,0));
        // contbillStatus		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(80);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);		
        this.contbillStatus.setForeground(new java.awt.Color(0,0,0));
        // chkFivouchered		
        this.chkFivouchered.setHorizontalAlignment(2);		
        this.chkFivouchered.setText(resHelper.getString("chkFivouchered.text"));		
        this.chkFivouchered.setEnabled(false);
        // contchickCostAmt		
        this.contchickCostAmt.setBoundLabelText(resHelper.getString("contchickCostAmt.boundLabelText"));		
        this.contchickCostAmt.setBoundLabelLength(80);		
        this.contchickCostAmt.setBoundLabelUnderline(true);		
        this.contchickCostAmt.setVisible(true);		
        this.contchickCostAmt.setForeground(new java.awt.Color(0,0,0));
        // contdrugCostAmt		
        this.contdrugCostAmt.setBoundLabelText(resHelper.getString("contdrugCostAmt.boundLabelText"));		
        this.contdrugCostAmt.setBoundLabelLength(80);		
        this.contdrugCostAmt.setBoundLabelUnderline(true);		
        this.contdrugCostAmt.setVisible(true);		
        this.contdrugCostAmt.setForeground(new java.awt.Color(0,0,0));
        // contfeedCostAmt		
        this.contfeedCostAmt.setBoundLabelText(resHelper.getString("contfeedCostAmt.boundLabelText"));		
        this.contfeedCostAmt.setBoundLabelLength(80);		
        this.contfeedCostAmt.setBoundLabelUnderline(true);		
        this.contfeedCostAmt.setVisible(true);		
        this.contfeedCostAmt.setForeground(new java.awt.Color(0,0,0));
        // contfeedBaseQty		
        this.contfeedBaseQty.setBoundLabelText(resHelper.getString("contfeedBaseQty.boundLabelText"));		
        this.contfeedBaseQty.setBoundLabelLength(80);		
        this.contfeedBaseQty.setBoundLabelUnderline(true);		
        this.contfeedBaseQty.setVisible(true);		
        this.contfeedBaseQty.setForeground(new java.awt.Color(0,0,0));
        // contchickQty		
        this.contchickQty.setBoundLabelText(resHelper.getString("contchickQty.boundLabelText"));		
        this.contchickQty.setBoundLabelLength(80);		
        this.contchickQty.setBoundLabelUnderline(true);		
        this.contchickQty.setVisible(true);		
        this.contchickQty.setForeground(new java.awt.Color(0,0,0));
        // conttotalAmt_1		
        this.conttotalAmt_1.setBoundLabelText(resHelper.getString("conttotalAmt_1.boundLabelText"));		
        this.conttotalAmt_1.setBoundLabelLength(80);		
        this.conttotalAmt_1.setBoundLabelUnderline(true);		
        this.conttotalAmt_1.setVisible(true);
        // contfeedToMeat_1		
        this.contfeedToMeat_1.setBoundLabelText(resHelper.getString("contfeedToMeat_1.boundLabelText"));		
        this.contfeedToMeat_1.setBoundLabelLength(80);		
        this.contfeedToMeat_1.setBoundLabelUnderline(true);		
        this.contfeedToMeat_1.setVisible(true);
        // contfeedToMeat_2		
        this.contfeedToMeat_2.setBoundLabelText(resHelper.getString("contfeedToMeat_2.boundLabelText"));		
        this.contfeedToMeat_2.setBoundLabelLength(80);		
        this.contfeedToMeat_2.setBoundLabelUnderline(true);		
        this.contfeedToMeat_2.setVisible(true);
        // contunitEatQty_1		
        this.contunitEatQty_1.setBoundLabelText(resHelper.getString("contunitEatQty_1.boundLabelText"));		
        this.contunitEatQty_1.setBoundLabelLength(80);		
        this.contunitEatQty_1.setBoundLabelUnderline(true);		
        this.contunitEatQty_1.setVisible(true);
        // continDate		
        this.continDate.setBoundLabelText(resHelper.getString("continDate.boundLabelText"));		
        this.continDate.setBoundLabelLength(80);		
        this.continDate.setBoundLabelUnderline(true);		
        this.continDate.setVisible(true);
        // contsendCars		
        this.contsendCars.setBoundLabelText(resHelper.getString("contsendCars.boundLabelText"));		
        this.contsendCars.setBoundLabelLength(80);		
        this.contsendCars.setBoundLabelUnderline(true);		
        this.contsendCars.setVisible(true);
        // contbatchContract		
        this.contbatchContract.setBoundLabelText(resHelper.getString("contbatchContract.boundLabelText"));		
        this.contbatchContract.setBoundLabelLength(80);		
        this.contbatchContract.setBoundLabelUnderline(true);		
        this.contbatchContract.setVisible(true);
        // contseriousContract		
        this.contseriousContract.setBoundLabelText(resHelper.getString("contseriousContract.boundLabelText"));		
        this.contseriousContract.setBoundLabelLength(80);		
        this.contseriousContract.setBoundLabelUnderline(true);		
        this.contseriousContract.setVisible(true);
        // contcontractType		
        this.contcontractType.setBoundLabelText(resHelper.getString("contcontractType.boundLabelText"));		
        this.contcontractType.setBoundLabelLength(80);		
        this.contcontractType.setBoundLabelUnderline(true);		
        this.contcontractType.setVisible(true);
        // prmtCreator		
        this.prmtCreator.setEnabled(false);		
        this.prmtCreator.setRequired(false);		
        this.prmtCreator.setForeground(new java.awt.Color(0,0,0));
        // kDDateCreateTime		
        this.kDDateCreateTime.setTimeEnabled(true);		
        this.kDDateCreateTime.setEnabled(false);		
        this.kDDateCreateTime.setRequired(false);		
        this.kDDateCreateTime.setForeground(new java.awt.Color(0,0,0));
        // prmtLastUpdateUser		
        this.prmtLastUpdateUser.setEnabled(false);		
        this.prmtLastUpdateUser.setVisible(false);		
        this.prmtLastUpdateUser.setRequired(false);		
        this.prmtLastUpdateUser.setForeground(new java.awt.Color(0,0,0));
        // kDDateLastUpdateTime		
        this.kDDateLastUpdateTime.setTimeEnabled(true);		
        this.kDDateLastUpdateTime.setEnabled(false);		
        this.kDDateLastUpdateTime.setVisible(false);		
        this.kDDateLastUpdateTime.setRequired(false);		
        this.kDDateLastUpdateTime.setForeground(new java.awt.Color(0,0,0));
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setEnabled(true);		
        this.txtNumber.setHorizontalAlignment(2);		
        this.txtNumber.setRequired(false);		
        this.txtNumber.setForeground(new java.awt.Color(0,0,0));
        // pkBizDate		
        this.pkBizDate.setEnabled(true);		
        this.pkBizDate.setRequired(false);		
        this.pkBizDate.setForeground(new java.awt.Color(0,0,0));
        // txtDescription		
        this.txtDescription.setMaxLength(80);		
        this.txtDescription.setEnabled(true);		
        this.txtDescription.setHorizontalAlignment(2);		
        this.txtDescription.setRequired(false);		
        this.txtDescription.setForeground(new java.awt.Color(0,0,0));
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);		
        this.prmtAuditor.setRequired(false);		
        this.prmtAuditor.setForeground(new java.awt.Color(0,0,0));
        // baseTab		
        this.baseTab.setVisible(true);
        // otherTab		
        this.otherTab.setVisible(true);
        // kDPanel2
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"billType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"billNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"billDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"weightType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"quantity\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"weight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{billType}</t:Cell><t:Cell>$Resource{billNum}</t:Cell><t:Cell>$Resource{billDate}</t:Cell><t:Cell>$Resource{weightType}</t:Cell><t:Cell>$Resource{quantity}</t:Cell><t:Cell>$Resource{weight}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));

                this.kdtEntrys.putBindContents("editData",new String[] {"id","billType","billNum","billDate","weightType","quantity","weight"});


        this.kdtEntrys.checkParsed();
        KDTextField kdtEntrys_billType_TextField = new KDTextField();
        kdtEntrys_billType_TextField.setName("kdtEntrys_billType_TextField");
        kdtEntrys_billType_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_billType_CellEditor = new KDTDefaultCellEditor(kdtEntrys_billType_TextField);
        this.kdtEntrys.getColumn("billType").setEditor(kdtEntrys_billType_CellEditor);
        KDTextField kdtEntrys_billNum_TextField = new KDTextField();
        kdtEntrys_billNum_TextField.setName("kdtEntrys_billNum_TextField");
        kdtEntrys_billNum_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_billNum_CellEditor = new KDTDefaultCellEditor(kdtEntrys_billNum_TextField);
        this.kdtEntrys.getColumn("billNum").setEditor(kdtEntrys_billNum_CellEditor);
        KDDatePicker kdtEntrys_billDate_DatePicker = new KDDatePicker();
        kdtEntrys_billDate_DatePicker.setName("kdtEntrys_billDate_DatePicker");
        kdtEntrys_billDate_DatePicker.setVisible(true);
        kdtEntrys_billDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_billDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_billDate_DatePicker);
        this.kdtEntrys.getColumn("billDate").setEditor(kdtEntrys_billDate_CellEditor);
        KDComboBox kdtEntrys_weightType_ComboBox = new KDComboBox();
        kdtEntrys_weightType_ComboBox.setName("kdtEntrys_weightType_ComboBox");
        kdtEntrys_weightType_ComboBox.setVisible(true);
        kdtEntrys_weightType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.taihe.weight.CarcassType").toArray());
        KDTDefaultCellEditor kdtEntrys_weightType_CellEditor = new KDTDefaultCellEditor(kdtEntrys_weightType_ComboBox);
        this.kdtEntrys.getColumn("weightType").setEditor(kdtEntrys_weightType_CellEditor);
        KDFormattedTextField kdtEntrys_quantity_TextField = new KDFormattedTextField();
        kdtEntrys_quantity_TextField.setName("kdtEntrys_quantity_TextField");
        kdtEntrys_quantity_TextField.setVisible(true);
        kdtEntrys_quantity_TextField.setEditable(true);
        kdtEntrys_quantity_TextField.setHorizontalAlignment(2);
        kdtEntrys_quantity_TextField.setDataType(1);
        	kdtEntrys_quantity_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_quantity_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_quantity_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_quantity_CellEditor = new KDTDefaultCellEditor(kdtEntrys_quantity_TextField);
        this.kdtEntrys.getColumn("quantity").setEditor(kdtEntrys_quantity_CellEditor);
        KDFormattedTextField kdtEntrys_weight_TextField = new KDFormattedTextField();
        kdtEntrys_weight_TextField.setName("kdtEntrys_weight_TextField");
        kdtEntrys_weight_TextField.setVisible(true);
        kdtEntrys_weight_TextField.setEditable(true);
        kdtEntrys_weight_TextField.setHorizontalAlignment(2);
        kdtEntrys_weight_TextField.setDataType(1);
        	kdtEntrys_weight_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_weight_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_weight_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_weight_CellEditor = new KDTDefaultCellEditor(kdtEntrys_weight_TextField);
        this.kdtEntrys.getColumn("weight").setEditor(kdtEntrys_weight_CellEditor);
        // kdtOtherEntrys
		String kdtOtherEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"wgtType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"quantity\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"weight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"price\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"disRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"wgtAfterDis\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{wgtType}</t:Cell><t:Cell>$Resource{quantity}</t:Cell><t:Cell>$Resource{weight}</t:Cell><t:Cell>$Resource{price}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{disRate}</t:Cell><t:Cell>$Resource{wgtAfterDis}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtOtherEntrys.setFormatXml(resHelper.translateString("kdtOtherEntrys",kdtOtherEntrysStrXML));

                this.kdtOtherEntrys.putBindContents("editData",new String[] {"id","wgtType","quantity","weight","price","amount","disRate","wgtAfterDis"});


        this.kdtOtherEntrys.checkParsed();
        KDComboBox kdtOtherEntrys_wgtType_ComboBox = new KDComboBox();
        kdtOtherEntrys_wgtType_ComboBox.setName("kdtOtherEntrys_wgtType_ComboBox");
        kdtOtherEntrys_wgtType_ComboBox.setVisible(true);
        kdtOtherEntrys_wgtType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.taihe.weight.CarcassType").toArray());
        KDTDefaultCellEditor kdtOtherEntrys_wgtType_CellEditor = new KDTDefaultCellEditor(kdtOtherEntrys_wgtType_ComboBox);
        this.kdtOtherEntrys.getColumn("wgtType").setEditor(kdtOtherEntrys_wgtType_CellEditor);
        KDFormattedTextField kdtOtherEntrys_quantity_TextField = new KDFormattedTextField();
        kdtOtherEntrys_quantity_TextField.setName("kdtOtherEntrys_quantity_TextField");
        kdtOtherEntrys_quantity_TextField.setVisible(true);
        kdtOtherEntrys_quantity_TextField.setEditable(true);
        kdtOtherEntrys_quantity_TextField.setHorizontalAlignment(2);
        kdtOtherEntrys_quantity_TextField.setDataType(0);
        KDTDefaultCellEditor kdtOtherEntrys_quantity_CellEditor = new KDTDefaultCellEditor(kdtOtherEntrys_quantity_TextField);
        this.kdtOtherEntrys.getColumn("quantity").setEditor(kdtOtherEntrys_quantity_CellEditor);
        KDFormattedTextField kdtOtherEntrys_weight_TextField = new KDFormattedTextField();
        kdtOtherEntrys_weight_TextField.setName("kdtOtherEntrys_weight_TextField");
        kdtOtherEntrys_weight_TextField.setVisible(true);
        kdtOtherEntrys_weight_TextField.setEditable(true);
        kdtOtherEntrys_weight_TextField.setHorizontalAlignment(2);
        kdtOtherEntrys_weight_TextField.setDataType(1);
        	kdtOtherEntrys_weight_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtOtherEntrys_weight_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtOtherEntrys_weight_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtOtherEntrys_weight_CellEditor = new KDTDefaultCellEditor(kdtOtherEntrys_weight_TextField);
        this.kdtOtherEntrys.getColumn("weight").setEditor(kdtOtherEntrys_weight_CellEditor);
        KDFormattedTextField kdtOtherEntrys_price_TextField = new KDFormattedTextField();
        kdtOtherEntrys_price_TextField.setName("kdtOtherEntrys_price_TextField");
        kdtOtherEntrys_price_TextField.setVisible(true);
        kdtOtherEntrys_price_TextField.setEditable(true);
        kdtOtherEntrys_price_TextField.setHorizontalAlignment(2);
        kdtOtherEntrys_price_TextField.setDataType(1);
        	kdtOtherEntrys_price_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtOtherEntrys_price_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtOtherEntrys_price_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtOtherEntrys_price_CellEditor = new KDTDefaultCellEditor(kdtOtherEntrys_price_TextField);
        this.kdtOtherEntrys.getColumn("price").setEditor(kdtOtherEntrys_price_CellEditor);
        KDFormattedTextField kdtOtherEntrys_amount_TextField = new KDFormattedTextField();
        kdtOtherEntrys_amount_TextField.setName("kdtOtherEntrys_amount_TextField");
        kdtOtherEntrys_amount_TextField.setVisible(true);
        kdtOtherEntrys_amount_TextField.setEditable(true);
        kdtOtherEntrys_amount_TextField.setHorizontalAlignment(2);
        kdtOtherEntrys_amount_TextField.setDataType(1);
        	kdtOtherEntrys_amount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtOtherEntrys_amount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtOtherEntrys_amount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtOtherEntrys_amount_CellEditor = new KDTDefaultCellEditor(kdtOtherEntrys_amount_TextField);
        this.kdtOtherEntrys.getColumn("amount").setEditor(kdtOtherEntrys_amount_CellEditor);
        KDFormattedTextField kdtOtherEntrys_disRate_TextField = new KDFormattedTextField();
        kdtOtherEntrys_disRate_TextField.setName("kdtOtherEntrys_disRate_TextField");
        kdtOtherEntrys_disRate_TextField.setVisible(true);
        kdtOtherEntrys_disRate_TextField.setEditable(true);
        kdtOtherEntrys_disRate_TextField.setHorizontalAlignment(2);
        kdtOtherEntrys_disRate_TextField.setDataType(1);
        	kdtOtherEntrys_disRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtOtherEntrys_disRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtOtherEntrys_disRate_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtOtherEntrys_disRate_CellEditor = new KDTDefaultCellEditor(kdtOtherEntrys_disRate_TextField);
        this.kdtOtherEntrys.getColumn("disRate").setEditor(kdtOtherEntrys_disRate_CellEditor);
        KDFormattedTextField kdtOtherEntrys_wgtAfterDis_TextField = new KDFormattedTextField();
        kdtOtherEntrys_wgtAfterDis_TextField.setName("kdtOtherEntrys_wgtAfterDis_TextField");
        kdtOtherEntrys_wgtAfterDis_TextField.setVisible(true);
        kdtOtherEntrys_wgtAfterDis_TextField.setEditable(true);
        kdtOtherEntrys_wgtAfterDis_TextField.setHorizontalAlignment(2);
        kdtOtherEntrys_wgtAfterDis_TextField.setDataType(1);
        	kdtOtherEntrys_wgtAfterDis_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtOtherEntrys_wgtAfterDis_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtOtherEntrys_wgtAfterDis_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtOtherEntrys_wgtAfterDis_CellEditor = new KDTDefaultCellEditor(kdtOtherEntrys_wgtAfterDis_TextField);
        this.kdtOtherEntrys.getColumn("wgtAfterDis").setEditor(kdtOtherEntrys_wgtAfterDis_CellEditor);
        // kdtSubsidy
		String kdtSubsidyStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"billNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"cusComplainType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"avgWgt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{billNum}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{cusComplainType}</t:Cell><t:Cell>$Resource{avgWgt}</t:Cell><t:Cell>$Resource{remark}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtSubsidy.setFormatXml(resHelper.translateString("kdtSubsidy",kdtSubsidyStrXML));

                this.kdtSubsidy.putBindContents("editData",new String[] {"seq","billNum","amount","cusComplainType","avgWgt","remark"});


        this.kdtSubsidy.checkParsed();
        KDFormattedTextField kdtSubsidy_seq_TextField = new KDFormattedTextField();
        kdtSubsidy_seq_TextField.setName("kdtSubsidy_seq_TextField");
        kdtSubsidy_seq_TextField.setVisible(true);
        kdtSubsidy_seq_TextField.setEditable(true);
        kdtSubsidy_seq_TextField.setHorizontalAlignment(2);
        kdtSubsidy_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtSubsidy_seq_CellEditor = new KDTDefaultCellEditor(kdtSubsidy_seq_TextField);
        this.kdtSubsidy.getColumn("seq").setEditor(kdtSubsidy_seq_CellEditor);
        KDTextField kdtSubsidy_billNum_TextField = new KDTextField();
        kdtSubsidy_billNum_TextField.setName("kdtSubsidy_billNum_TextField");
        kdtSubsidy_billNum_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtSubsidy_billNum_CellEditor = new KDTDefaultCellEditor(kdtSubsidy_billNum_TextField);
        this.kdtSubsidy.getColumn("billNum").setEditor(kdtSubsidy_billNum_CellEditor);
        KDFormattedTextField kdtSubsidy_amount_TextField = new KDFormattedTextField();
        kdtSubsidy_amount_TextField.setName("kdtSubsidy_amount_TextField");
        kdtSubsidy_amount_TextField.setVisible(true);
        kdtSubsidy_amount_TextField.setEditable(true);
        kdtSubsidy_amount_TextField.setHorizontalAlignment(2);
        kdtSubsidy_amount_TextField.setDataType(1);
        	kdtSubsidy_amount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtSubsidy_amount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtSubsidy_amount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtSubsidy_amount_CellEditor = new KDTDefaultCellEditor(kdtSubsidy_amount_TextField);
        this.kdtSubsidy.getColumn("amount").setEditor(kdtSubsidy_amount_CellEditor);
        KDTextField kdtSubsidy_cusComplainType_TextField = new KDTextField();
        kdtSubsidy_cusComplainType_TextField.setName("kdtSubsidy_cusComplainType_TextField");
        kdtSubsidy_cusComplainType_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtSubsidy_cusComplainType_CellEditor = new KDTDefaultCellEditor(kdtSubsidy_cusComplainType_TextField);
        this.kdtSubsidy.getColumn("cusComplainType").setEditor(kdtSubsidy_cusComplainType_CellEditor);
        KDFormattedTextField kdtSubsidy_avgWgt_TextField = new KDFormattedTextField();
        kdtSubsidy_avgWgt_TextField.setName("kdtSubsidy_avgWgt_TextField");
        kdtSubsidy_avgWgt_TextField.setVisible(true);
        kdtSubsidy_avgWgt_TextField.setEditable(true);
        kdtSubsidy_avgWgt_TextField.setHorizontalAlignment(2);
        kdtSubsidy_avgWgt_TextField.setDataType(1);
        	kdtSubsidy_avgWgt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtSubsidy_avgWgt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtSubsidy_avgWgt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtSubsidy_avgWgt_CellEditor = new KDTDefaultCellEditor(kdtSubsidy_avgWgt_TextField);
        this.kdtSubsidy.getColumn("avgWgt").setEditor(kdtSubsidy_avgWgt_CellEditor);
        KDTextField kdtSubsidy_remark_TextField = new KDTextField();
        kdtSubsidy_remark_TextField.setName("kdtSubsidy_remark_TextField");
        kdtSubsidy_remark_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtSubsidy_remark_CellEditor = new KDTDefaultCellEditor(kdtSubsidy_remark_TextField);
        this.kdtSubsidy.getColumn("remark").setEditor(kdtSubsidy_remark_CellEditor);
        // prmtaccountUnit		
        this.prmtaccountUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtaccountUnit.setEditable(true);		
        this.prmtaccountUnit.setDisplayFormat("$name$");		
        this.prmtaccountUnit.setEditFormat("$number$");		
        this.prmtaccountUnit.setCommitFormat("$number$");		
        this.prmtaccountUnit.setRequired(false);
        // prmtdepartment		
        this.prmtdepartment.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtdepartment.setEditable(true);		
        this.prmtdepartment.setDisplayFormat("$name$");		
        this.prmtdepartment.setEditFormat("$number$");		
        this.prmtdepartment.setCommitFormat("$number$");		
        this.prmtdepartment.setRequired(false);
        // prmtfarmer		
        this.prmtfarmer.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtfarmer.setEditable(true);		
        this.prmtfarmer.setDisplayFormat("$name$");		
        this.prmtfarmer.setEditFormat("$number$");		
        this.prmtfarmer.setCommitFormat("$number$");		
        this.prmtfarmer.setRequired(false);
        // txtpolicy		
        this.txtpolicy.setHorizontalAlignment(2);		
        this.txtpolicy.setMaxLength(100);		
        this.txtpolicy.setRequired(false);
        // prmtoperator		
        this.prmtoperator.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtoperator.setEditable(true);		
        this.prmtoperator.setDisplayFormat("$name$");		
        this.prmtoperator.setEditFormat("$number$");		
        this.prmtoperator.setCommitFormat("$number$");		
        this.prmtoperator.setRequired(false);
        // txtslaughterPlace		
        this.txtslaughterPlace.setHorizontalAlignment(2);		
        this.txtslaughterPlace.setMaxLength(100);		
        this.txtslaughterPlace.setRequired(false);
        // txtfeedToMeat		
        this.txtfeedToMeat.setHorizontalAlignment(2);		
        this.txtfeedToMeat.setDataType(1);		
        this.txtfeedToMeat.setSupportedEmpty(true);		
        this.txtfeedToMeat.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfeedToMeat.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfeedToMeat.setPrecision(10);		
        this.txtfeedToMeat.setRequired(false);
        // txtsurvivalRate		
        this.txtsurvivalRate.setHorizontalAlignment(2);		
        this.txtsurvivalRate.setDataType(1);		
        this.txtsurvivalRate.setSupportedEmpty(true);		
        this.txtsurvivalRate.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsurvivalRate.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsurvivalRate.setPrecision(10);		
        this.txtsurvivalRate.setRequired(false);
        // txtmedicineUsage		
        this.txtmedicineUsage.setHorizontalAlignment(2);		
        this.txtmedicineUsage.setDataType(1);		
        this.txtmedicineUsage.setSupportedEmpty(true);		
        this.txtmedicineUsage.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmedicineUsage.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmedicineUsage.setPrecision(10);		
        this.txtmedicineUsage.setRequired(false);
        // txtdisinfectant		
        this.txtdisinfectant.setHorizontalAlignment(2);		
        this.txtdisinfectant.setDataType(1);		
        this.txtdisinfectant.setSupportedEmpty(true);		
        this.txtdisinfectant.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdisinfectant.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdisinfectant.setPrecision(10);		
        this.txtdisinfectant.setRequired(false);
        // txtfeedingAmt		
        this.txtfeedingAmt.setHorizontalAlignment(2);		
        this.txtfeedingAmt.setDataType(1);		
        this.txtfeedingAmt.setSupportedEmpty(true);		
        this.txtfeedingAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfeedingAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfeedingAmt.setPrecision(2);		
        this.txtfeedingAmt.setRequired(false);
        // txtmedicineAmt		
        this.txtmedicineAmt.setHorizontalAlignment(2);		
        this.txtmedicineAmt.setDataType(1);		
        this.txtmedicineAmt.setSupportedEmpty(true);		
        this.txtmedicineAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmedicineAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmedicineAmt.setPrecision(2);		
        this.txtmedicineAmt.setRequired(false);
        // txtotherAmt		
        this.txtotherAmt.setHorizontalAlignment(2);		
        this.txtotherAmt.setDataType(1);		
        this.txtotherAmt.setSupportedEmpty(true);		
        this.txtotherAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtotherAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtotherAmt.setPrecision(2);		
        this.txtotherAmt.setRequired(false);
        // txtunitWeight		
        this.txtunitWeight.setHorizontalAlignment(2);		
        this.txtunitWeight.setDataType(1);		
        this.txtunitWeight.setSupportedEmpty(true);		
        this.txtunitWeight.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtunitWeight.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtunitWeight.setPrecision(4);		
        this.txtunitWeight.setRequired(false);
        // txtdayAge		
        this.txtdayAge.setHorizontalAlignment(2);		
        this.txtdayAge.setDataType(0);		
        this.txtdayAge.setSupportedEmpty(true);		
        this.txtdayAge.setRequired(false);
        // txttotalAmt		
        this.txttotalAmt.setHorizontalAlignment(2);		
        this.txttotalAmt.setDataType(1);		
        this.txttotalAmt.setSupportedEmpty(true);		
        this.txttotalAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttotalAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttotalAmt.setPrecision(2);		
        this.txttotalAmt.setRequired(false);
        // txtunitAmt		
        this.txtunitAmt.setHorizontalAlignment(2);		
        this.txtunitAmt.setDataType(1);		
        this.txtunitAmt.setSupportedEmpty(true);		
        this.txtunitAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtunitAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtunitAmt.setPrecision(2);		
        this.txtunitAmt.setRequired(false);
        // txtrebackCostAmt		
        this.txtrebackCostAmt.setHorizontalAlignment(2);		
        this.txtrebackCostAmt.setDataType(1);		
        this.txtrebackCostAmt.setSupportedEmpty(true);		
        this.txtrebackCostAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtrebackCostAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtrebackCostAmt.setPrecision(2);		
        this.txtrebackCostAmt.setRequired(false);
        // txtrebackCostPrice		
        this.txtrebackCostPrice.setHorizontalAlignment(2);		
        this.txtrebackCostPrice.setDataType(1);		
        this.txtrebackCostPrice.setSupportedEmpty(true);		
        this.txtrebackCostPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtrebackCostPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtrebackCostPrice.setPrecision(6);		
        this.txtrebackCostPrice.setRequired(false);
        // txtgrossDuckSalePrice		
        this.txtgrossDuckSalePrice.setHorizontalAlignment(2);		
        this.txtgrossDuckSalePrice.setDataType(1);		
        this.txtgrossDuckSalePrice.setSupportedEmpty(true);		
        this.txtgrossDuckSalePrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtgrossDuckSalePrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtgrossDuckSalePrice.setPrecision(6);		
        this.txtgrossDuckSalePrice.setRequired(false);
        // txtunitEatQty		
        this.txtunitEatQty.setHorizontalAlignment(2);		
        this.txtunitEatQty.setDataType(1);		
        this.txtunitEatQty.setSupportedEmpty(true);		
        this.txtunitEatQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtunitEatQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtunitEatQty.setPrecision(4);		
        this.txtunitEatQty.setRequired(false);
        // txtyieldRate		
        this.txtyieldRate.setHorizontalAlignment(2);		
        this.txtyieldRate.setDataType(1);		
        this.txtyieldRate.setSupportedEmpty(true);		
        this.txtyieldRate.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyieldRate.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyieldRate.setPrecision(10);		
        this.txtyieldRate.setRequired(false);
        // txtchickAmt		
        this.txtchickAmt.setHorizontalAlignment(2);		
        this.txtchickAmt.setDataType(1);		
        this.txtchickAmt.setSupportedEmpty(true);		
        this.txtchickAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchickAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchickAmt.setPrecision(2);		
        this.txtchickAmt.setRequired(false);
        // txtremark		
        this.txtremark.setHorizontalAlignment(2);		
        this.txtremark.setMaxLength(100);		
        this.txtremark.setRequired(false);
        // txtfarm		
        this.txtfarm.setHorizontalAlignment(2);		
        this.txtfarm.setMaxLength(100);		
        this.txtfarm.setRequired(false);
        // billStatus		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.settlebill.billStatus").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // txtchickCostAmt		
        this.txtchickCostAmt.setHorizontalAlignment(2);		
        this.txtchickCostAmt.setDataType(1);		
        this.txtchickCostAmt.setSupportedEmpty(true);		
        this.txtchickCostAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchickCostAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchickCostAmt.setPrecision(2);		
        this.txtchickCostAmt.setRequired(false);
        // txtdrugCostAmt		
        this.txtdrugCostAmt.setHorizontalAlignment(2);		
        this.txtdrugCostAmt.setDataType(1);		
        this.txtdrugCostAmt.setSupportedEmpty(true);		
        this.txtdrugCostAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdrugCostAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdrugCostAmt.setPrecision(2);		
        this.txtdrugCostAmt.setRequired(false);
        // txtfeedCostAmt		
        this.txtfeedCostAmt.setHorizontalAlignment(2);		
        this.txtfeedCostAmt.setDataType(1);		
        this.txtfeedCostAmt.setSupportedEmpty(true);		
        this.txtfeedCostAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfeedCostAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfeedCostAmt.setPrecision(2);		
        this.txtfeedCostAmt.setRequired(false);
        // txtfeedBaseQty		
        this.txtfeedBaseQty.setHorizontalAlignment(2);		
        this.txtfeedBaseQty.setDataType(1);		
        this.txtfeedBaseQty.setSupportedEmpty(true);		
        this.txtfeedBaseQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfeedBaseQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfeedBaseQty.setPrecision(4);		
        this.txtfeedBaseQty.setRequired(false);
        // txtchickQty		
        this.txtchickQty.setHorizontalAlignment(2);		
        this.txtchickQty.setDataType(1);		
        this.txtchickQty.setSupportedEmpty(true);		
        this.txtchickQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchickQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchickQty.setPrecision(4);		
        this.txtchickQty.setRequired(false);
        // txttotalAmt_1		
        this.txttotalAmt_1.setHorizontalAlignment(2);		
        this.txttotalAmt_1.setDataType(1);		
        this.txttotalAmt_1.setSupportedEmpty(true);		
        this.txttotalAmt_1.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttotalAmt_1.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttotalAmt_1.setPrecision(10);		
        this.txttotalAmt_1.setRequired(false);
        // txtfeedToMeat_1		
        this.txtfeedToMeat_1.setHorizontalAlignment(2);		
        this.txtfeedToMeat_1.setDataType(1);		
        this.txtfeedToMeat_1.setSupportedEmpty(true);		
        this.txtfeedToMeat_1.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfeedToMeat_1.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfeedToMeat_1.setPrecision(10);		
        this.txtfeedToMeat_1.setRequired(false);
        // txtfeedToMeat_2		
        this.txtfeedToMeat_2.setHorizontalAlignment(2);		
        this.txtfeedToMeat_2.setDataType(1);		
        this.txtfeedToMeat_2.setSupportedEmpty(true);		
        this.txtfeedToMeat_2.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfeedToMeat_2.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfeedToMeat_2.setPrecision(10);		
        this.txtfeedToMeat_2.setRequired(false);
        // txtunitEatQty_1		
        this.txtunitEatQty_1.setHorizontalAlignment(2);		
        this.txtunitEatQty_1.setDataType(1);		
        this.txtunitEatQty_1.setSupportedEmpty(true);		
        this.txtunitEatQty_1.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtunitEatQty_1.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtunitEatQty_1.setPrecision(10);		
        this.txtunitEatQty_1.setRequired(false);
        // pkinDate		
        this.pkinDate.setRequired(false);
        // prmtsendCars		
        this.prmtsendCars.setQueryInfo("com.kingdee.eas.custom.taihe.weight.app.CarSendBillQuery");		
        this.prmtsendCars.setEditable(true);		
        this.prmtsendCars.setDisplayFormat("$number$");		
        this.prmtsendCars.setEditFormat("$number$");		
        this.prmtsendCars.setCommitFormat("$number$");		
        this.prmtsendCars.setRequired(false);
        // prmtbatchContract		
        this.prmtbatchContract.setQueryInfo("com.kingdee.eas.custom.taihe.contract.app.BatchContractQuery");		
        this.prmtbatchContract.setEditable(true);		
        this.prmtbatchContract.setDisplayFormat("$number$");		
        this.prmtbatchContract.setEditFormat("$number$");		
        this.prmtbatchContract.setCommitFormat("$number$");		
        this.prmtbatchContract.setRequired(false);
        // prmtseriousContract		
        this.prmtseriousContract.setQueryInfo("com.kingdee.eas.custom.taihe.contract.app.SuccessiveContractQuery");		
        this.prmtseriousContract.setEditable(true);		
        this.prmtseriousContract.setDisplayFormat("$number$");		
        this.prmtseriousContract.setEditFormat("$number$");		
        this.prmtseriousContract.setCommitFormat("$number$");		
        this.prmtseriousContract.setRequired(false);
        // prmtcontractType		
        this.prmtcontractType.setQueryInfo("com.kingdee.eas.custom.signwasthetable.app.ContractTypeQuery");		
        this.prmtcontractType.setEditable(true);		
        this.prmtcontractType.setDisplayFormat("$name$");		
        this.prmtcontractType.setEditFormat("$number$");		
        this.prmtcontractType.setCommitFormat("$number$");		
        this.prmtcontractType.setRequired(false);
        // btnGetCostAmt
        this.btnGetCostAmt.setAction((IItemAction)ActionProxyFactory.getProxy(actionGetCostAmt, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnGetCostAmt.setText(resHelper.getString("btnGetCostAmt.text"));
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        // btnExeSet
        this.btnExeSet.setAction((IItemAction)ActionProxyFactory.getProxy(actionExeSet, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnExeSet.setText(resHelper.getString("btnExeSet.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {chkFivouchered,txttotalAmt_1,txtfeedToMeat_1,txtfeedToMeat_2,txtunitEatQty_1,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,prmtaccountUnit,prmtdepartment,prmtfarmer,txtpolicy,prmtoperator,txtslaughterPlace,txtfeedToMeat,txtsurvivalRate,txtmedicineUsage,txtdisinfectant,txtchickAmt,txtfeedingAmt,txtmedicineAmt,txtotherAmt,txtunitWeight,txtdayAge,txttotalAmt,txtunitAmt,txtrebackCostAmt,txtrebackCostPrice,txtgrossDuckSalePrice,txtunitEatQty,txtyieldRate,txtremark,txtfarm,billStatus,txtchickCostAmt,txtdrugCostAmt,txtfeedCostAmt,txtfeedBaseQty,txtchickQty,pkinDate,prmtsendCars,prmtbatchContract,prmtseriousContract,prmtcontractType,kdtOtherEntrys,kdtEntrys,kdtSubsidy}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 701));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1013, 701));
        contCreator.setBounds(new Rectangle(10, 634, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(10, 634, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(341, 634, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(341, 634, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(672, 634, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(672, 634, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateTime.setBounds(new Rectangle(341, 658, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(341, 658, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contNumber.setBounds(new Rectangle(381, 10, 250, 19));
        this.add(contNumber, new KDLayout.Constraints(381, 10, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(753, 58, 250, 19));
        this.add(contBizDate, new KDLayout.Constraints(753, 58, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contDescription.setBounds(new Rectangle(753, 322, 250, 19));
        this.add(contDescription, new KDLayout.Constraints(753, 322, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(10, 658, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(10, 658, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        paneBIZLayerControl17.setBounds(new Rectangle(10, 370, 993, 242));
        this.add(paneBIZLayerControl17, new KDLayout.Constraints(10, 370, 993, 242, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contaccountUnit.setBounds(new Rectangle(10, 10, 250, 19));
        this.add(contaccountUnit, new KDLayout.Constraints(10, 10, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdepartment.setBounds(new Rectangle(381, 82, 250, 19));
        this.add(contdepartment, new KDLayout.Constraints(381, 82, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmer.setBounds(new Rectangle(753, 106, 250, 19));
        this.add(contfarmer, new KDLayout.Constraints(753, 106, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contpolicy.setBounds(new Rectangle(381, 226, 250, 19));
        this.add(contpolicy, new KDLayout.Constraints(381, 226, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoperator.setBounds(new Rectangle(10, 82, 250, 19));
        this.add(contoperator, new KDLayout.Constraints(10, 82, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contslaughterPlace.setBounds(new Rectangle(753, 82, 250, 19));
        this.add(contslaughterPlace, new KDLayout.Constraints(753, 82, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfeedToMeat.setBounds(new Rectangle(753, 226, 250, 19));
        this.add(contfeedToMeat, new KDLayout.Constraints(753, 226, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contsurvivalRate.setBounds(new Rectangle(753, 250, 250, 19));
        this.add(contsurvivalRate, new KDLayout.Constraints(753, 250, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contmedicineUsage.setBounds(new Rectangle(753, 154, 250, 19));
        this.add(contmedicineUsage, new KDLayout.Constraints(753, 154, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contdisinfectant.setBounds(new Rectangle(381, 322, 250, 19));
        this.add(contdisinfectant, new KDLayout.Constraints(381, 322, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfeedingAmt.setBounds(new Rectangle(753, 178, 250, 19));
        this.add(contfeedingAmt, new KDLayout.Constraints(753, 178, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contmedicineAmt.setBounds(new Rectangle(381, 106, 250, 19));
        this.add(contmedicineAmt, new KDLayout.Constraints(381, 106, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contotherAmt.setBounds(new Rectangle(753, 298, 250, 19));
        this.add(contotherAmt, new KDLayout.Constraints(753, 298, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contunitWeight.setBounds(new Rectangle(753, 130, 250, 19));
        this.add(contunitWeight, new KDLayout.Constraints(753, 130, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contdayAge.setBounds(new Rectangle(381, 178, 250, 19));
        this.add(contdayAge, new KDLayout.Constraints(381, 178, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttotalAmt.setBounds(new Rectangle(381, 202, 250, 19));
        this.add(conttotalAmt, new KDLayout.Constraints(381, 202, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contunitAmt.setBounds(new Rectangle(10, 106, 250, 19));
        this.add(contunitAmt, new KDLayout.Constraints(10, 106, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contrebackCostAmt.setBounds(new Rectangle(10, 202, 250, 19));
        this.add(contrebackCostAmt, new KDLayout.Constraints(10, 202, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contrebackCostPrice.setBounds(new Rectangle(381, 298, 250, 19));
        this.add(contrebackCostPrice, new KDLayout.Constraints(381, 298, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contgrossDuckSalePrice.setBounds(new Rectangle(10, 178, 250, 19));
        this.add(contgrossDuckSalePrice, new KDLayout.Constraints(10, 178, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contunitEatQty.setBounds(new Rectangle(753, 274, 250, 19));
        this.add(contunitEatQty, new KDLayout.Constraints(753, 274, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contyieldRate.setBounds(new Rectangle(381, 130, 250, 19));
        this.add(contyieldRate, new KDLayout.Constraints(381, 130, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contchickAmt.setBounds(new Rectangle(753, 202, 250, 19));
        this.add(contchickAmt, new KDLayout.Constraints(753, 202, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contremark.setBounds(new Rectangle(10, 298, 250, 19));
        this.add(contremark, new KDLayout.Constraints(10, 298, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarm.setBounds(new Rectangle(10, 130, 250, 19));
        this.add(contfarm, new KDLayout.Constraints(10, 130, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(10, 346, 250, 19));
        this.add(contbillStatus, new KDLayout.Constraints(10, 346, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkFivouchered.setBounds(new Rectangle(381, 346, 250, 19));
        this.add(chkFivouchered, new KDLayout.Constraints(381, 346, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contchickCostAmt.setBounds(new Rectangle(10, 250, 250, 19));
        this.add(contchickCostAmt, new KDLayout.Constraints(10, 250, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdrugCostAmt.setBounds(new Rectangle(10, 226, 250, 19));
        this.add(contdrugCostAmt, new KDLayout.Constraints(10, 226, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfeedCostAmt.setBounds(new Rectangle(381, 154, 250, 19));
        this.add(contfeedCostAmt, new KDLayout.Constraints(381, 154, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfeedBaseQty.setBounds(new Rectangle(753, 10, 250, 19));
        this.add(contfeedBaseQty, new KDLayout.Constraints(753, 10, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contchickQty.setBounds(new Rectangle(10, 34, 250, 19));
        this.add(contchickQty, new KDLayout.Constraints(10, 34, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttotalAmt_1.setBounds(new Rectangle(381, 250, 250, 19));
        this.add(conttotalAmt_1, new KDLayout.Constraints(381, 250, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfeedToMeat_1.setBounds(new Rectangle(381, 274, 250, 19));
        this.add(contfeedToMeat_1, new KDLayout.Constraints(381, 274, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfeedToMeat_2.setBounds(new Rectangle(10, 274, 250, 19));
        this.add(contfeedToMeat_2, new KDLayout.Constraints(10, 274, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contunitEatQty_1.setBounds(new Rectangle(10, 322, 250, 19));
        this.add(contunitEatQty_1, new KDLayout.Constraints(10, 322, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        continDate.setBounds(new Rectangle(10, 154, 250, 19));
        this.add(continDate, new KDLayout.Constraints(10, 154, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsendCars.setBounds(new Rectangle(10, 58, 250, 19));
        this.add(contsendCars, new KDLayout.Constraints(10, 58, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbatchContract.setBounds(new Rectangle(381, 58, 250, 19));
        this.add(contbatchContract, new KDLayout.Constraints(381, 58, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contseriousContract.setBounds(new Rectangle(753, 34, 250, 19));
        this.add(contseriousContract, new KDLayout.Constraints(753, 34, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcontractType.setBounds(new Rectangle(381, 34, 250, 19));
        this.add(contcontractType, new KDLayout.Constraints(381, 34, 250, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //paneBIZLayerControl17
        paneBIZLayerControl17.add(baseTab, resHelper.getString("baseTab.constraints"));
        paneBIZLayerControl17.add(otherTab, resHelper.getString("otherTab.constraints"));
        paneBIZLayerControl17.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //baseTab
        baseTab.setLayout(new KDLayout());
        baseTab.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 209));        kdtEntrys.setBounds(new Rectangle(6, 6, 975, 192));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.custom.settlebill.SettleBillEntryInfo(),null,false);
        baseTab.add(kdtEntrys_detailPanel, new KDLayout.Constraints(6, 6, 975, 192, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("weightType","0");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //otherTab
        otherTab.setLayout(new KDLayout());
        otherTab.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 209));        kdtOtherEntrys.setBounds(new Rectangle(8, 8, 969, 191));
        kdtOtherEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtOtherEntrys,new com.kingdee.eas.custom.settlebill.SettleBillOtherEntryInfo(),null,false);
        otherTab.add(kdtOtherEntrys_detailPanel, new KDLayout.Constraints(8, 8, 969, 191, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtOtherEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("wgtType","0");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 209));        kdtSubsidy.setBounds(new Rectangle(12, 12, 954, 188));
        kdtSubsidy_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtSubsidy,new com.kingdee.eas.custom.settlebill.SettleBillSubsidyInfo(),null,false);
        kDPanel2.add(kdtSubsidy_detailPanel, new KDLayout.Constraints(12, 12, 954, 188, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contaccountUnit
        contaccountUnit.setBoundEditor(prmtaccountUnit);
        //contdepartment
        contdepartment.setBoundEditor(prmtdepartment);
        //contfarmer
        contfarmer.setBoundEditor(prmtfarmer);
        //contpolicy
        contpolicy.setBoundEditor(txtpolicy);
        //contoperator
        contoperator.setBoundEditor(prmtoperator);
        //contslaughterPlace
        contslaughterPlace.setBoundEditor(txtslaughterPlace);
        //contfeedToMeat
        contfeedToMeat.setBoundEditor(txtfeedToMeat);
        //contsurvivalRate
        contsurvivalRate.setBoundEditor(txtsurvivalRate);
        //contmedicineUsage
        contmedicineUsage.setBoundEditor(txtmedicineUsage);
        //contdisinfectant
        contdisinfectant.setBoundEditor(txtdisinfectant);
        //contfeedingAmt
        contfeedingAmt.setBoundEditor(txtfeedingAmt);
        //contmedicineAmt
        contmedicineAmt.setBoundEditor(txtmedicineAmt);
        //contotherAmt
        contotherAmt.setBoundEditor(txtotherAmt);
        //contunitWeight
        contunitWeight.setBoundEditor(txtunitWeight);
        //contdayAge
        contdayAge.setBoundEditor(txtdayAge);
        //conttotalAmt
        conttotalAmt.setBoundEditor(txttotalAmt);
        //contunitAmt
        contunitAmt.setBoundEditor(txtunitAmt);
        //contrebackCostAmt
        contrebackCostAmt.setBoundEditor(txtrebackCostAmt);
        //contrebackCostPrice
        contrebackCostPrice.setBoundEditor(txtrebackCostPrice);
        //contgrossDuckSalePrice
        contgrossDuckSalePrice.setBoundEditor(txtgrossDuckSalePrice);
        //contunitEatQty
        contunitEatQty.setBoundEditor(txtunitEatQty);
        //contyieldRate
        contyieldRate.setBoundEditor(txtyieldRate);
        //contchickAmt
        contchickAmt.setBoundEditor(txtchickAmt);
        //contremark
        contremark.setBoundEditor(txtremark);
        //contfarm
        contfarm.setBoundEditor(txtfarm);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //contchickCostAmt
        contchickCostAmt.setBoundEditor(txtchickCostAmt);
        //contdrugCostAmt
        contdrugCostAmt.setBoundEditor(txtdrugCostAmt);
        //contfeedCostAmt
        contfeedCostAmt.setBoundEditor(txtfeedCostAmt);
        //contfeedBaseQty
        contfeedBaseQty.setBoundEditor(txtfeedBaseQty);
        //contchickQty
        contchickQty.setBoundEditor(txtchickQty);
        //conttotalAmt_1
        conttotalAmt_1.setBoundEditor(txttotalAmt_1);
        //contfeedToMeat_1
        contfeedToMeat_1.setBoundEditor(txtfeedToMeat_1);
        //contfeedToMeat_2
        contfeedToMeat_2.setBoundEditor(txtfeedToMeat_2);
        //contunitEatQty_1
        contunitEatQty_1.setBoundEditor(txtunitEatQty_1);
        //continDate
        continDate.setBoundEditor(pkinDate);
        //contsendCars
        contsendCars.setBoundEditor(prmtsendCars);
        //contbatchContract
        contbatchContract.setBoundEditor(prmtbatchContract);
        //contseriousContract
        contseriousContract.setBoundEditor(prmtseriousContract);
        //contcontractType
        contcontractType.setBoundEditor(prmtcontractType);

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
        this.toolBar.add(btnGetCostAmt);
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);
        this.toolBar.add(btnExeSet);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("Fivouchered", boolean.class, this.chkFivouchered, "selected");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.custom.settlebill.SettleBillEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.billType", String.class, this.kdtEntrys, "billType.text");
		dataBinder.registerBinding("entrys.billNum", String.class, this.kdtEntrys, "billNum.text");
		dataBinder.registerBinding("entrys.billDate", java.util.Date.class, this.kdtEntrys, "billDate.text");
		dataBinder.registerBinding("entrys.biologicalAssets", String.class, this.kdtEntrys, "biologicalAssets.text");
		dataBinder.registerBinding("entrys.level", String.class, this.kdtEntrys, "level.text");
		dataBinder.registerBinding("entrys.quantity", java.math.BigDecimal.class, this.kdtEntrys, "quantity.text");
		dataBinder.registerBinding("entrys.weight", java.math.BigDecimal.class, this.kdtEntrys, "weight.text");
		dataBinder.registerBinding("entrys.weightType", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "weightType.text");
		dataBinder.registerBinding("OtherEntrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtOtherEntrys, "id.text");
		dataBinder.registerBinding("OtherEntrys", com.kingdee.eas.custom.settlebill.SettleBillOtherEntryInfo.class, this.kdtOtherEntrys, "userObject");
		dataBinder.registerBinding("OtherEntrys.weight", java.math.BigDecimal.class, this.kdtOtherEntrys, "weight.text");
		dataBinder.registerBinding("OtherEntrys.price", java.math.BigDecimal.class, this.kdtOtherEntrys, "price.text");
		dataBinder.registerBinding("OtherEntrys.amount", java.math.BigDecimal.class, this.kdtOtherEntrys, "amount.text");
		dataBinder.registerBinding("OtherEntrys.quantity", int.class, this.kdtOtherEntrys, "quantity.text");
		dataBinder.registerBinding("OtherEntrys.biologicalAssests", java.lang.Object.class, this.kdtOtherEntrys, "biologicalAssests.text");
		dataBinder.registerBinding("OtherEntrys.wgtType", com.kingdee.util.enums.Enum.class, this.kdtOtherEntrys, "wgtType.text");
		dataBinder.registerBinding("OtherEntrys.disRate", java.math.BigDecimal.class, this.kdtOtherEntrys, "disRate.text");
		dataBinder.registerBinding("OtherEntrys.wgtAfterDis", java.math.BigDecimal.class, this.kdtOtherEntrys, "wgtAfterDis.text");
		dataBinder.registerBinding("Subsidy.seq", int.class, this.kdtSubsidy, "seq.text");
		dataBinder.registerBinding("Subsidy", com.kingdee.eas.custom.settlebill.SettleBillSubsidyInfo.class, this.kdtSubsidy, "userObject");
		dataBinder.registerBinding("Subsidy.billNum", String.class, this.kdtSubsidy, "billNum.text");
		dataBinder.registerBinding("Subsidy.amount", java.math.BigDecimal.class, this.kdtSubsidy, "amount.text");
		dataBinder.registerBinding("Subsidy.cusComplainType", String.class, this.kdtSubsidy, "cusComplainType.text");
		dataBinder.registerBinding("Subsidy.remark", String.class, this.kdtSubsidy, "remark.text");
		dataBinder.registerBinding("Subsidy.avgWgt", java.math.BigDecimal.class, this.kdtSubsidy, "avgWgt.text");
		dataBinder.registerBinding("accountUnit", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtaccountUnit, "data");
		dataBinder.registerBinding("department", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtdepartment, "data");
		dataBinder.registerBinding("farmer", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtfarmer, "data");
		dataBinder.registerBinding("policy", String.class, this.txtpolicy, "text");
		dataBinder.registerBinding("operator", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtoperator, "data");
		dataBinder.registerBinding("slaughterPlace", String.class, this.txtslaughterPlace, "text");
		dataBinder.registerBinding("feedToMeat", java.math.BigDecimal.class, this.txtfeedToMeat, "value");
		dataBinder.registerBinding("survivalRate", java.math.BigDecimal.class, this.txtsurvivalRate, "value");
		dataBinder.registerBinding("medicineUsage", java.math.BigDecimal.class, this.txtmedicineUsage, "value");
		dataBinder.registerBinding("disinfectant", java.math.BigDecimal.class, this.txtdisinfectant, "value");
		dataBinder.registerBinding("feedingAmt", java.math.BigDecimal.class, this.txtfeedingAmt, "value");
		dataBinder.registerBinding("medicineAmt", java.math.BigDecimal.class, this.txtmedicineAmt, "value");
		dataBinder.registerBinding("otherAmt", java.math.BigDecimal.class, this.txtotherAmt, "value");
		dataBinder.registerBinding("unitWeight", java.math.BigDecimal.class, this.txtunitWeight, "value");
		dataBinder.registerBinding("dayAge", int.class, this.txtdayAge, "value");
		dataBinder.registerBinding("totalAmt", java.math.BigDecimal.class, this.txttotalAmt, "value");
		dataBinder.registerBinding("unitAmt", java.math.BigDecimal.class, this.txtunitAmt, "value");
		dataBinder.registerBinding("rebackCostAmt", java.math.BigDecimal.class, this.txtrebackCostAmt, "value");
		dataBinder.registerBinding("rebackCostPrice", java.math.BigDecimal.class, this.txtrebackCostPrice, "value");
		dataBinder.registerBinding("grossDuckSalePrice", java.math.BigDecimal.class, this.txtgrossDuckSalePrice, "value");
		dataBinder.registerBinding("unitEatQty", java.math.BigDecimal.class, this.txtunitEatQty, "value");
		dataBinder.registerBinding("yieldRate", java.math.BigDecimal.class, this.txtyieldRate, "value");
		dataBinder.registerBinding("chickAmt", java.math.BigDecimal.class, this.txtchickAmt, "value");
		dataBinder.registerBinding("remark", String.class, this.txtremark, "text");
		dataBinder.registerBinding("farm", String.class, this.txtfarm, "text");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.custom.settlebill.billStatus.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("chickCostAmt", java.math.BigDecimal.class, this.txtchickCostAmt, "value");
		dataBinder.registerBinding("drugCostAmt", java.math.BigDecimal.class, this.txtdrugCostAmt, "value");
		dataBinder.registerBinding("feedCostAmt", java.math.BigDecimal.class, this.txtfeedCostAmt, "value");
		dataBinder.registerBinding("feedBaseQty", java.math.BigDecimal.class, this.txtfeedBaseQty, "value");
		dataBinder.registerBinding("chickQty", java.math.BigDecimal.class, this.txtchickQty, "value");
		dataBinder.registerBinding("totalAmt_1", java.math.BigDecimal.class, this.txttotalAmt_1, "value");
		dataBinder.registerBinding("feedToMeat_1", java.math.BigDecimal.class, this.txtfeedToMeat_1, "value");
		dataBinder.registerBinding("feedToMeat_2", java.math.BigDecimal.class, this.txtfeedToMeat_2, "value");
		dataBinder.registerBinding("unitEatQty_1", java.math.BigDecimal.class, this.txtunitEatQty_1, "value");
		dataBinder.registerBinding("inDate", java.util.Date.class, this.pkinDate, "value");
		dataBinder.registerBinding("sendCars", com.kingdee.eas.custom.taihe.weight.CarSendBillInfo.class, this.prmtsendCars, "data");
		dataBinder.registerBinding("batchContract", com.kingdee.eas.custom.taihe.contract.BatchContractInfo.class, this.prmtbatchContract, "data");
		dataBinder.registerBinding("seriousContract", com.kingdee.eas.custom.taihe.contract.SuccessiveContractInfo.class, this.prmtseriousContract, "data");
		dataBinder.registerBinding("contractType", com.kingdee.eas.custom.signwasthetable.ContractTypeInfo.class, this.prmtcontractType, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.settlebill.app.SettleBillEditUIHandler";
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
        this.editData = (com.kingdee.eas.custom.settlebill.SettleBillInfo)ov;
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
		getValidateHelper().registerBindProperty("Fivouchered", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.billType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.billNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.billDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.biologicalAssets", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.level", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.quantity", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.weight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.weightType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OtherEntrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OtherEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OtherEntrys.weight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OtherEntrys.price", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OtherEntrys.amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OtherEntrys.quantity", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OtherEntrys.biologicalAssests", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OtherEntrys.wgtType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OtherEntrys.disRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OtherEntrys.wgtAfterDis", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Subsidy.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Subsidy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Subsidy.billNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Subsidy.amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Subsidy.cusComplainType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Subsidy.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Subsidy.avgWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("accountUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("department", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("policy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("operator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("slaughterPlace", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("feedToMeat", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("survivalRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("medicineUsage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("disinfectant", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("feedingAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("medicineAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("otherAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("unitWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dayAge", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("unitAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("rebackCostAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("rebackCostPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("grossDuckSalePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("unitEatQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yieldRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickCostAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("drugCostAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("feedCostAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("feedBaseQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalAmt_1", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("feedToMeat_1", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("feedToMeat_2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("unitEatQty_1", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("inDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sendCars", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batchContract", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("seriousContract", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contractType", ValidateHelper.ON_SAVE);    		
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
    	sic.add(new SelectorItemInfo("entrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("entrys.billType"));
    	sic.add(new SelectorItemInfo("entrys.billNum"));
    	sic.add(new SelectorItemInfo("entrys.billDate"));
    	sic.add(new SelectorItemInfo("entrys.biologicalAssets"));
    	sic.add(new SelectorItemInfo("entrys.level"));
    	sic.add(new SelectorItemInfo("entrys.quantity"));
    	sic.add(new SelectorItemInfo("entrys.weight"));
    	sic.add(new SelectorItemInfo("entrys.weightType"));
    	sic.add(new SelectorItemInfo("OtherEntrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("OtherEntrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("OtherEntrys.weight"));
    	sic.add(new SelectorItemInfo("OtherEntrys.price"));
    	sic.add(new SelectorItemInfo("OtherEntrys.amount"));
    	sic.add(new SelectorItemInfo("OtherEntrys.quantity"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("OtherEntrys.biologicalAssests.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("OtherEntrys.biologicalAssests.id"));
			sic.add(new SelectorItemInfo("OtherEntrys.biologicalAssests.name"));
        	sic.add(new SelectorItemInfo("OtherEntrys.biologicalAssests.number"));
		}
    	sic.add(new SelectorItemInfo("OtherEntrys.wgtType"));
    	sic.add(new SelectorItemInfo("OtherEntrys.disRate"));
    	sic.add(new SelectorItemInfo("OtherEntrys.wgtAfterDis"));
    	sic.add(new SelectorItemInfo("Subsidy.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Subsidy.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("Subsidy.billNum"));
    	sic.add(new SelectorItemInfo("Subsidy.amount"));
    	sic.add(new SelectorItemInfo("Subsidy.cusComplainType"));
    	sic.add(new SelectorItemInfo("Subsidy.remark"));
    	sic.add(new SelectorItemInfo("Subsidy.avgWgt"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("accountUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("accountUnit.id"));
        	sic.add(new SelectorItemInfo("accountUnit.number"));
        	sic.add(new SelectorItemInfo("accountUnit.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("department.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("department.id"));
        	sic.add(new SelectorItemInfo("department.number"));
        	sic.add(new SelectorItemInfo("department.name"));
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
        sic.add(new SelectorItemInfo("policy"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("operator.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("operator.id"));
        	sic.add(new SelectorItemInfo("operator.number"));
        	sic.add(new SelectorItemInfo("operator.name"));
		}
        sic.add(new SelectorItemInfo("slaughterPlace"));
        sic.add(new SelectorItemInfo("feedToMeat"));
        sic.add(new SelectorItemInfo("survivalRate"));
        sic.add(new SelectorItemInfo("medicineUsage"));
        sic.add(new SelectorItemInfo("disinfectant"));
        sic.add(new SelectorItemInfo("feedingAmt"));
        sic.add(new SelectorItemInfo("medicineAmt"));
        sic.add(new SelectorItemInfo("otherAmt"));
        sic.add(new SelectorItemInfo("unitWeight"));
        sic.add(new SelectorItemInfo("dayAge"));
        sic.add(new SelectorItemInfo("totalAmt"));
        sic.add(new SelectorItemInfo("unitAmt"));
        sic.add(new SelectorItemInfo("rebackCostAmt"));
        sic.add(new SelectorItemInfo("rebackCostPrice"));
        sic.add(new SelectorItemInfo("grossDuckSalePrice"));
        sic.add(new SelectorItemInfo("unitEatQty"));
        sic.add(new SelectorItemInfo("yieldRate"));
        sic.add(new SelectorItemInfo("chickAmt"));
        sic.add(new SelectorItemInfo("remark"));
        sic.add(new SelectorItemInfo("farm"));
        sic.add(new SelectorItemInfo("billStatus"));
        sic.add(new SelectorItemInfo("chickCostAmt"));
        sic.add(new SelectorItemInfo("drugCostAmt"));
        sic.add(new SelectorItemInfo("feedCostAmt"));
        sic.add(new SelectorItemInfo("feedBaseQty"));
        sic.add(new SelectorItemInfo("chickQty"));
        sic.add(new SelectorItemInfo("totalAmt_1"));
        sic.add(new SelectorItemInfo("feedToMeat_1"));
        sic.add(new SelectorItemInfo("feedToMeat_2"));
        sic.add(new SelectorItemInfo("unitEatQty_1"));
        sic.add(new SelectorItemInfo("inDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("sendCars.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("sendCars.id"));
        	sic.add(new SelectorItemInfo("sendCars.number"));
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
			sic.add(new SelectorItemInfo("seriousContract.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("seriousContract.id"));
        	sic.add(new SelectorItemInfo("seriousContract.number"));
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
     * output actionGetCostAmt_actionPerformed method
     */
    public void actionGetCostAmt_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.settlebill.SettleBillFactory.getRemoteInstance().getCostAmt(editData);
    }
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.settlebill.SettleBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.settlebill.SettleBillFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionCheckVoucher_actionPerformed method
     */
    public void actionCheckVoucher_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.settlebill.SettleBillFactory.getRemoteInstance().checkVoucher(editData);
    }
    	

    /**
     * output actionExeSet_actionPerformed method
     */
    public void actionExeSet_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.settlebill.SettleBillFactory.getRemoteInstance().exeSet(editData);
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
	public RequestContext prepareActionGetCostAmt(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionGetCostAmt() {
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
	public RequestContext prepareActionCheckVoucher(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionCheckVoucher() {
    	return false;
    }
	public RequestContext prepareActionExeSet(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionExeSet() {
    	return false;
    }

    /**
     * output ActionGetCostAmt class
     */     
    protected class ActionGetCostAmt extends ItemAction {     
    
        public ActionGetCostAmt()
        {
            this(null);
        }

        public ActionGetCostAmt(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionGetCostAmt.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionGetCostAmt.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionGetCostAmt.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractSettleBillEditUI.this, "ActionGetCostAmt", "actionGetCostAmt_actionPerformed", e);
        }
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
            innerActionPerformed("eas", AbstractSettleBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractSettleBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionCheckVoucher class
     */     
    protected class ActionCheckVoucher extends ItemAction {     
    
        public ActionCheckVoucher()
        {
            this(null);
        }

        public ActionCheckVoucher(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionCheckVoucher.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCheckVoucher.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCheckVoucher.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractSettleBillEditUI.this, "ActionCheckVoucher", "actionCheckVoucher_actionPerformed", e);
        }
    }

    /**
     * output ActionExeSet class
     */     
    protected class ActionExeSet extends ItemAction {     
    
        public ActionExeSet()
        {
            this(null);
        }

        public ActionExeSet(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionExeSet.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionExeSet.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionExeSet.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractSettleBillEditUI.this, "ActionExeSet", "actionExeSet_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.settlebill.client", "SettleBillEditUI");
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
        return com.kingdee.eas.custom.settlebill.client.SettleBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.settlebill.SettleBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.settlebill.SettleBillInfo objectValue = new com.kingdee.eas.custom.settlebill.SettleBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/settlebill/SettleBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.settlebill.app.SettleBillQuery");
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
		vo.put("billStatus","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}