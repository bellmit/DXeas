/**
 * output package name
 */
package com.kingdee.eas.farm.dayratecost.client;

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
public abstract class AbstractDayRateInitBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractDayRateInitBillEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator9;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisInit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperiod;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedStage;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstockingFarmer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstockingHouse;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstockingBatch;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstockingFarm;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisStageBalance;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperiod;
    protected com.kingdee.bos.ctrl.swing.KDComboBox breedStage;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstockingFarmer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstockingHouse;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstockingBatch;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstockingFarm;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntryDetail;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntryDetail_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallArAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallArAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbeginBreedQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoccurBreedQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contendBreedQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbeginFemaleQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoccrFemaleQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contendFemaleQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contworkQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contavgWorkQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsumWorkQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contavgSumWorkQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbeginBreedQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoccurBreedQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtendBreedQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbeginFemaleQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoccrFemaleQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtendFemaleQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtworkQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtavgWorkQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsumWorkQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtavgSumWorkQty;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDSeparator newSeparator3;
    protected com.kingdee.eas.farm.dayratecost.DayRateInitBillInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionInitialize actionInitialize = null;
    protected ActionUnInitialize actionUnInitialize = null;
    /**
     * output class constructor
     */
    public AbstractDayRateInitBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractDayRateInitBillEditUI.class.getName());
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
        //actionInitialize
        this.actionInitialize = new ActionInitialize(this);
        getActionManager().registerAction("actionInitialize", actionInitialize);
        this.actionInitialize.setExtendProperty("canForewarn", "true");
        this.actionInitialize.setExtendProperty("userDefined", "false");
        this.actionInitialize.setExtendProperty("isObjectUpdateLock", "false");
         this.actionInitialize.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionInitialize.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionUnInitialize
        this.actionUnInitialize = new ActionUnInitialize(this);
        getActionManager().registerAction("actionUnInitialize", actionUnInitialize);
        this.actionUnInitialize.setExtendProperty("canForewarn", "true");
        this.actionUnInitialize.setExtendProperty("userDefined", "false");
        this.actionUnInitialize.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnInitialize.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnInitialize.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDSeparator9 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.chkisInit = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contperiod = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbreedStage = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstockingFarmer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstockingHouse = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstockingBatch = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstockingFarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisStageBalance = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtperiod = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.breedStage = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtstockingFarmer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtstockingHouse = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtstockingBatch = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtstockingFarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtEntryDetail = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contallArAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtallArAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contbeginBreedQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoccurBreedQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contendBreedQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbeginFemaleQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoccrFemaleQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contendFemaleQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contworkQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contavgWorkQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsumWorkQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contavgSumWorkQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtbeginBreedQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtoccurBreedQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtendBreedQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbeginFemaleQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtoccrFemaleQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtendFemaleQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtworkQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtavgWorkQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsumWorkQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtavgSumWorkQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
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
        this.contcompany.setName("contcompany");
        this.contauditTime.setName("contauditTime");
        this.kDSeparator8.setName("kDSeparator8");
        this.kDSeparator9.setName("kDSeparator9");
        this.chkisInit.setName("chkisInit");
        this.contperiod.setName("contperiod");
        this.contbreedStage.setName("contbreedStage");
        this.contstockingFarmer.setName("contstockingFarmer");
        this.contstockingHouse.setName("contstockingHouse");
        this.contstockingBatch.setName("contstockingBatch");
        this.contstockingFarm.setName("contstockingFarm");
        this.chkisStageBalance.setName("chkisStageBalance");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.billStatus.setName("billStatus");
        this.prmtcompany.setName("prmtcompany");
        this.pkauditTime.setName("pkauditTime");
        this.prmtperiod.setName("prmtperiod");
        this.breedStage.setName("breedStage");
        this.prmtstockingFarmer.setName("prmtstockingFarmer");
        this.prmtstockingHouse.setName("prmtstockingHouse");
        this.prmtstockingBatch.setName("prmtstockingBatch");
        this.prmtstockingFarm.setName("prmtstockingFarm");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel3.setName("kDPanel3");
        this.kdtEntrys.setName("kdtEntrys");
        this.kdtEntryDetail.setName("kdtEntryDetail");
        this.contallArAmount.setName("contallArAmount");
        this.txtallArAmount.setName("txtallArAmount");
        this.contbeginBreedQty.setName("contbeginBreedQty");
        this.contoccurBreedQty.setName("contoccurBreedQty");
        this.contendBreedQty.setName("contendBreedQty");
        this.contbeginFemaleQty.setName("contbeginFemaleQty");
        this.contoccrFemaleQty.setName("contoccrFemaleQty");
        this.contendFemaleQty.setName("contendFemaleQty");
        this.contworkQty.setName("contworkQty");
        this.contavgWorkQty.setName("contavgWorkQty");
        this.contsumWorkQty.setName("contsumWorkQty");
        this.contavgSumWorkQty.setName("contavgSumWorkQty");
        this.txtbeginBreedQty.setName("txtbeginBreedQty");
        this.txtoccurBreedQty.setName("txtoccurBreedQty");
        this.txtendBreedQty.setName("txtendBreedQty");
        this.txtbeginFemaleQty.setName("txtbeginFemaleQty");
        this.txtoccrFemaleQty.setName("txtoccrFemaleQty");
        this.txtendFemaleQty.setName("txtendFemaleQty");
        this.txtworkQty.setName("txtworkQty");
        this.txtavgWorkQty.setName("txtavgWorkQty");
        this.txtsumWorkQty.setName("txtsumWorkQty");
        this.txtavgSumWorkQty.setName("txtavgSumWorkQty");
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
        // chkisInit		
        this.chkisInit.setText(resHelper.getString("chkisInit.text"));		
        this.chkisInit.setHorizontalAlignment(2);
        // contperiod		
        this.contperiod.setBoundLabelText(resHelper.getString("contperiod.boundLabelText"));		
        this.contperiod.setBoundLabelLength(100);		
        this.contperiod.setBoundLabelUnderline(true);		
        this.contperiod.setVisible(true);
        // contbreedStage		
        this.contbreedStage.setBoundLabelText(resHelper.getString("contbreedStage.boundLabelText"));		
        this.contbreedStage.setBoundLabelLength(100);		
        this.contbreedStage.setBoundLabelUnderline(true);		
        this.contbreedStage.setVisible(true);
        // contstockingFarmer		
        this.contstockingFarmer.setBoundLabelText(resHelper.getString("contstockingFarmer.boundLabelText"));		
        this.contstockingFarmer.setBoundLabelLength(100);		
        this.contstockingFarmer.setBoundLabelUnderline(true);		
        this.contstockingFarmer.setVisible(true);
        // contstockingHouse		
        this.contstockingHouse.setBoundLabelText(resHelper.getString("contstockingHouse.boundLabelText"));		
        this.contstockingHouse.setBoundLabelLength(100);		
        this.contstockingHouse.setBoundLabelUnderline(true);		
        this.contstockingHouse.setVisible(true);
        // contstockingBatch		
        this.contstockingBatch.setBoundLabelText(resHelper.getString("contstockingBatch.boundLabelText"));		
        this.contstockingBatch.setBoundLabelLength(100);		
        this.contstockingBatch.setBoundLabelUnderline(true);		
        this.contstockingBatch.setVisible(true);
        // contstockingFarm		
        this.contstockingFarm.setBoundLabelText(resHelper.getString("contstockingFarm.boundLabelText"));		
        this.contstockingFarm.setBoundLabelLength(100);		
        this.contstockingFarm.setBoundLabelUnderline(true);		
        this.contstockingFarm.setVisible(true);
        // chkisStageBalance		
        this.chkisStageBalance.setText(resHelper.getString("chkisStageBalance.text"));		
        this.chkisStageBalance.setHorizontalAlignment(2);
        // kDTabbedPane1
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
        // prmtperiod		
        this.prmtperiod.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7PeriodQuery");		
        this.prmtperiod.setEditable(true);		
        this.prmtperiod.setDisplayFormat("$number$");		
        this.prmtperiod.setEditFormat("$number$");		
        this.prmtperiod.setCommitFormat("$number$");		
        this.prmtperiod.setRequired(false);
        // breedStage		
        this.breedStage.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.FarmStageEnum").toArray());		
        this.breedStage.setRequired(false);
        // prmtstockingFarmer		
        this.prmtstockingFarmer.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmersQuery");		
        this.prmtstockingFarmer.setEditable(true);		
        this.prmtstockingFarmer.setDisplayFormat("$name$");		
        this.prmtstockingFarmer.setEditFormat("$number$");		
        this.prmtstockingFarmer.setCommitFormat("$number$");		
        this.prmtstockingFarmer.setRequired(false);
        		prmtstockingFarmer.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI prmtstockingFarmer_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtstockingFarmer_F7ListUI == null) {
					try {
						prmtstockingFarmer_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtstockingFarmer_F7ListUI));
					prmtstockingFarmer_F7ListUI.setF7Use(true,ctx);
					prmtstockingFarmer.setSelector(prmtstockingFarmer_F7ListUI);
				}
			}
		});
					
        // prmtstockingHouse		
        this.prmtstockingHouse.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");		
        this.prmtstockingHouse.setEditable(true);		
        this.prmtstockingHouse.setDisplayFormat("$name$");		
        this.prmtstockingHouse.setEditFormat("$number$");		
        this.prmtstockingHouse.setCommitFormat("$number$");		
        this.prmtstockingHouse.setRequired(false);
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
					
        // prmtstockingFarm		
        this.prmtstockingFarm.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmQuery");		
        this.prmtstockingFarm.setEditable(true);		
        this.prmtstockingFarm.setDisplayFormat("$name$");		
        this.prmtstockingFarm.setEditFormat("$number$");		
        this.prmtstockingFarm.setCommitFormat("$number$");		
        this.prmtstockingFarm.setRequired(false);
        		prmtstockingFarm.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmListUI prmtstockingFarm_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtstockingFarm_F7ListUI == null) {
					try {
						prmtstockingFarm_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtstockingFarm_F7ListUI));
					prmtstockingFarm_F7ListUI.setF7Use(true,ctx);
					prmtstockingFarm.setSelector(prmtstockingFarm_F7ListUI);
				}
			}
		});
					
        // kDPanel1
        // kDPanel2
        // kDPanel3
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"costItem\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"ItemName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"beginCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"beginQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"occurQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"occurCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"endCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"endQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"arAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{costItem}</t:Cell><t:Cell>$Resource{ItemName}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{beginCost}</t:Cell><t:Cell>$Resource{beginQty}</t:Cell><t:Cell>$Resource{occurQty}</t:Cell><t:Cell>$Resource{occurCost}</t:Cell><t:Cell>$Resource{endCost}</t:Cell><t:Cell>$Resource{endQty}</t:Cell><t:Cell>$Resource{arAmount}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtEntrys.putBindContents("editData",new String[] {"id","costItem","ItemName","unit","beginCost","beginQty","occurQty","occurCost","endCost","endQty","arAmount"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_costItem_PromptBox = new KDBizPromptBox();
        kdtEntrys_costItem_PromptBox.setQueryInfo("com.kingdee.eas.basedata.cm.app.F7CostItemQuery");
        kdtEntrys_costItem_PromptBox.setVisible(true);
        kdtEntrys_costItem_PromptBox.setEditable(true);
        kdtEntrys_costItem_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_costItem_PromptBox.setEditFormat("$number$");
        kdtEntrys_costItem_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_costItem_CellEditor = new KDTDefaultCellEditor(kdtEntrys_costItem_PromptBox);
        this.kdtEntrys.getColumn("costItem").setEditor(kdtEntrys_costItem_CellEditor);
        ObjectValueRender kdtEntrys_costItem_OVR = new ObjectValueRender();
        kdtEntrys_costItem_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("costItem").setRenderer(kdtEntrys_costItem_OVR);
        KDTextField kdtEntrys_ItemName_TextField = new KDTextField();
        kdtEntrys_ItemName_TextField.setName("kdtEntrys_ItemName_TextField");
        kdtEntrys_ItemName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_ItemName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_ItemName_TextField);
        this.kdtEntrys.getColumn("ItemName").setEditor(kdtEntrys_ItemName_CellEditor);
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
        KDFormattedTextField kdtEntrys_beginCost_TextField = new KDFormattedTextField();
        kdtEntrys_beginCost_TextField.setName("kdtEntrys_beginCost_TextField");
        kdtEntrys_beginCost_TextField.setVisible(true);
        kdtEntrys_beginCost_TextField.setEditable(true);
        kdtEntrys_beginCost_TextField.setHorizontalAlignment(2);
        kdtEntrys_beginCost_TextField.setDataType(1);
        	kdtEntrys_beginCost_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_beginCost_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_beginCost_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_beginCost_CellEditor = new KDTDefaultCellEditor(kdtEntrys_beginCost_TextField);
        this.kdtEntrys.getColumn("beginCost").setEditor(kdtEntrys_beginCost_CellEditor);
        KDFormattedTextField kdtEntrys_beginQty_TextField = new KDFormattedTextField();
        kdtEntrys_beginQty_TextField.setName("kdtEntrys_beginQty_TextField");
        kdtEntrys_beginQty_TextField.setVisible(true);
        kdtEntrys_beginQty_TextField.setEditable(true);
        kdtEntrys_beginQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_beginQty_TextField.setDataType(1);
        	kdtEntrys_beginQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_beginQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_beginQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_beginQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_beginQty_TextField);
        this.kdtEntrys.getColumn("beginQty").setEditor(kdtEntrys_beginQty_CellEditor);
        KDFormattedTextField kdtEntrys_occurQty_TextField = new KDFormattedTextField();
        kdtEntrys_occurQty_TextField.setName("kdtEntrys_occurQty_TextField");
        kdtEntrys_occurQty_TextField.setVisible(true);
        kdtEntrys_occurQty_TextField.setEditable(true);
        kdtEntrys_occurQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_occurQty_TextField.setDataType(1);
        	kdtEntrys_occurQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_occurQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_occurQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_occurQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_occurQty_TextField);
        this.kdtEntrys.getColumn("occurQty").setEditor(kdtEntrys_occurQty_CellEditor);
        KDFormattedTextField kdtEntrys_occurCost_TextField = new KDFormattedTextField();
        kdtEntrys_occurCost_TextField.setName("kdtEntrys_occurCost_TextField");
        kdtEntrys_occurCost_TextField.setVisible(true);
        kdtEntrys_occurCost_TextField.setEditable(true);
        kdtEntrys_occurCost_TextField.setHorizontalAlignment(2);
        kdtEntrys_occurCost_TextField.setDataType(1);
        	kdtEntrys_occurCost_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_occurCost_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_occurCost_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_occurCost_CellEditor = new KDTDefaultCellEditor(kdtEntrys_occurCost_TextField);
        this.kdtEntrys.getColumn("occurCost").setEditor(kdtEntrys_occurCost_CellEditor);
        KDFormattedTextField kdtEntrys_endCost_TextField = new KDFormattedTextField();
        kdtEntrys_endCost_TextField.setName("kdtEntrys_endCost_TextField");
        kdtEntrys_endCost_TextField.setVisible(true);
        kdtEntrys_endCost_TextField.setEditable(true);
        kdtEntrys_endCost_TextField.setHorizontalAlignment(2);
        kdtEntrys_endCost_TextField.setDataType(1);
        	kdtEntrys_endCost_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_endCost_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_endCost_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_endCost_CellEditor = new KDTDefaultCellEditor(kdtEntrys_endCost_TextField);
        this.kdtEntrys.getColumn("endCost").setEditor(kdtEntrys_endCost_CellEditor);
        KDFormattedTextField kdtEntrys_endQty_TextField = new KDFormattedTextField();
        kdtEntrys_endQty_TextField.setName("kdtEntrys_endQty_TextField");
        kdtEntrys_endQty_TextField.setVisible(true);
        kdtEntrys_endQty_TextField.setEditable(true);
        kdtEntrys_endQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_endQty_TextField.setDataType(1);
        	kdtEntrys_endQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_endQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_endQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_endQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_endQty_TextField);
        this.kdtEntrys.getColumn("endQty").setEditor(kdtEntrys_endQty_CellEditor);
        KDFormattedTextField kdtEntrys_arAmount_TextField = new KDFormattedTextField();
        kdtEntrys_arAmount_TextField.setName("kdtEntrys_arAmount_TextField");
        kdtEntrys_arAmount_TextField.setVisible(true);
        kdtEntrys_arAmount_TextField.setEditable(true);
        kdtEntrys_arAmount_TextField.setHorizontalAlignment(2);
        kdtEntrys_arAmount_TextField.setDataType(1);
        	kdtEntrys_arAmount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_arAmount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_arAmount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_arAmount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_arAmount_TextField);
        this.kdtEntrys.getColumn("arAmount").setEditor(kdtEntrys_arAmount_CellEditor);
        // kdtEntryDetail
		String kdtEntryDetailStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"itemName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"itemID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{itemName}</t:Cell><t:Cell>$Resource{itemID}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntryDetail.setFormatXml(resHelper.translateString("kdtEntryDetail",kdtEntryDetailStrXML));

                this.kdtEntryDetail.putBindContents("editData",new String[] {"EntryDetail.seq","EntryDetail.amount","EntryDetail.itemName","EntryDetail.itemID"});


        this.kdtEntryDetail.checkParsed();
        KDFormattedTextField kdtEntryDetail_seq_TextField = new KDFormattedTextField();
        kdtEntryDetail_seq_TextField.setName("kdtEntryDetail_seq_TextField");
        kdtEntryDetail_seq_TextField.setVisible(true);
        kdtEntryDetail_seq_TextField.setEditable(true);
        kdtEntryDetail_seq_TextField.setHorizontalAlignment(2);
        kdtEntryDetail_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntryDetail_seq_CellEditor = new KDTDefaultCellEditor(kdtEntryDetail_seq_TextField);
        this.kdtEntryDetail.getColumn("seq").setEditor(kdtEntryDetail_seq_CellEditor);
        KDFormattedTextField kdtEntryDetail_amount_TextField = new KDFormattedTextField();
        kdtEntryDetail_amount_TextField.setName("kdtEntryDetail_amount_TextField");
        kdtEntryDetail_amount_TextField.setVisible(true);
        kdtEntryDetail_amount_TextField.setEditable(true);
        kdtEntryDetail_amount_TextField.setHorizontalAlignment(2);
        kdtEntryDetail_amount_TextField.setDataType(1);
        	kdtEntryDetail_amount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntryDetail_amount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntryDetail_amount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntryDetail_amount_CellEditor = new KDTDefaultCellEditor(kdtEntryDetail_amount_TextField);
        this.kdtEntryDetail.getColumn("amount").setEditor(kdtEntryDetail_amount_CellEditor);
        KDTextField kdtEntryDetail_itemName_TextField = new KDTextField();
        kdtEntryDetail_itemName_TextField.setName("kdtEntryDetail_itemName_TextField");
        kdtEntryDetail_itemName_TextField.setMaxLength(200);
        KDTDefaultCellEditor kdtEntryDetail_itemName_CellEditor = new KDTDefaultCellEditor(kdtEntryDetail_itemName_TextField);
        this.kdtEntryDetail.getColumn("itemName").setEditor(kdtEntryDetail_itemName_CellEditor);
        KDTextField kdtEntryDetail_itemID_TextField = new KDTextField();
        kdtEntryDetail_itemID_TextField.setName("kdtEntryDetail_itemID_TextField");
        kdtEntryDetail_itemID_TextField.setMaxLength(60);
        KDTDefaultCellEditor kdtEntryDetail_itemID_CellEditor = new KDTDefaultCellEditor(kdtEntryDetail_itemID_TextField);
        this.kdtEntryDetail.getColumn("itemID").setEditor(kdtEntryDetail_itemID_CellEditor);
        // contallArAmount		
        this.contallArAmount.setBoundLabelText(resHelper.getString("contallArAmount.boundLabelText"));		
        this.contallArAmount.setBoundLabelLength(100);		
        this.contallArAmount.setBoundLabelUnderline(true);		
        this.contallArAmount.setVisible(true);
        // txtallArAmount		
        this.txtallArAmount.setHorizontalAlignment(2);		
        this.txtallArAmount.setDataType(1);		
        this.txtallArAmount.setSupportedEmpty(true);		
        this.txtallArAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallArAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallArAmount.setPrecision(2);		
        this.txtallArAmount.setRequired(false);
        // contbeginBreedQty		
        this.contbeginBreedQty.setBoundLabelText(resHelper.getString("contbeginBreedQty.boundLabelText"));		
        this.contbeginBreedQty.setBoundLabelLength(100);		
        this.contbeginBreedQty.setBoundLabelUnderline(true);		
        this.contbeginBreedQty.setVisible(true);
        // contoccurBreedQty		
        this.contoccurBreedQty.setBoundLabelText(resHelper.getString("contoccurBreedQty.boundLabelText"));		
        this.contoccurBreedQty.setBoundLabelLength(100);		
        this.contoccurBreedQty.setBoundLabelUnderline(true);		
        this.contoccurBreedQty.setVisible(true);
        // contendBreedQty		
        this.contendBreedQty.setBoundLabelText(resHelper.getString("contendBreedQty.boundLabelText"));		
        this.contendBreedQty.setBoundLabelLength(100);		
        this.contendBreedQty.setBoundLabelUnderline(true);		
        this.contendBreedQty.setVisible(true);
        // contbeginFemaleQty		
        this.contbeginFemaleQty.setBoundLabelText(resHelper.getString("contbeginFemaleQty.boundLabelText"));		
        this.contbeginFemaleQty.setBoundLabelLength(100);		
        this.contbeginFemaleQty.setBoundLabelUnderline(true);		
        this.contbeginFemaleQty.setVisible(true);
        // contoccrFemaleQty		
        this.contoccrFemaleQty.setBoundLabelText(resHelper.getString("contoccrFemaleQty.boundLabelText"));		
        this.contoccrFemaleQty.setBoundLabelLength(100);		
        this.contoccrFemaleQty.setBoundLabelUnderline(true);		
        this.contoccrFemaleQty.setVisible(true);
        // contendFemaleQty		
        this.contendFemaleQty.setBoundLabelText(resHelper.getString("contendFemaleQty.boundLabelText"));		
        this.contendFemaleQty.setBoundLabelLength(100);		
        this.contendFemaleQty.setBoundLabelUnderline(true);		
        this.contendFemaleQty.setVisible(true);
        // contworkQty		
        this.contworkQty.setBoundLabelText(resHelper.getString("contworkQty.boundLabelText"));		
        this.contworkQty.setBoundLabelLength(100);		
        this.contworkQty.setBoundLabelUnderline(true);		
        this.contworkQty.setVisible(true);
        // contavgWorkQty		
        this.contavgWorkQty.setBoundLabelText(resHelper.getString("contavgWorkQty.boundLabelText"));		
        this.contavgWorkQty.setBoundLabelLength(100);		
        this.contavgWorkQty.setBoundLabelUnderline(true);		
        this.contavgWorkQty.setVisible(true);
        // contsumWorkQty		
        this.contsumWorkQty.setBoundLabelText(resHelper.getString("contsumWorkQty.boundLabelText"));		
        this.contsumWorkQty.setBoundLabelLength(100);		
        this.contsumWorkQty.setBoundLabelUnderline(true);		
        this.contsumWorkQty.setVisible(true);
        // contavgSumWorkQty		
        this.contavgSumWorkQty.setBoundLabelText(resHelper.getString("contavgSumWorkQty.boundLabelText"));		
        this.contavgSumWorkQty.setBoundLabelLength(100);		
        this.contavgSumWorkQty.setBoundLabelUnderline(true);		
        this.contavgSumWorkQty.setVisible(true);
        // txtbeginBreedQty		
        this.txtbeginBreedQty.setHorizontalAlignment(2);		
        this.txtbeginBreedQty.setDataType(0);		
        this.txtbeginBreedQty.setSupportedEmpty(true);		
        this.txtbeginBreedQty.setRequired(false);
        txtbeginBreedQty.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				txtbeginBreedQty_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtoccurBreedQty		
        this.txtoccurBreedQty.setHorizontalAlignment(2);		
        this.txtoccurBreedQty.setDataType(0);		
        this.txtoccurBreedQty.setSupportedEmpty(true);		
        this.txtoccurBreedQty.setRequired(false);
        txtoccurBreedQty.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				txtoccurBreedQty_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtendBreedQty		
        this.txtendBreedQty.setHorizontalAlignment(2);		
        this.txtendBreedQty.setDataType(0);		
        this.txtendBreedQty.setSupportedEmpty(true);		
        this.txtendBreedQty.setRequired(false);
        txtendBreedQty.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				txtendBreedQty_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtbeginFemaleQty		
        this.txtbeginFemaleQty.setHorizontalAlignment(2);		
        this.txtbeginFemaleQty.setDataType(0);		
        this.txtbeginFemaleQty.setSupportedEmpty(true);		
        this.txtbeginFemaleQty.setRequired(false);
        // txtoccrFemaleQty		
        this.txtoccrFemaleQty.setHorizontalAlignment(2);		
        this.txtoccrFemaleQty.setDataType(0);		
        this.txtoccrFemaleQty.setSupportedEmpty(true);		
        this.txtoccrFemaleQty.setRequired(false);
        // txtendFemaleQty		
        this.txtendFemaleQty.setHorizontalAlignment(2);		
        this.txtendFemaleQty.setDataType(0);		
        this.txtendFemaleQty.setSupportedEmpty(true);		
        this.txtendFemaleQty.setRequired(false);
        // txtworkQty		
        this.txtworkQty.setHorizontalAlignment(2);		
        this.txtworkQty.setDataType(0);		
        this.txtworkQty.setSupportedEmpty(true);		
        this.txtworkQty.setRequired(false);
        // txtavgWorkQty		
        this.txtavgWorkQty.setHorizontalAlignment(2);		
        this.txtavgWorkQty.setDataType(0);		
        this.txtavgWorkQty.setSupportedEmpty(true);		
        this.txtavgWorkQty.setRequired(false);
        // txtsumWorkQty		
        this.txtsumWorkQty.setHorizontalAlignment(2);		
        this.txtsumWorkQty.setDataType(0);		
        this.txtsumWorkQty.setSupportedEmpty(true);		
        this.txtsumWorkQty.setRequired(false);
        // txtavgSumWorkQty		
        this.txtavgSumWorkQty.setHorizontalAlignment(2);		
        this.txtavgSumWorkQty.setDataType(0);		
        this.txtavgSumWorkQty.setSupportedEmpty(true);		
        this.txtavgSumWorkQty.setRequired(false);
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
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {kdtEntryDetail,txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,billStatus,prmtcompany,pkauditTime,chkisInit,prmtperiod,txtbeginBreedQty,txtoccurBreedQty,txtendBreedQty,breedStage,prmtstockingFarmer,prmtstockingHouse,prmtstockingBatch,prmtstockingFarm,chkisStageBalance,txtallArAmount,txtbeginFemaleQty,txtoccrFemaleQty,txtendFemaleQty,txtworkQty,txtavgWorkQty,txtsumWorkQty,txtavgSumWorkQty,kdtEntrys}));
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
        contCreator.setBounds(new Rectangle(356, 559, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(356, 559, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(690, 559, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(690, 559, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(356, 591, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(356, 591, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(690, 591, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(690, 591, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(20, 10, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(20, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(356, 10, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(356, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(690, 40, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(690, 40, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(29, 559, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(29, 559, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(690, 10, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(690, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompany.setBounds(new Rectangle(20, 40, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(20, 40, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(29, 591, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(29, 591, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator8.setBounds(new Rectangle(18, 548, 980, 10));
        this.add(kDSeparator8, new KDLayout.Constraints(18, 548, 980, 10, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator9.setBounds(new Rectangle(6, 126, 986, 8));
        this.add(kDSeparator9, new KDLayout.Constraints(6, 126, 986, 8, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisInit.setBounds(new Rectangle(690, 103, 94, 19));
        this.add(chkisInit, new KDLayout.Constraints(690, 103, 94, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contperiod.setBounds(new Rectangle(356, 40, 270, 19));
        this.add(contperiod, new KDLayout.Constraints(356, 40, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbreedStage.setBounds(new Rectangle(356, 102, 270, 19));
        this.add(contbreedStage, new KDLayout.Constraints(356, 102, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contstockingFarmer.setBounds(new Rectangle(20, 69, 270, 19));
        this.add(contstockingFarmer, new KDLayout.Constraints(20, 69, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contstockingHouse.setBounds(new Rectangle(690, 71, 270, 19));
        this.add(contstockingHouse, new KDLayout.Constraints(690, 71, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contstockingBatch.setBounds(new Rectangle(20, 102, 270, 19));
        this.add(contstockingBatch, new KDLayout.Constraints(20, 102, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contstockingFarm.setBounds(new Rectangle(356, 69, 270, 19));
        this.add(contstockingFarm, new KDLayout.Constraints(356, 69, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisStageBalance.setBounds(new Rectangle(814, 103, 146, 19));
        this.add(chkisStageBalance, new KDLayout.Constraints(814, 103, 146, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDTabbedPane1.setBounds(new Rectangle(17, 136, 975, 405));
        this.add(kDTabbedPane1, new KDLayout.Constraints(17, 136, 975, 405, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contperiod
        contperiod.setBoundEditor(prmtperiod);
        //contbreedStage
        contbreedStage.setBoundEditor(breedStage);
        //contstockingFarmer
        contstockingFarmer.setBoundEditor(prmtstockingFarmer);
        //contstockingHouse
        contstockingHouse.setBoundEditor(prmtstockingHouse);
        //contstockingBatch
        contstockingBatch.setBoundEditor(prmtstockingBatch);
        //contstockingFarm
        contstockingFarm.setBoundEditor(prmtstockingFarm);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 974, 372));        kdtEntrys.setBounds(new Rectangle(2, 2, 969, 160));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.dayratecost.DayRateInitBillEntryInfo(),null,false);
        kDPanel1.add(kdtEntrys_detailPanel, new KDLayout.Constraints(2, 2, 969, 160, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kdtEntryDetail.setBounds(new Rectangle(2, 168, 966, 205));
        kdtEntryDetail_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntryDetail,new com.kingdee.eas.farm.dayratecost.DayRateInitBillEntryEntryDetailInfo(),null,false);
        kDPanel1.add(kdtEntryDetail_detailPanel, new KDLayout.Constraints(2, 168, 966, 205, 0));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 974, 372));        contallArAmount.setBounds(new Rectangle(10, 5, 270, 19));
        kDPanel2.add(contallArAmount, new KDLayout.Constraints(10, 5, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contallArAmount
        contallArAmount.setBoundEditor(txtallArAmount);
        //kDPanel3
        kDPanel3.setLayout(new KDLayout());
        kDPanel3.putClientProperty("OriginalBounds", new Rectangle(0, 0, 974, 372));        contbeginBreedQty.setBounds(new Rectangle(37, 21, 270, 19));
        kDPanel3.add(contbeginBreedQty, new KDLayout.Constraints(37, 21, 270, 19, 0));
        contoccurBreedQty.setBounds(new Rectangle(351, 21, 270, 19));
        kDPanel3.add(contoccurBreedQty, new KDLayout.Constraints(351, 21, 270, 19, 0));
        contendBreedQty.setBounds(new Rectangle(666, 21, 270, 19));
        kDPanel3.add(contendBreedQty, new KDLayout.Constraints(666, 21, 270, 19, 0));
        contbeginFemaleQty.setBounds(new Rectangle(36, 66, 270, 19));
        kDPanel3.add(contbeginFemaleQty, new KDLayout.Constraints(36, 66, 270, 19, 0));
        contoccrFemaleQty.setBounds(new Rectangle(351, 66, 270, 19));
        kDPanel3.add(contoccrFemaleQty, new KDLayout.Constraints(351, 66, 270, 19, 0));
        contendFemaleQty.setBounds(new Rectangle(666, 66, 270, 19));
        kDPanel3.add(contendFemaleQty, new KDLayout.Constraints(666, 66, 270, 19, 0));
        contworkQty.setBounds(new Rectangle(36, 111, 270, 19));
        kDPanel3.add(contworkQty, new KDLayout.Constraints(36, 111, 270, 19, 0));
        contavgWorkQty.setBounds(new Rectangle(351, 111, 270, 19));
        kDPanel3.add(contavgWorkQty, new KDLayout.Constraints(351, 111, 270, 19, 0));
        contsumWorkQty.setBounds(new Rectangle(666, 111, 270, 19));
        kDPanel3.add(contsumWorkQty, new KDLayout.Constraints(666, 111, 270, 19, 0));
        contavgSumWorkQty.setBounds(new Rectangle(36, 151, 270, 19));
        kDPanel3.add(contavgSumWorkQty, new KDLayout.Constraints(36, 151, 270, 19, 0));
        //contbeginBreedQty
        contbeginBreedQty.setBoundEditor(txtbeginBreedQty);
        //contoccurBreedQty
        contoccurBreedQty.setBoundEditor(txtoccurBreedQty);
        //contendBreedQty
        contendBreedQty.setBoundEditor(txtendBreedQty);
        //contbeginFemaleQty
        contbeginFemaleQty.setBoundEditor(txtbeginFemaleQty);
        //contoccrFemaleQty
        contoccrFemaleQty.setBoundEditor(txtoccrFemaleQty);
        //contendFemaleQty
        contendFemaleQty.setBoundEditor(txtendFemaleQty);
        //contworkQty
        contworkQty.setBoundEditor(txtworkQty);
        //contavgWorkQty
        contavgWorkQty.setBoundEditor(txtavgWorkQty);
        //contsumWorkQty
        contsumWorkQty.setBoundEditor(txtsumWorkQty);
        //contavgSumWorkQty
        contavgSumWorkQty.setBoundEditor(txtavgSumWorkQty);

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
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(btnNextPerson);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("isInit", boolean.class, this.chkisInit, "selected");
		dataBinder.registerBinding("isStageBalance", boolean.class, this.chkisStageBalance, "selected");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("period", com.kingdee.eas.basedata.assistant.PeriodInfo.class, this.prmtperiod, "data");
		dataBinder.registerBinding("breedStage", com.kingdee.eas.farm.stocking.basedata.FarmStageEnum.class, this.breedStage, "selectedItem");
		dataBinder.registerBinding("stockingFarmer", com.kingdee.eas.farm.stocking.basedata.FarmersInfo.class, this.prmtstockingFarmer, "data");
		dataBinder.registerBinding("stockingHouse", com.kingdee.eas.farm.stocking.basedata.FarmInfo.class, this.prmtstockingHouse, "data");
		dataBinder.registerBinding("stockingBatch", com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo.class, this.prmtstockingBatch, "data");
		dataBinder.registerBinding("stockingFarm", com.kingdee.eas.farm.stocking.basedata.FarmInfo.class, this.prmtstockingFarm, "data");
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.dayratecost.DayRateInitBillEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.costItem", java.lang.Object.class, this.kdtEntrys, "costItem.text");
		dataBinder.registerBinding("entrys.beginCost", java.math.BigDecimal.class, this.kdtEntrys, "beginCost.text");
		dataBinder.registerBinding("entrys.beginQty", java.math.BigDecimal.class, this.kdtEntrys, "beginQty.text");
		dataBinder.registerBinding("entrys.endCost", java.math.BigDecimal.class, this.kdtEntrys, "endCost.text");
		dataBinder.registerBinding("entrys.endQty", java.math.BigDecimal.class, this.kdtEntrys, "endQty.text");
		dataBinder.registerBinding("entrys.unit", java.lang.Object.class, this.kdtEntrys, "unit.text");
		dataBinder.registerBinding("entrys.occurQty", java.math.BigDecimal.class, this.kdtEntrys, "occurQty.text");
		dataBinder.registerBinding("entrys.occurCost", java.math.BigDecimal.class, this.kdtEntrys, "occurCost.text");
		dataBinder.registerBinding("entrys.arAmount", java.math.BigDecimal.class, this.kdtEntrys, "arAmount.text");
		dataBinder.registerBinding("entrys.ItemName", String.class, this.kdtEntrys, "ItemName.text");
		dataBinder.registerBinding("entrys.EntryDetail.seq", int.class, this.kdtEntryDetail, "seq.text");
		dataBinder.registerBinding("entrys.EntryDetail", com.kingdee.eas.farm.dayratecost.DayRateInitBillEntryEntryDetailInfo.class, this.kdtEntryDetail, "userObject");
		dataBinder.registerBinding("entrys.EntryDetail.amount", java.math.BigDecimal.class, this.kdtEntryDetail, "amount.text");
		dataBinder.registerBinding("entrys.EntryDetail.itemName", String.class, this.kdtEntryDetail, "itemName.text");
		dataBinder.registerBinding("entrys.EntryDetail.itemID", String.class, this.kdtEntryDetail, "itemID.text");
		dataBinder.registerBinding("allArAmount", java.math.BigDecimal.class, this.txtallArAmount, "value");
		dataBinder.registerBinding("beginBreedQty", int.class, this.txtbeginBreedQty, "value");
		dataBinder.registerBinding("occurBreedQty", int.class, this.txtoccurBreedQty, "value");
		dataBinder.registerBinding("endBreedQty", int.class, this.txtendBreedQty, "value");
		dataBinder.registerBinding("beginFemaleQty", int.class, this.txtbeginFemaleQty, "value");
		dataBinder.registerBinding("occrFemaleQty", int.class, this.txtoccrFemaleQty, "value");
		dataBinder.registerBinding("endFemaleQty", int.class, this.txtendFemaleQty, "value");
		dataBinder.registerBinding("workQty", int.class, this.txtworkQty, "value");
		dataBinder.registerBinding("avgWorkQty", int.class, this.txtavgWorkQty, "value");
		dataBinder.registerBinding("sumWorkQty", int.class, this.txtsumWorkQty, "value");
		dataBinder.registerBinding("avgSumWorkQty", int.class, this.txtavgSumWorkQty, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.dayratecost.app.DayRateInitBillEditUIHandler";
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
        this.kdtEntryDetail.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.dayratecost.DayRateInitBillInfo)ov;
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
		getValidateHelper().registerBindProperty("isInit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isStageBalance", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("period", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedStage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("stockingFarmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("stockingHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("stockingBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("stockingFarm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.costItem", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.beginCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.beginQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.endCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.endQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.occurQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.occurCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.arAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.ItemName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.EntryDetail.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.EntryDetail", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.EntryDetail.amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.EntryDetail.itemName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.EntryDetail.itemID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allArAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("beginBreedQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("occurBreedQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("endBreedQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("beginFemaleQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("occrFemaleQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("endFemaleQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("workQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("avgWorkQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sumWorkQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("avgSumWorkQty", ValidateHelper.ON_SAVE);    		
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
            if ("costItem".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"ItemName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"costItem").getValue(),"name")));

}

    if ("occurCost".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"profitAmount").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,"arAmount").getValue())- com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,"occurCost").getValue())));

}

    if ("arAmount".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"profitAmount").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,"arAmount").getValue())- com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,"occurCost").getValue())));

}


    }

    /**
     * output txtbeginBreedQty_Changed() method
     */
    public void txtbeginBreedQty_Changed() throws Exception
    {
        System.out.println("txtbeginBreedQty_Changed() Function is executed!");
            txtendBreedQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(txtbeginBreedQty.getValue())- com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(txtoccurBreedQty.getValue())));


    }

    /**
     * output txtoccurBreedQty_Changed() method
     */
    public void txtoccurBreedQty_Changed() throws Exception
    {
        System.out.println("txtoccurBreedQty_Changed() Function is executed!");
            txtendBreedQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(txtbeginBreedQty.getValue())- com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(txtoccurBreedQty.getValue())));


    }

    /**
     * output txtendBreedQty_Changed() method
     */
    public void txtendBreedQty_Changed() throws Exception
    {
        System.out.println("txtendBreedQty_Changed() Function is executed!");
            txtoccurBreedQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(txtbeginBreedQty.getValue())- com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(txtendBreedQty.getValue())));


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
        sic.add(new SelectorItemInfo("isInit"));
        sic.add(new SelectorItemInfo("isStageBalance"));
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
			sic.add(new SelectorItemInfo("period.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("period.id"));
        	sic.add(new SelectorItemInfo("period.number"));
		}
        sic.add(new SelectorItemInfo("breedStage"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("stockingFarmer.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("stockingFarmer.id"));
        	sic.add(new SelectorItemInfo("stockingFarmer.number"));
        	sic.add(new SelectorItemInfo("stockingFarmer.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("stockingHouse.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("stockingHouse.id"));
        	sic.add(new SelectorItemInfo("stockingHouse.number"));
        	sic.add(new SelectorItemInfo("stockingHouse.name"));
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("stockingFarm.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("stockingFarm.id"));
        	sic.add(new SelectorItemInfo("stockingFarm.number"));
        	sic.add(new SelectorItemInfo("stockingFarm.name"));
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
			sic.add(new SelectorItemInfo("entrys.costItem.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.costItem.id"));
			sic.add(new SelectorItemInfo("entrys.costItem.name"));
        	sic.add(new SelectorItemInfo("entrys.costItem.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.beginCost"));
    	sic.add(new SelectorItemInfo("entrys.beginQty"));
    	sic.add(new SelectorItemInfo("entrys.endCost"));
    	sic.add(new SelectorItemInfo("entrys.endQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.unit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.unit.id"));
			sic.add(new SelectorItemInfo("entrys.unit.name"));
        	sic.add(new SelectorItemInfo("entrys.unit.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.occurQty"));
    	sic.add(new SelectorItemInfo("entrys.occurCost"));
    	sic.add(new SelectorItemInfo("entrys.arAmount"));
    	sic.add(new SelectorItemInfo("entrys.ItemName"));
    	sic.add(new SelectorItemInfo("entrys.EntryDetail.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.EntryDetail.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.EntryDetail.id"));
		}
    	sic.add(new SelectorItemInfo("entrys.EntryDetail.amount"));
    	sic.add(new SelectorItemInfo("entrys.EntryDetail.itemName"));
    	sic.add(new SelectorItemInfo("entrys.EntryDetail.itemID"));
        sic.add(new SelectorItemInfo("allArAmount"));
        sic.add(new SelectorItemInfo("beginBreedQty"));
        sic.add(new SelectorItemInfo("occurBreedQty"));
        sic.add(new SelectorItemInfo("endBreedQty"));
        sic.add(new SelectorItemInfo("beginFemaleQty"));
        sic.add(new SelectorItemInfo("occrFemaleQty"));
        sic.add(new SelectorItemInfo("endFemaleQty"));
        sic.add(new SelectorItemInfo("workQty"));
        sic.add(new SelectorItemInfo("avgWorkQty"));
        sic.add(new SelectorItemInfo("sumWorkQty"));
        sic.add(new SelectorItemInfo("avgSumWorkQty"));
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
        com.kingdee.eas.farm.dayratecost.DayRateInitBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.dayratecost.DayRateInitBillFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionInitialize_actionPerformed method
     */
    public void actionInitialize_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.dayratecost.DayRateInitBillFactory.getRemoteInstance().initialize(editData);
    }
    	

    /**
     * output actionUnInitialize_actionPerformed method
     */
    public void actionUnInitialize_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.dayratecost.DayRateInitBillFactory.getRemoteInstance().unInitialize(editData);
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
	public RequestContext prepareActionInitialize(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionInitialize() {
    	return false;
    }
	public RequestContext prepareActionUnInitialize(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionUnInitialize() {
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
            innerActionPerformed("eas", AbstractDayRateInitBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractDayRateInitBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionInitialize class
     */     
    protected class ActionInitialize extends ItemAction {     
    
        public ActionInitialize()
        {
            this(null);
        }

        public ActionInitialize(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionInitialize.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionInitialize.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionInitialize.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractDayRateInitBillEditUI.this, "ActionInitialize", "actionInitialize_actionPerformed", e);
        }
    }

    /**
     * output ActionUnInitialize class
     */     
    protected class ActionUnInitialize extends ItemAction {     
    
        public ActionUnInitialize()
        {
            this(null);
        }

        public ActionUnInitialize(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionUnInitialize.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnInitialize.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnInitialize.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractDayRateInitBillEditUI.this, "ActionUnInitialize", "actionUnInitialize_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.dayratecost.client", "DayRateInitBillEditUI");
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
        return com.kingdee.eas.farm.dayratecost.client.DayRateInitBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.dayratecost.DayRateInitBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.dayratecost.DayRateInitBillInfo objectValue = new com.kingdee.eas.farm.dayratecost.DayRateInitBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/dayratecost/DayRateInitBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.dayratecost.app.DayRateInitBillQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
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
        return kdtEntrys;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("billStatus",new Integer(-1));
vo.put("breedStage",new Integer(1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}