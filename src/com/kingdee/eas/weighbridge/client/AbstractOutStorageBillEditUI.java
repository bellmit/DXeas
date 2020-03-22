/**
 * output package name
 */
package com.kingdee.eas.weighbridge.client;

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
public abstract class AbstractOutStorageBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractOutStorageBillEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcar;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoutTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttareWeight;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtDetail;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtDetail_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contorderStorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcustomer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweighman;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbizType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweighType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contorderComopany;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisAutoCreateToInvBill;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcarNum;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcar;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkinTime;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkoutTime;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttareWeight;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstorageOrgUnit;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtorderStorageOrgUnit;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcustomer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtweighman;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDComboBox bizType;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.swing.KDComboBox weighType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtorderComopany;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcarNum;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.eas.weighbridge.OutStorageBillInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractOutStorageBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractOutStorageBillEditUI.class.getName());
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
        //actionNumberSign
        actionNumberSign.setEnabled(true);
        actionNumberSign.setDaemonRun(false);

        _tempStr = resHelper.getString("ActionNumberSign.SHORT_DESCRIPTION");
        actionNumberSign.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionNumberSign.LONG_DESCRIPTION");
        actionNumberSign.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionNumberSign.NAME");
        actionNumberSign.putValue(ItemAction.NAME, _tempStr);
        this.actionNumberSign.setExtendProperty("userDefined", "false");
        this.actionNumberSign.setExtendProperty("isObjectUpdateLock", "false");
         this.actionNumberSign.addService(new com.kingdee.eas.framework.client.service.PermissionService());
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
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contcar = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoutTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttareWeight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtDetail = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contstorageOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contorderStorageOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcustomer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweighman = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbizType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweighType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contorderComopany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisAutoCreateToInvBill = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contcarNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcar = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkinTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkoutTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txttareWeight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtstorageOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtorderStorageOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcustomer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtweighman = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.bizType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.weighType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtorderComopany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtcarNum = new com.kingdee.bos.ctrl.swing.KDTextField();
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
        this.kdtEntrys.setName("kdtEntrys");
        this.contcar.setName("contcar");
        this.continTime.setName("continTime");
        this.contoutTime.setName("contoutTime");
        this.conttareWeight.setName("conttareWeight");
        this.kdtDetail.setName("kdtDetail");
        this.contstorageOrgUnit.setName("contstorageOrgUnit");
        this.contorderStorageOrgUnit.setName("contorderStorageOrgUnit");
        this.contcustomer.setName("contcustomer");
        this.contweighman.setName("contweighman");
        this.contauditTime.setName("contauditTime");
        this.contbizType.setName("contbizType");
        this.contbillStatus.setName("contbillStatus");
        this.contweighType.setName("contweighType");
        this.contcompany.setName("contcompany");
        this.contorderComopany.setName("contorderComopany");
        this.chkisAutoCreateToInvBill.setName("chkisAutoCreateToInvBill");
        this.contcarNum.setName("contcarNum");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtcar.setName("prmtcar");
        this.pkinTime.setName("pkinTime");
        this.pkoutTime.setName("pkoutTime");
        this.txttareWeight.setName("txttareWeight");
        this.prmtstorageOrgUnit.setName("prmtstorageOrgUnit");
        this.prmtorderStorageOrgUnit.setName("prmtorderStorageOrgUnit");
        this.prmtcustomer.setName("prmtcustomer");
        this.prmtweighman.setName("prmtweighman");
        this.pkauditTime.setName("pkauditTime");
        this.bizType.setName("bizType");
        this.billStatus.setName("billStatus");
        this.weighType.setName("weighType");
        this.prmtcompany.setName("prmtcompany");
        this.prmtorderComopany.setName("prmtorderComopany");
        this.txtcarNum.setName("txtcarNum");
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
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"mateiralName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"Unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"tare\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"gross\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"tare2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"tempSuttle\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"suttle\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"actualSuttle\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"weighTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"weighTimeGross\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"weighTime2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"suttleDiff\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{mateiralName}</t:Cell><t:Cell>$Resource{model}</t:Cell><t:Cell>$Resource{Unit}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{tare}</t:Cell><t:Cell>$Resource{gross}</t:Cell><t:Cell>$Resource{tare2}</t:Cell><t:Cell>$Resource{tempSuttle}</t:Cell><t:Cell>$Resource{suttle}</t:Cell><t:Cell>$Resource{actualSuttle}</t:Cell><t:Cell>$Resource{weighTime}</t:Cell><t:Cell>$Resource{weighTimeGross}</t:Cell><t:Cell>$Resource{weighTime2}</t:Cell><t:Cell>$Resource{suttleDiff}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtEntrys.putBindContents("editData",new String[] {"id","material","mateiralName","model","Unit","qty","tare","gross","tare2","tempSuttle","suttle","actualSuttle","weighTime","weighTimeGross","weighTime2","suttleDiff"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_material_PromptBox = new KDBizPromptBox();
        kdtEntrys_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtEntrys_material_PromptBox.setVisible(true);
        kdtEntrys_material_PromptBox.setEditable(true);
        kdtEntrys_material_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_material_PromptBox.setEditFormat("$number$");
        kdtEntrys_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_material_CellEditor = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox);
        this.kdtEntrys.getColumn("material").setEditor(kdtEntrys_material_CellEditor);
        ObjectValueRender kdtEntrys_material_OVR = new ObjectValueRender();
        kdtEntrys_material_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("material").setRenderer(kdtEntrys_material_OVR);
        KDTextField kdtEntrys_mateiralName_TextField = new KDTextField();
        kdtEntrys_mateiralName_TextField.setName("kdtEntrys_mateiralName_TextField");
        kdtEntrys_mateiralName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_mateiralName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_mateiralName_TextField);
        this.kdtEntrys.getColumn("mateiralName").setEditor(kdtEntrys_mateiralName_CellEditor);
        KDTextField kdtEntrys_model_TextField = new KDTextField();
        kdtEntrys_model_TextField.setName("kdtEntrys_model_TextField");
        kdtEntrys_model_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_model_CellEditor = new KDTDefaultCellEditor(kdtEntrys_model_TextField);
        this.kdtEntrys.getColumn("model").setEditor(kdtEntrys_model_CellEditor);
        final KDBizPromptBox kdtEntrys_Unit_PromptBox = new KDBizPromptBox();
        kdtEntrys_Unit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtEntrys_Unit_PromptBox.setVisible(true);
        kdtEntrys_Unit_PromptBox.setEditable(true);
        kdtEntrys_Unit_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_Unit_PromptBox.setEditFormat("$number$");
        kdtEntrys_Unit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_Unit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_Unit_PromptBox);
        this.kdtEntrys.getColumn("Unit").setEditor(kdtEntrys_Unit_CellEditor);
        ObjectValueRender kdtEntrys_Unit_OVR = new ObjectValueRender();
        kdtEntrys_Unit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("Unit").setRenderer(kdtEntrys_Unit_OVR);
        KDFormattedTextField kdtEntrys_qty_TextField = new KDFormattedTextField();
        kdtEntrys_qty_TextField.setName("kdtEntrys_qty_TextField");
        kdtEntrys_qty_TextField.setVisible(true);
        kdtEntrys_qty_TextField.setEditable(true);
        kdtEntrys_qty_TextField.setHorizontalAlignment(2);
        kdtEntrys_qty_TextField.setDataType(1);
        	kdtEntrys_qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_qty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qty_TextField);
        this.kdtEntrys.getColumn("qty").setEditor(kdtEntrys_qty_CellEditor);
        KDFormattedTextField kdtEntrys_tare_TextField = new KDFormattedTextField();
        kdtEntrys_tare_TextField.setName("kdtEntrys_tare_TextField");
        kdtEntrys_tare_TextField.setVisible(true);
        kdtEntrys_tare_TextField.setEditable(true);
        kdtEntrys_tare_TextField.setHorizontalAlignment(2);
        kdtEntrys_tare_TextField.setDataType(1);
        	kdtEntrys_tare_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_tare_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_tare_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_tare_CellEditor = new KDTDefaultCellEditor(kdtEntrys_tare_TextField);
        this.kdtEntrys.getColumn("tare").setEditor(kdtEntrys_tare_CellEditor);
        KDFormattedTextField kdtEntrys_gross_TextField = new KDFormattedTextField();
        kdtEntrys_gross_TextField.setName("kdtEntrys_gross_TextField");
        kdtEntrys_gross_TextField.setVisible(true);
        kdtEntrys_gross_TextField.setEditable(true);
        kdtEntrys_gross_TextField.setHorizontalAlignment(2);
        kdtEntrys_gross_TextField.setDataType(1);
        	kdtEntrys_gross_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_gross_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_gross_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_gross_CellEditor = new KDTDefaultCellEditor(kdtEntrys_gross_TextField);
        this.kdtEntrys.getColumn("gross").setEditor(kdtEntrys_gross_CellEditor);
        KDFormattedTextField kdtEntrys_tare2_TextField = new KDFormattedTextField();
        kdtEntrys_tare2_TextField.setName("kdtEntrys_tare2_TextField");
        kdtEntrys_tare2_TextField.setVisible(true);
        kdtEntrys_tare2_TextField.setEditable(true);
        kdtEntrys_tare2_TextField.setHorizontalAlignment(2);
        kdtEntrys_tare2_TextField.setDataType(1);
        	kdtEntrys_tare2_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_tare2_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_tare2_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_tare2_CellEditor = new KDTDefaultCellEditor(kdtEntrys_tare2_TextField);
        this.kdtEntrys.getColumn("tare2").setEditor(kdtEntrys_tare2_CellEditor);
        KDFormattedTextField kdtEntrys_tempSuttle_TextField = new KDFormattedTextField();
        kdtEntrys_tempSuttle_TextField.setName("kdtEntrys_tempSuttle_TextField");
        kdtEntrys_tempSuttle_TextField.setVisible(true);
        kdtEntrys_tempSuttle_TextField.setEditable(true);
        kdtEntrys_tempSuttle_TextField.setHorizontalAlignment(2);
        kdtEntrys_tempSuttle_TextField.setDataType(1);
        	kdtEntrys_tempSuttle_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_tempSuttle_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_tempSuttle_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_tempSuttle_CellEditor = new KDTDefaultCellEditor(kdtEntrys_tempSuttle_TextField);
        this.kdtEntrys.getColumn("tempSuttle").setEditor(kdtEntrys_tempSuttle_CellEditor);
        KDFormattedTextField kdtEntrys_suttle_TextField = new KDFormattedTextField();
        kdtEntrys_suttle_TextField.setName("kdtEntrys_suttle_TextField");
        kdtEntrys_suttle_TextField.setVisible(true);
        kdtEntrys_suttle_TextField.setEditable(true);
        kdtEntrys_suttle_TextField.setHorizontalAlignment(2);
        kdtEntrys_suttle_TextField.setDataType(1);
        	kdtEntrys_suttle_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_suttle_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_suttle_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_suttle_CellEditor = new KDTDefaultCellEditor(kdtEntrys_suttle_TextField);
        this.kdtEntrys.getColumn("suttle").setEditor(kdtEntrys_suttle_CellEditor);
        KDFormattedTextField kdtEntrys_actualSuttle_TextField = new KDFormattedTextField();
        kdtEntrys_actualSuttle_TextField.setName("kdtEntrys_actualSuttle_TextField");
        kdtEntrys_actualSuttle_TextField.setVisible(true);
        kdtEntrys_actualSuttle_TextField.setEditable(true);
        kdtEntrys_actualSuttle_TextField.setHorizontalAlignment(2);
        kdtEntrys_actualSuttle_TextField.setDataType(1);
        	kdtEntrys_actualSuttle_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_actualSuttle_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_actualSuttle_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_actualSuttle_CellEditor = new KDTDefaultCellEditor(kdtEntrys_actualSuttle_TextField);
        this.kdtEntrys.getColumn("actualSuttle").setEditor(kdtEntrys_actualSuttle_CellEditor);
        KDDatePicker kdtEntrys_weighTime_DatePicker = new KDDatePicker();
        kdtEntrys_weighTime_DatePicker.setName("kdtEntrys_weighTime_DatePicker");
        kdtEntrys_weighTime_DatePicker.setVisible(true);
        kdtEntrys_weighTime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_weighTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_weighTime_DatePicker);
        this.kdtEntrys.getColumn("weighTime").setEditor(kdtEntrys_weighTime_CellEditor);
        KDDatePicker kdtEntrys_weighTimeGross_DatePicker = new KDDatePicker();
        kdtEntrys_weighTimeGross_DatePicker.setName("kdtEntrys_weighTimeGross_DatePicker");
        kdtEntrys_weighTimeGross_DatePicker.setVisible(true);
        kdtEntrys_weighTimeGross_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_weighTimeGross_CellEditor = new KDTDefaultCellEditor(kdtEntrys_weighTimeGross_DatePicker);
        this.kdtEntrys.getColumn("weighTimeGross").setEditor(kdtEntrys_weighTimeGross_CellEditor);
        KDDatePicker kdtEntrys_weighTime2_DatePicker = new KDDatePicker();
        kdtEntrys_weighTime2_DatePicker.setName("kdtEntrys_weighTime2_DatePicker");
        kdtEntrys_weighTime2_DatePicker.setVisible(true);
        kdtEntrys_weighTime2_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_weighTime2_CellEditor = new KDTDefaultCellEditor(kdtEntrys_weighTime2_DatePicker);
        this.kdtEntrys.getColumn("weighTime2").setEditor(kdtEntrys_weighTime2_CellEditor);
        KDFormattedTextField kdtEntrys_suttleDiff_TextField = new KDFormattedTextField();
        kdtEntrys_suttleDiff_TextField.setName("kdtEntrys_suttleDiff_TextField");
        kdtEntrys_suttleDiff_TextField.setVisible(true);
        kdtEntrys_suttleDiff_TextField.setEditable(true);
        kdtEntrys_suttleDiff_TextField.setHorizontalAlignment(2);
        kdtEntrys_suttleDiff_TextField.setDataType(1);
        	kdtEntrys_suttleDiff_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_suttleDiff_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_suttleDiff_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_suttleDiff_CellEditor = new KDTDefaultCellEditor(kdtEntrys_suttleDiff_TextField);
        this.kdtEntrys.getColumn("suttleDiff").setEditor(kdtEntrys_suttleDiff_CellEditor);
        // contcar		
        this.contcar.setBoundLabelText(resHelper.getString("contcar.boundLabelText"));		
        this.contcar.setBoundLabelLength(100);		
        this.contcar.setBoundLabelUnderline(true);		
        this.contcar.setVisible(true);
        // continTime		
        this.continTime.setBoundLabelText(resHelper.getString("continTime.boundLabelText"));		
        this.continTime.setBoundLabelLength(100);		
        this.continTime.setBoundLabelUnderline(true);		
        this.continTime.setVisible(true);
        // contoutTime		
        this.contoutTime.setBoundLabelText(resHelper.getString("contoutTime.boundLabelText"));		
        this.contoutTime.setBoundLabelLength(100);		
        this.contoutTime.setBoundLabelUnderline(true);		
        this.contoutTime.setVisible(true);
        // conttareWeight		
        this.conttareWeight.setBoundLabelText(resHelper.getString("conttareWeight.boundLabelText"));		
        this.conttareWeight.setBoundLabelLength(100);		
        this.conttareWeight.setBoundLabelUnderline(true);		
        this.conttareWeight.setVisible(true);
        // kdtDetail
		String kdtDetailStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"billType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"1\" /><t:Column t:key=\"sourceBillNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"2\" /><t:Column t:key=\"sourceEntrySeq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"3\" /><t:Column t:key=\"sourceEntryQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" t:styleID=\"sCol4\" /><t:Column t:key=\"weighQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"orderStorageOrg\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"sourceEntryBag\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"materialNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" /><t:Column t:key=\"mateiralName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"9\" /><t:Column t:key=\"model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"10\" /><t:Column t:key=\"customerName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"customerNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{billType}</t:Cell><t:Cell>$Resource{sourceBillNum}</t:Cell><t:Cell>$Resource{sourceEntrySeq}</t:Cell><t:Cell>$Resource{sourceEntryQty}</t:Cell><t:Cell>$Resource{weighQty}</t:Cell><t:Cell>$Resource{orderStorageOrg}</t:Cell><t:Cell>$Resource{sourceEntryBag}</t:Cell><t:Cell>$Resource{materialNum}</t:Cell><t:Cell>$Resource{mateiralName}</t:Cell><t:Cell>$Resource{model}</t:Cell><t:Cell>$Resource{customerName}</t:Cell><t:Cell>$Resource{customerNum}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtDetail.setFormatXml(resHelper.translateString("kdtDetail",kdtDetailStrXML));

                this.kdtDetail.putBindContents("editData",new String[] {"Detail.seq","Detail.billType","Detail.sourceBillNum","Detail.sourceEntrySeq","Detail.sourceEntryQty","Detail.weighQty","Detail.orderStorageOrg","Detail.sourceEntryBag","Detail.materialNum","Detail.mateiralName","Detail.model","Detail.customerName","Detail.customerNum"});


        this.kdtDetail.checkParsed();
        KDFormattedTextField kdtDetail_seq_TextField = new KDFormattedTextField();
        kdtDetail_seq_TextField.setName("kdtDetail_seq_TextField");
        kdtDetail_seq_TextField.setVisible(true);
        kdtDetail_seq_TextField.setEditable(true);
        kdtDetail_seq_TextField.setHorizontalAlignment(2);
        kdtDetail_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtDetail_seq_CellEditor = new KDTDefaultCellEditor(kdtDetail_seq_TextField);
        this.kdtDetail.getColumn("seq").setEditor(kdtDetail_seq_CellEditor);
        final KDBizPromptBox kdtDetail_billType_PromptBox = new KDBizPromptBox();
        kdtDetail_billType_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.common.app.F7BillTypeQuery");
        kdtDetail_billType_PromptBox.setVisible(true);
        kdtDetail_billType_PromptBox.setEditable(true);
        kdtDetail_billType_PromptBox.setDisplayFormat("$number$");
        kdtDetail_billType_PromptBox.setEditFormat("$number$");
        kdtDetail_billType_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtDetail_billType_CellEditor = new KDTDefaultCellEditor(kdtDetail_billType_PromptBox);
        this.kdtDetail.getColumn("billType").setEditor(kdtDetail_billType_CellEditor);
        ObjectValueRender kdtDetail_billType_OVR = new ObjectValueRender();
        kdtDetail_billType_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtDetail.getColumn("billType").setRenderer(kdtDetail_billType_OVR);
        KDTextField kdtDetail_sourceBillNum_TextField = new KDTextField();
        kdtDetail_sourceBillNum_TextField.setName("kdtDetail_sourceBillNum_TextField");
        kdtDetail_sourceBillNum_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtDetail_sourceBillNum_CellEditor = new KDTDefaultCellEditor(kdtDetail_sourceBillNum_TextField);
        this.kdtDetail.getColumn("sourceBillNum").setEditor(kdtDetail_sourceBillNum_CellEditor);
        KDTextField kdtDetail_sourceEntrySeq_TextField = new KDTextField();
        kdtDetail_sourceEntrySeq_TextField.setName("kdtDetail_sourceEntrySeq_TextField");
        kdtDetail_sourceEntrySeq_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtDetail_sourceEntrySeq_CellEditor = new KDTDefaultCellEditor(kdtDetail_sourceEntrySeq_TextField);
        this.kdtDetail.getColumn("sourceEntrySeq").setEditor(kdtDetail_sourceEntrySeq_CellEditor);
        KDFormattedTextField kdtDetail_sourceEntryQty_TextField = new KDFormattedTextField();
        kdtDetail_sourceEntryQty_TextField.setName("kdtDetail_sourceEntryQty_TextField");
        kdtDetail_sourceEntryQty_TextField.setVisible(true);
        kdtDetail_sourceEntryQty_TextField.setEditable(true);
        kdtDetail_sourceEntryQty_TextField.setHorizontalAlignment(2);
        kdtDetail_sourceEntryQty_TextField.setDataType(1);
        	kdtDetail_sourceEntryQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtDetail_sourceEntryQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtDetail_sourceEntryQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtDetail_sourceEntryQty_CellEditor = new KDTDefaultCellEditor(kdtDetail_sourceEntryQty_TextField);
        this.kdtDetail.getColumn("sourceEntryQty").setEditor(kdtDetail_sourceEntryQty_CellEditor);
        KDFormattedTextField kdtDetail_weighQty_TextField = new KDFormattedTextField();
        kdtDetail_weighQty_TextField.setName("kdtDetail_weighQty_TextField");
        kdtDetail_weighQty_TextField.setVisible(true);
        kdtDetail_weighQty_TextField.setEditable(true);
        kdtDetail_weighQty_TextField.setHorizontalAlignment(2);
        kdtDetail_weighQty_TextField.setDataType(1);
        	kdtDetail_weighQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtDetail_weighQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtDetail_weighQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtDetail_weighQty_CellEditor = new KDTDefaultCellEditor(kdtDetail_weighQty_TextField);
        this.kdtDetail.getColumn("weighQty").setEditor(kdtDetail_weighQty_CellEditor);
        final KDBizPromptBox kdtDetail_orderStorageOrg_PromptBox = new KDBizPromptBox();
        kdtDetail_orderStorageOrg_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");
        kdtDetail_orderStorageOrg_PromptBox.setVisible(true);
        kdtDetail_orderStorageOrg_PromptBox.setEditable(true);
        kdtDetail_orderStorageOrg_PromptBox.setDisplayFormat("$number$");
        kdtDetail_orderStorageOrg_PromptBox.setEditFormat("$number$");
        kdtDetail_orderStorageOrg_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtDetail_orderStorageOrg_CellEditor = new KDTDefaultCellEditor(kdtDetail_orderStorageOrg_PromptBox);
        this.kdtDetail.getColumn("orderStorageOrg").setEditor(kdtDetail_orderStorageOrg_CellEditor);
        ObjectValueRender kdtDetail_orderStorageOrg_OVR = new ObjectValueRender();
        kdtDetail_orderStorageOrg_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtDetail.getColumn("orderStorageOrg").setRenderer(kdtDetail_orderStorageOrg_OVR);
        KDFormattedTextField kdtDetail_sourceEntryBag_TextField = new KDFormattedTextField();
        kdtDetail_sourceEntryBag_TextField.setName("kdtDetail_sourceEntryBag_TextField");
        kdtDetail_sourceEntryBag_TextField.setVisible(true);
        kdtDetail_sourceEntryBag_TextField.setEditable(true);
        kdtDetail_sourceEntryBag_TextField.setHorizontalAlignment(2);
        kdtDetail_sourceEntryBag_TextField.setDataType(1);
        	kdtDetail_sourceEntryBag_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtDetail_sourceEntryBag_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtDetail_sourceEntryBag_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtDetail_sourceEntryBag_CellEditor = new KDTDefaultCellEditor(kdtDetail_sourceEntryBag_TextField);
        this.kdtDetail.getColumn("sourceEntryBag").setEditor(kdtDetail_sourceEntryBag_CellEditor);
        KDTextField kdtDetail_materialNum_TextField = new KDTextField();
        kdtDetail_materialNum_TextField.setName("kdtDetail_materialNum_TextField");
        kdtDetail_materialNum_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtDetail_materialNum_CellEditor = new KDTDefaultCellEditor(kdtDetail_materialNum_TextField);
        this.kdtDetail.getColumn("materialNum").setEditor(kdtDetail_materialNum_CellEditor);
        KDTextField kdtDetail_mateiralName_TextField = new KDTextField();
        kdtDetail_mateiralName_TextField.setName("kdtDetail_mateiralName_TextField");
        kdtDetail_mateiralName_TextField.setMaxLength(200);
        KDTDefaultCellEditor kdtDetail_mateiralName_CellEditor = new KDTDefaultCellEditor(kdtDetail_mateiralName_TextField);
        this.kdtDetail.getColumn("mateiralName").setEditor(kdtDetail_mateiralName_CellEditor);
        KDTextField kdtDetail_model_TextField = new KDTextField();
        kdtDetail_model_TextField.setName("kdtDetail_model_TextField");
        kdtDetail_model_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtDetail_model_CellEditor = new KDTDefaultCellEditor(kdtDetail_model_TextField);
        this.kdtDetail.getColumn("model").setEditor(kdtDetail_model_CellEditor);
        KDTextField kdtDetail_customerName_TextField = new KDTextField();
        kdtDetail_customerName_TextField.setName("kdtDetail_customerName_TextField");
        kdtDetail_customerName_TextField.setMaxLength(200);
        KDTDefaultCellEditor kdtDetail_customerName_CellEditor = new KDTDefaultCellEditor(kdtDetail_customerName_TextField);
        this.kdtDetail.getColumn("customerName").setEditor(kdtDetail_customerName_CellEditor);
        KDTextField kdtDetail_customerNum_TextField = new KDTextField();
        kdtDetail_customerNum_TextField.setName("kdtDetail_customerNum_TextField");
        kdtDetail_customerNum_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtDetail_customerNum_CellEditor = new KDTDefaultCellEditor(kdtDetail_customerNum_TextField);
        this.kdtDetail.getColumn("customerNum").setEditor(kdtDetail_customerNum_CellEditor);
        // contstorageOrgUnit		
        this.contstorageOrgUnit.setBoundLabelText(resHelper.getString("contstorageOrgUnit.boundLabelText"));		
        this.contstorageOrgUnit.setBoundLabelLength(100);		
        this.contstorageOrgUnit.setBoundLabelUnderline(true);		
        this.contstorageOrgUnit.setVisible(true);
        // contorderStorageOrgUnit		
        this.contorderStorageOrgUnit.setBoundLabelText(resHelper.getString("contorderStorageOrgUnit.boundLabelText"));		
        this.contorderStorageOrgUnit.setBoundLabelLength(100);		
        this.contorderStorageOrgUnit.setBoundLabelUnderline(true);		
        this.contorderStorageOrgUnit.setVisible(true);
        // contcustomer		
        this.contcustomer.setBoundLabelText(resHelper.getString("contcustomer.boundLabelText"));		
        this.contcustomer.setBoundLabelLength(100);		
        this.contcustomer.setBoundLabelUnderline(true);		
        this.contcustomer.setVisible(true);
        // contweighman		
        this.contweighman.setBoundLabelText(resHelper.getString("contweighman.boundLabelText"));		
        this.contweighman.setBoundLabelLength(100);		
        this.contweighman.setBoundLabelUnderline(true);		
        this.contweighman.setVisible(true);
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // contbizType		
        this.contbizType.setBoundLabelText(resHelper.getString("contbizType.boundLabelText"));		
        this.contbizType.setBoundLabelLength(100);		
        this.contbizType.setBoundLabelUnderline(true);		
        this.contbizType.setVisible(true);
        // contbillStatus		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);
        // contweighType		
        this.contweighType.setBoundLabelText(resHelper.getString("contweighType.boundLabelText"));		
        this.contweighType.setBoundLabelLength(100);		
        this.contweighType.setBoundLabelUnderline(true);		
        this.contweighType.setVisible(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contorderComopany		
        this.contorderComopany.setBoundLabelText(resHelper.getString("contorderComopany.boundLabelText"));		
        this.contorderComopany.setBoundLabelLength(100);		
        this.contorderComopany.setBoundLabelUnderline(true);		
        this.contorderComopany.setVisible(true);
        // chkisAutoCreateToInvBill		
        this.chkisAutoCreateToInvBill.setHorizontalAlignment(2);		
        this.chkisAutoCreateToInvBill.setText(resHelper.getString("chkisAutoCreateToInvBill.text"));
        // contcarNum		
        this.contcarNum.setBoundLabelText(resHelper.getString("contcarNum.boundLabelText"));		
        this.contcarNum.setBoundLabelLength(100);		
        this.contcarNum.setBoundLabelUnderline(true);		
        this.contcarNum.setVisible(true);
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
        // prmtcar		
        this.prmtcar.setQueryInfo("com.kingdee.eas.publicdata.app.CarQuery");		
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
					
        prmtcar.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtcar_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // pkinTime		
        this.pkinTime.setRequired(false);
        // pkoutTime		
        this.pkoutTime.setRequired(false);
        // txttareWeight		
        this.txttareWeight.setHorizontalAlignment(2);		
        this.txttareWeight.setDataType(1);		
        this.txttareWeight.setSupportedEmpty(true);		
        this.txttareWeight.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttareWeight.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttareWeight.setPrecision(4);		
        this.txttareWeight.setRequired(false);
        // prmtstorageOrgUnit		
        this.prmtstorageOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtstorageOrgUnit.setEditable(true);		
        this.prmtstorageOrgUnit.setDisplayFormat("$name$");		
        this.prmtstorageOrgUnit.setEditFormat("$number$");		
        this.prmtstorageOrgUnit.setCommitFormat("$number$");		
        this.prmtstorageOrgUnit.setRequired(false);
        // prmtorderStorageOrgUnit		
        this.prmtorderStorageOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtorderStorageOrgUnit.setEditable(true);		
        this.prmtorderStorageOrgUnit.setDisplayFormat("$name$");		
        this.prmtorderStorageOrgUnit.setEditFormat("$number$");		
        this.prmtorderStorageOrgUnit.setCommitFormat("$number$");		
        this.prmtorderStorageOrgUnit.setRequired(false);
        // prmtcustomer		
        this.prmtcustomer.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.CustomerInfoQuery");		
        this.prmtcustomer.setEditable(true);		
        this.prmtcustomer.setDisplayFormat("$name$");		
        this.prmtcustomer.setEditFormat("$number$");		
        this.prmtcustomer.setCommitFormat("$number$");		
        this.prmtcustomer.setRequired(false);
        // prmtweighman		
        this.prmtweighman.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtweighman.setEditable(true);		
        this.prmtweighman.setDisplayFormat("$name$");		
        this.prmtweighman.setEditFormat("$number$");		
        this.prmtweighman.setCommitFormat("$number$");		
        this.prmtweighman.setRequired(false);
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // bizType		
        this.bizType.addItems(EnumUtils.getEnumList("com.kingdee.eas.weighbridge.WeighBizType").toArray());		
        this.bizType.setRequired(false);
        // billStatus		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.weighbridge.WeighBaseStatus").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // weighType		
        this.weighType.addItems(EnumUtils.getEnumList("com.kingdee.eas.weighbridge.WeighBaseType").toArray());		
        this.weighType.setRequired(false);
        // prmtcompany		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
        // prmtorderComopany		
        this.prmtorderComopany.setEditable(true);		
        this.prmtorderComopany.setDisplayFormat("$name$");		
        this.prmtorderComopany.setEditFormat("$number$");		
        this.prmtorderComopany.setCommitFormat("$number$");		
        this.prmtorderComopany.setRequired(false);
        // txtcarNum		
        this.txtcarNum.setHorizontalAlignment(2);		
        this.txtcarNum.setMaxLength(100);		
        this.txtcarNum.setRequired(false);
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
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {kdtDetail,chkisAutoCreateToInvBill,prmtcar,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,pkinTime,pkoutTime,txttareWeight,prmtstorageOrgUnit,prmtorderStorageOrgUnit,prmtcustomer,prmtweighman,pkauditTime,bizType,billStatus,weighType,prmtorderComopany,prmtcompany,txtcarNum,kdtEntrys}));
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
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1013, 629));
        contCreator.setBounds(new Rectangle(354, 524, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(354, 524, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(676, 524, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(676, 524, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(354, 555, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(354, 555, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(676, 555, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(676, 555, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(33, 9, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(33, 9, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(351, 9, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(351, 9, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(33, 185, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(33, 185, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(33, 528, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(33, 528, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(33, 212, 913, 126));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.weighbridge.OutStorageBillEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(33, 212, 913, 126, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contcar.setBounds(new Rectangle(33, 79, 270, 19));
        this.add(contcar, new KDLayout.Constraints(33, 79, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        continTime.setBounds(new Rectangle(351, 81, 270, 19));
        this.add(continTime, new KDLayout.Constraints(351, 81, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoutTime.setBounds(new Rectangle(676, 81, 270, 19));
        this.add(contoutTime, new KDLayout.Constraints(676, 81, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conttareWeight.setBounds(new Rectangle(33, 149, 270, 19));
        this.add(conttareWeight, new KDLayout.Constraints(33, 149, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtDetail.setBounds(new Rectangle(34, 347, 913, 155));
        kdtDetail_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtDetail,new com.kingdee.eas.weighbridge.OutStorageBillEntryDetailInfo(),null,false);
        this.add(kdtDetail_detailPanel, new KDLayout.Constraints(34, 347, 913, 155, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contstorageOrgUnit.setBounds(new Rectangle(676, 45, 270, 19));
        this.add(contstorageOrgUnit, new KDLayout.Constraints(676, 45, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contorderStorageOrgUnit.setBounds(new Rectangle(351, 45, 270, 19));
        this.add(contorderStorageOrgUnit, new KDLayout.Constraints(351, 45, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcustomer.setBounds(new Rectangle(351, 45, 270, 19));
        this.add(contcustomer, new KDLayout.Constraints(351, 45, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contweighman.setBounds(new Rectangle(676, 117, 270, 19));
        this.add(contweighman, new KDLayout.Constraints(676, 117, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contauditTime.setBounds(new Rectangle(33, 555, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(33, 555, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbizType.setBounds(new Rectangle(33, 44, 270, 19));
        this.add(contbizType, new KDLayout.Constraints(33, 44, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(676, 9, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(676, 9, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contweighType.setBounds(new Rectangle(351, 117, 270, 19));
        this.add(contweighType, new KDLayout.Constraints(351, 117, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompany.setBounds(new Rectangle(351, 154, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(351, 154, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contorderComopany.setBounds(new Rectangle(676, 154, 270, 19));
        this.add(contorderComopany, new KDLayout.Constraints(676, 154, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkisAutoCreateToInvBill.setBounds(new Rectangle(351, 185, 270, 19));
        this.add(chkisAutoCreateToInvBill, new KDLayout.Constraints(351, 185, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcarNum.setBounds(new Rectangle(33, 114, 270, 19));
        this.add(contcarNum, new KDLayout.Constraints(33, 114, 270, 19, 0));
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
        //contcar
        contcar.setBoundEditor(prmtcar);
        //continTime
        continTime.setBoundEditor(pkinTime);
        //contoutTime
        contoutTime.setBoundEditor(pkoutTime);
        //conttareWeight
        conttareWeight.setBoundEditor(txttareWeight);
        //contstorageOrgUnit
        contstorageOrgUnit.setBoundEditor(prmtstorageOrgUnit);
        //contorderStorageOrgUnit
        contorderStorageOrgUnit.setBoundEditor(prmtorderStorageOrgUnit);
        //contcustomer
        contcustomer.setBoundEditor(prmtcustomer);
        //contweighman
        contweighman.setBoundEditor(prmtweighman);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contbizType
        contbizType.setBoundEditor(bizType);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //contweighType
        contweighType.setBoundEditor(weighType);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contorderComopany
        contorderComopany.setBoundEditor(prmtorderComopany);
        //contcarNum
        contcarNum.setBoundEditor(txtcarNum);

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
        menuBiz.add(menuItemDelVoucher);
        menuBiz.add(MenuItemVoucher);
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
        this.toolBar.add(tBtnAudit);
        this.toolBar.add(tBtnUnAudit);
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
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.weighbridge.OutStorageBillEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.material", java.lang.Object.class, this.kdtEntrys, "material.text");
		dataBinder.registerBinding("entrys.mateiralName", String.class, this.kdtEntrys, "mateiralName.text");
		dataBinder.registerBinding("entrys.model", String.class, this.kdtEntrys, "model.text");
		dataBinder.registerBinding("entrys.Unit", java.lang.Object.class, this.kdtEntrys, "Unit.text");
		dataBinder.registerBinding("entrys.weighTime", java.util.Date.class, this.kdtEntrys, "weighTime.text");
		dataBinder.registerBinding("entrys.qty", java.math.BigDecimal.class, this.kdtEntrys, "qty.text");
		dataBinder.registerBinding("entrys.tare", java.math.BigDecimal.class, this.kdtEntrys, "tare.text");
		dataBinder.registerBinding("entrys.gross", java.math.BigDecimal.class, this.kdtEntrys, "gross.text");
		dataBinder.registerBinding("entrys.suttle", java.math.BigDecimal.class, this.kdtEntrys, "suttle.text");
		dataBinder.registerBinding("entrys.weighTimeGross", java.util.Date.class, this.kdtEntrys, "weighTimeGross.text");
		dataBinder.registerBinding("entrys.tare2", java.math.BigDecimal.class, this.kdtEntrys, "tare2.text");
		dataBinder.registerBinding("entrys.weighTime2", java.util.Date.class, this.kdtEntrys, "weighTime2.text");
		dataBinder.registerBinding("entrys.actualSuttle", java.math.BigDecimal.class, this.kdtEntrys, "actualSuttle.text");
		dataBinder.registerBinding("entrys.tempSuttle", java.math.BigDecimal.class, this.kdtEntrys, "tempSuttle.text");
		dataBinder.registerBinding("entrys.suttleDiff", java.math.BigDecimal.class, this.kdtEntrys, "suttleDiff.text");
		dataBinder.registerBinding("entrys.Detail.seq", int.class, this.kdtDetail, "seq.text");
		dataBinder.registerBinding("entrys.Detail", com.kingdee.eas.weighbridge.OutStorageBillEntryDetailInfo.class, this.kdtDetail, "userObject");
		dataBinder.registerBinding("entrys.Detail.sourceBillNum", String.class, this.kdtDetail, "sourceBillNum.text");
		dataBinder.registerBinding("entrys.Detail.sourceEntrySeq", String.class, this.kdtDetail, "sourceEntrySeq.text");
		dataBinder.registerBinding("entrys.Detail.billType", java.lang.Object.class, this.kdtDetail, "billType.text");
		dataBinder.registerBinding("entrys.Detail.sourceEntryQty", java.math.BigDecimal.class, this.kdtDetail, "sourceEntryQty.text");
		dataBinder.registerBinding("entrys.Detail.weighQty", java.math.BigDecimal.class, this.kdtDetail, "weighQty.text");
		dataBinder.registerBinding("entrys.Detail.orderStorageOrg", java.lang.Object.class, this.kdtDetail, "orderStorageOrg.text");
		dataBinder.registerBinding("entrys.Detail.sourceEntryBag", java.math.BigDecimal.class, this.kdtDetail, "sourceEntryBag.text");
		dataBinder.registerBinding("entrys.Detail.mateiralName", String.class, this.kdtDetail, "mateiralName.text");
		dataBinder.registerBinding("entrys.Detail.model", String.class, this.kdtDetail, "model.text");
		dataBinder.registerBinding("entrys.Detail.materialNum", String.class, this.kdtDetail, "materialNum.text");
		dataBinder.registerBinding("entrys.Detail.customerName", String.class, this.kdtDetail, "customerName.text");
		dataBinder.registerBinding("entrys.Detail.customerNum", String.class, this.kdtDetail, "customerNum.text");
		dataBinder.registerBinding("isAutoCreateToInvBill", boolean.class, this.chkisAutoCreateToInvBill, "selected");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("car", com.kingdee.eas.publicdata.CarInfo.class, this.prmtcar, "data");
		dataBinder.registerBinding("inTime", java.util.Date.class, this.pkinTime, "value");
		dataBinder.registerBinding("outTime", java.util.Date.class, this.pkoutTime, "value");
		dataBinder.registerBinding("tareWeight", java.math.BigDecimal.class, this.txttareWeight, "value");
		dataBinder.registerBinding("storageOrgUnit", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtstorageOrgUnit, "data");
		dataBinder.registerBinding("orderStorageOrgUnit", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtorderStorageOrgUnit, "data");
		dataBinder.registerBinding("customer", com.kingdee.eas.basedata.master.cssp.CustomerInfo.class, this.prmtcustomer, "data");
		dataBinder.registerBinding("weighman", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtweighman, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("bizType", com.kingdee.eas.weighbridge.WeighBizType.class, this.bizType, "selectedItem");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.weighbridge.WeighBaseStatus.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("weighType", com.kingdee.eas.weighbridge.WeighBaseType.class, this.weighType, "selectedItem");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("orderComopany", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtorderComopany, "data");
		dataBinder.registerBinding("carNum", String.class, this.txtcarNum, "text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.weighbridge.app.OutStorageBillEditUIHandler";
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
        this.kdtDetail.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.weighbridge.OutStorageBillInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.mateiralName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.model", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.weighTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.tare", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.gross", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.suttle", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.weighTimeGross", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.tare2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.weighTime2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.actualSuttle", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.tempSuttle", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.suttleDiff", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.sourceBillNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.sourceEntrySeq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.billType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.sourceEntryQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.weighQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.orderStorageOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.sourceEntryBag", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.mateiralName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.model", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.materialNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.customerName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.customerNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isAutoCreateToInvBill", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("car", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("inTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("outTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("tareWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("storageOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("orderStorageOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("customer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("weighman", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("weighType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("orderComopany", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("carNum", ValidateHelper.ON_SAVE);    		
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
            if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"mateiralName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"material").getValue(),"name")));

}

    if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"model").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"material").getValue(),"model")));

}


    }

    /**
     * output prmtcar_Changed() method
     */
    public void prmtcar_Changed() throws Exception
    {
        System.out.println("prmtcar_Changed() Function is executed!");
            txttareWeight.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtcar.getData(),"tare")));


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
			sic.add(new SelectorItemInfo("entrys.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.material.id"));
			sic.add(new SelectorItemInfo("entrys.material.number"));
			sic.add(new SelectorItemInfo("entrys.material.name"));
		}
    	sic.add(new SelectorItemInfo("entrys.mateiralName"));
    	sic.add(new SelectorItemInfo("entrys.model"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.Unit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.Unit.id"));
			sic.add(new SelectorItemInfo("entrys.Unit.name"));
        	sic.add(new SelectorItemInfo("entrys.Unit.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.weighTime"));
    	sic.add(new SelectorItemInfo("entrys.qty"));
    	sic.add(new SelectorItemInfo("entrys.tare"));
    	sic.add(new SelectorItemInfo("entrys.gross"));
    	sic.add(new SelectorItemInfo("entrys.suttle"));
    	sic.add(new SelectorItemInfo("entrys.weighTimeGross"));
    	sic.add(new SelectorItemInfo("entrys.tare2"));
    	sic.add(new SelectorItemInfo("entrys.weighTime2"));
    	sic.add(new SelectorItemInfo("entrys.actualSuttle"));
    	sic.add(new SelectorItemInfo("entrys.tempSuttle"));
    	sic.add(new SelectorItemInfo("entrys.suttleDiff"));
    	sic.add(new SelectorItemInfo("entrys.Detail.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.Detail.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.Detail.id"));
		}
    	sic.add(new SelectorItemInfo("entrys.Detail.sourceBillNum"));
    	sic.add(new SelectorItemInfo("entrys.Detail.sourceEntrySeq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.Detail.billType.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.Detail.billType.id"));
			sic.add(new SelectorItemInfo("entrys.Detail.billType.name"));
        	sic.add(new SelectorItemInfo("entrys.Detail.billType.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.Detail.sourceEntryQty"));
    	sic.add(new SelectorItemInfo("entrys.Detail.weighQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.Detail.orderStorageOrg.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.Detail.orderStorageOrg.id"));
			sic.add(new SelectorItemInfo("entrys.Detail.orderStorageOrg.name"));
        	sic.add(new SelectorItemInfo("entrys.Detail.orderStorageOrg.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.Detail.sourceEntryBag"));
    	sic.add(new SelectorItemInfo("entrys.Detail.mateiralName"));
    	sic.add(new SelectorItemInfo("entrys.Detail.model"));
    	sic.add(new SelectorItemInfo("entrys.Detail.materialNum"));
    	sic.add(new SelectorItemInfo("entrys.Detail.customerName"));
    	sic.add(new SelectorItemInfo("entrys.Detail.customerNum"));
        sic.add(new SelectorItemInfo("isAutoCreateToInvBill"));
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
			sic.add(new SelectorItemInfo("car.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("car.id"));
        	sic.add(new SelectorItemInfo("car.number"));
        	sic.add(new SelectorItemInfo("car.name"));
		}
        sic.add(new SelectorItemInfo("inTime"));
        sic.add(new SelectorItemInfo("outTime"));
        sic.add(new SelectorItemInfo("tareWeight"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("storageOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("storageOrgUnit.id"));
        	sic.add(new SelectorItemInfo("storageOrgUnit.number"));
        	sic.add(new SelectorItemInfo("storageOrgUnit.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("orderStorageOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("orderStorageOrgUnit.id"));
        	sic.add(new SelectorItemInfo("orderStorageOrgUnit.number"));
        	sic.add(new SelectorItemInfo("orderStorageOrgUnit.name"));
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("weighman.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("weighman.id"));
        	sic.add(new SelectorItemInfo("weighman.number"));
        	sic.add(new SelectorItemInfo("weighman.name"));
		}
        sic.add(new SelectorItemInfo("auditTime"));
        sic.add(new SelectorItemInfo("bizType"));
        sic.add(new SelectorItemInfo("billStatus"));
        sic.add(new SelectorItemInfo("weighType"));
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
			sic.add(new SelectorItemInfo("orderComopany.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("orderComopany.id"));
        	sic.add(new SelectorItemInfo("orderComopany.number"));
        	sic.add(new SelectorItemInfo("orderComopany.name"));
		}
        sic.add(new SelectorItemInfo("carNum"));
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
     * output actionNumberSign_actionPerformed method
     */
    public void actionNumberSign_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionNumberSign_actionPerformed(e);
    }
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.weighbridge.OutStorageBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.weighbridge.OutStorageBillFactory.getRemoteInstance().unAudit(editData);
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
	public RequestContext prepareActionNumberSign(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionNumberSign(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionNumberSign() {
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
            innerActionPerformed("eas", AbstractOutStorageBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractOutStorageBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.weighbridge.client", "OutStorageBillEditUI");
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
        return com.kingdee.eas.weighbridge.client.OutStorageBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.weighbridge.OutStorageBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.weighbridge.OutStorageBillInfo objectValue = new com.kingdee.eas.weighbridge.OutStorageBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/weighbridge/OutStorageBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.weighbridge.app.OutStorageBillQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"当前财务组织"});
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
		vo.put("bizType","1");
vo.put("billStatus","0");
vo.put("weighType","1");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}