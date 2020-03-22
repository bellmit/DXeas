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
public abstract class AbstractLiveBirdWgtBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractLiveBirdWgtBillEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcarTimes;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer controadLine;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator9;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperson;
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
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcarTimes;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtroadLine;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpreHouseTare;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpreHouseGross;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpreHouseSuttle;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpreHouseQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpreHouseTare;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpreHouseGross;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpreHouseSuttle;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpreHouseQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdeathQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdeathWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsocialQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsocialWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoverWgtQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoverWgtWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsettleQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaverageWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdeathQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdeathWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsocialQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsocialWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoverWgtQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoverWgtWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsettleQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtaverageWgt;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtSaleEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtSaleEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperson;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.farm.carnivorous.recyclebiz.LiveBirdWgtBillInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractLiveBirdWgtBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractLiveBirdWgtBillEditUI.class.getName());
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
        this.contcarTimes = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.controadLine = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDSeparator9 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contperson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
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
        this.txtcarTimes = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtroadLine = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contpreHouseTare = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpreHouseGross = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpreHouseSuttle = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpreHouseQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtpreHouseTare = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpreHouseGross = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpreHouseSuttle = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpreHouseQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contdeathQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdeathWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsocialQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsocialWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoverWgtQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoverWgtWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsettleQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contaverageWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtdeathQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdeathWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsocialQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsocialWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtoverWgtQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtoverWgtWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsettleQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtaverageWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kdtSaleEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.prmtperson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
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
        this.contcarTimes.setName("contcarTimes");
        this.controadLine.setName("controadLine");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.kDSeparator8.setName("kDSeparator8");
        this.kDSeparator9.setName("kDSeparator9");
        this.contperson.setName("contperson");
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
        this.txtcarTimes.setName("txtcarTimes");
        this.prmtroadLine.setName("prmtroadLine");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel3.setName("kDPanel3");
        this.contpreHouseTare.setName("contpreHouseTare");
        this.contpreHouseGross.setName("contpreHouseGross");
        this.contpreHouseSuttle.setName("contpreHouseSuttle");
        this.contpreHouseQty.setName("contpreHouseQty");
        this.txtpreHouseTare.setName("txtpreHouseTare");
        this.txtpreHouseGross.setName("txtpreHouseGross");
        this.txtpreHouseSuttle.setName("txtpreHouseSuttle");
        this.txtpreHouseQty.setName("txtpreHouseQty");
        this.contdeathQty.setName("contdeathQty");
        this.contdeathWgt.setName("contdeathWgt");
        this.contsocialQty.setName("contsocialQty");
        this.contsocialWgt.setName("contsocialWgt");
        this.contoverWgtQty.setName("contoverWgtQty");
        this.contoverWgtWgt.setName("contoverWgtWgt");
        this.contsettleQty.setName("contsettleQty");
        this.contaverageWgt.setName("contaverageWgt");
        this.txtdeathQty.setName("txtdeathQty");
        this.txtdeathWgt.setName("txtdeathWgt");
        this.txtsocialQty.setName("txtsocialQty");
        this.txtsocialWgt.setName("txtsocialWgt");
        this.txtoverWgtQty.setName("txtoverWgtQty");
        this.txtoverWgtWgt.setName("txtoverWgtWgt");
        this.txtsettleQty.setName("txtsettleQty");
        this.txtaverageWgt.setName("txtaverageWgt");
        this.kdtSaleEntrys.setName("kdtSaleEntrys");
        this.prmtperson.setName("prmtperson");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
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
        // contcarTimes		
        this.contcarTimes.setBoundLabelText(resHelper.getString("contcarTimes.boundLabelText"));		
        this.contcarTimes.setBoundLabelLength(100);		
        this.contcarTimes.setBoundLabelUnderline(true);		
        this.contcarTimes.setVisible(true);
        // controadLine		
        this.controadLine.setBoundLabelText(resHelper.getString("controadLine.boundLabelText"));		
        this.controadLine.setBoundLabelLength(100);		
        this.controadLine.setBoundLabelUnderline(true);		
        this.controadLine.setVisible(true);
        // kDTabbedPane1
        // kDSeparator8
        // kDSeparator9
        // contperson		
        this.contperson.setBoundLabelText(resHelper.getString("contperson.boundLabelText"));		
        this.contperson.setBoundLabelLength(100);		
        this.contperson.setBoundLabelUnderline(true);		
        this.contperson.setVisible(true);
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
        this.pkBizDate.setVisible(true);		
        this.pkBizDate.setEnabled(true);		
        this.pkBizDate.setRequired(true);
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // prmtFICompany		
        this.prmtFICompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery4AsstAcct");		
        this.prmtFICompany.setVisible(true);		
        this.prmtFICompany.setEditable(true);		
        this.prmtFICompany.setDisplayFormat("$name$");		
        this.prmtFICompany.setEditFormat("$number$");		
        this.prmtFICompany.setCommitFormat("$number$");		
        this.prmtFICompany.setRequired(true);
        		setOrgF7(prmtFICompany,com.kingdee.eas.basedata.org.OrgType.getEnum("Company"));
					
        // pkauditTime		
        this.pkauditTime.setVisible(true);		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // prmtfarmer		
        this.prmtfarmer.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerQuery");		
        this.prmtfarmer.setVisible(true);		
        this.prmtfarmer.setEditable(true);		
        this.prmtfarmer.setDisplayFormat("$name$");		
        this.prmtfarmer.setEditFormat("$number$");		
        this.prmtfarmer.setCommitFormat("$number$");		
        this.prmtfarmer.setRequired(true);
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
        this.prmtfarm.setRequired(true);
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
					
        // prmtbatchContract		
        this.prmtbatchContract.setQueryInfo("com.kingdee.eas.farm.carnivorous.feedbiz.app.BatchContractBillQuery");		
        this.prmtbatchContract.setVisible(true);		
        this.prmtbatchContract.setEditable(true);		
        this.prmtbatchContract.setDisplayFormat("$number$");		
        this.prmtbatchContract.setEditFormat("$number$");		
        this.prmtbatchContract.setCommitFormat("$number$");		
        this.prmtbatchContract.setRequired(true);
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
					
        // billStatus		
        this.billStatus.setVisible(true);		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // prmtsettlePolicy		
        this.prmtsettlePolicy.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.SettlePolicyQuery");		
        this.prmtsettlePolicy.setVisible(true);		
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
        this.pkinDate.setVisible(true);		
        this.pkinDate.setRequired(false);		
        this.pkinDate.setEnabled(false);
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
        // txtcarTimes		
        this.txtcarTimes.setVisible(true);		
        this.txtcarTimes.setHorizontalAlignment(2);		
        this.txtcarTimes.setDataType(0);		
        this.txtcarTimes.setSupportedEmpty(true);		
        this.txtcarTimes.setRequired(false);
        // prmtroadLine		
        this.prmtroadLine.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.RoadLineQuery");		
        this.prmtroadLine.setVisible(true);		
        this.prmtroadLine.setEditable(true);		
        this.prmtroadLine.setDisplayFormat("$name$");		
        this.prmtroadLine.setEditFormat("$number$");		
        this.prmtroadLine.setCommitFormat("$number$");		
        this.prmtroadLine.setRequired(false);
        // kDPanel1
        // kDPanel2
        // kDPanel3
        // contpreHouseTare		
        this.contpreHouseTare.setBoundLabelText(resHelper.getString("contpreHouseTare.boundLabelText"));		
        this.contpreHouseTare.setBoundLabelLength(100);		
        this.contpreHouseTare.setBoundLabelUnderline(true);		
        this.contpreHouseTare.setVisible(true);
        // contpreHouseGross		
        this.contpreHouseGross.setBoundLabelText(resHelper.getString("contpreHouseGross.boundLabelText"));		
        this.contpreHouseGross.setBoundLabelLength(100);		
        this.contpreHouseGross.setBoundLabelUnderline(true);		
        this.contpreHouseGross.setVisible(true);
        // contpreHouseSuttle		
        this.contpreHouseSuttle.setBoundLabelText(resHelper.getString("contpreHouseSuttle.boundLabelText"));		
        this.contpreHouseSuttle.setBoundLabelLength(100);		
        this.contpreHouseSuttle.setBoundLabelUnderline(true);		
        this.contpreHouseSuttle.setVisible(true);
        // contpreHouseQty		
        this.contpreHouseQty.setBoundLabelText(resHelper.getString("contpreHouseQty.boundLabelText"));		
        this.contpreHouseQty.setBoundLabelLength(100);		
        this.contpreHouseQty.setBoundLabelUnderline(true);		
        this.contpreHouseQty.setVisible(true);
        // txtpreHouseTare		
        this.txtpreHouseTare.setVisible(true);		
        this.txtpreHouseTare.setHorizontalAlignment(2);		
        this.txtpreHouseTare.setDataType(1);		
        this.txtpreHouseTare.setSupportedEmpty(true);		
        this.txtpreHouseTare.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpreHouseTare.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpreHouseTare.setPrecision(4);		
        this.txtpreHouseTare.setRequired(false);
        // txtpreHouseGross		
        this.txtpreHouseGross.setVisible(true);		
        this.txtpreHouseGross.setHorizontalAlignment(2);		
        this.txtpreHouseGross.setDataType(1);		
        this.txtpreHouseGross.setSupportedEmpty(true);		
        this.txtpreHouseGross.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpreHouseGross.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpreHouseGross.setPrecision(4);		
        this.txtpreHouseGross.setRequired(false);
        // txtpreHouseSuttle		
        this.txtpreHouseSuttle.setVisible(true);		
        this.txtpreHouseSuttle.setHorizontalAlignment(2);		
        this.txtpreHouseSuttle.setDataType(1);		
        this.txtpreHouseSuttle.setSupportedEmpty(true);		
        this.txtpreHouseSuttle.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpreHouseSuttle.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpreHouseSuttle.setPrecision(4);		
        this.txtpreHouseSuttle.setRequired(false);		
        this.txtpreHouseSuttle.setEnabled(false);
        // txtpreHouseQty		
        this.txtpreHouseQty.setVisible(true);		
        this.txtpreHouseQty.setHorizontalAlignment(2);		
        this.txtpreHouseQty.setDataType(0);		
        this.txtpreHouseQty.setSupportedEmpty(true);		
        this.txtpreHouseQty.setRequired(false);
        // contdeathQty		
        this.contdeathQty.setBoundLabelText(resHelper.getString("contdeathQty.boundLabelText"));		
        this.contdeathQty.setBoundLabelLength(100);		
        this.contdeathQty.setBoundLabelUnderline(true);		
        this.contdeathQty.setVisible(true);
        // contdeathWgt		
        this.contdeathWgt.setBoundLabelText(resHelper.getString("contdeathWgt.boundLabelText"));		
        this.contdeathWgt.setBoundLabelLength(100);		
        this.contdeathWgt.setBoundLabelUnderline(true);		
        this.contdeathWgt.setVisible(true);
        // contsocialQty		
        this.contsocialQty.setBoundLabelText(resHelper.getString("contsocialQty.boundLabelText"));		
        this.contsocialQty.setBoundLabelLength(100);		
        this.contsocialQty.setBoundLabelUnderline(true);		
        this.contsocialQty.setVisible(true);
        // contsocialWgt		
        this.contsocialWgt.setBoundLabelText(resHelper.getString("contsocialWgt.boundLabelText"));		
        this.contsocialWgt.setBoundLabelLength(100);		
        this.contsocialWgt.setBoundLabelUnderline(true);		
        this.contsocialWgt.setVisible(true);
        // contoverWgtQty		
        this.contoverWgtQty.setBoundLabelText(resHelper.getString("contoverWgtQty.boundLabelText"));		
        this.contoverWgtQty.setBoundLabelLength(100);		
        this.contoverWgtQty.setBoundLabelUnderline(true);		
        this.contoverWgtQty.setVisible(true);
        // contoverWgtWgt		
        this.contoverWgtWgt.setBoundLabelText(resHelper.getString("contoverWgtWgt.boundLabelText"));		
        this.contoverWgtWgt.setBoundLabelLength(100);		
        this.contoverWgtWgt.setBoundLabelUnderline(true);		
        this.contoverWgtWgt.setVisible(true);
        // contsettleQty		
        this.contsettleQty.setBoundLabelText(resHelper.getString("contsettleQty.boundLabelText"));		
        this.contsettleQty.setBoundLabelLength(100);		
        this.contsettleQty.setBoundLabelUnderline(true);		
        this.contsettleQty.setVisible(true);
        // contaverageWgt		
        this.contaverageWgt.setBoundLabelText(resHelper.getString("contaverageWgt.boundLabelText"));		
        this.contaverageWgt.setBoundLabelLength(100);		
        this.contaverageWgt.setBoundLabelUnderline(true);		
        this.contaverageWgt.setVisible(true);
        // txtdeathQty		
        this.txtdeathQty.setVisible(true);		
        this.txtdeathQty.setHorizontalAlignment(2);		
        this.txtdeathQty.setDataType(0);		
        this.txtdeathQty.setSupportedEmpty(true);		
        this.txtdeathQty.setRequired(false);
        // txtdeathWgt		
        this.txtdeathWgt.setVisible(true);		
        this.txtdeathWgt.setHorizontalAlignment(2);		
        this.txtdeathWgt.setDataType(1);		
        this.txtdeathWgt.setSupportedEmpty(true);		
        this.txtdeathWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdeathWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdeathWgt.setPrecision(4);		
        this.txtdeathWgt.setRequired(false);
        // txtsocialQty		
        this.txtsocialQty.setVisible(true);		
        this.txtsocialQty.setHorizontalAlignment(2);		
        this.txtsocialQty.setDataType(0);		
        this.txtsocialQty.setSupportedEmpty(true);		
        this.txtsocialQty.setRequired(false);
        // txtsocialWgt		
        this.txtsocialWgt.setVisible(true);		
        this.txtsocialWgt.setHorizontalAlignment(2);		
        this.txtsocialWgt.setDataType(1);		
        this.txtsocialWgt.setSupportedEmpty(true);		
        this.txtsocialWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsocialWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsocialWgt.setPrecision(4);		
        this.txtsocialWgt.setRequired(false);
        // txtoverWgtQty		
        this.txtoverWgtQty.setVisible(true);		
        this.txtoverWgtQty.setHorizontalAlignment(2);		
        this.txtoverWgtQty.setDataType(0);		
        this.txtoverWgtQty.setSupportedEmpty(true);		
        this.txtoverWgtQty.setRequired(false);
        // txtoverWgtWgt		
        this.txtoverWgtWgt.setVisible(true);		
        this.txtoverWgtWgt.setHorizontalAlignment(2);		
        this.txtoverWgtWgt.setDataType(1);		
        this.txtoverWgtWgt.setSupportedEmpty(true);		
        this.txtoverWgtWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtoverWgtWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtoverWgtWgt.setPrecision(4);		
        this.txtoverWgtWgt.setRequired(false);
        // txtsettleQty		
        this.txtsettleQty.setVisible(true);		
        this.txtsettleQty.setHorizontalAlignment(2);		
        this.txtsettleQty.setDataType(0);		
        this.txtsettleQty.setSupportedEmpty(true);		
        this.txtsettleQty.setRequired(false);
        // txtaverageWgt		
        this.txtaverageWgt.setVisible(true);		
        this.txtaverageWgt.setHorizontalAlignment(2);		
        this.txtaverageWgt.setDataType(1);		
        this.txtaverageWgt.setSupportedEmpty(true);		
        this.txtaverageWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtaverageWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtaverageWgt.setPrecision(4);		
        this.txtaverageWgt.setRequired(false);		
        this.txtaverageWgt.setEnabled(false);
        // kdtSaleEntrys
		String kdtSaleEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"salebizType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"purchaseOrg\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"customer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"saleWgt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"car\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"driver\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{salebizType}</t:Cell><t:Cell>$Resource{purchaseOrg}</t:Cell><t:Cell>$Resource{customer}</t:Cell><t:Cell>$Resource{saleWgt}</t:Cell><t:Cell>$Resource{car}</t:Cell><t:Cell>$Resource{driver}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtSaleEntrys.setFormatXml(resHelper.translateString("kdtSaleEntrys",kdtSaleEntrysStrXML));

                this.kdtSaleEntrys.putBindContents("editData",new String[] {"seq","salebizType","purchaseOrg","customer","saleWgt","car","driver"});


        this.kdtSaleEntrys.checkParsed();
        KDFormattedTextField kdtSaleEntrys_seq_TextField = new KDFormattedTextField();
        kdtSaleEntrys_seq_TextField.setName("kdtSaleEntrys_seq_TextField");
        kdtSaleEntrys_seq_TextField.setVisible(true);
        kdtSaleEntrys_seq_TextField.setEditable(true);
        kdtSaleEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtSaleEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtSaleEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtSaleEntrys_seq_TextField);
        this.kdtSaleEntrys.getColumn("seq").setEditor(kdtSaleEntrys_seq_CellEditor);
        KDComboBox kdtSaleEntrys_salebizType_ComboBox = new KDComboBox();
        kdtSaleEntrys_salebizType_ComboBox.setName("kdtSaleEntrys_salebizType_ComboBox");
        kdtSaleEntrys_salebizType_ComboBox.setVisible(true);
        kdtSaleEntrys_salebizType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.recyclebiz.SaleBizType").toArray());
        KDTDefaultCellEditor kdtSaleEntrys_salebizType_CellEditor = new KDTDefaultCellEditor(kdtSaleEntrys_salebizType_ComboBox);
        this.kdtSaleEntrys.getColumn("salebizType").setEditor(kdtSaleEntrys_salebizType_CellEditor);
        final KDBizPromptBox kdtSaleEntrys_purchaseOrg_PromptBox = new KDBizPromptBox();
        kdtSaleEntrys_purchaseOrg_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.PurchaseItemQuery");
        kdtSaleEntrys_purchaseOrg_PromptBox.setVisible(true);
        kdtSaleEntrys_purchaseOrg_PromptBox.setEditable(true);
        kdtSaleEntrys_purchaseOrg_PromptBox.setDisplayFormat("$number$");
        kdtSaleEntrys_purchaseOrg_PromptBox.setEditFormat("$number$");
        kdtSaleEntrys_purchaseOrg_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtSaleEntrys_purchaseOrg_CellEditor = new KDTDefaultCellEditor(kdtSaleEntrys_purchaseOrg_PromptBox);
        this.kdtSaleEntrys.getColumn("purchaseOrg").setEditor(kdtSaleEntrys_purchaseOrg_CellEditor);
        ObjectValueRender kdtSaleEntrys_purchaseOrg_OVR = new ObjectValueRender();
        kdtSaleEntrys_purchaseOrg_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtSaleEntrys.getColumn("purchaseOrg").setRenderer(kdtSaleEntrys_purchaseOrg_OVR);
        final KDBizPromptBox kdtSaleEntrys_customer_PromptBox = new KDBizPromptBox();
        kdtSaleEntrys_customer_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.CustomerInfoQuery");
        kdtSaleEntrys_customer_PromptBox.setVisible(true);
        kdtSaleEntrys_customer_PromptBox.setEditable(true);
        kdtSaleEntrys_customer_PromptBox.setDisplayFormat("$number$");
        kdtSaleEntrys_customer_PromptBox.setEditFormat("$number$");
        kdtSaleEntrys_customer_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtSaleEntrys_customer_CellEditor = new KDTDefaultCellEditor(kdtSaleEntrys_customer_PromptBox);
        this.kdtSaleEntrys.getColumn("customer").setEditor(kdtSaleEntrys_customer_CellEditor);
        ObjectValueRender kdtSaleEntrys_customer_OVR = new ObjectValueRender();
        kdtSaleEntrys_customer_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtSaleEntrys.getColumn("customer").setRenderer(kdtSaleEntrys_customer_OVR);
        KDFormattedTextField kdtSaleEntrys_saleWgt_TextField = new KDFormattedTextField();
        kdtSaleEntrys_saleWgt_TextField.setName("kdtSaleEntrys_saleWgt_TextField");
        kdtSaleEntrys_saleWgt_TextField.setVisible(true);
        kdtSaleEntrys_saleWgt_TextField.setEditable(true);
        kdtSaleEntrys_saleWgt_TextField.setHorizontalAlignment(2);
        kdtSaleEntrys_saleWgt_TextField.setDataType(1);
        	kdtSaleEntrys_saleWgt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtSaleEntrys_saleWgt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtSaleEntrys_saleWgt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtSaleEntrys_saleWgt_CellEditor = new KDTDefaultCellEditor(kdtSaleEntrys_saleWgt_TextField);
        this.kdtSaleEntrys.getColumn("saleWgt").setEditor(kdtSaleEntrys_saleWgt_CellEditor);
        final KDBizPromptBox kdtSaleEntrys_car_PromptBox = new KDBizPromptBox();
        kdtSaleEntrys_car_PromptBox.setQueryInfo("com.kingdee.eas.publicdata.app.CarQuery");
        kdtSaleEntrys_car_PromptBox.setVisible(true);
        kdtSaleEntrys_car_PromptBox.setEditable(true);
        kdtSaleEntrys_car_PromptBox.setDisplayFormat("$number$");
        kdtSaleEntrys_car_PromptBox.setEditFormat("$number$");
        kdtSaleEntrys_car_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtSaleEntrys_car_CellEditor = new KDTDefaultCellEditor(kdtSaleEntrys_car_PromptBox);
        this.kdtSaleEntrys.getColumn("car").setEditor(kdtSaleEntrys_car_CellEditor);
        ObjectValueRender kdtSaleEntrys_car_OVR = new ObjectValueRender();
        kdtSaleEntrys_car_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtSaleEntrys.getColumn("car").setRenderer(kdtSaleEntrys_car_OVR);
        			kdtSaleEntrys_car_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.CarListUI kdtSaleEntrys_car_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtSaleEntrys_car_PromptBox_F7ListUI == null) {
					try {
						kdtSaleEntrys_car_PromptBox_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.CarListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtSaleEntrys_car_PromptBox_F7ListUI));
					kdtSaleEntrys_car_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtSaleEntrys_car_PromptBox.setSelector(kdtSaleEntrys_car_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtSaleEntrys_driver_PromptBox = new KDBizPromptBox();
        kdtSaleEntrys_driver_PromptBox.setQueryInfo("com.kingdee.eas.farm.feemanager.basedata.app.DriverQuery");
        kdtSaleEntrys_driver_PromptBox.setVisible(true);
        kdtSaleEntrys_driver_PromptBox.setEditable(true);
        kdtSaleEntrys_driver_PromptBox.setDisplayFormat("$number$");
        kdtSaleEntrys_driver_PromptBox.setEditFormat("$number$");
        kdtSaleEntrys_driver_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtSaleEntrys_driver_CellEditor = new KDTDefaultCellEditor(kdtSaleEntrys_driver_PromptBox);
        this.kdtSaleEntrys.getColumn("driver").setEditor(kdtSaleEntrys_driver_CellEditor);
        ObjectValueRender kdtSaleEntrys_driver_OVR = new ObjectValueRender();
        kdtSaleEntrys_driver_OVR.setFormat(new BizDataFormat("$drivername$"));
        this.kdtSaleEntrys.getColumn("driver").setRenderer(kdtSaleEntrys_driver_OVR);
        			kdtSaleEntrys_driver_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI kdtSaleEntrys_driver_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtSaleEntrys_driver_PromptBox_F7ListUI == null) {
					try {
						kdtSaleEntrys_driver_PromptBox_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtSaleEntrys_driver_PromptBox_F7ListUI));
					kdtSaleEntrys_driver_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtSaleEntrys_driver_PromptBox.setSelector(kdtSaleEntrys_driver_PromptBox_F7ListUI);
				}
			}
		});
					
        // prmtperson		
        this.prmtperson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtperson.setVisible(true);		
        this.prmtperson.setEditable(true);		
        this.prmtperson.setDisplayFormat("$name$");		
        this.prmtperson.setEditFormat("$number$");		
        this.prmtperson.setCommitFormat("$number$");		
        this.prmtperson.setRequired(false);		
        this.prmtperson.setEnabled(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {pkauditTime,prmtfarmer,prmtfarm,prmtbatchContract,prmtbatch,billStatus,prmtsettlePolicy,pkinDate,txtbatchQty,txtcarTimes,prmtroadLine,txtpreHouseTare,txtpreHouseGross,txtpreHouseSuttle,txtpreHouseQty,txtdeathQty,txtdeathWgt,txtsocialQty,txtsocialWgt,txtoverWgtQty,txtoverWgtWgt,txtsettleQty,txtaverageWgt,prmtperson}));
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
        this.setBounds(new Rectangle(-10, 2, 1209, 606));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(-10, 2, 1209, 606));
        contCreator.setBounds(new Rectangle(436, 528, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(436, 528, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(789, 527, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(789, 527, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(435, 560, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(435, 560, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(788, 559, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(788, 559, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(16, 30, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(16, 30, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(324, 30, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(324, 30, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(926, 145, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(926, 145, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(43, 527, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(43, 527, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contFICompany.setBounds(new Rectangle(633, 27, 270, 19));
        this.add(contFICompany, new KDLayout.Constraints(633, 27, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(42, 559, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(42, 559, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmer.setBounds(new Rectangle(16, 68, 270, 19));
        this.add(contfarmer, new KDLayout.Constraints(16, 68, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarm.setBounds(new Rectangle(324, 68, 270, 19));
        this.add(contfarm, new KDLayout.Constraints(324, 68, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbatchContract.setBounds(new Rectangle(633, 66, 270, 19));
        this.add(contbatchContract, new KDLayout.Constraints(633, 66, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbatch.setBounds(new Rectangle(926, 65, 270, 19));
        this.add(contbatch, new KDLayout.Constraints(926, 65, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbillStatus.setBounds(new Rectangle(926, 26, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(926, 26, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contsettlePolicy.setBounds(new Rectangle(16, 106, 270, 19));
        this.add(contsettlePolicy, new KDLayout.Constraints(16, 106, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        continDate.setBounds(new Rectangle(324, 106, 270, 19));
        this.add(continDate, new KDLayout.Constraints(324, 106, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbatchQty.setBounds(new Rectangle(633, 105, 270, 19));
        this.add(contbatchQty, new KDLayout.Constraints(633, 105, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcarTimes.setBounds(new Rectangle(324, 145, 270, 19));
        this.add(contcarTimes, new KDLayout.Constraints(324, 145, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        controadLine.setBounds(new Rectangle(633, 145, 270, 19));
        this.add(controadLine, new KDLayout.Constraints(633, 145, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane1.setBounds(new Rectangle(27, 200, 1142, 294));
        this.add(kDTabbedPane1, new KDLayout.Constraints(27, 200, 1142, 294, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator8.setBounds(new Rectangle(3, 181, 1201, 8));
        this.add(kDSeparator8, new KDLayout.Constraints(3, 181, 1201, 8, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator9.setBounds(new Rectangle(-4, 513, 1202, 8));
        this.add(kDSeparator9, new KDLayout.Constraints(-4, 513, 1202, 8, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contperson.setBounds(new Rectangle(926, 104, 270, 19));
        this.add(contperson, new KDLayout.Constraints(926, 104, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //contcarTimes
        contcarTimes.setBoundEditor(txtcarTimes);
        //controadLine
        controadLine.setBoundEditor(prmtroadLine);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1141, 261));        contpreHouseTare.setBounds(new Rectangle(43, 52, 270, 19));
        kDPanel1.add(contpreHouseTare, new KDLayout.Constraints(43, 52, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpreHouseGross.setBounds(new Rectangle(442, 52, 270, 19));
        kDPanel1.add(contpreHouseGross, new KDLayout.Constraints(442, 52, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpreHouseSuttle.setBounds(new Rectangle(43, 106, 270, 19));
        kDPanel1.add(contpreHouseSuttle, new KDLayout.Constraints(43, 106, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpreHouseQty.setBounds(new Rectangle(442, 106, 270, 19));
        kDPanel1.add(contpreHouseQty, new KDLayout.Constraints(442, 106, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contpreHouseTare
        contpreHouseTare.setBoundEditor(txtpreHouseTare);
        //contpreHouseGross
        contpreHouseGross.setBoundEditor(txtpreHouseGross);
        //contpreHouseSuttle
        contpreHouseSuttle.setBoundEditor(txtpreHouseSuttle);
        //contpreHouseQty
        contpreHouseQty.setBoundEditor(txtpreHouseQty);
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1141, 261));        contdeathQty.setBounds(new Rectangle(27, 42, 270, 19));
        kDPanel2.add(contdeathQty, new KDLayout.Constraints(27, 42, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdeathWgt.setBounds(new Rectangle(339, 42, 270, 19));
        kDPanel2.add(contdeathWgt, new KDLayout.Constraints(339, 42, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsocialQty.setBounds(new Rectangle(27, 83, 270, 19));
        kDPanel2.add(contsocialQty, new KDLayout.Constraints(27, 83, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsocialWgt.setBounds(new Rectangle(339, 83, 270, 19));
        kDPanel2.add(contsocialWgt, new KDLayout.Constraints(339, 83, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoverWgtQty.setBounds(new Rectangle(27, 124, 270, 19));
        kDPanel2.add(contoverWgtQty, new KDLayout.Constraints(27, 124, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoverWgtWgt.setBounds(new Rectangle(339, 124, 270, 19));
        kDPanel2.add(contoverWgtWgt, new KDLayout.Constraints(339, 124, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsettleQty.setBounds(new Rectangle(27, 166, 270, 19));
        kDPanel2.add(contsettleQty, new KDLayout.Constraints(27, 166, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contaverageWgt.setBounds(new Rectangle(339, 166, 270, 19));
        kDPanel2.add(contaverageWgt, new KDLayout.Constraints(339, 166, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contdeathQty
        contdeathQty.setBoundEditor(txtdeathQty);
        //contdeathWgt
        contdeathWgt.setBoundEditor(txtdeathWgt);
        //contsocialQty
        contsocialQty.setBoundEditor(txtsocialQty);
        //contsocialWgt
        contsocialWgt.setBoundEditor(txtsocialWgt);
        //contoverWgtQty
        contoverWgtQty.setBoundEditor(txtoverWgtQty);
        //contoverWgtWgt
        contoverWgtWgt.setBoundEditor(txtoverWgtWgt);
        //contsettleQty
        contsettleQty.setBoundEditor(txtsettleQty);
        //contaverageWgt
        contaverageWgt.setBoundEditor(txtaverageWgt);
        //kDPanel3
        kDPanel3.setLayout(new KDLayout());
        kDPanel3.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1141, 261));        kdtSaleEntrys.setBounds(new Rectangle(3, 3, 1104, 247));
        kdtSaleEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtSaleEntrys,new com.kingdee.eas.farm.carnivorous.recyclebiz.LiveBirdWgtBillSaleEntryInfo(),null,false);
        kDPanel3.add(kdtSaleEntrys_detailPanel, new KDLayout.Constraints(3, 3, 1104, 247, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtSaleEntrys_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("salebizType","0");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //contperson
        contperson.setBoundEditor(prmtperson);

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
		dataBinder.registerBinding("carTimes", int.class, this.txtcarTimes, "value");
		dataBinder.registerBinding("roadLine", com.kingdee.eas.farm.carnivorous.basedata.RoadLineInfo.class, this.prmtroadLine, "data");
		dataBinder.registerBinding("preHouseTare", java.math.BigDecimal.class, this.txtpreHouseTare, "value");
		dataBinder.registerBinding("preHouseGross", java.math.BigDecimal.class, this.txtpreHouseGross, "value");
		dataBinder.registerBinding("preHouseSuttle", java.math.BigDecimal.class, this.txtpreHouseSuttle, "value");
		dataBinder.registerBinding("preHouseQty", int.class, this.txtpreHouseQty, "value");
		dataBinder.registerBinding("deathQty", int.class, this.txtdeathQty, "value");
		dataBinder.registerBinding("deathWgt", java.math.BigDecimal.class, this.txtdeathWgt, "value");
		dataBinder.registerBinding("socialQty", int.class, this.txtsocialQty, "value");
		dataBinder.registerBinding("socialWgt", java.math.BigDecimal.class, this.txtsocialWgt, "value");
		dataBinder.registerBinding("overWgtQty", int.class, this.txtoverWgtQty, "value");
		dataBinder.registerBinding("overWgtWgt", java.math.BigDecimal.class, this.txtoverWgtWgt, "value");
		dataBinder.registerBinding("settleQty", int.class, this.txtsettleQty, "value");
		dataBinder.registerBinding("averageWgt", java.math.BigDecimal.class, this.txtaverageWgt, "value");
		dataBinder.registerBinding("SaleEntrys.seq", int.class, this.kdtSaleEntrys, "seq.text");
		dataBinder.registerBinding("SaleEntrys", com.kingdee.eas.farm.carnivorous.recyclebiz.LiveBirdWgtBillSaleEntryInfo.class, this.kdtSaleEntrys, "userObject");
		dataBinder.registerBinding("SaleEntrys.salebizType", com.kingdee.util.enums.Enum.class, this.kdtSaleEntrys, "salebizType.text");
		dataBinder.registerBinding("SaleEntrys.purchaseOrg", java.lang.Object.class, this.kdtSaleEntrys, "purchaseOrg.text");
		dataBinder.registerBinding("SaleEntrys.customer", java.lang.Object.class, this.kdtSaleEntrys, "customer.text");
		dataBinder.registerBinding("SaleEntrys.saleWgt", java.math.BigDecimal.class, this.kdtSaleEntrys, "saleWgt.text");
		dataBinder.registerBinding("SaleEntrys.car", java.lang.Object.class, this.kdtSaleEntrys, "car.text");
		dataBinder.registerBinding("SaleEntrys.driver", java.lang.Object.class, this.kdtSaleEntrys, "driver.text");
		dataBinder.registerBinding("person", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtperson, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.carnivorous.recyclebiz.app.LiveBirdWgtBillEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.carnivorous.recyclebiz.LiveBirdWgtBillInfo)ov;
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
		getValidateHelper().registerBindProperty("carTimes", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("roadLine", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("preHouseTare", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("preHouseGross", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("preHouseSuttle", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("preHouseQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("deathQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("deathWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("socialQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("socialWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("overWgtQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("overWgtWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("settleQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("averageWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntrys.salebizType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntrys.purchaseOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntrys.customer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntrys.saleWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntrys.car", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntrys.driver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("person", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("carTimes"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("roadLine.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("roadLine.id"));
        	sic.add(new SelectorItemInfo("roadLine.number"));
        	sic.add(new SelectorItemInfo("roadLine.name"));
		}
        sic.add(new SelectorItemInfo("preHouseTare"));
        sic.add(new SelectorItemInfo("preHouseGross"));
        sic.add(new SelectorItemInfo("preHouseSuttle"));
        sic.add(new SelectorItemInfo("preHouseQty"));
        sic.add(new SelectorItemInfo("deathQty"));
        sic.add(new SelectorItemInfo("deathWgt"));
        sic.add(new SelectorItemInfo("socialQty"));
        sic.add(new SelectorItemInfo("socialWgt"));
        sic.add(new SelectorItemInfo("overWgtQty"));
        sic.add(new SelectorItemInfo("overWgtWgt"));
        sic.add(new SelectorItemInfo("settleQty"));
        sic.add(new SelectorItemInfo("averageWgt"));
    	sic.add(new SelectorItemInfo("SaleEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SaleEntrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("SaleEntrys.salebizType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SaleEntrys.purchaseOrg.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("SaleEntrys.purchaseOrg.id"));
			sic.add(new SelectorItemInfo("SaleEntrys.purchaseOrg.name"));
        	sic.add(new SelectorItemInfo("SaleEntrys.purchaseOrg.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SaleEntrys.customer.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("SaleEntrys.customer.id"));
			sic.add(new SelectorItemInfo("SaleEntrys.customer.name"));
        	sic.add(new SelectorItemInfo("SaleEntrys.customer.number"));
		}
    	sic.add(new SelectorItemInfo("SaleEntrys.saleWgt"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SaleEntrys.car.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("SaleEntrys.car.id"));
			sic.add(new SelectorItemInfo("SaleEntrys.car.number"));
			sic.add(new SelectorItemInfo("SaleEntrys.car.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SaleEntrys.driver.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("SaleEntrys.driver.id"));
			sic.add(new SelectorItemInfo("SaleEntrys.driver.drivername"));
			sic.add(new SelectorItemInfo("SaleEntrys.driver.name"));
        	sic.add(new SelectorItemInfo("SaleEntrys.driver.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("person.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("person.id"));
        	sic.add(new SelectorItemInfo("person.number"));
        	sic.add(new SelectorItemInfo("person.name"));
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
        com.kingdee.eas.farm.carnivorous.recyclebiz.LiveBirdWgtBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.recyclebiz.LiveBirdWgtBillFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractLiveBirdWgtBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractLiveBirdWgtBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.recyclebiz.client", "LiveBirdWgtBillEditUI");
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
        return com.kingdee.eas.farm.carnivorous.recyclebiz.client.LiveBirdWgtBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.recyclebiz.LiveBirdWgtBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.recyclebiz.LiveBirdWgtBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.recyclebiz.LiveBirdWgtBillInfo();
				if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")).getBoolean("isBizUnit"))
			objectValue.put("FICompany",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")));
 
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/carnivorous/recyclebiz/LiveBirdWgtBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.carnivorous.recyclebiz.app.LiveBirdWgtBillQuery");
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
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtSaleEntrys;
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