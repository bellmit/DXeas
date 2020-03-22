/**
 * output package name
 */
package com.kingdee.eas.farm.hatch.client;

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
public abstract class AbstractBEggHatchBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractBEggHatchBillEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthatchFactory;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallHatchQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contincubator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoperator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteggType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthatchArea;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contadminOrg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthatchHouse;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoutArea;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisHasBEggCanding;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBEggCandingDate;
    protected com.kingdee.bos.ctrl.swing.KDButton btnViewSummary;
    protected com.kingdee.bos.ctrl.swing.KDButton btnExcel;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtComputeEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtComputeEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgenderType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contStorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisMaterialOut;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisInventory;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmthatchFactory;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEggEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEggEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contRows;
    protected com.kingdee.bos.ctrl.swing.KDButton btnAddRow;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtAddRows;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtHatchBoxSummaryEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtHatchBoxSummaryEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallHatchQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtincubator;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtoperator;
    protected com.kingdee.bos.ctrl.swing.KDComboBox eggType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmthatchArea;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtadminOrg;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmthatchHouse;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtoutArea;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBEggCandingDate;
    protected com.kingdee.bos.ctrl.swing.KDRadioButton radioHorizon;
    protected com.kingdee.bos.ctrl.swing.KDRadioButton radioVertical;
    protected com.kingdee.bos.ctrl.swing.KDRadioButton radioOrigin;
    protected com.kingdee.bos.ctrl.swing.KDComboBox genderType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtStorageOrgUnit;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtAreaSummaryEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtAreaSummaryEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAdjust;
    protected com.kingdee.eas.farm.hatch.BEggHatchBillInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionAdjust actionAdjust = null;
    /**
     * output class constructor
     */
    public AbstractBEggHatchBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractBEggHatchBillEditUI.class.getName());
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
        //actionAdjust
        this.actionAdjust = new ActionAdjust(this);
        getActionManager().registerAction("actionAdjust", actionAdjust);
        this.actionAdjust.setExtendProperty("canForewarn", "true");
        this.actionAdjust.setExtendProperty("userDefined", "false");
        this.actionAdjust.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAdjust.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAdjust.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthatchFactory = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane2 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contallHatchQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contincubator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoperator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteggType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthatchArea = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contadminOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthatchHouse = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoutArea = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisHasBEggCanding = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contBEggCandingDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnViewSummary = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnExcel = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtComputeEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contgenderType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contStorageOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisMaterialOut = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.chkisInventory = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmthatchFactory = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEggEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contRows = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnAddRow = new com.kingdee.bos.ctrl.swing.KDButton();
        this.txtAddRows = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kdtHatchBoxSummaryEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.txtallHatchQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtincubator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtoperator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.eggType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmthatchArea = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtadminOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmthatchHouse = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtoutArea = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkBEggCandingDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.radioHorizon = new com.kingdee.bos.ctrl.swing.KDRadioButton();
        this.radioVertical = new com.kingdee.bos.ctrl.swing.KDRadioButton();
        this.radioOrigin = new com.kingdee.bos.ctrl.swing.KDRadioButton();
        this.genderType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtStorageOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kdtAreaSummaryEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnAdjust = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.contauditTime.setName("contauditTime");
        this.contbaseStatus.setName("contbaseStatus");
        this.conthatchFactory.setName("conthatchFactory");
        this.kDTabbedPane2.setName("kDTabbedPane2");
        this.contallHatchQty.setName("contallHatchQty");
        this.contincubator.setName("contincubator");
        this.contoperator.setName("contoperator");
        this.conteggType.setName("conteggType");
        this.conthatchArea.setName("conthatchArea");
        this.contadminOrg.setName("contadminOrg");
        this.conthatchHouse.setName("conthatchHouse");
        this.contoutArea.setName("contoutArea");
        this.chkisHasBEggCanding.setName("chkisHasBEggCanding");
        this.contBEggCandingDate.setName("contBEggCandingDate");
        this.btnViewSummary.setName("btnViewSummary");
        this.btnExcel.setName("btnExcel");
        this.kDPanel4.setName("kDPanel4");
        this.kdtComputeEntry.setName("kdtComputeEntry");
        this.contgenderType.setName("contgenderType");
        this.contStorageOrgUnit.setName("contStorageOrgUnit");
        this.chkisMaterialOut.setName("chkisMaterialOut");
        this.kDPanel1.setName("kDPanel1");
        this.chkisInventory.setName("chkisInventory");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.pkauditTime.setName("pkauditTime");
        this.baseStatus.setName("baseStatus");
        this.prmthatchFactory.setName("prmthatchFactory");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel3.setName("kDPanel3");
        this.kdtEggEntry.setName("kdtEggEntry");
        this.contRows.setName("contRows");
        this.btnAddRow.setName("btnAddRow");
        this.txtAddRows.setName("txtAddRows");
        this.kdtHatchBoxSummaryEntry.setName("kdtHatchBoxSummaryEntry");
        this.txtallHatchQty.setName("txtallHatchQty");
        this.prmtincubator.setName("prmtincubator");
        this.prmtoperator.setName("prmtoperator");
        this.eggType.setName("eggType");
        this.prmthatchArea.setName("prmthatchArea");
        this.prmtadminOrg.setName("prmtadminOrg");
        this.prmthatchHouse.setName("prmthatchHouse");
        this.prmtoutArea.setName("prmtoutArea");
        this.pkBEggCandingDate.setName("pkBEggCandingDate");
        this.radioHorizon.setName("radioHorizon");
        this.radioVertical.setName("radioVertical");
        this.radioOrigin.setName("radioOrigin");
        this.genderType.setName("genderType");
        this.prmtStorageOrgUnit.setName("prmtStorageOrgUnit");
        this.kdtAreaSummaryEntry.setName("kdtAreaSummaryEntry");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
        this.btnAdjust.setName("btnAdjust");
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
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);
        // conthatchFactory		
        this.conthatchFactory.setBoundLabelText(resHelper.getString("conthatchFactory.boundLabelText"));		
        this.conthatchFactory.setBoundLabelLength(100);		
        this.conthatchFactory.setBoundLabelUnderline(true);		
        this.conthatchFactory.setVisible(true);
        // kDTabbedPane2
        // contallHatchQty		
        this.contallHatchQty.setBoundLabelText(resHelper.getString("contallHatchQty.boundLabelText"));		
        this.contallHatchQty.setBoundLabelLength(100);		
        this.contallHatchQty.setBoundLabelUnderline(true);		
        this.contallHatchQty.setVisible(true);
        // contincubator		
        this.contincubator.setBoundLabelText(resHelper.getString("contincubator.boundLabelText"));		
        this.contincubator.setBoundLabelLength(100);		
        this.contincubator.setBoundLabelUnderline(true);		
        this.contincubator.setVisible(false);
        // contoperator		
        this.contoperator.setBoundLabelText(resHelper.getString("contoperator.boundLabelText"));		
        this.contoperator.setBoundLabelLength(100);		
        this.contoperator.setBoundLabelUnderline(true);		
        this.contoperator.setVisible(true);
        // conteggType		
        this.conteggType.setBoundLabelText(resHelper.getString("conteggType.boundLabelText"));		
        this.conteggType.setBoundLabelLength(100);		
        this.conteggType.setBoundLabelUnderline(true);
        // conthatchArea		
        this.conthatchArea.setBoundLabelText(resHelper.getString("conthatchArea.boundLabelText"));		
        this.conthatchArea.setBoundLabelLength(100);		
        this.conthatchArea.setBoundLabelUnderline(true);		
        this.conthatchArea.setVisible(false);
        // contadminOrg		
        this.contadminOrg.setBoundLabelText(resHelper.getString("contadminOrg.boundLabelText"));		
        this.contadminOrg.setBoundLabelLength(100);		
        this.contadminOrg.setBoundLabelUnderline(true);		
        this.contadminOrg.setVisible(false);
        // conthatchHouse		
        this.conthatchHouse.setBoundLabelText(resHelper.getString("conthatchHouse.boundLabelText"));		
        this.conthatchHouse.setBoundLabelLength(100);		
        this.conthatchHouse.setBoundLabelUnderline(true);		
        this.conthatchHouse.setVisible(false);
        // contoutArea		
        this.contoutArea.setBoundLabelText(resHelper.getString("contoutArea.boundLabelText"));		
        this.contoutArea.setBoundLabelLength(100);		
        this.contoutArea.setBoundLabelUnderline(true);		
        this.contoutArea.setVisible(false);
        // chkisHasBEggCanding		
        this.chkisHasBEggCanding.setText(resHelper.getString("chkisHasBEggCanding.text"));		
        this.chkisHasBEggCanding.setHorizontalAlignment(2);		
        this.chkisHasBEggCanding.setEnabled(false);
        // contBEggCandingDate		
        this.contBEggCandingDate.setBoundLabelText(resHelper.getString("contBEggCandingDate.boundLabelText"));		
        this.contBEggCandingDate.setBoundLabelLength(100);		
        this.contBEggCandingDate.setBoundLabelUnderline(true);		
        this.contBEggCandingDate.setVisible(true);
        // btnViewSummary		
        this.btnViewSummary.setText(resHelper.getString("btnViewSummary.text"));
        // btnExcel		
        this.btnExcel.setText(resHelper.getString("btnExcel.text"));
        // kDPanel4		
        this.kDPanel4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel4.border.title")));
        // kdtComputeEntry
		String kdtComputeEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"floorQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"carQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"plateQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"meiQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{floorQty}</t:Cell><t:Cell>$Resource{carQty}</t:Cell><t:Cell>$Resource{plateQty}</t:Cell><t:Cell>$Resource{meiQty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtComputeEntry.setFormatXml(resHelper.translateString("kdtComputeEntry",kdtComputeEntryStrXML));		
        this.kdtComputeEntry.setVisible(false);

                this.kdtComputeEntry.putBindContents("editData",new String[] {"ComputeEntry.seq","ComputeEntry.floorQty","ComputeEntry.carQty","ComputeEntry.plateQty","ComputeEntry.meiQty"});


        this.kdtComputeEntry.checkParsed();
        KDFormattedTextField kdtComputeEntry_floorQty_TextField = new KDFormattedTextField();
        kdtComputeEntry_floorQty_TextField.setName("kdtComputeEntry_floorQty_TextField");
        kdtComputeEntry_floorQty_TextField.setVisible(true);
        kdtComputeEntry_floorQty_TextField.setEditable(true);
        kdtComputeEntry_floorQty_TextField.setHorizontalAlignment(2);
        kdtComputeEntry_floorQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtComputeEntry_floorQty_CellEditor = new KDTDefaultCellEditor(kdtComputeEntry_floorQty_TextField);
        this.kdtComputeEntry.getColumn("floorQty").setEditor(kdtComputeEntry_floorQty_CellEditor);
        KDFormattedTextField kdtComputeEntry_carQty_TextField = new KDFormattedTextField();
        kdtComputeEntry_carQty_TextField.setName("kdtComputeEntry_carQty_TextField");
        kdtComputeEntry_carQty_TextField.setVisible(true);
        kdtComputeEntry_carQty_TextField.setEditable(true);
        kdtComputeEntry_carQty_TextField.setHorizontalAlignment(2);
        kdtComputeEntry_carQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtComputeEntry_carQty_CellEditor = new KDTDefaultCellEditor(kdtComputeEntry_carQty_TextField);
        this.kdtComputeEntry.getColumn("carQty").setEditor(kdtComputeEntry_carQty_CellEditor);
        KDFormattedTextField kdtComputeEntry_plateQty_TextField = new KDFormattedTextField();
        kdtComputeEntry_plateQty_TextField.setName("kdtComputeEntry_plateQty_TextField");
        kdtComputeEntry_plateQty_TextField.setVisible(true);
        kdtComputeEntry_plateQty_TextField.setEditable(true);
        kdtComputeEntry_plateQty_TextField.setHorizontalAlignment(2);
        kdtComputeEntry_plateQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtComputeEntry_plateQty_CellEditor = new KDTDefaultCellEditor(kdtComputeEntry_plateQty_TextField);
        this.kdtComputeEntry.getColumn("plateQty").setEditor(kdtComputeEntry_plateQty_CellEditor);
        KDFormattedTextField kdtComputeEntry_meiQty_TextField = new KDFormattedTextField();
        kdtComputeEntry_meiQty_TextField.setName("kdtComputeEntry_meiQty_TextField");
        kdtComputeEntry_meiQty_TextField.setVisible(true);
        kdtComputeEntry_meiQty_TextField.setEditable(true);
        kdtComputeEntry_meiQty_TextField.setHorizontalAlignment(2);
        kdtComputeEntry_meiQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtComputeEntry_meiQty_CellEditor = new KDTDefaultCellEditor(kdtComputeEntry_meiQty_TextField);
        this.kdtComputeEntry.getColumn("meiQty").setEditor(kdtComputeEntry_meiQty_CellEditor);
        // contgenderType		
        this.contgenderType.setBoundLabelText(resHelper.getString("contgenderType.boundLabelText"));		
        this.contgenderType.setBoundLabelLength(100);		
        this.contgenderType.setBoundLabelUnderline(true);		
        this.contgenderType.setVisible(false);
        // contStorageOrgUnit		
        this.contStorageOrgUnit.setBoundLabelText(resHelper.getString("contStorageOrgUnit.boundLabelText"));		
        this.contStorageOrgUnit.setBoundLabelLength(100);		
        this.contStorageOrgUnit.setBoundLabelUnderline(true);		
        this.contStorageOrgUnit.setVisible(true);
        // chkisMaterialOut		
        this.chkisMaterialOut.setText(resHelper.getString("chkisMaterialOut.text"));		
        this.chkisMaterialOut.setVisible(true);		
        this.chkisMaterialOut.setHorizontalAlignment(2);		
        this.chkisMaterialOut.setEnabled(false);
        // kDPanel1		
        this.kDPanel1.setVisible(false);
        // chkisInventory		
        this.chkisInventory.setText(resHelper.getString("chkisInventory.text"));		
        this.chkisInventory.setVisible(true);		
        this.chkisInventory.setHorizontalAlignment(2);		
        this.chkisInventory.setEnabled(false);
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
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(false);		
        this.baseStatus.setEnabled(false);
        // prmthatchFactory		
        this.prmthatchFactory.setQueryInfo("com.kingdee.eas.farm.hatch.app.HatchBaseDataQuery");		
        this.prmthatchFactory.setEditable(true);		
        this.prmthatchFactory.setDisplayFormat("$name$");		
        this.prmthatchFactory.setEditFormat("$number$");		
        this.prmthatchFactory.setCommitFormat("$number$");		
        this.prmthatchFactory.setRequired(true);
        		prmthatchFactory.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.HatchBaseDataListUI prmthatchFactory_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmthatchFactory_F7ListUI == null) {
					try {
						prmthatchFactory_F7ListUI = new com.kingdee.eas.farm.hatch.client.HatchBaseDataListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmthatchFactory_F7ListUI));
					prmthatchFactory_F7ListUI.setF7Use(true,ctx);
					prmthatchFactory.setSelector(prmthatchFactory_F7ListUI);
				}
			}
		});
					
        this.prmthatchFactory.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmthatchFactory_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // kDPanel2
        // kDPanel3
        // kdtEggEntry
		String kdtEggEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol8\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol9\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol10\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol16\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol18\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol19\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol22\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol23\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol24\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol25\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol26\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol27\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol28\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol29\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol30\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol31\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol32\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol33\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol34\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol35\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol36\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol37\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol38\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol39\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol40\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol42\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol43\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol44\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"hatchHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"incubator\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"hatchCarNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"eggSourceType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"isMix\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"farm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"house\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"breedBatch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"outArea\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"farmer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"outFarm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"outHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"outBatch\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"weeklyAge\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"genderType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"18\" /><t:Column t:key=\"dayAge\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /><t:Column t:key=\"breedDataNew\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"BreedData\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"isFormal\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol19\" /><t:Column t:key=\"supplier\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"CostObject\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol22\" /><t:Column t:key=\"eggLog\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol23\" /><t:Column t:key=\"qc1lv1Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol24\" /><t:Column t:key=\"qc1lv2Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol25\" /><t:Column t:key=\"qc2lv1Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol26\" /><t:Column t:key=\"qc2lv2Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol27\" /><t:Column t:key=\"qc3lv1Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol28\" /><t:Column t:key=\"qc4lv1Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol29\" /><t:Column t:key=\"qc5lv1Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol30\" /><t:Column t:key=\"qc6lv1Qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol31\" /><t:Column t:key=\"qcEggType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol32\" /><t:Column t:key=\"carQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol33\" /><t:Column t:key=\"floorQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol34\" /><t:Column t:key=\"plateQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol35\" /><t:Column t:key=\"meiQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol36\" /><t:Column t:key=\"eggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol37\" /><t:Column t:key=\"standEgg\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol38\" /><t:Column t:key=\"reFundEgg\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol39\" /><t:Column t:key=\"eggHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol40\" /><t:Column t:key=\"babyBatch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"eggDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol42\" /><t:Column t:key=\"tidyEggDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol43\" /><t:Column t:key=\"mdperson\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol44\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{hatchHouse}</t:Cell><t:Cell>$Resource{incubator}</t:Cell><t:Cell>$Resource{hatchCarNum}</t:Cell><t:Cell>$Resource{eggSourceType}</t:Cell><t:Cell>$Resource{isMix}</t:Cell><t:Cell>$Resource{farm}</t:Cell><t:Cell>$Resource{house}</t:Cell><t:Cell>$Resource{breedBatch}</t:Cell><t:Cell>$Resource{outArea}</t:Cell><t:Cell>$Resource{farmer}</t:Cell><t:Cell>$Resource{outFarm}</t:Cell><t:Cell>$Resource{outHouse}</t:Cell><t:Cell>$Resource{outBatch}</t:Cell><t:Cell>$Resource{weeklyAge}</t:Cell><t:Cell>$Resource{genderType}</t:Cell><t:Cell>$Resource{dayAge}</t:Cell><t:Cell>$Resource{breedDataNew}</t:Cell><t:Cell>$Resource{BreedData}</t:Cell><t:Cell>$Resource{isFormal}</t:Cell><t:Cell>$Resource{supplier}</t:Cell><t:Cell>$Resource{CostObject}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{eggLog}</t:Cell><t:Cell>$Resource{qc1lv1Qty}</t:Cell><t:Cell>$Resource{qc1lv2Qty}</t:Cell><t:Cell>$Resource{qc2lv1Qty}</t:Cell><t:Cell>$Resource{qc2lv2Qty}</t:Cell><t:Cell>$Resource{qc3lv1Qty}</t:Cell><t:Cell>$Resource{qc4lv1Qty}</t:Cell><t:Cell>$Resource{qc5lv1Qty}</t:Cell><t:Cell>$Resource{qc6lv1Qty}</t:Cell><t:Cell>$Resource{qcEggType}</t:Cell><t:Cell>$Resource{carQty}</t:Cell><t:Cell>$Resource{floorQty}</t:Cell><t:Cell>$Resource{plateQty}</t:Cell><t:Cell>$Resource{meiQty}</t:Cell><t:Cell>$Resource{eggQty}</t:Cell><t:Cell>$Resource{standEgg}</t:Cell><t:Cell>$Resource{reFundEgg}</t:Cell><t:Cell>$Resource{eggHouse}</t:Cell><t:Cell>$Resource{babyBatch}</t:Cell><t:Cell>$Resource{eggDate}</t:Cell><t:Cell>$Resource{tidyEggDate}</t:Cell><t:Cell>$Resource{mdperson}</t:Cell><t:Cell>$Resource{remark}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEggEntry.setFormatXml(resHelper.translateString("kdtEggEntry",kdtEggEntryStrXML));
        kdtEggEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtEggEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtEggEntry.putBindContents("editData",new String[] {"seq","hatchHouse","incubator","hatchCarNum","eggSourceType","isMix","farm","house","breedBatch","outArea","farmer","outFarm","outHouse","outBatch","weeklyAge","genderType","dayAge","breedDataNew","BreedData","isFormal","supplier","CostObject","material","eggLog","qc1lv1Qty","qc1lv2Qty","qc2lv1Qty","qc2lv2Qty","qc3lv1Qty","qc4lv1Qty","qc5lv1Qty","qc6lv1Qty","qcEggType","carQty","floorQty","plateQty","meiQty","eggQty","standEgg","reFundEgg","eggHouse","babyBatch","eggDate","tidyEggDate","mdperson","remark"});


        this.kdtEggEntry.checkParsed();
        final KDBizPromptBox kdtEggEntry_hatchHouse_PromptBox = new KDBizPromptBox();
        kdtEggEntry_hatchHouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.hatch.app.HatchHouseQuery");
        kdtEggEntry_hatchHouse_PromptBox.setVisible(true);
        kdtEggEntry_hatchHouse_PromptBox.setEditable(true);
        kdtEggEntry_hatchHouse_PromptBox.setDisplayFormat("$number$");
        kdtEggEntry_hatchHouse_PromptBox.setEditFormat("$number$");
        kdtEggEntry_hatchHouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntry_hatchHouse_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_hatchHouse_PromptBox);
        this.kdtEggEntry.getColumn("hatchHouse").setEditor(kdtEggEntry_hatchHouse_CellEditor);
        ObjectValueRender kdtEggEntry_hatchHouse_OVR = new ObjectValueRender();
        kdtEggEntry_hatchHouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntry.getColumn("hatchHouse").setRenderer(kdtEggEntry_hatchHouse_OVR);
        			kdtEggEntry_hatchHouse_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.HatchHouseListUI kdtEggEntry_hatchHouse_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEggEntry_hatchHouse_PromptBox_F7ListUI == null) {
					try {
						kdtEggEntry_hatchHouse_PromptBox_F7ListUI = new com.kingdee.eas.farm.hatch.client.HatchHouseListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEggEntry_hatchHouse_PromptBox_F7ListUI));
					kdtEggEntry_hatchHouse_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEggEntry_hatchHouse_PromptBox.setSelector(kdtEggEntry_hatchHouse_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEggEntry_incubator_PromptBox = new KDBizPromptBox();
        kdtEggEntry_incubator_PromptBox.setQueryInfo("com.kingdee.eas.farm.hatch.app.F7IncubatorQuery");
        kdtEggEntry_incubator_PromptBox.setVisible(true);
        kdtEggEntry_incubator_PromptBox.setEditable(true);
        kdtEggEntry_incubator_PromptBox.setDisplayFormat("$number$");
        kdtEggEntry_incubator_PromptBox.setEditFormat("$number$");
        kdtEggEntry_incubator_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntry_incubator_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_incubator_PromptBox);
        this.kdtEggEntry.getColumn("incubator").setEditor(kdtEggEntry_incubator_CellEditor);
        ObjectValueRender kdtEggEntry_incubator_OVR = new ObjectValueRender();
        kdtEggEntry_incubator_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntry.getColumn("incubator").setRenderer(kdtEggEntry_incubator_OVR);
        			kdtEggEntry_incubator_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.IncubatorListUI kdtEggEntry_incubator_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEggEntry_incubator_PromptBox_F7ListUI == null) {
					try {
						kdtEggEntry_incubator_PromptBox_F7ListUI = new com.kingdee.eas.farm.hatch.client.IncubatorListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEggEntry_incubator_PromptBox_F7ListUI));
					kdtEggEntry_incubator_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEggEntry_incubator_PromptBox.setSelector(kdtEggEntry_incubator_PromptBox_F7ListUI);
				}
			}
		});
					
        KDTextField kdtEggEntry_hatchCarNum_TextField = new KDTextField();
        kdtEggEntry_hatchCarNum_TextField.setName("kdtEggEntry_hatchCarNum_TextField");
        kdtEggEntry_hatchCarNum_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEggEntry_hatchCarNum_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_hatchCarNum_TextField);
        this.kdtEggEntry.getColumn("hatchCarNum").setEditor(kdtEggEntry_hatchCarNum_CellEditor);
        KDComboBox kdtEggEntry_eggSourceType_ComboBox = new KDComboBox();
        kdtEggEntry_eggSourceType_ComboBox.setName("kdtEggEntry_eggSourceType_ComboBox");
        kdtEggEntry_eggSourceType_ComboBox.setVisible(true);
        kdtEggEntry_eggSourceType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.hatch.EggSourceType").toArray());
        KDTDefaultCellEditor kdtEggEntry_eggSourceType_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_eggSourceType_ComboBox);
        this.kdtEggEntry.getColumn("eggSourceType").setEditor(kdtEggEntry_eggSourceType_CellEditor);
        KDCheckBox kdtEggEntry_isMix_CheckBox = new KDCheckBox();
        kdtEggEntry_isMix_CheckBox.setName("kdtEggEntry_isMix_CheckBox");
        KDTDefaultCellEditor kdtEggEntry_isMix_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_isMix_CheckBox);
        this.kdtEggEntry.getColumn("isMix").setEditor(kdtEggEntry_isMix_CellEditor);
        final KDBizPromptBox kdtEggEntry_farm_PromptBox = new KDBizPromptBox();
        kdtEggEntry_farm_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.F7BreedStoorgSetQuery");
        kdtEggEntry_farm_PromptBox.setVisible(true);
        kdtEggEntry_farm_PromptBox.setEditable(true);
        kdtEggEntry_farm_PromptBox.setDisplayFormat("$number$");
        kdtEggEntry_farm_PromptBox.setEditFormat("$number$");
        kdtEggEntry_farm_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntry_farm_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_farm_PromptBox);
        this.kdtEggEntry.getColumn("farm").setEditor(kdtEggEntry_farm_CellEditor);
        ObjectValueRender kdtEggEntry_farm_OVR = new ObjectValueRender();
        kdtEggEntry_farm_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntry.getColumn("farm").setRenderer(kdtEggEntry_farm_OVR);
        final KDBizPromptBox kdtEggEntry_house_PromptBox = new KDBizPromptBox();
        kdtEggEntry_house_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseF7Query");
        kdtEggEntry_house_PromptBox.setVisible(true);
        kdtEggEntry_house_PromptBox.setEditable(true);
        kdtEggEntry_house_PromptBox.setDisplayFormat("$number$");
        kdtEggEntry_house_PromptBox.setEditFormat("$number$");
        kdtEggEntry_house_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntry_house_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_house_PromptBox);
        this.kdtEggEntry.getColumn("house").setEditor(kdtEggEntry_house_CellEditor);
        ObjectValueRender kdtEggEntry_house_OVR = new ObjectValueRender();
        kdtEggEntry_house_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntry.getColumn("house").setRenderer(kdtEggEntry_house_OVR);
        final KDBizPromptBox kdtEggEntry_breedBatch_PromptBox = new KDBizPromptBox();
        kdtEggEntry_breedBatch_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");
        kdtEggEntry_breedBatch_PromptBox.setVisible(true);
        kdtEggEntry_breedBatch_PromptBox.setEditable(true);
        kdtEggEntry_breedBatch_PromptBox.setDisplayFormat("$number$");
        kdtEggEntry_breedBatch_PromptBox.setEditFormat("$number$");
        kdtEggEntry_breedBatch_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntry_breedBatch_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_breedBatch_PromptBox);
        this.kdtEggEntry.getColumn("breedBatch").setEditor(kdtEggEntry_breedBatch_CellEditor);
        ObjectValueRender kdtEggEntry_breedBatch_OVR = new ObjectValueRender();
        kdtEggEntry_breedBatch_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntry.getColumn("breedBatch").setRenderer(kdtEggEntry_breedBatch_OVR);
        final KDBizPromptBox kdtEggEntry_outArea_PromptBox = new KDBizPromptBox();
        kdtEggEntry_outArea_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.F7FarmerGroupQuery");
        kdtEggEntry_outArea_PromptBox.setVisible(true);
        kdtEggEntry_outArea_PromptBox.setEditable(true);
        kdtEggEntry_outArea_PromptBox.setDisplayFormat("$number$");
        kdtEggEntry_outArea_PromptBox.setEditFormat("$number$");
        kdtEggEntry_outArea_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntry_outArea_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_outArea_PromptBox);
        this.kdtEggEntry.getColumn("outArea").setEditor(kdtEggEntry_outArea_CellEditor);
        ObjectValueRender kdtEggEntry_outArea_OVR = new ObjectValueRender();
        kdtEggEntry_outArea_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntry.getColumn("outArea").setRenderer(kdtEggEntry_outArea_OVR);
        final KDBizPromptBox kdtEggEntry_farmer_PromptBox = new KDBizPromptBox();
        kdtEggEntry_farmer_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmersQuery");
        kdtEggEntry_farmer_PromptBox.setVisible(true);
        kdtEggEntry_farmer_PromptBox.setEditable(true);
        kdtEggEntry_farmer_PromptBox.setDisplayFormat("$number$");
        kdtEggEntry_farmer_PromptBox.setEditFormat("$number$");
        kdtEggEntry_farmer_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntry_farmer_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_farmer_PromptBox);
        this.kdtEggEntry.getColumn("farmer").setEditor(kdtEggEntry_farmer_CellEditor);
        ObjectValueRender kdtEggEntry_farmer_OVR = new ObjectValueRender();
        kdtEggEntry_farmer_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntry.getColumn("farmer").setRenderer(kdtEggEntry_farmer_OVR);
        			kdtEggEntry_farmer_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI kdtEggEntry_farmer_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEggEntry_farmer_PromptBox_F7ListUI == null) {
					try {
						kdtEggEntry_farmer_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEggEntry_farmer_PromptBox_F7ListUI));
					kdtEggEntry_farmer_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEggEntry_farmer_PromptBox.setSelector(kdtEggEntry_farmer_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEggEntry_outFarm_PromptBox = new KDBizPromptBox();
        kdtEggEntry_outFarm_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmQuery");
        kdtEggEntry_outFarm_PromptBox.setVisible(true);
        kdtEggEntry_outFarm_PromptBox.setEditable(true);
        kdtEggEntry_outFarm_PromptBox.setDisplayFormat("$number$");
        kdtEggEntry_outFarm_PromptBox.setEditFormat("$number$");
        kdtEggEntry_outFarm_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntry_outFarm_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_outFarm_PromptBox);
        this.kdtEggEntry.getColumn("outFarm").setEditor(kdtEggEntry_outFarm_CellEditor);
        ObjectValueRender kdtEggEntry_outFarm_OVR = new ObjectValueRender();
        kdtEggEntry_outFarm_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntry.getColumn("outFarm").setRenderer(kdtEggEntry_outFarm_OVR);
        			kdtEggEntry_outFarm_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmListUI kdtEggEntry_outFarm_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEggEntry_outFarm_PromptBox_F7ListUI == null) {
					try {
						kdtEggEntry_outFarm_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEggEntry_outFarm_PromptBox_F7ListUI));
					kdtEggEntry_outFarm_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEggEntry_outFarm_PromptBox.setSelector(kdtEggEntry_outFarm_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEggEntry_outHouse_PromptBox = new KDBizPromptBox();
        kdtEggEntry_outHouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
        kdtEggEntry_outHouse_PromptBox.setVisible(true);
        kdtEggEntry_outHouse_PromptBox.setEditable(true);
        kdtEggEntry_outHouse_PromptBox.setDisplayFormat("$number$");
        kdtEggEntry_outHouse_PromptBox.setEditFormat("$number$");
        kdtEggEntry_outHouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntry_outHouse_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_outHouse_PromptBox);
        this.kdtEggEntry.getColumn("outHouse").setEditor(kdtEggEntry_outHouse_CellEditor);
        ObjectValueRender kdtEggEntry_outHouse_OVR = new ObjectValueRender();
        kdtEggEntry_outHouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntry.getColumn("outHouse").setRenderer(kdtEggEntry_outHouse_OVR);
        final KDBizPromptBox kdtEggEntry_outBatch_PromptBox = new KDBizPromptBox();
        kdtEggEntry_outBatch_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.StockingBatchQuery");
        kdtEggEntry_outBatch_PromptBox.setVisible(true);
        kdtEggEntry_outBatch_PromptBox.setEditable(true);
        kdtEggEntry_outBatch_PromptBox.setDisplayFormat("$number$");
        kdtEggEntry_outBatch_PromptBox.setEditFormat("$number$");
        kdtEggEntry_outBatch_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntry_outBatch_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_outBatch_PromptBox);
        this.kdtEggEntry.getColumn("outBatch").setEditor(kdtEggEntry_outBatch_CellEditor);
        ObjectValueRender kdtEggEntry_outBatch_OVR = new ObjectValueRender();
        kdtEggEntry_outBatch_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntry.getColumn("outBatch").setRenderer(kdtEggEntry_outBatch_OVR);
        			kdtEggEntry_outBatch_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI kdtEggEntry_outBatch_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEggEntry_outBatch_PromptBox_F7ListUI == null) {
					try {
						kdtEggEntry_outBatch_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEggEntry_outBatch_PromptBox_F7ListUI));
					kdtEggEntry_outBatch_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEggEntry_outBatch_PromptBox.setSelector(kdtEggEntry_outBatch_PromptBox_F7ListUI);
				}
			}
		});
					
        KDTextField kdtEggEntry_weeklyAge_TextField = new KDTextField();
        kdtEggEntry_weeklyAge_TextField.setName("kdtEggEntry_weeklyAge_TextField");
        kdtEggEntry_weeklyAge_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEggEntry_weeklyAge_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_weeklyAge_TextField);
        this.kdtEggEntry.getColumn("weeklyAge").setEditor(kdtEggEntry_weeklyAge_CellEditor);
        KDComboBox kdtEggEntry_genderType_ComboBox = new KDComboBox();
        kdtEggEntry_genderType_ComboBox.setName("kdtEggEntry_genderType_ComboBox");
        kdtEggEntry_genderType_ComboBox.setVisible(true);
        kdtEggEntry_genderType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.hatch.GenderType").toArray());
        KDTDefaultCellEditor kdtEggEntry_genderType_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_genderType_ComboBox);
        this.kdtEggEntry.getColumn("genderType").setEditor(kdtEggEntry_genderType_CellEditor);
        KDFormattedTextField kdtEggEntry_dayAge_TextField = new KDFormattedTextField();
        kdtEggEntry_dayAge_TextField.setName("kdtEggEntry_dayAge_TextField");
        kdtEggEntry_dayAge_TextField.setVisible(true);
        kdtEggEntry_dayAge_TextField.setEditable(true);
        kdtEggEntry_dayAge_TextField.setHorizontalAlignment(2);
        kdtEggEntry_dayAge_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntry_dayAge_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_dayAge_TextField);
        this.kdtEggEntry.getColumn("dayAge").setEditor(kdtEggEntry_dayAge_CellEditor);
        final KDBizPromptBox kdtEggEntry_breedDataNew_PromptBox = new KDBizPromptBox();
        kdtEggEntry_breedDataNew_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.BreedDataQuery");
        kdtEggEntry_breedDataNew_PromptBox.setVisible(true);
        kdtEggEntry_breedDataNew_PromptBox.setEditable(true);
        kdtEggEntry_breedDataNew_PromptBox.setDisplayFormat("$number$");
        kdtEggEntry_breedDataNew_PromptBox.setEditFormat("$number$");
        kdtEggEntry_breedDataNew_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntry_breedDataNew_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_breedDataNew_PromptBox);
        this.kdtEggEntry.getColumn("breedDataNew").setEditor(kdtEggEntry_breedDataNew_CellEditor);
        ObjectValueRender kdtEggEntry_breedDataNew_OVR = new ObjectValueRender();
        kdtEggEntry_breedDataNew_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntry.getColumn("breedDataNew").setRenderer(kdtEggEntry_breedDataNew_OVR);
        			kdtEggEntry_breedDataNew_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI kdtEggEntry_breedDataNew_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEggEntry_breedDataNew_PromptBox_F7ListUI == null) {
					try {
						kdtEggEntry_breedDataNew_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEggEntry_breedDataNew_PromptBox_F7ListUI));
					kdtEggEntry_breedDataNew_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEggEntry_breedDataNew_PromptBox.setSelector(kdtEggEntry_breedDataNew_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEggEntry_BreedData_PromptBox = new KDBizPromptBox();
        kdtEggEntry_BreedData_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.BreedDataQuery");
        kdtEggEntry_BreedData_PromptBox.setVisible(true);
        kdtEggEntry_BreedData_PromptBox.setEditable(true);
        kdtEggEntry_BreedData_PromptBox.setDisplayFormat("$number$");
        kdtEggEntry_BreedData_PromptBox.setEditFormat("$number$");
        kdtEggEntry_BreedData_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntry_BreedData_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_BreedData_PromptBox);
        this.kdtEggEntry.getColumn("BreedData").setEditor(kdtEggEntry_BreedData_CellEditor);
        ObjectValueRender kdtEggEntry_BreedData_OVR = new ObjectValueRender();
        kdtEggEntry_BreedData_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntry.getColumn("BreedData").setRenderer(kdtEggEntry_BreedData_OVR);
        			kdtEggEntry_BreedData_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI kdtEggEntry_BreedData_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEggEntry_BreedData_PromptBox_F7ListUI == null) {
					try {
						kdtEggEntry_BreedData_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEggEntry_BreedData_PromptBox_F7ListUI));
					kdtEggEntry_BreedData_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEggEntry_BreedData_PromptBox.setSelector(kdtEggEntry_BreedData_PromptBox_F7ListUI);
				}
			}
		});
					
        KDCheckBox kdtEggEntry_isFormal_CheckBox = new KDCheckBox();
        kdtEggEntry_isFormal_CheckBox.setName("kdtEggEntry_isFormal_CheckBox");
        KDTDefaultCellEditor kdtEggEntry_isFormal_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_isFormal_CheckBox);
        this.kdtEggEntry.getColumn("isFormal").setEditor(kdtEggEntry_isFormal_CellEditor);
        final KDBizPromptBox kdtEggEntry_supplier_PromptBox = new KDBizPromptBox();
        kdtEggEntry_supplier_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.F7SupplierDefaultQuery");
        kdtEggEntry_supplier_PromptBox.setVisible(true);
        kdtEggEntry_supplier_PromptBox.setEditable(true);
        kdtEggEntry_supplier_PromptBox.setDisplayFormat("$number$");
        kdtEggEntry_supplier_PromptBox.setEditFormat("$number$");
        kdtEggEntry_supplier_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntry_supplier_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_supplier_PromptBox);
        this.kdtEggEntry.getColumn("supplier").setEditor(kdtEggEntry_supplier_CellEditor);
        ObjectValueRender kdtEggEntry_supplier_OVR = new ObjectValueRender();
        kdtEggEntry_supplier_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntry.getColumn("supplier").setRenderer(kdtEggEntry_supplier_OVR);
        final KDBizPromptBox kdtEggEntry_CostObject_PromptBox = new KDBizPromptBox();
        kdtEggEntry_CostObject_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");
        kdtEggEntry_CostObject_PromptBox.setVisible(true);
        kdtEggEntry_CostObject_PromptBox.setEditable(true);
        kdtEggEntry_CostObject_PromptBox.setDisplayFormat("$number$");
        kdtEggEntry_CostObject_PromptBox.setEditFormat("$number$");
        kdtEggEntry_CostObject_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntry_CostObject_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_CostObject_PromptBox);
        this.kdtEggEntry.getColumn("CostObject").setEditor(kdtEggEntry_CostObject_CellEditor);
        ObjectValueRender kdtEggEntry_CostObject_OVR = new ObjectValueRender();
        kdtEggEntry_CostObject_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntry.getColumn("CostObject").setRenderer(kdtEggEntry_CostObject_OVR);
        final KDBizPromptBox kdtEggEntry_material_PromptBox = new KDBizPromptBox();
        kdtEggEntry_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtEggEntry_material_PromptBox.setVisible(true);
        kdtEggEntry_material_PromptBox.setEditable(true);
        kdtEggEntry_material_PromptBox.setDisplayFormat("$number$");
        kdtEggEntry_material_PromptBox.setEditFormat("$number$");
        kdtEggEntry_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntry_material_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_material_PromptBox);
        this.kdtEggEntry.getColumn("material").setEditor(kdtEggEntry_material_CellEditor);
        ObjectValueRender kdtEggEntry_material_OVR = new ObjectValueRender();
        kdtEggEntry_material_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntry.getColumn("material").setRenderer(kdtEggEntry_material_OVR);
        KDTextField kdtEggEntry_eggLog_TextField = new KDTextField();
        kdtEggEntry_eggLog_TextField.setName("kdtEggEntry_eggLog_TextField");
        kdtEggEntry_eggLog_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEggEntry_eggLog_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_eggLog_TextField);
        this.kdtEggEntry.getColumn("eggLog").setEditor(kdtEggEntry_eggLog_CellEditor);
        KDFormattedTextField kdtEggEntry_qc1lv1Qty_TextField = new KDFormattedTextField();
        kdtEggEntry_qc1lv1Qty_TextField.setName("kdtEggEntry_qc1lv1Qty_TextField");
        kdtEggEntry_qc1lv1Qty_TextField.setVisible(true);
        kdtEggEntry_qc1lv1Qty_TextField.setEditable(true);
        kdtEggEntry_qc1lv1Qty_TextField.setHorizontalAlignment(2);
        kdtEggEntry_qc1lv1Qty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntry_qc1lv1Qty_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_qc1lv1Qty_TextField);
        this.kdtEggEntry.getColumn("qc1lv1Qty").setEditor(kdtEggEntry_qc1lv1Qty_CellEditor);
        KDFormattedTextField kdtEggEntry_qc1lv2Qty_TextField = new KDFormattedTextField();
        kdtEggEntry_qc1lv2Qty_TextField.setName("kdtEggEntry_qc1lv2Qty_TextField");
        kdtEggEntry_qc1lv2Qty_TextField.setVisible(true);
        kdtEggEntry_qc1lv2Qty_TextField.setEditable(true);
        kdtEggEntry_qc1lv2Qty_TextField.setHorizontalAlignment(2);
        kdtEggEntry_qc1lv2Qty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntry_qc1lv2Qty_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_qc1lv2Qty_TextField);
        this.kdtEggEntry.getColumn("qc1lv2Qty").setEditor(kdtEggEntry_qc1lv2Qty_CellEditor);
        KDFormattedTextField kdtEggEntry_qc2lv1Qty_TextField = new KDFormattedTextField();
        kdtEggEntry_qc2lv1Qty_TextField.setName("kdtEggEntry_qc2lv1Qty_TextField");
        kdtEggEntry_qc2lv1Qty_TextField.setVisible(true);
        kdtEggEntry_qc2lv1Qty_TextField.setEditable(true);
        kdtEggEntry_qc2lv1Qty_TextField.setHorizontalAlignment(2);
        kdtEggEntry_qc2lv1Qty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntry_qc2lv1Qty_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_qc2lv1Qty_TextField);
        this.kdtEggEntry.getColumn("qc2lv1Qty").setEditor(kdtEggEntry_qc2lv1Qty_CellEditor);
        KDFormattedTextField kdtEggEntry_qc2lv2Qty_TextField = new KDFormattedTextField();
        kdtEggEntry_qc2lv2Qty_TextField.setName("kdtEggEntry_qc2lv2Qty_TextField");
        kdtEggEntry_qc2lv2Qty_TextField.setVisible(true);
        kdtEggEntry_qc2lv2Qty_TextField.setEditable(true);
        kdtEggEntry_qc2lv2Qty_TextField.setHorizontalAlignment(2);
        kdtEggEntry_qc2lv2Qty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntry_qc2lv2Qty_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_qc2lv2Qty_TextField);
        this.kdtEggEntry.getColumn("qc2lv2Qty").setEditor(kdtEggEntry_qc2lv2Qty_CellEditor);
        KDFormattedTextField kdtEggEntry_qc3lv1Qty_TextField = new KDFormattedTextField();
        kdtEggEntry_qc3lv1Qty_TextField.setName("kdtEggEntry_qc3lv1Qty_TextField");
        kdtEggEntry_qc3lv1Qty_TextField.setVisible(true);
        kdtEggEntry_qc3lv1Qty_TextField.setEditable(true);
        kdtEggEntry_qc3lv1Qty_TextField.setHorizontalAlignment(2);
        kdtEggEntry_qc3lv1Qty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntry_qc3lv1Qty_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_qc3lv1Qty_TextField);
        this.kdtEggEntry.getColumn("qc3lv1Qty").setEditor(kdtEggEntry_qc3lv1Qty_CellEditor);
        KDFormattedTextField kdtEggEntry_qc4lv1Qty_TextField = new KDFormattedTextField();
        kdtEggEntry_qc4lv1Qty_TextField.setName("kdtEggEntry_qc4lv1Qty_TextField");
        kdtEggEntry_qc4lv1Qty_TextField.setVisible(true);
        kdtEggEntry_qc4lv1Qty_TextField.setEditable(true);
        kdtEggEntry_qc4lv1Qty_TextField.setHorizontalAlignment(2);
        kdtEggEntry_qc4lv1Qty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntry_qc4lv1Qty_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_qc4lv1Qty_TextField);
        this.kdtEggEntry.getColumn("qc4lv1Qty").setEditor(kdtEggEntry_qc4lv1Qty_CellEditor);
        KDFormattedTextField kdtEggEntry_qc5lv1Qty_TextField = new KDFormattedTextField();
        kdtEggEntry_qc5lv1Qty_TextField.setName("kdtEggEntry_qc5lv1Qty_TextField");
        kdtEggEntry_qc5lv1Qty_TextField.setVisible(true);
        kdtEggEntry_qc5lv1Qty_TextField.setEditable(true);
        kdtEggEntry_qc5lv1Qty_TextField.setHorizontalAlignment(2);
        kdtEggEntry_qc5lv1Qty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntry_qc5lv1Qty_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_qc5lv1Qty_TextField);
        this.kdtEggEntry.getColumn("qc5lv1Qty").setEditor(kdtEggEntry_qc5lv1Qty_CellEditor);
        KDFormattedTextField kdtEggEntry_qc6lv1Qty_TextField = new KDFormattedTextField();
        kdtEggEntry_qc6lv1Qty_TextField.setName("kdtEggEntry_qc6lv1Qty_TextField");
        kdtEggEntry_qc6lv1Qty_TextField.setVisible(true);
        kdtEggEntry_qc6lv1Qty_TextField.setEditable(true);
        kdtEggEntry_qc6lv1Qty_TextField.setHorizontalAlignment(2);
        kdtEggEntry_qc6lv1Qty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntry_qc6lv1Qty_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_qc6lv1Qty_TextField);
        this.kdtEggEntry.getColumn("qc6lv1Qty").setEditor(kdtEggEntry_qc6lv1Qty_CellEditor);
        KDComboBox kdtEggEntry_qcEggType_ComboBox = new KDComboBox();
        kdtEggEntry_qcEggType_ComboBox.setName("kdtEggEntry_qcEggType_ComboBox");
        kdtEggEntry_qcEggType_ComboBox.setVisible(true);
        kdtEggEntry_qcEggType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.hatch.QcEggTypeEnum").toArray());
        KDTDefaultCellEditor kdtEggEntry_qcEggType_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_qcEggType_ComboBox);
        this.kdtEggEntry.getColumn("qcEggType").setEditor(kdtEggEntry_qcEggType_CellEditor);
        KDFormattedTextField kdtEggEntry_carQty_TextField = new KDFormattedTextField();
        kdtEggEntry_carQty_TextField.setName("kdtEggEntry_carQty_TextField");
        kdtEggEntry_carQty_TextField.setVisible(true);
        kdtEggEntry_carQty_TextField.setEditable(true);
        kdtEggEntry_carQty_TextField.setHorizontalAlignment(2);
        kdtEggEntry_carQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntry_carQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_carQty_TextField);
        this.kdtEggEntry.getColumn("carQty").setEditor(kdtEggEntry_carQty_CellEditor);
        KDFormattedTextField kdtEggEntry_floorQty_TextField = new KDFormattedTextField();
        kdtEggEntry_floorQty_TextField.setName("kdtEggEntry_floorQty_TextField");
        kdtEggEntry_floorQty_TextField.setVisible(true);
        kdtEggEntry_floorQty_TextField.setEditable(true);
        kdtEggEntry_floorQty_TextField.setHorizontalAlignment(2);
        kdtEggEntry_floorQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntry_floorQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_floorQty_TextField);
        this.kdtEggEntry.getColumn("floorQty").setEditor(kdtEggEntry_floorQty_CellEditor);
        KDFormattedTextField kdtEggEntry_plateQty_TextField = new KDFormattedTextField();
        kdtEggEntry_plateQty_TextField.setName("kdtEggEntry_plateQty_TextField");
        kdtEggEntry_plateQty_TextField.setVisible(true);
        kdtEggEntry_plateQty_TextField.setEditable(true);
        kdtEggEntry_plateQty_TextField.setHorizontalAlignment(2);
        kdtEggEntry_plateQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntry_plateQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_plateQty_TextField);
        this.kdtEggEntry.getColumn("plateQty").setEditor(kdtEggEntry_plateQty_CellEditor);
        KDFormattedTextField kdtEggEntry_meiQty_TextField = new KDFormattedTextField();
        kdtEggEntry_meiQty_TextField.setName("kdtEggEntry_meiQty_TextField");
        kdtEggEntry_meiQty_TextField.setVisible(true);
        kdtEggEntry_meiQty_TextField.setEditable(true);
        kdtEggEntry_meiQty_TextField.setHorizontalAlignment(2);
        kdtEggEntry_meiQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntry_meiQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_meiQty_TextField);
        this.kdtEggEntry.getColumn("meiQty").setEditor(kdtEggEntry_meiQty_CellEditor);
        KDFormattedTextField kdtEggEntry_eggQty_TextField = new KDFormattedTextField();
        kdtEggEntry_eggQty_TextField.setName("kdtEggEntry_eggQty_TextField");
        kdtEggEntry_eggQty_TextField.setVisible(true);
        kdtEggEntry_eggQty_TextField.setEditable(true);
        kdtEggEntry_eggQty_TextField.setHorizontalAlignment(2);
        kdtEggEntry_eggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntry_eggQty_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_eggQty_TextField);
        this.kdtEggEntry.getColumn("eggQty").setEditor(kdtEggEntry_eggQty_CellEditor);
        KDFormattedTextField kdtEggEntry_standEgg_TextField = new KDFormattedTextField();
        kdtEggEntry_standEgg_TextField.setName("kdtEggEntry_standEgg_TextField");
        kdtEggEntry_standEgg_TextField.setVisible(true);
        kdtEggEntry_standEgg_TextField.setEditable(true);
        kdtEggEntry_standEgg_TextField.setHorizontalAlignment(2);
        kdtEggEntry_standEgg_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntry_standEgg_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_standEgg_TextField);
        this.kdtEggEntry.getColumn("standEgg").setEditor(kdtEggEntry_standEgg_CellEditor);
        KDFormattedTextField kdtEggEntry_reFundEgg_TextField = new KDFormattedTextField();
        kdtEggEntry_reFundEgg_TextField.setName("kdtEggEntry_reFundEgg_TextField");
        kdtEggEntry_reFundEgg_TextField.setVisible(true);
        kdtEggEntry_reFundEgg_TextField.setEditable(true);
        kdtEggEntry_reFundEgg_TextField.setHorizontalAlignment(2);
        kdtEggEntry_reFundEgg_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEggEntry_reFundEgg_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_reFundEgg_TextField);
        this.kdtEggEntry.getColumn("reFundEgg").setEditor(kdtEggEntry_reFundEgg_CellEditor);
        final KDBizPromptBox kdtEggEntry_eggHouse_PromptBox = new KDBizPromptBox();
        kdtEggEntry_eggHouse_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7AllWarehouseQuery");
        kdtEggEntry_eggHouse_PromptBox.setVisible(true);
        kdtEggEntry_eggHouse_PromptBox.setEditable(true);
        kdtEggEntry_eggHouse_PromptBox.setDisplayFormat("$number$");
        kdtEggEntry_eggHouse_PromptBox.setEditFormat("$number$");
        kdtEggEntry_eggHouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEggEntry_eggHouse_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_eggHouse_PromptBox);
        this.kdtEggEntry.getColumn("eggHouse").setEditor(kdtEggEntry_eggHouse_CellEditor);
        ObjectValueRender kdtEggEntry_eggHouse_OVR = new ObjectValueRender();
        kdtEggEntry_eggHouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEggEntry.getColumn("eggHouse").setRenderer(kdtEggEntry_eggHouse_OVR);
        KDTextField kdtEggEntry_babyBatch_TextField = new KDTextField();
        kdtEggEntry_babyBatch_TextField.setName("kdtEggEntry_babyBatch_TextField");
        kdtEggEntry_babyBatch_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEggEntry_babyBatch_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_babyBatch_TextField);
        this.kdtEggEntry.getColumn("babyBatch").setEditor(kdtEggEntry_babyBatch_CellEditor);
        KDDatePicker kdtEggEntry_eggDate_DatePicker = new KDDatePicker();
        kdtEggEntry_eggDate_DatePicker.setName("kdtEggEntry_eggDate_DatePicker");
        kdtEggEntry_eggDate_DatePicker.setVisible(true);
        kdtEggEntry_eggDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEggEntry_eggDate_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_eggDate_DatePicker);
        this.kdtEggEntry.getColumn("eggDate").setEditor(kdtEggEntry_eggDate_CellEditor);
        KDDatePicker kdtEggEntry_tidyEggDate_DatePicker = new KDDatePicker();
        kdtEggEntry_tidyEggDate_DatePicker.setName("kdtEggEntry_tidyEggDate_DatePicker");
        kdtEggEntry_tidyEggDate_DatePicker.setVisible(true);
        kdtEggEntry_tidyEggDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEggEntry_tidyEggDate_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_tidyEggDate_DatePicker);
        this.kdtEggEntry.getColumn("tidyEggDate").setEditor(kdtEggEntry_tidyEggDate_CellEditor);
        KDTextField kdtEggEntry_mdperson_TextField = new KDTextField();
        kdtEggEntry_mdperson_TextField.setName("kdtEggEntry_mdperson_TextField");
        kdtEggEntry_mdperson_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEggEntry_mdperson_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_mdperson_TextField);
        this.kdtEggEntry.getColumn("mdperson").setEditor(kdtEggEntry_mdperson_CellEditor);
        KDTextField kdtEggEntry_remark_TextField = new KDTextField();
        kdtEggEntry_remark_TextField.setName("kdtEggEntry_remark_TextField");
        kdtEggEntry_remark_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEggEntry_remark_CellEditor = new KDTDefaultCellEditor(kdtEggEntry_remark_TextField);
        this.kdtEggEntry.getColumn("remark").setEditor(kdtEggEntry_remark_CellEditor);
        // contRows		
        this.contRows.setBoundLabelText(resHelper.getString("contRows.boundLabelText"));		
        this.contRows.setBoundLabelLength(100);		
        this.contRows.setBoundLabelUnderline(true);		
        this.contRows.setVisible(true);
        // btnAddRow		
        this.btnAddRow.setText(resHelper.getString("btnAddRow.text"));		
        this.btnAddRow.setVisible(false);
        // txtAddRows		
        this.txtAddRows.setHorizontalAlignment(2);		
        this.txtAddRows.setDataType(0);		
        this.txtAddRows.setSupportedEmpty(true);		
        this.txtAddRows.setRequired(false);		
        this.txtAddRows.setVisible(false);
        // kdtHatchBoxSummaryEntry
		String kdtHatchBoxSummaryEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"hatchHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"incubator\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"eggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{hatchHouse}</t:Cell><t:Cell>$Resource{incubator}</t:Cell><t:Cell>$Resource{eggQty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtHatchBoxSummaryEntry.setFormatXml(resHelper.translateString("kdtHatchBoxSummaryEntry",kdtHatchBoxSummaryEntryStrXML));

                this.kdtHatchBoxSummaryEntry.putBindContents("editData",new String[] {"seq","hatchHouse","incubator","eggQty"});


        this.kdtHatchBoxSummaryEntry.checkParsed();
        final KDBizPromptBox kdtHatchBoxSummaryEntry_hatchHouse_PromptBox = new KDBizPromptBox();
        kdtHatchBoxSummaryEntry_hatchHouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.hatch.app.HatchHouseQuery");
        kdtHatchBoxSummaryEntry_hatchHouse_PromptBox.setVisible(true);
        kdtHatchBoxSummaryEntry_hatchHouse_PromptBox.setEditable(true);
        kdtHatchBoxSummaryEntry_hatchHouse_PromptBox.setDisplayFormat("$number$");
        kdtHatchBoxSummaryEntry_hatchHouse_PromptBox.setEditFormat("$number$");
        kdtHatchBoxSummaryEntry_hatchHouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtHatchBoxSummaryEntry_hatchHouse_CellEditor = new KDTDefaultCellEditor(kdtHatchBoxSummaryEntry_hatchHouse_PromptBox);
        this.kdtHatchBoxSummaryEntry.getColumn("hatchHouse").setEditor(kdtHatchBoxSummaryEntry_hatchHouse_CellEditor);
        ObjectValueRender kdtHatchBoxSummaryEntry_hatchHouse_OVR = new ObjectValueRender();
        kdtHatchBoxSummaryEntry_hatchHouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtHatchBoxSummaryEntry.getColumn("hatchHouse").setRenderer(kdtHatchBoxSummaryEntry_hatchHouse_OVR);
        			kdtHatchBoxSummaryEntry_hatchHouse_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.HatchHouseListUI kdtHatchBoxSummaryEntry_hatchHouse_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtHatchBoxSummaryEntry_hatchHouse_PromptBox_F7ListUI == null) {
					try {
						kdtHatchBoxSummaryEntry_hatchHouse_PromptBox_F7ListUI = new com.kingdee.eas.farm.hatch.client.HatchHouseListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtHatchBoxSummaryEntry_hatchHouse_PromptBox_F7ListUI));
					kdtHatchBoxSummaryEntry_hatchHouse_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtHatchBoxSummaryEntry_hatchHouse_PromptBox.setSelector(kdtHatchBoxSummaryEntry_hatchHouse_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtHatchBoxSummaryEntry_incubator_PromptBox = new KDBizPromptBox();
        kdtHatchBoxSummaryEntry_incubator_PromptBox.setQueryInfo("com.kingdee.eas.farm.hatch.app.F7IncubatorQuery");
        kdtHatchBoxSummaryEntry_incubator_PromptBox.setVisible(true);
        kdtHatchBoxSummaryEntry_incubator_PromptBox.setEditable(true);
        kdtHatchBoxSummaryEntry_incubator_PromptBox.setDisplayFormat("$number$");
        kdtHatchBoxSummaryEntry_incubator_PromptBox.setEditFormat("$number$");
        kdtHatchBoxSummaryEntry_incubator_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtHatchBoxSummaryEntry_incubator_CellEditor = new KDTDefaultCellEditor(kdtHatchBoxSummaryEntry_incubator_PromptBox);
        this.kdtHatchBoxSummaryEntry.getColumn("incubator").setEditor(kdtHatchBoxSummaryEntry_incubator_CellEditor);
        ObjectValueRender kdtHatchBoxSummaryEntry_incubator_OVR = new ObjectValueRender();
        kdtHatchBoxSummaryEntry_incubator_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtHatchBoxSummaryEntry.getColumn("incubator").setRenderer(kdtHatchBoxSummaryEntry_incubator_OVR);
        			kdtHatchBoxSummaryEntry_incubator_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.IncubatorListUI kdtHatchBoxSummaryEntry_incubator_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtHatchBoxSummaryEntry_incubator_PromptBox_F7ListUI == null) {
					try {
						kdtHatchBoxSummaryEntry_incubator_PromptBox_F7ListUI = new com.kingdee.eas.farm.hatch.client.IncubatorListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtHatchBoxSummaryEntry_incubator_PromptBox_F7ListUI));
					kdtHatchBoxSummaryEntry_incubator_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtHatchBoxSummaryEntry_incubator_PromptBox.setSelector(kdtHatchBoxSummaryEntry_incubator_PromptBox_F7ListUI);
				}
			}
		});
					
        KDFormattedTextField kdtHatchBoxSummaryEntry_eggQty_TextField = new KDFormattedTextField();
        kdtHatchBoxSummaryEntry_eggQty_TextField.setName("kdtHatchBoxSummaryEntry_eggQty_TextField");
        kdtHatchBoxSummaryEntry_eggQty_TextField.setVisible(true);
        kdtHatchBoxSummaryEntry_eggQty_TextField.setEditable(true);
        kdtHatchBoxSummaryEntry_eggQty_TextField.setHorizontalAlignment(2);
        kdtHatchBoxSummaryEntry_eggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtHatchBoxSummaryEntry_eggQty_CellEditor = new KDTDefaultCellEditor(kdtHatchBoxSummaryEntry_eggQty_TextField);
        this.kdtHatchBoxSummaryEntry.getColumn("eggQty").setEditor(kdtHatchBoxSummaryEntry_eggQty_CellEditor);
        // txtallHatchQty		
        this.txtallHatchQty.setHorizontalAlignment(2);		
        this.txtallHatchQty.setDataType(0);		
        this.txtallHatchQty.setSupportedEmpty(true);		
        this.txtallHatchQty.setRequired(false);		
        this.txtallHatchQty.setEnabled(false);
        // prmtincubator		
        this.prmtincubator.setQueryInfo("com.kingdee.eas.farm.hatch.app.IncubatorQuery");		
        this.prmtincubator.setEditable(true);		
        this.prmtincubator.setDisplayFormat("$name$");		
        this.prmtincubator.setEditFormat("$number$");		
        this.prmtincubator.setCommitFormat("$number$");		
        this.prmtincubator.setRequired(false);
        		prmtincubator.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.IncubatorListUI prmtincubator_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtincubator_F7ListUI == null) {
					try {
						prmtincubator_F7ListUI = new com.kingdee.eas.farm.hatch.client.IncubatorListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtincubator_F7ListUI));
					prmtincubator_F7ListUI.setF7Use(true,ctx);
					prmtincubator.setSelector(prmtincubator_F7ListUI);
				}
			}
		});
					
        // prmtoperator		
        this.prmtoperator.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtoperator.setEditable(true);		
        this.prmtoperator.setDisplayFormat("$name$");		
        this.prmtoperator.setEditFormat("$number$");		
        this.prmtoperator.setCommitFormat("$number$");		
        this.prmtoperator.setRequired(false);
        // eggType		
        this.eggType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.hatch.EggType").toArray());		
        this.eggType.setRequired(false);
        // prmthatchArea		
        this.prmthatchArea.setQueryInfo("com.kingdee.eas.farm.hatch.app.HatchAreaQuery");		
        this.prmthatchArea.setEditable(true);		
        this.prmthatchArea.setDisplayFormat("$name$");		
        this.prmthatchArea.setEditFormat("$number$");		
        this.prmthatchArea.setCommitFormat("$number$");		
        this.prmthatchArea.setRequired(false);		
        this.prmthatchArea.setVisible(false);
        this.prmthatchArea.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmthatchArea_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // prmtadminOrg		
        this.prmtadminOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtadminOrg.setVisible(false);		
        this.prmtadminOrg.setEditable(true);		
        this.prmtadminOrg.setDisplayFormat("$name$");		
        this.prmtadminOrg.setEditFormat("$number$");		
        this.prmtadminOrg.setCommitFormat("$number$");		
        this.prmtadminOrg.setRequired(false);
        // prmthatchHouse		
        this.prmthatchHouse.setQueryInfo("com.kingdee.eas.farm.hatch.app.HatchHouseQuery");		
        this.prmthatchHouse.setEditable(true);		
        this.prmthatchHouse.setDisplayFormat("$name$");		
        this.prmthatchHouse.setEditFormat("$number$");		
        this.prmthatchHouse.setCommitFormat("$number$");		
        this.prmthatchHouse.setRequired(false);
        		prmthatchHouse.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.HatchHouseListUI prmthatchHouse_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmthatchHouse_F7ListUI == null) {
					try {
						prmthatchHouse_F7ListUI = new com.kingdee.eas.farm.hatch.client.HatchHouseListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmthatchHouse_F7ListUI));
					prmthatchHouse_F7ListUI.setF7Use(true,ctx);
					prmthatchHouse.setSelector(prmthatchHouse_F7ListUI);
				}
			}
		});
					
        // prmtoutArea		
        this.prmtoutArea.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.F7FarmerGroupQuery");		
        this.prmtoutArea.setEditable(true);		
        this.prmtoutArea.setDisplayFormat("$name$");		
        this.prmtoutArea.setEditFormat("$number$");		
        this.prmtoutArea.setCommitFormat("$number$");		
        this.prmtoutArea.setRequired(false);		
        this.prmtoutArea.setEnabled(false);		
        this.prmtoutArea.setVisible(false);
        // pkBEggCandingDate		
        this.pkBEggCandingDate.setRequired(false);		
        this.pkBEggCandingDate.setEnabled(false);
        // radioHorizon		
        this.radioHorizon.setText(resHelper.getString("radioHorizon.text"));
        // radioVertical		
        this.radioVertical.setText(resHelper.getString("radioVertical.text"));
        // radioOrigin		
        this.radioOrigin.setText(resHelper.getString("radioOrigin.text"));
        // genderType		
        this.genderType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.hatch.GenderType").toArray());		
        this.genderType.setRequired(false);		
        this.genderType.setVisible(false);		
        this.genderType.setEnabled(false);
        // prmtStorageOrgUnit		
        this.prmtStorageOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtStorageOrgUnit.setEditable(true);		
        this.prmtStorageOrgUnit.setDisplayFormat("$name$");		
        this.prmtStorageOrgUnit.setEditFormat("$number$");		
        this.prmtStorageOrgUnit.setCommitFormat("$number$");		
        this.prmtStorageOrgUnit.setRequired(false);		
        this.prmtStorageOrgUnit.setEnabled(false);
        // kdtAreaSummaryEntry
		String kdtAreaSummaryEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"outArea\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"farmer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"supplier\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"genderType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"qcEggType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"eggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{outArea}</t:Cell><t:Cell>$Resource{farmer}</t:Cell><t:Cell>$Resource{supplier}</t:Cell><t:Cell>$Resource{genderType}</t:Cell><t:Cell>$Resource{qcEggType}</t:Cell><t:Cell>$Resource{eggQty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtAreaSummaryEntry.setFormatXml(resHelper.translateString("kdtAreaSummaryEntry",kdtAreaSummaryEntryStrXML));		
        this.kdtAreaSummaryEntry.setVisible(false);

                this.kdtAreaSummaryEntry.putBindContents("editData",new String[] {"seq","outArea","farmer","supplier","genderType","qcEggType","eggQty"});


        this.kdtAreaSummaryEntry.checkParsed();
        final KDBizPromptBox kdtAreaSummaryEntry_outArea_PromptBox = new KDBizPromptBox();
        kdtAreaSummaryEntry_outArea_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.F7FarmerGroupQuery");
        kdtAreaSummaryEntry_outArea_PromptBox.setVisible(true);
        kdtAreaSummaryEntry_outArea_PromptBox.setEditable(true);
        kdtAreaSummaryEntry_outArea_PromptBox.setDisplayFormat("$number$");
        kdtAreaSummaryEntry_outArea_PromptBox.setEditFormat("$number$");
        kdtAreaSummaryEntry_outArea_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtAreaSummaryEntry_outArea_CellEditor = new KDTDefaultCellEditor(kdtAreaSummaryEntry_outArea_PromptBox);
        this.kdtAreaSummaryEntry.getColumn("outArea").setEditor(kdtAreaSummaryEntry_outArea_CellEditor);
        ObjectValueRender kdtAreaSummaryEntry_outArea_OVR = new ObjectValueRender();
        kdtAreaSummaryEntry_outArea_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtAreaSummaryEntry.getColumn("outArea").setRenderer(kdtAreaSummaryEntry_outArea_OVR);
        final KDBizPromptBox kdtAreaSummaryEntry_farmer_PromptBox = new KDBizPromptBox();
        kdtAreaSummaryEntry_farmer_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmersQuery");
        kdtAreaSummaryEntry_farmer_PromptBox.setVisible(true);
        kdtAreaSummaryEntry_farmer_PromptBox.setEditable(true);
        kdtAreaSummaryEntry_farmer_PromptBox.setDisplayFormat("$number$");
        kdtAreaSummaryEntry_farmer_PromptBox.setEditFormat("$number$");
        kdtAreaSummaryEntry_farmer_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtAreaSummaryEntry_farmer_CellEditor = new KDTDefaultCellEditor(kdtAreaSummaryEntry_farmer_PromptBox);
        this.kdtAreaSummaryEntry.getColumn("farmer").setEditor(kdtAreaSummaryEntry_farmer_CellEditor);
        ObjectValueRender kdtAreaSummaryEntry_farmer_OVR = new ObjectValueRender();
        kdtAreaSummaryEntry_farmer_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtAreaSummaryEntry.getColumn("farmer").setRenderer(kdtAreaSummaryEntry_farmer_OVR);
        			kdtAreaSummaryEntry_farmer_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI kdtAreaSummaryEntry_farmer_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtAreaSummaryEntry_farmer_PromptBox_F7ListUI == null) {
					try {
						kdtAreaSummaryEntry_farmer_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtAreaSummaryEntry_farmer_PromptBox_F7ListUI));
					kdtAreaSummaryEntry_farmer_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtAreaSummaryEntry_farmer_PromptBox.setSelector(kdtAreaSummaryEntry_farmer_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtAreaSummaryEntry_supplier_PromptBox = new KDBizPromptBox();
        kdtAreaSummaryEntry_supplier_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.F7SupplierDefaultQuery");
        kdtAreaSummaryEntry_supplier_PromptBox.setVisible(true);
        kdtAreaSummaryEntry_supplier_PromptBox.setEditable(true);
        kdtAreaSummaryEntry_supplier_PromptBox.setDisplayFormat("$number$");
        kdtAreaSummaryEntry_supplier_PromptBox.setEditFormat("$number$");
        kdtAreaSummaryEntry_supplier_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtAreaSummaryEntry_supplier_CellEditor = new KDTDefaultCellEditor(kdtAreaSummaryEntry_supplier_PromptBox);
        this.kdtAreaSummaryEntry.getColumn("supplier").setEditor(kdtAreaSummaryEntry_supplier_CellEditor);
        ObjectValueRender kdtAreaSummaryEntry_supplier_OVR = new ObjectValueRender();
        kdtAreaSummaryEntry_supplier_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtAreaSummaryEntry.getColumn("supplier").setRenderer(kdtAreaSummaryEntry_supplier_OVR);
        KDComboBox kdtAreaSummaryEntry_genderType_ComboBox = new KDComboBox();
        kdtAreaSummaryEntry_genderType_ComboBox.setName("kdtAreaSummaryEntry_genderType_ComboBox");
        kdtAreaSummaryEntry_genderType_ComboBox.setVisible(true);
        kdtAreaSummaryEntry_genderType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.hatch.GenderType").toArray());
        KDTDefaultCellEditor kdtAreaSummaryEntry_genderType_CellEditor = new KDTDefaultCellEditor(kdtAreaSummaryEntry_genderType_ComboBox);
        this.kdtAreaSummaryEntry.getColumn("genderType").setEditor(kdtAreaSummaryEntry_genderType_CellEditor);
        KDComboBox kdtAreaSummaryEntry_qcEggType_ComboBox = new KDComboBox();
        kdtAreaSummaryEntry_qcEggType_ComboBox.setName("kdtAreaSummaryEntry_qcEggType_ComboBox");
        kdtAreaSummaryEntry_qcEggType_ComboBox.setVisible(true);
        kdtAreaSummaryEntry_qcEggType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.hatch.QcEggTypeEnum").toArray());
        KDTDefaultCellEditor kdtAreaSummaryEntry_qcEggType_CellEditor = new KDTDefaultCellEditor(kdtAreaSummaryEntry_qcEggType_ComboBox);
        this.kdtAreaSummaryEntry.getColumn("qcEggType").setEditor(kdtAreaSummaryEntry_qcEggType_CellEditor);
        KDFormattedTextField kdtAreaSummaryEntry_eggQty_TextField = new KDFormattedTextField();
        kdtAreaSummaryEntry_eggQty_TextField.setName("kdtAreaSummaryEntry_eggQty_TextField");
        kdtAreaSummaryEntry_eggQty_TextField.setVisible(true);
        kdtAreaSummaryEntry_eggQty_TextField.setEditable(true);
        kdtAreaSummaryEntry_eggQty_TextField.setHorizontalAlignment(2);
        kdtAreaSummaryEntry_eggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtAreaSummaryEntry_eggQty_CellEditor = new KDTDefaultCellEditor(kdtAreaSummaryEntry_eggQty_TextField);
        this.kdtAreaSummaryEntry.getColumn("eggQty").setEditor(kdtAreaSummaryEntry_eggQty_CellEditor);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        // btnAdjust
        this.btnAdjust.setAction((IItemAction)ActionProxyFactory.getProxy(actionAdjust, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAdjust.setText(resHelper.getString("btnAdjust.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {kdtComputeEntry,txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,pkauditTime,baseStatus,prmthatchFactory,txtallHatchQty,prmtincubator,prmtoperator,eggType,prmthatchArea,prmtadminOrg,prmthatchHouse,prmtoutArea,chkisHasBEggCanding,pkBEggCandingDate,txtAddRows,genderType,prmtStorageOrgUnit,kdtEggEntry,kdtHatchBoxSummaryEntry,kdtAreaSummaryEntry,chkisMaterialOut,chkisInventory}));
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
        contCreator.setBounds(new Rectangle(373, 578, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(373, 578, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(373, 603, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(373, 603, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(725, 578, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(725, 578, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateTime.setBounds(new Rectangle(725, 603, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(725, 603, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(18, 9, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(18, 9, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(369, 33, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(369, 33, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(17, 114, 621, 19));
        this.add(contDescription, new KDLayout.Constraints(17, 114, 621, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(21, 578, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(21, 578, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(21, 603, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(21, 603, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbaseStatus.setBounds(new Rectangle(725, 9, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(725, 9, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conthatchFactory.setBounds(new Rectangle(369, 9, 270, 19));
        this.add(conthatchFactory, new KDLayout.Constraints(369, 9, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane2.setBounds(new Rectangle(16, 199, 977, 369));
        this.add(kDTabbedPane2, new KDLayout.Constraints(16, 199, 977, 369, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contallHatchQty.setBounds(new Rectangle(725, 33, 270, 19));
        this.add(contallHatchQty, new KDLayout.Constraints(725, 33, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contincubator.setBounds(new Rectangle(1001, 27, 270, 19));
        this.add(contincubator, new KDLayout.Constraints(1001, 27, 270, 19, 0));
        contoperator.setBounds(new Rectangle(725, 57, 270, 19));
        this.add(contoperator, new KDLayout.Constraints(725, 57, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conteggType.setBounds(new Rectangle(370, 60, 270, 19));
        this.add(conteggType, new KDLayout.Constraints(370, 60, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conthatchArea.setBounds(new Rectangle(931, 117, 270, 19));
        this.add(conthatchArea, new KDLayout.Constraints(931, 117, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contadminOrg.setBounds(new Rectangle(506, -11, 270, 19));
        this.add(contadminOrg, new KDLayout.Constraints(506, -11, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conthatchHouse.setBounds(new Rectangle(1002, 55, 270, 19));
        this.add(conthatchHouse, new KDLayout.Constraints(1002, 55, 270, 19, 0));
        contoutArea.setBounds(new Rectangle(660, -1, 270, 19));
        this.add(contoutArea, new KDLayout.Constraints(660, -1, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisHasBEggCanding.setBounds(new Rectangle(18, 91, 96, 19));
        this.add(chkisHasBEggCanding, new KDLayout.Constraints(18, 91, 96, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBEggCandingDate.setBounds(new Rectangle(369, 87, 270, 19));
        this.add(contBEggCandingDate, new KDLayout.Constraints(369, 87, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnViewSummary.setBounds(new Rectangle(911, 87, 73, 21));
        this.add(btnViewSummary, new KDLayout.Constraints(911, 87, 73, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        btnExcel.setBounds(new Rectangle(806, 87, 73, 21));
        this.add(btnExcel, new KDLayout.Constraints(806, 87, 73, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDPanel4.setBounds(new Rectangle(18, 144, 985, 45));
        this.add(kDPanel4, new KDLayout.Constraints(18, 144, 985, 45, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kdtComputeEntry.setBounds(new Rectangle(751, 540, 229, 37));
        kdtComputeEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtComputeEntry,new com.kingdee.eas.farm.hatch.BEggHatchBillEggEntryComputeEntryInfo(),null,false);
        this.add(kdtComputeEntry_detailPanel, new KDLayout.Constraints(751, 540, 229, 37, 0));
        contgenderType.setBounds(new Rectangle(19, 61, 270, 19));
        this.add(contgenderType, new KDLayout.Constraints(19, 61, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contStorageOrgUnit.setBounds(new Rectangle(18, 33, 270, 19));
        this.add(contStorageOrgUnit, new KDLayout.Constraints(18, 33, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisMaterialOut.setBounds(new Rectangle(121, 91, 160, 19));
        this.add(chkisMaterialOut, new KDLayout.Constraints(121, 91, 160, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDPanel1.setBounds(new Rectangle(1005, 200, 973, 338));
        this.add(kDPanel1, new KDLayout.Constraints(1005, 200, 973, 338, 0));
        chkisInventory.setBounds(new Rectangle(725, 118, 127, 19));
        this.add(chkisInventory, new KDLayout.Constraints(725, 118, 127, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //conthatchFactory
        conthatchFactory.setBoundEditor(prmthatchFactory);
        //kDTabbedPane2
        kDTabbedPane2.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        kDTabbedPane2.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 976, 336));        kdtEggEntry.setBounds(new Rectangle(9, 5, 955, 323));
        kdtEggEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEggEntry,new com.kingdee.eas.farm.hatch.BEggHatchBillEggEntryInfo(),null,false);
        kDPanel2.add(kdtEggEntry_detailPanel, new KDLayout.Constraints(9, 5, 955, 323, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtEggEntry_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("eggSourceType",new Integer(1));
vo.put("qcEggType",new Integer(101));
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        contRows.setBounds(new Rectangle(639, 10, 199, 19));
        kDPanel2.add(contRows, new KDLayout.Constraints(639, 10, 199, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnAddRow.setBounds(new Rectangle(863, 11, 73, 21));
        kDPanel2.add(btnAddRow, new KDLayout.Constraints(863, 11, 73, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contRows
        contRows.setBoundEditor(txtAddRows);
        //kDPanel3
        kDPanel3.setLayout(new KDLayout());
        kDPanel3.putClientProperty("OriginalBounds", new Rectangle(0, 0, 976, 336));        kdtHatchBoxSummaryEntry.setBounds(new Rectangle(3, 4, 963, 356));
        kdtHatchBoxSummaryEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtHatchBoxSummaryEntry,new com.kingdee.eas.farm.hatch.BEggHatchBillHatchBoxSummaryEntryInfo(),null,false);
        kDPanel3.add(kdtHatchBoxSummaryEntry_detailPanel, new KDLayout.Constraints(3, 4, 963, 356, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contallHatchQty
        contallHatchQty.setBoundEditor(txtallHatchQty);
        //contincubator
        contincubator.setBoundEditor(prmtincubator);
        //contoperator
        contoperator.setBoundEditor(prmtoperator);
        //conteggType
        conteggType.setBoundEditor(eggType);
        //conthatchArea
        conthatchArea.setBoundEditor(prmthatchArea);
        //contadminOrg
        contadminOrg.setBoundEditor(prmtadminOrg);
        //conthatchHouse
        conthatchHouse.setBoundEditor(prmthatchHouse);
        //contoutArea
        contoutArea.setBoundEditor(prmtoutArea);
        //contBEggCandingDate
        contBEggCandingDate.setBoundEditor(pkBEggCandingDate);
        //kDPanel4
        kDPanel4.setLayout(new KDLayout());
        kDPanel4.putClientProperty("OriginalBounds", new Rectangle(18, 144, 985, 45));        radioHorizon.setBounds(new Rectangle(28, 15, 140, 19));
        kDPanel4.add(radioHorizon, new KDLayout.Constraints(28, 15, 140, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        radioVertical.setBounds(new Rectangle(258, 15, 140, 19));
        kDPanel4.add(radioVertical, new KDLayout.Constraints(258, 15, 140, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        radioOrigin.setBounds(new Rectangle(484, 15, 140, 19));
        kDPanel4.add(radioOrigin, new KDLayout.Constraints(484, 15, 140, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contgenderType
        contgenderType.setBoundEditor(genderType);
        //contStorageOrgUnit
        contStorageOrgUnit.setBoundEditor(prmtStorageOrgUnit);
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(1005, 200, 973, 338));        kdtAreaSummaryEntry.setBounds(new Rectangle(91, 56, 961, 357));
        kdtAreaSummaryEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtAreaSummaryEntry,new com.kingdee.eas.farm.hatch.BEggHatchBillAreaSummaryEntryInfo(),null,false);
        kDPanel1.add(kdtAreaSummaryEntry_detailPanel, new KDLayout.Constraints(91, 56, 961, 357, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));

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
        this.toolBar.add(btnAdjust);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("isHasBEggCanding", boolean.class, this.chkisHasBEggCanding, "selected");
		dataBinder.registerBinding("EggEntry.ComputeEntry.seq", int.class, this.kdtComputeEntry, "seq.text");
		dataBinder.registerBinding("EggEntry.ComputeEntry", com.kingdee.eas.farm.hatch.BEggHatchBillEggEntryComputeEntryInfo.class, this.kdtComputeEntry, "userObject");
		dataBinder.registerBinding("EggEntry.ComputeEntry.floorQty", int.class, this.kdtComputeEntry, "floorQty.text");
		dataBinder.registerBinding("EggEntry.ComputeEntry.carQty", int.class, this.kdtComputeEntry, "carQty.text");
		dataBinder.registerBinding("EggEntry.ComputeEntry.plateQty", int.class, this.kdtComputeEntry, "plateQty.text");
		dataBinder.registerBinding("EggEntry.ComputeEntry.meiQty", int.class, this.kdtComputeEntry, "meiQty.text");
		dataBinder.registerBinding("isMaterialOut", boolean.class, this.chkisMaterialOut, "selected");
		dataBinder.registerBinding("isInventory", boolean.class, this.chkisInventory, "selected");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("hatchFactory", com.kingdee.eas.farm.hatch.HatchBaseDataInfo.class, this.prmthatchFactory, "data");
		dataBinder.registerBinding("EggEntry.seq", int.class, this.kdtEggEntry, "seq.text");
		dataBinder.registerBinding("EggEntry", com.kingdee.eas.farm.hatch.BEggHatchBillEggEntryInfo.class, this.kdtEggEntry, "userObject");
		dataBinder.registerBinding("EggEntry.eggSourceType", com.kingdee.util.enums.Enum.class, this.kdtEggEntry, "eggSourceType.text");
		dataBinder.registerBinding("EggEntry.farm", java.lang.Object.class, this.kdtEggEntry, "farm.text");
		dataBinder.registerBinding("EggEntry.eggHouse", java.lang.Object.class, this.kdtEggEntry, "eggHouse.text");
		dataBinder.registerBinding("EggEntry.eggLog", String.class, this.kdtEggEntry, "eggLog.text");
		dataBinder.registerBinding("EggEntry.eggQty", int.class, this.kdtEggEntry, "eggQty.text");
		dataBinder.registerBinding("EggEntry.outFarm", java.lang.Object.class, this.kdtEggEntry, "outFarm.text");
		dataBinder.registerBinding("EggEntry.farmer", java.lang.Object.class, this.kdtEggEntry, "farmer.text");
		dataBinder.registerBinding("EggEntry.supplier", java.lang.Object.class, this.kdtEggEntry, "supplier.text");
		dataBinder.registerBinding("EggEntry.material", java.lang.Object.class, this.kdtEggEntry, "material.text");
		dataBinder.registerBinding("EggEntry.breedBatch", java.lang.Object.class, this.kdtEggEntry, "breedBatch.text");
		dataBinder.registerBinding("EggEntry.babyBatch", String.class, this.kdtEggEntry, "babyBatch.text");
		dataBinder.registerBinding("EggEntry.outBatch", java.lang.Object.class, this.kdtEggEntry, "outBatch.text");
		dataBinder.registerBinding("EggEntry.house", java.lang.Object.class, this.kdtEggEntry, "house.text");
		dataBinder.registerBinding("EggEntry.hatchHouse", java.lang.Object.class, this.kdtEggEntry, "hatchHouse.text");
		dataBinder.registerBinding("EggEntry.incubator", java.lang.Object.class, this.kdtEggEntry, "incubator.text");
		dataBinder.registerBinding("EggEntry.outHouse", java.lang.Object.class, this.kdtEggEntry, "outHouse.text");
		dataBinder.registerBinding("EggEntry.qc1lv1Qty", int.class, this.kdtEggEntry, "qc1lv1Qty.text");
		dataBinder.registerBinding("EggEntry.qc1lv2Qty", int.class, this.kdtEggEntry, "qc1lv2Qty.text");
		dataBinder.registerBinding("EggEntry.qc2lv1Qty", int.class, this.kdtEggEntry, "qc2lv1Qty.text");
		dataBinder.registerBinding("EggEntry.qc2lv2Qty", int.class, this.kdtEggEntry, "qc2lv2Qty.text");
		dataBinder.registerBinding("EggEntry.qc4lv1Qty", int.class, this.kdtEggEntry, "qc4lv1Qty.text");
		dataBinder.registerBinding("EggEntry.qc3lv1Qty", int.class, this.kdtEggEntry, "qc3lv1Qty.text");
		dataBinder.registerBinding("EggEntry.qc5lv1Qty", int.class, this.kdtEggEntry, "qc5lv1Qty.text");
		dataBinder.registerBinding("EggEntry.qc6lv1Qty", int.class, this.kdtEggEntry, "qc6lv1Qty.text");
		dataBinder.registerBinding("EggEntry.hatchCarNum", String.class, this.kdtEggEntry, "hatchCarNum.text");
		dataBinder.registerBinding("EggEntry.outArea", java.lang.Object.class, this.kdtEggEntry, "outArea.text");
		dataBinder.registerBinding("EggEntry.isMix", boolean.class, this.kdtEggEntry, "isMix.text");
		dataBinder.registerBinding("EggEntry.qcEggType", com.kingdee.util.enums.Enum.class, this.kdtEggEntry, "qcEggType.text");
		dataBinder.registerBinding("EggEntry.dayAge", int.class, this.kdtEggEntry, "dayAge.text");
		dataBinder.registerBinding("EggEntry.isFormal", boolean.class, this.kdtEggEntry, "isFormal.text");
		dataBinder.registerBinding("EggEntry.weeklyAge", String.class, this.kdtEggEntry, "weeklyAge.text");
		dataBinder.registerBinding("EggEntry.genderType", com.kingdee.util.enums.Enum.class, this.kdtEggEntry, "genderType.text");
		dataBinder.registerBinding("EggEntry.floorQty", int.class, this.kdtEggEntry, "floorQty.text");
		dataBinder.registerBinding("EggEntry.meiQty", int.class, this.kdtEggEntry, "meiQty.text");
		dataBinder.registerBinding("EggEntry.plateQty", int.class, this.kdtEggEntry, "plateQty.text");
		dataBinder.registerBinding("EggEntry.carQty", int.class, this.kdtEggEntry, "carQty.text");
		dataBinder.registerBinding("EggEntry.eggDate", java.util.Date.class, this.kdtEggEntry, "eggDate.text");
		dataBinder.registerBinding("EggEntry.tidyEggDate", java.util.Date.class, this.kdtEggEntry, "tidyEggDate.text");
		dataBinder.registerBinding("EggEntry.mdperson", String.class, this.kdtEggEntry, "mdperson.text");
		dataBinder.registerBinding("EggEntry.CostObject", java.lang.Object.class, this.kdtEggEntry, "CostObject.text");
		dataBinder.registerBinding("EggEntry.standEgg", int.class, this.kdtEggEntry, "standEgg.text");
		dataBinder.registerBinding("EggEntry.reFundEgg", int.class, this.kdtEggEntry, "reFundEgg.text");
		dataBinder.registerBinding("EggEntry.remark", String.class, this.kdtEggEntry, "remark.text");
		dataBinder.registerBinding("EggEntry.BreedData", java.lang.Object.class, this.kdtEggEntry, "BreedData.text");
		dataBinder.registerBinding("EggEntry.breedDataNew", java.lang.Object.class, this.kdtEggEntry, "breedDataNew.text");
		dataBinder.registerBinding("BIMUDF0083", int.class, this.txtAddRows, "value");
		dataBinder.registerBinding("HatchBoxSummaryEntry.seq", int.class, this.kdtHatchBoxSummaryEntry, "seq.text");
		dataBinder.registerBinding("HatchBoxSummaryEntry", com.kingdee.eas.farm.hatch.BEggHatchBillHatchBoxSummaryEntryInfo.class, this.kdtHatchBoxSummaryEntry, "userObject");
		dataBinder.registerBinding("HatchBoxSummaryEntry.incubator", java.lang.Object.class, this.kdtHatchBoxSummaryEntry, "incubator.text");
		dataBinder.registerBinding("HatchBoxSummaryEntry.hatchHouse", java.lang.Object.class, this.kdtHatchBoxSummaryEntry, "hatchHouse.text");
		dataBinder.registerBinding("HatchBoxSummaryEntry.eggQty", int.class, this.kdtHatchBoxSummaryEntry, "eggQty.text");
		dataBinder.registerBinding("allHatchQty", int.class, this.txtallHatchQty, "value");
		dataBinder.registerBinding("incubator", com.kingdee.eas.farm.hatch.IncubatorInfo.class, this.prmtincubator, "data");
		dataBinder.registerBinding("operator", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtoperator, "data");
		dataBinder.registerBinding("eggType", com.kingdee.eas.farm.hatch.EggType.class, this.eggType, "selectedItem");
		dataBinder.registerBinding("hatchArea", com.kingdee.eas.farm.hatch.HatchAreaInfo.class, this.prmthatchArea, "data");
		dataBinder.registerBinding("adminOrg", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtadminOrg, "data");
		dataBinder.registerBinding("hatchHouse", com.kingdee.eas.farm.hatch.HatchHouseInfo.class, this.prmthatchHouse, "data");
		dataBinder.registerBinding("outArea", com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo.class, this.prmtoutArea, "data");
		dataBinder.registerBinding("BEggCandingDate", java.util.Date.class, this.pkBEggCandingDate, "value");
		dataBinder.registerBinding("genderType", com.kingdee.eas.farm.stocking.hatch.GenderType.class, this.genderType, "selectedItem");
		dataBinder.registerBinding("StorageOrgUnit", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtStorageOrgUnit, "data");
		dataBinder.registerBinding("AreaSummaryEntry.seq", int.class, this.kdtAreaSummaryEntry, "seq.text");
		dataBinder.registerBinding("AreaSummaryEntry", com.kingdee.eas.farm.hatch.BEggHatchBillAreaSummaryEntryInfo.class, this.kdtAreaSummaryEntry, "userObject");
		dataBinder.registerBinding("AreaSummaryEntry.outArea", java.lang.Object.class, this.kdtAreaSummaryEntry, "outArea.text");
		dataBinder.registerBinding("AreaSummaryEntry.qcEggType", com.kingdee.util.enums.Enum.class, this.kdtAreaSummaryEntry, "qcEggType.text");
		dataBinder.registerBinding("AreaSummaryEntry.eggQty", int.class, this.kdtAreaSummaryEntry, "eggQty.text");
		dataBinder.registerBinding("AreaSummaryEntry.supplier", java.lang.Object.class, this.kdtAreaSummaryEntry, "supplier.text");
		dataBinder.registerBinding("AreaSummaryEntry.genderType", com.kingdee.util.enums.Enum.class, this.kdtAreaSummaryEntry, "genderType.text");
		dataBinder.registerBinding("AreaSummaryEntry.farmer", java.lang.Object.class, this.kdtAreaSummaryEntry, "farmer.text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.hatch.app.BEggHatchBillEditUIHandler";
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
        this.kdtComputeEntry.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.hatch.BEggHatchBillInfo)ov;
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
	 * ????????§µ??
	 */
	protected void registerValidator() {
    	getValidateHelper().setCustomValidator( getValidator() );
		getValidateHelper().registerBindProperty("isHasBEggCanding", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.ComputeEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.ComputeEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.ComputeEntry.floorQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.ComputeEntry.carQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.ComputeEntry.plateQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.ComputeEntry.meiQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isMaterialOut", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isInventory", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hatchFactory", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.eggSourceType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.eggHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.eggLog", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.eggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.outFarm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.supplier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.breedBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.babyBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.outBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.house", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.hatchHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.incubator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.outHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.qc1lv1Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.qc1lv2Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.qc2lv1Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.qc2lv2Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.qc4lv1Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.qc3lv1Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.qc5lv1Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.qc6lv1Qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.hatchCarNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.outArea", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.isMix", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.qcEggType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.dayAge", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.isFormal", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.weeklyAge", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.genderType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.floorQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.meiQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.plateQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.carQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.eggDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.tidyEggDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.mdperson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.CostObject", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.standEgg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.reFundEgg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.BreedData", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EggEntry.breedDataNew", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BIMUDF0083", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HatchBoxSummaryEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HatchBoxSummaryEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HatchBoxSummaryEntry.incubator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HatchBoxSummaryEntry.hatchHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HatchBoxSummaryEntry.eggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allHatchQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("incubator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("operator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eggType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hatchArea", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("adminOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hatchHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("outArea", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BEggCandingDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("genderType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StorageOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AreaSummaryEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AreaSummaryEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AreaSummaryEntry.outArea", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AreaSummaryEntry.qcEggType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AreaSummaryEntry.eggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AreaSummaryEntry.supplier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AreaSummaryEntry.genderType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AreaSummaryEntry.farmer", ValidateHelper.ON_SAVE);    		
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
     * output prmthatchFactory_dataChanged method
     */
    protected void prmthatchFactory_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output prmthatchArea_dataChanged method
     */
    protected void prmthatchArea_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        //write your code here
    }


    /**
     * output kdtEggEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEggEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("farmer".equalsIgnoreCase(kdtEggEntry.getColumn(colIndex).getKey())) {
kdtEggEntry.getCell(rowIndex,"outArea").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEggEntry.getCell(rowIndex,"farmer").getValue(),"treeid"));

}

    if ("outBatch".equalsIgnoreCase(kdtEggEntry.getColumn(colIndex).getKey())) {
kdtEggEntry.getCell(rowIndex,"BreedData").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEggEntry.getCell(rowIndex,"outBatch").getValue(),"breedData.name")));

}

    if ("qc1lv1Qty".equalsIgnoreCase(kdtEggEntry.getColumn(colIndex).getKey())) {
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));

}

    if ("qc1lv2Qty".equalsIgnoreCase(kdtEggEntry.getColumn(colIndex).getKey())) {
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));

}

    if ("qc2lv1Qty".equalsIgnoreCase(kdtEggEntry.getColumn(colIndex).getKey())) {
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));

}

    if ("qc2lv2Qty".equalsIgnoreCase(kdtEggEntry.getColumn(colIndex).getKey())) {
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));

}

    if ("qc3lv1Qty".equalsIgnoreCase(kdtEggEntry.getColumn(colIndex).getKey())) {
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));

}

    if ("qc4lv1Qty".equalsIgnoreCase(kdtEggEntry.getColumn(colIndex).getKey())) {
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));

}

    if ("qc5lv1Qty".equalsIgnoreCase(kdtEggEntry.getColumn(colIndex).getKey())) {
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));

}

    if ("qc6lv1Qty".equalsIgnoreCase(kdtEggEntry.getColumn(colIndex).getKey())) {
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));
kdtEggEntry.getCell(rowIndex,"eggQty").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc1lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc2lv2Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc4lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc3lv1Qty").getValue())+ (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc5lv1Qty").getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEggEntry.getCell(rowIndex,"qc6lv1Qty").getValue())))))))));

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
        sic.add(new SelectorItemInfo("isHasBEggCanding"));
    	sic.add(new SelectorItemInfo("EggEntry.ComputeEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.ComputeEntry.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.ComputeEntry.id"));
		}
    	sic.add(new SelectorItemInfo("EggEntry.ComputeEntry.floorQty"));
    	sic.add(new SelectorItemInfo("EggEntry.ComputeEntry.carQty"));
    	sic.add(new SelectorItemInfo("EggEntry.ComputeEntry.plateQty"));
    	sic.add(new SelectorItemInfo("EggEntry.ComputeEntry.meiQty"));
        sic.add(new SelectorItemInfo("isMaterialOut"));
        sic.add(new SelectorItemInfo("isInventory"));
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
        sic.add(new SelectorItemInfo("baseStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("hatchFactory.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("hatchFactory.id"));
        	sic.add(new SelectorItemInfo("hatchFactory.number"));
        	sic.add(new SelectorItemInfo("hatchFactory.name"));
		}
    	sic.add(new SelectorItemInfo("EggEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("EggEntry.eggSourceType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.farm.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.farm.id"));
			sic.add(new SelectorItemInfo("EggEntry.farm.name"));
        	sic.add(new SelectorItemInfo("EggEntry.farm.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.eggHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.eggHouse.id"));
			sic.add(new SelectorItemInfo("EggEntry.eggHouse.name"));
        	sic.add(new SelectorItemInfo("EggEntry.eggHouse.number"));
		}
    	sic.add(new SelectorItemInfo("EggEntry.eggLog"));
    	sic.add(new SelectorItemInfo("EggEntry.eggQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.outFarm.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.outFarm.id"));
			sic.add(new SelectorItemInfo("EggEntry.outFarm.name"));
        	sic.add(new SelectorItemInfo("EggEntry.outFarm.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.farmer.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.farmer.id"));
			sic.add(new SelectorItemInfo("EggEntry.farmer.name"));
        	sic.add(new SelectorItemInfo("EggEntry.farmer.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.supplier.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.supplier.id"));
			sic.add(new SelectorItemInfo("EggEntry.supplier.name"));
        	sic.add(new SelectorItemInfo("EggEntry.supplier.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.material.id"));
			sic.add(new SelectorItemInfo("EggEntry.material.name"));
        	sic.add(new SelectorItemInfo("EggEntry.material.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.breedBatch.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.breedBatch.id"));
			sic.add(new SelectorItemInfo("EggEntry.breedBatch.name"));
        	sic.add(new SelectorItemInfo("EggEntry.breedBatch.number"));
		}
    	sic.add(new SelectorItemInfo("EggEntry.babyBatch"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.outBatch.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.outBatch.id"));
			sic.add(new SelectorItemInfo("EggEntry.outBatch.name"));
        	sic.add(new SelectorItemInfo("EggEntry.outBatch.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.house.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.house.id"));
			sic.add(new SelectorItemInfo("EggEntry.house.name"));
        	sic.add(new SelectorItemInfo("EggEntry.house.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.hatchHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.hatchHouse.id"));
			sic.add(new SelectorItemInfo("EggEntry.hatchHouse.name"));
        	sic.add(new SelectorItemInfo("EggEntry.hatchHouse.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.incubator.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.incubator.id"));
			sic.add(new SelectorItemInfo("EggEntry.incubator.name"));
        	sic.add(new SelectorItemInfo("EggEntry.incubator.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.outHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.outHouse.id"));
			sic.add(new SelectorItemInfo("EggEntry.outHouse.name"));
        	sic.add(new SelectorItemInfo("EggEntry.outHouse.number"));
		}
    	sic.add(new SelectorItemInfo("EggEntry.qc1lv1Qty"));
    	sic.add(new SelectorItemInfo("EggEntry.qc1lv2Qty"));
    	sic.add(new SelectorItemInfo("EggEntry.qc2lv1Qty"));
    	sic.add(new SelectorItemInfo("EggEntry.qc2lv2Qty"));
    	sic.add(new SelectorItemInfo("EggEntry.qc4lv1Qty"));
    	sic.add(new SelectorItemInfo("EggEntry.qc3lv1Qty"));
    	sic.add(new SelectorItemInfo("EggEntry.qc5lv1Qty"));
    	sic.add(new SelectorItemInfo("EggEntry.qc6lv1Qty"));
    	sic.add(new SelectorItemInfo("EggEntry.hatchCarNum"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.outArea.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.outArea.id"));
			sic.add(new SelectorItemInfo("EggEntry.outArea.name"));
        	sic.add(new SelectorItemInfo("EggEntry.outArea.number"));
		}
    	sic.add(new SelectorItemInfo("EggEntry.isMix"));
    	sic.add(new SelectorItemInfo("EggEntry.qcEggType"));
    	sic.add(new SelectorItemInfo("EggEntry.dayAge"));
    	sic.add(new SelectorItemInfo("EggEntry.isFormal"));
    	sic.add(new SelectorItemInfo("EggEntry.weeklyAge"));
    	sic.add(new SelectorItemInfo("EggEntry.genderType"));
    	sic.add(new SelectorItemInfo("EggEntry.floorQty"));
    	sic.add(new SelectorItemInfo("EggEntry.meiQty"));
    	sic.add(new SelectorItemInfo("EggEntry.plateQty"));
    	sic.add(new SelectorItemInfo("EggEntry.carQty"));
    	sic.add(new SelectorItemInfo("EggEntry.eggDate"));
    	sic.add(new SelectorItemInfo("EggEntry.tidyEggDate"));
    	sic.add(new SelectorItemInfo("EggEntry.mdperson"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.CostObject.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.CostObject.id"));
			sic.add(new SelectorItemInfo("EggEntry.CostObject.name"));
        	sic.add(new SelectorItemInfo("EggEntry.CostObject.number"));
		}
    	sic.add(new SelectorItemInfo("EggEntry.standEgg"));
    	sic.add(new SelectorItemInfo("EggEntry.reFundEgg"));
    	sic.add(new SelectorItemInfo("EggEntry.remark"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.BreedData.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.BreedData.id"));
			sic.add(new SelectorItemInfo("EggEntry.BreedData.name"));
        	sic.add(new SelectorItemInfo("EggEntry.BreedData.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EggEntry.breedDataNew.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("EggEntry.breedDataNew.id"));
			sic.add(new SelectorItemInfo("EggEntry.breedDataNew.name"));
        	sic.add(new SelectorItemInfo("EggEntry.breedDataNew.number"));
		}
        sic.add(new SelectorItemInfo("BIMUDF0083"));
    	sic.add(new SelectorItemInfo("HatchBoxSummaryEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("HatchBoxSummaryEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("HatchBoxSummaryEntry.incubator.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("HatchBoxSummaryEntry.incubator.id"));
			sic.add(new SelectorItemInfo("HatchBoxSummaryEntry.incubator.name"));
        	sic.add(new SelectorItemInfo("HatchBoxSummaryEntry.incubator.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("HatchBoxSummaryEntry.hatchHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("HatchBoxSummaryEntry.hatchHouse.id"));
			sic.add(new SelectorItemInfo("HatchBoxSummaryEntry.hatchHouse.name"));
        	sic.add(new SelectorItemInfo("HatchBoxSummaryEntry.hatchHouse.number"));
		}
    	sic.add(new SelectorItemInfo("HatchBoxSummaryEntry.eggQty"));
        sic.add(new SelectorItemInfo("allHatchQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("incubator.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("incubator.id"));
        	sic.add(new SelectorItemInfo("incubator.number"));
        	sic.add(new SelectorItemInfo("incubator.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("operator.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("operator.id"));
        	sic.add(new SelectorItemInfo("operator.number"));
        	sic.add(new SelectorItemInfo("operator.name"));
		}
        sic.add(new SelectorItemInfo("eggType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("hatchArea.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("hatchArea.id"));
        	sic.add(new SelectorItemInfo("hatchArea.number"));
        	sic.add(new SelectorItemInfo("hatchArea.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("adminOrg.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("adminOrg.id"));
        	sic.add(new SelectorItemInfo("adminOrg.number"));
        	sic.add(new SelectorItemInfo("adminOrg.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("hatchHouse.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("hatchHouse.id"));
        	sic.add(new SelectorItemInfo("hatchHouse.number"));
        	sic.add(new SelectorItemInfo("hatchHouse.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("outArea.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("outArea.id"));
        	sic.add(new SelectorItemInfo("outArea.number"));
        	sic.add(new SelectorItemInfo("outArea.name"));
		}
        sic.add(new SelectorItemInfo("BEggCandingDate"));
        sic.add(new SelectorItemInfo("genderType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("StorageOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("StorageOrgUnit.id"));
        	sic.add(new SelectorItemInfo("StorageOrgUnit.number"));
        	sic.add(new SelectorItemInfo("StorageOrgUnit.name"));
		}
    	sic.add(new SelectorItemInfo("AreaSummaryEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("AreaSummaryEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("AreaSummaryEntry.outArea.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("AreaSummaryEntry.outArea.id"));
			sic.add(new SelectorItemInfo("AreaSummaryEntry.outArea.name"));
        	sic.add(new SelectorItemInfo("AreaSummaryEntry.outArea.number"));
		}
    	sic.add(new SelectorItemInfo("AreaSummaryEntry.qcEggType"));
    	sic.add(new SelectorItemInfo("AreaSummaryEntry.eggQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("AreaSummaryEntry.supplier.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("AreaSummaryEntry.supplier.id"));
			sic.add(new SelectorItemInfo("AreaSummaryEntry.supplier.name"));
        	sic.add(new SelectorItemInfo("AreaSummaryEntry.supplier.number"));
		}
    	sic.add(new SelectorItemInfo("AreaSummaryEntry.genderType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("AreaSummaryEntry.farmer.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("AreaSummaryEntry.farmer.id"));
			sic.add(new SelectorItemInfo("AreaSummaryEntry.farmer.name"));
        	sic.add(new SelectorItemInfo("AreaSummaryEntry.farmer.number"));
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
        com.kingdee.eas.farm.hatch.BEggHatchBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.hatch.BEggHatchBillFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionAdjust_actionPerformed method
     */
    public void actionAdjust_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.hatch.BEggHatchBillFactory.getRemoteInstance().adjust(editData);
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
	public RequestContext prepareActionAdjust(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAdjust() {
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
            innerActionPerformed("eas", AbstractBEggHatchBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractBEggHatchBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionAdjust class
     */     
    protected class ActionAdjust extends ItemAction {     
    
        public ActionAdjust()
        {
            this(null);
        }

        public ActionAdjust(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionAdjust.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAdjust.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAdjust.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractBEggHatchBillEditUI.this, "ActionAdjust", "actionAdjust_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.hatch.client", "BEggHatchBillEditUI");
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
        return com.kingdee.eas.farm.hatch.client.BEggHatchBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.hatch.BEggHatchBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.hatch.BEggHatchBillInfo objectValue = new com.kingdee.eas.farm.hatch.BEggHatchBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/hatch/BEggHatchBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.hatch.app.BEggHatchBillQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"ÒµÎñÈÕÆÚ"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmthatchFactory.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"·õ»¯³¡"});
		}
		for (int i=0,n=kdtEggEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEggEntry.getCell(i,"CostObject").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"³É±¾¶ÔÏó"});
			}
		}
		for (int i=0,n=kdtEggEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEggEntry.getCell(i,"eggHouse").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"µ°¿â"});
			}
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtEggEntry;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("eggType","Grand");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}        
				protected void setTableToSumField() {
			setTableToSumField(kdtEggEntry,new String[] {"eggQty"});
		}


}