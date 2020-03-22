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
public abstract class AbstractPreHouseWgtBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractPreHouseWgtBillEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompanyWgtGross;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompanyWgtTare;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompanyWgtSuttle;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpreHouseSuttle;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpreHouseTare;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpreHouseGross;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisHasTuZai;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contseq;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contarriveTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contactualArriveTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoutSaleAmt;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisHasShengChanRK;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisHasSaleIssue;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrecQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsettleWgt;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisSettled;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrecSuttle;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contseedSource;
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
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcompanyWgtGross;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcompanyWgtTare;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcompanyWgtSuttle;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpreHouseSuttle;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpreHouseTare;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpreHouseGross;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtseq;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkarriveTime;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkactualArriveTime;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoutSaleAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtrecQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsettleWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtrecSuttle;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtseedSource;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.farm.carnivorous.recyclebiz.PreHouseWgtBillInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractPreHouseWgtBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractPreHouseWgtBillEditUI.class.getName());
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
        this.actionSubmit.setExtendProperty("userDefined", "true");
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
        this.contcompanyWgtGross = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompanyWgtTare = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompanyWgtSuttle = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpreHouseSuttle = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpreHouseTare = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpreHouseGross = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisHasTuZai = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contseq = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contarriveTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contactualArriveTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoutSaleAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisHasShengChanRK = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisHasSaleIssue = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contrecQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsettleWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisSettled = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contrecSuttle = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contseedSource = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
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
        this.txtcompanyWgtGross = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcompanyWgtTare = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcompanyWgtSuttle = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpreHouseSuttle = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpreHouseTare = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpreHouseGross = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtseq = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkarriveTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkactualArriveTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtoutSaleAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtrecQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsettleWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtrecSuttle = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtseedSource = new com.kingdee.bos.ctrl.swing.KDTextField();
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
        this.contcompanyWgtGross.setName("contcompanyWgtGross");
        this.contcompanyWgtTare.setName("contcompanyWgtTare");
        this.contcompanyWgtSuttle.setName("contcompanyWgtSuttle");
        this.contpreHouseSuttle.setName("contpreHouseSuttle");
        this.contpreHouseTare.setName("contpreHouseTare");
        this.contpreHouseGross.setName("contpreHouseGross");
        this.chkisHasTuZai.setName("chkisHasTuZai");
        this.contseq.setName("contseq");
        this.contarriveTime.setName("contarriveTime");
        this.contactualArriveTime.setName("contactualArriveTime");
        this.contoutSaleAmt.setName("contoutSaleAmt");
        this.chkisHasShengChanRK.setName("chkisHasShengChanRK");
        this.chkisHasSaleIssue.setName("chkisHasSaleIssue");
        this.contrecQty.setName("contrecQty");
        this.contsettleWgt.setName("contsettleWgt");
        this.chkisSettled.setName("chkisSettled");
        this.contrecSuttle.setName("contrecSuttle");
        this.contseedSource.setName("contseedSource");
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
        this.txtcompanyWgtGross.setName("txtcompanyWgtGross");
        this.txtcompanyWgtTare.setName("txtcompanyWgtTare");
        this.txtcompanyWgtSuttle.setName("txtcompanyWgtSuttle");
        this.txtpreHouseSuttle.setName("txtpreHouseSuttle");
        this.txtpreHouseTare.setName("txtpreHouseTare");
        this.txtpreHouseGross.setName("txtpreHouseGross");
        this.txtseq.setName("txtseq");
        this.pkarriveTime.setName("pkarriveTime");
        this.pkactualArriveTime.setName("pkactualArriveTime");
        this.txtoutSaleAmt.setName("txtoutSaleAmt");
        this.txtrecQty.setName("txtrecQty");
        this.txtsettleWgt.setName("txtsettleWgt");
        this.txtrecSuttle.setName("txtrecSuttle");
        this.txtseedSource.setName("txtseedSource");
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
        this.contpreHouseQty.setVisible(true);
        // contcompanyWgtGross		
        this.contcompanyWgtGross.setBoundLabelText(resHelper.getString("contcompanyWgtGross.boundLabelText"));		
        this.contcompanyWgtGross.setBoundLabelLength(100);		
        this.contcompanyWgtGross.setBoundLabelUnderline(true);		
        this.contcompanyWgtGross.setVisible(true);
        // contcompanyWgtTare		
        this.contcompanyWgtTare.setBoundLabelText(resHelper.getString("contcompanyWgtTare.boundLabelText"));		
        this.contcompanyWgtTare.setBoundLabelLength(100);		
        this.contcompanyWgtTare.setBoundLabelUnderline(true);		
        this.contcompanyWgtTare.setVisible(true);
        // contcompanyWgtSuttle		
        this.contcompanyWgtSuttle.setBoundLabelText(resHelper.getString("contcompanyWgtSuttle.boundLabelText"));		
        this.contcompanyWgtSuttle.setBoundLabelLength(100);		
        this.contcompanyWgtSuttle.setBoundLabelUnderline(true);		
        this.contcompanyWgtSuttle.setVisible(true);
        // contpreHouseSuttle		
        this.contpreHouseSuttle.setBoundLabelText(resHelper.getString("contpreHouseSuttle.boundLabelText"));		
        this.contpreHouseSuttle.setBoundLabelLength(100);		
        this.contpreHouseSuttle.setBoundLabelUnderline(true);		
        this.contpreHouseSuttle.setVisible(true);
        // contpreHouseTare		
        this.contpreHouseTare.setBoundLabelText(resHelper.getString("contpreHouseTare.boundLabelText"));		
        this.contpreHouseTare.setBoundLabelLength(100);		
        this.contpreHouseTare.setBoundLabelUnderline(true);		
        this.contpreHouseTare.setVisible(true);
        // contpreHouseGross		
        this.contpreHouseGross.setBoundLabelText(resHelper.getString("contpreHouseGross.boundLabelText"));		
        this.contpreHouseGross.setBoundLabelLength(100);		
        this.contpreHouseGross.setBoundLabelUnderline(true);		
        this.contpreHouseGross.setVisible(true);
        // chkisHasTuZai		
        this.chkisHasTuZai.setText(resHelper.getString("chkisHasTuZai.text"));		
        this.chkisHasTuZai.setVisible(true);		
        this.chkisHasTuZai.setHorizontalAlignment(2);		
        this.chkisHasTuZai.setEnabled(false);
        // contseq		
        this.contseq.setBoundLabelText(resHelper.getString("contseq.boundLabelText"));		
        this.contseq.setBoundLabelLength(100);		
        this.contseq.setBoundLabelUnderline(true);		
        this.contseq.setVisible(true);
        // contarriveTime		
        this.contarriveTime.setBoundLabelText(resHelper.getString("contarriveTime.boundLabelText"));		
        this.contarriveTime.setBoundLabelLength(100);		
        this.contarriveTime.setBoundLabelUnderline(true);		
        this.contarriveTime.setVisible(true);
        // contactualArriveTime		
        this.contactualArriveTime.setBoundLabelText(resHelper.getString("contactualArriveTime.boundLabelText"));		
        this.contactualArriveTime.setBoundLabelLength(100);		
        this.contactualArriveTime.setBoundLabelUnderline(true);		
        this.contactualArriveTime.setVisible(true);
        // contoutSaleAmt		
        this.contoutSaleAmt.setBoundLabelText(resHelper.getString("contoutSaleAmt.boundLabelText"));		
        this.contoutSaleAmt.setBoundLabelLength(100);		
        this.contoutSaleAmt.setBoundLabelUnderline(true);		
        this.contoutSaleAmt.setVisible(true);
        // chkisHasShengChanRK		
        this.chkisHasShengChanRK.setText(resHelper.getString("chkisHasShengChanRK.text"));		
        this.chkisHasShengChanRK.setVisible(true);		
        this.chkisHasShengChanRK.setHorizontalAlignment(2);		
        this.chkisHasShengChanRK.setEnabled(false);
        // chkisHasSaleIssue		
        this.chkisHasSaleIssue.setText(resHelper.getString("chkisHasSaleIssue.text"));		
        this.chkisHasSaleIssue.setVisible(true);		
        this.chkisHasSaleIssue.setHorizontalAlignment(2);		
        this.chkisHasSaleIssue.setEnabled(false);
        // contrecQty		
        this.contrecQty.setBoundLabelText(resHelper.getString("contrecQty.boundLabelText"));		
        this.contrecQty.setBoundLabelLength(100);		
        this.contrecQty.setBoundLabelUnderline(true);		
        this.contrecQty.setVisible(true);
        // contsettleWgt		
        this.contsettleWgt.setBoundLabelText(resHelper.getString("contsettleWgt.boundLabelText"));		
        this.contsettleWgt.setBoundLabelLength(100);		
        this.contsettleWgt.setBoundLabelUnderline(true);		
        this.contsettleWgt.setVisible(true);
        // chkisSettled		
        this.chkisSettled.setText(resHelper.getString("chkisSettled.text"));		
        this.chkisSettled.setVisible(true);		
        this.chkisSettled.setHorizontalAlignment(2);		
        this.chkisSettled.setEnabled(false);
        // contrecSuttle		
        this.contrecSuttle.setBoundLabelText(resHelper.getString("contrecSuttle.boundLabelText"));		
        this.contrecSuttle.setBoundLabelLength(100);		
        this.contrecSuttle.setBoundLabelUnderline(true);		
        this.contrecSuttle.setVisible(true);
        // contseedSource		
        this.contseedSource.setBoundLabelText(resHelper.getString("contseedSource.boundLabelText"));		
        this.contseedSource.setBoundLabelLength(100);		
        this.contseedSource.setBoundLabelUnderline(true);		
        this.contseedSource.setVisible(true);
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
        this.prmtfarmer.setEnabled(false);
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
        this.prmtfarm.setEnabled(false);
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
        this.prmtbatchContract.setEnabled(false);
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
        this.saleType.setEnabled(false);
        // prmtcustomer		
        this.prmtcustomer.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.CustomerInfoQuery");		
        this.prmtcustomer.setVisible(true);		
        this.prmtcustomer.setEditable(true);		
        this.prmtcustomer.setDisplayFormat("$name$");		
        this.prmtcustomer.setEditFormat("$number$");		
        this.prmtcustomer.setCommitFormat("$number$");		
        this.prmtcustomer.setRequired(true);		
        this.prmtcustomer.setEnabled(false);
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
        this.prmtcar.setEnabled(false);
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
        this.prmtdriver.setEnabled(false);
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
        this.txtdriverPhone.setEnabled(false);
        // txtpreHouseQty		
        this.txtpreHouseQty.setVisible(true);		
        this.txtpreHouseQty.setHorizontalAlignment(2);		
        this.txtpreHouseQty.setDataType(0);		
        this.txtpreHouseQty.setSupportedEmpty(true);		
        this.txtpreHouseQty.setRequired(true);
        // txtcompanyWgtGross		
        this.txtcompanyWgtGross.setVisible(true);		
        this.txtcompanyWgtGross.setHorizontalAlignment(2);		
        this.txtcompanyWgtGross.setDataType(1);		
        this.txtcompanyWgtGross.setSupportedEmpty(true);		
        this.txtcompanyWgtGross.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcompanyWgtGross.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcompanyWgtGross.setPrecision(4);		
        this.txtcompanyWgtGross.setRequired(false);		
        this.txtcompanyWgtGross.setEnabled(false);
        // txtcompanyWgtTare		
        this.txtcompanyWgtTare.setVisible(true);		
        this.txtcompanyWgtTare.setHorizontalAlignment(2);		
        this.txtcompanyWgtTare.setDataType(1);		
        this.txtcompanyWgtTare.setSupportedEmpty(true);		
        this.txtcompanyWgtTare.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcompanyWgtTare.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcompanyWgtTare.setPrecision(4);		
        this.txtcompanyWgtTare.setRequired(false);		
        this.txtcompanyWgtTare.setEnabled(false);
        // txtcompanyWgtSuttle		
        this.txtcompanyWgtSuttle.setVisible(true);		
        this.txtcompanyWgtSuttle.setHorizontalAlignment(2);		
        this.txtcompanyWgtSuttle.setDataType(1);		
        this.txtcompanyWgtSuttle.setSupportedEmpty(true);		
        this.txtcompanyWgtSuttle.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcompanyWgtSuttle.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcompanyWgtSuttle.setPrecision(4);		
        this.txtcompanyWgtSuttle.setRequired(false);		
        this.txtcompanyWgtSuttle.setEnabled(false);
        // txtpreHouseSuttle		
        this.txtpreHouseSuttle.setVisible(true);		
        this.txtpreHouseSuttle.setHorizontalAlignment(2);		
        this.txtpreHouseSuttle.setDataType(1);		
        this.txtpreHouseSuttle.setSupportedEmpty(true);		
        this.txtpreHouseSuttle.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtpreHouseSuttle.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtpreHouseSuttle.setPrecision(2);		
        this.txtpreHouseSuttle.setRequired(true);		
        this.txtpreHouseSuttle.setEnabled(false);
        // txtpreHouseTare		
        this.txtpreHouseTare.setVisible(true);		
        this.txtpreHouseTare.setHorizontalAlignment(2);		
        this.txtpreHouseTare.setDataType(1);		
        this.txtpreHouseTare.setSupportedEmpty(true);		
        this.txtpreHouseTare.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtpreHouseTare.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtpreHouseTare.setPrecision(2);		
        this.txtpreHouseTare.setRequired(false);
        // txtpreHouseGross		
        this.txtpreHouseGross.setVisible(true);		
        this.txtpreHouseGross.setHorizontalAlignment(2);		
        this.txtpreHouseGross.setDataType(1);		
        this.txtpreHouseGross.setSupportedEmpty(true);		
        this.txtpreHouseGross.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtpreHouseGross.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtpreHouseGross.setPrecision(2);		
        this.txtpreHouseGross.setRequired(false);
        // txtseq		
        this.txtseq.setVisible(true);		
        this.txtseq.setHorizontalAlignment(2);		
        this.txtseq.setDataType(0);		
        this.txtseq.setSupportedEmpty(true);		
        this.txtseq.setRequired(false);		
        this.txtseq.setEnabled(false);
        // pkarriveTime		
        this.pkarriveTime.setVisible(true);		
        this.pkarriveTime.setRequired(false);		
        this.pkarriveTime.setEnabled(false);
        // pkactualArriveTime		
        this.pkactualArriveTime.setVisible(true);		
        this.pkactualArriveTime.setRequired(false);
        // txtoutSaleAmt		
        this.txtoutSaleAmt.setVisible(true);		
        this.txtoutSaleAmt.setHorizontalAlignment(2);		
        this.txtoutSaleAmt.setDataType(1);		
        this.txtoutSaleAmt.setSupportedEmpty(true);		
        this.txtoutSaleAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtoutSaleAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtoutSaleAmt.setPrecision(2);		
        this.txtoutSaleAmt.setRequired(false);
        // txtrecQty		
        this.txtrecQty.setVisible(true);		
        this.txtrecQty.setHorizontalAlignment(2);		
        this.txtrecQty.setDataType(0);		
        this.txtrecQty.setSupportedEmpty(true);		
        this.txtrecQty.setRequired(false);		
        this.txtrecQty.setEnabled(false);
        // txtsettleWgt		
        this.txtsettleWgt.setVisible(true);		
        this.txtsettleWgt.setHorizontalAlignment(2);		
        this.txtsettleWgt.setDataType(1);		
        this.txtsettleWgt.setSupportedEmpty(true);		
        this.txtsettleWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsettleWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsettleWgt.setPrecision(4);		
        this.txtsettleWgt.setRequired(false);		
        this.txtsettleWgt.setEnabled(false);
        // txtrecSuttle		
        this.txtrecSuttle.setVisible(true);		
        this.txtrecSuttle.setHorizontalAlignment(2);		
        this.txtrecSuttle.setDataType(1);		
        this.txtrecSuttle.setSupportedEmpty(true);		
        this.txtrecSuttle.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtrecSuttle.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtrecSuttle.setPrecision(4);		
        this.txtrecSuttle.setRequired(false);		
        this.txtrecSuttle.setEnabled(false);
        // txtseedSource		
        this.txtseedSource.setVisible(true);		
        this.txtseedSource.setHorizontalAlignment(2);		
        this.txtseedSource.setMaxLength(255);		
        this.txtseedSource.setRequired(false);		
        this.txtseedSource.setEnabled(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtfarmer,prmtfarm,prmtbatchContract,prmtbatch,prmtsettlePolicy,pkinDate,txtbatchQty,prmtperson,txtfarmAddress,farmType,saleType,prmtcustomer,txtfarmerPhone,prmtbreedData,txtoutSalePrice,prmtcar,prmtdriver,txtdriverPhone,txtpreHouseQty,txtpreHouseSuttle,txtcompanyWgtGross,txtcompanyWgtTare,txtcompanyWgtSuttle,txtpreHouseGross,txtpreHouseTare,pkactualArriveTime,chkisHasTuZai,txtseq,pkarriveTime,txtoutSaleAmt,chkisHasShengChanRK,chkisHasSaleIssue,txtrecQty,txtsettleWgt,chkisSettled,txtrecSuttle,txtseedSource}));
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
        this.setBounds(new Rectangle(-10, 2, 1233, 606));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(-10, 2, 1233, 606));
        contCreator.setBounds(new Rectangle(436, 528, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(436, 528, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(789, 527, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(789, 527, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(435, 560, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(435, 560, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(788, 559, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(788, 559, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(27, 19, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(27, 19, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(336, 19, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(336, 19, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(27, 351, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(27, 351, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(43, 527, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(43, 527, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contFICompany.setBounds(new Rectangle(637, 19, 270, 19));
        this.add(contFICompany, new KDLayout.Constraints(637, 19, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(42, 559, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(42, 559, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmer.setBounds(new Rectangle(27, 52, 270, 19));
        this.add(contfarmer, new KDLayout.Constraints(27, 52, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarm.setBounds(new Rectangle(637, 52, 270, 19));
        this.add(contfarm, new KDLayout.Constraints(637, 52, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbatchContract.setBounds(new Rectangle(27, 85, 270, 19));
        this.add(contbatchContract, new KDLayout.Constraints(27, 85, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbatch.setBounds(new Rectangle(336, 85, 270, 19));
        this.add(contbatch, new KDLayout.Constraints(336, 85, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(937, 19, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(937, 19, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contsettlePolicy.setBounds(new Rectangle(27, 118, 270, 19));
        this.add(contsettlePolicy, new KDLayout.Constraints(27, 118, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        continDate.setBounds(new Rectangle(637, 85, 270, 19));
        this.add(continDate, new KDLayout.Constraints(637, 85, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbatchQty.setBounds(new Rectangle(937, 85, 270, 19));
        this.add(contbatchQty, new KDLayout.Constraints(937, 85, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator9.setBounds(new Rectangle(3, 510, 1202, 8));
        this.add(kDSeparator9, new KDLayout.Constraints(3, 510, 1202, 8, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contperson.setBounds(new Rectangle(336, 118, 270, 19));
        this.add(contperson, new KDLayout.Constraints(336, 118, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmAddress.setBounds(new Rectangle(937, 52, 270, 19));
        this.add(contfarmAddress, new KDLayout.Constraints(937, 52, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfarmType.setBounds(new Rectangle(937, 118, 270, 19));
        this.add(contfarmType, new KDLayout.Constraints(937, 118, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contsaleType.setBounds(new Rectangle(27, 151, 270, 19));
        this.add(contsaleType, new KDLayout.Constraints(27, 151, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcustomer.setBounds(new Rectangle(336, 151, 270, 19));
        this.add(contcustomer, new KDLayout.Constraints(336, 151, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmerPhone.setBounds(new Rectangle(336, 52, 270, 19));
        this.add(contfarmerPhone, new KDLayout.Constraints(336, 52, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbreedData.setBounds(new Rectangle(637, 118, 270, 19));
        this.add(contbreedData, new KDLayout.Constraints(637, 118, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoutSalePrice.setBounds(new Rectangle(637, 151, 270, 19));
        this.add(contoutSalePrice, new KDLayout.Constraints(637, 151, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcar.setBounds(new Rectangle(27, 184, 270, 19));
        this.add(contcar, new KDLayout.Constraints(27, 184, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdriver.setBounds(new Rectangle(336, 184, 270, 19));
        this.add(contdriver, new KDLayout.Constraints(336, 184, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdriverPhone.setBounds(new Rectangle(637, 184, 270, 19));
        this.add(contdriverPhone, new KDLayout.Constraints(637, 184, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpreHouseQty.setBounds(new Rectangle(336, 217, 270, 19));
        this.add(contpreHouseQty, new KDLayout.Constraints(336, 217, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompanyWgtGross.setBounds(new Rectangle(336, 250, 270, 19));
        this.add(contcompanyWgtGross, new KDLayout.Constraints(336, 250, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompanyWgtTare.setBounds(new Rectangle(637, 250, 270, 19));
        this.add(contcompanyWgtTare, new KDLayout.Constraints(637, 250, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompanyWgtSuttle.setBounds(new Rectangle(937, 250, 270, 19));
        this.add(contcompanyWgtSuttle, new KDLayout.Constraints(937, 250, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contpreHouseSuttle.setBounds(new Rectangle(27, 250, 270, 19));
        this.add(contpreHouseSuttle, new KDLayout.Constraints(27, 250, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpreHouseTare.setBounds(new Rectangle(937, 217, 270, 19));
        this.add(contpreHouseTare, new KDLayout.Constraints(937, 217, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contpreHouseGross.setBounds(new Rectangle(637, 217, 270, 19));
        this.add(contpreHouseGross, new KDLayout.Constraints(637, 217, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisHasTuZai.setBounds(new Rectangle(937, 351, 129, 19));
        this.add(chkisHasTuZai, new KDLayout.Constraints(937, 351, 129, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contseq.setBounds(new Rectangle(336, 283, 270, 19));
        this.add(contseq, new KDLayout.Constraints(336, 283, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contarriveTime.setBounds(new Rectangle(937, 184, 270, 19));
        this.add(contarriveTime, new KDLayout.Constraints(937, 184, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contactualArriveTime.setBounds(new Rectangle(27, 283, 270, 19));
        this.add(contactualArriveTime, new KDLayout.Constraints(27, 283, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoutSaleAmt.setBounds(new Rectangle(937, 151, 270, 19));
        this.add(contoutSaleAmt, new KDLayout.Constraints(937, 151, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkisHasShengChanRK.setBounds(new Rectangle(637, 351, 157, 19));
        this.add(chkisHasShengChanRK, new KDLayout.Constraints(637, 351, 157, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisHasSaleIssue.setBounds(new Rectangle(336, 351, 157, 19));
        this.add(chkisHasSaleIssue, new KDLayout.Constraints(336, 351, 157, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contrecQty.setBounds(new Rectangle(27, 217, 270, 19));
        this.add(contrecQty, new KDLayout.Constraints(27, 217, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsettleWgt.setBounds(new Rectangle(637, 283, 270, 19));
        this.add(contsettleWgt, new KDLayout.Constraints(637, 283, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisSettled.setBounds(new Rectangle(1091, 351, 116, 19));
        this.add(chkisSettled, new KDLayout.Constraints(1091, 351, 116, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contrecSuttle.setBounds(new Rectangle(937, 283, 270, 19));
        this.add(contrecSuttle, new KDLayout.Constraints(937, 283, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contseedSource.setBounds(new Rectangle(27, 316, 1182, 19));
        this.add(contseedSource, new KDLayout.Constraints(27, 316, 1182, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contcompanyWgtGross
        contcompanyWgtGross.setBoundEditor(txtcompanyWgtGross);
        //contcompanyWgtTare
        contcompanyWgtTare.setBoundEditor(txtcompanyWgtTare);
        //contcompanyWgtSuttle
        contcompanyWgtSuttle.setBoundEditor(txtcompanyWgtSuttle);
        //contpreHouseSuttle
        contpreHouseSuttle.setBoundEditor(txtpreHouseSuttle);
        //contpreHouseTare
        contpreHouseTare.setBoundEditor(txtpreHouseTare);
        //contpreHouseGross
        contpreHouseGross.setBoundEditor(txtpreHouseGross);
        //contseq
        contseq.setBoundEditor(txtseq);
        //contarriveTime
        contarriveTime.setBoundEditor(pkarriveTime);
        //contactualArriveTime
        contactualArriveTime.setBoundEditor(pkactualArriveTime);
        //contoutSaleAmt
        contoutSaleAmt.setBoundEditor(txtoutSaleAmt);
        //contrecQty
        contrecQty.setBoundEditor(txtrecQty);
        //contsettleWgt
        contsettleWgt.setBoundEditor(txtsettleWgt);
        //contrecSuttle
        contrecSuttle.setBoundEditor(txtrecSuttle);
        //contseedSource
        contseedSource.setBoundEditor(txtseedSource);

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
		dataBinder.registerBinding("isHasTuZai", boolean.class, this.chkisHasTuZai, "selected");
		dataBinder.registerBinding("isHasShengChanRK", boolean.class, this.chkisHasShengChanRK, "selected");
		dataBinder.registerBinding("isHasSaleIssue", boolean.class, this.chkisHasSaleIssue, "selected");
		dataBinder.registerBinding("isSettled", boolean.class, this.chkisSettled, "selected");
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
		dataBinder.registerBinding("companyWgtGross", java.math.BigDecimal.class, this.txtcompanyWgtGross, "value");
		dataBinder.registerBinding("companyWgtTare", java.math.BigDecimal.class, this.txtcompanyWgtTare, "value");
		dataBinder.registerBinding("companyWgtSuttle", java.math.BigDecimal.class, this.txtcompanyWgtSuttle, "value");
		dataBinder.registerBinding("preHouseSuttle", java.math.BigDecimal.class, this.txtpreHouseSuttle, "value");
		dataBinder.registerBinding("preHouseTare", java.math.BigDecimal.class, this.txtpreHouseTare, "value");
		dataBinder.registerBinding("preHouseGross", java.math.BigDecimal.class, this.txtpreHouseGross, "value");
		dataBinder.registerBinding("seq", int.class, this.txtseq, "value");
		dataBinder.registerBinding("arriveTime", java.util.Date.class, this.pkarriveTime, "value");
		dataBinder.registerBinding("actualArriveTime", java.util.Date.class, this.pkactualArriveTime, "value");
		dataBinder.registerBinding("outSaleAmt", java.math.BigDecimal.class, this.txtoutSaleAmt, "value");
		dataBinder.registerBinding("recQty", int.class, this.txtrecQty, "value");
		dataBinder.registerBinding("settleWgt", java.math.BigDecimal.class, this.txtsettleWgt, "value");
		dataBinder.registerBinding("recSuttle", java.math.BigDecimal.class, this.txtrecSuttle, "value");
		dataBinder.registerBinding("seedSource", String.class, this.txtseedSource, "text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.carnivorous.recyclebiz.app.PreHouseWgtBillEditUIHandler";
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
        this.prmtfarmer.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.carnivorous.recyclebiz.PreHouseWgtBillInfo)ov;
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
		getValidateHelper().registerBindProperty("isHasTuZai", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isHasShengChanRK", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isHasSaleIssue", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isSettled", ValidateHelper.ON_SAVE);    
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
		getValidateHelper().registerBindProperty("companyWgtGross", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("companyWgtTare", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("companyWgtSuttle", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("preHouseSuttle", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("preHouseTare", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("preHouseGross", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("arriveTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("actualArriveTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("outSaleAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("recQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("settleWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("recSuttle", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("seedSource", ValidateHelper.ON_SAVE);    		
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
     * output getSelectors method
     */
    public SelectorItemCollection getSelectors()
    {
        SelectorItemCollection sic = new SelectorItemCollection();
		String selectorAll = System.getProperty("selector.all");
		if(StringUtils.isEmpty(selectorAll)){
			selectorAll = "true";
		}
        sic.add(new SelectorItemInfo("isHasTuZai"));
        sic.add(new SelectorItemInfo("isHasShengChanRK"));
        sic.add(new SelectorItemInfo("isHasSaleIssue"));
        sic.add(new SelectorItemInfo("isSettled"));
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
        sic.add(new SelectorItemInfo("companyWgtGross"));
        sic.add(new SelectorItemInfo("companyWgtTare"));
        sic.add(new SelectorItemInfo("companyWgtSuttle"));
        sic.add(new SelectorItemInfo("preHouseSuttle"));
        sic.add(new SelectorItemInfo("preHouseTare"));
        sic.add(new SelectorItemInfo("preHouseGross"));
        sic.add(new SelectorItemInfo("seq"));
        sic.add(new SelectorItemInfo("arriveTime"));
        sic.add(new SelectorItemInfo("actualArriveTime"));
        sic.add(new SelectorItemInfo("outSaleAmt"));
        sic.add(new SelectorItemInfo("recQty"));
        sic.add(new SelectorItemInfo("settleWgt"));
        sic.add(new SelectorItemInfo("recSuttle"));
        sic.add(new SelectorItemInfo("seedSource"));
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
        com.kingdee.eas.farm.carnivorous.recyclebiz.PreHouseWgtBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.recyclebiz.PreHouseWgtBillFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractPreHouseWgtBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractPreHouseWgtBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.recyclebiz.client", "PreHouseWgtBillEditUI");
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
        return com.kingdee.eas.farm.carnivorous.recyclebiz.client.PreHouseWgtBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.recyclebiz.PreHouseWgtBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.recyclebiz.PreHouseWgtBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.recyclebiz.PreHouseWgtBillInfo();
				if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")).getBoolean("isBizUnit"))
			objectValue.put("FICompany",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")));
 
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/carnivorous/recyclebiz/PreHouseWgtBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.carnivorous.recyclebiz.app.PreHouseWgtBillQuery");
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
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcustomer.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"客户"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtpreHouseQty.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"棚前只数"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtpreHouseSuttle.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"棚前净重"});
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
		vo.put("billStatus",new Integer(-1));
vo.put("farmType","0");
vo.put("saleType","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}