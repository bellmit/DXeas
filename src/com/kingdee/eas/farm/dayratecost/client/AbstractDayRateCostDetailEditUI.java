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
public abstract class AbstractDayRateCostDetailEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractDayRateCostDetailEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator9;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcostCentor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperiod;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthouse;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisInit;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisStageBalance;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstockingBatch;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedStage;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcostCentor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperiod;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarm;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmthouse;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtDetail;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtDetail_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbeginBreedQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoccurBreedQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contendBreedQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweek;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweekDay;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbeginBreedQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoccurBreedQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtendBreedQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtweek;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtweekDay;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallArAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallArAmount;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstockingBatch;
    protected com.kingdee.bos.ctrl.swing.KDComboBox breedStage;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDSeparator newSeparator3;
    protected com.kingdee.eas.farm.dayratecost.DayRateCostDetailInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractDayRateCostDetailEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractDayRateCostDetailEditUI.class.getName());
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
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDSeparator9 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contcostCentor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperiod = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthouse = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisInit = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisStageBalance = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contstockingBatch = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbreedStage = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtcostCentor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtperiod = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtfarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtfarmer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmthouse = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtDetail = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contbeginBreedQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoccurBreedQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contendBreedQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweek = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweekDay = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtbeginBreedQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtoccurBreedQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtendBreedQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtweek = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtweekDay = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.contallArAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtallArAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtstockingBatch = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.breedStage = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.tBtnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.mBtnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.mBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.newSeparator3 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contAuditor.setName("contAuditor");
        this.contcompany.setName("contcompany");
        this.contauditTime.setName("contauditTime");
        this.kDSeparator8.setName("kDSeparator8");
        this.kDSeparator9.setName("kDSeparator9");
        this.contcostCentor.setName("contcostCentor");
        this.contperiod.setName("contperiod");
        this.contfarm.setName("contfarm");
        this.contfarmer.setName("contfarmer");
        this.conthouse.setName("conthouse");
        this.chkisInit.setName("chkisInit");
        this.chkisStageBalance.setName("chkisStageBalance");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contstockingBatch.setName("contstockingBatch");
        this.contbreedStage.setName("contbreedStage");
        this.contbillStatus.setName("contbillStatus");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtcompany.setName("prmtcompany");
        this.pkauditTime.setName("pkauditTime");
        this.prmtcostCentor.setName("prmtcostCentor");
        this.prmtperiod.setName("prmtperiod");
        this.prmtfarm.setName("prmtfarm");
        this.prmtfarmer.setName("prmtfarmer");
        this.prmthouse.setName("prmthouse");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel3.setName("kDPanel3");
        this.kdtEntrys.setName("kdtEntrys");
        this.kdtDetail.setName("kdtDetail");
        this.contbeginBreedQty.setName("contbeginBreedQty");
        this.contoccurBreedQty.setName("contoccurBreedQty");
        this.contendBreedQty.setName("contendBreedQty");
        this.contweek.setName("contweek");
        this.contweekDay.setName("contweekDay");
        this.contDescription.setName("contDescription");
        this.txtbeginBreedQty.setName("txtbeginBreedQty");
        this.txtoccurBreedQty.setName("txtoccurBreedQty");
        this.txtendBreedQty.setName("txtendBreedQty");
        this.txtweek.setName("txtweek");
        this.txtweekDay.setName("txtweekDay");
        this.txtDescription.setName("txtDescription");
        this.contallArAmount.setName("contallArAmount");
        this.txtallArAmount.setName("txtallArAmount");
        this.prmtstockingBatch.setName("prmtstockingBatch");
        this.breedStage.setName("breedStage");
        this.billStatus.setName("billStatus");
        this.tBtnAudit.setName("tBtnAudit");
        this.tBtnUnAudit.setName("tBtnUnAudit");
        this.mBtnAudit.setName("mBtnAudit");
        this.mBtnUnAudit.setName("mBtnUnAudit");
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
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);
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
        // contcostCentor		
        this.contcostCentor.setBoundLabelText(resHelper.getString("contcostCentor.boundLabelText"));		
        this.contcostCentor.setBoundLabelLength(100);		
        this.contcostCentor.setBoundLabelUnderline(true);		
        this.contcostCentor.setVisible(true);
        // contperiod		
        this.contperiod.setBoundLabelText(resHelper.getString("contperiod.boundLabelText"));		
        this.contperiod.setBoundLabelLength(100);		
        this.contperiod.setBoundLabelUnderline(true);		
        this.contperiod.setVisible(true);
        // contfarm		
        this.contfarm.setBoundLabelText(resHelper.getString("contfarm.boundLabelText"));		
        this.contfarm.setBoundLabelLength(100);		
        this.contfarm.setBoundLabelUnderline(true);		
        this.contfarm.setVisible(true);
        // contfarmer		
        this.contfarmer.setBoundLabelText(resHelper.getString("contfarmer.boundLabelText"));		
        this.contfarmer.setBoundLabelLength(100);		
        this.contfarmer.setBoundLabelUnderline(true);		
        this.contfarmer.setVisible(true);
        // conthouse		
        this.conthouse.setBoundLabelText(resHelper.getString("conthouse.boundLabelText"));		
        this.conthouse.setBoundLabelLength(100);		
        this.conthouse.setBoundLabelUnderline(true);		
        this.conthouse.setVisible(true);
        // chkisInit		
        this.chkisInit.setText(resHelper.getString("chkisInit.text"));		
        this.chkisInit.setHorizontalAlignment(2);
        // chkisStageBalance		
        this.chkisStageBalance.setText(resHelper.getString("chkisStageBalance.text"));		
        this.chkisStageBalance.setHorizontalAlignment(2);
        // kDTabbedPane1
        // contstockingBatch		
        this.contstockingBatch.setBoundLabelText(resHelper.getString("contstockingBatch.boundLabelText"));		
        this.contstockingBatch.setBoundLabelLength(100);		
        this.contstockingBatch.setBoundLabelUnderline(true);		
        this.contstockingBatch.setVisible(true);
        // contbreedStage		
        this.contbreedStage.setBoundLabelText(resHelper.getString("contbreedStage.boundLabelText"));		
        this.contbreedStage.setBoundLabelLength(100);		
        this.contbreedStage.setBoundLabelUnderline(true);		
        this.contbreedStage.setVisible(true);
        // contbillStatus		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);
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
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
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
        // prmtcostCentor		
        this.prmtcostCentor.setQueryInfo("com.kingdee.eas.basedata.org.app.CostCenterItemQuery");		
        this.prmtcostCentor.setEditable(true);		
        this.prmtcostCentor.setDisplayFormat("$name$");		
        this.prmtcostCentor.setEditFormat("$number$");		
        this.prmtcostCentor.setCommitFormat("$number$");		
        this.prmtcostCentor.setRequired(true);
        // prmtperiod		
        this.prmtperiod.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7PeriodQuery");		
        this.prmtperiod.setEditable(true);		
        this.prmtperiod.setDisplayFormat("$number$");		
        this.prmtperiod.setEditFormat("$number$");		
        this.prmtperiod.setCommitFormat("$number$");		
        this.prmtperiod.setRequired(true);
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
					
        // prmthouse		
        this.prmthouse.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmQuery");		
        this.prmthouse.setEditable(true);		
        this.prmthouse.setDisplayFormat("$name$");		
        this.prmthouse.setEditFormat("$number$");		
        this.prmthouse.setCommitFormat("$number$");		
        this.prmthouse.setRequired(false);
        		prmthouse.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmListUI prmthouse_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmthouse_F7ListUI == null) {
					try {
						prmthouse_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmthouse_F7ListUI));
					prmthouse_F7ListUI.setF7Use(true,ctx);
					prmthouse.setSelector(prmthouse_F7ListUI);
				}
			}
		});
					
        // kDPanel1
        // kDPanel2
        // kDPanel3
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"costItem\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"beginCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"unitBeginCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"occurQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"occurCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"endCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"unitEndCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{costItem}</t:Cell><t:Cell>$Resource{beginCost}</t:Cell><t:Cell>$Resource{unitBeginCost}</t:Cell><t:Cell>$Resource{occurQty}</t:Cell><t:Cell>$Resource{occurCost}</t:Cell><t:Cell>$Resource{endCost}</t:Cell><t:Cell>$Resource{unitEndCost}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));

                this.kdtEntrys.putBindContents("editData",new String[] {"id","costItem","beginCost","unitBeginCost","occurQty","occurCost","endCost","unitEndCost"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_costItem_PromptBox = new KDBizPromptBox();
        kdtEntrys_costItem_PromptBox.setQueryInfo("com.kingdee.eas.basedata.cm.app.F7CostItemQuery");
        kdtEntrys_costItem_PromptBox.setVisible(true);
        kdtEntrys_costItem_PromptBox.setEditable(true);
        kdtEntrys_costItem_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_costItem_PromptBox.setEditFormat("$number$");
        kdtEntrys_costItem_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_costItem_CellEditor = new KDTDefaultCellEditor(kdtEntrys_costItem_PromptBox);
        this.kdtEntrys.getColumn("costItem").setEditor(kdtEntrys_costItem_CellEditor);
        ObjectValueRender kdtEntrys_costItem_OVR = new ObjectValueRender();
        kdtEntrys_costItem_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("costItem").setRenderer(kdtEntrys_costItem_OVR);
        KDFormattedTextField kdtEntrys_beginCost_TextField = new KDFormattedTextField();
        kdtEntrys_beginCost_TextField.setName("kdtEntrys_beginCost_TextField");
        kdtEntrys_beginCost_TextField.setVisible(true);
        kdtEntrys_beginCost_TextField.setEditable(true);
        kdtEntrys_beginCost_TextField.setHorizontalAlignment(2);
        kdtEntrys_beginCost_TextField.setDataType(1);
        	kdtEntrys_beginCost_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_beginCost_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_beginCost_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_beginCost_CellEditor = new KDTDefaultCellEditor(kdtEntrys_beginCost_TextField);
        this.kdtEntrys.getColumn("beginCost").setEditor(kdtEntrys_beginCost_CellEditor);
        KDFormattedTextField kdtEntrys_unitBeginCost_TextField = new KDFormattedTextField();
        kdtEntrys_unitBeginCost_TextField.setName("kdtEntrys_unitBeginCost_TextField");
        kdtEntrys_unitBeginCost_TextField.setVisible(true);
        kdtEntrys_unitBeginCost_TextField.setEditable(true);
        kdtEntrys_unitBeginCost_TextField.setHorizontalAlignment(2);
        kdtEntrys_unitBeginCost_TextField.setDataType(1);
        	kdtEntrys_unitBeginCost_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_unitBeginCost_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_unitBeginCost_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_unitBeginCost_CellEditor = new KDTDefaultCellEditor(kdtEntrys_unitBeginCost_TextField);
        this.kdtEntrys.getColumn("unitBeginCost").setEditor(kdtEntrys_unitBeginCost_CellEditor);
        KDFormattedTextField kdtEntrys_occurQty_TextField = new KDFormattedTextField();
        kdtEntrys_occurQty_TextField.setName("kdtEntrys_occurQty_TextField");
        kdtEntrys_occurQty_TextField.setVisible(true);
        kdtEntrys_occurQty_TextField.setEditable(true);
        kdtEntrys_occurQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_occurQty_TextField.setDataType(1);
        	kdtEntrys_occurQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_occurQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_occurQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_occurQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_occurQty_TextField);
        this.kdtEntrys.getColumn("occurQty").setEditor(kdtEntrys_occurQty_CellEditor);
        KDFormattedTextField kdtEntrys_occurCost_TextField = new KDFormattedTextField();
        kdtEntrys_occurCost_TextField.setName("kdtEntrys_occurCost_TextField");
        kdtEntrys_occurCost_TextField.setVisible(true);
        kdtEntrys_occurCost_TextField.setEditable(true);
        kdtEntrys_occurCost_TextField.setHorizontalAlignment(2);
        kdtEntrys_occurCost_TextField.setDataType(1);
        	kdtEntrys_occurCost_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_occurCost_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_occurCost_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_occurCost_CellEditor = new KDTDefaultCellEditor(kdtEntrys_occurCost_TextField);
        this.kdtEntrys.getColumn("occurCost").setEditor(kdtEntrys_occurCost_CellEditor);
        KDFormattedTextField kdtEntrys_endCost_TextField = new KDFormattedTextField();
        kdtEntrys_endCost_TextField.setName("kdtEntrys_endCost_TextField");
        kdtEntrys_endCost_TextField.setVisible(true);
        kdtEntrys_endCost_TextField.setEditable(true);
        kdtEntrys_endCost_TextField.setHorizontalAlignment(2);
        kdtEntrys_endCost_TextField.setDataType(1);
        	kdtEntrys_endCost_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_endCost_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_endCost_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_endCost_CellEditor = new KDTDefaultCellEditor(kdtEntrys_endCost_TextField);
        this.kdtEntrys.getColumn("endCost").setEditor(kdtEntrys_endCost_CellEditor);
        KDFormattedTextField kdtEntrys_unitEndCost_TextField = new KDFormattedTextField();
        kdtEntrys_unitEndCost_TextField.setName("kdtEntrys_unitEndCost_TextField");
        kdtEntrys_unitEndCost_TextField.setVisible(true);
        kdtEntrys_unitEndCost_TextField.setEditable(true);
        kdtEntrys_unitEndCost_TextField.setHorizontalAlignment(2);
        kdtEntrys_unitEndCost_TextField.setDataType(1);
        	kdtEntrys_unitEndCost_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_unitEndCost_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_unitEndCost_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_unitEndCost_CellEditor = new KDTDefaultCellEditor(kdtEntrys_unitEndCost_TextField);
        this.kdtEntrys.getColumn("unitEndCost").setEditor(kdtEntrys_unitEndCost_CellEditor);
        // kdtDetail
		String kdtDetailStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"itemID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"2\" t:styleID=\"sCol1\" /><t:Column t:key=\"itemNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"3\" /><t:Column t:key=\"itemName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" /><t:Column t:key=\"costObject\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" /><t:Column t:key=\"baseUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" /><t:Column t:key=\"baseQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"6\" t:styleID=\"sCol6\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"7\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" t:styleID=\"sCol8\" /><t:Column t:key=\"cost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"9\" t:styleID=\"sCol9\" /><t:Column t:key=\"unitCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"10\" t:styleID=\"sCol10\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"headID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{itemID}</t:Cell><t:Cell>$Resource{itemNum}</t:Cell><t:Cell>$Resource{itemName}</t:Cell><t:Cell>$Resource{costObject}</t:Cell><t:Cell>$Resource{baseUnit}</t:Cell><t:Cell>$Resource{baseQty}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{cost}</t:Cell><t:Cell>$Resource{unitCost}</t:Cell><t:Cell>$Resource{remark}</t:Cell><t:Cell>$Resource{headID}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtDetail.setFormatXml(resHelper.translateString("kdtDetail",kdtDetailStrXML));

                this.kdtDetail.putBindContents("editData",new String[] {"Detail.seq","Detail.itemID","Detail.itemNum","Detail.itemName","Detail.costObject","Detail.baseUnit","Detail.baseQty","Detail.unit","Detail.qty","Detail.cost","Detail.unitCost","Detail.remark","Detail.headID"});


        this.kdtDetail.checkParsed();
        KDFormattedTextField kdtDetail_seq_TextField = new KDFormattedTextField();
        kdtDetail_seq_TextField.setName("kdtDetail_seq_TextField");
        kdtDetail_seq_TextField.setVisible(true);
        kdtDetail_seq_TextField.setEditable(true);
        kdtDetail_seq_TextField.setHorizontalAlignment(2);
        kdtDetail_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtDetail_seq_CellEditor = new KDTDefaultCellEditor(kdtDetail_seq_TextField);
        this.kdtDetail.getColumn("seq").setEditor(kdtDetail_seq_CellEditor);
        KDTextField kdtDetail_itemID_TextField = new KDTextField();
        kdtDetail_itemID_TextField.setName("kdtDetail_itemID_TextField");
        kdtDetail_itemID_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtDetail_itemID_CellEditor = new KDTDefaultCellEditor(kdtDetail_itemID_TextField);
        this.kdtDetail.getColumn("itemID").setEditor(kdtDetail_itemID_CellEditor);
        KDTextField kdtDetail_itemNum_TextField = new KDTextField();
        kdtDetail_itemNum_TextField.setName("kdtDetail_itemNum_TextField");
        kdtDetail_itemNum_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtDetail_itemNum_CellEditor = new KDTDefaultCellEditor(kdtDetail_itemNum_TextField);
        this.kdtDetail.getColumn("itemNum").setEditor(kdtDetail_itemNum_CellEditor);
        KDTextField kdtDetail_itemName_TextField = new KDTextField();
        kdtDetail_itemName_TextField.setName("kdtDetail_itemName_TextField");
        kdtDetail_itemName_TextField.setMaxLength(200);
        KDTDefaultCellEditor kdtDetail_itemName_CellEditor = new KDTDefaultCellEditor(kdtDetail_itemName_TextField);
        this.kdtDetail.getColumn("itemName").setEditor(kdtDetail_itemName_CellEditor);
        final KDBizPromptBox kdtDetail_costObject_PromptBox = new KDBizPromptBox();
        kdtDetail_costObject_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");
        kdtDetail_costObject_PromptBox.setVisible(true);
        kdtDetail_costObject_PromptBox.setEditable(true);
        kdtDetail_costObject_PromptBox.setDisplayFormat("$number$");
        kdtDetail_costObject_PromptBox.setEditFormat("$number$");
        kdtDetail_costObject_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtDetail_costObject_CellEditor = new KDTDefaultCellEditor(kdtDetail_costObject_PromptBox);
        this.kdtDetail.getColumn("costObject").setEditor(kdtDetail_costObject_CellEditor);
        ObjectValueRender kdtDetail_costObject_OVR = new ObjectValueRender();
        kdtDetail_costObject_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtDetail.getColumn("costObject").setRenderer(kdtDetail_costObject_OVR);
        final KDBizPromptBox kdtDetail_baseUnit_PromptBox = new KDBizPromptBox();
        kdtDetail_baseUnit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtDetail_baseUnit_PromptBox.setVisible(true);
        kdtDetail_baseUnit_PromptBox.setEditable(true);
        kdtDetail_baseUnit_PromptBox.setDisplayFormat("$number$");
        kdtDetail_baseUnit_PromptBox.setEditFormat("$number$");
        kdtDetail_baseUnit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtDetail_baseUnit_CellEditor = new KDTDefaultCellEditor(kdtDetail_baseUnit_PromptBox);
        this.kdtDetail.getColumn("baseUnit").setEditor(kdtDetail_baseUnit_CellEditor);
        ObjectValueRender kdtDetail_baseUnit_OVR = new ObjectValueRender();
        kdtDetail_baseUnit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtDetail.getColumn("baseUnit").setRenderer(kdtDetail_baseUnit_OVR);
        KDFormattedTextField kdtDetail_baseQty_TextField = new KDFormattedTextField();
        kdtDetail_baseQty_TextField.setName("kdtDetail_baseQty_TextField");
        kdtDetail_baseQty_TextField.setVisible(true);
        kdtDetail_baseQty_TextField.setEditable(true);
        kdtDetail_baseQty_TextField.setHorizontalAlignment(2);
        kdtDetail_baseQty_TextField.setDataType(1);
        	kdtDetail_baseQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtDetail_baseQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtDetail_baseQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtDetail_baseQty_CellEditor = new KDTDefaultCellEditor(kdtDetail_baseQty_TextField);
        this.kdtDetail.getColumn("baseQty").setEditor(kdtDetail_baseQty_CellEditor);
        final KDBizPromptBox kdtDetail_unit_PromptBox = new KDBizPromptBox();
        kdtDetail_unit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtDetail_unit_PromptBox.setVisible(true);
        kdtDetail_unit_PromptBox.setEditable(true);
        kdtDetail_unit_PromptBox.setDisplayFormat("$number$");
        kdtDetail_unit_PromptBox.setEditFormat("$number$");
        kdtDetail_unit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtDetail_unit_CellEditor = new KDTDefaultCellEditor(kdtDetail_unit_PromptBox);
        this.kdtDetail.getColumn("unit").setEditor(kdtDetail_unit_CellEditor);
        ObjectValueRender kdtDetail_unit_OVR = new ObjectValueRender();
        kdtDetail_unit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtDetail.getColumn("unit").setRenderer(kdtDetail_unit_OVR);
        KDFormattedTextField kdtDetail_qty_TextField = new KDFormattedTextField();
        kdtDetail_qty_TextField.setName("kdtDetail_qty_TextField");
        kdtDetail_qty_TextField.setVisible(true);
        kdtDetail_qty_TextField.setEditable(true);
        kdtDetail_qty_TextField.setHorizontalAlignment(2);
        kdtDetail_qty_TextField.setDataType(1);
        	kdtDetail_qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtDetail_qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtDetail_qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtDetail_qty_CellEditor = new KDTDefaultCellEditor(kdtDetail_qty_TextField);
        this.kdtDetail.getColumn("qty").setEditor(kdtDetail_qty_CellEditor);
        KDFormattedTextField kdtDetail_cost_TextField = new KDFormattedTextField();
        kdtDetail_cost_TextField.setName("kdtDetail_cost_TextField");
        kdtDetail_cost_TextField.setVisible(true);
        kdtDetail_cost_TextField.setEditable(true);
        kdtDetail_cost_TextField.setHorizontalAlignment(2);
        kdtDetail_cost_TextField.setDataType(1);
        	kdtDetail_cost_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtDetail_cost_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtDetail_cost_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtDetail_cost_CellEditor = new KDTDefaultCellEditor(kdtDetail_cost_TextField);
        this.kdtDetail.getColumn("cost").setEditor(kdtDetail_cost_CellEditor);
        KDFormattedTextField kdtDetail_unitCost_TextField = new KDFormattedTextField();
        kdtDetail_unitCost_TextField.setName("kdtDetail_unitCost_TextField");
        kdtDetail_unitCost_TextField.setVisible(true);
        kdtDetail_unitCost_TextField.setEditable(true);
        kdtDetail_unitCost_TextField.setHorizontalAlignment(2);
        kdtDetail_unitCost_TextField.setDataType(1);
        	kdtDetail_unitCost_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtDetail_unitCost_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtDetail_unitCost_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtDetail_unitCost_CellEditor = new KDTDefaultCellEditor(kdtDetail_unitCost_TextField);
        this.kdtDetail.getColumn("unitCost").setEditor(kdtDetail_unitCost_CellEditor);
        // contbeginBreedQty		
        this.contbeginBreedQty.setBoundLabelText(resHelper.getString("contbeginBreedQty.boundLabelText"));		
        this.contbeginBreedQty.setBoundLabelLength(100);		
        this.contbeginBreedQty.setBoundLabelUnderline(true);		
        this.contbeginBreedQty.setVisible(true);
        // contoccurBreedQty		
        this.contoccurBreedQty.setBoundLabelText(resHelper.getString("contoccurBreedQty.boundLabelText"));		
        this.contoccurBreedQty.setBoundLabelLength(100);		
        this.contoccurBreedQty.setBoundLabelUnderline(true);		
        this.contoccurBreedQty.setVisible(true);
        // contendBreedQty		
        this.contendBreedQty.setBoundLabelText(resHelper.getString("contendBreedQty.boundLabelText"));		
        this.contendBreedQty.setBoundLabelLength(100);		
        this.contendBreedQty.setBoundLabelUnderline(true);		
        this.contendBreedQty.setVisible(true);
        // contweek		
        this.contweek.setBoundLabelText(resHelper.getString("contweek.boundLabelText"));		
        this.contweek.setBoundLabelLength(100);		
        this.contweek.setBoundLabelUnderline(true);		
        this.contweek.setVisible(true);
        // contweekDay		
        this.contweekDay.setBoundLabelText(resHelper.getString("contweekDay.boundLabelText"));		
        this.contweekDay.setBoundLabelLength(100);		
        this.contweekDay.setBoundLabelUnderline(true);		
        this.contweekDay.setVisible(true);
        // contDescription		
        this.contDescription.setBoundLabelText(resHelper.getString("contDescription.boundLabelText"));		
        this.contDescription.setBoundLabelLength(100);		
        this.contDescription.setBoundLabelUnderline(true);
        // txtbeginBreedQty		
        this.txtbeginBreedQty.setHorizontalAlignment(2);		
        this.txtbeginBreedQty.setDataType(0);		
        this.txtbeginBreedQty.setSupportedEmpty(true);		
        this.txtbeginBreedQty.setRequired(false);
        // txtoccurBreedQty		
        this.txtoccurBreedQty.setHorizontalAlignment(2);		
        this.txtoccurBreedQty.setDataType(0);		
        this.txtoccurBreedQty.setSupportedEmpty(true);		
        this.txtoccurBreedQty.setRequired(false);
        // txtendBreedQty		
        this.txtendBreedQty.setHorizontalAlignment(2);		
        this.txtendBreedQty.setDataType(0);		
        this.txtendBreedQty.setSupportedEmpty(true);		
        this.txtendBreedQty.setRequired(false);
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
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // contallArAmount		
        this.contallArAmount.setBoundLabelText(resHelper.getString("contallArAmount.boundLabelText"));		
        this.contallArAmount.setBoundLabelLength(100);		
        this.contallArAmount.setBoundLabelUnderline(true);		
        this.contallArAmount.setVisible(true);
        // txtallArAmount		
        this.txtallArAmount.setHorizontalAlignment(2);		
        this.txtallArAmount.setDataType(1);		
        this.txtallArAmount.setSupportedEmpty(true);		
        this.txtallArAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallArAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallArAmount.setPrecision(2);		
        this.txtallArAmount.setRequired(false);
        // prmtstockingBatch		
        this.prmtstockingBatch.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.StockingBatchQuery");		
        this.prmtstockingBatch.setEditable(true);		
        this.prmtstockingBatch.setDisplayFormat("$number$");		
        this.prmtstockingBatch.setEditFormat("$number$");		
        this.prmtstockingBatch.setCommitFormat("$number$");		
        this.prmtstockingBatch.setRequired(false);
        		prmtstockingBatch.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI prmtstockingBatch_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtstockingBatch_F7ListUI == null) {
					try {
						prmtstockingBatch_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtstockingBatch_F7ListUI));
					prmtstockingBatch_F7ListUI.setF7Use(true,ctx);
					prmtstockingBatch.setSelector(prmtstockingBatch_F7ListUI);
				}
			}
		});
					
        // breedStage		
        this.breedStage.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.FarmStageEnum").toArray());		
        this.breedStage.setRequired(false);
        // billStatus		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
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
        // newSeparator3
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {kdtDetail,txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,prmtcompany,pkauditTime,prmtcostCentor,prmtperiod,txtweekDay,txtweek,txtbeginBreedQty,txtoccurBreedQty,txtendBreedQty,prmtfarmer,prmtfarm,prmthouse,chkisInit,chkisStageBalance,prmtstockingBatch,breedStage,txtallArAmount,billStatus,kdtEntrys}));
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
        contCreator.setBounds(new Rectangle(379, 545, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(379, 545, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(730, 545, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(730, 545, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(379, 577, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(379, 577, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(730, 577, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(730, 577, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(20, 14, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(20, 14, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(363, 14, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(363, 14, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(29, 545, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(29, 545, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompany.setBounds(new Rectangle(20, 43, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(20, 43, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(29, 577, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(29, 577, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator8.setBounds(new Rectangle(18, 527, 980, 10));
        this.add(kDSeparator8, new KDLayout.Constraints(18, 527, 980, 10, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator9.setBounds(new Rectangle(6, 124, 986, 8));
        this.add(kDSeparator9, new KDLayout.Constraints(6, 124, 986, 8, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contcostCentor.setBounds(new Rectangle(363, 43, 270, 19));
        this.add(contcostCentor, new KDLayout.Constraints(363, 43, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contperiod.setBounds(new Rectangle(707, 43, 270, 19));
        this.add(contperiod, new KDLayout.Constraints(707, 43, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfarm.setBounds(new Rectangle(363, 72, 270, 19));
        this.add(contfarm, new KDLayout.Constraints(363, 72, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmer.setBounds(new Rectangle(20, 72, 270, 19));
        this.add(contfarmer, new KDLayout.Constraints(20, 72, 270, 19, 0));
        conthouse.setBounds(new Rectangle(707, 72, 270, 19));
        this.add(conthouse, new KDLayout.Constraints(707, 72, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkisInit.setBounds(new Rectangle(707, 101, 90, 19));
        this.add(chkisInit, new KDLayout.Constraints(707, 101, 90, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisStageBalance.setBounds(new Rectangle(851, 101, 126, 19));
        this.add(chkisStageBalance, new KDLayout.Constraints(851, 101, 126, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane1.setBounds(new Rectangle(17, 132, 973, 387));
        this.add(kDTabbedPane1, new KDLayout.Constraints(17, 132, 973, 387, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contstockingBatch.setBounds(new Rectangle(20, 101, 270, 19));
        this.add(contstockingBatch, new KDLayout.Constraints(20, 101, 270, 19, 0));
        contbreedStage.setBounds(new Rectangle(363, 101, 270, 19));
        this.add(contbreedStage, new KDLayout.Constraints(363, 101, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(707, 14, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(707, 14, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contcostCentor
        contcostCentor.setBoundEditor(prmtcostCentor);
        //contperiod
        contperiod.setBoundEditor(prmtperiod);
        //contfarm
        contfarm.setBoundEditor(prmtfarm);
        //contfarmer
        contfarmer.setBoundEditor(prmtfarmer);
        //conthouse
        conthouse.setBoundEditor(prmthouse);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 972, 354));        kdtEntrys.setBounds(new Rectangle(5, 5, 954, 150));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.dayratecost.DayRateCostDetailEntryInfo(),null,false);
        kDPanel1.add(kdtEntrys_detailPanel, new KDLayout.Constraints(5, 5, 954, 150, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kdtDetail.setBounds(new Rectangle(5, 165, 945, 178));
        kdtDetail_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtDetail,new com.kingdee.eas.farm.dayratecost.DayRateCostDetailEntryDetailInfo(),null,false);
        kDPanel1.add(kdtDetail_detailPanel, new KDLayout.Constraints(5, 165, 945, 178, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 972, 354));        contbeginBreedQty.setBounds(new Rectangle(14, 18, 270, 19));
        kDPanel2.add(contbeginBreedQty, new KDLayout.Constraints(14, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoccurBreedQty.setBounds(new Rectangle(365, 18, 270, 19));
        kDPanel2.add(contoccurBreedQty, new KDLayout.Constraints(365, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contendBreedQty.setBounds(new Rectangle(684, 18, 270, 19));
        kDPanel2.add(contendBreedQty, new KDLayout.Constraints(684, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contweek.setBounds(new Rectangle(14, 50, 270, 19));
        kDPanel2.add(contweek, new KDLayout.Constraints(14, 50, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contweekDay.setBounds(new Rectangle(365, 50, 270, 19));
        kDPanel2.add(contweekDay, new KDLayout.Constraints(365, 50, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(14, 84, 270, 19));
        kDPanel2.add(contDescription, new KDLayout.Constraints(14, 84, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contbeginBreedQty
        contbeginBreedQty.setBoundEditor(txtbeginBreedQty);
        //contoccurBreedQty
        contoccurBreedQty.setBoundEditor(txtoccurBreedQty);
        //contendBreedQty
        contendBreedQty.setBoundEditor(txtendBreedQty);
        //contweek
        contweek.setBoundEditor(txtweek);
        //contweekDay
        contweekDay.setBoundEditor(txtweekDay);
        //contDescription
        contDescription.setBoundEditor(txtDescription);
        //kDPanel3
        kDPanel3.setLayout(new KDLayout());
        kDPanel3.putClientProperty("OriginalBounds", new Rectangle(0, 0, 972, 354));        contallArAmount.setBounds(new Rectangle(19, 14, 270, 19));
        kDPanel3.add(contallArAmount, new KDLayout.Constraints(19, 14, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contallArAmount
        contallArAmount.setBoundEditor(txtallArAmount);
        //contstockingBatch
        contstockingBatch.setBoundEditor(prmtstockingBatch);
        //contbreedStage
        contbreedStage.setBoundEditor(breedStage);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);

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
		dataBinder.registerBinding("isInit", boolean.class, this.chkisInit, "selected");
		dataBinder.registerBinding("isStageBalance", boolean.class, this.chkisStageBalance, "selected");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("costCentor", com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo.class, this.prmtcostCentor, "data");
		dataBinder.registerBinding("period", com.kingdee.eas.basedata.assistant.PeriodInfo.class, this.prmtperiod, "data");
		dataBinder.registerBinding("farm", com.kingdee.eas.farm.stocking.basedata.FarmInfo.class, this.prmtfarm, "data");
		dataBinder.registerBinding("farmer", com.kingdee.eas.farm.stocking.basedata.FarmersInfo.class, this.prmtfarmer, "data");
		dataBinder.registerBinding("house", com.kingdee.eas.farm.stocking.basedata.FarmInfo.class, this.prmthouse, "data");
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.dayratecost.DayRateCostDetailEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.beginCost", java.math.BigDecimal.class, this.kdtEntrys, "beginCost.text");
		dataBinder.registerBinding("entrys.endCost", java.math.BigDecimal.class, this.kdtEntrys, "endCost.text");
		dataBinder.registerBinding("entrys.occurCost", java.math.BigDecimal.class, this.kdtEntrys, "occurCost.text");
		dataBinder.registerBinding("entrys.unitEndCost", java.math.BigDecimal.class, this.kdtEntrys, "unitEndCost.text");
		dataBinder.registerBinding("entrys.unitBeginCost", java.math.BigDecimal.class, this.kdtEntrys, "unitBeginCost.text");
		dataBinder.registerBinding("entrys.occurQty", java.math.BigDecimal.class, this.kdtEntrys, "occurQty.text");
		dataBinder.registerBinding("entrys.costItem", java.lang.Object.class, this.kdtEntrys, "costItem.text");
		dataBinder.registerBinding("entrys.Detail.seq", int.class, this.kdtDetail, "seq.text");
		dataBinder.registerBinding("entrys.Detail", com.kingdee.eas.farm.dayratecost.DayRateCostDetailEntryDetailInfo.class, this.kdtDetail, "userObject");
		dataBinder.registerBinding("entrys.Detail.itemID", String.class, this.kdtDetail, "itemID.text");
		dataBinder.registerBinding("entrys.Detail.itemNum", String.class, this.kdtDetail, "itemNum.text");
		dataBinder.registerBinding("entrys.Detail.itemName", String.class, this.kdtDetail, "itemName.text");
		dataBinder.registerBinding("entrys.Detail.qty", java.math.BigDecimal.class, this.kdtDetail, "qty.text");
		dataBinder.registerBinding("entrys.Detail.cost", java.math.BigDecimal.class, this.kdtDetail, "cost.text");
		dataBinder.registerBinding("entrys.Detail.unitCost", java.math.BigDecimal.class, this.kdtDetail, "unitCost.text");
		dataBinder.registerBinding("entrys.Detail.costObject", java.lang.Object.class, this.kdtDetail, "costObject.text");
		dataBinder.registerBinding("entrys.Detail.baseQty", java.math.BigDecimal.class, this.kdtDetail, "baseQty.text");
		dataBinder.registerBinding("entrys.Detail.unit", java.lang.Object.class, this.kdtDetail, "unit.text");
		dataBinder.registerBinding("entrys.Detail.baseUnit", java.lang.Object.class, this.kdtDetail, "baseUnit.text");
		dataBinder.registerBinding("entrys.Detail.remark", String.class, this.kdtDetail, "remark.text");
		dataBinder.registerBinding("entrys.Detail.headID", String.class, this.kdtDetail, "headID.text");
		dataBinder.registerBinding("beginBreedQty", int.class, this.txtbeginBreedQty, "value");
		dataBinder.registerBinding("occurBreedQty", int.class, this.txtoccurBreedQty, "value");
		dataBinder.registerBinding("endBreedQty", int.class, this.txtendBreedQty, "value");
		dataBinder.registerBinding("week", int.class, this.txtweek, "value");
		dataBinder.registerBinding("weekDay", int.class, this.txtweekDay, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("allArAmount", java.math.BigDecimal.class, this.txtallArAmount, "value");
		dataBinder.registerBinding("stockingBatch", com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo.class, this.prmtstockingBatch, "data");
		dataBinder.registerBinding("breedStage", com.kingdee.eas.farm.stocking.basedata.FarmStageEnum.class, this.breedStage, "selectedItem");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.billStatus, "selectedItem");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.dayratecost.app.DayRateCostDetailEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.dayratecost.DayRateCostDetailInfo)ov;
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
		getValidateHelper().registerBindProperty("isInit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isStageBalance", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("costCentor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("period", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("house", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.beginCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.endCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.occurCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.unitEndCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.unitBeginCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.occurQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.costItem", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.itemID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.itemNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.itemName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.cost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.unitCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.costObject", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.baseQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.baseUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.Detail.headID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("beginBreedQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("occurBreedQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("endBreedQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("week", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("weekDay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allArAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("stockingBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedStage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("isInit"));
        sic.add(new SelectorItemInfo("isStageBalance"));
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
			sic.add(new SelectorItemInfo("costCentor.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("costCentor.id"));
        	sic.add(new SelectorItemInfo("costCentor.number"));
        	sic.add(new SelectorItemInfo("costCentor.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("period.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("period.id"));
        	sic.add(new SelectorItemInfo("period.number"));
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
			sic.add(new SelectorItemInfo("farmer.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farmer.id"));
        	sic.add(new SelectorItemInfo("farmer.number"));
        	sic.add(new SelectorItemInfo("farmer.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("house.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("house.id"));
        	sic.add(new SelectorItemInfo("house.number"));
        	sic.add(new SelectorItemInfo("house.name"));
		}
    	sic.add(new SelectorItemInfo("entrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("entrys.beginCost"));
    	sic.add(new SelectorItemInfo("entrys.endCost"));
    	sic.add(new SelectorItemInfo("entrys.occurCost"));
    	sic.add(new SelectorItemInfo("entrys.unitEndCost"));
    	sic.add(new SelectorItemInfo("entrys.unitBeginCost"));
    	sic.add(new SelectorItemInfo("entrys.occurQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.costItem.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.costItem.id"));
			sic.add(new SelectorItemInfo("entrys.costItem.name"));
        	sic.add(new SelectorItemInfo("entrys.costItem.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.Detail.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.Detail.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.Detail.id"));
		}
    	sic.add(new SelectorItemInfo("entrys.Detail.itemID"));
    	sic.add(new SelectorItemInfo("entrys.Detail.itemNum"));
    	sic.add(new SelectorItemInfo("entrys.Detail.itemName"));
    	sic.add(new SelectorItemInfo("entrys.Detail.qty"));
    	sic.add(new SelectorItemInfo("entrys.Detail.cost"));
    	sic.add(new SelectorItemInfo("entrys.Detail.unitCost"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.Detail.costObject.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.Detail.costObject.id"));
			sic.add(new SelectorItemInfo("entrys.Detail.costObject.name"));
        	sic.add(new SelectorItemInfo("entrys.Detail.costObject.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.Detail.baseQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.Detail.unit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.Detail.unit.id"));
			sic.add(new SelectorItemInfo("entrys.Detail.unit.name"));
        	sic.add(new SelectorItemInfo("entrys.Detail.unit.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.Detail.baseUnit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.Detail.baseUnit.id"));
			sic.add(new SelectorItemInfo("entrys.Detail.baseUnit.name"));
        	sic.add(new SelectorItemInfo("entrys.Detail.baseUnit.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.Detail.remark"));
    	sic.add(new SelectorItemInfo("entrys.Detail.headID"));
        sic.add(new SelectorItemInfo("beginBreedQty"));
        sic.add(new SelectorItemInfo("occurBreedQty"));
        sic.add(new SelectorItemInfo("endBreedQty"));
        sic.add(new SelectorItemInfo("week"));
        sic.add(new SelectorItemInfo("weekDay"));
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("allArAmount"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("stockingBatch.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("stockingBatch.id"));
        	sic.add(new SelectorItemInfo("stockingBatch.number"));
        	sic.add(new SelectorItemInfo("stockingBatch.name"));
		}
        sic.add(new SelectorItemInfo("breedStage"));
        sic.add(new SelectorItemInfo("billStatus"));
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
        com.kingdee.eas.farm.dayratecost.DayRateCostDetailFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.dayratecost.DayRateCostDetailFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractDayRateCostDetailEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractDayRateCostDetailEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.dayratecost.client", "DayRateCostDetailEditUI");
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
        return com.kingdee.eas.farm.dayratecost.client.DayRateCostDetailEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.dayratecost.DayRateCostDetailFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.dayratecost.DayRateCostDetailInfo objectValue = new com.kingdee.eas.farm.dayratecost.DayRateCostDetailInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/dayratecost/DayRateCostDetail";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.dayratecost.app.DayRateCostDetailQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcostCentor.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"成本中心"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtperiod.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"期间"});
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
		vo.put("breedStage",new Integer(1));
vo.put("billStatus",new Integer(-1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}