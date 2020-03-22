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
public abstract class AbstractBreedBatchEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractBreedBatchEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcostObject;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweek;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweekDay;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel1;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstoOrg;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthouseType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdays;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteggBatch;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contwarehouse;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedPlan;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttransQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcostObject;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtweek;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtweekDay;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstoOrg;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEditEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEditEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.swing.KDComboBox houseType;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdays;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmteggBatch;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtwarehouse;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbreedPlan;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttransQty;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem btnUpdateMarket;
    protected com.kingdee.eas.farm.breed.BreedBatchInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionUpdateBatchMarket actionUpdateBatchMarket = null;
    /**
     * output class constructor
     */
    public AbstractBreedBatchEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractBreedBatchEditUI.class.getName());
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
        this.contweek = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweekDay = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabel1 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDLabel2 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstoOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthouseType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdays = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteggBatch = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contwarehouse = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbreedPlan = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttransQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcostObject = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtweek = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtweekDay = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtstoOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtEditEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.houseType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtdays = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmteggBatch = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtwarehouse = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbreedPlan = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txttransQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
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
        this.contweek.setName("contweek");
        this.contweekDay.setName("contweekDay");
        this.kDLabel1.setName("kDLabel1");
        this.kDLabel2.setName("kDLabel2");
        this.contauditTime.setName("contauditTime");
        this.contstoOrg.setName("contstoOrg");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contbaseStatus.setName("contbaseStatus");
        this.conthouseType.setName("conthouseType");
        this.contdays.setName("contdays");
        this.conteggBatch.setName("conteggBatch");
        this.contwarehouse.setName("contwarehouse");
        this.contbreedPlan.setName("contbreedPlan");
        this.conttransQty.setName("conttransQty");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtcostObject.setName("prmtcostObject");
        this.txtweek.setName("txtweek");
        this.txtweekDay.setName("txtweekDay");
        this.pkauditTime.setName("pkauditTime");
        this.prmtstoOrg.setName("prmtstoOrg");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kdtEntrys.setName("kdtEntrys");
        this.kdtEditEntrys.setName("kdtEditEntrys");
        this.baseStatus.setName("baseStatus");
        this.houseType.setName("houseType");
        this.txtdays.setName("txtdays");
        this.prmteggBatch.setName("prmteggBatch");
        this.prmtwarehouse.setName("prmtwarehouse");
        this.prmtbreedPlan.setName("prmtbreedPlan");
        this.txttransQty.setName("txttransQty");
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
        // contweek		
        this.contweek.setBoundLabelText(resHelper.getString("contweek.boundLabelText"));		
        this.contweek.setBoundLabelLength(100);		
        this.contweek.setBoundLabelUnderline(true);		
        this.contweek.setVisible(true);
        // contweekDay		
        this.contweekDay.setBoundLabelText(resHelper.getString("contweekDay.boundLabelText"));		
        this.contweekDay.setBoundLabelLength(0);		
        this.contweekDay.setBoundLabelUnderline(true);		
        this.contweekDay.setVisible(true);
        // kDLabel1		
        this.kDLabel1.setText(resHelper.getString("kDLabel1.text"));
        // kDLabel2		
        this.kDLabel2.setText(resHelper.getString("kDLabel2.text"));
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // contstoOrg		
        this.contstoOrg.setBoundLabelText(resHelper.getString("contstoOrg.boundLabelText"));		
        this.contstoOrg.setBoundLabelLength(100);		
        this.contstoOrg.setBoundLabelUnderline(true);		
        this.contstoOrg.setVisible(true);
        // kDTabbedPane1
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);
        // conthouseType		
        this.conthouseType.setBoundLabelText(resHelper.getString("conthouseType.boundLabelText"));		
        this.conthouseType.setBoundLabelLength(100);		
        this.conthouseType.setBoundLabelUnderline(true);		
        this.conthouseType.setVisible(true);
        // contdays		
        this.contdays.setBoundLabelText(resHelper.getString("contdays.boundLabelText"));		
        this.contdays.setBoundLabelLength(100);		
        this.contdays.setBoundLabelUnderline(true);		
        this.contdays.setVisible(true);
        // conteggBatch		
        this.conteggBatch.setBoundLabelText(resHelper.getString("conteggBatch.boundLabelText"));		
        this.conteggBatch.setBoundLabelLength(100);		
        this.conteggBatch.setBoundLabelUnderline(true);		
        this.conteggBatch.setVisible(true);
        // contwarehouse		
        this.contwarehouse.setBoundLabelText(resHelper.getString("contwarehouse.boundLabelText"));		
        this.contwarehouse.setBoundLabelLength(100);		
        this.contwarehouse.setBoundLabelUnderline(true);		
        this.contwarehouse.setVisible(true);
        // contbreedPlan		
        this.contbreedPlan.setBoundLabelText(resHelper.getString("contbreedPlan.boundLabelText"));		
        this.contbreedPlan.setBoundLabelLength(100);		
        this.contbreedPlan.setBoundLabelUnderline(true);		
        this.contbreedPlan.setVisible(true);
        // conttransQty		
        this.conttransQty.setBoundLabelText(resHelper.getString("conttransQty.boundLabelText"));		
        this.conttransQty.setBoundLabelLength(100);		
        this.conttransQty.setBoundLabelUnderline(true);		
        this.conttransQty.setVisible(true);
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
        this.prmtcostObject.setRequired(false);
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
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // prmtstoOrg		
        this.prmtstoOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtstoOrg.setEditable(true);		
        this.prmtstoOrg.setDisplayFormat("$name$");		
        this.prmtstoOrg.setEditFormat("$number$");		
        this.prmtstoOrg.setCommitFormat("$number$");		
        this.prmtstoOrg.setRequired(true);		
        this.prmtstoOrg.setEnabled(false);
        // kDPanel1
        // kDPanel2
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"henHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"henhouseName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"chikenType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"incoopDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"initQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"stockingDensity\" t:width=\"120\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"henQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"henFixedQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"cockQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"cockFixedQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"isMarket\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"marketDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"marketQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{henHouse}</t:Cell><t:Cell>$Resource{henhouseName}</t:Cell><t:Cell>$Resource{chikenType}</t:Cell><t:Cell>$Resource{incoopDate}</t:Cell><t:Cell>$Resource{initQty}</t:Cell><t:Cell>$Resource{stockingDensity}</t:Cell><t:Cell>$Resource{henQty}</t:Cell><t:Cell>$Resource{henFixedQty}</t:Cell><t:Cell>$Resource{cockQty}</t:Cell><t:Cell>$Resource{cockFixedQty}</t:Cell><t:Cell>$Resource{isMarket}</t:Cell><t:Cell>$Resource{marketDate}</t:Cell><t:Cell>$Resource{marketQty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtEntrys.putBindContents("editData",new String[] {"id","henHouse","henhouseName","chikenType","incoopDate","initQty","stockingDensity","henQty","henFixedQty","cockQty","cockFixedQty","isMarket","marketDate","marketQty"});


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
        KDTextField kdtEntrys_henhouseName_TextField = new KDTextField();
        kdtEntrys_henhouseName_TextField.setName("kdtEntrys_henhouseName_TextField");
        kdtEntrys_henhouseName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_henhouseName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henhouseName_TextField);
        this.kdtEntrys.getColumn("henhouseName").setEditor(kdtEntrys_henhouseName_CellEditor);
        KDComboBox kdtEntrys_chikenType_ComboBox = new KDComboBox();
        kdtEntrys_chikenType_ComboBox.setName("kdtEntrys_chikenType_ComboBox");
        kdtEntrys_chikenType_ComboBox.setVisible(true);
        kdtEntrys_chikenType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.breed.ChikenType").toArray());
        KDTDefaultCellEditor kdtEntrys_chikenType_CellEditor = new KDTDefaultCellEditor(kdtEntrys_chikenType_ComboBox);
        this.kdtEntrys.getColumn("chikenType").setEditor(kdtEntrys_chikenType_CellEditor);
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
        KDFormattedTextField kdtEntrys_henQty_TextField = new KDFormattedTextField();
        kdtEntrys_henQty_TextField.setName("kdtEntrys_henQty_TextField");
        kdtEntrys_henQty_TextField.setVisible(true);
        kdtEntrys_henQty_TextField.setEditable(true);
        kdtEntrys_henQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_henQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_henQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henQty_TextField);
        this.kdtEntrys.getColumn("henQty").setEditor(kdtEntrys_henQty_CellEditor);
        KDFormattedTextField kdtEntrys_henFixedQty_TextField = new KDFormattedTextField();
        kdtEntrys_henFixedQty_TextField.setName("kdtEntrys_henFixedQty_TextField");
        kdtEntrys_henFixedQty_TextField.setVisible(true);
        kdtEntrys_henFixedQty_TextField.setEditable(true);
        kdtEntrys_henFixedQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_henFixedQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_henFixedQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henFixedQty_TextField);
        this.kdtEntrys.getColumn("henFixedQty").setEditor(kdtEntrys_henFixedQty_CellEditor);
        KDFormattedTextField kdtEntrys_cockQty_TextField = new KDFormattedTextField();
        kdtEntrys_cockQty_TextField.setName("kdtEntrys_cockQty_TextField");
        kdtEntrys_cockQty_TextField.setVisible(true);
        kdtEntrys_cockQty_TextField.setEditable(true);
        kdtEntrys_cockQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_cockQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_cockQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_cockQty_TextField);
        this.kdtEntrys.getColumn("cockQty").setEditor(kdtEntrys_cockQty_CellEditor);
        KDFormattedTextField kdtEntrys_cockFixedQty_TextField = new KDFormattedTextField();
        kdtEntrys_cockFixedQty_TextField.setName("kdtEntrys_cockFixedQty_TextField");
        kdtEntrys_cockFixedQty_TextField.setVisible(true);
        kdtEntrys_cockFixedQty_TextField.setEditable(true);
        kdtEntrys_cockFixedQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_cockFixedQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_cockFixedQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_cockFixedQty_TextField);
        this.kdtEntrys.getColumn("cockFixedQty").setEditor(kdtEntrys_cockFixedQty_CellEditor);
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
        // kdtEditEntrys
		String kdtEditEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"addDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"henhouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"henhouseName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"chikenType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"addQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"reason\" t:width=\"300\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{addDate}</t:Cell><t:Cell>$Resource{henhouse}</t:Cell><t:Cell>$Resource{henhouseName}</t:Cell><t:Cell>$Resource{chikenType}</t:Cell><t:Cell>$Resource{addQty}</t:Cell><t:Cell>$Resource{reason}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEditEntrys.setFormatXml(resHelper.translateString("kdtEditEntrys",kdtEditEntrysStrXML));
        kdtEditEntrys.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtEditEntrys_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtEditEntrys.putBindContents("editData",new String[] {"seq","addDate","henhouse","henhouseName","chikenType","addQty","reason"});


        this.kdtEditEntrys.checkParsed();
        KDFormattedTextField kdtEditEntrys_seq_TextField = new KDFormattedTextField();
        kdtEditEntrys_seq_TextField.setName("kdtEditEntrys_seq_TextField");
        kdtEditEntrys_seq_TextField.setVisible(true);
        kdtEditEntrys_seq_TextField.setEditable(true);
        kdtEditEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtEditEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEditEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtEditEntrys_seq_TextField);
        this.kdtEditEntrys.getColumn("seq").setEditor(kdtEditEntrys_seq_CellEditor);
        KDDatePicker kdtEditEntrys_addDate_DatePicker = new KDDatePicker();
        kdtEditEntrys_addDate_DatePicker.setName("kdtEditEntrys_addDate_DatePicker");
        kdtEditEntrys_addDate_DatePicker.setVisible(true);
        kdtEditEntrys_addDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEditEntrys_addDate_CellEditor = new KDTDefaultCellEditor(kdtEditEntrys_addDate_DatePicker);
        this.kdtEditEntrys.getColumn("addDate").setEditor(kdtEditEntrys_addDate_CellEditor);
        final KDBizPromptBox kdtEditEntrys_henhouse_PromptBox = new KDBizPromptBox();
        kdtEditEntrys_henhouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseF7Query");
        kdtEditEntrys_henhouse_PromptBox.setVisible(true);
        kdtEditEntrys_henhouse_PromptBox.setEditable(true);
        kdtEditEntrys_henhouse_PromptBox.setDisplayFormat("$number$");
        kdtEditEntrys_henhouse_PromptBox.setEditFormat("$number$");
        kdtEditEntrys_henhouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEditEntrys_henhouse_CellEditor = new KDTDefaultCellEditor(kdtEditEntrys_henhouse_PromptBox);
        this.kdtEditEntrys.getColumn("henhouse").setEditor(kdtEditEntrys_henhouse_CellEditor);
        ObjectValueRender kdtEditEntrys_henhouse_OVR = new ObjectValueRender();
        kdtEditEntrys_henhouse_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEditEntrys.getColumn("henhouse").setRenderer(kdtEditEntrys_henhouse_OVR);
        KDTextField kdtEditEntrys_henhouseName_TextField = new KDTextField();
        kdtEditEntrys_henhouseName_TextField.setName("kdtEditEntrys_henhouseName_TextField");
        kdtEditEntrys_henhouseName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEditEntrys_henhouseName_CellEditor = new KDTDefaultCellEditor(kdtEditEntrys_henhouseName_TextField);
        this.kdtEditEntrys.getColumn("henhouseName").setEditor(kdtEditEntrys_henhouseName_CellEditor);
        KDComboBox kdtEditEntrys_chikenType_ComboBox = new KDComboBox();
        kdtEditEntrys_chikenType_ComboBox.setName("kdtEditEntrys_chikenType_ComboBox");
        kdtEditEntrys_chikenType_ComboBox.setVisible(true);
        kdtEditEntrys_chikenType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.breed.ChikenType").toArray());
        KDTDefaultCellEditor kdtEditEntrys_chikenType_CellEditor = new KDTDefaultCellEditor(kdtEditEntrys_chikenType_ComboBox);
        this.kdtEditEntrys.getColumn("chikenType").setEditor(kdtEditEntrys_chikenType_CellEditor);
        KDFormattedTextField kdtEditEntrys_addQty_TextField = new KDFormattedTextField();
        kdtEditEntrys_addQty_TextField.setName("kdtEditEntrys_addQty_TextField");
        kdtEditEntrys_addQty_TextField.setVisible(true);
        kdtEditEntrys_addQty_TextField.setEditable(true);
        kdtEditEntrys_addQty_TextField.setHorizontalAlignment(2);
        kdtEditEntrys_addQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEditEntrys_addQty_CellEditor = new KDTDefaultCellEditor(kdtEditEntrys_addQty_TextField);
        this.kdtEditEntrys.getColumn("addQty").setEditor(kdtEditEntrys_addQty_CellEditor);
        KDTextField kdtEditEntrys_reason_TextField = new KDTextField();
        kdtEditEntrys_reason_TextField.setName("kdtEditEntrys_reason_TextField");
        kdtEditEntrys_reason_TextField.setMaxLength(255);
        KDTDefaultCellEditor kdtEditEntrys_reason_CellEditor = new KDTDefaultCellEditor(kdtEditEntrys_reason_TextField);
        this.kdtEditEntrys.getColumn("reason").setEditor(kdtEditEntrys_reason_CellEditor);
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(false);		
        this.baseStatus.setEnabled(false);
        // houseType		
        this.houseType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.breed.HenhouseType").toArray());		
        this.houseType.setRequired(true);
        // txtdays		
        this.txtdays.setHorizontalAlignment(2);		
        this.txtdays.setDataType(0);		
        this.txtdays.setSupportedEmpty(true);		
        this.txtdays.setRequired(false);
        // prmteggBatch		
        this.prmteggBatch.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");		
        this.prmteggBatch.setEditable(true);		
        this.prmteggBatch.setDisplayFormat("$name$");		
        this.prmteggBatch.setEditFormat("$number$");		
        this.prmteggBatch.setCommitFormat("$number$");		
        this.prmteggBatch.setRequired(false);
        // prmtwarehouse		
        this.prmtwarehouse.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.WarehouseQuery");		
        this.prmtwarehouse.setEditable(true);		
        this.prmtwarehouse.setDisplayFormat("$name$");		
        this.prmtwarehouse.setEditFormat("$number$");		
        this.prmtwarehouse.setCommitFormat("$number$");		
        this.prmtwarehouse.setRequired(false);
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
        // txttransQty		
        this.txttransQty.setVisible(true);		
        this.txttransQty.setHorizontalAlignment(2);		
        this.txttransQty.setDataType(0);		
        this.txttransQty.setSupportedEmpty(true);		
        this.txttransQty.setRequired(false);		
        this.txttransQty.setEnabled(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        // btnUpdateMarket
        this.btnUpdateMarket.setAction((IItemAction)ActionProxyFactory.getProxy(actionUpdateBatchMarket, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUpdateMarket.setText(resHelper.getString("btnUpdateMarket.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtcostObject,txtweek,txtweekDay,pkauditTime,prmtstoOrg,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,baseStatus,houseType,txtdays,prmteggBatch,prmtwarehouse,prmtbreedPlan,kdtEntrys,kdtEditEntrys,txttransQty}));
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
        contBizDate.setBounds(new Rectangle(382, 73, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(382, 73, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(26, 140, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(26, 140, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(725, 572, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(725, 572, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcostObject.setBounds(new Rectangle(382, 17, 270, 19));
        this.add(contcostObject, new KDLayout.Constraints(382, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contweek.setBounds(new Rectangle(734, 17, 139, 19));
        this.add(contweek, new KDLayout.Constraints(734, 17, 139, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contweekDay.setBounds(new Rectangle(920, 17, 34, 19));
        this.add(contweekDay, new KDLayout.Constraints(920, 17, 34, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabel1.setBounds(new Rectangle(883, 17, 27, 19));
        this.add(kDLabel1, new KDLayout.Constraints(883, 17, 27, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabel2.setBounds(new Rectangle(964, 17, 27, 19));
        this.add(kDLabel2, new KDLayout.Constraints(964, 17, 27, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contauditTime.setBounds(new Rectangle(725, 598, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(725, 598, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contstoOrg.setBounds(new Rectangle(28, 46, 270, 19));
        this.add(contstoOrg, new KDLayout.Constraints(28, 46, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane1.setBounds(new Rectangle(20, 163, 975, 396));
        this.add(kDTabbedPane1, new KDLayout.Constraints(20, 163, 975, 396, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contbaseStatus.setBounds(new Rectangle(734, 45, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(734, 45, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conthouseType.setBounds(new Rectangle(382, 46, 270, 19));
        this.add(conthouseType, new KDLayout.Constraints(382, 46, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdays.setBounds(new Rectangle(734, 17, 270, 19));
        this.add(contdays, new KDLayout.Constraints(734, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conteggBatch.setBounds(new Rectangle(734, 73, 270, 19));
        this.add(conteggBatch, new KDLayout.Constraints(734, 73, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contwarehouse.setBounds(new Rectangle(28, 73, 270, 19));
        this.add(contwarehouse, new KDLayout.Constraints(28, 73, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbreedPlan.setBounds(new Rectangle(382, 101, 270, 19));
        this.add(contbreedPlan, new KDLayout.Constraints(382, 101, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttransQty.setBounds(new Rectangle(734, 101, 270, 19));
        this.add(conttransQty, new KDLayout.Constraints(734, 101, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //contweek
        contweek.setBoundEditor(txtweek);
        //contweekDay
        contweekDay.setBoundEditor(txtweekDay);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contstoOrg
        contstoOrg.setBoundEditor(prmtstoOrg);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 974, 363));        kdtEntrys.setBounds(new Rectangle(0, 1, 968, 362));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.breed.BreedBatchEntryInfo(),null,false);
        kDPanel1.add(kdtEntrys_detailPanel, new KDLayout.Constraints(0, 1, 968, 362, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("chikenType","1");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 974, 363));        kdtEditEntrys.setBounds(new Rectangle(0, 0, 970, 364));
        kdtEditEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEditEntrys,new com.kingdee.eas.farm.breed.BreedBatchEditEntryInfo(),null,false);
        kDPanel2.add(kdtEditEntrys_detailPanel, new KDLayout.Constraints(0, 0, 970, 364, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtEditEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("chikenType","1");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //conthouseType
        conthouseType.setBoundEditor(houseType);
        //contdays
        contdays.setBoundEditor(txtdays);
        //conteggBatch
        conteggBatch.setBoundEditor(prmteggBatch);
        //contwarehouse
        contwarehouse.setBoundEditor(prmtwarehouse);
        //contbreedPlan
        contbreedPlan.setBoundEditor(prmtbreedPlan);
        //conttransQty
        conttransQty.setBoundEditor(txttransQty);

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
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("costObject", com.kingdee.eas.basedata.assistant.CostObjectInfo.class, this.prmtcostObject, "data");
		dataBinder.registerBinding("week", int.class, this.txtweek, "value");
		dataBinder.registerBinding("weekDay", int.class, this.txtweekDay, "value");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("stoOrg", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtstoOrg, "data");
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.breed.BreedBatchEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.henHouse", java.lang.Object.class, this.kdtEntrys, "henHouse.text");
		dataBinder.registerBinding("entrys.chikenType", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "chikenType.text");
		dataBinder.registerBinding("entrys.initQty", int.class, this.kdtEntrys, "initQty.text");
		dataBinder.registerBinding("entrys.incoopDate", java.util.Date.class, this.kdtEntrys, "incoopDate.text");
		dataBinder.registerBinding("entrys.isMarket", boolean.class, this.kdtEntrys, "isMarket.text");
		dataBinder.registerBinding("entrys.marketDate", java.util.Date.class, this.kdtEntrys, "marketDate.text");
		dataBinder.registerBinding("entrys.henhouseName", String.class, this.kdtEntrys, "henhouseName.text");
		dataBinder.registerBinding("entrys.henQty", int.class, this.kdtEntrys, "henQty.text");
		dataBinder.registerBinding("entrys.cockQty", int.class, this.kdtEntrys, "cockQty.text");
		dataBinder.registerBinding("entrys.henFixedQty", int.class, this.kdtEntrys, "henFixedQty.text");
		dataBinder.registerBinding("entrys.cockFixedQty", int.class, this.kdtEntrys, "cockFixedQty.text");
		dataBinder.registerBinding("entrys.marketQty", int.class, this.kdtEntrys, "marketQty.text");
		dataBinder.registerBinding("entrys.stockingDensity", java.math.BigDecimal.class, this.kdtEntrys, "stockingDensity.text");
		dataBinder.registerBinding("EditEntrys.seq", int.class, this.kdtEditEntrys, "seq.text");
		dataBinder.registerBinding("EditEntrys", com.kingdee.eas.farm.breed.BreedBatchEditEntryInfo.class, this.kdtEditEntrys, "userObject");
		dataBinder.registerBinding("EditEntrys.henhouse", java.lang.Object.class, this.kdtEditEntrys, "henhouse.text");
		dataBinder.registerBinding("EditEntrys.henhouseName", String.class, this.kdtEditEntrys, "henhouseName.text");
		dataBinder.registerBinding("EditEntrys.chikenType", com.kingdee.util.enums.Enum.class, this.kdtEditEntrys, "chikenType.text");
		dataBinder.registerBinding("EditEntrys.addQty", int.class, this.kdtEditEntrys, "addQty.text");
		dataBinder.registerBinding("EditEntrys.addDate", java.util.Date.class, this.kdtEditEntrys, "addDate.text");
		dataBinder.registerBinding("EditEntrys.reason", String.class, this.kdtEditEntrys, "reason.text");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("houseType", com.kingdee.eas.farm.breed.HenhouseType.class, this.houseType, "selectedItem");
		dataBinder.registerBinding("days", int.class, this.txtdays, "value");
		dataBinder.registerBinding("eggBatch", com.kingdee.eas.basedata.assistant.CostObjectInfo.class, this.prmteggBatch, "data");
		dataBinder.registerBinding("warehouse", com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo.class, this.prmtwarehouse, "data");
		dataBinder.registerBinding("breedPlan", com.kingdee.eas.farm.breed.business.CCBreedPlanInfo.class, this.prmtbreedPlan, "data");
		dataBinder.registerBinding("transQty", int.class, this.txttransQty, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.breed.app.BreedBatchEditUIHandler";
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
        this.prmtcostObject.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.breed.BreedBatchInfo)ov;
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
		getValidateHelper().registerBindProperty("week", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("weekDay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("stoOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.henHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.chikenType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.initQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.incoopDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.isMarket", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.marketDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.henhouseName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.henQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.cockQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.henFixedQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.cockFixedQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.marketQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.stockingDensity", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EditEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EditEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EditEntrys.henhouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EditEntrys.henhouseName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EditEntrys.chikenType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EditEntrys.addQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EditEntrys.addDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EditEntrys.reason", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("houseType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("days", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eggBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("warehouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedPlan", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("transQty", ValidateHelper.ON_SAVE);    		
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
     * output prmtbreedPlan_dataChanged method
     */
    protected void prmtbreedPlan_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        //write your code here
    }


    /**
     * output kdtEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("henHouse".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"henHouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"henHouse").getValue(),"warehouse.name")));

}

    if ("henHouse".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"henHouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"henHouse").getValue(),"warehouse.name")));

}

    if ("henHouse".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"henhouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"henHouse").getValue(),"name")));

}

    if ("henHouse".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"henhouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"henHouse").getValue(),"name")));

}


    }

    /**
     * output kdtEditEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEditEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("henhouse".equalsIgnoreCase(kdtEditEntrys.getColumn(colIndex).getKey())) {
kdtEditEntrys.getCell(rowIndex,"henhouseName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEditEntrys.getCell(rowIndex,"henhouse").getValue(),"name")));

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
        sic.add(new SelectorItemInfo("week"));
        sic.add(new SelectorItemInfo("weekDay"));
        sic.add(new SelectorItemInfo("auditTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("stoOrg.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("stoOrg.id"));
        	sic.add(new SelectorItemInfo("stoOrg.number"));
        	sic.add(new SelectorItemInfo("stoOrg.name"));
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
			sic.add(new SelectorItemInfo("entrys.henHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.henHouse.id"));
			sic.add(new SelectorItemInfo("entrys.henHouse.number"));
			sic.add(new SelectorItemInfo("entrys.henHouse.name"));
		}
    	sic.add(new SelectorItemInfo("entrys.chikenType"));
    	sic.add(new SelectorItemInfo("entrys.initQty"));
    	sic.add(new SelectorItemInfo("entrys.incoopDate"));
    	sic.add(new SelectorItemInfo("entrys.isMarket"));
    	sic.add(new SelectorItemInfo("entrys.marketDate"));
    	sic.add(new SelectorItemInfo("entrys.henhouseName"));
    	sic.add(new SelectorItemInfo("entrys.henQty"));
    	sic.add(new SelectorItemInfo("entrys.cockQty"));
    	sic.add(new SelectorItemInfo("entrys.henFixedQty"));
    	sic.add(new SelectorItemInfo("entrys.cockFixedQty"));
    	sic.add(new SelectorItemInfo("entrys.marketQty"));
    	sic.add(new SelectorItemInfo("entrys.stockingDensity"));
    	sic.add(new SelectorItemInfo("EditEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EditEntrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EditEntrys.henhouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EditEntrys.henhouse.id"));
			sic.add(new SelectorItemInfo("EditEntrys.henhouse.number"));
			sic.add(new SelectorItemInfo("EditEntrys.henhouse.name"));
		}
    	sic.add(new SelectorItemInfo("EditEntrys.henhouseName"));
    	sic.add(new SelectorItemInfo("EditEntrys.chikenType"));
    	sic.add(new SelectorItemInfo("EditEntrys.addQty"));
    	sic.add(new SelectorItemInfo("EditEntrys.addDate"));
    	sic.add(new SelectorItemInfo("EditEntrys.reason"));
        sic.add(new SelectorItemInfo("baseStatus"));
        sic.add(new SelectorItemInfo("houseType"));
        sic.add(new SelectorItemInfo("days"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("eggBatch.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("eggBatch.id"));
        	sic.add(new SelectorItemInfo("eggBatch.number"));
        	sic.add(new SelectorItemInfo("eggBatch.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("warehouse.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("warehouse.id"));
        	sic.add(new SelectorItemInfo("warehouse.number"));
        	sic.add(new SelectorItemInfo("warehouse.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("breedPlan.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("breedPlan.id"));
        	sic.add(new SelectorItemInfo("breedPlan.number"));
		}
        sic.add(new SelectorItemInfo("transQty"));
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
        com.kingdee.eas.farm.breed.BreedBatchFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.breed.BreedBatchFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionUpdateBatchMarket_actionPerformed method
     */
    public void actionUpdateBatchMarket_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.breed.BreedBatchFactory.getRemoteInstance().updateBatchMarket(editData);
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
            innerActionPerformed("eas", AbstractBreedBatchEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractBreedBatchEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractBreedBatchEditUI.this, "ActionUpdateBatchMarket", "actionUpdateBatchMarket_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.breed.client", "BreedBatchEditUI");
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
        return com.kingdee.eas.farm.breed.client.BreedBatchEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.breed.BreedBatchFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.breed.BreedBatchInfo objectValue = new com.kingdee.eas.farm.breed.BreedBatchInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/breed/BreedBatch";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.breed.app.BreedBatchQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtstoOrg.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖场"});
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"henHouse").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"鸡舍"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"chikenType").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"鸡类别"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(houseType.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"鸡舍类别"});
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
vo.put("houseType","1");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}        
				protected void setTableToSumField() {
			setTableToSumField(kdtEntrys,new String[] {"initQty","henQty","henFixedQty","cockQty","cockFixedQty","marketQty"});
		}


}