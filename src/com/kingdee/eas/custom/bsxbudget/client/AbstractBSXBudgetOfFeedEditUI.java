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
public abstract class AbstractBSXBudgetOfFeedEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractBSXBudgetOfFeedEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDButton btnPriceOfChicken;
    protected com.kingdee.bos.ctrl.swing.KDButton btnGetLairageQty;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperiod;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfeedPeriod;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdescription;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanelCommercialChicken;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanelFeed;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanelFarmProfit;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanelCCCost;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanelFeedConsumption;
    protected com.kingdee.bos.ctrl.swing.KDPanel kdPanelAnticipatedRevenue;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator9;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator10;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaverageCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaverageCostOfChicks;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaverageCostOfmedicine;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaverageCostOfFeedstuff;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalCostOfCC;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalCostOfChicks;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalCostOfMedicine;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfeeOfOthers;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtaverageCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtaverageCostOfChicks;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtaverageCostOfmedicine;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtaverageCostOfFeedstuff;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalCostOfCC;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalCostOfChicks;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalCostOfMedicine;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfeeOfOthers;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaverageWeight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalWeight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfeedToMeatRatio;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaveFeedConsumption;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtaverageWeight;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalWeight;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfeedToMeatRatio;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtaveFeedConsumption;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlairageQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsurvivalRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contslaughterQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtlairageQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsurvivalRate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtslaughterQty;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstandardCostOfAverage;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstandardCostOfNo1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalCostOfNo1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstandardCostOfNo2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalCostOfNo2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstandardCostOfNo3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalCostOfNo3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstandardCostOfNo4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalCostOfNo4;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtstandardCostOfAverage;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtstandardCostOfNo1;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalCostOfNo1;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtstandardCostOfNo2;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalCostOfNo2;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtstandardCostOfNo3;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalCostOfNo3;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtstandardCostOfNo4;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalCostOfNo4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contforageConsumption;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contratioOfNo1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalQtyOfNo1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contratioOfNo2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contratioOfNo3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalQtyOfNo2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalQtyOfNo3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contratioOfNo4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalQtyOfNo4;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtforageConsumption;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtratioOfNo1;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalQtyOfNo1;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtratioOfNo2;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtratioOfNo3;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalQtyOfNo2;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalQtyOfNo3;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtratioOfNo4;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalQtyOfNo4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpriceOfWholeChicken;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrevenueOfChickens;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrevenueOfOthers;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmainCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcostOfOthers;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfeeOfManage;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfeeOfFinance;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpredictedTotalRevenue;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpredictedTotalCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpredictedProfit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpredictTotalFee;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpriceOfWholeChicken;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtrevenueOfChickens;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtrevenueOfOthers;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmainCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcostOfOthers;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfeeOfManage;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfeeOfFinance;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpredictedTotalRevenue;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpredictedTotalCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpredictedProfit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpredictTotalFee;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperiod;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfeedPeriod;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdescription;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton getLairageQty;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.custom.bsxbudget.BSXBudgetOfFeedInfo editData = null;
    protected ActionGetLairageQty actionGetLairageQty = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractBSXBudgetOfFeedEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractBSXBudgetOfFeedEditUI.class.getName());
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
        //actionGetLairageQty
        this.actionGetLairageQty = new ActionGetLairageQty(this);
        getActionManager().registerAction("actionGetLairageQty", actionGetLairageQty);
        this.actionGetLairageQty.setExtendProperty("canForewarn", "true");
        this.actionGetLairageQty.setExtendProperty("userDefined", "false");
        this.actionGetLairageQty.setExtendProperty("isObjectUpdateLock", "false");
         this.actionGetLairageQty.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionGetLairageQty.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
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
        this.btnPriceOfChicken = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnGetLairageQty = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperiod = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfeedPeriod = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDPanelCommercialChicken = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanelFeed = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanelFarmProfit = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanelCCCost = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanelFeedConsumption = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdPanelAnticipatedRevenue = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDSeparator9 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDSeparator10 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contaverageCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contaverageCostOfChicks = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contaverageCostOfmedicine = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contaverageCostOfFeedstuff = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalCostOfCC = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalCostOfChicks = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalCostOfMedicine = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfeeOfOthers = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtaverageCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtaverageCostOfChicks = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtaverageCostOfmedicine = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtaverageCostOfFeedstuff = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttotalCostOfCC = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttotalCostOfChicks = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttotalCostOfMedicine = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfeeOfOthers = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contaverageWeight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalWeight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfeedToMeatRatio = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contaveFeedConsumption = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtaverageWeight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttotalWeight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfeedToMeatRatio = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtaveFeedConsumption = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contlairageQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsurvivalRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contslaughterQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtlairageQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsurvivalRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtslaughterQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contstandardCostOfAverage = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstandardCostOfNo1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalCostOfNo1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstandardCostOfNo2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalCostOfNo2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstandardCostOfNo3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalCostOfNo3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstandardCostOfNo4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalCostOfNo4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtstandardCostOfAverage = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtstandardCostOfNo1 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttotalCostOfNo1 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttotalCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtstandardCostOfNo2 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttotalCostOfNo2 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtstandardCostOfNo3 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttotalCostOfNo3 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtstandardCostOfNo4 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttotalCostOfNo4 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contforageConsumption = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contratioOfNo1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalQtyOfNo1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contratioOfNo2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contratioOfNo3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalQtyOfNo2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalQtyOfNo3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contratioOfNo4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalQtyOfNo4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtforageConsumption = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtratioOfNo1 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttotalQtyOfNo1 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtratioOfNo2 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtratioOfNo3 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttotalQtyOfNo2 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttotalQtyOfNo3 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtratioOfNo4 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttotalQtyOfNo4 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contpriceOfWholeChicken = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrevenueOfChickens = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrevenueOfOthers = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmainCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcostOfOthers = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfeeOfManage = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfeeOfFinance = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpredictedTotalRevenue = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpredictedTotalCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpredictedProfit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpredictTotalFee = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtpriceOfWholeChicken = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtrevenueOfChickens = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtrevenueOfOthers = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmainCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcostOfOthers = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfeeOfManage = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfeeOfFinance = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpredictedTotalRevenue = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpredictedTotalCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpredictedProfit = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpredictTotalFee = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtperiod = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtfeedPeriod = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.getLairageQty = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnPriceOfChicken.setName("btnPriceOfChicken");
        this.btnGetLairageQty.setName("btnGetLairageQty");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contAuditor.setName("contAuditor");
        this.contauditTime.setName("contauditTime");
        this.contperiod.setName("contperiod");
        this.contbillStatus.setName("contbillStatus");
        this.contfeedPeriod.setName("contfeedPeriod");
        this.contdescription.setName("contdescription");
        this.kDPanelCommercialChicken.setName("kDPanelCommercialChicken");
        this.kDPanelFeed.setName("kDPanelFeed");
        this.kDPanelFarmProfit.setName("kDPanelFarmProfit");
        this.kDPanelCCCost.setName("kDPanelCCCost");
        this.kDPanelFeedConsumption.setName("kDPanelFeedConsumption");
        this.kdPanelAnticipatedRevenue.setName("kdPanelAnticipatedRevenue");
        this.kDSeparator9.setName("kDSeparator9");
        this.kDSeparator10.setName("kDSeparator10");
        this.contaverageCost.setName("contaverageCost");
        this.contaverageCostOfChicks.setName("contaverageCostOfChicks");
        this.contaverageCostOfmedicine.setName("contaverageCostOfmedicine");
        this.contaverageCostOfFeedstuff.setName("contaverageCostOfFeedstuff");
        this.conttotalCostOfCC.setName("conttotalCostOfCC");
        this.conttotalCostOfChicks.setName("conttotalCostOfChicks");
        this.conttotalCostOfMedicine.setName("conttotalCostOfMedicine");
        this.contfeeOfOthers.setName("contfeeOfOthers");
        this.txtaverageCost.setName("txtaverageCost");
        this.txtaverageCostOfChicks.setName("txtaverageCostOfChicks");
        this.txtaverageCostOfmedicine.setName("txtaverageCostOfmedicine");
        this.txtaverageCostOfFeedstuff.setName("txtaverageCostOfFeedstuff");
        this.txttotalCostOfCC.setName("txttotalCostOfCC");
        this.txttotalCostOfChicks.setName("txttotalCostOfChicks");
        this.txttotalCostOfMedicine.setName("txttotalCostOfMedicine");
        this.txtfeeOfOthers.setName("txtfeeOfOthers");
        this.contaverageWeight.setName("contaverageWeight");
        this.conttotalWeight.setName("conttotalWeight");
        this.contfeedToMeatRatio.setName("contfeedToMeatRatio");
        this.contaveFeedConsumption.setName("contaveFeedConsumption");
        this.txtaverageWeight.setName("txtaverageWeight");
        this.txttotalWeight.setName("txttotalWeight");
        this.txtfeedToMeatRatio.setName("txtfeedToMeatRatio");
        this.txtaveFeedConsumption.setName("txtaveFeedConsumption");
        this.contlairageQty.setName("contlairageQty");
        this.contsurvivalRate.setName("contsurvivalRate");
        this.contslaughterQty.setName("contslaughterQty");
        this.txtlairageQty.setName("txtlairageQty");
        this.txtsurvivalRate.setName("txtsurvivalRate");
        this.txtslaughterQty.setName("txtslaughterQty");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel.setName("kDPanel");
        this.contstandardCostOfAverage.setName("contstandardCostOfAverage");
        this.contstandardCostOfNo1.setName("contstandardCostOfNo1");
        this.conttotalCostOfNo1.setName("conttotalCostOfNo1");
        this.conttotalCost.setName("conttotalCost");
        this.contstandardCostOfNo2.setName("contstandardCostOfNo2");
        this.conttotalCostOfNo2.setName("conttotalCostOfNo2");
        this.contstandardCostOfNo3.setName("contstandardCostOfNo3");
        this.conttotalCostOfNo3.setName("conttotalCostOfNo3");
        this.contstandardCostOfNo4.setName("contstandardCostOfNo4");
        this.conttotalCostOfNo4.setName("conttotalCostOfNo4");
        this.txtstandardCostOfAverage.setName("txtstandardCostOfAverage");
        this.txtstandardCostOfNo1.setName("txtstandardCostOfNo1");
        this.txttotalCostOfNo1.setName("txttotalCostOfNo1");
        this.txttotalCost.setName("txttotalCost");
        this.txtstandardCostOfNo2.setName("txtstandardCostOfNo2");
        this.txttotalCostOfNo2.setName("txttotalCostOfNo2");
        this.txtstandardCostOfNo3.setName("txtstandardCostOfNo3");
        this.txttotalCostOfNo3.setName("txttotalCostOfNo3");
        this.txtstandardCostOfNo4.setName("txtstandardCostOfNo4");
        this.txttotalCostOfNo4.setName("txttotalCostOfNo4");
        this.contforageConsumption.setName("contforageConsumption");
        this.contratioOfNo1.setName("contratioOfNo1");
        this.conttotalQtyOfNo1.setName("conttotalQtyOfNo1");
        this.contratioOfNo2.setName("contratioOfNo2");
        this.contratioOfNo3.setName("contratioOfNo3");
        this.conttotalQtyOfNo2.setName("conttotalQtyOfNo2");
        this.conttotalQtyOfNo3.setName("conttotalQtyOfNo3");
        this.contratioOfNo4.setName("contratioOfNo4");
        this.conttotalQtyOfNo4.setName("conttotalQtyOfNo4");
        this.txtforageConsumption.setName("txtforageConsumption");
        this.txtratioOfNo1.setName("txtratioOfNo1");
        this.txttotalQtyOfNo1.setName("txttotalQtyOfNo1");
        this.txtratioOfNo2.setName("txtratioOfNo2");
        this.txtratioOfNo3.setName("txtratioOfNo3");
        this.txttotalQtyOfNo2.setName("txttotalQtyOfNo2");
        this.txttotalQtyOfNo3.setName("txttotalQtyOfNo3");
        this.txtratioOfNo4.setName("txtratioOfNo4");
        this.txttotalQtyOfNo4.setName("txttotalQtyOfNo4");
        this.contpriceOfWholeChicken.setName("contpriceOfWholeChicken");
        this.contrevenueOfChickens.setName("contrevenueOfChickens");
        this.contrevenueOfOthers.setName("contrevenueOfOthers");
        this.contmainCost.setName("contmainCost");
        this.contcostOfOthers.setName("contcostOfOthers");
        this.contfeeOfManage.setName("contfeeOfManage");
        this.contfeeOfFinance.setName("contfeeOfFinance");
        this.contpredictedTotalRevenue.setName("contpredictedTotalRevenue");
        this.contpredictedTotalCost.setName("contpredictedTotalCost");
        this.contpredictedProfit.setName("contpredictedProfit");
        this.contpredictTotalFee.setName("contpredictTotalFee");
        this.txtpriceOfWholeChicken.setName("txtpriceOfWholeChicken");
        this.txtrevenueOfChickens.setName("txtrevenueOfChickens");
        this.txtrevenueOfOthers.setName("txtrevenueOfOthers");
        this.txtmainCost.setName("txtmainCost");
        this.txtcostOfOthers.setName("txtcostOfOthers");
        this.txtfeeOfManage.setName("txtfeeOfManage");
        this.txtfeeOfFinance.setName("txtfeeOfFinance");
        this.txtpredictedTotalRevenue.setName("txtpredictedTotalRevenue");
        this.txtpredictedTotalCost.setName("txtpredictedTotalCost");
        this.txtpredictedProfit.setName("txtpredictedProfit");
        this.txtpredictTotalFee.setName("txtpredictTotalFee");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.prmtAuditor.setName("prmtAuditor");
        this.pkauditTime.setName("pkauditTime");
        this.prmtperiod.setName("prmtperiod");
        this.billStatus.setName("billStatus");
        this.txtfeedPeriod.setName("txtfeedPeriod");
        this.txtdescription.setName("txtdescription");
        this.getLairageQty.setName("getLairageQty");
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
        // btnPriceOfChicken		
        this.btnPriceOfChicken.setText(resHelper.getString("btnPriceOfChicken.text"));
        this.btnPriceOfChicken.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                try {
                    btnPriceOfChicken_mouseClick(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });
        // btnGetLairageQty		
        this.btnGetLairageQty.setText(resHelper.getString("btnGetLairageQty.text"));
        this.btnGetLairageQty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                try {
                    btnGetLairageQty_mouseClick(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });
        // kDTabbedPane1
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
        // contfeedPeriod		
        this.contfeedPeriod.setBoundLabelText(resHelper.getString("contfeedPeriod.boundLabelText"));		
        this.contfeedPeriod.setBoundLabelLength(100);		
        this.contfeedPeriod.setBoundLabelUnderline(true);		
        this.contfeedPeriod.setVisible(true);
        // contdescription		
        this.contdescription.setBoundLabelText(resHelper.getString("contdescription.boundLabelText"));		
        this.contdescription.setBoundLabelLength(100);		
        this.contdescription.setBoundLabelUnderline(true);		
        this.contdescription.setVisible(true);
        // kDPanelCommercialChicken		
        this.kDPanelCommercialChicken.setBorder(null);
        // kDPanelFeed
        // kDPanelFarmProfit
        // kDPanelCCCost		
        this.kDPanelCCCost.setBorder(new TitledBorder(BorderFactory.createLineBorder(new Color(0,0,0),1), resHelper.getString("kDPanelCCCost.border.title")));
        // kDPanelFeedConsumption		
        this.kDPanelFeedConsumption.setBorder(new TitledBorder(BorderFactory.createLineBorder(new Color(0,0,0),1), resHelper.getString("kDPanelFeedConsumption.border.title")));
        // kdPanelAnticipatedRevenue		
        this.kdPanelAnticipatedRevenue.setBorder(new TitledBorder(BorderFactory.createLineBorder(new Color(0,0,0),1), resHelper.getString("kdPanelAnticipatedRevenue.border.title")));
        // kDSeparator9
        // kDSeparator10
        // contaverageCost		
        this.contaverageCost.setBoundLabelText(resHelper.getString("contaverageCost.boundLabelText"));		
        this.contaverageCost.setBoundLabelLength(120);		
        this.contaverageCost.setBoundLabelUnderline(true);		
        this.contaverageCost.setVisible(true);
        // contaverageCostOfChicks		
        this.contaverageCostOfChicks.setBoundLabelText(resHelper.getString("contaverageCostOfChicks.boundLabelText"));		
        this.contaverageCostOfChicks.setBoundLabelLength(120);		
        this.contaverageCostOfChicks.setBoundLabelUnderline(true);		
        this.contaverageCostOfChicks.setVisible(true);
        // contaverageCostOfmedicine		
        this.contaverageCostOfmedicine.setBoundLabelText(resHelper.getString("contaverageCostOfmedicine.boundLabelText"));		
        this.contaverageCostOfmedicine.setBoundLabelLength(120);		
        this.contaverageCostOfmedicine.setBoundLabelUnderline(true);		
        this.contaverageCostOfmedicine.setVisible(true);
        // contaverageCostOfFeedstuff		
        this.contaverageCostOfFeedstuff.setBoundLabelText(resHelper.getString("contaverageCostOfFeedstuff.boundLabelText"));		
        this.contaverageCostOfFeedstuff.setBoundLabelLength(120);		
        this.contaverageCostOfFeedstuff.setBoundLabelUnderline(true);		
        this.contaverageCostOfFeedstuff.setVisible(true);
        // conttotalCostOfCC		
        this.conttotalCostOfCC.setBoundLabelText(resHelper.getString("conttotalCostOfCC.boundLabelText"));		
        this.conttotalCostOfCC.setBoundLabelLength(120);		
        this.conttotalCostOfCC.setBoundLabelUnderline(true);		
        this.conttotalCostOfCC.setVisible(true);
        // conttotalCostOfChicks		
        this.conttotalCostOfChicks.setBoundLabelText(resHelper.getString("conttotalCostOfChicks.boundLabelText"));		
        this.conttotalCostOfChicks.setBoundLabelLength(120);		
        this.conttotalCostOfChicks.setBoundLabelUnderline(true);		
        this.conttotalCostOfChicks.setVisible(true);
        // conttotalCostOfMedicine		
        this.conttotalCostOfMedicine.setBoundLabelText(resHelper.getString("conttotalCostOfMedicine.boundLabelText"));		
        this.conttotalCostOfMedicine.setBoundLabelLength(120);		
        this.conttotalCostOfMedicine.setBoundLabelUnderline(true);		
        this.conttotalCostOfMedicine.setVisible(true);
        // contfeeOfOthers		
        this.contfeeOfOthers.setBoundLabelText(resHelper.getString("contfeeOfOthers.boundLabelText"));		
        this.contfeeOfOthers.setBoundLabelLength(120);		
        this.contfeeOfOthers.setBoundLabelUnderline(true);		
        this.contfeeOfOthers.setVisible(true);
        // txtaverageCost		
        this.txtaverageCost.setVisible(true);		
        this.txtaverageCost.setHorizontalAlignment(2);		
        this.txtaverageCost.setDataType(1);		
        this.txtaverageCost.setSupportedEmpty(true);		
        this.txtaverageCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtaverageCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtaverageCost.setPrecision(2);		
        this.txtaverageCost.setRequired(false);		
        this.txtaverageCost.setEnabled(false);
        // txtaverageCostOfChicks		
        this.txtaverageCostOfChicks.setVisible(true);		
        this.txtaverageCostOfChicks.setHorizontalAlignment(2);		
        this.txtaverageCostOfChicks.setDataType(1);		
        this.txtaverageCostOfChicks.setSupportedEmpty(true);		
        this.txtaverageCostOfChicks.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtaverageCostOfChicks.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtaverageCostOfChicks.setPrecision(2);		
        this.txtaverageCostOfChicks.setRequired(false);
        this.txtaverageCostOfChicks.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtaverageCostOfChicks_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtaverageCostOfmedicine		
        this.txtaverageCostOfmedicine.setVisible(true);		
        this.txtaverageCostOfmedicine.setHorizontalAlignment(2);		
        this.txtaverageCostOfmedicine.setDataType(1);		
        this.txtaverageCostOfmedicine.setSupportedEmpty(true);		
        this.txtaverageCostOfmedicine.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtaverageCostOfmedicine.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtaverageCostOfmedicine.setPrecision(2);		
        this.txtaverageCostOfmedicine.setRequired(false);
        this.txtaverageCostOfmedicine.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtaverageCostOfmedicine_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtaverageCostOfFeedstuff		
        this.txtaverageCostOfFeedstuff.setVisible(true);		
        this.txtaverageCostOfFeedstuff.setHorizontalAlignment(2);		
        this.txtaverageCostOfFeedstuff.setDataType(1);		
        this.txtaverageCostOfFeedstuff.setSupportedEmpty(true);		
        this.txtaverageCostOfFeedstuff.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtaverageCostOfFeedstuff.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtaverageCostOfFeedstuff.setPrecision(2);		
        this.txtaverageCostOfFeedstuff.setRequired(false);		
        this.txtaverageCostOfFeedstuff.setEnabled(false);
        // txttotalCostOfCC		
        this.txttotalCostOfCC.setVisible(true);		
        this.txttotalCostOfCC.setHorizontalAlignment(2);		
        this.txttotalCostOfCC.setDataType(1);		
        this.txttotalCostOfCC.setSupportedEmpty(true);		
        this.txttotalCostOfCC.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttotalCostOfCC.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttotalCostOfCC.setPrecision(2);		
        this.txttotalCostOfCC.setRequired(false);		
        this.txttotalCostOfCC.setEnabled(false);
        // txttotalCostOfChicks		
        this.txttotalCostOfChicks.setVisible(true);		
        this.txttotalCostOfChicks.setHorizontalAlignment(2);		
        this.txttotalCostOfChicks.setDataType(1);		
        this.txttotalCostOfChicks.setSupportedEmpty(true);		
        this.txttotalCostOfChicks.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttotalCostOfChicks.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttotalCostOfChicks.setPrecision(2);		
        this.txttotalCostOfChicks.setRequired(false);		
        this.txttotalCostOfChicks.setEnabled(false);
        // txttotalCostOfMedicine		
        this.txttotalCostOfMedicine.setVisible(true);		
        this.txttotalCostOfMedicine.setHorizontalAlignment(2);		
        this.txttotalCostOfMedicine.setDataType(1);		
        this.txttotalCostOfMedicine.setSupportedEmpty(true);		
        this.txttotalCostOfMedicine.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttotalCostOfMedicine.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttotalCostOfMedicine.setPrecision(2);		
        this.txttotalCostOfMedicine.setRequired(false);		
        this.txttotalCostOfMedicine.setEnabled(false);
        // txtfeeOfOthers		
        this.txtfeeOfOthers.setVisible(true);		
        this.txtfeeOfOthers.setHorizontalAlignment(2);		
        this.txtfeeOfOthers.setDataType(1);		
        this.txtfeeOfOthers.setSupportedEmpty(true);		
        this.txtfeeOfOthers.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfeeOfOthers.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfeeOfOthers.setPrecision(2);		
        this.txtfeeOfOthers.setRequired(false);
        this.txtfeeOfOthers.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtfeeOfOthers_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // contaverageWeight		
        this.contaverageWeight.setBoundLabelText(resHelper.getString("contaverageWeight.boundLabelText"));		
        this.contaverageWeight.setBoundLabelLength(100);		
        this.contaverageWeight.setBoundLabelUnderline(true);		
        this.contaverageWeight.setVisible(true);
        // conttotalWeight		
        this.conttotalWeight.setBoundLabelText(resHelper.getString("conttotalWeight.boundLabelText"));		
        this.conttotalWeight.setBoundLabelLength(100);		
        this.conttotalWeight.setBoundLabelUnderline(true);		
        this.conttotalWeight.setVisible(true);
        // contfeedToMeatRatio		
        this.contfeedToMeatRatio.setBoundLabelText(resHelper.getString("contfeedToMeatRatio.boundLabelText"));		
        this.contfeedToMeatRatio.setBoundLabelLength(100);		
        this.contfeedToMeatRatio.setBoundLabelUnderline(true);		
        this.contfeedToMeatRatio.setVisible(true);
        // contaveFeedConsumption		
        this.contaveFeedConsumption.setBoundLabelText(resHelper.getString("contaveFeedConsumption.boundLabelText"));		
        this.contaveFeedConsumption.setBoundLabelLength(100);		
        this.contaveFeedConsumption.setBoundLabelUnderline(true);		
        this.contaveFeedConsumption.setVisible(true);
        // txtaverageWeight		
        this.txtaverageWeight.setVisible(true);		
        this.txtaverageWeight.setHorizontalAlignment(2);		
        this.txtaverageWeight.setDataType(1);		
        this.txtaverageWeight.setSupportedEmpty(true);		
        this.txtaverageWeight.setMinimumValue( new java.math.BigDecimal("-1.0E22"));		
        this.txtaverageWeight.setMaximumValue( new java.math.BigDecimal("1.0E22"));		
        this.txtaverageWeight.setPrecision(6);		
        this.txtaverageWeight.setRequired(true);
        this.txtaverageWeight.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtaverageWeight_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txttotalWeight		
        this.txttotalWeight.setVisible(true);		
        this.txttotalWeight.setHorizontalAlignment(2);		
        this.txttotalWeight.setDataType(1);		
        this.txttotalWeight.setSupportedEmpty(true);		
        this.txttotalWeight.setMinimumValue( new java.math.BigDecimal("-1.0E22"));		
        this.txttotalWeight.setMaximumValue( new java.math.BigDecimal("1.0E22"));		
        this.txttotalWeight.setPrecision(6);		
        this.txttotalWeight.setRequired(false);		
        this.txttotalWeight.setEnabled(false);
        // txtfeedToMeatRatio		
        this.txtfeedToMeatRatio.setVisible(true);		
        this.txtfeedToMeatRatio.setHorizontalAlignment(2);		
        this.txtfeedToMeatRatio.setDataType(1);		
        this.txtfeedToMeatRatio.setSupportedEmpty(true);		
        this.txtfeedToMeatRatio.setMinimumValue( new java.math.BigDecimal("-1.0E22"));		
        this.txtfeedToMeatRatio.setMaximumValue( new java.math.BigDecimal("1.0E22"));		
        this.txtfeedToMeatRatio.setPrecision(6);		
        this.txtfeedToMeatRatio.setRequired(true);
        this.txtfeedToMeatRatio.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtfeedToMeatRatio_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtaveFeedConsumption		
        this.txtaveFeedConsumption.setVisible(true);		
        this.txtaveFeedConsumption.setHorizontalAlignment(2);		
        this.txtaveFeedConsumption.setDataType(1);		
        this.txtaveFeedConsumption.setSupportedEmpty(true);		
        this.txtaveFeedConsumption.setMinimumValue( new java.math.BigDecimal("-1.0E22"));		
        this.txtaveFeedConsumption.setMaximumValue( new java.math.BigDecimal("1.0E22"));		
        this.txtaveFeedConsumption.setPrecision(6);		
        this.txtaveFeedConsumption.setRequired(false);		
        this.txtaveFeedConsumption.setEnabled(false);
        // contlairageQty		
        this.contlairageQty.setBoundLabelText(resHelper.getString("contlairageQty.boundLabelText"));		
        this.contlairageQty.setBoundLabelLength(100);		
        this.contlairageQty.setBoundLabelUnderline(true);		
        this.contlairageQty.setVisible(true);
        // contsurvivalRate		
        this.contsurvivalRate.setBoundLabelText(resHelper.getString("contsurvivalRate.boundLabelText"));		
        this.contsurvivalRate.setBoundLabelLength(100);		
        this.contsurvivalRate.setBoundLabelUnderline(true);		
        this.contsurvivalRate.setVisible(true);
        // contslaughterQty		
        this.contslaughterQty.setBoundLabelText(resHelper.getString("contslaughterQty.boundLabelText"));		
        this.contslaughterQty.setBoundLabelLength(100);		
        this.contslaughterQty.setBoundLabelUnderline(true);		
        this.contslaughterQty.setVisible(true);
        // txtlairageQty		
        this.txtlairageQty.setVisible(true);		
        this.txtlairageQty.setHorizontalAlignment(2);		
        this.txtlairageQty.setDataType(1);		
        this.txtlairageQty.setSupportedEmpty(true);		
        this.txtlairageQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtlairageQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtlairageQty.setPrecision(4);		
        this.txtlairageQty.setRequired(false);		
        this.txtlairageQty.setEnabled(false);
        this.txtlairageQty.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtlairageQty_dataChang(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtsurvivalRate		
        this.txtsurvivalRate.setVisible(true);		
        this.txtsurvivalRate.setHorizontalAlignment(2);		
        this.txtsurvivalRate.setDataType(1);		
        this.txtsurvivalRate.setSupportedEmpty(true);		
        this.txtsurvivalRate.setMinimumValue( new java.math.BigDecimal("-1.0E22"));		
        this.txtsurvivalRate.setMaximumValue( new java.math.BigDecimal("1.0E22"));		
        this.txtsurvivalRate.setPrecision(6);		
        this.txtsurvivalRate.setRequired(true);
        this.txtsurvivalRate.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtsurvivalRate_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtslaughterQty		
        this.txtslaughterQty.setVisible(true);		
        this.txtslaughterQty.setHorizontalAlignment(2);		
        this.txtslaughterQty.setSupportedEmpty(true);		
        this.txtslaughterQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtslaughterQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtslaughterQty.setPrecision(4);		
        this.txtslaughterQty.setRequired(false);		
        this.txtslaughterQty.setEnabled(false);
        // kDPanel1		
        this.kDPanel1.setBorder(new TitledBorder(BorderFactory.createLineBorder(new Color(0,0,0),1), resHelper.getString("kDPanel1.border.title")));
        // kDPanel		
        this.kDPanel.setBorder(new TitledBorder(BorderFactory.createLineBorder(new Color(0,0,0),1), resHelper.getString("kDPanel.border.title")));
        // contstandardCostOfAverage		
        this.contstandardCostOfAverage.setBoundLabelText(resHelper.getString("contstandardCostOfAverage.boundLabelText"));		
        this.contstandardCostOfAverage.setBoundLabelLength(140);		
        this.contstandardCostOfAverage.setBoundLabelUnderline(true);		
        this.contstandardCostOfAverage.setVisible(true);
        // contstandardCostOfNo1		
        this.contstandardCostOfNo1.setBoundLabelText(resHelper.getString("contstandardCostOfNo1.boundLabelText"));		
        this.contstandardCostOfNo1.setBoundLabelLength(140);		
        this.contstandardCostOfNo1.setBoundLabelUnderline(true);		
        this.contstandardCostOfNo1.setVisible(true);
        // conttotalCostOfNo1		
        this.conttotalCostOfNo1.setBoundLabelText(resHelper.getString("conttotalCostOfNo1.boundLabelText"));		
        this.conttotalCostOfNo1.setBoundLabelLength(140);		
        this.conttotalCostOfNo1.setBoundLabelUnderline(true);		
        this.conttotalCostOfNo1.setVisible(true);
        // conttotalCost		
        this.conttotalCost.setBoundLabelText(resHelper.getString("conttotalCost.boundLabelText"));		
        this.conttotalCost.setBoundLabelLength(140);		
        this.conttotalCost.setBoundLabelUnderline(true);		
        this.conttotalCost.setVisible(true);
        // contstandardCostOfNo2		
        this.contstandardCostOfNo2.setBoundLabelText(resHelper.getString("contstandardCostOfNo2.boundLabelText"));		
        this.contstandardCostOfNo2.setBoundLabelLength(140);		
        this.contstandardCostOfNo2.setBoundLabelUnderline(true);		
        this.contstandardCostOfNo2.setVisible(true);
        // conttotalCostOfNo2		
        this.conttotalCostOfNo2.setBoundLabelText(resHelper.getString("conttotalCostOfNo2.boundLabelText"));		
        this.conttotalCostOfNo2.setBoundLabelLength(140);		
        this.conttotalCostOfNo2.setBoundLabelUnderline(true);		
        this.conttotalCostOfNo2.setVisible(true);
        // contstandardCostOfNo3		
        this.contstandardCostOfNo3.setBoundLabelText(resHelper.getString("contstandardCostOfNo3.boundLabelText"));		
        this.contstandardCostOfNo3.setBoundLabelLength(140);		
        this.contstandardCostOfNo3.setBoundLabelUnderline(true);		
        this.contstandardCostOfNo3.setVisible(true);
        // conttotalCostOfNo3		
        this.conttotalCostOfNo3.setBoundLabelText(resHelper.getString("conttotalCostOfNo3.boundLabelText"));		
        this.conttotalCostOfNo3.setBoundLabelLength(140);		
        this.conttotalCostOfNo3.setBoundLabelUnderline(true);		
        this.conttotalCostOfNo3.setVisible(true);
        // contstandardCostOfNo4		
        this.contstandardCostOfNo4.setBoundLabelText(resHelper.getString("contstandardCostOfNo4.boundLabelText"));		
        this.contstandardCostOfNo4.setBoundLabelLength(140);		
        this.contstandardCostOfNo4.setBoundLabelUnderline(true);		
        this.contstandardCostOfNo4.setVisible(true);
        // conttotalCostOfNo4		
        this.conttotalCostOfNo4.setBoundLabelText(resHelper.getString("conttotalCostOfNo4.boundLabelText"));		
        this.conttotalCostOfNo4.setBoundLabelLength(140);		
        this.conttotalCostOfNo4.setBoundLabelUnderline(true);		
        this.conttotalCostOfNo4.setVisible(true);
        // txtstandardCostOfAverage		
        this.txtstandardCostOfAverage.setVisible(true);		
        this.txtstandardCostOfAverage.setHorizontalAlignment(2);		
        this.txtstandardCostOfAverage.setDataType(1);		
        this.txtstandardCostOfAverage.setSupportedEmpty(true);		
        this.txtstandardCostOfAverage.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtstandardCostOfAverage.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtstandardCostOfAverage.setPrecision(3);		
        this.txtstandardCostOfAverage.setRequired(false);		
        this.txtstandardCostOfAverage.setEnabled(false);
        // txtstandardCostOfNo1		
        this.txtstandardCostOfNo1.setVisible(true);		
        this.txtstandardCostOfNo1.setHorizontalAlignment(2);		
        this.txtstandardCostOfNo1.setDataType(1);		
        this.txtstandardCostOfNo1.setSupportedEmpty(true);		
        this.txtstandardCostOfNo1.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtstandardCostOfNo1.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtstandardCostOfNo1.setPrecision(2);		
        this.txtstandardCostOfNo1.setRequired(false);
        txtstandardCostOfNo1.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				txtstandardCostOfNo1_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        this.txtstandardCostOfNo1.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtstandardCostOfNo1_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txttotalCostOfNo1		
        this.txttotalCostOfNo1.setVisible(true);		
        this.txttotalCostOfNo1.setHorizontalAlignment(2);		
        this.txttotalCostOfNo1.setDataType(1);		
        this.txttotalCostOfNo1.setSupportedEmpty(true);		
        this.txttotalCostOfNo1.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttotalCostOfNo1.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttotalCostOfNo1.setPrecision(2);		
        this.txttotalCostOfNo1.setRequired(false);		
        this.txttotalCostOfNo1.setEnabled(false);
        // txttotalCost		
        this.txttotalCost.setVisible(true);		
        this.txttotalCost.setHorizontalAlignment(2);		
        this.txttotalCost.setDataType(1);		
        this.txttotalCost.setSupportedEmpty(true);		
        this.txttotalCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttotalCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttotalCost.setPrecision(2);		
        this.txttotalCost.setRequired(false);		
        this.txttotalCost.setEnabled(false);
        // txtstandardCostOfNo2		
        this.txtstandardCostOfNo2.setVisible(true);		
        this.txtstandardCostOfNo2.setHorizontalAlignment(2);		
        this.txtstandardCostOfNo2.setDataType(1);		
        this.txtstandardCostOfNo2.setSupportedEmpty(true);		
        this.txtstandardCostOfNo2.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtstandardCostOfNo2.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtstandardCostOfNo2.setPrecision(2);		
        this.txtstandardCostOfNo2.setRequired(false);
        txtstandardCostOfNo2.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				txtstandardCostOfNo2_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        this.txtstandardCostOfNo2.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtstandardCostOfNo2_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txttotalCostOfNo2		
        this.txttotalCostOfNo2.setVisible(true);		
        this.txttotalCostOfNo2.setHorizontalAlignment(2);		
        this.txttotalCostOfNo2.setDataType(1);		
        this.txttotalCostOfNo2.setSupportedEmpty(true);		
        this.txttotalCostOfNo2.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttotalCostOfNo2.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttotalCostOfNo2.setPrecision(2);		
        this.txttotalCostOfNo2.setRequired(false);		
        this.txttotalCostOfNo2.setEnabled(false);
        // txtstandardCostOfNo3		
        this.txtstandardCostOfNo3.setVisible(true);		
        this.txtstandardCostOfNo3.setHorizontalAlignment(2);		
        this.txtstandardCostOfNo3.setDataType(1);		
        this.txtstandardCostOfNo3.setSupportedEmpty(true);		
        this.txtstandardCostOfNo3.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtstandardCostOfNo3.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtstandardCostOfNo3.setPrecision(2);		
        this.txtstandardCostOfNo3.setRequired(false);
        txtstandardCostOfNo3.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				txtstandardCostOfNo3_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        this.txtstandardCostOfNo3.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtstandardCostOfNo3_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txttotalCostOfNo3		
        this.txttotalCostOfNo3.setVisible(true);		
        this.txttotalCostOfNo3.setHorizontalAlignment(2);		
        this.txttotalCostOfNo3.setDataType(1);		
        this.txttotalCostOfNo3.setSupportedEmpty(true);		
        this.txttotalCostOfNo3.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttotalCostOfNo3.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttotalCostOfNo3.setPrecision(2);		
        this.txttotalCostOfNo3.setRequired(false);		
        this.txttotalCostOfNo3.setEnabled(false);
        // txtstandardCostOfNo4		
        this.txtstandardCostOfNo4.setVisible(true);		
        this.txtstandardCostOfNo4.setHorizontalAlignment(2);		
        this.txtstandardCostOfNo4.setDataType(1);		
        this.txtstandardCostOfNo4.setSupportedEmpty(true);		
        this.txtstandardCostOfNo4.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtstandardCostOfNo4.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtstandardCostOfNo4.setPrecision(2);		
        this.txtstandardCostOfNo4.setRequired(false);
        txtstandardCostOfNo4.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				txtstandardCostOfNo4_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        this.txtstandardCostOfNo4.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtstandardCostOfNo4_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txttotalCostOfNo4		
        this.txttotalCostOfNo4.setVisible(true);		
        this.txttotalCostOfNo4.setHorizontalAlignment(2);		
        this.txttotalCostOfNo4.setDataType(1);		
        this.txttotalCostOfNo4.setSupportedEmpty(true);		
        this.txttotalCostOfNo4.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttotalCostOfNo4.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttotalCostOfNo4.setPrecision(2);		
        this.txttotalCostOfNo4.setRequired(false);		
        this.txttotalCostOfNo4.setEnabled(false);
        // contforageConsumption		
        this.contforageConsumption.setBoundLabelText(resHelper.getString("contforageConsumption.boundLabelText"));		
        this.contforageConsumption.setBoundLabelLength(140);		
        this.contforageConsumption.setBoundLabelUnderline(true);		
        this.contforageConsumption.setVisible(true);
        // contratioOfNo1		
        this.contratioOfNo1.setBoundLabelText(resHelper.getString("contratioOfNo1.boundLabelText"));		
        this.contratioOfNo1.setBoundLabelLength(140);		
        this.contratioOfNo1.setBoundLabelUnderline(true);		
        this.contratioOfNo1.setVisible(true);
        // conttotalQtyOfNo1		
        this.conttotalQtyOfNo1.setBoundLabelText(resHelper.getString("conttotalQtyOfNo1.boundLabelText"));		
        this.conttotalQtyOfNo1.setBoundLabelLength(140);		
        this.conttotalQtyOfNo1.setBoundLabelUnderline(true);		
        this.conttotalQtyOfNo1.setVisible(true);
        // contratioOfNo2		
        this.contratioOfNo2.setBoundLabelText(resHelper.getString("contratioOfNo2.boundLabelText"));		
        this.contratioOfNo2.setBoundLabelLength(140);		
        this.contratioOfNo2.setBoundLabelUnderline(true);		
        this.contratioOfNo2.setVisible(true);
        // contratioOfNo3		
        this.contratioOfNo3.setBoundLabelText(resHelper.getString("contratioOfNo3.boundLabelText"));		
        this.contratioOfNo3.setBoundLabelLength(140);		
        this.contratioOfNo3.setBoundLabelUnderline(true);		
        this.contratioOfNo3.setVisible(true);
        // conttotalQtyOfNo2		
        this.conttotalQtyOfNo2.setBoundLabelText(resHelper.getString("conttotalQtyOfNo2.boundLabelText"));		
        this.conttotalQtyOfNo2.setBoundLabelLength(140);		
        this.conttotalQtyOfNo2.setBoundLabelUnderline(true);		
        this.conttotalQtyOfNo2.setVisible(true);
        // conttotalQtyOfNo3		
        this.conttotalQtyOfNo3.setBoundLabelText(resHelper.getString("conttotalQtyOfNo3.boundLabelText"));		
        this.conttotalQtyOfNo3.setBoundLabelLength(140);		
        this.conttotalQtyOfNo3.setBoundLabelUnderline(true);		
        this.conttotalQtyOfNo3.setVisible(true);
        // contratioOfNo4		
        this.contratioOfNo4.setBoundLabelText(resHelper.getString("contratioOfNo4.boundLabelText"));		
        this.contratioOfNo4.setBoundLabelLength(140);		
        this.contratioOfNo4.setBoundLabelUnderline(true);		
        this.contratioOfNo4.setVisible(true);
        // conttotalQtyOfNo4		
        this.conttotalQtyOfNo4.setBoundLabelText(resHelper.getString("conttotalQtyOfNo4.boundLabelText"));		
        this.conttotalQtyOfNo4.setBoundLabelLength(140);		
        this.conttotalQtyOfNo4.setBoundLabelUnderline(true);		
        this.conttotalQtyOfNo4.setVisible(true);
        // txtforageConsumption		
        this.txtforageConsumption.setVisible(true);		
        this.txtforageConsumption.setHorizontalAlignment(2);		
        this.txtforageConsumption.setDataType(1);		
        this.txtforageConsumption.setSupportedEmpty(true);		
        this.txtforageConsumption.setMinimumValue( new java.math.BigDecimal("-1.0E22"));		
        this.txtforageConsumption.setMaximumValue( new java.math.BigDecimal("1.0E22"));		
        this.txtforageConsumption.setRequired(false);		
        this.txtforageConsumption.setEnabled(false);
        txtforageConsumption.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				txtforageConsumption_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtratioOfNo1		
        this.txtratioOfNo1.setVisible(true);		
        this.txtratioOfNo1.setHorizontalAlignment(2);		
        this.txtratioOfNo1.setDataType(1);		
        this.txtratioOfNo1.setSupportedEmpty(true);		
        this.txtratioOfNo1.setMinimumValue( new java.math.BigDecimal("-1.0E22"));		
        this.txtratioOfNo1.setMaximumValue( new java.math.BigDecimal("1.0E22"));		
        this.txtratioOfNo1.setPrecision(3);		
        this.txtratioOfNo1.setRequired(false);
        this.txtratioOfNo1.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtratioOfNo1_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txttotalQtyOfNo1		
        this.txttotalQtyOfNo1.setVisible(true);		
        this.txttotalQtyOfNo1.setHorizontalAlignment(2);		
        this.txttotalQtyOfNo1.setDataType(1);		
        this.txttotalQtyOfNo1.setSupportedEmpty(true);		
        this.txttotalQtyOfNo1.setMinimumValue( new java.math.BigDecimal("-1.0E22"));		
        this.txttotalQtyOfNo1.setMaximumValue( new java.math.BigDecimal("1.0E22"));		
        this.txttotalQtyOfNo1.setRequired(false);		
        this.txttotalQtyOfNo1.setEnabled(false);		
        this.txttotalQtyOfNo1.setPrecision(3);
        this.txttotalQtyOfNo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    txttotalQtyOfNo1_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // txtratioOfNo2		
        this.txtratioOfNo2.setVisible(true);		
        this.txtratioOfNo2.setHorizontalAlignment(2);		
        this.txtratioOfNo2.setDataType(1);		
        this.txtratioOfNo2.setSupportedEmpty(true);		
        this.txtratioOfNo2.setMinimumValue( new java.math.BigDecimal("-1.0E22"));		
        this.txtratioOfNo2.setMaximumValue( new java.math.BigDecimal("1.0E22"));		
        this.txtratioOfNo2.setPrecision(3);		
        this.txtratioOfNo2.setRequired(false);
        this.txtratioOfNo2.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtratioOfNo2_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtratioOfNo3		
        this.txtratioOfNo3.setVisible(true);		
        this.txtratioOfNo3.setHorizontalAlignment(2);		
        this.txtratioOfNo3.setDataType(1);		
        this.txtratioOfNo3.setSupportedEmpty(true);		
        this.txtratioOfNo3.setMinimumValue( new java.math.BigDecimal("-1.0E22"));		
        this.txtratioOfNo3.setMaximumValue( new java.math.BigDecimal("1.0E22"));		
        this.txtratioOfNo3.setPrecision(3);		
        this.txtratioOfNo3.setRequired(false);
        this.txtratioOfNo3.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtratioOfNo3_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txttotalQtyOfNo2		
        this.txttotalQtyOfNo2.setVisible(true);		
        this.txttotalQtyOfNo2.setHorizontalAlignment(2);		
        this.txttotalQtyOfNo2.setDataType(1);		
        this.txttotalQtyOfNo2.setSupportedEmpty(true);		
        this.txttotalQtyOfNo2.setMinimumValue( new java.math.BigDecimal("-1.0E22"));		
        this.txttotalQtyOfNo2.setMaximumValue( new java.math.BigDecimal("1.0E22"));		
        this.txttotalQtyOfNo2.setPrecision(3);		
        this.txttotalQtyOfNo2.setRequired(false);		
        this.txttotalQtyOfNo2.setEnabled(false);
        // txttotalQtyOfNo3		
        this.txttotalQtyOfNo3.setVisible(true);		
        this.txttotalQtyOfNo3.setHorizontalAlignment(2);		
        this.txttotalQtyOfNo3.setDataType(1);		
        this.txttotalQtyOfNo3.setSupportedEmpty(true);		
        this.txttotalQtyOfNo3.setMinimumValue( new java.math.BigDecimal("-1.0E22"));		
        this.txttotalQtyOfNo3.setMaximumValue( new java.math.BigDecimal("1.0E22"));		
        this.txttotalQtyOfNo3.setPrecision(3);		
        this.txttotalQtyOfNo3.setRequired(false);		
        this.txttotalQtyOfNo3.setEnabled(false);
        // txtratioOfNo4		
        this.txtratioOfNo4.setVisible(true);		
        this.txtratioOfNo4.setHorizontalAlignment(2);		
        this.txtratioOfNo4.setDataType(1);		
        this.txtratioOfNo4.setSupportedEmpty(true);		
        this.txtratioOfNo4.setMinimumValue( new java.math.BigDecimal("-1.0E22"));		
        this.txtratioOfNo4.setMaximumValue( new java.math.BigDecimal("1.0E22"));		
        this.txtratioOfNo4.setPrecision(3);		
        this.txtratioOfNo4.setRequired(false);
        this.txtratioOfNo4.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtratioOfNo4_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txttotalQtyOfNo4		
        this.txttotalQtyOfNo4.setVisible(true);		
        this.txttotalQtyOfNo4.setHorizontalAlignment(2);		
        this.txttotalQtyOfNo4.setDataType(1);		
        this.txttotalQtyOfNo4.setSupportedEmpty(true);		
        this.txttotalQtyOfNo4.setMinimumValue( new java.math.BigDecimal("-1.0E22"));		
        this.txttotalQtyOfNo4.setMaximumValue( new java.math.BigDecimal("1.0E22"));		
        this.txttotalQtyOfNo4.setPrecision(3);		
        this.txttotalQtyOfNo4.setRequired(false);		
        this.txttotalQtyOfNo4.setEnabled(false);
        // contpriceOfWholeChicken		
        this.contpriceOfWholeChicken.setBoundLabelText(resHelper.getString("contpriceOfWholeChicken.boundLabelText"));		
        this.contpriceOfWholeChicken.setBoundLabelLength(100);		
        this.contpriceOfWholeChicken.setBoundLabelUnderline(true);		
        this.contpriceOfWholeChicken.setVisible(true);
        // contrevenueOfChickens		
        this.contrevenueOfChickens.setBoundLabelText(resHelper.getString("contrevenueOfChickens.boundLabelText"));		
        this.contrevenueOfChickens.setBoundLabelLength(100);		
        this.contrevenueOfChickens.setBoundLabelUnderline(true);		
        this.contrevenueOfChickens.setVisible(true);
        // contrevenueOfOthers		
        this.contrevenueOfOthers.setBoundLabelText(resHelper.getString("contrevenueOfOthers.boundLabelText"));		
        this.contrevenueOfOthers.setBoundLabelLength(100);		
        this.contrevenueOfOthers.setBoundLabelUnderline(true);		
        this.contrevenueOfOthers.setVisible(true);
        // contmainCost		
        this.contmainCost.setBoundLabelText(resHelper.getString("contmainCost.boundLabelText"));		
        this.contmainCost.setBoundLabelLength(100);		
        this.contmainCost.setBoundLabelUnderline(true);		
        this.contmainCost.setVisible(true);
        // contcostOfOthers		
        this.contcostOfOthers.setBoundLabelText(resHelper.getString("contcostOfOthers.boundLabelText"));		
        this.contcostOfOthers.setBoundLabelLength(100);		
        this.contcostOfOthers.setBoundLabelUnderline(true);		
        this.contcostOfOthers.setVisible(true);
        // contfeeOfManage		
        this.contfeeOfManage.setBoundLabelText(resHelper.getString("contfeeOfManage.boundLabelText"));		
        this.contfeeOfManage.setBoundLabelLength(100);		
        this.contfeeOfManage.setBoundLabelUnderline(true);		
        this.contfeeOfManage.setVisible(true);
        // contfeeOfFinance		
        this.contfeeOfFinance.setBoundLabelText(resHelper.getString("contfeeOfFinance.boundLabelText"));		
        this.contfeeOfFinance.setBoundLabelLength(100);		
        this.contfeeOfFinance.setBoundLabelUnderline(true);		
        this.contfeeOfFinance.setVisible(true);
        // contpredictedTotalRevenue		
        this.contpredictedTotalRevenue.setBoundLabelText(resHelper.getString("contpredictedTotalRevenue.boundLabelText"));		
        this.contpredictedTotalRevenue.setBoundLabelLength(100);		
        this.contpredictedTotalRevenue.setBoundLabelUnderline(true);		
        this.contpredictedTotalRevenue.setVisible(true);
        // contpredictedTotalCost		
        this.contpredictedTotalCost.setBoundLabelText(resHelper.getString("contpredictedTotalCost.boundLabelText"));		
        this.contpredictedTotalCost.setBoundLabelLength(100);		
        this.contpredictedTotalCost.setBoundLabelUnderline(true);		
        this.contpredictedTotalCost.setVisible(true);
        // contpredictedProfit		
        this.contpredictedProfit.setBoundLabelText(resHelper.getString("contpredictedProfit.boundLabelText"));		
        this.contpredictedProfit.setBoundLabelLength(100);		
        this.contpredictedProfit.setBoundLabelUnderline(true);		
        this.contpredictedProfit.setVisible(true);
        // contpredictTotalFee		
        this.contpredictTotalFee.setBoundLabelText(resHelper.getString("contpredictTotalFee.boundLabelText"));		
        this.contpredictTotalFee.setBoundLabelLength(100);		
        this.contpredictTotalFee.setBoundLabelUnderline(true);		
        this.contpredictTotalFee.setVisible(true);
        // txtpriceOfWholeChicken		
        this.txtpriceOfWholeChicken.setVisible(true);		
        this.txtpriceOfWholeChicken.setHorizontalAlignment(2);		
        this.txtpriceOfWholeChicken.setDataType(1);		
        this.txtpriceOfWholeChicken.setSupportedEmpty(true);		
        this.txtpriceOfWholeChicken.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpriceOfWholeChicken.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpriceOfWholeChicken.setPrecision(3);		
        this.txtpriceOfWholeChicken.setRequired(false);		
        this.txtpriceOfWholeChicken.setEnabled(false);
        // txtrevenueOfChickens		
        this.txtrevenueOfChickens.setVisible(true);		
        this.txtrevenueOfChickens.setHorizontalAlignment(2);		
        this.txtrevenueOfChickens.setDataType(1);		
        this.txtrevenueOfChickens.setSupportedEmpty(true);		
        this.txtrevenueOfChickens.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtrevenueOfChickens.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtrevenueOfChickens.setPrecision(2);		
        this.txtrevenueOfChickens.setRequired(false);		
        this.txtrevenueOfChickens.setEnabled(false);
        // txtrevenueOfOthers		
        this.txtrevenueOfOthers.setVisible(true);		
        this.txtrevenueOfOthers.setHorizontalAlignment(2);		
        this.txtrevenueOfOthers.setDataType(1);		
        this.txtrevenueOfOthers.setSupportedEmpty(true);		
        this.txtrevenueOfOthers.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtrevenueOfOthers.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtrevenueOfOthers.setPrecision(2);		
        this.txtrevenueOfOthers.setRequired(false);
        this.txtrevenueOfOthers.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtrevenueOfOthers_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtmainCost		
        this.txtmainCost.setVisible(true);		
        this.txtmainCost.setHorizontalAlignment(2);		
        this.txtmainCost.setDataType(1);		
        this.txtmainCost.setSupportedEmpty(true);		
        this.txtmainCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmainCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmainCost.setPrecision(2);		
        this.txtmainCost.setRequired(false);		
        this.txtmainCost.setEnabled(false);
        // txtcostOfOthers		
        this.txtcostOfOthers.setVisible(true);		
        this.txtcostOfOthers.setHorizontalAlignment(2);		
        this.txtcostOfOthers.setDataType(1);		
        this.txtcostOfOthers.setSupportedEmpty(true);		
        this.txtcostOfOthers.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcostOfOthers.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcostOfOthers.setPrecision(2);		
        this.txtcostOfOthers.setRequired(false);
        this.txtcostOfOthers.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtcostOfOthers_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtfeeOfManage		
        this.txtfeeOfManage.setVisible(true);		
        this.txtfeeOfManage.setHorizontalAlignment(2);		
        this.txtfeeOfManage.setDataType(1);		
        this.txtfeeOfManage.setSupportedEmpty(true);		
        this.txtfeeOfManage.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfeeOfManage.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfeeOfManage.setPrecision(2);		
        this.txtfeeOfManage.setRequired(false);
        this.txtfeeOfManage.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtfeeOfManage_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtfeeOfFinance		
        this.txtfeeOfFinance.setVisible(true);		
        this.txtfeeOfFinance.setHorizontalAlignment(2);		
        this.txtfeeOfFinance.setDataType(1);		
        this.txtfeeOfFinance.setSupportedEmpty(true);		
        this.txtfeeOfFinance.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfeeOfFinance.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfeeOfFinance.setPrecision(2);		
        this.txtfeeOfFinance.setRequired(false);
        this.txtfeeOfFinance.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtfeeOfFinance_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtpredictedTotalRevenue		
        this.txtpredictedTotalRevenue.setVisible(true);		
        this.txtpredictedTotalRevenue.setHorizontalAlignment(2);		
        this.txtpredictedTotalRevenue.setDataType(1);		
        this.txtpredictedTotalRevenue.setSupportedEmpty(true);		
        this.txtpredictedTotalRevenue.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpredictedTotalRevenue.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpredictedTotalRevenue.setPrecision(2);		
        this.txtpredictedTotalRevenue.setRequired(false);		
        this.txtpredictedTotalRevenue.setEnabled(false);
        // txtpredictedTotalCost		
        this.txtpredictedTotalCost.setVisible(true);		
        this.txtpredictedTotalCost.setHorizontalAlignment(2);		
        this.txtpredictedTotalCost.setDataType(1);		
        this.txtpredictedTotalCost.setSupportedEmpty(true);		
        this.txtpredictedTotalCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpredictedTotalCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpredictedTotalCost.setPrecision(2);		
        this.txtpredictedTotalCost.setRequired(false);		
        this.txtpredictedTotalCost.setEnabled(false);
        // txtpredictedProfit		
        this.txtpredictedProfit.setVisible(true);		
        this.txtpredictedProfit.setHorizontalAlignment(2);		
        this.txtpredictedProfit.setDataType(1);		
        this.txtpredictedProfit.setSupportedEmpty(true);		
        this.txtpredictedProfit.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpredictedProfit.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpredictedProfit.setPrecision(2);		
        this.txtpredictedProfit.setRequired(false);		
        this.txtpredictedProfit.setEnabled(false);
        // txtpredictTotalFee		
        this.txtpredictTotalFee.setVisible(true);		
        this.txtpredictTotalFee.setHorizontalAlignment(2);		
        this.txtpredictTotalFee.setDataType(1);		
        this.txtpredictTotalFee.setSupportedEmpty(true);		
        this.txtpredictTotalFee.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpredictTotalFee.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpredictTotalFee.setPrecision(2);		
        this.txtpredictTotalFee.setRequired(false);		
        this.txtpredictTotalFee.setEnabled(false);
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
        // prmtperiod		
        this.prmtperiod.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7PeriodQuery");		
        this.prmtperiod.setVisible(true);		
        this.prmtperiod.setEditable(true);		
        this.prmtperiod.setDisplayFormat("$number$");		
        this.prmtperiod.setEditFormat("$number$");		
        this.prmtperiod.setCommitFormat("$number$");		
        this.prmtperiod.setRequired(true);
        this.prmtperiod.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtperiod_dataChange(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // billStatus		
        this.billStatus.setVisible(true);		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.bsxbudget.billStatus").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // txtfeedPeriod		
        this.txtfeedPeriod.setVisible(true);		
        this.txtfeedPeriod.setHorizontalAlignment(2);		
        this.txtfeedPeriod.setDataType(0);		
        this.txtfeedPeriod.setSupportedEmpty(true);		
        this.txtfeedPeriod.setRequired(true);
        // txtdescription		
        this.txtdescription.setVisible(true);		
        this.txtdescription.setHorizontalAlignment(2);		
        this.txtdescription.setMaxLength(80);		
        this.txtdescription.setRequired(false);
        // getLairageQty
        this.getLairageQty.setAction((IItemAction)ActionProxyFactory.getProxy(actionGetLairageQty, new Class[] { IItemAction.class }, getServiceContext()));		
        this.getLairageQty.setText(resHelper.getString("getLairageQty.text"));
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {pkauditTime,prmtperiod,txtlairageQty,txtsurvivalRate,txtslaughterQty,txtaverageWeight,txttotalWeight,txtfeedToMeatRatio,txtaveFeedConsumption,txtaverageCost,txtaverageCostOfChicks,txtaverageCostOfmedicine,txtaverageCostOfFeedstuff,txttotalCostOfCC,txttotalCostOfChicks,txttotalCostOfMedicine,txtfeeOfOthers,txtpriceOfWholeChicken,txtrevenueOfChickens,txtrevenueOfOthers,txtmainCost,txtcostOfOthers,txtfeeOfManage,txtfeeOfFinance,txtforageConsumption,txtratioOfNo1,txttotalQtyOfNo1,txtratioOfNo2,txtstandardCostOfAverage,txtstandardCostOfNo1,txtpredictedTotalCost,txtpredictedTotalRevenue,txtpredictedProfit,billStatus,txtfeedPeriod,txtstandardCostOfNo4,txttotalCostOfNo4,txtpredictTotalFee}));
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
        btnPriceOfChicken.setBounds(new Rectangle(823, 91, 130, 21));
        this.add(btnPriceOfChicken, new KDLayout.Constraints(823, 91, 130, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        btnGetLairageQty.setBounds(new Rectangle(683, 91, 130, 21));
        this.add(btnGetLairageQty, new KDLayout.Constraints(683, 91, 130, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane1.setBounds(new Rectangle(4, 121, 995, 429));
        this.add(kDTabbedPane1, new KDLayout.Constraints(4, 121, 995, 429, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contCreator.setBounds(new Rectangle(372, 558, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(372, 558, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(730, 558, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(730, 558, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(372, 589, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(372, 589, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(730, 589, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(730, 589, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(354, 21, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(354, 21, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(26, 23, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(26, 23, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(15, 562, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(15, 562, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(15, 591, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(15, 591, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contperiod.setBounds(new Rectangle(683, 23, 270, 19));
        this.add(contperiod, new KDLayout.Constraints(683, 23, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbillStatus.setBounds(new Rectangle(26, 62, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(26, 62, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfeedPeriod.setBounds(new Rectangle(354, 62, 270, 19));
        this.add(contfeedPeriod, new KDLayout.Constraints(354, 62, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdescription.setBounds(new Rectangle(683, 62, 270, 19));
        this.add(contdescription, new KDLayout.Constraints(683, 62, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanelCommercialChicken, resHelper.getString("kDPanelCommercialChicken.constraints"));
        kDTabbedPane1.add(kDPanelFeed, resHelper.getString("kDPanelFeed.constraints"));
        kDTabbedPane1.add(kDPanelFarmProfit, resHelper.getString("kDPanelFarmProfit.constraints"));
        //kDPanelCommercialChicken
        kDPanelCommercialChicken.setLayout(new KDLayout());
        kDPanelCommercialChicken.putClientProperty("OriginalBounds", new Rectangle(0, 0, 994, 396));        kDPanelCCCost.setBounds(new Rectangle(9, 267, 961, 149));
        kDPanelCommercialChicken.add(kDPanelCCCost, new KDLayout.Constraints(9, 267, 961, 149, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDPanelFeedConsumption.setBounds(new Rectangle(9, 106, 961, 129));
        kDPanelCommercialChicken.add(kDPanelFeedConsumption, new KDLayout.Constraints(9, 106, 961, 129, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kdPanelAnticipatedRevenue.setBounds(new Rectangle(9, 13, 961, 62));
        kDPanelCommercialChicken.add(kdPanelAnticipatedRevenue, new KDLayout.Constraints(9, 13, 961, 62, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator9.setBounds(new Rectangle(-5, 248, 1009, 8));
        kDPanelCommercialChicken.add(kDSeparator9, new KDLayout.Constraints(-5, 248, 1009, 8, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator10.setBounds(new Rectangle(-14, 89, 1009, 6));
        kDPanelCommercialChicken.add(kDSeparator10, new KDLayout.Constraints(-14, 89, 1009, 6, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanelCCCost
        kDPanelCCCost.setLayout(new KDLayout());
        kDPanelCCCost.putClientProperty("OriginalBounds", new Rectangle(9, 267, 961, 149));        contaverageCost.setBounds(new Rectangle(346, 108, 270, 19));
        kDPanelCCCost.add(contaverageCost, new KDLayout.Constraints(346, 108, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contaverageCostOfChicks.setBounds(new Rectangle(26, 31, 270, 19));
        kDPanelCCCost.add(contaverageCostOfChicks, new KDLayout.Constraints(26, 31, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contaverageCostOfmedicine.setBounds(new Rectangle(346, 31, 270, 19));
        kDPanelCCCost.add(contaverageCostOfmedicine, new KDLayout.Constraints(346, 31, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contaverageCostOfFeedstuff.setBounds(new Rectangle(666, 31, 270, 19));
        kDPanelCCCost.add(contaverageCostOfFeedstuff, new KDLayout.Constraints(666, 31, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conttotalCostOfCC.setBounds(new Rectangle(26, 108, 270, 19));
        kDPanelCCCost.add(conttotalCostOfCC, new KDLayout.Constraints(26, 108, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttotalCostOfChicks.setBounds(new Rectangle(26, 69, 270, 19));
        kDPanelCCCost.add(conttotalCostOfChicks, new KDLayout.Constraints(26, 69, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttotalCostOfMedicine.setBounds(new Rectangle(346, 69, 270, 19));
        kDPanelCCCost.add(conttotalCostOfMedicine, new KDLayout.Constraints(346, 69, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfeeOfOthers.setBounds(new Rectangle(666, 69, 270, 19));
        kDPanelCCCost.add(contfeeOfOthers, new KDLayout.Constraints(666, 69, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contaverageCost
        contaverageCost.setBoundEditor(txtaverageCost);
        //contaverageCostOfChicks
        contaverageCostOfChicks.setBoundEditor(txtaverageCostOfChicks);
        //contaverageCostOfmedicine
        contaverageCostOfmedicine.setBoundEditor(txtaverageCostOfmedicine);
        //contaverageCostOfFeedstuff
        contaverageCostOfFeedstuff.setBoundEditor(txtaverageCostOfFeedstuff);
        //conttotalCostOfCC
        conttotalCostOfCC.setBoundEditor(txttotalCostOfCC);
        //conttotalCostOfChicks
        conttotalCostOfChicks.setBoundEditor(txttotalCostOfChicks);
        //conttotalCostOfMedicine
        conttotalCostOfMedicine.setBoundEditor(txttotalCostOfMedicine);
        //contfeeOfOthers
        contfeeOfOthers.setBoundEditor(txtfeeOfOthers);
        //kDPanelFeedConsumption
        kDPanelFeedConsumption.setLayout(new KDLayout());
        kDPanelFeedConsumption.putClientProperty("OriginalBounds", new Rectangle(9, 106, 961, 129));        contaverageWeight.setBounds(new Rectangle(25, 30, 270, 19));
        kDPanelFeedConsumption.add(contaverageWeight, new KDLayout.Constraints(25, 30, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttotalWeight.setBounds(new Rectangle(349, 34, 270, 19));
        kDPanelFeedConsumption.add(conttotalWeight, new KDLayout.Constraints(349, 34, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfeedToMeatRatio.setBounds(new Rectangle(669, 28, 270, 19));
        kDPanelFeedConsumption.add(contfeedToMeatRatio, new KDLayout.Constraints(669, 28, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contaveFeedConsumption.setBounds(new Rectangle(25, 72, 270, 19));
        kDPanelFeedConsumption.add(contaveFeedConsumption, new KDLayout.Constraints(25, 72, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contaverageWeight
        contaverageWeight.setBoundEditor(txtaverageWeight);
        //conttotalWeight
        conttotalWeight.setBoundEditor(txttotalWeight);
        //contfeedToMeatRatio
        contfeedToMeatRatio.setBoundEditor(txtfeedToMeatRatio);
        //contaveFeedConsumption
        contaveFeedConsumption.setBoundEditor(txtaveFeedConsumption);
        //kdPanelAnticipatedRevenue
        kdPanelAnticipatedRevenue.setLayout(new KDLayout());
        kdPanelAnticipatedRevenue.putClientProperty("OriginalBounds", new Rectangle(9, 13, 961, 62));        contlairageQty.setBounds(new Rectangle(21, 23, 270, 19));
        kdPanelAnticipatedRevenue.add(contlairageQty, new KDLayout.Constraints(21, 23, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsurvivalRate.setBounds(new Rectangle(345, 23, 270, 19));
        kdPanelAnticipatedRevenue.add(contsurvivalRate, new KDLayout.Constraints(345, 23, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contslaughterQty.setBounds(new Rectangle(670, 23, 270, 19));
        kdPanelAnticipatedRevenue.add(contslaughterQty, new KDLayout.Constraints(670, 23, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contlairageQty
        contlairageQty.setBoundEditor(txtlairageQty);
        //contsurvivalRate
        contsurvivalRate.setBoundEditor(txtsurvivalRate);
        //contslaughterQty
        contslaughterQty.setBoundEditor(txtslaughterQty);
        //kDPanelFeed
        kDPanelFeed.setLayout(new KDLayout());
        kDPanelFeed.putClientProperty("OriginalBounds", new Rectangle(0, 0, 994, 396));        kDPanel1.setBounds(new Rectangle(11, 212, 961, 198));
        kDPanelFeed.add(kDPanel1, new KDLayout.Constraints(11, 212, 961, 198, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDPanel.setBounds(new Rectangle(11, 13, 961, 188));
        kDPanelFeed.add(kDPanel, new KDLayout.Constraints(11, 13, 961, 188, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(11, 212, 961, 198));        contstandardCostOfAverage.setBounds(new Rectangle(654, 117, 290, 19));
        kDPanel1.add(contstandardCostOfAverage, new KDLayout.Constraints(654, 117, 290, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contstandardCostOfNo1.setBounds(new Rectangle(23, 35, 290, 19));
        kDPanel1.add(contstandardCostOfNo1, new KDLayout.Constraints(23, 35, 290, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttotalCostOfNo1.setBounds(new Rectangle(340, 35, 290, 19));
        kDPanel1.add(conttotalCostOfNo1, new KDLayout.Constraints(340, 35, 290, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttotalCost.setBounds(new Rectangle(653, 158, 290, 19));
        kDPanel1.add(conttotalCost, new KDLayout.Constraints(653, 158, 290, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contstandardCostOfNo2.setBounds(new Rectangle(23, 76, 290, 19));
        kDPanel1.add(contstandardCostOfNo2, new KDLayout.Constraints(23, 76, 290, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttotalCostOfNo2.setBounds(new Rectangle(340, 76, 290, 19));
        kDPanel1.add(conttotalCostOfNo2, new KDLayout.Constraints(340, 76, 290, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contstandardCostOfNo3.setBounds(new Rectangle(23, 117, 290, 19));
        kDPanel1.add(contstandardCostOfNo3, new KDLayout.Constraints(23, 117, 290, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttotalCostOfNo3.setBounds(new Rectangle(340, 117, 290, 19));
        kDPanel1.add(conttotalCostOfNo3, new KDLayout.Constraints(340, 117, 290, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contstandardCostOfNo4.setBounds(new Rectangle(23, 159, 290, 19));
        kDPanel1.add(contstandardCostOfNo4, new KDLayout.Constraints(23, 159, 290, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttotalCostOfNo4.setBounds(new Rectangle(340, 159, 290, 19));
        kDPanel1.add(conttotalCostOfNo4, new KDLayout.Constraints(340, 159, 290, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contstandardCostOfAverage
        contstandardCostOfAverage.setBoundEditor(txtstandardCostOfAverage);
        //contstandardCostOfNo1
        contstandardCostOfNo1.setBoundEditor(txtstandardCostOfNo1);
        //conttotalCostOfNo1
        conttotalCostOfNo1.setBoundEditor(txttotalCostOfNo1);
        //conttotalCost
        conttotalCost.setBoundEditor(txttotalCost);
        //contstandardCostOfNo2
        contstandardCostOfNo2.setBoundEditor(txtstandardCostOfNo2);
        //conttotalCostOfNo2
        conttotalCostOfNo2.setBoundEditor(txttotalCostOfNo2);
        //contstandardCostOfNo3
        contstandardCostOfNo3.setBoundEditor(txtstandardCostOfNo3);
        //conttotalCostOfNo3
        conttotalCostOfNo3.setBoundEditor(txttotalCostOfNo3);
        //contstandardCostOfNo4
        contstandardCostOfNo4.setBoundEditor(txtstandardCostOfNo4);
        //conttotalCostOfNo4
        conttotalCostOfNo4.setBoundEditor(txttotalCostOfNo4);
        //kDPanel
        kDPanel.setLayout(new KDLayout());
        kDPanel.putClientProperty("OriginalBounds", new Rectangle(11, 13, 961, 188));        contforageConsumption.setBounds(new Rectangle(657, 141, 290, 19));
        kDPanel.add(contforageConsumption, new KDLayout.Constraints(657, 141, 290, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contratioOfNo1.setBounds(new Rectangle(17, 26, 290, 19));
        kDPanel.add(contratioOfNo1, new KDLayout.Constraints(17, 26, 290, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttotalQtyOfNo1.setBounds(new Rectangle(344, 26, 290, 19));
        kDPanel.add(conttotalQtyOfNo1, new KDLayout.Constraints(344, 26, 290, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contratioOfNo2.setBounds(new Rectangle(17, 68, 290, 19));
        kDPanel.add(contratioOfNo2, new KDLayout.Constraints(17, 68, 290, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contratioOfNo3.setBounds(new Rectangle(17, 103, 290, 19));
        kDPanel.add(contratioOfNo3, new KDLayout.Constraints(17, 103, 290, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttotalQtyOfNo2.setBounds(new Rectangle(344, 64, 290, 19));
        kDPanel.add(conttotalQtyOfNo2, new KDLayout.Constraints(344, 64, 290, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttotalQtyOfNo3.setBounds(new Rectangle(344, 102, 290, 19));
        kDPanel.add(conttotalQtyOfNo3, new KDLayout.Constraints(344, 102, 290, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contratioOfNo4.setBounds(new Rectangle(17, 141, 290, 19));
        kDPanel.add(contratioOfNo4, new KDLayout.Constraints(17, 141, 290, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttotalQtyOfNo4.setBounds(new Rectangle(344, 141, 290, 19));
        kDPanel.add(conttotalQtyOfNo4, new KDLayout.Constraints(344, 141, 290, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contforageConsumption
        contforageConsumption.setBoundEditor(txtforageConsumption);
        //contratioOfNo1
        contratioOfNo1.setBoundEditor(txtratioOfNo1);
        //conttotalQtyOfNo1
        conttotalQtyOfNo1.setBoundEditor(txttotalQtyOfNo1);
        //contratioOfNo2
        contratioOfNo2.setBoundEditor(txtratioOfNo2);
        //contratioOfNo3
        contratioOfNo3.setBoundEditor(txtratioOfNo3);
        //conttotalQtyOfNo2
        conttotalQtyOfNo2.setBoundEditor(txttotalQtyOfNo2);
        //conttotalQtyOfNo3
        conttotalQtyOfNo3.setBoundEditor(txttotalQtyOfNo3);
        //contratioOfNo4
        contratioOfNo4.setBoundEditor(txtratioOfNo4);
        //conttotalQtyOfNo4
        conttotalQtyOfNo4.setBoundEditor(txttotalQtyOfNo4);
        //kDPanelFarmProfit
        kDPanelFarmProfit.setLayout(new KDLayout());
        kDPanelFarmProfit.putClientProperty("OriginalBounds", new Rectangle(0, 0, 994, 396));        contpriceOfWholeChicken.setBounds(new Rectangle(21, 26, 270, 19));
        kDPanelFarmProfit.add(contpriceOfWholeChicken, new KDLayout.Constraints(21, 26, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contrevenueOfChickens.setBounds(new Rectangle(21, 87, 270, 19));
        kDPanelFarmProfit.add(contrevenueOfChickens, new KDLayout.Constraints(21, 87, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contrevenueOfOthers.setBounds(new Rectangle(357, 87, 270, 19));
        kDPanelFarmProfit.add(contrevenueOfOthers, new KDLayout.Constraints(357, 87, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmainCost.setBounds(new Rectangle(21, 148, 270, 19));
        kDPanelFarmProfit.add(contmainCost, new KDLayout.Constraints(21, 148, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcostOfOthers.setBounds(new Rectangle(357, 148, 270, 19));
        kDPanelFarmProfit.add(contcostOfOthers, new KDLayout.Constraints(357, 148, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfeeOfManage.setBounds(new Rectangle(21, 209, 270, 19));
        kDPanelFarmProfit.add(contfeeOfManage, new KDLayout.Constraints(21, 209, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfeeOfFinance.setBounds(new Rectangle(357, 209, 270, 19));
        kDPanelFarmProfit.add(contfeeOfFinance, new KDLayout.Constraints(357, 209, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpredictedTotalRevenue.setBounds(new Rectangle(682, 87, 270, 19));
        kDPanelFarmProfit.add(contpredictedTotalRevenue, new KDLayout.Constraints(682, 87, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contpredictedTotalCost.setBounds(new Rectangle(680, 148, 270, 19));
        kDPanelFarmProfit.add(contpredictedTotalCost, new KDLayout.Constraints(680, 148, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contpredictedProfit.setBounds(new Rectangle(21, 273, 270, 19));
        kDPanelFarmProfit.add(contpredictedProfit, new KDLayout.Constraints(21, 273, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpredictTotalFee.setBounds(new Rectangle(680, 209, 270, 19));
        kDPanelFarmProfit.add(contpredictTotalFee, new KDLayout.Constraints(680, 209, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contpriceOfWholeChicken
        contpriceOfWholeChicken.setBoundEditor(txtpriceOfWholeChicken);
        //contrevenueOfChickens
        contrevenueOfChickens.setBoundEditor(txtrevenueOfChickens);
        //contrevenueOfOthers
        contrevenueOfOthers.setBoundEditor(txtrevenueOfOthers);
        //contmainCost
        contmainCost.setBoundEditor(txtmainCost);
        //contcostOfOthers
        contcostOfOthers.setBoundEditor(txtcostOfOthers);
        //contfeeOfManage
        contfeeOfManage.setBoundEditor(txtfeeOfManage);
        //contfeeOfFinance
        contfeeOfFinance.setBoundEditor(txtfeeOfFinance);
        //contpredictedTotalRevenue
        contpredictedTotalRevenue.setBoundEditor(txtpredictedTotalRevenue);
        //contpredictedTotalCost
        contpredictedTotalCost.setBoundEditor(txtpredictedTotalCost);
        //contpredictedProfit
        contpredictedProfit.setBoundEditor(txtpredictedProfit);
        //contpredictTotalFee
        contpredictTotalFee.setBoundEditor(txtpredictTotalFee);
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
        //contperiod
        contperiod.setBoundEditor(prmtperiod);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //contfeedPeriod
        contfeedPeriod.setBoundEditor(txtfeedPeriod);
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
        this.toolBar.add(getLairageQty);
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("averageCost", java.math.BigDecimal.class, this.txtaverageCost, "value");
		dataBinder.registerBinding("averageCostOfChicks", java.math.BigDecimal.class, this.txtaverageCostOfChicks, "value");
		dataBinder.registerBinding("averageCostOfmedicine", java.math.BigDecimal.class, this.txtaverageCostOfmedicine, "value");
		dataBinder.registerBinding("averageCostOfFeedstuff", java.math.BigDecimal.class, this.txtaverageCostOfFeedstuff, "value");
		dataBinder.registerBinding("totalCostOfCC", java.math.BigDecimal.class, this.txttotalCostOfCC, "value");
		dataBinder.registerBinding("totalCostOfChicks", java.math.BigDecimal.class, this.txttotalCostOfChicks, "value");
		dataBinder.registerBinding("totalCostOfMedicine", java.math.BigDecimal.class, this.txttotalCostOfMedicine, "value");
		dataBinder.registerBinding("feeOfOthers", java.math.BigDecimal.class, this.txtfeeOfOthers, "value");
		dataBinder.registerBinding("averageWeight", java.math.BigDecimal.class, this.txtaverageWeight, "value");
		dataBinder.registerBinding("totalWeight", java.math.BigDecimal.class, this.txttotalWeight, "value");
		dataBinder.registerBinding("feedToMeatRatio", java.math.BigDecimal.class, this.txtfeedToMeatRatio, "value");
		dataBinder.registerBinding("aveFeedConsumption", java.math.BigDecimal.class, this.txtaveFeedConsumption, "value");
		dataBinder.registerBinding("lairageQty", java.math.BigDecimal.class, this.txtlairageQty, "value");
		dataBinder.registerBinding("survivalRate", java.math.BigDecimal.class, this.txtsurvivalRate, "value");
		dataBinder.registerBinding("slaughterQty", java.math.BigDecimal.class, this.txtslaughterQty, "value");
		dataBinder.registerBinding("standardCostOfAverage", java.math.BigDecimal.class, this.txtstandardCostOfAverage, "value");
		dataBinder.registerBinding("standardCostOfNo1", java.math.BigDecimal.class, this.txtstandardCostOfNo1, "value");
		dataBinder.registerBinding("totalCostOfNo1", java.math.BigDecimal.class, this.txttotalCostOfNo1, "value");
		dataBinder.registerBinding("totalCost", java.math.BigDecimal.class, this.txttotalCost, "value");
		dataBinder.registerBinding("standardCostOfNo2", java.math.BigDecimal.class, this.txtstandardCostOfNo2, "value");
		dataBinder.registerBinding("totalCostOfNo2", java.math.BigDecimal.class, this.txttotalCostOfNo2, "value");
		dataBinder.registerBinding("standardCostOfNo3", java.math.BigDecimal.class, this.txtstandardCostOfNo3, "value");
		dataBinder.registerBinding("totalCostOfNo3", java.math.BigDecimal.class, this.txttotalCostOfNo3, "value");
		dataBinder.registerBinding("standardCostOfNo4", java.math.BigDecimal.class, this.txtstandardCostOfNo4, "value");
		dataBinder.registerBinding("totalCostOfNo4", java.math.BigDecimal.class, this.txttotalCostOfNo4, "value");
		dataBinder.registerBinding("forageConsumption", java.math.BigDecimal.class, this.txtforageConsumption, "value");
		dataBinder.registerBinding("ratioOfNo1", java.math.BigDecimal.class, this.txtratioOfNo1, "value");
		dataBinder.registerBinding("totalQtyOfNo1", java.math.BigDecimal.class, this.txttotalQtyOfNo1, "value");
		dataBinder.registerBinding("ratioOfNo2", java.math.BigDecimal.class, this.txtratioOfNo2, "value");
		dataBinder.registerBinding("ratioOfNo3", java.math.BigDecimal.class, this.txtratioOfNo3, "value");
		dataBinder.registerBinding("totalQtyOfNo2", java.math.BigDecimal.class, this.txttotalQtyOfNo2, "value");
		dataBinder.registerBinding("totalQtyOfNo3", java.math.BigDecimal.class, this.txttotalQtyOfNo3, "value");
		dataBinder.registerBinding("ratioOfNo4", java.math.BigDecimal.class, this.txtratioOfNo4, "value");
		dataBinder.registerBinding("totalQtyOfNo4", java.math.BigDecimal.class, this.txttotalQtyOfNo4, "value");
		dataBinder.registerBinding("priceOfWholeChicken", java.math.BigDecimal.class, this.txtpriceOfWholeChicken, "value");
		dataBinder.registerBinding("revenueOfChickens", java.math.BigDecimal.class, this.txtrevenueOfChickens, "value");
		dataBinder.registerBinding("revenueOfOthers", java.math.BigDecimal.class, this.txtrevenueOfOthers, "value");
		dataBinder.registerBinding("mainCost", java.math.BigDecimal.class, this.txtmainCost, "value");
		dataBinder.registerBinding("costOfOthers", java.math.BigDecimal.class, this.txtcostOfOthers, "value");
		dataBinder.registerBinding("feeOfManage", java.math.BigDecimal.class, this.txtfeeOfManage, "value");
		dataBinder.registerBinding("feeOfFinance", java.math.BigDecimal.class, this.txtfeeOfFinance, "value");
		dataBinder.registerBinding("predictedTotalRevenue", java.math.BigDecimal.class, this.txtpredictedTotalRevenue, "value");
		dataBinder.registerBinding("predictedTotalCost", java.math.BigDecimal.class, this.txtpredictedTotalCost, "value");
		dataBinder.registerBinding("predictedProfit", java.math.BigDecimal.class, this.txtpredictedProfit, "value");
		dataBinder.registerBinding("predictTotalFee", java.math.BigDecimal.class, this.txtpredictTotalFee, "value");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("period", com.kingdee.eas.basedata.assistant.PeriodInfo.class, this.prmtperiod, "data");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.custom.bsxbudget.billStatus.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("feedPeriod", int.class, this.txtfeedPeriod, "value");
		dataBinder.registerBinding("description", String.class, this.txtdescription, "text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.bsxbudget.app.BSXBudgetOfFeedEditUIHandler";
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
        this.editData = (com.kingdee.eas.custom.bsxbudget.BSXBudgetOfFeedInfo)ov;
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
		getValidateHelper().registerBindProperty("averageCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("averageCostOfChicks", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("averageCostOfmedicine", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("averageCostOfFeedstuff", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalCostOfCC", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalCostOfChicks", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalCostOfMedicine", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("feeOfOthers", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("averageWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("feedToMeatRatio", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("aveFeedConsumption", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lairageQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("survivalRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("slaughterQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("standardCostOfAverage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("standardCostOfNo1", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalCostOfNo1", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("standardCostOfNo2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalCostOfNo2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("standardCostOfNo3", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalCostOfNo3", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("standardCostOfNo4", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalCostOfNo4", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("forageConsumption", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ratioOfNo1", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalQtyOfNo1", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ratioOfNo2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ratioOfNo3", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalQtyOfNo2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalQtyOfNo3", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ratioOfNo4", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalQtyOfNo4", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("priceOfWholeChicken", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("revenueOfChickens", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("revenueOfOthers", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mainCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("costOfOthers", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("feeOfManage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("feeOfFinance", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("predictedTotalRevenue", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("predictedTotalCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("predictedProfit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("predictTotalFee", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("period", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("feedPeriod", ValidateHelper.ON_SAVE);    
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
     * output btnPriceOfChicken_mouseClick method
     */
    protected void btnPriceOfChicken_mouseClick(java.awt.event.MouseEvent e) throws Exception
    {
    }

    /**
     * output btnGetLairageQty_mouseClick method
     */
    protected void btnGetLairageQty_mouseClick(java.awt.event.MouseEvent e) throws Exception
    {
    }

    /**
     * output txtaverageCostOfChicks_dataChange method
     */
    protected void txtaverageCostOfChicks_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output txtaverageCostOfmedicine_dataChange method
     */
    protected void txtaverageCostOfmedicine_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output txtfeeOfOthers_dataChange method
     */
    protected void txtfeeOfOthers_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output txtaverageWeight_dataChange method
     */
    protected void txtaverageWeight_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output txtfeedToMeatRatio_dataChange method
     */
    protected void txtfeedToMeatRatio_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output txtlairageQty_dataChang method
     */
    protected void txtlairageQty_dataChang(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output txtsurvivalRate_dataChange method
     */
    protected void txtsurvivalRate_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output txtstandardCostOfNo1_dataChange method
     */
    protected void txtstandardCostOfNo1_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output txtstandardCostOfNo2_dataChange method
     */
    protected void txtstandardCostOfNo2_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output txtstandardCostOfNo3_dataChange method
     */
    protected void txtstandardCostOfNo3_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output txtstandardCostOfNo4_dataChange method
     */
    protected void txtstandardCostOfNo4_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output txtratioOfNo1_dataChange method
     */
    protected void txtratioOfNo1_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output txttotalQtyOfNo1_actionPerformed method
     */
    protected void txttotalQtyOfNo1_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output txtratioOfNo2_dataChange method
     */
    protected void txtratioOfNo2_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output txtratioOfNo3_dataChange method
     */
    protected void txtratioOfNo3_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output txtratioOfNo4_dataChange method
     */
    protected void txtratioOfNo4_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output txtrevenueOfOthers_dataChange method
     */
    protected void txtrevenueOfOthers_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output txtcostOfOthers_dataChange method
     */
    protected void txtcostOfOthers_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output txtfeeOfManage_dataChange method
     */
    protected void txtfeeOfManage_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output txtfeeOfFinance_dataChange method
     */
    protected void txtfeeOfFinance_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output prmtperiod_dataChange method
     */
    protected void prmtperiod_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }


    /**
     * output txtstandardCostOfNo1_Changed() method
     */
    public void txtstandardCostOfNo1_Changed() throws Exception
    {
        System.out.println("txtstandardCostOfNo1_Changed() Function is executed!");
            if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txttotalQtyOfNo1.getValue())|| com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtstandardCostOfNo1.getValue())) 
{
}
else
{
    txttotalCostOfNo1.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtstandardCostOfNo1.getValue())* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txttotalQtyOfNo1.getValue())));
}


    }

    /**
     * output txtstandardCostOfNo2_Changed() method
     */
    public void txtstandardCostOfNo2_Changed() throws Exception
    {
        System.out.println("txtstandardCostOfNo2_Changed() Function is executed!");
            if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txttotalQtyOfNo2.getValue())|| com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtstandardCostOfNo2.getValue())) 
{
}
else
{
    txttotalCostOfNo2.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtstandardCostOfNo2.getValue())* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txttotalQtyOfNo2.getValue())));
}


    }

    /**
     * output txtstandardCostOfNo3_Changed() method
     */
    public void txtstandardCostOfNo3_Changed() throws Exception
    {
        System.out.println("txtstandardCostOfNo3_Changed() Function is executed!");
            if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txttotalQtyOfNo3.getValue())|| com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtstandardCostOfNo3.getValue())) 
{
}
else
{
    txttotalCostOfNo3.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtstandardCostOfNo3.getValue())* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txttotalQtyOfNo3.getValue())));
}


    }

    /**
     * output txtstandardCostOfNo4_Changed() method
     */
    public void txtstandardCostOfNo4_Changed() throws Exception
    {
        System.out.println("txtstandardCostOfNo4_Changed() Function is executed!");
            if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtstandardCostOfNo4.getValue())|| com.kingdee.bos.ui.face.UIRuleUtil.isNull(txttotalQtyOfNo4.getValue())) 
{
}
else
{
    txttotalCostOfNo4.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtstandardCostOfNo4.getValue())* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txttotalQtyOfNo4.getValue())));
}


    }

    /**
     * output txtforageConsumption_Changed() method
     */
    public void txtforageConsumption_Changed() throws Exception
    {
        System.out.println("txtforageConsumption_Changed() Function is executed!");
            if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtslaughterQty.getValue())|| com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtaveFeedConsumption.getValue())) 
{
}
else
{
    txtforageConsumption.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtaveFeedConsumption.getValue())* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtslaughterQty.getValue())));
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
        sic.add(new SelectorItemInfo("averageCost"));
        sic.add(new SelectorItemInfo("averageCostOfChicks"));
        sic.add(new SelectorItemInfo("averageCostOfmedicine"));
        sic.add(new SelectorItemInfo("averageCostOfFeedstuff"));
        sic.add(new SelectorItemInfo("totalCostOfCC"));
        sic.add(new SelectorItemInfo("totalCostOfChicks"));
        sic.add(new SelectorItemInfo("totalCostOfMedicine"));
        sic.add(new SelectorItemInfo("feeOfOthers"));
        sic.add(new SelectorItemInfo("averageWeight"));
        sic.add(new SelectorItemInfo("totalWeight"));
        sic.add(new SelectorItemInfo("feedToMeatRatio"));
        sic.add(new SelectorItemInfo("aveFeedConsumption"));
        sic.add(new SelectorItemInfo("lairageQty"));
        sic.add(new SelectorItemInfo("survivalRate"));
        sic.add(new SelectorItemInfo("slaughterQty"));
        sic.add(new SelectorItemInfo("standardCostOfAverage"));
        sic.add(new SelectorItemInfo("standardCostOfNo1"));
        sic.add(new SelectorItemInfo("totalCostOfNo1"));
        sic.add(new SelectorItemInfo("totalCost"));
        sic.add(new SelectorItemInfo("standardCostOfNo2"));
        sic.add(new SelectorItemInfo("totalCostOfNo2"));
        sic.add(new SelectorItemInfo("standardCostOfNo3"));
        sic.add(new SelectorItemInfo("totalCostOfNo3"));
        sic.add(new SelectorItemInfo("standardCostOfNo4"));
        sic.add(new SelectorItemInfo("totalCostOfNo4"));
        sic.add(new SelectorItemInfo("forageConsumption"));
        sic.add(new SelectorItemInfo("ratioOfNo1"));
        sic.add(new SelectorItemInfo("totalQtyOfNo1"));
        sic.add(new SelectorItemInfo("ratioOfNo2"));
        sic.add(new SelectorItemInfo("ratioOfNo3"));
        sic.add(new SelectorItemInfo("totalQtyOfNo2"));
        sic.add(new SelectorItemInfo("totalQtyOfNo3"));
        sic.add(new SelectorItemInfo("ratioOfNo4"));
        sic.add(new SelectorItemInfo("totalQtyOfNo4"));
        sic.add(new SelectorItemInfo("priceOfWholeChicken"));
        sic.add(new SelectorItemInfo("revenueOfChickens"));
        sic.add(new SelectorItemInfo("revenueOfOthers"));
        sic.add(new SelectorItemInfo("mainCost"));
        sic.add(new SelectorItemInfo("costOfOthers"));
        sic.add(new SelectorItemInfo("feeOfManage"));
        sic.add(new SelectorItemInfo("feeOfFinance"));
        sic.add(new SelectorItemInfo("predictedTotalRevenue"));
        sic.add(new SelectorItemInfo("predictedTotalCost"));
        sic.add(new SelectorItemInfo("predictedProfit"));
        sic.add(new SelectorItemInfo("predictTotalFee"));
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("period.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("period.id"));
        	sic.add(new SelectorItemInfo("period.number"));
		}
        sic.add(new SelectorItemInfo("billStatus"));
        sic.add(new SelectorItemInfo("feedPeriod"));
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
     * output actionGetLairageQty_actionPerformed method
     */
    public void actionGetLairageQty_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.bsxbudget.BSXBudgetOfFeedFactory.getRemoteInstance().getLairageQty(editData);
    }
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.bsxbudget.BSXBudgetOfFeedFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.bsxbudget.BSXBudgetOfFeedFactory.getRemoteInstance().unAudit(editData);
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
	public RequestContext prepareActionGetLairageQty(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionGetLairageQty() {
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
     * output ActionGetLairageQty class
     */     
    protected class ActionGetLairageQty extends ItemAction {     
    
        public ActionGetLairageQty()
        {
            this(null);
        }

        public ActionGetLairageQty(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionGetLairageQty.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionGetLairageQty.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionGetLairageQty.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractBSXBudgetOfFeedEditUI.this, "ActionGetLairageQty", "actionGetLairageQty_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractBSXBudgetOfFeedEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractBSXBudgetOfFeedEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.bsxbudget.client", "BSXBudgetOfFeedEditUI");
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
        return com.kingdee.eas.custom.bsxbudget.client.BSXBudgetOfFeedEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.bsxbudget.BSXBudgetOfFeedFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.bsxbudget.BSXBudgetOfFeedInfo objectValue = new com.kingdee.eas.custom.bsxbudget.BSXBudgetOfFeedInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/bsxbudget/BSXBudgetOfFeed";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.bsxbudget.app.BSXBudgetOfFeedQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtaverageWeight.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"鸡只均重"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtfeedToMeatRatio.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"料肉比"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtsurvivalRate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"成活率"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtNumber.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"单据编号"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtperiod.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"期间"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtfeedPeriod.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"饲喂周期"});
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