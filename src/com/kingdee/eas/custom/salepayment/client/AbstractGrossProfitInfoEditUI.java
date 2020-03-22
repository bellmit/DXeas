/**
 * output package name
 */
package com.kingdee.eas.custom.salepayment.client;

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
public abstract class AbstractGrossProfitInfoEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractGrossProfitInfoEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyear;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmonth;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallGrossProfit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contindexType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsaleStimulateInfo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contquarter;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmonthRecAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallNoTaxAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallStandardCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsaler;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrecStandardCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrecGrossProfit;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyear;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmonth;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallGrossProfit;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.swing.KDComboBox indexType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsaleStimulateInfo;
    protected com.kingdee.bos.ctrl.swing.KDComboBox quarter;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmonthRecAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallNoTaxAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallStandardCost;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsaler;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtRecEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtRecEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtrecStandardCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtrecGrossProfit;
    protected com.kingdee.eas.custom.salepayment.GrossProfitInfoInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractGrossProfitInfoEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractGrossProfitInfoEditUI.class.getName());
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
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyear = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmonth = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallGrossProfit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contindexType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsaleStimulateInfo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contquarter = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmonthRecAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallNoTaxAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallStandardCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsaler = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contrecStandardCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrecGrossProfit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtyear = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmonth = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtallGrossProfit = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.indexType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtsaleStimulateInfo = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.quarter = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtmonthRecAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallNoTaxAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallStandardCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtsaler = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtRecEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.txtrecStandardCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtrecGrossProfit = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.contcompany.setName("contcompany");
        this.contyear.setName("contyear");
        this.contmonth.setName("contmonth");
        this.contauditTime.setName("contauditTime");
        this.contallGrossProfit.setName("contallGrossProfit");
        this.contbaseStatus.setName("contbaseStatus");
        this.contindexType.setName("contindexType");
        this.contsaleStimulateInfo.setName("contsaleStimulateInfo");
        this.contquarter.setName("contquarter");
        this.contmonthRecAmount.setName("contmonthRecAmount");
        this.contallNoTaxAmount.setName("contallNoTaxAmount");
        this.contallStandardCost.setName("contallStandardCost");
        this.contsaler.setName("contsaler");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contrecStandardCost.setName("contrecStandardCost");
        this.contrecGrossProfit.setName("contrecGrossProfit");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtcompany.setName("prmtcompany");
        this.txtyear.setName("txtyear");
        this.txtmonth.setName("txtmonth");
        this.pkauditTime.setName("pkauditTime");
        this.txtallGrossProfit.setName("txtallGrossProfit");
        this.baseStatus.setName("baseStatus");
        this.indexType.setName("indexType");
        this.prmtsaleStimulateInfo.setName("prmtsaleStimulateInfo");
        this.quarter.setName("quarter");
        this.txtmonthRecAmount.setName("txtmonthRecAmount");
        this.txtallNoTaxAmount.setName("txtallNoTaxAmount");
        this.txtallStandardCost.setName("txtallStandardCost");
        this.prmtsaler.setName("prmtsaler");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kdtEntrys.setName("kdtEntrys");
        this.kdtRecEntry.setName("kdtRecEntry");
        this.txtrecStandardCost.setName("txtrecStandardCost");
        this.txtrecGrossProfit.setName("txtrecGrossProfit");
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
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contyear		
        this.contyear.setBoundLabelText(resHelper.getString("contyear.boundLabelText"));		
        this.contyear.setBoundLabelLength(100);		
        this.contyear.setBoundLabelUnderline(true);		
        this.contyear.setVisible(true);
        // contmonth		
        this.contmonth.setBoundLabelText(resHelper.getString("contmonth.boundLabelText"));		
        this.contmonth.setBoundLabelLength(100);		
        this.contmonth.setBoundLabelUnderline(true);		
        this.contmonth.setVisible(true);
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // contallGrossProfit		
        this.contallGrossProfit.setBoundLabelText(resHelper.getString("contallGrossProfit.boundLabelText"));		
        this.contallGrossProfit.setBoundLabelLength(100);		
        this.contallGrossProfit.setBoundLabelUnderline(true);		
        this.contallGrossProfit.setVisible(true);
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);
        // contindexType		
        this.contindexType.setBoundLabelText(resHelper.getString("contindexType.boundLabelText"));		
        this.contindexType.setBoundLabelLength(100);		
        this.contindexType.setBoundLabelUnderline(true);		
        this.contindexType.setVisible(true);
        // contsaleStimulateInfo		
        this.contsaleStimulateInfo.setBoundLabelText(resHelper.getString("contsaleStimulateInfo.boundLabelText"));		
        this.contsaleStimulateInfo.setBoundLabelLength(100);		
        this.contsaleStimulateInfo.setBoundLabelUnderline(true);		
        this.contsaleStimulateInfo.setVisible(true);
        // contquarter		
        this.contquarter.setBoundLabelText(resHelper.getString("contquarter.boundLabelText"));		
        this.contquarter.setBoundLabelLength(100);		
        this.contquarter.setBoundLabelUnderline(true);		
        this.contquarter.setVisible(true);
        // contmonthRecAmount		
        this.contmonthRecAmount.setBoundLabelText(resHelper.getString("contmonthRecAmount.boundLabelText"));		
        this.contmonthRecAmount.setBoundLabelLength(100);		
        this.contmonthRecAmount.setBoundLabelUnderline(true);		
        this.contmonthRecAmount.setVisible(true);
        // contallNoTaxAmount		
        this.contallNoTaxAmount.setBoundLabelText(resHelper.getString("contallNoTaxAmount.boundLabelText"));		
        this.contallNoTaxAmount.setBoundLabelLength(100);		
        this.contallNoTaxAmount.setBoundLabelUnderline(true);		
        this.contallNoTaxAmount.setVisible(true);
        // contallStandardCost		
        this.contallStandardCost.setBoundLabelText(resHelper.getString("contallStandardCost.boundLabelText"));		
        this.contallStandardCost.setBoundLabelLength(100);		
        this.contallStandardCost.setBoundLabelUnderline(true);		
        this.contallStandardCost.setVisible(true);
        // contsaler		
        this.contsaler.setBoundLabelText(resHelper.getString("contsaler.boundLabelText"));		
        this.contsaler.setBoundLabelLength(100);		
        this.contsaler.setBoundLabelUnderline(true);		
        this.contsaler.setVisible(true);
        // kDTabbedPane1
        // contrecStandardCost		
        this.contrecStandardCost.setBoundLabelText(resHelper.getString("contrecStandardCost.boundLabelText"));		
        this.contrecStandardCost.setBoundLabelLength(100);		
        this.contrecStandardCost.setBoundLabelUnderline(true);		
        this.contrecStandardCost.setVisible(true);
        // contrecGrossProfit		
        this.contrecGrossProfit.setBoundLabelText(resHelper.getString("contrecGrossProfit.boundLabelText"));		
        this.contrecGrossProfit.setBoundLabelLength(100);		
        this.contrecGrossProfit.setBoundLabelUnderline(true);		
        this.contrecGrossProfit.setVisible(true);
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
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setVisible(true);		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);		
        this.prmtcompany.setEnabled(false);
        // txtyear		
        this.txtyear.setVisible(true);		
        this.txtyear.setHorizontalAlignment(2);		
        this.txtyear.setDataType(0);		
        this.txtyear.setSupportedEmpty(true);		
        this.txtyear.setRequired(true);		
        this.txtyear.setEnabled(false);
        // txtmonth		
        this.txtmonth.setVisible(true);		
        this.txtmonth.setHorizontalAlignment(2);		
        this.txtmonth.setDataType(0);		
        this.txtmonth.setSupportedEmpty(true);		
        this.txtmonth.setRequired(true);
        // pkauditTime		
        this.pkauditTime.setVisible(true);		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // txtallGrossProfit		
        this.txtallGrossProfit.setVisible(true);		
        this.txtallGrossProfit.setHorizontalAlignment(2);		
        this.txtallGrossProfit.setDataType(1);		
        this.txtallGrossProfit.setSupportedEmpty(true);		
        this.txtallGrossProfit.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtallGrossProfit.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtallGrossProfit.setPrecision(2);		
        this.txtallGrossProfit.setRequired(false);
        // baseStatus		
        this.baseStatus.setVisible(true);		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(true);		
        this.baseStatus.setEnabled(false);
        // indexType		
        this.indexType.setVisible(true);		
        this.indexType.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.salepayment.IndexType").toArray());		
        this.indexType.setRequired(false);
        // prmtsaleStimulateInfo		
        this.prmtsaleStimulateInfo.setQueryInfo("com.kingdee.eas.custom.salepayment.app.SalerStimulateSetQuery");		
        this.prmtsaleStimulateInfo.setVisible(true);		
        this.prmtsaleStimulateInfo.setEditable(true);		
        this.prmtsaleStimulateInfo.setDisplayFormat("$number$");		
        this.prmtsaleStimulateInfo.setEditFormat("$number$");		
        this.prmtsaleStimulateInfo.setCommitFormat("$number$");		
        this.prmtsaleStimulateInfo.setRequired(false);
        		prmtsaleStimulateInfo.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.custom.salepayment.client.SalerStimulateSetListUI prmtsaleStimulateInfo_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtsaleStimulateInfo_F7ListUI == null) {
					try {
						prmtsaleStimulateInfo_F7ListUI = new com.kingdee.eas.custom.salepayment.client.SalerStimulateSetListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtsaleStimulateInfo_F7ListUI));
					prmtsaleStimulateInfo_F7ListUI.setF7Use(true,ctx);
					prmtsaleStimulateInfo.setSelector(prmtsaleStimulateInfo_F7ListUI);
				}
			}
		});
					
        // quarter		
        this.quarter.setVisible(true);		
        this.quarter.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.salepayment.Quarter").toArray());		
        this.quarter.setRequired(false);
        // txtmonthRecAmount		
        this.txtmonthRecAmount.setVisible(true);		
        this.txtmonthRecAmount.setHorizontalAlignment(2);		
        this.txtmonthRecAmount.setDataType(1);		
        this.txtmonthRecAmount.setSupportedEmpty(true);		
        this.txtmonthRecAmount.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtmonthRecAmount.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtmonthRecAmount.setPrecision(2);		
        this.txtmonthRecAmount.setRequired(false);
        // txtallNoTaxAmount		
        this.txtallNoTaxAmount.setVisible(true);		
        this.txtallNoTaxAmount.setHorizontalAlignment(2);		
        this.txtallNoTaxAmount.setDataType(1);		
        this.txtallNoTaxAmount.setSupportedEmpty(true);		
        this.txtallNoTaxAmount.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtallNoTaxAmount.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtallNoTaxAmount.setPrecision(2);		
        this.txtallNoTaxAmount.setRequired(false);
        // txtallStandardCost		
        this.txtallStandardCost.setVisible(true);		
        this.txtallStandardCost.setHorizontalAlignment(2);		
        this.txtallStandardCost.setDataType(1);		
        this.txtallStandardCost.setSupportedEmpty(true);		
        this.txtallStandardCost.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtallStandardCost.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtallStandardCost.setPrecision(2);		
        this.txtallStandardCost.setRequired(false);
        // prmtsaler		
        this.prmtsaler.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtsaler.setVisible(true);		
        this.prmtsaler.setEditable(true);		
        this.prmtsaler.setDisplayFormat("$name$");		
        this.prmtsaler.setEditFormat("$number$");		
        this.prmtsaler.setCommitFormat("$number$");		
        this.prmtsaler.setRequired(false);
        // kDPanel1
        // kDPanel2
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"customer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"baseUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"baseQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"noTaxAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"taxAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"noTaxPrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"taxPrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"unitCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"allCoat\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"grossProfit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{customer}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{baseUnit}</t:Cell><t:Cell>$Resource{baseQty}</t:Cell><t:Cell>$Resource{noTaxAmount}</t:Cell><t:Cell>$Resource{taxAmount}</t:Cell><t:Cell>$Resource{noTaxPrice}</t:Cell><t:Cell>$Resource{taxPrice}</t:Cell><t:Cell>$Resource{unitCost}</t:Cell><t:Cell>$Resource{allCoat}</t:Cell><t:Cell>$Resource{grossProfit}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));

                this.kdtEntrys.putBindContents("editData",new String[] {"id","customer","material","baseUnit","baseQty","noTaxAmount","taxAmount","noTaxPrice","taxPrice","unitCost","allCoat","grossProfit"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_customer_PromptBox = new KDBizPromptBox();
        kdtEntrys_customer_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.CustomerInfoQuery");
        kdtEntrys_customer_PromptBox.setVisible(true);
        kdtEntrys_customer_PromptBox.setEditable(true);
        kdtEntrys_customer_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_customer_PromptBox.setEditFormat("$number$");
        kdtEntrys_customer_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_customer_CellEditor = new KDTDefaultCellEditor(kdtEntrys_customer_PromptBox);
        this.kdtEntrys.getColumn("customer").setEditor(kdtEntrys_customer_CellEditor);
        ObjectValueRender kdtEntrys_customer_OVR = new ObjectValueRender();
        kdtEntrys_customer_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("customer").setRenderer(kdtEntrys_customer_OVR);
        final KDBizPromptBox kdtEntrys_material_PromptBox = new KDBizPromptBox();
        kdtEntrys_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtEntrys_material_PromptBox.setVisible(true);
        kdtEntrys_material_PromptBox.setEditable(true);
        kdtEntrys_material_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_material_PromptBox.setEditFormat("$number$");
        kdtEntrys_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_material_CellEditor = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox);
        this.kdtEntrys.getColumn("material").setEditor(kdtEntrys_material_CellEditor);
        ObjectValueRender kdtEntrys_material_OVR = new ObjectValueRender();
        kdtEntrys_material_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("material").setRenderer(kdtEntrys_material_OVR);
        final KDBizPromptBox kdtEntrys_baseUnit_PromptBox = new KDBizPromptBox();
        kdtEntrys_baseUnit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtEntrys_baseUnit_PromptBox.setVisible(true);
        kdtEntrys_baseUnit_PromptBox.setEditable(true);
        kdtEntrys_baseUnit_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_baseUnit_PromptBox.setEditFormat("$number$");
        kdtEntrys_baseUnit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_baseUnit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_baseUnit_PromptBox);
        this.kdtEntrys.getColumn("baseUnit").setEditor(kdtEntrys_baseUnit_CellEditor);
        ObjectValueRender kdtEntrys_baseUnit_OVR = new ObjectValueRender();
        kdtEntrys_baseUnit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("baseUnit").setRenderer(kdtEntrys_baseUnit_OVR);
        KDFormattedTextField kdtEntrys_baseQty_TextField = new KDFormattedTextField();
        kdtEntrys_baseQty_TextField.setName("kdtEntrys_baseQty_TextField");
        kdtEntrys_baseQty_TextField.setVisible(true);
        kdtEntrys_baseQty_TextField.setEditable(true);
        kdtEntrys_baseQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_baseQty_TextField.setDataType(1);
        	kdtEntrys_baseQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_baseQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_baseQty_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_baseQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_baseQty_TextField);
        this.kdtEntrys.getColumn("baseQty").setEditor(kdtEntrys_baseQty_CellEditor);
        KDFormattedTextField kdtEntrys_noTaxAmount_TextField = new KDFormattedTextField();
        kdtEntrys_noTaxAmount_TextField.setName("kdtEntrys_noTaxAmount_TextField");
        kdtEntrys_noTaxAmount_TextField.setVisible(true);
        kdtEntrys_noTaxAmount_TextField.setEditable(true);
        kdtEntrys_noTaxAmount_TextField.setHorizontalAlignment(2);
        kdtEntrys_noTaxAmount_TextField.setDataType(1);
        	kdtEntrys_noTaxAmount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_noTaxAmount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_noTaxAmount_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_noTaxAmount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_noTaxAmount_TextField);
        this.kdtEntrys.getColumn("noTaxAmount").setEditor(kdtEntrys_noTaxAmount_CellEditor);
        KDFormattedTextField kdtEntrys_taxAmount_TextField = new KDFormattedTextField();
        kdtEntrys_taxAmount_TextField.setName("kdtEntrys_taxAmount_TextField");
        kdtEntrys_taxAmount_TextField.setVisible(true);
        kdtEntrys_taxAmount_TextField.setEditable(true);
        kdtEntrys_taxAmount_TextField.setHorizontalAlignment(2);
        kdtEntrys_taxAmount_TextField.setDataType(1);
        	kdtEntrys_taxAmount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_taxAmount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_taxAmount_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_taxAmount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_taxAmount_TextField);
        this.kdtEntrys.getColumn("taxAmount").setEditor(kdtEntrys_taxAmount_CellEditor);
        KDFormattedTextField kdtEntrys_noTaxPrice_TextField = new KDFormattedTextField();
        kdtEntrys_noTaxPrice_TextField.setName("kdtEntrys_noTaxPrice_TextField");
        kdtEntrys_noTaxPrice_TextField.setVisible(true);
        kdtEntrys_noTaxPrice_TextField.setEditable(true);
        kdtEntrys_noTaxPrice_TextField.setHorizontalAlignment(2);
        kdtEntrys_noTaxPrice_TextField.setDataType(1);
        	kdtEntrys_noTaxPrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_noTaxPrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_noTaxPrice_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_noTaxPrice_CellEditor = new KDTDefaultCellEditor(kdtEntrys_noTaxPrice_TextField);
        this.kdtEntrys.getColumn("noTaxPrice").setEditor(kdtEntrys_noTaxPrice_CellEditor);
        KDFormattedTextField kdtEntrys_taxPrice_TextField = new KDFormattedTextField();
        kdtEntrys_taxPrice_TextField.setName("kdtEntrys_taxPrice_TextField");
        kdtEntrys_taxPrice_TextField.setVisible(true);
        kdtEntrys_taxPrice_TextField.setEditable(true);
        kdtEntrys_taxPrice_TextField.setHorizontalAlignment(2);
        kdtEntrys_taxPrice_TextField.setDataType(1);
        	kdtEntrys_taxPrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_taxPrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_taxPrice_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_taxPrice_CellEditor = new KDTDefaultCellEditor(kdtEntrys_taxPrice_TextField);
        this.kdtEntrys.getColumn("taxPrice").setEditor(kdtEntrys_taxPrice_CellEditor);
        KDFormattedTextField kdtEntrys_unitCost_TextField = new KDFormattedTextField();
        kdtEntrys_unitCost_TextField.setName("kdtEntrys_unitCost_TextField");
        kdtEntrys_unitCost_TextField.setVisible(true);
        kdtEntrys_unitCost_TextField.setEditable(true);
        kdtEntrys_unitCost_TextField.setHorizontalAlignment(2);
        kdtEntrys_unitCost_TextField.setDataType(1);
        	kdtEntrys_unitCost_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_unitCost_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_unitCost_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_unitCost_CellEditor = new KDTDefaultCellEditor(kdtEntrys_unitCost_TextField);
        this.kdtEntrys.getColumn("unitCost").setEditor(kdtEntrys_unitCost_CellEditor);
        KDFormattedTextField kdtEntrys_allCoat_TextField = new KDFormattedTextField();
        kdtEntrys_allCoat_TextField.setName("kdtEntrys_allCoat_TextField");
        kdtEntrys_allCoat_TextField.setVisible(true);
        kdtEntrys_allCoat_TextField.setEditable(true);
        kdtEntrys_allCoat_TextField.setHorizontalAlignment(2);
        kdtEntrys_allCoat_TextField.setDataType(1);
        	kdtEntrys_allCoat_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_allCoat_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_allCoat_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_allCoat_CellEditor = new KDTDefaultCellEditor(kdtEntrys_allCoat_TextField);
        this.kdtEntrys.getColumn("allCoat").setEditor(kdtEntrys_allCoat_CellEditor);
        KDFormattedTextField kdtEntrys_grossProfit_TextField = new KDFormattedTextField();
        kdtEntrys_grossProfit_TextField.setName("kdtEntrys_grossProfit_TextField");
        kdtEntrys_grossProfit_TextField.setVisible(true);
        kdtEntrys_grossProfit_TextField.setEditable(true);
        kdtEntrys_grossProfit_TextField.setHorizontalAlignment(2);
        kdtEntrys_grossProfit_TextField.setDataType(1);
        	kdtEntrys_grossProfit_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_grossProfit_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_grossProfit_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_grossProfit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_grossProfit_TextField);
        this.kdtEntrys.getColumn("grossProfit").setEditor(kdtEntrys_grossProfit_CellEditor);
        // kdtRecEntry
		String kdtRecEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"customer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"recQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"recAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"unitCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"allCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"grossProfit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{customer}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{recQty}</t:Cell><t:Cell>$Resource{recAmount}</t:Cell><t:Cell>$Resource{unitCost}</t:Cell><t:Cell>$Resource{allCost}</t:Cell><t:Cell>$Resource{grossProfit}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtRecEntry.setFormatXml(resHelper.translateString("kdtRecEntry",kdtRecEntryStrXML));

                this.kdtRecEntry.putBindContents("editData",new String[] {"seq","customer","material","unit","recQty","recAmount","unitCost","allCost","grossProfit"});


        this.kdtRecEntry.checkParsed();
        KDFormattedTextField kdtRecEntry_seq_TextField = new KDFormattedTextField();
        kdtRecEntry_seq_TextField.setName("kdtRecEntry_seq_TextField");
        kdtRecEntry_seq_TextField.setVisible(true);
        kdtRecEntry_seq_TextField.setEditable(true);
        kdtRecEntry_seq_TextField.setHorizontalAlignment(2);
        kdtRecEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtRecEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtRecEntry_seq_TextField);
        this.kdtRecEntry.getColumn("seq").setEditor(kdtRecEntry_seq_CellEditor);
        final KDBizPromptBox kdtRecEntry_customer_PromptBox = new KDBizPromptBox();
        kdtRecEntry_customer_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.CustomerInfoQuery");
        kdtRecEntry_customer_PromptBox.setVisible(true);
        kdtRecEntry_customer_PromptBox.setEditable(true);
        kdtRecEntry_customer_PromptBox.setDisplayFormat("$number$");
        kdtRecEntry_customer_PromptBox.setEditFormat("$number$");
        kdtRecEntry_customer_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtRecEntry_customer_CellEditor = new KDTDefaultCellEditor(kdtRecEntry_customer_PromptBox);
        this.kdtRecEntry.getColumn("customer").setEditor(kdtRecEntry_customer_CellEditor);
        ObjectValueRender kdtRecEntry_customer_OVR = new ObjectValueRender();
        kdtRecEntry_customer_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtRecEntry.getColumn("customer").setRenderer(kdtRecEntry_customer_OVR);
        final KDBizPromptBox kdtRecEntry_material_PromptBox = new KDBizPromptBox();
        kdtRecEntry_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtRecEntry_material_PromptBox.setVisible(true);
        kdtRecEntry_material_PromptBox.setEditable(true);
        kdtRecEntry_material_PromptBox.setDisplayFormat("$number$");
        kdtRecEntry_material_PromptBox.setEditFormat("$number$");
        kdtRecEntry_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtRecEntry_material_CellEditor = new KDTDefaultCellEditor(kdtRecEntry_material_PromptBox);
        this.kdtRecEntry.getColumn("material").setEditor(kdtRecEntry_material_CellEditor);
        ObjectValueRender kdtRecEntry_material_OVR = new ObjectValueRender();
        kdtRecEntry_material_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtRecEntry.getColumn("material").setRenderer(kdtRecEntry_material_OVR);
        final KDBizPromptBox kdtRecEntry_unit_PromptBox = new KDBizPromptBox();
        kdtRecEntry_unit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtRecEntry_unit_PromptBox.setVisible(true);
        kdtRecEntry_unit_PromptBox.setEditable(true);
        kdtRecEntry_unit_PromptBox.setDisplayFormat("$number$");
        kdtRecEntry_unit_PromptBox.setEditFormat("$number$");
        kdtRecEntry_unit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtRecEntry_unit_CellEditor = new KDTDefaultCellEditor(kdtRecEntry_unit_PromptBox);
        this.kdtRecEntry.getColumn("unit").setEditor(kdtRecEntry_unit_CellEditor);
        ObjectValueRender kdtRecEntry_unit_OVR = new ObjectValueRender();
        kdtRecEntry_unit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtRecEntry.getColumn("unit").setRenderer(kdtRecEntry_unit_OVR);
        KDFormattedTextField kdtRecEntry_recQty_TextField = new KDFormattedTextField();
        kdtRecEntry_recQty_TextField.setName("kdtRecEntry_recQty_TextField");
        kdtRecEntry_recQty_TextField.setVisible(true);
        kdtRecEntry_recQty_TextField.setEditable(true);
        kdtRecEntry_recQty_TextField.setHorizontalAlignment(2);
        kdtRecEntry_recQty_TextField.setDataType(1);
        	kdtRecEntry_recQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtRecEntry_recQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtRecEntry_recQty_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtRecEntry_recQty_CellEditor = new KDTDefaultCellEditor(kdtRecEntry_recQty_TextField);
        this.kdtRecEntry.getColumn("recQty").setEditor(kdtRecEntry_recQty_CellEditor);
        KDFormattedTextField kdtRecEntry_recAmount_TextField = new KDFormattedTextField();
        kdtRecEntry_recAmount_TextField.setName("kdtRecEntry_recAmount_TextField");
        kdtRecEntry_recAmount_TextField.setVisible(true);
        kdtRecEntry_recAmount_TextField.setEditable(true);
        kdtRecEntry_recAmount_TextField.setHorizontalAlignment(2);
        kdtRecEntry_recAmount_TextField.setDataType(1);
        	kdtRecEntry_recAmount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtRecEntry_recAmount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtRecEntry_recAmount_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtRecEntry_recAmount_CellEditor = new KDTDefaultCellEditor(kdtRecEntry_recAmount_TextField);
        this.kdtRecEntry.getColumn("recAmount").setEditor(kdtRecEntry_recAmount_CellEditor);
        KDFormattedTextField kdtRecEntry_unitCost_TextField = new KDFormattedTextField();
        kdtRecEntry_unitCost_TextField.setName("kdtRecEntry_unitCost_TextField");
        kdtRecEntry_unitCost_TextField.setVisible(true);
        kdtRecEntry_unitCost_TextField.setEditable(true);
        kdtRecEntry_unitCost_TextField.setHorizontalAlignment(2);
        kdtRecEntry_unitCost_TextField.setDataType(1);
        	kdtRecEntry_unitCost_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtRecEntry_unitCost_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtRecEntry_unitCost_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtRecEntry_unitCost_CellEditor = new KDTDefaultCellEditor(kdtRecEntry_unitCost_TextField);
        this.kdtRecEntry.getColumn("unitCost").setEditor(kdtRecEntry_unitCost_CellEditor);
        KDFormattedTextField kdtRecEntry_allCost_TextField = new KDFormattedTextField();
        kdtRecEntry_allCost_TextField.setName("kdtRecEntry_allCost_TextField");
        kdtRecEntry_allCost_TextField.setVisible(true);
        kdtRecEntry_allCost_TextField.setEditable(true);
        kdtRecEntry_allCost_TextField.setHorizontalAlignment(2);
        kdtRecEntry_allCost_TextField.setDataType(1);
        	kdtRecEntry_allCost_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtRecEntry_allCost_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtRecEntry_allCost_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtRecEntry_allCost_CellEditor = new KDTDefaultCellEditor(kdtRecEntry_allCost_TextField);
        this.kdtRecEntry.getColumn("allCost").setEditor(kdtRecEntry_allCost_CellEditor);
        KDFormattedTextField kdtRecEntry_grossProfit_TextField = new KDFormattedTextField();
        kdtRecEntry_grossProfit_TextField.setName("kdtRecEntry_grossProfit_TextField");
        kdtRecEntry_grossProfit_TextField.setVisible(true);
        kdtRecEntry_grossProfit_TextField.setEditable(true);
        kdtRecEntry_grossProfit_TextField.setHorizontalAlignment(2);
        kdtRecEntry_grossProfit_TextField.setDataType(1);
        	kdtRecEntry_grossProfit_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtRecEntry_grossProfit_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtRecEntry_grossProfit_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtRecEntry_grossProfit_CellEditor = new KDTDefaultCellEditor(kdtRecEntry_grossProfit_TextField);
        this.kdtRecEntry.getColumn("grossProfit").setEditor(kdtRecEntry_grossProfit_CellEditor);
        // txtrecStandardCost		
        this.txtrecStandardCost.setVisible(true);		
        this.txtrecStandardCost.setHorizontalAlignment(2);		
        this.txtrecStandardCost.setDataType(1);		
        this.txtrecStandardCost.setSupportedEmpty(true);		
        this.txtrecStandardCost.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtrecStandardCost.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtrecStandardCost.setPrecision(2);		
        this.txtrecStandardCost.setRequired(false);
        // txtrecGrossProfit		
        this.txtrecGrossProfit.setVisible(true);		
        this.txtrecGrossProfit.setHorizontalAlignment(2);		
        this.txtrecGrossProfit.setDataType(1);		
        this.txtrecGrossProfit.setSupportedEmpty(true);		
        this.txtrecGrossProfit.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtrecGrossProfit.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtrecGrossProfit.setPrecision(2);		
        this.txtrecGrossProfit.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtcompany,txtyear,txtmonth,pkauditTime,txtallGrossProfit,baseStatus,indexType,prmtsaleStimulateInfo,quarter,txtmonthRecAmount,txtallNoTaxAmount,txtallStandardCost,prmtsaler,txtrecStandardCost,txtrecGrossProfit}));
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
        contCreator.setBounds(new Rectangle(367, 573, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(367, 573, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(367, 599, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(367, 599, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(724, 573, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(724, 573, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateTime.setBounds(new Rectangle(724, 599, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(724, 599, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(23, 14, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(23, 14, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(23, 146, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(23, 146, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(376, 146, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(376, 146, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(10, 573, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(10, 573, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompany.setBounds(new Rectangle(376, 14, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(376, 14, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contyear.setBounds(new Rectangle(376, 40, 270, 19));
        this.add(contyear, new KDLayout.Constraints(376, 40, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmonth.setBounds(new Rectangle(729, 40, 270, 19));
        this.add(contmonth, new KDLayout.Constraints(729, 40, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contauditTime.setBounds(new Rectangle(10, 599, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(10, 599, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contallGrossProfit.setBounds(new Rectangle(729, 92, 270, 19));
        this.add(contallGrossProfit, new KDLayout.Constraints(729, 92, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbaseStatus.setBounds(new Rectangle(729, 66, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(729, 66, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contindexType.setBounds(new Rectangle(23, 40, 270, 19));
        this.add(contindexType, new KDLayout.Constraints(23, 40, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsaleStimulateInfo.setBounds(new Rectangle(23, 66, 270, 19));
        this.add(contsaleStimulateInfo, new KDLayout.Constraints(23, 66, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contquarter.setBounds(new Rectangle(729, 14, 270, 19));
        this.add(contquarter, new KDLayout.Constraints(729, 14, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contmonthRecAmount.setBounds(new Rectangle(23, 118, 270, 19));
        this.add(contmonthRecAmount, new KDLayout.Constraints(23, 118, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contallNoTaxAmount.setBounds(new Rectangle(23, 92, 270, 19));
        this.add(contallNoTaxAmount, new KDLayout.Constraints(23, 92, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contallStandardCost.setBounds(new Rectangle(376, 92, 270, 19));
        this.add(contallStandardCost, new KDLayout.Constraints(376, 92, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsaler.setBounds(new Rectangle(376, 66, 270, 19));
        this.add(contsaler, new KDLayout.Constraints(376, 66, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane1.setBounds(new Rectangle(24, 185, 976, 382));
        this.add(kDTabbedPane1, new KDLayout.Constraints(24, 185, 976, 382, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contrecStandardCost.setBounds(new Rectangle(376, 118, 270, 19));
        this.add(contrecStandardCost, new KDLayout.Constraints(376, 118, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contrecGrossProfit.setBounds(new Rectangle(729, 118, 270, 19));
        this.add(contrecGrossProfit, new KDLayout.Constraints(729, 118, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contyear
        contyear.setBoundEditor(txtyear);
        //contmonth
        contmonth.setBoundEditor(txtmonth);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contallGrossProfit
        contallGrossProfit.setBoundEditor(txtallGrossProfit);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //contindexType
        contindexType.setBoundEditor(indexType);
        //contsaleStimulateInfo
        contsaleStimulateInfo.setBoundEditor(prmtsaleStimulateInfo);
        //contquarter
        contquarter.setBoundEditor(quarter);
        //contmonthRecAmount
        contmonthRecAmount.setBoundEditor(txtmonthRecAmount);
        //contallNoTaxAmount
        contallNoTaxAmount.setBoundEditor(txtallNoTaxAmount);
        //contallStandardCost
        contallStandardCost.setBoundEditor(txtallStandardCost);
        //contsaler
        contsaler.setBoundEditor(prmtsaler);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 975, 349));        kdtEntrys.setBounds(new Rectangle(0, 1, 970, 347));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.custom.salepayment.GrossProfitInfoEntryInfo(),null,false);
        kDPanel1.add(kdtEntrys_detailPanel, new KDLayout.Constraints(0, 1, 970, 347, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 975, 349));        kdtRecEntry.setBounds(new Rectangle(0, 0, 972, 347));
        kdtRecEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtRecEntry,new com.kingdee.eas.custom.salepayment.GrossProfitInfoRecEntryInfo(),null,false);
        kDPanel2.add(kdtRecEntry_detailPanel, new KDLayout.Constraints(0, 0, 972, 347, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contrecStandardCost
        contrecStandardCost.setBoundEditor(txtrecStandardCost);
        //contrecGrossProfit
        contrecGrossProfit.setBoundEditor(txtrecGrossProfit);

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
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("year", int.class, this.txtyear, "value");
		dataBinder.registerBinding("month", int.class, this.txtmonth, "value");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("allGrossProfit", java.math.BigDecimal.class, this.txtallGrossProfit, "value");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("indexType", com.kingdee.eas.custom.salepayment.IndexType.class, this.indexType, "selectedItem");
		dataBinder.registerBinding("saleStimulateInfo", com.kingdee.eas.custom.salepayment.SalerStimulateSetInfo.class, this.prmtsaleStimulateInfo, "data");
		dataBinder.registerBinding("quarter", com.kingdee.eas.custom.salepayment.Quarter.class, this.quarter, "selectedItem");
		dataBinder.registerBinding("monthRecAmount", java.math.BigDecimal.class, this.txtmonthRecAmount, "value");
		dataBinder.registerBinding("allNoTaxAmount", java.math.BigDecimal.class, this.txtallNoTaxAmount, "value");
		dataBinder.registerBinding("allStandardCost", java.math.BigDecimal.class, this.txtallStandardCost, "value");
		dataBinder.registerBinding("saler", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtsaler, "data");
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.custom.salepayment.GrossProfitInfoEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.customer", java.lang.Object.class, this.kdtEntrys, "customer.text");
		dataBinder.registerBinding("entrys.material", java.lang.Object.class, this.kdtEntrys, "material.text");
		dataBinder.registerBinding("entrys.baseUnit", java.lang.Object.class, this.kdtEntrys, "baseUnit.text");
		dataBinder.registerBinding("entrys.baseQty", java.math.BigDecimal.class, this.kdtEntrys, "baseQty.text");
		dataBinder.registerBinding("entrys.noTaxAmount", java.math.BigDecimal.class, this.kdtEntrys, "noTaxAmount.text");
		dataBinder.registerBinding("entrys.taxAmount", java.math.BigDecimal.class, this.kdtEntrys, "taxAmount.text");
		dataBinder.registerBinding("entrys.noTaxPrice", java.math.BigDecimal.class, this.kdtEntrys, "noTaxPrice.text");
		dataBinder.registerBinding("entrys.taxPrice", java.math.BigDecimal.class, this.kdtEntrys, "taxPrice.text");
		dataBinder.registerBinding("entrys.unitCost", java.math.BigDecimal.class, this.kdtEntrys, "unitCost.text");
		dataBinder.registerBinding("entrys.allCoat", java.math.BigDecimal.class, this.kdtEntrys, "allCoat.text");
		dataBinder.registerBinding("entrys.grossProfit", java.math.BigDecimal.class, this.kdtEntrys, "grossProfit.text");
		dataBinder.registerBinding("RecEntry.seq", int.class, this.kdtRecEntry, "seq.text");
		dataBinder.registerBinding("RecEntry", com.kingdee.eas.custom.salepayment.GrossProfitInfoRecEntryInfo.class, this.kdtRecEntry, "userObject");
		dataBinder.registerBinding("RecEntry.customer", java.lang.Object.class, this.kdtRecEntry, "customer.text");
		dataBinder.registerBinding("RecEntry.material", java.lang.Object.class, this.kdtRecEntry, "material.text");
		dataBinder.registerBinding("RecEntry.unit", java.lang.Object.class, this.kdtRecEntry, "unit.text");
		dataBinder.registerBinding("RecEntry.recQty", java.math.BigDecimal.class, this.kdtRecEntry, "recQty.text");
		dataBinder.registerBinding("RecEntry.recAmount", java.math.BigDecimal.class, this.kdtRecEntry, "recAmount.text");
		dataBinder.registerBinding("RecEntry.unitCost", java.math.BigDecimal.class, this.kdtRecEntry, "unitCost.text");
		dataBinder.registerBinding("RecEntry.allCost", java.math.BigDecimal.class, this.kdtRecEntry, "allCost.text");
		dataBinder.registerBinding("RecEntry.grossProfit", java.math.BigDecimal.class, this.kdtRecEntry, "grossProfit.text");
		dataBinder.registerBinding("recStandardCost", java.math.BigDecimal.class, this.txtrecStandardCost, "value");
		dataBinder.registerBinding("recGrossProfit", java.math.BigDecimal.class, this.txtrecGrossProfit, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.salepayment.app.GrossProfitInfoEditUIHandler";
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
        this.prmtcompany.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.salepayment.GrossProfitInfoInfo)ov;
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
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("year", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("month", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allGrossProfit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("indexType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("saleStimulateInfo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("quarter", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("monthRecAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allNoTaxAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allStandardCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("saler", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.customer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.baseUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.baseQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.noTaxAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.taxAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.noTaxPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.taxPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.unitCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.allCoat", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.grossProfit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecEntry.customer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecEntry.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecEntry.unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecEntry.recQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecEntry.recAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecEntry.unitCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecEntry.allCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecEntry.grossProfit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("recStandardCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("recGrossProfit", ValidateHelper.ON_SAVE);    		
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
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
        sic.add(new SelectorItemInfo("year"));
        sic.add(new SelectorItemInfo("month"));
        sic.add(new SelectorItemInfo("auditTime"));
        sic.add(new SelectorItemInfo("allGrossProfit"));
        sic.add(new SelectorItemInfo("baseStatus"));
        sic.add(new SelectorItemInfo("indexType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("saleStimulateInfo.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("saleStimulateInfo.id"));
        	sic.add(new SelectorItemInfo("saleStimulateInfo.number"));
        	sic.add(new SelectorItemInfo("saleStimulateInfo.name"));
		}
        sic.add(new SelectorItemInfo("quarter"));
        sic.add(new SelectorItemInfo("monthRecAmount"));
        sic.add(new SelectorItemInfo("allNoTaxAmount"));
        sic.add(new SelectorItemInfo("allStandardCost"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("saler.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("saler.id"));
        	sic.add(new SelectorItemInfo("saler.number"));
        	sic.add(new SelectorItemInfo("saler.name"));
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
			sic.add(new SelectorItemInfo("entrys.customer.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.customer.id"));
			sic.add(new SelectorItemInfo("entrys.customer.name"));
        	sic.add(new SelectorItemInfo("entrys.customer.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.material.id"));
			sic.add(new SelectorItemInfo("entrys.material.name"));
        	sic.add(new SelectorItemInfo("entrys.material.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.baseUnit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.baseUnit.id"));
			sic.add(new SelectorItemInfo("entrys.baseUnit.name"));
        	sic.add(new SelectorItemInfo("entrys.baseUnit.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.baseQty"));
    	sic.add(new SelectorItemInfo("entrys.noTaxAmount"));
    	sic.add(new SelectorItemInfo("entrys.taxAmount"));
    	sic.add(new SelectorItemInfo("entrys.noTaxPrice"));
    	sic.add(new SelectorItemInfo("entrys.taxPrice"));
    	sic.add(new SelectorItemInfo("entrys.unitCost"));
    	sic.add(new SelectorItemInfo("entrys.allCoat"));
    	sic.add(new SelectorItemInfo("entrys.grossProfit"));
    	sic.add(new SelectorItemInfo("RecEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("RecEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("RecEntry.customer.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("RecEntry.customer.id"));
			sic.add(new SelectorItemInfo("RecEntry.customer.name"));
        	sic.add(new SelectorItemInfo("RecEntry.customer.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("RecEntry.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("RecEntry.material.id"));
			sic.add(new SelectorItemInfo("RecEntry.material.name"));
        	sic.add(new SelectorItemInfo("RecEntry.material.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("RecEntry.unit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("RecEntry.unit.id"));
			sic.add(new SelectorItemInfo("RecEntry.unit.name"));
        	sic.add(new SelectorItemInfo("RecEntry.unit.number"));
		}
    	sic.add(new SelectorItemInfo("RecEntry.recQty"));
    	sic.add(new SelectorItemInfo("RecEntry.recAmount"));
    	sic.add(new SelectorItemInfo("RecEntry.unitCost"));
    	sic.add(new SelectorItemInfo("RecEntry.allCost"));
    	sic.add(new SelectorItemInfo("RecEntry.grossProfit"));
        sic.add(new SelectorItemInfo("recStandardCost"));
        sic.add(new SelectorItemInfo("recGrossProfit"));
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

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.salepayment.client", "GrossProfitInfoEditUI");
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
        return com.kingdee.eas.custom.salepayment.client.GrossProfitInfoEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.salepayment.GrossProfitInfoFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.salepayment.GrossProfitInfoInfo objectValue = new com.kingdee.eas.custom.salepayment.GrossProfitInfoInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/salepayment/GrossProfitInfo";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.salepayment.app.GrossProfitInfoQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"公司"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtyear.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"年"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtmonth.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"月"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(baseStatus.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"状态"});
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"customer").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"客户"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"material").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"物料"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"baseUnit").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"计量单位"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"baseQty").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"销量"});
			}
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
vo.put("indexType","2");
vo.put("quarter","1");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}