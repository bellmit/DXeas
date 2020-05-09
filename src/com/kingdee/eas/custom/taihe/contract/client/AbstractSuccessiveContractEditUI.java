/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.contract.client;

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
public abstract class AbstractSuccessiveContractEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSuccessiveContractEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontractType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbeginDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contendDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsuccessiveQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpartyBCell;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpartyBAddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpartyBID;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpartyBBank;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpartyBBankNo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contheader;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contheaderCell;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcapacity;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdays;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdiffDays;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contintervalDays;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcloseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcloseTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtremark;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contSupplier;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contupSeedingDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contupSeedingQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsettlePolicy;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcontractType;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkbeginDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkendDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsuccessiveQty;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpartyBCell;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpartyBAddress;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpartyBID;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpartyBBank;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpartyBBankNo;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtheader;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtheaderCell;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcapacity;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdays;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdiffDays;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtintervalDays;
    protected com.kingdee.bos.ctrl.swing.KDComboBox closeStatus;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkcloseTime;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtSupplier;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkupSeedingDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtupSeedingQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarm;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsettlePolicy;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnBalanceBond;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnViewOtherContract;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.custom.taihe.contract.SuccessiveContractInfo editData = null;
    protected ActionBalanceBond actionBalanceBond = null;
    protected ActionViewOtherContract actionViewOtherContract = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractSuccessiveContractEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractSuccessiveContractEditUI.class.getName());
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
        //actionBalanceBond
        this.actionBalanceBond = new ActionBalanceBond(this);
        getActionManager().registerAction("actionBalanceBond", actionBalanceBond);
        this.actionBalanceBond.setExtendProperty("canForewarn", "true");
        this.actionBalanceBond.setExtendProperty("userDefined", "true");
        this.actionBalanceBond.setExtendProperty("isObjectUpdateLock", "false");
         this.actionBalanceBond.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionBalanceBond.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionViewOtherContract
        this.actionViewOtherContract = new ActionViewOtherContract(this);
        getActionManager().registerAction("actionViewOtherContract", actionViewOtherContract);
        this.actionViewOtherContract.setExtendProperty("canForewarn", "true");
        this.actionViewOtherContract.setExtendProperty("userDefined", "true");
        this.actionViewOtherContract.setExtendProperty("isObjectUpdateLock", "false");
         this.actionViewOtherContract.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionViewOtherContract.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionAudit
        this.actionAudit = new ActionAudit(this);
        getActionManager().registerAction("actionAudit", actionAudit);
        this.actionAudit.setBindWorkFlow(true);
        this.actionAudit.setExtendProperty("canForewarn", "true");
        this.actionAudit.setExtendProperty("userDefined", "false");
        this.actionAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
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
        this.contcontractType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbeginDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contendDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsuccessiveQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpartyBCell = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpartyBAddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpartyBID = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpartyBBank = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpartyBBankNo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contheader = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contheaderCell = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcapacity = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdays = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdiffDays = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contintervalDays = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcloseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcloseTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtremark = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contSupplier = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contupSeedingDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contupSeedingQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsettlePolicy = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcontractType = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkbeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkendDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtsuccessiveQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpartyBCell = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtpartyBAddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtpartyBID = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtpartyBBank = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtpartyBBankNo = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtheader = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtheaderCell = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcapacity = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdays = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdiffDays = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtintervalDays = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.closeStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.pkcloseTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtSupplier = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkupSeedingDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtupSeedingQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtfarmer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtfarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtsettlePolicy = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.btnBalanceBond = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnViewOtherContract = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contAuditor.setName("contAuditor");
        this.contcontractType.setName("contcontractType");
        this.contbeginDate.setName("contbeginDate");
        this.contendDate.setName("contendDate");
        this.contsuccessiveQty.setName("contsuccessiveQty");
        this.contpartyBCell.setName("contpartyBCell");
        this.contpartyBAddress.setName("contpartyBAddress");
        this.contpartyBID.setName("contpartyBID");
        this.contpartyBBank.setName("contpartyBBank");
        this.contpartyBBankNo.setName("contpartyBBankNo");
        this.contheader.setName("contheader");
        this.contheaderCell.setName("contheaderCell");
        this.contcapacity.setName("contcapacity");
        this.contdays.setName("contdays");
        this.contdiffDays.setName("contdiffDays");
        this.contintervalDays.setName("contintervalDays");
        this.contcloseStatus.setName("contcloseStatus");
        this.contcloseTime.setName("contcloseTime");
        this.contbillStatus.setName("contbillStatus");
        this.contauditTime.setName("contauditTime");
        this.txtremark.setName("txtremark");
        this.contcompany.setName("contcompany");
        this.contSupplier.setName("contSupplier");
        this.contupSeedingDate.setName("contupSeedingDate");
        this.contupSeedingQty.setName("contupSeedingQty");
        this.contfarmer.setName("contfarmer");
        this.contfarm.setName("contfarm");
        this.contsettlePolicy.setName("contsettlePolicy");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtcontractType.setName("prmtcontractType");
        this.pkbeginDate.setName("pkbeginDate");
        this.pkendDate.setName("pkendDate");
        this.txtsuccessiveQty.setName("txtsuccessiveQty");
        this.txtpartyBCell.setName("txtpartyBCell");
        this.txtpartyBAddress.setName("txtpartyBAddress");
        this.txtpartyBID.setName("txtpartyBID");
        this.txtpartyBBank.setName("txtpartyBBank");
        this.txtpartyBBankNo.setName("txtpartyBBankNo");
        this.txtheader.setName("txtheader");
        this.txtheaderCell.setName("txtheaderCell");
        this.txtcapacity.setName("txtcapacity");
        this.txtdays.setName("txtdays");
        this.txtdiffDays.setName("txtdiffDays");
        this.txtintervalDays.setName("txtintervalDays");
        this.closeStatus.setName("closeStatus");
        this.pkcloseTime.setName("pkcloseTime");
        this.billStatus.setName("billStatus");
        this.pkauditTime.setName("pkauditTime");
        this.prmtcompany.setName("prmtcompany");
        this.prmtSupplier.setName("prmtSupplier");
        this.pkupSeedingDate.setName("pkupSeedingDate");
        this.txtupSeedingQty.setName("txtupSeedingQty");
        this.prmtfarmer.setName("prmtfarmer");
        this.prmtfarm.setName("prmtfarm");
        this.prmtsettlePolicy.setName("prmtsettlePolicy");
        this.btnBalanceBond.setName("btnBalanceBond");
        this.btnViewOtherContract.setName("btnViewOtherContract");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
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
        // contcontractType		
        this.contcontractType.setBoundLabelText(resHelper.getString("contcontractType.boundLabelText"));		
        this.contcontractType.setBoundLabelLength(100);		
        this.contcontractType.setBoundLabelUnderline(true);		
        this.contcontractType.setVisible(true);
        // contbeginDate		
        this.contbeginDate.setBoundLabelText(resHelper.getString("contbeginDate.boundLabelText"));		
        this.contbeginDate.setBoundLabelLength(100);		
        this.contbeginDate.setBoundLabelUnderline(true);		
        this.contbeginDate.setVisible(true);
        // contendDate		
        this.contendDate.setBoundLabelText(resHelper.getString("contendDate.boundLabelText"));		
        this.contendDate.setBoundLabelLength(100);		
        this.contendDate.setBoundLabelUnderline(true);		
        this.contendDate.setVisible(true);
        // contsuccessiveQty		
        this.contsuccessiveQty.setBoundLabelText(resHelper.getString("contsuccessiveQty.boundLabelText"));		
        this.contsuccessiveQty.setBoundLabelLength(100);		
        this.contsuccessiveQty.setBoundLabelUnderline(true);		
        this.contsuccessiveQty.setVisible(true);
        // contpartyBCell		
        this.contpartyBCell.setBoundLabelText(resHelper.getString("contpartyBCell.boundLabelText"));		
        this.contpartyBCell.setBoundLabelLength(100);		
        this.contpartyBCell.setBoundLabelUnderline(true);		
        this.contpartyBCell.setVisible(false);
        // contpartyBAddress		
        this.contpartyBAddress.setBoundLabelText(resHelper.getString("contpartyBAddress.boundLabelText"));		
        this.contpartyBAddress.setBoundLabelLength(100);		
        this.contpartyBAddress.setBoundLabelUnderline(true);		
        this.contpartyBAddress.setVisible(false);
        // contpartyBID		
        this.contpartyBID.setBoundLabelText(resHelper.getString("contpartyBID.boundLabelText"));		
        this.contpartyBID.setBoundLabelLength(100);		
        this.contpartyBID.setBoundLabelUnderline(true);		
        this.contpartyBID.setVisible(false);
        // contpartyBBank		
        this.contpartyBBank.setBoundLabelText(resHelper.getString("contpartyBBank.boundLabelText"));		
        this.contpartyBBank.setBoundLabelLength(100);		
        this.contpartyBBank.setBoundLabelUnderline(true);		
        this.contpartyBBank.setVisible(false);
        // contpartyBBankNo		
        this.contpartyBBankNo.setBoundLabelText(resHelper.getString("contpartyBBankNo.boundLabelText"));		
        this.contpartyBBankNo.setBoundLabelLength(100);		
        this.contpartyBBankNo.setBoundLabelUnderline(true);		
        this.contpartyBBankNo.setVisible(false);
        // contheader		
        this.contheader.setBoundLabelText(resHelper.getString("contheader.boundLabelText"));		
        this.contheader.setBoundLabelLength(100);		
        this.contheader.setBoundLabelUnderline(true);		
        this.contheader.setVisible(false);
        // contheaderCell		
        this.contheaderCell.setBoundLabelText(resHelper.getString("contheaderCell.boundLabelText"));		
        this.contheaderCell.setBoundLabelLength(100);		
        this.contheaderCell.setBoundLabelUnderline(true);		
        this.contheaderCell.setVisible(false);
        // contcapacity		
        this.contcapacity.setBoundLabelText(resHelper.getString("contcapacity.boundLabelText"));		
        this.contcapacity.setBoundLabelLength(100);		
        this.contcapacity.setBoundLabelUnderline(true);		
        this.contcapacity.setVisible(true);
        // contdays		
        this.contdays.setBoundLabelText(resHelper.getString("contdays.boundLabelText"));		
        this.contdays.setBoundLabelLength(100);		
        this.contdays.setBoundLabelUnderline(true);		
        this.contdays.setVisible(true);
        // contdiffDays		
        this.contdiffDays.setBoundLabelText(resHelper.getString("contdiffDays.boundLabelText"));		
        this.contdiffDays.setBoundLabelLength(100);		
        this.contdiffDays.setBoundLabelUnderline(true);		
        this.contdiffDays.setVisible(true);
        // contintervalDays		
        this.contintervalDays.setBoundLabelText(resHelper.getString("contintervalDays.boundLabelText"));		
        this.contintervalDays.setBoundLabelLength(100);		
        this.contintervalDays.setBoundLabelUnderline(true);		
        this.contintervalDays.setVisible(true);
        // contcloseStatus		
        this.contcloseStatus.setBoundLabelText(resHelper.getString("contcloseStatus.boundLabelText"));		
        this.contcloseStatus.setBoundLabelLength(100);		
        this.contcloseStatus.setBoundLabelUnderline(true);		
        this.contcloseStatus.setVisible(true);
        // contcloseTime		
        this.contcloseTime.setBoundLabelText(resHelper.getString("contcloseTime.boundLabelText"));		
        this.contcloseTime.setBoundLabelLength(100);		
        this.contcloseTime.setBoundLabelUnderline(true);		
        this.contcloseTime.setVisible(true);
        // contbillStatus		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // txtremark		
        this.txtremark.setVisible(true);		
        this.txtremark.setRequired(false);		
        this.txtremark.setMaxLength(255);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contSupplier		
        this.contSupplier.setBoundLabelText(resHelper.getString("contSupplier.boundLabelText"));		
        this.contSupplier.setBoundLabelLength(100);		
        this.contSupplier.setBoundLabelUnderline(true);		
        this.contSupplier.setVisible(false);
        // contupSeedingDate		
        this.contupSeedingDate.setBoundLabelText(resHelper.getString("contupSeedingDate.boundLabelText"));		
        this.contupSeedingDate.setBoundLabelLength(100);		
        this.contupSeedingDate.setBoundLabelUnderline(true);		
        this.contupSeedingDate.setVisible(true);
        // contupSeedingQty		
        this.contupSeedingQty.setBoundLabelText(resHelper.getString("contupSeedingQty.boundLabelText"));		
        this.contupSeedingQty.setBoundLabelLength(100);		
        this.contupSeedingQty.setBoundLabelUnderline(true);		
        this.contupSeedingQty.setVisible(true);
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
        // contsettlePolicy		
        this.contsettlePolicy.setBoundLabelText(resHelper.getString("contsettlePolicy.boundLabelText"));		
        this.contsettlePolicy.setBoundLabelLength(100);		
        this.contsettlePolicy.setBoundLabelUnderline(true);		
        this.contsettlePolicy.setVisible(true);
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
        // prmtcontractType		
        this.prmtcontractType.setQueryInfo("com.kingdee.eas.custom.signwasthetable.app.ContractTypeQuery");		
        this.prmtcontractType.setVisible(true);		
        this.prmtcontractType.setEditable(true);		
        this.prmtcontractType.setDisplayFormat("$name$");		
        this.prmtcontractType.setEditFormat("$number$");		
        this.prmtcontractType.setCommitFormat("$number$");		
        this.prmtcontractType.setRequired(false);
        // pkbeginDate		
        this.pkbeginDate.setVisible(true);		
        this.pkbeginDate.setRequired(false);
        // pkendDate		
        this.pkendDate.setVisible(true);		
        this.pkendDate.setRequired(false);
        // txtsuccessiveQty		
        this.txtsuccessiveQty.setVisible(true);		
        this.txtsuccessiveQty.setHorizontalAlignment(2);		
        this.txtsuccessiveQty.setDataType(0);		
        this.txtsuccessiveQty.setSupportedEmpty(true);		
        this.txtsuccessiveQty.setRequired(false);
        // txtpartyBCell		
        this.txtpartyBCell.setVisible(false);		
        this.txtpartyBCell.setHorizontalAlignment(2);		
        this.txtpartyBCell.setMaxLength(100);		
        this.txtpartyBCell.setRequired(false);
        // txtpartyBAddress		
        this.txtpartyBAddress.setVisible(false);		
        this.txtpartyBAddress.setHorizontalAlignment(2);		
        this.txtpartyBAddress.setMaxLength(100);		
        this.txtpartyBAddress.setRequired(false);
        // txtpartyBID		
        this.txtpartyBID.setVisible(false);		
        this.txtpartyBID.setHorizontalAlignment(2);		
        this.txtpartyBID.setMaxLength(100);		
        this.txtpartyBID.setRequired(false);
        // txtpartyBBank		
        this.txtpartyBBank.setVisible(false);		
        this.txtpartyBBank.setHorizontalAlignment(2);		
        this.txtpartyBBank.setMaxLength(100);		
        this.txtpartyBBank.setRequired(false);
        // txtpartyBBankNo		
        this.txtpartyBBankNo.setVisible(false);		
        this.txtpartyBBankNo.setHorizontalAlignment(2);		
        this.txtpartyBBankNo.setMaxLength(100);		
        this.txtpartyBBankNo.setRequired(false);
        // txtheader		
        this.txtheader.setVisible(false);		
        this.txtheader.setHorizontalAlignment(2);		
        this.txtheader.setMaxLength(80);		
        this.txtheader.setRequired(false);
        // txtheaderCell		
        this.txtheaderCell.setVisible(false);		
        this.txtheaderCell.setHorizontalAlignment(2);		
        this.txtheaderCell.setMaxLength(100);		
        this.txtheaderCell.setRequired(false);
        // txtcapacity		
        this.txtcapacity.setVisible(true);		
        this.txtcapacity.setHorizontalAlignment(2);		
        this.txtcapacity.setDataType(1);		
        this.txtcapacity.setSupportedEmpty(true);		
        this.txtcapacity.setMinimumValue( new java.math.BigDecimal("-3.4028234663852886E38"));		
        this.txtcapacity.setMaximumValue( new java.math.BigDecimal("3.4028234663852886E38"));		
        this.txtcapacity.setPrecision(10);		
        this.txtcapacity.setRequired(false);
        // txtdays		
        this.txtdays.setVisible(true);		
        this.txtdays.setHorizontalAlignment(2);		
        this.txtdays.setDataType(0);		
        this.txtdays.setSupportedEmpty(true);		
        this.txtdays.setRequired(false);
        // txtdiffDays		
        this.txtdiffDays.setVisible(true);		
        this.txtdiffDays.setHorizontalAlignment(2);		
        this.txtdiffDays.setDataType(0);		
        this.txtdiffDays.setSupportedEmpty(true);		
        this.txtdiffDays.setRequired(false);
        // txtintervalDays		
        this.txtintervalDays.setVisible(true);		
        this.txtintervalDays.setHorizontalAlignment(2);		
        this.txtintervalDays.setDataType(0);		
        this.txtintervalDays.setSupportedEmpty(true);		
        this.txtintervalDays.setRequired(false);
        // closeStatus		
        this.closeStatus.setVisible(true);		
        this.closeStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.taihe.contract.CloseStatus").toArray());		
        this.closeStatus.setRequired(false);
        // pkcloseTime		
        this.pkcloseTime.setVisible(true);		
        this.pkcloseTime.setRequired(false);
        // billStatus		
        this.billStatus.setVisible(true);		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // pkauditTime		
        this.pkauditTime.setVisible(true);		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setVisible(true);		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
        // prmtSupplier		
        this.prmtSupplier.setQueryInfo("com.kingdee.eas.bdm.bdapply.app.SupplierReqQuery");		
        this.prmtSupplier.setVisible(false);		
        this.prmtSupplier.setEditable(true);		
        this.prmtSupplier.setDisplayFormat("$name$");		
        this.prmtSupplier.setEditFormat("$number$");		
        this.prmtSupplier.setCommitFormat("$number$");		
        this.prmtSupplier.setRequired(false);
        // pkupSeedingDate		
        this.pkupSeedingDate.setVisible(true);		
        this.pkupSeedingDate.setRequired(false);
        // txtupSeedingQty		
        this.txtupSeedingQty.setVisible(true);		
        this.txtupSeedingQty.setHorizontalAlignment(2);		
        this.txtupSeedingQty.setDataType(1);		
        this.txtupSeedingQty.setSupportedEmpty(true);		
        this.txtupSeedingQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtupSeedingQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtupSeedingQty.setPrecision(4);		
        this.txtupSeedingQty.setRequired(false);
        // prmtfarmer		
        this.prmtfarmer.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerQuery");		
        this.prmtfarmer.setVisible(true);		
        this.prmtfarmer.setEditable(true);		
        this.prmtfarmer.setDisplayFormat("$name$");		
        this.prmtfarmer.setEditFormat("$number$");		
        this.prmtfarmer.setCommitFormat("$number$");		
        this.prmtfarmer.setRequired(false);
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
        this.prmtfarm.setRequired(false);
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
					
        // prmtsettlePolicy		
        this.prmtsettlePolicy.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.SettlePolicyQuery");		
        this.prmtsettlePolicy.setVisible(true);		
        this.prmtsettlePolicy.setEditable(true);		
        this.prmtsettlePolicy.setDisplayFormat("$name$");		
        this.prmtsettlePolicy.setEditFormat("$number$");		
        this.prmtsettlePolicy.setCommitFormat("$number$");		
        this.prmtsettlePolicy.setRequired(false);
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
					
        // btnBalanceBond
        this.btnBalanceBond.setAction((IItemAction)ActionProxyFactory.getProxy(actionBalanceBond, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnBalanceBond.setText(resHelper.getString("btnBalanceBond.text"));
        // btnViewOtherContract
        this.btnViewOtherContract.setAction((IItemAction)ActionProxyFactory.getProxy(actionViewOtherContract, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnViewOtherContract.setText(resHelper.getString("btnViewOtherContract.text"));
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtcontractType,pkbeginDate,pkendDate,txtsuccessiveQty,txtpartyBCell,txtpartyBAddress,txtpartyBID,txtpartyBBank,txtpartyBBankNo,txtheader,txtheaderCell,txtcapacity,txtdays,txtdiffDays,txtintervalDays,closeStatus,pkcloseTime,billStatus,pkauditTime,txtremark,prmtcompany,prmtSupplier,pkupSeedingDate,txtupSeedingQty,prmtfarmer,prmtfarm,prmtsettlePolicy}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 553));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1013, 553));
        contCreator.setBounds(new Rectangle(369, 462, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(369, 462, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(719, 462, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(719, 462, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(369, 493, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(369, 493, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(719, 493, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(719, 493, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(22, 32, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(22, 32, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(369, 32, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(369, 32, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(20, 466, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(20, 466, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcontractType.setBounds(new Rectangle(719, 32, 270, 19));
        this.add(contcontractType, new KDLayout.Constraints(719, 32, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbeginDate.setBounds(new Rectangle(22, 73, 270, 19));
        this.add(contbeginDate, new KDLayout.Constraints(22, 73, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contendDate.setBounds(new Rectangle(369, 73, 270, 19));
        this.add(contendDate, new KDLayout.Constraints(369, 73, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsuccessiveQty.setBounds(new Rectangle(369, 159, 270, 19));
        this.add(contsuccessiveQty, new KDLayout.Constraints(369, 159, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpartyBCell.setBounds(new Rectangle(9, 329, 270, 19));
        this.add(contpartyBCell, new KDLayout.Constraints(9, 329, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpartyBAddress.setBounds(new Rectangle(9, 329, 270, 19));
        this.add(contpartyBAddress, new KDLayout.Constraints(9, 329, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contpartyBID.setBounds(new Rectangle(9, 329, 270, 19));
        this.add(contpartyBID, new KDLayout.Constraints(9, 329, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpartyBBank.setBounds(new Rectangle(9, 329, 270, 19));
        this.add(contpartyBBank, new KDLayout.Constraints(9, 329, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpartyBBankNo.setBounds(new Rectangle(9, 329, 270, 19));
        this.add(contpartyBBankNo, new KDLayout.Constraints(9, 329, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contheader.setBounds(new Rectangle(9, 329, 270, 19));
        this.add(contheader, new KDLayout.Constraints(9, 329, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contheaderCell.setBounds(new Rectangle(9, 329, 270, 19));
        this.add(contheaderCell, new KDLayout.Constraints(9, 329, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcapacity.setBounds(new Rectangle(22, 159, 270, 19));
        this.add(contcapacity, new KDLayout.Constraints(22, 159, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdays.setBounds(new Rectangle(369, 118, 270, 19));
        this.add(contdays, new KDLayout.Constraints(369, 118, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdiffDays.setBounds(new Rectangle(719, 118, 270, 19));
        this.add(contdiffDays, new KDLayout.Constraints(719, 118, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contintervalDays.setBounds(new Rectangle(22, 200, 270, 19));
        this.add(contintervalDays, new KDLayout.Constraints(22, 200, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcloseStatus.setBounds(new Rectangle(22, 242, 270, 19));
        this.add(contcloseStatus, new KDLayout.Constraints(22, 242, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcloseTime.setBounds(new Rectangle(369, 200, 270, 19));
        this.add(contcloseTime, new KDLayout.Constraints(369, 200, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(719, 200, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(719, 200, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contauditTime.setBounds(new Rectangle(20, 493, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(20, 493, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        txtremark.setBounds(new Rectangle(22, 316, 969, 126));
        this.add(txtremark, new KDLayout.Constraints(22, 316, 969, 126, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompany.setBounds(new Rectangle(22, 274, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(22, 274, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contSupplier.setBounds(new Rectangle(9, 329, 270, 19));
        this.add(contSupplier, new KDLayout.Constraints(9, 329, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contupSeedingDate.setBounds(new Rectangle(369, 242, 270, 19));
        this.add(contupSeedingDate, new KDLayout.Constraints(369, 242, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contupSeedingQty.setBounds(new Rectangle(719, 242, 270, 19));
        this.add(contupSeedingQty, new KDLayout.Constraints(719, 242, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfarmer.setBounds(new Rectangle(719, 73, 270, 19));
        this.add(contfarmer, new KDLayout.Constraints(719, 73, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfarm.setBounds(new Rectangle(22, 118, 270, 19));
        this.add(contfarm, new KDLayout.Constraints(22, 118, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsettlePolicy.setBounds(new Rectangle(719, 160, 270, 19));
        this.add(contsettlePolicy, new KDLayout.Constraints(719, 160, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //contcontractType
        contcontractType.setBoundEditor(prmtcontractType);
        //contbeginDate
        contbeginDate.setBoundEditor(pkbeginDate);
        //contendDate
        contendDate.setBoundEditor(pkendDate);
        //contsuccessiveQty
        contsuccessiveQty.setBoundEditor(txtsuccessiveQty);
        //contpartyBCell
        contpartyBCell.setBoundEditor(txtpartyBCell);
        //contpartyBAddress
        contpartyBAddress.setBoundEditor(txtpartyBAddress);
        //contpartyBID
        contpartyBID.setBoundEditor(txtpartyBID);
        //contpartyBBank
        contpartyBBank.setBoundEditor(txtpartyBBank);
        //contpartyBBankNo
        contpartyBBankNo.setBoundEditor(txtpartyBBankNo);
        //contheader
        contheader.setBoundEditor(txtheader);
        //contheaderCell
        contheaderCell.setBoundEditor(txtheaderCell);
        //contcapacity
        contcapacity.setBoundEditor(txtcapacity);
        //contdays
        contdays.setBoundEditor(txtdays);
        //contdiffDays
        contdiffDays.setBoundEditor(txtdiffDays);
        //contintervalDays
        contintervalDays.setBoundEditor(txtintervalDays);
        //contcloseStatus
        contcloseStatus.setBoundEditor(closeStatus);
        //contcloseTime
        contcloseTime.setBoundEditor(pkcloseTime);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contSupplier
        contSupplier.setBoundEditor(prmtSupplier);
        //contupSeedingDate
        contupSeedingDate.setBoundEditor(pkupSeedingDate);
        //contupSeedingQty
        contupSeedingQty.setBoundEditor(txtupSeedingQty);
        //contfarmer
        contfarmer.setBoundEditor(prmtfarmer);
        //contfarm
        contfarm.setBoundEditor(prmtfarm);
        //contsettlePolicy
        contsettlePolicy.setBoundEditor(prmtsettlePolicy);

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
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);
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
        this.toolBar.add(btnPCVoucher);
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnDelPCVoucher);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(btnNextPerson);
        this.toolBar.add(btnBalanceBond);
        this.toolBar.add(btnViewOtherContract);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("remark", String.class, this.txtremark, "text");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("contractType", com.kingdee.eas.custom.signwasthetable.ContractTypeInfo.class, this.prmtcontractType, "data");
		dataBinder.registerBinding("beginDate", java.util.Date.class, this.pkbeginDate, "value");
		dataBinder.registerBinding("endDate", java.util.Date.class, this.pkendDate, "value");
		dataBinder.registerBinding("successiveQty", int.class, this.txtsuccessiveQty, "value");
		dataBinder.registerBinding("partyBCell", String.class, this.txtpartyBCell, "text");
		dataBinder.registerBinding("partyBAddress", String.class, this.txtpartyBAddress, "text");
		dataBinder.registerBinding("partyBID", String.class, this.txtpartyBID, "text");
		dataBinder.registerBinding("partyBBank", String.class, this.txtpartyBBank, "text");
		dataBinder.registerBinding("partyBBankNo", String.class, this.txtpartyBBankNo, "text");
		dataBinder.registerBinding("header", String.class, this.txtheader, "text");
		dataBinder.registerBinding("headerCell", String.class, this.txtheaderCell, "text");
		dataBinder.registerBinding("capacity", java.math.BigDecimal.class, this.txtcapacity, "value");
		dataBinder.registerBinding("days", int.class, this.txtdays, "value");
		dataBinder.registerBinding("diffDays", int.class, this.txtdiffDays, "value");
		dataBinder.registerBinding("intervalDays", int.class, this.txtintervalDays, "value");
		dataBinder.registerBinding("closeStatus", com.kingdee.eas.custom.taihe.contract.CloseStatus.class, this.closeStatus, "selectedItem");
		dataBinder.registerBinding("closeTime", java.util.Date.class, this.pkcloseTime, "value");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("Supplier", com.kingdee.eas.bdm.bdapply.SupplierReqInfo.class, this.prmtSupplier, "data");
		dataBinder.registerBinding("upSeedingDate", java.util.Date.class, this.pkupSeedingDate, "value");
		dataBinder.registerBinding("upSeedingQty", java.math.BigDecimal.class, this.txtupSeedingQty, "value");
		dataBinder.registerBinding("farmer", com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo.class, this.prmtfarmer, "data");
		dataBinder.registerBinding("farm", com.kingdee.eas.farm.carnivorous.basedata.FarmInfo.class, this.prmtfarm, "data");
		dataBinder.registerBinding("settlePolicy", com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo.class, this.prmtsettlePolicy, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.taihe.contract.app.SuccessiveContractEditUIHandler";
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
        this.prmtcontractType.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.taihe.contract.SuccessiveContractInfo)ov;
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
		getValidateHelper().registerBindProperty("remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contractType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("beginDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("endDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("successiveQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("partyBCell", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("partyBAddress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("partyBID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("partyBBank", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("partyBBankNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("header", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("headerCell", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("capacity", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("days", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("diffDays", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("intervalDays", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("closeStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("closeTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Supplier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("upSeedingDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("upSeedingQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("settlePolicy", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("remark"));
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
			sic.add(new SelectorItemInfo("contractType.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("contractType.id"));
        	sic.add(new SelectorItemInfo("contractType.number"));
        	sic.add(new SelectorItemInfo("contractType.name"));
		}
        sic.add(new SelectorItemInfo("beginDate"));
        sic.add(new SelectorItemInfo("endDate"));
        sic.add(new SelectorItemInfo("successiveQty"));
        sic.add(new SelectorItemInfo("partyBCell"));
        sic.add(new SelectorItemInfo("partyBAddress"));
        sic.add(new SelectorItemInfo("partyBID"));
        sic.add(new SelectorItemInfo("partyBBank"));
        sic.add(new SelectorItemInfo("partyBBankNo"));
        sic.add(new SelectorItemInfo("header"));
        sic.add(new SelectorItemInfo("headerCell"));
        sic.add(new SelectorItemInfo("capacity"));
        sic.add(new SelectorItemInfo("days"));
        sic.add(new SelectorItemInfo("diffDays"));
        sic.add(new SelectorItemInfo("intervalDays"));
        sic.add(new SelectorItemInfo("closeStatus"));
        sic.add(new SelectorItemInfo("closeTime"));
        sic.add(new SelectorItemInfo("billStatus"));
        sic.add(new SelectorItemInfo("auditTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Supplier.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("Supplier.id"));
        	sic.add(new SelectorItemInfo("Supplier.number"));
        	sic.add(new SelectorItemInfo("Supplier.name"));
		}
        sic.add(new SelectorItemInfo("upSeedingDate"));
        sic.add(new SelectorItemInfo("upSeedingQty"));
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
			sic.add(new SelectorItemInfo("settlePolicy.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("settlePolicy.id"));
        	sic.add(new SelectorItemInfo("settlePolicy.number"));
        	sic.add(new SelectorItemInfo("settlePolicy.name"));
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
     * output actionBalanceBond_actionPerformed method
     */
    public void actionBalanceBond_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.taihe.contract.SuccessiveContractFactory.getRemoteInstance().balanceBond(editData);
    }
    	

    /**
     * output actionViewOtherContract_actionPerformed method
     */
    public void actionViewOtherContract_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.taihe.contract.SuccessiveContractFactory.getRemoteInstance().viewOtherContract(editData);
    }
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.taihe.contract.SuccessiveContractFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.taihe.contract.SuccessiveContractFactory.getRemoteInstance().unAudit(editData);
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
	public RequestContext prepareActionBalanceBond(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionBalanceBond() {
    	return false;
    }
	public RequestContext prepareActionViewOtherContract(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionViewOtherContract() {
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
     * output ActionBalanceBond class
     */     
    protected class ActionBalanceBond extends ItemAction {     
    
        public ActionBalanceBond()
        {
            this(null);
        }

        public ActionBalanceBond(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionBalanceBond.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionBalanceBond.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionBalanceBond.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractSuccessiveContractEditUI.this, "ActionBalanceBond", "actionBalanceBond_actionPerformed", e);
        }
    }

    /**
     * output ActionViewOtherContract class
     */     
    protected class ActionViewOtherContract extends ItemAction {     
    
        public ActionViewOtherContract()
        {
            this(null);
        }

        public ActionViewOtherContract(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionViewOtherContract.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionViewOtherContract.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionViewOtherContract.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractSuccessiveContractEditUI.this, "ActionViewOtherContract", "actionViewOtherContract_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractSuccessiveContractEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractSuccessiveContractEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.taihe.contract.client", "SuccessiveContractEditUI");
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
        return com.kingdee.eas.custom.taihe.contract.client.SuccessiveContractEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.taihe.contract.SuccessiveContractFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.taihe.contract.SuccessiveContractInfo objectValue = new com.kingdee.eas.custom.taihe.contract.SuccessiveContractInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/taihe/contract/SuccessiveContract";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.taihe.contract.app.SuccessiveContractQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtNumber.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"单据编号"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"公司"});
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
		vo.put("closeStatus","0");
vo.put("billStatus",new Integer(-1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}