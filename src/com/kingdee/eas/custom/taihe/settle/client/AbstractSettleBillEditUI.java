/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.settle.client;

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
public abstract class AbstractSettleBillEditUI extends com.kingdee.eas.custom.wlhllicensemanager.client.WlhlCoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSettleBillEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane paneBIZLayerControl17;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpurchaseMthod;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpurchaseType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrecycleDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcarSendBill;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalSettleAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstdFrePrice;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtauditTime;
    protected com.kingdee.bos.ctrl.swing.KDPanel baseTab;
    protected com.kingdee.bos.ctrl.swing.KDPanel assTab;
    protected com.kingdee.bos.ctrl.swing.KDPanel otherTab;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtAssEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtAssEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtOtherEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtOtherEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatchContract;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsuccessiveContract;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontractType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoriginMtrialPerson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpartyB;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contiDCardNo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaccountBank;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbankAccount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmMnger;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdayAge;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkFivouchered;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsettlePolicy;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contawardsPolicy;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkhouseBefore;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continQty;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisQualified;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmAddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsupplierAddress;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisdiff;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdifftxt;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbatchContract;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsuccessiveContract;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcontractType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtoriginMtrialPerson;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpartyB;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtiDCardNo;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtaccountBank;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbankAccount;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarm;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfarmMnger;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkinDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdayAge;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsettlePolicy;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtawardsPolicy;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtinQty;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfarmAddress;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtsupplierAddress;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdifftxt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyieldStd;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcarcassSettleWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstdYeildRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contactualYieldRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalSettleWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsafePrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmarketPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpurchasePrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contqty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpurchaseSettleAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenSzQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenSzAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contplusSettleWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contplusPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenSzCoeff;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contawardsAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbasePrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthedingPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfixedCoeff;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contshareCoeff;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contavgWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchargeStd;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCSzAverageQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyieldStd;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcarcassSettleWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtstdYeildRate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtactualYieldRate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalSettleWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsafePrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmarketPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpurchasePrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtqty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpurchaseSettleAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickenSzQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickenSzAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtplusSettleWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtplusPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickenSzCoeff;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtawardsAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbasePrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txthedingPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfixedCoeff;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtshareCoeff;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtavgWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchargeStd;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtCSzAverageQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstdMiles;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contactualMiles;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsuppFreAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contselfFrePrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contactulSettleFreAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCarriageFormat;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcar;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contactualFreAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contselfFreAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbasketQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtstdMiles;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtactualMiles;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsuppFreAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtselfFrePrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtactulSettleFreAmt;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCarriageFormat;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcar;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtactualFreAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtselfFreAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbasketQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contotherAmount;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkbuyComplete;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtotherAmount;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDComboBox purchaseMthod;
    protected com.kingdee.bos.ctrl.swing.KDComboBox purchaseType;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkrecycleDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcarSendBill;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalSettleAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtstdFrePrice;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnExecute;
    protected com.kingdee.eas.custom.taihe.settle.SettleBillInfo editData = null;
    protected ActionExecute actionExecute = null;
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
        //actionAudit
        actionAudit.setEnabled(true);
        actionAudit.setDaemonRun(false);

        _tempStr = resHelper.getString("actionAudit.SHORT_DESCRIPTION");
        actionAudit.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("actionAudit.LONG_DESCRIPTION");
        actionAudit.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("actionAudit.NAME");
        actionAudit.putValue(ItemAction.NAME, _tempStr);
        this.actionAudit.setBindWorkFlow(true);
        this.actionAudit.setExtendProperty("canForewarn", "true");
        this.actionAudit.setExtendProperty("userDefined", "true");
        this.actionAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionUnAudit
        actionUnAudit.setEnabled(true);
        actionUnAudit.setDaemonRun(false);

        _tempStr = resHelper.getString("actionUnAudit.SHORT_DESCRIPTION");
        actionUnAudit.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("actionUnAudit.LONG_DESCRIPTION");
        actionUnAudit.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("actionUnAudit.NAME");
        actionUnAudit.putValue(ItemAction.NAME, _tempStr);
        this.actionUnAudit.setBindWorkFlow(true);
        this.actionUnAudit.setExtendProperty("canForewarn", "true");
        this.actionUnAudit.setExtendProperty("userDefined", "true");
        this.actionUnAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionExecute
        this.actionExecute = new ActionExecute(this);
        getActionManager().registerAction("actionExecute", actionExecute);
        this.actionExecute.setExtendProperty("canForewarn", "true");
        this.actionExecute.setExtendProperty("userDefined", "true");
        this.actionExecute.setExtendProperty("isObjectUpdateLock", "false");
         this.actionExecute.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionExecute.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.paneBIZLayerControl17 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpurchaseMthod = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpurchaseType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrecycleDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcarSendBill = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalSettleAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstdFrePrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtauditTime = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.baseTab = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.assTab = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.otherTab = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtAssEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtOtherEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contbatchContract = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsuccessiveContract = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcontractType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoriginMtrialPerson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpartyB = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contiDCardNo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contaccountBank = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbankAccount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmMnger = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdayAge = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkFivouchered = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contsettlePolicy = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contawardsPolicy = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkhouseBefore = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.continQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisQualified = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contfarmAddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsupplierAddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisdiff = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contdifftxt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtbatchContract = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtsuccessiveContract = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcontractType = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtoriginMtrialPerson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtpartyB = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtiDCardNo = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtaccountBank = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbankAccount = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtfarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtfarmMnger = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkinDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtdayAge = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtsettlePolicy = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtawardsPolicy = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtinQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfarmAddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtsupplierAddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtdifftxt = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.contyieldStd = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcarcassSettleWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstdYeildRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contactualYieldRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalSettleWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsafePrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmarketPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpurchasePrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contqty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpurchaseSettleAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchickenSzQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchickenSzAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contplusSettleWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contplusPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchickenSzCoeff = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contawardsAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbasePrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthedingPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfixedCoeff = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contshareCoeff = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contavgWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchargeStd = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCSzAverageQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtyieldStd = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcarcassSettleWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtstdYeildRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtactualYieldRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttotalSettleWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsafePrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmarketPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpurchasePrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtqty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpurchaseSettleAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtchickenSzQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtchickenSzAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtplusSettleWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtplusPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtchickenSzCoeff = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtawardsAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbasePrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txthedingPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfixedCoeff = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtshareCoeff = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtavgWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtchargeStd = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtCSzAverageQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contstdMiles = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contactualMiles = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsuppFreAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contselfFrePrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contactulSettleFreAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCarriageFormat = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcar = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contactualFreAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contselfFreAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbasketQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtstdMiles = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtactualMiles = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsuppFreAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtselfFrePrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtactulSettleFreAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtCarriageFormat = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcar = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtactualFreAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtselfFreAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbasketQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contotherAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkbuyComplete = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.txtotherAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.purchaseMthod = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.purchaseType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.pkrecycleDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtcarSendBill = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txttotalSettleAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtstdFrePrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.btnExecute = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.paneBIZLayerControl17.setName("paneBIZLayerControl17");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contcompany.setName("contcompany");
        this.contpurchaseMthod.setName("contpurchaseMthod");
        this.contpurchaseType.setName("contpurchaseType");
        this.contrecycleDate.setName("contrecycleDate");
        this.contcarSendBill.setName("contcarSendBill");
        this.conttotalSettleAmt.setName("conttotalSettleAmt");
        this.contstdFrePrice.setName("contstdFrePrice");
        this.prmtauditTime.setName("prmtauditTime");
        this.baseTab.setName("baseTab");
        this.assTab.setName("assTab");
        this.otherTab.setName("otherTab");
        this.kdtEntrys.setName("kdtEntrys");
        this.kdtAssEntrys.setName("kdtAssEntrys");
        this.kdtOtherEntrys.setName("kdtOtherEntrys");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel3.setName("kDPanel3");
        this.kDPanel4.setName("kDPanel4");
        this.kDPanel2.setName("kDPanel2");
        this.contbatchContract.setName("contbatchContract");
        this.contsuccessiveContract.setName("contsuccessiveContract");
        this.contcontractType.setName("contcontractType");
        this.contoriginMtrialPerson.setName("contoriginMtrialPerson");
        this.contpartyB.setName("contpartyB");
        this.contiDCardNo.setName("contiDCardNo");
        this.contaccountBank.setName("contaccountBank");
        this.contbankAccount.setName("contbankAccount");
        this.contfarm.setName("contfarm");
        this.contfarmMnger.setName("contfarmMnger");
        this.continDate.setName("continDate");
        this.contdayAge.setName("contdayAge");
        this.chkFivouchered.setName("chkFivouchered");
        this.contsettlePolicy.setName("contsettlePolicy");
        this.contawardsPolicy.setName("contawardsPolicy");
        this.chkhouseBefore.setName("chkhouseBefore");
        this.continQty.setName("continQty");
        this.chkisQualified.setName("chkisQualified");
        this.contfarmAddress.setName("contfarmAddress");
        this.contsupplierAddress.setName("contsupplierAddress");
        this.chkisdiff.setName("chkisdiff");
        this.contdifftxt.setName("contdifftxt");
        this.prmtbatchContract.setName("prmtbatchContract");
        this.prmtsuccessiveContract.setName("prmtsuccessiveContract");
        this.prmtcontractType.setName("prmtcontractType");
        this.prmtoriginMtrialPerson.setName("prmtoriginMtrialPerson");
        this.prmtpartyB.setName("prmtpartyB");
        this.txtiDCardNo.setName("txtiDCardNo");
        this.txtaccountBank.setName("txtaccountBank");
        this.txtbankAccount.setName("txtbankAccount");
        this.prmtfarm.setName("prmtfarm");
        this.txtfarmMnger.setName("txtfarmMnger");
        this.pkinDate.setName("pkinDate");
        this.txtdayAge.setName("txtdayAge");
        this.prmtsettlePolicy.setName("prmtsettlePolicy");
        this.prmtawardsPolicy.setName("prmtawardsPolicy");
        this.txtinQty.setName("txtinQty");
        this.txtfarmAddress.setName("txtfarmAddress");
        this.txtsupplierAddress.setName("txtsupplierAddress");
        this.txtdifftxt.setName("txtdifftxt");
        this.contyieldStd.setName("contyieldStd");
        this.contcarcassSettleWgt.setName("contcarcassSettleWgt");
        this.contstdYeildRate.setName("contstdYeildRate");
        this.contactualYieldRate.setName("contactualYieldRate");
        this.conttotalSettleWgt.setName("conttotalSettleWgt");
        this.contsafePrice.setName("contsafePrice");
        this.contmarketPrice.setName("contmarketPrice");
        this.contpurchasePrice.setName("contpurchasePrice");
        this.contqty.setName("contqty");
        this.contpurchaseSettleAmt.setName("contpurchaseSettleAmt");
        this.contchickenSzQty.setName("contchickenSzQty");
        this.contchickenSzAmt.setName("contchickenSzAmt");
        this.contplusSettleWgt.setName("contplusSettleWgt");
        this.contplusPrice.setName("contplusPrice");
        this.contchickenSzCoeff.setName("contchickenSzCoeff");
        this.contawardsAmount.setName("contawardsAmount");
        this.contbasePrice.setName("contbasePrice");
        this.conthedingPrice.setName("conthedingPrice");
        this.contfixedCoeff.setName("contfixedCoeff");
        this.contshareCoeff.setName("contshareCoeff");
        this.contavgWgt.setName("contavgWgt");
        this.contchargeStd.setName("contchargeStd");
        this.contCSzAverageQty.setName("contCSzAverageQty");
        this.txtyieldStd.setName("txtyieldStd");
        this.txtcarcassSettleWgt.setName("txtcarcassSettleWgt");
        this.txtstdYeildRate.setName("txtstdYeildRate");
        this.txtactualYieldRate.setName("txtactualYieldRate");
        this.txttotalSettleWgt.setName("txttotalSettleWgt");
        this.txtsafePrice.setName("txtsafePrice");
        this.txtmarketPrice.setName("txtmarketPrice");
        this.txtpurchasePrice.setName("txtpurchasePrice");
        this.txtqty.setName("txtqty");
        this.txtpurchaseSettleAmt.setName("txtpurchaseSettleAmt");
        this.txtchickenSzQty.setName("txtchickenSzQty");
        this.txtchickenSzAmt.setName("txtchickenSzAmt");
        this.txtplusSettleWgt.setName("txtplusSettleWgt");
        this.txtplusPrice.setName("txtplusPrice");
        this.txtchickenSzCoeff.setName("txtchickenSzCoeff");
        this.txtawardsAmount.setName("txtawardsAmount");
        this.txtbasePrice.setName("txtbasePrice");
        this.txthedingPrice.setName("txthedingPrice");
        this.txtfixedCoeff.setName("txtfixedCoeff");
        this.txtshareCoeff.setName("txtshareCoeff");
        this.txtavgWgt.setName("txtavgWgt");
        this.txtchargeStd.setName("txtchargeStd");
        this.txtCSzAverageQty.setName("txtCSzAverageQty");
        this.contstdMiles.setName("contstdMiles");
        this.contactualMiles.setName("contactualMiles");
        this.contsuppFreAmt.setName("contsuppFreAmt");
        this.contselfFrePrice.setName("contselfFrePrice");
        this.contactulSettleFreAmt.setName("contactulSettleFreAmt");
        this.contCarriageFormat.setName("contCarriageFormat");
        this.contcar.setName("contcar");
        this.contactualFreAmt.setName("contactualFreAmt");
        this.contselfFreAmt.setName("contselfFreAmt");
        this.contbasketQty.setName("contbasketQty");
        this.txtstdMiles.setName("txtstdMiles");
        this.txtactualMiles.setName("txtactualMiles");
        this.txtsuppFreAmt.setName("txtsuppFreAmt");
        this.txtselfFrePrice.setName("txtselfFrePrice");
        this.txtactulSettleFreAmt.setName("txtactulSettleFreAmt");
        this.prmtCarriageFormat.setName("prmtCarriageFormat");
        this.prmtcar.setName("prmtcar");
        this.txtactualFreAmt.setName("txtactualFreAmt");
        this.txtselfFreAmt.setName("txtselfFreAmt");
        this.txtbasketQty.setName("txtbasketQty");
        this.contotherAmount.setName("contotherAmount");
        this.chkbuyComplete.setName("chkbuyComplete");
        this.txtotherAmount.setName("txtotherAmount");
        this.prmtcompany.setName("prmtcompany");
        this.purchaseMthod.setName("purchaseMthod");
        this.purchaseType.setName("purchaseType");
        this.pkrecycleDate.setName("pkrecycleDate");
        this.prmtcarSendBill.setName("prmtcarSendBill");
        this.txttotalSettleAmt.setName("txttotalSettleAmt");
        this.txtstdFrePrice.setName("txtstdFrePrice");
        this.btnExecute.setName("btnExecute");
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
        this.contCreator.setBoundLabelText(resHelper.getString("contCreator.boundLabelText"));		
        this.contCreator.setBoundLabelLength(100);		
        this.contCreator.setBoundLabelUnderline(true);		
        this.contCreator.setEnabled(false);		
        this.contCreator.setBoundLabelAlignment(7);		
        this.contCreator.setVisible(true);		
        this.contCreator.setForeground(new java.awt.Color(0,0,0));		
        this.contCreateTime.setBoundLabelText(resHelper.getString("contCreateTime.boundLabelText"));		
        this.contCreateTime.setBoundLabelLength(100);		
        this.contCreateTime.setBoundLabelUnderline(true);		
        this.contCreateTime.setEnabled(false);		
        this.contCreateTime.setBoundLabelAlignment(7);		
        this.contCreateTime.setVisible(true);		
        this.contCreateTime.setForeground(new java.awt.Color(0,0,0));		
        this.contLastUpdateUser.setBoundLabelText(resHelper.getString("contLastUpdateUser.boundLabelText"));		
        this.contLastUpdateUser.setBoundLabelLength(100);		
        this.contLastUpdateUser.setBoundLabelUnderline(true);		
        this.contLastUpdateUser.setEnabled(false);		
        this.contLastUpdateUser.setVisible(true);		
        this.contLastUpdateUser.setBoundLabelAlignment(7);		
        this.contLastUpdateUser.setForeground(new java.awt.Color(0,0,0));		
        this.contLastUpdateTime.setBoundLabelText(resHelper.getString("contLastUpdateTime.boundLabelText"));		
        this.contLastUpdateTime.setBoundLabelLength(100);		
        this.contLastUpdateTime.setBoundLabelUnderline(true);		
        this.contLastUpdateTime.setEnabled(false);		
        this.contLastUpdateTime.setVisible(true);		
        this.contLastUpdateTime.setBoundLabelAlignment(7);		
        this.contLastUpdateTime.setForeground(new java.awt.Color(0,0,0));		
        this.contNumber.setBoundLabelText(resHelper.getString("contNumber.boundLabelText"));		
        this.contNumber.setBoundLabelLength(100);		
        this.contNumber.setBoundLabelUnderline(true);		
        this.contNumber.setBoundLabelAlignment(7);		
        this.contNumber.setVisible(true);		
        this.contNumber.setForeground(new java.awt.Color(0,0,0));		
        this.contBizDate.setBoundLabelText(resHelper.getString("contBizDate.boundLabelText"));		
        this.contBizDate.setBoundLabelLength(100);		
        this.contBizDate.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelAlignment(7);		
        this.contBizDate.setVisible(true);		
        this.contBizDate.setForeground(new java.awt.Color(0,0,0));		
        this.contDescription.setBoundLabelText(resHelper.getString("contDescription.boundLabelText"));		
        this.contDescription.setBoundLabelLength(100);		
        this.contDescription.setBoundLabelUnderline(true);		
        this.contDescription.setBoundLabelAlignment(7);		
        this.contDescription.setVisible(true);		
        this.contDescription.setForeground(new java.awt.Color(0,0,0));		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);		
        this.contAuditor.setBoundLabelAlignment(7);		
        this.contAuditor.setVisible(true);		
        this.contAuditor.setForeground(new java.awt.Color(0,0,0));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);		
        this.prmtCreator.setEnabled(false);		
        this.prmtCreator.setRequired(false);		
        this.prmtCreator.setForeground(new java.awt.Color(0,0,0));		
        this.kDDateCreateTime.setTimeEnabled(true);		
        this.kDDateCreateTime.setEnabled(false);		
        this.kDDateCreateTime.setRequired(false);		
        this.kDDateCreateTime.setForeground(new java.awt.Color(0,0,0));		
        this.prmtLastUpdateUser.setEnabled(false);		
        this.prmtLastUpdateUser.setRequired(false);		
        this.prmtLastUpdateUser.setForeground(new java.awt.Color(0,0,0));		
        this.kDDateLastUpdateTime.setTimeEnabled(true);		
        this.kDDateLastUpdateTime.setEnabled(false);		
        this.kDDateLastUpdateTime.setRequired(false);		
        this.kDDateLastUpdateTime.setForeground(new java.awt.Color(0,0,0));		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setEnabled(true);		
        this.txtNumber.setHorizontalAlignment(2);		
        this.txtNumber.setRequired(false);		
        this.txtNumber.setForeground(new java.awt.Color(0,0,0));		
        this.pkBizDate.setEnabled(true);		
        this.pkBizDate.setRequired(false);		
        this.pkBizDate.setForeground(new java.awt.Color(0,0,0));		
        this.txtDescription.setMaxLength(80);		
        this.txtDescription.setEnabled(true);		
        this.txtDescription.setHorizontalAlignment(2);		
        this.txtDescription.setRequired(false);		
        this.txtDescription.setForeground(new java.awt.Color(0,0,0));		
        this.prmtAuditor.setEnabled(false);		
        this.prmtAuditor.setRequired(false);		
        this.prmtAuditor.setForeground(new java.awt.Color(0,0,0));		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // paneBIZLayerControl17		
        this.paneBIZLayerControl17.setVisible(true);
        // kDTabbedPane1
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contpurchaseMthod		
        this.contpurchaseMthod.setBoundLabelText(resHelper.getString("contpurchaseMthod.boundLabelText"));		
        this.contpurchaseMthod.setBoundLabelLength(100);		
        this.contpurchaseMthod.setBoundLabelUnderline(true);		
        this.contpurchaseMthod.setVisible(true);
        // contpurchaseType		
        this.contpurchaseType.setBoundLabelText(resHelper.getString("contpurchaseType.boundLabelText"));		
        this.contpurchaseType.setBoundLabelLength(100);		
        this.contpurchaseType.setBoundLabelUnderline(true);		
        this.contpurchaseType.setVisible(true);
        // contrecycleDate		
        this.contrecycleDate.setBoundLabelText(resHelper.getString("contrecycleDate.boundLabelText"));		
        this.contrecycleDate.setBoundLabelLength(100);		
        this.contrecycleDate.setBoundLabelUnderline(true);		
        this.contrecycleDate.setVisible(true);
        // contcarSendBill		
        this.contcarSendBill.setBoundLabelText(resHelper.getString("contcarSendBill.boundLabelText"));		
        this.contcarSendBill.setBoundLabelLength(100);		
        this.contcarSendBill.setBoundLabelUnderline(true);		
        this.contcarSendBill.setVisible(true);
        // conttotalSettleAmt		
        this.conttotalSettleAmt.setBoundLabelText(resHelper.getString("conttotalSettleAmt.boundLabelText"));		
        this.conttotalSettleAmt.setBoundLabelLength(100);		
        this.conttotalSettleAmt.setBoundLabelUnderline(true);		
        this.conttotalSettleAmt.setVisible(true);
        // contstdFrePrice		
        this.contstdFrePrice.setBoundLabelText(resHelper.getString("contstdFrePrice.boundLabelText"));		
        this.contstdFrePrice.setBoundLabelLength(100);		
        this.contstdFrePrice.setBoundLabelUnderline(true);		
        this.contstdFrePrice.setVisible(false);
        // prmtauditTime		
        this.prmtauditTime.setQueryInfo("com.kingdee.eas.base.permission.app.UserListQuery");		
        this.prmtauditTime.setEditable(true);		
        this.prmtauditTime.setDisplayFormat("$number$");		
        this.prmtauditTime.setEditFormat("$number$");		
        this.prmtauditTime.setCommitFormat("$number$");		
        this.prmtauditTime.setRequired(false);		
        this.prmtauditTime.setEnabled(false);
        // baseTab		
        this.baseTab.setVisible(true);
        // assTab		
        this.assTab.setVisible(true);
        // otherTab		
        this.otherTab.setVisible(true);
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol1\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"billType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"billNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"billDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"wgtType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"wghTime\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"wgt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{billType}</t:Cell><t:Cell>$Resource{billNum}</t:Cell><t:Cell>$Resource{billDate}</t:Cell><t:Cell>$Resource{wgtType}</t:Cell><t:Cell>$Resource{wghTime}</t:Cell><t:Cell>$Resource{wgt}</t:Cell><t:Cell>$Resource{qty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));

                this.kdtEntrys.putBindContents("editData",new String[] {"id","billType","billNum","billDate","wgtType","wghTime","wgt","qty"});


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
        KDComboBox kdtEntrys_wgtType_ComboBox = new KDComboBox();
        kdtEntrys_wgtType_ComboBox.setName("kdtEntrys_wgtType_ComboBox");
        kdtEntrys_wgtType_ComboBox.setVisible(true);
        kdtEntrys_wgtType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.taihe.weight.CarcassType").toArray());
        KDTDefaultCellEditor kdtEntrys_wgtType_CellEditor = new KDTDefaultCellEditor(kdtEntrys_wgtType_ComboBox);
        this.kdtEntrys.getColumn("wgtType").setEditor(kdtEntrys_wgtType_CellEditor);
        KDDatePicker kdtEntrys_wghTime_DatePicker = new KDDatePicker();
        kdtEntrys_wghTime_DatePicker.setName("kdtEntrys_wghTime_DatePicker");
        kdtEntrys_wghTime_DatePicker.setVisible(true);
        kdtEntrys_wghTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_wghTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_wghTime_DatePicker);
        this.kdtEntrys.getColumn("wghTime").setEditor(kdtEntrys_wghTime_CellEditor);
        KDFormattedTextField kdtEntrys_wgt_TextField = new KDFormattedTextField();
        kdtEntrys_wgt_TextField.setName("kdtEntrys_wgt_TextField");
        kdtEntrys_wgt_TextField.setVisible(true);
        kdtEntrys_wgt_TextField.setEditable(true);
        kdtEntrys_wgt_TextField.setHorizontalAlignment(2);
        kdtEntrys_wgt_TextField.setDataType(1);
        	kdtEntrys_wgt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_wgt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_wgt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_wgt_CellEditor = new KDTDefaultCellEditor(kdtEntrys_wgt_TextField);
        this.kdtEntrys.getColumn("wgt").setEditor(kdtEntrys_wgt_CellEditor);
        KDFormattedTextField kdtEntrys_qty_TextField = new KDFormattedTextField();
        kdtEntrys_qty_TextField.setName("kdtEntrys_qty_TextField");
        kdtEntrys_qty_TextField.setVisible(true);
        kdtEntrys_qty_TextField.setEditable(true);
        kdtEntrys_qty_TextField.setHorizontalAlignment(2);
        kdtEntrys_qty_TextField.setDataType(1);
        	kdtEntrys_qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_qty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qty_TextField);
        this.kdtEntrys.getColumn("qty").setEditor(kdtEntrys_qty_CellEditor);
        // kdtAssEntrys
		String kdtAssEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"wgtType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"wgt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"disRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"wgtAfterDis\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"settleRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"settleWgt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{wgtType}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{wgt}</t:Cell><t:Cell>$Resource{disRate}</t:Cell><t:Cell>$Resource{wgtAfterDis}</t:Cell><t:Cell>$Resource{settleRate}</t:Cell><t:Cell>$Resource{settleWgt}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtAssEntrys.setFormatXml(resHelper.translateString("kdtAssEntrys",kdtAssEntrysStrXML));

                this.kdtAssEntrys.putBindContents("editData",new String[] {"id","wgtType","qty","wgt","disRate","wgtAfterDis","settleRate","settleWgt"});


        this.kdtAssEntrys.checkParsed();
        KDComboBox kdtAssEntrys_wgtType_ComboBox = new KDComboBox();
        kdtAssEntrys_wgtType_ComboBox.setName("kdtAssEntrys_wgtType_ComboBox");
        kdtAssEntrys_wgtType_ComboBox.setVisible(true);
        kdtAssEntrys_wgtType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.taihe.weight.CarcassType").toArray());
        KDTDefaultCellEditor kdtAssEntrys_wgtType_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_wgtType_ComboBox);
        this.kdtAssEntrys.getColumn("wgtType").setEditor(kdtAssEntrys_wgtType_CellEditor);
        KDFormattedTextField kdtAssEntrys_qty_TextField = new KDFormattedTextField();
        kdtAssEntrys_qty_TextField.setName("kdtAssEntrys_qty_TextField");
        kdtAssEntrys_qty_TextField.setVisible(true);
        kdtAssEntrys_qty_TextField.setEditable(true);
        kdtAssEntrys_qty_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_qty_TextField.setDataType(1);
        	kdtAssEntrys_qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtAssEntrys_qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtAssEntrys_qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtAssEntrys_qty_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_qty_TextField);
        this.kdtAssEntrys.getColumn("qty").setEditor(kdtAssEntrys_qty_CellEditor);
        KDFormattedTextField kdtAssEntrys_wgt_TextField = new KDFormattedTextField();
        kdtAssEntrys_wgt_TextField.setName("kdtAssEntrys_wgt_TextField");
        kdtAssEntrys_wgt_TextField.setVisible(true);
        kdtAssEntrys_wgt_TextField.setEditable(true);
        kdtAssEntrys_wgt_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_wgt_TextField.setDataType(1);
        	kdtAssEntrys_wgt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtAssEntrys_wgt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtAssEntrys_wgt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtAssEntrys_wgt_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_wgt_TextField);
        this.kdtAssEntrys.getColumn("wgt").setEditor(kdtAssEntrys_wgt_CellEditor);
        KDFormattedTextField kdtAssEntrys_disRate_TextField = new KDFormattedTextField();
        kdtAssEntrys_disRate_TextField.setName("kdtAssEntrys_disRate_TextField");
        kdtAssEntrys_disRate_TextField.setVisible(true);
        kdtAssEntrys_disRate_TextField.setEditable(true);
        kdtAssEntrys_disRate_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_disRate_TextField.setDataType(1);
        	kdtAssEntrys_disRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtAssEntrys_disRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtAssEntrys_disRate_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtAssEntrys_disRate_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_disRate_TextField);
        this.kdtAssEntrys.getColumn("disRate").setEditor(kdtAssEntrys_disRate_CellEditor);
        KDFormattedTextField kdtAssEntrys_wgtAfterDis_TextField = new KDFormattedTextField();
        kdtAssEntrys_wgtAfterDis_TextField.setName("kdtAssEntrys_wgtAfterDis_TextField");
        kdtAssEntrys_wgtAfterDis_TextField.setVisible(true);
        kdtAssEntrys_wgtAfterDis_TextField.setEditable(true);
        kdtAssEntrys_wgtAfterDis_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_wgtAfterDis_TextField.setDataType(1);
        	kdtAssEntrys_wgtAfterDis_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtAssEntrys_wgtAfterDis_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtAssEntrys_wgtAfterDis_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtAssEntrys_wgtAfterDis_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_wgtAfterDis_TextField);
        this.kdtAssEntrys.getColumn("wgtAfterDis").setEditor(kdtAssEntrys_wgtAfterDis_CellEditor);
        KDFormattedTextField kdtAssEntrys_settleRate_TextField = new KDFormattedTextField();
        kdtAssEntrys_settleRate_TextField.setName("kdtAssEntrys_settleRate_TextField");
        kdtAssEntrys_settleRate_TextField.setVisible(true);
        kdtAssEntrys_settleRate_TextField.setEditable(true);
        kdtAssEntrys_settleRate_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_settleRate_TextField.setDataType(1);
        	kdtAssEntrys_settleRate_TextField.setMinimumValue(new java.math.BigDecimal("-999.999"));
        	kdtAssEntrys_settleRate_TextField.setMaximumValue(new java.math.BigDecimal("999.999"));
        kdtAssEntrys_settleRate_TextField.setPrecision(3);
        KDTDefaultCellEditor kdtAssEntrys_settleRate_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_settleRate_TextField);
        this.kdtAssEntrys.getColumn("settleRate").setEditor(kdtAssEntrys_settleRate_CellEditor);
        KDFormattedTextField kdtAssEntrys_settleWgt_TextField = new KDFormattedTextField();
        kdtAssEntrys_settleWgt_TextField.setName("kdtAssEntrys_settleWgt_TextField");
        kdtAssEntrys_settleWgt_TextField.setVisible(true);
        kdtAssEntrys_settleWgt_TextField.setEditable(true);
        kdtAssEntrys_settleWgt_TextField.setHorizontalAlignment(2);
        kdtAssEntrys_settleWgt_TextField.setDataType(1);
        	kdtAssEntrys_settleWgt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtAssEntrys_settleWgt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtAssEntrys_settleWgt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtAssEntrys_settleWgt_CellEditor = new KDTDefaultCellEditor(kdtAssEntrys_settleWgt_TextField);
        this.kdtAssEntrys.getColumn("settleWgt").setEditor(kdtAssEntrys_settleWgt_CellEditor);
        // kdtOtherEntrys
		String kdtOtherEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"item\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"remark\" t:width=\"300\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{item}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{remark}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtOtherEntrys.setFormatXml(resHelper.translateString("kdtOtherEntrys",kdtOtherEntrysStrXML));

                this.kdtOtherEntrys.putBindContents("editData",new String[] {"id","item","amount","remark"});


        this.kdtOtherEntrys.checkParsed();
        final KDBizPromptBox kdtOtherEntrys_item_PromptBox = new KDBizPromptBox();
        kdtOtherEntrys_item_PromptBox.setQueryInfo("com.kingdee.eas.custom.taihe.settle.app.ThSettleItemQuery");
        kdtOtherEntrys_item_PromptBox.setVisible(true);
        kdtOtherEntrys_item_PromptBox.setEditable(true);
        kdtOtherEntrys_item_PromptBox.setDisplayFormat("$number$");
        kdtOtherEntrys_item_PromptBox.setEditFormat("$number$");
        kdtOtherEntrys_item_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtOtherEntrys_item_CellEditor = new KDTDefaultCellEditor(kdtOtherEntrys_item_PromptBox);
        this.kdtOtherEntrys.getColumn("item").setEditor(kdtOtherEntrys_item_CellEditor);
        ObjectValueRender kdtOtherEntrys_item_OVR = new ObjectValueRender();
        kdtOtherEntrys_item_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtOtherEntrys.getColumn("item").setRenderer(kdtOtherEntrys_item_OVR);
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
        KDTextField kdtOtherEntrys_remark_TextField = new KDTextField();
        kdtOtherEntrys_remark_TextField.setName("kdtOtherEntrys_remark_TextField");
        kdtOtherEntrys_remark_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtOtherEntrys_remark_CellEditor = new KDTDefaultCellEditor(kdtOtherEntrys_remark_TextField);
        this.kdtOtherEntrys.getColumn("remark").setEditor(kdtOtherEntrys_remark_CellEditor);
        // kDPanel1
        // kDPanel3
        // kDPanel4
        // kDPanel2
        // contbatchContract		
        this.contbatchContract.setBoundLabelText(resHelper.getString("contbatchContract.boundLabelText"));		
        this.contbatchContract.setBoundLabelLength(100);		
        this.contbatchContract.setBoundLabelUnderline(true);		
        this.contbatchContract.setVisible(true);
        // contsuccessiveContract		
        this.contsuccessiveContract.setBoundLabelText(resHelper.getString("contsuccessiveContract.boundLabelText"));		
        this.contsuccessiveContract.setBoundLabelLength(100);		
        this.contsuccessiveContract.setBoundLabelUnderline(true);		
        this.contsuccessiveContract.setVisible(true);
        // contcontractType		
        this.contcontractType.setBoundLabelText(resHelper.getString("contcontractType.boundLabelText"));		
        this.contcontractType.setBoundLabelLength(100);		
        this.contcontractType.setBoundLabelUnderline(true);		
        this.contcontractType.setVisible(true);
        // contoriginMtrialPerson		
        this.contoriginMtrialPerson.setBoundLabelText(resHelper.getString("contoriginMtrialPerson.boundLabelText"));		
        this.contoriginMtrialPerson.setBoundLabelLength(100);		
        this.contoriginMtrialPerson.setBoundLabelUnderline(true);		
        this.contoriginMtrialPerson.setVisible(true);
        // contpartyB		
        this.contpartyB.setBoundLabelText(resHelper.getString("contpartyB.boundLabelText"));		
        this.contpartyB.setBoundLabelLength(100);		
        this.contpartyB.setBoundLabelUnderline(true);		
        this.contpartyB.setVisible(true);
        // contiDCardNo		
        this.contiDCardNo.setBoundLabelText(resHelper.getString("contiDCardNo.boundLabelText"));		
        this.contiDCardNo.setBoundLabelLength(100);		
        this.contiDCardNo.setBoundLabelUnderline(true);		
        this.contiDCardNo.setVisible(true);
        // contaccountBank		
        this.contaccountBank.setBoundLabelText(resHelper.getString("contaccountBank.boundLabelText"));		
        this.contaccountBank.setBoundLabelLength(100);		
        this.contaccountBank.setBoundLabelUnderline(true);		
        this.contaccountBank.setVisible(true);
        // contbankAccount		
        this.contbankAccount.setBoundLabelText(resHelper.getString("contbankAccount.boundLabelText"));		
        this.contbankAccount.setBoundLabelLength(100);		
        this.contbankAccount.setBoundLabelUnderline(true);		
        this.contbankAccount.setVisible(true);
        // contfarm		
        this.contfarm.setBoundLabelText(resHelper.getString("contfarm.boundLabelText"));		
        this.contfarm.setBoundLabelLength(100);		
        this.contfarm.setBoundLabelUnderline(true);		
        this.contfarm.setVisible(true);
        // contfarmMnger		
        this.contfarmMnger.setBoundLabelText(resHelper.getString("contfarmMnger.boundLabelText"));		
        this.contfarmMnger.setBoundLabelLength(100);		
        this.contfarmMnger.setBoundLabelUnderline(true);		
        this.contfarmMnger.setVisible(true);
        // continDate		
        this.continDate.setBoundLabelText(resHelper.getString("continDate.boundLabelText"));		
        this.continDate.setBoundLabelLength(100);		
        this.continDate.setBoundLabelUnderline(true);		
        this.continDate.setVisible(true);
        // contdayAge		
        this.contdayAge.setBoundLabelText(resHelper.getString("contdayAge.boundLabelText"));		
        this.contdayAge.setBoundLabelLength(100);		
        this.contdayAge.setBoundLabelUnderline(true);		
        this.contdayAge.setVisible(true);
        // chkFivouchered		
        this.chkFivouchered.setHorizontalAlignment(2);		
        this.chkFivouchered.setText(resHelper.getString("chkFivouchered.text"));		
        this.chkFivouchered.setEnabled(false);
        // contsettlePolicy		
        this.contsettlePolicy.setBoundLabelText(resHelper.getString("contsettlePolicy.boundLabelText"));		
        this.contsettlePolicy.setBoundLabelLength(100);		
        this.contsettlePolicy.setBoundLabelUnderline(true);		
        this.contsettlePolicy.setVisible(true);
        // contawardsPolicy		
        this.contawardsPolicy.setBoundLabelText(resHelper.getString("contawardsPolicy.boundLabelText"));		
        this.contawardsPolicy.setBoundLabelLength(100);		
        this.contawardsPolicy.setBoundLabelUnderline(true);		
        this.contawardsPolicy.setVisible(true);
        // chkhouseBefore		
        this.chkhouseBefore.setText(resHelper.getString("chkhouseBefore.text"));		
        this.chkhouseBefore.setVisible(true);		
        this.chkhouseBefore.setHorizontalAlignment(2);
        // continQty		
        this.continQty.setBoundLabelText(resHelper.getString("continQty.boundLabelText"));		
        this.continQty.setBoundLabelLength(100);		
        this.continQty.setBoundLabelUnderline(true);		
        this.continQty.setVisible(true);
        // chkisQualified		
        this.chkisQualified.setText(resHelper.getString("chkisQualified.text"));		
        this.chkisQualified.setVisible(true);		
        this.chkisQualified.setHorizontalAlignment(2);
        // contfarmAddress		
        this.contfarmAddress.setBoundLabelText(resHelper.getString("contfarmAddress.boundLabelText"));		
        this.contfarmAddress.setBoundLabelLength(100);		
        this.contfarmAddress.setBoundLabelUnderline(true);		
        this.contfarmAddress.setVisible(true);
        // contsupplierAddress		
        this.contsupplierAddress.setBoundLabelText(resHelper.getString("contsupplierAddress.boundLabelText"));		
        this.contsupplierAddress.setBoundLabelLength(100);		
        this.contsupplierAddress.setBoundLabelUnderline(true);		
        this.contsupplierAddress.setVisible(true);
        // chkisdiff		
        this.chkisdiff.setText(resHelper.getString("chkisdiff.text"));		
        this.chkisdiff.setVisible(true);		
        this.chkisdiff.setHorizontalAlignment(2);
        // contdifftxt		
        this.contdifftxt.setBoundLabelText(resHelper.getString("contdifftxt.boundLabelText"));		
        this.contdifftxt.setBoundLabelLength(100);		
        this.contdifftxt.setBoundLabelUnderline(true);		
        this.contdifftxt.setVisible(true);
        // prmtbatchContract		
        this.prmtbatchContract.setQueryInfo("com.kingdee.eas.custom.taihe.contract.app.BatchContractQuery");		
        this.prmtbatchContract.setEditable(true);		
        this.prmtbatchContract.setDisplayFormat("$number$");		
        this.prmtbatchContract.setEditFormat("$number$");		
        this.prmtbatchContract.setCommitFormat("$number$");		
        this.prmtbatchContract.setRequired(false);
        prmtbatchContract.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtbatchContract_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // prmtsuccessiveContract		
        this.prmtsuccessiveContract.setQueryInfo("com.kingdee.eas.custom.taihe.contract.app.SuccessiveContractQuery");		
        this.prmtsuccessiveContract.setEditable(true);		
        this.prmtsuccessiveContract.setDisplayFormat("$number$");		
        this.prmtsuccessiveContract.setEditFormat("$number$");		
        this.prmtsuccessiveContract.setCommitFormat("$number$");		
        this.prmtsuccessiveContract.setRequired(false);
        // prmtcontractType		
        this.prmtcontractType.setQueryInfo("com.kingdee.eas.custom.signwasthetable.app.ContractTypeQuery");		
        this.prmtcontractType.setEditable(true);		
        this.prmtcontractType.setDisplayFormat("$name$");		
        this.prmtcontractType.setEditFormat("$number$");		
        this.prmtcontractType.setCommitFormat("$number$");		
        this.prmtcontractType.setRequired(true);
        // prmtoriginMtrialPerson		
        this.prmtoriginMtrialPerson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtoriginMtrialPerson.setEditable(true);		
        this.prmtoriginMtrialPerson.setDisplayFormat("$name$");		
        this.prmtoriginMtrialPerson.setEditFormat("$number$");		
        this.prmtoriginMtrialPerson.setCommitFormat("$number$");		
        this.prmtoriginMtrialPerson.setRequired(true);
        // prmtpartyB		
        this.prmtpartyB.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.PSupplierQuery");		
        this.prmtpartyB.setEditable(true);		
        this.prmtpartyB.setDisplayFormat("$name$");		
        this.prmtpartyB.setEditFormat("$number$");		
        this.prmtpartyB.setCommitFormat("$number$");		
        this.prmtpartyB.setRequired(true);
        prmtpartyB.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtpartyB_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtiDCardNo		
        this.txtiDCardNo.setHorizontalAlignment(2);		
        this.txtiDCardNo.setMaxLength(100);		
        this.txtiDCardNo.setRequired(false);
        // txtaccountBank		
        this.txtaccountBank.setHorizontalAlignment(2);		
        this.txtaccountBank.setMaxLength(100);		
        this.txtaccountBank.setRequired(false);
        // txtbankAccount		
        this.txtbankAccount.setHorizontalAlignment(2);		
        this.txtbankAccount.setMaxLength(100);		
        this.txtbankAccount.setRequired(false);
        // prmtfarm		
        this.prmtfarm.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmQuery");		
        this.prmtfarm.setEditable(true);		
        this.prmtfarm.setDisplayFormat("$name$");		
        this.prmtfarm.setEditFormat("$number$");		
        this.prmtfarm.setCommitFormat("$number$");		
        this.prmtfarm.setRequired(false);
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

        // txtfarmMnger		
        this.txtfarmMnger.setHorizontalAlignment(2);		
        this.txtfarmMnger.setMaxLength(80);		
        this.txtfarmMnger.setRequired(false);		
        this.txtfarmMnger.setEnabled(false);
        // pkinDate		
        this.pkinDate.setRequired(false);
        // txtdayAge		
        this.txtdayAge.setHorizontalAlignment(2);		
        this.txtdayAge.setMaxLength(100);		
        this.txtdayAge.setRequired(false);
        // prmtsettlePolicy		
        this.prmtsettlePolicy.setQueryInfo("com.kingdee.eas.custom.taihe.settle.app.TaiHeSettlePolicyQuery");		
        this.prmtsettlePolicy.setEditable(true);		
        this.prmtsettlePolicy.setDisplayFormat("$name$");		
        this.prmtsettlePolicy.setEditFormat("$number$");		
        this.prmtsettlePolicy.setCommitFormat("$number$");		
        this.prmtsettlePolicy.setRequired(true);
        prmtsettlePolicy.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtsettlePolicy_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // prmtawardsPolicy		
        this.prmtawardsPolicy.setQueryInfo("com.kingdee.eas.custom.taihe.settle.app.SettleAwardPolicyQuery");		
        this.prmtawardsPolicy.setEditable(true);		
        this.prmtawardsPolicy.setDisplayFormat("$name$");		
        this.prmtawardsPolicy.setEditFormat("$number$");		
        this.prmtawardsPolicy.setCommitFormat("$number$");		
        this.prmtawardsPolicy.setRequired(false);
        prmtawardsPolicy.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtawardsPolicy_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtinQty		
        this.txtinQty.setVisible(true);		
        this.txtinQty.setHorizontalAlignment(2);		
        this.txtinQty.setDataType(1);		
        this.txtinQty.setSupportedEmpty(true);		
        this.txtinQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtinQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtinQty.setPrecision(4);		
        this.txtinQty.setRequired(false);
        // txtfarmAddress		
        this.txtfarmAddress.setVisible(true);		
        this.txtfarmAddress.setHorizontalAlignment(2);		
        this.txtfarmAddress.setMaxLength(80);		
        this.txtfarmAddress.setRequired(false);
        // txtsupplierAddress		
        this.txtsupplierAddress.setVisible(true);		
        this.txtsupplierAddress.setHorizontalAlignment(2);		
        this.txtsupplierAddress.setMaxLength(80);		
        this.txtsupplierAddress.setRequired(false);
        // txtdifftxt		
        this.txtdifftxt.setVisible(true);		
        this.txtdifftxt.setHorizontalAlignment(2);		
        this.txtdifftxt.setMaxLength(100);		
        this.txtdifftxt.setRequired(false);
        // contyieldStd		
        this.contyieldStd.setBoundLabelText(resHelper.getString("contyieldStd.boundLabelText"));		
        this.contyieldStd.setBoundLabelLength(100);		
        this.contyieldStd.setBoundLabelUnderline(true);		
        this.contyieldStd.setVisible(true);
        // contcarcassSettleWgt		
        this.contcarcassSettleWgt.setBoundLabelText(resHelper.getString("contcarcassSettleWgt.boundLabelText"));		
        this.contcarcassSettleWgt.setBoundLabelLength(100);		
        this.contcarcassSettleWgt.setBoundLabelUnderline(true);		
        this.contcarcassSettleWgt.setVisible(true);
        // contstdYeildRate		
        this.contstdYeildRate.setBoundLabelText(resHelper.getString("contstdYeildRate.boundLabelText"));		
        this.contstdYeildRate.setBoundLabelLength(100);		
        this.contstdYeildRate.setBoundLabelUnderline(true);		
        this.contstdYeildRate.setVisible(true);
        // contactualYieldRate		
        this.contactualYieldRate.setBoundLabelText(resHelper.getString("contactualYieldRate.boundLabelText"));		
        this.contactualYieldRate.setBoundLabelLength(100);		
        this.contactualYieldRate.setBoundLabelUnderline(true);		
        this.contactualYieldRate.setVisible(true);
        // conttotalSettleWgt		
        this.conttotalSettleWgt.setBoundLabelText(resHelper.getString("conttotalSettleWgt.boundLabelText"));		
        this.conttotalSettleWgt.setBoundLabelLength(100);		
        this.conttotalSettleWgt.setBoundLabelUnderline(true);		
        this.conttotalSettleWgt.setVisible(true);
        // contsafePrice		
        this.contsafePrice.setBoundLabelText(resHelper.getString("contsafePrice.boundLabelText"));		
        this.contsafePrice.setBoundLabelLength(100);		
        this.contsafePrice.setBoundLabelUnderline(true);		
        this.contsafePrice.setVisible(true);
        // contmarketPrice		
        this.contmarketPrice.setBoundLabelText(resHelper.getString("contmarketPrice.boundLabelText"));		
        this.contmarketPrice.setBoundLabelLength(100);		
        this.contmarketPrice.setBoundLabelUnderline(true);		
        this.contmarketPrice.setVisible(true);
        // contpurchasePrice		
        this.contpurchasePrice.setBoundLabelText(resHelper.getString("contpurchasePrice.boundLabelText"));		
        this.contpurchasePrice.setBoundLabelLength(100);		
        this.contpurchasePrice.setBoundLabelUnderline(true);		
        this.contpurchasePrice.setVisible(true);
        // contqty		
        this.contqty.setBoundLabelText(resHelper.getString("contqty.boundLabelText"));		
        this.contqty.setBoundLabelLength(100);		
        this.contqty.setBoundLabelUnderline(true);		
        this.contqty.setVisible(true);
        // contpurchaseSettleAmt		
        this.contpurchaseSettleAmt.setBoundLabelText(resHelper.getString("contpurchaseSettleAmt.boundLabelText"));		
        this.contpurchaseSettleAmt.setBoundLabelLength(100);		
        this.contpurchaseSettleAmt.setBoundLabelUnderline(true);		
        this.contpurchaseSettleAmt.setVisible(false);
        // contchickenSzQty		
        this.contchickenSzQty.setBoundLabelText(resHelper.getString("contchickenSzQty.boundLabelText"));		
        this.contchickenSzQty.setBoundLabelLength(100);		
        this.contchickenSzQty.setBoundLabelUnderline(true);		
        this.contchickenSzQty.setVisible(true);
        // contchickenSzAmt		
        this.contchickenSzAmt.setBoundLabelText(resHelper.getString("contchickenSzAmt.boundLabelText"));		
        this.contchickenSzAmt.setBoundLabelLength(100);		
        this.contchickenSzAmt.setBoundLabelUnderline(true);		
        this.contchickenSzAmt.setVisible(true);
        // contplusSettleWgt		
        this.contplusSettleWgt.setBoundLabelText(resHelper.getString("contplusSettleWgt.boundLabelText"));		
        this.contplusSettleWgt.setBoundLabelLength(100);		
        this.contplusSettleWgt.setBoundLabelUnderline(true);		
        this.contplusSettleWgt.setVisible(true);
        // contplusPrice		
        this.contplusPrice.setBoundLabelText(resHelper.getString("contplusPrice.boundLabelText"));		
        this.contplusPrice.setBoundLabelLength(100);		
        this.contplusPrice.setBoundLabelUnderline(true);		
        this.contplusPrice.setVisible(true);
        // contchickenSzCoeff		
        this.contchickenSzCoeff.setBoundLabelText(resHelper.getString("contchickenSzCoeff.boundLabelText"));		
        this.contchickenSzCoeff.setBoundLabelLength(100);		
        this.contchickenSzCoeff.setBoundLabelUnderline(true);		
        this.contchickenSzCoeff.setVisible(true);
        // contawardsAmount		
        this.contawardsAmount.setBoundLabelText(resHelper.getString("contawardsAmount.boundLabelText"));		
        this.contawardsAmount.setBoundLabelLength(100);		
        this.contawardsAmount.setBoundLabelUnderline(true);
        // contbasePrice		
        this.contbasePrice.setBoundLabelText(resHelper.getString("contbasePrice.boundLabelText"));		
        this.contbasePrice.setBoundLabelLength(100);		
        this.contbasePrice.setBoundLabelUnderline(true);		
        this.contbasePrice.setVisible(true);
        // conthedingPrice		
        this.conthedingPrice.setBoundLabelText(resHelper.getString("conthedingPrice.boundLabelText"));		
        this.conthedingPrice.setBoundLabelLength(100);		
        this.conthedingPrice.setBoundLabelUnderline(true);		
        this.conthedingPrice.setVisible(true);
        // contfixedCoeff		
        this.contfixedCoeff.setBoundLabelText(resHelper.getString("contfixedCoeff.boundLabelText"));		
        this.contfixedCoeff.setBoundLabelLength(100);		
        this.contfixedCoeff.setBoundLabelUnderline(true);		
        this.contfixedCoeff.setVisible(true);
        // contshareCoeff		
        this.contshareCoeff.setBoundLabelText(resHelper.getString("contshareCoeff.boundLabelText"));		
        this.contshareCoeff.setBoundLabelLength(100);		
        this.contshareCoeff.setBoundLabelUnderline(true);		
        this.contshareCoeff.setVisible(true);
        // contavgWgt		
        this.contavgWgt.setBoundLabelText(resHelper.getString("contavgWgt.boundLabelText"));		
        this.contavgWgt.setBoundLabelLength(100);		
        this.contavgWgt.setBoundLabelUnderline(true);		
        this.contavgWgt.setVisible(true);
        // contchargeStd		
        this.contchargeStd.setBoundLabelText(resHelper.getString("contchargeStd.boundLabelText"));		
        this.contchargeStd.setBoundLabelLength(55);		
        this.contchargeStd.setBoundLabelUnderline(true);		
        this.contchargeStd.setVisible(true);
        // contCSzAverageQty		
        this.contCSzAverageQty.setBoundLabelText(resHelper.getString("contCSzAverageQty.boundLabelText"));		
        this.contCSzAverageQty.setBoundLabelLength(100);		
        this.contCSzAverageQty.setBoundLabelUnderline(true);		
        this.contCSzAverageQty.setVisible(true);
        // txtyieldStd		
        this.txtyieldStd.setHorizontalAlignment(2);		
        this.txtyieldStd.setDataType(1);		
        this.txtyieldStd.setSupportedEmpty(true);		
        this.txtyieldStd.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyieldStd.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyieldStd.setPrecision(4);		
        this.txtyieldStd.setRequired(false);		
        this.txtyieldStd.setEnabled(false);
        // txtcarcassSettleWgt		
        this.txtcarcassSettleWgt.setHorizontalAlignment(2);		
        this.txtcarcassSettleWgt.setDataType(1);		
        this.txtcarcassSettleWgt.setSupportedEmpty(true);		
        this.txtcarcassSettleWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcarcassSettleWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcarcassSettleWgt.setPrecision(4);		
        this.txtcarcassSettleWgt.setRequired(false);		
        this.txtcarcassSettleWgt.setEnabled(false);
        // txtstdYeildRate		
        this.txtstdYeildRate.setHorizontalAlignment(2);		
        this.txtstdYeildRate.setDataType(1);		
        this.txtstdYeildRate.setSupportedEmpty(true);		
        this.txtstdYeildRate.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtstdYeildRate.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtstdYeildRate.setPrecision(4);		
        this.txtstdYeildRate.setRequired(false);
        // txtactualYieldRate		
        this.txtactualYieldRate.setHorizontalAlignment(2);		
        this.txtactualYieldRate.setDataType(1);		
        this.txtactualYieldRate.setSupportedEmpty(true);		
        this.txtactualYieldRate.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtactualYieldRate.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtactualYieldRate.setRequired(false);		
        this.txtactualYieldRate.setEnabled(false);
        // txttotalSettleWgt		
        this.txttotalSettleWgt.setHorizontalAlignment(2);		
        this.txttotalSettleWgt.setDataType(1);		
        this.txttotalSettleWgt.setSupportedEmpty(true);		
        this.txttotalSettleWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttotalSettleWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttotalSettleWgt.setPrecision(2);		
        this.txttotalSettleWgt.setRequired(false);
        // txtsafePrice		
        this.txtsafePrice.setHorizontalAlignment(2);		
        this.txtsafePrice.setDataType(1);		
        this.txtsafePrice.setSupportedEmpty(true);		
        this.txtsafePrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsafePrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsafePrice.setPrecision(4);		
        this.txtsafePrice.setRequired(false);		
        this.txtsafePrice.setEnabled(false);
        // txtmarketPrice		
        this.txtmarketPrice.setHorizontalAlignment(2);		
        this.txtmarketPrice.setDataType(1);		
        this.txtmarketPrice.setSupportedEmpty(true);		
        this.txtmarketPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmarketPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmarketPrice.setPrecision(4);		
        this.txtmarketPrice.setRequired(false);
        // txtpurchasePrice		
        this.txtpurchasePrice.setHorizontalAlignment(2);		
        this.txtpurchasePrice.setDataType(1);		
        this.txtpurchasePrice.setSupportedEmpty(true);		
        this.txtpurchasePrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpurchasePrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpurchasePrice.setPrecision(4);		
        this.txtpurchasePrice.setRequired(false);
        // txtqty		
        this.txtqty.setHorizontalAlignment(2);		
        this.txtqty.setDataType(1);		
        this.txtqty.setSupportedEmpty(true);		
        this.txtqty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtqty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtqty.setPrecision(4);		
        this.txtqty.setRequired(false);		
        this.txtqty.setEnabled(false);
        // txtpurchaseSettleAmt		
        this.txtpurchaseSettleAmt.setHorizontalAlignment(2);		
        this.txtpurchaseSettleAmt.setDataType(1);		
        this.txtpurchaseSettleAmt.setSupportedEmpty(true);		
        this.txtpurchaseSettleAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpurchaseSettleAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpurchaseSettleAmt.setPrecision(2);		
        this.txtpurchaseSettleAmt.setRequired(false);		
        this.txtpurchaseSettleAmt.setEnabled(false);
        // txtchickenSzQty		
        this.txtchickenSzQty.setHorizontalAlignment(2);		
        this.txtchickenSzQty.setDataType(1);		
        this.txtchickenSzQty.setSupportedEmpty(true);		
        this.txtchickenSzQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchickenSzQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchickenSzQty.setPrecision(2);		
        this.txtchickenSzQty.setRequired(false);
        // txtchickenSzAmt		
        this.txtchickenSzAmt.setHorizontalAlignment(2);		
        this.txtchickenSzAmt.setDataType(1);		
        this.txtchickenSzAmt.setSupportedEmpty(true);		
        this.txtchickenSzAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchickenSzAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchickenSzAmt.setPrecision(2);		
        this.txtchickenSzAmt.setRequired(false);		
        this.txtchickenSzAmt.setEnabled(false);
        // txtplusSettleWgt		
        this.txtplusSettleWgt.setHorizontalAlignment(2);		
        this.txtplusSettleWgt.setDataType(1);		
        this.txtplusSettleWgt.setSupportedEmpty(true);		
        this.txtplusSettleWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtplusSettleWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtplusSettleWgt.setPrecision(4);		
        this.txtplusSettleWgt.setRequired(false);
        // txtplusPrice		
        this.txtplusPrice.setHorizontalAlignment(2);		
        this.txtplusPrice.setDataType(1);		
        this.txtplusPrice.setSupportedEmpty(true);		
        this.txtplusPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtplusPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtplusPrice.setPrecision(4);		
        this.txtplusPrice.setRequired(false);
        // txtchickenSzCoeff		
        this.txtchickenSzCoeff.setHorizontalAlignment(2);		
        this.txtchickenSzCoeff.setDataType(1);		
        this.txtchickenSzCoeff.setSupportedEmpty(true);		
        this.txtchickenSzCoeff.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchickenSzCoeff.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchickenSzCoeff.setPrecision(4);		
        this.txtchickenSzCoeff.setRequired(false);		
        this.txtchickenSzCoeff.setEnabled(false);
        // txtawardsAmount		
        this.txtawardsAmount.setHorizontalAlignment(2);		
        this.txtawardsAmount.setDataType(1);		
        this.txtawardsAmount.setSupportedEmpty(true);		
        this.txtawardsAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtawardsAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtawardsAmount.setPrecision(2);		
        this.txtawardsAmount.setRequired(false);
        // txtbasePrice		
        this.txtbasePrice.setHorizontalAlignment(2);		
        this.txtbasePrice.setDataType(1);		
        this.txtbasePrice.setSupportedEmpty(true);		
        this.txtbasePrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbasePrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbasePrice.setPrecision(4);		
        this.txtbasePrice.setRequired(false);		
        this.txtbasePrice.setEnabled(false);
        // txthedingPrice		
        this.txthedingPrice.setHorizontalAlignment(2);		
        this.txthedingPrice.setDataType(1);		
        this.txthedingPrice.setSupportedEmpty(true);		
        this.txthedingPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txthedingPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txthedingPrice.setPrecision(4);		
        this.txthedingPrice.setRequired(false);		
        this.txthedingPrice.setEnabled(false);
        // txtfixedCoeff		
        this.txtfixedCoeff.setHorizontalAlignment(2);		
        this.txtfixedCoeff.setDataType(1);		
        this.txtfixedCoeff.setSupportedEmpty(true);		
        this.txtfixedCoeff.setMinimumValue( new java.math.BigDecimal("-999.999"));		
        this.txtfixedCoeff.setMaximumValue( new java.math.BigDecimal("999.999"));		
        this.txtfixedCoeff.setPrecision(3);		
        this.txtfixedCoeff.setRequired(false);		
        this.txtfixedCoeff.setEnabled(false);
        // txtshareCoeff		
        this.txtshareCoeff.setHorizontalAlignment(2);		
        this.txtshareCoeff.setDataType(1);		
        this.txtshareCoeff.setSupportedEmpty(true);		
        this.txtshareCoeff.setMinimumValue( new java.math.BigDecimal("-999.999"));		
        this.txtshareCoeff.setMaximumValue( new java.math.BigDecimal("999.999"));		
        this.txtshareCoeff.setPrecision(3);		
        this.txtshareCoeff.setRequired(false);		
        this.txtshareCoeff.setEnabled(false);
        // txtavgWgt		
        this.txtavgWgt.setHorizontalAlignment(2);		
        this.txtavgWgt.setDataType(1);		
        this.txtavgWgt.setSupportedEmpty(true);		
        this.txtavgWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtavgWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtavgWgt.setPrecision(4);		
        this.txtavgWgt.setRequired(false);		
        this.txtavgWgt.setEnabled(false);
        // txtchargeStd		
        this.txtchargeStd.setVisible(true);		
        this.txtchargeStd.setHorizontalAlignment(2);		
        this.txtchargeStd.setDataType(1);		
        this.txtchargeStd.setSupportedEmpty(true);		
        this.txtchargeStd.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchargeStd.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchargeStd.setPrecision(2);		
        this.txtchargeStd.setRequired(false);		
        this.txtchargeStd.setEnabled(false);
        // txtCSzAverageQty		
        this.txtCSzAverageQty.setVisible(true);		
        this.txtCSzAverageQty.setHorizontalAlignment(2);		
        this.txtCSzAverageQty.setDataType(1);		
        this.txtCSzAverageQty.setSupportedEmpty(true);		
        this.txtCSzAverageQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtCSzAverageQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtCSzAverageQty.setPrecision(4);		
        this.txtCSzAverageQty.setRequired(false);
        // contstdMiles		
        this.contstdMiles.setBoundLabelText(resHelper.getString("contstdMiles.boundLabelText"));		
        this.contstdMiles.setBoundLabelLength(100);		
        this.contstdMiles.setBoundLabelUnderline(true);		
        this.contstdMiles.setVisible(true);
        // contactualMiles		
        this.contactualMiles.setBoundLabelText(resHelper.getString("contactualMiles.boundLabelText"));		
        this.contactualMiles.setBoundLabelLength(100);		
        this.contactualMiles.setBoundLabelUnderline(true);		
        this.contactualMiles.setVisible(true);
        // contsuppFreAmt		
        this.contsuppFreAmt.setBoundLabelText(resHelper.getString("contsuppFreAmt.boundLabelText"));		
        this.contsuppFreAmt.setBoundLabelLength(100);		
        this.contsuppFreAmt.setBoundLabelUnderline(true);		
        this.contsuppFreAmt.setVisible(true);
        // contselfFrePrice		
        this.contselfFrePrice.setBoundLabelText(resHelper.getString("contselfFrePrice.boundLabelText"));		
        this.contselfFrePrice.setBoundLabelLength(100);		
        this.contselfFrePrice.setBoundLabelUnderline(true);		
        this.contselfFrePrice.setVisible(true);
        // contactulSettleFreAmt		
        this.contactulSettleFreAmt.setBoundLabelText(resHelper.getString("contactulSettleFreAmt.boundLabelText"));		
        this.contactulSettleFreAmt.setBoundLabelLength(100);		
        this.contactulSettleFreAmt.setBoundLabelUnderline(true);		
        this.contactulSettleFreAmt.setVisible(true);
        // contCarriageFormat		
        this.contCarriageFormat.setBoundLabelText(resHelper.getString("contCarriageFormat.boundLabelText"));		
        this.contCarriageFormat.setBoundLabelLength(100);		
        this.contCarriageFormat.setBoundLabelUnderline(true);		
        this.contCarriageFormat.setVisible(true);
        // contcar		
        this.contcar.setBoundLabelText(resHelper.getString("contcar.boundLabelText"));		
        this.contcar.setBoundLabelLength(100);		
        this.contcar.setBoundLabelUnderline(true);		
        this.contcar.setVisible(true);
        // contactualFreAmt		
        this.contactualFreAmt.setBoundLabelText(resHelper.getString("contactualFreAmt.boundLabelText"));		
        this.contactualFreAmt.setBoundLabelLength(100);		
        this.contactualFreAmt.setBoundLabelUnderline(true);		
        this.contactualFreAmt.setVisible(true);
        // contselfFreAmt		
        this.contselfFreAmt.setBoundLabelText(resHelper.getString("contselfFreAmt.boundLabelText"));		
        this.contselfFreAmt.setBoundLabelLength(100);		
        this.contselfFreAmt.setBoundLabelUnderline(true);		
        this.contselfFreAmt.setVisible(true);
        // contbasketQty		
        this.contbasketQty.setBoundLabelText(resHelper.getString("contbasketQty.boundLabelText"));		
        this.contbasketQty.setBoundLabelLength(100);		
        this.contbasketQty.setBoundLabelUnderline(true);		
        this.contbasketQty.setVisible(true);
        // txtstdMiles		
        this.txtstdMiles.setHorizontalAlignment(2);		
        this.txtstdMiles.setDataType(1);		
        this.txtstdMiles.setSupportedEmpty(true);		
        this.txtstdMiles.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtstdMiles.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtstdMiles.setPrecision(4);		
        this.txtstdMiles.setRequired(false);		
        this.txtstdMiles.setEnabled(false);
        // txtactualMiles		
        this.txtactualMiles.setHorizontalAlignment(2);		
        this.txtactualMiles.setDataType(1);		
        this.txtactualMiles.setSupportedEmpty(true);		
        this.txtactualMiles.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtactualMiles.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtactualMiles.setPrecision(4);		
        this.txtactualMiles.setRequired(true);
        // txtsuppFreAmt		
        this.txtsuppFreAmt.setHorizontalAlignment(2);		
        this.txtsuppFreAmt.setDataType(1);		
        this.txtsuppFreAmt.setSupportedEmpty(true);		
        this.txtsuppFreAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsuppFreAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsuppFreAmt.setPrecision(2);		
        this.txtsuppFreAmt.setRequired(false);
        // txtselfFrePrice		
        this.txtselfFrePrice.setHorizontalAlignment(2);		
        this.txtselfFrePrice.setDataType(1);		
        this.txtselfFrePrice.setSupportedEmpty(true);		
        this.txtselfFrePrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtselfFrePrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtselfFrePrice.setPrecision(4);		
        this.txtselfFrePrice.setRequired(false);
        // txtactulSettleFreAmt		
        this.txtactulSettleFreAmt.setHorizontalAlignment(2);		
        this.txtactulSettleFreAmt.setDataType(1);		
        this.txtactulSettleFreAmt.setSupportedEmpty(true);		
        this.txtactulSettleFreAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtactulSettleFreAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtactulSettleFreAmt.setPrecision(2);		
        this.txtactulSettleFreAmt.setRequired(false);		
        this.txtactulSettleFreAmt.setEnabled(false);
        // prmtCarriageFormat		
        this.prmtCarriageFormat.setQueryInfo("com.kingdee.eas.farm.feemanager.basedata.app.CarriageFormatQuery");		
        this.prmtCarriageFormat.setEditable(true);		
        this.prmtCarriageFormat.setDisplayFormat("$carriagename$");		
        this.prmtCarriageFormat.setEditFormat("$number$");		
        this.prmtCarriageFormat.setCommitFormat("$number$");		
        this.prmtCarriageFormat.setRequired(true);
        		prmtCarriageFormat.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.CarriageFormatListUI prmtCarriageFormat_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtCarriageFormat_F7ListUI == null) {
					try {
						prmtCarriageFormat_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.CarriageFormatListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtCarriageFormat_F7ListUI));
					prmtCarriageFormat_F7ListUI.setF7Use(true,ctx);
					prmtCarriageFormat.setSelector(prmtCarriageFormat_F7ListUI);
				}
			}
		});
					
        // prmtcar		
        this.prmtcar.setQueryInfo("com.kingdee.eas.publicdata.app.CarQuery");		
        this.prmtcar.setEditable(true);		
        this.prmtcar.setDisplayFormat("$number$");		
        this.prmtcar.setEditFormat("$number$");		
        this.prmtcar.setCommitFormat("$number$");		
        this.prmtcar.setRequired(true);
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
					
        // txtactualFreAmt		
        this.txtactualFreAmt.setHorizontalAlignment(2);		
        this.txtactualFreAmt.setDataType(1);		
        this.txtactualFreAmt.setSupportedEmpty(true);		
        this.txtactualFreAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtactualFreAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtactualFreAmt.setPrecision(2);		
        this.txtactualFreAmt.setRequired(false);
        // txtselfFreAmt		
        this.txtselfFreAmt.setHorizontalAlignment(2);		
        this.txtselfFreAmt.setDataType(1);		
        this.txtselfFreAmt.setSupportedEmpty(true);		
        this.txtselfFreAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtselfFreAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtselfFreAmt.setPrecision(2);		
        this.txtselfFreAmt.setRequired(false);
        // txtbasketQty		
        this.txtbasketQty.setHorizontalAlignment(2);		
        this.txtbasketQty.setDataType(1);		
        this.txtbasketQty.setSupportedEmpty(true);		
        this.txtbasketQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbasketQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbasketQty.setPrecision(4);		
        this.txtbasketQty.setRequired(false);
        // contotherAmount		
        this.contotherAmount.setBoundLabelText(resHelper.getString("contotherAmount.boundLabelText"));		
        this.contotherAmount.setBoundLabelLength(100);		
        this.contotherAmount.setBoundLabelUnderline(true);		
        this.contotherAmount.setVisible(true);
        // chkbuyComplete		
        this.chkbuyComplete.setText(resHelper.getString("chkbuyComplete.text"));		
        this.chkbuyComplete.setVisible(true);		
        this.chkbuyComplete.setHorizontalAlignment(2);
        // txtotherAmount		
        this.txtotherAmount.setHorizontalAlignment(2);		
        this.txtotherAmount.setDataType(1);		
        this.txtotherAmount.setSupportedEmpty(true);		
        this.txtotherAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtotherAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtotherAmount.setPrecision(2);		
        this.txtotherAmount.setRequired(false);		
        this.txtotherAmount.setEnabled(false);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
        // purchaseMthod		
        this.purchaseMthod.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.taihe.weight.PurchaseMethod").toArray());		
        this.purchaseMthod.setRequired(false);
        // purchaseType		
        this.purchaseType.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.taihe.weight.PurchaseType").toArray());		
        this.purchaseType.setRequired(true);
        // pkrecycleDate		
        this.pkrecycleDate.setRequired(true);
        // prmtcarSendBill		
        this.prmtcarSendBill.setQueryInfo("com.kingdee.eas.custom.taihe.weight.app.CarSendBillQuery");		
        this.prmtcarSendBill.setEditable(true);		
        this.prmtcarSendBill.setDisplayFormat("$number$");		
        this.prmtcarSendBill.setEditFormat("$number$");		
        this.prmtcarSendBill.setCommitFormat("$number$");		
        this.prmtcarSendBill.setRequired(true);
        prmtcarSendBill.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtcarSendBill_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txttotalSettleAmt		
        this.txttotalSettleAmt.setHorizontalAlignment(2);		
        this.txttotalSettleAmt.setDataType(1);		
        this.txttotalSettleAmt.setSupportedEmpty(true);		
        this.txttotalSettleAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttotalSettleAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttotalSettleAmt.setPrecision(2);		
        this.txttotalSettleAmt.setRequired(false);		
        this.txttotalSettleAmt.setEnabled(false);
        // txtstdFrePrice		
        this.txtstdFrePrice.setHorizontalAlignment(2);		
        this.txtstdFrePrice.setDataType(1);		
        this.txtstdFrePrice.setSupportedEmpty(true);		
        this.txtstdFrePrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtstdFrePrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtstdFrePrice.setPrecision(4);		
        this.txtstdFrePrice.setRequired(false);
        // btnExecute
        this.btnExecute.setAction((IItemAction)ActionProxyFactory.getProxy(actionExecute, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnExecute.setText(resHelper.getString("btnExecute.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtAuditor,txtDescription,pkBizDate,txtNumber,prmtcompany,purchaseMthod,purchaseType,prmtcarSendBill,billStatus,pkauditTime,prmtbatchContract,prmtsuccessiveContract,prmtcontractType,pkrecycleDate,prmtoriginMtrialPerson,prmtpartyB,txtiDCardNo,txtaccountBank,txtbankAccount,prmtfarm,txtfarmMnger,pkinDate,txtdayAge,txtstdMiles,txtactualMiles,txtstdFrePrice,txtsuppFreAmt,txtactulSettleFreAmt,txtselfFrePrice,txtyieldStd,txtcarcassSettleWgt,txtstdYeildRate,txtactualYieldRate,kdtOtherEntrys,txttotalSettleWgt,txtsafePrice,txtmarketPrice,txtpurchasePrice,txttotalSettleAmt,txtqty,kdtAssEntrys,txtbasketQty,txtpurchaseSettleAmt,prmtCarriageFormat,txtchickenSzQty,txtchickenSzAmt,prmtcar,txtactualFreAmt,txtselfFreAmt,txtotherAmount,txtawardsAmount,prmtauditTime,chkFivouchered,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,kdtEntrys,prmtCreator,txtplusSettleWgt,txtplusPrice,txtchickenSzCoeff,prmtsettlePolicy,prmtawardsPolicy,txtbasePrice,txthedingPrice,txtfixedCoeff,txtshareCoeff,txtavgWgt,chkbuyComplete,txtchargeStd,chkhouseBefore,txtinQty,chkisQualified,txtCSzAverageQty,txtfarmAddress,txtsupplierAddress,chkisdiff,txtdifftxt}));
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
        contCreator.setBounds(new Rectangle(351, 576, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(351, 576, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(729, 576, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(729, 576, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(351, 598, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(351, 598, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(729, 598, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(729, 598, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(10, 11, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(10, 11, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(347, 11, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(347, 11, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(13, 576, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(13, 576, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(13, 598, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(13, 598, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(685, 11, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(685, 11, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        paneBIZLayerControl17.setBounds(new Rectangle(4, 348, 993, 225));
        this.add(paneBIZLayerControl17, new KDLayout.Constraints(4, 348, 993, 225, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDTabbedPane1.setBounds(new Rectangle(9, 78, 990, 267));
        this.add(kDTabbedPane1, new KDLayout.Constraints(9, 78, 990, 267, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompany.setBounds(new Rectangle(10, 33, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(10, 33, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpurchaseMthod.setBounds(new Rectangle(347, 33, 270, 19));
        this.add(contpurchaseMthod, new KDLayout.Constraints(347, 33, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpurchaseType.setBounds(new Rectangle(685, 33, 270, 19));
        this.add(contpurchaseType, new KDLayout.Constraints(685, 33, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contrecycleDate.setBounds(new Rectangle(347, 55, 270, 19));
        this.add(contrecycleDate, new KDLayout.Constraints(347, 55, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcarSendBill.setBounds(new Rectangle(10, 55, 270, 19));
        this.add(contcarSendBill, new KDLayout.Constraints(10, 55, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttotalSettleAmt.setBounds(new Rectangle(685, 55, 270, 19));
        this.add(conttotalSettleAmt, new KDLayout.Constraints(685, 55, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contstdFrePrice.setBounds(new Rectangle(979, 55, 270, 19));
        this.add(contstdFrePrice, new KDLayout.Constraints(979, 55, 270, 19, 0));
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
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        contauditTime.setBoundEditor(prmtauditTime);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //paneBIZLayerControl17
        paneBIZLayerControl17.add(baseTab, resHelper.getString("baseTab.constraints"));
        paneBIZLayerControl17.add(assTab, resHelper.getString("assTab.constraints"));
        paneBIZLayerControl17.add(otherTab, resHelper.getString("otherTab.constraints"));
        //baseTab
        baseTab.setLayout(new KDLayout());
        baseTab.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 192));        kdtEntrys.setBounds(new Rectangle(6, 6, 980, 186));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.custom.taihe.settle.SettleBillEntryInfo(),null,false);
        baseTab.add(kdtEntrys_detailPanel, new KDLayout.Constraints(6, 6, 980, 186, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //assTab
        assTab.setLayout(new KDLayout());
        assTab.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 192));        kdtAssEntrys.setBounds(new Rectangle(6, 4, 979, 189));
        kdtAssEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtAssEntrys,new com.kingdee.eas.custom.taihe.settle.SettleBillAssEntryInfo(),null,false);
        assTab.add(kdtAssEntrys_detailPanel, new KDLayout.Constraints(6, 4, 979, 189, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //otherTab
        otherTab.setLayout(new KDLayout());
        otherTab.putClientProperty("OriginalBounds", new Rectangle(0, 0, 992, 192));        kdtOtherEntrys.setBounds(new Rectangle(6, 7, 977, 185));
        kdtOtherEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtOtherEntrys,new com.kingdee.eas.custom.taihe.settle.SettleBillOtherEntryInfo(),null,false);
        otherTab.add(kdtOtherEntrys_detailPanel, new KDLayout.Constraints(6, 7, 977, 185, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        kDTabbedPane1.add(kDPanel4, resHelper.getString("kDPanel4.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 989, 234));        contDescription.setBounds(new Rectangle(690, 195, 270, 19));
        kDPanel1.add(contDescription, new KDLayout.Constraints(690, 195, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbatchContract.setBounds(new Rectangle(9, 12, 270, 19));
        kDPanel1.add(contbatchContract, new KDLayout.Constraints(9, 12, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsuccessiveContract.setBounds(new Rectangle(337, 12, 270, 19));
        kDPanel1.add(contsuccessiveContract, new KDLayout.Constraints(337, 12, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcontractType.setBounds(new Rectangle(690, 12, 270, 19));
        kDPanel1.add(contcontractType, new KDLayout.Constraints(690, 12, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contoriginMtrialPerson.setBounds(new Rectangle(690, 42, 270, 19));
        kDPanel1.add(contoriginMtrialPerson, new KDLayout.Constraints(690, 42, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contpartyB.setBounds(new Rectangle(9, 42, 270, 19));
        kDPanel1.add(contpartyB, new KDLayout.Constraints(9, 42, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contiDCardNo.setBounds(new Rectangle(337, 42, 270, 19));
        kDPanel1.add(contiDCardNo, new KDLayout.Constraints(337, 42, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contaccountBank.setBounds(new Rectangle(9, 72, 270, 19));
        kDPanel1.add(contaccountBank, new KDLayout.Constraints(9, 72, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbankAccount.setBounds(new Rectangle(337, 72, 270, 19));
        kDPanel1.add(contbankAccount, new KDLayout.Constraints(337, 72, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarm.setBounds(new Rectangle(9, 102, 270, 19));
        kDPanel1.add(contfarm, new KDLayout.Constraints(9, 102, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmMnger.setBounds(new Rectangle(337, 102, 270, 19));
        kDPanel1.add(contfarmMnger, new KDLayout.Constraints(337, 102, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        continDate.setBounds(new Rectangle(690, 72, 270, 19));
        kDPanel1.add(continDate, new KDLayout.Constraints(690, 72, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contdayAge.setBounds(new Rectangle(9, 134, 270, 19));
        kDPanel1.add(contdayAge, new KDLayout.Constraints(9, 134, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkFivouchered.setBounds(new Rectangle(110, 164, 108, 19));
        kDPanel1.add(chkFivouchered, new KDLayout.Constraints(110, 164, 108, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsettlePolicy.setBounds(new Rectangle(337, 134, 270, 19));
        kDPanel1.add(contsettlePolicy, new KDLayout.Constraints(337, 134, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contawardsPolicy.setBounds(new Rectangle(690, 134, 270, 19));
        kDPanel1.add(contawardsPolicy, new KDLayout.Constraints(690, 134, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkhouseBefore.setBounds(new Rectangle(9, 164, 87, 19));
        kDPanel1.add(chkhouseBefore, new KDLayout.Constraints(9, 164, 87, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        continQty.setBounds(new Rectangle(690, 102, 270, 19));
        kDPanel1.add(continQty, new KDLayout.Constraints(690, 102, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkisQualified.setBounds(new Rectangle(9, 185, 88, 19));
        kDPanel1.add(chkisQualified, new KDLayout.Constraints(9, 185, 88, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmAddress.setBounds(new Rectangle(690, 164, 270, 19));
        kDPanel1.add(contfarmAddress, new KDLayout.Constraints(690, 164, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contsupplierAddress.setBounds(new Rectangle(337, 164, 270, 19));
        kDPanel1.add(contsupplierAddress, new KDLayout.Constraints(337, 164, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisdiff.setBounds(new Rectangle(9, 205, 84, 19));
        kDPanel1.add(chkisdiff, new KDLayout.Constraints(9, 205, 84, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdifftxt.setBounds(new Rectangle(337, 195, 270, 19));
        kDPanel1.add(contdifftxt, new KDLayout.Constraints(337, 195, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contDescription
        contDescription.setBoundEditor(txtDescription);
        //contbatchContract
        contbatchContract.setBoundEditor(prmtbatchContract);
        //contsuccessiveContract
        contsuccessiveContract.setBoundEditor(prmtsuccessiveContract);
        //contcontractType
        contcontractType.setBoundEditor(prmtcontractType);
        //contoriginMtrialPerson
        contoriginMtrialPerson.setBoundEditor(prmtoriginMtrialPerson);
        //contpartyB
        contpartyB.setBoundEditor(prmtpartyB);
        //contiDCardNo
        contiDCardNo.setBoundEditor(txtiDCardNo);
        //contaccountBank
        contaccountBank.setBoundEditor(txtaccountBank);
        //contbankAccount
        contbankAccount.setBoundEditor(txtbankAccount);
        //contfarm
        contfarm.setBoundEditor(prmtfarm);
        //contfarmMnger
        contfarmMnger.setBoundEditor(txtfarmMnger);
        //continDate
        continDate.setBoundEditor(pkinDate);
        //contdayAge
        contdayAge.setBoundEditor(txtdayAge);
        //contsettlePolicy
        contsettlePolicy.setBoundEditor(prmtsettlePolicy);
        //contawardsPolicy
        contawardsPolicy.setBoundEditor(prmtawardsPolicy);
        //continQty
        continQty.setBoundEditor(txtinQty);
        //contfarmAddress
        contfarmAddress.setBoundEditor(txtfarmAddress);
        //contsupplierAddress
        contsupplierAddress.setBoundEditor(txtsupplierAddress);
        //contdifftxt
        contdifftxt.setBoundEditor(txtdifftxt);
        //kDPanel3
        kDPanel3.setLayout(new KDLayout());
        kDPanel3.putClientProperty("OriginalBounds", new Rectangle(0, 0, 989, 234));        contyieldStd.setBounds(new Rectangle(676, 38, 270, 19));
        kDPanel3.add(contyieldStd, new KDLayout.Constraints(676, 38, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcarcassSettleWgt.setBounds(new Rectangle(12, 38, 270, 19));
        kDPanel3.add(contcarcassSettleWgt, new KDLayout.Constraints(12, 38, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contstdYeildRate.setBounds(new Rectangle(346, 38, 270, 19));
        kDPanel3.add(contstdYeildRate, new KDLayout.Constraints(346, 38, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contactualYieldRate.setBounds(new Rectangle(346, 66, 270, 19));
        kDPanel3.add(contactualYieldRate, new KDLayout.Constraints(346, 66, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttotalSettleWgt.setBounds(new Rectangle(12, 66, 270, 19));
        kDPanel3.add(conttotalSettleWgt, new KDLayout.Constraints(12, 66, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsafePrice.setBounds(new Rectangle(12, 150, 270, 19));
        kDPanel3.add(contsafePrice, new KDLayout.Constraints(12, 150, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmarketPrice.setBounds(new Rectangle(676, 10, 270, 19));
        kDPanel3.add(contmarketPrice, new KDLayout.Constraints(676, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contpurchasePrice.setBounds(new Rectangle(346, 10, 270, 19));
        kDPanel3.add(contpurchasePrice, new KDLayout.Constraints(346, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contqty.setBounds(new Rectangle(12, 10, 270, 19));
        kDPanel3.add(contqty, new KDLayout.Constraints(12, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpurchaseSettleAmt.setBounds(new Rectangle(676, 66, 270, 19));
        kDPanel3.add(contpurchaseSettleAmt, new KDLayout.Constraints(676, 66, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contchickenSzQty.setBounds(new Rectangle(12, 122, 270, 19));
        kDPanel3.add(contchickenSzQty, new KDLayout.Constraints(12, 122, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contchickenSzAmt.setBounds(new Rectangle(676, 122, 270, 19));
        kDPanel3.add(contchickenSzAmt, new KDLayout.Constraints(676, 122, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contplusSettleWgt.setBounds(new Rectangle(12, 94, 270, 19));
        kDPanel3.add(contplusSettleWgt, new KDLayout.Constraints(12, 94, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contplusPrice.setBounds(new Rectangle(346, 94, 270, 19));
        kDPanel3.add(contplusPrice, new KDLayout.Constraints(346, 94, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contchickenSzCoeff.setBounds(new Rectangle(346, 122, 130, 19));
        kDPanel3.add(contchickenSzCoeff, new KDLayout.Constraints(346, 122, 130, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contawardsAmount.setBounds(new Rectangle(676, 94, 270, 19));
        kDPanel3.add(contawardsAmount, new KDLayout.Constraints(676, 94, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbasePrice.setBounds(new Rectangle(346, 150, 270, 19));
        kDPanel3.add(contbasePrice, new KDLayout.Constraints(346, 150, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conthedingPrice.setBounds(new Rectangle(676, 150, 270, 19));
        kDPanel3.add(conthedingPrice, new KDLayout.Constraints(676, 150, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfixedCoeff.setBounds(new Rectangle(12, 178, 270, 19));
        kDPanel3.add(contfixedCoeff, new KDLayout.Constraints(12, 178, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contshareCoeff.setBounds(new Rectangle(346, 178, 270, 19));
        kDPanel3.add(contshareCoeff, new KDLayout.Constraints(346, 178, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contavgWgt.setBounds(new Rectangle(676, 178, 270, 19));
        kDPanel3.add(contavgWgt, new KDLayout.Constraints(676, 178, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contchargeStd.setBounds(new Rectangle(486, 122, 130, 19));
        kDPanel3.add(contchargeStd, new KDLayout.Constraints(486, 122, 130, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCSzAverageQty.setBounds(new Rectangle(12, 209, 270, 19));
        kDPanel3.add(contCSzAverageQty, new KDLayout.Constraints(12, 209, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contyieldStd
        contyieldStd.setBoundEditor(txtyieldStd);
        //contcarcassSettleWgt
        contcarcassSettleWgt.setBoundEditor(txtcarcassSettleWgt);
        //contstdYeildRate
        contstdYeildRate.setBoundEditor(txtstdYeildRate);
        //contactualYieldRate
        contactualYieldRate.setBoundEditor(txtactualYieldRate);
        //conttotalSettleWgt
        conttotalSettleWgt.setBoundEditor(txttotalSettleWgt);
        //contsafePrice
        contsafePrice.setBoundEditor(txtsafePrice);
        //contmarketPrice
        contmarketPrice.setBoundEditor(txtmarketPrice);
        //contpurchasePrice
        contpurchasePrice.setBoundEditor(txtpurchasePrice);
        //contqty
        contqty.setBoundEditor(txtqty);
        //contpurchaseSettleAmt
        contpurchaseSettleAmt.setBoundEditor(txtpurchaseSettleAmt);
        //contchickenSzQty
        contchickenSzQty.setBoundEditor(txtchickenSzQty);
        //contchickenSzAmt
        contchickenSzAmt.setBoundEditor(txtchickenSzAmt);
        //contplusSettleWgt
        contplusSettleWgt.setBoundEditor(txtplusSettleWgt);
        //contplusPrice
        contplusPrice.setBoundEditor(txtplusPrice);
        //contchickenSzCoeff
        contchickenSzCoeff.setBoundEditor(txtchickenSzCoeff);
        //contawardsAmount
        contawardsAmount.setBoundEditor(txtawardsAmount);
        //contbasePrice
        contbasePrice.setBoundEditor(txtbasePrice);
        //conthedingPrice
        conthedingPrice.setBoundEditor(txthedingPrice);
        //contfixedCoeff
        contfixedCoeff.setBoundEditor(txtfixedCoeff);
        //contshareCoeff
        contshareCoeff.setBoundEditor(txtshareCoeff);
        //contavgWgt
        contavgWgt.setBoundEditor(txtavgWgt);
        //contchargeStd
        contchargeStd.setBoundEditor(txtchargeStd);
        //contCSzAverageQty
        contCSzAverageQty.setBoundEditor(txtCSzAverageQty);
        //kDPanel4
        kDPanel4.setLayout(new KDLayout());
        kDPanel4.putClientProperty("OriginalBounds", new Rectangle(0, 0, 989, 234));        contstdMiles.setBounds(new Rectangle(8, 50, 270, 19));
        kDPanel4.add(contstdMiles, new KDLayout.Constraints(8, 50, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contactualMiles.setBounds(new Rectangle(8, 84, 270, 19));
        kDPanel4.add(contactualMiles, new KDLayout.Constraints(8, 84, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsuppFreAmt.setBounds(new Rectangle(690, 84, 270, 19));
        kDPanel4.add(contsuppFreAmt, new KDLayout.Constraints(690, 84, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contselfFrePrice.setBounds(new Rectangle(347, 49, 270, 19));
        kDPanel4.add(contselfFrePrice, new KDLayout.Constraints(347, 49, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contactulSettleFreAmt.setBounds(new Rectangle(8, 120, 270, 19));
        kDPanel4.add(contactulSettleFreAmt, new KDLayout.Constraints(8, 120, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCarriageFormat.setBounds(new Rectangle(347, 16, 270, 19));
        kDPanel4.add(contCarriageFormat, new KDLayout.Constraints(347, 16, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcar.setBounds(new Rectangle(8, 16, 270, 19));
        kDPanel4.add(contcar, new KDLayout.Constraints(8, 16, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contactualFreAmt.setBounds(new Rectangle(347, 84, 270, 19));
        kDPanel4.add(contactualFreAmt, new KDLayout.Constraints(347, 84, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contselfFreAmt.setBounds(new Rectangle(690, 49, 270, 19));
        kDPanel4.add(contselfFreAmt, new KDLayout.Constraints(690, 49, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbasketQty.setBounds(new Rectangle(690, 16, 270, 19));
        kDPanel4.add(contbasketQty, new KDLayout.Constraints(690, 16, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contstdMiles
        contstdMiles.setBoundEditor(txtstdMiles);
        //contactualMiles
        contactualMiles.setBoundEditor(txtactualMiles);
        //contsuppFreAmt
        contsuppFreAmt.setBoundEditor(txtsuppFreAmt);
        //contselfFrePrice
        contselfFrePrice.setBoundEditor(txtselfFrePrice);
        //contactulSettleFreAmt
        contactulSettleFreAmt.setBoundEditor(txtactulSettleFreAmt);
        //contCarriageFormat
        contCarriageFormat.setBoundEditor(prmtCarriageFormat);
        //contcar
        contcar.setBoundEditor(prmtcar);
        //contactualFreAmt
        contactualFreAmt.setBoundEditor(txtactualFreAmt);
        //contselfFreAmt
        contselfFreAmt.setBoundEditor(txtselfFreAmt);
        //contbasketQty
        contbasketQty.setBoundEditor(txtbasketQty);
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 989, 234));        contotherAmount.setBounds(new Rectangle(20, 13, 270, 19));
        kDPanel2.add(contotherAmount, new KDLayout.Constraints(20, 13, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkbuyComplete.setBounds(new Rectangle(343, 13, 107, 19));
        kDPanel2.add(chkbuyComplete, new KDLayout.Constraints(343, 13, 107, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contotherAmount
        contotherAmount.setBoundEditor(txtotherAmount);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contpurchaseMthod
        contpurchaseMthod.setBoundEditor(purchaseMthod);
        //contpurchaseType
        contpurchaseType.setBoundEditor(purchaseType);
        //contrecycleDate
        contrecycleDate.setBoundEditor(pkrecycleDate);
        //contcarSendBill
        contcarSendBill.setBoundEditor(prmtcarSendBill);
        //conttotalSettleAmt
        conttotalSettleAmt.setBoundEditor(txttotalSettleAmt);
        //contstdFrePrice
        contstdFrePrice.setBoundEditor(txtstdFrePrice);

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
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        menuBiz.add(MenuItemVoucher);
        menuBiz.add(MenuItemPCVoucher);
        menuBiz.add(menuItemDelVoucher);
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
        this.toolBar.add(btnCopy);
        this.toolBar.add(btnRemove);
        this.toolBar.add(tBtnAudit);
        this.toolBar.add(tBtnUnAudit);
        this.toolBar.add(btnExecute);
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
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("auditTime", com.kingdee.eas.base.permission.UserInfo.class, this.prmtauditTime, "data");
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.custom.taihe.settle.SettleBillEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.billType", String.class, this.kdtEntrys, "billType.text");
		dataBinder.registerBinding("entrys.billNum", String.class, this.kdtEntrys, "billNum.text");
		dataBinder.registerBinding("entrys.billDate", java.util.Date.class, this.kdtEntrys, "billDate.text");
		dataBinder.registerBinding("entrys.wgtType", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "wgtType.text");
		dataBinder.registerBinding("entrys.wgt", java.math.BigDecimal.class, this.kdtEntrys, "wgt.text");
		dataBinder.registerBinding("entrys.qty", java.math.BigDecimal.class, this.kdtEntrys, "qty.text");
		dataBinder.registerBinding("entrys.wghTime", java.util.Date.class, this.kdtEntrys, "wghTime.text");
		dataBinder.registerBinding("AssEntrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtAssEntrys, "id.text");
		dataBinder.registerBinding("AssEntrys", com.kingdee.eas.custom.taihe.settle.SettleBillAssEntryInfo.class, this.kdtAssEntrys, "userObject");
		dataBinder.registerBinding("AssEntrys.wgtType", com.kingdee.util.enums.Enum.class, this.kdtAssEntrys, "wgtType.text");
		dataBinder.registerBinding("AssEntrys.qty", java.math.BigDecimal.class, this.kdtAssEntrys, "qty.text");
		dataBinder.registerBinding("AssEntrys.wgt", java.math.BigDecimal.class, this.kdtAssEntrys, "wgt.text");
		dataBinder.registerBinding("AssEntrys.disRate", java.math.BigDecimal.class, this.kdtAssEntrys, "disRate.text");
		dataBinder.registerBinding("AssEntrys.wgtAfterDis", java.math.BigDecimal.class, this.kdtAssEntrys, "wgtAfterDis.text");
		dataBinder.registerBinding("AssEntrys.settleWgt", java.math.BigDecimal.class, this.kdtAssEntrys, "settleWgt.text");
		dataBinder.registerBinding("AssEntrys.settleRate", java.math.BigDecimal.class, this.kdtAssEntrys, "settleRate.text");
		dataBinder.registerBinding("OtherEntrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtOtherEntrys, "id.text");
		dataBinder.registerBinding("OtherEntrys", com.kingdee.eas.custom.taihe.settle.SettleBillOtherEntryInfo.class, this.kdtOtherEntrys, "userObject");
		dataBinder.registerBinding("OtherEntrys.amount", java.math.BigDecimal.class, this.kdtOtherEntrys, "amount.text");
		dataBinder.registerBinding("OtherEntrys.remark", String.class, this.kdtOtherEntrys, "remark.text");
		dataBinder.registerBinding("OtherEntrys.item", java.lang.Object.class, this.kdtOtherEntrys, "item.text");
		dataBinder.registerBinding("Fivouchered", boolean.class, this.chkFivouchered, "selected");
		dataBinder.registerBinding("houseBefore", boolean.class, this.chkhouseBefore, "selected");
		dataBinder.registerBinding("isQualified", boolean.class, this.chkisQualified, "selected");
		dataBinder.registerBinding("isdiff", boolean.class, this.chkisdiff, "selected");
		dataBinder.registerBinding("batchContract", com.kingdee.eas.custom.taihe.contract.BatchContractInfo.class, this.prmtbatchContract, "data");
		dataBinder.registerBinding("successiveContract", com.kingdee.eas.custom.taihe.contract.SuccessiveContractInfo.class, this.prmtsuccessiveContract, "data");
		dataBinder.registerBinding("contractType", com.kingdee.eas.custom.signwasthetable.ContractTypeInfo.class, this.prmtcontractType, "data");
		dataBinder.registerBinding("originMtrialPerson", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtoriginMtrialPerson, "data");
		dataBinder.registerBinding("partyB", com.kingdee.eas.basedata.master.cssp.SupplierInfo.class, this.prmtpartyB, "data");
		dataBinder.registerBinding("iDCardNo", String.class, this.txtiDCardNo, "text");
		dataBinder.registerBinding("accountBank", String.class, this.txtaccountBank, "text");
		dataBinder.registerBinding("bankAccount", String.class, this.txtbankAccount, "text");
		dataBinder.registerBinding("farm", com.kingdee.eas.farm.stocking.basedata.FarmInfo.class, this.prmtfarm, "data");
		dataBinder.registerBinding("farmMnger", String.class, this.txtfarmMnger, "text");
		dataBinder.registerBinding("inDate", java.util.Date.class, this.pkinDate, "value");
		dataBinder.registerBinding("dayAge", String.class, this.txtdayAge, "text");
		dataBinder.registerBinding("settlePolicy", com.kingdee.eas.custom.taihe.settle.TaiHeSettlePolicyInfo.class, this.prmtsettlePolicy, "data");
		dataBinder.registerBinding("awardsPolicy", com.kingdee.eas.custom.taihe.settle.SettleAwardPolicyInfo.class, this.prmtawardsPolicy, "data");
		dataBinder.registerBinding("inQty", java.math.BigDecimal.class, this.txtinQty, "value");
		dataBinder.registerBinding("farmAddress", String.class, this.txtfarmAddress, "text");
		dataBinder.registerBinding("supplierAddress", String.class, this.txtsupplierAddress, "text");
		dataBinder.registerBinding("difftxt", String.class, this.txtdifftxt, "text");
		dataBinder.registerBinding("yieldStd", java.math.BigDecimal.class, this.txtyieldStd, "value");
		dataBinder.registerBinding("carcassSettleWgt", java.math.BigDecimal.class, this.txtcarcassSettleWgt, "value");
		dataBinder.registerBinding("stdYeildRate", java.math.BigDecimal.class, this.txtstdYeildRate, "value");
		dataBinder.registerBinding("actualYieldRate", java.math.BigDecimal.class, this.txtactualYieldRate, "value");
		dataBinder.registerBinding("totalSettleWgt", java.math.BigDecimal.class, this.txttotalSettleWgt, "value");
		dataBinder.registerBinding("safePrice", java.math.BigDecimal.class, this.txtsafePrice, "value");
		dataBinder.registerBinding("marketPrice", java.math.BigDecimal.class, this.txtmarketPrice, "value");
		dataBinder.registerBinding("purchasePrice", java.math.BigDecimal.class, this.txtpurchasePrice, "value");
		dataBinder.registerBinding("qty", java.math.BigDecimal.class, this.txtqty, "value");
		dataBinder.registerBinding("purchaseSettleAmt", java.math.BigDecimal.class, this.txtpurchaseSettleAmt, "value");
		dataBinder.registerBinding("chickenSzQty", java.math.BigDecimal.class, this.txtchickenSzQty, "value");
		dataBinder.registerBinding("chickenSzAmt", java.math.BigDecimal.class, this.txtchickenSzAmt, "value");
		dataBinder.registerBinding("plusSettleWgt", java.math.BigDecimal.class, this.txtplusSettleWgt, "value");
		dataBinder.registerBinding("plusPrice", java.math.BigDecimal.class, this.txtplusPrice, "value");
		dataBinder.registerBinding("chickenSzCoeff", java.math.BigDecimal.class, this.txtchickenSzCoeff, "value");
		dataBinder.registerBinding("awardsAmount", java.math.BigDecimal.class, this.txtawardsAmount, "value");
		dataBinder.registerBinding("basePrice", java.math.BigDecimal.class, this.txtbasePrice, "value");
		dataBinder.registerBinding("hedingPrice", java.math.BigDecimal.class, this.txthedingPrice, "value");
		dataBinder.registerBinding("fixedCoeff", java.math.BigDecimal.class, this.txtfixedCoeff, "value");
		dataBinder.registerBinding("shareCoeff", java.math.BigDecimal.class, this.txtshareCoeff, "value");
		dataBinder.registerBinding("avgWgt", java.math.BigDecimal.class, this.txtavgWgt, "value");
		dataBinder.registerBinding("chargeStd", java.math.BigDecimal.class, this.txtchargeStd, "value");
		dataBinder.registerBinding("CSzAverageQty", java.math.BigDecimal.class, this.txtCSzAverageQty, "value");
		dataBinder.registerBinding("stdMiles", java.math.BigDecimal.class, this.txtstdMiles, "value");
		dataBinder.registerBinding("actualMiles", java.math.BigDecimal.class, this.txtactualMiles, "value");
		dataBinder.registerBinding("suppFreAmt", java.math.BigDecimal.class, this.txtsuppFreAmt, "value");
		dataBinder.registerBinding("selfFrePrice", java.math.BigDecimal.class, this.txtselfFrePrice, "value");
		dataBinder.registerBinding("actulSettleFreAmt", java.math.BigDecimal.class, this.txtactulSettleFreAmt, "value");
		dataBinder.registerBinding("CarriageFormat", com.kingdee.eas.farm.feemanager.basedata.CarriageFormatInfo.class, this.prmtCarriageFormat, "data");
		dataBinder.registerBinding("car", com.kingdee.eas.publicdata.CarInfo.class, this.prmtcar, "data");
		dataBinder.registerBinding("actualFreAmt", java.math.BigDecimal.class, this.txtactualFreAmt, "value");
		dataBinder.registerBinding("selfFreAmt", java.math.BigDecimal.class, this.txtselfFreAmt, "value");
		dataBinder.registerBinding("basketQty", java.math.BigDecimal.class, this.txtbasketQty, "value");
		dataBinder.registerBinding("buyComplete", boolean.class, this.chkbuyComplete, "selected");
		dataBinder.registerBinding("otherAmount", java.math.BigDecimal.class, this.txtotherAmount, "value");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("purchaseMthod", com.kingdee.eas.custom.taihe.weight.PurchaseMethod.class, this.purchaseMthod, "selectedItem");
		dataBinder.registerBinding("purchaseType", com.kingdee.eas.custom.taihe.weight.PurchaseType.class, this.purchaseType, "selectedItem");
		dataBinder.registerBinding("recycleDate", java.util.Date.class, this.pkrecycleDate, "value");
		dataBinder.registerBinding("carSendBill", com.kingdee.eas.custom.taihe.weight.CarSendBillInfo.class, this.prmtcarSendBill, "data");
		dataBinder.registerBinding("totalSettleAmt", java.math.BigDecimal.class, this.txttotalSettleAmt, "value");
		dataBinder.registerBinding("stdFrePrice", java.math.BigDecimal.class, this.txtstdFrePrice, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.taihe.settle.app.SettleBillEditUIHandler";
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
        this.prmtAuditor.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.taihe.settle.SettleBillInfo)ov;
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
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.billType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.billNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.billDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.wgtType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.wgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.wghTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.wgtType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.wgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.disRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.wgtAfterDis", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.settleWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AssEntrys.settleRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OtherEntrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OtherEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OtherEntrys.amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OtherEntrys.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OtherEntrys.item", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Fivouchered", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("houseBefore", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isQualified", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isdiff", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batchContract", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("successiveContract", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contractType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("originMtrialPerson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("partyB", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("iDCardNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("accountBank", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bankAccount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmMnger", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("inDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dayAge", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("settlePolicy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("awardsPolicy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("inQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmAddress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("supplierAddress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("difftxt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yieldStd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("carcassSettleWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("stdYeildRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("actualYieldRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalSettleWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("safePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("marketPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("purchasePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("purchaseSettleAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenSzQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenSzAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("plusSettleWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("plusPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenSzCoeff", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("awardsAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("basePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hedingPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fixedCoeff", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("shareCoeff", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("avgWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chargeStd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CSzAverageQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("stdMiles", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("actualMiles", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("suppFreAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("selfFrePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("actulSettleFreAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CarriageFormat", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("car", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("actualFreAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("selfFreAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("basketQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("buyComplete", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("otherAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("purchaseMthod", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("purchaseType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("recycleDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("carSendBill", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalSettleAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("stdFrePrice", ValidateHelper.ON_SAVE);    		
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
     * output prmtbatchContract_Changed() method
     */
    public void prmtbatchContract_Changed() throws Exception
    {
        System.out.println("prmtbatchContract_Changed() Function is executed!");
            prmtcontractType.setData(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtbatchContract.getData(),"contractType"));
prmtfarm.setData(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtbatchContract.getData(),"farm"));
txtfarmMnger.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtbatchContract.getData(),"farmer")));
txtiDCardNo.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtbatchContract.getData(),"partyBID")));
txtaccountBank.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtbatchContract.getData(),"partyBBank")));
txtbankAccount.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtbatchContract.getData(),"partyBAccount")));
pkinDate.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getDateValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtbatchContract.getData(),"inDate")));
prmtpartyB.setData(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtbatchContract.getData(),"supplier"));
txtsafePrice.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtbatchContract.getData(),"contractSafePrice")));
txtpurchasePrice.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtbatchContract.getData(),"contractCellPrice")));
prmtsettlePolicy.setData(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtbatchContract.getData(),"settlePolicy"));
prmtawardsPolicy.setData(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtbatchContract.getData(),"awardPolicy"));
txtshareCoeff.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtbatchContract.getData(),"shareCoeff")));
txtfixedCoeff.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtbatchContract.getData(),"fixedCoeff")));
txthedingPrice.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtbatchContract.getData(),"hedgingPrice")));
txtbasePrice.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtbatchContract.getData(),"basePrice")));
prmtsuccessiveContract.setData(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtbatchContract.getData(),"successiveContract"));
prmtoriginMtrialPerson.setData(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtbatchContract.getData(),"purchasePerson"));
txtinQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtbatchContract.getData(),"inQty")));
txtplusPrice.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtbatchContract.getData(),"yzjincrease")));


    }

    /**
     * output prmtpartyB_Changed() method
     */
    public void prmtpartyB_Changed() throws Exception
    {
        System.out.println("prmtpartyB_Changed() Function is executed!");
            txtsupplierAddress.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtpartyB.getData(),"address")));


    }

    /**
     * output prmtfarm_Changed() method
     */
    public void prmtfarm_Changed() throws Exception
    {
        System.out.println("prmtfarm_Changed() Function is executed!");
            txtfarmMnger.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtfarm.getData(),"theHeader")));
txtstdMiles.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtfarm.getData(),"milesStd")));


    }

    /**
     * output prmtsettlePolicy_Changed() method
     */
    public void prmtsettlePolicy_Changed() throws Exception
    {
        System.out.println("prmtsettlePolicy_Changed() Function is executed!");
            txtstdYeildRate.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtsettlePolicy.getData(),"stdCarcass")));
txtchickenSzCoeff.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtsettlePolicy.getData(),"chickenSzCoeff")));


    }

    /**
     * output prmtawardsPolicy_Changed() method
     */
    public void prmtawardsPolicy_Changed() throws Exception
    {
        System.out.println("prmtawardsPolicy_Changed() Function is executed!");
            txtchickenSzCoeff.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtawardsPolicy.getData(),"chickenSzCoff")));


    }

    /**
     * output prmtcarSendBill_Changed() method
     */
    public void prmtcarSendBill_Changed() throws Exception
    {
        System.out.println("prmtcarSendBill_Changed() Function is executed!");
            txtfarmAddress.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtcarSendBill.getData(),"farmAddress")));
txtDescription.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtcarSendBill.getData(),"description")));


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
        sic.add(new SelectorItemInfo("auditTime"));
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
    	sic.add(new SelectorItemInfo("entrys.wgtType"));
    	sic.add(new SelectorItemInfo("entrys.wgt"));
    	sic.add(new SelectorItemInfo("entrys.qty"));
    	sic.add(new SelectorItemInfo("entrys.wghTime"));
    	sic.add(new SelectorItemInfo("AssEntrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("AssEntrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("AssEntrys.wgtType"));
    	sic.add(new SelectorItemInfo("AssEntrys.qty"));
    	sic.add(new SelectorItemInfo("AssEntrys.wgt"));
    	sic.add(new SelectorItemInfo("AssEntrys.disRate"));
    	sic.add(new SelectorItemInfo("AssEntrys.wgtAfterDis"));
    	sic.add(new SelectorItemInfo("AssEntrys.settleWgt"));
    	sic.add(new SelectorItemInfo("AssEntrys.settleRate"));
    	sic.add(new SelectorItemInfo("OtherEntrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("OtherEntrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("OtherEntrys.amount"));
    	sic.add(new SelectorItemInfo("OtherEntrys.remark"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("OtherEntrys.item.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("OtherEntrys.item.id"));
			sic.add(new SelectorItemInfo("OtherEntrys.item.name"));
        	sic.add(new SelectorItemInfo("OtherEntrys.item.number"));
		}
        sic.add(new SelectorItemInfo("Fivouchered"));
        sic.add(new SelectorItemInfo("houseBefore"));
        sic.add(new SelectorItemInfo("isQualified"));
        sic.add(new SelectorItemInfo("isdiff"));
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
			sic.add(new SelectorItemInfo("successiveContract.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("successiveContract.id"));
        	sic.add(new SelectorItemInfo("successiveContract.number"));
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("originMtrialPerson.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("originMtrialPerson.id"));
        	sic.add(new SelectorItemInfo("originMtrialPerson.number"));
        	sic.add(new SelectorItemInfo("originMtrialPerson.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("partyB.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("partyB.id"));
        	sic.add(new SelectorItemInfo("partyB.number"));
        	sic.add(new SelectorItemInfo("partyB.name"));
		}
        sic.add(new SelectorItemInfo("iDCardNo"));
        sic.add(new SelectorItemInfo("accountBank"));
        sic.add(new SelectorItemInfo("bankAccount"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("farm.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farm.id"));
        	sic.add(new SelectorItemInfo("farm.number"));
        	sic.add(new SelectorItemInfo("farm.name"));
		}
        sic.add(new SelectorItemInfo("farmMnger"));
        sic.add(new SelectorItemInfo("inDate"));
        sic.add(new SelectorItemInfo("dayAge"));
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
			sic.add(new SelectorItemInfo("awardsPolicy.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("awardsPolicy.id"));
        	sic.add(new SelectorItemInfo("awardsPolicy.number"));
        	sic.add(new SelectorItemInfo("awardsPolicy.name"));
		}
        sic.add(new SelectorItemInfo("inQty"));
        sic.add(new SelectorItemInfo("farmAddress"));
        sic.add(new SelectorItemInfo("supplierAddress"));
        sic.add(new SelectorItemInfo("difftxt"));
        sic.add(new SelectorItemInfo("yieldStd"));
        sic.add(new SelectorItemInfo("carcassSettleWgt"));
        sic.add(new SelectorItemInfo("stdYeildRate"));
        sic.add(new SelectorItemInfo("actualYieldRate"));
        sic.add(new SelectorItemInfo("totalSettleWgt"));
        sic.add(new SelectorItemInfo("safePrice"));
        sic.add(new SelectorItemInfo("marketPrice"));
        sic.add(new SelectorItemInfo("purchasePrice"));
        sic.add(new SelectorItemInfo("qty"));
        sic.add(new SelectorItemInfo("purchaseSettleAmt"));
        sic.add(new SelectorItemInfo("chickenSzQty"));
        sic.add(new SelectorItemInfo("chickenSzAmt"));
        sic.add(new SelectorItemInfo("plusSettleWgt"));
        sic.add(new SelectorItemInfo("plusPrice"));
        sic.add(new SelectorItemInfo("chickenSzCoeff"));
        sic.add(new SelectorItemInfo("awardsAmount"));
        sic.add(new SelectorItemInfo("basePrice"));
        sic.add(new SelectorItemInfo("hedingPrice"));
        sic.add(new SelectorItemInfo("fixedCoeff"));
        sic.add(new SelectorItemInfo("shareCoeff"));
        sic.add(new SelectorItemInfo("avgWgt"));
        sic.add(new SelectorItemInfo("chargeStd"));
        sic.add(new SelectorItemInfo("CSzAverageQty"));
        sic.add(new SelectorItemInfo("stdMiles"));
        sic.add(new SelectorItemInfo("actualMiles"));
        sic.add(new SelectorItemInfo("suppFreAmt"));
        sic.add(new SelectorItemInfo("selfFrePrice"));
        sic.add(new SelectorItemInfo("actulSettleFreAmt"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("CarriageFormat.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("CarriageFormat.id"));
        	sic.add(new SelectorItemInfo("CarriageFormat.number"));
        	sic.add(new SelectorItemInfo("CarriageFormat.name"));
        	sic.add(new SelectorItemInfo("CarriageFormat.carriagename"));
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
        sic.add(new SelectorItemInfo("actualFreAmt"));
        sic.add(new SelectorItemInfo("selfFreAmt"));
        sic.add(new SelectorItemInfo("basketQty"));
        sic.add(new SelectorItemInfo("buyComplete"));
        sic.add(new SelectorItemInfo("otherAmount"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
        sic.add(new SelectorItemInfo("purchaseMthod"));
        sic.add(new SelectorItemInfo("purchaseType"));
        sic.add(new SelectorItemInfo("recycleDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("carSendBill.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("carSendBill.id"));
        	sic.add(new SelectorItemInfo("carSendBill.number"));
		}
        sic.add(new SelectorItemInfo("totalSettleAmt"));
        sic.add(new SelectorItemInfo("stdFrePrice"));
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
        super.actionAudit_actionPerformed(e);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionUnAudit_actionPerformed(e);
    }
    	

    /**
     * output actionExecute_actionPerformed method
     */
    public void actionExecute_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.taihe.settle.SettleBillFactory.getRemoteInstance().execute(editData);
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
	public RequestContext prepareactionAudit(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareactionAudit(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareactionAudit() {
    	return false;
    }
	public RequestContext prepareactionUnAudit(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareactionUnAudit(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareactionUnAudit() {
    	return false;
    }
	public RequestContext prepareActionExecute(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionExecute() {
    	return false;
    }

    /**
     * output ActionExecute class
     */     
    protected class ActionExecute extends ItemAction {     
    
        public ActionExecute()
        {
            this(null);
        }

        public ActionExecute(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionExecute.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionExecute.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionExecute.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractSettleBillEditUI.this, "ActionExecute", "actionExecute_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.taihe.settle.client", "SettleBillEditUI");
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
        return com.kingdee.eas.custom.taihe.settle.client.SettleBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.taihe.settle.SettleBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.taihe.settle.SettleBillInfo objectValue = new com.kingdee.eas.custom.taihe.settle.SettleBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/taihe/settle/SettleBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.taihe.settle.app.SettleBillQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		for (int i=0,n=kdtOtherEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtOtherEntrys.getCell(i,"item").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"项目"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcontractType.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"合同类型"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtoriginMtrialPerson.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"原料员"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtpartyB.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"乙方"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtsettlePolicy.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"结算政策"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtactualMiles.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"实际里程"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtCarriageFormat.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"车型标准"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcar.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"承运方"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"公司"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(purchaseType.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"收购类型"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkrecycleDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"收购日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcarSendBill.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"派车单"});
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
				vo.put("chickenSzQty",new java.math.BigDecimal(0));
		vo.put("chickenSzAmt",new java.math.BigDecimal(0));
		vo.put("plusSettleWgt",new java.math.BigDecimal(0));
		vo.put("plusPrice",new java.math.BigDecimal(0));
		vo.put("chickenSzCoeff",new java.math.BigDecimal(0));
		vo.put("awardsAmount",new java.math.BigDecimal(0));
		vo.put("avgWgt",new java.math.BigDecimal(0));
		vo.put("suppFreAmt",new java.math.BigDecimal(0));
		vo.put("selfFrePrice",new java.math.BigDecimal(0));
		vo.put("actulSettleFreAmt",new java.math.BigDecimal(0));
		vo.put("actualFreAmt",new java.math.BigDecimal(0));
		vo.put("otherAmount",new java.math.BigDecimal(0));
vo.put("purchaseMthod","1");
vo.put("purchaseType","1");
		vo.put("stdFrePrice",new java.math.BigDecimal(0));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}