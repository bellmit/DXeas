/**
 * output package name
 */
package com.kingdee.eas.farm.pig.ccpig.client;

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
public abstract class AbstractCCPigBatchEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCCPigBatchEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcostObject;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdays;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continitAllQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpigFarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaveWeight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpigLevel;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcostObject;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtPigletBatchEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtPigletBatchEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtPbEarNumbers;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtPbEarNumbers_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDButton btnBatchAddPigNumber;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdays;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtinitAllQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpigFarm;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtaveWeight;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpigLevel;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem btnUpdateMarket;
    protected com.kingdee.eas.farm.pig.ccpig.CCPigBatchInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionUpdateBatchMarket actionUpdateBatchMarket = null;
    /**
     * output class constructor
     */
    public AbstractCCPigBatchEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCCPigBatchEditUI.class.getName());
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
        //actionUpdateBatchMarket
        this.actionUpdateBatchMarket = new ActionUpdateBatchMarket(this);
        getActionManager().registerAction("actionUpdateBatchMarket", actionUpdateBatchMarket);
        this.actionUpdateBatchMarket.setExtendProperty("canForewarn", "true");
        this.actionUpdateBatchMarket.setExtendProperty("userDefined", "true");
        this.actionUpdateBatchMarket.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUpdateBatchMarket.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUpdateBatchMarket.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcostObject = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdays = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continitAllQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpigFarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contaveWeight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpigLevel = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcostObject = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtPigletBatchEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtPbEarNumbers = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.btnBatchAddPigNumber = new com.kingdee.bos.ctrl.swing.KDButton();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtdays = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtinitAllQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtpigFarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtaveWeight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtpigLevel = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUpdateMarket = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.contcostObject.setName("contcostObject");
        this.contauditTime.setName("contauditTime");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contbaseStatus.setName("contbaseStatus");
        this.contdays.setName("contdays");
        this.continitAllQty.setName("continitAllQty");
        this.contpigFarm.setName("contpigFarm");
        this.contaveWeight.setName("contaveWeight");
        this.contpigLevel.setName("contpigLevel");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtcostObject.setName("prmtcostObject");
        this.pkauditTime.setName("pkauditTime");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kdtEntrys.setName("kdtEntrys");
        this.kdtPigletBatchEntry.setName("kdtPigletBatchEntry");
        this.kdtPbEarNumbers.setName("kdtPbEarNumbers");
        this.btnBatchAddPigNumber.setName("btnBatchAddPigNumber");
        this.baseStatus.setName("baseStatus");
        this.txtdays.setName("txtdays");
        this.txtinitAllQty.setName("txtinitAllQty");
        this.prmtpigFarm.setName("prmtpigFarm");
        this.txtaveWeight.setName("txtaveWeight");
        this.prmtpigLevel.setName("prmtpigLevel");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
        this.btnUpdateMarket.setName("btnUpdateMarket");
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
        // contcostObject		
        this.contcostObject.setBoundLabelText(resHelper.getString("contcostObject.boundLabelText"));		
        this.contcostObject.setBoundLabelLength(100);		
        this.contcostObject.setBoundLabelUnderline(true);		
        this.contcostObject.setVisible(true);
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // kDTabbedPane1
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);
        // contdays		
        this.contdays.setBoundLabelText(resHelper.getString("contdays.boundLabelText"));		
        this.contdays.setBoundLabelLength(100);		
        this.contdays.setBoundLabelUnderline(true);		
        this.contdays.setVisible(true);
        // continitAllQty		
        this.continitAllQty.setBoundLabelText(resHelper.getString("continitAllQty.boundLabelText"));		
        this.continitAllQty.setBoundLabelLength(100);		
        this.continitAllQty.setBoundLabelUnderline(true);		
        this.continitAllQty.setVisible(true);
        // contpigFarm		
        this.contpigFarm.setBoundLabelText(resHelper.getString("contpigFarm.boundLabelText"));		
        this.contpigFarm.setBoundLabelLength(100);		
        this.contpigFarm.setBoundLabelUnderline(true);		
        this.contpigFarm.setVisible(true);
        // contaveWeight		
        this.contaveWeight.setBoundLabelText(resHelper.getString("contaveWeight.boundLabelText"));		
        this.contaveWeight.setBoundLabelLength(100);		
        this.contaveWeight.setBoundLabelUnderline(true);		
        this.contaveWeight.setVisible(true);
        // contpigLevel		
        this.contpigLevel.setBoundLabelText(resHelper.getString("contpigLevel.boundLabelText"));		
        this.contpigLevel.setBoundLabelLength(100);		
        this.contpigLevel.setBoundLabelUnderline(true);		
        this.contpigLevel.setVisible(true);
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
        // prmtcostObject		
        this.prmtcostObject.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");		
        this.prmtcostObject.setEditable(true);		
        this.prmtcostObject.setDisplayFormat("$name$");		
        this.prmtcostObject.setEditFormat("$number$");		
        this.prmtcostObject.setCommitFormat("$number$");		
        this.prmtcostObject.setRequired(true);
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // kDPanel1
        // kDPanel2
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"pigHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"incoopDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"initQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"isMarket\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"marketDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"marketQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{pigHouse}</t:Cell><t:Cell>$Resource{incoopDate}</t:Cell><t:Cell>$Resource{initQty}</t:Cell><t:Cell>$Resource{isMarket}</t:Cell><t:Cell>$Resource{marketDate}</t:Cell><t:Cell>$Resource{marketQty}</t:Cell><t:Cell>$Resource{remark}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));

                this.kdtEntrys.putBindContents("editData",new String[] {"id","pigHouse","incoopDate","initQty","isMarket","marketDate","marketQty","remark"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_pigHouse_PromptBox = new KDBizPromptBox();
        kdtEntrys_pigHouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.pig.app.PigHouseF7Query");
        kdtEntrys_pigHouse_PromptBox.setVisible(true);
        kdtEntrys_pigHouse_PromptBox.setEditable(true);
        kdtEntrys_pigHouse_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_pigHouse_PromptBox.setEditFormat("$number$");
        kdtEntrys_pigHouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_pigHouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_pigHouse_PromptBox);
        this.kdtEntrys.getColumn("pigHouse").setEditor(kdtEntrys_pigHouse_CellEditor);
        ObjectValueRender kdtEntrys_pigHouse_OVR = new ObjectValueRender();
        kdtEntrys_pigHouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("pigHouse").setRenderer(kdtEntrys_pigHouse_OVR);
        			kdtEntrys_pigHouse_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.pig.client.PigHouseListUI kdtEntrys_pigHouse_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_pigHouse_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_pigHouse_PromptBox_F7ListUI = new com.kingdee.eas.farm.pig.client.PigHouseListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_pigHouse_PromptBox_F7ListUI));
					kdtEntrys_pigHouse_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_pigHouse_PromptBox.setSelector(kdtEntrys_pigHouse_PromptBox_F7ListUI);
				}
			}
		});
					
        KDDatePicker kdtEntrys_incoopDate_DatePicker = new KDDatePicker();
        kdtEntrys_incoopDate_DatePicker.setName("kdtEntrys_incoopDate_DatePicker");
        kdtEntrys_incoopDate_DatePicker.setVisible(true);
        kdtEntrys_incoopDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_incoopDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_incoopDate_DatePicker);
        this.kdtEntrys.getColumn("incoopDate").setEditor(kdtEntrys_incoopDate_CellEditor);
        KDFormattedTextField kdtEntrys_initQty_TextField = new KDFormattedTextField();
        kdtEntrys_initQty_TextField.setName("kdtEntrys_initQty_TextField");
        kdtEntrys_initQty_TextField.setVisible(true);
        kdtEntrys_initQty_TextField.setEditable(true);
        kdtEntrys_initQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_initQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_initQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_initQty_TextField);
        this.kdtEntrys.getColumn("initQty").setEditor(kdtEntrys_initQty_CellEditor);
        KDCheckBox kdtEntrys_isMarket_CheckBox = new KDCheckBox();
        kdtEntrys_isMarket_CheckBox.setName("kdtEntrys_isMarket_CheckBox");
        KDTDefaultCellEditor kdtEntrys_isMarket_CellEditor = new KDTDefaultCellEditor(kdtEntrys_isMarket_CheckBox);
        this.kdtEntrys.getColumn("isMarket").setEditor(kdtEntrys_isMarket_CellEditor);
        KDDatePicker kdtEntrys_marketDate_DatePicker = new KDDatePicker();
        kdtEntrys_marketDate_DatePicker.setName("kdtEntrys_marketDate_DatePicker");
        kdtEntrys_marketDate_DatePicker.setVisible(true);
        kdtEntrys_marketDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_marketDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_marketDate_DatePicker);
        this.kdtEntrys.getColumn("marketDate").setEditor(kdtEntrys_marketDate_CellEditor);
        KDFormattedTextField kdtEntrys_marketQty_TextField = new KDFormattedTextField();
        kdtEntrys_marketQty_TextField.setName("kdtEntrys_marketQty_TextField");
        kdtEntrys_marketQty_TextField.setVisible(true);
        kdtEntrys_marketQty_TextField.setEditable(true);
        kdtEntrys_marketQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_marketQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_marketQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_marketQty_TextField);
        this.kdtEntrys.getColumn("marketQty").setEditor(kdtEntrys_marketQty_CellEditor);
        KDTextField kdtEntrys_remark_TextField = new KDTextField();
        kdtEntrys_remark_TextField.setName("kdtEntrys_remark_TextField");
        kdtEntrys_remark_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_remark_CellEditor = new KDTDefaultCellEditor(kdtEntrys_remark_TextField);
        this.kdtEntrys.getColumn("remark").setEditor(kdtEntrys_remark_CellEditor);
        // kdtPigletBatchEntry
		String kdtPigletBatchEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"company\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"costObject\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{company}</t:Cell><t:Cell>$Resource{costObject}</t:Cell><t:Cell>$Resource{qty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtPigletBatchEntry.setFormatXml(resHelper.translateString("kdtPigletBatchEntry",kdtPigletBatchEntryStrXML));
        this.kdtPigletBatchEntry.addKDTEditListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter() {
            public void editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) {
                try {
                    kdtPigletBatchEntry_editStopped(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });

                this.kdtPigletBatchEntry.putBindContents("editData",new String[] {"seq","company","costObject","qty"});


        this.kdtPigletBatchEntry.checkParsed();
        KDFormattedTextField kdtPigletBatchEntry_seq_TextField = new KDFormattedTextField();
        kdtPigletBatchEntry_seq_TextField.setName("kdtPigletBatchEntry_seq_TextField");
        kdtPigletBatchEntry_seq_TextField.setVisible(true);
        kdtPigletBatchEntry_seq_TextField.setEditable(true);
        kdtPigletBatchEntry_seq_TextField.setHorizontalAlignment(2);
        kdtPigletBatchEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtPigletBatchEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtPigletBatchEntry_seq_TextField);
        this.kdtPigletBatchEntry.getColumn("seq").setEditor(kdtPigletBatchEntry_seq_CellEditor);
        final KDBizPromptBox kdtPigletBatchEntry_company_PromptBox = new KDBizPromptBox();
        kdtPigletBatchEntry_company_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery4AsstAcct");
        kdtPigletBatchEntry_company_PromptBox.setVisible(true);
        kdtPigletBatchEntry_company_PromptBox.setEditable(true);
        kdtPigletBatchEntry_company_PromptBox.setDisplayFormat("$number$");
        kdtPigletBatchEntry_company_PromptBox.setEditFormat("$number$");
        kdtPigletBatchEntry_company_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtPigletBatchEntry_company_CellEditor = new KDTDefaultCellEditor(kdtPigletBatchEntry_company_PromptBox);
        this.kdtPigletBatchEntry.getColumn("company").setEditor(kdtPigletBatchEntry_company_CellEditor);
        ObjectValueRender kdtPigletBatchEntry_company_OVR = new ObjectValueRender();
        kdtPigletBatchEntry_company_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtPigletBatchEntry.getColumn("company").setRenderer(kdtPigletBatchEntry_company_OVR);
        final KDBizPromptBox kdtPigletBatchEntry_costObject_PromptBox = new KDBizPromptBox();
        kdtPigletBatchEntry_costObject_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");
        kdtPigletBatchEntry_costObject_PromptBox.setVisible(true);
        kdtPigletBatchEntry_costObject_PromptBox.setEditable(true);
        kdtPigletBatchEntry_costObject_PromptBox.setDisplayFormat("$number$");
        kdtPigletBatchEntry_costObject_PromptBox.setEditFormat("$number$");
        kdtPigletBatchEntry_costObject_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtPigletBatchEntry_costObject_CellEditor = new KDTDefaultCellEditor(kdtPigletBatchEntry_costObject_PromptBox);
        this.kdtPigletBatchEntry.getColumn("costObject").setEditor(kdtPigletBatchEntry_costObject_CellEditor);
        ObjectValueRender kdtPigletBatchEntry_costObject_OVR = new ObjectValueRender();
        kdtPigletBatchEntry_costObject_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtPigletBatchEntry.getColumn("costObject").setRenderer(kdtPigletBatchEntry_costObject_OVR);
        KDFormattedTextField kdtPigletBatchEntry_qty_TextField = new KDFormattedTextField();
        kdtPigletBatchEntry_qty_TextField.setName("kdtPigletBatchEntry_qty_TextField");
        kdtPigletBatchEntry_qty_TextField.setVisible(true);
        kdtPigletBatchEntry_qty_TextField.setEditable(true);
        kdtPigletBatchEntry_qty_TextField.setHorizontalAlignment(2);
        kdtPigletBatchEntry_qty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtPigletBatchEntry_qty_CellEditor = new KDTDefaultCellEditor(kdtPigletBatchEntry_qty_TextField);
        this.kdtPigletBatchEntry.getColumn("qty").setEditor(kdtPigletBatchEntry_qty_CellEditor);
        // kdtPbEarNumbers
		String kdtPbEarNumbersStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"pigNumber\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{pigNumber}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtPbEarNumbers.setFormatXml(resHelper.translateString("kdtPbEarNumbers",kdtPbEarNumbersStrXML));

                this.kdtPbEarNumbers.putBindContents("editData",new String[] {"PbEarNumbers.seq","PbEarNumbers.pigNumber"});


        this.kdtPbEarNumbers.checkParsed();
        KDFormattedTextField kdtPbEarNumbers_seq_TextField = new KDFormattedTextField();
        kdtPbEarNumbers_seq_TextField.setName("kdtPbEarNumbers_seq_TextField");
        kdtPbEarNumbers_seq_TextField.setVisible(true);
        kdtPbEarNumbers_seq_TextField.setEditable(true);
        kdtPbEarNumbers_seq_TextField.setHorizontalAlignment(2);
        kdtPbEarNumbers_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtPbEarNumbers_seq_CellEditor = new KDTDefaultCellEditor(kdtPbEarNumbers_seq_TextField);
        this.kdtPbEarNumbers.getColumn("seq").setEditor(kdtPbEarNumbers_seq_CellEditor);
        KDTextField kdtPbEarNumbers_pigNumber_TextField = new KDTextField();
        kdtPbEarNumbers_pigNumber_TextField.setName("kdtPbEarNumbers_pigNumber_TextField");
        kdtPbEarNumbers_pigNumber_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtPbEarNumbers_pigNumber_CellEditor = new KDTDefaultCellEditor(kdtPbEarNumbers_pigNumber_TextField);
        this.kdtPbEarNumbers.getColumn("pigNumber").setEditor(kdtPbEarNumbers_pigNumber_CellEditor);
        // btnBatchAddPigNumber		
        this.btnBatchAddPigNumber.setText(resHelper.getString("btnBatchAddPigNumber.text"));
        this.btnBatchAddPigNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnBatchAddPigNumber_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(false);		
        this.baseStatus.setEnabled(false);
        // txtdays		
        this.txtdays.setHorizontalAlignment(2);		
        this.txtdays.setDataType(0);		
        this.txtdays.setSupportedEmpty(true);		
        this.txtdays.setRequired(false);
        // txtinitAllQty		
        this.txtinitAllQty.setHorizontalAlignment(2);		
        this.txtinitAllQty.setDataType(0);		
        this.txtinitAllQty.setSupportedEmpty(true);		
        this.txtinitAllQty.setRequired(false);
        // prmtpigFarm		
        this.prmtpigFarm.setQueryInfo("com.kingdee.eas.farm.pig.app.PigFarmQuery");		
        this.prmtpigFarm.setEditable(true);		
        this.prmtpigFarm.setDisplayFormat("$name$");		
        this.prmtpigFarm.setEditFormat("$number$");		
        this.prmtpigFarm.setCommitFormat("$number$");		
        this.prmtpigFarm.setRequired(false);
        		prmtpigFarm.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.pig.client.PigFarmListUI prmtpigFarm_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtpigFarm_F7ListUI == null) {
					try {
						prmtpigFarm_F7ListUI = new com.kingdee.eas.farm.pig.client.PigFarmListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtpigFarm_F7ListUI));
					prmtpigFarm_F7ListUI.setF7Use(true,ctx);
					prmtpigFarm.setSelector(prmtpigFarm_F7ListUI);
				}
			}
		});
					
        // txtaveWeight		
        this.txtaveWeight.setHorizontalAlignment(2);		
        this.txtaveWeight.setDataType(1);		
        this.txtaveWeight.setSupportedEmpty(true);		
        this.txtaveWeight.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtaveWeight.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtaveWeight.setPrecision(2);		
        this.txtaveWeight.setRequired(false);
        // prmtpigLevel		
        this.prmtpigLevel.setQueryInfo("com.kingdee.eas.farm.pig.app.PigLevelQuery");		
        this.prmtpigLevel.setVisible(true);		
        this.prmtpigLevel.setEditable(true);		
        this.prmtpigLevel.setDisplayFormat("$name$");		
        this.prmtpigLevel.setEditFormat("$number$");		
        this.prmtpigLevel.setCommitFormat("$number$");		
        this.prmtpigLevel.setRequired(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        // btnUpdateMarket
        this.btnUpdateMarket.setAction((IItemAction)ActionProxyFactory.getProxy(actionUpdateBatchMarket, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUpdateMarket.setText(resHelper.getString("btnUpdateMarket.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {kdtPbEarNumbers,prmtcostObject,pkauditTime,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,baseStatus,txtdays,txtinitAllQty,prmtpigFarm,txtaveWeight,kdtEntrys,kdtPigletBatchEntry,prmtpigLevel}));
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
        contCreator.setBounds(new Rectangle(14, 572, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(14, 572, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(15, 598, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(15, 598, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(370, 572, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(370, 572, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(370, 598, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(370, 598, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contNumber.setBounds(new Rectangle(28, 17, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(28, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(28, 41, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(28, 41, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(724, 65, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(724, 65, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(725, 572, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(725, 572, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcostObject.setBounds(new Rectangle(724, 17, 270, 19));
        this.add(contcostObject, new KDLayout.Constraints(724, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contauditTime.setBounds(new Rectangle(725, 598, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(725, 598, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDTabbedPane1.setBounds(new Rectangle(20, 128, 975, 431));
        this.add(kDTabbedPane1, new KDLayout.Constraints(20, 128, 975, 431, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contbaseStatus.setBounds(new Rectangle(724, 41, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(724, 41, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contdays.setBounds(new Rectangle(376, 41, 270, 19));
        this.add(contdays, new KDLayout.Constraints(376, 41, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        continitAllQty.setBounds(new Rectangle(28, 65, 270, 19));
        this.add(continitAllQty, new KDLayout.Constraints(28, 65, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpigFarm.setBounds(new Rectangle(376, 17, 270, 19));
        this.add(contpigFarm, new KDLayout.Constraints(376, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contaveWeight.setBounds(new Rectangle(377, 65, 270, 19));
        this.add(contaveWeight, new KDLayout.Constraints(377, 65, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpigLevel.setBounds(new Rectangle(28, 90, 270, 19));
        this.add(contpigLevel, new KDLayout.Constraints(28, 90, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contcostObject
        contcostObject.setBoundEditor(prmtcostObject);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 974, 398));        kdtEntrys.setBounds(new Rectangle(0, 1, 968, 378));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.pig.ccpig.CCPigBatchEntryInfo(),null,false);
        kDPanel1.add(kdtEntrys_detailPanel, new KDLayout.Constraints(0, 1, 968, 378, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 974, 398));        kdtPigletBatchEntry.setBounds(new Rectangle(2, 3, 567, 422));
        kdtPigletBatchEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtPigletBatchEntry,new com.kingdee.eas.farm.pig.ccpig.CCPigBatchPigletBatchEntryInfo(),null,false);
        kDPanel2.add(kdtPigletBatchEntry_detailPanel, new KDLayout.Constraints(2, 3, 567, 422, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtPbEarNumbers.setBounds(new Rectangle(595, 31, 371, 392));
        kdtPbEarNumbers_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtPbEarNumbers,new com.kingdee.eas.farm.pig.ccpig.CCPigBatchPigletBatchEntryPbEarNumberInfo(),null,false);
        kDPanel2.add(kdtPbEarNumbers_detailPanel, new KDLayout.Constraints(595, 31, 371, 392, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        btnBatchAddPigNumber.setBounds(new Rectangle(595, 4, 144, 23));
        kDPanel2.add(btnBatchAddPigNumber, new KDLayout.Constraints(595, 4, 144, 23, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE));
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //contdays
        contdays.setBoundEditor(txtdays);
        //continitAllQty
        continitAllQty.setBoundEditor(txtinitAllQty);
        //contpigFarm
        contpigFarm.setBoundEditor(prmtpigFarm);
        //contaveWeight
        contaveWeight.setBoundEditor(txtaveWeight);
        //contpigLevel
        contpigLevel.setBoundEditor(prmtpigLevel);

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
        menuEdit.add(btnUpdateMarket);
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
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(btnNextPerson);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("costObject", com.kingdee.eas.basedata.assistant.CostObjectInfo.class, this.prmtcostObject, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.pig.ccpig.CCPigBatchEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.initQty", int.class, this.kdtEntrys, "initQty.text");
		dataBinder.registerBinding("entrys.incoopDate", java.util.Date.class, this.kdtEntrys, "incoopDate.text");
		dataBinder.registerBinding("entrys.isMarket", boolean.class, this.kdtEntrys, "isMarket.text");
		dataBinder.registerBinding("entrys.marketDate", java.util.Date.class, this.kdtEntrys, "marketDate.text");
		dataBinder.registerBinding("entrys.marketQty", int.class, this.kdtEntrys, "marketQty.text");
		dataBinder.registerBinding("entrys.remark", String.class, this.kdtEntrys, "remark.text");
		dataBinder.registerBinding("entrys.pigHouse", java.lang.Object.class, this.kdtEntrys, "pigHouse.text");
		dataBinder.registerBinding("PigletBatchEntry.seq", int.class, this.kdtPigletBatchEntry, "seq.text");
		dataBinder.registerBinding("PigletBatchEntry", com.kingdee.eas.farm.pig.ccpig.CCPigBatchPigletBatchEntryInfo.class, this.kdtPigletBatchEntry, "userObject");
		dataBinder.registerBinding("PigletBatchEntry.company", java.lang.Object.class, this.kdtPigletBatchEntry, "company.text");
		dataBinder.registerBinding("PigletBatchEntry.costObject", java.lang.Object.class, this.kdtPigletBatchEntry, "costObject.text");
		dataBinder.registerBinding("PigletBatchEntry.qty", int.class, this.kdtPigletBatchEntry, "qty.text");
		dataBinder.registerBinding("PigletBatchEntry.PbEarNumbers.seq", int.class, this.kdtPbEarNumbers, "seq.text");
		dataBinder.registerBinding("PigletBatchEntry.PbEarNumbers", com.kingdee.eas.farm.pig.ccpig.CCPigBatchPigletBatchEntryPbEarNumberInfo.class, this.kdtPbEarNumbers, "userObject");
		dataBinder.registerBinding("PigletBatchEntry.PbEarNumbers.pigNumber", String.class, this.kdtPbEarNumbers, "pigNumber.text");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("days", int.class, this.txtdays, "value");
		dataBinder.registerBinding("initAllQty", int.class, this.txtinitAllQty, "value");
		dataBinder.registerBinding("pigFarm", com.kingdee.eas.farm.pig.PigFarmInfo.class, this.prmtpigFarm, "data");
		dataBinder.registerBinding("aveWeight", java.math.BigDecimal.class, this.txtaveWeight, "value");
		dataBinder.registerBinding("pigLevel", com.kingdee.eas.farm.pig.PigLevelInfo.class, this.prmtpigLevel, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.pig.ccpig.app.CCPigBatchEditUIHandler";
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
        this.kdtPbEarNumbers.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.pig.ccpig.CCPigBatchInfo)ov;
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
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("costObject", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.initQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.incoopDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isMarket", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.marketDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.marketQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.pigHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PigletBatchEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PigletBatchEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PigletBatchEntry.company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PigletBatchEntry.costObject", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PigletBatchEntry.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PigletBatchEntry.PbEarNumbers.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PigletBatchEntry.PbEarNumbers", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PigletBatchEntry.PbEarNumbers.pigNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("days", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("initAllQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("pigFarm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("aveWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("pigLevel", ValidateHelper.ON_SAVE);    		
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
     * output kdtPigletBatchEntry_editStopped method
     */
    protected void kdtPigletBatchEntry_editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnBatchAddPigNumber_actionPerformed method
     */
    protected void btnBatchAddPigNumber_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
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
			sic.add(new SelectorItemInfo("costObject.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("costObject.id"));
        	sic.add(new SelectorItemInfo("costObject.number"));
        	sic.add(new SelectorItemInfo("costObject.name"));
		}
        sic.add(new SelectorItemInfo("auditTime"));
    	sic.add(new SelectorItemInfo("entrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("entrys.initQty"));
    	sic.add(new SelectorItemInfo("entrys.incoopDate"));
    	sic.add(new SelectorItemInfo("entrys.isMarket"));
    	sic.add(new SelectorItemInfo("entrys.marketDate"));
    	sic.add(new SelectorItemInfo("entrys.marketQty"));
    	sic.add(new SelectorItemInfo("entrys.remark"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.pigHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.pigHouse.id"));
			sic.add(new SelectorItemInfo("entrys.pigHouse.name"));
        	sic.add(new SelectorItemInfo("entrys.pigHouse.number"));
		}
    	sic.add(new SelectorItemInfo("PigletBatchEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("PigletBatchEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("PigletBatchEntry.company.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("PigletBatchEntry.company.id"));
			sic.add(new SelectorItemInfo("PigletBatchEntry.company.name"));
        	sic.add(new SelectorItemInfo("PigletBatchEntry.company.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("PigletBatchEntry.costObject.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("PigletBatchEntry.costObject.id"));
			sic.add(new SelectorItemInfo("PigletBatchEntry.costObject.name"));
        	sic.add(new SelectorItemInfo("PigletBatchEntry.costObject.number"));
		}
    	sic.add(new SelectorItemInfo("PigletBatchEntry.qty"));
    	sic.add(new SelectorItemInfo("PigletBatchEntry.PbEarNumbers.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("PigletBatchEntry.PbEarNumbers.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("PigletBatchEntry.PbEarNumbers.id"));
		}
    	sic.add(new SelectorItemInfo("PigletBatchEntry.PbEarNumbers.pigNumber"));
        sic.add(new SelectorItemInfo("baseStatus"));
        sic.add(new SelectorItemInfo("days"));
        sic.add(new SelectorItemInfo("initAllQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("pigFarm.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("pigFarm.id"));
        	sic.add(new SelectorItemInfo("pigFarm.number"));
        	sic.add(new SelectorItemInfo("pigFarm.name"));
		}
        sic.add(new SelectorItemInfo("aveWeight"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("pigLevel.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("pigLevel.id"));
        	sic.add(new SelectorItemInfo("pigLevel.number"));
        	sic.add(new SelectorItemInfo("pigLevel.name"));
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
        com.kingdee.eas.farm.pig.ccpig.CCPigBatchFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.pig.ccpig.CCPigBatchFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionUpdateBatchMarket_actionPerformed method
     */
    public void actionUpdateBatchMarket_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.pig.ccpig.CCPigBatchFactory.getRemoteInstance().updateBatchMarket(editData);
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
	public RequestContext prepareActionUpdateBatchMarket(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionUpdateBatchMarket() {
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
            innerActionPerformed("eas", AbstractCCPigBatchEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractCCPigBatchEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionUpdateBatchMarket class
     */     
    protected class ActionUpdateBatchMarket extends ItemAction {     
    
        public ActionUpdateBatchMarket()
        {
            this(null);
        }

        public ActionUpdateBatchMarket(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionUpdateBatchMarket.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUpdateBatchMarket.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUpdateBatchMarket.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCCPigBatchEditUI.this, "ActionUpdateBatchMarket", "actionUpdateBatchMarket_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.pig.ccpig.client", "CCPigBatchEditUI");
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
        return com.kingdee.eas.farm.pig.ccpig.client.CCPigBatchEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.pig.ccpig.CCPigBatchFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.pig.ccpig.CCPigBatchInfo objectValue = new com.kingdee.eas.farm.pig.ccpig.CCPigBatchInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/pig/ccpig/CCPigBatch";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.pig.ccpig.app.CCPigBatchQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcostObject.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"批次（成本对象）"});
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
		vo.put("baseStatus",new Integer(-1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}        
				protected void setTableToSumField() {
			setTableToSumField(kdtEntrys,new String[] {"initQty","marketQty"});
		}


}