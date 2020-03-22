/**
 * output package name
 */
package com.kingdee.eas.farm.food.client;

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
public abstract class AbstractOutsidePersonRecordBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractOutsidePersonRecordBillEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditTime;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator9;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompanyName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpeopleCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthappenDate;
    protected com.kingdee.bos.ctrl.swing.KDButtonGroup kDButtonGroup1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsendCarTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmealtime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttel;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contresponsible;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfromPosition;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfromTel;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdepartment;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator10;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaddress;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisSendReception;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contadminOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtremark;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtreasons;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel1;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contapplerPerson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contposition;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDComboBox BillStatus;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkAuditTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcompanyName;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpeopleCount;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkhappenDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pksendCarTime;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkmealtime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperson;
    protected com.kingdee.bos.ctrl.swing.KDTextField txttel;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtresponsible;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfromPosition;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfromTel;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtdepartment;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtaddress;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtadminOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkother;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkrefrigerate;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkcorridor;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkworkshop;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkassay;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkbusinessChicken;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkhatch;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkbreedChicken;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkfeedMill;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtapplerPerson;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtposition;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.eas.farm.food.OutsidePersonRecordBillInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractOutsidePersonRecordBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractOutsidePersonRecordBillEditUI.class.getName());
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
        this.contBillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDSeparator9 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contcompanyName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpeopleCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthappenDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDButtonGroup1 = new com.kingdee.bos.ctrl.swing.KDButtonGroup();
        this.contsendCarTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmealtime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttel = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contresponsible = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfromPosition = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfromTel = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdepartment = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator10 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contaddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisSendReception = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contadminOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.txtremark = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.txtreasons = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.kDLabel1 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDLabel2 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.contapplerPerson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contposition = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.BillStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.pkAuditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtcompanyName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtpeopleCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkhappenDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pksendCarTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkmealtime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtperson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txttel = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtresponsible = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtfromPosition = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtfromTel = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtdepartment = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtaddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtadminOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.chkother = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkrefrigerate = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkcorridor = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkworkshop = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkassay = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkbusinessChicken = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkhatch = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkbreedChicken = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkfeedMill = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.prmtapplerPerson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtposition = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.tBtnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.mBtnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.mBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.contBillStatus.setName("contBillStatus");
        this.contAuditTime.setName("contAuditTime");
        this.kDSeparator8.setName("kDSeparator8");
        this.kDSeparator9.setName("kDSeparator9");
        this.contcompanyName.setName("contcompanyName");
        this.contpeopleCount.setName("contpeopleCount");
        this.conthappenDate.setName("conthappenDate");
        this.contsendCarTime.setName("contsendCarTime");
        this.contmealtime.setName("contmealtime");
        this.contperson.setName("contperson");
        this.conttel.setName("conttel");
        this.contresponsible.setName("contresponsible");
        this.contfromPosition.setName("contfromPosition");
        this.contfromTel.setName("contfromTel");
        this.contdepartment.setName("contdepartment");
        this.kDSeparator10.setName("kDSeparator10");
        this.contaddress.setName("contaddress");
        this.chkisSendReception.setName("chkisSendReception");
        this.contadminOrgUnit.setName("contadminOrgUnit");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.txtremark.setName("txtremark");
        this.txtreasons.setName("txtreasons");
        this.kDLabel1.setName("kDLabel1");
        this.kDLabel2.setName("kDLabel2");
        this.contapplerPerson.setName("contapplerPerson");
        this.contposition.setName("contposition");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.BillStatus.setName("BillStatus");
        this.pkAuditTime.setName("pkAuditTime");
        this.txtcompanyName.setName("txtcompanyName");
        this.txtpeopleCount.setName("txtpeopleCount");
        this.pkhappenDate.setName("pkhappenDate");
        this.pksendCarTime.setName("pksendCarTime");
        this.pkmealtime.setName("pkmealtime");
        this.prmtperson.setName("prmtperson");
        this.txttel.setName("txttel");
        this.txtresponsible.setName("txtresponsible");
        this.txtfromPosition.setName("txtfromPosition");
        this.txtfromTel.setName("txtfromTel");
        this.prmtdepartment.setName("prmtdepartment");
        this.txtaddress.setName("txtaddress");
        this.prmtadminOrgUnit.setName("prmtadminOrgUnit");
        this.chkother.setName("chkother");
        this.chkrefrigerate.setName("chkrefrigerate");
        this.chkcorridor.setName("chkcorridor");
        this.chkworkshop.setName("chkworkshop");
        this.chkassay.setName("chkassay");
        this.chkbusinessChicken.setName("chkbusinessChicken");
        this.chkhatch.setName("chkhatch");
        this.chkbreedChicken.setName("chkbreedChicken");
        this.chkfeedMill.setName("chkfeedMill");
        this.prmtapplerPerson.setName("prmtapplerPerson");
        this.prmtposition.setName("prmtposition");
        this.tBtnAudit.setName("tBtnAudit");
        this.tBtnUnAudit.setName("tBtnUnAudit");
        this.mBtnAudit.setName("mBtnAudit");
        this.mBtnUnAudit.setName("mBtnUnAudit");
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
        // contBillStatus		
        this.contBillStatus.setBoundLabelText(resHelper.getString("contBillStatus.boundLabelText"));		
        this.contBillStatus.setBoundLabelLength(100);		
        this.contBillStatus.setBoundLabelUnderline(true);		
        this.contBillStatus.setVisible(true);
        // contAuditTime		
        this.contAuditTime.setBoundLabelText(resHelper.getString("contAuditTime.boundLabelText"));		
        this.contAuditTime.setBoundLabelLength(100);		
        this.contAuditTime.setBoundLabelUnderline(true);		
        this.contAuditTime.setVisible(true);
        // kDSeparator8
        // kDSeparator9
        // contcompanyName		
        this.contcompanyName.setBoundLabelText(resHelper.getString("contcompanyName.boundLabelText"));		
        this.contcompanyName.setBoundLabelLength(70);		
        this.contcompanyName.setBoundLabelUnderline(true);		
        this.contcompanyName.setVisible(true);
        // contpeopleCount		
        this.contpeopleCount.setBoundLabelText(resHelper.getString("contpeopleCount.boundLabelText"));		
        this.contpeopleCount.setBoundLabelLength(100);		
        this.contpeopleCount.setBoundLabelUnderline(true);		
        this.contpeopleCount.setVisible(true);
        // conthappenDate		
        this.conthappenDate.setBoundLabelText(resHelper.getString("conthappenDate.boundLabelText"));		
        this.conthappenDate.setBoundLabelLength(100);		
        this.conthappenDate.setBoundLabelUnderline(true);		
        this.conthappenDate.setVisible(true);
        // kDButtonGroup1
        // contsendCarTime		
        this.contsendCarTime.setBoundLabelText(resHelper.getString("contsendCarTime.boundLabelText"));		
        this.contsendCarTime.setBoundLabelLength(100);		
        this.contsendCarTime.setBoundLabelUnderline(true);		
        this.contsendCarTime.setVisible(true);
        // contmealtime		
        this.contmealtime.setBoundLabelText(resHelper.getString("contmealtime.boundLabelText"));		
        this.contmealtime.setBoundLabelLength(100);		
        this.contmealtime.setBoundLabelUnderline(true);		
        this.contmealtime.setVisible(true);
        // contperson		
        this.contperson.setBoundLabelText(resHelper.getString("contperson.boundLabelText"));		
        this.contperson.setBoundLabelLength(100);		
        this.contperson.setBoundLabelUnderline(true);		
        this.contperson.setVisible(true);
        // conttel		
        this.conttel.setBoundLabelText(resHelper.getString("conttel.boundLabelText"));		
        this.conttel.setBoundLabelLength(100);		
        this.conttel.setBoundLabelUnderline(true);		
        this.conttel.setVisible(true);
        // contresponsible		
        this.contresponsible.setBoundLabelText(resHelper.getString("contresponsible.boundLabelText"));		
        this.contresponsible.setBoundLabelLength(100);		
        this.contresponsible.setBoundLabelUnderline(true);		
        this.contresponsible.setVisible(true);
        // contfromPosition		
        this.contfromPosition.setBoundLabelText(resHelper.getString("contfromPosition.boundLabelText"));		
        this.contfromPosition.setBoundLabelLength(100);		
        this.contfromPosition.setBoundLabelUnderline(true);		
        this.contfromPosition.setVisible(true);
        // contfromTel		
        this.contfromTel.setBoundLabelText(resHelper.getString("contfromTel.boundLabelText"));		
        this.contfromTel.setBoundLabelLength(100);		
        this.contfromTel.setBoundLabelUnderline(true);		
        this.contfromTel.setVisible(true);
        // contdepartment		
        this.contdepartment.setBoundLabelText(resHelper.getString("contdepartment.boundLabelText"));		
        this.contdepartment.setBoundLabelLength(100);		
        this.contdepartment.setBoundLabelUnderline(true);		
        this.contdepartment.setVisible(true);
        // kDSeparator10
        // contaddress		
        this.contaddress.setBoundLabelText(resHelper.getString("contaddress.boundLabelText"));		
        this.contaddress.setBoundLabelLength(100);		
        this.contaddress.setBoundLabelUnderline(true);		
        this.contaddress.setVisible(true);
        // chkisSendReception		
        this.chkisSendReception.setText(resHelper.getString("chkisSendReception.text"));		
        this.chkisSendReception.setVisible(true);		
        this.chkisSendReception.setHorizontalAlignment(2);
        // contadminOrgUnit		
        this.contadminOrgUnit.setBoundLabelText(resHelper.getString("contadminOrgUnit.boundLabelText"));		
        this.contadminOrgUnit.setBoundLabelLength(100);		
        this.contadminOrgUnit.setBoundLabelUnderline(true);		
        this.contadminOrgUnit.setVisible(true);
        // kDPanel1		
        this.kDPanel1.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel1.border.title")));
        // kDPanel2		
        this.kDPanel2.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel2.border.title")));
        // txtremark		
        this.txtremark.setVisible(true);		
        this.txtremark.setRequired(false);		
        this.txtremark.setMaxLength(500);
        // txtreasons		
        this.txtreasons.setVisible(true);		
        this.txtreasons.setRequired(true);		
        this.txtreasons.setMaxLength(500);
        // kDLabel1		
        this.kDLabel1.setText(resHelper.getString("kDLabel1.text"));		
        this.kDLabel1.setForeground(new java.awt.Color(1,1,1));
        // kDLabel2		
        this.kDLabel2.setText(resHelper.getString("kDLabel2.text"));		
        this.kDLabel2.setForeground(new java.awt.Color(74,74,74));
        // contapplerPerson		
        this.contapplerPerson.setBoundLabelText(resHelper.getString("contapplerPerson.boundLabelText"));		
        this.contapplerPerson.setBoundLabelLength(100);		
        this.contapplerPerson.setBoundLabelUnderline(true);		
        this.contapplerPerson.setVisible(true);
        // contposition		
        this.contposition.setBoundLabelText(resHelper.getString("contposition.boundLabelText"));		
        this.contposition.setBoundLabelLength(100);		
        this.contposition.setBoundLabelUnderline(true);		
        this.contposition.setVisible(true);
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
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // BillStatus		
        this.BillStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.BillStatus.setRequired(false);		
        this.BillStatus.setEnabled(false);
        // pkAuditTime		
        this.pkAuditTime.setRequired(false);		
        this.pkAuditTime.setEnabled(false);
        // txtcompanyName		
        this.txtcompanyName.setVisible(true);		
        this.txtcompanyName.setHorizontalAlignment(2);		
        this.txtcompanyName.setMaxLength(255);		
        this.txtcompanyName.setRequired(true);
        // txtpeopleCount		
        this.txtpeopleCount.setVisible(true);		
        this.txtpeopleCount.setHorizontalAlignment(2);		
        this.txtpeopleCount.setDataType(0);		
        this.txtpeopleCount.setSupportedEmpty(true);		
        this.txtpeopleCount.setRequired(true);
        // pkhappenDate		
        this.pkhappenDate.setVisible(true);		
        this.pkhappenDate.setRequired(true);
        // pksendCarTime		
        this.pksendCarTime.setVisible(true);		
        this.pksendCarTime.setRequired(false);
        // pkmealtime		
        this.pkmealtime.setVisible(true);		
        this.pkmealtime.setRequired(false);
        // prmtperson		
        this.prmtperson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtperson.setVisible(true);		
        this.prmtperson.setEditable(true);		
        this.prmtperson.setDisplayFormat("$name$");		
        this.prmtperson.setEditFormat("$number$");		
        this.prmtperson.setCommitFormat("$number$");		
        this.prmtperson.setRequired(true);
        // txttel		
        this.txttel.setVisible(true);		
        this.txttel.setHorizontalAlignment(2);		
        this.txttel.setMaxLength(100);		
        this.txttel.setRequired(false);
        // txtresponsible		
        this.txtresponsible.setVisible(true);		
        this.txtresponsible.setHorizontalAlignment(2);		
        this.txtresponsible.setMaxLength(100);		
        this.txtresponsible.setRequired(false);
        // txtfromPosition		
        this.txtfromPosition.setVisible(true);		
        this.txtfromPosition.setHorizontalAlignment(2);		
        this.txtfromPosition.setMaxLength(100);		
        this.txtfromPosition.setRequired(false);
        // txtfromTel		
        this.txtfromTel.setVisible(true);		
        this.txtfromTel.setHorizontalAlignment(2);		
        this.txtfromTel.setMaxLength(100);		
        this.txtfromTel.setRequired(false);
        // prmtdepartment		
        this.prmtdepartment.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtdepartment.setVisible(true);		
        this.prmtdepartment.setEditable(true);		
        this.prmtdepartment.setDisplayFormat("$name$");		
        this.prmtdepartment.setEditFormat("$number$");		
        this.prmtdepartment.setCommitFormat("$number$");		
        this.prmtdepartment.setRequired(true);
        // txtaddress		
        this.txtaddress.setVisible(true);		
        this.txtaddress.setHorizontalAlignment(2);		
        this.txtaddress.setMaxLength(255);		
        this.txtaddress.setRequired(false);
        // prmtadminOrgUnit		
        this.prmtadminOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtadminOrgUnit.setVisible(true);		
        this.prmtadminOrgUnit.setEditable(true);		
        this.prmtadminOrgUnit.setDisplayFormat("$name$");		
        this.prmtadminOrgUnit.setEditFormat("$number$");		
        this.prmtadminOrgUnit.setCommitFormat("$number$");		
        this.prmtadminOrgUnit.setRequired(true);
        // chkother		
        this.chkother.setText(resHelper.getString("chkother.text"));		
        this.chkother.setVisible(true);		
        this.chkother.setHorizontalAlignment(2);
        // chkrefrigerate		
        this.chkrefrigerate.setText(resHelper.getString("chkrefrigerate.text"));		
        this.chkrefrigerate.setVisible(true);		
        this.chkrefrigerate.setHorizontalAlignment(2);
        // chkcorridor		
        this.chkcorridor.setText(resHelper.getString("chkcorridor.text"));		
        this.chkcorridor.setVisible(true);		
        this.chkcorridor.setHorizontalAlignment(2);
        // chkworkshop		
        this.chkworkshop.setText(resHelper.getString("chkworkshop.text"));		
        this.chkworkshop.setVisible(true);		
        this.chkworkshop.setHorizontalAlignment(2);
        // chkassay		
        this.chkassay.setText(resHelper.getString("chkassay.text"));		
        this.chkassay.setVisible(true);		
        this.chkassay.setHorizontalAlignment(2);
        // chkbusinessChicken		
        this.chkbusinessChicken.setText(resHelper.getString("chkbusinessChicken.text"));		
        this.chkbusinessChicken.setVisible(true);		
        this.chkbusinessChicken.setHorizontalAlignment(2);
        // chkhatch		
        this.chkhatch.setText(resHelper.getString("chkhatch.text"));		
        this.chkhatch.setVisible(true);		
        this.chkhatch.setHorizontalAlignment(2);
        // chkbreedChicken		
        this.chkbreedChicken.setText(resHelper.getString("chkbreedChicken.text"));		
        this.chkbreedChicken.setVisible(true);		
        this.chkbreedChicken.setHorizontalAlignment(2);
        // chkfeedMill		
        this.chkfeedMill.setText(resHelper.getString("chkfeedMill.text"));		
        this.chkfeedMill.setVisible(true);		
        this.chkfeedMill.setHorizontalAlignment(2);
        // prmtapplerPerson		
        this.prmtapplerPerson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtapplerPerson.setVisible(true);		
        this.prmtapplerPerson.setEditable(true);		
        this.prmtapplerPerson.setDisplayFormat("$name$");		
        this.prmtapplerPerson.setEditFormat("$number$");		
        this.prmtapplerPerson.setCommitFormat("$number$");		
        this.prmtapplerPerson.setRequired(true);
        // prmtposition		
        this.prmtposition.setQueryInfo("com.kingdee.eas.basedata.org.app.PositionQuery");		
        this.prmtposition.setVisible(true);		
        this.prmtposition.setEditable(true);		
        this.prmtposition.setDisplayFormat("$name$");		
        this.prmtposition.setEditFormat("$number$");		
        this.prmtposition.setCommitFormat("$number$");		
        this.prmtposition.setRequired(false);
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
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,BillStatus,pkAuditTime,txtcompanyName,txtpeopleCount,pkhappenDate,txtreasons,chkworkshop,chkcorridor,chkrefrigerate,chkother,chkfeedMill,chkbreedChicken,chkhatch,chkbusinessChicken,chkassay,pksendCarTime,pkmealtime,prmtperson,txttel,txtresponsible,txtfromPosition,txtfromTel,prmtdepartment,txtaddress,chkisSendReception,txtremark,prmtadminOrgUnit,prmtapplerPerson,prmtposition}));
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
        this.setBounds(new Rectangle(0, 0, 1060, 644));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1060, 644));
        contCreator.setBounds(new Rectangle(40, 565, 300, 19));
        this.add(contCreator, new KDLayout.Constraints(40, 565, 300, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(40, 596, 300, 19));
        this.add(contCreateTime, new KDLayout.Constraints(40, 596, 300, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(379, 565, 300, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(379, 565, 300, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(379, 596, 300, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(379, 596, 300, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contNumber.setBounds(new Rectangle(40, 19, 300, 19));
        this.add(contNumber, new KDLayout.Constraints(40, 19, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(379, 19, 300, 19));
        this.add(contBizDate, new KDLayout.Constraints(379, 19, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(718, 48, 300, 19));
        this.add(contDescription, new KDLayout.Constraints(718, 48, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(718, 565, 300, 19));
        this.add(contAuditor, new KDLayout.Constraints(718, 565, 300, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contBillStatus.setBounds(new Rectangle(718, 19, 300, 19));
        this.add(contBillStatus, new KDLayout.Constraints(718, 19, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditTime.setBounds(new Rectangle(718, 596, 300, 19));
        this.add(contAuditTime, new KDLayout.Constraints(718, 596, 300, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator8.setBounds(new Rectangle(14, 79, 1014, 8));
        this.add(kDSeparator8, new KDLayout.Constraints(14, 79, 1014, 8, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator9.setBounds(new Rectangle(31, 547, 992, 8));
        this.add(kDSeparator9, new KDLayout.Constraints(31, 547, 992, 8, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompanyName.setBounds(new Rectangle(40, 89, 300, 19));
        this.add(contcompanyName, new KDLayout.Constraints(40, 89, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpeopleCount.setBounds(new Rectangle(379, 89, 300, 19));
        this.add(contpeopleCount, new KDLayout.Constraints(379, 89, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conthappenDate.setBounds(new Rectangle(718, 89, 300, 19));
        this.add(conthappenDate, new KDLayout.Constraints(718, 89, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contsendCarTime.setBounds(new Rectangle(718, 198, 300, 19));
        this.add(contsendCarTime, new KDLayout.Constraints(718, 198, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contmealtime.setBounds(new Rectangle(718, 233, 300, 19));
        this.add(contmealtime, new KDLayout.Constraints(718, 233, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contperson.setBounds(new Rectangle(379, 398, 300, 19));
        this.add(contperson, new KDLayout.Constraints(379, 398, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttel.setBounds(new Rectangle(40, 428, 300, 19));
        this.add(conttel, new KDLayout.Constraints(40, 428, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contresponsible.setBounds(new Rectangle(718, 268, 300, 19));
        this.add(contresponsible, new KDLayout.Constraints(718, 268, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfromPosition.setBounds(new Rectangle(718, 303, 300, 19));
        this.add(contfromPosition, new KDLayout.Constraints(718, 303, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfromTel.setBounds(new Rectangle(718, 339, 300, 19));
        this.add(contfromTel, new KDLayout.Constraints(718, 339, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contdepartment.setBounds(new Rectangle(40, 400, 300, 19));
        this.add(contdepartment, new KDLayout.Constraints(40, 400, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator10.setBounds(new Rectangle(19, 380, 1005, 8));
        this.add(kDSeparator10, new KDLayout.Constraints(19, 380, 1005, 8, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contaddress.setBounds(new Rectangle(379, 428, 300, 19));
        this.add(contaddress, new KDLayout.Constraints(379, 428, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisSendReception.setBounds(new Rectangle(718, 428, 122, 19));
        this.add(chkisSendReception, new KDLayout.Constraints(718, 428, 122, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contadminOrgUnit.setBounds(new Rectangle(40, 48, 300, 19));
        this.add(contadminOrgUnit, new KDLayout.Constraints(40, 48, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDPanel1.setBounds(new Rectangle(40, 196, 266, 170));
        this.add(kDPanel1, new KDLayout.Constraints(40, 196, 266, 170, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDPanel2.setBounds(new Rectangle(333, 196, 353, 170));
        this.add(kDPanel2, new KDLayout.Constraints(333, 196, 353, 170, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        txtremark.setBounds(new Rectangle(40, 484, 982, 56));
        this.add(txtremark, new KDLayout.Constraints(40, 484, 982, 56, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        txtreasons.setBounds(new Rectangle(40, 134, 981, 55));
        this.add(txtreasons, new KDLayout.Constraints(40, 134, 981, 55, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabel1.setBounds(new Rectangle(40, 114, 100, 19));
        this.add(kDLabel1, new KDLayout.Constraints(40, 114, 100, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabel2.setBounds(new Rectangle(40, 461, 230, 19));
        this.add(kDLabel2, new KDLayout.Constraints(40, 461, 230, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contapplerPerson.setBounds(new Rectangle(379, 48, 300, 19));
        this.add(contapplerPerson, new KDLayout.Constraints(379, 48, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contposition.setBounds(new Rectangle(718, 398, 300, 19));
        this.add(contposition, new KDLayout.Constraints(718, 398, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //contBillStatus
        contBillStatus.setBoundEditor(BillStatus);
        //contAuditTime
        contAuditTime.setBoundEditor(pkAuditTime);
        //contcompanyName
        contcompanyName.setBoundEditor(txtcompanyName);
        //contpeopleCount
        contpeopleCount.setBoundEditor(txtpeopleCount);
        //conthappenDate
        conthappenDate.setBoundEditor(pkhappenDate);
        //contsendCarTime
        contsendCarTime.setBoundEditor(pksendCarTime);
        //contmealtime
        contmealtime.setBoundEditor(pkmealtime);
        //contperson
        contperson.setBoundEditor(prmtperson);
        //conttel
        conttel.setBoundEditor(txttel);
        //contresponsible
        contresponsible.setBoundEditor(txtresponsible);
        //contfromPosition
        contfromPosition.setBoundEditor(txtfromPosition);
        //contfromTel
        contfromTel.setBoundEditor(txtfromTel);
        //contdepartment
        contdepartment.setBoundEditor(prmtdepartment);
        //contaddress
        contaddress.setBoundEditor(txtaddress);
        //contadminOrgUnit
        contadminOrgUnit.setBoundEditor(prmtadminOrgUnit);
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(40, 196, 266, 170));        chkother.setBounds(new Rectangle(25, 118, 100, 19));
        kDPanel1.add(chkother, new KDLayout.Constraints(25, 118, 100, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE));
        chkrefrigerate.setBounds(new Rectangle(25, 86, 100, 19));
        kDPanel1.add(chkrefrigerate, new KDLayout.Constraints(25, 86, 100, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE));
        chkcorridor.setBounds(new Rectangle(25, 54, 100, 19));
        kDPanel1.add(chkcorridor, new KDLayout.Constraints(25, 54, 100, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE));
        chkworkshop.setBounds(new Rectangle(25, 22, 100, 19));
        kDPanel1.add(chkworkshop, new KDLayout.Constraints(25, 22, 100, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(333, 196, 353, 170));        chkassay.setBounds(new Rectangle(23, 132, 100, 19));
        kDPanel2.add(chkassay, new KDLayout.Constraints(23, 132, 100, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE));
        chkbusinessChicken.setBounds(new Rectangle(23, 104, 100, 19));
        kDPanel2.add(chkbusinessChicken, new KDLayout.Constraints(23, 104, 100, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE));
        chkhatch.setBounds(new Rectangle(23, 76, 100, 19));
        kDPanel2.add(chkhatch, new KDLayout.Constraints(23, 76, 100, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE));
        chkbreedChicken.setBounds(new Rectangle(23, 48, 100, 19));
        kDPanel2.add(chkbreedChicken, new KDLayout.Constraints(23, 48, 100, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE));
        chkfeedMill.setBounds(new Rectangle(23, 20, 100, 19));
        kDPanel2.add(chkfeedMill, new KDLayout.Constraints(23, 20, 100, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE));
        //contapplerPerson
        contapplerPerson.setBoundEditor(prmtapplerPerson);
        //contposition
        contposition.setBoundEditor(prmtposition);

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
        this.toolBar.add(tBtnAudit);
        this.toolBar.add(tBtnUnAudit);
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
		dataBinder.registerBinding("isSendReception", boolean.class, this.chkisSendReception, "selected");
		dataBinder.registerBinding("remark", String.class, this.txtremark, "text");
		dataBinder.registerBinding("reasons", String.class, this.txtreasons, "text");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("BillStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.BillStatus, "selectedItem");
		dataBinder.registerBinding("AuditTime", java.util.Date.class, this.pkAuditTime, "value");
		dataBinder.registerBinding("companyName", String.class, this.txtcompanyName, "text");
		dataBinder.registerBinding("peopleCount", int.class, this.txtpeopleCount, "value");
		dataBinder.registerBinding("happenDate", java.util.Date.class, this.pkhappenDate, "value");
		dataBinder.registerBinding("sendCarTime", java.util.Date.class, this.pksendCarTime, "value");
		dataBinder.registerBinding("mealtime", java.util.Date.class, this.pkmealtime, "value");
		dataBinder.registerBinding("person", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtperson, "data");
		dataBinder.registerBinding("tel", String.class, this.txttel, "text");
		dataBinder.registerBinding("responsible", String.class, this.txtresponsible, "text");
		dataBinder.registerBinding("fromPosition", String.class, this.txtfromPosition, "text");
		dataBinder.registerBinding("fromTel", String.class, this.txtfromTel, "text");
		dataBinder.registerBinding("department", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtdepartment, "data");
		dataBinder.registerBinding("address", String.class, this.txtaddress, "text");
		dataBinder.registerBinding("adminOrgUnit", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtadminOrgUnit, "data");
		dataBinder.registerBinding("other", boolean.class, this.chkother, "selected");
		dataBinder.registerBinding("refrigerate", boolean.class, this.chkrefrigerate, "selected");
		dataBinder.registerBinding("corridor", boolean.class, this.chkcorridor, "selected");
		dataBinder.registerBinding("workshop", boolean.class, this.chkworkshop, "selected");
		dataBinder.registerBinding("assay", boolean.class, this.chkassay, "selected");
		dataBinder.registerBinding("businessChicken", boolean.class, this.chkbusinessChicken, "selected");
		dataBinder.registerBinding("hatch", boolean.class, this.chkhatch, "selected");
		dataBinder.registerBinding("breedChicken", boolean.class, this.chkbreedChicken, "selected");
		dataBinder.registerBinding("feedMill", boolean.class, this.chkfeedMill, "selected");
		dataBinder.registerBinding("applerPerson", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtapplerPerson, "data");
		dataBinder.registerBinding("position", com.kingdee.eas.basedata.org.PositionInfo.class, this.prmtposition, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.food.app.OutsidePersonRecordBillEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.food.OutsidePersonRecordBillInfo)ov;
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
		getValidateHelper().registerBindProperty("isSendReception", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("reasons", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BillStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AuditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("companyName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("peopleCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("happenDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sendCarTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mealtime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("person", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("tel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("responsible", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fromPosition", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fromTel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("department", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("address", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("adminOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("other", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("refrigerate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("corridor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("workshop", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("assay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("businessChicken", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedChicken", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("feedMill", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("applerPerson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("position", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("isSendReception"));
        sic.add(new SelectorItemInfo("remark"));
        sic.add(new SelectorItemInfo("reasons"));
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
        sic.add(new SelectorItemInfo("BillStatus"));
        sic.add(new SelectorItemInfo("AuditTime"));
        sic.add(new SelectorItemInfo("companyName"));
        sic.add(new SelectorItemInfo("peopleCount"));
        sic.add(new SelectorItemInfo("happenDate"));
        sic.add(new SelectorItemInfo("sendCarTime"));
        sic.add(new SelectorItemInfo("mealtime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("person.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("person.id"));
        	sic.add(new SelectorItemInfo("person.number"));
        	sic.add(new SelectorItemInfo("person.name"));
		}
        sic.add(new SelectorItemInfo("tel"));
        sic.add(new SelectorItemInfo("responsible"));
        sic.add(new SelectorItemInfo("fromPosition"));
        sic.add(new SelectorItemInfo("fromTel"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("department.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("department.id"));
        	sic.add(new SelectorItemInfo("department.number"));
        	sic.add(new SelectorItemInfo("department.name"));
		}
        sic.add(new SelectorItemInfo("address"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("adminOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("adminOrgUnit.id"));
        	sic.add(new SelectorItemInfo("adminOrgUnit.number"));
        	sic.add(new SelectorItemInfo("adminOrgUnit.name"));
		}
        sic.add(new SelectorItemInfo("other"));
        sic.add(new SelectorItemInfo("refrigerate"));
        sic.add(new SelectorItemInfo("corridor"));
        sic.add(new SelectorItemInfo("workshop"));
        sic.add(new SelectorItemInfo("assay"));
        sic.add(new SelectorItemInfo("businessChicken"));
        sic.add(new SelectorItemInfo("hatch"));
        sic.add(new SelectorItemInfo("breedChicken"));
        sic.add(new SelectorItemInfo("feedMill"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("applerPerson.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("applerPerson.id"));
        	sic.add(new SelectorItemInfo("applerPerson.number"));
        	sic.add(new SelectorItemInfo("applerPerson.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("position.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("position.id"));
        	sic.add(new SelectorItemInfo("position.number"));
        	sic.add(new SelectorItemInfo("position.name"));
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
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.food.OutsidePersonRecordBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.food.OutsidePersonRecordBillFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractOutsidePersonRecordBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractOutsidePersonRecordBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.food.client", "OutsidePersonRecordBillEditUI");
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
        return com.kingdee.eas.farm.food.client.OutsidePersonRecordBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.food.OutsidePersonRecordBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.food.OutsidePersonRecordBillInfo objectValue = new com.kingdee.eas.farm.food.OutsidePersonRecordBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/food/OutsidePersonRecordBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.food.app.OutsidePersonRecordBillQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtreasons.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"目的"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtcompanyName.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"公司名称"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtpeopleCount.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"人数"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkhappenDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"来访/结束时间"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtperson.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"接待人"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtdepartment.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"部门"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtadminOrgUnit.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"申请部门"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtapplerPerson.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"申请人"});
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
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}