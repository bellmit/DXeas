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
public abstract class AbstractCCarSendBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCCarSendBillEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contplanAverageQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmerPhone;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedData;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpurType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmileage;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdeliverQty;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisHasPQGB;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcar;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdriver;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdriverPhone;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contarriveTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contseq;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoutSalePrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contseedSource;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntry_detailPanel = null;
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
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtplanAverageQty;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfarmerPhone;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbreedData;
    protected com.kingdee.bos.ctrl.swing.KDComboBox purType;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmileage;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdeliverQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcar;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtdriver;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdriverPhone;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkarriveTime;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtseq;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoutSalePrice;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtseedSource;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractCCarSendBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCCarSendBillEditUI.class.getName());
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
        this.contplanAverageQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmerPhone = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbreedData = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpurType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmileage = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdeliverQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisHasPQGB = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contcar = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdriver = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdriverPhone = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contarriveTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contseq = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoutSalePrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contseedSource = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
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
        this.txtplanAverageQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfarmerPhone = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtbreedData = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.purType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtmileage = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdeliverQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtcar = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtdriver = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtdriverPhone = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkarriveTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtseq = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtoutSalePrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
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
        this.contplanAverageQty.setName("contplanAverageQty");
        this.contfarmerPhone.setName("contfarmerPhone");
        this.contbreedData.setName("contbreedData");
        this.contpurType.setName("contpurType");
        this.contmileage.setName("contmileage");
        this.contdeliverQty.setName("contdeliverQty");
        this.chkisHasPQGB.setName("chkisHasPQGB");
        this.contcar.setName("contcar");
        this.contdriver.setName("contdriver");
        this.contdriverPhone.setName("contdriverPhone");
        this.contarriveTime.setName("contarriveTime");
        this.contseq.setName("contseq");
        this.contoutSalePrice.setName("contoutSalePrice");
        this.contseedSource.setName("contseedSource");
        this.kdtEntry.setName("kdtEntry");
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
        this.txtplanAverageQty.setName("txtplanAverageQty");
        this.txtfarmerPhone.setName("txtfarmerPhone");
        this.prmtbreedData.setName("prmtbreedData");
        this.purType.setName("purType");
        this.txtmileage.setName("txtmileage");
        this.txtdeliverQty.setName("txtdeliverQty");
        this.prmtcar.setName("prmtcar");
        this.prmtdriver.setName("prmtdriver");
        this.txtdriverPhone.setName("txtdriverPhone");
        this.pkarriveTime.setName("pkarriveTime");
        this.txtseq.setName("txtseq");
        this.txtoutSalePrice.setName("txtoutSalePrice");
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
        // contplanAverageQty		
        this.contplanAverageQty.setBoundLabelText(resHelper.getString("contplanAverageQty.boundLabelText"));		
        this.contplanAverageQty.setBoundLabelLength(100);		
        this.contplanAverageQty.setBoundLabelUnderline(true);		
        this.contplanAverageQty.setVisible(true);
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
        // contpurType		
        this.contpurType.setBoundLabelText(resHelper.getString("contpurType.boundLabelText"));		
        this.contpurType.setBoundLabelLength(100);		
        this.contpurType.setBoundLabelUnderline(true);		
        this.contpurType.setVisible(true);
        // contmileage		
        this.contmileage.setBoundLabelText(resHelper.getString("contmileage.boundLabelText"));		
        this.contmileage.setBoundLabelLength(100);		
        this.contmileage.setBoundLabelUnderline(true);		
        this.contmileage.setVisible(true);
        // contdeliverQty		
        this.contdeliverQty.setBoundLabelText(resHelper.getString("contdeliverQty.boundLabelText"));		
        this.contdeliverQty.setBoundLabelLength(100);		
        this.contdeliverQty.setBoundLabelUnderline(true);		
        this.contdeliverQty.setVisible(true);
        // chkisHasPQGB		
        this.chkisHasPQGB.setText(resHelper.getString("chkisHasPQGB.text"));		
        this.chkisHasPQGB.setVisible(true);		
        this.chkisHasPQGB.setHorizontalAlignment(2);		
        this.chkisHasPQGB.setEnabled(false);
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
        // contarriveTime		
        this.contarriveTime.setBoundLabelText(resHelper.getString("contarriveTime.boundLabelText"));		
        this.contarriveTime.setBoundLabelLength(100);		
        this.contarriveTime.setBoundLabelUnderline(true);		
        this.contarriveTime.setVisible(true);
        // contseq		
        this.contseq.setBoundLabelText(resHelper.getString("contseq.boundLabelText"));		
        this.contseq.setBoundLabelLength(100);		
        this.contseq.setBoundLabelUnderline(true);		
        this.contseq.setVisible(true);
        // contoutSalePrice		
        this.contoutSalePrice.setBoundLabelText(resHelper.getString("contoutSalePrice.boundLabelText"));		
        this.contoutSalePrice.setBoundLabelLength(100);		
        this.contoutSalePrice.setBoundLabelUnderline(true);		
        this.contoutSalePrice.setVisible(true);
        // contseedSource		
        this.contseedSource.setBoundLabelText(resHelper.getString("contseedSource.boundLabelText"));		
        this.contseedSource.setBoundLabelLength(100);		
        this.contseedSource.setBoundLabelUnderline(true);		
        this.contseedSource.setVisible(true);
        // kdtEntry
		String kdtEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"farmer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"farm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"farmAddress\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"farmerTele\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"batch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"inDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"inQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"days\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{farmer}</t:Cell><t:Cell>$Resource{farm}</t:Cell><t:Cell>$Resource{farmAddress}</t:Cell><t:Cell>$Resource{farmerTele}</t:Cell><t:Cell>$Resource{batch}</t:Cell><t:Cell>$Resource{inDate}</t:Cell><t:Cell>$Resource{inQty}</t:Cell><t:Cell>$Resource{days}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntry.setFormatXml(resHelper.translateString("kdtEntry",kdtEntryStrXML));

                this.kdtEntry.putBindContents("editData",new String[] {"seq","farmer","farm","farmAddress","farmerTele","batch","inDate","inQty","days"});


        this.kdtEntry.checkParsed();
        KDFormattedTextField kdtEntry_seq_TextField = new KDFormattedTextField();
        kdtEntry_seq_TextField.setName("kdtEntry_seq_TextField");
        kdtEntry_seq_TextField.setVisible(true);
        kdtEntry_seq_TextField.setEditable(true);
        kdtEntry_seq_TextField.setHorizontalAlignment(2);
        kdtEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtEntry_seq_TextField);
        this.kdtEntry.getColumn("seq").setEditor(kdtEntry_seq_CellEditor);
        final KDBizPromptBox kdtEntry_farmer_PromptBox = new KDBizPromptBox();
        kdtEntry_farmer_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerQuery");
        kdtEntry_farmer_PromptBox.setVisible(true);
        kdtEntry_farmer_PromptBox.setEditable(true);
        kdtEntry_farmer_PromptBox.setDisplayFormat("$number$");
        kdtEntry_farmer_PromptBox.setEditFormat("$number$");
        kdtEntry_farmer_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_farmer_CellEditor = new KDTDefaultCellEditor(kdtEntry_farmer_PromptBox);
        this.kdtEntry.getColumn("farmer").setEditor(kdtEntry_farmer_CellEditor);
        ObjectValueRender kdtEntry_farmer_OVR = new ObjectValueRender();
        kdtEntry_farmer_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("farmer").setRenderer(kdtEntry_farmer_OVR);
        			kdtEntry_farmer_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.FarmerListUI kdtEntry_farmer_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntry_farmer_PromptBox_F7ListUI == null) {
					try {
						kdtEntry_farmer_PromptBox_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.FarmerListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntry_farmer_PromptBox_F7ListUI));
					kdtEntry_farmer_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntry_farmer_PromptBox.setSelector(kdtEntry_farmer_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEntry_farm_PromptBox = new KDBizPromptBox();
        kdtEntry_farm_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmQuery");
        kdtEntry_farm_PromptBox.setVisible(true);
        kdtEntry_farm_PromptBox.setEditable(true);
        kdtEntry_farm_PromptBox.setDisplayFormat("$number$");
        kdtEntry_farm_PromptBox.setEditFormat("$number$");
        kdtEntry_farm_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_farm_CellEditor = new KDTDefaultCellEditor(kdtEntry_farm_PromptBox);
        this.kdtEntry.getColumn("farm").setEditor(kdtEntry_farm_CellEditor);
        ObjectValueRender kdtEntry_farm_OVR = new ObjectValueRender();
        kdtEntry_farm_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("farm").setRenderer(kdtEntry_farm_OVR);
        			kdtEntry_farm_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.FarmListUI kdtEntry_farm_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntry_farm_PromptBox_F7ListUI == null) {
					try {
						kdtEntry_farm_PromptBox_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.FarmListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntry_farm_PromptBox_F7ListUI));
					kdtEntry_farm_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntry_farm_PromptBox.setSelector(kdtEntry_farm_PromptBox_F7ListUI);
				}
			}
		});
					
        KDTextField kdtEntry_farmAddress_TextField = new KDTextField();
        kdtEntry_farmAddress_TextField.setName("kdtEntry_farmAddress_TextField");
        kdtEntry_farmAddress_TextField.setMaxLength(200);
        KDTDefaultCellEditor kdtEntry_farmAddress_CellEditor = new KDTDefaultCellEditor(kdtEntry_farmAddress_TextField);
        this.kdtEntry.getColumn("farmAddress").setEditor(kdtEntry_farmAddress_CellEditor);
        KDTextField kdtEntry_farmerTele_TextField = new KDTextField();
        kdtEntry_farmerTele_TextField.setName("kdtEntry_farmerTele_TextField");
        kdtEntry_farmerTele_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntry_farmerTele_CellEditor = new KDTDefaultCellEditor(kdtEntry_farmerTele_TextField);
        this.kdtEntry.getColumn("farmerTele").setEditor(kdtEntry_farmerTele_CellEditor);
        final KDBizPromptBox kdtEntry_batch_PromptBox = new KDBizPromptBox();
        kdtEntry_batch_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.BatchQuery");
        kdtEntry_batch_PromptBox.setVisible(true);
        kdtEntry_batch_PromptBox.setEditable(true);
        kdtEntry_batch_PromptBox.setDisplayFormat("$number$");
        kdtEntry_batch_PromptBox.setEditFormat("$number$");
        kdtEntry_batch_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_batch_CellEditor = new KDTDefaultCellEditor(kdtEntry_batch_PromptBox);
        this.kdtEntry.getColumn("batch").setEditor(kdtEntry_batch_CellEditor);
        ObjectValueRender kdtEntry_batch_OVR = new ObjectValueRender();
        kdtEntry_batch_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("batch").setRenderer(kdtEntry_batch_OVR);
        			kdtEntry_batch_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.BatchListUI kdtEntry_batch_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntry_batch_PromptBox_F7ListUI == null) {
					try {
						kdtEntry_batch_PromptBox_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.BatchListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntry_batch_PromptBox_F7ListUI));
					kdtEntry_batch_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntry_batch_PromptBox.setSelector(kdtEntry_batch_PromptBox_F7ListUI);
				}
			}
		});
					
        KDDatePicker kdtEntry_inDate_DatePicker = new KDDatePicker();
        kdtEntry_inDate_DatePicker.setName("kdtEntry_inDate_DatePicker");
        kdtEntry_inDate_DatePicker.setVisible(true);
        kdtEntry_inDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntry_inDate_CellEditor = new KDTDefaultCellEditor(kdtEntry_inDate_DatePicker);
        this.kdtEntry.getColumn("inDate").setEditor(kdtEntry_inDate_CellEditor);
        KDFormattedTextField kdtEntry_inQty_TextField = new KDFormattedTextField();
        kdtEntry_inQty_TextField.setName("kdtEntry_inQty_TextField");
        kdtEntry_inQty_TextField.setVisible(true);
        kdtEntry_inQty_TextField.setEditable(true);
        kdtEntry_inQty_TextField.setHorizontalAlignment(2);
        kdtEntry_inQty_TextField.setDataType(1);
        	kdtEntry_inQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_inQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_inQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_inQty_CellEditor = new KDTDefaultCellEditor(kdtEntry_inQty_TextField);
        this.kdtEntry.getColumn("inQty").setEditor(kdtEntry_inQty_CellEditor);
        KDFormattedTextField kdtEntry_days_TextField = new KDFormattedTextField();
        kdtEntry_days_TextField.setName("kdtEntry_days_TextField");
        kdtEntry_days_TextField.setVisible(true);
        kdtEntry_days_TextField.setEditable(true);
        kdtEntry_days_TextField.setHorizontalAlignment(2);
        kdtEntry_days_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntry_days_CellEditor = new KDTDefaultCellEditor(kdtEntry_days_TextField);
        this.kdtEntry.getColumn("days").setEditor(kdtEntry_days_CellEditor);
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
        this.prmtfarmer.setRequired(false);		
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
        this.prmtfarm.setRequired(false);		
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
        this.prmtbatchContract.setRequired(false);		
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
        this.prmtcustomer.setRequired(false);		
        this.prmtcustomer.setEnabled(false);
        // txtplanAverageQty		
        this.txtplanAverageQty.setVisible(true);		
        this.txtplanAverageQty.setHorizontalAlignment(2);		
        this.txtplanAverageQty.setDataType(1);		
        this.txtplanAverageQty.setSupportedEmpty(true);		
        this.txtplanAverageQty.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtplanAverageQty.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtplanAverageQty.setPrecision(4);		
        this.txtplanAverageQty.setRequired(false);
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
					
        // purType		
        this.purType.setVisible(true);		
        this.purType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.recyclebiz.PurType").toArray());		
        this.purType.setRequired(false);
        // txtmileage		
        this.txtmileage.setVisible(true);		
        this.txtmileage.setHorizontalAlignment(2);		
        this.txtmileage.setDataType(1);		
        this.txtmileage.setSupportedEmpty(true);		
        this.txtmileage.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtmileage.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtmileage.setPrecision(2);		
        this.txtmileage.setRequired(false);
        // txtdeliverQty		
        this.txtdeliverQty.setVisible(true);		
        this.txtdeliverQty.setHorizontalAlignment(2);		
        this.txtdeliverQty.setDataType(0);		
        this.txtdeliverQty.setSupportedEmpty(true);		
        this.txtdeliverQty.setRequired(false);
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
        // pkarriveTime		
        this.pkarriveTime.setVisible(true);		
        this.pkarriveTime.setRequired(false);
        // txtseq		
        this.txtseq.setVisible(true);		
        this.txtseq.setHorizontalAlignment(2);		
        this.txtseq.setDataType(0);		
        this.txtseq.setSupportedEmpty(true);		
        this.txtseq.setRequired(false);
        // txtoutSalePrice		
        this.txtoutSalePrice.setVisible(true);		
        this.txtoutSalePrice.setHorizontalAlignment(2);		
        this.txtoutSalePrice.setDataType(1);		
        this.txtoutSalePrice.setSupportedEmpty(true);		
        this.txtoutSalePrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtoutSalePrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtoutSalePrice.setPrecision(4);		
        this.txtoutSalePrice.setRequired(false);
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
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {pkauditTime,prmtfarmer,prmtfarm,prmtbatchContract,prmtbatch,billStatus,prmtsettlePolicy,pkinDate,txtbatchQty,prmtperson,txtfarmAddress,farmType,saleType,prmtcustomer,txtplanAverageQty,txtfarmerPhone,prmtbreedData,purType,txtmileage,txtdeliverQty,chkisHasPQGB,prmtcar,prmtdriver,txtdriverPhone,pkarriveTime,txtseq,txtoutSalePrice,txtseedSource}));
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
        this.setBounds(new Rectangle(-10, 2, 1204, 606));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(-10, 2, 1204, 606));
        contCreator.setBounds(new Rectangle(436, 528, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(436, 528, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(789, 527, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(789, 527, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(435, 560, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(435, 560, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(788, 559, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(788, 559, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(34, 25, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(34, 25, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(321, 25, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(321, 25, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(34, 289, 559, 19));
        this.add(contDescription, new KDLayout.Constraints(34, 289, 559, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(43, 527, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(43, 527, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contFICompany.setBounds(new Rectangle(615, 25, 270, 19));
        this.add(contFICompany, new KDLayout.Constraints(615, 25, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(42, 559, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(42, 559, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmer.setBounds(new Rectangle(34, 58, 270, 19));
        this.add(contfarmer, new KDLayout.Constraints(34, 58, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarm.setBounds(new Rectangle(321, 58, 270, 19));
        this.add(contfarm, new KDLayout.Constraints(321, 58, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbatchContract.setBounds(new Rectangle(615, 58, 270, 19));
        this.add(contbatchContract, new KDLayout.Constraints(615, 58, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbatch.setBounds(new Rectangle(34, 124, 270, 19));
        this.add(contbatch, new KDLayout.Constraints(34, 124, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(909, 25, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(909, 25, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsettlePolicy.setBounds(new Rectangle(34, 91, 270, 19));
        this.add(contsettlePolicy, new KDLayout.Constraints(34, 91, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        continDate.setBounds(new Rectangle(321, 124, 270, 19));
        this.add(continDate, new KDLayout.Constraints(321, 124, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbatchQty.setBounds(new Rectangle(615, 124, 270, 19));
        this.add(contbatchQty, new KDLayout.Constraints(615, 124, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator9.setBounds(new Rectangle(-4, 513, 1202, 8));
        this.add(kDSeparator9, new KDLayout.Constraints(-4, 513, 1202, 8, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contperson.setBounds(new Rectangle(909, 91, 270, 19));
        this.add(contperson, new KDLayout.Constraints(909, 91, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmAddress.setBounds(new Rectangle(615, 91, 270, 19));
        this.add(contfarmAddress, new KDLayout.Constraints(615, 91, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmType.setBounds(new Rectangle(909, 124, 270, 19));
        this.add(contfarmType, new KDLayout.Constraints(909, 124, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsaleType.setBounds(new Rectangle(34, 157, 270, 19));
        this.add(contsaleType, new KDLayout.Constraints(34, 157, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcustomer.setBounds(new Rectangle(321, 157, 270, 19));
        this.add(contcustomer, new KDLayout.Constraints(321, 157, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contplanAverageQty.setBounds(new Rectangle(909, 157, 270, 19));
        this.add(contplanAverageQty, new KDLayout.Constraints(909, 157, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmerPhone.setBounds(new Rectangle(321, 91, 270, 19));
        this.add(contfarmerPhone, new KDLayout.Constraints(321, 91, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbreedData.setBounds(new Rectangle(909, 58, 270, 19));
        this.add(contbreedData, new KDLayout.Constraints(909, 58, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpurType.setBounds(new Rectangle(615, 223, 270, 19));
        this.add(contpurType, new KDLayout.Constraints(615, 223, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmileage.setBounds(new Rectangle(909, 190, 270, 19));
        this.add(contmileage, new KDLayout.Constraints(909, 190, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdeliverQty.setBounds(new Rectangle(615, 157, 270, 19));
        this.add(contdeliverQty, new KDLayout.Constraints(615, 157, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisHasPQGB.setBounds(new Rectangle(615, 289, 270, 19));
        this.add(chkisHasPQGB, new KDLayout.Constraints(615, 289, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcar.setBounds(new Rectangle(34, 190, 270, 19));
        this.add(contcar, new KDLayout.Constraints(34, 190, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdriver.setBounds(new Rectangle(321, 190, 270, 19));
        this.add(contdriver, new KDLayout.Constraints(321, 190, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdriverPhone.setBounds(new Rectangle(615, 190, 270, 19));
        this.add(contdriverPhone, new KDLayout.Constraints(615, 190, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contarriveTime.setBounds(new Rectangle(34, 223, 270, 19));
        this.add(contarriveTime, new KDLayout.Constraints(34, 223, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contseq.setBounds(new Rectangle(321, 223, 270, 19));
        this.add(contseq, new KDLayout.Constraints(321, 223, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoutSalePrice.setBounds(new Rectangle(909, 223, 270, 19));
        this.add(contoutSalePrice, new KDLayout.Constraints(909, 223, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contseedSource.setBounds(new Rectangle(34, 256, 1147, 19));
        this.add(contseedSource, new KDLayout.Constraints(34, 256, 1147, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntry.setBounds(new Rectangle(35, 316, 1148, 192));
        kdtEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntry,new com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillEntryInfo(),null,false);
        this.add(kdtEntry_detailPanel, new KDLayout.Constraints(35, 316, 1148, 192, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //contplanAverageQty
        contplanAverageQty.setBoundEditor(txtplanAverageQty);
        //contfarmerPhone
        contfarmerPhone.setBoundEditor(txtfarmerPhone);
        //contbreedData
        contbreedData.setBoundEditor(prmtbreedData);
        //contpurType
        contpurType.setBoundEditor(purType);
        //contmileage
        contmileage.setBoundEditor(txtmileage);
        //contdeliverQty
        contdeliverQty.setBoundEditor(txtdeliverQty);
        //contcar
        contcar.setBoundEditor(prmtcar);
        //contdriver
        contdriver.setBoundEditor(prmtdriver);
        //contdriverPhone
        contdriverPhone.setBoundEditor(txtdriverPhone);
        //contarriveTime
        contarriveTime.setBoundEditor(pkarriveTime);
        //contseq
        contseq.setBoundEditor(txtseq);
        //contoutSalePrice
        contoutSalePrice.setBoundEditor(txtoutSalePrice);
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
		dataBinder.registerBinding("isHasPQGB", boolean.class, this.chkisHasPQGB, "selected");
		dataBinder.registerBinding("Entry.seq", int.class, this.kdtEntry, "seq.text");
		dataBinder.registerBinding("Entry", com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillEntryInfo.class, this.kdtEntry, "userObject");
		dataBinder.registerBinding("Entry.farmer", java.lang.Object.class, this.kdtEntry, "farmer.text");
		dataBinder.registerBinding("Entry.farm", java.lang.Object.class, this.kdtEntry, "farm.text");
		dataBinder.registerBinding("Entry.farmAddress", String.class, this.kdtEntry, "farmAddress.text");
		dataBinder.registerBinding("Entry.farmerTele", String.class, this.kdtEntry, "farmerTele.text");
		dataBinder.registerBinding("Entry.batch", java.lang.Object.class, this.kdtEntry, "batch.text");
		dataBinder.registerBinding("Entry.inDate", java.util.Date.class, this.kdtEntry, "inDate.text");
		dataBinder.registerBinding("Entry.inQty", java.math.BigDecimal.class, this.kdtEntry, "inQty.text");
		dataBinder.registerBinding("Entry.days", int.class, this.kdtEntry, "days.text");
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
		dataBinder.registerBinding("planAverageQty", java.math.BigDecimal.class, this.txtplanAverageQty, "value");
		dataBinder.registerBinding("farmerPhone", String.class, this.txtfarmerPhone, "text");
		dataBinder.registerBinding("breedData", com.kingdee.eas.farm.stocking.basedata.BreedDataInfo.class, this.prmtbreedData, "data");
		dataBinder.registerBinding("purType", com.kingdee.eas.farm.carnivorous.recyclebiz.PurType.class, this.purType, "selectedItem");
		dataBinder.registerBinding("mileage", java.math.BigDecimal.class, this.txtmileage, "value");
		dataBinder.registerBinding("deliverQty", int.class, this.txtdeliverQty, "value");
		dataBinder.registerBinding("car", com.kingdee.eas.publicdata.CarInfo.class, this.prmtcar, "data");
		dataBinder.registerBinding("driver", com.kingdee.eas.farm.feemanager.basedata.DriverInfo.class, this.prmtdriver, "data");
		dataBinder.registerBinding("driverPhone", String.class, this.txtdriverPhone, "text");
		dataBinder.registerBinding("arriveTime", java.util.Date.class, this.pkarriveTime, "value");
		dataBinder.registerBinding("seq", int.class, this.txtseq, "value");
		dataBinder.registerBinding("outSalePrice", java.math.BigDecimal.class, this.txtoutSalePrice, "value");
		dataBinder.registerBinding("seedSource", String.class, this.txtseedSource, "text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.carnivorous.recyclebiz.app.CCarSendBillEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillInfo)ov;
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
		getValidateHelper().registerBindProperty("isHasPQGB", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.farmAddress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.farmerTele", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.batch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.inDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.inQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.days", ValidateHelper.ON_SAVE);    
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
		getValidateHelper().registerBindProperty("planAverageQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmerPhone", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedData", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("purType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mileage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("deliverQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("car", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("driver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("driverPhone", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("arriveTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("outSalePrice", ValidateHelper.ON_SAVE);    
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
        sic.add(new SelectorItemInfo("isHasPQGB"));
    	sic.add(new SelectorItemInfo("Entry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.farmer.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entry.farmer.id"));
			sic.add(new SelectorItemInfo("Entry.farmer.name"));
        	sic.add(new SelectorItemInfo("Entry.farmer.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.farm.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entry.farm.id"));
			sic.add(new SelectorItemInfo("Entry.farm.name"));
        	sic.add(new SelectorItemInfo("Entry.farm.number"));
		}
    	sic.add(new SelectorItemInfo("Entry.farmAddress"));
    	sic.add(new SelectorItemInfo("Entry.farmerTele"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.batch.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entry.batch.id"));
			sic.add(new SelectorItemInfo("Entry.batch.name"));
        	sic.add(new SelectorItemInfo("Entry.batch.number"));
		}
    	sic.add(new SelectorItemInfo("Entry.inDate"));
    	sic.add(new SelectorItemInfo("Entry.inQty"));
    	sic.add(new SelectorItemInfo("Entry.days"));
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
        sic.add(new SelectorItemInfo("planAverageQty"));
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
        sic.add(new SelectorItemInfo("purType"));
        sic.add(new SelectorItemInfo("mileage"));
        sic.add(new SelectorItemInfo("deliverQty"));
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
        sic.add(new SelectorItemInfo("arriveTime"));
        sic.add(new SelectorItemInfo("seq"));
        sic.add(new SelectorItemInfo("outSalePrice"));
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
        com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractCCarSendBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractCCarSendBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.recyclebiz.client", "CCarSendBillEditUI");
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
        return com.kingdee.eas.farm.carnivorous.recyclebiz.client.CCarSendBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillInfo();
				if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")).getBoolean("isBizUnit"))
			objectValue.put("FICompany",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")));
 
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/carnivorous/recyclebiz/CCarSendBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.carnivorous.recyclebiz.app.CCarSendBillQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtNumber.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"单据编号"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(saleType.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"销售类型"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtEntry;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("billStatus",new Integer(-1));
vo.put("farmType","0");
vo.put("saleType","0");
vo.put("purType","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}