/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.assistbiz.client;

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
public abstract class AbstractCKFreightBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCKFreightBillEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contFICompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcar;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdriver;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedData;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatchContract;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrecDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdistance;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrecSuttle;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcarcassWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continCompleteQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continCompleteWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmarketPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdateFmRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdateCKFreight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdressingPercent;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contactualCKFreight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcyxRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcyxKbAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contotherKbAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallFreight;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcustomer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcalUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaverageWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contactualFmRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmonthAveFmRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpldiffQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthighWayFee;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpldiffAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrecQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgrowthFreight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmaxFmRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfmRateStd;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcarcassQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmonthCalFmRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfmRateCoe;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtFICompany;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcar;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtdriver;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbreedData;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarm;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbatchContract;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkrecDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdistance;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtrecSuttle;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcarcassWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtinCompleteQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtinCompleteWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmarketPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdateFmRate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdateCKFreight;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdressingPercent;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtactualCKFreight;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcyxRate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcyxKbAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtotherKbAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallFreight;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcustomer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcalUnit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtaverageWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtactualFmRate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmonthAveFmRate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpldiffQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txthighWayFee;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpldiffAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtrecQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgrowthFreight;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmaxFmRate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfmRateStd;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcarcassQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmonthCalFmRate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfmRateCoe;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnCalFreight;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.farm.carnivorous.assistbiz.CKFreightBillInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionCalFreight actionCalFreight = null;
    /**
     * output class constructor
     */
    public AbstractCKFreightBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCKFreightBillEditUI.class.getName());
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
        //actionCalFreight
        this.actionCalFreight = new ActionCalFreight(this);
        getActionManager().registerAction("actionCalFreight", actionCalFreight);
        this.actionCalFreight.setBindWorkFlow(true);
        this.actionCalFreight.setExtendProperty("canForewarn", "true");
        this.actionCalFreight.setExtendProperty("userDefined", "true");
        this.actionCalFreight.setExtendProperty("isObjectUpdateLock", "false");
         this.actionCalFreight.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionCalFreight.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionCalFreight.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contFICompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcar = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdriver = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbreedData = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbatchContract = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrecDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdistance = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrecSuttle = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcarcassWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continCompleteQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continCompleteWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmarketPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdateFmRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdateCKFreight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdressingPercent = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contactualCKFreight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcyxRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcyxKbAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contotherKbAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallFreight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcustomer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcalUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contaverageWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contactualFmRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmonthAveFmRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpldiffQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthighWayFee = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpldiffAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrecQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgrowthFreight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmaxFmRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfmRateStd = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcarcassQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmonthCalFmRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfmRateCoe = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtFICompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtcar = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtdriver = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbreedData = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtfarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbatchContract = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkrecDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtdistance = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtrecSuttle = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcarcassWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtinCompleteQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtinCompleteWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmarketPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdateFmRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdateCKFreight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdressingPercent = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtactualCKFreight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcyxRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcyxKbAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtotherKbAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallFreight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtcustomer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtfarmer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcalUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtaverageWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtactualFmRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmonthAveFmRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpldiffQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txthighWayFee = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpldiffAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtrecQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtgrowthFreight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmaxFmRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfmRateStd = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcarcassQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmonthCalFmRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfmRateCoe = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.btnCalFreight = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contAuditor.setName("contAuditor");
        this.contFICompany.setName("contFICompany");
        this.contbillStatus.setName("contbillStatus");
        this.contcar.setName("contcar");
        this.contdriver.setName("contdriver");
        this.contbreedData.setName("contbreedData");
        this.contfarm.setName("contfarm");
        this.contbatchContract.setName("contbatchContract");
        this.contrecDate.setName("contrecDate");
        this.contdistance.setName("contdistance");
        this.contrecSuttle.setName("contrecSuttle");
        this.contcarcassWgt.setName("contcarcassWgt");
        this.continCompleteQty.setName("continCompleteQty");
        this.continCompleteWgt.setName("continCompleteWgt");
        this.contmarketPrice.setName("contmarketPrice");
        this.contdateFmRate.setName("contdateFmRate");
        this.contdateCKFreight.setName("contdateCKFreight");
        this.contdressingPercent.setName("contdressingPercent");
        this.contactualCKFreight.setName("contactualCKFreight");
        this.contcyxRate.setName("contcyxRate");
        this.contcyxKbAmt.setName("contcyxKbAmt");
        this.contotherKbAmt.setName("contotherKbAmt");
        this.contallFreight.setName("contallFreight");
        this.kDSeparator8.setName("kDSeparator8");
        this.contauditTime.setName("contauditTime");
        this.contcustomer.setName("contcustomer");
        this.contfarmer.setName("contfarmer");
        this.contcalUnit.setName("contcalUnit");
        this.contaverageWgt.setName("contaverageWgt");
        this.contactualFmRate.setName("contactualFmRate");
        this.contmonthAveFmRate.setName("contmonthAveFmRate");
        this.contpldiffQty.setName("contpldiffQty");
        this.conthighWayFee.setName("conthighWayFee");
        this.contpldiffAmount.setName("contpldiffAmount");
        this.contrecQty.setName("contrecQty");
        this.contgrowthFreight.setName("contgrowthFreight");
        this.contmaxFmRate.setName("contmaxFmRate");
        this.contfmRateStd.setName("contfmRateStd");
        this.contcarcassQty.setName("contcarcassQty");
        this.contmonthCalFmRate.setName("contmonthCalFmRate");
        this.contfmRateCoe.setName("contfmRateCoe");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtFICompany.setName("prmtFICompany");
        this.billStatus.setName("billStatus");
        this.prmtcar.setName("prmtcar");
        this.prmtdriver.setName("prmtdriver");
        this.prmtbreedData.setName("prmtbreedData");
        this.prmtfarm.setName("prmtfarm");
        this.prmtbatchContract.setName("prmtbatchContract");
        this.pkrecDate.setName("pkrecDate");
        this.txtdistance.setName("txtdistance");
        this.txtrecSuttle.setName("txtrecSuttle");
        this.txtcarcassWgt.setName("txtcarcassWgt");
        this.txtinCompleteQty.setName("txtinCompleteQty");
        this.txtinCompleteWgt.setName("txtinCompleteWgt");
        this.txtmarketPrice.setName("txtmarketPrice");
        this.txtdateFmRate.setName("txtdateFmRate");
        this.txtdateCKFreight.setName("txtdateCKFreight");
        this.txtdressingPercent.setName("txtdressingPercent");
        this.txtactualCKFreight.setName("txtactualCKFreight");
        this.txtcyxRate.setName("txtcyxRate");
        this.txtcyxKbAmt.setName("txtcyxKbAmt");
        this.txtotherKbAmt.setName("txtotherKbAmt");
        this.txtallFreight.setName("txtallFreight");
        this.pkauditTime.setName("pkauditTime");
        this.prmtcustomer.setName("prmtcustomer");
        this.prmtfarmer.setName("prmtfarmer");
        this.prmtcalUnit.setName("prmtcalUnit");
        this.txtaverageWgt.setName("txtaverageWgt");
        this.txtactualFmRate.setName("txtactualFmRate");
        this.txtmonthAveFmRate.setName("txtmonthAveFmRate");
        this.txtpldiffQty.setName("txtpldiffQty");
        this.txthighWayFee.setName("txthighWayFee");
        this.txtpldiffAmount.setName("txtpldiffAmount");
        this.txtrecQty.setName("txtrecQty");
        this.txtgrowthFreight.setName("txtgrowthFreight");
        this.txtmaxFmRate.setName("txtmaxFmRate");
        this.txtfmRateStd.setName("txtfmRateStd");
        this.txtcarcassQty.setName("txtcarcassQty");
        this.txtmonthCalFmRate.setName("txtmonthCalFmRate");
        this.txtfmRateCoe.setName("txtfmRateCoe");
        this.btnCalFreight.setName("btnCalFreight");
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
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);
        // contFICompany		
        this.contFICompany.setBoundLabelText(resHelper.getString("contFICompany.boundLabelText"));		
        this.contFICompany.setBoundLabelLength(100);		
        this.contFICompany.setBoundLabelUnderline(true);		
        this.contFICompany.setVisible(true);
        // contbillStatus		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);
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
        // contbreedData		
        this.contbreedData.setBoundLabelText(resHelper.getString("contbreedData.boundLabelText"));		
        this.contbreedData.setBoundLabelLength(100);		
        this.contbreedData.setBoundLabelUnderline(true);		
        this.contbreedData.setVisible(true);
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
        // contrecDate		
        this.contrecDate.setBoundLabelText(resHelper.getString("contrecDate.boundLabelText"));		
        this.contrecDate.setBoundLabelLength(100);		
        this.contrecDate.setBoundLabelUnderline(true);		
        this.contrecDate.setVisible(true);
        // contdistance		
        this.contdistance.setBoundLabelText(resHelper.getString("contdistance.boundLabelText"));		
        this.contdistance.setBoundLabelLength(130);		
        this.contdistance.setBoundLabelUnderline(true);		
        this.contdistance.setVisible(true);
        // contrecSuttle		
        this.contrecSuttle.setBoundLabelText(resHelper.getString("contrecSuttle.boundLabelText"));		
        this.contrecSuttle.setBoundLabelLength(130);		
        this.contrecSuttle.setBoundLabelUnderline(true);		
        this.contrecSuttle.setVisible(true);
        // contcarcassWgt		
        this.contcarcassWgt.setBoundLabelText(resHelper.getString("contcarcassWgt.boundLabelText"));		
        this.contcarcassWgt.setBoundLabelLength(130);		
        this.contcarcassWgt.setBoundLabelUnderline(true);		
        this.contcarcassWgt.setVisible(true);
        // continCompleteQty		
        this.continCompleteQty.setBoundLabelText(resHelper.getString("continCompleteQty.boundLabelText"));		
        this.continCompleteQty.setBoundLabelLength(130);		
        this.continCompleteQty.setBoundLabelUnderline(true);		
        this.continCompleteQty.setVisible(true);
        // continCompleteWgt		
        this.continCompleteWgt.setBoundLabelText(resHelper.getString("continCompleteWgt.boundLabelText"));		
        this.continCompleteWgt.setBoundLabelLength(130);		
        this.continCompleteWgt.setBoundLabelUnderline(true);		
        this.continCompleteWgt.setVisible(true);
        // contmarketPrice		
        this.contmarketPrice.setBoundLabelText(resHelper.getString("contmarketPrice.boundLabelText"));		
        this.contmarketPrice.setBoundLabelLength(130);		
        this.contmarketPrice.setBoundLabelUnderline(true);		
        this.contmarketPrice.setVisible(true);
        // contdateFmRate		
        this.contdateFmRate.setBoundLabelText(resHelper.getString("contdateFmRate.boundLabelText"));		
        this.contdateFmRate.setBoundLabelLength(130);		
        this.contdateFmRate.setBoundLabelUnderline(true);		
        this.contdateFmRate.setVisible(true);
        // contdateCKFreight		
        this.contdateCKFreight.setBoundLabelText(resHelper.getString("contdateCKFreight.boundLabelText"));		
        this.contdateCKFreight.setBoundLabelLength(130);		
        this.contdateCKFreight.setBoundLabelUnderline(true);		
        this.contdateCKFreight.setVisible(true);
        // contdressingPercent		
        this.contdressingPercent.setBoundLabelText(resHelper.getString("contdressingPercent.boundLabelText"));		
        this.contdressingPercent.setBoundLabelLength(130);		
        this.contdressingPercent.setBoundLabelUnderline(true);		
        this.contdressingPercent.setVisible(true);
        // contactualCKFreight		
        this.contactualCKFreight.setBoundLabelText(resHelper.getString("contactualCKFreight.boundLabelText"));		
        this.contactualCKFreight.setBoundLabelLength(130);		
        this.contactualCKFreight.setBoundLabelUnderline(true);		
        this.contactualCKFreight.setVisible(true);
        // contcyxRate		
        this.contcyxRate.setBoundLabelText(resHelper.getString("contcyxRate.boundLabelText"));		
        this.contcyxRate.setBoundLabelLength(130);		
        this.contcyxRate.setBoundLabelUnderline(true);		
        this.contcyxRate.setVisible(true);
        // contcyxKbAmt		
        this.contcyxKbAmt.setBoundLabelText(resHelper.getString("contcyxKbAmt.boundLabelText"));		
        this.contcyxKbAmt.setBoundLabelLength(130);		
        this.contcyxKbAmt.setBoundLabelUnderline(true);		
        this.contcyxKbAmt.setVisible(true);
        // contotherKbAmt		
        this.contotherKbAmt.setBoundLabelText(resHelper.getString("contotherKbAmt.boundLabelText"));		
        this.contotherKbAmt.setBoundLabelLength(130);		
        this.contotherKbAmt.setBoundLabelUnderline(true);		
        this.contotherKbAmt.setVisible(true);
        // contallFreight		
        this.contallFreight.setBoundLabelText(resHelper.getString("contallFreight.boundLabelText"));		
        this.contallFreight.setBoundLabelLength(130);		
        this.contallFreight.setBoundLabelUnderline(true);		
        this.contallFreight.setVisible(true);
        // kDSeparator8
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // contcustomer		
        this.contcustomer.setBoundLabelText(resHelper.getString("contcustomer.boundLabelText"));		
        this.contcustomer.setBoundLabelLength(100);		
        this.contcustomer.setBoundLabelUnderline(true);		
        this.contcustomer.setVisible(true);
        // contfarmer		
        this.contfarmer.setBoundLabelText(resHelper.getString("contfarmer.boundLabelText"));		
        this.contfarmer.setBoundLabelLength(100);		
        this.contfarmer.setBoundLabelUnderline(true);		
        this.contfarmer.setVisible(true);
        // contcalUnit		
        this.contcalUnit.setBoundLabelText(resHelper.getString("contcalUnit.boundLabelText"));		
        this.contcalUnit.setBoundLabelLength(100);		
        this.contcalUnit.setBoundLabelUnderline(true);		
        this.contcalUnit.setVisible(true);
        // contaverageWgt		
        this.contaverageWgt.setBoundLabelText(resHelper.getString("contaverageWgt.boundLabelText"));		
        this.contaverageWgt.setBoundLabelLength(130);		
        this.contaverageWgt.setBoundLabelUnderline(true);		
        this.contaverageWgt.setVisible(true);
        // contactualFmRate		
        this.contactualFmRate.setBoundLabelText(resHelper.getString("contactualFmRate.boundLabelText"));		
        this.contactualFmRate.setBoundLabelLength(130);		
        this.contactualFmRate.setBoundLabelUnderline(true);		
        this.contactualFmRate.setVisible(true);
        // contmonthAveFmRate		
        this.contmonthAveFmRate.setBoundLabelText(resHelper.getString("contmonthAveFmRate.boundLabelText"));		
        this.contmonthAveFmRate.setBoundLabelLength(130);		
        this.contmonthAveFmRate.setBoundLabelUnderline(true);		
        this.contmonthAveFmRate.setVisible(true);
        // contpldiffQty		
        this.contpldiffQty.setBoundLabelText(resHelper.getString("contpldiffQty.boundLabelText"));		
        this.contpldiffQty.setBoundLabelLength(130);		
        this.contpldiffQty.setBoundLabelUnderline(true);		
        this.contpldiffQty.setVisible(true);
        // conthighWayFee		
        this.conthighWayFee.setBoundLabelText(resHelper.getString("conthighWayFee.boundLabelText"));		
        this.conthighWayFee.setBoundLabelLength(130);		
        this.conthighWayFee.setBoundLabelUnderline(true);		
        this.conthighWayFee.setVisible(true);
        // contpldiffAmount		
        this.contpldiffAmount.setBoundLabelText(resHelper.getString("contpldiffAmount.boundLabelText"));		
        this.contpldiffAmount.setBoundLabelLength(130);		
        this.contpldiffAmount.setBoundLabelUnderline(true);		
        this.contpldiffAmount.setVisible(true);
        // contrecQty		
        this.contrecQty.setBoundLabelText(resHelper.getString("contrecQty.boundLabelText"));		
        this.contrecQty.setBoundLabelLength(130);		
        this.contrecQty.setBoundLabelUnderline(true);		
        this.contrecQty.setVisible(true);
        // contgrowthFreight		
        this.contgrowthFreight.setBoundLabelText(resHelper.getString("contgrowthFreight.boundLabelText"));		
        this.contgrowthFreight.setBoundLabelLength(130);		
        this.contgrowthFreight.setBoundLabelUnderline(true);		
        this.contgrowthFreight.setVisible(true);
        // contmaxFmRate		
        this.contmaxFmRate.setBoundLabelText(resHelper.getString("contmaxFmRate.boundLabelText"));		
        this.contmaxFmRate.setBoundLabelLength(130);		
        this.contmaxFmRate.setBoundLabelUnderline(true);		
        this.contmaxFmRate.setVisible(true);
        // contfmRateStd		
        this.contfmRateStd.setBoundLabelText(resHelper.getString("contfmRateStd.boundLabelText"));		
        this.contfmRateStd.setBoundLabelLength(130);		
        this.contfmRateStd.setBoundLabelUnderline(true);		
        this.contfmRateStd.setVisible(true);
        // contcarcassQty		
        this.contcarcassQty.setBoundLabelText(resHelper.getString("contcarcassQty.boundLabelText"));		
        this.contcarcassQty.setBoundLabelLength(130);		
        this.contcarcassQty.setBoundLabelUnderline(true);		
        this.contcarcassQty.setVisible(true);
        // contmonthCalFmRate		
        this.contmonthCalFmRate.setBoundLabelText(resHelper.getString("contmonthCalFmRate.boundLabelText"));		
        this.contmonthCalFmRate.setBoundLabelLength(130);		
        this.contmonthCalFmRate.setBoundLabelUnderline(true);		
        this.contmonthCalFmRate.setVisible(true);
        // contfmRateCoe		
        this.contfmRateCoe.setBoundLabelText(resHelper.getString("contfmRateCoe.boundLabelText"));		
        this.contfmRateCoe.setBoundLabelLength(130);		
        this.contfmRateCoe.setBoundLabelUnderline(true);		
        this.contfmRateCoe.setVisible(true);
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
        this.txtNumber.setEnabled(false);
        // pkBizDate		
        this.pkBizDate.setVisible(true);		
        this.pkBizDate.setRequired(true);
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
					
        // billStatus		
        this.billStatus.setVisible(true);		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // prmtcar		
        this.prmtcar.setQueryInfo("com.kingdee.eas.publicdata.app.CarQuery");		
        this.prmtcar.setVisible(true);		
        this.prmtcar.setEditable(true);		
        this.prmtcar.setDisplayFormat("$number$");		
        this.prmtcar.setEditFormat("$number$");		
        this.prmtcar.setCommitFormat("$number$");		
        this.prmtcar.setRequired(true);		
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
        this.prmtdriver.setRequired(true);		
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
					
        // prmtbreedData		
        this.prmtbreedData.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.BreedDataQuery");		
        this.prmtbreedData.setVisible(true);		
        this.prmtbreedData.setEditable(true);		
        this.prmtbreedData.setDisplayFormat("$name$");		
        this.prmtbreedData.setEditFormat("$number$");		
        this.prmtbreedData.setCommitFormat("$number$");		
        this.prmtbreedData.setRequired(true);		
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
					
        // prmtbatchContract		
        this.prmtbatchContract.setQueryInfo("com.kingdee.eas.farm.carnivorous.feedbiz.app.BatchContractBillQuery");		
        this.prmtbatchContract.setVisible(true);		
        this.prmtbatchContract.setEditable(true);		
        this.prmtbatchContract.setDisplayFormat("$number$");		
        this.prmtbatchContract.setEditFormat("$number$");		
        this.prmtbatchContract.setCommitFormat("$number$");		
        this.prmtbatchContract.setRequired(true);		
        this.prmtbatchContract.setEnabled(false);
        // pkrecDate		
        this.pkrecDate.setVisible(true);		
        this.pkrecDate.setRequired(false);		
        this.pkrecDate.setEnabled(false);
        // txtdistance		
        this.txtdistance.setVisible(true);		
        this.txtdistance.setHorizontalAlignment(2);		
        this.txtdistance.setDataType(1);		
        this.txtdistance.setSupportedEmpty(true);		
        this.txtdistance.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdistance.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdistance.setPrecision(4);		
        this.txtdistance.setRequired(false);		
        this.txtdistance.setEnabled(false);
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
        // txtcarcassWgt		
        this.txtcarcassWgt.setVisible(true);		
        this.txtcarcassWgt.setHorizontalAlignment(2);		
        this.txtcarcassWgt.setDataType(1);		
        this.txtcarcassWgt.setSupportedEmpty(true);		
        this.txtcarcassWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcarcassWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcarcassWgt.setPrecision(4);		
        this.txtcarcassWgt.setRequired(false);		
        this.txtcarcassWgt.setEnabled(false);
        // txtinCompleteQty		
        this.txtinCompleteQty.setVisible(true);		
        this.txtinCompleteQty.setHorizontalAlignment(2);		
        this.txtinCompleteQty.setDataType(0);		
        this.txtinCompleteQty.setSupportedEmpty(true);		
        this.txtinCompleteQty.setRequired(false);		
        this.txtinCompleteQty.setEnabled(false);
        // txtinCompleteWgt		
        this.txtinCompleteWgt.setVisible(true);		
        this.txtinCompleteWgt.setHorizontalAlignment(2);		
        this.txtinCompleteWgt.setDataType(1);		
        this.txtinCompleteWgt.setSupportedEmpty(true);		
        this.txtinCompleteWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtinCompleteWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtinCompleteWgt.setPrecision(4);		
        this.txtinCompleteWgt.setRequired(false);		
        this.txtinCompleteWgt.setEnabled(false);
        // txtmarketPrice		
        this.txtmarketPrice.setVisible(true);		
        this.txtmarketPrice.setHorizontalAlignment(2);		
        this.txtmarketPrice.setDataType(1);		
        this.txtmarketPrice.setSupportedEmpty(true);		
        this.txtmarketPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmarketPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmarketPrice.setPrecision(4);		
        this.txtmarketPrice.setRequired(false);		
        this.txtmarketPrice.setEnabled(false);
        // txtdateFmRate		
        this.txtdateFmRate.setVisible(true);		
        this.txtdateFmRate.setHorizontalAlignment(2);		
        this.txtdateFmRate.setDataType(1);		
        this.txtdateFmRate.setSupportedEmpty(true);		
        this.txtdateFmRate.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdateFmRate.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdateFmRate.setPrecision(4);		
        this.txtdateFmRate.setRequired(false);		
        this.txtdateFmRate.setEnabled(false);
        // txtdateCKFreight		
        this.txtdateCKFreight.setVisible(true);		
        this.txtdateCKFreight.setHorizontalAlignment(2);		
        this.txtdateCKFreight.setDataType(1);		
        this.txtdateCKFreight.setSupportedEmpty(true);		
        this.txtdateCKFreight.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdateCKFreight.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdateCKFreight.setPrecision(2);		
        this.txtdateCKFreight.setRequired(false);		
        this.txtdateCKFreight.setEnabled(false);
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
        // txtactualCKFreight		
        this.txtactualCKFreight.setVisible(true);		
        this.txtactualCKFreight.setHorizontalAlignment(2);		
        this.txtactualCKFreight.setDataType(1);		
        this.txtactualCKFreight.setSupportedEmpty(true);		
        this.txtactualCKFreight.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtactualCKFreight.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtactualCKFreight.setPrecision(2);		
        this.txtactualCKFreight.setRequired(false);		
        this.txtactualCKFreight.setEnabled(false);
        // txtcyxRate		
        this.txtcyxRate.setVisible(true);		
        this.txtcyxRate.setHorizontalAlignment(2);		
        this.txtcyxRate.setDataType(1);		
        this.txtcyxRate.setSupportedEmpty(true);		
        this.txtcyxRate.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcyxRate.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcyxRate.setPrecision(4);		
        this.txtcyxRate.setRequired(false);		
        this.txtcyxRate.setEnabled(false);
        // txtcyxKbAmt		
        this.txtcyxKbAmt.setVisible(true);		
        this.txtcyxKbAmt.setHorizontalAlignment(2);		
        this.txtcyxKbAmt.setDataType(1);		
        this.txtcyxKbAmt.setSupportedEmpty(true);		
        this.txtcyxKbAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcyxKbAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcyxKbAmt.setPrecision(2);		
        this.txtcyxKbAmt.setRequired(false);		
        this.txtcyxKbAmt.setEnabled(false);
        // txtotherKbAmt		
        this.txtotherKbAmt.setVisible(true);		
        this.txtotherKbAmt.setHorizontalAlignment(2);		
        this.txtotherKbAmt.setDataType(1);		
        this.txtotherKbAmt.setSupportedEmpty(true);		
        this.txtotherKbAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtotherKbAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtotherKbAmt.setPrecision(2);		
        this.txtotherKbAmt.setRequired(false);
        // txtallFreight		
        this.txtallFreight.setVisible(true);		
        this.txtallFreight.setHorizontalAlignment(2);		
        this.txtallFreight.setDataType(1);		
        this.txtallFreight.setSupportedEmpty(true);		
        this.txtallFreight.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallFreight.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallFreight.setPrecision(2);		
        this.txtallFreight.setRequired(false);		
        this.txtallFreight.setEnabled(false);
        // pkauditTime		
        this.pkauditTime.setVisible(true);		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // prmtcustomer		
        this.prmtcustomer.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.CustomerInfoQuery");		
        this.prmtcustomer.setVisible(true);		
        this.prmtcustomer.setEditable(true);		
        this.prmtcustomer.setDisplayFormat("$name$");		
        this.prmtcustomer.setEditFormat("$number$");		
        this.prmtcustomer.setCommitFormat("$number$");		
        this.prmtcustomer.setRequired(true);		
        this.prmtcustomer.setEnabled(false);
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
					
        // prmtcalUnit		
        this.prmtcalUnit.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FreightCalPointQuery");		
        this.prmtcalUnit.setVisible(true);		
        this.prmtcalUnit.setEditable(true);		
        this.prmtcalUnit.setDisplayFormat("$name$");		
        this.prmtcalUnit.setEditFormat("$number$");		
        this.prmtcalUnit.setCommitFormat("$number$");		
        this.prmtcalUnit.setRequired(true);
        		EntityViewInfo eviprmtcalUnit = new EntityViewInfo ();
		eviprmtcalUnit.setFilter(com.kingdee.eas.framework.FrameWorkUtils.getF7FilterInfoByAuthorizedOrg(com.kingdee.eas.basedata.org.OrgType.getEnum("Company"),"FICompany.id"));
		prmtcalUnit.setEntityViewInfo(eviprmtcalUnit);
					
        // txtaverageWgt		
        this.txtaverageWgt.setVisible(true);		
        this.txtaverageWgt.setHorizontalAlignment(2);		
        this.txtaverageWgt.setDataType(1);		
        this.txtaverageWgt.setSupportedEmpty(true);		
        this.txtaverageWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtaverageWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtaverageWgt.setPrecision(4);		
        this.txtaverageWgt.setRequired(true);		
        this.txtaverageWgt.setEnabled(false);
        // txtactualFmRate		
        this.txtactualFmRate.setVisible(true);		
        this.txtactualFmRate.setHorizontalAlignment(2);		
        this.txtactualFmRate.setDataType(1);		
        this.txtactualFmRate.setSupportedEmpty(true);		
        this.txtactualFmRate.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtactualFmRate.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtactualFmRate.setPrecision(4);		
        this.txtactualFmRate.setRequired(false);		
        this.txtactualFmRate.setEnabled(false);
        // txtmonthAveFmRate		
        this.txtmonthAveFmRate.setVisible(true);		
        this.txtmonthAveFmRate.setHorizontalAlignment(2);		
        this.txtmonthAveFmRate.setDataType(1);		
        this.txtmonthAveFmRate.setSupportedEmpty(true);		
        this.txtmonthAveFmRate.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmonthAveFmRate.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmonthAveFmRate.setPrecision(4);		
        this.txtmonthAveFmRate.setRequired(false);		
        this.txtmonthAveFmRate.setEnabled(false);
        // txtpldiffQty		
        this.txtpldiffQty.setVisible(true);		
        this.txtpldiffQty.setHorizontalAlignment(2);		
        this.txtpldiffQty.setDataType(0);		
        this.txtpldiffQty.setSupportedEmpty(true);		
        this.txtpldiffQty.setRequired(false);
        // txthighWayFee		
        this.txthighWayFee.setVisible(true);		
        this.txthighWayFee.setHorizontalAlignment(2);		
        this.txthighWayFee.setDataType(1);		
        this.txthighWayFee.setSupportedEmpty(true);		
        this.txthighWayFee.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txthighWayFee.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txthighWayFee.setPrecision(2);		
        this.txthighWayFee.setRequired(false);
        // txtpldiffAmount		
        this.txtpldiffAmount.setVisible(true);		
        this.txtpldiffAmount.setHorizontalAlignment(2);		
        this.txtpldiffAmount.setDataType(1);		
        this.txtpldiffAmount.setSupportedEmpty(true);		
        this.txtpldiffAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpldiffAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpldiffAmount.setPrecision(2);		
        this.txtpldiffAmount.setRequired(false);		
        this.txtpldiffAmount.setEnabled(false);
        // txtrecQty		
        this.txtrecQty.setVisible(true);		
        this.txtrecQty.setHorizontalAlignment(2);		
        this.txtrecQty.setDataType(0);		
        this.txtrecQty.setSupportedEmpty(true);		
        this.txtrecQty.setRequired(false);		
        this.txtrecQty.setEnabled(false);
        // txtgrowthFreight		
        this.txtgrowthFreight.setVisible(true);		
        this.txtgrowthFreight.setHorizontalAlignment(2);		
        this.txtgrowthFreight.setDataType(1);		
        this.txtgrowthFreight.setSupportedEmpty(true);		
        this.txtgrowthFreight.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtgrowthFreight.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtgrowthFreight.setPrecision(2);		
        this.txtgrowthFreight.setRequired(false);		
        this.txtgrowthFreight.setEnabled(false);
        // txtmaxFmRate		
        this.txtmaxFmRate.setVisible(true);		
        this.txtmaxFmRate.setHorizontalAlignment(2);		
        this.txtmaxFmRate.setDataType(1);		
        this.txtmaxFmRate.setSupportedEmpty(true);		
        this.txtmaxFmRate.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmaxFmRate.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmaxFmRate.setPrecision(4);		
        this.txtmaxFmRate.setRequired(false);		
        this.txtmaxFmRate.setEnabled(false);
        // txtfmRateStd		
        this.txtfmRateStd.setVisible(true);		
        this.txtfmRateStd.setHorizontalAlignment(2);		
        this.txtfmRateStd.setDataType(1);		
        this.txtfmRateStd.setSupportedEmpty(true);		
        this.txtfmRateStd.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfmRateStd.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfmRateStd.setPrecision(4);		
        this.txtfmRateStd.setRequired(false);		
        this.txtfmRateStd.setEnabled(false);
        // txtcarcassQty		
        this.txtcarcassQty.setVisible(true);		
        this.txtcarcassQty.setHorizontalAlignment(2);		
        this.txtcarcassQty.setDataType(0);		
        this.txtcarcassQty.setSupportedEmpty(true);		
        this.txtcarcassQty.setRequired(false);		
        this.txtcarcassQty.setEnabled(false);
        // txtmonthCalFmRate		
        this.txtmonthCalFmRate.setVisible(true);		
        this.txtmonthCalFmRate.setHorizontalAlignment(2);		
        this.txtmonthCalFmRate.setDataType(1);		
        this.txtmonthCalFmRate.setSupportedEmpty(true);		
        this.txtmonthCalFmRate.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmonthCalFmRate.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmonthCalFmRate.setPrecision(4);		
        this.txtmonthCalFmRate.setRequired(false);		
        this.txtmonthCalFmRate.setEnabled(false);
        // txtfmRateCoe		
        this.txtfmRateCoe.setVisible(true);		
        this.txtfmRateCoe.setHorizontalAlignment(2);		
        this.txtfmRateCoe.setDataType(1);		
        this.txtfmRateCoe.setSupportedEmpty(true);		
        this.txtfmRateCoe.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfmRateCoe.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfmRateCoe.setPrecision(4);		
        this.txtfmRateCoe.setRequired(false);		
        this.txtfmRateCoe.setEnabled(false);
        // btnCalFreight
        this.btnCalFreight.setAction((IItemAction)ActionProxyFactory.getProxy(actionCalFreight, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnCalFreight.setText(resHelper.getString("btnCalFreight.text"));		
        this.btnCalFreight.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_deprecalculate"));
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {billStatus,prmtcar,prmtdriver,prmtbreedData,prmtfarm,prmtbatchContract,pkrecDate,txtdistance,txtrecSuttle,txtcarcassWgt,txtinCompleteQty,txtinCompleteWgt,txtmarketPrice,txtdateFmRate,txtdateCKFreight,txtdressingPercent,txtactualCKFreight,txtcyxRate,txtcyxKbAmt,txtotherKbAmt,txtallFreight,pkauditTime,prmtcustomer,prmtfarmer,prmtcalUnit,txtaverageWgt,txtactualFmRate,txtmonthAveFmRate,txtpldiffQty,txthighWayFee,txtpldiffAmount,txtrecQty,txtgrowthFreight,txtfmRateStd,txtmaxFmRate,txtcarcassQty,txtmonthCalFmRate,txtfmRateCoe}));
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
        this.setBounds(new Rectangle(0, 0, 1270, 658));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1270, 658));
        contCreator.setBounds(new Rectangle(572, 577, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(572, 577, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(891, 576, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(891, 576, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(572, 608, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(572, 608, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(891, 607, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(891, 607, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(37, 25, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(37, 25, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(344, 25, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(344, 25, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(93, 577, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(93, 577, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contFICompany.setBounds(new Rectangle(656, 25, 270, 19));
        this.add(contFICompany, new KDLayout.Constraints(656, 25, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(976, 25, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(976, 25, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcar.setBounds(new Rectangle(656, 62, 270, 19));
        this.add(contcar, new KDLayout.Constraints(656, 62, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdriver.setBounds(new Rectangle(976, 62, 270, 19));
        this.add(contdriver, new KDLayout.Constraints(976, 62, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbreedData.setBounds(new Rectangle(344, 62, 270, 19));
        this.add(contbreedData, new KDLayout.Constraints(344, 62, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarm.setBounds(new Rectangle(344, 99, 270, 19));
        this.add(contfarm, new KDLayout.Constraints(344, 99, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbatchContract.setBounds(new Rectangle(656, 99, 270, 19));
        this.add(contbatchContract, new KDLayout.Constraints(656, 99, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contrecDate.setBounds(new Rectangle(976, 99, 270, 19));
        this.add(contrecDate, new KDLayout.Constraints(976, 99, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contdistance.setBounds(new Rectangle(344, 136, 270, 19));
        this.add(contdistance, new KDLayout.Constraints(344, 136, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contrecSuttle.setBounds(new Rectangle(976, 136, 270, 19));
        this.add(contrecSuttle, new KDLayout.Constraints(976, 136, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcarcassWgt.setBounds(new Rectangle(344, 173, 270, 19));
        this.add(contcarcassWgt, new KDLayout.Constraints(344, 173, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        continCompleteQty.setBounds(new Rectangle(976, 173, 270, 19));
        this.add(continCompleteQty, new KDLayout.Constraints(976, 173, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        continCompleteWgt.setBounds(new Rectangle(37, 210, 270, 19));
        this.add(continCompleteWgt, new KDLayout.Constraints(37, 210, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmarketPrice.setBounds(new Rectangle(344, 210, 270, 19));
        this.add(contmarketPrice, new KDLayout.Constraints(344, 210, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdateFmRate.setBounds(new Rectangle(344, 247, 270, 19));
        this.add(contdateFmRate, new KDLayout.Constraints(344, 247, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdateCKFreight.setBounds(new Rectangle(976, 247, 270, 19));
        this.add(contdateCKFreight, new KDLayout.Constraints(976, 247, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contdressingPercent.setBounds(new Rectangle(344, 284, 270, 19));
        this.add(contdressingPercent, new KDLayout.Constraints(344, 284, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contactualCKFreight.setBounds(new Rectangle(37, 321, 270, 19));
        this.add(contactualCKFreight, new KDLayout.Constraints(37, 321, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcyxRate.setBounds(new Rectangle(976, 321, 270, 19));
        this.add(contcyxRate, new KDLayout.Constraints(976, 321, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcyxKbAmt.setBounds(new Rectangle(37, 358, 270, 19));
        this.add(contcyxKbAmt, new KDLayout.Constraints(37, 358, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contotherKbAmt.setBounds(new Rectangle(656, 358, 270, 19));
        this.add(contotherKbAmt, new KDLayout.Constraints(656, 358, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contallFreight.setBounds(new Rectangle(976, 358, 270, 19));
        this.add(contallFreight, new KDLayout.Constraints(976, 358, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator8.setBounds(new Rectangle(-30, 548, 1295, 8));
        this.add(kDSeparator8, new KDLayout.Constraints(-30, 548, 1295, 8, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contauditTime.setBounds(new Rectangle(93, 613, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(93, 613, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcustomer.setBounds(new Rectangle(37, 62, 270, 19));
        this.add(contcustomer, new KDLayout.Constraints(37, 62, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmer.setBounds(new Rectangle(37, 99, 270, 19));
        this.add(contfarmer, new KDLayout.Constraints(37, 99, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcalUnit.setBounds(new Rectangle(37, 136, 270, 19));
        this.add(contcalUnit, new KDLayout.Constraints(37, 136, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contaverageWgt.setBounds(new Rectangle(656, 173, 270, 19));
        this.add(contaverageWgt, new KDLayout.Constraints(656, 173, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contactualFmRate.setBounds(new Rectangle(37, 247, 270, 19));
        this.add(contactualFmRate, new KDLayout.Constraints(37, 247, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmonthAveFmRate.setBounds(new Rectangle(37, 284, 270, 19));
        this.add(contmonthAveFmRate, new KDLayout.Constraints(37, 284, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpldiffQty.setBounds(new Rectangle(344, 321, 270, 19));
        this.add(contpldiffQty, new KDLayout.Constraints(344, 321, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conthighWayFee.setBounds(new Rectangle(344, 358, 270, 19));
        this.add(conthighWayFee, new KDLayout.Constraints(344, 358, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpldiffAmount.setBounds(new Rectangle(656, 321, 270, 19));
        this.add(contpldiffAmount, new KDLayout.Constraints(656, 321, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contrecQty.setBounds(new Rectangle(656, 136, 270, 19));
        this.add(contrecQty, new KDLayout.Constraints(656, 136, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contgrowthFreight.setBounds(new Rectangle(656, 247, 270, 19));
        this.add(contgrowthFreight, new KDLayout.Constraints(656, 247, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmaxFmRate.setBounds(new Rectangle(976, 210, 270, 19));
        this.add(contmaxFmRate, new KDLayout.Constraints(976, 210, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfmRateStd.setBounds(new Rectangle(656, 210, 270, 19));
        this.add(contfmRateStd, new KDLayout.Constraints(656, 210, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcarcassQty.setBounds(new Rectangle(37, 173, 270, 19));
        this.add(contcarcassQty, new KDLayout.Constraints(37, 173, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmonthCalFmRate.setBounds(new Rectangle(976, 286, 270, 19));
        this.add(contmonthCalFmRate, new KDLayout.Constraints(976, 286, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfmRateCoe.setBounds(new Rectangle(656, 284, 270, 19));
        this.add(contfmRateCoe, new KDLayout.Constraints(656, 284, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contFICompany
        contFICompany.setBoundEditor(prmtFICompany);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //contcar
        contcar.setBoundEditor(prmtcar);
        //contdriver
        contdriver.setBoundEditor(prmtdriver);
        //contbreedData
        contbreedData.setBoundEditor(prmtbreedData);
        //contfarm
        contfarm.setBoundEditor(prmtfarm);
        //contbatchContract
        contbatchContract.setBoundEditor(prmtbatchContract);
        //contrecDate
        contrecDate.setBoundEditor(pkrecDate);
        //contdistance
        contdistance.setBoundEditor(txtdistance);
        //contrecSuttle
        contrecSuttle.setBoundEditor(txtrecSuttle);
        //contcarcassWgt
        contcarcassWgt.setBoundEditor(txtcarcassWgt);
        //continCompleteQty
        continCompleteQty.setBoundEditor(txtinCompleteQty);
        //continCompleteWgt
        continCompleteWgt.setBoundEditor(txtinCompleteWgt);
        //contmarketPrice
        contmarketPrice.setBoundEditor(txtmarketPrice);
        //contdateFmRate
        contdateFmRate.setBoundEditor(txtdateFmRate);
        //contdateCKFreight
        contdateCKFreight.setBoundEditor(txtdateCKFreight);
        //contdressingPercent
        contdressingPercent.setBoundEditor(txtdressingPercent);
        //contactualCKFreight
        contactualCKFreight.setBoundEditor(txtactualCKFreight);
        //contcyxRate
        contcyxRate.setBoundEditor(txtcyxRate);
        //contcyxKbAmt
        contcyxKbAmt.setBoundEditor(txtcyxKbAmt);
        //contotherKbAmt
        contotherKbAmt.setBoundEditor(txtotherKbAmt);
        //contallFreight
        contallFreight.setBoundEditor(txtallFreight);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contcustomer
        contcustomer.setBoundEditor(prmtcustomer);
        //contfarmer
        contfarmer.setBoundEditor(prmtfarmer);
        //contcalUnit
        contcalUnit.setBoundEditor(prmtcalUnit);
        //contaverageWgt
        contaverageWgt.setBoundEditor(txtaverageWgt);
        //contactualFmRate
        contactualFmRate.setBoundEditor(txtactualFmRate);
        //contmonthAveFmRate
        contmonthAveFmRate.setBoundEditor(txtmonthAveFmRate);
        //contpldiffQty
        contpldiffQty.setBoundEditor(txtpldiffQty);
        //conthighWayFee
        conthighWayFee.setBoundEditor(txthighWayFee);
        //contpldiffAmount
        contpldiffAmount.setBoundEditor(txtpldiffAmount);
        //contrecQty
        contrecQty.setBoundEditor(txtrecQty);
        //contgrowthFreight
        contgrowthFreight.setBoundEditor(txtgrowthFreight);
        //contmaxFmRate
        contmaxFmRate.setBoundEditor(txtmaxFmRate);
        //contfmRateStd
        contfmRateStd.setBoundEditor(txtfmRateStd);
        //contcarcassQty
        contcarcassQty.setBoundEditor(txtcarcassQty);
        //contmonthCalFmRate
        contmonthCalFmRate.setBoundEditor(txtmonthCalFmRate);
        //contfmRateCoe
        contfmRateCoe.setBoundEditor(txtfmRateCoe);

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
        this.toolBar.add(btnCalFreight);
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
		dataBinder.registerBinding("FICompany", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtFICompany, "data");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("car", com.kingdee.eas.publicdata.CarInfo.class, this.prmtcar, "data");
		dataBinder.registerBinding("driver", com.kingdee.eas.farm.feemanager.basedata.DriverInfo.class, this.prmtdriver, "data");
		dataBinder.registerBinding("breedData", com.kingdee.eas.farm.stocking.basedata.BreedDataInfo.class, this.prmtbreedData, "data");
		dataBinder.registerBinding("farm", com.kingdee.eas.farm.carnivorous.basedata.FarmInfo.class, this.prmtfarm, "data");
		dataBinder.registerBinding("batchContract", com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo.class, this.prmtbatchContract, "data");
		dataBinder.registerBinding("recDate", java.util.Date.class, this.pkrecDate, "value");
		dataBinder.registerBinding("distance", java.math.BigDecimal.class, this.txtdistance, "value");
		dataBinder.registerBinding("recSuttle", java.math.BigDecimal.class, this.txtrecSuttle, "value");
		dataBinder.registerBinding("carcassWgt", java.math.BigDecimal.class, this.txtcarcassWgt, "value");
		dataBinder.registerBinding("inCompleteQty", int.class, this.txtinCompleteQty, "value");
		dataBinder.registerBinding("inCompleteWgt", java.math.BigDecimal.class, this.txtinCompleteWgt, "value");
		dataBinder.registerBinding("marketPrice", java.math.BigDecimal.class, this.txtmarketPrice, "value");
		dataBinder.registerBinding("dateFmRate", java.math.BigDecimal.class, this.txtdateFmRate, "value");
		dataBinder.registerBinding("dateCKFreight", java.math.BigDecimal.class, this.txtdateCKFreight, "value");
		dataBinder.registerBinding("dressingPercent", java.math.BigDecimal.class, this.txtdressingPercent, "value");
		dataBinder.registerBinding("actualCKFreight", java.math.BigDecimal.class, this.txtactualCKFreight, "value");
		dataBinder.registerBinding("cyxRate", java.math.BigDecimal.class, this.txtcyxRate, "value");
		dataBinder.registerBinding("cyxKbAmt", java.math.BigDecimal.class, this.txtcyxKbAmt, "value");
		dataBinder.registerBinding("otherKbAmt", java.math.BigDecimal.class, this.txtotherKbAmt, "value");
		dataBinder.registerBinding("allFreight", java.math.BigDecimal.class, this.txtallFreight, "value");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("customer", com.kingdee.eas.basedata.master.cssp.CustomerInfo.class, this.prmtcustomer, "data");
		dataBinder.registerBinding("farmer", com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo.class, this.prmtfarmer, "data");
		dataBinder.registerBinding("calUnit", com.kingdee.eas.farm.carnivorous.basedata.FreightCalPointInfo.class, this.prmtcalUnit, "data");
		dataBinder.registerBinding("averageWgt", java.math.BigDecimal.class, this.txtaverageWgt, "value");
		dataBinder.registerBinding("actualFmRate", java.math.BigDecimal.class, this.txtactualFmRate, "value");
		dataBinder.registerBinding("monthAveFmRate", java.math.BigDecimal.class, this.txtmonthAveFmRate, "value");
		dataBinder.registerBinding("pldiffQty", int.class, this.txtpldiffQty, "value");
		dataBinder.registerBinding("highWayFee", java.math.BigDecimal.class, this.txthighWayFee, "value");
		dataBinder.registerBinding("pldiffAmount", java.math.BigDecimal.class, this.txtpldiffAmount, "value");
		dataBinder.registerBinding("recQty", int.class, this.txtrecQty, "value");
		dataBinder.registerBinding("growthFreight", java.math.BigDecimal.class, this.txtgrowthFreight, "value");
		dataBinder.registerBinding("maxFmRate", java.math.BigDecimal.class, this.txtmaxFmRate, "value");
		dataBinder.registerBinding("fmRateStd", java.math.BigDecimal.class, this.txtfmRateStd, "value");
		dataBinder.registerBinding("carcassQty", int.class, this.txtcarcassQty, "value");
		dataBinder.registerBinding("monthCalFmRate", java.math.BigDecimal.class, this.txtmonthCalFmRate, "value");
		dataBinder.registerBinding("fmRateCoe", java.math.BigDecimal.class, this.txtfmRateCoe, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.carnivorous.assistbiz.app.CKFreightBillEditUIHandler";
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
        this.billStatus.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.carnivorous.assistbiz.CKFreightBillInfo)ov;
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
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FICompany", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("car", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("driver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedData", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batchContract", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("recDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("distance", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("recSuttle", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("carcassWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("inCompleteQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("inCompleteWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("marketPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dateFmRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dateCKFreight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dressingPercent", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("actualCKFreight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cyxRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cyxKbAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("otherKbAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allFreight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("customer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("calUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("averageWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("actualFmRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("monthAveFmRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("pldiffQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("highWayFee", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("pldiffAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("recQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("growthFreight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("maxFmRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fmRateStd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("carcassQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("monthCalFmRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fmRateCoe", ValidateHelper.ON_SAVE);    		
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FICompany.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("FICompany.id"));
        	sic.add(new SelectorItemInfo("FICompany.number"));
        	sic.add(new SelectorItemInfo("FICompany.name"));
		}
        sic.add(new SelectorItemInfo("billStatus"));
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("breedData.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("breedData.id"));
        	sic.add(new SelectorItemInfo("breedData.number"));
        	sic.add(new SelectorItemInfo("breedData.name"));
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
        sic.add(new SelectorItemInfo("recDate"));
        sic.add(new SelectorItemInfo("distance"));
        sic.add(new SelectorItemInfo("recSuttle"));
        sic.add(new SelectorItemInfo("carcassWgt"));
        sic.add(new SelectorItemInfo("inCompleteQty"));
        sic.add(new SelectorItemInfo("inCompleteWgt"));
        sic.add(new SelectorItemInfo("marketPrice"));
        sic.add(new SelectorItemInfo("dateFmRate"));
        sic.add(new SelectorItemInfo("dateCKFreight"));
        sic.add(new SelectorItemInfo("dressingPercent"));
        sic.add(new SelectorItemInfo("actualCKFreight"));
        sic.add(new SelectorItemInfo("cyxRate"));
        sic.add(new SelectorItemInfo("cyxKbAmt"));
        sic.add(new SelectorItemInfo("otherKbAmt"));
        sic.add(new SelectorItemInfo("allFreight"));
        sic.add(new SelectorItemInfo("auditTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("customer.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("customer.id"));
        	sic.add(new SelectorItemInfo("customer.number"));
        	sic.add(new SelectorItemInfo("customer.name"));
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("calUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("calUnit.id"));
        	sic.add(new SelectorItemInfo("calUnit.number"));
        	sic.add(new SelectorItemInfo("calUnit.name"));
		}
        sic.add(new SelectorItemInfo("averageWgt"));
        sic.add(new SelectorItemInfo("actualFmRate"));
        sic.add(new SelectorItemInfo("monthAveFmRate"));
        sic.add(new SelectorItemInfo("pldiffQty"));
        sic.add(new SelectorItemInfo("highWayFee"));
        sic.add(new SelectorItemInfo("pldiffAmount"));
        sic.add(new SelectorItemInfo("recQty"));
        sic.add(new SelectorItemInfo("growthFreight"));
        sic.add(new SelectorItemInfo("maxFmRate"));
        sic.add(new SelectorItemInfo("fmRateStd"));
        sic.add(new SelectorItemInfo("carcassQty"));
        sic.add(new SelectorItemInfo("monthCalFmRate"));
        sic.add(new SelectorItemInfo("fmRateCoe"));
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
        com.kingdee.eas.farm.carnivorous.assistbiz.CKFreightBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.assistbiz.CKFreightBillFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionCalFreight_actionPerformed method
     */
    public void actionCalFreight_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.assistbiz.CKFreightBillFactory.getRemoteInstance().calFreight(editData);
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
	public RequestContext prepareActionCalFreight(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionCalFreight() {
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
            innerActionPerformed("eas", AbstractCKFreightBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractCKFreightBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionCalFreight class
     */     
    protected class ActionCalFreight extends ItemAction {     
    
        public ActionCalFreight()
        {
            this(null);
        }

        public ActionCalFreight(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionCalFreight.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCalFreight.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCalFreight.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCKFreightBillEditUI.this, "ActionCalFreight", "actionCalFreight_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.assistbiz.client", "CKFreightBillEditUI");
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
        return com.kingdee.eas.farm.carnivorous.assistbiz.client.CKFreightBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.assistbiz.CKFreightBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.assistbiz.CKFreightBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.assistbiz.CKFreightBillInfo();
				if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")).getBoolean("isBizUnit"))
			objectValue.put("FICompany",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")));
 
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/carnivorous/assistbiz/CKFreightBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.carnivorous.assistbiz.app.CKFreightBillQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcar.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"车辆"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtdriver.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"司机"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtbreedData.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"品种"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtfarm.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖场"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtbatchContract.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"批次合同"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcustomer.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"客户"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtfarmer.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖户"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcalUnit.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"运费计算点"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtaverageWgt.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"毛鸡均重"});
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
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}