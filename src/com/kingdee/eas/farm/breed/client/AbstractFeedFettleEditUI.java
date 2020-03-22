/**
 * output package name
 */
package com.kingdee.eas.farm.breed.client;

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
public abstract class AbstractFeedFettleEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractFeedFettleEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcustomer;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcustomer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBIMUDF0003;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBIMUDF0004;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedBatch;
    protected com.kingdee.bos.ctrl.swing.KDButton btnExcute;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBIMUDF0003;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBIMUDF0004;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbreedBatch;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfodderQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdrugAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchikenQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBigChikenWeight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcustomerAllProfit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontractDIf;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsettlementStandard;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcustomerCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcustomerIncome;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweightAvg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfodderPerChicken;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmeatPerFodder;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbigChickenPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompanyGrossProfit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompanyAllProfit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfodderQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdrugAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchikenQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtBigChikenWeight;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcustomerAllProfit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcontractDIf;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsettlementStandard;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcustomerCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcustomerIncome;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickenCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtweightAvg;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfodderPerChicken;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmeatPerFodder;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbigChickenPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcompanyGrossProfit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcompanyAllProfit;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtStandardEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtStandardEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.eas.farm.breed.FeedFettleInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractFeedFettleEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractFeedFettleEditUI.class.getName());
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
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcustomer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcustomer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.contBIMUDF0003 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBIMUDF0004 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbreedBatch = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnExcute = new com.kingdee.bos.ctrl.swing.KDButton();
        this.pkBIMUDF0003 = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkBIMUDF0004 = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtbreedBatch = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.contfodderQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdrugAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchikenQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBigChikenWeight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcustomerAllProfit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcontractDIf = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsettlementStandard = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcustomerCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcustomerIncome = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchickenCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweightAvg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfodderPerChicken = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmeatPerFodder = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbigChickenPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompanyGrossProfit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompanyAllProfit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtfodderQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdrugAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtchikenQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtBigChikenWeight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcustomerAllProfit = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcontractDIf = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsettlementStandard = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcustomerCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcustomerIncome = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtchickenCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtweightAvg = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfodderPerChicken = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmeatPerFodder = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbigChickenPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcompanyGrossProfit = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcompanyAllProfit = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtStandardEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.contcustomer.setName("contcustomer");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contauditTime.setName("contauditTime");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtcustomer.setName("prmtcustomer");
        this.contBIMUDF0003.setName("contBIMUDF0003");
        this.contBIMUDF0004.setName("contBIMUDF0004");
        this.contbreedBatch.setName("contbreedBatch");
        this.btnExcute.setName("btnExcute");
        this.pkBIMUDF0003.setName("pkBIMUDF0003");
        this.pkBIMUDF0004.setName("pkBIMUDF0004");
        this.prmtbreedBatch.setName("prmtbreedBatch");
        this.contfodderQty.setName("contfodderQty");
        this.contdrugAmount.setName("contdrugAmount");
        this.contchikenQty.setName("contchikenQty");
        this.contBigChikenWeight.setName("contBigChikenWeight");
        this.contcustomerAllProfit.setName("contcustomerAllProfit");
        this.contcontractDIf.setName("contcontractDIf");
        this.contsettlementStandard.setName("contsettlementStandard");
        this.contcustomerCost.setName("contcustomerCost");
        this.contcustomerIncome.setName("contcustomerIncome");
        this.contchickenCost.setName("contchickenCost");
        this.contweightAvg.setName("contweightAvg");
        this.contfodderPerChicken.setName("contfodderPerChicken");
        this.contmeatPerFodder.setName("contmeatPerFodder");
        this.contbigChickenPrice.setName("contbigChickenPrice");
        this.contcompanyGrossProfit.setName("contcompanyGrossProfit");
        this.contcompanyAllProfit.setName("contcompanyAllProfit");
        this.txtfodderQty.setName("txtfodderQty");
        this.txtdrugAmount.setName("txtdrugAmount");
        this.txtchikenQty.setName("txtchikenQty");
        this.txtBigChikenWeight.setName("txtBigChikenWeight");
        this.txtcustomerAllProfit.setName("txtcustomerAllProfit");
        this.txtcontractDIf.setName("txtcontractDIf");
        this.txtsettlementStandard.setName("txtsettlementStandard");
        this.txtcustomerCost.setName("txtcustomerCost");
        this.txtcustomerIncome.setName("txtcustomerIncome");
        this.txtchickenCost.setName("txtchickenCost");
        this.txtweightAvg.setName("txtweightAvg");
        this.txtfodderPerChicken.setName("txtfodderPerChicken");
        this.txtmeatPerFodder.setName("txtmeatPerFodder");
        this.txtbigChickenPrice.setName("txtbigChickenPrice");
        this.txtcompanyGrossProfit.setName("txtcompanyGrossProfit");
        this.txtcompanyAllProfit.setName("txtcompanyAllProfit");
        this.kDPanel3.setName("kDPanel3");
        this.kDPanel4.setName("kDPanel4");
        this.kdtEntrys.setName("kdtEntrys");
        this.kdtStandardEntry.setName("kdtStandardEntry");
        this.pkauditTime.setName("pkauditTime");
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
        // contcustomer		
        this.contcustomer.setBoundLabelText(resHelper.getString("contcustomer.boundLabelText"));		
        this.contcustomer.setBoundLabelLength(100);		
        this.contcustomer.setBoundLabelUnderline(true);		
        this.contcustomer.setVisible(true);
        // kDPanel1		
        this.kDPanel1.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel1.border.title")));
        // kDPanel2		
        this.kDPanel2.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel2.border.title")));
        // kDTabbedPane1
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
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
        // prmtcustomer		
        this.prmtcustomer.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.CustomerInfoQuery");		
        this.prmtcustomer.setEditable(true);		
        this.prmtcustomer.setDisplayFormat("$name$");		
        this.prmtcustomer.setEditFormat("$number$");		
        this.prmtcustomer.setCommitFormat("$number$");		
        this.prmtcustomer.setRequired(false);
        // contBIMUDF0003		
        this.contBIMUDF0003.setBoundLabelText(resHelper.getString("contBIMUDF0003.boundLabelText"));		
        this.contBIMUDF0003.setBoundLabelLength(100);		
        this.contBIMUDF0003.setBoundLabelUnderline(true);		
        this.contBIMUDF0003.setVisible(true);
        // contBIMUDF0004		
        this.contBIMUDF0004.setBoundLabelText(resHelper.getString("contBIMUDF0004.boundLabelText"));		
        this.contBIMUDF0004.setBoundLabelLength(100);		
        this.contBIMUDF0004.setBoundLabelUnderline(true);		
        this.contBIMUDF0004.setVisible(true);
        // contbreedBatch		
        this.contbreedBatch.setBoundLabelText(resHelper.getString("contbreedBatch.boundLabelText"));		
        this.contbreedBatch.setBoundLabelLength(100);		
        this.contbreedBatch.setBoundLabelUnderline(true);		
        this.contbreedBatch.setVisible(true);
        // btnExcute		
        this.btnExcute.setText(resHelper.getString("btnExcute.text"));
        // pkBIMUDF0003		
        this.pkBIMUDF0003.setRequired(false);
        // pkBIMUDF0004		
        this.pkBIMUDF0004.setRequired(false);
        // prmtbreedBatch		
        this.prmtbreedBatch.setQueryInfo("com.kingdee.eas.farm.breed.app.BreedBatchQuery");		
        this.prmtbreedBatch.setEditable(true);		
        this.prmtbreedBatch.setDisplayFormat("$number$");		
        this.prmtbreedBatch.setEditFormat("$number$");		
        this.prmtbreedBatch.setCommitFormat("$number$");		
        this.prmtbreedBatch.setRequired(false);
        // contfodderQty		
        this.contfodderQty.setBoundLabelText(resHelper.getString("contfodderQty.boundLabelText"));		
        this.contfodderQty.setBoundLabelLength(100);		
        this.contfodderQty.setBoundLabelUnderline(true);		
        this.contfodderQty.setVisible(true);
        // contdrugAmount		
        this.contdrugAmount.setBoundLabelText(resHelper.getString("contdrugAmount.boundLabelText"));		
        this.contdrugAmount.setBoundLabelLength(100);		
        this.contdrugAmount.setBoundLabelUnderline(true);		
        this.contdrugAmount.setVisible(true);
        // contchikenQty		
        this.contchikenQty.setBoundLabelText(resHelper.getString("contchikenQty.boundLabelText"));		
        this.contchikenQty.setBoundLabelLength(100);		
        this.contchikenQty.setBoundLabelUnderline(true);		
        this.contchikenQty.setVisible(true);
        // contBigChikenWeight		
        this.contBigChikenWeight.setBoundLabelText(resHelper.getString("contBigChikenWeight.boundLabelText"));		
        this.contBigChikenWeight.setBoundLabelLength(100);		
        this.contBigChikenWeight.setBoundLabelUnderline(true);		
        this.contBigChikenWeight.setVisible(true);
        // contcustomerAllProfit		
        this.contcustomerAllProfit.setBoundLabelText(resHelper.getString("contcustomerAllProfit.boundLabelText"));		
        this.contcustomerAllProfit.setBoundLabelLength(100);		
        this.contcustomerAllProfit.setBoundLabelUnderline(true);		
        this.contcustomerAllProfit.setVisible(true);
        // contcontractDIf		
        this.contcontractDIf.setBoundLabelText(resHelper.getString("contcontractDIf.boundLabelText"));		
        this.contcontractDIf.setBoundLabelLength(100);		
        this.contcontractDIf.setBoundLabelUnderline(true);		
        this.contcontractDIf.setVisible(true);
        // contsettlementStandard		
        this.contsettlementStandard.setBoundLabelText(resHelper.getString("contsettlementStandard.boundLabelText"));		
        this.contsettlementStandard.setBoundLabelLength(100);		
        this.contsettlementStandard.setBoundLabelUnderline(true);		
        this.contsettlementStandard.setVisible(true);
        // contcustomerCost		
        this.contcustomerCost.setBoundLabelText(resHelper.getString("contcustomerCost.boundLabelText"));		
        this.contcustomerCost.setBoundLabelLength(100);		
        this.contcustomerCost.setBoundLabelUnderline(true);		
        this.contcustomerCost.setVisible(true);
        // contcustomerIncome		
        this.contcustomerIncome.setBoundLabelText(resHelper.getString("contcustomerIncome.boundLabelText"));		
        this.contcustomerIncome.setBoundLabelLength(100);		
        this.contcustomerIncome.setBoundLabelUnderline(true);		
        this.contcustomerIncome.setVisible(true);
        // contchickenCost		
        this.contchickenCost.setBoundLabelText(resHelper.getString("contchickenCost.boundLabelText"));		
        this.contchickenCost.setBoundLabelLength(100);		
        this.contchickenCost.setBoundLabelUnderline(true);		
        this.contchickenCost.setVisible(true);
        // contweightAvg		
        this.contweightAvg.setBoundLabelText(resHelper.getString("contweightAvg.boundLabelText"));		
        this.contweightAvg.setBoundLabelLength(100);		
        this.contweightAvg.setBoundLabelUnderline(true);		
        this.contweightAvg.setVisible(true);
        // contfodderPerChicken		
        this.contfodderPerChicken.setBoundLabelText(resHelper.getString("contfodderPerChicken.boundLabelText"));		
        this.contfodderPerChicken.setBoundLabelLength(100);		
        this.contfodderPerChicken.setBoundLabelUnderline(true);		
        this.contfodderPerChicken.setVisible(true);
        // contmeatPerFodder		
        this.contmeatPerFodder.setBoundLabelText(resHelper.getString("contmeatPerFodder.boundLabelText"));		
        this.contmeatPerFodder.setBoundLabelLength(100);		
        this.contmeatPerFodder.setBoundLabelUnderline(true);		
        this.contmeatPerFodder.setVisible(true);
        // contbigChickenPrice		
        this.contbigChickenPrice.setBoundLabelText(resHelper.getString("contbigChickenPrice.boundLabelText"));		
        this.contbigChickenPrice.setBoundLabelLength(100);		
        this.contbigChickenPrice.setBoundLabelUnderline(true);		
        this.contbigChickenPrice.setVisible(true);
        // contcompanyGrossProfit		
        this.contcompanyGrossProfit.setBoundLabelText(resHelper.getString("contcompanyGrossProfit.boundLabelText"));		
        this.contcompanyGrossProfit.setBoundLabelLength(100);		
        this.contcompanyGrossProfit.setBoundLabelUnderline(true);		
        this.contcompanyGrossProfit.setVisible(true);
        // contcompanyAllProfit		
        this.contcompanyAllProfit.setBoundLabelText(resHelper.getString("contcompanyAllProfit.boundLabelText"));		
        this.contcompanyAllProfit.setBoundLabelLength(100);		
        this.contcompanyAllProfit.setBoundLabelUnderline(true);		
        this.contcompanyAllProfit.setVisible(true);
        // txtfodderQty		
        this.txtfodderQty.setHorizontalAlignment(2);		
        this.txtfodderQty.setDataType(1);		
        this.txtfodderQty.setSupportedEmpty(true);		
        this.txtfodderQty.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtfodderQty.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtfodderQty.setPrecision(2);		
        this.txtfodderQty.setRequired(false);
        // txtdrugAmount		
        this.txtdrugAmount.setHorizontalAlignment(2);		
        this.txtdrugAmount.setDataType(1);		
        this.txtdrugAmount.setSupportedEmpty(true);		
        this.txtdrugAmount.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtdrugAmount.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtdrugAmount.setPrecision(2);		
        this.txtdrugAmount.setRequired(false);
        // txtchikenQty		
        this.txtchikenQty.setHorizontalAlignment(2);		
        this.txtchikenQty.setDataType(0);		
        this.txtchikenQty.setSupportedEmpty(true);		
        this.txtchikenQty.setRequired(false);
        // txtBigChikenWeight		
        this.txtBigChikenWeight.setHorizontalAlignment(2);		
        this.txtBigChikenWeight.setDataType(1);		
        this.txtBigChikenWeight.setSupportedEmpty(true);		
        this.txtBigChikenWeight.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtBigChikenWeight.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtBigChikenWeight.setPrecision(2);		
        this.txtBigChikenWeight.setRequired(false);
        // txtcustomerAllProfit		
        this.txtcustomerAllProfit.setHorizontalAlignment(2);		
        this.txtcustomerAllProfit.setDataType(1);		
        this.txtcustomerAllProfit.setSupportedEmpty(true);		
        this.txtcustomerAllProfit.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtcustomerAllProfit.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtcustomerAllProfit.setPrecision(2);		
        this.txtcustomerAllProfit.setRequired(false);
        // txtcontractDIf		
        this.txtcontractDIf.setHorizontalAlignment(2);		
        this.txtcontractDIf.setDataType(1);		
        this.txtcontractDIf.setSupportedEmpty(true);		
        this.txtcontractDIf.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtcontractDIf.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtcontractDIf.setPrecision(2);		
        this.txtcontractDIf.setRequired(false);
        // txtsettlementStandard		
        this.txtsettlementStandard.setHorizontalAlignment(2);		
        this.txtsettlementStandard.setDataType(1);		
        this.txtsettlementStandard.setSupportedEmpty(true);		
        this.txtsettlementStandard.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtsettlementStandard.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtsettlementStandard.setPrecision(2);		
        this.txtsettlementStandard.setRequired(false);
        // txtcustomerCost		
        this.txtcustomerCost.setHorizontalAlignment(2);		
        this.txtcustomerCost.setDataType(1);		
        this.txtcustomerCost.setSupportedEmpty(true);		
        this.txtcustomerCost.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtcustomerCost.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtcustomerCost.setPrecision(2);		
        this.txtcustomerCost.setRequired(false);
        // txtcustomerIncome		
        this.txtcustomerIncome.setHorizontalAlignment(2);		
        this.txtcustomerIncome.setDataType(1);		
        this.txtcustomerIncome.setSupportedEmpty(true);		
        this.txtcustomerIncome.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtcustomerIncome.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtcustomerIncome.setPrecision(2);		
        this.txtcustomerIncome.setRequired(false);
        // txtchickenCost		
        this.txtchickenCost.setHorizontalAlignment(2);		
        this.txtchickenCost.setDataType(1);		
        this.txtchickenCost.setSupportedEmpty(true);		
        this.txtchickenCost.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtchickenCost.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtchickenCost.setPrecision(2);		
        this.txtchickenCost.setRequired(false);
        // txtweightAvg		
        this.txtweightAvg.setHorizontalAlignment(2);		
        this.txtweightAvg.setDataType(1);		
        this.txtweightAvg.setSupportedEmpty(true);		
        this.txtweightAvg.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtweightAvg.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtweightAvg.setPrecision(2);		
        this.txtweightAvg.setRequired(false);
        // txtfodderPerChicken		
        this.txtfodderPerChicken.setHorizontalAlignment(2);		
        this.txtfodderPerChicken.setDataType(1);		
        this.txtfodderPerChicken.setSupportedEmpty(true);		
        this.txtfodderPerChicken.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtfodderPerChicken.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtfodderPerChicken.setPrecision(2);		
        this.txtfodderPerChicken.setRequired(false);
        // txtmeatPerFodder		
        this.txtmeatPerFodder.setHorizontalAlignment(2);		
        this.txtmeatPerFodder.setDataType(1);		
        this.txtmeatPerFodder.setSupportedEmpty(true);		
        this.txtmeatPerFodder.setMinimumValue( new java.math.BigDecimal("-1.0E22"));		
        this.txtmeatPerFodder.setMaximumValue( new java.math.BigDecimal("1.0E22"));		
        this.txtmeatPerFodder.setPrecision(6);		
        this.txtmeatPerFodder.setRequired(false);
        // txtbigChickenPrice		
        this.txtbigChickenPrice.setHorizontalAlignment(2);		
        this.txtbigChickenPrice.setDataType(1);		
        this.txtbigChickenPrice.setSupportedEmpty(true);		
        this.txtbigChickenPrice.setMinimumValue( new java.math.BigDecimal("-1.0E22"));		
        this.txtbigChickenPrice.setMaximumValue( new java.math.BigDecimal("1.0E22"));		
        this.txtbigChickenPrice.setPrecision(6);		
        this.txtbigChickenPrice.setRequired(false);
        // txtcompanyGrossProfit		
        this.txtcompanyGrossProfit.setHorizontalAlignment(2);		
        this.txtcompanyGrossProfit.setDataType(1);		
        this.txtcompanyGrossProfit.setSupportedEmpty(true);		
        this.txtcompanyGrossProfit.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtcompanyGrossProfit.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtcompanyGrossProfit.setPrecision(2);		
        this.txtcompanyGrossProfit.setRequired(false);
        // txtcompanyAllProfit		
        this.txtcompanyAllProfit.setHorizontalAlignment(2);		
        this.txtcompanyAllProfit.setDataType(1);		
        this.txtcompanyAllProfit.setSupportedEmpty(true);		
        this.txtcompanyAllProfit.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtcompanyAllProfit.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtcompanyAllProfit.setPrecision(2);		
        this.txtcompanyAllProfit.setRequired(false);
        // kDPanel3
        // kDPanel4
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"billDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"billNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"materialName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"baseQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"salePrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"saleAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"costPrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"costAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"companyGrossProfit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{billDate}</t:Cell><t:Cell>$Resource{billNumber}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{baseQty}</t:Cell><t:Cell>$Resource{salePrice}</t:Cell><t:Cell>$Resource{saleAmount}</t:Cell><t:Cell>$Resource{costPrice}</t:Cell><t:Cell>$Resource{costAmount}</t:Cell><t:Cell>$Resource{companyGrossProfit}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtEntrys.putBindContents("editData",new String[] {"id","billDate","billNumber","material","materialName","baseQty","salePrice","saleAmount","costPrice","costAmount","companyGrossProfit"});


        this.kdtEntrys.checkParsed();
        KDDatePicker kdtEntrys_billDate_DatePicker = new KDDatePicker();
        kdtEntrys_billDate_DatePicker.setName("kdtEntrys_billDate_DatePicker");
        kdtEntrys_billDate_DatePicker.setVisible(true);
        kdtEntrys_billDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_billDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_billDate_DatePicker);
        this.kdtEntrys.getColumn("billDate").setEditor(kdtEntrys_billDate_CellEditor);
        KDTextField kdtEntrys_billNumber_TextField = new KDTextField();
        kdtEntrys_billNumber_TextField.setName("kdtEntrys_billNumber_TextField");
        kdtEntrys_billNumber_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_billNumber_CellEditor = new KDTDefaultCellEditor(kdtEntrys_billNumber_TextField);
        this.kdtEntrys.getColumn("billNumber").setEditor(kdtEntrys_billNumber_CellEditor);
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
        KDFormattedTextField kdtEntrys_baseQty_TextField = new KDFormattedTextField();
        kdtEntrys_baseQty_TextField.setName("kdtEntrys_baseQty_TextField");
        kdtEntrys_baseQty_TextField.setVisible(true);
        kdtEntrys_baseQty_TextField.setEditable(true);
        kdtEntrys_baseQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_baseQty_TextField.setDataType(1);
        	kdtEntrys_baseQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E24"));
        	kdtEntrys_baseQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E24"));
        kdtEntrys_baseQty_TextField.setPrecision(4);
        KDTDefaultCellEditor kdtEntrys_baseQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_baseQty_TextField);
        this.kdtEntrys.getColumn("baseQty").setEditor(kdtEntrys_baseQty_CellEditor);
        KDFormattedTextField kdtEntrys_salePrice_TextField = new KDFormattedTextField();
        kdtEntrys_salePrice_TextField.setName("kdtEntrys_salePrice_TextField");
        kdtEntrys_salePrice_TextField.setVisible(true);
        kdtEntrys_salePrice_TextField.setEditable(true);
        kdtEntrys_salePrice_TextField.setHorizontalAlignment(2);
        kdtEntrys_salePrice_TextField.setDataType(1);
        	kdtEntrys_salePrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E22"));
        	kdtEntrys_salePrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E22"));
        kdtEntrys_salePrice_TextField.setPrecision(6);
        KDTDefaultCellEditor kdtEntrys_salePrice_CellEditor = new KDTDefaultCellEditor(kdtEntrys_salePrice_TextField);
        this.kdtEntrys.getColumn("salePrice").setEditor(kdtEntrys_salePrice_CellEditor);
        KDFormattedTextField kdtEntrys_saleAmount_TextField = new KDFormattedTextField();
        kdtEntrys_saleAmount_TextField.setName("kdtEntrys_saleAmount_TextField");
        kdtEntrys_saleAmount_TextField.setVisible(true);
        kdtEntrys_saleAmount_TextField.setEditable(true);
        kdtEntrys_saleAmount_TextField.setHorizontalAlignment(2);
        kdtEntrys_saleAmount_TextField.setDataType(1);
        	kdtEntrys_saleAmount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E24"));
        	kdtEntrys_saleAmount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E24"));
        kdtEntrys_saleAmount_TextField.setPrecision(4);
        KDTDefaultCellEditor kdtEntrys_saleAmount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_saleAmount_TextField);
        this.kdtEntrys.getColumn("saleAmount").setEditor(kdtEntrys_saleAmount_CellEditor);
        KDFormattedTextField kdtEntrys_costPrice_TextField = new KDFormattedTextField();
        kdtEntrys_costPrice_TextField.setName("kdtEntrys_costPrice_TextField");
        kdtEntrys_costPrice_TextField.setVisible(true);
        kdtEntrys_costPrice_TextField.setEditable(true);
        kdtEntrys_costPrice_TextField.setHorizontalAlignment(2);
        kdtEntrys_costPrice_TextField.setDataType(1);
        	kdtEntrys_costPrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E22"));
        	kdtEntrys_costPrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E22"));
        kdtEntrys_costPrice_TextField.setPrecision(6);
        KDTDefaultCellEditor kdtEntrys_costPrice_CellEditor = new KDTDefaultCellEditor(kdtEntrys_costPrice_TextField);
        this.kdtEntrys.getColumn("costPrice").setEditor(kdtEntrys_costPrice_CellEditor);
        KDFormattedTextField kdtEntrys_costAmount_TextField = new KDFormattedTextField();
        kdtEntrys_costAmount_TextField.setName("kdtEntrys_costAmount_TextField");
        kdtEntrys_costAmount_TextField.setVisible(true);
        kdtEntrys_costAmount_TextField.setEditable(true);
        kdtEntrys_costAmount_TextField.setHorizontalAlignment(2);
        kdtEntrys_costAmount_TextField.setDataType(1);
        	kdtEntrys_costAmount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E24"));
        	kdtEntrys_costAmount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E24"));
        kdtEntrys_costAmount_TextField.setPrecision(4);
        KDTDefaultCellEditor kdtEntrys_costAmount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_costAmount_TextField);
        this.kdtEntrys.getColumn("costAmount").setEditor(kdtEntrys_costAmount_CellEditor);
        KDFormattedTextField kdtEntrys_companyGrossProfit_TextField = new KDFormattedTextField();
        kdtEntrys_companyGrossProfit_TextField.setName("kdtEntrys_companyGrossProfit_TextField");
        kdtEntrys_companyGrossProfit_TextField.setVisible(true);
        kdtEntrys_companyGrossProfit_TextField.setEditable(true);
        kdtEntrys_companyGrossProfit_TextField.setHorizontalAlignment(2);
        kdtEntrys_companyGrossProfit_TextField.setDataType(1);
        	kdtEntrys_companyGrossProfit_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E24"));
        	kdtEntrys_companyGrossProfit_TextField.setMaximumValue(new java.math.BigDecimal("1.0E24"));
        kdtEntrys_companyGrossProfit_TextField.setPrecision(4);
        KDTDefaultCellEditor kdtEntrys_companyGrossProfit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_companyGrossProfit_TextField);
        this.kdtEntrys.getColumn("companyGrossProfit").setEditor(kdtEntrys_companyGrossProfit_CellEditor);
        // kdtStandardEntry
		String kdtStandardEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"standardNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"standardName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"grossProfit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"grossProfit2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"grossProfit3\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"isUse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"useGroprofitNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{standardNumber}</t:Cell><t:Cell>$Resource{standardName}</t:Cell><t:Cell>$Resource{grossProfit}</t:Cell><t:Cell>$Resource{grossProfit2}</t:Cell><t:Cell>$Resource{grossProfit3}</t:Cell><t:Cell>$Resource{isUse}</t:Cell><t:Cell>$Resource{useGroprofitNum}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtStandardEntry.setFormatXml(resHelper.translateString("kdtStandardEntry",kdtStandardEntryStrXML));
        kdtStandardEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtStandardEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtStandardEntry.putBindContents("editData",new String[] {"seq","standardNumber","standardName","grossProfit","grossProfit2","grossProfit3","isUse","useGroprofitNum"});


        this.kdtStandardEntry.checkParsed();
        KDFormattedTextField kdtStandardEntry_seq_TextField = new KDFormattedTextField();
        kdtStandardEntry_seq_TextField.setName("kdtStandardEntry_seq_TextField");
        kdtStandardEntry_seq_TextField.setVisible(true);
        kdtStandardEntry_seq_TextField.setEditable(true);
        kdtStandardEntry_seq_TextField.setHorizontalAlignment(2);
        kdtStandardEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtStandardEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtStandardEntry_seq_TextField);
        this.kdtStandardEntry.getColumn("seq").setEditor(kdtStandardEntry_seq_CellEditor);
        final KDBizPromptBox kdtStandardEntry_standardNumber_PromptBox = new KDBizPromptBox();
        kdtStandardEntry_standardNumber_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.EntrustSettleStandardQuery");
        kdtStandardEntry_standardNumber_PromptBox.setVisible(true);
        kdtStandardEntry_standardNumber_PromptBox.setEditable(true);
        kdtStandardEntry_standardNumber_PromptBox.setDisplayFormat("$number$");
        kdtStandardEntry_standardNumber_PromptBox.setEditFormat("$number$");
        kdtStandardEntry_standardNumber_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtStandardEntry_standardNumber_CellEditor = new KDTDefaultCellEditor(kdtStandardEntry_standardNumber_PromptBox);
        this.kdtStandardEntry.getColumn("standardNumber").setEditor(kdtStandardEntry_standardNumber_CellEditor);
        ObjectValueRender kdtStandardEntry_standardNumber_OVR = new ObjectValueRender();
        kdtStandardEntry_standardNumber_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtStandardEntry.getColumn("standardNumber").setRenderer(kdtStandardEntry_standardNumber_OVR);
        			kdtStandardEntry_standardNumber_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.breed.client.EntrustSettleStandardListUI kdtStandardEntry_standardNumber_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtStandardEntry_standardNumber_PromptBox_F7ListUI == null) {
					try {
						kdtStandardEntry_standardNumber_PromptBox_F7ListUI = new com.kingdee.eas.farm.breed.client.EntrustSettleStandardListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtStandardEntry_standardNumber_PromptBox_F7ListUI));
					kdtStandardEntry_standardNumber_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtStandardEntry_standardNumber_PromptBox.setSelector(kdtStandardEntry_standardNumber_PromptBox_F7ListUI);
				}
			}
		});
					
        KDTextField kdtStandardEntry_standardName_TextField = new KDTextField();
        kdtStandardEntry_standardName_TextField.setName("kdtStandardEntry_standardName_TextField");
        kdtStandardEntry_standardName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtStandardEntry_standardName_CellEditor = new KDTDefaultCellEditor(kdtStandardEntry_standardName_TextField);
        this.kdtStandardEntry.getColumn("standardName").setEditor(kdtStandardEntry_standardName_CellEditor);
        KDFormattedTextField kdtStandardEntry_grossProfit_TextField = new KDFormattedTextField();
        kdtStandardEntry_grossProfit_TextField.setName("kdtStandardEntry_grossProfit_TextField");
        kdtStandardEntry_grossProfit_TextField.setVisible(true);
        kdtStandardEntry_grossProfit_TextField.setEditable(true);
        kdtStandardEntry_grossProfit_TextField.setHorizontalAlignment(2);
        kdtStandardEntry_grossProfit_TextField.setDataType(1);
        	kdtStandardEntry_grossProfit_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtStandardEntry_grossProfit_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtStandardEntry_grossProfit_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtStandardEntry_grossProfit_CellEditor = new KDTDefaultCellEditor(kdtStandardEntry_grossProfit_TextField);
        this.kdtStandardEntry.getColumn("grossProfit").setEditor(kdtStandardEntry_grossProfit_CellEditor);
        KDFormattedTextField kdtStandardEntry_grossProfit2_TextField = new KDFormattedTextField();
        kdtStandardEntry_grossProfit2_TextField.setName("kdtStandardEntry_grossProfit2_TextField");
        kdtStandardEntry_grossProfit2_TextField.setVisible(true);
        kdtStandardEntry_grossProfit2_TextField.setEditable(true);
        kdtStandardEntry_grossProfit2_TextField.setHorizontalAlignment(2);
        kdtStandardEntry_grossProfit2_TextField.setDataType(1);
        	kdtStandardEntry_grossProfit2_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtStandardEntry_grossProfit2_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtStandardEntry_grossProfit2_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtStandardEntry_grossProfit2_CellEditor = new KDTDefaultCellEditor(kdtStandardEntry_grossProfit2_TextField);
        this.kdtStandardEntry.getColumn("grossProfit2").setEditor(kdtStandardEntry_grossProfit2_CellEditor);
        KDFormattedTextField kdtStandardEntry_grossProfit3_TextField = new KDFormattedTextField();
        kdtStandardEntry_grossProfit3_TextField.setName("kdtStandardEntry_grossProfit3_TextField");
        kdtStandardEntry_grossProfit3_TextField.setVisible(true);
        kdtStandardEntry_grossProfit3_TextField.setEditable(true);
        kdtStandardEntry_grossProfit3_TextField.setHorizontalAlignment(2);
        kdtStandardEntry_grossProfit3_TextField.setDataType(1);
        	kdtStandardEntry_grossProfit3_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtStandardEntry_grossProfit3_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtStandardEntry_grossProfit3_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtStandardEntry_grossProfit3_CellEditor = new KDTDefaultCellEditor(kdtStandardEntry_grossProfit3_TextField);
        this.kdtStandardEntry.getColumn("grossProfit3").setEditor(kdtStandardEntry_grossProfit3_CellEditor);
        KDCheckBox kdtStandardEntry_isUse_CheckBox = new KDCheckBox();
        kdtStandardEntry_isUse_CheckBox.setName("kdtStandardEntry_isUse_CheckBox");
        KDTDefaultCellEditor kdtStandardEntry_isUse_CellEditor = new KDTDefaultCellEditor(kdtStandardEntry_isUse_CheckBox);
        this.kdtStandardEntry.getColumn("isUse").setEditor(kdtStandardEntry_isUse_CellEditor);
        KDFormattedTextField kdtStandardEntry_useGroprofitNum_TextField = new KDFormattedTextField();
        kdtStandardEntry_useGroprofitNum_TextField.setName("kdtStandardEntry_useGroprofitNum_TextField");
        kdtStandardEntry_useGroprofitNum_TextField.setVisible(true);
        kdtStandardEntry_useGroprofitNum_TextField.setEditable(true);
        kdtStandardEntry_useGroprofitNum_TextField.setHorizontalAlignment(2);
        kdtStandardEntry_useGroprofitNum_TextField.setDataType(0);
        KDTDefaultCellEditor kdtStandardEntry_useGroprofitNum_CellEditor = new KDTDefaultCellEditor(kdtStandardEntry_useGroprofitNum_TextField);
        this.kdtStandardEntry.getColumn("useGroprofitNum").setEditor(kdtStandardEntry_useGroprofitNum_CellEditor);
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtcustomer,prmtbreedBatch,pkauditTime,txtfodderQty,txtdrugAmount,txtchikenQty,txtBigChikenWeight,txtbigChickenPrice,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,pkBIMUDF0004,pkBIMUDF0003,txtmeatPerFodder,txtfodderPerChicken,txtweightAvg,txtchickenCost,txtcustomerIncome,txtcustomerCost,txtsettlementStandard,txtcontractDIf,txtcustomerAllProfit,txtcompanyGrossProfit,txtcompanyAllProfit,kdtEntrys,kdtStandardEntry}));
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
        this.setLayout(null);
        contCreator.setBounds(new Rectangle(370, 571, 270, 19));
        this.add(contCreator, null);
        contCreateTime.setBounds(new Rectangle(370, 598, 270, 19));
        this.add(contCreateTime, null);
        contLastUpdateUser.setBounds(new Rectangle(726, 571, 270, 19));
        this.add(contLastUpdateUser, null);
        contLastUpdateTime.setBounds(new Rectangle(726, 598, 270, 19));
        this.add(contLastUpdateTime, null);
        contNumber.setBounds(new Rectangle(13, 14, 270, 19));
        this.add(contNumber, null);
        contBizDate.setBounds(new Rectangle(721, 19, 270, 19));
        this.add(contBizDate, null);
        contDescription.setBounds(new Rectangle(724, -236, 270, 19));
        this.add(contDescription, null);
        contAuditor.setBounds(new Rectangle(15, 571, 270, 19));
        this.add(contAuditor, null);
        contcustomer.setBounds(new Rectangle(375, 18, 270, 19));
        this.add(contcustomer, null);
        kDPanel1.setBounds(new Rectangle(9, 58, 994, 52));
        this.add(kDPanel1, null);
        kDPanel2.setBounds(new Rectangle(6, 123, 996, 191));
        this.add(kDPanel2, null);
        kDTabbedPane1.setBounds(new Rectangle(9, 321, 988, 243));
        this.add(kDTabbedPane1, null);
        contauditTime.setBounds(new Rectangle(15, 598, 270, 19));
        this.add(contauditTime, null);
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
        //contcustomer
        contcustomer.setBoundEditor(prmtcustomer);
        //kDPanel1
        kDPanel1.setLayout(null);        contBIMUDF0003.setBounds(new Rectangle(11, 13, 270, 19));
        kDPanel1.add(contBIMUDF0003, null);
        contBIMUDF0004.setBounds(new Rectangle(318, 18, 270, 19));
        kDPanel1.add(contBIMUDF0004, null);
        contbreedBatch.setBounds(new Rectangle(626, 15, 270, 19));
        kDPanel1.add(contbreedBatch, null);
        btnExcute.setBounds(new Rectangle(908, 15, 73, 21));
        kDPanel1.add(btnExcute, null);
        //contBIMUDF0003
        contBIMUDF0003.setBoundEditor(pkBIMUDF0003);
        //contBIMUDF0004
        contBIMUDF0004.setBoundEditor(pkBIMUDF0004);
        //contbreedBatch
        contbreedBatch.setBoundEditor(prmtbreedBatch);
        //kDPanel2
        kDPanel2.setLayout(null);        contfodderQty.setBounds(new Rectangle(23, 21, 270, 19));
        kDPanel2.add(contfodderQty, null);
        contdrugAmount.setBounds(new Rectangle(363, 17, 270, 19));
        kDPanel2.add(contdrugAmount, null);
        contchikenQty.setBounds(new Rectangle(704, 17, 270, 19));
        kDPanel2.add(contchikenQty, null);
        contBigChikenWeight.setBounds(new Rectangle(23, 47, 270, 19));
        kDPanel2.add(contBigChikenWeight, null);
        contcustomerAllProfit.setBounds(new Rectangle(363, 125, 270, 19));
        kDPanel2.add(contcustomerAllProfit, null);
        contcontractDIf.setBounds(new Rectangle(23, 125, 270, 19));
        kDPanel2.add(contcontractDIf, null);
        contsettlementStandard.setBounds(new Rectangle(704, 98, 270, 19));
        kDPanel2.add(contsettlementStandard, null);
        contcustomerCost.setBounds(new Rectangle(363, 98, 270, 19));
        kDPanel2.add(contcustomerCost, null);
        contcustomerIncome.setBounds(new Rectangle(23, 99, 270, 19));
        kDPanel2.add(contcustomerIncome, null);
        contchickenCost.setBounds(new Rectangle(704, 71, 270, 19));
        kDPanel2.add(contchickenCost, null);
        contweightAvg.setBounds(new Rectangle(704, 44, 270, 19));
        kDPanel2.add(contweightAvg, null);
        contfodderPerChicken.setBounds(new Rectangle(23, 73, 270, 19));
        kDPanel2.add(contfodderPerChicken, null);
        contmeatPerFodder.setBounds(new Rectangle(363, 71, 270, 19));
        kDPanel2.add(contmeatPerFodder, null);
        contbigChickenPrice.setBounds(new Rectangle(363, 44, 270, 19));
        kDPanel2.add(contbigChickenPrice, null);
        contcompanyGrossProfit.setBounds(new Rectangle(23, 155, 270, 19));
        kDPanel2.add(contcompanyGrossProfit, null);
        contcompanyAllProfit.setBounds(new Rectangle(363, 155, 270, 19));
        kDPanel2.add(contcompanyAllProfit, null);
        //contfodderQty
        contfodderQty.setBoundEditor(txtfodderQty);
        //contdrugAmount
        contdrugAmount.setBoundEditor(txtdrugAmount);
        //contchikenQty
        contchikenQty.setBoundEditor(txtchikenQty);
        //contBigChikenWeight
        contBigChikenWeight.setBoundEditor(txtBigChikenWeight);
        //contcustomerAllProfit
        contcustomerAllProfit.setBoundEditor(txtcustomerAllProfit);
        //contcontractDIf
        contcontractDIf.setBoundEditor(txtcontractDIf);
        //contsettlementStandard
        contsettlementStandard.setBoundEditor(txtsettlementStandard);
        //contcustomerCost
        contcustomerCost.setBoundEditor(txtcustomerCost);
        //contcustomerIncome
        contcustomerIncome.setBoundEditor(txtcustomerIncome);
        //contchickenCost
        contchickenCost.setBoundEditor(txtchickenCost);
        //contweightAvg
        contweightAvg.setBoundEditor(txtweightAvg);
        //contfodderPerChicken
        contfodderPerChicken.setBoundEditor(txtfodderPerChicken);
        //contmeatPerFodder
        contmeatPerFodder.setBoundEditor(txtmeatPerFodder);
        //contbigChickenPrice
        contbigChickenPrice.setBoundEditor(txtbigChickenPrice);
        //contcompanyGrossProfit
        contcompanyGrossProfit.setBoundEditor(txtcompanyGrossProfit);
        //contcompanyAllProfit
        contcompanyAllProfit.setBoundEditor(txtcompanyAllProfit);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        kDTabbedPane1.add(kDPanel4, resHelper.getString("kDPanel4.constraints"));
        //kDPanel3
        kDPanel3.setLayout(null);        kdtEntrys.setBounds(new Rectangle(2, 2, 980, 208));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.breed.FeedFettleEntryInfo(),null,false);
        kDPanel3.add(kdtEntrys_detailPanel, null);
        //kDPanel4
        kDPanel4.setLayout(null);        kdtStandardEntry.setBounds(new Rectangle(1, 1, 981, 208));
        kdtStandardEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtStandardEntry,new com.kingdee.eas.farm.breed.FeedFettleStandardEntryInfo(),null,false);
        kDPanel4.add(kdtStandardEntry_detailPanel, null);
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
        this.toolBar.add(btnPCVoucher);
        this.toolBar.add(btnDelPCVoucher);
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
		dataBinder.registerBinding("customer", com.kingdee.eas.basedata.master.cssp.CustomerInfo.class, this.prmtcustomer, "data");
		dataBinder.registerBinding("BIMUDF0003", java.util.Date.class, this.pkBIMUDF0003, "value");
		dataBinder.registerBinding("BIMUDF0004", java.util.Date.class, this.pkBIMUDF0004, "value");
		dataBinder.registerBinding("breedBatch", com.kingdee.eas.farm.breed.BreedBatchInfo.class, this.prmtbreedBatch, "data");
		dataBinder.registerBinding("fodderQty", java.math.BigDecimal.class, this.txtfodderQty, "value");
		dataBinder.registerBinding("drugAmount", java.math.BigDecimal.class, this.txtdrugAmount, "value");
		dataBinder.registerBinding("chikenQty", int.class, this.txtchikenQty, "value");
		dataBinder.registerBinding("BigChikenWeight", java.math.BigDecimal.class, this.txtBigChikenWeight, "value");
		dataBinder.registerBinding("customerAllProfit", java.math.BigDecimal.class, this.txtcustomerAllProfit, "value");
		dataBinder.registerBinding("contractDIf", java.math.BigDecimal.class, this.txtcontractDIf, "value");
		dataBinder.registerBinding("settlementStandard", java.math.BigDecimal.class, this.txtsettlementStandard, "value");
		dataBinder.registerBinding("customerCost", java.math.BigDecimal.class, this.txtcustomerCost, "value");
		dataBinder.registerBinding("customerIncome", java.math.BigDecimal.class, this.txtcustomerIncome, "value");
		dataBinder.registerBinding("chickenCost", java.math.BigDecimal.class, this.txtchickenCost, "value");
		dataBinder.registerBinding("weightAvg", java.math.BigDecimal.class, this.txtweightAvg, "value");
		dataBinder.registerBinding("fodderPerChicken", java.math.BigDecimal.class, this.txtfodderPerChicken, "value");
		dataBinder.registerBinding("meatPerFodder", java.math.BigDecimal.class, this.txtmeatPerFodder, "value");
		dataBinder.registerBinding("bigChickenPrice", java.math.BigDecimal.class, this.txtbigChickenPrice, "value");
		dataBinder.registerBinding("companyGrossProfit", java.math.BigDecimal.class, this.txtcompanyGrossProfit, "value");
		dataBinder.registerBinding("companyAllProfit", java.math.BigDecimal.class, this.txtcompanyAllProfit, "value");
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.breed.FeedFettleEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.billDate", java.util.Date.class, this.kdtEntrys, "billDate.text");
		dataBinder.registerBinding("entrys.billNumber", String.class, this.kdtEntrys, "billNumber.text");
		dataBinder.registerBinding("entrys.material", java.lang.Object.class, this.kdtEntrys, "material.text");
		dataBinder.registerBinding("entrys.materialName", String.class, this.kdtEntrys, "materialName.text");
		dataBinder.registerBinding("entrys.baseQty", java.math.BigDecimal.class, this.kdtEntrys, "baseQty.text");
		dataBinder.registerBinding("entrys.salePrice", java.math.BigDecimal.class, this.kdtEntrys, "salePrice.text");
		dataBinder.registerBinding("entrys.saleAmount", java.math.BigDecimal.class, this.kdtEntrys, "saleAmount.text");
		dataBinder.registerBinding("entrys.costPrice", java.math.BigDecimal.class, this.kdtEntrys, "costPrice.text");
		dataBinder.registerBinding("entrys.costAmount", java.math.BigDecimal.class, this.kdtEntrys, "costAmount.text");
		dataBinder.registerBinding("entrys.companyGrossProfit", java.math.BigDecimal.class, this.kdtEntrys, "companyGrossProfit.text");
		dataBinder.registerBinding("StandardEntry.seq", int.class, this.kdtStandardEntry, "seq.text");
		dataBinder.registerBinding("StandardEntry", com.kingdee.eas.farm.breed.FeedFettleStandardEntryInfo.class, this.kdtStandardEntry, "userObject");
		dataBinder.registerBinding("StandardEntry.standardNumber", java.lang.Object.class, this.kdtStandardEntry, "standardNumber.text");
		dataBinder.registerBinding("StandardEntry.standardName", String.class, this.kdtStandardEntry, "standardName.text");
		dataBinder.registerBinding("StandardEntry.grossProfit", java.math.BigDecimal.class, this.kdtStandardEntry, "grossProfit.text");
		dataBinder.registerBinding("StandardEntry.isUse", boolean.class, this.kdtStandardEntry, "isUse.text");
		dataBinder.registerBinding("StandardEntry.grossProfit2", java.math.BigDecimal.class, this.kdtStandardEntry, "grossProfit2.text");
		dataBinder.registerBinding("StandardEntry.grossProfit3", java.math.BigDecimal.class, this.kdtStandardEntry, "grossProfit3.text");
		dataBinder.registerBinding("StandardEntry.useGroprofitNum", int.class, this.kdtStandardEntry, "useGroprofitNum.text");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.breed.app.FeedFettleEditUIHandler";
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
        this.prmtcustomer.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.breed.FeedFettleInfo)ov;
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
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("customer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BIMUDF0003", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BIMUDF0004", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fodderQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("drugAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chikenQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BigChikenWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("customerAllProfit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contractDIf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("settlementStandard", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("customerCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("customerIncome", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("weightAvg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fodderPerChicken", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("meatPerFodder", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bigChickenPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("companyGrossProfit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("companyAllProfit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.billDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.billNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.materialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.baseQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.salePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.saleAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.costPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.costAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.companyGrossProfit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StandardEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StandardEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StandardEntry.standardNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StandardEntry.standardName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StandardEntry.grossProfit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StandardEntry.isUse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StandardEntry.grossProfit2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StandardEntry.grossProfit3", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StandardEntry.useGroprofitNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    		
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
kdtEntrys.getCell(rowIndex,"materialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"material").getValue(),"name")));

}


    }

    /**
     * output kdtStandardEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtStandardEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("standardNumber".equalsIgnoreCase(kdtStandardEntry.getColumn(colIndex).getKey())) {
kdtStandardEntry.getCell(rowIndex,"standardName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtStandardEntry.getCell(rowIndex,"standardNumber").getValue(),"name")));

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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("customer.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("customer.id"));
        	sic.add(new SelectorItemInfo("customer.number"));
        	sic.add(new SelectorItemInfo("customer.name"));
		}
        sic.add(new SelectorItemInfo("BIMUDF0003"));
        sic.add(new SelectorItemInfo("BIMUDF0004"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("breedBatch.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("breedBatch.id"));
        	sic.add(new SelectorItemInfo("breedBatch.number"));
		}
        sic.add(new SelectorItemInfo("fodderQty"));
        sic.add(new SelectorItemInfo("drugAmount"));
        sic.add(new SelectorItemInfo("chikenQty"));
        sic.add(new SelectorItemInfo("BigChikenWeight"));
        sic.add(new SelectorItemInfo("customerAllProfit"));
        sic.add(new SelectorItemInfo("contractDIf"));
        sic.add(new SelectorItemInfo("settlementStandard"));
        sic.add(new SelectorItemInfo("customerCost"));
        sic.add(new SelectorItemInfo("customerIncome"));
        sic.add(new SelectorItemInfo("chickenCost"));
        sic.add(new SelectorItemInfo("weightAvg"));
        sic.add(new SelectorItemInfo("fodderPerChicken"));
        sic.add(new SelectorItemInfo("meatPerFodder"));
        sic.add(new SelectorItemInfo("bigChickenPrice"));
        sic.add(new SelectorItemInfo("companyGrossProfit"));
        sic.add(new SelectorItemInfo("companyAllProfit"));
    	sic.add(new SelectorItemInfo("entrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("entrys.billDate"));
    	sic.add(new SelectorItemInfo("entrys.billNumber"));
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
    	sic.add(new SelectorItemInfo("entrys.baseQty"));
    	sic.add(new SelectorItemInfo("entrys.salePrice"));
    	sic.add(new SelectorItemInfo("entrys.saleAmount"));
    	sic.add(new SelectorItemInfo("entrys.costPrice"));
    	sic.add(new SelectorItemInfo("entrys.costAmount"));
    	sic.add(new SelectorItemInfo("entrys.companyGrossProfit"));
    	sic.add(new SelectorItemInfo("StandardEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("StandardEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("StandardEntry.standardNumber.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("StandardEntry.standardNumber.id"));
			sic.add(new SelectorItemInfo("StandardEntry.standardNumber.number"));
			sic.add(new SelectorItemInfo("StandardEntry.standardNumber.name"));
		}
    	sic.add(new SelectorItemInfo("StandardEntry.standardName"));
    	sic.add(new SelectorItemInfo("StandardEntry.grossProfit"));
    	sic.add(new SelectorItemInfo("StandardEntry.isUse"));
    	sic.add(new SelectorItemInfo("StandardEntry.grossProfit2"));
    	sic.add(new SelectorItemInfo("StandardEntry.grossProfit3"));
    	sic.add(new SelectorItemInfo("StandardEntry.useGroprofitNum"));
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

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.breed.client", "FeedFettleEditUI");
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
        return com.kingdee.eas.farm.breed.client.FeedFettleEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.breed.FeedFettleFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.breed.FeedFettleInfo objectValue = new com.kingdee.eas.farm.breed.FeedFettleInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/breed/FeedFettle";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.breed.app.FeedFettleQuery");
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
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}