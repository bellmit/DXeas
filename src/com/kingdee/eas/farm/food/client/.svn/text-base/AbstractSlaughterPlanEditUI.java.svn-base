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
public abstract class AbstractSlaughterPlanEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSlaughterPlanEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstoOrg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperiod;
    protected com.kingdee.bos.ctrl.swing.KDLabel labelDays;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contslaughterHenHouseQtyAveDay;
    protected com.kingdee.bos.ctrl.swing.KDButton btnGetSlaughterPlan;
    protected com.kingdee.bos.ctrl.swing.KDButton btnSort;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntryScheduling;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntryScheduling_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer labelageOfDaysFrom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contageOfDaysTo;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstoOrg;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperiod;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtslaughterHenHouseQtyAveDay;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtageOfDaysFrom;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtageOfDaysTo;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnRefresh;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.farm.food.SlaughterPlanInfo editData = null;
    protected ActionGetSlaughterPlan actionGetSlaughterPlan = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionRefresh actionRefresh = null;
    /**
     * output class constructor
     */
    public AbstractSlaughterPlanEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractSlaughterPlanEditUI.class.getName());
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
        //actionGetSlaughterPlan
        this.actionGetSlaughterPlan = new ActionGetSlaughterPlan(this);
        getActionManager().registerAction("actionGetSlaughterPlan", actionGetSlaughterPlan);
        this.actionGetSlaughterPlan.setExtendProperty("canForewarn", "true");
        this.actionGetSlaughterPlan.setExtendProperty("userDefined", "false");
        this.actionGetSlaughterPlan.setExtendProperty("isObjectUpdateLock", "false");
         this.actionGetSlaughterPlan.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionGetSlaughterPlan.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
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
        //actionRefresh
        this.actionRefresh = new ActionRefresh(this);
        getActionManager().registerAction("actionRefresh", actionRefresh);
        this.actionRefresh.setExtendProperty("canForewarn", "true");
        this.actionRefresh.setExtendProperty("userDefined", "false");
        this.actionRefresh.setExtendProperty("isObjectUpdateLock", "false");
         this.actionRefresh.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionRefresh.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstoOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperiod = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.labelDays = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.contslaughterHenHouseQtyAveDay = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnGetSlaughterPlan = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnSort = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kdtEntryScheduling = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.labelageOfDaysFrom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contageOfDaysTo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.pkauditDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtstoOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtperiod = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtslaughterHenHouseQtyAveDay = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtageOfDaysFrom = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtageOfDaysTo = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.btnRefresh = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contAuditor.setName("contAuditor");
        this.kdtEntrys.setName("kdtEntrys");
        this.contbillStatus.setName("contbillStatus");
        this.contauditDate.setName("contauditDate");
        this.contstoOrg.setName("contstoOrg");
        this.contperiod.setName("contperiod");
        this.labelDays.setName("labelDays");
        this.contslaughterHenHouseQtyAveDay.setName("contslaughterHenHouseQtyAveDay");
        this.btnGetSlaughterPlan.setName("btnGetSlaughterPlan");
        this.btnSort.setName("btnSort");
        this.kdtEntryScheduling.setName("kdtEntryScheduling");
        this.labelageOfDaysFrom.setName("labelageOfDaysFrom");
        this.contageOfDaysTo.setName("contageOfDaysTo");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.prmtAuditor.setName("prmtAuditor");
        this.billStatus.setName("billStatus");
        this.pkauditDate.setName("pkauditDate");
        this.prmtstoOrg.setName("prmtstoOrg");
        this.prmtperiod.setName("prmtperiod");
        this.txtslaughterHenHouseQtyAveDay.setName("txtslaughterHenHouseQtyAveDay");
        this.txtageOfDaysFrom.setName("txtageOfDaysFrom");
        this.txtageOfDaysTo.setName("txtageOfDaysTo");
        this.btnRefresh.setName("btnRefresh");
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
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol1\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"lairageDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"pkDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"ageOfDaysActually\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"stoOrgUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"henHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"henHouseName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"SlaughterAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"isLocked\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"breedBatch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{lairageDate}</t:Cell><t:Cell>$Resource{pkDate}</t:Cell><t:Cell>$Resource{ageOfDaysActually}</t:Cell><t:Cell>$Resource{stoOrgUnit}</t:Cell><t:Cell>$Resource{henHouse}</t:Cell><t:Cell>$Resource{henHouseName}</t:Cell><t:Cell>$Resource{SlaughterAmt}</t:Cell><t:Cell>$Resource{isLocked}</t:Cell><t:Cell>$Resource{breedBatch}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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
            public void editStarted(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) {
                try {
                    kdtEntrys_editStarte(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
            public void editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) {
                try {
                    kdtEntrys_editStoppe(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });

                this.kdtEntrys.putBindContents("editData",new String[] {"id","lairageDate","pkDate","ageOfDaysActually","stoOrgUnit","henHouse","henHouseName","SlaughterAmt","isLocked","breedBatch"});


        this.kdtEntrys.checkParsed();
        KDDatePicker kdtEntrys_lairageDate_DatePicker = new KDDatePicker();
        kdtEntrys_lairageDate_DatePicker.setName("kdtEntrys_lairageDate_DatePicker");
        kdtEntrys_lairageDate_DatePicker.setVisible(true);
        kdtEntrys_lairageDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_lairageDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_lairageDate_DatePicker);
        this.kdtEntrys.getColumn("lairageDate").setEditor(kdtEntrys_lairageDate_CellEditor);
        KDDatePicker kdtEntrys_pkDate_DatePicker = new KDDatePicker();
        kdtEntrys_pkDate_DatePicker.setName("kdtEntrys_pkDate_DatePicker");
        kdtEntrys_pkDate_DatePicker.setVisible(true);
        kdtEntrys_pkDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_pkDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_pkDate_DatePicker);
        this.kdtEntrys.getColumn("pkDate").setEditor(kdtEntrys_pkDate_CellEditor);
        KDFormattedTextField kdtEntrys_ageOfDaysActually_TextField = new KDFormattedTextField();
        kdtEntrys_ageOfDaysActually_TextField.setName("kdtEntrys_ageOfDaysActually_TextField");
        kdtEntrys_ageOfDaysActually_TextField.setVisible(true);
        kdtEntrys_ageOfDaysActually_TextField.setEditable(true);
        kdtEntrys_ageOfDaysActually_TextField.setHorizontalAlignment(2);
        kdtEntrys_ageOfDaysActually_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_ageOfDaysActually_CellEditor = new KDTDefaultCellEditor(kdtEntrys_ageOfDaysActually_TextField);
        this.kdtEntrys.getColumn("ageOfDaysActually").setEditor(kdtEntrys_ageOfDaysActually_CellEditor);
        final KDBizPromptBox kdtEntrys_stoOrgUnit_PromptBox = new KDBizPromptBox();
        kdtEntrys_stoOrgUnit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");
        kdtEntrys_stoOrgUnit_PromptBox.setVisible(true);
        kdtEntrys_stoOrgUnit_PromptBox.setEditable(true);
        kdtEntrys_stoOrgUnit_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_stoOrgUnit_PromptBox.setEditFormat("$number$");
        kdtEntrys_stoOrgUnit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_stoOrgUnit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_stoOrgUnit_PromptBox);
        this.kdtEntrys.getColumn("stoOrgUnit").setEditor(kdtEntrys_stoOrgUnit_CellEditor);
        ObjectValueRender kdtEntrys_stoOrgUnit_OVR = new ObjectValueRender();
        kdtEntrys_stoOrgUnit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("stoOrgUnit").setRenderer(kdtEntrys_stoOrgUnit_OVR);
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
        KDFormattedTextField kdtEntrys_SlaughterAmt_TextField = new KDFormattedTextField();
        kdtEntrys_SlaughterAmt_TextField.setName("kdtEntrys_SlaughterAmt_TextField");
        kdtEntrys_SlaughterAmt_TextField.setVisible(true);
        kdtEntrys_SlaughterAmt_TextField.setEditable(true);
        kdtEntrys_SlaughterAmt_TextField.setHorizontalAlignment(2);
        kdtEntrys_SlaughterAmt_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_SlaughterAmt_CellEditor = new KDTDefaultCellEditor(kdtEntrys_SlaughterAmt_TextField);
        this.kdtEntrys.getColumn("SlaughterAmt").setEditor(kdtEntrys_SlaughterAmt_CellEditor);
        KDCheckBox kdtEntrys_isLocked_CheckBox = new KDCheckBox();
        kdtEntrys_isLocked_CheckBox.setName("kdtEntrys_isLocked_CheckBox");
        KDTDefaultCellEditor kdtEntrys_isLocked_CellEditor = new KDTDefaultCellEditor(kdtEntrys_isLocked_CheckBox);
        this.kdtEntrys.getColumn("isLocked").setEditor(kdtEntrys_isLocked_CellEditor);
        final KDBizPromptBox kdtEntrys_breedBatch_PromptBox = new KDBizPromptBox();
        kdtEntrys_breedBatch_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.BreedBatchF7Query");
        kdtEntrys_breedBatch_PromptBox.setVisible(true);
        kdtEntrys_breedBatch_PromptBox.setEditable(true);
        kdtEntrys_breedBatch_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_breedBatch_PromptBox.setEditFormat("$number$");
        kdtEntrys_breedBatch_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_breedBatch_CellEditor = new KDTDefaultCellEditor(kdtEntrys_breedBatch_PromptBox);
        this.kdtEntrys.getColumn("breedBatch").setEditor(kdtEntrys_breedBatch_CellEditor);
        ObjectValueRender kdtEntrys_breedBatch_OVR = new ObjectValueRender();
        kdtEntrys_breedBatch_OVR.setFormat(new BizDataFormat("$sourceBillId$"));
        this.kdtEntrys.getColumn("breedBatch").setRenderer(kdtEntrys_breedBatch_OVR);
        // contbillStatus		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);
        // contauditDate		
        this.contauditDate.setBoundLabelText(resHelper.getString("contauditDate.boundLabelText"));		
        this.contauditDate.setBoundLabelLength(100);		
        this.contauditDate.setBoundLabelUnderline(true);		
        this.contauditDate.setVisible(true);
        // contstoOrg		
        this.contstoOrg.setBoundLabelText(resHelper.getString("contstoOrg.boundLabelText"));		
        this.contstoOrg.setBoundLabelLength(100);		
        this.contstoOrg.setBoundLabelUnderline(true);		
        this.contstoOrg.setVisible(true);
        // contperiod		
        this.contperiod.setBoundLabelText(resHelper.getString("contperiod.boundLabelText"));		
        this.contperiod.setBoundLabelLength(100);		
        this.contperiod.setBoundLabelUnderline(true);		
        this.contperiod.setVisible(true);
        // labelDays		
        this.labelDays.setText(resHelper.getString("labelDays.text"));
        // contslaughterHenHouseQtyAveDay		
        this.contslaughterHenHouseQtyAveDay.setBoundLabelText(resHelper.getString("contslaughterHenHouseQtyAveDay.boundLabelText"));		
        this.contslaughterHenHouseQtyAveDay.setBoundLabelLength(100);		
        this.contslaughterHenHouseQtyAveDay.setBoundLabelUnderline(true);		
        this.contslaughterHenHouseQtyAveDay.setVisible(true);
        // btnGetSlaughterPlan		
        this.btnGetSlaughterPlan.setText(resHelper.getString("btnGetSlaughterPlan.text"));
        this.btnGetSlaughterPlan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                try {
                    btnGetSlaughterPlan_mouseClick(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });
        // btnSort		
        this.btnSort.setText(resHelper.getString("btnSort.text"));
        this.btnSort.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                try {
                    btnSort_mouseClick(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });
        // kdtEntryScheduling
		String kdtEntrySchedulingStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"schedulingDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"schedulingHenHouseQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"hadSortHenHouseQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"isOffDuty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"slaughterQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"lockedHenHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{schedulingDate}</t:Cell><t:Cell>$Resource{schedulingHenHouseQty}</t:Cell><t:Cell>$Resource{hadSortHenHouseQty}</t:Cell><t:Cell>$Resource{isOffDuty}</t:Cell><t:Cell>$Resource{slaughterQty}</t:Cell><t:Cell>$Resource{remark}</t:Cell><t:Cell>$Resource{lockedHenHouse}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntryScheduling.setFormatXml(resHelper.translateString("kdtEntryScheduling",kdtEntrySchedulingStrXML));
        this.kdtEntryScheduling.addKDTEditListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter() {
            public void editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) {
                try {
                    kdtEntryScheduling_editStopp(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
            public void editStarted(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) {
                try {
                    kdtEntryScheduling_editStart(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });

                this.kdtEntryScheduling.putBindContents("editData",new String[] {"seq","schedulingDate","schedulingHenHouseQty","hadSortHenHouseQty","isOffDuty","slaughterQty","remark","lockedHenHouse"});


        this.kdtEntryScheduling.checkParsed();
        KDFormattedTextField kdtEntryScheduling_seq_TextField = new KDFormattedTextField();
        kdtEntryScheduling_seq_TextField.setName("kdtEntryScheduling_seq_TextField");
        kdtEntryScheduling_seq_TextField.setVisible(true);
        kdtEntryScheduling_seq_TextField.setEditable(true);
        kdtEntryScheduling_seq_TextField.setHorizontalAlignment(2);
        kdtEntryScheduling_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntryScheduling_seq_CellEditor = new KDTDefaultCellEditor(kdtEntryScheduling_seq_TextField);
        this.kdtEntryScheduling.getColumn("seq").setEditor(kdtEntryScheduling_seq_CellEditor);
        KDDatePicker kdtEntryScheduling_schedulingDate_DatePicker = new KDDatePicker();
        kdtEntryScheduling_schedulingDate_DatePicker.setName("kdtEntryScheduling_schedulingDate_DatePicker");
        kdtEntryScheduling_schedulingDate_DatePicker.setVisible(true);
        kdtEntryScheduling_schedulingDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntryScheduling_schedulingDate_CellEditor = new KDTDefaultCellEditor(kdtEntryScheduling_schedulingDate_DatePicker);
        this.kdtEntryScheduling.getColumn("schedulingDate").setEditor(kdtEntryScheduling_schedulingDate_CellEditor);
        KDFormattedTextField kdtEntryScheduling_schedulingHenHouseQty_TextField = new KDFormattedTextField();
        kdtEntryScheduling_schedulingHenHouseQty_TextField.setName("kdtEntryScheduling_schedulingHenHouseQty_TextField");
        kdtEntryScheduling_schedulingHenHouseQty_TextField.setVisible(true);
        kdtEntryScheduling_schedulingHenHouseQty_TextField.setEditable(true);
        kdtEntryScheduling_schedulingHenHouseQty_TextField.setHorizontalAlignment(2);
        kdtEntryScheduling_schedulingHenHouseQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntryScheduling_schedulingHenHouseQty_CellEditor = new KDTDefaultCellEditor(kdtEntryScheduling_schedulingHenHouseQty_TextField);
        this.kdtEntryScheduling.getColumn("schedulingHenHouseQty").setEditor(kdtEntryScheduling_schedulingHenHouseQty_CellEditor);
        KDFormattedTextField kdtEntryScheduling_hadSortHenHouseQty_TextField = new KDFormattedTextField();
        kdtEntryScheduling_hadSortHenHouseQty_TextField.setName("kdtEntryScheduling_hadSortHenHouseQty_TextField");
        kdtEntryScheduling_hadSortHenHouseQty_TextField.setVisible(true);
        kdtEntryScheduling_hadSortHenHouseQty_TextField.setEditable(true);
        kdtEntryScheduling_hadSortHenHouseQty_TextField.setHorizontalAlignment(2);
        kdtEntryScheduling_hadSortHenHouseQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntryScheduling_hadSortHenHouseQty_CellEditor = new KDTDefaultCellEditor(kdtEntryScheduling_hadSortHenHouseQty_TextField);
        this.kdtEntryScheduling.getColumn("hadSortHenHouseQty").setEditor(kdtEntryScheduling_hadSortHenHouseQty_CellEditor);
        KDCheckBox kdtEntryScheduling_isOffDuty_CheckBox = new KDCheckBox();
        kdtEntryScheduling_isOffDuty_CheckBox.setName("kdtEntryScheduling_isOffDuty_CheckBox");
        KDTDefaultCellEditor kdtEntryScheduling_isOffDuty_CellEditor = new KDTDefaultCellEditor(kdtEntryScheduling_isOffDuty_CheckBox);
        this.kdtEntryScheduling.getColumn("isOffDuty").setEditor(kdtEntryScheduling_isOffDuty_CellEditor);
        KDFormattedTextField kdtEntryScheduling_slaughterQty_TextField = new KDFormattedTextField();
        kdtEntryScheduling_slaughterQty_TextField.setName("kdtEntryScheduling_slaughterQty_TextField");
        kdtEntryScheduling_slaughterQty_TextField.setVisible(true);
        kdtEntryScheduling_slaughterQty_TextField.setEditable(true);
        kdtEntryScheduling_slaughterQty_TextField.setHorizontalAlignment(2);
        kdtEntryScheduling_slaughterQty_TextField.setDataType(1);
        	kdtEntryScheduling_slaughterQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntryScheduling_slaughterQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntryScheduling_slaughterQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntryScheduling_slaughterQty_CellEditor = new KDTDefaultCellEditor(kdtEntryScheduling_slaughterQty_TextField);
        this.kdtEntryScheduling.getColumn("slaughterQty").setEditor(kdtEntryScheduling_slaughterQty_CellEditor);
        KDTextField kdtEntryScheduling_remark_TextField = new KDTextField();
        kdtEntryScheduling_remark_TextField.setName("kdtEntryScheduling_remark_TextField");
        kdtEntryScheduling_remark_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntryScheduling_remark_CellEditor = new KDTDefaultCellEditor(kdtEntryScheduling_remark_TextField);
        this.kdtEntryScheduling.getColumn("remark").setEditor(kdtEntryScheduling_remark_CellEditor);
        KDFormattedTextField kdtEntryScheduling_lockedHenHouse_TextField = new KDFormattedTextField();
        kdtEntryScheduling_lockedHenHouse_TextField.setName("kdtEntryScheduling_lockedHenHouse_TextField");
        kdtEntryScheduling_lockedHenHouse_TextField.setVisible(true);
        kdtEntryScheduling_lockedHenHouse_TextField.setEditable(true);
        kdtEntryScheduling_lockedHenHouse_TextField.setHorizontalAlignment(2);
        kdtEntryScheduling_lockedHenHouse_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntryScheduling_lockedHenHouse_CellEditor = new KDTDefaultCellEditor(kdtEntryScheduling_lockedHenHouse_TextField);
        this.kdtEntryScheduling.getColumn("lockedHenHouse").setEditor(kdtEntryScheduling_lockedHenHouse_CellEditor);
        // labelageOfDaysFrom		
        this.labelageOfDaysFrom.setBoundLabelText(resHelper.getString("labelageOfDaysFrom.boundLabelText"));		
        this.labelageOfDaysFrom.setBoundLabelLength(100);		
        this.labelageOfDaysFrom.setBoundLabelUnderline(true);
        // contageOfDaysTo		
        this.contageOfDaysTo.setBoundLabelText(resHelper.getString("contageOfDaysTo.boundLabelText"));		
        this.contageOfDaysTo.setBoundLabelLength(40);
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
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // billStatus		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.cm.common.BillBaseStatusEnum").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // pkauditDate		
        this.pkauditDate.setRequired(false);		
        this.pkauditDate.setEnabled(false);
        // prmtstoOrg		
        this.prmtstoOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtstoOrg.setEditable(true);		
        this.prmtstoOrg.setDisplayFormat("$name$");		
        this.prmtstoOrg.setEditFormat("$number$");		
        this.prmtstoOrg.setCommitFormat("$number$");		
        this.prmtstoOrg.setRequired(true);		
        this.prmtstoOrg.setEnabled(false);
        // prmtperiod		
        this.prmtperiod.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7PeriodQuery");		
        this.prmtperiod.setEditable(true);		
        this.prmtperiod.setDisplayFormat("$number$");		
        this.prmtperiod.setEditFormat("$number$");		
        this.prmtperiod.setCommitFormat("$number$");		
        this.prmtperiod.setRequired(true);
        // txtslaughterHenHouseQtyAveDay		
        this.txtslaughterHenHouseQtyAveDay.setHorizontalAlignment(2);		
        this.txtslaughterHenHouseQtyAveDay.setDataType(0);		
        this.txtslaughterHenHouseQtyAveDay.setSupportedEmpty(true);		
        this.txtslaughterHenHouseQtyAveDay.setRequired(true);
        // txtageOfDaysFrom		
        this.txtageOfDaysFrom.setHorizontalAlignment(2);		
        this.txtageOfDaysFrom.setDataType(0);		
        this.txtageOfDaysFrom.setSupportedEmpty(true);		
        this.txtageOfDaysFrom.setRequired(true);
        this.txtageOfDaysFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    txtageOfDaysFrom_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // txtageOfDaysTo		
        this.txtageOfDaysTo.setHorizontalAlignment(2);		
        this.txtageOfDaysTo.setDataType(0);		
        this.txtageOfDaysTo.setSupportedEmpty(true);		
        this.txtageOfDaysTo.setRequired(true);
        this.txtageOfDaysTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    txtageOfDaysTo_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnRefresh
        this.btnRefresh.setAction((IItemAction)ActionProxyFactory.getProxy(actionRefresh, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnRefresh.setText(resHelper.getString("btnRefresh.text"));
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,billStatus,pkauditDate,prmtstoOrg,prmtperiod,txtageOfDaysFrom,txtageOfDaysTo,txtslaughterHenHouseQtyAveDay,kdtEntrys,kdtEntryScheduling}));
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
        contCreator.setBounds(new Rectangle(374, 556, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(374, 556, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(731, 556, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(731, 556, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(374, 587, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(374, 587, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(731, 587, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(731, 587, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(17, 17, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(17, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(731, 17, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(731, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(17, 556, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(17, 556, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntrys.setBounds(new Rectangle(17, 128, 596, 418));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.food.SlaughterPlanEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(17, 128, 596, 418, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(731, 54, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(731, 54, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contauditDate.setBounds(new Rectangle(17, 587, 270, 19));
        this.add(contauditDate, new KDLayout.Constraints(17, 587, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contstoOrg.setBounds(new Rectangle(374, 17, 270, 19));
        this.add(contstoOrg, new KDLayout.Constraints(374, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contperiod.setBounds(new Rectangle(17, 54, 270, 19));
        this.add(contperiod, new KDLayout.Constraints(17, 54, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        labelDays.setBounds(new Rectangle(628, 56, 16, 19));
        this.add(labelDays, new KDLayout.Constraints(628, 56, 16, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contslaughterHenHouseQtyAveDay.setBounds(new Rectangle(17, 97, 270, 19));
        this.add(contslaughterHenHouseQtyAveDay, new KDLayout.Constraints(17, 97, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnGetSlaughterPlan.setBounds(new Rectangle(672, 96, 124, 21));
        this.add(btnGetSlaughterPlan, new KDLayout.Constraints(672, 96, 124, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnSort.setBounds(new Rectangle(824, 97, 73, 21));
        this.add(btnSort, new KDLayout.Constraints(824, 97, 73, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kdtEntryScheduling.setBounds(new Rectangle(631, 128, 370, 418));
        kdtEntryScheduling_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntryScheduling,new com.kingdee.eas.farm.food.SlaughterPlanEntrySchedulingInfo(),null,false);
        this.add(kdtEntryScheduling_detailPanel, new KDLayout.Constraints(631, 128, 370, 418, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtEntryScheduling_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
		vo.put("schedulingHenHouseQty",new Integer(5));
		vo.put("hadSortHenHouseQty",new Integer(0));
		vo.put("lockedHenHouse",new Integer(0));
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        labelageOfDaysFrom.setBounds(new Rectangle(374, 56, 153, 19));
        this.add(labelageOfDaysFrom, new KDLayout.Constraints(374, 56, 153, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contageOfDaysTo.setBounds(new Rectangle(541, 56, 78, 19));
        this.add(contageOfDaysTo, new KDLayout.Constraints(541, 56, 78, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contAuditor
        contAuditor.setBoundEditor(prmtAuditor);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //contauditDate
        contauditDate.setBoundEditor(pkauditDate);
        //contstoOrg
        contstoOrg.setBoundEditor(prmtstoOrg);
        //contperiod
        contperiod.setBoundEditor(prmtperiod);
        //contslaughterHenHouseQtyAveDay
        contslaughterHenHouseQtyAveDay.setBoundEditor(txtslaughterHenHouseQtyAveDay);
        //labelageOfDaysFrom
        labelageOfDaysFrom.setBoundEditor(txtageOfDaysFrom);
        //contageOfDaysTo
        contageOfDaysTo.setBoundEditor(txtageOfDaysTo);

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
        this.toolBar.add(btnRefresh);
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);
        this.toolBar.add(btnTraceUp);
        this.toolBar.add(btnTraceDown);
        this.toolBar.add(btnWorkFlowG);
        this.toolBar.add(btnSignature);
        this.toolBar.add(btnViewSignature);
        this.toolBar.add(separatorFW5);
        this.toolBar.add(separatorFW4);
        this.toolBar.add(btnNumberSign);
        this.toolBar.add(btnNextPerson);
        this.toolBar.add(separatorFW7);
        this.toolBar.add(btnCreateFrom);
        this.toolBar.add(btnCopyFrom);
        this.toolBar.add(btnCreateTo);
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


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.food.SlaughterPlanEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.stoOrgUnit", java.lang.Object.class, this.kdtEntrys, "stoOrgUnit.text");
		dataBinder.registerBinding("entrys.henHouse", java.lang.Object.class, this.kdtEntrys, "henHouse.text");
		dataBinder.registerBinding("entrys.henHouseName", String.class, this.kdtEntrys, "henHouseName.text");
		dataBinder.registerBinding("entrys.SlaughterAmt", int.class, this.kdtEntrys, "SlaughterAmt.text");
		dataBinder.registerBinding("entrys.pkDate", java.util.Date.class, this.kdtEntrys, "pkDate.text");
		dataBinder.registerBinding("entrys.ageOfDaysActually", int.class, this.kdtEntrys, "ageOfDaysActually.text");
		dataBinder.registerBinding("entrys.lairageDate", java.util.Date.class, this.kdtEntrys, "lairageDate.text");
		dataBinder.registerBinding("entrys.isLocked", boolean.class, this.kdtEntrys, "isLocked.text");
		dataBinder.registerBinding("entrys.breedBatch", java.lang.Object.class, this.kdtEntrys, "breedBatch.text");
		dataBinder.registerBinding("EntryScheduling.seq", int.class, this.kdtEntryScheduling, "seq.text");
		dataBinder.registerBinding("EntryScheduling", com.kingdee.eas.farm.food.SlaughterPlanEntrySchedulingInfo.class, this.kdtEntryScheduling, "userObject");
		dataBinder.registerBinding("EntryScheduling.schedulingDate", java.util.Date.class, this.kdtEntryScheduling, "schedulingDate.text");
		dataBinder.registerBinding("EntryScheduling.schedulingHenHouseQty", int.class, this.kdtEntryScheduling, "schedulingHenHouseQty.text");
		dataBinder.registerBinding("EntryScheduling.isOffDuty", boolean.class, this.kdtEntryScheduling, "isOffDuty.text");
		dataBinder.registerBinding("EntryScheduling.slaughterQty", java.math.BigDecimal.class, this.kdtEntryScheduling, "slaughterQty.text");
		dataBinder.registerBinding("EntryScheduling.remark", String.class, this.kdtEntryScheduling, "remark.text");
		dataBinder.registerBinding("EntryScheduling.lockedHenHouse", int.class, this.kdtEntryScheduling, "lockedHenHouse.text");
		dataBinder.registerBinding("EntryScheduling.hadSortHenHouseQty", int.class, this.kdtEntryScheduling, "hadSortHenHouseQty.text");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.cm.common.BillBaseStatusEnum.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("auditDate", java.util.Date.class, this.pkauditDate, "value");
		dataBinder.registerBinding("stoOrg", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtstoOrg, "data");
		dataBinder.registerBinding("period", com.kingdee.eas.basedata.assistant.PeriodInfo.class, this.prmtperiod, "data");
		dataBinder.registerBinding("slaughterHenHouseQtyAveDay", int.class, this.txtslaughterHenHouseQtyAveDay, "value");
		dataBinder.registerBinding("ageOfDaysFrom", int.class, this.txtageOfDaysFrom, "value");
		dataBinder.registerBinding("ageOfDaysTo", int.class, this.txtageOfDaysTo, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.food.app.SlaughterPlanEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.food.SlaughterPlanInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.stoOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.henHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.henHouseName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.SlaughterAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.pkDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.ageOfDaysActually", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.lairageDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isLocked", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.breedBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EntryScheduling.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EntryScheduling", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EntryScheduling.schedulingDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EntryScheduling.schedulingHenHouseQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EntryScheduling.isOffDuty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EntryScheduling.slaughterQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EntryScheduling.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EntryScheduling.lockedHenHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EntryScheduling.hadSortHenHouseQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("stoOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("period", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("slaughterHenHouseQtyAveDay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ageOfDaysFrom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ageOfDaysTo", ValidateHelper.ON_SAVE);    		
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
     * output kdtEntrys_editStarte method
     */
    protected void kdtEntrys_editStarte(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
    }

    /**
     * output kdtEntrys_editStoppe method
     */
    protected void kdtEntrys_editStoppe(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
    }

    /**
     * output btnGetSlaughterPlan_mouseClick method
     */
    protected void btnGetSlaughterPlan_mouseClick(java.awt.event.MouseEvent e) throws Exception
    {
    }

    /**
     * output btnSort_mouseClick method
     */
    protected void btnSort_mouseClick(java.awt.event.MouseEvent e) throws Exception
    {
    }

    /**
     * output kdtEntryScheduling_editStopp method
     */
    protected void kdtEntryScheduling_editStopp(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
    }

    /**
     * output kdtEntryScheduling_editStart method
     */
    protected void kdtEntryScheduling_editStart(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
    }

    /**
     * output txtageOfDaysFrom_actionPerformed method
     */
    protected void txtageOfDaysFrom_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output txtageOfDaysTo_actionPerformed method
     */
    protected void txtageOfDaysTo_actionPerformed(java.awt.event.ActionEvent e) throws Exception
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.stoOrgUnit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.stoOrgUnit.id"));
			sic.add(new SelectorItemInfo("entrys.stoOrgUnit.name"));
        	sic.add(new SelectorItemInfo("entrys.stoOrgUnit.number"));
		}
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
    	sic.add(new SelectorItemInfo("entrys.SlaughterAmt"));
    	sic.add(new SelectorItemInfo("entrys.pkDate"));
    	sic.add(new SelectorItemInfo("entrys.ageOfDaysActually"));
    	sic.add(new SelectorItemInfo("entrys.lairageDate"));
    	sic.add(new SelectorItemInfo("entrys.isLocked"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.breedBatch.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.breedBatch.id"));
			sic.add(new SelectorItemInfo("entrys.breedBatch.sourceBillId"));
        	sic.add(new SelectorItemInfo("entrys.breedBatch.number"));
		}
    	sic.add(new SelectorItemInfo("EntryScheduling.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EntryScheduling.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("EntryScheduling.schedulingDate"));
    	sic.add(new SelectorItemInfo("EntryScheduling.schedulingHenHouseQty"));
    	sic.add(new SelectorItemInfo("EntryScheduling.isOffDuty"));
    	sic.add(new SelectorItemInfo("EntryScheduling.slaughterQty"));
    	sic.add(new SelectorItemInfo("EntryScheduling.remark"));
    	sic.add(new SelectorItemInfo("EntryScheduling.lockedHenHouse"));
    	sic.add(new SelectorItemInfo("EntryScheduling.hadSortHenHouseQty"));
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
        sic.add(new SelectorItemInfo("auditDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("stoOrg.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("stoOrg.id"));
        	sic.add(new SelectorItemInfo("stoOrg.number"));
        	sic.add(new SelectorItemInfo("stoOrg.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("period.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("period.id"));
        	sic.add(new SelectorItemInfo("period.number"));
		}
        sic.add(new SelectorItemInfo("slaughterHenHouseQtyAveDay"));
        sic.add(new SelectorItemInfo("ageOfDaysFrom"));
        sic.add(new SelectorItemInfo("ageOfDaysTo"));
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
     * output actionGetSlaughterPlan_actionPerformed method
     */
    public void actionGetSlaughterPlan_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.food.SlaughterPlanFactory.getRemoteInstance().getSlaughterPlan(editData);
    }
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.food.SlaughterPlanFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.food.SlaughterPlanFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionRefresh_actionPerformed method
     */
    public void actionRefresh_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.food.SlaughterPlanFactory.getRemoteInstance().refresh(editData);
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
	public RequestContext prepareActionGetSlaughterPlan(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionGetSlaughterPlan() {
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
	public RequestContext prepareActionRefresh(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionRefresh() {
    	return false;
    }

    /**
     * output ActionGetSlaughterPlan class
     */     
    protected class ActionGetSlaughterPlan extends ItemAction {     
    
        public ActionGetSlaughterPlan()
        {
            this(null);
        }

        public ActionGetSlaughterPlan(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionGetSlaughterPlan.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionGetSlaughterPlan.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionGetSlaughterPlan.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractSlaughterPlanEditUI.this, "ActionGetSlaughterPlan", "actionGetSlaughterPlan_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractSlaughterPlanEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractSlaughterPlanEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionRefresh class
     */     
    protected class ActionRefresh extends ItemAction {     
    
        public ActionRefresh()
        {
            this(null);
        }

        public ActionRefresh(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionRefresh.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionRefresh.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionRefresh.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractSlaughterPlanEditUI.this, "ActionRefresh", "actionRefresh_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.food.client", "SlaughterPlanEditUI");
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
        return com.kingdee.eas.farm.food.client.SlaughterPlanEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.food.SlaughterPlanFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.food.SlaughterPlanInfo objectValue = new com.kingdee.eas.farm.food.SlaughterPlanInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/food/SlaughterPlan";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.food.app.SlaughterPlanQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"pkDate").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"宰杀日期"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"stoOrgUnit").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖场"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"henHouse").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"鸡舍"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"henHouseName").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"鸡舍名称"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"SlaughterAmt").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"宰杀只数"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtNumber.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"单据编号"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtstoOrg.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"食品厂"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtperiod.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"宰杀期间"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtslaughterHenHouseQtyAveDay.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"标准宰杀舍数"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtageOfDaysFrom.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"日龄从"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtageOfDaysTo.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"日龄到"});
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
		vo.put("billStatus",new Integer(8));
		vo.put("slaughterHenHouseQtyAveDay",new Integer(5));
		vo.put("ageOfDaysFrom",new Integer(39));
		vo.put("ageOfDaysTo",new Integer(41));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}