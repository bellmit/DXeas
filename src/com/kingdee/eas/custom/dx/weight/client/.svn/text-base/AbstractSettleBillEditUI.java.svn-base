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
public abstract class AbstractSettleBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSettleBillEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCarSend;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcarNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsupplier;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contGrossPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickavwgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdriver;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcarMaster;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCarSend;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDeductionZY;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDeductionPY;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDeductionSZ;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDeductionKF;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtDeductionZY;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtDeductionPY;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtDeductionSZ;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtDeductionKF;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contGrossQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contGrossWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contSmChickenQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contSmChickenWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCriChickenQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCriChickenWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contSettleAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contFrightAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfinlAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfirghttwo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contPyFarmAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfirghtprice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contOtherAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contreAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtGrossQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtGrossWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtSmChickenQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtSmChickenWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtCriChickenQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtCriChickenWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfarmAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtSettleAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtFrightAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfinlAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfirghttwo;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtPyFarmAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfirghtprice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtOtherAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtreAmount;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcarNum;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsupplier;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtGrossPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickavwgt;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtdriver;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcarMaster;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton audit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton unaudit;
    protected com.kingdee.eas.custom.dx.weight.SettleBillInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractSettleBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractSettleBillEditUI.class.getName());
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
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCarSend = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contcarNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsupplier = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contGrossPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchickavwgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdriver = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcarMaster = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtCarSend = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.contDeductionZY = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDeductionPY = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDeductionSZ = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDeductionKF = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtDeductionZY = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtDeductionPY = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtDeductionSZ = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtDeductionKF = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contGrossQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contGrossWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contSmChickenQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contSmChickenWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCriChickenQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCriChickenWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contSettleAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contFrightAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfinlAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfirghttwo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contPyFarmAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfirghtprice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contOtherAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contreAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtGrossQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtGrossWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtSmChickenQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtSmChickenWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtCriChickenQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtCriChickenWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfarmAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtSettleAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtFrightAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfinlAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfirghttwo = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtPyFarmAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfirghtprice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtOtherAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtreAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcarNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtsupplier = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtGrossPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtchickavwgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtdriver = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtcarMaster = new com.kingdee.bos.ctrl.swing.KDTextField();
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
        this.contcompany.setName("contcompany");
        this.contCarSend.setName("contCarSend");
        this.contbillStatus.setName("contbillStatus");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.contcarNum.setName("contcarNum");
        this.contsupplier.setName("contsupplier");
        this.contGrossPrice.setName("contGrossPrice");
        this.contchickavwgt.setName("contchickavwgt");
        this.contdriver.setName("contdriver");
        this.contcarMaster.setName("contcarMaster");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtcompany.setName("prmtcompany");
        this.prmtCarSend.setName("prmtCarSend");
        this.billStatus.setName("billStatus");
        this.contDeductionZY.setName("contDeductionZY");
        this.contDeductionPY.setName("contDeductionPY");
        this.contDeductionSZ.setName("contDeductionSZ");
        this.contDeductionKF.setName("contDeductionKF");
        this.txtDeductionZY.setName("txtDeductionZY");
        this.txtDeductionPY.setName("txtDeductionPY");
        this.txtDeductionSZ.setName("txtDeductionSZ");
        this.txtDeductionKF.setName("txtDeductionKF");
        this.contGrossQty.setName("contGrossQty");
        this.contGrossWgt.setName("contGrossWgt");
        this.contSmChickenQty.setName("contSmChickenQty");
        this.contSmChickenWgt.setName("contSmChickenWgt");
        this.contCriChickenQty.setName("contCriChickenQty");
        this.contCriChickenWgt.setName("contCriChickenWgt");
        this.contfarmAmount.setName("contfarmAmount");
        this.contSettleAmount.setName("contSettleAmount");
        this.contFrightAmount.setName("contFrightAmount");
        this.contAmount.setName("contAmount");
        this.contfinlAmount.setName("contfinlAmount");
        this.contfirghttwo.setName("contfirghttwo");
        this.contPyFarmAmount.setName("contPyFarmAmount");
        this.contfirghtprice.setName("contfirghtprice");
        this.contOtherAmount.setName("contOtherAmount");
        this.contreAmount.setName("contreAmount");
        this.txtGrossQty.setName("txtGrossQty");
        this.txtGrossWgt.setName("txtGrossWgt");
        this.txtSmChickenQty.setName("txtSmChickenQty");
        this.txtSmChickenWgt.setName("txtSmChickenWgt");
        this.txtCriChickenQty.setName("txtCriChickenQty");
        this.txtCriChickenWgt.setName("txtCriChickenWgt");
        this.txtfarmAmount.setName("txtfarmAmount");
        this.txtSettleAmount.setName("txtSettleAmount");
        this.txtFrightAmount.setName("txtFrightAmount");
        this.txtAmount.setName("txtAmount");
        this.txtfinlAmount.setName("txtfinlAmount");
        this.txtfirghttwo.setName("txtfirghttwo");
        this.txtPyFarmAmount.setName("txtPyFarmAmount");
        this.txtfirghtprice.setName("txtfirghtprice");
        this.txtOtherAmount.setName("txtOtherAmount");
        this.txtreAmount.setName("txtreAmount");
        this.txtcarNum.setName("txtcarNum");
        this.prmtsupplier.setName("prmtsupplier");
        this.txtGrossPrice.setName("txtGrossPrice");
        this.txtchickavwgt.setName("txtchickavwgt");
        this.prmtdriver.setName("prmtdriver");
        this.txtcarMaster.setName("txtcarMaster");
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
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
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
        // contsupplier		
        this.contsupplier.setBoundLabelText(resHelper.getString("contsupplier.boundLabelText"));		
        this.contsupplier.setBoundLabelLength(100);		
        this.contsupplier.setBoundLabelUnderline(true);		
        this.contsupplier.setVisible(true);
        // contGrossPrice		
        this.contGrossPrice.setBoundLabelText(resHelper.getString("contGrossPrice.boundLabelText"));		
        this.contGrossPrice.setBoundLabelLength(100);		
        this.contGrossPrice.setBoundLabelUnderline(true);		
        this.contGrossPrice.setVisible(true);
        // contchickavwgt		
        this.contchickavwgt.setBoundLabelText(resHelper.getString("contchickavwgt.boundLabelText"));		
        this.contchickavwgt.setBoundLabelLength(100);		
        this.contchickavwgt.setBoundLabelUnderline(true);		
        this.contchickavwgt.setVisible(true);
        // contdriver		
        this.contdriver.setBoundLabelText(resHelper.getString("contdriver.boundLabelText"));		
        this.contdriver.setBoundLabelLength(100);		
        this.contdriver.setBoundLabelUnderline(true);		
        this.contdriver.setVisible(true);
        // contcarMaster		
        this.contcarMaster.setBoundLabelText(resHelper.getString("contcarMaster.boundLabelText"));		
        this.contcarMaster.setBoundLabelLength(100);		
        this.contcarMaster.setBoundLabelUnderline(true);		
        this.contcarMaster.setVisible(true);
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
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setVisible(true);		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(false);
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
        this.contDeductionKF.setVisible(false);
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
        this.txtDeductionKF.setHorizontalAlignment(2);		
        this.txtDeductionKF.setDataType(1);		
        this.txtDeductionKF.setSupportedEmpty(true);		
        this.txtDeductionKF.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtDeductionKF.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtDeductionKF.setPrecision(4);		
        this.txtDeductionKF.setRequired(false);
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
        // contfarmAmount		
        this.contfarmAmount.setBoundLabelText(resHelper.getString("contfarmAmount.boundLabelText"));		
        this.contfarmAmount.setBoundLabelLength(100);		
        this.contfarmAmount.setBoundLabelUnderline(true);		
        this.contfarmAmount.setVisible(true);
        // contSettleAmount		
        this.contSettleAmount.setBoundLabelText(resHelper.getString("contSettleAmount.boundLabelText"));		
        this.contSettleAmount.setBoundLabelLength(100);		
        this.contSettleAmount.setBoundLabelUnderline(true);		
        this.contSettleAmount.setVisible(true);
        // contFrightAmount		
        this.contFrightAmount.setBoundLabelText(resHelper.getString("contFrightAmount.boundLabelText"));		
        this.contFrightAmount.setBoundLabelLength(100);		
        this.contFrightAmount.setBoundLabelUnderline(true);		
        this.contFrightAmount.setVisible(true);
        // contAmount		
        this.contAmount.setBoundLabelText(resHelper.getString("contAmount.boundLabelText"));		
        this.contAmount.setBoundLabelLength(100);		
        this.contAmount.setBoundLabelUnderline(true);		
        this.contAmount.setVisible(true);
        // contfinlAmount		
        this.contfinlAmount.setBoundLabelText(resHelper.getString("contfinlAmount.boundLabelText"));		
        this.contfinlAmount.setBoundLabelLength(100);		
        this.contfinlAmount.setBoundLabelUnderline(true);		
        this.contfinlAmount.setVisible(true);
        // contfirghttwo		
        this.contfirghttwo.setBoundLabelText(resHelper.getString("contfirghttwo.boundLabelText"));		
        this.contfirghttwo.setBoundLabelLength(100);		
        this.contfirghttwo.setBoundLabelUnderline(true);		
        this.contfirghttwo.setVisible(true);
        // contPyFarmAmount		
        this.contPyFarmAmount.setBoundLabelText(resHelper.getString("contPyFarmAmount.boundLabelText"));		
        this.contPyFarmAmount.setBoundLabelLength(100);		
        this.contPyFarmAmount.setBoundLabelUnderline(true);		
        this.contPyFarmAmount.setVisible(true);
        // contfirghtprice		
        this.contfirghtprice.setBoundLabelText(resHelper.getString("contfirghtprice.boundLabelText"));		
        this.contfirghtprice.setBoundLabelLength(100);		
        this.contfirghtprice.setBoundLabelUnderline(true);		
        this.contfirghtprice.setVisible(true);
        // contOtherAmount		
        this.contOtherAmount.setBoundLabelText(resHelper.getString("contOtherAmount.boundLabelText"));		
        this.contOtherAmount.setBoundLabelLength(100);		
        this.contOtherAmount.setBoundLabelUnderline(true);		
        this.contOtherAmount.setVisible(true);
        // contreAmount		
        this.contreAmount.setBoundLabelText(resHelper.getString("contreAmount.boundLabelText"));		
        this.contreAmount.setBoundLabelLength(100);		
        this.contreAmount.setBoundLabelUnderline(true);		
        this.contreAmount.setVisible(true);
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
        // txtfarmAmount		
        this.txtfarmAmount.setVisible(true);		
        this.txtfarmAmount.setHorizontalAlignment(2);		
        this.txtfarmAmount.setDataType(1);		
        this.txtfarmAmount.setSupportedEmpty(true);		
        this.txtfarmAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfarmAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfarmAmount.setPrecision(2);		
        this.txtfarmAmount.setRequired(true);
        // txtSettleAmount		
        this.txtSettleAmount.setVisible(true);		
        this.txtSettleAmount.setHorizontalAlignment(2);		
        this.txtSettleAmount.setDataType(1);		
        this.txtSettleAmount.setSupportedEmpty(true);		
        this.txtSettleAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtSettleAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtSettleAmount.setPrecision(2);		
        this.txtSettleAmount.setRequired(true);		
        this.txtSettleAmount.setEnabled(false);
        // txtFrightAmount		
        this.txtFrightAmount.setVisible(true);		
        this.txtFrightAmount.setHorizontalAlignment(2);		
        this.txtFrightAmount.setDataType(1);		
        this.txtFrightAmount.setSupportedEmpty(true);		
        this.txtFrightAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtFrightAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtFrightAmount.setPrecision(2);		
        this.txtFrightAmount.setRequired(false);		
        this.txtFrightAmount.setEnabled(false);
        // txtAmount		
        this.txtAmount.setVisible(true);		
        this.txtAmount.setHorizontalAlignment(2);		
        this.txtAmount.setDataType(1);		
        this.txtAmount.setSupportedEmpty(true);		
        this.txtAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtAmount.setPrecision(4);		
        this.txtAmount.setRequired(false);
        // txtfinlAmount		
        this.txtfinlAmount.setVisible(true);		
        this.txtfinlAmount.setHorizontalAlignment(2);		
        this.txtfinlAmount.setDataType(1);		
        this.txtfinlAmount.setSupportedEmpty(true);		
        this.txtfinlAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfinlAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfinlAmount.setPrecision(4);		
        this.txtfinlAmount.setRequired(false);		
        this.txtfinlAmount.setEnabled(false);
        // txtfirghttwo		
        this.txtfirghttwo.setVisible(true);		
        this.txtfirghttwo.setHorizontalAlignment(2);		
        this.txtfirghttwo.setDataType(1);		
        this.txtfirghttwo.setSupportedEmpty(true);		
        this.txtfirghttwo.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfirghttwo.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfirghttwo.setPrecision(4);		
        this.txtfirghttwo.setRequired(false);		
        this.txtfirghttwo.setEnabled(false);
        // txtPyFarmAmount		
        this.txtPyFarmAmount.setVisible(true);		
        this.txtPyFarmAmount.setHorizontalAlignment(2);		
        this.txtPyFarmAmount.setDataType(1);		
        this.txtPyFarmAmount.setSupportedEmpty(true);		
        this.txtPyFarmAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtPyFarmAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtPyFarmAmount.setPrecision(4);		
        this.txtPyFarmAmount.setRequired(false);
        // txtfirghtprice		
        this.txtfirghtprice.setVisible(true);		
        this.txtfirghtprice.setHorizontalAlignment(2);		
        this.txtfirghtprice.setDataType(1);		
        this.txtfirghtprice.setSupportedEmpty(true);		
        this.txtfirghtprice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfirghtprice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfirghtprice.setPrecision(4);		
        this.txtfirghtprice.setRequired(false);		
        this.txtfirghtprice.setEnabled(false);
        // txtOtherAmount		
        this.txtOtherAmount.setVisible(true);		
        this.txtOtherAmount.setHorizontalAlignment(2);		
        this.txtOtherAmount.setDataType(1);		
        this.txtOtherAmount.setSupportedEmpty(true);		
        this.txtOtherAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtOtherAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtOtherAmount.setPrecision(4);		
        this.txtOtherAmount.setRequired(false);
        // txtreAmount		
        this.txtreAmount.setVisible(true);		
        this.txtreAmount.setHorizontalAlignment(2);		
        this.txtreAmount.setDataType(1);		
        this.txtreAmount.setSupportedEmpty(true);		
        this.txtreAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtreAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtreAmount.setPrecision(4);		
        this.txtreAmount.setRequired(false);		
        this.txtreAmount.setEnabled(false);
        // txtcarNum		
        this.txtcarNum.setVisible(true);		
        this.txtcarNum.setHorizontalAlignment(2);		
        this.txtcarNum.setMaxLength(100);		
        this.txtcarNum.setRequired(false);
        // prmtsupplier		
        this.prmtsupplier.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.PSupplierQuery");		
        this.prmtsupplier.setVisible(true);		
        this.prmtsupplier.setEditable(true);		
        this.prmtsupplier.setDisplayFormat("$name$");		
        this.prmtsupplier.setEditFormat("$number$");		
        this.prmtsupplier.setCommitFormat("$number$");		
        this.prmtsupplier.setRequired(false);
        // txtGrossPrice		
        this.txtGrossPrice.setVisible(true);		
        this.txtGrossPrice.setHorizontalAlignment(2);		
        this.txtGrossPrice.setDataType(1);		
        this.txtGrossPrice.setSupportedEmpty(true);		
        this.txtGrossPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtGrossPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtGrossPrice.setPrecision(4);		
        this.txtGrossPrice.setRequired(false);
        // txtchickavwgt		
        this.txtchickavwgt.setVisible(true);		
        this.txtchickavwgt.setHorizontalAlignment(2);		
        this.txtchickavwgt.setDataType(1);		
        this.txtchickavwgt.setSupportedEmpty(true);		
        this.txtchickavwgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchickavwgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchickavwgt.setPrecision(4);		
        this.txtchickavwgt.setRequired(false);		
        this.txtchickavwgt.setEnabled(false);
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
					
        // txtcarMaster		
        this.txtcarMaster.setVisible(true);		
        this.txtcarMaster.setHorizontalAlignment(2);		
        this.txtcarMaster.setMaxLength(100);		
        this.txtcarMaster.setRequired(false);		
        this.txtcarMaster.setEnabled(false);
        // audit
        this.audit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.audit.setText(resHelper.getString("audit.text"));
        // unaudit
        this.unaudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.unaudit.setText(resHelper.getString("unaudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtcarNum,prmtcompany,prmtCarSend,txtGrossQty,txtGrossWgt,txtSmChickenQty,txtSmChickenWgt,txtCriChickenQty,txtCriChickenWgt,txtDeductionSZ,txtDeductionZY,txtDeductionPY,txtDeductionKF,billStatus,txtfarmAmount,txtSettleAmount,txtFrightAmount,prmtsupplier,txtAmount,txtfinlAmount,txtfirghttwo,txtPyFarmAmount,txtfirghtprice,txtOtherAmount,txtGrossPrice,txtchickavwgt,txtreAmount,prmtdriver,txtcarMaster}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 529));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1013, 529));
        contCreator.setBounds(new Rectangle(376, 465, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(376, 465, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(730, 465, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(730, 465, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(376, 496, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(376, 496, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(730, 496, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(730, 496, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(37, 20, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(37, 20, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(721, 20, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(721, 20, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contDescription.setBounds(new Rectangle(-728, 66, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(-728, 66, 270, 19, 0));
        contAuditor.setBounds(new Rectangle(15, 469, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(15, 469, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompany.setBounds(new Rectangle(392, 20, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(392, 20, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCarSend.setBounds(new Rectangle(37, 51, 270, 19));
        this.add(contCarSend, new KDLayout.Constraints(37, 51, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(721, 51, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(721, 51, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDPanel1.setBounds(new Rectangle(25, 370, 955, 84));
        this.add(kDPanel1, new KDLayout.Constraints(25, 370, 955, 84, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDPanel2.setBounds(new Rectangle(26, 140, 952, 223));
        this.add(kDPanel2, new KDLayout.Constraints(26, 140, 952, 223, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcarNum.setBounds(new Rectangle(392, 51, 270, 19));
        this.add(contcarNum, new KDLayout.Constraints(392, 51, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsupplier.setBounds(new Rectangle(37, 79, 270, 19));
        this.add(contsupplier, new KDLayout.Constraints(37, 79, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contGrossPrice.setBounds(new Rectangle(392, 108, 270, 19));
        this.add(contGrossPrice, new KDLayout.Constraints(392, 108, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contchickavwgt.setBounds(new Rectangle(721, 108, 270, 19));
        this.add(contchickavwgt, new KDLayout.Constraints(721, 108, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contdriver.setBounds(new Rectangle(392, 79, 270, 19));
        this.add(contdriver, new KDLayout.Constraints(392, 79, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcarMaster.setBounds(new Rectangle(721, 79, 270, 19));
        this.add(contcarMaster, new KDLayout.Constraints(721, 79, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contCarSend
        contCarSend.setBoundEditor(prmtCarSend);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(25, 370, 955, 84));        contDeductionZY.setBounds(new Rectangle(333, 21, 270, 19));
        kDPanel1.add(contDeductionZY, new KDLayout.Constraints(333, 21, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDeductionPY.setBounds(new Rectangle(632, 16, 270, 19));
        kDPanel1.add(contDeductionPY, new KDLayout.Constraints(632, 16, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contDeductionSZ.setBounds(new Rectangle(16, 20, 270, 19));
        kDPanel1.add(contDeductionSZ, new KDLayout.Constraints(16, 20, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDeductionKF.setBounds(new Rectangle(16, 48, 270, 19));
        kDPanel1.add(contDeductionKF, new KDLayout.Constraints(16, 48, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contDeductionZY
        contDeductionZY.setBoundEditor(txtDeductionZY);
        //contDeductionPY
        contDeductionPY.setBoundEditor(txtDeductionPY);
        //contDeductionSZ
        contDeductionSZ.setBoundEditor(txtDeductionSZ);
        //contDeductionKF
        contDeductionKF.setBoundEditor(txtDeductionKF);
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(26, 140, 952, 223));        contGrossQty.setBounds(new Rectangle(632, 52, 270, 19));
        kDPanel2.add(contGrossQty, new KDLayout.Constraints(632, 52, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contGrossWgt.setBounds(new Rectangle(632, 23, 270, 19));
        kDPanel2.add(contGrossWgt, new KDLayout.Constraints(632, 23, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contSmChickenQty.setBounds(new Rectangle(17, 26, 270, 19));
        kDPanel2.add(contSmChickenQty, new KDLayout.Constraints(17, 26, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contSmChickenWgt.setBounds(new Rectangle(16, 56, 270, 19));
        kDPanel2.add(contSmChickenWgt, new KDLayout.Constraints(16, 56, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCriChickenQty.setBounds(new Rectangle(334, 24, 270, 19));
        kDPanel2.add(contCriChickenQty, new KDLayout.Constraints(334, 24, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCriChickenWgt.setBounds(new Rectangle(334, 53, 270, 19));
        kDPanel2.add(contCriChickenWgt, new KDLayout.Constraints(334, 53, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmAmount.setBounds(new Rectangle(334, 85, 270, 19));
        kDPanel2.add(contfarmAmount, new KDLayout.Constraints(334, 85, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contSettleAmount.setBounds(new Rectangle(16, 88, 270, 19));
        kDPanel2.add(contSettleAmount, new KDLayout.Constraints(16, 88, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contFrightAmount.setBounds(new Rectangle(632, 114, 270, 19));
        kDPanel2.add(contFrightAmount, new KDLayout.Constraints(632, 114, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAmount.setBounds(new Rectangle(16, 120, 270, 19));
        kDPanel2.add(contAmount, new KDLayout.Constraints(16, 120, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfinlAmount.setBounds(new Rectangle(333, 119, 270, 19));
        kDPanel2.add(contfinlAmount, new KDLayout.Constraints(333, 119, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfirghttwo.setBounds(new Rectangle(632, 148, 270, 19));
        kDPanel2.add(contfirghttwo, new KDLayout.Constraints(632, 148, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contPyFarmAmount.setBounds(new Rectangle(16, 182, 270, 19));
        kDPanel2.add(contPyFarmAmount, new KDLayout.Constraints(16, 182, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfirghtprice.setBounds(new Rectangle(333, 147, 270, 19));
        kDPanel2.add(contfirghtprice, new KDLayout.Constraints(333, 147, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contOtherAmount.setBounds(new Rectangle(632, 84, 270, 19));
        kDPanel2.add(contOtherAmount, new KDLayout.Constraints(632, 84, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contreAmount.setBounds(new Rectangle(16, 153, 270, 19));
        kDPanel2.add(contreAmount, new KDLayout.Constraints(16, 153, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contfarmAmount
        contfarmAmount.setBoundEditor(txtfarmAmount);
        //contSettleAmount
        contSettleAmount.setBoundEditor(txtSettleAmount);
        //contFrightAmount
        contFrightAmount.setBoundEditor(txtFrightAmount);
        //contAmount
        contAmount.setBoundEditor(txtAmount);
        //contfinlAmount
        contfinlAmount.setBoundEditor(txtfinlAmount);
        //contfirghttwo
        contfirghttwo.setBoundEditor(txtfirghttwo);
        //contPyFarmAmount
        contPyFarmAmount.setBoundEditor(txtPyFarmAmount);
        //contfirghtprice
        contfirghtprice.setBoundEditor(txtfirghtprice);
        //contOtherAmount
        contOtherAmount.setBoundEditor(txtOtherAmount);
        //contreAmount
        contreAmount.setBoundEditor(txtreAmount);
        //contcarNum
        contcarNum.setBoundEditor(txtcarNum);
        //contsupplier
        contsupplier.setBoundEditor(prmtsupplier);
        //contGrossPrice
        contGrossPrice.setBoundEditor(txtGrossPrice);
        //contchickavwgt
        contchickavwgt.setBoundEditor(txtchickavwgt);
        //contdriver
        contdriver.setBoundEditor(prmtdriver);
        //contcarMaster
        contcarMaster.setBoundEditor(txtcarMaster);

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
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("CarSend", com.kingdee.eas.custom.dx.weight.CarSendBillInfo.class, this.prmtCarSend, "data");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.custom.settlebill.billStatus.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("DeductionZY", java.math.BigDecimal.class, this.txtDeductionZY, "value");
		dataBinder.registerBinding("DeductionPY", java.math.BigDecimal.class, this.txtDeductionPY, "value");
		dataBinder.registerBinding("DeductionSZ", java.math.BigDecimal.class, this.txtDeductionSZ, "value");
		dataBinder.registerBinding("DeductionKF", java.math.BigDecimal.class, this.txtDeductionKF, "value");
		dataBinder.registerBinding("GrossQty", java.math.BigDecimal.class, this.txtGrossQty, "value");
		dataBinder.registerBinding("GrossWgt", java.math.BigDecimal.class, this.txtGrossWgt, "value");
		dataBinder.registerBinding("SmChickenQty", java.math.BigDecimal.class, this.txtSmChickenQty, "value");
		dataBinder.registerBinding("SmChickenWgt", java.math.BigDecimal.class, this.txtSmChickenWgt, "value");
		dataBinder.registerBinding("CriChickenQty", java.math.BigDecimal.class, this.txtCriChickenQty, "value");
		dataBinder.registerBinding("CriChickenWgt", java.math.BigDecimal.class, this.txtCriChickenWgt, "value");
		dataBinder.registerBinding("farmAmount", java.math.BigDecimal.class, this.txtfarmAmount, "value");
		dataBinder.registerBinding("SettleAmount", java.math.BigDecimal.class, this.txtSettleAmount, "value");
		dataBinder.registerBinding("FrightAmount", java.math.BigDecimal.class, this.txtFrightAmount, "value");
		dataBinder.registerBinding("Amount", java.math.BigDecimal.class, this.txtAmount, "value");
		dataBinder.registerBinding("finlAmount", java.math.BigDecimal.class, this.txtfinlAmount, "value");
		dataBinder.registerBinding("firghttwo", java.math.BigDecimal.class, this.txtfirghttwo, "value");
		dataBinder.registerBinding("PyFarmAmount", java.math.BigDecimal.class, this.txtPyFarmAmount, "value");
		dataBinder.registerBinding("firghtprice", java.math.BigDecimal.class, this.txtfirghtprice, "value");
		dataBinder.registerBinding("OtherAmount", java.math.BigDecimal.class, this.txtOtherAmount, "value");
		dataBinder.registerBinding("reAmount", java.math.BigDecimal.class, this.txtreAmount, "value");
		dataBinder.registerBinding("carNum", String.class, this.txtcarNum, "text");
		dataBinder.registerBinding("supplier", com.kingdee.eas.basedata.master.cssp.SupplierInfo.class, this.prmtsupplier, "data");
		dataBinder.registerBinding("GrossPrice", java.math.BigDecimal.class, this.txtGrossPrice, "value");
		dataBinder.registerBinding("chickavwgt", java.math.BigDecimal.class, this.txtchickavwgt, "value");
		dataBinder.registerBinding("driver", com.kingdee.eas.farm.feemanager.basedata.DriverInfo.class, this.prmtdriver, "data");
		dataBinder.registerBinding("carMaster", String.class, this.txtcarMaster, "text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.dx.weight.app.SettleBillEditUIHandler";
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
        this.editData = (com.kingdee.eas.custom.dx.weight.SettleBillInfo)ov;
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
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CarSend", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DeductionZY", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DeductionPY", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DeductionSZ", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DeductionKF", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("GrossQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("GrossWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SmChickenQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SmChickenWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CriChickenQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CriChickenWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SettleAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FrightAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("finlAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("firghttwo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PyFarmAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("firghtprice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OtherAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("reAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("carNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("supplier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("GrossPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickavwgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("driver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("carMaster", ValidateHelper.ON_SAVE);    		
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
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
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
        sic.add(new SelectorItemInfo("GrossQty"));
        sic.add(new SelectorItemInfo("GrossWgt"));
        sic.add(new SelectorItemInfo("SmChickenQty"));
        sic.add(new SelectorItemInfo("SmChickenWgt"));
        sic.add(new SelectorItemInfo("CriChickenQty"));
        sic.add(new SelectorItemInfo("CriChickenWgt"));
        sic.add(new SelectorItemInfo("farmAmount"));
        sic.add(new SelectorItemInfo("SettleAmount"));
        sic.add(new SelectorItemInfo("FrightAmount"));
        sic.add(new SelectorItemInfo("Amount"));
        sic.add(new SelectorItemInfo("finlAmount"));
        sic.add(new SelectorItemInfo("firghttwo"));
        sic.add(new SelectorItemInfo("PyFarmAmount"));
        sic.add(new SelectorItemInfo("firghtprice"));
        sic.add(new SelectorItemInfo("OtherAmount"));
        sic.add(new SelectorItemInfo("reAmount"));
        sic.add(new SelectorItemInfo("carNum"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("supplier.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("supplier.id"));
        	sic.add(new SelectorItemInfo("supplier.number"));
        	sic.add(new SelectorItemInfo("supplier.name"));
		}
        sic.add(new SelectorItemInfo("GrossPrice"));
        sic.add(new SelectorItemInfo("chickavwgt"));
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
        sic.add(new SelectorItemInfo("carMaster"));
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
        com.kingdee.eas.custom.dx.weight.SettleBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.dx.weight.SettleBillFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractSettleBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractSettleBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.dx.weight.client", "SettleBillEditUI");
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
        return com.kingdee.eas.custom.dx.weight.client.SettleBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.dx.weight.SettleBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.dx.weight.SettleBillInfo objectValue = new com.kingdee.eas.custom.dx.weight.SettleBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/dx/weight/SettleBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.dx.weight.app.SettleBillQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtfarmAmount.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖户结算金额"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtSettleAmount.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"结算金额"});
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
		vo.put("billStatus","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}