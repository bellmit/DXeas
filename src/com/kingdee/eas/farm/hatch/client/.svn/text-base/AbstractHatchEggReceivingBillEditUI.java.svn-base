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
public abstract class AbstractHatchEggReceivingBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractHatchEggReceivingBillEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contEggSourceType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthatchFactory;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contreceivingLot;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contkczz;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgrendt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contTheEggTable;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contreceivingDate;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDComboBox EggSourceType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmthatchFactory;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtreceivingLot;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtkczz;
    protected com.kingdee.bos.ctrl.swing.KDComboBox grendt;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtTheEggTable;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkreceivingDate;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtGoodsEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtGoodsEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.farm.hatch.HatchEggReceivingBillInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractHatchEggReceivingBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractHatchEggReceivingBillEditUI.class.getName());
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
        this.contEggSourceType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthatchFactory = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contreceivingLot = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contkczz = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgrendt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contTheEggTable = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contreceivingDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.EggSourceType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmthatchFactory = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtreceivingLot = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtkczz = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.grendt = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtTheEggTable = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkreceivingDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtGoodsEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
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
        this.contEggSourceType.setName("contEggSourceType");
        this.conthatchFactory.setName("conthatchFactory");
        this.contauditTime.setName("contauditTime");
        this.contreceivingLot.setName("contreceivingLot");
        this.contbaseStatus.setName("contbaseStatus");
        this.contkczz.setName("contkczz");
        this.contgrendt.setName("contgrendt");
        this.contTheEggTable.setName("contTheEggTable");
        this.contreceivingDate.setName("contreceivingDate");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.EggSourceType.setName("EggSourceType");
        this.prmthatchFactory.setName("prmthatchFactory");
        this.pkauditTime.setName("pkauditTime");
        this.txtreceivingLot.setName("txtreceivingLot");
        this.baseStatus.setName("baseStatus");
        this.prmtkczz.setName("prmtkczz");
        this.grendt.setName("grendt");
        this.prmtTheEggTable.setName("prmtTheEggTable");
        this.pkreceivingDate.setName("pkreceivingDate");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kdtEntrys.setName("kdtEntrys");
        this.kdtGoodsEntrys.setName("kdtGoodsEntrys");
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
        // contEggSourceType		
        this.contEggSourceType.setBoundLabelText(resHelper.getString("contEggSourceType.boundLabelText"));		
        this.contEggSourceType.setBoundLabelLength(100);		
        this.contEggSourceType.setBoundLabelUnderline(true);		
        this.contEggSourceType.setVisible(true);
        // conthatchFactory		
        this.conthatchFactory.setBoundLabelText(resHelper.getString("conthatchFactory.boundLabelText"));		
        this.conthatchFactory.setBoundLabelLength(100);		
        this.conthatchFactory.setBoundLabelUnderline(true);		
        this.conthatchFactory.setVisible(true);
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // contreceivingLot		
        this.contreceivingLot.setBoundLabelText(resHelper.getString("contreceivingLot.boundLabelText"));		
        this.contreceivingLot.setBoundLabelLength(100);		
        this.contreceivingLot.setBoundLabelUnderline(true);		
        this.contreceivingLot.setVisible(false);
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);
        // contkczz		
        this.contkczz.setBoundLabelText(resHelper.getString("contkczz.boundLabelText"));		
        this.contkczz.setBoundLabelLength(100);		
        this.contkczz.setBoundLabelUnderline(true);		
        this.contkczz.setVisible(true);
        // contgrendt		
        this.contgrendt.setBoundLabelText(resHelper.getString("contgrendt.boundLabelText"));		
        this.contgrendt.setBoundLabelLength(100);		
        this.contgrendt.setBoundLabelUnderline(true);		
        this.contgrendt.setVisible(false);
        // contTheEggTable		
        this.contTheEggTable.setBoundLabelText(resHelper.getString("contTheEggTable.boundLabelText"));		
        this.contTheEggTable.setBoundLabelLength(100);		
        this.contTheEggTable.setBoundLabelUnderline(true);		
        this.contTheEggTable.setVisible(true);
        // contreceivingDate		
        this.contreceivingDate.setBoundLabelText(resHelper.getString("contreceivingDate.boundLabelText"));		
        this.contreceivingDate.setBoundLabelLength(100);		
        this.contreceivingDate.setBoundLabelUnderline(true);		
        this.contreceivingDate.setVisible(true);
        // kDTabbedPane1
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
        this.pkBizDate.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    pkBizDate_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // EggSourceType		
        this.EggSourceType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.hatch.EggSourceType").toArray());		
        this.EggSourceType.setRequired(false);		
        this.EggSourceType.setEnabled(false);
        this.EggSourceType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    EggSourceType_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // prmthatchFactory		
        this.prmthatchFactory.setQueryInfo("com.kingdee.eas.farm.hatch.app.HatchBaseDataQuery");		
        this.prmthatchFactory.setEditable(true);		
        this.prmthatchFactory.setDisplayFormat("$name$");		
        this.prmthatchFactory.setEditFormat("$number$");		
        this.prmthatchFactory.setCommitFormat("$number$");		
        this.prmthatchFactory.setRequired(false);
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
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // txtreceivingLot		
        this.txtreceivingLot.setHorizontalAlignment(2);		
        this.txtreceivingLot.setMaxLength(100);		
        this.txtreceivingLot.setRequired(false);		
        this.txtreceivingLot.setVisible(false);
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(false);		
        this.baseStatus.setEnabled(false);
        // prmtkczz		
        this.prmtkczz.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtkczz.setEditable(true);		
        this.prmtkczz.setDisplayFormat("$name$");		
        this.prmtkczz.setEditFormat("$number$");		
        this.prmtkczz.setCommitFormat("$number$");		
        this.prmtkczz.setRequired(false);		
        this.prmtkczz.setEnabled(false);
        // grendt		
        this.grendt.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.hatch.GenderType").toArray());		
        this.grendt.setRequired(false);		
        this.grendt.setEnabled(false);		
        this.grendt.setVisible(false);
        // prmtTheEggTable		
        this.prmtTheEggTable.setQueryInfo("com.kingdee.eas.farm.stocking.processbizill.app.TheEggTableQuery");		
        this.prmtTheEggTable.setEditable(true);		
        this.prmtTheEggTable.setDisplayFormat("$number$");		
        this.prmtTheEggTable.setEditFormat("$number$");		
        this.prmtTheEggTable.setCommitFormat("$number$");		
        this.prmtTheEggTable.setRequired(false);		
        this.prmtTheEggTable.setEnabled(false);
        // pkreceivingDate		
        this.pkreceivingDate.setRequired(false);		
        this.pkreceivingDate.setEnabled(false);
        // kDPanel1
        // kDPanel2
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol1\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol8\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol9\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol10\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol11\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol16\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol17\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol18\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol19\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol20\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol21\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol22\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol23\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol24\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol25\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol26\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol27\"><c:Protection locked=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"stockingFarmer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"stockingFarm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"stockingBatch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"stockingHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"grendType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"supplier\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"internalFarm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"internalBreedingBatch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"henhouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"internalEggBatch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"sendDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"sendQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"dz\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"quaEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"quaSmaallEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"fxd\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /><t:Column t:key=\"weakEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"mutanEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"doubleYolkQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol19\" /><t:Column t:key=\"brokenEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol20\" /><t:Column t:key=\"xpd\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol21\" /><t:Column t:key=\"zd\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol22\" /><t:Column t:key=\"rd\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol23\" /><t:Column t:key=\"otherEggQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol24\" /><t:Column t:key=\"reQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol25\" /><t:Column t:key=\"cys\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol26\" /><t:Column t:key=\"eggWarehouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol27\" /><t:Column t:key=\"description\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{stockingFarmer}</t:Cell><t:Cell>$Resource{stockingFarm}</t:Cell><t:Cell>$Resource{stockingBatch}</t:Cell><t:Cell>$Resource{stockingHouse}</t:Cell><t:Cell>$Resource{grendType}</t:Cell><t:Cell>$Resource{supplier}</t:Cell><t:Cell>$Resource{internalFarm}</t:Cell><t:Cell>$Resource{internalBreedingBatch}</t:Cell><t:Cell>$Resource{henhouse}</t:Cell><t:Cell>$Resource{internalEggBatch}</t:Cell><t:Cell>$Resource{sendDate}</t:Cell><t:Cell>$Resource{sendQty}</t:Cell><t:Cell>$Resource{dz}</t:Cell><t:Cell>$Resource{quaEggQty}</t:Cell><t:Cell>$Resource{quaSmaallEggQty}</t:Cell><t:Cell>$Resource{fxd}</t:Cell><t:Cell>$Resource{weakEggQty}</t:Cell><t:Cell>$Resource{mutanEggQty}</t:Cell><t:Cell>$Resource{doubleYolkQty}</t:Cell><t:Cell>$Resource{brokenEggQty}</t:Cell><t:Cell>$Resource{xpd}</t:Cell><t:Cell>$Resource{zd}</t:Cell><t:Cell>$Resource{rd}</t:Cell><t:Cell>$Resource{otherEggQty}</t:Cell><t:Cell>$Resource{reQty}</t:Cell><t:Cell>$Resource{cys}</t:Cell><t:Cell>$Resource{eggWarehouse}</t:Cell><t:Cell>$Resource{description}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));
        this.kdtEntrys.addKDTEditListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter() {
            public void editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) {
                try {
                    kdtEntrys_editStopped(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });

                this.kdtEntrys.putBindContents("editData",new String[] {"id","stockingFarmer","stockingFarm","stockingBatch","stockingHouse","grendType","supplier","internalFarm","internalBreedingBatch","henhouse","internalEggBatch","sendDate","sendQty","dz","quaEggQty","quaSmaallEggQty","fxd","weakEggQty","mutanEggQty","doubleYolkQty","brokenEggQty","xpd","zd","rd","otherEggQty","reQty","cys","eggWarehouse","description"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_stockingFarmer_PromptBox = new KDBizPromptBox();
        kdtEntrys_stockingFarmer_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmersQuery");
        kdtEntrys_stockingFarmer_PromptBox.setVisible(true);
        kdtEntrys_stockingFarmer_PromptBox.setEditable(true);
        kdtEntrys_stockingFarmer_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_stockingFarmer_PromptBox.setEditFormat("$number$");
        kdtEntrys_stockingFarmer_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_stockingFarmer_CellEditor = new KDTDefaultCellEditor(kdtEntrys_stockingFarmer_PromptBox);
        this.kdtEntrys.getColumn("stockingFarmer").setEditor(kdtEntrys_stockingFarmer_CellEditor);
        ObjectValueRender kdtEntrys_stockingFarmer_OVR = new ObjectValueRender();
        kdtEntrys_stockingFarmer_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("stockingFarmer").setRenderer(kdtEntrys_stockingFarmer_OVR);
        			kdtEntrys_stockingFarmer_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI kdtEntrys_stockingFarmer_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_stockingFarmer_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_stockingFarmer_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_stockingFarmer_PromptBox_F7ListUI));
					kdtEntrys_stockingFarmer_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_stockingFarmer_PromptBox.setSelector(kdtEntrys_stockingFarmer_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEntrys_stockingFarm_PromptBox = new KDBizPromptBox();
        kdtEntrys_stockingFarm_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmQuery");
        kdtEntrys_stockingFarm_PromptBox.setVisible(true);
        kdtEntrys_stockingFarm_PromptBox.setEditable(true);
        kdtEntrys_stockingFarm_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_stockingFarm_PromptBox.setEditFormat("$number$");
        kdtEntrys_stockingFarm_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_stockingFarm_CellEditor = new KDTDefaultCellEditor(kdtEntrys_stockingFarm_PromptBox);
        this.kdtEntrys.getColumn("stockingFarm").setEditor(kdtEntrys_stockingFarm_CellEditor);
        ObjectValueRender kdtEntrys_stockingFarm_OVR = new ObjectValueRender();
        kdtEntrys_stockingFarm_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("stockingFarm").setRenderer(kdtEntrys_stockingFarm_OVR);
        			kdtEntrys_stockingFarm_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmListUI kdtEntrys_stockingFarm_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_stockingFarm_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_stockingFarm_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_stockingFarm_PromptBox_F7ListUI));
					kdtEntrys_stockingFarm_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_stockingFarm_PromptBox.setSelector(kdtEntrys_stockingFarm_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEntrys_stockingBatch_PromptBox = new KDBizPromptBox();
        kdtEntrys_stockingBatch_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.StockingBatchQuery");
        kdtEntrys_stockingBatch_PromptBox.setVisible(true);
        kdtEntrys_stockingBatch_PromptBox.setEditable(true);
        kdtEntrys_stockingBatch_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_stockingBatch_PromptBox.setEditFormat("$number$");
        kdtEntrys_stockingBatch_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_stockingBatch_CellEditor = new KDTDefaultCellEditor(kdtEntrys_stockingBatch_PromptBox);
        this.kdtEntrys.getColumn("stockingBatch").setEditor(kdtEntrys_stockingBatch_CellEditor);
        ObjectValueRender kdtEntrys_stockingBatch_OVR = new ObjectValueRender();
        kdtEntrys_stockingBatch_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("stockingBatch").setRenderer(kdtEntrys_stockingBatch_OVR);
        			kdtEntrys_stockingBatch_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI kdtEntrys_stockingBatch_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_stockingBatch_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_stockingBatch_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_stockingBatch_PromptBox_F7ListUI));
					kdtEntrys_stockingBatch_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_stockingBatch_PromptBox.setSelector(kdtEntrys_stockingBatch_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEntrys_stockingHouse_PromptBox = new KDBizPromptBox();
        kdtEntrys_stockingHouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
        kdtEntrys_stockingHouse_PromptBox.setVisible(true);
        kdtEntrys_stockingHouse_PromptBox.setEditable(true);
        kdtEntrys_stockingHouse_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_stockingHouse_PromptBox.setEditFormat("$number$");
        kdtEntrys_stockingHouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_stockingHouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_stockingHouse_PromptBox);
        this.kdtEntrys.getColumn("stockingHouse").setEditor(kdtEntrys_stockingHouse_CellEditor);
        ObjectValueRender kdtEntrys_stockingHouse_OVR = new ObjectValueRender();
        kdtEntrys_stockingHouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("stockingHouse").setRenderer(kdtEntrys_stockingHouse_OVR);
        KDComboBox kdtEntrys_grendType_ComboBox = new KDComboBox();
        kdtEntrys_grendType_ComboBox.setName("kdtEntrys_grendType_ComboBox");
        kdtEntrys_grendType_ComboBox.setVisible(true);
        kdtEntrys_grendType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.hatch.GenderType").toArray());
        KDTDefaultCellEditor kdtEntrys_grendType_CellEditor = new KDTDefaultCellEditor(kdtEntrys_grendType_ComboBox);
        this.kdtEntrys.getColumn("grendType").setEditor(kdtEntrys_grendType_CellEditor);
        final KDBizPromptBox kdtEntrys_supplier_PromptBox = new KDBizPromptBox();
        kdtEntrys_supplier_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.F7SupplierDefaultQuery");
        kdtEntrys_supplier_PromptBox.setVisible(true);
        kdtEntrys_supplier_PromptBox.setEditable(true);
        kdtEntrys_supplier_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_supplier_PromptBox.setEditFormat("$number$");
        kdtEntrys_supplier_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_supplier_CellEditor = new KDTDefaultCellEditor(kdtEntrys_supplier_PromptBox);
        this.kdtEntrys.getColumn("supplier").setEditor(kdtEntrys_supplier_CellEditor);
        ObjectValueRender kdtEntrys_supplier_OVR = new ObjectValueRender();
        kdtEntrys_supplier_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("supplier").setRenderer(kdtEntrys_supplier_OVR);
        final KDBizPromptBox kdtEntrys_internalFarm_PromptBox = new KDBizPromptBox();
        kdtEntrys_internalFarm_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.F7BreedStoorgSetQuery");
        kdtEntrys_internalFarm_PromptBox.setVisible(true);
        kdtEntrys_internalFarm_PromptBox.setEditable(true);
        kdtEntrys_internalFarm_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_internalFarm_PromptBox.setEditFormat("$number$");
        kdtEntrys_internalFarm_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_internalFarm_CellEditor = new KDTDefaultCellEditor(kdtEntrys_internalFarm_PromptBox);
        this.kdtEntrys.getColumn("internalFarm").setEditor(kdtEntrys_internalFarm_CellEditor);
        ObjectValueRender kdtEntrys_internalFarm_OVR = new ObjectValueRender();
        kdtEntrys_internalFarm_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("internalFarm").setRenderer(kdtEntrys_internalFarm_OVR);
        final KDBizPromptBox kdtEntrys_internalBreedingBatch_PromptBox = new KDBizPromptBox();
        kdtEntrys_internalBreedingBatch_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.BreedBatchF7Query");
        kdtEntrys_internalBreedingBatch_PromptBox.setVisible(true);
        kdtEntrys_internalBreedingBatch_PromptBox.setEditable(true);
        kdtEntrys_internalBreedingBatch_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_internalBreedingBatch_PromptBox.setEditFormat("$number$");
        kdtEntrys_internalBreedingBatch_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_internalBreedingBatch_CellEditor = new KDTDefaultCellEditor(kdtEntrys_internalBreedingBatch_PromptBox);
        this.kdtEntrys.getColumn("internalBreedingBatch").setEditor(kdtEntrys_internalBreedingBatch_CellEditor);
        ObjectValueRender kdtEntrys_internalBreedingBatch_OVR = new ObjectValueRender();
        kdtEntrys_internalBreedingBatch_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntrys.getColumn("internalBreedingBatch").setRenderer(kdtEntrys_internalBreedingBatch_OVR);
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
        final KDBizPromptBox kdtEntrys_internalEggBatch_PromptBox = new KDBizPromptBox();
        kdtEntrys_internalEggBatch_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");
        kdtEntrys_internalEggBatch_PromptBox.setVisible(true);
        kdtEntrys_internalEggBatch_PromptBox.setEditable(true);
        kdtEntrys_internalEggBatch_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_internalEggBatch_PromptBox.setEditFormat("$number$");
        kdtEntrys_internalEggBatch_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_internalEggBatch_CellEditor = new KDTDefaultCellEditor(kdtEntrys_internalEggBatch_PromptBox);
        this.kdtEntrys.getColumn("internalEggBatch").setEditor(kdtEntrys_internalEggBatch_CellEditor);
        ObjectValueRender kdtEntrys_internalEggBatch_OVR = new ObjectValueRender();
        kdtEntrys_internalEggBatch_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("internalEggBatch").setRenderer(kdtEntrys_internalEggBatch_OVR);
        KDDatePicker kdtEntrys_sendDate_DatePicker = new KDDatePicker();
        kdtEntrys_sendDate_DatePicker.setName("kdtEntrys_sendDate_DatePicker");
        kdtEntrys_sendDate_DatePicker.setVisible(true);
        kdtEntrys_sendDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrys_sendDate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_sendDate_DatePicker);
        this.kdtEntrys.getColumn("sendDate").setEditor(kdtEntrys_sendDate_CellEditor);
        KDFormattedTextField kdtEntrys_sendQty_TextField = new KDFormattedTextField();
        kdtEntrys_sendQty_TextField.setName("kdtEntrys_sendQty_TextField");
        kdtEntrys_sendQty_TextField.setVisible(true);
        kdtEntrys_sendQty_TextField.setEditable(true);
        kdtEntrys_sendQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_sendQty_TextField.setDataType(1);
        	kdtEntrys_sendQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_sendQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_sendQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_sendQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_sendQty_TextField);
        this.kdtEntrys.getColumn("sendQty").setEditor(kdtEntrys_sendQty_CellEditor);
        KDFormattedTextField kdtEntrys_dz_TextField = new KDFormattedTextField();
        kdtEntrys_dz_TextField.setName("kdtEntrys_dz_TextField");
        kdtEntrys_dz_TextField.setVisible(true);
        kdtEntrys_dz_TextField.setEditable(true);
        kdtEntrys_dz_TextField.setHorizontalAlignment(2);
        kdtEntrys_dz_TextField.setDataType(1);
        	kdtEntrys_dz_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_dz_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_dz_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_dz_CellEditor = new KDTDefaultCellEditor(kdtEntrys_dz_TextField);
        this.kdtEntrys.getColumn("dz").setEditor(kdtEntrys_dz_CellEditor);
        KDFormattedTextField kdtEntrys_quaEggQty_TextField = new KDFormattedTextField();
        kdtEntrys_quaEggQty_TextField.setName("kdtEntrys_quaEggQty_TextField");
        kdtEntrys_quaEggQty_TextField.setVisible(true);
        kdtEntrys_quaEggQty_TextField.setEditable(true);
        kdtEntrys_quaEggQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_quaEggQty_TextField.setDataType(1);
        	kdtEntrys_quaEggQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_quaEggQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_quaEggQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_quaEggQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_quaEggQty_TextField);
        this.kdtEntrys.getColumn("quaEggQty").setEditor(kdtEntrys_quaEggQty_CellEditor);
        KDFormattedTextField kdtEntrys_quaSmaallEggQty_TextField = new KDFormattedTextField();
        kdtEntrys_quaSmaallEggQty_TextField.setName("kdtEntrys_quaSmaallEggQty_TextField");
        kdtEntrys_quaSmaallEggQty_TextField.setVisible(true);
        kdtEntrys_quaSmaallEggQty_TextField.setEditable(true);
        kdtEntrys_quaSmaallEggQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_quaSmaallEggQty_TextField.setDataType(1);
        	kdtEntrys_quaSmaallEggQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_quaSmaallEggQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_quaSmaallEggQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_quaSmaallEggQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_quaSmaallEggQty_TextField);
        this.kdtEntrys.getColumn("quaSmaallEggQty").setEditor(kdtEntrys_quaSmaallEggQty_CellEditor);
        KDFormattedTextField kdtEntrys_fxd_TextField = new KDFormattedTextField();
        kdtEntrys_fxd_TextField.setName("kdtEntrys_fxd_TextField");
        kdtEntrys_fxd_TextField.setVisible(true);
        kdtEntrys_fxd_TextField.setEditable(true);
        kdtEntrys_fxd_TextField.setHorizontalAlignment(2);
        kdtEntrys_fxd_TextField.setDataType(1);
        	kdtEntrys_fxd_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_fxd_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_fxd_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_fxd_CellEditor = new KDTDefaultCellEditor(kdtEntrys_fxd_TextField);
        this.kdtEntrys.getColumn("fxd").setEditor(kdtEntrys_fxd_CellEditor);
        KDFormattedTextField kdtEntrys_weakEggQty_TextField = new KDFormattedTextField();
        kdtEntrys_weakEggQty_TextField.setName("kdtEntrys_weakEggQty_TextField");
        kdtEntrys_weakEggQty_TextField.setVisible(true);
        kdtEntrys_weakEggQty_TextField.setEditable(true);
        kdtEntrys_weakEggQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_weakEggQty_TextField.setDataType(1);
        	kdtEntrys_weakEggQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_weakEggQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_weakEggQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_weakEggQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_weakEggQty_TextField);
        this.kdtEntrys.getColumn("weakEggQty").setEditor(kdtEntrys_weakEggQty_CellEditor);
        KDFormattedTextField kdtEntrys_mutanEggQty_TextField = new KDFormattedTextField();
        kdtEntrys_mutanEggQty_TextField.setName("kdtEntrys_mutanEggQty_TextField");
        kdtEntrys_mutanEggQty_TextField.setVisible(true);
        kdtEntrys_mutanEggQty_TextField.setEditable(true);
        kdtEntrys_mutanEggQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_mutanEggQty_TextField.setDataType(1);
        	kdtEntrys_mutanEggQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_mutanEggQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_mutanEggQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_mutanEggQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_mutanEggQty_TextField);
        this.kdtEntrys.getColumn("mutanEggQty").setEditor(kdtEntrys_mutanEggQty_CellEditor);
        KDFormattedTextField kdtEntrys_doubleYolkQty_TextField = new KDFormattedTextField();
        kdtEntrys_doubleYolkQty_TextField.setName("kdtEntrys_doubleYolkQty_TextField");
        kdtEntrys_doubleYolkQty_TextField.setVisible(true);
        kdtEntrys_doubleYolkQty_TextField.setEditable(true);
        kdtEntrys_doubleYolkQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_doubleYolkQty_TextField.setDataType(1);
        	kdtEntrys_doubleYolkQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_doubleYolkQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_doubleYolkQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_doubleYolkQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_doubleYolkQty_TextField);
        this.kdtEntrys.getColumn("doubleYolkQty").setEditor(kdtEntrys_doubleYolkQty_CellEditor);
        KDFormattedTextField kdtEntrys_brokenEggQty_TextField = new KDFormattedTextField();
        kdtEntrys_brokenEggQty_TextField.setName("kdtEntrys_brokenEggQty_TextField");
        kdtEntrys_brokenEggQty_TextField.setVisible(true);
        kdtEntrys_brokenEggQty_TextField.setEditable(true);
        kdtEntrys_brokenEggQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_brokenEggQty_TextField.setDataType(1);
        	kdtEntrys_brokenEggQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_brokenEggQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_brokenEggQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_brokenEggQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_brokenEggQty_TextField);
        this.kdtEntrys.getColumn("brokenEggQty").setEditor(kdtEntrys_brokenEggQty_CellEditor);
        KDFormattedTextField kdtEntrys_xpd_TextField = new KDFormattedTextField();
        kdtEntrys_xpd_TextField.setName("kdtEntrys_xpd_TextField");
        kdtEntrys_xpd_TextField.setVisible(true);
        kdtEntrys_xpd_TextField.setEditable(true);
        kdtEntrys_xpd_TextField.setHorizontalAlignment(2);
        kdtEntrys_xpd_TextField.setDataType(1);
        	kdtEntrys_xpd_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_xpd_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_xpd_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_xpd_CellEditor = new KDTDefaultCellEditor(kdtEntrys_xpd_TextField);
        this.kdtEntrys.getColumn("xpd").setEditor(kdtEntrys_xpd_CellEditor);
        KDFormattedTextField kdtEntrys_zd_TextField = new KDFormattedTextField();
        kdtEntrys_zd_TextField.setName("kdtEntrys_zd_TextField");
        kdtEntrys_zd_TextField.setVisible(true);
        kdtEntrys_zd_TextField.setEditable(true);
        kdtEntrys_zd_TextField.setHorizontalAlignment(2);
        kdtEntrys_zd_TextField.setDataType(1);
        	kdtEntrys_zd_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_zd_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_zd_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_zd_CellEditor = new KDTDefaultCellEditor(kdtEntrys_zd_TextField);
        this.kdtEntrys.getColumn("zd").setEditor(kdtEntrys_zd_CellEditor);
        KDFormattedTextField kdtEntrys_rd_TextField = new KDFormattedTextField();
        kdtEntrys_rd_TextField.setName("kdtEntrys_rd_TextField");
        kdtEntrys_rd_TextField.setVisible(true);
        kdtEntrys_rd_TextField.setEditable(true);
        kdtEntrys_rd_TextField.setHorizontalAlignment(2);
        kdtEntrys_rd_TextField.setDataType(1);
        	kdtEntrys_rd_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_rd_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_rd_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_rd_CellEditor = new KDTDefaultCellEditor(kdtEntrys_rd_TextField);
        this.kdtEntrys.getColumn("rd").setEditor(kdtEntrys_rd_CellEditor);
        KDFormattedTextField kdtEntrys_otherEggQty_TextField = new KDFormattedTextField();
        kdtEntrys_otherEggQty_TextField.setName("kdtEntrys_otherEggQty_TextField");
        kdtEntrys_otherEggQty_TextField.setVisible(true);
        kdtEntrys_otherEggQty_TextField.setEditable(true);
        kdtEntrys_otherEggQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_otherEggQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_otherEggQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_otherEggQty_TextField);
        this.kdtEntrys.getColumn("otherEggQty").setEditor(kdtEntrys_otherEggQty_CellEditor);
        KDFormattedTextField kdtEntrys_reQty_TextField = new KDFormattedTextField();
        kdtEntrys_reQty_TextField.setName("kdtEntrys_reQty_TextField");
        kdtEntrys_reQty_TextField.setVisible(true);
        kdtEntrys_reQty_TextField.setEditable(true);
        kdtEntrys_reQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_reQty_TextField.setDataType(1);
        	kdtEntrys_reQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_reQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_reQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_reQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_reQty_TextField);
        this.kdtEntrys.getColumn("reQty").setEditor(kdtEntrys_reQty_CellEditor);
        KDFormattedTextField kdtEntrys_cys_TextField = new KDFormattedTextField();
        kdtEntrys_cys_TextField.setName("kdtEntrys_cys_TextField");
        kdtEntrys_cys_TextField.setVisible(true);
        kdtEntrys_cys_TextField.setEditable(true);
        kdtEntrys_cys_TextField.setHorizontalAlignment(2);
        kdtEntrys_cys_TextField.setDataType(1);
        	kdtEntrys_cys_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_cys_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_cys_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_cys_CellEditor = new KDTDefaultCellEditor(kdtEntrys_cys_TextField);
        this.kdtEntrys.getColumn("cys").setEditor(kdtEntrys_cys_CellEditor);
        final KDBizPromptBox kdtEntrys_eggWarehouse_PromptBox = new KDBizPromptBox();
        kdtEntrys_eggWarehouse_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7AllWarehouseQuery");
        kdtEntrys_eggWarehouse_PromptBox.setVisible(true);
        kdtEntrys_eggWarehouse_PromptBox.setEditable(true);
        kdtEntrys_eggWarehouse_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_eggWarehouse_PromptBox.setEditFormat("$number$");
        kdtEntrys_eggWarehouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_eggWarehouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_eggWarehouse_PromptBox);
        this.kdtEntrys.getColumn("eggWarehouse").setEditor(kdtEntrys_eggWarehouse_CellEditor);
        ObjectValueRender kdtEntrys_eggWarehouse_OVR = new ObjectValueRender();
        kdtEntrys_eggWarehouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("eggWarehouse").setRenderer(kdtEntrys_eggWarehouse_OVR);
        KDTextField kdtEntrys_description_TextField = new KDTextField();
        kdtEntrys_description_TextField.setName("kdtEntrys_description_TextField");
        kdtEntrys_description_TextField.setMaxLength(200);
        KDTDefaultCellEditor kdtEntrys_description_CellEditor = new KDTDefaultCellEditor(kdtEntrys_description_TextField);
        this.kdtEntrys.getColumn("description").setEditor(kdtEntrys_description_CellEditor);
        // kdtGoodsEntrys
		String kdtGoodsEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"stockingFarm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"UnqualifiedEggs\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"brokenEggs\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"lossEggs\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{stockingFarm}</t:Cell><t:Cell>$Resource{UnqualifiedEggs}</t:Cell><t:Cell>$Resource{brokenEggs}</t:Cell><t:Cell>$Resource{lossEggs}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtGoodsEntrys.setFormatXml(resHelper.translateString("kdtGoodsEntrys",kdtGoodsEntrysStrXML));

                this.kdtGoodsEntrys.putBindContents("editData",new String[] {"seq","stockingFarm","UnqualifiedEggs","brokenEggs","lossEggs"});


        this.kdtGoodsEntrys.checkParsed();
        KDFormattedTextField kdtGoodsEntrys_seq_TextField = new KDFormattedTextField();
        kdtGoodsEntrys_seq_TextField.setName("kdtGoodsEntrys_seq_TextField");
        kdtGoodsEntrys_seq_TextField.setVisible(true);
        kdtGoodsEntrys_seq_TextField.setEditable(true);
        kdtGoodsEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtGoodsEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtGoodsEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtGoodsEntrys_seq_TextField);
        this.kdtGoodsEntrys.getColumn("seq").setEditor(kdtGoodsEntrys_seq_CellEditor);
        final KDBizPromptBox kdtGoodsEntrys_stockingFarm_PromptBox = new KDBizPromptBox();
        kdtGoodsEntrys_stockingFarm_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmQuery");
        kdtGoodsEntrys_stockingFarm_PromptBox.setVisible(true);
        kdtGoodsEntrys_stockingFarm_PromptBox.setEditable(true);
        kdtGoodsEntrys_stockingFarm_PromptBox.setDisplayFormat("$number$");
        kdtGoodsEntrys_stockingFarm_PromptBox.setEditFormat("$number$");
        kdtGoodsEntrys_stockingFarm_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtGoodsEntrys_stockingFarm_CellEditor = new KDTDefaultCellEditor(kdtGoodsEntrys_stockingFarm_PromptBox);
        this.kdtGoodsEntrys.getColumn("stockingFarm").setEditor(kdtGoodsEntrys_stockingFarm_CellEditor);
        ObjectValueRender kdtGoodsEntrys_stockingFarm_OVR = new ObjectValueRender();
        kdtGoodsEntrys_stockingFarm_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtGoodsEntrys.getColumn("stockingFarm").setRenderer(kdtGoodsEntrys_stockingFarm_OVR);
        			kdtGoodsEntrys_stockingFarm_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmListUI kdtGoodsEntrys_stockingFarm_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtGoodsEntrys_stockingFarm_PromptBox_F7ListUI == null) {
					try {
						kdtGoodsEntrys_stockingFarm_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtGoodsEntrys_stockingFarm_PromptBox_F7ListUI));
					kdtGoodsEntrys_stockingFarm_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtGoodsEntrys_stockingFarm_PromptBox.setSelector(kdtGoodsEntrys_stockingFarm_PromptBox_F7ListUI);
				}
			}
		});
					
        KDFormattedTextField kdtGoodsEntrys_UnqualifiedEggs_TextField = new KDFormattedTextField();
        kdtGoodsEntrys_UnqualifiedEggs_TextField.setName("kdtGoodsEntrys_UnqualifiedEggs_TextField");
        kdtGoodsEntrys_UnqualifiedEggs_TextField.setVisible(true);
        kdtGoodsEntrys_UnqualifiedEggs_TextField.setEditable(true);
        kdtGoodsEntrys_UnqualifiedEggs_TextField.setHorizontalAlignment(2);
        kdtGoodsEntrys_UnqualifiedEggs_TextField.setDataType(1);
        	kdtGoodsEntrys_UnqualifiedEggs_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtGoodsEntrys_UnqualifiedEggs_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtGoodsEntrys_UnqualifiedEggs_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtGoodsEntrys_UnqualifiedEggs_CellEditor = new KDTDefaultCellEditor(kdtGoodsEntrys_UnqualifiedEggs_TextField);
        this.kdtGoodsEntrys.getColumn("UnqualifiedEggs").setEditor(kdtGoodsEntrys_UnqualifiedEggs_CellEditor);
        KDFormattedTextField kdtGoodsEntrys_brokenEggs_TextField = new KDFormattedTextField();
        kdtGoodsEntrys_brokenEggs_TextField.setName("kdtGoodsEntrys_brokenEggs_TextField");
        kdtGoodsEntrys_brokenEggs_TextField.setVisible(true);
        kdtGoodsEntrys_brokenEggs_TextField.setEditable(true);
        kdtGoodsEntrys_brokenEggs_TextField.setHorizontalAlignment(2);
        kdtGoodsEntrys_brokenEggs_TextField.setDataType(1);
        	kdtGoodsEntrys_brokenEggs_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtGoodsEntrys_brokenEggs_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtGoodsEntrys_brokenEggs_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtGoodsEntrys_brokenEggs_CellEditor = new KDTDefaultCellEditor(kdtGoodsEntrys_brokenEggs_TextField);
        this.kdtGoodsEntrys.getColumn("brokenEggs").setEditor(kdtGoodsEntrys_brokenEggs_CellEditor);
        KDFormattedTextField kdtGoodsEntrys_lossEggs_TextField = new KDFormattedTextField();
        kdtGoodsEntrys_lossEggs_TextField.setName("kdtGoodsEntrys_lossEggs_TextField");
        kdtGoodsEntrys_lossEggs_TextField.setVisible(true);
        kdtGoodsEntrys_lossEggs_TextField.setEditable(true);
        kdtGoodsEntrys_lossEggs_TextField.setHorizontalAlignment(2);
        kdtGoodsEntrys_lossEggs_TextField.setDataType(1);
        	kdtGoodsEntrys_lossEggs_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtGoodsEntrys_lossEggs_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtGoodsEntrys_lossEggs_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtGoodsEntrys_lossEggs_CellEditor = new KDTDefaultCellEditor(kdtGoodsEntrys_lossEggs_TextField);
        this.kdtGoodsEntrys.getColumn("lossEggs").setEditor(kdtGoodsEntrys_lossEggs_CellEditor);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {EggSourceType,prmthatchFactory,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,pkauditTime,txtreceivingLot,baseStatus,prmtkczz,grendt,prmtTheEggTable,pkreceivingDate,kdtEntrys,kdtGoodsEntrys}));
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
        contCreator.setBounds(new Rectangle(21, 570, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(21, 570, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(21, 594, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(21, 594, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(372, 570, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(372, 570, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(372, 594, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(372, 594, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contNumber.setBounds(new Rectangle(14, 15, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(14, 15, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(372, 14, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(372, 14, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(14, 65, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(14, 65, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(716, 570, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(716, 570, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contEggSourceType.setBounds(new Rectangle(731, 15, 270, 19));
        this.add(contEggSourceType, new KDLayout.Constraints(731, 15, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conthatchFactory.setBounds(new Rectangle(372, 39, 270, 19));
        this.add(conthatchFactory, new KDLayout.Constraints(372, 39, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(716, 594, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(716, 594, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contreceivingLot.setBounds(new Rectangle(14, 91, 270, 19));
        this.add(contreceivingLot, new KDLayout.Constraints(14, 91, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbaseStatus.setBounds(new Rectangle(731, 39, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(731, 39, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contkczz.setBounds(new Rectangle(372, 66, 270, 19));
        this.add(contkczz, new KDLayout.Constraints(372, 66, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contgrendt.setBounds(new Rectangle(731, 88, 270, 19));
        this.add(contgrendt, new KDLayout.Constraints(731, 88, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contTheEggTable.setBounds(new Rectangle(731, 66, 270, 19));
        this.add(contTheEggTable, new KDLayout.Constraints(731, 66, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contreceivingDate.setBounds(new Rectangle(14, 39, 270, 19));
        this.add(contreceivingDate, new KDLayout.Constraints(14, 39, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane1.setBounds(new Rectangle(15, 116, 986, 443));
        this.add(kDTabbedPane1, new KDLayout.Constraints(15, 116, 986, 443, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //contEggSourceType
        contEggSourceType.setBoundEditor(EggSourceType);
        //conthatchFactory
        conthatchFactory.setBoundEditor(prmthatchFactory);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contreceivingLot
        contreceivingLot.setBoundEditor(txtreceivingLot);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //contkczz
        contkczz.setBoundEditor(prmtkczz);
        //contgrendt
        contgrendt.setBoundEditor(grendt);
        //contTheEggTable
        contTheEggTable.setBoundEditor(prmtTheEggTable);
        //contreceivingDate
        contreceivingDate.setBoundEditor(pkreceivingDate);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 985, 410));        kdtEntrys.setBounds(new Rectangle(1, 2, 978, 442));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.hatch.HatchEggReceivingBillEntryInfo(),null,false);
        kDPanel1.add(kdtEntrys_detailPanel, new KDLayout.Constraints(1, 2, 978, 442, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 985, 410));        kdtGoodsEntrys.setBounds(new Rectangle(4, 4, 972, 400));
        kdtGoodsEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtGoodsEntrys,new com.kingdee.eas.farm.hatch.HatchEggReceivingBillGoodsEntryInfo(),null,false);
        kDPanel2.add(kdtGoodsEntrys_detailPanel, new KDLayout.Constraints(4, 4, 972, 400, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));

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
		dataBinder.registerBinding("EggSourceType", com.kingdee.eas.farm.hatch.EggSourceType.class, this.EggSourceType, "selectedItem");
		dataBinder.registerBinding("hatchFactory", com.kingdee.eas.farm.hatch.HatchBaseDataInfo.class, this.prmthatchFactory, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("receivingLot", String.class, this.txtreceivingLot, "text");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("kczz", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtkczz, "data");
		dataBinder.registerBinding("grendt", com.kingdee.eas.farm.stocking.hatch.GenderType.class, this.grendt, "selectedItem");
		dataBinder.registerBinding("TheEggTable", com.kingdee.eas.farm.stocking.processbizill.TheEggTableInfo.class, this.prmtTheEggTable, "data");
		dataBinder.registerBinding("receivingDate", java.util.Date.class, this.pkreceivingDate, "value");
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.hatch.HatchEggReceivingBillEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.description", String.class, this.kdtEntrys, "description.text");
		dataBinder.registerBinding("entrys.eggWarehouse", java.lang.Object.class, this.kdtEntrys, "eggWarehouse.text");
		dataBinder.registerBinding("entrys.internalFarm", java.lang.Object.class, this.kdtEntrys, "internalFarm.text");
		dataBinder.registerBinding("entrys.internalBreedingBatch", java.lang.Object.class, this.kdtEntrys, "internalBreedingBatch.text");
		dataBinder.registerBinding("entrys.internalEggBatch", java.lang.Object.class, this.kdtEntrys, "internalEggBatch.text");
		dataBinder.registerBinding("entrys.supplier", java.lang.Object.class, this.kdtEntrys, "supplier.text");
		dataBinder.registerBinding("entrys.otherEggQty", int.class, this.kdtEntrys, "otherEggQty.text");
		dataBinder.registerBinding("entrys.sendDate", java.util.Date.class, this.kdtEntrys, "sendDate.text");
		dataBinder.registerBinding("entrys.henhouse", java.lang.Object.class, this.kdtEntrys, "henhouse.text");
		dataBinder.registerBinding("entrys.stockingFarmer", java.lang.Object.class, this.kdtEntrys, "stockingFarmer.text");
		dataBinder.registerBinding("entrys.stockingFarm", java.lang.Object.class, this.kdtEntrys, "stockingFarm.text");
		dataBinder.registerBinding("entrys.stockingBatch", java.lang.Object.class, this.kdtEntrys, "stockingBatch.text");
		dataBinder.registerBinding("entrys.stockingHouse", java.lang.Object.class, this.kdtEntrys, "stockingHouse.text");
		dataBinder.registerBinding("entrys.grendType", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "grendType.text");
		dataBinder.registerBinding("entrys.zd", java.math.BigDecimal.class, this.kdtEntrys, "zd.text");
		dataBinder.registerBinding("entrys.rd", java.math.BigDecimal.class, this.kdtEntrys, "rd.text");
		dataBinder.registerBinding("entrys.xpd", java.math.BigDecimal.class, this.kdtEntrys, "xpd.text");
		dataBinder.registerBinding("entrys.fxd", java.math.BigDecimal.class, this.kdtEntrys, "fxd.text");
		dataBinder.registerBinding("entrys.reQty", java.math.BigDecimal.class, this.kdtEntrys, "reQty.text");
		dataBinder.registerBinding("entrys.cys", java.math.BigDecimal.class, this.kdtEntrys, "cys.text");
		dataBinder.registerBinding("entrys.sendQty", java.math.BigDecimal.class, this.kdtEntrys, "sendQty.text");
		dataBinder.registerBinding("entrys.quaEggQty", java.math.BigDecimal.class, this.kdtEntrys, "quaEggQty.text");
		dataBinder.registerBinding("entrys.quaSmaallEggQty", java.math.BigDecimal.class, this.kdtEntrys, "quaSmaallEggQty.text");
		dataBinder.registerBinding("entrys.weakEggQty", java.math.BigDecimal.class, this.kdtEntrys, "weakEggQty.text");
		dataBinder.registerBinding("entrys.mutanEggQty", java.math.BigDecimal.class, this.kdtEntrys, "mutanEggQty.text");
		dataBinder.registerBinding("entrys.doubleYolkQty", java.math.BigDecimal.class, this.kdtEntrys, "doubleYolkQty.text");
		dataBinder.registerBinding("entrys.brokenEggQty", java.math.BigDecimal.class, this.kdtEntrys, "brokenEggQty.text");
		dataBinder.registerBinding("entrys.dz", java.math.BigDecimal.class, this.kdtEntrys, "dz.text");
		dataBinder.registerBinding("GoodsEntrys.seq", int.class, this.kdtGoodsEntrys, "seq.text");
		dataBinder.registerBinding("GoodsEntrys", com.kingdee.eas.farm.hatch.HatchEggReceivingBillGoodsEntryInfo.class, this.kdtGoodsEntrys, "userObject");
		dataBinder.registerBinding("GoodsEntrys.stockingFarm", java.lang.Object.class, this.kdtGoodsEntrys, "stockingFarm.text");
		dataBinder.registerBinding("GoodsEntrys.UnqualifiedEggs", java.math.BigDecimal.class, this.kdtGoodsEntrys, "UnqualifiedEggs.text");
		dataBinder.registerBinding("GoodsEntrys.brokenEggs", java.math.BigDecimal.class, this.kdtGoodsEntrys, "brokenEggs.text");
		dataBinder.registerBinding("GoodsEntrys.lossEggs", java.math.BigDecimal.class, this.kdtGoodsEntrys, "lossEggs.text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.hatch.app.HatchEggReceivingBillEditUIHandler";
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
        this.EggSourceType.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.hatch.HatchEggReceivingBillInfo)ov;
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
		getValidateHelper().registerBindProperty("EggSourceType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hatchFactory", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("receivingLot", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("kczz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("grendt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("TheEggTable", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("receivingDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.eggWarehouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.internalFarm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.internalBreedingBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.internalEggBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.supplier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.otherEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sendDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.henhouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.stockingFarmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.stockingFarm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.stockingBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.stockingHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.grendType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.zd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.rd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.xpd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.fxd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.reQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.cys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.sendQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.quaEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.quaSmaallEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.weakEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.mutanEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.doubleYolkQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.brokenEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.dz", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("GoodsEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("GoodsEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("GoodsEntrys.stockingFarm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("GoodsEntrys.UnqualifiedEggs", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("GoodsEntrys.brokenEggs", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("GoodsEntrys.lossEggs", ValidateHelper.ON_SAVE);    		
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
     * output pkBizDate_dataChanged method
     */
    protected void pkBizDate_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output EggSourceType_actionPerformed method
     */
    protected void EggSourceType_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output prmthatchFactory_dataChanged method
     */
    protected void prmthatchFactory_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output kdtEntrys_editStopped method
     */
    protected void kdtEntrys_editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
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
        sic.add(new SelectorItemInfo("EggSourceType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("hatchFactory.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("hatchFactory.id"));
        	sic.add(new SelectorItemInfo("hatchFactory.number"));
        	sic.add(new SelectorItemInfo("hatchFactory.name"));
		}
        sic.add(new SelectorItemInfo("auditTime"));
        sic.add(new SelectorItemInfo("receivingLot"));
        sic.add(new SelectorItemInfo("baseStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("kczz.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("kczz.id"));
        	sic.add(new SelectorItemInfo("kczz.number"));
        	sic.add(new SelectorItemInfo("kczz.name"));
		}
        sic.add(new SelectorItemInfo("grendt"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("TheEggTable.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("TheEggTable.id"));
        	sic.add(new SelectorItemInfo("TheEggTable.number"));
		}
        sic.add(new SelectorItemInfo("receivingDate"));
    	sic.add(new SelectorItemInfo("entrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("entrys.description"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.eggWarehouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.eggWarehouse.id"));
			sic.add(new SelectorItemInfo("entrys.eggWarehouse.name"));
        	sic.add(new SelectorItemInfo("entrys.eggWarehouse.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.internalFarm.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.internalFarm.id"));
			sic.add(new SelectorItemInfo("entrys.internalFarm.name"));
        	sic.add(new SelectorItemInfo("entrys.internalFarm.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.internalBreedingBatch.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.internalBreedingBatch.id"));
			sic.add(new SelectorItemInfo("entrys.internalBreedingBatch.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.internalEggBatch.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.internalEggBatch.id"));
			sic.add(new SelectorItemInfo("entrys.internalEggBatch.name"));
        	sic.add(new SelectorItemInfo("entrys.internalEggBatch.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.supplier.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.supplier.id"));
			sic.add(new SelectorItemInfo("entrys.supplier.name"));
        	sic.add(new SelectorItemInfo("entrys.supplier.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.otherEggQty"));
    	sic.add(new SelectorItemInfo("entrys.sendDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.henhouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.henhouse.id"));
			sic.add(new SelectorItemInfo("entrys.henhouse.name"));
        	sic.add(new SelectorItemInfo("entrys.henhouse.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.stockingFarmer.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.stockingFarmer.id"));
			sic.add(new SelectorItemInfo("entrys.stockingFarmer.name"));
        	sic.add(new SelectorItemInfo("entrys.stockingFarmer.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.stockingFarm.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.stockingFarm.id"));
			sic.add(new SelectorItemInfo("entrys.stockingFarm.name"));
        	sic.add(new SelectorItemInfo("entrys.stockingFarm.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.stockingBatch.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.stockingBatch.id"));
			sic.add(new SelectorItemInfo("entrys.stockingBatch.number"));
			sic.add(new SelectorItemInfo("entrys.stockingBatch.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.stockingHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.stockingHouse.id"));
			sic.add(new SelectorItemInfo("entrys.stockingHouse.name"));
        	sic.add(new SelectorItemInfo("entrys.stockingHouse.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.grendType"));
    	sic.add(new SelectorItemInfo("entrys.zd"));
    	sic.add(new SelectorItemInfo("entrys.rd"));
    	sic.add(new SelectorItemInfo("entrys.xpd"));
    	sic.add(new SelectorItemInfo("entrys.fxd"));
    	sic.add(new SelectorItemInfo("entrys.reQty"));
    	sic.add(new SelectorItemInfo("entrys.cys"));
    	sic.add(new SelectorItemInfo("entrys.sendQty"));
    	sic.add(new SelectorItemInfo("entrys.quaEggQty"));
    	sic.add(new SelectorItemInfo("entrys.quaSmaallEggQty"));
    	sic.add(new SelectorItemInfo("entrys.weakEggQty"));
    	sic.add(new SelectorItemInfo("entrys.mutanEggQty"));
    	sic.add(new SelectorItemInfo("entrys.doubleYolkQty"));
    	sic.add(new SelectorItemInfo("entrys.brokenEggQty"));
    	sic.add(new SelectorItemInfo("entrys.dz"));
    	sic.add(new SelectorItemInfo("GoodsEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("GoodsEntrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("GoodsEntrys.stockingFarm.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("GoodsEntrys.stockingFarm.id"));
			sic.add(new SelectorItemInfo("GoodsEntrys.stockingFarm.name"));
        	sic.add(new SelectorItemInfo("GoodsEntrys.stockingFarm.number"));
		}
    	sic.add(new SelectorItemInfo("GoodsEntrys.UnqualifiedEggs"));
    	sic.add(new SelectorItemInfo("GoodsEntrys.brokenEggs"));
    	sic.add(new SelectorItemInfo("GoodsEntrys.lossEggs"));
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
        com.kingdee.eas.farm.hatch.HatchEggReceivingBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.hatch.HatchEggReceivingBillFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractHatchEggReceivingBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractHatchEggReceivingBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.hatch.client", "HatchEggReceivingBillEditUI");
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
        return com.kingdee.eas.farm.hatch.client.HatchEggReceivingBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.hatch.HatchEggReceivingBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.hatch.HatchEggReceivingBillInfo objectValue = new com.kingdee.eas.farm.hatch.HatchEggReceivingBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/hatch/HatchEggReceivingBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.hatch.app.HatchEggReceivingBillQuery");
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
		vo.put("EggSourceType",new Integer(1));
vo.put("baseStatus",new Integer(-1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}