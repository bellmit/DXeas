/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basebiz.client;

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
public abstract class AbstractCustomerViewReqBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCustomerViewReqBillEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contFICompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatchContract;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatch;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatchQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contamount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contviewType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contremark;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrecDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrecQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfeedWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrecRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfmRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdrugAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsingleDrugAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoValue;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrecSuttle;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdyFee;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsingleDyFee;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcAverageWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfeedDays;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsingleFeedWgt;
    protected com.kingdee.bos.ctrl.swing.KDButton BtnUpdateSettle;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedData;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contseedSource;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsettlePolicy;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contapplyGetBreed;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditGetBreed;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtFICompany;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarm;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbatchContract;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbatch;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkinDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbatchQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperson;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtamount;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtviewType;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane scrollPaneremark;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtremark;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkrecDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtrecQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfeedWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtrecRate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfmRate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdrugAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsingleDrugAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoValue;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtauditAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtrecSuttle;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdyFee;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsingleDyFee;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcAverageWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfeedDays;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsingleFeedWgt;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbreedData;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtseedSource;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsettlePolicy;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbreedPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtapplyGetBreed;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtauditGetBreed;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUpdateSettle;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnRevoke;
    protected com.kingdee.eas.farm.carnivorous.basebiz.CustomerViewReqBillInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionRevoke actionRevoke = null;
    /**
     * output class constructor
     */
    public AbstractCustomerViewReqBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCustomerViewReqBillEditUI.class.getName());
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
        //actionRevoke
        this.actionRevoke = new ActionRevoke(this);
        getActionManager().registerAction("actionRevoke", actionRevoke);
        this.actionRevoke.setBindWorkFlow(true);
        this.actionRevoke.setExtendProperty("canForewarn", "true");
        this.actionRevoke.setExtendProperty("userDefined", "true");
        this.actionRevoke.setExtendProperty("isObjectUpdateLock", "false");
         this.actionRevoke.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionRevoke.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionRevoke.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contFICompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbatchContract = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbatch = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbatchQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contamount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contviewType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contremark = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrecDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrecQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfeedWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrecRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfmRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdrugAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsingleDrugAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoValue = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabel1 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.contauditAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrecSuttle = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdyFee = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsingleDyFee = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcAverageWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfeedDays = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsingleFeedWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.BtnUpdateSettle = new com.kingdee.bos.ctrl.swing.KDButton();
        this.contbreedData = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contseedSource = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsettlePolicy = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbreedPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contapplyGetBreed = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditGetBreed = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtFICompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtfarmer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtfarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbatchContract = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbatch = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkinDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtbatchQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtperson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtamount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtviewType = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.scrollPaneremark = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txtremark = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.pkrecDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtrecQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfeedWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtrecRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfmRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdrugAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsingleDrugAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtoValue = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtauditAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtrecSuttle = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdyFee = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsingleDyFee = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcAverageWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfeedDays = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsingleFeedWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtbreedData = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtseedSource = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtsettlePolicy = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtbreedPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtapplyGetBreed = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtauditGetBreed = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUpdateSettle = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnRevoke = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contAuditor.setName("contAuditor");
        this.contFICompany.setName("contFICompany");
        this.contbillStatus.setName("contbillStatus");
        this.contfarmer.setName("contfarmer");
        this.contfarm.setName("contfarm");
        this.contbatchContract.setName("contbatchContract");
        this.contbatch.setName("contbatch");
        this.continDate.setName("continDate");
        this.contbatchQty.setName("contbatchQty");
        this.contperson.setName("contperson");
        this.contamount.setName("contamount");
        this.contauditTime.setName("contauditTime");
        this.contviewType.setName("contviewType");
        this.contremark.setName("contremark");
        this.contrecDate.setName("contrecDate");
        this.contrecQty.setName("contrecQty");
        this.contfeedWgt.setName("contfeedWgt");
        this.contrecRate.setName("contrecRate");
        this.contfmRate.setName("contfmRate");
        this.contdrugAmt.setName("contdrugAmt");
        this.contsingleDrugAmt.setName("contsingleDrugAmt");
        this.contoValue.setName("contoValue");
        this.kDLabel1.setName("kDLabel1");
        this.contauditAmt.setName("contauditAmt");
        this.contrecSuttle.setName("contrecSuttle");
        this.contdyFee.setName("contdyFee");
        this.contsingleDyFee.setName("contsingleDyFee");
        this.contcAverageWgt.setName("contcAverageWgt");
        this.contfeedDays.setName("contfeedDays");
        this.contsingleFeedWgt.setName("contsingleFeedWgt");
        this.BtnUpdateSettle.setName("BtnUpdateSettle");
        this.contbreedData.setName("contbreedData");
        this.contseedSource.setName("contseedSource");
        this.contsettlePolicy.setName("contsettlePolicy");
        this.contbreedPrice.setName("contbreedPrice");
        this.contapplyGetBreed.setName("contapplyGetBreed");
        this.contauditGetBreed.setName("contauditGetBreed");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtFICompany.setName("prmtFICompany");
        this.billStatus.setName("billStatus");
        this.prmtfarmer.setName("prmtfarmer");
        this.prmtfarm.setName("prmtfarm");
        this.prmtbatchContract.setName("prmtbatchContract");
        this.prmtbatch.setName("prmtbatch");
        this.pkinDate.setName("pkinDate");
        this.txtbatchQty.setName("txtbatchQty");
        this.prmtperson.setName("prmtperson");
        this.txtamount.setName("txtamount");
        this.pkauditTime.setName("pkauditTime");
        this.prmtviewType.setName("prmtviewType");
        this.scrollPaneremark.setName("scrollPaneremark");
        this.txtremark.setName("txtremark");
        this.pkrecDate.setName("pkrecDate");
        this.txtrecQty.setName("txtrecQty");
        this.txtfeedWgt.setName("txtfeedWgt");
        this.txtrecRate.setName("txtrecRate");
        this.txtfmRate.setName("txtfmRate");
        this.txtdrugAmt.setName("txtdrugAmt");
        this.txtsingleDrugAmt.setName("txtsingleDrugAmt");
        this.txtoValue.setName("txtoValue");
        this.txtauditAmt.setName("txtauditAmt");
        this.txtrecSuttle.setName("txtrecSuttle");
        this.txtdyFee.setName("txtdyFee");
        this.txtsingleDyFee.setName("txtsingleDyFee");
        this.txtcAverageWgt.setName("txtcAverageWgt");
        this.txtfeedDays.setName("txtfeedDays");
        this.txtsingleFeedWgt.setName("txtsingleFeedWgt");
        this.prmtbreedData.setName("prmtbreedData");
        this.txtseedSource.setName("txtseedSource");
        this.prmtsettlePolicy.setName("prmtsettlePolicy");
        this.txtbreedPrice.setName("txtbreedPrice");
        this.txtapplyGetBreed.setName("txtapplyGetBreed");
        this.txtauditGetBreed.setName("txtauditGetBreed");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
        this.btnUpdateSettle.setName("btnUpdateSettle");
        this.btnRevoke.setName("btnRevoke");
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
        // contperson		
        this.contperson.setBoundLabelText(resHelper.getString("contperson.boundLabelText"));		
        this.contperson.setBoundLabelLength(120);		
        this.contperson.setBoundLabelUnderline(true);		
        this.contperson.setVisible(true);
        // contamount		
        this.contamount.setBoundLabelText(resHelper.getString("contamount.boundLabelText"));		
        this.contamount.setBoundLabelLength(120);		
        this.contamount.setBoundLabelUnderline(true);		
        this.contamount.setVisible(true);
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // contviewType		
        this.contviewType.setBoundLabelText(resHelper.getString("contviewType.boundLabelText"));		
        this.contviewType.setBoundLabelLength(100);		
        this.contviewType.setBoundLabelUnderline(true);		
        this.contviewType.setVisible(true);
        // contremark		
        this.contremark.setBoundLabelText(resHelper.getString("contremark.boundLabelText"));		
        this.contremark.setBoundLabelLength(0);		
        this.contremark.setBoundLabelUnderline(true);		
        this.contremark.setVisible(true);
        // contrecDate		
        this.contrecDate.setBoundLabelText(resHelper.getString("contrecDate.boundLabelText"));		
        this.contrecDate.setBoundLabelLength(100);		
        this.contrecDate.setBoundLabelUnderline(true);		
        this.contrecDate.setVisible(true);
        // contrecQty		
        this.contrecQty.setBoundLabelText(resHelper.getString("contrecQty.boundLabelText"));		
        this.contrecQty.setBoundLabelLength(120);		
        this.contrecQty.setBoundLabelUnderline(true);		
        this.contrecQty.setVisible(true);
        // contfeedWgt		
        this.contfeedWgt.setBoundLabelText(resHelper.getString("contfeedWgt.boundLabelText"));		
        this.contfeedWgt.setBoundLabelLength(120);		
        this.contfeedWgt.setBoundLabelUnderline(true);		
        this.contfeedWgt.setVisible(true);
        // contrecRate		
        this.contrecRate.setBoundLabelText(resHelper.getString("contrecRate.boundLabelText"));		
        this.contrecRate.setBoundLabelLength(120);		
        this.contrecRate.setBoundLabelUnderline(true);		
        this.contrecRate.setVisible(true);
        // contfmRate		
        this.contfmRate.setBoundLabelText(resHelper.getString("contfmRate.boundLabelText"));		
        this.contfmRate.setBoundLabelLength(120);		
        this.contfmRate.setBoundLabelUnderline(true);		
        this.contfmRate.setVisible(true);
        // contdrugAmt		
        this.contdrugAmt.setBoundLabelText(resHelper.getString("contdrugAmt.boundLabelText"));		
        this.contdrugAmt.setBoundLabelLength(120);		
        this.contdrugAmt.setBoundLabelUnderline(true);		
        this.contdrugAmt.setVisible(true);
        // contsingleDrugAmt		
        this.contsingleDrugAmt.setBoundLabelText(resHelper.getString("contsingleDrugAmt.boundLabelText"));		
        this.contsingleDrugAmt.setBoundLabelLength(120);		
        this.contsingleDrugAmt.setBoundLabelUnderline(true);		
        this.contsingleDrugAmt.setVisible(true);
        // contoValue		
        this.contoValue.setBoundLabelText(resHelper.getString("contoValue.boundLabelText"));		
        this.contoValue.setBoundLabelLength(120);		
        this.contoValue.setBoundLabelUnderline(true);		
        this.contoValue.setVisible(true);
        // kDLabel1		
        this.kDLabel1.setText(resHelper.getString("kDLabel1.text"));
        // contauditAmt		
        this.contauditAmt.setBoundLabelText(resHelper.getString("contauditAmt.boundLabelText"));		
        this.contauditAmt.setBoundLabelLength(120);		
        this.contauditAmt.setBoundLabelUnderline(true);		
        this.contauditAmt.setVisible(true);
        // contrecSuttle		
        this.contrecSuttle.setBoundLabelText(resHelper.getString("contrecSuttle.boundLabelText"));		
        this.contrecSuttle.setBoundLabelLength(120);		
        this.contrecSuttle.setBoundLabelUnderline(true);		
        this.contrecSuttle.setVisible(true);
        // contdyFee		
        this.contdyFee.setBoundLabelText(resHelper.getString("contdyFee.boundLabelText"));		
        this.contdyFee.setBoundLabelLength(120);		
        this.contdyFee.setBoundLabelUnderline(true);		
        this.contdyFee.setVisible(true);
        // contsingleDyFee		
        this.contsingleDyFee.setBoundLabelText(resHelper.getString("contsingleDyFee.boundLabelText"));		
        this.contsingleDyFee.setBoundLabelLength(120);		
        this.contsingleDyFee.setBoundLabelUnderline(true);		
        this.contsingleDyFee.setVisible(true);
        // contcAverageWgt		
        this.contcAverageWgt.setBoundLabelText(resHelper.getString("contcAverageWgt.boundLabelText"));		
        this.contcAverageWgt.setBoundLabelLength(120);		
        this.contcAverageWgt.setBoundLabelUnderline(true);		
        this.contcAverageWgt.setVisible(true);
        // contfeedDays		
        this.contfeedDays.setBoundLabelText(resHelper.getString("contfeedDays.boundLabelText"));		
        this.contfeedDays.setBoundLabelLength(120);		
        this.contfeedDays.setBoundLabelUnderline(true);		
        this.contfeedDays.setVisible(true);
        // contsingleFeedWgt		
        this.contsingleFeedWgt.setBoundLabelText(resHelper.getString("contsingleFeedWgt.boundLabelText"));		
        this.contsingleFeedWgt.setBoundLabelLength(120);		
        this.contsingleFeedWgt.setBoundLabelUnderline(true);		
        this.contsingleFeedWgt.setVisible(true);
        // BtnUpdateSettle		
        this.BtnUpdateSettle.setText(resHelper.getString("BtnUpdateSettle.text"));
        this.BtnUpdateSettle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    BtnUpdateSettle_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // contbreedData		
        this.contbreedData.setBoundLabelText(resHelper.getString("contbreedData.boundLabelText"));		
        this.contbreedData.setBoundLabelLength(100);		
        this.contbreedData.setBoundLabelUnderline(true);		
        this.contbreedData.setVisible(true);
        // contseedSource		
        this.contseedSource.setBoundLabelText(resHelper.getString("contseedSource.boundLabelText"));		
        this.contseedSource.setBoundLabelLength(100);		
        this.contseedSource.setBoundLabelUnderline(true);		
        this.contseedSource.setVisible(true);
        // contsettlePolicy		
        this.contsettlePolicy.setBoundLabelText(resHelper.getString("contsettlePolicy.boundLabelText"));		
        this.contsettlePolicy.setBoundLabelLength(100);		
        this.contsettlePolicy.setBoundLabelUnderline(true);		
        this.contsettlePolicy.setVisible(true);
        // contbreedPrice		
        this.contbreedPrice.setBoundLabelText(resHelper.getString("contbreedPrice.boundLabelText"));		
        this.contbreedPrice.setBoundLabelLength(120);		
        this.contbreedPrice.setBoundLabelUnderline(true);		
        this.contbreedPrice.setVisible(true);
        // contapplyGetBreed		
        this.contapplyGetBreed.setBoundLabelText(resHelper.getString("contapplyGetBreed.boundLabelText"));		
        this.contapplyGetBreed.setBoundLabelLength(120);		
        this.contapplyGetBreed.setBoundLabelUnderline(true);		
        this.contapplyGetBreed.setVisible(true);
        // contauditGetBreed		
        this.contauditGetBreed.setBoundLabelText(resHelper.getString("contauditGetBreed.boundLabelText"));		
        this.contauditGetBreed.setBoundLabelLength(120);		
        this.contauditGetBreed.setBoundLabelUnderline(true);		
        this.contauditGetBreed.setVisible(true);
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
        this.pkBizDate.setVisible(true);		
        this.pkBizDate.setEnabled(true);		
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
        		setOrgF7(prmtFICompany,com.kingdee.eas.basedata.org.OrgType.getEnum("Company"));
					
        // billStatus		
        this.billStatus.setVisible(true);		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
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
        // txtamount		
        this.txtamount.setVisible(true);		
        this.txtamount.setHorizontalAlignment(2);		
        this.txtamount.setDataType(1);		
        this.txtamount.setSupportedEmpty(true);		
        this.txtamount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtamount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtamount.setPrecision(2);		
        this.txtamount.setRequired(true);
        // pkauditTime		
        this.pkauditTime.setVisible(true);		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // prmtviewType		
        this.prmtviewType.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.CustomerViewTypeQuery");		
        this.prmtviewType.setVisible(true);		
        this.prmtviewType.setEditable(true);		
        this.prmtviewType.setDisplayFormat("$name$");		
        this.prmtviewType.setEditFormat("$number$");		
        this.prmtviewType.setCommitFormat("$number$");		
        this.prmtviewType.setRequired(true);
        		EntityViewInfo eviprmtviewType = new EntityViewInfo ();
		eviprmtviewType.setFilter(com.kingdee.eas.framework.FrameWorkUtils.getF7FilterInfoByAuthorizedOrg(com.kingdee.eas.basedata.org.OrgType.getEnum("Company"),"FICompany.id"));
		prmtviewType.setEntityViewInfo(eviprmtviewType);
					
        // scrollPaneremark
        // txtremark		
        this.txtremark.setVisible(true);		
        this.txtremark.setRequired(false);		
        this.txtremark.setMaxLength(1000);
        // pkrecDate		
        this.pkrecDate.setVisible(true);		
        this.pkrecDate.setRequired(false);		
        this.pkrecDate.setEnabled(false);
        // txtrecQty		
        this.txtrecQty.setVisible(true);		
        this.txtrecQty.setHorizontalAlignment(2);		
        this.txtrecQty.setDataType(0);		
        this.txtrecQty.setSupportedEmpty(true);		
        this.txtrecQty.setRequired(false);		
        this.txtrecQty.setEnabled(false);
        // txtfeedWgt		
        this.txtfeedWgt.setVisible(true);		
        this.txtfeedWgt.setHorizontalAlignment(2);		
        this.txtfeedWgt.setDataType(1);		
        this.txtfeedWgt.setSupportedEmpty(true);		
        this.txtfeedWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfeedWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfeedWgt.setPrecision(4);		
        this.txtfeedWgt.setRequired(false);		
        this.txtfeedWgt.setEnabled(false);
        // txtrecRate		
        this.txtrecRate.setVisible(true);		
        this.txtrecRate.setHorizontalAlignment(2);		
        this.txtrecRate.setDataType(1);		
        this.txtrecRate.setSupportedEmpty(true);		
        this.txtrecRate.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtrecRate.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtrecRate.setPrecision(4);		
        this.txtrecRate.setRequired(false);		
        this.txtrecRate.setEnabled(false);
        // txtfmRate		
        this.txtfmRate.setVisible(true);		
        this.txtfmRate.setHorizontalAlignment(2);		
        this.txtfmRate.setDataType(1);		
        this.txtfmRate.setSupportedEmpty(true);		
        this.txtfmRate.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfmRate.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfmRate.setPrecision(4);		
        this.txtfmRate.setRequired(false);		
        this.txtfmRate.setEnabled(false);
        // txtdrugAmt		
        this.txtdrugAmt.setVisible(true);		
        this.txtdrugAmt.setHorizontalAlignment(2);		
        this.txtdrugAmt.setDataType(1);		
        this.txtdrugAmt.setSupportedEmpty(true);		
        this.txtdrugAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdrugAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdrugAmt.setPrecision(2);		
        this.txtdrugAmt.setRequired(false);		
        this.txtdrugAmt.setEnabled(false);
        // txtsingleDrugAmt		
        this.txtsingleDrugAmt.setVisible(true);		
        this.txtsingleDrugAmt.setHorizontalAlignment(2);		
        this.txtsingleDrugAmt.setDataType(1);		
        this.txtsingleDrugAmt.setSupportedEmpty(true);		
        this.txtsingleDrugAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsingleDrugAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsingleDrugAmt.setPrecision(2);		
        this.txtsingleDrugAmt.setRequired(false);		
        this.txtsingleDrugAmt.setEnabled(false);
        // txtoValue		
        this.txtoValue.setVisible(true);		
        this.txtoValue.setHorizontalAlignment(2);		
        this.txtoValue.setDataType(1);		
        this.txtoValue.setSupportedEmpty(true);		
        this.txtoValue.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtoValue.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtoValue.setPrecision(4);		
        this.txtoValue.setRequired(false);		
        this.txtoValue.setEnabled(false);
        // txtauditAmt		
        this.txtauditAmt.setVisible(true);		
        this.txtauditAmt.setHorizontalAlignment(2);		
        this.txtauditAmt.setDataType(1);		
        this.txtauditAmt.setSupportedEmpty(true);		
        this.txtauditAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtauditAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtauditAmt.setPrecision(2);		
        this.txtauditAmt.setRequired(false);
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
        // txtdyFee		
        this.txtdyFee.setVisible(true);		
        this.txtdyFee.setHorizontalAlignment(2);		
        this.txtdyFee.setDataType(1);		
        this.txtdyFee.setSupportedEmpty(true);		
        this.txtdyFee.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdyFee.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdyFee.setPrecision(2);		
        this.txtdyFee.setRequired(false);		
        this.txtdyFee.setEnabled(false);
        // txtsingleDyFee		
        this.txtsingleDyFee.setVisible(true);		
        this.txtsingleDyFee.setHorizontalAlignment(2);		
        this.txtsingleDyFee.setDataType(1);		
        this.txtsingleDyFee.setSupportedEmpty(true);		
        this.txtsingleDyFee.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsingleDyFee.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsingleDyFee.setPrecision(2);		
        this.txtsingleDyFee.setRequired(false);		
        this.txtsingleDyFee.setEnabled(false);
        // txtcAverageWgt		
        this.txtcAverageWgt.setVisible(true);		
        this.txtcAverageWgt.setHorizontalAlignment(2);		
        this.txtcAverageWgt.setDataType(1);		
        this.txtcAverageWgt.setSupportedEmpty(true);		
        this.txtcAverageWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcAverageWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcAverageWgt.setPrecision(4);		
        this.txtcAverageWgt.setRequired(false);		
        this.txtcAverageWgt.setEnabled(false);
        // txtfeedDays		
        this.txtfeedDays.setVisible(true);		
        this.txtfeedDays.setHorizontalAlignment(2);		
        this.txtfeedDays.setDataType(0);		
        this.txtfeedDays.setSupportedEmpty(true);		
        this.txtfeedDays.setRequired(false);		
        this.txtfeedDays.setEnabled(false);
        // txtsingleFeedWgt		
        this.txtsingleFeedWgt.setVisible(true);		
        this.txtsingleFeedWgt.setHorizontalAlignment(2);		
        this.txtsingleFeedWgt.setDataType(1);		
        this.txtsingleFeedWgt.setSupportedEmpty(true);		
        this.txtsingleFeedWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsingleFeedWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsingleFeedWgt.setPrecision(4);		
        this.txtsingleFeedWgt.setRequired(false);		
        this.txtsingleFeedWgt.setEnabled(false);
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
					
        // txtseedSource		
        this.txtseedSource.setVisible(true);		
        this.txtseedSource.setHorizontalAlignment(2);		
        this.txtseedSource.setMaxLength(250);		
        this.txtseedSource.setRequired(false);		
        this.txtseedSource.setEnabled(false);
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
					
        // txtbreedPrice		
        this.txtbreedPrice.setVisible(true);		
        this.txtbreedPrice.setHorizontalAlignment(2);		
        this.txtbreedPrice.setDataType(1);		
        this.txtbreedPrice.setSupportedEmpty(true);		
        this.txtbreedPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbreedPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbreedPrice.setPrecision(4);		
        this.txtbreedPrice.setRequired(false);		
        this.txtbreedPrice.setEnabled(false);
        // txtapplyGetBreed		
        this.txtapplyGetBreed.setVisible(true);		
        this.txtapplyGetBreed.setHorizontalAlignment(2);		
        this.txtapplyGetBreed.setDataType(1);		
        this.txtapplyGetBreed.setSupportedEmpty(true);		
        this.txtapplyGetBreed.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtapplyGetBreed.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtapplyGetBreed.setPrecision(4);		
        this.txtapplyGetBreed.setRequired(false);
        // txtauditGetBreed		
        this.txtauditGetBreed.setVisible(true);		
        this.txtauditGetBreed.setHorizontalAlignment(2);		
        this.txtauditGetBreed.setDataType(1);		
        this.txtauditGetBreed.setSupportedEmpty(true);		
        this.txtauditGetBreed.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtauditGetBreed.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtauditGetBreed.setPrecision(4);		
        this.txtauditGetBreed.setRequired(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        // btnUpdateSettle		
        this.btnUpdateSettle.setText(resHelper.getString("btnUpdateSettle.text"));		
        this.btnUpdateSettle.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_demandcollateresult"));
        this.btnUpdateSettle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnUpdateSettle_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnRevoke
        this.btnRevoke.setAction((IItemAction)ActionProxyFactory.getProxy(actionRevoke, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnRevoke.setText(resHelper.getString("btnRevoke.text"));		
        this.btnRevoke.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_blankout"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {billStatus,prmtfarmer,prmtfarm,prmtbatchContract,prmtbatch,pkinDate,txtbatchQty,prmtperson,txtamount,pkauditTime,prmtviewType,txtremark,pkrecDate,txtrecQty,txtfeedWgt,txtrecRate,txtfmRate,txtdrugAmt,txtsingleDrugAmt,txtoValue,txtauditAmt,txtrecSuttle,txtdyFee,txtsingleDyFee,txtcAverageWgt,txtfeedDays,txtsingleFeedWgt,prmtbreedData,txtseedSource,prmtsettlePolicy,txtbreedPrice,txtapplyGetBreed,txtauditGetBreed}));
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
        this.setBounds(new Rectangle(0, 0, 1015, 629));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1015, 629));
        contCreator.setBounds(new Rectangle(440, 560, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(440, 560, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(730, 560, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(730, 560, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(440, 591, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(440, 591, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(730, 591, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(730, 591, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(39, 14, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(39, 14, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(373, 14, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(373, 14, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(22, 555, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(22, 555, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contFICompany.setBounds(new Rectangle(39, 42, 270, 19));
        this.add(contFICompany, new KDLayout.Constraints(39, 42, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(712, 14, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(712, 14, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfarmer.setBounds(new Rectangle(712, 42, 270, 19));
        this.add(contfarmer, new KDLayout.Constraints(712, 42, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfarm.setBounds(new Rectangle(39, 70, 270, 19));
        this.add(contfarm, new KDLayout.Constraints(39, 70, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbatchContract.setBounds(new Rectangle(373, 70, 270, 19));
        this.add(contbatchContract, new KDLayout.Constraints(373, 70, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbatch.setBounds(new Rectangle(712, 70, 270, 19));
        this.add(contbatch, new KDLayout.Constraints(712, 70, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        continDate.setBounds(new Rectangle(712, 98, 270, 19));
        this.add(continDate, new KDLayout.Constraints(712, 98, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbatchQty.setBounds(new Rectangle(39, 126, 270, 19));
        this.add(contbatchQty, new KDLayout.Constraints(39, 126, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contperson.setBounds(new Rectangle(39, 266, 270, 19));
        this.add(contperson, new KDLayout.Constraints(39, 266, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contamount.setBounds(new Rectangle(373, 266, 270, 19));
        this.add(contamount, new KDLayout.Constraints(373, 266, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(22, 593, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(22, 593, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contviewType.setBounds(new Rectangle(373, 42, 270, 19));
        this.add(contviewType, new KDLayout.Constraints(373, 42, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contremark.setBounds(new Rectangle(43, 379, 917, 165));
        this.add(contremark, new KDLayout.Constraints(43, 379, 917, 165, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contrecDate.setBounds(new Rectangle(373, 126, 270, 19));
        this.add(contrecDate, new KDLayout.Constraints(373, 126, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contrecQty.setBounds(new Rectangle(712, 126, 270, 19));
        this.add(contrecQty, new KDLayout.Constraints(712, 126, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfeedWgt.setBounds(new Rectangle(373, 154, 270, 19));
        this.add(contfeedWgt, new KDLayout.Constraints(373, 154, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contrecRate.setBounds(new Rectangle(712, 182, 270, 19));
        this.add(contrecRate, new KDLayout.Constraints(712, 182, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfmRate.setBounds(new Rectangle(39, 210, 270, 19));
        this.add(contfmRate, new KDLayout.Constraints(39, 210, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdrugAmt.setBounds(new Rectangle(712, 154, 270, 19));
        this.add(contdrugAmt, new KDLayout.Constraints(712, 154, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contsingleDrugAmt.setBounds(new Rectangle(39, 238, 270, 19));
        this.add(contsingleDrugAmt, new KDLayout.Constraints(39, 238, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoValue.setBounds(new Rectangle(712, 238, 270, 19));
        this.add(contoValue, new KDLayout.Constraints(712, 238, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabel1.setBounds(new Rectangle(43, 354, 100, 19));
        this.add(kDLabel1, new KDLayout.Constraints(43, 354, 100, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditAmt.setBounds(new Rectangle(712, 266, 270, 19));
        this.add(contauditAmt, new KDLayout.Constraints(712, 266, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contrecSuttle.setBounds(new Rectangle(39, 154, 270, 19));
        this.add(contrecSuttle, new KDLayout.Constraints(39, 154, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdyFee.setBounds(new Rectangle(39, 182, 270, 19));
        this.add(contdyFee, new KDLayout.Constraints(39, 182, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsingleDyFee.setBounds(new Rectangle(373, 182, 270, 19));
        this.add(contsingleDyFee, new KDLayout.Constraints(373, 182, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcAverageWgt.setBounds(new Rectangle(373, 210, 270, 19));
        this.add(contcAverageWgt, new KDLayout.Constraints(373, 210, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfeedDays.setBounds(new Rectangle(712, 210, 270, 19));
        this.add(contfeedDays, new KDLayout.Constraints(712, 210, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contsingleFeedWgt.setBounds(new Rectangle(373, 238, 270, 19));
        this.add(contsingleFeedWgt, new KDLayout.Constraints(373, 238, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        BtnUpdateSettle.setBounds(new Rectangle(846, 344, 110, 30));
        this.add(BtnUpdateSettle, new KDLayout.Constraints(846, 344, 110, 30, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbreedData.setBounds(new Rectangle(39, 98, 270, 19));
        this.add(contbreedData, new KDLayout.Constraints(39, 98, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contseedSource.setBounds(new Rectangle(39, 328, 947, 19));
        this.add(contseedSource, new KDLayout.Constraints(39, 328, 947, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contsettlePolicy.setBounds(new Rectangle(373, 98, 270, 19));
        this.add(contsettlePolicy, new KDLayout.Constraints(373, 98, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbreedPrice.setBounds(new Rectangle(39, 296, 270, 19));
        this.add(contbreedPrice, new KDLayout.Constraints(39, 296, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contapplyGetBreed.setBounds(new Rectangle(373, 296, 270, 19));
        this.add(contapplyGetBreed, new KDLayout.Constraints(373, 296, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditGetBreed.setBounds(new Rectangle(712, 296, 270, 19));
        this.add(contauditGetBreed, new KDLayout.Constraints(712, 296, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contfarmer
        contfarmer.setBoundEditor(prmtfarmer);
        //contfarm
        contfarm.setBoundEditor(prmtfarm);
        //contbatchContract
        contbatchContract.setBoundEditor(prmtbatchContract);
        //contbatch
        contbatch.setBoundEditor(prmtbatch);
        //continDate
        continDate.setBoundEditor(pkinDate);
        //contbatchQty
        contbatchQty.setBoundEditor(txtbatchQty);
        //contperson
        contperson.setBoundEditor(prmtperson);
        //contamount
        contamount.setBoundEditor(txtamount);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contviewType
        contviewType.setBoundEditor(prmtviewType);
        //contremark
        contremark.setBoundEditor(scrollPaneremark);
        //scrollPaneremark
        scrollPaneremark.getViewport().add(txtremark, null);
        //contrecDate
        contrecDate.setBoundEditor(pkrecDate);
        //contrecQty
        contrecQty.setBoundEditor(txtrecQty);
        //contfeedWgt
        contfeedWgt.setBoundEditor(txtfeedWgt);
        //contrecRate
        contrecRate.setBoundEditor(txtrecRate);
        //contfmRate
        contfmRate.setBoundEditor(txtfmRate);
        //contdrugAmt
        contdrugAmt.setBoundEditor(txtdrugAmt);
        //contsingleDrugAmt
        contsingleDrugAmt.setBoundEditor(txtsingleDrugAmt);
        //contoValue
        contoValue.setBoundEditor(txtoValue);
        //contauditAmt
        contauditAmt.setBoundEditor(txtauditAmt);
        //contrecSuttle
        contrecSuttle.setBoundEditor(txtrecSuttle);
        //contdyFee
        contdyFee.setBoundEditor(txtdyFee);
        //contsingleDyFee
        contsingleDyFee.setBoundEditor(txtsingleDyFee);
        //contcAverageWgt
        contcAverageWgt.setBoundEditor(txtcAverageWgt);
        //contfeedDays
        contfeedDays.setBoundEditor(txtfeedDays);
        //contsingleFeedWgt
        contsingleFeedWgt.setBoundEditor(txtsingleFeedWgt);
        //contbreedData
        contbreedData.setBoundEditor(prmtbreedData);
        //contseedSource
        contseedSource.setBoundEditor(txtseedSource);
        //contsettlePolicy
        contsettlePolicy.setBoundEditor(prmtsettlePolicy);
        //contbreedPrice
        contbreedPrice.setBoundEditor(txtbreedPrice);
        //contapplyGetBreed
        contapplyGetBreed.setBoundEditor(txtapplyGetBreed);
        //contauditGetBreed
        contauditGetBreed.setBoundEditor(txtauditGetBreed);

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
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);
        this.toolBar.add(btnUpdateSettle);
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
        this.toolBar.add(btnRevoke);


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
		dataBinder.registerBinding("farmer", com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo.class, this.prmtfarmer, "data");
		dataBinder.registerBinding("farm", com.kingdee.eas.farm.carnivorous.basedata.FarmInfo.class, this.prmtfarm, "data");
		dataBinder.registerBinding("batchContract", com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo.class, this.prmtbatchContract, "data");
		dataBinder.registerBinding("batch", com.kingdee.eas.farm.carnivorous.basedata.BatchInfo.class, this.prmtbatch, "data");
		dataBinder.registerBinding("inDate", java.util.Date.class, this.pkinDate, "value");
		dataBinder.registerBinding("batchQty", java.math.BigDecimal.class, this.txtbatchQty, "value");
		dataBinder.registerBinding("person", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtperson, "data");
		dataBinder.registerBinding("amount", java.math.BigDecimal.class, this.txtamount, "value");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("viewType", com.kingdee.eas.farm.carnivorous.basedata.CustomerViewTypeInfo.class, this.prmtviewType, "data");
		dataBinder.registerBinding("remark", String.class, this.txtremark, "text");
		dataBinder.registerBinding("recDate", java.util.Date.class, this.pkrecDate, "value");
		dataBinder.registerBinding("recQty", int.class, this.txtrecQty, "value");
		dataBinder.registerBinding("feedWgt", java.math.BigDecimal.class, this.txtfeedWgt, "value");
		dataBinder.registerBinding("recRate", java.math.BigDecimal.class, this.txtrecRate, "value");
		dataBinder.registerBinding("fmRate", java.math.BigDecimal.class, this.txtfmRate, "value");
		dataBinder.registerBinding("drugAmt", java.math.BigDecimal.class, this.txtdrugAmt, "value");
		dataBinder.registerBinding("singleDrugAmt", java.math.BigDecimal.class, this.txtsingleDrugAmt, "value");
		dataBinder.registerBinding("oValue", java.math.BigDecimal.class, this.txtoValue, "value");
		dataBinder.registerBinding("auditAmt", java.math.BigDecimal.class, this.txtauditAmt, "value");
		dataBinder.registerBinding("recSuttle", java.math.BigDecimal.class, this.txtrecSuttle, "value");
		dataBinder.registerBinding("dyFee", java.math.BigDecimal.class, this.txtdyFee, "value");
		dataBinder.registerBinding("singleDyFee", java.math.BigDecimal.class, this.txtsingleDyFee, "value");
		dataBinder.registerBinding("cAverageWgt", java.math.BigDecimal.class, this.txtcAverageWgt, "value");
		dataBinder.registerBinding("feedDays", int.class, this.txtfeedDays, "value");
		dataBinder.registerBinding("singleFeedWgt", java.math.BigDecimal.class, this.txtsingleFeedWgt, "value");
		dataBinder.registerBinding("breedData", com.kingdee.eas.farm.stocking.basedata.BreedDataInfo.class, this.prmtbreedData, "data");
		dataBinder.registerBinding("seedSource", String.class, this.txtseedSource, "text");
		dataBinder.registerBinding("settlePolicy", com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo.class, this.prmtsettlePolicy, "data");
		dataBinder.registerBinding("breedPrice", java.math.BigDecimal.class, this.txtbreedPrice, "value");
		dataBinder.registerBinding("applyGetBreed", java.math.BigDecimal.class, this.txtapplyGetBreed, "value");
		dataBinder.registerBinding("auditGetBreed", java.math.BigDecimal.class, this.txtauditGetBreed, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.carnivorous.basebiz.app.CustomerViewReqBillEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.carnivorous.basebiz.CustomerViewReqBillInfo)ov;
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
		getValidateHelper().registerBindProperty("farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batchContract", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("inDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batchQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("person", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("viewType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("recDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("recQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("feedWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("recRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fmRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("drugAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("singleDrugAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("oValue", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("recSuttle", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dyFee", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("singleDyFee", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cAverageWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("feedDays", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("singleFeedWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedData", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("seedSource", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("settlePolicy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("applyGetBreed", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditGetBreed", ValidateHelper.ON_SAVE);    		
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
     * output BtnUpdateSettle_actionPerformed method
     */
    protected void BtnUpdateSettle_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output btnUpdateSettle_actionPerformed method
     */
    protected void btnUpdateSettle_actionPerformed(java.awt.event.ActionEvent e) throws Exception
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
        sic.add(new SelectorItemInfo("amount"));
        sic.add(new SelectorItemInfo("auditTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("viewType.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("viewType.id"));
        	sic.add(new SelectorItemInfo("viewType.number"));
        	sic.add(new SelectorItemInfo("viewType.name"));
		}
        sic.add(new SelectorItemInfo("remark"));
        sic.add(new SelectorItemInfo("recDate"));
        sic.add(new SelectorItemInfo("recQty"));
        sic.add(new SelectorItemInfo("feedWgt"));
        sic.add(new SelectorItemInfo("recRate"));
        sic.add(new SelectorItemInfo("fmRate"));
        sic.add(new SelectorItemInfo("drugAmt"));
        sic.add(new SelectorItemInfo("singleDrugAmt"));
        sic.add(new SelectorItemInfo("oValue"));
        sic.add(new SelectorItemInfo("auditAmt"));
        sic.add(new SelectorItemInfo("recSuttle"));
        sic.add(new SelectorItemInfo("dyFee"));
        sic.add(new SelectorItemInfo("singleDyFee"));
        sic.add(new SelectorItemInfo("cAverageWgt"));
        sic.add(new SelectorItemInfo("feedDays"));
        sic.add(new SelectorItemInfo("singleFeedWgt"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("breedData.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("breedData.id"));
        	sic.add(new SelectorItemInfo("breedData.number"));
        	sic.add(new SelectorItemInfo("breedData.name"));
		}
        sic.add(new SelectorItemInfo("seedSource"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("settlePolicy.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("settlePolicy.id"));
        	sic.add(new SelectorItemInfo("settlePolicy.number"));
        	sic.add(new SelectorItemInfo("settlePolicy.name"));
		}
        sic.add(new SelectorItemInfo("breedPrice"));
        sic.add(new SelectorItemInfo("applyGetBreed"));
        sic.add(new SelectorItemInfo("auditGetBreed"));
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
        com.kingdee.eas.farm.carnivorous.basebiz.CustomerViewReqBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.basebiz.CustomerViewReqBillFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionRevoke_actionPerformed method
     */
    public void actionRevoke_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.basebiz.CustomerViewReqBillFactory.getRemoteInstance().revoke(editData);
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
	public RequestContext prepareActionRevoke(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionRevoke() {
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
            innerActionPerformed("eas", AbstractCustomerViewReqBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractCustomerViewReqBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionRevoke class
     */     
    protected class ActionRevoke extends ItemAction {     
    
        public ActionRevoke()
        {
            this(null);
        }

        public ActionRevoke(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionRevoke.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionRevoke.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionRevoke.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCustomerViewReqBillEditUI.this, "ActionRevoke", "actionRevoke_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.basebiz.client", "CustomerViewReqBillEditUI");
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
        return com.kingdee.eas.farm.carnivorous.basebiz.client.CustomerViewReqBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.basebiz.CustomerViewReqBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.basebiz.CustomerViewReqBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.basebiz.CustomerViewReqBillInfo();
				if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")).getBoolean("isBizUnit"))
			objectValue.put("FICompany",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")));
 
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/carnivorous/basebiz/CustomerViewReqBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.carnivorous.basebiz.app.CustomerViewReqBillQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
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
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtamount.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"金额"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtviewType.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"客诉类型"});
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