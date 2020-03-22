/**
 * output package name
 */
package com.kingdee.eas.farm.breed.client;

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
public abstract class AbstractParentBreedBatchEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractParentBreedBatchEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedPlan;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbabyCostObject;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyoungCostObject;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteggCostObject;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyoungDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contadultDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedArea;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedModel;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisMoultingBatch;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweek;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweekDay;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisToBreed;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisToLayegg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthenhouseType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contVarietie;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtFieldDetailEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtFieldDetailEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel1;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtTransEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtTransEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbreedPlan;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarm;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbabyCostObject;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtyoungCostObject;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmteggCostObject;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkyoungDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkadultDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperson;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbreedArea;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbreedModel;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtweek;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtweekDay;
    protected com.kingdee.bos.ctrl.swing.KDComboBox henhouseType;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtVarietie;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem btnUpdateMarket;
    protected com.kingdee.eas.farm.breed.ParentBreedBatchInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionUpdateBatchMarket actionUpdateBatchMarket = null;
    /**
     * output class constructor
     */
    public AbstractParentBreedBatchEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractParentBreedBatchEditUI.class.getName());
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
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbreedPlan = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbabyCostObject = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyoungCostObject = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteggCostObject = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyoungDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contadultDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbreedArea = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbreedModel = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisMoultingBatch = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contweek = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweekDay = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisToBreed = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisToLayegg = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.conthenhouseType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contVarietie = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtFieldDetailEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDLabel1 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kdtTransEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtbreedPlan = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtfarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbabyCostObject = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtyoungCostObject = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmteggCostObject = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkyoungDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkadultDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtperson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbreedArea = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbreedModel = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtweek = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtweekDay = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.henhouseType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtVarietie = new com.kingdee.bos.ctrl.swing.KDTextField();
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
        this.contauditTime.setName("contauditTime");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contbaseStatus.setName("contbaseStatus");
        this.contbreedPlan.setName("contbreedPlan");
        this.contfarm.setName("contfarm");
        this.contbabyCostObject.setName("contbabyCostObject");
        this.contyoungCostObject.setName("contyoungCostObject");
        this.conteggCostObject.setName("conteggCostObject");
        this.contyoungDate.setName("contyoungDate");
        this.contadultDate.setName("contadultDate");
        this.contperson.setName("contperson");
        this.contbreedArea.setName("contbreedArea");
        this.contbreedModel.setName("contbreedModel");
        this.chkisMoultingBatch.setName("chkisMoultingBatch");
        this.contweek.setName("contweek");
        this.contweekDay.setName("contweekDay");
        this.chkisToBreed.setName("chkisToBreed");
        this.chkisToLayegg.setName("chkisToLayegg");
        this.conthenhouseType.setName("conthenhouseType");
        this.contVarietie.setName("contVarietie");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.pkauditTime.setName("pkauditTime");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kdtEntrys.setName("kdtEntrys");
        this.kdtFieldDetailEntrys.setName("kdtFieldDetailEntrys");
        this.kDLabel1.setName("kDLabel1");
        this.kdtTransEntrys.setName("kdtTransEntrys");
        this.baseStatus.setName("baseStatus");
        this.prmtbreedPlan.setName("prmtbreedPlan");
        this.prmtfarm.setName("prmtfarm");
        this.prmtbabyCostObject.setName("prmtbabyCostObject");
        this.prmtyoungCostObject.setName("prmtyoungCostObject");
        this.prmteggCostObject.setName("prmteggCostObject");
        this.pkyoungDate.setName("pkyoungDate");
        this.pkadultDate.setName("pkadultDate");
        this.prmtperson.setName("prmtperson");
        this.prmtbreedArea.setName("prmtbreedArea");
        this.prmtbreedModel.setName("prmtbreedModel");
        this.txtweek.setName("txtweek");
        this.txtweekDay.setName("txtweekDay");
        this.henhouseType.setName("henhouseType");
        this.txtVarietie.setName("txtVarietie");
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
        // contbreedPlan		
        this.contbreedPlan.setBoundLabelText(resHelper.getString("contbreedPlan.boundLabelText"));		
        this.contbreedPlan.setBoundLabelLength(100);		
        this.contbreedPlan.setBoundLabelUnderline(true);		
        this.contbreedPlan.setVisible(true);
        // contfarm		
        this.contfarm.setBoundLabelText(resHelper.getString("contfarm.boundLabelText"));		
        this.contfarm.setBoundLabelLength(100);		
        this.contfarm.setBoundLabelUnderline(true);		
        this.contfarm.setVisible(true);
        // contbabyCostObject		
        this.contbabyCostObject.setBoundLabelText(resHelper.getString("contbabyCostObject.boundLabelText"));		
        this.contbabyCostObject.setBoundLabelLength(100);		
        this.contbabyCostObject.setBoundLabelUnderline(true);		
        this.contbabyCostObject.setVisible(true);
        // contyoungCostObject		
        this.contyoungCostObject.setBoundLabelText(resHelper.getString("contyoungCostObject.boundLabelText"));		
        this.contyoungCostObject.setBoundLabelLength(100);		
        this.contyoungCostObject.setBoundLabelUnderline(true);		
        this.contyoungCostObject.setVisible(true);
        // conteggCostObject		
        this.conteggCostObject.setBoundLabelText(resHelper.getString("conteggCostObject.boundLabelText"));		
        this.conteggCostObject.setBoundLabelLength(100);		
        this.conteggCostObject.setBoundLabelUnderline(true);		
        this.conteggCostObject.setVisible(true);
        // contyoungDate		
        this.contyoungDate.setBoundLabelText(resHelper.getString("contyoungDate.boundLabelText"));		
        this.contyoungDate.setBoundLabelLength(100);		
        this.contyoungDate.setBoundLabelUnderline(true);		
        this.contyoungDate.setVisible(true);
        // contadultDate		
        this.contadultDate.setBoundLabelText(resHelper.getString("contadultDate.boundLabelText"));		
        this.contadultDate.setBoundLabelLength(100);		
        this.contadultDate.setBoundLabelUnderline(true);		
        this.contadultDate.setVisible(true);
        // contperson		
        this.contperson.setBoundLabelText(resHelper.getString("contperson.boundLabelText"));		
        this.contperson.setBoundLabelLength(100);		
        this.contperson.setBoundLabelUnderline(true);		
        this.contperson.setVisible(true);
        // contbreedArea		
        this.contbreedArea.setBoundLabelText(resHelper.getString("contbreedArea.boundLabelText"));		
        this.contbreedArea.setBoundLabelLength(100);		
        this.contbreedArea.setBoundLabelUnderline(true);		
        this.contbreedArea.setVisible(true);
        // contbreedModel		
        this.contbreedModel.setBoundLabelText(resHelper.getString("contbreedModel.boundLabelText"));		
        this.contbreedModel.setBoundLabelLength(100);		
        this.contbreedModel.setBoundLabelUnderline(true);		
        this.contbreedModel.setVisible(true);
        // chkisMoultingBatch		
        this.chkisMoultingBatch.setText(resHelper.getString("chkisMoultingBatch.text"));		
        this.chkisMoultingBatch.setHorizontalAlignment(2);
        // contweek		
        this.contweek.setBoundLabelText(resHelper.getString("contweek.boundLabelText"));		
        this.contweek.setBoundLabelLength(100);		
        this.contweek.setBoundLabelUnderline(true);		
        this.contweek.setVisible(true);
        // contweekDay		
        this.contweekDay.setBoundLabelText(resHelper.getString("contweekDay.boundLabelText"));		
        this.contweekDay.setBoundLabelLength(40);		
        this.contweekDay.setBoundLabelUnderline(true);		
        this.contweekDay.setVisible(true);
        // chkisToBreed		
        this.chkisToBreed.setText(resHelper.getString("chkisToBreed.text"));		
        this.chkisToBreed.setHorizontalAlignment(2);		
        this.chkisToBreed.setEnabled(false);
        // chkisToLayegg		
        this.chkisToLayegg.setText(resHelper.getString("chkisToLayegg.text"));		
        this.chkisToLayegg.setHorizontalAlignment(2);		
        this.chkisToLayegg.setEnabled(false);
        // conthenhouseType		
        this.conthenhouseType.setBoundLabelText(resHelper.getString("conthenhouseType.boundLabelText"));		
        this.conthenhouseType.setBoundLabelLength(100);		
        this.conthenhouseType.setBoundLabelUnderline(true);		
        this.conthenhouseType.setVisible(true);
        // contVarietie		
        this.contVarietie.setBoundLabelText(resHelper.getString("contVarietie.boundLabelText"));		
        this.contVarietie.setBoundLabelLength(100);		
        this.contVarietie.setBoundLabelUnderline(true);		
        this.contVarietie.setVisible(true);
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
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // kDPanel1
        this.kDPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                try {
                    kDPanel1_mouseClicked(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });
        // kDPanel2
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"henhouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"henhouseName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"incoopDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"stockingDensity\" t:width=\"120\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"henInitQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"cockInitQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{henhouse}</t:Cell><t:Cell>$Resource{henhouseName}</t:Cell><t:Cell>$Resource{incoopDate}</t:Cell><t:Cell>$Resource{stockingDensity}</t:Cell><t:Cell>$Resource{henInitQty}</t:Cell><t:Cell>$Resource{cockInitQty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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

        this.kdtEntrys.addKDTSelectListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTSelectListener() {
            public void tableSelectChanged(com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent e) {
                try {
                    kdtEntrys_tableSelectChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        this.kdtEntrys.addKDTMouseListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTMouseListener() {
            public void tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) {
                try {
                    kdtEntrys_tableClicked(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        this.kdtEntrys.addKDTActiveCellListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTActiveCellListener() {
            public void activeCellChanged(com.kingdee.bos.ctrl.kdf.table.event.KDTActiveCellEvent e) {
                try {
                    kdtEntrys_activeCellChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });

                this.kdtEntrys.putBindContents("editData",new String[] {"id","henhouse","henhouseName","incoopDate","stockingDensity","henInitQty","cockInitQty"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_henhouse_PromptBox = new KDBizPromptBox();
        kdtEntrys_henhouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseF7Query");
        kdtEntrys_henhouse_PromptBox.setVisible(true);
        kdtEntrys_henhouse_PromptBox.setEditable(true);
        kdtEntrys_henhouse_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_henhouse_PromptBox.setEditFormat("$number$");
        kdtEntrys_henhouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_henhouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henhouse_PromptBox);
        this.kdtEntrys.getColumn("henhouse").setEditor(kdtEntrys_henhouse_CellEditor);
        ObjectValueRender kdtEntrys_henhouse_OVR = new ObjectValueRender();
        kdtEntrys_henhouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("henhouse").setRenderer(kdtEntrys_henhouse_OVR);
        KDTextField kdtEntrys_henhouseName_TextField = new KDTextField();
        kdtEntrys_henhouseName_TextField.setName("kdtEntrys_henhouseName_TextField");
        kdtEntrys_henhouseName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_henhouseName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henhouseName_TextField);
        this.kdtEntrys.getColumn("henhouseName").setEditor(kdtEntrys_henhouseName_CellEditor);
        KDDatePicker kdtEntrys_incoopDate_DatePicker = new KDDatePicker();
        kdtEntrys_incoopDate_DatePicker.setName("kdtEntrys_incoopDate_DatePicker");
        kdtEntrys_incoopDate_DatePicker.setVisible(true);
        kdtEntrys_incoopDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_incoopDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_incoopDate_DatePicker);
        this.kdtEntrys.getColumn("incoopDate").setEditor(kdtEntrys_incoopDate_CellEditor);
        KDFormattedTextField kdtEntrys_stockingDensity_TextField = new KDFormattedTextField();
        kdtEntrys_stockingDensity_TextField.setName("kdtEntrys_stockingDensity_TextField");
        kdtEntrys_stockingDensity_TextField.setVisible(true);
        kdtEntrys_stockingDensity_TextField.setEditable(true);
        kdtEntrys_stockingDensity_TextField.setHorizontalAlignment(2);
        kdtEntrys_stockingDensity_TextField.setDataType(1);
        	kdtEntrys_stockingDensity_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_stockingDensity_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_stockingDensity_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_stockingDensity_CellEditor = new KDTDefaultCellEditor(kdtEntrys_stockingDensity_TextField);
        this.kdtEntrys.getColumn("stockingDensity").setEditor(kdtEntrys_stockingDensity_CellEditor);
        KDFormattedTextField kdtEntrys_henInitQty_TextField = new KDFormattedTextField();
        kdtEntrys_henInitQty_TextField.setName("kdtEntrys_henInitQty_TextField");
        kdtEntrys_henInitQty_TextField.setVisible(true);
        kdtEntrys_henInitQty_TextField.setEditable(true);
        kdtEntrys_henInitQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_henInitQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_henInitQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henInitQty_TextField);
        this.kdtEntrys.getColumn("henInitQty").setEditor(kdtEntrys_henInitQty_CellEditor);
        KDFormattedTextField kdtEntrys_cockInitQty_TextField = new KDFormattedTextField();
        kdtEntrys_cockInitQty_TextField.setName("kdtEntrys_cockInitQty_TextField");
        kdtEntrys_cockInitQty_TextField.setVisible(true);
        kdtEntrys_cockInitQty_TextField.setEditable(true);
        kdtEntrys_cockInitQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_cockInitQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_cockInitQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_cockInitQty_TextField);
        this.kdtEntrys.getColumn("cockInitQty").setEditor(kdtEntrys_cockInitQty_CellEditor);
        // kdtFieldDetailEntrys
		String kdtFieldDetailEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"0\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"housefield\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"henInitQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"cockInitQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{housefield}</t:Cell><t:Cell>$Resource{henInitQty}</t:Cell><t:Cell>$Resource{cockInitQty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtFieldDetailEntrys.setFormatXml(resHelper.translateString("kdtFieldDetailEntrys",kdtFieldDetailEntrysStrXML));		
        this.kdtFieldDetailEntrys.setVisible(false);

                this.kdtFieldDetailEntrys.putBindContents("editData",new String[] {"FieldDetailEntrys.seq","FieldDetailEntrys.housefield","FieldDetailEntrys.henInitQty","FieldDetailEntrys.cockInitQty"});


        this.kdtFieldDetailEntrys.checkParsed();
        KDFormattedTextField kdtFieldDetailEntrys_seq_TextField = new KDFormattedTextField();
        kdtFieldDetailEntrys_seq_TextField.setName("kdtFieldDetailEntrys_seq_TextField");
        kdtFieldDetailEntrys_seq_TextField.setVisible(true);
        kdtFieldDetailEntrys_seq_TextField.setEditable(true);
        kdtFieldDetailEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtFieldDetailEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtFieldDetailEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtFieldDetailEntrys_seq_TextField);
        this.kdtFieldDetailEntrys.getColumn("seq").setEditor(kdtFieldDetailEntrys_seq_CellEditor);
        final KDBizPromptBox kdtFieldDetailEntrys_housefield_PromptBox = new KDBizPromptBox();
        kdtFieldDetailEntrys_housefield_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HouseFieldQuery");
        kdtFieldDetailEntrys_housefield_PromptBox.setVisible(true);
        kdtFieldDetailEntrys_housefield_PromptBox.setEditable(true);
        kdtFieldDetailEntrys_housefield_PromptBox.setDisplayFormat("$number$");
        kdtFieldDetailEntrys_housefield_PromptBox.setEditFormat("$number$");
        kdtFieldDetailEntrys_housefield_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtFieldDetailEntrys_housefield_CellEditor = new KDTDefaultCellEditor(kdtFieldDetailEntrys_housefield_PromptBox);
        this.kdtFieldDetailEntrys.getColumn("housefield").setEditor(kdtFieldDetailEntrys_housefield_CellEditor);
        ObjectValueRender kdtFieldDetailEntrys_housefield_OVR = new ObjectValueRender();
        kdtFieldDetailEntrys_housefield_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtFieldDetailEntrys.getColumn("housefield").setRenderer(kdtFieldDetailEntrys_housefield_OVR);
        KDFormattedTextField kdtFieldDetailEntrys_henInitQty_TextField = new KDFormattedTextField();
        kdtFieldDetailEntrys_henInitQty_TextField.setName("kdtFieldDetailEntrys_henInitQty_TextField");
        kdtFieldDetailEntrys_henInitQty_TextField.setVisible(true);
        kdtFieldDetailEntrys_henInitQty_TextField.setEditable(true);
        kdtFieldDetailEntrys_henInitQty_TextField.setHorizontalAlignment(2);
        kdtFieldDetailEntrys_henInitQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtFieldDetailEntrys_henInitQty_CellEditor = new KDTDefaultCellEditor(kdtFieldDetailEntrys_henInitQty_TextField);
        this.kdtFieldDetailEntrys.getColumn("henInitQty").setEditor(kdtFieldDetailEntrys_henInitQty_CellEditor);
        KDFormattedTextField kdtFieldDetailEntrys_cockInitQty_TextField = new KDFormattedTextField();
        kdtFieldDetailEntrys_cockInitQty_TextField.setName("kdtFieldDetailEntrys_cockInitQty_TextField");
        kdtFieldDetailEntrys_cockInitQty_TextField.setVisible(true);
        kdtFieldDetailEntrys_cockInitQty_TextField.setEditable(true);
        kdtFieldDetailEntrys_cockInitQty_TextField.setHorizontalAlignment(2);
        kdtFieldDetailEntrys_cockInitQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtFieldDetailEntrys_cockInitQty_CellEditor = new KDTDefaultCellEditor(kdtFieldDetailEntrys_cockInitQty_TextField);
        this.kdtFieldDetailEntrys.getColumn("cockInitQty").setEditor(kdtFieldDetailEntrys_cockInitQty_CellEditor);
        // kDLabel1		
        this.kDLabel1.setText(resHelper.getString("kDLabel1.text"));		
        this.kDLabel1.setFont(resHelper.getFont("kDLabel1.font"));		
        this.kDLabel1.setBackground(new java.awt.Color(192,192,192));		
        this.kDLabel1.setVisible(false);
        // kdtTransEntrys
		String kdtTransEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol16\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol17\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol18\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"isTransOut\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"isBuy\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"supplier\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"isFromOtherBatch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"fromBatch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"fromHenhouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"outHousefield\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"toBatch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"toHenhouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"inHousefield\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"transHenQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"transCockQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"henAsFixedQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"cockAsFixedQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"asTransEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"transDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /><t:Column t:key=\"transWeeks\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"transWeekDays\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{isTransOut}</t:Cell><t:Cell>$Resource{isBuy}</t:Cell><t:Cell>$Resource{supplier}</t:Cell><t:Cell>$Resource{isFromOtherBatch}</t:Cell><t:Cell>$Resource{fromBatch}</t:Cell><t:Cell>$Resource{fromHenhouse}</t:Cell><t:Cell>$Resource{outHousefield}</t:Cell><t:Cell>$Resource{toBatch}</t:Cell><t:Cell>$Resource{toHenhouse}</t:Cell><t:Cell>$Resource{inHousefield}</t:Cell><t:Cell>$Resource{transHenQty}</t:Cell><t:Cell>$Resource{transCockQty}</t:Cell><t:Cell>$Resource{henAsFixedQty}</t:Cell><t:Cell>$Resource{cockAsFixedQty}</t:Cell><t:Cell>$Resource{asTransEggQty}</t:Cell><t:Cell>$Resource{transDate}</t:Cell><t:Cell>$Resource{transWeeks}</t:Cell><t:Cell>$Resource{transWeekDays}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtTransEntrys.setFormatXml(resHelper.translateString("kdtTransEntrys",kdtTransEntrysStrXML));

                this.kdtTransEntrys.putBindContents("editData",new String[] {"seq","isTransOut","isBuy","supplier","isFromOtherBatch","fromBatch","fromHenhouse","outHousefield","toBatch","toHenhouse","inHousefield","transHenQty","transCockQty","henAsFixedQty","cockAsFixedQty","asTransEggQty","transDate","transWeeks","transWeekDays"});


        this.kdtTransEntrys.checkParsed();
        KDFormattedTextField kdtTransEntrys_seq_TextField = new KDFormattedTextField();
        kdtTransEntrys_seq_TextField.setName("kdtTransEntrys_seq_TextField");
        kdtTransEntrys_seq_TextField.setVisible(true);
        kdtTransEntrys_seq_TextField.setEditable(true);
        kdtTransEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtTransEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtTransEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtTransEntrys_seq_TextField);
        this.kdtTransEntrys.getColumn("seq").setEditor(kdtTransEntrys_seq_CellEditor);
        KDCheckBox kdtTransEntrys_isTransOut_CheckBox = new KDCheckBox();
        kdtTransEntrys_isTransOut_CheckBox.setName("kdtTransEntrys_isTransOut_CheckBox");
        KDTDefaultCellEditor kdtTransEntrys_isTransOut_CellEditor = new KDTDefaultCellEditor(kdtTransEntrys_isTransOut_CheckBox);
        this.kdtTransEntrys.getColumn("isTransOut").setEditor(kdtTransEntrys_isTransOut_CellEditor);
        KDCheckBox kdtTransEntrys_isBuy_CheckBox = new KDCheckBox();
        kdtTransEntrys_isBuy_CheckBox.setName("kdtTransEntrys_isBuy_CheckBox");
        KDTDefaultCellEditor kdtTransEntrys_isBuy_CellEditor = new KDTDefaultCellEditor(kdtTransEntrys_isBuy_CheckBox);
        this.kdtTransEntrys.getColumn("isBuy").setEditor(kdtTransEntrys_isBuy_CellEditor);
        final KDBizPromptBox kdtTransEntrys_supplier_PromptBox = new KDBizPromptBox();
        kdtTransEntrys_supplier_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.F7SupplierDefaultQuery");
        kdtTransEntrys_supplier_PromptBox.setVisible(true);
        kdtTransEntrys_supplier_PromptBox.setEditable(true);
        kdtTransEntrys_supplier_PromptBox.setDisplayFormat("$number$");
        kdtTransEntrys_supplier_PromptBox.setEditFormat("$number$");
        kdtTransEntrys_supplier_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtTransEntrys_supplier_CellEditor = new KDTDefaultCellEditor(kdtTransEntrys_supplier_PromptBox);
        this.kdtTransEntrys.getColumn("supplier").setEditor(kdtTransEntrys_supplier_CellEditor);
        ObjectValueRender kdtTransEntrys_supplier_OVR = new ObjectValueRender();
        kdtTransEntrys_supplier_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtTransEntrys.getColumn("supplier").setRenderer(kdtTransEntrys_supplier_OVR);
        KDCheckBox kdtTransEntrys_isFromOtherBatch_CheckBox = new KDCheckBox();
        kdtTransEntrys_isFromOtherBatch_CheckBox.setName("kdtTransEntrys_isFromOtherBatch_CheckBox");
        KDTDefaultCellEditor kdtTransEntrys_isFromOtherBatch_CellEditor = new KDTDefaultCellEditor(kdtTransEntrys_isFromOtherBatch_CheckBox);
        this.kdtTransEntrys.getColumn("isFromOtherBatch").setEditor(kdtTransEntrys_isFromOtherBatch_CellEditor);
        final KDBizPromptBox kdtTransEntrys_fromBatch_PromptBox = new KDBizPromptBox();
        kdtTransEntrys_fromBatch_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.ParentBreedBatchQuery");
        kdtTransEntrys_fromBatch_PromptBox.setVisible(true);
        kdtTransEntrys_fromBatch_PromptBox.setEditable(true);
        kdtTransEntrys_fromBatch_PromptBox.setDisplayFormat("$number$");
        kdtTransEntrys_fromBatch_PromptBox.setEditFormat("$number$");
        kdtTransEntrys_fromBatch_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtTransEntrys_fromBatch_CellEditor = new KDTDefaultCellEditor(kdtTransEntrys_fromBatch_PromptBox);
        this.kdtTransEntrys.getColumn("fromBatch").setEditor(kdtTransEntrys_fromBatch_CellEditor);
        ObjectValueRender kdtTransEntrys_fromBatch_OVR = new ObjectValueRender();
        kdtTransEntrys_fromBatch_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtTransEntrys.getColumn("fromBatch").setRenderer(kdtTransEntrys_fromBatch_OVR);
        final KDBizPromptBox kdtTransEntrys_fromHenhouse_PromptBox = new KDBizPromptBox();
        kdtTransEntrys_fromHenhouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseF7Query");
        kdtTransEntrys_fromHenhouse_PromptBox.setVisible(true);
        kdtTransEntrys_fromHenhouse_PromptBox.setEditable(true);
        kdtTransEntrys_fromHenhouse_PromptBox.setDisplayFormat("$number$");
        kdtTransEntrys_fromHenhouse_PromptBox.setEditFormat("$number$");
        kdtTransEntrys_fromHenhouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtTransEntrys_fromHenhouse_CellEditor = new KDTDefaultCellEditor(kdtTransEntrys_fromHenhouse_PromptBox);
        this.kdtTransEntrys.getColumn("fromHenhouse").setEditor(kdtTransEntrys_fromHenhouse_CellEditor);
        ObjectValueRender kdtTransEntrys_fromHenhouse_OVR = new ObjectValueRender();
        kdtTransEntrys_fromHenhouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtTransEntrys.getColumn("fromHenhouse").setRenderer(kdtTransEntrys_fromHenhouse_OVR);
        final KDBizPromptBox kdtTransEntrys_outHousefield_PromptBox = new KDBizPromptBox();
        kdtTransEntrys_outHousefield_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HouseFieldQuery");
        kdtTransEntrys_outHousefield_PromptBox.setVisible(true);
        kdtTransEntrys_outHousefield_PromptBox.setEditable(true);
        kdtTransEntrys_outHousefield_PromptBox.setDisplayFormat("$number$");
        kdtTransEntrys_outHousefield_PromptBox.setEditFormat("$number$");
        kdtTransEntrys_outHousefield_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtTransEntrys_outHousefield_CellEditor = new KDTDefaultCellEditor(kdtTransEntrys_outHousefield_PromptBox);
        this.kdtTransEntrys.getColumn("outHousefield").setEditor(kdtTransEntrys_outHousefield_CellEditor);
        ObjectValueRender kdtTransEntrys_outHousefield_OVR = new ObjectValueRender();
        kdtTransEntrys_outHousefield_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtTransEntrys.getColumn("outHousefield").setRenderer(kdtTransEntrys_outHousefield_OVR);
        final KDBizPromptBox kdtTransEntrys_toBatch_PromptBox = new KDBizPromptBox();
        kdtTransEntrys_toBatch_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.ParentBreedBatchQuery");
        kdtTransEntrys_toBatch_PromptBox.setVisible(true);
        kdtTransEntrys_toBatch_PromptBox.setEditable(true);
        kdtTransEntrys_toBatch_PromptBox.setDisplayFormat("$number$");
        kdtTransEntrys_toBatch_PromptBox.setEditFormat("$number$");
        kdtTransEntrys_toBatch_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtTransEntrys_toBatch_CellEditor = new KDTDefaultCellEditor(kdtTransEntrys_toBatch_PromptBox);
        this.kdtTransEntrys.getColumn("toBatch").setEditor(kdtTransEntrys_toBatch_CellEditor);
        ObjectValueRender kdtTransEntrys_toBatch_OVR = new ObjectValueRender();
        kdtTransEntrys_toBatch_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtTransEntrys.getColumn("toBatch").setRenderer(kdtTransEntrys_toBatch_OVR);
        final KDBizPromptBox kdtTransEntrys_toHenhouse_PromptBox = new KDBizPromptBox();
        kdtTransEntrys_toHenhouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseF7Query");
        kdtTransEntrys_toHenhouse_PromptBox.setVisible(true);
        kdtTransEntrys_toHenhouse_PromptBox.setEditable(true);
        kdtTransEntrys_toHenhouse_PromptBox.setDisplayFormat("$number$");
        kdtTransEntrys_toHenhouse_PromptBox.setEditFormat("$number$");
        kdtTransEntrys_toHenhouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtTransEntrys_toHenhouse_CellEditor = new KDTDefaultCellEditor(kdtTransEntrys_toHenhouse_PromptBox);
        this.kdtTransEntrys.getColumn("toHenhouse").setEditor(kdtTransEntrys_toHenhouse_CellEditor);
        ObjectValueRender kdtTransEntrys_toHenhouse_OVR = new ObjectValueRender();
        kdtTransEntrys_toHenhouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtTransEntrys.getColumn("toHenhouse").setRenderer(kdtTransEntrys_toHenhouse_OVR);
        final KDBizPromptBox kdtTransEntrys_inHousefield_PromptBox = new KDBizPromptBox();
        kdtTransEntrys_inHousefield_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HouseFieldQuery");
        kdtTransEntrys_inHousefield_PromptBox.setVisible(true);
        kdtTransEntrys_inHousefield_PromptBox.setEditable(true);
        kdtTransEntrys_inHousefield_PromptBox.setDisplayFormat("$number$");
        kdtTransEntrys_inHousefield_PromptBox.setEditFormat("$number$");
        kdtTransEntrys_inHousefield_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtTransEntrys_inHousefield_CellEditor = new KDTDefaultCellEditor(kdtTransEntrys_inHousefield_PromptBox);
        this.kdtTransEntrys.getColumn("inHousefield").setEditor(kdtTransEntrys_inHousefield_CellEditor);
        ObjectValueRender kdtTransEntrys_inHousefield_OVR = new ObjectValueRender();
        kdtTransEntrys_inHousefield_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtTransEntrys.getColumn("inHousefield").setRenderer(kdtTransEntrys_inHousefield_OVR);
        KDFormattedTextField kdtTransEntrys_transHenQty_TextField = new KDFormattedTextField();
        kdtTransEntrys_transHenQty_TextField.setName("kdtTransEntrys_transHenQty_TextField");
        kdtTransEntrys_transHenQty_TextField.setVisible(true);
        kdtTransEntrys_transHenQty_TextField.setEditable(true);
        kdtTransEntrys_transHenQty_TextField.setHorizontalAlignment(2);
        kdtTransEntrys_transHenQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtTransEntrys_transHenQty_CellEditor = new KDTDefaultCellEditor(kdtTransEntrys_transHenQty_TextField);
        this.kdtTransEntrys.getColumn("transHenQty").setEditor(kdtTransEntrys_transHenQty_CellEditor);
        KDFormattedTextField kdtTransEntrys_transCockQty_TextField = new KDFormattedTextField();
        kdtTransEntrys_transCockQty_TextField.setName("kdtTransEntrys_transCockQty_TextField");
        kdtTransEntrys_transCockQty_TextField.setVisible(true);
        kdtTransEntrys_transCockQty_TextField.setEditable(true);
        kdtTransEntrys_transCockQty_TextField.setHorizontalAlignment(2);
        kdtTransEntrys_transCockQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtTransEntrys_transCockQty_CellEditor = new KDTDefaultCellEditor(kdtTransEntrys_transCockQty_TextField);
        this.kdtTransEntrys.getColumn("transCockQty").setEditor(kdtTransEntrys_transCockQty_CellEditor);
        KDFormattedTextField kdtTransEntrys_henAsFixedQty_TextField = new KDFormattedTextField();
        kdtTransEntrys_henAsFixedQty_TextField.setName("kdtTransEntrys_henAsFixedQty_TextField");
        kdtTransEntrys_henAsFixedQty_TextField.setVisible(true);
        kdtTransEntrys_henAsFixedQty_TextField.setEditable(true);
        kdtTransEntrys_henAsFixedQty_TextField.setHorizontalAlignment(2);
        kdtTransEntrys_henAsFixedQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtTransEntrys_henAsFixedQty_CellEditor = new KDTDefaultCellEditor(kdtTransEntrys_henAsFixedQty_TextField);
        this.kdtTransEntrys.getColumn("henAsFixedQty").setEditor(kdtTransEntrys_henAsFixedQty_CellEditor);
        KDFormattedTextField kdtTransEntrys_cockAsFixedQty_TextField = new KDFormattedTextField();
        kdtTransEntrys_cockAsFixedQty_TextField.setName("kdtTransEntrys_cockAsFixedQty_TextField");
        kdtTransEntrys_cockAsFixedQty_TextField.setVisible(true);
        kdtTransEntrys_cockAsFixedQty_TextField.setEditable(true);
        kdtTransEntrys_cockAsFixedQty_TextField.setHorizontalAlignment(2);
        kdtTransEntrys_cockAsFixedQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtTransEntrys_cockAsFixedQty_CellEditor = new KDTDefaultCellEditor(kdtTransEntrys_cockAsFixedQty_TextField);
        this.kdtTransEntrys.getColumn("cockAsFixedQty").setEditor(kdtTransEntrys_cockAsFixedQty_CellEditor);
        KDFormattedTextField kdtTransEntrys_asTransEggQty_TextField = new KDFormattedTextField();
        kdtTransEntrys_asTransEggQty_TextField.setName("kdtTransEntrys_asTransEggQty_TextField");
        kdtTransEntrys_asTransEggQty_TextField.setVisible(true);
        kdtTransEntrys_asTransEggQty_TextField.setEditable(true);
        kdtTransEntrys_asTransEggQty_TextField.setHorizontalAlignment(2);
        kdtTransEntrys_asTransEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtTransEntrys_asTransEggQty_CellEditor = new KDTDefaultCellEditor(kdtTransEntrys_asTransEggQty_TextField);
        this.kdtTransEntrys.getColumn("asTransEggQty").setEditor(kdtTransEntrys_asTransEggQty_CellEditor);
        KDDatePicker kdtTransEntrys_transDate_DatePicker = new KDDatePicker();
        kdtTransEntrys_transDate_DatePicker.setName("kdtTransEntrys_transDate_DatePicker");
        kdtTransEntrys_transDate_DatePicker.setVisible(true);
        kdtTransEntrys_transDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtTransEntrys_transDate_CellEditor = new KDTDefaultCellEditor(kdtTransEntrys_transDate_DatePicker);
        this.kdtTransEntrys.getColumn("transDate").setEditor(kdtTransEntrys_transDate_CellEditor);
        KDFormattedTextField kdtTransEntrys_transWeeks_TextField = new KDFormattedTextField();
        kdtTransEntrys_transWeeks_TextField.setName("kdtTransEntrys_transWeeks_TextField");
        kdtTransEntrys_transWeeks_TextField.setVisible(true);
        kdtTransEntrys_transWeeks_TextField.setEditable(true);
        kdtTransEntrys_transWeeks_TextField.setHorizontalAlignment(2);
        kdtTransEntrys_transWeeks_TextField.setDataType(0);
        KDTDefaultCellEditor kdtTransEntrys_transWeeks_CellEditor = new KDTDefaultCellEditor(kdtTransEntrys_transWeeks_TextField);
        this.kdtTransEntrys.getColumn("transWeeks").setEditor(kdtTransEntrys_transWeeks_CellEditor);
        KDFormattedTextField kdtTransEntrys_transWeekDays_TextField = new KDFormattedTextField();
        kdtTransEntrys_transWeekDays_TextField.setName("kdtTransEntrys_transWeekDays_TextField");
        kdtTransEntrys_transWeekDays_TextField.setVisible(true);
        kdtTransEntrys_transWeekDays_TextField.setEditable(true);
        kdtTransEntrys_transWeekDays_TextField.setHorizontalAlignment(2);
        kdtTransEntrys_transWeekDays_TextField.setDataType(0);
        KDTDefaultCellEditor kdtTransEntrys_transWeekDays_CellEditor = new KDTDefaultCellEditor(kdtTransEntrys_transWeekDays_TextField);
        this.kdtTransEntrys.getColumn("transWeekDays").setEditor(kdtTransEntrys_transWeekDays_CellEditor);
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(false);		
        this.baseStatus.setEnabled(false);
        // prmtbreedPlan		
        this.prmtbreedPlan.setQueryInfo("com.kingdee.eas.farm.breed.business.app.CCBreedPlanQuery");		
        this.prmtbreedPlan.setEditable(true);		
        this.prmtbreedPlan.setDisplayFormat("$number$");		
        this.prmtbreedPlan.setEditFormat("$number$");		
        this.prmtbreedPlan.setCommitFormat("$number$");
        this.prmtbreedPlan.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtbreedPlan_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // prmtfarm		
        this.prmtfarm.setQueryInfo("com.kingdee.eas.farm.breed.app.BreedStoorgSetQuery");		
        this.prmtfarm.setEditable(true);		
        this.prmtfarm.setDisplayFormat("$name$");		
        this.prmtfarm.setEditFormat("$number$");		
        this.prmtfarm.setCommitFormat("$number$");		
        this.prmtfarm.setRequired(true);		
        this.prmtfarm.setEnabled(false);
        this.prmtfarm.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtfarm_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // prmtbabyCostObject		
        this.prmtbabyCostObject.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");		
        this.prmtbabyCostObject.setEditable(true);		
        this.prmtbabyCostObject.setDisplayFormat("$relatedName$");		
        this.prmtbabyCostObject.setEditFormat("$number$");		
        this.prmtbabyCostObject.setCommitFormat("$number$");		
        this.prmtbabyCostObject.setRequired(false);		
        this.prmtbabyCostObject.setEnabled(false);
        // prmtyoungCostObject		
        this.prmtyoungCostObject.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");		
        this.prmtyoungCostObject.setEditable(true);		
        this.prmtyoungCostObject.setDisplayFormat("$relatedName$");		
        this.prmtyoungCostObject.setEditFormat("$number$");		
        this.prmtyoungCostObject.setCommitFormat("$number$");		
        this.prmtyoungCostObject.setRequired(false);		
        this.prmtyoungCostObject.setEnabled(false);
        // prmteggCostObject		
        this.prmteggCostObject.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");		
        this.prmteggCostObject.setEditable(true);		
        this.prmteggCostObject.setDisplayFormat("$relatedName$");		
        this.prmteggCostObject.setEditFormat("$number$");		
        this.prmteggCostObject.setCommitFormat("$number$");		
        this.prmteggCostObject.setRequired(false);		
        this.prmteggCostObject.setEnabled(false);
        // pkyoungDate		
        this.pkyoungDate.setRequired(false);		
        this.pkyoungDate.setEnabled(false);
        // pkadultDate		
        this.pkadultDate.setRequired(false);		
        this.pkadultDate.setEnabled(false);
        // prmtperson		
        this.prmtperson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtperson.setEditable(true);		
        this.prmtperson.setDisplayFormat("$name$");		
        this.prmtperson.setEditFormat("$number$");		
        this.prmtperson.setCommitFormat("$number$");		
        this.prmtperson.setRequired(true);
        // prmtbreedArea		
        this.prmtbreedArea.setQueryInfo("com.kingdee.eas.farm.breed.app.BreedAreaQuery");		
        this.prmtbreedArea.setEditable(true);		
        this.prmtbreedArea.setDisplayFormat("$areaName$");		
        this.prmtbreedArea.setEditFormat("$number$");		
        this.prmtbreedArea.setCommitFormat("$number$");		
        this.prmtbreedArea.setRequired(true);
        this.prmtbreedArea.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtbreedArea_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // prmtbreedModel		
        this.prmtbreedModel.setQueryInfo("com.kingdee.eas.farm.breed.app.BreedModelQuery");		
        this.prmtbreedModel.setEditable(true);		
        this.prmtbreedModel.setDisplayFormat("$name$");		
        this.prmtbreedModel.setEditFormat("$number$");		
        this.prmtbreedModel.setCommitFormat("$number$");		
        this.prmtbreedModel.setRequired(true);
        		prmtbreedModel.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.breed.client.BreedModelListUI prmtbreedModel_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtbreedModel_F7ListUI == null) {
					try {
						prmtbreedModel_F7ListUI = new com.kingdee.eas.farm.breed.client.BreedModelListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtbreedModel_F7ListUI));
					prmtbreedModel_F7ListUI.setF7Use(true,ctx);
					prmtbreedModel.setSelector(prmtbreedModel_F7ListUI);
				}
			}
		});
					
        prmtbreedModel.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtbreedModel_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtweek		
        this.txtweek.setHorizontalAlignment(2);		
        this.txtweek.setDataType(0);		
        this.txtweek.setSupportedEmpty(true);		
        this.txtweek.setRequired(false);
        // txtweekDay		
        this.txtweekDay.setHorizontalAlignment(2);		
        this.txtweekDay.setDataType(0);		
        this.txtweekDay.setSupportedEmpty(true);		
        this.txtweekDay.setRequired(false);
        // henhouseType		
        this.henhouseType.setVisible(true);		
        this.henhouseType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.breed.HenhouseType").toArray());		
        this.henhouseType.setRequired(true);
        // txtVarietie		
        this.txtVarietie.setVisible(true);		
        this.txtVarietie.setHorizontalAlignment(2);		
        this.txtVarietie.setMaxLength(80);		
        this.txtVarietie.setRequired(false);		
        this.txtVarietie.setEnabled(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        // btnUpdateMarket
        this.btnUpdateMarket.setAction((IItemAction)ActionProxyFactory.getProxy(actionUpdateBatchMarket, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUpdateMarket.setText(resHelper.getString("btnUpdateMarket.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {kdtFieldDetailEntrys,pkauditTime,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,baseStatus,prmtbreedPlan,prmtfarm,prmtbabyCostObject,prmtyoungCostObject,prmteggCostObject,pkyoungDate,pkadultDate,prmtperson,prmtbreedArea,prmtbreedModel,chkisMoultingBatch,txtweek,txtweekDay,chkisToBreed,chkisToLayegg,kdtEntrys,kdtTransEntrys,henhouseType,txtVarietie}));
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
        contNumber.setBounds(new Rectangle(28, 15, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(28, 15, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(379, 105, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(379, 105, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(733, 128, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(733, 128, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(725, 572, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(725, 572, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contauditTime.setBounds(new Rectangle(725, 598, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(725, 598, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDTabbedPane1.setBounds(new Rectangle(20, 184, 975, 375));
        this.add(kDTabbedPane1, new KDLayout.Constraints(20, 184, 975, 375, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contbaseStatus.setBounds(new Rectangle(731, 81, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(731, 81, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbreedPlan.setBounds(new Rectangle(379, 81, 270, 19));
        this.add(contbreedPlan, new KDLayout.Constraints(379, 81, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarm.setBounds(new Rectangle(379, 15, 270, 19));
        this.add(contfarm, new KDLayout.Constraints(379, 15, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbabyCostObject.setBounds(new Rectangle(28, 37, 270, 19));
        this.add(contbabyCostObject, new KDLayout.Constraints(28, 37, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contyoungCostObject.setBounds(new Rectangle(379, 37, 270, 19));
        this.add(contyoungCostObject, new KDLayout.Constraints(379, 37, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conteggCostObject.setBounds(new Rectangle(731, 37, 270, 19));
        this.add(conteggCostObject, new KDLayout.Constraints(731, 37, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contyoungDate.setBounds(new Rectangle(379, 59, 270, 19));
        this.add(contyoungDate, new KDLayout.Constraints(379, 59, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contadultDate.setBounds(new Rectangle(731, 59, 270, 19));
        this.add(contadultDate, new KDLayout.Constraints(731, 59, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contperson.setBounds(new Rectangle(28, 105, 270, 19));
        this.add(contperson, new KDLayout.Constraints(28, 105, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbreedArea.setBounds(new Rectangle(731, 15, 270, 19));
        this.add(contbreedArea, new KDLayout.Constraints(731, 15, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbreedModel.setBounds(new Rectangle(379, 128, 270, 19));
        this.add(contbreedModel, new KDLayout.Constraints(379, 128, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisMoultingBatch.setBounds(new Rectangle(28, 128, 83, 19));
        this.add(chkisMoultingBatch, new KDLayout.Constraints(28, 128, 83, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contweek.setBounds(new Rectangle(731, 105, 150, 19));
        this.add(contweek, new KDLayout.Constraints(731, 105, 150, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contweekDay.setBounds(new Rectangle(893, 105, 108, 19));
        this.add(contweekDay, new KDLayout.Constraints(893, 105, 108, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkisToBreed.setBounds(new Rectangle(28, 81, 87, 19));
        this.add(chkisToBreed, new KDLayout.Constraints(28, 81, 87, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisToLayegg.setBounds(new Rectangle(169, 81, 77, 19));
        this.add(chkisToLayegg, new KDLayout.Constraints(169, 81, 77, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conthenhouseType.setBounds(new Rectangle(28, 59, 270, 19));
        this.add(conthenhouseType, new KDLayout.Constraints(28, 59, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contVarietie.setBounds(new Rectangle(28, 147, 270, 19));
        this.add(contVarietie, new KDLayout.Constraints(28, 147, 270, 19, 0));
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
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 974, 342));        kdtEntrys.setBounds(new Rectangle(0, 1, 638, 340));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.breed.ParentBreedBatchEntryInfo(),null,false);
        kDPanel1.add(kdtEntrys_detailPanel, new KDLayout.Constraints(0, 1, 638, 340, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtFieldDetailEntrys.setBounds(new Rectangle(640, 31, 328, 311));
        kdtFieldDetailEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtFieldDetailEntrys,new com.kingdee.eas.farm.breed.ParentBreedBatchEntryFieldDetailEntryInfo(),null,false);
        kDPanel1.add(kdtFieldDetailEntrys_detailPanel, new KDLayout.Constraints(640, 31, 328, 311, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabel1.setBounds(new Rectangle(640, 3, 125, 26));
        kDPanel1.add(kDLabel1, new KDLayout.Constraints(640, 3, 125, 26, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 974, 342));        kdtTransEntrys.setBounds(new Rectangle(2, 2, 965, 337));
        kdtTransEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtTransEntrys,new com.kingdee.eas.farm.breed.ParentBreedBatchTransEntryInfo(),null,false);
        kDPanel2.add(kdtTransEntrys_detailPanel, new KDLayout.Constraints(2, 2, 965, 337, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //contbreedPlan
        contbreedPlan.setBoundEditor(prmtbreedPlan);
        //contfarm
        contfarm.setBoundEditor(prmtfarm);
        //contbabyCostObject
        contbabyCostObject.setBoundEditor(prmtbabyCostObject);
        //contyoungCostObject
        contyoungCostObject.setBoundEditor(prmtyoungCostObject);
        //conteggCostObject
        conteggCostObject.setBoundEditor(prmteggCostObject);
        //contyoungDate
        contyoungDate.setBoundEditor(pkyoungDate);
        //contadultDate
        contadultDate.setBoundEditor(pkadultDate);
        //contperson
        contperson.setBoundEditor(prmtperson);
        //contbreedArea
        contbreedArea.setBoundEditor(prmtbreedArea);
        //contbreedModel
        contbreedModel.setBoundEditor(prmtbreedModel);
        //contweek
        contweek.setBoundEditor(txtweek);
        //contweekDay
        contweekDay.setBoundEditor(txtweekDay);
        //conthenhouseType
        conthenhouseType.setBoundEditor(henhouseType);
        //contVarietie
        contVarietie.setBoundEditor(txtVarietie);

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
		dataBinder.registerBinding("isMoultingBatch", boolean.class, this.chkisMoultingBatch, "selected");
		dataBinder.registerBinding("isToBreed", boolean.class, this.chkisToBreed, "selected");
		dataBinder.registerBinding("isToLayegg", boolean.class, this.chkisToLayegg, "selected");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.breed.ParentBreedBatchEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.incoopDate", java.util.Date.class, this.kdtEntrys, "incoopDate.text");
		dataBinder.registerBinding("entrys.stockingDensity", java.math.BigDecimal.class, this.kdtEntrys, "stockingDensity.text");
		dataBinder.registerBinding("entrys.henhouse", java.lang.Object.class, this.kdtEntrys, "henhouse.text");
		dataBinder.registerBinding("entrys.henInitQty", int.class, this.kdtEntrys, "henInitQty.text");
		dataBinder.registerBinding("entrys.cockInitQty", int.class, this.kdtEntrys, "cockInitQty.text");
		dataBinder.registerBinding("entrys.henhouseName", String.class, this.kdtEntrys, "henhouseName.text");
		dataBinder.registerBinding("entrys.FieldDetailEntrys.seq", int.class, this.kdtFieldDetailEntrys, "seq.text");
		dataBinder.registerBinding("entrys.FieldDetailEntrys", com.kingdee.eas.farm.breed.ParentBreedBatchEntryFieldDetailEntryInfo.class, this.kdtFieldDetailEntrys, "userObject");
		dataBinder.registerBinding("entrys.FieldDetailEntrys.housefield", java.lang.Object.class, this.kdtFieldDetailEntrys, "housefield.text");
		dataBinder.registerBinding("entrys.FieldDetailEntrys.henInitQty", int.class, this.kdtFieldDetailEntrys, "henInitQty.text");
		dataBinder.registerBinding("entrys.FieldDetailEntrys.cockInitQty", int.class, this.kdtFieldDetailEntrys, "cockInitQty.text");
		dataBinder.registerBinding("TransEntrys.seq", int.class, this.kdtTransEntrys, "seq.text");
		dataBinder.registerBinding("TransEntrys", com.kingdee.eas.farm.breed.ParentBreedBatchTransEntryInfo.class, this.kdtTransEntrys, "userObject");
		dataBinder.registerBinding("TransEntrys.isFromOtherBatch", boolean.class, this.kdtTransEntrys, "isFromOtherBatch.text");
		dataBinder.registerBinding("TransEntrys.fromHenhouse", java.lang.Object.class, this.kdtTransEntrys, "fromHenhouse.text");
		dataBinder.registerBinding("TransEntrys.toHenhouse", java.lang.Object.class, this.kdtTransEntrys, "toHenhouse.text");
		dataBinder.registerBinding("TransEntrys.transDate", java.util.Date.class, this.kdtTransEntrys, "transDate.text");
		dataBinder.registerBinding("TransEntrys.transWeeks", int.class, this.kdtTransEntrys, "transWeeks.text");
		dataBinder.registerBinding("TransEntrys.transWeekDays", int.class, this.kdtTransEntrys, "transWeekDays.text");
		dataBinder.registerBinding("TransEntrys.outHousefield", java.lang.Object.class, this.kdtTransEntrys, "outHousefield.text");
		dataBinder.registerBinding("TransEntrys.inHousefield", java.lang.Object.class, this.kdtTransEntrys, "inHousefield.text");
		dataBinder.registerBinding("TransEntrys.isBuy", boolean.class, this.kdtTransEntrys, "isBuy.text");
		dataBinder.registerBinding("TransEntrys.supplier", java.lang.Object.class, this.kdtTransEntrys, "supplier.text");
		dataBinder.registerBinding("TransEntrys.isTransOut", boolean.class, this.kdtTransEntrys, "isTransOut.text");
		dataBinder.registerBinding("TransEntrys.asTransEggQty", int.class, this.kdtTransEntrys, "asTransEggQty.text");
		dataBinder.registerBinding("TransEntrys.transHenQty", int.class, this.kdtTransEntrys, "transHenQty.text");
		dataBinder.registerBinding("TransEntrys.transCockQty", int.class, this.kdtTransEntrys, "transCockQty.text");
		dataBinder.registerBinding("TransEntrys.henAsFixedQty", int.class, this.kdtTransEntrys, "henAsFixedQty.text");
		dataBinder.registerBinding("TransEntrys.cockAsFixedQty", int.class, this.kdtTransEntrys, "cockAsFixedQty.text");
		dataBinder.registerBinding("TransEntrys.fromBatch", java.lang.Object.class, this.kdtTransEntrys, "fromBatch.text");
		dataBinder.registerBinding("TransEntrys.toBatch", java.lang.Object.class, this.kdtTransEntrys, "toBatch.text");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("breedPlan", com.kingdee.eas.farm.breed.business.CCBreedPlanInfo.class, this.prmtbreedPlan, "data");
		dataBinder.registerBinding("farm", com.kingdee.eas.farm.breed.BreedStoorgSetInfo.class, this.prmtfarm, "data");
		dataBinder.registerBinding("babyCostObject", com.kingdee.eas.basedata.assistant.CostObjectInfo.class, this.prmtbabyCostObject, "data");
		dataBinder.registerBinding("youngCostObject", com.kingdee.eas.basedata.assistant.CostObjectInfo.class, this.prmtyoungCostObject, "data");
		dataBinder.registerBinding("eggCostObject", com.kingdee.eas.basedata.assistant.CostObjectInfo.class, this.prmteggCostObject, "data");
		dataBinder.registerBinding("youngDate", java.util.Date.class, this.pkyoungDate, "value");
		dataBinder.registerBinding("adultDate", java.util.Date.class, this.pkadultDate, "value");
		dataBinder.registerBinding("person", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtperson, "data");
		dataBinder.registerBinding("breedArea", com.kingdee.eas.farm.breed.BreedAreaInfo.class, this.prmtbreedArea, "data");
		dataBinder.registerBinding("breedModel", com.kingdee.eas.farm.breed.BreedModelInfo.class, this.prmtbreedModel, "data");
		dataBinder.registerBinding("week", int.class, this.txtweek, "value");
		dataBinder.registerBinding("weekDay", int.class, this.txtweekDay, "value");
		dataBinder.registerBinding("henhouseType", com.kingdee.eas.farm.breed.HenhouseType.class, this.henhouseType, "selectedItem");
		dataBinder.registerBinding("Varietie", String.class, this.txtVarietie, "text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.breed.app.ParentBreedBatchEditUIHandler";
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
        this.kdtFieldDetailEntrys.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.breed.ParentBreedBatchInfo)ov;
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
		getValidateHelper().registerBindProperty("isMoultingBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isToBreed", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isToLayegg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.incoopDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.stockingDensity", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.henhouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.henInitQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.cockInitQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.henhouseName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.FieldDetailEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.FieldDetailEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.FieldDetailEntrys.housefield", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.FieldDetailEntrys.henInitQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.FieldDetailEntrys.cockInitQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntrys.isFromOtherBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntrys.fromHenhouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntrys.toHenhouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntrys.transDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntrys.transWeeks", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntrys.transWeekDays", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntrys.outHousefield", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntrys.inHousefield", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntrys.isBuy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntrys.supplier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntrys.isTransOut", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntrys.asTransEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntrys.transHenQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntrys.transCockQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntrys.henAsFixedQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntrys.cockAsFixedQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntrys.fromBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TransEntrys.toBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedPlan", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("babyCostObject", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("youngCostObject", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eggCostObject", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("youngDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("adultDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("person", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedArea", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedModel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("week", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("weekDay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("henhouseType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Varietie", ValidateHelper.ON_SAVE);    		
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
     * output kDPanel1_mouseClicked method
     */
    protected void kDPanel1_mouseClicked(java.awt.event.MouseEvent e) throws Exception
    {
    }

    /**
     * output kdtEntrys_tableSelectChanged method
     */
    protected void kdtEntrys_tableSelectChanged(com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output kdtEntrys_tableClicked method
     */
    protected void kdtEntrys_tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output kdtEntrys_activeCellChanged method
     */
    protected void kdtEntrys_activeCellChanged(com.kingdee.bos.ctrl.kdf.table.event.KDTActiveCellEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output prmtbreedPlan_dataChanged method
     */
    protected void prmtbreedPlan_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output prmtfarm_dataChanged method
     */
    protected void prmtfarm_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output prmtbreedArea_dataChanged method
     */
    protected void prmtbreedArea_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        //write your code here
    }


    /**
     * output kdtEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("henhouse".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"henhouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"henhouse").getValue(),"name")));

}


    }

    /**
     * output prmtbreedModel_Changed() method
     */
    public void prmtbreedModel_Changed() throws Exception
    {
        System.out.println("prmtbreedModel_Changed() Function is executed!");
            txtVarietie.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtbreedModel.getData(),"Varietie.name")));


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
        sic.add(new SelectorItemInfo("isMoultingBatch"));
        sic.add(new SelectorItemInfo("isToBreed"));
        sic.add(new SelectorItemInfo("isToLayegg"));
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
        sic.add(new SelectorItemInfo("auditTime"));
    	sic.add(new SelectorItemInfo("entrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("entrys.incoopDate"));
    	sic.add(new SelectorItemInfo("entrys.stockingDensity"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.henhouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.henhouse.id"));
			sic.add(new SelectorItemInfo("entrys.henhouse.name"));
        	sic.add(new SelectorItemInfo("entrys.henhouse.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.henInitQty"));
    	sic.add(new SelectorItemInfo("entrys.cockInitQty"));
    	sic.add(new SelectorItemInfo("entrys.henhouseName"));
    	sic.add(new SelectorItemInfo("entrys.FieldDetailEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.FieldDetailEntrys.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.FieldDetailEntrys.id"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.FieldDetailEntrys.housefield.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.FieldDetailEntrys.housefield.id"));
			sic.add(new SelectorItemInfo("entrys.FieldDetailEntrys.housefield.name"));
        	sic.add(new SelectorItemInfo("entrys.FieldDetailEntrys.housefield.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.FieldDetailEntrys.henInitQty"));
    	sic.add(new SelectorItemInfo("entrys.FieldDetailEntrys.cockInitQty"));
    	sic.add(new SelectorItemInfo("TransEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransEntrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("TransEntrys.isFromOtherBatch"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransEntrys.fromHenhouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("TransEntrys.fromHenhouse.id"));
			sic.add(new SelectorItemInfo("TransEntrys.fromHenhouse.name"));
        	sic.add(new SelectorItemInfo("TransEntrys.fromHenhouse.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransEntrys.toHenhouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("TransEntrys.toHenhouse.id"));
			sic.add(new SelectorItemInfo("TransEntrys.toHenhouse.name"));
        	sic.add(new SelectorItemInfo("TransEntrys.toHenhouse.number"));
		}
    	sic.add(new SelectorItemInfo("TransEntrys.transDate"));
    	sic.add(new SelectorItemInfo("TransEntrys.transWeeks"));
    	sic.add(new SelectorItemInfo("TransEntrys.transWeekDays"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransEntrys.outHousefield.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("TransEntrys.outHousefield.id"));
			sic.add(new SelectorItemInfo("TransEntrys.outHousefield.name"));
        	sic.add(new SelectorItemInfo("TransEntrys.outHousefield.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransEntrys.inHousefield.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("TransEntrys.inHousefield.id"));
			sic.add(new SelectorItemInfo("TransEntrys.inHousefield.name"));
        	sic.add(new SelectorItemInfo("TransEntrys.inHousefield.number"));
		}
    	sic.add(new SelectorItemInfo("TransEntrys.isBuy"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransEntrys.supplier.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("TransEntrys.supplier.id"));
			sic.add(new SelectorItemInfo("TransEntrys.supplier.name"));
        	sic.add(new SelectorItemInfo("TransEntrys.supplier.number"));
		}
    	sic.add(new SelectorItemInfo("TransEntrys.isTransOut"));
    	sic.add(new SelectorItemInfo("TransEntrys.asTransEggQty"));
    	sic.add(new SelectorItemInfo("TransEntrys.transHenQty"));
    	sic.add(new SelectorItemInfo("TransEntrys.transCockQty"));
    	sic.add(new SelectorItemInfo("TransEntrys.henAsFixedQty"));
    	sic.add(new SelectorItemInfo("TransEntrys.cockAsFixedQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransEntrys.fromBatch.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("TransEntrys.fromBatch.id"));
			sic.add(new SelectorItemInfo("TransEntrys.fromBatch.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TransEntrys.toBatch.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("TransEntrys.toBatch.id"));
			sic.add(new SelectorItemInfo("TransEntrys.toBatch.number"));
		}
        sic.add(new SelectorItemInfo("baseStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("breedPlan.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("breedPlan.id"));
        	sic.add(new SelectorItemInfo("breedPlan.number"));
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
			sic.add(new SelectorItemInfo("babyCostObject.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("babyCostObject.id"));
        	sic.add(new SelectorItemInfo("babyCostObject.number"));
        	sic.add(new SelectorItemInfo("babyCostObject.name"));
        	sic.add(new SelectorItemInfo("babyCostObject.relatedName"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("youngCostObject.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("youngCostObject.id"));
        	sic.add(new SelectorItemInfo("youngCostObject.number"));
        	sic.add(new SelectorItemInfo("youngCostObject.name"));
        	sic.add(new SelectorItemInfo("youngCostObject.relatedName"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("eggCostObject.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("eggCostObject.id"));
        	sic.add(new SelectorItemInfo("eggCostObject.number"));
        	sic.add(new SelectorItemInfo("eggCostObject.name"));
        	sic.add(new SelectorItemInfo("eggCostObject.relatedName"));
		}
        sic.add(new SelectorItemInfo("youngDate"));
        sic.add(new SelectorItemInfo("adultDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("person.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("person.id"));
        	sic.add(new SelectorItemInfo("person.number"));
        	sic.add(new SelectorItemInfo("person.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("breedArea.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("breedArea.id"));
        	sic.add(new SelectorItemInfo("breedArea.number"));
        	sic.add(new SelectorItemInfo("breedArea.areaName"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("breedModel.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("breedModel.id"));
        	sic.add(new SelectorItemInfo("breedModel.number"));
        	sic.add(new SelectorItemInfo("breedModel.name"));
		}
        sic.add(new SelectorItemInfo("week"));
        sic.add(new SelectorItemInfo("weekDay"));
        sic.add(new SelectorItemInfo("henhouseType"));
        sic.add(new SelectorItemInfo("Varietie"));
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
        com.kingdee.eas.farm.breed.ParentBreedBatchFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.breed.ParentBreedBatchFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionUpdateBatchMarket_actionPerformed method
     */
    public void actionUpdateBatchMarket_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.breed.ParentBreedBatchFactory.getRemoteInstance().updateBatchMarket(editData);
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
            innerActionPerformed("eas", AbstractParentBreedBatchEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractParentBreedBatchEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractParentBreedBatchEditUI.this, "ActionUpdateBatchMarket", "actionUpdateBatchMarket_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.breed.client", "ParentBreedBatchEditUI");
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
        return com.kingdee.eas.farm.breed.client.ParentBreedBatchEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.breed.ParentBreedBatchFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.breed.ParentBreedBatchInfo objectValue = new com.kingdee.eas.farm.breed.ParentBreedBatchInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/breed/ParentBreedBatch";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.breed.app.ParentBreedBatchQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtNumber.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"单据编号"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtfarm.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖场"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtperson.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"责任人"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtbreedArea.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"区"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtbreedModel.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"适用规范"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(henhouseType.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"禽类别"});
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
vo.put("henhouseType","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}