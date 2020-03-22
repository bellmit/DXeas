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
public abstract class AbstractFoodSendCarPlanEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractFoodSendCarPlanEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcarCount;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtOrgEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtOrgEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDButton btnGetPlan;
    protected com.kingdee.bos.ctrl.swing.KDButton btnGetOrgEntys;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthitchTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttransferTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaheadTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcarCount;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkhitchTime;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttransferTime;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtaheadTime;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.eas.farm.food.FoodSendCarPlanInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractFoodSendCarPlanEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractFoodSendCarPlanEditUI.class.getName());
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
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contcarCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtOrgEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnGetPlan = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnGetOrgEntys = new com.kingdee.bos.ctrl.swing.KDButton();
        this.contstorageOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthitchTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttransferTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contaheadTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtcarCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtstorageOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.pkhitchTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtallQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttransferTime = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtaheadTime = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
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
        this.contcarCount.setName("contcarCount");
        this.kdtOrgEntry.setName("kdtOrgEntry");
        this.contauditTime.setName("contauditTime");
        this.btnGetPlan.setName("btnGetPlan");
        this.btnGetOrgEntys.setName("btnGetOrgEntys");
        this.contstorageOrgUnit.setName("contstorageOrgUnit");
        this.contbillStatus.setName("contbillStatus");
        this.conthitchTime.setName("conthitchTime");
        this.contallQty.setName("contallQty");
        this.conttransferTime.setName("conttransferTime");
        this.contaheadTime.setName("contaheadTime");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.txtcarCount.setName("txtcarCount");
        this.pkauditTime.setName("pkauditTime");
        this.prmtstorageOrgUnit.setName("prmtstorageOrgUnit");
        this.billStatus.setName("billStatus");
        this.pkhitchTime.setName("pkhitchTime");
        this.txtallQty.setName("txtallQty");
        this.txttransferTime.setName("txttransferTime");
        this.txtaheadTime.setName("txtaheadTime");
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
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;time</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;time</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;time</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;time</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;time</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;time</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;time</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"carNo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"storageOrgUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"startTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"reachTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"beginCatchTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"outTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"backTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"hitchTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"reStartTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"carCount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{carNo}</t:Cell><t:Cell>$Resource{storageOrgUnit}</t:Cell><t:Cell>$Resource{startTime}</t:Cell><t:Cell>$Resource{reachTime}</t:Cell><t:Cell>$Resource{beginCatchTime}</t:Cell><t:Cell>$Resource{outTime}</t:Cell><t:Cell>$Resource{backTime}</t:Cell><t:Cell>$Resource{hitchTime}</t:Cell><t:Cell>$Resource{reStartTime}</t:Cell><t:Cell>$Resource{carCount}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));

                this.kdtEntrys.putBindContents("editData",new String[] {"id","carNo","storageOrgUnit","startTime","reachTime","beginCatchTime","outTime","backTime","hitchTime","reStartTime","carCount"});


        this.kdtEntrys.checkParsed();
        KDTextField kdtEntrys_carNo_TextField = new KDTextField();
        kdtEntrys_carNo_TextField.setName("kdtEntrys_carNo_TextField");
        kdtEntrys_carNo_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_carNo_CellEditor = new KDTDefaultCellEditor(kdtEntrys_carNo_TextField);
        this.kdtEntrys.getColumn("carNo").setEditor(kdtEntrys_carNo_CellEditor);
        final KDBizPromptBox kdtEntrys_storageOrgUnit_PromptBox = new KDBizPromptBox();
        kdtEntrys_storageOrgUnit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");
        kdtEntrys_storageOrgUnit_PromptBox.setVisible(true);
        kdtEntrys_storageOrgUnit_PromptBox.setEditable(true);
        kdtEntrys_storageOrgUnit_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_storageOrgUnit_PromptBox.setEditFormat("$number$");
        kdtEntrys_storageOrgUnit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_storageOrgUnit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_storageOrgUnit_PromptBox);
        this.kdtEntrys.getColumn("storageOrgUnit").setEditor(kdtEntrys_storageOrgUnit_CellEditor);
        ObjectValueRender kdtEntrys_storageOrgUnit_OVR = new ObjectValueRender();
        kdtEntrys_storageOrgUnit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("storageOrgUnit").setRenderer(kdtEntrys_storageOrgUnit_OVR);
        KDTimePicker kdtEntrys_startTime_TimePicker = new KDTimePicker();
        kdtEntrys_startTime_TimePicker.setName("kdtEntrys_startTime_TimePicker");
        kdtEntrys_startTime_TimePicker.setVisible(true);
        KDTDefaultCellEditor kdtEntrys_startTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_startTime_TimePicker);
        this.kdtEntrys.getColumn("startTime").setEditor(kdtEntrys_startTime_CellEditor);
        KDTimePicker kdtEntrys_reachTime_TimePicker = new KDTimePicker();
        kdtEntrys_reachTime_TimePicker.setName("kdtEntrys_reachTime_TimePicker");
        kdtEntrys_reachTime_TimePicker.setVisible(true);
        KDTDefaultCellEditor kdtEntrys_reachTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_reachTime_TimePicker);
        this.kdtEntrys.getColumn("reachTime").setEditor(kdtEntrys_reachTime_CellEditor);
        KDTimePicker kdtEntrys_beginCatchTime_TimePicker = new KDTimePicker();
        kdtEntrys_beginCatchTime_TimePicker.setName("kdtEntrys_beginCatchTime_TimePicker");
        kdtEntrys_beginCatchTime_TimePicker.setVisible(true);
        KDTDefaultCellEditor kdtEntrys_beginCatchTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_beginCatchTime_TimePicker);
        this.kdtEntrys.getColumn("beginCatchTime").setEditor(kdtEntrys_beginCatchTime_CellEditor);
        KDTimePicker kdtEntrys_outTime_TimePicker = new KDTimePicker();
        kdtEntrys_outTime_TimePicker.setName("kdtEntrys_outTime_TimePicker");
        kdtEntrys_outTime_TimePicker.setVisible(true);
        KDTDefaultCellEditor kdtEntrys_outTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_outTime_TimePicker);
        this.kdtEntrys.getColumn("outTime").setEditor(kdtEntrys_outTime_CellEditor);
        KDTimePicker kdtEntrys_backTime_TimePicker = new KDTimePicker();
        kdtEntrys_backTime_TimePicker.setName("kdtEntrys_backTime_TimePicker");
        kdtEntrys_backTime_TimePicker.setVisible(true);
        KDTDefaultCellEditor kdtEntrys_backTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_backTime_TimePicker);
        this.kdtEntrys.getColumn("backTime").setEditor(kdtEntrys_backTime_CellEditor);
        KDTimePicker kdtEntrys_hitchTime_TimePicker = new KDTimePicker();
        kdtEntrys_hitchTime_TimePicker.setName("kdtEntrys_hitchTime_TimePicker");
        kdtEntrys_hitchTime_TimePicker.setVisible(true);
        KDTDefaultCellEditor kdtEntrys_hitchTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_hitchTime_TimePicker);
        this.kdtEntrys.getColumn("hitchTime").setEditor(kdtEntrys_hitchTime_CellEditor);
        KDTimePicker kdtEntrys_reStartTime_TimePicker = new KDTimePicker();
        kdtEntrys_reStartTime_TimePicker.setName("kdtEntrys_reStartTime_TimePicker");
        kdtEntrys_reStartTime_TimePicker.setVisible(true);
        KDTDefaultCellEditor kdtEntrys_reStartTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_reStartTime_TimePicker);
        this.kdtEntrys.getColumn("reStartTime").setEditor(kdtEntrys_reStartTime_CellEditor);
        KDFormattedTextField kdtEntrys_carCount_TextField = new KDFormattedTextField();
        kdtEntrys_carCount_TextField.setName("kdtEntrys_carCount_TextField");
        kdtEntrys_carCount_TextField.setVisible(true);
        kdtEntrys_carCount_TextField.setEditable(true);
        kdtEntrys_carCount_TextField.setHorizontalAlignment(2);
        kdtEntrys_carCount_TextField.setDataType(1);
        	kdtEntrys_carCount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_carCount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_carCount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_carCount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_carCount_TextField);
        this.kdtEntrys.getColumn("carCount").setEditor(kdtEntrys_carCount_CellEditor);
        // contcarCount		
        this.contcarCount.setBoundLabelText(resHelper.getString("contcarCount.boundLabelText"));		
        this.contcarCount.setBoundLabelLength(100);		
        this.contcarCount.setBoundLabelUnderline(true);		
        this.contcarCount.setVisible(true);
        // kdtOrgEntry
		String kdtOrgEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"isSelected\" t:width=\"40\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"order\" t:width=\"60\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"storageOrg\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"batch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"henhouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"dayAge\" t:width=\"50\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{isSelected}</t:Cell><t:Cell>$Resource{order}</t:Cell><t:Cell>$Resource{storageOrg}</t:Cell><t:Cell>$Resource{batch}</t:Cell><t:Cell>$Resource{henhouse}</t:Cell><t:Cell>$Resource{dayAge}</t:Cell><t:Cell>$Resource{qty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtOrgEntry.setFormatXml(resHelper.translateString("kdtOrgEntry",kdtOrgEntryStrXML));
        kdtOrgEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtOrgEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtOrgEntry.putBindContents("editData",new String[] {"seq","isSelected","order","storageOrg","batch","henhouse","dayAge","qty"});


        this.kdtOrgEntry.checkParsed();
        KDFormattedTextField kdtOrgEntry_seq_TextField = new KDFormattedTextField();
        kdtOrgEntry_seq_TextField.setName("kdtOrgEntry_seq_TextField");
        kdtOrgEntry_seq_TextField.setVisible(true);
        kdtOrgEntry_seq_TextField.setEditable(true);
        kdtOrgEntry_seq_TextField.setHorizontalAlignment(2);
        kdtOrgEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtOrgEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtOrgEntry_seq_TextField);
        this.kdtOrgEntry.getColumn("seq").setEditor(kdtOrgEntry_seq_CellEditor);
        KDCheckBox kdtOrgEntry_isSelected_CheckBox = new KDCheckBox();
        kdtOrgEntry_isSelected_CheckBox.setName("kdtOrgEntry_isSelected_CheckBox");
        KDTDefaultCellEditor kdtOrgEntry_isSelected_CellEditor = new KDTDefaultCellEditor(kdtOrgEntry_isSelected_CheckBox);
        this.kdtOrgEntry.getColumn("isSelected").setEditor(kdtOrgEntry_isSelected_CellEditor);
        KDComboBox kdtOrgEntry_order_ComboBox = new KDComboBox();
        kdtOrgEntry_order_ComboBox.setName("kdtOrgEntry_order_ComboBox");
        kdtOrgEntry_order_ComboBox.setVisible(true);
        kdtOrgEntry_order_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.food.orderEnum").toArray());
        KDTDefaultCellEditor kdtOrgEntry_order_CellEditor = new KDTDefaultCellEditor(kdtOrgEntry_order_ComboBox);
        this.kdtOrgEntry.getColumn("order").setEditor(kdtOrgEntry_order_CellEditor);
        final KDBizPromptBox kdtOrgEntry_storageOrg_PromptBox = new KDBizPromptBox();
        kdtOrgEntry_storageOrg_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");
        kdtOrgEntry_storageOrg_PromptBox.setVisible(true);
        kdtOrgEntry_storageOrg_PromptBox.setEditable(true);
        kdtOrgEntry_storageOrg_PromptBox.setDisplayFormat("$number$");
        kdtOrgEntry_storageOrg_PromptBox.setEditFormat("$number$");
        kdtOrgEntry_storageOrg_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtOrgEntry_storageOrg_CellEditor = new KDTDefaultCellEditor(kdtOrgEntry_storageOrg_PromptBox);
        this.kdtOrgEntry.getColumn("storageOrg").setEditor(kdtOrgEntry_storageOrg_CellEditor);
        ObjectValueRender kdtOrgEntry_storageOrg_OVR = new ObjectValueRender();
        kdtOrgEntry_storageOrg_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtOrgEntry.getColumn("storageOrg").setRenderer(kdtOrgEntry_storageOrg_OVR);
        final KDBizPromptBox kdtOrgEntry_batch_PromptBox = new KDBizPromptBox();
        kdtOrgEntry_batch_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.BreedBatchF7Query");
        kdtOrgEntry_batch_PromptBox.setVisible(true);
        kdtOrgEntry_batch_PromptBox.setEditable(true);
        kdtOrgEntry_batch_PromptBox.setDisplayFormat("$number$");
        kdtOrgEntry_batch_PromptBox.setEditFormat("$number$");
        kdtOrgEntry_batch_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtOrgEntry_batch_CellEditor = new KDTDefaultCellEditor(kdtOrgEntry_batch_PromptBox);
        this.kdtOrgEntry.getColumn("batch").setEditor(kdtOrgEntry_batch_CellEditor);
        ObjectValueRender kdtOrgEntry_batch_OVR = new ObjectValueRender();
        kdtOrgEntry_batch_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtOrgEntry.getColumn("batch").setRenderer(kdtOrgEntry_batch_OVR);
        final KDBizPromptBox kdtOrgEntry_henhouse_PromptBox = new KDBizPromptBox();
        kdtOrgEntry_henhouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseF7Query");
        kdtOrgEntry_henhouse_PromptBox.setVisible(true);
        kdtOrgEntry_henhouse_PromptBox.setEditable(true);
        kdtOrgEntry_henhouse_PromptBox.setDisplayFormat("$number$");
        kdtOrgEntry_henhouse_PromptBox.setEditFormat("$number$");
        kdtOrgEntry_henhouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtOrgEntry_henhouse_CellEditor = new KDTDefaultCellEditor(kdtOrgEntry_henhouse_PromptBox);
        this.kdtOrgEntry.getColumn("henhouse").setEditor(kdtOrgEntry_henhouse_CellEditor);
        ObjectValueRender kdtOrgEntry_henhouse_OVR = new ObjectValueRender();
        kdtOrgEntry_henhouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtOrgEntry.getColumn("henhouse").setRenderer(kdtOrgEntry_henhouse_OVR);
        KDFormattedTextField kdtOrgEntry_dayAge_TextField = new KDFormattedTextField();
        kdtOrgEntry_dayAge_TextField.setName("kdtOrgEntry_dayAge_TextField");
        kdtOrgEntry_dayAge_TextField.setVisible(true);
        kdtOrgEntry_dayAge_TextField.setEditable(true);
        kdtOrgEntry_dayAge_TextField.setHorizontalAlignment(2);
        kdtOrgEntry_dayAge_TextField.setDataType(0);
        KDTDefaultCellEditor kdtOrgEntry_dayAge_CellEditor = new KDTDefaultCellEditor(kdtOrgEntry_dayAge_TextField);
        this.kdtOrgEntry.getColumn("dayAge").setEditor(kdtOrgEntry_dayAge_CellEditor);
        KDFormattedTextField kdtOrgEntry_qty_TextField = new KDFormattedTextField();
        kdtOrgEntry_qty_TextField.setName("kdtOrgEntry_qty_TextField");
        kdtOrgEntry_qty_TextField.setVisible(true);
        kdtOrgEntry_qty_TextField.setEditable(true);
        kdtOrgEntry_qty_TextField.setHorizontalAlignment(2);
        kdtOrgEntry_qty_TextField.setDataType(1);
        	kdtOrgEntry_qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtOrgEntry_qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtOrgEntry_qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtOrgEntry_qty_CellEditor = new KDTDefaultCellEditor(kdtOrgEntry_qty_TextField);
        this.kdtOrgEntry.getColumn("qty").setEditor(kdtOrgEntry_qty_CellEditor);
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // btnGetPlan		
        this.btnGetPlan.setText(resHelper.getString("btnGetPlan.text"));
        this.btnGetPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnOK_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnGetOrgEntys		
        this.btnGetOrgEntys.setText(resHelper.getString("btnGetOrgEntys.text"));
        this.btnGetOrgEntys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnGetOrgEntys_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // contstorageOrgUnit		
        this.contstorageOrgUnit.setBoundLabelText(resHelper.getString("contstorageOrgUnit.boundLabelText"));		
        this.contstorageOrgUnit.setBoundLabelLength(100);		
        this.contstorageOrgUnit.setBoundLabelUnderline(true);		
        this.contstorageOrgUnit.setVisible(true);
        // contbillStatus		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);
        // conthitchTime		
        this.conthitchTime.setBoundLabelText(resHelper.getString("conthitchTime.boundLabelText"));		
        this.conthitchTime.setBoundLabelLength(100);		
        this.conthitchTime.setBoundLabelUnderline(true);		
        this.conthitchTime.setVisible(true);
        // contallQty		
        this.contallQty.setBoundLabelText(resHelper.getString("contallQty.boundLabelText"));		
        this.contallQty.setBoundLabelLength(100);		
        this.contallQty.setBoundLabelUnderline(true);		
        this.contallQty.setVisible(true);
        // conttransferTime		
        this.conttransferTime.setBoundLabelText(resHelper.getString("conttransferTime.boundLabelText"));		
        this.conttransferTime.setBoundLabelLength(75);		
        this.conttransferTime.setBoundLabelUnderline(true);		
        this.conttransferTime.setVisible(true);
        // contaheadTime		
        this.contaheadTime.setBoundLabelText(resHelper.getString("contaheadTime.boundLabelText"));		
        this.contaheadTime.setBoundLabelLength(75);		
        this.contaheadTime.setBoundLabelUnderline(true);		
        this.contaheadTime.setVisible(true);
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
        this.pkBizDate.setRequired(true);
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // txtcarCount		
        this.txtcarCount.setHorizontalAlignment(2);		
        this.txtcarCount.setDataType(1);		
        this.txtcarCount.setSupportedEmpty(true);		
        this.txtcarCount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcarCount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcarCount.setPrecision(4);		
        this.txtcarCount.setRequired(true);
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // prmtstorageOrgUnit		
        this.prmtstorageOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtstorageOrgUnit.setEditable(true);		
        this.prmtstorageOrgUnit.setDisplayFormat("$name$");		
        this.prmtstorageOrgUnit.setEditFormat("$number$");		
        this.prmtstorageOrgUnit.setCommitFormat("$number$");		
        this.prmtstorageOrgUnit.setRequired(true);
        // billStatus		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // pkhitchTime		
        this.pkhitchTime.setRequired(false);
        // txtallQty		
        this.txtallQty.setHorizontalAlignment(2);		
        this.txtallQty.setDataType(1);		
        this.txtallQty.setSupportedEmpty(true);		
        this.txtallQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallQty.setPrecision(4);		
        this.txtallQty.setRequired(false);
        // txttransferTime		
        this.txttransferTime.setHorizontalAlignment(2);		
        this.txttransferTime.setDataType(1);		
        this.txttransferTime.setSupportedEmpty(true);		
        this.txttransferTime.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttransferTime.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttransferTime.setPrecision(4);		
        this.txttransferTime.setRequired(false);
        // txtaheadTime		
        this.txtaheadTime.setHorizontalAlignment(2);		
        this.txtaheadTime.setDataType(1);		
        this.txtaheadTime.setSupportedEmpty(true);		
        this.txtaheadTime.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtaheadTime.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtaheadTime.setPrecision(4);		
        this.txtaheadTime.setRequired(false);
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
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,txtcarCount,pkauditTime,prmtstorageOrgUnit,billStatus,pkhitchTime,txtallQty,txttransferTime,txtaheadTime,kdtOrgEntry,kdtEntrys}));
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
        contCreator.setBounds(new Rectangle(369, 528, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(369, 528, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(725, 528, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(725, 528, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(369, 555, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(369, 555, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(725, 555, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(725, 555, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(14, 9, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(14, 9, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(368, 9, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(368, 9, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(14, 75, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(14, 75, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(14, 528, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(14, 528, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(408, 112, 587, 400));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.food.FoodSendCarPlanEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(408, 112, 587, 400, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcarCount.setBounds(new Rectangle(14, 42, 270, 19));
        this.add(contcarCount, new KDLayout.Constraints(14, 42, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtOrgEntry.setBounds(new Rectangle(14, 143, 379, 370));
        kdtOrgEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtOrgEntry,new com.kingdee.eas.farm.food.FoodSendCarPlanOrgEntryInfo(),null,false);
        this.add(kdtOrgEntry_detailPanel, new KDLayout.Constraints(14, 143, 379, 370, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
		kdtOrgEntry_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("order",new Integer(0));
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        contauditTime.setBounds(new Rectangle(14, 555, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(14, 555, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnGetPlan.setBounds(new Rectangle(280, 110, 113, 21));
        this.add(btnGetPlan, new KDLayout.Constraints(280, 110, 113, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnGetOrgEntys.setBounds(new Rectangle(14, 108, 119, 21));
        this.add(btnGetOrgEntys, new KDLayout.Constraints(14, 108, 119, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contstorageOrgUnit.setBounds(new Rectangle(725, 9, 270, 19));
        this.add(contstorageOrgUnit, new KDLayout.Constraints(725, 9, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbillStatus.setBounds(new Rectangle(725, 42, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(725, 42, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conthitchTime.setBounds(new Rectangle(368, 42, 270, 19));
        this.add(conthitchTime, new KDLayout.Constraints(368, 42, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contallQty.setBounds(new Rectangle(368, 75, 270, 19));
        this.add(contallQty, new KDLayout.Constraints(368, 75, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttransferTime.setBounds(new Rectangle(861, 75, 134, 19));
        this.add(conttransferTime, new KDLayout.Constraints(861, 75, 134, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contaheadTime.setBounds(new Rectangle(725, 75, 134, 19));
        this.add(contaheadTime, new KDLayout.Constraints(725, 75, 134, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contcarCount
        contcarCount.setBoundEditor(txtcarCount);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contstorageOrgUnit
        contstorageOrgUnit.setBoundEditor(prmtstorageOrgUnit);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //conthitchTime
        conthitchTime.setBoundEditor(pkhitchTime);
        //contallQty
        contallQty.setBoundEditor(txtallQty);
        //conttransferTime
        conttransferTime.setBoundEditor(txttransferTime);
        //contaheadTime
        contaheadTime.setBoundEditor(txtaheadTime);

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
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.food.FoodSendCarPlanEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.carNo", String.class, this.kdtEntrys, "carNo.text");
		dataBinder.registerBinding("entrys.startTime", java.sql.Time.class, this.kdtEntrys, "startTime.text");
		dataBinder.registerBinding("entrys.reachTime", java.sql.Time.class, this.kdtEntrys, "reachTime.text");
		dataBinder.registerBinding("entrys.outTime", java.sql.Time.class, this.kdtEntrys, "outTime.text");
		dataBinder.registerBinding("entrys.backTime", java.sql.Time.class, this.kdtEntrys, "backTime.text");
		dataBinder.registerBinding("entrys.reStartTime", java.sql.Time.class, this.kdtEntrys, "reStartTime.text");
		dataBinder.registerBinding("entrys.carCount", java.math.BigDecimal.class, this.kdtEntrys, "carCount.text");
		dataBinder.registerBinding("entrys.storageOrgUnit", java.lang.Object.class, this.kdtEntrys, "storageOrgUnit.text");
		dataBinder.registerBinding("entrys.beginCatchTime", java.sql.Time.class, this.kdtEntrys, "beginCatchTime.text");
		dataBinder.registerBinding("entrys.hitchTime", java.sql.Time.class, this.kdtEntrys, "hitchTime.text");
		dataBinder.registerBinding("OrgEntry.seq", int.class, this.kdtOrgEntry, "seq.text");
		dataBinder.registerBinding("OrgEntry", com.kingdee.eas.farm.food.FoodSendCarPlanOrgEntryInfo.class, this.kdtOrgEntry, "userObject");
		dataBinder.registerBinding("OrgEntry.isSelected", boolean.class, this.kdtOrgEntry, "isSelected.text");
		dataBinder.registerBinding("OrgEntry.storageOrg", java.lang.Object.class, this.kdtOrgEntry, "storageOrg.text");
		dataBinder.registerBinding("OrgEntry.dayAge", int.class, this.kdtOrgEntry, "dayAge.text");
		dataBinder.registerBinding("OrgEntry.qty", java.math.BigDecimal.class, this.kdtOrgEntry, "qty.text");
		dataBinder.registerBinding("OrgEntry.henhouse", java.lang.Object.class, this.kdtOrgEntry, "henhouse.text");
		dataBinder.registerBinding("OrgEntry.batch", java.lang.Object.class, this.kdtOrgEntry, "batch.text");
		dataBinder.registerBinding("OrgEntry.order", com.kingdee.util.enums.Enum.class, this.kdtOrgEntry, "order.text");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("carCount", java.math.BigDecimal.class, this.txtcarCount, "value");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("storageOrgUnit", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtstorageOrgUnit, "data");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("hitchTime", java.util.Date.class, this.pkhitchTime, "value");
		dataBinder.registerBinding("allQty", java.math.BigDecimal.class, this.txtallQty, "value");
		dataBinder.registerBinding("transferTime", java.math.BigDecimal.class, this.txttransferTime, "value");
		dataBinder.registerBinding("aheadTime", java.math.BigDecimal.class, this.txtaheadTime, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.food.app.FoodSendCarPlanEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.food.FoodSendCarPlanInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.carNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.startTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.reachTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.outTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.backTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.reStartTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.carCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.storageOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.beginCatchTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.hitchTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OrgEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OrgEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OrgEntry.isSelected", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OrgEntry.storageOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OrgEntry.dayAge", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OrgEntry.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OrgEntry.henhouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OrgEntry.batch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("OrgEntry.order", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("carCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("storageOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hitchTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("transferTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("aheadTime", ValidateHelper.ON_SAVE);    		
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
     * output btnOK_actionPerformed method
     */
    protected void btnOK_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output btnGetOrgEntys_actionPerformed method
     */
    protected void btnGetOrgEntys_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }


    /**
     * output kdtOrgEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtOrgEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("order".equalsIgnoreCase(kdtOrgEntry.getColumn(colIndex).getKey())) {
txtallQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(0));

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
    	sic.add(new SelectorItemInfo("entrys.carNo"));
    	sic.add(new SelectorItemInfo("entrys.startTime"));
    	sic.add(new SelectorItemInfo("entrys.reachTime"));
    	sic.add(new SelectorItemInfo("entrys.outTime"));
    	sic.add(new SelectorItemInfo("entrys.backTime"));
    	sic.add(new SelectorItemInfo("entrys.reStartTime"));
    	sic.add(new SelectorItemInfo("entrys.carCount"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.storageOrgUnit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.storageOrgUnit.id"));
			sic.add(new SelectorItemInfo("entrys.storageOrgUnit.name"));
        	sic.add(new SelectorItemInfo("entrys.storageOrgUnit.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.beginCatchTime"));
    	sic.add(new SelectorItemInfo("entrys.hitchTime"));
    	sic.add(new SelectorItemInfo("OrgEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("OrgEntry.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("OrgEntry.isSelected"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("OrgEntry.storageOrg.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("OrgEntry.storageOrg.id"));
			sic.add(new SelectorItemInfo("OrgEntry.storageOrg.name"));
        	sic.add(new SelectorItemInfo("OrgEntry.storageOrg.number"));
		}
    	sic.add(new SelectorItemInfo("OrgEntry.dayAge"));
    	sic.add(new SelectorItemInfo("OrgEntry.qty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("OrgEntry.henhouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("OrgEntry.henhouse.id"));
			sic.add(new SelectorItemInfo("OrgEntry.henhouse.name"));
        	sic.add(new SelectorItemInfo("OrgEntry.henhouse.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("OrgEntry.batch.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("OrgEntry.batch.id"));
			sic.add(new SelectorItemInfo("OrgEntry.batch.number"));
		}
    	sic.add(new SelectorItemInfo("OrgEntry.order"));
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
        sic.add(new SelectorItemInfo("carCount"));
        sic.add(new SelectorItemInfo("auditTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("storageOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("storageOrgUnit.id"));
        	sic.add(new SelectorItemInfo("storageOrgUnit.number"));
        	sic.add(new SelectorItemInfo("storageOrgUnit.name"));
		}
        sic.add(new SelectorItemInfo("billStatus"));
        sic.add(new SelectorItemInfo("hitchTime"));
        sic.add(new SelectorItemInfo("allQty"));
        sic.add(new SelectorItemInfo("transferTime"));
        sic.add(new SelectorItemInfo("aheadTime"));
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
        com.kingdee.eas.farm.food.FoodSendCarPlanFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.food.FoodSendCarPlanFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractFoodSendCarPlanEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractFoodSendCarPlanEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.food.client", "FoodSendCarPlanEditUI");
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
        return com.kingdee.eas.farm.food.client.FoodSendCarPlanEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.food.FoodSendCarPlanFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.food.FoodSendCarPlanInfo objectValue = new com.kingdee.eas.farm.food.FoodSendCarPlanInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/food/FoodSendCarPlan";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.food.app.FoodSendCarPlanQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtcarCount.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"派车数量"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtstorageOrgUnit.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"库存组织"});
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
		vo.put("billStatus",new Integer(-1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}