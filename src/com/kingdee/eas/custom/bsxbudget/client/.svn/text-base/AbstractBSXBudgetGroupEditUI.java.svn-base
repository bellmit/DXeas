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
public abstract class AbstractBSXBudgetGroupEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractBSXBudgetGroupEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDPanel kdPanelRevenue;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator9;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator10;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator11;
    protected com.kingdee.bos.ctrl.swing.KDPanel kdPanelCost;
    protected com.kingdee.bos.ctrl.swing.KDPanel kdPanelFee;
    protected com.kingdee.bos.ctrl.swing.KDPanel kdPanelProfit;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator13;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperiod;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDButton btnGetCostAndRevenue;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contRevenueFood;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrevenueFeed;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrevenueGroup;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtRevenueFood;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtrevenueFeed;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtrevenueGroup;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcostFood;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcostFeed;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcostGroup;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcostFood;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcostFeed;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcostGroup;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmanageFee;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contFIFee;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgroupFee;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmanageFee;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtFIFee;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgroupFee;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contprofit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtprofit;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperiod;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdescription;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.custom.bsxbudget.BSXBudgetGroupInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractBSXBudgetGroupEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractBSXBudgetGroupEditUI.class.getName());
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
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdPanelRevenue = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDSeparator9 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDSeparator10 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDSeparator11 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kdPanelCost = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdPanelFee = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdPanelProfit = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDSeparator13 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contperiod = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnGetCostAndRevenue = new com.kingdee.bos.ctrl.swing.KDButton();
        this.contdescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.contRevenueFood = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrevenueFeed = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrevenueGroup = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtRevenueFood = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtrevenueFeed = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtrevenueGroup = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contcostFood = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcostFeed = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcostGroup = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtcostFood = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcostFeed = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcostGroup = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contmanageFee = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contFIFee = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgroupFee = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtmanageFee = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtFIFee = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtgroupFee = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contprofit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtprofit = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
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
        this.kdPanelRevenue.setName("kdPanelRevenue");
        this.kDSeparator8.setName("kDSeparator8");
        this.kDSeparator9.setName("kDSeparator9");
        this.kDSeparator10.setName("kDSeparator10");
        this.kDSeparator11.setName("kDSeparator11");
        this.kdPanelCost.setName("kdPanelCost");
        this.kdPanelFee.setName("kdPanelFee");
        this.kdPanelProfit.setName("kdPanelProfit");
        this.kDSeparator13.setName("kDSeparator13");
        this.contperiod.setName("contperiod");
        this.contbillStatus.setName("contbillStatus");
        this.btnGetCostAndRevenue.setName("btnGetCostAndRevenue");
        this.contdescription.setName("contdescription");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.prmtAuditor.setName("prmtAuditor");
        this.pkauditTime.setName("pkauditTime");
        this.contRevenueFood.setName("contRevenueFood");
        this.contrevenueFeed.setName("contrevenueFeed");
        this.contrevenueGroup.setName("contrevenueGroup");
        this.txtRevenueFood.setName("txtRevenueFood");
        this.txtrevenueFeed.setName("txtrevenueFeed");
        this.txtrevenueGroup.setName("txtrevenueGroup");
        this.contcostFood.setName("contcostFood");
        this.contcostFeed.setName("contcostFeed");
        this.contcostGroup.setName("contcostGroup");
        this.txtcostFood.setName("txtcostFood");
        this.txtcostFeed.setName("txtcostFeed");
        this.txtcostGroup.setName("txtcostGroup");
        this.contmanageFee.setName("contmanageFee");
        this.contFIFee.setName("contFIFee");
        this.contgroupFee.setName("contgroupFee");
        this.txtmanageFee.setName("txtmanageFee");
        this.txtFIFee.setName("txtFIFee");
        this.txtgroupFee.setName("txtgroupFee");
        this.contprofit.setName("contprofit");
        this.txtprofit.setName("txtprofit");
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
        // kdPanelRevenue		
        this.kdPanelRevenue.setBorder(new TitledBorder(BorderFactory.createLineBorder(new Color(0,0,0),1), resHelper.getString("kdPanelRevenue.border.title")));
        // kDSeparator8
        // kDSeparator9
        // kDSeparator10
        // kDSeparator11
        // kdPanelCost		
        this.kdPanelCost.setBorder(new TitledBorder(BorderFactory.createLineBorder(new Color(0,0,0),1), resHelper.getString("kdPanelCost.border.title")));
        // kdPanelFee		
        this.kdPanelFee.setBorder(new TitledBorder(BorderFactory.createLineBorder(new Color(0,0,0),1), resHelper.getString("kdPanelFee.border.title")));
        // kdPanelProfit		
        this.kdPanelProfit.setBorder(new TitledBorder(BorderFactory.createLineBorder(new Color(0,0,0),1), resHelper.getString("kdPanelProfit.border.title")));
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
        // btnGetCostAndRevenue		
        this.btnGetCostAndRevenue.setText(resHelper.getString("btnGetCostAndRevenue.text"));
        this.btnGetCostAndRevenue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                try {
                    btnGetCostAndRevenue_mouseClick(e);
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
        // contRevenueFood		
        this.contRevenueFood.setBoundLabelText(resHelper.getString("contRevenueFood.boundLabelText"));		
        this.contRevenueFood.setBoundLabelLength(100);		
        this.contRevenueFood.setBoundLabelUnderline(true);		
        this.contRevenueFood.setVisible(true);
        // contrevenueFeed		
        this.contrevenueFeed.setBoundLabelText(resHelper.getString("contrevenueFeed.boundLabelText"));		
        this.contrevenueFeed.setBoundLabelLength(100);		
        this.contrevenueFeed.setBoundLabelUnderline(true);		
        this.contrevenueFeed.setVisible(true);
        // contrevenueGroup		
        this.contrevenueGroup.setBoundLabelText(resHelper.getString("contrevenueGroup.boundLabelText"));		
        this.contrevenueGroup.setBoundLabelLength(100);		
        this.contrevenueGroup.setBoundLabelUnderline(true);		
        this.contrevenueGroup.setVisible(true);
        // txtRevenueFood		
        this.txtRevenueFood.setVisible(true);		
        this.txtRevenueFood.setHorizontalAlignment(2);		
        this.txtRevenueFood.setDataType(1);		
        this.txtRevenueFood.setSupportedEmpty(true);		
        this.txtRevenueFood.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtRevenueFood.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtRevenueFood.setPrecision(2);		
        this.txtRevenueFood.setRequired(true);		
        this.txtRevenueFood.setEnabled(false);
        // txtrevenueFeed		
        this.txtrevenueFeed.setVisible(true);		
        this.txtrevenueFeed.setHorizontalAlignment(2);		
        this.txtrevenueFeed.setDataType(1);		
        this.txtrevenueFeed.setSupportedEmpty(true);		
        this.txtrevenueFeed.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtrevenueFeed.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtrevenueFeed.setPrecision(2);		
        this.txtrevenueFeed.setRequired(true);		
        this.txtrevenueFeed.setEnabled(false);
        // txtrevenueGroup		
        this.txtrevenueGroup.setVisible(true);		
        this.txtrevenueGroup.setHorizontalAlignment(2);		
        this.txtrevenueGroup.setDataType(1);		
        this.txtrevenueGroup.setSupportedEmpty(true);		
        this.txtrevenueGroup.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtrevenueGroup.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtrevenueGroup.setPrecision(2);		
        this.txtrevenueGroup.setRequired(true);		
        this.txtrevenueGroup.setEnabled(false);
        // contcostFood		
        this.contcostFood.setBoundLabelText(resHelper.getString("contcostFood.boundLabelText"));		
        this.contcostFood.setBoundLabelLength(100);		
        this.contcostFood.setBoundLabelUnderline(true);		
        this.contcostFood.setVisible(true);
        // contcostFeed		
        this.contcostFeed.setBoundLabelText(resHelper.getString("contcostFeed.boundLabelText"));		
        this.contcostFeed.setBoundLabelLength(100);		
        this.contcostFeed.setBoundLabelUnderline(true);		
        this.contcostFeed.setVisible(true);
        // contcostGroup		
        this.contcostGroup.setBoundLabelText(resHelper.getString("contcostGroup.boundLabelText"));		
        this.contcostGroup.setBoundLabelLength(100);		
        this.contcostGroup.setBoundLabelUnderline(true);		
        this.contcostGroup.setVisible(true);
        // txtcostFood		
        this.txtcostFood.setVisible(true);		
        this.txtcostFood.setHorizontalAlignment(2);		
        this.txtcostFood.setDataType(1);		
        this.txtcostFood.setSupportedEmpty(true);		
        this.txtcostFood.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcostFood.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcostFood.setPrecision(2);		
        this.txtcostFood.setRequired(true);		
        this.txtcostFood.setEnabled(false);
        // txtcostFeed		
        this.txtcostFeed.setVisible(true);		
        this.txtcostFeed.setHorizontalAlignment(2);		
        this.txtcostFeed.setDataType(1);		
        this.txtcostFeed.setSupportedEmpty(true);		
        this.txtcostFeed.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcostFeed.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcostFeed.setPrecision(2);		
        this.txtcostFeed.setRequired(true);		
        this.txtcostFeed.setEnabled(false);
        // txtcostGroup		
        this.txtcostGroup.setVisible(true);		
        this.txtcostGroup.setHorizontalAlignment(2);		
        this.txtcostGroup.setDataType(1);		
        this.txtcostGroup.setSupportedEmpty(true);		
        this.txtcostGroup.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcostGroup.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcostGroup.setPrecision(2);		
        this.txtcostGroup.setRequired(true);		
        this.txtcostGroup.setEnabled(false);
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
        // contgroupFee		
        this.contgroupFee.setBoundLabelText(resHelper.getString("contgroupFee.boundLabelText"));		
        this.contgroupFee.setBoundLabelLength(100);		
        this.contgroupFee.setBoundLabelUnderline(true);		
        this.contgroupFee.setVisible(true);
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
        // txtgroupFee		
        this.txtgroupFee.setVisible(true);		
        this.txtgroupFee.setHorizontalAlignment(2);		
        this.txtgroupFee.setDataType(1);		
        this.txtgroupFee.setSupportedEmpty(true);		
        this.txtgroupFee.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtgroupFee.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtgroupFee.setPrecision(2);		
        this.txtgroupFee.setRequired(true);		
        this.txtgroupFee.setEnabled(false);
        // contprofit		
        this.contprofit.setBoundLabelText(resHelper.getString("contprofit.boundLabelText"));		
        this.contprofit.setBoundLabelLength(100);		
        this.contprofit.setBoundLabelUnderline(true);		
        this.contprofit.setVisible(true);
        // txtprofit		
        this.txtprofit.setVisible(true);		
        this.txtprofit.setHorizontalAlignment(2);		
        this.txtprofit.setDataType(1);		
        this.txtprofit.setSupportedEmpty(true);		
        this.txtprofit.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtprofit.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtprofit.setPrecision(2);		
        this.txtprofit.setRequired(true);		
        this.txtprofit.setEnabled(false);
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
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {pkauditTime,prmtperiod,txtRevenueFood,txtrevenueFeed,txtrevenueGroup,txtcostFood,txtcostFeed,txtcostGroup,txtmanageFee,txtFIFee,txtgroupFee,txtprofit,billStatus}));
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
        contCreator.setBounds(new Rectangle(372, 558, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(372, 558, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(702, 558, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(702, 558, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(372, 589, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(372, 589, 270, 19, KDLayout.Constraints.ANCHOR_CENTRE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(702, 589, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(702, 589, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(356, 23, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(356, 23, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(11, 23, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(11, 23, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(15, 562, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(15, 562, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(15, 591, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(15, 591, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdPanelRevenue.setBounds(new Rectangle(11, 109, 961, 73));
        this.add(kdPanelRevenue, new KDLayout.Constraints(11, 109, 961, 73, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator8.setBounds(new Rectangle(3, 95, 1009, 2));
        this.add(kDSeparator8, new KDLayout.Constraints(3, 95, 1009, 2, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator9.setBounds(new Rectangle(3, 202, 1009, 8));
        this.add(kDSeparator9, new KDLayout.Constraints(3, 202, 1009, 8, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator10.setBounds(new Rectangle(3, 462, 1009, 6));
        this.add(kDSeparator10, new KDLayout.Constraints(3, 462, 1009, 6, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator11.setBounds(new Rectangle(3, 544, 1009, 2));
        this.add(kDSeparator11, new KDLayout.Constraints(3, 544, 1009, 2, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kdPanelCost.setBounds(new Rectangle(11, 225, 961, 149));
        this.add(kdPanelCost, new KDLayout.Constraints(11, 225, 961, 149, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kdPanelFee.setBounds(new Rectangle(11, 388, 961, 62));
        this.add(kdPanelFee, new KDLayout.Constraints(11, 388, 961, 62, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kdPanelProfit.setBounds(new Rectangle(11, 473, 961, 62));
        this.add(kdPanelProfit, new KDLayout.Constraints(11, 473, 961, 62, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator13.setBounds(new Rectangle(3, 377, 1009, 2));
        this.add(kDSeparator13, new KDLayout.Constraints(3, 377, 1009, 2, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contperiod.setBounds(new Rectangle(702, 23, 270, 19));
        this.add(contperiod, new KDLayout.Constraints(702, 23, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbillStatus.setBounds(new Rectangle(11, 65, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(11, 65, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnGetCostAndRevenue.setBounds(new Rectangle(735, 63, 237, 21));
        this.add(btnGetCostAndRevenue, new KDLayout.Constraints(735, 63, 237, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contdescription.setBounds(new Rectangle(356, 65, 270, 19));
        this.add(contdescription, new KDLayout.Constraints(356, 65, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //kdPanelRevenue
        kdPanelRevenue.setLayout(new KDLayout());
        kdPanelRevenue.putClientProperty("OriginalBounds", new Rectangle(11, 109, 961, 73));        contRevenueFood.setBounds(new Rectangle(337, 23, 270, 19));
        kdPanelRevenue.add(contRevenueFood, new KDLayout.Constraints(337, 23, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contrevenueFeed.setBounds(new Rectangle(17, 23, 270, 19));
        kdPanelRevenue.add(contrevenueFeed, new KDLayout.Constraints(17, 23, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contrevenueGroup.setBounds(new Rectangle(657, 23, 270, 19));
        kdPanelRevenue.add(contrevenueGroup, new KDLayout.Constraints(657, 23, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contRevenueFood
        contRevenueFood.setBoundEditor(txtRevenueFood);
        //contrevenueFeed
        contrevenueFeed.setBoundEditor(txtrevenueFeed);
        //contrevenueGroup
        contrevenueGroup.setBoundEditor(txtrevenueGroup);
        //kdPanelCost
        kdPanelCost.setLayout(new KDLayout());
        kdPanelCost.putClientProperty("OriginalBounds", new Rectangle(11, 225, 961, 149));        contcostFood.setBounds(new Rectangle(343, 48, 270, 19));
        kdPanelCost.add(contcostFood, new KDLayout.Constraints(343, 48, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcostFeed.setBounds(new Rectangle(22, 48, 270, 19));
        kdPanelCost.add(contcostFeed, new KDLayout.Constraints(22, 48, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcostGroup.setBounds(new Rectangle(664, 48, 270, 19));
        kdPanelCost.add(contcostGroup, new KDLayout.Constraints(664, 48, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contcostFood
        contcostFood.setBoundEditor(txtcostFood);
        //contcostFeed
        contcostFeed.setBoundEditor(txtcostFeed);
        //contcostGroup
        contcostGroup.setBoundEditor(txtcostGroup);
        //kdPanelFee
        kdPanelFee.setLayout(new KDLayout());
        kdPanelFee.putClientProperty("OriginalBounds", new Rectangle(11, 388, 961, 62));        contmanageFee.setBounds(new Rectangle(22, 20, 270, 19));
        kdPanelFee.add(contmanageFee, new KDLayout.Constraints(22, 20, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contFIFee.setBounds(new Rectangle(347, 20, 270, 19));
        kdPanelFee.add(contFIFee, new KDLayout.Constraints(347, 20, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contgroupFee.setBounds(new Rectangle(673, 19, 270, 19));
        kdPanelFee.add(contgroupFee, new KDLayout.Constraints(673, 19, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contmanageFee
        contmanageFee.setBoundEditor(txtmanageFee);
        //contFIFee
        contFIFee.setBoundEditor(txtFIFee);
        //contgroupFee
        contgroupFee.setBoundEditor(txtgroupFee);
        //kdPanelProfit
        kdPanelProfit.setLayout(new KDLayout());
        kdPanelProfit.putClientProperty("OriginalBounds", new Rectangle(11, 473, 961, 62));        contprofit.setBounds(new Rectangle(18, 25, 270, 19));
        kdPanelProfit.add(contprofit, new KDLayout.Constraints(18, 25, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contprofit
        contprofit.setBoundEditor(txtprofit);
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
		dataBinder.registerBinding("RevenueFood", java.math.BigDecimal.class, this.txtRevenueFood, "value");
		dataBinder.registerBinding("revenueFeed", java.math.BigDecimal.class, this.txtrevenueFeed, "value");
		dataBinder.registerBinding("revenueGroup", java.math.BigDecimal.class, this.txtrevenueGroup, "value");
		dataBinder.registerBinding("costFood", java.math.BigDecimal.class, this.txtcostFood, "value");
		dataBinder.registerBinding("costFeed", java.math.BigDecimal.class, this.txtcostFeed, "value");
		dataBinder.registerBinding("costGroup", java.math.BigDecimal.class, this.txtcostGroup, "value");
		dataBinder.registerBinding("manageFee", java.math.BigDecimal.class, this.txtmanageFee, "value");
		dataBinder.registerBinding("FIFee", java.math.BigDecimal.class, this.txtFIFee, "value");
		dataBinder.registerBinding("groupFee", java.math.BigDecimal.class, this.txtgroupFee, "value");
		dataBinder.registerBinding("profit", java.math.BigDecimal.class, this.txtprofit, "value");
		dataBinder.registerBinding("period", com.kingdee.eas.basedata.assistant.PeriodInfo.class, this.prmtperiod, "data");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.custom.bsxbudget.billStatus.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("description", String.class, this.txtdescription, "text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.bsxbudget.app.BSXBudgetGroupEditUIHandler";
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
        this.editData = (com.kingdee.eas.custom.bsxbudget.BSXBudgetGroupInfo)ov;
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
		getValidateHelper().registerBindProperty("RevenueFood", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("revenueFeed", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("revenueGroup", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("costFood", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("costFeed", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("costGroup", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("manageFee", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FIFee", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("groupFee", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("profit", ValidateHelper.ON_SAVE);    
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
     * output btnGetCostAndRevenue_mouseClick method
     */
    protected void btnGetCostAndRevenue_mouseClick(java.awt.event.MouseEvent e) throws Exception
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
     * output prmtperiod_dataChange method
     */
    protected void prmtperiod_dataChange(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
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
        sic.add(new SelectorItemInfo("RevenueFood"));
        sic.add(new SelectorItemInfo("revenueFeed"));
        sic.add(new SelectorItemInfo("revenueGroup"));
        sic.add(new SelectorItemInfo("costFood"));
        sic.add(new SelectorItemInfo("costFeed"));
        sic.add(new SelectorItemInfo("costGroup"));
        sic.add(new SelectorItemInfo("manageFee"));
        sic.add(new SelectorItemInfo("FIFee"));
        sic.add(new SelectorItemInfo("groupFee"));
        sic.add(new SelectorItemInfo("profit"));
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
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.bsxbudget.BSXBudgetGroupFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.bsxbudget.BSXBudgetGroupFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractBSXBudgetGroupEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractBSXBudgetGroupEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.bsxbudget.client", "BSXBudgetGroupEditUI");
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
        return com.kingdee.eas.custom.bsxbudget.client.BSXBudgetGroupEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.bsxbudget.BSXBudgetGroupFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.bsxbudget.BSXBudgetGroupInfo objectValue = new com.kingdee.eas.custom.bsxbudget.BSXBudgetGroupInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/bsxbudget/BSXBudgetGroup";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.bsxbudget.app.BSXBudgetGroupQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtNumber.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"单据编号"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtRevenueFood.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"食品公司收入"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtrevenueFeed.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖公司收入"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtrevenueGroup.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"集团总收入"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtcostFood.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"食品公司成本"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtcostFeed.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖公司成本"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtcostGroup.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"集团总成本"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtmanageFee.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"管理费用"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtFIFee.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务费用"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtgroupFee.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"集团总费用"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtprofit.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"集团总利润"});
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