/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.feedbiz.client;

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
public abstract class AbstractCTransDrugBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCTransDrugBillEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator9;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatch;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttargetFarmer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttargetFarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttargetBatchContract;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttargetBatch;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcar;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatchContract;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdriver;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator10;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedData;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttargetBreedData;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttargetIndate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatchQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttargetBatchQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttargetPerson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continCostCenter;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoutCostCenter;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstorageOrgUnit;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarm;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbatch;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmttargetFarmer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmttargetFarm;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmttargetBatchContract;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmttargetBatch;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcar;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbatchContract;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtdriver;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbreedData;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmttargetBreedData;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkinDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pktargetIndate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbatchQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttargetBatchQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperson;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmttargetPerson;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtinCostCenter;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtoutCostCenter;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDSeparator newSeparator3;
    protected com.kingdee.eas.farm.carnivorous.feedbiz.CTransDrugBillInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractCTransDrugBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCTransDrugBillEditUI.class.getName());
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
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDSeparator9 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contstorageOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbatch = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttargetFarmer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttargetFarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttargetBatchContract = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttargetBatch = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcar = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbatchContract = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdriver = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator10 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contbreedData = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttargetBreedData = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttargetIndate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbatchQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttargetBatchQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttargetPerson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continCostCenter = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoutCostCenter = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtstorageOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtfarmer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtfarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbatch = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmttargetFarmer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmttargetFarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmttargetBatchContract = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmttargetBatch = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcar = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbatchContract = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtdriver = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbreedData = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmttargetBreedData = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkinDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pktargetIndate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtbatchQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttargetBatchQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtperson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmttargetPerson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtinCostCenter = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtoutCostCenter = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
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
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.contbillStatus.setName("contbillStatus");
        this.contcompany.setName("contcompany");
        this.contauditTime.setName("contauditTime");
        this.kDSeparator8.setName("kDSeparator8");
        this.kDSeparator9.setName("kDSeparator9");
        this.kdtEntrys.setName("kdtEntrys");
        this.contstorageOrgUnit.setName("contstorageOrgUnit");
        this.contfarmer.setName("contfarmer");
        this.contfarm.setName("contfarm");
        this.contbatch.setName("contbatch");
        this.conttargetFarmer.setName("conttargetFarmer");
        this.conttargetFarm.setName("conttargetFarm");
        this.conttargetBatchContract.setName("conttargetBatchContract");
        this.conttargetBatch.setName("conttargetBatch");
        this.contcar.setName("contcar");
        this.contbatchContract.setName("contbatchContract");
        this.contdriver.setName("contdriver");
        this.kDSeparator10.setName("kDSeparator10");
        this.contbreedData.setName("contbreedData");
        this.conttargetBreedData.setName("conttargetBreedData");
        this.continDate.setName("continDate");
        this.conttargetIndate.setName("conttargetIndate");
        this.contbatchQty.setName("contbatchQty");
        this.conttargetBatchQty.setName("conttargetBatchQty");
        this.contperson.setName("contperson");
        this.conttargetPerson.setName("conttargetPerson");
        this.continCostCenter.setName("continCostCenter");
        this.contoutCostCenter.setName("contoutCostCenter");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.billStatus.setName("billStatus");
        this.prmtcompany.setName("prmtcompany");
        this.pkauditTime.setName("pkauditTime");
        this.prmtstorageOrgUnit.setName("prmtstorageOrgUnit");
        this.prmtfarmer.setName("prmtfarmer");
        this.prmtfarm.setName("prmtfarm");
        this.prmtbatch.setName("prmtbatch");
        this.prmttargetFarmer.setName("prmttargetFarmer");
        this.prmttargetFarm.setName("prmttargetFarm");
        this.prmttargetBatchContract.setName("prmttargetBatchContract");
        this.prmttargetBatch.setName("prmttargetBatch");
        this.prmtcar.setName("prmtcar");
        this.prmtbatchContract.setName("prmtbatchContract");
        this.prmtdriver.setName("prmtdriver");
        this.prmtbreedData.setName("prmtbreedData");
        this.prmttargetBreedData.setName("prmttargetBreedData");
        this.pkinDate.setName("pkinDate");
        this.pktargetIndate.setName("pktargetIndate");
        this.txtbatchQty.setName("txtbatchQty");
        this.txttargetBatchQty.setName("txttargetBatchQty");
        this.prmtperson.setName("prmtperson");
        this.prmttargetPerson.setName("prmttargetPerson");
        this.prmtinCostCenter.setName("prmtinCostCenter");
        this.prmtoutCostCenter.setName("prmtoutCostCenter");
        this.tBtnAudit.setName("tBtnAudit");
        this.tBtnUnAudit.setName("tBtnUnAudit");
        this.mBtnAudit.setName("mBtnAudit");
        this.mBtnUnAudit.setName("mBtnUnAudit");
        this.newSeparator3.setName("newSeparator3");
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
        // contbillStatus		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);
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
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"materialName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"transQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"7\" t:styleID=\"sCol5\" /><t:Column t:key=\"basePrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" t:styleID=\"sCol6\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"9\" t:styleID=\"sCol7\" /><t:Column t:key=\"warehouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"10\" /><t:Column t:key=\"orderBasePrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"11\" t:styleID=\"sCol9\" /><t:Column t:key=\"orderAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"12\" t:styleID=\"sCol10\" /><t:Column t:key=\"orderWarehouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"13\" /><t:Column t:key=\"batchLot\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{model}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{transQty}</t:Cell><t:Cell>$Resource{basePrice}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{warehouse}</t:Cell><t:Cell>$Resource{orderBasePrice}</t:Cell><t:Cell>$Resource{orderAmount}</t:Cell><t:Cell>$Resource{orderWarehouse}</t:Cell><t:Cell>$Resource{batchLot}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtEntrys.putBindContents("editData",new String[] {"id","material","materialName","model","unit","transQty","basePrice","amount","warehouse","orderBasePrice","orderAmount","orderWarehouse","batchLot"});


        this.kdtEntrys.checkParsed();
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
        kdtEntrys_material_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("material").setRenderer(kdtEntrys_material_OVR);
        KDTextField kdtEntrys_materialName_TextField = new KDTextField();
        kdtEntrys_materialName_TextField.setName("kdtEntrys_materialName_TextField");
        kdtEntrys_materialName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_materialName_CellEditor = new KDTDefaultCellEditor(kdtEntrys_materialName_TextField);
        this.kdtEntrys.getColumn("materialName").setEditor(kdtEntrys_materialName_CellEditor);
        KDTextField kdtEntrys_model_TextField = new KDTextField();
        kdtEntrys_model_TextField.setName("kdtEntrys_model_TextField");
        kdtEntrys_model_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntrys_model_CellEditor = new KDTDefaultCellEditor(kdtEntrys_model_TextField);
        this.kdtEntrys.getColumn("model").setEditor(kdtEntrys_model_CellEditor);
        final KDBizPromptBox kdtEntrys_unit_PromptBox = new KDBizPromptBox();
        kdtEntrys_unit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtEntrys_unit_PromptBox.setVisible(true);
        kdtEntrys_unit_PromptBox.setEditable(true);
        kdtEntrys_unit_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_unit_PromptBox.setEditFormat("$number$");
        kdtEntrys_unit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_unit_CellEditor = new KDTDefaultCellEditor(kdtEntrys_unit_PromptBox);
        this.kdtEntrys.getColumn("unit").setEditor(kdtEntrys_unit_CellEditor);
        ObjectValueRender kdtEntrys_unit_OVR = new ObjectValueRender();
        kdtEntrys_unit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("unit").setRenderer(kdtEntrys_unit_OVR);
        KDFormattedTextField kdtEntrys_transQty_TextField = new KDFormattedTextField();
        kdtEntrys_transQty_TextField.setName("kdtEntrys_transQty_TextField");
        kdtEntrys_transQty_TextField.setVisible(true);
        kdtEntrys_transQty_TextField.setEditable(true);
        kdtEntrys_transQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_transQty_TextField.setDataType(1);
        	kdtEntrys_transQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_transQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_transQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_transQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_transQty_TextField);
        this.kdtEntrys.getColumn("transQty").setEditor(kdtEntrys_transQty_CellEditor);
        KDFormattedTextField kdtEntrys_basePrice_TextField = new KDFormattedTextField();
        kdtEntrys_basePrice_TextField.setName("kdtEntrys_basePrice_TextField");
        kdtEntrys_basePrice_TextField.setVisible(true);
        kdtEntrys_basePrice_TextField.setEditable(true);
        kdtEntrys_basePrice_TextField.setHorizontalAlignment(2);
        kdtEntrys_basePrice_TextField.setDataType(1);
        	kdtEntrys_basePrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_basePrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_basePrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_basePrice_CellEditor = new KDTDefaultCellEditor(kdtEntrys_basePrice_TextField);
        this.kdtEntrys.getColumn("basePrice").setEditor(kdtEntrys_basePrice_CellEditor);
        KDFormattedTextField kdtEntrys_amount_TextField = new KDFormattedTextField();
        kdtEntrys_amount_TextField.setName("kdtEntrys_amount_TextField");
        kdtEntrys_amount_TextField.setVisible(true);
        kdtEntrys_amount_TextField.setEditable(true);
        kdtEntrys_amount_TextField.setHorizontalAlignment(2);
        kdtEntrys_amount_TextField.setDataType(1);
        	kdtEntrys_amount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_amount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_amount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_amount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_amount_TextField);
        this.kdtEntrys.getColumn("amount").setEditor(kdtEntrys_amount_CellEditor);
        final KDBizPromptBox kdtEntrys_warehouse_PromptBox = new KDBizPromptBox();
        kdtEntrys_warehouse_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7AllWarehouseQuery");
        kdtEntrys_warehouse_PromptBox.setVisible(true);
        kdtEntrys_warehouse_PromptBox.setEditable(true);
        kdtEntrys_warehouse_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_warehouse_PromptBox.setEditFormat("$number$");
        kdtEntrys_warehouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_warehouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_warehouse_PromptBox);
        this.kdtEntrys.getColumn("warehouse").setEditor(kdtEntrys_warehouse_CellEditor);
        ObjectValueRender kdtEntrys_warehouse_OVR = new ObjectValueRender();
        kdtEntrys_warehouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("warehouse").setRenderer(kdtEntrys_warehouse_OVR);
        KDFormattedTextField kdtEntrys_orderBasePrice_TextField = new KDFormattedTextField();
        kdtEntrys_orderBasePrice_TextField.setName("kdtEntrys_orderBasePrice_TextField");
        kdtEntrys_orderBasePrice_TextField.setVisible(true);
        kdtEntrys_orderBasePrice_TextField.setEditable(true);
        kdtEntrys_orderBasePrice_TextField.setHorizontalAlignment(2);
        kdtEntrys_orderBasePrice_TextField.setDataType(1);
        	kdtEntrys_orderBasePrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_orderBasePrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_orderBasePrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_orderBasePrice_CellEditor = new KDTDefaultCellEditor(kdtEntrys_orderBasePrice_TextField);
        this.kdtEntrys.getColumn("orderBasePrice").setEditor(kdtEntrys_orderBasePrice_CellEditor);
        KDFormattedTextField kdtEntrys_orderAmount_TextField = new KDFormattedTextField();
        kdtEntrys_orderAmount_TextField.setName("kdtEntrys_orderAmount_TextField");
        kdtEntrys_orderAmount_TextField.setVisible(true);
        kdtEntrys_orderAmount_TextField.setEditable(true);
        kdtEntrys_orderAmount_TextField.setHorizontalAlignment(2);
        kdtEntrys_orderAmount_TextField.setDataType(1);
        	kdtEntrys_orderAmount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_orderAmount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_orderAmount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_orderAmount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_orderAmount_TextField);
        this.kdtEntrys.getColumn("orderAmount").setEditor(kdtEntrys_orderAmount_CellEditor);
        final KDBizPromptBox kdtEntrys_orderWarehouse_PromptBox = new KDBizPromptBox();
        kdtEntrys_orderWarehouse_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7AllWarehouseQuery");
        kdtEntrys_orderWarehouse_PromptBox.setVisible(true);
        kdtEntrys_orderWarehouse_PromptBox.setEditable(true);
        kdtEntrys_orderWarehouse_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_orderWarehouse_PromptBox.setEditFormat("$number$");
        kdtEntrys_orderWarehouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_orderWarehouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_orderWarehouse_PromptBox);
        this.kdtEntrys.getColumn("orderWarehouse").setEditor(kdtEntrys_orderWarehouse_CellEditor);
        ObjectValueRender kdtEntrys_orderWarehouse_OVR = new ObjectValueRender();
        kdtEntrys_orderWarehouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("orderWarehouse").setRenderer(kdtEntrys_orderWarehouse_OVR);
        KDTextField kdtEntrys_batchLot_TextField = new KDTextField();
        kdtEntrys_batchLot_TextField.setName("kdtEntrys_batchLot_TextField");
        kdtEntrys_batchLot_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntrys_batchLot_CellEditor = new KDTDefaultCellEditor(kdtEntrys_batchLot_TextField);
        this.kdtEntrys.getColumn("batchLot").setEditor(kdtEntrys_batchLot_CellEditor);
        // contstorageOrgUnit		
        this.contstorageOrgUnit.setBoundLabelText(resHelper.getString("contstorageOrgUnit.boundLabelText"));		
        this.contstorageOrgUnit.setBoundLabelLength(100);		
        this.contstorageOrgUnit.setBoundLabelUnderline(true);		
        this.contstorageOrgUnit.setVisible(true);
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
        // contbatch		
        this.contbatch.setBoundLabelText(resHelper.getString("contbatch.boundLabelText"));		
        this.contbatch.setBoundLabelLength(100);		
        this.contbatch.setBoundLabelUnderline(true);		
        this.contbatch.setVisible(true);
        // conttargetFarmer		
        this.conttargetFarmer.setBoundLabelText(resHelper.getString("conttargetFarmer.boundLabelText"));		
        this.conttargetFarmer.setBoundLabelLength(100);		
        this.conttargetFarmer.setBoundLabelUnderline(true);		
        this.conttargetFarmer.setVisible(true);
        // conttargetFarm		
        this.conttargetFarm.setBoundLabelText(resHelper.getString("conttargetFarm.boundLabelText"));		
        this.conttargetFarm.setBoundLabelLength(100);		
        this.conttargetFarm.setBoundLabelUnderline(true);		
        this.conttargetFarm.setVisible(true);
        // conttargetBatchContract		
        this.conttargetBatchContract.setBoundLabelText(resHelper.getString("conttargetBatchContract.boundLabelText"));		
        this.conttargetBatchContract.setBoundLabelLength(100);		
        this.conttargetBatchContract.setBoundLabelUnderline(true);		
        this.conttargetBatchContract.setVisible(true);
        // conttargetBatch		
        this.conttargetBatch.setBoundLabelText(resHelper.getString("conttargetBatch.boundLabelText"));		
        this.conttargetBatch.setBoundLabelLength(100);		
        this.conttargetBatch.setBoundLabelUnderline(true);		
        this.conttargetBatch.setVisible(true);
        // contcar		
        this.contcar.setBoundLabelText(resHelper.getString("contcar.boundLabelText"));		
        this.contcar.setBoundLabelLength(100);		
        this.contcar.setBoundLabelUnderline(true);		
        this.contcar.setVisible(true);
        // contbatchContract		
        this.contbatchContract.setBoundLabelText(resHelper.getString("contbatchContract.boundLabelText"));		
        this.contbatchContract.setBoundLabelLength(100);		
        this.contbatchContract.setBoundLabelUnderline(true);		
        this.contbatchContract.setVisible(true);
        // contdriver		
        this.contdriver.setBoundLabelText(resHelper.getString("contdriver.boundLabelText"));		
        this.contdriver.setBoundLabelLength(100);		
        this.contdriver.setBoundLabelUnderline(true);		
        this.contdriver.setVisible(true);
        // kDSeparator10
        // contbreedData		
        this.contbreedData.setBoundLabelText(resHelper.getString("contbreedData.boundLabelText"));		
        this.contbreedData.setBoundLabelLength(100);		
        this.contbreedData.setBoundLabelUnderline(true);		
        this.contbreedData.setVisible(true);
        // conttargetBreedData		
        this.conttargetBreedData.setBoundLabelText(resHelper.getString("conttargetBreedData.boundLabelText"));		
        this.conttargetBreedData.setBoundLabelLength(100);		
        this.conttargetBreedData.setBoundLabelUnderline(true);		
        this.conttargetBreedData.setVisible(true);
        // continDate		
        this.continDate.setBoundLabelText(resHelper.getString("continDate.boundLabelText"));		
        this.continDate.setBoundLabelLength(100);		
        this.continDate.setBoundLabelUnderline(true);		
        this.continDate.setVisible(true);
        // conttargetIndate		
        this.conttargetIndate.setBoundLabelText(resHelper.getString("conttargetIndate.boundLabelText"));		
        this.conttargetIndate.setBoundLabelLength(100);		
        this.conttargetIndate.setBoundLabelUnderline(true);		
        this.conttargetIndate.setVisible(true);
        // contbatchQty		
        this.contbatchQty.setBoundLabelText(resHelper.getString("contbatchQty.boundLabelText"));		
        this.contbatchQty.setBoundLabelLength(100);		
        this.contbatchQty.setBoundLabelUnderline(true);		
        this.contbatchQty.setVisible(true);
        // conttargetBatchQty		
        this.conttargetBatchQty.setBoundLabelText(resHelper.getString("conttargetBatchQty.boundLabelText"));		
        this.conttargetBatchQty.setBoundLabelLength(100);		
        this.conttargetBatchQty.setBoundLabelUnderline(true);		
        this.conttargetBatchQty.setVisible(true);
        // contperson		
        this.contperson.setBoundLabelText(resHelper.getString("contperson.boundLabelText"));		
        this.contperson.setBoundLabelLength(100);		
        this.contperson.setBoundLabelUnderline(true);		
        this.contperson.setVisible(true);
        // conttargetPerson		
        this.conttargetPerson.setBoundLabelText(resHelper.getString("conttargetPerson.boundLabelText"));		
        this.conttargetPerson.setBoundLabelLength(100);		
        this.conttargetPerson.setBoundLabelUnderline(true);		
        this.conttargetPerson.setVisible(true);
        // continCostCenter		
        this.continCostCenter.setBoundLabelText(resHelper.getString("continCostCenter.boundLabelText"));		
        this.continCostCenter.setBoundLabelLength(100);		
        this.continCostCenter.setBoundLabelUnderline(true);		
        this.continCostCenter.setVisible(true);
        // contoutCostCenter		
        this.contoutCostCenter.setBoundLabelText(resHelper.getString("contoutCostCenter.boundLabelText"));		
        this.contoutCostCenter.setBoundLabelLength(100);		
        this.contoutCostCenter.setBoundLabelUnderline(true);		
        this.contoutCostCenter.setVisible(true);
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
        // billStatus		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
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
        // prmtstorageOrgUnit		
        this.prmtstorageOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtstorageOrgUnit.setEditable(true);		
        this.prmtstorageOrgUnit.setDisplayFormat("$name$");		
        this.prmtstorageOrgUnit.setEditFormat("$number$");		
        this.prmtstorageOrgUnit.setCommitFormat("$number$");		
        this.prmtstorageOrgUnit.setRequired(true);
        // prmtfarmer		
        this.prmtfarmer.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerQuery");		
        this.prmtfarmer.setVisible(true);		
        this.prmtfarmer.setEditable(true);		
        this.prmtfarmer.setDisplayFormat("$name$");		
        this.prmtfarmer.setEditFormat("$number$");		
        this.prmtfarmer.setCommitFormat("$number$");		
        this.prmtfarmer.setRequired(false);
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
					
        // prmtfarm		
        this.prmtfarm.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmQuery");		
        this.prmtfarm.setVisible(true);		
        this.prmtfarm.setEditable(true);		
        this.prmtfarm.setDisplayFormat("$name$");		
        this.prmtfarm.setEditFormat("$number$");		
        this.prmtfarm.setCommitFormat("$number$");		
        this.prmtfarm.setRequired(false);
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
					
        // prmtbatch		
        this.prmtbatch.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.BatchQuery");		
        this.prmtbatch.setVisible(true);		
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
					
        // prmttargetFarmer		
        this.prmttargetFarmer.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerQuery");		
        this.prmttargetFarmer.setVisible(true);		
        this.prmttargetFarmer.setEditable(true);		
        this.prmttargetFarmer.setDisplayFormat("$name$");		
        this.prmttargetFarmer.setEditFormat("$number$");		
        this.prmttargetFarmer.setCommitFormat("$number$");		
        this.prmttargetFarmer.setRequired(false);
        		prmttargetFarmer.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.FarmerListUI prmttargetFarmer_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmttargetFarmer_F7ListUI == null) {
					try {
						prmttargetFarmer_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.FarmerListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmttargetFarmer_F7ListUI));
					prmttargetFarmer_F7ListUI.setF7Use(true,ctx);
					prmttargetFarmer.setSelector(prmttargetFarmer_F7ListUI);
				}
			}
		});
					
        // prmttargetFarm		
        this.prmttargetFarm.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmQuery");		
        this.prmttargetFarm.setVisible(true);		
        this.prmttargetFarm.setEditable(true);		
        this.prmttargetFarm.setDisplayFormat("$name$");		
        this.prmttargetFarm.setEditFormat("$number$");		
        this.prmttargetFarm.setCommitFormat("$number$");		
        this.prmttargetFarm.setRequired(false);
        		prmttargetFarm.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.FarmListUI prmttargetFarm_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmttargetFarm_F7ListUI == null) {
					try {
						prmttargetFarm_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.FarmListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmttargetFarm_F7ListUI));
					prmttargetFarm_F7ListUI.setF7Use(true,ctx);
					prmttargetFarm.setSelector(prmttargetFarm_F7ListUI);
				}
			}
		});
					
        // prmttargetBatchContract		
        this.prmttargetBatchContract.setQueryInfo("com.kingdee.eas.farm.carnivorous.feedbiz.app.BatchContractBillQuery");		
        this.prmttargetBatchContract.setVisible(true);		
        this.prmttargetBatchContract.setEditable(true);		
        this.prmttargetBatchContract.setDisplayFormat("$number$");		
        this.prmttargetBatchContract.setEditFormat("$number$");		
        this.prmttargetBatchContract.setCommitFormat("$number$");		
        this.prmttargetBatchContract.setRequired(false);
        // prmttargetBatch		
        this.prmttargetBatch.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.BatchQuery");		
        this.prmttargetBatch.setVisible(true);		
        this.prmttargetBatch.setEditable(true);		
        this.prmttargetBatch.setDisplayFormat("$name$");		
        this.prmttargetBatch.setEditFormat("$number$");		
        this.prmttargetBatch.setCommitFormat("$number$");		
        this.prmttargetBatch.setRequired(false);		
        this.prmttargetBatch.setEnabled(false);
        		prmttargetBatch.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.BatchListUI prmttargetBatch_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmttargetBatch_F7ListUI == null) {
					try {
						prmttargetBatch_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.BatchListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmttargetBatch_F7ListUI));
					prmttargetBatch_F7ListUI.setF7Use(true,ctx);
					prmttargetBatch.setSelector(prmttargetBatch_F7ListUI);
				}
			}
		});
					
        // prmtcar		
        this.prmtcar.setQueryInfo("com.kingdee.eas.publicdata.app.CarQuery");		
        this.prmtcar.setVisible(true);		
        this.prmtcar.setEditable(true);		
        this.prmtcar.setDisplayFormat("$number$");		
        this.prmtcar.setEditFormat("$number$");		
        this.prmtcar.setCommitFormat("$number$");		
        this.prmtcar.setRequired(false);
        		prmtcar.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.CarListUI prmtcar_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtcar_F7ListUI == null) {
					try {
						prmtcar_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.CarListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtcar_F7ListUI));
					prmtcar_F7ListUI.setF7Use(true,ctx);
					prmtcar.setSelector(prmtcar_F7ListUI);
				}
			}
		});
					
        // prmtbatchContract		
        this.prmtbatchContract.setQueryInfo("com.kingdee.eas.farm.carnivorous.feedbiz.app.BatchContractBillQuery");		
        this.prmtbatchContract.setVisible(true);		
        this.prmtbatchContract.setEditable(true);		
        this.prmtbatchContract.setDisplayFormat("$number$");		
        this.prmtbatchContract.setEditFormat("$number$");		
        this.prmtbatchContract.setCommitFormat("$number$");		
        this.prmtbatchContract.setRequired(false);
        // prmtdriver		
        this.prmtdriver.setQueryInfo("com.kingdee.eas.farm.feemanager.basedata.app.DriverQuery");		
        this.prmtdriver.setVisible(true);		
        this.prmtdriver.setEditable(true);		
        this.prmtdriver.setDisplayFormat("$drivername$");		
        this.prmtdriver.setEditFormat("$number$");		
        this.prmtdriver.setCommitFormat("$number$");		
        this.prmtdriver.setRequired(false);
        		prmtdriver.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI prmtdriver_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtdriver_F7ListUI == null) {
					try {
						prmtdriver_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtdriver_F7ListUI));
					prmtdriver_F7ListUI.setF7Use(true,ctx);
					prmtdriver.setSelector(prmtdriver_F7ListUI);
				}
			}
		});
					
        // prmtbreedData		
        this.prmtbreedData.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.BreedDataQuery");		
        this.prmtbreedData.setVisible(true);		
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
					
        // prmttargetBreedData		
        this.prmttargetBreedData.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.BreedDataQuery");		
        this.prmttargetBreedData.setVisible(true);		
        this.prmttargetBreedData.setEditable(true);		
        this.prmttargetBreedData.setDisplayFormat("$name$");		
        this.prmttargetBreedData.setEditFormat("$number$");		
        this.prmttargetBreedData.setCommitFormat("$number$");		
        this.prmttargetBreedData.setRequired(false);		
        this.prmttargetBreedData.setEnabled(false);
        		prmttargetBreedData.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI prmttargetBreedData_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmttargetBreedData_F7ListUI == null) {
					try {
						prmttargetBreedData_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmttargetBreedData_F7ListUI));
					prmttargetBreedData_F7ListUI.setF7Use(true,ctx);
					prmttargetBreedData.setSelector(prmttargetBreedData_F7ListUI);
				}
			}
		});
					
        // pkinDate		
        this.pkinDate.setVisible(true);		
        this.pkinDate.setRequired(false);		
        this.pkinDate.setEnabled(false);
        // pktargetIndate		
        this.pktargetIndate.setVisible(true);		
        this.pktargetIndate.setRequired(false);		
        this.pktargetIndate.setEnabled(false);
        // txtbatchQty		
        this.txtbatchQty.setVisible(true);		
        this.txtbatchQty.setHorizontalAlignment(2);		
        this.txtbatchQty.setDataType(1);		
        this.txtbatchQty.setSupportedEmpty(true);		
        this.txtbatchQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbatchQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbatchQty.setPrecision(4);		
        this.txtbatchQty.setRequired(false);		
        this.txtbatchQty.setEnabled(false);
        // txttargetBatchQty		
        this.txttargetBatchQty.setVisible(true);		
        this.txttargetBatchQty.setHorizontalAlignment(2);		
        this.txttargetBatchQty.setDataType(1);		
        this.txttargetBatchQty.setSupportedEmpty(true);		
        this.txttargetBatchQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttargetBatchQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttargetBatchQty.setPrecision(4);		
        this.txttargetBatchQty.setRequired(false);		
        this.txttargetBatchQty.setEnabled(false);
        // prmtperson		
        this.prmtperson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtperson.setVisible(true);		
        this.prmtperson.setEditable(true);		
        this.prmtperson.setDisplayFormat("$name$");		
        this.prmtperson.setEditFormat("$number$");		
        this.prmtperson.setCommitFormat("$number$");		
        this.prmtperson.setRequired(false);		
        this.prmtperson.setEnabled(false);
        // prmttargetPerson		
        this.prmttargetPerson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmttargetPerson.setVisible(true);		
        this.prmttargetPerson.setEditable(true);		
        this.prmttargetPerson.setDisplayFormat("$name$");		
        this.prmttargetPerson.setEditFormat("$number$");		
        this.prmttargetPerson.setCommitFormat("$number$");		
        this.prmttargetPerson.setRequired(false);		
        this.prmttargetPerson.setEnabled(false);
        // prmtinCostCenter		
        this.prmtinCostCenter.setQueryInfo("com.kingdee.eas.basedata.org.app.CostCenterItemQuery");		
        this.prmtinCostCenter.setVisible(true);		
        this.prmtinCostCenter.setEditable(true);		
        this.prmtinCostCenter.setDisplayFormat("$name$");		
        this.prmtinCostCenter.setEditFormat("$number$");		
        this.prmtinCostCenter.setCommitFormat("$number$");		
        this.prmtinCostCenter.setRequired(true);
        // prmtoutCostCenter		
        this.prmtoutCostCenter.setQueryInfo("com.kingdee.eas.basedata.org.app.CostCenterItemQuery");		
        this.prmtoutCostCenter.setVisible(true);		
        this.prmtoutCostCenter.setEditable(true);		
        this.prmtoutCostCenter.setDisplayFormat("$name$");		
        this.prmtoutCostCenter.setEditFormat("$number$");		
        this.prmtoutCostCenter.setCommitFormat("$number$");		
        this.prmtoutCostCenter.setRequired(true);
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
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,billStatus,prmtcompany,pkauditTime,prmtstorageOrgUnit,kdtEntrys,prmtfarmer,prmtfarm,prmtbatch,prmttargetFarmer,prmttargetFarm,prmttargetBatchContract,prmttargetBatch,prmtcar,prmtbatchContract,prmtdriver,prmtbreedData,prmttargetBreedData,pkinDate,pktargetIndate,txtbatchQty,txttargetBatchQty,prmtperson,prmttargetPerson,prmtinCostCenter,prmtoutCostCenter}));
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
        this.setBounds(new Rectangle(-24, 3, 1149, 660));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(-24, 3, 1149, 660));
        contCreator.setBounds(new Rectangle(406, 588, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(406, 588, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(814, 589, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(814, 589, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(406, 621, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(406, 621, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(814, 622, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(814, 622, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(18, 10, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(18, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(298, 10, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(298, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(875, 10, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(875, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(26, 588, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(26, 588, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(583, 10, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(583, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompany.setBounds(new Rectangle(18, 41, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(18, 41, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(26, 621, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(26, 621, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator8.setBounds(new Rectangle(15, 581, 1068, 8));
        this.add(kDSeparator8, new KDLayout.Constraints(15, 581, 1068, 8, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator9.setBounds(new Rectangle(5, 223, 1122, 8));
        this.add(kDSeparator9, new KDLayout.Constraints(5, 223, 1122, 8, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kdtEntrys.setBounds(new Rectangle(21, 234, 1081, 338));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.carnivorous.feedbiz.CTransDrugBillEntryInfo(),null,false);
        this.add(kdtEntrys_detailPanel, new KDLayout.Constraints(21, 234, 1081, 338, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contstorageOrgUnit.setBounds(new Rectangle(298, 40, 270, 19));
        this.add(contstorageOrgUnit, new KDLayout.Constraints(298, 40, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmer.setBounds(new Rectangle(18, 71, 270, 19));
        this.add(contfarmer, new KDLayout.Constraints(18, 71, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarm.setBounds(new Rectangle(298, 70, 270, 19));
        this.add(contfarm, new KDLayout.Constraints(298, 70, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbatch.setBounds(new Rectangle(875, 70, 270, 19));
        this.add(contbatch, new KDLayout.Constraints(875, 70, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conttargetFarmer.setBounds(new Rectangle(18, 131, 270, 19));
        this.add(conttargetFarmer, new KDLayout.Constraints(18, 131, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttargetFarm.setBounds(new Rectangle(298, 130, 270, 19));
        this.add(conttargetFarm, new KDLayout.Constraints(298, 130, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttargetBatchContract.setBounds(new Rectangle(583, 132, 270, 19));
        this.add(conttargetBatchContract, new KDLayout.Constraints(583, 132, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttargetBatch.setBounds(new Rectangle(875, 130, 270, 19));
        this.add(conttargetBatch, new KDLayout.Constraints(875, 130, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcar.setBounds(new Rectangle(583, 40, 270, 21));
        this.add(contcar, new KDLayout.Constraints(583, 40, 270, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbatchContract.setBounds(new Rectangle(583, 72, 270, 19));
        this.add(contbatchContract, new KDLayout.Constraints(583, 72, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdriver.setBounds(new Rectangle(875, 40, 270, 19));
        this.add(contdriver, new KDLayout.Constraints(875, 40, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator10.setBounds(new Rectangle(7, 126, 1042, 8));
        this.add(kDSeparator10, new KDLayout.Constraints(7, 126, 1042, 8, 0));
        contbreedData.setBounds(new Rectangle(18, 101, 270, 19));
        this.add(contbreedData, new KDLayout.Constraints(18, 101, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttargetBreedData.setBounds(new Rectangle(18, 163, 270, 19));
        this.add(conttargetBreedData, new KDLayout.Constraints(18, 163, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        continDate.setBounds(new Rectangle(298, 100, 270, 19));
        this.add(continDate, new KDLayout.Constraints(298, 100, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttargetIndate.setBounds(new Rectangle(298, 163, 270, 19));
        this.add(conttargetIndate, new KDLayout.Constraints(298, 163, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbatchQty.setBounds(new Rectangle(583, 102, 270, 19));
        this.add(contbatchQty, new KDLayout.Constraints(583, 102, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttargetBatchQty.setBounds(new Rectangle(583, 163, 270, 19));
        this.add(conttargetBatchQty, new KDLayout.Constraints(583, 163, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contperson.setBounds(new Rectangle(875, 100, 270, 19));
        this.add(contperson, new KDLayout.Constraints(875, 100, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conttargetPerson.setBounds(new Rectangle(875, 163, 270, 19));
        this.add(conttargetPerson, new KDLayout.Constraints(875, 163, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        continCostCenter.setBounds(new Rectangle(18, 197, 270, 19));
        this.add(continCostCenter, new KDLayout.Constraints(18, 197, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoutCostCenter.setBounds(new Rectangle(298, 197, 270, 19));
        this.add(contoutCostCenter, new KDLayout.Constraints(298, 197, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contstorageOrgUnit
        contstorageOrgUnit.setBoundEditor(prmtstorageOrgUnit);
        //contfarmer
        contfarmer.setBoundEditor(prmtfarmer);
        //contfarm
        contfarm.setBoundEditor(prmtfarm);
        //contbatch
        contbatch.setBoundEditor(prmtbatch);
        //conttargetFarmer
        conttargetFarmer.setBoundEditor(prmttargetFarmer);
        //conttargetFarm
        conttargetFarm.setBoundEditor(prmttargetFarm);
        //conttargetBatchContract
        conttargetBatchContract.setBoundEditor(prmttargetBatchContract);
        //conttargetBatch
        conttargetBatch.setBoundEditor(prmttargetBatch);
        //contcar
        contcar.setBoundEditor(prmtcar);
        //contbatchContract
        contbatchContract.setBoundEditor(prmtbatchContract);
        //contdriver
        contdriver.setBoundEditor(prmtdriver);
        //contbreedData
        contbreedData.setBoundEditor(prmtbreedData);
        //conttargetBreedData
        conttargetBreedData.setBoundEditor(prmttargetBreedData);
        //continDate
        continDate.setBoundEditor(pkinDate);
        //conttargetIndate
        conttargetIndate.setBoundEditor(pktargetIndate);
        //contbatchQty
        contbatchQty.setBoundEditor(txtbatchQty);
        //conttargetBatchQty
        conttargetBatchQty.setBoundEditor(txttargetBatchQty);
        //contperson
        contperson.setBoundEditor(prmtperson);
        //conttargetPerson
        conttargetPerson.setBoundEditor(prmttargetPerson);
        //continCostCenter
        continCostCenter.setBoundEditor(prmtinCostCenter);
        //contoutCostCenter
        contoutCostCenter.setBoundEditor(prmtoutCostCenter);

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
        menuBiz.add(MenuItemPCVoucher);
        menuBiz.add(MenuItemVoucher);
        menuBiz.add(menuItemDelPCVoucher);
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
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.carnivorous.feedbiz.CTransDrugBillEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.material", java.lang.Object.class, this.kdtEntrys, "material.text");
		dataBinder.registerBinding("entrys.materialName", String.class, this.kdtEntrys, "materialName.text");
		dataBinder.registerBinding("entrys.model", String.class, this.kdtEntrys, "model.text");
		dataBinder.registerBinding("entrys.warehouse", java.lang.Object.class, this.kdtEntrys, "warehouse.text");
		dataBinder.registerBinding("entrys.transQty", java.math.BigDecimal.class, this.kdtEntrys, "transQty.text");
		dataBinder.registerBinding("entrys.orderWarehouse", java.lang.Object.class, this.kdtEntrys, "orderWarehouse.text");
		dataBinder.registerBinding("entrys.amount", java.math.BigDecimal.class, this.kdtEntrys, "amount.text");
		dataBinder.registerBinding("entrys.basePrice", java.math.BigDecimal.class, this.kdtEntrys, "basePrice.text");
		dataBinder.registerBinding("entrys.orderAmount", java.math.BigDecimal.class, this.kdtEntrys, "orderAmount.text");
		dataBinder.registerBinding("entrys.orderBasePrice", java.math.BigDecimal.class, this.kdtEntrys, "orderBasePrice.text");
		dataBinder.registerBinding("entrys.unit", java.lang.Object.class, this.kdtEntrys, "unit.text");
		dataBinder.registerBinding("entrys.batchLot", String.class, this.kdtEntrys, "batchLot.text");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("storageOrgUnit", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtstorageOrgUnit, "data");
		dataBinder.registerBinding("farmer", com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo.class, this.prmtfarmer, "data");
		dataBinder.registerBinding("farm", com.kingdee.eas.farm.carnivorous.basedata.FarmInfo.class, this.prmtfarm, "data");
		dataBinder.registerBinding("batch", com.kingdee.eas.farm.carnivorous.basedata.BatchInfo.class, this.prmtbatch, "data");
		dataBinder.registerBinding("targetFarmer", com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo.class, this.prmttargetFarmer, "data");
		dataBinder.registerBinding("targetFarm", com.kingdee.eas.farm.carnivorous.basedata.FarmInfo.class, this.prmttargetFarm, "data");
		dataBinder.registerBinding("targetBatchContract", com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo.class, this.prmttargetBatchContract, "data");
		dataBinder.registerBinding("targetBatch", com.kingdee.eas.farm.carnivorous.basedata.BatchInfo.class, this.prmttargetBatch, "data");
		dataBinder.registerBinding("car", com.kingdee.eas.publicdata.CarInfo.class, this.prmtcar, "data");
		dataBinder.registerBinding("batchContract", com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo.class, this.prmtbatchContract, "data");
		dataBinder.registerBinding("driver", com.kingdee.eas.farm.feemanager.basedata.DriverInfo.class, this.prmtdriver, "data");
		dataBinder.registerBinding("breedData", com.kingdee.eas.farm.stocking.basedata.BreedDataInfo.class, this.prmtbreedData, "data");
		dataBinder.registerBinding("targetBreedData", com.kingdee.eas.farm.stocking.basedata.BreedDataInfo.class, this.prmttargetBreedData, "data");
		dataBinder.registerBinding("inDate", java.util.Date.class, this.pkinDate, "value");
		dataBinder.registerBinding("targetIndate", java.util.Date.class, this.pktargetIndate, "value");
		dataBinder.registerBinding("batchQty", java.math.BigDecimal.class, this.txtbatchQty, "value");
		dataBinder.registerBinding("targetBatchQty", java.math.BigDecimal.class, this.txttargetBatchQty, "value");
		dataBinder.registerBinding("person", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtperson, "data");
		dataBinder.registerBinding("targetPerson", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmttargetPerson, "data");
		dataBinder.registerBinding("inCostCenter", com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo.class, this.prmtinCostCenter, "data");
		dataBinder.registerBinding("outCostCenter", com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo.class, this.prmtoutCostCenter, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.carnivorous.feedbiz.app.CTransDrugBillEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.carnivorous.feedbiz.CTransDrugBillInfo)ov;
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
		getValidateHelper().registerBindProperty("entrys.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.materialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.model", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.warehouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.transQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.orderWarehouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.basePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.orderAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.orderBasePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.batchLot", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("storageOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("targetFarmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("targetFarm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("targetBatchContract", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("targetBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("car", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batchContract", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("driver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedData", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("targetBreedData", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("inDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("targetIndate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batchQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("targetBatchQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("person", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("targetPerson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("inCostCenter", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("outCostCenter", ValidateHelper.ON_SAVE);    		
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
     * output kdtEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"materialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"material").getValue(),"name")));

}

    if ("material".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
kdtEntrys.getCell(rowIndex,"model").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntrys.getCell(rowIndex,"material").getValue(),"model")));

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
			sic.add(new SelectorItemInfo("entrys.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.material.id"));
			sic.add(new SelectorItemInfo("entrys.material.number"));
			sic.add(new SelectorItemInfo("entrys.material.name"));
		}
    	sic.add(new SelectorItemInfo("entrys.materialName"));
    	sic.add(new SelectorItemInfo("entrys.model"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.warehouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.warehouse.id"));
			sic.add(new SelectorItemInfo("entrys.warehouse.name"));
        	sic.add(new SelectorItemInfo("entrys.warehouse.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.transQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.orderWarehouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.orderWarehouse.id"));
			sic.add(new SelectorItemInfo("entrys.orderWarehouse.name"));
        	sic.add(new SelectorItemInfo("entrys.orderWarehouse.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.amount"));
    	sic.add(new SelectorItemInfo("entrys.basePrice"));
    	sic.add(new SelectorItemInfo("entrys.orderAmount"));
    	sic.add(new SelectorItemInfo("entrys.orderBasePrice"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.unit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.unit.id"));
			sic.add(new SelectorItemInfo("entrys.unit.name"));
        	sic.add(new SelectorItemInfo("entrys.unit.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.batchLot"));
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
        sic.add(new SelectorItemInfo("billStatus"));
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
			sic.add(new SelectorItemInfo("storageOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("storageOrgUnit.id"));
        	sic.add(new SelectorItemInfo("storageOrgUnit.number"));
        	sic.add(new SelectorItemInfo("storageOrgUnit.name"));
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
			sic.add(new SelectorItemInfo("farm.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farm.id"));
        	sic.add(new SelectorItemInfo("farm.number"));
        	sic.add(new SelectorItemInfo("farm.name"));
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("targetFarmer.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("targetFarmer.id"));
        	sic.add(new SelectorItemInfo("targetFarmer.number"));
        	sic.add(new SelectorItemInfo("targetFarmer.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("targetFarm.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("targetFarm.id"));
        	sic.add(new SelectorItemInfo("targetFarm.number"));
        	sic.add(new SelectorItemInfo("targetFarm.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("targetBatchContract.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("targetBatchContract.id"));
        	sic.add(new SelectorItemInfo("targetBatchContract.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("targetBatch.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("targetBatch.id"));
        	sic.add(new SelectorItemInfo("targetBatch.number"));
        	sic.add(new SelectorItemInfo("targetBatch.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("car.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("car.id"));
        	sic.add(new SelectorItemInfo("car.number"));
        	sic.add(new SelectorItemInfo("car.name"));
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
			sic.add(new SelectorItemInfo("driver.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("driver.id"));
        	sic.add(new SelectorItemInfo("driver.number"));
        	sic.add(new SelectorItemInfo("driver.name"));
        	sic.add(new SelectorItemInfo("driver.drivername"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("breedData.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("breedData.id"));
        	sic.add(new SelectorItemInfo("breedData.number"));
        	sic.add(new SelectorItemInfo("breedData.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("targetBreedData.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("targetBreedData.id"));
        	sic.add(new SelectorItemInfo("targetBreedData.number"));
        	sic.add(new SelectorItemInfo("targetBreedData.name"));
		}
        sic.add(new SelectorItemInfo("inDate"));
        sic.add(new SelectorItemInfo("targetIndate"));
        sic.add(new SelectorItemInfo("batchQty"));
        sic.add(new SelectorItemInfo("targetBatchQty"));
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
			sic.add(new SelectorItemInfo("targetPerson.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("targetPerson.id"));
        	sic.add(new SelectorItemInfo("targetPerson.number"));
        	sic.add(new SelectorItemInfo("targetPerson.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("inCostCenter.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("inCostCenter.id"));
        	sic.add(new SelectorItemInfo("inCostCenter.number"));
        	sic.add(new SelectorItemInfo("inCostCenter.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("outCostCenter.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("outCostCenter.id"));
        	sic.add(new SelectorItemInfo("outCostCenter.number"));
        	sic.add(new SelectorItemInfo("outCostCenter.name"));
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
        com.kingdee.eas.farm.carnivorous.feedbiz.CTransDrugBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.CTransDrugBillFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractCTransDrugBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractCTransDrugBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.feedbiz.client", "CTransDrugBillEditUI");
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
        return com.kingdee.eas.farm.carnivorous.feedbiz.client.CTransDrugBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.feedbiz.CTransDrugBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.CTransDrugBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.feedbiz.CTransDrugBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/carnivorous/feedbiz/CTransDrugBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.carnivorous.feedbiz.app.CTransDrugBillQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"material").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"饲料编码"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"unit").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"计量单位"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"transQty").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"转料数量"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtstorageOrgUnit.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"库存组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtinCostCenter.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"调入成本中心"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtoutCostCenter.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"调出成本中心"});
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
		vo.put("billStatus",new Integer(-1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}