/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.recyclebiz.client;

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
public abstract class AbstractCKCostAllocateBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCKCostAllocateBillEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contFICompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperiod;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcostCenter;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtPeriodEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtPeriodEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtFICompany;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallAmount;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperiod;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcostCenter;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btncostAmt;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnExecAllocate;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillInfo editData = null;
    protected ActionExecAllocate actionExecAllocate = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionCostAmt actionCostAmt = null;
    /**
     * output class constructor
     */
    public AbstractCKCostAllocateBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCKCostAllocateBillEditUI.class.getName());
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
        //actionExecAllocate
        this.actionExecAllocate = new ActionExecAllocate(this);
        getActionManager().registerAction("actionExecAllocate", actionExecAllocate);
        this.actionExecAllocate.setExtendProperty("canForewarn", "true");
        this.actionExecAllocate.setExtendProperty("userDefined", "true");
        this.actionExecAllocate.setExtendProperty("isObjectUpdateLock", "false");
         this.actionExecAllocate.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionExecAllocate.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionAudit
        this.actionAudit = new ActionAudit(this);
        getActionManager().registerAction("actionAudit", actionAudit);
        this.actionAudit.setBindWorkFlow(true);
        this.actionAudit.setExtendProperty("canForewarn", "true");
        this.actionAudit.setExtendProperty("userDefined", "true");
        this.actionAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionUnAudit
        this.actionUnAudit = new ActionUnAudit(this);
        getActionManager().registerAction("actionUnAudit", actionUnAudit);
        this.actionUnAudit.setBindWorkFlow(true);
        this.actionUnAudit.setExtendProperty("canForewarn", "true");
        this.actionUnAudit.setExtendProperty("userDefined", "true");
        this.actionUnAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.WorkFlowService());
        //actionCostAmt
        this.actionCostAmt = new ActionCostAmt(this);
        getActionManager().registerAction("actionCostAmt", actionCostAmt);
        this.actionCostAmt.setExtendProperty("canForewarn", "true");
        this.actionCostAmt.setExtendProperty("userDefined", "true");
        this.actionCostAmt.setExtendProperty("isObjectUpdateLock", "false");
         this.actionCostAmt.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionCostAmt.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contFICompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperiod = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcostCenter = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtPeriodEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtFICompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtallAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtperiod = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtcostCenter = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.btncostAmt = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnExecAllocate = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.kdtEntrys.setName("kdtEntrys");
        this.contFICompany.setName("contFICompany");
        this.contallAmount.setName("contallAmount");
        this.contbillStatus.setName("contbillStatus");
        this.contperiod.setName("contperiod");
        this.contauditTime.setName("contauditTime");
        this.contcostCenter.setName("contcostCenter");
        this.kdtPeriodEntry.setName("kdtPeriodEntry");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtFICompany.setName("prmtFICompany");
        this.txtallAmount.setName("txtallAmount");
        this.billStatus.setName("billStatus");
        this.prmtperiod.setName("prmtperiod");
        this.pkauditTime.setName("pkauditTime");
        this.prmtcostCenter.setName("prmtcostCenter");
        this.btncostAmt.setName("btncostAmt");
        this.btnExecAllocate.setName("btnExecAllocate");
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
        // contDescription		
        this.contDescription.setBoundLabelText(resHelper.getString("contDescription.boundLabelText"));		
        this.contDescription.setBoundLabelLength(100);		
        this.contDescription.setBoundLabelUnderline(true);
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"farmer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"farm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"breeddata\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"batchContract\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"inQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"weight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"recWgt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{farmer}</t:Cell><t:Cell>$Resource{farm}</t:Cell><t:Cell>$Resource{breeddata}</t:Cell><t:Cell>$Resource{batchContract}</t:Cell><t:Cell>$Resource{inQty}</t:Cell><t:Cell>$Resource{weight}</t:Cell><t:Cell>$Resource{recWgt}</t:Cell><t:Cell>$Resource{amount}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));

                this.kdtEntrys.putBindContents("editData",new String[] {"id","farmer","farm","breeddata","batchContract","inQty","weight","recWgt","amount"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_farmer_PromptBox = new KDBizPromptBox();
        kdtEntrys_farmer_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerQuery");
        kdtEntrys_farmer_PromptBox.setVisible(true);
        kdtEntrys_farmer_PromptBox.setEditable(true);
        kdtEntrys_farmer_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_farmer_PromptBox.setEditFormat("$number$");
        kdtEntrys_farmer_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_farmer_CellEditor = new KDTDefaultCellEditor(kdtEntrys_farmer_PromptBox);
        this.kdtEntrys.getColumn("farmer").setEditor(kdtEntrys_farmer_CellEditor);
        ObjectValueRender kdtEntrys_farmer_OVR = new ObjectValueRender();
        kdtEntrys_farmer_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("farmer").setRenderer(kdtEntrys_farmer_OVR);
        			kdtEntrys_farmer_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.FarmerListUI kdtEntrys_farmer_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_farmer_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_farmer_PromptBox_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.FarmerListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_farmer_PromptBox_F7ListUI));
					kdtEntrys_farmer_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_farmer_PromptBox.setSelector(kdtEntrys_farmer_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEntrys_farm_PromptBox = new KDBizPromptBox();
        kdtEntrys_farm_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmQuery");
        kdtEntrys_farm_PromptBox.setVisible(true);
        kdtEntrys_farm_PromptBox.setEditable(true);
        kdtEntrys_farm_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_farm_PromptBox.setEditFormat("$number$");
        kdtEntrys_farm_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_farm_CellEditor = new KDTDefaultCellEditor(kdtEntrys_farm_PromptBox);
        this.kdtEntrys.getColumn("farm").setEditor(kdtEntrys_farm_CellEditor);
        ObjectValueRender kdtEntrys_farm_OVR = new ObjectValueRender();
        kdtEntrys_farm_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("farm").setRenderer(kdtEntrys_farm_OVR);
        			kdtEntrys_farm_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.FarmListUI kdtEntrys_farm_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_farm_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_farm_PromptBox_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.FarmListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_farm_PromptBox_F7ListUI));
					kdtEntrys_farm_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_farm_PromptBox.setSelector(kdtEntrys_farm_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEntrys_breeddata_PromptBox = new KDBizPromptBox();
        kdtEntrys_breeddata_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.BreedDataQuery");
        kdtEntrys_breeddata_PromptBox.setVisible(true);
        kdtEntrys_breeddata_PromptBox.setEditable(true);
        kdtEntrys_breeddata_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_breeddata_PromptBox.setEditFormat("$number$");
        kdtEntrys_breeddata_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_breeddata_CellEditor = new KDTDefaultCellEditor(kdtEntrys_breeddata_PromptBox);
        this.kdtEntrys.getColumn("breeddata").setEditor(kdtEntrys_breeddata_CellEditor);
        ObjectValueRender kdtEntrys_breeddata_OVR = new ObjectValueRender();
        kdtEntrys_breeddata_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("breeddata").setRenderer(kdtEntrys_breeddata_OVR);
        			kdtEntrys_breeddata_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI kdtEntrys_breeddata_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_breeddata_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_breeddata_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_breeddata_PromptBox_F7ListUI));
					kdtEntrys_breeddata_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_breeddata_PromptBox.setSelector(kdtEntrys_breeddata_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEntrys_batchContract_PromptBox = new KDBizPromptBox();
        kdtEntrys_batchContract_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.feedbiz.app.BatchContractBillQuery");
        kdtEntrys_batchContract_PromptBox.setVisible(true);
        kdtEntrys_batchContract_PromptBox.setEditable(true);
        kdtEntrys_batchContract_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_batchContract_PromptBox.setEditFormat("$number$");
        kdtEntrys_batchContract_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_batchContract_CellEditor = new KDTDefaultCellEditor(kdtEntrys_batchContract_PromptBox);
        this.kdtEntrys.getColumn("batchContract").setEditor(kdtEntrys_batchContract_CellEditor);
        ObjectValueRender kdtEntrys_batchContract_OVR = new ObjectValueRender();
        kdtEntrys_batchContract_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("batchContract").setRenderer(kdtEntrys_batchContract_OVR);
        KDFormattedTextField kdtEntrys_inQty_TextField = new KDFormattedTextField();
        kdtEntrys_inQty_TextField.setName("kdtEntrys_inQty_TextField");
        kdtEntrys_inQty_TextField.setVisible(true);
        kdtEntrys_inQty_TextField.setEditable(true);
        kdtEntrys_inQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_inQty_TextField.setDataType(1);
        	kdtEntrys_inQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_inQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_inQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_inQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_inQty_TextField);
        this.kdtEntrys.getColumn("inQty").setEditor(kdtEntrys_inQty_CellEditor);
        KDFormattedTextField kdtEntrys_weight_TextField = new KDFormattedTextField();
        kdtEntrys_weight_TextField.setName("kdtEntrys_weight_TextField");
        kdtEntrys_weight_TextField.setVisible(true);
        kdtEntrys_weight_TextField.setEditable(true);
        kdtEntrys_weight_TextField.setHorizontalAlignment(2);
        kdtEntrys_weight_TextField.setDataType(1);
        	kdtEntrys_weight_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_weight_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_weight_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_weight_CellEditor = new KDTDefaultCellEditor(kdtEntrys_weight_TextField);
        this.kdtEntrys.getColumn("weight").setEditor(kdtEntrys_weight_CellEditor);
        KDFormattedTextField kdtEntrys_recWgt_TextField = new KDFormattedTextField();
        kdtEntrys_recWgt_TextField.setName("kdtEntrys_recWgt_TextField");
        kdtEntrys_recWgt_TextField.setVisible(true);
        kdtEntrys_recWgt_TextField.setEditable(true);
        kdtEntrys_recWgt_TextField.setHorizontalAlignment(2);
        kdtEntrys_recWgt_TextField.setDataType(1);
        	kdtEntrys_recWgt_TextField.setMinimumValue(new java.math.BigDecimal("-9.999999999999999E22"));
        	kdtEntrys_recWgt_TextField.setMaximumValue(new java.math.BigDecimal("9.999999999999999E22"));
        kdtEntrys_recWgt_TextField.setPrecision(5);
        KDTDefaultCellEditor kdtEntrys_recWgt_CellEditor = new KDTDefaultCellEditor(kdtEntrys_recWgt_TextField);
        this.kdtEntrys.getColumn("recWgt").setEditor(kdtEntrys_recWgt_CellEditor);
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
        // contFICompany		
        this.contFICompany.setBoundLabelText(resHelper.getString("contFICompany.boundLabelText"));		
        this.contFICompany.setBoundLabelLength(100);		
        this.contFICompany.setBoundLabelUnderline(true);		
        this.contFICompany.setVisible(true);
        // contallAmount		
        this.contallAmount.setBoundLabelText(resHelper.getString("contallAmount.boundLabelText"));		
        this.contallAmount.setBoundLabelLength(100);		
        this.contallAmount.setBoundLabelUnderline(true);		
        this.contallAmount.setVisible(false);
        // contbillStatus		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);
        // contperiod		
        this.contperiod.setBoundLabelText(resHelper.getString("contperiod.boundLabelText"));		
        this.contperiod.setBoundLabelLength(100);		
        this.contperiod.setBoundLabelUnderline(true);		
        this.contperiod.setVisible(true);
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // contcostCenter		
        this.contcostCenter.setBoundLabelText(resHelper.getString("contcostCenter.boundLabelText"));		
        this.contcostCenter.setBoundLabelLength(100);		
        this.contcostCenter.setBoundLabelUnderline(true);		
        this.contcostCenter.setVisible(false);
        // kdtPeriodEntry
		String kdtPeriodEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"costCenter\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"accountView\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"accountName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"restCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"currentCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"endingBanace\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{costCenter}</t:Cell><t:Cell>$Resource{accountView}</t:Cell><t:Cell>$Resource{accountName}</t:Cell><t:Cell>$Resource{restCost}</t:Cell><t:Cell>$Resource{currentCost}</t:Cell><t:Cell>$Resource{endingBanace}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtPeriodEntry.setFormatXml(resHelper.translateString("kdtPeriodEntry",kdtPeriodEntryStrXML));
        kdtPeriodEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtPeriodEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtPeriodEntry.putBindContents("editData",new String[] {"seq","costCenter","accountView","accountName","restCost","currentCost","endingBanace"});


        this.kdtPeriodEntry.checkParsed();
        KDFormattedTextField kdtPeriodEntry_seq_TextField = new KDFormattedTextField();
        kdtPeriodEntry_seq_TextField.setName("kdtPeriodEntry_seq_TextField");
        kdtPeriodEntry_seq_TextField.setVisible(true);
        kdtPeriodEntry_seq_TextField.setEditable(true);
        kdtPeriodEntry_seq_TextField.setHorizontalAlignment(2);
        kdtPeriodEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtPeriodEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtPeriodEntry_seq_TextField);
        this.kdtPeriodEntry.getColumn("seq").setEditor(kdtPeriodEntry_seq_CellEditor);
        final KDBizPromptBox kdtPeriodEntry_costCenter_PromptBox = new KDBizPromptBox();
        kdtPeriodEntry_costCenter_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.CostCenterItemQuery");
        kdtPeriodEntry_costCenter_PromptBox.setVisible(true);
        kdtPeriodEntry_costCenter_PromptBox.setEditable(true);
        kdtPeriodEntry_costCenter_PromptBox.setDisplayFormat("$number$");
        kdtPeriodEntry_costCenter_PromptBox.setEditFormat("$number$");
        kdtPeriodEntry_costCenter_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtPeriodEntry_costCenter_CellEditor = new KDTDefaultCellEditor(kdtPeriodEntry_costCenter_PromptBox);
        this.kdtPeriodEntry.getColumn("costCenter").setEditor(kdtPeriodEntry_costCenter_CellEditor);
        ObjectValueRender kdtPeriodEntry_costCenter_OVR = new ObjectValueRender();
        kdtPeriodEntry_costCenter_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtPeriodEntry.getColumn("costCenter").setRenderer(kdtPeriodEntry_costCenter_OVR);
        final KDBizPromptBox kdtPeriodEntry_accountView_PromptBox = new KDBizPromptBox();
        kdtPeriodEntry_accountView_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.account.app.F7AccountViewQuery");
        kdtPeriodEntry_accountView_PromptBox.setVisible(true);
        kdtPeriodEntry_accountView_PromptBox.setEditable(true);
        kdtPeriodEntry_accountView_PromptBox.setDisplayFormat("$number$");
        kdtPeriodEntry_accountView_PromptBox.setEditFormat("$number$");
        kdtPeriodEntry_accountView_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtPeriodEntry_accountView_CellEditor = new KDTDefaultCellEditor(kdtPeriodEntry_accountView_PromptBox);
        this.kdtPeriodEntry.getColumn("accountView").setEditor(kdtPeriodEntry_accountView_CellEditor);
        ObjectValueRender kdtPeriodEntry_accountView_OVR = new ObjectValueRender();
        kdtPeriodEntry_accountView_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtPeriodEntry.getColumn("accountView").setRenderer(kdtPeriodEntry_accountView_OVR);
        KDTextField kdtPeriodEntry_accountName_TextField = new KDTextField();
        kdtPeriodEntry_accountName_TextField.setName("kdtPeriodEntry_accountName_TextField");
        kdtPeriodEntry_accountName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtPeriodEntry_accountName_CellEditor = new KDTDefaultCellEditor(kdtPeriodEntry_accountName_TextField);
        this.kdtPeriodEntry.getColumn("accountName").setEditor(kdtPeriodEntry_accountName_CellEditor);
        KDFormattedTextField kdtPeriodEntry_restCost_TextField = new KDFormattedTextField();
        kdtPeriodEntry_restCost_TextField.setName("kdtPeriodEntry_restCost_TextField");
        kdtPeriodEntry_restCost_TextField.setVisible(true);
        kdtPeriodEntry_restCost_TextField.setEditable(true);
        kdtPeriodEntry_restCost_TextField.setHorizontalAlignment(2);
        kdtPeriodEntry_restCost_TextField.setDataType(1);
        	kdtPeriodEntry_restCost_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPeriodEntry_restCost_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPeriodEntry_restCost_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPeriodEntry_restCost_CellEditor = new KDTDefaultCellEditor(kdtPeriodEntry_restCost_TextField);
        this.kdtPeriodEntry.getColumn("restCost").setEditor(kdtPeriodEntry_restCost_CellEditor);
        KDFormattedTextField kdtPeriodEntry_currentCost_TextField = new KDFormattedTextField();
        kdtPeriodEntry_currentCost_TextField.setName("kdtPeriodEntry_currentCost_TextField");
        kdtPeriodEntry_currentCost_TextField.setVisible(true);
        kdtPeriodEntry_currentCost_TextField.setEditable(true);
        kdtPeriodEntry_currentCost_TextField.setHorizontalAlignment(2);
        kdtPeriodEntry_currentCost_TextField.setDataType(1);
        	kdtPeriodEntry_currentCost_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPeriodEntry_currentCost_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPeriodEntry_currentCost_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPeriodEntry_currentCost_CellEditor = new KDTDefaultCellEditor(kdtPeriodEntry_currentCost_TextField);
        this.kdtPeriodEntry.getColumn("currentCost").setEditor(kdtPeriodEntry_currentCost_CellEditor);
        KDFormattedTextField kdtPeriodEntry_endingBanace_TextField = new KDFormattedTextField();
        kdtPeriodEntry_endingBanace_TextField.setName("kdtPeriodEntry_endingBanace_TextField");
        kdtPeriodEntry_endingBanace_TextField.setVisible(true);
        kdtPeriodEntry_endingBanace_TextField.setEditable(true);
        kdtPeriodEntry_endingBanace_TextField.setHorizontalAlignment(2);
        kdtPeriodEntry_endingBanace_TextField.setDataType(1);
        	kdtPeriodEntry_endingBanace_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPeriodEntry_endingBanace_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPeriodEntry_endingBanace_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPeriodEntry_endingBanace_CellEditor = new KDTDefaultCellEditor(kdtPeriodEntry_endingBanace_TextField);
        this.kdtPeriodEntry.getColumn("endingBanace").setEditor(kdtPeriodEntry_endingBanace_CellEditor);
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
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // prmtFICompany		
        this.prmtFICompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery4AsstAcct");		
        this.prmtFICompany.setEditable(true);		
        this.prmtFICompany.setDisplayFormat("$name$");		
        this.prmtFICompany.setEditFormat("$number$");		
        this.prmtFICompany.setCommitFormat("$number$");		
        this.prmtFICompany.setRequired(true);
        		setOrgF7(prmtFICompany,com.kingdee.eas.basedata.org.OrgType.getEnum("Company"));
					
        // txtallAmount		
        this.txtallAmount.setHorizontalAlignment(2);		
        this.txtallAmount.setDataType(1);		
        this.txtallAmount.setSupportedEmpty(true);		
        this.txtallAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallAmount.setPrecision(2);		
        this.txtallAmount.setRequired(false);		
        this.txtallAmount.setVisible(false);
        // billStatus		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // prmtperiod		
        this.prmtperiod.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7PeriodQuery");		
        this.prmtperiod.setEditable(true);		
        this.prmtperiod.setDisplayFormat("$number$");		
        this.prmtperiod.setEditFormat("$number$");		
        this.prmtperiod.setCommitFormat("$number$");		
        this.prmtperiod.setRequired(true);
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // prmtcostCenter		
        this.prmtcostCenter.setQueryInfo("com.kingdee.eas.basedata.org.app.CostCenterItemQuery");		
        this.prmtcostCenter.setEditable(true);		
        this.prmtcostCenter.setDisplayFormat("$name$");		
        this.prmtcostCenter.setEditFormat("$number$");		
        this.prmtcostCenter.setCommitFormat("$number$");		
        this.prmtcostCenter.setRequired(false);		
        this.prmtcostCenter.setVisible(false);
        // btncostAmt
        this.btncostAmt.setAction((IItemAction)ActionProxyFactory.getProxy(actionCostAmt, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btncostAmt.setText(resHelper.getString("btncostAmt.text"));
        // btnExecAllocate
        this.btnExecAllocate.setAction((IItemAction)ActionProxyFactory.getProxy(actionExecAllocate, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnExecAllocate.setText(resHelper.getString("btnExecAllocate.text"));		
        this.btnExecAllocate.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_manualcount"));
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtFICompany,txtNumber,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,txtallAmount,billStatus,prmtperiod,pkauditTime,prmtcostCenter,kdtEntrys,kdtPeriodEntry}));
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
        contCreator.setBounds(new Rectangle(384, 572, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(384, 572, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(719, 572, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(719, 572, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(384, 598, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(384, 598, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(719, 598, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(719, 598, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(20, 15, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(20, 15, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(349, 40, 272, 19));
        this.add(contDescription, new KDLayout.Constraints(349, 40, 272, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(11, 572, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(11, 572, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(12, 336, 981, 226));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(12, 336, 981, 226, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contFICompany.setBounds(new Rectangle(349, 15, 270, 19));
        this.add(contFICompany, new KDLayout.Constraints(349, 15, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contallAmount.setBounds(new Rectangle(355, 2, 270, 19));
        this.add(contallAmount, new KDLayout.Constraints(355, 2, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(680, 15, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(680, 15, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contperiod.setBounds(new Rectangle(20, 40, 270, 19));
        this.add(contperiod, new KDLayout.Constraints(20, 40, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(11, 598, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(11, 598, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcostCenter.setBounds(new Rectangle(686, 2, 270, 19));
        this.add(contcostCenter, new KDLayout.Constraints(686, 2, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kdtPeriodEntry.setBounds(new Rectangle(12, 72, 977, 250));
        kdtPeriodEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtPeriodEntry,new com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillPeriodEntryInfo(),null,false);
        this.add(kdtPeriodEntry_detailPanel, new KDLayout.Constraints(12, 72, 977, 250, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //contDescription
        contDescription.setBoundEditor(txtDescription);
        //contAuditor
        contAuditor.setBoundEditor(prmtAuditor);
        //contFICompany
        contFICompany.setBoundEditor(prmtFICompany);
        //contallAmount
        contallAmount.setBoundEditor(txtallAmount);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //contperiod
        contperiod.setBoundEditor(prmtperiod);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contcostCenter
        contcostCenter.setBoundEditor(prmtcostCenter);

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
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);
        this.toolBar.add(btnAttachment);
        this.toolBar.add(separatorFW1);
        this.toolBar.add(btnPageSetup);
        this.toolBar.add(btncostAmt);
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
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnDelPCVoucher);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(btnNextPerson);
        this.toolBar.add(btnExecAllocate);
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.farmer", java.lang.Object.class, this.kdtEntrys, "farmer.text");
		dataBinder.registerBinding("entrys.farm", java.lang.Object.class, this.kdtEntrys, "farm.text");
		dataBinder.registerBinding("entrys.batchContract", java.lang.Object.class, this.kdtEntrys, "batchContract.text");
		dataBinder.registerBinding("entrys.amount", java.math.BigDecimal.class, this.kdtEntrys, "amount.text");
		dataBinder.registerBinding("entrys.weight", java.math.BigDecimal.class, this.kdtEntrys, "weight.text");
		dataBinder.registerBinding("entrys.breeddata", java.lang.Object.class, this.kdtEntrys, "breeddata.text");
		dataBinder.registerBinding("entrys.recWgt", java.math.BigDecimal.class, this.kdtEntrys, "recWgt.text");
		dataBinder.registerBinding("entrys.inQty", java.math.BigDecimal.class, this.kdtEntrys, "inQty.text");
		dataBinder.registerBinding("PeriodEntry.seq", int.class, this.kdtPeriodEntry, "seq.text");
		dataBinder.registerBinding("PeriodEntry", com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillPeriodEntryInfo.class, this.kdtPeriodEntry, "userObject");
		dataBinder.registerBinding("PeriodEntry.costCenter", java.lang.Object.class, this.kdtPeriodEntry, "costCenter.text");
		dataBinder.registerBinding("PeriodEntry.accountView", java.lang.Object.class, this.kdtPeriodEntry, "accountView.text");
		dataBinder.registerBinding("PeriodEntry.accountName", String.class, this.kdtPeriodEntry, "accountName.text");
		dataBinder.registerBinding("PeriodEntry.restCost", java.math.BigDecimal.class, this.kdtPeriodEntry, "restCost.text");
		dataBinder.registerBinding("PeriodEntry.currentCost", java.math.BigDecimal.class, this.kdtPeriodEntry, "currentCost.text");
		dataBinder.registerBinding("PeriodEntry.endingBanace", java.math.BigDecimal.class, this.kdtPeriodEntry, "endingBanace.text");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("FICompany", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtFICompany, "data");
		dataBinder.registerBinding("allAmount", java.math.BigDecimal.class, this.txtallAmount, "value");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("period", com.kingdee.eas.basedata.assistant.PeriodInfo.class, this.prmtperiod, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("costCenter", com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo.class, this.prmtcostCenter, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.carnivorous.recyclebiz.app.CKCostAllocateBillEditUIHandler";
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
        this.prmtFICompany.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillInfo)ov;
    }
    protected void removeByPK(IObjectPK pk) throws Exception {
    	IObjectValue editData = this.editData;
    	super.removeByPK(pk);
    	recycleNumberByOrg(editData,"Company",editData.getString("number"));
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
			return com.kingdee.eas.basedata.org.OrgType.getEnum("Company");
		}

	protected KDBizPromptBox getMainBizOrg() {
		return prmtFICompany;
}


    /**
     * output loadFields method
     */
    public void loadFields()
    {
        		setAutoNumberByOrg("Company");
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
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.batchContract", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.weight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.breeddata", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.recWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.inQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PeriodEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PeriodEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PeriodEntry.costCenter", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PeriodEntry.accountView", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PeriodEntry.accountName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PeriodEntry.restCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PeriodEntry.currentCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PeriodEntry.endingBanace", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FICompany", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("period", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("costCenter", ValidateHelper.ON_SAVE);    		
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
     * output kdtPeriodEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtPeriodEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("accountView".equalsIgnoreCase(kdtPeriodEntry.getColumn(colIndex).getKey())) {
kdtPeriodEntry.getCell(rowIndex,"accountName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtPeriodEntry.getCell(rowIndex,"accountView").getValue(),"name")));

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
			sic.add(new SelectorItemInfo("entrys.farmer.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.farmer.id"));
			sic.add(new SelectorItemInfo("entrys.farmer.name"));
        	sic.add(new SelectorItemInfo("entrys.farmer.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.farm.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.farm.id"));
			sic.add(new SelectorItemInfo("entrys.farm.name"));
        	sic.add(new SelectorItemInfo("entrys.farm.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.batchContract.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.batchContract.id"));
			sic.add(new SelectorItemInfo("entrys.batchContract.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.amount"));
    	sic.add(new SelectorItemInfo("entrys.weight"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.breeddata.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.breeddata.id"));
			sic.add(new SelectorItemInfo("entrys.breeddata.name"));
        	sic.add(new SelectorItemInfo("entrys.breeddata.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.recWgt"));
    	sic.add(new SelectorItemInfo("entrys.inQty"));
    	sic.add(new SelectorItemInfo("PeriodEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("PeriodEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("PeriodEntry.costCenter.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("PeriodEntry.costCenter.id"));
			sic.add(new SelectorItemInfo("PeriodEntry.costCenter.name"));
        	sic.add(new SelectorItemInfo("PeriodEntry.costCenter.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("PeriodEntry.accountView.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("PeriodEntry.accountView.id"));
			sic.add(new SelectorItemInfo("PeriodEntry.accountView.number"));
			sic.add(new SelectorItemInfo("PeriodEntry.accountView.name"));
		}
    	sic.add(new SelectorItemInfo("PeriodEntry.accountName"));
    	sic.add(new SelectorItemInfo("PeriodEntry.restCost"));
    	sic.add(new SelectorItemInfo("PeriodEntry.currentCost"));
    	sic.add(new SelectorItemInfo("PeriodEntry.endingBanace"));
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
			sic.add(new SelectorItemInfo("FICompany.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("FICompany.id"));
        	sic.add(new SelectorItemInfo("FICompany.number"));
        	sic.add(new SelectorItemInfo("FICompany.name"));
		}
        sic.add(new SelectorItemInfo("allAmount"));
        sic.add(new SelectorItemInfo("billStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("period.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("period.id"));
        	sic.add(new SelectorItemInfo("period.number"));
		}
        sic.add(new SelectorItemInfo("auditTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("costCenter.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("costCenter.id"));
        	sic.add(new SelectorItemInfo("costCenter.number"));
        	sic.add(new SelectorItemInfo("costCenter.name"));
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
     * output actionExecAllocate_actionPerformed method
     */
    public void actionExecAllocate_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillFactory.getRemoteInstance().execAllocate(editData);
    }
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionCostAmt_actionPerformed method
     */
    public void actionCostAmt_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillFactory.getRemoteInstance().costAmt(editData);
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
	public RequestContext prepareActionExecAllocate(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionExecAllocate() {
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
	public RequestContext prepareActionCostAmt(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionCostAmt() {
    	return false;
    }

    /**
     * output ActionExecAllocate class
     */     
    protected class ActionExecAllocate extends ItemAction {     
    
        public ActionExecAllocate()
        {
            this(null);
        }

        public ActionExecAllocate(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionExecAllocate.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionExecAllocate.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionExecAllocate.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCKCostAllocateBillEditUI.this, "ActionExecAllocate", "actionExecAllocate_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractCKCostAllocateBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractCKCostAllocateBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionCostAmt class
     */     
    protected class ActionCostAmt extends ItemAction {     
    
        public ActionCostAmt()
        {
            this(null);
        }

        public ActionCostAmt(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionCostAmt.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCostAmt.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCostAmt.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCKCostAllocateBillEditUI.this, "ActionCostAmt", "actionCostAmt_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.recyclebiz.client", "CKCostAllocateBillEditUI");
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
        return com.kingdee.eas.farm.carnivorous.recyclebiz.client.CKCostAllocateBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillInfo();
				if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")).getBoolean("isBizUnit"))
			objectValue.put("FICompany",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")));
 
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/carnivorous/recyclebiz/CKCostAllocateBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.carnivorous.recyclebiz.app.CKCostAllocateBillQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtperiod.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"ÆÚ¼ä"});
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
				protected void setTableToSumField() {
			setTableToSumField(kdtEntrys,new String[] {"recWgt"});
			setTableToSumField(kdtPeriodEntry,new String[] {"restCost","currentCost","endingBanace"});
		}


}