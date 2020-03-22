/**
 * output package name
 */
package com.kingdee.eas.custom.dx.weight.client;

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
public abstract class AbstractSettleReEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSettleReEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdriver;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcar;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCarSend;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcarNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenZYWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenSZWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenPYWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contFaecesPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contGrossPrice;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtdriver;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcar;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCarSend;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDeductionZY;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDeductionPY;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDeductionSZ;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDeductionKF;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDeductionKSS;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtDeductionZY;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtDeductionPY;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtDeductionSZ;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtDeductionKF;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtDeductionKSS;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contQCWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contChickenSet;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contGrossQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contGrossWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contSmChickenQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contSmChickenWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCriChickenQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCriChickenWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contQCQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contGrossSumQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contSetAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtQCWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtChickenSet;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtGrossQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtGrossWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtSmChickenQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtSmChickenWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtCriChickenQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtCriChickenWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtQCQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtGrossSumQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtSetAmount;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcarNum;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickenZYWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickenSZWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickenPYWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtFaecesPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtGrossPrice;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton audit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton unaudit;
    protected com.kingdee.eas.custom.dx.weight.SettleReInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractSettleReEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractSettleReEditUI.class.getName());
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
        this.actionAudit.setExtendProperty("userDefined", "true");
        this.actionAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionUnAudit
        this.actionUnAudit = new ActionUnAudit(this);
        getActionManager().registerAction("actionUnAudit", actionUnAudit);
        this.actionUnAudit.setExtendProperty("canForewarn", "true");
        this.actionUnAudit.setExtendProperty("userDefined", "true");
        this.actionUnAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdriver = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcar = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCarSend = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contcarNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchickenZYWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchickenSZWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchickenPYWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contFaecesPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contGrossPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtdriver = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcar = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtCarSend = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.contDeductionZY = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDeductionPY = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDeductionSZ = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDeductionKF = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDeductionKSS = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtDeductionZY = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtDeductionPY = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtDeductionSZ = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtDeductionKF = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtDeductionKSS = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contQCWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contChickenSet = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contGrossQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contGrossWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contSmChickenQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contSmChickenWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCriChickenQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCriChickenWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contQCQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contGrossSumQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contSetAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtQCWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtChickenSet = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtGrossQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtGrossWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtSmChickenQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtSmChickenWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtCriChickenQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtCriChickenWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtQCQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtGrossSumQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtSetAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcarNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtchickenZYWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtchickenSZWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtchickenPYWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtFaecesPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtGrossPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.audit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.unaudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.contdriver.setName("contdriver");
        this.contcompany.setName("contcompany");
        this.contcar.setName("contcar");
        this.contCarSend.setName("contCarSend");
        this.contbillStatus.setName("contbillStatus");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.contcarNum.setName("contcarNum");
        this.contchickenZYWgt.setName("contchickenZYWgt");
        this.contchickenSZWgt.setName("contchickenSZWgt");
        this.contchickenPYWgt.setName("contchickenPYWgt");
        this.contFaecesPrice.setName("contFaecesPrice");
        this.contGrossPrice.setName("contGrossPrice");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtdriver.setName("prmtdriver");
        this.prmtcompany.setName("prmtcompany");
        this.prmtcar.setName("prmtcar");
        this.prmtCarSend.setName("prmtCarSend");
        this.billStatus.setName("billStatus");
        this.contDeductionZY.setName("contDeductionZY");
        this.contDeductionPY.setName("contDeductionPY");
        this.contDeductionSZ.setName("contDeductionSZ");
        this.contDeductionKF.setName("contDeductionKF");
        this.contDeductionKSS.setName("contDeductionKSS");
        this.txtDeductionZY.setName("txtDeductionZY");
        this.txtDeductionPY.setName("txtDeductionPY");
        this.txtDeductionSZ.setName("txtDeductionSZ");
        this.txtDeductionKF.setName("txtDeductionKF");
        this.txtDeductionKSS.setName("txtDeductionKSS");
        this.contQCWgt.setName("contQCWgt");
        this.contChickenSet.setName("contChickenSet");
        this.contGrossQty.setName("contGrossQty");
        this.contGrossWgt.setName("contGrossWgt");
        this.contSmChickenQty.setName("contSmChickenQty");
        this.contSmChickenWgt.setName("contSmChickenWgt");
        this.contCriChickenQty.setName("contCriChickenQty");
        this.contCriChickenWgt.setName("contCriChickenWgt");
        this.contQCQty.setName("contQCQty");
        this.contGrossSumQty.setName("contGrossSumQty");
        this.contSetAmount.setName("contSetAmount");
        this.txtQCWgt.setName("txtQCWgt");
        this.txtChickenSet.setName("txtChickenSet");
        this.txtGrossQty.setName("txtGrossQty");
        this.txtGrossWgt.setName("txtGrossWgt");
        this.txtSmChickenQty.setName("txtSmChickenQty");
        this.txtSmChickenWgt.setName("txtSmChickenWgt");
        this.txtCriChickenQty.setName("txtCriChickenQty");
        this.txtCriChickenWgt.setName("txtCriChickenWgt");
        this.txtQCQty.setName("txtQCQty");
        this.txtGrossSumQty.setName("txtGrossSumQty");
        this.txtSetAmount.setName("txtSetAmount");
        this.txtcarNum.setName("txtcarNum");
        this.txtchickenZYWgt.setName("txtchickenZYWgt");
        this.txtchickenSZWgt.setName("txtchickenSZWgt");
        this.txtchickenPYWgt.setName("txtchickenPYWgt");
        this.txtFaecesPrice.setName("txtFaecesPrice");
        this.txtGrossPrice.setName("txtGrossPrice");
        this.audit.setName("audit");
        this.unaudit.setName("unaudit");
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
        // contdriver		
        this.contdriver.setBoundLabelText(resHelper.getString("contdriver.boundLabelText"));		
        this.contdriver.setBoundLabelLength(100);		
        this.contdriver.setBoundLabelUnderline(true);		
        this.contdriver.setVisible(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contcar		
        this.contcar.setBoundLabelText(resHelper.getString("contcar.boundLabelText"));		
        this.contcar.setBoundLabelLength(100);		
        this.contcar.setBoundLabelUnderline(true);		
        this.contcar.setVisible(true);
        // contCarSend		
        this.contCarSend.setBoundLabelText(resHelper.getString("contCarSend.boundLabelText"));		
        this.contCarSend.setBoundLabelLength(100);		
        this.contCarSend.setBoundLabelUnderline(true);		
        this.contCarSend.setVisible(true);
        // contbillStatus		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);
        // kDPanel1		
        this.kDPanel1.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel1.border.title")));
        // kDPanel2		
        this.kDPanel2.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel2.border.title")));
        // contcarNum		
        this.contcarNum.setBoundLabelText(resHelper.getString("contcarNum.boundLabelText"));		
        this.contcarNum.setBoundLabelLength(100);		
        this.contcarNum.setBoundLabelUnderline(true);		
        this.contcarNum.setVisible(true);
        // contchickenZYWgt		
        this.contchickenZYWgt.setBoundLabelText(resHelper.getString("contchickenZYWgt.boundLabelText"));		
        this.contchickenZYWgt.setBoundLabelLength(100);		
        this.contchickenZYWgt.setBoundLabelUnderline(true);		
        this.contchickenZYWgt.setVisible(false);
        // contchickenSZWgt		
        this.contchickenSZWgt.setBoundLabelText(resHelper.getString("contchickenSZWgt.boundLabelText"));		
        this.contchickenSZWgt.setBoundLabelLength(100);		
        this.contchickenSZWgt.setBoundLabelUnderline(true);		
        this.contchickenSZWgt.setVisible(false);
        // contchickenPYWgt		
        this.contchickenPYWgt.setBoundLabelText(resHelper.getString("contchickenPYWgt.boundLabelText"));		
        this.contchickenPYWgt.setBoundLabelLength(100);		
        this.contchickenPYWgt.setBoundLabelUnderline(true);		
        this.contchickenPYWgt.setVisible(false);
        // contFaecesPrice		
        this.contFaecesPrice.setBoundLabelText(resHelper.getString("contFaecesPrice.boundLabelText"));		
        this.contFaecesPrice.setBoundLabelLength(100);		
        this.contFaecesPrice.setBoundLabelUnderline(true);		
        this.contFaecesPrice.setVisible(false);
        // contGrossPrice		
        this.contGrossPrice.setBoundLabelText(resHelper.getString("contGrossPrice.boundLabelText"));		
        this.contGrossPrice.setBoundLabelLength(100);		
        this.contGrossPrice.setBoundLabelUnderline(true);		
        this.contGrossPrice.setVisible(true);
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
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
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
					
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setVisible(true);		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(false);
        // prmtcar		
        this.prmtcar.setQueryInfo("com.kingdee.eas.publicdata.app.CarQuery");		
        this.prmtcar.setVisible(true);		
        this.prmtcar.setEditable(true);		
        this.prmtcar.setDisplayFormat("$name$");		
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
					
        // prmtCarSend		
        this.prmtCarSend.setQueryInfo("com.kingdee.eas.custom.dx.weight.app.CarSendBillQuery");		
        this.prmtCarSend.setVisible(true);		
        this.prmtCarSend.setEditable(true);		
        this.prmtCarSend.setDisplayFormat("$number$");		
        this.prmtCarSend.setEditFormat("$number$");		
        this.prmtCarSend.setCommitFormat("$number$");		
        this.prmtCarSend.setRequired(false);
        // billStatus		
        this.billStatus.setVisible(true);		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.settlebill.billStatus").toArray());		
        this.billStatus.setRequired(false);
        // contDeductionZY		
        this.contDeductionZY.setBoundLabelText(resHelper.getString("contDeductionZY.boundLabelText"));		
        this.contDeductionZY.setBoundLabelLength(100);		
        this.contDeductionZY.setBoundLabelUnderline(true);		
        this.contDeductionZY.setVisible(true);
        // contDeductionPY		
        this.contDeductionPY.setBoundLabelText(resHelper.getString("contDeductionPY.boundLabelText"));		
        this.contDeductionPY.setBoundLabelLength(100);		
        this.contDeductionPY.setBoundLabelUnderline(true);		
        this.contDeductionPY.setVisible(true);
        // contDeductionSZ		
        this.contDeductionSZ.setBoundLabelText(resHelper.getString("contDeductionSZ.boundLabelText"));		
        this.contDeductionSZ.setBoundLabelLength(100);		
        this.contDeductionSZ.setBoundLabelUnderline(true);		
        this.contDeductionSZ.setVisible(true);
        // contDeductionKF		
        this.contDeductionKF.setBoundLabelText(resHelper.getString("contDeductionKF.boundLabelText"));		
        this.contDeductionKF.setBoundLabelLength(100);		
        this.contDeductionKF.setBoundLabelUnderline(true);		
        this.contDeductionKF.setVisible(true);
        // contDeductionKSS		
        this.contDeductionKSS.setBoundLabelText(resHelper.getString("contDeductionKSS.boundLabelText"));		
        this.contDeductionKSS.setBoundLabelLength(100);		
        this.contDeductionKSS.setBoundLabelUnderline(true);		
        this.contDeductionKSS.setVisible(true);
        // txtDeductionZY		
        this.txtDeductionZY.setVisible(true);		
        this.txtDeductionZY.setHorizontalAlignment(2);		
        this.txtDeductionZY.setDataType(1);		
        this.txtDeductionZY.setSupportedEmpty(true);		
        this.txtDeductionZY.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtDeductionZY.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtDeductionZY.setPrecision(4);		
        this.txtDeductionZY.setRequired(false);
        // txtDeductionPY		
        this.txtDeductionPY.setVisible(true);		
        this.txtDeductionPY.setHorizontalAlignment(2);		
        this.txtDeductionPY.setDataType(1);		
        this.txtDeductionPY.setSupportedEmpty(true);		
        this.txtDeductionPY.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtDeductionPY.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtDeductionPY.setPrecision(4);		
        this.txtDeductionPY.setRequired(false);
        // txtDeductionSZ		
        this.txtDeductionSZ.setVisible(true);		
        this.txtDeductionSZ.setHorizontalAlignment(2);		
        this.txtDeductionSZ.setDataType(1);		
        this.txtDeductionSZ.setSupportedEmpty(true);		
        this.txtDeductionSZ.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtDeductionSZ.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtDeductionSZ.setPrecision(4);		
        this.txtDeductionSZ.setRequired(false);
        // txtDeductionKF		
        this.txtDeductionKF.setVisible(true);		
        this.txtDeductionKF.setHorizontalAlignment(2);		
        this.txtDeductionKF.setDataType(1);		
        this.txtDeductionKF.setSupportedEmpty(true);		
        this.txtDeductionKF.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtDeductionKF.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtDeductionKF.setPrecision(4);		
        this.txtDeductionKF.setRequired(false);
        // txtDeductionKSS		
        this.txtDeductionKSS.setVisible(true);		
        this.txtDeductionKSS.setHorizontalAlignment(2);		
        this.txtDeductionKSS.setDataType(1);		
        this.txtDeductionKSS.setSupportedEmpty(true);		
        this.txtDeductionKSS.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtDeductionKSS.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtDeductionKSS.setPrecision(4);		
        this.txtDeductionKSS.setRequired(false);
        // contQCWgt		
        this.contQCWgt.setBoundLabelText(resHelper.getString("contQCWgt.boundLabelText"));		
        this.contQCWgt.setBoundLabelLength(100);		
        this.contQCWgt.setBoundLabelUnderline(true);		
        this.contQCWgt.setVisible(true);
        // contChickenSet		
        this.contChickenSet.setBoundLabelText(resHelper.getString("contChickenSet.boundLabelText"));		
        this.contChickenSet.setBoundLabelLength(100);		
        this.contChickenSet.setBoundLabelUnderline(true);		
        this.contChickenSet.setVisible(true);
        // contGrossQty		
        this.contGrossQty.setBoundLabelText(resHelper.getString("contGrossQty.boundLabelText"));		
        this.contGrossQty.setBoundLabelLength(100);		
        this.contGrossQty.setBoundLabelUnderline(true);		
        this.contGrossQty.setVisible(true);
        // contGrossWgt		
        this.contGrossWgt.setBoundLabelText(resHelper.getString("contGrossWgt.boundLabelText"));		
        this.contGrossWgt.setBoundLabelLength(100);		
        this.contGrossWgt.setBoundLabelUnderline(true);		
        this.contGrossWgt.setVisible(true);
        // contSmChickenQty		
        this.contSmChickenQty.setBoundLabelText(resHelper.getString("contSmChickenQty.boundLabelText"));		
        this.contSmChickenQty.setBoundLabelLength(100);		
        this.contSmChickenQty.setBoundLabelUnderline(true);		
        this.contSmChickenQty.setVisible(true);
        // contSmChickenWgt		
        this.contSmChickenWgt.setBoundLabelText(resHelper.getString("contSmChickenWgt.boundLabelText"));		
        this.contSmChickenWgt.setBoundLabelLength(100);		
        this.contSmChickenWgt.setBoundLabelUnderline(true);		
        this.contSmChickenWgt.setVisible(true);
        // contCriChickenQty		
        this.contCriChickenQty.setBoundLabelText(resHelper.getString("contCriChickenQty.boundLabelText"));		
        this.contCriChickenQty.setBoundLabelLength(100);		
        this.contCriChickenQty.setBoundLabelUnderline(true);		
        this.contCriChickenQty.setVisible(true);
        // contCriChickenWgt		
        this.contCriChickenWgt.setBoundLabelText(resHelper.getString("contCriChickenWgt.boundLabelText"));		
        this.contCriChickenWgt.setBoundLabelLength(100);		
        this.contCriChickenWgt.setBoundLabelUnderline(true);		
        this.contCriChickenWgt.setVisible(true);
        // contQCQty		
        this.contQCQty.setBoundLabelText(resHelper.getString("contQCQty.boundLabelText"));		
        this.contQCQty.setBoundLabelLength(100);		
        this.contQCQty.setBoundLabelUnderline(true);		
        this.contQCQty.setVisible(true);
        // contGrossSumQty		
        this.contGrossSumQty.setBoundLabelText(resHelper.getString("contGrossSumQty.boundLabelText"));		
        this.contGrossSumQty.setBoundLabelLength(100);		
        this.contGrossSumQty.setBoundLabelUnderline(true);		
        this.contGrossSumQty.setVisible(true);
        // contSetAmount		
        this.contSetAmount.setBoundLabelText(resHelper.getString("contSetAmount.boundLabelText"));		
        this.contSetAmount.setBoundLabelLength(100);		
        this.contSetAmount.setBoundLabelUnderline(true);		
        this.contSetAmount.setVisible(true);
        // txtQCWgt		
        this.txtQCWgt.setVisible(true);		
        this.txtQCWgt.setHorizontalAlignment(2);		
        this.txtQCWgt.setDataType(1);		
        this.txtQCWgt.setSupportedEmpty(true);		
        this.txtQCWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtQCWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtQCWgt.setPrecision(4);		
        this.txtQCWgt.setRequired(false);
        // txtChickenSet		
        this.txtChickenSet.setVisible(true);		
        this.txtChickenSet.setHorizontalAlignment(2);		
        this.txtChickenSet.setDataType(1);		
        this.txtChickenSet.setSupportedEmpty(true);		
        this.txtChickenSet.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtChickenSet.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtChickenSet.setPrecision(4);		
        this.txtChickenSet.setRequired(false);
        // txtGrossQty		
        this.txtGrossQty.setVisible(true);		
        this.txtGrossQty.setHorizontalAlignment(2);		
        this.txtGrossQty.setDataType(1);		
        this.txtGrossQty.setSupportedEmpty(true);		
        this.txtGrossQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtGrossQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtGrossQty.setPrecision(4);		
        this.txtGrossQty.setRequired(false);
        // txtGrossWgt		
        this.txtGrossWgt.setVisible(true);		
        this.txtGrossWgt.setHorizontalAlignment(2);		
        this.txtGrossWgt.setDataType(1);		
        this.txtGrossWgt.setSupportedEmpty(true);		
        this.txtGrossWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtGrossWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtGrossWgt.setPrecision(4);		
        this.txtGrossWgt.setRequired(false);
        // txtSmChickenQty		
        this.txtSmChickenQty.setVisible(true);		
        this.txtSmChickenQty.setHorizontalAlignment(2);		
        this.txtSmChickenQty.setDataType(1);		
        this.txtSmChickenQty.setSupportedEmpty(true);		
        this.txtSmChickenQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtSmChickenQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtSmChickenQty.setPrecision(4);		
        this.txtSmChickenQty.setRequired(false);
        // txtSmChickenWgt		
        this.txtSmChickenWgt.setVisible(true);		
        this.txtSmChickenWgt.setHorizontalAlignment(2);		
        this.txtSmChickenWgt.setDataType(1);		
        this.txtSmChickenWgt.setSupportedEmpty(true);		
        this.txtSmChickenWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtSmChickenWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtSmChickenWgt.setPrecision(4);		
        this.txtSmChickenWgt.setRequired(false);
        // txtCriChickenQty		
        this.txtCriChickenQty.setVisible(true);		
        this.txtCriChickenQty.setHorizontalAlignment(2);		
        this.txtCriChickenQty.setDataType(1);		
        this.txtCriChickenQty.setSupportedEmpty(true);		
        this.txtCriChickenQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtCriChickenQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtCriChickenQty.setPrecision(4);		
        this.txtCriChickenQty.setRequired(false);
        // txtCriChickenWgt		
        this.txtCriChickenWgt.setVisible(true);		
        this.txtCriChickenWgt.setHorizontalAlignment(2);		
        this.txtCriChickenWgt.setDataType(1);		
        this.txtCriChickenWgt.setSupportedEmpty(true);		
        this.txtCriChickenWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtCriChickenWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtCriChickenWgt.setPrecision(4);		
        this.txtCriChickenWgt.setRequired(false);
        // txtQCQty		
        this.txtQCQty.setVisible(true);		
        this.txtQCQty.setHorizontalAlignment(2);		
        this.txtQCQty.setDataType(1);		
        this.txtQCQty.setSupportedEmpty(true);		
        this.txtQCQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtQCQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtQCQty.setPrecision(4);		
        this.txtQCQty.setRequired(false);
        // txtGrossSumQty		
        this.txtGrossSumQty.setVisible(true);		
        this.txtGrossSumQty.setHorizontalAlignment(2);		
        this.txtGrossSumQty.setDataType(0);		
        this.txtGrossSumQty.setSupportedEmpty(true);		
        this.txtGrossSumQty.setRequired(false);
        // txtSetAmount		
        this.txtSetAmount.setVisible(true);		
        this.txtSetAmount.setHorizontalAlignment(2);		
        this.txtSetAmount.setDataType(1);		
        this.txtSetAmount.setSupportedEmpty(true);		
        this.txtSetAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtSetAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtSetAmount.setPrecision(4);		
        this.txtSetAmount.setRequired(false);
        // txtcarNum		
        this.txtcarNum.setVisible(true);		
        this.txtcarNum.setHorizontalAlignment(2);		
        this.txtcarNum.setMaxLength(100);		
        this.txtcarNum.setRequired(false);
        // txtchickenZYWgt		
        this.txtchickenZYWgt.setVisible(false);		
        this.txtchickenZYWgt.setHorizontalAlignment(2);		
        this.txtchickenZYWgt.setDataType(1);		
        this.txtchickenZYWgt.setSupportedEmpty(true);		
        this.txtchickenZYWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchickenZYWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchickenZYWgt.setPrecision(4);		
        this.txtchickenZYWgt.setRequired(false);
        // txtchickenSZWgt		
        this.txtchickenSZWgt.setVisible(false);		
        this.txtchickenSZWgt.setHorizontalAlignment(2);		
        this.txtchickenSZWgt.setDataType(1);		
        this.txtchickenSZWgt.setSupportedEmpty(true);		
        this.txtchickenSZWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchickenSZWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchickenSZWgt.setPrecision(4);		
        this.txtchickenSZWgt.setRequired(false);
        // txtchickenPYWgt		
        this.txtchickenPYWgt.setVisible(false);		
        this.txtchickenPYWgt.setHorizontalAlignment(2);		
        this.txtchickenPYWgt.setDataType(1);		
        this.txtchickenPYWgt.setSupportedEmpty(true);		
        this.txtchickenPYWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchickenPYWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchickenPYWgt.setPrecision(4);		
        this.txtchickenPYWgt.setRequired(false);
        // txtFaecesPrice		
        this.txtFaecesPrice.setVisible(false);		
        this.txtFaecesPrice.setHorizontalAlignment(2);		
        this.txtFaecesPrice.setDataType(1);		
        this.txtFaecesPrice.setSupportedEmpty(true);		
        this.txtFaecesPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtFaecesPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtFaecesPrice.setPrecision(4);		
        this.txtFaecesPrice.setRequired(false);
        // txtGrossPrice		
        this.txtGrossPrice.setVisible(true);		
        this.txtGrossPrice.setHorizontalAlignment(2);		
        this.txtGrossPrice.setDataType(1);		
        this.txtGrossPrice.setSupportedEmpty(true);		
        this.txtGrossPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtGrossPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtGrossPrice.setPrecision(4);		
        this.txtGrossPrice.setRequired(false);
        // audit
        this.audit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.audit.setText(resHelper.getString("audit.text"));
        // unaudit
        this.unaudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.unaudit.setText(resHelper.getString("unaudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtcarNum,prmtdriver,prmtcompany,txtchickenSZWgt,prmtcar,prmtCarSend,txtchickenPYWgt,txtchickenZYWgt,txtChickenSet,txtGrossQty,txtGrossWgt,txtSmChickenQty,txtSmChickenWgt,txtCriChickenQty,txtCriChickenWgt,txtQCQty,txtQCWgt,txtDeductionSZ,txtDeductionZY,txtDeductionPY,txtDeductionKF,txtFaecesPrice,billStatus,txtDeductionKSS,txtGrossSumQty,txtSetAmount,txtGrossPrice}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 560));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1013, 560));
        contCreator.setBounds(new Rectangle(376, 456, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(376, 456, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(730, 456, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(730, 456, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(376, 487, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(376, 487, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(730, 487, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(730, 487, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(37, 30, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(37, 30, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(721, 26, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(721, 26, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contDescription.setBounds(new Rectangle(-728, 66, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(-728, 66, 270, 19, 0));
        contAuditor.setBounds(new Rectangle(15, 460, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(15, 460, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdriver.setBounds(new Rectangle(394, 62, 270, 19));
        this.add(contdriver, new KDLayout.Constraints(394, 62, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompany.setBounds(new Rectangle(392, 27, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(392, 27, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcar.setBounds(new Rectangle(39, 107, 270, 19));
        this.add(contcar, new KDLayout.Constraints(39, 107, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCarSend.setBounds(new Rectangle(38, 67, 270, 19));
        this.add(contCarSend, new KDLayout.Constraints(38, 67, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(721, 60, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(721, 60, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDPanel1.setBounds(new Rectangle(27, 316, 948, 116));
        this.add(kDPanel1, new KDLayout.Constraints(27, 316, 948, 116, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDPanel2.setBounds(new Rectangle(26, 150, 952, 147));
        this.add(kDPanel2, new KDLayout.Constraints(26, 150, 952, 147, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcarNum.setBounds(new Rectangle(394, 106, 270, 19));
        this.add(contcarNum, new KDLayout.Constraints(394, 106, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contchickenZYWgt.setBounds(new Rectangle(970, 326, 270, 19));
        this.add(contchickenZYWgt, new KDLayout.Constraints(970, 326, 270, 19, 0));
        contchickenSZWgt.setBounds(new Rectangle(970, 298, 270, 19));
        this.add(contchickenSZWgt, new KDLayout.Constraints(970, 298, 270, 19, 0));
        contchickenPYWgt.setBounds(new Rectangle(970, 359, 270, 19));
        this.add(contchickenPYWgt, new KDLayout.Constraints(970, 359, 270, 19, 0));
        contFaecesPrice.setBounds(new Rectangle(969, 393, 270, 19));
        this.add(contFaecesPrice, new KDLayout.Constraints(969, 393, 270, 19, 0));
        contGrossPrice.setBounds(new Rectangle(721, 104, 270, 19));
        this.add(contGrossPrice, new KDLayout.Constraints(721, 104, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //contdriver
        contdriver.setBoundEditor(prmtdriver);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contcar
        contcar.setBoundEditor(prmtcar);
        //contCarSend
        contCarSend.setBoundEditor(prmtCarSend);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(27, 316, 948, 116));        contDeductionZY.setBounds(new Rectangle(336, 21, 270, 19));
        kDPanel1.add(contDeductionZY, new KDLayout.Constraints(336, 21, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDeductionPY.setBounds(new Rectangle(630, 20, 270, 19));
        kDPanel1.add(contDeductionPY, new KDLayout.Constraints(630, 20, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contDeductionSZ.setBounds(new Rectangle(14, 22, 270, 19));
        kDPanel1.add(contDeductionSZ, new KDLayout.Constraints(14, 22, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDeductionKF.setBounds(new Rectangle(14, 59, 270, 19));
        kDPanel1.add(contDeductionKF, new KDLayout.Constraints(14, 59, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDeductionKSS.setBounds(new Rectangle(336, 57, 270, 19));
        kDPanel1.add(contDeductionKSS, new KDLayout.Constraints(336, 57, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contDeductionZY
        contDeductionZY.setBoundEditor(txtDeductionZY);
        //contDeductionPY
        contDeductionPY.setBoundEditor(txtDeductionPY);
        //contDeductionSZ
        contDeductionSZ.setBoundEditor(txtDeductionSZ);
        //contDeductionKF
        contDeductionKF.setBoundEditor(txtDeductionKF);
        //contDeductionKSS
        contDeductionKSS.setBoundEditor(txtDeductionKSS);
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(26, 150, 952, 147));        contQCWgt.setBounds(new Rectangle(16, 86, 270, 19));
        kDPanel2.add(contQCWgt, new KDLayout.Constraints(16, 86, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contChickenSet.setBounds(new Rectangle(15, 114, 270, 19));
        kDPanel2.add(contChickenSet, new KDLayout.Constraints(15, 114, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contGrossQty.setBounds(new Rectangle(337, 23, 270, 19));
        kDPanel2.add(contGrossQty, new KDLayout.Constraints(337, 23, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contGrossWgt.setBounds(new Rectangle(338, 53, 270, 19));
        kDPanel2.add(contGrossWgt, new KDLayout.Constraints(338, 53, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contSmChickenQty.setBounds(new Rectangle(644, 22, 270, 19));
        kDPanel2.add(contSmChickenQty, new KDLayout.Constraints(644, 22, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contSmChickenWgt.setBounds(new Rectangle(645, 52, 270, 19));
        kDPanel2.add(contSmChickenWgt, new KDLayout.Constraints(645, 52, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contCriChickenQty.setBounds(new Rectangle(645, 79, 270, 19));
        kDPanel2.add(contCriChickenQty, new KDLayout.Constraints(645, 79, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contCriChickenWgt.setBounds(new Rectangle(646, 108, 270, 19));
        kDPanel2.add(contCriChickenWgt, new KDLayout.Constraints(646, 108, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contQCQty.setBounds(new Rectangle(15, 56, 270, 19));
        kDPanel2.add(contQCQty, new KDLayout.Constraints(15, 56, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contGrossSumQty.setBounds(new Rectangle(15, 28, 270, 19));
        kDPanel2.add(contGrossSumQty, new KDLayout.Constraints(15, 28, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contSetAmount.setBounds(new Rectangle(338, 113, 270, 19));
        kDPanel2.add(contSetAmount, new KDLayout.Constraints(338, 113, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contQCWgt
        contQCWgt.setBoundEditor(txtQCWgt);
        //contChickenSet
        contChickenSet.setBoundEditor(txtChickenSet);
        //contGrossQty
        contGrossQty.setBoundEditor(txtGrossQty);
        //contGrossWgt
        contGrossWgt.setBoundEditor(txtGrossWgt);
        //contSmChickenQty
        contSmChickenQty.setBoundEditor(txtSmChickenQty);
        //contSmChickenWgt
        contSmChickenWgt.setBoundEditor(txtSmChickenWgt);
        //contCriChickenQty
        contCriChickenQty.setBoundEditor(txtCriChickenQty);
        //contCriChickenWgt
        contCriChickenWgt.setBoundEditor(txtCriChickenWgt);
        //contQCQty
        contQCQty.setBoundEditor(txtQCQty);
        //contGrossSumQty
        contGrossSumQty.setBoundEditor(txtGrossSumQty);
        //contSetAmount
        contSetAmount.setBoundEditor(txtSetAmount);
        //contcarNum
        contcarNum.setBoundEditor(txtcarNum);
        //contchickenZYWgt
        contchickenZYWgt.setBoundEditor(txtchickenZYWgt);
        //contchickenSZWgt
        contchickenSZWgt.setBoundEditor(txtchickenSZWgt);
        //contchickenPYWgt
        contchickenPYWgt.setBoundEditor(txtchickenPYWgt);
        //contFaecesPrice
        contFaecesPrice.setBoundEditor(txtFaecesPrice);
        //contGrossPrice
        contGrossPrice.setBoundEditor(txtGrossPrice);

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
        this.toolBar.add(audit);
        this.toolBar.add(unaudit);
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
		dataBinder.registerBinding("driver", com.kingdee.eas.farm.feemanager.basedata.DriverInfo.class, this.prmtdriver, "data");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("car", com.kingdee.eas.publicdata.CarInfo.class, this.prmtcar, "data");
		dataBinder.registerBinding("CarSend", com.kingdee.eas.custom.dx.weight.CarSendBillInfo.class, this.prmtCarSend, "data");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.custom.settlebill.billStatus.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("DeductionZY", java.math.BigDecimal.class, this.txtDeductionZY, "value");
		dataBinder.registerBinding("DeductionPY", java.math.BigDecimal.class, this.txtDeductionPY, "value");
		dataBinder.registerBinding("DeductionSZ", java.math.BigDecimal.class, this.txtDeductionSZ, "value");
		dataBinder.registerBinding("DeductionKF", java.math.BigDecimal.class, this.txtDeductionKF, "value");
		dataBinder.registerBinding("DeductionKSS", java.math.BigDecimal.class, this.txtDeductionKSS, "value");
		dataBinder.registerBinding("QCWgt", java.math.BigDecimal.class, this.txtQCWgt, "value");
		dataBinder.registerBinding("ChickenSet", java.math.BigDecimal.class, this.txtChickenSet, "value");
		dataBinder.registerBinding("GrossQty", java.math.BigDecimal.class, this.txtGrossQty, "value");
		dataBinder.registerBinding("GrossWgt", java.math.BigDecimal.class, this.txtGrossWgt, "value");
		dataBinder.registerBinding("SmChickenQty", java.math.BigDecimal.class, this.txtSmChickenQty, "value");
		dataBinder.registerBinding("SmChickenWgt", java.math.BigDecimal.class, this.txtSmChickenWgt, "value");
		dataBinder.registerBinding("CriChickenQty", java.math.BigDecimal.class, this.txtCriChickenQty, "value");
		dataBinder.registerBinding("CriChickenWgt", java.math.BigDecimal.class, this.txtCriChickenWgt, "value");
		dataBinder.registerBinding("QCQty", java.math.BigDecimal.class, this.txtQCQty, "value");
		dataBinder.registerBinding("GrossSumQty", int.class, this.txtGrossSumQty, "value");
		dataBinder.registerBinding("SetAmount", java.math.BigDecimal.class, this.txtSetAmount, "value");
		dataBinder.registerBinding("carNum", String.class, this.txtcarNum, "text");
		dataBinder.registerBinding("chickenZYWgt", java.math.BigDecimal.class, this.txtchickenZYWgt, "value");
		dataBinder.registerBinding("chickenSZWgt", java.math.BigDecimal.class, this.txtchickenSZWgt, "value");
		dataBinder.registerBinding("chickenPYWgt", java.math.BigDecimal.class, this.txtchickenPYWgt, "value");
		dataBinder.registerBinding("FaecesPrice", java.math.BigDecimal.class, this.txtFaecesPrice, "value");
		dataBinder.registerBinding("GrossPrice", java.math.BigDecimal.class, this.txtGrossPrice, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.dx.weight.app.SettleReEditUIHandler";
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
        this.txtcarNum.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.dx.weight.SettleReInfo)ov;
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
		getValidateHelper().registerBindProperty("driver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("car", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CarSend", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DeductionZY", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DeductionPY", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DeductionSZ", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DeductionKF", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DeductionKSS", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("QCWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ChickenSet", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("GrossQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("GrossWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SmChickenQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SmChickenWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CriChickenQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CriChickenWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("QCQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("GrossSumQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SetAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("carNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenZYWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenSZWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenPYWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FaecesPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("GrossPrice", ValidateHelper.ON_SAVE);    		
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
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
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
			sic.add(new SelectorItemInfo("CarSend.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("CarSend.id"));
        	sic.add(new SelectorItemInfo("CarSend.number"));
		}
        sic.add(new SelectorItemInfo("billStatus"));
        sic.add(new SelectorItemInfo("DeductionZY"));
        sic.add(new SelectorItemInfo("DeductionPY"));
        sic.add(new SelectorItemInfo("DeductionSZ"));
        sic.add(new SelectorItemInfo("DeductionKF"));
        sic.add(new SelectorItemInfo("DeductionKSS"));
        sic.add(new SelectorItemInfo("QCWgt"));
        sic.add(new SelectorItemInfo("ChickenSet"));
        sic.add(new SelectorItemInfo("GrossQty"));
        sic.add(new SelectorItemInfo("GrossWgt"));
        sic.add(new SelectorItemInfo("SmChickenQty"));
        sic.add(new SelectorItemInfo("SmChickenWgt"));
        sic.add(new SelectorItemInfo("CriChickenQty"));
        sic.add(new SelectorItemInfo("CriChickenWgt"));
        sic.add(new SelectorItemInfo("QCQty"));
        sic.add(new SelectorItemInfo("GrossSumQty"));
        sic.add(new SelectorItemInfo("SetAmount"));
        sic.add(new SelectorItemInfo("carNum"));
        sic.add(new SelectorItemInfo("chickenZYWgt"));
        sic.add(new SelectorItemInfo("chickenSZWgt"));
        sic.add(new SelectorItemInfo("chickenPYWgt"));
        sic.add(new SelectorItemInfo("FaecesPrice"));
        sic.add(new SelectorItemInfo("GrossPrice"));
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
        com.kingdee.eas.custom.dx.weight.SettleReFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.dx.weight.SettleReFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractSettleReEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractSettleReEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.dx.weight.client", "SettleReEditUI");
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
        return com.kingdee.eas.custom.dx.weight.client.SettleReEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.dx.weight.SettleReFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.dx.weight.SettleReInfo objectValue = new com.kingdee.eas.custom.dx.weight.SettleReInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/dx/weight/SettleRe";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.dx.weight.app.SettleReQuery");
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