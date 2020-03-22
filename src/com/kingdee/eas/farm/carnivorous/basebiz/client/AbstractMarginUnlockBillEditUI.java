/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basebiz.client;

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
public abstract class AbstractMarginUnlockBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractMarginUnlockBillEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contFICompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalMargin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoccupyMargin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contenableMargin;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisFromSettleBill;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtFICompany;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmer;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalMargin;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoccupyMargin;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtenableMargin;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.farm.carnivorous.basebiz.MarginUnlockBillInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractMarginUnlockBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractMarginUnlockBillEditUI.class.getName());
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
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contFICompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalMargin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoccupyMargin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contenableMargin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisFromSettleBill = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtFICompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtfarmer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txttotalMargin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtoccupyMargin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtenableMargin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
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
        this.contFICompany.setName("contFICompany");
        this.contbillStatus.setName("contbillStatus");
        this.contfarmer.setName("contfarmer");
        this.contauditTime.setName("contauditTime");
        this.conttotalMargin.setName("conttotalMargin");
        this.contoccupyMargin.setName("contoccupyMargin");
        this.contenableMargin.setName("contenableMargin");
        this.chkisFromSettleBill.setName("chkisFromSettleBill");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtFICompany.setName("prmtFICompany");
        this.billStatus.setName("billStatus");
        this.prmtfarmer.setName("prmtfarmer");
        this.pkauditTime.setName("pkauditTime");
        this.txttotalMargin.setName("txttotalMargin");
        this.txtoccupyMargin.setName("txtoccupyMargin");
        this.txtenableMargin.setName("txtenableMargin");
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
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"0\" t:styleID=\"sCol0\" /><t:Column t:key=\"batchContract\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"1\" /><t:Column t:key=\"farm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"2\" t:styleID=\"sCol2\" /><t:Column t:key=\"stockingBatch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"3\" t:styleID=\"sCol3\" /><t:Column t:key=\"breedData\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" t:styleID=\"sCol4\" /><t:Column t:key=\"actualInDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" t:styleID=\"sCol5\" /><t:Column t:key=\"batchQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"6\" t:styleID=\"sCol6\" /><t:Column t:key=\"mMargin\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"7\" t:styleID=\"sCol7\" /><t:Column t:key=\"sMargin\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" t:styleID=\"sCol8\" /><t:Column t:key=\"actualUsedMargin\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"9\" t:styleID=\"sCol9\" /><t:Column t:key=\"restSingleMargin\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"10\" t:styleID=\"sCol10\" /><t:Column t:key=\"isUnlockInit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"11\" /><t:Column t:key=\"initOccupyMargin\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"12\" t:styleID=\"sCol12\" /><t:Column t:key=\"unLockedOpMargin\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"13\" t:styleID=\"sCol13\" /><t:Column t:key=\"enableOccupyMargin\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"14\" t:styleID=\"sCol14\" /><t:Column t:key=\"unlockAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"15\" t:styleID=\"sCol15\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"16\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{batchContract}</t:Cell><t:Cell>$Resource{farm}</t:Cell><t:Cell>$Resource{stockingBatch}</t:Cell><t:Cell>$Resource{breedData}</t:Cell><t:Cell>$Resource{actualInDate}</t:Cell><t:Cell>$Resource{batchQty}</t:Cell><t:Cell>$Resource{mMargin}</t:Cell><t:Cell>$Resource{sMargin}</t:Cell><t:Cell>$Resource{actualUsedMargin}</t:Cell><t:Cell>$Resource{restSingleMargin}</t:Cell><t:Cell>$Resource{isUnlockInit}</t:Cell><t:Cell>$Resource{initOccupyMargin}</t:Cell><t:Cell>$Resource{unLockedOpMargin}</t:Cell><t:Cell>$Resource{enableOccupyMargin}</t:Cell><t:Cell>$Resource{unlockAmt}</t:Cell><t:Cell>$Resource{remark}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtEntrys.putBindContents("editData",new String[] {"id","batchContract","farm","stockingBatch","breedData","actualInDate","batchQty","mMargin","sMargin","actualUsedMargin","restSingleMargin","isUnlockInit","initOccupyMargin","unLockedOpMargin","enableOccupyMargin","unlockAmt","remark"});


        this.kdtEntrys.checkParsed();
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
					
        final KDBizPromptBox kdtEntrys_stockingBatch_PromptBox = new KDBizPromptBox();
        kdtEntrys_stockingBatch_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.BatchQuery");
        kdtEntrys_stockingBatch_PromptBox.setVisible(true);
        kdtEntrys_stockingBatch_PromptBox.setEditable(true);
        kdtEntrys_stockingBatch_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_stockingBatch_PromptBox.setEditFormat("$number$");
        kdtEntrys_stockingBatch_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_stockingBatch_CellEditor = new KDTDefaultCellEditor(kdtEntrys_stockingBatch_PromptBox);
        this.kdtEntrys.getColumn("stockingBatch").setEditor(kdtEntrys_stockingBatch_CellEditor);
        ObjectValueRender kdtEntrys_stockingBatch_OVR = new ObjectValueRender();
        kdtEntrys_stockingBatch_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("stockingBatch").setRenderer(kdtEntrys_stockingBatch_OVR);
        			kdtEntrys_stockingBatch_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.BatchListUI kdtEntrys_stockingBatch_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_stockingBatch_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_stockingBatch_PromptBox_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.BatchListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_stockingBatch_PromptBox_F7ListUI));
					kdtEntrys_stockingBatch_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_stockingBatch_PromptBox.setSelector(kdtEntrys_stockingBatch_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEntrys_breedData_PromptBox = new KDBizPromptBox();
        kdtEntrys_breedData_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.BreedDataQuery");
        kdtEntrys_breedData_PromptBox.setVisible(true);
        kdtEntrys_breedData_PromptBox.setEditable(true);
        kdtEntrys_breedData_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_breedData_PromptBox.setEditFormat("$number$");
        kdtEntrys_breedData_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_breedData_CellEditor = new KDTDefaultCellEditor(kdtEntrys_breedData_PromptBox);
        this.kdtEntrys.getColumn("breedData").setEditor(kdtEntrys_breedData_CellEditor);
        ObjectValueRender kdtEntrys_breedData_OVR = new ObjectValueRender();
        kdtEntrys_breedData_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("breedData").setRenderer(kdtEntrys_breedData_OVR);
        			kdtEntrys_breedData_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI kdtEntrys_breedData_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_breedData_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_breedData_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_breedData_PromptBox_F7ListUI));
					kdtEntrys_breedData_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_breedData_PromptBox.setSelector(kdtEntrys_breedData_PromptBox_F7ListUI);
				}
			}
		});
					
        KDDatePicker kdtEntrys_actualInDate_DatePicker = new KDDatePicker();
        kdtEntrys_actualInDate_DatePicker.setName("kdtEntrys_actualInDate_DatePicker");
        kdtEntrys_actualInDate_DatePicker.setVisible(true);
        kdtEntrys_actualInDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_actualInDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_actualInDate_DatePicker);
        this.kdtEntrys.getColumn("actualInDate").setEditor(kdtEntrys_actualInDate_CellEditor);
        KDFormattedTextField kdtEntrys_batchQty_TextField = new KDFormattedTextField();
        kdtEntrys_batchQty_TextField.setName("kdtEntrys_batchQty_TextField");
        kdtEntrys_batchQty_TextField.setVisible(true);
        kdtEntrys_batchQty_TextField.setEditable(true);
        kdtEntrys_batchQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_batchQty_TextField.setDataType(1);
        	kdtEntrys_batchQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_batchQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_batchQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_batchQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_batchQty_TextField);
        this.kdtEntrys.getColumn("batchQty").setEditor(kdtEntrys_batchQty_CellEditor);
        KDFormattedTextField kdtEntrys_mMargin_TextField = new KDFormattedTextField();
        kdtEntrys_mMargin_TextField.setName("kdtEntrys_mMargin_TextField");
        kdtEntrys_mMargin_TextField.setVisible(true);
        kdtEntrys_mMargin_TextField.setEditable(true);
        kdtEntrys_mMargin_TextField.setHorizontalAlignment(2);
        kdtEntrys_mMargin_TextField.setDataType(1);
        	kdtEntrys_mMargin_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_mMargin_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_mMargin_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_mMargin_CellEditor = new KDTDefaultCellEditor(kdtEntrys_mMargin_TextField);
        this.kdtEntrys.getColumn("mMargin").setEditor(kdtEntrys_mMargin_CellEditor);
        KDFormattedTextField kdtEntrys_sMargin_TextField = new KDFormattedTextField();
        kdtEntrys_sMargin_TextField.setName("kdtEntrys_sMargin_TextField");
        kdtEntrys_sMargin_TextField.setVisible(true);
        kdtEntrys_sMargin_TextField.setEditable(true);
        kdtEntrys_sMargin_TextField.setHorizontalAlignment(2);
        kdtEntrys_sMargin_TextField.setDataType(1);
        	kdtEntrys_sMargin_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_sMargin_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_sMargin_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_sMargin_CellEditor = new KDTDefaultCellEditor(kdtEntrys_sMargin_TextField);
        this.kdtEntrys.getColumn("sMargin").setEditor(kdtEntrys_sMargin_CellEditor);
        KDFormattedTextField kdtEntrys_actualUsedMargin_TextField = new KDFormattedTextField();
        kdtEntrys_actualUsedMargin_TextField.setName("kdtEntrys_actualUsedMargin_TextField");
        kdtEntrys_actualUsedMargin_TextField.setVisible(true);
        kdtEntrys_actualUsedMargin_TextField.setEditable(true);
        kdtEntrys_actualUsedMargin_TextField.setHorizontalAlignment(2);
        kdtEntrys_actualUsedMargin_TextField.setDataType(1);
        	kdtEntrys_actualUsedMargin_TextField.setMinimumValue(new java.math.BigDecimal("-3.4028234663852886E38"));
        	kdtEntrys_actualUsedMargin_TextField.setMaximumValue(new java.math.BigDecimal("3.4028234663852886E38"));
        kdtEntrys_actualUsedMargin_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_actualUsedMargin_CellEditor = new KDTDefaultCellEditor(kdtEntrys_actualUsedMargin_TextField);
        this.kdtEntrys.getColumn("actualUsedMargin").setEditor(kdtEntrys_actualUsedMargin_CellEditor);
        KDFormattedTextField kdtEntrys_restSingleMargin_TextField = new KDFormattedTextField();
        kdtEntrys_restSingleMargin_TextField.setName("kdtEntrys_restSingleMargin_TextField");
        kdtEntrys_restSingleMargin_TextField.setVisible(true);
        kdtEntrys_restSingleMargin_TextField.setEditable(true);
        kdtEntrys_restSingleMargin_TextField.setHorizontalAlignment(2);
        kdtEntrys_restSingleMargin_TextField.setDataType(1);
        	kdtEntrys_restSingleMargin_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_restSingleMargin_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_restSingleMargin_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_restSingleMargin_CellEditor = new KDTDefaultCellEditor(kdtEntrys_restSingleMargin_TextField);
        this.kdtEntrys.getColumn("restSingleMargin").setEditor(kdtEntrys_restSingleMargin_CellEditor);
        KDCheckBox kdtEntrys_isUnlockInit_CheckBox = new KDCheckBox();
        kdtEntrys_isUnlockInit_CheckBox.setName("kdtEntrys_isUnlockInit_CheckBox");
        KDTDefaultCellEditor kdtEntrys_isUnlockInit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_isUnlockInit_CheckBox);
        this.kdtEntrys.getColumn("isUnlockInit").setEditor(kdtEntrys_isUnlockInit_CellEditor);
        KDFormattedTextField kdtEntrys_initOccupyMargin_TextField = new KDFormattedTextField();
        kdtEntrys_initOccupyMargin_TextField.setName("kdtEntrys_initOccupyMargin_TextField");
        kdtEntrys_initOccupyMargin_TextField.setVisible(true);
        kdtEntrys_initOccupyMargin_TextField.setEditable(true);
        kdtEntrys_initOccupyMargin_TextField.setHorizontalAlignment(2);
        kdtEntrys_initOccupyMargin_TextField.setDataType(1);
        	kdtEntrys_initOccupyMargin_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_initOccupyMargin_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_initOccupyMargin_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_initOccupyMargin_CellEditor = new KDTDefaultCellEditor(kdtEntrys_initOccupyMargin_TextField);
        this.kdtEntrys.getColumn("initOccupyMargin").setEditor(kdtEntrys_initOccupyMargin_CellEditor);
        KDFormattedTextField kdtEntrys_unLockedOpMargin_TextField = new KDFormattedTextField();
        kdtEntrys_unLockedOpMargin_TextField.setName("kdtEntrys_unLockedOpMargin_TextField");
        kdtEntrys_unLockedOpMargin_TextField.setVisible(true);
        kdtEntrys_unLockedOpMargin_TextField.setEditable(true);
        kdtEntrys_unLockedOpMargin_TextField.setHorizontalAlignment(2);
        kdtEntrys_unLockedOpMargin_TextField.setDataType(1);
        	kdtEntrys_unLockedOpMargin_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_unLockedOpMargin_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_unLockedOpMargin_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_unLockedOpMargin_CellEditor = new KDTDefaultCellEditor(kdtEntrys_unLockedOpMargin_TextField);
        this.kdtEntrys.getColumn("unLockedOpMargin").setEditor(kdtEntrys_unLockedOpMargin_CellEditor);
        KDFormattedTextField kdtEntrys_enableOccupyMargin_TextField = new KDFormattedTextField();
        kdtEntrys_enableOccupyMargin_TextField.setName("kdtEntrys_enableOccupyMargin_TextField");
        kdtEntrys_enableOccupyMargin_TextField.setVisible(true);
        kdtEntrys_enableOccupyMargin_TextField.setEditable(true);
        kdtEntrys_enableOccupyMargin_TextField.setHorizontalAlignment(2);
        kdtEntrys_enableOccupyMargin_TextField.setDataType(1);
        	kdtEntrys_enableOccupyMargin_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_enableOccupyMargin_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_enableOccupyMargin_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_enableOccupyMargin_CellEditor = new KDTDefaultCellEditor(kdtEntrys_enableOccupyMargin_TextField);
        this.kdtEntrys.getColumn("enableOccupyMargin").setEditor(kdtEntrys_enableOccupyMargin_CellEditor);
        KDFormattedTextField kdtEntrys_unlockAmt_TextField = new KDFormattedTextField();
        kdtEntrys_unlockAmt_TextField.setName("kdtEntrys_unlockAmt_TextField");
        kdtEntrys_unlockAmt_TextField.setVisible(true);
        kdtEntrys_unlockAmt_TextField.setEditable(true);
        kdtEntrys_unlockAmt_TextField.setHorizontalAlignment(2);
        kdtEntrys_unlockAmt_TextField.setDataType(1);
        	kdtEntrys_unlockAmt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_unlockAmt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_unlockAmt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_unlockAmt_CellEditor = new KDTDefaultCellEditor(kdtEntrys_unlockAmt_TextField);
        this.kdtEntrys.getColumn("unlockAmt").setEditor(kdtEntrys_unlockAmt_CellEditor);
        KDTextField kdtEntrys_remark_TextField = new KDTextField();
        kdtEntrys_remark_TextField.setName("kdtEntrys_remark_TextField");
        kdtEntrys_remark_TextField.setMaxLength(250);
        KDTDefaultCellEditor kdtEntrys_remark_CellEditor = new KDTDefaultCellEditor(kdtEntrys_remark_TextField);
        this.kdtEntrys.getColumn("remark").setEditor(kdtEntrys_remark_CellEditor);
        // contFICompany		
        this.contFICompany.setBoundLabelText(resHelper.getString("contFICompany.boundLabelText"));		
        this.contFICompany.setBoundLabelLength(100);		
        this.contFICompany.setBoundLabelUnderline(true);		
        this.contFICompany.setVisible(true);
        // contbillStatus		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);
        // contfarmer		
        this.contfarmer.setBoundLabelText(resHelper.getString("contfarmer.boundLabelText"));		
        this.contfarmer.setBoundLabelLength(100);		
        this.contfarmer.setBoundLabelUnderline(true);		
        this.contfarmer.setVisible(true);
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // conttotalMargin		
        this.conttotalMargin.setBoundLabelText(resHelper.getString("conttotalMargin.boundLabelText"));		
        this.conttotalMargin.setBoundLabelLength(100);		
        this.conttotalMargin.setBoundLabelUnderline(true);		
        this.conttotalMargin.setVisible(true);
        // contoccupyMargin		
        this.contoccupyMargin.setBoundLabelText(resHelper.getString("contoccupyMargin.boundLabelText"));		
        this.contoccupyMargin.setBoundLabelLength(100);		
        this.contoccupyMargin.setBoundLabelUnderline(true);		
        this.contoccupyMargin.setVisible(true);
        // contenableMargin		
        this.contenableMargin.setBoundLabelText(resHelper.getString("contenableMargin.boundLabelText"));		
        this.contenableMargin.setBoundLabelLength(100);		
        this.contenableMargin.setBoundLabelUnderline(true);		
        this.contenableMargin.setVisible(true);
        // chkisFromSettleBill		
        this.chkisFromSettleBill.setText(resHelper.getString("chkisFromSettleBill.text"));		
        this.chkisFromSettleBill.setVisible(true);		
        this.chkisFromSettleBill.setHorizontalAlignment(2);		
        this.chkisFromSettleBill.setEnabled(false);
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
        // prmtFICompany		
        this.prmtFICompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery4AsstAcct");		
        this.prmtFICompany.setVisible(true);		
        this.prmtFICompany.setEditable(true);		
        this.prmtFICompany.setDisplayFormat("$name$");		
        this.prmtFICompany.setEditFormat("$number$");		
        this.prmtFICompany.setCommitFormat("$number$");		
        this.prmtFICompany.setRequired(true);
        		setOrgF7(prmtFICompany,com.kingdee.eas.basedata.org.OrgType.getEnum("Company"));
					
        // billStatus		
        this.billStatus.setVisible(true);		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // prmtfarmer		
        this.prmtfarmer.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerQuery");		
        this.prmtfarmer.setVisible(true);		
        this.prmtfarmer.setEditable(true);		
        this.prmtfarmer.setDisplayFormat("$name$");		
        this.prmtfarmer.setEditFormat("$number$");		
        this.prmtfarmer.setCommitFormat("$number$");		
        this.prmtfarmer.setRequired(false);
        		prmtfarmer.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.FarmerListUI prmtfarmer_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarmer_F7ListUI == null) {
					try {
						prmtfarmer_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.FarmerListUI();
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
					
        // pkauditTime		
        this.pkauditTime.setVisible(true);		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // txttotalMargin		
        this.txttotalMargin.setVisible(true);		
        this.txttotalMargin.setHorizontalAlignment(2);		
        this.txttotalMargin.setDataType(1);		
        this.txttotalMargin.setSupportedEmpty(true);		
        this.txttotalMargin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttotalMargin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttotalMargin.setPrecision(2);		
        this.txttotalMargin.setRequired(false);		
        this.txttotalMargin.setEnabled(false);
        // txtoccupyMargin		
        this.txtoccupyMargin.setVisible(true);		
        this.txtoccupyMargin.setHorizontalAlignment(2);		
        this.txtoccupyMargin.setDataType(1);		
        this.txtoccupyMargin.setSupportedEmpty(true);		
        this.txtoccupyMargin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtoccupyMargin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtoccupyMargin.setPrecision(2);		
        this.txtoccupyMargin.setRequired(false);		
        this.txtoccupyMargin.setEnabled(false);
        // txtenableMargin		
        this.txtenableMargin.setVisible(true);		
        this.txtenableMargin.setHorizontalAlignment(2);		
        this.txtenableMargin.setDataType(1);		
        this.txtenableMargin.setSupportedEmpty(true);		
        this.txtenableMargin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtenableMargin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtenableMargin.setPrecision(2);		
        this.txtenableMargin.setRequired(false);		
        this.txtenableMargin.setEnabled(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {billStatus,prmtfarmer,pkauditTime,txttotalMargin,txtoccupyMargin,txtenableMargin,chkisFromSettleBill}));
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
        contCreator.setBounds(new Rectangle(440, 524, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(440, 524, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(730, 524, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(730, 524, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(440, 555, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(440, 555, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(730, 555, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(730, 555, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(24, 18, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(24, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(366, 18, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(366, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(713, 52, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(713, 52, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(16, 528, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(16, 528, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(12, 154, 991, 358));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.carnivorous.basebiz.MarginUnlockBillEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(12, 154, 991, 358, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contFICompany.setBounds(new Rectangle(24, 52, 270, 19));
        this.add(contFICompany, new KDLayout.Constraints(24, 52, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(713, 18, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(713, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfarmer.setBounds(new Rectangle(366, 52, 270, 19));
        this.add(contfarmer, new KDLayout.Constraints(366, 52, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(16, 565, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(16, 565, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttotalMargin.setBounds(new Rectangle(24, 86, 270, 19));
        this.add(conttotalMargin, new KDLayout.Constraints(24, 86, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoccupyMargin.setBounds(new Rectangle(366, 86, 270, 19));
        this.add(contoccupyMargin, new KDLayout.Constraints(366, 86, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contenableMargin.setBounds(new Rectangle(713, 86, 270, 19));
        this.add(contenableMargin, new KDLayout.Constraints(713, 86, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkisFromSettleBill.setBounds(new Rectangle(24, 122, 270, 19));
        this.add(chkisFromSettleBill, new KDLayout.Constraints(24, 122, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contFICompany
        contFICompany.setBoundEditor(prmtFICompany);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //contfarmer
        contfarmer.setBoundEditor(prmtfarmer);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //conttotalMargin
        conttotalMargin.setBoundEditor(txttotalMargin);
        //contoccupyMargin
        contoccupyMargin.setBoundEditor(txtoccupyMargin);
        //contenableMargin
        contenableMargin.setBoundEditor(txtenableMargin);

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
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);
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
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.carnivorous.basebiz.MarginUnlockBillEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.unlockAmt", java.math.BigDecimal.class, this.kdtEntrys, "unlockAmt.text");
		dataBinder.registerBinding("entrys.batchContract", java.lang.Object.class, this.kdtEntrys, "batchContract.text");
		dataBinder.registerBinding("entrys.isUnlockInit", boolean.class, this.kdtEntrys, "isUnlockInit.text");
		dataBinder.registerBinding("entrys.initOccupyMargin", java.math.BigDecimal.class, this.kdtEntrys, "initOccupyMargin.text");
		dataBinder.registerBinding("entrys.actualInDate", java.util.Date.class, this.kdtEntrys, "actualInDate.text");
		dataBinder.registerBinding("entrys.restSingleMargin", java.math.BigDecimal.class, this.kdtEntrys, "restSingleMargin.text");
		dataBinder.registerBinding("entrys.actualUsedMargin", java.math.BigDecimal.class, this.kdtEntrys, "actualUsedMargin.text");
		dataBinder.registerBinding("entrys.remark", String.class, this.kdtEntrys, "remark.text");
		dataBinder.registerBinding("entrys.stockingBatch", java.lang.Object.class, this.kdtEntrys, "stockingBatch.text");
		dataBinder.registerBinding("entrys.unLockedOpMargin", java.math.BigDecimal.class, this.kdtEntrys, "unLockedOpMargin.text");
		dataBinder.registerBinding("entrys.enableOccupyMargin", java.math.BigDecimal.class, this.kdtEntrys, "enableOccupyMargin.text");
		dataBinder.registerBinding("entrys.batchQty", java.math.BigDecimal.class, this.kdtEntrys, "batchQty.text");
		dataBinder.registerBinding("entrys.mMargin", java.math.BigDecimal.class, this.kdtEntrys, "mMargin.text");
		dataBinder.registerBinding("entrys.sMargin", java.math.BigDecimal.class, this.kdtEntrys, "sMargin.text");
		dataBinder.registerBinding("entrys.farm", java.lang.Object.class, this.kdtEntrys, "farm.text");
		dataBinder.registerBinding("entrys.breedData", java.lang.Object.class, this.kdtEntrys, "breedData.text");
		dataBinder.registerBinding("isFromSettleBill", boolean.class, this.chkisFromSettleBill, "selected");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("FICompany", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtFICompany, "data");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("farmer", com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo.class, this.prmtfarmer, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("totalMargin", java.math.BigDecimal.class, this.txttotalMargin, "value");
		dataBinder.registerBinding("occupyMargin", java.math.BigDecimal.class, this.txtoccupyMargin, "value");
		dataBinder.registerBinding("enableMargin", java.math.BigDecimal.class, this.txtenableMargin, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.carnivorous.basebiz.app.MarginUnlockBillEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.carnivorous.basebiz.MarginUnlockBillInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.unlockAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.batchContract", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isUnlockInit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.initOccupyMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.actualInDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.restSingleMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.actualUsedMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.stockingBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.unLockedOpMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.enableOccupyMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.batchQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.mMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.breedData", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isFromSettleBill", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FICompany", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("occupyMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("enableMargin", ValidateHelper.ON_SAVE);    		
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
            if ("batchContract".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"actualInDate").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getDateValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"batchContract").getValue(),"actualBreedDate")));

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
    	sic.add(new SelectorItemInfo("entrys.unlockAmt"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.batchContract.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.batchContract.id"));
			sic.add(new SelectorItemInfo("entrys.batchContract.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.isUnlockInit"));
    	sic.add(new SelectorItemInfo("entrys.initOccupyMargin"));
    	sic.add(new SelectorItemInfo("entrys.actualInDate"));
    	sic.add(new SelectorItemInfo("entrys.restSingleMargin"));
    	sic.add(new SelectorItemInfo("entrys.actualUsedMargin"));
    	sic.add(new SelectorItemInfo("entrys.remark"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.stockingBatch.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.stockingBatch.id"));
			sic.add(new SelectorItemInfo("entrys.stockingBatch.name"));
        	sic.add(new SelectorItemInfo("entrys.stockingBatch.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.unLockedOpMargin"));
    	sic.add(new SelectorItemInfo("entrys.enableOccupyMargin"));
    	sic.add(new SelectorItemInfo("entrys.batchQty"));
    	sic.add(new SelectorItemInfo("entrys.mMargin"));
    	sic.add(new SelectorItemInfo("entrys.sMargin"));
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
			sic.add(new SelectorItemInfo("entrys.breedData.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.breedData.id"));
			sic.add(new SelectorItemInfo("entrys.breedData.name"));
        	sic.add(new SelectorItemInfo("entrys.breedData.number"));
		}
        sic.add(new SelectorItemInfo("isFromSettleBill"));
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
			sic.add(new SelectorItemInfo("FICompany.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("FICompany.id"));
        	sic.add(new SelectorItemInfo("FICompany.number"));
        	sic.add(new SelectorItemInfo("FICompany.name"));
		}
        sic.add(new SelectorItemInfo("billStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("farmer.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farmer.id"));
        	sic.add(new SelectorItemInfo("farmer.number"));
        	sic.add(new SelectorItemInfo("farmer.name"));
		}
        sic.add(new SelectorItemInfo("auditTime"));
        sic.add(new SelectorItemInfo("totalMargin"));
        sic.add(new SelectorItemInfo("occupyMargin"));
        sic.add(new SelectorItemInfo("enableMargin"));
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
        com.kingdee.eas.farm.carnivorous.basebiz.MarginUnlockBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.basebiz.MarginUnlockBillFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractMarginUnlockBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractMarginUnlockBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.basebiz.client", "MarginUnlockBillEditUI");
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
        return com.kingdee.eas.farm.carnivorous.basebiz.client.MarginUnlockBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.basebiz.MarginUnlockBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.basebiz.MarginUnlockBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.basebiz.MarginUnlockBillInfo();
				if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")).getBoolean("isBizUnit"))
			objectValue.put("FICompany",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")));
 
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/carnivorous/basebiz/MarginUnlockBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.carnivorous.basebiz.app.MarginUnlockBillQuery");
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