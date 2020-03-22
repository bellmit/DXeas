/**
 * output package name
 */
package com.kingdee.eas.farm.dayratecost.client;

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
public abstract class AbstractCostAllocationEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCostAllocationEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator9;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperiod;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtDetail;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtDetail_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallocationType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmGroup;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmerGroup;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarm;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperiod;
    protected com.kingdee.bos.ctrl.swing.KDComboBox allocationType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmGroup;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmerGroup;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnExeAllocation;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnExeAllocation;
    protected com.kingdee.bos.ctrl.swing.KDSeparator newSeparator3;
    protected com.kingdee.eas.farm.dayratecost.CostAllocationInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionExeAllocation actionExeAllocation = null;
    /**
     * output class constructor
     */
    public AbstractCostAllocationEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCostAllocationEditUI.class.getName());
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
        this.actionAudit.setExtendProperty("userDefined", "false");
        this.actionAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionUnAudit
        this.actionUnAudit = new ActionUnAudit(this);
        getActionManager().registerAction("actionUnAudit", actionUnAudit);
        this.actionUnAudit.setExtendProperty("canForewarn", "true");
        this.actionUnAudit.setExtendProperty("userDefined", "false");
        this.actionUnAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionExeAllocation
        this.actionExeAllocation = new ActionExeAllocation(this);
        getActionManager().registerAction("actionExeAllocation", actionExeAllocation);
        this.actionExeAllocation.setExtendProperty("canForewarn", "true");
        this.actionExeAllocation.setExtendProperty("userDefined", "false");
        this.actionExeAllocation.setExtendProperty("isObjectUpdateLock", "false");
         this.actionExeAllocation.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionExeAllocation.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDSeparator9 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contfarmer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperiod = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtDetail = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contallocationType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmGroup = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmerGroup = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtfarmer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtfarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtperiod = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.allocationType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtfarmGroup = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtfarmerGroup = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.tBtnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnExeAllocation = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.mBtnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.mBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.mBtnExeAllocation = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.newSeparator3 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.contbillStatus.setName("contbillStatus");
        this.contcompany.setName("contcompany");
        this.contauditTime.setName("contauditTime");
        this.kDSeparator8.setName("kDSeparator8");
        this.kDSeparator9.setName("kDSeparator9");
        this.kdtEntrys.setName("kdtEntrys");
        this.contfarmer.setName("contfarmer");
        this.contfarm.setName("contfarm");
        this.contperiod.setName("contperiod");
        this.kdtDetail.setName("kdtDetail");
        this.contallocationType.setName("contallocationType");
        this.contfarmGroup.setName("contfarmGroup");
        this.contfarmerGroup.setName("contfarmerGroup");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.billStatus.setName("billStatus");
        this.prmtcompany.setName("prmtcompany");
        this.pkauditTime.setName("pkauditTime");
        this.prmtfarmer.setName("prmtfarmer");
        this.prmtfarm.setName("prmtfarm");
        this.prmtperiod.setName("prmtperiod");
        this.allocationType.setName("allocationType");
        this.prmtfarmGroup.setName("prmtfarmGroup");
        this.prmtfarmerGroup.setName("prmtfarmerGroup");
        this.tBtnAudit.setName("tBtnAudit");
        this.tBtnUnAudit.setName("tBtnUnAudit");
        this.tBtnExeAllocation.setName("tBtnExeAllocation");
        this.mBtnAudit.setName("mBtnAudit");
        this.mBtnUnAudit.setName("mBtnUnAudit");
        this.mBtnExeAllocation.setName("mBtnExeAllocation");
        this.newSeparator3.setName("newSeparator3");
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
        // contbillStatus		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // kDSeparator8
        // kDSeparator9
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"feeItem\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{feeItem}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{remark}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));

                this.kdtEntrys.putBindContents("editData",new String[] {"id","feeItem","amount","remark"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_feeItem_PromptBox = new KDBizPromptBox();
        kdtEntrys_feeItem_PromptBox.setQueryInfo("com.kingdee.eas.farm.dayratecost.app.DayrateFeeItemQuery");
        kdtEntrys_feeItem_PromptBox.setVisible(true);
        kdtEntrys_feeItem_PromptBox.setEditable(true);
        kdtEntrys_feeItem_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_feeItem_PromptBox.setEditFormat("$number$");
        kdtEntrys_feeItem_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_feeItem_CellEditor = new KDTDefaultCellEditor(kdtEntrys_feeItem_PromptBox);
        this.kdtEntrys.getColumn("feeItem").setEditor(kdtEntrys_feeItem_CellEditor);
        ObjectValueRender kdtEntrys_feeItem_OVR = new ObjectValueRender();
        kdtEntrys_feeItem_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("feeItem").setRenderer(kdtEntrys_feeItem_OVR);
        			kdtEntrys_feeItem_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.dayratecost.client.DayrateFeeItemListUI kdtEntrys_feeItem_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_feeItem_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_feeItem_PromptBox_F7ListUI = new com.kingdee.eas.farm.dayratecost.client.DayrateFeeItemListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_feeItem_PromptBox_F7ListUI));
					kdtEntrys_feeItem_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_feeItem_PromptBox.setSelector(kdtEntrys_feeItem_PromptBox_F7ListUI);
				}
			}
		});
					
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
        KDTextField kdtEntrys_remark_TextField = new KDTextField();
        kdtEntrys_remark_TextField.setName("kdtEntrys_remark_TextField");
        kdtEntrys_remark_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_remark_CellEditor = new KDTDefaultCellEditor(kdtEntrys_remark_TextField);
        this.kdtEntrys.getColumn("remark").setEditor(kdtEntrys_remark_CellEditor);
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
        // contperiod		
        this.contperiod.setBoundLabelText(resHelper.getString("contperiod.boundLabelText"));		
        this.contperiod.setBoundLabelLength(100);		
        this.contperiod.setBoundLabelUnderline(true);		
        this.contperiod.setVisible(true);
        // kdtDetail
		String kdtDetailStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"farmer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"1\" /><t:Column t:key=\"farm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"2\" /><t:Column t:key=\"house\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"3\" /><t:Column t:key=\"stockingBatch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" /><t:Column t:key=\"proportion\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"7\" t:styleID=\"sCol5\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" t:styleID=\"sCol6\" /><t:Column t:key=\"breedStage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"9\" /><t:Column t:key=\"matureDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"10\" t:styleID=\"sCol8\" /><t:Column t:key=\"matureprop\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"11\" t:styleID=\"sCol9\" /><t:Column t:key=\"matureAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"13\" t:styleID=\"sCol10\" /><t:Column t:key=\"alloctionAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"14\" t:styleID=\"sCol11\" /><t:Column t:key=\"lastStock\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"allLastStock\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"matureQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"proportion2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{farmer}</t:Cell><t:Cell>$Resource{farm}</t:Cell><t:Cell>$Resource{house}</t:Cell><t:Cell>$Resource{stockingBatch}</t:Cell><t:Cell>$Resource{proportion}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{breedStage}</t:Cell><t:Cell>$Resource{matureDate}</t:Cell><t:Cell>$Resource{matureprop}</t:Cell><t:Cell>$Resource{matureAmount}</t:Cell><t:Cell>$Resource{alloctionAmount}</t:Cell><t:Cell>$Resource{lastStock}</t:Cell><t:Cell>$Resource{allLastStock}</t:Cell><t:Cell>$Resource{matureQty}</t:Cell><t:Cell>$Resource{proportion2}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtDetail.setFormatXml(resHelper.translateString("kdtDetail",kdtDetailStrXML));

                this.kdtDetail.putBindContents("editData",new String[] {"Detail.seq","Detail.farmer","Detail.farm","Detail.house","Detail.stockingBatch","Detail.proportion","Detail.amount","Detail.breedStage","Detail.matureDate","Detail.matureprop","Detail.matureAmount","Detail.alloctionAmount","Detail.lastStock","Detail.allLastStock","Detail.matureQty","Detail.proportion2"});


        this.kdtDetail.checkParsed();
        KDFormattedTextField kdtDetail_seq_TextField = new KDFormattedTextField();
        kdtDetail_seq_TextField.setName("kdtDetail_seq_TextField");
        kdtDetail_seq_TextField.setVisible(true);
        kdtDetail_seq_TextField.setEditable(true);
        kdtDetail_seq_TextField.setHorizontalAlignment(2);
        kdtDetail_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtDetail_seq_CellEditor = new KDTDefaultCellEditor(kdtDetail_seq_TextField);
        this.kdtDetail.getColumn("seq").setEditor(kdtDetail_seq_CellEditor);
        final KDBizPromptBox kdtDetail_farmer_PromptBox = new KDBizPromptBox();
        kdtDetail_farmer_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmersQuery");
        kdtDetail_farmer_PromptBox.setVisible(true);
        kdtDetail_farmer_PromptBox.setEditable(true);
        kdtDetail_farmer_PromptBox.setDisplayFormat("$number$");
        kdtDetail_farmer_PromptBox.setEditFormat("$number$");
        kdtDetail_farmer_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtDetail_farmer_CellEditor = new KDTDefaultCellEditor(kdtDetail_farmer_PromptBox);
        this.kdtDetail.getColumn("farmer").setEditor(kdtDetail_farmer_CellEditor);
        ObjectValueRender kdtDetail_farmer_OVR = new ObjectValueRender();
        kdtDetail_farmer_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtDetail.getColumn("farmer").setRenderer(kdtDetail_farmer_OVR);
        			kdtDetail_farmer_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI kdtDetail_farmer_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtDetail_farmer_PromptBox_F7ListUI == null) {
					try {
						kdtDetail_farmer_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtDetail_farmer_PromptBox_F7ListUI));
					kdtDetail_farmer_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtDetail_farmer_PromptBox.setSelector(kdtDetail_farmer_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtDetail_farm_PromptBox = new KDBizPromptBox();
        kdtDetail_farm_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmQuery");
        kdtDetail_farm_PromptBox.setVisible(true);
        kdtDetail_farm_PromptBox.setEditable(true);
        kdtDetail_farm_PromptBox.setDisplayFormat("$number$");
        kdtDetail_farm_PromptBox.setEditFormat("$number$");
        kdtDetail_farm_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtDetail_farm_CellEditor = new KDTDefaultCellEditor(kdtDetail_farm_PromptBox);
        this.kdtDetail.getColumn("farm").setEditor(kdtDetail_farm_CellEditor);
        ObjectValueRender kdtDetail_farm_OVR = new ObjectValueRender();
        kdtDetail_farm_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtDetail.getColumn("farm").setRenderer(kdtDetail_farm_OVR);
        			kdtDetail_farm_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmListUI kdtDetail_farm_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtDetail_farm_PromptBox_F7ListUI == null) {
					try {
						kdtDetail_farm_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtDetail_farm_PromptBox_F7ListUI));
					kdtDetail_farm_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtDetail_farm_PromptBox.setSelector(kdtDetail_farm_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtDetail_house_PromptBox = new KDBizPromptBox();
        kdtDetail_house_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
        kdtDetail_house_PromptBox.setVisible(true);
        kdtDetail_house_PromptBox.setEditable(true);
        kdtDetail_house_PromptBox.setDisplayFormat("$number$");
        kdtDetail_house_PromptBox.setEditFormat("$number$");
        kdtDetail_house_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtDetail_house_CellEditor = new KDTDefaultCellEditor(kdtDetail_house_PromptBox);
        this.kdtDetail.getColumn("house").setEditor(kdtDetail_house_CellEditor);
        ObjectValueRender kdtDetail_house_OVR = new ObjectValueRender();
        kdtDetail_house_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtDetail.getColumn("house").setRenderer(kdtDetail_house_OVR);
        final KDBizPromptBox kdtDetail_stockingBatch_PromptBox = new KDBizPromptBox();
        kdtDetail_stockingBatch_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.StockingBatchQuery");
        kdtDetail_stockingBatch_PromptBox.setVisible(true);
        kdtDetail_stockingBatch_PromptBox.setEditable(true);
        kdtDetail_stockingBatch_PromptBox.setDisplayFormat("$number$");
        kdtDetail_stockingBatch_PromptBox.setEditFormat("$number$");
        kdtDetail_stockingBatch_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtDetail_stockingBatch_CellEditor = new KDTDefaultCellEditor(kdtDetail_stockingBatch_PromptBox);
        this.kdtDetail.getColumn("stockingBatch").setEditor(kdtDetail_stockingBatch_CellEditor);
        ObjectValueRender kdtDetail_stockingBatch_OVR = new ObjectValueRender();
        kdtDetail_stockingBatch_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtDetail.getColumn("stockingBatch").setRenderer(kdtDetail_stockingBatch_OVR);
        			kdtDetail_stockingBatch_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI kdtDetail_stockingBatch_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtDetail_stockingBatch_PromptBox_F7ListUI == null) {
					try {
						kdtDetail_stockingBatch_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtDetail_stockingBatch_PromptBox_F7ListUI));
					kdtDetail_stockingBatch_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtDetail_stockingBatch_PromptBox.setSelector(kdtDetail_stockingBatch_PromptBox_F7ListUI);
				}
			}
		});
					
        KDFormattedTextField kdtDetail_proportion_TextField = new KDFormattedTextField();
        kdtDetail_proportion_TextField.setName("kdtDetail_proportion_TextField");
        kdtDetail_proportion_TextField.setVisible(true);
        kdtDetail_proportion_TextField.setEditable(true);
        kdtDetail_proportion_TextField.setHorizontalAlignment(2);
        kdtDetail_proportion_TextField.setDataType(1);
        	kdtDetail_proportion_TextField.setMinimumValue(new java.math.BigDecimal("-999.99"));
        	kdtDetail_proportion_TextField.setMaximumValue(new java.math.BigDecimal("999.99"));
        kdtDetail_proportion_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtDetail_proportion_CellEditor = new KDTDefaultCellEditor(kdtDetail_proportion_TextField);
        this.kdtDetail.getColumn("proportion").setEditor(kdtDetail_proportion_CellEditor);
        KDFormattedTextField kdtDetail_amount_TextField = new KDFormattedTextField();
        kdtDetail_amount_TextField.setName("kdtDetail_amount_TextField");
        kdtDetail_amount_TextField.setVisible(true);
        kdtDetail_amount_TextField.setEditable(true);
        kdtDetail_amount_TextField.setHorizontalAlignment(2);
        kdtDetail_amount_TextField.setDataType(1);
        	kdtDetail_amount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtDetail_amount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtDetail_amount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtDetail_amount_CellEditor = new KDTDefaultCellEditor(kdtDetail_amount_TextField);
        this.kdtDetail.getColumn("amount").setEditor(kdtDetail_amount_CellEditor);
        KDComboBox kdtDetail_breedStage_ComboBox = new KDComboBox();
        kdtDetail_breedStage_ComboBox.setName("kdtDetail_breedStage_ComboBox");
        kdtDetail_breedStage_ComboBox.setVisible(true);
        kdtDetail_breedStage_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.FarmStageEnum").toArray());
        KDTDefaultCellEditor kdtDetail_breedStage_CellEditor = new KDTDefaultCellEditor(kdtDetail_breedStage_ComboBox);
        this.kdtDetail.getColumn("breedStage").setEditor(kdtDetail_breedStage_CellEditor);
        KDDatePicker kdtDetail_matureDate_DatePicker = new KDDatePicker();
        kdtDetail_matureDate_DatePicker.setName("kdtDetail_matureDate_DatePicker");
        kdtDetail_matureDate_DatePicker.setVisible(true);
        kdtDetail_matureDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtDetail_matureDate_CellEditor = new KDTDefaultCellEditor(kdtDetail_matureDate_DatePicker);
        this.kdtDetail.getColumn("matureDate").setEditor(kdtDetail_matureDate_CellEditor);
        KDFormattedTextField kdtDetail_matureprop_TextField = new KDFormattedTextField();
        kdtDetail_matureprop_TextField.setName("kdtDetail_matureprop_TextField");
        kdtDetail_matureprop_TextField.setVisible(true);
        kdtDetail_matureprop_TextField.setEditable(true);
        kdtDetail_matureprop_TextField.setHorizontalAlignment(2);
        kdtDetail_matureprop_TextField.setDataType(1);
        	kdtDetail_matureprop_TextField.setMinimumValue(new java.math.BigDecimal("-999.99"));
        	kdtDetail_matureprop_TextField.setMaximumValue(new java.math.BigDecimal("999.99"));
        kdtDetail_matureprop_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtDetail_matureprop_CellEditor = new KDTDefaultCellEditor(kdtDetail_matureprop_TextField);
        this.kdtDetail.getColumn("matureprop").setEditor(kdtDetail_matureprop_CellEditor);
        KDFormattedTextField kdtDetail_matureAmount_TextField = new KDFormattedTextField();
        kdtDetail_matureAmount_TextField.setName("kdtDetail_matureAmount_TextField");
        kdtDetail_matureAmount_TextField.setVisible(true);
        kdtDetail_matureAmount_TextField.setEditable(true);
        kdtDetail_matureAmount_TextField.setHorizontalAlignment(2);
        kdtDetail_matureAmount_TextField.setDataType(1);
        	kdtDetail_matureAmount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtDetail_matureAmount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtDetail_matureAmount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtDetail_matureAmount_CellEditor = new KDTDefaultCellEditor(kdtDetail_matureAmount_TextField);
        this.kdtDetail.getColumn("matureAmount").setEditor(kdtDetail_matureAmount_CellEditor);
        KDFormattedTextField kdtDetail_alloctionAmount_TextField = new KDFormattedTextField();
        kdtDetail_alloctionAmount_TextField.setName("kdtDetail_alloctionAmount_TextField");
        kdtDetail_alloctionAmount_TextField.setVisible(true);
        kdtDetail_alloctionAmount_TextField.setEditable(true);
        kdtDetail_alloctionAmount_TextField.setHorizontalAlignment(2);
        kdtDetail_alloctionAmount_TextField.setDataType(1);
        	kdtDetail_alloctionAmount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtDetail_alloctionAmount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtDetail_alloctionAmount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtDetail_alloctionAmount_CellEditor = new KDTDefaultCellEditor(kdtDetail_alloctionAmount_TextField);
        this.kdtDetail.getColumn("alloctionAmount").setEditor(kdtDetail_alloctionAmount_CellEditor);
        KDFormattedTextField kdtDetail_lastStock_TextField = new KDFormattedTextField();
        kdtDetail_lastStock_TextField.setName("kdtDetail_lastStock_TextField");
        kdtDetail_lastStock_TextField.setVisible(true);
        kdtDetail_lastStock_TextField.setEditable(true);
        kdtDetail_lastStock_TextField.setHorizontalAlignment(2);
        kdtDetail_lastStock_TextField.setDataType(0);
        KDTDefaultCellEditor kdtDetail_lastStock_CellEditor = new KDTDefaultCellEditor(kdtDetail_lastStock_TextField);
        this.kdtDetail.getColumn("lastStock").setEditor(kdtDetail_lastStock_CellEditor);
        KDFormattedTextField kdtDetail_allLastStock_TextField = new KDFormattedTextField();
        kdtDetail_allLastStock_TextField.setName("kdtDetail_allLastStock_TextField");
        kdtDetail_allLastStock_TextField.setVisible(true);
        kdtDetail_allLastStock_TextField.setEditable(true);
        kdtDetail_allLastStock_TextField.setHorizontalAlignment(2);
        kdtDetail_allLastStock_TextField.setDataType(0);
        KDTDefaultCellEditor kdtDetail_allLastStock_CellEditor = new KDTDefaultCellEditor(kdtDetail_allLastStock_TextField);
        this.kdtDetail.getColumn("allLastStock").setEditor(kdtDetail_allLastStock_CellEditor);
        KDFormattedTextField kdtDetail_matureQty_TextField = new KDFormattedTextField();
        kdtDetail_matureQty_TextField.setName("kdtDetail_matureQty_TextField");
        kdtDetail_matureQty_TextField.setVisible(true);
        kdtDetail_matureQty_TextField.setEditable(true);
        kdtDetail_matureQty_TextField.setHorizontalAlignment(2);
        kdtDetail_matureQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtDetail_matureQty_CellEditor = new KDTDefaultCellEditor(kdtDetail_matureQty_TextField);
        this.kdtDetail.getColumn("matureQty").setEditor(kdtDetail_matureQty_CellEditor);
        KDFormattedTextField kdtDetail_proportion2_TextField = new KDFormattedTextField();
        kdtDetail_proportion2_TextField.setName("kdtDetail_proportion2_TextField");
        kdtDetail_proportion2_TextField.setVisible(true);
        kdtDetail_proportion2_TextField.setEditable(true);
        kdtDetail_proportion2_TextField.setHorizontalAlignment(2);
        kdtDetail_proportion2_TextField.setDataType(1);
        	kdtDetail_proportion2_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtDetail_proportion2_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtDetail_proportion2_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtDetail_proportion2_CellEditor = new KDTDefaultCellEditor(kdtDetail_proportion2_TextField);
        this.kdtDetail.getColumn("proportion2").setEditor(kdtDetail_proportion2_CellEditor);
        // contallocationType		
        this.contallocationType.setBoundLabelText(resHelper.getString("contallocationType.boundLabelText"));		
        this.contallocationType.setBoundLabelLength(100);		
        this.contallocationType.setBoundLabelUnderline(true);		
        this.contallocationType.setVisible(true);
        // contfarmGroup		
        this.contfarmGroup.setBoundLabelText(resHelper.getString("contfarmGroup.boundLabelText"));		
        this.contfarmGroup.setBoundLabelLength(100);		
        this.contfarmGroup.setBoundLabelUnderline(true);		
        this.contfarmGroup.setVisible(true);
        // contfarmerGroup		
        this.contfarmerGroup.setBoundLabelText(resHelper.getString("contfarmerGroup.boundLabelText"));		
        this.contfarmerGroup.setBoundLabelLength(100);		
        this.contfarmerGroup.setBoundLabelUnderline(true);		
        this.contfarmerGroup.setVisible(true);
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
        // billStatus		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // prmtfarmer		
        this.prmtfarmer.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmersQuery");		
        this.prmtfarmer.setEditable(true);		
        this.prmtfarmer.setDisplayFormat("$name$");		
        this.prmtfarmer.setEditFormat("$number$");		
        this.prmtfarmer.setCommitFormat("$number$");		
        this.prmtfarmer.setRequired(false);
        		prmtfarmer.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI prmtfarmer_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarmer_F7ListUI == null) {
					try {
						prmtfarmer_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI();
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
        this.prmtfarm.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmQuery");		
        this.prmtfarm.setEditable(true);		
        this.prmtfarm.setDisplayFormat("$name$");		
        this.prmtfarm.setEditFormat("$number$");		
        this.prmtfarm.setCommitFormat("$number$");		
        this.prmtfarm.setRequired(false);
        		prmtfarm.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmListUI prmtfarm_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarm_F7ListUI == null) {
					try {
						prmtfarm_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmListUI();
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
					
        // prmtperiod		
        this.prmtperiod.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7PeriodQuery");		
        this.prmtperiod.setEditable(true);		
        this.prmtperiod.setDisplayFormat("$number$");		
        this.prmtperiod.setEditFormat("$number$");		
        this.prmtperiod.setCommitFormat("$number$");		
        this.prmtperiod.setRequired(true);
        // allocationType		
        this.allocationType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.dayratecost.AllocationTypeEnum").toArray());		
        this.allocationType.setRequired(true);
        // prmtfarmGroup		
        this.prmtfarmGroup.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmGroupQuery");		
        this.prmtfarmGroup.setEditable(true);		
        this.prmtfarmGroup.setDisplayFormat("$name$");		
        this.prmtfarmGroup.setEditFormat("$number$");		
        this.prmtfarmGroup.setCommitFormat("$number$");		
        this.prmtfarmGroup.setRequired(false);
        // prmtfarmerGroup		
        this.prmtfarmerGroup.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmerGroupQuery");		
        this.prmtfarmerGroup.setEditable(true);		
        this.prmtfarmerGroup.setDisplayFormat("$name$");		
        this.prmtfarmerGroup.setEditFormat("$number$");		
        this.prmtfarmerGroup.setCommitFormat("$number$");		
        this.prmtfarmerGroup.setRequired(false);
        // tBtnAudit
        this.tBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnAudit.setText(resHelper.getString("tBtnAudit.text"));
        // tBtnUnAudit
        this.tBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnUnAudit.setText(resHelper.getString("tBtnUnAudit.text"));
        // tBtnExeAllocation
        this.tBtnExeAllocation.setAction((IItemAction)ActionProxyFactory.getProxy(actionExeAllocation, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnExeAllocation.setText(resHelper.getString("tBtnExeAllocation.text"));
        // mBtnAudit
        this.mBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnAudit.setText(resHelper.getString("mBtnAudit.text"));
        // mBtnUnAudit
        this.mBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnUnAudit.setText(resHelper.getString("mBtnUnAudit.text"));
        // mBtnExeAllocation
        this.mBtnExeAllocation.setAction((IItemAction)ActionProxyFactory.getProxy(actionExeAllocation, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnExeAllocation.setText(resHelper.getString("mBtnExeAllocation.text"));
        // newSeparator3
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {kdtDetail,txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,billStatus,prmtcompany,pkauditTime,prmtfarmer,prmtfarm,prmtperiod,allocationType,prmtfarmerGroup,prmtfarmGroup,kdtEntrys}));
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
        contCreator.setBounds(new Rectangle(379, 549, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(379, 549, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(718, 549, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(718, 549, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(379, 582, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(379, 582, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(718, 582, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(718, 582, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(20, 20, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(20, 20, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(371, 20, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(371, 20, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(711, 87, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(711, 87, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(29, 549, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(29, 549, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(711, 20, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(711, 20, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompany.setBounds(new Rectangle(20, 53, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(20, 53, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(29, 582, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(29, 582, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator8.setBounds(new Rectangle(17, 534, 980, 10));
        this.add(kDSeparator8, new KDLayout.Constraints(17, 534, 980, 10, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator9.setBounds(new Rectangle(6, 119, 986, 8));
        this.add(kDSeparator9, new KDLayout.Constraints(6, 119, 986, 8, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kdtEntrys.setBounds(new Rectangle(20, 137, 968, 152));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.dayratecost.CostAllocationEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(20, 137, 968, 152, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contfarmer.setBounds(new Rectangle(20, 87, 270, 19));
        this.add(contfarmer, new KDLayout.Constraints(20, 87, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarm.setBounds(new Rectangle(371, 87, 270, 19));
        this.add(contfarm, new KDLayout.Constraints(371, 87, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contperiod.setBounds(new Rectangle(371, 53, 270, 19));
        this.add(contperiod, new KDLayout.Constraints(371, 53, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtDetail.setBounds(new Rectangle(20, 297, 967, 222));
        kdtDetail_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtDetail,new com.kingdee.eas.farm.dayratecost.CostAllocationEntryDetailInfo(),null,false);
        this.add(kdtDetail_detailPanel, new KDLayout.Constraints(20, 297, 967, 222, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtDetail_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("breedStage",new Integer(1));
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        contallocationType.setBounds(new Rectangle(711, 53, 270, 19));
        this.add(contallocationType, new KDLayout.Constraints(711, 53, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfarmGroup.setBounds(new Rectangle(20, 87, 270, 19));
        this.add(contfarmGroup, new KDLayout.Constraints(20, 87, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmerGroup.setBounds(new Rectangle(20, 87, 270, 19));
        this.add(contfarmerGroup, new KDLayout.Constraints(20, 87, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contfarmer
        contfarmer.setBoundEditor(prmtfarmer);
        //contfarm
        contfarm.setBoundEditor(prmtfarm);
        //contperiod
        contperiod.setBoundEditor(prmtperiod);
        //contallocationType
        contallocationType.setBoundEditor(allocationType);
        //contfarmGroup
        contfarmGroup.setBoundEditor(prmtfarmGroup);
        //contfarmerGroup
        contfarmerGroup.setBoundEditor(prmtfarmerGroup);

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
        menuBiz.add(mBtnExeAllocation);
        menuBiz.add(newSeparator3);
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
        this.toolBar.add(tBtnAudit);
        this.toolBar.add(tBtnUnAudit);
        this.toolBar.add(tBtnExeAllocation);
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
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.dayratecost.CostAllocationEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.amount", java.math.BigDecimal.class, this.kdtEntrys, "amount.text");
		dataBinder.registerBinding("entrys.remark", String.class, this.kdtEntrys, "remark.text");
		dataBinder.registerBinding("entrys.feeItem", java.lang.Object.class, this.kdtEntrys, "feeItem.text");
		dataBinder.registerBinding("entrys.Detail.seq", int.class, this.kdtDetail, "seq.text");
		dataBinder.registerBinding("entrys.Detail", com.kingdee.eas.farm.dayratecost.CostAllocationEntryDetailInfo.class, this.kdtDetail, "userObject");
		dataBinder.registerBinding("entrys.Detail.house", java.lang.Object.class, this.kdtDetail, "house.text");
		dataBinder.registerBinding("entrys.Detail.stockingBatch", java.lang.Object.class, this.kdtDetail, "stockingBatch.text");
		dataBinder.registerBinding("entrys.Detail.farmer", java.lang.Object.class, this.kdtDetail, "farmer.text");
		dataBinder.registerBinding("entrys.Detail.farm", java.lang.Object.class, this.kdtDetail, "farm.text");
		dataBinder.registerBinding("entrys.Detail.matureDate", java.util.Date.class, this.kdtDetail, "matureDate.text");
		dataBinder.registerBinding("entrys.Detail.matureprop", java.math.BigDecimal.class, this.kdtDetail, "matureprop.text");
		dataBinder.registerBinding("entrys.Detail.matureAmount", java.math.BigDecimal.class, this.kdtDetail, "matureAmount.text");
		dataBinder.registerBinding("entrys.Detail.alloctionAmount", java.math.BigDecimal.class, this.kdtDetail, "alloctionAmount.text");
		dataBinder.registerBinding("entrys.Detail.proportion", java.math.BigDecimal.class, this.kdtDetail, "proportion.text");
		dataBinder.registerBinding("entrys.Detail.amount", java.math.BigDecimal.class, this.kdtDetail, "amount.text");
		dataBinder.registerBinding("entrys.Detail.breedStage", com.kingdee.util.enums.Enum.class, this.kdtDetail, "breedStage.text");
		dataBinder.registerBinding("entrys.Detail.lastStock", int.class, this.kdtDetail, "lastStock.text");
		dataBinder.registerBinding("entrys.Detail.allLastStock", int.class, this.kdtDetail, "allLastStock.text");
		dataBinder.registerBinding("entrys.Detail.matureQty", int.class, this.kdtDetail, "matureQty.text");
		dataBinder.registerBinding("entrys.Detail.proportion2", java.math.BigDecimal.class, this.kdtDetail, "proportion2.text");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("farmer", com.kingdee.eas.farm.stocking.basedata.FarmersInfo.class, this.prmtfarmer, "data");
		dataBinder.registerBinding("farm", com.kingdee.eas.farm.stocking.basedata.FarmInfo.class, this.prmtfarm, "data");
		dataBinder.registerBinding("period", com.kingdee.eas.basedata.assistant.PeriodInfo.class, this.prmtperiod, "data");
		dataBinder.registerBinding("allocationType", com.kingdee.eas.farm.dayratecost.AllocationTypeEnum.class, this.allocationType, "selectedItem");
		dataBinder.registerBinding("farmGroup", com.kingdee.eas.farm.stocking.basedata.FarmInfo.class, this.prmtfarmGroup, "data");
		dataBinder.registerBinding("farmerGroup", com.kingdee.eas.farm.stocking.basedata.FarmersInfo.class, this.prmtfarmerGroup, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.dayratecost.app.CostAllocationEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.dayratecost.CostAllocationInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.feeItem", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.house", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.stockingBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.matureDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.matureprop", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.matureAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.alloctionAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.proportion", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.breedStage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.lastStock", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.allLastStock", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.matureQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.proportion2", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("period", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allocationType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmGroup", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmerGroup", ValidateHelper.ON_SAVE);    		
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
    	sic.add(new SelectorItemInfo("entrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("entrys.amount"));
    	sic.add(new SelectorItemInfo("entrys.remark"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.feeItem.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.feeItem.id"));
			sic.add(new SelectorItemInfo("entrys.feeItem.name"));
        	sic.add(new SelectorItemInfo("entrys.feeItem.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.Detail.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.Detail.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.Detail.id"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.Detail.house.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.Detail.house.id"));
			sic.add(new SelectorItemInfo("entrys.Detail.house.name"));
        	sic.add(new SelectorItemInfo("entrys.Detail.house.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.Detail.stockingBatch.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.Detail.stockingBatch.id"));
			sic.add(new SelectorItemInfo("entrys.Detail.stockingBatch.number"));
			sic.add(new SelectorItemInfo("entrys.Detail.stockingBatch.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.Detail.farmer.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.Detail.farmer.id"));
			sic.add(new SelectorItemInfo("entrys.Detail.farmer.name"));
        	sic.add(new SelectorItemInfo("entrys.Detail.farmer.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.Detail.farm.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.Detail.farm.id"));
			sic.add(new SelectorItemInfo("entrys.Detail.farm.name"));
        	sic.add(new SelectorItemInfo("entrys.Detail.farm.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.Detail.matureDate"));
    	sic.add(new SelectorItemInfo("entrys.Detail.matureprop"));
    	sic.add(new SelectorItemInfo("entrys.Detail.matureAmount"));
    	sic.add(new SelectorItemInfo("entrys.Detail.alloctionAmount"));
    	sic.add(new SelectorItemInfo("entrys.Detail.proportion"));
    	sic.add(new SelectorItemInfo("entrys.Detail.amount"));
    	sic.add(new SelectorItemInfo("entrys.Detail.breedStage"));
    	sic.add(new SelectorItemInfo("entrys.Detail.lastStock"));
    	sic.add(new SelectorItemInfo("entrys.Detail.allLastStock"));
    	sic.add(new SelectorItemInfo("entrys.Detail.matureQty"));
    	sic.add(new SelectorItemInfo("entrys.Detail.proportion2"));
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
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
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
			sic.add(new SelectorItemInfo("period.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("period.id"));
        	sic.add(new SelectorItemInfo("period.number"));
		}
        sic.add(new SelectorItemInfo("allocationType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("farmGroup.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farmGroup.id"));
        	sic.add(new SelectorItemInfo("farmGroup.number"));
        	sic.add(new SelectorItemInfo("farmGroup.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("farmerGroup.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farmerGroup.id"));
        	sic.add(new SelectorItemInfo("farmerGroup.number"));
        	sic.add(new SelectorItemInfo("farmerGroup.name"));
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
        com.kingdee.eas.farm.dayratecost.CostAllocationFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.dayratecost.CostAllocationFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionExeAllocation_actionPerformed method
     */
    public void actionExeAllocation_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.dayratecost.CostAllocationFactory.getRemoteInstance().exeAllocation(editData);
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
	public RequestContext prepareActionExeAllocation(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionExeAllocation() {
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
            innerActionPerformed("eas", AbstractCostAllocationEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractCostAllocationEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionExeAllocation class
     */     
    protected class ActionExeAllocation extends ItemAction {     
    
        public ActionExeAllocation()
        {
            this(null);
        }

        public ActionExeAllocation(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionExeAllocation.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionExeAllocation.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionExeAllocation.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCostAllocationEditUI.this, "ActionExeAllocation", "actionExeAllocation_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.dayratecost.client", "CostAllocationEditUI");
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
        return com.kingdee.eas.farm.dayratecost.client.CostAllocationEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.dayratecost.CostAllocationFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.dayratecost.CostAllocationInfo objectValue = new com.kingdee.eas.farm.dayratecost.CostAllocationInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/dayratecost/CostAllocation";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.dayratecost.app.CostAllocationQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"feeItem").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"费用项目"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"amount").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"金额"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtperiod.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"期间"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(allocationType.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"分摊方式"});
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
		vo.put("allocationType",new Integer(1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}