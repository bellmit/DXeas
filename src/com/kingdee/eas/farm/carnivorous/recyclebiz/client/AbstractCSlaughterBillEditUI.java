/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.recyclebiz.client;

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
public abstract class AbstractCSlaughterBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCSlaughterBillEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contFICompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatchContract;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatch;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsettlePolicy;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatchQty;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator9;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmAddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsaleType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcustomer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmerPhone;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedData;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoutSalePrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcar;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdriver;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdriverPhone;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpreHouseQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpreHouseSuttle;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsettleWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpreHouseGross;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpreHouseTare;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisHasShengChanRK;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisHasSaleIssue;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompanyGross;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompanyTare;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompanySuttle;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcalUnit;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkhasFreightBill;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcatchCKTeam;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkweighed;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkhasLLCK;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkhasQTCK;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contreceQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBWeight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contreturnWeight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAWeight;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisPrepare;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchicWeighr;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contF7Number;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contF7id;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsettleWeight;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisManRec;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisSaleOut;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contavgWeight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcostCenter;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdeathQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtFICompany;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarm;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbatchContract;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbatch;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsettlePolicy;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkinDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbatchQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperson;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfarmAddress;
    protected com.kingdee.bos.ctrl.swing.KDComboBox farmType;
    protected com.kingdee.bos.ctrl.swing.KDComboBox saleType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcustomer;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfarmerPhone;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbreedData;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoutSalePrice;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcar;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtdriver;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdriverPhone;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpreHouseQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpreHouseSuttle;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtQCEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtQCEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpunishAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpunishWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdiffChickenQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweighBillNum;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpunishAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpunishWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdiffChickenQty;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtweighBillNum;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsettleWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpreHouseGross;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpreHouseTare;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcompanyGross;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcompanyTare;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcompanySuttle;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcalUnit;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcatchCKTeam;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcarcassQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcarcassWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcAverageWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdiffQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrecQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contincompleteQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contincompleteWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contincompleteRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmeatRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdressingPercent;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcarcassQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcarcassWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcAverageWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdiffQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtrecQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtincompleteQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtincompleteWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtincompleteRate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmeatRate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdressingPercent;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtreceQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtAQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtBQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtBWeight;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtreturnWeight;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtAWeight;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtchicWeighr;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtF7Number;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtF7id;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsettleWeight;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtavgWeight;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcostCenter;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdeathQty;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractCSlaughterBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCSlaughterBillEditUI.class.getName());
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
        this.actionAudit.setBindWorkFlow(true);
        this.actionAudit.setExtendProperty("canForewarn", "true");
        this.actionAudit.setExtendProperty("userDefined", "true");
        this.actionAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionUnAudit
        this.actionUnAudit = new ActionUnAudit(this);
        getActionManager().registerAction("actionUnAudit", actionUnAudit);
        this.actionUnAudit.setBindWorkFlow(true);
        this.actionUnAudit.setExtendProperty("canForewarn", "true");
        this.actionUnAudit.setExtendProperty("userDefined", "true");
        this.actionUnAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contFICompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbatchContract = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbatch = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsettlePolicy = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbatchQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator9 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contperson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmAddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsaleType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcustomer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmerPhone = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbreedData = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoutSalePrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcar = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdriver = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdriverPhone = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpreHouseQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpreHouseSuttle = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contsettleWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpreHouseGross = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpreHouseTare = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisHasShengChanRK = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisHasSaleIssue = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contcompanyGross = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompanyTare = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompanySuttle = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcalUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkhasFreightBill = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contcatchCKTeam = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkweighed = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkhasLLCK = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkhasQTCK = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contreceQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBWeight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contreturnWeight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAWeight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisPrepare = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contchicWeighr = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contF7Number = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contF7id = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsettleWeight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisManRec = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisSaleOut = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contavgWeight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcostCenter = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdeathQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtFICompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtfarmer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtfarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbatchContract = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbatch = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtsettlePolicy = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkinDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtbatchQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtperson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtfarmAddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.farmType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.saleType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtcustomer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtfarmerPhone = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtbreedData = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtoutSalePrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtcar = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtdriver = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtdriverPhone = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtpreHouseQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpreHouseSuttle = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtQCEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contpunishAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpunishWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdiffChickenQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweighBillNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtpunishAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpunishWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdiffChickenQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtweighBillNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtsettleWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpreHouseGross = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpreHouseTare = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcompanyGross = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcompanyTare = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcompanySuttle = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtcalUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcatchCKTeam = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.contcarcassQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcarcassWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcAverageWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdiffQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrecQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contincompleteQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contincompleteWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contincompleteRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmeatRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdressingPercent = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtcarcassQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcarcassWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcAverageWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdiffQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtrecQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtincompleteQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtincompleteWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtincompleteRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmeatRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdressingPercent = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtreceQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtAQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtBQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtBWeight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtreturnWeight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtAWeight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtchicWeighr = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtF7Number = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtF7id = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtsettleWeight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtavgWeight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtcostCenter = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtdeathQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.contFICompany.setName("contFICompany");
        this.contauditTime.setName("contauditTime");
        this.contfarmer.setName("contfarmer");
        this.contfarm.setName("contfarm");
        this.contbatchContract.setName("contbatchContract");
        this.contbatch.setName("contbatch");
        this.contbillStatus.setName("contbillStatus");
        this.contsettlePolicy.setName("contsettlePolicy");
        this.continDate.setName("continDate");
        this.contbatchQty.setName("contbatchQty");
        this.kDSeparator9.setName("kDSeparator9");
        this.contperson.setName("contperson");
        this.contfarmAddress.setName("contfarmAddress");
        this.contfarmType.setName("contfarmType");
        this.contsaleType.setName("contsaleType");
        this.contcustomer.setName("contcustomer");
        this.contfarmerPhone.setName("contfarmerPhone");
        this.contbreedData.setName("contbreedData");
        this.contoutSalePrice.setName("contoutSalePrice");
        this.contcar.setName("contcar");
        this.contdriver.setName("contdriver");
        this.contdriverPhone.setName("contdriverPhone");
        this.contpreHouseQty.setName("contpreHouseQty");
        this.contpreHouseSuttle.setName("contpreHouseSuttle");
        this.kDSeparator8.setName("kDSeparator8");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contsettleWgt.setName("contsettleWgt");
        this.contpreHouseGross.setName("contpreHouseGross");
        this.contpreHouseTare.setName("contpreHouseTare");
        this.chkisHasShengChanRK.setName("chkisHasShengChanRK");
        this.chkisHasSaleIssue.setName("chkisHasSaleIssue");
        this.contcompanyGross.setName("contcompanyGross");
        this.contcompanyTare.setName("contcompanyTare");
        this.contcompanySuttle.setName("contcompanySuttle");
        this.contcalUnit.setName("contcalUnit");
        this.chkhasFreightBill.setName("chkhasFreightBill");
        this.contcatchCKTeam.setName("contcatchCKTeam");
        this.chkweighed.setName("chkweighed");
        this.chkhasLLCK.setName("chkhasLLCK");
        this.chkhasQTCK.setName("chkhasQTCK");
        this.kDPanel1.setName("kDPanel1");
        this.contreceQty.setName("contreceQty");
        this.contAQty.setName("contAQty");
        this.contBQty.setName("contBQty");
        this.contBWeight.setName("contBWeight");
        this.contreturnWeight.setName("contreturnWeight");
        this.contAWeight.setName("contAWeight");
        this.chkisPrepare.setName("chkisPrepare");
        this.contchicWeighr.setName("contchicWeighr");
        this.contF7Number.setName("contF7Number");
        this.contF7id.setName("contF7id");
        this.contsettleWeight.setName("contsettleWeight");
        this.chkisManRec.setName("chkisManRec");
        this.chkisSaleOut.setName("chkisSaleOut");
        this.contavgWeight.setName("contavgWeight");
        this.contcostCenter.setName("contcostCenter");
        this.contdeathQty.setName("contdeathQty");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtFICompany.setName("prmtFICompany");
        this.pkauditTime.setName("pkauditTime");
        this.prmtfarmer.setName("prmtfarmer");
        this.prmtfarm.setName("prmtfarm");
        this.prmtbatchContract.setName("prmtbatchContract");
        this.prmtbatch.setName("prmtbatch");
        this.billStatus.setName("billStatus");
        this.prmtsettlePolicy.setName("prmtsettlePolicy");
        this.pkinDate.setName("pkinDate");
        this.txtbatchQty.setName("txtbatchQty");
        this.prmtperson.setName("prmtperson");
        this.txtfarmAddress.setName("txtfarmAddress");
        this.farmType.setName("farmType");
        this.saleType.setName("saleType");
        this.prmtcustomer.setName("prmtcustomer");
        this.txtfarmerPhone.setName("txtfarmerPhone");
        this.prmtbreedData.setName("prmtbreedData");
        this.txtoutSalePrice.setName("txtoutSalePrice");
        this.prmtcar.setName("prmtcar");
        this.prmtdriver.setName("prmtdriver");
        this.txtdriverPhone.setName("txtdriverPhone");
        this.txtpreHouseQty.setName("txtpreHouseQty");
        this.txtpreHouseSuttle.setName("txtpreHouseSuttle");
        this.kDPanel2.setName("kDPanel2");
        this.kdtQCEntrys.setName("kdtQCEntrys");
        this.contpunishAmt.setName("contpunishAmt");
        this.contpunishWgt.setName("contpunishWgt");
        this.contdiffChickenQty.setName("contdiffChickenQty");
        this.contweighBillNum.setName("contweighBillNum");
        this.txtpunishAmt.setName("txtpunishAmt");
        this.txtpunishWgt.setName("txtpunishWgt");
        this.txtdiffChickenQty.setName("txtdiffChickenQty");
        this.txtweighBillNum.setName("txtweighBillNum");
        this.txtsettleWgt.setName("txtsettleWgt");
        this.txtpreHouseGross.setName("txtpreHouseGross");
        this.txtpreHouseTare.setName("txtpreHouseTare");
        this.txtcompanyGross.setName("txtcompanyGross");
        this.txtcompanyTare.setName("txtcompanyTare");
        this.txtcompanySuttle.setName("txtcompanySuttle");
        this.prmtcalUnit.setName("prmtcalUnit");
        this.prmtcatchCKTeam.setName("prmtcatchCKTeam");
        this.contcarcassQty.setName("contcarcassQty");
        this.contcarcassWgt.setName("contcarcassWgt");
        this.contcAverageWgt.setName("contcAverageWgt");
        this.contdiffQty.setName("contdiffQty");
        this.contrecQty.setName("contrecQty");
        this.contincompleteQty.setName("contincompleteQty");
        this.contincompleteWgt.setName("contincompleteWgt");
        this.contincompleteRate.setName("contincompleteRate");
        this.contmeatRate.setName("contmeatRate");
        this.contdressingPercent.setName("contdressingPercent");
        this.txtcarcassQty.setName("txtcarcassQty");
        this.txtcarcassWgt.setName("txtcarcassWgt");
        this.txtcAverageWgt.setName("txtcAverageWgt");
        this.txtdiffQty.setName("txtdiffQty");
        this.txtrecQty.setName("txtrecQty");
        this.txtincompleteQty.setName("txtincompleteQty");
        this.txtincompleteWgt.setName("txtincompleteWgt");
        this.txtincompleteRate.setName("txtincompleteRate");
        this.txtmeatRate.setName("txtmeatRate");
        this.txtdressingPercent.setName("txtdressingPercent");
        this.txtreceQty.setName("txtreceQty");
        this.txtAQty.setName("txtAQty");
        this.txtBQty.setName("txtBQty");
        this.txtBWeight.setName("txtBWeight");
        this.txtreturnWeight.setName("txtreturnWeight");
        this.txtAWeight.setName("txtAWeight");
        this.prmtchicWeighr.setName("prmtchicWeighr");
        this.txtF7Number.setName("txtF7Number");
        this.txtF7id.setName("txtF7id");
        this.txtsettleWeight.setName("txtsettleWeight");
        this.txtavgWeight.setName("txtavgWeight");
        this.prmtcostCenter.setName("prmtcostCenter");
        this.txtdeathQty.setName("txtdeathQty");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
        // CoreUI		
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
        // contFICompany		
        this.contFICompany.setBoundLabelText(resHelper.getString("contFICompany.boundLabelText"));		
        this.contFICompany.setBoundLabelLength(100);		
        this.contFICompany.setBoundLabelUnderline(true);		
        this.contFICompany.setVisible(true);
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // contfarmer		
        this.contfarmer.setBoundLabelText(resHelper.getString("contfarmer.boundLabelText"));		
        this.contfarmer.setBoundLabelLength(100);		
        this.contfarmer.setBoundLabelUnderline(true);		
        this.contfarmer.setVisible(true);
        // contfarm		
        this.contfarm.setBoundLabelText(resHelper.getString("contfarm.boundLabelText"));		
        this.contfarm.setBoundLabelLength(100);		
        this.contfarm.setBoundLabelUnderline(true);		
        this.contfarm.setVisible(true);
        // contbatchContract		
        this.contbatchContract.setBoundLabelText(resHelper.getString("contbatchContract.boundLabelText"));		
        this.contbatchContract.setBoundLabelLength(100);		
        this.contbatchContract.setBoundLabelUnderline(true);		
        this.contbatchContract.setVisible(true);
        // contbatch		
        this.contbatch.setBoundLabelText(resHelper.getString("contbatch.boundLabelText"));		
        this.contbatch.setBoundLabelLength(100);		
        this.contbatch.setBoundLabelUnderline(true);		
        this.contbatch.setVisible(true);
        // contbillStatus		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);
        // contsettlePolicy		
        this.contsettlePolicy.setBoundLabelText(resHelper.getString("contsettlePolicy.boundLabelText"));		
        this.contsettlePolicy.setBoundLabelLength(100);		
        this.contsettlePolicy.setBoundLabelUnderline(true);		
        this.contsettlePolicy.setVisible(true);
        // continDate		
        this.continDate.setBoundLabelText(resHelper.getString("continDate.boundLabelText"));		
        this.continDate.setBoundLabelLength(100);		
        this.continDate.setBoundLabelUnderline(true);		
        this.continDate.setVisible(true);
        // contbatchQty		
        this.contbatchQty.setBoundLabelText(resHelper.getString("contbatchQty.boundLabelText"));		
        this.contbatchQty.setBoundLabelLength(100);		
        this.contbatchQty.setBoundLabelUnderline(true);		
        this.contbatchQty.setVisible(true);
        // kDSeparator9
        // contperson		
        this.contperson.setBoundLabelText(resHelper.getString("contperson.boundLabelText"));		
        this.contperson.setBoundLabelLength(100);		
        this.contperson.setBoundLabelUnderline(true);		
        this.contperson.setVisible(true);
        // contfarmAddress		
        this.contfarmAddress.setBoundLabelText(resHelper.getString("contfarmAddress.boundLabelText"));		
        this.contfarmAddress.setBoundLabelLength(100);		
        this.contfarmAddress.setBoundLabelUnderline(true);		
        this.contfarmAddress.setVisible(true);
        // contfarmType		
        this.contfarmType.setBoundLabelText(resHelper.getString("contfarmType.boundLabelText"));		
        this.contfarmType.setBoundLabelLength(100);		
        this.contfarmType.setBoundLabelUnderline(true);		
        this.contfarmType.setVisible(true);
        // contsaleType		
        this.contsaleType.setBoundLabelText(resHelper.getString("contsaleType.boundLabelText"));		
        this.contsaleType.setBoundLabelLength(100);		
        this.contsaleType.setBoundLabelUnderline(true);		
        this.contsaleType.setVisible(true);
        // contcustomer		
        this.contcustomer.setBoundLabelText(resHelper.getString("contcustomer.boundLabelText"));		
        this.contcustomer.setBoundLabelLength(100);		
        this.contcustomer.setBoundLabelUnderline(true);		
        this.contcustomer.setVisible(true);
        // contfarmerPhone		
        this.contfarmerPhone.setBoundLabelText(resHelper.getString("contfarmerPhone.boundLabelText"));		
        this.contfarmerPhone.setBoundLabelLength(100);		
        this.contfarmerPhone.setBoundLabelUnderline(true);		
        this.contfarmerPhone.setVisible(true);
        // contbreedData		
        this.contbreedData.setBoundLabelText(resHelper.getString("contbreedData.boundLabelText"));		
        this.contbreedData.setBoundLabelLength(100);		
        this.contbreedData.setBoundLabelUnderline(true);		
        this.contbreedData.setVisible(true);
        // contoutSalePrice		
        this.contoutSalePrice.setBoundLabelText(resHelper.getString("contoutSalePrice.boundLabelText"));		
        this.contoutSalePrice.setBoundLabelLength(100);		
        this.contoutSalePrice.setBoundLabelUnderline(true);		
        this.contoutSalePrice.setVisible(true);
        // contcar		
        this.contcar.setBoundLabelText(resHelper.getString("contcar.boundLabelText"));		
        this.contcar.setBoundLabelLength(100);		
        this.contcar.setBoundLabelUnderline(true);		
        this.contcar.setVisible(true);
        // contdriver		
        this.contdriver.setBoundLabelText(resHelper.getString("contdriver.boundLabelText"));		
        this.contdriver.setBoundLabelLength(100);		
        this.contdriver.setBoundLabelUnderline(true);		
        this.contdriver.setVisible(true);
        // contdriverPhone		
        this.contdriverPhone.setBoundLabelText(resHelper.getString("contdriverPhone.boundLabelText"));		
        this.contdriverPhone.setBoundLabelLength(100);		
        this.contdriverPhone.setBoundLabelUnderline(true);		
        this.contdriverPhone.setVisible(true);
        // contpreHouseQty		
        this.contpreHouseQty.setBoundLabelText(resHelper.getString("contpreHouseQty.boundLabelText"));		
        this.contpreHouseQty.setBoundLabelLength(100);		
        this.contpreHouseQty.setBoundLabelUnderline(true);		
        this.contpreHouseQty.setVisible(false);
        // contpreHouseSuttle		
        this.contpreHouseSuttle.setBoundLabelText(resHelper.getString("contpreHouseSuttle.boundLabelText"));		
        this.contpreHouseSuttle.setBoundLabelLength(100);		
        this.contpreHouseSuttle.setBoundLabelUnderline(true);		
        this.contpreHouseSuttle.setVisible(false);
        // kDSeparator8
        // kDTabbedPane1
        // contsettleWgt		
        this.contsettleWgt.setBoundLabelText(resHelper.getString("contsettleWgt.boundLabelText"));		
        this.contsettleWgt.setBoundLabelLength(100);		
        this.contsettleWgt.setBoundLabelUnderline(true);		
        this.contsettleWgt.setVisible(false);
        // contpreHouseGross		
        this.contpreHouseGross.setBoundLabelText(resHelper.getString("contpreHouseGross.boundLabelText"));		
        this.contpreHouseGross.setBoundLabelLength(100);		
        this.contpreHouseGross.setBoundLabelUnderline(true);		
        this.contpreHouseGross.setVisible(false);
        // contpreHouseTare		
        this.contpreHouseTare.setBoundLabelText(resHelper.getString("contpreHouseTare.boundLabelText"));		
        this.contpreHouseTare.setBoundLabelLength(100);		
        this.contpreHouseTare.setBoundLabelUnderline(true);		
        this.contpreHouseTare.setVisible(false);
        // chkisHasShengChanRK		
        this.chkisHasShengChanRK.setText(resHelper.getString("chkisHasShengChanRK.text"));		
        this.chkisHasShengChanRK.setVisible(false);		
        this.chkisHasShengChanRK.setHorizontalAlignment(2);		
        this.chkisHasShengChanRK.setEnabled(false);
        // chkisHasSaleIssue		
        this.chkisHasSaleIssue.setText(resHelper.getString("chkisHasSaleIssue.text"));		
        this.chkisHasSaleIssue.setVisible(false);		
        this.chkisHasSaleIssue.setHorizontalAlignment(2);		
        this.chkisHasSaleIssue.setEnabled(false);
        // contcompanyGross		
        this.contcompanyGross.setBoundLabelText(resHelper.getString("contcompanyGross.boundLabelText"));		
        this.contcompanyGross.setBoundLabelLength(100);		
        this.contcompanyGross.setBoundLabelUnderline(true);		
        this.contcompanyGross.setVisible(false);
        // contcompanyTare		
        this.contcompanyTare.setBoundLabelText(resHelper.getString("contcompanyTare.boundLabelText"));		
        this.contcompanyTare.setBoundLabelLength(100);		
        this.contcompanyTare.setBoundLabelUnderline(true);		
        this.contcompanyTare.setVisible(false);
        // contcompanySuttle		
        this.contcompanySuttle.setBoundLabelText(resHelper.getString("contcompanySuttle.boundLabelText"));		
        this.contcompanySuttle.setBoundLabelLength(100);		
        this.contcompanySuttle.setBoundLabelUnderline(true);		
        this.contcompanySuttle.setVisible(false);
        // contcalUnit		
        this.contcalUnit.setBoundLabelText(resHelper.getString("contcalUnit.boundLabelText"));		
        this.contcalUnit.setBoundLabelLength(100);		
        this.contcalUnit.setBoundLabelUnderline(true);		
        this.contcalUnit.setVisible(false);
        // chkhasFreightBill		
        this.chkhasFreightBill.setText(resHelper.getString("chkhasFreightBill.text"));		
        this.chkhasFreightBill.setVisible(false);		
        this.chkhasFreightBill.setHorizontalAlignment(2);		
        this.chkhasFreightBill.setEnabled(false);
        // contcatchCKTeam		
        this.contcatchCKTeam.setBoundLabelText(resHelper.getString("contcatchCKTeam.boundLabelText"));		
        this.contcatchCKTeam.setBoundLabelLength(100);		
        this.contcatchCKTeam.setBoundLabelUnderline(true);		
        this.contcatchCKTeam.setVisible(true);
        // chkweighed		
        this.chkweighed.setText(resHelper.getString("chkweighed.text"));		
        this.chkweighed.setVisible(false);		
        this.chkweighed.setHorizontalAlignment(2);		
        this.chkweighed.setEnabled(false);
        // chkhasLLCK		
        this.chkhasLLCK.setText(resHelper.getString("chkhasLLCK.text"));		
        this.chkhasLLCK.setVisible(false);		
        this.chkhasLLCK.setHorizontalAlignment(2);		
        this.chkhasLLCK.setEnabled(false);
        // chkhasQTCK		
        this.chkhasQTCK.setText(resHelper.getString("chkhasQTCK.text"));		
        this.chkhasQTCK.setVisible(false);		
        this.chkhasQTCK.setHorizontalAlignment(2);		
        this.chkhasQTCK.setEnabled(false);
        // kDPanel1
        // contreceQty		
        this.contreceQty.setBoundLabelText(resHelper.getString("contreceQty.boundLabelText"));		
        this.contreceQty.setBoundLabelLength(100);		
        this.contreceQty.setBoundLabelUnderline(true);		
        this.contreceQty.setVisible(true);
        // contAQty		
        this.contAQty.setBoundLabelText(resHelper.getString("contAQty.boundLabelText"));		
        this.contAQty.setBoundLabelLength(100);		
        this.contAQty.setBoundLabelUnderline(true);		
        this.contAQty.setVisible(true);
        // contBQty		
        this.contBQty.setBoundLabelText(resHelper.getString("contBQty.boundLabelText"));		
        this.contBQty.setBoundLabelLength(100);		
        this.contBQty.setBoundLabelUnderline(true);		
        this.contBQty.setVisible(true);
        // contBWeight		
        this.contBWeight.setBoundLabelText(resHelper.getString("contBWeight.boundLabelText"));		
        this.contBWeight.setBoundLabelLength(100);		
        this.contBWeight.setBoundLabelUnderline(true);		
        this.contBWeight.setVisible(true);
        // contreturnWeight		
        this.contreturnWeight.setBoundLabelText(resHelper.getString("contreturnWeight.boundLabelText"));		
        this.contreturnWeight.setBoundLabelLength(100);		
        this.contreturnWeight.setBoundLabelUnderline(true);		
        this.contreturnWeight.setVisible(true);
        // contAWeight		
        this.contAWeight.setBoundLabelText(resHelper.getString("contAWeight.boundLabelText"));		
        this.contAWeight.setBoundLabelLength(100);		
        this.contAWeight.setBoundLabelUnderline(true);		
        this.contAWeight.setVisible(true);
        // chkisPrepare		
        this.chkisPrepare.setText(resHelper.getString("chkisPrepare.text"));		
        this.chkisPrepare.setVisible(true);		
        this.chkisPrepare.setHorizontalAlignment(2);
        // contchicWeighr		
        this.contchicWeighr.setBoundLabelText(resHelper.getString("contchicWeighr.boundLabelText"));		
        this.contchicWeighr.setBoundLabelLength(100);		
        this.contchicWeighr.setBoundLabelUnderline(true);
        // contF7Number		
        this.contF7Number.setBoundLabelText(resHelper.getString("contF7Number.boundLabelText"));		
        this.contF7Number.setBoundLabelLength(100);		
        this.contF7Number.setBoundLabelUnderline(true);		
        this.contF7Number.setVisible(false);
        // contF7id		
        this.contF7id.setBoundLabelText(resHelper.getString("contF7id.boundLabelText"));		
        this.contF7id.setBoundLabelLength(100);		
        this.contF7id.setBoundLabelUnderline(true);		
        this.contF7id.setVisible(false);
        // contsettleWeight		
        this.contsettleWeight.setBoundLabelText(resHelper.getString("contsettleWeight.boundLabelText"));		
        this.contsettleWeight.setBoundLabelLength(100);		
        this.contsettleWeight.setBoundLabelUnderline(true);
        // chkisManRec		
        this.chkisManRec.setText(resHelper.getString("chkisManRec.text"));		
        this.chkisManRec.setVisible(true);		
        this.chkisManRec.setHorizontalAlignment(2);		
        this.chkisManRec.setEnabled(false);
        // chkisSaleOut		
        this.chkisSaleOut.setText(resHelper.getString("chkisSaleOut.text"));		
        this.chkisSaleOut.setVisible(true);		
        this.chkisSaleOut.setHorizontalAlignment(2);		
        this.chkisSaleOut.setEnabled(false);
        // contavgWeight		
        this.contavgWeight.setBoundLabelText(resHelper.getString("contavgWeight.boundLabelText"));		
        this.contavgWeight.setBoundLabelLength(100);		
        this.contavgWeight.setBoundLabelUnderline(true);		
        this.contavgWeight.setVisible(true);
        // contcostCenter		
        this.contcostCenter.setBoundLabelText(resHelper.getString("contcostCenter.boundLabelText"));		
        this.contcostCenter.setBoundLabelLength(100);		
        this.contcostCenter.setBoundLabelUnderline(true);		
        this.contcostCenter.setVisible(true);
        // contdeathQty		
        this.contdeathQty.setBoundLabelText(resHelper.getString("contdeathQty.boundLabelText"));		
        this.contdeathQty.setBoundLabelLength(100);		
        this.contdeathQty.setBoundLabelUnderline(true);		
        this.contdeathQty.setVisible(true);
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
        this.txtNumber.setEnabled(false);
        // pkBizDate		
        this.pkBizDate.setVisible(true);		
        this.pkBizDate.setRequired(true);
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // prmtFICompany		
        this.prmtFICompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery4AsstAcct");		
        this.prmtFICompany.setVisible(true);		
        this.prmtFICompany.setEditable(true);		
        this.prmtFICompany.setDisplayFormat("$name$");		
        this.prmtFICompany.setEditFormat("$number$");		
        this.prmtFICompany.setCommitFormat("$number$");		
        this.prmtFICompany.setRequired(true);		
        this.prmtFICompany.setEnabled(false);
        		setOrgF7(prmtFICompany,com.kingdee.eas.basedata.org.OrgType.getEnum("Company"));
					
        // pkauditTime		
        this.pkauditTime.setVisible(true);		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // prmtfarmer		
        this.prmtfarmer.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerQuery");		
        this.prmtfarmer.setVisible(true);		
        this.prmtfarmer.setEditable(true);		
        this.prmtfarmer.setDisplayFormat("$name$");		
        this.prmtfarmer.setEditFormat("$number$");		
        this.prmtfarmer.setCommitFormat("$number$");		
        this.prmtfarmer.setRequired(true);
        		prmtfarmer.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.FarmerListUI prmtfarmer_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarmer_F7ListUI == null) {
					try {
						prmtfarmer_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.FarmerListUI();
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
					
        prmtfarmer.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtfarmer_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // prmtfarm		
        this.prmtfarm.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmQuery");		
        this.prmtfarm.setVisible(true);		
        this.prmtfarm.setEditable(true);		
        this.prmtfarm.setDisplayFormat("$name$");		
        this.prmtfarm.setEditFormat("$number$");		
        this.prmtfarm.setCommitFormat("$number$");		
        this.prmtfarm.setRequired(true);
        		prmtfarm.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.FarmListUI prmtfarm_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarm_F7ListUI == null) {
					try {
						prmtfarm_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.FarmListUI();
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

        // prmtbatchContract		
        this.prmtbatchContract.setQueryInfo("com.kingdee.eas.farm.carnivorous.feedbiz.app.BatchContractBillQuery");		
        this.prmtbatchContract.setVisible(true);		
        this.prmtbatchContract.setEditable(true);		
        this.prmtbatchContract.setDisplayFormat("$number$");		
        this.prmtbatchContract.setEditFormat("$number$");		
        this.prmtbatchContract.setCommitFormat("$number$");		
        this.prmtbatchContract.setRequired(true);
        // prmtbatch		
        this.prmtbatch.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.BatchQuery");		
        this.prmtbatch.setVisible(true);		
        this.prmtbatch.setEditable(true);		
        this.prmtbatch.setDisplayFormat("$name$");		
        this.prmtbatch.setEditFormat("$number$");		
        this.prmtbatch.setCommitFormat("$number$");		
        this.prmtbatch.setRequired(false);		
        this.prmtbatch.setEnabled(false);
        		prmtbatch.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.BatchListUI prmtbatch_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtbatch_F7ListUI == null) {
					try {
						prmtbatch_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.BatchListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtbatch_F7ListUI));
					prmtbatch_F7ListUI.setF7Use(true,ctx);
					prmtbatch.setSelector(prmtbatch_F7ListUI);
				}
			}
		});
					
        // billStatus		
        this.billStatus.setVisible(true);		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // prmtsettlePolicy		
        this.prmtsettlePolicy.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.SettlePolicyQuery");		
        this.prmtsettlePolicy.setVisible(true);		
        this.prmtsettlePolicy.setEditable(true);		
        this.prmtsettlePolicy.setDisplayFormat("$name$");		
        this.prmtsettlePolicy.setEditFormat("$number$");		
        this.prmtsettlePolicy.setCommitFormat("$number$");		
        this.prmtsettlePolicy.setRequired(false);		
        this.prmtsettlePolicy.setEnabled(false);
        		prmtsettlePolicy.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.SettlePolicyListUI prmtsettlePolicy_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtsettlePolicy_F7ListUI == null) {
					try {
						prmtsettlePolicy_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.SettlePolicyListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtsettlePolicy_F7ListUI));
					prmtsettlePolicy_F7ListUI.setF7Use(true,ctx);
					prmtsettlePolicy.setSelector(prmtsettlePolicy_F7ListUI);
				}
			}
		});
					
        // pkinDate		
        this.pkinDate.setVisible(true);		
        this.pkinDate.setRequired(false);		
        this.pkinDate.setEnabled(false);
        // txtbatchQty		
        this.txtbatchQty.setVisible(true);		
        this.txtbatchQty.setHorizontalAlignment(2);		
        this.txtbatchQty.setDataType(1);		
        this.txtbatchQty.setSupportedEmpty(true);		
        this.txtbatchQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbatchQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbatchQty.setPrecision(4);		
        this.txtbatchQty.setRequired(false);		
        this.txtbatchQty.setEnabled(false);
        // prmtperson		
        this.prmtperson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtperson.setVisible(true);		
        this.prmtperson.setEditable(true);		
        this.prmtperson.setDisplayFormat("$name$");		
        this.prmtperson.setEditFormat("$number$");		
        this.prmtperson.setCommitFormat("$number$");		
        this.prmtperson.setRequired(false);		
        this.prmtperson.setEnabled(false);
        // txtfarmAddress		
        this.txtfarmAddress.setVisible(true);		
        this.txtfarmAddress.setHorizontalAlignment(2);		
        this.txtfarmAddress.setMaxLength(80);		
        this.txtfarmAddress.setRequired(false);		
        this.txtfarmAddress.setEnabled(false);
        // farmType		
        this.farmType.setVisible(true);		
        this.farmType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.FarmsType").toArray());		
        this.farmType.setRequired(false);		
        this.farmType.setEnabled(false);
        // saleType		
        this.saleType.setVisible(true);		
        this.saleType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.recyclebiz.SaleBizType").toArray());		
        this.saleType.setRequired(true);
        // prmtcustomer		
        this.prmtcustomer.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.CustomerInfoQuery");		
        this.prmtcustomer.setVisible(true);		
        this.prmtcustomer.setEditable(true);		
        this.prmtcustomer.setDisplayFormat("$name$");		
        this.prmtcustomer.setEditFormat("$number$");		
        this.prmtcustomer.setCommitFormat("$number$");		
        this.prmtcustomer.setRequired(false);
        // txtfarmerPhone		
        this.txtfarmerPhone.setVisible(true);		
        this.txtfarmerPhone.setHorizontalAlignment(2);		
        this.txtfarmerPhone.setMaxLength(80);		
        this.txtfarmerPhone.setRequired(false);		
        this.txtfarmerPhone.setEnabled(false);
        // prmtbreedData		
        this.prmtbreedData.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.BreedDataQuery");		
        this.prmtbreedData.setVisible(true);		
        this.prmtbreedData.setEditable(true);		
        this.prmtbreedData.setDisplayFormat("$name$");		
        this.prmtbreedData.setEditFormat("$number$");		
        this.prmtbreedData.setCommitFormat("$number$");		
        this.prmtbreedData.setRequired(false);		
        this.prmtbreedData.setEnabled(false);
        		prmtbreedData.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI prmtbreedData_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtbreedData_F7ListUI == null) {
					try {
						prmtbreedData_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtbreedData_F7ListUI));
					prmtbreedData_F7ListUI.setF7Use(true,ctx);
					prmtbreedData.setSelector(prmtbreedData_F7ListUI);
				}
			}
		});
					
        // txtoutSalePrice		
        this.txtoutSalePrice.setVisible(true);		
        this.txtoutSalePrice.setHorizontalAlignment(2);		
        this.txtoutSalePrice.setDataType(1);		
        this.txtoutSalePrice.setSupportedEmpty(true);		
        this.txtoutSalePrice.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtoutSalePrice.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtoutSalePrice.setPrecision(2);		
        this.txtoutSalePrice.setRequired(false);
        // prmtcar		
        this.prmtcar.setQueryInfo("com.kingdee.eas.publicdata.app.CarQuery");		
        this.prmtcar.setVisible(true);		
        this.prmtcar.setEditable(true);		
        this.prmtcar.setDisplayFormat("$number$");		
        this.prmtcar.setEditFormat("$number$");		
        this.prmtcar.setCommitFormat("$number$");		
        this.prmtcar.setRequired(false);
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
					
        // prmtdriver		
        this.prmtdriver.setQueryInfo("com.kingdee.eas.farm.feemanager.basedata.app.DriverQuery");		
        this.prmtdriver.setVisible(true);		
        this.prmtdriver.setEditable(true);		
        this.prmtdriver.setDisplayFormat("$drivername$");		
        this.prmtdriver.setEditFormat("$number$");		
        this.prmtdriver.setCommitFormat("$number$");		
        this.prmtdriver.setRequired(false);
        		prmtdriver.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI prmtdriver_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtdriver_F7ListUI == null) {
					try {
						prmtdriver_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtdriver_F7ListUI));
					prmtdriver_F7ListUI.setF7Use(true,ctx);
					prmtdriver.setSelector(prmtdriver_F7ListUI);
				}
			}
		});
					
        prmtdriver.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtdriver_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtdriverPhone		
        this.txtdriverPhone.setVisible(true);		
        this.txtdriverPhone.setHorizontalAlignment(2);		
        this.txtdriverPhone.setMaxLength(80);		
        this.txtdriverPhone.setRequired(false);
        // txtpreHouseQty		
        this.txtpreHouseQty.setVisible(false);		
        this.txtpreHouseQty.setHorizontalAlignment(2);		
        this.txtpreHouseQty.setDataType(0);		
        this.txtpreHouseQty.setSupportedEmpty(true);		
        this.txtpreHouseQty.setRequired(false);
        // txtpreHouseSuttle		
        this.txtpreHouseSuttle.setVisible(false);		
        this.txtpreHouseSuttle.setHorizontalAlignment(2);		
        this.txtpreHouseSuttle.setDataType(1);		
        this.txtpreHouseSuttle.setSupportedEmpty(true);		
        this.txtpreHouseSuttle.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtpreHouseSuttle.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtpreHouseSuttle.setPrecision(2);		
        this.txtpreHouseSuttle.setRequired(false);		
        this.txtpreHouseSuttle.setEnabled(false);
        // kDPanel2
        // kdtQCEntrys
		String kdtQCEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"QCItem\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"randPType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"2\" t:styleID=\"sCol2\" /><t:Column t:key=\"actualRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"3\" t:styleID=\"sCol3\" /><t:Column t:key=\"punishAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" t:styleID=\"sCol4\" /><t:Column t:key=\"actualWgt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" t:styleID=\"sCol5\" /><t:Column t:key=\"punishWgt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"6\" t:styleID=\"sCol6\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{QCItem}</t:Cell><t:Cell>$Resource{randPType}</t:Cell><t:Cell>$Resource{actualRate}</t:Cell><t:Cell>$Resource{punishAmt}</t:Cell><t:Cell>$Resource{actualWgt}</t:Cell><t:Cell>$Resource{punishWgt}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtQCEntrys.setFormatXml(resHelper.translateString("kdtQCEntrys",kdtQCEntrysStrXML));
        kdtQCEntrys.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtQCEntrys_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtQCEntrys.putBindContents("editData",new String[] {"seq","QCItem","randPType","actualRate","punishAmt","actualWgt","punishWgt"});


        this.kdtQCEntrys.checkParsed();
        final KDBizPromptBox kdtQCEntrys_QCItem_PromptBox = new KDBizPromptBox();
        kdtQCEntrys_QCItem_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.RewardAndPunishItemQuery");
        kdtQCEntrys_QCItem_PromptBox.setVisible(true);
        kdtQCEntrys_QCItem_PromptBox.setEditable(true);
        kdtQCEntrys_QCItem_PromptBox.setDisplayFormat("$number$");
        kdtQCEntrys_QCItem_PromptBox.setEditFormat("$number$");
        kdtQCEntrys_QCItem_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtQCEntrys_QCItem_CellEditor = new KDTDefaultCellEditor(kdtQCEntrys_QCItem_PromptBox);
        this.kdtQCEntrys.getColumn("QCItem").setEditor(kdtQCEntrys_QCItem_CellEditor);
        ObjectValueRender kdtQCEntrys_QCItem_OVR = new ObjectValueRender();
        kdtQCEntrys_QCItem_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtQCEntrys.getColumn("QCItem").setRenderer(kdtQCEntrys_QCItem_OVR);
        			EntityViewInfo evikdtQCEntrys_QCItem_PromptBox = new EntityViewInfo ();
		evikdtQCEntrys_QCItem_PromptBox.setFilter(com.kingdee.eas.framework.FrameWorkUtils.getF7FilterInfoByAuthorizedOrg(com.kingdee.eas.basedata.org.OrgType.getEnum("Company"),"FICompany.id"));
		kdtQCEntrys_QCItem_PromptBox.setEntityViewInfo(evikdtQCEntrys_QCItem_PromptBox);
					
        KDComboBox kdtQCEntrys_randPType_ComboBox = new KDComboBox();
        kdtQCEntrys_randPType_ComboBox.setName("kdtQCEntrys_randPType_ComboBox");
        kdtQCEntrys_randPType_ComboBox.setVisible(true);
        kdtQCEntrys_randPType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.basedata.PunishType").toArray());
        KDTDefaultCellEditor kdtQCEntrys_randPType_CellEditor = new KDTDefaultCellEditor(kdtQCEntrys_randPType_ComboBox);
        this.kdtQCEntrys.getColumn("randPType").setEditor(kdtQCEntrys_randPType_CellEditor);
        KDFormattedTextField kdtQCEntrys_actualRate_TextField = new KDFormattedTextField();
        kdtQCEntrys_actualRate_TextField.setName("kdtQCEntrys_actualRate_TextField");
        kdtQCEntrys_actualRate_TextField.setVisible(true);
        kdtQCEntrys_actualRate_TextField.setEditable(true);
        kdtQCEntrys_actualRate_TextField.setHorizontalAlignment(2);
        kdtQCEntrys_actualRate_TextField.setDataType(1);
        	kdtQCEntrys_actualRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E25"));
        	kdtQCEntrys_actualRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E25"));
        kdtQCEntrys_actualRate_TextField.setPrecision(3);
        KDTDefaultCellEditor kdtQCEntrys_actualRate_CellEditor = new KDTDefaultCellEditor(kdtQCEntrys_actualRate_TextField);
        this.kdtQCEntrys.getColumn("actualRate").setEditor(kdtQCEntrys_actualRate_CellEditor);
        KDFormattedTextField kdtQCEntrys_punishAmt_TextField = new KDFormattedTextField();
        kdtQCEntrys_punishAmt_TextField.setName("kdtQCEntrys_punishAmt_TextField");
        kdtQCEntrys_punishAmt_TextField.setVisible(true);
        kdtQCEntrys_punishAmt_TextField.setEditable(true);
        kdtQCEntrys_punishAmt_TextField.setHorizontalAlignment(2);
        kdtQCEntrys_punishAmt_TextField.setDataType(1);
        	kdtQCEntrys_punishAmt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtQCEntrys_punishAmt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtQCEntrys_punishAmt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtQCEntrys_punishAmt_CellEditor = new KDTDefaultCellEditor(kdtQCEntrys_punishAmt_TextField);
        this.kdtQCEntrys.getColumn("punishAmt").setEditor(kdtQCEntrys_punishAmt_CellEditor);
        KDFormattedTextField kdtQCEntrys_actualWgt_TextField = new KDFormattedTextField();
        kdtQCEntrys_actualWgt_TextField.setName("kdtQCEntrys_actualWgt_TextField");
        kdtQCEntrys_actualWgt_TextField.setVisible(true);
        kdtQCEntrys_actualWgt_TextField.setEditable(true);
        kdtQCEntrys_actualWgt_TextField.setHorizontalAlignment(2);
        kdtQCEntrys_actualWgt_TextField.setDataType(1);
        	kdtQCEntrys_actualWgt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtQCEntrys_actualWgt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtQCEntrys_actualWgt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtQCEntrys_actualWgt_CellEditor = new KDTDefaultCellEditor(kdtQCEntrys_actualWgt_TextField);
        this.kdtQCEntrys.getColumn("actualWgt").setEditor(kdtQCEntrys_actualWgt_CellEditor);
        KDFormattedTextField kdtQCEntrys_punishWgt_TextField = new KDFormattedTextField();
        kdtQCEntrys_punishWgt_TextField.setName("kdtQCEntrys_punishWgt_TextField");
        kdtQCEntrys_punishWgt_TextField.setVisible(true);
        kdtQCEntrys_punishWgt_TextField.setEditable(true);
        kdtQCEntrys_punishWgt_TextField.setHorizontalAlignment(2);
        kdtQCEntrys_punishWgt_TextField.setDataType(1);
        	kdtQCEntrys_punishWgt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtQCEntrys_punishWgt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtQCEntrys_punishWgt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtQCEntrys_punishWgt_CellEditor = new KDTDefaultCellEditor(kdtQCEntrys_punishWgt_TextField);
        this.kdtQCEntrys.getColumn("punishWgt").setEditor(kdtQCEntrys_punishWgt_CellEditor);
        // contpunishAmt		
        this.contpunishAmt.setBoundLabelText(resHelper.getString("contpunishAmt.boundLabelText"));		
        this.contpunishAmt.setBoundLabelLength(120);		
        this.contpunishAmt.setBoundLabelUnderline(true);		
        this.contpunishAmt.setVisible(true);
        // contpunishWgt		
        this.contpunishWgt.setBoundLabelText(resHelper.getString("contpunishWgt.boundLabelText"));		
        this.contpunishWgt.setBoundLabelLength(120);		
        this.contpunishWgt.setBoundLabelUnderline(true);		
        this.contpunishWgt.setVisible(true);
        // contdiffChickenQty		
        this.contdiffChickenQty.setBoundLabelText(resHelper.getString("contdiffChickenQty.boundLabelText"));		
        this.contdiffChickenQty.setBoundLabelLength(100);		
        this.contdiffChickenQty.setBoundLabelUnderline(true);		
        this.contdiffChickenQty.setVisible(false);
        // contweighBillNum		
        this.contweighBillNum.setBoundLabelText(resHelper.getString("contweighBillNum.boundLabelText"));		
        this.contweighBillNum.setBoundLabelLength(100);		
        this.contweighBillNum.setBoundLabelUnderline(true);		
        this.contweighBillNum.setVisible(false);
        // txtpunishAmt		
        this.txtpunishAmt.setVisible(true);		
        this.txtpunishAmt.setHorizontalAlignment(2);		
        this.txtpunishAmt.setDataType(1);		
        this.txtpunishAmt.setSupportedEmpty(true);		
        this.txtpunishAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpunishAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpunishAmt.setPrecision(2);		
        this.txtpunishAmt.setRequired(false);		
        this.txtpunishAmt.setEnabled(false);
        // txtpunishWgt		
        this.txtpunishWgt.setVisible(true);		
        this.txtpunishWgt.setHorizontalAlignment(2);		
        this.txtpunishWgt.setDataType(1);		
        this.txtpunishWgt.setSupportedEmpty(true);		
        this.txtpunishWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpunishWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpunishWgt.setPrecision(4);		
        this.txtpunishWgt.setRequired(false);		
        this.txtpunishWgt.setEnabled(false);
        // txtdiffChickenQty		
        this.txtdiffChickenQty.setVisible(false);		
        this.txtdiffChickenQty.setHorizontalAlignment(2);		
        this.txtdiffChickenQty.setDataType(0);		
        this.txtdiffChickenQty.setSupportedEmpty(true);		
        this.txtdiffChickenQty.setRequired(false);
        // txtweighBillNum		
        this.txtweighBillNum.setVisible(false);		
        this.txtweighBillNum.setHorizontalAlignment(2);		
        this.txtweighBillNum.setMaxLength(100);		
        this.txtweighBillNum.setRequired(false);		
        this.txtweighBillNum.setEnabled(false);
        // txtsettleWgt		
        this.txtsettleWgt.setVisible(false);		
        this.txtsettleWgt.setHorizontalAlignment(2);		
        this.txtsettleWgt.setDataType(1);		
        this.txtsettleWgt.setSupportedEmpty(true);		
        this.txtsettleWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsettleWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsettleWgt.setPrecision(10);		
        this.txtsettleWgt.setRequired(false);		
        this.txtsettleWgt.setEnabled(false);
        // txtpreHouseGross		
        this.txtpreHouseGross.setVisible(false);		
        this.txtpreHouseGross.setHorizontalAlignment(2);		
        this.txtpreHouseGross.setDataType(1);		
        this.txtpreHouseGross.setSupportedEmpty(true);		
        this.txtpreHouseGross.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpreHouseGross.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpreHouseGross.setPrecision(4);		
        this.txtpreHouseGross.setRequired(false);
        // txtpreHouseTare		
        this.txtpreHouseTare.setVisible(false);		
        this.txtpreHouseTare.setHorizontalAlignment(2);		
        this.txtpreHouseTare.setDataType(1);		
        this.txtpreHouseTare.setSupportedEmpty(true);		
        this.txtpreHouseTare.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpreHouseTare.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpreHouseTare.setPrecision(4);		
        this.txtpreHouseTare.setRequired(false);
        // txtcompanyGross		
        this.txtcompanyGross.setVisible(false);		
        this.txtcompanyGross.setHorizontalAlignment(2);		
        this.txtcompanyGross.setDataType(1);		
        this.txtcompanyGross.setSupportedEmpty(true);		
        this.txtcompanyGross.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcompanyGross.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcompanyGross.setPrecision(4);		
        this.txtcompanyGross.setRequired(false);
        // txtcompanyTare		
        this.txtcompanyTare.setVisible(false);		
        this.txtcompanyTare.setHorizontalAlignment(2);		
        this.txtcompanyTare.setDataType(1);		
        this.txtcompanyTare.setSupportedEmpty(true);		
        this.txtcompanyTare.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcompanyTare.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcompanyTare.setPrecision(4);		
        this.txtcompanyTare.setRequired(false);
        // txtcompanySuttle		
        this.txtcompanySuttle.setVisible(false);		
        this.txtcompanySuttle.setHorizontalAlignment(2);		
        this.txtcompanySuttle.setDataType(1);		
        this.txtcompanySuttle.setSupportedEmpty(true);		
        this.txtcompanySuttle.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcompanySuttle.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcompanySuttle.setPrecision(4);		
        this.txtcompanySuttle.setRequired(false);		
        this.txtcompanySuttle.setEnabled(false);
        // prmtcalUnit		
        this.prmtcalUnit.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FreightCalPointQuery");		
        this.prmtcalUnit.setVisible(false);		
        this.prmtcalUnit.setEditable(true);		
        this.prmtcalUnit.setDisplayFormat("$name$");		
        this.prmtcalUnit.setEditFormat("$number$");		
        this.prmtcalUnit.setCommitFormat("$number$");		
        this.prmtcalUnit.setRequired(false);
        		EntityViewInfo eviprmtcalUnit = new EntityViewInfo ();
		eviprmtcalUnit.setFilter(com.kingdee.eas.framework.FrameWorkUtils.getF7FilterInfoByAuthorizedOrg(com.kingdee.eas.basedata.org.OrgType.getEnum("Company"),"FICompany.id"));
		prmtcalUnit.setEntityViewInfo(eviprmtcalUnit);
					
        // prmtcatchCKTeam		
        this.prmtcatchCKTeam.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.CatchCKTeamQuery");		
        this.prmtcatchCKTeam.setVisible(true);		
        this.prmtcatchCKTeam.setEditable(true);		
        this.prmtcatchCKTeam.setDisplayFormat("$name$");		
        this.prmtcatchCKTeam.setEditFormat("$number$");		
        this.prmtcatchCKTeam.setCommitFormat("$number$");		
        this.prmtcatchCKTeam.setRequired(false);
        		EntityViewInfo eviprmtcatchCKTeam = new EntityViewInfo ();
		eviprmtcatchCKTeam.setFilter(com.kingdee.eas.framework.FrameWorkUtils.getF7FilterInfoByAuthorizedOrg(com.kingdee.eas.basedata.org.OrgType.getEnum("Company"),"FICompany.id"));
		prmtcatchCKTeam.setEntityViewInfo(eviprmtcatchCKTeam);
					
        // contcarcassQty		
        this.contcarcassQty.setBoundLabelText(resHelper.getString("contcarcassQty.boundLabelText"));		
        this.contcarcassQty.setBoundLabelLength(100);		
        this.contcarcassQty.setBoundLabelUnderline(true);		
        this.contcarcassQty.setVisible(true);
        // contcarcassWgt		
        this.contcarcassWgt.setBoundLabelText(resHelper.getString("contcarcassWgt.boundLabelText"));		
        this.contcarcassWgt.setBoundLabelLength(100);		
        this.contcarcassWgt.setBoundLabelUnderline(true);		
        this.contcarcassWgt.setVisible(true);
        // contcAverageWgt		
        this.contcAverageWgt.setBoundLabelText(resHelper.getString("contcAverageWgt.boundLabelText"));		
        this.contcAverageWgt.setBoundLabelLength(100);		
        this.contcAverageWgt.setBoundLabelUnderline(true);		
        this.contcAverageWgt.setVisible(true);
        // contdiffQty		
        this.contdiffQty.setBoundLabelText(resHelper.getString("contdiffQty.boundLabelText"));		
        this.contdiffQty.setBoundLabelLength(100);		
        this.contdiffQty.setBoundLabelUnderline(true);		
        this.contdiffQty.setVisible(true);
        // contrecQty		
        this.contrecQty.setBoundLabelText(resHelper.getString("contrecQty.boundLabelText"));		
        this.contrecQty.setBoundLabelLength(100);		
        this.contrecQty.setBoundLabelUnderline(true);		
        this.contrecQty.setVisible(true);
        // contincompleteQty		
        this.contincompleteQty.setBoundLabelText(resHelper.getString("contincompleteQty.boundLabelText"));		
        this.contincompleteQty.setBoundLabelLength(100);		
        this.contincompleteQty.setBoundLabelUnderline(true);		
        this.contincompleteQty.setVisible(true);
        // contincompleteWgt		
        this.contincompleteWgt.setBoundLabelText(resHelper.getString("contincompleteWgt.boundLabelText"));		
        this.contincompleteWgt.setBoundLabelLength(100);		
        this.contincompleteWgt.setBoundLabelUnderline(true);		
        this.contincompleteWgt.setVisible(true);
        // contincompleteRate		
        this.contincompleteRate.setBoundLabelText(resHelper.getString("contincompleteRate.boundLabelText"));		
        this.contincompleteRate.setBoundLabelLength(100);		
        this.contincompleteRate.setBoundLabelUnderline(true);		
        this.contincompleteRate.setVisible(true);
        // contmeatRate		
        this.contmeatRate.setBoundLabelText(resHelper.getString("contmeatRate.boundLabelText"));		
        this.contmeatRate.setBoundLabelLength(100);		
        this.contmeatRate.setBoundLabelUnderline(true);		
        this.contmeatRate.setVisible(true);
        // contdressingPercent		
        this.contdressingPercent.setBoundLabelText(resHelper.getString("contdressingPercent.boundLabelText"));		
        this.contdressingPercent.setBoundLabelLength(100);		
        this.contdressingPercent.setBoundLabelUnderline(true);		
        this.contdressingPercent.setVisible(true);
        // txtcarcassQty		
        this.txtcarcassQty.setVisible(true);		
        this.txtcarcassQty.setHorizontalAlignment(2);		
        this.txtcarcassQty.setDataType(0);		
        this.txtcarcassQty.setSupportedEmpty(true);		
        this.txtcarcassQty.setRequired(false);
        // txtcarcassWgt		
        this.txtcarcassWgt.setVisible(true);		
        this.txtcarcassWgt.setHorizontalAlignment(2);		
        this.txtcarcassWgt.setDataType(1);		
        this.txtcarcassWgt.setSupportedEmpty(true);		
        this.txtcarcassWgt.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtcarcassWgt.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtcarcassWgt.setPrecision(2);		
        this.txtcarcassWgt.setRequired(false);
        // txtcAverageWgt		
        this.txtcAverageWgt.setVisible(true);		
        this.txtcAverageWgt.setHorizontalAlignment(2);		
        this.txtcAverageWgt.setDataType(1);		
        this.txtcAverageWgt.setSupportedEmpty(true);		
        this.txtcAverageWgt.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtcAverageWgt.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtcAverageWgt.setPrecision(2);		
        this.txtcAverageWgt.setRequired(false);		
        this.txtcAverageWgt.setEnabled(false);
        // txtdiffQty		
        this.txtdiffQty.setVisible(true);		
        this.txtdiffQty.setHorizontalAlignment(2);		
        this.txtdiffQty.setDataType(0);		
        this.txtdiffQty.setSupportedEmpty(true);		
        this.txtdiffQty.setRequired(false);		
        this.txtdiffQty.setEnabled(false);
        // txtrecQty		
        this.txtrecQty.setVisible(true);		
        this.txtrecQty.setHorizontalAlignment(2);		
        this.txtrecQty.setDataType(0);		
        this.txtrecQty.setSupportedEmpty(true);		
        this.txtrecQty.setRequired(false);		
        this.txtrecQty.setEnabled(false);
        // txtincompleteQty		
        this.txtincompleteQty.setVisible(true);		
        this.txtincompleteQty.setHorizontalAlignment(2);		
        this.txtincompleteQty.setDataType(0);		
        this.txtincompleteQty.setSupportedEmpty(true);		
        this.txtincompleteQty.setRequired(false);
        // txtincompleteWgt		
        this.txtincompleteWgt.setVisible(true);		
        this.txtincompleteWgt.setHorizontalAlignment(2);		
        this.txtincompleteWgt.setDataType(1);		
        this.txtincompleteWgt.setSupportedEmpty(true);		
        this.txtincompleteWgt.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtincompleteWgt.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtincompleteWgt.setPrecision(2);		
        this.txtincompleteWgt.setRequired(false);
        // txtincompleteRate		
        this.txtincompleteRate.setVisible(true);		
        this.txtincompleteRate.setHorizontalAlignment(2);		
        this.txtincompleteRate.setDataType(1);		
        this.txtincompleteRate.setSupportedEmpty(true);		
        this.txtincompleteRate.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtincompleteRate.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtincompleteRate.setPrecision(4);		
        this.txtincompleteRate.setRequired(false);		
        this.txtincompleteRate.setEnabled(false);
        // txtmeatRate		
        this.txtmeatRate.setVisible(true);		
        this.txtmeatRate.setHorizontalAlignment(2);		
        this.txtmeatRate.setDataType(1);		
        this.txtmeatRate.setSupportedEmpty(true);		
        this.txtmeatRate.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmeatRate.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmeatRate.setPrecision(4);		
        this.txtmeatRate.setRequired(false);		
        this.txtmeatRate.setEnabled(false);
        // txtdressingPercent		
        this.txtdressingPercent.setVisible(true);		
        this.txtdressingPercent.setHorizontalAlignment(2);		
        this.txtdressingPercent.setDataType(1);		
        this.txtdressingPercent.setSupportedEmpty(true);		
        this.txtdressingPercent.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdressingPercent.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdressingPercent.setPrecision(4);		
        this.txtdressingPercent.setRequired(false);		
        this.txtdressingPercent.setEnabled(false);
        // txtreceQty		
        this.txtreceQty.setVisible(true);		
        this.txtreceQty.setHorizontalAlignment(2);		
        this.txtreceQty.setDataType(1);		
        this.txtreceQty.setSupportedEmpty(true);		
        this.txtreceQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtreceQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtreceQty.setPrecision(4);		
        this.txtreceQty.setRequired(false);
        // txtAQty		
        this.txtAQty.setVisible(true);		
        this.txtAQty.setHorizontalAlignment(2);		
        this.txtAQty.setDataType(1);		
        this.txtAQty.setSupportedEmpty(true);		
        this.txtAQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtAQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtAQty.setPrecision(4);		
        this.txtAQty.setRequired(false);		
        this.txtAQty.setEnabled(false);
        // txtBQty		
        this.txtBQty.setVisible(true);		
        this.txtBQty.setHorizontalAlignment(2);		
        this.txtBQty.setDataType(1);		
        this.txtBQty.setSupportedEmpty(true);		
        this.txtBQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtBQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtBQty.setPrecision(4);		
        this.txtBQty.setRequired(false);
        // txtBWeight		
        this.txtBWeight.setVisible(true);		
        this.txtBWeight.setHorizontalAlignment(2);		
        this.txtBWeight.setDataType(1);		
        this.txtBWeight.setSupportedEmpty(true);		
        this.txtBWeight.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtBWeight.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtBWeight.setPrecision(10);		
        this.txtBWeight.setRequired(false);		
        this.txtBWeight.setEnabled(false);
        // txtreturnWeight		
        this.txtreturnWeight.setVisible(true);		
        this.txtreturnWeight.setHorizontalAlignment(2);		
        this.txtreturnWeight.setDataType(1);		
        this.txtreturnWeight.setSupportedEmpty(true);		
        this.txtreturnWeight.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtreturnWeight.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtreturnWeight.setPrecision(10);		
        this.txtreturnWeight.setRequired(false);
        // txtAWeight		
        this.txtAWeight.setVisible(true);		
        this.txtAWeight.setHorizontalAlignment(2);		
        this.txtAWeight.setDataType(1);		
        this.txtAWeight.setSupportedEmpty(true);		
        this.txtAWeight.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtAWeight.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtAWeight.setPrecision(10);		
        this.txtAWeight.setRequired(false);		
        this.txtAWeight.setEnabled(false);
        // prmtchicWeighr		
        this.prmtchicWeighr.setQueryInfo("com.kingdee.eas.weighbridge.app.InStorageBillQuery");		
        this.prmtchicWeighr.setEditable(true);		
        this.prmtchicWeighr.setDisplayFormat("$number$");		
        this.prmtchicWeighr.setEditFormat("$number$");		
        this.prmtchicWeighr.setCommitFormat("$number$");		
        this.prmtchicWeighr.setRequired(true);		
        this.prmtchicWeighr.setEnabledMultiSelection(true);
        // txtF7Number		
        this.txtF7Number.setHorizontalAlignment(2);		
        this.txtF7Number.setMaxLength(200);		
        this.txtF7Number.setRequired(false);		
        this.txtF7Number.setVisible(false);
        // txtF7id		
        this.txtF7id.setHorizontalAlignment(2);		
        this.txtF7id.setMaxLength(200);		
        this.txtF7id.setRequired(false);		
        this.txtF7id.setVisible(false);
        // txtsettleWeight		
        this.txtsettleWeight.setVisible(true);		
        this.txtsettleWeight.setHorizontalAlignment(2);		
        this.txtsettleWeight.setDataType(1);		
        this.txtsettleWeight.setSupportedEmpty(true);		
        this.txtsettleWeight.setMinimumValue( new java.math.BigDecimal("-9.999999999999999E22"));		
        this.txtsettleWeight.setMaximumValue( new java.math.BigDecimal("9.999999999999999E22"));		
        this.txtsettleWeight.setPrecision(5);		
        this.txtsettleWeight.setRequired(false);		
        this.txtsettleWeight.setEnabled(false);
        // txtavgWeight		
        this.txtavgWeight.setVisible(true);		
        this.txtavgWeight.setHorizontalAlignment(2);		
        this.txtavgWeight.setDataType(1);		
        this.txtavgWeight.setSupportedEmpty(true);		
        this.txtavgWeight.setMinimumValue( new java.math.BigDecimal("-9.999999999999999E22"));		
        this.txtavgWeight.setMaximumValue( new java.math.BigDecimal("9.999999999999999E22"));		
        this.txtavgWeight.setPrecision(5);		
        this.txtavgWeight.setRequired(false);		
        this.txtavgWeight.setEnabled(false);
        // prmtcostCenter		
        this.prmtcostCenter.setQueryInfo("com.kingdee.eas.basedata.org.app.CostCenterItemQuery");		
        this.prmtcostCenter.setVisible(true);		
        this.prmtcostCenter.setEditable(true);		
        this.prmtcostCenter.setDisplayFormat("$name$");		
        this.prmtcostCenter.setEditFormat("$number$");		
        this.prmtcostCenter.setCommitFormat("$number$");		
        this.prmtcostCenter.setRequired(false);		
        this.prmtcostCenter.setEnabled(false);
        // txtdeathQty		
        this.txtdeathQty.setVisible(true);		
        this.txtdeathQty.setHorizontalAlignment(2);		
        this.txtdeathQty.setDataType(1);		
        this.txtdeathQty.setSupportedEmpty(true);		
        this.txtdeathQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdeathQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdeathQty.setPrecision(4);		
        this.txtdeathQty.setRequired(false);		
        this.txtdeathQty.setEnabled(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,prmtfarmer,prmtfarm,prmtbatchContract,prmtbatch,prmtsettlePolicy,pkinDate,txtbatchQty,prmtperson,txtfarmAddress,farmType,saleType,prmtcustomer,txtfarmerPhone,prmtbreedData,txtoutSalePrice,prmtcar,prmtdriver,txtdriverPhone,txtpreHouseQty,txtpreHouseSuttle,txtcarcassQty,txtcarcassWgt,txtincompleteQty,txtincompleteWgt,txtcAverageWgt,txtincompleteRate,txtdiffQty,txtmeatRate,txtrecQty,txtpunishAmt,txtpunishWgt,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,kdtQCEntrys,billStatus,pkauditTime,prmtFICompany,txtpreHouseGross,txtpreHouseTare,chkisHasShengChanRK,chkisHasSaleIssue,txtdiffChickenQty,txtdressingPercent,txtcompanyGross,txtcompanyTare,txtcompanySuttle,prmtcalUnit,chkhasFreightBill,prmtcatchCKTeam,chkweighed,txtweighBillNum,chkhasLLCK,chkhasQTCK,txtreceQty,txtAQty,txtBQty,txtBWeight,txtreturnWeight,txtAWeight,chkisPrepare,prmtchicWeighr,txtF7Number,txtF7id,txtsettleWeight,chkisManRec,chkisSaleOut,txtavgWeight,prmtcostCenter,txtdeathQty}));
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
        this.setBounds(new Rectangle(-10, 2, 1235, 821));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(-10, 2, 1235, 821));
        contCreator.setBounds(new Rectangle(461, 753, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(461, 753, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(814, 752, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(814, 752, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(460, 785, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(460, 785, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(813, 784, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(813, 784, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(42, 13, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(42, 13, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(342, 13, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(342, 13, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(949, 125, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(949, 125, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(68, 752, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(68, 752, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contFICompany.setBounds(new Rectangle(645, 13, 270, 19));
        this.add(contFICompany, new KDLayout.Constraints(645, 13, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(67, 784, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(67, 784, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmer.setBounds(new Rectangle(42, 41, 270, 19));
        this.add(contfarmer, new KDLayout.Constraints(42, 41, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarm.setBounds(new Rectangle(645, 41, 270, 19));
        this.add(contfarm, new KDLayout.Constraints(645, 41, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbatchContract.setBounds(new Rectangle(42, 69, 270, 19));
        this.add(contbatchContract, new KDLayout.Constraints(42, 69, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbatch.setBounds(new Rectangle(342, 69, 270, 19));
        this.add(contbatch, new KDLayout.Constraints(342, 69, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(949, 13, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(949, 13, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contsettlePolicy.setBounds(new Rectangle(42, 97, 270, 19));
        this.add(contsettlePolicy, new KDLayout.Constraints(42, 97, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        continDate.setBounds(new Rectangle(645, 69, 270, 19));
        this.add(continDate, new KDLayout.Constraints(645, 69, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbatchQty.setBounds(new Rectangle(949, 69, 270, 19));
        this.add(contbatchQty, new KDLayout.Constraints(949, 69, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator9.setBounds(new Rectangle(-15, 738, 1267, 8));
        this.add(kDSeparator9, new KDLayout.Constraints(-15, 738, 1267, 8, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contperson.setBounds(new Rectangle(342, 97, 270, 19));
        this.add(contperson, new KDLayout.Constraints(342, 97, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmAddress.setBounds(new Rectangle(949, 41, 270, 19));
        this.add(contfarmAddress, new KDLayout.Constraints(949, 41, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfarmType.setBounds(new Rectangle(949, 97, 270, 19));
        this.add(contfarmType, new KDLayout.Constraints(949, 97, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contsaleType.setBounds(new Rectangle(42, 125, 270, 19));
        this.add(contsaleType, new KDLayout.Constraints(42, 125, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcustomer.setBounds(new Rectangle(342, 125, 270, 19));
        this.add(contcustomer, new KDLayout.Constraints(342, 125, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmerPhone.setBounds(new Rectangle(342, 41, 270, 19));
        this.add(contfarmerPhone, new KDLayout.Constraints(342, 41, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbreedData.setBounds(new Rectangle(645, 97, 270, 19));
        this.add(contbreedData, new KDLayout.Constraints(645, 97, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoutSalePrice.setBounds(new Rectangle(645, 125, 270, 19));
        this.add(contoutSalePrice, new KDLayout.Constraints(645, 125, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcar.setBounds(new Rectangle(42, 153, 270, 19));
        this.add(contcar, new KDLayout.Constraints(42, 153, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdriver.setBounds(new Rectangle(342, 153, 270, 19));
        this.add(contdriver, new KDLayout.Constraints(342, 153, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdriverPhone.setBounds(new Rectangle(645, 153, 270, 19));
        this.add(contdriverPhone, new KDLayout.Constraints(645, 153, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpreHouseQty.setBounds(new Rectangle(933, 271, 270, 19));
        this.add(contpreHouseQty, new KDLayout.Constraints(933, 271, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpreHouseSuttle.setBounds(new Rectangle(-247, 273, 270, 19));
        this.add(contpreHouseSuttle, new KDLayout.Constraints(-247, 273, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator8.setBounds(new Rectangle(-87, 273, 1371, 8));
        this.add(kDSeparator8, new KDLayout.Constraints(-87, 273, 1371, 8, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDTabbedPane1.setBounds(new Rectangle(35, 286, 1169, 447));
        this.add(kDTabbedPane1, new KDLayout.Constraints(35, 286, 1169, 447, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contsettleWgt.setBounds(new Rectangle(1231, 218, 72, 19));
        this.add(contsettleWgt, new KDLayout.Constraints(1231, 218, 72, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpreHouseGross.setBounds(new Rectangle(-271, 319, 270, 19));
        this.add(contpreHouseGross, new KDLayout.Constraints(-271, 319, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpreHouseTare.setBounds(new Rectangle(-254, 296, 270, 19));
        this.add(contpreHouseTare, new KDLayout.Constraints(-254, 296, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisHasShengChanRK.setBounds(new Rectangle(1230, 287, 144, 19));
        this.add(chkisHasShengChanRK, new KDLayout.Constraints(1230, 287, 144, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisHasSaleIssue.setBounds(new Rectangle(1227, 316, 138, 19));
        this.add(chkisHasSaleIssue, new KDLayout.Constraints(1227, 316, 138, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompanyGross.setBounds(new Rectangle(54, -6, 270, 19));
        this.add(contcompanyGross, new KDLayout.Constraints(54, -6, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompanyTare.setBounds(new Rectangle(354, -6, 270, 19));
        this.add(contcompanyTare, new KDLayout.Constraints(354, -6, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompanySuttle.setBounds(new Rectangle(657, -6, 270, 19));
        this.add(contcompanySuttle, new KDLayout.Constraints(657, -6, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcalUnit.setBounds(new Rectangle(960, -6, 270, 19));
        this.add(contcalUnit, new KDLayout.Constraints(960, -6, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkhasFreightBill.setBounds(new Rectangle(1233, 337, 168, 19));
        this.add(chkhasFreightBill, new KDLayout.Constraints(1233, 337, 168, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcatchCKTeam.setBounds(new Rectangle(949, 153, 270, 19));
        this.add(contcatchCKTeam, new KDLayout.Constraints(949, 153, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkweighed.setBounds(new Rectangle(1228, 256, 118, 19));
        this.add(chkweighed, new KDLayout.Constraints(1228, 256, 118, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkhasLLCK.setBounds(new Rectangle(1227, 235, 93, 19));
        this.add(chkhasLLCK, new KDLayout.Constraints(1227, 235, 93, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkhasQTCK.setBounds(new Rectangle(1229, 302, 270, 19));
        this.add(chkhasQTCK, new KDLayout.Constraints(1229, 302, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDPanel1.setBounds(new Rectangle(1235, 384, 288, 52));
        this.add(kDPanel1, new KDLayout.Constraints(1235, 384, 288, 52, 0));
        contreceQty.setBounds(new Rectangle(40, 182, 270, 19));
        this.add(contreceQty, new KDLayout.Constraints(40, 182, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAQty.setBounds(new Rectangle(341, 182, 270, 19));
        this.add(contAQty, new KDLayout.Constraints(341, 182, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBQty.setBounds(new Rectangle(644, 182, 270, 19));
        this.add(contBQty, new KDLayout.Constraints(644, 182, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBWeight.setBounds(new Rectangle(950, 186, 270, 19));
        this.add(contBWeight, new KDLayout.Constraints(950, 186, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contreturnWeight.setBounds(new Rectangle(40, 209, 270, 19));
        this.add(contreturnWeight, new KDLayout.Constraints(40, 209, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAWeight.setBounds(new Rectangle(341, 209, 270, 19));
        this.add(contAWeight, new KDLayout.Constraints(341, 209, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisPrepare.setBounds(new Rectangle(644, 230, 270, 19));
        this.add(chkisPrepare, new KDLayout.Constraints(644, 230, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contchicWeighr.setBounds(new Rectangle(950, 209, 270, 19));
        this.add(contchicWeighr, new KDLayout.Constraints(950, 209, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contF7Number.setBounds(new Rectangle(348, 257, 270, 19));
        this.add(contF7Number, new KDLayout.Constraints(348, 257, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contF7id.setBounds(new Rectangle(649, 257, 270, 19));
        this.add(contF7id, new KDLayout.Constraints(649, 257, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsettleWeight.setBounds(new Rectangle(40, 230, 270, 19));
        this.add(contsettleWeight, new KDLayout.Constraints(40, 230, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisManRec.setBounds(new Rectangle(1106, 230, 114, 19));
        this.add(chkisManRec, new KDLayout.Constraints(1106, 230, 114, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkisSaleOut.setBounds(new Rectangle(950, 230, 117, 19));
        this.add(chkisSaleOut, new KDLayout.Constraints(950, 230, 117, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contavgWeight.setBounds(new Rectangle(341, 230, 270, 19));
        this.add(contavgWeight, new KDLayout.Constraints(341, 230, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcostCenter.setBounds(new Rectangle(40, 258, 270, 19));
        this.add(contcostCenter, new KDLayout.Constraints(40, 258, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdeathQty.setBounds(new Rectangle(644, 209, 270, 19));
        this.add(contdeathQty, new KDLayout.Constraints(644, 209, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contFICompany
        contFICompany.setBoundEditor(prmtFICompany);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contfarmer
        contfarmer.setBoundEditor(prmtfarmer);
        //contfarm
        contfarm.setBoundEditor(prmtfarm);
        //contbatchContract
        contbatchContract.setBoundEditor(prmtbatchContract);
        //contbatch
        contbatch.setBoundEditor(prmtbatch);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //contsettlePolicy
        contsettlePolicy.setBoundEditor(prmtsettlePolicy);
        //continDate
        continDate.setBoundEditor(pkinDate);
        //contbatchQty
        contbatchQty.setBoundEditor(txtbatchQty);
        //contperson
        contperson.setBoundEditor(prmtperson);
        //contfarmAddress
        contfarmAddress.setBoundEditor(txtfarmAddress);
        //contfarmType
        contfarmType.setBoundEditor(farmType);
        //contsaleType
        contsaleType.setBoundEditor(saleType);
        //contcustomer
        contcustomer.setBoundEditor(prmtcustomer);
        //contfarmerPhone
        contfarmerPhone.setBoundEditor(txtfarmerPhone);
        //contbreedData
        contbreedData.setBoundEditor(prmtbreedData);
        //contoutSalePrice
        contoutSalePrice.setBoundEditor(txtoutSalePrice);
        //contcar
        contcar.setBoundEditor(prmtcar);
        //contdriver
        contdriver.setBoundEditor(prmtdriver);
        //contdriverPhone
        contdriverPhone.setBoundEditor(txtdriverPhone);
        //contpreHouseQty
        contpreHouseQty.setBoundEditor(txtpreHouseQty);
        //contpreHouseSuttle
        contpreHouseSuttle.setBoundEditor(txtpreHouseSuttle);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1168, 414));        kdtQCEntrys.setBounds(new Rectangle(10, 44, 1151, 404));
        kdtQCEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtQCEntrys,new com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillQCEntryInfo(),null,false);
        kDPanel2.add(kdtQCEntrys_detailPanel, new KDLayout.Constraints(10, 44, 1151, 404, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtQCEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("randPType","0");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        contpunishAmt.setBounds(new Rectangle(16, 13, 270, 19));
        kDPanel2.add(contpunishAmt, new KDLayout.Constraints(16, 13, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpunishWgt.setBounds(new Rectangle(332, 13, 270, 19));
        kDPanel2.add(contpunishWgt, new KDLayout.Constraints(332, 13, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdiffChickenQty.setBounds(new Rectangle(667, 4, 270, 19));
        kDPanel2.add(contdiffChickenQty, new KDLayout.Constraints(667, 4, 270, 19, 0));
        contweighBillNum.setBounds(new Rectangle(916, 4, 270, 19));
        kDPanel2.add(contweighBillNum, new KDLayout.Constraints(916, 4, 270, 19, 0));
        //contpunishAmt
        contpunishAmt.setBoundEditor(txtpunishAmt);
        //contpunishWgt
        contpunishWgt.setBoundEditor(txtpunishWgt);
        //contdiffChickenQty
        contdiffChickenQty.setBoundEditor(txtdiffChickenQty);
        //contweighBillNum
        contweighBillNum.setBoundEditor(txtweighBillNum);
        //contsettleWgt
        contsettleWgt.setBoundEditor(txtsettleWgt);
        //contpreHouseGross
        contpreHouseGross.setBoundEditor(txtpreHouseGross);
        //contpreHouseTare
        contpreHouseTare.setBoundEditor(txtpreHouseTare);
        //contcompanyGross
        contcompanyGross.setBoundEditor(txtcompanyGross);
        //contcompanyTare
        contcompanyTare.setBoundEditor(txtcompanyTare);
        //contcompanySuttle
        contcompanySuttle.setBoundEditor(txtcompanySuttle);
        //contcalUnit
        contcalUnit.setBoundEditor(prmtcalUnit);
        //contcatchCKTeam
        contcatchCKTeam.setBoundEditor(prmtcatchCKTeam);
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(1235, 384, 288, 52));        contcarcassQty.setBounds(new Rectangle(28, 31, 270, 19));
        kDPanel1.add(contcarcassQty, new KDLayout.Constraints(28, 31, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcarcassWgt.setBounds(new Rectangle(313, 26, 270, 19));
        kDPanel1.add(contcarcassWgt, new KDLayout.Constraints(313, 26, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcAverageWgt.setBounds(new Rectangle(599, 85, 270, 19));
        kDPanel1.add(contcAverageWgt, new KDLayout.Constraints(599, 85, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdiffQty.setBounds(new Rectangle(313, 137, 270, 19));
        kDPanel1.add(contdiffQty, new KDLayout.Constraints(313, 137, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contrecQty.setBounds(new Rectangle(28, 85, 270, 19));
        kDPanel1.add(contrecQty, new KDLayout.Constraints(28, 85, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contincompleteQty.setBounds(new Rectangle(599, 27, 270, 19));
        kDPanel1.add(contincompleteQty, new KDLayout.Constraints(599, 27, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contincompleteWgt.setBounds(new Rectangle(886, 27, 270, 19));
        kDPanel1.add(contincompleteWgt, new KDLayout.Constraints(886, 27, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contincompleteRate.setBounds(new Rectangle(28, 137, 270, 19));
        kDPanel1.add(contincompleteRate, new KDLayout.Constraints(28, 137, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmeatRate.setBounds(new Rectangle(886, 85, 270, 19));
        kDPanel1.add(contmeatRate, new KDLayout.Constraints(886, 85, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contdressingPercent.setBounds(new Rectangle(313, 85, 270, 19));
        kDPanel1.add(contdressingPercent, new KDLayout.Constraints(313, 85, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contcarcassQty
        contcarcassQty.setBoundEditor(txtcarcassQty);
        //contcarcassWgt
        contcarcassWgt.setBoundEditor(txtcarcassWgt);
        //contcAverageWgt
        contcAverageWgt.setBoundEditor(txtcAverageWgt);
        //contdiffQty
        contdiffQty.setBoundEditor(txtdiffQty);
        //contrecQty
        contrecQty.setBoundEditor(txtrecQty);
        //contincompleteQty
        contincompleteQty.setBoundEditor(txtincompleteQty);
        //contincompleteWgt
        contincompleteWgt.setBoundEditor(txtincompleteWgt);
        //contincompleteRate
        contincompleteRate.setBoundEditor(txtincompleteRate);
        //contmeatRate
        contmeatRate.setBoundEditor(txtmeatRate);
        //contdressingPercent
        contdressingPercent.setBoundEditor(txtdressingPercent);
        //contreceQty
        contreceQty.setBoundEditor(txtreceQty);
        //contAQty
        contAQty.setBoundEditor(txtAQty);
        //contBQty
        contBQty.setBoundEditor(txtBQty);
        //contBWeight
        contBWeight.setBoundEditor(txtBWeight);
        //contreturnWeight
        contreturnWeight.setBoundEditor(txtreturnWeight);
        //contAWeight
        contAWeight.setBoundEditor(txtAWeight);
        //contchicWeighr
        contchicWeighr.setBoundEditor(prmtchicWeighr);
        //contF7Number
        contF7Number.setBoundEditor(txtF7Number);
        //contF7id
        contF7id.setBoundEditor(txtF7id);
        //contsettleWeight
        contsettleWeight.setBoundEditor(txtsettleWeight);
        //contavgWeight
        contavgWeight.setBoundEditor(txtavgWeight);
        //contcostCenter
        contcostCenter.setBoundEditor(prmtcostCenter);
        //contdeathQty
        contdeathQty.setBoundEditor(txtdeathQty);

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
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);
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
		dataBinder.registerBinding("isHasShengChanRK", boolean.class, this.chkisHasShengChanRK, "selected");
		dataBinder.registerBinding("isHasSaleIssue", boolean.class, this.chkisHasSaleIssue, "selected");
		dataBinder.registerBinding("hasFreightBill", boolean.class, this.chkhasFreightBill, "selected");
		dataBinder.registerBinding("weighed", boolean.class, this.chkweighed, "selected");
		dataBinder.registerBinding("hasLLCK", boolean.class, this.chkhasLLCK, "selected");
		dataBinder.registerBinding("hasQTCK", boolean.class, this.chkhasQTCK, "selected");
		dataBinder.registerBinding("isPrepare", boolean.class, this.chkisPrepare, "selected");
		dataBinder.registerBinding("isManRec", boolean.class, this.chkisManRec, "selected");
		dataBinder.registerBinding("isSaleOut", boolean.class, this.chkisSaleOut, "selected");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("FICompany", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtFICompany, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("farmer", com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo.class, this.prmtfarmer, "data");
		dataBinder.registerBinding("farm", com.kingdee.eas.farm.carnivorous.basedata.FarmInfo.class, this.prmtfarm, "data");
		dataBinder.registerBinding("batchContract", com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo.class, this.prmtbatchContract, "data");
		dataBinder.registerBinding("batch", com.kingdee.eas.farm.carnivorous.basedata.BatchInfo.class, this.prmtbatch, "data");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("settlePolicy", com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo.class, this.prmtsettlePolicy, "data");
		dataBinder.registerBinding("inDate", java.util.Date.class, this.pkinDate, "value");
		dataBinder.registerBinding("batchQty", java.math.BigDecimal.class, this.txtbatchQty, "value");
		dataBinder.registerBinding("person", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtperson, "data");
		dataBinder.registerBinding("farmAddress", String.class, this.txtfarmAddress, "text");
		dataBinder.registerBinding("farmType", com.kingdee.eas.farm.stocking.basedata.FarmsType.class, this.farmType, "selectedItem");
		dataBinder.registerBinding("saleType", com.kingdee.eas.farm.carnivorous.recyclebiz.SaleBizType.class, this.saleType, "selectedItem");
		dataBinder.registerBinding("customer", com.kingdee.eas.basedata.master.cssp.CustomerInfo.class, this.prmtcustomer, "data");
		dataBinder.registerBinding("farmerPhone", String.class, this.txtfarmerPhone, "text");
		dataBinder.registerBinding("breedData", com.kingdee.eas.farm.stocking.basedata.BreedDataInfo.class, this.prmtbreedData, "data");
		dataBinder.registerBinding("outSalePrice", java.math.BigDecimal.class, this.txtoutSalePrice, "value");
		dataBinder.registerBinding("car", com.kingdee.eas.publicdata.CarInfo.class, this.prmtcar, "data");
		dataBinder.registerBinding("driver", com.kingdee.eas.farm.feemanager.basedata.DriverInfo.class, this.prmtdriver, "data");
		dataBinder.registerBinding("driverPhone", String.class, this.txtdriverPhone, "text");
		dataBinder.registerBinding("preHouseQty", int.class, this.txtpreHouseQty, "value");
		dataBinder.registerBinding("preHouseSuttle", java.math.BigDecimal.class, this.txtpreHouseSuttle, "value");
		dataBinder.registerBinding("QCEntrys.seq", int.class, this.kdtQCEntrys, "seq.text");
		dataBinder.registerBinding("QCEntrys", com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillQCEntryInfo.class, this.kdtQCEntrys, "userObject");
		dataBinder.registerBinding("QCEntrys.QCItem", java.lang.Object.class, this.kdtQCEntrys, "QCItem.text");
		dataBinder.registerBinding("QCEntrys.actualRate", java.math.BigDecimal.class, this.kdtQCEntrys, "actualRate.text");
		dataBinder.registerBinding("QCEntrys.punishAmt", java.math.BigDecimal.class, this.kdtQCEntrys, "punishAmt.text");
		dataBinder.registerBinding("QCEntrys.actualWgt", java.math.BigDecimal.class, this.kdtQCEntrys, "actualWgt.text");
		dataBinder.registerBinding("QCEntrys.punishWgt", java.math.BigDecimal.class, this.kdtQCEntrys, "punishWgt.text");
		dataBinder.registerBinding("QCEntrys.randPType", com.kingdee.util.enums.Enum.class, this.kdtQCEntrys, "randPType.text");
		dataBinder.registerBinding("punishAmt", java.math.BigDecimal.class, this.txtpunishAmt, "value");
		dataBinder.registerBinding("punishWgt", java.math.BigDecimal.class, this.txtpunishWgt, "value");
		dataBinder.registerBinding("diffChickenQty", int.class, this.txtdiffChickenQty, "value");
		dataBinder.registerBinding("weighBillNum", String.class, this.txtweighBillNum, "text");
		dataBinder.registerBinding("settleWgt", java.math.BigDecimal.class, this.txtsettleWgt, "value");
		dataBinder.registerBinding("preHouseGross", java.math.BigDecimal.class, this.txtpreHouseGross, "value");
		dataBinder.registerBinding("preHouseTare", java.math.BigDecimal.class, this.txtpreHouseTare, "value");
		dataBinder.registerBinding("companyGross", java.math.BigDecimal.class, this.txtcompanyGross, "value");
		dataBinder.registerBinding("companyTare", java.math.BigDecimal.class, this.txtcompanyTare, "value");
		dataBinder.registerBinding("companySuttle", java.math.BigDecimal.class, this.txtcompanySuttle, "value");
		dataBinder.registerBinding("calUnit", com.kingdee.eas.farm.carnivorous.basedata.FreightCalPointInfo.class, this.prmtcalUnit, "data");
		dataBinder.registerBinding("catchCKTeam", com.kingdee.eas.farm.carnivorous.basedata.CatchCKTeamInfo.class, this.prmtcatchCKTeam, "data");
		dataBinder.registerBinding("carcassQty", int.class, this.txtcarcassQty, "value");
		dataBinder.registerBinding("carcassWgt", java.math.BigDecimal.class, this.txtcarcassWgt, "value");
		dataBinder.registerBinding("cAverageWgt", java.math.BigDecimal.class, this.txtcAverageWgt, "value");
		dataBinder.registerBinding("diffQty", int.class, this.txtdiffQty, "value");
		dataBinder.registerBinding("recQty", int.class, this.txtrecQty, "value");
		dataBinder.registerBinding("incompleteQty", int.class, this.txtincompleteQty, "value");
		dataBinder.registerBinding("incompleteWgt", java.math.BigDecimal.class, this.txtincompleteWgt, "value");
		dataBinder.registerBinding("incompleteRate", java.math.BigDecimal.class, this.txtincompleteRate, "value");
		dataBinder.registerBinding("meatRate", java.math.BigDecimal.class, this.txtmeatRate, "value");
		dataBinder.registerBinding("dressingPercent", java.math.BigDecimal.class, this.txtdressingPercent, "value");
		dataBinder.registerBinding("receQty", java.math.BigDecimal.class, this.txtreceQty, "value");
		dataBinder.registerBinding("AQty", java.math.BigDecimal.class, this.txtAQty, "value");
		dataBinder.registerBinding("BQty", java.math.BigDecimal.class, this.txtBQty, "value");
		dataBinder.registerBinding("BWeight", java.math.BigDecimal.class, this.txtBWeight, "value");
		dataBinder.registerBinding("returnWeight", java.math.BigDecimal.class, this.txtreturnWeight, "value");
		dataBinder.registerBinding("AWeight", java.math.BigDecimal.class, this.txtAWeight, "value");
		dataBinder.registerBinding("chicWeighr", com.kingdee.eas.weighbridge.InStorageBillInfo.class, this.prmtchicWeighr, "data");
		dataBinder.registerBinding("F7Number", String.class, this.txtF7Number, "text");
		dataBinder.registerBinding("F7id", String.class, this.txtF7id, "text");
		dataBinder.registerBinding("settleWeight", java.math.BigDecimal.class, this.txtsettleWeight, "value");
		dataBinder.registerBinding("avgWeight", java.math.BigDecimal.class, this.txtavgWeight, "value");
		dataBinder.registerBinding("costCenter", com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo.class, this.prmtcostCenter, "data");
		dataBinder.registerBinding("deathQty", java.math.BigDecimal.class, this.txtdeathQty, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.carnivorous.recyclebiz.app.CSlaughterBillEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillInfo)ov;
    }
    protected void removeByPK(IObjectPK pk) throws Exception {
    	IObjectValue editData = this.editData;
    	super.removeByPK(pk);
    	recycleNumberByOrg(editData,"Company",editData.getString("number"));
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
			protected com.kingdee.eas.basedata.org.OrgType getMainBizOrgType() {
			return com.kingdee.eas.basedata.org.OrgType.getEnum("Company");
		}

	protected KDBizPromptBox getMainBizOrg() {
		return prmtFICompany;
}


    /**
     * output loadFields method
     */
    public void loadFields()
    {
        		setAutoNumberByOrg("Company");
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
		getValidateHelper().registerBindProperty("isHasShengChanRK", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isHasSaleIssue", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hasFreightBill", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("weighed", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hasLLCK", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hasQTCK", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isPrepare", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isManRec", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isSaleOut", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FICompany", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batchContract", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("settlePolicy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("inDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batchQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("person", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmAddress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("saleType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("customer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmerPhone", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedData", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("outSalePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("car", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("driver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("driverPhone", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("preHouseQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("preHouseSuttle", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("QCEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("QCEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("QCEntrys.QCItem", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("QCEntrys.actualRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("QCEntrys.punishAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("QCEntrys.actualWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("QCEntrys.punishWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("QCEntrys.randPType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("punishAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("punishWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("diffChickenQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("weighBillNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("settleWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("preHouseGross", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("preHouseTare", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("companyGross", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("companyTare", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("companySuttle", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("calUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("catchCKTeam", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("carcassQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("carcassWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cAverageWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("diffQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("recQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("incompleteQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("incompleteWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("incompleteRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("meatRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dressingPercent", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("receQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("returnWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chicWeighr", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("F7Number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("F7id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("settleWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("avgWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("costCenter", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("deathQty", ValidateHelper.ON_SAVE);    		
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
     * output prmtfarmer_Changed() method
     */
    public void prmtfarmer_Changed() throws Exception
    {
        System.out.println("prmtfarmer_Changed() Function is executed!");
            txtfarmerPhone.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtfarmer.getData(),"mobileTel")));


    }

    /**
     * output prmtfarm_Changed() method
     */
    public void prmtfarm_Changed() throws Exception
    {
        System.out.println("prmtfarm_Changed() Function is executed!");
            txtfarmAddress.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtfarm.getData(),"address")));

    farmType.setSelectedItem(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtfarm.getData(),"faemsType"));


    }

    /**
     * output prmtdriver_Changed() method
     */
    public void prmtdriver_Changed() throws Exception
    {
        System.out.println("prmtdriver_Changed() Function is executed!");
            txtdriverPhone.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtdriver.getData(),"driverphone")));


    }

    /**
     * output kdtQCEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtQCEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("QCItem".equalsIgnoreCase(kdtQCEntrys.getColumn(colIndex).getKey())) {
kdtQCEntrys.getCell(rowIndex,"randPType").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtQCEntrys.getCell(rowIndex,"QCItem").getValue(),"punishType"));

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
        sic.add(new SelectorItemInfo("isHasShengChanRK"));
        sic.add(new SelectorItemInfo("isHasSaleIssue"));
        sic.add(new SelectorItemInfo("hasFreightBill"));
        sic.add(new SelectorItemInfo("weighed"));
        sic.add(new SelectorItemInfo("hasLLCK"));
        sic.add(new SelectorItemInfo("hasQTCK"));
        sic.add(new SelectorItemInfo("isPrepare"));
        sic.add(new SelectorItemInfo("isManRec"));
        sic.add(new SelectorItemInfo("isSaleOut"));
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
			sic.add(new SelectorItemInfo("FICompany.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("FICompany.id"));
        	sic.add(new SelectorItemInfo("FICompany.number"));
        	sic.add(new SelectorItemInfo("FICompany.name"));
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
			sic.add(new SelectorItemInfo("farm.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farm.id"));
        	sic.add(new SelectorItemInfo("farm.number"));
        	sic.add(new SelectorItemInfo("farm.name"));
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
			sic.add(new SelectorItemInfo("batch.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("batch.id"));
        	sic.add(new SelectorItemInfo("batch.number"));
        	sic.add(new SelectorItemInfo("batch.name"));
		}
        sic.add(new SelectorItemInfo("billStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("settlePolicy.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("settlePolicy.id"));
        	sic.add(new SelectorItemInfo("settlePolicy.number"));
        	sic.add(new SelectorItemInfo("settlePolicy.name"));
		}
        sic.add(new SelectorItemInfo("inDate"));
        sic.add(new SelectorItemInfo("batchQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("person.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("person.id"));
        	sic.add(new SelectorItemInfo("person.number"));
        	sic.add(new SelectorItemInfo("person.name"));
		}
        sic.add(new SelectorItemInfo("farmAddress"));
        sic.add(new SelectorItemInfo("farmType"));
        sic.add(new SelectorItemInfo("saleType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("customer.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("customer.id"));
        	sic.add(new SelectorItemInfo("customer.number"));
        	sic.add(new SelectorItemInfo("customer.name"));
		}
        sic.add(new SelectorItemInfo("farmerPhone"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("breedData.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("breedData.id"));
        	sic.add(new SelectorItemInfo("breedData.number"));
        	sic.add(new SelectorItemInfo("breedData.name"));
		}
        sic.add(new SelectorItemInfo("outSalePrice"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("car.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("car.id"));
        	sic.add(new SelectorItemInfo("car.number"));
        	sic.add(new SelectorItemInfo("car.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("driver.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("driver.id"));
        	sic.add(new SelectorItemInfo("driver.number"));
        	sic.add(new SelectorItemInfo("driver.name"));
        	sic.add(new SelectorItemInfo("driver.drivername"));
		}
        sic.add(new SelectorItemInfo("driverPhone"));
        sic.add(new SelectorItemInfo("preHouseQty"));
        sic.add(new SelectorItemInfo("preHouseSuttle"));
    	sic.add(new SelectorItemInfo("QCEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("QCEntrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("QCEntrys.QCItem.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("QCEntrys.QCItem.id"));
			sic.add(new SelectorItemInfo("QCEntrys.QCItem.name"));
        	sic.add(new SelectorItemInfo("QCEntrys.QCItem.number"));
		}
    	sic.add(new SelectorItemInfo("QCEntrys.actualRate"));
    	sic.add(new SelectorItemInfo("QCEntrys.punishAmt"));
    	sic.add(new SelectorItemInfo("QCEntrys.actualWgt"));
    	sic.add(new SelectorItemInfo("QCEntrys.punishWgt"));
    	sic.add(new SelectorItemInfo("QCEntrys.randPType"));
        sic.add(new SelectorItemInfo("punishAmt"));
        sic.add(new SelectorItemInfo("punishWgt"));
        sic.add(new SelectorItemInfo("diffChickenQty"));
        sic.add(new SelectorItemInfo("weighBillNum"));
        sic.add(new SelectorItemInfo("settleWgt"));
        sic.add(new SelectorItemInfo("preHouseGross"));
        sic.add(new SelectorItemInfo("preHouseTare"));
        sic.add(new SelectorItemInfo("companyGross"));
        sic.add(new SelectorItemInfo("companyTare"));
        sic.add(new SelectorItemInfo("companySuttle"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("calUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("calUnit.id"));
        	sic.add(new SelectorItemInfo("calUnit.number"));
        	sic.add(new SelectorItemInfo("calUnit.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("catchCKTeam.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("catchCKTeam.id"));
        	sic.add(new SelectorItemInfo("catchCKTeam.number"));
        	sic.add(new SelectorItemInfo("catchCKTeam.name"));
		}
        sic.add(new SelectorItemInfo("carcassQty"));
        sic.add(new SelectorItemInfo("carcassWgt"));
        sic.add(new SelectorItemInfo("cAverageWgt"));
        sic.add(new SelectorItemInfo("diffQty"));
        sic.add(new SelectorItemInfo("recQty"));
        sic.add(new SelectorItemInfo("incompleteQty"));
        sic.add(new SelectorItemInfo("incompleteWgt"));
        sic.add(new SelectorItemInfo("incompleteRate"));
        sic.add(new SelectorItemInfo("meatRate"));
        sic.add(new SelectorItemInfo("dressingPercent"));
        sic.add(new SelectorItemInfo("receQty"));
        sic.add(new SelectorItemInfo("AQty"));
        sic.add(new SelectorItemInfo("BQty"));
        sic.add(new SelectorItemInfo("BWeight"));
        sic.add(new SelectorItemInfo("returnWeight"));
        sic.add(new SelectorItemInfo("AWeight"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("chicWeighr.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("chicWeighr.id"));
        	sic.add(new SelectorItemInfo("chicWeighr.number"));
		}
        sic.add(new SelectorItemInfo("F7Number"));
        sic.add(new SelectorItemInfo("F7id"));
        sic.add(new SelectorItemInfo("settleWeight"));
        sic.add(new SelectorItemInfo("avgWeight"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("costCenter.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("costCenter.id"));
        	sic.add(new SelectorItemInfo("costCenter.number"));
        	sic.add(new SelectorItemInfo("costCenter.name"));
		}
        sic.add(new SelectorItemInfo("deathQty"));
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
        com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractCSlaughterBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractCSlaughterBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.recyclebiz.client", "CSlaughterBillEditUI");
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
        return com.kingdee.eas.farm.carnivorous.recyclebiz.client.CSlaughterBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillInfo();
				if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")).getBoolean("isBizUnit"))
			objectValue.put("FICompany",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")));
 
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/carnivorous/recyclebiz/CSlaughterBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.carnivorous.recyclebiz.app.CSlaughterBillQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtNumber.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"单据编号"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtfarmer.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖户"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtfarm.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖场"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtbatchContract.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"批次合同"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(saleType.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"销售类型"});
		}
		for (int i=0,n=kdtQCEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtQCEntrys.getCell(i,"QCItem").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"质检项目"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtchicWeighr.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"毛鸡过磅单"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtQCEntrys;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("billStatus",new Integer(-1));
vo.put("farmType","0");
vo.put("saleType","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}        
				protected void setTableToSumField() {
			setTableToSumField(kdtQCEntrys,new String[] {"punishAmt","actualWgt","punishWgt"});
		}


}