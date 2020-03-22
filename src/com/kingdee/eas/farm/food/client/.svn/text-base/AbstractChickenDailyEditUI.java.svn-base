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
public abstract class AbstractChickenDailyEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractChickenDailyEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contStorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompanyOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contPhysicalDeathQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contPhysicalDeathWeight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCarcassQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCarcassWeight;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator9;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdryingChickenWeight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contunCarcassWeight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contunCarcassQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdryingChickenQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmainPWeight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbyPWeight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contachickenclaw;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdermatitis;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgizzardsFood;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contwingBlood;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenUniform;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisBatchOver;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contreportDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCarcassUniformity;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contFIBizDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDComboBox BillStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtStorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkAuditTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompanyOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtPhysicalDeathQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtPhysicalDeathWeight;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtCarcassQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtCarcassWeight;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarm;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdryingChickenWeight;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtunCarcassWeight;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtunCarcassQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdryingChickenQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmainPWeight;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbyPWeight;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtachickenclaw;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdermatitis;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgizzardsFood;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtwingBlood;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickenUniform;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtBodyEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtBodyEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtCarCassEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtCarCassEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkreportDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtCarcassUniformity;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkFIBizDate;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.eas.farm.food.ChickenDailyInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractChickenDailyEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractChickenDailyEditUI.class.getName());
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
        this.contBillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contStorageOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompanyOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contPhysicalDeathQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contPhysicalDeathWeight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCarcassQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCarcassWeight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDSeparator9 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contfarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdryingChickenWeight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contunCarcassWeight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contunCarcassQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdryingChickenQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmainPWeight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbyPWeight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contachickenclaw = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdermatitis = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgizzardsFood = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contwingBlood = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchickenUniform = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.chkisBatchOver = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contreportDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCarcassUniformity = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contFIBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.BillStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtStorageOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkAuditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtcompanyOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtPhysicalDeathQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtPhysicalDeathWeight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtCarcassQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtCarcassWeight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtfarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtdryingChickenWeight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtunCarcassWeight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtunCarcassQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdryingChickenQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmainPWeight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbyPWeight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtachickenclaw = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdermatitis = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtgizzardsFood = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtwingBlood = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtchickenUniform = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtBodyEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtCarCassEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.pkreportDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtCarcassUniformity = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkFIBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
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
        this.contBillStatus.setName("contBillStatus");
        this.contStorageOrgUnit.setName("contStorageOrgUnit");
        this.contAuditTime.setName("contAuditTime");
        this.contcompanyOrgUnit.setName("contcompanyOrgUnit");
        this.contPhysicalDeathQty.setName("contPhysicalDeathQty");
        this.contPhysicalDeathWeight.setName("contPhysicalDeathWeight");
        this.contCarcassQty.setName("contCarcassQty");
        this.contCarcassWeight.setName("contCarcassWeight");
        this.kDSeparator8.setName("kDSeparator8");
        this.kDSeparator9.setName("kDSeparator9");
        this.contfarm.setName("contfarm");
        this.contdryingChickenWeight.setName("contdryingChickenWeight");
        this.contunCarcassWeight.setName("contunCarcassWeight");
        this.contunCarcassQty.setName("contunCarcassQty");
        this.contdryingChickenQty.setName("contdryingChickenQty");
        this.contmainPWeight.setName("contmainPWeight");
        this.contbyPWeight.setName("contbyPWeight");
        this.contachickenclaw.setName("contachickenclaw");
        this.contdermatitis.setName("contdermatitis");
        this.contgizzardsFood.setName("contgizzardsFood");
        this.contwingBlood.setName("contwingBlood");
        this.contchickenUniform.setName("contchickenUniform");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.chkisBatchOver.setName("chkisBatchOver");
        this.contreportDate.setName("contreportDate");
        this.contCarcassUniformity.setName("contCarcassUniformity");
        this.contFIBizDate.setName("contFIBizDate");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.BillStatus.setName("BillStatus");
        this.prmtStorageOrgUnit.setName("prmtStorageOrgUnit");
        this.pkAuditTime.setName("pkAuditTime");
        this.prmtcompanyOrgUnit.setName("prmtcompanyOrgUnit");
        this.txtPhysicalDeathQty.setName("txtPhysicalDeathQty");
        this.txtPhysicalDeathWeight.setName("txtPhysicalDeathWeight");
        this.txtCarcassQty.setName("txtCarcassQty");
        this.txtCarcassWeight.setName("txtCarcassWeight");
        this.prmtfarm.setName("prmtfarm");
        this.txtdryingChickenWeight.setName("txtdryingChickenWeight");
        this.txtunCarcassWeight.setName("txtunCarcassWeight");
        this.txtunCarcassQty.setName("txtunCarcassQty");
        this.txtdryingChickenQty.setName("txtdryingChickenQty");
        this.txtmainPWeight.setName("txtmainPWeight");
        this.txtbyPWeight.setName("txtbyPWeight");
        this.txtachickenclaw.setName("txtachickenclaw");
        this.txtdermatitis.setName("txtdermatitis");
        this.txtgizzardsFood.setName("txtgizzardsFood");
        this.txtwingBlood.setName("txtwingBlood");
        this.txtchickenUniform.setName("txtchickenUniform");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kdtBodyEntry.setName("kdtBodyEntry");
        this.kdtCarCassEntry.setName("kdtCarCassEntry");
        this.pkreportDate.setName("pkreportDate");
        this.txtCarcassUniformity.setName("txtCarcassUniformity");
        this.pkFIBizDate.setName("pkFIBizDate");
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
        // contBillStatus		
        this.contBillStatus.setBoundLabelText(resHelper.getString("contBillStatus.boundLabelText"));		
        this.contBillStatus.setBoundLabelLength(100);		
        this.contBillStatus.setBoundLabelUnderline(true);		
        this.contBillStatus.setVisible(true);
        // contStorageOrgUnit		
        this.contStorageOrgUnit.setBoundLabelText(resHelper.getString("contStorageOrgUnit.boundLabelText"));		
        this.contStorageOrgUnit.setBoundLabelLength(100);		
        this.contStorageOrgUnit.setBoundLabelUnderline(true);		
        this.contStorageOrgUnit.setVisible(true);
        // contAuditTime		
        this.contAuditTime.setBoundLabelText(resHelper.getString("contAuditTime.boundLabelText"));		
        this.contAuditTime.setBoundLabelLength(100);		
        this.contAuditTime.setBoundLabelUnderline(true);		
        this.contAuditTime.setVisible(true);
        // contcompanyOrgUnit		
        this.contcompanyOrgUnit.setBoundLabelText(resHelper.getString("contcompanyOrgUnit.boundLabelText"));		
        this.contcompanyOrgUnit.setBoundLabelLength(100);		
        this.contcompanyOrgUnit.setBoundLabelUnderline(true);		
        this.contcompanyOrgUnit.setVisible(true);
        // contPhysicalDeathQty		
        this.contPhysicalDeathQty.setBoundLabelText(resHelper.getString("contPhysicalDeathQty.boundLabelText"));		
        this.contPhysicalDeathQty.setBoundLabelLength(120);		
        this.contPhysicalDeathQty.setBoundLabelUnderline(true);		
        this.contPhysicalDeathQty.setVisible(true);
        // contPhysicalDeathWeight		
        this.contPhysicalDeathWeight.setBoundLabelText(resHelper.getString("contPhysicalDeathWeight.boundLabelText"));		
        this.contPhysicalDeathWeight.setBoundLabelLength(120);		
        this.contPhysicalDeathWeight.setBoundLabelUnderline(true);		
        this.contPhysicalDeathWeight.setVisible(true);
        // contCarcassQty		
        this.contCarcassQty.setBoundLabelText(resHelper.getString("contCarcassQty.boundLabelText"));		
        this.contCarcassQty.setBoundLabelLength(120);		
        this.contCarcassQty.setBoundLabelUnderline(true);		
        this.contCarcassQty.setVisible(true);
        // contCarcassWeight		
        this.contCarcassWeight.setBoundLabelText(resHelper.getString("contCarcassWeight.boundLabelText"));		
        this.contCarcassWeight.setBoundLabelLength(120);		
        this.contCarcassWeight.setBoundLabelUnderline(true);		
        this.contCarcassWeight.setVisible(true);
        // kDSeparator8
        // kDSeparator9
        // contfarm		
        this.contfarm.setBoundLabelText(resHelper.getString("contfarm.boundLabelText"));		
        this.contfarm.setBoundLabelLength(100);		
        this.contfarm.setBoundLabelUnderline(true);		
        this.contfarm.setVisible(true);
        // contdryingChickenWeight		
        this.contdryingChickenWeight.setBoundLabelText(resHelper.getString("contdryingChickenWeight.boundLabelText"));		
        this.contdryingChickenWeight.setBoundLabelLength(120);		
        this.contdryingChickenWeight.setBoundLabelUnderline(true);		
        this.contdryingChickenWeight.setVisible(true);
        // contunCarcassWeight		
        this.contunCarcassWeight.setBoundLabelText(resHelper.getString("contunCarcassWeight.boundLabelText"));		
        this.contunCarcassWeight.setBoundLabelLength(120);		
        this.contunCarcassWeight.setBoundLabelUnderline(true);		
        this.contunCarcassWeight.setVisible(true);
        // contunCarcassQty		
        this.contunCarcassQty.setBoundLabelText(resHelper.getString("contunCarcassQty.boundLabelText"));		
        this.contunCarcassQty.setBoundLabelLength(120);		
        this.contunCarcassQty.setBoundLabelUnderline(true);		
        this.contunCarcassQty.setVisible(true);
        // contdryingChickenQty		
        this.contdryingChickenQty.setBoundLabelText(resHelper.getString("contdryingChickenQty.boundLabelText"));		
        this.contdryingChickenQty.setBoundLabelLength(120);		
        this.contdryingChickenQty.setBoundLabelUnderline(true);		
        this.contdryingChickenQty.setVisible(true);
        // contmainPWeight		
        this.contmainPWeight.setBoundLabelText(resHelper.getString("contmainPWeight.boundLabelText"));		
        this.contmainPWeight.setBoundLabelLength(120);		
        this.contmainPWeight.setBoundLabelUnderline(true);		
        this.contmainPWeight.setVisible(true);
        // contbyPWeight		
        this.contbyPWeight.setBoundLabelText(resHelper.getString("contbyPWeight.boundLabelText"));		
        this.contbyPWeight.setBoundLabelLength(120);		
        this.contbyPWeight.setBoundLabelUnderline(true);		
        this.contbyPWeight.setVisible(true);
        // contachickenclaw		
        this.contachickenclaw.setBoundLabelText(resHelper.getString("contachickenclaw.boundLabelText"));		
        this.contachickenclaw.setBoundLabelLength(120);		
        this.contachickenclaw.setBoundLabelUnderline(true);		
        this.contachickenclaw.setVisible(false);		
        this.contachickenclaw.setForeground(new java.awt.Color(0,0,0));
        // contdermatitis		
        this.contdermatitis.setBoundLabelText(resHelper.getString("contdermatitis.boundLabelText"));		
        this.contdermatitis.setBoundLabelLength(120);		
        this.contdermatitis.setBoundLabelUnderline(true);		
        this.contdermatitis.setVisible(false);		
        this.contdermatitis.setForeground(new java.awt.Color(0,0,0));
        // contgizzardsFood		
        this.contgizzardsFood.setBoundLabelText(resHelper.getString("contgizzardsFood.boundLabelText"));		
        this.contgizzardsFood.setBoundLabelLength(120);		
        this.contgizzardsFood.setBoundLabelUnderline(true);		
        this.contgizzardsFood.setVisible(false);		
        this.contgizzardsFood.setForeground(new java.awt.Color(0,0,0));
        // contwingBlood		
        this.contwingBlood.setBoundLabelText(resHelper.getString("contwingBlood.boundLabelText"));		
        this.contwingBlood.setBoundLabelLength(120);		
        this.contwingBlood.setBoundLabelUnderline(true);		
        this.contwingBlood.setVisible(false);		
        this.contwingBlood.setForeground(new java.awt.Color(0,0,0));
        // contchickenUniform		
        this.contchickenUniform.setBoundLabelText(resHelper.getString("contchickenUniform.boundLabelText"));		
        this.contchickenUniform.setBoundLabelLength(120);		
        this.contchickenUniform.setBoundLabelUnderline(true);		
        this.contchickenUniform.setVisible(false);		
        this.contchickenUniform.setForeground(new java.awt.Color(0,0,0));
        // kDTabbedPane1
        // chkisBatchOver		
        this.chkisBatchOver.setText(resHelper.getString("chkisBatchOver.text"));		
        this.chkisBatchOver.setHorizontalAlignment(2);
        // contreportDate		
        this.contreportDate.setBoundLabelText(resHelper.getString("contreportDate.boundLabelText"));		
        this.contreportDate.setBoundLabelLength(100);		
        this.contreportDate.setBoundLabelUnderline(true);		
        this.contreportDate.setVisible(true);
        // contCarcassUniformity		
        this.contCarcassUniformity.setBoundLabelText(resHelper.getString("contCarcassUniformity.boundLabelText"));		
        this.contCarcassUniformity.setBoundLabelLength(120);		
        this.contCarcassUniformity.setBoundLabelUnderline(true);		
        this.contCarcassUniformity.setVisible(true);
        // contFIBizDate		
        this.contFIBizDate.setBoundLabelText(resHelper.getString("contFIBizDate.boundLabelText"));		
        this.contFIBizDate.setBoundLabelLength(100);		
        this.contFIBizDate.setBoundLabelUnderline(true);		
        this.contFIBizDate.setVisible(true);
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
        // BillStatus		
        this.BillStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.BillStatus.setRequired(false);		
        this.BillStatus.setEnabled(false);
        // prmtStorageOrgUnit		
        this.prmtStorageOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtStorageOrgUnit.setEditable(true);		
        this.prmtStorageOrgUnit.setDisplayFormat("$name$");		
        this.prmtStorageOrgUnit.setEditFormat("$number$");		
        this.prmtStorageOrgUnit.setCommitFormat("$number$");		
        this.prmtStorageOrgUnit.setRequired(true);
        // pkAuditTime		
        this.pkAuditTime.setRequired(false);		
        this.pkAuditTime.setEnabled(false);
        // prmtcompanyOrgUnit		
        this.prmtcompanyOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompanyOrgUnit.setEditable(true);		
        this.prmtcompanyOrgUnit.setDisplayFormat("$name$");		
        this.prmtcompanyOrgUnit.setEditFormat("$number$");		
        this.prmtcompanyOrgUnit.setCommitFormat("$number$");		
        this.prmtcompanyOrgUnit.setRequired(true);
        // txtPhysicalDeathQty		
        this.txtPhysicalDeathQty.setHorizontalAlignment(2);		
        this.txtPhysicalDeathQty.setDataType(1);		
        this.txtPhysicalDeathQty.setSupportedEmpty(true);		
        this.txtPhysicalDeathQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtPhysicalDeathQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtPhysicalDeathQty.setPrecision(4);		
        this.txtPhysicalDeathQty.setRequired(false);
        // txtPhysicalDeathWeight		
        this.txtPhysicalDeathWeight.setHorizontalAlignment(2);		
        this.txtPhysicalDeathWeight.setDataType(1);		
        this.txtPhysicalDeathWeight.setSupportedEmpty(true);		
        this.txtPhysicalDeathWeight.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtPhysicalDeathWeight.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtPhysicalDeathWeight.setPrecision(4);		
        this.txtPhysicalDeathWeight.setRequired(false);
        // txtCarcassQty		
        this.txtCarcassQty.setHorizontalAlignment(2);		
        this.txtCarcassQty.setDataType(1);		
        this.txtCarcassQty.setSupportedEmpty(true);		
        this.txtCarcassQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtCarcassQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtCarcassQty.setPrecision(4);		
        this.txtCarcassQty.setRequired(false);
        // txtCarcassWeight		
        this.txtCarcassWeight.setHorizontalAlignment(2);		
        this.txtCarcassWeight.setDataType(1);		
        this.txtCarcassWeight.setSupportedEmpty(true);		
        this.txtCarcassWeight.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtCarcassWeight.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtCarcassWeight.setPrecision(4);		
        this.txtCarcassWeight.setRequired(false);
        // prmtfarm		
        this.prmtfarm.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtfarm.setEditable(true);		
        this.prmtfarm.setDisplayFormat("$name$");		
        this.prmtfarm.setEditFormat("$number$");		
        this.prmtfarm.setCommitFormat("$number$");		
        this.prmtfarm.setRequired(true);
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
        // txtdryingChickenWeight		
        this.txtdryingChickenWeight.setHorizontalAlignment(2);		
        this.txtdryingChickenWeight.setDataType(1);		
        this.txtdryingChickenWeight.setSupportedEmpty(true);		
        this.txtdryingChickenWeight.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdryingChickenWeight.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdryingChickenWeight.setPrecision(4);		
        this.txtdryingChickenWeight.setRequired(false);
        // txtunCarcassWeight		
        this.txtunCarcassWeight.setHorizontalAlignment(2);		
        this.txtunCarcassWeight.setDataType(1);		
        this.txtunCarcassWeight.setSupportedEmpty(true);		
        this.txtunCarcassWeight.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtunCarcassWeight.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtunCarcassWeight.setPrecision(4);		
        this.txtunCarcassWeight.setRequired(false);
        // txtunCarcassQty		
        this.txtunCarcassQty.setHorizontalAlignment(2);		
        this.txtunCarcassQty.setDataType(1);		
        this.txtunCarcassQty.setSupportedEmpty(true);		
        this.txtunCarcassQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtunCarcassQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtunCarcassQty.setPrecision(4);		
        this.txtunCarcassQty.setRequired(false);
        // txtdryingChickenQty		
        this.txtdryingChickenQty.setHorizontalAlignment(2);		
        this.txtdryingChickenQty.setDataType(1);		
        this.txtdryingChickenQty.setSupportedEmpty(true);		
        this.txtdryingChickenQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdryingChickenQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdryingChickenQty.setPrecision(4);		
        this.txtdryingChickenQty.setRequired(false);
        // txtmainPWeight		
        this.txtmainPWeight.setHorizontalAlignment(2);		
        this.txtmainPWeight.setDataType(1);		
        this.txtmainPWeight.setSupportedEmpty(true);		
        this.txtmainPWeight.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmainPWeight.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmainPWeight.setPrecision(4);		
        this.txtmainPWeight.setRequired(false);
        // txtbyPWeight		
        this.txtbyPWeight.setHorizontalAlignment(2);		
        this.txtbyPWeight.setDataType(1);		
        this.txtbyPWeight.setSupportedEmpty(true);		
        this.txtbyPWeight.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbyPWeight.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbyPWeight.setPrecision(4);		
        this.txtbyPWeight.setRequired(false);
        // txtachickenclaw		
        this.txtachickenclaw.setHorizontalAlignment(2);		
        this.txtachickenclaw.setDataType(1);		
        this.txtachickenclaw.setSupportedEmpty(true);		
        this.txtachickenclaw.setMinimumValue( new java.math.BigDecimal("-9.999999999E7"));		
        this.txtachickenclaw.setMaximumValue( new java.math.BigDecimal("9.999999999E7"));		
        this.txtachickenclaw.setPrecision(2);		
        this.txtachickenclaw.setRequired(false);
        // txtdermatitis		
        this.txtdermatitis.setHorizontalAlignment(2);		
        this.txtdermatitis.setDataType(1);		
        this.txtdermatitis.setSupportedEmpty(true);		
        this.txtdermatitis.setMinimumValue( new java.math.BigDecimal("-9.999999999E7"));		
        this.txtdermatitis.setMaximumValue( new java.math.BigDecimal("9.999999999E7"));		
        this.txtdermatitis.setPrecision(2);		
        this.txtdermatitis.setRequired(false);
        // txtgizzardsFood		
        this.txtgizzardsFood.setHorizontalAlignment(2);		
        this.txtgizzardsFood.setDataType(1);		
        this.txtgizzardsFood.setSupportedEmpty(true);		
        this.txtgizzardsFood.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtgizzardsFood.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtgizzardsFood.setPrecision(4);		
        this.txtgizzardsFood.setRequired(false);
        // txtwingBlood		
        this.txtwingBlood.setHorizontalAlignment(2);		
        this.txtwingBlood.setDataType(1);		
        this.txtwingBlood.setSupportedEmpty(true);		
        this.txtwingBlood.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtwingBlood.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtwingBlood.setPrecision(4);		
        this.txtwingBlood.setRequired(false);
        // txtchickenUniform		
        this.txtchickenUniform.setHorizontalAlignment(2);		
        this.txtchickenUniform.setDataType(1);		
        this.txtchickenUniform.setSupportedEmpty(true);		
        this.txtchickenUniform.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchickenUniform.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchickenUniform.setPrecision(4);		
        this.txtchickenUniform.setRequired(false);
        // kDPanel1
        // kDPanel2
        // kdtBodyEntry
		String kdtBodyEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"henHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"dermatitis\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"chickenclaw\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"swingBlood\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"gizzardsFood\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"gizzardCondition\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"chickenUniform\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{henHouse}</t:Cell><t:Cell>$Resource{dermatitis}</t:Cell><t:Cell>$Resource{chickenclaw}</t:Cell><t:Cell>$Resource{swingBlood}</t:Cell><t:Cell>$Resource{gizzardsFood}</t:Cell><t:Cell>$Resource{gizzardCondition}</t:Cell><t:Cell>$Resource{chickenUniform}</t:Cell><t:Cell>$Resource{remark}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtBodyEntry.setFormatXml(resHelper.translateString("kdtBodyEntry",kdtBodyEntryStrXML));

                this.kdtBodyEntry.putBindContents("editData",new String[] {"seq","henHouse","dermatitis","chickenclaw","swingBlood","gizzardsFood","gizzardCondition","chickenUniform","remark"});


        this.kdtBodyEntry.checkParsed();
        KDFormattedTextField kdtBodyEntry_seq_TextField = new KDFormattedTextField();
        kdtBodyEntry_seq_TextField.setName("kdtBodyEntry_seq_TextField");
        kdtBodyEntry_seq_TextField.setVisible(true);
        kdtBodyEntry_seq_TextField.setEditable(true);
        kdtBodyEntry_seq_TextField.setHorizontalAlignment(2);
        kdtBodyEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtBodyEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtBodyEntry_seq_TextField);
        this.kdtBodyEntry.getColumn("seq").setEditor(kdtBodyEntry_seq_CellEditor);
        final KDBizPromptBox kdtBodyEntry_henHouse_PromptBox = new KDBizPromptBox();
        kdtBodyEntry_henHouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseF7Query");
        kdtBodyEntry_henHouse_PromptBox.setVisible(true);
        kdtBodyEntry_henHouse_PromptBox.setEditable(true);
        kdtBodyEntry_henHouse_PromptBox.setDisplayFormat("$number$");
        kdtBodyEntry_henHouse_PromptBox.setEditFormat("$number$");
        kdtBodyEntry_henHouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtBodyEntry_henHouse_CellEditor = new KDTDefaultCellEditor(kdtBodyEntry_henHouse_PromptBox);
        this.kdtBodyEntry.getColumn("henHouse").setEditor(kdtBodyEntry_henHouse_CellEditor);
        ObjectValueRender kdtBodyEntry_henHouse_OVR = new ObjectValueRender();
        kdtBodyEntry_henHouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtBodyEntry.getColumn("henHouse").setRenderer(kdtBodyEntry_henHouse_OVR);
        KDFormattedTextField kdtBodyEntry_dermatitis_TextField = new KDFormattedTextField();
        kdtBodyEntry_dermatitis_TextField.setName("kdtBodyEntry_dermatitis_TextField");
        kdtBodyEntry_dermatitis_TextField.setVisible(true);
        kdtBodyEntry_dermatitis_TextField.setEditable(true);
        kdtBodyEntry_dermatitis_TextField.setHorizontalAlignment(2);
        kdtBodyEntry_dermatitis_TextField.setDataType(1);
        	kdtBodyEntry_dermatitis_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtBodyEntry_dermatitis_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtBodyEntry_dermatitis_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtBodyEntry_dermatitis_CellEditor = new KDTDefaultCellEditor(kdtBodyEntry_dermatitis_TextField);
        this.kdtBodyEntry.getColumn("dermatitis").setEditor(kdtBodyEntry_dermatitis_CellEditor);
        KDFormattedTextField kdtBodyEntry_chickenclaw_TextField = new KDFormattedTextField();
        kdtBodyEntry_chickenclaw_TextField.setName("kdtBodyEntry_chickenclaw_TextField");
        kdtBodyEntry_chickenclaw_TextField.setVisible(true);
        kdtBodyEntry_chickenclaw_TextField.setEditable(true);
        kdtBodyEntry_chickenclaw_TextField.setHorizontalAlignment(2);
        kdtBodyEntry_chickenclaw_TextField.setDataType(1);
        	kdtBodyEntry_chickenclaw_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtBodyEntry_chickenclaw_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtBodyEntry_chickenclaw_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtBodyEntry_chickenclaw_CellEditor = new KDTDefaultCellEditor(kdtBodyEntry_chickenclaw_TextField);
        this.kdtBodyEntry.getColumn("chickenclaw").setEditor(kdtBodyEntry_chickenclaw_CellEditor);
        KDFormattedTextField kdtBodyEntry_swingBlood_TextField = new KDFormattedTextField();
        kdtBodyEntry_swingBlood_TextField.setName("kdtBodyEntry_swingBlood_TextField");
        kdtBodyEntry_swingBlood_TextField.setVisible(true);
        kdtBodyEntry_swingBlood_TextField.setEditable(true);
        kdtBodyEntry_swingBlood_TextField.setHorizontalAlignment(2);
        kdtBodyEntry_swingBlood_TextField.setDataType(1);
        	kdtBodyEntry_swingBlood_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtBodyEntry_swingBlood_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtBodyEntry_swingBlood_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtBodyEntry_swingBlood_CellEditor = new KDTDefaultCellEditor(kdtBodyEntry_swingBlood_TextField);
        this.kdtBodyEntry.getColumn("swingBlood").setEditor(kdtBodyEntry_swingBlood_CellEditor);
        KDFormattedTextField kdtBodyEntry_gizzardsFood_TextField = new KDFormattedTextField();
        kdtBodyEntry_gizzardsFood_TextField.setName("kdtBodyEntry_gizzardsFood_TextField");
        kdtBodyEntry_gizzardsFood_TextField.setVisible(true);
        kdtBodyEntry_gizzardsFood_TextField.setEditable(true);
        kdtBodyEntry_gizzardsFood_TextField.setHorizontalAlignment(2);
        kdtBodyEntry_gizzardsFood_TextField.setDataType(1);
        	kdtBodyEntry_gizzardsFood_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtBodyEntry_gizzardsFood_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtBodyEntry_gizzardsFood_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtBodyEntry_gizzardsFood_CellEditor = new KDTDefaultCellEditor(kdtBodyEntry_gizzardsFood_TextField);
        this.kdtBodyEntry.getColumn("gizzardsFood").setEditor(kdtBodyEntry_gizzardsFood_CellEditor);
        KDFormattedTextField kdtBodyEntry_gizzardCondition_TextField = new KDFormattedTextField();
        kdtBodyEntry_gizzardCondition_TextField.setName("kdtBodyEntry_gizzardCondition_TextField");
        kdtBodyEntry_gizzardCondition_TextField.setVisible(true);
        kdtBodyEntry_gizzardCondition_TextField.setEditable(true);
        kdtBodyEntry_gizzardCondition_TextField.setHorizontalAlignment(2);
        kdtBodyEntry_gizzardCondition_TextField.setDataType(1);
        	kdtBodyEntry_gizzardCondition_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtBodyEntry_gizzardCondition_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtBodyEntry_gizzardCondition_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtBodyEntry_gizzardCondition_CellEditor = new KDTDefaultCellEditor(kdtBodyEntry_gizzardCondition_TextField);
        this.kdtBodyEntry.getColumn("gizzardCondition").setEditor(kdtBodyEntry_gizzardCondition_CellEditor);
        KDFormattedTextField kdtBodyEntry_chickenUniform_TextField = new KDFormattedTextField();
        kdtBodyEntry_chickenUniform_TextField.setName("kdtBodyEntry_chickenUniform_TextField");
        kdtBodyEntry_chickenUniform_TextField.setVisible(true);
        kdtBodyEntry_chickenUniform_TextField.setEditable(true);
        kdtBodyEntry_chickenUniform_TextField.setHorizontalAlignment(2);
        kdtBodyEntry_chickenUniform_TextField.setDataType(1);
        	kdtBodyEntry_chickenUniform_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtBodyEntry_chickenUniform_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtBodyEntry_chickenUniform_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtBodyEntry_chickenUniform_CellEditor = new KDTDefaultCellEditor(kdtBodyEntry_chickenUniform_TextField);
        this.kdtBodyEntry.getColumn("chickenUniform").setEditor(kdtBodyEntry_chickenUniform_CellEditor);
        KDTextField kdtBodyEntry_remark_TextField = new KDTextField();
        kdtBodyEntry_remark_TextField.setName("kdtBodyEntry_remark_TextField");
        kdtBodyEntry_remark_TextField.setMaxLength(250);
        KDTDefaultCellEditor kdtBodyEntry_remark_CellEditor = new KDTDefaultCellEditor(kdtBodyEntry_remark_TextField);
        this.kdtBodyEntry.getColumn("remark").setEditor(kdtBodyEntry_remark_CellEditor);
        // kdtCarCassEntry
		String kdtCarCassEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"weight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"proportion\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{weight}</t:Cell><t:Cell>$Resource{proportion}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtCarCassEntry.setFormatXml(resHelper.translateString("kdtCarCassEntry",kdtCarCassEntryStrXML));

                this.kdtCarCassEntry.putBindContents("editData",new String[] {"seq","weight","proportion"});


        this.kdtCarCassEntry.checkParsed();
        KDFormattedTextField kdtCarCassEntry_seq_TextField = new KDFormattedTextField();
        kdtCarCassEntry_seq_TextField.setName("kdtCarCassEntry_seq_TextField");
        kdtCarCassEntry_seq_TextField.setVisible(true);
        kdtCarCassEntry_seq_TextField.setEditable(true);
        kdtCarCassEntry_seq_TextField.setHorizontalAlignment(2);
        kdtCarCassEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtCarCassEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtCarCassEntry_seq_TextField);
        this.kdtCarCassEntry.getColumn("seq").setEditor(kdtCarCassEntry_seq_CellEditor);
        KDTextField kdtCarCassEntry_weight_TextField = new KDTextField();
        kdtCarCassEntry_weight_TextField.setName("kdtCarCassEntry_weight_TextField");
        kdtCarCassEntry_weight_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtCarCassEntry_weight_CellEditor = new KDTDefaultCellEditor(kdtCarCassEntry_weight_TextField);
        this.kdtCarCassEntry.getColumn("weight").setEditor(kdtCarCassEntry_weight_CellEditor);
        KDFormattedTextField kdtCarCassEntry_proportion_TextField = new KDFormattedTextField();
        kdtCarCassEntry_proportion_TextField.setName("kdtCarCassEntry_proportion_TextField");
        kdtCarCassEntry_proportion_TextField.setVisible(true);
        kdtCarCassEntry_proportion_TextField.setEditable(true);
        kdtCarCassEntry_proportion_TextField.setHorizontalAlignment(2);
        kdtCarCassEntry_proportion_TextField.setDataType(1);
        	kdtCarCassEntry_proportion_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtCarCassEntry_proportion_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtCarCassEntry_proportion_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtCarCassEntry_proportion_CellEditor = new KDTDefaultCellEditor(kdtCarCassEntry_proportion_TextField);
        this.kdtCarCassEntry.getColumn("proportion").setEditor(kdtCarCassEntry_proportion_CellEditor);
        // pkreportDate		
        this.pkreportDate.setRequired(false);
        // txtCarcassUniformity		
        this.txtCarcassUniformity.setVisible(true);		
        this.txtCarcassUniformity.setHorizontalAlignment(2);		
        this.txtCarcassUniformity.setDataType(1);		
        this.txtCarcassUniformity.setSupportedEmpty(true);		
        this.txtCarcassUniformity.setMinimumValue( new java.math.BigDecimal("-9.999999999E7"));		
        this.txtCarcassUniformity.setMaximumValue( new java.math.BigDecimal("9.999999999E7"));		
        this.txtCarcassUniformity.setPrecision(2);		
        this.txtCarcassUniformity.setRequired(false);
        // pkFIBizDate		
        this.pkFIBizDate.setVisible(true);		
        this.pkFIBizDate.setRequired(false);
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
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,BillStatus,prmtStorageOrgUnit,pkAuditTime,prmtcompanyOrgUnit,txtPhysicalDeathQty,txtPhysicalDeathWeight,txtCarcassQty,txtCarcassWeight,prmtfarm,txtdryingChickenQty,txtdryingChickenWeight,txtunCarcassQty,txtunCarcassWeight,txtmainPWeight,txtbyPWeight,txtdermatitis,txtachickenclaw,txtwingBlood,txtgizzardsFood,txtchickenUniform,chkisBatchOver,pkreportDate,kdtCarCassEntry,kdtBodyEntry,txtCarcassUniformity,pkFIBizDate}));
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
        this.setBounds(new Rectangle(0, 0, 1064, 605));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1064, 605));
        contCreator.setBounds(new Rectangle(10, 538, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(10, 538, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(10, 562, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(10, 562, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(706, 538, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(706, 538, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateTime.setBounds(new Rectangle(706, 562, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(706, 562, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(10, 5, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(10, 5, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(358, 5, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(358, 5, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(10, 76, 618, 19));
        this.add(contDescription, new KDLayout.Constraints(10, 76, 618, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(358, 538, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(358, 538, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBillStatus.setBounds(new Rectangle(706, 5, 270, 19));
        this.add(contBillStatus, new KDLayout.Constraints(706, 5, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contStorageOrgUnit.setBounds(new Rectangle(706, 29, 270, 19));
        this.add(contStorageOrgUnit, new KDLayout.Constraints(706, 29, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditTime.setBounds(new Rectangle(358, 562, 270, 19));
        this.add(contAuditTime, new KDLayout.Constraints(358, 562, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompanyOrgUnit.setBounds(new Rectangle(358, 29, 270, 19));
        this.add(contcompanyOrgUnit, new KDLayout.Constraints(358, 29, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contPhysicalDeathQty.setBounds(new Rectangle(10, 154, 270, 19));
        this.add(contPhysicalDeathQty, new KDLayout.Constraints(10, 154, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contPhysicalDeathWeight.setBounds(new Rectangle(10, 178, 270, 19));
        this.add(contPhysicalDeathWeight, new KDLayout.Constraints(10, 178, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCarcassQty.setBounds(new Rectangle(358, 106, 270, 19));
        this.add(contCarcassQty, new KDLayout.Constraints(358, 106, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCarcassWeight.setBounds(new Rectangle(358, 130, 270, 19));
        this.add(contCarcassWeight, new KDLayout.Constraints(358, 130, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator8.setBounds(new Rectangle(10, 99, 975, 8));
        this.add(kDSeparator8, new KDLayout.Constraints(10, 99, 975, 8, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator9.setBounds(new Rectangle(10, 514, 984, 8));
        this.add(kDSeparator9, new KDLayout.Constraints(10, 514, 984, 8, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contfarm.setBounds(new Rectangle(10, 29, 270, 19));
        this.add(contfarm, new KDLayout.Constraints(10, 29, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdryingChickenWeight.setBounds(new Rectangle(10, 130, 270, 19));
        this.add(contdryingChickenWeight, new KDLayout.Constraints(10, 130, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contunCarcassWeight.setBounds(new Rectangle(358, 178, 270, 19));
        this.add(contunCarcassWeight, new KDLayout.Constraints(358, 178, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contunCarcassQty.setBounds(new Rectangle(358, 154, 270, 19));
        this.add(contunCarcassQty, new KDLayout.Constraints(358, 154, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdryingChickenQty.setBounds(new Rectangle(10, 106, 270, 19));
        this.add(contdryingChickenQty, new KDLayout.Constraints(10, 106, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmainPWeight.setBounds(new Rectangle(706, 106, 270, 19));
        this.add(contmainPWeight, new KDLayout.Constraints(706, 106, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbyPWeight.setBounds(new Rectangle(706, 130, 270, 19));
        this.add(contbyPWeight, new KDLayout.Constraints(706, 130, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contachickenclaw.setBounds(new Rectangle(10, 490, 270, 19));
        this.add(contachickenclaw, new KDLayout.Constraints(10, 490, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdermatitis.setBounds(new Rectangle(10, 466, 270, 19));
        this.add(contdermatitis, new KDLayout.Constraints(10, 466, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contgizzardsFood.setBounds(new Rectangle(358, 490, 270, 19));
        this.add(contgizzardsFood, new KDLayout.Constraints(358, 490, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contwingBlood.setBounds(new Rectangle(358, 466, 270, 19));
        this.add(contwingBlood, new KDLayout.Constraints(358, 466, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contchickenUniform.setBounds(new Rectangle(706, 466, 270, 19));
        this.add(contchickenUniform, new KDLayout.Constraints(706, 466, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDTabbedPane1.setBounds(new Rectangle(10, 202, 965, 264));
        this.add(kDTabbedPane1, new KDLayout.Constraints(10, 202, 965, 264, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        chkisBatchOver.setBounds(new Rectangle(10, 53, 270, 19));
        this.add(chkisBatchOver, new KDLayout.Constraints(10, 53, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contreportDate.setBounds(new Rectangle(358, 53, 270, 19));
        this.add(contreportDate, new KDLayout.Constraints(358, 53, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCarcassUniformity.setBounds(new Rectangle(705, 154, 270, 19));
        this.add(contCarcassUniformity, new KDLayout.Constraints(705, 154, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contFIBizDate.setBounds(new Rectangle(706, 53, 270, 19));
        this.add(contFIBizDate, new KDLayout.Constraints(706, 53, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //contBillStatus
        contBillStatus.setBoundEditor(BillStatus);
        //contStorageOrgUnit
        contStorageOrgUnit.setBoundEditor(prmtStorageOrgUnit);
        //contAuditTime
        contAuditTime.setBoundEditor(pkAuditTime);
        //contcompanyOrgUnit
        contcompanyOrgUnit.setBoundEditor(prmtcompanyOrgUnit);
        //contPhysicalDeathQty
        contPhysicalDeathQty.setBoundEditor(txtPhysicalDeathQty);
        //contPhysicalDeathWeight
        contPhysicalDeathWeight.setBoundEditor(txtPhysicalDeathWeight);
        //contCarcassQty
        contCarcassQty.setBoundEditor(txtCarcassQty);
        //contCarcassWeight
        contCarcassWeight.setBoundEditor(txtCarcassWeight);
        //contfarm
        contfarm.setBoundEditor(prmtfarm);
        //contdryingChickenWeight
        contdryingChickenWeight.setBoundEditor(txtdryingChickenWeight);
        //contunCarcassWeight
        contunCarcassWeight.setBoundEditor(txtunCarcassWeight);
        //contunCarcassQty
        contunCarcassQty.setBoundEditor(txtunCarcassQty);
        //contdryingChickenQty
        contdryingChickenQty.setBoundEditor(txtdryingChickenQty);
        //contmainPWeight
        contmainPWeight.setBoundEditor(txtmainPWeight);
        //contbyPWeight
        contbyPWeight.setBoundEditor(txtbyPWeight);
        //contachickenclaw
        contachickenclaw.setBoundEditor(txtachickenclaw);
        //contdermatitis
        contdermatitis.setBoundEditor(txtdermatitis);
        //contgizzardsFood
        contgizzardsFood.setBoundEditor(txtgizzardsFood);
        //contwingBlood
        contwingBlood.setBoundEditor(txtwingBlood);
        //contchickenUniform
        contchickenUniform.setBoundEditor(txtchickenUniform);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 964, 231));        kdtBodyEntry.setBounds(new Rectangle(1, 1, 956, 229));
        kdtBodyEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtBodyEntry,new com.kingdee.eas.farm.food.ChickenDailyBodyEntryInfo(),null,false);
        kDPanel1.add(kdtBodyEntry_detailPanel, new KDLayout.Constraints(1, 1, 956, 229, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 964, 231));        kdtCarCassEntry.setBounds(new Rectangle(2, 2, 955, 228));
        kdtCarCassEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtCarCassEntry,new com.kingdee.eas.farm.food.ChickenDailyCarCassEntryInfo(),null,false);
        kDPanel2.add(kdtCarCassEntry_detailPanel, new KDLayout.Constraints(2, 2, 955, 228, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contreportDate
        contreportDate.setBoundEditor(pkreportDate);
        //contCarcassUniformity
        contCarcassUniformity.setBoundEditor(txtCarcassUniformity);
        //contFIBizDate
        contFIBizDate.setBoundEditor(pkFIBizDate);

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
		dataBinder.registerBinding("isBatchOver", boolean.class, this.chkisBatchOver, "selected");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("BillStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.BillStatus, "selectedItem");
		dataBinder.registerBinding("StorageOrgUnit", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtStorageOrgUnit, "data");
		dataBinder.registerBinding("AuditTime", java.util.Date.class, this.pkAuditTime, "value");
		dataBinder.registerBinding("companyOrgUnit", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompanyOrgUnit, "data");
		dataBinder.registerBinding("PhysicalDeathQty", java.math.BigDecimal.class, this.txtPhysicalDeathQty, "value");
		dataBinder.registerBinding("PhysicalDeathWeight", java.math.BigDecimal.class, this.txtPhysicalDeathWeight, "value");
		dataBinder.registerBinding("CarcassQty", java.math.BigDecimal.class, this.txtCarcassQty, "value");
		dataBinder.registerBinding("CarcassWeight", java.math.BigDecimal.class, this.txtCarcassWeight, "value");
		dataBinder.registerBinding("farm", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtfarm, "data");
		dataBinder.registerBinding("dryingChickenWeight", java.math.BigDecimal.class, this.txtdryingChickenWeight, "value");
		dataBinder.registerBinding("unCarcassWeight", java.math.BigDecimal.class, this.txtunCarcassWeight, "value");
		dataBinder.registerBinding("unCarcassQty", java.math.BigDecimal.class, this.txtunCarcassQty, "value");
		dataBinder.registerBinding("dryingChickenQty", java.math.BigDecimal.class, this.txtdryingChickenQty, "value");
		dataBinder.registerBinding("mainPWeight", java.math.BigDecimal.class, this.txtmainPWeight, "value");
		dataBinder.registerBinding("byPWeight", java.math.BigDecimal.class, this.txtbyPWeight, "value");
		dataBinder.registerBinding("achickenclaw", java.math.BigDecimal.class, this.txtachickenclaw, "value");
		dataBinder.registerBinding("dermatitis", java.math.BigDecimal.class, this.txtdermatitis, "value");
		dataBinder.registerBinding("gizzardsFood", java.math.BigDecimal.class, this.txtgizzardsFood, "value");
		dataBinder.registerBinding("wingBlood", java.math.BigDecimal.class, this.txtwingBlood, "value");
		dataBinder.registerBinding("chickenUniform", java.math.BigDecimal.class, this.txtchickenUniform, "value");
		dataBinder.registerBinding("BodyEntry.seq", int.class, this.kdtBodyEntry, "seq.text");
		dataBinder.registerBinding("BodyEntry", com.kingdee.eas.farm.food.ChickenDailyBodyEntryInfo.class, this.kdtBodyEntry, "userObject");
		dataBinder.registerBinding("BodyEntry.henHouse", java.lang.Object.class, this.kdtBodyEntry, "henHouse.text");
		dataBinder.registerBinding("BodyEntry.dermatitis", java.math.BigDecimal.class, this.kdtBodyEntry, "dermatitis.text");
		dataBinder.registerBinding("BodyEntry.chickenclaw", java.math.BigDecimal.class, this.kdtBodyEntry, "chickenclaw.text");
		dataBinder.registerBinding("BodyEntry.swingBlood", java.math.BigDecimal.class, this.kdtBodyEntry, "swingBlood.text");
		dataBinder.registerBinding("BodyEntry.gizzardsFood", java.math.BigDecimal.class, this.kdtBodyEntry, "gizzardsFood.text");
		dataBinder.registerBinding("BodyEntry.chickenUniform", java.math.BigDecimal.class, this.kdtBodyEntry, "chickenUniform.text");
		dataBinder.registerBinding("BodyEntry.remark", String.class, this.kdtBodyEntry, "remark.text");
		dataBinder.registerBinding("BodyEntry.gizzardCondition", java.math.BigDecimal.class, this.kdtBodyEntry, "gizzardCondition.text");
		dataBinder.registerBinding("CarCassEntry.seq", int.class, this.kdtCarCassEntry, "seq.text");
		dataBinder.registerBinding("CarCassEntry", com.kingdee.eas.farm.food.ChickenDailyCarCassEntryInfo.class, this.kdtCarCassEntry, "userObject");
		dataBinder.registerBinding("CarCassEntry.weight", String.class, this.kdtCarCassEntry, "weight.text");
		dataBinder.registerBinding("CarCassEntry.proportion", java.math.BigDecimal.class, this.kdtCarCassEntry, "proportion.text");
		dataBinder.registerBinding("reportDate", java.util.Date.class, this.pkreportDate, "value");
		dataBinder.registerBinding("CarcassUniformity", java.math.BigDecimal.class, this.txtCarcassUniformity, "value");
		dataBinder.registerBinding("FIBizDate", java.util.Date.class, this.pkFIBizDate, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.food.app.ChickenDailyEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.food.ChickenDailyInfo)ov;
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
		getValidateHelper().registerBindProperty("isBatchOver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BillStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StorageOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AuditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("companyOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PhysicalDeathQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PhysicalDeathWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CarcassQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CarcassWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dryingChickenWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("unCarcassWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("unCarcassQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dryingChickenQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mainPWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("byPWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("achickenclaw", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dermatitis", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("gizzardsFood", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("wingBlood", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenUniform", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BodyEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BodyEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BodyEntry.henHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BodyEntry.dermatitis", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BodyEntry.chickenclaw", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BodyEntry.swingBlood", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BodyEntry.gizzardsFood", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BodyEntry.chickenUniform", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BodyEntry.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BodyEntry.gizzardCondition", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CarCassEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CarCassEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CarCassEntry.weight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CarCassEntry.proportion", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("reportDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CarcassUniformity", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FIBizDate", ValidateHelper.ON_SAVE);    		
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
     * output prmtfarm_dataChanged method
     */
    protected void prmtfarm_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
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
        sic.add(new SelectorItemInfo("isBatchOver"));
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
        sic.add(new SelectorItemInfo("BillStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("StorageOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("StorageOrgUnit.id"));
        	sic.add(new SelectorItemInfo("StorageOrgUnit.number"));
        	sic.add(new SelectorItemInfo("StorageOrgUnit.name"));
		}
        sic.add(new SelectorItemInfo("AuditTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("companyOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("companyOrgUnit.id"));
        	sic.add(new SelectorItemInfo("companyOrgUnit.number"));
        	sic.add(new SelectorItemInfo("companyOrgUnit.name"));
		}
        sic.add(new SelectorItemInfo("PhysicalDeathQty"));
        sic.add(new SelectorItemInfo("PhysicalDeathWeight"));
        sic.add(new SelectorItemInfo("CarcassQty"));
        sic.add(new SelectorItemInfo("CarcassWeight"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("farm.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farm.id"));
        	sic.add(new SelectorItemInfo("farm.number"));
        	sic.add(new SelectorItemInfo("farm.name"));
		}
        sic.add(new SelectorItemInfo("dryingChickenWeight"));
        sic.add(new SelectorItemInfo("unCarcassWeight"));
        sic.add(new SelectorItemInfo("unCarcassQty"));
        sic.add(new SelectorItemInfo("dryingChickenQty"));
        sic.add(new SelectorItemInfo("mainPWeight"));
        sic.add(new SelectorItemInfo("byPWeight"));
        sic.add(new SelectorItemInfo("achickenclaw"));
        sic.add(new SelectorItemInfo("dermatitis"));
        sic.add(new SelectorItemInfo("gizzardsFood"));
        sic.add(new SelectorItemInfo("wingBlood"));
        sic.add(new SelectorItemInfo("chickenUniform"));
    	sic.add(new SelectorItemInfo("BodyEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("BodyEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("BodyEntry.henHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("BodyEntry.henHouse.id"));
			sic.add(new SelectorItemInfo("BodyEntry.henHouse.name"));
        	sic.add(new SelectorItemInfo("BodyEntry.henHouse.number"));
		}
    	sic.add(new SelectorItemInfo("BodyEntry.dermatitis"));
    	sic.add(new SelectorItemInfo("BodyEntry.chickenclaw"));
    	sic.add(new SelectorItemInfo("BodyEntry.swingBlood"));
    	sic.add(new SelectorItemInfo("BodyEntry.gizzardsFood"));
    	sic.add(new SelectorItemInfo("BodyEntry.chickenUniform"));
    	sic.add(new SelectorItemInfo("BodyEntry.remark"));
    	sic.add(new SelectorItemInfo("BodyEntry.gizzardCondition"));
    	sic.add(new SelectorItemInfo("CarCassEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("CarCassEntry.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("CarCassEntry.weight"));
    	sic.add(new SelectorItemInfo("CarCassEntry.proportion"));
        sic.add(new SelectorItemInfo("reportDate"));
        sic.add(new SelectorItemInfo("CarcassUniformity"));
        sic.add(new SelectorItemInfo("FIBizDate"));
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
        com.kingdee.eas.farm.food.ChickenDailyFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.food.ChickenDailyFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractChickenDailyEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractChickenDailyEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.food.client", "ChickenDailyEditUI");
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
        return com.kingdee.eas.farm.food.client.ChickenDailyEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.food.ChickenDailyFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.food.ChickenDailyInfo objectValue = new com.kingdee.eas.farm.food.ChickenDailyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/food/ChickenDaily";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.food.app.ChickenDailyQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtStorageOrgUnit.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"库存组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompanyOrgUnit.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtfarm.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖场"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtBodyEntry;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}