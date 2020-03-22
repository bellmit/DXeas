/**
 * output package name
 */
package com.kingdee.eas.custom.ccchargeback.client;

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
public abstract class AbstractCcChargeBackBizBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCcChargeBackBizBillEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstoOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDPanel panelSTD;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalWeight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalAmt;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstoOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contSTDRemark;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane scrollPaneSTDRemark;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtSTDRemark;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchicksQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchicksWT;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchicksAvgWT;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgrossChickenWT;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgrossChickTotalWT;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchicksQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchicksWT;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchicksAvgWT;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgrossChickenWT;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgrossChickTotalWT;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalWeight;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalAmt;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.custom.ccchargeback.CcChargeBackBizBillInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractCcChargeBackBizBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCcChargeBackBizBillEditUI.class.getName());
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
        this.actionAudit.setExtendProperty("userDefined", "false");
        this.actionAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionUnAudit
        this.actionUnAudit = new ActionUnAudit(this);
        getActionManager().registerAction("actionUnAudit", actionUnAudit);
        this.actionUnAudit.setBindWorkFlow(true);
        this.actionUnAudit.setExtendProperty("canForewarn", "true");
        this.actionUnAudit.setExtendProperty("userDefined", "false");
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
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstoOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.panelSTD = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalWeight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtstoOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.contSTDRemark = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.scrollPaneSTDRemark = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txtSTDRemark = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.contchicksQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchicksWT = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchicksAvgWT = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgrossChickenWT = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgrossChickTotalWT = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtchicksQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtchicksWT = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtchicksAvgWT = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtgrossChickenWT = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtgrossChickTotalWT = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txttotalWeight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttotalAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
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
        this.kdtEntrys.setName("kdtEntrys");
        this.contbillStatus.setName("contbillStatus");
        this.contstoOrgUnit.setName("contstoOrgUnit");
        this.panelSTD.setName("panelSTD");
        this.kDPanel1.setName("kDPanel1");
        this.contauditTime.setName("contauditTime");
        this.conttotalWeight.setName("conttotalWeight");
        this.conttotalAmt.setName("conttotalAmt");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.billStatus.setName("billStatus");
        this.prmtstoOrgUnit.setName("prmtstoOrgUnit");
        this.contSTDRemark.setName("contSTDRemark");
        this.scrollPaneSTDRemark.setName("scrollPaneSTDRemark");
        this.txtSTDRemark.setName("txtSTDRemark");
        this.contchicksQty.setName("contchicksQty");
        this.contchicksWT.setName("contchicksWT");
        this.contchicksAvgWT.setName("contchicksAvgWT");
        this.contgrossChickenWT.setName("contgrossChickenWT");
        this.contgrossChickTotalWT.setName("contgrossChickTotalWT");
        this.txtchicksQty.setName("txtchicksQty");
        this.txtchicksWT.setName("txtchicksWT");
        this.txtchicksAvgWT.setName("txtchicksAvgWT");
        this.txtgrossChickenWT.setName("txtgrossChickenWT");
        this.txtgrossChickTotalWT.setName("txtgrossChickTotalWT");
        this.pkauditTime.setName("pkauditTime");
        this.txttotalWeight.setName("txttotalWeight");
        this.txttotalAmt.setName("txttotalAmt");
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
        // contDescription		
        this.contDescription.setBoundLabelText(resHelper.getString("contDescription.boundLabelText"));		
        this.contDescription.setBoundLabelLength(100);		
        this.contDescription.setBoundLabelUnderline(true);
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"henHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"henHouseName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"incoopQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"pulvillusProportion\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"pulvillusOver\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"pulvillusChargebackAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"dermatitisProportion\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"dermatitisOver\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"dermatitisAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"avgWT\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"SamplingRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"maxWT\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"cropBuckle\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"cropDeductMoney\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{henHouse}</t:Cell><t:Cell>$Resource{henHouseName}</t:Cell><t:Cell>$Resource{incoopQty}</t:Cell><t:Cell>$Resource{pulvillusProportion}</t:Cell><t:Cell>$Resource{pulvillusOver}</t:Cell><t:Cell>$Resource{pulvillusChargebackAmt}</t:Cell><t:Cell>$Resource{dermatitisProportion}</t:Cell><t:Cell>$Resource{dermatitisOver}</t:Cell><t:Cell>$Resource{dermatitisAmt}</t:Cell><t:Cell>$Resource{avgWT}</t:Cell><t:Cell>$Resource{SamplingRate}</t:Cell><t:Cell>$Resource{maxWT}</t:Cell><t:Cell>$Resource{cropBuckle}</t:Cell><t:Cell>$Resource{cropDeductMoney}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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

        this.kdtEntrys.addKDTEditListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter() {
            public void editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) {
                try {
                    kdtEntrys_editStoppe(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
            public void editStarting(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) {
                try {
                    kdtEntrys_editStartin(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });

                this.kdtEntrys.putBindContents("editData",new String[] {"id","henHouse","henHouseName","incoopQty","pulvillusProportion","pulvillusOver","pulvillusChargebackAmt","dermatitisProportion","dermatitisOver","dermatitisAmt","avgWT","SamplingRate","maxWT","cropBuckle","cropDeductMoney"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_henHouse_PromptBox = new KDBizPromptBox();
        kdtEntrys_henHouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseF7Query");
        kdtEntrys_henHouse_PromptBox.setVisible(true);
        kdtEntrys_henHouse_PromptBox.setEditable(true);
        kdtEntrys_henHouse_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_henHouse_PromptBox.setEditFormat("$number$");
        kdtEntrys_henHouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_henHouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henHouse_PromptBox);
        this.kdtEntrys.getColumn("henHouse").setEditor(kdtEntrys_henHouse_CellEditor);
        ObjectValueRender kdtEntrys_henHouse_OVR = new ObjectValueRender();
        kdtEntrys_henHouse_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("henHouse").setRenderer(kdtEntrys_henHouse_OVR);
        KDTextField kdtEntrys_henHouseName_TextField = new KDTextField();
        kdtEntrys_henHouseName_TextField.setName("kdtEntrys_henHouseName_TextField");
        kdtEntrys_henHouseName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_henHouseName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henHouseName_TextField);
        this.kdtEntrys.getColumn("henHouseName").setEditor(kdtEntrys_henHouseName_CellEditor);
        KDFormattedTextField kdtEntrys_incoopQty_TextField = new KDFormattedTextField();
        kdtEntrys_incoopQty_TextField.setName("kdtEntrys_incoopQty_TextField");
        kdtEntrys_incoopQty_TextField.setVisible(true);
        kdtEntrys_incoopQty_TextField.setEditable(true);
        kdtEntrys_incoopQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_incoopQty_TextField.setDataType(1);
        	kdtEntrys_incoopQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_incoopQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_incoopQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_incoopQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_incoopQty_TextField);
        this.kdtEntrys.getColumn("incoopQty").setEditor(kdtEntrys_incoopQty_CellEditor);
        KDFormattedTextField kdtEntrys_pulvillusProportion_TextField = new KDFormattedTextField();
        kdtEntrys_pulvillusProportion_TextField.setName("kdtEntrys_pulvillusProportion_TextField");
        kdtEntrys_pulvillusProportion_TextField.setVisible(true);
        kdtEntrys_pulvillusProportion_TextField.setEditable(true);
        kdtEntrys_pulvillusProportion_TextField.setHorizontalAlignment(2);
        kdtEntrys_pulvillusProportion_TextField.setDataType(1);
        	kdtEntrys_pulvillusProportion_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_pulvillusProportion_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_pulvillusProportion_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_pulvillusProportion_CellEditor = new KDTDefaultCellEditor(kdtEntrys_pulvillusProportion_TextField);
        this.kdtEntrys.getColumn("pulvillusProportion").setEditor(kdtEntrys_pulvillusProportion_CellEditor);
        KDFormattedTextField kdtEntrys_pulvillusOver_TextField = new KDFormattedTextField();
        kdtEntrys_pulvillusOver_TextField.setName("kdtEntrys_pulvillusOver_TextField");
        kdtEntrys_pulvillusOver_TextField.setVisible(true);
        kdtEntrys_pulvillusOver_TextField.setEditable(true);
        kdtEntrys_pulvillusOver_TextField.setHorizontalAlignment(2);
        kdtEntrys_pulvillusOver_TextField.setDataType(1);
        	kdtEntrys_pulvillusOver_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_pulvillusOver_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_pulvillusOver_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_pulvillusOver_CellEditor = new KDTDefaultCellEditor(kdtEntrys_pulvillusOver_TextField);
        this.kdtEntrys.getColumn("pulvillusOver").setEditor(kdtEntrys_pulvillusOver_CellEditor);
        KDFormattedTextField kdtEntrys_pulvillusChargebackAmt_TextField = new KDFormattedTextField();
        kdtEntrys_pulvillusChargebackAmt_TextField.setName("kdtEntrys_pulvillusChargebackAmt_TextField");
        kdtEntrys_pulvillusChargebackAmt_TextField.setVisible(true);
        kdtEntrys_pulvillusChargebackAmt_TextField.setEditable(true);
        kdtEntrys_pulvillusChargebackAmt_TextField.setHorizontalAlignment(2);
        kdtEntrys_pulvillusChargebackAmt_TextField.setDataType(1);
        	kdtEntrys_pulvillusChargebackAmt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_pulvillusChargebackAmt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_pulvillusChargebackAmt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_pulvillusChargebackAmt_CellEditor = new KDTDefaultCellEditor(kdtEntrys_pulvillusChargebackAmt_TextField);
        this.kdtEntrys.getColumn("pulvillusChargebackAmt").setEditor(kdtEntrys_pulvillusChargebackAmt_CellEditor);
        KDFormattedTextField kdtEntrys_dermatitisProportion_TextField = new KDFormattedTextField();
        kdtEntrys_dermatitisProportion_TextField.setName("kdtEntrys_dermatitisProportion_TextField");
        kdtEntrys_dermatitisProportion_TextField.setVisible(true);
        kdtEntrys_dermatitisProportion_TextField.setEditable(true);
        kdtEntrys_dermatitisProportion_TextField.setHorizontalAlignment(2);
        kdtEntrys_dermatitisProportion_TextField.setDataType(1);
        	kdtEntrys_dermatitisProportion_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_dermatitisProportion_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_dermatitisProportion_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_dermatitisProportion_CellEditor = new KDTDefaultCellEditor(kdtEntrys_dermatitisProportion_TextField);
        this.kdtEntrys.getColumn("dermatitisProportion").setEditor(kdtEntrys_dermatitisProportion_CellEditor);
        KDFormattedTextField kdtEntrys_dermatitisOver_TextField = new KDFormattedTextField();
        kdtEntrys_dermatitisOver_TextField.setName("kdtEntrys_dermatitisOver_TextField");
        kdtEntrys_dermatitisOver_TextField.setVisible(true);
        kdtEntrys_dermatitisOver_TextField.setEditable(true);
        kdtEntrys_dermatitisOver_TextField.setHorizontalAlignment(2);
        kdtEntrys_dermatitisOver_TextField.setDataType(1);
        	kdtEntrys_dermatitisOver_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_dermatitisOver_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_dermatitisOver_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_dermatitisOver_CellEditor = new KDTDefaultCellEditor(kdtEntrys_dermatitisOver_TextField);
        this.kdtEntrys.getColumn("dermatitisOver").setEditor(kdtEntrys_dermatitisOver_CellEditor);
        KDFormattedTextField kdtEntrys_dermatitisAmt_TextField = new KDFormattedTextField();
        kdtEntrys_dermatitisAmt_TextField.setName("kdtEntrys_dermatitisAmt_TextField");
        kdtEntrys_dermatitisAmt_TextField.setVisible(true);
        kdtEntrys_dermatitisAmt_TextField.setEditable(true);
        kdtEntrys_dermatitisAmt_TextField.setHorizontalAlignment(2);
        kdtEntrys_dermatitisAmt_TextField.setDataType(1);
        	kdtEntrys_dermatitisAmt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_dermatitisAmt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_dermatitisAmt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_dermatitisAmt_CellEditor = new KDTDefaultCellEditor(kdtEntrys_dermatitisAmt_TextField);
        this.kdtEntrys.getColumn("dermatitisAmt").setEditor(kdtEntrys_dermatitisAmt_CellEditor);
        KDFormattedTextField kdtEntrys_avgWT_TextField = new KDFormattedTextField();
        kdtEntrys_avgWT_TextField.setName("kdtEntrys_avgWT_TextField");
        kdtEntrys_avgWT_TextField.setVisible(true);
        kdtEntrys_avgWT_TextField.setEditable(true);
        kdtEntrys_avgWT_TextField.setHorizontalAlignment(2);
        kdtEntrys_avgWT_TextField.setDataType(1);
        	kdtEntrys_avgWT_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E24"));
        	kdtEntrys_avgWT_TextField.setMaximumValue(new java.math.BigDecimal("1.0E24"));
        kdtEntrys_avgWT_TextField.setPrecision(4);
        KDTDefaultCellEditor kdtEntrys_avgWT_CellEditor = new KDTDefaultCellEditor(kdtEntrys_avgWT_TextField);
        this.kdtEntrys.getColumn("avgWT").setEditor(kdtEntrys_avgWT_CellEditor);
        KDFormattedTextField kdtEntrys_SamplingRate_TextField = new KDFormattedTextField();
        kdtEntrys_SamplingRate_TextField.setName("kdtEntrys_SamplingRate_TextField");
        kdtEntrys_SamplingRate_TextField.setVisible(true);
        kdtEntrys_SamplingRate_TextField.setEditable(true);
        kdtEntrys_SamplingRate_TextField.setHorizontalAlignment(2);
        kdtEntrys_SamplingRate_TextField.setDataType(1);
        	kdtEntrys_SamplingRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_SamplingRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_SamplingRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_SamplingRate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_SamplingRate_TextField);
        this.kdtEntrys.getColumn("SamplingRate").setEditor(kdtEntrys_SamplingRate_CellEditor);
        KDFormattedTextField kdtEntrys_maxWT_TextField = new KDFormattedTextField();
        kdtEntrys_maxWT_TextField.setName("kdtEntrys_maxWT_TextField");
        kdtEntrys_maxWT_TextField.setVisible(true);
        kdtEntrys_maxWT_TextField.setEditable(true);
        kdtEntrys_maxWT_TextField.setHorizontalAlignment(2);
        kdtEntrys_maxWT_TextField.setDataType(1);
        	kdtEntrys_maxWT_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E22"));
        	kdtEntrys_maxWT_TextField.setMaximumValue(new java.math.BigDecimal("1.0E22"));
        kdtEntrys_maxWT_TextField.setPrecision(6);
        KDTDefaultCellEditor kdtEntrys_maxWT_CellEditor = new KDTDefaultCellEditor(kdtEntrys_maxWT_TextField);
        this.kdtEntrys.getColumn("maxWT").setEditor(kdtEntrys_maxWT_CellEditor);
        KDFormattedTextField kdtEntrys_cropBuckle_TextField = new KDFormattedTextField();
        kdtEntrys_cropBuckle_TextField.setName("kdtEntrys_cropBuckle_TextField");
        kdtEntrys_cropBuckle_TextField.setVisible(true);
        kdtEntrys_cropBuckle_TextField.setEditable(true);
        kdtEntrys_cropBuckle_TextField.setHorizontalAlignment(2);
        kdtEntrys_cropBuckle_TextField.setDataType(1);
        	kdtEntrys_cropBuckle_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_cropBuckle_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_cropBuckle_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_cropBuckle_CellEditor = new KDTDefaultCellEditor(kdtEntrys_cropBuckle_TextField);
        this.kdtEntrys.getColumn("cropBuckle").setEditor(kdtEntrys_cropBuckle_CellEditor);
        KDFormattedTextField kdtEntrys_cropDeductMoney_TextField = new KDFormattedTextField();
        kdtEntrys_cropDeductMoney_TextField.setName("kdtEntrys_cropDeductMoney_TextField");
        kdtEntrys_cropDeductMoney_TextField.setVisible(true);
        kdtEntrys_cropDeductMoney_TextField.setEditable(true);
        kdtEntrys_cropDeductMoney_TextField.setHorizontalAlignment(2);
        kdtEntrys_cropDeductMoney_TextField.setDataType(1);
        	kdtEntrys_cropDeductMoney_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_cropDeductMoney_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_cropDeductMoney_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_cropDeductMoney_CellEditor = new KDTDefaultCellEditor(kdtEntrys_cropDeductMoney_TextField);
        this.kdtEntrys.getColumn("cropDeductMoney").setEditor(kdtEntrys_cropDeductMoney_CellEditor);
        // contbillStatus		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);
        // contstoOrgUnit		
        this.contstoOrgUnit.setBoundLabelText(resHelper.getString("contstoOrgUnit.boundLabelText"));		
        this.contstoOrgUnit.setBoundLabelLength(100);		
        this.contstoOrgUnit.setBoundLabelUnderline(true);		
        this.contstoOrgUnit.setVisible(true);
        // panelSTD		
        this.panelSTD.setBorder(new TitledBorder(BorderFactory.createLineBorder(new Color(0,0,0),1), resHelper.getString("panelSTD.border.title")));
        // kDPanel1		
        this.kDPanel1.setBorder(new TitledBorder(BorderFactory.createLineBorder(new Color(0,0,0),1), resHelper.getString("kDPanel1.border.title")));
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // conttotalWeight		
        this.conttotalWeight.setBoundLabelText(resHelper.getString("conttotalWeight.boundLabelText"));		
        this.conttotalWeight.setBoundLabelLength(100);		
        this.conttotalWeight.setBoundLabelUnderline(true);		
        this.conttotalWeight.setVisible(true);
        // conttotalAmt		
        this.conttotalAmt.setBoundLabelText(resHelper.getString("conttotalAmt.boundLabelText"));		
        this.conttotalAmt.setBoundLabelLength(100);		
        this.conttotalAmt.setBoundLabelUnderline(true);		
        this.conttotalAmt.setVisible(true);
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
        this.pkBizDate.setEnabled(true);		
        this.pkBizDate.setRequired(true);
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // billStatus		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.ccchargeback.billStatus").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // prmtstoOrgUnit		
        this.prmtstoOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtstoOrgUnit.setEditable(true);		
        this.prmtstoOrgUnit.setDisplayFormat("$name$");		
        this.prmtstoOrgUnit.setEditFormat("$number$");		
        this.prmtstoOrgUnit.setCommitFormat("$number$");		
        this.prmtstoOrgUnit.setRequired(true);
        this.prmtstoOrgUnit.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtstoOrgUnit_dataChang(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // contSTDRemark		
        this.contSTDRemark.setBoundLabelText(resHelper.getString("contSTDRemark.boundLabelText"));		
        this.contSTDRemark.setBoundLabelLength(0);		
        this.contSTDRemark.setBoundLabelUnderline(true);		
        this.contSTDRemark.setVisible(true);
        // scrollPaneSTDRemark
        // txtSTDRemark		
        this.txtSTDRemark.setRequired(false);		
        this.txtSTDRemark.setMaxLength(2000);		
        this.txtSTDRemark.setEnabled(false);
        // contchicksQty		
        this.contchicksQty.setBoundLabelText(resHelper.getString("contchicksQty.boundLabelText"));		
        this.contchicksQty.setBoundLabelLength(100);		
        this.contchicksQty.setBoundLabelUnderline(true);		
        this.contchicksQty.setVisible(true);
        // contchicksWT		
        this.contchicksWT.setBoundLabelText(resHelper.getString("contchicksWT.boundLabelText"));		
        this.contchicksWT.setBoundLabelLength(100);		
        this.contchicksWT.setBoundLabelUnderline(true);		
        this.contchicksWT.setVisible(true);
        // contchicksAvgWT		
        this.contchicksAvgWT.setBoundLabelText(resHelper.getString("contchicksAvgWT.boundLabelText"));		
        this.contchicksAvgWT.setBoundLabelLength(100);		
        this.contchicksAvgWT.setBoundLabelUnderline(true);		
        this.contchicksAvgWT.setVisible(true);
        // contgrossChickenWT		
        this.contgrossChickenWT.setBoundLabelText(resHelper.getString("contgrossChickenWT.boundLabelText"));		
        this.contgrossChickenWT.setBoundLabelLength(100);		
        this.contgrossChickenWT.setBoundLabelUnderline(true);		
        this.contgrossChickenWT.setVisible(true);
        // contgrossChickTotalWT		
        this.contgrossChickTotalWT.setBoundLabelText(resHelper.getString("contgrossChickTotalWT.boundLabelText"));		
        this.contgrossChickTotalWT.setBoundLabelLength(100);		
        this.contgrossChickTotalWT.setBoundLabelUnderline(true);		
        this.contgrossChickTotalWT.setVisible(true);
        // txtchicksQty		
        this.txtchicksQty.setHorizontalAlignment(2);		
        this.txtchicksQty.setDataType(1);		
        this.txtchicksQty.setSupportedEmpty(true);		
        this.txtchicksQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchicksQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchicksQty.setPrecision(0);		
        this.txtchicksQty.setRequired(false);
        this.txtchicksQty.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtchicksQty_dataChang(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtchicksWT		
        this.txtchicksWT.setHorizontalAlignment(2);		
        this.txtchicksWT.setDataType(1);		
        this.txtchicksWT.setSupportedEmpty(true);		
        this.txtchicksWT.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchicksWT.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchicksWT.setPrecision(4);		
        this.txtchicksWT.setRequired(false);
        this.txtchicksWT.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    txtchicksWT_dataChang(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtchicksAvgWT		
        this.txtchicksAvgWT.setHorizontalAlignment(2);		
        this.txtchicksAvgWT.setDataType(1);		
        this.txtchicksAvgWT.setSupportedEmpty(true);		
        this.txtchicksAvgWT.setMinimumValue( new java.math.BigDecimal("-1.0E22"));		
        this.txtchicksAvgWT.setMaximumValue( new java.math.BigDecimal("1.0E22"));		
        this.txtchicksAvgWT.setPrecision(6);		
        this.txtchicksAvgWT.setRequired(false);		
        this.txtchicksAvgWT.setEnabled(false);
        // txtgrossChickenWT		
        this.txtgrossChickenWT.setHorizontalAlignment(2);		
        this.txtgrossChickenWT.setDataType(1);		
        this.txtgrossChickenWT.setSupportedEmpty(true);		
        this.txtgrossChickenWT.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtgrossChickenWT.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtgrossChickenWT.setPrecision(4);		
        this.txtgrossChickenWT.setRequired(false);		
        this.txtgrossChickenWT.setEnabled(false);
        // txtgrossChickTotalWT		
        this.txtgrossChickTotalWT.setHorizontalAlignment(2);		
        this.txtgrossChickTotalWT.setDataType(1);		
        this.txtgrossChickTotalWT.setSupportedEmpty(true);		
        this.txtgrossChickTotalWT.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtgrossChickTotalWT.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtgrossChickTotalWT.setPrecision(4);		
        this.txtgrossChickTotalWT.setRequired(false);		
        this.txtgrossChickTotalWT.setEnabled(false);
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // txttotalWeight		
        this.txttotalWeight.setVisible(true);		
        this.txttotalWeight.setHorizontalAlignment(2);		
        this.txttotalWeight.setDataType(1);		
        this.txttotalWeight.setSupportedEmpty(true);		
        this.txttotalWeight.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttotalWeight.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttotalWeight.setPrecision(4);		
        this.txttotalWeight.setRequired(false);		
        this.txttotalWeight.setEnabled(false);
        // txttotalAmt		
        this.txttotalAmt.setVisible(true);		
        this.txttotalAmt.setHorizontalAlignment(2);		
        this.txttotalAmt.setDataType(1);		
        this.txttotalAmt.setSupportedEmpty(true);		
        this.txttotalAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttotalAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttotalAmt.setPrecision(2);		
        this.txttotalAmt.setRequired(false);		
        this.txttotalAmt.setEnabled(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {billStatus,prmtstoOrgUnit,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,txtSTDRemark,txtchicksQty,txtchicksWT,txtchicksAvgWT,txtgrossChickenWT,txtgrossChickTotalWT,pkauditTime,kdtEntrys,txttotalWeight,txttotalAmt}));
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
        contCreator.setBounds(new Rectangle(367, 570, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(367, 570, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(722, 570, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(722, 570, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(367, 601, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(367, 601, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(722, 601, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(722, 601, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(18, 21, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(18, 21, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(367, 21, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(367, 21, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(19, 96, 967, 20));
        this.add(contDescription, new KDLayout.Constraints(19, 96, 967, 20, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(15, 574, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(15, 574, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(12, 227, 980, 204));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.custom.ccchargeback.CcChargeBackBizBillEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(12, 227, 980, 204, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contbillStatus.setBounds(new Rectangle(18, 53, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(18, 53, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contstoOrgUnit.setBounds(new Rectangle(714, 16, 270, 19));
        this.add(contstoOrgUnit, new KDLayout.Constraints(714, 16, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        panelSTD.setBounds(new Rectangle(12, 444, 980, 115));
        this.add(panelSTD, new KDLayout.Constraints(12, 444, 980, 115, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDPanel1.setBounds(new Rectangle(12, 122, 980, 93));
        this.add(kDPanel1, new KDLayout.Constraints(12, 122, 980, 93, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contauditTime.setBounds(new Rectangle(15, 601, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(15, 601, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttotalWeight.setBounds(new Rectangle(367, 53, 270, 19));
        this.add(conttotalWeight, new KDLayout.Constraints(367, 53, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttotalAmt.setBounds(new Rectangle(714, 53, 270, 19));
        this.add(conttotalAmt, new KDLayout.Constraints(714, 53, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //contstoOrgUnit
        contstoOrgUnit.setBoundEditor(prmtstoOrgUnit);
        //panelSTD
        panelSTD.setLayout(new KDLayout());
        panelSTD.putClientProperty("OriginalBounds", new Rectangle(12, 444, 980, 115));        contSTDRemark.setBounds(new Rectangle(14, 21, 959, 79));
        panelSTD.add(contSTDRemark, new KDLayout.Constraints(14, 21, 959, 79, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contSTDRemark
        contSTDRemark.setBoundEditor(scrollPaneSTDRemark);
        //scrollPaneSTDRemark
        scrollPaneSTDRemark.getViewport().add(txtSTDRemark, null);
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(12, 122, 980, 93));        contchicksQty.setBounds(new Rectangle(18, 25, 270, 19));
        kDPanel1.add(contchicksQty, new KDLayout.Constraints(18, 25, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contchicksWT.setBounds(new Rectangle(358, 25, 270, 19));
        kDPanel1.add(contchicksWT, new KDLayout.Constraints(358, 25, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contchicksAvgWT.setBounds(new Rectangle(692, 21, 270, 19));
        kDPanel1.add(contchicksAvgWT, new KDLayout.Constraints(692, 21, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contgrossChickenWT.setBounds(new Rectangle(18, 60, 270, 19));
        kDPanel1.add(contgrossChickenWT, new KDLayout.Constraints(18, 60, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contgrossChickTotalWT.setBounds(new Rectangle(358, 60, 270, 19));
        kDPanel1.add(contgrossChickTotalWT, new KDLayout.Constraints(358, 60, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contchicksQty
        contchicksQty.setBoundEditor(txtchicksQty);
        //contchicksWT
        contchicksWT.setBoundEditor(txtchicksWT);
        //contchicksAvgWT
        contchicksAvgWT.setBoundEditor(txtchicksAvgWT);
        //contgrossChickenWT
        contgrossChickenWT.setBoundEditor(txtgrossChickenWT);
        //contgrossChickTotalWT
        contgrossChickTotalWT.setBoundEditor(txtgrossChickTotalWT);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //conttotalWeight
        conttotalWeight.setBoundEditor(txttotalWeight);
        //conttotalAmt
        conttotalAmt.setBoundEditor(txttotalAmt);

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
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.custom.ccchargeback.CcChargeBackBizBillEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.incoopQty", java.math.BigDecimal.class, this.kdtEntrys, "incoopQty.text");
		dataBinder.registerBinding("entrys.pulvillusProportion", java.math.BigDecimal.class, this.kdtEntrys, "pulvillusProportion.text");
		dataBinder.registerBinding("entrys.pulvillusOver", java.math.BigDecimal.class, this.kdtEntrys, "pulvillusOver.text");
		dataBinder.registerBinding("entrys.pulvillusChargebackAmt", java.math.BigDecimal.class, this.kdtEntrys, "pulvillusChargebackAmt.text");
		dataBinder.registerBinding("entrys.dermatitisProportion", java.math.BigDecimal.class, this.kdtEntrys, "dermatitisProportion.text");
		dataBinder.registerBinding("entrys.dermatitisOver", java.math.BigDecimal.class, this.kdtEntrys, "dermatitisOver.text");
		dataBinder.registerBinding("entrys.dermatitisAmt", java.math.BigDecimal.class, this.kdtEntrys, "dermatitisAmt.text");
		dataBinder.registerBinding("entrys.avgWT", java.math.BigDecimal.class, this.kdtEntrys, "avgWT.text");
		dataBinder.registerBinding("entrys.SamplingRate", java.math.BigDecimal.class, this.kdtEntrys, "SamplingRate.text");
		dataBinder.registerBinding("entrys.maxWT", java.math.BigDecimal.class, this.kdtEntrys, "maxWT.text");
		dataBinder.registerBinding("entrys.cropBuckle", java.math.BigDecimal.class, this.kdtEntrys, "cropBuckle.text");
		dataBinder.registerBinding("entrys.cropDeductMoney", java.math.BigDecimal.class, this.kdtEntrys, "cropDeductMoney.text");
		dataBinder.registerBinding("entrys.henHouse", java.lang.Object.class, this.kdtEntrys, "henHouse.text");
		dataBinder.registerBinding("entrys.henHouseName", String.class, this.kdtEntrys, "henHouseName.text");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.custom.ccchargeback.billStatus.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("stoOrgUnit", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtstoOrgUnit, "data");
		dataBinder.registerBinding("STDRemark", String.class, this.txtSTDRemark, "text");
		dataBinder.registerBinding("chicksQty", java.math.BigDecimal.class, this.txtchicksQty, "value");
		dataBinder.registerBinding("chicksWT", java.math.BigDecimal.class, this.txtchicksWT, "value");
		dataBinder.registerBinding("chicksAvgWT", java.math.BigDecimal.class, this.txtchicksAvgWT, "value");
		dataBinder.registerBinding("grossChickenWT", java.math.BigDecimal.class, this.txtgrossChickenWT, "value");
		dataBinder.registerBinding("grossChickTotalWT", java.math.BigDecimal.class, this.txtgrossChickTotalWT, "value");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("totalWeight", java.math.BigDecimal.class, this.txttotalWeight, "value");
		dataBinder.registerBinding("totalAmt", java.math.BigDecimal.class, this.txttotalAmt, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.ccchargeback.app.CcChargeBackBizBillEditUIHandler";
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
        this.editData = (com.kingdee.eas.custom.ccchargeback.CcChargeBackBizBillInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.incoopQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.pulvillusProportion", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.pulvillusOver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.pulvillusChargebackAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.dermatitisProportion", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.dermatitisOver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.dermatitisAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.avgWT", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.SamplingRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.maxWT", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.cropBuckle", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.cropDeductMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.henHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.henHouseName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("stoOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("STDRemark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chicksQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chicksWT", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chicksAvgWT", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("grossChickenWT", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("grossChickTotalWT", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalAmt", ValidateHelper.ON_SAVE);    		
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
     * output kdtEntrys_editStoppe method
     */
    protected void kdtEntrys_editStoppe(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
    }

    /**
     * output kdtEntrys_editStartin method
     */
    protected void kdtEntrys_editStartin(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
    }

    /**
     * output prmtstoOrgUnit_dataChang method
     */
    protected void prmtstoOrgUnit_dataChang(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output txtchicksQty_dataChang method
     */
    protected void txtchicksQty_dataChang(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }

    /**
     * output txtchicksWT_dataChang method
     */
    protected void txtchicksWT_dataChang(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
    }


    /**
     * output kdtEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("henHouse".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"henHouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"henHouse").getValue(),"name")));

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
    	sic.add(new SelectorItemInfo("entrys.incoopQty"));
    	sic.add(new SelectorItemInfo("entrys.pulvillusProportion"));
    	sic.add(new SelectorItemInfo("entrys.pulvillusOver"));
    	sic.add(new SelectorItemInfo("entrys.pulvillusChargebackAmt"));
    	sic.add(new SelectorItemInfo("entrys.dermatitisProportion"));
    	sic.add(new SelectorItemInfo("entrys.dermatitisOver"));
    	sic.add(new SelectorItemInfo("entrys.dermatitisAmt"));
    	sic.add(new SelectorItemInfo("entrys.avgWT"));
    	sic.add(new SelectorItemInfo("entrys.SamplingRate"));
    	sic.add(new SelectorItemInfo("entrys.maxWT"));
    	sic.add(new SelectorItemInfo("entrys.cropBuckle"));
    	sic.add(new SelectorItemInfo("entrys.cropDeductMoney"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.henHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.henHouse.id"));
			sic.add(new SelectorItemInfo("entrys.henHouse.number"));
			sic.add(new SelectorItemInfo("entrys.henHouse.name"));
		}
    	sic.add(new SelectorItemInfo("entrys.henHouseName"));
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
        sic.add(new SelectorItemInfo("billStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("stoOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("stoOrgUnit.id"));
        	sic.add(new SelectorItemInfo("stoOrgUnit.number"));
        	sic.add(new SelectorItemInfo("stoOrgUnit.name"));
		}
        sic.add(new SelectorItemInfo("STDRemark"));
        sic.add(new SelectorItemInfo("chicksQty"));
        sic.add(new SelectorItemInfo("chicksWT"));
        sic.add(new SelectorItemInfo("chicksAvgWT"));
        sic.add(new SelectorItemInfo("grossChickenWT"));
        sic.add(new SelectorItemInfo("grossChickTotalWT"));
        sic.add(new SelectorItemInfo("auditTime"));
        sic.add(new SelectorItemInfo("totalWeight"));
        sic.add(new SelectorItemInfo("totalAmt"));
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
        com.kingdee.eas.custom.ccchargeback.CcChargeBackBizBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.ccchargeback.CcChargeBackBizBillFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractCcChargeBackBizBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractCcChargeBackBizBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.ccchargeback.client", "CcChargeBackBizBillEditUI");
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
        return com.kingdee.eas.custom.ccchargeback.client.CcChargeBackBizBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.ccchargeback.CcChargeBackBizBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.ccchargeback.CcChargeBackBizBillInfo objectValue = new com.kingdee.eas.custom.ccchargeback.CcChargeBackBizBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/ccchargeback/CcChargeBackBizBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.ccchargeback.app.CcChargeBackBizBillQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"henHouse").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"鸡舍"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtNumber.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"单据编号"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtstoOrgUnit.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"商品鸡场"});
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
		vo.put("billStatus","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}