/**
 * output package name
 */
package com.kingdee.eas.farm.farmer.client;

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
public abstract class AbstractFarmerResearchBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractFarmerResearchBillEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmerName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contIDCardNo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthomeAddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmAddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedExperience;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedLevel;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthenhouseType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthenhouseOwn;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkhenhousePledged;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedMode;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contkeepTempEquip;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkhasLoan;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcustomerPublicPraice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontractMode;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpayInAgency;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpaInSupplier;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteverAgency;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdownTempEquip;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contotherDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallScore;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfarmerName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtIDCardNo;
    protected com.kingdee.bos.ctrl.swing.KDTextField txthomeAddress;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfarmAddress;
    protected com.kingdee.bos.ctrl.swing.KDComboBox breedExperience;
    protected com.kingdee.bos.ctrl.swing.KDComboBox breedLevel;
    protected com.kingdee.bos.ctrl.swing.KDComboBox henhouseType;
    protected com.kingdee.bos.ctrl.swing.KDComboBox henhouseOwn;
    protected com.kingdee.bos.ctrl.swing.KDComboBox breedMode;
    protected com.kingdee.bos.ctrl.swing.KDComboBox keepTempEquip;
    protected com.kingdee.bos.ctrl.swing.KDComboBox customerPublicPraice;
    protected com.kingdee.bos.ctrl.swing.KDComboBox contractMode;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpayInAgency;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpaInSupplier;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmteverAgency;
    protected com.kingdee.bos.ctrl.swing.KDComboBox downTempEquip;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane scrollPaneotherDescription;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtotherDescription;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtallScore;
    protected com.kingdee.eas.farm.farmer.FarmerResearchBillInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractFarmerResearchBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractFarmerResearchBillEditUI.class.getName());
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
        this.contfarmerName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contIDCardNo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthomeAddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmAddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbreedExperience = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbreedLevel = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthenhouseType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthenhouseOwn = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkhenhousePledged = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contbreedMode = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contkeepTempEquip = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkhasLoan = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contcustomerPublicPraice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcontractMode = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpayInAgency = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpaInSupplier = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteverAgency = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdownTempEquip = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contotherDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallScore = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtfarmerName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtIDCardNo = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txthomeAddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtfarmAddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.breedExperience = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.breedLevel = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.henhouseType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.henhouseOwn = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.breedMode = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.keepTempEquip = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.customerPublicPraice = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.contractMode = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtpayInAgency = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtpaInSupplier = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmteverAgency = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.downTempEquip = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.scrollPaneotherDescription = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txtotherDescription = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.txtallScore = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.contfarmerName.setName("contfarmerName");
        this.contIDCardNo.setName("contIDCardNo");
        this.conthomeAddress.setName("conthomeAddress");
        this.contfarmAddress.setName("contfarmAddress");
        this.contbreedExperience.setName("contbreedExperience");
        this.contbreedLevel.setName("contbreedLevel");
        this.conthenhouseType.setName("conthenhouseType");
        this.conthenhouseOwn.setName("conthenhouseOwn");
        this.chkhenhousePledged.setName("chkhenhousePledged");
        this.contbreedMode.setName("contbreedMode");
        this.contkeepTempEquip.setName("contkeepTempEquip");
        this.chkhasLoan.setName("chkhasLoan");
        this.contcustomerPublicPraice.setName("contcustomerPublicPraice");
        this.contcontractMode.setName("contcontractMode");
        this.contpayInAgency.setName("contpayInAgency");
        this.contpaInSupplier.setName("contpaInSupplier");
        this.conteverAgency.setName("conteverAgency");
        this.contdownTempEquip.setName("contdownTempEquip");
        this.contauditTime.setName("contauditTime");
        this.contotherDescription.setName("contotherDescription");
        this.contallScore.setName("contallScore");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.txtfarmerName.setName("txtfarmerName");
        this.txtIDCardNo.setName("txtIDCardNo");
        this.txthomeAddress.setName("txthomeAddress");
        this.txtfarmAddress.setName("txtfarmAddress");
        this.breedExperience.setName("breedExperience");
        this.breedLevel.setName("breedLevel");
        this.henhouseType.setName("henhouseType");
        this.henhouseOwn.setName("henhouseOwn");
        this.breedMode.setName("breedMode");
        this.keepTempEquip.setName("keepTempEquip");
        this.customerPublicPraice.setName("customerPublicPraice");
        this.contractMode.setName("contractMode");
        this.prmtpayInAgency.setName("prmtpayInAgency");
        this.prmtpaInSupplier.setName("prmtpaInSupplier");
        this.prmteverAgency.setName("prmteverAgency");
        this.downTempEquip.setName("downTempEquip");
        this.pkauditTime.setName("pkauditTime");
        this.scrollPaneotherDescription.setName("scrollPaneotherDescription");
        this.txtotherDescription.setName("txtotherDescription");
        this.txtallScore.setName("txtallScore");
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
        // contfarmerName		
        this.contfarmerName.setBoundLabelText(resHelper.getString("contfarmerName.boundLabelText"));		
        this.contfarmerName.setBoundLabelLength(100);		
        this.contfarmerName.setBoundLabelUnderline(true);		
        this.contfarmerName.setVisible(true);
        // contIDCardNo		
        this.contIDCardNo.setBoundLabelText(resHelper.getString("contIDCardNo.boundLabelText"));		
        this.contIDCardNo.setBoundLabelLength(100);		
        this.contIDCardNo.setBoundLabelUnderline(true);		
        this.contIDCardNo.setVisible(true);
        // conthomeAddress		
        this.conthomeAddress.setBoundLabelText(resHelper.getString("conthomeAddress.boundLabelText"));		
        this.conthomeAddress.setBoundLabelLength(100);		
        this.conthomeAddress.setBoundLabelUnderline(true);		
        this.conthomeAddress.setVisible(true);
        // contfarmAddress		
        this.contfarmAddress.setBoundLabelText(resHelper.getString("contfarmAddress.boundLabelText"));		
        this.contfarmAddress.setBoundLabelLength(100);		
        this.contfarmAddress.setBoundLabelUnderline(true);		
        this.contfarmAddress.setVisible(true);
        // contbreedExperience		
        this.contbreedExperience.setBoundLabelText(resHelper.getString("contbreedExperience.boundLabelText"));		
        this.contbreedExperience.setBoundLabelLength(100);		
        this.contbreedExperience.setBoundLabelUnderline(true);		
        this.contbreedExperience.setVisible(true);
        // contbreedLevel		
        this.contbreedLevel.setBoundLabelText(resHelper.getString("contbreedLevel.boundLabelText"));		
        this.contbreedLevel.setBoundLabelLength(100);		
        this.contbreedLevel.setBoundLabelUnderline(true);		
        this.contbreedLevel.setVisible(true);
        // conthenhouseType		
        this.conthenhouseType.setBoundLabelText(resHelper.getString("conthenhouseType.boundLabelText"));		
        this.conthenhouseType.setBoundLabelLength(100);		
        this.conthenhouseType.setBoundLabelUnderline(true);		
        this.conthenhouseType.setVisible(true);
        // conthenhouseOwn		
        this.conthenhouseOwn.setBoundLabelText(resHelper.getString("conthenhouseOwn.boundLabelText"));		
        this.conthenhouseOwn.setBoundLabelLength(100);		
        this.conthenhouseOwn.setBoundLabelUnderline(true);		
        this.conthenhouseOwn.setVisible(true);
        // chkhenhousePledged		
        this.chkhenhousePledged.setText(resHelper.getString("chkhenhousePledged.text"));		
        this.chkhenhousePledged.setVisible(true);		
        this.chkhenhousePledged.setHorizontalAlignment(2);
        // contbreedMode		
        this.contbreedMode.setBoundLabelText(resHelper.getString("contbreedMode.boundLabelText"));		
        this.contbreedMode.setBoundLabelLength(100);		
        this.contbreedMode.setBoundLabelUnderline(true);		
        this.contbreedMode.setVisible(true);
        // contkeepTempEquip		
        this.contkeepTempEquip.setBoundLabelText(resHelper.getString("contkeepTempEquip.boundLabelText"));		
        this.contkeepTempEquip.setBoundLabelLength(100);		
        this.contkeepTempEquip.setBoundLabelUnderline(true);		
        this.contkeepTempEquip.setVisible(true);
        // chkhasLoan		
        this.chkhasLoan.setText(resHelper.getString("chkhasLoan.text"));		
        this.chkhasLoan.setVisible(true);		
        this.chkhasLoan.setHorizontalAlignment(2);
        // contcustomerPublicPraice		
        this.contcustomerPublicPraice.setBoundLabelText(resHelper.getString("contcustomerPublicPraice.boundLabelText"));		
        this.contcustomerPublicPraice.setBoundLabelLength(100);		
        this.contcustomerPublicPraice.setBoundLabelUnderline(true);		
        this.contcustomerPublicPraice.setVisible(true);
        // contcontractMode		
        this.contcontractMode.setBoundLabelText(resHelper.getString("contcontractMode.boundLabelText"));		
        this.contcontractMode.setBoundLabelLength(100);		
        this.contcontractMode.setBoundLabelUnderline(true);		
        this.contcontractMode.setVisible(true);
        // contpayInAgency		
        this.contpayInAgency.setBoundLabelText(resHelper.getString("contpayInAgency.boundLabelText"));		
        this.contpayInAgency.setBoundLabelLength(100);		
        this.contpayInAgency.setBoundLabelUnderline(true);		
        this.contpayInAgency.setVisible(true);
        // contpaInSupplier		
        this.contpaInSupplier.setBoundLabelText(resHelper.getString("contpaInSupplier.boundLabelText"));		
        this.contpaInSupplier.setBoundLabelLength(100);		
        this.contpaInSupplier.setBoundLabelUnderline(true);		
        this.contpaInSupplier.setVisible(true);
        // conteverAgency		
        this.conteverAgency.setBoundLabelText(resHelper.getString("conteverAgency.boundLabelText"));		
        this.conteverAgency.setBoundLabelLength(100);		
        this.conteverAgency.setBoundLabelUnderline(true);		
        this.conteverAgency.setVisible(true);
        // contdownTempEquip		
        this.contdownTempEquip.setBoundLabelText(resHelper.getString("contdownTempEquip.boundLabelText"));		
        this.contdownTempEquip.setBoundLabelLength(100);		
        this.contdownTempEquip.setBoundLabelUnderline(true);		
        this.contdownTempEquip.setVisible(true);
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // contotherDescription		
        this.contotherDescription.setBoundLabelText(resHelper.getString("contotherDescription.boundLabelText"));		
        this.contotherDescription.setBoundLabelLength(100);		
        this.contotherDescription.setBoundLabelUnderline(true);		
        this.contotherDescription.setVisible(true);
        // contallScore		
        this.contallScore.setBoundLabelText(resHelper.getString("contallScore.boundLabelText"));		
        this.contallScore.setBoundLabelLength(100);		
        this.contallScore.setBoundLabelUnderline(true);		
        this.contallScore.setVisible(true);
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
        // txtfarmerName		
        this.txtfarmerName.setVisible(true);		
        this.txtfarmerName.setHorizontalAlignment(2);		
        this.txtfarmerName.setMaxLength(100);		
        this.txtfarmerName.setRequired(false);
        // txtIDCardNo		
        this.txtIDCardNo.setVisible(true);		
        this.txtIDCardNo.setHorizontalAlignment(2);		
        this.txtIDCardNo.setMaxLength(100);		
        this.txtIDCardNo.setRequired(false);
        // txthomeAddress		
        this.txthomeAddress.setVisible(true);		
        this.txthomeAddress.setHorizontalAlignment(2);		
        this.txthomeAddress.setMaxLength(255);		
        this.txthomeAddress.setRequired(false);
        // txtfarmAddress		
        this.txtfarmAddress.setVisible(true);		
        this.txtfarmAddress.setHorizontalAlignment(2);		
        this.txtfarmAddress.setMaxLength(255);		
        this.txtfarmAddress.setRequired(false);
        // breedExperience		
        this.breedExperience.setVisible(true);		
        this.breedExperience.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.farmer.BreedExperience").toArray());		
        this.breedExperience.setRequired(false);
        // breedLevel		
        this.breedLevel.setVisible(true);		
        this.breedLevel.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.farmer.BreedAbility").toArray());		
        this.breedLevel.setRequired(false);
        // henhouseType		
        this.henhouseType.setVisible(true);		
        this.henhouseType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.farmer.HenhouseType").toArray());		
        this.henhouseType.setRequired(false);
        // henhouseOwn		
        this.henhouseOwn.setVisible(true);		
        this.henhouseOwn.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.farmer.HenhouseOwner").toArray());		
        this.henhouseOwn.setRequired(false);
        // breedMode		
        this.breedMode.setVisible(true);		
        this.breedMode.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.farmer.BreedMode").toArray());		
        this.breedMode.setRequired(false);
        // keepTempEquip		
        this.keepTempEquip.setVisible(true);		
        this.keepTempEquip.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.farmer.KeepTempEquip").toArray());		
        this.keepTempEquip.setRequired(false);
        // customerPublicPraice		
        this.customerPublicPraice.setVisible(true);		
        this.customerPublicPraice.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.farmer.PublicPraise").toArray());		
        this.customerPublicPraice.setRequired(false);
        // contractMode		
        this.contractMode.setVisible(true);		
        this.contractMode.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.farmer.ContractMode").toArray());		
        this.contractMode.setRequired(false);
        // prmtpayInAgency		
        this.prmtpayInAgency.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.CustomerInfoQuery");		
        this.prmtpayInAgency.setVisible(true);		
        this.prmtpayInAgency.setEditable(true);		
        this.prmtpayInAgency.setDisplayFormat("$name$");		
        this.prmtpayInAgency.setEditFormat("$number$");		
        this.prmtpayInAgency.setCommitFormat("$number$");		
        this.prmtpayInAgency.setRequired(false);
        // prmtpaInSupplier		
        this.prmtpaInSupplier.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.PSupplierQuery");		
        this.prmtpaInSupplier.setVisible(true);		
        this.prmtpaInSupplier.setEditable(true);		
        this.prmtpaInSupplier.setDisplayFormat("$name$");		
        this.prmtpaInSupplier.setEditFormat("$number$");		
        this.prmtpaInSupplier.setCommitFormat("$number$");		
        this.prmtpaInSupplier.setRequired(false);
        // prmteverAgency		
        this.prmteverAgency.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.CustomerInfoQuery");		
        this.prmteverAgency.setVisible(true);		
        this.prmteverAgency.setEditable(true);		
        this.prmteverAgency.setDisplayFormat("$name$");		
        this.prmteverAgency.setEditFormat("$number$");		
        this.prmteverAgency.setCommitFormat("$number$");		
        this.prmteverAgency.setRequired(false);
        // downTempEquip		
        this.downTempEquip.setVisible(true);		
        this.downTempEquip.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.farmer.DownTempEquip").toArray());		
        this.downTempEquip.setRequired(false);
        // pkauditTime		
        this.pkauditTime.setVisible(true);		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // scrollPaneotherDescription
        // txtotherDescription		
        this.txtotherDescription.setVisible(true);		
        this.txtotherDescription.setRequired(false);		
        this.txtotherDescription.setMaxLength(500);
        // txtallScore		
        this.txtallScore.setVisible(true);		
        this.txtallScore.setHorizontalAlignment(2);		
        this.txtallScore.setMaxLength(200);		
        this.txtallScore.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtfarmerName,txtIDCardNo,txthomeAddress,txtfarmAddress,breedExperience,breedLevel,henhouseType,henhouseOwn,chkhenhousePledged,breedMode,keepTempEquip,downTempEquip,chkhasLoan,customerPublicPraice,contractMode,prmtpayInAgency,prmtpaInSupplier,prmteverAgency,pkauditTime,txtotherDescription,txtallScore}));
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
        contCreator.setBounds(new Rectangle(383, 567, 270, 19));
        this.add(contCreator, null);
        contCreateTime.setBounds(new Rectangle(380, 596, 270, 19));
        this.add(contCreateTime, null);
        contLastUpdateUser.setBounds(new Rectangle(726, 573, 270, 19));
        this.add(contLastUpdateUser, null);
        contLastUpdateTime.setBounds(new Rectangle(728, 597, 270, 19));
        this.add(contLastUpdateTime, null);
        contNumber.setBounds(new Rectangle(21, 15, 270, 19));
        this.add(contNumber, null);
        contBizDate.setBounds(new Rectangle(719, 49, 270, 19));
        this.add(contBizDate, null);
        contDescription.setBounds(new Rectangle(719, 83, 270, 19));
        this.add(contDescription, null);
        contAuditor.setBounds(new Rectangle(19, 569, 270, 19));
        this.add(contAuditor, null);
        contfarmerName.setBounds(new Rectangle(370, 15, 270, 19));
        this.add(contfarmerName, null);
        contIDCardNo.setBounds(new Rectangle(719, 15, 270, 19));
        this.add(contIDCardNo, null);
        conthomeAddress.setBounds(new Rectangle(21, 49, 624, 19));
        this.add(conthomeAddress, null);
        contfarmAddress.setBounds(new Rectangle(21, 83, 625, 19));
        this.add(contfarmAddress, null);
        contbreedExperience.setBounds(new Rectangle(374, 117, 270, 19));
        this.add(contbreedExperience, null);
        contbreedLevel.setBounds(new Rectangle(21, 117, 270, 19));
        this.add(contbreedLevel, null);
        conthenhouseType.setBounds(new Rectangle(21, 185, 270, 19));
        this.add(conthenhouseType, null);
        conthenhouseOwn.setBounds(new Rectangle(21, 151, 270, 19));
        this.add(conthenhouseOwn, null);
        chkhenhousePledged.setBounds(new Rectangle(374, 151, 270, 19));
        this.add(chkhenhousePledged, null);
        contbreedMode.setBounds(new Rectangle(719, 117, 270, 19));
        this.add(contbreedMode, null);
        contkeepTempEquip.setBounds(new Rectangle(374, 185, 270, 19));
        this.add(contkeepTempEquip, null);
        chkhasLoan.setBounds(new Rectangle(719, 151, 270, 19));
        this.add(chkhasLoan, null);
        contcustomerPublicPraice.setBounds(new Rectangle(374, 219, 270, 19));
        this.add(contcustomerPublicPraice, null);
        contcontractMode.setBounds(new Rectangle(21, 219, 270, 19));
        this.add(contcontractMode, null);
        contpayInAgency.setBounds(new Rectangle(374, 253, 270, 19));
        this.add(contpayInAgency, null);
        contpaInSupplier.setBounds(new Rectangle(719, 220, 270, 19));
        this.add(contpaInSupplier, null);
        conteverAgency.setBounds(new Rectangle(21, 253, 270, 19));
        this.add(conteverAgency, null);
        contdownTempEquip.setBounds(new Rectangle(719, 185, 270, 19));
        this.add(contdownTempEquip, null);
        contauditTime.setBounds(new Rectangle(18, 596, 270, 19));
        this.add(contauditTime, null);
        contotherDescription.setBounds(new Rectangle(23, 319, 969, 214));
        this.add(contotherDescription, null);
        contallScore.setBounds(new Rectangle(21, 288, 968, 19));
        this.add(contallScore, null);
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
        //contfarmerName
        contfarmerName.setBoundEditor(txtfarmerName);
        //contIDCardNo
        contIDCardNo.setBoundEditor(txtIDCardNo);
        //conthomeAddress
        conthomeAddress.setBoundEditor(txthomeAddress);
        //contfarmAddress
        contfarmAddress.setBoundEditor(txtfarmAddress);
        //contbreedExperience
        contbreedExperience.setBoundEditor(breedExperience);
        //contbreedLevel
        contbreedLevel.setBoundEditor(breedLevel);
        //conthenhouseType
        conthenhouseType.setBoundEditor(henhouseType);
        //conthenhouseOwn
        conthenhouseOwn.setBoundEditor(henhouseOwn);
        //contbreedMode
        contbreedMode.setBoundEditor(breedMode);
        //contkeepTempEquip
        contkeepTempEquip.setBoundEditor(keepTempEquip);
        //contcustomerPublicPraice
        contcustomerPublicPraice.setBoundEditor(customerPublicPraice);
        //contcontractMode
        contcontractMode.setBoundEditor(contractMode);
        //contpayInAgency
        contpayInAgency.setBoundEditor(prmtpayInAgency);
        //contpaInSupplier
        contpaInSupplier.setBoundEditor(prmtpaInSupplier);
        //conteverAgency
        conteverAgency.setBoundEditor(prmteverAgency);
        //contdownTempEquip
        contdownTempEquip.setBoundEditor(downTempEquip);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contotherDescription
        contotherDescription.setBoundEditor(scrollPaneotherDescription);
        //scrollPaneotherDescription
        scrollPaneotherDescription.getViewport().add(txtotherDescription, null);
        //contallScore
        contallScore.setBoundEditor(txtallScore);

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


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("henhousePledged", boolean.class, this.chkhenhousePledged, "selected");
		dataBinder.registerBinding("hasLoan", boolean.class, this.chkhasLoan, "selected");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("farmerName", String.class, this.txtfarmerName, "text");
		dataBinder.registerBinding("IDCardNo", String.class, this.txtIDCardNo, "text");
		dataBinder.registerBinding("homeAddress", String.class, this.txthomeAddress, "text");
		dataBinder.registerBinding("farmAddress", String.class, this.txtfarmAddress, "text");
		dataBinder.registerBinding("breedExperience", com.kingdee.eas.farm.farmer.BreedExperience.class, this.breedExperience, "selectedItem");
		dataBinder.registerBinding("breedLevel", com.kingdee.eas.farm.farmer.BreedAbility.class, this.breedLevel, "selectedItem");
		dataBinder.registerBinding("henhouseType", com.kingdee.eas.farm.farmer.HenhouseType.class, this.henhouseType, "selectedItem");
		dataBinder.registerBinding("henhouseOwn", com.kingdee.eas.farm.farmer.HenhouseOwner.class, this.henhouseOwn, "selectedItem");
		dataBinder.registerBinding("breedMode", com.kingdee.eas.farm.farmer.BreedMode.class, this.breedMode, "selectedItem");
		dataBinder.registerBinding("keepTempEquip", com.kingdee.eas.farm.farmer.KeepTempEquip.class, this.keepTempEquip, "selectedItem");
		dataBinder.registerBinding("customerPublicPraice", com.kingdee.eas.farm.farmer.PublicPraise.class, this.customerPublicPraice, "selectedItem");
		dataBinder.registerBinding("contractMode", com.kingdee.eas.farm.farmer.ContractMode.class, this.contractMode, "selectedItem");
		dataBinder.registerBinding("payInAgency", com.kingdee.eas.basedata.master.cssp.CustomerInfo.class, this.prmtpayInAgency, "data");
		dataBinder.registerBinding("paInSupplier", com.kingdee.eas.basedata.master.cssp.SupplierInfo.class, this.prmtpaInSupplier, "data");
		dataBinder.registerBinding("everAgency", com.kingdee.eas.basedata.master.cssp.CustomerInfo.class, this.prmteverAgency, "data");
		dataBinder.registerBinding("downTempEquip", com.kingdee.eas.farm.farmer.DownTempEquip.class, this.downTempEquip, "selectedItem");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("otherDescription", String.class, this.txtotherDescription, "text");
		dataBinder.registerBinding("allScore", String.class, this.txtallScore, "text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.farmer.app.FarmerResearchBillEditUIHandler";
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
        this.txtfarmerName.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.farmer.FarmerResearchBillInfo)ov;
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
		getValidateHelper().registerBindProperty("henhousePledged", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hasLoan", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmerName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("IDCardNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("homeAddress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmAddress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedExperience", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedLevel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("henhouseType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("henhouseOwn", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedMode", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("keepTempEquip", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("customerPublicPraice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contractMode", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("payInAgency", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("paInSupplier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("everAgency", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("downTempEquip", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("otherDescription", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allScore", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("henhousePledged"));
        sic.add(new SelectorItemInfo("hasLoan"));
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
        sic.add(new SelectorItemInfo("farmerName"));
        sic.add(new SelectorItemInfo("IDCardNo"));
        sic.add(new SelectorItemInfo("homeAddress"));
        sic.add(new SelectorItemInfo("farmAddress"));
        sic.add(new SelectorItemInfo("breedExperience"));
        sic.add(new SelectorItemInfo("breedLevel"));
        sic.add(new SelectorItemInfo("henhouseType"));
        sic.add(new SelectorItemInfo("henhouseOwn"));
        sic.add(new SelectorItemInfo("breedMode"));
        sic.add(new SelectorItemInfo("keepTempEquip"));
        sic.add(new SelectorItemInfo("customerPublicPraice"));
        sic.add(new SelectorItemInfo("contractMode"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("payInAgency.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("payInAgency.id"));
        	sic.add(new SelectorItemInfo("payInAgency.number"));
        	sic.add(new SelectorItemInfo("payInAgency.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("paInSupplier.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("paInSupplier.id"));
        	sic.add(new SelectorItemInfo("paInSupplier.number"));
        	sic.add(new SelectorItemInfo("paInSupplier.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("everAgency.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("everAgency.id"));
        	sic.add(new SelectorItemInfo("everAgency.number"));
        	sic.add(new SelectorItemInfo("everAgency.name"));
		}
        sic.add(new SelectorItemInfo("downTempEquip"));
        sic.add(new SelectorItemInfo("auditTime"));
        sic.add(new SelectorItemInfo("otherDescription"));
        sic.add(new SelectorItemInfo("allScore"));
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
        return new MetaDataPK("com.kingdee.eas.farm.farmer.client", "FarmerResearchBillEditUI");
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
        return com.kingdee.eas.farm.farmer.client.FarmerResearchBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.farmer.FarmerResearchBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.farmer.FarmerResearchBillInfo objectValue = new com.kingdee.eas.farm.farmer.FarmerResearchBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/farmer/FarmerResearchBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.farmer.app.FarmerResearchBillQuery");
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
		vo.put("breedExperience","0");
vo.put("breedLevel","1");
vo.put("henhouseType","1");
vo.put("henhouseOwn","1");
vo.put("breedMode","1");
vo.put("keepTempEquip","1");
vo.put("contractMode","1");
vo.put("downTempEquip","1");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}