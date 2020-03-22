/**
 * output package name
 */
package com.kingdee.eas.custom.bsxbudget.client;

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
public abstract class AbstractBSXBudgetFoodEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractBSXBudgetFoodEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDPanel kdPanelAnticipatedRevenue;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator9;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator10;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator11;
    protected com.kingdee.bos.ctrl.swing.KDPanel kdPanelAnticipatedCost;
    protected com.kingdee.bos.ctrl.swing.KDPanel kdPanelFee;
    protected com.kingdee.bos.ctrl.swing.KDPanel kdPanelAnticipatedProfit;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator13;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperiod;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDButton btnGetTotalWeight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contexpectedSalesAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contexpectedPricePerTon;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contexpectedSalesRevenue;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtexpectedSalesAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtexpectedPricePerTon;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtexpectedSalesRevenue;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalWeight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpricePerKG;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotolCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyieldRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyield;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contproductCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstockAtMonthBegin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstockAmtAtMonthBegin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contexpectedRec;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpredictRecAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contexpectedSaleCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contexpectedsalesCostPerKG;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalWeight;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpricePerKG;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotolCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyieldRate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyield;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtproductCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtstockAtMonthBegin;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtstockAmtAtMonthBegin;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtexpectedRec;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpredictRecAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtexpectedSaleCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtexpectedsalesCostPerKG;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmanageFee;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contFIFee;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsaleFee;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmanageFee;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtFIFee;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsaleFee;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsaleProfit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompanyProfit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsaleProfit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcompanyProfit;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperiod;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdescription;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.custom.bsxbudget.BSXBudgetFoodInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractBSXBudgetFoodEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractBSXBudgetFoodEditUI.class.getName());
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
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdPanelAnticipatedRevenue = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDSeparator9 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDSeparator10 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDSeparator11 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kdPanelAnticipatedCost = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdPanelFee = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdPanelAnticipatedProfit = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDSeparator13 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contperiod = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnGetTotalWeight = new com.kingdee.bos.ctrl.swing.KDButton();
        this.contdescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.contexpectedSalesAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contexpectedPricePerTon = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contexpectedSalesRevenue = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtexpectedSalesAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtexpectedPricePerTon = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtexpectedSalesRevenue = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.conttotalWeight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpricePerKG = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotolCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyieldRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyield = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contproductCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstockAtMonthBegin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstockAmtAtMonthBegin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contexpectedRec = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpredictRecAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contexpectedSaleCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contexpectedsalesCostPerKG = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txttotalWeight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpricePerKG = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttotolCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyieldRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyield = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtproductCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtstockAtMonthBegin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtstockAmtAtMonthBegin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtexpectedRec = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpredictRecAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtexpectedSaleCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtexpectedsalesCostPerKG = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contmanageFee = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contFIFee = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsaleFee = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtmanageFee = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtFIFee = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsaleFee = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contsaleProfit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompanyProfit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtsaleProfit = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcompanyProfit = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtperiod = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtdescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contAuditor.setName("contAuditor");
        this.contauditTime.setName("contauditTime");
        this.kdPanelAnticipatedRevenue.setName("kdPanelAnticipatedRevenue");
        this.kDSeparator8.setName("kDSeparator8");
        this.kDSeparator9.setName("kDSeparator9");
        this.kDSeparator10.setName("kDSeparator10");
        this.kDSeparator11.setName("kDSeparator11");
        this.kdPanelAnticipatedCost.setName("kdPanelAnticipatedCost");
        this.kdPanelFee.setName("kdPanelFee");
        this.kdPanelAnticipatedProfit.setName("kdPanelAnticipatedProfit");
        this.kDSeparator13.setName("kDSeparator13");
        this.contperiod.setName("contperiod");
        this.contbillStatus.setName("contbillStatus");
        this.btnGetTotalWeight.setName("btnGetTotalWeight");
        this.contdescription.setName("contdescription");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.prmtAuditor.setName("prmtAuditor");
        this.pkauditTime.setName("pkauditTime");
        this.contexpectedSalesAmt.setName("contexpectedSalesAmt");
        this.contexpectedPricePerTon.setName("contexpectedPricePerTon");
        this.contexpectedSalesRevenue.setName("contexpectedSalesRevenue");
        this.txtexpectedSalesAmt.setName("txtexpectedSalesAmt");
        this.txtexpectedPricePerTon.setName("txtexpectedPricePerTon");
        this.txtexpectedSalesRevenue.setName("txtexpectedSalesRevenue");
        this.conttotalWeight.setName("conttotalWeight");
        this.contpricePerKG.setName("contpricePerKG");
        this.conttotolCost.setName("conttotolCost");
        this.contyieldRate.setName("contyieldRate");
        this.contyield.setName("contyield");
        this.contproductCost.setName("contproductCost");
        this.contstockAtMonthBegin.setName("contstockAtMonthBegin");
        this.contstockAmtAtMonthBegin.setName("contstockAmtAtMonthBegin");
        this.contexpectedRec.setName("contexpectedRec");
        this.contpredictRecAmt.setName("contpredictRecAmt");
        this.contexpectedSaleCost.setName("contexpectedSaleCost");
        this.contexpectedsalesCostPerKG.setName("contexpectedsalesCostPerKG");
        this.txttotalWeight.setName("txttotalWeight");
        this.txtpricePerKG.setName("txtpricePerKG");
        this.txttotolCost.setName("txttotolCost");
        this.txtyieldRate.setName("txtyieldRate");
        this.txtyield.setName("txtyield");
        this.txtproductCost.setName("txtproductCost");
        this.txtstockAtMonthBegin.setName("txtstockAtMonthBegin");
        this.txtstockAmtAtMonthBegin.setName("txtstockAmtAtMonthBegin");
        this.txtexpectedRec.setName("txtexpectedRec");
        this.txtpredictRecAmt.setName("txtpredictRecAmt");
        this.txtexpectedSaleCost.setName("txtexpectedSaleCost");
        this.txtexpectedsalesCostPerKG.setName("txtexpectedsalesCostPerKG");
        this.contmanageFee.setName("contmanageFee");
        this.contFIFee.setName("contFIFee");
        this.contsaleFee.setName("contsaleFee");
        this.txtmanageFee.setName("txtmanageFee");
        this.txtFIFee.setName("txtFIFee");
        this.txtsaleFee.setName("txtsaleFee");
        this.contsaleProfit.setName("contsaleProfit");
        this.contcompanyProfit.setName("contcompanyProfit");
        this.txtsaleProfit.setName("txtsaleProfit");
        this.txtcompanyProfit.setName("txtcompanyProfit");
        this.prmtperiod.setName("prmtperiod");
        this.billStatus.setName("billStatus");
        this.txtdescription.setName("txtdescription");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
        // CoreUI		
        this.setBorder(null);		
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
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // kdPanelAnticipatedRevenue		
        this.kdPanelAnticipatedRevenue.setBorder(new TitledBorder(BorderFactory.createLineBorder(new Color(0,0,0),1), resHelper.getString("kdPanelAnticipatedRevenue.border.title")));
        // kDSeparator8
        // kDSeparator9
        // kDSeparator10
        // kDSeparator11
        // kdPanelAnticipatedCost		
        this.kdPanelAnticipatedCost.setBorder(new TitledBorder(BorderFactory.createLineBorder(new Color(0,0,0),1), resHelper.getString("kdPanelAnticipatedCost.border.title")));
        // kdPanelFee		
        this.kdPanelFee.setBorder(new TitledBorder(BorderFactory.createLineBorder(new Color(0,0,0),1), resHelper.getString("kdPanelFee.border.title")));
        // kdPanelAnticipatedProfit		
        this.kdPanelAnticipatedProfit.setBorder(new TitledBorder(BorderFactory.createLineBorder(new Color(0,0,0),1), resHelper.getString("kdPanelAnticipatedProfit.border.title")));
        // kDSeparator13
        // contperiod		
        this.contperiod.setBoundLabelText(resHelper.getString("contperiod.boundLabelText"));		
        this.contperiod.setBoundLabelLength(100);		
        this.contperiod.setBoundLabelUnderline(true);		
        this.contperiod.setVisible(true);
        // contbillStatus		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);
        // btnGetTotalWeight		
        this.btnGetTotalWeight.setText(resHelper.getString("btnGetTotalWeight.text"));
        this.btnGetTotalWeight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                try {
                    btnGetTotalWeight_mouseClicke(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });
        // contdescription		
        this.contdescription.setBoundLabelText(resHelper.getString("contdescription.boundLabelText"));		
        this.contdescription.setBoundLabelLength(100);		
        this.contdescription.setBoundLabelUnderline(true);		
        this.contdescription.setVisible(true);
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
        this.pkBizDate.setVisible(true);		
        this.pkBizDate.setEnabled(true);		
        this.pkBizDate.setRequired(true);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // pkauditTime		
        this.pkauditTime.setVisible(true);		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // contexpectedSalesAmt		
        this.contexpectedSalesAmt.setBoundLabelText(resHelper.getString("contexpectedSalesAmt.boundLabelText"));		
        this.contexpectedSalesAmt.setBoundLabelLength(100);		
        this.contexpectedSalesAmt.setBoundLabelUnderline(true);		
        this.contexpectedSalesAmt.setVisible(true);
        // contexpectedPricePerTon		
        this.contexpectedPricePerTon.setBoundLabelText(resHelper.getString("contexpectedPricePerTon.boundLabelText"));		
        this.contexpectedPricePerTon.setBoundLabelLength(100);		
        this.contexpectedPricePerTon.setBoundLabelUnderline(true);		
        this.contexpectedPricePerTon.setVisible(true);
        // contexpectedSalesRevenue		
        this.contexpectedSalesRevenue.setBoundLabelText(resHelper.getString("contexpectedSalesRevenue.boundLabelText"));		
        this.contexpectedSalesRevenue.setBoundLabelLength(100);		
        this.contexpectedSalesRevenue.setBoundLabelUnderline(true);		
        this.contexpectedSalesRevenue.setVisible(true);
        // txtexpectedSalesAmt		
        this.txtexpectedSalesAmt.setVisible(true);		
        this.txtexpectedSalesAmt.setHorizontalAlignment(2);		
        this.txtexpectedSalesAmt.setDataType(1);		
        this.txtexpectedSalesAmt.setSupportedEmpty(true);		
        this.txtexpectedSalesAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtexpectedSalesAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtexpectedSalesAmt.setPrecision(4);		
        this.txtexpectedSalesAmt.setRequired(true);
        this.txtexpectedSalesAmt.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtexpectedSalesAmt_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtexpectedPricePerTon		
        this.txtexpectedPricePerTon.setVisible(true);		
        this.txtexpectedPricePerTon.setHorizontalAlignment(2);		
        this.txtexpectedPricePerTon.setDataType(1);		
        this.txtexpectedPricePerTon.setSupportedEmpty(true);		
        this.txtexpectedPricePerTon.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtexpectedPricePerTon.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtexpectedPricePerTon.setPrecision(4);		
        this.txtexpectedPricePerTon.setRequired(true);
        this.txtexpectedPricePerTon.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtexpectedPricePerTon_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtexpectedSalesRevenue		
        this.txtexpectedSalesRevenue.setVisible(true);		
        this.txtexpectedSalesRevenue.setHorizontalAlignment(2);		
        this.txtexpectedSalesRevenue.setDataType(1);		
        this.txtexpectedSalesRevenue.setSupportedEmpty(true);		
        this.txtexpectedSalesRevenue.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtexpectedSalesRevenue.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtexpectedSalesRevenue.setPrecision(2);		
        this.txtexpectedSalesRevenue.setRequired(false);		
        this.txtexpectedSalesRevenue.setEnabled(false);
        // conttotalWeight		
        this.conttotalWeight.setBoundLabelText(resHelper.getString("conttotalWeight.boundLabelText"));		
        this.conttotalWeight.setBoundLabelLength(120);		
        this.conttotalWeight.setBoundLabelUnderline(true);		
        this.conttotalWeight.setVisible(true);
        // contpricePerKG		
        this.contpricePerKG.setBoundLabelText(resHelper.getString("contpricePerKG.boundLabelText"));		
        this.contpricePerKG.setBoundLabelLength(120);		
        this.contpricePerKG.setBoundLabelUnderline(true);		
        this.contpricePerKG.setVisible(true);
        // conttotolCost		
        this.conttotolCost.setBoundLabelText(resHelper.getString("conttotolCost.boundLabelText"));		
        this.conttotolCost.setBoundLabelLength(120);		
        this.conttotolCost.setBoundLabelUnderline(true);		
        this.conttotolCost.setVisible(true);
        // contyieldRate		
        this.contyieldRate.setBoundLabelText(resHelper.getString("contyieldRate.boundLabelText"));		
        this.contyieldRate.setBoundLabelLength(120);		
        this.contyieldRate.setBoundLabelUnderline(true);		
        this.contyieldRate.setVisible(true);
        // contyield		
        this.contyield.setBoundLabelText(resHelper.getString("contyield.boundLabelText"));		
        this.contyield.setBoundLabelLength(120);		
        this.contyield.setBoundLabelUnderline(true);		
        this.contyield.setVisible(true);
        // contproductCost		
        this.contproductCost.setBoundLabelText(resHelper.getString("contproductCost.boundLabelText"));		
        this.contproductCost.setBoundLabelLength(120);		
        this.contproductCost.setBoundLabelUnderline(true);		
        this.contproductCost.setVisible(true);
        // contstockAtMonthBegin		
        this.contstockAtMonthBegin.setBoundLabelText(resHelper.getString("contstockAtMonthBegin.boundLabelText"));		
        this.contstockAtMonthBegin.setBoundLabelLength(120);		
        this.contstockAtMonthBegin.setBoundLabelUnderline(true);		
        this.contstockAtMonthBegin.setVisible(true);
        // contstockAmtAtMonthBegin		
        this.contstockAmtAtMonthBegin.setBoundLabelText(resHelper.getString("contstockAmtAtMonthBegin.boundLabelText"));		
        this.contstockAmtAtMonthBegin.setBoundLabelLength(120);		
        this.contstockAmtAtMonthBegin.setBoundLabelUnderline(true);		
        this.contstockAmtAtMonthBegin.setVisible(true);
        // contexpectedRec		
        this.contexpectedRec.setBoundLabelText(resHelper.getString("contexpectedRec.boundLabelText"));		
        this.contexpectedRec.setBoundLabelLength(120);		
        this.contexpectedRec.setBoundLabelUnderline(true);		
        this.contexpectedRec.setVisible(true);
        // contpredictRecAmt		
        this.contpredictRecAmt.setBoundLabelText(resHelper.getString("contpredictRecAmt.boundLabelText"));		
        this.contpredictRecAmt.setBoundLabelLength(120);		
        this.contpredictRecAmt.setBoundLabelUnderline(true);		
        this.contpredictRecAmt.setVisible(true);
        // contexpectedSaleCost		
        this.contexpectedSaleCost.setBoundLabelText(resHelper.getString("contexpectedSaleCost.boundLabelText"));		
        this.contexpectedSaleCost.setBoundLabelLength(120);		
        this.contexpectedSaleCost.setBoundLabelUnderline(true);		
        this.contexpectedSaleCost.setVisible(true);
        // contexpectedsalesCostPerKG		
        this.contexpectedsalesCostPerKG.setBoundLabelText(resHelper.getString("contexpectedsalesCostPerKG.boundLabelText"));		
        this.contexpectedsalesCostPerKG.setBoundLabelLength(120);		
        this.contexpectedsalesCostPerKG.setBoundLabelUnderline(true);		
        this.contexpectedsalesCostPerKG.setVisible(true);
        // txttotalWeight		
        this.txttotalWeight.setVisible(true);		
        this.txttotalWeight.setHorizontalAlignment(2);		
        this.txttotalWeight.setDataType(1);		
        this.txttotalWeight.setSupportedEmpty(true);		
        this.txttotalWeight.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttotalWeight.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttotalWeight.setPrecision(4);		
        this.txttotalWeight.setRequired(false);		
        this.txttotalWeight.setEnabled(false);
        txttotalWeight.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				txttotalWeight_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        this.txttotalWeight.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txttotalWeight_dataChang(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtpricePerKG		
        this.txtpricePerKG.setVisible(true);		
        this.txtpricePerKG.setHorizontalAlignment(2);		
        this.txtpricePerKG.setDataType(1);		
        this.txtpricePerKG.setSupportedEmpty(true);		
        this.txtpricePerKG.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpricePerKG.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpricePerKG.setPrecision(4);		
        this.txtpricePerKG.setRequired(true);
        txtpricePerKG.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				txtpricePerKG_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        this.txtpricePerKG.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtpricePerKG_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txttotolCost		
        this.txttotolCost.setVisible(true);		
        this.txttotolCost.setHorizontalAlignment(2);		
        this.txttotolCost.setDataType(1);		
        this.txttotolCost.setSupportedEmpty(true);		
        this.txttotolCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttotolCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttotolCost.setPrecision(2);		
        this.txttotolCost.setRequired(false);		
        this.txttotolCost.setEnabled(false);
        // txtyieldRate		
        this.txtyieldRate.setVisible(true);		
        this.txtyieldRate.setHorizontalAlignment(2);		
        this.txtyieldRate.setDataType(1);		
        this.txtyieldRate.setSupportedEmpty(true);		
        this.txtyieldRate.setMinimumValue( new java.math.BigDecimal("-1.0E25"));		
        this.txtyieldRate.setMaximumValue( new java.math.BigDecimal("1.0E25"));		
        this.txtyieldRate.setPrecision(3);		
        this.txtyieldRate.setRequired(true);
        txtyieldRate.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				txtyieldRate_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        this.txtyieldRate.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtyieldRate_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtyield		
        this.txtyield.setVisible(true);		
        this.txtyield.setHorizontalAlignment(2);		
        this.txtyield.setDataType(1);		
        this.txtyield.setSupportedEmpty(true);		
        this.txtyield.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtyield.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtyield.setPrecision(4);		
        this.txtyield.setRequired(false);		
        this.txtyield.setEnabled(false);
        // txtproductCost		
        this.txtproductCost.setVisible(true);		
        this.txtproductCost.setHorizontalAlignment(2);		
        this.txtproductCost.setDataType(1);		
        this.txtproductCost.setSupportedEmpty(true);		
        this.txtproductCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtproductCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtproductCost.setPrecision(2);		
        this.txtproductCost.setRequired(true);
        txtproductCost.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				txtproductCost_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        this.txtproductCost.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtproductCost_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtstockAtMonthBegin		
        this.txtstockAtMonthBegin.setVisible(true);		
        this.txtstockAtMonthBegin.setHorizontalAlignment(2);		
        this.txtstockAtMonthBegin.setDataType(1);		
        this.txtstockAtMonthBegin.setSupportedEmpty(true);		
        this.txtstockAtMonthBegin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtstockAtMonthBegin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtstockAtMonthBegin.setPrecision(4);		
        this.txtstockAtMonthBegin.setRequired(false);		
        this.txtstockAtMonthBegin.setEnabled(false);
        // txtstockAmtAtMonthBegin		
        this.txtstockAmtAtMonthBegin.setVisible(true);		
        this.txtstockAmtAtMonthBegin.setHorizontalAlignment(2);		
        this.txtstockAmtAtMonthBegin.setDataType(1);		
        this.txtstockAmtAtMonthBegin.setSupportedEmpty(true);		
        this.txtstockAmtAtMonthBegin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtstockAmtAtMonthBegin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtstockAmtAtMonthBegin.setPrecision(2);		
        this.txtstockAmtAtMonthBegin.setRequired(false);		
        this.txtstockAmtAtMonthBegin.setEnabled(false);
        // txtexpectedRec		
        this.txtexpectedRec.setVisible(true);		
        this.txtexpectedRec.setHorizontalAlignment(2);		
        this.txtexpectedRec.setDataType(1);		
        this.txtexpectedRec.setSupportedEmpty(true);		
        this.txtexpectedRec.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtexpectedRec.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtexpectedRec.setPrecision(4);		
        this.txtexpectedRec.setRequired(false);		
        this.txtexpectedRec.setEnabled(false);
        // txtpredictRecAmt		
        this.txtpredictRecAmt.setVisible(true);		
        this.txtpredictRecAmt.setHorizontalAlignment(2);		
        this.txtpredictRecAmt.setDataType(1);		
        this.txtpredictRecAmt.setSupportedEmpty(true);		
        this.txtpredictRecAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpredictRecAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpredictRecAmt.setPrecision(2);		
        this.txtpredictRecAmt.setRequired(false);		
        this.txtpredictRecAmt.setEnabled(false);
        // txtexpectedSaleCost		
        this.txtexpectedSaleCost.setVisible(true);		
        this.txtexpectedSaleCost.setHorizontalAlignment(2);		
        this.txtexpectedSaleCost.setDataType(1);		
        this.txtexpectedSaleCost.setSupportedEmpty(true);		
        this.txtexpectedSaleCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtexpectedSaleCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtexpectedSaleCost.setPrecision(2);		
        this.txtexpectedSaleCost.setRequired(false);		
        this.txtexpectedSaleCost.setEnabled(false);
        // txtexpectedsalesCostPerKG		
        this.txtexpectedsalesCostPerKG.setVisible(true);		
        this.txtexpectedsalesCostPerKG.setHorizontalAlignment(2);		
        this.txtexpectedsalesCostPerKG.setDataType(1);		
        this.txtexpectedsalesCostPerKG.setSupportedEmpty(true);		
        this.txtexpectedsalesCostPerKG.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtexpectedsalesCostPerKG.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtexpectedsalesCostPerKG.setPrecision(2);		
        this.txtexpectedsalesCostPerKG.setRequired(false);		
        this.txtexpectedsalesCostPerKG.setEnabled(false);
        // contmanageFee		
        this.contmanageFee.setBoundLabelText(resHelper.getString("contmanageFee.boundLabelText"));		
        this.contmanageFee.setBoundLabelLength(100);		
        this.contmanageFee.setBoundLabelUnderline(true);		
        this.contmanageFee.setVisible(true);
        // contFIFee		
        this.contFIFee.setBoundLabelText(resHelper.getString("contFIFee.boundLabelText"));		
        this.contFIFee.setBoundLabelLength(100);		
        this.contFIFee.setBoundLabelUnderline(true);		
        this.contFIFee.setVisible(true);
        // contsaleFee		
        this.contsaleFee.setBoundLabelText(resHelper.getString("contsaleFee.boundLabelText"));		
        this.contsaleFee.setBoundLabelLength(100);		
        this.contsaleFee.setBoundLabelUnderline(true);		
        this.contsaleFee.setVisible(true);
        // txtmanageFee		
        this.txtmanageFee.setVisible(true);		
        this.txtmanageFee.setHorizontalAlignment(2);		
        this.txtmanageFee.setDataType(1);		
        this.txtmanageFee.setSupportedEmpty(true);		
        this.txtmanageFee.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmanageFee.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmanageFee.setPrecision(2);		
        this.txtmanageFee.setRequired(true);
        this.txtmanageFee.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtmanageFee_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtFIFee		
        this.txtFIFee.setVisible(true);		
        this.txtFIFee.setHorizontalAlignment(2);		
        this.txtFIFee.setDataType(1);		
        this.txtFIFee.setSupportedEmpty(true);		
        this.txtFIFee.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtFIFee.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtFIFee.setPrecision(2);		
        this.txtFIFee.setRequired(true);
        this.txtFIFee.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtFIFee_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtsaleFee		
        this.txtsaleFee.setVisible(true);		
        this.txtsaleFee.setHorizontalAlignment(2);		
        this.txtsaleFee.setDataType(1);		
        this.txtsaleFee.setSupportedEmpty(true);		
        this.txtsaleFee.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsaleFee.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsaleFee.setPrecision(2);		
        this.txtsaleFee.setRequired(true);
        this.txtsaleFee.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtsaleFee_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // contsaleProfit		
        this.contsaleProfit.setBoundLabelText(resHelper.getString("contsaleProfit.boundLabelText"));		
        this.contsaleProfit.setBoundLabelLength(100);		
        this.contsaleProfit.setBoundLabelUnderline(true);		
        this.contsaleProfit.setVisible(true);
        // contcompanyProfit		
        this.contcompanyProfit.setBoundLabelText(resHelper.getString("contcompanyProfit.boundLabelText"));		
        this.contcompanyProfit.setBoundLabelLength(100);		
        this.contcompanyProfit.setBoundLabelUnderline(true);		
        this.contcompanyProfit.setVisible(true);
        // txtsaleProfit		
        this.txtsaleProfit.setVisible(true);		
        this.txtsaleProfit.setHorizontalAlignment(2);		
        this.txtsaleProfit.setDataType(1);		
        this.txtsaleProfit.setSupportedEmpty(true);		
        this.txtsaleProfit.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsaleProfit.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsaleProfit.setPrecision(2);		
        this.txtsaleProfit.setRequired(false);		
        this.txtsaleProfit.setEnabled(false);
        // txtcompanyProfit		
        this.txtcompanyProfit.setVisible(true);		
        this.txtcompanyProfit.setHorizontalAlignment(2);		
        this.txtcompanyProfit.setDataType(1);		
        this.txtcompanyProfit.setSupportedEmpty(true);		
        this.txtcompanyProfit.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcompanyProfit.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcompanyProfit.setPrecision(2);		
        this.txtcompanyProfit.setRequired(false);		
        this.txtcompanyProfit.setEnabled(false);
        // prmtperiod		
        this.prmtperiod.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7PeriodQuery");		
        this.prmtperiod.setVisible(true);		
        this.prmtperiod.setEditable(true);		
        this.prmtperiod.setDisplayFormat("$number$");		
        this.prmtperiod.setEditFormat("$number$");		
        this.prmtperiod.setCommitFormat("$number$");		
        this.prmtperiod.setRequired(true);
        // billStatus		
        this.billStatus.setVisible(true);		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.bsxbudget.billStatus").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // txtdescription		
        this.txtdescription.setVisible(true);		
        this.txtdescription.setHorizontalAlignment(2);		
        this.txtdescription.setMaxLength(80);		
        this.txtdescription.setRequired(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {pkauditTime,prmtperiod,txtexpectedSalesAmt,txtexpectedPricePerTon,txtexpectedSalesRevenue,txttotalWeight,txtpricePerKG,txttotolCost,txtyieldRate,txtyield,txtproductCost,txtstockAtMonthBegin,txtstockAmtAtMonthBegin,txtexpectedRec,txtmanageFee,txtFIFee,txtsaleFee,txtsaleProfit,txtcompanyProfit,txtpredictRecAmt,txtexpectedSaleCost,txtexpectedsalesCostPerKG,billStatus}));
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
        this.setBounds(new Rectangle(0, -1, 1013, 629));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, -1, 1013, 629));
        contCreator.setBounds(new Rectangle(358, 558, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(358, 558, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(702, 558, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(702, 558, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(358, 589, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(358, 589, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(702, 589, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(702, 589, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(354, 13, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(354, 13, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(26, 15, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(26, 15, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(15, 562, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(15, 562, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(15, 591, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(15, 591, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdPanelAnticipatedRevenue.setBounds(new Rectangle(11, 90, 961, 62));
        this.add(kdPanelAnticipatedRevenue, new KDLayout.Constraints(11, 90, 961, 62, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator8.setBounds(new Rectangle(3, 82, 1009, 2));
        this.add(kDSeparator8, new KDLayout.Constraints(3, 82, 1009, 2, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator9.setBounds(new Rectangle(3, 161, 1009, 8));
        this.add(kDSeparator9, new KDLayout.Constraints(3, 161, 1009, 8, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator10.setBounds(new Rectangle(3, 462, 1009, 6));
        this.add(kDSeparator10, new KDLayout.Constraints(3, 462, 1009, 6, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator11.setBounds(new Rectangle(3, 533, 1009, 2));
        this.add(kDSeparator11, new KDLayout.Constraints(3, 533, 1009, 2, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kdPanelAnticipatedCost.setBounds(new Rectangle(11, 170, 961, 202));
        this.add(kdPanelAnticipatedCost, new KDLayout.Constraints(11, 170, 961, 202, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kdPanelFee.setBounds(new Rectangle(11, 389, 961, 62));
        this.add(kdPanelFee, new KDLayout.Constraints(11, 389, 961, 62, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kdPanelAnticipatedProfit.setBounds(new Rectangle(11, 472, 961, 47));
        this.add(kdPanelAnticipatedProfit, new KDLayout.Constraints(11, 472, 961, 47, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator13.setBounds(new Rectangle(3, 378, 1009, 2));
        this.add(kDSeparator13, new KDLayout.Constraints(3, 378, 1009, 2, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contperiod.setBounds(new Rectangle(683, 15, 270, 19));
        this.add(contperiod, new KDLayout.Constraints(683, 15, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbillStatus.setBounds(new Rectangle(26, 48, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(26, 48, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnGetTotalWeight.setBounds(new Rectangle(724, 46, 229, 21));
        this.add(btnGetTotalWeight, new KDLayout.Constraints(724, 46, 229, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contdescription.setBounds(new Rectangle(354, 48, 270, 19));
        this.add(contdescription, new KDLayout.Constraints(354, 48, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //kdPanelAnticipatedRevenue
        kdPanelAnticipatedRevenue.setLayout(new KDLayout());
        kdPanelAnticipatedRevenue.putClientProperty("OriginalBounds", new Rectangle(11, 90, 961, 62));        contexpectedSalesAmt.setBounds(new Rectangle(15, 21, 270, 19));
        kdPanelAnticipatedRevenue.add(contexpectedSalesAmt, new KDLayout.Constraints(15, 21, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contexpectedPricePerTon.setBounds(new Rectangle(340, 22, 270, 19));
        kdPanelAnticipatedRevenue.add(contexpectedPricePerTon, new KDLayout.Constraints(340, 22, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contexpectedSalesRevenue.setBounds(new Rectangle(666, 18, 270, 19));
        kdPanelAnticipatedRevenue.add(contexpectedSalesRevenue, new KDLayout.Constraints(666, 18, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contexpectedSalesAmt
        contexpectedSalesAmt.setBoundEditor(txtexpectedSalesAmt);
        //contexpectedPricePerTon
        contexpectedPricePerTon.setBoundEditor(txtexpectedPricePerTon);
        //contexpectedSalesRevenue
        contexpectedSalesRevenue.setBoundEditor(txtexpectedSalesRevenue);
        //kdPanelAnticipatedCost
        kdPanelAnticipatedCost.setLayout(new KDLayout());
        kdPanelAnticipatedCost.putClientProperty("OriginalBounds", new Rectangle(11, 170, 961, 202));        conttotalWeight.setBounds(new Rectangle(17, 29, 270, 19));
        kdPanelAnticipatedCost.add(conttotalWeight, new KDLayout.Constraints(17, 29, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpricePerKG.setBounds(new Rectangle(336, 28, 270, 19));
        kdPanelAnticipatedCost.add(contpricePerKG, new KDLayout.Constraints(336, 28, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttotolCost.setBounds(new Rectangle(669, 25, 270, 19));
        kdPanelAnticipatedCost.add(conttotolCost, new KDLayout.Constraints(669, 25, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contyieldRate.setBounds(new Rectangle(17, 79, 270, 19));
        kdPanelAnticipatedCost.add(contyieldRate, new KDLayout.Constraints(17, 79, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contyield.setBounds(new Rectangle(336, 79, 270, 19));
        kdPanelAnticipatedCost.add(contyield, new KDLayout.Constraints(336, 79, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contproductCost.setBounds(new Rectangle(669, 72, 270, 19));
        kdPanelAnticipatedCost.add(contproductCost, new KDLayout.Constraints(669, 72, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contstockAtMonthBegin.setBounds(new Rectangle(17, 123, 270, 19));
        kdPanelAnticipatedCost.add(contstockAtMonthBegin, new KDLayout.Constraints(17, 123, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contstockAmtAtMonthBegin.setBounds(new Rectangle(336, 117, 270, 19));
        kdPanelAnticipatedCost.add(contstockAmtAtMonthBegin, new KDLayout.Constraints(336, 117, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contexpectedRec.setBounds(new Rectangle(669, 122, 270, 19));
        kdPanelAnticipatedCost.add(contexpectedRec, new KDLayout.Constraints(669, 122, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contpredictRecAmt.setBounds(new Rectangle(17, 159, 270, 19));
        kdPanelAnticipatedCost.add(contpredictRecAmt, new KDLayout.Constraints(17, 159, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contexpectedSaleCost.setBounds(new Rectangle(336, 160, 270, 19));
        kdPanelAnticipatedCost.add(contexpectedSaleCost, new KDLayout.Constraints(336, 160, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contexpectedsalesCostPerKG.setBounds(new Rectangle(669, 160, 270, 19));
        kdPanelAnticipatedCost.add(contexpectedsalesCostPerKG, new KDLayout.Constraints(669, 160, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //conttotalWeight
        conttotalWeight.setBoundEditor(txttotalWeight);
        //contpricePerKG
        contpricePerKG.setBoundEditor(txtpricePerKG);
        //conttotolCost
        conttotolCost.setBoundEditor(txttotolCost);
        //contyieldRate
        contyieldRate.setBoundEditor(txtyieldRate);
        //contyield
        contyield.setBoundEditor(txtyield);
        //contproductCost
        contproductCost.setBoundEditor(txtproductCost);
        //contstockAtMonthBegin
        contstockAtMonthBegin.setBoundEditor(txtstockAtMonthBegin);
        //contstockAmtAtMonthBegin
        contstockAmtAtMonthBegin.setBoundEditor(txtstockAmtAtMonthBegin);
        //contexpectedRec
        contexpectedRec.setBoundEditor(txtexpectedRec);
        //contpredictRecAmt
        contpredictRecAmt.setBoundEditor(txtpredictRecAmt);
        //contexpectedSaleCost
        contexpectedSaleCost.setBoundEditor(txtexpectedSaleCost);
        //contexpectedsalesCostPerKG
        contexpectedsalesCostPerKG.setBoundEditor(txtexpectedsalesCostPerKG);
        //kdPanelFee
        kdPanelFee.setLayout(new KDLayout());
        kdPanelFee.putClientProperty("OriginalBounds", new Rectangle(11, 389, 961, 62));        contmanageFee.setBounds(new Rectangle(20, 21, 270, 19));
        kdPanelFee.add(contmanageFee, new KDLayout.Constraints(20, 21, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contFIFee.setBounds(new Rectangle(347, 23, 270, 19));
        kdPanelFee.add(contFIFee, new KDLayout.Constraints(347, 23, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsaleFee.setBounds(new Rectangle(675, 21, 270, 19));
        kdPanelFee.add(contsaleFee, new KDLayout.Constraints(675, 21, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contmanageFee
        contmanageFee.setBoundEditor(txtmanageFee);
        //contFIFee
        contFIFee.setBoundEditor(txtFIFee);
        //contsaleFee
        contsaleFee.setBoundEditor(txtsaleFee);
        //kdPanelAnticipatedProfit
        kdPanelAnticipatedProfit.setLayout(new KDLayout());
        kdPanelAnticipatedProfit.putClientProperty("OriginalBounds", new Rectangle(11, 472, 961, 47));        contsaleProfit.setBounds(new Rectangle(21, 25, 270, 19));
        kdPanelAnticipatedProfit.add(contsaleProfit, new KDLayout.Constraints(21, 25, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompanyProfit.setBounds(new Rectangle(674, 22, 270, 19));
        kdPanelAnticipatedProfit.add(contcompanyProfit, new KDLayout.Constraints(674, 22, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contsaleProfit
        contsaleProfit.setBoundEditor(txtsaleProfit);
        //contcompanyProfit
        contcompanyProfit.setBoundEditor(txtcompanyProfit);
        //contperiod
        contperiod.setBoundEditor(prmtperiod);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //contdescription
        contdescription.setBoundEditor(txtdescription);

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
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("expectedSalesAmt", java.math.BigDecimal.class, this.txtexpectedSalesAmt, "value");
		dataBinder.registerBinding("expectedPricePerTon", java.math.BigDecimal.class, this.txtexpectedPricePerTon, "value");
		dataBinder.registerBinding("expectedSalesRevenue", java.math.BigDecimal.class, this.txtexpectedSalesRevenue, "value");
		dataBinder.registerBinding("totalWeight", java.math.BigDecimal.class, this.txttotalWeight, "value");
		dataBinder.registerBinding("pricePerKG", java.math.BigDecimal.class, this.txtpricePerKG, "value");
		dataBinder.registerBinding("totolCost", java.math.BigDecimal.class, this.txttotolCost, "value");
		dataBinder.registerBinding("yieldRate", java.math.BigDecimal.class, this.txtyieldRate, "value");
		dataBinder.registerBinding("yield", java.math.BigDecimal.class, this.txtyield, "value");
		dataBinder.registerBinding("productCost", java.math.BigDecimal.class, this.txtproductCost, "value");
		dataBinder.registerBinding("stockAtMonthBegin", java.math.BigDecimal.class, this.txtstockAtMonthBegin, "value");
		dataBinder.registerBinding("stockAmtAtMonthBegin", java.math.BigDecimal.class, this.txtstockAmtAtMonthBegin, "value");
		dataBinder.registerBinding("expectedRec", java.math.BigDecimal.class, this.txtexpectedRec, "value");
		dataBinder.registerBinding("predictRecAmt", java.math.BigDecimal.class, this.txtpredictRecAmt, "value");
		dataBinder.registerBinding("expectedSaleCost", java.math.BigDecimal.class, this.txtexpectedSaleCost, "value");
		dataBinder.registerBinding("expectedsalesCostPerKG", java.math.BigDecimal.class, this.txtexpectedsalesCostPerKG, "value");
		dataBinder.registerBinding("manageFee", java.math.BigDecimal.class, this.txtmanageFee, "value");
		dataBinder.registerBinding("FIFee", java.math.BigDecimal.class, this.txtFIFee, "value");
		dataBinder.registerBinding("saleFee", java.math.BigDecimal.class, this.txtsaleFee, "value");
		dataBinder.registerBinding("saleProfit", java.math.BigDecimal.class, this.txtsaleProfit, "value");
		dataBinder.registerBinding("companyProfit", java.math.BigDecimal.class, this.txtcompanyProfit, "value");
		dataBinder.registerBinding("period", com.kingdee.eas.basedata.assistant.PeriodInfo.class, this.prmtperiod, "data");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.custom.bsxbudget.billStatus.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("description", String.class, this.txtdescription, "text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.bsxbudget.app.BSXBudgetFoodEditUIHandler";
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
        this.editData = (com.kingdee.eas.custom.bsxbudget.BSXBudgetFoodInfo)ov;
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
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("expectedSalesAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("expectedPricePerTon", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("expectedSalesRevenue", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("pricePerKG", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totolCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yieldRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yield", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("productCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("stockAtMonthBegin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("stockAmtAtMonthBegin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("expectedRec", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("predictRecAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("expectedSaleCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("expectedsalesCostPerKG", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("manageFee", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FIFee", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("saleFee", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("saleProfit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("companyProfit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("period", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    		
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
     * output btnGetTotalWeight_mouseClicke method
     */
    protected void btnGetTotalWeight_mouseClicke(java.awt.event.MouseEvent e) throws Exception
    {
    }

    /**
     * output txtexpectedSalesAmt_dataChange method
     */
    protected void txtexpectedSalesAmt_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output txtexpectedPricePerTon_dataChange method
     */
    protected void txtexpectedPricePerTon_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output txttotalWeight_dataChang method
     */
    protected void txttotalWeight_dataChang(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output txtpricePerKG_dataChange method
     */
    protected void txtpricePerKG_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output txtyieldRate_dataChange method
     */
    protected void txtyieldRate_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output txtproductCost_dataChange method
     */
    protected void txtproductCost_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output txtmanageFee_dataChange method
     */
    protected void txtmanageFee_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output txtFIFee_dataChange method
     */
    protected void txtFIFee_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output txtsaleFee_dataChange method
     */
    protected void txtsaleFee_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }


    /**
     * output txttotalWeight_Changed() method
     */
    public void txttotalWeight_Changed() throws Exception
    {
        System.out.println("txttotalWeight_Changed() Function is executed!");
            if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txttotalWeight.getValue())|| com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtpricePerKG.getValue())) 
{
}
else
{
    txttotolCost.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtpricePerKG.getValue())* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txttotalWeight.getValue())));
}

    if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txttotalWeight.getValue())|| com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtyieldRate.getValue())) 
{
}
else
{
    txtyield.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtyieldRate.getValue())* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txttotalWeight.getValue()))/ 100));
}


    }

    /**
     * output txtpricePerKG_Changed() method
     */
    public void txtpricePerKG_Changed() throws Exception
    {
        System.out.println("txtpricePerKG_Changed() Function is executed!");
            if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txttotalWeight.getValue())|| com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtpricePerKG.getValue())) 
{
}
else
{
    txttotolCost.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtpricePerKG.getValue())* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txttotalWeight.getValue())));
}

    if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtproductCost.getValue())|| (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtpricePerKG.getValue())|| com.kingdee.bos.ui.face.UIRuleUtil.isNull(txttotalWeight.getValue()))) 
{
}
else
{
    txtpredictRecAmt.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txttotalWeight.getValue())* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtpricePerKG.getValue()))* 0.87)+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtproductCost.getValue())));
}


    }

    /**
     * output txtyieldRate_Changed() method
     */
    public void txtyieldRate_Changed() throws Exception
    {
        System.out.println("txtyieldRate_Changed() Function is executed!");
            if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtyieldRate.getValue())|| com.kingdee.bos.ui.face.UIRuleUtil.isNull(txttotalWeight.getValue())) 
{
}
else
{
    txtyield.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtyieldRate.getValue())* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txttotalWeight.getValue()))/ 100));
}

    if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtyieldRate.getValue())|| com.kingdee.bos.ui.face.UIRuleUtil.isNull(txttotalWeight.getValue())) 
{
}
else
{
    txtexpectedRec.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtyieldRate.getValue())* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txttotalWeight.getValue()))/ 100));
}


    }

    /**
     * output txtproductCost_Changed() method
     */
    public void txtproductCost_Changed() throws Exception
    {
        System.out.println("txtproductCost_Changed() Function is executed!");
            if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtexpectedSalesAmt.getValue())|| (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtexpectedPricePerTon.getValue())|| (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txttotalWeight.getValue())|| (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtpricePerKG.getValue())|| (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtproductCost.getValue())|| com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtstockAmtAtMonthBegin.getValue())))))) 
{
}
else
{
    txtsaleProfit.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtexpectedSalesAmt.getValue())* (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtexpectedPricePerTon.getValue())- (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtstockAmtAtMonthBegin.getValue())- (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txttotalWeight.getValue())* (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtpricePerKG.getValue())* 0.87)))))- com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtproductCost.getValue()))/ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtexpectedSalesAmt.getValue())));
}

    if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtexpectedSalesAmt.getValue())|| (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtexpectedPricePerTon.getValue())|| (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtstockAmtAtMonthBegin.getValue())|| (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtproductCost.getValue())|| (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtpricePerKG.getValue())|| (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txttotalWeight.getValue())|| (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtmanageFee.getValue())|| (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtFIFee.getValue())|| com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtsaleFee.getValue()))))))))) 
{
}
else
{
    txtcompanyProfit.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtexpectedSalesAmt.getValue())* (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtexpectedPricePerTon.getValue())- (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtstockAmtAtMonthBegin.getValue())- (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtpricePerKG.getValue())* (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txttotolCost.getValue())* (0.87- (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtproductCost.getValue())- (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmanageFee.getValue())- com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtFIFee.getValue())))))))))- com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtsaleFee.getValue())));
}

    if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtproductCost.getValue())|| com.kingdee.bos.ui.face.UIRuleUtil.isNull(txttotolCost.getValue())) 
{
}
else
{
    txtpredictRecAmt.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtproductCost.getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txttotolCost.getValue())* 0.87)));
}

    if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txttotolCost.getValue())|| (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtyield.getValue())|| (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtproductCost.getValue())|| (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtstockAmtAtMonthBegin.getValue())|| com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtstockAtMonthBegin.getValue()))))) 
{
}
else
{
    txtexpectedsalesCostPerKG.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(((0.87* (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txttotolCost.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtproductCost.getValue())))+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtstockAmtAtMonthBegin.getValue()))/ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtstockAtMonthBegin.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtyield.getValue()))));
}

    if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txttotolCost.getValue())|| (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtproductCost.getValue())|| com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtstockAmtAtMonthBegin.getValue()))) 
{
}
else
{
    txtexpectedSaleCost.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txttotolCost.getValue())* 0.87)+ (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtproductCost.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtstockAmtAtMonthBegin.getValue()))));
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
        sic.add(new SelectorItemInfo("expectedSalesAmt"));
        sic.add(new SelectorItemInfo("expectedPricePerTon"));
        sic.add(new SelectorItemInfo("expectedSalesRevenue"));
        sic.add(new SelectorItemInfo("totalWeight"));
        sic.add(new SelectorItemInfo("pricePerKG"));
        sic.add(new SelectorItemInfo("totolCost"));
        sic.add(new SelectorItemInfo("yieldRate"));
        sic.add(new SelectorItemInfo("yield"));
        sic.add(new SelectorItemInfo("productCost"));
        sic.add(new SelectorItemInfo("stockAtMonthBegin"));
        sic.add(new SelectorItemInfo("stockAmtAtMonthBegin"));
        sic.add(new SelectorItemInfo("expectedRec"));
        sic.add(new SelectorItemInfo("predictRecAmt"));
        sic.add(new SelectorItemInfo("expectedSaleCost"));
        sic.add(new SelectorItemInfo("expectedsalesCostPerKG"));
        sic.add(new SelectorItemInfo("manageFee"));
        sic.add(new SelectorItemInfo("FIFee"));
        sic.add(new SelectorItemInfo("saleFee"));
        sic.add(new SelectorItemInfo("saleProfit"));
        sic.add(new SelectorItemInfo("companyProfit"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("period.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("period.id"));
        	sic.add(new SelectorItemInfo("period.number"));
		}
        sic.add(new SelectorItemInfo("billStatus"));
        sic.add(new SelectorItemInfo("description"));
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
        com.kingdee.eas.custom.bsxbudget.BSXBudgetFoodFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.bsxbudget.BSXBudgetFoodFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractBSXBudgetFoodEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractBSXBudgetFoodEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.bsxbudget.client", "BSXBudgetFoodEditUI");
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
        return com.kingdee.eas.custom.bsxbudget.client.BSXBudgetFoodEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.bsxbudget.BSXBudgetFoodFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.bsxbudget.BSXBudgetFoodInfo objectValue = new com.kingdee.eas.custom.bsxbudget.BSXBudgetFoodInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/bsxbudget/BSXBudgetFood";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.bsxbudget.app.BSXBudgetFoodQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtNumber.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"单据编号"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtexpectedSalesAmt.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"预计销量"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtexpectedPricePerTon.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"预计吨平均售价"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtpricePerKG.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"单位毛鸡收购价格"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtyieldRate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"毛鸡出成率"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtproductCost.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"生产费用"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtmanageFee.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"管理费用"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtFIFee.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务费用"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtsaleFee.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"销售费用"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtperiod.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"期间"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {        
        return null;
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