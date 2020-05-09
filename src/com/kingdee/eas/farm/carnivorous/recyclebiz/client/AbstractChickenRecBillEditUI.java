/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.recyclebiz.client;

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
public abstract class AbstractChickenRecBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractChickenRecBillEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contFICompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatchContract;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatch;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsettlePolicy;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatchQty;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator9;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmAddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmerPhone;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedData;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfeedDays;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisManu;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisSaleOut;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtFICompany;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarm;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbatchContract;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbatch;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsettlePolicy;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkinDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbatchQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperson;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfarmAddress;
    protected com.kingdee.bos.ctrl.swing.KDComboBox farmType;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfarmerPhone;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbreedData;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfeedDays;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtWeigntEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtWeigntEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtButcherEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtButcherEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractChickenRecBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractChickenRecBillEditUI.class.getName());
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
        this.contFICompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbatchContract = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbatch = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsettlePolicy = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbatchQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator9 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contperson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmAddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmerPhone = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbreedData = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfeedDays = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.chkisManu = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisSaleOut = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtFICompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtfarmer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtfarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbatchContract = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbatch = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtsettlePolicy = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkinDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtbatchQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtperson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtfarmAddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.farmType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtfarmerPhone = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtbreedData = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtfeedDays = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtWeigntEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtButcherEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
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
        this.contFICompany.setName("contFICompany");
        this.contauditTime.setName("contauditTime");
        this.contfarmer.setName("contfarmer");
        this.contfarm.setName("contfarm");
        this.contbatchContract.setName("contbatchContract");
        this.contbatch.setName("contbatch");
        this.contbillStatus.setName("contbillStatus");
        this.contsettlePolicy.setName("contsettlePolicy");
        this.continDate.setName("continDate");
        this.contbatchQty.setName("contbatchQty");
        this.kDSeparator9.setName("kDSeparator9");
        this.contperson.setName("contperson");
        this.contfarmAddress.setName("contfarmAddress");
        this.contfarmType.setName("contfarmType");
        this.contfarmerPhone.setName("contfarmerPhone");
        this.contbreedData.setName("contbreedData");
        this.contfeedDays.setName("contfeedDays");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.chkisManu.setName("chkisManu");
        this.chkisSaleOut.setName("chkisSaleOut");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtFICompany.setName("prmtFICompany");
        this.pkauditTime.setName("pkauditTime");
        this.prmtfarmer.setName("prmtfarmer");
        this.prmtfarm.setName("prmtfarm");
        this.prmtbatchContract.setName("prmtbatchContract");
        this.prmtbatch.setName("prmtbatch");
        this.billStatus.setName("billStatus");
        this.prmtsettlePolicy.setName("prmtsettlePolicy");
        this.pkinDate.setName("pkinDate");
        this.txtbatchQty.setName("txtbatchQty");
        this.prmtperson.setName("prmtperson");
        this.txtfarmAddress.setName("txtfarmAddress");
        this.farmType.setName("farmType");
        this.txtfarmerPhone.setName("txtfarmerPhone");
        this.prmtbreedData.setName("prmtbreedData");
        this.txtfeedDays.setName("txtfeedDays");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel3.setName("kDPanel3");
        this.kdtEntry.setName("kdtEntry");
        this.kdtWeigntEntry.setName("kdtWeigntEntry");
        this.kdtButcherEntry.setName("kdtButcherEntry");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
        // CoreUI		
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
        // contFICompany		
        this.contFICompany.setBoundLabelText(resHelper.getString("contFICompany.boundLabelText"));		
        this.contFICompany.setBoundLabelLength(100);		
        this.contFICompany.setBoundLabelUnderline(true);		
        this.contFICompany.setVisible(true);
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // contfarmer		
        this.contfarmer.setBoundLabelText(resHelper.getString("contfarmer.boundLabelText"));		
        this.contfarmer.setBoundLabelLength(100);		
        this.contfarmer.setBoundLabelUnderline(true);		
        this.contfarmer.setVisible(true);
        // contfarm		
        this.contfarm.setBoundLabelText(resHelper.getString("contfarm.boundLabelText"));		
        this.contfarm.setBoundLabelLength(100);		
        this.contfarm.setBoundLabelUnderline(true);		
        this.contfarm.setVisible(true);
        // contbatchContract		
        this.contbatchContract.setBoundLabelText(resHelper.getString("contbatchContract.boundLabelText"));		
        this.contbatchContract.setBoundLabelLength(100);		
        this.contbatchContract.setBoundLabelUnderline(true);		
        this.contbatchContract.setVisible(true);
        // contbatch		
        this.contbatch.setBoundLabelText(resHelper.getString("contbatch.boundLabelText"));		
        this.contbatch.setBoundLabelLength(100);		
        this.contbatch.setBoundLabelUnderline(true);		
        this.contbatch.setVisible(true);
        // contbillStatus		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);
        // contsettlePolicy		
        this.contsettlePolicy.setBoundLabelText(resHelper.getString("contsettlePolicy.boundLabelText"));		
        this.contsettlePolicy.setBoundLabelLength(100);		
        this.contsettlePolicy.setBoundLabelUnderline(true);		
        this.contsettlePolicy.setVisible(true);
        // continDate		
        this.continDate.setBoundLabelText(resHelper.getString("continDate.boundLabelText"));		
        this.continDate.setBoundLabelLength(100);		
        this.continDate.setBoundLabelUnderline(true);		
        this.continDate.setVisible(true);
        // contbatchQty		
        this.contbatchQty.setBoundLabelText(resHelper.getString("contbatchQty.boundLabelText"));		
        this.contbatchQty.setBoundLabelLength(100);		
        this.contbatchQty.setBoundLabelUnderline(true);		
        this.contbatchQty.setVisible(true);
        // kDSeparator9
        // contperson		
        this.contperson.setBoundLabelText(resHelper.getString("contperson.boundLabelText"));		
        this.contperson.setBoundLabelLength(100);		
        this.contperson.setBoundLabelUnderline(true);		
        this.contperson.setVisible(true);
        // contfarmAddress		
        this.contfarmAddress.setBoundLabelText(resHelper.getString("contfarmAddress.boundLabelText"));		
        this.contfarmAddress.setBoundLabelLength(100);		
        this.contfarmAddress.setBoundLabelUnderline(true);		
        this.contfarmAddress.setVisible(true);
        // contfarmType		
        this.contfarmType.setBoundLabelText(resHelper.getString("contfarmType.boundLabelText"));		
        this.contfarmType.setBoundLabelLength(100);		
        this.contfarmType.setBoundLabelUnderline(true);		
        this.contfarmType.setVisible(true);
        // contfarmerPhone		
        this.contfarmerPhone.setBoundLabelText(resHelper.getString("contfarmerPhone.boundLabelText"));		
        this.contfarmerPhone.setBoundLabelLength(100);		
        this.contfarmerPhone.setBoundLabelUnderline(true);		
        this.contfarmerPhone.setVisible(true);
        // contbreedData		
        this.contbreedData.setBoundLabelText(resHelper.getString("contbreedData.boundLabelText"));		
        this.contbreedData.setBoundLabelLength(100);		
        this.contbreedData.setBoundLabelUnderline(true);		
        this.contbreedData.setVisible(true);
        // contfeedDays		
        this.contfeedDays.setBoundLabelText(resHelper.getString("contfeedDays.boundLabelText"));		
        this.contfeedDays.setBoundLabelLength(100);		
        this.contfeedDays.setBoundLabelUnderline(true);		
        this.contfeedDays.setVisible(true);
        // kDTabbedPane1
        // chkisManu		
        this.chkisManu.setText(resHelper.getString("chkisManu.text"));		
        this.chkisManu.setVisible(true);		
        this.chkisManu.setHorizontalAlignment(2);		
        this.chkisManu.setEnabled(false);
        // chkisSaleOut		
        this.chkisSaleOut.setText(resHelper.getString("chkisSaleOut.text"));		
        this.chkisSaleOut.setVisible(true);		
        this.chkisSaleOut.setHorizontalAlignment(2);		
        this.chkisSaleOut.setEnabled(false);
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
        // prmtFICompany		
        this.prmtFICompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery4AsstAcct");		
        this.prmtFICompany.setEditable(true);		
        this.prmtFICompany.setDisplayFormat("$name$");		
        this.prmtFICompany.setEditFormat("$number$");		
        this.prmtFICompany.setCommitFormat("$number$");		
        this.prmtFICompany.setRequired(true);
        		setOrgF7(prmtFICompany,com.kingdee.eas.basedata.org.OrgType.getEnum("Company"));
					
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // prmtfarmer		
        this.prmtfarmer.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerQuery");		
        this.prmtfarmer.setEditable(true);		
        this.prmtfarmer.setDisplayFormat("$name$");		
        this.prmtfarmer.setEditFormat("$number$");		
        this.prmtfarmer.setCommitFormat("$number$");		
        this.prmtfarmer.setRequired(true);		
        this.prmtfarmer.setEnabled(false);
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
					
        prmtfarmer.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtfarmer_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // prmtfarm		
        this.prmtfarm.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmQuery");		
        this.prmtfarm.setEditable(true);		
        this.prmtfarm.setDisplayFormat("$name$");		
        this.prmtfarm.setEditFormat("$number$");		
        this.prmtfarm.setCommitFormat("$number$");		
        this.prmtfarm.setRequired(true);		
        this.prmtfarm.setEnabled(false);
        		prmtfarm.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.FarmListUI prmtfarm_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarm_F7ListUI == null) {
					try {
						prmtfarm_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.FarmListUI();
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
					
        prmtfarm.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtfarm_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // prmtbatchContract		
        this.prmtbatchContract.setQueryInfo("com.kingdee.eas.farm.carnivorous.feedbiz.app.BatchContractBillQuery");		
        this.prmtbatchContract.setEditable(true);		
        this.prmtbatchContract.setDisplayFormat("$number$");		
        this.prmtbatchContract.setEditFormat("$number$");		
        this.prmtbatchContract.setCommitFormat("$number$");		
        this.prmtbatchContract.setRequired(true);
        // prmtbatch		
        this.prmtbatch.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.BatchQuery");		
        this.prmtbatch.setEditable(true);		
        this.prmtbatch.setDisplayFormat("$name$");		
        this.prmtbatch.setEditFormat("$number$");		
        this.prmtbatch.setCommitFormat("$number$");		
        this.prmtbatch.setRequired(false);		
        this.prmtbatch.setEnabled(false);
        		prmtbatch.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.BatchListUI prmtbatch_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtbatch_F7ListUI == null) {
					try {
						prmtbatch_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.BatchListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtbatch_F7ListUI));
					prmtbatch_F7ListUI.setF7Use(true,ctx);
					prmtbatch.setSelector(prmtbatch_F7ListUI);
				}
			}
		});
					
        // billStatus		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // prmtsettlePolicy		
        this.prmtsettlePolicy.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.SettlePolicyQuery");		
        this.prmtsettlePolicy.setEditable(true);		
        this.prmtsettlePolicy.setDisplayFormat("$name$");		
        this.prmtsettlePolicy.setEditFormat("$number$");		
        this.prmtsettlePolicy.setCommitFormat("$number$");		
        this.prmtsettlePolicy.setRequired(false);		
        this.prmtsettlePolicy.setEnabled(false);
        		prmtsettlePolicy.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.SettlePolicyListUI prmtsettlePolicy_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtsettlePolicy_F7ListUI == null) {
					try {
						prmtsettlePolicy_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.SettlePolicyListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtsettlePolicy_F7ListUI));
					prmtsettlePolicy_F7ListUI.setF7Use(true,ctx);
					prmtsettlePolicy.setSelector(prmtsettlePolicy_F7ListUI);
				}
			}
		});
					
        // pkinDate		
        this.pkinDate.setRequired(false);		
        this.pkinDate.setEnabled(false);
        // txtbatchQty		
        this.txtbatchQty.setHorizontalAlignment(2);		
        this.txtbatchQty.setDataType(1);		
        this.txtbatchQty.setSupportedEmpty(true);		
        this.txtbatchQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbatchQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbatchQty.setPrecision(4);		
        this.txtbatchQty.setRequired(false);		
        this.txtbatchQty.setEnabled(false);
        // prmtperson		
        this.prmtperson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtperson.setEditable(true);		
        this.prmtperson.setDisplayFormat("$name$");		
        this.prmtperson.setEditFormat("$number$");		
        this.prmtperson.setCommitFormat("$number$");		
        this.prmtperson.setRequired(false);		
        this.prmtperson.setEnabled(false);
        // txtfarmAddress		
        this.txtfarmAddress.setHorizontalAlignment(2);		
        this.txtfarmAddress.setMaxLength(80);		
        this.txtfarmAddress.setRequired(false);		
        this.txtfarmAddress.setEnabled(false);
        // farmType		
        this.farmType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.FarmsType").toArray());		
        this.farmType.setRequired(false);		
        this.farmType.setEnabled(false);
        // txtfarmerPhone		
        this.txtfarmerPhone.setHorizontalAlignment(2);		
        this.txtfarmerPhone.setMaxLength(80);		
        this.txtfarmerPhone.setRequired(false);		
        this.txtfarmerPhone.setEnabled(false);
        // prmtbreedData		
        this.prmtbreedData.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.BreedDataQuery");		
        this.prmtbreedData.setEditable(true);		
        this.prmtbreedData.setDisplayFormat("$name$");		
        this.prmtbreedData.setEditFormat("$number$");		
        this.prmtbreedData.setCommitFormat("$number$");		
        this.prmtbreedData.setRequired(false);		
        this.prmtbreedData.setEnabled(false);
        		prmtbreedData.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI prmtbreedData_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtbreedData_F7ListUI == null) {
					try {
						prmtbreedData_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtbreedData_F7ListUI));
					prmtbreedData_F7ListUI.setF7Use(true,ctx);
					prmtbreedData.setSelector(prmtbreedData_F7ListUI);
				}
			}
		});
					
        // txtfeedDays		
        this.txtfeedDays.setHorizontalAlignment(2);		
        this.txtfeedDays.setDataType(0);		
        this.txtfeedDays.setSupportedEmpty(true);		
        this.txtfeedDays.setRequired(false);		
        this.txtfeedDays.setEnabled(false);
        // kDPanel1
        // kDPanel2
        // kDPanel3
        // kdtEntry
		String kdtEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"car\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"driver\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"telephone\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"chickenQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{car}</t:Cell><t:Cell>$Resource{driver}</t:Cell><t:Cell>$Resource{telephone}</t:Cell><t:Cell>$Resource{chickenQty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntry.setFormatXml(resHelper.translateString("kdtEntry",kdtEntryStrXML));
        kdtEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtEntry.putBindContents("editData",new String[] {"seq","car","driver","telephone","chickenQty"});


        this.kdtEntry.checkParsed();
        final KDBizPromptBox kdtEntry_car_PromptBox = new KDBizPromptBox();
        kdtEntry_car_PromptBox.setQueryInfo("com.kingdee.eas.publicdata.app.CarQuery");
        kdtEntry_car_PromptBox.setVisible(true);
        kdtEntry_car_PromptBox.setEditable(true);
        kdtEntry_car_PromptBox.setDisplayFormat("$number$");
        kdtEntry_car_PromptBox.setEditFormat("$number$");
        kdtEntry_car_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_car_CellEditor = new KDTDefaultCellEditor(kdtEntry_car_PromptBox);
        this.kdtEntry.getColumn("car").setEditor(kdtEntry_car_CellEditor);
        ObjectValueRender kdtEntry_car_OVR = new ObjectValueRender();
        kdtEntry_car_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntry.getColumn("car").setRenderer(kdtEntry_car_OVR);
        			kdtEntry_car_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.CarListUI kdtEntry_car_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntry_car_PromptBox_F7ListUI == null) {
					try {
						kdtEntry_car_PromptBox_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.CarListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntry_car_PromptBox_F7ListUI));
					kdtEntry_car_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntry_car_PromptBox.setSelector(kdtEntry_car_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEntry_driver_PromptBox = new KDBizPromptBox();
        kdtEntry_driver_PromptBox.setQueryInfo("com.kingdee.eas.farm.feemanager.basedata.app.DriverQuery");
        kdtEntry_driver_PromptBox.setVisible(true);
        kdtEntry_driver_PromptBox.setEditable(true);
        kdtEntry_driver_PromptBox.setDisplayFormat("$number$");
        kdtEntry_driver_PromptBox.setEditFormat("$number$");
        kdtEntry_driver_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_driver_CellEditor = new KDTDefaultCellEditor(kdtEntry_driver_PromptBox);
        this.kdtEntry.getColumn("driver").setEditor(kdtEntry_driver_CellEditor);
        ObjectValueRender kdtEntry_driver_OVR = new ObjectValueRender();
        kdtEntry_driver_OVR.setFormat(new BizDataFormat("$drivername$"));
        this.kdtEntry.getColumn("driver").setRenderer(kdtEntry_driver_OVR);
        			kdtEntry_driver_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI kdtEntry_driver_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntry_driver_PromptBox_F7ListUI == null) {
					try {
						kdtEntry_driver_PromptBox_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntry_driver_PromptBox_F7ListUI));
					kdtEntry_driver_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntry_driver_PromptBox.setSelector(kdtEntry_driver_PromptBox_F7ListUI);
				}
			}
		});
					
        KDTextField kdtEntry_telephone_TextField = new KDTextField();
        kdtEntry_telephone_TextField.setName("kdtEntry_telephone_TextField");
        kdtEntry_telephone_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntry_telephone_CellEditor = new KDTDefaultCellEditor(kdtEntry_telephone_TextField);
        this.kdtEntry.getColumn("telephone").setEditor(kdtEntry_telephone_CellEditor);
        KDFormattedTextField kdtEntry_chickenQty_TextField = new KDFormattedTextField();
        kdtEntry_chickenQty_TextField.setName("kdtEntry_chickenQty_TextField");
        kdtEntry_chickenQty_TextField.setVisible(true);
        kdtEntry_chickenQty_TextField.setEditable(true);
        kdtEntry_chickenQty_TextField.setHorizontalAlignment(2);
        kdtEntry_chickenQty_TextField.setDataType(1);
        	kdtEntry_chickenQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_chickenQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_chickenQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_chickenQty_CellEditor = new KDTDefaultCellEditor(kdtEntry_chickenQty_TextField);
        this.kdtEntry.getColumn("chickenQty").setEditor(kdtEntry_chickenQty_CellEditor);
        // kdtWeigntEntry
		String kdtWeigntEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol17\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol18\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol19\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol20\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol21\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"carcar\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"carleader\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"driver\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"telephone\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"carText\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"driverText\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"driverTel\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"settlementItem\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"carcass\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"marketPrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"chickenQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"houseWeight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"houseSkinWeight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"houseNetWeight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"avgWgt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"customer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"saleChicPrice\" t:width=\"180\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"saleQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"punishAmt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol19\" /><t:Column t:key=\"saleAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol20\" /><t:Column t:key=\"carcessReduceWeight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol21\" /><t:Column t:key=\"entryEemark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{carcar}</t:Cell><t:Cell>$Resource{carleader}</t:Cell><t:Cell>$Resource{driver}</t:Cell><t:Cell>$Resource{telephone}</t:Cell><t:Cell>$Resource{carText}</t:Cell><t:Cell>$Resource{driverText}</t:Cell><t:Cell>$Resource{driverTel}</t:Cell><t:Cell>$Resource{settlementItem}</t:Cell><t:Cell>$Resource{carcass}</t:Cell><t:Cell>$Resource{marketPrice}</t:Cell><t:Cell>$Resource{chickenQty}</t:Cell><t:Cell>$Resource{houseWeight}</t:Cell><t:Cell>$Resource{houseSkinWeight}</t:Cell><t:Cell>$Resource{houseNetWeight}</t:Cell><t:Cell>$Resource{avgWgt}</t:Cell><t:Cell>$Resource{customer}</t:Cell><t:Cell>$Resource{saleChicPrice}</t:Cell><t:Cell>$Resource{saleQty}</t:Cell><t:Cell>$Resource{punishAmt}</t:Cell><t:Cell>$Resource{saleAmount}</t:Cell><t:Cell>$Resource{carcessReduceWeight}</t:Cell><t:Cell>$Resource{entryEemark}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtWeigntEntry.setFormatXml(resHelper.translateString("kdtWeigntEntry",kdtWeigntEntryStrXML));
        kdtWeigntEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtWeigntEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtWeigntEntry.putBindContents("editData",new String[] {"seq","carcar","carleader","driver","telephone","carText","driverText","driverTel","settlementItem","carcass","marketPrice","chickenQty","houseWeight","houseSkinWeight","houseNetWeight","avgWgt","customer","saleChicPrice","saleQty","punishAmt","saleAmount","carcessReduceWeight","entryEemark"});


        this.kdtWeigntEntry.checkParsed();
        final KDBizPromptBox kdtWeigntEntry_carcar_PromptBox = new KDBizPromptBox();
        kdtWeigntEntry_carcar_PromptBox.setQueryInfo("com.kingdee.eas.publicdata.app.CarQuery");
        kdtWeigntEntry_carcar_PromptBox.setVisible(true);
        kdtWeigntEntry_carcar_PromptBox.setEditable(true);
        kdtWeigntEntry_carcar_PromptBox.setDisplayFormat("$number$");
        kdtWeigntEntry_carcar_PromptBox.setEditFormat("$number$");
        kdtWeigntEntry_carcar_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtWeigntEntry_carcar_CellEditor = new KDTDefaultCellEditor(kdtWeigntEntry_carcar_PromptBox);
        this.kdtWeigntEntry.getColumn("carcar").setEditor(kdtWeigntEntry_carcar_CellEditor);
        ObjectValueRender kdtWeigntEntry_carcar_OVR = new ObjectValueRender();
        kdtWeigntEntry_carcar_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtWeigntEntry.getColumn("carcar").setRenderer(kdtWeigntEntry_carcar_OVR);
        			kdtWeigntEntry_carcar_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.CarListUI kdtWeigntEntry_carcar_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtWeigntEntry_carcar_PromptBox_F7ListUI == null) {
					try {
						kdtWeigntEntry_carcar_PromptBox_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.CarListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtWeigntEntry_carcar_PromptBox_F7ListUI));
					kdtWeigntEntry_carcar_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtWeigntEntry_carcar_PromptBox.setSelector(kdtWeigntEntry_carcar_PromptBox_F7ListUI);
				}
			}
		});
					
        KDTextField kdtWeigntEntry_carleader_TextField = new KDTextField();
        kdtWeigntEntry_carleader_TextField.setName("kdtWeigntEntry_carleader_TextField");
        kdtWeigntEntry_carleader_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtWeigntEntry_carleader_CellEditor = new KDTDefaultCellEditor(kdtWeigntEntry_carleader_TextField);
        this.kdtWeigntEntry.getColumn("carleader").setEditor(kdtWeigntEntry_carleader_CellEditor);
        final KDBizPromptBox kdtWeigntEntry_driver_PromptBox = new KDBizPromptBox();
        kdtWeigntEntry_driver_PromptBox.setQueryInfo("com.kingdee.eas.farm.feemanager.basedata.app.DriverQuery");
        kdtWeigntEntry_driver_PromptBox.setVisible(true);
        kdtWeigntEntry_driver_PromptBox.setEditable(true);
        kdtWeigntEntry_driver_PromptBox.setDisplayFormat("$number$");
        kdtWeigntEntry_driver_PromptBox.setEditFormat("$number$");
        kdtWeigntEntry_driver_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtWeigntEntry_driver_CellEditor = new KDTDefaultCellEditor(kdtWeigntEntry_driver_PromptBox);
        this.kdtWeigntEntry.getColumn("driver").setEditor(kdtWeigntEntry_driver_CellEditor);
        ObjectValueRender kdtWeigntEntry_driver_OVR = new ObjectValueRender();
        kdtWeigntEntry_driver_OVR.setFormat(new BizDataFormat("$drivername$"));
        this.kdtWeigntEntry.getColumn("driver").setRenderer(kdtWeigntEntry_driver_OVR);
        			kdtWeigntEntry_driver_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI kdtWeigntEntry_driver_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtWeigntEntry_driver_PromptBox_F7ListUI == null) {
					try {
						kdtWeigntEntry_driver_PromptBox_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtWeigntEntry_driver_PromptBox_F7ListUI));
					kdtWeigntEntry_driver_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtWeigntEntry_driver_PromptBox.setSelector(kdtWeigntEntry_driver_PromptBox_F7ListUI);
				}
			}
		});
					
        KDTextField kdtWeigntEntry_telephone_TextField = new KDTextField();
        kdtWeigntEntry_telephone_TextField.setName("kdtWeigntEntry_telephone_TextField");
        kdtWeigntEntry_telephone_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtWeigntEntry_telephone_CellEditor = new KDTDefaultCellEditor(kdtWeigntEntry_telephone_TextField);
        this.kdtWeigntEntry.getColumn("telephone").setEditor(kdtWeigntEntry_telephone_CellEditor);
        KDTextField kdtWeigntEntry_carText_TextField = new KDTextField();
        kdtWeigntEntry_carText_TextField.setName("kdtWeigntEntry_carText_TextField");
        kdtWeigntEntry_carText_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtWeigntEntry_carText_CellEditor = new KDTDefaultCellEditor(kdtWeigntEntry_carText_TextField);
        this.kdtWeigntEntry.getColumn("carText").setEditor(kdtWeigntEntry_carText_CellEditor);
        KDTextField kdtWeigntEntry_driverText_TextField = new KDTextField();
        kdtWeigntEntry_driverText_TextField.setName("kdtWeigntEntry_driverText_TextField");
        kdtWeigntEntry_driverText_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtWeigntEntry_driverText_CellEditor = new KDTDefaultCellEditor(kdtWeigntEntry_driverText_TextField);
        this.kdtWeigntEntry.getColumn("driverText").setEditor(kdtWeigntEntry_driverText_CellEditor);
        KDTextField kdtWeigntEntry_driverTel_TextField = new KDTextField();
        kdtWeigntEntry_driverTel_TextField.setName("kdtWeigntEntry_driverTel_TextField");
        kdtWeigntEntry_driverTel_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtWeigntEntry_driverTel_CellEditor = new KDTDefaultCellEditor(kdtWeigntEntry_driverTel_TextField);
        this.kdtWeigntEntry.getColumn("driverTel").setEditor(kdtWeigntEntry_driverTel_CellEditor);
        KDComboBox kdtWeigntEntry_settlementItem_ComboBox = new KDComboBox();
        kdtWeigntEntry_settlementItem_ComboBox.setName("kdtWeigntEntry_settlementItem_ComboBox");
        kdtWeigntEntry_settlementItem_ComboBox.setVisible(true);
        kdtWeigntEntry_settlementItem_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.basedata.settlementItem").toArray());
        KDTDefaultCellEditor kdtWeigntEntry_settlementItem_CellEditor = new KDTDefaultCellEditor(kdtWeigntEntry_settlementItem_ComboBox);
        this.kdtWeigntEntry.getColumn("settlementItem").setEditor(kdtWeigntEntry_settlementItem_CellEditor);
        KDCheckBox kdtWeigntEntry_carcass_CheckBox = new KDCheckBox();
        kdtWeigntEntry_carcass_CheckBox.setName("kdtWeigntEntry_carcass_CheckBox");
        KDTDefaultCellEditor kdtWeigntEntry_carcass_CellEditor = new KDTDefaultCellEditor(kdtWeigntEntry_carcass_CheckBox);
        this.kdtWeigntEntry.getColumn("carcass").setEditor(kdtWeigntEntry_carcass_CellEditor);
        KDFormattedTextField kdtWeigntEntry_marketPrice_TextField = new KDFormattedTextField();
        kdtWeigntEntry_marketPrice_TextField.setName("kdtWeigntEntry_marketPrice_TextField");
        kdtWeigntEntry_marketPrice_TextField.setVisible(true);
        kdtWeigntEntry_marketPrice_TextField.setEditable(true);
        kdtWeigntEntry_marketPrice_TextField.setHorizontalAlignment(2);
        kdtWeigntEntry_marketPrice_TextField.setDataType(1);
        	kdtWeigntEntry_marketPrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtWeigntEntry_marketPrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtWeigntEntry_marketPrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtWeigntEntry_marketPrice_CellEditor = new KDTDefaultCellEditor(kdtWeigntEntry_marketPrice_TextField);
        this.kdtWeigntEntry.getColumn("marketPrice").setEditor(kdtWeigntEntry_marketPrice_CellEditor);
        KDFormattedTextField kdtWeigntEntry_chickenQty_TextField = new KDFormattedTextField();
        kdtWeigntEntry_chickenQty_TextField.setName("kdtWeigntEntry_chickenQty_TextField");
        kdtWeigntEntry_chickenQty_TextField.setVisible(true);
        kdtWeigntEntry_chickenQty_TextField.setEditable(true);
        kdtWeigntEntry_chickenQty_TextField.setHorizontalAlignment(2);
        kdtWeigntEntry_chickenQty_TextField.setDataType(1);
        	kdtWeigntEntry_chickenQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtWeigntEntry_chickenQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtWeigntEntry_chickenQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtWeigntEntry_chickenQty_CellEditor = new KDTDefaultCellEditor(kdtWeigntEntry_chickenQty_TextField);
        this.kdtWeigntEntry.getColumn("chickenQty").setEditor(kdtWeigntEntry_chickenQty_CellEditor);
        KDFormattedTextField kdtWeigntEntry_houseWeight_TextField = new KDFormattedTextField();
        kdtWeigntEntry_houseWeight_TextField.setName("kdtWeigntEntry_houseWeight_TextField");
        kdtWeigntEntry_houseWeight_TextField.setVisible(true);
        kdtWeigntEntry_houseWeight_TextField.setEditable(true);
        kdtWeigntEntry_houseWeight_TextField.setHorizontalAlignment(2);
        kdtWeigntEntry_houseWeight_TextField.setDataType(1);
        	kdtWeigntEntry_houseWeight_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E25"));
        	kdtWeigntEntry_houseWeight_TextField.setMaximumValue(new java.math.BigDecimal("1.0E25"));
        kdtWeigntEntry_houseWeight_TextField.setPrecision(3);
        KDTDefaultCellEditor kdtWeigntEntry_houseWeight_CellEditor = new KDTDefaultCellEditor(kdtWeigntEntry_houseWeight_TextField);
        this.kdtWeigntEntry.getColumn("houseWeight").setEditor(kdtWeigntEntry_houseWeight_CellEditor);
        KDFormattedTextField kdtWeigntEntry_houseSkinWeight_TextField = new KDFormattedTextField();
        kdtWeigntEntry_houseSkinWeight_TextField.setName("kdtWeigntEntry_houseSkinWeight_TextField");
        kdtWeigntEntry_houseSkinWeight_TextField.setVisible(true);
        kdtWeigntEntry_houseSkinWeight_TextField.setEditable(true);
        kdtWeigntEntry_houseSkinWeight_TextField.setHorizontalAlignment(2);
        kdtWeigntEntry_houseSkinWeight_TextField.setDataType(1);
        	kdtWeigntEntry_houseSkinWeight_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E25"));
        	kdtWeigntEntry_houseSkinWeight_TextField.setMaximumValue(new java.math.BigDecimal("1.0E25"));
        kdtWeigntEntry_houseSkinWeight_TextField.setPrecision(3);
        KDTDefaultCellEditor kdtWeigntEntry_houseSkinWeight_CellEditor = new KDTDefaultCellEditor(kdtWeigntEntry_houseSkinWeight_TextField);
        this.kdtWeigntEntry.getColumn("houseSkinWeight").setEditor(kdtWeigntEntry_houseSkinWeight_CellEditor);
        KDTextField kdtWeigntEntry_houseNetWeight_TextField = new KDTextField();
        kdtWeigntEntry_houseNetWeight_TextField.setName("kdtWeigntEntry_houseNetWeight_TextField");
        kdtWeigntEntry_houseNetWeight_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtWeigntEntry_houseNetWeight_CellEditor = new KDTDefaultCellEditor(kdtWeigntEntry_houseNetWeight_TextField);
        this.kdtWeigntEntry.getColumn("houseNetWeight").setEditor(kdtWeigntEntry_houseNetWeight_CellEditor);
        KDFormattedTextField kdtWeigntEntry_avgWgt_TextField = new KDFormattedTextField();
        kdtWeigntEntry_avgWgt_TextField.setName("kdtWeigntEntry_avgWgt_TextField");
        kdtWeigntEntry_avgWgt_TextField.setVisible(true);
        kdtWeigntEntry_avgWgt_TextField.setEditable(true);
        kdtWeigntEntry_avgWgt_TextField.setHorizontalAlignment(2);
        kdtWeigntEntry_avgWgt_TextField.setDataType(1);
        	kdtWeigntEntry_avgWgt_TextField.setMinimumValue(new java.math.BigDecimal("-9.999999999999999E22"));
        	kdtWeigntEntry_avgWgt_TextField.setMaximumValue(new java.math.BigDecimal("9.999999999999999E22"));
        kdtWeigntEntry_avgWgt_TextField.setPrecision(5);
        KDTDefaultCellEditor kdtWeigntEntry_avgWgt_CellEditor = new KDTDefaultCellEditor(kdtWeigntEntry_avgWgt_TextField);
        this.kdtWeigntEntry.getColumn("avgWgt").setEditor(kdtWeigntEntry_avgWgt_CellEditor);
        final KDBizPromptBox kdtWeigntEntry_customer_PromptBox = new KDBizPromptBox();
        kdtWeigntEntry_customer_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.CustomerInfoQuery");
        kdtWeigntEntry_customer_PromptBox.setVisible(true);
        kdtWeigntEntry_customer_PromptBox.setEditable(true);
        kdtWeigntEntry_customer_PromptBox.setDisplayFormat("$number$");
        kdtWeigntEntry_customer_PromptBox.setEditFormat("$number$");
        kdtWeigntEntry_customer_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtWeigntEntry_customer_CellEditor = new KDTDefaultCellEditor(kdtWeigntEntry_customer_PromptBox);
        this.kdtWeigntEntry.getColumn("customer").setEditor(kdtWeigntEntry_customer_CellEditor);
        ObjectValueRender kdtWeigntEntry_customer_OVR = new ObjectValueRender();
        kdtWeigntEntry_customer_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtWeigntEntry.getColumn("customer").setRenderer(kdtWeigntEntry_customer_OVR);
        KDFormattedTextField kdtWeigntEntry_saleChicPrice_TextField = new KDFormattedTextField();
        kdtWeigntEntry_saleChicPrice_TextField.setName("kdtWeigntEntry_saleChicPrice_TextField");
        kdtWeigntEntry_saleChicPrice_TextField.setVisible(true);
        kdtWeigntEntry_saleChicPrice_TextField.setEditable(true);
        kdtWeigntEntry_saleChicPrice_TextField.setHorizontalAlignment(2);
        kdtWeigntEntry_saleChicPrice_TextField.setDataType(1);
        	kdtWeigntEntry_saleChicPrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E25"));
        	kdtWeigntEntry_saleChicPrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E25"));
        kdtWeigntEntry_saleChicPrice_TextField.setPrecision(3);
        KDTDefaultCellEditor kdtWeigntEntry_saleChicPrice_CellEditor = new KDTDefaultCellEditor(kdtWeigntEntry_saleChicPrice_TextField);
        this.kdtWeigntEntry.getColumn("saleChicPrice").setEditor(kdtWeigntEntry_saleChicPrice_CellEditor);
        KDFormattedTextField kdtWeigntEntry_saleQty_TextField = new KDFormattedTextField();
        kdtWeigntEntry_saleQty_TextField.setName("kdtWeigntEntry_saleQty_TextField");
        kdtWeigntEntry_saleQty_TextField.setVisible(true);
        kdtWeigntEntry_saleQty_TextField.setEditable(true);
        kdtWeigntEntry_saleQty_TextField.setHorizontalAlignment(2);
        kdtWeigntEntry_saleQty_TextField.setDataType(1);
        	kdtWeigntEntry_saleQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtWeigntEntry_saleQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtWeigntEntry_saleQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtWeigntEntry_saleQty_CellEditor = new KDTDefaultCellEditor(kdtWeigntEntry_saleQty_TextField);
        this.kdtWeigntEntry.getColumn("saleQty").setEditor(kdtWeigntEntry_saleQty_CellEditor);
        KDFormattedTextField kdtWeigntEntry_punishAmt_TextField = new KDFormattedTextField();
        kdtWeigntEntry_punishAmt_TextField.setName("kdtWeigntEntry_punishAmt_TextField");
        kdtWeigntEntry_punishAmt_TextField.setVisible(true);
        kdtWeigntEntry_punishAmt_TextField.setEditable(true);
        kdtWeigntEntry_punishAmt_TextField.setHorizontalAlignment(2);
        kdtWeigntEntry_punishAmt_TextField.setDataType(1);
        	kdtWeigntEntry_punishAmt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtWeigntEntry_punishAmt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtWeigntEntry_punishAmt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtWeigntEntry_punishAmt_CellEditor = new KDTDefaultCellEditor(kdtWeigntEntry_punishAmt_TextField);
        this.kdtWeigntEntry.getColumn("punishAmt").setEditor(kdtWeigntEntry_punishAmt_CellEditor);
        KDFormattedTextField kdtWeigntEntry_saleAmount_TextField = new KDFormattedTextField();
        kdtWeigntEntry_saleAmount_TextField.setName("kdtWeigntEntry_saleAmount_TextField");
        kdtWeigntEntry_saleAmount_TextField.setVisible(true);
        kdtWeigntEntry_saleAmount_TextField.setEditable(true);
        kdtWeigntEntry_saleAmount_TextField.setHorizontalAlignment(2);
        kdtWeigntEntry_saleAmount_TextField.setDataType(1);
        	kdtWeigntEntry_saleAmount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtWeigntEntry_saleAmount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtWeigntEntry_saleAmount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtWeigntEntry_saleAmount_CellEditor = new KDTDefaultCellEditor(kdtWeigntEntry_saleAmount_TextField);
        this.kdtWeigntEntry.getColumn("saleAmount").setEditor(kdtWeigntEntry_saleAmount_CellEditor);
        KDFormattedTextField kdtWeigntEntry_carcessReduceWeight_TextField = new KDFormattedTextField();
        kdtWeigntEntry_carcessReduceWeight_TextField.setName("kdtWeigntEntry_carcessReduceWeight_TextField");
        kdtWeigntEntry_carcessReduceWeight_TextField.setVisible(true);
        kdtWeigntEntry_carcessReduceWeight_TextField.setEditable(true);
        kdtWeigntEntry_carcessReduceWeight_TextField.setHorizontalAlignment(2);
        kdtWeigntEntry_carcessReduceWeight_TextField.setDataType(1);
        	kdtWeigntEntry_carcessReduceWeight_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtWeigntEntry_carcessReduceWeight_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtWeigntEntry_carcessReduceWeight_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtWeigntEntry_carcessReduceWeight_CellEditor = new KDTDefaultCellEditor(kdtWeigntEntry_carcessReduceWeight_TextField);
        this.kdtWeigntEntry.getColumn("carcessReduceWeight").setEditor(kdtWeigntEntry_carcessReduceWeight_CellEditor);
        KDTextField kdtWeigntEntry_entryEemark_TextField = new KDTextField();
        kdtWeigntEntry_entryEemark_TextField.setName("kdtWeigntEntry_entryEemark_TextField");
        kdtWeigntEntry_entryEemark_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtWeigntEntry_entryEemark_CellEditor = new KDTDefaultCellEditor(kdtWeigntEntry_entryEemark_TextField);
        this.kdtWeigntEntry.getColumn("entryEemark").setEditor(kdtWeigntEntry_entryEemark_CellEditor);
        // kdtButcherEntry
		String kdtButcherEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"carcassQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"carcassWeight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"aliveRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"reducedWeight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"customer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"saleChickPrice\" t:width=\"180\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"saleQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"saleAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{carcassQty}</t:Cell><t:Cell>$Resource{carcassWeight}</t:Cell><t:Cell>$Resource{aliveRate}</t:Cell><t:Cell>$Resource{reducedWeight}</t:Cell><t:Cell>$Resource{customer}</t:Cell><t:Cell>$Resource{saleChickPrice}</t:Cell><t:Cell>$Resource{saleQty}</t:Cell><t:Cell>$Resource{saleAmount}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtButcherEntry.setFormatXml(resHelper.translateString("kdtButcherEntry",kdtButcherEntryStrXML));

                this.kdtButcherEntry.putBindContents("editData",new String[] {"seq","carcassQty","carcassWeight","aliveRate","reducedWeight","customer","saleChickPrice","saleQty","saleAmount"});


        this.kdtButcherEntry.checkParsed();
        KDFormattedTextField kdtButcherEntry_carcassQty_TextField = new KDFormattedTextField();
        kdtButcherEntry_carcassQty_TextField.setName("kdtButcherEntry_carcassQty_TextField");
        kdtButcherEntry_carcassQty_TextField.setVisible(true);
        kdtButcherEntry_carcassQty_TextField.setEditable(true);
        kdtButcherEntry_carcassQty_TextField.setHorizontalAlignment(2);
        kdtButcherEntry_carcassQty_TextField.setDataType(1);
        	kdtButcherEntry_carcassQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtButcherEntry_carcassQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtButcherEntry_carcassQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtButcherEntry_carcassQty_CellEditor = new KDTDefaultCellEditor(kdtButcherEntry_carcassQty_TextField);
        this.kdtButcherEntry.getColumn("carcassQty").setEditor(kdtButcherEntry_carcassQty_CellEditor);
        KDFormattedTextField kdtButcherEntry_carcassWeight_TextField = new KDFormattedTextField();
        kdtButcherEntry_carcassWeight_TextField.setName("kdtButcherEntry_carcassWeight_TextField");
        kdtButcherEntry_carcassWeight_TextField.setVisible(true);
        kdtButcherEntry_carcassWeight_TextField.setEditable(true);
        kdtButcherEntry_carcassWeight_TextField.setHorizontalAlignment(2);
        kdtButcherEntry_carcassWeight_TextField.setDataType(1);
        	kdtButcherEntry_carcassWeight_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E25"));
        	kdtButcherEntry_carcassWeight_TextField.setMaximumValue(new java.math.BigDecimal("1.0E25"));
        kdtButcherEntry_carcassWeight_TextField.setPrecision(3);
        KDTDefaultCellEditor kdtButcherEntry_carcassWeight_CellEditor = new KDTDefaultCellEditor(kdtButcherEntry_carcassWeight_TextField);
        this.kdtButcherEntry.getColumn("carcassWeight").setEditor(kdtButcherEntry_carcassWeight_CellEditor);
        KDFormattedTextField kdtButcherEntry_aliveRate_TextField = new KDFormattedTextField();
        kdtButcherEntry_aliveRate_TextField.setName("kdtButcherEntry_aliveRate_TextField");
        kdtButcherEntry_aliveRate_TextField.setVisible(true);
        kdtButcherEntry_aliveRate_TextField.setEditable(true);
        kdtButcherEntry_aliveRate_TextField.setHorizontalAlignment(2);
        kdtButcherEntry_aliveRate_TextField.setDataType(1);
        	kdtButcherEntry_aliveRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E25"));
        	kdtButcherEntry_aliveRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E25"));
        kdtButcherEntry_aliveRate_TextField.setPrecision(3);
        KDTDefaultCellEditor kdtButcherEntry_aliveRate_CellEditor = new KDTDefaultCellEditor(kdtButcherEntry_aliveRate_TextField);
        this.kdtButcherEntry.getColumn("aliveRate").setEditor(kdtButcherEntry_aliveRate_CellEditor);
        KDFormattedTextField kdtButcherEntry_reducedWeight_TextField = new KDFormattedTextField();
        kdtButcherEntry_reducedWeight_TextField.setName("kdtButcherEntry_reducedWeight_TextField");
        kdtButcherEntry_reducedWeight_TextField.setVisible(true);
        kdtButcherEntry_reducedWeight_TextField.setEditable(true);
        kdtButcherEntry_reducedWeight_TextField.setHorizontalAlignment(2);
        kdtButcherEntry_reducedWeight_TextField.setDataType(1);
        	kdtButcherEntry_reducedWeight_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E25"));
        	kdtButcherEntry_reducedWeight_TextField.setMaximumValue(new java.math.BigDecimal("1.0E25"));
        kdtButcherEntry_reducedWeight_TextField.setPrecision(3);
        KDTDefaultCellEditor kdtButcherEntry_reducedWeight_CellEditor = new KDTDefaultCellEditor(kdtButcherEntry_reducedWeight_TextField);
        this.kdtButcherEntry.getColumn("reducedWeight").setEditor(kdtButcherEntry_reducedWeight_CellEditor);
        final KDBizPromptBox kdtButcherEntry_customer_PromptBox = new KDBizPromptBox();
        kdtButcherEntry_customer_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.CustomerInfoQuery");
        kdtButcherEntry_customer_PromptBox.setVisible(true);
        kdtButcherEntry_customer_PromptBox.setEditable(true);
        kdtButcherEntry_customer_PromptBox.setDisplayFormat("$number$");
        kdtButcherEntry_customer_PromptBox.setEditFormat("$number$");
        kdtButcherEntry_customer_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtButcherEntry_customer_CellEditor = new KDTDefaultCellEditor(kdtButcherEntry_customer_PromptBox);
        this.kdtButcherEntry.getColumn("customer").setEditor(kdtButcherEntry_customer_CellEditor);
        ObjectValueRender kdtButcherEntry_customer_OVR = new ObjectValueRender();
        kdtButcherEntry_customer_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtButcherEntry.getColumn("customer").setRenderer(kdtButcherEntry_customer_OVR);
        KDFormattedTextField kdtButcherEntry_saleChickPrice_TextField = new KDFormattedTextField();
        kdtButcherEntry_saleChickPrice_TextField.setName("kdtButcherEntry_saleChickPrice_TextField");
        kdtButcherEntry_saleChickPrice_TextField.setVisible(true);
        kdtButcherEntry_saleChickPrice_TextField.setEditable(true);
        kdtButcherEntry_saleChickPrice_TextField.setHorizontalAlignment(2);
        kdtButcherEntry_saleChickPrice_TextField.setDataType(1);
        	kdtButcherEntry_saleChickPrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E25"));
        	kdtButcherEntry_saleChickPrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E25"));
        kdtButcherEntry_saleChickPrice_TextField.setPrecision(3);
        KDTDefaultCellEditor kdtButcherEntry_saleChickPrice_CellEditor = new KDTDefaultCellEditor(kdtButcherEntry_saleChickPrice_TextField);
        this.kdtButcherEntry.getColumn("saleChickPrice").setEditor(kdtButcherEntry_saleChickPrice_CellEditor);
        KDFormattedTextField kdtButcherEntry_saleQty_TextField = new KDFormattedTextField();
        kdtButcherEntry_saleQty_TextField.setName("kdtButcherEntry_saleQty_TextField");
        kdtButcherEntry_saleQty_TextField.setVisible(true);
        kdtButcherEntry_saleQty_TextField.setEditable(true);
        kdtButcherEntry_saleQty_TextField.setHorizontalAlignment(2);
        kdtButcherEntry_saleQty_TextField.setDataType(1);
        	kdtButcherEntry_saleQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtButcherEntry_saleQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtButcherEntry_saleQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtButcherEntry_saleQty_CellEditor = new KDTDefaultCellEditor(kdtButcherEntry_saleQty_TextField);
        this.kdtButcherEntry.getColumn("saleQty").setEditor(kdtButcherEntry_saleQty_CellEditor);
        KDFormattedTextField kdtButcherEntry_saleAmount_TextField = new KDFormattedTextField();
        kdtButcherEntry_saleAmount_TextField.setName("kdtButcherEntry_saleAmount_TextField");
        kdtButcherEntry_saleAmount_TextField.setVisible(true);
        kdtButcherEntry_saleAmount_TextField.setEditable(true);
        kdtButcherEntry_saleAmount_TextField.setHorizontalAlignment(2);
        kdtButcherEntry_saleAmount_TextField.setDataType(1);
        	kdtButcherEntry_saleAmount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtButcherEntry_saleAmount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtButcherEntry_saleAmount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtButcherEntry_saleAmount_CellEditor = new KDTDefaultCellEditor(kdtButcherEntry_saleAmount_TextField);
        this.kdtButcherEntry.getColumn("saleAmount").setEditor(kdtButcherEntry_saleAmount_CellEditor);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {pkauditTime,prmtfarmer,prmtfarm,prmtbatchContract,prmtbatch,billStatus,prmtsettlePolicy,pkinDate,txtbatchQty,prmtperson,txtfarmAddress,farmType,txtfarmerPhone,prmtbreedData,txtfeedDays,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,prmtFICompany,kdtButcherEntry,kdtWeigntEntry,kdtEntry,chkisManu,chkisSaleOut}));
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
        this.setBounds(new Rectangle(-10, 2, 1228, 605));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(-10, 2, 1228, 605));
        contCreator.setBounds(new Rectangle(412, 538, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(412, 538, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(412, 562, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(412, 562, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(814, 538, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(814, 538, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateTime.setBounds(new Rectangle(814, 562, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(814, 562, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(10, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(325, 10, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(325, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(324, 131, 892, 19));
        this.add(contDescription, new KDLayout.Constraints(324, 131, 892, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(10, 538, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(10, 538, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contFICompany.setBounds(new Rectangle(634, 10, 270, 19));
        this.add(contFICompany, new KDLayout.Constraints(634, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(10, 562, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(10, 562, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmer.setBounds(new Rectangle(948, 40, 270, 19));
        this.add(contfarmer, new KDLayout.Constraints(948, 40, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfarm.setBounds(new Rectangle(10, 66, 270, 19));
        this.add(contfarm, new KDLayout.Constraints(10, 66, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbatchContract.setBounds(new Rectangle(8, 36, 270, 19));
        this.add(contbatchContract, new KDLayout.Constraints(8, 36, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbatch.setBounds(new Rectangle(325, 98, 270, 19));
        this.add(contbatch, new KDLayout.Constraints(325, 98, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(948, 10, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(948, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contsettlePolicy.setBounds(new Rectangle(10, 98, 270, 19));
        this.add(contsettlePolicy, new KDLayout.Constraints(10, 98, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        continDate.setBounds(new Rectangle(634, 98, 270, 19));
        this.add(continDate, new KDLayout.Constraints(634, 98, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbatchQty.setBounds(new Rectangle(948, 98, 270, 19));
        this.add(contbatchQty, new KDLayout.Constraints(948, 98, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator9.setBounds(new Rectangle(10, 514, 1202, 8));
        this.add(kDSeparator9, new KDLayout.Constraints(10, 514, 1202, 8, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contperson.setBounds(new Rectangle(948, 66, 270, 19));
        this.add(contperson, new KDLayout.Constraints(948, 66, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfarmAddress.setBounds(new Rectangle(325, 66, 270, 19));
        this.add(contfarmAddress, new KDLayout.Constraints(325, 66, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmType.setBounds(new Rectangle(634, 66, 270, 19));
        this.add(contfarmType, new KDLayout.Constraints(634, 66, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmerPhone.setBounds(new Rectangle(325, 34, 270, 19));
        this.add(contfarmerPhone, new KDLayout.Constraints(325, 34, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbreedData.setBounds(new Rectangle(634, 34, 270, 19));
        this.add(contbreedData, new KDLayout.Constraints(634, 34, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfeedDays.setBounds(new Rectangle(9, 131, 270, 19));
        this.add(contfeedDays, new KDLayout.Constraints(9, 131, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane1.setBounds(new Rectangle(10, 186, 1158, 321));
        this.add(kDTabbedPane1, new KDLayout.Constraints(10, 186, 1158, 321, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        chkisManu.setBounds(new Rectangle(11, 154, 270, 19));
        this.add(chkisManu, new KDLayout.Constraints(11, 154, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisSaleOut.setBounds(new Rectangle(324, 157, 270, 19));
        this.add(chkisSaleOut, new KDLayout.Constraints(324, 157, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contfarmer
        contfarmer.setBoundEditor(prmtfarmer);
        //contfarm
        contfarm.setBoundEditor(prmtfarm);
        //contbatchContract
        contbatchContract.setBoundEditor(prmtbatchContract);
        //contbatch
        contbatch.setBoundEditor(prmtbatch);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //contsettlePolicy
        contsettlePolicy.setBoundEditor(prmtsettlePolicy);
        //continDate
        continDate.setBoundEditor(pkinDate);
        //contbatchQty
        contbatchQty.setBoundEditor(txtbatchQty);
        //contperson
        contperson.setBoundEditor(prmtperson);
        //contfarmAddress
        contfarmAddress.setBoundEditor(txtfarmAddress);
        //contfarmType
        contfarmType.setBoundEditor(farmType);
        //contfarmerPhone
        contfarmerPhone.setBoundEditor(txtfarmerPhone);
        //contbreedData
        contbreedData.setBoundEditor(prmtbreedData);
        //contfeedDays
        contfeedDays.setBoundEditor(txtfeedDays);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1157, 288));        kdtEntry.setBounds(new Rectangle(2, 0, 1150, 295));
        kdtEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntry,new com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillEntryInfo(),null,false);
        kDPanel1.add(kdtEntry_detailPanel, new KDLayout.Constraints(2, 0, 1150, 295, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1157, 288));        kdtWeigntEntry.setBounds(new Rectangle(1, 2, 1150, 298));
        kdtWeigntEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtWeigntEntry,new com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillWeigntEntryInfo(),null,false);
        kDPanel2.add(kdtWeigntEntry_detailPanel, new KDLayout.Constraints(1, 2, 1150, 298, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtWeigntEntry_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("settlementItem","1");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //kDPanel3
        kDPanel3.setLayout(new KDLayout());
        kDPanel3.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1157, 288));        kdtButcherEntry.setBounds(new Rectangle(0, 0, 1152, 296));
        kdtButcherEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtButcherEntry,new com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillButcherEntryInfo(),null,false);
        kDPanel3.add(kdtButcherEntry_detailPanel, new KDLayout.Constraints(0, 0, 1152, 296, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));

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
        this.toolBar.add(btnCopy);
        this.toolBar.add(btnRemove);
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);
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
        this.toolBar.add(btnDelPCVoucher);
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(btnNextPerson);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("isManu", boolean.class, this.chkisManu, "selected");
		dataBinder.registerBinding("isSaleOut", boolean.class, this.chkisSaleOut, "selected");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("FICompany", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtFICompany, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("farmer", com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo.class, this.prmtfarmer, "data");
		dataBinder.registerBinding("farm", com.kingdee.eas.farm.carnivorous.basedata.FarmInfo.class, this.prmtfarm, "data");
		dataBinder.registerBinding("batchContract", com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo.class, this.prmtbatchContract, "data");
		dataBinder.registerBinding("batch", com.kingdee.eas.farm.carnivorous.basedata.BatchInfo.class, this.prmtbatch, "data");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("settlePolicy", com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo.class, this.prmtsettlePolicy, "data");
		dataBinder.registerBinding("inDate", java.util.Date.class, this.pkinDate, "value");
		dataBinder.registerBinding("batchQty", java.math.BigDecimal.class, this.txtbatchQty, "value");
		dataBinder.registerBinding("person", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtperson, "data");
		dataBinder.registerBinding("farmAddress", String.class, this.txtfarmAddress, "text");
		dataBinder.registerBinding("farmType", com.kingdee.eas.farm.stocking.basedata.FarmsType.class, this.farmType, "selectedItem");
		dataBinder.registerBinding("farmerPhone", String.class, this.txtfarmerPhone, "text");
		dataBinder.registerBinding("breedData", com.kingdee.eas.farm.stocking.basedata.BreedDataInfo.class, this.prmtbreedData, "data");
		dataBinder.registerBinding("feedDays", int.class, this.txtfeedDays, "value");
		dataBinder.registerBinding("Entry.seq", int.class, this.kdtEntry, "seq.text");
		dataBinder.registerBinding("Entry", com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillEntryInfo.class, this.kdtEntry, "userObject");
		dataBinder.registerBinding("Entry.driver", java.lang.Object.class, this.kdtEntry, "driver.text");
		dataBinder.registerBinding("Entry.telephone", String.class, this.kdtEntry, "telephone.text");
		dataBinder.registerBinding("Entry.chickenQty", java.math.BigDecimal.class, this.kdtEntry, "chickenQty.text");
		dataBinder.registerBinding("Entry.car", java.lang.Object.class, this.kdtEntry, "car.text");
		dataBinder.registerBinding("WeigntEntry.seq", int.class, this.kdtWeigntEntry, "seq.text");
		dataBinder.registerBinding("WeigntEntry", com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillWeigntEntryInfo.class, this.kdtWeigntEntry, "userObject");
		dataBinder.registerBinding("WeigntEntry.driver", java.lang.Object.class, this.kdtWeigntEntry, "driver.text");
		dataBinder.registerBinding("WeigntEntry.telephone", String.class, this.kdtWeigntEntry, "telephone.text");
		dataBinder.registerBinding("WeigntEntry.chickenQty", java.math.BigDecimal.class, this.kdtWeigntEntry, "chickenQty.text");
		dataBinder.registerBinding("WeigntEntry.houseWeight", java.math.BigDecimal.class, this.kdtWeigntEntry, "houseWeight.text");
		dataBinder.registerBinding("WeigntEntry.houseSkinWeight", java.math.BigDecimal.class, this.kdtWeigntEntry, "houseSkinWeight.text");
		dataBinder.registerBinding("WeigntEntry.houseNetWeight", String.class, this.kdtWeigntEntry, "houseNetWeight.text");
		dataBinder.registerBinding("WeigntEntry.customer", java.lang.Object.class, this.kdtWeigntEntry, "customer.text");
		dataBinder.registerBinding("WeigntEntry.saleChicPrice", java.math.BigDecimal.class, this.kdtWeigntEntry, "saleChicPrice.text");
		dataBinder.registerBinding("WeigntEntry.saleQty", java.math.BigDecimal.class, this.kdtWeigntEntry, "saleQty.text");
		dataBinder.registerBinding("WeigntEntry.saleAmount", java.math.BigDecimal.class, this.kdtWeigntEntry, "saleAmount.text");
		dataBinder.registerBinding("WeigntEntry.carcar", java.lang.Object.class, this.kdtWeigntEntry, "carcar.text");
		dataBinder.registerBinding("WeigntEntry.carText", String.class, this.kdtWeigntEntry, "carText.text");
		dataBinder.registerBinding("WeigntEntry.driverText", String.class, this.kdtWeigntEntry, "driverText.text");
		dataBinder.registerBinding("WeigntEntry.driverTel", String.class, this.kdtWeigntEntry, "driverTel.text");
		dataBinder.registerBinding("WeigntEntry.settlementItem", com.kingdee.util.enums.Enum.class, this.kdtWeigntEntry, "settlementItem.text");
		dataBinder.registerBinding("WeigntEntry.marketPrice", java.math.BigDecimal.class, this.kdtWeigntEntry, "marketPrice.text");
		dataBinder.registerBinding("WeigntEntry.carcessReduceWeight", java.math.BigDecimal.class, this.kdtWeigntEntry, "carcessReduceWeight.text");
		dataBinder.registerBinding("WeigntEntry.carcass", boolean.class, this.kdtWeigntEntry, "carcass.text");
		dataBinder.registerBinding("WeigntEntry.entryEemark", String.class, this.kdtWeigntEntry, "entryEemark.text");
		dataBinder.registerBinding("WeigntEntry.carleader", String.class, this.kdtWeigntEntry, "carleader.text");
		dataBinder.registerBinding("WeigntEntry.avgWgt", java.math.BigDecimal.class, this.kdtWeigntEntry, "avgWgt.text");
		dataBinder.registerBinding("WeigntEntry.punishAmt", java.math.BigDecimal.class, this.kdtWeigntEntry, "punishAmt.text");
		dataBinder.registerBinding("ButcherEntry.seq", int.class, this.kdtButcherEntry, "seq.text");
		dataBinder.registerBinding("ButcherEntry", com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillButcherEntryInfo.class, this.kdtButcherEntry, "userObject");
		dataBinder.registerBinding("ButcherEntry.carcassQty", java.math.BigDecimal.class, this.kdtButcherEntry, "carcassQty.text");
		dataBinder.registerBinding("ButcherEntry.carcassWeight", java.math.BigDecimal.class, this.kdtButcherEntry, "carcassWeight.text");
		dataBinder.registerBinding("ButcherEntry.reducedWeight", java.math.BigDecimal.class, this.kdtButcherEntry, "reducedWeight.text");
		dataBinder.registerBinding("ButcherEntry.aliveRate", java.math.BigDecimal.class, this.kdtButcherEntry, "aliveRate.text");
		dataBinder.registerBinding("ButcherEntry.customer", java.lang.Object.class, this.kdtButcherEntry, "customer.text");
		dataBinder.registerBinding("ButcherEntry.saleChickPrice", java.math.BigDecimal.class, this.kdtButcherEntry, "saleChickPrice.text");
		dataBinder.registerBinding("ButcherEntry.saleAmount", java.math.BigDecimal.class, this.kdtButcherEntry, "saleAmount.text");
		dataBinder.registerBinding("ButcherEntry.saleQty", java.math.BigDecimal.class, this.kdtButcherEntry, "saleQty.text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.carnivorous.recyclebiz.app.ChickenRecBillEditUIHandler";
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
        this.pkauditTime.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillInfo)ov;
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
	 * ????????У??
	 */
	protected void registerValidator() {
    	getValidateHelper().setCustomValidator( getValidator() );
		getValidateHelper().registerBindProperty("isManu", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isSaleOut", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FICompany", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batchContract", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("settlePolicy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("inDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batchQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("person", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmAddress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmerPhone", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedData", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("feedDays", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.driver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.telephone", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.chickenQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.car", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("WeigntEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("WeigntEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("WeigntEntry.driver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("WeigntEntry.telephone", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("WeigntEntry.chickenQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("WeigntEntry.houseWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("WeigntEntry.houseSkinWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("WeigntEntry.houseNetWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("WeigntEntry.customer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("WeigntEntry.saleChicPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("WeigntEntry.saleQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("WeigntEntry.saleAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("WeigntEntry.carcar", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("WeigntEntry.carText", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("WeigntEntry.driverText", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("WeigntEntry.driverTel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("WeigntEntry.settlementItem", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("WeigntEntry.marketPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("WeigntEntry.carcessReduceWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("WeigntEntry.carcass", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("WeigntEntry.entryEemark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("WeigntEntry.carleader", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("WeigntEntry.avgWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("WeigntEntry.punishAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ButcherEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ButcherEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ButcherEntry.carcassQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ButcherEntry.carcassWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ButcherEntry.reducedWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ButcherEntry.aliveRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ButcherEntry.customer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ButcherEntry.saleChickPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ButcherEntry.saleAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ButcherEntry.saleQty", ValidateHelper.ON_SAVE);    		
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
     * output prmtfarmer_Changed() method
     */
    public void prmtfarmer_Changed() throws Exception
    {
        System.out.println("prmtfarmer_Changed() Function is executed!");
            txtfarmerPhone.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtfarmer.getData(),"mobileTel")));


    }

    /**
     * output prmtfarm_Changed() method
     */
    public void prmtfarm_Changed() throws Exception
    {
        System.out.println("prmtfarm_Changed() Function is executed!");
            txtfarmAddress.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtfarm.getData(),"address")));

    farmType.setSelectedItem(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtfarm.getData(),"faemsType"));


    }

    /**
     * output kdtEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("driver".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"telephone").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntry.getCell(rowIndex,"driver").getValue(),"driverphone")));

}


    }

    /**
     * output kdtWeigntEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtWeigntEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("carcar".equalsIgnoreCase(kdtWeigntEntry.getColumn(colIndex).getKey())) {
kdtWeigntEntry.getCell(rowIndex,"carleader").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtWeigntEntry.getCell(rowIndex,"carcar").getValue(),"carOwner")));

}

    if ("driver".equalsIgnoreCase(kdtWeigntEntry.getColumn(colIndex).getKey())) {
kdtWeigntEntry.getCell(rowIndex,"telephone").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtWeigntEntry.getCell(rowIndex,"driver").getValue(),"driverphone")));

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
        sic.add(new SelectorItemInfo("isManu"));
        sic.add(new SelectorItemInfo("isSaleOut"));
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
        sic.add(new SelectorItemInfo("auditTime"));
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
			sic.add(new SelectorItemInfo("farm.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farm.id"));
        	sic.add(new SelectorItemInfo("farm.number"));
        	sic.add(new SelectorItemInfo("farm.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("batchContract.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("batchContract.id"));
        	sic.add(new SelectorItemInfo("batchContract.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("batch.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("batch.id"));
        	sic.add(new SelectorItemInfo("batch.number"));
        	sic.add(new SelectorItemInfo("batch.name"));
		}
        sic.add(new SelectorItemInfo("billStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("settlePolicy.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("settlePolicy.id"));
        	sic.add(new SelectorItemInfo("settlePolicy.number"));
        	sic.add(new SelectorItemInfo("settlePolicy.name"));
		}
        sic.add(new SelectorItemInfo("inDate"));
        sic.add(new SelectorItemInfo("batchQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("person.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("person.id"));
        	sic.add(new SelectorItemInfo("person.number"));
        	sic.add(new SelectorItemInfo("person.name"));
		}
        sic.add(new SelectorItemInfo("farmAddress"));
        sic.add(new SelectorItemInfo("farmType"));
        sic.add(new SelectorItemInfo("farmerPhone"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("breedData.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("breedData.id"));
        	sic.add(new SelectorItemInfo("breedData.number"));
        	sic.add(new SelectorItemInfo("breedData.name"));
		}
        sic.add(new SelectorItemInfo("feedDays"));
    	sic.add(new SelectorItemInfo("Entry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.driver.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entry.driver.id"));
			sic.add(new SelectorItemInfo("Entry.driver.drivername"));
			sic.add(new SelectorItemInfo("Entry.driver.name"));
        	sic.add(new SelectorItemInfo("Entry.driver.number"));
		}
    	sic.add(new SelectorItemInfo("Entry.telephone"));
    	sic.add(new SelectorItemInfo("Entry.chickenQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.car.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entry.car.id"));
			sic.add(new SelectorItemInfo("Entry.car.number"));
			sic.add(new SelectorItemInfo("Entry.car.name"));
		}
    	sic.add(new SelectorItemInfo("WeigntEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("WeigntEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("WeigntEntry.driver.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("WeigntEntry.driver.id"));
			sic.add(new SelectorItemInfo("WeigntEntry.driver.drivername"));
			sic.add(new SelectorItemInfo("WeigntEntry.driver.name"));
        	sic.add(new SelectorItemInfo("WeigntEntry.driver.number"));
		}
    	sic.add(new SelectorItemInfo("WeigntEntry.telephone"));
    	sic.add(new SelectorItemInfo("WeigntEntry.chickenQty"));
    	sic.add(new SelectorItemInfo("WeigntEntry.houseWeight"));
    	sic.add(new SelectorItemInfo("WeigntEntry.houseSkinWeight"));
    	sic.add(new SelectorItemInfo("WeigntEntry.houseNetWeight"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("WeigntEntry.customer.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("WeigntEntry.customer.id"));
			sic.add(new SelectorItemInfo("WeigntEntry.customer.name"));
        	sic.add(new SelectorItemInfo("WeigntEntry.customer.number"));
		}
    	sic.add(new SelectorItemInfo("WeigntEntry.saleChicPrice"));
    	sic.add(new SelectorItemInfo("WeigntEntry.saleQty"));
    	sic.add(new SelectorItemInfo("WeigntEntry.saleAmount"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("WeigntEntry.carcar.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("WeigntEntry.carcar.id"));
			sic.add(new SelectorItemInfo("WeigntEntry.carcar.number"));
			sic.add(new SelectorItemInfo("WeigntEntry.carcar.name"));
		}
    	sic.add(new SelectorItemInfo("WeigntEntry.carText"));
    	sic.add(new SelectorItemInfo("WeigntEntry.driverText"));
    	sic.add(new SelectorItemInfo("WeigntEntry.driverTel"));
    	sic.add(new SelectorItemInfo("WeigntEntry.settlementItem"));
    	sic.add(new SelectorItemInfo("WeigntEntry.marketPrice"));
    	sic.add(new SelectorItemInfo("WeigntEntry.carcessReduceWeight"));
    	sic.add(new SelectorItemInfo("WeigntEntry.carcass"));
    	sic.add(new SelectorItemInfo("WeigntEntry.entryEemark"));
    	sic.add(new SelectorItemInfo("WeigntEntry.carleader"));
    	sic.add(new SelectorItemInfo("WeigntEntry.avgWgt"));
    	sic.add(new SelectorItemInfo("WeigntEntry.punishAmt"));
    	sic.add(new SelectorItemInfo("ButcherEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ButcherEntry.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("ButcherEntry.carcassQty"));
    	sic.add(new SelectorItemInfo("ButcherEntry.carcassWeight"));
    	sic.add(new SelectorItemInfo("ButcherEntry.reducedWeight"));
    	sic.add(new SelectorItemInfo("ButcherEntry.aliveRate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ButcherEntry.customer.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("ButcherEntry.customer.id"));
			sic.add(new SelectorItemInfo("ButcherEntry.customer.name"));
        	sic.add(new SelectorItemInfo("ButcherEntry.customer.number"));
		}
    	sic.add(new SelectorItemInfo("ButcherEntry.saleChickPrice"));
    	sic.add(new SelectorItemInfo("ButcherEntry.saleAmount"));
    	sic.add(new SelectorItemInfo("ButcherEntry.saleQty"));
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
        com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractChickenRecBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractChickenRecBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.recyclebiz.client", "ChickenRecBillEditUI");
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
        return com.kingdee.eas.farm.carnivorous.recyclebiz.client.ChickenRecBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillInfo();
				if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")).getBoolean("isBizUnit"))
			objectValue.put("FICompany",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")));
 
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/carnivorous/recyclebiz/ChickenRecBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.carnivorous.recyclebiz.app.ChickenRecBillQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtNumber.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"单据编号"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtfarmer.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖户"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtfarm.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖场"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtbatchContract.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"批次合同"});
		}
		for (int i=0,n=kdtWeigntEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtWeigntEntry.getCell(i,"settlementItem").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"结算类型"});
			}
		}
		for (int i=0,n=kdtWeigntEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtWeigntEntry.getCell(i,"marketPrice").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"市场价"});
			}
		}
		for (int i=0,n=kdtWeigntEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtWeigntEntry.getCell(i,"customer").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"销售客户"});
			}
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtEntry;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("billStatus",new Integer(-1));
vo.put("farmType","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}        
				protected void setTableToSumField() {
			setTableToSumField(kdtWeigntEntry,new String[] {"chickenQty","houseWeight","houseSkinWeight","saleQty","saleAmount","carcessReduceWeight"});
		}


}