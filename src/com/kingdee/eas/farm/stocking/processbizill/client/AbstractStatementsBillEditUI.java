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
public abstract class AbstractStatementsBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractStatementsBillEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator9;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstockingBatch;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsettleType;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperiod;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbeginDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contendDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedStage;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmersTree;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstockingBatch;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel6;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel7;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEggEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEggEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtRewardsEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtRewardsEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtOtherEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtOtherEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtHandEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtHandEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarm;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDComboBox settleType;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel5;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel8;
    protected com.kingdee.bos.ctrl.swing.KDPanel kdPanelBatchDetail;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedDataAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfodderAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdrugAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbirdsAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmerProfit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contawardsAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmarginAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallEggAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthandAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoriginalFarmerProfit;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator11;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel1;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel2;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator13;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmarginInterest;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contloanInterest;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contalimony;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contotherMaterialAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoccupyInterest;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbreedDataAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfodderAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdrugAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbirdsAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfarmerProfit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtawardsAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmarginAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallEggAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txthandAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoriginalFarmerProfit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmarginInterest;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtloanInterest;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtalimony;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtotherMaterialAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoccupyInterest;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contFCR;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsurvivalRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbirdsQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfertilizationRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlayingRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contavgWeight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallLastStock;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteggQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatchContract;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfertilizationRate2;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtFCR;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsurvivalRate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbirdsQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfertilizationRate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtlayingRate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtavgWeight;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallLastStock;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txteggQty;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbatchContract;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfertilizationRate2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedDataCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfodderCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdrugCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contotherMaterialCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contarAmountOffset;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfaFurCardCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfeeCostAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallActualCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contunitActualAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcoProductAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contloanInterestDiff;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contreceiveQcEggQty;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel4;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbreedDataCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfodderCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdrugCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtotherMaterialCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtarAmountOffset;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfaFurCardCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfeeCostAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallActualCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtunitActualAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcoProductAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtloanInterestDiff;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtreceiveQcEggQty;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtBatchDetail;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtBatchDetail_detailPanel = null;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperiod;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkbeginDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkendDate;
    protected com.kingdee.bos.ctrl.swing.KDComboBox breedStage;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmersTree;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnExeCal;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnBreateBill;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDSeparator newSeparator3;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnExeCal;
    protected com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionBtnExeCal actionBtnExeCal = null;
    protected ActionMultiSubmit actionMultiSubmit = null;
    protected ActionBreateBill actionBreateBill = null;
    protected ActionCalYC actionCalYC = null;
    protected ActionCarryover actionCarryover = null;
    /**
     * output class constructor
     */
    public AbstractStatementsBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractStatementsBillEditUI.class.getName());
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
        this.actionSubmit.setExtendProperty("userDefined", "false");
        this.actionSubmit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
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
        //actionBtnExeCal
        this.actionBtnExeCal = new ActionBtnExeCal(this);
        getActionManager().registerAction("actionBtnExeCal", actionBtnExeCal);
        this.actionBtnExeCal.setExtendProperty("canForewarn", "true");
        this.actionBtnExeCal.setExtendProperty("userDefined", "false");
        this.actionBtnExeCal.setExtendProperty("isObjectUpdateLock", "false");
         this.actionBtnExeCal.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionBtnExeCal.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionMultiSubmit
        this.actionMultiSubmit = new ActionMultiSubmit(this);
        getActionManager().registerAction("actionMultiSubmit", actionMultiSubmit);
        this.actionMultiSubmit.setBindWorkFlow(true);
        this.actionMultiSubmit.setExtendProperty("canForewarn", "true");
        this.actionMultiSubmit.setExtendProperty("userDefined", "false");
        this.actionMultiSubmit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionMultiSubmit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionMultiSubmit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionMultiSubmit.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionBreateBill
        this.actionBreateBill = new ActionBreateBill(this);
        getActionManager().registerAction("actionBreateBill", actionBreateBill);
        this.actionBreateBill.setExtendProperty("canForewarn", "true");
        this.actionBreateBill.setExtendProperty("userDefined", "true");
        this.actionBreateBill.setExtendProperty("isObjectUpdateLock", "false");
         this.actionBreateBill.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionBreateBill.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionCalYC
        this.actionCalYC = new ActionCalYC(this);
        getActionManager().registerAction("actionCalYC", actionCalYC);
        this.actionCalYC.setExtendProperty("canForewarn", "true");
        this.actionCalYC.setExtendProperty("userDefined", "false");
        this.actionCalYC.setExtendProperty("isObjectUpdateLock", "false");
         this.actionCalYC.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionCalYC.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionCarryover
        this.actionCarryover = new ActionCarryover(this);
        getActionManager().registerAction("actionCarryover", actionCarryover);
        this.actionCarryover.setExtendProperty("canForewarn", "true");
        this.actionCarryover.setExtendProperty("userDefined", "false");
        this.actionCarryover.setExtendProperty("isObjectUpdateLock", "false");
         this.actionCarryover.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionCarryover.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDSeparator9 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contfarmer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstockingBatch = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contfarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstorageOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsettleType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane2 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contperiod = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbeginDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contendDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbreedStage = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmersTree = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtfarmer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtstockingBatch = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel6 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel7 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtEggEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtRewardsEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtOtherEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtHandEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.prmtfarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtstorageOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.settleType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.kDPanel5 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel8 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdPanelBatchDetail = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contbreedDataAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfodderAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdrugAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbirdsAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmerProfit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contawardsAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmarginAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallEggAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthandAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoriginalFarmerProfit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator11 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDLabel1 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDLabel2 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDSeparator13 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDLabel3 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.contmarginInterest = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contloanInterest = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contalimony = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contotherMaterialAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoccupyInterest = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtbreedDataAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfodderAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdrugAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbirdsAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfarmerProfit = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtawardsAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmarginAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallEggAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txthandAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtoriginalFarmerProfit = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmarginInterest = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtloanInterest = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtalimony = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtotherMaterialAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtoccupyInterest = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contallQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contFCR = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsurvivalRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbirdsQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfertilizationRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlayingRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contavgWeight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallLastStock = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteggQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbatchContract = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfertilizationRate2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtallQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtFCR = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsurvivalRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbirdsQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfertilizationRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtlayingRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtavgWeight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallLastStock = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txteggQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtbatchContract = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtfertilizationRate2 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contbreedDataCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfodderCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdrugCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contotherMaterialCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contarAmountOffset = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfaFurCardCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfeeCostAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallActualCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contunitActualAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcoProductAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contloanInterestDiff = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contreceiveQcEggQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabel4 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.txtbreedDataCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfodderCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdrugCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtotherMaterialCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtarAmountOffset = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfaFurCardCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfeeCostAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallActualCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtunitActualAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcoProductAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtloanInterestDiff = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtreceiveQcEggQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kdtBatchDetail = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.prmtperiod = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkbeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkendDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.breedStage = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtfarmersTree = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.tBtnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnExeCal = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnBreateBill = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.mBtnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.mBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.newSeparator3 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.mBtnExeCal = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contAuditor.setName("contAuditor");
        this.contbillStatus.setName("contbillStatus");
        this.contcompany.setName("contcompany");
        this.contauditTime.setName("contauditTime");
        this.kDSeparator8.setName("kDSeparator8");
        this.kDSeparator9.setName("kDSeparator9");
        this.contfarmer.setName("contfarmer");
        this.contstockingBatch.setName("contstockingBatch");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contfarm.setName("contfarm");
        this.contstorageOrgUnit.setName("contstorageOrgUnit");
        this.contsettleType.setName("contsettleType");
        this.kDTabbedPane2.setName("kDTabbedPane2");
        this.contperiod.setName("contperiod");
        this.contbeginDate.setName("contbeginDate");
        this.contendDate.setName("contendDate");
        this.contbreedStage.setName("contbreedStage");
        this.contfarmersTree.setName("contfarmersTree");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.prmtAuditor.setName("prmtAuditor");
        this.billStatus.setName("billStatus");
        this.prmtcompany.setName("prmtcompany");
        this.pkauditTime.setName("pkauditTime");
        this.prmtfarmer.setName("prmtfarmer");
        this.prmtstockingBatch.setName("prmtstockingBatch");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel6.setName("kDPanel6");
        this.kDPanel7.setName("kDPanel7");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel3.setName("kDPanel3");
        this.kdtEntrys.setName("kdtEntrys");
        this.kdtEggEntry.setName("kdtEggEntry");
        this.kdtRewardsEntry.setName("kdtRewardsEntry");
        this.kdtOtherEntry.setName("kdtOtherEntry");
        this.kdtHandEntry.setName("kdtHandEntry");
        this.prmtfarm.setName("prmtfarm");
        this.prmtstorageOrgUnit.setName("prmtstorageOrgUnit");
        this.settleType.setName("settleType");
        this.kDPanel5.setName("kDPanel5");
        this.kDPanel4.setName("kDPanel4");
        this.kDPanel8.setName("kDPanel8");
        this.kdPanelBatchDetail.setName("kdPanelBatchDetail");
        this.contbreedDataAmount.setName("contbreedDataAmount");
        this.contfodderAmount.setName("contfodderAmount");
        this.contdrugAmount.setName("contdrugAmount");
        this.contbirdsAmount.setName("contbirdsAmount");
        this.contfarmerProfit.setName("contfarmerProfit");
        this.contawardsAmount.setName("contawardsAmount");
        this.contmarginAmount.setName("contmarginAmount");
        this.contallEggAmount.setName("contallEggAmount");
        this.conthandAmount.setName("conthandAmount");
        this.contoriginalFarmerProfit.setName("contoriginalFarmerProfit");
        this.kDSeparator11.setName("kDSeparator11");
        this.kDLabel1.setName("kDLabel1");
        this.kDLabel2.setName("kDLabel2");
        this.kDSeparator13.setName("kDSeparator13");
        this.kDLabel3.setName("kDLabel3");
        this.contmarginInterest.setName("contmarginInterest");
        this.contloanInterest.setName("contloanInterest");
        this.contalimony.setName("contalimony");
        this.contotherMaterialAmount.setName("contotherMaterialAmount");
        this.contoccupyInterest.setName("contoccupyInterest");
        this.txtbreedDataAmount.setName("txtbreedDataAmount");
        this.txtfodderAmount.setName("txtfodderAmount");
        this.txtdrugAmount.setName("txtdrugAmount");
        this.txtbirdsAmount.setName("txtbirdsAmount");
        this.txtfarmerProfit.setName("txtfarmerProfit");
        this.txtawardsAmount.setName("txtawardsAmount");
        this.txtmarginAmount.setName("txtmarginAmount");
        this.txtallEggAmount.setName("txtallEggAmount");
        this.txthandAmount.setName("txthandAmount");
        this.txtoriginalFarmerProfit.setName("txtoriginalFarmerProfit");
        this.txtmarginInterest.setName("txtmarginInterest");
        this.txtloanInterest.setName("txtloanInterest");
        this.txtalimony.setName("txtalimony");
        this.txtotherMaterialAmount.setName("txtotherMaterialAmount");
        this.txtoccupyInterest.setName("txtoccupyInterest");
        this.contallQty.setName("contallQty");
        this.contFCR.setName("contFCR");
        this.contsurvivalRate.setName("contsurvivalRate");
        this.contbirdsQty.setName("contbirdsQty");
        this.contfertilizationRate.setName("contfertilizationRate");
        this.contlayingRate.setName("contlayingRate");
        this.contavgWeight.setName("contavgWeight");
        this.contallLastStock.setName("contallLastStock");
        this.conteggQty.setName("conteggQty");
        this.contDescription.setName("contDescription");
        this.contbatchContract.setName("contbatchContract");
        this.contfertilizationRate2.setName("contfertilizationRate2");
        this.txtallQty.setName("txtallQty");
        this.txtFCR.setName("txtFCR");
        this.txtsurvivalRate.setName("txtsurvivalRate");
        this.txtbirdsQty.setName("txtbirdsQty");
        this.txtfertilizationRate.setName("txtfertilizationRate");
        this.txtlayingRate.setName("txtlayingRate");
        this.txtavgWeight.setName("txtavgWeight");
        this.txtallLastStock.setName("txtallLastStock");
        this.txteggQty.setName("txteggQty");
        this.txtDescription.setName("txtDescription");
        this.prmtbatchContract.setName("prmtbatchContract");
        this.txtfertilizationRate2.setName("txtfertilizationRate2");
        this.contbreedDataCost.setName("contbreedDataCost");
        this.contfodderCost.setName("contfodderCost");
        this.contdrugCost.setName("contdrugCost");
        this.contotherMaterialCost.setName("contotherMaterialCost");
        this.contarAmountOffset.setName("contarAmountOffset");
        this.contfaFurCardCost.setName("contfaFurCardCost");
        this.contfeeCostAmount.setName("contfeeCostAmount");
        this.contallActualCost.setName("contallActualCost");
        this.contunitActualAmount.setName("contunitActualAmount");
        this.contcoProductAmount.setName("contcoProductAmount");
        this.contloanInterestDiff.setName("contloanInterestDiff");
        this.contreceiveQcEggQty.setName("contreceiveQcEggQty");
        this.kDLabel4.setName("kDLabel4");
        this.txtbreedDataCost.setName("txtbreedDataCost");
        this.txtfodderCost.setName("txtfodderCost");
        this.txtdrugCost.setName("txtdrugCost");
        this.txtotherMaterialCost.setName("txtotherMaterialCost");
        this.txtarAmountOffset.setName("txtarAmountOffset");
        this.txtfaFurCardCost.setName("txtfaFurCardCost");
        this.txtfeeCostAmount.setName("txtfeeCostAmount");
        this.txtallActualCost.setName("txtallActualCost");
        this.txtunitActualAmount.setName("txtunitActualAmount");
        this.txtcoProductAmount.setName("txtcoProductAmount");
        this.txtloanInterestDiff.setName("txtloanInterestDiff");
        this.txtreceiveQcEggQty.setName("txtreceiveQcEggQty");
        this.kdtBatchDetail.setName("kdtBatchDetail");
        this.prmtperiod.setName("prmtperiod");
        this.pkbeginDate.setName("pkbeginDate");
        this.pkendDate.setName("pkendDate");
        this.breedStage.setName("breedStage");
        this.prmtfarmersTree.setName("prmtfarmersTree");
        this.tBtnAudit.setName("tBtnAudit");
        this.tBtnUnAudit.setName("tBtnUnAudit");
        this.tBtnExeCal.setName("tBtnExeCal");
        this.btnBreateBill.setName("btnBreateBill");
        this.mBtnAudit.setName("mBtnAudit");
        this.mBtnUnAudit.setName("mBtnUnAudit");
        this.newSeparator3.setName("newSeparator3");
        this.mBtnExeCal.setName("mBtnExeCal");
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
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);
        // contbillStatus		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(55);		
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
        // kDSeparator9
        // contfarmer		
        this.contfarmer.setBoundLabelText(resHelper.getString("contfarmer.boundLabelText"));		
        this.contfarmer.setBoundLabelLength(100);		
        this.contfarmer.setBoundLabelUnderline(true);		
        this.contfarmer.setVisible(true);
        // contstockingBatch		
        this.contstockingBatch.setBoundLabelText(resHelper.getString("contstockingBatch.boundLabelText"));		
        this.contstockingBatch.setBoundLabelLength(100);		
        this.contstockingBatch.setBoundLabelUnderline(true);		
        this.contstockingBatch.setVisible(true);
        // kDTabbedPane1
        // contfarm		
        this.contfarm.setBoundLabelText(resHelper.getString("contfarm.boundLabelText"));		
        this.contfarm.setBoundLabelLength(100);		
        this.contfarm.setBoundLabelUnderline(true);		
        this.contfarm.setVisible(true);
        // contstorageOrgUnit		
        this.contstorageOrgUnit.setBoundLabelText(resHelper.getString("contstorageOrgUnit.boundLabelText"));		
        this.contstorageOrgUnit.setBoundLabelLength(100);		
        this.contstorageOrgUnit.setBoundLabelUnderline(true);		
        this.contstorageOrgUnit.setVisible(false);
        // contsettleType		
        this.contsettleType.setBoundLabelText(resHelper.getString("contsettleType.boundLabelText"));		
        this.contsettleType.setBoundLabelLength(55);		
        this.contsettleType.setBoundLabelUnderline(true);		
        this.contsettleType.setVisible(true);
        // kDTabbedPane2
        // contperiod		
        this.contperiod.setBoundLabelText(resHelper.getString("contperiod.boundLabelText"));		
        this.contperiod.setBoundLabelLength(100);		
        this.contperiod.setBoundLabelUnderline(true);		
        this.contperiod.setVisible(true);
        // contbeginDate		
        this.contbeginDate.setBoundLabelText(resHelper.getString("contbeginDate.boundLabelText"));		
        this.contbeginDate.setBoundLabelLength(100);		
        this.contbeginDate.setBoundLabelUnderline(true);
        // contendDate		
        this.contendDate.setBoundLabelText(resHelper.getString("contendDate.boundLabelText"));		
        this.contendDate.setBoundLabelLength(100);		
        this.contendDate.setBoundLabelUnderline(true);
        // contbreedStage		
        this.contbreedStage.setBoundLabelText(resHelper.getString("contbreedStage.boundLabelText"));		
        this.contbreedStage.setBoundLabelLength(100);		
        this.contbreedStage.setBoundLabelUnderline(true);
        // contfarmersTree		
        this.contfarmersTree.setBoundLabelText(resHelper.getString("contfarmersTree.boundLabelText"));		
        this.contfarmersTree.setBoundLabelLength(100);		
        this.contfarmersTree.setBoundLabelUnderline(true);		
        this.contfarmersTree.setVisible(true);
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
					
        // prmtstockingBatch		
        this.prmtstockingBatch.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.StockingBatchQuery");		
        this.prmtstockingBatch.setEditable(true);		
        this.prmtstockingBatch.setDisplayFormat("$number$");		
        this.prmtstockingBatch.setEditFormat("$number$");		
        this.prmtstockingBatch.setCommitFormat("$number$");		
        this.prmtstockingBatch.setRequired(false);
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
					
        // kDPanel1
        // kDPanel6
        // kDPanel7
        // kDPanel2
        // kDPanel3
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol1\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"settlementItem\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"ItemName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"materialName\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"price\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"remark\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"unitActualCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"actualCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{settlementItem}</t:Cell><t:Cell>$Resource{ItemName}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{model}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{price}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{remark}</t:Cell><t:Cell>$Resource{unitActualCost}</t:Cell><t:Cell>$Resource{actualCost}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtEntrys.putBindContents("editData",new String[] {"id","settlementItem","ItemName","material","materialName","model","unit","qty","price","amount","remark","unitActualCost","actualCost"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_settlementItem_PromptBox = new KDBizPromptBox();
        kdtEntrys_settlementItem_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.SettlementItemQuery");
        kdtEntrys_settlementItem_PromptBox.setVisible(true);
        kdtEntrys_settlementItem_PromptBox.setEditable(true);
        kdtEntrys_settlementItem_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_settlementItem_PromptBox.setEditFormat("$number$");
        kdtEntrys_settlementItem_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_settlementItem_CellEditor = new KDTDefaultCellEditor(kdtEntrys_settlementItem_PromptBox);
        this.kdtEntrys.getColumn("settlementItem").setEditor(kdtEntrys_settlementItem_CellEditor);
        ObjectValueRender kdtEntrys_settlementItem_OVR = new ObjectValueRender();
        kdtEntrys_settlementItem_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("settlementItem").setRenderer(kdtEntrys_settlementItem_OVR);
        			kdtEntrys_settlementItem_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.SettlementItemListUI kdtEntrys_settlementItem_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_settlementItem_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_settlementItem_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.SettlementItemListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_settlementItem_PromptBox_F7ListUI));
					kdtEntrys_settlementItem_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_settlementItem_PromptBox.setSelector(kdtEntrys_settlementItem_PromptBox_F7ListUI);
				}
			}
		});
					
        KDTextField kdtEntrys_ItemName_TextField = new KDTextField();
        kdtEntrys_ItemName_TextField.setName("kdtEntrys_ItemName_TextField");
        kdtEntrys_ItemName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_ItemName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_ItemName_TextField);
        this.kdtEntrys.getColumn("ItemName").setEditor(kdtEntrys_ItemName_CellEditor);
        final KDBizPromptBox kdtEntrys_material_PromptBox = new KDBizPromptBox();
        kdtEntrys_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtEntrys_material_PromptBox.setVisible(true);
        kdtEntrys_material_PromptBox.setEditable(true);
        kdtEntrys_material_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_material_PromptBox.setEditFormat("$number$");
        kdtEntrys_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_material_CellEditor = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox);
        this.kdtEntrys.getColumn("material").setEditor(kdtEntrys_material_CellEditor);
        ObjectValueRender kdtEntrys_material_OVR = new ObjectValueRender();
        kdtEntrys_material_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("material").setRenderer(kdtEntrys_material_OVR);
        KDTextField kdtEntrys_materialName_TextField = new KDTextField();
        kdtEntrys_materialName_TextField.setName("kdtEntrys_materialName_TextField");
        kdtEntrys_materialName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_materialName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_materialName_TextField);
        this.kdtEntrys.getColumn("materialName").setEditor(kdtEntrys_materialName_CellEditor);
        KDTextField kdtEntrys_model_TextField = new KDTextField();
        kdtEntrys_model_TextField.setName("kdtEntrys_model_TextField");
        kdtEntrys_model_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_model_CellEditor = new KDTDefaultCellEditor(kdtEntrys_model_TextField);
        this.kdtEntrys.getColumn("model").setEditor(kdtEntrys_model_CellEditor);
        final KDBizPromptBox kdtEntrys_unit_PromptBox = new KDBizPromptBox();
        kdtEntrys_unit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtEntrys_unit_PromptBox.setVisible(true);
        kdtEntrys_unit_PromptBox.setEditable(true);
        kdtEntrys_unit_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_unit_PromptBox.setEditFormat("$number$");
        kdtEntrys_unit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_unit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_unit_PromptBox);
        this.kdtEntrys.getColumn("unit").setEditor(kdtEntrys_unit_CellEditor);
        ObjectValueRender kdtEntrys_unit_OVR = new ObjectValueRender();
        kdtEntrys_unit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("unit").setRenderer(kdtEntrys_unit_OVR);
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
        KDFormattedTextField kdtEntrys_price_TextField = new KDFormattedTextField();
        kdtEntrys_price_TextField.setName("kdtEntrys_price_TextField");
        kdtEntrys_price_TextField.setVisible(true);
        kdtEntrys_price_TextField.setEditable(true);
        kdtEntrys_price_TextField.setHorizontalAlignment(2);
        kdtEntrys_price_TextField.setDataType(1);
        	kdtEntrys_price_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_price_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_price_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_price_CellEditor = new KDTDefaultCellEditor(kdtEntrys_price_TextField);
        this.kdtEntrys.getColumn("price").setEditor(kdtEntrys_price_CellEditor);
        KDFormattedTextField kdtEntrys_amount_TextField = new KDFormattedTextField();
        kdtEntrys_amount_TextField.setName("kdtEntrys_amount_TextField");
        kdtEntrys_amount_TextField.setVisible(true);
        kdtEntrys_amount_TextField.setEditable(true);
        kdtEntrys_amount_TextField.setHorizontalAlignment(2);
        kdtEntrys_amount_TextField.setDataType(1);
        	kdtEntrys_amount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_amount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_amount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_amount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_amount_TextField);
        this.kdtEntrys.getColumn("amount").setEditor(kdtEntrys_amount_CellEditor);
        KDTextField kdtEntrys_remark_TextField = new KDTextField();
        kdtEntrys_remark_TextField.setName("kdtEntrys_remark_TextField");
        kdtEntrys_remark_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_remark_CellEditor = new KDTDefaultCellEditor(kdtEntrys_remark_TextField);
        this.kdtEntrys.getColumn("remark").setEditor(kdtEntrys_remark_CellEditor);
        KDFormattedTextField kdtEntrys_unitActualCost_TextField = new KDFormattedTextField();
        kdtEntrys_unitActualCost_TextField.setName("kdtEntrys_unitActualCost_TextField");
        kdtEntrys_unitActualCost_TextField.setVisible(true);
        kdtEntrys_unitActualCost_TextField.setEditable(true);
        kdtEntrys_unitActualCost_TextField.setHorizontalAlignment(2);
        kdtEntrys_unitActualCost_TextField.setDataType(1);
        	kdtEntrys_unitActualCost_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_unitActualCost_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_unitActualCost_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_unitActualCost_CellEditor = new KDTDefaultCellEditor(kdtEntrys_unitActualCost_TextField);
        this.kdtEntrys.getColumn("unitActualCost").setEditor(kdtEntrys_unitActualCost_CellEditor);
        KDFormattedTextField kdtEntrys_actualCost_TextField = new KDFormattedTextField();
        kdtEntrys_actualCost_TextField.setName("kdtEntrys_actualCost_TextField");
        kdtEntrys_actualCost_TextField.setVisible(true);
        kdtEntrys_actualCost_TextField.setEditable(true);
        kdtEntrys_actualCost_TextField.setHorizontalAlignment(2);
        kdtEntrys_actualCost_TextField.setDataType(1);
        	kdtEntrys_actualCost_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_actualCost_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_actualCost_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_actualCost_CellEditor = new KDTDefaultCellEditor(kdtEntrys_actualCost_TextField);
        this.kdtEntrys.getColumn("actualCost").setEditor(kdtEntrys_actualCost_CellEditor);
        // kdtEggEntry
		String kdtEggEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"settlementItem\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"itemName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"materialName\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"weight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"price\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"remark\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{settlementItem}</t:Cell><t:Cell>$Resource{itemName}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{model}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{weight}</t:Cell><t:Cell>$Resource{price}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{remark}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEggEntry.setFormatXml(resHelper.translateString("kdtEggEntry",kdtEggEntryStrXML));
        kdtEggEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtEggEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtEggEntry.putBindContents("editData",new String[] {"seq","settlementItem","itemName","material","materialName","model","unit","qty","number","weight","price","amount","remark"});


        this.kdtEggEntry.checkParsed();
        KDFormattedTextField kdtEggEntry_seq_TextField = new KDFormattedTextField();
        kdtEggEntry_seq_TextField.setName("kdtEggEntry_seq_TextField");
        kdtEggEntry_seq_TextField.setVisible(true);
        kdtEggEntry_seq_TextField.setEditable(true);
        kdtEggEntry_seq_TextField.setHorizontalAlignment(2);
        kdtEggEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_seq_TextField);
        this.kdtEggEntry.getColumn("seq").setEditor(kdtEggEntry_seq_CellEditor);
        final KDBizPromptBox kdtEggEntry_settlementItem_PromptBox = new KDBizPromptBox();
        kdtEggEntry_settlementItem_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.SettlementItemQuery");
        kdtEggEntry_settlementItem_PromptBox.setVisible(true);
        kdtEggEntry_settlementItem_PromptBox.setEditable(true);
        kdtEggEntry_settlementItem_PromptBox.setDisplayFormat("$number$");
        kdtEggEntry_settlementItem_PromptBox.setEditFormat("$number$");
        kdtEggEntry_settlementItem_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntry_settlementItem_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_settlementItem_PromptBox);
        this.kdtEggEntry.getColumn("settlementItem").setEditor(kdtEggEntry_settlementItem_CellEditor);
        ObjectValueRender kdtEggEntry_settlementItem_OVR = new ObjectValueRender();
        kdtEggEntry_settlementItem_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntry.getColumn("settlementItem").setRenderer(kdtEggEntry_settlementItem_OVR);
        			kdtEggEntry_settlementItem_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.SettlementItemListUI kdtEggEntry_settlementItem_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEggEntry_settlementItem_PromptBox_F7ListUI == null) {
					try {
						kdtEggEntry_settlementItem_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.SettlementItemListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEggEntry_settlementItem_PromptBox_F7ListUI));
					kdtEggEntry_settlementItem_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEggEntry_settlementItem_PromptBox.setSelector(kdtEggEntry_settlementItem_PromptBox_F7ListUI);
				}
			}
		});
					
        KDTextField kdtEggEntry_itemName_TextField = new KDTextField();
        kdtEggEntry_itemName_TextField.setName("kdtEggEntry_itemName_TextField");
        kdtEggEntry_itemName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEggEntry_itemName_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_itemName_TextField);
        this.kdtEggEntry.getColumn("itemName").setEditor(kdtEggEntry_itemName_CellEditor);
        final KDBizPromptBox kdtEggEntry_material_PromptBox = new KDBizPromptBox();
        kdtEggEntry_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtEggEntry_material_PromptBox.setVisible(true);
        kdtEggEntry_material_PromptBox.setEditable(true);
        kdtEggEntry_material_PromptBox.setDisplayFormat("$number$");
        kdtEggEntry_material_PromptBox.setEditFormat("$number$");
        kdtEggEntry_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntry_material_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_material_PromptBox);
        this.kdtEggEntry.getColumn("material").setEditor(kdtEggEntry_material_CellEditor);
        ObjectValueRender kdtEggEntry_material_OVR = new ObjectValueRender();
        kdtEggEntry_material_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEggEntry.getColumn("material").setRenderer(kdtEggEntry_material_OVR);
        KDTextField kdtEggEntry_materialName_TextField = new KDTextField();
        kdtEggEntry_materialName_TextField.setName("kdtEggEntry_materialName_TextField");
        kdtEggEntry_materialName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEggEntry_materialName_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_materialName_TextField);
        this.kdtEggEntry.getColumn("materialName").setEditor(kdtEggEntry_materialName_CellEditor);
        KDTextField kdtEggEntry_model_TextField = new KDTextField();
        kdtEggEntry_model_TextField.setName("kdtEggEntry_model_TextField");
        kdtEggEntry_model_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEggEntry_model_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_model_TextField);
        this.kdtEggEntry.getColumn("model").setEditor(kdtEggEntry_model_CellEditor);
        final KDBizPromptBox kdtEggEntry_unit_PromptBox = new KDBizPromptBox();
        kdtEggEntry_unit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtEggEntry_unit_PromptBox.setVisible(true);
        kdtEggEntry_unit_PromptBox.setEditable(true);
        kdtEggEntry_unit_PromptBox.setDisplayFormat("$number$");
        kdtEggEntry_unit_PromptBox.setEditFormat("$number$");
        kdtEggEntry_unit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntry_unit_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_unit_PromptBox);
        this.kdtEggEntry.getColumn("unit").setEditor(kdtEggEntry_unit_CellEditor);
        ObjectValueRender kdtEggEntry_unit_OVR = new ObjectValueRender();
        kdtEggEntry_unit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntry.getColumn("unit").setRenderer(kdtEggEntry_unit_OVR);
        KDFormattedTextField kdtEggEntry_qty_TextField = new KDFormattedTextField();
        kdtEggEntry_qty_TextField.setName("kdtEggEntry_qty_TextField");
        kdtEggEntry_qty_TextField.setVisible(true);
        kdtEggEntry_qty_TextField.setEditable(true);
        kdtEggEntry_qty_TextField.setHorizontalAlignment(2);
        kdtEggEntry_qty_TextField.setDataType(1);
        	kdtEggEntry_qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEggEntry_qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEggEntry_qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEggEntry_qty_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_qty_TextField);
        this.kdtEggEntry.getColumn("qty").setEditor(kdtEggEntry_qty_CellEditor);
        KDFormattedTextField kdtEggEntry_number_TextField = new KDFormattedTextField();
        kdtEggEntry_number_TextField.setName("kdtEggEntry_number_TextField");
        kdtEggEntry_number_TextField.setVisible(true);
        kdtEggEntry_number_TextField.setEditable(true);
        kdtEggEntry_number_TextField.setHorizontalAlignment(2);
        kdtEggEntry_number_TextField.setDataType(1);
        	kdtEggEntry_number_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEggEntry_number_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEggEntry_number_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEggEntry_number_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_number_TextField);
        this.kdtEggEntry.getColumn("number").setEditor(kdtEggEntry_number_CellEditor);
        KDFormattedTextField kdtEggEntry_weight_TextField = new KDFormattedTextField();
        kdtEggEntry_weight_TextField.setName("kdtEggEntry_weight_TextField");
        kdtEggEntry_weight_TextField.setVisible(true);
        kdtEggEntry_weight_TextField.setEditable(true);
        kdtEggEntry_weight_TextField.setHorizontalAlignment(2);
        kdtEggEntry_weight_TextField.setDataType(1);
        	kdtEggEntry_weight_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEggEntry_weight_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEggEntry_weight_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEggEntry_weight_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_weight_TextField);
        this.kdtEggEntry.getColumn("weight").setEditor(kdtEggEntry_weight_CellEditor);
        KDFormattedTextField kdtEggEntry_price_TextField = new KDFormattedTextField();
        kdtEggEntry_price_TextField.setName("kdtEggEntry_price_TextField");
        kdtEggEntry_price_TextField.setVisible(true);
        kdtEggEntry_price_TextField.setEditable(true);
        kdtEggEntry_price_TextField.setHorizontalAlignment(2);
        kdtEggEntry_price_TextField.setDataType(1);
        	kdtEggEntry_price_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEggEntry_price_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEggEntry_price_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEggEntry_price_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_price_TextField);
        this.kdtEggEntry.getColumn("price").setEditor(kdtEggEntry_price_CellEditor);
        KDFormattedTextField kdtEggEntry_amount_TextField = new KDFormattedTextField();
        kdtEggEntry_amount_TextField.setName("kdtEggEntry_amount_TextField");
        kdtEggEntry_amount_TextField.setVisible(true);
        kdtEggEntry_amount_TextField.setEditable(true);
        kdtEggEntry_amount_TextField.setHorizontalAlignment(2);
        kdtEggEntry_amount_TextField.setDataType(1);
        	kdtEggEntry_amount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEggEntry_amount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEggEntry_amount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEggEntry_amount_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_amount_TextField);
        this.kdtEggEntry.getColumn("amount").setEditor(kdtEggEntry_amount_CellEditor);
        KDTextField kdtEggEntry_remark_TextField = new KDTextField();
        kdtEggEntry_remark_TextField.setName("kdtEggEntry_remark_TextField");
        kdtEggEntry_remark_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEggEntry_remark_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_remark_TextField);
        this.kdtEggEntry.getColumn("remark").setEditor(kdtEggEntry_remark_CellEditor);
        // kdtRewardsEntry
		String kdtRewardsEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"itemName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"itemID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"remark\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{itemName}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{itemID}</t:Cell><t:Cell>$Resource{remark}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtRewardsEntry.setFormatXml(resHelper.translateString("kdtRewardsEntry",kdtRewardsEntryStrXML));

                this.kdtRewardsEntry.putBindContents("editData",new String[] {"seq","itemName","amount","itemID","remark"});


        this.kdtRewardsEntry.checkParsed();
        KDFormattedTextField kdtRewardsEntry_seq_TextField = new KDFormattedTextField();
        kdtRewardsEntry_seq_TextField.setName("kdtRewardsEntry_seq_TextField");
        kdtRewardsEntry_seq_TextField.setVisible(true);
        kdtRewardsEntry_seq_TextField.setEditable(true);
        kdtRewardsEntry_seq_TextField.setHorizontalAlignment(2);
        kdtRewardsEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtRewardsEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtRewardsEntry_seq_TextField);
        this.kdtRewardsEntry.getColumn("seq").setEditor(kdtRewardsEntry_seq_CellEditor);
        KDTextField kdtRewardsEntry_itemName_TextField = new KDTextField();
        kdtRewardsEntry_itemName_TextField.setName("kdtRewardsEntry_itemName_TextField");
        kdtRewardsEntry_itemName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtRewardsEntry_itemName_CellEditor = new KDTDefaultCellEditor(kdtRewardsEntry_itemName_TextField);
        this.kdtRewardsEntry.getColumn("itemName").setEditor(kdtRewardsEntry_itemName_CellEditor);
        KDFormattedTextField kdtRewardsEntry_amount_TextField = new KDFormattedTextField();
        kdtRewardsEntry_amount_TextField.setName("kdtRewardsEntry_amount_TextField");
        kdtRewardsEntry_amount_TextField.setVisible(true);
        kdtRewardsEntry_amount_TextField.setEditable(true);
        kdtRewardsEntry_amount_TextField.setHorizontalAlignment(2);
        kdtRewardsEntry_amount_TextField.setDataType(1);
        	kdtRewardsEntry_amount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtRewardsEntry_amount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtRewardsEntry_amount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtRewardsEntry_amount_CellEditor = new KDTDefaultCellEditor(kdtRewardsEntry_amount_TextField);
        this.kdtRewardsEntry.getColumn("amount").setEditor(kdtRewardsEntry_amount_CellEditor);
        KDTextField kdtRewardsEntry_itemID_TextField = new KDTextField();
        kdtRewardsEntry_itemID_TextField.setName("kdtRewardsEntry_itemID_TextField");
        kdtRewardsEntry_itemID_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtRewardsEntry_itemID_CellEditor = new KDTDefaultCellEditor(kdtRewardsEntry_itemID_TextField);
        this.kdtRewardsEntry.getColumn("itemID").setEditor(kdtRewardsEntry_itemID_CellEditor);
        KDTextField kdtRewardsEntry_remark_TextField = new KDTextField();
        kdtRewardsEntry_remark_TextField.setName("kdtRewardsEntry_remark_TextField");
        kdtRewardsEntry_remark_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtRewardsEntry_remark_CellEditor = new KDTDefaultCellEditor(kdtRewardsEntry_remark_TextField);
        this.kdtRewardsEntry.getColumn("remark").setEditor(kdtRewardsEntry_remark_CellEditor);
        // kdtOtherEntry
		String kdtOtherEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"itemName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"remark\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{itemName}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{remark}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtOtherEntry.setFormatXml(resHelper.translateString("kdtOtherEntry",kdtOtherEntryStrXML));

                this.kdtOtherEntry.putBindContents("editData",new String[] {"seq","itemName","qty","amount","remark"});


        this.kdtOtherEntry.checkParsed();
        KDFormattedTextField kdtOtherEntry_seq_TextField = new KDFormattedTextField();
        kdtOtherEntry_seq_TextField.setName("kdtOtherEntry_seq_TextField");
        kdtOtherEntry_seq_TextField.setVisible(true);
        kdtOtherEntry_seq_TextField.setEditable(true);
        kdtOtherEntry_seq_TextField.setHorizontalAlignment(2);
        kdtOtherEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtOtherEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtOtherEntry_seq_TextField);
        this.kdtOtherEntry.getColumn("seq").setEditor(kdtOtherEntry_seq_CellEditor);
        KDTextField kdtOtherEntry_itemName_TextField = new KDTextField();
        kdtOtherEntry_itemName_TextField.setName("kdtOtherEntry_itemName_TextField");
        kdtOtherEntry_itemName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtOtherEntry_itemName_CellEditor = new KDTDefaultCellEditor(kdtOtherEntry_itemName_TextField);
        this.kdtOtherEntry.getColumn("itemName").setEditor(kdtOtherEntry_itemName_CellEditor);
        KDFormattedTextField kdtOtherEntry_qty_TextField = new KDFormattedTextField();
        kdtOtherEntry_qty_TextField.setName("kdtOtherEntry_qty_TextField");
        kdtOtherEntry_qty_TextField.setVisible(true);
        kdtOtherEntry_qty_TextField.setEditable(true);
        kdtOtherEntry_qty_TextField.setHorizontalAlignment(2);
        kdtOtherEntry_qty_TextField.setDataType(1);
        	kdtOtherEntry_qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtOtherEntry_qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtOtherEntry_qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtOtherEntry_qty_CellEditor = new KDTDefaultCellEditor(kdtOtherEntry_qty_TextField);
        this.kdtOtherEntry.getColumn("qty").setEditor(kdtOtherEntry_qty_CellEditor);
        KDFormattedTextField kdtOtherEntry_amount_TextField = new KDFormattedTextField();
        kdtOtherEntry_amount_TextField.setName("kdtOtherEntry_amount_TextField");
        kdtOtherEntry_amount_TextField.setVisible(true);
        kdtOtherEntry_amount_TextField.setEditable(true);
        kdtOtherEntry_amount_TextField.setHorizontalAlignment(2);
        kdtOtherEntry_amount_TextField.setDataType(1);
        	kdtOtherEntry_amount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtOtherEntry_amount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtOtherEntry_amount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtOtherEntry_amount_CellEditor = new KDTDefaultCellEditor(kdtOtherEntry_amount_TextField);
        this.kdtOtherEntry.getColumn("amount").setEditor(kdtOtherEntry_amount_CellEditor);
        KDTextField kdtOtherEntry_remark_TextField = new KDTextField();
        kdtOtherEntry_remark_TextField.setName("kdtOtherEntry_remark_TextField");
        kdtOtherEntry_remark_TextField.setMaxLength(200);
        KDTDefaultCellEditor kdtOtherEntry_remark_CellEditor = new KDTDefaultCellEditor(kdtOtherEntry_remark_TextField);
        this.kdtOtherEntry.getColumn("remark").setEditor(kdtOtherEntry_remark_CellEditor);
        // kdtHandEntry
		String kdtHandEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"itemName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"remark\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{itemName}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{remark}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtHandEntry.setFormatXml(resHelper.translateString("kdtHandEntry",kdtHandEntryStrXML));

                this.kdtHandEntry.putBindContents("editData",new String[] {"seq","itemName","qty","amount","remark"});


        this.kdtHandEntry.checkParsed();
        KDFormattedTextField kdtHandEntry_seq_TextField = new KDFormattedTextField();
        kdtHandEntry_seq_TextField.setName("kdtHandEntry_seq_TextField");
        kdtHandEntry_seq_TextField.setVisible(true);
        kdtHandEntry_seq_TextField.setEditable(true);
        kdtHandEntry_seq_TextField.setHorizontalAlignment(2);
        kdtHandEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtHandEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtHandEntry_seq_TextField);
        this.kdtHandEntry.getColumn("seq").setEditor(kdtHandEntry_seq_CellEditor);
        KDTextField kdtHandEntry_itemName_TextField = new KDTextField();
        kdtHandEntry_itemName_TextField.setName("kdtHandEntry_itemName_TextField");
        kdtHandEntry_itemName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtHandEntry_itemName_CellEditor = new KDTDefaultCellEditor(kdtHandEntry_itemName_TextField);
        this.kdtHandEntry.getColumn("itemName").setEditor(kdtHandEntry_itemName_CellEditor);
        KDFormattedTextField kdtHandEntry_qty_TextField = new KDFormattedTextField();
        kdtHandEntry_qty_TextField.setName("kdtHandEntry_qty_TextField");
        kdtHandEntry_qty_TextField.setVisible(true);
        kdtHandEntry_qty_TextField.setEditable(true);
        kdtHandEntry_qty_TextField.setHorizontalAlignment(2);
        kdtHandEntry_qty_TextField.setDataType(1);
        	kdtHandEntry_qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtHandEntry_qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtHandEntry_qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtHandEntry_qty_CellEditor = new KDTDefaultCellEditor(kdtHandEntry_qty_TextField);
        this.kdtHandEntry.getColumn("qty").setEditor(kdtHandEntry_qty_CellEditor);
        KDFormattedTextField kdtHandEntry_amount_TextField = new KDFormattedTextField();
        kdtHandEntry_amount_TextField.setName("kdtHandEntry_amount_TextField");
        kdtHandEntry_amount_TextField.setVisible(true);
        kdtHandEntry_amount_TextField.setEditable(true);
        kdtHandEntry_amount_TextField.setHorizontalAlignment(2);
        kdtHandEntry_amount_TextField.setDataType(1);
        	kdtHandEntry_amount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtHandEntry_amount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtHandEntry_amount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtHandEntry_amount_CellEditor = new KDTDefaultCellEditor(kdtHandEntry_amount_TextField);
        this.kdtHandEntry.getColumn("amount").setEditor(kdtHandEntry_amount_CellEditor);
        KDTextField kdtHandEntry_remark_TextField = new KDTextField();
        kdtHandEntry_remark_TextField.setName("kdtHandEntry_remark_TextField");
        kdtHandEntry_remark_TextField.setMaxLength(200);
        KDTDefaultCellEditor kdtHandEntry_remark_CellEditor = new KDTDefaultCellEditor(kdtHandEntry_remark_TextField);
        this.kdtHandEntry.getColumn("remark").setEditor(kdtHandEntry_remark_CellEditor);
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
					
        // prmtstorageOrgUnit		
        this.prmtstorageOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtstorageOrgUnit.setEditable(true);		
        this.prmtstorageOrgUnit.setDisplayFormat("$name$");		
        this.prmtstorageOrgUnit.setEditFormat("$number$");		
        this.prmtstorageOrgUnit.setCommitFormat("$number$");		
        this.prmtstorageOrgUnit.setRequired(false);
        // settleType		
        this.settleType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.processbizill.StockingSettlementTypeEnum").toArray());		
        this.settleType.setRequired(true);
        // kDPanel5		
        this.kDPanel5.setBorder(null);
        // kDPanel4
        // kDPanel8
        // kdPanelBatchDetail
        // contbreedDataAmount		
        this.contbreedDataAmount.setBoundLabelText(resHelper.getString("contbreedDataAmount.boundLabelText"));		
        this.contbreedDataAmount.setBoundLabelLength(100);		
        this.contbreedDataAmount.setBoundLabelUnderline(true);		
        this.contbreedDataAmount.setVisible(true);
        // contfodderAmount		
        this.contfodderAmount.setBoundLabelText(resHelper.getString("contfodderAmount.boundLabelText"));		
        this.contfodderAmount.setBoundLabelLength(100);		
        this.contfodderAmount.setBoundLabelUnderline(true);		
        this.contfodderAmount.setVisible(true);
        // contdrugAmount		
        this.contdrugAmount.setBoundLabelText(resHelper.getString("contdrugAmount.boundLabelText"));		
        this.contdrugAmount.setBoundLabelLength(100);		
        this.contdrugAmount.setBoundLabelUnderline(true);		
        this.contdrugAmount.setVisible(true);
        // contbirdsAmount		
        this.contbirdsAmount.setBoundLabelText(resHelper.getString("contbirdsAmount.boundLabelText"));		
        this.contbirdsAmount.setBoundLabelLength(100);		
        this.contbirdsAmount.setBoundLabelUnderline(true);		
        this.contbirdsAmount.setVisible(true);
        // contfarmerProfit		
        this.contfarmerProfit.setBoundLabelText(resHelper.getString("contfarmerProfit.boundLabelText"));		
        this.contfarmerProfit.setBoundLabelLength(100);		
        this.contfarmerProfit.setBoundLabelUnderline(true);		
        this.contfarmerProfit.setVisible(true);
        // contawardsAmount		
        this.contawardsAmount.setBoundLabelText(resHelper.getString("contawardsAmount.boundLabelText"));		
        this.contawardsAmount.setBoundLabelLength(100);		
        this.contawardsAmount.setBoundLabelUnderline(true);		
        this.contawardsAmount.setVisible(true);
        // contmarginAmount		
        this.contmarginAmount.setBoundLabelText(resHelper.getString("contmarginAmount.boundLabelText"));		
        this.contmarginAmount.setBoundLabelLength(100);		
        this.contmarginAmount.setBoundLabelUnderline(true);		
        this.contmarginAmount.setVisible(true);
        // contallEggAmount		
        this.contallEggAmount.setBoundLabelText(resHelper.getString("contallEggAmount.boundLabelText"));		
        this.contallEggAmount.setBoundLabelLength(100);		
        this.contallEggAmount.setBoundLabelUnderline(true);		
        this.contallEggAmount.setVisible(true);
        // conthandAmount		
        this.conthandAmount.setBoundLabelText(resHelper.getString("conthandAmount.boundLabelText"));		
        this.conthandAmount.setBoundLabelLength(100);		
        this.conthandAmount.setBoundLabelUnderline(true);		
        this.conthandAmount.setVisible(true);
        // contoriginalFarmerProfit		
        this.contoriginalFarmerProfit.setBoundLabelText(resHelper.getString("contoriginalFarmerProfit.boundLabelText"));		
        this.contoriginalFarmerProfit.setBoundLabelLength(100);		
        this.contoriginalFarmerProfit.setBoundLabelUnderline(true);
        // kDSeparator11
        // kDLabel1		
        this.kDLabel1.setText(resHelper.getString("kDLabel1.text"));		
        this.kDLabel1.setFont(resHelper.getFont("kDLabel1.font"));		
        this.kDLabel1.setForeground(new java.awt.Color(43,189,86));
        // kDLabel2		
        this.kDLabel2.setText(resHelper.getString("kDLabel2.text"));		
        this.kDLabel2.setFont(resHelper.getFont("kDLabel2.font"));		
        this.kDLabel2.setForeground(new java.awt.Color(255,0,0));
        // kDSeparator13
        // kDLabel3		
        this.kDLabel3.setText(resHelper.getString("kDLabel3.text"));		
        this.kDLabel3.setFont(resHelper.getFont("kDLabel3.font"));		
        this.kDLabel3.setForeground(new java.awt.Color(5,53,220));
        // contmarginInterest		
        this.contmarginInterest.setBoundLabelText(resHelper.getString("contmarginInterest.boundLabelText"));		
        this.contmarginInterest.setBoundLabelLength(100);		
        this.contmarginInterest.setBoundLabelUnderline(true);		
        this.contmarginInterest.setVisible(true);
        // contloanInterest		
        this.contloanInterest.setBoundLabelText(resHelper.getString("contloanInterest.boundLabelText"));		
        this.contloanInterest.setBoundLabelLength(100);		
        this.contloanInterest.setBoundLabelUnderline(true);		
        this.contloanInterest.setVisible(true);
        // contalimony		
        this.contalimony.setBoundLabelText(resHelper.getString("contalimony.boundLabelText"));		
        this.contalimony.setBoundLabelLength(100);		
        this.contalimony.setBoundLabelUnderline(true);		
        this.contalimony.setVisible(true);
        // contotherMaterialAmount		
        this.contotherMaterialAmount.setBoundLabelText(resHelper.getString("contotherMaterialAmount.boundLabelText"));		
        this.contotherMaterialAmount.setBoundLabelLength(100);		
        this.contotherMaterialAmount.setBoundLabelUnderline(true);		
        this.contotherMaterialAmount.setVisible(true);
        // contoccupyInterest		
        this.contoccupyInterest.setBoundLabelText(resHelper.getString("contoccupyInterest.boundLabelText"));		
        this.contoccupyInterest.setBoundLabelLength(100);		
        this.contoccupyInterest.setBoundLabelUnderline(true);		
        this.contoccupyInterest.setVisible(true);
        // txtbreedDataAmount		
        this.txtbreedDataAmount.setHorizontalAlignment(2);		
        this.txtbreedDataAmount.setDataType(1);		
        this.txtbreedDataAmount.setSupportedEmpty(true);		
        this.txtbreedDataAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbreedDataAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbreedDataAmount.setPrecision(4);		
        this.txtbreedDataAmount.setRequired(false);
        // txtfodderAmount		
        this.txtfodderAmount.setHorizontalAlignment(2);		
        this.txtfodderAmount.setDataType(1);		
        this.txtfodderAmount.setSupportedEmpty(true);		
        this.txtfodderAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfodderAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfodderAmount.setPrecision(2);		
        this.txtfodderAmount.setRequired(false);
        // txtdrugAmount		
        this.txtdrugAmount.setHorizontalAlignment(2);		
        this.txtdrugAmount.setDataType(1);		
        this.txtdrugAmount.setSupportedEmpty(true);		
        this.txtdrugAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdrugAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdrugAmount.setPrecision(2);		
        this.txtdrugAmount.setRequired(false);
        // txtbirdsAmount		
        this.txtbirdsAmount.setHorizontalAlignment(2);		
        this.txtbirdsAmount.setDataType(1);		
        this.txtbirdsAmount.setSupportedEmpty(true);		
        this.txtbirdsAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbirdsAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbirdsAmount.setPrecision(2);		
        this.txtbirdsAmount.setRequired(false);
        // txtfarmerProfit		
        this.txtfarmerProfit.setHorizontalAlignment(2);		
        this.txtfarmerProfit.setDataType(1);		
        this.txtfarmerProfit.setSupportedEmpty(true);		
        this.txtfarmerProfit.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfarmerProfit.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfarmerProfit.setPrecision(2);		
        this.txtfarmerProfit.setRequired(false);		
        this.txtfarmerProfit.setEnabled(false);
        // txtawardsAmount		
        this.txtawardsAmount.setHorizontalAlignment(2);		
        this.txtawardsAmount.setDataType(1);		
        this.txtawardsAmount.setSupportedEmpty(true);		
        this.txtawardsAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtawardsAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtawardsAmount.setPrecision(2);		
        this.txtawardsAmount.setRequired(false);
        // txtmarginAmount		
        this.txtmarginAmount.setHorizontalAlignment(2);		
        this.txtmarginAmount.setDataType(1);		
        this.txtmarginAmount.setSupportedEmpty(true);		
        this.txtmarginAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmarginAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmarginAmount.setPrecision(2);		
        this.txtmarginAmount.setRequired(false);
        // txtallEggAmount		
        this.txtallEggAmount.setHorizontalAlignment(2);		
        this.txtallEggAmount.setDataType(1);		
        this.txtallEggAmount.setSupportedEmpty(true);		
        this.txtallEggAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallEggAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallEggAmount.setPrecision(2);		
        this.txtallEggAmount.setRequired(false);
        // txthandAmount		
        this.txthandAmount.setHorizontalAlignment(2);		
        this.txthandAmount.setDataType(1);		
        this.txthandAmount.setSupportedEmpty(true);		
        this.txthandAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txthandAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txthandAmount.setPrecision(2);		
        this.txthandAmount.setRequired(false);
        // txtoriginalFarmerProfit		
        this.txtoriginalFarmerProfit.setHorizontalAlignment(2);		
        this.txtoriginalFarmerProfit.setDataType(1);		
        this.txtoriginalFarmerProfit.setSupportedEmpty(true);		
        this.txtoriginalFarmerProfit.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtoriginalFarmerProfit.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtoriginalFarmerProfit.setPrecision(10);		
        this.txtoriginalFarmerProfit.setRequired(false);
        // txtmarginInterest		
        this.txtmarginInterest.setHorizontalAlignment(2);		
        this.txtmarginInterest.setDataType(1);		
        this.txtmarginInterest.setSupportedEmpty(true);		
        this.txtmarginInterest.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmarginInterest.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmarginInterest.setPrecision(2);		
        this.txtmarginInterest.setRequired(false);
        // txtloanInterest		
        this.txtloanInterest.setHorizontalAlignment(2);		
        this.txtloanInterest.setDataType(1);		
        this.txtloanInterest.setSupportedEmpty(true);		
        this.txtloanInterest.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtloanInterest.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtloanInterest.setPrecision(2);		
        this.txtloanInterest.setRequired(false);
        // txtalimony		
        this.txtalimony.setHorizontalAlignment(2);		
        this.txtalimony.setDataType(1);		
        this.txtalimony.setSupportedEmpty(true);		
        this.txtalimony.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtalimony.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtalimony.setPrecision(2);		
        this.txtalimony.setRequired(false);
        // txtotherMaterialAmount		
        this.txtotherMaterialAmount.setHorizontalAlignment(2);		
        this.txtotherMaterialAmount.setDataType(1);		
        this.txtotherMaterialAmount.setSupportedEmpty(true);		
        this.txtotherMaterialAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtotherMaterialAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtotherMaterialAmount.setPrecision(2);		
        this.txtotherMaterialAmount.setRequired(false);
        // txtoccupyInterest		
        this.txtoccupyInterest.setVisible(true);		
        this.txtoccupyInterest.setHorizontalAlignment(2);		
        this.txtoccupyInterest.setDataType(1);		
        this.txtoccupyInterest.setSupportedEmpty(true);		
        this.txtoccupyInterest.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtoccupyInterest.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtoccupyInterest.setPrecision(2);		
        this.txtoccupyInterest.setRequired(false);
        // contallQty		
        this.contallQty.setBoundLabelText(resHelper.getString("contallQty.boundLabelText"));		
        this.contallQty.setBoundLabelLength(100);		
        this.contallQty.setBoundLabelUnderline(true);		
        this.contallQty.setVisible(true);
        // contFCR		
        this.contFCR.setBoundLabelText(resHelper.getString("contFCR.boundLabelText"));		
        this.contFCR.setBoundLabelLength(100);		
        this.contFCR.setBoundLabelUnderline(true);		
        this.contFCR.setVisible(true);
        // contsurvivalRate		
        this.contsurvivalRate.setBoundLabelText(resHelper.getString("contsurvivalRate.boundLabelText"));		
        this.contsurvivalRate.setBoundLabelLength(100);		
        this.contsurvivalRate.setBoundLabelUnderline(true);		
        this.contsurvivalRate.setVisible(true);
        // contbirdsQty		
        this.contbirdsQty.setBoundLabelText(resHelper.getString("contbirdsQty.boundLabelText"));		
        this.contbirdsQty.setBoundLabelLength(100);		
        this.contbirdsQty.setBoundLabelUnderline(true);		
        this.contbirdsQty.setVisible(true);
        // contfertilizationRate		
        this.contfertilizationRate.setBoundLabelText(resHelper.getString("contfertilizationRate.boundLabelText"));		
        this.contfertilizationRate.setBoundLabelLength(100);		
        this.contfertilizationRate.setBoundLabelUnderline(true);		
        this.contfertilizationRate.setVisible(false);
        // contlayingRate		
        this.contlayingRate.setBoundLabelText(resHelper.getString("contlayingRate.boundLabelText"));		
        this.contlayingRate.setBoundLabelLength(100);		
        this.contlayingRate.setBoundLabelUnderline(true);		
        this.contlayingRate.setVisible(true);
        // contavgWeight		
        this.contavgWeight.setBoundLabelText(resHelper.getString("contavgWeight.boundLabelText"));		
        this.contavgWeight.setBoundLabelLength(100);		
        this.contavgWeight.setBoundLabelUnderline(true);		
        this.contavgWeight.setVisible(true);
        // contallLastStock		
        this.contallLastStock.setBoundLabelText(resHelper.getString("contallLastStock.boundLabelText"));		
        this.contallLastStock.setBoundLabelLength(100);		
        this.contallLastStock.setBoundLabelUnderline(true);		
        this.contallLastStock.setVisible(true);
        // conteggQty		
        this.conteggQty.setBoundLabelText(resHelper.getString("conteggQty.boundLabelText"));		
        this.conteggQty.setBoundLabelLength(100);		
        this.conteggQty.setBoundLabelUnderline(true);		
        this.conteggQty.setVisible(true);
        // contDescription		
        this.contDescription.setBoundLabelText(resHelper.getString("contDescription.boundLabelText"));		
        this.contDescription.setBoundLabelLength(100);		
        this.contDescription.setBoundLabelUnderline(true);
        // contbatchContract		
        this.contbatchContract.setBoundLabelText(resHelper.getString("contbatchContract.boundLabelText"));		
        this.contbatchContract.setBoundLabelLength(100);		
        this.contbatchContract.setBoundLabelUnderline(true);		
        this.contbatchContract.setVisible(false);
        // contfertilizationRate2		
        this.contfertilizationRate2.setBoundLabelText(resHelper.getString("contfertilizationRate2.boundLabelText"));		
        this.contfertilizationRate2.setBoundLabelLength(100);		
        this.contfertilizationRate2.setBoundLabelUnderline(true);		
        this.contfertilizationRate2.setVisible(true);
        // txtallQty		
        this.txtallQty.setHorizontalAlignment(2);		
        this.txtallQty.setDataType(1);		
        this.txtallQty.setSupportedEmpty(true);		
        this.txtallQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallQty.setPrecision(4);		
        this.txtallQty.setRequired(false);
        // txtFCR		
        this.txtFCR.setHorizontalAlignment(2);		
        this.txtFCR.setDataType(1);		
        this.txtFCR.setSupportedEmpty(true);		
        this.txtFCR.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtFCR.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtFCR.setPrecision(4);		
        this.txtFCR.setRequired(false);
        // txtsurvivalRate		
        this.txtsurvivalRate.setHorizontalAlignment(2);		
        this.txtsurvivalRate.setDataType(1);		
        this.txtsurvivalRate.setSupportedEmpty(true);		
        this.txtsurvivalRate.setMinimumValue( new java.math.BigDecimal("-999.99"));		
        this.txtsurvivalRate.setMaximumValue( new java.math.BigDecimal("999.99"));		
        this.txtsurvivalRate.setPrecision(2);		
        this.txtsurvivalRate.setRequired(false);
        // txtbirdsQty		
        this.txtbirdsQty.setHorizontalAlignment(2);		
        this.txtbirdsQty.setDataType(1);		
        this.txtbirdsQty.setSupportedEmpty(true);		
        this.txtbirdsQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbirdsQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbirdsQty.setPrecision(4);		
        this.txtbirdsQty.setRequired(false);
        // txtfertilizationRate		
        this.txtfertilizationRate.setHorizontalAlignment(2);		
        this.txtfertilizationRate.setDataType(1);		
        this.txtfertilizationRate.setSupportedEmpty(true);		
        this.txtfertilizationRate.setMinimumValue( new java.math.BigDecimal("-999.99"));		
        this.txtfertilizationRate.setMaximumValue( new java.math.BigDecimal("999.99"));		
        this.txtfertilizationRate.setPrecision(2);		
        this.txtfertilizationRate.setRequired(false);
        // txtlayingRate		
        this.txtlayingRate.setHorizontalAlignment(2);		
        this.txtlayingRate.setDataType(1);		
        this.txtlayingRate.setSupportedEmpty(true);		
        this.txtlayingRate.setMinimumValue( new java.math.BigDecimal("-999.99"));		
        this.txtlayingRate.setMaximumValue( new java.math.BigDecimal("999.99"));		
        this.txtlayingRate.setPrecision(2);		
        this.txtlayingRate.setRequired(false);
        // txtavgWeight		
        this.txtavgWeight.setHorizontalAlignment(2);		
        this.txtavgWeight.setDataType(1);		
        this.txtavgWeight.setSupportedEmpty(true);		
        this.txtavgWeight.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtavgWeight.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtavgWeight.setPrecision(4);		
        this.txtavgWeight.setRequired(false);
        // txtallLastStock		
        this.txtallLastStock.setHorizontalAlignment(2);		
        this.txtallLastStock.setDataType(1);		
        this.txtallLastStock.setSupportedEmpty(true);		
        this.txtallLastStock.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallLastStock.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallLastStock.setPrecision(4);		
        this.txtallLastStock.setRequired(false);
        // txteggQty		
        this.txteggQty.setHorizontalAlignment(2);		
        this.txteggQty.setDataType(1);		
        this.txteggQty.setSupportedEmpty(true);		
        this.txteggQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txteggQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txteggQty.setPrecision(4);		
        this.txteggQty.setRequired(false);
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // prmtbatchContract		
        this.prmtbatchContract.setQueryInfo("com.kingdee.eas.farm.stocking.processbizill.app.BatchContractQuery");		
        this.prmtbatchContract.setEditable(true);		
        this.prmtbatchContract.setDisplayFormat("$number$");		
        this.prmtbatchContract.setEditFormat("$number$");		
        this.prmtbatchContract.setCommitFormat("$number$");		
        this.prmtbatchContract.setRequired(false);
        // txtfertilizationRate2		
        this.txtfertilizationRate2.setVisible(true);		
        this.txtfertilizationRate2.setHorizontalAlignment(2);		
        this.txtfertilizationRate2.setDataType(1);		
        this.txtfertilizationRate2.setSupportedEmpty(true);		
        this.txtfertilizationRate2.setMinimumValue( new java.math.BigDecimal("-1.0E22"));		
        this.txtfertilizationRate2.setMaximumValue( new java.math.BigDecimal("1.0E22"));		
        this.txtfertilizationRate2.setPrecision(6);		
        this.txtfertilizationRate2.setRequired(false);
        // contbreedDataCost		
        this.contbreedDataCost.setBoundLabelText(resHelper.getString("contbreedDataCost.boundLabelText"));		
        this.contbreedDataCost.setBoundLabelLength(100);		
        this.contbreedDataCost.setBoundLabelUnderline(true);		
        this.contbreedDataCost.setVisible(true);
        // contfodderCost		
        this.contfodderCost.setBoundLabelText(resHelper.getString("contfodderCost.boundLabelText"));		
        this.contfodderCost.setBoundLabelLength(100);		
        this.contfodderCost.setBoundLabelUnderline(true);		
        this.contfodderCost.setVisible(true);
        // contdrugCost		
        this.contdrugCost.setBoundLabelText(resHelper.getString("contdrugCost.boundLabelText"));		
        this.contdrugCost.setBoundLabelLength(100);		
        this.contdrugCost.setBoundLabelUnderline(true);		
        this.contdrugCost.setVisible(true);
        // contotherMaterialCost		
        this.contotherMaterialCost.setBoundLabelText(resHelper.getString("contotherMaterialCost.boundLabelText"));		
        this.contotherMaterialCost.setBoundLabelLength(100);		
        this.contotherMaterialCost.setBoundLabelUnderline(true);		
        this.contotherMaterialCost.setVisible(true);
        // contarAmountOffset		
        this.contarAmountOffset.setBoundLabelText(resHelper.getString("contarAmountOffset.boundLabelText"));		
        this.contarAmountOffset.setBoundLabelLength(100);		
        this.contarAmountOffset.setBoundLabelUnderline(true);		
        this.contarAmountOffset.setVisible(true);
        // contfaFurCardCost		
        this.contfaFurCardCost.setBoundLabelText(resHelper.getString("contfaFurCardCost.boundLabelText"));		
        this.contfaFurCardCost.setBoundLabelLength(100);		
        this.contfaFurCardCost.setBoundLabelUnderline(true);		
        this.contfaFurCardCost.setVisible(true);
        // contfeeCostAmount		
        this.contfeeCostAmount.setBoundLabelText(resHelper.getString("contfeeCostAmount.boundLabelText"));		
        this.contfeeCostAmount.setBoundLabelLength(100);		
        this.contfeeCostAmount.setBoundLabelUnderline(true);		
        this.contfeeCostAmount.setVisible(true);
        // contallActualCost		
        this.contallActualCost.setBoundLabelText(resHelper.getString("contallActualCost.boundLabelText"));		
        this.contallActualCost.setBoundLabelLength(100);		
        this.contallActualCost.setBoundLabelUnderline(true);		
        this.contallActualCost.setVisible(true);
        // contunitActualAmount		
        this.contunitActualAmount.setBoundLabelText(resHelper.getString("contunitActualAmount.boundLabelText"));		
        this.contunitActualAmount.setBoundLabelLength(100);		
        this.contunitActualAmount.setBoundLabelUnderline(true);		
        this.contunitActualAmount.setVisible(true);
        // contcoProductAmount		
        this.contcoProductAmount.setBoundLabelText(resHelper.getString("contcoProductAmount.boundLabelText"));		
        this.contcoProductAmount.setBoundLabelLength(100);		
        this.contcoProductAmount.setBoundLabelUnderline(true);		
        this.contcoProductAmount.setVisible(true);
        // contloanInterestDiff		
        this.contloanInterestDiff.setBoundLabelText(resHelper.getString("contloanInterestDiff.boundLabelText"));		
        this.contloanInterestDiff.setBoundLabelLength(100);		
        this.contloanInterestDiff.setBoundLabelUnderline(true);		
        this.contloanInterestDiff.setVisible(true);
        // contreceiveQcEggQty		
        this.contreceiveQcEggQty.setBoundLabelText(resHelper.getString("contreceiveQcEggQty.boundLabelText"));		
        this.contreceiveQcEggQty.setBoundLabelLength(100);		
        this.contreceiveQcEggQty.setBoundLabelUnderline(true);		
        this.contreceiveQcEggQty.setVisible(true);
        // kDLabel4		
        this.kDLabel4.setText(resHelper.getString("kDLabel4.text"));		
        this.kDLabel4.setForeground(new java.awt.Color(124,124,124));
        // txtbreedDataCost		
        this.txtbreedDataCost.setHorizontalAlignment(2);		
        this.txtbreedDataCost.setDataType(1);		
        this.txtbreedDataCost.setSupportedEmpty(true);		
        this.txtbreedDataCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbreedDataCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbreedDataCost.setPrecision(2);		
        this.txtbreedDataCost.setRequired(false);
        // txtfodderCost		
        this.txtfodderCost.setHorizontalAlignment(2);		
        this.txtfodderCost.setDataType(1);		
        this.txtfodderCost.setSupportedEmpty(true);		
        this.txtfodderCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfodderCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfodderCost.setPrecision(2);		
        this.txtfodderCost.setRequired(false);
        // txtdrugCost		
        this.txtdrugCost.setHorizontalAlignment(2);		
        this.txtdrugCost.setDataType(1);		
        this.txtdrugCost.setSupportedEmpty(true);		
        this.txtdrugCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdrugCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdrugCost.setPrecision(2);		
        this.txtdrugCost.setRequired(false);
        // txtotherMaterialCost		
        this.txtotherMaterialCost.setHorizontalAlignment(2);		
        this.txtotherMaterialCost.setDataType(1);		
        this.txtotherMaterialCost.setSupportedEmpty(true);		
        this.txtotherMaterialCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtotherMaterialCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtotherMaterialCost.setPrecision(2);		
        this.txtotherMaterialCost.setRequired(false);
        // txtarAmountOffset		
        this.txtarAmountOffset.setHorizontalAlignment(2);		
        this.txtarAmountOffset.setDataType(1);		
        this.txtarAmountOffset.setSupportedEmpty(true);		
        this.txtarAmountOffset.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtarAmountOffset.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtarAmountOffset.setPrecision(2);		
        this.txtarAmountOffset.setRequired(false);
        // txtfaFurCardCost		
        this.txtfaFurCardCost.setHorizontalAlignment(2);		
        this.txtfaFurCardCost.setDataType(1);		
        this.txtfaFurCardCost.setSupportedEmpty(true);		
        this.txtfaFurCardCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfaFurCardCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfaFurCardCost.setPrecision(2);		
        this.txtfaFurCardCost.setRequired(false);
        // txtfeeCostAmount		
        this.txtfeeCostAmount.setHorizontalAlignment(2);		
        this.txtfeeCostAmount.setDataType(1);		
        this.txtfeeCostAmount.setSupportedEmpty(true);		
        this.txtfeeCostAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfeeCostAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfeeCostAmount.setPrecision(2);		
        this.txtfeeCostAmount.setRequired(false);
        // txtallActualCost		
        this.txtallActualCost.setHorizontalAlignment(2);		
        this.txtallActualCost.setDataType(1);		
        this.txtallActualCost.setSupportedEmpty(true);		
        this.txtallActualCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallActualCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallActualCost.setPrecision(2);		
        this.txtallActualCost.setRequired(false);		
        this.txtallActualCost.setEnabled(false);
        // txtunitActualAmount		
        this.txtunitActualAmount.setHorizontalAlignment(2);		
        this.txtunitActualAmount.setDataType(1);		
        this.txtunitActualAmount.setSupportedEmpty(true);		
        this.txtunitActualAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtunitActualAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtunitActualAmount.setPrecision(2);		
        this.txtunitActualAmount.setRequired(false);		
        this.txtunitActualAmount.setEnabled(false);
        // txtcoProductAmount		
        this.txtcoProductAmount.setHorizontalAlignment(2);		
        this.txtcoProductAmount.setDataType(1);		
        this.txtcoProductAmount.setSupportedEmpty(true);		
        this.txtcoProductAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcoProductAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcoProductAmount.setPrecision(2);		
        this.txtcoProductAmount.setRequired(false);
        // txtloanInterestDiff		
        this.txtloanInterestDiff.setVisible(true);		
        this.txtloanInterestDiff.setHorizontalAlignment(2);		
        this.txtloanInterestDiff.setDataType(1);		
        this.txtloanInterestDiff.setSupportedEmpty(true);		
        this.txtloanInterestDiff.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtloanInterestDiff.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtloanInterestDiff.setPrecision(2);		
        this.txtloanInterestDiff.setRequired(false);
        // txtreceiveQcEggQty		
        this.txtreceiveQcEggQty.setVisible(true);		
        this.txtreceiveQcEggQty.setHorizontalAlignment(2);		
        this.txtreceiveQcEggQty.setDataType(1);		
        this.txtreceiveQcEggQty.setSupportedEmpty(true);		
        this.txtreceiveQcEggQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtreceiveQcEggQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtreceiveQcEggQty.setPrecision(4);		
        this.txtreceiveQcEggQty.setRequired(false);
        // kdtBatchDetail
		String kdtBatchDetailStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"farmer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"farm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"stockingBatch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"house\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"breedDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"matureDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"arOffsetBillID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"beginDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"endDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"isTransFA\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"offsetAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{farmer}</t:Cell><t:Cell>$Resource{farm}</t:Cell><t:Cell>$Resource{stockingBatch}</t:Cell><t:Cell>$Resource{house}</t:Cell><t:Cell>$Resource{breedDate}</t:Cell><t:Cell>$Resource{matureDate}</t:Cell><t:Cell>$Resource{arOffsetBillID}</t:Cell><t:Cell>$Resource{beginDate}</t:Cell><t:Cell>$Resource{endDate}</t:Cell><t:Cell>$Resource{isTransFA}</t:Cell><t:Cell>$Resource{offsetAmount}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtBatchDetail.setFormatXml(resHelper.translateString("kdtBatchDetail",kdtBatchDetailStrXML));

                this.kdtBatchDetail.putBindContents("editData",new String[] {"seq","farmer","farm","stockingBatch","house","breedDate","matureDate","arOffsetBillID","beginDate","endDate","isTransFA","offsetAmount"});


        this.kdtBatchDetail.checkParsed();
        KDFormattedTextField kdtBatchDetail_seq_TextField = new KDFormattedTextField();
        kdtBatchDetail_seq_TextField.setName("kdtBatchDetail_seq_TextField");
        kdtBatchDetail_seq_TextField.setVisible(true);
        kdtBatchDetail_seq_TextField.setEditable(true);
        kdtBatchDetail_seq_TextField.setHorizontalAlignment(2);
        kdtBatchDetail_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtBatchDetail_seq_CellEditor = new KDTDefaultCellEditor(kdtBatchDetail_seq_TextField);
        this.kdtBatchDetail.getColumn("seq").setEditor(kdtBatchDetail_seq_CellEditor);
        final KDBizPromptBox kdtBatchDetail_farmer_PromptBox = new KDBizPromptBox();
        kdtBatchDetail_farmer_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmersQuery");
        kdtBatchDetail_farmer_PromptBox.setVisible(true);
        kdtBatchDetail_farmer_PromptBox.setEditable(true);
        kdtBatchDetail_farmer_PromptBox.setDisplayFormat("$number$");
        kdtBatchDetail_farmer_PromptBox.setEditFormat("$number$");
        kdtBatchDetail_farmer_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtBatchDetail_farmer_CellEditor = new KDTDefaultCellEditor(kdtBatchDetail_farmer_PromptBox);
        this.kdtBatchDetail.getColumn("farmer").setEditor(kdtBatchDetail_farmer_CellEditor);
        ObjectValueRender kdtBatchDetail_farmer_OVR = new ObjectValueRender();
        kdtBatchDetail_farmer_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtBatchDetail.getColumn("farmer").setRenderer(kdtBatchDetail_farmer_OVR);
        			kdtBatchDetail_farmer_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI kdtBatchDetail_farmer_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtBatchDetail_farmer_PromptBox_F7ListUI == null) {
					try {
						kdtBatchDetail_farmer_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtBatchDetail_farmer_PromptBox_F7ListUI));
					kdtBatchDetail_farmer_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtBatchDetail_farmer_PromptBox.setSelector(kdtBatchDetail_farmer_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtBatchDetail_farm_PromptBox = new KDBizPromptBox();
        kdtBatchDetail_farm_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmQuery");
        kdtBatchDetail_farm_PromptBox.setVisible(true);
        kdtBatchDetail_farm_PromptBox.setEditable(true);
        kdtBatchDetail_farm_PromptBox.setDisplayFormat("$number$");
        kdtBatchDetail_farm_PromptBox.setEditFormat("$number$");
        kdtBatchDetail_farm_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtBatchDetail_farm_CellEditor = new KDTDefaultCellEditor(kdtBatchDetail_farm_PromptBox);
        this.kdtBatchDetail.getColumn("farm").setEditor(kdtBatchDetail_farm_CellEditor);
        ObjectValueRender kdtBatchDetail_farm_OVR = new ObjectValueRender();
        kdtBatchDetail_farm_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtBatchDetail.getColumn("farm").setRenderer(kdtBatchDetail_farm_OVR);
        			kdtBatchDetail_farm_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmListUI kdtBatchDetail_farm_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtBatchDetail_farm_PromptBox_F7ListUI == null) {
					try {
						kdtBatchDetail_farm_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtBatchDetail_farm_PromptBox_F7ListUI));
					kdtBatchDetail_farm_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtBatchDetail_farm_PromptBox.setSelector(kdtBatchDetail_farm_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtBatchDetail_stockingBatch_PromptBox = new KDBizPromptBox();
        kdtBatchDetail_stockingBatch_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.StockingBatchQuery");
        kdtBatchDetail_stockingBatch_PromptBox.setVisible(true);
        kdtBatchDetail_stockingBatch_PromptBox.setEditable(true);
        kdtBatchDetail_stockingBatch_PromptBox.setDisplayFormat("$number$");
        kdtBatchDetail_stockingBatch_PromptBox.setEditFormat("$number$");
        kdtBatchDetail_stockingBatch_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtBatchDetail_stockingBatch_CellEditor = new KDTDefaultCellEditor(kdtBatchDetail_stockingBatch_PromptBox);
        this.kdtBatchDetail.getColumn("stockingBatch").setEditor(kdtBatchDetail_stockingBatch_CellEditor);
        ObjectValueRender kdtBatchDetail_stockingBatch_OVR = new ObjectValueRender();
        kdtBatchDetail_stockingBatch_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtBatchDetail.getColumn("stockingBatch").setRenderer(kdtBatchDetail_stockingBatch_OVR);
        			kdtBatchDetail_stockingBatch_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI kdtBatchDetail_stockingBatch_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtBatchDetail_stockingBatch_PromptBox_F7ListUI == null) {
					try {
						kdtBatchDetail_stockingBatch_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtBatchDetail_stockingBatch_PromptBox_F7ListUI));
					kdtBatchDetail_stockingBatch_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtBatchDetail_stockingBatch_PromptBox.setSelector(kdtBatchDetail_stockingBatch_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtBatchDetail_house_PromptBox = new KDBizPromptBox();
        kdtBatchDetail_house_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
        kdtBatchDetail_house_PromptBox.setVisible(true);
        kdtBatchDetail_house_PromptBox.setEditable(true);
        kdtBatchDetail_house_PromptBox.setDisplayFormat("$number$");
        kdtBatchDetail_house_PromptBox.setEditFormat("$number$");
        kdtBatchDetail_house_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtBatchDetail_house_CellEditor = new KDTDefaultCellEditor(kdtBatchDetail_house_PromptBox);
        this.kdtBatchDetail.getColumn("house").setEditor(kdtBatchDetail_house_CellEditor);
        ObjectValueRender kdtBatchDetail_house_OVR = new ObjectValueRender();
        kdtBatchDetail_house_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtBatchDetail.getColumn("house").setRenderer(kdtBatchDetail_house_OVR);
        KDDatePicker kdtBatchDetail_breedDate_DatePicker = new KDDatePicker();
        kdtBatchDetail_breedDate_DatePicker.setName("kdtBatchDetail_breedDate_DatePicker");
        kdtBatchDetail_breedDate_DatePicker.setVisible(true);
        kdtBatchDetail_breedDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtBatchDetail_breedDate_CellEditor = new KDTDefaultCellEditor(kdtBatchDetail_breedDate_DatePicker);
        this.kdtBatchDetail.getColumn("breedDate").setEditor(kdtBatchDetail_breedDate_CellEditor);
        KDDatePicker kdtBatchDetail_matureDate_DatePicker = new KDDatePicker();
        kdtBatchDetail_matureDate_DatePicker.setName("kdtBatchDetail_matureDate_DatePicker");
        kdtBatchDetail_matureDate_DatePicker.setVisible(true);
        kdtBatchDetail_matureDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtBatchDetail_matureDate_CellEditor = new KDTDefaultCellEditor(kdtBatchDetail_matureDate_DatePicker);
        this.kdtBatchDetail.getColumn("matureDate").setEditor(kdtBatchDetail_matureDate_CellEditor);
        KDTextField kdtBatchDetail_arOffsetBillID_TextField = new KDTextField();
        kdtBatchDetail_arOffsetBillID_TextField.setName("kdtBatchDetail_arOffsetBillID_TextField");
        kdtBatchDetail_arOffsetBillID_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtBatchDetail_arOffsetBillID_CellEditor = new KDTDefaultCellEditor(kdtBatchDetail_arOffsetBillID_TextField);
        this.kdtBatchDetail.getColumn("arOffsetBillID").setEditor(kdtBatchDetail_arOffsetBillID_CellEditor);
        KDDatePicker kdtBatchDetail_beginDate_DatePicker = new KDDatePicker();
        kdtBatchDetail_beginDate_DatePicker.setName("kdtBatchDetail_beginDate_DatePicker");
        kdtBatchDetail_beginDate_DatePicker.setVisible(true);
        kdtBatchDetail_beginDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtBatchDetail_beginDate_CellEditor = new KDTDefaultCellEditor(kdtBatchDetail_beginDate_DatePicker);
        this.kdtBatchDetail.getColumn("beginDate").setEditor(kdtBatchDetail_beginDate_CellEditor);
        KDDatePicker kdtBatchDetail_endDate_DatePicker = new KDDatePicker();
        kdtBatchDetail_endDate_DatePicker.setName("kdtBatchDetail_endDate_DatePicker");
        kdtBatchDetail_endDate_DatePicker.setVisible(true);
        kdtBatchDetail_endDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtBatchDetail_endDate_CellEditor = new KDTDefaultCellEditor(kdtBatchDetail_endDate_DatePicker);
        this.kdtBatchDetail.getColumn("endDate").setEditor(kdtBatchDetail_endDate_CellEditor);
        KDCheckBox kdtBatchDetail_isTransFA_CheckBox = new KDCheckBox();
        kdtBatchDetail_isTransFA_CheckBox.setName("kdtBatchDetail_isTransFA_CheckBox");
        KDTDefaultCellEditor kdtBatchDetail_isTransFA_CellEditor = new KDTDefaultCellEditor(kdtBatchDetail_isTransFA_CheckBox);
        this.kdtBatchDetail.getColumn("isTransFA").setEditor(kdtBatchDetail_isTransFA_CellEditor);
        KDFormattedTextField kdtBatchDetail_offsetAmount_TextField = new KDFormattedTextField();
        kdtBatchDetail_offsetAmount_TextField.setName("kdtBatchDetail_offsetAmount_TextField");
        kdtBatchDetail_offsetAmount_TextField.setVisible(true);
        kdtBatchDetail_offsetAmount_TextField.setEditable(true);
        kdtBatchDetail_offsetAmount_TextField.setHorizontalAlignment(2);
        kdtBatchDetail_offsetAmount_TextField.setDataType(1);
        	kdtBatchDetail_offsetAmount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtBatchDetail_offsetAmount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtBatchDetail_offsetAmount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtBatchDetail_offsetAmount_CellEditor = new KDTDefaultCellEditor(kdtBatchDetail_offsetAmount_TextField);
        this.kdtBatchDetail.getColumn("offsetAmount").setEditor(kdtBatchDetail_offsetAmount_CellEditor);
        // prmtperiod		
        this.prmtperiod.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7PeriodQuery");		
        this.prmtperiod.setEditable(true);		
        this.prmtperiod.setDisplayFormat("$number$");		
        this.prmtperiod.setEditFormat("$number$");		
        this.prmtperiod.setCommitFormat("$number$");		
        this.prmtperiod.setRequired(true);
        // pkbeginDate		
        this.pkbeginDate.setRequired(false);		
        this.pkbeginDate.setEnabled(false);
        // pkendDate		
        this.pkendDate.setRequired(false);		
        this.pkendDate.setEnabled(false);
        // breedStage		
        this.breedStage.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.FarmStageEnum").toArray());		
        this.breedStage.setRequired(true);
        // prmtfarmersTree		
        this.prmtfarmersTree.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtfarmersTree.setVisible(true);		
        this.prmtfarmersTree.setEditable(true);		
        this.prmtfarmersTree.setDisplayFormat("$name$");		
        this.prmtfarmersTree.setEditFormat("$number$");		
        this.prmtfarmersTree.setCommitFormat("$number$");		
        this.prmtfarmersTree.setRequired(false);
        // tBtnAudit
        this.tBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnAudit.setText(resHelper.getString("tBtnAudit.text"));
        // tBtnUnAudit
        this.tBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnUnAudit.setText(resHelper.getString("tBtnUnAudit.text"));
        // tBtnExeCal
        this.tBtnExeCal.setAction((IItemAction)ActionProxyFactory.getProxy(actionBtnExeCal, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnExeCal.setText(resHelper.getString("tBtnExeCal.text"));
        // btnBreateBill
        this.btnBreateBill.setAction((IItemAction)ActionProxyFactory.getProxy(actionBreateBill, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnBreateBill.setText(resHelper.getString("btnBreateBill.text"));
        // mBtnAudit
        this.mBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnAudit.setText(resHelper.getString("mBtnAudit.text"));
        // mBtnUnAudit
        this.mBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnUnAudit.setText(resHelper.getString("mBtnUnAudit.text"));
        // newSeparator3
        // mBtnExeCal
        this.mBtnExeCal.setAction((IItemAction)ActionProxyFactory.getProxy(actionBtnExeCal, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnExeCal.setText(resHelper.getString("mBtnExeCal.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtfertilizationRate,txtlayingRate,txtoriginalFarmerProfit,txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,billStatus,prmtcompany,pkauditTime,prmtfarmer,prmtstockingBatch,prmtfarm,txtFCR,txtsurvivalRate,txtallQty,txtbreedDataAmount,txtfodderAmount,txtdrugAmount,txtavgWeight,txteggQty,txtbirdsAmount,txtbirdsQty,txtfarmerProfit,txtawardsAmount,prmtstorageOrgUnit,txtmarginAmount,pkbeginDate,pkendDate,prmtbatchContract,txtallLastStock,txtallEggAmount,txthandAmount,txtmarginInterest,txtloanInterest,txtalimony,settleType,prmtperiod,txtbreedDataCost,txtfodderCost,txtdrugCost,txtotherMaterialCost,txtarAmountOffset,txtfaFurCardCost,breedStage,txtfeeCostAmount,txtallActualCost,txtotherMaterialAmount,txtunitActualAmount,txtcoProductAmount,kdtEntrys,kdtOtherEntry,kdtEggEntry,kdtRewardsEntry,kdtHandEntry,kdtBatchDetail,txtoccupyInterest,txtloanInterestDiff,txtreceiveQcEggQty,txtfertilizationRate2,prmtfarmersTree}));
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
        this.setBounds(new Rectangle(0, 0, 1012, 629));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1012, 629));
        contCreator.setBounds(new Rectangle(379, 566, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(379, 566, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(730, 566, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(730, 566, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(379, 591, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(379, 591, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(730, 591, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(730, 591, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(20, 9, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(20, 9, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(371, 9, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(371, 9, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(29, 566, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(29, 566, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(847, 9, 133, 19));
        this.add(contbillStatus, new KDLayout.Constraints(847, 9, 133, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompany.setBounds(new Rectangle(20, 59, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(20, 59, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(29, 591, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(29, 591, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator8.setBounds(new Rectangle(18, 562, 980, 8));
        this.add(kDSeparator8, new KDLayout.Constraints(18, 562, 980, 8, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator9.setBounds(new Rectangle(6, 132, 986, 8));
        this.add(kDSeparator9, new KDLayout.Constraints(6, 132, 986, 8, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contfarmer.setBounds(new Rectangle(20, 33, 270, 19));
        this.add(contfarmer, new KDLayout.Constraints(20, 33, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contstockingBatch.setBounds(new Rectangle(710, 33, 270, 19));
        this.add(contstockingBatch, new KDLayout.Constraints(710, 33, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDTabbedPane1.setBounds(new Rectangle(21, 351, 965, 205));
        this.add(kDTabbedPane1, new KDLayout.Constraints(21, 351, 965, 205, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contfarm.setBounds(new Rectangle(371, 33, 270, 19));
        this.add(contfarm, new KDLayout.Constraints(371, 33, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contstorageOrgUnit.setBounds(new Rectangle(20, 109, 270, 19));
        this.add(contstorageOrgUnit, new KDLayout.Constraints(20, 109, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsettleType.setBounds(new Rectangle(710, 9, 134, 19));
        this.add(contsettleType, new KDLayout.Constraints(710, 9, 134, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane2.setBounds(new Rectangle(21, 142, 969, 201));
        this.add(kDTabbedPane2, new KDLayout.Constraints(21, 142, 969, 201, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contperiod.setBounds(new Rectangle(371, 59, 270, 19));
        this.add(contperiod, new KDLayout.Constraints(371, 59, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbeginDate.setBounds(new Rectangle(371, 83, 270, 19));
        this.add(contbeginDate, new KDLayout.Constraints(371, 83, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contendDate.setBounds(new Rectangle(710, 83, 270, 19));
        this.add(contendDate, new KDLayout.Constraints(710, 83, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbreedStage.setBounds(new Rectangle(710, 59, 270, 19));
        this.add(contbreedStage, new KDLayout.Constraints(710, 59, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfarmersTree.setBounds(new Rectangle(20, 83, 270, 19));
        this.add(contfarmersTree, new KDLayout.Constraints(20, 83, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contfarmer
        contfarmer.setBoundEditor(prmtfarmer);
        //contstockingBatch
        contstockingBatch.setBoundEditor(prmtstockingBatch);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel6, resHelper.getString("kDPanel6.constraints"));
        kDTabbedPane1.add(kDPanel7, resHelper.getString("kDPanel7.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 964, 172));        kdtEntrys.setBounds(new Rectangle(2, 3, 956, 175));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.stocking.processbizill.StatementsBillEntryInfo(),null,false);
        kDPanel1.add(kdtEntrys_detailPanel, new KDLayout.Constraints(2, 3, 956, 175, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel6
        kDPanel6.setLayout(new KDLayout());
        kDPanel6.putClientProperty("OriginalBounds", new Rectangle(0, 0, 964, 172));        kdtEggEntry.setBounds(new Rectangle(2, 3, 954, 176));
        kdtEggEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEggEntry,new com.kingdee.eas.farm.stocking.processbizill.StatementsBillEggEntryInfo(),null,false);
        kDPanel6.add(kdtEggEntry_detailPanel, new KDLayout.Constraints(2, 3, 954, 176, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel7
        kDPanel7.setLayout(new KDLayout());
        kDPanel7.putClientProperty("OriginalBounds", new Rectangle(0, 0, 964, 172));        kdtRewardsEntry.setBounds(new Rectangle(3, 2, 955, 179));
        kdtRewardsEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtRewardsEntry,new com.kingdee.eas.farm.stocking.processbizill.StatementsBillRewardsEntryInfo(),null,false);
        kDPanel7.add(kdtRewardsEntry_detailPanel, new KDLayout.Constraints(3, 2, 955, 179, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 964, 172));        kdtOtherEntry.setBounds(new Rectangle(2, 0, 959, 183));
        kdtOtherEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtOtherEntry,new com.kingdee.eas.farm.stocking.processbizill.StatementsBillOtherEntryInfo(),null,false);
        kDPanel2.add(kdtOtherEntry_detailPanel, new KDLayout.Constraints(2, 0, 959, 183, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel3
        kDPanel3.setLayout(new KDLayout());
        kDPanel3.putClientProperty("OriginalBounds", new Rectangle(0, 0, 964, 172));        kdtHandEntry.setBounds(new Rectangle(2, 1, 957, 169));
        kdtHandEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtHandEntry,new com.kingdee.eas.farm.stocking.processbizill.StatementsBillHandEntryInfo(),null,false);
        kDPanel3.add(kdtHandEntry_detailPanel, new KDLayout.Constraints(2, 1, 957, 169, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contfarm
        contfarm.setBoundEditor(prmtfarm);
        //contstorageOrgUnit
        contstorageOrgUnit.setBoundEditor(prmtstorageOrgUnit);
        //contsettleType
        contsettleType.setBoundEditor(settleType);
        //kDTabbedPane2
        kDTabbedPane2.add(kDPanel5, resHelper.getString("kDPanel5.constraints"));
        kDTabbedPane2.add(kDPanel4, resHelper.getString("kDPanel4.constraints"));
        kDTabbedPane2.add(kDPanel8, resHelper.getString("kDPanel8.constraints"));
        kDTabbedPane2.add(kdPanelBatchDetail, resHelper.getString("kdPanelBatchDetail.constraints"));
        //kDPanel5
        kDPanel5.setLayout(new KDLayout());
        kDPanel5.putClientProperty("OriginalBounds", new Rectangle(0, 0, 968, 168));        contbreedDataAmount.setBounds(new Rectangle(60, 18, 270, 19));
        kDPanel5.add(contbreedDataAmount, new KDLayout.Constraints(60, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfodderAmount.setBounds(new Rectangle(373, 18, 270, 19));
        kDPanel5.add(contfodderAmount, new KDLayout.Constraints(373, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdrugAmount.setBounds(new Rectangle(686, 18, 270, 19));
        kDPanel5.add(contdrugAmount, new KDLayout.Constraints(686, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbirdsAmount.setBounds(new Rectangle(373, 80, 270, 19));
        kDPanel5.add(contbirdsAmount, new KDLayout.Constraints(373, 80, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmerProfit.setBounds(new Rectangle(686, 137, 270, 19));
        kDPanel5.add(contfarmerProfit, new KDLayout.Constraints(686, 137, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contawardsAmount.setBounds(new Rectangle(686, 80, 270, 19));
        kDPanel5.add(contawardsAmount, new KDLayout.Constraints(686, 80, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contmarginAmount.setBounds(new Rectangle(60, 103, 270, 19));
        kDPanel5.add(contmarginAmount, new KDLayout.Constraints(60, 103, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contallEggAmount.setBounds(new Rectangle(60, 82, 270, 19));
        kDPanel5.add(contallEggAmount, new KDLayout.Constraints(60, 82, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conthandAmount.setBounds(new Rectangle(373, 137, 270, 19));
        kDPanel5.add(conthandAmount, new KDLayout.Constraints(373, 137, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoriginalFarmerProfit.setBounds(new Rectangle(60, 137, 270, 19));
        kDPanel5.add(contoriginalFarmerProfit, new KDLayout.Constraints(60, 137, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator11.setBounds(new Rectangle(31, 69, 923, 8));
        kDPanel5.add(kDSeparator11, new KDLayout.Constraints(31, 69, 923, 8, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabel1.setBounds(new Rectangle(15, 11, 35, 51));
        kDPanel5.add(kDLabel1, new KDLayout.Constraints(15, 11, 35, 51, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabel2.setBounds(new Rectangle(15, 79, 35, 48));
        kDPanel5.add(kDLabel2, new KDLayout.Constraints(15, 79, 35, 48, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator13.setBounds(new Rectangle(31, 130, 924, 8));
        kDPanel5.add(kDSeparator13, new KDLayout.Constraints(31, 130, 924, 8, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabel3.setBounds(new Rectangle(15, 138, 42, 19));
        kDPanel5.add(kDLabel3, new KDLayout.Constraints(15, 138, 42, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmarginInterest.setBounds(new Rectangle(373, 102, 270, 19));
        kDPanel5.add(contmarginInterest, new KDLayout.Constraints(373, 102, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contloanInterest.setBounds(new Rectangle(373, 40, 270, 19));
        kDPanel5.add(contloanInterest, new KDLayout.Constraints(373, 40, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contalimony.setBounds(new Rectangle(686, 40, 270, 19));
        kDPanel5.add(contalimony, new KDLayout.Constraints(686, 40, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contotherMaterialAmount.setBounds(new Rectangle(60, 40, 270, 19));
        kDPanel5.add(contotherMaterialAmount, new KDLayout.Constraints(60, 40, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoccupyInterest.setBounds(new Rectangle(686, 102, 270, 19));
        kDPanel5.add(contoccupyInterest, new KDLayout.Constraints(686, 102, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contbreedDataAmount
        contbreedDataAmount.setBoundEditor(txtbreedDataAmount);
        //contfodderAmount
        contfodderAmount.setBoundEditor(txtfodderAmount);
        //contdrugAmount
        contdrugAmount.setBoundEditor(txtdrugAmount);
        //contbirdsAmount
        contbirdsAmount.setBoundEditor(txtbirdsAmount);
        //contfarmerProfit
        contfarmerProfit.setBoundEditor(txtfarmerProfit);
        //contawardsAmount
        contawardsAmount.setBoundEditor(txtawardsAmount);
        //contmarginAmount
        contmarginAmount.setBoundEditor(txtmarginAmount);
        //contallEggAmount
        contallEggAmount.setBoundEditor(txtallEggAmount);
        //conthandAmount
        conthandAmount.setBoundEditor(txthandAmount);
        //contoriginalFarmerProfit
        contoriginalFarmerProfit.setBoundEditor(txtoriginalFarmerProfit);
        //contmarginInterest
        contmarginInterest.setBoundEditor(txtmarginInterest);
        //contloanInterest
        contloanInterest.setBoundEditor(txtloanInterest);
        //contalimony
        contalimony.setBoundEditor(txtalimony);
        //contotherMaterialAmount
        contotherMaterialAmount.setBoundEditor(txtotherMaterialAmount);
        //contoccupyInterest
        contoccupyInterest.setBoundEditor(txtoccupyInterest);
        //kDPanel4
        kDPanel4.setLayout(new KDLayout());
        kDPanel4.putClientProperty("OriginalBounds", new Rectangle(0, 0, 968, 168));        contallQty.setBounds(new Rectangle(14, 9, 270, 19));
        kDPanel4.add(contallQty, new KDLayout.Constraints(14, 9, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contFCR.setBounds(new Rectangle(343, 9, 270, 19));
        kDPanel4.add(contFCR, new KDLayout.Constraints(343, 9, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsurvivalRate.setBounds(new Rectangle(665, 9, 270, 19));
        kDPanel4.add(contsurvivalRate, new KDLayout.Constraints(665, 9, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbirdsQty.setBounds(new Rectangle(665, 35, 270, 19));
        kDPanel4.add(contbirdsQty, new KDLayout.Constraints(665, 35, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfertilizationRate.setBounds(new Rectangle(667, 92, 270, 19));
        kDPanel4.add(contfertilizationRate, new KDLayout.Constraints(667, 92, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contlayingRate.setBounds(new Rectangle(343, 59, 270, 19));
        kDPanel4.add(contlayingRate, new KDLayout.Constraints(343, 59, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contavgWeight.setBounds(new Rectangle(343, 35, 270, 19));
        kDPanel4.add(contavgWeight, new KDLayout.Constraints(343, 35, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contallLastStock.setBounds(new Rectangle(14, 35, 270, 19));
        kDPanel4.add(contallLastStock, new KDLayout.Constraints(14, 35, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conteggQty.setBounds(new Rectangle(14, 59, 270, 19));
        kDPanel4.add(conteggQty, new KDLayout.Constraints(14, 59, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(14, 86, 270, 19));
        kDPanel4.add(contDescription, new KDLayout.Constraints(14, 86, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbatchContract.setBounds(new Rectangle(741, 131, 270, 19));
        kDPanel4.add(contbatchContract, new KDLayout.Constraints(741, 131, 270, 19, 0));
        contfertilizationRate2.setBounds(new Rectangle(665, 59, 270, 19));
        kDPanel4.add(contfertilizationRate2, new KDLayout.Constraints(665, 59, 270, 19, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contallQty
        contallQty.setBoundEditor(txtallQty);
        //contFCR
        contFCR.setBoundEditor(txtFCR);
        //contsurvivalRate
        contsurvivalRate.setBoundEditor(txtsurvivalRate);
        //contbirdsQty
        contbirdsQty.setBoundEditor(txtbirdsQty);
        //contfertilizationRate
        contfertilizationRate.setBoundEditor(txtfertilizationRate);
        //contlayingRate
        contlayingRate.setBoundEditor(txtlayingRate);
        //contavgWeight
        contavgWeight.setBoundEditor(txtavgWeight);
        //contallLastStock
        contallLastStock.setBoundEditor(txtallLastStock);
        //conteggQty
        conteggQty.setBoundEditor(txteggQty);
        //contDescription
        contDescription.setBoundEditor(txtDescription);
        //contbatchContract
        contbatchContract.setBoundEditor(prmtbatchContract);
        //contfertilizationRate2
        contfertilizationRate2.setBoundEditor(txtfertilizationRate2);
        //kDPanel8
        kDPanel8.setLayout(new KDLayout());
        kDPanel8.putClientProperty("OriginalBounds", new Rectangle(0, 0, 968, 168));        contbreedDataCost.setBounds(new Rectangle(25, 18, 270, 19));
        kDPanel8.add(contbreedDataCost, new KDLayout.Constraints(25, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfodderCost.setBounds(new Rectangle(350, 18, 270, 19));
        kDPanel8.add(contfodderCost, new KDLayout.Constraints(350, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdrugCost.setBounds(new Rectangle(676, 18, 270, 19));
        kDPanel8.add(contdrugCost, new KDLayout.Constraints(676, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contotherMaterialCost.setBounds(new Rectangle(25, 44, 270, 19));
        kDPanel8.add(contotherMaterialCost, new KDLayout.Constraints(25, 44, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contarAmountOffset.setBounds(new Rectangle(25, 70, 270, 19));
        kDPanel8.add(contarAmountOffset, new KDLayout.Constraints(25, 70, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfaFurCardCost.setBounds(new Rectangle(676, 44, 270, 19));
        kDPanel8.add(contfaFurCardCost, new KDLayout.Constraints(676, 44, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfeeCostAmount.setBounds(new Rectangle(350, 44, 270, 19));
        kDPanel8.add(contfeeCostAmount, new KDLayout.Constraints(350, 44, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contallActualCost.setBounds(new Rectangle(25, 96, 270, 19));
        kDPanel8.add(contallActualCost, new KDLayout.Constraints(25, 96, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contunitActualAmount.setBounds(new Rectangle(25, 125, 270, 19));
        kDPanel8.add(contunitActualAmount, new KDLayout.Constraints(25, 125, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcoProductAmount.setBounds(new Rectangle(676, 96, 270, 19));
        kDPanel8.add(contcoProductAmount, new KDLayout.Constraints(676, 96, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contloanInterestDiff.setBounds(new Rectangle(350, 70, 270, 19));
        kDPanel8.add(contloanInterestDiff, new KDLayout.Constraints(350, 70, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contreceiveQcEggQty.setBounds(new Rectangle(350, 96, 270, 19));
        kDPanel8.add(contreceiveQcEggQty, new KDLayout.Constraints(350, 96, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabel4.setBounds(new Rectangle(25, 152, 816, 19));
        kDPanel8.add(kDLabel4, new KDLayout.Constraints(25, 152, 816, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contbreedDataCost
        contbreedDataCost.setBoundEditor(txtbreedDataCost);
        //contfodderCost
        contfodderCost.setBoundEditor(txtfodderCost);
        //contdrugCost
        contdrugCost.setBoundEditor(txtdrugCost);
        //contotherMaterialCost
        contotherMaterialCost.setBoundEditor(txtotherMaterialCost);
        //contarAmountOffset
        contarAmountOffset.setBoundEditor(txtarAmountOffset);
        //contfaFurCardCost
        contfaFurCardCost.setBoundEditor(txtfaFurCardCost);
        //contfeeCostAmount
        contfeeCostAmount.setBoundEditor(txtfeeCostAmount);
        //contallActualCost
        contallActualCost.setBoundEditor(txtallActualCost);
        //contunitActualAmount
        contunitActualAmount.setBoundEditor(txtunitActualAmount);
        //contcoProductAmount
        contcoProductAmount.setBoundEditor(txtcoProductAmount);
        //contloanInterestDiff
        contloanInterestDiff.setBoundEditor(txtloanInterestDiff);
        //contreceiveQcEggQty
        contreceiveQcEggQty.setBoundEditor(txtreceiveQcEggQty);
        //kdPanelBatchDetail
        kdPanelBatchDetail.setLayout(new KDLayout());
        kdPanelBatchDetail.putClientProperty("OriginalBounds", new Rectangle(0, 0, 968, 168));        kdtBatchDetail.setBounds(new Rectangle(2, 1, 959, 179));
        kdtBatchDetail_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtBatchDetail,new com.kingdee.eas.farm.stocking.processbizill.StatementsBillBatchDetailInfo(),null,false);
        kdPanelBatchDetail.add(kdtBatchDetail_detailPanel, new KDLayout.Constraints(2, 1, 959, 179, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contperiod
        contperiod.setBoundEditor(prmtperiod);
        //contbeginDate
        contbeginDate.setBoundEditor(pkbeginDate);
        //contendDate
        contendDate.setBoundEditor(pkendDate);
        //contbreedStage
        contbreedStage.setBoundEditor(breedStage);
        //contfarmersTree
        contfarmersTree.setBoundEditor(prmtfarmersTree);

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
        menuBiz.add(MenuItemVoucher);
        menuBiz.add(menuItemDelVoucher);
        menuBiz.add(mBtnExeCal);
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
        this.toolBar.add(tBtnExeCal);
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
        this.toolBar.add(btnBreateBill);


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
		dataBinder.registerBinding("billStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("farmer", com.kingdee.eas.farm.stocking.basedata.FarmersInfo.class, this.prmtfarmer, "data");
		dataBinder.registerBinding("stockingBatch", com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo.class, this.prmtstockingBatch, "data");
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.stocking.processbizill.StatementsBillEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.material", java.lang.Object.class, this.kdtEntrys, "material.text");
		dataBinder.registerBinding("entrys.materialName", String.class, this.kdtEntrys, "materialName.text");
		dataBinder.registerBinding("entrys.model", String.class, this.kdtEntrys, "model.text");
		dataBinder.registerBinding("entrys.unit", java.lang.Object.class, this.kdtEntrys, "unit.text");
		dataBinder.registerBinding("entrys.qty", java.math.BigDecimal.class, this.kdtEntrys, "qty.text");
		dataBinder.registerBinding("entrys.price", java.math.BigDecimal.class, this.kdtEntrys, "price.text");
		dataBinder.registerBinding("entrys.amount", java.math.BigDecimal.class, this.kdtEntrys, "amount.text");
		dataBinder.registerBinding("entrys.settlementItem", java.lang.Object.class, this.kdtEntrys, "settlementItem.text");
		dataBinder.registerBinding("entrys.ItemName", String.class, this.kdtEntrys, "ItemName.text");
		dataBinder.registerBinding("entrys.remark", String.class, this.kdtEntrys, "remark.text");
		dataBinder.registerBinding("entrys.actualCost", java.math.BigDecimal.class, this.kdtEntrys, "actualCost.text");
		dataBinder.registerBinding("entrys.unitActualCost", java.math.BigDecimal.class, this.kdtEntrys, "unitActualCost.text");
		dataBinder.registerBinding("EggEntry.seq", int.class, this.kdtEggEntry, "seq.text");
		dataBinder.registerBinding("EggEntry", com.kingdee.eas.farm.stocking.processbizill.StatementsBillEggEntryInfo.class, this.kdtEggEntry, "userObject");
		dataBinder.registerBinding("EggEntry.material", java.lang.Object.class, this.kdtEggEntry, "material.text");
		dataBinder.registerBinding("EggEntry.materialName", String.class, this.kdtEggEntry, "materialName.text");
		dataBinder.registerBinding("EggEntry.model", String.class, this.kdtEggEntry, "model.text");
		dataBinder.registerBinding("EggEntry.unit", java.lang.Object.class, this.kdtEggEntry, "unit.text");
		dataBinder.registerBinding("EggEntry.qty", java.math.BigDecimal.class, this.kdtEggEntry, "qty.text");
		dataBinder.registerBinding("EggEntry.price", java.math.BigDecimal.class, this.kdtEggEntry, "price.text");
		dataBinder.registerBinding("EggEntry.amount", java.math.BigDecimal.class, this.kdtEggEntry, "amount.text");
		dataBinder.registerBinding("EggEntry.settlementItem", java.lang.Object.class, this.kdtEggEntry, "settlementItem.text");
		dataBinder.registerBinding("EggEntry.weight", java.math.BigDecimal.class, this.kdtEggEntry, "weight.text");
		dataBinder.registerBinding("EggEntry.itemName", String.class, this.kdtEggEntry, "itemName.text");
		dataBinder.registerBinding("EggEntry.remark", String.class, this.kdtEggEntry, "remark.text");
		dataBinder.registerBinding("EggEntry.number", java.math.BigDecimal.class, this.kdtEggEntry, "number.text");
		dataBinder.registerBinding("RewardsEntry.seq", int.class, this.kdtRewardsEntry, "seq.text");
		dataBinder.registerBinding("RewardsEntry", com.kingdee.eas.farm.stocking.processbizill.StatementsBillRewardsEntryInfo.class, this.kdtRewardsEntry, "userObject");
		dataBinder.registerBinding("RewardsEntry.itemName", String.class, this.kdtRewardsEntry, "itemName.text");
		dataBinder.registerBinding("RewardsEntry.amount", java.math.BigDecimal.class, this.kdtRewardsEntry, "amount.text");
		dataBinder.registerBinding("RewardsEntry.itemID", String.class, this.kdtRewardsEntry, "itemID.text");
		dataBinder.registerBinding("RewardsEntry.remark", String.class, this.kdtRewardsEntry, "remark.text");
		dataBinder.registerBinding("OtherEntry.seq", int.class, this.kdtOtherEntry, "seq.text");
		dataBinder.registerBinding("OtherEntry", com.kingdee.eas.farm.stocking.processbizill.StatementsBillOtherEntryInfo.class, this.kdtOtherEntry, "userObject");
		dataBinder.registerBinding("OtherEntry.itemName", String.class, this.kdtOtherEntry, "itemName.text");
		dataBinder.registerBinding("OtherEntry.amount", java.math.BigDecimal.class, this.kdtOtherEntry, "amount.text");
		dataBinder.registerBinding("OtherEntry.qty", java.math.BigDecimal.class, this.kdtOtherEntry, "qty.text");
		dataBinder.registerBinding("OtherEntry.remark", String.class, this.kdtOtherEntry, "remark.text");
		dataBinder.registerBinding("HandEntry.seq", int.class, this.kdtHandEntry, "seq.text");
		dataBinder.registerBinding("HandEntry", com.kingdee.eas.farm.stocking.processbizill.StatementsBillHandEntryInfo.class, this.kdtHandEntry, "userObject");
		dataBinder.registerBinding("HandEntry.itemName", String.class, this.kdtHandEntry, "itemName.text");
		dataBinder.registerBinding("HandEntry.qty", java.math.BigDecimal.class, this.kdtHandEntry, "qty.text");
		dataBinder.registerBinding("HandEntry.amount", java.math.BigDecimal.class, this.kdtHandEntry, "amount.text");
		dataBinder.registerBinding("HandEntry.remark", String.class, this.kdtHandEntry, "remark.text");
		dataBinder.registerBinding("farm", com.kingdee.eas.farm.stocking.basedata.FarmInfo.class, this.prmtfarm, "data");
		dataBinder.registerBinding("storageOrgUnit", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtstorageOrgUnit, "data");
		dataBinder.registerBinding("settleType", com.kingdee.eas.farm.stocking.processbizill.StockingSettlementTypeEnum.class, this.settleType, "selectedItem");
		dataBinder.registerBinding("breedDataAmount", java.math.BigDecimal.class, this.txtbreedDataAmount, "value");
		dataBinder.registerBinding("fodderAmount", java.math.BigDecimal.class, this.txtfodderAmount, "value");
		dataBinder.registerBinding("drugAmount", java.math.BigDecimal.class, this.txtdrugAmount, "value");
		dataBinder.registerBinding("birdsAmount", java.math.BigDecimal.class, this.txtbirdsAmount, "value");
		dataBinder.registerBinding("farmerProfit", java.math.BigDecimal.class, this.txtfarmerProfit, "value");
		dataBinder.registerBinding("awardsAmount", java.math.BigDecimal.class, this.txtawardsAmount, "value");
		dataBinder.registerBinding("marginAmount", java.math.BigDecimal.class, this.txtmarginAmount, "value");
		dataBinder.registerBinding("allEggAmount", java.math.BigDecimal.class, this.txtallEggAmount, "value");
		dataBinder.registerBinding("handAmount", java.math.BigDecimal.class, this.txthandAmount, "value");
		dataBinder.registerBinding("originalFarmerProfit", java.math.BigDecimal.class, this.txtoriginalFarmerProfit, "value");
		dataBinder.registerBinding("marginInterest", java.math.BigDecimal.class, this.txtmarginInterest, "value");
		dataBinder.registerBinding("loanInterest", java.math.BigDecimal.class, this.txtloanInterest, "value");
		dataBinder.registerBinding("alimony", java.math.BigDecimal.class, this.txtalimony, "value");
		dataBinder.registerBinding("otherMaterialAmount", java.math.BigDecimal.class, this.txtotherMaterialAmount, "value");
		dataBinder.registerBinding("occupyInterest", java.math.BigDecimal.class, this.txtoccupyInterest, "value");
		dataBinder.registerBinding("allQty", java.math.BigDecimal.class, this.txtallQty, "value");
		dataBinder.registerBinding("FCR", java.math.BigDecimal.class, this.txtFCR, "value");
		dataBinder.registerBinding("survivalRate", java.math.BigDecimal.class, this.txtsurvivalRate, "value");
		dataBinder.registerBinding("birdsQty", java.math.BigDecimal.class, this.txtbirdsQty, "value");
		dataBinder.registerBinding("fertilizationRate", java.math.BigDecimal.class, this.txtfertilizationRate, "value");
		dataBinder.registerBinding("layingRate", java.math.BigDecimal.class, this.txtlayingRate, "value");
		dataBinder.registerBinding("avgWeight", java.math.BigDecimal.class, this.txtavgWeight, "value");
		dataBinder.registerBinding("allLastStock", java.math.BigDecimal.class, this.txtallLastStock, "value");
		dataBinder.registerBinding("eggQty", java.math.BigDecimal.class, this.txteggQty, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("batchContract", com.kingdee.eas.farm.stocking.processbizill.BatchContractInfo.class, this.prmtbatchContract, "data");
		dataBinder.registerBinding("fertilizationRate2", java.math.BigDecimal.class, this.txtfertilizationRate2, "value");
		dataBinder.registerBinding("breedDataCost", java.math.BigDecimal.class, this.txtbreedDataCost, "value");
		dataBinder.registerBinding("fodderCost", java.math.BigDecimal.class, this.txtfodderCost, "value");
		dataBinder.registerBinding("drugCost", java.math.BigDecimal.class, this.txtdrugCost, "value");
		dataBinder.registerBinding("otherMaterialCost", java.math.BigDecimal.class, this.txtotherMaterialCost, "value");
		dataBinder.registerBinding("arAmountOffset", java.math.BigDecimal.class, this.txtarAmountOffset, "value");
		dataBinder.registerBinding("faFurCardCost", java.math.BigDecimal.class, this.txtfaFurCardCost, "value");
		dataBinder.registerBinding("feeCostAmount", java.math.BigDecimal.class, this.txtfeeCostAmount, "value");
		dataBinder.registerBinding("allActualCost", java.math.BigDecimal.class, this.txtallActualCost, "value");
		dataBinder.registerBinding("unitActualAmount", java.math.BigDecimal.class, this.txtunitActualAmount, "value");
		dataBinder.registerBinding("coProductAmount", java.math.BigDecimal.class, this.txtcoProductAmount, "value");
		dataBinder.registerBinding("loanInterestDiff", java.math.BigDecimal.class, this.txtloanInterestDiff, "value");
		dataBinder.registerBinding("receiveQcEggQty", java.math.BigDecimal.class, this.txtreceiveQcEggQty, "value");
		dataBinder.registerBinding("BatchDetail.seq", int.class, this.kdtBatchDetail, "seq.text");
		dataBinder.registerBinding("BatchDetail", com.kingdee.eas.farm.stocking.processbizill.StatementsBillBatchDetailInfo.class, this.kdtBatchDetail, "userObject");
		dataBinder.registerBinding("BatchDetail.farmer", java.lang.Object.class, this.kdtBatchDetail, "farmer.text");
		dataBinder.registerBinding("BatchDetail.farm", java.lang.Object.class, this.kdtBatchDetail, "farm.text");
		dataBinder.registerBinding("BatchDetail.stockingBatch", java.lang.Object.class, this.kdtBatchDetail, "stockingBatch.text");
		dataBinder.registerBinding("BatchDetail.matureDate", java.util.Date.class, this.kdtBatchDetail, "matureDate.text");
		dataBinder.registerBinding("BatchDetail.arOffsetBillID", String.class, this.kdtBatchDetail, "arOffsetBillID.text");
		dataBinder.registerBinding("BatchDetail.beginDate", java.util.Date.class, this.kdtBatchDetail, "beginDate.text");
		dataBinder.registerBinding("BatchDetail.endDate", java.util.Date.class, this.kdtBatchDetail, "endDate.text");
		dataBinder.registerBinding("BatchDetail.house", java.lang.Object.class, this.kdtBatchDetail, "house.text");
		dataBinder.registerBinding("BatchDetail.breedDate", java.util.Date.class, this.kdtBatchDetail, "breedDate.text");
		dataBinder.registerBinding("BatchDetail.isTransFA", boolean.class, this.kdtBatchDetail, "isTransFA.text");
		dataBinder.registerBinding("BatchDetail.offsetAmount", java.math.BigDecimal.class, this.kdtBatchDetail, "offsetAmount.text");
		dataBinder.registerBinding("period", com.kingdee.eas.basedata.assistant.PeriodInfo.class, this.prmtperiod, "data");
		dataBinder.registerBinding("beginDate", java.util.Date.class, this.pkbeginDate, "value");
		dataBinder.registerBinding("endDate", java.util.Date.class, this.pkendDate, "value");
		dataBinder.registerBinding("breedStage", com.kingdee.eas.farm.stocking.basedata.FarmStageEnum.class, this.breedStage, "selectedItem");
		dataBinder.registerBinding("farmersTree", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtfarmersTree, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.stocking.processbizill.app.StatementsBillEditUIHandler";
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
        this.txtfertilizationRate.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo)ov;
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
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("stockingBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.materialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.model", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.price", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.settlementItem", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.ItemName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.actualCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.unitActualCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.materialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.model", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.price", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.settlementItem", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.weight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.itemName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RewardsEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RewardsEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RewardsEntry.itemName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RewardsEntry.amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RewardsEntry.itemID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RewardsEntry.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OtherEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OtherEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OtherEntry.itemName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OtherEntry.amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OtherEntry.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OtherEntry.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HandEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HandEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HandEntry.itemName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HandEntry.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HandEntry.amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HandEntry.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("storageOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("settleType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedDataAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fodderAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("drugAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("birdsAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmerProfit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("awardsAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("marginAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allEggAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("handAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("originalFarmerProfit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("marginInterest", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("loanInterest", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("alimony", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("otherMaterialAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("occupyInterest", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FCR", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("survivalRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("birdsQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fertilizationRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("layingRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("avgWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allLastStock", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batchContract", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fertilizationRate2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedDataCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fodderCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("drugCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("otherMaterialCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("arAmountOffset", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("faFurCardCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("feeCostAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allActualCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("unitActualAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("coProductAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("loanInterestDiff", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("receiveQcEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BatchDetail.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BatchDetail", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BatchDetail.farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BatchDetail.farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BatchDetail.stockingBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BatchDetail.matureDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BatchDetail.arOffsetBillID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BatchDetail.beginDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BatchDetail.endDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BatchDetail.house", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BatchDetail.breedDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BatchDetail.isTransFA", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BatchDetail.offsetAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("period", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("beginDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("endDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedStage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmersTree", ValidateHelper.ON_SAVE);    		
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
     * output kdtEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"model").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"material").getValue(),"model")));

}

    if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"materialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"material").getValue(),"name")));

}


    }

    /**
     * output kdtEggEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEggEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("settlementItem".equalsIgnoreCase(kdtEggEntry.getColumn(colIndex).getKey())) {
kdtEggEntry.getCell(rowIndex,"materialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEggEntry.getCell(rowIndex,"settlementItem").getValue(),"name")));

}

    if ("material".equalsIgnoreCase(kdtEggEntry.getColumn(colIndex).getKey())) {
kdtEggEntry.getCell(rowIndex,"model").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEggEntry.getCell(rowIndex,"material").getValue(),"model")));

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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("stockingBatch.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("stockingBatch.id"));
        	sic.add(new SelectorItemInfo("stockingBatch.number"));
        	sic.add(new SelectorItemInfo("stockingBatch.name"));
		}
    	sic.add(new SelectorItemInfo("entrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.material.id"));
			sic.add(new SelectorItemInfo("entrys.material.number"));
			sic.add(new SelectorItemInfo("entrys.material.name"));
		}
    	sic.add(new SelectorItemInfo("entrys.materialName"));
    	sic.add(new SelectorItemInfo("entrys.model"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.unit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.unit.id"));
			sic.add(new SelectorItemInfo("entrys.unit.name"));
        	sic.add(new SelectorItemInfo("entrys.unit.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.qty"));
    	sic.add(new SelectorItemInfo("entrys.price"));
    	sic.add(new SelectorItemInfo("entrys.amount"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.settlementItem.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.settlementItem.id"));
			sic.add(new SelectorItemInfo("entrys.settlementItem.name"));
        	sic.add(new SelectorItemInfo("entrys.settlementItem.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.ItemName"));
    	sic.add(new SelectorItemInfo("entrys.remark"));
    	sic.add(new SelectorItemInfo("entrys.actualCost"));
    	sic.add(new SelectorItemInfo("entrys.unitActualCost"));
    	sic.add(new SelectorItemInfo("EggEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("EggEntry.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.material.id"));
			sic.add(new SelectorItemInfo("EggEntry.material.number"));
			sic.add(new SelectorItemInfo("EggEntry.material.name"));
		}
    	sic.add(new SelectorItemInfo("EggEntry.materialName"));
    	sic.add(new SelectorItemInfo("EggEntry.model"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.unit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.unit.id"));
			sic.add(new SelectorItemInfo("EggEntry.unit.name"));
        	sic.add(new SelectorItemInfo("EggEntry.unit.number"));
		}
    	sic.add(new SelectorItemInfo("EggEntry.qty"));
    	sic.add(new SelectorItemInfo("EggEntry.price"));
    	sic.add(new SelectorItemInfo("EggEntry.amount"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.settlementItem.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.settlementItem.id"));
			sic.add(new SelectorItemInfo("EggEntry.settlementItem.name"));
        	sic.add(new SelectorItemInfo("EggEntry.settlementItem.number"));
		}
    	sic.add(new SelectorItemInfo("EggEntry.weight"));
    	sic.add(new SelectorItemInfo("EggEntry.itemName"));
    	sic.add(new SelectorItemInfo("EggEntry.remark"));
    	sic.add(new SelectorItemInfo("RewardsEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("RewardsEntry.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("RewardsEntry.itemName"));
    	sic.add(new SelectorItemInfo("RewardsEntry.amount"));
    	sic.add(new SelectorItemInfo("RewardsEntry.itemID"));
    	sic.add(new SelectorItemInfo("RewardsEntry.remark"));
    	sic.add(new SelectorItemInfo("OtherEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("OtherEntry.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("OtherEntry.itemName"));
    	sic.add(new SelectorItemInfo("OtherEntry.amount"));
    	sic.add(new SelectorItemInfo("OtherEntry.qty"));
    	sic.add(new SelectorItemInfo("OtherEntry.remark"));
    	sic.add(new SelectorItemInfo("HandEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("HandEntry.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("HandEntry.itemName"));
    	sic.add(new SelectorItemInfo("HandEntry.qty"));
    	sic.add(new SelectorItemInfo("HandEntry.amount"));
    	sic.add(new SelectorItemInfo("HandEntry.remark"));
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
			sic.add(new SelectorItemInfo("storageOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("storageOrgUnit.id"));
        	sic.add(new SelectorItemInfo("storageOrgUnit.number"));
        	sic.add(new SelectorItemInfo("storageOrgUnit.name"));
		}
        sic.add(new SelectorItemInfo("settleType"));
        sic.add(new SelectorItemInfo("breedDataAmount"));
        sic.add(new SelectorItemInfo("fodderAmount"));
        sic.add(new SelectorItemInfo("drugAmount"));
        sic.add(new SelectorItemInfo("birdsAmount"));
        sic.add(new SelectorItemInfo("farmerProfit"));
        sic.add(new SelectorItemInfo("awardsAmount"));
        sic.add(new SelectorItemInfo("marginAmount"));
        sic.add(new SelectorItemInfo("allEggAmount"));
        sic.add(new SelectorItemInfo("handAmount"));
        sic.add(new SelectorItemInfo("originalFarmerProfit"));
        sic.add(new SelectorItemInfo("marginInterest"));
        sic.add(new SelectorItemInfo("loanInterest"));
        sic.add(new SelectorItemInfo("alimony"));
        sic.add(new SelectorItemInfo("otherMaterialAmount"));
        sic.add(new SelectorItemInfo("occupyInterest"));
        sic.add(new SelectorItemInfo("allQty"));
        sic.add(new SelectorItemInfo("FCR"));
        sic.add(new SelectorItemInfo("survivalRate"));
        sic.add(new SelectorItemInfo("birdsQty"));
        sic.add(new SelectorItemInfo("fertilizationRate"));
        sic.add(new SelectorItemInfo("layingRate"));
        sic.add(new SelectorItemInfo("avgWeight"));
        sic.add(new SelectorItemInfo("allLastStock"));
        sic.add(new SelectorItemInfo("eggQty"));
        sic.add(new SelectorItemInfo("description"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("batchContract.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("batchContract.id"));
        	sic.add(new SelectorItemInfo("batchContract.number"));
		}
        sic.add(new SelectorItemInfo("fertilizationRate2"));
        sic.add(new SelectorItemInfo("breedDataCost"));
        sic.add(new SelectorItemInfo("fodderCost"));
        sic.add(new SelectorItemInfo("drugCost"));
        sic.add(new SelectorItemInfo("otherMaterialCost"));
        sic.add(new SelectorItemInfo("arAmountOffset"));
        sic.add(new SelectorItemInfo("faFurCardCost"));
        sic.add(new SelectorItemInfo("feeCostAmount"));
        sic.add(new SelectorItemInfo("allActualCost"));
        sic.add(new SelectorItemInfo("unitActualAmount"));
        sic.add(new SelectorItemInfo("coProductAmount"));
        sic.add(new SelectorItemInfo("loanInterestDiff"));
        sic.add(new SelectorItemInfo("receiveQcEggQty"));
    	sic.add(new SelectorItemInfo("BatchDetail.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("BatchDetail.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("BatchDetail.farmer.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("BatchDetail.farmer.id"));
			sic.add(new SelectorItemInfo("BatchDetail.farmer.name"));
        	sic.add(new SelectorItemInfo("BatchDetail.farmer.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("BatchDetail.farm.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("BatchDetail.farm.id"));
			sic.add(new SelectorItemInfo("BatchDetail.farm.name"));
        	sic.add(new SelectorItemInfo("BatchDetail.farm.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("BatchDetail.stockingBatch.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("BatchDetail.stockingBatch.id"));
			sic.add(new SelectorItemInfo("BatchDetail.stockingBatch.number"));
			sic.add(new SelectorItemInfo("BatchDetail.stockingBatch.name"));
		}
    	sic.add(new SelectorItemInfo("BatchDetail.matureDate"));
    	sic.add(new SelectorItemInfo("BatchDetail.arOffsetBillID"));
    	sic.add(new SelectorItemInfo("BatchDetail.beginDate"));
    	sic.add(new SelectorItemInfo("BatchDetail.endDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("BatchDetail.house.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("BatchDetail.house.id"));
			sic.add(new SelectorItemInfo("BatchDetail.house.name"));
        	sic.add(new SelectorItemInfo("BatchDetail.house.number"));
		}
    	sic.add(new SelectorItemInfo("BatchDetail.breedDate"));
    	sic.add(new SelectorItemInfo("BatchDetail.isTransFA"));
    	sic.add(new SelectorItemInfo("BatchDetail.offsetAmount"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("period.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("period.id"));
        	sic.add(new SelectorItemInfo("period.number"));
		}
        sic.add(new SelectorItemInfo("beginDate"));
        sic.add(new SelectorItemInfo("endDate"));
        sic.add(new SelectorItemInfo("breedStage"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("farmersTree.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farmersTree.id"));
        	sic.add(new SelectorItemInfo("farmersTree.number"));
        	sic.add(new SelectorItemInfo("farmersTree.name"));
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
        com.kingdee.eas.farm.stocking.processbizill.StatementsBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.processbizill.StatementsBillFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionBtnExeCal_actionPerformed method
     */
    public void actionBtnExeCal_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.processbizill.StatementsBillFactory.getRemoteInstance().btnExeCal(editData);
    }
    	

    /**
     * output actionMultiSubmit_actionPerformed method
     */
    public void actionMultiSubmit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.processbizill.StatementsBillFactory.getRemoteInstance().multiSubmit(editData);
    }
    	

    /**
     * output actionBreateBill_actionPerformed method
     */
    public void actionBreateBill_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.processbizill.StatementsBillFactory.getRemoteInstance().breateBill(editData);
    }
    	

    /**
     * output actionCalYC_actionPerformed method
     */
    public void actionCalYC_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.processbizill.StatementsBillFactory.getRemoteInstance().calYC(editData);
    }
    	

    /**
     * output actionCarryover_actionPerformed method
     */
    public void actionCarryover_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.processbizill.StatementsBillFactory.getRemoteInstance().carryover(editData);
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
	public RequestContext prepareActionBtnExeCal(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionBtnExeCal() {
    	return false;
    }
	public RequestContext prepareActionMultiSubmit(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionMultiSubmit() {
    	return false;
    }
	public RequestContext prepareActionBreateBill(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionBreateBill() {
    	return false;
    }
	public RequestContext prepareActionCalYC(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionCalYC() {
    	return false;
    }
	public RequestContext prepareActionCarryover(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionCarryover() {
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
            innerActionPerformed("eas", AbstractStatementsBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractStatementsBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionBtnExeCal class
     */     
    protected class ActionBtnExeCal extends ItemAction {     
    
        public ActionBtnExeCal()
        {
            this(null);
        }

        public ActionBtnExeCal(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionBtnExeCal.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionBtnExeCal.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionBtnExeCal.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractStatementsBillEditUI.this, "ActionBtnExeCal", "actionBtnExeCal_actionPerformed", e);
        }
    }

    /**
     * output ActionMultiSubmit class
     */     
    protected class ActionMultiSubmit extends ItemAction {     
    
        public ActionMultiSubmit()
        {
            this(null);
        }

        public ActionMultiSubmit(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionMultiSubmit.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionMultiSubmit.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionMultiSubmit.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractStatementsBillEditUI.this, "ActionMultiSubmit", "actionMultiSubmit_actionPerformed", e);
        }
    }

    /**
     * output ActionBreateBill class
     */     
    protected class ActionBreateBill extends ItemAction {     
    
        public ActionBreateBill()
        {
            this(null);
        }

        public ActionBreateBill(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionBreateBill.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionBreateBill.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionBreateBill.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractStatementsBillEditUI.this, "ActionBreateBill", "actionBreateBill_actionPerformed", e);
        }
    }

    /**
     * output ActionCalYC class
     */     
    protected class ActionCalYC extends ItemAction {     
    
        public ActionCalYC()
        {
            this(null);
        }

        public ActionCalYC(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionCalYC.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCalYC.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCalYC.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractStatementsBillEditUI.this, "ActionCalYC", "actionCalYC_actionPerformed", e);
        }
    }

    /**
     * output ActionCarryover class
     */     
    protected class ActionCarryover extends ItemAction {     
    
        public ActionCarryover()
        {
            this(null);
        }

        public ActionCarryover(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionCarryover.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCarryover.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCarryover.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractStatementsBillEditUI.this, "ActionCarryover", "actionCarryover_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.stocking.processbizill.client", "StatementsBillEditUI");
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
        return com.kingdee.eas.farm.stocking.processbizill.client.StatementsBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.processbizill.StatementsBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/stocking/processbizill/StatementsBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.stocking.processbizill.app.StatementsBillQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtfarmer.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养户名称"});
		}
		for (int i=0,n=kdtHandEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtHandEntry.getCell(i,"itemName").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"项目名称"});
			}
		}
		for (int i=0,n=kdtHandEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtHandEntry.getCell(i,"amount").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"金额"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtfarm.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖场"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(settleType.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"结算方式"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtperiod.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"期间"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(breedStage.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖阶段"});
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
		vo.put("billStatus",new Integer(-1));
vo.put("settleType",new Integer(1));
		vo.put("handAmount",new java.math.BigDecimal(0));
vo.put("breedStage",new Integer(1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}