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
public abstract class AbstractSaleProfitCalculateResultEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSaleProfitCalculateResultEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallGrossProfit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contindexType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsaleStimulateInfo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contquarter;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompanyTarget;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contareaTarget;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrecDataSource;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmanagerFeeShareType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contprofitExeType;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator9;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnoTaxSaleAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallStandardCost;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsaler;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator10;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallRecAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallPersonalFee;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallSharedFee;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallFee;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompanySaleAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contarKhAmount;
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
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallGrossProfit;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.swing.KDComboBox indexType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsaleStimulateInfo;
    protected com.kingdee.bos.ctrl.swing.KDComboBox quarter;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompanyTarget;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtareaTarget;
    protected com.kingdee.bos.ctrl.swing.KDComboBox recDataSource;
    protected com.kingdee.bos.ctrl.swing.KDComboBox managerFeeShareType;
    protected com.kingdee.bos.ctrl.swing.KDComboBox profitExeType;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtnoTaxSaleAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallStandardCost;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtMonthEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtMonthEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtFeeEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtFeeEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsaler;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallRecAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallPersonalFee;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallSharedFee;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallFee;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcompanySaleAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtarKhAmount;
    protected com.kingdee.eas.custom.salepayment.SaleProfitCalculateResultInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractSaleProfitCalculateResultEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractSaleProfitCalculateResultEditUI.class.getName());
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
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallGrossProfit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contindexType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsaleStimulateInfo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contquarter = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompanyTarget = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contareaTarget = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contrecDataSource = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmanagerFeeShareType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contprofitExeType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator9 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contnoTaxSaleAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallStandardCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contsaler = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator10 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contallRecAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallPersonalFee = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallSharedFee = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallFee = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompanySaleAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contarKhAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
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
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtallGrossProfit = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.indexType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtsaleStimulateInfo = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.quarter = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtcompanyTarget = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtareaTarget = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.recDataSource = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.managerFeeShareType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.profitExeType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtnoTaxSaleAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallStandardCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtMonthEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtFeeEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.prmtsaler = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtallRecAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallPersonalFee = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallSharedFee = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallFee = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcompanySaleAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtarKhAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
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
        this.contauditTime.setName("contauditTime");
        this.contallGrossProfit.setName("contallGrossProfit");
        this.contbaseStatus.setName("contbaseStatus");
        this.contindexType.setName("contindexType");
        this.contsaleStimulateInfo.setName("contsaleStimulateInfo");
        this.contquarter.setName("contquarter");
        this.contcompanyTarget.setName("contcompanyTarget");
        this.contareaTarget.setName("contareaTarget");
        this.kDSeparator8.setName("kDSeparator8");
        this.contrecDataSource.setName("contrecDataSource");
        this.contmanagerFeeShareType.setName("contmanagerFeeShareType");
        this.contprofitExeType.setName("contprofitExeType");
        this.kDSeparator9.setName("kDSeparator9");
        this.contnoTaxSaleAmount.setName("contnoTaxSaleAmount");
        this.contallStandardCost.setName("contallStandardCost");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contsaler.setName("contsaler");
        this.kDSeparator10.setName("kDSeparator10");
        this.contallRecAmount.setName("contallRecAmount");
        this.contallPersonalFee.setName("contallPersonalFee");
        this.contallSharedFee.setName("contallSharedFee");
        this.contallFee.setName("contallFee");
        this.contcompanySaleAmount.setName("contcompanySaleAmount");
        this.contarKhAmount.setName("contarKhAmount");
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
        this.pkauditTime.setName("pkauditTime");
        this.txtallGrossProfit.setName("txtallGrossProfit");
        this.baseStatus.setName("baseStatus");
        this.indexType.setName("indexType");
        this.prmtsaleStimulateInfo.setName("prmtsaleStimulateInfo");
        this.quarter.setName("quarter");
        this.prmtcompanyTarget.setName("prmtcompanyTarget");
        this.prmtareaTarget.setName("prmtareaTarget");
        this.recDataSource.setName("recDataSource");
        this.managerFeeShareType.setName("managerFeeShareType");
        this.profitExeType.setName("profitExeType");
        this.txtnoTaxSaleAmount.setName("txtnoTaxSaleAmount");
        this.txtallStandardCost.setName("txtallStandardCost");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kdtMonthEntry.setName("kdtMonthEntry");
        this.kdtFeeEntry.setName("kdtFeeEntry");
        this.prmtsaler.setName("prmtsaler");
        this.txtallRecAmount.setName("txtallRecAmount");
        this.txtallPersonalFee.setName("txtallPersonalFee");
        this.txtallSharedFee.setName("txtallSharedFee");
        this.txtallFee.setName("txtallFee");
        this.txtcompanySaleAmount.setName("txtcompanySaleAmount");
        this.txtarKhAmount.setName("txtarKhAmount");
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
        // contcompanyTarget		
        this.contcompanyTarget.setBoundLabelText(resHelper.getString("contcompanyTarget.boundLabelText"));		
        this.contcompanyTarget.setBoundLabelLength(100);		
        this.contcompanyTarget.setBoundLabelUnderline(true);		
        this.contcompanyTarget.setVisible(true);
        // contareaTarget		
        this.contareaTarget.setBoundLabelText(resHelper.getString("contareaTarget.boundLabelText"));		
        this.contareaTarget.setBoundLabelLength(100);		
        this.contareaTarget.setBoundLabelUnderline(true);		
        this.contareaTarget.setVisible(true);
        // kDSeparator8
        // contrecDataSource		
        this.contrecDataSource.setBoundLabelText(resHelper.getString("contrecDataSource.boundLabelText"));		
        this.contrecDataSource.setBoundLabelLength(100);		
        this.contrecDataSource.setBoundLabelUnderline(true);		
        this.contrecDataSource.setVisible(true);
        // contmanagerFeeShareType		
        this.contmanagerFeeShareType.setBoundLabelText(resHelper.getString("contmanagerFeeShareType.boundLabelText"));		
        this.contmanagerFeeShareType.setBoundLabelLength(100);		
        this.contmanagerFeeShareType.setBoundLabelUnderline(true);		
        this.contmanagerFeeShareType.setVisible(true);
        // contprofitExeType		
        this.contprofitExeType.setBoundLabelText(resHelper.getString("contprofitExeType.boundLabelText"));		
        this.contprofitExeType.setBoundLabelLength(100);		
        this.contprofitExeType.setBoundLabelUnderline(true);		
        this.contprofitExeType.setVisible(true);
        // kDSeparator9
        // contnoTaxSaleAmount		
        this.contnoTaxSaleAmount.setBoundLabelText(resHelper.getString("contnoTaxSaleAmount.boundLabelText"));		
        this.contnoTaxSaleAmount.setBoundLabelLength(100);		
        this.contnoTaxSaleAmount.setBoundLabelUnderline(true);		
        this.contnoTaxSaleAmount.setVisible(true);
        // contallStandardCost		
        this.contallStandardCost.setBoundLabelText(resHelper.getString("contallStandardCost.boundLabelText"));		
        this.contallStandardCost.setBoundLabelLength(100);		
        this.contallStandardCost.setBoundLabelUnderline(true);		
        this.contallStandardCost.setVisible(true);
        // kDTabbedPane1
        // contsaler		
        this.contsaler.setBoundLabelText(resHelper.getString("contsaler.boundLabelText"));		
        this.contsaler.setBoundLabelLength(100);		
        this.contsaler.setBoundLabelUnderline(true);		
        this.contsaler.setVisible(true);
        // kDSeparator10
        // contallRecAmount		
        this.contallRecAmount.setBoundLabelText(resHelper.getString("contallRecAmount.boundLabelText"));		
        this.contallRecAmount.setBoundLabelLength(100);		
        this.contallRecAmount.setBoundLabelUnderline(true);		
        this.contallRecAmount.setVisible(true);
        // contallPersonalFee		
        this.contallPersonalFee.setBoundLabelText(resHelper.getString("contallPersonalFee.boundLabelText"));		
        this.contallPersonalFee.setBoundLabelLength(100);		
        this.contallPersonalFee.setBoundLabelUnderline(true);		
        this.contallPersonalFee.setVisible(true);
        // contallSharedFee		
        this.contallSharedFee.setBoundLabelText(resHelper.getString("contallSharedFee.boundLabelText"));		
        this.contallSharedFee.setBoundLabelLength(100);		
        this.contallSharedFee.setBoundLabelUnderline(true);		
        this.contallSharedFee.setVisible(true);
        // contallFee		
        this.contallFee.setBoundLabelText(resHelper.getString("contallFee.boundLabelText"));		
        this.contallFee.setBoundLabelLength(100);		
        this.contallFee.setBoundLabelUnderline(true);		
        this.contallFee.setVisible(true);
        // contcompanySaleAmount		
        this.contcompanySaleAmount.setBoundLabelText(resHelper.getString("contcompanySaleAmount.boundLabelText"));		
        this.contcompanySaleAmount.setBoundLabelLength(100);		
        this.contcompanySaleAmount.setBoundLabelUnderline(true);		
        this.contcompanySaleAmount.setVisible(true);
        // contarKhAmount		
        this.contarKhAmount.setBoundLabelText(resHelper.getString("contarKhAmount.boundLabelText"));		
        this.contarKhAmount.setBoundLabelLength(100);		
        this.contarKhAmount.setBoundLabelUnderline(true);		
        this.contarKhAmount.setVisible(true);
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
        this.txtNumber.setEnabled(false);
        // pkBizDate		
        this.pkBizDate.setEnabled(true);
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);		
        this.prmtcompany.setEnabled(false);
        // txtyear		
        this.txtyear.setHorizontalAlignment(2);		
        this.txtyear.setDataType(0);		
        this.txtyear.setSupportedEmpty(true);		
        this.txtyear.setRequired(true);		
        this.txtyear.setEnabled(false);
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // txtallGrossProfit		
        this.txtallGrossProfit.setHorizontalAlignment(2);		
        this.txtallGrossProfit.setDataType(1);		
        this.txtallGrossProfit.setSupportedEmpty(true);		
        this.txtallGrossProfit.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtallGrossProfit.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtallGrossProfit.setPrecision(2);		
        this.txtallGrossProfit.setRequired(false);		
        this.txtallGrossProfit.setEnabled(false);
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(true);		
        this.baseStatus.setEnabled(false);
        // indexType		
        this.indexType.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.salepayment.IndexType").toArray());		
        this.indexType.setRequired(false);		
        this.indexType.setEnabled(false);
        // prmtsaleStimulateInfo		
        this.prmtsaleStimulateInfo.setQueryInfo("com.kingdee.eas.custom.salepayment.app.SalerStimulateSetQuery");		
        this.prmtsaleStimulateInfo.setEditable(true);		
        this.prmtsaleStimulateInfo.setDisplayFormat("$number$");		
        this.prmtsaleStimulateInfo.setEditFormat("$number$");		
        this.prmtsaleStimulateInfo.setCommitFormat("$number$");		
        this.prmtsaleStimulateInfo.setRequired(false);		
        this.prmtsaleStimulateInfo.setEnabled(false);
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
        this.quarter.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.salepayment.Quarter").toArray());		
        this.quarter.setRequired(false);		
        this.quarter.setEnabled(false);
        // prmtcompanyTarget		
        this.prmtcompanyTarget.setQueryInfo("com.kingdee.eas.custom.salepayment.app.CompanyTargetQuery");		
        this.prmtcompanyTarget.setEditable(true);		
        this.prmtcompanyTarget.setDisplayFormat("$number$");		
        this.prmtcompanyTarget.setEditFormat("$number$");		
        this.prmtcompanyTarget.setCommitFormat("$number$");		
        this.prmtcompanyTarget.setRequired(false);		
        this.prmtcompanyTarget.setEnabled(false);
        		prmtcompanyTarget.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.custom.salepayment.client.CompanyTargetListUI prmtcompanyTarget_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtcompanyTarget_F7ListUI == null) {
					try {
						prmtcompanyTarget_F7ListUI = new com.kingdee.eas.custom.salepayment.client.CompanyTargetListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtcompanyTarget_F7ListUI));
					prmtcompanyTarget_F7ListUI.setF7Use(true,ctx);
					prmtcompanyTarget.setSelector(prmtcompanyTarget_F7ListUI);
				}
			}
		});
					
        // prmtareaTarget		
        this.prmtareaTarget.setQueryInfo("com.kingdee.eas.custom.salepayment.app.AreaTargetQuery");		
        this.prmtareaTarget.setEditable(true);		
        this.prmtareaTarget.setDisplayFormat("$number$");		
        this.prmtareaTarget.setEditFormat("$number$");		
        this.prmtareaTarget.setCommitFormat("$number$");		
        this.prmtareaTarget.setRequired(false);		
        this.prmtareaTarget.setEnabled(false);
        		prmtareaTarget.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.custom.salepayment.client.AreaTargetListUI prmtareaTarget_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtareaTarget_F7ListUI == null) {
					try {
						prmtareaTarget_F7ListUI = new com.kingdee.eas.custom.salepayment.client.AreaTargetListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtareaTarget_F7ListUI));
					prmtareaTarget_F7ListUI.setF7Use(true,ctx);
					prmtareaTarget.setSelector(prmtareaTarget_F7ListUI);
				}
			}
		});
					
        // recDataSource		
        this.recDataSource.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.salepayment.RecDataSource").toArray());		
        this.recDataSource.setRequired(false);		
        this.recDataSource.setEnabled(false);
        // managerFeeShareType		
        this.managerFeeShareType.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.salepayment.ManageFeeShareType").toArray());		
        this.managerFeeShareType.setRequired(false);		
        this.managerFeeShareType.setEnabled(false);
        // profitExeType		
        this.profitExeType.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.salepayment.ProfitExeType").toArray());		
        this.profitExeType.setRequired(false);		
        this.profitExeType.setEnabled(false);
        // txtnoTaxSaleAmount		
        this.txtnoTaxSaleAmount.setHorizontalAlignment(2);		
        this.txtnoTaxSaleAmount.setDataType(1);		
        this.txtnoTaxSaleAmount.setSupportedEmpty(true);		
        this.txtnoTaxSaleAmount.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtnoTaxSaleAmount.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtnoTaxSaleAmount.setPrecision(2);		
        this.txtnoTaxSaleAmount.setRequired(false);		
        this.txtnoTaxSaleAmount.setEnabled(false);
        // txtallStandardCost		
        this.txtallStandardCost.setHorizontalAlignment(2);		
        this.txtallStandardCost.setDataType(1);		
        this.txtallStandardCost.setSupportedEmpty(true);		
        this.txtallStandardCost.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtallStandardCost.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtallStandardCost.setPrecision(2);		
        this.txtallStandardCost.setRequired(false);		
        this.txtallStandardCost.setEnabled(false);
        // kDPanel1
        // kDPanel2
        // kdtMonthEntry
		String kdtMonthEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"monthGrossProfit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"month\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"grossProfit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{monthGrossProfit}</t:Cell><t:Cell>$Resource{month}</t:Cell><t:Cell>$Resource{grossProfit}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtMonthEntry.setFormatXml(resHelper.translateString("kdtMonthEntry",kdtMonthEntryStrXML));
        kdtMonthEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtMonthEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtMonthEntry.putBindContents("editData",new String[] {"seq","monthGrossProfit","month","grossProfit"});


        this.kdtMonthEntry.checkParsed();
        KDFormattedTextField kdtMonthEntry_seq_TextField = new KDFormattedTextField();
        kdtMonthEntry_seq_TextField.setName("kdtMonthEntry_seq_TextField");
        kdtMonthEntry_seq_TextField.setVisible(true);
        kdtMonthEntry_seq_TextField.setEditable(true);
        kdtMonthEntry_seq_TextField.setHorizontalAlignment(2);
        kdtMonthEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtMonthEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtMonthEntry_seq_TextField);
        this.kdtMonthEntry.getColumn("seq").setEditor(kdtMonthEntry_seq_CellEditor);
        final KDBizPromptBox kdtMonthEntry_monthGrossProfit_PromptBox = new KDBizPromptBox();
        kdtMonthEntry_monthGrossProfit_PromptBox.setQueryInfo("com.kingdee.eas.custom.salepayment.app.GrossProfitInfoQuery");
        kdtMonthEntry_monthGrossProfit_PromptBox.setVisible(true);
        kdtMonthEntry_monthGrossProfit_PromptBox.setEditable(true);
        kdtMonthEntry_monthGrossProfit_PromptBox.setDisplayFormat("$number$");
        kdtMonthEntry_monthGrossProfit_PromptBox.setEditFormat("$number$");
        kdtMonthEntry_monthGrossProfit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtMonthEntry_monthGrossProfit_CellEditor = new KDTDefaultCellEditor(kdtMonthEntry_monthGrossProfit_PromptBox);
        this.kdtMonthEntry.getColumn("monthGrossProfit").setEditor(kdtMonthEntry_monthGrossProfit_CellEditor);
        ObjectValueRender kdtMonthEntry_monthGrossProfit_OVR = new ObjectValueRender();
        kdtMonthEntry_monthGrossProfit_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtMonthEntry.getColumn("monthGrossProfit").setRenderer(kdtMonthEntry_monthGrossProfit_OVR);
        KDFormattedTextField kdtMonthEntry_month_TextField = new KDFormattedTextField();
        kdtMonthEntry_month_TextField.setName("kdtMonthEntry_month_TextField");
        kdtMonthEntry_month_TextField.setVisible(true);
        kdtMonthEntry_month_TextField.setEditable(true);
        kdtMonthEntry_month_TextField.setHorizontalAlignment(2);
        kdtMonthEntry_month_TextField.setDataType(0);
        KDTDefaultCellEditor kdtMonthEntry_month_CellEditor = new KDTDefaultCellEditor(kdtMonthEntry_month_TextField);
        this.kdtMonthEntry.getColumn("month").setEditor(kdtMonthEntry_month_CellEditor);
        KDFormattedTextField kdtMonthEntry_grossProfit_TextField = new KDFormattedTextField();
        kdtMonthEntry_grossProfit_TextField.setName("kdtMonthEntry_grossProfit_TextField");
        kdtMonthEntry_grossProfit_TextField.setVisible(true);
        kdtMonthEntry_grossProfit_TextField.setEditable(true);
        kdtMonthEntry_grossProfit_TextField.setHorizontalAlignment(2);
        kdtMonthEntry_grossProfit_TextField.setDataType(1);
        	kdtMonthEntry_grossProfit_TextField.setMinimumValue(new java.math.BigDecimal("-3.4028234663852886E38"));
        	kdtMonthEntry_grossProfit_TextField.setMaximumValue(new java.math.BigDecimal("3.4028234663852886E38"));
        kdtMonthEntry_grossProfit_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtMonthEntry_grossProfit_CellEditor = new KDTDefaultCellEditor(kdtMonthEntry_grossProfit_TextField);
        this.kdtMonthEntry.getColumn("grossProfit").setEditor(kdtMonthEntry_grossProfit_CellEditor);
        // kdtFeeEntry
		String kdtFeeEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"feeType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"feeAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"isShared\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{feeType}</t:Cell><t:Cell>$Resource{feeAmount}</t:Cell><t:Cell>$Resource{isShared}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtFeeEntry.setFormatXml(resHelper.translateString("kdtFeeEntry",kdtFeeEntryStrXML));

                this.kdtFeeEntry.putBindContents("editData",new String[] {"seq","feeType","feeAmount","isShared"});


        this.kdtFeeEntry.checkParsed();
        KDFormattedTextField kdtFeeEntry_seq_TextField = new KDFormattedTextField();
        kdtFeeEntry_seq_TextField.setName("kdtFeeEntry_seq_TextField");
        kdtFeeEntry_seq_TextField.setVisible(true);
        kdtFeeEntry_seq_TextField.setEditable(true);
        kdtFeeEntry_seq_TextField.setHorizontalAlignment(2);
        kdtFeeEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtFeeEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtFeeEntry_seq_TextField);
        this.kdtFeeEntry.getColumn("seq").setEditor(kdtFeeEntry_seq_CellEditor);
        final KDBizPromptBox kdtFeeEntry_feeType_PromptBox = new KDBizPromptBox();
        kdtFeeEntry_feeType_PromptBox.setQueryInfo("com.kingdee.eas.custom.salepayment.app.FeeTypeQuery");
        kdtFeeEntry_feeType_PromptBox.setVisible(true);
        kdtFeeEntry_feeType_PromptBox.setEditable(true);
        kdtFeeEntry_feeType_PromptBox.setDisplayFormat("$number$");
        kdtFeeEntry_feeType_PromptBox.setEditFormat("$number$");
        kdtFeeEntry_feeType_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtFeeEntry_feeType_CellEditor = new KDTDefaultCellEditor(kdtFeeEntry_feeType_PromptBox);
        this.kdtFeeEntry.getColumn("feeType").setEditor(kdtFeeEntry_feeType_CellEditor);
        ObjectValueRender kdtFeeEntry_feeType_OVR = new ObjectValueRender();
        kdtFeeEntry_feeType_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtFeeEntry.getColumn("feeType").setRenderer(kdtFeeEntry_feeType_OVR);
        			kdtFeeEntry_feeType_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.custom.salepayment.client.FeeTypeListUI kdtFeeEntry_feeType_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtFeeEntry_feeType_PromptBox_F7ListUI == null) {
					try {
						kdtFeeEntry_feeType_PromptBox_F7ListUI = new com.kingdee.eas.custom.salepayment.client.FeeTypeListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtFeeEntry_feeType_PromptBox_F7ListUI));
					kdtFeeEntry_feeType_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtFeeEntry_feeType_PromptBox.setSelector(kdtFeeEntry_feeType_PromptBox_F7ListUI);
				}
			}
		});
					
        KDFormattedTextField kdtFeeEntry_feeAmount_TextField = new KDFormattedTextField();
        kdtFeeEntry_feeAmount_TextField.setName("kdtFeeEntry_feeAmount_TextField");
        kdtFeeEntry_feeAmount_TextField.setVisible(true);
        kdtFeeEntry_feeAmount_TextField.setEditable(true);
        kdtFeeEntry_feeAmount_TextField.setHorizontalAlignment(2);
        kdtFeeEntry_feeAmount_TextField.setDataType(1);
        	kdtFeeEntry_feeAmount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtFeeEntry_feeAmount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtFeeEntry_feeAmount_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtFeeEntry_feeAmount_CellEditor = new KDTDefaultCellEditor(kdtFeeEntry_feeAmount_TextField);
        this.kdtFeeEntry.getColumn("feeAmount").setEditor(kdtFeeEntry_feeAmount_CellEditor);
        KDCheckBox kdtFeeEntry_isShared_CheckBox = new KDCheckBox();
        kdtFeeEntry_isShared_CheckBox.setName("kdtFeeEntry_isShared_CheckBox");
        KDTDefaultCellEditor kdtFeeEntry_isShared_CellEditor = new KDTDefaultCellEditor(kdtFeeEntry_isShared_CheckBox);
        this.kdtFeeEntry.getColumn("isShared").setEditor(kdtFeeEntry_isShared_CellEditor);
        // prmtsaler		
        this.prmtsaler.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtsaler.setVisible(true);		
        this.prmtsaler.setEditable(true);		
        this.prmtsaler.setDisplayFormat("$name$");		
        this.prmtsaler.setEditFormat("$number$");		
        this.prmtsaler.setCommitFormat("$number$");		
        this.prmtsaler.setRequired(false);
        // txtallRecAmount		
        this.txtallRecAmount.setVisible(true);		
        this.txtallRecAmount.setHorizontalAlignment(2);		
        this.txtallRecAmount.setDataType(1);		
        this.txtallRecAmount.setSupportedEmpty(true);		
        this.txtallRecAmount.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtallRecAmount.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtallRecAmount.setPrecision(2);		
        this.txtallRecAmount.setRequired(false);
        // txtallPersonalFee		
        this.txtallPersonalFee.setVisible(true);		
        this.txtallPersonalFee.setHorizontalAlignment(2);		
        this.txtallPersonalFee.setDataType(1);		
        this.txtallPersonalFee.setSupportedEmpty(true);		
        this.txtallPersonalFee.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtallPersonalFee.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtallPersonalFee.setPrecision(2);		
        this.txtallPersonalFee.setRequired(false);
        // txtallSharedFee		
        this.txtallSharedFee.setVisible(true);		
        this.txtallSharedFee.setHorizontalAlignment(2);		
        this.txtallSharedFee.setDataType(1);		
        this.txtallSharedFee.setSupportedEmpty(true);		
        this.txtallSharedFee.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtallSharedFee.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtallSharedFee.setPrecision(2);		
        this.txtallSharedFee.setRequired(false);
        // txtallFee		
        this.txtallFee.setVisible(true);		
        this.txtallFee.setHorizontalAlignment(2);		
        this.txtallFee.setDataType(1);		
        this.txtallFee.setSupportedEmpty(true);		
        this.txtallFee.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtallFee.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtallFee.setPrecision(2);		
        this.txtallFee.setRequired(false);
        // txtcompanySaleAmount		
        this.txtcompanySaleAmount.setVisible(true);		
        this.txtcompanySaleAmount.setHorizontalAlignment(2);		
        this.txtcompanySaleAmount.setDataType(1);		
        this.txtcompanySaleAmount.setSupportedEmpty(true);		
        this.txtcompanySaleAmount.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtcompanySaleAmount.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtcompanySaleAmount.setPrecision(2);		
        this.txtcompanySaleAmount.setRequired(false);
        // txtarKhAmount		
        this.txtarKhAmount.setVisible(true);		
        this.txtarKhAmount.setHorizontalAlignment(2);		
        this.txtarKhAmount.setDataType(1);		
        this.txtarKhAmount.setSupportedEmpty(true);		
        this.txtarKhAmount.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtarKhAmount.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtarKhAmount.setPrecision(2);		
        this.txtarKhAmount.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtcompany,txtyear,pkauditTime,txtallGrossProfit,baseStatus,indexType,prmtsaleStimulateInfo,quarter,prmtcompanyTarget,prmtareaTarget,recDataSource,managerFeeShareType,profitExeType,txtnoTaxSaleAmount,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,txtallStandardCost,kdtMonthEntry,prmtsaler,txtallRecAmount,txtallPersonalFee,txtallSharedFee,txtallFee,txtcompanySaleAmount,txtarKhAmount}));
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
        contBizDate.setBounds(new Rectangle(390, -264, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(390, -264, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(390, -264, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(390, -264, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(10, 573, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(10, 573, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompany.setBounds(new Rectangle(365, 14, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(365, 14, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contyear.setBounds(new Rectangle(365, 39, 270, 19));
        this.add(contyear, new KDLayout.Constraints(365, 39, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(10, 599, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(10, 599, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contallGrossProfit.setBounds(new Rectangle(734, 174, 270, 19));
        this.add(contallGrossProfit, new KDLayout.Constraints(734, 174, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbaseStatus.setBounds(new Rectangle(734, 11, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(734, 11, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contindexType.setBounds(new Rectangle(23, 39, 270, 19));
        this.add(contindexType, new KDLayout.Constraints(23, 39, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsaleStimulateInfo.setBounds(new Rectangle(734, 64, 270, 19));
        this.add(contsaleStimulateInfo, new KDLayout.Constraints(734, 64, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contquarter.setBounds(new Rectangle(734, 39, 270, 19));
        this.add(contquarter, new KDLayout.Constraints(734, 39, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompanyTarget.setBounds(new Rectangle(23, 64, 270, 19));
        this.add(contcompanyTarget, new KDLayout.Constraints(23, 64, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contareaTarget.setBounds(new Rectangle(365, 64, 270, 19));
        this.add(contareaTarget, new KDLayout.Constraints(365, 64, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator8.setBounds(new Rectangle(25, 125, 982, 10));
        this.add(kDSeparator8, new KDLayout.Constraints(25, 125, 982, 10, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contrecDataSource.setBounds(new Rectangle(23, 138, 270, 19));
        this.add(contrecDataSource, new KDLayout.Constraints(23, 138, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmanagerFeeShareType.setBounds(new Rectangle(365, 138, 270, 19));
        this.add(contmanagerFeeShareType, new KDLayout.Constraints(365, 138, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contprofitExeType.setBounds(new Rectangle(734, 141, 270, 19));
        this.add(contprofitExeType, new KDLayout.Constraints(734, 141, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator9.setBounds(new Rectangle(20, 163, 983, 10));
        this.add(kDSeparator9, new KDLayout.Constraints(20, 163, 983, 10, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contnoTaxSaleAmount.setBounds(new Rectangle(23, 174, 270, 19));
        this.add(contnoTaxSaleAmount, new KDLayout.Constraints(23, 174, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contallStandardCost.setBounds(new Rectangle(365, 174, 270, 19));
        this.add(contallStandardCost, new KDLayout.Constraints(365, 174, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane1.setBounds(new Rectangle(12, 325, 990, 243));
        this.add(kDTabbedPane1, new KDLayout.Constraints(12, 325, 990, 243, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contsaler.setBounds(new Rectangle(23, 89, 270, 19));
        this.add(contsaler, new KDLayout.Constraints(23, 89, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator10.setBounds(new Rectangle(17, 237, 984, 10));
        this.add(kDSeparator10, new KDLayout.Constraints(17, 237, 984, 10, 0));
        contallRecAmount.setBounds(new Rectangle(23, 205, 270, 19));
        this.add(contallRecAmount, new KDLayout.Constraints(23, 205, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contallPersonalFee.setBounds(new Rectangle(368, 249, 270, 19));
        this.add(contallPersonalFee, new KDLayout.Constraints(368, 249, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contallSharedFee.setBounds(new Rectangle(730, 250, 270, 19));
        this.add(contallSharedFee, new KDLayout.Constraints(730, 250, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contallFee.setBounds(new Rectangle(24, 249, 270, 19));
        this.add(contallFee, new KDLayout.Constraints(24, 249, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompanySaleAmount.setBounds(new Rectangle(365, 89, 270, 19));
        this.add(contcompanySaleAmount, new KDLayout.Constraints(365, 89, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contarKhAmount.setBounds(new Rectangle(24, 282, 270, 19));
        this.add(contarKhAmount, new KDLayout.Constraints(24, 282, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contcompanyTarget
        contcompanyTarget.setBoundEditor(prmtcompanyTarget);
        //contareaTarget
        contareaTarget.setBoundEditor(prmtareaTarget);
        //contrecDataSource
        contrecDataSource.setBoundEditor(recDataSource);
        //contmanagerFeeShareType
        contmanagerFeeShareType.setBoundEditor(managerFeeShareType);
        //contprofitExeType
        contprofitExeType.setBoundEditor(profitExeType);
        //contnoTaxSaleAmount
        contnoTaxSaleAmount.setBoundEditor(txtnoTaxSaleAmount);
        //contallStandardCost
        contallStandardCost.setBoundEditor(txtallStandardCost);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 989, 210));        kdtMonthEntry.setBounds(new Rectangle(-1, 1, 984, 205));
        kdtMonthEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtMonthEntry,new com.kingdee.eas.custom.salepayment.SaleProfitCalculateResultMonthEntryInfo(),null,false);
        kDPanel1.add(kdtMonthEntry_detailPanel, new KDLayout.Constraints(-1, 1, 984, 205, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 989, 210));        kdtFeeEntry.setBounds(new Rectangle(1, 0, 983, 211));
        kdtFeeEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtFeeEntry,new com.kingdee.eas.custom.salepayment.SaleProfitCalculateResultFeeEntryInfo(),null,false);
        kDPanel2.add(kdtFeeEntry_detailPanel, new KDLayout.Constraints(1, 0, 983, 211, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contsaler
        contsaler.setBoundEditor(prmtsaler);
        //contallRecAmount
        contallRecAmount.setBoundEditor(txtallRecAmount);
        //contallPersonalFee
        contallPersonalFee.setBoundEditor(txtallPersonalFee);
        //contallSharedFee
        contallSharedFee.setBoundEditor(txtallSharedFee);
        //contallFee
        contallFee.setBoundEditor(txtallFee);
        //contcompanySaleAmount
        contcompanySaleAmount.setBoundEditor(txtcompanySaleAmount);
        //contarKhAmount
        contarKhAmount.setBoundEditor(txtarKhAmount);

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
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("allGrossProfit", java.math.BigDecimal.class, this.txtallGrossProfit, "value");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("indexType", com.kingdee.eas.custom.salepayment.IndexType.class, this.indexType, "selectedItem");
		dataBinder.registerBinding("saleStimulateInfo", com.kingdee.eas.custom.salepayment.SalerStimulateSetInfo.class, this.prmtsaleStimulateInfo, "data");
		dataBinder.registerBinding("quarter", com.kingdee.eas.custom.salepayment.Quarter.class, this.quarter, "selectedItem");
		dataBinder.registerBinding("companyTarget", com.kingdee.eas.custom.salepayment.CompanyTargetInfo.class, this.prmtcompanyTarget, "data");
		dataBinder.registerBinding("areaTarget", com.kingdee.eas.custom.salepayment.AreaTargetInfo.class, this.prmtareaTarget, "data");
		dataBinder.registerBinding("recDataSource", com.kingdee.eas.custom.salepayment.RecDataSource.class, this.recDataSource, "selectedItem");
		dataBinder.registerBinding("managerFeeShareType", com.kingdee.eas.custom.salepayment.ManageFeeShareType.class, this.managerFeeShareType, "selectedItem");
		dataBinder.registerBinding("profitExeType", com.kingdee.eas.custom.salepayment.ProfitExeType.class, this.profitExeType, "selectedItem");
		dataBinder.registerBinding("noTaxSaleAmount", java.math.BigDecimal.class, this.txtnoTaxSaleAmount, "value");
		dataBinder.registerBinding("allStandardCost", java.math.BigDecimal.class, this.txtallStandardCost, "value");
		dataBinder.registerBinding("MonthEntry.seq", int.class, this.kdtMonthEntry, "seq.text");
		dataBinder.registerBinding("MonthEntry", com.kingdee.eas.custom.salepayment.SaleProfitCalculateResultMonthEntryInfo.class, this.kdtMonthEntry, "userObject");
		dataBinder.registerBinding("MonthEntry.monthGrossProfit", java.lang.Object.class, this.kdtMonthEntry, "monthGrossProfit.text");
		dataBinder.registerBinding("MonthEntry.month", int.class, this.kdtMonthEntry, "month.text");
		dataBinder.registerBinding("MonthEntry.grossProfit", java.math.BigDecimal.class, this.kdtMonthEntry, "grossProfit.text");
		dataBinder.registerBinding("FeeEntry.seq", int.class, this.kdtFeeEntry, "seq.text");
		dataBinder.registerBinding("FeeEntry", com.kingdee.eas.custom.salepayment.SaleProfitCalculateResultFeeEntryInfo.class, this.kdtFeeEntry, "userObject");
		dataBinder.registerBinding("FeeEntry.feeType", java.lang.Object.class, this.kdtFeeEntry, "feeType.text");
		dataBinder.registerBinding("FeeEntry.feeAmount", java.math.BigDecimal.class, this.kdtFeeEntry, "feeAmount.text");
		dataBinder.registerBinding("FeeEntry.isShared", boolean.class, this.kdtFeeEntry, "isShared.text");
		dataBinder.registerBinding("saler", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtsaler, "data");
		dataBinder.registerBinding("allRecAmount", java.math.BigDecimal.class, this.txtallRecAmount, "value");
		dataBinder.registerBinding("allPersonalFee", java.math.BigDecimal.class, this.txtallPersonalFee, "value");
		dataBinder.registerBinding("allSharedFee", java.math.BigDecimal.class, this.txtallSharedFee, "value");
		dataBinder.registerBinding("allFee", java.math.BigDecimal.class, this.txtallFee, "value");
		dataBinder.registerBinding("companySaleAmount", java.math.BigDecimal.class, this.txtcompanySaleAmount, "value");
		dataBinder.registerBinding("arKhAmount", java.math.BigDecimal.class, this.txtarKhAmount, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.salepayment.app.SaleProfitCalculateResultEditUIHandler";
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
        this.editData = (com.kingdee.eas.custom.salepayment.SaleProfitCalculateResultInfo)ov;
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
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allGrossProfit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("indexType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("saleStimulateInfo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("quarter", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("companyTarget", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("areaTarget", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("recDataSource", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("managerFeeShareType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("profitExeType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("noTaxSaleAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allStandardCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MonthEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MonthEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MonthEntry.monthGrossProfit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MonthEntry.month", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MonthEntry.grossProfit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FeeEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FeeEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FeeEntry.feeType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FeeEntry.feeAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FeeEntry.isShared", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("saler", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allRecAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allPersonalFee", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allSharedFee", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allFee", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("companySaleAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("arKhAmount", ValidateHelper.ON_SAVE);    		
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
     * output kdtMonthEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtMonthEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("monthGrossProfit".equalsIgnoreCase(kdtMonthEntry.getColumn(colIndex).getKey())) {
kdtMonthEntry.getCell(rowIndex,"month").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtMonthEntry.getCell(rowIndex,"monthGrossProfit").getValue(),"month")));

}

    if ("monthGrossProfit".equalsIgnoreCase(kdtMonthEntry.getColumn(colIndex).getKey())) {
kdtMonthEntry.getCell(rowIndex,"grossProfit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtMonthEntry.getCell(rowIndex,"monthGrossProfit").getValue(),"allGrossProfit")));

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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("companyTarget.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("companyTarget.id"));
        	sic.add(new SelectorItemInfo("companyTarget.number"));
        	sic.add(new SelectorItemInfo("companyTarget.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("areaTarget.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("areaTarget.id"));
        	sic.add(new SelectorItemInfo("areaTarget.number"));
        	sic.add(new SelectorItemInfo("areaTarget.name"));
		}
        sic.add(new SelectorItemInfo("recDataSource"));
        sic.add(new SelectorItemInfo("managerFeeShareType"));
        sic.add(new SelectorItemInfo("profitExeType"));
        sic.add(new SelectorItemInfo("noTaxSaleAmount"));
        sic.add(new SelectorItemInfo("allStandardCost"));
    	sic.add(new SelectorItemInfo("MonthEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("MonthEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("MonthEntry.monthGrossProfit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("MonthEntry.monthGrossProfit.id"));
			sic.add(new SelectorItemInfo("MonthEntry.monthGrossProfit.number"));
		}
    	sic.add(new SelectorItemInfo("MonthEntry.month"));
    	sic.add(new SelectorItemInfo("MonthEntry.grossProfit"));
    	sic.add(new SelectorItemInfo("FeeEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FeeEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FeeEntry.feeType.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("FeeEntry.feeType.id"));
			sic.add(new SelectorItemInfo("FeeEntry.feeType.name"));
        	sic.add(new SelectorItemInfo("FeeEntry.feeType.number"));
		}
    	sic.add(new SelectorItemInfo("FeeEntry.feeAmount"));
    	sic.add(new SelectorItemInfo("FeeEntry.isShared"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("saler.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("saler.id"));
        	sic.add(new SelectorItemInfo("saler.number"));
        	sic.add(new SelectorItemInfo("saler.name"));
		}
        sic.add(new SelectorItemInfo("allRecAmount"));
        sic.add(new SelectorItemInfo("allPersonalFee"));
        sic.add(new SelectorItemInfo("allSharedFee"));
        sic.add(new SelectorItemInfo("allFee"));
        sic.add(new SelectorItemInfo("companySaleAmount"));
        sic.add(new SelectorItemInfo("arKhAmount"));
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
        return new MetaDataPK("com.kingdee.eas.custom.salepayment.client", "SaleProfitCalculateResultEditUI");
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
        return com.kingdee.eas.custom.salepayment.client.SaleProfitCalculateResultEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.salepayment.SaleProfitCalculateResultFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.salepayment.SaleProfitCalculateResultInfo objectValue = new com.kingdee.eas.custom.salepayment.SaleProfitCalculateResultInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/salepayment/SaleProfitCalculateResult";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.salepayment.app.SaleProfitCalculateResultQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"¹«Ë¾"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtyear.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"Äê"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(baseStatus.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"×´Ì¬"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtMonthEntry;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("baseStatus",new Integer(-1));
vo.put("indexType","2");
vo.put("quarter","1");
vo.put("recDataSource","1");
vo.put("managerFeeShareType","1");
vo.put("profitExeType","1");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}