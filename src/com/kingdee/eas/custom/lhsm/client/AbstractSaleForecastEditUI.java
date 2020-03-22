/**
 * output package name
 */
package com.kingdee.eas.custom.lhsm.client;

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
public abstract class AbstractSaleForecastEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSaleForecastEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcustomer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbeginDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contendDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlinkman;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlinkmanTel;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contwayOfTakingDelivery;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsendAddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsalePerson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsaleGroup;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpayType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsaleOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsaleCustomer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdepartment;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcustomer;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkbeginDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkendDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtlinkman;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtlinkmanTel;
    protected com.kingdee.bos.ctrl.swing.KDComboBox wayOfTakingDelivery;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtsendAddress;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsalePerson;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsaleGroup;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpayType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsaleOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalQty;
    protected com.kingdee.bos.ctrl.swing.KDComboBox state;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsaleCustomer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtdepartment;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnProgressView;
    protected com.kingdee.eas.custom.lhsm.SaleForecastInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionProgressView actionProgressView = null;
    protected ActionViewPro actionViewPro = null;
    /**
     * output class constructor
     */
    public AbstractSaleForecastEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractSaleForecastEditUI.class.getName());
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
        //actionProgressView
        this.actionProgressView = new ActionProgressView(this);
        getActionManager().registerAction("actionProgressView", actionProgressView);
        this.actionProgressView.setExtendProperty("canForewarn", "true");
        this.actionProgressView.setExtendProperty("userDefined", "false");
        this.actionProgressView.setExtendProperty("isObjectUpdateLock", "false");
         this.actionProgressView.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionProgressView.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionViewPro
        this.actionViewPro = new ActionViewPro(this);
        getActionManager().registerAction("actionViewPro", actionViewPro);
        this.actionViewPro.setExtendProperty("canForewarn", "true");
        this.actionViewPro.setExtendProperty("userDefined", "false");
        this.actionViewPro.setExtendProperty("isObjectUpdateLock", "false");
         this.actionViewPro.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionViewPro.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contcustomer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbeginDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contendDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlinkman = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlinkmanTel = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contwayOfTakingDelivery = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsendAddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsalePerson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsaleGroup = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpayType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsaleOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsaleCustomer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdepartment = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcustomer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkbeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkendDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtlinkman = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtlinkmanTel = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.wayOfTakingDelivery = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtsendAddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtsalePerson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtsaleGroup = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtpayType = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtsaleOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txttotalAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttotalQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.state = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtsaleCustomer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtdepartment = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnProgressView = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.kdtEntrys.setName("kdtEntrys");
        this.contcustomer.setName("contcustomer");
        this.contbeginDate.setName("contbeginDate");
        this.contendDate.setName("contendDate");
        this.contlinkman.setName("contlinkman");
        this.contlinkmanTel.setName("contlinkmanTel");
        this.contwayOfTakingDelivery.setName("contwayOfTakingDelivery");
        this.contsendAddress.setName("contsendAddress");
        this.contsalePerson.setName("contsalePerson");
        this.contsaleGroup.setName("contsaleGroup");
        this.contpayType.setName("contpayType");
        this.contcompany.setName("contcompany");
        this.contsaleOrgUnit.setName("contsaleOrgUnit");
        this.conttotalAmount.setName("conttotalAmount");
        this.conttotalQty.setName("conttotalQty");
        this.contstate.setName("contstate");
        this.contauditTime.setName("contauditTime");
        this.contsaleCustomer.setName("contsaleCustomer");
        this.contdepartment.setName("contdepartment");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtcustomer.setName("prmtcustomer");
        this.pkbeginDate.setName("pkbeginDate");
        this.pkendDate.setName("pkendDate");
        this.txtlinkman.setName("txtlinkman");
        this.txtlinkmanTel.setName("txtlinkmanTel");
        this.wayOfTakingDelivery.setName("wayOfTakingDelivery");
        this.txtsendAddress.setName("txtsendAddress");
        this.prmtsalePerson.setName("prmtsalePerson");
        this.prmtsaleGroup.setName("prmtsaleGroup");
        this.prmtpayType.setName("prmtpayType");
        this.prmtcompany.setName("prmtcompany");
        this.prmtsaleOrgUnit.setName("prmtsaleOrgUnit");
        this.txttotalAmount.setName("txttotalAmount");
        this.txttotalQty.setName("txttotalQty");
        this.state.setName("state");
        this.pkauditTime.setName("pkauditTime");
        this.prmtsaleCustomer.setName("prmtsaleCustomer");
        this.prmtdepartment.setName("prmtdepartment");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
        this.btnProgressView.setName("btnProgressView");
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
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>0.00</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol16\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol17\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol18\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol19\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol20\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol22\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol23\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol24\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"materialNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"materialName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"wareHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"measureUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"baseUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"assistUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"assistUnitQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"price\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"internalCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"suttlePrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"srcPrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"premium\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"premiumAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /><t:Column t:key=\"baseQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"basePrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"qtya\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol19\" /><t:Column t:key=\"qtyb\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol20\" /><t:Column t:key=\"company\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"sourceEntryId\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol22\" /><t:Column t:key=\"materialGroup\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol23\" /><t:Column t:key=\"materialGroupB\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol24\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{materialNumber}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{model}</t:Cell><t:Cell>$Resource{wareHouse}</t:Cell><t:Cell>$Resource{measureUnit}</t:Cell><t:Cell>$Resource{baseUnit}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{assistUnit}</t:Cell><t:Cell>$Resource{assistUnitQty}</t:Cell><t:Cell>$Resource{price}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{internalCost}</t:Cell><t:Cell>$Resource{suttlePrice}</t:Cell><t:Cell>$Resource{srcPrice}</t:Cell><t:Cell>$Resource{premium}</t:Cell><t:Cell>$Resource{premiumAmount}</t:Cell><t:Cell>$Resource{baseQty}</t:Cell><t:Cell>$Resource{basePrice}</t:Cell><t:Cell>$Resource{qtya}</t:Cell><t:Cell>$Resource{qtyb}</t:Cell><t:Cell>$Resource{company}</t:Cell><t:Cell>$Resource{sourceEntryId}</t:Cell><t:Cell>$Resource{materialGroup}</t:Cell><t:Cell>$Resource{materialGroupB}</t:Cell><t:Cell>$Resource{remark}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));
        kdtEntrys.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtEntrys_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtEntrys.putBindContents("editData",new String[] {"id","materialNumber","materialName","model","wareHouse","measureUnit","baseUnit","qty","assistUnit","assistUnitQty","price","amount","internalCost","suttlePrice","srcPrice","premium","premiumAmount","baseQty","basePrice","qtya","qtyb","company","sourceEntryId","materialGroup","materialGroupB","remark"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_materialNumber_PromptBox = new KDBizPromptBox();
        kdtEntrys_materialNumber_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtEntrys_materialNumber_PromptBox.setVisible(true);
        kdtEntrys_materialNumber_PromptBox.setEditable(true);
        kdtEntrys_materialNumber_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_materialNumber_PromptBox.setEditFormat("$number$");
        kdtEntrys_materialNumber_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_materialNumber_CellEditor = new KDTDefaultCellEditor(kdtEntrys_materialNumber_PromptBox);
        this.kdtEntrys.getColumn("materialNumber").setEditor(kdtEntrys_materialNumber_CellEditor);
        ObjectValueRender kdtEntrys_materialNumber_OVR = new ObjectValueRender();
        kdtEntrys_materialNumber_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("materialNumber").setRenderer(kdtEntrys_materialNumber_OVR);
        KDTextField kdtEntrys_materialName_TextField = new KDTextField();
        kdtEntrys_materialName_TextField.setName("kdtEntrys_materialName_TextField");
        kdtEntrys_materialName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_materialName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_materialName_TextField);
        this.kdtEntrys.getColumn("materialName").setEditor(kdtEntrys_materialName_CellEditor);
        KDTextField kdtEntrys_model_TextField = new KDTextField();
        kdtEntrys_model_TextField.setName("kdtEntrys_model_TextField");
        kdtEntrys_model_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_model_CellEditor = new KDTDefaultCellEditor(kdtEntrys_model_TextField);
        this.kdtEntrys.getColumn("model").setEditor(kdtEntrys_model_CellEditor);
        final KDBizPromptBox kdtEntrys_wareHouse_PromptBox = new KDBizPromptBox();
        kdtEntrys_wareHouse_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7AllWarehouseQuery");
        kdtEntrys_wareHouse_PromptBox.setVisible(true);
        kdtEntrys_wareHouse_PromptBox.setEditable(true);
        kdtEntrys_wareHouse_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_wareHouse_PromptBox.setEditFormat("$number$");
        kdtEntrys_wareHouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_wareHouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_wareHouse_PromptBox);
        this.kdtEntrys.getColumn("wareHouse").setEditor(kdtEntrys_wareHouse_CellEditor);
        ObjectValueRender kdtEntrys_wareHouse_OVR = new ObjectValueRender();
        kdtEntrys_wareHouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("wareHouse").setRenderer(kdtEntrys_wareHouse_OVR);
        final KDBizPromptBox kdtEntrys_measureUnit_PromptBox = new KDBizPromptBox();
        kdtEntrys_measureUnit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtEntrys_measureUnit_PromptBox.setVisible(true);
        kdtEntrys_measureUnit_PromptBox.setEditable(true);
        kdtEntrys_measureUnit_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_measureUnit_PromptBox.setEditFormat("$number$");
        kdtEntrys_measureUnit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_measureUnit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_measureUnit_PromptBox);
        this.kdtEntrys.getColumn("measureUnit").setEditor(kdtEntrys_measureUnit_CellEditor);
        ObjectValueRender kdtEntrys_measureUnit_OVR = new ObjectValueRender();
        kdtEntrys_measureUnit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("measureUnit").setRenderer(kdtEntrys_measureUnit_OVR);
        final KDBizPromptBox kdtEntrys_baseUnit_PromptBox = new KDBizPromptBox();
        kdtEntrys_baseUnit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtEntrys_baseUnit_PromptBox.setVisible(true);
        kdtEntrys_baseUnit_PromptBox.setEditable(true);
        kdtEntrys_baseUnit_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_baseUnit_PromptBox.setEditFormat("$number$");
        kdtEntrys_baseUnit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_baseUnit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_baseUnit_PromptBox);
        this.kdtEntrys.getColumn("baseUnit").setEditor(kdtEntrys_baseUnit_CellEditor);
        ObjectValueRender kdtEntrys_baseUnit_OVR = new ObjectValueRender();
        kdtEntrys_baseUnit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("baseUnit").setRenderer(kdtEntrys_baseUnit_OVR);
        KDFormattedTextField kdtEntrys_qty_TextField = new KDFormattedTextField();
        kdtEntrys_qty_TextField.setName("kdtEntrys_qty_TextField");
        kdtEntrys_qty_TextField.setVisible(true);
        kdtEntrys_qty_TextField.setEditable(true);
        kdtEntrys_qty_TextField.setHorizontalAlignment(2);
        kdtEntrys_qty_TextField.setDataType(1);
        	kdtEntrys_qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E24"));
        	kdtEntrys_qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E24"));
        kdtEntrys_qty_TextField.setPrecision(4);
        KDTDefaultCellEditor kdtEntrys_qty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qty_TextField);
        this.kdtEntrys.getColumn("qty").setEditor(kdtEntrys_qty_CellEditor);
        final KDBizPromptBox kdtEntrys_assistUnit_PromptBox = new KDBizPromptBox();
        kdtEntrys_assistUnit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtEntrys_assistUnit_PromptBox.setVisible(true);
        kdtEntrys_assistUnit_PromptBox.setEditable(true);
        kdtEntrys_assistUnit_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_assistUnit_PromptBox.setEditFormat("$number$");
        kdtEntrys_assistUnit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_assistUnit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_assistUnit_PromptBox);
        this.kdtEntrys.getColumn("assistUnit").setEditor(kdtEntrys_assistUnit_CellEditor);
        ObjectValueRender kdtEntrys_assistUnit_OVR = new ObjectValueRender();
        kdtEntrys_assistUnit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("assistUnit").setRenderer(kdtEntrys_assistUnit_OVR);
        KDFormattedTextField kdtEntrys_assistUnitQty_TextField = new KDFormattedTextField();
        kdtEntrys_assistUnitQty_TextField.setName("kdtEntrys_assistUnitQty_TextField");
        kdtEntrys_assistUnitQty_TextField.setVisible(true);
        kdtEntrys_assistUnitQty_TextField.setEditable(true);
        kdtEntrys_assistUnitQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_assistUnitQty_TextField.setDataType(1);
        	kdtEntrys_assistUnitQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_assistUnitQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_assistUnitQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_assistUnitQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_assistUnitQty_TextField);
        this.kdtEntrys.getColumn("assistUnitQty").setEditor(kdtEntrys_assistUnitQty_CellEditor);
        KDFormattedTextField kdtEntrys_price_TextField = new KDFormattedTextField();
        kdtEntrys_price_TextField.setName("kdtEntrys_price_TextField");
        kdtEntrys_price_TextField.setVisible(true);
        kdtEntrys_price_TextField.setEditable(true);
        kdtEntrys_price_TextField.setHorizontalAlignment(2);
        kdtEntrys_price_TextField.setDataType(1);
        	kdtEntrys_price_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E22"));
        	kdtEntrys_price_TextField.setMaximumValue(new java.math.BigDecimal("1.0E22"));
        kdtEntrys_price_TextField.setPrecision(6);
        KDTDefaultCellEditor kdtEntrys_price_CellEditor = new KDTDefaultCellEditor(kdtEntrys_price_TextField);
        this.kdtEntrys.getColumn("price").setEditor(kdtEntrys_price_CellEditor);
        KDFormattedTextField kdtEntrys_amount_TextField = new KDFormattedTextField();
        kdtEntrys_amount_TextField.setName("kdtEntrys_amount_TextField");
        kdtEntrys_amount_TextField.setVisible(true);
        kdtEntrys_amount_TextField.setEditable(true);
        kdtEntrys_amount_TextField.setHorizontalAlignment(2);
        kdtEntrys_amount_TextField.setDataType(1);
        	kdtEntrys_amount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_amount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_amount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_amount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_amount_TextField);
        this.kdtEntrys.getColumn("amount").setEditor(kdtEntrys_amount_CellEditor);
        KDFormattedTextField kdtEntrys_internalCost_TextField = new KDFormattedTextField();
        kdtEntrys_internalCost_TextField.setName("kdtEntrys_internalCost_TextField");
        kdtEntrys_internalCost_TextField.setVisible(true);
        kdtEntrys_internalCost_TextField.setEditable(true);
        kdtEntrys_internalCost_TextField.setHorizontalAlignment(2);
        kdtEntrys_internalCost_TextField.setDataType(1);
        	kdtEntrys_internalCost_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_internalCost_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_internalCost_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_internalCost_CellEditor = new KDTDefaultCellEditor(kdtEntrys_internalCost_TextField);
        this.kdtEntrys.getColumn("internalCost").setEditor(kdtEntrys_internalCost_CellEditor);
        KDFormattedTextField kdtEntrys_suttlePrice_TextField = new KDFormattedTextField();
        kdtEntrys_suttlePrice_TextField.setName("kdtEntrys_suttlePrice_TextField");
        kdtEntrys_suttlePrice_TextField.setVisible(true);
        kdtEntrys_suttlePrice_TextField.setEditable(true);
        kdtEntrys_suttlePrice_TextField.setHorizontalAlignment(2);
        kdtEntrys_suttlePrice_TextField.setDataType(1);
        	kdtEntrys_suttlePrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_suttlePrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_suttlePrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_suttlePrice_CellEditor = new KDTDefaultCellEditor(kdtEntrys_suttlePrice_TextField);
        this.kdtEntrys.getColumn("suttlePrice").setEditor(kdtEntrys_suttlePrice_CellEditor);
        KDFormattedTextField kdtEntrys_srcPrice_TextField = new KDFormattedTextField();
        kdtEntrys_srcPrice_TextField.setName("kdtEntrys_srcPrice_TextField");
        kdtEntrys_srcPrice_TextField.setVisible(true);
        kdtEntrys_srcPrice_TextField.setEditable(true);
        kdtEntrys_srcPrice_TextField.setHorizontalAlignment(2);
        kdtEntrys_srcPrice_TextField.setDataType(1);
        	kdtEntrys_srcPrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_srcPrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_srcPrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_srcPrice_CellEditor = new KDTDefaultCellEditor(kdtEntrys_srcPrice_TextField);
        this.kdtEntrys.getColumn("srcPrice").setEditor(kdtEntrys_srcPrice_CellEditor);
        KDFormattedTextField kdtEntrys_premium_TextField = new KDFormattedTextField();
        kdtEntrys_premium_TextField.setName("kdtEntrys_premium_TextField");
        kdtEntrys_premium_TextField.setVisible(true);
        kdtEntrys_premium_TextField.setEditable(true);
        kdtEntrys_premium_TextField.setHorizontalAlignment(2);
        kdtEntrys_premium_TextField.setDataType(1);
        	kdtEntrys_premium_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_premium_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_premium_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_premium_CellEditor = new KDTDefaultCellEditor(kdtEntrys_premium_TextField);
        this.kdtEntrys.getColumn("premium").setEditor(kdtEntrys_premium_CellEditor);
        KDFormattedTextField kdtEntrys_premiumAmount_TextField = new KDFormattedTextField();
        kdtEntrys_premiumAmount_TextField.setName("kdtEntrys_premiumAmount_TextField");
        kdtEntrys_premiumAmount_TextField.setVisible(true);
        kdtEntrys_premiumAmount_TextField.setEditable(true);
        kdtEntrys_premiumAmount_TextField.setHorizontalAlignment(2);
        kdtEntrys_premiumAmount_TextField.setDataType(1);
        	kdtEntrys_premiumAmount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_premiumAmount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_premiumAmount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_premiumAmount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_premiumAmount_TextField);
        this.kdtEntrys.getColumn("premiumAmount").setEditor(kdtEntrys_premiumAmount_CellEditor);
        KDFormattedTextField kdtEntrys_baseQty_TextField = new KDFormattedTextField();
        kdtEntrys_baseQty_TextField.setName("kdtEntrys_baseQty_TextField");
        kdtEntrys_baseQty_TextField.setVisible(true);
        kdtEntrys_baseQty_TextField.setEditable(true);
        kdtEntrys_baseQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_baseQty_TextField.setDataType(1);
        	kdtEntrys_baseQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E24"));
        	kdtEntrys_baseQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E24"));
        kdtEntrys_baseQty_TextField.setPrecision(4);
        KDTDefaultCellEditor kdtEntrys_baseQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_baseQty_TextField);
        this.kdtEntrys.getColumn("baseQty").setEditor(kdtEntrys_baseQty_CellEditor);
        KDFormattedTextField kdtEntrys_basePrice_TextField = new KDFormattedTextField();
        kdtEntrys_basePrice_TextField.setName("kdtEntrys_basePrice_TextField");
        kdtEntrys_basePrice_TextField.setVisible(true);
        kdtEntrys_basePrice_TextField.setEditable(true);
        kdtEntrys_basePrice_TextField.setHorizontalAlignment(2);
        kdtEntrys_basePrice_TextField.setDataType(1);
        	kdtEntrys_basePrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E22"));
        	kdtEntrys_basePrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E22"));
        kdtEntrys_basePrice_TextField.setPrecision(6);
        KDTDefaultCellEditor kdtEntrys_basePrice_CellEditor = new KDTDefaultCellEditor(kdtEntrys_basePrice_TextField);
        this.kdtEntrys.getColumn("basePrice").setEditor(kdtEntrys_basePrice_CellEditor);
        KDFormattedTextField kdtEntrys_qtya_TextField = new KDFormattedTextField();
        kdtEntrys_qtya_TextField.setName("kdtEntrys_qtya_TextField");
        kdtEntrys_qtya_TextField.setVisible(true);
        kdtEntrys_qtya_TextField.setEditable(true);
        kdtEntrys_qtya_TextField.setHorizontalAlignment(2);
        kdtEntrys_qtya_TextField.setDataType(1);
        	kdtEntrys_qtya_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E24"));
        	kdtEntrys_qtya_TextField.setMaximumValue(new java.math.BigDecimal("1.0E24"));
        kdtEntrys_qtya_TextField.setPrecision(4);
        KDTDefaultCellEditor kdtEntrys_qtya_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qtya_TextField);
        this.kdtEntrys.getColumn("qtya").setEditor(kdtEntrys_qtya_CellEditor);
        KDFormattedTextField kdtEntrys_qtyb_TextField = new KDFormattedTextField();
        kdtEntrys_qtyb_TextField.setName("kdtEntrys_qtyb_TextField");
        kdtEntrys_qtyb_TextField.setVisible(true);
        kdtEntrys_qtyb_TextField.setEditable(true);
        kdtEntrys_qtyb_TextField.setHorizontalAlignment(2);
        kdtEntrys_qtyb_TextField.setDataType(1);
        	kdtEntrys_qtyb_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E24"));
        	kdtEntrys_qtyb_TextField.setMaximumValue(new java.math.BigDecimal("1.0E24"));
        kdtEntrys_qtyb_TextField.setPrecision(4);
        KDTDefaultCellEditor kdtEntrys_qtyb_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qtyb_TextField);
        this.kdtEntrys.getColumn("qtyb").setEditor(kdtEntrys_qtyb_CellEditor);
        final KDBizPromptBox kdtEntrys_company_PromptBox = new KDBizPromptBox();
        kdtEntrys_company_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery4AsstAcct");
        kdtEntrys_company_PromptBox.setVisible(true);
        kdtEntrys_company_PromptBox.setEditable(true);
        kdtEntrys_company_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_company_PromptBox.setEditFormat("$number$");
        kdtEntrys_company_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_company_CellEditor = new KDTDefaultCellEditor(kdtEntrys_company_PromptBox);
        this.kdtEntrys.getColumn("company").setEditor(kdtEntrys_company_CellEditor);
        ObjectValueRender kdtEntrys_company_OVR = new ObjectValueRender();
        kdtEntrys_company_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("company").setRenderer(kdtEntrys_company_OVR);
        KDTextField kdtEntrys_sourceEntryId_TextField = new KDTextField();
        kdtEntrys_sourceEntryId_TextField.setName("kdtEntrys_sourceEntryId_TextField");
        kdtEntrys_sourceEntryId_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_sourceEntryId_CellEditor = new KDTDefaultCellEditor(kdtEntrys_sourceEntryId_TextField);
        this.kdtEntrys.getColumn("sourceEntryId").setEditor(kdtEntrys_sourceEntryId_CellEditor);
        KDTextArea kdtEntrys_remark_TextArea = new KDTextArea();
        kdtEntrys_remark_TextArea.setName("kdtEntrys_remark_TextArea");
        kdtEntrys_remark_TextArea.setMaxLength(2000);
        KDTDefaultCellEditor kdtEntrys_remark_CellEditor = new KDTDefaultCellEditor(kdtEntrys_remark_TextArea);
        this.kdtEntrys.getColumn("remark").setEditor(kdtEntrys_remark_CellEditor);
        // contcustomer		
        this.contcustomer.setBoundLabelText(resHelper.getString("contcustomer.boundLabelText"));		
        this.contcustomer.setBoundLabelLength(100);		
        this.contcustomer.setBoundLabelUnderline(true);		
        this.contcustomer.setVisible(true);
        // contbeginDate		
        this.contbeginDate.setBoundLabelText(resHelper.getString("contbeginDate.boundLabelText"));		
        this.contbeginDate.setBoundLabelLength(100);		
        this.contbeginDate.setBoundLabelUnderline(true);		
        this.contbeginDate.setVisible(false);
        // contendDate		
        this.contendDate.setBoundLabelText(resHelper.getString("contendDate.boundLabelText"));		
        this.contendDate.setBoundLabelLength(100);		
        this.contendDate.setBoundLabelUnderline(true);		
        this.contendDate.setVisible(false);
        // contlinkman		
        this.contlinkman.setBoundLabelText(resHelper.getString("contlinkman.boundLabelText"));		
        this.contlinkman.setBoundLabelLength(100);		
        this.contlinkman.setBoundLabelUnderline(true);		
        this.contlinkman.setVisible(true);
        // contlinkmanTel		
        this.contlinkmanTel.setBoundLabelText(resHelper.getString("contlinkmanTel.boundLabelText"));		
        this.contlinkmanTel.setBoundLabelLength(100);		
        this.contlinkmanTel.setBoundLabelUnderline(true);		
        this.contlinkmanTel.setVisible(true);
        // contwayOfTakingDelivery		
        this.contwayOfTakingDelivery.setBoundLabelText(resHelper.getString("contwayOfTakingDelivery.boundLabelText"));		
        this.contwayOfTakingDelivery.setBoundLabelLength(100);		
        this.contwayOfTakingDelivery.setBoundLabelUnderline(true);		
        this.contwayOfTakingDelivery.setVisible(true);
        // contsendAddress		
        this.contsendAddress.setBoundLabelText(resHelper.getString("contsendAddress.boundLabelText"));		
        this.contsendAddress.setBoundLabelLength(100);		
        this.contsendAddress.setBoundLabelUnderline(true);		
        this.contsendAddress.setVisible(true);
        // contsalePerson		
        this.contsalePerson.setBoundLabelText(resHelper.getString("contsalePerson.boundLabelText"));		
        this.contsalePerson.setBoundLabelLength(100);		
        this.contsalePerson.setBoundLabelUnderline(true);		
        this.contsalePerson.setVisible(true);
        // contsaleGroup		
        this.contsaleGroup.setBoundLabelText(resHelper.getString("contsaleGroup.boundLabelText"));		
        this.contsaleGroup.setBoundLabelLength(100);		
        this.contsaleGroup.setBoundLabelUnderline(true);		
        this.contsaleGroup.setVisible(true);
        // contpayType		
        this.contpayType.setBoundLabelText(resHelper.getString("contpayType.boundLabelText"));		
        this.contpayType.setBoundLabelLength(100);		
        this.contpayType.setBoundLabelUnderline(true);		
        this.contpayType.setVisible(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contsaleOrgUnit		
        this.contsaleOrgUnit.setBoundLabelText(resHelper.getString("contsaleOrgUnit.boundLabelText"));		
        this.contsaleOrgUnit.setBoundLabelLength(100);		
        this.contsaleOrgUnit.setBoundLabelUnderline(true);		
        this.contsaleOrgUnit.setVisible(true);
        // conttotalAmount		
        this.conttotalAmount.setBoundLabelText(resHelper.getString("conttotalAmount.boundLabelText"));		
        this.conttotalAmount.setBoundLabelLength(100);		
        this.conttotalAmount.setBoundLabelUnderline(true);		
        this.conttotalAmount.setVisible(true);
        // conttotalQty		
        this.conttotalQty.setBoundLabelText(resHelper.getString("conttotalQty.boundLabelText"));		
        this.conttotalQty.setBoundLabelLength(100);		
        this.conttotalQty.setBoundLabelUnderline(true);		
        this.conttotalQty.setVisible(true);
        // contstate		
        this.contstate.setBoundLabelText(resHelper.getString("contstate.boundLabelText"));		
        this.contstate.setBoundLabelLength(100);		
        this.contstate.setBoundLabelUnderline(true);		
        this.contstate.setVisible(true);
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // contsaleCustomer		
        this.contsaleCustomer.setBoundLabelText(resHelper.getString("contsaleCustomer.boundLabelText"));		
        this.contsaleCustomer.setBoundLabelLength(100);		
        this.contsaleCustomer.setBoundLabelUnderline(true);		
        this.contsaleCustomer.setVisible(true);
        // contdepartment		
        this.contdepartment.setBoundLabelText(resHelper.getString("contdepartment.boundLabelText"));		
        this.contdepartment.setBoundLabelLength(100);		
        this.contdepartment.setBoundLabelUnderline(true);
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
        // prmtcustomer		
        this.prmtcustomer.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.CustomerInfoQuery");		
        this.prmtcustomer.setEditable(true);		
        this.prmtcustomer.setDisplayFormat("$name$");		
        this.prmtcustomer.setEditFormat("$number$");		
        this.prmtcustomer.setCommitFormat("$number$");		
        this.prmtcustomer.setRequired(true);
        // pkbeginDate		
        this.pkbeginDate.setRequired(false);
        // pkendDate		
        this.pkendDate.setRequired(false);
        // txtlinkman		
        this.txtlinkman.setHorizontalAlignment(2);		
        this.txtlinkman.setMaxLength(100);		
        this.txtlinkman.setRequired(false);
        // txtlinkmanTel		
        this.txtlinkmanTel.setHorizontalAlignment(2);		
        this.txtlinkmanTel.setMaxLength(100);		
        this.txtlinkmanTel.setRequired(false);
        // wayOfTakingDelivery		
        this.wayOfTakingDelivery.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.lhsm.WayOfTakingDeliveryEnum").toArray());		
        this.wayOfTakingDelivery.setRequired(false);
        // txtsendAddress		
        this.txtsendAddress.setHorizontalAlignment(2);		
        this.txtsendAddress.setMaxLength(255);		
        this.txtsendAddress.setRequired(false);
        // prmtsalePerson		
        this.prmtsalePerson.setQueryInfo("com.kingdee.eas.basedata.scm.sd.sale.app.F7SalePersonQuery");		
        this.prmtsalePerson.setEditable(true);		
        this.prmtsalePerson.setDisplayFormat("$name$");		
        this.prmtsalePerson.setEditFormat("$number$");		
        this.prmtsalePerson.setCommitFormat("$person.number$");		
        this.prmtsalePerson.setRequired(true);
        // prmtsaleGroup		
        this.prmtsaleGroup.setEditable(true);		
        this.prmtsaleGroup.setDisplayFormat("$name$");		
        this.prmtsaleGroup.setEditFormat("$number$");		
        this.prmtsaleGroup.setCommitFormat("$number$");		
        this.prmtsaleGroup.setRequired(true);
        // prmtpayType		
        this.prmtpayType.setQueryInfo("com.kingdee.eas.basedata.assistant.app.PaymentTypeQuery");		
        this.prmtpayType.setEditable(true);		
        this.prmtpayType.setDisplayFormat("$name$");		
        this.prmtpayType.setEditFormat("$number$");		
        this.prmtpayType.setCommitFormat("$number$");		
        this.prmtpayType.setRequired(false);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);		
        this.prmtcompany.setEnabled(false);
        // prmtsaleOrgUnit		
        this.prmtsaleOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.SaleItemQuery");		
        this.prmtsaleOrgUnit.setEditable(true);		
        this.prmtsaleOrgUnit.setDisplayFormat("$name$");		
        this.prmtsaleOrgUnit.setEditFormat("$number$");		
        this.prmtsaleOrgUnit.setCommitFormat("$number$");		
        this.prmtsaleOrgUnit.setRequired(false);		
        this.prmtsaleOrgUnit.setEnabled(false);
        		setOrgF7(prmtsaleOrgUnit,com.kingdee.eas.basedata.org.OrgType.getEnum("Sale"));
					
        // txttotalAmount		
        this.txttotalAmount.setHorizontalAlignment(2);		
        this.txttotalAmount.setDataType(1);		
        this.txttotalAmount.setSupportedEmpty(true);		
        this.txttotalAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttotalAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttotalAmount.setPrecision(2);		
        this.txttotalAmount.setRequired(false);		
        this.txttotalAmount.setEnabled(false);
        // txttotalQty		
        this.txttotalQty.setHorizontalAlignment(2);		
        this.txttotalQty.setDataType(1);		
        this.txttotalQty.setSupportedEmpty(true);		
        this.txttotalQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttotalQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttotalQty.setPrecision(4);		
        this.txttotalQty.setRequired(false);		
        this.txttotalQty.setEnabled(false);
        // state		
        this.state.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.lhsm.ForecastEnum").toArray());		
        this.state.setRequired(false);		
        this.state.setEnabled(false);
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // prmtsaleCustomer		
        this.prmtsaleCustomer.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.CustomerInfoQuery");		
        this.prmtsaleCustomer.setEditable(true);		
        this.prmtsaleCustomer.setDisplayFormat("$name$");		
        this.prmtsaleCustomer.setEditFormat("$number$");		
        this.prmtsaleCustomer.setCommitFormat("$number$");		
        this.prmtsaleCustomer.setRequired(false);
        // prmtdepartment		
        this.prmtdepartment.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtdepartment.setEditable(true);		
        this.prmtdepartment.setDisplayFormat("$name$");		
        this.prmtdepartment.setEditFormat("$number$");		
        this.prmtdepartment.setCommitFormat("$number$");		
        this.prmtdepartment.setRequired(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        // btnProgressView
        this.btnProgressView.setAction((IItemAction)ActionProxyFactory.getProxy(actionProgressView, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnProgressView.setText(resHelper.getString("btnProgressView.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtcustomer,pkbeginDate,pkendDate,txtlinkman,txtlinkmanTel,wayOfTakingDelivery,txtsendAddress,prmtsalePerson,prmtsaleGroup,prmtpayType,prmtcompany,txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,prmtsaleOrgUnit,txttotalAmount,txttotalQty,state,pkauditTime,prmtsaleCustomer,prmtdepartment,kdtEntrys}));
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
        this.setBounds(new Rectangle(0, 0, 1014, 484));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1014, 484));
        contCreator.setBounds(new Rectangle(12, 419, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(12, 419, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(370, 420, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(370, 420, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(12, 450, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(12, 450, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(370, 448, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(370, 448, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contNumber.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(10, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(730, 85, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(730, 85, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contDescription.setBounds(new Rectangle(10, 110, 630, 19));
        this.add(contDescription, new KDLayout.Constraints(10, 110, 630, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(729, 418, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(729, 418, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kdtEntrys.setBounds(new Rectangle(10, 197, 991, 212));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.custom.lhsm.SaleForecastEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(10, 197, 991, 212, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contcustomer.setBounds(new Rectangle(10, 35, 270, 19));
        this.add(contcustomer, new KDLayout.Constraints(10, 35, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbeginDate.setBounds(new Rectangle(1043, 168, 270, 19));
        this.add(contbeginDate, new KDLayout.Constraints(1043, 168, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contendDate.setBounds(new Rectangle(1042, 197, 270, 19));
        this.add(contendDate, new KDLayout.Constraints(1042, 197, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contlinkman.setBounds(new Rectangle(370, 60, 270, 19));
        this.add(contlinkman, new KDLayout.Constraints(370, 60, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contlinkmanTel.setBounds(new Rectangle(730, 60, 270, 19));
        this.add(contlinkmanTel, new KDLayout.Constraints(730, 60, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contwayOfTakingDelivery.setBounds(new Rectangle(10, 60, 270, 19));
        this.add(contwayOfTakingDelivery, new KDLayout.Constraints(10, 60, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsendAddress.setBounds(new Rectangle(10, 85, 631, 19));
        this.add(contsendAddress, new KDLayout.Constraints(10, 85, 631, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsalePerson.setBounds(new Rectangle(730, 35, 270, 19));
        this.add(contsalePerson, new KDLayout.Constraints(730, 35, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contsaleGroup.setBounds(new Rectangle(370, 35, 270, 19));
        this.add(contsaleGroup, new KDLayout.Constraints(370, 35, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpayType.setBounds(new Rectangle(730, 10, 270, 19));
        this.add(contpayType, new KDLayout.Constraints(730, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompany.setBounds(new Rectangle(730, 110, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(730, 110, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contsaleOrgUnit.setBounds(new Rectangle(730, 135, 270, 19));
        this.add(contsaleOrgUnit, new KDLayout.Constraints(730, 135, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conttotalAmount.setBounds(new Rectangle(370, 135, 270, 19));
        this.add(conttotalAmount, new KDLayout.Constraints(370, 135, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttotalQty.setBounds(new Rectangle(10, 135, 270, 19));
        this.add(conttotalQty, new KDLayout.Constraints(10, 135, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contstate.setBounds(new Rectangle(370, 10, 270, 19));
        this.add(contstate, new KDLayout.Constraints(370, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(729, 448, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(729, 448, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contsaleCustomer.setBounds(new Rectangle(10, 160, 270, 19));
        this.add(contsaleCustomer, new KDLayout.Constraints(10, 160, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdepartment.setBounds(new Rectangle(370, 160, 270, 19));
        this.add(contdepartment, new KDLayout.Constraints(370, 160, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contcustomer
        contcustomer.setBoundEditor(prmtcustomer);
        //contbeginDate
        contbeginDate.setBoundEditor(pkbeginDate);
        //contendDate
        contendDate.setBoundEditor(pkendDate);
        //contlinkman
        contlinkman.setBoundEditor(txtlinkman);
        //contlinkmanTel
        contlinkmanTel.setBoundEditor(txtlinkmanTel);
        //contwayOfTakingDelivery
        contwayOfTakingDelivery.setBoundEditor(wayOfTakingDelivery);
        //contsendAddress
        contsendAddress.setBoundEditor(txtsendAddress);
        //contsalePerson
        contsalePerson.setBoundEditor(prmtsalePerson);
        //contsaleGroup
        contsaleGroup.setBoundEditor(prmtsaleGroup);
        //contpayType
        contpayType.setBoundEditor(prmtpayType);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contsaleOrgUnit
        contsaleOrgUnit.setBoundEditor(prmtsaleOrgUnit);
        //conttotalAmount
        conttotalAmount.setBoundEditor(txttotalAmount);
        //conttotalQty
        conttotalQty.setBoundEditor(txttotalQty);
        //contstate
        contstate.setBoundEditor(state);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contsaleCustomer
        contsaleCustomer.setBoundEditor(prmtsaleCustomer);
        //contdepartment
        contdepartment.setBoundEditor(prmtdepartment);

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
        this.toolBar.add(btnNumberSign);
        this.toolBar.add(btnViewSignature);
        this.toolBar.add(separatorFW4);
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
        this.toolBar.add(btnProgressView);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.custom.lhsm.SaleForecastEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.materialNumber", java.lang.Object.class, this.kdtEntrys, "materialNumber.text");
		dataBinder.registerBinding("entrys.materialName", String.class, this.kdtEntrys, "materialName.text");
		dataBinder.registerBinding("entrys.measureUnit", java.lang.Object.class, this.kdtEntrys, "measureUnit.text");
		dataBinder.registerBinding("entrys.baseQty", java.math.BigDecimal.class, this.kdtEntrys, "baseQty.text");
		dataBinder.registerBinding("entrys.qty", java.math.BigDecimal.class, this.kdtEntrys, "qty.text");
		dataBinder.registerBinding("entrys.qtya", java.math.BigDecimal.class, this.kdtEntrys, "qtya.text");
		dataBinder.registerBinding("entrys.qtyb", java.math.BigDecimal.class, this.kdtEntrys, "qtyb.text");
		dataBinder.registerBinding("entrys.price", java.math.BigDecimal.class, this.kdtEntrys, "price.text");
		dataBinder.registerBinding("entrys.amount", java.math.BigDecimal.class, this.kdtEntrys, "amount.text");
		dataBinder.registerBinding("entrys.basePrice", java.math.BigDecimal.class, this.kdtEntrys, "basePrice.text");
		dataBinder.registerBinding("entrys.baseUnit", java.lang.Object.class, this.kdtEntrys, "baseUnit.text");
		dataBinder.registerBinding("entrys.company", java.lang.Object.class, this.kdtEntrys, "company.text");
		dataBinder.registerBinding("entrys.sourceEntryId", String.class, this.kdtEntrys, "sourceEntryId.text");
		dataBinder.registerBinding("entrys.premium", java.math.BigDecimal.class, this.kdtEntrys, "premium.text");
		dataBinder.registerBinding("entrys.model", String.class, this.kdtEntrys, "model.text");
		dataBinder.registerBinding("entrys.assistUnit", java.lang.Object.class, this.kdtEntrys, "assistUnit.text");
		dataBinder.registerBinding("entrys.assistUnitQty", java.math.BigDecimal.class, this.kdtEntrys, "assistUnitQty.text");
		dataBinder.registerBinding("entrys.internalCost", java.math.BigDecimal.class, this.kdtEntrys, "internalCost.text");
		dataBinder.registerBinding("entrys.suttlePrice", java.math.BigDecimal.class, this.kdtEntrys, "suttlePrice.text");
		dataBinder.registerBinding("entrys.wareHouse", java.lang.Object.class, this.kdtEntrys, "wareHouse.text");
		dataBinder.registerBinding("entrys.materialGroup", java.lang.Object.class, this.kdtEntrys, "materialGroup.text");
		dataBinder.registerBinding("entrys.materialGroupB", java.lang.Object.class, this.kdtEntrys, "materialGroupB.text");
		dataBinder.registerBinding("entrys.srcPrice", java.math.BigDecimal.class, this.kdtEntrys, "srcPrice.text");
		dataBinder.registerBinding("entrys.premiumAmount", java.math.BigDecimal.class, this.kdtEntrys, "premiumAmount.text");
		dataBinder.registerBinding("entrys.remark", String.class, this.kdtEntrys, "remark.text");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("customer", com.kingdee.eas.basedata.master.cssp.CustomerInfo.class, this.prmtcustomer, "data");
		dataBinder.registerBinding("beginDate", java.util.Date.class, this.pkbeginDate, "value");
		dataBinder.registerBinding("endDate", java.util.Date.class, this.pkendDate, "value");
		dataBinder.registerBinding("linkman", String.class, this.txtlinkman, "text");
		dataBinder.registerBinding("linkmanTel", String.class, this.txtlinkmanTel, "text");
		dataBinder.registerBinding("wayOfTakingDelivery", com.kingdee.eas.custom.lhsm.WayOfTakingDeliveryEnum.class, this.wayOfTakingDelivery, "selectedItem");
		dataBinder.registerBinding("sendAddress", String.class, this.txtsendAddress, "text");
		dataBinder.registerBinding("salePerson", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtsalePerson, "data");
		dataBinder.registerBinding("saleGroup", com.kingdee.eas.basedata.scm.sd.sale.SaleGroupInfo.class, this.prmtsaleGroup, "data");
		dataBinder.registerBinding("payType", com.kingdee.eas.basedata.assistant.PaymentTypeInfo.class, this.prmtpayType, "data");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("saleOrgUnit", com.kingdee.eas.basedata.org.SaleOrgUnitInfo.class, this.prmtsaleOrgUnit, "data");
		dataBinder.registerBinding("totalAmount", java.math.BigDecimal.class, this.txttotalAmount, "value");
		dataBinder.registerBinding("totalQty", java.math.BigDecimal.class, this.txttotalQty, "value");
		dataBinder.registerBinding("state", com.kingdee.eas.custom.lhsm.ForecastEnum.class, this.state, "selectedItem");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("saleCustomer", com.kingdee.eas.basedata.master.cssp.CustomerInfo.class, this.prmtsaleCustomer, "data");
		dataBinder.registerBinding("department", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtdepartment, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.lhsm.app.SaleForecastEditUIHandler";
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
        this.prmtcustomer.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.lhsm.SaleForecastInfo)ov;
    }
    protected void removeByPK(IObjectPK pk) throws Exception {
    	IObjectValue editData = this.editData;
    	super.removeByPK(pk);
    	recycleNumberByOrg(editData,"Sale",editData.getString("number"));
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
			return com.kingdee.eas.basedata.org.OrgType.getEnum("Sale");
		}

	protected KDBizPromptBox getMainBizOrg() {
		return prmtsaleOrgUnit;
}


    /**
     * output loadFields method
     */
    public void loadFields()
    {
        		setAutoNumberByOrg("Sale");
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
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.materialNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.materialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.measureUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.baseQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qtya", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qtyb", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.price", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.basePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.baseUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sourceEntryId", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.premium", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.model", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.assistUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.assistUnitQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.internalCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.suttlePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.wareHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.materialGroup", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.materialGroupB", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.srcPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.premiumAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("customer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("beginDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("endDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("linkman", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("linkmanTel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("wayOfTakingDelivery", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sendAddress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("salePerson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("saleGroup", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("payType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("saleOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("state", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("saleCustomer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("department", ValidateHelper.ON_SAVE);    		
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
     * output kdtEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("materialNumber".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"model").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"materialNumber").getValue(),"model")));

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
    	sic.add(new SelectorItemInfo("entrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.materialNumber.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.materialNumber.id"));
			sic.add(new SelectorItemInfo("entrys.materialNumber.number"));
			sic.add(new SelectorItemInfo("entrys.materialNumber.name"));
		}
    	sic.add(new SelectorItemInfo("entrys.materialName"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.measureUnit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.measureUnit.id"));
			sic.add(new SelectorItemInfo("entrys.measureUnit.name"));
        	sic.add(new SelectorItemInfo("entrys.measureUnit.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.baseQty"));
    	sic.add(new SelectorItemInfo("entrys.qty"));
    	sic.add(new SelectorItemInfo("entrys.qtya"));
    	sic.add(new SelectorItemInfo("entrys.qtyb"));
    	sic.add(new SelectorItemInfo("entrys.price"));
    	sic.add(new SelectorItemInfo("entrys.amount"));
    	sic.add(new SelectorItemInfo("entrys.basePrice"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.baseUnit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.baseUnit.id"));
			sic.add(new SelectorItemInfo("entrys.baseUnit.name"));
        	sic.add(new SelectorItemInfo("entrys.baseUnit.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.company.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.company.id"));
			sic.add(new SelectorItemInfo("entrys.company.name"));
        	sic.add(new SelectorItemInfo("entrys.company.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.sourceEntryId"));
    	sic.add(new SelectorItemInfo("entrys.premium"));
    	sic.add(new SelectorItemInfo("entrys.model"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.assistUnit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.assistUnit.id"));
			sic.add(new SelectorItemInfo("entrys.assistUnit.name"));
        	sic.add(new SelectorItemInfo("entrys.assistUnit.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.assistUnitQty"));
    	sic.add(new SelectorItemInfo("entrys.internalCost"));
    	sic.add(new SelectorItemInfo("entrys.suttlePrice"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.wareHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.wareHouse.id"));
			sic.add(new SelectorItemInfo("entrys.wareHouse.name"));
        	sic.add(new SelectorItemInfo("entrys.wareHouse.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.materialGroup.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.materialGroup.id"));
			sic.add(new SelectorItemInfo("entrys.materialGroup.name"));
        	sic.add(new SelectorItemInfo("entrys.materialGroup.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.materialGroupB.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.materialGroupB.id"));
			sic.add(new SelectorItemInfo("entrys.materialGroupB.name"));
        	sic.add(new SelectorItemInfo("entrys.materialGroupB.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.srcPrice"));
    	sic.add(new SelectorItemInfo("entrys.premiumAmount"));
    	sic.add(new SelectorItemInfo("entrys.remark"));
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
			sic.add(new SelectorItemInfo("customer.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("customer.id"));
        	sic.add(new SelectorItemInfo("customer.number"));
        	sic.add(new SelectorItemInfo("customer.name"));
		}
        sic.add(new SelectorItemInfo("beginDate"));
        sic.add(new SelectorItemInfo("endDate"));
        sic.add(new SelectorItemInfo("linkman"));
        sic.add(new SelectorItemInfo("linkmanTel"));
        sic.add(new SelectorItemInfo("wayOfTakingDelivery"));
        sic.add(new SelectorItemInfo("sendAddress"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("salePerson.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("salePerson.id"));
        	sic.add(new SelectorItemInfo("salePerson.number"));
        	sic.add(new SelectorItemInfo("salePerson.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("saleGroup.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("saleGroup.id"));
        	sic.add(new SelectorItemInfo("saleGroup.number"));
        	sic.add(new SelectorItemInfo("saleGroup.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("payType.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("payType.id"));
        	sic.add(new SelectorItemInfo("payType.number"));
        	sic.add(new SelectorItemInfo("payType.name"));
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
			sic.add(new SelectorItemInfo("saleOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("saleOrgUnit.id"));
        	sic.add(new SelectorItemInfo("saleOrgUnit.number"));
        	sic.add(new SelectorItemInfo("saleOrgUnit.name"));
		}
        sic.add(new SelectorItemInfo("totalAmount"));
        sic.add(new SelectorItemInfo("totalQty"));
        sic.add(new SelectorItemInfo("state"));
        sic.add(new SelectorItemInfo("auditTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("saleCustomer.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("saleCustomer.id"));
        	sic.add(new SelectorItemInfo("saleCustomer.number"));
        	sic.add(new SelectorItemInfo("saleCustomer.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("department.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("department.id"));
        	sic.add(new SelectorItemInfo("department.number"));
        	sic.add(new SelectorItemInfo("department.name"));
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
        com.kingdee.eas.custom.lhsm.SaleForecastFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.lhsm.SaleForecastFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionProgressView_actionPerformed method
     */
    public void actionProgressView_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.lhsm.SaleForecastFactory.getRemoteInstance().progressView(editData);
    }
    	

    /**
     * output actionViewPro_actionPerformed method
     */
    public void actionViewPro_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.lhsm.SaleForecastFactory.getRemoteInstance().viewPro(editData);
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
	public RequestContext prepareActionProgressView(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionProgressView() {
    	return false;
    }
	public RequestContext prepareActionViewPro(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionViewPro() {
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
            innerActionPerformed("eas", AbstractSaleForecastEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractSaleForecastEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionProgressView class
     */     
    protected class ActionProgressView extends ItemAction {     
    
        public ActionProgressView()
        {
            this(null);
        }

        public ActionProgressView(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionProgressView.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionProgressView.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionProgressView.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractSaleForecastEditUI.this, "ActionProgressView", "actionProgressView_actionPerformed", e);
        }
    }

    /**
     * output ActionViewPro class
     */     
    protected class ActionViewPro extends ItemAction {     
    
        public ActionViewPro()
        {
            this(null);
        }

        public ActionViewPro(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionViewPro.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionViewPro.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionViewPro.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractSaleForecastEditUI.this, "ActionViewPro", "actionViewPro_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.lhsm.client", "SaleForecastEditUI");
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
        return com.kingdee.eas.custom.lhsm.client.SaleForecastEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.lhsm.SaleForecastFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.lhsm.SaleForecastInfo objectValue = new com.kingdee.eas.custom.lhsm.SaleForecastInfo();
				if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Sale")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Sale")).getBoolean("isBizUnit"))
			objectValue.put("saleOrgUnit",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Sale")));
 
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/lhsm/SaleForecast";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.lhsm.app.SaleForecastQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"materialNumber").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"物料编码"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"wareHouse").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"仓库"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"measureUnit").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"计量单位"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"qty").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"数量"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"company").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"意向公司"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcustomer.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"购货客户"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtsalePerson.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"销售员"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtsaleGroup.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"销售组"});
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
        return kdtEntrys;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("wayOfTakingDelivery","1");
		vo.put("totalAmount",new java.math.BigDecimal(0));
		vo.put("totalQty",new java.math.BigDecimal(0));
vo.put("state","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}